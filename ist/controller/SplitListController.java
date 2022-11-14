

package edu.psu.ist.controller;

import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.model.UtilListImpl;
import edu.psu.ist.view.SplitListForm;
import edu.psu.ist.view.SplitListView;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class SplitListController {

    public static final String OUTPUT_FILE_NAME = "contents.txt";

    private ISplittableList<String> listModel;
    private SplitListView view;
    private String lastRemoved;

    public SplitListController(ISplittableList<String> listModel,
                               SplitListView view) {
        this.listModel = listModel;
        this.view = view;
        SplitListForm frm = view.form();

        // first thing we'll do in the constructor
        // (remember: this runs only once per run of the app) is set the initial
        // text rendering the (empty) list
        frm.getListValueLabel().setText(listModel.toString());

        // TODO: (Start this only once the form is built --
        //        and the App class runs and displays your form)
        //   add action listeners to the various buttons and manipulate the listModel,
        //   updating the various components on the view when needed

        // Tip: Do the save and load buttons last (get everything else working first)
        frm.getAddToRightAtFrontButton().addActionListener(e ->{

            if(frm.getListTextField().getText().isBlank())
            {
                JOptionPane.showMessageDialog(view, "Text fields cannot be blank");
                return;
            }
            String addToRight = frm.getListTextField().getText();
            listModel.addToRightAtFront(addToRight);
            frm.getListValueLabel().setText(listModel.toString());
            frm.getRightLengthJLabel().setText(String.valueOf(listModel.rightLength()));
            frm.getLeftLengthJLabel().setText(String.valueOf(listModel.leftLength()));
            frm.getListTextField().setText("");

        });
        frm.getRemoveFromRightAtFrontButton().addActionListener(e ->{

            if(listModel.rightLength() == 0)
            {
                JOptionPane.showMessageDialog(view, "You cannot remove when the right list is empty");
                return;
            }
            lastRemoved = listModel.removeFromRightAtFront();
            frm.getLastRemovedJLabel().setText(lastRemoved);
            frm.getListValueLabel().setText(listModel.toString());
            frm.getRightLengthJLabel().setText(String.valueOf(listModel.rightLength()));
            frm.getLeftLengthJLabel().setText(String.valueOf(listModel.leftLength()));
            frm.getListTextField().setText("");

        });
        frm.getMoveForwardButton().addActionListener(e ->{

            if(listModel.rightLength() == 0)
            {
                JOptionPane.showMessageDialog(view, "You cannot move the handle forward when the right list is empty");
                return;
            }
            listModel.moveForward();
            frm.getListValueLabel().setText(listModel.toString());
            frm.getRightLengthJLabel().setText(String.valueOf(listModel.rightLength()));
            frm.getLeftLengthJLabel().setText(String.valueOf(listModel.leftLength()));

        });
        frm.getMoveToBeginningButton().addActionListener(e ->{
            listModel.moveToVeryBeginning();
            frm.getListValueLabel().setText(listModel.toString());
            frm.getRightLengthJLabel().setText(String.valueOf(listModel.rightLength()));
            frm.getLeftLengthJLabel().setText(String.valueOf(listModel.leftLength()));
        });
        frm.getClearButton().addActionListener(e -> {
            listModel.clear();
            String update = listModel.toString();
            frm.getListValueLabel().setText(update);
            frm.getLeftLengthJLabel().setText("");
            frm.getRightLengthJLabel().setText("");
            frm.getLastRemovedJLabel().setText("");
            frm.getListTextField().setText("");
        });

        frm.getSaveButton().addActionListener(e -> {
            save();

        });

        frm.getClearLoadButton().addActionListener(e -> {
            listModel.clear();
            load();
            String update = listModel.toString();
            frm.getListValueLabel().setText(update);
            frm.getLeftLengthJLabel().setText(String.valueOf(listModel.leftLength()));
            frm.getRightLengthJLabel().setText(String.valueOf(listModel.rightLength()));
            frm.getListTextField().setText("");

        });

    }

    /**
     * Saves the contents of the current {@link ISplittableList} model to a
     * file. Note that this method mutates the model, but
     * <strong>restores</strong> it to its original (input) state upon
     * completion of the method.
     * <p>
     * If an exception is thrown during the course of the method, the list model
     * is just reinitialized (and an error msg is displayed).
     */
    private void save() {


        try (PrintWriter writer = new PrintWriter(OUTPUT_FILE_NAME))
        {
            // TODO: Here's one potential (high level) approach:
            //    add elements from the left side of the listModel to a list
            //    push elements from the right side of the listModel onto a stack (Q: why a stack?)
            //    .. take it from here ...
            //    (think about the various calls you'll need to make to the listModel
            //     to get the contents.txt file into the format shown)

            // TODO: Don't forget to restore the listModel to its original
            //   state before the save occurred.
            List<String> toWriteLeft = new ArrayList<>();
            List<String> toWriteRightArrayList = new ArrayList<>();
            Stack<String> toWriteRight = new Stack<>();
            int rightBefore = listModel.rightLength();
            int leftBefore = listModel.leftLength();

            listModel.moveToVeryBeginning();

            for(int i = 0; i < leftBefore; i++)
            {
                toWriteLeft.add(listModel.removeFromRightAtFront());
            }

            for (int i = 0; i < rightBefore; i++)
            {
                String toWrite = listModel.removeFromRightAtFront();
                toWriteRight.push(toWrite);
                toWriteRightArrayList.add(toWrite);

            }

            for (int i = 0; i < leftBefore; i++ ) {
                writer.println(toWriteLeft.get(i));

            }
            for (int i = leftBefore -1; i >= 0; i-- ) {
                listModel.addToRightAtFront(toWriteLeft.get(i));
            }

            for (int i = 0; i < leftBefore; i++)
            {
                listModel.moveForward();
            }

            writer.println("");

            for (int i = 0; i < rightBefore; i++) {
                String popped = toWriteRight.pop();
                writer.println(toWriteRightArrayList.get(i));
                listModel.addToRightAtFront(popped);
            }

            String update = listModel.toString();
            view.form().getLastRemovedJLabel().setText(lastRemoved);
            view.form().getListValueLabel().setText(update);
            view.form().getLeftLengthJLabel().setText(String.valueOf(leftBefore));
            view.form().getRightLengthJLabel().setText(String.valueOf(rightBefore));
            view.form().getListTextField().setText("");
        }
        catch (FileNotFoundException e)
        {

            listModel = new UtilListImpl<>(); // reinitialize..
            JOptionPane.showMessageDialog(view, e.getMessage());
            String update = listModel.toString();

            view.form().getListValueLabel().setText(update);
            view.form().getLeftLengthJLabel().setText("");
            view.form().getRightLengthJLabel().setText("");
            view.form().getLastRemovedJLabel().setText("");
            view.form().getListTextField().setText("");
        }

    }

    private void load(){
        int counter = 0;
        int splitAt = 0;
        try (Scanner scan = new Scanner(new File(OUTPUT_FILE_NAME)))
        {

            while(scan.hasNextLine())
            {
                String next = scan.nextLine();
                if(next.equals(""))
                {
                    splitAt = counter;
                }
                else {
                    counter++;
                    listModel.addToRightAtFront(next);
                    listModel.moveForward();
                }

            }

            listModel.moveToVeryBeginning();

            for (int i = 0; i < splitAt; i++)
            {
                listModel.moveForward();
            }

        }
        catch(FileNotFoundException e) {

            listModel = new UtilListImpl<>(); // reinitialize..
            JOptionPane.showMessageDialog(view, e.getMessage());
            String update = listModel.toString();


            view.form().getListValueLabel().setText(update);
            view.form().getLeftLengthJLabel().setText("");
            view.form().getRightLengthJLabel().setText("");
            view.form().getLastRemovedJLabel().setText("");
            view.form().getListTextField().setText("");
        }
    }
}

