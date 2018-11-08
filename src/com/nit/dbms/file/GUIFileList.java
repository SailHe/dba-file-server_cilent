package com.nit.dbms.file;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GUIFileList extends JFrame {

	private static final long serialVersionUID = 1L;
	// 程序主框架
	private JFrame jFrame;
	// 主面板
	private JPanel jPanel;
	// 删除按钮
	private JButton jButtonDel;
	// 查看按钮
	private JButton jButtonView;
	// 查询内容文本框
	private JTextField jTextMessage;
	// 浏览按钮
	private JButton jButtonQuery;
	// 显示消息的滚动面板
	private JScrollPane jScrollPane;
	// 显示消息的表格，用于使界面显示更规则
	private JTable jTable;
	// 表格初始化模型
	private DBViewTableModel dbViewModel;
	private String filePath;
	// 获取文件数据
	List<FileBean> listFile;
	private FileBean fileBean;

	public GUIFileList() {
		jButtonDel = new JButton("删除");
		jButtonView = new JButton("查看");
		jTextMessage = new JTextField("重输浏览路径");
		jButtonQuery = new JButton("浏览");
		// 获取文件数据
		filePath = "./";
		File dir = new File(filePath);
		File file[] = dir.listFiles();
		listFile = new ArrayList<FileBean>();
		for (int i = 0; i < file.length; i++) {
			fileBean = new FileBean();
			fileBean.setFId(i + 1);
			fileBean.setFileName(file[i].getName());
			listFile.add(fileBean);
		}
		// 滚动面板布局设置
		jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(0, 440));
		jScrollPane.setViewportView(getInfoTable());
		jPanel = new JPanel();
		// 定义整体菜单面板布局
		JPanel jPanelMenu = new JPanel();
		jPanelMenu.setLayout(new GridLayout(1, 4));
		jPanelMenu.add(jTextMessage);
		jPanelMenu.add(jButtonQuery);
		jPanelMenu.add(jButtonView);
		jPanelMenu.add(jButtonDel);
		// 添加列表
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jScrollPane, BorderLayout.CENTER);
		jPanel.add(jPanelMenu, BorderLayout.NORTH);
		// 定义主界面框架
		jFrame = new JFrame("文件信息");
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

		// 浏览按钮单击事件
		jButtonView.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				// 单击触发事件
				try {
					JOptionPane.showMessageDialog(null, filePath + "/" + jTable.getValueAt(jTable.getSelectedRow(), 1));
				} catch (Exception en) {
					en.printStackTrace();
				}
			}
		});

		// 查询消息按钮单击事件
		jButtonQuery.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				// 单击触发事件
				try {
					File dir = new File(jTextMessage.getText());
					File file[] = dir.listFiles();
					listFile = new ArrayList<FileBean>();
					for (int i = 0; i < file.length; i++) {
						fileBean = new FileBean();
						fileBean.setFId(i + 1);
						fileBean.setFileName(file[i].getName());
						listFile.add(fileBean);
					}
					getInfoTable().updateUI();
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
			jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
			jTable.getColumnModel().getColumn(1).setPreferredWidth(400);
			jTable.getColumnModel().getColumn(2).setPreferredWidth(100);
			// 设置表头和行高
			jTable.getTableHeader().setPreferredSize(new Dimension(0, 30));
			jTable.setRowHeight(30);
			// 设置table内容居中
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			jTable.setDefaultRenderer(Object.class, tcr);

			// 鼠标单击事件，在此修改已读和未读的标志位
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
					try {
						if (jTable.getValueAt(jTable.getSelectedRow(), 0) != null) {
							// 你选中了一行
							JOptionPane.showMessageDialog(null,
									filePath + "/" + jTable.getValueAt(jTable.getSelectedRow(), 1));
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
		@Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		// 返回表格的列数
		@Override
        public int getColumnCount() {
			return 3;
		}

		// 返回表格的行数
		@Override
        public int getRowCount() {
			return listFile.size();
		}

		// 文件列表表头
		@Override
        public String getColumnName(int col) {
			switch (col) {
			case 0:
				return "序号";
			case 1:
				return "文件名称";
			case 2:
				return "文件大小";
			}
			return "";
		}

		// 显示列表值
		@Override
        public Object getValueAt(int row, int col) {
			fileBean = listFile.get(row);
			if (col == 0) {
				return fileBean.getFId();
			}
			if (col == 1) {
				return fileBean.getFileName();
			}
			if (col == 2) {
				return "unknown K";
			}
			return null;
		}
	}

	public static void main(String args[]) {
		new GUIFileList();
	}
}
