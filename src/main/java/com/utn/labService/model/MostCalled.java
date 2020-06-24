package com.utn.labService.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Datos de una persona y el número de linea a la cual mas llamadas hizo")
public class MostCalled {

    @ApiModelProperty(notes = "Nombre de la persona realizadora de llamadas")
    private String name;
    @ApiModelProperty(notes = "Apellido de la persona realizadora de llamadas")
    private String lastname;
    @ApiModelProperty(notes = "Numero de linea al que mas llamadas hizo")
    private String mostCalled;

}