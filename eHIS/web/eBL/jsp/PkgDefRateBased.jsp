<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*, eBL.PkgDefBean, java.sql.*, webbeans.eCommon.*" %>
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
	boolean servGrpLimitSiteSpec = false; //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	//sarathkumar added code to make as siteSpecific 	//sarathkumar InclHmeMedi 
	String siteSpecf=session.getAttribute("siteSpecf").toString();
	Boolean ss=Boolean.parseBoolean(siteSpecf); 			
	System.out.println("siteSpecf" + ss);
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
	Connection con = null;
	con = ConnectionManager.getConnection(request);
	boolean dailyLimitSiteSpec = false;
	try {				
		dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT");
	} catch(Exception ex) {
		System.err.println("Error in PkgDefRateBased.jsp: "+ex);
		ex.printStackTrace();
	}
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
	//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	try {			
		servGrpLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_PKG_SERV_IND_LIMIT");//MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020 
	} catch(Exception ex) {
		System.err.println("Error in PkgDefRateBased.jsp: "+ex);
		ex.printStackTrace();
	}
	//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


	
	
	<script>
	
	/* Added By Vijay A.P. for GHL-SCF-1086  */
	
	$(document).ready(function(){
	
		//Added By Vijay for GHL-SCF
		var new_added_date=	parent.parent.frames[1].frames[0].document.forms[0].new_date_added.value;
		//alert('new_added_date '+new_added_date);
		$('#new_added_date').val(new_added_date);			
//ends 
		 var totalrecords=parent.parent.PkgDefBaseDateMain.baseDateDtl.document.getElementById('totRec').value;
		 totalrecords=totalrecords-1;
		 var fromDate= parent.parent.PkgDefBaseDateMain.baseDateDtl.document.getElementById("from_date").value;
		 var firstDate=$(parent.parent.PkgDefBaseDateMain.baseDateDtl.document).find('#fromDate_'+totalrecords).val();
		 if(fromDate==""||fromDate==null||fromDate=="undefined"||fromDate=="undefined")
			 {
		 fromDate=firstDate;
			 }
	
	$('#from_date').val(fromDate);
	
		//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated.
		if($('#dailyLimitSiteSpec').val() == true || $('#dailyLimitSiteSpec').val() == "true") { 
			if(parent.parent.PkgDefHeader.frmPkgDefHeader.orderAssociated.checked) {
				var formObj=document.rate_based_dtl;
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
				var formObj=document.rate_based_dtl;
				dailyLmtChkBxClickPharma(eval("formObj.service_code"+ind),eval("formObj.type"+ind),ind);
			}
		} *///Commented V190626-Aravindh/MMS-DM-CRF-0129.1/No need to check for PH service or not
	});
	/*  *** ends ***     */
	
	</script>	

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onscroll='moveFrame()' onLoad='includeHomeMedicationEnable();'>
<%

	System.out.println("this is from PkgDefRateBased.jsp");
	String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");
	String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
	System.out.println("fromDate PkgDefRateBased.jsp "+fromDate);
	String fromDateTemp = "";
	String fromDateVals			 = request.getParameter("fromDateVals")==null ? "" :request.getParameter("fromDateVals") ;
	String custCode			 = request.getParameter("custCode")==null ? "" :request.getParameter("custCode") ;

	String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N":request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
		 modifyStatus = " disabled ";

	String locale			= (String)session.getAttribute("LOCALE");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String order_associated=request.getParameter("orderAssociated") == null ? "N" : request.getParameter("orderAssociated");
	String acrossEncounters	= request.getParameter("acrossEncounters") == null ? "N" : request.getParameter("acrossEncounters");
	String disabled="disabled";
	int totalRecords=1;
	
	String ordCatDisabled="disabled";
	if(order_associated.equals("Y")){	
		ordCatDisabled="";
	}

	String packageCode		=	"" ;
	String copyFrm_pkgCode		=	"" ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
		String type		="";
	String 		service_code			="";
	String 	    service_desc		="";
	String 		catalog_code			="";
	String 		catalog_desc		="";
	String 		ind			="";
	String 		factorOrRate		="";
	String 		qty_limit			="";
	String 		amt_limit_ind		="";
	String 		amt_limit		="";
	//String 		unlimited			="N";
	String 		replace		="N";
	String 		replaceSrv_code		="";
	String 		replaceSrv_desc		="";
	String 		replaceSrv_cat_code		="";
	String 		replaceSrv_cat_desc			="";
	String 		refund			="N";
	String		autoRefund		= "N";
	String 		refundAmt			="";
	String 		factor_appl			="";
	String 		service_limit			="N";
	String 	    roundTo	  = "";
	String      roundInd  = "";
	String      closePkg = "N";
	String     	closePkgVal = "N";
	String		splitReqd = "Y";	//Split reqd
	String      includeHomeMedication = "N";  //sarathkumar InclHmeMedi
	String      enableDisParam= "N";  //sarathkumar InclHmeMedi
	String      closePkgStat = "disabled";
	String      perAmt_limitStatus =" disabled";
	String      uSelect = "";
	String      dSelect = "";
	String		disableAutoRefund  = " disabled";
	String		amtLmtIndNullDisplay	= "";
	String		amtLmtIndAmtDisplay		= "";
	String		amtLmtIndPerDisplay		= "";
	String		amtLmtIndUnlmtDisplay	= "";
	String 		listSizeChargeBased=""; //Newly Added By Vijay For MMS-SCF-DM-0357
	String 		dailyLmtChkYN = "N";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtGrossNet = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "", qtyFldDisabled = "", indicatorFldDisabled = "";//Added V190625-Aravindh/MMS-DM-CRF-0129.1
	
	ArrayList	type_list	    =	new ArrayList();
	ArrayList	service_code_list    =	new ArrayList();
	ArrayList	service_desc_list	    =	new ArrayList();
	ArrayList	catalog_code_list		    =	new ArrayList();
	ArrayList	catalog_desc_list		    =	new ArrayList();
	ArrayList	ind_list		    =	new ArrayList();
	ArrayList	factorOrRate_list    =	new ArrayList();
	ArrayList	qty_limit_list   =	new ArrayList();
	ArrayList	amt_limit_ind_list    =	new ArrayList();
	ArrayList	amt_limit_list    =	new ArrayList();
	//ArrayList	unlimited_list    =	new ArrayList();
	ArrayList	replace_list    =	new ArrayList();
	ArrayList	replaceSrv_code_list    =	new ArrayList();
	ArrayList	replaceSrv_desc_list    =	new ArrayList();
	ArrayList	replaceSrv_cat_code_list    =	new ArrayList();
	ArrayList	replaceSrv_cat_desc_list    =	new ArrayList();
	ArrayList	refund_list    =	new ArrayList();
	ArrayList	refundAmt_list    =	new ArrayList();	
	ArrayList	auto_refund_list    =	new ArrayList();	
	ArrayList	factor_appl_list    =	new ArrayList();	
	ArrayList	service_limit_list    =	new ArrayList();
	ArrayList	roundTo_list    =	new ArrayList();
	ArrayList	roundInd_list    =	new ArrayList();
	ArrayList	closePkg_list    =	new ArrayList();
	ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
	ArrayList   includeHomeMedication_list= new ArrayList();//sarathkumar InclHmeMedi
	ArrayList   enableDisParam_list= new ArrayList();//sarathkumar InclHmeMedi
	ArrayList	rBServices    =	new ArrayList();

	ArrayList fromDateList = new ArrayList();
	ArrayList fromDateFoundList = new ArrayList();
	
	ArrayList dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
	ArrayList dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
	ArrayList dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
	ArrayList dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
	ArrayList dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
	String bean_id		= "bl_PkgDefBean" ;
	String bean_name	= "eBL.PkgDefBean";
	PkgDefBean bean			= (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
	String beanRateBasedId		= "bl_PkgDefRateBasedBean" ;
	PkgDefBean chgBsdBean			= (PkgDefBean)getBeanObject( beanRateBasedId, bean_name, request ) ; //Newly Added By Vijay for MMS-SCF-DM-0357
	//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	String serv_grp_limit_ind = "";
	String	servGrpLmtIndNullDisplay	= "";
	String	servGrpLmtIndGroupDisplay	= "";
	String	servGrpLmtIndServiceDisplay	= "";
	ArrayList serv_grp_limit_ind_list    =	new ArrayList();
	String servGrpLmtYN = "";
	String servGrpLmtBy = "";
	String servGrpLmtFldDisabled = ""; 
	if(order_associated.equals("Y") || !servGrpLimitSiteSpec || mode.equals("modify")){	
		servGrpLmtFldDisabled=" disabled ";	
	}	
	//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
	try
	{

	String deletedStatusRB = bean.getDeletedStatusRB();
	if(mode.equals("modify") && deletedStatusRB.equals("N") && (bean.getIncludedItems_RB()==null || bean.getIncludedItems_RB().size()==0 )) {	
		bean.setDBValues("RATE_BASED",packageCode,locale,facilityId,"","",fromDate);//set database values to bean.
		bean.setModifyRateBased("Y");	
		chgBsdBean.setDBValues("CHARGE_BASED_ITEM",packageCode,locale,facilityId,"","",fromDate);// Added By Vijay for MMS-SCF-DM-0357 
	}
	
	/*if(mode.equals("insert") && (bean.getIncludedItems_RB()==null || bean.getIncludedItems_RB().size()==0 ) && !copyFrm_pkgCode.equals("")){
			bean.setDBValues("RATE_BASED",packageCode,locale,facilityId,"",copyFrm_pkgCode,fromDate);//set database values to bean.		
	}  */

	if(mode.equals("insert") && (bean.getIncludedItems_RB()==null || bean.getIncludedItems_RB().size()==0 ) && !copyFrm_pkgCode.equals("")){
			bean.setDBValues("RATE_BASED",packageCode,locale,facilityId,"",copyFrm_pkgCode,fromDate);//set database values to bean.		
	}
	int noofdecimal = Integer.parseInt(bean.getNoOfDecimal());
	HashMap includedItems_RB    =   null;
	HashMap includedItemsFD_RB    =   null;

	includedItems_RB    =  bean.getIncludedItems_RB();
	
	chgBsdBean.setDBValues("CHARGE_BASED",packageCode,locale,facilityId,"","",fromDate);// Added By Vijay for MMS-SCF-DM-0357 
	listSizeChargeBased=Integer.toString(chgBsdBean.getIncludedItems_CB().size());
 /*******Ends ******/
	fromDateTemp = fromDate;

	//ArrayList includedItems_RBD =	new ArrayList();
	if(includedItems_RB.size()>0 && includedItems_RB.containsKey(packageCode) )
	{
		includedItemsFD_RB =(HashMap)includedItems_RB.get(packageCode);
		int i = 0;
		int j = 0;		
		if(!includedItemsFD_RB.containsKey(fromDate))
		{
			StringTokenizer st = new StringTokenizer(fromDateVals,"|");
			while(st.hasMoreElements())
			{	
				String strTempDate = st.nextToken();

				if(includedItemsFD_RB.containsKey(strTempDate))
				{
					fromDateFoundList.add(strTempDate);
				}
				else
				{
					fromDateFoundList.add("");
				}
				if(fromDate.equals(strTempDate))
				{
					j=i;
				}
				i++;
			}
			int k=j;
			for(int l=0;l<j;l++)
			{
				k=k-1;
				if(!fromDateFoundList.get(k).equals(""))
				{
					fromDateTemp = (String)fromDateFoundList.get(k);
					break;
				}					
			}
		}

		if(includedItemsFD_RB.size()>0 && includedItemsFD_RB.containsKey(fromDateTemp))
		{
			rBServices =(ArrayList)includedItemsFD_RB.get(fromDateTemp);  
			if(rBServices.size()>0)
			{
				type_list		= (ArrayList)rBServices.get(0);
				service_code_list		= (ArrayList)rBServices.get(1);
			    service_desc_list	= (ArrayList)rBServices.get(2);
				catalog_code_list		= (ArrayList)rBServices.get(3);
				catalog_desc_list			= (ArrayList)rBServices.get(4);
				ind_list		= (ArrayList)rBServices.get(5);
				factorOrRate_list		= (ArrayList)rBServices.get(6);
				qty_limit_list		= (ArrayList)rBServices.get(7);
				amt_limit_ind_list	= (ArrayList)rBServices.get(8);
				amt_limit_list		= (ArrayList)rBServices.get(9);
				//unlimited_list		= (ArrayList)rBServices.get(10);
				replace_list		= (ArrayList)rBServices.get(10);
				
				replaceSrv_code_list= (ArrayList)rBServices.get(11);
				replaceSrv_desc_list		= (ArrayList)rBServices.get(12);
				replaceSrv_cat_code_list		= (ArrayList)rBServices.get(13);
				replaceSrv_cat_desc_list		= (ArrayList)rBServices.get(14);
				refund_list		= (ArrayList)rBServices.get(15);
				refundAmt_list		= (ArrayList)rBServices.get(16);
				factor_appl_list		= (ArrayList)rBServices.get(17);
				service_limit_list		= (ArrayList)rBServices.get(18);
				auto_refund_list		= (ArrayList)rBServices.get(19);
				roundTo_list			= (ArrayList)rBServices.get(20);
				roundInd_list			= (ArrayList)rBServices.get(21);
				closePkg_list			= (ArrayList)rBServices.get(22);
				if(rBServices.size()>23){
					split_reqd_list = (ArrayList)rBServices.get(23);
				}
				if(rBServices.size()>24){
					includeHomeMedication_list = (ArrayList)rBServices.get(24); //sarathkumar InclHmeMedi
				}
				if(rBServices.size()>=25){
					enableDisParam_list = (ArrayList)rBServices.get(25); //sarathkumar InclHmeMedi
				}
				if(rBServices.size()>=26){
					dailyLmtChkBxList = (ArrayList)rBServices.get(26); //Added V190320-Aravindh/MMS-DM-CRF-0129
				}
				if(rBServices.size()>=27){
					dailyLmtAmtList = (ArrayList)rBServices.get(27); //Added V190320-Aravindh/MMS-DM-CRF-0129
				}
				if(rBServices.size()>=28){
					dailyLmtGrossNetList = (ArrayList)rBServices.get(28); //Added V190320-Aravindh/MMS-DM-CRF-0129
				}
				if(rBServices.size()>=29){
					dailyLmtIndicatorList = (ArrayList)rBServices.get(29); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
				}
				if(rBServices.size()>=30){
					dailyLmtQtyList = (ArrayList)rBServices.get(30); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
				}
				//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
				if(rBServices.size()>=31){
					serv_grp_limit_ind_list = (ArrayList)rBServices.get(31); //Added V190626-Aravindh/MMS-DM-CRF-0129.1
				}
				//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
			}
		}
	}
	if(service_code_list.size()>0){
		totalRecords=service_code_list.size();
		disabled="";
	}
%>

<form name='rate_based_dtl' id='rate_based_dtl'  target='messageFrame' >	
<table cellpadding=3 cellspacing=0 border=1 width="100%" height="" class='grid'  id="rate_based_tbl">
<tr>
<!--<td class='columnheader' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td> 
<td class='columnheader' > <fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="eBL.AmountIndicator.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.FactorRate.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT_INDICATOR.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
<td  class='COLUMNHEADER' ><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>-->
<!-- <td class='columnheader' ><fmt:message key="eBL.PercentageLimit.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.NoLimit.label" bundle="${bl_labels}"/></td>
 -->
<!--<td class='columnheader' ><fmt:message key="Common.Replace.label" bundle="${common_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.RefundRatePer.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.AUTO_REFUND.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.CLOSE_PACKAGE.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.serviceLimit.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
-->

</tr>
<%

	/* Added V190625-Aravindh/MMS-DM-CRF-0129.1/Starts */
	String blParametersqry = "SELECT NVL(PKG_SERV_LMT_BY,'*') PKG_SERV_LMT_BY, NVL(DAILY_PKG_LMT_YN,'N') DAILY_PKG_LMT_YN, NVL(DAILY_PKG_LMT_BY,'*') DAILY_PKG_LMT_BY,NVL(PKG_LIMIT_IND_YN,'*') PKG_LIMIT_IND_YN  ,NVL(PKG_LIMIT_IND_BY,'*') PKG_LIMIT_IND_BY FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+facilityId+"'";
	PreparedStatement pstmt = con.prepareStatement(blParametersqry);
	ResultSet rst = pstmt.executeQuery();
	while(rst.next()) {
		pkgServLimit = rst.getString("PKG_SERV_LMT_BY");
		dailyLmtChkYN = rst.getString("DAILY_PKG_LMT_YN");
		dailyPkgLmt = rst.getString("DAILY_PKG_LMT_BY");
		servGrpLmtYN = rst.getString("PKG_LIMIT_IND_YN"); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		servGrpLmtBy = rst.getString("PKG_LIMIT_IND_BY"); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020		
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
	//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
	if(null == servGrpLmtBy || "*".equals(servGrpLmtBy))
	{					
		servGrpLmtIndNullDisplay    = "selected";
		servGrpLmtIndGroupDisplay	= "";				
		servGrpLmtIndServiceDisplay	= "";
		servGrpLmtFldDisabled 	=" disabled";
	}
	//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
	for(int i=0; i<totalRecords; i++)
	{	
		if(service_code_list.size()>0)
		{
			type		= (String)type_list.get(i);
			service_code		= (String)service_code_list.get(i);
		    service_desc	=(String) service_desc_list.get(i);
			catalog_code		=(String) catalog_code_list.get(i);
			catalog_desc			= (String)catalog_desc_list.get(i);
			ind		= (String)ind_list.get(i);
			factorOrRate		= (String)factorOrRate_list.get(i);
			qty_limit		=(String) qty_limit_list.get(i);
			amt_limit_ind	=(String) amt_limit_ind_list.get(i);
			amt_limit		= (String)amt_limit_list.get(i);
			/*unlimited		= (String)unlimited_list.get(i);
			if(unlimited==null || unlimited.equals("") || unlimited.equals("null"))
				unlimited="N";	  */
			replace		= (String)replace_list.get(i);
			replaceSrv_code= (String)replaceSrv_code_list.get(i);
			replaceSrv_desc		= (String)replaceSrv_desc_list.get(i);
			replaceSrv_cat_code		=(String) replaceSrv_cat_code_list.get(i);
			replaceSrv_cat_desc	= (String)replaceSrv_cat_desc_list.get(i);
			refund		=(String) refund_list.get(i);
			refundAmt		= (String)refundAmt_list.get(i);
			autoRefund		= (String)auto_refund_list.get(i);
			factor_appl		= (String)factor_appl_list.get(i);
			service_limit		= (String)service_limit_list.get(i);
			roundTo			= (String)roundTo_list.get(i);
			roundInd		= (String)roundInd_list.get(i);
			closePkg		=(String) closePkg_list.get(i);
			splitReqd 		=(String) split_reqd_list.get(i);//Split reqd
			includeHomeMedication =(String) includeHomeMedication_list.get(i); //sarathkumar InclHmeMedi
			enableDisParam = (String) enableDisParam_list.get(i); //sarathkumar InclHmeMedi
			/* Commented V190819-Aravindh/MMS-DM-CRF-0129.1/Below line */
			//dailyLmtChkYN = (String) dailyLmtChkBxList.get(i);//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtAmt = (String) dailyLmtAmtList.get(i);//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtGrossNet = (String) dailyLmtGrossNetList.get(i);//Added V190320-Aravindh/MMS-DM-CRF-0129
			dailyLmtInd = (String) dailyLmtIndicatorList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			if("".equals(dailyLmtInd)){
				dailyLmtInd = "*";
			}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			dailyLmtQty = (String) dailyLmtQtyList.get(i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			serv_grp_limit_ind	=(String) serv_grp_limit_ind_list.get(i);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		}
		uSelect = roundInd.equals("U")? " selected "	 :"";
		dSelect = roundInd.equals("D")? " selected "	 :"";
		closePkgStat = (acrossEncounters.equals("Y") && type.equals("S"))?"":"disabled";
		closePkgVal = closePkg.equals("Y") ? "Y" :"N";
		if(refund==null || refund.equals("") || refund.equals("null"))
			refund="N";

		if(amt_limit_ind.equals("A"))
		{
				amtLmtIndNullDisplay    = "";
				amtLmtIndAmtDisplay		= " selected";
				amtLmtIndPerDisplay		= "";
				amtLmtIndUnlmtDisplay	= "";
				perAmt_limitStatus      ="";
		}
		else if(amt_limit_ind.equals("P"))
		{
				amtLmtIndNullDisplay    = "";
				amtLmtIndAmtDisplay		= "";
				amtLmtIndPerDisplay		= "selected";
				amtLmtIndUnlmtDisplay	= "";
				perAmt_limitStatus      ="";
		}
		else if(amt_limit_ind.equals("U"))
		{
			amtLmtIndNullDisplay    = "";
			amtLmtIndAmtDisplay		= "";
			amtLmtIndPerDisplay		= "";
			amtLmtIndUnlmtDisplay	= "selected";
			perAmt_limitStatus      =" disabled";
			//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
			servGrpLmtIndNullDisplay    = "selected";
			servGrpLmtIndGroupDisplay	= "";				
			servGrpLmtIndServiceDisplay	= "";
			servGrpLmtFldDisabled 	=" disabled";
			//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		}
		else
		{
			amtLmtIndNullDisplay = "selected";
			amtLmtIndAmtDisplay		= "";
			amtLmtIndPerDisplay		= "";
			amtLmtIndUnlmtDisplay	= "";
			perAmt_limitStatus      =" disabled";

		}
		//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		if(serv_grp_limit_ind.equals("G"))
		{
			servGrpLmtIndNullDisplay    = "";				
			servGrpLmtIndGroupDisplay	= "selected";
			servGrpLmtIndServiceDisplay	= "";
		}
		else if(serv_grp_limit_ind.equals("S"))
		{
			servGrpLmtIndNullDisplay    = "";
			servGrpLmtIndGroupDisplay	= "";				
			servGrpLmtIndServiceDisplay	= "selected";								
		}
		else
		{
			servGrpLmtIndNullDisplay = "selected";
			servGrpLmtIndGroupDisplay	= "";
			servGrpLmtIndServiceDisplay	= "";
		}
		//Ended By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		if(service_limit==null || service_limit.equals("") || service_limit.equals("null"))
			service_limit="N";
		if(replace==null || replace.equals("") || replace.equals("null"))
			replace="N";
		if(refundAmt.equals(""))
		   disableAutoRefund = " disabled";
		else
		   disableAutoRefund = "";

		%>
<tr>
<td class='fields' nowrap WIDTH='9'> 
<%
if(order_associated.equals("Y")){%>
<select name='type<%=i%>' id='type<%=i%>' id='type<%=i%>' onChange='onServiceTypeChange(this,"<%=i%>")' <%=modifyStatus%>><option value='S' <%=type.equals("S")?"selected":""%> ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option></select>
<%}else{%>
<select name='type<%=i%>' id='type<%=i%>' id='type<%=i%>' onChange='onServiceTypeChange(this,"<%=i%>")' <%=modifyStatus%>><option value='G' <%=type.equals("G")?"selected":""%> ><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/></option><option value='C' <%=type.equals("C")?"selected":""%>><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option><option value='S' <%=type.equals("S")?"selected":""%>><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>
<option value='P' <%=type.equals("P")?"selected":""%>><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"/></option>
	</select>
<!-- Above line is Added by Muthu against CRF on 22-2-12 -->

<%
}%>
</td>

						
<td class='fields' nowrap WIDTH=''>
	<input type='hidden' name='service_code<%=i%>' id='service_code<%=i%>' id='service_code<%=i%>' <%=modifyStatus%> value='<%=service_code%>'>
	<!-- Removed V190626-Aravindh/MMS-DM-CRF-0129.1/ removed calling new function dailyLmtChkBxClickPharma -->
	<input type='text' name = 'service_desc<%=i%>' id='service_desc<%=i%>' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="before_serviceLookUp(this,service_code<%=i%>,type<%=i%>,'<%=i%>'); IncludeHomeMedicationCheck(service_code<%=i%>,type<%=i%>,'<%=i%>');"  value="<%=service_desc%>">

	<INPUT type='hidden' name='service_desc_temp<%=i%>' id='service_desc_temp<%=i%>' value=''>
	<!-- Removed V190626-Aravindh/MMS-DM-CRF-0129.1/ removed calling new function dailyLmtChkBxClickPharma -->
	<input type='button' name='service_button<%=i%>' id='service_button<%=i%>' class='button' value='?'   onclick="serviceLookUp(service_desc<%=i%>,service_code<%=i%>,type<%=i%>,'<%=i%>'); IncludeHomeMedicationCheck(service_code<%=i%>,type<%=i%>,'<%=i%>');">
</td>
			
<td class='fields' nowrap WIDTH=''><input type='hidden' name='catalog_code<%=i%>' id='catalog_code<%=i%>' value='<%=catalog_code%>'><input type='text' name = 'catalog_desc<%=i%>'  <%=modifyStatus%> <%=ordCatDisabled%> size='10' maxlength='10' onBlur="before_catalogLookUp(this,catalog_code<%=i%>,service_code<%=i%>,'<%=i%>')" value='<%=catalog_desc%>'><INPUT type='hidden' name='catalog_desc_temp<%=i%>' id='catalog_desc_temp<%=i%>' value=''><input type='button' name='catalog_button<%=i%>' id='catalog_button<%=i%>'  <%=ordCatDisabled%>  class='button' value='?'	<%=modifyStatus%> onclick="catalogLookUp(catalog_desc<%=i%>,catalog_code<%=i%>,service_code<%=i%>,'<%=i%>')"></td>
	
<td class='fields' nowrap WIDTH=''>
<%if(type.equals("G") || type.equals("C")){ %>
<select name='ind<%=i%>' id='ind<%=i%>' onChange='onIndChange(this,"<%=i%>")' <%=modifyStatus%>><option value='S' <%=ind.equals("S")?"selected":""%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option><option value='R' <%=ind.equals("R")?"selected":""%> ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option><option value='P' <%=ind.equals("P")?"selected":""%> >
	<fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/></option></select>
<%}else{%>	
<select name='ind<%=i%>' id='ind<%=i%>' onChange='onIndChange(this,"<%=i%>")' <%=modifyStatus%>><option value='S' <%=ind.equals("S")?"selected":""%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option><option value='R' <%=ind.equals("R")?"selected":""%> ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option><option value='U' <%=ind.equals("U")?"selected":""%> ><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></option><option value='P' <%=ind.equals("P")?"selected":""%> ><fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/></option><option value='X' <%=ind.equals("X")?"selected":""%> ></option></select>
<%}%>
</td>
		


<td class='fields' nowrap WIDTH=''><input type='text' name='factorOrRate<%=i%>' id='factorOrRate<%=i%>' size='12' <%=modifyStatus%>  maxlength='13' onBlur='checkForNegetiveNumber(this,document.forms[0].noofdecimal.value,"BL8665");' onkeypress='return allowValidNumber1(this,event)'; value="<%=factorOrRate%>" /></td>
			
<td class='fields' nowrap WIDTH=''><input type='text'    name='qty_limit<%=i%>' id='qty_limit<%=i%>'   size='8'  <%=modifyStatus%> <%=disabled%> onBlur='chkQtyLimit(this,"<%=i%>");' onkeypress='return ChkNumberInput(this,event,"0")'; value="<%=qty_limit%>" /></td>
<td  align="left" nowrap WIDTH=''>
<select name='amt_limit_ind<%=i%>' id='amt_limit_ind<%=i%>' <%=modifyStatus%> onChange='validateInd(this,"<%=i%>","perAmt_limit","factor_appl","qty_limit");changeSplitReqd(this,"amt_limit","<%=i%>","<%=dailyLimitSiteSpec%>",dailyLmtIndicator<%=i%>)'>
<option value='' <%=amtLmtIndNullDisplay%> >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<option value='A' <%=amtLmtIndAmtDisplay%> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
<option value='P' <%=amtLmtIndPerDisplay%>><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
<option value='U' <%=amtLmtIndUnlmtDisplay%>><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>
</select>
</td>

<td class='fields' WIDTH='' nowrap><input type='text' name='perAmt_limit<%=i%>' id='perAmt_limit<%=i%>' size='8' maxlength='13' <%=modifyStatus%> <%=perAmt_limitStatus%>  onBlur='validForAmtPerUnltd(document.forms[0].amt_limit_ind<%=i%>,this,"<%=i%>","","<%=noofdecimal%>")' onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")'; value="<%=amt_limit%>"  /></td>

<td  class='fields' WIDTH='' nowrap><input type='text' name='roundTo<%=i%>' id='roundTo<%=i%>' size='6'  <%=modifyStatus%> value="<%=roundTo%>"  onkeypress=" return (allowValidNumber1(this,event));"  /></td>

<td  class='fields' WIDTH='' nowrap>
<select name='roundInd<%=i%>' id='roundInd<%=i%>'    onChange="" <%=modifyStatus%> >
<option value='U' <%=uSelect%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
<option value='D' <%=dSelect%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
</select>
</td>

<%if(servGrpLimitSiteSpec) {%> 
<td  align="left" nowrap WIDTH=''>
<select name='serv_grp_limit_ind<%=i%>' id='serv_grp_limit_ind<%=i%>' id='serv_grp_limit_ind<%=i%>' <%=servGrpLmtFldDisabled%>  >
<%if("B".equals(servGrpLmtBy)){ %>
<option value='' <%=servGrpLmtIndNullDisplay%> >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<option value='G' <%=servGrpLmtIndGroupDisplay%>><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
<option value='S' <%=servGrpLmtIndServiceDisplay%> ><fmt:message key="eBL.Service.label" bundle="${bl_labels}"/></option>
<%}else if("G".equals(servGrpLmtBy)) {%>
<option value='' <%=servGrpLmtIndNullDisplay%> >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<option value='G' <%=servGrpLmtIndGroupDisplay%>><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
<%}else if("S".equals(servGrpLmtBy)) {%>
<option value='' <%=servGrpLmtIndNullDisplay%> >--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<option value='S' <%=servGrpLmtIndServiceDisplay%> ><fmt:message key="eBL.Service.label" bundle="${bl_labels}"/></option>
<%} else {%>
<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%} %>
</select>
</td>
<%} else if(order_associated.equals("Y") || !servGrpLimitSiteSpec){ System.out.println("in else for limit");%>
<td  align="left" nowrap WIDTH=''>
<select name='serv_grp_limit_ind<%=i%>' id='serv_grp_limit_ind<%=i%>' id='serv_grp_limit_ind<%=i%>' <%=servGrpLmtFldDisabled%>  >
<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
</select>
</td>
<%} else {%>
<td  align="left" nowrap WIDTH=''>
<select name='serv_grp_limit_ind<%=i%>' id='serv_grp_limit_ind<%=i%>' id='serv_grp_limit_ind<%=i%>' disabled  >
<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
</select>
</td>
<%} %>

<%if(ss){ 
System.err.println("enableDisParam from ratebased"+enableDisParam);
%>
<!-- 	//sarathkumar InclHmeMedi  -->
<td class='fields' WIDTH='75' nowrap ><input type='checkbox'  <%=modifyStatus%> name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%> <%="Y".equals(enableDisParam)?"":"disabled"%> onclick="checkInclHomeMedi(this);"> </td> 
<input type='hidden'  <%=modifyStatus%> name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value='<%=enableDisParam %>'> </td>
<% } else{%>
	<td> <input type='hidden'   name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='Y'> 
	<input type='hidden'   name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value='Y'> </td>
<%} %>
<!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->
<!-- Modified V190626-Aravindh/MMS-DM-CRF-0129.1 -->
<%if(dailyLimitSiteSpec) { %>
	<%-- <td class='fields' WIDTH='' nowrap >
	<!-- Added V190404-dhananjay/MMS-DM-CRF-0129/ added  enableDisParam to disable or enable -->
		<input type='checkbox' name = 'dailyLmtChkBx<%=i%>' id = 'dailyLmtChkBx<%=i%>' <%=modifyStatus%> onclick = 'dailyLmtChkBxClick(this,<%=i%>,document.rate_based_dtl)' value='<%=dailyLmtChkYN %>' <%="Y".equals(dailyLmtChkYN)?" checked ":""%> />
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
		<select name='dailyLmtIndicator<%=i%>' id='dailyLmtIndicator<%=i%>' id='dailyLmtIndicator<%=i%>' <%=modifyStatus%> <%=indicatorFldDisabled%> onchange='dailyLmtIndicatorOnChange(this,<%=i%>,document.rate_based_dtl)' >
			<option value="*"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
			<% if("G".equals(dailyPkgLmt) || "B".equals(dailyPkgLmt)) { %>
				<option value="G" <%="G".equals(dailyLmtInd)?" selected ":""%> ><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
			<% } if("I".equals(dailyPkgLmt) || "B".equals(dailyPkgLmt)) {%>
				<option value="I" <%="I".equals(dailyLmtInd)?" selected ":""%> ><fmt:message key="eBL.PIPD.label" bundle="${bl_labels}"/></option>
			<% } %>
		</select>
		<input type='hidden' name = 'dailyLmtChkBx<%=i%>' id = 'dailyLmtChkBx<%=i%>' value = '<%=dailyLmtChkYN%>' />
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
<input type='checkbox'   <%=disabled%> name='replace<%=i%>'   <%=modifyStatus%> <%=replace.equals("Y")?" checked ":""%> onClick='chkReplace(this,"<%=i%>")' value="<%=replace%>"/>
<%if(replace.equals("Y")){%><a name='replace_dtls<%=i%>' href='#' onClick='showReplaceDtls("<%=i%>")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a><%}%><input type="hidden" name="replaceSrv_code<%=i%>" id="replaceSrv_code<%=i%>" value="<%=replaceSrv_code%>"><input type="hidden" name="replaceSrv_desc<%=i%>" id="replaceSrv_desc<%=i%>" value="<%=replaceSrv_desc%>"><input type="hidden" name="replaceSrv_cat_code<%=i%>" id="replaceSrv_cat_code<%=i%>" value="<%=replaceSrv_cat_code%>"><input type="hidden" name="replaceSrv_cat_desc<%=i%>" id="replaceSrv_cat_desc<%=i%>" value="<%=replaceSrv_cat_desc%>">
</td>

<td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=disabled%>	<%=modifyStatus%> name='refund<%=i%>' <%=refund.equals("Y")?" checked ":""%> onClick='chkRefund(this,"<%=i%>")' value="<%=refund%>"/><%if(refund.equals("Y")){%><input type='text'	 <%=modifyStatus%> name='refundAmt<%=i%>' value='<%=refundAmt%>' onkeypress='return ChkNumberInput(this,event,"<%=noofdecimal%>")' onBlur='validPercentageForRefund(this,"autoRefund<%=i%>")' size='2' maxlength ='4'><%}%></td>

<td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=disabled%>	 <%=modifyStatus%>  <%=disableAutoRefund%>  name='autoRefund<%=i%>' <%=autoRefund.equals("Y")?" checked ":""%> onClick='chkautoRefund(this,"refundAmt<%=i%>")' value="<%=autoRefund%>"/></td>



<td class='fields' nowrap WIDTH='60'><input type='checkbox'  name='factor_appl<%=i%>' id='factor_appl<%=i%>' <%=modifyStatus%> <%=factor_appl.equals("Y")?" checked ":""%> onClick='factorAppl(this,"<%=i%>")' value="<%=factor_appl%>"/></td>

<td class='fields' nowrap WIDTH='60'>
<input type='radio' name='closePkg' id='closePkg' id='closePkg' <%=modifyStatus%> <%=closePkgVal.equals("Y")?"checked":""%> <%=closePkgStat%> onClick="assignClosePkgVal(this,'<%=i%>')"/><input type='hidden' name='closePkg<%=i%>' id='closePkg<%=i%>' value="<%=closePkgVal%>" /></td>

<td class='fields' nowrap WIDTH='80'><input type='checkbox'   <%=disabled%>	name='service_limit<%=i%>' <%=modifyStatus%>  <%=service_limit.equals("Y")?" checked ":""%> onClick='chkServiceLimit(this,"<%=i%>")' value="<%=service_limit%>"/><%if(service_limit.equals("Y")){%><a name='service_limit_dtls<%=i%>' href='#' onClick='serviceLimitDtls("<%=i%>")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a><%}%></td>
 <td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=modifyStatus%>	name='split_reqd<%=i%>' id='split_reqd<%=i%>' <%="selected".equals(amtLmtIndUnlmtDisplay)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);" <%= !"*".equals(dailyLmtInd)?" disabled ":"" %> ></td> 
<td class='fields' nowrap WIDTH='50'>
<input type='checkbox'  name='deleteService<%=i%>' id='deleteService<%=i%>'	 <%=modifyStatus%> onClick='chkDeleteService(this,"<%=i%>")' value="N"/></td>

</tr>
<%
}
%>
 </table>
 <INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
 	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="order_associated" id="order_associated" value="<%=order_associated%>">	
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" id="totalRecords" name="totalRecords" id="totalRecords" value="<%=totalRecords%>"> <!-- saraa -->
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>"> <!--added by Nandhini for KDAH-SCF-0769-->
	<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
	<input type='hidden' name='custCode' id='custCode' value="<%=custCode%>" />
	<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
	<input type='hidden' name='acrossEncounters' id='acrossEncounters' value="<%=acrossEncounters%>" >
	<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
	<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
	<input type='hidden' name='from_date' id='from_date'  id='from_date' value=''>
	<input type='hidden' name='fromDateVals' id='fromDateVals'  id='fromDateVals' value='<%=fromDateVals%>'>
	<input type='hidden' name='totRecChargeBased' id='totRecChargeBased' id='totRecChargeBased' value='<%=listSizeChargeBased %>'/> 
	<input type='hidden' name='new_added_date' id='new_added_date' id='new_added_date' value=''/> 
	<input type='hidden' name='siteSpecf' id='siteSpecf'  id='siteSpecf' value='<%=siteSpecf%>'> 	<!-- //sarathkumar InclHmeMedi --> 
	<input type='hidden' name='dailyLimitSiteSpec' id='dailyLimitSiteSpec'  id='dailyLimitSiteSpec' value='<%=dailyLimitSiteSpec%>' ><!-- Added V190320-Aravindh/MMS-DM-CRF-0129 --> 
	<input type='hidden' name='modifyStatus' id='modifyStatus'  id='modifyStatus' value='<%=modifyStatus%>' ><!-- Added V190409-Aravindh/MMS-DM-CRF-0129 --> 
	<input type='hidden' name='pkgServLimit' id='pkgServLimit'  id='pkgServLimit' value='<%=pkgServLimit%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='dailyPkgLmt' id='dailyPkgLmt'  id='dailyPkgLmt' value='<%=dailyPkgLmt%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='dailyLmtChkYN' id='dailyLmtChkYN'  id='dailyLmtChkYN' value='<%=dailyLmtChkYN%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='amtFldDisabled' id='amtFldDisabled'  id='amtFldDisabled' value='<%=amtFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='qtyFldDisabled' id='qtyFldDisabled'  id='qtyFldDisabled' value='<%=qtyFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='indicatorFldDisabled' id='indicatorFldDisabled'  id='indicatorFldDisabled' value='<%=indicatorFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
	<input type='hidden' name='servGrpLimitSiteSpec' id='servGrpLimitSiteSpec'  id='servGrpLimitSiteSpec' value='<%=servGrpLimitSiteSpec%>' ><!-- Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 --> 
	<input type='hidden' name='servGrpLmtBy' id='servGrpLmtBy'  id='servGrpLmtBy' value='<%=servGrpLmtBy%>' ><!-- Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 -->
	<input type='hidden' name='servGrpLmtFldDisabled' id='servGrpLmtFldDisabled'  id='servGrpLmtFldDisabled' value='<%=servGrpLmtFldDisabled%>' ><!-- Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 -->
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>"> <!--V211130-->
	 </form>
 	<script><%-- //commented by ram and added new line initializeRateForm();updateCurrentForm("RATE_BASED","parent.frames[3].frames[0].document.rate_based_dtl","parent.frames[3].frames[2].document.srvLimit_rate_based_dtl","parent.parent.PkgDefHeader.document.frmPkgDefHeader",<%=totalRecords%>); --%>
	initializeRateForm();updateCurrentForm("RATE_BASED","parent.frames[3].frames[1].document.rate_based_dtl","parent.frames[3].frames[4].document.srvLimit_rate_based_dtl","parent.parent.PkgDefHeader.document.frmPkgDefHeader",<%=totalRecords%>);</script>
	<SCRIPT>alignHeading();</SCRIPT>
<%}
catch(Exception e)
{
	System.out.println("Exception from package definition  Rate based:"+e);
	e.printStackTrace();
}%>

 </body>
  <%putObjectInBean(bean_id,bean,request);%>
</html>

