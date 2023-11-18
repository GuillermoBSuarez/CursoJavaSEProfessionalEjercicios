package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Ciudad {
	private String nombre;
	private String pais;
	private long habitantes;
	private double temperaturaMedia;
}