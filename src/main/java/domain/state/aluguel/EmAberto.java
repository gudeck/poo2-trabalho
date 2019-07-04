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
public class EmAberto extends EstadoAluguel {

    private EmAberto() {
        this.codEstado = 2;
    }

    public static EmAberto getInstance() {
        return EmLojaHolder.INSTANCE;
    }

    @Override
    public EstadoAluguel setFechado() {
        return Fechado.getInstance();
    }

    @Override
    public EstadoAluguel setEmAberto() {
        return this;
    }

    @Override
    public EstadoAluguel setNaoRetirado() {
        return this;
    }

    private static class EmLojaHolder {

        private static final EmAberto INSTANCE = new EmAberto();
    }

	@Override
	public String toString() {
		return "Em Aberto";
	}
    
    
}
