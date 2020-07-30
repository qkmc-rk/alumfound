package org.whystudio.alumfound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AlumfoundApplication implements ApplicationRunner {

	Logger logger = LoggerFactory.getLogger(AlumfoundApplication.class);

	@Value("${server.port}")
	public int port;

	@Value("${server.servlet.context-path}")
	public String context;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Tomcat服务启动完成: http://{}:{}{}", "localhost", port, context);
		logger.info("Swagger2 API文档: http://{}:{}{}/swagger-ui.html", "localhost", port, context);
	}

	public static void main(String[] args) {
		SpringApplication.run(AlumfoundApplication.class, args);
	}
}
