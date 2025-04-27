<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ page import="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css'
	href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 <script language='javascript' src='../../eDR/js/ExcludePossibleDuplicates.js'></script>
	 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	 <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

     </head>
     <body onMouseDown="CodeArrest()" onKeyDown="lockKey();">
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet	rs			= null;

		
	String classValue		= "";
	//String str				= "";
	String max_record_sql	= "";
	String search_sql		= "";
	String p_patient_id1	= "";
	String p_patient_id2	= "";
	String p_patient_name1	= "";
	String p_patient_name2	= "";
    String  patid2    ="";
	String  patid1    ="";
	String chkBoxes[]= new String[10];
	int max_record	= 0;
	int start		= 0;
	int end			= 0;
	int i			= 1;
	int count		= 0;
	int row_chkbox	= 0;

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String from				= request.getParameter("from");
		String to				= request.getParameter("to");
		String criteria			= request.getParameter("criteria");
		String patient_id		= request.getParameter("patient_id");
        String chkStr= request.getParameter("chkVls")==null?"":request.getParameter("chkVls");
		String chkStr1="";
		if(from == null || from.equals("")) from = "";
		if(to == null || to.equals("")) to = "";
		if(criteria == null || criteria.equals("")) criteria = "";
		if(patient_id == null || patient_id.equals("")) patient_id = "";

		//demography d	= new demography();
        chkStr=chkStr.trim();
		//if(from == null || from.equals("")) 
		if( from.equals(""))
		{	
		start =1 ;
			}
		else start=Integer.parseInt(from);
   		if( to == null || to.equals("")) end = 8;
		//if( to.equals(""))  end = 8;
		else end =Integer.parseInt(to);
       	//This query is only to find out the maximum distinct records
		if(patient_id.equals(""))
		{
		max_record_sql = "SELECT count(*) FROM dr_not_dup_patients WHERE (patient_id1 = nvl(null, patient_id1) OR patient_id2 = nvl(null, patient_id2))";
		}
		else
		{
		  max_record_sql = "SELECT count(*) FROM dr_not_dup_patients WHERE (patient_id1 = NVL ('"+patient_id+"', patient_id1) OR patient_id2 = NVL ('"+patient_id+"', patient_id2) )";
		}

		rs = stmt.executeQuery(max_record_sql);
		if(rs != null)
		{
			while(rs.next())
			{
				max_record = rs.getInt(1);
			}

			if(max_record == 0)
			{
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
		} if(rs != null) rs.close();
		search_sql = "SELECT (CASE WHEN INSTR (Get_dup_Patient_line (patient_id1,'"+localeName+"'), '#') > 0 THEN SUBSTR (Get_dup_Patient_line (patient_id1,'"+localeName+"'), 1, INSTR (Get_dup_Patient_line (patient_id1,'"+localeName+"'), '#') - 1)  ELSE SUBSTR (Get_Patient_line (patient_id1,'"+localeName+"'), 1, INSTR (Get_Patient_line (patient_id1,'"+localeName+"'), '#') - 1 ) END ) patient_id1, (CASE WHEN INSTR (Get_dup_Patient_line (patient_id2,'"+localeName+"'), '#') > 0 THEN SUBSTR (Get_dup_Patient_line (patient_id2,'"+localeName+"'), 1, INSTR (Get_dup_Patient_line (patient_id2,'"+localeName+"'), '#') - 1 ) ELSE SUBSTR (Get_Patient_line (patient_id2,'"+localeName+"'), 1, INSTR (Get_Patient_line (patient_id2,'"+localeName+"'), '#') - 1 ) END) patient_id2 FROM dr_not_dup_patients WHERE (patient_id1 = NVL ('"+patient_id+"', patient_id1) OR patient_id2 = NVL ('"+patient_id+"', patient_id2) )";
		rs = stmt.executeQuery(search_sql);
		
		
		chkStr=chkStr+"00000000";
		
		if(chkStr != null && !chkStr.equals(""))
		{
			chkStr1	= chkStr.substring(start-1,end);
	 		for(int k=1; k<=8; k++)
			{
				if(chkStr1.indexOf(String.valueOf(k))!=-1) { chkBoxes[k]="CHECKED";
										
						}
				else { chkBoxes[k]	= "UNCHECKED"; }
			}
		}
		else
		{ 
			for(int k=1; k<=8; k++) { chkBoxes[k]	= "UNCHECKED"; }
		}
				
		%>
<body onLoad='button_disable("<%=start%>","<%=end%>","<%=max_record%>","1","8")'>
	
	<form name='result_form' id='result_form' action='../../servlet/eDR.ExcludePossibleDuplicateServlet' method='post' target='messageFrame'>
		
	<table border='0' width='90%' cellspacing='0' align='center'>
		<br>
		<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
			
			<tr>
				<td colspan='3' class='WHITE'>&nbsp;</td>
				<td  class='WHITE'><input type='button' class='button' name='patient_details' id='patient_details' value='<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/>' onClick="patient_details_view();">
				</td>
			</tr>
			<tr>
				<td colspan='3' class='WHITE'>&nbsp;</td>
				<td class='WHITE'><input type='button' class='button' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/> ' onClick="call_previous('1','8');" disabled><input type=button  class='button' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>'  onClick="call_next('1','8');" disabled>
				</td>
			</tr>
	</table>
		
	<table border='1' width='90%' cellpadding='0' cellspacing='0' align='center' ID='tb1'>
		<br>
			    <tr>
				<td class='label' width=''></td> 
				<td class='label' width=''></td>			
				<td class='label' width=''></td>
				<td class='label' width=''></td>
			    </tr>
			<input type='hidden' name='start' id='start' value='<%=start%>'>
			<input type='hidden' name='end' id='end' value='<%=end%>'>
			<input type='hidden' name='max_record' id='max_record' value='<%=max_record%>'> 
			
			<td class='COLUMNHEADER' colspan='6' ><fmt:message key="eDR.ExcludedPossibleDuplicates.label" bundle="${dr_labels}"/></td>
		
			<tr>		
				<td width='4%' class='data'><b><fmt:message key="Common.delete.label" bundle="${common_labels}"/></b></td>
				<td>&nbsp;</td>
				<td width='' class='data'><b><fmt:message key="eDR.PatientID1.label" bundle="${dr_labels}"/></b></td>
				<td width='1%'>&nbsp;</td>
				<td width='' class='data'><b><fmt:message key="eDR.PatientID2.label" bundle="${dr_labels}"/></b></td>
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

			count = 0;
			

			int j=1;

			if(rs != null)
			{
				while(rs.next() && i <= end)
				{
					p_patient_id1	= rs.getString("patient_id1");
					p_patient_id2	= rs.getString("patient_id2");

					if(p_patient_id1 == null || p_patient_id1.equals("")) p_patient_id1 = "";
					if(p_patient_id2 == null || p_patient_id2.equals("")) p_patient_id2 = "";

									
					
					int flag	=0;	
						
					if(!p_patient_id1.equals(""))
					{
					flag = p_patient_id1.lastIndexOf(',');
						if(flag>1)
						{
					p_patient_name1 = p_patient_id1.substring(0,flag);
					int length1		= p_patient_id1.length();
					 patid1	= p_patient_id1.substring((flag+2),(length1-1));
				}
					}
					if(!p_patient_id1.equals(""))
					{
				
					flag=p_patient_id2.lastIndexOf(',');
										
					if(flag>1)
						{
					p_patient_name2 = p_patient_id2.substring(0,flag);
					int length2		= p_patient_id2.length();
                  	patid2	= p_patient_id2.substring((flag+2),(length2-1));
						}
					}
					count++;

					if(i % 2 == 0) classValue = "QRYEVEN" ;
					else classValue = "QRYODD" ;

			
					if(!patid1.equals("") || (!patid2.equals("")))
					{
					out.println("<tr><td class='" + classValue + "' >&nbsp;");
					out.println("<input type='checkbox' name='checkbox"+j+"' id='checkbox"+j+"' "+chkBoxes[j]+" onClick='call_rowchk(this)'>");
					
					
										
					out.println("</td>");

					out.println("<td class='" + classValue + "'><a href=javascript:viewPatientDetails('"+patid1+"')>");
					out.println("&nbsp;+</a></td><td class='" + classValue + "'><font size=2>");
					out.println(patid1+"&nbsp;"+p_patient_name1);
					out.println("</td>");
                   
					
					out.println("<td class='" + classValue + "'><a href=javascript:viewPatientDetails('"+patid2+"')>");
					out.println("&nbsp;+</a></td><td class='" + classValue + "'><font size=2 >");
					out.println(patid2+"&nbsp;"+p_patient_name2);
					out.println("</td>");
					out.println("</tr>");
					out.println("<input type=hidden name='view_pat1_id"+j+"' id='view_pat1_id"+j+"' value='"+patid1+"'>");
					out.println("<input type=hidden name='view_pat2_id"+j+"' id='view_pat2_id"+j+"' value='"+patid2+"'>");
                   
                    j++; 
					i++;
					row_chkbox++;
				}
				}
			 }
			 %>
			 <input type='hidden' name='start' id='start' value='<%=start%>'>
			<input type='hidden' name='end' id='end' value='<%=end%>'>
			<input type='hidden' name='max_record' id='max_record' value='<%=max_record%>'> 
			<input type='hidden' name='count' id='count' value='<%=count%>'> 
			<input type='hidden' name='mode' id='mode' value='delete'>
			<input type='hidden' name='fin_patient_id' id='fin_patient_id' value=''> 
		    <input type='hidden' name='CheckBoxes' id='CheckBoxes' value=''> 
			<input type='hidden' name='chkedVls' id='chkedVls' value=''>  
			   
			 
			 </table>
	</form>
	<%
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	
	}
	catch(Exception e)
	{
		out.println("Exception e :"+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

