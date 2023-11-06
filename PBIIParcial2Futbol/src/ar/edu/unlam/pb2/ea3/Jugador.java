package ar.edu.unlam.pb2.ea3;

import java.util.Objects;

public class Jugador implements Comparable<Jugador>{
	Integer numero;
	String nombre;
	Integer precio;
	
	public Jugador(Integer numero, String nombre, Integer precio) {
		this.numero = numero;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Jugador [numero=" + numero + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Jugador))
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Jugador o) {
		return this.getNombre().compareTo(o.getNombre());
	}

}
