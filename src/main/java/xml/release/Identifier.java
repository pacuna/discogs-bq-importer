package xml.release;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "identifier")
@XmlAccessorType(XmlAccessType.FIELD)
public class Identifier {
    @XmlAttribute(name = "type")
    private String type;
    @XmlAttribute(name = "description")
    private String description;
    @XmlAttribute(name = "value")
    private String value;

    public Identifier(String type, String description, String value) {
        this.type = type;
        this.description = description;
        this.value = value;
    }

    public Identifier() {
    }

    public String getType() {
        return Objects.toString(type, "");
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return Objects.toString(description, "");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return Objects.toString(value, "");
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
