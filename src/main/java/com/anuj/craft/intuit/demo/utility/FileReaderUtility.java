package com.anuj.craft.intuit.demo.utility;

import com.anuj.craft.intuit.demo.model.Player;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class FileReaderUtility {

    private static final String FILE_LOCATION = "/Users/anujvishwakarma/Desktop/topic.txt";

    public  Map<Integer,Player> readFileData() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_LOCATION);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        Map<Integer,Player> map= new TreeMap<>(Collections.reverseOrder());
        while ((st = br.readLine()) != null) {
            try {
                Player player = mapper.readValue(st, Player.class);
                map.put(player.getScore(),player);
            } catch (JsonGenerationException e) {

                e.printStackTrace();

            } catch (JsonMappingException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

       return map;
    }

//    public static void main(String[] args) throws IOException {
//        readFileData();
//    }
}
