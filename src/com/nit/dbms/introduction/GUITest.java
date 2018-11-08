package com.nit.dbms.introduction;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.nit.dbms.introduction.StudentBean;
import com.nit.dbms.introduction.StudentDao;

public class GUITest extends JFrame {

	private static final long serialVersionUID = 1L;
	// 程序主框架
	private JFrame jFrame;
	// 主面板
	private JPanel jPanel;
	// 查询内容文本框
	private JTextField jTextMessage;
	// 查询按钮
	private JButton jButtonQuery;
	// 添加按钮
	private JButton jButtonAdd;
	// 更新按钮
	private JButton jButtonEdit;
	// 删除按钮
	private JButton jButtonDel;
	// 显示消息的滚动面板
	private JScrollPane jScrollPane;
	// 显示消息的表格，用于使界面显示更规则
	private JTable jTable;
	// 表格初始化模型
	private DBViewTableModel dbViewModel;
	// 获取学生数据
	List<StudentBean> listStudent = new ArrayList<StudentBean>();
	private StudentBean studentBean = new StudentBean();

	public GUITest() {
		jTextMessage = new JTextField("查询内容");
		jButtonQuery = new JButton("查询");
		jButtonAdd = new JButton("添加");
		jButtonEdit = new JButton("编辑");
		jButtonDel = new JButton("删除");
		// 获取学生数据
		StudentDao studentDao = new StudentDao();
		listStudent = studentDao.getStudentInfo("");
		// 滚动面板布局设置
		jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(0, 440));
		jScrollPane.setViewportView(getInfoTable());
		jPanel = new JPanel();
		// 定义整体菜单面板布局
		JPanel jPanelMenu = new JPanel();
		jPanelMenu.setLayout(new GridLayout(1, 5));
		jPanelMenu.add(jTextMessage);
		jPanelMenu.add(jButtonQuery);
		jPanelMenu.add(jButtonAdd);
		jPanelMenu.add(jButtonDel);
		jPanelMenu.add(jButtonEdit);
		// 添加列表
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jScrollPane, BorderLayout.CENTER);
		jPanel.add(jPanelMenu, BorderLayout.NORTH);
		// 定义主界面框架
		jFrame = new JFrame("学生信息");
		// 设置显示大小及位置等属性
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int SwingX = 600;
		int SwingY = 500;
		jFrame.setBounds(screensize.width / 2 - SwingX / 2, screensize.height / 2 - SwingY / 2, SwingX, SwingY);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = jFrame.getContentPane();
		contentPane.add(jPanel, BorderLayout.CENTER);
		jFrame.setResizable(false);
		jFrame.setVisible(true);

		// 查询消息按钮单击事件
		jButtonQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 单击触发事件
				try {
					//进行数据库查询并更新界面
					listStudent = studentDao.getStudentInfo(jTextMessage.getText());
					getInfoTable().updateUI();
				} catch (Exception en) {
					en.printStackTrace();
				}
			}
		});

		// 添加消息按钮单击事件
		jButtonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 单击触发事件
				try {
					JOptionPane.showMessageDialog(null, "弹出一个对话框");
				} catch (Exception en) {
					en.printStackTrace();
				}
			}
		});
	}

	// 显示列表，以下内容为表格的属性设置，可以不改动
	private JTable getInfoTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.setModel(getDBViewModel());
			// 设置表是否绘制单元格周围的网格线
			jTable.setShowGrid(true);
			jTable.getColumnModel().getColumn(0).setPreferredWidth(150);
			jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
			jTable.getColumnModel().getColumn(2).setPreferredWidth(50);
			jTable.getColumnModel().getColumn(3).setPreferredWidth(150);
			jTable.getColumnModel().getColumn(4).setPreferredWidth(100);
			// 设置表头和行高
			jTable.getTableHeader().setPreferredSize(new Dimension(0, 30));
			jTable.setRowHeight(30);
			// 设置table内容居中
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			jTable.setDefaultRenderer(Object.class, tcr);

			// 鼠标单击事件，在此修改已读和未读的标志位
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try {
						if (jTable.getValueAt(jTable.getSelectedRow(), 0) != null) {
							// 你选中了一行
							JOptionPane.showMessageDialog(null, jTable.getValueAt(jTable.getSelectedRow(), 1));
							getInfoTable().updateUI();
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return jTable;
	}

	// 实例化列表格式
	private DBViewTableModel getDBViewModel() {
		if (dbViewModel == null) {
			dbViewModel = new DBViewTableModel();
		}
		return dbViewModel;
	}

	// 设置列表格式
	private class DBViewTableModel extends DefaultTableModel {
		private static final long serialVersionUID = 1L;

		// 设置单元格不可编辑
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		// 返回表格的列数
		public int getColumnCount() {
			return 5;
		}

		// 返回表格的行数
		public int getRowCount() {
			return listStudent.size();
		}

		// 文件列表表头
		public String getColumnName(int col) {
			switch (col) {
			case 0:
				return "学号";
			case 1:
				return "姓名";
			case 2:
				return "性别";
			case 3:
				return "出生日期";
			case 4:
				return "电话";
			}
			return "";
		}

		// 显示列表值
		public Object getValueAt(int row, int col) {
			studentBean = listStudent.get(row);
			if (col == 0) {
				return studentBean.getSId();
			}
			if (col == 1) {
				return studentBean.getSName();
			}
			if (col == 2) {
				return studentBean.getSSexy();
			}
			if (col == 3) {
				return studentBean.getSBdate();
			}
			if (col == 4) {
				return studentBean.getSTele();
			}
			return null;
		}
	}

	public static void main(String args[]) {
		new GUITest();
	}
}
