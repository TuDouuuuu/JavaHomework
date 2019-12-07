import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JButton; 
import javax.swing.JEditorPane; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTextPane; 
import javax.swing.UIManager; 
import javax.swing.WindowConstants; 
import javax.swing.text.AttributeSet; 
import javax.swing.text.DefaultStyledDocument; 
import javax.swing.text.Document; 
import javax.swing.text.EditorKit; 
import javax.swing.text.MutableAttributeSet; 
import javax.swing.text.SimpleAttributeSet; 
import javax.swing.text.StyleConstants; 
import javax.swing.text.StyledDocument; 
import javax.swing.text.StyledEditorKit; 

public class NewJFrame extends javax.swing.JFrame implements ActionListener { 
    private JPanel jp1; 
    private JButton color; 
    private JTextPane jep; 
    private JScrollPane jsp; 
    private JButton font; 
    /** 
      * Auto-generated main method to display this JFrame 
      */ 
    public static void main(String[] args) { 
      NewJFrame inst = new NewJFrame(); 
      inst.setVisible(true); 
    } 
    public NewJFrame() { 
      super(); 
      initGUI(); 
    } 
    private void initGUI() { 
      try { 
       BorderLayout thisLayout = new BorderLayout(); 
       getContentPane().setLayout(thisLayout); 
       setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
       { 
        jp1 = new JPanel(); 
        getContentPane().add(jp1, BorderLayout.NORTH); 
        {  
         font = new JButton(); 
         font.addActionListener(this); 
         jp1.add(font); 
         font.setText("font"); 
        } 
        { 
         color = new JButton(); 
         jp1.add(color); 
         color.addActionListener(this); 
         color.setText("color"); 
        } 
       } 
       { 
        jsp = new JScrollPane(); 
        getContentPane().add(jsp, BorderLayout.CENTER); 
        { 
         jep = new JTextPane(); 
         jsp.setViewportView(jep); 
         jep.setDocument(new DefaultStyledDocument()); 
        } 
       } 
       pack(); 
       setSize(400, 300); 
      } catch (Exception e) { 
       e.printStackTrace(); 
      } 
    } 

    public static void setFontSize(JEditorPane editor, int size) { 
      if (editor != null) { 
       if ((size > 0) && (size < 512)) { 
        MutableAttributeSet attr = new SimpleAttributeSet(); 
        StyleConstants.setFontSize(attr, size); 
        setCharacterAttributes(editor, attr, false); 
       } else { 
        UIManager.getLookAndFeel().provideErrorFeedback(editor); 
       } 
      } 
    } 

    public static void setForeground(JEditorPane editor, Color fg) { 
      if (editor != null) { 
       if (fg != null) { 
        MutableAttributeSet attr = new SimpleAttributeSet(); 
        StyleConstants.setForeground(attr, fg); 
        setCharacterAttributes(editor, attr, false); 
       } else { 
        UIManager.getLookAndFeel().provideErrorFeedback(editor); 
       } 
      } 
    } 

    public static final void setCharacterAttributes(JEditorPane editor, 
       AttributeSet attr, boolean replace) { 
      int p0 = editor.getSelectionStart(); 
      int p1 = editor.getSelectionEnd(); 
      if (p0 != p1) { 
       StyledDocument doc = getStyledDocument(editor); 
       doc.setCharacterAttributes(p0, p1 - p0, attr, replace); 
      } 
      StyledEditorKit k = getStyledEditorKit(editor); 
      MutableAttributeSet inputAttributes = k.getInputAttributes(); 
      if (replace) { 
       inputAttributes.removeAttributes(inputAttributes); 
      } 
      inputAttributes.addAttributes(attr); 
    } 

    protected static final StyledDocument getStyledDocument(JEditorPane e) { 
      Document d = e.getDocument(); 
      if (d instanceof StyledDocument) { 
       return (StyledDocument) d; 
      } 
      throw new IllegalArgumentException("document must be StyledDocument"); 
    } 

    protected static final StyledEditorKit getStyledEditorKit(JEditorPane e) { 
      EditorKit k = e.getEditorKit(); 
      if (k instanceof StyledEditorKit) { 
       return (StyledEditorKit) k; 
      } 
      throw new IllegalArgumentException("EditorKit must be StyledEditorKit"); 
    } 

    public void actionPerformed(ActionEvent e) { 
      Object obj = e.getSource(); 
      if (obj == font) { 
       JEditorPane editor = jep; 
       setFontSize(editor, 20); 
      } 
      if (obj == color) { 
       JEditorPane editor = jep; 
       setForeground(editor, Color.red); 
      } 
    } 

} 