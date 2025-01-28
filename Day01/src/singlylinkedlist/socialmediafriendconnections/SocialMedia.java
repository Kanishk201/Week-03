package singlylinkedlist.socialmediafriendconnections;

import java.util.ArrayList;
class SocialMedia {
    private User head;

    // Add a new user
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Find a user by User ID
    private User findUserByID(int userID) {
        User current = head;
        while (current != null) {
            if (current.userID == userID) return current;
            current = current.next;
        }
        return null;
    }

    // Find a user by Name
    private User findUserByName(String name) {
        User current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) return current;
            current = current.next;
        }
        return null;
    }

    // Add a friend connection
    public void addFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIDs.contains(userID2)) {
            user1.friendIDs.add(userID2);
        }
        if (!user2.friendIDs.contains(userID1)) {
            user2.friendIDs.add(userID1);
        }
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove a friend connection
    public void removeFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIDs.remove((Integer) userID2);
        user2.friendIDs.remove((Integer) userID1);
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Find mutual friends
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.print("Mutual friends between " + user1.name + " and " + user2.name + ": ");
        ArrayList<Integer> mutualFriends = new ArrayList<>();
        for (int friendID : user1.friendIDs) {
            if (user2.friendIDs.contains(friendID)) {
                mutualFriends.add(friendID);
            }
        }

        if (mutualFriends.isEmpty()) {
            System.out.println("None");
        } else {
            for (int id : mutualFriends) {
                User mutualFriend = findUserByID(id);
                if (mutualFriend != null) {
                    System.out.print(mutualFriend.name + " ");
                }
            }
            System.out.println();
        }
    }

    // Display all friends of a user
    public void displayFriends(int userID) {
        User user = findUserByID(userID);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friendIDs.isEmpty()) {
            System.out.println("No friends.");
        } else {
            for (int friendID : user.friendIDs) {
                User friend = findUserByID(friendID);
                if (friend != null) {
                    System.out.println("- " + friend.name);
                }
            }
        }
    }

    // Search for a user
    public void searchUser(int userID) {
        User user = findUserByID(userID);
        if (user == null) {
            System.out.println("User not found.");
        } else {
            System.out.println("User Found: " + user.name + ", ID: " + user.userID + ", Age: " + user.age);
        }
    }

    public void searchUser(String name) {
        User user = findUserByName(name);
        if (user == null) {
            System.out.println("User not found.");
        } else {
            System.out.println("User Found: " + user.name + ", ID: " + user.userID + ", Age: " + user.age);
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User current = head;
        while (current != null) {
            System.out.println(current.name + " has " + current.friendIDs.size() + " friends.");
            current = current.next;
        }
    }

    // Display all users
    public void displayUsers() {
        User current = head;
        if (current == null) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("All Users:");
        while (current != null) {
            System.out.println("Name: " + current.name + ", ID: " + current.userID + ", Age: " + current.age);
            current = current.next;
        }
    }
}
