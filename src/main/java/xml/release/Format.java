package xml.release;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "format")
@XmlAccessorType(XmlAccessType.FIELD)
public class Format {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "qty")
    private Integer qty;
    @XmlAttribute(name = "text")
    private String text;
    @XmlElementWrapper(name = "descriptions")
    @XmlElement(name = "description")
    private List<String> descriptions = new ArrayList<>();

    public Format(String name, Integer qty, String text, List<String> descriptions) {
        this.name = name;
        this.qty = qty;
        this.text = text;
        this.descriptions = descriptions;
    }

    public Format() {
    }

    public String getName() {
        return Objects.toString(name, "");
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getText() {
        return Objects.toString(text, "");
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Format{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", text='" + text + '\'' +
                ", descriptions=" + descriptions +
                '}';
    }
}
