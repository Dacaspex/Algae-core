package main;

public class Main {

    public static void main(String[] args) throws Exception {

        Server server = new Server();

        server.connect();
        server.start();

    }

}