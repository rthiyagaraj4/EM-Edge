<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
		request.setCharacterEncoding("UTF-8"); 
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//endss
		String locale = (String) session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/SlidingScaleTmpl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown="lockKey()"  onKeyDown = 'lockKey()' >
<%
	String patient_id		= request.getParameter("patient_id") ;
	String encounter_id		= request.getParameter("encounter_id") ;
	String drug_code			= request.getParameter("drug_code") ;
	String srl_no			= request.getParameter("srl_no") ;
	String drugCode			= request.getParameter("drug_code") ;
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	String extdrugCode		=	"";
	String srlNo			=	"";
	String form_code	   =	"";
	String route_code	   = "";
	String mode = request.getParameter("mode")==null?"":(String)request.getParameter("mode");
	ArrayList slidingScaleTmpl = new ArrayList();
	HashMap drugDetails    =null;
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	ArrayList presDetails	= (ArrayList) bean.getpresDetails();

	String template_id_selected = "";
		if(presDetails!=null && presDetails.size()>0){		
			for(int i=0;i<presDetails.size();i++){
				drugDetails		= (HashMap)presDetails.get(i);
				if(((String)drugDetails.get("DRUG_CODE")).equals(drugCode) && ((String)drugDetails.get("SRL_NO")).equals(srl_no)){
					extdrugCode		= (String)drugDetails.get("DRUG_CODE");
					srlNo			= (String)drugDetails.get("SRL_NO");
					template_id_selected	= drugDetails.get("TEMPLATE_ID")==null?"":(String)drugDetails.get("TEMPLATE_ID");
					if(extdrugCode.equals(drug_code) && srlNo.equals(srl_no) ){
						form_code	   = (String)drugDetails.get("FORM_CODE");
						route_code	   = (String)drugDetails.get("ROUTE_CODE");
					}
				}
			}
		}

	String called_from_amend = request.getParameter("called_from_amend")==null?"":request.getParameter("called_from_amend");
	
	slidingScaleTmpl = bean.getSlidingScaleTmpl(drug_code);
	

	bean.setPredefinedRemarks(route_code,form_code);
	HashMap predefined_remarks = bean.getPredefinedRemarks();
		
%>
<form name="prescription_sliding_scale_remarks" id="prescription_sliding_scale_remarks" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">		
<%
	if((slidingScaleTmpl != null && slidingScaleTmpl.size() > 0)){
%>
	<tr>
		<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<th ><fmt:message key="ePH.SlidingScaleTemplate.label" bundle="${ph_labels}"/></td>
	</tr>
<%
	}
	else if(predefined_remarks.size()>0){
%>
	<tr>
		<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<th ><fmt:message key="ePH.PredefinedRemarksforSlidingScalePrescription.label" bundle="${ph_labels}"/></td>
	</tr>
<%
	}
	Set keyset = predefined_remarks.keySet() ;
	Iterator keyiterator= keyset.iterator() ;		
	String key  = "";
	String desc = "";
	int index   = 1;
	String classvalue = "";
if(!(slidingScaleTmpl != null && slidingScaleTmpl.size() > 0)){
	if(drugDetails.get("SLIDING_SCALE_REMARKS") != null && drugDetails.get("SLIDING_SCALE_REMARKS_CODES") != null){
		StringTokenizer rem = new StringTokenizer((String)drugDetails.get("SLIDING_SCALE_REMARKS"),"..");
		StringTokenizer rem_code = new StringTokenizer((String)drugDetails.get("SLIDING_SCALE_REMARKS_CODES"),"||");
		while(rem_code.hasMoreTokens()){
			key   = (String)rem_code.nextToken();
			desc  = (String)rem.nextToken();
			if ( index % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
%>	
		<tr>
			<td  class="<%=classvalue%>">
				<input type="checkbox" name="chk_select_<%=index%>" id="chk_select_<%=index%>" value="E" checked>
			</td>
			<td class="<%=classvalue%>">
				<input type="text"   name="txt_remarks_<%=index%>" id="txt_remarks_<%=index%>"      value="<%=desc%>" size="40">
				<input type="hidden" name="txt_remarks_code_<%=index%>" id="txt_remarks_code_<%=index%>" value="<%=key%>" >
			</td>
		</tr>
<%
		index++;
		}

	}else{
		while(keyiterator.hasNext()){
			key   = (String)keyiterator.next();
			desc  = (String)predefined_remarks.get(key);
			if ( index % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
%>	
		<tr>
			<td  class="<%=classvalue%>">
				<input type="checkbox" name="chk_select_<%=index%>" id="chk_select_<%=index%>" value="E" checked>
			</td>
			<td class="<%=classvalue%>">
				<input type="text"   name="txt_remarks_<%=index%>" id="txt_remarks_<%=index%>"      value="<%=desc%>" size="40">
				<input type="hidden" name="txt_remarks_code_<%=index%>" id="txt_remarks_code_<%=index%>" value="<%=key%>" >
			</td>
		</tr>
	<%
		index++;
		}
	}
}
%>
</table>
<table  cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<%

	String rangeUomCodeSelected = "";
	String adminUnitsUomCodeSelected = "";
	String chk = "";

	if(slidingScaleTmpl != null && slidingScaleTmpl.size() > 0){
		HashMap template = new HashMap();
		for(int i=0; i<slidingScaleTmpl.size(); i++){
			template = (HashMap)(slidingScaleTmpl.get(i));
			
			if(template_id_selected != ""){
				if(template_id_selected.equals((String)template.get("TEMPLATE_ID"))){
					chk = "checked";
					rangeUomCodeSelected = (String)template.get("RANGE_UOM_CODE");
					adminUnitsUomCodeSelected= (String)template.get("ADMIN_UNITS_UOM_CODE");
				}
				else
					chk = "";
			}
			else{
				if(i==0){
					chk = "checked";
					template_id_selected = (String)(((HashMap)slidingScaleTmpl.get(0)).get("TEMPLATE_ID"));
					rangeUomCodeSelected = (String)(((HashMap)slidingScaleTmpl.get(0)).get("RANGE_UOM_CODE"));
					adminUnitsUomCodeSelected= (String)(((HashMap)slidingScaleTmpl.get(0)).get("ADMIN_UNITS_UOM_CODE"));
				}
				else{
					chk="";
				}
			}

		%>
			<tr>
				<td class="<%=classvalue%>">
					<INPUT TYPE="radio" name="tmpl" id="tmpl" <%=chk%> onClick="loadTemplateDetailChange('<%=(String)template.get("TEMPLATE_ID")%>','<%=(String)template.get("RANGE_UOM_CODE")%>','<%=(String)template.get("ADMIN_UNITS_UOM_CODE")%>','<%=i%>','<%=mode%>');">
				</td>
				<td class="<%=classvalue%>">&nbsp;<%=(String)template.get("TEMPLATE_DESC")%>
					<input type="hidden" name="template_desc<%=i%>" id="template_desc<%=i%>" size="40" value = <%=(String)template.get("TEMPLATE_DESC")%>>
				</td>
			</tr>
			
		
		<input type="hidden" name="template_id<%=i%>" id="template_id<%=i%>" value=<%=(String)template.get("TEMPLATE_ID")%>>
		<input type="hidden" name="rangeUom<%=i%>" id="rangeUom<%=i%>" value=<%=(String)template.get("RANGE_UOM_CODE")%>>
		<input type="hidden" name="adminUom<%=i%>" id="adminUom<%=i%>" value=<%=(String)template.get("ADMIN_UNITS_UOM_CODE")%>>
		<%

		}
		
		

	}

	%>
</table>
		<input type="hidden" name="currTemplate_id" id="currTemplate_id" value=0>
	<input type="hidden" name="no_of_remarks" id="no_of_remarks" value="<%=index%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
	<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>"><!-- Added for ARYU-SCF-0053 -->
	
<script>
<% 

	//if(template_id_selected != ""){
%>		
		loadTemplateDetail('<%=template_id_selected%>','<%=rangeUomCodeSelected%>','<%=adminUnitsUomCodeSelected%>','','<%=mode%>');
<%
	//}
%>
</script>
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

