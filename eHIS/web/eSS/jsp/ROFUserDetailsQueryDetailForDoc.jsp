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
		String sStyle					 =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/ROFDetails.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%

	String doc_type_code				=			request.getParameter( "doc_type_code" ) ;
	String doc_no						=			request.getParameter( "doc_no" ) ;
	String rof_status					=			request.getParameter( "rof_status" ) ;
	String tray_no						=			request.getParameter( "tray_no" ) ;
	boolean searched					=			(request.getParameter("searched") == null) ?false:true;

try{
	String classvalue					=			"";
	String facility_id					=			"";
	facility_id							=			(String) session.getAttribute("facility_id");
	
	doc_type_code						=			CommonBean.checkForNull( doc_type_code );
	doc_no								=			CommonBean.checkForNull( doc_no );
	rof_status							=			CommonBean.checkForNull( rof_status );
	tray_no								=			CommonBean.checkForNull( tray_no );


	

	

	//Common parameters.
	HashMap sqlMap						=			new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_ROF_USER_DETAIL_TRAY_QUERY"));


	//Function Parameters
	HashMap funcMap						=			 new HashMap();

	//The fields are going to be display
	ArrayList displayFields				=			new ArrayList();

	
	displayFields.add( "tray_no"	);
	displayFields.add( "entered_by"	);
	displayFields.add( "checked_by"	);
	displayFields.add( "washed_by"	);
	displayFields.add( "packed_by_id"	);
	displayFields.add( "autoclaved_by"	);
	displayFields.add( "dispatched_by_id"	);
	displayFields.add( "ack_by"	);

		
	
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields					=			 new ArrayList();
	
	chkFields.add( facility_id );
	chkFields.add( doc_type_code );
	chkFields.add( doc_no );
	chkFields.add( rof_status );
	chkFields.add( tray_no );
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	ArrayList result					=			(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,10);
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

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.EnteredBy.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.CheckedBy.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.WashedBy.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.PackedBy.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.AutoclavedBy.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.DispatchedBy.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Ack.By.label" bundle="${ss_labels}"/></th>
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++)
		{
			records=(ArrayList) result.get( recCount );
			
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			
	%>
	
			<tr onClick="Modify(this);" >
				<td class="<%=classvalue%>"   align='right' onclick="disableClick(event);"><%=records.get(0)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align='left'><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align='left'><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align='left'><%=CommonBean.checkForNull((String)records.get(4),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align='left'><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align='left'><%=CommonBean.checkForNull((String)records.get(6),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" align='left'><%=CommonBean.checkForNull((String)records.get(7),"&nbsp;")%></td>
			</tr> 
	<%
		}
	%>
		</table>
	<%
		out.flush();
	} else{
	%>
		 <script>//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));
				//document.location.href="../../eCommon/html/blank.html";
				//parent.window.close();
		</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../eSS/jsp/ROFDetailsQueryDetailForDoc.jsp", searched) );
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
%>
</body>
</html>

