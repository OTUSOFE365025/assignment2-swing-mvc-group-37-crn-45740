public class Controller {
    CashRegisterModel cashRegisterModel;
    Display display;
    public Controller(CashRegisterModel cashRegisterModel, Display display){
        this.cashRegisterModel = cashRegisterModel;
        this.display = display;
    }

    public void scanItem(Integer UPC){
        cashRegisterModel.scanItem(UPC);
        display.addItem(cashRegisterModel.getItem(UPC));
        display.setSubtotal(cashRegisterModel.getSubtotal());
    }
}
