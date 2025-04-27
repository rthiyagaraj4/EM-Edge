<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
//String p_patient_id="";
String p_locn_desc="";
String p_locn_type_desc="";
String p_status="";
String p_prior_locn_desc	= "";
String p_prior_locn_type_desc = "";
String p_date_time	= "";
String p_notes	= "";


StringBuffer sql=new StringBuffer();
//String p_encounter_id	= request.getParameter("Encounter_Id");
String patid=request.getParameter("Patient_ID");
String facilityid=request.getParameter("facilityid");
String room_num="";

%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown = 'lockKey();'>
<div align='center' >
<script>
 function closew()
  {
	  window.parent.close();
  }
  </script>

<%
	
	PreparedStatement pstmt = null;
	ResultSet rs		= null;
	Connection conn = null;
	//String fac_id    	= (String) session.getValue( "facility_id" ) ;
try {
	conn=ConnectionManager.getConnection(request);
	sql.append("select  patient_id, SUBSTR(curr_locn_desc,1,INSTR(curr_locn_desc,'**')-1) current_locn_desc, SUBSTR(curr_locn_desc, INSTR(curr_locn_desc,'**')+2) current_locn_type_desc, STATUS, SUBSTR(PRIOR_LOCN_DESC,1,INSTR(PRIOR_LOCN_DESC,'**')-1) prior_locn_desc, SUBSTR(PRIOR_LOCN_DESC,INSTR(PRIOR_LOCN_DESC,'**')+2) prior_locn_type_desc, to_char(DATE_TIME,'dd/mm/yyyy  hh24:mi') date_time, TRACKING_NOTES  notes, patient_tracking_status,room_num  from op_patient_tracking_locn_vw  where operating_facility_id='"+facilityid+"' and patient_id = '"+patid+"'");
	
	pstmt=conn.prepareStatement(sql.toString());	
	rs=pstmt.executeQuery();
   rs.next();

  //  p_patient_id=rs.getString("patient_id");
    p_locn_desc=rs.getString("current_locn_desc");
    if (p_locn_desc==null)
         p_locn_desc="";
    p_locn_type_desc=rs.getString("current_locn_type_desc");
     if (p_locn_type_desc==null)
        p_locn_type_desc="";
    p_status=rs.getString("STATUS");
     if (p_status==null)
        p_status="";
    p_date_time 	= rs.getString("date_time");
    if (p_date_time==null)
        p_date_time="";
    p_prior_locn_desc  =rs.getString("prior_locn_desc");
     if (p_prior_locn_desc==null)
        p_prior_locn_desc="";
    p_prior_locn_type_desc	= rs.getString("prior_locn_type_desc");
     if (p_prior_locn_type_desc==null)
        p_prior_locn_type_desc="";
    p_notes	= rs.getString("notes");
     if (p_notes==null)
        p_notes="";
        
        
        
      room_num=rs.getString("room_num");

     if ((room_num == null) || (room_num.equals("*ALL")) || (room_num).equals("null"))
      room_num="";


   if (rs!=null){
	out.println("<table width='80%' cellspacing='0' cellpadding='0' border='0'>");
	out.println("<td class='BORDER'>");
	out.println("<table width='100%' cellpadding='0' cellspacing='0' align='left'  BORDER='0'>");
	out.println("<tr><td width='50%'   align='right' class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td  align='left' width ='50%'  class='QUERYDATA'><br>"+p_locn_desc+" / " +p_locn_type_desc+ "</td></tr>");	
	
	//added by smita for room number display on 03-02-04
	if (!( rs.getString("patient_tracking_status").equals("T")))
	{
	if(!(room_num.equals("")) )
			{
			out.println("<tr><td width='50%' align='right' class='label' nowrap><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
			out.println("<td align='left' width='50%' class='QUERYDATA'><br>"+room_num+"</td></tr>");
			}	
	}
	
	out.println("<tr><td width='50%'  align='right'  class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td   align='left' width ='50%'  class='QUERYDATA'><br>"+p_status+"</td></tr>");
	out.println("<tr><td width='50%'  align='right' class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td align='left' width ='50%'  class='QUERYDATA'><br>"+p_date_time+"</td></tr> ");
	if ( rs.getString("patient_tracking_status").equals("T"))
	{
	out.println("<tr><td width='50%'  align='right' class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.PriorLocation.label","op_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td  align='left' width ='50%'  class='QUERYDATA'><br>"+p_prior_locn_desc+" / "+p_prior_locn_type_desc+"</td></tr>");

	
		if(!(room_num.equals("")))
		{
		out.println("<tr><td width='50%' align='right' class='label' nowrap><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		out.println("<td align='left' width='50%' class='QUERYDATA'><br>"+room_num+"</td></tr>");
		}	

	
	out.println("<tr><td width='50%' valign='top' align='right' class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td  align='left' width ='50% ' class='QUERYDATA'><br>"+p_notes+"</td></tr>");
    }

    out.println("</table></table>");
}
else
{
	out.println("<table width='80%' cellspacing='0' cellpadding='0'>");
	out.println("<tr><td class='BORDER'>");
	out.println("<table width='100%'cellpadding='0' cellspacing='0' align='left'  BORDER='0'>");
	out.println("<tr><td width='50%'   class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
    out.println("<tr><td width='50%'   class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
    out.println("<tr><td width='50%'   class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>");
        if ( rs.getString("patient_tracking_status").equals("T"))
			{
			out.println("<tr><td width='50%'  class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.PriorLocation.label","op_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
			out.println("<tr><td width='50%'  class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>");
            }
         out.println("</table></table>");
}

}
catch ( Exception e ){out.println(e.toString());}
finally{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	sql=null;
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>
<div>
</body>
</html>

