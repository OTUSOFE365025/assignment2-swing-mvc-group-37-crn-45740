import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CashRegisterModel {
    private final HashMap<Integer, Item> registeredItems = new HashMap<>();
    private final List<Item> scannedItems = new ArrayList<>();

    // Helper list for generating a random UPC from valid UPCs
    private final List<Integer> validUpcs = new ArrayList<>();

    double subtotal = 0;

    public CashRegisterModel(File inputFile) {
        try (FileReader reader = new FileReader(inputFile)) {
            BufferedReader bf = new BufferedReader(reader);

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
        Item scannedItem = this.getItem(upc);
        if (scannedItem == null) {
            System.out.println("Invalid UPC!");
            return;
        }

        subtotal += scannedItem.getPrice();

        scannedItems.add(scannedItem);
    }

    public double getSubtotal(){
        return subtotal;
    }

    public Item getItem(Integer UPC){
        return registeredItems.get(UPC);
    }

    public List<Integer> getValidUpcs() {
        return validUpcs;
    }
}
