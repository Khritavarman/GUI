import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Akharu on 6/28/2016.
 */
public class MyFrame extends JFrame {

    private FormA formA = new FormA();
    private FormB formB = new FormB();

    public MyFrame() {
        setContentPane(formA.getRootPanel());
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        formA.addActionListenerForSwitchAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToB();
            }
        });

        formB.addActionListenerForSwitchAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToA();
            }
        });

        Action actA = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToB();
            }
        };

        Action actB = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToA();
            }
        };

        KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_MASK);
        formA.getRootPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(key, "act");
        formA.getRootPanel().getActionMap().put("act", actA);
        formB.getRootPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(key, "act");
        formB.getRootPanel().getActionMap().put("act", actB);
    }

    public void switchToB () {
        if (formA.isNecessaryFieldsEmpty()) {
            JOptionPane.showMessageDialog(formA.getRootPanel(),
                    "Type Name and Surname, please",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else if (formA.isUnnecessaryFieldEmpty()){
            int answer = JOptionPane.showConfirmDialog(formA.getRootPanel(),
                    "Second name is empty, do you want to continue?",
                    "Warning",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                setContentPane(formB.getRootPanel());
                formB.getRootPanel().revalidate();
                formB.getRootPanel().repaint();
                formB.getFio().setText(formA.getSurname().getText() +  " " + formA.getName().getText()
                        + " " + formA.getSecondName().getText());
                /*formB.setPerson(formA.getPerson());
                formB.fillForm();*/
            } else {
                formA.getSecondName().requestFocus();
            }
        } else {
            setContentPane(formB.getRootPanel());
            formB.getRootPanel().revalidate();
            formB.getRootPanel().repaint();
            formB.getFio().setText(formA.getSurname().getText() +  " " + formA.getName().getText()
                    + " " + formA.getSecondName().getText());
        }
    }

    public void switchToA () {
        String[] text = formB.getFio().getText().split("[\\s]+");
        if (text.length < 2){
            JOptionPane.showMessageDialog(formA.getRootPanel(),
                    "It seems, that you didn't type name or surname",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else if (text.length > 3) {
            JOptionPane.showMessageDialog(formA.getRootPanel(),
                    "It seems, that something's wrong",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else if (text.length == 2) {
            setContentPane(formA.getRootPanel());
            formA.getRootPanel().revalidate();
            formA.getRootPanel().repaint();
            formA.getSurname().setText(text[0]);
            formA.getName().setText(text[1]);
            formA.getSecondName().setText("");
        } else {
            setContentPane(formA.getRootPanel());
            formA.getRootPanel().revalidate();
            formA.getRootPanel().repaint();
            formA.getSurname().setText(text[0]);
            formA.getName().setText(text[1]);
            formA.getSecondName().setText(text[2]);
        }
        /*formA.setPerson(formB.getPerson());
        formA.fillForm();*/
    }
}
