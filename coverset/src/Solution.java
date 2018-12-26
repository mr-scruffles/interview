import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.List;

public class Solution {

    public static class Item {
        String id;
        String name;
        Long price;
    }

    public static class Category {
        String id;
        String name;
        List<Item> items;
    }

    public static class Combo {
        String id;
        String name;
        Long discount;
        List<String> categories;
    }

    public static class Inventory {
        List<Category> categories;
        List<Combo> combos;
    }

    public static class OrderInfo {
        Long id;
        List<String> items;
    }

    public static class InputData {
        Inventory inventory;
        List<OrderInfo> orders;
    }

    public static void main(String[] args) {
        try {
            Gson gson = new GsonBuilder().create();

            // Read in the inventory and the orders
            InputStream inputStream       = new FileInputStream("/home/ryan/interview/coverset/src/input1.json");
//            InputStreamReader inp = new InputStreamReader(System.in);
            InputStreamReader inp = new InputStreamReader(inputStream);

            BufferedReader br = new BufferedReader(inp);
            InputData input = gson.fromJson(br, InputData.class);

            // Create some objects that contain the categories and combos for possible use
            List<Category> categories = input.inventory.categories;
            List<Combo> combos = input.inventory.combos;

            // Loop over each test order and construct it
            for (OrderInfo order:input.orders) {
                System.out.println("Order : " + order.id);
                for (String itemId:order.items) {
                    System.out.println("  Adding item : " + itemId);
                    // Calculate the current combos

                    // Add code here, feel free to add / edit any other code (apart from these two printlns)

                    // ...
                    System.out.println("  Combos : " /* + currentComboIds*/ );
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }
    }
}
