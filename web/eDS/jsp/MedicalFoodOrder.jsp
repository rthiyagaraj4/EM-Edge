<!DOCTYPE html>
<!-- Newly Created against ML-MMOH-CRF-0598 -->
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList,java.util.*,eCommon.Common.CommonBean,webbeans.eCommon.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>

<%
	String locale = (String)session.getAttribute("LOCALE");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
	.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
	:"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";			
%>
	<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<Script Language="JavaScript" src="../../eDS/js/MedicalFoodOrder.js"></Script>
	<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
	<script language='javascript' src='../../eDS/js/LabelStickerForFormula.js'></script>

<script language='javascript'>
function clearSource(){
	var frmObj=document.forms[0];
	frmObj.wardClinic_code.value='';
	frmObj.wardDesc.value='';
	frmObj.changed_wardClinic.value='';
}

function changeSourceType(){
	clearSource();
	patient_type_code=document.forms[0].patient_type_code.value;
	var isDSNotifications=document.forms[0].isDSNotifications.value; //Added Against ML-MMOH-CRF-1291[IN068947]
	var isDSMealFoodOrder=document.forms[0].isDSMealFoodOrder.value; // Added Against ML-MMOH-CRF-1572
	var val=document.getElementById("Patient_Class").value;
	var patient_type_code1=patient_type_code.split("$$");
	if(val==""){
		document.getElementById("wardClinic").value="";
		document.getElementById("wardClinicDesc").value =""; 
		document.getElementById("wardClinic").disabled=true;
		//Added Against Start ML-MMOH-CRF-1291[IN068947]
		if(isDSNotifications=="true" || isDSMealFoodOrder=="true"){		// Added isDSMealFoodOrder Against ML-MMOH-CRF-1572
			document.forms[0].wardClinic_code.disabled=true;		
			document.forms[0].quest6.disabled=true;	
		}
		//Added Against End ML-MMOH-CRF-1291[IN068947]
	}

	if(val=='DC'||val=='IP'){
		document.getElementById("wardClinic").value="W";
		document.getElementById("wardClinicDesc").value=getLabel("Common.nursingUnit.label","Common");
		document.getElementById("wardClinic").disabled=true;	
		//Added Against Start ML-MMOH-CRF-1291[IN068947]
		if(isDSNotifications=="true" || isDSMealFoodOrder=="true"){	 // Added isDSMealFoodOrder Against ML-MMOH-CRF-1572		
			document.forms[0].wardClinic_code.disabled=false;		
			document.forms[0].quest6.disabled=false;		
		}
		//Added Against End ML-MMOH-CRF-1291[IN068947]
	}

	if(val=='EM'||val=='OP'){
		document.getElementById("wardClinic").value="C";
		document.getElementById("wardClinicDesc").value=getLabel("Common.clinic.label","Common");
		document.getElementById("wardClinic").disabled=true;
		//Added Against Start ML-MMOH-CRF-1291[IN068947]
		if(isDSNotifications=="true" || isDSMealFoodOrder=="true"){	 // Added isDSMealFoodOrder Against ML-MMOH-CRF-1572
			document.forms[0].wardClinic_code.disabled=false;		
			document.forms[0].quest6.disabled=false;					
		}
		//Added Against End ML-MMOH-CRF-1291[IN068947]
	}
		document.getElementById("changed_wardClinic").value=document.getElementById("wardClinic").value;
		document.getElementById("changed_wardClinicDesc").value=document.getElementById("wardClinicDesc").value;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;	
	String sql="";
	String servingDate="";
	String patient_id_length="";
	String strReferalWardClinic="",wardClinicDesc="",strRefWardClinicCode="",strReferalDesc="",patient_type_code="";
	boolean isDSNotifications =false;
	boolean isDSMealFoodOrder =false;	// Added Against ML-MMOH-CRF-1572
	boolean InstructionInLabelFormulaAppl = false;	//Added by Santhosh for ML-MMOH-CRF-1961
	try{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi') CURRENT_DATE FROM DUAL"); //Added  hh24:mi by Santhosh for ML-MMOH-CRF-1961
		rst = pstmt.executeQuery();
		while(rst.next()){
			servingDate = rst.getString("CURRENT_DATE");
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		String SystemDate_display = DateUtils.convertDate(servingDate,"DMYHM" ,"en",localeName);
		
		sql ="select patient_id_length from MP_PARAM where MODULE_ID='MP'";
		pstmt = conn.prepareStatement(sql);

		rst = pstmt.executeQuery();
		while(rst.next()){
			patient_id_length = rst.getString("patient_id_length");
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		//Added Against Start ML-MMOH-CRF-1291[IN068947]		
		isDSNotifications = CommonBean.isSiteSpecific(conn,"DS","DS_NOTIFICATIONS");
		//Added Against End ML-MMOH-CRF-1291[IN068947]
		isDSMealFoodOrder = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_COMPLAINTS"); // Added Against ML-MMOH-CRF-1572
		
		//Added by Santhosh for ML-MMOH-CRF-1961
		InstructionInLabelFormulaAppl = CommonBean.isSiteSpecific(conn, "DS","LABEL_STICKER_FORMULA");
%>
<body onload="enable_disable(this)">
<form name="MedicalFoodOrderReport" id="MedicalFoodOrderReport" target="messageFrame" method="POST" >
	<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
	<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>

	<tr>
		<td>
		</td>
		<td  class="label">
			<fmt:message key="Common.from.label" bundle="${common_labels}" />
		</td>
		<td  class="label">
			<fmt:message key="Common.to.label" bundle="${common_labels}" />
		</td>
	</tr>
	
	<tr>
		<td  class="label">
			<fmt:message key="eDS.OrderDate.Label" bundle="${ds_labels}" />
		</td>
		<td  class="label">
			<input type="text" name="fromDate" id="fromDate" id='fromDate' maxlength="19" size="18" value="<%=SystemDate_display%>" onkeypress="return checkForSpecCharsforID(event);"   onblur="isValidDateTime(this);">
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('fromDate',null,'hh:mm','modal');">
			<img src='../../eCommon/images/mandatory.gif' />
		</td>
		<td  class="label">
			<input type="text" name="toDate" id="toDate" id='toDate'maxlength="19" size="18" value="<%=SystemDate_display%>" onkeypress="return checkForSpecCharsforID(event);"  onblur="isValidDateTime(this);">
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('toDate',null,'hh:mm','modal');">
			<img src='../../eCommon/images/mandatory.gif' />
		</td>
	</tr>
	
	
	<%if(InstructionInLabelFormulaAppl){%><!-- Added by Santhosh for ML-MMOH-CRF-1961 -->
<tr>
		<td  class="label">
			<fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/>
		</td>
		<td  class="label">
			<select name="OrderStatusFrom" id="OrderStatusFrom" id="OrderStatusFrom" onChange=''>
				<option value="ALL" selected><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>	
				<option value="03"><fmt:message key="eOR.Pending.label" bundle="${or_labels}"/>&nbsp;<fmt:message key="eOR.Authorization.label" bundle="${or_labels}"/></option>				
				<option value="10"><fmt:message key="Common.Ordered.label" bundle="${common_labels}" /></option>
				<option value="25"><fmt:message key="eOR.Registered.label" bundle="${or_labels}"/></option>
				<!--<option value="60"><fmt:message key="eOR.ResultComplete.label" bundle="${or_labels}"/></option>-->
				<option value="85"><fmt:message key="eOR.ResultComplete.label" bundle="${or_labels}"/></option><!--ML-MMOH-SCF-2457-->
				<option value="93"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
				<option value="99"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
			</select>
		</td>
	</tr>
	<%} else if(isDSNotifications || isDSMealFoodOrder ){ // Added isDSMealFoodOrder Against ML-MMOH-CRF-1572 %><!-- Added Against Start ML-MMOH-CRF-1291[IN068947] -->
	<tr>
		<td  class="label">
			<fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/>
		</td>
		<td  class="label">
			<select name="OrderStatusFrom" id="OrderStatusFrom" id="OrderStatusFrom" onChange=''>				
				<option value="03"><fmt:message key="eOR.Pending.label" bundle="${or_labels}"/>&nbsp;<fmt:message key="eOR.Authorization.label" bundle="${or_labels}"/></option>				
				<option value="10" selected><fmt:message key="Common.Ordered.label" bundle="${common_labels}" /></option>
				<option value="25"><fmt:message key="eOR.Registered.label" bundle="${or_labels}"/></option>
				<!--<option value="60"><fmt:message key="eOR.ResultComplete.label" bundle="${or_labels}"/></option>-->
				<option value="85"><fmt:message key="eOR.ResultComplete.label" bundle="${or_labels}"/></option><!--ML-MMOH-SCF-2457-->
				<option value="93"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
				<option value="99"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
			</select>
		<td  class="label">
			<select name="OrderStatusTo" id="OrderStatusTo" id="OrderStatusTo" onChange=''>				
				<option value="03"><fmt:message key="eOR.Pending.label" bundle="${or_labels}"/>&nbsp;<fmt:message key="eOR.Authorization.label" bundle="${or_labels}"/></option>				
				<option value="10" selected><fmt:message key="Common.Ordered.label" bundle="${common_labels}" /></option>
				<option value="25"><fmt:message key="eOR.Registered.label" bundle="${or_labels}"/></option>
				<!--<option value="60"><fmt:message key="eOR.ResultComplete.label" bundle="${or_labels}"/></option>-->
				<option value="85"><fmt:message key="eOR.ResultComplete.label" bundle="${or_labels}"/></option><!--ML-MMOH-SCF-2457-->
				<option value="93"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
				<option value="99"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		</td>
	</tr>
	<%}%><!-- END -->
	<!-- Added Against End ML-MMOH-CRF-1291[IN068947] -->
	
	<tr>	 
		<td  class="label" >
			<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
		</td>
		<td class='label'>
			<select name="Patient_Class" id="Patient_Class" id="Patient_Class" onChange='changeSourceType();'>
			<% if(InstructionInLabelFormulaAppl){ //Added by Santhosh for ML-MMOH-CRF-1961	%>
			<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}" /> </option>	
			<%} else if(isDSNotifications || isDSMealFoodOrder ){ // Added isDSMealFoodOrder Against ML-MMOH-CRF-1572	%>
			<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}" /> </option>	
			<%}else{%>
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /> </option>	
			<%}%>
			<!-- Modified Against ML-MMOH-CRF-1291[IN068947] -->
					
				<%			
					LinkedHashMap<String,String>  PatientClassMap  =DSCommonBeanObj.getPatientClass(locale);	
					Iterator it = PatientClassMap.entrySet().iterator();
					while (it.hasNext())
					{
						Map.Entry patientclassEntry = (Map.Entry)it.next();			
					if(!patientclassEntry.getKey().toString().equalsIgnoreCase("XT"))
					{
						patient_type_code=patient_type_code+patientclassEntry.getKey()+"$$";	
					%>
						<option value="<%=patientclassEntry.getKey()%>">
							<%=patientclassEntry.getValue() %>
						</option>
					<%}
				}				
				%>								
			</select>
			</select>
			<%if(!isDSNotifications || isDSMealFoodOrder){ // Added isDSMealFoodOrder Against ML-MMOH-CRF-1572 %> 
			<img src='../../eCommon/images/mandatory.gif' /> <%}%>
		</td>
	</tr>

	<tr>
		<td  class='label'>
			<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
		</td>
		<td  class='label'>
			<input type="text" name="patientId" id="patientId" maxlength='<%=patient_id_length%>' onkeypress="restrictSpecialChars(event);return CheckForSpecChars(event);"  size="12"/>
		</td>
	</tr>

	<tr>
		<td  class="label">
			<fmt:message key="eDS.WardClinic.Label" bundle="${ds_labels}"/>
		</td>

		<td  class='label'>
			<input type='hidden' name='wardClinic' id='wardClinic'  DB_VALUE='<%=strReferalWardClinic%>' value='<%=strReferalWardClinic%>'  >
			<input type='text' name='wardClinicDesc' id='wardClinicDesc' size='10'  value="<%=wardClinicDesc%>" disabled>
	        <!-- ML-MMOH-CRF-0752.7-US001 -->
			<input type='text' name='wardClinic_code' id='wardClinic_code' size='36' value='<%=strReferalDesc%>' onBlur="if(this.value!='') searchWardClinicSelect(wardClinic_code);else callclear();">
			<input type='button' class='button' name='quest6' id='quest6' value='?' onClick="searchWardClinicSelect(wardClinic_code)">
			<div id='more_img' style='position:absolute;visibility:hidden;'>
			<img src='../../eCommon/images/mandatory.gif'></img>
			</div>
		</td>
	</tr>

	<%
		}
		  catch(Exception e)	  {e.printStackTrace();}
		   finally
		   {
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null) rst.close();
					ConnectionManager.returnConnection(conn);
				}
				catch(Exception e){
					System.err.println("Exception in MedicalFoodOrder:"+e);
				}
		   }
	%>
	<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
	</table>		
		
	<INPUT TYPE="hidden" name="module_id" id="module_id" VALUE="DS">
	<input type="hidden" name="p_module_id" id="p_module_id" value="DS"/>
	
	<input type="hidden" name="report_id" id="report_id" value="DSMFDORLST"/>
	<input type="hidden" name="p_report_id" id="p_report_id" value="DSMFDORLST"/>			
	
	<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
	
	<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
	
	<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>"/>
	<input type='hidden' name='datepattrn' id='datepattrn' value="dd/MM/yyyy"/>
	<input type='hidden' name='InstructionInLabelFormulaAppl' id='InstructionInLabelFormulaAppl' value='<%=InstructionInLabelFormulaAppl%>'>

	<input type='hidden' name='changed_wardClinic' id='changed_wardClinic'  value='<%=strReferalWardClinic%>'  >
	<input type='hidden' name='changed_wardClinicDesc' id='changed_wardClinicDesc'  value=''  >
	<input type='hidden' name='wardDesc' id='wardDesc' value='<%=strRefWardClinicCode%>'>
	<input type='hidden' name='HLongRefWdId' id='HLongRefWdId' value="">
	<input type='hidden' name='patient_type_code' id='patient_type_code' value='<%=patient_type_code%>' >											
	<input type='hidden' name='isDSNotifications' id='isDSNotifications' value='<%=isDSNotifications%>' >											
	<input type='hidden' name='isDSMealFoodOrder' id='isDSMealFoodOrder' value='<%=isDSMealFoodOrder%>' >	<!--Added Against ML-MMOH-CRF-1572-->									
	</form>
	</body>
</html>

