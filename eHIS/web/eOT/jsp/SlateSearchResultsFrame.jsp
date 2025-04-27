<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--NOTE: Due to Amazon Changes SlateResultsHeader.jsp frame giving as  0%. That Header Line displaying directly respective jsps. i.e SlateSchSearchResults.jsp and SlateUnSchSearchResults.jsp
 -->
<%@page  import="eOT.*, eOT.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
    <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>
 <%
	String params		= request.getQueryString() ;
	String theatre_date	= request.getParameter("theatre_date");
	String speciality	= request.getParameter("speciality");
	String theatre_from	= request.getParameter("theatre_from");
	String theatre_to	= request.getParameter("theatre_to");
	String surgeon		= request.getParameter("surgeon");
	String view_by		= request.getParameter("view_by");
	String status		= request.getParameter("status");
	String theatre_date_from = request.getParameter("theatre_date_from");
	String elec_emer		= request.getParameter("elec_emer");
	String doc_status		= request.getParameter("doc_status");
	String scan_vals		= request.getParameter("scan_vals");
	String theatre_type		= request.getParameter("theatre_type");
	String patient_id		= request.getParameter("patient_id");//MO-CRF-20082
	String bean_id		= "SlateBean";
	String bean_name	= "eOT.SlateBean";
	SlateBean bean	= (SlateBean)mh.getBeanObject( bean_id, request, bean_name );

	bean.clear();
	boolean ot_sch_dtls_flag = false;
	
	System.out.println(" ******************* view_by : "+view_by+" theatre_date : "+theatre_date+" theatre_from : "+theatre_from+
			" theatre_to : "+theatre_to+" speciality : "+speciality+" surgeon : "+surgeon+" status : "+status+
			" theatre_date_from : "+theatre_date_from+" elec_emer : "+elec_emer+" doc_status : "+doc_status+" scan_vals : "+scan_vals+
			" theatre_type : "+theatre_type+" patient_id : "+patient_id);
	if(view_by.equals("S") || view_by.equals("A"))
		//ot_sch_dtls_flag = bean.loadScheduledCases(theatre_date,theatre_from,theatre_to,speciality,surgeon,status,);
		ot_sch_dtls_flag = bean.loadScheduledCases(theatre_date,theatre_from,theatre_to,speciality,surgeon,status,theatre_date_from,elec_emer,doc_status,scan_vals,theatre_type,patient_id);//MO-CRF-20082
	boolean ot_unsch_dtls_flag = false;
	if(view_by.equals("U") || view_by.equals("A"))
			ot_unsch_dtls_flag = bean.loadUnScheduledCases(theatre_date,theatre_from,theatre_to,speciality,surgeon,status,theatre_date_from,elec_emer,doc_status,scan_vals,theatre_type,patient_id);//MO-CRF-20082
	
	System.out.println(" ******************* ot_sch_dtls_flag : "+ot_sch_dtls_flag +" ot_unsch_dtls_flag : "+ot_unsch_dtls_flag);
%>

	<% 	if(view_by.equals("S") || view_by.equals("U")){
	%>
		<frameset id="SlateSearchResultsFrame" rows="0%,*,2%">
	<%
		}else if(view_by.equals("A") && ot_sch_dtls_flag==true && ot_unsch_dtls_flag==true){
	%>
		<frameset id="SlateSearchResultsFrame" rows="0%,40%,31%,2%">
	<%
		}else if(view_by.equals("A")){	// only one of the schedule/unschedule cases is true
	%>
		<frameset id="SlateSearchResultsFrame" rows="0%,*,2%">
	<%
		}
		if((view_by.equals("S") || view_by.equals("A")) && ot_sch_dtls_flag==true){
	%>
			<frame name="f_header_frame" scrolling="no" noresize src="../../eOT/jsp/SlateResultsHeader.jsp?<%=params+"&sch_unsch_flag=SCH"%>" > 
			<%
				if(ot_sch_dtls_flag==true){ 
			%>
					<frame name="f_sch_cases_frame" frameborder="0" scrolling="yes" noresize src="../../eOT/jsp/SlateSchSearchResults.jsp?<%=params%>" >
			<%
				}
		}
		if(view_by.equals("U") && ot_unsch_dtls_flag==true){
		%>
				<frame name="f_header_frame" scrolling="no" noresize src="../../eOT/jsp/SlateResultsHeader.jsp?<%=params+"&sch_unsch_flag=UNSCH"%>" > 

				<frame name="f_unsch_cases_frame" frameborder="0" scrolling="yes" noresize src="../../eOT/jsp/SlateUnSchSearchResults.jsp?<%=params%>">

		<%
	
		}else if(view_by.equals("A") && ot_unsch_dtls_flag==true){
			if(view_by.equals("A") && ot_sch_dtls_flag==true){

		%>         <frameset id="SlateSearchResultsFrame_2" rows="0%,*">
						<frame name="f_header_frame" scrolling="no" noresize src="../../eOT/jsp/SlateResultsHeader.jsp?<%=params+"&sch_unsch_flag=UNSCH"%>" > 

						<frame name="f_unsch_cases_frame" frameborder="0" scrolling="yes" noresize src="../../eOT/jsp/SlateUnSchSearchResults.jsp?<%=params%>">
					</frameset>
		<%
			}else{
		%>          
					<frame name="f_header_frame" scrolling="no" noresize src="../../eOT/jsp/SlateResultsHeader.jsp?<%=params+"&sch_unsch_flag=UNSCH"%>" > 

					<frame name="f_unsch_cases_frame" frameborder="0" scrolling="yes" noresize src="../../eOT/jsp/SlateUnSchSearchResults.jsp?<%=params%>">
		<%
						}
		}if(ot_sch_dtls_flag==true || ot_unsch_dtls_flag==true){
		//IN055102 start 
			params=params+"&ot_sch_dtls_flag="+ot_sch_dtls_flag+"&ot_unsch_dtls_flag="+ot_unsch_dtls_flag;
		//IN055102 end
			%>
				<frame name="f_colours_frame" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/SlateOrdersColorInd.jsp?<%=params%>">
			<%
		}else{
		%>
			<frame name="f_header_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" > 
		<%
			}
		%>
	</frameset>
</html>
	<%
		if(ot_sch_dtls_flag==false && ot_unsch_dtls_flag==false){
	%>
		<script language="javascript">
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			//enableSearchCriteria();
		</script>
	<%
		}
	%>
