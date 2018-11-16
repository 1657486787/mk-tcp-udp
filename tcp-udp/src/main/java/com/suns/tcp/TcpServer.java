/**
 * Project Name:mk-tcp-udp <br>
 * Package Name:com.suns.tcp <br>
 *
 * @author mk <br>
 * Date:2018-11-16 15:29 <br>
 */

package com.suns.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: TcpServer <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-16 15:29 <br>
 * @version
 */
public class TcpServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader bufferedReader = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("tcp服务器启动成功，等等客户端上线");
            while(true){
                socket = serverSocket.accept();
                System.out.println("有客户端上线，"+socket.getRemoteSocketAddress());
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg = null;
                while(null != ( msg = bufferedReader.readLine())){
                    System.out.println("tcp服务器接受消息："+msg);

                    if("88".equals(msg)){
                        System.out.println("客户端下线了，"+socket.getRemoteSocketAddress());
                        break;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != bufferedReader){
                    bufferedReader.close();
                }
                if(null != socket){
                    socket.close();
                }
                if(null != serverSocket){
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
