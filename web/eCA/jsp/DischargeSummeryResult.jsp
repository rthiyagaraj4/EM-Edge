<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String patient_id			=	"";
	String accession_num		=	"";

	int k						=	0;
	String classValue			=	"";
	String note_type			=	"";
	String service_name			=	"";
	String subject				=	"";
	String date_time			=	"";
	String performed_by_name	=	"";
	String authorized_by_name	=	"";
	String status				=	"";
	StringBuffer sql = new StringBuffer();
	String disch_summ_note_type	=	"";
	Connection con				=	null;
	ResultSet rs				=	null;
	PreparedStatement stmt		=	null;

	String head_desc			=	"";
	String pre_hdr				=	"";
	String sql_notetype			=	"";
	String l_clinican_id		=	"";
	String resp_id				=	"";
	String user_id				=	"";
	l_clinican_id				=	(String) session.getValue("ca_practitioner_id");
	resp_id    					=	(String) session.getValue("responsibility_id");
	user_id 					=	(String) session.getValue("login_user");
%>
<style>
TD.TD_BROWN{
    BACKGROUND-COLOR: BROWN;  
	COLOR = WHITE;
	FONT-SIZE: 9pt ;
	BORDER-STYLE: SOLID;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18;	
 }
</style>

<%
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src='../../eCA/js/PhysicianNote.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT 'onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='result_form' id='result_form'>
<table border="1" width="100%" cellspacing='0' cellpadding='3' id='tb1'>
<tr>
<th width='17%' align='center' nowrap><font size=1><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></font></th>
<th width='20%' align='center' nowrap><font size=1><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></font></th>
<th width='20%' align='center' nowrap><font size=1><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></font></th>
<th width='10%' align='center' nowrap><font size=1><fmt:message key="eCA.Subject.label" bundle="${ca_labels}"/></font></th>
<th width='13%' align='center' nowrap><font size=1><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></font></th>
<th width='12%' align='center' nowrap><font size=1><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></font></th>
<th width='8%' align='center' nowrap><font size=1><fmt:message key="Common.status.label" bundle="${common_labels}"/></font></th></tr>
 <%

	try
	{
		con					=ConnectionManager.getConnection(request);
		rs					=null;
		stmt				=null;
		patient_id			=request.getParameter("patient_id");


		sql_notetype="Select disch_summ_note_type from ca_note_param";
		stmt=con.prepareStatement(sql_notetype);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
		while(rs.next())
			{
			disch_summ_note_type =rs.getString("disch_summ_note_type");
			}
		}

		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(sql.length() > 0) sql.delete(0,sql.length());
   		sql.append("SELECT a.facility_id, a.accession_num, a.note_type, "); sql.append("b.note_type_desc,a.service_code,");
   		sql.append(" DECODE( A.EVENT_STATUS,'1','In Progress','2','Transcribted','3','Unauthorized','4','Authorized','5','Modified','9','In Error') status,c.short_desc service_name,");
		sql.append("a.event_title_desc,to_char(a.event_date_time,'dd/mm/yyyy hh24:mi')event_date_time,a.performed_by_id,");
		sql.append("d.practitioner_name performed_by_name,a.authorized_by_id,");
		sql.append("e.practitioner_name authorized_by_name,a.note_content, CA_GET_VISIT_DTL(A.FACILITY_ID, A.PATIENT_CLASS, A.ENCOUNTER_ID, A.PATIENT_ID) VISIT_HDR ");
		sql.append("FROM ca_encntr_note a,ca_note_type b,am_service c, am_practitioner d, ");
		sql.append("am_practitioner e ");
		sql.append("WHERE  CA_GET_APPL_NOTE_OPERN(a.facility_id,a.accession_num,?,?,a.note_type,? )  is not null and b.note_type=a.note_type and c.service_code=a.service_code and a.event_status in ('3','4','5','9')");
		sql.append("and d.practitioner_id=a.performed_by_id and e.practitioner_id(+)=a.authorized_by_id and a.patient_id=?  ");
		if(!(disch_summ_note_type.equals(""))){
		sql.append("and a.note_type=? ");
		}
		sql.append(" order by VISIT_HDR, a.event_date_time desc");
		stmt=con.prepareStatement(sql.toString());
		int count1=0;
		stmt.setString(++count1,resp_id);
		stmt.setString(++count1,l_clinican_id);
		stmt.setString(++count1,user_id);
		stmt.setString(++count1,patient_id);
		if(!(disch_summ_note_type.equals(""))){
			stmt.setString(++count1,disch_summ_note_type);
		}
		rs=stmt.executeQuery();
       if (rs !=null)
        {
        	while(rs.next()){

				if ( k%2 == 0 )
				classValue = "QRYEVEN" ;
				else
				classValue = "QRYODD" ;
				head_desc=rs.getString("visit_hdr");
				note_type=rs.getString("note_type_desc");
				accession_num=rs.getString("accession_num");
				service_name=rs.getString("service_name");
				subject=rs.getString("event_title_desc");
				date_time=rs.getString("event_date_time");
				performed_by_name=rs.getString("performed_by_name");
				authorized_by_name=rs.getString("authorized_by_name");
				status=rs.getString("status");

				if(note_type ==null || note_type.equals(""))
				{
				note_type="&nbsp;";
				}
				if(service_name ==null || service_name.equals(""))
				{
				service_name="&nbsp;";
				}
				if(subject ==null || subject.equals(""))
				{
				subject="&nbsp;";
				}
				if(date_time ==null || date_time.equals(""))
				{
				date_time="&nbsp;";
				}
				if(performed_by_name ==null || performed_by_name.equals(""))
				{
				performed_by_name="&nbsp;";
				}
				if(authorized_by_name ==null || authorized_by_name.equals(""))
				{
				authorized_by_name="&nbsp;";
				}
				if(status ==null || status.equals(""))
				{
				status="&nbsp;";
				}

				if(!(pre_hdr.equals(head_desc))){
				out.println("<tr><td nowrap colspan='7' class=CAGROUP>"+head_desc+"</td></tr>");
				}
				pre_hdr=head_desc;
				if(status.equals("In Error"))
				{
					out.println("<tr><td nowrap class='TD_BROWN'>"+date_time+"</td><td	class='TD_BROWN'><a style='color:YELLOW' href=javascript:call_notes('"+accession_num+"')>"+note_type+"</a></td><td nowrap class='TD_BROWN'>"+service_name+"</td><td nowrap	class='TD_BROWN'>"+subject+"</td><td	nowrap			class='TD_BROWN'>"+performed_by_name+"</td><td nowrap class='TD_BROWN'>"+authorized_by_name+"</td><td nowrap class='TD_BROWN'>"+status+"</td></tr>");
				}
				else
				{
					out.println("<tr><td nowrap class='"+classValue+"'>"+date_time+"</td><td	class='"+classValue+"'><a href=javascript:call_notes('"+accession_num+"')>"+note_type+"</a></td><td nowrap class='"+classValue+"'>"+service_name+"</td><td nowrap	class='"+classValue+"'>"+subject+"</td><td	nowrap			class='"+classValue+"'>"+performed_by_name+"</td><td nowrap class='"+classValue+"'>"+authorized_by_name+"</td><td nowrap class='"+classValue+"'>"+status+"</td></tr>");				
				}

				k++;
		       	}
			if(k==0)
				out.println("<script>alert('APP-002415 Query caused no records to be retrieved')</script>");
		}//if
		if(rs!=null)	rs.close();
		if(stmt!=null) 	stmt.close();
		
    }
	catch(Exception e)
	{
		//out.print("ERROR"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);

	}


%>
</table>
</form>
</body>
</html>

