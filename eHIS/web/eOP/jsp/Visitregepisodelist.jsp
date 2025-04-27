<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eOP/js/VisitRegPatientVisits.js'></script>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<%
String Facility_Id = (String) session.getValue("facility_id");
String patid=request.getParameter("patid");
String mrnno=request.getParameter("mrnno");
String enctid=request.getParameter("enctid");
String dtfrm=request.getParameter("dtfrm");
String dtto=request.getParameter("dtto");
String serv=request.getParameter("serv");
String loc=request.getParameter("loc");
String pract=request.getParameter("pract");
String mode=request.getParameter("mode");
if(mrnno==null) mrnno="";
if(enctid==null) enctid="";
if(dtfrm==null) dtfrm="";
if(dtto==null) dtto="";
if(serv==null) serv="";
if(loc==null) loc="";
if(pract==null) pract="";
if(mode==null) mode="";

String params="patid="+patid+"&mrnno="+mrnno+"&mode="+mode+"&enctid="+enctid+"&dtfrm="+dtfrm+"&dtto="+dtto+"&serv="+serv+"&loc="+loc+"&pract="+pract;
String where_criteria = "";
String and_yn = "";

// patient_id 
if (!patid.equals(""))
{
    where_criteria  = "patient_id = '"+patid+"'";
    and_yn = " and ";
}
//MRN
if (!mrnno.equals(""))
{
    where_criteria  = where_criteria + and_yn+ " patient_id in(select patient_id from mr_pat_file_index "+
    " where facility_id='"+Facility_Id+"' and file_no ='"+mrnno+"')";
    and_yn = " and ";
}
//Encounter ID
if (!enctid.equals(""))
{
    where_criteria  = where_criteria + and_yn+ "encounter_id ='"+ enctid +"'";
    and_yn = " and ";
}
// Date From
if (!dtfrm.equals(""))
{
    where_criteria  = where_criteria + and_yn+"trunc(visit_adm_date_time) >= to_date('"+dtfrm+"','dd/mm/yyyy')";
    and_yn = " and ";
}
// To
if (!dtto.equals(""))
{
    where_criteria  = where_criteria + and_yn+"trunc(visit_adm_date_time) <= to_date('"+dtto+"','dd/mm/yyyy')";
    and_yn = " and ";
}
//Service
if (!serv.equals(""))
{
    where_criteria  = where_criteria + and_yn+ "service_code ='"+ serv +"'";
    and_yn      = " and ";
}
//Clinic
if (!loc.equals(""))
{
    where_criteria  = where_criteria + and_yn+ "assign_care_locn_code ='"+loc+"'";
    and_yn      = " and ";
}
//Practitioner
if (!pract.equals(""))
{
    where_criteria  = where_criteria + and_yn+ "attend_practitioner_id='"+pract+"'";
    and_yn      = " and ";
}

//Connection conn = (Connection) session.getValue( "connection" );
Connection conn =  ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rset=null;
String sql1="";

try{
    stmt = conn.createStatement();
    
    sql1 = sql1 + "select to_char(episode.start_date_time,'dd/mm/yyyy') start_date_time,";
    sql1 = sql1 + "to_char(episode.end_date_time,'dd/mm/yyyy') end_date_time,";
    sql1 = sql1 + "service.short_desc,subservice.short_desc, clinic.long_desc clinic_desc,";
    sql1 = sql1 + "episode.episode_id from op_episode_for_service episode,am_service service,";
    sql1 = sql1 + "am_subservice subservice,op_clinic clinic ";
    sql1 = sql1 + "where episode.operating_facility_id='"+Facility_Id+"' ";
    sql1 = sql1 + "and service.service_code(+) = episode.service_code ";
    sql1 = sql1 + "and subservice.service_code(+) = episode.subservice_code ";
    sql1 = sql1 + "and subservice.subservice_code(+) = episode.subservice_code ";
    sql1 = sql1 + "and clinic.facility_id = episode.operating_facility_id "; 
    sql1 = sql1 + "and clinic.clinic_code = episode.clinic_code ";
    sql1 = sql1 + "and episode.patient_id = '"+patid+"' ";
	sql1 = sql1 + "and episode.episode_status = '01' ";
	sql1 = sql1 + "and episode.SERVICE_CODE = '"+serv+"' ";
    sql1 = sql1 + "and episode.episode_id in (select episode_id from pr_encounter ";
    sql1 = sql1 + "where facility_id = '"+Facility_Id+"' and "+where_criteria+") order by 1 desc";


    rset = stmt.executeQuery(sql1);


    

%>
<form name="episodetab_form" id="episodetab_form">
    <table border='0' cellpadding='0' cellspacing='0' width='94%' align='center'>
    <tr><td align='center'>
    <table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
    <td class='columnheader' align='center'>&nbsp;&nbsp;</td>    
    <td class='columnheader' align='center'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
    <td class='columnheader' align='center'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
    <td class='columnheader' align='center'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
    <td class='columnheader' align='center'><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
    <td class='columnheader' align='center'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

    <%

    String classValue = "";

    String fld1="";
    String fld2="";
    String fld3="";
    String fld4="";
    String fld5="";
    String fld6="";

    int i = 0;
    if(rset != null) {
        while(rset.next())
        {
            if ( i%2 == 0 )
                classValue="QRYEVEN";
            else
                classValue="QRYODD";

            fld1=rset.getString(1); if(fld1 == null) fld1="";
            fld2=rset.getString(2); if(fld2 == null) fld2="";
            fld3=rset.getString(3); if(fld3 == null) fld3="";
            fld4=rset.getString(4); if(fld4 == null) fld4="";
            fld5=rset.getString(5); if(fld5 == null) fld5="";
            fld6=rset.getString(6); if(fld6 == null) fld6="";
            
            String row =  "<tr><td  class='" + classValue + "'>";
            row = row + "<a href = javascript:dispnotes('"+fld6+"')> + </td>";
            row = row + "<td  class='" + classValue + "'>";
            row = row + "<a href = javascript:dispvisit('"+params+"','"+fld6+"')>" + fld1 + "</td>";
            row = row + "<td  class='" + classValue + "'>" + fld2 + "</td>";
            row = row + "<td  class='" + classValue + "'>" + fld3 + "</td>";
            row = row + "<td  class='" + classValue + "'>" + fld4 + "</td>";
            row = row + "<td  class='" + classValue + "'>" + fld5 + "</td></tr>";

            out.print(row);
            //out.println("<tr><td  class='" + classValue + "'><a href = javascript:modify('"+dsrl_no+"')>" + ddate + "</td><td  class='" + classValue + "'><a href=javascript:modify('"+dsrl_no+"')>" + ddetail + "</td></tr>");
            i++;
        }
    }

}
catch(Exception e){out.println("Excep EPISODE:"+e);
}
finally
{
//Added by Raj when dealing with unclosed connections, statements and resultsets on 10/17/2003
if(rset!=null)rset.close();
if(stmt!=null)stmt.close();

if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
    %>

    </table>
    </td></tr>
    </table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
</form>

</html>


