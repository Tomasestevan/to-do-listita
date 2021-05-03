package server;

import controller.TareaController;
import spark.Filter;
import spark.Spark;

import static spark.Spark.after;

public class Router {
    public static TareaController tareitas = new TareaController();
    public static void configure() {
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, HEAD, PUT, PATCH, POST, DELETE, OPTIONS");//header a la respuesta, cors protocolo standard para conectar https
            response.header("Access-Control-Allow-Headers", "Content-Type, Accept");

        });
        Spark.get("/tarea", tareitas::getTarea);
        Spark.post("/tarea", tareitas::postTarea);
        Spark.post("/deleteTarea", tareitas::deleteTarea); //aca deberia ir un .delete pero #corsproblems
        Spark.put("/tarea", tareitas::cambiarEstado);
        Spark.get("/tareas", tareitas::getTareas);
    }
}
