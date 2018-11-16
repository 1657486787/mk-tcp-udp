/**
 * Project Name:mk-tcp-udp <br>
 * Package Name:com.suns.udp <br>
 *
 * @author mk <br>
 * Date:2018-11-16 16:34 <br>
 */

package com.suns.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * ClassName: UdpClient <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-16 16:34 <br>
 * @version
 */
public class UdpClient {

    private final static int PORT = 1234;
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            System.out.println("udp客户端启动成功，"+datagramSocket.getLocalSocketAddress());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while(null != (msg = bufferedReader.readLine())){
                byte[] bytes = msg.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,new InetSocketAddress("127.0.0.1",PORT));
                datagramSocket.send(datagramPacket);
                System.out.println("udp客户端发送消息："+msg);
                if("88".equals(msg)){
                    Thread.sleep(1000);
                    System.out.println("客户端下线了，"+datagramSocket.getLocalSocketAddress());
                    break;
                }
            }



        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
