package model;

import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TareaRepo {
    public ArrayList<Tarea> tareas = new ArrayList<Tarea>();

    public void agregarTarea(Tarea unaTarea) {
        unaTarea.FechaDeCreacion = LocalDateTime.now();
        tareas.add(unaTarea);
    }

    public void borrarTarea(Tarea unaTarea) {
        tareas.remove(unaTarea);
    }

    public void cambiarEstado(Tarea unaTarea, String unEstado) {
        unaTarea.Estado = unEstado;
    }

    public Tarea getTarea(int unID) {
        for (Tarea unaTarea : tareas) {
            if (unaTarea.Id == unID) {
                return unaTarea;
            }
        } throw new RuntimeException("No Existe esa tarea");
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
    //Session session = factory.openSession();
//session.doWork(new Work() {
  //      @Override
    //    public void execute(Connection connection) throws SQLException {
            //You got a connection
    //    }
   // });
    }