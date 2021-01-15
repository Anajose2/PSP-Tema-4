package servidorg2;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Angel Salas Calvo
 *  Hilo que permitira al servidor mandar mensajes
 */
public class HiloEscribir extends Thread {
    
    private Socket skCliente;

    HiloEscribir(Socket skCliente) {
        this.skCliente=skCliente;
    }
    
    @Override
    public void run(){
    }
}

