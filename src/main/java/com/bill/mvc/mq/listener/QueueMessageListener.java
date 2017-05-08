package com.bill.mvc.mq.listener;

import com.bill.mvc.utils.DateUtil;
import org.apache.activemq.util.TimeUtils;
import org.apache.commons.io.FileUtils;
import sun.jvm.hotspot.runtime.Bytes;

import javax.jms.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by chenking on 2017/5/6.
 */
public class QueueMessageListener implements MessageListener {
    public void onMessage(Message message) {
        try {
            System.out.println("receive message");
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage) message;
                System.out.println("queue listen text message " + tm.getText());
            }else if(message instanceof ObjectMessage){

                System.out.println("get objectmessage");

                ObjectMessage objmsg=(ObjectMessage)message;

                File movie= (File) objmsg.getObject();

                String path="/tmp/"+movie.getName();

                try{
                    saveFile(path,movie);
                }catch (IOException ex){
                    ex.printStackTrace();
                }

            }else if(message instanceof BytesMessage){
                BytesMessage bytesMessage=(BytesMessage)message;
                int length=(int)bytesMessage.getBodyLength();
                byte[]  results=new byte[length];
                bytesMessage.readBytes(results);

                String path="/tmp/"+ DateUtil.GetNowTimeNoEmpty()+".mp4";
                saveFileByByte(path,results);


            }


        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    //save file
    private void saveFile(String path,File file) throws IOException{
        File filedest=new File(path);
        FileUtils.copyFile(file,filedest);
    }

    //sace file
    private void saveFileByByte(String path,byte[] results){

        File file=new File(path);
        try{
            FileUtils.writeByteArrayToFile(file,results);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
