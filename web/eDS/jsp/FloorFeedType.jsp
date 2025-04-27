<!DOCTYPE html>
<!---KDAH-CRF-0351 for Floor wise feed type-->
<%@page import="eDS.Common.DlQuery"%>

<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.sql.Statement,eCommon.Common.*"%>
<%@  page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/FloorFeedType.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
		<%
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String facility_id  = (String) session.getValue("facility_id");
			String servingDate="";
			try{

				conn = ConnectionManager.getConnection(request);
				pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
		%>

	<form name="FloorFeedType" id="FloorFeedType" method="post"  target="messageFrame">
		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
	    
		    <tr>
				<td align="right" class="label">
				<fmt:message key="Common.date.label" bundle="${common_labels}"/>
				</td>
				<td>
                <input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
				<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
				<img src='../../eCommon/images/mandatory.gif' />
				</td>
		   </tr>
          
		   <tr>
				<td  class="label" align="right">
				   <fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
				</td>
				<td>
				 <select name="nursing_Unit" id="nursing_Unit" id ="nursing_Unit">
				 <option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<% try{
							 conn = ConnectionManager.getConnection(request);
							 pstmt = conn.prepareStatement(DlQuery.DL_DS_NURSING_UNIT);
							 pstmt.setString(1, locale);
							 pstmt.setString(2, facility_id);
							 rst = pstmt.executeQuery();
						     while(rst.next()) {%>							 
							 <option value="<%=rst.getString("nursing_unit_code")%>"><%=rst.getString("short_desc") %></option>					 
					<%}
							 pstmt = null;
							 rst = null;
					%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
								
					 <%}
                         catch(Exception e){
						     e.printStackTrace();
			                 out.println(e);
						}
                         finally{
							try{
								if(pstmt!=null) pstmt.close();
								if(rst!=null) rst.close();
								ConnectionManager.returnConnection(conn);
								}
								catch(Exception e){
									e.printStackTrace();
								System.err.println("Exception in Attendents:"+e);
								}
							}
					%>
							
			     </td>
			</tr>
		    	
			<tr>
				  <td  class="label" align="right">
					   <fmt:message key="eOT.FeedType.Label" bundle="${ot_labels}" />
					</td>
					<td>
						<select name="feedType" id="feedType" id ="feedType">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
							<% try{
							         conn = ConnectionManager.getConnection(request);
							         pstmt = conn.prepareStatement(DlQuery.DL_DS_FEED_TYPE);
								     rst = pstmt.executeQuery();
						             while(rst.next()) {%>
									 
									<option value="<%=rst.getString("feed_Type")%>"><%=rst.getString("short_desc") %></option>
							<%}
									 pstmt = null;
									rst = null;%>
						 </select>
									
							<%}

							catch(Exception e){
								e.printStackTrace();
			                    out.println(e);
							}

							finally{
								try{
									if(pstmt!=null) pstmt.close();
									if(rst!=null) rst.close();
									ConnectionManager.returnConnection(conn);
								}
								catch(Exception e){
									e.printStackTrace();
									System.err.println("Exception in Attendents:"+e);
								}
							}
							%>
							
			        </td>
				</tr>	  
			    <tr>
					 <td  class="label" align="right">
						 <fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
						</td>
						 <td>
						<select name="mealType" id="mealType" id ="mealType">
						<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
							<% try{
							           conn = ConnectionManager.getConnection(request);
							            pstmt = conn.prepareStatement(DlQuery.DL_DS_MEAL_TYPE);
										pstmt.setString(1, locale);
							            rst = pstmt.executeQuery();
						    
										while(rst.next()) {%>
											<option value="<%=rst.getString("meal_type")%>">
											<%=rst.getString("short_desc") %>
											</option>
										<%}
										pstmt = null;
										rst = null;%>
									</select>
								
							<%}

							catch(Exception e){
								e.printStackTrace();
			                    out.println(e);
							}

							finally{
								try{
									if(pstmt!=null) pstmt.close();
									if(rst!=null) rst.close();
									ConnectionManager.returnConnection(conn);
								}
								catch(Exception e){
									e.printStackTrace();
									System.err.println("Exception in Floor Feed:"+e);
								}
							}
							%>
						</td>
					</tr>
		
            </table>
			<%
			 }
		       catch(Exception e){
			    e.printStackTrace();
			    out.println(e);
		    }finally{
		      if(conn!=null)  
		     ConnectionManager.returnConnection(conn);
		   }
			 %>
				<input type="hidden" name="method" id="method"/>

				<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

				<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
				<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>

				<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
				<input type="hidden" name="module_id" id="module_id" value="DS">

				<input type="hidden" name="p_report_id" id="p_report_id" value="DSFLWFTYP">
				<input type="hidden" name="report_id" id="report_id" value="DSFLWFTYP"/>

				<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
				<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
				<input type="hidden" name="datepattrn" id="datepattrn" value="dd/MM/yyyy"/>
				<input type="hidden" name="P_KITCHEN_CODE" id="P_KITCHEN_CODE"/>
				<input type="hidden" name="converDate" id="converDate" value="" />
				<input type='hidden' name='PARAM1' id='PARAM1' value="" />			
					</form>
				</body>
		</html>

