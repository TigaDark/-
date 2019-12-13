package ssm.domain;

public class ReponseBody {
    private int flag;
    private String name;

    public ReponseBody(int flag, String name) {
        this.flag = flag;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
