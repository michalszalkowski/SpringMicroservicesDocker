package com.michalszalkowski.storageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@SpringBootApplication
public class StorageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageServiceApplication.class, args);
	}
}

@Entity
class Storage {

	@Id
	@GeneratedValue
	private Long id;

	private String key;
	private String value;

	public Storage() {
	}

	public Storage(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}

@RestController
class StorageRestController {

	@RequestMapping("/post")
	public Storage post() {
		return new Storage("POST", "6vTeaY8t2vpr7Em3n3zxQTzCbsMBPJvWWTqAwPLXJiYumEXuuXgc3E6nsJtn");
	}

	@RequestMapping("/article")
	public Storage article() {
		return new Storage("ARTICLE", "jh6bAwEfqxKg59wNzV4najTAJda4hGdCUd6qP56eDwjxmXLzcdvZiscCzbB2");
	}

}