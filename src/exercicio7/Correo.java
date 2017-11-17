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
        String entrada = "Hola soy el mensaje de entrada";//mensaje de entrada
            synchronized (q){//sincronizacion
                for(int p=0; p<2; p++){//mensaje entrante al correo será 1 máximo
                    try {
                        while (q.size() == maximo){//cuando llegue la bandeja al máximo
                            try {
                                System.out.println("¡Advertencia! Bandeja de entrada llena");//salta este mensaje
                                System.out.println("");
                                q.wait();
                                if(q.size()<1){//al tener más mensajes avisará de que tienes más mensajes por leer
                                System.out.println("Te quedan mensajes por leer, mensaje número: "+p+" Abriendo ...");
                                System.out.println("<---->");
                                Thread.sleep(segundos * 1000);//intervalo de tiempo entre ejecuciones
                                }
                            } catch (Exception ex) {
                            }
                        }
                        Random random = new Random();
                        int i = random.nextInt(500)+1;//le asigno un número aleatorio al mensaje para diferenciarlos
                        System.out.println("Nuevo correo entrante sin leer:\nContenido -> "+entrada+" "+i);//aviso de correo nuevo más su contenido
                        System.out.println("");
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
        
        
  

