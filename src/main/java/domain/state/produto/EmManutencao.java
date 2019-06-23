/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.state.produto;

import javax.persistence.Entity;

/**
 *
 * @author guzuc
 */
@Entity
public class EmManutencao extends EstadoProduto {

    private EmManutencao() {
        this.codEstado = 3;
    }

    public static EmManutencao getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    @Override
    public EstadoProduto setDanoPermanente() {
        return DanoPermanente.getInstance();
    }

    @Override
    public EstadoProduto setEmAluguel() {
        return this;
    }

    @Override
    public EstadoProduto setEmLoja() {
        return EmLoja.getInstance();
    }

    @Override
    public EstadoProduto setEmManutencao() {
        return this;
    }

    private static class NewSingletonHolder {

        private static final EmManutencao INSTANCE = new EmManutencao();
    }

    @Override
    public String toString() {
        return "Em Manutenção";
    }

}
