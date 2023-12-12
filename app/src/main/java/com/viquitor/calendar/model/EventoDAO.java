package com.viquitor.calendar.model;

import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    private List<Evento> eventos;

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> obterEventos() {
        return eventos;
    }
}
