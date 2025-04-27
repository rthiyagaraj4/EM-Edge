<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eAE/js/AESearchVisit.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<% 
request.setCharacterEncoding("UTF-8");
String PatientID=request.getParameter("patientid");
String p_mode=request.getParameter("pmode");
String sql=request.getParameter("where_criteria");
String max_days=request.getParameter("max_days");
String patient_id= "";
String DateTime="";
String QueueStatus="";
String Location="";
String VisitType="";
String Practitioner="";
String Encounter_id="";
int i=0;
StringBuffer sqlBuf = new StringBuffer();
sqlBuf.append(sql);
if (p_mode == null)
    p_mode = "";

    if  (!PatientID.equals(""))
     sqlBuf.append(" and PATIENT_ID='"+PatientID+"' and patient_class = 'EM'");

   if (p_mode.equals("CANCELVISIT") || p_mode.equals("REVISEVISIT" ) )
   {
   sqlBuf.append(" and queue_status in('01','02','03')  and   (sysdate-visit_adm_date_time) < "+max_days+" ");
   }
Connection conn=null;

String facilityId = (String) session.getValue( "facility_id" ) ;
PreparedStatement pstmt	= null ;
ResultSet rs=null;

try{
	conn=ConnectionManager.getConnection(request);
    StringBuffer strsql2 = new StringBuffer();
	strsql2.append("select  encounter_id,to_char(visit_adm_date_time,");
	strsql2.append("'dd/mm/yyyy hh24:mi')visit_adm_date_time,");
	strsql2.append("decode(queue_status_desc,'Arrived at Nursing Station','Assigned to Treatment Area',queue_status_desc) queue_status_desc,");
	strsql2.append(" clinic_desc, visit_type_desc,practitioner_name,");
	strsql2.append(" to_char(queue_date,'dd/mm/yyyy'), patient_id  from     Pr_Search_visit_vw ");
	strsql2.append(" where   facility_id = ? ");
	strsql2.append(sqlBuf.toString());
	strsql2.append("order by to_date(visit_adm_date_time,'dd/mm/yyyy hh24:mi') desc");
    pstmt = conn.prepareStatement(strsql2.toString());
	pstmt.setString(1, facilityId);
	rs = pstmt.executeQuery();
rs.next();
%>
<BR>
<table border="0" width="100%" cellspacing='0' cellpadding='0' align='center'>
  <tr width='100%' >
<td><B><fmt:message key="eAE.VisitDetail.label" bundle="${ae_labels}"/></B></td>
</tr>
<tr>
<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1' align='center'>
<tr>
<th><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
<th> <fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></th>
<th> <fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
<th> <fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
<th> <fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
</tr>
<%
String rowclass = "" ;
do
{
    if ( i % 2 == 0 )
        rowclass = "QRYEVEN" ;
    else
        rowclass = "QRYODD" ;

   Encounter_id=String.valueOf(rs.getLong(1));/*Changed from String to Long*/
   DateTime = rs.getString(2);
   QueueStatus=rs.getString(3);
   Location=rs.getString(4);
   VisitType=rs.getString(5);
   Practitioner=rs.getString(6);
   patient_id = rs.getString(8);

   if (Practitioner == null)
    Practitioner = "&nbsp;";

    out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");
    %>
    <a   href="javascript:closew('<%=Encounter_id%>','<%=patient_id%>');">
    <%
    out.println(DateTime+"</a></td><td  class='"+rowclass+"'>");
    out.println(QueueStatus+"</td><td  class='"+rowclass+"'>");
    out.println(Location+"</td><td  class='"+rowclass+"'>");
    out.println(VisitType+"</td><td  class='"+rowclass+"'>");
    out.println(Practitioner+"</td></tr>" );

i++;
  }while ( rs.next());
 if(pstmt != null) pstmt.close();
 if(rs != null)  rs.close();
 if((strsql2 != null) && (strsql2.length() > 0))
 {
	strsql2.delete(0,strsql2.length());
 } 
 if((sqlBuf != null) && (sqlBuf.length() > 0))
 {
	sqlBuf.delete(0,sqlBuf.length());
 } 
}catch(Exception e)
{
		e.printStackTrace();
} 
    finally
    {
         if(conn!=null) ConnectionManager.returnConnection(conn,request);
     }
%>
</table>
</tr>
</table>
</BODY>
</HTML>

