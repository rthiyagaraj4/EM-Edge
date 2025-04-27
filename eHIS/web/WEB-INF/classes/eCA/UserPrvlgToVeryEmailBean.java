/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.io.*;
import java.util.*;

public class  UserPrvlgToVeryEmailBean implements java.io.Serializable
{
	
	ArrayList userList = new ArrayList();
	public UserPrvlgToVeryEmailBean()
	{
		userList = new ArrayList();
	}
	public void setUserList(String value)
	{
		userList.add(value);
	}

	public ArrayList getUserList()
	{
		return userList;
	}

	public void clearBean()
	{
		userList = new ArrayList();
	}
	public void removeUserList(String value)
	{
		if(userList.contains(value))
			userList.remove(value);
	}
	
}
