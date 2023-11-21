package com.example.helthreminderapp;

public class Pacientes {
    private long id;
    private String nome;
    private String historico;
    private String nome_medicamento;
    private Float quantidade_medicamento;
    private Integer periodo_medicamento;
    private Integer intervalo_medicamento;

    public Pacientes(long id, String nome, String historico, String nome_medicamento, Float quantidade_medicamento, Integer periodo_medicamento, Integer intervalo_medicamento) {
        this.id = id;
        this.nome = nome;
        this.historico = historico;
        this.nome_medicamento = nome_medicamento;
        this.quantidade_medicamento = quantidade_medicamento;
        this.periodo_medicamento = periodo_medicamento;
        this.intervalo_medicamento = intervalo_medicamento;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getHistorico() {
        return historico;
    }

    public String getNome_medicamento() {
        return nome_medicamento;
    }

    public Float getQuantidade_medicamento() {
        return quantidade_medicamento;
    }

    public Integer getPeriodo_medicamento() {
        return periodo_medicamento;
    }

    public Integer getIntervalo_medicamento() {
        return intervalo_medicamento;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public void setNome_medicamento(String nome_medicamento) {
        this.nome_medicamento = nome_medicamento;
    }

    public void setQuantidade_medicamento(Float quantidade_medicamento) {
        this.quantidade_medicamento = quantidade_medicamento;
    }

    public void setPeriodo_medicamento(Integer periodo_medicamento) {
        this.periodo_medicamento = periodo_medicamento;
    }

    public void setIntervalo_medicamento(Integer intervalo_medicamento) {
        this.intervalo_medicamento = intervalo_medicamento;
    }
}
