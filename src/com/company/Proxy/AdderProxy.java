package com.company.Proxy;

import java.rmi.Naming;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Proxy for the Adder class.  This class contains a constructor to make this class's methods
 * remote-accessible.  It provides an add(x,y) proxy method, which returns a normal addition using the
 * Adder.add(x,y) method, -unless- the x argument is greater than 500.  If x > 500, the proxy returns a
 * result of 0 (just to demonstrate that the proxy is working).
 */
public class AdderProxy implements AdderIF {
    protected Adder adder;

    /**
     * Instantiate the Adder object, which we will act as proxy for.
     */
    public AdderProxy() throws java.rmi.RemoteException {
        adder = new Adder();

        // Create an rmiregistry to listen on port 1099 and enable remote access to the add(x,y) method
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.out.println("Exception starting RMI registry:");
            e.printStackTrace();
        }

        // Bind the name "Adder" to be the remote name for the Adder object which we will act as proxy for
        try {
            Naming.rebind("Adder", adder);
        }
        catch (Exception e) {
            System.out.println("Error in Adder when attempting to rebind name: " + e.getMessage());
            e.printStackTrace();
        }

        // Discussion: One purpose of a proxy is to defer the full cost of creation and initialization
        // until we actually need to use it.  Is this being accomplished here?
        // No.  We instantiate and initialize the proxy server in the constructor.
        // It appears that Remote Proxies differ than Virtual Proxies in this respect.
        // I.e. it's about hiding the remote setup/teardown aspect, rather than hiding object
        // creation/initialization as a whole?
    }

    /**
     * This proxy add function will return 0 if the first argument (x) is > 0.
     * Otherwise, it calls the Adder class's add(x,y) method.
     * This acts as a simple test to show that the proxy pattern is working
     * The proxy 'intercepts' if the x argument is > 500 and acts for the concrete adder.
     */
    public int add(int x, int y) throws java.rmi.RemoteException {
        try {
            if (x < 500) {
                return adder.add(x, y);
            }
        }
        catch (Exception e) {
            System.out.println("AdderProxy exception: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}
