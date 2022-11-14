package edu.psu.ist.view;

import javax.swing.*;

public class SplitListView extends JFrame {
        // uncomment this once the form is built (using the formbuilder)
        private final SplitListForm form;

        public SplitListView() {
            // uncomment the lines below once your form is built
            this.form = new SplitListForm();
            JPanel content = form.getMyPanel();
            this.setContentPane(content);
            this.pack();

            this.setTitle("Splittable Madness"); // change if you like
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        // uncomment once the form is built
    public SplitListForm form() {
        return form;
    }
}

