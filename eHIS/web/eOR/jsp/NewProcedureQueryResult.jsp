<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

    <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/NewProcedure.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<head>

<%//out.println("<script>alert('===="+request.getQueryString()+"===')</script>");
		String Patient_Id				= checkForNull(request.getParameter("patient_id"));
		String Encounter_Id				= checkForNull(request.getParameter("encounter_id"));		
		String operating_facility_id	= (String) session.getValue("facility_id");
		String patient_class		    = checkForNull(request.getParameter("patient_class"));
		//String age						= checkForNull(request.getParameter("Age"));	
		//String dob						= checkForNull(request.getParameter("Dob"));	
		String Locn_Code	            = checkForNull(request.getParameter("location_code"));			
		String Locn_Type			    = checkForNull(request.getParameter("location_type"));
		String Practitioner_Id			= checkForNull(request.getParameter("Practitioner_Id"));	
		String relationship_id			= checkForNull(request.getParameter("relationship_id"));
		//String sex						= checkForNull(request.getParameter("Sex"));
		String modal_yn					= checkForNull(request.getParameter("modal_yn"));
		String start_date				= checkForNull(request.getParameter("date_from"));
		String end_date					= checkForNull(request.getParameter("date_to"));
		//String view				= checkForNull(request.getParameter("viewScope"));
		//String restrict					= checkForNull(request.getParameter("restrict"));
		String status				= checkForNull(request.getParameter("status"));
		
		String classValue				= "";
		//String practitioner_type		= checkForNull((String)session.getValue("practitioner_type"));
			
		Connection con			= null;
		PreparedStatement stmt	= null;
		ResultSet rs			= null;		
	
		String term_code = ""; 		//String accuracy_short_desc = "";
		//String onset_nature = "";	
		String onset_date = "";
		//String onset_status = "";	
		String short_desc = "";
		//String term_set_id = "";	
		String term_set_desc = "";
		//String encounter_id1 = "";	
		//String accur_code_ind	=""; 
		//String occur_srl_no	="";
		//String Support_exisist_yn_YN	="";
		StringBuffer associate_codes = new StringBuffer();
		if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
			Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
		}
%>
	
	
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name='query_result_form' id='query_result_form' action='' method='post' target='messageFrame'>
	
	<table border='0' width='100%' id='dataTitleTable' cellpadding='0' cellspacing='0' align='center' >
			<tr><th align='left' colspan='8' '><font='verdana' size='1'>Procedure History</font></th>
			</tr>
	</table>
	<table border='0' width='100%' id='' cellpadding='0' cellspacing='1' align='center' >
	<tr>
				<!-- <td align='center' width='2%' ><font size=1 ></font></td> -->
				<td align='center' width='2%' ><font size=1 ></font></td>
				<td align='center' width='52%'><font size=1 >Procedure Description</font></td>
				<td align='center' width='10%'><font size=1 >Code</font></td>
				<td align='center' width='16%'><font size=1 >Performed On</font></td>
				<td align='center' width='10%'><font size=1 >Details</font></td>
				<td align='center' width='10%'><font size=1 >Outcome</font></td>
				
	</tr>
	</table>

	<!-- <table border='1' width='100%' id='dataTable' cellpadding='0' cellspacing='0' align='center' style="border-bottom:#ffffff"> -->
	
	<%
	try
	{
		//String status = "";
		//String nature ="";
		//String priority ="";
		String priorityclass ="";
		String prev_term_set_id ="";
		//String Diff_status = "";
		//String not_curr_enc="S";
		//String curr_accuracy_code="";
		//String notifiable_yn="";
        con=ConnectionManager.getConnection(request);
		
		
		int k = 0;
		StringBuffer strBuffer	= new StringBuffer();
	
		if(strBuffer.length() > 0) strBuffer.delete(0,strBuffer.length());
		strBuffer.append("Select a.proc_narration term_code_desc ,a.proc_code term_code,c.Term_Set_Desc  TERM_SET_DESC,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,b.practitioner_name practitioner_name, PATIENT_ID,proc_date dummydate, a.srl_no srl_no,c.term_set_id term_set_id  from pr_encounter_procedure a, am_practitioner b ,mr_term_set  c where a.facility_id = ? and a.PATIENT_ID = ? and a.PROC_CODE_SCHEME = c.TERM_SET_ID and b.practitioner_id=a.practitioner_id and nvl(error_yn,'N')='N' and trunc(proc_date)  between to_date(nvl((?),'01/01/1000'),'dd/mm/yyyy hh24:mi') and to_date(nvl((?),'31/12/9999'),'dd/mm/yyyy hh24:mi') order by dummydate desc");

		stmt = con.prepareStatement(strBuffer.toString());
		stmt.setString(1,operating_facility_id);
		stmt.setString(2,Patient_Id);
		stmt.setString(3,start_date);
		stmt.setString(4,end_date);
		
		rs = stmt.executeQuery();
		int i=0;
		String term_set_id1="";
//System.out.println("rs----------"+rs.next());
		while(rs.next())
		{
			term_set_desc = checkForNull(rs.getString("TERM_SET_DESC"));
			term_set_id1 = checkForNull(rs.getString("TERM_SET_ID"));
			
			if(!prev_term_set_id.equals(term_set_desc))
			{
	
	%>		<table border='1' width='100%' id='dataTable' cellpadding='0' cellspacing='0' 						align='center' >
			<tr>
				<td colspan='' width='2%' class='CAGROUPHEADING' align='center' style='cursor:pointer' onClick='showRelatedProcedure(<%=k%>)' id='proc_tree<%=k%>'><font size="1" color='#6633FF'><B>--</B></font></td>
				<td colspan='8' width='98%' class='CAGROUPHEADING' align='left'><label onClick="callProceduredetail('<%=term_set_id1%>');" style='cursor:pointer'><font size="1" color='#6633FF'><b><%=term_set_desc%></b></font></label></td>
				
			</tr>
			</table> 
			<table border='1' cellspacing='0' cellpadding='0' width='100%' align='center' id='proc_detail<%=k%>' style='display:inline' >
			
	<%		i++;
			}
			prev_term_set_id = term_set_desc;
			if ( k%2 == 0 )
                classValue = "QRYEVEN" ;
             else
                classValue = "QRYODD" ;

			short_desc					= checkForNull(rs.getString("term_code_desc"));
			term_code					= checkForNull(rs.getString("term_code"));
			onset_date					= checkForNull(rs.getString("proc_date")); 
			status = "";
			priorityclass = "GREEN";
			out.println("<tr>");
			/*if(encounter_id1.equals("Y"))
				out.println("<td width='2%' class='BLUE'></td>");
			else
				out.println("<td width='2%' class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"')\">"+not_curr_enc+"</a></td>");
			*/
			out.println("<td width='2%' class='"+priorityclass+"'></td>");
			out.println("<td class='"+classValue+"' width='52%'><font size='1'>"+short_desc+"</font></td>");
			//out.println("<td class='"+classValue+"' width='50%'><font size='1'><a href=\"javascript:callDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+patient_class+"','"+onset_date+"', '"+notifiable_yn+"','"+dob+"','"+age+"','"+sex+"','"+occur_srl_no+"','"+(java.net.URLEncoder.encode(associate_codes.toString()))+"','"+Encounter_Id+"')\">"+short_desc+"</a></font><font color='blue' size='1'><b><a href=\"javascript:diffGroup('"+term_set_id+"','update','"+term_code+"')\">"+Diff_status+" </a></b></font></td>");
			out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+term_code+"</font></td>");
			out.println("<td class='"+classValue+"' width='16%'><font size='1'>"+onset_date+"</font></td>");
			//out.println("<td class='"+classValue+"' width='10%' align='center'><font size='1'><img src='../images/flow_text.gif' width='16' height='16' border=0 style='cursor:pointer' onclick=\"callClinicalNotes('','"+Patient_Id+"','"+patient_class+"','"+Encounter_Id+"','"+k+"')\"></font></td>");
			out.println("<td class='"+classValue+"' width='10%' align='center'><font size='1'><img src='../images/flow_text.gif' width='16' height='16' border=0 style='cursor:pointer' ></font></td>");
			out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+status+"</font></td>");
			
			
			out.println("</tr>");		
			out.println("<input type='hidden' name='accession_num"+k+"' id='accession_num"+k+"' value=''>");		
			k++;
			associate_codes = new StringBuffer();
			priorityclass = "";
		}
		
		  if(rs!=null)		rs.close();
		  if(stmt!=null)    stmt.close();

      %>


</table>		  


	<input type='hidden' name='qryStr' id='qryStr' value="<%=request.getQueryString()==null?"":request.getQueryString()%>" >
	<input type='hidden' name='Patient_Id' id='Patient_Id' value="<%=Patient_Id%>" >
	<input type='hidden' name='Encounter_Id' id='Encounter_Id' value="<%=Encounter_Id%>" >
	<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
	<input type="hidden" name = "Locn_Code" value ="<%=Locn_Code%>">
	<input type="hidden" name = "Locn_Type" value ="<%=Locn_Type%>">
	<input type="hidden" name = "Practitioner_Id" value ="<%=Practitioner_Id%>">
	<input type="hidden" name = "relationship_id" value ="<%=relationship_id%>">
	<input type="hidden" name = "modal_yn" value ="<%=modal_yn%>">
</form>
</body>
</html>

<%
}
catch(Exception e)
{
	//out.println("Exception @ try "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

