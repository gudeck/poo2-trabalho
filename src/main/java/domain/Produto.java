/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.state.produto.EstadoProduto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author gudeck
 */
@Entity
public class Produto implements Serializable {

    public Produto() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codProduto;

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

    @Column(nullable = false)
    private boolean danoPermanente;

    @ManyToOne
    @JoinColumn(name = "codCategoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "chaveComposta.produto")
    List<ProdutoAlugado> listaProdutosAlugados = new ArrayList<>();

    @OneToMany(mappedBy = "produto")
    List<Manutencao> listaManutencao = new ArrayList<>();

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

    public boolean getDanoPermanente() {
        return danoPermanente;
    }

    public void setDanoPermanente(Boolean danoPermanente) {
        this.danoPermanente = danoPermanente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<ProdutoAlugado> getListaProdutosAlugados() {
        return listaProdutosAlugados;
    }

    public void setListaProdutosAlugados(List<ProdutoAlugado> listaProdutosAlugados) {
        this.listaProdutosAlugados = listaProdutosAlugados;
    }

    public List<Manutencao> getListaManutencao() {
        return listaManutencao;
    }

    public void setListaManutencao(List<Manutencao> listaManutencao) {
        this.listaManutencao = listaManutencao;
    }

}
