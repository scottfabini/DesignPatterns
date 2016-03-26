package com.company.AbstractFactory;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * The AbstractFactoryIF manages the creation of both an
 * Account and SecurityManager for a single User.
 * To create a concrete factory, implement the createAccount and
 * createSecurityManager methods to return a concrete class that
 * extends the AccountIF and SecurityManagerIF, respectively.
 */
public abstract class AbstractFactoryIF  {
    /**
     * Each concrete instantiation of this interface has an account interface
     */
    protected AccountIF account;

    /**
     * Each concrete instantiation of this interface has a security manager interface
     */
    protected SecurityManagerIF securityManager;

    /**
     * Abstract factory interface for creating securityManagers
     * @return Security Manager Inteface
     */
    public abstract SecurityManagerIF createSecurityManager();

    /**
     * Abstract factory interface for creating accounts
     * @return Account Inteface
     */
    public abstract AccountIF createAccount(int loginID);

}
