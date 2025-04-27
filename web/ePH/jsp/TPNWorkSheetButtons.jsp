<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>

<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	 request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNWorkSheet.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DispMedication.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	
	</script>
</HEAD>


<%

	String qty					=	"";
	String uom					=	"";
	String presc_base_unit		=   "";
	String order_id				=   request.getParameter("order_id");
	String patient_id			=   request.getParameter("patient_id");

	String params = request.getQueryString() ;
	String order_line_no		=   "1";
	String	bean_id				=	"DispMedicationAllStages" ;
	String	bean_name			=	"ePH.DispMedicationAllStages";
	DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
	uom				=	bean.getDrugUom();
	String pres_qty =   bean.getTPNPresQty();
	if(qty==null) qty="";
	if(uom==null) uom="";


	String tpn_qty     = request.getParameter("tpn_qty")==null?"":request.getParameter("tpn_qty");
	if(tpn_qty.equals("")) //if block Added for ICN:35432
		tpn_qty = "0";
	if(!tpn_qty.equals("")){
          qty  = tpn_qty;
	}
    String tpn_uom     = request.getParameter("tpn_uom")==null?"":request.getParameter("tpn_uom");
	if(!tpn_uom.equals(""))
          uom  = tpn_uom;

    String osmolarity_volume         = request.getParameter("ws_osmo_value")==null?"":request.getParameter("ws_osmo_value");
	String osmolarity_volume_per_ltr = request.getParameter("ws_osmo_value_lt")==null?"":request.getParameter("ws_osmo_value_lt");

	String bean_id1			 = "TPNWorkSheetBean";
	String bean_name1		 = "ePH.TPNWorkSheetBean";
	TPNWorkSheetBean bean_ws = (TPNWorkSheetBean)getBeanObject(bean_id1,bean_name1,request);
	bean_ws.setLanguageId(locale);
	
	presc_base_unit		=	bean_ws.getPrescBaseUnit();
	if(uom.equals("")){ uom = presc_base_unit; }
    String tot_groos_pat_payable_str				="";
	String tot_gross_charge_amount_str				="";

	String billing_interface_yn     =   bean.checkforbillinginterface();
	if(billing_interface_yn.equals("Y")){
	 tot_groos_pat_payable_str				=   request.getParameter("tot_groos_pat_payable_str")==null?"":request.getParameter("tot_groos_pat_payable_str");
	tot_gross_charge_amount_str				=   request.getParameter("tot_gross_charge_amount_str")==null?"":request.getParameter("tot_gross_charge_amount_str");
	//out.println("==tot_groos_pat_payable_str===="+tot_groos_pat_payable_str+"=tot_gross_charge_amount_str=="+tot_gross_charge_amount_str);

	}

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean_ws,request); 			

%>
<!-- <BODY > -->
<body onMouseDown="" onKeyDown="lockKey()">
<FORM name="formTPNWorkSheetButtons" id="formTPNWorkSheetButtons" >
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR height ="3"><TD colspan="6"></TD></TR>
	<TR>
		<td class=label name=fluid  align='right'><b><fmt:message key="ePH.FluidVolume.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</b></td>
		
		
		<td align="left" class="label" ><input type=text name="ordered_volume" id="ordered_volume" readonly value='<%=pres_qty%>'  size=3>
		<label ID='ordered_uom'  align='left' STYLE="font-size:9;font-weight:bold;" > <b><%=uom%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type=text name="ordered_volume_overage" id="ordered_volume_overage" readonly value='<%=pres_qty%>'   size=3>
		</td>


		<td align="left" class="label" ></td>
		<TD class="label" ALIGN="right" >
			<b>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Osmolarity.label" bundle="${ph_labels}"/>:&nbsp;&nbsp;&nbsp;</b>
			<fmt:message key="Common.total.label" bundle="${common_labels}"/>
        <%
		if(osmolarity_volume.equals("")){%>
			  <input type=text name="osmolarity_volume" id="osmolarity_volume" readonly value='<%=retunFormatedInt(qty)%>'   size='6'>
		<%}else{%>
             <input type=text name="osmolarity_volume" id="osmolarity_volume" readonly value='<%=retunFormatedInt(osmolarity_volume)%>'   size='6'>
		<%}%>
		<label ID='osmolarity_uom'  align='left' STYLE="font-size:9;font-weight:bold;" >mOsmol&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		</TD>

		<TD class="label" ALIGN="right" >
			<b>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</b><input type=text name="fluid_volume" id="fluid_volume" readonly value='<%=retunFormatedInt(qty)%>'  size=6><input type='hidden' name='fluid_volume_hid' id='fluid_volume_hid' value='<%=qty%>'>

		<label ID='fluid_uom'  align='left' STYLE="font-size:9;font-weight:bold;" > <b><%=uom%></b>&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp;
		</TD>

	</TR>
	<TR height ="3"><TD colspan="6"></TD></TR>
	<TR>
		<td  align='center'  WRAP class="DOSELIMIT"  border="1" bordercolor="black"><b><fmt:message key="ePH.BeyondLimit.label" bundle="${ph_labels}"/></b></td>
		<td align="center"  class="AMENDEDDRUGS" border="1" bordercolor="black"><b><fmt:message key="ePH.Notordered.label" bundle="${ph_labels}"/></b></td>
		<td align="left" class="label" ></td>
		<TD class="label" ALIGN="right" >
		<%if(osmolarity_volume_per_ltr.equals("")){%>
			<input type=text name="osmolarity_volume_per_ltr" id="osmolarity_volume_per_ltr" readonly value='<%=retunFormatedInt(qty)%>'  size='6'>
		<%}else{%>
            <input type=text name="osmolarity_volume_per_ltr" id="osmolarity_volume_per_ltr" readonly value='<%=retunFormatedInt(osmolarity_volume_per_ltr)%>'  size='6'>
		<%}%>
		<label ID='osmolarity_uom'  align='left' STYLE="font-size:9;font-weight:bold;" >mOsmol/L&nbsp;&nbsp;&nbsp;
		</TD>
		<TD STYLE="bachground-color:white" ALIGN="right" >
			<INPUT TYPE="button" CLASS="button" name="RECORD" id="RECORD" VALUE='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="callRecordWS('<%=pres_qty%>')">&nbsp;
			<INPUT TYPE="button" CLASS="button" name="CANCEL" id="CANCEL" VALUE='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' onClick="callCancel()">&nbsp;&nbsp;&nbsp;
		</TD>
	</TR>
	<TR height ="3"><TD colspan="6"></TD></TR>
	<INPUT type = 'hidden' name='billing_interface_yn' id='billing_interface_yn' value='<%=billing_interface_yn%>'>

	</TABLE>
	<%if(billing_interface_yn.equals("Y")){%>
		<table cellpadding="0" cellspacing="0" height='10' width="100%" align="center" border="0">	 
		   <tr>
				 <td class="data" width='30%'>&nbsp;</td>  
			   <td  class="data"  align='center' style="font-size:9pt" id='td_total_payable' ><fmt:message key="ePH.TotalChargeAmount.label" bundle="${ph_labels}"/> : <%=tot_gross_charge_amount_str%> </td>
			   <td  class="data"  align='center' style="font-size:9pt" id='td_patient_payable' ><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>  :<%=tot_groos_pat_payable_str%>  </td>
		   </tr>
	   </table>
	   <input type="hidden"  name="total_payable" id="total_payable"   value="<%=tot_gross_charge_amount_str%>">
	  <input type="hidden"   name="patient_payable" id="patient_payable" value="<%=tot_groos_pat_payable_str%>">	
   <%}%>
<SCRIPT>
    if(parent.f_query_add_mod!=undefined){
	         parent.f_query_add_mod.document.getElementById("overage_uom").innerText	= '<%=presc_base_unit%>';
		}
		calOvrgeOrdQty(parent.f_query_add_mod.document.formTPNWorkSheetDetails.overage_volume);
</SCRIPT>
	<INPUT type = 'hidden' name='presc_base_unit' id='presc_base_unit' value='<%=presc_base_unit%>'>
<%! 
	DecimalFormat dfToInteger = new DecimalFormat("#.####");
	private String retunFormatedInt(String sValue)
	{
		if(sValue != null && !sValue.equals(""))
		{
			return dfToInteger.format(Double.parseDouble(sValue));
		}
		return "";
	}
%>
</FORM>
</BODY>

</HTML>

