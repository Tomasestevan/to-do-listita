package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import model.Tarea;
import model.TareaRepo;
import spark.Request;
import spark.Response;

public class TareaController {
    public TareaRepo Repo = new TareaRepo();

    public String postTarea(Request req, Response res) {
        Tarea tar = new Gson().fromJson(req.body(), Tarea.class);
        Repo.agregarTarea(tar);
        return ("oki LO HICIMOOOOOOS");
    }

    public String deleteTarea(Request req, Response res) {
        Tarea unatar = new Gson().fromJson(req.body(), Tarea.class);
        Tarea untarea = Repo.getTarea(unatar.Id);
        Repo.borrarTarea(untarea);
        return ("Eliminada");

    }

    public String getTarea(Request req, Response res) throws JsonProcessingException {
        Tarea unatar = new Gson().fromJson(req.body(), Tarea.class);
        Tarea unatarea = Repo.getTarea(unatar.Id);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(unatarea);
        return json;
    }

    public String cambiarEstado(Request req, Response res) throws JsonProcessingException {
        Tarea estado = new Gson().fromJson(req.body(), Tarea.class);
        Tarea cambio = Repo.getTarea(estado.Id);
        if (estado.Estado != null) {cambio.setEstado(estado.Estado);}
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(cambio);
            return json;
        }
    }

