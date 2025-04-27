<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
18/12/2013	IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality
03/02/2020		IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
---------------------------------------------------------------------------------------------------------------

*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script Language="JavaScript" src='../../eCA/js/RecClinicalNotesFileUpload.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart4.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onscroll='scrollTitle()' class='CONTENT'>
<center>
<form name='RecClinicalNotesPrevNotesResultForm' id='RecClinicalNotesPrevNotesResultForm' action = "../../eCA/jsp/RecClinicalNotesPrevNotesSearchDetail.jsp" method=post>
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	StringBuffer query_notes_detail	=	new StringBuffer();
	StringBuffer whereClause		=	new StringBuffer();

	
	String	classValue			=	"";
	String	note_type			=	"";
	String	temp_note_type			=	"";
	String	note_group			=	"",		appl_task_id		=	"";
	String	event_date_time		=	"";
	String	tblrow_id			=	"";
	String	login_user_id		=	"",		clinician_id		=	"";
	String	resp_id				=	"";
	String	patient_id			=	"",		encounter_id			=	"";
	String	from_date_time		=	"",		to_date_time		=	"";
	String  from_date_time_en	=	"",		to_date_time_en		=	"";
	String event_status         =   "";
	String accession_num         =   "";
	String ext_image_appl_id         =   "";
	String fileUploadImage         =   "";
	String first_accession_num         =   "";


	
	int		rowCnt				=	0, colIndex = 0;

	patient_id		=	(request.getParameter("patient_id")==null) ?	""	:	request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null) ?	""	:	request.getParameter("encounter_id");
	event_status	=	((request.getParameter("status")==null)||(request.getParameter("status")=="")) ?	"0"	:	request.getParameter("status");
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	
	from_date_time_en	=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time_en		=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");

	note_type = (request.getParameter("note_type")==null)?"":request.getParameter("note_type");
	note_group = (request.getParameter("note_group")==null)?"":request.getParameter("note_group");
	appl_task_id = (request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");

//for Sorting feature in the Header
	String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	String colorForDate = "color:pink";
	String colorForEvent = "color:white";
	if(orderBy.equals("PB"))
	{
		if(reOrder.equals("1"))
		{
			colorForEvent = "color:pink";
		}
		else
		{
			colorForEvent = "color:yellow";
		}
		colorForDate = "color:white";
	}
	else
	{
		if(reOrder.equals("1"))
			colorForDate = "color:pink";
		else
			colorForDate = "color:yellow";
	}
//----- 
	try
	{
		con				=	ConnectionManager.getConnection(request);
		boolean restrict_rd	=false;	//IN071561
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		login_user_id	=	(String)		session.getValue("login_user");
		resp_id			=	(String)		session.getValue("responsibility_id");
		clinician_id	=	(String)		session.getValue("ca_practitioner_id");

		//IN042552 Start.
		whereClause.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");
		//IN042552 End.
		if(restrict_rd)
		whereClause.append(" AND RD_PEER_NOTE_RESULT_HIDE_YN(a.facility_id,a.CONTR_MOD_ACCESSION_NUM,'"+login_user_id+"')='N'");
		
		if(!(from_date_time.equals("")))
			whereClause.append(" and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");

		if(!(to_date_time.equals("")))
			whereClause.append(" and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' ) ");

		if(!(event_status.equals("0")))
			whereClause.append(" and a.event_status = ? ");

		if(!note_type.equals(""))
		{
			whereClause.append(" and a.note_type=? " );
		}

		if (!note_group.equals(""))
		{
			whereClause.append(" and b.note_group_id=? " );
		}
		else
		{
			whereClause.append(" and b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
		}
	

		query_notes_detail.append("select to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.accession_num, a.ext_image_appl_id, a.note_type from ca_encntr_note a, ca_note_type b, am_service c, am_practitioner d, am_practitioner e where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? )  is not null and b.note_type=a.note_type  and  c.service_code=a.service_code  and  d.practitioner_id = a.performed_by_id  and  e.practitioner_id(+) = a.authorized_by_id and a.patient_id = ? and a.event_status in ('1','2','3','4','5') ");
		query_notes_detail.append(whereClause.toString());
		 /*and a.encounter_id = ? */
		String desc="";
		
		if(reOrder.equals("2"))
		{
			desc=" desc";
		}
		if(!orderBy.equals(""))
		{
			if(orderBy.equals("DT"))
			{
				query_notes_detail.append(" order by event_date_time "+desc);
			}
			else if(orderBy.equals("PB"))
			{
				query_notes_detail.append(" order by d.practitioner_name "+desc);
			}
		}
		else
		{
			query_notes_detail.append(" order by event_date_time desc");
		}
		pstmt			=	con.prepareStatement(query_notes_detail.toString());


		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	clinician_id	);
		pstmt.setString( ++colIndex,	login_user_id	);

		pstmt.setString( ++colIndex,	patient_id		);
		//pstmt.setString( ++colIndex,	encounter_id		);

		if(!(from_date_time.equals(""))){
			pstmt.setString	(	++colIndex,	from_date_time_en	);
		}

		if(!(to_date_time.equals(""))){
			pstmt.setString	(	++colIndex,	to_date_time_en	);
		}

		if(!(event_status.equals("0")))
			pstmt.setString	(	++colIndex,	event_status	);

		/*if(!categoryId.equals(""))
		{
		      pstmt.setString	(	++colIndex,	categoryId	);
		}*/
		if(!note_type.equals(""))
		{
			pstmt.setString	(	++colIndex,	note_type	);
		}
		
		if (!note_group.equals(""))
		{
			pstmt.setString	(	++colIndex,	note_group	);
		}
		else
		{
			pstmt.setString	(	++colIndex,	appl_task_id	);
		}
	


		rs				=	pstmt.executeQuery();

	%>
	<div id='divTitleTable'>
	<table cellspacing=0 cellpadding=3 width='100%' border=1 id='titleTable' align='center'>
	<tr>
		<td class='COLUMNHEADER'><a class='gridLink' name=1 href="javascript:callForOrderBy('DT');" onclick='changeColor(this);' style="<%=colorForDate%>" ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></a></td>
	</tr>
	</table>
	</div>

	<table class='grid'width='100%' id='tb1'>
	<%

		//if(startIndex>1)
			//rs.absolute((startIndex-1));
		classValue	= "gridData";
		while(rs.next())
		{
			rowCnt++;

			/*if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";*/
		

			event_date_time		=	rs.getString("event_date_time1");
			event_date_time		=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);
			
			accession_num	=	rs.getString("accession_num");
			ext_image_appl_id	=	rs.getString("ext_image_appl_id") == null ? "" : rs.getString("ext_image_appl_id");
			if(note_type.equals(""))
				temp_note_type = rs.getString("note_type") == null ? "" : rs.getString("note_type");
			else
				temp_note_type = note_type;
	
			if(rowCnt == 1)
				first_accession_num = accession_num;

			if(!ext_image_appl_id.equals(""))
			{
				fileUploadImage ="<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accession_num+"\",\""+temp_note_type+"\")' height='20' title='FileUpload...' ></img>";
			}
			else
			{
				fileUploadImage = "";
			}
		
		%>
			<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>' VALIGN=top ><a  class='gridLink' href="javascript:call_notes('<%=accession_num%>');"><%=event_date_time%>&nbsp;<%=fileUploadImage%></a></td>
			</tr>
		<%

		}
		if(rowCnt == 0)
		{
			out.println("<script>parent.RecClinicalNotesPrevNotesSearchNotesDetailFrame.location.href='../../eCommon/html/blank.html';</script>");
			out.println("<script>alert(getMessage('NO_RECORD_FOUND','Common'));</script>");
		}
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
<tr style="visibility:hidden">
	<td class='columnheader'><a class='gridLink' name=1 href="javascript:callForOrderBy('DT');" onclick='changeColor(this);' style="<%=colorForDate%>"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></a></td>
</tr>
</table>
<input type=hidden name=orderBy value=""></input>
<input type=hidden name=reOrder value=""></input>
<input type=hidden name=patient_id value="<%=patient_id%>"></input>
<input type=hidden name=encounter_id value="<%=encounter_id%>"></input>
<input type=hidden name=status value="<%=event_status%>"></input>
<input type=hidden name=from_date_time value="<%=from_date_time%>"></input>
<input type=hidden name=to_date_time value="<%=to_date_time%>"></input>
<input type=hidden name=note_type value="<%=note_type%>"></input>
<input type=hidden name=appl_task_id value="<%=appl_task_id%>"></input>
</form>
</center>
</body>
<!-- <script>alignUnitsAndData();</script> -->
<%
if(rowCnt > 0){
%>
<script>call_notes('<%=first_accession_num%>');</script>
<%
}
%>
</html>

