package com.anuj.craft.intuit.demo.utility;

import com.anuj.craft.intuit.demo.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.FileWriter;

@Component
public class FileWriterUtility {

    private static final String FILE_LOCATION = "/Users/anujvishwakarma/Desktop/topic.txt";
    private static final String NEW_LINE_SEPRATOR = "\n";

        public static void writeDataInTheFile(Player object) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            String msg = mapper.writeValueAsString(object);
            if(msg != null && !msg.isEmpty()) {
                try {
                    FileWriter fw = new FileWriter(FILE_LOCATION, true);
                    fw.write(msg+NEW_LINE_SEPRATOR);
                    fw.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("Success...");
            }
}

//    public static void main(String[] args) {
//        String msg  = "Janij";
//        FileWriterUtility fileWriterUtility = new FileWriterUtility();
//        fileWriterUtility.writeDataInTheFile(msg);
//    }
}
