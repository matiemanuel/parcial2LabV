package com.utn.labService;


import com.utn.labService.controller.MostCalledIntegrationController;
import com.utn.labService.model.MostCalled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.junit.Assert.assertEquals;

@SpringBootTest
class LabServiceApplicationTests {

    @Autowired
    MostCalledIntegrationController mostCalledIntegrationController;

    @Test
    public void mostCalledOkTest(){
        ResponseEntity<MostCalled> mostCalled = mostCalledIntegrationController.getMostCalled("1");
        assertEquals(SC_OK, mostCalled.getStatusCodeValue());

        ResponseEntity<MostCalled> mostCalledNotFound = mostCalledIntegrationController.getMostCalled("2");
        assertEquals(SC_NOT_FOUND, mostCalledNotFound.getStatusCodeValue());

    }

}
