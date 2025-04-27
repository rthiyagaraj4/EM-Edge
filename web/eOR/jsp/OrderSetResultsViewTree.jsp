<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<link rel="stylesheet" type="text/css" href="../../eOR/html/ORMainMenu.css"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/ORMainMenu.js"></script>

 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../js/ResultOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- added to include the function for viewing the results onclicking the status hyperlink -->
	<script>
	function dummy(){
	}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	//String mode			= "1";//request.getParameter( "mode" ) ;
	//String function_id	= request.getParameter( "function_id" ) ;
	
	String patient_id	= request.getParameter("patientId");
	String encounter_id	= request.getParameter("encntr_id");
	String bean_id 		= "@existingorderbean"+patient_id+encounter_id;
	String bean_name	= "eOR.ExistingOrder";

	ArrayList allValues = new ArrayList();
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 	//bean.setMode( mode ) ;
 
%>
<%
	String patientId		= request.getParameter( "patientId" ) ;
	String encntr_id		= request.getParameter( "encntr_id" ) ;
	String order_status		= request.getParameter( "ord_status" ) ;
		order_status		= "Z"; // By default make the order_status as "Z", should bring the record for all status
	String order_by			= request.getParameter( "order_by" ) ;
	String catalog			= request.getParameter( "catalog" ) ;
	String view				= request.getParameter( "view" ) ;
	String priority			= request.getParameter( "priority" ) ;
	String date_from		= request.getParameter( "date_from" ) ;
	String date_to			= request.getParameter( "date_to" ) ;
	String order_category	= request.getParameter( "order_category" ) ;
	String order_type		= request.getParameter( "order_type" ) ;
	String view_by			= request.getParameter( "view_by" ) ;
	String search_criteria	= request.getParameter( "search_criteria" ) ;
	String catalog_desc		= request.getParameter("catalog_desc");
	String orderId			= request.getParameter( "orderId" ) ; // Will get orderId only if it is for OrderSet results
	String practitioner_type = (String)session.getValue("practitioner_type");

	String order_grouping_category = "";
	String executable_name		   = "../../eOR/jsp/OrderSetResultsView.jsp?"+request.getQueryString();
	String workAreaFrame		   = "ExistingOrderSetViewResult";
	String query_executable_name   = "";
	String order_line_num		   = "";
 	String[] existing_details = null;
	int i	= 0;
  	if(patientId != null )patientId = patientId.trim();			else patientId = "";
	if(encntr_id != null )encntr_id = encntr_id.trim();			else encntr_id = "";
	if(orderId != null )orderId = orderId.trim();				else orderId = "";
	if(view != null )view = view.trim();						else view = "";
	if(order_status != null )order_status = order_status.trim();else order_status = "";
	if(priority != null )priority = priority.trim();			else priority = "";
	if(date_from != null )date_from = date_from.trim();			else date_from = "";
	if(date_to != null )date_to = date_to.trim();				else date_to = "";
	if(order_category != null )order_category = order_category.trim();	else order_category = "";
	if(order_type != null )order_type = order_type.trim();		else order_type = "";
	if(catalog != null )catalog = catalog.trim();				else catalog = "";
	if(search_criteria != null )search_criteria = search_criteria.trim();	else search_criteria = "";
	if(order_by != null )order_by = order_by.trim();			else order_by = "";
	if(view_by != null )view_by = view_by.trim();				else view_by = "";
	if(catalog_desc != null )catalog_desc = catalog_desc.trim();				else catalog_desc = ""; 
  	allValues		= bean.getOrderSetSearchDetails(view,patientId,encntr_id,order_status,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, orderId,practitioner_type);
	 
%>
<FORM METHOD=POST ACTION="" name="frmMenu" id="frmMenu">
<script> 
	 
		var obj;
		obj = new dTree('obj');
		obj.add(0,-1,'<font size=1 style=font-weight:bold style=color:#333><a class="gridLink" href="#" onClick="showOrderSetResults()" ><%=catalog_desc%></a></font>');
		obj.config.useStatusText=true;
 <% 	if(allValues.size() == 0){			%>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common")); 
 			parent.window.close();
<%		} else {  
			for(i=0; i<allValues.size(); i++){
			   existing_details = (String[])allValues.get(i);
		       if(existing_details[0] == null) existing_details[0] = "";
		       if(existing_details[1] == null) existing_details[1] = "";
			   if(existing_details[3] == null) existing_details[3] = "";
				if(existing_details[3].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])existing_details[3].split("!~!");
					String order_detail ="";
					String[] strtitle = null;
					for(int s=0;s<str.length;s++)
					{
						if(str[s].indexOf("$$RD##")!=-1)
						{
							String line_order = (String)str[s];
							strtitle  =line_order.split("::");
							String titleText = "";
							if(strtitle[1].length()>0)
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
							}
							else
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
							}
							strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
							order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
						}
						else
						{
							order_detail = order_detail+str[s]+", ";
						}
					}
					existing_details[3] = order_detail;
					if(existing_details[3].lastIndexOf(",") ==((existing_details[3].length())-2))
					{
						existing_details[3] = existing_details[3] .substring(0,((existing_details[3].length())-2));
					}
				}
				if(existing_details[3].indexOf("!~!")!=-1)
				{
					existing_details[3] = existing_details[3].replace("!~!",",");
				}
			   if(existing_details[9] == null) existing_details[9] = "";if(existing_details[11] == null) existing_details[11] = "";
			   if((view_by.trim()).equals("L")){
					order_line_num = existing_details[11];
			   } else  {
					order_line_num = "";
			   }
 			   query_executable_name		= executable_name+"&order_cat="+existing_details[0]+"&order_cat_desc="+existing_details[1]+"&line_order_id="+existing_details[9]+"&order_line_num="+order_line_num;
   			   if(!order_grouping_category.equals(existing_details[0])) {
%>			   		obj.add("<%=existing_details[0]%>1","0","<%=existing_details[1]%>","<%=query_executable_name%>","<%=existing_details[1]%>","<%=workAreaFrame%>","","","","");
					obj.add("OPTION_ID<%=i%>1","<%=existing_details[0]%>1","<%=existing_details[3]%>","<%=query_executable_name%>","<%=existing_details[3]%>","<%=workAreaFrame%>","","","","");
<%				} else {  %>
 					obj.add("OPTION_ID<%=i%>1","<%=existing_details[0]%>1","<%=existing_details[3]%>","<%=query_executable_name%>","<%=existing_details[3]%>","<%=workAreaFrame%>","","","","");
<%				} 
				order_grouping_category = existing_details[0]; 
 			} // End of For
	  } 
 %>
</script>
	<input type="hidden" name="txtNodePoistions" id="txtNodePoistions" value="<%=i%>">
 	<input type="hidden" name="txtCurrentPosition" id="txtCurrentPosition" value="">
	<input type="hidden" name="txtToolTips" id="txtToolTips" value="">
	<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<script>
 		document.write(obj);
		obj.openAll();
   		parent.ExistingOrderSetViewResult.location.href="<%=executable_name%>";
  	</script>

 </form>
</body>
</html>

<%
	//putObjectInBean(bean_id,bean,request);
%>	

