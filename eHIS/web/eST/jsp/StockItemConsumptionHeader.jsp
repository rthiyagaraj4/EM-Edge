<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eST/js/StockItemConsumption.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<style>
	TD.OAQRYODD2{
	FONT-SIZE: 6pt ;
        BACKGROUND-COLOR: #E2E3F0;  
	border-style: solid;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
    }
	</style>
<body  onLoad="FocusFirstElement();disableEncounter();">
<form name="formStockItemConsumptionHeader" id="formStockItemConsumptionHeader">
<%
try{
	String bean_id							=		"stockItemConsumptionBean" ;
	String bean_name						=		"eST.StockItemConsumptionBean";

	eST.StockItemConsumptionBean bean		=		(eST.StockItemConsumptionBean)getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);

	//Added By Sakti Sankar on 01/11/2012 against Inc#35941 to get count of trn_type - CON  
	int count=Integer.parseInt((String)bean.fetchRecord("select count(*) count from st_trn_doc_type where trn_type='CON'").get("COUNT"));
	//Added ends

	String trn_type							=		"";
	String mode								=		request.getParameter("mode");
	//String trn_type							=		"SAL"; Commented By Sakti Sankar on 01/11/2012 against Inc#35941

	//Added By Sakti Sankar on 01/11/2012 against Inc#35941 to display trn_type - CON related doc_type_codes if available
	if(count>0){
     trn_type								=		"CON";
	}else{
	trn_type								=		"SAL";
	}
	//Added ends
	String sql_id							=		"SQL_ST_STK_ITEM_CON_STORE_SELECT";
	String codeDisabled						=		"";
	String encounter_id_visibility			=		"hidden";
	String patient_id_visibility			=		"hidden";
	String preview_disabled					=		"disabled";
	String item_class_based					=		 bean.getCONItemClassBased(trn_type);
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) 
		codeDisabled						=		"disabled";
		
		//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 Starts
	String visibility1				=		"visibility:hidden";  
	String hdr_remarks_reqd = bean.checkForNull((String)bean.fetchRecord("SELECT HDR_REMARKS_REQD FROM ST_TRN_TYPE_FOR_REMARKS WHERE TRN_TYPE ='CON'").get("HDR_REMARKS_REQD"),"N");
    if(hdr_remarks_reqd.equals("Y"))
	visibility1			=		"visibility:visible";
	//ends
	//Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014
	String hdr_rems_mode = bean.checkForNull((String)bean.fetchRecord("SELECT HDR_RMKS_MODE FROM ST_FACILITY_PARAM WHERE FACILITY_ID =?",bean.getLoginFacilityId()).get("HDR_RMKS_MODE"),"M");
	//Added for GHL-CRF-0413 starts
			Connection con				= null;
			con						= ConnectionManager.getConnection(request);
			boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
			bean.setSite_spec_yn(site_main);
	//Added for GHL-CRF-0413 ends
	boolean is_new_con_screen = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","NEW_STOCK_ITEM_CONSUMPTION");//Adding start for TH-KW-CRF-0042,43
	String  new_con_screen_yn="N";
	if(is_new_con_screen)
		 new_con_screen_yn="Y";
	//Adding end for TH-KW-CRF-0042,43
	
%>
<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"				value="<%=mode%>" />
	<jsp:param name="trn_type"			value="<%=trn_type%>" />
	<jsp:param name="storeSQLID"		value="<%=sql_id%>" />
	<jsp:param name="doc_type_code"		value="<%=bean.getDoc_type_code()%>" />
	<jsp:param name="doc_no"			value="<%=bean.getDoc_no()%>" />
	<jsp:param name="doc_date"			value="<%=bean.getDoc_date()%>" />
	<jsp:param name="doc_ref"			value="<%=bean.getDoc_ref()%>" />
	<jsp:param name="store_code"		value="<%=bean.getStore_code()%>" />
	<jsp:param name="item_class_code"	value="<%=bean.getItem_class_code()%>" /> 
	<jsp:param name="bean_id"			value="<%=bean_id%>" />
	<jsp:param name="bean_name"			value="<%=bean_name%>" />
	<jsp:param name="default_doc"		value="STK_ITEM_CON" />
</jsp:include>
<%	//if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
%>
<%	
	if (!bean.getSal_trn_type().equals("R") && !bean.getSal_trn_type().equals("C")) {
		encounter_id_visibility			=	"visible";
		
	}
	else{
		encounter_id_visibility			=	"hidden";
	}
	if(bean.getSal_trn_type().equals("C")){
		//encounter_id_visibility		=	"hidden";
		patient_id_visibility			=	"hidden";

	}
	//ArrayList custList = bean.getCustomerId();
	//HashMap map = (HashMap)custList.get(0);
	//String customerId = (String)map.get("CUSTOMER_ID");
	//}
%>
<table cellpadding=0 cellspacing=0 border=0 width='100%' align="center">
	<tr>
		<td class='label' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;<select name="sal_trn_type" id="sal_trn_type" <%=codeDisabled%> onChange="checkTRNType(this);" disabled >	<%=bean.getSal_trn_type_List()%>
		</select>
		</td>
		<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<!-- Added by Rabbani #Inc no:39734(RUT-SCF-0268) on 24-MAY-2013-->
		<!--//Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014 -->
		<%if(hdr_rems_mode.equals("P")){%>
		<td colspan='3' class='fields'>&nbsp;<input type='text' name='remarks' id='remarks' size=70 maxLength=200 value="<%=bean.getRemarks()%>" onKeyPress="return false;" onpaste="return false;"  onBlur="checkRemarksLength(this);"><input type="hidden" name="hdr_remarks_code" id="hdr_remarks_code" value = "" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(hdr_remarks_code,remarks);"><img id="remarks_jif" src="../../eCommon/images/mandatory.gif" align=center style="<%=visibility1%>">
		</td>
		<%}else{%>
		<td colspan='3' class='fields'>&nbsp;<input type='text' name='remarks' id='remarks' size=70 maxLength=200 value="<%=bean.getRemarks()%>"  onBlur="checkRemarksLength(this);"><input type="hidden" name="hdr_remarks_code" id="hdr_remarks_code" value = "" ><img id="remarks_jif" src="../../eCommon/images/mandatory.gif" align=center style="<%=visibility1%>"></td>
		<%}%>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;<input type='text' name='patient_id' id='patient_id' class="UPPER" size=20 maxLength=<%=bean.getpatlength()%> value="<%=bean.getPatient_id()%>" onBlur="ChangeUpperCase(this);getPatientName(this.value);" <%=codeDisabled%>><input type='button' class='button' value="?" onclick="searchPatient();" <%=codeDisabled%>><span id='id_patient_id_gif' style="visibility:<%=patient_id_visibility%>"><%=bean.getImage("M")%></span></td>
		<td class='label' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;<input type='text' name="patient_name" id="patient_name" 	value="<%=bean.getPatient_name()%>" size=30 maxLength=40 disabled> 
		</td>
		<td class='fields'>
			<input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class=button style='width:53' style='height:14pt' <%=preview_disabled%>  onclick="previewDetails();" >
		</td> 
	</tr>
</table>
<table cellpadding=0 cellspacing=0 border=0 width='100%' align="center">
	<tr>
		<td class='label'  width = '101'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;<select name='encounter_id' id='encounter_id' <%=codeDisabled%>> 
		<%
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) 
		{
			out.println(bean.getStRepositoryValue("DEFAULT_LIST_OPTION"));
		}
		else
		{
			ArrayList list = bean.getEncounter_id_List();
			HashMap results = null;
				for(int i=0;i<list.size();i++)
		{
			results = (HashMap)list.get(i);
		%>
		<option value="<%=results.get("ITISTOPOPULATELISTBOX")%>"><%=(String)results.get("CLINIC_NAME")+" , "+(String)results.get("DT_TIME")+" , "+(String)results.get("PRACTITIONER_NAME")%></option>
		<%
		}
		}
		%>
		</select><span id='id_encounter_id_gif' style="visibility:hidden"><%=bean.getImage("M")%></span>
		</td>
	 
	</tr>

	</table>
	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="finalized_yn" id="finalized_yn"			value="N">
	<input type="hidden" name="authorized_by_id" id="authorized_by_id"		value="<%=bean.getLoginById()%>">
	<input type="hidden" name="authorize_allowed_yn" id="authorize_allowed_yn"	value="N">
	<input type="hidden" name="function_id" id="function_id"				value="<%= request.getParameter("function_id") %>">
	<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
	<!--Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 -->
	<input type="hidden" name="hdr_remarks_reqd" id="hdr_remarks_reqd"		 value="<%=hdr_remarks_reqd%>">
	<!-- Added by Rabbani #Inc no:39734(RUT-SCF-0268) on 24-MAY-2013-->
	<input type="hidden"	name="lang_id" id="lang_id"			value="<%=locale%>">
	<input type="hidden"	name="rem_trans_type" id="rem_trans_type"	value="CON">
	<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
	 <!--Added against GHL-CRF-0413 starts-->
        <input type="hidden"    name="site" id="site"	 value="<%=site_main%>">
        <input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
	<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" >
	<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value="">
	<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" >
	<!--Added against GHL-CRF-0413 ends-->
	<input type="hidden" name ="new_con_screen_yn" value ="<%=new_con_screen_yn%>"><!-- Added for TH-KW-CRF-0042,43 -->
	
</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>
<script type="text/javascript">
callBarCodeApplicable('CON','formStockItemConsumptionHeader','stockItemConsumptionBean','eST.StockItemConsumptionBean');//Added against GHL-CRF-0413
</script>
<%
//Added for GHL-CRF-0413 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413 ends
%>
	<%
			}
		catch(Exception e) {
			e.printStackTrace();
					}
		%>

