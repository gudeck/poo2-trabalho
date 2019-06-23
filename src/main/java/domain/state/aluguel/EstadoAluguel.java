/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.state.aluguel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author guzuc
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class EstadoAluguel implements Serializable {

    @Id
    protected Integer codEstado;

    public EstadoAluguel() {

    }

    public abstract EstadoAluguel setFechado();

    public abstract EstadoAluguel setEmAberto();

    public abstract EstadoAluguel setNaoRetirado();

    public Integer getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Integer codEstado) {
        this.codEstado = codEstado;
    }

}
