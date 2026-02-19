package App1UseCases;

import App1DTO.PersonaDTO;
import java.util.List;

/**
 * Interfaz que define el contrato para listar personas.
 * Principio SOLID: Interface Segregation & Dependency Inversion.
 */
public interface ListarPersonas {
    List<PersonaDTO> listadoPersonas();
}
