import java.io.File;

public class CashRegisterApp {
    public static void main(String[] args) {
        File file = new File("input.txt");
        CashRegister model = new CashRegister(file);
        Scanner display = new Scanner(model);
    }
}
