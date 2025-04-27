/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.util;

import java.util.ArrayList;

public class AutoGenerationList extends ArrayList {
	private Class clazz;

	public AutoGenerationList(Class clazz) {
		super();
		this.clazz = clazz;
	}

	public Object get(int index) {

		Object obj = null;
		try {
			obj = super.get(index);
		} catch (IndexOutOfBoundsException e) {

			try {
				// obj = clazz.newInstance();

				if (index >= size()) {
					for (int localInd = size(); localInd <= index; localInd++) {
						super.add(clazz.newInstance());
					}
				}
				obj = super.get(index);

				// super.add(index,obj);
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return obj;
	}

}
