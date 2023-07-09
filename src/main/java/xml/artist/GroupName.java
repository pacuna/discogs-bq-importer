package xml.artist;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "name")
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupName {
    @XmlAttribute(name = "id")
    private Integer id;

    @XmlValue
    private String value;

    public GroupName(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public GroupName() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GroupName{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
