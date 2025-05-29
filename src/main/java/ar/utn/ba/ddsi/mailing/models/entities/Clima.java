package ar.utn.ba.ddsi.mailing.models.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;



@Getter
@Setter
public class Clima {
    private Long id;
    private String ciudad;
    private String region;
    private String pais;
    private Double temperaturaCelsius;
    private Double temperaturaFahrenheit;
    private String condicion;
    private Double velocidadVientoKmh;
    private Integer humedad;
    private LocalDateTime fechaActualizacion;
    private boolean procesado;
    private static final double TEMPERATURA_ALERTA = 35.0;
    private static final int HUMEDAD_ALERTA = 60;

    public Clima() {
        this.fechaActualizacion = LocalDateTime.now();
        this.procesado = false;
    }

    public boolean cumpleCondicionesDeAlerta() {
        return this.temperaturaCelsius > TEMPERATURA_ALERTA &&
                this.humedad> HUMEDAD_ALERTA;
    }

    public Alerta revisarSiHayQueGenerarAlerta() {
        if(this.cumpleCondicionesDeAlerta())
            return new Alerta(ciudad,temperaturaCelsius,humedad,condicion,velocidadVientoKmh);
        else
            return null;



    }
}