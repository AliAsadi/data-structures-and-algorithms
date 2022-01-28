package data_structure.graphs.questions.interface_design;

import java.util.*;


/**
 * Implement the Monarchy the interface.
 */
public class MonarchyImpl implements Monarchy {

    static class Person {
        String name;
        boolean isAlive = true;
        ArrayList<Person> childrens = new ArrayList<>();

        public Person(String name) {
            this.name = name;
        }
    }

    private final Map<String, Person> persons = new HashMap<>();
    private final Person king;

    MonarchyImpl(String king) {
        this.king = new Person(king);
        persons.put(king, this.king);
    }

    @Override
    public void birth(String child, String parent) {
        Person parentObject = new Person(parent);
        Person childObject = new Person(child);

        if (!persons.containsKey(parent)) persons.put(parent, parentObject);
        persons.get(parent).childrens.add(childObject);

        persons.put(child, childObject);
    }

    @Override
    public void death(String name) {
        if (persons.containsKey(name)) persons.get(name).isAlive = false;
    }

    @Override
    public List<String> getOrderOfSuccession() {
        List<String> list = new ArrayList<>();
        dfs(king,list);
        return list;
    }

    void dfs(Person person, List<String> list) {
        if (person.isAlive) list.add(person.name);

        for (Person children : person.childrens) {
            dfs(children, list);
        }
    }

    public static void main(String[] args) {
        MonarchyImpl monarchy = new MonarchyImpl("Jake");
        monarchy.birth("Catherine", "Jake");
        monarchy.birth("Tom", "Jake");
        monarchy.birth("Celine", "Jake");
        monarchy.birth("Peter", "Celine");
        monarchy.birth("Jane", "Catherine");
        monarchy.birth("Farah", "Jane");
        monarchy.birth("Mark", "Catherine");


        monarchy.death("Jake");
        monarchy.death("Jane");
        System.out.println(monarchy.getOrderOfSuccession());
    }
}
