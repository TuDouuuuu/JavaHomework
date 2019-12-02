// 本代码来自于互联网
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Demo {
    private JFrame frame;

    public static void main(String[] args) {
        Demo window = new Demo();
        window.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {                
                int i= JOptionPane.showConfirmDialog(null, "确认退出吗？");
                if(i==JOptionPane.OK_OPTION){
                    System.exit(0);                    
                }else{
                    
                }
            }
        });
    }

    public Demo() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认点击关闭
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}