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
public class EmLoja extends EstadoProduto {

    private EmLoja() {
        this.codEstado = 1;
    }

    public static EmLoja getInstance() {
        return EmLojaHolder.INSTANCE;
    }

    @Override
    public EstadoProduto setDanoPermanente() {
        return DanoPermanente.getInstance();
    }

    @Override
    public EstadoProduto setEmAluguel() {
        return EmAluguel.getInstance();
    }

    @Override
    public EstadoProduto setEmLoja() {
        return this;
    }

    @Override
    public EstadoProduto setEmManutencao() {
        return EmManutencao.getInstance();
    }

    private static class EmLojaHolder {

        private static final EmLoja INSTANCE = new EmLoja();
    }

    @Override
    public String toString() {
        return "Em Loja";
    }
}
