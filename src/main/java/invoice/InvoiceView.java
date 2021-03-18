package invoice;

public class InvoiceView {

    public static void main(String[] args) {
        var invoiceView = new InvoiceView();
        invoiceView.printInvoices();
    }

    public void printInvoices()
    {
        InvoiceDao invoiceDao = new InvoiceH2Dao();
        invoiceDao.save(new Invoice("Pelles gott",99.0));
        invoiceDao.save(new Invoice("ICA Mini",50.0));
        invoiceDao.save(new Invoice("Enegårdens kött",101.0));

        InvoiceFilter filter = new InvoiceFilter(new InvoiceH2Dao());
        filter.filter().forEach(this::printInvoice);
    }

    private void printInvoice(Invoice invoice){
        System.out.println("Customer: " + invoice.getCustomer());
        System.out.println("Amount: " + invoice.getValue());
    }
}
