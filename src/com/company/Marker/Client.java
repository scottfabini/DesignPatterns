package com.company.Marker;

import java.rmi.Naming;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * A client to access the remote adder.
 * Note that the remote adder must be instantiated in
 * a separate window before starting this client.
 * I.e. the remote interface needs instantiated.
 *
 */
public class Client {
    public static void main(String [] ignore) {
        int result;
        try {
            RemoteAdderIF adder = (RemoteAdderIF) Naming.lookup("//" + "localhost" + ":" + 1099 + "/Adder");
            result = adder.add(1, 2);
            System.out.println("1 + 2 = " + result);
        }
        catch (Exception e) {
            System.out.println("Remote interface not found: " + e.getMessage());
            e.printStackTrace();
        }
    }

}