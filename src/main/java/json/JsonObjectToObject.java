package json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonObjectToObject {
    public static void main(String[] args) {
        String studentJsonString = """
                {
                    "name": "Tom",
                    "age": 12
                }
                """;

        Gson gson = new Gson();
        JsonObject jsonObject = JsonParser.parseString(studentJsonString).getAsJsonObject();

        // Json Object to Object
        StudentEntity student = gson.fromJson(jsonObject, StudentEntity.class);

        System.out.println(student);
    }
}

