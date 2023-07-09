package xml.release;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "track")
@XmlAccessorType(XmlAccessType.FIELD)
public class Track {
    @XmlElement(name = "position")
    private String position;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "duration")
    private String duration;

    public Track(String position, String title, String duration) {
        this.position = position;
        this.title = title;
        this.duration = duration;
    }

    public Track() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "position='" + position + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
