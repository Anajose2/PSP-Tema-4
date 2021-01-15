/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorg2;

/**
 *
 * @author ramon
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.* ;

public class HiloServidor extends Thread{

    private Socket skCliente;

    HiloServidor(Socket skCliente) {
        this.skCliente=skCliente;
    }

    @Override
    public void run () {
    }

}