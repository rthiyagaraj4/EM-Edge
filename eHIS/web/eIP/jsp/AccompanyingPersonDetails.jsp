<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>                         
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con = null;
	Statement statement		=	null;
	PreparedStatement pstmt = 	null;
	ResultSet resultSet		=	null;
	try
	{
		String facility_id	=	checkForNull((String)session.getValue("facility_id"));
		String encounterId  =	checkForNull(request.getParameter("encounterId"));
		con	= ConnectionManager.getConnection(request);

		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("SELECT a.lodger_ref_no, DECODE (a.attached_to_inpatient_yn, ");
		stringBuffer.append("'Y', 'Attendant', 'N', 'Lodger') accom_categ, ");
		stringBuffer.append("NVL (b.short_desc, 'Other Places') nursing_unit_short_desc, ");
		stringBuffer.append("a.attached_to_inpatient_yn, a.patient_encounter_id, d.patient_id, ");
		stringBuffer.append("a.lodger_patient_id, a.lodger_name, TO_CHAR (check_in_date_time, ");
		stringBuffer.append("'dd/mm/rrrr hh24:mi') check_in_date_time, ");
		stringBuffer.append("check_in_date_time check_in_date_time1, lodger_gender, ");
		stringBuffer.append("e.short_desc reason_for_stay_code, c.encounter_id, ");
		stringBuffer.append("TO_CHAR (period_from_date, 'dd/mm/rrrr hh24:mi') period_from_date, ");
		stringBuffer.append("TO_CHAR (period_to_date, 'dd/mm/rrrr hh24:mi') period_to_date ");
		stringBuffer.append("FROM ip_lodger_detail a, ip_nursing_unit b,pr_encounter c,mp_patient d,");
		stringBuffer.append(" ip_reason_for_lodger_stay e WHERE a.facility_id = ? ");
		//stringBuffer.append(facility_id);
		stringBuffer.append(" AND a.check_out_yn = 'N' and a.patient_encounter_id = ? ");
		//stringBuffer.append(encounterId);
		stringBuffer.append(" AND b.facility_id(+) = a.facility_id ");
		stringBuffer.append("AND b.nursing_unit_code(+) = a.nursing_unit_code ");
		stringBuffer.append("AND c.facility_id(+) = a.facility_id ");
		stringBuffer.append("AND c.encounter_id(+) = a.patient_encounter_id ");
		stringBuffer.append("AND d.patient_id(+) = c.patient_id ");
		stringBuffer.append("AND a.reason_for_stay_code = e.reason_for_stay_code(+) ORDER BY ");
		stringBuffer.append("accom_categ, nursing_unit_short_desc, check_in_date_time1 desc ");

		pstmt = con.prepareStatement(stringBuffer.toString());
		pstmt.setString(1, facility_id);
		pstmt.setString(2, encounterId);
		resultSet = pstmt.executeQuery();
/*         resultSet = statement.executeQuery(stringBuffer.toString()) ; */
		out.println("<table width='100%' cellspacing=0 cellpadding=0 border=1>") ;
		out.println( "<tr>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonID.label","ip_labels")+"</th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonName.label","ip_labels")+"</th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.periodfrom.label","common_labels")+"</th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.periodto.label","common_labels")+"</th>" ) ;
        
		if(resultSet!=null)
        {
			String cname= "QRYEVEN" ;

			while(resultSet.next()) 
            {
                if(cname.equals("QRYEVEN"))
                    cname = "QRYODD" ;
                else
                    cname = "QRYEVEN" ;

				out.println( "<tr>" ) ;
				out.println ( "<td class='"+cname+"'>");
				out.println(resultSet.getString("lodger_patient_id")==null ? "&nbsp; ": resultSet.getString("lodger_patient_id") +"</td>") ;
				out.println ( "<td class='"+cname+"'>"+checkForNull(resultSet.getString("lodger_name"))+"</td>") ;
				out.println ( "<td class='"+cname+"'> "+  (resultSet.getString("PERIOD_FROM_DATE") ==null? "&nbsp;":(resultSet.getString("PERIOD_FROM_DATE")) ) +"</td>" ) ;
				out.println ( "<td class='"+cname+"'> "+  (resultSet.getString("PERIOD_TO_DATE") ==null? "&nbsp;":(resultSet.getString("PERIOD_TO_DATE")) ) +"</td>" ) ;
				out.println( "</tr>" ) ;
			}
		}
			out.println("</table>");
        
			if (resultSet != null)   resultSet.close();  
			if (statement != null) statement.close();
			if (pstmt != null) pstmt.close();
			
		}catch(Exception e) 
		{ 
/* 			out.println(e.toString()); */
			e.printStackTrace();
		}
	    finally 
		{
			ConnectionManager.returnConnection(con,request);
        }
    %>
		<br>
    </body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

