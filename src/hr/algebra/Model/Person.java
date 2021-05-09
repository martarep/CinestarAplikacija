package hr.algebra.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Comparable<Person> {

    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "surname")
    private String surname;
    @XmlElement(name = "function")
    private PersonFunction function;

    public Person() {
    }

    public Person(String name, String surname, PersonFunction function) {
        this.name = name;
        this.surname = surname;
        this.function = function;
    }

    public Person(int id, String name, String surname, PersonFunction function) {
        this(name, surname, function);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public PersonFunction getFunction() {
        return function;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFunction(PersonFunction function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int compareTo(Person p) {
        return this.getName().compareTo(p.getName());
    }

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        return this.toString().equals(p.toString());
    }

}
