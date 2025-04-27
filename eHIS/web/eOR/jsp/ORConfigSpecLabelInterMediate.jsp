
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
		String added_facility_id = (String)session.getValue("facility_id");
		String user_id 	=	(String) session.getValue("login_user");
		String client_ip_address = p.getProperty("client_ip_address")==null?"":(String)p.getProperty("client_ip_address");
		ORConfigSpeciLabelFrmtBean configSpecimenLabel = (ORConfigSpeciLabelFrmtBean)getObjectFromBean("Or_ConfigSpecimenLabel","eOR.ORConfigSpeciLabelFrmtBean",session);	
		configSpecimenLabel.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
		String callFrom =(String) hash.get("CallFrom");

		if(callFrom.equals("ADD_ORDER_TYPE"))
		{		
			String order_type =(String) hash.get("order_type");				
			configSpecimenLabel.setOrderType(order_type);	
			
		}else if(callFrom.equals("REMOVE_ORDER_TYPE"))
		{		
			String order_type =(String) hash.get("order_type");					
			configSpecimenLabel.removeOrderType(order_type);	
		}else if(callFrom.equals("CLEAR_OBJECT"))
		{									
			configSpecimenLabel.clearObject();	
		}else if(callFrom.equals("CHK_SPEC_FRMT_EXT"))
		{	
			String facility_id=(String)hash.get("FACILITY_ID");	
			String config_ref_no = configSpecimenLabel.isExistsSpecFrmtForAllOT(facility_id);	
			out.println(config_ref_no);
		}
		else if(callFrom.equals("SAVE_SPEC_FRMT"))
		{	
			Boolean flag = true;
			String errorMsg = "";
			String queryString = "home_required_yn=Y&module_id=OR&function_id=ORMS_CONFIG_SPECIMEN_LBL_NO&function_name=Configure Specimen Label and No&function_type=F&access=YYYNN&desktopFlag=N";			
			hash.put("ADDED_BY_ID",user_id);
			hash.put("ADDED_AT_WS_NO",client_ip_address);
			hash.put("ADDED_FACILITY_ID",added_facility_id);				
	//		ArrayList orderTypeValues = (ArrayList)configSpecimenLabel.getOrderTypes();
	//		String spec_frmt_type=(String)hash.get("SPEC_FRMT_TYPE");		
	//		String facility_id=(String)hash.get("FACILITY_ID");		
	/*		String ext_appl=(String)hash.get("EXT_APPL");		
			String spec_format=(String)hash.get("SPEC_FORMAT");		
			String mode = (String)hash.get("MODE");				
			String config_ref_no = (String)hash.get("CONFIG_REF_NO")==null?"":(String)hash.get("CONFIG_REF_NO");		*/		
			

			Hashtable tabdata = new Hashtable();
			String returnVal = "";					
			returnVal = configSpecimenLabel.validate(hash);
			/*	if(returnVal.equalsIgnoreCase("TRANS_SUCCESS"))
				{		*/											

					configSpecimenLabel.clearObject();	
					out.println("commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?"+queryString +"'"); 
					out.println("frameCofigSpecimenFrmt.location.href='../../eOR/jsp/ORConfigureSpeciLabelHdr.jsp?"+queryString +"'"); 
					out.println("frameCofigSpecimenFrmtDtl.location.href='../../eCommon/html/blank.html'"); 
					
					if(returnVal.equalsIgnoreCase("TRANS_SUCCESS"))				
						tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					else
						tabdata = MessageManager.getMessage(locale, "OPERATION_FAILED","OR");

					errorMsg = (String) tabdata.get("message");			
				
					out.println("messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0'"); 
					
			//	}
					
				//}
			//}
			
		}
		putObjectInBean("Or_ConfigSpecimenLabel",configSpecimenLabel,session);
	}catch(Exception e){
		e.printStackTrace();	
	}
%>	 
	
