package main.java.pl.jakubmarcinkowski.projekt.client;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement
public class Event {
    private long id;
    private String ip;
    private EventType typOperacji;
    private String link;
    private String dataOperacji;

    public Event(String ip, EventType typOperacji, String link, String dataOperacji) {
        this.ip = ip;
        this.typOperacji = typOperacji;
        this.link = link;
        this.dataOperacji = dataOperacji;
    }

    public Event() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public EventType getTypOperacji() {
        return typOperacji;
    }

    public void setTypOperacji(EventType typOperacji) {
        this.typOperacji = typOperacji;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDataOperacji() {
        return dataOperacji;
    }

    public void setDataOperacji(String dataOperacji) {
        this.dataOperacji = dataOperacji;
    }
}
