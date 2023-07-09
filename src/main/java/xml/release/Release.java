package xml.release;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "release")
@XmlAccessorType(XmlAccessType.FIELD)
public class Release {
    @XmlAttribute(name = "id")
    private Integer id;
    @XmlAttribute(name = "status")
    private String status;

    @XmlElementWrapper(name = "artists")
    @XmlElement(name = "artist")
    private List<Artist> artists = new ArrayList<>();

    @XmlElement(name = "title")
    private String title;

    @XmlElementWrapper(name = "labels")
    @XmlElement(name = "label")
    private List<Label> labels = new ArrayList<>();

    @XmlElementWrapper(name = "extraartists")
    @XmlElement(name = "artist")
    private List<Artist> extraArtists = new ArrayList<>();


    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "genre")
    private List<String> genres = new ArrayList<>();


    @XmlElementWrapper(name = "styles")
    @XmlElement(name = "style")
    private List<String> styles = new ArrayList<>();

    @XmlElement(name = "country")
    private String country;

    @XmlElement(name = "released")
    private String released;

    @XmlElement(name = "notes")
    private String notes;

    @XmlElement(name = "data_quality")
    private String dataQuality;

    @XmlElement(name = "master_id")
    private MasterId masterId;

    @XmlElementWrapper(name = "tracklist")
    @XmlElement(name = "track")
    private List<Track> tracklist = new ArrayList<>();

    @XmlElementWrapper(name = "identifiers")
    @XmlElement(name = "identifier")
    private List<Identifier> identifiers = new ArrayList<>();

    @XmlElementWrapper(name = "formats")
    @XmlElement(name = "format")
    private List<Format> formats = new ArrayList<>();

    @XmlElementWrapper(name = "companies")
    @XmlElement(name = "company")
    private List<Company> companies = new ArrayList<>();

    public Release() {
    }

    public Release(Integer id,
                   String status,
                   List<Artist> artists,
                   String title,
                   List<Label> labels,
                   List<Artist> extraArtists,
                   List<String> genres,
                   List<String> styles,
                   String country,
                   String released,
                   String notes,
                   String dataQuality,
                   MasterId masterId,
                   List<Track> tracklist,
                   List<Identifier> identifiers,
                   List<Format> formats,
                   List<Company> companies) {
        this.id = id;
        this.status = status;
        this.artists = artists;
        this.title = title;
        this.labels = labels;
        this.extraArtists = extraArtists;
        this.genres = genres;
        this.styles = styles;
        this.country = country;
        this.released = released;
        this.notes = notes;
        this.dataQuality = dataQuality;
        this.masterId = masterId;
        this.tracklist = tracklist;
        this.identifiers = identifiers;
        this.formats = formats;
        this.companies = companies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return Objects.toString(status, "");
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<Artist> getExtraArtists() {
        return extraArtists;
    }

    public void setExtraArtists(List<Artist> extraArtists) {
        this.extraArtists = extraArtists;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    public MasterId getMasterId() {
        return masterId;
    }

    public void setMasterId(MasterId masterId) {
        this.masterId = masterId;
    }

    public List<Track> getTracklist() {
        return tracklist;
    }

    public void setTracklist(List<Track> tracklist) {
        this.tracklist = tracklist;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public List<Format> getFormats() {
        return formats;
    }

    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "Release{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", artists=" + artists +
                ", title='" + title + '\'' +
                ", labels=" + labels +
                ", extraArtists=" + extraArtists +
                ", genres=" + genres +
                ", styles=" + styles +
                ", country='" + country + '\'' +
                ", released='" + released + '\'' +
                ", notes='" + notes + '\'' +
                ", dataQuality='" + dataQuality + '\'' +
                ", masterId=" + masterId +
                ", tracklist=" + tracklist +
                ", identifiers=" + identifiers +
                ", formats=" + formats +
                ", companies=" + companies +
                '}';
    }
}
