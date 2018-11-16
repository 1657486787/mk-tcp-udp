/**
 * Project Name:mk-tcp-udp <br>
 * Package Name:com.suns.rmi <br>
 *
 * @author mk <br>
 * Date:2018-11-16 17:00 <br>
 */

package com.suns.rmi;

import com.suns.service.HelloService;
import com.suns.service.impl.HelloServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * ClassName: RmiServer <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-16 17:00 <br>
 * @version
 */
public class RmiServer {

    private static int port = 1234;
    private static String rmiPath = "rmi://127.0.0.1:"+port;


    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(port);
        HelloService helloService = new HelloServiceImpl();
        Naming.bind(rmiPath+"/helloService",helloService);
        System.out.println("Waiting for invocations from clients ...");
    }
}
