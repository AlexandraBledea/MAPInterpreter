package model.ADT;

import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface DictionaryInterface<TKey, TValue>
{
    public int size();
    public boolean containsKey(TKey key);
    public boolean containsValue(TValue value);
    public boolean isEmpty();
    public void update(TKey key, TValue newValue);
    public void insert(TKey key, TValue newValue);
    public void clear();
    public TValue getValue(TKey key);
    public TValue remove(TKey key);
    public Collection<TValue> getAllValues();
    public Collection<TKey> getAllKeys();
    public Map<TKey, TValue> getAllPairs();

}
