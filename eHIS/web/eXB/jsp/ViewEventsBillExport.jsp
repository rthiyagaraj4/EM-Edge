<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*,java.util.*,java.io.*,eXB.*,eXB.XBDBAdapter,webbeans.eCommon.ConnectionManager" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
 
<%
	Connection connection	= null;
	Statement statement		= null;
	ResultSet resultSet		= null;
	String eventtype		= "";
	String protocolLinkID	= "";
	ArrayList rec = null;
	try {										    
		int errFlag				   = 0;									      
		String exceptions	   = "";
		String func_mode	   = request.getParameter("func_mode");					 
		Hashtable hash		   = (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						   = (Hashtable)hash.get( "SEARCH" ) ;
		String sqlQry	       = "";  											  
		if(func_mode!= null && func_mode.equals("genExport")) {
		String whereClause   = java.net.URLDecoder.decode((String) hash.get("whereClause"));			   
	    eventtype					= (String) hash.get("eventtype");				  
		String msgIdsList		= (String) hash.get("msgIdsList");

		whereClause     =  java.net.URLDecoder.decode(whereClause);					   
		try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ViewEventsBillExport  :"+exp.toString());
			exp.printStackTrace(System.err);
		}		
		request.setAttribute("action_attr","R");	   
		XHElectronicBillsControllerBean xhBean=XHElectronicBillsControllerBean.getBean(XHElectronicBillsControllerBean.strBeanName,request,session);
        xhBean.action(request,connection);	    
	//	String strData[][]= xhBean.getDatabaseData();
		TreeMap tm=xhBean.treempselect;   
		  ArrayList b1=new ArrayList();     
		Set set = tm.entrySet(); 
		Iterator i = set.iterator(); 
		while(i.hasNext()) { 
					Map.Entry me = (Map.Entry)i.next(); 		    
							  b1.add(me.getValue());
			}   											    

					  String mesglist="";

					for(int K=0;K<b1.size();K++)
					{
							rec = (ArrayList)b1.get(K); 


						mesglist=mesglist+"'"+rec.get(3)+"'"+",";	 
					}

				   mesglist=mesglist+msgIdsList;
				   mesglist=mesglist.substring(0,(mesglist.length()));

        sqlQry = "UPDATE  XB_APPLICATION_MESSAGE  SET MESSAGE_STATUS = '' WHERE EVENT_TYPE = NVL('"+eventtype+"',EVENT_TYPE)  "+whereClause+" AND MESSAGE_ID IN ("+mesglist+")";

		
		try{		
		    statement = connection.createStatement();
			System.out.println("sqlQry: "+sqlQry);
			int updtCnt = statement.executeUpdate(sqlQry);   
			System.out.println("updtCnt: "+updtCnt);			
            connection.commit();												  
			out.println("getGatewayServer()");
		}
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ViewEventsBillExport  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
				System.out.println(" ViewEventsBillExport errFlag : "+errFlag);		
				/*	if(connection!=null){
					ConnectionManager.returnConnection(connection);
				}*/
		}
		}
		else if(func_mode!= null && func_mode.equals("genAccessionNum")) {     
					  
		String accession_number		=  (String) hash.get("accession_number");	   
		String OptionYN	= (String) hash.get("OptionYN");
		if(OptionYN.equals(""))														   
		{
			OptionYN="N";
		}
		  
	/*	try{
			if(connection==null) connection = ConnectionManager.getConnection();      
		}
		catch(Exception exp){
			System.out.println("Error in calling getconnection method of ViewEventsBillExport  :"+exp.toString());
			exp.printStackTrace(System.err);
		} */
		request.setAttribute("action_attr","R");
		XHElectronicBillsControllerBean xhBean=XHElectronicBillsControllerBean.getBean(XHElectronicBillsControllerBean.strBeanName,request,session);
		 xhBean.setSelectedRecords(connection,OptionYN,accession_number); 
       // xhBean.action(request,connection);	    
		         
		
																			   		    
		try{		
		    										  
			out.println("funLoad()");
		}																		   
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ViewEventsBillExport  :"+exp.toString());
			exp.printStackTrace(System.err);
			exceptions=exp.toString();        
		}
		finally{
				System.out.println(" ViewEventsBillExport errFlag : "+errFlag);			 
		}
		} // end of genAccessionNum
	}
	catch (Exception e) {
		e.printStackTrace() ;
	}
		finally{
			try{
			     if(resultSet!=null) resultSet.close();
				 if(statement!=null) statement.close();
			}catch(Exception es){
				es.printStackTrace() ;
			}
				if(connection!=null){
					ConnectionManager.returnConnection(connection);
				}
		}



%>
