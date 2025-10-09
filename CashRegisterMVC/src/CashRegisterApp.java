import java.io.File;

public class CashRegisterApp {
    public static void main(String[] args) {
        File input = new File("input.txt");
        Display display = new Display();
        CashRegisterModel model = new CashRegisterModel(input);
        Controller controller = new Controller(model, display);
        Scanner scanner = new Scanner(controller, model);
    }
}
