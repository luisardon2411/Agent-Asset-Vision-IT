package com.agent.asset.vision.it;

import com.agent.asset.vision.it.models.WriteFile;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WriteFile file = new WriteFile();
        file.writeSystemInfoToFile("system_information.txt");
        
        System.out.println("¡Análisis generado con éxito en Escritorio!");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        try {
            final String os = System.getProperty("os.name");
            
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
            }
        } catch (Exception e) {
            System.out.println("No se pudo limpiar la consola");
        }
    }
}
