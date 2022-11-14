package edu.psu.ist.view;

import javax.swing.*;

public class SplitListForm {
    private JButton addToRightAtFrontButton;
    private JButton removeFromRightAtFrontButton;
    private JButton moveForwardButton;
    private JButton moveToBeginningButton;
    private JButton clearButton;
    private JButton saveButton;
    private JButton clearLoadButton;
    private JLabel lastRemovedNO;
    private JLabel LeftLenNO;
    private JLabel RightLenNO;
    private JLabel lastRemovedJLabel;
    private JLabel leftLengthJLabel;
    private JPanel MyPanel;
    private JLabel listValueLabel;
    private JLabel rightLengthJLabel;
    private JTextField listTextField;

    public JButton getAddToRightAtFrontButton() {
        return addToRightAtFrontButton;
    }

    public void setAddToRightAtFrontButton(JButton addToRightAtFrontButton) {
        this.addToRightAtFrontButton = addToRightAtFrontButton;
    }

    public JButton getRemoveFromRightAtFrontButton() {
        return removeFromRightAtFrontButton;
    }

    public void setRemoveFromRightAtFrontButton(JButton removeFromRightAtFrontButton) {
        this.removeFromRightAtFrontButton = removeFromRightAtFrontButton;
    }

    public JButton getMoveForwardButton() {
        return moveForwardButton;
    }

    public void setMoveForwardButton(JButton moveForwardButton) {
        this.moveForwardButton = moveForwardButton;
    }

    public JButton getMoveToBeginningButton() {
        return moveToBeginningButton;
    }

    public void setMoveToBeginningButton(JButton moveToBeginningButton) {
        this.moveToBeginningButton = moveToBeginningButton;
    }

    public JLabel getRightLengthJLabel() {
        return rightLengthJLabel;
    }

    public JTextField getListTextField() {
        return listTextField;
    }

    public void setListTextField(JTextField listTextField) {
        this.listTextField = listTextField;
    }

    public void setRightLengthJLabel(JLabel rightLengthJLabel) {
        this.rightLengthJLabel = rightLengthJLabel;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getClearLoadButton() {
        return clearLoadButton;
    }

    public void setClearLoadButton(JButton clearLoadButton) {
        this.clearLoadButton = clearLoadButton;
    }

    public JLabel getLastRemovedJLabel() {
        return lastRemovedJLabel;
    }

    public void setLastRemovedJLabel(JLabel lastRemovedJLabel) {
        this.lastRemovedJLabel = lastRemovedJLabel;
    }

    public JLabel getLeftLengthJLabel() {
        return leftLengthJLabel;
    }

    public void setLeftLengthJLabel(JLabel leftLengthJLabel) {
        this.leftLengthJLabel = leftLengthJLabel;
    }

    public javax.swing.JPanel getMyPanel() {
        return MyPanel;
    }

    public void setMyPanel(javax.swing.JPanel JPanel) {
        this.MyPanel = JPanel;
    }

    public JLabel getListValueLabel() {
        return listValueLabel;
    }

    public void setListValueLabel(JLabel listValueLabel) {
        this.listValueLabel = listValueLabel;
    }
}
