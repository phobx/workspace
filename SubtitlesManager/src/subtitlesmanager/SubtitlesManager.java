package subtitlesmanager;

/**
 *
 * @author yaroslav.hulaga
 */
public class SubtitlesManager {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Timing t1 = new Timing(1);
        Timing t2 = new Timing("1:51:00");
        Timing t3 = new Timing("0:52:42");
        Timing t = new Timing(t1.getSeconds() + t2.getSeconds() + t3.getSeconds());
        System.out.println(t.toString());
        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }
}
