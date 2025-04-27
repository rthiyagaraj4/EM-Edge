<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:
*	Created By		:	Suri
*	Created On		:	15 January 2005
-->
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eRS.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<script>
	function Modify(obj,asyn,enable_temp){
		var grade_code						= obj.cells[0].innerText;
		var grade_desc			= obj.cells[1].innerText;
		var grade_level						= obj.cells[2].innerText;
		var allow_scheduling_yn	= asyn;
		var ft_work_hours					= obj.cells[4].innerText;
		var eff_status							= enable_temp;
document.location.href="../../eRS/jsp/GradeAddModify.jsp?mode=2&grade_code="+grade_code;
}
</script>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classvalue = "";
	/*----- Required while Selecting sql and Formatting display------*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;
	try{
		String grade_code			= request.getParameter("grade_code");
		String grade_desc			= request.getParameter("grade_desc");
		String grade_level				= request.getParameter("grade_level");
		String	 allow_scheduling_yn	=request.getParameter("allow_scheduling_yn");
		String ft_work_hours		=request.getParameter("ft_work_hours");
		String	 eff_status	=request.getParameter("eff_status");
		//System.err.println("eff_status----<"+eff_status);
		boolean searched			= request.getParameter( "searched" ) == null? false : true  ;
		String enable_temp="";
		String asyn="";

		if(grade_code==null )
			grade_code ="";
		else 
			grade_code = grade_code.trim(); 
		if(grade_desc==null )
			grade_desc="";
		else
			grade_desc = grade_desc.trim();
		if(grade_level==null )
			grade_level="";
		else
			grade_level = grade_level.trim();
		if(allow_scheduling_yn==null )
			allow_scheduling_yn="";
		else
			allow_scheduling_yn = allow_scheduling_yn.trim();
		if(ft_work_hours==null )
			ft_work_hours="";
			else
			ft_work_hours = ft_work_hours.trim();
		if(eff_status==null )
			eff_status="";
		else
			eff_status = eff_status.trim();
		if(eff_status.equals("B"))
		 eff_status="%";
		 
		//Common parameters.
			
		HashMap sqlMap = new HashMap();
		//include all the common parameters.
		String SelectSql="SELECT GRADE_CODE,GRADE_DESC,GRADE_LEVEL,ALLOW_SCHEDULING_YN,FT_WORK_HOURS,EFF_STATUS FROM RS_GRADE_LANG_VW WHERE GRADE_CODE LIKE UPPER(?)AND UPPER(GRADE_DESC) LIKE UPPER(?) AND GRADE_LEVEL LIKE UPPER(?) AND ALLOW_SCHEDULING_YN LIKE UPPER(?) AND FT_WORK_HOURS LIKE (?) AND EFF_STATUS LIKE UPPER(?) and language_id like ? ";

		sqlMap.put( "sqlData",SelectSql);
		//The fields are going to be display, ,GRADE_EXPL_TEXT, , ,, , 
		ArrayList displayFields = new ArrayList();
		displayFields.add("GRADE_CODE" );
		displayFields.add("GRADE_DESC");
		displayFields.add("GRADE_LEVEL");
		displayFields.add("ALLOW_SCHEDULING_YN");
		displayFields.add("FT_WORK_HOURS");
		displayFields.add("EFF_STATUS");
		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add(grade_code+"%" );
		chkFields.add(grade_desc+"%" );
		chkFields.add(grade_level+"%" );
		chkFields.add(allow_scheduling_yn+"%" );
		chkFields.add(ft_work_hours+"%" );
		chkFields.add(eff_status);
		chkFields.add(locale);
		
		// Adding function related array list into the HashMap//
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		//Calling the Result from Common Adaptor as a arraylist.//
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
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
	<th width="15%"><fmt:message key="eRS.GradeCode.label" bundle="${rs_labels}"/></th>
	<th width="30%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th width="15%"><fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
	<th width="15%"><fmt:message key="eRS.ConsiderForScheduling.label" bundle="${rs_labels}"/></th>
	<th width="15%"><fmt:message key="eRS.FTWorkHours.label" bundle="${rs_labels}"/></th>
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
		String align="";
		 records=(ArrayList) result.get( recCount );
		 asyn=(String)records.get(3);
		 enable_temp=(String)records.get(5);
	%>
	<tr onClick="Modify(this,'<%=asyn%>','<%=enable_temp%>');" >
		<%
			for(int colCount=0; colCount<6; colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
		<%}else{
			String str = (String)records.get(colCount);			
			if(colCount == 3 )
				str=str.equals("Y")?enableGif:disableGif;
				if(colCount == 5 )
				str=str.equals("E")?enableGif:disableGif;		
		%>
			<td class="<%=classvalue%>" align='<%=align%>' onclick="disableClick(event);" ><%=str%></td>
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
		out.println(CommonBean.setForm(request ,"../../eRS/jsp/GradeQueryResult.jsp", searched));
		}catch(Exception e ){
			out.println("here in catch"+e);
		}
	%>
</body>
</html>

