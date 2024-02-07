/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agent.asset.vision.it.models;

import oshi.SystemInfo;

/**
 *
 * @author luise.ardon
 */
public class SystemAbstractLayer {
    
    
    private SystemInfo system;
    
    public SystemAbstractLayer(){
        this.system = new SystemInfo();
    }
    
    protected SystemInfo getSystem(){
        return system;
    }

}
