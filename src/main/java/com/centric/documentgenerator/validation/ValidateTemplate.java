package com.centric.documentgenerator.validation;

import com.aspose.words.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@RestController
public class ValidateTemplate {

    @PostMapping("template-validation")
    public ResponseEntity<TreeSet<String>> validateTemplate(){
        TreeSet<String> tags  = new TreeSet<>();
        tags.add("James");
        tags.add("John");
//        String inputPath = "src/main/resources/document/foodLabel.docx";
//        try{
//            Document template = new Document(inputPath);
//
//            // Extract text from the document
//            NodeCollection<?> allNodes = template.getChildNodes(NodeType.RUN, true);
//            for (Node node : allNodes) {
//                if (node instanceof Run run) {
//                    // System.out.println(run);
//                    String text = run.getText().strip().trim();
//                    //System.out.println(text);
//                    String key = TemplateValidatorFunction.isValidTemplate(text);
//                    if(key != null){
//                        tags.add(key);
//                    }
//                }
//            }
//            return ResponseEntity.ok().body(tags);
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
        return ResponseEntity.ok().body(tags);
    }
}
