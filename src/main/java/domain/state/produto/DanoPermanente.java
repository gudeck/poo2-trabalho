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
public class DanoPermanente extends EstadoProduto {

    private DanoPermanente() {
        this.codEstado = 4;
    }

    public static DanoPermanente getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    @Override
    public EstadoProduto setDanoPermanente() {
        return this;
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
        return EmManutencao.getInstance();
    }

    private static class NewSingletonHolder {

        private static final DanoPermanente INSTANCE = new DanoPermanente();
    }

    @Override
    public String toString() {
        return "Dano Permanente";
    }

}
