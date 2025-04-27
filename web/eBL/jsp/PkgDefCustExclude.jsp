<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%
 /*
Sr No        Version           Incident        SCF/CRF             Developer Name
---------------------------------------------------------------------------------------
1			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
*/
%>
<html>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String siteSpecf=session.getAttribute("siteSpecf").toString();
	Boolean ss=Boolean.parseBoolean(siteSpecf); 
	System.out.println("siteSpecf" + ss);
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
	Connection con = null;
	boolean dailyLimitSiteSpec = false;
	try {
		con = ConnectionManager.getConnection(request);
		dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT");
	} catch(Exception ex) {
		System.err.println("Error in PkgDefRateBased.jsp: "+ex);
		ex.printStackTrace();
	}
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDefCust.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<script>
	$(document).ready(function(){
		//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated.
		if($('#dailyLimitSiteSpec').val() == true || $('#dailyLimitSiteSpec').val() == "true") { 
			if(parent.frames[1].document.forms[0].order_associated.value == "Y") {
				var formObj=document.cust_srvLimit_rate_based_dtl;
				for(var cnt = 0; cnt < document.forms[0].totalRecords.value; cnt++) {
					eval("formObj.dailyLmtChkBx"+cnt).checked = false;
					
					eval("formObj.dailyLmtChkBx"+cnt).value = 'N';
					eval("formObj.dailyLmtAmt"+cnt).value = '';
					eval("formObj.dailyLmtGrossNetList"+cnt).value = 'G';
					eval("formObj.dailyLmtIndicator"+cnt).value = '*';//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					eval("formObj.dailyLmtQty"+cnt).value = '';//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					
					eval("formObj.dailyLmtChkBx"+cnt).disabled = true;
					eval("formObj.dailyLmtAmt"+cnt).disabled = true;
					eval("formObj.dailyLmtGrossNetList"+cnt).disabled = true;
					eval("formObj.dailyLmtIndicator"+cnt).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					eval("formObj.dailyLmtQty"+cnt).disabled = true;//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				}
			}
		}//Ends
		
		/* if($('#modifyStatus').val() == "") {
			for(var ind = 0; ind < document.forms[0].totalRecords.value; ind++) {//Added V190409-Aravindh/MMS-DM-CRF-0129
				var formObj=document.cust_srvLimit_rate_based_dtl;
				dailyLmtChkBxClickPharmaCust(eval("formObj.srvLimit_service_code"+ind),eval("formObj.srvLimit_type"+ind),ind);
			}
		} *///Commented V190626-Aravindh/MMS-DM-CRF-0129.1/No need to check for PH service or not
	});
	function alignHeading()
	{	
		if(parent.cust_srvLimit_rate_based_dtl_hdr.document.getElementById("tableheader")!=null)
		{		
				parent.cust_srvLimit_rate_based_dtl_hdr.document.getElementById("tableheader").width =	eval(parent.frames[4].document.getElementById("cust_srvLimit_rate_based_tbl").offsetWidth);
					for (j=0; j < parent.frames[4].document.getElementById("cust_srvLimit_rate_based_tbl").rows(2).cells.length; j++) 
					{		
						
						var  wid=eval(parent.frames[4].document.getElementById("cust_srvLimit_rate_based_tbl").rows(2).cells(j).offsetWidth);					
						if(parent.cust_srvLimit_rate_based_dtl_hdr.document.getElementById("tableheader").rows(1).cells(j) != null)
						{
					
							parent.cust_srvLimit_rate_based_dtl_hdr.document.getElementById("tableheader").rows(1).cells(j).width=wid;
							/* parent.cust_srvLimit_rate_based_dtl_hdr.document.getElementById("tableheader").rows(1).cells(0).width='150';
							parent.frames[4].document.getElementById("cust_srvLimit_rate_based_tbl").rows(2).cells(2).width='66';
							parent.frames[4].document.getElementById("cust_srvLimit_rate_based_tbl").rows(2).cells(8).width='66';
							parent.frames[4].document.getElementById("cust_srvLimit_rate_based_tbl").rows(2).cells(9).width='66';
							parent.frames[4].document.getElementById("cust_srvLimit_rate_based_tbl").rows(2).cells(10).width='66';
							parent.frames[4].document.getElementById("cust_srvLimit_rate_based_tbl").rows(2).cells(11).width='80';
							parent.frames[4].document.getElementById("cust_srvLimit_rate_based_tbl").rows(2).cells(12).width='66'; */
							
					
						}
					}
			}
		
	}
	function moveFrame()
	{	
		var temp=document.body.scrollLeft;
		scrollValue=temp;

		if(parent.cust_srvLimit_rate_based_dtl_hdr.location.href.indexOf(".jsp") != -1)
		{
			parent.cust_srvLimit_rate_based_dtl_hdr.document.body.scrollLeft=temp;
		}
	}
	</script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onscroll='moveFrame()' onLoad='chkCustExludeServiceonload();includeHomeMedicationEnableCust();'>
<%
try{
	String locale			= (String)session.getAttribute("LOCALE");
	String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	
	String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
	String fromDateTemp		 = request.getParameter("fromDateTemp")==null ? "" :request.getParameter("fromDateTemp") ;
	String type=request.getParameter("type");
	int totalRecords=1;
	
	String packageCode		=	"" ;
	String copyFrm_pkgCode		=	"" ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
	String parent_indx		=	request.getParameter("parent_indx") == null ? "" :request.getParameter("parent_indx") ;
	String cust_grp_code		=	request.getParameter("cust_grp_code") == null ? "" :request.getParameter("cust_grp_code") ;
	String cust_grp_desc		=	request.getParameter("cust_grp_desc") == null ? "" :request.getParameter("cust_grp_desc") ;
	String cust_code		=	request.getParameter("cust_code") == null ? "" :request.getParameter("cust_code") ;
	String cust_desc		=	request.getParameter("cust_desc") == null ? "" :request.getParameter("cust_desc") ;
	String service_code		=	request.getParameter("service_code") == null ? "" :request.getParameter("service_code") ;
	String service_desc		=	request.getParameter("service_desc") == null ? "" :request.getParameter("service_desc") ;
	String parDailyLmtInd = request.getParameter("dailyLmtInd") == null ? "*" : request.getParameter("dailyLmtInd");//Added V190731-Aravindh/MMS-DM-CRF-0129.1

	String uSelect = "";
	String dSelect ="";
		String disabledAll="";
	String bean_id		= "bl_PkgDefCustBean" ;
	String bean_name	= "eBL.PkgDefCustBean";
	PkgDefCustBean bean		= (PkgDefCustBean)getBeanObject( bean_id, bean_name, request ) ;	
	String		splitReqd = "Y";	//Split reqd
	String		includeHomeMedication = "N";	//Split reqd
	String enableDisParam="N";
	String srvLimit_type		="";
	String 		srvLimit_service_code			="";
	String 	    srvLimit_service_desc		="";
	String 		exludeService			="N";
	String 		srvLimit_qty_limit		="";
	String 		srvLimit_amt_limit			="";
	String 		srvLimit_factor_appl			="";	
	String 		srvLimit_amt_limit_ind	="";
	String 	    srvLimit_replace		="N";
	String 		srvLimit_replaceSrv_code="";
	String		srvLimit_replaceSrv_desc = "";
	String 		srvLimit_refund		="N";
	String 		srvLimit_refundAmt		="";
	String 		srvLimit_auto_refund			="N";
	String      srvLimit_roundTo = "";
	String      srvLimit_roundInd = "";
	String 		dailyLmtChkYN = "N";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtGrossNet = "G";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		order_associated=request.getParameter("orderAssociated") == null ? "N" : request.getParameter("orderAssociated");//Added V190404-DHANANJAY/MMS-DM-CRF-0129
	String 		pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "", qtyFldDisabled = "", indicatorFldDisabled = "";//Added V190625-Aravindh/MMS-DM-CRF-0129.1
	String 		facilityId = (String) session.getValue( "facility_id" ) ;//Added V190625-Aravindh/MMS-DM-CRF-0129.1
	
	bean.setModifyCustRateSrvExcl("Y");	
	HashMap cust_rate_srv_excl		= new HashMap();		
	ArrayList cust_rate_srv_excl_list	     =	new ArrayList();
	String noofdecimal	= bean.getNoOfDecimal();
	cust_rate_srv_excl	=  (HashMap)bean.getCustRateSrvExcl();
	if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0 && cust_rate_srv_excl.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim()))
	{
		cust_rate_srv_excl_list=(ArrayList)cust_rate_srv_excl.get(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
	}
	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
		 modifyStatus = " disabled ";

%>

<form name='cust_srvLimit_rate_based_dtl' id='cust_srvLimit_rate_based_dtl'  target='messageFrame' >	
<table class='grid' width='100%' id="cust_srvLimit_rate_based_tbl"  name="cust_srvLimit_rate_based_tbl" id="cust_srvLimit_rate_based_tbl" border = "1">
<!--<tr><td class='COLUMNHEADER'  colspan='17'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>&nbsp;: &nbsp;<%=cust_grp_desc%>&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=cust_desc%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=fromDate%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=service_desc%>&nbsp;&nbsp;&nbsp;</td>
</tr><tr>
<td class='columnheader' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>
<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>

<td class='columnheader' ><fmt:message key="Common.Replace.label" bundle="${common_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.RefundRatePer.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
</tr>
-->
<tr></tr><tr></tr>


<%	 
	/* Added V190625-Aravindh/MMS-DM-CRF-0129.1/Starts */
	String blParametersqry = "SELECT NVL(PKG_SERV_LMT_BY,'*') PKG_SERV_LMT_BY, NVL(DAILY_PKG_LMT_YN,'N') DAILY_PKG_LMT_YN, NVL(DAILY_PKG_LMT_BY,'*') DAILY_PKG_LMT_BY FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+facilityId+"'";
	PreparedStatement pstmt = con.prepareStatement(blParametersqry);
	ResultSet rst = pstmt.executeQuery();
	while(rst.next()) {
		pkgServLimit = rst.getString("PKG_SERV_LMT_BY");
		dailyLmtChkYN = rst.getString("DAILY_PKG_LMT_YN");
		dailyPkgLmt = rst.getString("DAILY_PKG_LMT_BY");
	}
	
	pstmt.close();
	rst.close();
	
	if(null != pkgServLimit && !"*".equals(pkgServLimit))
	{
		if("Q".equals(pkgServLimit)) {
			amtFldDisabled = " disabled ";
		} else if("A".equals(pkgServLimit)) {
			qtyFldDisabled = " disabled ";
		}
	}
	
	if(null == dailyLmtChkYN || !"Y".equals(dailyLmtChkYN)) {
		indicatorFldDisabled = " disabled ";
	}
	/* Added V190625-Aravindh/MMS-DM-CRF-0129.1/Ends */
	String[] 	record;
	if(cust_rate_srv_excl_list!=null && cust_rate_srv_excl_list.size()>0){
		totalRecords = cust_rate_srv_excl_list.size();	//added by ram
		for(int i=0;i<totalRecords;i++){
		
			//record=new String[19];//Split Reqd
			/* Commented V190320-Aravindh/MMS-DM-CRF-0129/Above line, added below line */
			record=new String[24];//Split Reqd				
			record=(String[])(cust_rate_srv_excl_list.get(i));
			
			srvLimit_type		= record[0];
			srvLimit_service_code		= record[1];
		    srvLimit_service_desc	=record[2];
			exludeService		=record[3];
			if(exludeService==null || exludeService.equals("") || exludeService.equals("null"))
				exludeService="N";
			srvLimit_qty_limit			= record[4];
			srvLimit_amt_limit_ind	= record[5];
			srvLimit_amt_limit		= record[6];
		    srvLimit_roundTo		= record[7];			
			srvLimit_roundInd= record[8];
			srvLimit_replace		= record[9];
			srvLimit_replaceSrv_code		=record[10];
			srvLimit_replaceSrv_desc		=record[11];
			srvLimit_refund	= record[12];
			srvLimit_refundAmt		=record[13];
			if(srvLimit_refundAmt==null || srvLimit_refundAmt.equals("") || srvLimit_refundAmt.equals("null"))
				srvLimit_refundAmt="";
			srvLimit_auto_refund		=record[14];
			srvLimit_factor_appl		=record[15];
			splitReqd	=	record[16];
			includeHomeMedication	=	record[17];
			enableDisParam		= record[18];
			/* Commented V190819-Aravindh/MMS-DM-CRF-0129.1/Below line */
			//dailyLmtChkYN = record[19];//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtAmt = record[20];//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtGrossNet = record[21];//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtInd = record[22];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			if("".equals(dailyLmtInd)){
				dailyLmtInd = "*";
			}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			dailyLmtQty = record[23];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			
		uSelect = srvLimit_roundInd.equals("U")? " selected "	 :"";
		dSelect = srvLimit_roundInd.equals("D")? " selected "	 :"";
			if(exludeService==null || exludeService.equals("") || exludeService.equals("null"))
			exludeService="N";
			if(exludeService.equals("Y"))
			disabledAll="disabled";
		else
		   disabledAll="";

		%>
<tr>
<td class='fields' nowrap WIDTH=''> 
<%
if(type.equals("G")){
%>
<select name='srvLimit_type<%=i%>' id='srvLimit_type<%=i%>'  <%=modifyStatus%> onChange='onCustSrvLimitServiceTypeChange(this,"<%=i%>")'>
	<option value='C' <%=srvLimit_type.equals("C")?"selected":""%>>
	<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option>
	<option value='S' <%=srvLimit_type.equals("S")?"selected":""%>>
	<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>

<!-- Added By Muthukumar against KDAH-SCF-0057 on 30-4-12 Starts Here --> 
	<option value='M' <%=srvLimit_type.equals("M")?"selected":""%>>
	<fmt:message key="Common.item.label" bundle="${common_labels}"/></option>
	<option value='P' <%=srvLimit_type.equals("P")?"selected":""%>>
	<fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"/></option>	
</select>
<%  
}else if(type.equals("P")){
%>
<select name='srvLimit_type<%=i%>' id='srvLimit_type<%=i%>' <%=modifyStatus%> onChange='onCustSrvLimitServiceTypeChange(this,"<%=i%>")'>
<option value='C' <%=srvLimit_type.equals("C")?"selected":""%>>
<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/>
</option>
<option value='G'<%=srvLimit_type.equals("G")?"selected":""%>>
<fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/>
</option>
<option value='S' <%=srvLimit_type.equals("S")?"selected":""%>>
<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>
</option>
<option value='M' <%=srvLimit_type.equals("M")?"selected":""%>>
<fmt:message key="Common.item.label" bundle="${common_labels}"/>
</option>
<option value='T' <%=srvLimit_type.equals("T")?"selected":""%>>
	<fmt:message key="eBL.SalesCategory.label" bundle="${bl_labels}"/>
</option>
<option value='P' <%=srvLimit_type.equals("P")?"selected":""%>>
<fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"/>
</option>
<!-- Added By Muthukumar against KDAH-SCF-0057 on 30-4-12 Ends Here -->
</select>
<%
}else{%>
<select name='srvLimit_type<%=i%>' id='srvLimit_type<%=i%>'	<%=modifyStatus%> onChange='onCustSrvLimitServiceTypeChange(this,"<%=i%>")'><option value='S' <%=srvLimit_type.equals("S")?"selected":""%>><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option></select>
<%}
%>
</td>
					
<td class='fields' nowrap WIDTH=''><input type='text' name='srvLimit_service_code<%=i%>' id='srvLimit_service_code<%=i%>'	<%=modifyStatus%> value='<%=srvLimit_service_code%>' size='10' onBlur="custSrvLimitCodeLookUp(srvLimit_service_desc<%=i%>,this,srvLimit_type<%=i%>,'<%=i%>')"><input type='text' name = 'srvLimit_service_desc<%=i%>' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="before_custSrvLimitServiceLookUp(this,srvLimit_service_code<%=i%>,srvLimit_type<%=i%>,'<%=i%>')" value="<%=srvLimit_service_desc%>"><INPUT type='hidden' name='srvLimit_service_code_temp<%=i%>' id='srvLimit_service_code_temp<%=i%>' value=''><INPUT type='hidden' name='srvLimit_service_desc_temp<%=i%>' id='srvLimit_service_desc_temp<%=i%>' value=''><input type='button' name='srvLimit_service_button<%=i%>' id='srvLimit_service_button<%=i%>' class='button' value='?'	 <%=modifyStatus%> onclick="custSrvLimitServiceLookUp(srvLimit_service_desc<%=i%>,srvLimit_service_code<%=i%>,srvLimit_type<%=i%>,'<%=i%>')"></td>

<td class='fields' nowrap WIDTH='60' ><input type='checkbox' name='exludeService<%=i%>' id='exludeService<%=i%>'	id='exludeService<%=i%>' <%=modifyStatus%>  <%=exludeService.equals("Y")?"checked":""%> onClick='chkCustExludeService(this,"<%=i%>");changeSplitReqd(this,"exclude","<%=i%>");IncludeHomeMedicationcustExclude(this,srvLimit_service_code<%=i%>,srvLimit_type<%=i%>,"<%=i%>");' value="<%=exludeService%>" /></td>
			
<td class='fields' nowrap WIDTH=''><input type='text'    name='srvLimit_qty_limit<%=i%>' id='srvLimit_qty_limit<%=i%>' <%=modifyStatus%>  size='5' <%=disabledAll%> onBlur='chkCustSrvLimitQtyLimit(this);' onkeypress='return allowValidNumber(this,event,"<%=noofdecimal%>");' value="<%=srvLimit_qty_limit%>" /></td>

<td  class='fields' nowrap WIDTH=''>
<select name='srvLimit_amt_limit_ind<%=i%>' id='srvLimit_amt_limit_ind<%=i%>' onChange='validateCustInd(this,"<%=i%>")' <%=modifyStatus%> <%=disabledAll%>>
<option value='' <%=(srvLimit_amt_limit_ind.equals("")?"selected":"")%> >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<option value='A' <%=(srvLimit_amt_limit_ind.equals("A")?"selected":"")%>><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
<option value='P' <%=(srvLimit_amt_limit_ind.equals("P")?"selected":"")%> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
</select>
</td>

<td class='fields' nowrap WIDTH=''><input type='text' name='srvLimit_amt_limit<%=i%>' id='srvLimit_amt_limit<%=i%>' <%=modifyStatus%>  <%=disabledAll%> size='5' maxlength='13' 	<%=((srvLimit_amt_limit_ind.equals("")||srvLimit_amt_limit_ind.equals("U"))?"disabled":"")%> onBlur='chkCustSrvLimitAmtLimit(this,"<%=i%>","<%=noofdecimal%>")' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>");' value="<%=srvLimit_amt_limit%>"/></td>
<td  class='fields' ><input type='text' name='srvLimit_roundTo<%=i%>' id='srvLimit_roundTo<%=i%>' size='3'	<%=modifyStatus%> <%=disabledAll%> maxlength="3"  value="<%=srvLimit_roundTo%>"  onkeypress=" return (allowValidNumber(this,event));"  /></td>
<td  class='fields' class='fields' nowrap WIDTH='75' >
<select name='srvLimit_roundInd<%=i%>' id='srvLimit_roundInd<%=i%>' <%=modifyStatus%>   <%=disabledAll%> onChange="" >
<option value='U' <%=uSelect%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
<option value='D' <%=dSelect%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
</select>
</td>
<%if(ss){%>	
	<td class='fields' nowrap WIDTH='75'><input type='checkbox'   <%=modifyStatus%> name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%> <%="Y".equals(enableDisParam)?"":"disabled" %>  onclick="checkInclHomeMedi(this); IncludeHomeMedicationUnchkExclude(this,'custrateexclude','<%=i%>');">
	<input type='hidden' name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value="<%=enableDisParam%>"> </td>
<%}else{%>
	<td class='fields' nowrap WIDTH=''><input type='hidden'   <%=modifyStatus%>	name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='Y' >
	<input type='hidden' name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value="Y"> </td>
<%} %>
<!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->
<%if(dailyLimitSiteSpec) { %>
	<%-- <td class='fields' WIDTH='' nowrap >
	<!-- Added 	V190404 - dhananjay/MMS-DM-CRF-0129 added enableDisParam to disable or enable -->
		<input type='checkbox' name = 'dailyLmtChkBx<%=i%>' id = 'dailyLmtChkBx<%=i%>' <%=modifyStatus%> onclick = 'dailyLmtChkBxClick(this,<%=i%>,document.cust_srvLimit_rate_based_dtl)' value='<%=dailyLmtChkYN %>' <%="Y".equals(dailyLmtChkYN)?" checked ":""%> />
	</td>
	<td class='fields' WIDTH='' nowrap >
		<input type='text' name = 'dailyLmtAmt<%=i%>' id = 'dailyLmtAmt<%=i%>' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8540");' 
			onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")'; <%=modifyStatus%> <%="Y".equals(dailyLmtChkYN)?"":" disabled "%> value='<%=dailyLmtAmt %>' />
		<select name='dailyLmtGrossNetList<%=i%>' id='dailyLmtGrossNetList<%=i%>' id='dailyLmtGrossNetList<%=i%>' <%=modifyStatus%> <%="Y".equals(dailyLmtChkYN)?"":" disabled "%> >
			<option value='G' <%="G".equals(dailyLmtGrossNet)?" selected ":""%> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
			<option value='N' <%="N".equals(dailyLmtGrossNet)?" selected ":""%> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
		</select>
	</td> --%>
	<td class='fields' WIDTH='' nowrap >
		<select name='dailyLmtIndicator<%=i%>' id='dailyLmtIndicator<%=i%>' id='dailyLmtIndicator<%=i%>' <%=modifyStatus%> <%=indicatorFldDisabled%> onchange='dailyLmtIndicatorOnChange(this,<%=i%>,document.cust_srvLimit_rate_based_dtl)' >
			<option value="*"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
			<% if("G".equals(parDailyLmtInd) || "B".equals(parDailyLmtInd)) { %>
				<option value="G" <%="G".equals(dailyLmtInd)?" selected ":""%> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
			<% } if("I".equals(parDailyLmtInd) || "B".equals(parDailyLmtInd)) {%>
				<option value="I" <%="I".equals(dailyLmtInd)?" selected ":""%> ><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
			<% } %>
		</select>
		<input type='hidden' name = 'dailyLmtChkBx<%=i%>' id = 'dailyLmtChkBx<%=i%>' value = '<%=dailyLmtChkYN%>' />
		<%-- <input type='hidden' name = 'dailyLmtGrossNetList<%=i%>' id='dailyLmtGrossNetList<%=i%>' value = '' /> --%>
	</td>
	<td class='fields' WIDTH='' nowrap >
		<input type='text' name = 'dailyLmtAmt<%=i%>' id = 'dailyLmtAmt<%=i%>' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8540");' 
				onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>");' <%=modifyStatus%> <%=amtFldDisabled%> <%=indicatorFldDisabled%> 
				value='<%=dailyLmtAmt %>' <%="*".equals(dailyLmtInd)?" readOnly ":""%> />
		<select name='dailyLmtGrossNetList<%=i%>' id='dailyLmtGrossNetList<%=i%>' id='dailyLmtGrossNetList<%=i%>' <%=modifyStatus%> <%=amtFldDisabled%> <%=indicatorFldDisabled%> <%="*".equals(dailyLmtInd)?" disabled ":""%> >
			<option value='G' <%="G".equals(dailyLmtGrossNet)?" selected ":""%> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
			<option value='N' <%="N".equals(dailyLmtGrossNet)?" selected ":""%> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
		</select>
	</td>
	<td class='fields' WIDTH='' nowrap >
		<input type='text' name = 'dailyLmtQty<%=i%>' id = 'dailyLmtQty<%=i%>' size='8' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,"BL8538");' 
				onkeypress='return allowValidNumber(this,event,10,0);' <%=modifyStatus%> <%=qtyFldDisabled%> <%=indicatorFldDisabled%> 
				value='<%=dailyLmtQty %>' <%="*".equals(dailyLmtInd)?" readOnly ":""%> />
	</td>
<% } else { %>
	<td class='fields' WIDTH='' nowrap  Display:none >
		<input type='hidden' name = 'dailyLmtChkBx<%=i%>' id = 'dailyLmtChkBx<%=i%>' value = 'N' />
		<input type='hidden' name = 'dailyLmtIndicator<%=i%>' id = 'dailyLmtIndicator<%=i%>' value = '' />
	</td>
	<td class='fields' WIDTH='' nowrap  Display:none >
		<input type='hidden' name = 'dailyLmtAmt<%=i%>' id = 'dailyLmtAmt<%=i%>' value = '' />
		<input type='hidden' name = 'dailyLmtGrossNetList<%=i%>' id='dailyLmtGrossNetList<%=i%>' value = '' />
	</td>
	<td class='fields' WIDTH='' nowrap  Display:none >
		<input type='hidden' name = 'dailyLmtQty<%=i%>' id = 'dailyLmtQty<%=i%>' value = '' />
	</td>
<% } %>			
<td  class='fields' nowrap WIDTH='60'>
<input type='checkbox'   <<%=disabledAll%> name='srvLimit_replace<%=i%>' <%=modifyStatus%> <%=srvLimit_replace.equals("Y")?"checked":""%>onClick='custSrvLimitChkReplace(this,"<%=i%>")' value="<%=srvLimit_replace%>"/>
<%if(srvLimit_replace.equals("Y")){%><a name='srvLimit_replace_dtls<%=i%>'  <%=disabledAll%> href='#'	onClick='custSrvLimitShowReplaceDtls("<%=i%>")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
<%}%><input type="hidden" name="srvLimit_replaceSrv_code<%=i%>" id="srvLimit_replaceSrv_code<%=i%>" value="<%=srvLimit_replaceSrv_code%>"><input type="hidden" name="srvLimit_replaceSrv_desc<%=i%>" id="srvLimit_replaceSrv_desc<%=i%>" value="<%=srvLimit_replaceSrv_desc%>" />
</td>

<td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=disabledAll%>		<%=modifyStatus%> name='srvLimit_refund<%=i%>' <%=srvLimit_refund.equals("Y")?"checked":""%> onClick='custSrvLimitChkRefund(this,"<%=i%>")' value="<%=srvLimit_refund%>"/><%if(srvLimit_refund.equals("Y")){%><input type='text' name='srvLimit_refundAmt<%=i%>' id='srvLimit_refundAmt<%=i%>' value='<%=srvLimit_refundAmt%>'   <%=modifyStatus%> <%=disabledAll%> onBlur='validPercentageForRefundCust(this,"srvLimit_autoRefund<%=i%>")' onkeypress='return allowValidNumber(this,event,"<%=noofdecimal%>")' size='2' maxlength='4'  ><%}%></td>
<td class='fields' nowrap WIDTH='60'><input type='checkbox'  <%=disabledAll%>	  <%=modifyStatus%> name='srvLimit_autoRefund<%=i%>' <%=srvLimit_auto_refund.equals("Y")?"checked":""%>	  <%=srvLimit_refundAmt.equals("")?" disabled":""%> onClick='chkCustAutoRefund(this,"srvLimit_refundAmt<%=i%>")' value="<%=srvLimit_auto_refund%>"/></td>
<td class='fields' nowrap WIDTH='80'>
<input type='checkbox' name='srvLimit_factor_appl<%=i%>' id='srvLimit_factor_appl<%=i%>' <%=disabledAll%>	 <%=modifyStatus%> <%=srvLimit_factor_appl.equals("Y")?"checked":""%> onClick='custSrvLimitFactorAppl(this,"<%=i%>")' value="<%=srvLimit_factor_appl%>" /></td>
<td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=modifyStatus%>	name='split_reqd<%=i%>' id='split_reqd<%=i%>' <%="Y".equals(exludeService)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);" <%= !"*".equals(dailyLmtInd)?" disabled ":"" %> ></td>

<td class='fields' nowrap WIDTH='50'><input type='checkbox' 	 <%=modifyStatus%> name='srvLimit_deleteService<%=i%>' onClick='chkCustSrvLimitDeleteService(this,"<%=i%>");' value='N'/></td>

</tr>
<%
}
}else{
%>
<tr>
<td class='fields' nowrap WIDTH=''> 
<%
if(type.equals("G")){
%>
<select name='srvLimit_type0' id='srvLimit_type0' <%=modifyStatus%> onChange='onCustSrvLimitServiceTypeChange(this,"0")'>
	<option value='C' ><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option>
	<option value='S' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>

<!-- Added By Muthukumar against KDAH-SCF-0057 on 30-4-12 Starts Here --> 
	<option value='M' ><fmt:message key="Common.item.label" bundle="${common_labels}"/></option>
	<option value='P' ><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"/></option>	
</select>
<%  
}else if(type.equals("P")){
%>
<select name='srvLimit_type0' id='srvLimit_type0' <%=modifyStatus%> onChange='onCustSrvLimitServiceTypeChange(this,"0")'>
<option value='C'><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option>
<option value='G'><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/></option>
<option value='S'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>
<option value='M'><fmt:message key="Common.item.label" bundle="${common_labels}"/></option>
<option value='T'><fmt:message key="eBL.SalesCategory.label" bundle="${bl_labels}"/> </option>
<option value='P'><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"/></option>
<!-- Added By Muthukumar against KDAH-SCF-0057 on 30-4-12 Ends Here -->
</select>
<%
}else{%>
<select name='srvLimit_type0' id='srvLimit_type0' <%=modifyStatus%> onChange='onCustSrvLimitServiceTypeChange(this,"0")'><option value='S' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option></select>
<%}
%>
</td>
					
<td class='fields' nowrap WIDTH=''>
	<input type='text' name='srvLimit_service_code0' id='srvLimit_service_code0'	<%=modifyStatus%> value='' size='10' onBlur="custSrvLimitCodeLookUp(srvLimit_service_desc0,this,srvLimit_type0,'0')">
	<input type='text' name = 'srvLimit_service_desc0' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="before_custSrvLimitServiceLookUp(this,srvLimit_service_code0,srvLimit_type0,'0')" value="">
	<INPUT type='hidden' name='srvLimit_service_code_temp0' id='srvLimit_service_code_temp0' value=''>
	<INPUT type='hidden' name='srvLimit_service_desc_temp0' id='srvLimit_service_desc_temp0' value=''>
	<input type='button' name='srvLimit_service_button0' id='srvLimit_service_button0' class='button' value='?'	 <%=modifyStatus%> onclick="custSrvLimitServiceLookUp(srvLimit_service_desc0,srvLimit_service_code0,srvLimit_type0,'0')"></td>

<td class='fields' nowrap WIDTH='60' ><input type='checkbox' name='exludeService0' id='exludeService0'	 <%=modifyStatus%> disabled  onClick='chkCustExludeService(this,"0");changeSplitReqd(this,"exclude","0");IncludeHomeMedicationcustExclude(this,srvLimit_service_code0,srvLimit_type0,"0");' value="" /></td>
			
<td class='fields' nowrap WIDTH=''><input type='text'    name='srvLimit_qty_limit0' id='srvLimit_qty_limit0'  	<%=modifyStatus%> size='5' disabled onBlur='chkCustSrvLimitQtyLimit(this);' onkeypress='return allowValidNumber(this,event,"<%=noofdecimal%>");' value="" /></td>

<td  class='fields' nowrap WIDTH=''>
<select name='srvLimit_amt_limit_ind0' id='srvLimit_amt_limit_ind0' onChange='validateCustInd(this,"0")' <%=modifyStatus%> >
<option value='' <%=(srvLimit_amt_limit_ind.equals("")?"selected":"")%> >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<option value='A' <%=(srvLimit_amt_limit_ind.equals("A")?"selected":"")%>><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
<option value='P'<%=(srvLimit_amt_limit_ind.equals("P")?"selected":"")%> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
</select>
</td>

<td class='fields' nowrap WIDTH=''><input type='text' name='srvLimit_amt_limit0' id='srvLimit_amt_limit0' 	<%=modifyStatus%> disabled size='5' maxlength='13' 	 <%=((srvLimit_amt_limit_ind.equals("")||srvLimit_amt_limit_ind.equals("U"))?"disabled":"")%> onBlur='chkCustSrvLimitAmtLimit(this,"0","<%=noofdecimal%>")' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>");' value=""/></td>
<td  class='fields' ><input type='text' name='srvLimit_roundTo0' id='srvLimit_roundTo0' size='3' <%=modifyStatus%> maxlength="3"  value=""  onkeypress=" return (allowValidNumber(this,event));"  /></td>
<td  class='fields' WIDTH='75' >
<select name='srvLimit_roundInd0' id='srvLimit_roundInd0'  <%=modifyStatus%>  onChange=""   >
<option value='U' <%=uSelect%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
<option value='D' <%=dSelect%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
</select>
</td>
<%if(ss){%>
	<td class='fields' nowrap WIDTH='75'>
		<input type='checkbox'   <%=modifyStatus%>	name='includeHomeMedication0' id='includeHomeMedication0' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%> <%="Y".equals(enableDisParam)?"":"disabled" %>  onclick="checkInclHomeMedi(this); IncludeHomeMedicationUnchkExclude(this,'custrateexclude','0');" >
		<input type='hidden' name='enableDisParam0' id='enableDisParam0' id='enableDisParam0' value="<%=enableDisParam%>"> </td>
<% } else{%>
	<td class='fields' nowrap WIDTH='' >
		<input type='hidden' 	<%=modifyStatus%> name='includeHomeMedication0' id='includeHomeMedication0' value='Y' > 
		<input type='hidden' name='enableDisParam0' id='enableDisParam0' id='enableDisParam0' value="Y"> </td>
<%} %>
<%if(dailyLimitSiteSpec) { %>
	<%-- <td class='fields' WIDTH='' nowrap >
		<input type='checkbox' name = 'dailyLmtChkBx0' id = 'dailyLmtChkBx0' <%=modifyStatus%> onclick = 'dailyLmtChkBxClick(this,0,document.cust_srvLimit_rate_based_dtl)' value='N' />
	</td>
	<td class='fields' WIDTH='' nowrap >
		<input type='text' name = 'dailyLmtAmt0' id = 'dailyLmtAmt0' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8540");' 
			onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")'; <%=modifyStatus%> disabled />
		<select name='dailyLmtGrossNetList0' id='dailyLmtGrossNetList0' id='dailyLmtGrossNetList0' <%=modifyStatus%> disabled >
			<option value='G'><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
			<option value='N'><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
		</select>
	</td> --%>
	<td class='fields' WIDTH='' nowrap >
		<select name='dailyLmtIndicator0' id='dailyLmtIndicator0' id='dailyLmtIndicator0' <%=modifyStatus%> <%=indicatorFldDisabled%> onchange='dailyLmtIndicatorOnChange(this,0,document.cust_srvLimit_rate_based_dtl)' >
			<option value="*"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
			<% if("G".equals(parDailyLmtInd) || "B".equals(parDailyLmtInd)) { %>
				<option value="G"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
			<% } if("I".equals(parDailyLmtInd) || "B".equals(parDailyLmtInd)) {%>
				<option value="I"><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
			<% } %>
		</select>
		<input type='hidden' name = 'dailyLmtChkBx0' id = 'dailyLmtChkBx0' value = '<%=dailyLmtChkYN%>' />
		<!-- <input type='hidden' name = 'dailyLmtGrossNetList0' id='dailyLmtGrossNetList0' value = '' /> -->
	</td>
	<td class='fields' WIDTH='' nowrap >
		<input type='text' name = 'dailyLmtAmt0' id = 'dailyLmtAmt0' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8540");' 
				onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>");' <%=modifyStatus%> <%=amtFldDisabled%> <%=indicatorFldDisabled%> 
				value='' readOnly />
		<select name='dailyLmtGrossNetList0' id='dailyLmtGrossNetList0' id='dailyLmtGrossNetList0' <%=modifyStatus%> <%=amtFldDisabled%> <%=indicatorFldDisabled%> <%="*".equals(dailyLmtInd)?" disabled ":""%> >
			<option value='G' <%="G".equals(dailyLmtGrossNet)?" selected ":""%> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
			<option value='N' <%="N".equals(dailyLmtGrossNet)?" selected ":""%> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
		</select>
	</td>
	<td class='fields' WIDTH='' nowrap >
		<input type='text' name = 'dailyLmtQty0' id = 'dailyLmtQty0' size='8' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,"BL8538");' 
				onkeypress='return allowValidNumber(this,event,10,0);' <%=modifyStatus%> <%=qtyFldDisabled%> <%=indicatorFldDisabled%> 
				value='' readOnly />
	</td>
<% } else { %>
	<td class='fields' WIDTH='' nowrap  Display:none >
		<input type='hidden' name = 'dailyLmtChkBx0' id = 'dailyLmtChkBx0' value = 'N' />
		<input type='hidden' name = 'dailyLmtIndicator0' id = 'dailyLmtIndicator0' value = '' />
	</td>
	<td class='fields' WIDTH='' nowrap  Display:none >
		<input type='hidden' name = 'dailyLmtAmt0' id = 'dailyLmtAmt0' value = '' />
		<input type='hidden' name = 'dailyLmtGrossNetList0' id='dailyLmtGrossNetList0' value = '' />
	</td>
	<td class='fields' WIDTH='' nowrap  Display:none >
		<input type='hidden' name = 'dailyLmtQty0' id = 'dailyLmtQty0' value = '' />
	</td>
<% } %>
<td  class='fields' nowrap WIDTH='60'>
<input type='checkbox'  disabled name='srvLimit_replace0' id='srvLimit_replace0' <%=modifyStatus%> onClick='custSrvLimitChkReplace(this,"0")' value=""/>
<input type="hidden" name="srvLimit_replaceSrv_code0" id="srvLimit_replaceSrv_code0" value=""><input type="hidden" name="srvLimit_replaceSrv_desc0" id="srvLimit_replaceSrv_desc0" value=""/>
</td>

<td class='fields' nowrap WIDTH='60'><input type='checkbox'   disabled	 <%=modifyStatus%> name='srvLimit_refund0'  onClick='custSrvLimitChkRefund(this,"0")' value=""/></td>
<td align="left" nowrap WIDTH='60'><input type='checkbox'   disabled	 <%=modifyStatus%> name='srvLimit_autoRefund0'    onClick='chkCustAutoRefund(this,"srvLimit_refundAmt0")' value=""/></td>
<td align="left" nowrap WIDTH='80'>
<input type='checkbox' name='srvLimit_factor_appl0' id='srvLimit_factor_appl0' disabled <%=modifyStatus%> onClick='custSrvLimitFactorAppl(this,"0")' value="" /></td>
<td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=modifyStatus%>	name='split_reqd0' id='split_reqd0' <%="Y".equals(exludeService)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);" <%= !"*".equals(dailyLmtInd)?" disabled ":"" %> ></td>
<td class='fields' nowrap WIDTH='50'><input type='checkbox'  name='srvLimit_deleteService0' id='srvLimit_deleteService0'	<%=modifyStatus%> onClick='chkCustSrvLimitDeleteService(this,"0");' value='N'/></td>

</tr>
<%}%>
 </table>
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="parent_type" id="parent_type" value="<%=type%>">
	<INPUT TYPE="hidden" name="packageCode" id="packageCode" value="<%=packageCode%>">
	<INPUT TYPE="hidden" name="parent_service_code" id="parent_service_code" value="<%=service_code%>">
	<INPUT TYPE="hidden" name="service_desc" id="service_desc" value="<%=srvLimit_service_desc%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>"> <!--V211130-->
	<input type="hidden" name='totalRecords' id='totalRecords' value="<%=totalRecords%>">
	<input type='hidden' name='parent_indx' id='parent_indx' value="<%=parent_indx%>">
	<input type='hidden' name='cust_grp_code' id='cust_grp_code' value="<%=cust_grp_code%>" />
	<input type='hidden' name='cust_grp_desc' id='cust_grp_desc' value="<%=cust_grp_desc%>" />
	<input type='hidden' name='cust_code' id='cust_code' value="<%=cust_code%>" />
	<input type='hidden' name='cust_desc' id='cust_desc' value="<%=cust_desc%>" />
	<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
	<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" />
	<INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
	<INPUT TYPE="hidden" name='type' id='type' value="<%=type%>">
	<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
	<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
	<input type='hidden' name='copyFrm_pkgCode' id='copyFrm_pkgCode' value="<%=copyFrm_pkgCode%>" />
	<INPUT TYPE="hidden" name="parent_service_ind" id="parent_service_ind" value="<%=type%>"> <!--Added by Muthu against the lookup issue -->
	<input type='hidden' name='siteId' id='siteId' id ='siteId' value='<%=ss %>' />
	<input type='hidden' name='dailyLimitSiteSpec' id='dailyLimitSiteSpec'  id='dailyLimitSiteSpec' value='<%=dailyLimitSiteSpec%>' ><!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->
	<input type="hidden" name="order_associated" id="order_associated" value="<%=order_associated%>">	<!-- Added V190404-DHANANJAY/MMS-DM-CRF-0129 -->
	<input type='hidden' name='modifyStatus' id='modifyStatus'  id='modifyStatus' value='<%=modifyStatus%>' ><!-- Added V190409-Aravindh/MMS-DM-CRF-0129 -->
	<input type='hidden' name='pkgServLimit' id='pkgServLimit'  id='pkgServLimit' value='<%=pkgServLimit%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='dailyPkgLmt' id='dailyPkgLmt'  id='dailyPkgLmt' value='<%=dailyPkgLmt%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='dailyLmtChkYN' id='dailyLmtChkYN'  id='dailyLmtChkYN' value='<%=dailyLmtChkYN%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='amtFldDisabled' id='amtFldDisabled'  id='amtFldDisabled' value='<%=amtFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='qtyFldDisabled' id='qtyFldDisabled'  id='qtyFldDisabled' value='<%=qtyFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='indicatorFldDisabled' id='indicatorFldDisabled'  id='indicatorFldDisabled' value='<%=indicatorFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='parDailyLmtInd' id='parDailyLmtInd'  id='parDailyLmtInd' value='<%=parDailyLmtInd%>' ><!-- Added V190731-Aravindh/MMS-DM-CRF-0129.1 --> 
 <%-- <script>///updateNoofExcln(<%=totalRecords%>,'1');</script> --%>
 <script>alignHeading();</script>
  </form> 
  
 </body>

 <%
  putObjectInBean(bean_id,bean,request);
 }catch(Exception e){
	System.out.println("Exception in PkgDefCustExclude.jsp="+e);
	e.printStackTrace();
 }
%>
</html>

