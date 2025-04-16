import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Jack", 20));
        list.add(new Person("Peter", 22));
        list.add(new Person("Sam", 35));
        list.add(new Person("Shon", 35));
        list.add(new Person("Bob", 37));

        System.out.println(ifPersonWithNameExists(list, "Peter"));
        System.out.println(ifPersonWithNameExists2(list, "Peter"));

    }


    public static boolean ifPersonWithNameExists(List<Person> list, String name) {
        for (Person person : list) {
            if (person.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ifPersonWithNameExists2(List<Person> list, String name) {
        return list.stream()
                .filter(p->p!=null)
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .count() > 0;
    }
}