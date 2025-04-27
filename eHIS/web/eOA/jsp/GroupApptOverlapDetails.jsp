<!DOCTYPE html>

 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>	
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- Below Style For Fixed Header with scroll.... -->
	
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
	<script type="text/javascript">
	window.onload = function () { 
		if(document.getElementById("Overlap_appt_dtls")!=null){
			fxheaderInit('Overlap_appt_dtls',350);
		}
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

 <table border="1" width="100%" cellspacing='0' cellpadding='0' id="Overlap_appt_dtls">
   
 	      <tr >
			<td width="15%" class='COLUMNHEADER' nowrap style="height:25px"> <fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
			<td width="15%" class='COLUMNHEADER' nowrap style="height:25px"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td width="50%" class='COLUMNHEADER' nowrap style="height:25px"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		    <td width="15%" class='COLUMNHEADER' nowrap style="height:25px"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>	
	      </tr>

<%
		Connection con = null;
		Statement	stmt		=null;
		PreparedStatement pstmt=null;
		ResultSet	rs			=null;
		request.setCharacterEncoding("UTF-8");
			
		String slapfromTime=checkForNull(request.getParameter("fromTime"));
        String slaptoTime=checkForNull(request.getParameter("toTime"));
        String group_id=checkForNull(request.getParameter("group_id"));
        String appt_Date=checkForNull(request.getParameter("apptDate"));
		String location=checkForNull(request.getParameter("location"));
		
		String classValue="";
		String name	="";
		String pat_id	="";
		String app_no="";
		String fromTime	="";
		String toTime="";
		String Locationdesc="";
		//String group_Name="";
		int i=0;
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
       try{
       con = ConnectionManager.getConnection(request);
	   stmt=con.createStatement();
		/*rs = stmt.executeQuery("SELECT APPT_REF_NO,nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time,nvl(to_char(appt_slab_to_time,'hh24:mi'),' ') appt_slab_to_time,PATIENT_NAME,PATIENT_ID  FROM oa_appt where GROUP_ID='"+group_id+"' and practitioner_id='"+prac_id+"' AND ( TRUNC (appt_date) = TRUNC (to_date('"+app_date+"','dd/mm/yyyy')))");*/
		
		//String query="SELECT APPT_REF_NO,op_get_desc.op_clinic(facility_id,CLINIC_CODE,'"+locale+"',1) current_location,nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time,nvl(to_char(appt_slab_to_time,'hh24:mi'),' ') appt_slab_to_time,PATIENT_NAME,PATIENT_ID  FROM oa_appt WHERE facility_id = '"+fac_id+"'   AND ((TO_DATE('"+slapfromTime+"','HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE ('"+slaptoTime+"', 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE ('"+slapfromTime+"', 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'),'hh24:miss') < TO_DATE ('"+slaptoTime+"', 'hh24:miss'))) AND appt_date = TO_DATE ('"+appt_Date+"', 'dd/mm/yyyy')   AND patient_id IN (SELECT patient_id FROM oa_group_dtls where group_id = '"+group_id+"' )  and CLINIC_CODE not in('"+location+"')";
		String query="SELECT APPT_REF_NO,op_get_desc.op_clinic(facility_id,CLINIC_CODE,?,1) current_location,nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time,nvl(to_char(appt_slab_to_time,'hh24:mi'),' ') appt_slab_to_time,PATIENT_NAME,PATIENT_ID  FROM oa_appt WHERE facility_id = ? AND ((TO_DATE(?,'HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE (?, 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE (?, 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'),'hh24:miss') < TO_DATE (?, 'hh24:miss'))) AND appt_date = TO_DATE (?, 'dd/mm/yyyy') AND patient_id IN (SELECT patient_id FROM oa_group_dtls where group_id = ? )  and CLINIC_CODE not in(?)";
	
		//rs = stmt.executeQuery(query);
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,locale);
		pstmt.setString(2,fac_id);
		pstmt.setString(3,slapfromTime);
		pstmt.setString(4,slaptoTime);
		pstmt.setString(5,slapfromTime);
		pstmt.setString(6,slaptoTime);
		pstmt.setString(7,appt_Date);
		pstmt.setString(8,group_id);
		pstmt.setString(9,location);
		rs = pstmt.executeQuery();
		while(rs.next()){			
			if ( i % 2 == 0 ){
			  classValue = "QRYEVEN" ;
			}else{
			  classValue = "QRYODD" ;
			}			  
		        app_no=checkForNull(rs.getString("APPT_REF_NO"));
				name=checkForNull(rs.getString("PATIENT_NAME"));
				pat_id=checkForNull(rs.getString("PATIENT_ID"));
				fromTime=checkForNull(rs.getString("appt_slab_from_time"));
				toTime=checkForNull(rs.getString("appt_slab_to_time"));				
				Locationdesc=checkForNull(rs.getString("current_location"));
			
		%>
	<tr>
		<td  class='<%=classValue%>' width="15%" nowrap ><%=app_no%></td>
		<td  class='<%=classValue%>'  width="15%" nowrap   ><%=pat_id%></td>
		<td  class='<%=classValue%>'  width="50%" wrap  ><%=name%></td>		
		<td  class='<%=classValue%>' width="15%" nowrap  ><%=Locationdesc%></td>
    </tr> 
	<%	
			i++;
		
	}
			
 
  if(i == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
window.close();</script>
<%}
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}catch(Exception e)
	{
	//out.println("one L :" +e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</table>

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

