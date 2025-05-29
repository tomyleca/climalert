package ar.utn.ba.ddsi.mailing.models.entities;

import ar.utn.ba.ddsi.mailing.models.repositories.impl.EmailRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
public class Email {
    private Long id;
    private String destinatario;
    private String remitente;
    private String asunto;
    private String contenido;
    private boolean enviado;
    private EmailRepository emailRepository;


    public Email(String destinatario, String remitente, String asunto, String contenido) {
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.asunto = asunto;
        this.contenido = contenido;
        this.enviado = false;
    }

    public static Email of(String destinatario,String remitente,Alerta alerta) {
        String asunto = "Alerta de Clima - Condiciones Extremas";
        String mensaje = String.format(
                "ALERTA: Condiciones climáticas extremas detectadas en %s\n\n" +
                        "Temperatura: %.1f°C\n" +
                        "Humedad: %d%%\n" +
                        "Condición: %s\n" +
                        "Velocidad del viento: %.1f km/h\n\n" +
                        "Se recomienda tomar precauciones.",
                alerta.getCiudad(),
                alerta.getTemperaturaCelsius(),
                alerta.getHumedad(),
                alerta.getCondicion(),
                alerta.getVelocidadVientoKmh()
        );

        return new Email(destinatario, remitente, asunto, mensaje);
    }



    public void enviar() {
        //TODO: Implementación pendiente. Podríamos usar adapters
    }
} 