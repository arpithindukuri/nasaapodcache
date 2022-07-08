package com.d1dev.nasaapodcache;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.d1dev.nasaapodcache.utils.FileUtils;

@SpringBootApplication
@EnableScheduling
public class NasaapodcacheApplication {

	@Value("${apiUrl}")
	private String apiUrl;

	@Value("${apiKey}")
	private String apiKey;

	private static final Logger log = LoggerFactory.getLogger(NasaapodcacheApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NasaapodcacheApplication.class, args);
	}

	@Scheduled(initialDelay = 0, fixedRate = 1 * 60 * 60 * 3)
	public void checkApi() {
		RestTemplate restTemplate = new RestTemplate();
		APODResponse res = restTemplate.getForObject(
				apiUrl + apiKey, APODResponse.class);
		try {
			FileUtils.saveImage(res.getUrl(), "image.jpg");
			log.info("Saved: " + res.toString());
		} catch (IOException e) {
			log.error("Could Not Save Response: " + res.toString());
			e.printStackTrace();
		}
	}
}
