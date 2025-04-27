<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Create History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
22/04/2014	       		BRU-HIMS-CRF-398	    Sakti Sankar	   22/04/2014	     Sakti Sankar			 Newly Created
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,java.sql.*, eSS.Common.*, eSS.* , eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>   
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
		<script language="Javascript" src="../../eSS/js/ReturnStatus.js"> </script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()">
<%

//	java.util.HashMap defaultParameter			=		null;
	String bean_id								=		"returnStatusBean";
	String bean_name							=		"eSS.ReturnStatusBean";

//	RequestStatusBean bean						=		(RequestStatusBean) mh.getBeanObject( bean_id, request,  bean_name);

	ReturnStatusBean bean						=		(ReturnStatusBean) getBeanObject( bean_id, bean_name, request );	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(locale);
	String login_user=bean.getLoginById() ;

	String from_date							=		request.getParameter( "from_date" ) ;
	String to_date								=		request.getParameter( "to_date" ) ;
	String entry_completed_yn					=		request.getParameter( "entry_completed_yn" ) ;
	String finalized_yn							=		request.getParameter( "finalized_yn" ) ;

	String req_by_store							=		request.getParameter( "req_by_store" ) ;
	String req_on_store							=		request.getParameter( "req_on_store" ) ;
	String doc_no								=		request.getParameter( "doc_no" ) ;
	boolean searched							=		(request.getParameter("searched") == null) ?false:true;
	boolean AckForReqyn				            =		false;
	AckForReqyn						            =		bean.getAckReqd();

try{
	String classvalue							=		"";
	String facility_id							=		"";
	facility_id									=		(String) session.getAttribute("facility_id");
	
	from_date									=		CommonBean.checkForNull( from_date );
	if(!(locale.equals("en")))
		{
						 from_date				=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
						 to_date				=	com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");
					 
					 
		}
	to_date										=		CommonBean.checkForNull( to_date );
	entry_completed_yn							=		CommonBean.checkForNull( entry_completed_yn,"%" );
	finalized_yn								=		CommonBean.checkForNull( finalized_yn,"%" );
	
	req_by_store								=		CommonBean.checkForNull( req_by_store,"%");
	req_on_store								=		CommonBean.checkForNull( req_on_store,"%");
	doc_no										=		CommonBean.checkForNull( doc_no,"%");
	String l_finalize_yn 						= 		"";
	String field_name_dynamic 					= 		"";
	
	//Dynamically field_name passed based on Acknowledgement Applicable
	if(AckForReqyn){
		field_name_dynamic = "sr.PROCESS_FOR_ACKNOWLEDGE";
	}else{
		field_name_dynamic = "sr.FINALIZED_YN";
	}//Added ends
	
	//Common parameters.
	HashMap sqlMap								=		new HashMap();


	sqlMap.put( "sqlData","SELECT sr.facility_id, sr.doc_type_code, TO_CHAR (sr.doc_no) doc_no, TO_CHAR (doc_date, 'dd/mm/yyyy') doc_date, sr.doc_ref,  ms.short_desc req_by_store_desc, ms1.short_desc req_on_store_desc, sr.entry_completed_yn, sy.short_desc doc_type_desc,  SS_Ret_Ack_Status (sr.facility_id, sr.doc_type_code, sr.doc_no) Ack_status, TO_CHAR (sr.added_date, 'DD/MM/YYYY HH24:MI:SS') added_date, (SELECT apn.appl_user_name  FROM sm_appl_user_lang_vw apn WHERE sr.added_by_id = apn.appl_user_id AND ms.language_id = apn.language_id) appl_user_name,sr.finalized_yn,sr.PROCESS_FOR_ACKNOWLEDGE  FROM ss_return_hdr sr, mm_store_lang_vw ms, mm_store_lang_vw ms1,sy_doc_type_master_lang_vw sy,ss_user_access_for_store ss1,ss_user_access_for_store ss2 WHERE sy.doc_type_code = sr.doc_type_code AND sr.facility_id = (?)  AND sr.fr_store_code = ms.store_code AND ss1.store_code = sr.fr_store_code AND ss2.store_code = sr.to_store_code AND ss1.rtg_allowed_yn = 'Y'  AND ss1.user_id = (?)  AND ss2.user_id = (?)  AND sr.to_store_code = ms1.store_code AND TO_DATE (TO_CHAR (doc_date, 'dd/mm/yyyy'), 'dd/mm/yyyy')  BETWEEN TO_DATE (NVL ((?), '01/01/1472'), 'dd/mm/yyyy') AND TO_DATE (NVL ((?), '31/12/5000'), 'dd/mm/yyyy') AND sr.entry_completed_yn LIKE (?) AND " +field_name_dynamic+" LIKE (?) AND sr.doc_no like (?) AND sr.fr_store_code LIKE (?) AND sr.to_store_code LIKE (?) AND ms.language_id = sy.language_id  AND ms.language_id = ? AND ms1.language_id = ? ");
	
	 
	

	//Function Parameters
	HashMap funcMap								=		new HashMap();

	//The fields are going to be display
	ArrayList displayFields						=		new ArrayList();

	displayFields.add( "doc_type_desc"	);
	displayFields.add( "doc_no"	);
	displayFields.add( "doc_date" );
	displayFields.add( "doc_ref" );
	displayFields.add( "req_by_store_desc" );
	displayFields.add( "req_on_store_desc" );
	displayFields.add( "entry_completed_yn" );
	
	
	displayFields.add( "Ack_status"	); 
	displayFields.add("APPL_USER_NAME"); 
	displayFields.add("ADDED_DATE"); 
	displayFields.add( "doc_type_code"	);
	displayFields.add( "finalized_yn" );
	displayFields.add( "PROCESS_FOR_ACKNOWLEDGE" );

  
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields							=		new ArrayList();
	
	chkFields.add( facility_id );
	chkFields.add( login_user);
	chkFields.add( login_user);
	chkFields.add( from_date );
	chkFields.add( to_date );
	chkFields.add( entry_completed_yn );
	chkFields.add( finalized_yn );
	chkFields.add( doc_no);
	chkFields.add( req_by_store);	
	chkFields.add( req_on_store);
	chkFields.add( locale);
	chkFields.add( locale);

	System.out.println("chkFields"+chkFields);
	System.out.println("sqlMap"+sqlMap);
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	
	 
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,14);
	System.out.println("result"+result);
	
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
		<th><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.ReturnFrom.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.ReturnTo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Entered.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Finalize.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.ReturnedBy.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.ReturnDate.label" bundle="${ss_labels}"/></th>
		<% if(AckForReqyn){%>
		<th><fmt:message key="eSS.AcknowledgementStatus.label" bundle="${ss_labels}"/></th>
		<%}%>
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
//				String link_columns = "1";
	%>      
	        <% if(AckForReqyn){
	        l_finalize_yn = (String)records.get(12); %>
			<tr onClick="changeRowColor(this,11);Modify(this,'<%=l_finalize_yn%>');" name="<%=i%>">
			<%}else{
			l_finalize_yn = (String)records.get(11);%>
			<tr onClick="changeRowColor(this,10);Modify(this,'<%=l_finalize_yn%>');" name="<%=i%>">
			<%}
			if(l_finalize_yn.equals("Y")) {%>
						
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> <font class='HYPERLINK'><%=records.get(0)%></font></td>
				<%}else{%>
				<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=records.get(0)%></td>
				<%} %>
				<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=records.get(1)%></td>
				<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=doc_date_disp%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%></td>
			<%	out.println("<td class='"+classvalue+"' align='center' onclick='disableClick(event);'>");
					if( ((String)records.get(6)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img></td>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img></td>");
					
					out.println("<td class='"+classvalue+"' align='center' onclick='disableClick(event);'>");
					if( l_finalize_yn.equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img></td>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img></td>");
				
					
			%>	
				
				<td class="<%=classvalue%>" onclick='disableClick(event);'><%=records.get(8)%></td>
				
				<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(9),"DMYHMS","en",locale)%></td>
				<!-- ends -->
			
				<% if(AckForReqyn) {
				       if(CommonBean.checkForNull((String)records.get(11),"").equals("Y") || CommonBean.checkForNull((String)records.get(12),"").equals("Y")) {%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(7),"")%>&nbsp;</td>
					<%}else{%>
					<td class="<%=classvalue%>" onclick="disableClick(event);">&nbsp;</td>
				       <%}}else {%>
							<td class="NODISPLAY"><input type="hidden">&nbsp;</td>
						<%}%>
						<td class="NODISPLAY"><%=CommonBean.checkForNull((String)records.get(10),"")%>&nbsp;</td>
				
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
	out.println(CommonBean.setForm ( request ,"../../eSS/jsp/ReturnStatusQueryResult.jsp", searched) );
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
%>
</body>
</html>

