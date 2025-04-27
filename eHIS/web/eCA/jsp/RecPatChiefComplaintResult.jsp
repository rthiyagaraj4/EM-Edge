<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created 
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />


<script src='../../eCA/js/RecPatChiefComplaint.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function scrollTitle()
{
	  var y = document.body.scrollTop;

	  if(y == 0){
		document.getElementById("divDataTitle").style.position = 'static';
		document.getElementById("divDataTitle").style.posTop  = 0;
	  }else{
		document.getElementById("divDataTitle").style.position = 'relative';
		document.getElementById("divDataTitle").style.posTop  = y-2;
	  }
	}
	function alignWidth(){		
		var totalRows =  document.getElementById("dataTable").rows.length;		
		var counter = totalRows-1;
		//alert(document.getElementById("dataTitleTable").rows.length);
		var temp = document.getElementById("dataTitleTable").rows[0].cells.length;
		for(var i=0;i<temp;i++) 
		{
			document.getElementById("dataTitleTable").rows[0].cells[i].width = document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
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
	String complaint_desc = "";
	String complaint_text = "";
	String complaint_text1 = "";
//	String complaint_desc1 = "";
	String complaint_id = "";
	String onset_datetime = "";
	String remarks = "";
	String mode = "";
	String classValue = "";
	String patient_id = "";
	String relationship_id = "";
	String open_in_modal  = "";	
	String p_called_from_widget = ""; //CHL-CRF [IN035950]
	String qrystr = request.getQueryString();//CHL-CRF [IN035950]
	int i = 0;
	int len = 0;


	facility_id=(String) session.getValue("facility_id");
	encounter_id = request.getParameter("encounter_id");
	patient_id = request.getParameter("patient_id");
	relationship_id = request.getParameter("relationship_id");
	open_in_modal  = request.getParameter("open_in_modal")==null?"":request.getParameter("open_in_modal");
	p_called_from_widget  = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
	
%>
</head>
<body onScroll='scrollTitle()' onKeyDown="lockKey()">
	<form name='RecPatChiefComplaintResultForm' id='RecPatChiefComplaintResultForm'>
<%
try
{
	con	= ConnectionManager.getConnection();
	
    //sql = "select b.complaint_id,b.complaint_desc, b.complaint_text,a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy HH:mm') onset_datetime_str from ca_encntr_chief_complaint a, ca_chief_complaint b where a.facility_id=? and a.encounter_id=?  and b.complaint_id=a.complaint_id order by a.onset_datetime desc";
//	sql = "select a.complaint_id,CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,'en','1') complaint_desc, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy HH24:MI') onset_datetime_str from ca_encntr_chief_complaint a where a.facility_id=? and a.encounter_id=? order by a.onset_datetime desc";

	sql = "select a.complaint_id, complaint_desc, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy HH24:MI') onset_datetime_str from ca_encntr_chief_complaint a where a.facility_id=? and a.encounter_id=? order by a.onset_datetime desc";
	
	pstmt = con.prepareStatement(sql);
    pstmt.setString(1,locale);
	//pstmt.setString(2,locale);
	pstmt.setString(2,facility_id);
	pstmt.setString(3,encounter_id);
	rs = pstmt.executeQuery();
	
	mode = "modify";
%>
<div id='divDataTitle' style='postion:relative'> 
<table border='1' width='100%' cellpadding='3' cellspacing='0' align='center'>
	<tr ><td class='COLUMNHEADER' colspan=4 ><fmt:message key="eCA.CurrentChiefComplaint.label" bundle="${ca_labels}"/></td></tr>
</table>

<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
	<tr>
		<td class='COLUMNHEADERCENTER' width='50%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="eCA.Onset.label" bundle="${ca_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='15%'><a href='javascript:ViewAllDiag()' title='View Diagnosis for Present Chief Complaint' ><font color='aqua'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></font></a></td>
		<td class='COLUMNHEADERCENTER' width='15%'><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	</tr>
</table>
</div>

	<table  width='100%' id='dataTable' class='grid'   >
		
<%
	while(rs.next())
	{
		/*if ( i % 2 == 0 )
			classValue = "gridData" ;
		else
			classValue = "gridData" ;*/
			classValue = "gridData";

		complaint_desc = rs.getString("complaint_desc")==null?"":rs.getString("complaint_desc");
		complaint_text = rs.getString("complaint_text")==null?"":rs.getString("complaint_text");
		/*Added by Archana on 3/10/2010 at 3:07 PM for IN019870 start*/
		complaint_text1 = complaint_text.replaceAll("\"", "CHIEFDOUBLEQUOTE");
		complaint_text1 = complaint_text1.replaceAll("'", "CHIEFSINGLEQUOTE");
		//end
		onset_datetime = rs.getString("onset_datetime_str")==null?"":rs.getString("onset_datetime_str");

		
		complaint_id=rs.getString("complaint_id")==null?"":rs.getString("complaint_id");
		remarks=rs.getString("remarks")==null?"":rs.getString("remarks");
		len = complaint_text.length();	
		
		//out.println("</tr align='left'><td class='"+classValue+"'><a href=\"javascript:updateChiefComplaint('"+complaint_desc+"','"+complaint_text+"','"+onset_datetime+"','"+complaint_id+"','"+remarks+"','"+mode+"','"+encounter_id+"')\" title=\"Click here to Update\" >"+complaint_desc+"</td>");

			//	out.println("<input type='hidden' name='remarks"+i+"' id='remarks"+i+"' value="+remarks+">");
			
		
		out.println("<tr><td class='gridData' width='30%'><a  href='javascript:show_det(\""+complaint_id+"\",\"\",\""+complaint_text1+"\",\""+onset_datetime+"\",\"\",\""+encounter_id+"\",\""+patient_id+"\",\""+relationship_id+"\")' class='gridLink'>"+complaint_text+"</a></td>");
        
		onset_datetime	= com.ehis.util.DateUtils.convertDate(onset_datetime,"DMYHM","en",locale);

		/*if(len > 15 ) encounter_id
		{
			printString=complaint_text.substring(0,15);
			out.println("<td class='"+classValue+"'><a href='javascript:showRemarks(\""+complaint_text+"\",\""+complaint_desc+"\")' title='view Complaint Details' >"+printString+"...</a></td>");
		}
		else
			out.println("<td class='"+classValue+"'>"+complaint_text+"</td>");*/

		out.println("<td class='gridData' width='24%'>"+onset_datetime+"</td>");
		out.println("<td  class='gridData' width='24%'><a  href='javascript:showdiagnosis(\""+complaint_id+"\",\""+complaint_text1+"\")' title=\"view Diagnosis for "+complaint_desc+"\" class='gridLink' >(D)</a></td>");
	
		
		
		out.println("<td class='gridData' width='22%' ><a href='javascript:onclick=showRemarks(\""+complaint_text1+"\",\"\",\"\",\""+complaint_id+"\",\""+facility_id+"\",\""+encounter_id+"\")' class='gridLink'><img src='../../eCA/images/flow_text.gif' ></img></a></td></tr>");



		
	i++;
	}				
%>
	<tr style='visibility:hidden'>
		<td class='COLUMNHEADER' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.OnsetDateTime.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' ><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>

	</tr>
	</table>
    <input type='hidden' name='open_in_modal' id='open_in_modal' value='<%=open_in_modal%>'></input>
	<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='<%=p_called_from_widget%>'></input> <!-- //CHL-CRF [IN035950] -->
	<input type='hidden' name='qrystr' id='qrystr' value='<%=qrystr%>'></input><!-- //CHL-CRF [IN035950] -->
	</form>
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
		//out.println("Exception @ try"+ex.toString());//common-icn-0181
		ex.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
<script>alignWidth();</script>

