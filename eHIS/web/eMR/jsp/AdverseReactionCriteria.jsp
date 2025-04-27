<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<html>
	<head>
		<%String sStyle	=
		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/common.js">	</script>
		<script language='javascript' src='../js/AdverseReaction.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<!-- <script language="JavaScript" src="../js/eMRmessages.js"></script> file not found -->  
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<script>

		function enable_txt(obj)
		{
			if(obj.value!='00')
					
			  document.forms[0].search_txt.disabled=false;
					
			else
			{
			  document.forms[0].search_txt.disabled=true;
			   document.forms[0].search_txt.value="";
			}
		}

		
		</script>
	
		<%
			String locale			= (String)session.getAttribute("LOCALE");
			request.setCharacterEncoding("UTF-8");
		   Connection conn = null;
		   Statement stmt1=null;
		   ResultSet rs=null;
		   ResultSet rset2=null;
		   String mode="";
		   String reac_code="";
		   String reac_desc="";


	try
	{
 
		conn = ConnectionManager.getConnection(request);
    	stmt1 = conn.createStatement();
		mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		if(mode ==null || mode=="") mode="insert";
		String sql1="";
%>
</head>
	<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >

		<form name='Adverse_reaction_criteria' id='Adverse_reaction_criteria' >  
	
			<BR><BR>

			<table border='0' cellspacing=0 cellpadding=3 width='85%' align='center'>

			
				
					<tr>
						<td  class=label ><fmt:message key="Common.Reaction.label" bundle="${common_labels}"/></td>
						<td class='fields'><select name='reac_long_desc' id='reac_long_desc' onchange="enable_search(this);">
							<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------
						<%
						
						 //sql1="select REACTION_CODE, long_desc,short_DESC,eff_status from AM_REACTION WHERE REACTION_CODE NOT LIKE 'UNKN%' AND ADVERSE_REACTION_YN ='Y' AND EFF_STATUS='E' ORDER BY LONG_DESC ASC  ";
						 sql1="select REACTION_CODE, am_get_desc.am_reaction(reaction_code,'"+locale+"',1) long_desc,am_get_desc.am_reaction(reaction_code,'"+locale+"',2)short_DESC,eff_status from AM_REACTION WHERE REACTION_CODE NOT LIKE 'UNKN%' AND ADVERSE_REACTION_YN ='Y' AND EFF_STATUS='E' ORDER BY LONG_DESC ASC  ";
						rs=stmt1.executeQuery(sql1);
						if(rs !=null)
						{
							while(rs.next())
							{
							reac_code=rs.getString("REACTION_CODE");
							reac_desc=rs.getString("long_desc");
							out.println("<option value='"+reac_code+"'>"+reac_desc);
	
							}
						}%></select>	<img  src = '../../eCommon/images/mandatory.gif'></td>
							
					</tr>

					<tr>
					<td  class='label' nowrap width='5%'><fmt:message key="eMR.AdverseEventTypeIndicator.label" bundle="${mr_labels}"/></td>
					<td><select name='sel_rec_type' id='sel_rec_type' onchange='get_adv_events(this);claerResultPage()'>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------
						<%
							
							String adv_event1_code="";
							String adv_event_desc1="";
							//String adv_ind="select ADV_EVENT_TYPE_IND,ADV_EVENT_TYPE_IND_DESC from MR_ADV_EVENT_TYPE_IND ORDER BY ADV_EVENT_TYPE_IND_DESC ASC ";
							String adv_ind="select ADV_EVENT_TYPE_IND,mr_get_desc.mr_adv_event_type_ind(adv_event_type_ind,'"+locale+"',1)ADV_EVENT_TYPE_IND_DESC from MR_ADV_EVENT_TYPE_IND ORDER BY ADV_EVENT_TYPE_IND_DESC ASC ";
								rset2=stmt1.executeQuery(adv_ind);
								if(rset2 !=null)
								{
									while(rset2.next())
									{
										adv_event1_code=rset2.getString("ADV_EVENT_TYPE_IND");
										adv_event_desc1=rset2.getString("ADV_EVENT_TYPE_IND_DESC");
										
										out.println("<option value='"+adv_event1_code+"'>"+adv_event_desc1);
									}
								}
							%>
						
						</select>
						<img id = 'code_mand' src = '../../eCommon/images/mandatory.gif'>
						 <select name='adv_evnt_type' id='adv_evnt_type' onchange='claerResultPage()' tabindex=0><option value=''> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option></select>
					</tr>

					<tr>
					
					<td class='label' width="20%" id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
					<td  colspan=1 class='fields' width="80%">
					
					<SELECT name="search_by" id="search_by" onchange="enable_txt(this)">
					<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
					<option value="01"><fmt:message key="eMR.AllergenCode.label" bundle="${mr_labels}"/></option>
					<option value="02"><fmt:message key="eMR.Allergendesc.label" bundle="${mr_labels}"/></option>
					</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt"  disabled size=30 maxlength=30></td>
						
					</tr>


					<tr>
						<td class="padding"></td>
						<td class="button">
							<input type="button" class="button" name="search" value="Search" disabled="" onclick="serach_results();" style="float: right;margin-top: 0px;">
						</td>
					</tr>
				

				</table>

					<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
					<input type='hidden' name='adv_agnt_code_val' id='adv_agnt_code_val' value=''>
					<input type='hidden' name='adv_agnt_desc_val' id='adv_agnt_desc_val' value=''>
					<input type='hidden' name='allow_one' id='allow_one' value=''>
					<input type='hidden' name='allow_two' id='allow_two' value=''>
					<input type='hidden' name='allow_three' id='allow_three' value=''>
					<input type='hidden' name='allow_four' id='allow_four' value=''>
					<input type='hidden' name='locale' id='locale' value="<%=locale%>">
							
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
		if(stmt1 !=null)stmt1.close();	
		if(rs !=null)rs.close();
	}catch(Exception e)
	{
		out.println("Exception "+e.toString());
		e.printStackTrace();

	}finally{
		ConnectionManager.returnConnection(conn,request);

	}%>

