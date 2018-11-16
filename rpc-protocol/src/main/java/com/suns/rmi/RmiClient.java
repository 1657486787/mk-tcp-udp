/**
 * Project Name:mk-tcp-udp <br>
 * Package Name:com.suns.rmi <br>
 *
 * @author mk <br>
 * Date:2018-11-16 17:05 <br>
 */

package com.suns.rmi;

import com.suns.service.HelloService;

import java.rmi.Naming;

/**
 * ClassName: RmiClient <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-16 17:05 <br>
 * @version
 */
public class RmiClient {

    private static int port = 1234;
    private static String rmiPath = "rmi://127.0.0.1:"+port;
//    private static String rmiPath = "rmi://10.50.10.169:"+port;

    public static void main(String[] args) throws Exception {
        HelloService helloService = (HelloService) Naming.lookup(rmiPath+"/helloService");
        String result = helloService.sayHello("my name is remote client.");
        System.out.println("result:"+result);
    }
}
