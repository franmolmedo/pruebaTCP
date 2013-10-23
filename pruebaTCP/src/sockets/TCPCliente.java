/**
 * TCPCliente.java
 *
 * @author Antonio J. Nebro
 * @version 1.0
 *
 * Ejemplo de cliente TCP: lee una cadena de caracteres del teclado, 
 * la envia al servidor y recibe otra cadena como respuesta
 */
package sockets;

import java.io.* ;
import java.net.*;

public class TCPCliente {

  /**
   * @param args Linea de argumentos
   */
	public static void main(String[] args) throws Exception {
		String mensaje ;
		String mensajeDelServidor ;

		// Stream para leer del teclado
		BufferedReader teclado = new BufferedReader(
				new InputStreamReader(System.in)) ;

		// Creacion del socket en el extremo del cliente
		Socket socketCliente = new Socket("127.0.0.1", 7000) ;
		System.out.println("Cliente. Conexion aceptada. " + socketCliente.toString()) ;

		// Stream de envio de datos al servidor
		DataOutputStream alServidor = 
			new DataOutputStream(socketCliente.getOutputStream()) ;

		// Stream de recepcion de datos del servidor
		BufferedReader delServidor = new BufferedReader(
				new InputStreamReader(socketCliente.getInputStream())) ;

		// Lectura de una cadena del teclado
		System.out.print("Cliente. Introduce una cadena de caracteres: ") ;
		mensaje = teclado.readLine() ;

		// Envio de la cadena al servidor
		alServidor.writeBytes(mensaje + '\n') ;

		// Recepcion de la respuesta del servidor
		mensajeDelServidor = delServidor.readLine() ;

		System.out.println("Cliente. Mensaje del servidor: " + mensajeDelServidor) ;

		// Cierre del socket
		socketCliente.close() ;
	} // main
} // TCPCliente