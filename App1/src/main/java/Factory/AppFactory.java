package Factory;

import App1UseCases.CrearPersona;
import App1UseCases.CrearPersonaUseCase;
import App1UseCases.ListarPersonas;
import App1UseCases.ListarPersonasUseCase;
import App1UseCases.PersonaDAO;
import App1Entities.Permisos;
import Controllers.ControllerUseCase1;
import App1ViewCases.CrearPersonaView;
import App1ViewCases.ListarPersonaView;
import InicioMain.Authorizer.Permissions;
import InicioMain.DataBase.PersonaDAOImpl;

/**
 * Fábrica General (Factory Method + Singleton).
 * Centraliza la creación de TODOS los componentes de la aplicación.
 * 
 * Patrones aplicados:
 *   - Factory Method: métodos de creación para cada componente.
 *   - Singleton: una única instancia de la fábrica.
 * 
 * Principios SOLID:
 *   - Single Responsibility: solo se encarga de crear objetos.
 *   - Open/Closed: se pueden agregar nuevos métodos de creación sin modificar los existentes.
 *   - Dependency Inversion: los clientes dependen de abstracciones (interfaces), no de implementaciones.
 */
public class AppFactory {

    // ===================== SINGLETON =====================
    private static AppFactory instance;

    private final Permisos permisos;
    private final PersonaDAO personaDAO;

    private AppFactory() {
        // Obtener las instancias Singleton de los componentes de infraestructura
        this.permisos = Permissions.inicializarPermissions();
        this.personaDAO = PersonaDAOImpl.inicializarPersonaDAO();
    }

    public static AppFactory getInstance() {
        if (instance == null) {
            instance = new AppFactory();
        }
        return instance;
    }

    // ===================== FACTORY METHODS =====================

    /**
     * Crea el caso de uso para crear personas.
     * Inyecta automáticamente Permisos y PersonaDAO.
     * 
     * @return instancia de CrearPersona (interfaz)
     */
    public CrearPersona crearCrearPersonaUseCase() {
        return new CrearPersonaUseCase(permisos, personaDAO);
    }

    /**
     * Crea el caso de uso para listar personas.
     * Inyecta automáticamente PersonaDAO.
     * 
     * @return instancia de ListarPersonas (interfaz)
     */
    public ListarPersonas crearListarPersonasUseCase() {
        return new ListarPersonasUseCase(personaDAO);
    }

    /**
     * Crea el controlador con sus casos de uso inyectados.
     * 
     * @return instancia de ControllerUseCase1
     */
    public ControllerUseCase1 crearController() {
        return new ControllerUseCase1(
                crearCrearPersonaUseCase(),
                crearListarPersonasUseCase()
        );
    }

    /**
     * Crea la vista de creación de personas con el controlador inyectado.
     * 
     * @return instancia de CrearPersonaView
     */
    public CrearPersonaView crearCrearPersonaView() {
        return new CrearPersonaView(crearController());
    }

    /**
     * Crea la vista de listado de personas con el controlador inyectado.
     * 
     * @return instancia de ListarPersonaView
     */
    public ListarPersonaView crearListarPersonaView() {
        return new ListarPersonaView(crearController());
    }
}
