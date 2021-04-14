package server;

import controller.TareaController;
import spark.Spark;

public class Router {
    public static TareaController tareitas = new TareaController();
    public static void configure() {
        Spark.get("/tareas", tareitas::getTarea);
        Spark.post("/tareas", tareitas::postTarea);
        Spark.delete("/tareas", tareitas::deleteTarea);
        Spark.put("/tareas", tareitas::cambiarEstado);
    }
}
