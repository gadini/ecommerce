package br.com.fiap.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.dtos.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ProdutoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ProdutoResponseDto;
import br.com.fiap.ecommerce.model.Produto;
import br.com.fiap.ecommerce.service.ProdutoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoResponseDto> list(){

        List<Produto> produtos = produtoService.list();
        return null;
    }

    @PostMapping
    public ProdutoResponseDto create(@RequestBody ProdutoRequestCreateDto dto){
        //produtoService.save();
        return null;
    }

    @PutMapping("{id}")
    public ProdutoResponseDto update(@PathVariable Long id, @RequestBody ProdutoRequestUpdateDto dto){
        
        if(! produtoService.existsById(id)){
            new RuntimeException("Id inexistente");
        }

        //Produto saved = produtoService.save(produto);

        return null;
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id){
        if(! produtoService.existsById(id)){
            new RuntimeException("Id inexistente");
        }

        produtoService.delete(id);

    }

    @GetMapping("{id}")
    public ProdutoResponseDto findById(@PathVariable Long id){

        Optional<Produto> opt = produtoService.findById(id);

        Produto produto = null;
        
        if(opt.isPresent()){
            produto = opt.get();
        }
        else{
            new RuntimeException("Produto inexistente");
        }

        return null;
    }

}
