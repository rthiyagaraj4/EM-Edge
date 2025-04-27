<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>

<html>
<head>
	<!--  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 <script language='javascript' src='../../eDR/js/QueryExcludePossibleDuplicates.js'></script>
	 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	 <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey();">
<%	
	Connection          con      = null;
	java.sql.Statement	stmt     = null;
	ResultSet	        rs		 = null;

	String classValue		     = "";
   // String str				     = "";
    String max_record_sql	     = "";
    String search_sql		     = "";
	String p_patient_id1	     = "";
    String p_patient_id2	     = "";
    String p_patient_name1       = "";
    String p_patient_name2	     = "";

	int max_record			     = 0;
	int start				     = 0;
	int end					     = 0;
	int i					     = 1;
	int count				     = 0;
	int row_chkbox			     = 0;

	demography d;

try
 {
	con                          = ConnectionManager.getConnection(request);
	stmt					     = con.createStatement();

	String from				     = request.getParameter("from");
	String to				     = request.getParameter("to");
	String criteria			     = request.getParameter("criteria");
	String patient_id		     = request.getParameter("patient_id");

	if(from == null || p_patient_id1.equals(null)) from = "";
    
	if(to == null || to.equals(null)) to = "";
	if(criteria == null || criteria.equals("null")) criteria = "";
	if(patient_id == null || patient_id.equals("null")) patient_id ="";

	d=new demography();

	
	if ( from == null || from.equals(""))
	    start = 1 ;
	else
	   start = Integer.parseInt(from) ;
	if ( to == null || to.equals(""))
	   end = 8 ;
	else
	   end = Integer.parseInt( to ) ;
 if(patient_id.equals(""))
	 {
	max_record_sql="select count(*) from dr_not_dup_patients where (patient_id1= nvl(null,patient_id1) or patient_id2 = nvl(null,patient_id2) )";
	 }
	else
		{
		  max_record_sql = "SELECT count(*) FROM dr_not_dup_patients WHERE (patient_id1 = NVL ('"+patient_id+"', patient_id1) OR patient_id2 = NVL ('"+patient_id+"', patient_id2) )";
		}
	rs=stmt.executeQuery(max_record_sql);
	if(rs!=null)
	{
			while(rs.next())
			{
			max_record=rs.getInt(1);
			}
	} if(rs!=null) rs.close();
    
	if (max_record==0) 
	 {
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
		out.println("parent.pat_search.document.location.href ='../../eDR/jsp/QueryExcludePossiblePatIdQuery.jsp';");
		out.println("parent.dup_display.document.location.href ='../../eCommon/html/blank.html';</script>");
	 }
	    
	else
	{
		/*search_sql="select patient_id1,patient_id2 from dr_not_dup_patients where (patient_id1= nvl('"+patient_id+"',patient_id1) or patient_id2 = nvl('"+patient_id+"',patient_id2) )";*/

		search_sql="SELECT (CASE WHEN INSTR (Get_dup_Patient_line (patient_id1,'"+localeName+"'), '#') > 0 THEN SUBSTR (Get_dup_Patient_line (patient_id1,'"+localeName+"'), 1, INSTR (Get_dup_Patient_line (patient_id1,'"+localeName+"'), '#') - 1)  ELSE SUBSTR (Get_Patient_line (patient_id1,'"+localeName+"'), 1, INSTR (Get_Patient_line (patient_id1,'"+localeName+"'), '#') - 1 ) END ) patient_id1, (CASE WHEN INSTR (Get_dup_Patient_line (patient_id2,'"+localeName+"'), '#') > 0 THEN SUBSTR (Get_dup_Patient_line (patient_id2,'"+localeName+"'), 1, INSTR (Get_dup_Patient_line (patient_id2,'"+localeName+"'), '#') - 1 ) ELSE SUBSTR (Get_Patient_line (patient_id2,'"+localeName+"'), 1, INSTR (Get_Patient_line (patient_id2,'"+localeName+"'), '#') - 1 ) END) patient_id2 FROM dr_not_dup_patients WHERE (   patient_id1 = NVL ('"+patient_id+"', patient_id1) OR patient_id2 = NVL ('"+patient_id+"', patient_id2) )";
		
		rs=stmt.executeQuery(search_sql);
	}
	%>
	<body onLoad='button_disable("<%=start%>","<%=end%>","<%=max_record%>","1","8")'>
	<form name='result_form' id='result_form' >
	<table border=0 width='90%' cellspacing=0 align='center'>
	<br>
		<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
		<tr>
		   <td colspan='3' class='WHITE'></td>
		   <td class='WHITE'></td>
	   </tr>
	   <tr>
		   <td colspan='3' class='WHITE'></td>
		   <td class='WHITE'><input type=button class=button name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/> ' onClick="call_previous('1','8');" disabled><input type=button  class=button name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>'  onClick="call_next('1','8');" disabled></td>
   	  </tr>
	</table>
	<table border=1 width='90%' cellpadding=0 cellspacing=0 align='center' ID='tb1'>
	<br>
				<tr>
					<td class=label width=''></td>
					<td class=label width=''></td>
					<td class=label width=''></td>
					<td class=label width=''></td>
				</tr>
			<input type='hidden' name='start' id='start' value='<%=start%>'>
			<input type='hidden' name='end' id='end' value='<%=end%>'>
			<input type='hidden' name='max_record' id='max_record' value='<%=max_record%>'> 
			<th colspan=6 align=left><fmt:message key="eDR.ExcludedPossibleDuplicates.label" bundle="${dr_labels}"/></th>
			<tr>		
				<td width='1%' class='label'><b>&nbsp;</b></td>
				<td width='' class='Label'><b><fmt:message key="eDR.PatientID1.label" bundle="${dr_labels}"/></b></td>
				<td width='1%' class='label'><b>&nbsp;</b></td>
				<td width='' class='Label'><b><fmt:message key="eDR.PatientID2.label" bundle="${dr_labels}"/></b></td>
			</tr>
	<%
			if(start != 1)
			{
				for(int j=1; j<start; i++,j++)
				{
					if(rs != null)
					{
						rs.next() ;
					}
				}
			}

			
				  count=0;
				  if(rs!=null)
					  {
					  while ( rs.next() && i<=end )
						{
							p_patient_id1	= rs.getString("patient_id1");
							p_patient_id2	= rs.getString("patient_id2");
							if(p_patient_id1 == null || p_patient_id1.equals("")) p_patient_id1 = "";
							if(p_patient_id2 == null || p_patient_id2.equals("")) p_patient_id2 = "";

							/*p_patient_name1	= d.name_age_sex(session ,p_patient_id1,con);
							p_patient_name2	= d.name_age_sex(session ,p_patient_id2,con);				  
							int flag        = p_patient_name1.lastIndexOf(',');
							p_patient_name1 = p_patient_name1.substring(0,flag);
							flag            = p_patient_name2.lastIndexOf(',');
							p_patient_name2 = p_patient_name2.substring(0,flag);*/

							int flag		= p_patient_id1.lastIndexOf(',');
							p_patient_name1 = p_patient_id1.substring(0,flag);
							int length1		= p_patient_id1.length();
							String patid1	= p_patient_id1.substring((flag+2),(length1-1));

							flag			= p_patient_id2.lastIndexOf(',');
							p_patient_name2 = p_patient_id2.substring(0,flag);
							int length2		= p_patient_id2.length();
							String patid2	= p_patient_id2.substring((flag+2),(length2-1));

						count++;
						if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
						else
						classValue = "QRYODD" ;
						out.println("<tr><td class='" + classValue + "'><a href=javascript:viewPatientDetails('"+patid1+"')>");
						out.println("&nbsp;+</a></td><td class='" + classValue + "'><font size=2 >");
						out.println(patid1+"&nbsp;"+p_patient_name1);
						out.println("</td>");
						out.println("<td class='" + classValue + "'><a href=javascript:viewPatientDetails('"+patid2+"')>");
						out.println("&nbsp;+</a></td><td class='" + classValue + "'><font size=2 >");
						out.println(patid2+"&nbsp;"+p_patient_name2);
						out.println("</td>");
						out.println("</tr>");
						out.println("<input type=hidden name='view_pat1_id"+i+"' id='view_pat1_id"+i+"' value='"+patid1+"'>");
						out.println("<input type=hidden name='view_pat2_id"+i+"' id='view_pat2_id"+i+"' value='"+patid2+"'>");
						i++;
						row_chkbox++;
						}
					 }if(rs!=null) rs.close();
		
	%>
	<input type='hidden' name='count' id='count' value='<%=count%>'> 
	<input type='hidden' name='mode' id='mode' value='delete'>
	<input type='hidden' name='fin_patient_id' id='fin_patient_id' value=''> 
	</table>
	</form>
	<%
	 if (stmt!=null) stmt.close();
	 if (rs!=null) rs.close();
  }
	
   catch(Exception e)
   {
	   out.println("Exception in the File QueryExcludePossiblePatIdQueryResult"+e.toString());
	   e.printStackTrace();
   }
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
<!-- <script>
parent.frames[1].document.getElementById("Execute").disabled=false;
</script> -->
</body>
</html>

