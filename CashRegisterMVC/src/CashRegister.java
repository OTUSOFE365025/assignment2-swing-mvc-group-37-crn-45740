import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CashRegister {
    private final HashMap<Integer, Item> registeredItems = new HashMap<>();
    private final List<Item> scannedItems = new ArrayList<>();

    // Helper list for generating a random UPC from valid UPCs
    private final List<Integer> validUpcs = new ArrayList<>();

    double subtotal = 0;

    public CashRegister(File inputFile) {
        try (FileReader reader = new FileReader(inputFile)) {
            BufferedReader bf = new BufferedReader(reader);
            // Empty out the first line as it defines the format of the file
            bf.readLine();

            String productInfo;
            while ((productInfo = bf.readLine()) != null) {
                // Parse product info from line
                String[] info = productInfo.split(",");
                int upc = Integer.parseInt(info[0]);
                String name = info[1];
                float price = Float.parseFloat(info[2]);
                registeredItems.put(upc, new Item(upc, name, price));

                validUpcs.add(upc);
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Error while parsing product info: " + e);
        }
    }

    public void scanItem(int upc) {
        Item scannedItem = registeredItems.get(upc);
        if (scannedItem == null) {
            System.out.println("Invalid UPC!");
            return;
        }

        subtotal += scannedItem.getPrice();

        System.out.println(scannedItem.getName() + ": $" + scannedItem.getPrice());
        System.out.println("Subtotal: " + subtotal);
        scannedItems.add(scannedItem);
    }

    public List<Integer> getValidUpcs() {
        return validUpcs;
    }
}
