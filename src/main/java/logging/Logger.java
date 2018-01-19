package logging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Logger {

    private static Path path;

    public static void init() throws IOException {

        path = Paths.get("core_log.txt");
        Files.delete(path);
        Files.write(path, ("").getBytes(), StandardOpenOption.CREATE);

    }

    public static void info(String message) throws IOException {

        LocalDateTime now = LocalDateTime.now();
        String time = "[" + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond() + "]";
        message = time + "[INFO] " + message;

        write(message);

    }

    private static void write(String message) throws IOException {

        Files.write(path, message.concat("\r\n").getBytes(), StandardOpenOption.APPEND);

    }

}
