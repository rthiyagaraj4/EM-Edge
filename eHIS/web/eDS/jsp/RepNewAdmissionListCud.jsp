<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>

	 <%
		String locale = (String)session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
			
	%>   
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<Script Language="JavaScript" src="../../eDS/js/NewAdmissionList.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



 </head>
 <%
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String facility_id  = (String) session.getValue("facility_id");
			// Checkstyle Violation commented by Munisekhar
			//String params="";
			//String source ="";
			//String duration ="";
			String sql="";
			String strCode ="";
			String strDesc ="";
			String servingDate="";
			// Checkstyle Violation commented by Munisekhar
			//String strMtype = "";
			//String strMDesc = "";

			try{

				conn = ConnectionManager.getConnection(request);


				pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = rst.getString("CURRENT_DATE");
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				
			
			
		%>
	<body>
		<form name="NewAdmissionList" id="NewAdmissionList" target="messageFrame" method="GET">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			<tr>
				<td  class="label">
						<fmt:message key="Common.date.label" bundle="${common_labels}" />
				</td>
					<td>
						<input type="text" name="date" id="date" maxlength="10" size="16" value="<%=servingDate%>" onblur='isValidDate(this);'>
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date');">
						<img src='../../eCommon/images/mandatory.gif' />
							
					</td>
				<td>
			</td>
		</tr>
			<tr>
				<td  class="label">
					<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}" />
				</td>
					<td>
						<select name="kitchen" id="kitchen">
							<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
							<%
									try
									{
									sql ="select kitchen.kitchen_Code,kitchen.short_Desc from Ds_Kitchens_Lang_Vw kitchen where kitchen.operating_Facility_Id like '"+facility_id+"' and   kitchen.language_Id = '"+locale+"'and   kitchen.eff_Status ='E'";
										pstmt=conn.prepareStatement(sql);
										rst = pstmt.executeQuery();
										while(rst.next()){
										strCode = rst.getString(1);
										strDesc =  rst.getString(2);
								%>
								<option value="<%=strCode%>"><%=strDesc%></option>
								<%}

									}
									  catch(Exception DCat)
										  {
										  System.out.println("GenerateMeal Plan Kitchen"+DCat);
									  }
									   finally
									   {
										   if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
									   }

								%>
								</select>
								<img src='../../eCommon/images/mandatory.gif' />
							</td>
						<td>
					</td>
					<%
									}
									  catch(Exception e)	  {}
									   finally
									   {
											try{
												if(pstmt!=null) pstmt.close();
												if(rst!=null) rst.close();
												ConnectionManager.returnConnection(conn);
											}
											catch(Exception e){
												System.err.println("Exception in New Admission List:"+e);
											}
									   }

								%>
				</tr>
				<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			</table>			
			
					<INPUT TYPE="hidden" name="module_id" id="module_id" VALUE="DS">
					<input type="hidden" name="p_module_id" id="p_module_id" value="DS"/>
					
					<input type="hidden" name="report_id" id="report_id" value="DSRNADML"/>
					<input type="hidden" name="p_report_id" id="p_report_id" value="DSRNADML"/>			
					
					<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
					<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
					
					<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
					<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
					
					<input type='hidden' name='locale' id='locale' value="<%=locale%>"/>
					<input type='hidden' name='datepattrn' id='datepattrn' value="dd/MM/yyyy"/>

					<input type="hidden" name="P_KITCHEN_CODE" id="P_KITCHEN_CODE"/>		
					<input type="hidden" name="P_ADMISSION_DATE" id="P_ADMISSION_DATE"/>							
		</form>
	</body>
</html>

