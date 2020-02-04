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

import org.springframework.stereotype.Component;												

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;						   				  
import java.util.Vector;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;

@Component		  
public class mainFrame {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tablemodle = null;
	private DefaultTableModel tablemodle_1 = null;
	private JTable table_1;
	private List<Integer> list = new ArrayList<>();	
	//静态变量
	private String listValue = null;
	
	//================= 临时变量 =================
	/**
	 * 全局变量界面-临时变量
	 */
	private int selectedColumn = -1;
	
	
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
				list.add(tablemodle.getRowCount() -1);
				System.out.println(tablemodle.getRowCount());
			}
		});
		btnNewButton.setBounds(301, 13, 113, 27);
		panel1.add(btnNewButton);
		
		//读取数据库
		Object[][] playerInfo={{"name","value"},{"aa","bb"}};
		
		String[] names={"变量名","变量值"};
		
		JButton btnNewButton_1 = new JButton("保存");
		btnNewButton_1.addActionListener(Event->lala(table, list));													 
		btnNewButton_1.setBounds(551, 13, 113, 27);
		panel1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("删除");
				System.out.println(selectedColumn);
				//tablemodle.removeRow(selectedColumn);
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent var1) {
				selectedColumn =table.getSelectedColumn();
				System.out.println(table.getSelectedColumn());
				//tablemodle.removeRow(selectedColumn);
				
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
				panel2.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("险种");
				lblNewLabel.setBounds(204, 37, 54, 15);
				panel2.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("地区");
				lblNewLabel_1.setBounds(334, 37, 54, 15);
				panel2.add(lblNewLabel_1);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(249, 34, 75, 21);
				comboBox.addItem("--请选择--");
				panel2.add(comboBox);
				
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setBounds(382, 34, 82, 21);
				comboBox_1.addItem("--请选择--");
				panel2.add(comboBox_1);
				
				JButton btnNewButton_6 = new JButton("新增场景");
				btnNewButton_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnNewButton_6.setBounds(601, 10, 93, 23);
				panel2.add(btnNewButton_6);
				String[] listData = new String[7];
		        listData[0] = "交强险投批退场景";
		        listData[1] = "商业险投批退场景";
		        listData[2] = "交强险退保场景";
		        listData[3] = "商业险退保场景";
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(42, 84, 556, 280);
				panel2.add(scrollPane_2);
				
				JList list = new JList();
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listValue = (String) list.getSelectedValue();
						System.out.println(listValue);
					}
				});
				scrollPane_2.setColumnHeaderView(list);
				list.setListData(listData);
				list.setBounds(80, 106, 505, 246);
				
				JButton btnNewButton_7 = new JButton("执    行");
				btnNewButton_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnNewButton_7.setBounds(601, 82, 93, 23);
				panel2.add(btnNewButton_7);
				
				JButton btnNewButton_8 = new JButton("删    除");
				btnNewButton_8.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println(list.getSelectedIndex());
						
					}
				});
				btnNewButton_8.setBounds(601, 49, 93, 23);
				panel2.add(btnNewButton_8);
		
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
				tablemodle_1.addRow(new Vector<>());
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
		
						 
		tablemodle_1 = new DefaultTableModel(new Object[][] {
				   
			{"xmlUrl", "投保查询",null,"QUERY_SEQUENCE_NO"}
		},
		new String[] {
			"xml路径", "接口名","变量字段","取值字段"
		});
		table_1 = new JTable(tablemodle_1);
		scrollPane_1.setViewportView(table_1);
		
	}
	
	/**
	 * 此方法为获取新增的全局变量值，然后存入数据库中
	 * @param table
	 * @param list
	 * @return
	 */
	private Object lala(JTable table, List<Integer> list) {
		for (Integer row : list) {
			String value1 = (String)table.getValueAt(row, 0);
			String value2 = (String)table.getValueAt(row, 1);
			System.out.println();
		}
		return null;
	}
}																		 

