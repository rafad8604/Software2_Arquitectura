package App1Entities;

import App1DTO.PersonaDTO;

public class Persona {
    private Double identificacion;
    private String nombres;
    private String apellidos;
    private int edad;
    private String codigo;
    
    public Persona() { 
        this.identificacion = 0.0;
        this.nombres = "---";
        this.apellidos = "---";
        this.edad = 0;
        this.codigo="XYZ";
    }

    // Constructor privado para el Builder
    private Persona(Builder builder) {
        this.identificacion = builder.identificacion;
        this.nombres = builder.nombres;
        this.apellidos = builder.apellidos;
        this.edad = builder.edad;
        this.codigo = "XYZ" + (builder.identificacion != null ? builder.identificacion.toString() : "");
    }

    // ===================== BUILDER PATTERN =====================
    public static class Builder {
        private Double identificacion;
        private String nombres;
        private String apellidos;
        private int edad;

        public Builder identificacion(Double identificacion) {
            this.identificacion = identificacion;
            return this;
        }

        public Builder nombres(String nombres) {
            this.nombres = nombres;
            return this;
        }

        public Builder apellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

        public Builder edad(int edad) {
            this.edad = edad;
            return this;
        }

        public Persona build() {
            return new Persona(this);
        }
    }
    
    @Override
    public String toString() {
        return "Persona{" + "identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }
    
    public void setDatosPersona(PersonaDTO persona) {
        this.identificacion = persona.getIdentificacion();
        this.nombres = persona.getNombres();
        this.apellidos = persona.getApellidos();
        this.edad = persona.getEdad();
        this.codigo="XYZ" + this.identificacion.toString();
    }

    public Double getIdentificacion() {
        return identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getCodigo() {
        return codigo;
    }
}
