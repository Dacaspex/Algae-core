package main;

import logging.Logger;
import server.Server;

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