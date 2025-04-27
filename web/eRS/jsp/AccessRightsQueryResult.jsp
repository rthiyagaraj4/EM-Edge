<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:
*	Created By		:	P.Anuradha
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classvalue = "";
	/*----- Required while Selecting sql and Formatting display------*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

	try{

		String appl_user_id = request.getParameter("appl_user_id");
		String appl_user_name = request.getParameter("appl_user_name");
		String workplace_code = request.getParameter("workplace_code");
		String workplace_description = request.getParameter("workplace_desc");
        boolean searched = request.getParameter( "searched" ) == null? false : true;
	
		if(appl_user_id==null )
			appl_user_id ="";
		else 
			appl_user_id = appl_user_id.trim(); 

		if(appl_user_name==null )
			appl_user_name="";
		else
			appl_user_name = appl_user_name.trim();

		if(workplace_code==null )
			workplace_code="";
		else
			workplace_code = workplace_code.trim();

		if(workplace_description==null )
			workplace_description="";
		else
			workplace_description = workplace_description.trim();

		//Common parameters.
		HashMap sqlMap = new HashMap();
		//include all the common parameters.
		//String SelectSql="select distinct a.appl_user_id appl_user_id,b.appl_user_name appl_user_name,a.workplace_code workplace_code,c.workplace_desc workplace_desc,a.setup_requirement_yn setup_requirement_yn,a.allocate_yn allocate_yn,a.reallocate_yn reallocate_yn,a.cancel_schedule_yn cancel_schedule_yn from rs_access_rights a,sm_appl_user b,rs_workplace c,sm_facility_for_user d where upper(a.appl_user_id) like upper(?) and upper(b.appl_user_name) like upper(?) and upper(a.workplace_code) like upper(?) and upper(c.workplace_desc) like  upper(?) and a.facility_id=c.facility_id and a.workplace_code=c.workplace_code and a.appl_user_id=b.appl_user_id and a.facility_id=d.facility_id";
		String SelectSql="select distinct a.appl_user_id appl_user_id,b.appl_user_name appl_user_name,a.workplace_code workplace_code,c.workplace_desc workplace_desc,a.setup_requirement_yn setup_requirement_yn,a.allocate_yn allocate_yn,a.reallocate_yn reallocate_yn,a.cancel_schedule_yn cancel_schedule_yn from rs_access_rights a,sm_appl_user_lang_vw b,rs_workplace_lang_vw c,sm_facility_for_user d where upper(a.appl_user_id) like upper(?) and upper(b.appl_user_name) like upper(?) and upper(a.workplace_code) like upper(?) and upper(c.workplace_desc) like  upper(?) and a.facility_id=c.facility_id and a.workplace_code=c.workplace_code and a.appl_user_id=b.appl_user_id and a.facility_id=d.facility_id and b.language_id = ? and c.language_id = b.language_id";

		sqlMap.put( "sqlData",SelectSql);

		//The fields are going to be display.
		ArrayList displayFields = new ArrayList();
		displayFields.add("appl_user_id" );
		displayFields.add("appl_user_name");
		displayFields.add("workplace_code");
		displayFields.add("workplace_desc");
		displayFields.add("setup_requirement_yn");
		displayFields.add("allocate_yn");
		displayFields.add("reallocate_yn");
		displayFields.add("cancel_schedule_yn");

		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add(appl_user_id+"%" );
		chkFields.add(appl_user_name+"%" );
		chkFields.add(workplace_code+"%");
		chkFields.add(workplace_description+"%");
		chkFields.add(locale);

		// Adding function related array list into the HashMap//
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.//
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

		if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){	
%>
<table cellpadding=0 cellspacing=0 width="98%" align="center">
	<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
		<%
			// For display the previous/next link
		    out.println(result.get(1));
		%>
		</td></tr>
</table>
<table cellpadding=0 cellspacing=0 border=1 width='98%' align="center">
<tr>
	<th><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eRS.WorkplaceCode.label" bundle="${rs_labels}"/></th>
	<th><fmt:message key="eRS.WorkplaceDescription.label" bundle="${rs_labels}"/></th>
	<th><fmt:message key="eRS.SetUpReq.label" bundle="${rs_labels}"/></th>
	<th><fmt:message key="eRS.Allocate.label" bundle="${rs_labels}"/></th>
	<th><fmt:message key="eRS.Re-allocate.label" bundle="${rs_labels}"/></th>
	<th><fmt:message key="eRS.CancelSch.label" bundle="${rs_labels}"/></th></tr>
	<%
	//------------Retriving the records from result arraylist------------------//
	ArrayList records=new ArrayList();
	for(int recCount=2; recCount<result.size(); recCount++) {
		if ( recCount % 2 == 0 )
			classvalue = "QRYEVEN" ;
		else
			classvalue = "QRYODD" ;
		String link_columns = "1";
		String align="";
		 records=(ArrayList) result.get( recCount );
	%>
	<tr>
		<%
			for(int colCount=0; colCount<8; colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>"><%=(String)records.get(colCount)%></td>
		<%}else{
			String str = (String)records.get(colCount);			
			if(colCount == 4 )
				str=str.equals("Y")?enableGif:disableGif;
			if(colCount == 5 )
				str=str.equals("Y")?enableGif:disableGif;		
			if(colCount == 6 )
				str=str.equals("Y")?enableGif:disableGif;
			if(colCount == 7 )
				str=str.equals("Y")?enableGif:disableGif;		
		%>
			<td class="<%=classvalue%>" align='<%=align%>'onclick="disableClick(event);"><%=str%></td>
		  <%}//with out hyper link
		}//loop for all tds
		%>
	</tr>
	<%}//Loop for all records%>
	</table>
	<%
		out.flush();
		} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
		}
		out.println(CommonBean.setForm(request ,"../../eRS/jsp/AccessRightsQueryResult.jsp", searched));
		}catch(Exception e ){
		out.println("here in catch"+e);
		}
	%>
</body>
</html>

