<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eBL.BLReportIdMapper"%> 



<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String siteSpecf=session.getAttribute("siteSpecf").toString();
	Boolean ss=Boolean.parseBoolean(siteSpecf); 
	System.out.println("siteSpecf" + ss);	
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
<script language="javascript" src='../js/PkgDef.js'></script> 
<script language="javascript" src='../js/PkgDefBlngGrp.js'></script> 
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
	function alignHeading()
	{	
			if(parent.blng_grp_charge_based_dtl_hdr.document.getElementById("tableheader")!=null)
			{		
					parent.blng_grp_charge_based_dtl_hdr.document.getElementById("tableheader").width =	eval(parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").offsetWidth);
						for (j=0; j < parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells.length; j++) 
						{			
							var  wid=eval(parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells(j).offsetWidth);						
							if(parent.blng_grp_charge_based_dtl_hdr.document.getElementById("tableheader").rows(1).cells(j) != null)
							{
						
								parent.blng_grp_charge_based_dtl_hdr.document.getElementById("tableheader").rows(1).cells(j).width=wid;
								parent.blng_grp_charge_based_dtl_hdr.document.getElementById("tableheader").rows(1).cells(0).width='300';							
								parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells(0).width='300';
								parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells(3).width='75';
								parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells(5).width='75';
								parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells(6).width='66';
								parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells(7).width='66';
								parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells(8).width='66';
								parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells(9).width='66';
								parent.frames[1].document.getElementById("blng_grp_charge_based_tbl").rows(2).cells(10).width='66';
								
								
						
							}
						}
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

		String locale			= (String)session.getAttribute("LOCALE");
		String params = request.getQueryString();
		System.out.println("params ===> "+params);

		String packageCode		=	"" ;
		String mode				= "";
		//Newly Added by Muthu against 28192 on 8/24/2012
		String srvLmt			= "N";
		String srvLmtChk        = "";
		String dtlsDisp	        = "NONE";
		//Newly Added by Muthu against 28192 on 8/24/2012
		String factorAppl		="N";
		String roundTo	  = "";
		String roundInd  = "";
	//	String uSelect = "";
	//	String dSelect = "";
		String 		refund			="N";
		String		autoRefund		= "N";
		String 		refundAmt			="";
		String cbService = "";
		String cbServiceDesc = "";;
		String amountLimitInd = "";
		String amountLimit = "";
		String cbType ="";//MuthuN against 28192 
		String charge_type ="";//MuthuN against 28192
		String		splitReqd = "Y";	//Split reqd
		String		includeHomeMedication = "N";	
		String enableDisParam="N";
		String SiteID="";
		ArrayList fromDateList = new ArrayList();
		ArrayList fromDateFoundList = new ArrayList();
	
		int totalRecords=1;
		String copyFrm_pkgCode		=	"" ;
		packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
		copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
		String blng_grp_code		=	request.getParameter("blng_grp_code") == null ? "" :request.getParameter("blng_grp_code") ;
		String blng_grp_desc		=	request.getParameter("blng_grp_desc") == null ? "" :request.getParameter("blng_grp_desc") ;
		mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;	
		String fromDateVals			 = request.getParameter("fromDateVals")==null ? "" :request.getParameter("fromDateVals") ;
		String fromDateTemp = "";
		String parent_index			 = request.getParameter("parent_index")==null ? "" :request.getParameter("parent_index") ;	

		String bean_id		= "bl_PkgDefBlngGrpBean" ;
		String bean_name	= "eBL.PkgDefBlngGrpBean";
		PkgDefBlngGrpBean bean			= (PkgDefBlngGrpBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setModifyBlngGrpChargeSrv("Y");	
		String noofdecimal=bean.getNoOfDecimal();
		HashMap blng_grp_charge_srv		= new HashMap();		
		//System.out.println("cust_charge_srv 123 "+cust_charge_srv);
		ArrayList blng_grp_charge_srv_list	     =	new ArrayList();
		//System.out.println("cust_charge_srv_list 123 "+cust_charge_srv_list);
		blng_grp_charge_srv	=  (HashMap)bean.getBlngGrpChargeSrv();
		fromDateTemp = fromDate;
		String blngGrpRateBasedRcdSize=""; //Added By Vijay For MMS-SCF-0357
		blngGrpRateBasedRcdSize=Integer.toString(bean.getBlngGrpRateSrv().size()); //Added By Vijay For MMS-SCF-0357
		if(blng_grp_charge_srv!=null && blng_grp_charge_srv.size()>0)
		{
			int i = 0;
			int j = 0;
			if(blng_grp_charge_srv.containsKey(blng_grp_code.trim()+"~~"+fromDateTemp.trim()))
			{
				blng_grp_charge_srv_list=(ArrayList)blng_grp_charge_srv.get(blng_grp_code.trim()+"~~"+fromDateTemp.trim());
				//System.out.println("cust_charge_srv_list 133 "+cust_charge_srv_list);
			}
			else
			{
				StringTokenizer st = new StringTokenizer(fromDateVals,"|");
				while(st.hasMoreElements())
				{	
					String strTempDate = st.nextToken();

					if(blng_grp_charge_srv.containsKey(blng_grp_code.trim()+"~~"+strTempDate.trim()))
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
				blng_grp_charge_srv_list=(ArrayList)blng_grp_charge_srv.get(blng_grp_code.trim()+"~~"+fromDateTemp.trim());
			}
		}
		
		if(blng_grp_charge_srv_list!=null &&  blng_grp_charge_srv_list.size()>0){
			totalRecords=blng_grp_charge_srv_list.size();	
		
		}
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
%>	

	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" onLoad='includeHomeMedicationEnableBlngGrp();'>
	<form name='blng_grp_charge_based_dtl' id='blng_grp_charge_based_dtl'>	
	<table class='grid' width='100%' id="blng_grp_charge_based_tbl">
<tr></tr><tr></tr>
	<%

String[] 	record;
	if(blng_grp_charge_srv_list!=null && blng_grp_charge_srv_list.size()>0){
		for(int i=0;i<totalRecords;i++){
			record=new String[15];//Split Reqd									
			record=(String[])(blng_grp_charge_srv_list.get(i));
			cbType = record[0];//MuthuN against 28192 
			//System.out.println("cbType in CustChargeBased.jsp "+cbType);
			cbService		= record[1];
			cbServiceDesc		= record[2];
		    amountLimitInd	=record[3];
			amountLimit		=record[4];			
			roundTo		= record[5];
			roundInd		= record[6];
			refund		=record[7];
			if(refund==null || refund.equals("") || refund.equals("null"))
				refund="N";
			refundAmt	=record[8];
			autoRefund		= record[9];		
			factorAppl			= record[10];
			srvLmt          = record[11];
			splitReqd = record[12];
			includeHomeMedication = record[13];
			enableDisParam		= record[14];
//Newly Added by Muthu against 28192 on 8/24/2012
System.out.println("srvLmt in jsp ==> "+srvLmt);
		if(srvLmt.equals("Y"))
		{
			srvLmtChk = " checked ";
			dtlsDisp = "inline ";
		}
		else
		{
			srvLmtChk = " ";
			dtlsDisp = "none ";
		}
//Newly Added by Muthu against 28192 on 8/24/2012
			//System.out.println("cbType in CustChargeBased.jsp 2 "+cbType);
%>
<tr>
<!-- Added by MuthuN against 28192 on 1-8-12 Starts Here -->
<td class='fields' nowrap WIDTH='4%'> 
<select name='charge_type<%=i%>' id='charge_type<%=i%>'  id='charge_type<%=i%>'onChange='onSrvLimitServiceTypeChange_blngGrpcharge(this,"<%=i%>")' <%=modifyStatus%>>
	<option value='S' <%=cbType.equals("S")?"selected":""%> ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>	
	<option value='M' <%=cbType.equals("M")?"selected":""%>><fmt:message key="Common.item.label" bundle="${common_labels}"/></option>
</select>
</td>

<td  class='fields' ><input type='text' name='cbCode_<%=i%>' id='cbCode_<%=i%>'  <%=modifyStatus%>  id='cbCode_<%=i%>'size='10' maxlength="10"  value="<%=cbService%>"   onBlur='blngGrpCallLookup(this,this,document.forms[0].cbDesc_<%=i%>,"BLNG_GRP_CHARGE_BASED","<%=i%>");'><input type='hidden' name='cbCodePrev_<%=i%>' id='cbCodePrev_<%=i%>' value="<%=cbService%>"/><input type='text' name='cbDesc_<%=i%>' id='cbDesc_<%=i%>' id='cbDesc_<%=i%>'size='10' maxlength="100"  <%=modifyStatus%>  value="<%=cbServiceDesc%>"   onBlur='blngGrpCallLookup(this,document.forms[0].cbCode_<%=i%>,this,"BLNG_GRP_CHARGE_BASED","<%=i%>");'><input type='hidden' name='cbDescPrev_<%=i%>' id='cbDescPrev_<%=i%>' value="<%=cbServiceDesc%>"/><input type='button' class='button' name='serviceLookUp_<%=i%>' id='serviceLookUp_<%=i%>' value='?'	<%=modifyStatus%>  onClick="blngGrpCallServices(document.forms[0].cbCode_<%=i%>,document.forms[0].cbDesc_<%=i%>,'BLNG_GRP_CHARGE_BASED','<%=i%>') ; " tabindex='0'><input type='hidden' name='oldSrvKey<%=i%>' id='oldSrvKey<%=i%>' value='<%=(blng_grp_code+"~~"+fromDate+"~~"+cbService)%>'></td>

<td  align="left" nowrap>
<select name='amt_limit_ind<%=i%>' id='amt_limit_ind<%=i%>' <%=modifyStatus%>  onChange='validateBlngGrpInd(this,"<%=i%>");changeSplitReqd(this,"amt_limit","<%=i%>")'>
<option value='A' <%=(amountLimitInd.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
<option value='P'  <%=(amountLimitInd.equals("P")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
<option value='U'  <%=(amountLimitInd.equals("U")?"selected":"") %> ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>
</select>
</td>

<td><input type='text' name='perAmt_limit<%=i%>' id='perAmt_limit<%=i%>' <%=modifyStatus%>  <%=(amountLimitInd.equals("U")?"disabled":"")%> size='5' maxlength='13'  onBlur='blngGrpValidForAmtPerUnltd(amt_limit_ind<%=i%>,this,"<%=i%>","BLNG_GRP_CHARGE_BASED","<%=noofdecimal%>")' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")'; value="<%=amountLimit%>"/></td>		
<td  class='fields' ><input type='text' name='roundTo_<%=i%>' id='roundTo_<%=i%>' size='3'	<%=modifyStatus%>  maxlength="3"  value="<%=roundTo%>"  onkeypress=" return (allowValidNumber(this,event));"  /></td>

<td  class='fields' >
<select name='roundInd_<%=i%>' id='roundInd_<%=i%>'    onChange="" <%=modifyStatus%>  >
<option value='U' <%=roundInd.equals("U")?"selected":""%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
<option value='D' <%=roundInd.equals("D")?"selected":""%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
</select>
</td>
<%if( ss){%>
<td class='fields' nowrap WIDTH=''><input type='checkbox'   <%=modifyStatus%>	name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%> <%="Y".equals(enableDisParam)?"":"disabled" %> onclick="checkInclHomeMedi(this);">
<input type='hidden' name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value="<%=enableDisParam%>"></td>
<%}else{%>
<td class='fields' nowrap WIDTH='' >
<input type='hidden' 	name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='Y' >
<input type='hidden' name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value="Y"> </td>
<%} %>

<td align="left" nowrap><input type='checkbox'    name='refund_<%=i%>' id='refund_<%=i%>'	<%=modifyStatus%>  <%=refund.equals("Y")?"checked":""%> onClick='chkBlngGrpRefundCB(this,"<%=i%>")' value="<%=refund%>"/>
<%if(refund.equals("Y")){%><input type='text' name='refundAmt_<%=i%>' id='refundAmt_<%=i%>' <%=modifyStatus%>  id='refundAmt_<%=i%>' value='<%=refundAmt%>' onBlur='validPercentageForRefundBlngGrp(this,"autoRefund_<%=i%>");' onkeypress='return allowValidNumber(this,event,"<%=noofdecimal%>")' size='2' maxlength='4'  ><%}%></td>

<td align="left" nowrap><input type='checkbox'    name='autoRefund_<%=i%>' id='autoRefund_<%=i%>'	<%=modifyStatus%>  <%=autoRefund.equals("Y")?"checked":""%>	<%=refundAmt.equals("")?" disabled" : ""%> onClick='chkBlngGrpAutoRefund(this,"refundAmt_<%=i%>")' value="<%=autoRefund%>"/></td>

<td align="left" nowrap><input type='checkbox'  name='factor_appl<%=i%>' id='factor_appl<%=i%>'  <%=modifyStatus%>  DISABLED  <%=factorAppl.equals("Y")?"checked":""%> onClick='blngGrpFactorAppl(this,"<%=i%>")' value="<%=factorAppl%>"/></td>

<%if(cbType.equalsIgnoreCase("S")){%>
<!--Newly Added by Muthu against 28192 on 8/24/2012-->
<td  class='fields'>
<input type='checkbox' name='srvLmt_<%=i%>' id='srvLmt_<%=i%>' value="<%=srvLmt%>"  <%=srvLmtChk%>  <%=modifyStatus%> onclick="showLmtDetails(this,'<%=i%>')"/>
<!--Newly Added by Muthu against 28192 on 8/24/2012-->
<a style ="display:<%=dtlsDisp%>" id='srvLmtDtls_<%=i%>'  href='javascript:loadBlngGrpChargeBasedServiceLimit(document.forms[0].cbCode_<%=i%>.value,"<%=i%>")'><fmt:message key='eBL.Dtls.label' bundle='${bl_labels}'/></a>			
</td>
<%
} else{
%>
<td  class='fields'>
<input type='checkbox' name='srvLmt_<%=i%>' id='srvLmt_<%=i%>' value="<%=srvLmt%>" <%=srvLmtChk%> <%=modifyStatus%> onclick="showLmtDetails(this,'<%=i%>')" disabled />
</td>
<%
}
%>
<td class='fields' nowrap ><input type='checkbox'   <%=modifyStatus%>	name='split_reqd<%=i%>' id='split_reqd<%=i%>' <%="U".equals(amountLimitInd)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);"></td>
<td  class='fields'  ><input type='checkbox' name='delCode_<%=i%>' id='delCode_<%=i%>'	<%=modifyStatus%>  value=''   onclick="chkBlngGrpDeleteService(this,'<%=i%>')"/></td>
</tr>
<%}
		}else{
			System.out.println("305 *** ");
			//System.out.println("cbType in CustChargeBased.jsp 2 "+cbType);
		%>
		<tr >
<!-- Added by MuthuN against 28192 on 1-8-12 Starts Here -->

<td class='fields' nowrap WIDTH='4%'> 
<select name='charge_type0' id='charge_type0' onChange='onSrvLimitServiceTypeChange_blngGrpcharge(this,"0")' <%=modifyStatus%>>
	<option value='S' <%=cbType.equals("S")?"selected":""%> ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></option>	
	<option value='M' <%=cbType.equals("M")?"selected":""%>><fmt:message key="Common.item.label" bundle="${common_labels}"/></option>
</select>
</td>
<!-- Added by MuthuN against 28192 on 1-8-12 Starts Here -->
<td  class='fields' ><input type='text' name='cbCode_0' id='cbCode_0' id='cbCode_0'size='10' maxlength="10"  value=""  	 <%=modifyStatus%>  onBlur='blngGrpCallLookup(this,this,document.forms[0].cbDesc_0,"BLNG_GRP_CHARGE_BASED","0");'><input type='hidden' name='cbCodePrev_0' id='cbCodePrev_0' value=""/><input type='text' name='cbDesc_0' id='cbDesc_0' id='cbDesc_0'size='10' maxlength="100"  value="" <%=modifyStatus%>   onBlur='blngGrpCallLookup(this,document.forms[0].cbCode_0,this,"BLNG_GRP_CHARGE_BASED","0");'><input type='hidden' name='cbDescPrev_0' id='cbDescPrev_0' value=""/><input type='button' class='button' name='serviceLookUp_0' id='serviceLookUp_0' value='?' onClick="blngGrpCallServices(document.forms[0].cbCode_0,document.forms[0].cbDesc_0,'BLNG_GRP_CHARGE_BASED',charge_type0,'0'); "  tabindex='0'><input type='hidden' name='oldSrvKey0' id='oldSrvKey0' value=''></td>

<td  align="left" nowrap>
<select name='amt_limit_ind0' id='amt_limit_ind0' onChange='validateBlngGrpInd(this,"0");changeSplitReqd(this,"amt_limit","0")' <%=modifyStatus%> >
<option value='A' ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
<option value='P'   ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
<option value='U'   ><fmt:message key="eBL.UNLIMITED.label" bundle="${bl_labels}"/></option>
</select>
</td>

<td><input type='text' name='perAmt_limit0' id='perAmt_limit0'  size='5' maxlength='13'  <%=modifyStatus%>  onBlur='blngGrpValidForAmtPerUnltd(amt_limit_ind0,this,"0","BLNG_GRP_CHARGE_BASED","<%=noofdecimal%>")' onkeypress='return allowValidNumber(this,event,"10","<%=noofdecimal%>")'; value=""/></td>		
<td  class='fields' ><input type='text' name='roundTo_0' id='roundTo_0' size='3' maxlength="3"  value=""  onkeypress=" return (allowValidNumber(this,event));" <%=modifyStatus%>  /></td>

<td  class='fields' >
<select name='roundInd_0' id='roundInd_0'    onChange=""  <%=modifyStatus%> >
<option value='U' ><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
<option value='D' ><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
</select>
</td>
<%if( ss){%>
	<td class='fields' nowrap WIDTH=''><input type='checkbox'   <%=modifyStatus%>	name='includeHomeMedication0' id='includeHomeMedication0' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%> <%="Y".equals(enableDisParam)?"":"disabled" %>  onclick="checkInclHomeMedi(this);">
	<input type='hidden' name='enableDisParam0' id='enableDisParam0' id='enableDisParam0' value="<%=enableDisParam%>">
	</td>
<% } else{%>
<td class='fields' nowrap WIDTH='' >	<input type='hidden' 	<%=modifyStatus%> name='includeHomeMedication0' id='includeHomeMedication0' value='Y' > 
<input type='hidden' name='enableDisParam0' id='enableDisParam0' id='enableDisParam0' value="Y"></td>
<%} %>
<td align="left" nowrap><input type='checkbox'    name='refund_0' id='refund_0' <%=modifyStatus%>  onClick='chkBlngGrpRefundCB(this,"0")' value=""/></td>

<td align="left" nowrap><input type='checkbox'    name='autoRefund_0' id='autoRefund_0'  onClick='chkBlngGrpAutoRefund(this,"refundAmt_0")' value=""/></td>

<td align="left" nowrap><input type='checkbox'  name='factor_appl0' id='factor_appl0'  DISABLED  onClick='blngGrpFactorAppl(this,"0")' value=""/></td>

<!--Newly Added by Muthu against 28192 on 8/24/2012-->
<td  class='fields'>
<input type='checkbox' name='srvLmt_0' id='srvLmt_0' value="" <%=srvLmtChk%> <%=modifyStatus%> onclick="showLmtDetails(this,'0')"/>
<!--Newly Added by Muthu against 28192 on 8/24/2012-->
<a style ="display:<%=dtlsDisp%>" id='srvLmtDtls_0' href='javascript:loadBlngGrpChargeBasedServiceLimit(document.forms[0].cbCode_0.value,"0")'><fmt:message key='eBL.Dtls.label' bundle='${bl_labels}'/></a>			
</td>
<td class='fields' nowrap ><input type='checkbox'   <%=modifyStatus%>	name='split_reqd0' id='split_reqd0' <%="U".equals(amountLimitInd)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);"></td>
<td  class='fields' ><input type='checkbox' name='delCode_0' id='delCode_0' value=''   onclick="chkBlngGrpDeleteService(this,'0')" <%=modifyStatus%> /></td>
				</tr>
		<%}%>
		</table>		
	
		<INPUT TYPE="hidden" name='packageCode' id='packageCode' value="<%=packageCode%>">
		<INPUT TYPE="hidden" name='copyFrm_pkgCode' id='copyFrm_pkgCode' value="<%=copyFrm_pkgCode%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='mode' id='mode' value="<%=mode%>" >
		<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
		<input type='hidden' name='fromDateTemp' id='fromDateTemp' value="<%=fromDateTemp%>" />
		<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
		<input type='hidden' name='totalRecords' id='totalRecords' value="<%=totalRecords%>" >
		<input type='hidden' name='blng_grp_code' id='blng_grp_code' value="<%=blng_grp_code%>" >
		<input type='hidden' name='blng_grp_desc' id='blng_grp_desc' value="<%=blng_grp_desc%>" >
		<input type='hidden' name='parent_index' id='parent_index' value="<%=parent_index%>" >
		<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
		<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
		<input type='hidden' name='params' id='params' value="<%=params%>" />
		<input type='hidden' name='blngGrpRateBasedRcdSize' id='blngGrpRateBasedRcdSize' value='<%=blngGrpRateBasedRcdSize %>'> <!-- Added By Vijay For MMS-SCF-DM-0357 -->

<input type='hidden' name='siteId' id='siteId' id ='siteId' value='<%=ss %>' />
<script>parent.updateCurrentForm("BLNG_GRP_CHARGE_BASED","parent.frames[4].frames[0].document.blng_grp_charge_based_dtl","parent.frames[4].frames[2].document.blng_grp_charge_based_excl","parent.PkgDefBlngGrpHeader.document.frmPkgDefBlngGrpHeader",<%=totalRecords%>);</script>
<script>alignHeading();</script>
</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from PkgDefBlngGrpChargeBased :"+e);
	e.printStackTrace();
}
%>
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

