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
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script>
	<script type="text/javascript">
	window.onload = function () { 
		if(document.getElementById("Patient_Queue_dtls")!=null){
			fxheaderInit('Patient_Queue_dtls',500);
		}
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

 <table border="1" width="100%" cellspacing='0' cellpadding='0' id="Patient_Queue_dtls">
   
 	      <tr >
			<td width="15%" class='columnheader' nowrap style="height:25px"> <fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
			<td width="20%" class='columnheader' nowrap style="height:25px"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
			<!--Below Modified for Regression-PAS-OP Transaction- Register Visit-->
			<td width="15%" class='columnheader' nowrap style="height:25px"><fmt:message key="eOP.TotalVisits.label" bundle="${op_labels}"/></td>
		    <td width="20%" class='columnheader' nowrap style="height:25px"><fmt:message key="eOP.VisitsConsulted.label" bundle="${op_labels}"/></td>	
			<td width="20%" class='columnheader' nowrap style="height:25px"><fmt:message key="eOP.PendingConsult.label" bundle="${op_labels}"/></td>
	      </tr>

<%
		Connection con = null;
		Statement	stmt		=null;
		ResultSet	rs			=null;
		request.setCharacterEncoding("UTF-8");
			
        String clinic_code=checkForNull(request.getParameter("clinic_code"));
       
		
		String classValue="";
		String name	="";
		String pract_id	="";
		String totalvisits="";
		String consultedvisit	="";
		String pendingvisit="";
		int i=0;
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
       try{
       con = ConnectionManager.getConnection(request);
	   stmt=con.createStatement();
		
		String query="SELECT   a.practitioner_id pract_id,am_get_desc.am_practitioner (a.practitioner_id, '"+locale+"', 2) pract_name,COUNT (a.practitioner_id) total_visits,SUM (CASE WHEN a.queue_status >= 04 THEN 1 ELSE 0 END) visit_consulted,SUM (CASE WHEN a.queue_status < 04 THEN 1 ELSE 0 END ) visit_pending_for_consult FROM op_patient_queue a WHERE a.facility_id = '"+fac_id+"' AND a.locn_code = '"+clinic_code+"' and a.practitioner_id <> '*ALL' AND TO_CHAR (a.queue_date, 'dd/mm/yyyy') =TO_CHAR (SYSDATE, 'dd/mm/yyyy') and queue_Status <> 99 and patient_class = 'OP' GROUP BY a.practitioner_id,am_get_desc.am_practitioner (a.practitioner_id, '"+locale+"', 2) order by 2";
		
		rs = stmt.executeQuery(query);
		while(rs.next()){			
			if ( i % 2 == 0 ){
			  classValue = "QRYEVEN" ;
			}else{
			  classValue = "QRYODD" ;
			}			  
		        pract_id=checkForNull(rs.getString("pract_id"));
				name=checkForNull(rs.getString("pract_name"));
				totalvisits=checkForNull(rs.getString("total_visits"));
				consultedvisit=checkForNull(rs.getString("visit_consulted"));
				pendingvisit=checkForNull(rs.getString("visit_pending_for_consult"));				
			
			
		%>
	<tr>
		<td  class='<%=classValue%>' width="15%" nowrap ><%=pract_id%></td>
		<td  class='<%=classValue%>'  width="20%" nowrap   ><%=name%></td>
		<td  class='<%=classValue%>'  width="15%" wrap  ><%=totalvisits%></td>		
		<td  class='<%=classValue%>' width="20%" nowrap  ><%=consultedvisit%></td>
		<td  class='<%=classValue%>' width="20%" nowrap  ><%=pendingvisit%></td>
    </tr> 
	<%	
			i++;
		
	}
			
 
  if(i == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
parent.parent.document.getElementById("dialog_tag").close();</script>
<%}
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}catch(Exception e)
	{
	out.println("one L :" +e.toString());
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

