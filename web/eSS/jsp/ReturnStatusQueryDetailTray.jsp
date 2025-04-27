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
<%@	page import="java.util.*, eSS.Common.*, eSS.*,java.util.*,java.sql.* " contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@	include file="../../eCommon/jsp/CommonBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
	<head>
		<title>Return Details - Tray Level</title>
		
<% 
		request.setCharacterEncoding("UTF-8");
		String sStyle				 =		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="Javascript" src="../../eSS/js/ReturnStatus.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload='' onclick='hidePopup();'>
<%

	String doc_type_code			=		request.getParameter("doc_type_code") ;
	doc_type_code					=		doc_type_code.trim();
	String doc_no					=		request.getParameter("doc_no") ;
	boolean searched				=		(request.getParameter("searched") == null) ?false:true;
	//String facility_id				=		(String) session.getAttribute("facility_id");
	String facility_id				=		request.getParameter("facility_id") ;
	facility_id						= 		facility_id.trim();
	String group_desc				=		request.getParameter("group_desc") ;
	String group_code				=		request.getParameter("group_code") ;
		
	group_desc  					= 		java.net.URLEncoder.encode(group_desc,"UTF-8");
	String spcfn_img_display	    =		"display:inline";
	String remarks_desc				=		"";
	
		
try{
	ReturnStatusBean bean			=		(ReturnStatusBean)getBeanObject( "returnStatusBean",  "eSS.ReturnStatusBean" ,request) ;

	String classvalue				=		"";

	
	//Common parameters.

	HashMap sqlMap					=		new HashMap();

	//include all the common parameters.

	sqlMap.put( "sqlData", SsRepository.getSsKeyValue( "SQL_SS_RETURN_STATUS_TRAY_DETAIL"));
	
	//sqlMap.put( "sqlData", "SELECT a.tray_no, a.patient_id,bin.short_desc bin_desc, a.remarks, a.expired_yn, a.used_yn, a.sterilize_yn, a.wash_yn, a.pack_yn, a.contaminated_yn, a.charge_consumable_yn,(SELECT COUNT (*) FROM ss_return_discrepancy_dtl c WHERE c.doc_no = a.doc_no AND c.doc_type_code = a.doc_type_code  AND c.facility_id = a.facility_id AND c.group_code = a.return_group_code AND c.tray_no = a.tray_no) count_ret_disc,(SELECT COUNT (*)  FROM ss_discrepancy_dtl d WHERE d.group_code = a.return_group_code AND d.tray_no = a.tray_no AND d.org_doc_no IS NULL) count_tray_disc FROM ss_return_dtl a,ss_return_hdr b,mm_bin_location bin WHERE b.to_store_code=bin.store_code and a.bin_location_code = bin.bin_location_code and a.facility_id = b.facility_id and a.doc_type_code = b.doc_type_code and a.doc_no = b.doc_no  and a.facility_id = ? AND a.doc_type_code = ? AND a.doc_no = ? and a.return_group_code=? order by a.tray_no");


	//Function Parameters

	HashMap funcMap					=		new HashMap();

	//The fields are going to be display

	ArrayList displayFields			=		new ArrayList();

	displayFields.add( "tray_no"	);
	displayFields.add( "patient_id"	);
	displayFields.add( "bin_desc" );
	displayFields.add( "remarks" );
	displayFields.add( "expired_yn" );
	displayFields.add( "used_yn" );
	displayFields.add( "sterilize_yn"	);
	displayFields.add( "wash_yn"	);
	displayFields.add( "pack_yn" );
	displayFields.add( "contaminated_yn" );
	displayFields.add( "charge_consumable_yn" );
	displayFields.add( "count_ret_disc" );
	displayFields.add( "count_tray_disc" );
	displayFields.add( "remarks_desc" );
	
	
	
	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields				=		new ArrayList(); 
	
	chkFields.add(facility_id);
	chkFields.add(doc_type_code);
	chkFields.add(doc_no);
	chkFields.add(group_code);
	
		
	// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields",chkFields);


	ArrayList result				=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,14);
	
	//out.println((String) result.get(0));
	if( (result.size()>0) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 80"></div>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		 <td width="20%" align="left" onmouseover="changeCursor(this);"   onClick="details('<%=group_code%>','<%=group_desc%>');" ><fmt:message key="Common.Group.label" bundle="${common_labels}"/>:<font class="HYPERLINK"><%=java.net.URLDecoder.decode(group_desc,"UTF-8")%></font></td>
		<td width="80%" align="right" class="label"  ><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/>:<b><%=doc_no%></b></td>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th ><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Reason.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Expired.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="Common.used.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eSS.Sterilized.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Wash.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.Contaminated.label" bundle="${ss_labels}"/></th>
		<th><fmt:message key="eSS.ChargeConsumables.label" bundle="${ss_labels}"/></th>
		<th>Discrepancy</th>

		
	
	<%
		//Retriving the records from result arraylist
		ArrayList records			=		new ArrayList();
	int i = 0;
		
		for(int recCount=2; recCount<result.size(); recCount++)
		{
			records=(ArrayList) result.get( recCount );
			i++;
			
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			 remarks_desc = CommonBean.checkForNull((String)records.get(13),"");
			//Added by Sakti against inc#49268 to display remarks description in tooltip
			if(!remarks_desc.equals("")){
					remarks_desc = remarks_desc.replaceAll(" ","%20");
					remarks_desc = java.net.URLEncoder.encode(remarks_desc,"UTF-8");
					remarks_desc = remarks_desc.replaceAll("%2520","%20");
			}
				if(remarks_desc.equals("")  ) {
					spcfn_img_display="display:none";
				}
				//Added ends
			
			
	%>
			<!--<tr onClick="Modify(this);" > -->
			   <tr>
				<td class="<%=classvalue%>" onclick="disableClick(event);">&nbsp;<%=records.get(0)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull((String)records.get(1),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%><a style='<%=spcfn_img_display%>'> <img  onmouseover="onMOver(msg,event,'<%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%>','<%=remarks_desc%>');"   onMouseout="onMOut(msg);"   src='../../eST/images/info.gif' ></img></a></td>
				<%	out.println("<td class='"+classvalue+"' align='center' onclick='disableClick(event);'>");
					if( ((String)records.get(4)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img></td>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img></td>");
					
					out.println("<td class='"+classvalue+"' align='center' onclick='disableClick(event);'>");
					if( ((String)records.get(5)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img></td>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img></td>");
					
					out.println("<td class='"+classvalue+"' align='center' onclick='disableClick(event);'>");
					if( ((String)records.get(5)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img></td>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img></td>");
					
					out.println("<td class='"+classvalue+"' align='center' onclick='disableClick(event);'>");
					if( ((String)records.get(7)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img></td>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img></td>");
					
					out.println("<td class='"+classvalue+"' align='center' onclick='disableClick(event);'>");
					if( ((String)records.get(8)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img></td>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img></td>");
					
					out.println("<td class='"+classvalue+"' align='center' onclick='disableClick(event);'>");
					if( ((String)records.get(9)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img></td>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img></td>");
					
					out.println("<td class='"+classvalue+"' align='center' onclick='disableClick(event);'>");
					if( ((String)records.get(10)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img></td>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img></td>");
				
					
			if(Integer.parseInt((String)records.get(11)) > 0 || Integer.parseInt((String)records.get(12)) > 0 ) {%>	
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showPopup('<%=i%>','<%=CommonBean.checkForNull((String)records.get(12))%>','<%=CommonBean.checkForNull((String)records.get(11))%>','<%=group_code%>','<%=CommonBean.checkForNull((String)records.get(0))%>','<%=java.net.URLDecoder.decode(group_desc,"UTF-8")%>');"><font class="HYPERLINK">Discrepancy</font></td>
				<%}else{ %>
				<td class="<%=classvalue%>">Discrepancy</td>
				<%} %>
				<div id="manage_menu" style="border: 1px solid black;width:150px"  onmouseover="over()" onMouseout="out()" onclick="showWindow('<%=doc_no%>','<%=doc_type_code%>','<%=facility_id%>','<%=CommonBean.checkForNull((String)records.get(12))%>','<%=CommonBean.checkForNull((String)records.get(11))%>');">
				<div id='tray_disc' style="background-color:#83AAB4" class="manage_menuitem"  value='T'><fmt:message key="eSS.TrayDiscrepancy.label" bundle="${ss_labels}"/></div>
				<div id='ret_disc' style="background-color:#83AAB4" class="manage_menuitem" value='R'><fmt:message key="eSS.ReturnDiscrepancy.label" bundle="${ss_labels}"/></div></div>
				


				
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
		</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../eSS/jsp/ReturnStatusQueryDetailTray.jsp", searched) );
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0185
}
%>
</body>
</html>

