package model.statement;

import model.ADT.Dictionary.DictionaryInterface;
import model.ADT.Heap.HeapInterface;
import model.ADT.List.ListInterface;
import model.ProgramState;
import model.expression.ExpressionInterface;
import model.value.ValueInterface;

public class PrintStatement implements StatementInterface{
    private ExpressionInterface expression;

    public PrintStatement(ExpressionInterface expression) {
        this.expression = expression;
    }

    @Override
    public String toString(){
        return "print("+expression.toString()+")";
    }

    @Override
    public StatementInterface deepCopy() {
        return new PrintStatement(expression);
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        ListInterface<ValueInterface> output = state.getOutput();
        DictionaryInterface<String, ValueInterface> symbolTable = state.getSymbolTable();
        HeapInterface<Integer, ValueInterface> heap = state.getHeap();

        output.add(expression.evaluate(symbolTable, heap));
        return state;
    }
}
