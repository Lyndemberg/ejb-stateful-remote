package com.ifpb.dac.stateful.shared;

import java.util.List;

public interface Carrinho {
    public void addProduto(String produto);
    public void removeProduto(String produto);
    public List<String> list();
    public void finalizarCompra();
}
