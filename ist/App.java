package edu.psu.ist;


import edu.psu.ist.controller.SplitListController;
import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.model.UtilListImpl;
import edu.psu.ist.view.SplitListView;

public class App{

    public static void main(String[] args) { // in App.java

        ISplittableList<String> model = new UtilListImpl<>();

        SplitListView view = new SplitListView();
        SplitListController controller =
                new SplitListController(model, view);
        view.setVisible(true);
    }
}
