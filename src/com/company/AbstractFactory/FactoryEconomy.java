package com.company.AbstractFactory;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Concrete factory for creating an Account and SecurityManager for an "Economy" user
 */
public class FactoryEconomy extends AbstractFactoryIF  {
    public AccountIF createAccount(int loginID) {
        return new AccountEconomy(loginID);
    }

    public SecurityManagerIF createSecurityManager() {
        return new SecurityManagerEconomy();
    }
}
