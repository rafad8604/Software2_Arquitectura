package App1UseCases;

import App1DTO.PersonaDTO;
import App1Entities.Persona;
import java.util.List;

/**
 * Interface para el acceso a datos de Persona.
 * Esta interfaz rompe la dependencia directa con la capa de DataBase,
 * permitiendo que los UseCases dependan de una abstracción.
 */
public interface PersonaDAO {
    boolean guardar(Persona persona);
    List<PersonaDTO> listadoPersonas();
}
