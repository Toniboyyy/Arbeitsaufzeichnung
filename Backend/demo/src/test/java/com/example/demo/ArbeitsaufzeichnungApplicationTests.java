package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.apache.catalina.connector.Response;
import org.assertj.core.util.Strings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration-test")
public abstract class ArbeitsaufzeichnungApplicationTests {



		private static final String SERVER_HOST = "http://localhost";
		private static final String USER_USERNAME = "user";
		private static final String USER_PASSWORD = "password";
		private static final String ADMIN_PASSWORD = "password";
		private static final String ADMIN_USERNAME = "admin";

		@Value("${server.context-path}")
		private String contextPath;

		@LocalServerPort
		private int port;


		protected String validUserTokenWithPrefix;
		protected String validAdminTokenWithPrefix;

		@Before
		public void beforeBase() {
			RestAssured.baseURI = SERVER_HOST;
			RestAssured.basePath = contextPath;
			RestAssured.port = port;
		}


}
