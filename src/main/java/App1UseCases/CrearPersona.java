package App1UseCases;

import App1DTO.PersonaDTO;

/**
 * Interfaz que define el contrato para crear una persona.
 * Principio SOLID: Interface Segregation & Dependency Inversion.
 */
public interface CrearPersona {
    boolean inicializarPersona(PersonaDTO personaDTO);
}
