/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiempo_transmision;

/**
 *
 * @author ramon
 */
import java.io.*;
import java.net.*;
import java.util.Date;

// importante debes sincronizar el reloj de tu ordenador (si es Linux) con un servicio de tiempo
// Ejecuta desde la terminal de comandos  =>  sudo ntpdate -u 0.centos.pool.ntp.org
public class Cliente {

    //static final String HOST = "192.168.1.200";
    static final String HOST = "localhost";
    static final int Puerto = 2000;

    public Cliente() {
        String datos = new String();
        String num_cliente = new String();

        try {
            // Me conecto al puerto
            Socket sCliente = new Socket(HOST, Puerto);

            // Creo los flujos de entrada y salida
            DataInputStream flujo_entrada = new DataInputStream(sCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(sCliente.getOutputStream());

            // Recibir la información del servidor con el tiempo inicial => tiempo1          
            long tiempo1 = flujo_entrada.readLong();

            // Calcular el tiempo final => tiempo 2
            //long tiempo2=(new Date()).getTime();
            long tiempo2 = System.currentTimeMillis(); // => es más exacto calcular el tiempo así.

            // Mostrar el tiempo en transmitir	
            System.out.println("\n El tiempo en transmitir es: " + (tiempo2 - tiempo1) + " milisegundos");

            // Se cierra la conexión
            sCliente.close();

        } catch (UnknownHostException e) {
            System.out.println("Host desconocido: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error E/S: " + e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Cliente();
    }
}
