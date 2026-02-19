package App1ViewCases;

import Controllers.ControllerUseCase1;
import App1DTO.PersonaDTO;

/**
 * Vista para crear personas.
 * Inyección de Dependencias: recibe el controlador por constructor.
 * Builder Pattern: usa PersonaDTO.Builder para construir el DTO.
 */
public class CrearPersonaView {
    private final ControllerUseCase1 controllerUseCase1;

    // Inyección de Dependencias por constructor
    public CrearPersonaView(ControllerUseCase1 controllerUseCase1) {
        this.controllerUseCase1 = controllerUseCase1;
    }

    public void adicionarPersona() {
        creandoPersona();
    }

    private void creandoPersona() {
        controllerUseCase1.crearPersona(definiendoPersona());
    }

    // Builder Pattern para construir el PersonaDTO
    private PersonaDTO definiendoPersona() {
        return new PersonaDTO.Builder()
                .identificacion(100.0)
                .nombres("Juan")
                .apellidos("Calderón Moreno")
                .edad(50)
                .build();
    }
}
