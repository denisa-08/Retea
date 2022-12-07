package ui;
import domain.validators.ValidationException;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

/**
 * Class that helps to interact with the users
 */
public class Console {
    final private Scanner in = new Scanner(System.in);
    private final Service service;


    public Console(Service service) {
        this.service = service;
    }

    /**
     * Adds a user with the data provided by the client
     * @throws InputMismatchException if input is not valid for the expected type
     * @throws IllegalArgumentException if there is an illegal or unsuitable argument passed to the method
     * @throws ValidationException if the user's attributes are invalid
     */
    public void addUserUI() throws InputMismatchException, IllegalArgumentException, ValidationException {
        System.out.print("First name: ");
        String firstName = in.next();
        System.out.print("Last name: ");
        String lastName = in.next();
        System.out.print("Email: ");
        String email = in.next();
        service.addUser(firstName, lastName, email);
    }

    /**
     * Removes a user by the id
     * @throws InputMismatchException if input is not valid for the expected type
     * @throws IllegalArgumentException if there is an illegal or unsuitable argument passed to the method
     */
    public void removeUserUI() throws InputMismatchException, IllegalArgumentException {
        service.printAll();
        System.out.print("User ID: ");
        //long id = in.nextLong();
        String id = in.next();
        UUID id_converted = UUID.fromString(id);
        service.removeUser(id_converted);
    }

    /**
     * Creates a friendship between 2 users by their ids, with the ids provided by client
     */
    public void addFriendUI() {
        service.printAll();
        System.out.print("User1 ID: ");
        //long id1 = in.nextLong();
        String id1 = in.next();
        UUID id1_converted = UUID.fromString(id1);
        System.out.print("User2 ID: ");
        //long id2 = in.nextLong();
        String id2 = in.next();
        UUID id2_converted = UUID.fromString(id2);
        service.addFriend(id1_converted, id2_converted);
    }

    /**
     * Removes a friendship between 2 users by their ids, with the ids provided by client
     */
    public void removeFriendUI() {
        service.printAllWithFriends();
        System.out.print("User1 ID: ");
        //long id1 = in.nextLong();
        String id1 = in.next();
        UUID id1_converted = UUID.fromString(id1);
        System.out.print("User2 ID: ");
        //long id2 = in.nextLong();
        String id2 = in.next();
        UUID id2_converted = UUID.fromString(id2);
        service.removeFriend(id1_converted, id2_converted);
    }


    /**
     * Function to start the application
     */
    public void start() {
        boolean done = false;
        while(!done) {
            System.out.print("Menu \n\t1 - add user\n\t2 - remove user\n\t3 - add friend\n\t4 - remove friend\n\t5 - all users" +
                    "\n\t6 - all users with their friends\n\t7 - exit\n");
            try {
                System.out.println("Command ");
                int cmd = in.nextInt();

                switch(cmd) {
                    case 1:
                    {
                        addUserUI();
                        break;
                    }

                    case 2:
                    {
                        removeUserUI();
                        break;
                    }

                    case 3:
                    {
                        addFriendUI();
                        break;
                    }

                    case 4:
                    {
                        removeFriendUI();
                        break;
                    }

                    case 5:
                    {
                        //System.out.println("Number of communities: " + service.numberofCommunities());
                        service.printAll();
                        break;
                    }

                    case 6:
                    {
                        service.printAllWithFriends();
                        break;
                    }

                    case 7:
                    {
                        done=true;
                    }

                    default:
                        break;
                }
            }
            catch (InputMismatchException exception) {
                System.err.println("Not an integer");
                if(in.next().isEmpty())
                    break;
            }
            catch (IllegalArgumentException | ValidationException exception) {
                System.err.println(exception);
            }
        }
        in.close();
    }

}
