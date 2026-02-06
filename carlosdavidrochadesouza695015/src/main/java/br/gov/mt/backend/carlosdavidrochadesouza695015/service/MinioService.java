package br.gov.mt.backend.carlosdavidrochadesouza695015.service;

import io.minio.GetPresignedObjectUrlArgs; // O nome correto termina com 'Args'
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MinioService {

    private final String bucketName = "albuns-capas";
    private final MinioClient minioClient = MinioClient.builder()
            .endpoint("http://localhost:9000")
            .credentials("carlos_admin", "carlos_senha") // Alinhado com seu compose.yaml
            .build();

    public String uploadFile(MultipartFile file) throws Exception {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build()
        );

        // Gera um link temporário (Requisito Sênior de visualização de mídia)
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder() // Ajustado para GetPresignedObjectUrlArgs
                        .method(Method.GET)
                        .bucket(bucketName)
                        .object(fileName)
                        .expiry(60 * 60) // 1 hora
                        .build()
        );
    }
}