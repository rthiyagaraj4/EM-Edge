<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
  ArrayList  vecGcsResponseDesc = null;
  ArrayList  vecGcsDesc = null;
  String strGcsCode1="";
  String strGcsCode2="";
  String strGcsCode3="";
  String strGcsWeight1="";
  String strGcsWeight2="";
  String strGcsWeight3=""; 
  String strGcsScore ="";
  String strGcsRemarks ="";
  String strPriority = "";
  String strTreatmentArea = "";
  String strClinicDesc = "";
  String strPractName = "";

	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 
	 String strTraumaDate = request.getParameter("TraumaDate");
     String facility_id = request.getParameter("FacilityId");

	String qryAeGcsResponse = "select GCS_RESPONSE_CODE, GCS_RESPONSE_DESC  from ae_gcs_response";

	String qryScoreDetails = "SELECT A.Clinic_code,A.Treatment_area_code,A.Practitioner_id,A.GCS_RESPONSE_CODE1,A.GCS_CODE1,A.GCS_WEIGHT1,A.GCS_RESPONSE_CODE2,A.GCS_CODE2,A.GCS_WEIGHT2, A.GCS_RESPONSE_CODE3,A.GCS_CODE3,A.GCS_WEIGHT3,A.GCS_SCORE,A.GCS_REMARKS,A.PRIORITY,TO_CHAR(a.exam_date_time,'dd/mm/yyyy hh24:mi')date_time,b.SHORT_DESC treatment_area_desc , C.LONG_DESC CLINIC_DESC ,D.PRACTITIONER_NAME FROM AE_PAT_GCS_SCORE a,ae_tmt_area_for_clinic b,OP_CLINIC C,AM_PRACTITIONER D WHERE a.FACILITY_ID='"+facility_id+"'  AND  exam_date_time=TO_DATE('"+strTraumaDate+"','dd/mm/yyyy hh24:mi') AND a.FACILITY_ID=b.FACILITY_ID  AND  a.CLINIC_CODE=b.CLINIC_CODE   AND a.TREATMENT_AREA_CODE=b.TREATMENT_AREA_CODE AND A.CLINIC_CODE = C.CLINIC_CODE AND A.PRACTITIONER_ID=D.PRACTITIONER_ID";

	String qryAeGcsForResponse = "select gcs_code,gcs_desc, APPL_GCS_RESPONSE_CODE  from ae_gcs_for_response order by gcs_desc";

	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet rsScoreDetails = null;
	ResultSet rsAeGcsForResponse = null;
try{
	conn = webbeans.eCommon.ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement(qryAeGcsResponse);
	rs = pstmt.executeQuery();

	if(rs != null)
	{
		vecGcsResponseDesc = new ArrayList ();
		while(rs.next())
		{
			vecGcsResponseDesc.add(rs.getString("GCS_RESPONSE_DESC"));	
		}
	}
	if(rs!=null)rs.close();
	if(pstmt != null)pstmt.close();
	pstmt = conn.prepareStatement(qryScoreDetails);
	rsScoreDetails = pstmt.executeQuery();
	if(rsScoreDetails != null)
	{
			while(rsScoreDetails.next())
			{
				strGcsCode1 = rsScoreDetails.getString("GCS_CODE1");
				strGcsCode2 = rsScoreDetails.getString("GCS_CODE2");
				strGcsCode3 = rsScoreDetails.getString("GCS_CODE3");

				strGcsWeight1 = rsScoreDetails.getString("GCS_WEIGHT1");
				strGcsWeight2 = rsScoreDetails.getString("GCS_WEIGHT2");
				strGcsWeight3 = rsScoreDetails.getString("GCS_WEIGHT3");
				
				strGcsScore    = rsScoreDetails.getString("GCS_SCORE");
				strGcsRemarks = rsScoreDetails.getString("GCS_REMARKS");
				if(strGcsRemarks==null)strGcsRemarks="";
				strPriority	    = rsScoreDetails.getString("PRIORITY");
				strTreatmentArea = rsScoreDetails.getString("treatment_area_desc");
				strClinicDesc  = rsScoreDetails.getString("CLINIC_DESC");
				strPractName = rsScoreDetails.getString("PRACTITIONER_NAME");
			}
		    if(rsScoreDetails != null)rsScoreDetails.close();
			if(pstmt != null)pstmt.close();

			if(strPriority==null)strPriority="";
			if(strPriority.equals("R"))
			{
			  strPriority = "Resuscitation";
			}
			if(strPriority.equals("E"))
			{
				strPriority = "Emergent";
			}
			if(strPriority.equals("U"))
			{
				strPriority = "Urgent";
			}

			if(strPriority.equals("S"))
			{
				strPriority = "Semi Urgent";
			}

			if(strPriority.equals("N"))
			{
				strPriority = "Non Urgent";
			}
			
	}

	pstmt = conn.prepareStatement(qryAeGcsForResponse);
	rsAeGcsForResponse=pstmt.executeQuery();
	if(rsAeGcsForResponse != null)
	{
		vecGcsDesc =new ArrayList ();
			while(rsAeGcsForResponse.next())
			{
					if(strGcsCode1.equals(rsAeGcsForResponse.getString("gcs_code")))
					{
						vecGcsDesc.add(rsAeGcsForResponse.getString("gcs_desc"));
						vecGcsDesc.add(strGcsWeight1);
					}
					else if(strGcsCode2.equals(rsAeGcsForResponse.getString("gcs_code")))
					{
						vecGcsDesc.add(rsAeGcsForResponse.getString("gcs_desc"));
						vecGcsDesc.add(strGcsWeight2);
					}
					else if(strGcsCode3.equals(rsAeGcsForResponse.getString("gcs_code")))
					{
						vecGcsDesc.add(rsAeGcsForResponse.getString("gcs_desc"));
						vecGcsDesc.add(strGcsWeight3);
					}				
			}
			if(rsAeGcsForResponse != null)rsAeGcsForResponse.close();
			if(pstmt != null)pstmt.close();
	}
	}catch(Exception exc)
	{
		exc.printStackTrace();
	}
	finally
	{
		if(rs!=null)rs.close();
		if(rsAeGcsForResponse != null)rsAeGcsForResponse.close();
		if(rsScoreDetails != null)rsScoreDetails.close();
		if(pstmt != null)pstmt.close();
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}
%>
<body onSelect="codeArrestThruSelect()"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<table align="center" cellPadding="0" border='0' cellSpacing="0" width="100%" >  
	    <tr>
		    <td class="label" align='right'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td  class="QueryData">&nbsp;<%=strClinicDesc%></td>
            <td class="label"  nowrap align='right'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
            <td align='left' class="QueryData">&nbsp;<%=strTreatmentArea%></td>
       </tr>
	   <tr>
            <td class="label" nowrap align='right'><fmt:message key="eAE.ExamDateTime.label" bundle="${ae_labels}"/></td>
			<td  class="QueryData">&nbsp;<%=strTraumaDate%></td>
		    <td  colspan='2'>&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td class="label"  align='right'><fmt:message key="eAE.ExaminedBy.label" bundle="${ae_labels}"/></td>
			<td colspan='3' class="QueryData">&nbsp;<%=strPractName%></td>
		</tr>
		<tr>
			<td class="label"  colspan='4'>&nbsp;</td>
      </tr>		
       <tr>
	      <td colspan='4' class='label' align='left'><b><fmt:message key="eAE.GCSScore.label" bundle="${ae_labels}"/></b></td>
      </tr>
<%
int j=0;
		for(int i=0;i<vecGcsResponseDesc.size();i++)
		{			
%>
		<tr>
          <th colspan='4' align='left'><%=vecGcsResponseDesc.get(i)%></th>  
      </tr>
	  <tr>
			<td align='right' class="label"><fmt:message key="eAE.GCSDescription.label" bundle="${ae_labels}"/></td>
	        <td align='left' class="QueryData">&nbsp;<%=vecGcsDesc.get(j)%></td>
			  <td align='left' colspan='2'>&nbsp;</td>
      </tr> 
      <tr>
		    <td class="label" align='right'><fmt:message key="Common.Score.label" bundle="${common_labels}"/></td>
		<td align='left' class="QueryData">&nbsp;<%=vecGcsDesc.get(j+1)%></td>
			  			  <td align='left' colspan='2'>&nbsp;</td>
	  </tr>
<%
		j=j+2;
		}
		vecGcsDesc.clear(); 
		vecGcsResponseDesc.clear(); 
		vecGcsDesc = null;
		vecGcsResponseDesc = null;
%>	
	   <tr>
          <th colspan='4' align='left'><fmt:message key="Common.Score.label" bundle="${common_labels}"/></th>  
      </tr>
	  <tr>
        <td class="label" align='right'><fmt:message key="eAE.GCSScore.label" bundle="${ae_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strGcsScore%></td>
		<td class="label" align='right'><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
        <td align='left' class="QueryData">&nbsp;<%=strPriority%></td>
	  </tr>
	  <tr >
        <td class="label"  align='right'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td align='left' class="QueryData">&nbsp;<%=strGcsRemarks%></td>
		<td align='left' colspan='2'>&nbsp;</td>
       </tr>
	  <tr>
        <td colspan='4'>&nbsp;</td>        
       </tr>
  </table>
</body>
</html>

