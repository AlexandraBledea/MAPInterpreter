package model;

import model.ADT.Dictionary.DictionaryInterface;
import model.ADT.Heap.HeapInterface;
import model.ADT.List.ListInterface;
import model.ADT.Stack.StackInterface;
import model.statement.StatementInterface;
import model.value.StringValue;
import model.value.ValueInterface;

import java.io.BufferedReader;

public class ProgramState {
    private StackInterface<StatementInterface> executionStack;
    private DictionaryInterface<String, ValueInterface> symbolTable;
    private DictionaryInterface<StringValue, BufferedReader> fileTable;
    private ListInterface<ValueInterface> output;
    private HeapInterface<Integer, ValueInterface> heap;
    private StatementInterface originalProgram;


    public ProgramState(StackInterface<StatementInterface> executionStack,
                        DictionaryInterface<String, ValueInterface> symbolTable,
                        ListInterface<ValueInterface> output,
                        DictionaryInterface<StringValue, BufferedReader> fileTable,
                        HeapInterface<Integer, ValueInterface> heap,
                        StatementInterface program) {
        this.executionStack = executionStack;
        this.symbolTable = symbolTable;
        this.output = output;
        this.fileTable = fileTable;
        this.heap = heap;
        this.originalProgram = program.deepCopy();
//        this.executionStack.push(originalProgram);
        this.executionStack.push(program);
    }

    @Override
    public String toString(){
        String representation = "";
        representation += "\n------------------\n";
        representation += "Execution Stack: \n";
        representation += this.executionStack.toString();
        representation += "\nSymbol Table:\n";
        representation += this.symbolTable.toString();
        representation += "\nOutput Table:\n";
        representation += this.output.toString();
        representation += "\nFile Table:\n";
        representation += this.fileTable.toString();
        representation += "\nHeap: \n";
        representation += this.heap.toString();

        return representation;
    }

    public StackInterface<StatementInterface> getExecutionStack(){
        return executionStack;
    }

    public DictionaryInterface<StringValue, BufferedReader> getFileTable(){
        return this.fileTable;
    }

    public DictionaryInterface<String, ValueInterface> getSymbolTable(){
        return symbolTable;
    }

    public ListInterface<ValueInterface> getOutput(){
        return output;
    }

    public HeapInterface<Integer, ValueInterface> getHeap(){
        return this.heap;
    }

    public void setFileTable(DictionaryInterface<StringValue, BufferedReader> newFileTable){
        this.fileTable = newFileTable;
    }

    public void setExecutionStack(StackInterface<StatementInterface> stack){
        executionStack = stack;
    }

    public void setSymbolTable(DictionaryInterface<String, ValueInterface> table){
        symbolTable = table;
    }

    public void setOutput(ListInterface<ValueInterface> list){
        output = list;
    }

    public void setHeap(HeapInterface<Integer, ValueInterface> newHeap){
        this.heap = newHeap;
    }

}
