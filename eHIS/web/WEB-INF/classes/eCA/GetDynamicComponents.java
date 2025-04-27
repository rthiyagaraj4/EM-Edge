/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
26/2/2021	TFS15204		   Ramesh Goli		26/2/2021		Ramesh G			COMMN-ICN-0026
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import eCommon.Common.CommonAdapter;

public class GetDynamicComponents extends CommonAdapter{
	public Hashtable getDynamicCompDetails(StringBuffer XMLContent,HashMap paramHash)throws Exception 
	//public Hashtable getDynamicCompDetails(HashMap paramHash)throws Exception
    {
		Hashtable<String,String> ht = new Hashtable<String,String>();
		Hashtable<String,String> fHashMap = new Hashtable<String,String>();
		ArrayList<String> valueList = new ArrayList<String>();
		Connection connection 		= null;
		ResultSet rs 	= null;
	//	PreparedStatement pstmt 	= null;
		Statement stm		= null;
		try {
			StringReader strTemp = new StringReader(XMLContent.toString());
			InputSource isTemp = new InputSource(strTemp);
			
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(isTemp);			
			doc.getDocumentElement().normalize();
						
			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("ROW");  // Get the list of ROW Child nodes for Root_Element.	 
			for (int temp = 0; temp < nList.getLength(); temp++) {	 
			   Node nNode = nList.item(temp);
			   if (nNode.getNodeType() == Node.ELEMENT_NODE) {	 
			      Element eElement = (Element) nNode;
			      
			      NodeList cNode = eElement.getElementsByTagName("COL"); // Get the list of COL Child nodes for Root_Element>>[ROW]Child_Node.
			      for(int ctemp=0; ctemp < cNode.getLength(); ctemp++){
			    	  Element cElement = (Element) cNode.item(ctemp);
			    	  
			    	  NodeList ccNode = cElement.getElementsByTagName("*"); // Get the list of Child nodes for Root_Element>>[ROW]Child_Node>>[COL]Child_Node
			    	  for(int ftemp=0; ftemp < ccNode.getLength(); ftemp++){
			    		  Element fElement = (Element) ccNode.item(ftemp);
						  if(""!=fElement.getAttribute("DISCRID")){
			    		  valueList.add(fElement.getAttribute("DISCRID"));
						  }
			    	  }
			      }			      
			   }
			}			
			if(valueList.size()>0){
				// Query Generation
				StringBuilder sb=new StringBuilder();
				sb.append("SELECT FIELD_MNEMONIC,FIELD_MNEMONIC_QUERY FROM CA_MNEMONIC WHERE GENERIC_COMP_YN='Y' AND FIELD_MNEMONIC IN(");
				for(int i=0;i<valueList.size();i++){
					if(i!=((valueList.size())-1))
						sb.append("'"+valueList.get(i)+"',");
					else
						sb.append("'"+valueList.get(i)+"'");
					//TFS15204 Start.	
					if(i==999 || i==1998|| i==2997 || i==3996 || i==4995){
						sb.append(" ) OR FIELD_MNEMONIC IN( ");
					}
					//TFS15204 End.
				}
				sb.append(")");
				/*
				StringBuffer sb=new StringBuffer();
				sb.append("SELECT FIELD_MNEMONIC,FIELD_MNEMONIC_QUERY FROM CA_MNEMONIC WHERE FIELD_TYPE='N'");
				*/
				connection	= getConnection();
				stm = connection.createStatement();
				rs = stm.executeQuery(sb.toString());
				
				while(rs!=null && rs.next())
				{
					//System.out.println(((String)rs.getString("FIELD_MNEMONIC"))+"==========>"+((String)rs.getString("FIELD_MNEMONIC_QUERY")));
					ht.put(((String)rs.getString("FIELD_MNEMONIC")), ((String)rs.getString("FIELD_MNEMONIC_QUERY")));					
				}
				if(rs!=null) rs.close();
				if(stm!=null)stm.close();
				if(ht.size()>0){
					Set set = ht.entrySet();
					Iterator i = set.iterator(); 

					while(i.hasNext()){
						Map.Entry me = (Map.Entry)i.next();
						//if(rs!=null)
						//	rs = null;
						String keyV=(String)me.getKey();
						String query= (String)me.getValue();
						if(paramHash.size()>0){
							Set setH = paramHash.entrySet();
							Iterator iH = setH.iterator();
							while(iH.hasNext()){
								Map.Entry meH = (Map.Entry)iH.next();
								query =query.replace(((String)meH.getKey()),"'"+((String)meH.getValue())+"'");
							}
							//System.out.println("GetDynamicComponents.java----114----query--->"+query);
							try{
								stm = connection.createStatement();
								rs = stm.executeQuery(query); 
								if(rs.next()){
									//System.out.println("		----->"+(String)rs.getString(1)+"<------");
									fHashMap.put(keyV,((String)rs.getString(1)));
								}
								if(rs!=null) rs.close();
								if(stm!=null)stm.close();
							}catch(Exception ex){							
								System.out.println("Error : "+ex.getMessage());
							}
							
						}
						
					}
				}		
				
			}
			
		  } catch (Exception e) {
			e.printStackTrace();
		  }finally{	
			closeResultSet(rs);
			closeStatement(stm);	  
			closeConnection(connection);			 
		  }
		return fHashMap;
    }
}
