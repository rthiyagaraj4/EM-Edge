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
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		String sStyle				 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/ROFDetails.js"> </script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%

	String doc_type_code			=		request.getParameter( "doc_type_code" ) ;
	String doc_no					=		request.getParameter( "doc_no" ) ;
	String rof_status				=		request.getParameter( "rof_status" ) ;
	boolean searched				=		(request.getParameter("searched") == null) ?false:true;
	
try{
	String classvalue				=		"";
	String facility_id				=		"";
	facility_id						=		(String) session.getAttribute("facility_id");
	
	doc_type_code					=		CommonBean.checkForNull( doc_type_code );
	doc_no							=		CommonBean.checkForNull( doc_no );
	rof_status						=		CommonBean.checkForNull( rof_status );

	

	
	//Common parameters.
	HashMap sqlMap					=		new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_ROF_DETAIL_DETAIL_QUERY"));


	//Function Parameters
	HashMap funcMap					=		new HashMap();

	//The fields are going to be display
	ArrayList displayFields			=		new ArrayList();

	displayFields.add( "tray_no"	);
	displayFields.add( "enter_dt"	);
	displayFields.add( "checked_dt"	);
	displayFields.add( "washed_dt"	);
	displayFields.add( "packed_dt"	);
	displayFields.add( "autoclaved_dt"	);
	displayFields.add( "dispatched_dt"	);
	displayFields.add( "ack_by"	);
	
	
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields				=		new ArrayList();
	
	chkFields.add( facility_id );
	chkFields.add( doc_type_code );
	chkFields.add( doc_no );
	chkFields.add( rof_status );

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,10);
	
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
		<th><fmt:message key="eSS.EnteredDt.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.CheckedDt.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.WashedDt.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.PackedDt.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.AutoclavedDt.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.DispatchedDt.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Ack.Dt.label" bundle="${ss_labels}"/></th>
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++)
		{
			records=(ArrayList) result.get( recCount );
			
			String ent_date_disp  = com.ehis.util.DateUtils.convertDate((String)records.get(1),"DMY","en",locale);
			String chk_date_disp  =  com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale);
			String wash_date_disp = com.ehis.util.DateUtils.convertDate((String)records.get(3),"DMY","en",locale);
			String pack_date_disp = com.ehis.util.DateUtils.convertDate((String)records.get(4),"DMY","en",locale);
			String auto_date_disp =  com.ehis.util.DateUtils.convertDate((String)records.get(5),"DMY","en",locale);
			String disp_date_disp =  com.ehis.util.DateUtils.convertDate((String)records.get(6),"DMY","en",locale);
			String ack_date_disp  =  com.ehis.util.DateUtils.convertDate((String)records.get(7),"DMY","en",locale);
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			
	%>
			<tr onClick="Modify(this);" >
				<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=records.get(0)%></td>
				<td class="<%=classvalue%>"   onclick="disableClick(event);"><%=CommonBean.checkForNull(ent_date_disp,"&nbsp;")%></td>
				<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=CommonBean.checkForNull(chk_date_disp,"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull(wash_date_disp,"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull(pack_date_disp,"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull(auto_date_disp,"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull(disp_date_disp,"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull(ack_date_disp,"&nbsp;")%></td>
				
			</tr> 
	<%
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
				parent.window.close();
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

