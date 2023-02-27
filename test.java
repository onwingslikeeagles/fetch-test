import java.io.*;
import java.util.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JSONReadFromTheFileTest {
   public static void main(String[] args) {
      JSONParser parser = new JSONParser();
      try {
         Object obj = parser.parse(new FileReader("/Users/baile/OneDrive/Documents/git-repos/fetch-test/hiring.json"));
         JSONArray jsonArray = (JSONArray)obj;

	   Collections.sort(jsonArray, new Comparator<JSONObject>() {
         private static final String KEY_NAME = "listId";

         @Override
         public int compare(JSONObject a, JSONObject b) {
            String valA = new String();
            String valB = new String();

            try {
                valA = (String) a.get(KEY_NAME);
                valB = (String) b.get(KEY_NAME);
            } 
            catch (JSONException e) {
                e.printStackTrace();
            }

            return valA.compareTo(valB);
         }
         });

	   Collections.sort(jsonArray, new Comparator<JSONObject>() {
         private static final String KEY_NAME = "name";

         @Override
         public int compare(JSONObject a, JSONObject b) {
            String valA = new String();
            String valB = new String();

            try {
                valA = (String) a.get(KEY_NAME);
                valB = (String) b.get(KEY_NAME);
            } 
            catch (JSONException e) {
                e.printStackTrace();
            }

            return valA.compareTo(valB);
         }
         });
		
	   int jsonArrayCount = 0;
	   while(jsonArray.jsonObject(jsonArrayCount) != null) {
		   if(jsonArray.jsonObject(jsonArrayCount).get("name") != null && jsonArray.jsonObject(jsonArrayCount).get("name") != "") {
			System.out.println("ListId: " + jsonArray.jsonObject(jsonArrayCount).get("listId") + " Name: " + jsonArray.jsonObject(jsonArrayCount).get("name"));
		   }

		   jsonArrayCount++;
	   }
	}
	catch(Exeception e) {
		e.printStackTrace();
	}
  }
}