package retoUd6;

import java.util.Date;

public class Jugador {

    private String nombreJugador;
    private String armaJugador;
    private String habitacion;
    private Date hora_de_la_partida;

    public Jugador(String n, String a, String h, Date hora) {

        this.nombreJugador = a;
        this.armaJugador = a;
        this.habitacion = h;
        this.hora_de_la_partida = new Date();

    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getArmaJugador() {
        return armaJugador;
    }

    public void setArmaJugador(String armaJugador) {
        this.armaJugador = armaJugador;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public Date getHora_de_la_partida() {
        return hora_de_la_partida;
    }

    public void setHora_de_la_partida(Date hora_de_la_partida) {
        this.hora_de_la_partida = hora_de_la_partida;
    }

}
