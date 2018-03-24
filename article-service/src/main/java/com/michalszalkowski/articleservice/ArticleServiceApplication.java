package com.michalszalkowski.articleservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class ArticleServiceApplication {

	@Bean
	CommandLineRunner commandLineRunner(ArticleRepository articleRepository) {
		return strings -> {
			Stream.of("Lorem 1", "Lorem  2", "Lorem 3").forEach(title -> articleRepository.save(new Article(title)));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ArticleServiceApplication.class, args);
	}
}

@Entity
class Article {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	public Article() {
	}

	public Article(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}

@RepositoryRestResource
interface ArticleRepository extends JpaRepository<Article, Long> {

	@RestResource(path = "by-title")
	Collection<Article> findByTitle(@Param("title") String title);
}

@RestController
class TestRestController {
	@Value("${message.test:ConfigurationNotAvailable}")
	private String message;

	@RequestMapping("/config")
	public String message() {
		return this.message;
	}


	@RequestMapping("/article/storage")
	public Map articleStorage() {
		RestTemplate restTemplate = new RestTemplate();
		Map json = restTemplate.getForObject("http://storage-service:8080/article", Map.class);
		return json;
	}

}