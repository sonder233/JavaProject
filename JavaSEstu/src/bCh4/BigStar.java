package bCh4;

public class BigStar implements Star {
    String name;

    public BigStar() {
    }

    public BigStar(String name) {
        this.name = name;
    }

    @Override
    public String sing(String name){
        System.out.println(this.name+" is singing ");
        return "谢谢";
    }

    @Override
    public void dance(){
        System.out.println(this.name+" is dancing ");
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "BigStar{name = " + name + "}";
    }
}
