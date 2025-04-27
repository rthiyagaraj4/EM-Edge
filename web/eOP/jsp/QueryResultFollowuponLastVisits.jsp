<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html; charset=UTF-8" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<%

Connection conn  =null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
//ResultSet prs1 = null;	
ResultSet prs2 = null;
Statement stmt = null;
ResultSet rs = null;
try{
	conn  =  ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
    String locale=(String)session.getAttribute("LOCALE");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' onMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>");
  
	StringBuffer sql= new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int andCheck = 0;
	String endOfRes="1";
	String install_yn="";
	String date1="";
//	SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		
    String operatingfacilityid=(String)session.getValue("facility_id");
       if (operatingfacilityid==null)
           operatingfacilityid = "";
    String fromdate = request.getParameter("date_from");
            if (fromdate ==null)
                fromdate = "";
        String todate = request.getParameter("date_to" );
            if (todate ==null)
                todate = "";
        String speciality_code = request.getParameter("speciality_code");
            if (speciality_code ==null)
                speciality_code = "";
        String servicecode = request.getParameter("service_code");
            if (servicecode ==null)
                servicecode = "";
        String cliniccode = request.getParameter("clinic_code");
            if (cliniccode ==null)
                cliniccode = "";
        String practitionerid = request.getParameter("practitioner_id");
            if (practitionerid ==null)
                practitionerid = "";

		String pat_id = request.getParameter("pat_id");
		
            if (pat_id ==null)
                pat_id = "";
		String user = request.getParameter("user");
            if (user ==null)
                user = "";
		String visit_date = request.getParameter("visit_date");
            if (visit_date ==null)
                visit_date = "";
		
		if ( !(operatingfacilityid== null || operatingfacilityid.equals("")) )
                {
                sql.append(" WHERE c.language_id='"+locale+"'  and  a.patient_id = b.patient_id     AND a.recall_date IS NOT NULL    AND a.patient_class = 'OP' AND   operating_facility_id = '"+operatingfacilityid+"'  AND a.operating_facility_id = c.facility_id       AND a.assign_care_locn_code = c.clinic_code");
   
				
				//sql.append("where operating_facility_id like '"+operatingfacilityid+"%'" );
                andCheck = 1;
                }
        if ( !(fromdate  == null || fromdate.equals("")))
          {
              
		
				if ( andCheck == 1 )
            {
                sql.append(" and ");
                sql.append("recall_date >= to_date('"+fromdate+"','dd/mm/yyyy')");
            }
            else
            {
                sql.append("recall_date >=to_date( '"+fromdate+"','dd/mm/yyyy')" );
                andCheck = 1;
            }
		  }

    if ( !(todate== null || todate.equals("")) )
            {
                if ( andCheck == 1 )
            {
               sql.append( " and " );
               sql.append( "recall_date <=to_date('"+todate+"','dd/mm/yyyy')");
            }
            else
             {
               sql.append(" recall_date<= to_date('"+todate+"','dd/mm/yyyy')" );
               andCheck = 1;
             }
            }
			if ( !(speciality_code== null || speciality_code.equals("")))
			{
				if ( andCheck == 1 )
				{
					sql.append( " and " );
					sql.append( "speciality_code =  '"+speciality_code+"'" );
				}
				else
				{
					sql.append(" speciality_code = '"+speciality_code+"'" );
					  andCheck = 1;
				}

			}

			if ( !(servicecode== null || servicecode.equals("")))
			{
				if ( andCheck == 1 )
				{
					sql.append(" and " );
					sql.append( " a.service_code =  '"+servicecode+"'" );
				}
				else
				{
					sql.append( " a.service_code = '"+servicecode+"'") ;
					  andCheck = 1;
				}

			}

            if ( !(cliniccode== null || cliniccode.equals("")))
            {
                if ( andCheck == 1 )
                {
                    sql.append(" and " );
                    sql.append( "clinic_code =  '"+cliniccode+"'" );
                }
                else
                {
                     sql.append(" clinic_code = '"+cliniccode+"'" );
                      andCheck = 1;
                }

            }
        if ( !(practitionerid== null || practitionerid.equals("")))
        {
            if ( andCheck == 1 )
            {
                sql.append( " and " );
                sql.append( "ATTEND_PRACTITIONER_ID =  '"+practitionerid+"'" );
            }
            else
            {
               sql.append(" ATTEND_PRACTITIONER_ID = '"+practitionerid+"'" );
                  andCheck = 1;
            }

    }

	 if ( !(pat_id== null || pat_id.equals("")))
        {
            if ( andCheck == 1 )
            {
                sql.append( " and " );
                sql.append( "a.PATIENT_ID =  '"+pat_id+"'" );
            }
            else
            {
               sql.append(" a.PATIENT_ID = '"+pat_id+"'" );
                  andCheck = 1;
            }
	    }

		if ( !(user== null || user.equals("")))
        {
            if ( andCheck == 1 )
            {
                sql.append( " and " );
                sql.append( "a.ADDED_BY_ID =  '"+user+"'" );
            }
            else
            {
               sql.append(" a.ADDED_BY_ID = '"+user+"'" );
                  andCheck = 1;
            }
	    }


		if ( !(visit_date  == null || visit_date.equals("")))
          {
             if ( andCheck == 1 )
            {
                sql.append(" and ");
                sql.append("trunc(visit_adm_date_time) = to_date('"+visit_date+"','dd/mm/yyyy')");
            }
            else
            {
                sql.append("trunc(visit_adm_date_time) = to_date( '"+visit_date+"','dd/mm/yyyy')" );
                andCheck = 1;
            }
		  }


    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" order by " );
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql.append(ord[i]);
        else
           sql.append(ord[i]).append(",");
        }
    }

   
   
	String classValue = "" ;
	String curr_clinic_code = "";
	String prev_clinic_code = "";
	String curr_service_code = "";
	String prev_service_code = "";
	String patientid = "";
	String earliest_appt_date = ""; 
	String file_location = "";
	String date1_display = "";
	//String earliest_appt_date_display = "";
	int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 10 ;
    else
        end = Integer.parseInt( to ) ;

sql.append(" Order by clinic_desc, service_desc");

//int maxRecord = 1;
/*rs = stmt.executeQuery("select count(*) as total from op_fup_on_last_visit_vw  "+sql.toString());
//out.println("select count(*) as total from op_fup_on_last_visit_vw"+sql.toString());
rs.next();
maxRecord = rs.getInt("total");*/

if(rs != null) rs.close();

pstmt2=conn.prepareStatement("select install_yn from sm_module where module_id='FM'");
prs2=pstmt2.executeQuery();
		
		if(prs2 != null)
		{
			if(prs2.next())
			{
				install_yn=prs2.getString(1);
			}
		}
if(prs2 != null) prs2.close();
if(pstmt2 != null) pstmt2.close();

/*if(maxRecord == 0)					
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
else
	{*/

//rs = stmt.executeQuery("select visit_due_date, patient_name, gender, patient_id, contact_no, last_visit_date, clinic_desc, service_desc, practitioner_name, clinic_code, service_code from op_fup_on_last_visit_vw "+sql.toString());
//out.println("select visit_due_date, patient_name, gender, patient_id, contact_no, last_visit_date, clinic_desc, service_desc, practitioner_name, clinic_code, service_code from op_fup_on_last_visit_vw "+sql.toString());

//out.println(sql.toString());
rs = stmt.executeQuery("SELECT  TO_CHAR(a.recall_date,'dd/mm/yyyy') visit_due_date, decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, sex gender, a.patient_id, contact1_no contact_no,   TO_CHAR(visit_adm_date_time,'dd/mm/yyyy') last_visit_date, c.long_desc clinic_desc,    am_get_desc.AM_SERVICE(a.SERVICE_CODE,'"+locale+"',2)service_desc, am_get_desc.AM_PRACTITIONER(attend_practitioner_id,'"+locale+"',1) practitioner_name, assign_care_locn_code clinic_code,  a.service_code,sm_get_desc.SM_APPL_USER(a.ADDED_BY_ID,'en',1) user_name, (select TO_CHAR(MIN(APPT_DATE),'dd/mm/yyyy') from     oa_appt where   facility_id = a.operating_FACILITY_ID        AND PATIENT_ID = a.patient_id AND TRUNC(APPT_DATE) >= TRUNC(SYSDATE)) min_date     FROM  op_last_visit_for_service a, mp_patient b,op_clinic_lang_vw c "+sql.toString());



if ( start != 1 )
         for( int j=1; j<start; i++,j++ )
              rs.next() ;
	
int cnt=0;

while ( i<=end && rs.next() )
{
	if( cnt == 0 )
	{		
%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOP/jsp/QueryResultFollowuponLastVisits.jsp?from="+(start-10)+"&to="+(end-10)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( endOfRes.equals("1"))
    out.println("<A id='nextval' HREF='../../eOP/jsp/QueryResultFollowuponLastVisits.jsp?from="+(start+10)+"&to="+(end+10)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table><br>
</P>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="eOP.VisitDue.label" bundle="${op_labels}"/><br>(<fmt:message key="Common.Earliest.label" bundle="${common_labels}"/>)</th>
<th class='columnheader'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.contactNo.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eOP.LastVisitDate.label" bundle="${op_labels}"/></th>
<th class='columnheader'><fmt:message key="eOP.EarliestApptDate.label" bundle="${op_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eOP.FileCurrentLocation.label" bundle="${op_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.Visit.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>

<%

	} 
	 
        if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;
        else
            classValue = "QRYODD" ;

		if(i == 1)
		{
			curr_clinic_code = rs.getString("clinic_code");
			prev_clinic_code = rs.getString("clinic_code");
			curr_service_code = rs.getString("service_code");
			prev_service_code = rs.getString("service_code");

		    out.println("<tr><td colspan='9' align='left' class='CAGROUPHEADING'>&nbsp;<font size='1'>"+rs.getString(7)+" / "+rs.getString(8)+"</font></td></tr>");
		}

		curr_clinic_code = rs.getString("clinic_code");
		curr_service_code = rs.getString("service_code");

		if( (!curr_clinic_code.equals(prev_clinic_code)) || (!curr_service_code.equals(prev_service_code)) )
		{
			prev_clinic_code  = curr_clinic_code;
			prev_service_code = curr_service_code;

			out.println("<tr><td colspan='9' align='left' class='CAGROUPHEADING'>&nbsp;<font size='1'>"+rs.getString("clinic_desc")+" / "+rs.getString("service_desc")+"</font></td></tr>");
		}

        patientid = rs.getString("patient_id");
	
	/*	pstmt1 = conn.prepareStatement("Select to_char(min(APPT_DATE),'dd/mm/yyyy') min_date from OA_APPT WHERE FACILITY_ID = '"+operatingfacilityid+"' AND PATIENT_ID = '"+patientid+"' and APPT_DATE >= trunc(sysdate)");
		prs1 = pstmt1.executeQuery();
		if(prs1.next())
		{*/
			earliest_appt_date = rs.getString("min_date")==null?"":rs.getString("min_date");
			if(!earliest_appt_date.equals(""))
			{
				earliest_appt_date = DateUtils.convertDate(earliest_appt_date,"DMY","en",locale);
			}	
		/*}*/

		//if(prs1 != null) prs1.close();
		//if(pstmt1 != null) pstmt1.close();

// SELECT INSTALL_YN FROM SM_MODULE WHERE MODULE_ID = 'FM';
// IF INSTALL_YN = 'Y', PROCEED ELSE SKIP.
		
		if(install_yn.equals("Y"))
		{
		pstmt2 = conn.prepareStatement("SELECT B.SHORT_DESC CURR_FS_LOCN_SHORT_DESC FROM FM_CURR_LOCN A, FM_STORAGE_LOCN B WHERE A.FACILITY_ID = '"+operatingfacilityid+"' AND A.PATIENT_ID = '"+patientid+"' AND A.CURR_FACILITY_ID = B.FACILITY_ID AND A.CURR_FS_LOCN_CODE = B.FS_LOCN_CODE");
		prs2 = pstmt2.executeQuery();
		file_location = "&nbsp;";
		if(prs2.next())
		{
			file_location = prs2.getString(1);
			if(file_location == null || file_location.equals("null"))
				file_location = "&nbsp;";
		}

		if(prs2 != null) prs2.close();
		if(pstmt2 != null) pstmt2.close();
		}

        out.println("<tr><td align=='left' class='" + classValue + "'>");
        date1 = rs.getString("visit_due_date")==null?"":rs.getString("visit_due_date");
		if(!date1.equals(""))
		{	
			date1_display = DateUtils.convertDate(date1,"DMY","en",locale);
        }

       // String dateString="";
        /* if(date1==null)
            dateString ="&nbsp";
         else
            dateString = formatter.format(date1_display);*/
		/*
		if(!earliest_appt_date.equals(""))
			date1_display = earliest_appt_date;
		*/

		if(!date1_display.equals(""))
	        out.println(date1_display);
		else
			 out.println("&nbsp;");

        out.println("</td><td class='" + classValue + "' nowrap>");
        String pname=rs.getString(2);
        if (pname==null)
        pname="";
        out.println(pname);

        out.println("</td><td class='" + classValue + "'>");
        out.println(patientid);

        out.println("</td><td align='center' class='" + classValue + "'>");
        String contactno=rs.getString(5);
        if (contactno==null)
        {
			contactno="&nbsp;";
			out.println("&nbsp;");
		}
		else
        out.println(contactno);

        out.println("</td><td align='center' class='" + classValue + "'>");
        date1 = rs.getString("last_visit_date");
		if(!date1.equals(""))
		{	
			date1_display = DateUtils.convertDate(date1,"DMY","en",locale);
        }
		//dateString = formatter.format(date1_display);
        out.println(date1_display);

        out.println("</td><td class='" + classValue + "'>");

		if(!earliest_appt_date.equals(""))
	        out.println(earliest_appt_date);
		else
			out.println("&nbsp;");

        out.println("</td><td class='" + classValue + "' nowrap>");
        String prname=rs.getString(9);
        if (prname==null)
        prname="&nbsp;";
        out.println(prname);

		out.println("</td><td class='" + classValue + "' nowrap>");
        out.println(file_location);
		out.println("</td><td class='" + classValue + "' nowrap>");
        out.println(rs.getString("user_name"));

		out.println("</td></tr>");
        i++;
		cnt++;
	}

   if (!rs.next() && cnt!=0 )
    {
    endOfRes = "0";	
	%>
		<script>
		document.getElementById("nextval").innerHTML=" ";
		//document.getElementById("nextval").style.visibility='hidden';
		</script>
		<!--<tr>
			<td class='labelcenter' colspan='12'><fmt:message key="Common.EndofResults.label" bundle="${common_labels}"/></td>
		</tr>-->
	<%
 }

//}
if(rs!=null)rs.close();
if(stmt != null) stmt.close();

sql.setLength(0);

if( cnt == 0 ){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
}

}
catch(Exception e){
	out.println(e);
	e.printStackTrace();
	}
finally{
out.println("<script>parent.frames[0].query_form.search.disabled=false;</script>");
if(stmt!=null)stmt.close();
if(rs!=null)rs.close();

if(pstmt1!=null)pstmt1.close();
if(pstmt2!=null)pstmt2.close();

if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

%>

</td></tr>
</table>
</center>

<br><center>

</center>
</BODY>
</HTML>

