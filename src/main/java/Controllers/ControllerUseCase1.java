package Controllers;

import App1DTO.PersonaDTO;
import App1UseCases.CrearPersona;
import App1UseCases.ListarPersonas;
import java.util.List;

/**
 * Controlador que coordina los casos de uso.
 * Principio SOLID: Dependency Inversion (depende de abstracciones CrearPersona y ListarPersonas).
 * Inyección de Dependencias: recibe los casos de uso por constructor.
 */
public class ControllerUseCase1 {
    private final CrearPersona crearPersona;
    private final ListarPersonas listarPersonas;

    // Inyección de Dependencias por constructor
    public ControllerUseCase1(CrearPersona crearPersona, ListarPersonas listarPersonas) {
        this.crearPersona = crearPersona;
        this.listarPersonas = listarPersonas;
    }

    public boolean crearPersona(PersonaDTO personaDTO) {
        return crearPersona.inicializarPersona(personaDTO);
    }

    public List<PersonaDTO> listadoPersonas() {
        return listarPersonas.listadoPersonas();
    }
}
