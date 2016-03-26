package com.company.Flyweight;

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
public class flyweightDriver {
    /** Usual entry point. Constructs and pretty prints an example program. */
    public static void main (String [] arg) {
        Statement factorial = new Compound (
               // new Assignment("fact", new Expr ()),
                new While (FlyweightFactory.get("1"), new Compound(
                        // new Assignment("fact", new Expr()),
                        new Assignment("fact", FlyweightFactory.get("n")),
                        new Assignment("n", FlyweightFactory.get("n")))));
        factorial.print (System.out, 0);
        System.out.println ();
    }
}
