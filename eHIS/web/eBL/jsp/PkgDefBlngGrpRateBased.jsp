<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*, eBL.PkgDefBean, java.sql.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="eBL.BLReportIdMapper"%> 
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
	System.out.println("siteSpecf pkgdefblnggrpratebased" + ss);
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
	Connection con = null;
	boolean dailyLimitSiteSpec = false;
	try {
		con = ConnectionManager.getConnection(request);
		dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT");
	} catch(Exception ex) {
		System.err.println("Error in PkgDefBlngGrpRateBased.jsp: "+ex);
		ex.printStackTrace();
	}
	/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDefBlngGrp.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<script>
	$(document).ready(function(){
		//Added V190320-Aravindh/MMS-DM-CRF-0129/Disabling the dailyLimitCheckBox based on Order Associated.
		if($('#dailyLimitSiteSpec').val() == true || $('#dailyLimitSiteSpec').val() == "true") { 
			if(document.forms[0].order_associated.value == "Y") {
				var formObj=document.blng_grp_rate_based_dtl;
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
				
	});
	function alignHeading()
	{				
		if(parent.blng_grp_rate_based_dtl_hdr.document.getElementById("tableheader1")!=null)
		{					
			parent.blng_grp_rate_based_dtl_hdr.document.getElementById("tableheader1").width =	eval(parent.frames[1].document.getElementById("blng_grp_rate_based_tbl").offsetWidth);
			for (j=0; j < parent.frames[1].document.getElementById("blng_grp_rate_based_tbl").rows(2).cells.length; j++) 
			{			
				var  wid=eval(parent.frames[1].document.getElementById("blng_grp_rate_based_tbl").rows(2).cells(j).offsetWidth);									
				if(parent.blng_grp_rate_based_dtl_hdr.document.getElementById("tableheader1").rows(1).cells(j) != null)
				{									
					parent.blng_grp_rate_based_dtl_hdr.document.getElementById("tableheader1").rows(1).cells(j).width=wid;								
				}
			}
		}
	}

	function moveFrame()
	{	
		var temp=document.body.scrollLeft;
		scrollValue=temp;

		if(parent.blng_grp_rate_based_dtl_hdr.location.href.indexOf(".jsp") != -1)
		{
			parent.blng_grp_rate_based_dtl_hdr.document.body.scrollLeft=temp;
		}
	}
</script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onscroll='moveFrame()' onLoad='includeHomeMedicationEnableBlngGrp();'>
<%

	String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
	String fromDateTemp = "";
	String fromDateVals			 = request.getParameter("fromDateVals")==null ? "" :request.getParameter("fromDateVals") ;
	String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String locale			= (String)session.getAttribute("LOCALE");
	String		splitReqd = "Y";	//Split reqd
	String		includeHomeMedication = "N";	
	String enableDisParam="N";
	String order_associated=request.getParameter("orderAssociated") == null ? "N" : request.getParameter("orderAssociated");
	String acrossEncounters=request.getParameter("acrossEncounters") == null ? "N" : request.getParameter("acrossEncounters");

	String disabled="disabled";
	int totalRecords=1;
	
	String ordCatDisabled="disabled";
	if(order_associated.equals("Y"))
	{	
		ordCatDisabled="";
	}
	
	String packageCode		=	"" ;
	String copyFrm_pkgCode		=	"" ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
	String blng_grp_code		=	request.getParameter("blng_grp_code") == null ? "" :request.getParameter("blng_grp_code") ;
	String blng_grp_desc		=	request.getParameter("blng_grp_desc") == null ? "" :request.getParameter("blng_grp_desc") ;	
	String parent_index		=	request.getParameter("parent_index") == null ? "" :request.getParameter("parent_index") ;
	
	String bean_id		= "bl_PkgDefBlngGrpBean" ;
	String bean_name	= "eBL.PkgDefBlngGrpBean";
	PkgDefBlngGrpBean bean			= (PkgDefBlngGrpBean)getBeanObject( bean_id, bean_name, request ) ;

	String		type			="";
	String 		service_code	="";
	String 	    service_desc	="";
	String 		catalog_code	="";
	String 		catalog_desc	="";
	String 		ind				="";
	String 		factorOrRate	="";
	String 		qty_limit		="";
	String 		amt_limit_ind	="";
	String 		amt_limit		="";	
	//String 		unlimited			="N";
	String 		replace			="N";
	String 		replaceSrv_code	="";
	String 		replaceSrv_desc	="";
	String 		replaceSrv_cat_code	="";
	String 		replaceSrv_cat_desc	="";
	String 		refund			="N";
	String		autoRefund		= "N";
	String 		refundAmt		="";
	String 		factor_appl		="";
	String 	    roundTo	  = "";
	String      roundInd  = "";
	String      closePkg = "N";
	String     	closePkgVal = "N";
	String      closePkgStat = "disabled";
	String      uSelect = "";
	String      dSelect = "";
	String		noofdecimal=bean.getNoOfDecimal();
	String 		blngGrpChgBasedRcdSize="";  // Added By Vijay For MMS-SCF-0357
	String 		SiteID="";
	String 		dailyLmtChkYN = "N";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtAmt = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		dailyLmtGrossNet = "";//Added V190320-Aravindh/MMS-DM-CRF-0129
	String 		pkgServLimit = "", dailyPkgLmt = "", dailyLmtInd = "*", dailyLmtQty = "", amtFldDisabled = "", qtyFldDisabled = "", indicatorFldDisabled = "";//Added V190625-Aravindh/MMS-DM-CRF-0129.1
	String 		facilityId = (String) session.getValue( "facility_id" ) ;//Added V190625-Aravindh/MMS-DM-CRF-0129.1

	ArrayList fromDateList = new ArrayList();
	ArrayList fromDateFoundList = new ArrayList();

	bean.setModifyBlngGrpRateSrv("Y");	
	System.err.println("Query String:"+request.getQueryString());
	HashMap blng_grp_rate_srv		= new HashMap();		
	ArrayList blng_grp_rate_srv_list	     =	new ArrayList();
	blng_grp_rate_srv	=  (HashMap)bean.getBlngGrpRateSrv();
	blngGrpChgBasedRcdSize=Integer.toString(bean.getBlngGrpChargeSrv().size()); //Added By Vijay For MMS-SCF-0357
	fromDateTemp = fromDate;
	if(blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0)
	{
		int i = 0;
		int j = 0;
		if(blng_grp_rate_srv.containsKey(blng_grp_code.trim()+"~~"+fromDateTemp.trim()))
		{
			blng_grp_rate_srv_list=(ArrayList)blng_grp_rate_srv.get(blng_grp_code.trim()+"~~"+fromDateTemp.trim());
		}
		else
		{
			StringTokenizer st = new StringTokenizer(fromDateVals,"|");
			while(st.hasMoreElements())
			{	
				String strTempDate = st.nextToken();

				if(blng_grp_rate_srv.containsKey(blng_grp_code.trim()+"~~"+strTempDate.trim()))
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
			blng_grp_rate_srv_list=(ArrayList)blng_grp_rate_srv.get(blng_grp_code.trim()+"~~"+fromDateTemp.trim());
		}
	}
	if(blng_grp_rate_srv_list!=null &&  blng_grp_rate_srv_list.size()>0)
	{
		totalRecords=blng_grp_rate_srv_list.size();	
		disabled="";
	}

	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
		 modifyStatus = " disabled ";
%>

<form name='blng_grp_rate_based_dtl' id='blng_grp_rate_based_dtl'  target='messageFrame' >	
<table cellpadding=3 cellspacing=0 border=1 width="100%" height="" class='grid'  id="blng_grp_rate_based_tbl">
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
	if(blng_grp_rate_srv_list!=null && blng_grp_rate_srv_list.size()>0)
	{
	for(int i=0;i<totalRecords;i++)
	{
		System.out.println("for looppppppp ** blng_grp_rate_srv_list ");
		//record=new String[25];//Split Reqd
		/* Commented V190320-Aravindh/MMS-DM-CRF-0129/Above line, added below line */
		record=new String[30];//Modified V190702-Aravindh/MMS-DM-CRF-0129.1/String[28] -> String[30]
		record=(String[])(blng_grp_rate_srv_list.get(i));
			
		type		= record[0];
		service_code		= record[1];
		service_desc	=record[2];
		catalog_code		=record[3];
		catalog_desc			= record[4];
		ind		= record[5];
		factorOrRate		= record[6];
		qty_limit		=record[7];
		amt_limit_ind	=record[8];
		amt_limit		= record[9];
		replace		= record[10];
		if(replace==null || replace.equals("") || replace.equals("null"))
			replace="N";
		replaceSrv_code= record[11];
		replaceSrv_desc		= record[12];
		replaceSrv_cat_code		=record[13];
		replaceSrv_cat_desc	= record[14];
		refund		=record[15];
		if(refund==null || refund.equals("") || refund.equals("null"))
			refund="N";
		refundAmt		= record[16];
		if(refundAmt==null || refundAmt.equals("") || refundAmt.equals("null"))
			refundAmt="";
		autoRefund		= record[17];
		factor_appl		= record[18];	
		roundTo			= record[19];
		roundInd		= record[20];
		closePkg		=record[21];
		splitReqd		= record[22];
		includeHomeMedication		= record[23];
		enableDisParam		= record[24];
		/* Commented V190819-Aravindh/MMS-DM-CRF-0129.1/Below line */
		//dailyLmtChkYN = record[25];//Added V190320-Aravindh/MMS-DM-CRF-0129
		dailyLmtAmt = record[26];//Added V190320-Aravindh/MMS-DM-CRF-0129
		dailyLmtGrossNet = record[27];//Added V190320-Aravindh/MMS-DM-CRF-0129
		dailyLmtInd = record[28];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		if("".equals(dailyLmtInd)){
			dailyLmtInd = "*";
		}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		dailyLmtQty = record[29];//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		
			//System.out.println("@@ amt_limit_ind="+amt_limit_ind);
		uSelect = roundInd.equals("U")? "selected"	 :"";
		dSelect = roundInd.equals("D")? "selected"	 :"";
		closePkgStat = type.equals("S")?"":"disabled";
		closePkgVal = closePkg.equals("Y") ? "on" :"off";
%>
	<tr>
		<td class='fields' nowrap WIDTH=''> 
<%
		if(order_associated.equals("Y"))
		{
%>
			<select name='type<%=i%>' id='type<%=i%>' <%=modifyStatus%> onChange='onBlngGrpServiceTypeChange(this,"<%=i%>")'>
				<option value='S' <%=type.equals("S")?"selected":""%> ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>
				</option>
			</select>
<%
		}
		else
		{
%>
			<select name='type<%=i%>' id='type<%=i%>' <%=modifyStatus%> onChange='onBlngGrpServiceTypeChange(this,"<%=i%>")'>
				<option value='G' <%=type.equals("G")?"selected":""%> ><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/>
				</option>
				<option value='C' <%=type.equals("C")?"selected":""%>><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/>
				</option>
				<option value='S' <%=type.equals("S")?"selected":""%>><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>
				</option>	
	<!-- Modified by Muthu against KDAH-SCF-0057 on 27-4-12 -->
				<option value='P' <%=type.equals("P")?"selected":""%> ><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"/>	</option>
	<!-- Modified by Muthu against KDAH-SCF-0057 -->
			</select>
<%
		}
%>
		</td>
		<td class='fields' nowrap WIDTH=''>
			<input type='hidden' name='service_code<%=i%>' id='service_code<%=i%>' value='<%=service_code%>'>
			<input type='text' name = 'service_desc<%=i%>'  <%=modifyStatus%> size='10' maxlength='10' onBlur="before_blngGrpServiceLookUp(this,service_code<%=i%>,type<%=i%>,'<%=i%>')" value="<%=service_desc%>">
			<INPUT type='hidden' name='service_desc_temp<%=i%>' id='service_desc_temp<%=i%>' value=''>
			<input type='button' name='service_button<%=i%>' id='service_button<%=i%>' class='button'   <%=modifyStatus%> value='?' onclick="blngGrpServiceLookUp(service_desc<%=i%>,service_code<%=i%>,type<%=i%>,'<%=i%>')">
			<input type='hidden' name='oldSrvKey<%=i%>' id='oldSrvKey<%=i%>' value='<%=(blng_grp_code+"~~"+fromDate+"~~"+service_code)%>'>
		</td>
			
		<td class='fields' nowrap WIDTH=''>
			<input type='hidden' name='catalog_code<%=i%>' id='catalog_code<%=i%>' value='<%=catalog_code%>'>
			<input type='text' name = 'catalog_desc<%=i%>'   <%=modifyStatus%> <%=ordCatDisabled%> size='10' maxlength='10' onBlur="before_blngGrpCatalogLookUp(this,catalog_code<%=i%>,service_code<%=i%>,'<%=i%>')" value='<%=catalog_desc%>'>
			<INPUT type='hidden' name='catalog_desc_temp<%=i%>' id='catalog_desc_temp<%=i%>' value=''>
			<input type='button'   <%=modifyStatus%> name='catalog_button<%=i%>'  <%=ordCatDisabled%>  class='button' value='?' onclick="blngGrpCatalogLookUp(catalog_desc<%=i%>,catalog_code<%=i%>,service_code<%=i%>,'<%=i%>')">
		</td>
	
		<td  class='fields' nowrap WIDTH=''>
<%
		if(type.equals("G") || type.equals("C"))
		{ 
%>
			<select name='ind<%=i%>' id='ind<%=i%>' onChange='onblngGrpIndChange(this,"<%=i%>")' <%=modifyStatus%>>
				<option value='S' <%=ind.equals("S")?"selected":""%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option>
				<option value='R' <%=ind.equals("R")?"selected":""%> ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option>
				<option value='P' <%=ind.equals("P")?"selected":""%>><fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/>
				</option>
			</select>
<%
		}
		else
		{
%>	
			<select name='ind<%=i%>' id='ind<%=i%>' onChange='onBlngGrpIndChange(this,"<%=i%>")' <%=modifyStatus%>>
				<option value='S' <%=ind.equals("S")?"selected":""%>><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option>
				<option value='R' <%=ind.equals("R")?"selected":""%> ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option>
				<option value='U' <%=ind.equals("U")?"selected":""%> ><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></option>
				<option value='P' <%=ind.equals("P")?"selected":""%> ><fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/></option>
				<option value='X' <%=ind.equals("X")?"selected":""%> ></option>
			</select>
<%		}
%>
		</td>

		<td class='fields' nowrap WIDTH=''>
			<input type='text' name='factorOrRate<%=i%>' id='factorOrRate<%=i%>' size='12'  <%=modifyStatus%>  maxlength='13'  onBlur='checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8665");' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")'; value="<%=factorOrRate%>" />
		</td>
			
		<td class='fields' nowrap WIDTH=''>
			<input type='text'    name='qty_limit<%=i%>' id='qty_limit<%=i%>'   size='8'  <%=modifyStatus%>  <%=disabled%> onBlur='chkBlngGrpQtyLimit(this,"<%=i%>");' onkeypress='return allowValidNumber(this,event,noofdecimal.value)'; value="<%=qty_limit%>" />
		</td>

<td class='fields' nowrap WIDTH=''>
			<select name='amt_limit_ind<%=i%>' id='amt_limit_ind<%=i%>' onChange='validateBlngGrpInd(this,"<%=i%>");changeSplitReqd(this,"amt_limit","<%=i%>","<%=dailyLimitSiteSpec%>",dailyLmtIndicator<%=i%>)'  <%=modifyStatus%>>
				<option value='' <%=(amt_limit_ind.equals("")?"selected":"")%>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<option value='A' <%=(amt_limit_ind.equals("A")?"selected":"")%> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
				<option value='P'  <%=(amt_limit_ind.equals("P")?"selected":"")%>><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
				<option value='U' <%=(amt_limit_ind.equals("U")?"selected":"")%> ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>
			</select>
		</td>
		
		<td class='fields' nowrap WIDTH=''>
			<input type='text' name='perAmt_limit<%=i%>' id='perAmt_limit<%=i%>' size='8' maxlength='13'  <%=modifyStatus%> <%=((amt_limit_ind.equals("")||amt_limit_ind.equals("U"))?" disabled":"")%> onBlur='blngGrpValidForAmtPerUnltd(document.forms[0].amt_limit_ind<%=i%>,this,"<%=i%>","","<%=noofdecimal%>")' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")'; value="<%=amt_limit%>"/>
		</td>

		<td  class='fields' nowrap WIDTH=''>
			<input type='text' name='roundTo<%=i%>' id='roundTo<%=i%>' size='6'  <%=modifyStatus%> maxlength="3"  value="<%=roundTo%>"  onkeypress=" return (allowValidNumber(this,event,noofdecimal.value));"  />
		</td>

		<td  class='fields' nowrap WIDTH=''>
			<select name='roundInd<%=i%>' id='roundInd<%=i%>'    onChange=""   <%=modifyStatus%>>
				<option value='U' <%=uSelect%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
				<option value='D' <%=dSelect%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
			</select>
		</td>
			<%if(ss){%>	
		<td class='fields' nowrap WIDTH='75'><input type='checkbox'   <%=modifyStatus%> name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%> <%="Y".equals(enableDisParam)?"":"disabled" %>  onclick="checkInclHomeMedi(this);">
		<input type='hidden' name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value="<%=enableDisParam%>"> </td>
		<%}else{%>
			<td class='fields' nowrap WIDTH=''><input type='hidden'   <%=modifyStatus%>	name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='Y' >
			<input type='hidden' name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value="Y"> </td>
		<%} %>
		<!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->
		<%if(dailyLimitSiteSpec) { %>			
			<td class='fields' WIDTH='80' nowrap >
				<select name='dailyLmtIndicator<%=i%>' id='dailyLmtIndicator<%=i%>' id='dailyLmtIndicator<%=i%>' <%=modifyStatus%> <%=indicatorFldDisabled%> onchange='dailyLmtIndicatorOnChange(this,<%=i%>,document.blng_grp_rate_based_dtl)' >
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
			<input type='checkbox'   <%=disabled%> name='replace<%=i%>'  <%=modifyStatus%>  <%=replace.equals("Y")?"checked ":""%> onClick='chkBlngGrpReplace(this,"<%=i%>")' value="<%=replace%>"/>
<%
		if(replace.equals("Y"))
		{
%>
			<a name='replace_dtls<%=i%>' href='#' onClick='showBlngGrpReplaceDtls("<%=i%>")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
<%
		}
%>			<input type="hidden" name="replaceSrv_code<%=i%>" id="replaceSrv_code<%=i%>" value="<%=replaceSrv_code%>">
			<input type="hidden" name="replaceSrv_desc<%=i%>" id="replaceSrv_desc<%=i%>" value="<%=replaceSrv_desc%>">
			<input type="hidden" name="replaceSrv_cat_code<%=i%>" id="replaceSrv_cat_code<%=i%>" value="<%=replaceSrv_cat_code%>">
			<input type="hidden" name="replaceSrv_cat_desc<%=i%>" id="replaceSrv_cat_desc<%=i%>" value="<%=replaceSrv_cat_desc%>"> 
		</td>

		<td class='fields' nowrap WIDTH='60'>
			<input type='checkbox'   <%=disabled%>	  <%=modifyStatus%> name='refund<%=i%>' <%=refund.equals("Y")?"checked":""%> onClick='chkBlngGrpRefund(this,"<%=i%>")' value="<%=refund%>"/>
<%	
		if(refund.equals("Y"))
		{
%>
			<input type='text' name='refundAmt<%=i%>' id='refundAmt<%=i%>' value='<%=refundAmt%>' onBlur='validPercentageForRefundBlngGrp(this,"autoRefund<%=i%>")' onkeypress='return allowValidNumber(this,event,noofdecimal.value)' size='2' maxlength='4'  >
<%
		}
%>
		</td>

		<td class='fields' nowrap WIDTH='60'>
			<input type='checkbox'   <%=disabled%>	   <%=modifyStatus%> name='autoRefund<%=i%>' <%=autoRefund.equals("Y")?"checked":""%> onClick='chkBlngGrpAutoRefund(this,"refundAmt<%=i%>")' value="<%=autoRefund%>"/>
		</td>

		<td class='fields' nowrap WIDTH='60'>
			<input type='checkbox'    name='factor_appl<%=i%>' id='factor_appl<%=i%>'	 <%=modifyStatus%> <%=factor_appl.equals("Y")?"checked":""%> onClick='blngGrpFactorAppl(this,"<%=i%>")' value="<%=factor_appl%>"/>
		</td>

		<td class='fields' nowrap WIDTH='60'>
			<input type='radio' name='closePkg' id='closePkg'  <%=modifyStatus%> <%=closePkg.equals("Y")?" checked ":""%> <%=closePkgStat%> onClick="blngGrpAssignClosePkgVal(this,'<%=i%>')"/>
			<input type='hidden' name='closePkg<%=i%>' id='closePkg<%=i%>' value="<%=closePkg%>" />
		</td>

		<td class='fields' nowrap WIDTH='80'>
			<a name='service_limit_dtls<%=i%>' href='#' onClick='blngGrpServiceLimitDtls("<%=i%>")' ><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
		</td>
		<td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=modifyStatus%>	name='split_reqd<%=i%>' id='split_reqd<%=i%>' <%="U".equals(amt_limit_ind)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);" <%= !"*".equals(dailyLmtInd)?" disabled ":"" %>></td>
		<td class='fields'  nowrap WIDTH='50'>
			<input type='checkbox'  name='deleteService<%=i%>' id='deleteService<%=i%>'	  <%=modifyStatus%> onClick='chkBlngGrpDeleteService(this,"<%=i%>")' value="N"/>
		</td>
	</tr>
<%
	}
	}
	else
	{
%>
	<tr>
		<td class='fields' nowrap WIDTH=''> 
<%
		if(order_associated.equals("Y"))
		{
%>
			<select name='type0' id='type0' onChange='onBlngGrpServiceTypeChange(this,"0")'  <%=modifyStatus%>>
				<option value='S'  ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>
			</select>
<%
		}
		else
		{
%>
			<select name='type0' id='type0' onChange='onBlngGrpServiceTypeChange(this,"0")'  <%=modifyStatus%>>
				<option value='G' ><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/></option>
				<option value='C' ><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/></option>
				<option value='S' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>
	<!-- Modified by Muthu against KDAH-SCF-0057 on 27-4-12 -->
				<option value='P' ><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"/>	</option>
	<!-- Modified by Muthu against KDAH-SCF-0057 -->
			</select>
<%
		}
%>
		</td>

		<td class='fields' nowrap WIDTH=''>
			<input type='hidden' name='service_code0' id='service_code0' value=''>
			<input type='text' name = 'service_desc0' size='10' maxlength='10'  <%=modifyStatus%> onBlur="before_blngGrpServiceLookUp(this,service_code0,type0,'0')" value="">
			<INPUT type='hidden' name='service_desc_temp0' id='service_desc_temp0' value=''>
			<input type='button' name='service_button0' id='service_button0' class='button' value='?'	 <%=modifyStatus%> onclick="blngGrpServiceLookUp(service_desc0,service_code0,type0,'0')">
			<input type='hidden' name='oldSrvKey0' id='oldSrvKey0' value=''>
		</td>
					
		<td class='fields' nowrap WIDTH=''>
			<input type='hidden' name='catalog_code0' id='catalog_code0' value=''>
			<input type='text' name = 'catalog_desc0'  <%=ordCatDisabled%> size='10' maxlength='10'	  <%=modifyStatus%> onBlur="before_blngGrpCatalogLookUp(this,catalog_code0,service_code0,'0')" value=''>
			<INPUT type='hidden' name='catalog_desc_temp0' id='catalog_desc_temp0' value=''>
			<input type='button' name='catalog_button0' id='catalog_button0'  <%=ordCatDisabled%>  class='button' value='?'	  <%=modifyStatus%> onclick="blngGrpCatalogLookUp(catalog_desc0,catalog_code0,service_code0,'0')">
		</td>
	
		<td  class='fields' nowrap WIDTH=''>
<%
		if(type.equals("G") || type.equals("C"))
		{ 
%>
			<select name='ind0' id='ind0' onChange='onBlngGrpIndChange(this,"0")'  <%=modifyStatus%>>
				<option value='S' ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option>
				<option value='R'  ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option>
				<option value='P'  ><fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/></option>
			</select>
<%		
		}
		else
		{
%>	
			<select name='ind0' id='ind0' onChange='onBlngGrpIndChange(this,"0")'  <%=modifyStatus%>>
				<option value='S' ><fmt:message key="Common.Standard.label" bundle="${common_labels}"/></option>
				<option value='R' ><fmt:message key="eBL.AsPerRule.label" bundle="${bl_labels}"/></option>
				<option value='U' ><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></option>
				<option value='P'  ><fmt:message key="eBL.PRICE_CLASS.label" bundle="${bl_labels}"/></option>
				<option value='X'  ></option>
			</select>
<%
		}
%>
		</td>
		<td class='fields' nowrap WIDTH=''>
			<input type='text' name='factorOrRate0' id='factorOrRate0' size='12' <%=modifyStatus%> maxlength="13"  onBlur='checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8665");' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")'; value="" />
		</td>
			
		<td class='fields' nowrap WIDTH=''>
			<input type='text'    name='qty_limit0' id='qty_limit0'   size='8'	  <%=modifyStatus%> <%=disabled%> onBlur='chkBlngGrpQtyLimit(this,"0");' onkeypress='return allowValidNumber(this,event,noofdecimal.value)'; value="" />
		</td>

		<td  class='fields' nowrap WIDTH=''>
			<select name='amt_limit_ind0' id='amt_limit_ind0' onChange='validateBlngGrpInd(this,"0");changeSplitReqd(this,"amt_limit","0","<%=dailyLimitSiteSpec%>",dailyLmtIndicator0)'  <%=modifyStatus%>>
				<option value='' <%=(amt_limit_ind.equals("")?"selected":"")%>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<option value='A' <%=(amt_limit_ind.equals("A")?"selected":"")%> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
				<option value='P' <%=(amt_limit_ind.equals("P")?"selected":"")%>><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
				<option value='U' <%=(amt_limit_ind.equals("U")?"selected":"")%>><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>
			</select>
		</td>

		<td class='fields' nowrap WIDTH=''>
			<input type='text' name='perAmt_limit0' id='perAmt_limit0' size='8' maxlength='13'   <%=modifyStatus%> <%=((amt_limit_ind.equals("")||amt_limit_ind.equals("U"))?" disabled":"")%> onBlur='blngGrpValidForAmtPerUnltd(document.forms[0].amt_limit_ind0,this,"0","","<%=noofdecimal%>")' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")'; value=""/>
		</td>
		<td  class='fields' nowrap WIDTH=''>
			<input type='text' name='roundTo0' id='roundTo0' size='6' maxlength="3"   <%=modifyStatus%> value=""  onkeypress=" return (allowValidNumber(this,event,noofdecimal.value));"  />
		</td>

		<td  class='fields' nowrap WIDTH=''>
			<select name='roundInd0' id='roundInd0'    onChange=""   <%=modifyStatus%>>
				<option value='U' <%=uSelect%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
				<option value='D' <%=dSelect%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
			</select>
		</td>
		
			<%if(ss){%>
			<td class='fields' nowrap WIDTH='75'>
				<input type='checkbox'   <%=modifyStatus%>	name='includeHomeMedication0' id='includeHomeMedication0' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%> <%="Y".equals(enableDisParam)?"":"disabled" %>onclick="checkInclHomeMedi(this);">
				<input type='hidden' name='enableDisParam0' id='enableDisParam0' id='enableDisParam0' value="<%=enableDisParam%>"> </td>
		<% } else{%>
			<td class='fields' nowrap WIDTH='' style="visibility: hidden;">
				<input type='hidden' 	<%=modifyStatus%> name='includeHomeMedication0' id='includeHomeMedication0' value='Y' >
				<input type='hidden' name='enableDisParam0' id='enableDisParam0' id='enableDisParam0' value="Y"> </td>
		<%} %>
		<%if(dailyLimitSiteSpec) { %>
			<td class='fields' WIDTH='80' nowrap >
				<select name='dailyLmtIndicator0' id='dailyLmtIndicator0' id='dailyLmtIndicator0' <%=modifyStatus%> <%=indicatorFldDisabled%> onchange='dailyLmtIndicatorOnChange(this,0,document.blng_grp_rate_based_dtl)' >
					<option value="*"><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
					<% if("G".equals(dailyPkgLmt) || "B".equals(dailyPkgLmt)) { %>
						<option value="G"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
					<% } if("I".equals(dailyPkgLmt) || "B".equals(dailyPkgLmt)) {%>
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
			<input type='checkbox'   <%=disabled%> name='replace0'  <%=modifyStatus%> onClick='chkBlngGrpReplace(this,"0")' value=""/>
			<input type="hidden" name="replaceSrv_code0" id="replaceSrv_code0" value="">
			<input type="hidden" name="replaceSrv_desc0" id="replaceSrv_desc0" value="">
			<input type="hidden" name="replaceSrv_cat_code0" id="replaceSrv_cat_code0" value="">
			<input type="hidden" name="replaceSrv_cat_desc0" id="replaceSrv_cat_desc0" value="">
		</td>

		<td class='fields' nowrap WIDTH='60'>
			<input type='checkbox'   <%=disabled%> name='refund0'  <%=modifyStatus%> onClick='chkBlngGrpRefund(this,"0")' value=""/>
		</td>

		<td class='fields' nowrap WIDTH='60'>
			<input type='checkbox'  <%=modifyStatus%>  <%=disabled%> name='autoRefund0'  onClick='chkBlngGrpAutoRefund(this,"refundAmt0")' value=""/>
		</td>

		<td class='fields' nowrap WIDTH='60'>
			<input type='checkbox'    name='factor_appl0' id='factor_appl0' 	  <%=modifyStatus%> onClick='blngGrpFactorAppl(this,"0")' value=""/>
		</td>

		<td class='fields' nowrap WIDTH='60'>
			<input type='radio' name='closePkg' id='closePkg'  <%=closePkgStat%>	  <%=modifyStatus%> onClick="blngGrpAssignClosePkgVal(this,'0')"/>
			<input type='hidden' name='closePkg0' id='closePkg0' value="" />
		</td>

		<td class='fields' nowrap WIDTH='80'>
			<a name='service_limit_dtls0' href='#' onClick='blngGrpServiceLimitDtls("0")' ><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
		</td>
		<td class='fields' nowrap WIDTH='60'><input type='checkbox'   <%=modifyStatus%>	name='split_reqd0' id='split_reqd0' <%="U".equals(amt_limit_ind)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);" <%= !"*".equals(dailyLmtInd)?" disabled ":"" %> ></td>
		<td class='fields' nowrap WIDTH='50'>
			<input type='checkbox'  name='deleteService0' id='deleteService0'	   <%=modifyStatus%> onClick='chkBlngGrpDeleteService(this,"0")' value="N"/>
		</td>
	</tr>
<%	
	}
%>
</table>
<INPUT TYPE="hidden" name='packageCode' id='packageCode' value="<%=packageCode%>">
<INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
<INPUT TYPE="hidden" name='copyFrm_pkgCode' id='copyFrm_pkgCode' value="<%=copyFrm_pkgCode%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="order_associated" id="order_associated" value="<%=order_associated%>">	
<input type="hidden" name="acrossEncounters" id="acrossEncounters" value="<%=acrossEncounters%>">	
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
<input type='hidden' name='fromDateTemp' id='fromDateTemp' value="<%=fromDateTemp%>" />
<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
<input type='hidden' name='blng_grp_code' id='blng_grp_code' value="<%=blng_grp_code%>" >
<input type='hidden' name='blng_grp_desc' id='blng_grp_desc' value="<%=blng_grp_desc%>" >
<input type='hidden' name='parent_index' id='parent_index' value="<%=parent_index%>" />
<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
<input type='hidden' name='blngGrpChgBasedRcdSize' id='blngGrpChgBasedRcdSize' value='<%= blngGrpChgBasedRcdSize%>'/> <!-- Added By Vijay For MMS-SCF-DM-0357 -->
<input type='hidden' name='siteId' id='siteId' id ='siteId' value='<%=ss %>' />
<input type='hidden' name='dailyLimitSiteSpec' id='dailyLimitSiteSpec'  id='dailyLimitSiteSpec' value='<%=dailyLimitSiteSpec%>' ><!-- Added V190320-Aravindh/MMS-DM-CRF-0129 -->
<input type='hidden' name='modifyStatus' id='modifyStatus'  id='modifyStatus' value='<%=modifyStatus%>' ><!-- Added V190409-Aravindh/MMS-DM-CRF-0129 -->
<input type='hidden' name='pkgServLimit' id='pkgServLimit'  id='pkgServLimit' value='<%=pkgServLimit%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
<input type='hidden' name='dailyPkgLmt' id='dailyPkgLmt'  id='dailyPkgLmt' value='<%=dailyPkgLmt%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
<input type='hidden' name='dailyLmtChkYN' id='dailyLmtChkYN'  id='dailyLmtChkYN' value='<%=dailyLmtChkYN%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
<input type='hidden' name='amtFldDisabled' id='amtFldDisabled'  id='amtFldDisabled' value='<%=amtFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
<input type='hidden' name='qtyFldDisabled' id='qtyFldDisabled'  id='qtyFldDisabled' value='<%=qtyFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 --> 
<input type='hidden' name='indicatorFldDisabled' id='indicatorFldDisabled'  id='indicatorFldDisabled' value='<%=indicatorFldDisabled%>' ><!-- Added V190626-Aravindh/MMS-DM-CRF-0129.1 -->
<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>"> <!--V211130--> 
</form>
<script>
	alignHeading();initializeBlngGrpRateForm();updateCurrentForm("BLNG_GRP_RATE_BASED","parent.frames[4].frames[1].document.forms[0]","parent.frames[4].frames[2].document.blng_grp_srvLimit_rate_based_dtl","parent.parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader",<%=totalRecords%>);
</script>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>

<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

