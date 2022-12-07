import domain.User;
import domain.validators.UserValidator;
import repository.RepositoryUserDB;
import ui.Console;
import service.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Console console = new Console(service);
        console.start();
    }
}