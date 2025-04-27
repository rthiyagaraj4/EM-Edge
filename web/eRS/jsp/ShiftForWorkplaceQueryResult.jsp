<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
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
<script Language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classvalue = "";
	String facility_id=(String)session.getAttribute("facility_id");
	try
	{
		String workplace_code		= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
		String workplace_desc		= request.getParameter("workplace_desc")==null?"":request.getParameter("workplace_desc");
		String shift_code	= request.getParameter("shift_code")==null?"":request.getParameter("shift_code");
		String shift_desc	= request.getParameter("shift_desc")==null?"":request.getParameter("shift_desc");
		boolean searched = request.getParameter( "searched" ) == null? false : true  ;	

		workplace_code = workplace_code.trim();
		workplace_desc = workplace_desc.trim();
		shift_code = shift_code.trim();
		shift_desc = shift_desc.trim();

		//String sql_shiftforworkplace="select a.workplace_code, b.workplace_desc, a.shift_code,c.short_desc shift_desc from rs_shift_for_workplace a, rs_workplace b, am_shift c where a.facility_id=? and a.workplace_code=b.workplace_code and a.shift_code=c.shift_code and upper(a.workplace_code) like(upper(?)) and upper(b.workplace_desc) like (upper(?)) and upper(a.shift_code) like (upper(?)) and upper(c.short_desc) like (upper(?))";
		String sql_shiftforworkplace="select a.workplace_code, b.workplace_desc, a.shift_code,c.short_desc shift_desc from rs_shift_for_workplace a, rs_workplace_lang_vw b, am_shift_lang_vw c where a.facility_id=? and a.workplace_code=b.workplace_code and a.shift_code=c.shift_code and upper(a.workplace_code) like(upper(?)) and upper(b.workplace_desc) like (upper(?)) and upper(a.shift_code) like (upper(?)) and upper(c.short_desc) like (upper(?)) and b.language_id = ? and c.language_id = b.language_id";

		//Common parameters.
		HashMap sqlMap = new HashMap();

		//include all the common parameters.
		sqlMap.put( "sqlData",sql_shiftforworkplace);
		
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		
		displayFields.add("workplace_code");
		displayFields.add("workplace_desc");
		displayFields.add("shift_code");
		displayFields.add("shift_desc");
		
		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();

		chkFields.add( facility_id);
		chkFields.add( workplace_code+"%" );
		chkFields.add( workplace_desc+"%" );
		chkFields.add( shift_code+"%" );
		chkFields.add( shift_desc+"%" );
		chkFields.add( locale );

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
		<th width="16%"><fmt:message key="eRS.WorkplaceCode.label" bundle="${rs_labels}"/></th>
		<th width="37%"><fmt:message key="eRS.WorkplaceDescription.label" bundle="${rs_labels}"/></th>
		<th width="10%"><fmt:message key="eRS.ShiftCode.label" bundle="${rs_labels}"/></th>
		<th width="37%"><fmt:message key="eRS.ShiftDescription.label" bundle="${rs_labels}"/></th>
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
			for(int colCount=0; colCount<4; colCount++){		
				String str = (String)records.get(colCount); 
%>	
				<td class="<%=classvalue%>"><%=str%></td>
<%
			}//end of for loop
%>
			</tr>
<%
		}//L00p for all records%>
		</table>
<%
		out.flush();
		}
		else{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<%	
		}
			out.println(CommonBean.setForm(request ,"../../eRS/jsp/ShiftForWorkplaceQueryResult.jsp", searched));
		}catch(Exception e ){
			out.println("here in catch"+e);
		}
%>
</body>
</html> 

