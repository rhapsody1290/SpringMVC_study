package cn.apeius.springmvc.test;

/**
 * Created by Asus on 2016/9/3.
 */
public class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public void importantMethod(){
        System.out.println("A:importantMethod");
        b.userfulMethod();
    }
}


