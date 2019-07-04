/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.state.produto.EstadoProduto;

import javax.persistence.*;


import java.io.Serializable;

/**
 *
 * @author gudeck
 */
@Entity
public class Produto implements Serializable {

    public Produto() {
        // Construtor vazio pra uso do Hibernate
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codProduto;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false, length = 3)
    private String tamanho;

    @ManyToOne
    @JoinColumn(name = "codEstado", nullable = false)
    private EstadoProduto estado;

    @Column(nullable = false)
    private Double valorDiaria;

    @Column(nullable = false)
    private Double valorDanoPermanente;

    @ManyToOne
    @JoinColumn(name = "codCategoria", nullable = false)
    private Categoria categoria;

    @Override
    public String toString() {
        return nome;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public EstadoProduto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProduto estado) {
        this.estado = estado;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Double getValorDanoPermanente() {
        return valorDanoPermanente;
    }

    public void setValorDanoPermanente(Double valorDanoPermanente) {
        this.valorDanoPermanente = valorDanoPermanente;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
