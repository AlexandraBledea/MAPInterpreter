package model.expression;

import com.sun.jdi.Value;
import exception.InvalidOperatorException;
import exception.InvalidTypeException;
import model.ADT.DictionaryInterface;
import model.type.BoolType;
import model.value.BoolValue;
import model.value.ValueInterface;

public class LogicalExpression implements ExpressionInterface{

    private ExpressionInterface firstExpression;
    private ExpressionInterface secondExpression;
    private int operator;

    public LogicalExpression(ExpressionInterface firstExpression, ExpressionInterface secondExpression, int operator) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operator = operator;
    }

    @Override
    public ValueInterface evaluate(DictionaryInterface<String, ValueInterface> table) throws Exception {
        ValueInterface firstValue;
        ValueInterface secondValue;
        firstValue = this.firstExpression.evaluate(table);
        if(firstValue.getType().equals(new BoolType())){
            secondValue = this.secondExpression.evaluate(table);
            if(secondValue.getType().equals(new BoolType())){
                boolean firstBoolean = ((BoolValue)firstValue).getValue();
                boolean secondBoolean = ((BoolValue)secondValue).getValue();

                if(operator == 1){
                    return new BoolValue(firstBoolean && secondBoolean);
                }
                if(operator == 2){
                    return new BoolValue(firstBoolean || secondBoolean);
                }
                else {
                    throw new InvalidOperatorException();
                }
            }
            else
            {
                throw new InvalidTypeException("Second operand not a boolean!");
            }
        }
        else {
            throw new InvalidTypeException("First operand not a boolean!");
        }
    }
}
