<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.util.*,java.text.*,java.sql.*,java.net.*,webbeans.eCommon.*"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<%String sStyle	=
		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/common.js">	</script>
		<script language='javascript' src='../js/AdverseEventType.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<!-- <script language="JavaScript" src="../js/eMRmessages.js"></script> // file not found --> 
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
			String locale			= (String)session.getAttribute("LOCALE");
			request.setCharacterEncoding("UTF-8");
		   String adv_event_code="";
		   String adv_event1_code="";
		   String adv_event1_ind="";
		   String adv_event_desc="";
		   String longdesc="";
		   String shortdesc="";
		   String effstatus="";
		  // String effstatus2="";
		   String codeTextAttribute="";
		   String otherTextAttribute="";
		   String checkBoxAttribute="";
		   String checkBoxAttribute1="";
		  // String checkBoxAttribute2="";
		   String dis_chk = "";
		   String eventFunctionForCase="";
		   String mode="";
		   String user_define="";
		  // boolean status = false;
		   StringBuffer sql = new StringBuffer();
		   Connection conn=null;
		   PreparedStatement stmt=null;
		   Statement stmt2=null;
		   ResultSet rset=null;
		   ResultSet rs=null;
		   ResultSet rset2=null;

try
{
       // String facilityId	=(String) session.getValue("facility_id");
		conn = ConnectionManager.getConnection(request);
		stmt2=conn.createStatement();
		adv_event_code=request.getParameter("ADV_EVENT_TYPE_CODE")==null?"":request.getParameter("ADV_EVENT_TYPE_CODE");
		mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		if(mode ==null || mode=="") mode="insert";
	
		HashSet tabdata;	
       tabdata = new HashSet();

	if(adv_event_code==null || adv_event_code.equals(""))
	{
		adv_event_code="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		checkBoxAttribute1="CHECKED";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		checkBoxAttribute="";
		//status=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else if(!adv_event_code.equals(""))
	{
			sql.append("SELECT a.adv_event_type_code, a.long_desc, a.short_desc, a.eff_status status1,       a.sys_user_val, b.adv_event_type_ind, b.EFF_STATUS status2  FROM mr_adv_event_type a, mr_adv_event_type_detail b WHERE   a.adv_event_type_code = b.adv_event_type_code(+) and b.adv_event_type_code ='"+adv_event_code+"' order by b.ADV_EVENT_TYPE_IND ");
			stmt = conn.prepareStatement(sql.toString());
			rset = stmt.executeQuery();
			while(rset.next())
			 {
				adv_event_code	=rset.getString("ADV_EVENT_TYPE_CODE");
				longdesc	    =rset.getString("long_desc");
				shortdesc	    =rset.getString("short_desc");
				effstatus	    =rset.getString("status1");
				if(effstatus==null) effstatus="D";
				user_define     =rset.getString("SYS_USER_VAL");
				adv_event1_code =rset.getString("ADV_EVENT_TYPE_IND");
				//effstatus2	    =rset.getString("status2");
				tabdata.add(adv_event1_code);
			 }
			
		   	 if(rset!=null)   rset.close();


			

			if(effstatus.equals("D")){
				otherTextAttribute="READONLY";
				checkBoxAttribute="";
				dis_chk = "disabled";
			}else{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
				dis_chk = "";
				//status=true;
			}
			codeTextAttribute="READONLY";
			//status=false;
			eventFunctionForCase="";
	}
		%>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='adverse_event' id='adverse_event' action='../../servlet/eMR.AdverseEventTypeServlet' method='post' target='messageFrame' >
			<div align='left'>
      	<BR><BR><BR><BR><BR><BR>
			<table border='0' cellspacing=0 cellpadding=0 width='70%' align='center'>
			
				<tr>
					<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td class='fields'>
					<input type=text name='code' id='code' value="<%=adv_event_code%>"  maxlength="2" size="2" onKeyPress="return CheckForSpecChars(event)"  <%=codeTextAttribute%> <%=eventFunctionForCase%>>
					<img id = 'code_mand' src = '../../eCommon/images/mandatory.gif'></td>
				</tr>
			
				<tr>
					<td class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
					<td class='fields'>
					<input type=text name='long_desc' id='long_desc'  value="<%=longdesc%>" maxlength="30"  size="30" <%=otherTextAttribute%> onBlur="makeValidString(this);" ><img id = 'short_mand' src = '../../eCommon/images/mandatory.gif'></td>
				</tr>			
				<tr>
					<td class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
					<td class='fields'>
					<input type=text name='short_desc' id='short_desc' value="<%=shortdesc%>" <%=otherTextAttribute%>  maxlength="15" size="15" onBlur="makeValidString(this);"><img id = 'long_mand' src = '../../eCommon/images/mandatory.gif'>
				</tr>
			
      		<tr>
      		     <td class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				 <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="medBoard_change()"></td>
      		</tr>
			
				<tr>
				<td class="COLUMNHEADER" nowrap colspan=4><fmt:message key="eMR.ApplicableAdverseEventTypeInd.label" bundle="${mr_labels}"/><img id = 'IND_mand' src = '../../eCommon/images/mandatory.gif'></td></tr>
			
				
					<%
						int k=0;
						String sql_cnt="select count(*) count from MR_ADV_EVENT_TYPE_IND ";
						rs=stmt2.executeQuery(sql_cnt);
						if(rs !=null && rs.next())
						{
							k = rs.getInt("count");
						}
						
						String adv_ind="select ADV_EVENT_TYPE_IND,ADV_EVENT_TYPE_IND_DESC from MR_ADV_EVENT_TYPE_IND ORDER BY ADV_EVENT_TYPE_IND";
						rset2=stmt2.executeQuery(adv_ind);
						int i=0;

							
						if(rset2 !=null)
						{
							while(rset2.next())
							{
							
								adv_event1_ind=rset2.getString("ADV_EVENT_TYPE_IND");
									if(tabdata.contains(adv_event1_ind))
									{
										checkBoxAttribute1="CHECKED";
									}else
							{
								checkBoxAttribute1="";
							}
								adv_event_desc=rset2.getString("ADV_EVENT_TYPE_IND_DESC");

							%>
							<tr><td class='label' width='25%' nowrap ><%=adv_event_desc%></td><td  class='fields'><input type=checkbox name='checkBox<%=i%>' id='checkBox<%=i%>' value='' id='check_box' onClick='javascript:checkBoxOnClick(this);' <%=checkBoxAttribute1%> <%=dis_chk%>><input type='hidden' name='adv_evnt_ind<%=i%>' id='adv_evnt_ind<%=i%>' value='<%=adv_event1_ind%>' <%=dis_chk%>><input type=hidden name='ret_value' id='ret_value' value='<%=adv_event1_ind%>,<%=i%>' <%=dis_chk%>></td></tr>
							<% 
								i++;
								}
							
						}%>
				
				
			
						
				<input type='hidden' name='count' id='count' value='<%=k%>'>
				<input type='hidden' name='fina_val' id='fina_val' value=''>
				<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
				<input type='hidden' name='user_define' id='user_define' value="<%=user_define%>">
				<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			</table>
		</form>
	</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%><%
		if(rset !=null) rset.close();
		if(rset2 !=null) rset2.close();
		if(rs !=null) rs.close();
		if(stmt2 !=null) stmt2.close();
		if(stmt!=null)  stmt.close();

	}catch(Exception e)
	{
		out.println("Exception "+e.toString());

		e.printStackTrace();

	}finally
	{
		ConnectionManager.returnConnection(conn,request);

	}%>

