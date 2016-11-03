package elite.example.house.elite.sqlitegoover;

/**
 * Created by House on 2016/11/1.
 */

public class Person {
    private String name;
    private int age;
    private String pclass;

    public Person() {
    }

    public Person(String name, int age, String pclass) {
        this.name = name;
        this.age = age;
        this.pclass = pclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPclass() {
        return pclass;
    }

    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pclass='" + pclass + '\'' +
                '}';
    }
}
