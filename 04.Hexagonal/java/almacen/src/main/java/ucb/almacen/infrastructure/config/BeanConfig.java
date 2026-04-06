package ucb.almacen.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ucb.almacen.application.ArticuloUseCase;
import ucb.almacen.application.ArticuloUseCaseImpl;
import ucb.almacen.domain.ArticuloRepositoryPort;
import ucb.almacen.infrastructure.ArticuloRepositoryAdapter;

@Configuration
public class BeanConfig {

    @Bean
    public ArticuloRepositoryPort articuloRepositoryPort() {
        return new ArticuloRepositoryAdapter();
    }

    @Bean
    public ArticuloUseCase articuloUseCase(ArticuloRepositoryPort articuloRepositoryPort) {
        return new ArticuloUseCaseImpl(articuloRepositoryPort);
    }
}
