package invoice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceIT {

    @Test
    void integrationTest1() {

        InvoiceH2Dao invoiceDao = new InvoiceH2Dao();
        invoiceDao.save(new Invoice("Martin", 56));

        InvoiceFilter filter = new InvoiceFilter(invoiceDao);

        assertThat(filter.filter()).contains(new Invoice("Martin", 56));
    }
}
