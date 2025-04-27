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
import java.util.*;
import java.io.*;
public class ChatMessages implements Serializable
{

	ArrayList list = null;
	public ChatMessages()
	{
		list = new ArrayList();
	}
	public void addChatEntry(ChatEntry cEntry)
	{
		list.add(cEntry);
	}
	public ArrayList getAllChatEntries()
	{
		return list;
	}
	public ChatEntry getChatEntry(int index)
	{
		return (ChatEntry)list.get(index);
	}
	public int getSize()
	{
		return list.size();
	}
	//clear all chat Entries present for that ChatMessages
	public void clearChatEntries(){
		ChatEntry cEntry = null;
		if(list!=null){
			for(int i=0;i<list.size();i++){
				cEntry = (ChatEntry)list.get(i);
				cEntry = cEntry;
				cEntry = null;
			}
		}
		list.clear();
	}
}
