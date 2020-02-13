package com.sinosoft.cses.view.windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;

public class businessView extends JFrame {
	
	/**
	 * 业务场景tableModel
	 */
	private DefaultTableModel tablemodle = null;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public businessView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 447);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 69, 618, 318);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 312, 618, -310);
		panel.add(scrollPane);
		//加载tableModle
		Object[][] businessInfo ={};
		tablemodle = new DefaultTableModel(businessInfo,new String[] {
				"业务场景名", "接口名(保证顺序)"
			});
		table = new JTable(tablemodle);
		panel.add(table);
		table.setBounds(0, 0, 616, 318);

	}
}
