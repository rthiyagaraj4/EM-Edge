<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.util.*,java.text.*,java.sql.*,java.net.*,webbeans.eCommon.*"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<html>
	<head>
		<%String sStyle	=
		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		
		<script language="javascript" src="../../eCommon/js/common.js">	</script>
		<script language='javascript' src='../js/AgentforAllergen.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<!-- <script language="JavaScript" src="../js/eMRmessages.js"></script> // file not found -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
		<%
		String locale	= (String)session.getAttribute("LOCALE");
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		Statement stmt1=null;
		Statement stmt2=null;
		 PreparedStatement stmt=null;
		 ResultSet rset=null;
		ResultSet rset2=null;
		  ResultSet rs=null;
		String checkBoxAttribute="";
		String  CAUSATIVE_CODE="";
		String mode="";
	    boolean status = false;
		StringBuffer sql = new StringBuffer();
		String sql2="";
		String longdesc="";
		String shortdesc="";
		String effstatus="";
		String codeTextAttribute="";
		String otherTextAttribute="";
		 String adv_event_type_ind="";
		  
		   String dis_chk = "";
		   String eventFunctionForCase="";
		   String adv_event_desc="";
		   String ADV_EVENT_TYPE_DESC="";
		   String ADV_EVENT_TYPE_CODE="";
		   String facilityId="";
try
{
 
		conn = ConnectionManager.getConnection(request);
    	stmt1 = conn.createStatement();
		stmt2=conn.createStatement();
		 facilityId	=(String) session.getValue("facility_id"); CAUSATIVE_CODE=request.getParameter("CAUSATIVE_CODE")==null?"":request.getParameter("CAUSATIVE_CODE");
		mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		if(mode ==null || mode=="") mode="insert";
		
		if(CAUSATIVE_CODE==null || CAUSATIVE_CODE.equals(""))
		{
			CAUSATIVE_CODE="";
			longdesc="";
			shortdesc="";
			effstatus="E";
			codeTextAttribute="";
			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
			status=true;
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
		}else if(!CAUSATIVE_CODE.equals(""))
		{
			sql.append("SELECT a.ALLERGEN_CODE, a.long_desc, a.short_desc, a.eff_status,a.ADV_EVENT_TYPE_IND,a.adv_event_type_code, b.long_desc adv_event_desc FROM MR_ALLERGEN a, mr_adv_event_type b WHERE a.adv_event_type_code = b.adv_event_type_code and ALLERGEN_CODE=?");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1,CAUSATIVE_CODE);
			rset = stmt.executeQuery();
			while(rset.next())
			 {
				CAUSATIVE_CODE	=rset.getString("ALLERGEN_CODE");
				longdesc	=rset.getString("long_desc");
				shortdesc	=rset.getString("short_desc");
				effstatus	=rset.getString("eff_status");
			//	if(effstatus==null || effstatus.equals("")) effstatus="D";
				adv_event_type_ind=rset.getString("ADV_EVENT_TYPE_IND");
				adv_event_desc=rset.getString("adv_event_desc");
			 }

		   	 if(rset!=null)   rset.close();
			 if(stmt!=null)  stmt.close();

			 	if(effstatus.equals("D"))
				{
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
	
		}%>
	</head>
	<body onload='disable()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='causitive_agent' id='causitive_agent' action='../../servlet/eMR.AgentforAllergenServlet' method='post' target='messageFrame' >     
			<BR><BR><BR><BR><BR><BR><BR><BR>
			<table border='0' cellspacing=0 cellpadding=0 width='85%' align='center'>
			<tr><td class='label'></td></tr>
				<tr>
					<td  class='label' nowrap width='5%'><fmt:message key="eMR.AdverseEventTypeIndicator.label" bundle="${mr_labels}"/></td>
					<td><select name='sel_rec_type' id='sel_rec_type' <%=dis_chk%> onchange='get_adv_events(this);'>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------
						<%
							
							String adv_event1_code="";
							String adv_event_desc1="";
							if(mode.equals("insert"))
							{
								String adv_ind="select ADV_EVENT_TYPE_IND,mr_get_desc.mr_adv_event_type_ind(adv_event_type_ind,'"+locale+"',1) ADV_EVENT_TYPE_IND_DESC from MR_ADV_EVENT_TYPE_IND";
								rset2=stmt2.executeQuery(adv_ind);
								if(rset2 !=null)
								{
									while(rset2.next())
									{
										adv_event1_code=rset2.getString("ADV_EVENT_TYPE_IND");
										adv_event_desc1=rset2.getString("ADV_EVENT_TYPE_IND_DESC");
										
										out.println("<option value='"+adv_event1_code+"'>"+adv_event_desc1);
									}
								}
							}else{
								String sel="";
								String adv_ind="select ADV_EVENT_TYPE_IND,mr_get_desc.mr_adv_event_type_ind(adv_event_type_ind,'"+locale+"',1) ADV_EVENT_TYPE_IND_DESC from MR_ADV_EVENT_TYPE_IND";
								rset2=stmt2.executeQuery(adv_ind);
								if(rset2 !=null)
								{
									while(rset2.next())
									{
										adv_event1_code=rset2.getString("ADV_EVENT_TYPE_IND");
										adv_event_desc1=rset2.getString("ADV_EVENT_TYPE_IND_DESC");
										if(adv_event1_code.equals(adv_event_type_ind))
												sel="selected";
										else
												sel="";
										
										out.println("<option value='"+adv_event1_code+"'"+sel+">"+adv_event_desc1);
									}
								}
							}%>
						
						</select>
						<img id = 'code_mand' src = '../../eCommon/images/mandatory.gif'>

					<%if(mode.equals("insert")) {%>

						 <select name='adv_evnt_type' id='adv_evnt_type'  tabindex=0><option value=''> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option></select>

					<%}else if(mode.equals("modify")) {%>

							 <select name='adv_evnt_type' id='adv_evnt_type'  tabindex=0 <%=dis_chk%>><option value=''>  ------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						 <%
		 
						//sql2="Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE from MR_ADV_EVENT_TYPE a ,MR_ADV_EVENT_TYPE_DETAIL b where  a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and a.ADDED_FACILITY_ID='"+facilityId+"' and a.eff_status='E'  AND b.ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"'";

						sql2="Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE from MR_ADV_EVENT_TYPE a ,MR_ADV_EVENT_TYPE_DETAIL b where  a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and a.eff_status='E'  AND b.ADV_EVENT_TYPE_IND='"+adv_event_type_ind+"'";

						
					
							//if (rs!=null) rs.close();
							rs = stmt1.executeQuery(sql2) ;
							String sel="";
							if (rs != null)
							{
								while(rs.next())
								{

								ADV_EVENT_TYPE_DESC=rs.getString("long_desc");
								ADV_EVENT_TYPE_CODE=rs.getString("ADV_EVENT_TYPE_CODE");
								if (ADV_EVENT_TYPE_DESC.equals(adv_event_desc))
										sel="selected";
									else
										sel="";
								out.println("<option value='"+ADV_EVENT_TYPE_CODE+"' "+sel+">"+ADV_EVENT_TYPE_DESC);
										
								}
							}%>
						</select></td>
					</tr>
				<%}%>
							

				<tr>
					<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td  class='fields'><input type=text name='code_val' id='code_val' maxlength="4" size="4" value='<%=CAUSATIVE_CODE%>'onKeyPress="return CheckForSpecChars(event)" <%=codeTextAttribute%> <%=eventFunctionForCase%>><img id = 'code_mand' src = '../../eCommon/images/mandatory.gif'></td>
				</tr>

							

				<tr>
					<td class='label' nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type=text name='long_desc' id='long_desc' value="<%=longdesc%>" maxlength="30" size="30" <%=otherTextAttribute%> onBlur="makeValidString(this);" ><img id = 'long_mand' src = '../../eCommon/images/mandatory.gif'>
				</tr>

							

				<tr>
					<td class='label' nowrap><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type=text name='Short_desc' id='Short_desc' value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this);" maxlength="15" size="15"><img id = 'long_mand' src = '../../eCommon/images/mandatory.gif'>
				</tr>
				
					

				<tr>
      		     <td class='label' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="medBoard_change()"></td>
      			</tr>
						

				<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
				<input type='hidden' name='adv_agnt_code_val' id='adv_agnt_code_val' value=''>
				<input type='hidden' name='adv_agnt_desc_val' id='adv_agnt_desc_val' value=''>
				<input type='hidden' name='allow_one' id='allow_one' value=''>
				<input type='hidden' name='allow_two' id='allow_two' value=''>
				<input type='hidden' name='allow_three' id='allow_three' value=''>
				<input type='hidden' name='allow_four' id='allow_four' value=''>
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
	%>
		<%
	
	if(rset!=null)   rset.close();
	if(rset2!=null)   rset2.close();
	if(rs!=null)   rs.close();
	if(stmt!=null)  stmt.close();
	if(stmt1!=null)  stmt1.close();
	if(stmt2!=null)  stmt2.close();

}catch(Exception e)
	{
		out.println("Exception "+e);
		e.printStackTrace();

	}finally{
		
		ConnectionManager.returnConnection(conn,request);
	}%>

