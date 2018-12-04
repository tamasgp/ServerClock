package hu.hfctechnics.vaadin.serverclock.client.serverclock;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import java.util.Date;

public class ServerClockWidget extends HTML {

    public static final String CLASSNAME = "serverclock";
    private long time = 0;
    private Timer timer = null;
    private final Date date = new Date();
    private final DateTimeFormat timeFormat = DateTimeFormat.getFormat("HH:mm:ss");
    
    private String timeHtml = null;

    public ServerClockWidget() {
        
        setStyleName(CLASSNAME);

        timer = new Timer() {
            @Override
            public void run() {
                time = time + 1000;
                display();
            }
        };
        timer.scheduleRepeating(1000);
        
    }
    
    public void setTime(long t) {
            time = t;
    }
    
    private void display() {
        date.setTime(time);
        timeHtml = "<span>" + timeFormat.format(date) + "</span>";
        setHTML(timeHtml);
    }
}
