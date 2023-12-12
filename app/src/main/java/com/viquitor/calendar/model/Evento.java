package com.viquitor.calendar.model;
public class Evento {
        private String nome;
        private String cidade;
        private String data;
        private String endereco;
        private String foto;

        // Construtor
        public Evento(String nome, String cidade, String data, String endereco, String foto) {
            this.nome = nome;
            this.cidade = cidade;
            this.data = data;
            this.endereco = endereco;
            this.foto = foto;
        }


}
