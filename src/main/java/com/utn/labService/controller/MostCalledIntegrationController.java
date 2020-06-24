package com.utn.labService.controller;

import com.utn.labService.model.MostCalled;
import com.utn.labService.service.MostCalledIntegrationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/integrations")
public class MostCalledIntegrationController {

    @Autowired
    MostCalledIntegrationService userIntegrationService;
    @ApiOperation(
            value = "Persona mas llamada por usuario de id",
            notes = "Devuelve el nombre y apellido del usuario del id pasado por parametro y el numero al que mas llamadas realizó",
            response = MostCalled.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Se encontró a la persona y su numero mas llamado"),
            @ApiResponse(code = 204, message = "Se encontró a la persona pero no realizó ninguna llamada aun"),
            @ApiResponse(code = 404, message = "No se encontró el id del usuario"),
    })
    @GetMapping("/getMostCalled/{userId}")
    public ResponseEntity<MostCalled> getMostCalled(@ApiParam(value = "Id del usuario que realiza las llamadas")@PathVariable("userId") String userId) {
        return userIntegrationService.getUsers(userId);
    }
}