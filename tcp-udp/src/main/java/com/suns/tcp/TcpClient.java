/**
 * Project Name:mk-tcp-udp <br>
 * Package Name:com.suns.tcp <br>
 *
 * @author mk <br>
 * Date:2018-11-16 15:33 <br>
 */

package com.suns.tcp;

import java.io.*;
import java.net.Socket;

/**
 * ClassName: TcpClient <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-16 15:33 <br>
 * @version
 */
public class TcpClient {

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        try {
            socket = new Socket("127.0.0.1", 12345);
            System.out.println("tcp客户端启动成功，连接远程客户端，"+socket.getRemoteSocketAddress());
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(socket.getOutputStream());
            String msg = null;
            while(null != (msg = bufferedReader.readLine())){
                printWriter.println(msg);
                printWriter.flush();
                System.out.println("tcp客户端发送消息："+msg);
                if("88".equals(msg)){
                    System.out.println("客户端退出了，"+socket.getLocalSocketAddress());
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != bufferedReader){
                    bufferedReader.close();
                }
                if(null != printWriter){
                    printWriter.close();
                }
                if(null != socket){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
