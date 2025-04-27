/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class OrderedHashMap<K, V> extends HashMap<K, V> implements Map<K, V>, Serializable
{
    private static final long serialVersionUID = 1L;
    private ArrayList<K> list;

    public OrderedHashMap()
    {
        super();
        list = new ArrayList<K>();
    }

    public OrderedHashMap(int initialCapacity)
    {
        super(initialCapacity);
        list = new ArrayList<K>(initialCapacity);
    }

    public  V put(K key, V value)
    {
        if(!list.contains(key))
        {
            list.add(key);
        }
        return super.put(key, value);
    }

    public  List<K> getKeyList()
    {
        if(list.size() != 0)
        {
            return list;
        }
        return null;
    }

    public  boolean remove(K key)
    {
        if(list.contains(key))
        {
            list.remove(key);
            super.remove(key);
            return true;
        }
        return false;
    }

    public  V get(Object key)
    {
        if(!key.equals("") || key != null)
        {

            if(list.contains(key))
            {
                return super.get(list.get(list.indexOf(key)));
            }
        }
        return null;
    }

    public  boolean isEmpty()
    {
        return list.size() == 0;
    }

	public  void clear() 
	{
		Iterator<K> itr = list.iterator();

		while(itr.hasNext())
		{
			itr.next();
			itr.remove();
		}
		super.clear();
	}
}
