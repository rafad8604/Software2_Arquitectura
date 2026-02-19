package InicioMain;

import Factory.AppFactory;
import App1ViewCases.CrearPersonaView;
import App1ViewCases.ListarPersonaView;


/**
 * Punto de entrada de la aplicación.
 * Usa AppFactory (Factory Method + Singleton) para crear todos los componentes.
 * La fábrica se encarga de la inyección de dependencias.
 */
public class InicioAplicacion {

    public static void main(String[] args) {
        // Obtener la fábrica general (Singleton)
        AppFactory factory = AppFactory.getInstance();

        // Factory Method: crear vistas con todas sus dependencias inyectadas
        CrearPersonaView vista1 = factory.crearCrearPersonaView();
        vista1.adicionarPersona();
        vista1.adicionarPersona();

        ListarPersonaView vista2 = factory.crearListarPersonaView();
    }
}
