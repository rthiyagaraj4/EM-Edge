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
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%--This JSP is call when a user clicks on Create Button from Autoclave / Washing Unit Menu--%>
<%@ page contentType="text/html;charset=UTF-8" import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale		=	(String)session.getAttribute("LOCALE");
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/AutoclaveWashingUnit.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled			=		"";
	String disabled				=		"";
	String visibility			=		"visible";//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057 
	
	mode						=		request.getParameter( "mode" ) ;
	bean_id						=		"autoclaveWashingUnitBean" ;
	bean_name					=		"eSS.AutoclaveWashingUnitBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	AutoclaveWashingUnitBean bean = (AutoclaveWashingUnitBean) getBeanObject( bean_id,  bean_name, request );
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.initService_location_code();


	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled			=		"disabled";
		if (request.getParameter( "autoclave_wash_unit_code" ) == null ) {
			return;		
		}
		bean.setAutoclave_wash_unit_code(request.getParameter( "autoclave_wash_unit_code" )) ;
		bean.loadData() ;
		if(bean.getEff_status().equals("D"))
			disabled			=		"disabled" ;
		if(bean.getUnit_type().equals("W")) visibility = "hidden";//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057 
	}
	bean.setLanguageId(locale);
%>
<script language="javascript">
var varUnitType="<%=bean.getUnit_type()%>";
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement();checkSterilizationTypeinQuery()" onMouseDown='CodeArrest();'> 
<form name="formAutoclaveWashingUnit" id="formAutoclaveWashingUnit" onReset="FocusFirstElement();">
 
 <table border="0" cellpadding="0" cellspacing="0" width='100%'  align='center' height='38%'>

  <tr>
	<td width='100%' align='center' class="WHITE">

	   <table border="0" cellpadding="1" cellspacing="0" width='100%' align='center'>
          <tr>
		     <td>&nbsp;</td>
			 <td>&nbsp;</td>
             <td>&nbsp;</td>
			 <td>&nbsp;</td>
	      </tr>
          <tr>
		   	 <td class="label"><fmt:message key="eSS.UnitType.label" bundle="${ss_labels}"/></td>
		     <td class=label>&nbsp;&nbsp;&nbsp;&nbsp;<select name="unit_type" id="unit_type" <%=codeDisabled%> onChange="checkSterilizationType(this);">
			    <%=bean.getUnit_type_List()%>
		       </select>
			 </td>
             <td class="label"><fmt:message key="eSS.SterilizationType.label" bundle="${ss_labels}"/></td>
		     <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<select name="sterile_type" id="sterile_type" <%=disabled%> <%=codeDisabled%>><%=bean.getSterile_type_List()%>
		        </select><span id='span1' style="visibility:visible"><%=bean.getMandatoryImageTag()%></span>
			 </td>
			</tr>
          <tr>
		  <td colspan='4' ></td>
		  </tr>
          <tr>
		    <td colspan='4' ></td>
		  </tr>
		  <tr>
		  <td colspan='4' ></td>
		  </tr>
		  <tr>          
		     <td colspan='4' class='WHITE'></td>
	      </tr>
		  <tr>          
		     <td colspan='4' class='WHITE'></td>
	      </tr>
		  <tr>
		  <td colspan='4' ></td>
		  </tr>
          <tr>
		  <td colspan='4' ></td>
		  </tr>
		  <tr>
		  <td colspan='4' ></td>
		  </tr>
		  <tr>
               <td  class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		        <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getAutoclave_wash_unit_code()%>" name="autoclave_wash_unit_code" size='8' maxLength='8'  class="UPPER" onKeyPress="return CheckForSpecChars(event);" <%=codeDisabled%> onBlur="checkSpecialChars(this);"><%=bean.getMandatoryImageTag()%>
			   </td>
			   <td  class="label"><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
		       <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<select name="service_location_code" id="service_location_code" <%=disabled%>>
			   <%=bean.getService_location_code_List()%>
		       </select><%=bean.getMandatoryImageTag()%>
			   </td>
		   </tr>
		   <tr>
		     <td>&nbsp;</td>
			 <td>&nbsp;</td>
             <td>&nbsp;</td>
			 <td>&nbsp;</td>
	      </tr>
		   <tr>
		       <td  class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		       <td class="label" colspan="3" >&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getLong_desc()%>" name="long_desc" size='40' maxLength='40' onBlur="makeValidString(this);" <%=disabled%>><%=bean.getMandatoryImageTag()%>
			   </td>
			</tr>
			<tr>
		     <td>&nbsp;</td>
			 <td>&nbsp;</td>
             <td>&nbsp;</td>
			 <td>&nbsp;</td>
	        </tr>
            <tr>
		        
				<td  class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		        <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" value="<%=bean.getShort_desc()%>" name="short_desc" size='15' maxLength='15' onBlur="makeValidString(this);" onBlur="checkSpecialChars(this);"  <%=disabled%>><%=bean.getMandatoryImageTag()%>
			    </td>
				<td class="label"><fmt:message key="eSS.Temperature.label" bundle="${ss_labels}"/></td>
		        <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' value="<%=bean.getTemperature()%>" name="temperature" maxLength='15' size='15' <%=disabled%> onkeypress="return isValidNumber(this,event,7,2);" onblur="checkDoubleFormat(this, false);" >
			    </td>

		   </tr>
		   <tr>
		     <td>&nbsp;</td>
			 <td>&nbsp;</td>
             <td>&nbsp;</td>
			 <td>&nbsp;</td>
	      </tr>
           <tr>
		        <td  class="label"><fmt:message key="eSS.UnitCondition.label" bundle="${ss_labels}"/></td>
		        <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<select name="unit_status" id="unit_status" <%=disabled%>>
			    <%=bean.getUnit_status_List()%>
		        </select>
				</td>
				<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		        <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" value="E" name="eff_status" id="eff_status" <%=bean.getChecked(bean.getEff_status())%>>
				</td>
		   </tr>
		   <tr>
		     <td>&nbsp;</td>
			 <td>&nbsp;</td>
             <td>&nbsp;</td>
			 <td>&nbsp;</td>
	      </tr>
		  <!-- Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312 -->
		  <tr id="id_b_indi_pass" style="visibility: <%=visibility%>;" >
		      <td class="label"><fmt:message key="eSS.BiologicalIndicator.label" bundle="${ss_labels}"/></td>
		      <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<select name="b_indicator_test" id="b_indicator_test" <%=disabled%>>
			  <%=bean.getBIndicator_Test_List()%>
		      </select>
			</td>
			<td  class="label"><fmt:message key="eSS.BMSPassFail.label" bundle="${ss_labels}"/></td>
		    <td class="label">&nbsp;&nbsp;&nbsp;&nbsp;<select name="bms_pass_fail" id="bms_pass_fail" <%=disabled%>>
			  <%=bean.getBMS_PassFail_List()%>
		      </select>
			</td>
		   </tr>
		   <!-- Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312  Added ends-->
        </table> 
     </td>
  </tr>
  

  </tr>
 </table>
    <input type="hidden" name="mode" id="mode"		value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>	
<%
		putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

