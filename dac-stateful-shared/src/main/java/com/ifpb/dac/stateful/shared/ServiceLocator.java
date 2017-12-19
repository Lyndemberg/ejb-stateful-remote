package com.ifpb.dac.stateful.shared;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {
    
    
    public Carrinho lookup(String host, String port, String name){
        try {
            Properties props = new Properties();
            props.put(InitialContext.INITIAL_CONTEXT_FACTORY, 
                "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost", host);
            props.setProperty("org.omg.CORBA.ORBInitialPort", port);
            Context cont = new InitialContext(props);
            return (Carrinho) cont.lookup(name);
        } catch (NamingException ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
