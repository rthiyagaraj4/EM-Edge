<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	7 January 2005

--%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eRS.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>


<HTML>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classvalue = "";
	String facility_id = (String)session.getValue( "facility_id" ) ;

	try{
		String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
		String workplace_desc	= request.getParameter("workplace_desc")==null?"":request.getParameter("workplace_desc");
		String location_type	= request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String location_code= request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String location_desc	= request.getParameter("location_desc")==null?"":request.getParameter("location_desc");
		
		boolean searched = request.getParameter("searched") == null? false : true  ;	
		workplace_code =workplace_code.trim();
		workplace_desc = workplace_desc.trim();
		location_type	 = location_type.trim();
		location_code = location_code.trim();
		location_desc = location_desc.trim();
		HashMap sqlMap = new HashMap();	
		
		//String sql_terminology="select a.workplace_code,b.workplace_desc,a.locn_type,a.locn_code,c.long_desc from rs_locn_for_workplace a,rs_workplace b,am_care_locn_type c where a.workplace_code=b.workplace_code and a.locn_type=c.locn_type and upper(a.workplace_code) like upper(?) and upper( b.workplace_desc) like upper(?) and upper(a.locn_type) like upper(?) and upper(a.locn_code) like upper(?)  and upper(c.long_desc) like upper(?) and a.facility_id=?";
		String sql_terminology="SELECT a.workplace_code,b.workplace_desc,a.locn_type,a.locn_code,c.long_desc FROM rs_locn_for_workplace a,rs_workplace_lang_vw b,am_care_locn_type_lang_vw c WHERE a.workplace_code=b.workplace_code AND a.locn_type=c.locn_type AND UPPER(a.workplace_code) LIKE UPPER(?) AND UPPER( b.workplace_desc) LIKE UPPER(?) AND UPPER(a.locn_type) LIKE UPPER(?) AND UPPER(a.locn_code) LIKE UPPER(?)  AND UPPER(c.long_desc) LIKE UPPER(?) AND a.facility_id=? AND b.language_id like ? AND c.language_id = b.language_id";
		sqlMap.put( "sqlData",sql_terminology);
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		
		displayFields.add("workplace_code");
		displayFields.add("workplace_desc");
		displayFields.add("locn_type");
		displayFields.add("locn_code");
		displayFields.add("long_desc");
		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();

		chkFields.add(workplace_code+"%");
		chkFields.add(workplace_desc+"%");
		chkFields.add( location_type+"%");
		chkFields.add(location_code+"%");
		chkFields.add(location_desc+"%");
		chkFields.add(facility_id);
		chkFields.add(locale);
		
		// Adding function related array list into the HashMap//
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		ArrayList result=new ArrayList();
		
		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
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
		</td>
	</tr>
	</table>

	<table cellpadding=0 cellspacing=0 border=1 width='97%'  align=center>
	<tr>

	<th align='left'><fmt:message key="eRS.WorkplaceCode.label" bundle="${rs_labels}"/></th>
	<th align='left'><fmt:message key="eRS.WorkplaceDescription.label" bundle="${rs_labels}"/></th>
	<th align='left'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
	<th align='left'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
	<th align='left'><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
</tr>
<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			
			records=(ArrayList) result.get( recCount );
%>				
			<tr>   
<%
			for(int colCount=0; colCount<records.size(); colCount++){		
				String str = (String)records.get(colCount)==null?"":(String)records.get(colCount);
				if(str.equals("")){
%>
					<td class="<%=classvalue%>">&nbsp;</td>
<%			}
				else {
%>
					<td class="<%=classvalue%>"><%=str%></td>
<%
				}
			}//end of for loop
%>
			</tr>
<%
		}//L00p for all records
%>
			</table>
<%
			out.flush();
		}
		else{
%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<%
		}
			out.println(CommonBean.setForm(request ,"../../eRS/jsp/LocnForWorkplaceQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} 
%>
</body>
</html>  

