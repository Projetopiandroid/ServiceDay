package com.example.serviceday;

import android.net.Uri;

public class Usuario {


    private String nome;
    private String sexo;
    private Integer dtnasc;
    private Integer telefone;
    private String estado;
    private String cidade;
    private String rua;
    private String bairro;
    private Integer cep;
    private Integer numerocasa;
    private String email;
    private String id;
    private Uri foto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Uri getFoto() {
        return foto;
    }

    public void setFoto(Uri foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Integer dtnasc) {
        this.dtnasc = dtnasc;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getNumerocasa() {
        return numerocasa;
    }

    public void setNumerocasa(Integer numerocasa) {
        this.numerocasa = numerocasa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
