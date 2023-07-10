package xml.labelrenamed;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "label")
@XmlAccessorType(XmlAccessType.FIELD)
public class Label {
    @XmlElement(name = "id")
    private Integer id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "contactinfo")
    private String contactInfo;

    @XmlElement(name = "profile")
    private String profile;

    @XmlElement(name = "data_quality")
    private String dataQuality;

    @XmlElementWrapper(name = "urls")
    @XmlElement(name = "url")
    private List<String> urls = new ArrayList<>();

    @XmlElementWrapper(name = "sublabels")
    @XmlElement(name = "sublabel")
    private List<SubLabel> subLabels = new ArrayList<>();

    public Label() {
    }

    public Label(Integer id,
                 String name,
                 String contactInfo,
                 String profile,
                 String dataQuality,
                 List<String> urls,
                 List<SubLabel> subLabels) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.profile = profile;
        this.dataQuality = dataQuality;
        this.urls = urls;
        this.subLabels = subLabels;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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

    public List<SubLabel> getSubLabels() {
        return subLabels;
    }

    public void setSubLabels(List<SubLabel> subLabels) {
        this.subLabels = subLabels;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", profile='" + profile + '\'' +
                ", dataQuality='" + dataQuality + '\'' +
                ", urls=" + urls +
                ", subLabels=" + subLabels +
                '}';
    }
}
