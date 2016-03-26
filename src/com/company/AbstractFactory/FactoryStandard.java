package com.company.AbstractFactory;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Concrete factory for creating an Account and SecurityManager for a "Standard" user
 */
public class FactoryStandard extends AbstractFactoryIF  {
    public AccountIF createAccount(int loginID) {
        return new AccountStandard(loginID);
    }

    public SecurityManagerIF createSecurityManager() {
        return new SecurityManagerStandard();
    }
}
