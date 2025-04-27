<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
	   
	
	
	String count =request.getParameter("count");
	session.setAttribute("count",count);
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/ReviewMergeProcessErrors.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str					= "";
	StringBuffer strsb			= null;
	String p_patient_id			= "";
	String p_status_upd_date	= "";
	String p_patient_line		= "";
	String whereclause			= "";
	String sql					= "";
	String strsql1				= "";
	String p_order_by			= "";
    String locale=(String)session.getAttribute("LOCALE");
	int p_pat_count		= 0;
	int p_dup_group_id	= 0; 
	int p_pat_rec_cnt	= 0;
	int maxRecord		= 0;
	String chkBoxes[]	= new String[20];
	String chkStr1="";	
	//String check_flag="";	
String groupIdIndex="";
String chkSelAll        = "";
//String chkSelAll_id        = "";
int stat = 0, en = 0;
String check="true";
	
	try
	{
		whereclause	        = request.getParameter("whereclause");
		strsb				= new StringBuffer();

	    String from			= request.getParameter("from");
	    String to			= request.getParameter("to");
		String chkStr		=request.getParameter("chkVls")==null?"":request.getParameter("chkVls");
		
		groupIdIndex=request.getParameter("groupIdIndex")==null?"":request.getParameter("groupIdIndex");
		String p_update_string1=request.getParameter("p_update_string1")==null?"":request.getParameter("p_update_string1");
		//String check_flag=request.getParameter("check_flag")==null?"":request.getParameter("check_flag");
		
		

		if(from == null) stat = 0 ;
	    else stat = (Integer.parseInt( from ) - 1);

	   if(to == null) en = 9;
	   else en = (Integer.parseInt( to ));
		
	con= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if((whereclause == null || whereclause.equals("")))
		{
			sql	= "";

			p_patient_id	= request.getParameter("patient_id");

			if(p_patient_id == null) 
			{
				p_patient_id = "";
			}
		
			sql = "WHERE dup_indicator = 'V' AND group_status = 'E' ";
		}
		else
		{
			sql = whereclause;
		}

		int x			= 0;
		int time_count	= 0;
		int start		= 0;
		int end			= 0;
		int i			= 1;

		if(from == null) start = 1 ;
		else start =(Integer.parseInt(from ));
		if(to == null) end = 9;
		else end = Integer.parseInt(to);
		strsql1 = "SELECT count(1) AS total FROM dr_dup_group_vw2  "+  sql;
		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");
		if(rs !=null) rs.close();
		%>
		<form name='group_header_form' id='group_header_form'  action='../../servlet/eDR.ReviewMergeProcessErrorsServlet' method='post' target='messageFrame'>
			<table border='0' width='100%' cellspacing='0'  id='tabz'>
				<tr>
					<td class='fields' width='5%'><input type='checkbox' name='sel_all' id='sel_all' onClick='sel_all_chk()' ></td>
					<td class='label' width='75%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/></td>
					<td class='label' width='20%'></td>
					<td class='label' ></td>
				</tr>
				<tr>
					<td class='label' width='5%'></td>
					<td class='label' width='75%'></td>
					<td class='label' width='20%'>&nbsp;</td>
					<td class='label' ></td>
				</tr>
			</table>
			<table border=0 width='100%' cellspacing='0'  id='tb1' >
				<tr>
					<td class='label' width='5%'></td>
					<td class='label' width='75%'></td>
					<td class='label' width='20%'></td>
				</tr>
				<%
			//int c=0;
		chkStr=chkStr+"000000000";
		if(chkStr != null && !chkStr.equals(""))
		{
		chkStr1=chkStr.substring(stat,en);
		
		for(int k=1; k<=9; k++)
			{
				
    if(chkStr1.indexOf(String.valueOf(k))!=-1 )
	      	 {
				chkBoxes[k]="CHECKED"; }
				else { chkBoxes[k]	= "UNCHECKED"; }
			}
		}
		else
		{ 
			for(int k=0; k<=9; k++) { chkBoxes[k]	= "UNCHECKED"; }
		}
			if(p_patient_id.length() > 0)
				{
					str = "SELECT count(1) total FROM dr_dup_group_vw2  " + sql;
					rs  = stmt.executeQuery(str);
					if(rs.next())
					p_pat_rec_cnt = rs.getInt("total");
					if(rs !=null) rs.close();
					if(p_pat_rec_cnt == 0)
					{
						%>

						<script> 
							
							var ErrorText = getMesssage("NO_RECORD","DR");
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
						
						//parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
					</script>
					<%
				}
			
				
				str  = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl " ;
				rs	 = stmt.executeQuery(str);
				if(rs.next())
				{
					p_order_by = rs.getString("order_by_for_process_cycle");
				} if(rs !=null) rs.close();

				strsb.append("SELECT dup_group_id,patient_id,SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line,pat_count,mp_patient_added_date,to_char(status_upd_date,'dd/mm/rrrr') status_upd_date FROM dr_dup_group_vw2 "); 
				strsb.append(sql); 
				strsb.append( "order by ");
				strsb.append(p_order_by);
				strsb.append(" ");
				rs	= stmt.executeQuery(strsb.toString());

				//out.println("Sal"+strsb.toString());

				if(rs != null)
				{
					if(start != 1)
					for(int j=1; j<start; i++,j++)
					{
						rs.next() ;						  
					}
					while( rs.next() && i <= end)
					{
						//int t=1;
						x = x + 1;
						time_count++;
						p_patient_id		= rs.getString("patient_id");
						p_pat_count			= rs.getInt("pat_count");
						p_patient_line		= rs.getString("patient_line") ;
						p_dup_group_id		= rs.getInt("dup_group_id");
						p_status_upd_date   = rs.getString("status_upd_date");
                        if(chkBoxes[x].equals("UNCHECKED")){
								chkSelAll = "false";
								check="false";
								}
							else {
								chkSelAll = "true";
								/*if(chkSelAll=="true"){
									chkSelAll_id="Y";
									
									}*/							    
								
								}
									%>
						<tr id='_<%=p_patient_id%>'>
							<td class='label' valign='top'>
						<input type='checkbox' name='selectpatient<%=x%>' id='selectpatient<%=x%>' <%=chkBoxes[x]%> onClick='sel_chk(this)'  value=''><a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>&nbsp;+</a></td>
							<td colspan='2' class='label'><a name='<%=x%>' onClick='changeRowColor(this,3)' href='javascript:callDupGroupDetails("<%=p_patient_id%>","<%=p_dup_group_id%>","<%=p_pat_count%>","<%=p_status_upd_date%>")' id='_a<%=p_patient_id%>'>
							&nbsp;<%=p_patient_id%> 
							</a><br><font size='1'>&nbsp;&nbsp;<%=p_patient_line%></font></td>
							<td align='right' valign=top class='label'><%=p_pat_count%> 
							<input type='hidden' name='dup_group_id<%=x%>' id='dup_group_id<%=x%>' value=<%=p_dup_group_id%>></td>
						</tr>
						<%
						i++;
				
					}
					
				} if(rs != null) rs.close();
				%>
			</table>
			<input type='hidden'name='p_patcount' value='0'>
			<input type='hidden'name='count' value='<%=x%>'>
			<input type='hidden'name='update_string' value=''>
			<input type='hidden'name='check_flag' value=''>
			<input type='hidden'name='mode'value='update'>
		   <input type='hidden' name="CheckBoxes" id="CheckBoxes" value=''>
		   <input type='hidden' name="selAll" id="selAll" value=''>
		   <input type='hidden' name="dup_group_id" id="dup_group_id" value=''>
		   <input type='hidden' name='chkedVls' id='chkedVls' value=''>	
		   <input type='hidden' name='p_update_string1' id='p_update_string1' value='<%=p_update_string1%>'>	
				<input type='hidden' name="endd" id="endd" value='<%=end%>'>
			<input type='hidden' name="start" id="start" value='<%=start%>'>
				</form>
		<%
					
	
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(strsb!=null || strsb.length() >0)
			strsb.setLength(0);
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
         <script>			
				if('<%=chkSelAll%>'=='true' && '<%=check%>'=='true') {
					document.getElementById("sel_all").checked = true; 
				} else { 
					document.getElementById("sel_all").checked = false;
				}
		
		</script>
</body>
</html>

