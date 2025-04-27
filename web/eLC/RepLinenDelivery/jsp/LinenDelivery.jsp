<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.vo.UserPreferences"%>
<%@ page import="com.iba.framework.cache.pojo.business.Cache"%>
<%@ page import="com.iba.framework.cache.pojo.business.CacheManager"%>
<%@ page import="com.iba.framework.core.util.IBADate"%>
<%@ page import="com.iba.framework.core.util.IBADateTime"%>
<%@ page import="com.iba.framework.core.util.IBADateValidation"%>
<%@ page import="com.iba.ehis.lc.core.util.LcDateFormat"%>
<%@ include file="/framework/html/Tag.text"%>
<html>
<head>
	<%
		
		String functionId=(String)session.getAttribute("functionId");
		String moduleId=(String)session.getAttribute("moduleId");
		String facilityId=(String)session.getAttribute("facility_id");
		String language_Id = (String)session.getAttribute("LOCALE");
		
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		
		
								
		UserPreferences userPrefs =new UserPreferences();
		userPrefs.setDateFormat("dd/MM/yyyy") ;
		userPrefs.setTimeFormat("HH:mm");
		userPrefs.setLocale(language_Id);
		try{
		/* Cache cache = CacheManager.getCache();
	
		cache.putObject(Constants.USER_SESSION_CACHE, request.getSession().getId(),  Constants.USER_PREFS,userPrefs); */	//Commented Against AMRI-SCF-0679
	
		}catch(Exception ex){
			out.println("EXCEPTION IN PUTTING OBJECTS INTO CACHE");
			}

			String datepattrn=userPrefs.getDateFormat();
			String locale=userPrefs.getLocale();
					
			IBADateTime date = new IBADateTime(request.getSession().getId());
			IBADateTime fromDate=LcDateFormat.getSevendaysBackDate(request);
			
			IBADateValidation ibaDateValidation = new IBADateValidation();
			String cdate = ibaDateValidation.convertDateJS(date.toString(),"en",locale,datepattrn);
			String conFromDate=ibaDateValidation.convertDateJS(fromDate.toString(),"en",locale,datepattrn);
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
		<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
		<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
		<Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
		<Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>  
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
		<Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/RepLinenDelivery/js/LinenDelivery.js"></Script>     
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<IBATagLibs:initCalendar /> 			
</head>
	<body onmouseover="converDates();" onblur="converDates();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<br>
		<ibaHTML:form action="/RepLinenDeliveryAction.do" target="messageFrame" method="GET">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>
						</td>
							<td align="left" class="label">
								<ibaBean:message key="com.iba.ehis.lc.From" bundle="lcLabels" />
								</td>
								<td align="left" class="label">
							<ibaBean:message key="com.iba.ehis.lc.To" bundle="lcLabels" />
						</td>
					</tr>	
				<tr>
					<td align="right" class="label">
						<ibaBean:message key="com.iba.ehis.lc.reqestdate" bundle="lcLabels" />
							</td>
								<td>
									<ibaHTML:IBACalendarInput property="vo.dateFrom" value="<%=conFromDate%>" format="dd/MM/yyyy" size="18" maxlength="18" />
										<img src='framework/images/mandatory.gif' />
									</td>			
								<td>
							<ibaHTML:IBACalendarInput property="vo.dateTo" value="<%=cdate%>"  format="dd/MM/yyyy"  size="18" maxlength="18"/> 
						</td>
					</tr>
				<tr>
					<td align="right" class="label">
						<ibaBean:message key="com.iba.ehis.lc.deliverydate" bundle="lcLabels" />
							</td>
								<td>
									<ibaHTML:IBACalendarInput property="vo.from" size="18" format="dd/MM/yyyy" maxlength="18"/>
										</td>	
											<td>
												<ibaHTML:IBACalendarInput property="vo.to" size="18"  format="dd/MM/yyyy" maxlength="18"/> 
											</td>
										</tr>
									<tr>
								<td align="right" class="label">
							<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
						</td>
					<td>
						<ibaHTML:text property="vo.linenItem" size="30" maxlength="30" onblur="showLookup('linenItem');"/>
							<input type='hidden' name="linenItemHidden" id="linenItemHidden" value=''/>
								<input type='button' class='button' value='?' onClick="showLookup('linenItem');" />
									</td>
										<td>
									</td>
								</tr>
							<tr>
						<td align="right" class="label">
							<ibaBean:message key="com.iba.ehis.lc.source" bundle="lcLabels" />
								</td>
									<td>			
										<ibaHTML:select property="vo.sourceType" onchange="clearSource();">
										<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" /></ibaHTML:option>
										<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" /></ibaHTML:option>			
										<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" /></ibaHTML:option>			
										</ibaHTML:select>			
									</td>
								<td>
								<ibaHTML:text property="vo.sourceCode" size="30" maxlength="30" onblur="showLookup('sourceCode');"/>
							<input type='hidden' name="sourceCodeHidden" id="sourceCodeHidden" value=''/>
						<input type='button' class='button' value='?' onClick="showLookup('sourceCode');" />
					</td>
				</tr>
				<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
		
				<ibaHTML:hidden property="method"/>
				<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>"/>
				<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>"/>
	
				<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
	
				<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
				<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
				
				<input type="hidden" name="p_module_id" id="p_module_id" value="LC">
				<input type="hidden" name="module_id" id="module_id" value="LC">
	
				<input type="hidden" name="p_report_id" id="p_report_id" value="LCRLNDLY">
				<input type="hidden" name="report_id" id="report_id" value="LCRLNDLY"/>
		
				<input type='hidden' name='locale' id='locale' value='<%=language_Id%>'>
				<input type='hidden' name='p_language_id' id='p_language_id' value='<%=language_Id%>'>
				<input type='hidden' name='facility_Id' id='facility_Id' value='<%=facilityId%>'>
				<input type='hidden' name='dateFormate' id='dateFormate' value='<%=datepattrn%>'>
									
				<input type='hidden' name='P_REQUEST_DATE_FROM' id='P_REQUEST_DATE_FROM' value=''>
				<input type='hidden' name='P_REQUEST_DATE_TO' id='P_REQUEST_DATE_TO' value=''>
				<input type='hidden' name='P_Delivery_Date_From' id='P_Delivery_Date_From' value=''>
				<input type='hidden' name='P_Delivery_Date_To' id='P_Delivery_Date_To' value=''>
				<input type='hidden' name='P_Linen_Item' id='P_Linen_Item' value=''>
				<input type='hidden' name='P_Source_Type' id='P_Source_Type' value=''>
				<input type='hidden' name='P_Source_Code' id='P_Source_Code' value=''>
				<input type='hidden' name='conFromDate' id='conFromDate' value=''>
				<input type='hidden' name='conToDate' id='conToDate' value=''>
				<input type='hidden' name='conFrom' id='conFrom' value=''>
				<input type='hidden' name='conTo' id='conTo' value=''>
		</ibaHTML:form>
	</body>
</html>

