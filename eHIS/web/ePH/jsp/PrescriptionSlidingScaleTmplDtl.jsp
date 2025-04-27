<!DOCTYPE html>
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
//ends
		String locale = (String) session.getAttribute("LOCALE");  
		String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/SlidingScaleTmpl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown="lockKey()"  onKeyDown = 'lockKey()' >
<%
	String patient_id		= request.getParameter("patient_id") ;
	String encounter_id		= request.getParameter("encounter_id") ;
	String template_id		= "" ;
	String rangeUom = request.getParameter("rangeUom")==null?"":request.getParameter("rangeUom");
	String adminUom = request.getParameter("adminUom")==null?"":request.getParameter("adminUom");
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	String blank ="";
	String template_remark ="";
	String utf8 ="UTF-8";
	int noOfRangeForTmpl = 0;
	ArrayList slidingScaleTmplDtl = new ArrayList();
	
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	
	HashMap drugDetails		= null;
	ArrayList presDetails	= (ArrayList) bean.getpresDetails();
	String drug_code = request.getParameter("drug_code")==null?"":(String)request.getParameter("drug_code");
	String srl_no			= request.getParameter("srl_no")==null?"":request.getParameter("srl_no") ;//Added for ARYU-SCF-0053
%>
<form name="prescription_sliding_scale_remarks_Dtl" id="prescription_sliding_scale_remarks_Dtl" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">		
<%
//if(!called_from_amend.equals("Y")){
if(presDetails!=null && presDetails.size()>0){	

	String drugcode = "";
	String ext_srl_no ="";
	for(int j=0;j<presDetails.size();j++){
		drugDetails		= (HashMap)presDetails.get(j);

		drugcode =  drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
		ext_srl_no   =  (String)drugDetails.get("SRL_NO")==null?"":(String)drugDetails.get("SRL_NO");//Added for ARYU-SCF-0053
		if(drug_code.equals(drugcode) && srl_no.equals(ext_srl_no) ){//srl_no condition added for ARYU-SCF-0053
		if(request.getParameter("template_id") == null || request.getParameter("template_id") == "")
			template_id		= (String)drugDetails.get("TEMPLATE_ID");
		else
			template_id = request.getParameter("template_id");

		if((drugDetails.get("TEMPLATE_ID")==null || drugDetails.get("TEMPLATE_ID")== "") || !((String)drugDetails.get("TEMPLATE_ID")).equals(template_id) ){
			slidingScaleTmplDtl = bean.getSlidingScaleTmplDtl(template_id);
		}
		else{
			slidingScaleTmplDtl	= (ArrayList)drugDetails.get("SLDSCALE_TMPL_DTL");
		}
		if(slidingScaleTmplDtl.size()>0){
			drugDetails.put("RANGEUOM",rangeUom);
			drugDetails.put("ADMINUOM",adminUom);
%>
		<tr>
			<th > <fmt:message key="Common.from.label" bundle="${common_labels}"/> </th>
			<th > <fmt:message key="Common.to.label" bundle="${common_labels}"/> </th>
			<th > <fmt:message key="Common.uom.label" bundle="${common_labels}"/>  </th>
			<th > <fmt:message key="ePH.AdminUnits.label" bundle="${ph_labels}"/> </th>
			<th > <fmt:message key="Common.uom.label" bundle="${common_labels}"/> </th>
			<th > <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </th>
		</tr>
<%
	}

	if(drugDetails.get("TEMPLATE_ID")==null|| drugDetails.get("TEMPLATE_ID")== "" || !((String)drugDetails.get("TEMPLATE_ID")).equals(template_id)){
		int index = 1;
		String classvalue = "";
		String range_to = "0.0";
		String range_from = "0.0";
		String admin_units = "0.0";
		HashMap template = new HashMap();
		noOfRangeForTmpl = slidingScaleTmplDtl.size();
		ArrayList temp = new ArrayList();
		for(int i=0; i<noOfRangeForTmpl; i++){
			if ( index % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
			template = (HashMap)(slidingScaleTmplDtl.get(i));

			range_to = (String)template.get("RANGE_TO")+"";
			if(range_to.equals("0") || range_to.equals("0.0")){
				range_to = "";
			}
			range_from = (String)template.get("RANGE_FROM")+"";
			if(range_from.equals("0") || range_from.equals("0.0")){
				range_from = "";
			}
			admin_units = (String)template.get("ADMIN_UNITS")+"";
			temp.add(template.get("SRL_NO"));
			temp.add(range_from);
			temp.add(range_to);
			temp.add(template.get("ADMIN_UNITS"));
			temp.add((String)template.get("REMARKS")==null?"":(String)template.get("REMARKS"));
			template_remark = (String)template.get("REMARKS");
	%>
			<input type="hidden" name="srl_no<%=i%>" id="srl_no<%=i%>" size=10  value = <%=template.get("SRL_NO")%>>
			<tr>
				<td class="<%=classvalue%>">
					<input type="text" class="NUMBER" onKeyPress="return allowValidNumber(this, event,6,3)"  name="range_from<%=i%>" id="range_from<%=i%>" size=6 value = "<%=range_from%>"  onblur="allowValidNumber(this, event,6,3);checkDoubleFormat(this);">
				</td>
				<td class="<%=classvalue%>">
					<input type="text" class="NUMBER" onKeyPress="return allowValidNumber(this, event,6,3)" name="range_to<%=i%>" id="range_to<%=i%>" size=6  value = "<%=range_to%>" onblur="allowValidNumber(this, event,6,3); checkDoubleFormat(this);ValidateRange(this.name,'<%=i%>',document.prescription_sliding_scale_remarks_Dtl)">
				</td>
				<td class="<%=classvalue%>">
					<input type="text" disabled name="range_uom<%=i%>" id="range_uom<%=i%>" size=10  value = <%=rangeUom%>>
				</td>
				<td>   <!-- Added by rawther for inc -- 28430 -->
					<input type="text" class="NUMBER" onKeyPress="return allowValidNumber(this, event,6,3)" name="admin_units<%=i%>" id="admin_units<%=i%>" size=6  value = <%=admin_units%>  onblur="ValidateAdminUnits(this);" oncopy="return false" onpaste="return false">
				</td>
				<td class="<%=classvalue%>">
					<input type="text" disabled name="admin_uom<%=i%>" id="admin_uom<%=i%>" size=10  value = <%=adminUom%>>
				</td>
				<td class="<%=classvalue%>">
					<input type="text" name="remarks<%=i%>" id="remarks<%=i%>" maxlength='60' size='25'  value = "<%=java.net.URLDecoder.decode(template_remark==null?blank:template_remark,utf8)%>" >
				</td>
			</tr>
<%
		}
	//drugDetails.put("SLDSCALE_TMPL_DTL",temp); //Commented for IN16718 (sl_scale_details will be put to drugDetails on confirm)
%>
		</table>
		
<% 
		}
		else{
		int index = 1;
		int num = 0;
		String classvalue = "";
	//	HashMap template = new HashMap();
		noOfRangeForTmpl = slidingScaleTmplDtl.size();
		String range_to = "0.0";
		String range_from = "0.0";
		String admin_units = "0.0";
		for(int i=0; i<noOfRangeForTmpl; i=i+5){
			if ( index % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
			range_to = (String)slidingScaleTmplDtl.get(i+2)==null? "":(String)slidingScaleTmplDtl.get(i+2) ;
			
			if(range_to.equals("0") || range_to.equals("0.0")){
				range_to = "";
			}
			if(range_to!= null && !(range_to.equals("")))
				range_to =Float.parseFloat(range_to)+"";

			
			range_from = (String)slidingScaleTmplDtl.get(i+1)==null? "":(String)slidingScaleTmplDtl.get(i+1) ;
			if(range_from.equals("0") || range_from.equals("0.0")){
				range_from = "";
			}
			if(range_from!= null && !(range_from.equals("")))
				range_from =Float.parseFloat(range_from)+"";

			admin_units = (String)slidingScaleTmplDtl.get(i+3)==null? "":(String)slidingScaleTmplDtl.get(i+3) ;

			if(admin_units!= null && !(admin_units.equals("")))
				admin_units =Float.parseFloat(admin_units)+"";
	%>
			<input type="hidden" name="srl_no<%=num%>" id="srl_no<%=num%>" size=10  value = <%=slidingScaleTmplDtl.get(i)%>>
			<tr>
				<td class="<%=classvalue%>">
					<input type="text" class="NUMBER" onKeyPress="return allowValidNumber(this,event,6,3);"  name="range_from<%=num%>" id="range_from<%=num%>" size=6 value = "<%=range_from%>" onblur="ValidateRange(this.name,'<%=num%>',document.prescription_sliding_scale_remarks_Dtl)">
				</td>
				<td class="<%=classvalue%>">
					<input type="text" class="NUMBER" onKeyPress="return allowValidNumber(this,event,6,3);" name="range_to<%=num%>" id="range_to<%=num%>" size=6  value = "<%=range_to%>" onblur="ValidateRange(this.name,'<%=num%>',document.prescription_sliding_scale_remarks_Dtl)">
				</td>
				<td class="<%=classvalue%>">
					<input type="text" disabled name="range_uom<%=num%>" id="range_uom<%=num%>" size=10  value = <%=rangeUom%>>
				</td>
				<td>  <!-- Added by rawther for inc -- 28430 -->
					<input type="text" class="NUMBER" onKeyPress="return allowValidNumber(this,event,6,3);" name="admin_units<%=num%>" id="admin_units<%=num%>" size=6  value = "<%=admin_units%>" onblur="ValidateAdminUnits(this);" oncopy="return false" onpaste="return false">
				</td>
				<td class="<%=classvalue%>">
					<input type="text" disabled name="admin_uom<%=num%>" id="admin_uom<%=num%>" size=10  value = <%=adminUom%>>
				</td>
				<td class="<%=classvalue%>">
					<input type="text" name="remarks<%=num%>" id="remarks<%=num%>" size=25 maxlength='60' value = "<%=java.net.URLDecoder.decode((String)(slidingScaleTmplDtl.get(i+4)==null?blank:slidingScaleTmplDtl.get(i+4)),utf8)%>">
				</td>
			</tr>
<%
			num = num+1;
			}
			noOfRangeForTmpl = noOfRangeForTmpl/5;
		}
%>
	<input type="hidden" name="template_id" id="template_id" value="<%=template_id%>">
	<input type="hidden" name="noOfTemplates" id="noOfTemplates" value="<%=noOfRangeForTmpl%>"> 
	<input type="hidden" name="validate" id="validate" value=""> 

<%
	break;
	}
	}
}

putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>

