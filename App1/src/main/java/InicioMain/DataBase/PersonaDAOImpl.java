package InicioMain.DataBase;

import App1DTO.PersonaDTO;
import App1Entities.Persona;
import App1UseCases.PersonaDAO;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {
    ArrayList<PersonaDTO> listado = new ArrayList<PersonaDTO>();
    private static PersonaDAOImpl personaDAO;

    private PersonaDAOImpl() { }
    
    public static PersonaDAOImpl inicializarPersonaDAO() {
        if (personaDAO == null) {
            personaDAO = new PersonaDAOImpl();
        }
        return personaDAO;
    }
    
    @Override
    public boolean guardar(Persona persona) {        
        listado.add(new PersonaDTO(persona.getIdentificacion(), persona.getNombres(), persona.getApellidos(), persona.getEdad()));
        return true;
    }
    
    @Override
    public List<PersonaDTO> listadoPersonas() {
        listado.add(new PersonaDTO(100.0, "Roger", "", 40));
        listado.add(new PersonaDTO(100.0, "Roger", "Calderón", 41));
        listado.add(new PersonaDTO(100.0, "Roger", "Calderón Moreno", 42));
        return listado;
    }
}
