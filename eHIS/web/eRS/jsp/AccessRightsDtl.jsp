<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	P.Anuradha
*	Created On		:	19 Jan 2005
-->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="AccessRights" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/AccessRights.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection conn=null;

PreparedStatement stmt=null;
PreparedStatement workplace_stmt=null;
PreparedStatement count_stmt=null;
PreparedStatement stmt_yn=null;

ResultSet workplace_rset=null;
ResultSet count_rset=null;
ResultSet rset=null;
ResultSet rset_yn=null;

conn = ConnectionManager.getConnection(request);
String setup_check="";
String allocate_check="";
String reallocate_check="";
String cancel_check="";
String select_check="";

String workplace1=request.getParameter("workplace");

if(workplace1 == null){workplace1="";}

String workplace_code1=request.getParameter("workplace_code");
String facility_id = (String)session.getAttribute("facility_id");


int start = 0 ;
int end = 0 ;

String from = request.getParameter("from");
String to = request.getParameter("to");

if ( from == null )
		start = 0;
else
		start = Integer.parseInt(from) ;

if ( to == null )
	  	end = 11;
else
		end = Integer.parseInt(to) ;

if(workplace1==null)workplace1="";
if(workplace_code1==null)workplace_code1="";

String user_id=request.getParameter("user_id");
String req_start="";
String req_end="";
%>
<body  onMouseDown="CodeArrest()" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' onKeyDown="lockKey()" >
<form name='AccessRightsDetail_form' id='AccessRightsDetail_form' action="../../eRS/jsp/AccessRightsDtl.jsp" method='post'>
<%
if(workplace1!="" && workplace_code1!="")
{

%>
<table cellpadding=0 cellspacing=0 border=1 width="100%">
<tr>
		<th width='20%'><fmt:message key="eRS.Workplace.label" bundle="${rs_labels}"/></th>
		<th width='16%'><fmt:message key="eRS.SetUpReq.label" bundle="${rs_labels}"/></th>
		<th width='8%'><fmt:message key="eRS.Allocate.label" bundle="${rs_labels}"/></th>
		<th width='12%'><fmt:message key="eRS.Re-allocate.label" bundle="${rs_labels}"/></th>
		<th width='15%'><fmt:message key="eRS.CancelSch.label" bundle="${rs_labels}"/></th>
		<th width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>
<%
	String setup="";
    String allocate="";
    String reallocate="";
    String cancel="";
	String dbaction="";

	//String sql_yn="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn, nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace a,rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code =? and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace i where i.facility_id =? and i.workplace_code =? and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from   rs_access_rights where appl_user_id =?) order by 2";
	String sql_yn="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn, nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace_lang_vw  a,rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code =? and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code and a.language_id = ? UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace_lang_vw i where i.facility_id =? and i.workplace_code =? and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from   rs_access_rights where appl_user_id =?) and i.language_id = ? order by 2";

    stmt_yn=conn.prepareStatement(sql_yn);
	stmt_yn.setString(1,user_id);
	stmt_yn.setString(2,facility_id);
	stmt_yn.setString(3,workplace_code1);
	stmt_yn.setString(4,locale);
	stmt_yn.setString(5,user_id);
	stmt_yn.setString(6,facility_id);
	stmt_yn.setString(7,workplace_code1);
	stmt_yn.setString(8,user_id);
	stmt_yn.setString(9,locale);

	rset_yn=stmt_yn.executeQuery();
		if(rset_yn!=null)
	{
		while(rset_yn.next())
		{
			setup=rset_yn.getString("setup_requirement_yn");
			allocate=rset_yn.getString("allocate_yn");
			reallocate=rset_yn.getString("reallocate_yn");
			cancel=rset_yn.getString("cancel_schedule_yn");
			dbaction=rset_yn.getString("db_action");

			if(dbaction.equals("U"))
			{
				select_check="checked";
			}
			else if(dbaction.equals("I"))
			{
				select_check="";
			}


			if(setup.equals("Y"))
			{
				setup_check="checked";
			}
			else
			{
				setup_check="";
			}

			if(allocate.equals("Y"))
			{
				allocate_check="checked";
			}
			else
			{
				allocate_check="";
			}

			if(reallocate.equals("Y"))
			{
				reallocate_check="checked";
			}
			else
			{
				reallocate_check="";
			}

			if(cancel.equals("Y"))
			{
				cancel_check="checked";
			}
			else
			{
				cancel_check="";
			}
%>
	<tr>
	<td width='20%' align="left"><%=workplace1%></td>
	<td width='16%' align="center"><input type=checkbox name="Setup" id="Setup" <%=setup_check%>></input></td>
	<td width='8%' align="center"><input type=checkbox name="Allocate" id="Allocate" <%=allocate_check%>></input></td>
	<td width='12%' align="center"><input type=checkbox name="Reallocate" id="Reallocate" <%=reallocate_check%>></input></td>
	<td width='15%' align="center"><input type=checkbox name="Cancel" id="Cancel" <%=cancel_check%>></input></td>
	<td width='5%' align="center"><input type=checkbox name="select" id="select" <%=select_check%>></input></td>
	</tr>
		<%
		}}%>
</table>
<input type=hidden name="setup" id="setup" value="">
<input type=hidden name="allocate" id="allocate" value="">
<input type=hidden name="reallocate" id="reallocate" value="">
<input type=hidden name="cancel" id="cancel" value="">
<input type=hidden name="dbaction" id="dbaction" value="<%=dbaction%>">
<input type=hidden name="select1" id="select1" value="">
<input type=hidden name="workplace_code" id="workplace_code" value="<%=workplace_code1%>">
<input type=hidden name="workplace" id="workplace" value="<%=workplace1%>">
<%
}
else if(workplace1=="" && workplace_code1=="")
{
    req_start=(request.getParameter("start")==null)?"0":request.getParameter("start");
	req_end=(request.getParameter("end")==null)?"0":request.getParameter("end");

	String flagSelect=request.getParameter("fromSearch");
	int k=1;

	String setup_yn="";
	String allocate_yn="";
	String reallocate_yn="";
	String cancel_yn="";
	String workplace_value="";
	String select_yn="";
	String db_action="";

    try
	{
	if(flagSelect !=null){
			AccessRights.clearAll();
			//String sqlinsVals="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn, nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code UNION ALL select i.workplace_code workplace_code, i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn, 'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) order by 2";
			String sqlinsVals="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn, nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace_lang_vw a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code and a.language_id = ? UNION ALL select i.workplace_code workplace_code, i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn, 'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace_lang_vw i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) and i.language_id = ? order by 2";
			stmt=conn.prepareStatement(sqlinsVals);
			stmt.setString(1,user_id);
			stmt.setString(2,facility_id);
			stmt.setString(3,locale);
			stmt.setString(4,user_id);
			stmt.setString(5,facility_id);
			stmt.setString(6,user_id);
			stmt.setString(7,locale);

			rset = stmt.executeQuery();
				if(rset !=null){
				while(rset.next()){
						workplace_value=rset.getString("workplace_code");
						setup_yn=rset.getString("setup_requirement_yn");
						allocate_yn=rset.getString("allocate_yn");
						reallocate_yn=rset.getString("reallocate_yn");
						cancel_yn=rset.getString("cancel_schedule_yn");
						db_action=rset.getString("db_action");

						if(db_action.equals("U")) select_yn="Y";
						else if(db_action.equals("I")) select_yn="N";

			  			ArrayList alist1=new ArrayList();

						alist1.add(workplace_value);
						alist1.add(select_yn);
						alist1.add(setup_yn);
						alist1.add(allocate_yn);
						alist1.add(reallocate_yn);
						alist1.add(cancel_yn);
						alist1.add(db_action);

                       AccessRights.putObject(alist1);
				   }
				}	
			}

			String select1="";
			String setup1="";
			String allocate1="";
			String reallocate1="";
			String cancel1="";
			String db_action1="";
			String workplacecode1="";


			if(from != null && to != null){
            	for(k=Integer.parseInt(req_start);k<(Integer.parseInt(req_end)); k++){
					 if(request.getParameter("select"+(k))!=null)
						 select1="Y";
					 else if(request.getParameter("select"+(k))==null)
						 select1="N";
                     if(request.getParameter("Setup"+(k))!=null)
						 setup1="Y";
					 else if(request.getParameter("Setup"+(k))==null)
						 setup1="N";
					 if(request.getParameter("Allocate"+(k))!=null)
						 allocate1="Y";
					 else if(request.getParameter("Allocate"+(k))==null)
						 allocate1="N";
					  if(request.getParameter("Reallocate"+(k))!=null)
						 reallocate1="Y";
					 else if(request.getParameter("Reallocate"+(k))==null)
						 reallocate1="N";
					  if(request.getParameter("Cancel"+(k))!=null)
						 cancel1="Y";
					 else if(request.getParameter("Cancel"+(k))==null)
						 cancel1="N";
					 db_action1=request.getParameter("db_action"+(k));
                     workplacecode1=request.getParameter("workplace_code"+(k));

			 		 ArrayList alist_checkedOnes=new ArrayList();

             			 alist_checkedOnes.add(workplacecode1);
             			 alist_checkedOnes.add(select1);
						 alist_checkedOnes.add(setup1);
						 alist_checkedOnes.add(allocate1);
						 alist_checkedOnes.add(reallocate1);
						 alist_checkedOnes.add(cancel1);
						 alist_checkedOnes.add(db_action1);

						 AccessRights.setObject(k,alist_checkedOnes);
				}
			}


     String sql_count="select count(workplace_code) count from (select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn,nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) order by 2)";

	 count_stmt=conn.prepareStatement(sql_count);
	 count_stmt.setString(1,user_id);
	 count_stmt.setString(2,facility_id);
	 count_stmt.setString(3,user_id);
	 count_stmt.setString(4,facility_id);
	 count_stmt.setString(5,user_id);

    count_rset=count_stmt.executeQuery();
	int record_count=0;
	if(count_rset!=null)
	{
		while(count_rset.next())
		{
			record_count=count_rset.getInt("count");
		}
	}

    String classValue="";
%>
<input type=hidden name="from" id="from" value="<%=start%>">
<input type=hidden name="to" id="to" value="<%=end%>">
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='allValues' id='allValues' value=''>
<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<table border=0 width='98%'>
<tr>
<td align='right' class='NONURGENT'>
<%
if (!(start<=1))
{
%>
	<a href='javascript:submitPrevNext(<%=(start-11)%>,<%=(end-11)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
}
if (!((start+11)>=record_count))
{
%>
	  <a href='javascript:submitPrevNext(<%=(start+11)%>,<%=(end+11)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichP age' id='whichP age' value='next'>
<%
}
%>
</td>
</tr>	
</table>
<input type=hidden name="Record_Count" id="Record_Count" value="<%=record_count%>">
<table cellpadding=0 cellspacing=0 border=1 id="workplace_table" width="100%">
<tr>
<th width='40%'><fmt:message key="eRS.Workplace.label" bundle="${rs_labels}"/></th>
<th width='16%'><fmt:message key="eRS.SetUpReq.label" bundle="${rs_labels}"/></th>
<th width='8%'><fmt:message key="eRS.Allocate.label" bundle="${rs_labels}"/></th>
<th width='12%'><fmt:message key="eRS.Re-allocate.label" bundle="${rs_labels}"/></th>
<th width='15%'><fmt:message key="eRS.CancelSch.label" bundle="${rs_labels}"/></th>
<th width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type=checkbox name="selectall" id="selectall" onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
</tr>
<%
	//String sql="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn,nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) order by 2";
	String sql="select a.workplace_code workplace_code,a.workplace_desc workplace_desc,b.appl_user_id appl_user_id,nvl(b.allocate_yn,'N') allocate_yn,nvl(b.reallocate_yn,'N') reallocate_yn,nvl(b.cancel_schedule_yn,'N') cancel_schedule_yn,nvl(b.setup_requirement_yn,'N') setup_requirement_yn,'U' db_action from rs_workplace_lang_vw a, rs_access_rights b where b.appl_user_id =? and b.facility_id =? and b.workplace_code = nvl('',b.workplace_code) and a.facility_id = b.facility_id and a.workplace_code = b.workplace_code and a.language_id = ? UNION ALL select i.workplace_code workplace_code,i.workplace_desc workplace_desc,?,'N' allocate_yn,'N' reallocate_yn,'N' setup_requirement_yn,'N' cancel_schedule_yn,'I' db_action from rs_workplace_lang_vw i where i.facility_id =? and i.workplace_code = nvl('',i.workplace_code) and (i.facility_id,i.workplace_code) not in (select facility_id, workplace_code from rs_access_rights where appl_user_id =?) and i.language_id = ? order by 2";

	workplace_stmt=conn.prepareStatement(sql);
	workplace_stmt.setString(1,user_id);
	workplace_stmt.setString(2,facility_id);
	workplace_stmt.setString(3,locale);
	workplace_stmt.setString(4,user_id);
	workplace_stmt.setString(5,facility_id);
	workplace_stmt.setString(6,user_id);
	workplace_stmt.setString(7,locale);

		String workplace_desc="";
		String workplace_code="";
		String workplace="";
		String allocate="";
		String reallocate="";
		String cancel="";
		String setup="";
		String dbaction="";
		String select="";

	workplace_rset=workplace_stmt.executeQuery();

   int i=1;

	if ( start != 0 )
		 for( int j=1; j<=start; i++,j++ )
		 {
			workplace_rset.next() ;
		 }

    if(workplace_rset!=null)
	{
	while ( workplace_rset.next() && i<=end)
	{
		    workplace_code=workplace_rset.getString("workplace_code");
			workplace_desc=workplace_rset.getString("workplace_desc");
         
			for(int l=0;l<AccessRights.getSize();l++)
		    {
				ArrayList al1=new ArrayList();
				al1=(ArrayList)AccessRights.getObject(l);
				workplace=(String)al1.get(0);
				select=(String)al1.get(1);
				setup=(String)al1.get(2);
				allocate=(String)al1.get(3);
				reallocate=(String)al1.get(4);
				cancel=(String)al1.get(5);
				dbaction=(String)al1.get(6);
    			if(workplace_code.equals(workplace))
				{
					if(select.equals("Y"))
					{
						    select_check="checked";
					}
					else if(select.equals("N"))
					{
						    select_check="";
					}
        		    if(setup.equals("Y"))
					{
			            	setup_check="checked";
					}
		            else if(setup.equals("N"))
					{
				            setup_check="";
					}
		            if(allocate.equals("Y"))
					{
						allocate_check="checked";
					}
		            else if(allocate.equals("N"))
					{
				            allocate_check="";
					}
		            if(reallocate.equals("Y"))
					{
				             reallocate_check="checked";
					}
                   	else if(reallocate.equals("N"))
					{
				             reallocate_check="";
					}
		            if(cancel.equals("Y"))
					{
				             cancel_check="checked";
					}
    	            else if(reallocate.equals("N"))
					{
			                 cancel_check="";
					}
					break;
				}
				else
				{
					select_check="";
					setup_check="";
					allocate_check="";
					reallocate_check="";
					cancel_check="";
				}
			}

       	if (i%2 == 0)
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
%>
<tr>
<td class="<%=classValue%>" width='40%' align="left"><%=workplace_desc%></td>
<td class="<%=classValue%>" width='16%' align="center"><input type=checkbox name="Setup<%=(i-1)%>" id="Setup<%=(i-1)%>" value="<%=setup%>" <%=setup_check%>></input></td>
<td class="<%=classValue%>" width='8%' align="center"><input type=checkbox name="Allocate<%=(i-1)%>" id="Allocate<%=(i-1)%>" value="<%=allocate%>" <%=allocate_check%>></input></td>
<td class="<%=classValue%>" width='12%' align="center"><input type=checkbox name="Reallocate<%=(i-1)%>" id="Reallocate<%=(i-1)%>" value="<%=reallocate%>" <%=reallocate_check%>></input></td>
<td class="<%=classValue%>" width='15%' align="center"><input type=checkbox name="Cancel<%=(i-1)%>" id="Cancel<%=(i-1)%>" value="<%=cancel%>" <%=cancel_check%>></input></td>
<td class="<%=classValue%>" width='5%' align="center"><input type=checkbox name="select<%=(i-1)%>" id="select<%=(i-1)%>" value="<%=select%>" <%=select_check%>></input></td>
<input type=hidden name="db_action<%=(i-1)%>" id="db_action<%=(i-1)%>" value="<%=dbaction%>">
<input type=hidden name="workplace_code<%=(i-1)%>" id="workplace_code<%=(i-1)%>" value="<%=workplace_code%>">
</tr>
<%
	i++;
	}
}
}
catch(Exception exp)
{
	exp.toString();
}
finally
{
	try
	{
	if(rset_yn!=null) rset_yn.close();
	if(stmt_yn!=null) stmt_yn.close();

	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();

	if(count_rset!=null) count_rset.close();
	if(count_stmt!=null) count_stmt.close();

	if(workplace_rset!=null) workplace_rset.close();
	if(workplace_stmt!=null) workplace_stmt.close();

	ConnectionManager.returnConnection(conn,request);
	session.setAttribute("AccessRights",AccessRights);
	}
	catch(Exception exp)
	{
		exp.toString();
	}
}
}
%>
</table>
<input type=hidden name="user_id" id="user_id" value="<%=user_id%>">
<input type=hidden name="facility_id" id="facility_id" value="<%=facility_id%>">
</form>
</body>
</html>

