package br.com.fiap.ecommerce.dtos;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Produto;

public class ProdutoResponseDto {
    
    private Long id;
    private String nome;
    private static final ModelMapper modelMapper = new ModelMapper();

    public ProdutoResponseDto toDto(Produto produto){
        ProdutoResponseDto result = modelMapper.map(produto, ProdutoResponseDto.class);
        return result;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    

}
