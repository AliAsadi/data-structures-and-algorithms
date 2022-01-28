package data_structure.graphs.questions.interface_design;

import java.util.List;

/**
 *
 */
interface Monarchy {
    void birth(String child, String parent);

    void death(String name);

    List<String> getOrderOfSuccession();
}
