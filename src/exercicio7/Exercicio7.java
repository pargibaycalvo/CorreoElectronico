/*
Programa que simule un buzón de correo (recurso compartido), de xeito que se poida leer unha mensaje ou envialo. 
O buzón soamente pode almacear unha mensaxe, de xeito que para poder escribir débese atopar baleiro e para poder leer debe de estar cheo. 
Crear varios fíos lectores e escritores que manexen o buzón de xeito sincronizado.
 */
package exercicio7;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author pargibaycalvo
 */
public class Exercicio7 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue ma = new LinkedList<>();
        int maximo = 1;//máximo de mensajes entre correo entrante y salida
        
        Correo email1 = new Correo(false, "entrada", ma, maximo);
        Lectura lect1 = new Lectura(true, "salida", ma, maximo);
        email1.start();
        lect1.start();
        
    }
    
}
