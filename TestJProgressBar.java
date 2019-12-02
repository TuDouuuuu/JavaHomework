import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.awt.Color;

public class TestJProgressBar{
	static BarThread stepper;
	//进度条线程
	static class BarThread extends Thread{
		private static int DELAY = 500;
		JProgressBar progressBar;
		private boolean m_bStopped;
		private boolean m_bPaused=false;
		//构造方法
		public BarThread(JProgressBar bar) {
			progressBar = bar;
			m_bStopped=false;
			m_bPaused=false;
		}
		//线程体
		public void run() {
			int minimum = progressBar.getMinimum();//取得最小值
			int maximum = progressBar.getMaximum();//取得最大值
			for (int i = minimum; i < maximum; i++) {
				if(m_bStopped){
					progressBar.setValue(0);	
					break;
				}
				try {
					while(m_bPaused)
						//延时DELAY毫秒
						Thread.sleep(DELAY);
				
					int value = progressBar.getValue();
					progressBar.setValue(value + 1);
					//延时DELAY毫秒
					Thread.sleep(DELAY);
				}
				catch (InterruptedException ignoredException) {
				}
			}
		}
		//设置暂停
		public void Pause(boolean bPaused){
			m_bPaused=bPaused;
		}
		//设置停止
		public void Stop(boolean bStopped){
			m_bStopped=bStopped;
		}
	}

	public static void main(String args[]) {
		JFrame frm= new JFrame("JFrame with JProgressBar");
		//设置进度条属性
		final JProgressBar aJProgressBar = new JProgressBar(0, 50);//进度条从0-50
		aJProgressBar.setStringPainted(true);
		aJProgressBar.setBackground(Color.white);
		aJProgressBar.setForeground(Color.blue);		
		//定义按钮
		final JButton btnStart = new JButton("开始");
		final JButton btnStop = new JButton("停止");
		
		//按钮事件处理程序
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(e.getSource()==btnStart){//开始或暂停
					if(stepper==null){
						stepper=new BarThread(aJProgressBar);
						btnStop.setEnabled(true);					
						stepper.start();						
					}
					if(btnStart.getText().equals("开始") | btnStart.getText().equals("继续")){//非暂停状态，即开始状态
						btnStart.setText("暂停");
						stepper.Pause(false);
					}
					else{
						btnStart.setText("继续");
						stepper.Pause(true);
					}					
				}else{
					btnStart.setText("开始");
					btnStop.setEnabled(false);
					stepper.Stop(true);
					stepper=null;
				}
				
			}
		};
		//关联事件源
		btnStart.addActionListener(actionListener);
		btnStop.addActionListener(actionListener);
		//添加组件到界面上
		frm.add(aJProgressBar, BorderLayout.NORTH);
		JPanel jp=new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp.add(btnStart);
		jp.add(btnStop);
		btnStop.setEnabled(false);
		frm.add(jp, BorderLayout.SOUTH);
		//设置窗口属性
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(300, 100);
		//frm.pack();
		frm.setVisible(true);
	}
}

