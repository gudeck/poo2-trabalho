/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.*;
import domain.*;
import domain.state.aluguel.EmAberto;
import domain.state.aluguel.Fechado;
import domain.state.aluguel.NaoRetirado;
import domain.state.produto.DanoPermanente;
import domain.state.produto.EmAluguel;
import domain.state.produto.EmLoja;
import domain.state.produto.EmManutencao;
import domain.state.produto.EstadoProduto;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gudeck
 */
public class ControleDominio {

    private static final ControleDominio uniqueInstance = new ControleDominio();
    private final GenericDAO genericDao;

    private ControleDominio() {
        dao.ConexaoHibernate.getSessionFactory();
        genericDao = new GenericDAO();
        genericDao.create_update(EmAberto.getInstance());
        genericDao.create_update(Fechado.getInstance());
        genericDao.create_update(NaoRetirado.getInstance());

        genericDao.create_update(DanoPermanente.getInstance());
        genericDao.create_update(EmAluguel.getInstance());
        genericDao.create_update(EmLoja.getInstance());
        genericDao.create_update(EmManutencao.getInstance());
    }

    public static ControleDominio getInstance() {
        return uniqueInstance;
    }

    public void clienteCreate(String nome, String endereco, String email, String cpf, String dataNascimento, String telefone, char sexo) throws ParseException {

        Cliente cliente = new Cliente();

        cpf = cpf.replace(".", "").replace("-", "");
        telefone = telefone.replace("(", "").replace(")", "").replace(" ", "").replace("-", "");

        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        cliente.setEmail(email);
        cliente.setCpf(cpf);
        cliente.setDataNascimento(MetodosUteis.stringTOjavaDate(dataNascimento));
        cliente.setTelefone(telefone);
        cliente.setSexo(sexo);

        DAOCliente.getInstance().create_update(cliente);

    }

    public List<Cliente> clienteReadAll() {
        return DAOCliente.getInstance().read(Cliente.class);
    }

    public void clienteUpdate(int codigo, String nome, String endereco, String email, String cpf, String dataNascimento, String telefone, char sexo) throws ParseException {

        Cliente cliente = new Cliente();

        cpf = cpf.replace(".", "").replace("-", "");
        telefone = telefone.replace("(", "").replace(")", "").replace(" ", "").replace("-", "");

        cliente.setCodCliente(codigo);
        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        cliente.setEmail(email);
        cliente.setCpf(cpf);
        cliente.setDataNascimento(MetodosUteis.stringTOjavaDate(dataNascimento));
        cliente.setTelefone(telefone);
        cliente.setSexo(sexo);

        DAOCliente.getInstance().create_update(cliente);

    }

    public void clienteDelete(Cliente cliente) {

        DAOCliente.getInstance().delete(cliente);

    }

    public void categoriaCreate(String nome, String descricao) {

        Categoria categoria = new Categoria();

        categoria.setNome(nome);
        categoria.setDescricao(descricao);

        DAOCategoria.getInstance().create_update(categoria);

    }

    public List<Categoria> categoriaReadAll() {

        return DAOCategoria.getInstance().read(Categoria.class);

    }

    public void categoriaUpdate(int codigo, String nome, String descricao) {

        Categoria categoria = new Categoria();

        categoria.setCodCategoria(codigo);
        categoria.setNome(nome);
        categoria.setDescricao(descricao);

        DAOCategoria.getInstance().create_update(categoria);

    }

    public void categoriaDelete(Categoria categoria) {

        DAOCategoria.getInstance().delete(categoria);

    }

    public void produtoCreate(String nome, Double diaria, Double danoPermanente, Categoria categoria, String tamanho, String descricao) {

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setValorDiaria(diaria);
        produto.setValorDanoPermanente(danoPermanente);
        produto.setCategoria(categoria);
        produto.setTamanho(tamanho);
        produto.setDescricao(descricao);
        produto.setEstado(EmLoja.getInstance());

        DAOProduto.getInstance().create_update(produto);

    }

    public List<Produto> produtoReadAll() {
        return DAOProduto.getInstance().read(Produto.class);
    }

    public List<Produto> produtoReadEmLoja() {
        return DAOProduto.getInstance().readEmLoja();
    }

    public List<Produto> produtoReadEmManutencao() {
        return DAOProduto.getInstance().readEmManutencao();
    }

    public void produtoUpdate(int codProduto, String nome, Double diaria, Double danoPermanente, Categoria categoria, String tamanho, String descricao, EstadoProduto estado) {

        Produto produto = new Produto();
        produto.setCodProduto(codProduto);
        produto.setNome(nome);
        produto.setValorDiaria(diaria);
        produto.setValorDanoPermanente(danoPermanente);
        produto.setCategoria(categoria);
        produto.setTamanho(tamanho);
        produto.setDescricao(descricao);
        produto.setEstado(estado);

        DAOProduto.getInstance().create_update(produto);

    }

    public void produtoDelete(Produto produto) {

        DAOProduto.getInstance().delete(produto);

    }

    public GenericDAO getGenericDao() {
        return genericDao;
    }

    public void reservaCreate(List<Produto> listaProdutos, Cliente cliente, String dataRetirada, String dataDevolucao, String valorTotal) throws ParseException {
        Date data = new Date();
        Aluguel aluguel = new Aluguel();

        aluguel.setCliente(cliente);
        aluguel.setDataDevolucao(MetodosUteis.stringTOjavaDate(dataDevolucao));
        aluguel.setDataReserva(data);
        aluguel.setDataRetirada(MetodosUteis.stringTOjavaDate(dataRetirada));
        aluguel.setPessoaRetirou("Não retirado.");
        aluguel.setValorPago(Double.valueOf(valorTotal) / 2);
        aluguel.setValorTotal(Double.valueOf(valorTotal));
        aluguel.setEstado(NaoRetirado.getInstance());

        List<ProdutoAlugado> produtosAluguel = new ArrayList();
        ProdutoAlugado produtoAlugado;

        for (Produto p : listaProdutos) {

            p.setEstado(p.getEstado().setEmAluguel());
            DAOProduto.getInstance().create_update(p);
        }

        for (Produto p : listaProdutos) {
            produtoAlugado = new ProdutoAlugado();
            produtoAlugado.setProdutoAlugado(aluguel, p);
            produtosAluguel.add(produtoAlugado);
        }

        aluguel.setProdutosAlugados(produtosAluguel);

        DAOProduto.getInstance().create_update(aluguel);

    }

    public List<Produto> aluguelReadRoupas(Cliente cliente, Aluguel aluguel) {
        return DAOAluguel.getInstance().readRoupas(cliente, aluguel);
    }

    public List<Aluguel> aluguelReadIndireto(Cliente cliente, String estado) {
        return DAOAluguel.getInstance().readAluguelEstadoIndireto(cliente, estado);
    }

    public Aluguel aluguelReadDireto(Cliente cliente, String estado) {
        return DAOAluguel.getInstance().readAluguelEstadoDireto(cliente, estado);
    }

    public void aluguelUpdate(Aluguel aluguel) {
        for (ProdutoAlugado pa : aluguel.getProdutosAlugados()) {
            genericDao.create_update(pa);
        }
        DAOAluguel.getInstance().create_update(aluguel);
        
    }

}
