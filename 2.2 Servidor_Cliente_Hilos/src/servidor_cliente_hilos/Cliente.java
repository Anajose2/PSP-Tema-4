/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_cliente_hilos;

/**
 *
 * @author ramon
 */
import java.io.*;
import java.net.*;

public class Cliente {

    static final String HOST = "localhost";
    static final int Puerto = 2000;

    public Cliente() {
        try {
            // Creo el socket del cliente
            Socket skCliente = new Socket(HOST, Puerto);

            // Creo los flujos de entrada y salida
            DataInputStream flujo_entrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(skCliente.getOutputStream());

            // TAREAS QUE REALIZA EL CLIENTE
            String datos = flujo_entrada.readUTF();
            System.out.println(datos);

            skCliente.close();

        } catch (UnknownHostException e) {
            System.out.println("Host Desconocido " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error E/S " + e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Cliente();
    }
}
