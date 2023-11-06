package ar.edu.unlam.pb2.ea3;

import java.util.Set;
import java.util.TreeSet;

public class EquipoDeFutbol {
	private String nombre;
	private TreeSet<Jugador> jugadores;
	
	public EquipoDeFutbol(String nombre) {
		this.setNombre(nombre);
		jugadores = new TreeSet<>();
	}

	/*
	 * La capacidad m�xima de un equipo es 23. Cualquier intento de agregar m�s
	 * jugadores generar� una excepci�n (CapacidadMaximaException). Adem�s, no
	 * deber� permitir duplicar Jugadores (JugadorDuplicadoException).
	 */
	public void agregarJugador(Jugador jugador) throws CapacidadMaximaException, JugadorDuplicadoException {
		if(jugadores.size()>=23)
			throw new CapacidadMaximaException();
		
		for(Jugador j: jugadores) {
			if(j.getNombre().equals(jugador.getNombre()))
				throw new JugadorDuplicadoException();
		}
		
		jugadores.add(jugador);
	}
	
	public void eliminarJugador(Jugador jugador) throws JugadorInexistenteException {
		for(Jugador j: jugadores) {
			if(j.getNombre().equals(jugador.getNombre())) {
				jugadores.remove(jugador);
				return;
			}
		}
		throw new JugadorInexistenteException();
	}

	/*
	 * Permite cambiar cualquier jugador. Un intento de cambiar un jugador no
	 * presente en el equipo generar� una excepci�n
	 * (JugadoreInexistenteException).
	 */
	public Boolean cambiarJugador(Jugador saliente, Jugador entrante) throws JugadorInexistenteException, CapacidadMaximaException, JugadorDuplicadoException{
		eliminarJugador(saliente);
		agregarJugador(entrante);
		return true;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorNombreDeJugador() {
		
		return null;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorPrecioDeCompraDeJugador() {
		TreeSet<Jugador> jugadoresOrdenadosPorPrecio = new TreeSet<>(new ComparadorPorPrecio());
		jugadoresOrdenadosPorPrecio.addAll(jugadores);
		return jugadoresOrdenadosPorPrecio;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorNumeroDeCamisetaDeJugador() {
		TreeSet<Jugador> jugadoresOrdenadosPorNumeroDeCamiseta = new TreeSet<>(new ComparadorPorNumero());
		jugadoresOrdenadosPorNumeroDeCamiseta.addAll(jugadores);
		
		return jugadoresOrdenadosPorNumeroDeCamiseta;
	}

	public TreeSet<Jugador> getJugadores() {
		return jugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
