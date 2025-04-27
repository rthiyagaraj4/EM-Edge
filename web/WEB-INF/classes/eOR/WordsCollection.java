/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eOR;
import java.util.*;
 public class WordsCollection
	{
	  List<Word> list1=new ArrayList<Word>();
		private int mycount;
	  public WordsCollection()
		{
		}

		public WordsCollection(ArrayList<Word> list)
		{
			for (Object item : list)
			{
				if (item instanceof Word)
				{
					list1.add((Word)item);
				}
			}
		}

		public final boolean add(Word item)
		{
			mycount++;
			return list1.add(item);
		}

		public final void insert(int index, Word item)
		{
			list1.set(index, item);
		}

		public final void remove(Word item)
		{
			list1.remove(item);
		}

		public final int getCount()
		{
			return list1.size();
		}
		public final boolean contains(Word item)
		{
			return list1.contains(item);
		}

		public final int IndexOf(Word item)
		{
			return list1.indexOf(item);
		}

		public final Word getItem(int index)
		{
			return (Word) list1.get(index);
		}
		public final void setItem(int index, Word value)
		{
			list1.set(index,value);
			
			
		}

		public final void CopyTo(WordsCollection col, int index)
		{
			for (int i=index; i < list1.size(); i++)
			{
				col.add(this.getItem(i));
			}
		}

		public final void CopyTo(WordsCollection col)
		{
			this.CopyTo(col, 0);
		}
	}
