package com.example.serviceday;

import android.net.Uri;

public class Usuario {


    private static String nome;
    private String sexo;
    private Integer dtnasc;
    private static String telefone;
    private static String estado;
    private static String cidade;
    private static String rua;
    private static String bairro;
    private static Integer cep;
    private static Integer numerocasa;
    private static String email;
    private static String id;
    private static Uri foto;

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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String  getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
