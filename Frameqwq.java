// 框架文件
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Frame extends JFrame{
    static JMenuBar mb = new JMenuBar();

    // 菜单栏
    static FgMenu mFile = new FgMenu("文件(F)",KeyEvent.VK_F);
    static FgMenu mJava = new FgMenu("Java上机题目");
    static FgMenu mConnect = new FgMenu("通讯录(C)",KeyEvent.VK_C);

    // "文件"菜单
    static JMenuItem mfNew = new JMenuItem("新建(N)",KeyEvent.VK_N);
    static JMenuItem mfOpen = new JMenuItem("打开(O)",KeyEvent.VK_O);
    static JMenuItem mfSave = new JMenuItem("保存(S)",KeyEvent.VK_S);
    static JMenuItem mfFont = new JMenuItem("字体(F)",KeyEvent.VK_F);
    static JMenuItem mfBack = new JMenuItem("背景颜色(B)",KeyEvent.VK_B);
    static JMenuItem mfQuit = new JMenuItem("退出(Q)",KeyEvent.VK_Q);

    // 

    // 构造函数
    Frame(String str){
        super(str);
        setSize(400,300);
        addMenue();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        centerWindow();
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
        mFile.add(mfNew);
        mFile.add(mfOpen);
        mFile.add(mfSave);
        mFile.add(mfFont);
        mFile.add(mfBack);
        mFile.add(mfQuit);

        mb.add(mFile);
    }

    // 窗体居中
    private void centerWindow(){
        Toolkit tk = getToolkit();
        Dimension dm = tk.getScreenSize();
        setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
    }

}