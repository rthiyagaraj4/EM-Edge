<!DOCTYPE html>
<!--addModifyVisitRule.jsp is introduced by Suresh M on 03.11.2011 for  FD-KDAH-CRF-0033-->
<%@ page   import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>

	<head>
	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  <script language='javascript' src='../js/VisitRule.js'></script>
	  <script language='javascript' src='../../eCommon/js/common.js'></script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	</head>
<%	 
	Connection con 					= null;
	PreparedStatement pstmt			= null;
	ResultSet rset				    = null;	 
	request.setCharacterEncoding("UTF-8");

	
//	String	facilityId				= (String) session.getValue( "facility_id" ) ;
	String mode						= "";
	String rule_id				= request.getParameter("rule_id")==null?"":request.getParameter("rule_id");
	try
	{
		con									= ConnectionManager.getConnection(request);		 
		String rule_desc	= "";
		String follow_up ="" ;
		String secondary_visit ="";
		String eff_status					= "";	
		String checkBoxAttribute		= "";	
		String cummulativeCheckBox		= "";	
		String readonly                    = "";
		String modifymode				= "";		
		String no_of_followup_visit		= "";		
		String no_of_sec_visit			= "";		
		String cummulative_allowed_yn	= "";		
		 
		mode = "INSERT";
		
		String sql = "select rule_id, rule_desc, follow_up_visit, secondary_visit, no_of_followup_visit, no_of_sec_visit, cummulative_allowed_yn, eff_status from op_visit_rule where rule_id=? ";		 
		if(!rule_id.equals(""))
		{
			pstmt   = con.prepareStatement(sql);
			pstmt.setString(1,rule_id);		
			rset = pstmt.executeQuery();
			
			while(rset!=null && rset.next())
			{
				mode = "MODIFY";
				rule_id					= rset.getString("rule_id")==null?"":rset.getString("rule_id");    
				rule_desc					= rset.getString("rule_desc")==null?"":rset.getString("rule_desc");    
				follow_up					= rset.getString("follow_up_visit");    
				secondary_visit			= rset.getString("secondary_visit");    
				no_of_followup_visit			= rset.getString("no_of_followup_visit");    
				no_of_sec_visit			= rset.getString("no_of_sec_visit");    
				cummulative_allowed_yn = rset.getString("cummulative_allowed_yn")==null?"N":rset.getString("cummulative_allowed_yn");    
				eff_status					= rset.getString("eff_status")==null?"D":rset.getString("eff_status");   
				if(eff_status!=null && eff_status.equalsIgnoreCase("E")){
					checkBoxAttribute   = "CHECKED";
				}else
					readonly="disabled";					
				if(cummulative_allowed_yn!=null && cummulative_allowed_yn.equalsIgnoreCase("Y")){
					cummulativeCheckBox   = "CHECKED";
				}else
					cummulativeCheckBox = "UNCHECKED";				 
			}	 
			if(rset!=null)  rset.close();
			if(pstmt!=null)  pstmt.close();
		}	// end of if rule_id
		if(mode.equalsIgnoreCase("INSERT"))		
			checkBoxAttribute = "CHECKED";			
		else if(mode.equalsIgnoreCase("MODIFY"))
			modifymode="disabled";
		%>
		<body OnMouseDown='CodeArrest()' onLoad='setFocus();' onKeyDown = 'lockKey()'>
			 <form name="visit_rule_form" id="visit_rule_form" action="../../servlet/eOP.VisitRuleServlet" method="post" target="messageFrame">
	
				<table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
				 <br><br><br><br>
					<tr><td colspan='2' height='5'></td></tr>
				    <tr>
					    <td class='label'  width='50%'><fmt:message key="eOP.RuleID.label" bundle="${op_labels}"/></td>
						<td class='field'  width='50%'>	
						<input type='text' name='rule_id' id='rule_id' value='<%=rule_id%>' maxLength='4' size='4'
		  onBlur='ChangeUpperCase(this);' onKeyPress="return CheckForSpecChars(event);" <%=readonly%> <%=modifymode%>>
		  <img src='../../eCommon/images/mandatory.gif' ></img>
						</td> 	
				    </tr>	
					<tr><td colspan='2' ></td></tr>

					<tr><td colspan='2' height='5'></td></tr>
				    <tr>
					    <td class='label'  width='50%'><fmt:message key="eOP.RuleDesc.label" bundle="${op_labels}"/></td>
						<td class='field'  width='50%'>	
						<input type='text' name='rule_desc' id='rule_desc' value='<%=rule_desc%>' maxLength='40' size='40'  onblur =" makeValidString(this);" <%=readonly%>>
						<img src='../../eCommon/images/mandatory.gif' ></img>
						</td> 	
				    </tr>	
					<tr><td colspan='2' ></td></tr>

					<tr><td colspan='4' height='5'></td></tr>
				    <tr>
					    <td class='label'  width='50%'><fmt:message key="eOP.Followup.label" bundle="${op_labels}"/></td>
						<td class='field'  width='50%'>	
						<input type='text' name='followup_days' id='followup_days' value='<%=follow_up%>' maxLength='2' size='2'
		  onBlur='checkForZero(this);' onKeyPress="return CheckForDigits(event);" <%=readonly%>>
		  <fmt:message key="Common.days.label" bundle="${common_labels}"/>
		  <img src='../../eCommon/images/mandatory.gif' ></img>
						</td> 	
				    </tr>	
					<tr><td colspan='2' ></td></tr>

					<tr><td colspan='4' height='5'></td></tr>
				    <tr>
					    <td class='label'  width='50%'><fmt:message key="eOP.SecondaryVisit.label" bundle="${op_labels}"/></td>
						<td class='field'  width='10%'>	
						<input type='text' name='secvisit_days' id='secvisit_days' value='<%=secondary_visit%>' maxLength='2' size='2'
		  onBlur='checkForZero(this);' onKeyPress="return CheckForDigits(event);"<%=readonly%>>
		  <fmt:message key="Common.days.label" bundle="${common_labels}"/>
		  <img src='../../eCommon/images/mandatory.gif' ></img>
						</td> 	
				    </tr>	
					<tr><td colspan='2' ></td></tr>

					<tr><td colspan='4' height='5'></td></tr>
				    <tr>
					    <td class='label'  width='50%'><fmt:message key="eOP.NoofFollowupAllowed.label" bundle="${op_labels}"/></td>
						<td class='field'  width='50%'>	
						<input type='text' name='no_of_followup_visit' id='no_of_followup_visit' value='<%=no_of_followup_visit%>' maxLength='2' size='2'
		  onBlur='checkForZero(this);' onKeyPress="return CheckForDigits(event);"<%=readonly%>>		   
		  <img src='../../eCommon/images/mandatory.gif' ></img>
						</td> 	
				    </tr>	
					<tr><td colspan='2' ></td></tr>

					<tr><td colspan='4' height='5'></td></tr>
				    <tr>
					    <td class='label'  width='50%'><fmt:message key="eOP.NoofSecondaryAllowed.label" bundle="${op_labels}"/></td>
						<td class='field'  width='50%'>	
						<input type='text' name='no_of_sec_visit' id='no_of_sec_visit' value='<%=no_of_sec_visit%>' maxLength='2' size='2'
		  onBlur='checkForZero(this);' onKeyPress="return CheckForDigits(event);"<%=readonly%>>		   
		  <img src='../../eCommon/images/mandatory.gif' ></img>
						</td> 	
				    </tr>	
					<tr><td colspan='2' ></td></tr>

					<tr><td colspan='4' height='5'></td></tr>
					<tr>
						<td class='label'  width='50%'><fmt:message key="eOP.CummulativevisitsAllowed.label" bundle="${op_labels}"/></td>
			    	    <td class='field'  width='50%'><input type='checkbox' name='cummulative_allowed_yn' id='cummulative_allowed_yn' value="N" <%=cummulativeCheckBox%>  onClick='chkCumtiveValue(this);'>
						</td>
			        </tr>
					<tr><td colspan='2' height='5'></td></tr>
					<tr>
						<td class='label'  width='50%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			    	    <td class='field'  width='50%'><input type='checkbox' name='eff_status' id='eff_status' value="E" <%=checkBoxAttribute%>  onClick='chkValue(this);'>
						</td>
			        </tr>
					<tr><td colspan='2' height='5'></td></tr>
			 </table> 
			     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >				
		 </form>
	  </body>
<%
		if(rset!=null) rset.close(); 
		if(pstmt!=null) pstmt.close();	    
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
    {
    	if(con != null)
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

