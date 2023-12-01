package com.gabrielprata.cursouml.cursouml.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielprata.cursouml.cursouml.domain.CustomerOrder;
import com.gabrielprata.cursouml.cursouml.services.CustomerOrderService;

@RestController
@RequestMapping(value = "/orders")
public class CustomerOrderResource {
    
    @Autowired
    private CustomerOrderService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    //@PathVariable serve para o Spring saiba que o id da URL tem que ir para o id da variável
    //O tipo ResponseEntity (Tipo do Spring) já encapsula informações de uma resposta HTTP REST
    //A interrogação serve para dizer que ali cabe qualquer tipo, pois a busca pode não ser bem sucedida
    public ResponseEntity<?> find(@PathVariable int id) {
        //O handler lança a resposta HTTP adequada caso haja algum erro (nesse caso 404)
        
        CustomerOrder obj = service.search(id);
        return ResponseEntity.ok().body(obj);
    }
}
