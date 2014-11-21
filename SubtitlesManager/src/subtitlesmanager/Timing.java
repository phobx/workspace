package subtitlesmanager;

import java.util.regex.*;

/**
 *
 * @author yaroslav.hulaga
 * @version 0.1 A <code> Timing </code> operates with <code> Episode
 * </code>duration in seconds or as parsable String.
 */
public class Timing {

    public Timing(String Duration) {

        this.Availability = isParsable(Duration);

        if (this.Availability) {
            this.Seconds = toSecons(Duration);
            this.Duration = Duration;
        } else {
            this.Seconds = 0;
            this.Duration = "NA";
        }
    }

    public Timing(int Seconds) {
        this.Availability = true;
        this.Seconds = Seconds;
        this.Duration = this.toString();
    }

    /**
     *
     * @param Duration
     * @return Availability
     */
    private boolean isParsable(String Duration) {
        String s = Duration.trim();

        Pattern p = Pattern.compile("(\\d+):([0-5]\\d):([0-5]\\d)");
        Matcher m = p.matcher(s);
        if (m.find()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     *
     * @param Duration
     * @return
     */
    private int toSecons(String Duration) {
        String st = Duration.trim();

        Pattern p = Pattern.compile("(\\d+):([0-5]\\d):([0-5]\\d)");
        Matcher mt = p.matcher(st);
        mt.find();

        int h = Integer.parseInt(mt.group(1));
        int m = Integer.parseInt(mt.group(2));
        int s = Integer.parseInt(mt.group(3));
        return (h * 3600) + (m * 60) + s;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if (this.Availability) {
            int h = this.Seconds / 3600;
            int m = (this.Seconds % 3600) / 60;
            int s = this.Seconds % 60;

            return String.format("%02d:%02d:%02d", h, m, s);
        } else {
            return "NA";
        }
    }

    public int getSeconds() {
        return Seconds;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }
    /**
     * Availability of duration in seconds.
     */
    private boolean Availability;
    /**
     * Duration in seconds. e.g. 3096
     */
    private int Seconds;
    /**
     * Duration as String. e.g. "00:51:36" or "NA"
     */
    private String Duration;
}
