package xml.artist;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "artist")
@XmlAccessorType(XmlAccessType.FIELD)
public class Artist {
    @XmlElement(name = "id")
    private Integer id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "realname")
    private String realName;

    @XmlElement(name = "profile")
    private String profile;

    @XmlElement(name = "data_quality")
    private String dataQuality;

    @XmlElementWrapper(name = "urls")
    @XmlElement(name = "url")
    private List<String> urls = new ArrayList<>();

    @XmlElementWrapper(name = "namevariations")
    @XmlElement(name = "name")
    private List<String> nameVariations = new ArrayList<>();

    @XmlElementWrapper(name = "groups")
    @XmlElement(name = "name")
    private List<GroupName> groupNames = new ArrayList<>();

    public Artist(Integer id, String name, String realName, String profile, String dataQuality, List<String> urls, List<String> nameVariations, List<GroupName> groupNames) {
        this.id = id;
        this.name = name;
        this.realName = realName;
        this.profile = profile;
        this.dataQuality = dataQuality;
        this.urls = urls;
        this.nameVariations = nameVariations;
        this.groupNames = groupNames;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getNameVariations() {
        return nameVariations;
    }

    public void setNameVariations(List<String> nameVariations) {
        this.nameVariations = nameVariations;
    }

    public List<GroupName> getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(List<GroupName> groupNames) {
        this.groupNames = groupNames;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                ", profile='" + profile + '\'' +
                ", dataQuality='" + dataQuality + '\'' +
                ", urls=" + urls +
                ", nameVariations=" + nameVariations +
                ", groupNames=" + groupNames +
                '}';
    }
}
