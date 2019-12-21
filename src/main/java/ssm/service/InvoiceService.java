package ssm.service;

import ssm.domain.Invoice;
import ssm.domain.Logistics;
import ssm.domain.Pojo.SelectInfo;

import java.util.List;


public interface InvoiceService {
    List<Invoice> findInvoiceByInfo(SelectInfo selectInfo);

    void confirmSent(int invoiceid , Logistics logistics) throws Exception;
}
