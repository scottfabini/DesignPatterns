package com.company.AbstractFactory;

/**
 * @author Instructor
 *
 * This "instructor's code" was provided as part of the assignment.  Our goal is
 * to implement the pattern -without- requiring changes to the instructor's code.
 */
public class abstractFactoryDriver {
    /**
     * Static method to drive the AbstractFactory
     * @param loginIDarray Array of login ID strings
     */
    public static void abstractFactoryIFTest(String [] loginIDarray) {
        if (loginIDarray.length != 1) {
            System.err.println ("Command requires an argument");
            System.exit (1);
        }
        int loginId = -1;
        try { loginId = Integer.parseInt (loginIDarray [0]); }
        catch (NumberFormatException ex) {
            System.err.println ("Argument must be an integer");
            System.exit (1);
        }
        AbstractFactoryIF factory = null;
        // Note: Despite their names, FactoryEconomy and
        // FactoryStandard are both actually Concrete factories.
        // factory = new AbstractFactoryIF();
        if (1000 < loginId && loginId <= 5000)
            factory = new FactoryEconomy();
        else if (5000 < loginId && loginId <= 8000)
        	    factory = new FactoryStandard();
        //      Professional factories haven't been coded, yet
        //	else if (8000 < loginId && loginId <= 9999)
        //	    factory = new AbstractFactoryProfessional ();
        else {
            System.err.println ("Argument out of range");
            System.exit (1);
        }
        // Note how the following code is independent of the
        // account type: economy, standard or professional.
        // Both the account and the security manager are
        // created consistently (for each other) by the factory.
        // Essential Elements: our factory must provide an
        // interface to createAccount(login) and
        // createSecurityManager().
        User user = new User (factory.createAccount (loginId),
                factory.createSecurityManager ());
        System.out.println (user);
    }

}
