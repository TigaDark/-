package ssm.service;

import org.springframework.stereotype.Service;
import ssm.domain.Invoice;
import ssm.domain.SelectInfo;

import java.util.List;


public interface InvoiceService {
    List<Invoice> findInvoiceByInfo(SelectInfo selectInfo);

    void confirmSent(Invoice invoice) throws Exception;
}
