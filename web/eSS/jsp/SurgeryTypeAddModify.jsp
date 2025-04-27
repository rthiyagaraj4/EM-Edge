<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<head>
	<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE"); 

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
	<script language="javascript" src="../../eSS/js/SurgeryType.js"></script>
</head>
<body onLoad="FocusFirstElement()" onMouseDown='CodeArrest();'>
<%
		String mode;
		String bean_id;
		String bean_name;
		String disabled = "";
		String surgery_type	=	"";
		String surg_name_disabled = "";
		String surg_desc			=	"";
		String short_desc			=	"";
		String long_desc			=	"";
		String caption				=	"";

		mode	= request.getParameter( "mode" ) ;
		bean_id = "surgeryTypeJBean" ;
		bean_name = "eSS.SurgeryTypeBean";

		if ((mode == null) || (mode.equals(""))) 
			return ;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;

		SurgeryTypeBean bean = (SurgeryTypeBean)getBeanObject( bean_id, bean_name, request ) ; 
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setLanguageId(locale) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));		
		if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
			surgery_type	=	request.getParameter( "surgery_type" ) ;
			if (surgery_type == null ) {
				return;		
			}
			bean.setCode(0,surgery_type) ;
			bean.loadData() ;
			if(bean.getEff_status(0).equals("D"))
				disabled = "disabled" ;
		}
		//Added by sakti against KDAH_CRF_0247
		String surg_nature_link_to_OT_yn = bean.checkForNull((String)((HashMap)bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_SURG_NATURE_LINK_OT_YN_SELECT"),bean.getLoginFacilityId())).get("SURG_NATURE_LINK_OT_YN"));
		if(surg_nature_link_to_OT_yn.equals("N")){
			surg_name_disabled = "disabled";
		}else{
			surg_desc = bean.checkForNull(bean.getSurg_desc(0));
			surg_desc = java.net.URLEncoder.encode(surg_desc,"UTF-8");
			if(bean.checkForNull(bean.getNature_type(0)).equals("EL")){
				caption				=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Elective.label","ss_labels");
			}else if(bean.checkForNull(bean.getNature_type(0)).equals("EM")){
				caption 			=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSS.Emergency.label","ss_labels");
			}
		}

		long_desc = bean.checkForNull(bean.getLong_desc(0));
		long_desc = java.net.URLEncoder.encode(long_desc,"UTF-8");

		short_desc = bean.checkForNull(bean.getShort_desc(0));
		short_desc = java.net.URLEncoder.encode(short_desc,"UTF-8");

		
	
%>

<form name="formSurgeryType" id="formSurgeryType" >
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
	<td width='100%' align='center' class="WHITE">
		<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td align="left">&nbsp;<input type="text" name="code_0" id="code_0" value="<%= bean.getCode(0) %>" size="8" maxlength="8" disabled>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td align="left">&nbsp;<input type="text" name="long_desc_0" id="long_desc_0" value="" size="42" maxlength="40" <%= disabled %> onBlur="makeValidString(this);">
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td align="left">&nbsp;<input type="text" name="short_desc_0" id="short_desc_0" value="" size="20" maxlength="15" <%= disabled %> onBlur="makeValidString(this);">
			<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<!-- Added By Sakti against KDAH-CRF-0247 -->
		<tr>	
					
			<td align="right" class="label"><fmt:message key="eSS.SurgeryName.label" bundle="${ss_labels}"/></td>
			<td align="left">&nbsp;<input type="text" readonly name="surg_name_0" id="surg_name_0" value="" size="20" maxlength="15" <%= surg_name_disabled %> onBlur="makeValidString(this);" onkeydown="return isNumberKey(event);">
			<input type='button' class='BUTTON' value='?'  onClick="callNatureTypeSearchWindow(surgery_type_search_0, surg_name_0,nature_type);"  name="surgery_name_search0" id="surgery_name_search0" <%= surg_name_disabled %> <%= disabled %>>
			<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			<input type="hidden" name="surgery_type_search_0" id="surgery_type_search_0" value="<%= bean.checkForNull(bean.getSurg_name(0)) %>">
			<input type="hidden" name="temp_surg_name_0" id="temp_surg_name_0" value="<%= surg_desc %>">
			<input type="hidden" name="temp_short_desc_0" id="temp_short_desc_0" value="<%= short_desc %>">
			<input type="hidden" name="temp_long_desc_0" id="temp_long_desc_0" value="<%= long_desc %>"></td> </td> 
		</tr>
				
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
		<td class="label" align="right"><fmt:message key="eSS.NatureType.label" bundle="${ss_labels}"/></td>
		<td align="left">&nbsp;<input type="text"  name="nature_type" id="nature_type" value="<%=caption %>" size="10" maxlength="10" readonly onkeydown="return isNumberKey(event);">
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		
		<tr>
			<td class="label" align="right"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td align="left">&nbsp;<input type="checkBox" name="eff_status_0" id="eff_status_0" value="E" <%=(bean.getEff_status(0)).equals("E")?"checked":"" %> onkeydown="return isNumberKey(event);">
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<%
			if((bean.getEff_status(0)).equals("E")) {
		%>
			<script language="javascript">
					document.formSurgeryType.long_desc_0.focus() ;
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
				}
		%>
		</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="surg_nature_link_to_OT_yn" id="surg_nature_link_to_OT_yn" value="<%=surg_nature_link_to_OT_yn%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="">
</form>
</body>
<% putObjectInBean(bean_id,bean,request);%>
</html>
 <script>
Setsurgdesc(document.formSurgeryType.temp_surg_name_0,document.formSurgeryType.temp_short_desc_0,document.formSurgeryType.temp_long_desc_0);
</script>

