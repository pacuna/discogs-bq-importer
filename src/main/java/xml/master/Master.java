package xml.master;

import xml.release.Artist;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "master")
@XmlAccessorType(XmlAccessType.FIELD)
public class Master {
    @XmlAttribute(name = "id")
    private Integer id;

    @XmlElement(name = "main_release")
    private Integer mainRelease;

    @XmlElementWrapper(name = "artists")
    @XmlElement(name = "artist")
    private List<Artist> artists = new ArrayList<>();

    @XmlElementWrapper(name = "styles")
    @XmlElement(name = "style")
    private List<String> styles = new ArrayList<>();

    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "genre")
    private List<String> genres = new ArrayList<>();

    @XmlElement(name = "year")
    private String year;

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "data_quality")
    private String dataQuality;

    public Master(Integer id,
                  Integer mainRelease,
                  List<Artist> artists,
                  List<String> styles,
                  List<String> genres,
                  String year,
                  String title,
                  String dataQuality) {
        this.id = id;
        this.mainRelease = mainRelease;
        this.artists = artists;
        this.styles = styles;
        this.genres = genres;
        this.year = year;
        this.title = title;
        this.dataQuality = dataQuality;
    }

    public Master() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainRelease() {
        return mainRelease;
    }

    public void setMainRelease(Integer mainRelease) {
        this.mainRelease = mainRelease;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", mainRelease='" + mainRelease + '\'' +
                ", artists=" + artists +
                ", styles=" + styles +
                ", genres=" + genres +
                ", year='" + year + '\'' +
                ", title='" + title + '\'' +
                ", dataQuality='" + dataQuality + '\'' +
                '}';
    }
}
