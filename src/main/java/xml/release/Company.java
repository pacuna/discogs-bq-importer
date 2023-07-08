package xml.release;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    @XmlElement(name="id")
    private Integer id;
    @XmlElement(name="name")
    private String name;
    @XmlElement(name="catno")
    private String catNo;
    @XmlElement(name="entity_type")
    private Integer entityType;
    @XmlElement(name="entity_type_name")
    private String entityTypeName;
    @XmlElement(name="resource_url")
    private String resourceUrl;

    public Company() {
    }

    public Company(Integer id, String name, String catNo, Integer entityType, String entityTypeName, String resourceUrl) {
        this.id = id;
        this.name = name;
        this.catNo = catNo;
        this.entityType = entityType;
        this.entityTypeName = entityTypeName;
        this.resourceUrl = resourceUrl;
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

    public String getCatNo() {
        return catNo;
    }

    public void setCatNo(String catNo) {
        this.catNo = catNo;
    }

    public Integer getEntityType() {
        return entityType;
    }

    public void setEntityType(Integer entityType) {
        this.entityType = entityType;
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        this.entityTypeName = entityTypeName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catNo=" + catNo +
                ", entityType=" + entityType +
                ", entityTypeName='" + entityTypeName + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                '}';
    }
}
