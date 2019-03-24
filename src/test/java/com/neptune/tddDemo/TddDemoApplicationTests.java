package com.neptune.tddDemo;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.neptune.tddDemo.model.Car;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TddDemoApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getCar_returnsCarDetails() throws Exception {
		//arrange
		
		//action
		ResponseEntity<Car> response=restTemplate.getForEntity("/cars/prius", Car.class);
		//assert
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.SC_OK);
		Assertions.assertThat(response.getBody().getBrand()).isEqualTo("Mercedes");
		Assertions.assertThat(response.getBody().getType()).isEqualTo("Hibrid");
		
	}

}
