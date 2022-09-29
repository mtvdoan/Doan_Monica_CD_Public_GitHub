import java.util.HashMap; //*Imports the HasMap class */


public class MapOfTheHashmatique {
    
    public static void main(String[] args) {
        //*Create a HashMap object called 'trackList' */
        HashMap<String, String> trackList = new HashMap<String, String>();

        //*Add keys and values (Track(song name), Lyrics) */
        trackList.put("Misty's Song", "I love you...");
        trackList.put("Pokemon Opening", "I wanna be the very best.");
        trackList.put("Addicted to Spuds", "Potato skins...Potato cakes");
        trackList.put("Simple and Clean", "When you walk away, you don't hear me say,'Please...Oh, Baby...Don't go...'");

        //*Interate through the map and printing out the set with 'Track: Lyric' format */
        //* 'i' is the track name and trackList.get(i) gets the lyrics associated with the track name (i) */
        for (String i: trackList.keySet()){
            System.out.println(i + " : " + trackList.get(i) + "\n");
        }

        //*print out the Map */
        // System.out.println(trackList);


        //*Get by trackList name */
        System.out.println("\n\nThis is the lyrics for the Track 'Simple and Clean':");
        System.out.println(trackList.get("Simple and Clean"));
    }
}

