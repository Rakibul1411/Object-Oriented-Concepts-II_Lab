import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<User> userList = Arrays.asList(
                new User(5, "azad", "rajshahi", "azad987"),
                new User(6, "sami", "dhaka", "sam789"),
                new User(7, "munna", "Bhola", "munna123"),
                new User(8, "azad", "rajshahi", "azad987")

        );

        Set<Integer> seenId = new HashSet<>();
        Set<String> seenUserName = new HashSet<>();
        List<User> uniqueUsers = new ArrayList<>();

        for (User user : userList) {
            if (!seenId.contains(user.getId()) && !seenUserName.contains(user.getUserName())) {
                seenId.add(user.getId());
                seenUserName.add(user.getUserName());
                uniqueUsers.add(user);
            }
        }

        PriorityQueue<User> userQueue = new PriorityQueue<>(uniqueUsers);

        while (!userQueue.isEmpty()) {
            System.out.println(userQueue.poll());
        }
    }
}
