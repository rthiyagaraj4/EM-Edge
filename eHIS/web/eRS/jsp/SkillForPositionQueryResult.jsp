<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eRS.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eRS.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations end --%>
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
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

	try{
		String position_code		= request.getParameter("position_code")==null?"":request.getParameter("position_code");
		String position_desc		= request.getParameter("position_desc")==null?"":request.getParameter("position_desc");
		String role_type_desc		= request.getParameter("role_type")==null?"":request.getParameter("role_type");
		String staff_type_desc		= request.getParameter("staff_type_desc")==null?"":request.getParameter("staff_type_desc");
		String skill_code	= request.getParameter("skill_code")==null?"":request.getParameter("skill_code");
		String skill_desc	= request.getParameter("skill_desc")==null?"":request.getParameter("skill_desc");
		boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	

		position_code = position_code.trim();
		position_desc = position_desc.trim();
		role_type_desc = role_type_desc.trim();
		staff_type_desc = staff_type_desc.trim();
		skill_code = skill_code.trim();
		skill_desc = skill_desc.trim();

		//Common parameters.
		HashMap sqlMap = new HashMap();

		//include all the common parameters.
		sqlMap.put( "sqlData","SELECT 	A.POSITION_CODE POSITION_CODE, B.POSITION_DESC POSITION_DESC, DECODE(B.ROLE_TYPE,'P','Practitioner','O','Other Staff') ROLE_TYPE_DESC, B.STAFF_TYPE_DESC STAFF_TYPE_DESC, A.SKILL_CODE SKILL_CODE, C.SKILL_DESC SKILL_DESC, A.MANDATORY_YN MANDATORY_YN FROM 	RS_SKILL_FOR_POSITION A, AM_POSITION_VW B, RS_SKILL C WHERE B.POSITION_CODE = A.POSITION_CODE AND C.SKILL_CODE = A.SKILL_CODE AND B.POSITION_CODE LIKE UPPER(?) AND upper(B.POSITION_DESC) LIKE UPPER(?) AND B.ROLE_TYPE LIKE UPPER(?) AND C.SKILL_CODE LIKE UPPER(?) AND upper(C.SKILL_DESC) LIKE UPPER(?) AND A.EFF_STATUS='E'");
		
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		
		displayFields.add("position_code");
		displayFields.add("position_desc");
		displayFields.add("role_type_desc");
		displayFields.add("staff_type_desc");
		displayFields.add("skill_code");
		displayFields.add("skill_desc");
		displayFields.add("mandatory_yn");
		
		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();

		chkFields.add( position_code+"%" );
		chkFields.add( position_desc+"%" );
		chkFields.add( role_type_desc+"%" );
		chkFields.add( skill_code+"%" );
		chkFields.add( skill_desc+"%" );

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
			<th width="7%"><fmt:message key="eRS.PositionCode.label" bundle="${rs_labels}"/></th>
			<th width="15%"><fmt:message key="eRS.PositionDescription.label" bundle="${rs_labels}"/></th>
			<th width="13%"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></th>
			<th width="10%"><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></th>
			<th width="10%"><fmt:message key="eRS.SkillCode.label" bundle="${rs_labels}"/></th>
			<th width="15%"><fmt:message key="eRS.SkillDescription.label" bundle="${rs_labels}"/></th>
			<th width="5%"><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></th>
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
			for(int colCount=0; colCount<7; colCount++){		
				String str = (String)records.get(colCount);
				if(colCount ==6 ){
						if(str.equalsIgnoreCase("Y")){
							str=enableGif;
						}else
						  str=disableGif;
				}
				if(str==null){
%>	
					<td class="<%=classvalue%>">&nbsp;</td>
<%
				}
				else{
%>
					<td class="<%=classvalue%>"><%=str%></td>
<%
				}
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
		out.println(CommonBean.setForm(request ,"../../eRS/jsp/SkillForPositionQueryResult.jsp", searched));
	}catch(Exception e ){
		e.printStackTrace() ;
		throw e ;
	}
%>
</body>
</html>

