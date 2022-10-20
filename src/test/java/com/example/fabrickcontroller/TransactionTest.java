package com.example.fabrickcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TransactionTest extends FabrickControllerApplicationTests {

    private final String txRequestPayload = """
            {
              "creditor": {
                "name": "John Doe",
                "account": {
                  "accountCode": "IT23A0336844430152923804660",
                  "bicCode": "SELBIT2BXXX"
                },
                "address": {
                  "address": null,
                  "city": null,
                  "countryCode": null
                }
              },
              "executionDate": "2019-04-01",
              "uri": "REMITTANCE_INFORMATION",
              "description": "Payment invoice 75/2017",
              "amount": 800,
              "currency": "EUR",
              "isUrgent": false,
              "isInstant": false,
              "feeType": "SHA",
              "feeAccountId": "45685475",
              "taxRelief": {
                "taxReliefId": "L449",
                "isCondoUpgrade": false,
                "creditorFiscalCode": "56258745832",
                "beneficiaryType": "NATURAL_PERSON",
                "naturalPersonBeneficiary": {
                  "fiscalCode1": "MRLFNC81L04A859L",
                  "fiscalCode2": null,
                  "fiscalCode3": null,
                  "fiscalCode4": null,
                  "fiscalCode5": null
                },
                "legalPersonBeneficiary": {
                  "fiscalCode": null,
                  "legalRepresentativeFiscalCode": null
                }
              }
            }
            """;

    private final String expectedTxJsonResponse = """
            {
              "status": "KO",
              "errors": [
                {
                  "code": "API000",
                  "description": "it.sella.pagamenti.servizibonifico.exception.ServiziInvioBonificoSubsystemException: it.sella.pagamenti.sottosistemi.SottosistemiException: Errore tecnico CONTO 45685475:Conto 45685475 non esiste",
                  "params": ""
                }
              ],
              "payload": {}
            }
            """;

    @Test
    public void testTriggerTransaction() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/f/transactions/14537780/create-transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Api-Key", "")
                        .header("Auth-Schema", "S2S")
                        .content(txRequestPayload)
                )
                .andExpect(status().is5xxServerError())
                .andDo(print())
                .andExpect(content().json(expectedTxJsonResponse))
                .andDo(print());
    }
}
