<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Register File Not Pulled
	Function		:	This function is used for Search Result.
-->
<%@ page import= "java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, webbeans.st.RecordSetBean"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="recordSet" scope="session" class="webbeans.st.RecordSetBean"/>
<%!int row_count=0;%>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con	=	null;
	Statement stmt	=	null;		 
	ResultSet rs	=	null;	
	
	Hashtable		htRecord	=	null;
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();		
		
		int start = 0 ;
		int end = 0 ;
		int fm_disp=0, to_disp=0;
		
		String file_no="", patient_id="", tblrow_id="",classValue="";
		String pat_details="",appt_date="",	clinic_desc="", clinic_code="",fs_locn_code="",curr_file_status="",pull_yn_prop="";
		String fs_locn_desc="",practitioner_name="",practitioner_id="",result_query="",file_pull_yn="N";
		String curr_fs_locn_code="", curr_facility_id="",curr_file_status1="";

		String facility_id=(String)session.getValue("facility_id");
		String from			=	request.getParameter( "from" ) ;
		String to			=	request.getParameter( "to" ) ;
		String mode			=	request.getParameter("mode") ;

		if(mode == null || mode.equals("null")) mode="";

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
	  		end = 9 ;
		else
			end = Integer.parseInt( to ) ;

		if(mode.equals(""))
		{
			appt_date=request.getParameter("appt_date");
			if(appt_date==null)appt_date="";
			if(!(appt_date.equals(""))) recordSet.clearAll();

			//result_query="select a.file_no, a.patient_id, a.clinic_desc, a.clinic_code, a.src_fs_locn_code, a.DEST_FS_LOCN_DESC src_fs_locn_desc, a.practitioner_name, a.practitioner_id, get_patient_line(a.patient_id) pat_details , decode(b.curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived', 'O', 'Outside' ) curr_file_status,curr_file_status curr_file_status1,b.curr_fs_locn_code,b.curr_facility_id from fm_pulling_list_vw a,fm_curr_locn_vw b where a.facility_id='"+facility_id+"' and a.appt_date = to_date('"+appt_date+"','dd/mm/yyyy') and a.file_pulled_yn='N' and a.facility_id=b.facility_id and a.file_no=b.file_no ";
			result_query = "SELECT"
						  +"  a.File_No"
						  +"  , a.Patient_Id"
						  +"  , op_Get_desc.OP_CLINIC('"+facility_id+"',a.Clinic_Code,'"+localeName+"',1)"
						  +"  , a.Clinic_Code"
						  +"  , a.src_fs_Locn_Code"
						  +"  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.src_fs_Locn_Code,'"+localeName+"',2) src_fs_Locn_desc"
						  +"  , am_Get_desc.AM_PRACTITIONER(a.Practitioner_Id,'"+localeName+"',1)"
						  +"  , a.Practitioner_Id"
						  +"  , Get_patient_line(a.Patient_Id,'"+localeName+"') Pat_Details"
						  +"  , b.Curr_File_Status Curr_File_Status"
						  +"  , Curr_File_Status Curr_File_Status1"
						  +"  , b.Curr_fs_Locn_Code"
						  +"  , b.Curr_Facility_Id "
						  +"FROM"
						  +"  fm_PullIng_List a"
						  +"  , fm_Curr_Locn b "
						  +"WHERE a.Facility_Id = '"+facility_id+"' "
						  +"  AND a.appt_Date = TO_DATE('"+appt_date+"','dd/mm/yyyy') "
						  +"  AND a.CONFIRM_YN = 'N' "
						  +"  AND a.Facility_Id = b.Facility_Id "
						  +"  AND a.File_No = b.File_No";


			rs=stmt.executeQuery(result_query);

			if(rs != null)
			{
				while(rs.next())
				{
					file_no				=	rs.getString("file_no");
					patient_id			=	rs.getString("patient_id");
					clinic_desc			=	rs.getString("clinic_desc");
					clinic_code			=	rs.getString("clinic_code");
					fs_locn_code		=	rs.getString("src_fs_locn_code");
					fs_locn_desc		=	rs.getString("src_fs_locn_desc");
					practitioner_name	=	rs.getString("practitioner_name");
					practitioner_id		=	rs.getString("practitioner_id");
					curr_file_status	=	rs.getString("curr_file_status");
					curr_file_status1	=	rs.getString("curr_file_status1");
					pat_details			=	rs.getString("pat_details").substring(0,rs.getString("pat_details").length()-6);
					curr_fs_locn_code	=	rs.getString("curr_fs_locn_code");
					curr_facility_id	=	rs.getString("curr_facility_id");


					if(file_no == null || file_no.equals("null"))file_no="";
					if(patient_id == null || patient_id.equals("null"))patient_id="";
					if(clinic_desc == null || clinic_desc.equals("null"))clinic_desc="";				if(clinic_code == null || clinic_code.equals("null"))clinic_code="";
					if(fs_locn_code == null || fs_locn_code.equals("null"))fs_locn_code="";
					if(fs_locn_desc == null || fs_locn_desc.equals("null"))fs_locn_desc="";
					if(practitioner_name == null || practitioner_name.equals("null"))practitioner_name="";
					if(practitioner_id == null || practitioner_id.equals("null"))practitioner_id="";
					if(pat_details == null || pat_details.equals("null"))pat_details="";
					if(curr_file_status == null || curr_file_status.equals("null"))curr_file_status="";
					if(curr_file_status1 == null || curr_file_status1.equals("null"))curr_file_status1="";
					if(curr_fs_locn_code == null || curr_fs_locn_code.equals("null"))curr_fs_locn_code="";
					if(curr_facility_id == null || curr_facility_id.equals("null"))curr_facility_id="";

			if(!curr_file_status.equals(""))
			{
				switch(curr_file_status.charAt(0))
				{
					case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;
			
				}
			}


					htRecord			=	new Hashtable();

					htRecord.put("file_no"			,	file_no);
					htRecord.put("patient_id"		,	patient_id);
					htRecord.put("clinic_desc"		,	clinic_desc);
					htRecord.put("clinic_code"		,	clinic_code);
					htRecord.put("fs_locn_code"		,	fs_locn_code);
					htRecord.put("fs_locn_desc"		,	fs_locn_desc);
					htRecord.put("practitioner_name",	practitioner_name);
					htRecord.put("practitioner_id"	,	practitioner_id);
					htRecord.put("pat_details"		,	pat_details);
					htRecord.put("pat_details"		,	pat_details);
					htRecord.put("file_pull_yn"		,	file_pull_yn);
					htRecord.put("curr_file_status" ,	curr_file_status);
					htRecord.put("curr_file_status1" ,	curr_file_status1);
					htRecord.put("curr_fs_locn_code",	curr_fs_locn_code);	
					htRecord.put("curr_facility_id" ,	curr_facility_id);
					
					recordSet.putObject(htRecord);
				}
			}

			row_count				=	recordSet.getSize();

			
			fm_disp	=	0;
			to_disp	=	9;
			if(to_disp > (row_count-1))
					to_disp=(row_count-1);
		}

			fm_disp =	start-1;
			to_disp	=	end-1;
				if(to_disp > (row_count-1))
					to_disp=(row_count-1);
		
%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMRegFilesNotPulled.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<SCRIPT>
	function loadCurrPage()
	{
		/*		
		var CBValStr		=	parent.frames[0].document.forms[0].CBValStr.value;
		var fm_disp	=	document.forms[0].fm_disp.value;
		var to_disp	=	document.forms[0].to_disp.value;
		if(CBValStr != "")
		{
			for(i=fm_disp; i<=to_disp; i++)
			{
				if(eval('document.forms[0].pull_yn'+i+'.disabled=false;'))
				{
					eval('document.forms[0].pull_yn'+i+'.checked=true;');
				}
			}
		}		
		//else if((chk_val==""))
		//{
			//parent.frames[1].document.forms[0].CBValStr.value	=	CBValStr;
			//parent.frames[1].document.forms[0].LocnValStr.value	=	LocnValStr;

		/*for(i=fm_disp; i<=to_disp; i++)
			{
				eval('document.forms[0].fs_locn_code'+i+'.disabled=false;');
				eval('document.forms[0].associate_yn'+i+'.disabled=false;');
				eval('document.forms[0].fs_locn_code'+i+'.value="";');
				eval('document.forms[0].associate_yn'+i+'.checked=false;');
			}
			if(CBValStr != "") parent.frames[1].document.forms[0].CBValStr.value="";
			if(LocnValStr != "") parent.frames[1].document.forms[0].LocnValStr.value="";
		*/
		//}
		
	}
	</SCRIPT>
</head>
<body  onLoad='dispRecord(); loadCurrPage();' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='FMRegFilesNotPulledForm' id='FMRegFilesNotPulledForm' action='' method=''>
<P>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
	{
%>
	<A HREF='../jsp/FMRegFilesNotPulledResults.jsp?from=<%=start-9%>&to=<%=end-9%>&mode=Previous' onClick='checkVal();' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%	
	}
%>
<%
	if ( !( (start+9) > row_count ) )
	{
%>
	<A HREF='../jsp/FMRegFilesNotPulledResults.jsp?from=<%=(start+9)%>&to=<%=(end+9)%>&mode=next' onClick='checkVal();' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
<%
	}
%>
</td>
</tr>
</table> 
<br><br>
</P>

<table cellpadding='0' cellspacing='0' border='1' width='100%'  >
<th width='40%'><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></th>
<th width='15%'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></th>
<th width='15%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
<th width='15%'><fmt:message key="eFM.ReceivingFSLocation.label" bundle="${fm_labels}"/></th>
<th width='10%'><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></th>
<th width='5%'><fmt:message key="eFM.Pull.label" bundle="${fm_labels}"/>?</th>
<%
try
{
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		htRecord			=	(java.util.Hashtable)	recordSet.getObject(i);

		file_no				=	(String)	htRecord.get("file_no");
		patient_id			=	(String)	htRecord.get("patient_id");
		clinic_desc			=	(String)	htRecord.get("clinic_desc");
		clinic_code			=	(String)	htRecord.get("clinic_code");
		fs_locn_code		=	(String)	htRecord.get("fs_locn_code");
		fs_locn_desc		=	(String)	htRecord.get("fs_locn_desc");
		practitioner_name	=	(String)	htRecord.get("practitioner_name");
		practitioner_id		=	(String)	htRecord.get("practitioner_id");
		curr_file_status	=	(String)	htRecord.get("curr_file_status");
		curr_file_status1	=	(String)	htRecord.get("curr_file_status1");
		pat_details			=	(String)	htRecord.get("pat_details");
		curr_fs_locn_code	=	(String)	htRecord.get("curr_fs_locn_code");
		curr_facility_id	=	(String)	htRecord.get("curr_facility_id");
				
		if((fs_locn_code.equals(curr_fs_locn_code)) && (facility_id.equals(curr_facility_id)) && (curr_file_status1.equals("I"))) 
			pull_yn_prop="checked";
		else
			pull_yn_prop="disabled";

		tblrow_id	=	"tblrow_id"+i;

		%>
			<tr id='<%=tblrow_id%>'>
			<td class='<%=classValue%>' ><font size='1'><b><%=((file_no.equals(""))?"&nbsp;":file_no)%></b></font><br>&nbsp;&nbsp;&nbsp;<font size='1'><%=((pat_details.equals(""))?"&nbsp;":pat_details)%></font></td>			

			<td class='<%=classValue%>' ><font size='1'><%=((clinic_desc.equals(""))?"&nbsp;":clinic_desc)%></font></td>

			<td class='<%=classValue%>' ><font size='1'><%=((practitioner_name.equals(""))?"&nbsp;":practitioner_name)%></font></td>

			<td class='<%=classValue%>' ><font size='1'><%=((fs_locn_desc.equals(""))?"&nbsp;":fs_locn_desc)%></font></td>

			<td class='<%=classValue%>' ><font size='1'><%=((curr_file_status.equals(""))?"&nbsp;":curr_file_status)%></font></td>			

			<td class='<%=classValue%>' align='center'><input type='checkbox' name='pull_yn<%=i%>' id='pull_yn<%=i%>'  value='Y'  onClick='CBValue(this,"<%=i%>");' <%=pull_yn_prop%> ></td>
			</tr>
		<%
		}
	}
	catch(Exception e)
	{
		out.println("Exception@2: "+e);
	}	
%>
</table>
<input type='hidden' name='row_count' id='row_count' value='<%=row_count%>'>
<input type='hidden' name='fm_disp' id='fm_disp' value='<%=fm_disp%>'>
<input type='hidden' name='to_disp' id='to_disp' value='<%=to_disp%>'>
</form>
<%
if(rs != null) rs.close();
if(stmt != null) stmt.close();	
}
catch(Exception e)
{
	out.println("Exception in etching connection"+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>


