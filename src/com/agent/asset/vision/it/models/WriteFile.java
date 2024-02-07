/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agent.asset.vision.it.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import oshi.SystemInfo;

/**
 *
 * @author luise.ardon
 */
public class WriteFile {

    private final SystemInfo system = new SystemInfo();
    private final OS os = new OS();

    public void writeSystemInfoToFile(String fileName) {
        // Obtenemos la ruta del escritorio del usuario actual
        String desktopPath = System.getProperty("user.home") + "\\Desktop";
        String filePath = Paths.get(desktopPath, fileName).toString();

        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Arte ASCII para el encabezado
            writer.write("                       _    __      ___     _               _____ _______ \n");
            writer.write("    /\\                | |   \\ \\    / (_)   (_)             |_   _|__   __|\n");
            writer.write("   /  \\   ___ ___  ___| |_   \\ \\  / / _ ___ _  ___  _ __     | |    | |   \n");
            writer.write("  / /\\ \\ / __/ __|/ _ \\ __|   \\ \\/ / | / __| |/ _ \\| '_ \\    | |    | |   \n");
            writer.write(" / ____ \\\\__ \\__ \\  __/ |_     \\  /  | \\__ \\ | (_) | | | |  _| |_   | |   \n");
            writer.write("/_/    \\_\\___/___/\\___|\\__|     \\/   |_|___/_|\\___/|_| |_| |_____|  |_|\n");
            writer.write("------------------------------------------------------------------------\n");
            writer.write("Agente de captura de información del sistema.\n");
            writer.newLine();
            // Obtener la fecha actual
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.write("Hora de análisis: " + now.format(formatter));
            writer.newLine();
            writer.write("-------------------------------------\n");
            writer.write("Descripcion General:");
            writer.newLine();
            writer.write("-------------------\n");
            writer.write("AssetVisionIT es una herramienta diseñada para proporcionar una visión\n");
            writer.write("integral de los recursos de hardware críticos dentro de un entorno de TI.\n");
            writer.write("Destinada a administradores de sistemas, técnicos de soporte y profesionales\n");
            writer.write("de TI, esta aplicación facilita la recopilación y el análisis de información\n");
            writer.write("detallada sobre los componentes esenciales del sistema, incluyendo el sistema\n");
            writer.write("operativo, las especificaciones de la CPU y los detalles del disco duro.\n");
            writer.write("Al generar un informe completo y accesible.\n");
            writer.write("----------------------------------------------------------------------------\n");
            writer.write("Informacion del fabricante: ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("" + system.getHardware().getComputerSystem());
            writer.write("\n--------------------------\n");
            writer.write("Informacion del Sistema Operativo: ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("Sistema Operativo: " + os.obtenerNombreSO());
            writer.write("\nVersión: " + os.obtenerVersionSO());
            writer.write("\nEdición: " + os.obtenerEdicionSO());
            writer.write("\n--------------------------\n");
            writer.write("Informacion del CPU: ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("" + system.getHardware().getProcessor());
            writer.write("\n--------------------------\n");
            writer.write("Informacion de memoria RAM: ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("Total: " + system.getHardware().getMemory().getTotal());
            writer.write("\nDisponible: " + system.getHardware().getMemory());
            writer.write("\nSlots utilizados: " + system.getHardware().getMemory().getPhysicalMemory());
            writer.write("\n--------------------------\n");
            writer.write("Informacion de Disco(s): ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("" + system.getHardware().getDiskStores());
            writer.write("\n--------------------------\n");
            writer.write("Informacion de pantalla(s): ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("" + system.getHardware().getDisplays());
            writer.write("\n--------------------------\n");
            writer.write("Informacion de tarjetas de video: ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("" + system.getHardware().getGraphicsCards());
            writer.write("\n--------------------------\n");
            writer.write("Informacion de dispositivos de red: ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("" + system.getHardware().getNetworkIFs());
            writer.write("\n--------------------------\n");
            writer.write("Informacion de coolers: ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("" + system.getHardware().getSensors());
            writer.write("\n--------------------------\n");
                        writer.write("Informacion de Energía: ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("" + system.getHardware().getPowerSources());
            writer.write("\n--------------------------\n");
                        writer.write("Informacion de dispositivos USB: ");
            writer.newLine();
            writer.write("--------------------------\n");
            writer.write("" + system.getHardware().getUsbDevices(true));
            writer.write("\n--------------------------\n");
            writer.newLine();
            writer.write("Gracias por utilizar el Agente de Asset Vision IT");
            writer.newLine();
            writer.write("@Luis Ardón");

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
