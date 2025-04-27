<!DOCTYPE html>

<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

16/7/2021				TFS-20598				Shazana													ML-MMOH-SCF-1845
--------------------------------------------------------------------------------------------------------------------------------------------
*/
--%>
 <%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
 
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eSS/js/CheckList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onMouseDown="CodeArrest()">
<%
	String bean_id = "checkListBean";
	String bean_name = "eSS.CheckListBean";

	CheckListBean bean = (CheckListBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String checklist_code = request.getParameter("checklist_code");
	String checklist_desc = request.getParameter("checklist_desc");
	String eff_status	= request.getParameter("eff_status");
	//String orderBy[] = request.getParameterValues("orderByCols");

	boolean searched = (request.getParameter("searched") == null) ?false:true;

	String classvalue = "";
	try{
		checklist_code = CommonBean.checkForNull(checklist_code)+"%";
		checklist_desc = CommonBean.checkForNull(checklist_desc)+"%";


		HashMap sqlMap = new HashMap();
		HashMap funcMap = new HashMap();
		ArrayList displayFields = new ArrayList();
		ArrayList chkFields = new ArrayList();
		

		sqlMap.put("sqlData", "select   checklist_code ,  checklist_desc , eff_status from  ss_checklist where    upper(checklist_code) like  upper(?) and      upper(checklist_desc) like  upper(?) and eff_status like  ? ");
		displayFields.add("CHECKLIST_CODE");
		displayFields.add("CHECKLIST_DESC");
		displayFields.add("EFF_STATUS");
		
		chkFields.add(checklist_code);
		chkFields.add(checklist_desc);
		chkFields.add(eff_status);
		//chkFields.add(locale);
		
		
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
		
				<th>CheckList Code <!--<fmt:message key="eST.KitTemplateCode.label" bundle="${st_labels}"/>--></th>
				<th>CheckList Description <!--<fmt:message key="eST.KitTemplateDescription.label" bundle="${st_labels}"/>--></th>
				<th><fmt:message key="Common.Nature.label" bundle="${mm_labels}"/></th>
				
			
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
							if(colCount == 2) 
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
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/CheckListQueryResult.jsp", searched) );   //ML-MMOH-SCF-1845
	} catch(Exception e) {
// 	out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
%>
</body>
</html>

