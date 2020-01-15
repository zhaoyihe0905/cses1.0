package com.sinosoft.cses;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class mainFrame {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tablemodle = null;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame window = new mainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("客服服务体验系统");
		frame.setBounds(100, 100, 827, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane mainPanel = new JTabbedPane(JTabbedPane.LEFT);
		mainPanel.setBounds(0, 0, 809, 399);
		frame.getContentPane().add(mainPanel);
		
		JPanel panel1 = new JPanel();
		//切换界面事件
		panel1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent var1) {
				System.out.println("111111111111");
			}
		});

		mainPanel.addTab("自定义全局变量", null, panel1, null);
		panel1.setLayout(null);
		
		JButton btnNewButton = new JButton("新增变量");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent var1) {
				tablemodle.addRow(new Vector<>());
				System.out.println(tablemodle.getRowCount());
			}
		});
		btnNewButton.setBounds(301, 13, 113, 27);
		panel1.add(btnNewButton);
		
		//读取数据库
		Object[][] playerInfo={{"name","value"},{"aa","bb"}};
		
		String[] names={"变量名","变量值"};
		
		JButton btnNewButton_1 = new JButton("保存");
		btnNewButton_1.setBounds(551, 13, 113, 27);
		panel1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent var1) {
				System.out.println(table.getSelectedColumn());
			}
		});

		btnNewButton_2.setBounds(428, 13, 113, 27);
		panel1.add(btnNewButton_2);
		
		//表格模型
		tablemodle = new DefaultTableModel(playerInfo,names);
		table = new JTable(tablemodle);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setBounds(14, 55, 655, 326);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 83, 664, 298);
		scrollPane.setViewportView(table);
		panel1.add(scrollPane);
		
		JPanel panel2 = new JPanel();

		mainPanel.addTab("业务场景", null, panel2, null);
		
		JPanel panel3 = new JPanel();
		mainPanel.addTab("定时任务", null, panel3, null);
		
		JPanel panel4 = new JPanel();
		mainPanel.addTab("刷新缓存", null, panel4, null);
		
		JPanel panel5 = new JPanel();
		mainPanel.addTab("日志显示", null, panel5, null);
		
		JPanel panel6 = new JPanel();
		mainPanel.addTab("接口列表", null, panel6, null);	
		panel6.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("新增");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBounds(380, 23, 93, 23);
		panel6.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("删除");
		btnNewButton_4.setBounds(483, 23, 93, 23);
		panel6.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("保存");
		btnNewButton_5.setBounds(586, 23, 93, 23);
		panel6.add(btnNewButton_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 70, 669, 314);
		panel6.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"xmlUrl", "投保查询",null,"QUERY_SEQUENCE_NO"}
			},
			new String[] {
				"xml路径", "接口名","变量字段","取值字段"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
	}
}
