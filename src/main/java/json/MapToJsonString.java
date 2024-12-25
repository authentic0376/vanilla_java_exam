package json;

import com.google.gson.Gson;

import java.util.Map;

public class MapToJsonString {
    public static void main(String[] args) {
        Map<String, Object> map = Map
                .of(
                        "A", 123,
                        "B", "sdfe");

        Gson gson = new Gson();
        String jsonString = gson.toJson(map);
        System.out.println("jsonString = " + jsonString);

        // jsonString = {"B":"sdfe","A":123}
    }
}
