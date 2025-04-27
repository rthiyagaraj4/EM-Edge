<!DOCTYPE html>
<!-- Added by Rajesh 28-8-12-->
<%@page import="java.io.File"%>
<!-- Added by Rajesh 28-8-12-->
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
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
<!--Added Against ML-MMOH-CRF-0670-US001 -->
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/>
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/> 
<!--Added Against ML-MMOH-CRF-0670-US001 -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/DietType.js'></script>
<script language='javascript' src='../../eDS/js/DSCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<!-- Modified by Rajesh 28-8-12-->
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- Modified by Rajesh 28-8-12-->
<% String diet_type = "";
   String long_desc = "";
   String short_desc = "";
   String age_group = "";
   String diet_category = "";
   String default_feed = "";
   String default_diet = "";
   String diet_cycle = "";
   String order_catlog = "";
   String enabled_yn = "";
   String dietTypeCode = request.getParameter("dietType");
   String disabled_flag = "";
   String readOnlyFlag = "";
   
   String ipdiettype_yn = ""; //ML-MMOH-CRF-0820
   String dcdiettype_yn = ""; //ML-MMOH-CRF-0820

   String opdiettype_yn = ""; //ML-MMOH-CRF-0418
   String emdiettype_yn = ""; //ML-MMOH-CRF-0418
   String applstafforder_yn = "";//ML-MMOH-CRF-0419-US8 
   String attdntorderappl_yn ="";//ML-MMOH-CRF-0670-US001

   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;

   String sql_ageGroup = "select age_group_code code,short_desc sdesc from am_age_group_lang_vw where language_id = '"+locale+"' and eff_status = 'E' order by sdesc";
   String sql_feedType = "select feed_type type,short_desc sdesc from ds_feed_type_lang_vw where language_id = '"+locale+"' and eff_status = 'E' order by sdesc";
   String sql_dietCategory = "select diet_category_code code,description description from ds_diet_category_lang_vw where language_id = '"+locale+"' order by description";
   String sql_getDiet 	= 	"select diet_type,long_desc,short_desc,age_group_code,"+
							"diet_category_code,default_feed_type,default_yn,diet_cycle_type,order_catalog_code,"+
   							"ip_diet_type_yn,dc_diet_type_yn,op_diet_type_yn,em_diet_type_yn,APPL_STAFF_ORDER_YN,APPL_ATT_YN,eff_status from DS_DIET_TYPE where diet_type = '"+dietTypeCode+"'";//ML-MMOH-CRF-0418 & CRF-0419 & CRF-0670
							
							
   String mode = request.getParameter("mode");
   if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(sql_getDiet);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			diet_type = rst.getString("diet_type");
	   			long_desc = rst.getString("long_desc");
	   			short_desc = rst.getString("short_desc");
	   			age_group = rst.getString("age_group_code");
	   			diet_category = rst.getString("diet_category_code");
	   			default_feed = rst.getString("default_feed_type");
	   			default_diet = rst.getString("default_yn");
	   			diet_cycle = rst.getString("diet_cycle_type");
	   			order_catlog = rst.getString("order_catalog_code");
				ipdiettype_yn = rst.getString("ip_diet_type_yn");//ML-MMOH-CRF-0820
				dcdiettype_yn = rst.getString("dc_diet_type_yn");//ML-MMOH-CRF-0820
	   			opdiettype_yn = rst.getString("op_diet_type_yn");//ML-MMOH-CRF-0418
	   			emdiettype_yn=rst.getString("em_diet_type_yn");//ML-MMOH-CRF-0418
				applstafforder_yn=rst.getString("APPL_STAFF_ORDER_YN");//CRF-0419
				attdntorderappl_yn =rst.getString("APPL_ATT_YN");//ML-MMOH-CRF-0670-US001
				enabled_yn = rst.getString("eff_status");
				
	   		}
   		}
   		catch(Exception e){
			e.printStackTrace();
	   		System.err.println("Error in diet Type->"+e);
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				e.printStackTrace();
				System.err.println("Exception in Diet Create:"+e);
			}
   		}
   }
%>
		<br>
		<form name="diet_form" id="diet_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.DietTypeServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="dietType" id="dietType" value="<%=diet_type %>" onkeypress="restrictSpecialChars(event)" size="25" maxlength="20" onblur="setFieldToUpperCase(this);" onkeypress="return checkAlpha(event)" <%=readOnlyFlag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="longDesc" id="longDesc" value="<%=long_desc %>"  onkeypress="restrictSpecialChars(event)" size="60" maxlength="60" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="shortDesc" id="shortDesc" value="<%=short_desc %>" onkeypress="restrictSpecialChars(event)" size="45" maxlength="45" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(sql_ageGroup);
						rst = pstmt.executeQuery();
				%>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.AgeGroup.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="ageGroup" id="ageGroup">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {
								if(rst.getString("code").equals(age_group)){%>
									<option value="<%=rst.getString("code")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("code")%>">
								<%} %>
							<%=rst.getString("sdesc") %>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.DefaultDietType.Label" bundle="${ot_labels}"/>
					</td>
					<td>
					<%if("Y".equals(default_diet)){ %>
						<input type="checkbox" name="defaultDiet" id="defaultDiet" checked="checked"/>
					<%}
					else{ %>
						<input type="checkbox" name="defaultDiet" id="defaultDiet" />
					<%} %>

					</td>
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.DefaultFeedType.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="defaultFeed" id="defaultFeed">
						<%	pstmt = con.prepareStatement(sql_feedType);
							rst = pstmt.executeQuery(); %>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {
								if(rst.getString("type").equals(default_feed)){%>
									<option value="<%=rst.getString("type")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("type")%>">
								<%} %>
							<%=rst.getString("sdesc") %>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.DietCycleType.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="dietCycle" id="dietCycle">
							<option value="R">
								Repeat
							</option>
							<%if("O".equals(diet_cycle)){ %>
								<option value="O" selected="selected">
							<%}
							else{%>
								<option value="O">
							<%} %>
								One Time
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.OrderCatalogcode.Label" bundle="${ot_labels}"/>
					</td>
					<td class='fields'>
						<input type="text" name="orderCatalogDescription" id="orderCatalogDescription" value="<%=order_catlog%>" size="60" onblur="if(this.value!='')getLookup(orderCatalogDescription);" <%=disabled_flag %>/>
						<input type="button" class='BUTTON' name="lookUp" id="lookUp" value="?" onClick="getLookup(orderCatalogDescription);" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="dietCategory" id="dietCategory" <%=disabled_flag %>>
						<%	pstmt = con.prepareStatement(sql_dietCategory);
							rst = pstmt.executeQuery(); %>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {
								if(rst.getString("code").equals(diet_category)){%>
									<option value="<%=rst.getString("code")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("code")%>">
								<%} %>
							<%=rst.getString("description") %>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<%}

				catch(Exception e){
					e.printStackTrace();
					System.err.println("Exception in Diet Create:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						e.printStackTrace();
						System.err.println("Exception in Diet Create:"+e);
					}
				}
				%>

				<!-- ML-MMOH-CRF-0820 STARTS -->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.IPDietType.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(ipdiettype_yn)){ %>
								<input type="checkbox" name="ipdiettype_yn" id="ipdiettype_yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="ipdiettype_yn" id="ipdiettype_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="ipdiettype_yn" id="ipdiettype_yn" checked="checked" />
						<%} %>
					</td>
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.DCDietType.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(dcdiettype_yn)){ %>
								<input type="checkbox" name="dcdiettype_yn" id="dcdiettype_yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="dcdiettype_yn" id="dcdiettype_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="dcdiettype_yn" id="dcdiettype_yn" checked="checked" />
						<%} %>
					</td>
				</tr>
				<!-- ML-MMOH-CRF-0820 ENDS -->
				
				<!-- ML-MMOH-CRF-0418 STARTS -->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.OPDietType.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(opdiettype_yn)){ %>
								<input type="checkbox" name="opdiettype_yn" id="opdiettype_yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="opdiettype_yn" id="opdiettype_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="opdiettype_yn" id="opdiettype_yn" checked="checked" />
						<%} %>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.EMDietType.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(emdiettype_yn)){ %>
								<input type="checkbox" name="emdiettype_yn" id="emdiettype_yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="emdiettype_yn" id="emdiettype_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="emdiettype_yn" id="emdiettype_yn" checked="checked" />
						<%} %>
					</td>
				</tr>
				<!-- ML-MMOH-CRF-0418 ENDS-->
				
				<!-- ML-MMOH-CRF-0419-US8 Starts-->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eDS.ApplForStaffOrder.Label" bundle="${ds_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(applstafforder_yn)){ %>
								<input type="checkbox" name="applstafforder_yn" id="applstafforder_yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="applstafforder_yn" id="applstafforder_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="applstafforder_yn" id="applstafforder_yn" checked="checked" />
						<%} %>
					</td>
				</tr>
				<!-- ML-MMOH-CRF-0419-US8 Ends -->
				<!-- ML-MMOH-CRF-0670-US001 Starts Here-->
				<tr>
					<td align="right" class='label'>
					<fmt:message key="eDS.ApplicableFor.Label" bundle="${ds_labels}"/>
					<option><%=DSCommonBeanObj.getAttendantLabel()%></option>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("Y".equals(attdntorderappl_yn)){
							%>
								<input type="checkbox" name="attdntorderappl_yn" id="attdntorderappl_yn"  checked="checked"/>
							<%}
							else{
							%>
								<input type="checkbox" name="attdntorderappl_yn" id="attdntorderappl_yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="attdntorderappl_yn" id="attdntorderappl_yn"  checked="checked"/>
						<%} %>
					</td>
				</tr>
				<!-- ML-MMOH-CRF-0670-US001 Ends Here-->
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("E".equals(enabled_yn)){ %>
								<input type="checkbox" name="enable" id="enable"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="enable" id="enable"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="enable" id="enable"  checked="checked"/>
						<%} %>
					</td>
				</tr>
				<tr>
			</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
		</form>
	</body>
</html>


