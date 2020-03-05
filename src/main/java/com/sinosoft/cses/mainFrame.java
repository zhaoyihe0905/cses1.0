package com.sinosoft.cses;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.sinosoft.master.controller.ExecutionController;
import com.sinosoft.master.controller.GlobalVariableController;
import com.sinosoft.master.controller.SysConfigController;
import com.sinosoft.master.entity.Execution;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sinosoft.cses.test.JobDemo;
import com.sinosoft.cses.util.AppCache;
import com.sinosoft.cses.util.BusinessFun;
import com.sinosoft.master.controller.InterfacesController;
import com.sinosoft.master.entity.Interfaces;

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

/**
 * 主界面
 *
 * @author zyh
 */
@Order(3)
@Component
public class mainFrame implements CommandLineRunner {

    /** 日志*/
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private JFrame frame;
    /**
     * 
     */
    private Scheduler scheduler = null;
    /**
     * 全局自定义变量table
     */
    private JTable table;
    /**
     * 接口列表table
     */
    private JTable table_1;

    /**
     * 业务列表table
     */
    private JTable table_2;

    /**
     * 缓存列表table
     */
    private JTable table_3;

    /**
     * 定时任务列表table
     */
    private JTable table_4;

    /**
     * 日志列表table
     */
    private JTable table_5;

    /**
     * 全局自定义变量tableModel
     */
    private DefaultTableModel tablemodle = null;
    /**
     * 接口列表tableModel
     */
    private DefaultTableModel tablemodle_1 = null;

    /**
     * 业务场景列表tableModel
     */
    private DefaultTableModel tablemodle_2 = null;

    /**
     * 缓存列表tableModel
     */
    private DefaultTableModel tablemodle_3 = null;

    /**
     * 定时任务列表tableModel
     */
    private DefaultTableModel tablemodle_4 = null;

    /**
     * 日志列表tableModel
     */
    private DefaultTableModel tablemodle_5 = null;

    //private List<Integer> list = new ArrayList<>();

    @Autowired
    private BusinessFun businessFun;
    @Autowired
    private AppCache appCache;
    @Autowired
    private InterfacesController interfacesC;
    @Autowired
    private ExecutionController executionController;
    @Autowired
    private GlobalVariableController globalVariableController;
    @Autowired
    private SysConfigController sysConfigController;
    //静态变量
    private String listValue = null;

    //================================== 临时变量 ==================================
    /**
     * 全局变量界面-临时变量
     */
    private int selectedColumn = -1;

    /*
    * 日志文本域
    */
//    private JTextField textField;

    private JTextArea textArea;

    /**
     * Launch the application.
     *
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
     *
     * @wbp.parser.entryPoint
     */
    public void init(String[] args) {
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
     *
     * @wbp.parser.entryPoint
     */
    public mainFrame() {
//        initialize();
    }

    /**
     * Initialize the contents of the frame.
     *
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
//		Object[][] playerInfo=businessFun.mapToObject(AppCache.globalVariable);
        Object[][] playerInfo = globalVariableController.mapToObject(AppCache.globalVariable);
        String[] names = {"变量名", "变量值"};


        //全局自定义变量表格模型
        tablemodle = new DefaultTableModel(playerInfo, names);
        table = new JTable(tablemodle);
        table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        table.setBounds(14, 55, 655, 326);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 83, 664, 298);
        scrollPane.setViewportView(table);
        panel1.add(scrollPane);
        JButton btnNewButton = new JButton("新增变量");
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
        btnNewButton_1.addActionListener(Event -> this.saveAll(table));
        btnNewButton_1.setBounds(551, 13, 113, 27);
        panel1.add(btnNewButton_1);
        JButton btnNewButton_2 = new JButton("删除");
        btnNewButton_2.addActionListener(Event -> this.deleteSelected(table, tablemodle));
        btnNewButton_2.setBounds(428, 13, 113, 27);
        panel1.add(btnNewButton_2);

		/*----------------业务场景模块-----------------*/
        JPanel panel2 = new JPanel();
        //加载业务场景列表界面
        Object[][] interfaceInfo2 = executionController.selectExecution(3);
        tablemodle_2 = new DefaultTableModel(interfaceInfo2, new String[]{"业务场景", "接口名", ""});

        mainPanel.addTab("业务场景", null, panel2, null);
        panel2.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("地区:");
        lblNewLabel_1.setBounds(54, 37, 54, 15);
        panel2.add(lblNewLabel_1);

        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.setBounds(102, 34, 106, 21);
        for (String areaCode : AppCache.areaEng.keySet()) {
//			comboBox_1.addItem("--请选择--");
            comboBox_1.addItem(areaCode);
        }
        panel2.add(comboBox_1);

        JButton btnNewButton_6 = new JButton("新增场景");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                tablemodle_2.addRow(new Vector<>());
            }
        });
        btnNewButton_6.setBounds(222, 33, 96, 23);
        panel2.add(btnNewButton_6);
        table_2 = new JTable(tablemodle_2);
        TableColumnModel tcm2 = table_2.getColumnModel();
        TableColumn tc2 = tcm2.getColumn(2);
        tc2.setMaxWidth(0);
        tc2.setPreferredWidth(0);
        tc2.setMinWidth(0);
        tc2.setWidth(0);
        table_2.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        table_2.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);

        JScrollPane scrollPane_2 = new JScrollPane();
        //scrollPane_2.setBounds(42, 84, 556, 280);
        scrollPane_2.setBounds(14, 83, 664, 298);
        panel2.add(scrollPane_2);

        JButton btnNewButton_7 = new JButton("执   行");
        btnNewButton_7.addActionListener(Event -> this.doexecution(table_2, tablemodle_2, comboBox_1, textArea, mainPanel));
        btnNewButton_7.setBounds(552, 33, 96, 23);
        panel2.add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("删    除");
        btnNewButton_8.addActionListener(Event -> this.deleteExecution(table_2, tablemodle_2));
        btnNewButton_8.setBounds(332, 33, 96, 23);
        panel2.add(btnNewButton_8);
        scrollPane_2.setViewportView(table_2);

        JButton btnNewButton_9 = new JButton("保    存");
        btnNewButton_9.addActionListener(Event -> this.saveexecution(table_2));
        btnNewButton_9.setBounds(442, 34, 96, 21);
        panel2.add(btnNewButton_9);



        /*===================定时任务=============================*/
        JPanel panel3 = new JPanel();
        mainPanel.addTab("定时任务", null, panel3, null);
        Object[][] interfaceInfo4 = null;
        tablemodle_4 = new DefaultTableModel(interfaceInfo4, new String[]{"定时任务", ""});
        panel3.setLayout(null);

        JScrollPane scrollPane_3 = new JScrollPane();
        //scrollPane_2.setBounds(42, 84, 556, 280);
        scrollPane_3.setBounds(14, 83, 664, 298);
        panel3.add(scrollPane_3);

        JLabel lblNewLabel_2 = new JLabel("业务场景:");
        lblNewLabel_2.setBounds(54, 37, 74, 15);
        panel3.add(lblNewLabel_2);

        JComboBox<String> comboBox_2 = new JComboBox<String>();
        comboBox_2.setBounds(133, 34, 185, 21);
       /* for (Execution execution : AppCache.executions) {
            comboBox_2.addItem(execution.getProcess());
        }*/
        //定时界面重新加载
        panel3.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent var1) {
            	comboBox_2.removeAllItems();
            	 for (Execution execution : AppCache.executions) {
                     comboBox_2.addItem(execution.getProcess());
                 }
            }
        });
        panel3.add(comboBox_2);

        JButton btnNewButton_10 = new JButton("执   行");
        //btnNewButton_10.addActionListener(Event -> this.doexecution(table_2, tablemodle_2, comboBox_1));
        btnNewButton_10.addActionListener(Event -> this.StartQuartz());
        btnNewButton_10.setBounds(552, 33, 96, 23);
        panel3.add(btnNewButton_10);

        JButton btnNewButton_11 = new JButton("保    存");
        //btnNewButton_11.addActionListener(Event -> this.deleteExecution(table_2, tablemodle_2));
        btnNewButton_11.setBounds(332, 33, 96, 23);
        panel3.add(btnNewButton_11);
        scrollPane_3.setViewportView(table_4);

        JButton btnNewButton_12 = new JButton("停    止");
        btnNewButton_12.addActionListener(Event -> this.EndQuartz());
        btnNewButton_12.setBounds(442, 34, 96, 21);
        panel3.add(btnNewButton_12);


        //==========================刷新缓存============================
        JPanel panel4 = new JPanel();
        mainPanel.addTab("缓存页面", null, panel4, null);
        //加载缓存列表界面
        Object[][] interfaceInfo3 = null;
        tablemodle_3 = new DefaultTableModel(interfaceInfo3, new String[]{"缓存", ""});
        panel4.setLayout(null);

        JButton btnNewButton_sxhc = new JButton("刷新缓存");

        btnNewButton_sxhc.setBounds(235, 33, 93, 23);
        panel4.add(btnNewButton_sxhc);
        btnNewButton_sxhc.addActionListener(Event -> this.initAppCache());
        table_3 = new JTable(tablemodle_3);

		/*JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(42, 84, 556, 280);
		panel4.add(scrollPane_3);*/

        Object[][] interfaceInfo_sys = sysConfigController.sysConfigListToObject();
        tablemodle_3 = new DefaultTableModel(interfaceInfo_sys, new String[]{
                "参数代码", "参数值", ""
        });
        table_3 = new JTable(tablemodle_3);
        //隐藏最后一列id
        TableColumnModel tcm3 = table_3.getColumnModel();
        TableColumn tc3 = tcm3.getColumn(2);
        tc3.setMaxWidth(0);
        tc3.setPreferredWidth(0);
        tc3.setMinWidth(0);
        tc3.setWidth(0);
        table_3.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        table_3.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        JScrollPane scrollPane_sys = new JScrollPane();
        scrollPane_sys.setBounds(10, 70, 669, 314);
        panel4.add(scrollPane_sys);
        scrollPane_sys.setViewportView(table_3);


        //==========================日志模块=========================================

        JPanel panel5 = new JPanel();
        mainPanel.addTab("日志显示", null, panel5, null);
        panel5.setLayout(null);
        textArea = new JTextArea();
        textArea.setBounds(0, 0, 683, 394);
        panel5.add(textArea);
//        textArea.setColumns(50);
        //此代码影响接口页面显示
        //panel5.setVisible(true);

        JPanel panel6 = new JPanel();
        mainPanel.addTab("接口列表", null, panel6, null);
        panel6.setLayout(null);


        //================================== 接口列表 ==================================

        //加载接口列表界面
        //需要获取new Object[][]数组
        Object[][] interfaceInfo = interfacesC.interfacesListToObject(7);
        tablemodle_1 = new DefaultTableModel(interfaceInfo, new String[]{
                "xml路径", "接口名", "url", "变量字段", "取值字段", "标识", ""
        });
        table_1 = new JTable(tablemodle_1);
        //隐藏最后一列id
        /*TableColumnModel tcm = table_1.getColumnModel();
        TableColumn tc = tcm.getColumn(6);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        tc.setMinWidth(0);
        tc.setWidth(0);
        table_1.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        table_1.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);*/

        JButton btnNewButton_3 = new JButton("新增");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                tablemodle_1.addRow(new Vector<>());
            }
        });
        btnNewButton_3.setBounds(380, 23, 93, 23);
        panel6.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("删除");
        btnNewButton_4.addActionListener(Event -> this.deleteInterface(table_1, tablemodle_1));
        btnNewButton_4.setBounds(483, 23, 93, 23);
        panel6.add(btnNewButton_4);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 70, 669, 314);
        panel6.add(scrollPane_1);

        JButton btnNewButton_5 = new JButton("保存");
        btnNewButton_5.addActionListener(Event -> this.saveInterface(table_1,panel6));
        btnNewButton_5.setBounds(586, 23, 93, 23);
        panel6.add(btnNewButton_5);
        scrollPane_1.setViewportView(table_1);
    }

    private Object doexecution(JTable table_2, DefaultTableModel tablemodle_2, JComboBox<String> comboBox_1, JTextArea textArea2, JTabbedPane mainPanel) {

        try {
            Integer id = null;
            try {
                id = (Integer) table_2.getValueAt(table_2.getSelectedRow(), 2);
            } catch (Exception e) {
                logger.error(e.toString());
                JOptionPane.showMessageDialog(null, "请先选择业务场景", "标题", JOptionPane.INFORMATION_MESSAGE);
                throw new Exception("请先选择业务场景");
            }
            //切换界面
            mainPanel.setSelectedIndex(4);

            String area = (String) comboBox_1.getSelectedItem();
            executionController.doExecution(id, area, textArea2);
        } catch (Exception e) {

        }
        return null;
    }

    private Object initAppCache() {
        // TODO Auto-generated method stub
        try {
            //System.out.println("开始刷新缓存！");
            logger.info("开始刷新缓存!");
            appCache.run(null);
            JOptionPane.showMessageDialog(null, "刷新成功", "标题", JOptionPane.INFORMATION_MESSAGE);
            logger.info("刷新缓存成功！");
        } catch (Exception e) {
            logger.info("刷新缓存异常！");
            JOptionPane.showMessageDialog(null, "刷新缓存异常", "标题", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private void deleteExecution(JTable table_2, DefaultTableModel tablemodle_2) {
        logger.info("删除业务场景列表选定项!"+table_2.getColumnCount()+"--"+table_2.getRowCount());
        executionController.del((Integer) table_2.getValueAt(table_2.getSelectedRow(), 2));
        //System.out.println("删除业务场景列表选定项");
        tablemodle_2.removeRow(table_2.getSelectedRow());
    }

    /*
    * 业务列表保存
    **/
    private void saveexecution(JTable table_2) {
        //定义参数list
        List<Execution> executionList = new ArrayList<>();
        //int rowCount = table_2.getRowCount();
        for (int row = 0; row < table_2.getRowCount(); row++) {
            if (table_2.getValueAt(row, 0) != null) {
                Execution execution = new Execution();
                execution.setProcess((String) table_2.getValueAt(row, 0));
                execution.setOrders((String) table_2.getValueAt(row, 1));
                if (table_2.getValueAt(row, 2) != null) {
                    execution.setId((Integer) table_2.getValueAt(row, 2));
                }
                executionList.add(execution);
            } else {
                logger.error("第"+row+"行，第1两列数据为空。保存失败！");
                //System.out.println("新增一行的数据为空！");
                JOptionPane.showMessageDialog(null, "第"+row+"行，第1两列数据为空。保存失败！", "标题", JOptionPane.ERROR_MESSAGE);
            }
        }
        //调用方法进行数据保存
        try {
            executionController.saveExecution(executionList);
            logger.info("保存业务数据成功！");
            JOptionPane.showMessageDialog(null, "保存成功", "标题", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            logger.error("保存业务数据异常！"+e.getMessage());
            JOptionPane.showMessageDialog(null, "保存业务数据异常", "标题", JOptionPane.ERROR_MESSAGE);
        }
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
     *
     * @param table
     * @wbp.parser.entryPoint
     */
    public void saveAll(JTable table) {
        //获取table值，存储为map<String，String>
        HashMap<String, String> infoMap = new HashMap<>();
        for (int row = 0; row < table.getRowCount(); row++) {
            if (table.getValueAt(row, 0) != null && table.getValueAt(row, 1) != null) {
                infoMap.put((String) table.getValueAt(row, 0), (String) table.getValueAt(row, 1));
            }
        }
        //调用方法进行数据保存
//		businessFun.saveGlobalVariable(infoMap);
        globalVariableController.saveGlobalVariable(infoMap);
    }

    /**
     * 全局变量数据删除
     *
     * @param table
     * @param model
     */
    public void deleteSelected(JTable table, DefaultTableModel model) {
        System.out.println("全局变量id为："+table.getValueAt(table.getSelectedRow(), 0));
        //删除数据库中数据
//		businessFun.deleteGlobalVariable((String)table.getValueAt(table.getSelectedRow(), 0));
        globalVariableController.deleteGlobalVariable((String) table.getValueAt(table.getSelectedRow(), 0));
        model.removeRow(table.getSelectedRow());
    }

    /**
     * 接口列表数据保存
     *
     * @param table
     */
    public void saveInterface(JTable table,JPanel panel6) {
        //定义参数list
        List<Interfaces> interfacesList = new ArrayList<>();
        for (int row = 0; row < table.getRowCount(); row++) {
            if (table.getValueAt(row, 0) != null && table.getValueAt(row, 1) != null) {
                Interfaces interfaces = new Interfaces();
                interfaces.setXmlName((String) table.getValueAt(row, 0));
                interfaces.setBussiness_desc((String) table.getValueAt(row, 1));
                interfaces.setUrl((String) table.getValueAt(row, 2));
                interfaces.setInconfigField((String) table.getValueAt(row, 3));
                interfaces.setOutconfigField((String) table.getValueAt(row, 4));
                interfaces.setIdentification((String) table.getValueAt(row, 5));
                if (table.getValueAt(row, 6) != null) {
                    //System.out.println("============" + table.getValueAt(row, 5).toString());
                    interfaces.setId((Integer) table.getValueAt(row, 6));
                }
                interfacesList.add(interfaces);
            }
        }
        //调用方法进行数据保存
        logger.info("保存接口列表数据!");
        try {
            interfacesC.saveInterfaces(interfacesList);
            //下面方法用来刷新列表（未解决）
            /*table_1.removeAll();
            table_1.updateUI();
            table_1.repaint();*/
            logger.info("保存接口列表数据成功！");
            JOptionPane.showMessageDialog(null, "保存成功", "标题", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            logger.error("保存接口列表数据异常！");
            JOptionPane.showMessageDialog(null, "保存接口列表数据异常", "标题", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * 接口列表数据删除
     *
     * @param table
     * @param model
     */
    public void deleteInterface(JTable table, DefaultTableModel model) {
        logger.info("删除第"+table.getRowCount()+"行，第"+table.getColumnCount()+"列的id为："+table.getValueAt(table.getSelectedRow(), 6)+"接口数据！");
        interfacesC.deleteInterfaces((Integer) table.getValueAt(table.getSelectedRow(), 6));
        model.removeRow(table.getSelectedRow());
    }
    /**
     * 启动定时任务
     * @throws Exception
     */
    public void StartQuartz(){
    	try {
    		//实例化调度器
        	scheduler =StdSchedulerFactory.getDefaultScheduler();
        	//创建触发器
        	Trigger trigger = TriggerBuilder.newTrigger()
        			.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
        			.build();
        	//创建任务：被执行任务需要实现Job接口，定时任务会执行excute方法
        	JobDetail job =JobBuilder.newJob(JobDemo.class).build();
        	//注册触发器和任务到调度器中
        	
        	scheduler.scheduleJob(job, trigger);
        	if(scheduler.isStarted()){
        		JOptionPane.showMessageDialog(null, "定时任务已启动", "标题", JOptionPane.INFORMATION_MESSAGE);
        	}else{
            	scheduler.start();
        	}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    /**
     * 关闭定时任务
     */
    public void EndQuartz(){
    	try {
    		System.out.println("关闭定时任务");
    		if(scheduler!=null&&scheduler.isStarted()){
        		scheduler.shutdown();
        		JOptionPane.showMessageDialog(null, "定时任务已停止", "标题", JOptionPane.INFORMATION_MESSAGE);
        	}else{
        		JOptionPane.showMessageDialog(null, "没有正在进行的定时任务", "标题", JOptionPane.INFORMATION_MESSAGE);
        	}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}																		 


