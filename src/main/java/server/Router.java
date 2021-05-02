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
            response.header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");//header a la respuesta, cors protocolo standard para conectar https
            response.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
            response.header("Access-Control-Allow-Credentials", "true");

        });
        Spark.get("/tarea", tareitas::getTarea);
        Spark.post("/tarea", tareitas::postTarea);
        Spark.delete("/tarea", tareitas::deleteTarea);
        Spark.put("/tarea", tareitas::cambiarEstado);
        Spark.get("/tareas", tareitas::getTareas);
    }
}
