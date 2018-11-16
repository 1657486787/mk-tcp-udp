/**
 * Project Name:mk-tcp-udp <br>
 * Package Name:com.suns.service <br>
 *
 * @author mk <br>
 * Date:2018-11-16 17:00 <br>
 */

package com.suns.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * ClassName: HelloService <br>
 * Description:  <br>
 * @author mk
 * @Date 2018-11-16 17:00 <br>
 * @version
 */
public interface HelloService extends Remote {

    String sayHello(String name) throws RemoteException;
}
