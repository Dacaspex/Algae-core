package main;

import logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {

        Logger.init();
        Logger.info("Starting up server...");

        Server server = new Server();

        server.connect();
        server.start();

        Logger.info("Done");

    }

}