package com.neptune.tddDemo;

import com.neptune.tddDemo.controller.CarController;
import com.neptune.tddDemo.exception.CarNotFoundException;
import com.neptune.tddDemo.model.Car;
import com.neptune.tddDemo.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CarService carService;

    @Test
    public void getCar_ShouldReturnCar() throws Exception{
        given(carService.getCarDetails(anyString())).willReturn(new Car("mercedes","hybrid"));
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("brand").value("mercedes"))
                .andExpect(jsonPath("type").value("hybrid"));
    }

    @Test
    public void getCar_notFound() throws Exception{
        given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
                .andExpect(status().isNotFound());
    }
}
