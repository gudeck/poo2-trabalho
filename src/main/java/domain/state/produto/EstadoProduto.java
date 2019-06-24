/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.state.produto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author guzuc
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class EstadoProduto implements Serializable {

    @Id
    protected Integer codEstado;

    public EstadoProduto() {

    }

    public abstract EstadoProduto setDanoPermanente();

    public abstract EstadoProduto setEmAluguel();

    public abstract EstadoProduto setEmLoja();

    public abstract EstadoProduto setEmManutencao();

    public Integer getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Integer codEstado) {
        this.codEstado = codEstado;
    }

}
