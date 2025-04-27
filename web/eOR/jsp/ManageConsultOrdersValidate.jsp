<%/*
-----------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN063669		Raja S			10/3/2017	    Ramesh G		GHL-SCF-1165  
-----------------------------------------------------------------------------------------------------------------------------------------------------
*/%>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*, webbeans.eCommon.MessageManager" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try 
	{
		request.setCharacterEncoding("UTF-8");		
		Properties	p	=	(java.util.Properties) session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		String facility_id = (String)session.getValue("facility_id");
		String user_id 	=	(String) session.getValue("login_user");
		String client_ip_address = p.getProperty("client_ip_address")==null?"":(String)p.getProperty("client_ip_address");
		ManageConsultOrders ManageConsOrders = (ManageConsultOrders)getObjectFromBean("Or_ManageConsOrders","eOR.ManageConsultOrders",session);	
		ManageConsOrders.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
		String callFrom =(String) hash.get("CallFrom");
		String  returnVal  = "";
		if((callFrom.equals("SAVE_CONSULT_GRP"))||(callFrom.equals("UPDATE_CONSULT_GRP")))
		{	
			Boolean flag = true;
			String errorMsg = "";
			String called_from = (String)hash.get("CALLED_FROM");	
			String encounter_id = (String)hash.get("ENCOUNTER_ID");				//"home_required_yn=Y&menu_id=MED_DFLT&module_id=OR&function_id=MAN_CONS_ORDER&function_name=Manage Consult Order&function_type=F&access=YYYNN&desktopFlag=N";
			String queryString ="called_from="+called_from+"&encounter_id="+encounter_id;
			hash.put("ADDED_BY_ID",user_id);
			hash.put("ADDED_AT_WS_NO",client_ip_address);
			hash.put("ADDED_FACILITY_ID",facility_id);		

			String mode = (String)hash.get("MODE");	
			String row_ids	= (String)hash.get("ROW_IDS");
			String speciality_codes	= (String)hash.get("SPECIALITY_CODES");
			String practitioner_ids	= (String)hash.get("PRACTITIONER_IDS");
			String locns	= (String)hash.get("LOCNS");
			String consult_dates	= (String)hash.get("CONSULT_DATES");
			String fm_val	= (String)hash.get("FROM");
			String to_val	= (String)hash.get("TO");
			int fm_value = Integer.parseInt(fm_val);
			int to_value = Integer.parseInt(to_val);


			StringTokenizer rowidStoken = new StringTokenizer(row_ids,"~");
			StringTokenizer specialityCodes = new StringTokenizer(speciality_codes,"~");
			StringTokenizer practitionerIds = new StringTokenizer(practitioner_ids,"~");
			StringTokenizer locnStoken = new StringTokenizer(locns,"~");
			StringTokenizer consultDates = new StringTokenizer(consult_dates,"~");

			Hashtable tabdata = new Hashtable();
			//HashMap dataMap = new HashMap();
			String row_id = "";
			String speciality = "";
			String practitionerId = "";
			String locn = "";
			String consultDate = "";
			

			for(int j=fm_value; j<to_value; j++)
			{
				int change = 0;
				if(rowidStoken.hasMoreTokens()) 
				{
					row_id			=	 (rowidStoken.nextToken()).trim();
					if(row_id.equals("@#"))
						row_id		=	 "";
				}
				else 
				{
					row_id			=	 "";
				}

				if(specialityCodes.hasMoreTokens()) 
				{
					speciality			=	 (specialityCodes.nextToken()).trim();
					if(speciality.equals("@#"))
						speciality		=	 "";
				}
				else 
				{
					speciality			=	 "";
				}

				if(practitionerIds.hasMoreTokens()) 
				{
					practitionerId			=	 (practitionerIds.nextToken()).trim();
					if(practitionerId.equals("@#"))
						practitionerId		=	 "";
				}
				else 
				{
					practitionerId			=	 "";
				}

				if(locnStoken.hasMoreTokens()) 
				{
					locn			=	 (locnStoken.nextToken()).trim();
					if(locn.equals("@#"))
						locn		=	 "";
				}
				else 
				{
					locn			=	 "";
				}

				if(consultDates.hasMoreTokens()) 
				{
					consultDate			=	 (consultDates.nextToken()).trim();
					if(consultDate.equals("@#"))
						consultDate		=	 "";
				}
				else 
				{
					consultDate			=	 "";
				}
				String[] record = (String[])ManageConsOrders.getDataMapValues(row_id);
				
				if(!consultDate.equals((String)record[12]))
				{
					record[12] = consultDate;
					++change;
				}
				if(!locn.equals((String)record[10]))
				{
					record[10] = locn;
					++change;
				}
				if(!practitionerId.equals((String)record[8]))
				{
					record[8] = practitionerId;
					++change;
				}
				if(!speciality.equals((String)record[6]))
				{
					record[6] = speciality;
					++change;
				}
				if(change>0)
				{
					record[18] = "C";
					ManageConsOrders.setDataMap(row_id,record);
				}
			}
			
			if((callFrom.equals("SAVE_CONSULT_GRP")))
			{
				returnVal = (String)ManageConsOrders.insert(hash);	
		
				if(returnVal.equals("TRANS_SUCCESS"))
				{
					//IN063669 Changes Starts
					//out.println("parent.ManageConsultOrderdtl.location.href='../../eOR/jsp/ManageConsultOrdersDetail.jsp?"+queryString +"'");//Commented for IN063669
					//out.println("parent.ManageConsultOrderbtn.location.href='../../eOR/jsp/ManageConsultOrdersButton.jsp?"+queryString +"'");//Commented for IN063669  
					//IN063669 Changes Ends
					tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					errorMsg = (String) tabdata.get("message");	
					//IN063669 Changes Starts
					//out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); //Commented for IN063669
					out.println("alert('"+errorMsg+"');window.close()"); //Added for IN063669					
					//IN063669 Changes Ends
				}
				else if(returnVal.equals("") || returnVal.equals("TRANS_FAILED"))
				{
					//out.println("commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?"+queryString +"'"); 
					out.println("parent.ManageConsultOrderdtl.location.href='../../eOR/jsp/ManageConsultOrdersDetail.jsp?"+queryString +"'"); 
					out.println("parent.ManageConsultOrderbtn.location.href='../../eOR/jsp/ManageConsultOrdersButton.jsp?"+queryString +"'");  
					tabdata = MessageManager.getMessage(locale, "OPERATION_FAILED","OR");
					errorMsg = (String) tabdata.get("message");		
					out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); 
				}
				else if(returnVal.equals("") && returnVal.equals("NO_CHANGES_TO_SAVE"))
				{
					//out.println("commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?"+queryString +"'"); 
					out.println("parent.ManageConsultOrderdtl.location.href='../../eOR/jsp/ManageConsultOrdersDetail.jsp?"+queryString +"'"); 
					out.println("parent.ManageConsultOrderbtn.location.href='../../eOR/jsp/ManageConsultOrdersButton.jsp?"+queryString +"'");  
					tabdata = MessageManager.getMessage(locale, "NO_CHANGES_TO_SAVE","Common");
					errorMsg = (String) tabdata.get("message");		
					out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); 
				}
			}
		}				
		putObjectInBean("Or_ManageConsOrders",ManageConsOrders,session);
	}catch(Exception e){
		e.printStackTrace();	
	}
%>	 
	
