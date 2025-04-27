<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% 
String locale = (String)session.getAttribute("LOCALE"); 
String facility_id=(String)session.getAttribute("facility_id").toString(); 
%>
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
<script language='javascript' src='../../eDS/js/MealCategory.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String nursingUnit = "";
   //Checkstyle Violation commented by Munisekhar
   //String patientOrder = "";
   //String noAttendents = "";
   String mealCategoryCode = request.getParameter("mealCategory");
   String disabled_flag = "";
   String readOnlyFlag = "";
   int totalRows = 0;
   String Attendent_Label_Name=request.getParameter("Attendent_Label_Name");//ML-MMOH-CRF-406
   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;

   String mode = request.getParameter("mode");
   if("modify".equals(mode)){
	   try{
  			disabled_flag = "disabled";
  			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_MEAL_CATEGORY);
	   		pstmt.setString(1,mealCategoryCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			nursingUnit = rst.getString("default_diet_type");
	   			nursingUnit = rst.getString("default_meal_class");
	   		}
  		}

  		catch(Exception e){
	   		System.err.println("Error in Meal Category->"+e);
  		}
  		finally{
  			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Meal Category:"+e);
			}
  		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="mealAttendents" id="mealAttendents"  onload='FocusFirstElement()'  action="../../servlet/eDS.MealCategoryServlet" method="post" target="messageFrame">
			<table width="100%" border="0" cellpadding="" cellspacing="0" align="center">
						<tr><td valign="top"> <!-- IN::39906 -->
						<table border="0 " cellpadding="" cellspacing="0" >
						<% try{
							con = ConnectionManager.getConnection(request);
							pstmt = con.prepareStatement(DlQuery.DL_DS_NURSING_UNIT);
							pstmt.setString(1, locale);
							pstmt.setString(2, facility_id);//ML-MMOH-CRF-406
							rst = pstmt.executeQuery();
						%>
							<tr>
								<td  class="label" align="right">
								<fmt:message key="eOT.NursingUnit.Label" bundle="${ot_labels}"/>
								</td>
								<td>
									<select name="nursing_Unit" id="nursing_Unit">
										<option value="">
											<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
										</option>
										<%while(rst.next()) {%>
											<option value="<%=rst.getString("nursing_unit_code")%>">
											<%=rst.getString("short_desc") %>
											</option>
										<%}
										pstmt = null;
										rst = null;%>
									</select>
								</td>
							</tr>
							<%}

							catch(Exception e){
								System.err.println("Exception in Attendents:"+e);
							}

							finally{
								try{
									if(pstmt!=null) pstmt.close();
									if(rst!=null) rst.close();
									ConnectionManager.returnConnection(con);
								}
								catch(Exception e){
									System.err.println("Exception in Attendents:"+e);
								}
							}
							%>
							<tr>
								<td class="label" align="right">
									<fmt:message key="eOT.PatientOrder.Label" bundle="${ot_labels}"/>
								</td>
								<td>
									<input type="checkbox" name="patient_Order" id="patient_Order"/>
								</td>
							</tr>
							<tr>
								<td class="label" align="right">
								<!--<fmt:message key="eOT.NoOfAttendent.Label" bundle="${ot_labels}"/>-->
								No Of <%=Attendent_Label_Name%><!--ML-MMOH-CRF-406-->
								</td>
								<td>
								<!-- modified by N Munisekhar on 20-May-2013 against [IN39893]-->
								<input type="text" name="noAttendents" id="noAttendents" value="" size="4" maxlength="4" onkeypress="checkNumber()" onpaste="return false;"/>
								<!--End of[IN39893]-->
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="button" value="Select" onClick="selectRecord1()" class="button"/>
									<input type="button" value="Cancel" class="button" onClick="cancelRecord()"/>
								</td>

							</tr>
						</table>
						</td>
						<td width="50%" valign="top"> <!-- IN:: 39906 -->
						<table id="listContentTable" border="1" cellpadding="0" cellspacing="0">
							<tr>
								 <th class="columnheadercenter" nowrap>
									<fmt:message key="eOT.NursingUnit.Label" bundle="${ot_labels}"/>
								</th>
								 
								

								<th class="columnheadercenter" nowrap>
									<fmt:message key="eOT.PatientOrder.Label" bundle="${ot_labels}"/>
								</th>
								<th class="columnheadercenter" nowrap>
									<!--<fmt:message key="eOT.NoOfAttendent.Label" bundle="${ot_labels}"/>-->
									No Of <%=Attendent_Label_Name%><!--ML-MMOH-CRF-406-->
								</th>
							</tr>
							<% try{
									con = ConnectionManager.getConnection(request);
									pstmt = con.prepareStatement(DlQuery.DL_GET_MEAL_ATTENDENTS);
									rst = pstmt.executeQuery();
									int i=2;
									int j=0;
									while(rst.next()){%>
										<input type="hidden" name="nutMode<%=j %>" id="nutMode<%=j %>" value="U">
										<tr>
											<td><a href="javascript:callfn12(<%=i%>)"><%=rst.getString("nursing_unit_code") %></a></td>
											<td><%=rst.getString("dflt_patient_order_yn") %></td>
											<td><%=rst.getString("deflt_attendents") %></td>
										</tr>
										<%i++;
										j++;%>
									<%}
									pstmt = null;
									rst = null;
									totalRows = j;
								}

								catch(Exception e){
									System.err.println("Exception in Attendents:"+e);
								}

								finally{
									try{
										if(pstmt!=null) pstmt.close();
										if(rst!=null) rst.close();
										ConnectionManager.returnConnection(con);
									}
									catch(Exception e){
										System.err.println("Exception in Attendents:"+e);
									}
								}
							%>
						</table>
						</td>
						</tr>
						</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updMealCategory' id='updMealCategory' value='<%=mealCategoryCode%>'>
			<input type='hidden' name='forUpdate' id='forUpdate' value=''>
			<input type='hidden' name='totalRows' id='totalRows' value='<%=totalRows%>'>
			<input type='hidden' name='Attendent_Label_Name' id='Attendent_Label_Name' value='<%=Attendent_Label_Name%>'><!--ML-MMOH-CRF-406-->
		</form>
	</body>
</html>


