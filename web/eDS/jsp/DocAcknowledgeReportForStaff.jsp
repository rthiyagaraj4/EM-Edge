<!DOCTYPE html>
<!-- New file DocAcknowledgeReportForStaff.jsp created against ML-MMOH-CRF-0730 [IN:062776] -->
<%@ page import="eDS.Common.DlQuery" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.sql.Statement" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facility_id=(String)session.getAttribute("facility_id");
%>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/DocAcknowledgeReportForStaff.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
	<%
		Connection conn=null;
		PreparedStatement stmt=null;
		Statement st = null ;
		ResultSet rst=null;

		String pat_id_length="",current_date="",sql = "",meal_category_code="",meal_category_description="";
		String diet_type_code="",diet_type_description="";
		String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
		String diet_location_code="",diet_location_description="",default_diet_request_location="";
		try{
			conn	= ConnectionManager.getConnection(request);
			st	= conn.createStatement() ;
			rst	= st.executeQuery(sql_curr_date);
			while(rst!=null && rst.next()){
				current_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
				}			
	%>
<form name="MealAcknowledgeReport" id="MealAcknowledgeReport" method="post"  target="messageFrame">
	<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>	

		<!-- Document Acknowledge Meal Order From -->
		<tr>
			<td class='label' align="right">
					<fmt:message key="eOT.MealOrderFrom.Label" bundle="${ot_labels}" />
			</td>
			<td class='label' >
					<input type="text" name="mealOrderFrom" id="mealOrderFrom" value="<%=current_date%>" size="10"onblur="validDateObj(this,'DMY','en');" onkeypress="return Valid_DT(event)" maxlength="10" /><!-- CRF-0419-->
					<img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('mealOrderFrom');"/>	
					<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>

		<!-- Document Acknowledge DietRequestLocation -->
		<tr>
			<td class='label' align="right">
				<fmt:message key="eDS.DietRequestLocation.Label" bundle="${ds_labels}" />
			</td>
			<td  class='label' >
				<select name="dietLocation" id="dietLocation" id ='dietLocation'>
				<% try
				      { 
					  	  sql="SELECT SUM (eff_count) eff_count, SUM (default_count) default_count FROM (SELECT COUNT (*) eff_count, 0 default_count FROM ds_diet_request_loc_lang_vw b WHERE b.language_id = 'en' AND b.eff_status = 'E' UNION SELECT 0 eff_count, COUNT (*) default_count FROM ds_diet_request_loc_lang_vw d WHERE d.language_id = 'en' AND d.eff_status = 'E' AND d.default_diet_request_location = 'Y')";  
						  int eff_status_Count=0;
						  int default_Count=0;
							stmt=conn.prepareStatement(sql);
							rst=stmt.executeQuery();
						 if (rst.next())
						 {
							 eff_status_Count = rst.getInt(1);
							 default_Count = rst.getInt(2);
						 }		
					 if(default_Count != 1 && eff_status_Count != 1)
					 {
				%>
						<option value="">
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
				<%
					 }
							sql= "SELECT LOCATION_CODE, SHORT_DESC,DEFAULT_DIET_REQUEST_LOCATION FROM ds_diet_request_loc_lang_vw WHERE language_id = 'en' and eff_status = 'E' ORDER BY 2, 1";
		
							stmt=conn.prepareStatement(sql);
							rst=stmt.executeQuery();
							if(rst!=null)
							{
							   while(rst.next())
							        {
								        diet_location_code=rst.getString(1);
								        diet_location_description=rst.getString(2);
										default_diet_request_location=rst.getString(3);
									 if(default_Count == 1 && default_diet_request_location.equalsIgnoreCase("Y"))
									 {
				%>
							              <option value="<%=diet_location_code%>" selected><%=diet_location_description%>
				<%
									  }
									  else
									  {
				 %>
					              	<option value="<%=diet_location_code%>" ><%=diet_location_description%>
				<%  }
						}
						}
				%>
					</select>
				
			<% }catch(Exception e){
				e.printStackTrace();
			}
			finally{
			try{
				if(rst!=null) rst.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			%>
			</td>
		</tr>
		
		<!-- Document Acknowledge Meal Category-->
		<tr>
				<td class='label' align="right">
					<fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}" />
				</td>
				<td  class='label' >				
					<select name="mealCategory" id="mealCategory" onChange="callPractitioner(this)">
						<option value="">
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
					<% try
					      { 
														
							sql= "SELECT meal_category_code, description FROM ds_meal_category_lang_vw WHERE meal_category_code IN ('STF', 'ONC', 'STU','DOC','OPS') AND (language_id = '"+locale+"') ORDER BY 2, 1";

							stmt=conn.prepareStatement(sql);
							rst=stmt.executeQuery();
							if(rst!=null)
							{
							   while(rst.next())
							        {
								        meal_category_code=rst.getString(1);
								        meal_category_description=rst.getString(2);
					%>
					              <option value="<%=meal_category_code%>"><%=meal_category_description%>
					<%  
									}
							}
					%>
					</select>					
				 <% }catch(Exception e){
						e.printStackTrace();
						}
				  finally{
					try{
						if(rst!=null) rst.close();
						if(stmt!=null) stmt.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				%>
			</td>
		  </tr>

		<!-- Document Acknowledge Practitioner Id -->

		<tr id="practId" style="display:none;">
					<td align='right' width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td>
					<input type=text name='practitioner_id' id='practitioner_id'  onblur="callPractSearch1(this,practitioner_id,'en','<%=facility_id%>');" value=''   size='25' >
					<input type=hidden name='practitionerid' id='practitionerid'  value='' size='30' maxlength='30' ></input>
					
					</td>
		</tr>

		<!-- Document Acknowledge Practitioner Name -->
		<tr id="practName" style="display:none;">
				<td class='label' align="right">
					<fmt:message key="eDS.practitionerName.Label" bundle="${ds_labels}" />					
				</td>

				<td>
					<input type=text name='practitioner_name' id='practitioner_name'   value=''   size='25'  >
					<input type=hidden name='practitionername' id='practitionername'  value='' size='30' maxlength='30' ></input>
					<input type='button' class='button' value='?'  name='search_pract' id='search_pract'  onClick="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" >
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
         </tr>

		<!-- Document Acknowledge DietType -->
		<tr>
						<td class='label' align="right">
							<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
						</td>							
						<td>
							<select name="DietType" id="DietType" id='DietType'>
								<option value="">
									<fmt:message key="Common.Select.label" bundle="${common_labels}" />
								</option>
							<% try
								  {
									/* appl_staff_order_yn is added newly */
									sql= "select DIET_TYPE,SHORT_DESC from DS_DIET_TYPE_LANG_VW where (LANGUAGE_ID='"+locale+"') and (EFF_STATUS='E') and (appl_staff_order_yn = 'Y') order by  2 , 1";//CRF-0419-US8
									stmt=conn.prepareStatement(sql);
									rst=stmt.executeQuery();
									if(rst!=null)
									{
									   while(rst.next())
											{
												diet_type_code=rst.getString(1);
												diet_type_description=rst.getString(2);
												%>
											   <option value="<%=diet_type_code%>"><%=diet_type_description%>
										<%  }
								  }%>
								</select>							
				<% }catch(Exception e){
						e.printStackTrace();
					}
				finally{
				try{
					if(rst!=null) rst.close();
					if(stmt!=null) stmt.close();
				}catch(Exception e)
				{
					e.printStackTrace();
						}
				}
				%>
			</td>				
		</tr>
		
		
		<!-- Document Acknowledge status -->
		<tr>
			<td align="right" class="label">
				<fmt:message key="Common.status.label" bundle="${common_labels}"/>
			</td>
			<td width=50% >
					<select name="setStatus" id="setStatus" onChange="callComplaint(this)">
						<option value=''>
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>						
						<option value='MR'>
							<fmt:message key="eOT.MealReceived.Label" bundle="${ot_labels}" />
						</option>
						<option value='MS'>
							<fmt:message key="eOT.MealServed.Label" bundle="${ot_labels}" />
						</option>
						<option value='MJ'>
							<fmt:message key="eOT.MealReject.Label" bundle="${ot_labels}" />
						</option>
					</select>					
			</td>
		</tr>
				
		<!-- Document Acknowledge Complaints -->
		<tr id="complaint" style="display:none;">
				<td class='label' align="right">
					<fmt:message key="eOT.Complaints.Label" bundle="${ot_labels}"/>
				</td>

				<td>
					<input type="text" value="" name="complaintDesc" id="complaintDesc" onblur="if(this.value!='') return complaintsLookup('complaintDesc'); else complaintCode.value=''" />
					<input type="hidden"  value="" name="complaintCode" id="complaintCode" />
					<input type="button" id="bt" class="BUTTON" value="?" onclick="complaintsLookup('complaintDesc')" />
				</td>
         	</tr>

	</table>

	<%
		}
		catch(Exception e){
			e.printStackTrace();
			out.println(e);
		}finally{
			if(conn!=null)  ConnectionManager.returnConnection(conn, request);
		}
	%>

	<input type="hidden" name="method" id="method"/>

	<INPUT TYPE="hidden" name="facility_id" id="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

	<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>

	<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
	<input type="hidden" name="module_id" id="module_id" value="DS">

	<input type="hidden" name="p_report_id" id="p_report_id" id ="p_report_id" value="DSMACKSTA">
	<input type="hidden" name="report_id" id="report_id" id ="report_id" value="DSMACKSTA"/>

	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
	<input type="hidden" name="datepattrn" id="datepattrn" value="dd/MM/yyyy"/>
	<input type="hidden" name="P_KITCHEN_CODE" id="P_KITCHEN_CODE"/>
	<input type="hidden" name="converDate" id="converDate" value="" />

	<input type='hidden' name='PARAM1' id='PARAM1' value="" />
	<input type="hidden" name="selectedAll" id="selectedAll" id="selectedAll" value="" />
	
</form>
</body>
</html>

