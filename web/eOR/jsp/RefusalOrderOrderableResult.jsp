<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- RefusalOrderOrderableResult.jsp -->

<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/12/2012	  IN031304 		Karthi L	  		new column added follow_visit_type(IN035976)  
---------------------------------------------------------------------------------------------------------------
*/ %>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- JSP Page specific attributes end --%>
 

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%> 

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	  
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/RefusalOrders.js"></script> 
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<!--<script language="JavaScript" src="../js/OrMessages.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;
		
		function callModify(){
			
			if(document.getElementById("res_size").value == "3"){
				var argArray = window.dialogArguments ;
				var code1=document.getElementById("resTable").rows(1).cells[0].innerText;
				var code2=document.getElementById("resTable").rows(1).cells[1].innerText;
				
				

				var retVal = code1 + "&" + code2 ;
				window.returnValue = retVal ;
				window.close()
			}
		}
    </script>

	
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="refOrderableresult" id="refOrderableresult">
<%			
         
		String CallingModule = (request.getParameter("CallingModule")==null) ? "":request.getParameter("CallingModule");		
		String called_from = request.getParameter("called_from");
		if(called_from==null) called_from = "";
		String order_category=request.getParameter("order_category");
		String order_type_code=request.getParameter("type_code");
		String activity_type=request.getParameter("activity_type");
		String type_desc=request.getParameter("type_desc");
		String activity_desc=request.getParameter("activity_desc");		
 		String search_by=request.getParameter("search_by");
		if(search_by==null || search_by=="null") search_by = "C";
 		String description_code=request.getParameter("description_code");
		String long_desc=request.getParameter("search_text");		
		if(long_desc==null || long_desc=="null") long_desc = "";
 		//String table_name = (request.getParameter("table_name")==null) ? "":request.getParameter("table_name");
		// Apart from the Normal Parameters, when passed from Clinic (OA) p_clinic_code will be passed
		// If called from OP and table name is passed, clinic code is passed
		String p_clinic_code = (request.getParameter("p_clinic_code")==null) ? "":request.getParameter("p_clinic_code");

		// And p_speciality_code if speciality is selected, if from OP and if Wing/OT is selected 
		String p_speciality_code = (request.getParameter("p_speciality_code")==null) ? "":request.getParameter("p_speciality_code");
		// if from OP and if Wing/OT is selected service_code, p_wing_code and p_service_code will be passed 
 		String p_service_code = (request.getParameter("p_service_code")==null) ? "":request.getParameter("p_service_code");
		String p_wing_code = (request.getParameter("p_wing_code")==null) ? "":request.getParameter("p_wing_code");
		//Added by Uma on 3/12/2010 for IN019490
		String practitionerId = (request.getParameter("practitionerId")==null) ? "":request.getParameter("practitionerId");
		String locn_code = (request.getParameter("locn_code")==null) ? "":request.getParameter("locn_code"); //IN031304
		String rd_appt_yn = (request.getParameter("rd_appt_yn")==null) ? "":request.getParameter("rd_appt_yn"); //IN031304
		
		if(rd_appt_yn.equals("Y") && locn_code != null && locn_code != "" && !(locn_code.equalsIgnoreCase("undefined")) && called_from.equalsIgnoreCase("OA")){ // added for IN031304 - Start
			
			if(p_clinic_code == null || p_clinic_code.equals(""))
			{
				p_clinic_code = locn_code;
			}
			
		} // added for IN031304 - END
 		String facility_id = (String)session.getValue("facility_id");
		
		if(p_clinic_code==null || p_clinic_code.equals("null"))
			p_clinic_code ="";
		if(p_speciality_code==null || p_speciality_code.equals("null"))
			p_speciality_code ="";
		if(p_wing_code==null || p_wing_code.equals("null"))
			p_wing_code ="";
		if(p_service_code==null || p_service_code.equals("null"))
			p_service_code ="";


 		//String temp_long_desc="";
		String bean_id = "refusalOrdersBean" ;
		String bean_name = "eOR.RefusalOrdersBean";
		boolean searched = request.getParameter( "searched" ) == null ? false : true  ;
		RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id, bean_name,request) ;
		//Added by Uma on 3/12/2010 for IN019490
		String privilegeApplicabilityOrd = (String)bean.getAuthorisationOrOrderingYn("ORD");
		String sql = "";

	try{
	String classvalue			= "";
	//String callBlur				= "";
	
  	HashMap sqlMap = new HashMap();
 	if(called_from.equalsIgnoreCase("AM") || called_from.equalsIgnoreCase("OP") || called_from.equalsIgnoreCase("OA")) 
	{
		//if(table_name!=null &&  !table_name.equals(""))	 // When table name is passed
		//{
		if(p_speciality_code!=null && !p_speciality_code.equals(""))
		{
			sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_AM"));
		}
		else if(p_clinic_code!=null &&  !p_clinic_code.equals(""))
		{
			sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_OP"));
		}
		else if(p_wing_code!=null &&  !p_wing_code.equals(""))
		{
			sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_WING"));
		}
		else	// Default query
		{
			sqlMap.put( "sqlData",OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_RES_WITHOUT_PH"));
		}
		//}
 		//else
		//	sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_RES_WITHOUT_PH"));

	}
	else
	{
		sql = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_RES");
		//sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_RES"));
		if(privilegeApplicabilityOrd.equalsIgnoreCase("Y"))
		{
			sql = sql.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',order_catalog_code,?)");
		}
		else
		{
			sql = sql.replace("##FILTERCAT##","");
		}
		sqlMap.put( "sqlData", sql);
	}
	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "order_catalog_code");
	displayFields.add("long_desc" );
	
	ArrayList chkFields = new ArrayList();

 	 if(p_wing_code==null ||  p_wing_code.equals("")) 
	{
			chkFields.add(order_category);
			chkFields.add(order_type_code);
			chkFields.add(description_code);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(search_by);
			chkFields.add(description_code);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(search_by);
			chkFields.add(activity_type);
			//chkFields.add(activity_type);
			if(p_speciality_code!=null && !p_speciality_code.equals(""))
				chkFields.add(p_speciality_code);
			else if(p_clinic_code!=null &&  !p_clinic_code.equals("")) 
			{
				if(p_clinic_code.equals("*A"))	p_clinic_code = "";
				chkFields.add(p_clinic_code);
				chkFields.add(facility_id);		
			} 
		} 
		else 
		{
		 	if(p_wing_code.equals("*A"))	p_wing_code = "";
	 		chkFields.add(facility_id);	
			chkFields.add(p_wing_code);	
			chkFields.add(p_service_code);	
			chkFields.add(order_category);
			chkFields.add(order_type_code);
			chkFields.add(description_code);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(search_by);
			chkFields.add(description_code);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(search_by);
			chkFields.add(activity_type);
			//chkFields.add(activity_type);
 		}
		if(called_from.equalsIgnoreCase("AM") || called_from.equalsIgnoreCase("OP") || called_from.equalsIgnoreCase("OA")) 
		{
		}
		else
		{
			/*Added by Uma on 3/12/2010 for IN019490*/

			if(privilegeApplicabilityOrd.equalsIgnoreCase("Y"))
			{
				if(practitionerId.equals(""))
				{
					practitionerId = bean.checkForNull((String)session.getValue("ca_practitioner_id"));
					if(practitionerId.equals("null")||practitionerId==null)
						practitionerId = (String) session.getValue("login_user") ;
				}
				String resp_id = (String)session.getValue("responsibility_id");
				chkFields.add(practitionerId);		//P_PRACTITIONER_ID
				chkFields.add(resp_id);		//P_RESP_ID
				chkFields.add(privilegeApplicabilityOrd);		//P_PRIV_APPL_YN
			}
		}
		/*End here*/

 	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.(sqlMap, funcMap, request,false)
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table border="" cellpadding="0" cellspacing="0" width="100%" align="center" id="resTable" class="grid">
		<td class='COLUMNHEADER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<input type="hidden" name="res_size" id="res_size" value="<%=result.size()%>">
		<%
		//Retriving the records from result arraylist
		
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			//out.println("recCount"+recCount);
			/*if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;*/
				classvalue="gridData";
		%>
			<tr onClick="Modify(this);">
		<%
		String link_columns = "2", disp ="";
		records=(ArrayList) result.get( recCount );		
		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
				//out.println("one");%>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get(colCount)%> 
			</td>
			<%}else{
					
				if(colCount != 3){
					%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);"><a href="#" class="gridLink" onclick='getDescrip("<%=(String)records.get(colCount+0)%>","<%=recCount%>")' ><%
					out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
				%></a><input type="hidden" name="catalog_desc<%=recCount%>" id="catalog_desc<%=recCount%>" value = "<%=(String)records.get(colCount+1)%>"></td> 
				<%
				}else{
						disp = (String)records.get(colCount);
					%>
					<td class="<%=classvalue%>" align="center"><input type='hidden' value=<%=disp%>></img><%
					if(disp.equals("E")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(disp.equals("D")){%><img src="../../eCommon/images/disabled.gif"></img> <%}%></td>

					<%
				}
			}
		}
		%>
		</tr>
		<%}
		%>
		</table>
		<script>//callModify();</script>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<!--<script>getDescrip("noRecords");</script>-->
			<%}
	}
	catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
	}
	%>
	<input type="hidden" name="order_type_desc" id="order_type_desc" value="<%=type_desc%>">
	<input type="hidden" name="order_type_code" id="order_type_code" value="<%=order_type_code%>">
	<input type="hidden" name="activity_desc" id="activity_desc" value="<%=activity_desc%>">
	<input type="hidden" name="activity_code" id="activity_code" value="<%=activity_type%>">
	<input type="hidden" name="CallingModule" id="CallingModule" value="<%=CallingModule%>">
	</form>
	<%
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/RefusalOrderOrderableResult.jsp", searched));
%>
	</body>
	</html>

											



