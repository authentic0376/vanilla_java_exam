package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ComplexJsonStringToJsonObject {
    public static void main(String[] args) {

        String studentJsonString = """
                [
                    {
                    "name": "Tom",
                    "age": 12,
                    "address":
                        [
                            {
                                "city":"New York",
                                "country":"USA"
                            },
                            {
                                "city":"Los Angeles",
                                "country":"USA"
                            }
                        ]
                    },

                    {
                        "name": "Daniel",
                        "age": 13,
                        "address":
                            {
                                city : Chicago,
                                country : USA
                            }
                    }

                ]
                """;
        // jsonString can omit quotes for keys and values

        JsonArray studentJsonObejct = JsonParser.parseString(studentJsonString).getAsJsonArray();

        String danielCity = studentJsonObejct
                .get(1).getAsJsonObject() // Student Daniel
                .get("address").getAsJsonObject() // Address Daniel's address
                .get("city").getAsString(); // String Daniel's city
        System.out.printf("Danie's city: %s\n\n", danielCity); // Prints Chicago

        // Print the list of Tom's addresses
        JsonArray tomAddresses = studentJsonObejct
                .get(0).getAsJsonObject() // Student Tom
                .get("address").getAsJsonArray(); // Address[] Tom's address

        System.out.println("Tom's cities list:");
        for (JsonElement address : tomAddresses) {
            String city = address.getAsJsonObject().get("city").getAsString();
            System.out.printf("city: %s\n", city); // Prints each city in Tom's address list
        }

        // Since the JSON can contain arrays, objects, strings, etc.,
        // it is necessary to use the appropriate `getAs` methods for the expected type.
    }
}
