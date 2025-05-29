package ar.utn.ba.ddsi.mailing.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Alerta {

    private String ciudad;
    private Double temperaturaCelsius;
    private Integer humedad;
    private String Condicion;
    private Double velocidadVientoKmh;


}
