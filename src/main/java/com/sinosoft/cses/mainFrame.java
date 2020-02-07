package com.sinosoft.cses;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.sinosoft.cses.util.AppCache;
import com.sinosoft.cses.util.BusinessFun;
import com.sinosoft.master.controller.InterfacesController;
import com.sinosoft.master.entity.Interfaces;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
/**
 * 主界面
 * @author zyh
 *
 */
@Order(3)
@Component		  
public class mainFrame  implements CommandLineRunner{

	private JFrame frame;
	/**
	 * 全局自定义变量table
	 */
	private JTable table;
	/**
	 * 接口列表table
	 */
	private JTable table_1;
	
	/**
	 * 全局自定义变量tableModel
	 */
	private DefaultTableModel tablemodle = null;
	/**
	 * 接口列表tableModel
	 */
	private DefaultTableModel tablemodle_1 = null;

	//private List<Integer> list = new ArrayList<>();	
	
	@Autowired
	private BusinessFun businessFun;
	@Autowired
	private InterfacesController interfacesC;
	//静态变量
	private String listValue = null;
	
	//================================== 临时变量 ==================================
	/**
	 * 全局变量界面-临时变量
	 */
	private int selectedColumn = -1;
	
	
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
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
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public  void init(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					mainFrame window = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public mainFrame() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
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
				System.out.println("切換界面");
			}
		});
		//================================== 自定义全局变量 ==================================	
		mainPanel.addTab("自定义全局变量", null, panel1, null);
		panel1.setLayout(null);
		
		
		//初始化全局自定义变量界面数据
		Object[][] playerInfo=businessFun.mapToObject(AppCache.globalVariable);
		String[] names={"变量名","变量值"};
		
		
		//全局自定义变量表格模型
		tablemodle = new DefaultTableModel(playerInfo,names);
		table = new JTable(tablemodle);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setBounds(14, 55, 655, 326);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 83, 664, 298);
		scrollPane.setViewportView(table);
		panel1.add(scrollPane);
		JButton btnNewButton = new JButton("新增变量");
		/*		btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent var1) {
					}
				});*/
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent var1) {
						tablemodle.addRow(new Vector<>());
						//list.add(tablemodle.getRowCount() -1);
					}
				});
				btnNewButton.setBounds(301, 13, 113, 27);
				panel1.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("保存");
		btnNewButton_1.addActionListener(Event->this.saveAll(table));													 
		btnNewButton_1.setBounds(551, 13, 113, 27);
		panel1.add(btnNewButton_1);		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(Event->this.deleteSelected(table,tablemodle));	
		btnNewButton_2.setBounds(428, 13, 113, 27);
		panel1.add(btnNewButton_2);
		
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
		
		
		//================================== 接口列表 ==================================	

		//加载接口列表界面			
		//需要获取new Object[][]数组
		Object[][] interfaceInfo = interfacesC.interfacesListToObject(5);
		tablemodle_1 = new DefaultTableModel(interfaceInfo,new String[] {
			"xml路径", "接口名","变量字段","取值字段",""
		});
		table_1 = new JTable(tablemodle_1);
		TableColumnModel tcm = table_1.getColumnModel();
		TableColumn tc = tcm.getColumn(4) ;  
		JButton btnNewButton_3 = new JButton("新增");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablemodle_1.addRow(new Vector<>());
			}
		});
		btnNewButton_3.setBounds(380, 23, 93, 23);
		panel6.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("删除");
		btnNewButton_4.addActionListener(Event->this.deleteInterface(table_1,tablemodle_1));
		btnNewButton_4.setBounds(483, 23, 93, 23);
		panel6.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("保存");
		btnNewButton_5.addActionListener(Event->this.saveInterface(table_1));
		btnNewButton_5.setBounds(586, 23, 93, 23);
		panel6.add(btnNewButton_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 70, 669, 314);
		panel6.add(scrollPane_1);
		
		scrollPane_1.setViewportView(table_1);		
	}
	


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		initialize();
		
	}
	/**
	 * 全局变量数据保存
	 * @param table
	 * @wbp.parser.entryPoint
	 */
	public void saveAll(JTable table){
		//获取table值，存储为map<String，String>
		HashMap<String, String> infoMap = new HashMap<>();
		for(int row=0;row<table.getRowCount();row++){
			if(table.getValueAt(row, 0)!=null&&table.getValueAt(row, 1)!=null){
				infoMap.put((String)table.getValueAt(row, 0), (String)table.getValueAt(row, 1));
			}		
		}
		//调用方法进行数据保存
		businessFun.saveGlobalVariable(infoMap);
	}
	/**
	 * 全局变量数据删除
	 * @param table
	 * @param model
	 */
	public void deleteSelected(JTable table,DefaultTableModel model){
		//删除数据库中数据
		businessFun.deleteGlobalVariable((String)table.getValueAt(table.getSelectedRow(), 0));
		model.removeRow(table.getSelectedRow());
	}
	/**
	 * 接口列表数据保存
	 * @param table
	 */
	public void saveInterface(JTable table){
		//定义参数list
		List<Interfaces> interfacesList = new ArrayList<>();
		for(int row=0;row<table.getRowCount();row++){
			if(table.getValueAt(row, 0)!=null&&table.getValueAt(row, 1)!=null){
				Interfaces interfaces = new Interfaces();
				interfaces.setXmlName((String)table.getValueAt(row, 0));
				interfaces.setBussiness_desc((String)table.getValueAt(row, 1));
				interfaces.setInconfigField((String)table.getValueAt(row, 2));
				interfaces.setOutconfigField((String)table.getValueAt(row, 3));
				interfaces.setId((Integer)table.getValueAt(row, 4));
				interfacesList.add(interfaces);
			}		
		}
		//调用方法进行数据保存
		System.out.println("保存接口列表数据");
		try {
			interfacesC.saveInterfaces(interfacesList);
			JOptionPane.showMessageDialog(null, "保存成功", "标题", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(), "标题", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	/**
	 * 接口列表数据删除
	 * @param table
	 * @param model
	 */
	public void deleteInterface(JTable table,DefaultTableModel model){

		System.out.println(table.getColumnCount());
		System.out.println(table.getRowCount());
		interfacesC.deleteInterfaces((Integer)table.getValueAt(table.getSelectedRow(), 4));
		System.out.println("删除接口列表选定项");
		model.removeRow(table.getSelectedRow());
	}
}																		 


