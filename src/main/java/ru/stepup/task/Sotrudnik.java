package ru.stepup.task;

public class Sotrudnik implements Comparable<Sotrudnik>{
    private final String name;
    private final Integer age;
    private final String workPosition;

    public Sotrudnik(String name, int age, String workPosition) {
        this.name = name;
        this.age = age;
        this.workPosition = workPosition;
    }

    @Override
    public String toString() {
        return "Sotrudnik{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPosition='" + workPosition + '\'' +
                '}';
    }
    public Integer getAge(){
        return age;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    @Override
    public int compareTo(Sotrudnik sotr) {
        return getAge().compareTo(sotr.getAge());
    }
}
