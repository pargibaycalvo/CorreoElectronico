/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio7;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pargibaycalvo
 */
public class Lectura extends Thread{
    private Queue q;
    private int maximo;
    String BandejaSalida;
    boolean leido = true;
    int segundos = 3;

    public Lectura(boolean leido, String BandejaSalida, Queue q, int maximo) {
        super(BandejaSalida);
        this.leido = leido;
        this.q = q;
        this.maximo = maximo;
        
    }
    
    public void run(){
        String salida = "Leí el mensaje y te respondí";
        while(true){
            synchronized(q){ 
                try {
                    while(q.isEmpty()){
                        System.out.println("¡Enhorabuena! no tienes ningún mensaje sin leer en tu bandeja.");
                        try{
                            q.wait();
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("Mensaje leído");
                    System.out.println("Enviando respuesta automática....");
                    Thread.sleep(segundos * 1000);
                    System.out.println("Respondido-> "+salida+" "+q.remove());
                    q.notifyAll();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Lectura.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
}
