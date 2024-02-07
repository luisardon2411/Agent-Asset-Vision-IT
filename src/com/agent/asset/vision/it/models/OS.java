package com.agent.asset.vision.it.models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author luise.ardon
 */
public class OS extends SystemAbstractLayer {
    
    private final OperatingSystem os;
    
    public OS(){
        super();
        this.os = getSystem().getOperatingSystem();
    }
    
    public String obtenerNombreSO(){
        return os.getFamily();
    }
    
    public String obtenerVersionSO(){
        return os.getVersionInfo().getVersion();
    }
    
    public String obtenerEdicionSO(){
        String editionOS = os.getFamily();
         try {
            if( editionOS.equals("Windows")){
                Process process = Runtime.getRuntime().exec("wmic os get Caption");
             BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
            // El resultado contiene la línea "Caption" seguido por la edición de Windows, limpiamos el resultado
            return output.toString().replace("Caption", "").trim();
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener la edición de Windows";
        }
    }
    
}
