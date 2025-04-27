<!DOCTYPE html>
<%--
/**
  * Created Date		:	12th FEB 2009
  *	Author				:	S V Narayana
  */
--%>
<%@page import="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script language='javascript' src='../../eAE/js/AEPatientByCriteria.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con				=	null;
	PreparedStatement pstmt		=	null;
	ResultSet rs				=	null;
	StringBuffer sqlPatQ        = new StringBuffer();
	 StringBuffer whereClause    = new StringBuffer();


	try
	{ 
     String  admission_date_time       = "";
     String  encounter_id			   = "";
     String  patient_id                = "";
     String  observe_id                = "";
     String  gender            = "";
    // String  bed_bay_type              = "";
	 String  patient_name              = "";
     String  Sex                       = "";
     String  nursing_unit_short_desc   = "";
     String  bed_class_short_desc      = "";
     String  bed_type_short_desc       = "";
     String  bed_no                    = "";
     String  room_no                   = "";
    // String  location_desc             = "";
	 String nursing_unit_code          = "";
	 String facility_id                = "";
	 String login_user_id			   = "";
	 String oper_stn_id                = "";
	 String	from 					   = "",		to 						=	"";
	 String CAInstalled                = "";
	 String classValue                 = "";
	 patient_id			=	checkForNull(request.getParameter("patient_id"));
	 observe_id			=	checkForNull(request.getParameter("observe_id"));
	 gender		=	checkForNull(request.getParameter("gender"));

	 int maxDispRecords =7; 
	con				   =	(Connection)	ConnectionManager.getConnection(request);
		facility_id		   =	(String)		session.getValue("facility_id");
		login_user_id	   =	(String)		session.getValue("login_user");
		oper_stn_id		   =	checkForNull(request.getParameter("oper_stn_id"));
		nursing_unit_code  =	checkForNull(request.getParameter("nursing_unit_code"));
		String locale			= (String)session.getAttribute("LOCALE");


	    int		rowIndex				=	1;		
		int		maxRecord				=	0;
		int 	i						=	1;
		int		start					=	0;
		int 	end						=	0;
    
		from							=	request.getParameter("from") ;
		to								=	request.getParameter("to") ;
		if ( from == null ||from.equals("") )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null ||to.equals(""))
			end = maxDispRecords ;
		else
			end = Integer.parseInt( to ) ;  


		StringBuffer CAInstallSQL = new StringBuffer("select install_yn from sm_module where module_id='CA' ");
		PreparedStatement CAInstallPSTMT		= con.prepareStatement(CAInstallSQL.toString());
		ResultSet CAInstallRS					= CAInstallPSTMT.executeQuery();
		if(CAInstallRS!=null && CAInstallRS.next())
		{
			CAInstalled = CAInstallRS.getString(1); 
		}

        if(CAInstallPSTMT!=null) CAInstallPSTMT.close();
        if(CAInstallRS!=null) CAInstallRS.close();
		if((CAInstallSQL != null) && (CAInstallSQL.length() > 0))
		{
			CAInstallSQL.delete(0,CAInstallSQL.length()); 		}   
			
        //using filter

		if(!(patient_id.equals("")))			whereClause.append(" and a.patient_id = '"+patient_id+"' ");
		if(!(gender.equals("")))		whereClause.append(" and c.sex = '"+gender+"' ");


			
			sqlPatQ.append(" SELECT a.room_num, ip_get_desc.ip_bed_class (a.bed_class_code, '"+locale+"', 2 ) bed_class_short_desc, ip_get_desc.ip_bed_type (a.bed_type_code,'"+locale+"', 2 ) bed_type_short_desc, TO_CHAR (a.admission_date_time, 'dd/mm/yyyy hh24:mi' ) admission_date_time, am_get_desc.AM_SPECIALITY (a.specialty_code, '"+locale+"', 2 ) specialty_short_desc, a.nursing_unit_code, am_get_desc.AM_PRACTITIONER (a.admit_practitioner_id,'"+locale+"', '1' ) practitioner_short_name, a.encounter_id, a.patient_id, c.sex, TO_CHAR (c.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, DECODE ('"+locale+"', 'en', c.patient_name, NVL (c.patient_name_loc_lang, c.patient_name) ) patient_name, ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, a.bed_num, a.blocked_bed_no, a.admit_practitioner_id, a.oth_adt_status, a.leave_expiry_date_time, DECODE (SIGN ((a.leave_expiry_date_time - SYSDATE)), -1, 'Y', 'N' ) leave_flag, DECODE (pat_curr_locn_type, 'N', (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.facility_id AND nursing_unit_code = pat_curr_locn_code AND language_id ='"+locale+"'), 'R', (SELECT short_desc FROM am_facility_room_lang_vw WHERE operating_facility_id = a.facility_id AND room_num = pat_curr_locn_code AND room_type = pat_curr_locn_type AND language_id = '"+locale+"'), (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.facility_id AND clinic_code = pat_curr_locn_code AND language_id ='"+locale+"') ) location_desc, a.patient_class patient_class, a.tfr_req_status    FROM ip_open_encounter a, mp_patient c   WHERE facility_id = ?  AND a.patient_id = c.patient_id");
			sqlPatQ.append(whereClause);	
			sqlPatQ.append(" AND a.nursing_unit_code = ? AND a.adt_status IN ('01', '02') AND nursing_unit_code IN ( SELECT a.nursing_unit_code FROM ip_nursing_unit a, am_os_user_locn_access_vw b WHERE a.facility_id = a.facility_id AND a.facility_id = b.facility_id AND a.nursing_unit_code = b.locn_code AND a.locn_type = b.locn_type AND b.locn_type = 'N' AND a.eff_status = 'E' AND b.oper_stn_id = ? AND b.appl_user_id = ?)     AND a.oth_adt_status IS NULL AND a.ip_leave_status IS NULL AND facility_id = a.facility_id ORDER BY specialty_short_desc, practitioner_short_name, admission_date_time, TO_DATE (a.admission_date_time, 'DD/MM/RRRR HH24:MI')");

            pstmt		=	con.prepareStatement(sqlPatQ.toString());
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	nursing_unit_code	);
			pstmt.setString	(	3,	oper_stn_id		);
			pstmt.setString	(	4,	login_user_id		);

           
			rs			=	pstmt.executeQuery();	
			while(rs!=null && rs.next())
			{
			  maxRecord++; 
			}
	    
		if(pstmt!=null)	pstmt.close();
		if(rs!=null)	rs.close();
		/********************/
		if	 (maxRecord==0)
		{
%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		</script>
<%
}
else
{
    pstmt		=	con.prepareStatement(sqlPatQ.toString());
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	nursing_unit_code	);
			pstmt.setString	(	3,	oper_stn_id		);
			pstmt.setString	(	4,	login_user_id		);
	
	rs			=	pstmt.executeQuery();	
 %>

<form name='AEIPSearchResultFrame' id='AEIPSearchResultFrame'>
<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
</div>
<div  id='divTitleTable' >
<table border='0' cellpadding='0' cellspacing='0' width='100%' id='TitleTab'>
<tr>
        <td  width='80%'>
            <table  align=right>
                <tr>
                    <td> 
<%
if ( !(start <= 1) ){

	out.println("<label  onClick=\"self.location.href='../../eAE/jsp/AEIPSearchResult.jsp?from="+(start-maxDispRecords)+"&to="+(end-maxDispRecords)+"&nursing_unit_code="+nursing_unit_code+ "&observe_id="+observe_id+"&patient_id="+patient_id+"&gender="+gender+"&oper_stn_id="+oper_stn_id+ "&whereclause="+URLEncoder.encode(whereClause.toString())+"';\"  style='cursor:pointer'><font color='BLUE'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font></label>");
	}

  if ( !( (start+maxDispRecords) > maxRecord ) ){

	  out.println("<A HREF='../../eAE/jsp/AEIPSearchResult.jsp?from="+(start+maxDispRecords)+"&to="+(end+maxDispRecords)+"&oper_stn_id="+oper_stn_id+"&observe_id="+observe_id+"&patient_id="+patient_id+"&gender="+gender+"&nursing_unit_code="+nursing_unit_code+"&whereclause="+URLEncoder.encode(whereClause.toString())+"';\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	}
%>
</td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
<tr>
<th nowrap><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
<th nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></th>
</tr>
</div>
<%
int tryl=1;
i=1;
if ( rs != null )
{
    int p1=1;
   if ( start != 1 )
    {
	     for( int k=1; k<start; i++,k++ )
	     {
		  rs.next() ;
	     }
    }
		while ( rs.next() && i<=end )
        {
			classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;

			admission_date_time = rs.getString("admission_date_time");
			if(admission_date_time == null) admission_date_time="&nbsp;";
            encounter_id=rs.getString("encounter_id");
			if(encounter_id == null) encounter_id="";
			patient_id = rs.getString("patient_id");
			if( patient_id == null) patient_id="";
			patient_name=rs.getString("patient_name");
			if ((patient_name == null) || (patient_name.equals("null"))) 
			patient_name="";
			Sex =rs.getString("sex");
			if( Sex == null )Sex="";
		    nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
		    if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";
		    bed_class_short_desc=rs.getString("bed_class_short_desc");
		    if(bed_class_short_desc== null) bed_class_short_desc="&nbsp;";
		    bed_type_short_desc=rs.getString("bed_type_short_desc");
		    if(bed_type_short_desc== null) bed_type_short_desc="&nbsp;";
		    bed_no =rs.getString("bed_num");
		    if(bed_no== null) bed_no="&nbsp;";
		    room_no =rs.getString("room_num");
		    if(room_no== null) room_no="&nbsp;";

%>

		<tr>  			
		<td class='<%=classValue%>'  width='7%'><font size=1><%=DateUtils.convertDate(admission_date_time,"DMYHM","en",locale)%></td>
		<td style='background-color:#F4D7F0;' width='7%'><font size=1><a href='javascript:DummyRef()' 	onClick="showCAChart('<%=encounter_id%>');"><font size=1><%=encounter_id%></a></td>
		<td class='<%=classValue%>'  width='7%'><font size=1><%=patient_id%></td>
		<td class='<%=classValue%>'  width='7%'><font size=1><%=patient_name%></td>
		<td class='<%=classValue%>'  width='7%'><font size=1><%=Sex%></td>
		<td class='<%=classValue%>'  width='7%'><font size=1><%=nursing_unit_short_desc%></td>
		<td class='<%=classValue%>'  width='7%'><font size=1><%=bed_class_short_desc%></td>
		<td class='<%=classValue%>'  width='7%'><font size=1><%=bed_type_short_desc%></td>
		<td class='<%=classValue%>'  width='7%'><font size=1><%=bed_no%></td>
		<td class='<%=classValue%>'  width='7%'><font size=1><%=room_no%></td>
	
		<%
			tryl++;
			i++;
			p1++;
	} //end while
	   if(rs!=null) rs.close();
	   if(pstmt!=null)			pstmt.close();
     }
		}
		if((whereClause != null) && (whereClause.length() > 0))
		{
			whereClause.delete(0,whereClause.length());
		}

%></table>
<input type='hidden' name='CAInstalled' id='CAInstalled' value="<%=CAInstalled%>" >  
<input type="hidden" name= 'observe_id' value='<%=observe_id%>'>

<%	
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
</form>
</body>
</html>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
%>

