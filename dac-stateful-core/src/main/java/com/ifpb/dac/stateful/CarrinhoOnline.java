package com.ifpb.dac.stateful;

import com.ifpb.dac.stateful.shared.Carrinho;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoOnline implements Carrinho{

    private List<String> produtos = new ArrayList<>();
    
    @Override
    public void addProduto(String produto) {
        System.out.println("Produto adicionado: "+produto);
        this.produtos.add(produto);
    }

    @Override
    public void removeProduto(String produto) {
        System.out.println("Produto removido: "+produto);
        this.produtos.remove(produto);
    }

    @Override
    public List<String> list() {
        return Collections.unmodifiableList(produtos);
    }

    @Remove
    @Override
    public void finalizarCompra() {
        System.out.println("--Compra finalizada--");
        for(int i=0; i<produtos.size(); i++){
            String produto = produtos.get(i);
            System.out.println("1- "+produto);
        }
    }
    
}
