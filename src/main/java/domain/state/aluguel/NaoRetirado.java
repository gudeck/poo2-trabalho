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
public class NaoRetirado extends EstadoAluguel {

    private NaoRetirado() {
        this.codEstado = 1;
    }

    public static NaoRetirado getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    @Override
    public EstadoAluguel setFechado() {
        return this;
    }

    @Override
    public EstadoAluguel setEmAberto() {
        return EmAberto.getInstance();
    }

    @Override
    public EstadoAluguel setNaoRetirado() {
        return this;
    }

    private static class NewSingletonHolder {

        private static final NaoRetirado INSTANCE = new NaoRetirado();
    }

}
