<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
	<script language='javascript' src='../../eDR/js/PossibleDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey();'>

<%
	String locale=(String)session.getAttribute("LOCALE");
	Connection con				= null;
	java.sql.Statement	stmt	= null;
	ResultSet	rs				= null;
	
	String str				= "";
	String p_patient_id		= "";
	String p_patient_line	= "";

	int p_dup_group_id	    = 0; 
	int p_pat_count			= 0;
	int p_pat_rec_cnt		= 0;

	String whereClause = request.getParameter("whereclause");
	if(whereClause == null || whereClause.equals("null")) whereClause = "";
	
	String from = request.getParameter("from");
	String to	= request.getParameter( "to");

	String sql			= "";
	String strsql1		= "";
	String p_order_by	= "";

	StringBuffer SelectSQLBuffer = null;
	SelectSQLBuffer				 = new StringBuffer();

	try
	{ 
		
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
        
		if(whereClause.equals(""))
		{
			sql	= "";

			p_patient_id	= request.getParameter("patient_id");
			if(p_patient_id == null || p_patient_id.equals("null"))  p_patient_id = "";
		
			//sql	= "where sug_valid_pat_flag='Y'  and system_gen_yn='Y' and marked_for_merge_yn = 'N' and patient_id = nvl(('"+p_patient_id+"'),patient_id) ";

			sql	= " WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND sug_valid_pat_flag='Y'  and group_status = 'U'  AND system_gen_yn='Y'   AND marked_for_merge_yn = 'N' AND patient_id = NVL(('"+p_patient_id+"'),patient_id)";
		}
		else
		{
			sql = whereClause;
		}

		int x			= 0;
		int time_count	= 0;
		int start		= 0 ;
		int end			= 0 ;
		int i			= 1;
		
		if(from == null || from.equals("null")) start = 1 ;
		else start = Integer.parseInt( from ) ;

		if(to == null || to.equals("null")) end = 10 ;
		else end = Integer.parseInt( to ) ;
			
		int maxRecord = 0;
		
		strsql1 = "SELECT count(1) as total FROM  DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B "+  sql;
		
		
		rs = stmt.executeQuery(strsql1);
		while(rs.next()){
		maxRecord = rs.getInt("total");
		}
		if(rs != null) rs .close();
		if(maxRecord == 0)
		{
%>
		<script>
		function disableEnable()
		{
			parent.frames[4].document.getElementById("search_criteria").disabled = true;
		}
		setTimeout('disableEnable()',50);
		</script>
<%		}
		else
		{
%>
		<script>
		function disableEnable()
		{
			parent.frames[4].document.getElementById("search_criteria").disabled = false;
		}
		setTimeout('disableEnable()',50);
		</script>
<%
		}
%>
<form name='group_header_form' id='group_header_form'>
	<table border='0' width='100%' cellspacing='0'  id='tb1'>
		<tr>
			<td class='label' width='5%'></td>
			<td class='label' width='75%'></td>
			<td class='label' width='20%'></td>
		</tr>
<%
	if (p_patient_id.length() > 0)
	{
		p_pat_rec_cnt = maxRecord;
		if (p_pat_rec_cnt == 0)
		{
			%>
			<script> 
				//var ErrorText = 'DR0009 - Patient Record does not exist';
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

	str  = "select decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle from dr_process_ctl " ;

	rs	 = stmt.executeQuery(str);
	if (rs.next())
	{
		p_order_by = rs.getString("order_by_for_process_cycle");
	} if (rs != null) rs .close();

	if(p_order_by==null || p_order_by.equals("null"))
		p_order_by="";
	/*SelectSQLBuffer.append("select dup_group_id,patient_id,ltrim(rtrim(patient_line))patient_line,pat_count,mp_patient_added_date 	from dr_dup_group_vw2 "); 
	SelectSQLBuffer.append(sql); 
	SelectSQLBuffer.append(" and rownum between 1 and "+end+" ");
	if(!(p_order_by.equals("")))
	SelectSQLBuffer.append("order by "+p_order_by+" "); */

	SelectSQLBuffer.append("SELECT b.dup_group_id, b.patient_id, SUBSTR(get_patient_line(b.patient_id,'"+locale+"'),1,LENGTH(get_patient_line(b.patient_id,'"+locale+"'))-6) patient_line, pat_count, mp_patient_added_date FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B"); 
	SelectSQLBuffer.append(sql); 
	SelectSQLBuffer.append(" and rownum between 1 and "+end+" ");
	if(!(p_order_by.equals("")))
	SelectSQLBuffer.append("order by "+p_order_by+" "); 
  
	rs	= stmt.executeQuery(SelectSQLBuffer.toString());
	if(rs != null)
	{
		if(start != 1)
		for(int j=1; j<start; i++,j++)
		{
			rs.next();						  
		}
		while(rs.next() && i<=end)
		{
			x= x + 1;
			time_count++;

			p_patient_id	= rs.getString("patient_id");
			p_pat_count		= rs.getInt("pat_count");
			p_patient_line	= rs.getString("patient_line") ;
			p_dup_group_id  = rs.getInt("dup_group_id");

			
%>
			<tr id='_<%=p_patient_id%>'>
				<td class='label' valign=top><a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>+</a></td>
				<td colspan='2' class='label'><a name='<%=x%>' onClick='changeRowColor(this,3)' href='javascript:callDupGroupDetails("<%=p_patient_id%>","<%=p_dup_group_id%>","<%=p_pat_count%>")' id='_a<%=p_patient_id%>'>
					<%=p_patient_id%> 
					</a><br>
					<font size='1'><%=p_patient_line%> </font>
				</td>
				<td valign=top class='label'>
					<%=p_pat_count%> 
				</td>
			</tr>
		<%
		i++;
		}
	} if (rs != null) rs.close();
%>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
</table>
		<input type=hidden name='p_patcount' id='p_patcount' value=0>
</form>
<%
	if((SelectSQLBuffer != null) && (SelectSQLBuffer.length() >0))
	{
		SelectSQLBuffer.delete(0,SelectSQLBuffer.length());
	}

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in PossibleDuplicarteHeader.jsp :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

