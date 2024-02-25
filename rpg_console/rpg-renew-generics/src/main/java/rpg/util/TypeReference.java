package rpg.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T>{
    private Type type;

    public TypeReference() {
        this.type = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }

}
