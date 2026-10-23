package src;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
public class DatabaseInitializer {
    @Bean
    CommandLineRunner createDatabaseDirectoryAndSeedInstitution(InstituicaoRepository repository) {
        return args -> {
            Files.createDirectories(Path.of("data"));
            if (!repository.existsByNomeIgnoreCase("PUC Minas")) {
                Instituicao pucMinas = new Instituicao();
                pucMinas.setNome("PUC Minas");
                repository.save(pucMinas);
            }
        };
    }
}
