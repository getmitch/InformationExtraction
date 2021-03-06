package com.intel.ie;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.sequences.SeqClassifierFlags;
import edu.stanford.nlp.util.StringUtils;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import java.util.Properties;

public class TrainModel {
    public static void main(String[] args) {
        String path = "data/NERDepartment/department.prop";
        Properties props = StringUtils.propFileToProperties(path);

        SeqClassifierFlags flags = new SeqClassifierFlags(props);
        CRFClassifier<CoreLabel> crf = new CRFClassifier<CoreLabel>(flags);
        crf.train();
        String modelPath = props.getProperty("serializeTo");
        crf.serializeClassifier(modelPath);
        System.out.println("Build model to " + modelPath);
    }
}
