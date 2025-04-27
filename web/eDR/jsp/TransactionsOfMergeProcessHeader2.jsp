<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" %>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/TransactionsOfMergeProcess.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>	
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str				= "";
	String p_patient_id		= "";
	String p_patient_line	= "";

	int p_pat_count			= 0;
	int p_dup_group_id	    = 0; 
	int p_pat_rec_cnt		= 0;

	String whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");

	String sql			= "";
	String strsql1		= "";
	String p_order_by	= "";
	String p_dup_ind	= "";
String locale = (String)session.getAttribute("LOCALE");
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if((whereClause == null || whereClause.equals("")))
		{
			sql	= "";

			p_patient_id	= request.getParameter("patient_id");
			if(p_patient_id == null) p_patient_id = "";
		
			sql	= "WHERE dup_indicator = 'V' AND group_status = 'E' AND patient_id = nvl(('"+p_patient_id+"'), patient_id) ";
		}
		else
		{
			sql = whereClause;
		}

		int x			= 0;
		int time_count	= 0;
		int start		= 0;
		int end			= 0;
		int i			= 1;

		if(from == null) start = 1 ;
		else start = Integer.parseInt( from ) ;

		if(to == null) end = 5 ;
		else end = Integer.parseInt( to ) ;
		
		strsql1="SELECT count(1) AS TOTAL FROM dr_dup_group_vw2 "+  sql + " AND dup_group_id LIKE '%%'";
		rs = stmt.executeQuery(strsql1);
		{
			rs.next();
		} if(rs != null) rs.close();
		%>
		<form name='group_header_form' id='group_header_form'>
			<table border='0' width='100%' cellspacing='0' id='tb1'>
				<tr>
					<td class=label width='5%'></td>
					<td class=label width='75%'></td>
					<td class=label width='20%'></td>
				</tr>
				<%
				if(p_patient_id.length() > 0)
				{
					str = "SELECT count(1) TOTAL FROM dr_dup_group_vw2 " + sql + " AND dup_group_id LIKE '%%' ";
					rs = stmt.executeQuery(str);
					if(rs.next())
					{
						p_pat_rec_cnt = rs.getInt("total");
					} if(rs != null) rs.close();

					if(p_pat_rec_cnt == 0)
					{
						%>
						<script> 
							var ErrorText = getMessage("NO_RECORD","DR");
							parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
						</script>
						<%
					}
				}
				else
				{
					%>
					<script> 
						var ErrorText = '';
						parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
					</script>
					<%
				}
				
				str  = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl ";
				rs	 = stmt.executeQuery(str);
				if(rs.next())
				{
					p_order_by = rs.getString("order_by_for_process_cycle")==null?"":rs.getString("order_by_for_process_cycle");
				} if (rs != null) rs.close();
				
				str  = "SELECT dup_group_id, patient_id,SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line, pat_count, mp_patient_added_date, dup_indicator FROM dr_dup_group_vw2 " + sql + " AND dup_group_id LIKE '%%' ";
				if(!p_order_by.equals(""))	
		           {
					str=str+" ORDER BY "+p_order_by;
				   }
				rs	= stmt.executeQuery(str);
				if(rs != null)
				{
					if(start != 1)
						for(int j=1; j<start; i++,j++)
						{	
							rs.next();						  
						}
						while(rs.next() && i <= end)
						{
							x = x + 1;
							time_count++;

							p_patient_id	= rs.getString("patient_id");
							p_pat_count		= rs.getInt("pat_count");
							p_patient_line	= rs.getString("patient_line");
							p_dup_group_id  = rs.getInt("dup_group_id");
							p_dup_ind		= rs.getString("dup_indicator");
                                                        
							%>
							<tr id='_<%=p_patient_id%>'>
								<td class='label' valign='top'><a href='javascript:viewPatientDetails("<%=p_patient_id%>","<%=p_dup_ind%>")'>+</a></td>
								<td colspan='2' class='label'><a name='<%=x%>' onClick='changeRowColor(this,3)' href='javascript:callDupGroupDetails("<%=p_patient_id%>","<%=p_dup_group_id%>","<%=p_pat_count%>","E")' id='_a<%=p_patient_id%>'>&nbsp;<%=p_patient_id%></a><br>
								<font size=1>&nbsp;&nbsp;&nbsp;&nbsp;<%=p_patient_line%> </font>
								</td>
								<td align='right' valign=top class='label'><%=p_pat_count%></td>
							</tr>
							<%
								i++;
							}
						} if(rs != null) rs.close();
					%>
				</table>
				<input type=hidden name=p_patcount id=p_patcount value=0>
			</form>
			<%
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
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

