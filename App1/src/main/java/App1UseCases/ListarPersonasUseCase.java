package App1UseCases;

import App1DTO.PersonaDTO;
import java.util.List;

/**
 * Implementación del caso de uso ListarPersonas.
 * Principio SOLID: Single Responsibility (solo lista personas).
 * Inyección de Dependencias: recibe PersonaDAO por constructor.
 */
public class ListarPersonasUseCase implements ListarPersonas {
    private final PersonaDAO personaDAO;

    // Inyección de Dependencias por constructor
    public ListarPersonasUseCase(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    @Override
    public List<PersonaDTO> listadoPersonas() {
        return personaDAO.listadoPersonas();
    }
}
