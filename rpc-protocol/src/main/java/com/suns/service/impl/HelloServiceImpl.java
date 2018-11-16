/**
 * Project Name:mk-tcp-udp <br>
 * Package Name:com.suns.service.impl <br>
 *
 * @author mk <br>
 * Date:2018-11-16 17:01 <br>
 */

package com.suns.service.impl;

import com.suns.service.HelloService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * ClassName: HelloServiceImpl <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-16 17:01 <br>
 * @version
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    public HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException{
        System.out.println("调用了一次："+name);
        return "hello:"+name;
    }
}
