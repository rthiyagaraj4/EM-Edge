<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<HTML>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
String facility_id=(String)session.getAttribute("facility_id");
try{
	String locn_type		= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String workplace_code		= request.getParameter("workplace_code")==null?"":request.getParameter("locn_type");
	String workplace_desc		= request.getParameter("workplace_desc")==null?"":request.getParameter("workplace_desc");
	String role_type	= request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_id	= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String staff_name	= request.getParameter("staff_name")==null?"":request.getParameter("staff_name");
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	

	locn_type = locn_type.trim();
	workplace_code = workplace_code.trim();
	workplace_desc = workplace_desc.trim();
	role_type = role_type.trim();
	staff_id = staff_id.trim();
	staff_name = staff_name.trim();

	String sql_staffforworkplace="select d.short_desc locn_desc,a.workplace_code,   c.workplace_desc,decode(b.role_type,'P','Practitioner','O','Other Staff') role,a.staff_id, b.staff_name from rs_staff_for_workplace a, am_staff_vw b, rs_workplace c, am_care_locn_type d where a.facility_id  =?  and a.eff_status='E'  and (? is null or d.locn_type =?) and upper(a.workplace_code) like  upper(?) and upper(c.workplace_desc) like  upper(?) and upper(a.role_type) like  upper(?) and upper(a.staff_id) like  upper(?) and upper(b.staff_name) like  upper(?) and b.staff_id = a.staff_id and d.locn_type(+) = c.locn_type and c.facility_id = a.facility_id and c.workplace_code = a.workplace_code";
	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData",sql_staffforworkplace);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("locn_desc");
	displayFields.add("workplace_code");
	displayFields.add("workplace_desc");
	displayFields.add("role");
	displayFields.add("staff_id");
	displayFields.add("staff_name");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add( facility_id);
	chkFields.add( locn_type );
	chkFields.add( locn_type );
	chkFields.add( workplace_code+"%" );
	chkFields.add( workplace_desc+"%" );
	chkFields.add( role_type);
	chkFields.add( staff_id+"%" );
	chkFields.add( staff_name+"%" );

	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	
	//Calling the Result from Common Adaptor as a arraylist.//
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

<table cellpadding=0 cellspacing=0 border=1 width='98%'>
<tr>
	<th width="15%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
	<th width="15%"><fmt:message key="eRS.WorkplaceCode.label" bundle="${rs_labels}"/></th>
	<th width="25%"><fmt:message key="eRS.WorkplaceDescription.label" bundle="${rs_labels}"/></th>
	<th width="10%"><fmt:message key="Common.Role.label" bundle="${common_labels}"/></th>
	<th width="10%"><fmt:message key="eRS.StaffId.label" bundle="${rs_labels}"/></th>
	<th width="25%"><fmt:message key="eRS.StaffName.label" bundle="${rs_labels}"/></th>
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
		for(int colCount=0; colCount<6; colCount++){		
			String str = (String)records.get(colCount); %>	
			<td class="<%=classvalue%>"><%=str%></td>
		  <%}//end of for loop
		  %>
</tr>
<%}//L00p for all records%>
</table>
	<%
	out.flush();
	}else{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eRS/jsp/StaffForWorkplaceQueryResult.jsp", searched));
		}catch(Exception e ){
			out.println("here in catch"+e);
		}
%>
</body>
</html>  

