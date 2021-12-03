import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：Swing计时器组件
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/3
 * Time(创建时间)： 20:24
 * Version(版本): 1.0
 * Description(描述)： 计时器（Timer）组件可以在指定时间间隔触发一个或多个 ActionEvent。
 * 设置计时器的过程包括创建一个 Timer 对象，在该对象上注册一个或多个动作侦听器，以及使用 start() 方法启动该计时器。
 * 创建 Timer 类时要指定一个延迟参数和一个 ActionListener。延迟参数用于设置初始延迟和事件触发之间的延迟（以毫秒为单位）。
 * 启动计时器后，它将在向已注册监听器触发第一个 ActionEvent 之前等待初始延迟。第一个事件之后，每次超过事件间延迟时它都继续触发事件，直到被停止。
 * 创建 Timer 类之后，可以单独更改初始延迟和事件间延迟，并且可以添加其他 ActionListener。
 * 如果希望计时器只在第一次时触发然后停止，可以对计时器调用 setRepeats(false)。
 * Timer类的常用方法
 * 方法名称	说明
 * addActionListener(ActionListener 1)	将一个动作监听器添加到 Timer
 * getDelay()	返回两次触发动作事件间延迟，以毫秒为单位
 * isCoalesce()	如果 Timer 组合多个挂起的动作事件，则返回 true
 * isRunning()	如果 Timer 正在运行，则返回 true
 * restart()	重新启动 Timer，取消所有挂起的触发并使它按初始延迟触发
 * setCoalesce(boolean flag)	设置 Timer 是否组合多个挂起的 ActionEvent
 * setDelay(int delay)	设置 Timer 的事件间延迟，两次连续的动作事件之间的毫秒数
 * setLogTimers(boolean flag)	启用/禁用计时器日志
 * setRepeats(boolean flag)	如果 flag 为 false，则指示 Timer 只向其监听器发送一次动作事件
 * start()	启动 Timer，使它开始向其监听器发送动作事件
 * stop()	停止 Timer，使它停止向其监听器发送动作事件
 */

public class test implements ActionListener, ChangeListener
{
    JFrame frame = null;
    JProgressBar progressbar;
    JLabel label;
    Timer timer;
    JButton button;

    public test()
    {
        frame = new JFrame("软件安装");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        label = new JLabel(" ", JLabel.CENTER);    //创建显示进度信息的文本标签
        progressbar = new JProgressBar();    //创建一个进度条
        progressbar.setOrientation(JProgressBar.HORIZONTAL);
        progressbar.setMinimum(0);
        progressbar.setMaximum(100);
        progressbar.setValue(0);
        progressbar.setStringPainted(true);
        progressbar.addChangeListener(this);    //添加事件监听器
        //设置进度条的几何形状
        progressbar.setPreferredSize(new Dimension(300, 20));
        progressbar.setBorderPainted(true);
        progressbar.setBackground(Color.pink);
        //添加启动按钮
        JPanel panel = new JPanel();
        button = new JButton("安装");
        button.setForeground(Color.blue);
        //添加事件监听器
        button.addActionListener(this);
        panel.add(button);
        timer = new Timer(100, this);    //创建一个计时器，计时间隔为100毫秒
        //把组件添加到frame中
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(progressbar, BorderLayout.CENTER);
        contentPane.add(label, BorderLayout.SOUTH);
        frame.setSize(640,130);
        frame.setLocation(1920/2-640/2,1080/2-130/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button)
        {
            timer.start();
        }
        if (e.getSource() == timer)
        {
            int value = progressbar.getValue();
            if (value < 100)
            {
                progressbar.setValue(++value);
            }
            else
            {
                timer.stop();
                frame.dispose();
                Toolkit.getDefaultToolkit().beep();
                System.exit(1);
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        int value = progressbar.getValue();
        if (e.getSource() == progressbar)
        {
            label.setText("目前已完成进度：" + Integer.toString(value) + " %");
            label.setForeground(Color.blue);
        }
    }

    public static void main(String[] args)
    {
        test t=new test();
    }
}
