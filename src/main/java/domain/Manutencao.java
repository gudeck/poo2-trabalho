/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author gudeck
 */
@Entity
class Manutencao implements Serializable {

    public Manutencao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codManutencao;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date dataIdaManutencao;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date dataVoltaManutencao;

    @Column(nullable = false)
    String descricaoManutencao;

    @ManyToOne
    @JoinColumn(name = "codProduto")
    Produto produto;

    @OneToOne(mappedBy = "manutencao")
    ProdutoAlugado produtoAlugado;

    public Integer getCodManutencao() {
        return codManutencao;
    }

    public void setCodManutencao(Integer codManutencao) {
        this.codManutencao = codManutencao;
    }

    public Date getDataIdaManutencao() {
        return dataIdaManutencao;
    }

    public void setDataIdaManutencao(Date dataIdaManutencao) {
        this.dataIdaManutencao = dataIdaManutencao;
    }

    public Date getDataVoltaManutencao() {
        return dataVoltaManutencao;
    }

    public void setDataVoltaManutencao(Date dataVoltaManutencao) {
        this.dataVoltaManutencao = dataVoltaManutencao;
    }

    public String getDescricaoManutencao() {
        return descricaoManutencao;
    }

    public void setDescricaoManutencao(String descricaoManutencao) {
        this.descricaoManutencao = descricaoManutencao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutoAlugado getProdutoAlugado() {
        return produtoAlugado;
    }

    public void setProdutoAlugado(ProdutoAlugado produtoAlugado) {
        this.produtoAlugado = produtoAlugado;
    }

}
