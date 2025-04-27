<!DOCTYPE html>


<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
 <%
 request.setCharacterEncoding("UTF-8"); 
 request= new XSSRequestWrapper(request);
 response.addHeader("X-XSS-Protection", "1; mode=block");
 response.addHeader("X-Content-Type-Options", "nosniff");
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<!-- Added by Dharma on Feb 10th 2014 against PMG2014-MOD-CRF-0002 [IN:050447] Start-->
		<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Supporting Js File For Fixed Header with scroll.... -->
		<script>
	
			function fnPageLoad(){
				if(document.getElementById("Tabledata")!=null && document.getElementById("dataCount").value > 0){			
					fxheaderInit('Tabledata',400);
					var row = document.getElementById("Tabledata").rows;
					row[row.length-1].scrollIntoView(false);
				}
				
			}
		</script>

		<!-- Added by Dharma on Feb 10th 2014 against PMG2014-MOD-CRF-0002 [IN:050447] End-->
</head>

<!--fnPageLoad() function Added by Dharma on Feb 10th 2014 against PMG2014-MOD-CRF-0002 [IN:050447] -->
<body onload="fnPageLoad();">

 <form name="patientnotes" id="patientnotes" method="post"  action='../../servlet/eMP.PatientNotesServlet' target="messageFrame">
   
	

	 <%
	 
		 String patientid=request.getParameter("patientid")== null?"":request.getParameter("patientid");
		/*Below Variables Commented by Dharma for checkstyle execution against PMG2014-MOD-CRF-0002 [IN:050447] Start*/
		// String facility_id = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
		// String addedby_notes=""; String addedby_id="";   //java.sql.Date addedby_date="";
		// String addedby_date=""; 
		 /*Below Variables Commented by Dharma for checkstyle execution against PMG2014-MOD-CRF-0002 [IN:050447] End*/
		 String locale = (String) session.getValue("LOCALE");
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 try{
			conn = ConnectionManager.getConnection(request);		
			int cnt = 0;
			 int i=1;	
	 %>
		<!--Modified by Dharma on Feb 10th 2014 against PMG2014-MOD-CRF-0002 [IN:050447] Start-->
			<!-- <table align=center border="1" width="100%" cellspacing='0' cellpadding='3'>	-->
			 <table  border="1" width="100%" cellpadding='3' style='border-spacing:0px ;border-collapse: collapse;' id='TableData'>
			 <!--Modified by Dharma on Feb 10th 2014 against PMG2014-MOD-CRF-0002 [IN:050447] End>-->
			 <tr>
			  <td class='columnheader' align = center nowrap width="40%"><fmt:message key="eMP.RecentNotes.label" bundle="${mp_labels}"/></td>	
			  <td class='columnheader' align = center nowrap width="20%"><fmt:message key="eAE.AddedBy.label" bundle="${ae_labels}"/> 
			  <fmt:message key="eDR.Dateandtime.label" bundle="${dr_labels}"/></td>

			  <!--Added by Ashwini on 24-Jan-2017 for ML-MMOH-CRF-0619-->
			  <td class='columnheader' align = center nowrap width="10%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>

			  <!--Added by Ashwini on 24-Jan-2017 for ML-MMOH-CRF-0619-->
			  <td class='columnheader' align = center nowrap width="10%"><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></td>
			  </tr>
			  <%
			 /*Modified by Dharma on Feb 10th 2014 against PMG2014-MOD-CRF-0002 [IN:050447] Start*/ 
			//String sql1="select NOTES,sm_get_desc.SM_APPL_USER(ADDED_BY_ID,'"+locale+"',1) user_name,to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') addeddate,ADDED_DATE from MP_PATIENT_NOTES  where patient_id='"+patientid+"' order by ADDED_DATE desc";	
		
			 String sql1="select NOTES,sm_get_desc.SM_APPL_USER(ADDED_BY_ID,'"+locale+"',1) user_name,to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') addeddate,ADDED_DATE,ENCOUNTER_ID,TO_CHAR (encounter_date_time, 'dd/mm/yyyy hh24:mi')  ENCOUNTER_DATE_TIME from MP_PATIENT_NOTES  where patient_id='"+patientid+"' order by ADDED_DATE asc";
			 /*Modified by Dharma on Feb 10th 2014 against PMG2014-MOD-CRF-0002 [IN:050447] End*/
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();	
				/*Modified by Dharma on Feb 10th 2014 against PMG2014-MOD-CRF-0002 [IN:050447] Start*/ 
			   //while(i<=5 && rs.next() ){
				if(rs!=null){
					while(rs.next()){
					/*Modified by Dharma on Feb 10th 2014 against PMG2014-MOD-CRF-0002 [IN:050447] End*/
				
						String classValue="";
						if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
						else
					   classValue = "QRYODD" ;
						String notes="";
						String user_name="";
						String addeddate = "";	
						String ENCOUNTER_ID = "";
						String ENCOUNTER_DATE_TIME = "";
		
						notes					= rs.getString("NOTES")==null?"":rs.getString("NOTES");    
						user_name					= rs.getString("user_name")==null?"":rs.getString("user_name");    				   
						addeddate					= rs.getString("addeddate")==null?"":rs.getString("addeddate"); 
						
						//Added by Ashwini on 24-Jan-2017 for ML-MMOH-CRF-0619
						ENCOUNTER_ID					= rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");  
						
						//Added by Ashwini on 24-Jan-2017 for ML-MMOH-CRF-0619
						ENCOUNTER_DATE_TIME					= rs.getString("ENCOUNTER_DATE_TIME")==null?"":rs.getString("ENCOUNTER_DATE_TIME");  
						
						String addeddatedisplay=DateUtils.convertDate(addeddate,"DMYHMS","en",locale);
						out.println("<tr>");					
						out.println("<td  style='word-wrap: break-word;width:410px;FONT-SIZE:8pt;' class='" + classValue + "'>");					
						out.println(notes+"</td>");	
						out.println("<td style='word-wrap: break-word;width:175px;FONT-SIZE:8pt;' class='" + classValue + "'>");					
						out.println(user_name+"   " +addeddatedisplay+"</td>");
						
						//Added by Ashwini on 24-Jan-2017 for ML-MMOH-CRF-0619
						out.println("<td  style='word-wrap: break-word;width:175px;FONT-SIZE:8pt;' class='" + classValue + "'>");					
						out.println(ENCOUNTER_ID+"</td>");	

						//Added by Ashwini on 24-Jan-2017 for ML-MMOH-CRF-0619
						out.println("<td  style='word-wrap: break-word;width:175px;FONT-SIZE:8pt;' class='" + classValue + "'>");					
						out.println(ENCOUNTER_DATE_TIME+"</td>");	

						out.println("</tr>");						
						i++;
						cnt++;
					
					}
				}
%>
	
	</table>
	
	<input type="hidden" id="dataCount" value="<%=cnt%>">
	<%
	if(rs != null ) rs.close();	 
	if(pstmt!=null) pstmt.close();

	}catch(Exception e){
		out.print(e);
		e.printStackTrace();
	 }
	finally	{	
		 if(pstmt!=null)    pstmt.close();
		 if(rs!=null)        rs.close();
		 ConnectionManager.returnConnection(conn,request); 
	}
		 
		
		   %>	 
		 
	 
	<input type="hidden" name="patientid" id="patientid" value="<%=patientid%>">
	<input type="hidden" name="operation" id="operation" value="insert">
	 
	
	 
</form>
</body>
</div>
</html>
	  
	 
</form>
</div>
</body>
</html>

