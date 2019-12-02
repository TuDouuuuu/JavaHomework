import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class work extends JFrame{
    JMenuBar mb=new JMenuBar();
    FgMenu mFile=new FgMenu("文件（F）",KeyEvent.VK_F),
                  mWork=new FgMenu("Java上机题目"),
                  mList=new FgMenu("通讯录",KeyEvent.VK_L);
    JMenuItem miNew=new JMenuItem("新建（N）",KeyEvent.VK_H),
                     miOpen =new JMenuItem("打开（O）...",KeyEvent.VK_O),
                     miSave =new JMenuItem("保存（S）",KeyEvent.VK_S),
                     miFont =new JMenuItem("字体与颜色（F）",KeyEvent.VK_F),
                     miQuit =new JMenuItem("退出（X）...",KeyEvent.VK_X);
    JTextArea ta=new JTextArea();
    JToolBar mtb=new JToolBar();
    work(String sTitle){
        super(sTitle);
        addMenus();
        JScrollPane sp=new JScrollPane(ta);
        add(sp);
        setSize(400,300);
        addToolBar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        centerWindow();

    }
    private void addMenus(){
        setJMenuBar(mb);
        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miSave);
        mFile.addSeparator();
        mFile.add(miFont);
        mFile.addSeparator();
        mFile.add(miQuit);
        mb.add(mFile);
        mb.add(mWork);
        mb.add(mList);
    }
    private void addToolBar(){
        Container c=getContentPane();
        c.add(BorderLayout.NORTH,mtb);
        mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
        FgButton[] btn= {
                new FgButton(new ImageIcon(getClass().getResource("new.gif")),"新建文件"),
                new FgButton(new ImageIcon(getClass().getResource("1.png")),"打开文件"),
                new FgButton(new ImageIcon(getClass().getResource("1.png")),"保存文件")
        };
        for(int i=0;i<btn.length;i++){
            btn[i].setBorder(BorderFactory.createEmptyBorder());
            mtb.add(btn[i]);
        }
        mtb.setFloatable(false);
    }
    public void centerWindow(){
        Toolkit tk=getToolkit();
        Dimension dm=tk.getScreenSize();
        setLocation((int)(dm.getWidth()-getWidth())/2,(int)(dm.getHeight()-getHeight())/2);
    }
    public static void main(String args[]){
        EventQueue.invokeLater(()->{
            work fr=new work("Java程序设计综合实验");
            fr.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            fr.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    int result = JOptionPane.showConfirmDialog(null, "确认退出?", "确认",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if(result == JOptionPane.OK_OPTION){
                        System.exit(0);
                    }
                }
            });
            fr.setVisible(true);
        });
    }
}

class FgMenu extends JMenu{
    public FgMenu(String label){
        super(label);
    }
    public FgMenu (String label,int nAccelerator){
        super(label);
        setMnemonic(nAccelerator);
    }
}

class FgButton extends JButton{
    public FgButton(){
        super() ;
    }
    public FgButton(Icon icon){
        super(icon);
    }
    public FgButton(Icon icon,String strToolTipText){
        super(icon);
        setToolTipText(strToolTipText);
    }
    public FgButton(String text){
        super(text);
    }
    public FgButton(String text,Icon icon,String strToolTipText){
        super(text,icon);
        setToolTipText(strToolTipText);
    }
}
