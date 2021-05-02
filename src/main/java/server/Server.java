package server;

import spark.Filter;
import spark.Spark;

import static spark.Spark.after;

public class Server {
    public static void main (String[] args){

        Spark.port(9047);
        Router.configure();
    }

}
