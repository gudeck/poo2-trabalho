/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.state.aluguel;

import javax.persistence.Entity;

/**
 *
 * @author guzuc
 */
@Entity
public class Fechado extends EstadoAluguel {

    private Fechado() {
        this.codEstado = 3;
    }

    public static Fechado getInstance() {
        return EmAluguelHolder.INSTANCE;
    }

    @Override
    public EstadoAluguel setFechado() {
        return this;
    }

    @Override
    public EstadoAluguel setEmAberto() {
        return this;
    }

    @Override
    public EstadoAluguel setNaoRetirado() {
        return this;
    }

    private static class EmAluguelHolder {

        private static final Fechado INSTANCE = new Fechado();
    }
    
    @Override
	public String toString() {
		return "Fechado";
	}
    
}
