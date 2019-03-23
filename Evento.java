package com.social.servicio.actuaria;

public class Evento {
    private String prnombreEvento;
    private String prnombrePonente;
    private int prhoraInicio;
    private int prhoraFin;
    private int prmes;
    private int prdia;

    public Evento(String nombreEvento, String nombrePonente, int horaInicio, int horaFin, int mes, int dia){
        prnombreEvento = nombreEvento;
        prnombrePonente = nombrePonente;
        prhoraInicio = horaInicio;
        prhoraFin = horaFin;
        prmes = mes;
        prdia = dia;
    }

    public String getPrnombreEvento() {
        return prnombreEvento;
    }

    public String getPrnombrePonente() {
        return prnombrePonente;
    }

    public int getPrhoraInicio() {
        return prhoraInicio;
    }

    public int getPrhoraFin() {
        return prhoraFin;
    }

    public int getPrmes() {
        return prmes;
    }

    public int getPrdia() {
        return prdia;
    }
}
