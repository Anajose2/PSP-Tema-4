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

public class Servidor extends Thread {

    Socket skCliente;
    static final int PUERTO = 2000;

    public Servidor(Socket sCliente) {
        skCliente = sCliente;
    }

    public static void main(String[] arg) {
        
        ServerSocket skServidor = null;
        try {
            // Inicio el servidor en el puerto
            skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);

            // atender peticiones de forma ininterrumpida
            // no es lo recomendable tener un bucle infinito
            // en algún momento tendrá que finalizar el servidor
            while (true) {
                // Se conecta un cliente
                Socket skCliente = skServidor.accept();
                System.out.println("Cliente conectado");

                // Atiendo al cliente mediante un thread
                new Servidor(skCliente).start();
            }
        } catch (IOException e) {
            System.out.println("Error E/S en el servidor: " + e);
        } finally {
            // Intentar cerrar el socket del servidor por si ocurre cualquier error
            try {
                if (skServidor != null) {
                    skServidor.close();
                }
            } catch (IOException e) {
                System.out.println("Error E/S al cerrar el servidor");
            }
        }
    }

    public void run() {
        try {
            // Creo los flujos de entrada y salida
            DataInputStream flujo_entrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(skCliente.getOutputStream());

            // ATENDER PETICIÓN DEL CLIENTE
            flujo_salida.writeUTF("Se ha conectado el cliente de forma correcta");

            // Se cierra la conexión
            skCliente.close();
            System.out.println("Cliente desconectado");

        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
