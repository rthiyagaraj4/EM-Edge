<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	29 Oct 2004
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function Modify(obj,longdesc,locn_type,enable_temp)
{
		var shift_pattern_id	= obj.cells[0].innerText;
		var short_desc			= obj.cells[1].innerText;
		var long_desc	 			=longdesc;
		var locn_type				= locn_type;
		var eff_status				= enable_temp;
		//alert("longdesc--------->"+unescape(longdesc));
		//alert("decodeURIComponent(longdesc)--------->"+decodeURIComponent(longdesc));
		 
document.location.href="../../eRS/jsp/ShiftPatternFrameSet.jsp?mode=2&function_id="+parent.function_id+"&shift_pattern_id="+shift_pattern_id+"&long_desc="+long_desc+"&short_desc="+ unescape(short_desc)+"&locn_type="+locn_type+"&eff_status="+eff_status;
}
</script>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String classvalue = "";
	/*----- Required while Selecting sql and Formatting display------*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

	try{

		boolean searched			= request.getParameter( "searched" ) == null? false : true  ;
		String enable_temp="";
		String long_desc="";
		String shift_pattern_id	= request.getParameter("shift_pattern_id").equals(null)?"":request.getParameter("shift_pattern_id");
		String short_desc			= request.getParameter("short_desc").equals(null)?"":request.getParameter("short_desc");
		String locn_type				= request.getParameter("locn_type").equals(null)?"":request.getParameter("locn_type");
		String	eff_status			=request.getParameter("eff_status").equals(null)?"":request.getParameter("eff_status");
		if(locn_type.equals(" "))
			locn_type="";


		HashMap sqlMap = new HashMap();

		//sqlMap.put("sqlData","select a.shift_pattern_id, a.long_desc, a.short_desc,  a.locn_type, b.short_desc locn_desc, a.eff_status from rs_shift_pattern a, am_care_locn_type b where a.shift_pattern_id like upper(?)and upper(a.short_desc) like upper(?)  and ((? is null or a.locn_type = ?) and a.locn_type=b.locn_type(+))  and a.eff_status like upper(?)");
		sqlMap.put("sqlData","select a.shift_pattern_id, a.long_desc, a.short_desc,  a.locn_type, b.short_desc locn_desc, a.eff_status from rs_shift_pattern_lang_vw a, am_care_locn_type_lang_vw b where a.shift_pattern_id like upper(?)and upper(a.short_desc) like upper(?)  and ((? is null or a.locn_type = ?) and a.locn_type=b.locn_type(+))  and a.eff_status like upper(?) and a.language_id = ? and b.language_id = a.language_id");


		ArrayList displayFields = new ArrayList();
		displayFields.add("shift_pattern_id" );
		displayFields.add("long_desc");
		displayFields.add("short_desc");
		displayFields.add("locn_type");
		displayFields.add("locn_desc");
		displayFields.add("eff_status");

		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add( shift_pattern_id+"%" );
		chkFields.add( short_desc+"%" );
		chkFields.add( locn_type);
		chkFields.add( locn_type);
		chkFields.add( eff_status+"%" );
		chkFields.add( locale );

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
	<th width="15%"><fmt:message key="eRS.ShiftPatternID.label" bundle="${rs_labels}"/></th>
	<th width="30%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th width="15%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
	<th width="15%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
</tr>

	<%
	//------------Retriving the records from result arraylist------------------//
	ArrayList records=new ArrayList();
	for(int recCount=2; recCount<result.size(); recCount++) {
		if ( recCount % 2 == 0 )
			classvalue = "QRYEVEN" ;
		else
			classvalue = "QRYODD" ;
		String link_columns = "1";
		 records=(ArrayList) result.get( recCount );
		 long_desc=(String)records.get(1);
		 long_desc=java.net.URLEncoder.encode(long_desc,"UTF-8");
			
		 //System.err.println("long_desc------->"+long_desc);
		 locn_type=(String)records.get(3);
		 enable_temp=(String)records.get(5);
	%>
	<tr onClick="Modify(this,'<%=long_desc%>','<%=locn_type%>','<%=enable_temp%>');" >
		<%
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
		<%}else{
			if((colCount==1)||(colCount ==3)) continue;
			String str = (String)records.get(colCount)==null?"":(String)records.get(colCount);	

			if(colCount == 5 )
				str=str.equals("E")?enableGif:disableGif;
			if(str.equals("")){
		%>
			<td class="<%=classvalue%>" onclick="disableClick(event);">&nbsp;</td>
		<%}else{%>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><%=str%></td>
		  <%}}//with out hyper link
		}//loop for all tds
		%>
	</tr>
	<%}//L00p for all records%>
	</table>

	<%
		out.flush();
		} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
		}
		out.println(CommonBean.setForm(request ,"../../eRS/jsp/ShiftPatternQueryResult.jsp", searched));
		}catch(Exception e ){
			out.println("here in catch"+e);
		}
%>
</body>
</html>

