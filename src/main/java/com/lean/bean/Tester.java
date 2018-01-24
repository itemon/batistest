/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lean.bean;

import java.io.Serializable;

/**
 *
 * @author huangwei
 */
public class Tester implements Serializable {
    private static final long serialVersionUID = 201801241147L;
            
    private Long id;
    private String name;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "name= "+name + ", id="+id;
    }
}
