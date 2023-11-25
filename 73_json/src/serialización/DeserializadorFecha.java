// Adaptación de 72_nio

package serialización;

import java.lang.reflect.Type;
import java.time.LocalDate;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DeserializadorFecha implements JsonDeserializer<LocalDate> {
	/* Interfaz JsonDeserializar:
	https://javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/com/google/gson/JsonDeserializer.html
	Tiene un único método abstracto deserialize que, al implementar la interfaz en la clase,
	estamos obligados a sobreescribir. */

	@Override
	public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return LocalDate.parse(json.getAsString());
	// Coge el parámetro json como una cadena y lo devuelve como LocalDate en formato ISO.
	}
}