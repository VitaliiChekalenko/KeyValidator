package com.chekalenko.ugreen.key.validator.tests;

import com.chekalenko.key.validator.UGreenKeyValditorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = UGreenKeyValditorApplication.class)
@TestPropertySource(properties = {
		"spring.profiles.active=secret",
		"spring.datasource.username=${DB_USERNAME}",
		"spring.datasource.password=${DB_PASSWORD}",
		"spring.datasource.url=${DB_URL}"
})
class UGreenKeyValditorApplicationTests {

	@Test
	void contextLoads() {
	}

}
