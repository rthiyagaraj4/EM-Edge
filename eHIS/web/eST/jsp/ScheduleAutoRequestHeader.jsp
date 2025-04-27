<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page import ="eST.ScheduleAutoRequestBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		String sStyle			 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eST/js/ScheduleAutoRequest.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
        function_id						=		"<%= request.getParameter("function_id") %>"
		menu_id							=		"<%= request.getParameter("menu_id") %>"
		module_id						=		"<%= request.getParameter("module_id") %>"
	</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale						=		 (String)session.getAttribute("LOCALE");
	String mode							=		request.getParameter("mode");
	mode								=		mode.trim();

	String default_value				=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	

	
	if ((mode == null) || (mode.equals(""))) 
		return;
		
	String sch_code = "";
	String readOnly = "";
	String disabled  = "";
	java.util.HashMap defaultParameter	 =		 null;
	String bean_id						 =		"scheduleAutoRequestBean";
	String bean_name					 =		"eST.ScheduleAutoRequestBean";
	ScheduleAutoRequestBean bean		 =		(ScheduleAutoRequestBean) getBeanObject( bean_id, bean_name,request);  
	defaultParameter					 =		bean.getDefaultStParameter();
	String default_doc_type_code		 =		"";
	String sys_date						 =		"";
	String eff_status_ch				 =		"";
	String eff_status_val				 =		"";
	String auto_authorised_ch			 =		"";
	String auto_authorised_val			 =		"";
	if (!mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))){
		readOnly = "readonly";
		disabled = "disabled";
		sch_code = bean.checkForNull((String)request.getParameter("schdule_code"));
		bean.loadData(sch_code);
		sys_date=com.ehis.util.DateUtils.convertDate(bean.getStarting_from(),"DMY","en",locale);
		if(bean.getEff_status().equals("E")){
			eff_status_ch="checked";
			eff_status_val="Y";
		}else{
			eff_status_ch="";
			eff_status_val="N";
		}
		if(bean.getAuto_authorised().equals("Y")){
			auto_authorised_ch="checked";
			auto_authorised_val="Y";
		}else{
			auto_authorised_ch="";
			auto_authorised_val="N";
		}
	}else{
		bean.clear();
		bean.initialize();
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.setLanguageId(locale);
		default_doc_type_code		 =		(String)defaultParameter.get("DEF_ISS_DOC_TYPE_CODE");
		sys_date=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
		bean.setDefaultDocType(default_doc_type_code);
		eff_status_ch="checked";
		eff_status_val="Y";
		auto_authorised_ch="";
		auto_authorised_val="N";
	}


%>
<body onLoad='defaultFirstElement();'>
	<form name="schduleAutoRequestForm" id="schduleAutoRequestForm" >
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  class="label" nowrap><fmt:message key="eST.ScheduleCode.label" bundle="${st_labels}"/>
		
		<%if(!mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))){%>
		<td  class='fields'>
		<input type="text"  name="schedule_code" id="schedule_code" value="<%=sch_code%>" maxlength="10" size="12"  class="UPPER" <%=readOnly%>>	&nbsp;<img  src="../../eCommon/images/mandatory.gif" ><input type="text"  name="schedule_desc" id="schedule_desc" value="<%=bean.getSchedule_desc()%>" size="35" <%=readOnly%> maxlength=60 >&nbsp;	<img  src="../../eCommon/images/mandatory.gif" ></td>
		<%}else{%>
		<td  class='fields'>
		<input type="text"  name="schedule_code" id="schedule_code" value="<%=sch_code%>" maxlength="10" size="12" onBlur="checkDuplicateCode(this);convertToUpperCase(this);checkSpecialChars(this)" onKeyPress="return CheckForSpecChars(event);" class="UPPER" <%=readOnly%>>	&nbsp;
		<img  src="../../eCommon/images/mandatory.gif" ><input type="text"  name="schedule_desc" id="schedule_desc" value="<%=bean.getSchedule_desc()%>" size="35" <%=readOnly%> maxlength=60 >&nbsp;	<img  src="../../eCommon/images/mandatory.gif" ></td>
	<%	}%>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class="fields">
		<select name="doc_type_code" id="doc_type_code" <%=disabled%>><%=bean.getDocTypes()%></select>&nbsp;<img  src="../../eCommon/images/mandatory.gif" ></td>
		 </tr>
		 <tr>
				<td class=label ><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
		<td  class='fields'><select name="requisition_by_store" id="requisition_by_store" onBlur="checkCanAuthorize(this);"> 
		<%=bean.getStores()%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" >
		</td>
		<td class=label ><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/>
		</td><td class='fields'>

		<%if (mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))){%>
		<select name="requisition_on_store" id="requisition_on_store" onBlur="populateItemClass(requisition_by_store,this);" ><%=default_value%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" >
		<%}else{%>
		<select name="requisition_on_store" id="requisition_on_store" <%=disabled%>>	<%=bean.getOnStoresQuery()%> </select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" >
		<%}%>

		
	 </tr>
	  <tr>
	
		<td class=label ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		<td class='fields' align="left" ><input type="text" class="NUMBER" maxLength=10 size=10 name="frequency" id="frequency" value="<%=bean.getFrequency()%>" onkeypress="return CheckForSpecialChars(event);" onBlur="checkIntegerFormat(this,'0');" >&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" ></td>
		</td>
		<td class=label ><fmt:message key="eST.StartingFrom.label" bundle="${st_labels}"/>&nbsp;
		<td class='fields' > <input type="text" maxLength=10 size=10 name="starting_from" id="starting_from" value="<%=sys_date%>" onBlur="checkSysdate(this,sysdate);">&nbsp;&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('starting_from');"></img>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" ></td>
		
		</tr>
	  <tr>
	  <td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
	  <%if (mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))){%>
		<td  ><select name="item_class_code" id="item_class_code"><%=default_value%></select></td>
		<%}else{%>
		<td  ><select name="item_class_code" id="item_class_code"><%=bean.getItemClassesQuery()%></select></td>
		<%}%>
	  <td  class="label"><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></td>
		<td  class='fields'><select name="consignment" id="consignment" >
		<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value="Y"><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></option>
		<option value="N"><fmt:message key="eST.NonConsignment.label" bundle="${st_labels}"/></option>
		</select></td>
	  	
		</tr>
	
	<tr>
		<td class='LABEL' nowrap ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>1</td>
		<td class='fields'><select name='item_analysis_1' id='item_analysis_1'  accesskey='1' ><%=bean.getItemAnalysis()%> </select>
		<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>2
		&nbsp;&nbsp;<select name='item_analysis_2' id='item_analysis_2'  accesskey='2' ><%=bean.getItemAnalysis()%> </select></td>
		<td class='LABEL'  ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>3</td>
		<td class='fields'><select name='item_analysis_3' id='item_analysis_3'  accesskey='3' ><%=bean.getItemAnalysis()%> </select></td>
	</tr>
	<tr>
		<td class='LABEL'  nowrap ><fmt:message key="eST.AutoAuthorised.label" bundle="${st_labels}"/></td>
		<td class='fields'><input type="checkbox" name='auto_authorised' id='auto_authorised' onclick="assignValue(this);" value='<%=auto_authorised_val%>' <%=auto_authorised_ch%> > </td>
		<td class=label align=right><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td><input type="checkBox" name="eff_status" id="eff_status" value='<%=eff_status_val%>'  onclick="assignValue(this);" <%=eff_status_ch%> ></td>
	</tr>
	  </table>
	 

		<input type='hidden'	name="authorize_yn" id="authorize_yn"			value="No">
		<input type='hidden'	name="mode" id="mode"					value="<%=mode%>">
		<input type="hidden"	name="bean_id" id="bean_id"				value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"			value="<%= bean_name %>">
		<input type="hidden"	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
		<input type='hidden'	name="sysdate" id="sysdate"				value="<%=sys_date%>">
		<input type="hidden"	name="locale" id="locale"				value="<%=locale%>">

		
		
			
	</form>
	<%putObjectInBean(bean_id,bean,request);%>
	</body>
</html>

