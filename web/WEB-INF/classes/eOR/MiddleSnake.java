/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;
public class MiddleSnake
	{
		public MiddleSnake()
		{
			Source = new mySequence1();
			Destination = new mySequence1();
		}
		public mySequence1 Source;
		public mySequence1 Destination;

		public int SES_Length;
	}
