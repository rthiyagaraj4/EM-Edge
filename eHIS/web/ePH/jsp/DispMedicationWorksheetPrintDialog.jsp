<!DOCTYPE html>

 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*" %>
 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
	<%
	
	           request.setCharacterEncoding("UTF-8");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="Common.internalreport.label" bundle="${common_labels}"/></title>
</HEAD>
<%
Connection con			= null;  // Added for ML-MMOH-CRF-0468 
con				= ConnectionManager.getConnection(request);// Added for ML-MMOH-CRF-0468 
	try{
		String	bean_id			=	"DispMedicationBean" ;
	String	bean_name		=	"ePH.DispMedicationBean";
	
	DispMedicationBean bean	= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);

	String	bean_id_2		=	"DispMedicationAllStages" ;
	String	bean_name_2		=	"ePH.DispMedicationAllStages";
	
	DispMedicationAllStages bean_2	= (DispMedicationAllStages)getBeanObject( bean_id_2, bean_name_2, request);
   //Added for ML-MMOH-CRF-0468 START
	String ord_type						     = bean.getOrderType();
 
    boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 
    boolean siteTpn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STD_REGIMEN_LABEL");// added for ML-MMOH-CRF-1089
    String identity = request.getParameter("identity");
	String showTitle ="IV";
	if(identity==null){ identity="";}
	if(identity.equals("TPN_WS_FINALIZE")|| identity.equals("TPN_WS_RECORD") ){
		showTitle="TPN";
	}
	String sPatientClass ="";

	if(bean.getDispLocnCatg().trim().equals("O"))
		sPatientClass	=	"OP";
	else if(bean.getDispLocnCatg().trim().equals("I"))
		sPatientClass	=	"IP";

	HashMap  hmPrintOptions			= bean_2.getPrintOptions(sPatientClass);
	boolean  bTokenYN				= bean_2.checkTokenSeries(sPatientClass);	
	String sCertificateReim			=	"hide";
	String sHomeMedicationSheet		=	"hide";
	String sMedicationList			=	"hide";
	String sRefillMediationSheet	=	"hide";
	String sToken					=	"hide";
	String sWorkSheet				=	"hide";
	String sMFGLabel				=	"hide";
	String sLipidLabel				=	"hide";//Added for ml-mmoh-crf-0468
	String sTPNCoverBag				=	"hide";//Added for ml-mmoh-crf-0468
	
	
	if(hmPrintOptions.size()>0){
		//Added for ml-mmoh-crf-0468 start
		if(tpn_mf_label){
			 sLipidLabel				=	"checked";
			 sTPNCoverBag				=	"checked";

		}
		//Added for ml-mmoh-crf-0468  end

		if(hmPrintOptions.get("WORK_SHEET")!=null && hmPrintOptions.get("WORK_SHEET").toString().equals("PD"))
		   sWorkSheet	="checked";
		else if(hmPrintOptions.get("WORK_SHEET")!=null && hmPrintOptions.get("WORK_SHEET").toString().equals("PT"))
			sWorkSheet	="";
				
		if(tpn_mf_label && ord_type.equals("TD")){////added for ml-mmoh-crf-0469 start
			 
			sWorkSheet	="checked";
		}
		//Added for ml-mmoh-crf-0469  end

		if(hmPrintOptions.get("MANUFACTURING_LABEL")!=null && hmPrintOptions.get("MANUFACTURING_LABEL").toString().equals("PD"))
		   sMFGLabel	="checked";
		else if(hmPrintOptions.get("MANUFACTURING_LABEL")!=null && hmPrintOptions.get("MANUFACTURING_LABEL").toString().equals("PT"))
			sMFGLabel	="";

		if(hmPrintOptions.get("CERTIFICATE_REIMBURSEMENT")!=null && hmPrintOptions.get("CERTIFICATE_REIMBURSEMENT").toString().equals("PD"))
		   sCertificateReim	="checked";
		else if(hmPrintOptions.get("CERTIFICATE_REIMBURSEMENT")!=null && hmPrintOptions.get("CERTIFICATE_REIMBURSEMENT").toString().equals("PT"))
			sCertificateReim	="";

		if(hmPrintOptions.get("HOME_MEDICATION_SHEET")!=null && hmPrintOptions.get("HOME_MEDICATION_SHEET").toString().equals("PD"))
		   sHomeMedicationSheet	="checked";
		else if(hmPrintOptions.get("HOME_MEDICATION_SHEET")!=null && hmPrintOptions.get("HOME_MEDICATION_SHEET").toString().equals("PT"))
			sHomeMedicationSheet	="";

		if(hmPrintOptions.get("MEDICATION_LIST")!=null && hmPrintOptions.get("MEDICATION_LIST").toString().equals("PD"))
		   sMedicationList	="checked";
		else if(hmPrintOptions.get("MEDICATION_LIST")!=null && hmPrintOptions.get("MEDICATION_LIST").toString().equals("PT"))
			sMedicationList	="";

		if(bTokenYN)
		{
			if(hmPrintOptions.get("TOKEN")!=null && hmPrintOptions.get("TOKEN").toString().equals("PD"))
				sToken	="checked";
			else if(hmPrintOptions.get("TOKEN")!=null && hmPrintOptions.get("TOKEN").toString().equals("PT"))
				sToken	="";
		}


		if(!sWorkSheet.equals("hide") || !sMFGLabel.equals("hide") || !sCertificateReim.equals("hide") || !sHomeMedicationSheet.equals("hide") || !sMedicationList.equals("hide") || !sRefillMediationSheet.equals("hide") ||	!sToken.equals("hide"))
		{


%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="DispMedicationWorksheetPrintDialog" id="DispMedicationWorksheetPrintDialog">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<tr>
	<td  class="COLUMNHEADER" width="70%"><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></td>
	<td  class="COLUMNHEADER" width="15%"><fmt:message key="Common.required.label" bundle="${common_labels}"/></td>	
</tr>
<%
	if(!sWorkSheet.equals("hide") )
	{//modified for ml-mmoh-crf-0468//ord_type for  for ml-mmoh-crf-0469
%>
<tr>
	<td> <fmt:message key="Common.PrintWorksheet.label" bundle="${common_labels}"/> <!-- <%=showTitle%> <fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/> --></td>
	<td  class="label"><input type="checkbox" name="work_sheet" id="work_sheet" value="Y" <%=sWorkSheet%> ></td>	
</tr>
<%
	}
	if(!sMFGLabel.equals("hide") )
	{
		if((identity.equals("WS_FINALIZE"))|| (identity.equals("TPN_WS_FINALIZE"))||(identity.equals("WS_RECORD"))||(identity.equals("CYTO_WS_FINALIZE"))){
%>		
<tr>
	<td> <fmt:message key="ePH.ManufacturingLabel.label" bundle="${ph_labels}"/> </td>
	<td  class="label"><input type="checkbox" name="manufacturing_label" id="manufacturing_label" value="Y" <%=sMFGLabel%> ></td>
</tr>
<%
		}
	}
%>
<tr>


<% 
	if(!sCertificateReim.equals("hide"))
	{
%>
<tr>
	<td> <fmt:message key="ePH.CERTIFICATE_REIMBURSEMENT.label" bundle="${ph_labels}"/> </td>
	<td  class="label" colspan="2"><input type="checkbox" name="certiReimbur" id="certiReimbur" <%=sCertificateReim%>></td>
</tr>
<%
	}
	if(!sMedicationList.equals("hide"))
	{
%>
<tr>
	<td> <fmt:message key="ePH.MEDICATION_LIST.label" bundle="${ph_labels}"/> </td>
	<td  class="label" colspan="2"><input type="checkbox" name="medicationList" id="medicationList" <%=sMedicationList%>></td>
</tr>
<%
	}
	if(!sToken.equals("hide"))
	{
%>
<tr>
	<td> <fmt:message key="ePH.Token.label" bundle="${ph_labels}"/> </td>
	<td  class="label" colspan="2"><input type="checkbox" name="token" id="token" <%=sToken%>></td>
</tr>
<%
	}
	if(!sHomeMedicationSheet.equals("hide"))
	{
%>
<tr>
	<td> <fmt:message key="ePH.HOME_MEDICATION_SHEET.label" bundle="${ph_labels}"/> </td>
	<td  class="label" colspan="2"><input type="checkbox" name="homeMedicationSheet" id="homeMedicationSheet" <%=sHomeMedicationSheet%>></td>
</tr>
<%		}
	//added for crf-ml-mmoh-cf-0468 start
	if(!sLipidLabel.equals("hide")  && showTitle.equals("TPN") && tpn_mf_label )
	{
%>
<tr>
	<td> <fmt:message key="ePH.LIPIDLABEL.label" bundle="${ph_labels}"/>  </td>
	<td  class="label" colspan="2"><input type="checkbox" name="lipid_label" id="lipid_label" value ="Y"<%=sLipidLabel%>></td>
</tr>
<%
	}
	if(!sTPNCoverBag.equals("hide") && (ord_type.equals("TA") || (ord_type.equals("TD") && siteTpn )) && showTitle.equals("TPN") &&  tpn_mf_label )
	{//ord_type.equals("TD") && siteTpn added for ML-MMOH-CRF-1089
%>
<tr>
	<td> <fmt:message key="ePH.TPNCOVERBAG.label" bundle="${ph_labels}"/> </td>
	<td  class="label" colspan="2"><input type="checkbox" name="cover_bag" id="cover_bag" value="Y"<%=sTPNCoverBag%>></td>
</tr>
<%
	} 
%>
<!-- //added for crf-ml-mmoh-cf-0468 end -->

<td class="white" colspan="3"></td></tr>
</table>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<tr>
	<td  colspan="3" class="white" align='right'><input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="assignSelectedReports(document.DispMedicationWorksheetPrintDialog);window.close()">&nbsp;<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="window.close()"></td>
</tr>
</table>
<%
		}
		else
		{
%>
	<script>
		window.close();
	</script>
<%
	}

	}
	else
	{
%>
	<script>
		window.close();
	</script>
<%
	}}
	catch(Exception e){
		e.printStackTrace();
	}
    finally{ // Added for ML-MMOH-SCF-0468- start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for ML-MMOH-SCF-0468 - stat
%>
</form>
</body>
</html>

