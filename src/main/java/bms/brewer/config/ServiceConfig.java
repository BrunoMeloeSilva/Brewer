package bms.brewer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import bms.brewer.service.CervejasService;
import bms.brewer.storage.FotoStorage;
import bms.brewer.storage.local.FotoStorageLocal;


@Configuration
@ComponentScan(basePackageClasses = CervejasService.class)
public class ServiceConfig {

	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}
	
}