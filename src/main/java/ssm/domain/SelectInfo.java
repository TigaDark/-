package ssm.domain;

public class SelectInfo {
    //查询参数
    private String query;
    // 当前的页数
    private int pagenum;
    // 当前每页显示多少条数据
    private int pagesize;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
}
