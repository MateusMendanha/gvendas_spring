package com.gvendas.gestaovendas.servico;

import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public List<Produto> listarTodos(Long CodigoCategoria){
        return produtoRepositorio.findByCategoriaCodigo(CodigoCategoria);

    }

    public Optional<Produto> buscarPorCodigo(Long codigo, Long codigoCategoria) {
        return produtoRepositorio.buscarPorCodigo(codigo, codigoCategoria);
    }

    public Produto salvar(Produto produto) {
        return produtoRepositorio.save(produto);
    }
}
