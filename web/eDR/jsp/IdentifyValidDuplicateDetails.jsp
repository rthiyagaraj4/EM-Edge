<!DOCTYPE html>
<!-- Developed By       :  P.Sudhakaran -->
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
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
<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<%
	String locale = (String)session.getAttribute("LOCALE");
	
	Connection con				= null;
	java.sql.Statement	stmt	= null;
	java.sql.Statement	stmt1	= null;
	ResultSet	rs				= null;
     ResultSet	rs1				= null;
	String p_dup_group_id		= "";
	String p_valid_duplicate	= "";
	String p_valid_check		= "";
	String p_dup_check			= "";
	String p_not_check			= "";
	String p_exc_check			= "";
	String p_patient_line		= "";
	String p_line				= "";
	String p_dup_count			= "";
	String p_order_by			= "";
	String str					= "";
	int encounter				= 0;
	StringBuffer p_linesb=null;
	String Facility	="";
     String pat_series="";
	int i = 0;

	try
	{
		p_linesb        = new StringBuffer();
		Facility		= (String) session.getValue("facility_id");
		con				= ConnectionManager.getConnection(request);
		stmt			= con.createStatement();
	   stmt1          = con.createStatement();
		String p_patient_id		= request.getParameter("patient_id");;
		String modal			= request.getParameter("modal");

		if(modal == null) modal = "N";
		
		p_dup_count				= request.getParameter("p_pat_count");

		if(p_patient_id == null)
		{
			p_patient_id = "";
		}

		//str  = "SELECT dup_group_id, pat_count FROM dr_dup_group_vw2 WHERE group_status IN ('U','I') AND system_gen_yn = 'Y' AND patient_id = nvl(('"+p_patient_id+"'), patient_id) ";

		str  = "SELECT b.dup_group_id, pat_count FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND group_status IN ('U','I') AND system_gen_yn = 'Y' AND patient_id = NVL(('"+p_patient_id+"'), patient_id)";
		
		rs	= stmt.executeQuery(str);
		if(rs != null)
		{
			if(rs.next())
			{
				p_dup_group_id = rs.getString("dup_group_id");
				p_dup_count    = rs.getString("pat_count") ;
				%>
				<script>
					parent.frames[1].document.getElementById('p_patcount').value = <%=p_dup_count%>; 
					if(parent.frames[4].document.getElementById('duplicatesdetails').disabled == true)
					{
						parent.frames[4].document.getElementById('duplicatesdetails').disabled = false;
					}
				</script>
				<%			
			}
			else
			{
				%>
				<script>
					var ErrorText = getMessage('NO_RECORD','DR');
					parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
					parent.frames[4].document.getElementById('duplicatesdetails').disabled = true;
				</script>
				<%
			}
		} if(rs != null) rs.close();

		str  = "select decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle from dr_process_ctl " ;
		rs	 = stmt.executeQuery(str);
		if(rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle");
		} if(rs != null) rs.close();

		//str   = "SELECT dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate, patient_line,( SELECT Count(*) FROM pr_encounter WHERE patient_id=dr_dup_group_vw2.patient_id) counts FROM dr_dup_group_vw2 WHERE group_status = 'U'  and  dup_group_id='"+p_dup_group_id+"' ORDER BY "+p_order_by+" ";

		str   = "SELECT b.dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line,  ( SELECT COUNT(*) FROM pr_encounter WHERE patient_id=b.patient_id) counts FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND group_status = 'U'  AND b.dup_group_id='"+p_dup_group_id+"' ORDER BY "+p_order_by+" ";		
		
		rs	    = stmt.executeQuery(str);
		%>
		<form name='group_details_form' id='group_details_form' action='../../servlet/eDR.IdentifyValidDuplicateServlet' method='post' target='messageFrame'>
		<table border='0' width='100%' cellspacing='0' cellpadding='0' >
			<%
			if(rs != null)
			{
				while(rs.next())
				{
					i++;
					p_patient_id		= rs.getString("patient_id") ;
					p_valid_duplicate	= rs.getString("valid_duplicate");
					p_patient_line		= rs.getString("patient_line") ;
					encounter			= rs.getInt("counts") ;
								

					//p_line	+=	p_patient_id+"|";
					p_linesb.append(p_patient_id);
                    p_linesb.append("|");
					
					if(p_valid_duplicate.equals("V"))
					{
						p_valid_check = "checked";
						p_dup_check   = "unchecked";
						p_not_check	  = "unchecked";
						p_exc_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("D"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "checked";
						p_not_check	  = "unchecked";
						p_exc_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("X"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check	  = "checked";
						p_exc_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("E"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check	  = "unchecked";
						p_exc_check   = "checked";
					}
				

					String str1="SELECT PAT_SER_GRP_CODE FROM mp_patient WHERE patient_id='"+p_patient_id+"'";
					rs1 = stmt1.executeQuery(str1);
					while(rs1.next())
					{	
					pat_series=rs1.getString("PAT_SER_GRP_CODE");
					}
if(rs1!=null) rs1.close();
					%>
					<tr>
						<td width='7%' align='center'> <input type=checkbox name='selectpatient<%=i%>' id='selectpatient<%=i%>' onClick='javascript:checkDuplicatesDetails("<%=p_patient_id%>","<%=i%>")' ></td>
						
						<td width='15%' class='data'>&nbsp;&nbsp;&nbsp;&nbsp; <%=pat_series%></td>
						
						<td width='4%' class='label' >
					<%	if(encounter >0)
						{	%><a href='javascript:encounterdetails("<%=p_patient_id%>")'>E</a><%}else{%>E<%}%></td>
						<td width='40%' class='data'   colspan='1' >&nbsp;<font size=1><a href='javascript:viewPatientDetails("<%=p_patient_id%>")'><%=p_patient_id%></a></font><input type='hidden' name='selectpatientid<%=i%>' id='selectpatientid<%=i%>' value='<%=p_patient_id%>'></td>
						<td width='10%' align='center'>&nbsp;&nbsp;&nbsp;<input type='radio' name='dupindicator<%=i%>' id='dupindicator<%=i%>'  <%=p_valid_check%> value='V' onclick='assign_value(this,<%=i%>);'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width='10%' align='center'><input type='radio' name='dupindicator<%=i%>' id='dupindicator<%=i%>' value='D'  <%=p_dup_check%> onclick='assign_value(this,<%=i%>);'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width='20%' align='center'><input type='radio' name='dupindicator<%=i%>' id='dupindicator<%=i%>'  <%=p_not_check%> value='X' onclick='assign_value(this,<%=i%>);'><input type='hidden' name='chk_value<%=i%>' id='chk_value<%=i%>' value='<%=p_valid_duplicate%>'><input type='hidden' name='p_value<%=i%>' id='p_value<%=i%>' value='<%=p_patient_id%>'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width='10%' align='center'><input type='radio' name='dupindicator<%=i%>' id='dupindicator<%=i%>'  <%=p_exc_check%> value='E' onclick='assign_value(this,<%=i%>);'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        </td>
					    </tr>
					    <tr>
						<td width='7%'></td>
						<td width='14%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td class='data' colspan='6'><font size=1><%=p_patient_line%> </font></td>
					</tr>
					<%
				}
			} 
			p_line=p_linesb.toString();
			
			if(i==0)
		      {     %> <script>
					var ErrorText = getMessage('NO_RECORD','DR');
					parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
					parent.frames[4].document.getElementById('duplicatesdetails').disabled = true;
				</script>
					<% }if(rs != null) rs.close();
				              
			
			%>               
 			</table>
			<input type=hidden name="exclude_mode" id="exclude_mode" value="N">
			<input type=hidden name=patcount id=patcount value=0>
			<input type=hidden name=patient_id1 id=patient_id1 value=''>
			<input type=hidden name=patient_id2 id=patient_id2 value=''>
			<input type=hidden name=p_dup_group_id id=p_dup_group_id value=<%=p_dup_group_id%>>
			<input type=hidden name=p_dup_count id=p_dup_count value=<%=p_dup_count%>>
			<input type=hidden name=p_line id=p_line value=<%=p_line%>>
			<input type=hidden name=count id=count value=<%=i%>>
			<input type=hidden name='final_chk_values' id='final_chk_values' value=''>
			<input type=hidden name='modal' id='modal' value='<%=modal%>'>
			<input type=hidden name='del_header' id='del_header' value='N'>
			<input type=hidden name='function_name' id='function_name' value='I'>
			<input type=hidden name='facility_id' id='facility_id' value='<%=Facility%>'>
		</form>
	<%
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

