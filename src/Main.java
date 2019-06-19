import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        List<Person> contacts = new ArrayList<>();
        String enterData;
        Person person = new Person();


        System.out.print("Enter the name of the person: ");
        person.setName(sc.nextLine());
        System.out.print("Enter the surname of the person: ");
        person.setSurame(sc.nextLine());
        System.out.print("Enter the number: ");
        person.setPhoneNo(sc.nextLine());

        contacts.add(person);
        System.out.println("A record created!");
        System.out.println("A Phone Book with a single record created!");


    }

    static class Person {
        private String name;
        private String surame;
        private String phoneNo;

        public Person(String name, String surame, String phoneNo) {
            this.name = name;
            this.surame = surame;
            this.phoneNo = phoneNo;
        }

        public Person() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurame() {
            return surame;
        }

        public void setSurame(String surame) {
            this.surame = surame;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }
    }
}

