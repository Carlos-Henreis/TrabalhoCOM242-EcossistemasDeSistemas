/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.Scanner;
import main.Server.JavaServer;
import main.controllers.Switcher;

/**
 *
 * @author salomon
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JavaServer js = new JavaServer();
        String op;
        js.start();
        Scanner in = new Scanner(System.in);
        Switcher sw = new Switcher();
        while(true) {
            printMenu();
            op = in.nextLine();
            if(op.equals("q")) break;
            
            try {
                 Runtime.getRuntime().exec("clear");
            } catch(IOException e) {
                print("\n\n\nVOCE ESTA USANDO O RUINDOWS, NADA DE CONSOLE LIMPO PRA VOCÊ\n\n\n");
            }
            
            sw.runOption(op);
        }
        
        js.stopServer();
    }
    
    private static void printMenu() {
        print("Java Application:");
        print("pyip \t\t\t Change PythonApp ip");
        print("rbip \t\t\t Change RubyApp ip");
        print("sc \t\t\t Start Combat");
        print("rh \t\t\t Register Hero");
        print("sh \t\t\t Show Heroes");
        print("rd \t\t\t Roll Dice");
        print("q  \t\t\t Quit App");
    }
    
    private static void print(String str) { 
        System.out.println(str);
    }

}
