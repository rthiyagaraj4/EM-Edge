<!DOCTYPE html>
 <%@ page import ="ePH.*, ePH.Common.* , eCommon.Common.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
  <%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			=			(String)session.getAttribute("LOCALE");
		String sStyle			=			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/ADRQuestion.js"></script>	
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<!-- <body onMouseDown="CodeArrest()"> -->
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String question_code		=	request.getParameter("question_code");
	String question_desc		=	request.getParameter("question_desc");
	String eff_status			=	request.getParameter("eff_status");


	String bean_id				=	"ADRQuestionBean";
	String bean_name			=	"ePH.ADRQuestionBean";
	ADRQuestionBean bean		=	(ADRQuestionBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//String orderBy[]			= request.getParameterValues("orderByCols");
	boolean searched			=	(request.getParameter("searched") == null) ?false:true;
	String classvalue			=	"";

	try{
		
		question_code			=	 CommonBean.checkForNull(question_code)+"%";
		question_desc			=	 CommonBean.checkForNull(question_desc)+"%";

		HashMap sqlMap			=	 new HashMap();
		HashMap funcMap			=	 new HashMap();
		ArrayList displayFields =	 new ArrayList();
		ArrayList chkFields		=	 new ArrayList();

		//String sql="Select  QUESTION_CODE,QUESTION_DESC,SEQ_NO,YES_SCORE,NO_SCORE,NOT_KNOWN_SCORE,EFF_STATUS FROM PH_ADR_QUESTION_LANG_VW WHERE UPPER(QUESTION_CODE) LIKE UPPER(?) AND UPPER(QUESTION_DESC) LIKE UPPER(?) AND UPPER(EFF_STATUS) LIKE UPPER(?) and LANGUAGE_ID like ?";
		
		//sqlMap.put("sqlData",sql);

		sqlMap.put("sqlData", PhRepository.getPhKeyValue("SQL_PH_ADR_QUESTION_QUERY_RESULT"));
		displayFields.add("QUESTION_CODE");
		displayFields.add("QUESTION_DESC");
		displayFields.add("SEQ_NO");
		displayFields.add("YES_SCORE");
		displayFields.add("NO_SCORE");
		displayFields.add("NOT_KNOWN_SCORE");
		
		displayFields.add("EFF_STATUS");

		chkFields.add(question_code);	
		chkFields.add(question_desc);	
		chkFields.add(eff_status);	
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
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  align=center>
			<tr>
		
				<th width="5%" align="center"  rowspan='2'><fmt:message key="ePH.QuestionCode.label" bundle="${ph_labels}"/></th>
				<th  width="30%" align="center"  rowspan='2' ><fmt:message key="ePH.QuestionDescription.label" bundle="${ph_labels}"/></th>
				<th  width="5%" align="center"  rowspan='2'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
				<th  width="15%" align="center" colspan='3'><fmt:message key="ePH.RelativeScoresForResponse.label" bundle="${ph_labels}"/> </th>

				<th  width="5%" align="center"  rowspan='2'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			
				
		</tr>
		<tr>
			<th  width="5%"><b><fmt:message key="Common.yes.label" bundle="${common_labels}"/></b></th>
			<th width="5%"><b><fmt:message key="Common.no.label" bundle="${common_labels}"/> </b></th>
			<th width="5%"><b><fmt:message key="Common.NotKnown.label" bundle="${common_labels}"/></b></th>
		</tr>
		
		<%
		
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) 
			{
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;

					
				else
					classvalue = "QRYODD" ;
			%>
			<tr onClick="Modify(this);" >
			<%
				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++)
				{
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					{
					%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%></font></td>
					<%
					}else
					{
						%>
						<% 
							if(colCount == 6) 
							{%>
							<td class="<%=classvalue%>" onclick="disableClick(event);" align='center' >
							<font style='display:none'><%=records.get(colCount)%></font>
							<%
								
								if( ((String)records.get( colCount )).equals("E"))
										out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
										out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else 
							{%>
								<td class='<%=classvalue%>' onclick='disableClick(event);'>
							<%	out.println((String)records.get( colCount ));
							}

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
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ADRQuestionQueryResult.jsp", searched) );
	} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

