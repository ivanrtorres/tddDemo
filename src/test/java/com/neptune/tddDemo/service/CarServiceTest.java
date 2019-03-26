package com.neptune.tddDemo.service;

import com.neptune.tddDemo.exception.CarNotFoundException;
import com.neptune.tddDemo.model.Car;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() throws Exception{
        carService=new CarService();
    }

    @Test
    public void getCarDetails_returnCarInfo(){
        given(carRepository.findByName("prius")).willReturn(new Car("prius","hybrid"));
        Car car=carService.getCarDetails("prius");
        assertThat(car.getBrand()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");
    }
    @Test (expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound(){
        given(carRepository.findByName("prius")).willReturn(null);
        carService.getCarDetails("prius");
    }

}