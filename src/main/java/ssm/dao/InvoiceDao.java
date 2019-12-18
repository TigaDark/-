package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Invoice;

import java.util.List;

public interface InvoiceDao {
    /**
     * 生成发货单
     * @param invoice
     */
    void createInvoice(@Param(value = "invoice")Invoice invoice,@Param(value = "customerid")int customerid);

    /**
     * 根据查询参数 页码 查询发货单
     * @param query
     * @return
     */
    List<Invoice> findInvoiceByInfo(String query);

    void editissentById(@Param(value = "id")int id, @Param(value = "issent")int issent);
}
