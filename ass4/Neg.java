/**
 * @author Ori Engelberg <turht50@gmail.com>
 * @version 1.0
 * @since 2016-04-21 */
public class Neg extends UnaryExpression implements Expression {

    private static int counter = 1;

    /** Neg constructor.
     * Give Neg an inhered argument and the operator "-".
     * <p>
     * @param negation - the argument of the expression.*/
    public Neg(Object negation) {
        super(negation);
        this.setOperator("-");
    }

    @Override
    /** Evaluate the Neg.
     * Set the arguments the value of minus(argument).
     * <p>
     * @throws Exception if the evaluation failed.
     * @return minus of the argument */
    public double evaluate() throws Exception {
        double neg = 0;
        try {
            //System.out.println(getArg().evaluate());
            neg = -(getArg().evaluate());
        } catch (Exception e) {
            System.out.println("neg evaluation faild :" + e);
            throw e;
        }
        return neg;
    }

    @Override
    /**
     * assigns a given expression to a var.
     * <p>
     * @param var - a string of the var to assign the expression to
     * @param expression - a string of the var to assign the expression to
     * @return a new Neg expression with the new assigned vars.*/
    public Expression assign(String var, Expression expression) {
        return new Neg(getArg().assign(var, expression));
    }

    @Override
    /** differentiate of Neg.
     * <p>
     * @param var - the var to differentiate according it.
     * @return the differentiate of -(u) => -(u'). */
    public Expression differentiate(String var) {
        return new Neg(getArg().differentiate(var));
    }

    /** Simplification of Neg.
     * If the argument is't var evaluate the expression else check for minus reduction.
     * <p>
     * @return the simplify expression. */
    public Expression simplify() {
        int flag = 0;
        //if there is no vars, evaluate
        if (getArg().getVariables() == null) {
            try {
                double evaluate = this.evaluate();
                Expression exp = new Num(evaluate);
                return exp;
            } catch (Exception e) {
                System.out.println("evaluate failed");
            }
        }
        // advanced simplification
        // --(expression) = expression, ---(expression) = -(expression).
        if (counter > 1) {
            flag = 1;
        }
        if (getArg() instanceof Neg) {
            counter += 1;
        }
        //simplify the arguments
            setArg(getArg().simplify());
        if (counter % 2 == 0) {
            if (flag == 0) {
                counter = 1;
            }
            return getArg();
        } else {
            counter += 1;
            return new Neg(getArg());
        }
    }
}