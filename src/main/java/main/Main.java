package main;

import fractal.JuliaFractal;
import logging.Logger;
import server.Server;
import util.math.Complex;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        Logger.init();
        Logger.info("Starting up server...");

        Server.init();
        Server server = Server.getServer();

        server.connect();
        server.start();

        Logger.info("Done");

    }

}