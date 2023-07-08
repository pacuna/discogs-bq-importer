package xml.release;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "artist")
@XmlAccessorType(XmlAccessType.FIELD)
public class Artist {
    @XmlElement(name = "id")
    private Integer id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "anv")
    private String anv;
    @XmlElement(name = "join")
    private String join;
    @XmlElement(name = "tracks")
    private String tracks;

    public Artist(Integer id, String name, String anv, String join, String tracks) {
        this.id = id;
        this.name = name;
        this.anv = anv;
        this.join = join;
        this.tracks = tracks;
    }

    public Artist() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnv() {
        return anv;
    }

    public void setAnv(String anv) {
        this.anv = anv;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", anv='" + anv + '\'' +
                ", join='" + join + '\'' +
                ", tracks='" + tracks + '\'' +
                '}';
    }
}
