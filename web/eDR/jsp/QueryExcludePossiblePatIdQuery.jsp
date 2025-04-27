<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>


<html>
	<head>
		
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eDR/js/QueryExcludePossibleDuplicates.js'></script>
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
			Connection          con         =  null;
			java.sql.Statement	stmt		=  null;
			ResultSet	        rs			=  null;

			String              patient_id  =  "";
			String              name        =  "";
			 String locale=(String)session.getAttribute("LOCALE");  
			try
			{
				con                         =  ConnectionManager.getConnection(request);
				stmt	                    =  con.createStatement();
				int pat_id_length           =  0;
				int pat_id_size             =  0;
				String str                  =  "";

				patient_id                  =request.getParameter("patient_id");
				if(patient_id==null)patient_id="";
				demography d=new demography();
				name =d.name_age_sex(session ,patient_id,con,locale);
				

				str = "select patient_id_length from mp_param";
				rs = stmt.executeQuery(str);
				
				if(rs!=null)
				{
					while (rs.next())
				    {
					pat_id_length = rs.getInt("patient_id_length");
				    }
				}if(rs   != null) rs.close();
				pat_id_size = pat_id_length + 2;
						
		%>
	<body onLoad="query_form.patient_id.focus()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='query_form' id='query_form'>
	  <table width='100%' cellspacing='0'>
		  <tr>
			<td colspan='1' class='label'>&nbsp;</td>
		    <td colspan='1' class='label'>&nbsp;</td>
		 </tr>
		 <tr>
			<td class='label' width='40%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields' width='60%'>
			<input type='text' name='patient_id' id='patient_id' size='20' maxlength=<%=pat_id_length%> value='<%=patient_id%>'  onKeyPress='CheckForSpecChars(event);'><input type='button' class='button' value='?' onClick ="callPatientSearch()"></td>
		</tr>
		<tr>
			<td class='label'>&nbsp;</td>
		    <td id='PatDetID' class='label'><%=name%></td></tr>
		<tr> <!-- below Search button name changed against ML-MMOH-SCF-0760 by Mano-->
			<td class='button' colspan=2 align='right' ><input type='button' class=button  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='execute_query()';></td>
		</tr>
	</table>
<%
			if(rs   != null) rs.close();
			if(stmt != null) stmt.close();
		}
			catch(Exception e)
			{
				out.println("Exception From File QueryExcludePossibleQuery"+e.toString());
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
			
%>
	</form>
	</body>
	</html>

