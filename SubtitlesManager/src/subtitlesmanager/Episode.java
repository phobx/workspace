/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package subtitlesmanager;

/**
 *
 * @author yaroslav.hulaga
 * @version 0.1
 * A <code> Episode </code> represents a single film unit in Ardome System.
 */
public class Episode {
    

    private /*final*/ String ArdomeID;
    private byte TypeID;
    private Series Series;
    private int EpisodeNumber;
    private String ArdomeName;
    private Timing Timing;
    private int EpisodeID;
    private String Type;
    private String Name;
    private String ArdomeLink;

    
    private static int ID;
    public static final String TypeOne = "Series";
    public static final String TypeTwo = "Movie";
    public static final String TypeThree = "Show";
    

}
