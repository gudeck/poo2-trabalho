/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author gudeck
 */
@Entity
public class ProdutoAlugado implements Serializable {

    public ProdutoAlugado() {
    }

    @EmbeddedId
    ProdutoAlugadoPK chaveComposta;

    @OneToOne
    @JoinColumn(name = "codManutencao")
    Manutencao manutencao;

    public void setProdutoAlugado(Aluguel aluguel, Produto produto) {

        chaveComposta = new ProdutoAlugadoPK();
        chaveComposta.aluguel = aluguel;
        chaveComposta.produto = produto;
    }

    public Aluguel getAluguel() {
        return chaveComposta.getAluguel();
    }

    public void setAluguel(Aluguel aluguel) {
        chaveComposta.setAluguel(aluguel);
    }

    public Produto getProduto() {
        return chaveComposta.getProduto();
    }

    public void setProduto(Produto produto) {
        chaveComposta.setProduto(produto);
    }

}
