package com.company.Proxy;

import java.rmi.Naming;

/**
 * Testing class for remote adder client
 */
public class RemoteAdderClient {
    public static void main(String [] ignore) {
        int result;
        try {
            AdderIF adder = (AdderIF) Naming.lookup("//" + "localhost" + ":" + 1099 + "/Adder");
            System.out.println("The Proxy adder will return 0 if first argument > 500");
            System.out.println("Expected behavior: 501 + 2 = 0.  ");
            System.out.println("Results:");
            result = adder.add(1, 2);
            System.out.println("1 + 2 = " + result);
            result = adder.add(501, 2);
            System.out.println("501 + 2 = " + result);
        }
        catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

}