<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
  <%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eAE/js/AETriageDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		Connection con               = null;
    	PreparedStatement pstmt		 = null;
        ResultSet rset               = null ;
   try{
		String facilityId			 = (String)session.getValue("facility_id");
		String clinic_code			 = request.getParameter("clinic_code");
			   clinic_code			 = (clinic_code == null)?"":clinic_code;
	    String orig_tmt_area_code	 = request.getParameter("orig_tmt_area_code");
			   orig_tmt_area_code	 = (orig_tmt_area_code == null)?"":orig_tmt_area_code;

		
	    String treatment_area_code	 = request.getParameter("treatment_area_code");
			   treatment_area_code	 = (treatment_area_code == null)?"":treatment_area_code;
	    String treatment_area_desc	 = request.getParameter("treatment_area_desc");
			   treatment_area_desc	 = (treatment_area_desc == null)?"":treatment_area_desc;
		String encounter_id			 = request.getParameter("encounter_id");
			   encounter_id			 = (encounter_id == null)?"":encounter_id;
		String  Temp_desc="";
		String queryString			 = request.getQueryString();
		String classValue			 = "";
		int i						 = 0;
		%>
 <body onKeyDown = 'lockKey()'>
   <form name="ae_triage_search_form" id="ae_triage_search_form" >
 <br>
	 <table border="1" cellpadding="0" cellspacing="0" align='center' width='100%'>
		 <tr><th align='left'><fmt:message key="eAE.RecordedDetails.label" bundle="${ae_labels}"/></th></tr>
       <%		
		con                  = ConnectionManager.getConnection(request);
	
		String strsql = "select to_char(a.TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi') "+
			"TRIAGE_START_DATE_TIME,b.SHORT_DESC ,a.ENCOUNTER_ID, "+
			" a.TREATMENT_AREA_CODE , a.TRIAGE_START_DATE_TIME "+
			"from AE_PAT_TRIAGE a,ae_tmt_area_for_clinic b where a.FACILITY_ID= ? and  "+
			"a.encounter_id = ? and a.CLINIC_CODE = ?  and "+
			"a.FACILITY_ID=b.FACILITY_ID  and  a.CLINIC_CODE=b.CLINIC_CODE and "+
			"a.TREATMENT_AREA_CODE=b.TREATMENT_AREA_CODE  order by a.TREATMENT_AREA_CODE,5 desc ";

		pstmt = con.prepareStatement(strsql);
		pstmt.setString	(1,	facilityId);
		pstmt.setString	(2,	encounter_id);
		pstmt.setString	(3,	clinic_code);
		rset = pstmt.executeQuery();
		
	    while(rset!=null && rset.next())
	    {
			String Short_desc =rset.getString("SHORT_DESC");
				if(!Short_desc.equals(Temp_desc )){
					out.println("<tr><th class='BLUECOLOR' align='left'>"+Short_desc+"</th></tr>");
				}
				Temp_desc=Short_desc;
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
				out.println("<tr><td class='" + classValue + "'>");
				 out.println("<font size='1'><a href=\"javascript:callDate('"+rset.getString("TRIAGE_START_DATE_TIME")+"','"+rset.getString("ENCOUNTER_ID")+"','"+rset.getString("TREATMENT_AREA_CODE")+"','"+orig_tmt_area_code+"')\">");
			     out.println(rset.getString("TRIAGE_START_DATE_TIME")==null?"": rset.getString("TRIAGE_START_DATE_TIME") );
				out.println("</a></td></tr>");
			i++;
		}
%>
	    </table>
          <input type='hidden' name='clinic_code' id='clinic_code' value="<%=ecis.utils.HTMLUtilities.getDisplayString(clinic_code)%>">
   		  <input type='hidden' name='treatment_area_code' id='treatment_area_code' value="<%=ecis.utils.HTMLUtilities.getDisplayString(treatment_area_code)%>">
          <input type='hidden' name='queryString' id='queryString' value="<%=ecis.utils.HTMLUtilities.getDisplayString(queryString)%>">
	
		
<%
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        if(pstmt!=null)  pstmt.close();
		if(rset!=null)  rset.close();
	    ConnectionManager.returnConnection(con,request);
    }
%>
		</form>
   </body>
</html>

