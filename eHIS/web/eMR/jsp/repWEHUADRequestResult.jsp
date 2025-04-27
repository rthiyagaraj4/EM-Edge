<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper"   contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String classValue	 = "";
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	
	String jsp_name =request.getParameter("jsp_name")==null?"":request.getParameter("jsp_name");	
	String temp1="";

	String finalSelect	= request.getParameter("finalSelect")==null?"":request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";

	String Enc_Type	= request.getParameter("lstPatientClass")==null?"":request.getParameter("lstPatientClass");

	String orderBy	= request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	if(orderBy == null || orderBy.equals("ET")) 
		orderBy = "encounter_type, a.visit_adm_date_time desc";
	else if(orderBy.equals("ED")) 
		orderBy = "a.visit_adm_date_time desc";

	String alt_id1_exp_date	= request.getParameter("alt_id1_exp_date")==null?"":request.getParameter("alt_id1_exp_date");
	if(alt_id1_exp_date == null) alt_id1_exp_date="";

	String alt_id2_exp_date	= request.getParameter("alt_id2_exp_date")==null?"":request.getParameter("alt_id2_exp_date");
	if(alt_id2_exp_date == null) alt_id2_exp_date="";
	
	String national_id_no	= request.getParameter("national_id_no")==null?"":request.getParameter("national_id_no");
	if(national_id_no == null) national_id_no="";

	String alt_id1_no	= request.getParameter("alt_id1_no")==null?"":request.getParameter("alt_id1_no");
	if(alt_id1_no == null) alt_id1_no="";
	
	String alt_id2_no=request.getParameter("alt_id2_no")==null?"":request.getParameter("alt_id2_no");
	if(alt_id2_no == null) alt_id2_no="";
	
	String alt_id3_no=request.getParameter("alt_id3_no")==null?"":request.getParameter("alt_id3_no");
	if(alt_id3_no == null) alt_id3_no="";
	
	String alt_id4_no=request.getParameter("alt_id4_no")==null?"":request.getParameter("alt_id4_no");
	if(alt_id4_no == null) alt_id4_no="";

	String other_alt_type	=request.getParameter("other_alt_type")==null?"":request.getParameter("other_alt_type");
	if(other_alt_type == null) other_alt_type="";
	String other_alt_Id		=request.getParameter("other_alt_Id")==null?"":request.getParameter("other_alt_Id");
	if(other_alt_Id == null) other_alt_Id="";

	temp1=request.getParameter("temp1")==null?"":request.getParameter("temp1");
	if(temp1 == null) temp1="";

	String flag	=	"";
	flag=(request.getParameter("flag")==null) ? "" : request.getParameter("flag");

	String  req_start   =   "", req_end     =   "";

    req_start =	(request.getParameter("from")==null)   ?   "0" :   request.getParameter("from");
    req_end   =	(request.getParameter("to")==null)     ?   "0" :   request.getParameter("to");

	if( jsp_name == null) jsp_name="";
	String window_styl=request.getParameter("window_styl");
	if( window_styl == null) window_styl="";
	String close_yn	=request.getParameter("close_yn");
	if( close_yn == null) close_yn="";
	String win_top =request.getParameter("win_top");
	if( win_top == null) win_top="";
	String win_height =request.getParameter("win_height");
	if(win_height ==null) win_height="";
	String dialogTop =request.getParameter("dialogTop");
	if(dialogTop ==null) dialogTop="";
	String win_width =request.getParameter("win_width");
	if( win_width == null) win_width="";
	String modal=request.getParameter("modal");
	if(modal == null) modal="";
	String module=request.getParameter("module");
	if(module == null) module="";
	String model_window=request.getParameter("model_window");
	if( model_window == null) model_window="";
	String function_id=request.getParameter("function_id");
	if( function_id == null) function_id="";

	String prog_id=request.getParameter("prog_id");
	if( prog_id == null) prog_id="";
	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";

	String sql = "";
	String PatientId		=	request.getParameter("PatientId") ;
	if(PatientId	== null || PatientId.equals("null"))		
		PatientId = "";		
	
	String EncounterId		=	request.getParameter("p_encounter_id") ;
	if(EncounterId	== null || EncounterId.equals("null"))		
		EncounterId = "";

	String whereClause = request.getParameter("whereclause");
	if(whereClause	== null || whereClause.equals("null"))	
	{
		whereClause= "";
	}
	else
	{
		sql = whereClause;
	}

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	int start = 0 ;
	int end = 0 ;
    int i=1;


	if ( from == null )
		start = 1 ;
	else
	{
		if(from.equals(""))start=1;
		else
		start = Integer.parseInt( from ) ;
	}

	if ( to == null )
		end = 10 ;
	else
	{
		if(to.equals(""))end=10;
		else
		end = Integer.parseInt( to ) ;
	}

	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	Statement stmt=null;
	Connection conn = null;
try
{
	conn = ConnectionManager.getConnection(request);	
	if(from != null && to != null)
	{
		 int j=0;
		 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		 {
			 if(request.getParameter("chk"+(i)) != null)
			 {
				 j++;
			 }
		 }	
		 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
	i = 1 ;
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<HTML>
<head>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eOA/js/QueryLocnForDay.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
	<script src='../../eMR/js/MRReports.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>
<form name='MedRecRequestResult' id='MedRecRequestResult'  action="../../eMR/jsp/repWEHUADRequestResult.jsp" method="post"  >
<%
		StringBuffer Where  = new StringBuffer();
		String locale = (String) session.getValue("LOCALE");
		Where.append("");
					
		Where.append("WHERE a.facility_id = '"+FacilityId+"' AND a.patient_id = b.patient_id AND b.patient_id LIKE '%%' AND TRUNC (a.visit_adm_date_time) >= TO_DATE  ('"+alt_id1_exp_date+"','dd/mm/yyyy') AND TRUNC (a.visit_adm_date_time) <= TO_DATE ('"+alt_id2_exp_date+"','dd/mm/yyyy') AND EXISTS (SELECT onset_facility_id, onset_encounter_id FROM mr_diag_recoding WHERE onset_facility_id = a.facility_id AND onset_encounter_id = a.encounter_id)");

		if ( !(PatientId == null || PatientId.equals("")) )
		{
			Where.append( " and a.PATIENT_ID = '"+PatientId+"'");
		}

		if ( !(Enc_Type == null || Enc_Type.equals("")) )
		{
			Where.append( " and a.PATIENT_CLASS = '"+Enc_Type+"'");
		}

		if ( !(EncounterId == null || EncounterId.equals("")) )
		{
			Where.append( " and a.encounter_id = '"+EncounterId+"'");
		}

		if ( !(national_id_no == null || national_id_no.equals("")) )
		{
			Where.append(" and b.NATIONAL_ID_NO = '"+national_id_no+"' ");
		}
		if ( !(alt_id1_no == null || alt_id1_no.equals("")) )
		{
			Where.append( " and b.alt_id1_no = '"+alt_id1_no+"' ");
		}
		if ( !(alt_id2_no == null || alt_id2_no.equals("")) )
		{
			Where.append(" and b.alt_id2_no = '"+alt_id2_no+"' ");
		}
		if ( !(alt_id3_no == null || alt_id3_no.equals("")) )
		{
			Where.append( " and b.alt_id3_no = '"+alt_id3_no+"'");
		}
		if ( !(alt_id4_no == null || alt_id4_no.equals("")) )
		{
			Where.append( " and b.alt_id4_no = '"+alt_id4_no+"'");
		}

		if ( !(other_alt_type == null || other_alt_type.equals("")) )
		{
			Where.append( " and b.oth_alt_id_type = '"+other_alt_type+"'");
		}
		
		if ( !(other_alt_Id == null || other_alt_Id.equals("")) )
		{
			Where.append( " and b.oth_alt_Id_no = '"+other_alt_Id+"'");
		}

		if ( !(orderBy == null || orderBy.equals("")) )
		{
			Where.append( " order by "+orderBy+" ");
		}

	int maxRecord = 0;
	if(rs != null)rs.close();
	if(pstmt  != null)pstmt.close();

		sql = "SELECT   a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))patient_name, DECODE (b.sex, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,TO_CHAR (b.date_of_birth, 'dd/mm/yy') birth_date, TO_CHAR (a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi')encounter_date, a.encounter_id,(CASE WHEN a.specialty_code IS NOT NULL  THEN (SELECT short_desc FROM am_speciality  WHERE speciality_code = a.specialty_code) END) speciality_desc,DECODE (a.assign_care_locn_type,'N', (SELECT short_desc FROM ip_nursing_unit  WHERE facility_id = '"+FacilityId+"' AND nursing_unit_code = a.assign_care_locn_code),(SELECT long_desc FROM op_clinic WHERE facility_id = '"+FacilityId+"' AND clinic_code = a.assign_care_locn_code)) locn_desc,(CASE WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner WHERE practitioner_id = a.attend_practitioner_id) END) practitioner_name,a.assign_room_num room_no, a.assign_bed_num bed_no,DECODE (a.assign_care_locn_type,'C', 'Clinic','N', 'Nursing Unit','E', 'Procedure Unit','Y', 'Daycare Unit' ) locn_type, (CASE  WHEN a.patient_class IS NOT NULL THEN (SELECT short_desc FROM am_patient_class WHERE patient_class = a.patient_class) END) encounter_type, b.alt_id1_no alt_id1_no, b.alt_id2_no alt_id2_no, b.alt_id3_no alt_id3_no, b.alt_id4_no alt_id4_no,a.patient_class patient_class, get_age (b.date_of_birth) age FROM pr_encounter a, mp_patient b " + Where;

		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();
		stmt	= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs =stmt.executeQuery(sql);
		if (stmt  != null) stmt.close();
		
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		
	if (maxRecord==0)
	{			
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));//document.location.href='../../eCommon/html/blank.html'</script>");
	}
	 else
	 {

	if(!flag.equals("true"))
	{
		%>
	<%	if(!PatientId.equals(""))
		{	%>
			<table border="0" cellpadding="0" cellspacing="0" align='center' width="100%">
				<tr>
					<td>	
					<jsp:include page="../../eCommon/jsp/pline.jsp" flush="true">
					<jsp:param name="Patient_ID" value="<%=PatientId%>" />				
					</jsp:include> 			
					</td>
				</tr>
			</table>
	<%	}	%>		
		
		<table align='right'>
			<tr>
				<td>
					<%
					if ( !(start <= 1) )
						out.println("<A HREF=\"javascript:submitPrevNextrepWEHUADReqRes("+(start-10)+","+(end-10)+")\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
					if ( !( (start+10) > maxRecord ) )
						out.println("<A HREF=\"javascript:submitPrevNextrepWEHUADReqRes("+(start+10)+","+(end+10)+")\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					%>
				</td>
			</tr>
		</table>
			<br><br>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<th align='center' nowrap>&nbsp;</th>
			<th align='center' nowrap><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
	
	<%	if(PatientId.equals(""))
		{ %>
			<th align='center' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
	<%	}	%>
			<th align='center' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.room.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.Bed.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<%

		if ( rs != null )
		{
			if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

				while ( rs.next() && i<=end )
				{
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;

					String Patient_ID=rs.getString("patient_id");				
					String Patient_Name=rs.getString("patient_name");				
					String conGender=rs.getString("gender");				
					String Date_of_Birth=rs.getString("birth_date");				
					String Patient_Class=rs.getString("encounter_type");	
					String Encounter_Date=rs.getString("encounter_date");				
					String Encounter_ID=rs.getString("encounter_id");				
					String con_Speciality=rs.getString("speciality_desc");				
					String con_Location=rs.getString("locn_desc");				
					String con_Practitioner=rs.getString("practitioner_name");				
					String room_no=rs.getString("room_no");				
					String bed_no=rs.getString("bed_no");				
					String locn_type=rs.getString("locn_type");		
					String Encounter_Type = rs.getString("encounter_type");
					String Patient_Class_code= rs.getString("Patient_Class");
					String age= rs.getString("age");

					if(Patient_ID==null	      || Patient_ID.equals("null"))		    
						Patient_ID = "";
					if(Patient_Name==null	  || Patient_Name.equals("null"))				
						Patient_Name = "";
					if(conGender==null	      || conGender.equals("null"))		    
						conGender = "";
					if(Date_of_Birth==null	  || Date_of_Birth.equals("null"))
						Date_of_Birth = "";
					if(Patient_Class==null	  || Patient_Class.equals("null"))
						Patient_Class = "";
					if(Encounter_Date==null	  || Encounter_Date.equals("null"))
						Encounter_Date = "";
					if(Encounter_ID==null	  || Encounter_ID.equals("null"))
						Encounter_ID = "";
					if(con_Speciality==null	  || con_Speciality.equals("null"))
						con_Speciality = "&nbsp;";
					if(con_Location==null	  || con_Location.equals("null"))
						con_Location = "&nbsp;";
					if(con_Practitioner==null || con_Practitioner.equals("null"))
						con_Practitioner = "&nbsp;";
					if(room_no==null || room_no.equals("null"))
						room_no = "&nbsp;";
					if(bed_no==null || bed_no.equals("null"))
						bed_no = "&nbsp;";
					if(locn_type==null || locn_type.equals("null"))
						locn_type = "&nbsp;";
					if(Encounter_Type==null || Encounter_Type.equals("null"))
						Encounter_Type = "&nbsp;";

					out.println("<tr>");
					out.println("<td align='left' class='"+classValue+"'>");
					out.print("<a href=\"javascript:closeWinrepWEHUADReqRes('"+Encounter_ID+"','"+Patient_ID+"','"+"N"+"','"+Patient_Class_code+"')\">");	
					out.print("+</a></td>");				
					out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +Encounter_Type+"</td>");
					out.println("<td nowrap class='"+classValue+"'><a href=javascript:RecodeDiagnosisrepWEHUADReqRes('"+Encounter_ID+"','"+Patient_ID+"')>"+Encounter_ID+"</a></td>");

				if(PatientId.equals(""))
				{					
					out.println("<td nowrap class='"+classValue+"'>"+Patient_ID+", "+Patient_Name+", "+conGender+", "+age+"&nbsp;</td>");				
				}
					out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +room_no+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +bed_no+"</td>");
					out.println("<td nowrap class='"+classValue+"'>"+con_Practitioner+"</td>");
					out.println("</tr>");
				i++;
			}
		}	%>	
	</table>
<%	}
	
	%>
	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
	<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
	<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
	<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
	<input type='hidden' name='module' id='module' value="<%=module%>" >
	<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
	
	<input type='hidden' name='total_count' id='total_count' value="<%=(i-1)%>" >
	<input type='hidden' name='PatientId' id='PatientId' value="<%=PatientId%>" >
	<input type='hidden' name='from' id='from' value="<%=start%>" >
	<input type='hidden' name='to' id='to' value="<%=end%>" >
	<input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect%>'>
	<input type='hidden' name='temp1' id='temp1' value='<%=temp1%>'>

	<input type='hidden' name='lstPatientClass' id='lstPatientClass' value="<%=Enc_Type%>" >
	<input type='hidden' name='orderBy' id='orderBy' value="<%=orderBy%>" >
	<input type='hidden' name='alt_id1_exp_date' id='alt_id1_exp_date' value="<%=alt_id1_exp_date%>" >
	<input type='hidden' name='alt_id2_exp_date' id='alt_id2_exp_date' value="<%=alt_id2_exp_date%>" >


	<input type='hidden' name='national_id_no' id='national_id_no' value="<%=national_id_no%>" >
	<input type='hidden' name='alt_id1_no' id='alt_id1_no' value="<%=alt_id1_no%>" >
	<input type='hidden' name='alt_id2_no' id='alt_id2_no' value="<%=alt_id2_no%>" >
	<input type='hidden' name='alt_id3_no' id='alt_id3_no' value="<%=alt_id3_no%>" >
	<input type='hidden' name='alt_id4_no' id='alt_id4_no' value="<%=alt_id4_no%>" >
	<input type='hidden' name='other_alt_type' id='other_alt_type' value="<%=other_alt_type%>" >
	<input type='hidden' name='other_alt_Id' id='other_alt_Id' value="<%=other_alt_Id%>" >

	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name="hddEncID" id="hddEncID" value="">
	<input type='hidden' name="PatientId" id="PatientId" value="<%=PatientId%>">
	<input type='hidden' name="p_encounter_id" id="p_encounter_id" value="<%=EncounterId%>">
	<input type='hidden' name="FacilityId" id="FacilityId" value="<%=FacilityId%>">


	<br><center>
<%
}
if(!finalSelect.equals("SELECTALL"))
{
	StringTokenizer st=new StringTokenizer(finalSelect,"~");
	String objName ="";String enable_dis="";
	int temp=st.countTokens();
	for(int u2=0;u2<temp;u2++)
	{
		String st2=st.nextToken();
		StringTokenizer st1=new StringTokenizer(st2,"$");
		st1.nextToken();
		objName=st1.nextToken();
		enable_dis=st1.nextToken();

		if(enable_dis.equals("E"))
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=true;</script>");
		else
			out.println("<script>if(document.forms[0]."+objName+")document.forms[0]."+objName+".checked=false;</script>");
	}
}
Where.setLength(0);
}catch ( Exception e )
{ 
	//out.println(e);
	e.printStackTrace();
}

finally
{

	try
	{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	}
	catch (Exception e)
	{
	}

	ConnectionManager.returnConnection(conn,request);
}
%>
</center>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

