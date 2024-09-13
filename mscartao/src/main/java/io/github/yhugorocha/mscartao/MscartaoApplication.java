package io.github.yhugorocha.mscartao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MscartaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscartaoApplication.class, args);
	}

}
