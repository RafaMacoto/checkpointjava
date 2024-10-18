package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Corretor {
        private Long id;
        private String nome;
        private String cpf;
        private List<Seguro> segurosVendidos;

        public Corretor(Long id, String nome, String cpf) {
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
            this.segurosVendidos = new ArrayList<>();
        }

        public List<Seguro> getSegurosVendidos() {
            return segurosVendidos;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }
}
