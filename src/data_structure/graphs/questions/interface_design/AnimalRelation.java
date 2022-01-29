package data_structure.graphs.questions.interface_design;

import java.util.*;

/**
 *
 */
public class AnimalRelation {


    static class Solution1 {

        void printTree(List<Relation> relationList) {
            Map<String, List<String>> graph = new HashMap<>();
            HashSet<String> children = new HashSet<>();
            for (Relation relation : relationList) {
                children.add(relation.child);
                if (!graph.containsKey(relation.parent)) graph.put(relation.parent, new ArrayList<>());
                graph.get(relation.parent).add(relation.child);
            }

            String root = "";
            for (String parent : graph.keySet()) {
                if (!children.contains(parent)) root = parent;
            }

            dfs(graph, root);
        }

        void dfs(Map<String, List<String>> graph, String animal) {
            System.out.print(animal + " ");
            if (graph.containsKey(animal)) {
                for (String child : graph.get(animal)) {
                    dfs(graph, child);
                }
            }
        }

    }

    static class Solution2 {


        static class Animal {
            String name;
            Animal parent;
            List<Animal> children = new ArrayList<>();

            public Animal(String name) {
                this.name = name;
            }
        }

        void printTree(List<Relation> relationList) {
            HashMap<String, Animal> animals = new HashMap<>();

            for (Relation relation : relationList) {
                if (!animals.containsKey(relation.parent)) animals.put(relation.parent, new Animal(relation.parent));
                if (!animals.containsKey(relation.child)) animals.put(relation.child, new Animal(relation.child));

                Animal parent = animals.get(relation.parent);
                Animal child = animals.get(relation.child);

                parent.children.add(child);
                child.parent = parent;
            }


            Animal root = null;
            for (Animal animal : animals.values()) {
                if (animal.parent == null) root = animal;
            }

            dfs(root);
        }

        void dfs(Animal animal) {
            System.out.print(animal.name + " ");

            if (!animal.children.isEmpty()) {
                for (Animal child : animal.children) dfs(child);
            }
        }
    }


    public static void main(String[] args) {

        List<Relation> relationList = new ArrayList<>();
        relationList.add(new Relation("animal", "mamal"));
        relationList.add(new Relation("animal", "bird"));
        relationList.add(new Relation("lifeform", "animal"));
        relationList.add(new Relation("cat", "lion"));
        relationList.add(new Relation("mamal", "cat"));
        relationList.add(new Relation("animal", "fish"));


        //animal -> mamal, bird, fish
        //lifeform -> animal
        //cat -> lion
        //mamal -> cat

//        new Solution1().printTree(relationList);
        new Solution2().printTree(relationList);
    }
}

class Relation {
    String parent;
    String child;

    public Relation(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }
}