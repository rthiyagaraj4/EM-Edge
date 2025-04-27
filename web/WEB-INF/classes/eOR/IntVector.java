/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eOR;
 public class IntVector
	{
		private int [] data;
		private int N;

		public IntVector(int N)
		{
			data = new int [2*N];
			this.N = N;
		}

		public final int getItem(int index)
		{
			return data[N + index];
		}
		public final void setItem(int index, int value)
		{
			data[N + index] = value;
		}
	}
