/**
 * Project Name:mk-tcp-udp <br>
 * Package Name:com.suns.udp <br>
 *
 * @author mk <br>
 * Date:2018-11-16 16:23 <br>
 */

package com.suns.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ClassName: UdpServer <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-16 16:23 <br>
 * @version
 */
public class UdpServer {

    private final static int PORT = 1234;
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(PORT);
            System.out.println("udp服务器启动成功，等等客户端上线,"+datagramSocket.getLocalSocketAddress());
            byte [] bytes = new byte[1024];
            while(true){//无限循环是必须要的，因为不知道数据何时来
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                String result = new String(data);
                System.out.println("receive from "+datagramSocket.getRemoteSocketAddress()+",data:"+result);

                if("88".equals(result)){
                    System.out.println("客户端下线了，"+datagramSocket.getRemoteSocketAddress());
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
