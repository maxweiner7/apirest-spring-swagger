package com.produtos.apirest.resources;

import com.produtos.apirest.repository.ProdutoRepository;
import com.produtos.apirest.models.Produto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value = "Deleta produto")
    @DeleteMapping("/produto/")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @ApiOperation(value = "Atualiza produto")
    @PutMapping("/produto/")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);

    }

    @ApiOperation(value = "Retorna produto")
    @GetMapping("/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    @ApiOperation(value = "Retorna lista de produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @ApiOperation(value = "Salva produto")
    @PostMapping("/produto")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }


}
