
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.io.*,eOR.*, webbeans.eCommon.*,eCA.CommonCollectionUtils,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	java.util.Properties props = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) props.getProperty("LOCALE");
	String bean_id = "Or_ConfigSpecimenLabel" ;
	String bean_name = "eOR.ORConfigSpeciLabelFrmtBean";
	ORConfigSpeciLabelFrmtBean configSpecimenLabel = (ORConfigSpeciLabelFrmtBean)getObjectFromBean(bean_id,bean_name,session);	
	configSpecimenLabel.setLanguageId(locale);
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<!--<link rel='StyleSheet' href='../../eCommon/html/grid.css' type='text/css' />-->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language='javascript' src='../../eOR/js/ORConfigureSpeciLabelFmt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%				
	String config_ref_no=request.getParameter("config_ref_no")==null?"":request.getParameter("config_ref_no");	
	String mode = request.getParameter("mode")==null ? "" : request.getParameter("mode");	
	String from = request.getParameter("from")==null?"0":request.getParameter("from");
	String to = request.getParameter("to")==null?"10":request.getParameter("to");	
	String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String ext_appl = request.getParameter("ext_appl")==null?"":request.getParameter("ext_appl");
	String spec_num_format = request.getParameter("spec_num_format")==null?"":request.getParameter("spec_num_format");
//	String spec_label_frmt = request.getParameter("spec_label_frmt")==null?"":request.getParameter("spec_label_frmt");
	int rowCount = 0;
	int maxRecord = 0;
	int start = 0;
	int end = 0;
	String error_msg = "";	
	end = Integer.parseInt(to);
	start = Integer.parseInt(from);	
	CommonCollectionUtils<String, String> orderTypeMap = null;
	List<String> order_type_lst = null;
	
	try 
	{	
		
		if(config_ref_no.equals(""))
			//config_ref_no = configSpecimenLabel.getConfigrefNo(spec_label_frmt,facility_id,ext_appl,spec_num_format); 
			config_ref_no = configSpecimenLabel.getConfigrefNo(facility_id,ext_appl,spec_num_format); 
		
		configSpecimenLabel.loadOrderTypes(config_ref_no); 
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("MODE",mode);
		paramMap.put("CONFIG_REF_NO",config_ref_no);				
		paramMap.put("FACILITY_ID",facility_id);				
		orderTypeMap = configSpecimenLabel.getOrderTypes(paramMap);		
		order_type_lst =  configSpecimenLabel.getOrderTypes();
		
		maxRecord = orderTypeMap.size();	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	%>
<body>
<form name='OROrderTypefrm' id='OROrderTypefrm'>
<table cellpadding='0' cellspacing='0' border='0' width='50%' align='center'>
	<tr>
	 <td class='white' width='100%'></td> 
	<td class='label' width='16%' align='right' nowrap>
	<%
		if ( !(start <= 1) )
			out.println("<A class='gridLink'  href='../../eOR/jsp/ORConfigureSpeciLabelForOrderType.jsp?from="+(start-10)+"&facility_id="+facility_id+"&config_ref_no="+config_ref_no+"&mode="+mode+"&to="+(end-10)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		if ( !( (end) >= maxRecord ) )
			out.println("&nbsp;<A class='gridLink'  href='../../eOR/jsp/ORConfigureSpeciLabelForOrderType.jsp?from="+(start+10)+"&facility_id="+facility_id+"&config_ref_no="+config_ref_no+"&mode="+mode+"&to="+(end+10)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	%>
		</td>
	</tr>
</table>	
<table border='0' class="grid" cellpadding='3' cellspacing='0' width="50%" align='center'>
	<tr>
		<td class='COLUMNHEADER'  width="30%" height="20" nowrap>
			<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>
		</td>
		<td class='COLUMNHEADER'>
			<fmt:message key="Common.Select.label" bundle="${common_labels}"/> 
		</td>
	</tr>	
		<%
			try{ 		
					if(orderTypeMap != null && orderTypeMap.size() > 0)
					{
						String orderType = ""; 
						String orderTypeDesc = ""; 
						List<String> orderTypeLst = orderTypeMap.keyList();
						int cnt = 1;
						for(int i = start; i < end; i++)
						{
							if(i < orderTypeLst.size())
							{
								orderType = orderTypeLst.get(i);	
								orderTypeDesc = orderTypeMap.get(orderTypeLst.get(i));									
		%>
							<tr>
							<td class="gridData" width="75%"><%=orderTypeDesc%></td>
							<td class="gridData" width="25%"><input type='checkbox' name='order_type_<%=cnt%>' id='order_type_<%=cnt%>' value="<%=orderType%>" onClick="setOrderType(this)" <%if(order_type_lst.contains(orderType)){%>checked<%}%>></td>
							</tr>
		<%
						cnt++;
		
						}	
						}	
					}else{
						error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";
						out.println("<script>alert(getMessage('"+error_msg+"','Common'));</script>");						
						out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
					}
					
			}catch(Exception e)
			{
				e.printStackTrace(System.err);
			}
			
		%>
</table>
</form>
</body>
</html>

	


	




