package com.ifpb.dac.stateful.jsf;

import com.ifpb.dac.stateful.shared.Carrinho;
import com.ifpb.dac.stateful.shared.ServiceLocator;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
/**
 * @author lyndemberg
 */
@Named
@SessionScoped
public class ControladorCarrinho implements Serializable{
    private String produto;
    private Carrinho carrinho;
    
    @PostConstruct
    public void init(){
        carrinho = new ServiceLocator().lookup("host-core", "3700", 
                "java:global/dac-stateful-core/CarrinhoOnline");
    }
    public String add(){
        this.carrinho.addProduto(produto);
        this.produto="";
        return null;
    }
    public String remove(String produto){
        this.carrinho.removeProduto(produto);
        return null;
    }
    public List<String> list(){
        return carrinho.list();
    }
    public String finalizar(){
        this.carrinho.finalizarCompra();
        encerrarSessao();
        return "index?faces-redirect=true";
    }

    private void encerrarSessao() {
        ExternalContext extCon = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession sessao = (HttpSession) extCon.getSession(true);
        if(sessao != null){
            sessao.invalidate();
        }
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
    
    
}
