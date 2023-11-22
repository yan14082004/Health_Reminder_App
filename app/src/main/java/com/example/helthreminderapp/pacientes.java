package com.example.helthreminderapp;

class Pacientes {
    private Long id;
    private String nome;
    private String nome_remedio;
    private String periodo_remedio;
    private String intervalo_remedio;


    public Pacientes(Long id, String nome, String nome_remedio, String periodo_remedio, String intervalo_remedio) {
        this.id = id;
        this.nome = nome;
        this.nome_remedio = nome_remedio;
        this.periodo_remedio = periodo_remedio;
        this.intervalo_remedio = intervalo_remedio;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNome_remedio() {
        return nome_remedio;
    }

    public String getPeriodo_remedio() {
        return periodo_remedio;
    }


    public String getIntervalo_remedio() {
        return intervalo_remedio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNome_remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public void setPeriodo_remedio(String periodo_remedio) {
        this.periodo_remedio = periodo_remedio;
    }

    public void setIntervalo_remedio(String intervalo_remedio) {
        this.intervalo_remedio = intervalo_remedio;
    }
}
