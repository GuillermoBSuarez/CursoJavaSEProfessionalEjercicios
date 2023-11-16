package model;

import java.time.LocalDate;

public record Pedido(String producto, LocalDate fecha, double precio) {
	
}