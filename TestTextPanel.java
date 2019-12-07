public class TestTextPanel {
    public TestTextPanel() {
        textPane=new javax.swing.JTextPane();
        javax.swing.text.Document doc=new javax.swing.text.DefaultStyledDocument();
        init(doc);
        javax.swing.JFrame frame=new javax.swing.JFrame();
        javax.swing.JScrollPane spanel=new  javax.swing.JScrollPane(textPane);
        frame.getContentPane().add(spanel,java.awt.BorderLayout.CENTER);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(30,30,300,300);
        frame.setVisible(true);
    }
    public static void main (String args[]) {
        new TestTextPanel();
    }    
    public void init(javax.swing.text.Document doc) {
        textPane.setDocument(doc);        
        javax.swing.text.SimpleAttributeSet attributeSet=new javax.swing.text.SimpleAttributeSet();
        // javax.swing.text.StyleConstants.setFirstLineIndent(attributeSet,80);
        // javax.swing.text.StyleConstants.setForeground(attributeSet,java.awt.Color.red);
        // javax.swing.text.StyleConstants.setFontSize(attributeSet,20);                
        try{
            // textPane.setParagraphAttributes(attributeSet,true) ;
            javax.swing.text.StyleConstants.setFontSize(attributeSet,60);
            doc.insertString(0,"红色小字体",attributeSet);
            javax.swing.text.StyleConstants.setFontSize(attributeSet,20);
            // javax.swing.text.StyleConstants.setFontSize(attributeSet,40);
            // doc.insertString(doc.getLength(),"红色中字体",attributeSet);
            
            // doc.insertString(0,"红色大字体\n",attributeSet); 
            
            // attributeSet=new javax.swing.text.SimpleAttributeSet();
            // javax.swing.text.StyleConstants.setForeground(attributeSet,java.awt.Color.green);
            // textPane.setCaretPosition(doc.getLength());
            // javax.swing.text.StyleConstants.setFirstLineIndent(attributeSet,140);
            // textPane.setParagraphAttributes(attributeSet,true) ;        
            // doc.insertString(doc.getLength(),"缩进更大",attributeSet);             
            // javax.swing.text.StyleConstants.setFontSize(attributeSet,20);
            // doc.insertString(doc.getLength(),"绿色小字体",attributeSet);    
            // javax.swing.text.StyleConstants.setFontSize(attributeSet,40);
            // doc.insertString(doc.getLength(),"绿色中字体",attributeSet);      
            // javax.swing.text.StyleConstants.setFontSize(attributeSet,60);
            // doc.insertString(doc.getLength(),"绿色大字体\n",attributeSet);      
            
        }catch(Exception e){e.printStackTrace(System.out);}           
    }     
    private javax.swing.JTextPane textPane;
}