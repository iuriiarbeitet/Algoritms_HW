import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Задача: Дана коллекция объектов класса Person, содержащая поля name и список friends,
 * представляющий список друзей данного человека. Напишите метод, который находит двух людей в коллекции,
 * у которых максимальное число общих друзей. Если таких людей несколько, то вернуть список их имен.
 */
public class MainTask {
    public static void main(String[] args) {
        System.out.println(findMaxCountFriends(fillListPerson()));
    }

    public static List<Person> fillListPerson() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("name1", fillListFriends(10)));
        personList.add(new Person("name2", fillListFriends(15)));
        personList.add(new Person("name3", fillListFriends(16)));
        personList.add(new Person("name4", fillListFriends(25)));
        personList.add(new Person("name5", fillListFriends(25)));
        personList.add(new Person("name6", fillListFriends(5)));
        personList.add(new Person("name7", fillListFriends(11)));
        personList.add(new Person("name8", fillListFriends(25)));
        personList.add(new Person("name9", fillListFriends(16)));

        return personList;
    }

    public static List<String> fillListFriends(int a) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            list.add("friend" + i);
        }
        return list;
    }

    public static List<String> findMaxCountFriends(List<Person> people) {
        List<String> listMaxFriends = people.stream()
                .collect(Collectors.groupingBy(o -> o.getListFriends().size()))
                .entrySet()
                .stream()
                .sorted(((o1, o2) -> o2.getKey().compareTo(o1.getKey())))
                .limit(2)
                .flatMap(x -> x.getValue().stream())
                .map(x -> x.getName())
                .collect(Collectors.toList());
        return listMaxFriends;
    }


static class Person {
    private String name;
    List<String> listFriends;

    public Person(String name, List<String> listFriends) {
        this.name = name;
        this.listFriends = listFriends;
    }

    public String getName() {
        return name;
    }

    public List<String> getListFriends() {
        return listFriends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", listFriends=" + listFriends +
                '}';
    }
}
}
