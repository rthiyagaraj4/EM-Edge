
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
		OrderEntryReportGrouping orderEntryGrpBean = (OrderEntryReportGrouping)getObjectFromBean("Or_OrderEntryRptGrp","eOR.OrderEntryReportGrouping",session);	
		orderEntryGrpBean.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
		String callFrom =(String) hash.get("CallFrom");

		if(callFrom.equals("ADD_ORDER_TYPE"))
		{		
			String order_type =(String) hash.get("order_type");
			//ArrayList orderTypeValues = (ArrayList)orderEntryGrpBean.getOrderTypes();
			//if(!orderTypeValues.contains(order_type))
			//{					
				orderEntryGrpBean.setOrderType(order_type);	
			//}
		}else if(callFrom.equals("REMOVE_ORDER_TYPE"))
		{		
			String order_type =(String) hash.get("order_type");		
			System.out.println("in remove order type order_type 38"+order_type);
			orderEntryGrpBean.removeOrderType(order_type);	
		}else if(callFrom.equals("CLEAR_OBJECT"))
		{									
			orderEntryGrpBean.clearObject();	
		}
		else if(callFrom.equals("SAVE_RPT_GRP"))
		{	
			Boolean flag = true;
			String errorMsg = "";
			String queryString = "home_required_yn=Y&menu_id=ORDERENTRYRESULTREPORTING&module_id=OR&function_id=ORMS_ORDER_ENTRY_REP_GROUP&function_name=Order Entry Report Grouping Setup&function_type=F&access=YYYNN&desktopFlag=N";
			System.out.println("OROrderEntryRepGrpInterMediate.jsp   hash    :   "+hash);
			hash.put("ADDED_BY_ID",user_id);
			hash.put("ADDED_AT_WS_NO",client_ip_address);
			hash.put("ADDED_FACILITY_ID",facility_id);		
			System.out.println("OROrderEntryRepGrpInterMediate.jsp getOrderTypes   :    "+orderEntryGrpBean.getOrderTypes());
			ArrayList orderTypeValues = (ArrayList)orderEntryGrpBean.getOrderTypes();
			String APPL_ORD_TYPE=(String)hash.get("APPL_ORD_TYPE");		
			String mode = (String)hash.get("MODE");	
			String eff_status = (String)hash.get("EFF_STATUS");	
			String order_category = (String)hash.get("ORDER_CATEGORY");	
			System.out.println("mode 54"+mode);
			System.out.println("eff_status 58"+eff_status);
			Hashtable tabdata = new Hashtable();
			String returnVal = "";
			//if(mode.equalsIgnoreCase("1"))
			//{
				returnVal = orderEntryGrpBean.validate(hash);
				System.out.println("it enters 58 returnVal"+returnVal);
				if(!returnVal.equalsIgnoreCase("RECORD_NOT_EXISTS"))
				{
				//if(returnVal.equalsIgnoreCase("RECORD_EXISTS"))
				//{
					flag = false;
					out.println("commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?"+queryString +"'"); 
					out.println("OROrderentryreportGrpdtl.location.href='../../eOR/jsp/OROrderEntryRepGrpAddModify.jsp?"+queryString +"'"); 
					out.println("paneldetails1.location.href='../../eCommon/html/blank.html'"); 
					
					if((returnVal.equalsIgnoreCase("RECORD_EXISTS1"))||(returnVal.equalsIgnoreCase("RECORD_EXISTS_FOR_CATEGORY")))
					{
						tabdata = MessageManager.getMessage(locale,returnVal,"OR");
					}
					errorMsg = (String) tabdata.get("message");	
					if((returnVal.equalsIgnoreCase("RECORD_EXISTS_FOR_CATEGORY")))
					{
						order_category = orderEntryGrpBean.getOrderCategoryDesc(order_category);
						System.out.println("order_category 84"+order_category);
						errorMsg = errorMsg.replace("$$",order_category);
					}
					System.out.println("errorMsg 83"+errorMsg);
					out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); 
				}
					
				//}
			//}
			System.out.println("flag 71"+flag);
			if(flag)
			{
				if((orderTypeValues.size()>0 && APPL_ORD_TYPE.equalsIgnoreCase("S")||(APPL_ORD_TYPE.equalsIgnoreCase("A"))))
				{
					returnVal = orderEntryGrpBean.insert(hash);	
					System.out.println("OROrderEntryRepGrpInterMediate.jsp   returnVal    :   "+returnVal);
					if(returnVal.equals("TRANS_SUCCESS"))
					{
						out.println("commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?"+queryString +"'"); 
						out.println("OROrderentryreportGrpdtl.location.href='../../eOR/jsp/OROrderEntryRepGrpAddModify.jsp?"+queryString +"'"); 
						out.println("paneldetails1.location.href='../../eCommon/html/blank.html'"); 
						tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
						errorMsg = (String) tabdata.get("message");				
						out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); 
					}
					else if(returnVal.equals("") && returnVal.equals("TRANS_FAILED"))
					{
						out.println("commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?"+queryString +"'"); 
						out.println("OROrderentryreportGrpdtl.location.href='../../eOR/jsp/OROrderEntryRepGrpAddModify.jsp?"+queryString +"'"); 
						out.println("paneldetails1.location.href='../../eCommon/html/blank.html'"); 
						tabdata = MessageManager.getMessage(locale, "OPERATION_FAILED","OR");
						errorMsg = (String) tabdata.get("message");		
						out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); 
					}
				}
				else
				{
					tabdata = MessageManager.getMessage(locale, "SELECT_ORDER_TYPE_FOR_SPECIFIC","OR");
					errorMsg = (String) tabdata.get("message");					out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); 
				}
			}
		}
		putObjectInBean("Or_OrderEntryRptGrp",orderEntryGrpBean,session);
	}catch(Exception e){
		e.printStackTrace();	
	}
%>	 
	
