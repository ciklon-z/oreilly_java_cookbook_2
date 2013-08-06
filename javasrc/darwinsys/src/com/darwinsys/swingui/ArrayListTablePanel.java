package com.darwinsys.swingui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * ArrayListTablePanel - Bean/GUI panel for ArrayListTableModel.
 * <p>
 * Subclass should call getTable() and set any
 * desired Renderers or Editors.
 * <p>
 * The class of things in the list must have a public, no-argument constructor.
 *
 * <p>TODO
 * <ul>
 * <li>Debug MoveUp/MoveDown!
 * <li>add constructor options for Add, Remove, MoveUp/MoveDown buttons
 * </ul>
 *
 * @author	Ian Darwin, http://www.darwinsys.com/
 * @version	$Id: ArrayListTablePanel.java,v 1.8 2004/01/31 01:26:05 ian Exp $
 */
public class ArrayListTablePanel extends JPanel {

	/** The list of objects we are viewing */
	protected ArrayList list;
	/** The kind of thing that is in the list. */
	protected Class objectClass;
	/** The JTable's data (model) */
	protected ArrayListTableModel model;
	/** The JTable itself */
	protected JTable table;

	/** Construct new ArrayListTablePanel */
	public ArrayListTablePanel(Class objClass,
		ArrayList al, ArrayListTableModel lm) {

		objectClass = objClass;
		list = al;
		model = lm;
		table = new JTable(model);

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);

		JPanel botPanel = new JPanel();
		JButton jb;
		botPanel.add(jb = new JButton("Add"));
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int i = table.getSelectedRow();
				if (i<0) i = list.size();
				Object newObj = null;
				try {
					newObj = objectClass.newInstance();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
						"Object creation FAILED\n " + ex, "Error",
						JOptionPane.ERROR_MESSAGE);
					return;
				}
				list.add(i, newObj);
				table.tableChanged(new 
					TableModelEvent(model, i, i, 
					TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
			}
		});

		botPanel.add(jb = new JButton("Move Up"));
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int i = table.getSelectedRow();
				if (i == -1 || i == 0)
					return;
				Object obj = list.get(i);
				list.remove(i);
				list.add(i-1, obj);
				table.tableChanged(new 
					TableModelEvent(model, i-1, i-1, 
					TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
				model.invalidateCache();
			}
		});

		botPanel.add(jb = new JButton("Move Down"));
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int i = table.getSelectedRow();
				if (i == -1 || i == list.size()-1)
					return;
				Object obj = list.get(i);
				list.remove(i);
				list.add(i+1, obj);
				table.tableChanged(new 
					TableModelEvent(model, i, i, 
					TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT));
				// table.setSelectedRowInterval(i+1, i+1);
				model.invalidateCache();
			}
		});

		botPanel.add(jb = new JButton("Remove"));
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int i = table.getSelectedRow();
				if (i<0)
					return;	// nothing selected
				list.remove(i);
				table.tableChanged(new 
					TableModelEvent(model, i, i, 
					TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE));
				model.invalidateCache();
			}
		});

		add(botPanel, BorderLayout.SOUTH);
	}

	/** Return a reference to the JTable. */
	public JTable getTable() {
		return table;
	}
}
