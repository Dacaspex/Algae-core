package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Handles incoming requests from the client and can send data back
 */
public class Server {

    /**
     * Port to run on
     */
    private final static int port = 8181;

    /**
     * Indicates whether the server should be running or not
     */
    private boolean running;

    /**
     * Actual server socket
     */
    private ServerSocket server;

    /**
     * Client socket
     */
    private Socket client;

    /**
     * Input stream reader. Has the incoming data from the client
     */
    private BufferedReader reader;

    /**
     * Output stream, this allows for communication back to the client
     */
    private PrintStream printStream;

    /**
     * Constructor
     *
     * @throws IOException if an I/O error occurs when opening the socket.
     */
    public Server() throws IOException {

        this.server = new ServerSocket(port);

    }

    /**
     * Waits for the client to connect to the server and initialises input and output streams
     *
     * @throws IOException if an I/O error occurs when waiting for a connection.
     */
    public void connect() throws IOException {

        // Connect with the client
        client = server.accept();
        running = true;

        // Setup communication channels
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        printStream = new PrintStream(client.getOutputStream());

    }

    /**
     * Starts listening for input
     *
     * @throws IOException If an I/O error occurs
     */
    public void start() throws IOException {

        while (running) {

            String input = reader.readLine();
            // TODO Parse input into json object

        }

    }

}
