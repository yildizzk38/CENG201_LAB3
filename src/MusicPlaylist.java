/**
 * Represents the doubly linked list for the music playlist.
 *
 * Your Name:        Yıldız Karamahmut
 * Your Student ID:  240444039
 * Your Date:        19/10/2026
 */
public class MusicPlaylist {
    private SongNode head;
    private SongNode tail;
    private SongNode current;
    public MusicPlaylist() {
        this.head = null;
        this.tail = null;
        this.current = null;
    }
    // Add a song to the end of the playlist
    public void addSong(String title) {
        SongNode newNode = new SongNode(title);
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    // Remove a song from the playlist
    public void removeSong(String title) {
        SongNode temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("The song isn't in the playlist");
            return;
        }
        System.out.println("Removed: " + temp.title);
        // Case 1: Only one node in the list
        if (temp == head && temp == tail) {
            head = null;
            tail = null;
            current = null;
        } else if (temp == head) { // Case 2: Removing the head node
            head = head.next;
            head.prev = null;
        } else if (temp == tail) { // Case 3: Removing the tail node
            tail = tail.prev;
            tail.next = null;
        } else { // Case 4: Removing a node from the middle
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        // Update current if the removed song was currently playing
        if (current == temp) {
            current = (temp.next != null) ? temp.next : temp.prev;
        }
    }
    // Move to the next song
    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the last song of the playlist.");
        }
    }
    // Move to the previous song
    public void previousSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the first song of the playlist.");
        }
    }
    // Display the currently playing song
    public void displayCurrentSong() {
        if (current != null) {
            System.out.println("Current Song: " + current.title);
        }
    }
    // Display the entire playlist
    public void displayPlaylist() {
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp.title + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}