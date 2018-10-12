package hust.edu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Session extends HustObject implements Comparable<Session> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE HH:mm");

    private Date start;
    private Date end;
    private Room room;
    private Class whichClass;

    Session(String id, String startDate, String endDate, Room room, Class whichClass) {
        super(id);
        this.setStart(this.parseDate(startDate));
        this.setEnd(this.parseDate(endDate));
        this.setRoom(room);
        this.setWhichClass(whichClass);
    }

    private Date parseDate(String dateString) {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    private int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public int compareTo(Session other) {
        return Integer.compare(getDayOfWeek(this.start), getDayOfWeek(other.start));
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Class getWhichClass() {
        return whichClass;
    }

    public void setWhichClass(Class whichClass) {
        this.whichClass = whichClass;
    }
}
