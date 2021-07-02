package model;

import java.time.LocalDateTime;

public class Tarea {
    public int Id;
    public String Nombre;
    public LocalDateTime FechaDeCreacion;
    public String Estado;

    public Tarea(int unId, String unNombre,String unEstado) {
        Id = unId;
        Nombre = unNombre;
        FechaDeCreacion = LocalDateTime.now();
        Estado = unEstado;

    }
    public Tarea() { }

    public void setEstado (String unEstado) {Estado = unEstado;}




}

//una api es una interfaz entre dos sistemas request (put post get delete) y response (tienen status code)
// url representa un recurso particular y va de lo mas global a lo mas puntual (como puede ser dominio/usuarios/nombre) ejemplo de insta

