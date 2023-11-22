package com.example.pupfeeder;

public class Pacientes {
    private Long id;
    private String nome;
    private String nome_medicamento;
    private String periodo_medicamento;
    private String intervalo_medicamento;

    public Pacientes(Long id, String nome, String nome_medicamento, String periodo_medicamento, String intervalo_medicamento) {
        this.id = id;
        this.nome = nome;
        this.nome_medicamento = nome_medicamento;
        this.periodo_medicamento = periodo_medicamento;
        this.intervalo_medicamento = intervalo_medicamento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNome_medicamento() {
        return nome_medicamento;
    }

    public String getPeriodo_medicamento() {
        return periodo_medicamento;
    }

    public String getIntervalo_medicamento() {
        return intervalo_medicamento;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNome_medicamento(String nome_medicamento) {
        this.nome_medicamento = nome_medicamento;
    }

    public void setPeriodo_medicamento(String periodo_medicamento) {
        this.periodo_medicamento = periodo_medicamento;
    }

    public void setIntervalo_medicamento(String intervalo_medicamento) {
        this.intervalo_medicamento = intervalo_medicamento;
    }
}
