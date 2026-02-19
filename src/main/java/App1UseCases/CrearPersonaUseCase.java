package App1UseCases;

import App1DTO.PersonaDTO;
import App1Entities.Persona;
import App1Entities.Permisos;

/**
 * Implementación del caso de uso CrearPersona.
 * Principio SOLID: Single Responsibility (solo crea personas).
 * Inyección de Dependencias: recibe Permisos y PersonaDAO por constructor.
 * Builder Pattern: usa Persona.Builder para construir la entidad.
 */
public class CrearPersonaUseCase implements CrearPersona {
    private final Permisos permisos;
    private final PersonaDAO personaDAO;

    // Inyección de Dependencias por constructor
    public CrearPersonaUseCase(Permisos permisos, PersonaDAO personaDAO) {
        this.permisos = permisos;
        this.personaDAO = personaDAO;
    }

    @Override
    public boolean inicializarPersona(PersonaDTO personaDTO) {
        permisos.validarPermisos();
        // Builder Pattern para construir la entidad Persona
        Persona persona = new Persona.Builder()
                .identificacion(personaDTO.getIdentificacion())
                .nombres(personaDTO.getNombres())
                .apellidos(personaDTO.getApellidos())
                .edad(personaDTO.getEdad())
                .build();
        personaDAO.guardar(persona);
        return true;
    }
}
