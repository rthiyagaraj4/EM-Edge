<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%	
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	boolean servGrpLimitSiteSpec = false;//21-10-2020
	//sarathkumar added code to make as siteSpecific saraa
	String siteSpecf=session.getAttribute("siteSpecf").toString();
	Boolean ss=Boolean.parseBoolean(siteSpecf); 

	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
	Connection con = null;
	Connection con1 = null;//21-10-2020
	boolean dailyLimitSiteSpec = false;
	try {
		con = ConnectionManager.getConnection(request);
		dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT");
	} catch(Exception ex) {
		System.err.println("Error in PkgDefExclude.jsp con: "+ex);
		ex.printStackTrace();
	}
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
	try {	//21-10-2020
		con1 = ConnectionManager.getConnection(request);	
		servGrpLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con1, "BL", "BL_ENABLE_PKG_SERV_IND_LIMIT");//MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 
	} catch(Exception ex) {
		System.err.println("Error in PkgDefExclude.jsp con1: "+ex);
		ex.printStackTrace();
	}//21-10-2020
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
	<script>
	$(document).ready(function(){
	//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated.
	if($('#dailyLimitSiteSpec').val() == true || $('#dailyLimitSiteSpec').val() == "true") { 
		if(parent.parent.PkgDefHeader.frmPkgDefHeader.orderAssociated.checked) {
		var formObj=document.srvLimit_rate_based_dtl;
		for(var cnt = 0; cnt < $('#totalRecords').val(); cnt++) {
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
		for(var ind = 0; ind < $('#totalRecords').val(); ind++) {//Added V190409-Aravindh/MMS-DM-CRF-0129
			var formObj=document.srvLimit_rate_based_dtl;
			dailyLmtChkBxClickPharma(eval("formObj.srvLimit_service_code"+ind),eval("formObj.srvLimit_type"+ind),ind);
		}
	} *///Commented V190626-Aravindh/MMS-DM-CRF-0129.1/No need to check for PH service or not
	});
	</script>
</head>
<!-- Function name(moveFrame_Exclude()) is changed by Nmuthu against 32308 on 13-4-12 -->
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onscroll='moveFrame_Exclude()' onLoad='chkExludeServiceonload();includeHomeMedicationEnable();'>
<%
	String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");
	String locale			= (String)session.getAttribute("LOCALE");
	String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		
	//Added By Vijay for GHL-SCF
	String newDateAddedFlag= request.getParameter("new_date_added")==null ? "" :request.getParameter("new_date_added") ;	
	String type=request.getParameter("type");
	String service_code=request.getParameter("service_code");
	int totalRecords=1;
	String disabled="disabled";
	String disabledAll="";
	String packageCode		=	"" ;
	String copyFrm_pkgCode		=	"" ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
	String parent_indx		=	request.getParameter("parent_indx") == null ? "" :request.getParameter("parent_indx") ;
	String      dtlsDisp = "none";
	String      refndDisp = "none";
	String uSelect = "";
	String dSelect ="";
	String	amtLmtIndNullDisplay	= "";
	String	amtLmtIndAmtDisplay		= "";
	String	amtLmtIndPerDisplay		= "";
	String	perAmt_limitStatus		= "";
	String		splitReqd = "Y";	//Split reqd
	String      includeHomeMedication = "N";  //sarathkumar InclHmeMedi
	String      enableDisParam = "N";  //sarathkumar InclHmeMedi
	String 		dailyLmtChkYN = "N";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtGrossNet = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "", qtyFldDisabled = "", indicatorFldDisabled = "";//Added V190625-Aravindh/MMS-DM-CRF-0129.1
	
	String bean_id		= "bl_PkgDefBean" ;
	String bean_name	= "eBL.PkgDefBean";
	PkgDefBean bean		= (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;	
	String order_associated = request.getParameter("orderAssociated") == null ? "N" : request.getParameter("orderAssociated"); // Added V190404-dhananjay/MMS-DM-CRF-0129
		
	try
	{
	int noofdecimal = Integer.parseInt(bean.getNoOfDecimal());

	HashMap excludedItems_RB    =   new HashMap();
	HashMap excludedItemsFD_RB  =   new HashMap();
	//HashMap excludedItemsSR_RB  =   new HashMap();

	String deletedStatusRBLt = bean.getDeletedStatusRBLt();

	excludedItems_RB    =  bean.getExcludedItems_RB();	
   
	if(excludedItems_RB.size()>0 && excludedItems_RB.containsKey(fromDate))
	{
		excludedItemsFD_RB = (HashMap)excludedItems_RB.get(fromDate);
  	}
   
	if(mode.equals("modify") && deletedStatusRBLt.equals("N") && !(excludedItemsFD_RB.containsKey(service_code)))
	{	
		//Added By Vijay FOr GHL-SCF
		bean.setNewDateAddedFlag(newDateAddedFlag);
		//ends
		System.out.println("bean.getNewDateAddedFlag "+bean.getNewDateAddedFlag());
		bean.setDBValues("SRVLIMIT_RATE_BASED",packageCode,locale,facilityId,service_code,"",fromDate); //set database values to bean.
		bean.setModifyRateSrvLimits("Y");	
		excludedItems_RB    =  bean.getExcludedItems_RB();
	}

	//HashMap includedItems_RB = bean.getIncludedItems_RB();// unused variable.
	/*HashMap includedItemsFD_RB = new HashMap();
	if(includedItems_RB.containsKey(packageCode))
		includedItemsFD_RB = (HashMap)includedItems_RB.get(packageCode);  */
   
	String srvLimit_type		="";
	String 		srvLimit_service_code			="";
	String 	    srvLimit_service_desc		="";
	String 		exludeService			="N";
	String 		srvLimit_qty_limit		="";
	String 		srvLimit_amt_limit			="";
	String 		srvLimit_factor_appl			="";	
	String 		srvLimit_amt_limit_ind	="";
	String 	    srvLimit_replace		="N";
//	String 		srvLimit_replaceSrv_code="N"; COMMENTED FOR IN020833 AND ADDED BELOW
	String 		srvLimit_replaceSrv_code="";
	String		srvLimit_replaceSrv_desc = "";
	String 		srvLimit_refund		="N";
	String 		srvLimit_refundAmt		="";
	String 		srvLimit_auto_refund			="N";
	String      srvLimit_roundTo = "";
	String      srvLimit_roundInd = "";

	ArrayList	srvLimit_type_list	    =	new ArrayList();
	ArrayList	srvLimit_service_code_list    =	new ArrayList();
	ArrayList	srvLimit_service_desc_list	    =	new ArrayList();
	ArrayList	exludeService_list		    =	new ArrayList();
	ArrayList	srvLimit_qty_limit_list		    =	new ArrayList();
	ArrayList	srvLimit_amt_limit_list		    =	new ArrayList();
	ArrayList	srvLimit_factor_appl_list		    =	new ArrayList();
	ArrayList   amt_limit_ind_list			=	new ArrayList();
	ArrayList	srvLimit_replace_list				=	new ArrayList();
	ArrayList	srvLimit_replaceSrv_code_list		=	new ArrayList();
	ArrayList   srvLimit_refund_list					=	new ArrayList();
	ArrayList   srvLimit_refundAmt_list				=	new ArrayList();
	ArrayList   srvLimit_auto_refund_list			=	new ArrayList();
	ArrayList	srvLimit_roundTo_list			=	new ArrayList();
	ArrayList	srvLimit_roundInd_list		 =	new ArrayList();
	ArrayList	srvLimit_replaceSrv_desc_list		=	new ArrayList();
	ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
	ArrayList   includeHomeMedication_list= new ArrayList();//sarathkumar InclHmeMedi
	ArrayList   enableDisParam_list= new ArrayList();//sarathkumar InclHmeMedi
	ArrayList	rBServiceLimits    =	new ArrayList();
	ArrayList dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
	ArrayList dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
	ArrayList dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
	ArrayList dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
	ArrayList dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
	
	if(excludedItems_RB.size()>0 && excludedItems_RB.containsKey(fromDate))
	{
		excludedItemsFD_RB = (HashMap)excludedItems_RB.get(fromDate);
	
		if(excludedItemsFD_RB.size()>0 && excludedItemsFD_RB.containsKey(service_code) )
		{
			rBServiceLimits =(ArrayList)excludedItemsFD_RB.get(service_code);
			
			if(rBServiceLimits.size()>0)
			{
				srvLimit_type_list		= (ArrayList)rBServiceLimits.get(0);
				srvLimit_service_code_list		= (ArrayList)rBServiceLimits.get(1);
				srvLimit_service_desc_list	= (ArrayList)rBServiceLimits.get(2);
				exludeService_list		= (ArrayList)rBServiceLimits.get(3);
				srvLimit_qty_limit_list			= (ArrayList)rBServiceLimits.get(4);
				srvLimit_amt_limit_list		= (ArrayList)rBServiceLimits.get(5);	
				srvLimit_factor_appl_list		= (ArrayList)rBServiceLimits.get(6);
				amt_limit_ind_list		= (ArrayList)rBServiceLimits.get(7);	
				srvLimit_replace_list		= (ArrayList)rBServiceLimits.get(8);
				srvLimit_replaceSrv_code_list	= (ArrayList)rBServiceLimits.get(9);	
				srvLimit_refund_list		= (ArrayList)rBServiceLimits.get(10);
				srvLimit_refundAmt_list		= (ArrayList)rBServiceLimits.get(11);
				srvLimit_auto_refund_list		= (ArrayList)rBServiceLimits.get(12);	
				srvLimit_roundTo_list		= (ArrayList)rBServiceLimits.get(13);
				srvLimit_roundInd_list		= (ArrayList)rBServiceLimits.get(14);
				srvLimit_replaceSrv_desc_list		= (ArrayList)rBServiceLimits.get(15);
				split_reqd_list	=	(ArrayList)rBServiceLimits.get(16);//Split reqd
				
				includeHomeMedication_list =(ArrayList)rBServiceLimits.get(17); //sarathkumar InclHmeMedi
				enableDisParam_list =(ArrayList)rBServiceLimits.get(18);
				if(rBServiceLimits.size()>19){
					dailyLmtChkBxList = (ArrayList)rBServiceLimits.get(19); //Added V190320-Aravindh/MMS-DM-CRF-0129
				}
				if(rBServiceLimits.size()>20){
					dailyLmtAmtList = (ArrayList)rBServiceLimits.get(20); //Added V190320-Aravindh/MMS-DM-CRF-0129
				}
				if(rBServiceLimits.size()>21){
					dailyLmtGrossNetList = (ArrayList)rBServiceLimits.get(21); //Added V190320-Aravindh/MMS-DM-CRF-0129
				}
				if(rBServiceLimits.size()>=22){
					dailyLmtIndicatorList = (ArrayList)rBServiceLimits.get(22); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
				}
				if(rBServiceLimits.size()>=23){
					dailyLmtQtyList = (ArrayList)rBServiceLimits.get(23); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
				}
				
				if(srvLimit_service_code_list.size()>0){
						totalRecords=srvLimit_service_code_list.size();
						disabled	="";	
					}
				}
			}
		}
		
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
		String parDailyLmtInd = request.getParameter("dailyLmtInd") == null ? "*" : request.getParameter("dailyLmtInd");//Added V190731-Aravindh/MMS-DM-CRF-0129.1
%>

<form name='srvLimit_rate_based_dtl' id='srvLimit_rate_based_dtl'  target='messageFrame' >

	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="parent_type" id="parent_type" value="<%=type%>">
	<INPUT TYPE="hidden" name="parent_service_code" id="parent_service_code" value="<%=service_code%>">
	<INPUT TYPE="hidden" name="parent_service_ind" id="parent_service_ind" value="<%=type%>"> <!--Added by lakshmi against the lookup issue -->
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<%-- <input type="hidden" name='totalRecords' id='totalRecords' value="<%=totalRecords%>"> --%>
	<input type='hidden' name='parent_indx' id='parent_indx' value="<%=parent_indx%>">
	<input type='hidden' name='fromDate' id='fromDate'  id='fromDate' value="<%=fromDate%>" />
	<INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
	<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
	<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
	<input type="hidden" name="order_associated" id="order_associated" value="<%=order_associated%>">	 <!-- Added V190404-dhananjay/MMS-DM-CRF-0129 -->
<!--<table id="tableheader" border="1" width="100%" cellspacing='0' cellpadding='3'>
	<table id="srvLimit_rate_based_tbl" border="1" width="100%" cellspacing='0' cellpadding='3'>-->

<table class = 'grid' width='100%' id="srvLimit_rate_based_tbl"  cellpadding='3' cellspacing='0' border="1" height="">

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

	for(int i=0; i<totalRecords; i++)
	{	 
		if(srvLimit_service_code_list.size()>0)
		{
			srvLimit_type		= (String)srvLimit_type_list.get(i);
			srvLimit_service_code		= (String)srvLimit_service_code_list.get(i);
		    	srvLimit_service_desc	=(String) srvLimit_service_desc_list.get(i);
			exludeService		=(String) exludeService_list.get(i);
			srvLimit_qty_limit		= (String)srvLimit_qty_limit_list.get(i);
			srvLimit_amt_limit		= (String)srvLimit_amt_limit_list.get(i);
			srvLimit_factor_appl	= (String)srvLimit_factor_appl_list.get(i);
			srvLimit_amt_limit_ind	= (String)amt_limit_ind_list.get(i);		
			srvLimit_replace= (String)srvLimit_replace_list.get(i);				
			srvLimit_replaceSrv_code= (String)srvLimit_replaceSrv_code_list.get(i);		
			srvLimit_refund	= (String)srvLimit_refund_list.get(i);				
			srvLimit_refundAmt	= (String)srvLimit_refundAmt_list.get(i);			
			srvLimit_auto_refund= (String)srvLimit_auto_refund_list.get(i);			
			srvLimit_roundTo		= (String)srvLimit_roundTo_list.get(i);
			
			srvLimit_roundInd		= (String)srvLimit_roundInd_list.get(i);
			srvLimit_replaceSrv_desc		= (String)srvLimit_replaceSrv_desc_list.get(i);
			splitReqd	= 	(String)split_reqd_list.get(i);
			includeHomeMedication	= 	(String)includeHomeMedication_list.get(i); //sarathkumar InclHmeMedi
			enableDisParam	= 	(String)enableDisParam_list.get(i); //sarathkumar InclHmeMedi
			/* Commented V190819-Aravindh/MMS-DM-CRF-0129.1/Below line */
			//dailyLmtChkYN = (String) dailyLmtChkBxList.get(i);//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtAmt = (String) dailyLmtAmtList.get(i);//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtGrossNet = (String) dailyLmtGrossNetList.get(i);//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtInd = (String) dailyLmtIndicatorList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			if("".equals(dailyLmtInd)){
				dailyLmtInd = "*";
			}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			dailyLmtQty = (String) dailyLmtQtyList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		}
		
		if(exludeService==null || exludeService.equals("") || exludeService.equals("null"))
			exludeService="N";
			if(exludeService.equals("Y"))
			disabledAll="disabled";
		else
		   disabledAll="";
		if(srvLimit_replace.equals("Y"))
			  dtlsDisp = "inline";
		if(srvLimit_refund.equals("Y"))
			refndDisp = "inline";
	
		uSelect = srvLimit_roundInd.equals("U")? " selected "	 :"";
		dSelect = srvLimit_roundInd.equals("D")? " selected "	 :"";

		if(srvLimit_amt_limit_ind.equals("A"))
		{
			amtLmtIndNullDisplay    = "";
			amtLmtIndAmtDisplay		= " selected";
			amtLmtIndPerDisplay		= "";
			perAmt_limitStatus      ="";
		}
		else if(srvLimit_amt_limit_ind.equals("P"))
		{
			amtLmtIndNullDisplay    = "";
			amtLmtIndAmtDisplay		= "";
			amtLmtIndPerDisplay		= "selected";
			perAmt_limitStatus      ="";
		}
		else
		{
			amtLmtIndNullDisplay = "selected";
			amtLmtIndAmtDisplay		= "";
			amtLmtIndPerDisplay		= "";
			perAmt_limitStatus      =" disabled";
		}
		if(disabledAll.equals("disabled"))
			   perAmt_limitStatus = " disabled";
		
		%>		   
<tr>
<td class='fields' nowrap WIDTH=''> 
<%
if(type.equals("G")){
%>
	<select name='srvLimit_type<%=i%>' id='srvLimit_type<%=i%>'  <%=modifyStatus%> onChange='onSrvLimitServiceTypeChange(this,"<%=i%>")'>
		<option value='C' <%=srvLimit_type.equals("C")?"selected":""%>>
		<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option>
		<option value='S' <%=srvLimit_type.equals("S")?"selected":""%>>
		<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>

	<!-- Added By Muthukumar on 18-11-11 Reg Balaraman Issue  -->
		<option value='M' <%=srvLimit_type.equals("M")?"selected":""%>>
		<fmt:message key="Common.item.label" bundle="${common_labels}"/></option>
	<!-- Added By Muthukumar on 18-11-11 Reg Balaraman Issue  -->

	<!-- Above line is Added by Muthu against CRF on 22-2-12 -->
		<option value='P' <%=srvLimit_type.equals("P")?"selected":""%>>
		<fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"/></option>
	<!-- Above line is Added by Muthu against CRF on 22-2-12 -->
	</select>
<%  
}
else if(type.equals("P")){
%>
	<select name='srvLimit_type<%=i%>' id='srvLimit_type<%=i%>' id='type<%=i%>' <%=modifyStatus%> onChange='onSrvLimitServiceTypeChange(this,"<%=i%>")'>
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
	</select>
<%
}
else{
%>
	<select name='srvLimit_type<%=i%>' id='srvLimit_type<%=i%>' id='type<%=i%>' <%=modifyStatus%> onChange='onSrvLimitServiceTypeChange(this,"<%=i%>")'>	
		<option value='S' <%=srvLimit_type.equals("S")?"selected":""%>>
		<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>
		</option>
	</select>
<%
}
%>
</td>

<!-- Added Newly on 13-3-12 by Muthukumar -->					
<td class='fields' nowrap WIDTH=''>
<!-- Removed V190626-Aravindh/MMS-DM-CRF-0129.1/ removed calling new function dailyLmtChkBxClickPharma -->
<input type='text' name='srvLimit_service_code<%=i%>' id='srvLimit_service_code<%=i%>'  <%=modifyStatus%> value='<%=srvLimit_service_code%>' size='10' onBlur="srvLimitCodeLookUp(srvLimit_service_desc<%=i%>,this,srvLimit_type<%=i%>,'<%=i%>'); IncludeHomeMedicationCheck(srvLimit_service_code<%=i%>,srvLimit_type<%=i%>,'<%=i%>');">

<input type='text' name = 'srvLimit_service_desc<%=i%>' size='10' <%=modifyStatus%> maxlength='10' onBlur="before_srvLimitServiceLookUp(this,srvLimit_service_code<%=i%>,srvLimit_type<%=i%>,'<%=i%>');IncludeHomeMedicationCheck(srvLimit_service_code<%=i%>,srvLimit_type<%=i%>,'<%=i%>');" value="<%=srvLimit_service_desc%>">

<INPUT type='hidden' name='srvLimit_service_code_temp<%=i%>' id='srvLimit_service_code_temp<%=i%>' value=''>
<INPUT type='hidden' name='srvLimit_service_desc_temp<%=i%>' id='srvLimit_service_desc_temp<%=i%>' value=''>
<!-- Removed V190626-Aravindh/MMS-DM-CRF-0129.1/ removed calling new function dailyLmtChkBxClickPharma -->
<input type='button' name='srvLimit_service_button<%=i%>' id='srvLimit_service_button<%=i%>' class='button' value='?' onclick="srvLimitServiceLookUp(srvLimit_service_desc<%=i%>,srvLimit_service_code<%=i%>,srvLimit_type<%=i%>, '<%=i%>');IncludeHomeMedicationCheck(srvLimit_service_code<%=i%>,srvLimit_type<%=i%>,'<%=i%>');">
</td>

<td class='fields' nowrap WIDTH='55' ><input type='checkbox' name='exludeService<%=i%>' id='exludeService<%=i%>' id='exludeService<%=i%>' <%=modifyStatus%> <%=disabled%> <%=exludeService.equals("Y")?"checked":""%> onClick='chkExludeService(this,"<%=i%>");changeSplitReqd(this,"exclude","<%=i%>");IncludeHomeMedicationExclude(this,srvLimit_service_code<%=i%>,srvLimit_type<%=i%>,"<%=i%>");' value="<%=exludeService%>" /></td>
			
<td class='fields' nowrap WIDTH=''><input type='text'    name='srvLimit_qty_limit<%=i%>' id='srvLimit_qty_limit<%=i%>' <%=modifyStatus%>   size='8' <%=disabledAll%> onBlur='chkSrvLimitQtyLimit(this);' onkeypress='return allowValidNumber1_temp(this,event,"2");' value="<%=srvLimit_qty_limit%>" /></td>

<td  class='fields' nowrap WIDTH=''>
<select name='srvLimit_amt_limit_ind<%=i%>' id='srvLimit_amt_limit_ind<%=i%>'	<%=modifyStatus%> onChange='validateInd(this,"<%=i%>","srvLimit_amt_limit","srvLimit_factor_appl","srvLimit_qty_limit")' <%=disabledAll%>>
<option value='' <%=amtLmtIndNullDisplay%>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<option value='A' <%=amtLmtIndAmtDisplay%>><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
<option value='P' <%=amtLmtIndPerDisplay%>><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
</select>
</td>

<td class='fields' nowrap WIDTH=''><input type='text' name='srvLimit_amt_limit<%=i%>' id='srvLimit_amt_limit<%=i%>'  <%=modifyStatus%>  <%=perAmt_limitStatus%>   size='6' maxlength='13'  onBlur='chkSrvLimitAmtLimit(this,"<%=i%>","<%=noofdecimal%>")' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>");' value="<%=srvLimit_amt_limit%>"/></td>
<td  class='fields' ><input type='text' name='srvLimit_roundTo<%=i%>' id='srvLimit_roundTo<%=i%>' size='6' <%=modifyStatus%>   value="<%=srvLimit_roundTo%>" <%=disabledAll%> onkeypress=" return (allowValidNumber1(this,event));"  /></td>
<td  class='fields' nowrap WIDTH=''>
<select name='srvLimit_roundInd<%=i%>' id='srvLimit_roundInd<%=i%>' <%=disabledAll%>   onChange="" <%=modifyStatus%>>
<option value='U' <%=uSelect%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
<option value='D' <%=dSelect%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
</select>
</td>

<%if(ss){ 
%>
<!-- 	//sarathkumar InclHmeMedi  -->
<td class='fields' WIDTH='75' nowrap ><input type='checkbox' <%=modifyStatus%> name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%>  <%="Y".equals(enableDisParam)?"":"disabled"%> onclick='checkInclHomeMedi(this); IncludeHomeMedicationUnchkExclude(this,"rateexclude","<%=i%>");' > </td> 
<input type='hidden'  <%=modifyStatus%> name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value='<%=enableDisParam %>'> </td>
<% } else{%>
	<td><input type='hidden'   name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>'  value='Y' >
	<input type='hidden'   name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value='Y' </td>
<%} %>
<!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->
<!-- Modified V190626-Aravindh/MMS-DM-CRF-0129.1 -->
<%if(dailyLimitSiteSpec) { %>
	<%-- <td class='fields' WIDTH='' nowrap >
	<!-- Added V190404-dhananjay/MMS-DM-CRF-0129/ disabling dailyLmtChkBx  field if it is pharmacy -->
		<input type='checkbox' name = 'dailyLmtChkBx<%=i%>' id = 'dailyLmtChkBx<%=i%>' <%=modifyStatus%> onclick = 'dailyLmtChkBxClick(this,<%=i%>,document.srvLimit_rate_based_dtl)' value='<%=dailyLmtChkYN %>' <%="Y".equals(dailyLmtChkYN)?" checked ":""%> />
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
		<select name='dailyLmtIndicator<%=i%>' id='dailyLmtIndicator<%=i%>' id='dailyLmtIndicator<%=i%>' <%=modifyStatus%> <%=indicatorFldDisabled%> onchange = 'dailyLmtIndicatorOnChange(this,<%=i%>,document.srvLimit_rate_based_dtl)' >
			<option value="*"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
			<% if("G".equals(parDailyLmtInd) || "B".equals(parDailyLmtInd)) { %>
				<option value="G" <%="G".equals(dailyLmtInd)?" selected ":""%> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
			<% } if("I".equals(parDailyLmtInd) || "B".equals(parDailyLmtInd)) {%>
				<option value="I" <%="I".equals(dailyLmtInd)?" selected ":""%> ><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
			<% } %>
		</select>
		<input type='hidden' name = 'dailyLmtChkBx<%=i%>' id = 'dailyLmtChkBx<%=i%>' value = '<%=dailyLmtChkYN%>' />
		<%-- <input type='hidden' name = 'dailyLmtAmt<%=i%>' id = 'dailyLmtAmt<%=i%>' value = '' /> --%>
		<%-- <input type='hidden' name = 'dailyLmtGrossNetList<%=i%>' id='dailyLmtGrossNetList<%=i%>' value = '' /> --%>
	</td>
	<td class='fields' WIDTH='' nowrap >
		<input type='text' name = 'dailyLmtAmt<%=i%>' id = 'dailyLmtAmt<%=i%>' size='8' maxlength='13' onBlur='return checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8540");' 
				onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>");' <%=modifyStatus%> <%=amtFldDisabled%> <%=indicatorFldDisabled%> 
				value='<%=dailyLmtAmt %>'  <%="*".equals(dailyLmtInd)?" readOnly ":""%> />
		<select name='dailyLmtGrossNetList<%=i%>' id='dailyLmtGrossNetList<%=i%>' id='dailyLmtGrossNetList<%=i%>' <%=modifyStatus%> <%=amtFldDisabled%> <%=indicatorFldDisabled%> <%="*".equals(dailyLmtInd)?" disabled ":""%> >
			<option value='G' <%="G".equals(dailyLmtGrossNet)?" selected ":""%> ><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
			<option value='N' <%="N".equals(dailyLmtGrossNet)?" selected ":""%> ><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
		</select>
	</td>
	<td class='fields' WIDTH='' nowrap >
		<input type='text' name = 'dailyLmtQty<%=i%>' id = 'dailyLmtQty<%=i%>' size='8' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,"BL8538");' 
				onkeypress='return allowValidNumber(this,event,10,0);' <%=modifyStatus%> <%=qtyFldDisabled%> <%=indicatorFldDisabled%> 
				value='<%=dailyLmtQty %>'  <%="*".equals(dailyLmtInd)?" readOnly ":""%> />
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
	<input type='checkbox'   <%=disabledAll%> name='srvLimit_replace<%=i%>' <%=modifyStatus%> <%=srvLimit_type.equals("S")?"":" disabled "%> <%=srvLimit_replace.equals("Y")?" checked ":""%>onClick='srvLimitChkReplace(this,"<%=i%>")' value="<%=srvLimit_replace%>"/>
	<a name='srvLimit_replace_dtls<%=i%>' id='srvLimit_replace_dtls<%=i%>' href='#'	style ='display:<%=dtlsDisp%>' onClick='srvLimitShowReplaceDtls("<%=i%>")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a><input type="hidden" name="srvLimit_replaceSrv_code<%=i%>" id="srvLimit_replaceSrv_code<%=i%>" value="<%=srvLimit_replaceSrv_code%>"><input type="hidden" name="srvLimit_replaceSrv_desc<%=i%>" id="srvLimit_replaceSrv_desc<%=i%>" value="<%=srvLimit_replaceSrv_desc%>"/>
	</td>

	<td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=disabledAll%>	<%=modifyStatus%>  <%=srvLimit_type.equals("S")?"":" disabled "%> name='srvLimit_refund<%=i%>' <%=srvLimit_refund.equals("Y")?" checked":""%> onClick='srvLimitChkRefund(this,"<%=i%>")' value="<%=srvLimit_refund%>"/><input type='text' name='srvLimit_refundAmt<%=i%>' id='srvLimit_refundAmt<%=i%>' value='<%=srvLimit_refundAmt%>'   <%=modifyStatus%> style ='display:<%=refndDisp%>' onkeypress='return ChkNumberInput(this,event,"<%=noofdecimal%>")' onBlur='validPercentageForRefund(this,"srvLimit_autoRefund<%=i%>")' size='2' maxlength ='4' ></td>
	<td align="left" nowrap WIDTH='80'><input type='checkbox'   <%=disabledAll%>  <%=modifyStatus%>	<%=srvLimit_refundAmt.equals("")?" disabled ":""%> name='srvLimit_autoRefund<%=i%>' <%=srvLimit_auto_refund.equals("Y")?" checked ":""%> onClick='chkautoRefund(this,"srvLimit_refundAmt<%=i%>")' value="<%=srvLimit_auto_refund%>"/></td>
	<td class='fields' nowrap WIDTH='60'>
	<input type='checkbox' name='srvLimit_factor_appl<%=i%>' id='srvLimit_factor_appl<%=i%>' <%=disabledAll%>	<%=modifyStatus%>  <%=srvLimit_factor_appl.equals("Y")?" checked ":""%>	<%=srvLimit_amt_limit_ind.equals("A")?"":" disabled "%> onClick='srvLimitFactorAppl(this,"<%=i%>")' value="<%=srvLimit_factor_appl%>" /></td>
	<td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=modifyStatus%>	<%="Y".equals(exludeService)?"disabled":"" %> name='split_reqd<%=i%>' id='split_reqd<%=i%>' value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);" <%= !"*".equals(dailyLmtInd)?" disabled ":"" %> ></td>
	<td class='fields' nowrap WIDTH='50'><input type='checkbox'  <%=modifyStatus%> name='srvLimit_deleteService<%=i%>' onClick='chkSrvLimitDeleteService(this,"<%=i%>");' value='N'/></td>

</tr>
<%
}
%>
	</table>
	<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type='hidden' name='from_date' id='from_date' id='from_date' value='<%=fromDate %>'>
	<input type="hidden" id="totalRecords" name="totalRecords" id="totalRecords" value="<%=totalRecords%>"> <!-- saraa -->
	<input type='hidden' name='siteSpecf' id='siteSpecf'  id='siteSpecf' value='<%=siteSpecf%>'> <!-- saraa -->
	<input type='hidden' name='dailyLimitSiteSpec' id='dailyLimitSiteSpec'  id='dailyLimitSiteSpec' value='<%=dailyLimitSiteSpec%>' ><!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->
	<input type='hidden' name='modifyStatus' id='modifyStatus'  id='modifyStatus' value='<%=modifyStatus%>' ><!-- Added V190409-Aravindh/MMS-DM-CRF-0129 -->
	<input type='hidden' name='pkgServLimit' id='pkgServLimit'  id='pkgServLimit' value='<%=pkgServLimit%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='dailyPkgLmt' id='dailyPkgLmt'  id='dailyPkgLmt' value='<%=dailyPkgLmt%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='dailyLmtChkYN' id='dailyLmtChkYN'  id='dailyLmtChkYN' value='<%=dailyLmtChkYN%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='amtFldDisabled' id='amtFldDisabled'  id='amtFldDisabled' value='<%=amtFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='qtyFldDisabled' id='qtyFldDisabled'  id='qtyFldDisabled' value='<%=qtyFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='indicatorFldDisabled' id='indicatorFldDisabled'  id='indicatorFldDisabled' value='<%=indicatorFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='parDailyLmtInd' id='parDailyLmtInd'  id='parDailyLmtInd' value='<%=parDailyLmtInd%>' >
	<input type='hidden' name='servGrpLimitSiteSpec' id='servGrpLimitSiteSpec'  id='servGrpLimitSiteSpec' value='<%=servGrpLimitSiteSpec%>' ><!-- Added V190731-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value="<%=facilityId%>" >
	<script>updateNoofExcln(<%=totalRecords%>,'1');</script>
	<script>alignHeading_Exclude();</script><!-- Function name is changed by Nmuthu against 32308 on 13-4-12 -->
	</form> 
<%}
	catch(Exception e)
	{
		System.out.println("Exception from package definition  Rate based exclusions:"+e);
		e.printStackTrace();
	}
%>
 </body>
 <%putObjectInBean(bean_id,bean,request);%>
</html>

