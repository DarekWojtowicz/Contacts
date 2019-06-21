import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String respons;
        Scanner sc = new Scanner(System.in);
        List<Person> contacts = new ArrayList<>();
        String enterData;
        Person person;
        int locator;
        String editedData;

        do {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            respons = sc.nextLine();
            switch (respons) {
                case "count" :
                    System.out.println("The Phone Book has " + contacts.size() + " records.");
                    break;

                case "add" :
                    person = new Person();
                    System.out.print("Enter the name of the person: ");
                    person.setName(sc.nextLine());
                    System.out.print("Enter the surname of the person: ");
                    person.setSurame(sc.nextLine());
                    System.out.print("Enter the number: ");
                    person.setPhoneNo(sc.nextLine());
                    contacts.add(person);
                    System.out.println("The record added.");

                    break;

                case "remove" :
                    if (contacts.size() > 0){
                        Main.list(contacts);
                        System.out.print("Select a record: ");
                        locator = sc.nextInt();
                        if (locator > 0 && locator <= contacts.size()) {
                            locator--;
                            contacts.remove(locator);
                            System.out.println("The record removed!");
                        }else {
                            System.out.println("Record not found!");
                        }

                    }else {
                        System.out.println("No records to remove!");
                    }

                    break;

                case "edit" :
                    if (contacts.size() > 0){
                        Main.list(contacts);
                        System.out.print("Select a record: ");
                        locator = sc.nextInt();
                        if (locator > 0 && locator <= contacts.size()) {
                            locator--;
                            System.out.print("Select a field (name, surname, number): ");
                            editedData = sc.nextLine();
                            editedData = sc.nextLine();
                            switch (editedData){
                                case "name" :
                                    editedData = sc.nextLine();
                                    contacts.get(locator).setName(editedData);

                                    break;
                                case "surname" :
                                    editedData = sc.nextLine();
                                    contacts.get(locator).setSurame(editedData);

                                    break;
                                case "number" :
                                    editedData = sc.nextLine();
                                    contacts.get(locator).setPhoneNo(editedData);

                                    break;
                                default:
                                    System.out.println("Unknown operation!");
                            }
                            System.out.println("The record updated!");
                        }else {
                            System.out.println("Record not found!");
                        }
                    }else {
                        System.out.println("No records to edit!");
                    }

                    break;

                case "list" :
                    Main.list(contacts);

                    break;
                case "exit" :

                    break;

                default:
                    System.out.println("Unknown operation!");

            }
            System.out.println();


        } while(!respons.equals("exit"));






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
            String pattern1 = "^\\+?((\\((\\d|[a-zA-Z]){2,}\\))|(((\\d|[a-zA-Z]){2,}[\\s-])(\\((\\d|[a-zA-Z]){2,}\\))))?([\\s-](\\d|[a-zA-Z]){2,})*$";  // pierwszy lub drugi człon w nawiasach
            String pattern2 = "^\\+?((\\d|[a-zA-Z]){2,}[\\s-]?)+$";                                                                                     // brak nawiasów
//            Pattern p1 = Pattern.compile(pattern1);
//            Pattern p2 = Pattern.compile(pattern2);

//            Matcher m1 = p1.matcher(phoneNo);
//            Matcher m2 = p2.matcher(phoneNo);

            if(phoneNo.matches(pattern1) || phoneNo.matches(pattern2)){
                this.phoneNo = phoneNo;
            }else {
                System.out.println("Wrong number format!");
                this.phoneNo = "[no number]";
            }

        }

        @Override
        public String toString() {
            return  name + " " + surame + " " + phoneNo;
        }
    }
    public static void list(List contacts){
        for (int i = 0; i < contacts.size(); i++){
            System.out.println((i+1) + " " + contacts.get(i));
        }
    }
}

