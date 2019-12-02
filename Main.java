import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]){
        Frame frm = new Frame("201806060825－叶璇－Java程序设计综合实验");
        // Frame.Mainfun();
        // Frame.centerWindow(frm);
    }
}

class MenuBar extends JMenuBar{

}


class Frame extends JFrame{
    // static JMenuBar mb = new JMenuBar();
    static JToolBar mt = new JToolBar();
    static JTextArea ma = new JTextArea();

    // 菜单栏  
    FgMenu mFile = new FgMenu("文件(F)",KeyEvent.VK_F);
    FgMenu mJava = new FgMenu("Java上机题目");
    FgMenu mConnect = new FgMenu("通讯录(C)",KeyEvent.VK_C);

    // "文件"菜单
    static JMenuItem mfNew = new JMenuItem("新建(N)",KeyEvent.VK_N);
    static JMenuItem mfOpen = new JMenuItem("打开(O)",KeyEvent.VK_O);
    static JMenuItem mfSave = new JMenuItem("保存(S)",KeyEvent.VK_S);
    static JMenuItem mfFont = new JMenuItem("字体(F)",KeyEvent.VK_F);
    static JMenuItem mfBack = new JMenuItem("背景颜色(B)",KeyEvent.VK_B);
    static JMenuItem mfQuit = new JMenuItem("退出(Q)",KeyEvent.VK_Q);

    // "Java上机题目"菜单
    static JMenuItem mjPara = new JMenuItem("回文数(P)",KeyEvent.VK_P);
    static JMenuItem mjTrans = new JMenuItem("数字与英文互译(T)",KeyEvent.VK_T);
    static JMenuItem mjExcel = new JMenuItem("统计英文数据(E)",KeyEvent.VK_E);
    static JMenuItem mjSum = new JMenuItem("文本文件求和(S)",KeyEvent.VK_S);

    // "通讯录"菜单
    static JMenuItem mcMaintain = new JMenuItem("通讯录维护(M)",KeyEvent.VK_M);
    static JMenuItem mcSavefile = new JMenuItem("通讯录存储文件设置(S)",KeyEvent.VK_S); 

    class Button extends JButton{
        public Button(Icon icon,String str){
            super(icon);setToolTipText(str);
        }
    } 

    class FgMenu extends JMenu{
        public FgMenu(String str){super(str);}
        public FgMenu(String str,int acc){super(str);setMnemonic(acc);}
    }

    // 构造函数
    Frame(String str){
        super(str);
        setSize(800,600);

        addMenue(); // 菜单
        addToolBar();   // 工具栏
        addTextArea();  // 文本编辑框
        centerWindow();// 居中显示
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {          
                int i = JOptionPane.showConfirmDialog(null, "确认退出吗？","Java程序设计综合实验",JOptionPane.YES_NO_OPTION);
                if(i==JOptionPane.OK_OPTION){   //关闭窗口
                    System.exit(0);                    
                }
            }
        });
    }

    // 添加菜单组件
    private void addMenue(){
        setJMenuBar(mb);
        // "文件"操作
        mFile.add(mfNew);mFile.add(mfOpen);mFile.add(mfSave);
        mFile.add(mfFont);mFile.add(mfBack);mFile.add(mfQuit);
        mb.add(mFile);
        // "Java上机文件"操作
        mJava.add(mjPara);mJava.add(mjTrans);
        mJava.add(mjExcel);mJava.add(mjExcel);
        mb.add(mJava);
        // "通讯录"菜单
        mConnect.add(mcMaintain);mConnect.add(mcSavefile);
        mb.add(mConnect);
    }

    // 添加工具条
    private void addToolBar(){
        Container ct = getContentPane();
        ct.add(BorderLayout.NORTH,mt);
        mt.setLayout(new FlowLayout(FlowLayout.LEFT));
        Button[] bts = {
            new Button(new ImageIcon(getClass().getResource("new.png")),"新建文件"),
            new Button(new ImageIcon(getClass().getResource("open.png")),"打开文件"),
            new Button(new ImageIcon(getClass().getResource("save.png")),"保存文件")
        };
        for(int i=0;i<bts.length;i++){
            bts[i].setBorder(BorderFactory.createEmptyBorder());
            mt.add(bts[i]);
        }
        mt.setFloatable(false);
    }

    // 添加带滚动条的文本框
    private void addTextArea(){
        JScrollPane sp = new JScrollPane(ma);
        add(sp);
    }

    // 窗体居中
    private void centerWindow(){
        Toolkit tk = getToolkit();
        Dimension dm = tk.getScreenSize();
        setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
    }
}