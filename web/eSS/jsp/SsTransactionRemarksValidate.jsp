<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="alSelectedRemarks" scope="session" class="java.util.ArrayList"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale					=		(String)session.getAttribute("LOCALE");
	String bean_id					=		request.getParameter("bean_id");
	String bean_name				=		request.getParameter("bean_name");
	int functionType				=		Integer.parseInt(request.getParameter("function_type"));

	if ((bean_id == null) || (bean_id.equals("")))
		return;
	SsTransactionRemarksBean bean		=		(SsTransactionRemarksBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
    hash							=		(Hashtable) hash.get ("SEARCH");
	
	switch (functionType) {
		case 1: 
			{
					if (hash.size() > 0) {
						bean.updateSelectedRemarks(hash);
					}
			}
			break;
			case 2: 
			{	
					bean.clear();
					bean.setSelect_All("");
					String trans_type		=		request.getParameter("trans_type");
					bean.setTransaction_Type(trans_type);
				
			}
			break;
			case 3: 
			{	
					String select_all		=		(String)request.getParameter("select_all")==null?"":(String)request.getParameter("select_all");
					String totalRecords		=		request.getParameter("totalRecords");
					if(select_all.equals("Y"))bean.setSelect_All(select_all);
					bean.setTotalRemarks(Integer.parseInt(totalRecords));
					if (hash.size() > 0) {
						bean.updateSelectedRemarks(hash);
					}
								
			}
			break;
			case 4: 
			{	
					String total_records	= (String)hash.get("obj");
					bean.setTotalRemarks(Integer.parseInt(total_records));
					
				
			}
			break;
			
		default :
			out.println("alert(\'Invalid Function : "+functionType+"\');");
			return;
	}
%>
<%
	putObjectInBean(bean_id,bean,request);
%>
