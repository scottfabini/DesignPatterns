package com.company.Decorator;

import com.company.Decorator.Expr.*;
import com.company.Decorator.Statement.Assignment;
import com.company.Decorator.Statement.Compound;
import com.company.Decorator.Statement.Statement;
import com.company.Decorator.Statement.While;

/**
 *  Driver for a Composite pattern example.
 *  Composite objects are programs in a simple "while" language
 *  defined by the following informal syntax:
 *  <PRE>
 *      Statement   ::= Assignment | Conditional | While | Compound
 *      Assignment  ::= Var := Expr
 *      Conditional ::= if Expr then Statement else Statement
 *      While       ::= while Expr do Statement
 *      Compound    ::= begin Statement; ...; Statement end
 *  </PRE>
 *  The main method constructs and pretty prints the following
 *  program
 *  <PRE>
 *      begin
 *        fact = 1;
 *        while (n > 1) do
 *          begin
 *            fact := fact * n;
 *            n := n - 1
 *          end
 *      end
 *  </PRE>
 */

public class Client {
    /** Usual entry point. Constructs and pretty prints an example program. */
    public static void main (String [] arg) {
        FlyweightFactory vf = FlyweightFactory.getInstance();
        Statement factorial = new Compound(
                new Assignment(vf.makeVar("n"), vf.makeLit(15)),
                new Assignment(vf.makeVar("fact"), vf.makeLit(1)),
                new While(new GT(vf.makeVar("n"), vf.makeLit(1)), new Compound(
                        new Assignment(vf.makeVar("fact"), new Mult(vf.makeVar("fact"), vf.makeVar("n"))),
                        new Assignment(vf.makeVar("n"), new Sub(vf.makeVar("n"), vf.makeLit(1))))),
                new Assignment(vf.makeVar("fact"), vf.makeVar("fact")));
        factorial.print (System.out, 0);
        System.out.println ();
        System.out.println("Interpreter result: " + factorial.interpret());
    }
}
