<!DOCTYPE html>
 <%@ page import ="ePH.*, ePH.Common.* , eCommon.Common.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
  <%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			=			(String)session.getAttribute("LOCALE");
		String sStyle			=			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/ADRCertainity.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>

<!-- <body onMouseDown="CodeArrest()"> -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	String bean_id						=		"ADRCertainityBean";
	String bean_name					=		"ePH.ADRCertainityBean";
	ADRCertainityBean bean				=		(ADRCertainityBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	boolean searched					=		(request.getParameter("searched") == null) ?false:true;
	String classvalue					=		"";

	try{
		
		HashMap sqlMap					=			 new HashMap();
		HashMap funcMap					=			 new HashMap();
		ArrayList displayFields			=			 new ArrayList();
		ArrayList chkFields				=			 new ArrayList();

		
		sqlMap.put("sqlData",  PhRepository.getPhKeyValue("SQL_CERTAINITY_QUERY_RESULT"));
		
		
		displayFields.add("CERTAINITY_CODE");
		displayFields.add("CERTAINITY_SYS_DESC");
		displayFields.add("CERTAINITY_USER_DESC");
		displayFields.add("REL_SCORE_FROM");
		displayFields.add("REL_SCORE_TO");

		chkFields.add(locale);	
		
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align=center>
		
				<th><fmt:message key="ePH.CertainityCode.label" bundle="${ph_labels}"/> </th>
				<th> <fmt:message key="Common.SystemDescription.label" bundle="${common_labels}"/> </th>
				<th><fmt:message key="Common.UserDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="ePH.RelativeScoreFrom.label" bundle="${ph_labels}"/> </th>
				<th><fmt:message key="ePH.RelativeScoreTo.label" bundle="${ph_labels}"/> </th>
				
			<%
		
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) 
			{
				if ( recCount % 2 == 0 )
					classvalue	 =	 "QRYEVEN" ;
					
				else
					classvalue	 =	 "QRYODD" ;
			%>
			<tr onClick="Modify(this);"  >
			<%
				//String link_columns		=	 "1";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++)
				{
					if(colCount==1)
					{
						
					%>
						<td  class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK' ><%=(String)records.get( colCount )%></font></td>
					<%
					
					}else
					{
						%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<% 
							
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),""));
					%> </td>
					<%
					}
				}
				%>
			</tr>
		<%}	%>
		</table>
		<%
			out.flush();
		} else{
		%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script> 
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ADRCertainityQueryResult.jsp", searched) );
	} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

