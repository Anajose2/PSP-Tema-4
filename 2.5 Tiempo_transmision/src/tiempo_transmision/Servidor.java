/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiempo_transmision;

import java.io.*;
import java.net.*;
import java.util.Date;

// importante debes sincronizar el reloj de tu ordenador (si es Linux) con un servicio de tiempo
// Ejecuta desde la terminal de comandos  =>  sudo ntpdate -u 0.centos.pool.ntp.org
public class Servidor {

    static final int Puerto = 2000;

    // Constructor
    public Servidor() {

        try {
            // Inicio el servidor en el puerto
            ServerSocket sServidor = new ServerSocket(Puerto);
            System.out.println("Escucho el puerto " + Puerto);

            // Se conecta un cliente
            Socket sCliente = sServidor.accept();
            System.out.println("Cliente conectado");

            // Creo los flujos de entrada y salida
            DataInputStream flujo_entrada = new DataInputStream(sCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(sCliente.getOutputStream());

            // Calcular el tiempo inicial antes de mandar la información al cliente
            // long tiempo1=(new Date()).getTime();
            long tiempo1 = System.currentTimeMillis(); // => es más exacto calcular el tiempo así.

            // Transmitir la información al cliente del tiempo inicial
            flujo_salida.writeLong(tiempo1);

            // Se cierra la conexión
            sCliente.close();
            System.out.println("Cliente desconectado");

        } catch (IOException e) {
            System.out.println("Error de E/S " + e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Servidor();
    }
}
