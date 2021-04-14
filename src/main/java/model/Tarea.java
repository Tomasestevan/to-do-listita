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
    public void setEstado (String unEstado) {Estado = unEstado;}


}