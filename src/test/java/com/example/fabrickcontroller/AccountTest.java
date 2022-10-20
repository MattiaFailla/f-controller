package com.example.fabrickcontroller;


import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AccountTest extends FabrickControllerApplicationTests {

    @Test
    public void testGetBalance() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/f/accounts/14537780/balance")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Api-Key", "")
                .header("Auth-Schema", "S2S")
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testGetAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/f/accounts/14537780")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Api-Key", "")
                .header("Auth-Schema", "S2S")
        ).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testGetTransactions() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/f/accounts/14537780/transactions?fromAccountingDate=2022-10-01&toAccountingDate=2022-10-20")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Api-Key", "")
                .header("Auth-Schema", "S2S")
        ).andExpect(status().isOk()).andDo(print());
    }


}
