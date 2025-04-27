/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.io.Serializable;

public class CommonCollectionUtils<K, V> implements Cloneable, Serializable
{
    //private static final long serialVersionUID = 8745522110258996351L;

    /**
     * The ArrayList into which all keys of the  are stored.
     */
    private ArrayList<K> keyList;

    /**
     * The ArrayList into which all values of the  are stored.
     */
    private ArrayList<V> valueList;

    /**
     * The ArrayList into which all key occurance of the given key of
     * the  are stored.
     */
    private ArrayList<Integer> keyOccur;

    /**
     * Constructs an empty  with an initial capacity of ArrayList.
     */
    public CommonCollectionUtils()
    {
        keyList = new ArrayList<K>();
        valueList = new ArrayList<V>();
        keyOccur = new ArrayList<Integer>();
    }

    /**
     * Constructs an empty  with the specified initial capacity.
     *
     * @param   initialCapacity   the initial capacity of the ArrayList
     * @exception IllegalArgumentException if the specified initial capacity
     *            is negative
     */
    public CommonCollectionUtils(int initialCapacity)
    {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                initialCapacity);
        keyList = new ArrayList<K>(initialCapacity);
        valueList = new ArrayList<V>(initialCapacity);
        keyOccur = new ArrayList<Integer>();
    }

    /**
     * Appends the specified element and value to the end of this .
     *
     * @param element element to be stored
     * @param value element  to be stored
     * @throws NullPointerException
     */
    public void add(K key, V value)
    {
        if(key != null)
        {
            keyList.add(key);
            valueList.add(value);
        }
        else
          throw new NullPointerException(" key can not be null.");
    }

    /**
     * Inserts the specified element at the specified position in this .
     * Shifts the element currently at that position (if any) and
     * any subsequent elements to the right.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @param value element to be stored at the specified position
     * @throws NullPointerException, IndexOutOfBoundsException
     */
    public void add(int index, K key, V value)
    {
		if (index > keyList.size() || index < 0)
               throw new IndexOutOfBoundsException("Index: "+index
            +", Size: "+keyList.size());

        if(key != null)
        {
            keyList.add(index, key);
            valueList.add(index, value);
        }
        else
          throw new NullPointerException(" key or value can not be null.");
    }

   /**
    * Returns the array of values to which the specified key is mapped,
    * in the insert order or {@code null} if this map contains no mapping for the key.
    *
    * <p>A return value of {@code null} does not <i>necessarily</i>
    * indicate that the map contains no mapping for the key;
    */
    public V[] getByKey(K key)
    {
        getKeyOccurrences(key);

        if(keyOccur.size() > 0)
        {
            V[] elements = (V[]) java.lang.reflect.Array.newInstance(valueList
                .get(0).getClass(), keyOccur.size());

            for(int i = 0; i < keyOccur.size(); i++)
            {
                elements[i] = (V) valueList.get(keyOccur.get(i));
            }
            keyOccur.clear();
            return elements;
        }
        return null;
    }

   /**
    * Returns the first occurance value to which the specified key is mapped,
    * or {@code null} if this map contains no mapping for the key.
    */
    public V get(K key)
    {
        if(key != null)
        for(int i =0; i < keyList.size();i++)
        {
            K value = keyList.get(i);
            if(value == key || value.equals(key))
            {
                return valueList.get(i);
            }
        }
        return null;
    }

    /**
     * Removes all of the elements from this .  The list will
     * be empty after this call returns.
     */
    public void clear()
    {
        keyList.clear();
        valueList.clear();
    }

   /**
    * Returns a {@link List} view of the keys contained in this map.
    * The list is backed by the map, so changes to the map are
    * reflected in the list, and vice-versa.  If the map is modified
    * while an iteration over the list is in progress (except through
    * the iterator's own <tt>remove</tt> operation), the results of
    * the iteration are undefined.
    */
    public List<K> keyList()
    {
        return this.keyList;
    }

    /**
     * Returns the number of elements in this .
     *
     * @return the number of elements in this
     */
    public int size()
    {
        return this.keyList.size();
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty()
    {
        return this.keyList.isEmpty();
    }

    /**
     * Returns <tt>true</tt> if this  contains the specified element.
     *
     * @param key element whose presence in this  is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    public boolean containsKey(K key)
    {
        return keyList.contains(key);
    }

    /**
     * Returns <tt>true</tt> if this  contains the specified element.
     *
     * @param value element whose presence in this  is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    public boolean containsValue(V value)
    {
        return valueList.contains(value);
    }

    /**
     * Removes the all occurrence of the specified element from this ,
     * if it is present and  Shifts any subsequent elements to the left.
     * If the  does not contain the element, it is unchanged.
     *
     * @param key the index of the element to be removed
     */
    public void removeKey(K key)
    {
        getKeyOccurrences(key);
        if(keyOccur.size() > 0)
        for(int i = keyOccur.size()-1; i >= 0; i--)
        {
            int r = keyOccur.get(i);
            valueList.remove(r);
            keyList.remove(r);
        }
        keyOccur.clear();
    }

    /**
     * Gets the all occurrence of the specified element from this .
     */
    private void getKeyOccurrences(K key)
    {
        for(int i = 0; i < keyList.size(); i++)
        {
            K element = keyList.get(i);
            if(element.equals(key) || element == key)
            {
                keyOccur.add(i);
            }
        }
    }

    /**
     * Returns the element at the specified position in this .
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this
     * @throws IndexOutOfBoundsException
     */
    public V get(int keyIndex)
    {
        if (keyIndex >= keyList.size() || keyIndex < 0)
            throw new IndexOutOfBoundsException("Index: "+keyIndex
            +", Size: "+keyList.size());
        return (V) valueList.get(keyIndex);
    }

    /**
     * Removes the element at the specified position in this .
     * Shifts any subsequent elements to the left.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException
     */
    public void removeKeyAtIndex(int keyIndex)
    {
        if (keyIndex >= keyList.size() || keyIndex < 0)
            throw new IndexOutOfBoundsException("Index: "+keyIndex
            +", Size: "+keyList.size());
        valueList.remove(keyIndex);
        keyList.remove(keyIndex);
    }

    /**
     * Returns a Deep copy of this <tt></tt> instance.
     *
     * @return a clone of this <tt></tt> instance
     */
    public Object clone()
    {
        try
        {
            CommonCollectionUtils<K, V> v = (CommonCollectionUtils<K, V>) super.clone();
            v.keyList = (ArrayList<K>) this.keyList.clone();
            v.valueList = (ArrayList<V>) this.valueList.clone();
            v.keyOccur =  (ArrayList<Integer>) this.keyOccur.clone();
            return v;
        }
        catch (CloneNotSupportedException e)
        {
            // this shouldn't happen, since we are Cloneable.
            throw new InternalError();
        }
    }

    /**
     * Returns a string which contains all the key and values as pair of the
     * .
     *
     * @return a string conating all keys and values as pair
     */
    public final String toString()
    {
        if(keyList.size() > 0)
		{
			StringBuffer sb = new StringBuffer();
			sb.append("{");
			for(int i = 0; i < keyList.size(); i++)
			{
				if(i == (keyList.size() - 1))
					sb.append(keyList.get(i)+" = "+valueList.get(i));
				else
					sb.append(keyList.get(i)+" = "+valueList.get(i)+", ");
			}
			sb.append("}");
			return sb.toString();
		}
		return "";
    }

   /**
    * Returns a {@link Collection} view of the values contained in this map.
    *
    * @return Collection of mapped values of this <tt></tt>.
    */
    public Collection<V> values()
    {
        return valueList;
    }

	/**
     * Replace the specified element and value to the CommonCollectionUtils.
     *
     * @param key element to be stored
     * @param value element  to be stored
     */
    public void replaceValue(K key, V value)
    {
    	if(key != null)
            for(int i =0; i < keyList.size();i++)
            {
                K val = keyList.get(i);
                if(val == key || val.equals(key))
                {
                	 valueList.remove(i);
                     valueList.add(i, value);
                }
            }
    }
}
