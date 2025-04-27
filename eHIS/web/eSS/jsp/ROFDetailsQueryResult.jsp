<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/ROFDetails.js"> </script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()">
<%

		String from_date				=		request.getParameter("from_date");
		String to_date					=		request.getParameter("to_date");
		String req_by_store				=		request.getParameter("req_by_store");
		String doc_type_code			=		request.getParameter("doc_type_code");
		String doc_ref					=		request.getParameter("doc_ref");
		String process_stage_code		=		request.getParameter("rof_status");

		boolean searched				=		(request.getParameter("searched") == null) ?false:true;

try{
		String classvalue				=		"";
		String facility_id				=		"";
		facility_id						=		(String) session.getAttribute("facility_id");
		
		from_date						=		CommonBean.checkForNull(from_date);
		to_date							=		CommonBean.checkForNull(to_date);
		if(!(locale.equals("en")))
		{
						 from_date		=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
						 to_date		=	com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");
					 
					 
		}
		req_by_store					=		CommonBean.checkForNull(req_by_store,"%");
		doc_type_code					=		CommonBean.checkForNull(doc_type_code,"%");
		doc_ref							=		CommonBean.checkForNull(doc_ref,"%");
		process_stage_code				=		CommonBean.checkForNull(process_stage_code,"%");


	
	//Common parameters.
		HashMap sqlMap					=		new HashMap();

	//include all the common parameters.
		sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_ROF_DETAIL_HDR_QUERY"));  	

	//Function Parameters
		HashMap funcMap					=		new HashMap();

	//The fields are going to be display
		ArrayList displayFields			=		new ArrayList();
	
		displayFields.add( "doc_type_desc"	);
		displayFields.add( "doc_no"	);
		displayFields.add( "doc_date" );
		displayFields.add( "store_desc" );
		displayFields.add( "group_desc" );
		displayFields.add( "tray_no" );
		displayFields.add( "process_stage_desc" );
		displayFields.add( "rof_status" );
		displayFields.add( "doc_type_code" );
		
	

	//The fields are going to be in where condition * should match with the query
		ArrayList chkFields				=		new ArrayList();
	
		chkFields.add(facility_id);
		chkFields.add(from_date);
		chkFields.add(to_date);
		chkFields.add(req_by_store);	
		chkFields.add(doc_type_code);
		chkFields.add(doc_ref);
		chkFields.add(process_stage_code);
		chkFields.add(locale);
	
	// Adding function related array list into the HashMap

		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

	ArrayList result	=	(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,14);
	//out.println((String) result.get(0));
	if( (result.size()>0) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
		<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSS.Tray.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		int i=1;
		for(int recCount=2; recCount<result.size(); recCount++)
		{
			records=(ArrayList) result.get( recCount );
			String doc_date_disp = (String)records.get(2);
				if(doc_date_disp==null)doc_date_disp="";
				  if(!(locale.equals("en")))
				{
					 doc_date_disp=com.ehis.util.DateUtils.convertDate(doc_date_disp,"DMY","en",locale);
					 if(doc_date_disp==null)doc_date_disp="";
					 
				}
			if ( recCount % 2 == 0 )

				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
//			String link_columns = "1";
	%>
			<tr onClick="changeRowColor(this,7);Modify('<%=records.get(8)%>','<%=records.get(7)%>',this);" id="<%=i%>">
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=records.get(0)%></font></td>
				<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull(doc_date_disp,"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(4),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(6),"&nbsp;")%></td>
		
			</tr> 
	<%
				i++;
		}
	%>
		</table>
	<%
		out.flush();
	} else{
	%>
		 <script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			document.location.href="../../eCommon/html/blank.html";
		</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../eSS/jsp/ROFDetailsQueryResult.jsp", searched) );
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
%>
</body>
</html>

