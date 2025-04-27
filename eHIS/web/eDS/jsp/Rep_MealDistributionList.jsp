<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.Common.CommonBean ,webbeans.eCommon.ConnectionManager,java.util.ArrayList ,eCommon.Common.*,webbeans.eCommon.*,eOT.*,eOT.Common.*,eOT.Common.OTRepository,java.net.URLDecoder" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
	<%
		String locale = (String)session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
        boolean isMealType = false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;

		conn=ConnectionManager.getConnection(request);
		String facility_id  = (String) session.getValue("facility_id");
		String sql="";
		String strCode ="";
		String strDesc ="";
		// modified by N Munisekhar on 20-May-2013 against [IN039994]
		String servingDate="";
             	pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				//End of [IN039994]
	%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript" ></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eDS/js/Rep_MealDistributionList.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>

<body onload="getSysDate();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onmouseover="">
<br>
	<form name="MealDistributionListForm" id="MealDistributionListForm" action="" target="messageFrame" method="GET">
		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			<tr>
				<td  class="label">
					<fmt:message key="Common.date.label" bundle="${common_labels}"/>
				</td>
				<!--commented by N Munisekhar on 20-May-2013 against [IN039994]
				<td>
					<input type="text" name="date" id="date" size="10" maxlength="10" value="" onblur="isValidDate(this);"><a onclick="return showCal('date', '%d/%m/%Y', false, true,'date');" name='dateButton' id='dateButton'><img src="../../framework/images/img.gif"></a><input type='hidden' name='datePattern' id='datePattern' value='dd/MM/yyyy'>
					<img src='../../eCommon/images/mandatory.gif' />
					</td>-->
					<!--added by N Munisekhar on 20-May-2013 against [IN039994]-->
						<td>
					<input type="text" name="date" id="date" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'><img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('date');">
					<img src='../../eCommon/images/mandatory.gif' />
					</td>
				
			</tr>

			<tr>
				<td  class="label">
					<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}" />
						</td>
							<td>
								<select name="kitchen" id="kitchen">
									<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
									<%
										try
											{
												sql ="select  KITCHEN_CODE,SHORT_DESC  from DS_KITCHENS_LANG_VW  where language_id ='"+locale+"' and operating_facility_id ='"+facility_id+"' and(EFF_STATUS='E' ) order by  2 , 1";
												pstmt=conn.prepareStatement(sql);
												rst = pstmt.executeQuery();
												while(rst.next()){
												strCode = rst.getString(1);
												strDesc =  rst.getString(2);
									%>
									<option value="<%=strCode%>"><%=strDesc%></option>
												<%}
											}
								  			catch(Exception ex) {
												System.out.println("Meal Order Report"+ex);
										  	}
								    		finally {
												if(rst != null) rst.close();
											    if(pstmt != null) pstmt.close();
								    		}
											%>
								</select>
								<img src='../../eCommon/images/mandatory.gif' />
						</td>
					</tr>
				<%
					//Added Against ML-MMOH-CRF-1965...starts
					isMealType = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_TYPE_DISTRIBUTION");
					System.err.println("isMealType --->"+isMealType);
					//Added Against ML-MMOH-CRF-1965...ends
				
				
				    if(isMealType){
				%>
				<tr>
				  <td  class="label">
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
				  </td>
				  <td>
				    <select name="mealType" id="mealType"><option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
				<%
					try
					{
						String mealTypeCode = "";
						String mealTypeDesc =  "";
						//String sql_meal_type ="select meal_type,short_Desc from ds_meal_type_lang_vw where language_Id like '"+locale+"' and eff_Status ='E' order by meal_order ASC";
						String sql_meal_type ="select meal_type,short_Desc from ds_meal_type_lang_vw where language_Id like '"+locale+"' order by meal_order ASC";//59957
						pstmt=conn.prepareStatement(sql_meal_type);
						rst = pstmt.executeQuery();
						while(rst.next()){
						mealTypeCode = rst.getString(1);
						mealTypeDesc =  rst.getString(2);
				%>
					<option value="<%=mealTypeCode%>"><%=mealTypeDesc%></option>
				<%      }
					}
					catch(Exception DCat)
					{
						DCat.printStackTrace();
						System.out.println("MealOrderList==MealType==>"+DCat);
					}
					finally
					{
						if(rst != null) rst.close();
						if(pstmt != null) pstmt.close();
					}
				%>
				    </select>
				  </td>
			    </tr>
				<%
				   }
				%>	
					<tr>
			   			<td/>
						<td align="left" class="label">
							<fmt:message key="Common.from.label" bundle="${common_labels}"/>
						</td>
						<td align="left" class="label">
							<fmt:message key="Common.to.label" bundle="${common_labels}" />
						</td>
					</tr>
					<tr>
						<td  class="label">
								<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}" />
						</td>
						<td align="left">
								<select name="wardCodeFrom" id="wardCodeFrom">
									<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
									<%
										try
											{
												sql ="select NURSING_UNIT_CODE as col_0_0_, SHORT_DESC as col_1_0_ from IP_NURSING_UNIT_LANG_VW where (EFF_STATUS='E' )and(FACILITY_ID like '"+facility_id+"' )and(LANGUAGE_ID like '"+locale+"' ) order by  2 , 1";
												pstmt=conn.prepareStatement(sql);
												rst = pstmt.executeQuery();
												while(rst.next()){
												strCode = rst.getString(1);
												strDesc =  rst.getString(2);
									%>
									<option value="<%=strCode%>"><%=strDesc%></option>
												<%}
											}
								  			catch(Exception ex) {
								  				ex.printStackTrace();
										  	}
								    		finally {
												if(rst != null) rst.close();
											    if(pstmt != null) pstmt.close();
								    		}
											%>
								</select>
						</td>
						<td align="left">
								<select name="wardCodeTo" id="wardCodeTo">
									<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
									<%
										try
											{
												sql ="select NURSING_UNIT_CODE as col_0_0_, SHORT_DESC as col_1_0_ from IP_NURSING_UNIT_LANG_VW where (EFF_STATUS='E' )and(FACILITY_ID like '"+facility_id+"' )and(LANGUAGE_ID like '"+locale+"' ) order by  2 , 1";
												pstmt=conn.prepareStatement(sql);
												rst = pstmt.executeQuery();
												while(rst.next()){
												strCode = rst.getString(1);
												strDesc =  rst.getString(2);
									%>
									<option value="<%=strCode%>"><%=strDesc%></option>
												<%}
											}
								  			catch(Exception ex) {
								  				ex.printStackTrace();
										  	}
								    		finally {
												if(rst != null) rst.close();
											    if(pstmt != null) pstmt.close();
								    		}
											%>
								</select>
						</td>
					</tr>
					<tr>
						<td  class="label">
								<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
						</td>
						<td align="left">
							<select name="dietTypeFrom" id="dietTypeFrom">
								<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
								<%
									try
										{
											sql ="select DIET_TYPE, SHORT_DESC from DS_DIET_TYPE_LANG_VW where (EFF_STATUS='E' )and(LANGUAGE_ID like '"+locale+"' ) order by  2 , 1";
											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>
								<option value="<%=strCode%>"><%=strDesc%></option>
											<%}
										}
							  			catch(Exception ex) {
							  				ex.printStackTrace();
									  	}
							    		finally {
											if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
							    		}
										%>
							</select>
						</td>
						<td align="left">
							<select name="dietTypeTo" id="dietTypeTo">
								<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
								<%
									try
										{
											sql ="select DIET_TYPE, SHORT_DESC from DS_DIET_TYPE_LANG_VW where (EFF_STATUS='E' )and(LANGUAGE_ID like '"+locale+"' ) order by  2 , 1";
											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>
								<option value="<%=strCode%>"><%=strDesc%></option>
											<%}
										}
							  			catch(Exception ex) {
							  				ex.printStackTrace();
									  	}
							    		finally {
											if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
							    		}
										%>
							</select>
						</td>
					</tr>
					<tr>
						<td  class="label">
								<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" />
						</td>
						<td align="left">
						<select name="mealClassFrom" id="mealClassFrom">
								<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
								<%
									try
										{
											sql ="select MEAL_CLASS, SHORT_DESC from DS_MEAL_CLASS_LANG_VW where (LANGUAGE_ID='"+locale+"' )and(EFF_STATUS='E' ) order by  2 , 1";
											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>
								<option value="<%=strCode%>"><%=strDesc%></option>
											<%}
										}
							  			catch(Exception ex) {
							  				ex.printStackTrace();
									  	}
							    		finally {
											if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
							    		}
										%>
							</select>
						</td>
						 <td align="left">
							<select name="mealClassTo" id="mealClassTo">
								<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
								<%
									try
										{
											sql ="select MEAL_CLASS, SHORT_DESC from DS_MEAL_CLASS_LANG_VW where (LANGUAGE_ID='"+locale+"' )and(EFF_STATUS='E' ) order by  2 , 1";
											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>
								<option value="<%=strCode%>"><%=strDesc%></option>
											<%}
										}
							  			catch(Exception ex) {
							  				ex.printStackTrace();
									  	}
							    		finally {
											if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
							    		}
										%>
							</select>
						</td>
					</tr>
					<tr>
						<td  class="label">
								<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}" />
						</td>
						 <td align="left">
							<select name="itemTypeFrom" id="itemTypeFrom">
								<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
								<%
									try
										{
											sql ="select ITEM_TYPE, SHORT_DESC from DS_ITEM_TYPE_LANG_VW where (LANGUAGE_ID='"+locale+"' )and(EFF_STATUS='E' ) order by  2 , 1";
											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>
								<option value="<%=strCode%>"><%=strDesc%></option>
											<%}
										}
							  			catch(Exception ex) {
							  				ex.printStackTrace();
									  	}
							    		finally {
											if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
							    		}
										%>
							</select>
						</td>
						<td align="left">
							<select name="itemTypeTo" id="itemTypeTo">
								<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
								<%
									try
										{
											sql ="select ITEM_TYPE, SHORT_DESC from DS_ITEM_TYPE_LANG_VW where (LANGUAGE_ID='"+locale+"' )and(EFF_STATUS='E' ) order by  2 , 1";
											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>
								<option value="<%=strCode%>"><%=strDesc%></option>
											<%}
										}
							  			catch(Exception ex) {
							  				ex.printStackTrace();
									  	}
							    		finally {
											try{
												if(pstmt!=null) pstmt.close();
												if(rst!=null) rst.close();
												ConnectionManager.returnConnection(conn);
											}
											catch(Exception e){
												System.err.println("Exception in Meal Distribution List:"+e);
											}							    			
							    		}
										%>
							</select>
						</td>
					</tr>
					<tr>
						<td class="label">
								<fmt:message key="eOT.Item.Label" bundle="${ot_labels}" />
						</td>
						<td class='label' align='left'>
							<input type="text" name="itemCodeFrom" id="itemCodeFrom" size="30" maxlength="30" onblur="getItemCode('Item_Code_From'),clearFields();"/>
							<input type='hidden' name="Hid_itemCodeFrom" id="Hid_itemCodeFrom" value=''/>
							<input type='button' class='button' name="But_ItemCodeFrom" id="But_ItemCodeFrom" value='?' onClick="showLookup('Item_Code_From');" />
						</td>
						<td class='label' align='left'>
							<input type="text" name="itemCodeTo" id="itemCodeTo" size="30" maxlength="30" onblur="getItemCode('Item_Code_To'),clearFields();" />
							<input type='hidden' name="Hid_itemCodeTo" id="Hid_itemCodeTo" value='' />
							<input type='button' class='button' name="But_ItemCodeTo" id="But_ItemCodeTo" value='?' onClick="showLookup('Item_Code_To');" />
						</td>
					</tr>
					<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
					</table>


					<input type="hidden" name="functionId" id="functionId" value="DSR_MEAL_DISTR_LIST"/>
					<input type="hidden" name="moduleId" id="moduleId" value="DS"/>

					<input type="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
					<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

					<input type="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
					<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>

					<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
					<input type="hidden" name="module_id" id="module_id" value="DS">

					<input type="hidden" name="p_report_id" id="p_report_id" value="DSRMLDST">
					<input type="hidden" name="report_id" id="report_id" value="DSRMLDST">

					<!--input type='hidden' name='p_language_id' value='en'-->

					<input type='hidden' name='P_kitchen_code' id='P_kitchen_code' value=''>
                    <input type='hidden' name='P_meal_type' id='P_meal_type' value=''><!--Added against ML-MMOH-CRF-1965-->
					<input type='hidden' name = 'isMealType' value = "<%=isMealType%>">
					<input type='hidden' name="PARAM1" id="PARAM1" value="">
					<input type='hidden' name='PARAM2' id='PARAM2' value=''>
					<input type='hidden' name='PARAM3' id='PARAM3' value=''>
					<input type='hidden' name='PARAM4' id='PARAM4' value=''>
					<input type='hidden' name='PARAM5' id='PARAM5' value=''>
					<input type='hidden' name='PARAM6' id='PARAM6' value=''>
					<input type='hidden' name='PARAM7' id='PARAM7' value=''>
					<input type='hidden' name='PARAM8' id='PARAM8' value=''>
					<input type='hidden' name='PARAM9' id='PARAM9' value=''>
					<input type='hidden' name='PARAM10' id='PARAM10' value=''>
					<input type='hidden' name='PARAM11' id='PARAM11' value=''>

					<input type="hidden" name="datepattrn" id="datepattrn" value="dd/MM/yyyy"/>
					<input type='hidden' name='locale' id='locale' value='<%=locale%>'>

					<script>getSysDate();</script>
					</form>
				</body>
		</html>


