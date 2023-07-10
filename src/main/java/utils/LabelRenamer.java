package utils;

import xml.label.Labels;
import xml.labelrenamed.SubLabel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LabelRenamer {

    public static void rename(String input) throws JAXBException, IOException {
        xml.label.Labels inputLabels = unmarshall(input);
        xml.labelrenamed.Labels outputLabels = new xml.labelrenamed.Labels();
        List<xml.labelrenamed.Label> outputLabelsList = new ArrayList<>();

        for (xml.label.Label sl: inputLabels.getLabels()) {

            List<xml.labelrenamed.SubLabel> renamed = new ArrayList<>();
            for (xml.label.SubLabel ssl: sl.getSubLabels()){
               xml.labelrenamed.SubLabel labelRenamed = new xml.labelrenamed.SubLabel();
               labelRenamed.setId(ssl.getId());
               labelRenamed.setValue(ssl.getValue());
               renamed.add(labelRenamed);
            }

            xml.labelrenamed.Label newLabel = new xml.labelrenamed.Label();
            newLabel.setId(sl.getId());
            newLabel.setContactInfo(sl.getContactInfo());
            newLabel.setName(sl.getName());
            newLabel.setProfile(sl.getProfile());
            newLabel.setUrls(sl.getUrls());
            newLabel.setProfile(sl.getProfile());
            newLabel.setDataQuality(sl.getDataQuality());
            newLabel.setSubLabels(renamed);
            outputLabelsList.add(newLabel);
            System.out.println("Label renamed");
        }
        outputLabels.setLabels(outputLabelsList);
        JAXBContext context = JAXBContext.newInstance(xml.labelrenamed.Labels.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(outputLabels, new File("./labels_renamed.xml"));
    }

    public static Labels unmarshall(String input) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Labels.class);
        return (Labels) context.createUnmarshaller()
                .unmarshal(new FileReader(input));
    }

    public static void main(String[] args) throws JAXBException, IOException {
        rename("src/main/resources/input_labels.xml");
    }
}
