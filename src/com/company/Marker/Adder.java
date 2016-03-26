package com.company.Marker;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Remotely accessible adder.
 * The extension of UnicastRemoteObject and
 * the implementation of RemoteAdder (which extends the Remote marker)
 * make this class remote accessible.
 *
 * Run this program in a separate window in the IDE to instantiate the main()
 */
public class Adder extends UnicastRemoteObject implements RemoteAdderIF {
    /**
     * Default constructor
     * @throws RemoteException
     */
    public Adder() throws RemoteException {}
    public int add(int x, int y) throws java.rmi.RemoteException {
        return x + y;
    }

    /**
     * Test program for the adder itself
     * @param ignore
     */
    public static void main(String [] ignore) {
        try {
            Adder adder = new Adder();

            try {
                java.rmi.registry.LocateRegistry.createRegistry(1099);
                System.out.println("RMI registry ready.");
            } catch (Exception e) {
                System.out.println("Exception starting RMI registry:");
                e.printStackTrace();
            }
            Naming.rebind("Adder", adder);
        }
        catch (Exception e) {
            System.out.println("Adder error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
