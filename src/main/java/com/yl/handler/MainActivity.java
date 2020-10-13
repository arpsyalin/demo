package com.yl.handler;

import org.springframework.cglib.core.MethodWrapper;

import javax.xml.soap.Text;

/**
 * * @Description 主Activity
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark TODO
 **/
public class MainActivity extends Activity {
    TextView textView;
    Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
        textView = findViewById(R.id_text);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String string = (String) msg.obj;
                textView.setText(string);
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Message message = new Message();
                    message.obj = "111111";
                    mHandler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Message message = new Message();
        message.obj = "ssssssss1";
        mHandler.sendMessageDelay(message, 6000);

        Message message1 = new Message();
        message1.obj = "ssssssss2";
        mHandler.sendMessageDelay(message1, 5000);

        Message message2 = new Message();
        message2.obj = "ssssssss3";
        mHandler.sendMessageDelay(message2, 3000);
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume");
    }
}
