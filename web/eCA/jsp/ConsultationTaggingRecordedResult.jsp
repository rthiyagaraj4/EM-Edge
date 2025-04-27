<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
21/04/2024  50627    Twinkle Shah    21/04/2024		Ramesh Goli        ML-MMOH-CRF-2106									
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />


<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCA/js/ConsultationTagging.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script>
function scrollTitle()
{
	  var y = document.body.scrollTop;

	  if(y == 0){
		document.getElementById('divDataTitle').style.position = 'static';
		document.getElementById('divDataTitle').style.posTop  = 0;
	  }else{
		document.getElementById('divDataTitle').style.position = 'relative';
		document.getElementById('divDataTitle').style.posTop  = y-2;
	  }
	}
	function alignWidth(){	
		var totalRows =  document.getElementById('dataTable').rows.length;		
		var counter = totalRows-1;
		//alert(document.getElementById('dataTitleTable').rows.length);
		var temp = document.getElementById('dataTitleTable').rows(0).cells.length;
		for(var i=0;i<temp;i++) 
		{
			document.getElementById('dataTitleTable').rows(0).cells(i).width = document.getElementById('dataTable').rows(counter).cells(i).offsetWidth;
		}
	}


</script>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	String facility_id = "";
	String encounter_id = "";
	String classValue = "";
	String patient_id = "";
	String qrystr = request.getQueryString();
	int i = 0;
	int len = 0;

String speciality_code="";
String tag_practitioner_id="";
String start_date="";
String end_date="";
String added_by_id="";
String mode="";
facility_id=(String) session.getValue("facility_id");
encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
long encounter=0;
if (encounter_id!= null || encounter_id  !="")
{
encounter = Long.parseLong(encounter_id);
}

patient_id = request.getParameter("patient_id");
String	option_id =  request.getParameter("option_id")==null?"":request.getParameter("option_id");
String spl_name="";
String pract_name="";
String visit_adm_date="";
%>
</head>
<body onScroll='scrollTitle()' onKeyDown="lockKey()" >
	<form name='ConsultationTagResultfrm' id='ConsultationTagResultfrm'>
<%
try
{
	con	= ConnectionManager.getConnection();
	sql ="SELECT A.PATIENT_ID, A.SPECIALITY_CODE, C.SHORT_DESC SPL_NAME, A.ENCOUNTER_ID, A.TAG_PRACTITIONER_ID, B.PRACTITIONER_NAME PRACT_NAME, TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') START_DATE, TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI') END_DATE, TO_CHAR (D.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE, A.ADDED_BY_ID FROM CA_CONSULTATION_TAGGING A, AM_PRACTITIONER B, AM_SPECIALITY_LANG_VW C, PR_ENCOUNTER D WHERE A.TAG_PRACTITIONER_ID = B.PRACTITIONER_ID AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND D.PATIENT_ID = A.PATIENT_ID AND D.ENCOUNTER_ID = A.ENCOUNTER_ID AND LANGUAGE_ID = ? AND A.PATIENT_ID = ? AND A.ENCOUNTER_ID = ? ORDER BY A.ADDED_DATE DESC";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,patient_id);
	pstmt.setLong(3, encounter);
	rs = pstmt.executeQuery();
	mode = "modify";
%>

<div id='divDataTitle' style='postion:relative' >			
<center>	
<table width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' class='grid' style="border-bottom: none;" >
<tr>
<td class='columnheader' width='100%' colspan=5 style="border-bottom: 1px solid #000;"><fmt:message key="eCA.ConsultTagHistory.label" bundle="${ca_labels}"/></td>
</tr>
<tr class='bordered-row'>
<td class='columnheadercenter' width='30%' style="border-bottom: 1px solid #000;"><fmt:message key="eCA.TaggedPractitioner.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' width='15%' style="border-bottom: 1px solid #000;"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='20%' style="border-bottom: 1px solid #000;"><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='20%' style="border-bottom: 1px solid #000;"><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter' width='15%' style="border-bottom: 1px solid #000;">Tagging By</td>
</tr>
<tr>
<td width='100%' colspan=5 class='CAGROUP'>&nbsp;</td>
</tr>
</table>
</div>
<table  width='100%' id='dataTable' class='grid' style="border-top: none;">	
<%
	while(rs.next())
	{
		 /*if ( i % 2 == 0 )
			classValue = "gridData" ;
		    else
			classValue = "gridData" ;*/
			classValue = "gridData";

			patient_id = rs.getString("patient_id")==null?"":rs.getString("patient_id");
			speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
			spl_name=rs.getString("spl_name")==null?"":rs.getString("spl_name");
            encounter_id = rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
            tag_practitioner_id=rs.getString("tag_practitioner_id")==null?"":rs.getString("tag_practitioner_id");
            pract_name=rs.getString("pract_name")==null?"":rs.getString("pract_name");
            start_date=rs.getString("start_date")==null?"":rs.getString("start_date");
            end_date=rs.getString("end_date")==null?"":rs.getString("end_date");
            visit_adm_date=rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
            added_by_id=rs.getString("added_by_id")==null?"":rs.getString("added_by_id");
					
		
		    out.println("<tr><td class='gridData' width='30%'><a  href='javascript:modifyTaggedRecord(\""+patient_id+"\",\""+speciality_code+"\",\""+encounter_id+"\",\""+tag_practitioner_id+"\",\""+start_date+"\",\""+end_date+"\",\""+visit_adm_date+"\")' class='gridLink'>"+pract_name+"</a></td>");
			out.println("<td class='gridData' width='15%'>"+spl_name+"</td>");
		    out.println("<td class='gridData' width='20%'>"+start_date+"</td>");
			out.println("<td class='gridData' width='20%'>"+end_date+"</td>");
			out.println("<td class='gridData' width='15%'>"+added_by_id+"</td></tr>");
	i++;
	}
if(pstmt!=null)pstmt.close();
if(rs!=null)rs.close();
%>	
	</table>
	<input type='hidden' name='qrystr' id='qrystr' value='<%=qrystr%>'></input>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
    <input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>	  
    <input type='hidden' name='option_id' id='option_id' value='<%=option_id%>'>	  
	</form>
		</center>	
</body>
</html>
	<%	
		if(pstmt!=null)
			pstmt.close();
		if(rs!=null)
			rs.close();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
<script>alignWidth();</script>

