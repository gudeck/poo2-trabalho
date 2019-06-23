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
 * @author liviaaurich
 */
public class ProdutoAlugadoPK implements Serializable {

    public ProdutoAlugadoPK() {
    }

    @ManyToOne
    @JoinColumn(name = "codAluguel")
    Aluguel aluguel;

    @ManyToOne
    @JoinColumn(name = "codProduto")
    Produto produto;

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
