import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Akharu on 6/28/2016.
 */
public class FormA {

    private Person person = new Person();
    private JPanel rootPanel;
    private JPanel buttonPanel;
    private JPanel labelPanel;
    private JPanel textFieldPanel;
    private JTextField surname;
    private JTextField secondName;
    private JTextField name;
    private JButton buttonAtoB;

    public JTextField getSecondName() {
        return secondName;
    }

    public JTextField getName() {
        return name;
    }

    public JTextField getSurname() {
        return surname;
    }

    public JPanel getTextFieldPanel() {
        return textFieldPanel;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JButton getButtonAtoB() {
        return buttonAtoB;
    }

    public void addActionListenerForSwitchAction(ActionListener actionListener) {
        buttonAtoB.addActionListener(actionListener);
        name.addActionListener(actionListener);
        surname.addActionListener(actionListener);
        secondName.addActionListener(actionListener);
    }

    public boolean isNecessaryFieldsEmpty() {
        if (surname.getText().isEmpty()) {
            surname.requestFocus();
        } else {
            name.requestFocus();
        }
        return surname.getText().isEmpty() || name.getText().isEmpty();
    }

    public boolean isUnnecessaryFieldEmpty() {
        return secondName.getText().isEmpty();
    }

    public Person getPerson() {
        namePerson();
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private void namePerson() {
        person.setName(name.getText());
        person.setSurname(surname.getText());
        person.setSecondName(secondName.getText());
    }

    public void fillForm() {
        name.setText(person.getName());
        surname.setText(person.getSurname());
        secondName.setText(person.getSecondName());
    }
}
