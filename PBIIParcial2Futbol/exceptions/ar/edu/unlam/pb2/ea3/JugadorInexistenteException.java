package ar.edu.unlam.pb2.ea3;

public class JugadorInexistenteException extends Exception {
	public JugadorInexistenteException() {
		super("No se encontró el jugador");
	}
}
