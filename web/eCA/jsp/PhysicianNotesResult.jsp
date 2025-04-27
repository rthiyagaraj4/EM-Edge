<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 	request.setCharacterEncoding("UTF-8"); %>
<%

	String patient_id	="";
	String note_type_id	="";
	String accession_num="";
	String perform_id	="";
	String med_anc_id	="";
	String status_val	="";
	String from_date	="";
	String end_date		="";
	int k				=0;
	String classValue	="";
	String note_type	="";
	String service_name	="";
	String subject		="";
	String date_time	="";
	String performed_by_name="";
	String authorized_by_name	="";
	String status		="";
	StringBuffer sql=new StringBuffer();
	String p_event_class="";
	Connection con		=null;
	ResultSet rs		=null;
	PreparedStatement stmt		=null;
	String from_query	="";
	String cur_epi		="";
	String encounter_id	="";
	String episode_type	="";
	String head_desc	="";
	int i=1;
	String pre_hdr		="";

	String l_clinican_id 	= "";
	String resp_id          ="";
	String user_id          ="";
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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src='../js/PhysicianNote.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll='scrollTitle()' >
 <script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<form name='result_form' id='result_form'>
<div id='divDataTitle' style='postion:relative'>
<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
<TR>
<td class='columnheadercenter' width='17%'><font size=1><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter' width='20%' ><font size=1><fmt:message key="eCA.NoteType.label" bundle="${ca_labels}"/></font></td>
<td class='columnheadercenter' width='20%' ><font size=1><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter' width='10%' ><font size=1><fmt:message key="eCA.Subject.label" bundle="${ca_labels}"/></font></td>
<td class='columnheadercenter' width='13%' ><font size=1><fmt:message key="Common.Performed.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter' width='12%' ><font size=1><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter' width='8%' ><font size=1><fmt:message key="Common.status.label" bundle="${common_labels}"/></font></td></tr>
</table>
</div>
<table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff">
 <%

	try
	{
		con				=ConnectionManager.getConnection(request);
		rs				=null;
		stmt				=null;
		from_query			=request.getParameter("from_query");
		if(from_query !=null && from_query.equals("Y")){
		note_type_id			=request.getParameter("note_type");
		perform_id			=request.getParameter("performed_by");
		med_anc_id			=request.getParameter("med_anc");
		status_val			=request.getParameter("status");
		from_date			=request.getParameter("from_date");
		end_date			=request.getParameter("to_date");
		}
		patient_id			=request.getParameter("patient_id");
		p_event_class			=request.getParameter("p_event_class");
		episode_type			=request.getParameter("episode_type");
		encounter_id			=request.getParameter("episode_id");
		cur_epi				=request.getParameter("cur_epi");
		if(cur_epi ==null)
			cur_epi="Y";

	
		l_clinican_id				=	(String) session.getValue("ca_practitioner_id");
		resp_id    					=	(String) session.getValue("responsibility_id");
		user_id 					=	(String) session.getValue("login_user");

		sql.append(" SELECT a.facility_id, a.accession_num, a.note_type, "); 
		sql.append("b.note_type_desc,a.service_code,");
   		sql.append(" DECODE( A.EVENT_STATUS,'1','In Progress','2','Transcribted','3','Unauthorized','4','Authorized','5','Modified','9','In Error') status,c.short_desc service_name,");
		sql.append(" a.event_title_desc,to_char(a.event_date_time,'dd/mm/yyyy hh24:mi')event_date_time,a.performed_by_id,");
		sql.append(" d.practitioner_name performed_by_name,a.authorized_by_id,");
		sql.append(" e.practitioner_name authorized_by_name,a.note_content, CA_GET_VISIT_DTL(a.facility_id, a.patient_class, a.encounter_id, a.patient_id) VISIT_HDR ");
		sql.append(" FROM ca_encntr_note a,ca_note_type b,am_service c,am_practitioner d, ");
		sql.append(" am_practitioner e ");
		sql.append(" WHERE   CA_GET_APPL_NOTE_OPERN(a.facility_id,a.accession_num,?,?,a.note_type,? )  is not null and b.note_type=a.note_type and c.service_code=a.service_code and a.event_status in ('3','4','5','9')");
		sql.append(" and d.practitioner_id=a.performed_by_id and e.practitioner_id(+)=a.authorized_by_id and a.event_class=? and a.patient_id=? ");
		if(!(note_type_id.equals(""))){
		sql.append("and a.note_type=? ");
		}
		if(!(perform_id.equals(""))){
		sql.append("and a.performed_by_id=? ");
		}
		if(!(med_anc_id.equals(""))){
		sql.append("and a.service_code=? ");
		}
		if(!(status_val.equals(""))){
		sql.append("and a.event_status=? ");
		}
		if(!(cur_epi.equals("N"))){

			if(!(episode_type.equals("")) && episode_type.equals("O")){
			sql.append("and a.encounter_id=? ");
			}
			else if(!(episode_type.equals("")) && episode_type.equals("I")){
			sql.append("and a.encounter_id=? ");

			}
		}

		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) ){
				 sql.append(" and trunc(a.event_date_time) between to_date(?,'dd/mm/yyyy') and  to_date(?,'dd/mm/yyyy') ");
				 }
		else if((end_date.equals("")) && !(from_date.equals(""))){
				 sql.append(" and trunc(a.event_date_time) >= to_date(?,'dd/mm/yyyy')");
				 }
	        else if((from_date.equals("")) && !(end_date.equals(""))){
				 sql.append(" and trunc(a.event_date_time) <= to_date(?,'dd/mm/yyyy')");
				 }

		sql.append(" order by VISIT_HDR, a.event_date_time desc ");
	    //out.println(sql);
		stmt=con.prepareStatement(sql.toString());
		int count1=0;
		stmt.setString(++count1,resp_id);
		stmt.setString(++count1,l_clinican_id);
		stmt.setString(++count1,user_id);
		stmt.setString(++count1,p_event_class);
		stmt.setString(++count1,patient_id);
		if(!(note_type_id.equals(""))){
		stmt.setString(++count1,note_type_id);
		}
		if(!(perform_id.equals(""))){
		stmt.setString(++count1,perform_id);
		}
		if(!(med_anc_id.equals(""))){
		stmt.setString(++count1,med_anc_id);
		}
		if(!(status_val.equals(""))){
		stmt.setString(++count1,status_val);
		}
		if(!(cur_epi.equals("N"))){

			if(!(episode_type.equals("")) && episode_type.equals("O")){
				stmt.setString(++count1,encounter_id);
			}
			else if(!(episode_type.equals("")) && episode_type.equals("I")){
				stmt.setString(++count1,encounter_id);

			}
		}

		if( (!(from_date.equals(""))) && (!(end_date.equals(""))) ){
				 stmt.setString(++count1,from_date);
				 stmt.setString(++count1,end_date);
				 }
		else if((end_date.equals("")) && !(from_date.equals(""))){
				 stmt.setString(++count1,from_date);
				 }
	        else if((from_date.equals("")) && !(end_date.equals(""))){
				 stmt.setString(++count1,end_date);
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
				//out.println(head_desc);
				note_type=rs.getString("note_type_desc");
				accession_num=rs.getString("accession_num");
				//out.println(accession_num);
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
				if(status.equals("In Error")){
					out.println("<tr><td nowrap class='TD_BROWN'>"+date_time+"</td><td	class='TD_BROWN'><a style='color:YELLOW' href=javascript:call_notes('"+accession_num+"')>"+note_type+"</a></td><td nowrap class='TD_BROWN'>"+service_name+"</td><td nowrap	class='TD_BROWN'>"+subject+"</td><td	nowrap			class='TD_BROWN'>"+performed_by_name+"</td><td nowrap class='TD_BROWN'>"+authorized_by_name+"</td><td nowrap class='TD_BROWN'>"+status+"</td></tr>");				
				}else{
					out.println("<tr><td nowrap class='"+classValue+"'>"+date_time+"</td><td	class='"+classValue+"'><a href=javascript:call_notes('"+accession_num+"')>"+note_type+"</a></td><td nowrap class='"+classValue+"'>"+service_name+"</td><td nowrap	class='"+classValue+"'>"+subject+"</td><td	nowrap			class='"+classValue+"'>"+performed_by_name+"</td><td nowrap class='"+classValue+"'>"+authorized_by_name+"</td><td nowrap class='"+classValue+"'>"+status+"</td></tr>");
				}
				i++;
				k++;
		       	}
		}//if

		  if(k==0){ %>
					<Script language=javascript>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		  <%}
    
	if(rs!=null)	rs.close();
	if(stmt!=null) 	stmt.close();
	}
	catch(Exception e){
		//out.print("ERROR"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		
		if(con!=null)ConnectionManager.returnConnection(con,request);

	}


%>
<tr style='visibility:hidden'>
<td class='columnheadercenter' width='17%' align='center' nowrap><font size=1><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter' width='20%' align='center' nowrap><font size=1><fmt:message key="eCA.NoteType.label" bundle="${ca_labels}"/></font></td>
<td class='columnheadercenter' width='20%' align='center' nowrap><font size=1><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter' width='10%' align='center' nowrap><font size=1><fmt:message key="eCA.Subject.label" bundle="${ca_labels}"/></font></td>
<td class='columnheadercenter' width='13%' align='center' nowrap><font size=1><fmt:message key="eCA.PerfomedBy.label" bundle="${ca_labels}"/></font></td>
<td class='columnheadercenter' width='12%' align='center' nowrap><font size=1><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></font></td>
<td class='columnheadercenter' width='8%' align='center' nowrap><font size=1><fmt:message key="Common.status.label" bundle="${common_labels}"/></font></td></tr>
</table>
</form>
</body>
</html>
<script>alignWidth();</script>

