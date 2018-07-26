package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class DriverCalendar {
    private Map<Date, ArrayList<String>> dairy;

    public ArrayList<String> getWorkingHours(Date date) {
        return dairy.get(date);
    }

    public void setWorkingHours(Date date, ArrayList<String> hours) {
        dairy.put(date, hours);
    }
}
