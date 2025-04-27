<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,java.net.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");  %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'> </link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eIP/js/IPCountLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()' >
<form name='pat_count_result' id='pat_count_result' >
<% 
String Nursing_unit_code="";
String Speciality_code  ="";
String From_date        ="";
String To_date          ="";
String Practitioner_id  ="";
String facilityid       ="";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs =null;
try{


 Nursing_unit_code =checkForNull(request.getParameter("nursing_unit")) ;
 Speciality_code   =checkForNull(request.getParameter("specialty"));
 From_date         =checkForNull(request.getParameter("from_date"));
 To_date           =checkForNull(request.getParameter("to_date"));
 Practitioner_id   =checkForNull(request.getParameter("practitioner" ));
 facilityid        =(String)session.getValue("facility_id") ;
 StringBuffer sql   = new StringBuffer();

 

if(!Nursing_unit_code.equals("")){
	sql.append(" and a.nursing_unit_code = '"+Nursing_unit_code+"'");
}
if(!Speciality_code.equals("")){
	sql.append(" and a.specialty_code = '"+Speciality_code+"' ");
}
if(!Practitioner_id.equals("")){
	sql.append(" and a.practitioner_id = '"+Practitioner_id+"' ");
}
if(!From_date.equals("") && !To_date.equals("")){
	sql.append("and trunc(a.admission_date_time) BETWEEN TO_DATE ('"+From_date+"', 'DD/MM/YYYY') AND TO_DATE ('"+To_date+"', 'DD/MM/YYYY')");
}else if(!From_date.equals("")){
	sql.append("and trunc(a.admission_date_time) >= TO_DATE ('"+From_date+"', 'DD/MM/YYYY')");
}else if(!To_date.equals("")){
	sql.append("and trunc(a.admission_date_time) <= TO_DATE ('"+To_date+"', 'DD/MM/YYYY')");
}


int inPatientCount = 0;
int foriegnCount = 0;
int disAdvCount = 0;
int corpCount = 0;
int insurCount = 0;
int freeCount = 0;
int cashCount = 0;
con = ConnectionManager.getConnection(request);
//COUNT FOR CURRENT INPATIENT LIST

StringBuffer countSql = new StringBuffer();
 
countSql.setLength(0);
countSql.append("SELECT COUNT (*) count FROM ip_open_encounter_vw a WHERE patient_class = 'IP' AND facility_id = '"+facilityid+"' ");
if(!sql.equals("")){
	countSql.append(sql);	 
}

pstmt   = con.prepareStatement(countSql.toString());
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		inPatientCount = rs.getInt("count");
	}
	
/////////
countSql.setLength(0);
countSql.append("SELECT COUNT (*) count FROM ip_open_encounter_vw a WHERE patient_class = 'IP' AND citizen_yn = 'N' AND facility_id = '"+facilityid+"' ");
	if(!sql.equals("")){	 
		countSql.append(sql);
    }

pstmt   = con.prepareStatement(countSql.toString());
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		foriegnCount = rs.getInt("count");
	}
	
///////////////////////////////////
countSql.setLength(0);
countSql.append("select count(*) count from ip_open_encounter_vw a, ip_discharge_advice b where CANCELLATION_DATE_TIME IS null AND DIS_ADV_STATUS IN (0,9) AND a.ENCOUNTER_ID = b.ENCOUNTER_ID AND a.FACILITY_ID = '"+facilityid+"' ");
	if(!sql.equals("")){	 
		countSql.append(sql);
    }

pstmt   = con.prepareStatement(countSql.toString());
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		disAdvCount = rs.getInt("count");
	}
	
	////////////
countSql.setLength(0);
countSql.append("select count(*) count from ip_open_encounter_vw a ,bl_episode_fin_Dtls b where SETTLEMENT_IND ='R' AND EPISODE_TYPE ='I' and a.patient_class= 'IP' and a.ENCOUNTER_ID = b.ENCOUNTER_ID AND facility_id ='"+facilityid+"' ");
	if(!sql.equals("")){	 
		countSql.append(sql);
    }

pstmt   = con.prepareStatement(countSql.toString());
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		corpCount = rs.getInt("count");
	}
	

countSql.setLength(0);
countSql.append("select count(*) count from ip_open_encounter_vw a,bl_episode_fin_Dtls b where SETTLEMENT_IND ='X' AND EPISODE_TYPE ='I' and a.patient_class= 'IP' and a.ENCOUNTER_ID = b.ENCOUNTER_ID AND facility_id ='"+facilityid+"' ");
	if(!sql.equals("")){	 
		countSql.append(sql);
    }

pstmt   = con.prepareStatement(countSql.toString());
	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		insurCount = rs.getInt("count");
	}
	
	//////
	countSql.setLength(0);
	countSql.append("select count(*) count from ip_open_encounter_vw a, bl_episode_fin_Dtls b where BLNG_GRP_ID='FREE' AND EPISODE_TYPE ='I' and a.patient_class= 'IP' and a.ENCOUNTER_ID = b.ENCOUNTER_ID AND facility_id  ='"+facilityid+"' ");
	if(!sql.equals("")){	 
		countSql.append(sql);
    }

pstmt   = con.prepareStatement(countSql.toString());

	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		freeCount = rs.getInt("count");
	}
	
	countSql.setLength(0);
	countSql.append("select count(*) count from ip_open_encounter_vw a, bl_episode_fin_Dtls b where SETTLEMENT_IND ='C' AND blng_grp_id !='FREE' AND EPISODE_TYPE ='I' and a.patient_class= 'IP' and a.ENCOUNTER_ID = b.ENCOUNTER_ID AND facility_id  ='"+facilityid+"' ");
	if(!sql.equals("")){	 
		countSql.append(sql);
    }

pstmt   = con.prepareStatement(countSql.toString());

	rs = pstmt.executeQuery();
	if(rs!=null && rs.next()){
		cashCount = rs.getInt("count");
	}
	
%>
<table cellspacing=0 cellpadding=0  width='100%' border='2'>
<tr>  
<th  width='5%' >
&nbsp;<font size="2"><fmt:message key="eIP.SlNo.label" bundle="${ip_labels}"/></font>
</th>
<th  width='70%' >
&nbsp;<font size="2"><fmt:message key="eIP.ReportName.label" bundle="${ip_labels}"/></font>
</th>
<th  width='25%'>
&nbsp;<font size="2"><fmt:message key="eIP.Count.label" bundle="${ip_labels}"/></font>
</th>
</tr>
<tr>
<td  class='QRYEVEN' align='center'>1</td>
<td  class='QRYEVEN'><fmt:message key="eIP.TotNoInPat.label" bundle="${ip_labels}"/> </td>
<td class='QRYEVEN' align='center'><a href="javascript:patientDetails('IP_PAT_COUNT','<%=inPatientCount%>')"><%=inPatientCount%> </a></td>
</tr>
<tr>
<td class='QRYODD' align='center'>2</td>
<td class='QRYODD' align='left'><fmt:message key="eIP.TotNoForPat.label" bundle="${ip_labels}"/></td>
<td class='QRYODD' align='center'><a href="javascript:patientDetails('FRGN_PAT_COUNT','<%=foriegnCount%>')"><%=foriegnCount%></a></td>
</tr>
<tr>
<td class='QRYEVEN' align='center'>3</td>
<td class='QRYEVEN' align='left'><fmt:message key="eIP.TotNoDisAdvPat.label" bundle="${ip_labels}"/></td>
<td class='QRYEVEN'align='center'><a href="javascript:patientDetails('DISC_ADV_COUNT','<%=disAdvCount%>')"><%=disAdvCount%></a></td>
</tr>
<tr>
<td class='QRYODD' align='center'>4</td>
<td class='QRYODD' align='left'><fmt:message key="eIP.TotNoCorPat.label" bundle="${ip_labels}"/></td>
<td class='QRYODD' align='center'><a href="javascript:patientDetails('CORP_PAT_COUNT','<%=corpCount%>')"><%=corpCount%></a></td>
</tr>
<tr>
<td class='QRYEVEN' align='center'>5</td>
<td class='QRYEVEN' align='left'><fmt:message key="eIP.TotNoInsPat.label" bundle="${ip_labels}"/></td>
<td class='QRYEVEN' align='center'><a href="javascript:patientDetails('INSU_PAT_COUNT','<%=insurCount%>')"><%=insurCount%><a></td>
</tr>
<tr>
<td class='QRYODD'  align='center'>6</td>
<td class='QRYODD' align='left'><fmt:message key="eIP.TotNoFrePat.label" bundle="${ip_labels}"/></td>
<td class='QRYODD' align='center'><a href="javascript:patientDetails('FREE_PAT_COUNT','<%=freeCount%>')"><%=freeCount%><a></td>
</tr>
<tr>
<td class='QRYEVEN' align='center'>7</td>
<td class='QRYEVEN' align='left'><fmt:message key="eIP.TotNoCasPat.label" bundle="${ip_labels}"/></td>
<td class='QRYEVEN' align='center'><a href="javascript:patientDetails('CASH_PAT_COUNT',<%=cashCount%>)"><%=cashCount%><a></td>
</tr>
</table>
<%}catch(Exception e){
	e.printStackTrace();
} 
finally
{
if (pstmt != null) pstmt.close();
if(rs != null) rs.close();
  if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>
<input type='hidden' name='Nursing_unit_code' id='Nursing_unit_code' value='<%=Nursing_unit_code%>'></input>
<input type='hidden' name='Speciality_code' id='Speciality_code' value='<%=Speciality_code%>'></input>
<input type='hidden' name='From_date' id='From_date' value='<%=From_date%>'></input>
<input type='hidden' name='To_date' id='To_date' value='<%=To_date%>'></input>
<input type='hidden' name='Practitioner_id' id='Practitioner_id' value='<%=Practitioner_id%>'></input>
<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'></input>
<!--Below line added by Venkatesh.S on 04/FEB/2012 against KDAH-CRF-0191(32447) -->
<!--Below line modified by Venkatesh.S on 19/FEB/2012 against 37933 -->
<input type='hidden' name='title' id='title' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.InpatientDetails.label","ip_labels")%>'></input>
<!-- end KDAH-CRF-0191(32447) -->

</form>
<body>
</html>

<%!
	
	 public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

