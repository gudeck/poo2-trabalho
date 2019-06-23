/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.state.aluguel.EstadoAluguel;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author gudeck
 */
@Entity
public class Aluguel implements Serializable {

    public Aluguel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codAluguel;

    @Column(nullable = false, name = "dataReserva")
    @Temporal(TemporalType.DATE)
    private Date dataReserva;

    @Column(nullable = false, name = "dataRetirada")
    @Temporal(TemporalType.DATE)
    private Date dataRetirada;

    @Column(nullable = false, name = "dataDevolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    @Column(nullable = false)
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "codEstado", nullable = false)
    private EstadoAluguel estado;

    @Column(nullable = false)
    private String pessoaRetirou;

    @Column(nullable = false)
    private Double valorPago;

    @ManyToOne
    @JoinColumn(name = "codCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "chaveComposta.aluguel", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ProdutoAlugado> produtosAlugados;

    public Integer getCodAluguel() {
        return codAluguel;
    }

    public void setCodAluguel(Integer codAluguel) {
        this.codAluguel = codAluguel;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public EstadoAluguel getEstado() {
        return estado;
    }

    public void setEstado(EstadoAluguel estado) {
        this.estado = estado;
    }

    public String getPessoaRetirou() {
        return pessoaRetirou;
    }

    public void setPessoaRetirou(String pessoaRetirou) {
        this.pessoaRetirou = pessoaRetirou;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoAlugado> getProdutosAlugados() {
        return produtosAlugados;
    }

    public void setProdutosAlugados(List<ProdutoAlugado> produtosAlugados) {
        this.produtosAlugados = produtosAlugados;
    }

    
    
}
