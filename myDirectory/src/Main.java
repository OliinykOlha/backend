import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        MyThread thread = new MyThread("Anna");

        thread.start();

        List<Person> list = new ArrayList<>();
        list.add(new Person("Anna", 23));
        list.add(new Person("Filip", 34));
        list.add(new Person("Piter", 25));
        list.add(new Person("Alisa", 28));
        list.add(new Person("Alisa", 29));

        System.out.println(ifNameExists2(list,"Alisa"));

        List<Person> filteredList = list.stream().filter(p-> p !=null)
                .filter(p->p.getName().equalsIgnoreCase("Alisa"))
                .collect(Collectors.toList());

        System.out.println(filteredList);

    }

    public static boolean ifNameExists(List<Person> list, String name){
        for(Person person : list) {
            if(person.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ifNameExists2(List<Person> list, String name) {
        return list.stream()
                .anyMatch(p->p.getName()
                        .equalsIgnoreCase(name));
    }


}