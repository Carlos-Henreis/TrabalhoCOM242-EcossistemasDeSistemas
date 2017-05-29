/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author salomon
 */
public class JavaServer extends Thread {

    Server server;
    int port = 50051;

    @Override
    public void run(){
        try {
        server = ServerBuilder.forPort(port)
                .addService(new JavaApp())
                .build()
                .start();
        server.awaitTermination();
        
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(JavaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void stopServer() {
        if (server != null) {
            server.shutdown();
        }
    }
}
