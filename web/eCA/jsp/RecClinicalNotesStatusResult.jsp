<!DOCTYPE html>
<%/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
08/11/2016	IN060975		Raja S												MO-CRF-20114
06/05/2018	IN67872			Dinesh T		06/05/2018		Ramesh G			GHL-CRF-0497.1
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G			MO-CRF-20147.7
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ %> 
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,java.util.zip.*,java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eCA.RecordingClinicalNotes.label" bundle="${ca_labels}"/><fmt:message key="Common.status.label" bundle="${common_labels}"/><fmt:message key="Common.Result.label" bundle="${common_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<!-- ****  Modified by kishor kumar n on 06/12/2008 for crf0387 applied new css grid. **** -->
	
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
A:ACTIVE {
	COLOR: WHITE;
	TEXT-DECORATION : NONE ;
}
</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='RecClinicalNotesStatusResultForm' id='RecClinicalNotesStatusResultForm'>
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	query_notes_detail	=	"",		classValue			=	"gridData";

	String	facility_id			=	"",		accession_num		=	"";
	String	action_date_time	=	"",		clinician_name		=	"";
	String	action_type			=	"",		action_desc			=	"";
	String	prev_action_type = "";
	String	tblrow_id			=	"",		image_text			=	"";
	String	action_comment		=	"",		action_status		=	"";
	String	prev_action_comment		=	"";
	String  action_date_time_th =	"";
	String  requested_by_pract	=	"";
	String  prev_requested_by_pract	=	"";
	String  prev_clinician_name	=	"";
	String	requested_time		=	"";
	String	requested_time_th   =	"";
	String	prev_action_date_time_th   =	"";
	String privilege_type = "";
	String specialtyDesc = "";
	long	clob_length			=	0;
	int		rowCnt				=	0;
	long    comp_note_content_len	= 0; //6484
	try
	{
		con				=	ConnectionManager.getConnection(request);

		facility_id		=	(String)	session.getValue("facility_id");
		accession_num	=	checkForNull(request.getParameter("accession_num"));

		//query_notes_detail = "select distinct to_char(a.action_date_time,'dd/mm/yyyy hh24:mi:ss') s_action_date_time, b.short_name clinician_name, a.action_type,  decode(action_status,'CO',decode(a.action_type,'TR','Transcribed','PR','Performed','RV','Reviewed','SN','Signed','ER','Marked as Error','RS','Response Received'),'RQ', decode(a.action_type,'RV','Awaiting for Review','SN','Awaiting for Sign','RS','Response Received') ) action_desc, dbms_lob.getlength(pre_amendment_note_content) clob_len,a.action_date_time,a.action_comment from ca_encntr_note_audit_log a, am_practitioner b where b.practitioner_id = a.action_by_id and a.facility_id = ? and a.accession_num = ? order by a.action_date_time desc, decode(a.action_type,'PR','1','TR','2','3') desc ";
		//query_notes_detail = "select distinct a.ADDED_DATE, to_char(a.action_date_time,'dd/mm/yyyy hh24:mi:ss') s_action_date_time, b.practitioner_name clinician_name, a.action_type,  action_status action_desc, dbms_lob.getlength(pre_amendment_note_content) clob_len,a.action_date_time,a.action_comment,d.practitioner_name requested_by_pract,to_char(REQUEST_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') requested_time, a.privilege_type, am_get_desc.AM_SPECIALITY(a.ACTION_BY_GROUP_CODE,?,2) spl_desc from ca_encntr_note_audit_log a, am_practitioner_lang_vw  b ,am_speciality_lang_vw c, am_practitioner_lang_vw d where b.practitioner_id(+) = a.action_by_id and c.speciality_code(+)=a.action_by_group_code and d.practitioner_id(+) = a.REQUEST_BY_ID /*and a.facility_id = ? */and a.accession_num = ?  and  b.language_id = ?  and  d.language_id(+) = ? order by nvl(a.action_date_time,a.ADDED_DATE) desc,action_status desc,action_type desc "; //a.ADDED_DATE  s_action_date_time//IN67872
		//6484 Start.
		//query_notes_detail = "select  a.ADDED_DATE, to_char(a.action_date_time,'dd/mm/yyyy hh24:mi:ss') s_action_date_time, b.practitioner_name clinician_name, a.action_type,  action_status action_desc, dbms_lob.getlength(pre_amendment_note_content) clob_len,a.action_date_time,a.action_comment,d.practitioner_name requested_by_pract,to_char(REQUEST_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') requested_time, a.privilege_type, am_get_desc.AM_SPECIALITY(a.ACTION_BY_GROUP_CODE,?,2) spl_desc from ca_encntr_note_audit_log a, am_practitioner_lang_vw  b ,am_speciality_lang_vw c, am_practitioner_lang_vw d where b.practitioner_id(+) = a.action_by_id and c.speciality_code(+)=a.action_by_group_code and d.practitioner_id(+) = a.REQUEST_BY_ID /*and a.facility_id = ? */and a.accession_num = ?  and  b.language_id = ?  and  d.language_id(+) = ? order by nvl(a.action_date_time,a.ADDED_DATE) desc,action_status desc,action_type desc "; //a.ADDED_DATE  s_action_date_time//IN67872
		query_notes_detail = "select  a.ADDED_DATE, to_char(a.action_date_time,'dd/mm/yyyy hh24:mi:ss') s_action_date_time, b.practitioner_name clinician_name, a.action_type,  action_status action_desc, dbms_lob.getlength(pre_amendment_note_content) clob_len,nvl(dbms_lob.getlength (compress_note_content),0) comp_note_content_len,a.action_date_time,a.action_comment,d.practitioner_name requested_by_pract,to_char(REQUEST_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') requested_time, a.privilege_type, am_get_desc.AM_SPECIALITY(a.ACTION_BY_GROUP_CODE,?,2) spl_desc from ca_encntr_note_audit_log a, am_practitioner_lang_vw  b ,am_speciality_lang_vw c, am_practitioner_lang_vw d where b.practitioner_id(+) = a.action_by_id and c.speciality_code(+)=a.action_by_group_code and d.practitioner_id(+) = a.REQUEST_BY_ID and a.accession_num = ?  and  b.language_id = ?  and  d.language_id(+) = ? order by nvl(a.action_date_time,a.ADDED_DATE) desc,action_status desc,action_type desc "; 
		
		//6484 End.
		pstmt				=	con.prepareStatement(query_notes_detail);

		pstmt.setString( 1,	locale		);
		//pstmt.setString( 2,	facility_id		);
		pstmt.setString( 2,	accession_num	);
		pstmt.setString( 3,	locale	);
		pstmt.setString( 4,	locale	);
		rs					=	pstmt.executeQuery();
	%>
	<table class='grid' width='100%' id='tb1'>
		<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ActionBy.label" bundle="${ca_labels}"/></td>
		<td class='COLUMNHEADERCENTER'><fmt:message key="Common.ActionDescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER'><fmt:message key="Common.ActionRemarks.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.PreImage.label" bundle="${ca_labels}"/></td>
	<%
		while(rs.next())
		{
			
			tblrow_id		=	"tblrow_id"+(rowCnt);

			rowCnt++;

			/*if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";*/

			action_date_time	=	rs.getString("s_action_date_time")==null?"":rs.getString("s_action_date_time");

			if(action_date_time.equals(""))
			{
				action_date_time	="&nbsp;";
				action_date_time_th	= "&nbsp;";
			}
			else
				action_date_time_th	=	com.ehis.util.DateUtils.convertDate(action_date_time,"DMYHMS","en",locale);

			clinician_name		=	rs.getString("clinician_name")==null?"":rs.getString("clinician_name");
			action_type			=	rs.getString("action_type")==null?"":rs.getString("action_type");
			//action_desc		=	rs.getString("action_desc")==null?"":rs.getString("action_desc");
			action_status		=	rs.getString("action_desc")==null?"":rs.getString("action_desc");
			action_comment		=	rs.getString("action_comment")==null?"&nbsp;":rs.getString("action_comment");
			clob_length			=	rs.getLong("clob_len");
			comp_note_content_len = rs.getLong("comp_note_content_len"); //6484
			requested_by_pract	=	rs.getString("requested_by_pract")==null?"":rs.getString("requested_by_pract");
			requested_time		=	rs.getString("requested_time")==null?"":rs.getString("requested_time");
			privilege_type		=	rs.getString("privilege_type")==null?"":rs.getString("privilege_type");
			specialtyDesc		=	rs.getString("spl_desc")==null?"":rs.getString("spl_desc");

			//if( ( action_type.equals("RV")) && ( clob_length >0 ) ) //Commented for IN060975
			//6484 Start.
			//if( ( action_type.equals("RV") || action_type.equals("SN") || action_type.equals("PR")) && ( clob_length >0 )) //Updated for IN060975
			if( ( action_type.equals("RV") || action_type.equals("SN") || action_type.equals("PR")) && (( clob_length >0 ) || comp_note_content_len>0 )) 
			//6484 end.
			{
				image_text = "<img src='../../eCA/images/flow_text.gif' onClick=\"showNoteStatusDetails('"+accession_num+"','"+action_date_time+"','"+action_type+"',"+tblrow_id+");\" align='center' style='cursor:pointer'></img>";
			}
			else
			{
				image_text = "&nbsp;";
			}

			if(prev_action_type.equals("RS") && action_type.equals("FS"))
			{
				
				
				//prev_action_date_time_th
				%>
				<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>' width='18%' id='mydate'><%=action_date_time_th%></td>
				<td class='<%=classValue%>' width='16%'><%=prev_requested_by_pract%></td>
				<td class='<%=classValue%>'width='16%'><fmt:message key="eCA.respSentTo.label" bundle="${ca_labels}"/> - <%=prev_clinician_name%></td>
				<td class='<%=classValue%>'><%=prev_action_comment%></td>
				<td class='<%=classValue%>' align='center' width='8%'>&nbsp;</td>
				</tr>
			<%				
			}
				if(prev_action_type.equals("FS") && action_type.equals("SN"))
				{
				%>
				<script> 
					
				try{	//document.getElementById("mydate").innerText='<%=prev_action_date_time_th%>';
				}
				catch(e){}
				</script>
				<%
				}


			if(action_status.equals("CO"))
			{
				if(action_type.equals("TR"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
				else if(action_type.equals("PR"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Recorded.label","ca_labels");
				else if(action_type.equals("RV"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
				else if(action_type.equals("SN"))
				{
					if(privilege_type.equals("1"))
						action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels") + " - " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
					if(privilege_type.equals("2"))
						action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels") + " - " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.forwardedForAuth.label","ca_labels");
					else
						action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels");
				}
				else if(action_type.equals("ER"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels");
				else if(action_type.equals("RS"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Response.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
				else if(action_type.equals("FS"))
					//action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+" "+ specialtyDesc+" - "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
				else if(action_type.equals("SP"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+"-"+ requested_by_pract ;

				else if(action_type.equals("SS"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+" "+ specialtyDesc;			

             /* if(!(action_type.equals("SN")))
				{
			       action_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels")+ " - " + action_desc;
				}*/			
			}
			else if(action_status.equals("RQ"))
			{
				if(action_type.equals("RV"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AwaitingReview.label","ca_labels");
				else if(action_type.equals("SN"))
				{
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AwaitingSign.label","ca_labels");
				}
				else if(action_type.equals("RS"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Response.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.received.label","common_labels");

				else if(action_type.equals("FS"))
					//action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
					//action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+" "+ specialtyDesc;

					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AwaitingReview.label","ca_labels")+" "+ specialtyDesc;								
			}			
			else if(action_status.equals("RJ"))//IN67872, starts
			{
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
			}//IN67872, ends


			if(action_date_time==null)	image_text	=	"&nbsp;";
		%>	
			<tr id='<%=tblrow_id%>'>
				<%if((action_type.equals("RV")||action_type.equals("FS")||action_type.equals("SN"))&&action_status.equals("RQ")){%>
				<td class='<%=classValue%>' width='18%'>&nbsp;</td>
				<% }else{%>
				<td class='<%=classValue%>' width='18%'><%=(action_date_time_th)%></td>
				<%}%>
				<%if((action_type.equals("FS"))&&action_status.equals("RQ")){%>
				<td class='<%=classValue%>' width='16%'>&nbsp;</td>
				<% }else {%>
				<td class='<%=classValue%>' width='16%'><%=clinician_name%></td>
				<%}%>
				<td class='<%=classValue%>'width='16%'><%=action_desc%></td>
				<td class='<%=classValue%>'><%=action_comment%></td>
				<td class='<%=classValue%>' align='center' width='8%'><%=image_text%></td>
			</tr> 
		<%
			if(!requested_by_pract.equals("") &&action_type.equals("RV"))
			{
				tblrow_id		=	"tblrow_id"+(rowCnt);
				rowCnt++;
				/*if( (rowCnt%2)==0 )
					classValue	=	"QRYEVEN";
				else
					classValue	=	"QRYODD";*/
				
				if(requested_time.equals(""))
			{
				requested_time	="&nbsp;";
				requested_time_th	= "&nbsp;";
			}
			else
				requested_time_th=	com.ehis.util.DateUtils.convertDate(requested_time,"DMYHMS","en",locale);				
		%>
				<!--<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>' width='18%'><%=requested_time_th%></td>
				<td class='<%=classValue%>' width='16%'><%=requested_by_pract%></td>
				<td class='<%=classValue%>'width='16%'><fmt:message key="eCA.ForwardTo.label" bundle="${ca_labels}"/> - <%=clinician_name%></td>
				<td class='<%=classValue%>'><%=action_comment%></td>
				<td class='<%=classValue%>' align='center' width='8%'>&nbsp;</td>
				</tr> -->


		<% }
		prev_action_type = action_type;
		prev_requested_by_pract = requested_by_pract; 
		prev_clinician_name = clinician_name; 
		prev_action_date_time_th = action_date_time_th;
		prev_action_comment = action_comment;
		
		
		}
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
</table>
</form>
</center>
</body>
</html>

<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return ( inputString==null || inputString.equals("") )	?	defaultValue	:	inputString;
	}
%>

