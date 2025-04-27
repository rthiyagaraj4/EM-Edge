<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>



<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../../eBL/js/PkgDefBlngGrp.js'></script>
<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
		var headTop = -1;
		var FloatHead1;
		function processScroll()
			{
				if (headTop < 0)
				{
					saveHeadPos();
					
				}
				if (headTop>0)
				{
					if (document.documentElement && document.documentElement.scrollTop)
						theTop = document.documentElement.scrollTop;
					else if (document.body)
						theTop = document.body.scrollTop;

					if (theTop>headTop)
						FloatHead1.style.top = (theTop-headTop) + 'px';
					else
						FloatHead1.style.top = '0px';
				}
			}

			function saveHeadPos()
			{
				parTable = document.getElementById("divHeadSep");
				if (parTable != null)
				{
					headTop = parTable.offsetTop + 3;
					FloatHead1 = document.getElementById("heading");
					FloatHead1.style.position = "relative";
				}
			}
		</script>
</head>
<style>
		thead td, thead td.locked	{
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		</style>

<% 
	try
	{		
		String bean_id		     = "bl_PkgDefBlngGrpBean" ;
		String bean_name	     = "eBL.PkgDefBlngGrpBean";
		PkgDefBlngGrpBean bean	 = (PkgDefBlngGrpBean)getBeanObject( bean_id, bean_name, request ) ;
		String locale			 = (String)session.getAttribute("LOCALE");
		String facilityId		 = (String) session.getValue( "facility_id" ) ;
		String packageCode		 = "" ;
		String mode				 = "" ;
		
		String parent_index		 =  request.getParameter("parent_index")== null ? "" : request.getParameter("parent_index"); 
		String fromDate			 =  request.getParameter("fromDate")== null ? "" : request.getParameter("fromDate"); 		
		String toDate			 = "";

		String pkgPriceClsCode	 = "";
		String pkgPriceClsDesc	 = "";
		String oPkgPriceClsCode	 = "";
		String oPkgPriceClsDesc	 = "";		
		String glSmry	 = "";		
		String glSmryDesc	 = "";		
		String glSmryDisc	 = "";		
		String glSmryDiscDesc	 = "";	
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts		
		String VATapp		 = "";
		String VATapp_old		 = "";
		String VATpercent	 = "";
		String ruleCoverageInd	 = "";
		String flagval="insert";
		String asperpolicy="", payercoverage="", patientcoverage="",defSelect="";
		boolean boolIsAfter=true;
		String VATSetup="";
		String VATapplCheck="";
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
	//	String code				 = "";//unused variable
		int  totRec				 = 1;
		bean.setModifyBlngGrpPeriod("Y");	
		HashMap blng_grp_period	     =	new HashMap();
		String[] record;
		//Added V190325 Gayathri/KDAH-CRF-0503
		String isMasterPackYN	=request.getParameter("isMasterPackageYN");
		if(isMasterPackYN == null || isMasterPackYN == "") isMasterPackYN="N";
		blng_grp_period    = (HashMap)bean.getBlngGrpPeriod();
		String glSmryYN=bean.getGLSmryYN(facilityId);
		if(glSmryYN==null) glSmryYN="";
		ArrayList blng_grp_period_list=new ArrayList();
		String blng_grp_code				 =  request.getParameter("blng_grp_code")==null ? "" :request.getParameter("blng_grp_code") ;
		String blng_grp_desc				 =  request.getParameter("blng_grp_desc")==null ? "" :request.getParameter("blng_grp_desc") ;		
		packageCode				 =  request.getParameter("packageCode")==null ? "" :request.getParameter("packageCode") ;
		mode					 = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";

		if(blng_grp_period!=null && blng_grp_period.size()>0 && blng_grp_period.containsKey(blng_grp_code.trim())){
		blng_grp_period_list=(ArrayList)blng_grp_period.get(blng_grp_code.trim());
		}
		if(blng_grp_period_list!=null && blng_grp_period_list.size()>0 ){
				totRec=blng_grp_period_list.size();		
		}
		
			Connection con = null;	
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts	
			Boolean VATapplicableYN=false;
			String VATapplicable ="";
				
			//sarath jan/10/2017 added code to make as siteSpecific MMS-QF-SCF-0545 beginning...					
			Boolean SiteSpec=false;
			String SiteSpecific ="";
			Boolean allow_masterChild_pack=false;
			String allow_masterChild_package="N";
			try
			{
				con = ConnectionManager.getConnection();	
				SiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","PKG_MANDATORY_TABCLK_CHK");
				VATapplicableYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","VAT_CHANGES_APPLICABLE_YN");	
				allow_masterChild_pack = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ALLOW_MASTER_CHILD_PKG_MAPPING");	
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception in site specific "+e);
			}
			finally{
				ConnectionManager.returnConnection(con);				
			}
			if(SiteSpec){
				SiteSpecific="Y";
			}
			else{
				SiteSpecific="N";
			} 
			if(VATapplicableYN){
				VATapplicable="Y";
			}
			else{
				VATapplicable="N";
			}
			if(allow_masterChild_pack){
				allow_masterChild_package="Y";
			}
			else{
				allow_masterChild_package="N";
			}
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
			//sarath jan/10/2017 added code to make as siteSpecific MMS-QF-SCF-0545 ending...
		
%>		
	<%	
		
   %>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	<form name='blng_grp_period_dtl' id='blng_grp_period_dtl'>	
	<!-- <div id="tbl-container" STYLE="overflow: auto; width: 1020px; height: 355px;   padding:3px; margin: 0px"> -->
	<div id="tbl-container" STYLE="overflow-x:scroll; width: 100%;    padding:3px; margin: 0px">
<!--<div id="divHeadSep" style="position: absolute;">-->
	<table class='grid' width='100%' height='70%' id="blng_grp_period_tbl">
		<thead>
		<!--Added by muthu against 31860 on 5/7/2012 Starts here -->
	<tr><td class='COLUMNHEADER'  colspan='12' align='LEFT'><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/>&nbsp;: &nbsp;<%=blng_grp_desc%></td>
	</tr>
		<tr>
		<td  class='COLUMNHEADER'  align='left'><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER'  align='left'><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER'  align='left'><fmt:message key="eBL.PACKAGE_PRICE_CLASS.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' nowrap="nowrap" align='left'><fmt:message key="eBL.OUTSIDE_PACKAGE_PRICE_CLASS.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' nowrap="nowrap" align='left'><fmt:message key="eBL.AccountingCode.label" bundle="${bl_labels}"/> </td>
		<td  class='COLUMNHEADER' nowrap="nowrap" align='left'><fmt:message key="eBL.DISC_ACC_CODE.label" bundle="${bl_labels}"/> </td>
<!-- Added by muthu against 31860 on 5/3/2012 -->
	<td  class='COLUMNHEADER' nowrap="nowrap"  align='left'><fmt:message key="eBL.CopyBaseDef.label" bundle="${bl_labels}"/> </td>
	<td  class='COLUMNHEADER' nowrap="nowrap" align='left'><fmt:message key="eBL.ReplaceWithBaseDef.label" bundle="${bl_labels}"/> </td>
<!-- Added by muthu against 31860 on 5/3/2012 -->
<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts -->
<%if("Y".equals(VATapplicable)) {%>
		<td  class='COLUMNHEADER'><fmt:message key="eBL.VAT_APPLICABLE.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER'><fmt:message key="eBL.VAT_PERCENTAGE.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER'><fmt:message key="eBL.RULE_COVERAGE.label" bundle="${bl_labels}"/></td>
<%} %>
<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends -->
		<td  class='COLUMNHEADER' >&nbsp;</td>
		</tr>
		
			</thead>
	<tbody>
		<%

if(blng_grp_period_list!=null && blng_grp_period_list.size()>0){
	for(int i=0;i<blng_grp_period_list.size();i++){
		record=new String[6];				
		record=(String[])blng_grp_period_list.get(i);
		fromDate		= record[0];
		toDate		= record[1];
	    pkgPriceClsCode	=	record[2];
		pkgPriceClsDesc		=record[3];
		oPkgPriceClsCode		=record[4];	  
		oPkgPriceClsDesc		=record[5];	  
		glSmry		=record[6];	  
		glSmryDesc		=record[7];	  
		glSmryDisc		=record[8];	  
		glSmryDiscDesc		=record[9];	  
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
		VATapp		=record[10];	  
		VATpercent		=record[11];	  
		ruleCoverageInd		=record[12];	
		flagval=record[13];
		VATapp_old		=record[14];	

		asperpolicy=("S").equals(ruleCoverageInd) ?"SELECTED" :"";
		payercoverage=("P").equals(ruleCoverageInd) ?"SELECTED" :"";
		patientcoverage=("C").equals(ruleCoverageInd) ?"SELECTED" :"";
		defSelect=("").equals(ruleCoverageInd) ?"SELECTED" :"";
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends

	    %>
			
		<tr width='100%' height='50%' scrolling='yes' >								
		<td  class='fields' ><input type='text' name='fromDate_<%=i%>' id='fromDate_<%=i%>' <%=modifyStatus%>  size='10' maxlength="10"  value="<%=fromDate%>"   onBlur="blngGrpValidateDate(this,this,toDate_<%=i%>,'<%=i%>');showBlngGrpBasePrice(this,'<%=i%>');" ><img id = 'fromDate_img_<%=i%>' name="fromDate_img_<%=i%>"	 <%=modifyStatus%>  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fromDate_<%=i%>');"   /><img src='../../eCommon/images/mandatory.gif'/><input type='hidden' name='oldPeriodKey<%=i%>' id='oldPeriodKey<%=i%>' value='<%=(blng_grp_code+"~~"+fromDate)%>'></td>
				
		<td  class='fields' ><input type='text' name='toDate_<%=i%>' id='toDate_<%=i%>'  <%=modifyStatus%>  id='toDate_<%=i%>' size='10' maxlength="10"  value="<%=toDate%>"  onBlur="blngGrpValidateDate(this,fromDate_<%=i%>,this,'<%=i%>');" ><img id = 'toDate_img_<%=i%>' name="toDate_img_<%=i%>"	 src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('toDate_<%=i%>');" ></td>
		<td  class='fields' nowrap="nowrap"><input type='text' name='pkgPriceClsCode_<%=i%>' id='pkgPriceClsCode_<%=i%>' size='8'	<%=modifyStatus%>  maxlength="8"  value="<%=pkgPriceClsCode%>" onBlur="callBlngGrpPriceClass(this,'code','PRICE_CLASS','<%=i%>')" > <input type='text' name='pkgPriceClsDesc_<%=i%>' id='pkgPriceClsDesc_<%=i%>' size='10'	<%=modifyStatus%>  maxlength="10"  value="<%=pkgPriceClsDesc%>" onBlur="callBlngGrpPriceClass(this,'desc','PRICE_CLASS','<%=i%>')" ><input type='button' class='button' name='pkgPriceCls_<%=i%>' id='pkgPriceCls_<%=i%>'	 <%=modifyStatus%>  value='?' onClick="callBlngGrpPriceClass('','','PRICE_CLASS','<%=i%>')" tabindex='0'/></td>
		<td  class='fields' nowrap="nowrap"><input type='text'	<%=modifyStatus%>  name='oPkgPriceClsCode_<%=i%>' size='8' maxlength="8"  value="<%=oPkgPriceClsCode%>" onBlur="callBlngGrpPriceClass(this,'code','OUT_PRICE_CLASS','<%=i%>')" />
		<input type='text' name='oPkgPriceClsDesc_<%=i%>' id='oPkgPriceClsDesc_<%=i%>' size='10'	<%=modifyStatus%>  maxlength="10"  value="<%=oPkgPriceClsDesc%>" onBlur="callBlngGrpPriceClass(this,'desc','OUT_PRICE_CLASS','<%=i%>')"/><input type='button' class='button' name='OPkgPriceCls_<%=i%>' id='OPkgPriceCls_<%=i%>' value='?'	  <%=modifyStatus%>  onClick="callBlngGrpPriceClass('','','OUT_PRICE_CLASS','<%=i%>')" tabindex='0'/></td>
		<td align="left" nowrap><input type='text' name='glSmry<%=i%>' id='glSmry<%=i%>' size='6' <%=modifyStatus%>  maxlength="6" value="<%=glSmry%>" <%=glSmryYN.equals("N")?"disabled":""%> onBlur="blngGrpGlSmryCodeLookUp(glSmryDesc<%=i%>,this,'<%=i%>')"/><input type='text' name='glSmryDesc<%=i%>' id='glSmryDesc<%=i%>' size='15' maxlength="15"	<%=modifyStatus%>  <%=glSmryYN.equals("N")?"disabled":""%> value="<%=glSmryDesc%>" onBlur="blngGrpGlSmryDescLookUp(this,glSmry<%=i%>,'<%=i%>')"/><INPUT type='hidden' name='glSmry_temp<%=i%>' id='glSmry_temp<%=i%>' value=''><INPUT type='hidden' name='glSmryDesc_temp<%=i%>' id='glSmryDesc_temp<%=i%>' value=''><input type='button' class='button' name='glSmryLookUp<%=i%>' id='glSmryLookUp<%=i%>' value='?'	 <%=modifyStatus%>  onClick="blngGrpGlSmryLookUp(glSmryDesc<%=i%>,glSmry<%=i%>,'<%=i%>');"  <%=glSmryYN.equals("N")?" disabled ":""%>/></td>
		<td align="left" nowrap><input type='text' name='glSmryDisc<%=i%>' id='glSmryDisc<%=i%>' size='6' <%=modifyStatus%>  maxlength="6" value="<%=glSmryDisc%>" <%=glSmryYN.equals("N")?"disabled":""%> onBlur="blngGrpGlSmryDiscCodeLookUp(glSmryDiscDesc<%=i%>,this,'<%=i%>')"/><input type='text' name='glSmryDiscDesc<%=i%>' id='glSmryDiscDesc<%=i%>' size='15' maxlength="15"	<%=modifyStatus%>  <%=glSmryYN.equals("N")?"disabled":""%> value="<%=glSmryDiscDesc%>" onBlur="blnggrpGlSmryDiscDescLookUp(this,glSmryDisc<%=i%>,'<%=i%>')"/><INPUT type='hidden' name='glSmryDisc_temp<%=i%>' id='glSmryDisc_temp<%=i%>' value=''><INPUT type='hidden' name='glSmryDiscDesc_temp<%=i%>' id='glSmryDiscDesc_temp<%=i%>' value=''><input type='button' class='button' name='glSmryDiscLookUp<%=i%>' id='glSmryDiscLookUp<%=i%>' value='?'	 <%=modifyStatus%>  onClick="blngGrpGlSmryDiscLookUp(glSmryDiscDesc<%=i%>,glSmryDisc<%=i%>,'<%=i%>');"  <%=glSmryYN.equals("N")?" disabled ":""%>/></td>
		<!-- Added by muthu against 31860 on 5/3/2012 -->
		<td align="left" style="white-space: nowrap"><input type='checkbox' name='CopyBase<%=i%>' id='CopyBase<%=i%>' value="" onclick="CopyBaseChk()"></td>
		<td align="left" style="white-space: nowrap">
		<input type='checkbox' name='ReplaceBase<%=i%>' id='ReplaceBase<%=i%>' value="" onclick="ReplaceBaseChk()">
		<INPUT type='hidden' name='VATapp1<%=i%>' id='VATapp1<%=i%>' value="<%=VATapp_old%>">
		</td>
		<!-- Added by muthu against 31860 on 5/3/2012 -->
		<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts -->
		<%if("Y".equals(VATapplicable)) {
			boolIsAfter= com.ehis.util.DateUtils.isBefore(toDate,"31/12/2017", "DMY", locale);
		
			if((("Y".equals(VATapp)) &&("modify".equals(flagval)) &&(("Y").equals(VATapp_old))) || (((!("").equals(fromDate)) &&(!("").equals(toDate)))&& boolIsAfter))
				VATSetup="disabled";
			else
				VATSetup="";	
		%>	
		<td>
		<input type='checkbox' name='VATapp<%=i%>' id='VATapp<%=i%>' id='VATapp<%=i%>' value="<%=VATapp%>"  <%=VATapp.equals("Y")?"checked":""%>	<%=VATSetup %><%=modifyStatus%>  onClick="ruleCodeLookup_blng_grp(this,'<%=i%>')">
		</td>
			<%
			if((!("Y".equals(VATapp)))|| ("modify".equals(flagval))&&("Y").equals(VATapp_old)){
				VATapplCheck=" disabled ";		
			}
			else{
				VATapplCheck="";			  
			}
		%>
		<td style="white-space: nowrap" width="6%">
		<input type='text' name='VATpercent<%=i%>' id='VATpercent<%=i%>' id='VATpercent<%=i%>' size='6' maxlength="6"  value="<%=VATpercent%>" <%=modifyStatus%> <%=VATapplCheck%> nowrap  onBlur="ruleCodeLookup_blng_grp(VATpercent<%=i%>,'<%=i%>')"  />
		<input type='button' class='button' name='VATpercent_temp<%=i%>' id='VATpercent_temp<%=i%>' id='VATpercent_temp<%=i%>' value='?' <%=modifyStatus%> <%=VATapplCheck%> nowrap onClick="ruleCodeLookup_blng_grp(VATpercent<%=i%>,'<%=i%>')"/>

		</td>
		<td>
			<select name='ruleCoverageInd<%=i%>' id='ruleCoverageInd<%=i%>' onChange="" <%=modifyStatus%> <%=VATapplCheck%>> 
			<option value='' <%=defSelect%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='S' <%=asperpolicy%>><fmt:message key="eBL.AS_PER_POLICY.label" bundle="${common_labels}"/></option>
			<option value='C' <%=patientcoverage%>><fmt:message key="eBL.PATIENT_COVERAGE.label" bundle="${common_labels}"/></option>
			<option value='P' <%=payercoverage%>><fmt:message key="eBL.PAYER_COVERAGE.label" bundle="${common_labels}"/></option>
			</select>
			</td>
		<%}else{
		}%>
		<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends -->
		<td align="left" nowrap>		
			<a name='select_<%=i%>' href='#' onClick='showBlngGrpBasePrice(this,"<%=i%>")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
		<input type='hidden' name='flag_<%=i%>' id='flag_<%=i%>' value="<%=mode%>" >
		<input type='hidden' name='flagVal<%=i%>' id='flagVal<%=i%>' value="<%=flagval%>" ></td>
		</tr>
		<%	
		}
		}else{ %>
	    		<tr width='100%' height='50%' scrolling='yes'>
			<td  class='fields' ><input type='text' name='fromDate_0' id='fromDate_0'	  <%=modifyStatus%>  id='fromDate_0' size='10' maxlength="10"  value=""   onBlur="blngGrpValidateDate(this,this,toDate_0,'0');showBlngGrpBasePrice(this,'0');" ><img id = 'fromDate_img_0' name="fromDate_img_0"	  <%=modifyStatus%>  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fromDate_0');"   /><img src='../../eCommon/images/mandatory.gif'/><input type='hidden' name='oldPeriodKey0' id='oldPeriodKey0' value=''></td>
			<td  class='fields' ><input type='text' name='toDate_0' id='toDate_0' <%=modifyStatus%>  id='toDate_0' size='10' maxlength="10"  value=""  onBlur="blngGrpValidateDate(this,fromDate_0,this,'0');" ><img id = 'toDate_img_0' name="toDate_img_0"		 <%=modifyStatus%>  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('toDate_0');" ></td>
			<td  class='fields' nowrap="nowrap">			
			<input type='text' name='pkgPriceClsCode_0' id='pkgPriceClsCode_0' size='8' maxlength="8" <%=modifyStatus%>  value="" onBlur="callBlngGrpPriceClass(this,'code','PRICE_CLASS','0')" > <input type='text' name='pkgPriceClsDesc_0' id='pkgPriceClsDesc_0' size='10' maxlength="10" 	 <%=modifyStatus%>  value="" onBlur="callBlngGrpPriceClass(this,'desc','PRICE_CLASS','0')" ><input type='button' class='button' name='pkgPriceCls_0' id='pkgPriceCls_0' value='?'   <%=modifyStatus%>  onClick="callBlngGrpPriceClass('','','PRICE_CLASS','0')" tabindex='0'/>
			</td>				
			<td  class='fields' nowrap="nowrap"><input type='text' name='oPkgPriceClsCode_0' id='oPkgPriceClsCode_0'	<%=modifyStatus%>  size='8' maxlength="8"  value="" onBlur="callBlngGrpPriceClass(this,'code','OUT_PRICE_CLASS','0')" /><input type='text' name='oPkgPriceClsDesc_0' id='oPkgPriceClsDesc_0' size='10' maxlength="10"  value=""	<%=modifyStatus%>  onBlur="callBlngGrpPriceClass(this,'desc','OUT_PRICE_CLASS','0')"/><input type='button' class='button' name='OPkgPriceCls_0' id='OPkgPriceCls_0' value='?'	<%=modifyStatus%>  onClick="callBlngGrpPriceClass('','','OUT_PRICE_CLASS','0')" tabindex='0'/>
			</td>
			<td align="left" nowrap>
			<input type='text' name='glSmry0' id='glSmry0' size='6' maxlength="6" value=""	 <%=modifyStatus%>  <%=glSmryYN.equals("N")?"disabled":""%> onBlur="blngGrpGlSmryCodeLookUp(glSmryDesc0,this,'0')"/><input type='text' name='glSmryDesc0' id='glSmryDesc0' size='15' maxlength="15"  <%=modifyStatus%>  <%=glSmryYN.equals("N")?"disabled":""%> value="" onBlur="blngGrpGlSmryDescLookUp(this,glSmry0,'0')"/><INPUT type='hidden' name='glSmry_temp0' id='glSmry_temp0' value=''><INPUT type='hidden' name='glSmryDesc_temp0' id='glSmryDesc_temp0' value=''><input type='button' class='button' name='glSmryLookUp0' id='glSmryLookUp0'	<%=modifyStatus%>  value='?' onClick="blngGrpGlSmryLookUp(glSmryDesc0,glSmry0,'0');"  <%=glSmryYN.equals("N")?" disabled ":""%>/></td>
			<td align="left" nowrap>
			<input type='text' name='glSmryDisc0' id='glSmryDisc0' size='6' maxlength="6" value=""	 <%=modifyStatus%>  <%=glSmryYN.equals("N")?"disabled":""%> onBlur="blngGrpGlSmryDiscCodeLookUp(glSmryDiscDesc0,this,'0')"/><input type='text' name='glSmryDiscDesc0' id='glSmryDiscDesc0' size='15' maxlength="15"  <%=modifyStatus%>  <%=glSmryYN.equals("N")?"disabled":""%> value="" onBlur="blngGrpGlSmryDiscDescLookUp(this,glSmryDisc0,'0')"/><INPUT type='hidden' name='glSmryDisc_temp0' id='glSmryDisc_temp0' value=''><INPUT type='hidden' name='glSmryDiscDesc_temp0' id='glSmryDiscDesc_temp0' value=''><input type='button' class='button' name='glSmryDiscLookUp0' id='glSmryDiscLookUp0'	<%=modifyStatus%>  value='?' onClick="blngGrpGlSmryDiscLookUp(glSmryDiscDesc0,glSmryDisc0,'0');"  <%=glSmryYN.equals("N")?" disabled ":""%>/></td>

	<!-- Added by muthu against 31860 on 5/3/2012 -->
		<td align="left" nowrap>
		<input type='checkbox' name='CopyBase' id='CopyBase' value="" onclick="CopyBaseChk()">
		</td>

		<td align="left" nowrap>
		<input type='checkbox' name='ReplaceBase' id='ReplaceBase' value="" onclick="ReplaceBaseChk()">
		</td>
	<!-- Added by muthu against 31860 on 5/3/2012 -->
	<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts -->
	<%if("Y".equals(VATapplicable)) {%>
	<td>
		<input type='checkbox' name='VATapp0' id='VATapp0' id='VATapp0' value=""  <%=VATapp.equals("Y")?"checked":""%>	<%=modifyStatus%> onClick="ruleCodeLookup_blng_grp(this,'0')">
		</td>
			<%
				if("Y".equals(VATapp)){
					VATapplCheck="";
				}
				else
				{
					VATapplCheck="disabled";
				}			
			%>
		<td style="white-space: nowrap" width="6%">
		<input type='text' name='VATpercent0' id='VATpercent0' id='VATpercent0' size='6' maxlength="6"  value="" <%=modifyStatus%> <%=VATapplCheck%> onBlur="ruleCodeLookup_blng_grp(VATpercent0,'0')"  />
		<input type='button' class='button' name='VATpercent_temp0' id='VATpercent_temp0' id='VATpercent_temp0' value='?' <%=modifyStatus%> <%=VATapplCheck%> onClick="ruleCodeLookup_blng_grp(VATpercent0,'0')"/>
</td>
<td>
	<select name='ruleCoverageInd0' id='ruleCoverageInd0'  onChange="" <%=modifyStatus%> <%=VATapplCheck%>> 
	<option value='' <%=defSelect%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<option value='S' <%=asperpolicy%>><fmt:message key="eBL.AS_PER_POLICY.label" bundle="${common_labels}"/></option>
	<option value='C' <%=patientcoverage%>><fmt:message key="eBL.PATIENT_COVERAGE.label" bundle="${common_labels}"/></option>
	<option value='P' <%=payercoverage%>><fmt:message key="eBL.PAYER_COVERAGE.label" bundle="${common_labels}"/></option>
	</select>
	</td>
<%
	}%>
	<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends -->
		<td align="left" nowrap>		
		<a name='select_0' href='#' onClick='showBlngGrpBasePrice(this,"0")'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
		<input type='hidden' name='flag_0' id='flag_0' value="<%=mode%>" >
		<input type='hidden' name='flagVal0' id='flagVal0' value="<%=flagval%>" ></td>
		</tr>
		<%}%>
			</tbody>
		</table>		
	</div>	
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='totalRecords' id='totalRecords' value="<%=totRec%>" >		
		<input type='hidden' name='blng_grp_code' id='blng_grp_code' value="<%=blng_grp_code%>" />
		<input type='hidden' name='blng_grp_desc' id='blng_grp_desc' value="<%=blng_grp_desc%>" />
		<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
		<input type='hidden' name='mode' id='mode' value="<%=mode%>" />
		<input type='hidden' name='parent_index' id='parent_index' value="<%=parent_index%>" />
		<input type='hidden' name='glSmryYN' id='glSmryYN' value="<%=glSmryYN%>" />
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" />
		<input type='hidden' name='VATapplicable' id='VATapplicable' value="<%=VATapplicable%>" />
		<input type='hidden' name='isMasterPackYN' id='isMasterPackYN' value="<%=isMasterPackYN%>" />
		<input type='hidden' name='allow_masterChild_package' id='allow_masterChild_package' value="<%=allow_masterChild_package%>" />		
		<!-- //sarath added MMS-QF-SCF-0545 below filed added -->
		<input type='hidden' name='BLNG_GRP_NEW_DATE_CHK' id='BLNG_GRP_NEW_DATE_CHK' id='BLNG_GRP_NEW_DATE_CHK' value="N" />
		<input type='hidden' name='SiteSpecific' id='SiteSpecific' id='SiteSpecific' value="<%=SiteSpecific%>" /> <!-- //sarath jan/10/2017 added hidden field to make as siteSpecific MMS-QF-SCF-0545 -->

		<!-- Added by muthu against 31860 on 5/3/2012  --sarath disabled below script to avoid script error  MMS-QF-SCF-0545 -->
		<!-- Added by muthu against 31860 on 5/3/2012 -->
</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>
	<%
	}
	catch(Exception e)
	{
		System.out.println("Exception from Billing Group Base Date :"+e);
		e.printStackTrace();
	}
	%>


