package xml.release;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "master_id")
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterId {
    @XmlAttribute(name = "is_main_release")
    private Boolean isMainRelease;

    @XmlValue
    private Integer value;

    public MasterId(Boolean isMainRelease, Integer value) {
        this.isMainRelease = isMainRelease;
        this.value = value;
    }

    public MasterId() {
    }

    public Boolean getIsMainRelease() {
        return isMainRelease;
    }

    public void setIsMainRelease(Boolean isMainRelease) {
        this.isMainRelease = isMainRelease;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MasterId{" +
                "isMainRelease=" + isMainRelease +
                ", value='" + value + '\'' +
                '}';
    }
}
