package servidorg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jmfdiaz
 */
public class RunServidor implements Runnable{
    
    private Socket skCliente;
    
    RunServidor(Socket skCliente){
        this.skCliente=skCliente;
    }

    @Override
    public void run() {
    }
    
}
