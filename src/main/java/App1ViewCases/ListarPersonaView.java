package App1ViewCases;

import Controllers.ControllerUseCase1;
import App1DTO.PersonaDTO;
import java.util.List;

/**
 * Vista para listar personas.
 * Inyección de Dependencias: recibe el controlador por constructor.
 */
public class ListarPersonaView {
    private final ControllerUseCase1 controllerUseCase1;

    // Inyección de Dependencias por constructor
    public ListarPersonaView(ControllerUseCase1 controllerUseCase1) {
        this.controllerUseCase1 = controllerUseCase1;
        mostrarInformacion();
    }

    private void mostrarInformacion() {
        System.out.println("---------------------------------------------------------.");
        System.out.println("Imprimiendo la información de las personas registradas.");
        System.out.println("---------------------------------------------------------.");
        List<PersonaDTO> personas = controllerUseCase1.listadoPersonas();
        if (personas != null) {
            for (PersonaDTO personaDTO : personas) {
                System.out.println("-->" + personaDTO.toString());
            }
        }
        System.out.println("---------------------------------------------------------.");
    }
}
