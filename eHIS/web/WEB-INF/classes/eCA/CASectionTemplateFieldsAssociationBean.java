/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
Flow of storing the data
========================
	Hashtable---------------------->
			(itemcode)---->HashMap----------->
											1. (compid+srlno)---->Object---->1.String  (in  case of other 										 then List box)  
																			2.HashMap (in case of List 			    Box)
																					--------->Item-Value	
																					(Itemcode)

											2. (compid+srlno+_STATUS)-------> String (used in case of 	 List Items (intoduced later	for knowing the status E/D in case of list ,done on 3/20/2004 and will effect setStaus() and constructXML Functions and new function introduced getStatusEDWhenList())
											Note: used only in case of list and available directly in case of other components

XML Flow
========
<POST-ITEM-ACTIONS TYPE="L/C">
	<ACTION CODE="compItemId">
		<COMPONENT NAME="" TYPE="" STATUS="" />
		<COMPONENT NAME="" TYPE="L" DEFAULT-CODE="">
			<LIST-DATA CODE="" VALUE=""/>
			<LIST-DATA CODE="" VALUE=""/>
			......
			......
		</COMPONENT>
		<COMPONENT NAME="" TYPE="" STATUS="" />
		.....
		.....
	</ACTION>

	<ACTION CODE="">
		....
		....
	</ACTION>
	....
	....

</POST-ITEM-ACTIONS>
*/							
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
--------------------------------------------------------------------------------------------------------------------------------
?				?				?				Created
11/04/2017     	INC61905       	DineshT        	The Scoring functionality In Notes should work in the similar manner as in Charts 												i.e on selection of individual variable, the score gets automatically calculated
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date   		Rev.By		Description
--------------------------------------------------------------------------------------------------------------------------------
14/08/2017		IN064910		Raja S			14/08/2017		Ramesh G	The sequence not listed accordingly as per 																						configuration in Discrete Measure function.
--------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.sql.*;
import java.util.*;
import java.io.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
public class CASectionTemplateFieldsAssociationBean extends DefaultHandler implements java.io.Serializable 
{
	private Hashtable hash = null;
	private Hashtable associationTable = null;
	
	public CASectionTemplateFieldsAssociationBean()
	{
		hash = new Hashtable();
		associationTable = new Hashtable();
	}
	public void setStatusEDWhenList(String currentCompIdSrlNo,String compItemId,Object status)
	{
		//updating the hash which is used finally to construct XML
		//here status can be Hashtable(for List Items) and String(other components)
		//if its a list item we r storing the Status E/D in _STATUS
		currentCompIdSrlNo = currentCompIdSrlNo;
		HashMap currentCompDetails = null;
		if(hash.get(compItemId)!=null)
			currentCompDetails = (HashMap)hash.get(compItemId);
		else
			currentCompDetails = new HashMap();
		currentCompDetails.put(currentCompIdSrlNo+"_STATUS",status);
		hash.put(compItemId,currentCompDetails);
	}
	public String getStatusEDWhenList(String currentCompIdSrlNo, String compItemId)
	{
		HashMap currentCompDetails = null;
		currentCompIdSrlNo = currentCompIdSrlNo;
		if(hash.get(compItemId)!=null)
			currentCompDetails = (HashMap)hash.get(compItemId);
		else
			return null;
		return (String)currentCompDetails.get(currentCompIdSrlNo+"_STATUS");

	}
	public Object getStatus(String currentCompIdSrlNo, String compItemId)
	{
		HashMap currentCompDetails = null;
		currentCompIdSrlNo = currentCompIdSrlNo;
		if(hash.get(compItemId)!=null)
			currentCompDetails = (HashMap)hash.get(compItemId);
		else
			return null;
		return currentCompDetails.get(currentCompIdSrlNo);
	}
	
	
	//currentCompIdSrlNo is the unique identification for the individual component which u r attaching to the main component this is compid+srlno
	//compItemId is the unique identification for the main comp to which u r attaching other components it can be Y/N or code of the ListItems
	/*compIdSrlNo is used in the Hashtable assciationTable to maintain the information abt what components r linked with which component in this whole section template,
	to find out the validations and restriction based on the intercomponent linking*/

	public void setStatus(String currentCompIdSrlNo,String compItemId,Object status)
	{
		//updating the hash which is used finally to construct XML
		//here status can be Hashtable(for List Items) and String(other components)
		//if its a list item we r storing the Status E/D in _STATUS
		HashMap currentCompDetails = null;
		if(hash.get(compItemId)!=null)
			currentCompDetails = (HashMap)hash.get(compItemId);
		else
			currentCompDetails = new HashMap();
		currentCompDetails.put(currentCompIdSrlNo,status);		
		hash.put(compItemId,currentCompDetails);
		currentCompIdSrlNo = currentCompIdSrlNo;
	}
	
	public void removeStatus(String currentCompIdSrlNo,String compItemId)
	{
		//-------------------------------------
		HashMap currentCompDetails = null;
		currentCompIdSrlNo = currentCompIdSrlNo;
		if(hash.get(compItemId)!=null)
		{
			currentCompDetails = (HashMap)hash.get(compItemId);
			currentCompDetails.remove(currentCompIdSrlNo);
			currentCompDetails.remove(currentCompIdSrlNo+"_STATUS");
			hash.put(compItemId,currentCompDetails);
		}

		//if(currentCompDetails != null) currentCompDetails.clear();
	}
	public Vector getAssociatedComponents(String compIdSrlNo)
	{
		compIdSrlNo = compIdSrlNo;
		return (Vector)associationTable.get(compIdSrlNo);
	}
	public void setAssociatedComponents(String compIdSrlNo,Vector dependentComponent)
	{
		associationTable.put(compIdSrlNo,dependentComponent);
	}

	public String constructXML(String type,String compIdSrlNo)
	{
		Vector dependentComp = getAssociatedComponents(compIdSrlNo);
		
		String l_comp_type_linked = "";//INC61905		
		
		if(dependentComp!=null && !dependentComp.isEmpty())
		{
			if(hash!=null && !hash.isEmpty())
			{
				
				StringBuffer strBuffer = new StringBuffer("<POST-ITEM-ACTIONS TYPE=\""+type+"\">");
				Enumeration enumHashTable = hash.keys();
				//Enumeration enumHashMap = null,enumItemHashMap = null;
				Enumeration enumItemHashMap = null;
				String compItemId = "";
				String currentCompIdSrlNo = "";
				String listItemId = "",listItemText="",itemSelected="";
				Hashtable  itemDetailsHashtable = null;//compDetailsHashtable = null
				HashMap compDetailsHashMap = null;
				Object status = null;
				String statusED = null;
				try{
					while(enumHashTable.hasMoreElements())
					{
						compItemId = (String)enumHashTable.nextElement();
						strBuffer.append("<ACTION CODE = \""+compItemId+"\" >");
						//compDetailsHashtable = new Hashtable((HashMap)hash.get(compItemId));
						//enumHashMap = compDetailsHashtable.keys();
						compDetailsHashMap = (HashMap)hash.get(compItemId);						
						//while(enumHashMap.hasMoreElements())
						//taking the dependecy vector and using the components present in the vector to form the XML
						
						for(int k=0;k<dependentComp.size();k++)
						{
							//currentCompIdSrlNo = (String)enumHashMap.nextElement();
							//status = compDetailsHashtable.get(currentCompIdSrlNo);
							currentCompIdSrlNo = (String)dependentComp.elementAt(k);
							status = compDetailsHashMap.get(currentCompIdSrlNo);
							
							statusED = (String)compDetailsHashMap.get(currentCompIdSrlNo+"_STATUS");
							l_comp_type_linked =(String) compDetailsHashMap.get(currentCompIdSrlNo+"_COMP_TYPE_LINKED")==null?"":(String)compDetailsHashMap.get(currentCompIdSrlNo+"_COMP_TYPE_LINKED");//INC61905
							if(status!=null)
							{
								if(status instanceof String)
								{
									statusED = (String)status;
									//strBuffer.append("<COMPONENT NAME=\"C_"+currentCompIdSrlNo+"\" TYPE=\"\" STATUS=\""+statusED+"\" />");//INC61905
									strBuffer.append("<COMPONENT NAME=\"C_"+currentCompIdSrlNo+"\" TYPE=\"\" STATUS=\""+statusED+"\" COMP_TYPE_LINKED = \""+l_comp_type_linked+"\"/>");//INC61905
								}
								else if(status instanceof HashMap)
								{
									
									itemDetailsHashtable = new Hashtable((HashMap)status);
									//IN064910 starts
									HashMap itemValuesHashMap = null;
									itemValuesHashMap =(HashMap)status;
									//IN064910 Ends
									itemSelected = (String)itemDetailsHashtable.get("DEFAULT_CODE");
									//strBuffer.append("<COMPONENT NAME=\"C_"+currentCompIdSrlNo+"\" TYPE=\"L\" DEFAULT-CODE=\""+itemSelected+"\" STATUS=\""+statusED+"\" >");//INC61905
									strBuffer.append("<COMPONENT NAME=\"C_"+currentCompIdSrlNo+"\" TYPE=\"L\" DEFAULT-CODE=\""+itemSelected+"\" STATUS=\""+statusED+"\" COMP_TYPE_LINKED = \""+l_comp_type_linked+"\" >");//INC61905
									//IN064910 starts
									//Vector itemDetailsKeySet = new Vector(itemDetailsHashtable.keySet()); //commented for IN064910
									Vector itemDetailsKeySet = new Vector(itemValuesHashMap.keySet()); //Modified for IN064910
									//Collections.sort(itemDetailsKeySet);//Commented for IN064910
									//IN064910 Ends
									//enumItemHashMap = itemDetailsHashtable.keys();
									enumItemHashMap = itemDetailsKeySet.elements();
									while(enumItemHashMap.hasMoreElements())
									{
										listItemId = (String)enumItemHashMap.nextElement();
										
										if(!listItemId.equals("DEFAULT_CODE"))
										{
											listItemText =replaceSpecialChars((String)itemDetailsHashtable.get(listItemId));
											strBuffer.append("<LIST-DATA CODE=\""+listItemId+"\" VALUE=\""+listItemText+"\" />");
										}								
									}
									strBuffer.append("</COMPONENT>");
								}								
							}
							else if(statusED!=null)
							{
								if(!statusED.equals(""))
								{
									//strBuffer.append("<COMPONENT NAME=\"C_"+currentCompIdSrlNo+"\" TYPE=\"L\" STATUS=\""+statusED+"\" />");//INC61905
									strBuffer.append("<COMPONENT NAME=\"C_"+currentCompIdSrlNo+"\" TYPE=\"L\" STATUS=\""+statusED+"\" COMP_TYPE_LINKED = \""+l_comp_type_linked+"\"/>");//INC61905
								}
							}
						}
						strBuffer.append("</ACTION>");
					}
				}catch(Exception e)
				{
					e.printStackTrace();
					return e.toString();
					
				}
			
				strBuffer.append("</POST-ITEM-ACTIONS>");
				//garbage collection
				enumHashTable = null;
				//enumHashMap = null;
				enumItemHashMap = null;
				compItemId = null;
				currentCompIdSrlNo = null;
				listItemId = null;listItemText=null;itemSelected=null;
				compDetailsHashMap = null; itemDetailsHashtable = null;
				status = null;statusED = null;


				return strBuffer.toString();
			}
		}
		return "";
	}
	//************************************************************************************
	//parsing the XML generated and storing the values in the key value pairs in hashtable 
	public void parseXmlLoadHashtable(String XMLString)
	{
		try
		{
			SAXParser parser = (SAXParserFactory.newInstance()).newSAXParser();
			//parser.parse(new InputSource(new ByteArrayInputStream(XMLString.getBytes())));
                        parser.parse(new InputSource(new ByteArrayInputStream(XMLString.getBytes())), this);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	//calback Methods
	public void startElement(String uri, String localName, String rawName, Attributes attributes)
	{		
		uri = uri;
		localName = localName;
		if(rawName.equals("ACTION"))
		{
			if(attributes!=null)
			{
				compItemId = attributes.getValue("CODE");
			}
		}
		if(rawName.equals("COMPONENT"))
		{
			if(attributes!=null)
			{
				currentCompIdSrlNo = attributes.getValue("NAME");
				currentCompIdSrlNo = currentCompIdSrlNo.substring(2);
				if(attributes.getValue("TYPE").equals("L"))
				{
					
					String defaultCode = attributes.getValue("DEFAULT-CODE");
					if(defaultCode!=null) //in case when the list item is just disabled and no restriction is put on the items so status will not be there ( only StatusED will be there)
					{
						listItemsHashMap = new HashMap();
						listItemsHashMap.put("DEFAULT_CODE",defaultCode);
					}
					
					String statusTF = attributes.getValue("STATUS");
					setStatusEDWhenList(currentCompIdSrlNo,compItemId,statusTF);
				}
				else if(attributes.getValue("TYPE").equals(""))
				{
					String statusTF = attributes.getValue("STATUS");
					setStatus(currentCompIdSrlNo,compItemId,statusTF);
				}
			}
		}
		if(rawName.equals("LIST-DATA"))
		{
			if(attributes!=null)
			{
				String itemCode = attributes.getValue("CODE");
				String itemValue = attributes.getValue("VALUE");
				listItemsHashMap.put(itemCode,itemValue);
			}

		}
	}
	public void endElement(String uri, String localName, String rawName)
	{
		uri = uri;
		localName= localName;
		if(rawName.equals("COMPONENT"))
		{
			if(listItemsHashMap!=null)
			{
				setStatus(currentCompIdSrlNo,compItemId,listItemsHashMap);
				listItemsHashMap = null;
			}
		}
	}
	//*************************************************************************************
	//return values
	//0 = Not Dependent
	//-1 = Is parent of some component
	//-2 = Is already a child of some component
	public int isDependent(String currentCompIdSrlNo)
	{
		if(associationTable!=null && !associationTable.isEmpty())
		{
			Enumeration parentCompIdsEnum = associationTable.keys();
			String parentCompId = "";
			Vector childCompVector = null;
			while(parentCompIdsEnum.hasMoreElements())
			{
				parentCompId = (String)parentCompIdsEnum.nextElement();
				if(parentCompId.equals(currentCompIdSrlNo))//its a parent
					return -1;
				childCompVector = (Vector)associationTable.get(parentCompId);
				if(childCompVector.contains(currentCompIdSrlNo))//its a child
					return -2;
			}
		}
		return 0;
	}
	public boolean clearBean()
	{
		if(hash!=null)
		{
			hash.clear();
			associationTable.clear();
			return true;
		}
		else
			return false;
	}
	public Hashtable getHashData()
	{
		return hash;
	}
	public Hashtable getAssociationData()
	{
		return associationTable;
	}
	 private static String replaceSpecialChars(String input)
    {

		if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
		if (input.indexOf("<") != -1) input = input.replaceAll("<","&lt;");
		if (input.indexOf(">") != -1) input = input.replaceAll(">","&gt;");	

      /*
		StringBuffer temp=null;
        int a=0,b=0,c=0,i=0;
        while(true)
        {
            a=input.indexOf('&',i)==-1?999999:input.indexOf('&',i);
            b=input.indexOf('<',i)==-1?999999:input.indexOf('<',i);
            c=input.indexOf('>',i)==-1?999999:input.indexOf('>',i);
            if(a<b && a<c && a!=-1)
            {
                temp=new StringBuffer(input);
                temp.replace(a,a+1,"&amp;");
                input=temp.toString();
                i=a+5;
            }
            else if(b<a && b<c && b!=-1)
            {
                temp=new StringBuffer(input);
                temp.replace(b,b+1,"&lt;");
                input=temp.toString();
                i=b+4;
            }
            else if(c<a && c<b && c!=-1)
            {
                temp=new StringBuffer(input);
                temp.replace(c,c+1,"&gt;");
                input=temp.toString();
                i=c+4;
            }
            else if(a==b && b==c)
            {
                break;
            }
            else
            {
                break;
            }

        }
		*/

        return input;
    }
	String compItemId = "";
	String currentCompIdSrlNo = "";
	HashMap listItemsHashMap = null;

	//INC61905, starts
	public void setCurrentCompTypeLinked(String currentCompIdSrlNo,String compItemId,Object status)
	{
		currentCompIdSrlNo = currentCompIdSrlNo;
		HashMap currentCompDetails = null;
		if(hash.get(compItemId)!=null)
			currentCompDetails = (HashMap)hash.get(compItemId);
		else
			currentCompDetails = new HashMap();
		currentCompDetails.put(currentCompIdSrlNo+"_COMP_TYPE_LINKED",status);
		hash.put(compItemId,currentCompDetails);
	}
	//INC61905, ends
}
