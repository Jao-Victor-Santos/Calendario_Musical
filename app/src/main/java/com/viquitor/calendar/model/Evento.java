package com.viquitor.calendar.model;
public class Evento {
        private String nome;
        private String cidade;
        private String endereco;
        private String comum;
        private String data;
        private String horario;
        private String foto;


        // Construtor

    public Evento(String nome, String cidade, String endereco, String comum, String data, String horario, String foto) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
        this.comum = comum;
        this.data = data;
        this.horario = horario;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComum() {
        return comum;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getFoto() {
        return foto;
    }
}
