package ssm.domain;

public class Goods {
    private int id;
    private String name;
    private double price;
    private int nums;
    private int minn;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", nums=" + nums +
                ", minn=" + minn +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public int getMinn() {
        return minn;
    }

    public void setMinn(int minn) {
        this.minn = minn;
    }
}
