package xml.label;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "labels")
@XmlAccessorType(XmlAccessType.FIELD)
public class Labels {
    @XmlElement(name = "label")
    private List<Label> labels = new ArrayList<>();

    public Labels(List<Label> labels) {
        this.labels = labels;
    }

    public Labels() {
    }

    @Override
    public String toString() {
        return "Labels{" +
                "labels=" + labels +
                '}';
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
