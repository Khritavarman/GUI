import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

/**
 * Created by Akharu on 6/28/2016.
 */
public class FormB {

    private Person person = new Person();
    private JPanel rootPanel;
    private JPanel centerPanel;
    private JProgressBar progressBar;
    private JButton buttonBtoA;
    private JTextField fio;

    public FormB() {

        fio.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                progressBar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                progressBar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                progressBar();
            }
        });

        progressBar.setMaximum(99);
        progressBar.setStringPainted(true);
    }

    public void addActionListenerForSwitchAction(ActionListener actionListener) {
        buttonBtoA.addActionListener(actionListener);
        fio.addActionListener(actionListener);
    }

    public JTextField getFio() {
        return fio;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public Person getPerson() {
        namePerson();
        return person;
    }

    public JButton getButtonBtoA() {
        return buttonBtoA;
    }

    public void progressBar() {
        progressBar.setValue(fio.getText().length());
    }

    public String[] splitFio() {
        return fio.getText().split("[\\s]+");
    }

    private void namePerson() {
        String[] text = splitFio();
        try {
            person.setSurname(text[0]);
            person.setName(text[1]);
            person.setSecondName(text[2]);
        } catch (ArrayIndexOutOfBoundsException e1) {
            person.setSecondName("");
        }
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void fillForm() {l
        fio.setText(person.getSurname() +  " " + person.getName() + " " + person.getSecondName());
    }
}
