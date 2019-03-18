package md.mmirzaghitov.ms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Controller
public class HealthChecker {

	private static final Logger log = LoggerFactory.getLogger(HealthChecker.class);

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(HealthChecker.class, args);
	}


	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("/test")
	public void testHello() {
		log.info("Test!!!");
	}

	@RequestMapping("/hello")
	public @ResponseBody String sayHi(@RequestParam("name") String name) {
		log.info("Hello, {}", name);
		return "Hello, " + name;
	}

}