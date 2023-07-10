package xml.label;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "label")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubLabel {
    @XmlAttribute(name = "id")
    private Integer id;

    @XmlValue
    private String value;

    public SubLabel(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public SubLabel() {
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
        return "SubLabel{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
