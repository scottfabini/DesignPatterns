package com.company.Marker;

import java.rmi.Remote;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Interface for a basic adder method that can be
 * accessed Remotely.
 *
 * Here, the Remote class is acting as the Marker pattern
 * It is an interface used to signal that this
 * interface is remote accessible
 */
public interface RemoteAdderIF extends Remote {
    int add(int x, int y) throws java.rmi.RemoteException;
}
