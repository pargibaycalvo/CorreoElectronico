/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio7;

import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pargibaycalvo
 */
public class Correo extends Thread{
    private Queue q;
    private int maximo;
    String BandejaEntrada;
    boolean leido = false;
    int segundos = 3;


    public Correo(boolean leido, String BandejaEntrada, Queue q, int maximo) {
        super(BandejaEntrada);
        this.leido = leido;
        this.q = q;
        this.maximo = maximo;
        
    }

    public void run(){
        String entrada = "Hola soy el mensaje de entrada";
            synchronized (q){
                for(int p=0; p<1; p++){
                    try {
                        while (q.size() == maximo){
                            try {
                                System.out.println("Bandeja de entrada llena");
                                q.wait();
                            } catch (Exception ex) {
                            }
                        }
                        Random random = new Random();
                        int i = random.nextInt(500)+1;
                        System.out.println("Nuevo correo entrante sin leer-> "+entrada+" "+i);
                        Thread.sleep(segundos * 1000);
                        q.add(i);
                        q.notifyAll();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
        }
        }
      
        }
        
        
  

