<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
	<%
		String locale = (String)session.getAttribute("LOCALE");
		String functionId=(String)session.getAttribute("functionId");
		String moduleId=(String)session.getAttribute("moduleId");

		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";		
	%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript" ></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script src="../../eDS/js/Rep_MasterCodeList.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<%
	Connection conn=null;
try{
	conn	= ConnectionManager.getConnection(request);
	//ML-MMOH-CRF-0684
	boolean isMenuType = false;
	isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
	//ML-MMOH-CRF-0684
%>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
  <form name="RepDSMasterCodesForm" id="RepDSMasterCodesForm" target="messageFrame" method="GET">
   		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr>
				<td>&nbsp;
				</td>
				<td>&nbsp;
				</td>
			</tr>
			<tr>
   				<td align="right" class="label">
					<fmt:message key="eOT.MasterCodes.Label" bundle="${ot_labels}" />
				</td>
				
			<td class="label">
				<select property="repName" onchange = "populateFields(this.value);">
				<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}" /></option>
				<option value="DT"><fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /></option>
				<option value="MC"><fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" /></option>
				<option value="MT"><fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" /></option>
				<option value="FT"><fmt:message key="eOT.FeedType.Label" bundle="${ot_labels}" /></option>
				<option value="IT"><fmt:message key="eOT.ItemQty.Label" bundle="${ot_labels}" /></option>
				<option value="Cmpts"><fmt:message key="eOT.Complaints.Label" bundle="${ot_labels}" /></option>
				<option value="DI"><fmt:message key="eOT.deliveryInstruction.Label" bundle="${ot_labels}" /></option>
				<option value="Ingrds"><fmt:message key="eOT.Ingredients.Label" bundle="${ot_labels}" /></option>
				<option value="MCtrgy"><fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}" /></option>
				<option value="KHNS"><fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}" /></option>
				<option value="KA"><fmt:message key="eOT.KitchenArea.Label" bundle="${ot_labels}" /></option>
				<option value="FI"><fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}" /></option>
				<option value="CF"><fmt:message key="eOT.CommercialFormula.Label" bundle="${ot_labels}" /></option>
				<option value="Menu"><fmt:message key="eOT.Menu.Label" bundle="${ot_labels}" /></option>
				<option value="DC"><fmt:message key="eOT.MenuCycle.Label" bundle="${ot_labels}" /></option>
 				<option value="DTT"><fmt:message key="eOT.MenuTimeTable.Label" bundle="${ot_labels}" /></option>
				<option value="WforK"><fmt:message key="eOT.WardsForKitchen.Label" bundle="${ot_labels}" /></option>
				<option value="NRT"><fmt:message key="eOT.Nutrient.Label" bundle="${ot_labels}" /></option>
				<option value="TXT"><fmt:message key="eDS.TextureOfDiet.Label" bundle="${ds_labels}" /></option>
				<!--412-US6-->
				<option value="DRL"><fmt:message key="eDS.DietRequestLocation.Label" bundle="${ds_labels}" /></option>
				<!--412-US6-->
				<!-- ML-MMOH-CRF-684-US3 -->
				<%if(isMenuType){%>
				<option value="MNT"><fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}" /></option>
				<%}%>
				<!-- ML-MMOH-CRF-684-US3 -->
			    </select>
		    </td>
	        </tr>

	<tr>
		<td>&nbsp;
		</td>
		<td>&nbsp;
		</td>
	</tr>
	<tr>
	</tr>
	</table>
	<table id="Tab_CodeList_Fields" border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
	</table>
	<input type="hidden" name="method" id="method"/>
	<input type="hidden" name="functionId" id="functionId" value="<%=functionId%>"/>
	<input type="hidden" name="moduleId" id="moduleId" value="<%=moduleId%>"/>
	<input type="hidden" name="repId" id="repId" value=""/>
	<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
	<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
	<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
	<input type="hidden" name="module_id" id="module_id" value="DS">
	<input type="hidden" name="p_report_id" id="p_report_id" value="">
	<input type="hidden" name="report_id" id="report_id" value=""/>
	<input type="hidden" name="locale" id="locale" value="<%=locale%>"/>
</form>
<%
//ML-MMOH-CRF-0684
		}
		catch(Exception e){
			e.printStackTrace();
			out.println(e);
		}finally{
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
		}
//ML-MMOH-CRF-0684
%>
</body>
</html>

