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
public class EmAluguel extends EstadoProduto {

    private EmAluguel() {
        this.codEstado = 2;
    }

    public static EmAluguel getInstance() {
        return EmAluguelHolder.INSTANCE;
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
        return this;
    }

    @Override
    public EstadoProduto setEmManutencao() {
        return EmManutencao.getInstance();
    }

    private static class EmAluguelHolder {

        private static final EmAluguel INSTANCE = new EmAluguel();
    }

    @Override
    public String toString() {
        return "Em Aluguel";
    }
}
