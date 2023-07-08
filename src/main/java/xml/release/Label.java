package xml.release;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name="label")
@XmlAccessorType(XmlAccessType.FIELD)
public class Label {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "catno")
    private String catNo;
    @XmlAttribute(name = "id")
    private Integer id;

    public Label(String name, String catNo, Integer id) {
        this.name = name;
        this.catNo = catNo;
        this.id = id;
    }

    public Label() {
    }

    public String getName() {
        return Objects.toString(name, "");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatNo() {
        return Objects.toString(catNo, "");
    }

    public void setCatNo(String catNo) {
        this.catNo = catNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Label{" +
                "name='" + name + '\'' +
                ", catNo='" + catNo + '\'' +
                ", id=" + id +
                '}';
    }
}
