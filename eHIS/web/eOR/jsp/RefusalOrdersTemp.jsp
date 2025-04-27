<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.*,eOR.*" %>


<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%	
	request.setCharacterEncoding("UTF-8");
	String str = request.getParameter("str");
	String str1 = request.getParameter("str1");
	String str3 = request.getParameter("str3"); //--[IN029211]
	String checked = request.getParameter("checked");
	String ret_bean_val = request.getParameter("ret_bean_val");
	String localeName=request.getParameter("localeName");
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
System.err.println("====bean_id"+bean_id+"==bean_name"+bean_name);
System.err.println("====checked"+checked+"==ret_bean_val"+ret_bean_val);
System.err.println("====str"+str+"==str1"+str1);
System.err.println("====str3"+str3);

	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name , request) ;
	bean.setLanguageId(localeName);
System.err.println("====ret_bean_val"+ret_bean_val);
	if(ret_bean_val.equalsIgnoreCase("Y")){
		ArrayList chkd_val= new ArrayList();
		chkd_val = bean.getSelectedCatalogValue();
		//System.out.println("==========="+chkd_val.size());
		for(int i=0;i<chkd_val.size();i++){
		//out.println("store_ordid_check1["+i+"]='"+chkd_val.get(i)+"'");
		// out.println("store_ordid_check1_temp["+i+"]='"+chkd_val.get(i)+"'");
		// out.println("store_ordid_check1_temp["+i+"]='"+chkd_val.get(i)+"'");
		 out.println( "addOrderId(\"" + i + "\",\"" + chkd_val.get(i) + "\") ; " ) ;
		}

	}else{
		if(checked.equalsIgnoreCase("Y"))
		{
			if(str != null && str != ""){
				bean.setSelectedCatalog(str);
				bean.setSelectedCatalogValue(str1);
				bean.setSelectedOrderId(str3); //--[IN029211]
				//System.out.println("======="+bean.getSelectedCatalogValue()+"=====");
			}
		}
		else
		{
			if(str != null && str != "")
			{
				bean.remSelectedCatalog(str);
				bean.remSelectedCatalogValue(str1);
				bean.remSelectedOrderId(str3);	//--[IN029211]
			}
		}
	}
	putObjectInBean(bean_id,bean,request);
%>
