package com.company.Proxy;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Testing program for remote adder server
 */
public class RemoteAdderServer {
    public static void main (String[] ignore) {
        int result;
        try {
            AdderIF adder = new AdderProxy();
        }
        catch (Exception e) {
            System.out.println("RemoteAdderServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
