<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

12/11/2014				AAKH_CRF_0057			Sakti Sankar		52312											Autoclaving function, option to select
																													Biological indicator , BMS Pass / Fail 
																													Both in Master as wel as Transaction function.
06/03/2015				IN054240				Ramesh Goli		IN054240											Default value not displayed in transaction																													
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<meta name="Generator" content="EditPlus @ Isoft Health(P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Suri K.">

		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/Autoclaving.js"></script>
		<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<jsp:useBean id="bean" scope="page" class="eSS.AutoclavingBean"/>	
	

<%


	String mode;
	String bean_id;
	String bean_name;
	String autoclave_wash_unit_code;
	String load_no;
	String codeDisabled						=		"";
	String disabled							=		"";
	String disabled_load_status				=		"";
	//Added by suresh.r on 09-12-2014 against AAKH_CRF_0057 beg
	String vis_BIndicat						=		"hidden";
	String vis_BMSPass						=		"hidden";
	//Added by suresh.r on 09-12-2014 against AAKH_CRF_0057 end
//	String docNoDisabled					=		"";
	
	String dis_rof							=		"";
	mode									=	request.getParameter( "mode" ) ;
	if(mode.equals("2")) dis_rof			=	"disabled";

	bean_id = "autoclavingBean" ;
	bean_name = "eSS.AutoclavingBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	//	AutoclavingBean bean					=	(AutoclavingBean) getBeanObject( bean_id,  bean_name, request );

	bean.clear() ;	
	bean.setLanguageId(locale);
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setLoginById((String)session.getAttribute("login_user")) ;
	bean.setFunctionId(request.getParameter("function_id"));
	bean.setMode(mode) ;
	bean.setSession(session) ;
	bean.initSsParameter();
	bean.initAutoclaving_date();
	bean.initStore_code();
	bean.setAdded_by_id(bean.getLoginById());
	
	
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled						=	"disabled";
		autoclave_wash_unit_code=request.getParameter("autoclave_wash_unit_code");
		load_no=request.getParameter("load_no");
		if (( autoclave_wash_unit_code== null )||( load_no== null )) {
			return;		
		}
		bean.setLoad_no(load_no) ;
		bean.setAutoclave_wash_unit_code(autoclave_wash_unit_code) ;

		bean.loadData() ;
		if(bean.getEntry_completed_yn().equals("Y")) disabled="disabled";
		//Added by suresh.r on 09-12-2014 against AAKH_CRF_0057 beg
		//IN054240 Start.
		//if(bean.chkBioindAndBMSNotApp(autoclave_wash_unit_code,"1")) 	vis_BIndicat="visible";
		//if(bean.chkBioindAndBMSNotApp(autoclave_wash_unit_code,"2"))	vis_BMSPass="visible";
		
		if(!"X".equals(bean.getBIndicatorTestDone_yn())){
			vis_BIndicat="visible";
		}
		if(!"X".equals(bean.getBMSPassFail_yn())){
			vis_BMSPass="visible";
		}
		//IN054240 End.
		//Added by suresh.r on 09-12-2014 against AAKH_CRF_0057 end
	}
	//docNoDisabled=bean.isDocNoAutoGenYN(bean.getDoc_type_code())?"disabled":docNoDisabled;
	if(disabled.equals("disabled"))
		disabled_load_status				=	"";
	else if(disabled.equals(""))
		disabled_load_status				=	"disabled";


	//To get Entered By User Name from User ID
			/*String strEnterdByName="";
			String strEnterdById=bean.getAdded_by_id();
			String strLocale=(String) session.getValue( "LOCALE" ) ;
			Connection con=ConnectionManager.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rset=null;
			rset = stmt.executeQuery("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = '"+strLocale+"' and APPL_USER_ID='"+strEnterdById+"'") ;
			
			if(rset !=null)	{
				if(rset.next()) {
					strEnterdByName = rset.getString("APPL_USER_NAME");
				}
			}*/
			ArrayList alParam	=	new ArrayList();
			alParam.add(locale);
			alParam.add(bean.getAdded_by_id());
			String strEnterdByName = (String)((HashMap)bean.fetchRecord("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? AND APPL_USER_ID=?",alParam)).get("APPL_USER_NAME");

%>
	<body onload="FocusFirstElement();" onMouseDown='CodeArrest();'>
		<form name="formAutoclavingHeader" id="formAutoclavingHeader" onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="eSS.AutoclaveUnit.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="autoclave_wash_unit_code" id="autoclave_wash_unit_code" <%=codeDisabled%> onchange='PopulateOtherDetails(this)'>
						<%=bean.getAutoclave_wash_unit_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td class="label"><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getSterileTypeDesc()%>"  name="service_location" maxLength="12" size="12" <%=disabled%> readOnly>
					<%=bean.getMandatoryImageTag()%> </td>
					<td class="label"><fmt:message key="eSS.SterilizationType.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getServiceLocation()%>" name="sterilization_type" maxLength="12" size="12" <%=disabled%> readOnly>
					 </td>
  			    </tr>

				<tr>
                    <td  class="label"><fmt:message key="eSS.LoadNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" class="NUMBER" value="<%=bean.getLoad_no()%>" name="load_no" maxLength="12" size="12" onKeyPress="return isValidInteger();" <%=codeDisabled%> readonly></td>
					<td  class="label"><fmt:message key="eSS.Temperature.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text"  value="<%=bean.getTemperature()%>" name="temperature" maxLength="15" size="15"  <%=disabled%>      ></td>
					<td  class="label"><fmt:message key="eSS.AutoclaveDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getAutoclave_date(),"DMY","en",locale)%>" name="autoclave_date"  maxLength="10" size="10" disabled    
					onBlur="checkAutoClavingDate(this,sysdate);"
					 >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('autoclave_date');" disabled></img>
					<%=bean.getMandatoryImageTag()%></td> 
					

				</tr>
				<tr>
					
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="store_code" id="store_code" <%=codeDisabled%>><%=bean.getStore_code_List()%></select><%=bean.getMandatoryImageTag()%></td>
					<td class="label"><fmt:message key="eSS.LoadStatus.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="load_status" id="load_status" <%=disabled%>  ><%=bean.getLoad_status_List()%></select><%=bean.getMandatoryImageTag()%></td>
					<td class="label"><fmt:message key="eSS.OldLoadNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getOld_load_no()%>" name="old_load_no"  maxLength="12" size="12"  readonly></td>

				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.EnteredBy.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="hidden" value="<%=bean.getAdded_by_id()%>" name="added_by_id" maxLength="10" size="10" disabled>
					<input type="text" value="<%=strEnterdByName%>" name="added_by_name" maxLength="10" size="10" disabled>
					</td>
					<!-- Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312 -->
					<td class="label"><fmt:message key="eSS.RoomTemperature.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getRoom_temp()%>" name="room_temp"  maxLength="15" size="15" <%=disabled%>></td>
					<td class="label"><fmt:message key="eSS.RelativeHumidity.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=bean.getRelativeHumidity()%>" name="relative_humidity"  maxLength="15" size="15" <%=disabled%>></td>
					<!-- Added ends -->
			</tr>
			<tr>
					<td class="label"><fmt:message key="eSS.EntryCompleted.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="checkbox" value="Y" name="entry_completed_yn" id="entry_completed_yn" <%=disabled%> <%=bean.getChecked(bean.getEntry_completed_yn())%>></td>
					
					<!-- Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312 -->
					<td class="label"><label id="id_b_indicator_label" style="visibility: <%=vis_BIndicat%>;"><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></label></td>
					<td class="label">&nbsp;&nbsp;<label id="id_b_indicator" style="visibility: <%=vis_BIndicat%>;"><select name="b_indicator_test_done_yn" id="b_indicator_test_done_yn" <%=disabled%>><%=bean.getBIndicator_List()%></select></label></td>
					<td class="label"><label id="id_bms_pass_fail_label" style="visibility: <%=vis_BMSPass%>;"><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></label></td>
					<td class="label">&nbsp;&nbsp;<label id="id_bms_pass_fail" style="visibility: <%=vis_BMSPass%>;"><select name="bms_pass_fail" id="bms_pass_fail" <%=disabled%>><%=bean.getBMS_PassFail_List()%></select></label></td>
					<!-- Added ends -->
					
					
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><input type=button class=button name=ROF value='Get Ster Req Details' <%=dis_rof%> onclick='PopulateROF()'></td>
			</tr>
			
			</table>
			<input type="hidden" name="records_to_delete" id="records_to_delete"		 value="">
			<input type="hidden" name="locale" id="locale"					 value="<%=locale%>">
			<input type="hidden" name="sterile_type" id="sterile_type"             value="">
			<input type="hidden" name="finalized" id="finalized"				 value="N">
			<input type="hidden" name="mode" id="mode"					 value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"					 value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				 value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				 value="<%= bean.getFunctionId() %>">
			<input type='hidden' name="sysdate" id="sysdate"					value="<%=bean.getSSParameter().get("SYS_DATE").toString()%>">
			<%
	try{
		/* Commented by Sakti  since we have finalize in function level AAKH_SCF_158
			ArrayList alParameters = new ArrayList();
			alParameters.add(request.getParameter("module_id"));
		//	alParameters.add(request.getParameter("menu_id"));
			alParameters.add(request.getParameter("function_id"));
			alParameters.add(session.getAttribute("responsibility_id"));
			ArrayList alRequestGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SM_MENU_TRANS_SUB_FUNCTION_SELECT"),alParameters);
			for (int i=0;i<alRequestGroupRecords.size();i++){
				HashMap hmRequestGroupSubFunc=(HashMap)alRequestGroupRecords.get(i);
					hidden filed is removed SS_AUTOCLAVING_FINALIZE from here
			}
			*/
		}
		catch (Exception exception) {
			out.println(exception);
			exception.printStackTrace();
		}
%>
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>

</html>

