package utils;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonFileReader  {

	public static String getJsonValue(String jsonInputFile, String jsonfield){
		String field = null; 
		try {
			InputStream is = new FileInputStream(jsonInputFile);
			JsonReader reader = Json.createReader(is);
			JsonObject fileObj = reader.readObject();
			reader.close();
			if (fileObj.getString(jsonfield) != null) {
				field = fileObj.getString(jsonfield);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return field;
	}
	
	@SuppressWarnings("null")
	public static List<String> getJsonValues(FileReader jsonInputFile, String array){
		List<String> fields = new ArrayList<String>();
		
		JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(jsonInputFile);

            JSONObject jsonObject = (JSONObject) obj;

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get(array);
            @SuppressWarnings("unchecked")
			Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                fields.add(iterator.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
		return fields;
	}
}