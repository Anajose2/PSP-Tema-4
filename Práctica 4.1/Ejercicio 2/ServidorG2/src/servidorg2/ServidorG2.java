/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorg2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author jmfdiaz
 */
public class ServidorG2 {

    Socket skCliente;
    static final int PUERTO = 15000;

    public static void main (String args []) {
        ServerSocket skServidor = null;
        HiloServidor hServidor;
        HiloEscribir hEscribir;

        try {
            // Inicio el servidor en el puerto
            skServidor = new ServerSocket(PUERTO);

        } catch (IOException e) {
            System.out.println("Error E/S en el servidor: " + e.getMessage());
        } finally {
            // Intentar cerrar el socket del servidor por si ocurre cualquier error
            try {
                if (skServidor != null) {
                    skServidor.close();
                }
            } catch (IOException ex) {
                System.out.println("Error E/S al finalizar el servidor: "+ ex.getMessage());
            }
        }
    }

}
