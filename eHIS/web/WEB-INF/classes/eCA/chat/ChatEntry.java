/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
 * Created on Jun 21, 2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

/**
 * @author ankursetia
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package eCA.chat;
import java.io.*;
public class ChatEntry implements Serializable
{
	private String senderName;
	private String message;
	public ChatEntry(String senderName,String message)
	{
		this.senderName = senderName;
		this.message = message;
	}
	public String getSenderName()
	{
		return senderName;
	}
	public String getMessage()
	{
		return message;
	}
}
