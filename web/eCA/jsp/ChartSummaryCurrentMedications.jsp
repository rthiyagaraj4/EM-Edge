<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
	<title><fmt:message key="Common.ChartSummaryCurrentMedications.label" bundle="${common_labels}"/></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<center>
		<form name='CAViewPatientAllergyForm' id='CAViewPatientAllergyForm' method='post'>
		<table class='grid' width='100%'>
		

		<%
			String patient_id = "", query_current_medications = "";
			String drug_name = "",	drug_duration = "";
			String classValue = "";
			int i=0;

			Connection con = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			ResultSet	rs = null;
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			
			String facilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");

			try
			{
				//27788 Start.
				String compressed =request.getParameter("compressed")==null?"N":(String)request.getParameter("compressed");				
				if("Y".equals(compressed)){
					patient_id = new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));					
				}else{
				//27788 End.
					patient_id = request.getParameter("patient_id");
				}				
				if(patient_id==null) patient_id = "";			
				
					
					
		query_current_medications =" SELECT e.form_code||' '||e.DRUG_DESC||' '||a.dosage ||' '||PH_GET_UOM_DISPLAY('"+facilityId+"',a.dosage_uom_code)||' '||a.FREQ_CODE||' * '||a.DURATION  ||' '||c.DURN_DESC   drug_name,to_char(a.start_date,'dd/mm/yy') start_date, to_char(a.end_date,'dd/mm/yy') end_date  FROM ph_patient_drug_profile a ,am_duration_type c,am_frequency d, ph_drug e ,ph_generic_name f WHERE a.patient_id = ? AND TRUNC(NVL(a.end_date,SYSDATE)) >= TRUNC(SYSDATE) AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND d.freq_code(+)=a.FREQ_CODE AND e.DRUG_CODE=a.DRUG_CODE  and f.GENERIC_ID=a.GENERIC_ID AND c.durn_type(+)=d.INTERVAL_DURN_TYPE ORDER BY start_date DESc ";
		
			 con = ConnectionManager.getConnection(request);
			 String phInstallYn="select 1 from  sm_module where module_id='PH' and INSTALL_YN='Y'";
			pstmt1 = con.prepareStatement(phInstallYn);

			if(rs != null) rs = null;
			rs = pstmt1.executeQuery();
			String strStDate ="";
			String strEdDate = "";

			if(rs.next())
			{

				if (rs!=null) rs.close();
				pstmt	=	con.prepareStatement(query_current_medications);

				pstmt.setString(1,patient_id);

				rs = pstmt.executeQuery();

				while(rs.next())
				{
					i++;

					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";

					drug_name	= rs.getString("drug_name");
					strStDate = ((rs.getString("start_date")==null)?"":rs.getString("start_date"));
					strEdDate = ((rs.getString("end_date")==null)?"":rs.getString("end_date"));

					drug_duration	= com.ehis.util.DateUtils.convertDate(strStDate,"DMY","en",locale) + " - " + com.ehis.util.DateUtils.convertDate(strEdDate,"DMY","en",locale) ;

					if(drug_name==null)		drug_name		= "&nbsp;";
				
			%>
					<tr>
						<td class='gridData' width="60%"><%=drug_name%></td>
						<td class='gridData' width="40%"><%=drug_duration%></td>
					</tr>
			<%
			}
			} // module install
				if(rs!=null) rs.close();
				if(pstmt1!=null) pstmt1.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{
				//out.println("Exception@1 : "+e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		%>
		</table>
		<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'>  <!-- 27788 -->
		</form>
	</center>
</body>
</html>

