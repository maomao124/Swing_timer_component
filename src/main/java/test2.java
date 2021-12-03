import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：Swing计时器组件
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/3
 * Time(创建时间)： 20:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test2
{
    public static void main(String[] args)
    {
        final int[] i = {1};
        Timer t;
        ActionListener taskListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("第"+ i[0] +"次调用");
                i[0]++;
                Toolkit.getDefaultToolkit().beep();
            }
        };
        t= new Timer(2000,taskListener);
        t.start();
        try
        {
            Thread.sleep(22000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
