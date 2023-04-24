package com.deliverybusiness.controller;


import com.deliverybusiness.model.Restaurant;
import com.deliverybusiness.service.RestaurantServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.reflect.Array.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
@AutoConfigureMockMvc
class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private RestaurantServiceImpl restaurantServiceImpl;
    @Autowired
    protected ObjectMapper objectMapper;
    private Restaurant restoran;
    private Restaurant restoran2;
    private Restaurant restoran3;


    @BeforeEach
    void setup(){
        this.restoran = new Restaurant(1, "Skadarlija", true,
                "Srpska hrana", null );
        this.restoran2 = new Restaurant(2, "Becar", true,
                "Srpska hrana", null );
        this.restoran3 = new Restaurant(1, "Tri sesira", true,
                "Srpska hrana", null );
    }

    @Test
    void getAll() throws Exception {
        List<Restaurant> actualListOfRestaurants = new ArrayList<>();
        actualListOfRestaurants.add(restoran);
        actualListOfRestaurants.add(restoran2);
        actualListOfRestaurants.add(restoran3);
        when(restaurantServiceImpl.findAll()).thenReturn(actualListOfRestaurants);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/restaurant")).andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name", is(restoran.getName())))
                .andExpect(jsonPath("$.[0].isActive", is(true)))
                .andExpect(jsonPath("$.[1].id", is(restoran2.getId())))
                .andExpect(jsonPath("$.[2].name", is("Tri sesira")))
                .andReturn();

        List<Restaurant> expectedListOfRestaurants = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<List<Restaurant>>() {
        });

        assertEquals(actualListOfRestaurants.size(), expectedListOfRestaurants.size());
        assertEquals(actualListOfRestaurants.get(1).getName(), "Becar" );
        assertEquals(actualListOfRestaurants.get(0).getName(), expectedListOfRestaurants.get(0).getName());
    }

    @Test
    void addRestaurant() throws Exception {
        when(restaurantServiceImpl.addRestaurant(any())).thenReturn(this.restoran);
        MvcResult result = mvc.perform(post("/restaurant").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(this.restoran))).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(restoran.getName())))
                .andExpect(jsonPath("$.description", is(restoran.getDescription())))
                .andReturn();
       Restaurant results = objectMapper.readValue(result.getResponse().getContentAsByteArray(), Restaurant.class);
       assertEquals(this.restoran.getName(), results.getName());
    }

    @Test
    void findByName() {
    }

    @Test
    void deleteRestaurant() {
    }

    @Test
    void updateRestaurant() {
    }

    @Test
    void findByIsActiveTrue() {
    }
}