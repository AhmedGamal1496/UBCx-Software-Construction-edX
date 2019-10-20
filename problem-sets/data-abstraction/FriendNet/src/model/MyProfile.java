package model;

import java.util.LinkedList;
import java.util.List;

public class MyProfile {

    private String name;
    private int age;
    private String currentLocation;
    private String workPlace;
    private List<MyProfile> friendsList;
    private List<Event> upcomingEvents;

    public MyProfile(String nm, int age, String locn, String work) {
        // TODO: complete the implementation of this method
        this.name = nm;
        this.age = age;
        this.currentLocation = locn;
        this.workPlace = work;
        friendsList = new LinkedList<>();
        upcomingEvents = new LinkedList<>();
    }

    // getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCurrentLocation() { return currentLocation; }
    public String getWorkPlace() { return workPlace; }
    public List<MyProfile> getFriendsList() { return friendsList; }
    public List<Event> getEventList() { return upcomingEvents; }
    public int upcomingEventNum() { return upcomingEvents.size(); }


    // REQUIRES: f is not already in friendsList
    // MODIFIES: this
    // EFFECTS: consumes a MyProfile object, a friend f, and adds it to the friendsList
    public void addFriend(MyProfile f) {
        // TODO: complete the implementation of this method
        this.friendsList.add(f);
    }

    // MODIFIES: this
    // EFFECTS: removes a friend with the given name from this. If removal is successful, return true, else
    //          return false
    public boolean unFriend(String nm) {
        // TODO: complete the implementation of this method
        for (MyProfile profile : friendsList) {
            if (profile.getName() == nm) {
                this.friendsList.remove(profile);
                return true;
            }
        }
        return false;
    }

    // REQUIRES: ev is not in upcomingEvents
    // MODIFIES: this
    // EFFECTS: adds the given event to the list of upcoming events
    public void addEvent(Event ev) {
        // TODO: complete the implementation of this method
        this.upcomingEvents.add(ev);
    }

    // MODIFIES: this
    // EFFECTS: removes an event with the given name. If removal is successful, return true, else return false
    public boolean removeEvent(String nm) {
        // TODO: complete the implementation of this method
        for (Event event : upcomingEvents) {
            if (event.getName().equals(nm)) {
                this.upcomingEvents.remove(event);
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns the number of events that are at the current location of this person
    public int eventNumNearMe() {
        // TODO: complete the implementation of this method
        int number = 0;

        for (Event event : upcomingEvents) {
            if (event.getLocation().equals(this.currentLocation)) {
                number++;
            }
        }
        return number;
    }

    // EFFECTS: returns the number of events of the given type et
    public int specificEventType(EventType et) {
        // TODO: complete the implementation of this method
        int num = 0;

        for (Event event : upcomingEvents) {
            if (event.getEventType().equals(et)) {
                num++;
            }
        }
        return num;
    }

    // EFFECTS: prints events of  type et to the console
    //          Hint: is there a method you have already written that you can use?
    public void printEventSchedule(EventType et) {
        // TODO: complete the implementation of this method
        for (Event event : upcomingEvents) {
            if (event.getEventType().equals(et)) {
                System.out.println(event);
            }
        }
    }

    // EFFECTS: prints out the list of friends that this MyProfile has
    public void printFriendNames() {
        // TODO: complete the implementation of this method
        for (MyProfile friend : friendsList) {
            System.out.println(friend.getName());
        }
    }

    // EFFECTS: prints out the names of friends who live at the same location associated with this profile
    public void printFriendsNearMe() {
        // TODO: complete the implementation of this method
        for (MyProfile friend : friendsList) {
            if (this.getCurrentLocation() == friend.getCurrentLocation()) {
                System.out.println(friend.getName());
            }
        }
    }

    // EFFECTS: produces true if this profile has a friend with the given name,
    //          OR if any of this profile's friends has a friend with the given name
    //          Hint: use recursion!
    public boolean canFindPerson(String name) {
        if (this.friendsList.isEmpty()) return false;

        for (MyProfile p : friendsList) {
            if (p.getName().equals(name)) {
                return true;
            }
        }

        for (MyProfile p : friendsList) {
            if (p.canFindPerson(name)) {
                return true;
            }
        }

        return false;
    }


}
