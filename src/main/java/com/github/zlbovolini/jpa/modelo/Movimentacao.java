package com.github.zlbovolini.jpa.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    private LocalDateTime data;
    private String descricao;
    private BigDecimal valor;

    @ManyToOne
    private Conta conta;

    @ManyToMany
    private List<Categoria> categorias;

    public Movimentacao() {
    }

    public Movimentacao(Long id) {
        this.id = id;
    }

    public Movimentacao(TipoMovimentacao tipoMovimentacao, LocalDateTime data,
                        String descricao, BigDecimal valor, Conta conta, List<Categoria> categoriaList) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.conta = conta;
        this.categorias = categoriaList;
    }

    public Movimentacao(Long id, TipoMovimentacao tipoMovimentacao, LocalDateTime data,
                        String descricao, BigDecimal valor, Conta conta, List<Categoria> categoriaList) {
        this(tipoMovimentacao, data, descricao, valor, conta, categoriaList);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
