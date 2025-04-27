<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" %>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>	
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()' onLoad="callChk();" >
<% 
	String facilityId = (String) session.getValue("facility_id");
    String locale = (String)session.getAttribute("LOCALE");
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str				= "";
	StringBuffer strsb		= null;
	String p_patient_id		= "";
	String p_patient_line	= "";
	String sql				= "";
	String p_order_by		= "";
	String chkStr1			= "";
	String groupTotal		= "";
	StringBuffer sb			= null;
	String chkSelAll        = "";

	int p_pat_count		= 0;
	int p_dup_group_id	= 0; 
	int p_pat_rec_cnt	= 0;
    int flag			= 0;

	String whereClause = request.getParameter("whereclause");
		
	ArrayList dupGroupId1 = new ArrayList(20);
	dupGroupId1.add(0,"000000000");

	String from = request.getParameter("from");
	String to	= request.getParameter("to");

	String chkBoxes[]	= new String[10];

    String chkStr		= request.getParameter("chkVls")==null?"":request.getParameter("chkVls");
	//out.println("chkStr-->"+chkStr);
	String dupGroupId	= request.getParameter("dupGroupId")==null?"":request.getParameter("dupGroupId");
	String groupIdIndex	= request.getParameter("groupIdIndex")==null?"0":request.getParameter("groupIdIndex");
    
	int index		= 0;
	int groupIndex	= Integer.parseInt(groupIdIndex);
    int stat = 0, en = 0;

	chkStr	= chkStr.trim();

	if(from == null) stat = 0 ;
	else stat = (Integer.parseInt( from ) - 1);

	if(to == null) en = 9;
	else en = (Integer.parseInt( to ));

	ArrayList dupGpId	= null;
	index				= (int)(en/9);

	try
	{
		sb		= new StringBuffer();
		strsb	= new StringBuffer();
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		dupGpId	= (ArrayList)session.getAttribute("dupGroupId");
		if(dupGpId != null && chkStr.equals(""))
		{
			session.removeAttribute("dupGroupId");
			dupGpId	= null;
		}	

		if(dupGpId != null)
		{
			int sz = dupGpId.size();
			if(sz > groupIndex) dupGpId.remove(groupIndex);//Here we can also use dupGpId.set(index,Object) method instead of removing.
			if(dupGpId.size()>0)
			dupGpId.add(groupIndex,dupGroupId);
			for(int i=0; i<dupGpId.size(); i++)
			{ 
				if(i == 0) 
				sb.append(((String)dupGpId.get(i)).toString());
				else
				{
					sb.append("~");
					sb.append(((String)dupGpId.get(i)).toString());

				}
			}
		}
		else
		{
			dupGpId	= new ArrayList(20);
			dupGpId.add(0,"000000000");
			session.setAttribute("dupGroupId",dupGpId);
		}
		session.setAttribute("dupGroupId",dupGpId);
        groupTotal=sb.toString();  
		String fromPage = request.getParameter("fromPage");
		String facility	= request.getParameter("facility1");

		if(fromPage == null) fromPage = "";
		if(facility == null) facility = "";
      
		 chkStr=chkStr+"000000000";
		if(chkStr != null && !chkStr.equals(""))
		{
			
			chkStr1	= chkStr.substring(stat,en); 
			
			for(int i=1; i<=9; i++)
			{
				
				if(chkStr1.indexOf(String.valueOf(i))!=-1) { chkBoxes[i]="CHECKED";  }
				else { chkBoxes[i]	= "UNCHECKED"; }
			}
		}
		else
		{ 
			for(int i=0; i<=9; i++) { chkBoxes[i]	= "UNCHECKED"; }
		}

		if((whereClause == null || whereClause.equals("")))
		{
			p_patient_id = request.getParameter("patient_id");
			if(p_patient_id == null) p_patient_id = "";

			if(fromPage.equals("2"))
			{
				sql = "WHERE dup_indicator = 'V' AND group_status = 'I' AND marked_for_merge_yn = 'N' AND added_facility_id = nvl('"+facility+"', added_facility_id) and patient_id = nvl('"+p_patient_id+"',patient_id)";
			}
			else
			{
				sql="WHERE dup_indicator = 'V' AND group_status = 'I' AND marked_for_merge_yn = 'N' AND added_facility_id = nvl('"+facilityId+"', added_facility_id) AND patient_id = nvl('"+p_patient_id+"', patient_id)";
			}
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

		if(from == null) start = 1;
		else start = Integer.parseInt(from);

		if(to == null) end = 9;
		else end = Integer.parseInt(to);
		%>
		<form name='group_header_form' id='group_header_form'>
			<table border='0' width='100%' cellspacing='0'  id='tabz' >
				<tr>
					<td class='fields' width='5%'>
						<input type='checkbox' name='sel_all' id='sel_all' onClick='sel_all_chk()'></td>
					<td class='label' width='80%' ><fmt:message key="eDR.SelectAllCurrentPage.label" bundle="${dr_labels}"/></td>
					<td class='label' width='15%'></td>
					<td class='label'></td>
				</tr>
				<tr>
					<td class='label' width='5%'></td>
					<td class='label' width='75%'></td>
					<td class='label' width='20%'></td>
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
				if(p_patient_id.length() > 0)
				{
					str = "select count(1) total from dr_dup_group_vw2 " + sql;
					rs = stmt.executeQuery(str);
					if (rs.next())
					{
						p_pat_rec_cnt = rs.getInt("total");
					} if(rs != null) rs.close();

					if(p_pat_rec_cnt == 0)
					{
						%>
						
						<%
					}
				}
				else
				{
					%>
					<script> 
						var ErrorText = '';
						parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num=";
					</script> 
					<%
				}

				str  = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl " ;
				rs	 = stmt.executeQuery(str);
				if(rs.next())
				{
					p_order_by	= rs.getString("order_by_for_process_cycle");
					flag		= 1;
				} if(rs != null) rs.close();

				strsb.append("SELECT dup_group_id, patient_id, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6)  patient_line, pat_count, mp_patient_added_date FROM dr_dup_group_vw2 ");
				 strsb.append(sql); 
               
			    if(flag == 1)
				{
					strsb.append( "order by ");
					strsb.append(p_order_by);
					strsb.append(" ");
				}
                
					rs	= stmt.executeQuery(strsb.toString());
				if(rs != null)
				{
					if(start != 1)
						for(int j=1; j<start; i++,j++)
						{	
							rs.next() ;						  
						}
						while(rs.next() && i <= end)
						{
							x = x + 1;
							time_count++;

							p_patient_id	= rs.getString("patient_id");
							p_pat_count		= rs.getInt("pat_count");
							p_patient_line	= rs.getString("patient_line");
							p_dup_group_id  = rs.getInt("dup_group_id");

							if(chkBoxes[x].equals("UNCHECKED"))
								chkSelAll = "false";
							else 
								chkSelAll = "true";
							
							%>

							<tr id='_<%=p_patient_id%>'>
								<td class='fields' valign='top'><input type=checkbox name='selectpatient<%=x%>' id='selectpatient<%=x%>' <%=chkBoxes[x]%> value=''  onclick="chk_slt_all(this,'<%=x%>');"><a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>+</a>
								</td>
								<td colspan='2' class='data'><a name='<%=x%>' onClick='changeRowColor(this,3)' href='javascript:callDupGroupDetails("<%=p_patient_id%>","<%=p_dup_group_id%>","<%=p_pat_count%>")' id='_a<%=p_patient_id%>'><%=p_patient_id%></a><br>
								<font size=1><%=p_patient_line%></font></td>
								<td  valign=top class='label'><%=p_pat_count%> 
								<input type=hidden name='dup_group_id<%=x%>' id='dup_group_id<%=x%>' value=<%=p_dup_group_id%>>
								</td>
							</tr>
							<%
								i++;
						}
					} if (rs != null) rs.close();
					//out.println("dupGroupId-->"+dupGroupId);
					%>
				</table>
				<input type='hidden' name="p_patcount" id="p_patcount" value='0'>
				<input type='hidden' name='count' id='count' value='<%=x%>'>
				<input type='hidden' name='chkedVls' id='chkedVls' value=''>
				<input type='hidden' name="start" id="start" value='<%=start%>'>
				<input type='hidden' name="dupGroupId" id="dupGroupId" value='<%=dupGroupId%>'>
				<input type='hidden' name="endd" id="endd" value='<%=end%>'>
				<input type='hidden' name='groupTotal' id='groupTotal' value='<%=groupTotal%>'></input>
		        <input type='hidden' name='index' id='index' value='<%=index%>'></input>		
			</form>
			<%
			dupGroupId1.clear();
			dupGpId.clear();
			if(sb!=null || sb.length() >0)
			sb.setLength(0);
			if(strsb!=null || strsb.length() >0)
			strsb.setLength(0);
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception In MergeDuplicateHeader:"+e.getMessage());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
		%>
		<script> 
				document.getElementById('groupTotal').value='<%=groupTotal%>';
				document.getElementById('index').value='<%=index%>';	
				if('<%=chkSelAll%>'=='true') {
					document.getElementById('sel_all').checked = true;
				} else {
					document.getElementById('sel_all').checked = false;
				}
		if(parent.frames[1].document.getElementById('sel_all').checked==true)
 	 {
	 if(parent.parent.frames[1].frames[4].document.getElementById('start_now'))
		 {
	 parent.parent.frames[1].frames[4].document.getElementById('start_now').disabled=false;
		 }
	if(parent.parent.frames[1].frames[4].document.getElementById('start_later'))
		 {
	parent.parent.frames[1].frames[4].document.getElementById('start_later').disabled=false; 
		 }
	 }else{
	     if(parent.parent.frames[1].frames[4].document.getElementById(''))
		 {
		 parent.parent.frames[1].frames[4].document.getElementById('start_now').disabled=true;
	     }
		 if(parent.parent.frames[1].frames[4].document.getElementById(''))
		 {
		 parent.parent.frames[1].frames[4].document.getElementById('start_later').disabled=true; 
		 }
	 }
		 </script>
	     </body>
         </html>

