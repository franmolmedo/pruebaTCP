/**
 * TCPServidor.java
 *
 * @author Antonio J. Nebro
 * @version 1.0
 *
 * Ejemplo de servidor TCP: recibe una cadena de caracteres de un cliente, 
 * convierte los caracteres de la misma a mayusculas y devuelve la cadena
 * modificada
 */
package sockets;

import java.io.* ;
import java.net.* ;

public class TCPServidor {

	static final int PUERTO = 7000 ; 
	/**
	 * @param args Linea de argumentos
	 */
	public static void main(String[] args) throws Exception {
		String mensajeCliente      ;
		String mensajeEnMayusculas ;
		
		// Creacion de un ServerSocket
		ServerSocket serverSocket = new ServerSocket(PUERTO) ;
		
		// Bucle principal
		while (true) {
			// Espera una conexion de un cliente
			System.out.println("Servidor. Esperando conexion ...") ;
			Socket socket = serverSocket.accept() ;
			System.out.println("Servidor. Conexion aceptada. " + socket.toString()) ;

			// Stream de recepcion de datos del cliente
			BufferedReader delCliente = 
				new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
			
			// Stream de envio de datos al cliente
			DataOutputStream alCliente = 
				new DataOutputStream(socket.getOutputStream()) ;
			
			// Lectura del mensaje de cliente
			mensajeCliente = delCliente.readLine() ;
			System.out.println("Servidor. Recibido mensaje: " + mensajeCliente) ;
			
			// El mensaje se modifica cambiando minusculas por mayusculas
			mensajeEnMayusculas = mensajeCliente.toUpperCase() + '\n' ;
			
			// Respuesta el cliente
			alCliente.writeBytes(mensajeEnMayusculas) ;
			System.out.println("Servidor. Fin de conexion") ;
			
			socket.close() ;
		} // while
	} // main
} // TCPServer