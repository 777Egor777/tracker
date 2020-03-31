package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("There is no such user");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("Invalid User!!!");
        } else if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Length of User less than 3. Invalid!!");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("m5", true)
        };
        try {
            User user = findUser(users, "m5");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        }  catch (UserInvalidException userInvalidEx) {
            System.out.println("User is not valid!");
            userInvalidEx.printStackTrace();
        } catch (UserNotFoundException userNotFoundEx) {
            System.out.println("User is not found!");
            userNotFoundEx.printStackTrace();
        }
    }
}
