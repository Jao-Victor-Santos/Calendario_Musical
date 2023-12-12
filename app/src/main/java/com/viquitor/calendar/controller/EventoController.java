package com.viquitor.calendar.controller;

import com.viquitor.calendar.model.EventoDAO;
import com.viquitor.calendar.model.Evento;

import java.util.List;

public class EventoController {
    private EventoDAO eventoDAO;

    public EventoController() {
        this.eventoDAO = new EventoDAO();
    }

    public void adicionarEvento(String nome, String cidade, String data, String endereco, String foto) {
        Evento evento = new Evento(nome, cidade, data, endereco, foto);
        eventoDAO.adicionarEvento(evento);
    }

    public List<Evento> obterEventos() {
        return eventoDAO.obterEventos();
    }

    // Implemente métodos adicionais do controlador conforme necessário.
}
