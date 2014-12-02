package maintenance;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ListModelExample extends JPanel {

  JList list;

  DefaultListModel model;

  int counter = 15;

  public ListModelExample(OwnerList owners) {
    setLayout(new BorderLayout());
    model = new DefaultListModel();
    list = new JList(model);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    JScrollPane pane = new JScrollPane(list);
    JButton addButton = new JButton("Add Element");
    JButton removeButton = new JButton("Remove Element");
    for (int i = 0; i < owners.getOwnerCount(); i++)
      model.addElement( owners.getList()[i].getName() );

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        model.addElement("Element " + counter);
        counter++;
      }
    });
    removeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (model.getSize() > 0)
          model.removeElementAt(0);
      }
    });

    JLabel label  = new JLabel("", JLabel.LEFT);        
    label.setText("Address");

    add(label);
    add(pane, BorderLayout.NORTH);
    add(addButton, BorderLayout.WEST);
    add(removeButton, BorderLayout.EAST);

    ListSelectionListener listSelectionListener = new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
        java.util.List objs = list.getSelectedValuesList();
        int selections[] = list.getSelectedIndices();

        String item = (String) list.getSelectedValue();
        int selectedid = list.getSelectedIndex();
        System.out.println("ooo "+ selectedid);

        Object selectedValues[] = list.getSelectedValues();
        for (int i = 0, n = selections.length; i < n; i++) {
          if (i == 0) {
            System.out.println("  Selections: ");
          }
          System.out.println(selections[i] + "/" + selectedValues[i] + " ");
        }

      }
    };
    list.addListSelectionListener(listSelectionListener);
  }

  public void addListItem(String s){
  	model.addElement(s);
  }
}