package model.type;

public class IntType implements TypeInterface {

    @Override
    public boolean equals(Object another){ return (another instanceof IntType);}

    @Override
    public String toString(){
        return "int";
    }

}