package com.company.Visitor;

import com.company.Visitor.Expr.Expr;
import com.company.Visitor.Statement.Statement;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/25/16
 */
public interface Visitor {
    public Object visit(Statement statement, Integer integer);
    public Object visit(Expr expr, Integer integer);
}
