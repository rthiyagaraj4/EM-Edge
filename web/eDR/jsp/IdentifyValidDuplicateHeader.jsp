<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ page import ="java.sql.*, java.text.*, webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" import="eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/IdentifyValidDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eDR/js/DRrowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()' >
<%
	String locale = (String)session.getAttribute("LOCALE");

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt			= con.createStatement();

		String str				= "";
		String p_patient_id		= "";
		String p_patient_line	= ""; 
		int p_dup_group_id	= 0;		
		int p_pat_count		= 0; 		

		int tot_rec = 0;

		String modal		= request.getParameter("modal");		
		String from 		= request.getParameter("from");
		String to			= request.getParameter("to");

		String grp_no = "";

		grp_no =  request.getParameter("grp_no")==null?"":request.getParameter("grp_no");

		if(!(grp_no.equals("")))
			tot_rec = Integer.parseInt(grp_no);

		int x			= 0;
		int time_count	= 0;
		int start 		= 0;
		int end 		= 0;
		int i			= 1;

		if(from == null) start = 1 ;
		else start = Integer.parseInt(from);

		if(to == null) end = 10;
		else end = Integer.parseInt(to);
		
		if(start > tot_rec)
		{
			start = start-10;
		    end = end-10;
			if(start <= 0) start = 1;				
			if(end <= 0) end = 1;				
		}
		
		%>
	<form name='group_header_form' id='group_header_form'>
	 <table border='0' width='100%' cellspacing='0'  id='tb1' > 
		 <tr>
			<td class='label' width='5%'></td>
			<td class='label' width='75%'></td>
			<td class='label' width='20%'></td>
		</tr> 
		
		<% 	

		str=" SELECT b.dup_group_id, patient_id, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line, pat_count, mp_patient_added_date FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND system_gen_yn='Y' AND marked_for_merge_yn='N' AND group_status = 'U' AND sug_valid_pat_flag='Y' "; 	    
		
		rs  = stmt.executeQuery(str);
	
		if(rs != null)
		{
			if(start != 1)
			for(int j=1; j<start; i++,j++)
			{	
				rs.next();						  
			}
			while( rs.next() && i<=end)
			{
				x = x + 1;
				time_count++;

				p_patient_id    = rs.getString("patient_id");
				p_pat_count     = rs.getInt("pat_count");
				p_patient_line	= rs.getString("patient_line") ;
				p_dup_group_id  = rs.getInt("dup_group_id");
                
				
				%>
				<!-- <table border='0' width='100%' cellspacing='0'  id='tb1' >
				 <tr>
					<td class='label' width='5%'></td>
					<td class='label' width='75%'></td>
					<td class='label' width='20%'></td>
				</tr> -->
				<tr id='_<%=p_patient_id%>'>
					<td class='label' valign='top'><a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>+</a></td>
					<td colspan='2' class='data'><a name='<%=x%>' onClick='changeRowColor(this,3)' href='javascript:callDupGroupDetails("<%=p_patient_id%>","<%=p_dup_group_id%>","<%=p_pat_count%>")' id='_a<%=p_patient_id%>'>
					<%=p_patient_id%> 
					</a><br><font size='1'><%=p_patient_line%></font></td>
					<td align='right' valign=top class='label'>
									<%=p_pat_count%> 
								</td>
					</tr>
					
				
				<%
				i++;
			}
		} if(rs != null) rs.close();

		%>
		</table>
		
		<input type='hidden' name='p_patcount' id='p_patcount' value='0'>
	    <input type='hidden' name='modal' id='modal' value='<%=modal%>'>
		<input type='hidden' name='patient_id' id='patient_id' value='<%=p_patient_id%>'>
		<input type='hidden' name='start' id='start' value='<%=start%>'>
		<input type='hidden' name='end' id='end' value='<%=end%>'>
		
		</form>
		<%

		if(rs != null)	rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

