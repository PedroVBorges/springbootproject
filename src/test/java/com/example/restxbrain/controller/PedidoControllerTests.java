package com.example.restxbrain.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.restxbrain.model.Pedido;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PedidoControllerTests {
    @Autowired
    private MockMvc mockMvc;
    
    ObjectMapper objectMapper;
    
    @Test
    public void invalidIdToGetOrder() throws Exception {
        this.mockMvc.perform(get("/api/pedidos/0")).andDo(print()).andExpect(status().isNotFound());
    }
    
    @Test public void createOrder() throws Exception {
        Pedido pedido = new Pedido();
        pedido.setAddress("foo address");
        pedido.setClientCode(10);
        pedido.setProductList("1, 2, 3");
        pedido.setTotalValue((long) 900);
        
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pedido);
               
        this.mockMvc.perform(post("/api/pedidos")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json))
                .andExpect(status().isOk());
    }
    
}
