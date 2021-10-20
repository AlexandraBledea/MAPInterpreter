package model.statement;

import exception.ExistingVariableException;
import exception.InvalidTypeException;
import model.ADT.DictionaryInterface;
import model.ADT.StackInterface;
import model.ProgramState;
import model.type.BoolType;
import model.type.IntType;
import model.type.TypeInterface;
import model.value.BoolValue;
import model.value.IntValue;
import model.value.ValueInterface;

public class VariableDeclarationStatement implements StatementInterface{

    private String name;
    private TypeInterface type;
    public static final int DEFAULT_INT_VALUE = 0;
    public static final boolean DEFAULT_BOOL_VALUE = false;

    public VariableDeclarationStatement(String name, TypeInterface type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString(){
        return type.toString() + " " + name;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception {
        DictionaryInterface<String, ValueInterface> symbolTable = state.getSymbolTable();
        if(symbolTable.containsKey(name)){
            throw new ExistingVariableException("Variable " + name + "is already declared!");
        }
        else if(type.equals(new IntType())){
            symbolTable.insert(name, new IntValue(DEFAULT_INT_VALUE));
        }
        else if(type.equals(new BoolType())){
            symbolTable.insert(name, new BoolValue(DEFAULT_BOOL_VALUE));
        }
        else
        {
            throw new InvalidTypeException("Invalid type!");
        }
        return state;
    }
}