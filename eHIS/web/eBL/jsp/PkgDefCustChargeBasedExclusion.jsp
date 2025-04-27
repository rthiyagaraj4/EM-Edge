<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String siteSpecf=session.getAttribute("siteSpecf").toString();
	Boolean ss=Boolean.parseBoolean(siteSpecf);	
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script> 
<script language="javascript" src='../js/PkgDef.js'></script> 
<script language="javascript" src='../js/PkgDefCust.js'></script> 
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
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
		<script>
		</script>
<% 
	try
	{
		String locale			= (String)session.getAttribute("LOCALE");
		String fromDate			= request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		String fromDateTemp		= request.getParameter("fromDateTemp")==null ? "" :request.getParameter("fromDateTemp") ;
		String parent_indx		=	request.getParameter("parent_indx") == null ? "" :request.getParameter("parent_indx") ;
		String cust_grp_code	=	request.getParameter("cust_grp_code") == null ? "" :request.getParameter("cust_grp_code") ;
		String cust_grp_desc	=	request.getParameter("cust_grp_desc") == null ? "" :request.getParameter("cust_grp_desc") ;
		String cust_code		=	request.getParameter("cust_code") == null ? "" :request.getParameter("cust_code") ;
		String cust_desc		=	request.getParameter("cust_desc") == null ? "" :request.getParameter("cust_desc") ;
		String service_code		=	request.getParameter("service_code") == null ? "" :request.getParameter("service_code") ;
		String service_desc		=	request.getParameter("service_desc") == null ? "" :request.getParameter("service_desc") ;
        	cust_grp_desc= java.net.URLDecoder.decode(cust_grp_desc,"UTF-8");
        	cust_desc= java.net.URLDecoder.decode(cust_desc,"UTF-8");
		String packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
		String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String		includeHomeMedication = "N";	
		String enableDisParam="N";
		String SiteID="";
		String itemCode = "";
		String itemDesc = "";
		String qtyLimit = "";
		String amountLimit = "";
		String inExcl = "N";
		String inDisabled = " ";
		String inSel = "";
		String		splitReqd = "Y";	//Split reqd
		String bean_id		= "bl_PkgDefCustBean" ;
		String bean_name	= "eBL.PkgDefCustBean";
		PkgDefCustBean bean		= (PkgDefCustBean)getBeanObject( bean_id, bean_name, request ) ;	
		bean.setModifyCustChargeSrvExcl("Y");		

		int totalRecords=1;
		HashMap cust_charge_srv_excl		= new HashMap();		
		ArrayList cust_charge_srv_excl_list	     =	new ArrayList();
		String noofdecimal	= bean.getNoOfDecimal();
		cust_charge_srv_excl	=  (HashMap)bean.getCustChargeSrvExcl();
		if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0 && cust_charge_srv_excl.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim())){
			cust_charge_srv_excl_list=(ArrayList)cust_charge_srv_excl.get(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
		}
		
		if(cust_charge_srv_excl_list!=null &&  cust_charge_srv_excl_list.size()>0){
			totalRecords=cust_charge_srv_excl_list.size();	
		}

		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
%>	
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" onLoad="chkCustChargeExludeServiceonload();includeHomeMedicationEnableCust();">
	<form name='cust_charge_based_excl_dtl' id='cust_charge_based_excl_dtl'>	
<!--	<div id="divHeadSep" style="position: absolute;">-->
<div id="tbl-container" STYLE="overflow: auto; width: 100%; height: 85px;   padding:3px; margin: 0px">
	<table class='grid' width='100%' id="cust_charge_based_excl_tbl">
	<thead>
	<%if( ss){%>
	<tr><td class='COLUMNHEADER'  colspan='7' align='left'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>&nbsp;: &nbsp;<%=cust_grp_desc%>&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=cust_desc%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=fromDate%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=service_desc%>&nbsp;&nbsp;&nbsp;</td></tr>
	<%}else{%>
		<tr><td class='COLUMNHEADER'  colspan='6' align='left'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>&nbsp;: &nbsp;<%=cust_grp_desc%>&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<%=cust_desc%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=fromDate%>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;: &nbsp;<%=service_desc%>&nbsp;&nbsp;&nbsp;</td></tr>
	<%}%>
	<tr >
		<td  class='COLUMNHEADER' width="20%" align='left'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' align='left'><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' align='left'><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' align='left'><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></td>	
		<td class='columnheader' width=''  nowrap><fmt:message bundle="${bl_labels }" key="eBL.SplitReqd.label"></fmt:message></td>
			<%if( ss){%>
	<td class='columnheader'width=''  nowrap><fmt:message bundle="${bl_labels }" key="eBL.IncludeHomeMedication.label"></fmt:message></td> 
	<!-- Added By suganya  -->
<%} else{%>
	<td class='columnheader'width=''  nowrap >
<%} %>
		<td class='COLUMNHEADER' align='left'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td> 
	</tr>
	</thead>
	<tbody>
	<%
	String[] 	record;
	if(cust_charge_srv_excl_list!=null && cust_charge_srv_excl_list.size()>0){
		for(int i=0;i<totalRecords;i++){
			record=new String[8];//Split Reqd				
			record=(String[])(cust_charge_srv_excl_list.get(i));			
			itemCode		= record[0];
			itemDesc		= record[1];
		    inExcl	=record[2];
			if(inExcl==null || inExcl.equals("") || inExcl.equals("null"))
				inExcl="N";
			qtyLimit		=record[3];	
			amountLimit			= record[4];	
			splitReqd	=	record[5];
				includeHomeMedication		= record[6];
				enableDisParam		= record[7];
			if(inExcl.equals("Y"))
			{
				inSel = " checked ";
				inDisabled = " disabled ";
			}
			else 
			{
				inSel = "  ";
				inDisabled = " ";
			}
%>
			<tr ><input type='hidden'   name='charge_type<%=i%>' id='charge_type<%=i%>' id='charge_type<%=i%>' value='M' />
			<td  class='fields'><input type='text' name='cbCode_<%=i%>' id='cbCode_<%=i%>' <%=modifyStatus%>  id='cbCode_<%=i%>'size='10' maxlength="10"  value="<%=itemCode%>"   onBlur='custCallServices(document.forms[0].cbCode_<%=i%>,document.forms[0].cbDesc_<%=i%>,"CUST_CHARGE_BASED_ITEM",charge_type<%=i%>,"<%=i%>");'><input type='hidden' name='cbCodePrev_<%=i%>' id='cbCodePrev_<%=i%>' value="<%=itemCode%>"/><input type='text' name='cbDesc_<%=i%>' id='cbDesc_<%=i%>' id='cbDesc_<%=i%>'size='30'  <%=modifyStatus%>  maxlength="100"  value="<%=itemDesc%>"   onBlur='custCallServices(document.forms[0].cbCode_<%=i%>,document.forms[0].cbDesc_<%=i%>,"CUST_CHARGE_BASED_ITEM",charge_type<%=i%>,"<%=i%>");'><input type='hidden' name='cbDescPrev_<%=i%>' id='cbDescPrev_<%=i%>' value="<%=itemDesc%>"/><input type='button' class='button'	<%=modifyStatus%>  name='serviceLookUp_<%=i%>' value='?' onClick="custCallServices(document.forms[0].cbCode_<%=i%>,document.forms[0].cbDesc_<%=i%>,'CUST_CHARGE_BASED_ITEM',charge_type<%=i%>,'<%=i%>');" tabindex='0'></td>

			<td  class='fields' >
			<input type='checkbox' name='inEx_<%=i%>' id='inEx_<%=i%>' id='inEx_<%=i%>'  value="<%=inExcl%>" <%=modifyStatus%>  <%=inSel%>   onclick="custExcludeItem(this,'<%=i%>');changeSplitReqd(this,'exclude','<%=i%>');IncludeHomeMedicationcustExclude(this,cbCode_<%=i%>,charge_type<%=i%>,'<%=i%>');"/>
		   	</td>
			<td  class='fields' >
			 <input type='text' name='quantityLimit_<%=i%>' id='quantityLimit_<%=i%>'  <%=inDisabled%>  <%=modifyStatus%>  size='15' maxlength="15"  value="<%=qtyLimit%>" onkeypress=" return (allowValidNumber(this,event,'<%=noofdecimal%>'));"/></td>
			<td  class='fields' >
			<input type='text' name='amountLimit_<%=i%>' id='amountLimit_<%=i%>' <%=inDisabled%>  <%=modifyStatus%>  size='13' maxlength="13"  value="<%=amountLimit%>" onkeypress=" return (allowValidNumber(this,event,'10','<%=noofdecimal%>'));" onBlur='checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8540")'></td>
			<td class='fields' nowrap ><input type='checkbox'   <%=modifyStatus%>	name='split_reqd<%=i%>' id='split_reqd<%=i%>' <%="checked".equals(inSel)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);"></td>
		
		<%if(ss){%>	
			<td class='fields' nowrap WIDTH=''>
			<input type='checkbox'   <%=modifyStatus%> name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%> <%="Y".equals(enableDisParam)?"":"disabled" %>  onclick="checkInclHomeMedi(this); IncludeHomeMedicationUnchkExclude(this,'custchargeexclude','<%=i%>');">
			<input type='hidden' name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value="<%=enableDisParam%>"> </td>
			</td>
		<%}else{%>
			<td class='fields' nowrap WIDTH=''>
			<input type='hidden'	name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='Y' >
			<input type='hidden' name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value="Y"> </td>
			</td>
			<%} %>
			
			<td  class='fields'>
			<input type='checkbox' name='delCode_<%=i%>' id='delCode_<%=i%>' value='N'  <%=modifyStatus%>  onclick="chkCustDeleteService(this,'<%=i%>')"/>
		   	</td>

			</tr>
		<%}
}else{		%>
			<tr ><input type='hidden'   name='charge_type0' id='charge_type0' id='charge_type0' value='M' />
			<td  class='fields'><input type='text' name='cbCode_0' id='cbCode_0'	<%=modifyStatus%>  id='cbCode_0'size='10' maxlength="10"  value=""   onBlur="custCallServices(document.forms[0].cbCode_0,document.forms[0].cbDesc_0,'CUST_CHARGE_BASED_ITEM','M','0');"><input type='hidden' name='cbCodePrev_0' id='cbCodePrev_0' value=""/><input type='text' name='cbDesc_0' id='cbDesc_0' id='cbDesc_0'size='30' maxlength="100" <%=modifyStatus%>  value=""   onBlur="custCallServices(document.forms[0].cbCode_0,document.forms[0].cbDesc_0,'CUST_CHARGE_BASED_ITEM','M','0');"><input type='hidden' name='cbDescPrev_0' id='cbDescPrev_0' value=""/><input type='button'  <%=modifyStatus%>  class='button' name='serviceLookUp_0' value='?' onClick="custCallServices(document.forms[0].cbCode_0,document.forms[0].cbDesc_0,'CUST_CHARGE_BASED_ITEM','M','0')" tabindex='0'></td>

			<td  class='fields' >
			<input type='checkbox' name='inEx_0' id='inEx_0' value="N"  <%=modifyStatus%>   onclick="custExcludeItem(this,'0');changeSplitReqd(this,'exclude','0');IncludeHomeMedicationcustExclude(this,cbCode_0,charge_type0,'0');"/>
		   	</td>
			<td  class='fields' >
			 <input type='text' name='quantityLimit_0' id='quantityLimit_0'    size='15'  <%=modifyStatus%>  maxlength="15"  value="" onkeypress=" return (allowValidNumber(this,event,'<%=noofdecimal%>'));"/></td>
			<td  class='fields' >
			<input type='text' name='amountLimit_0' id='amountLimit_0'   size='13' maxlength="13"  value="" onkeypress=" return (allowValidNumber(this,event,'10','<%=noofdecimal%>'));"  <%=modifyStatus%>  onBlur='checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8540")'></td>
			<td class='fields' nowrap ><input type='checkbox'   <%=modifyStatus%>	name='split_reqd0' id='split_reqd0' <%="checked".equals(inSel)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);"></td>
		
		<%if(ss){%>	
			<td class='fields' nowrap WIDTH=''>
			<input type='checkbox'   <%=modifyStatus%> name='includeHomeMedication0' id='includeHomeMedication0' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%> <%="Y".equals(enableDisParam)?"":"disabled" %>  onclick="checkInclHomeMedi(this); IncludeHomeMedicationUnchkExclude(this,'custchargeexclude','0');">
			<input type='hidden' name='enableDisParam0' id='enableDisParam0' id='enableDisParam0' value="<%=enableDisParam%>"> </td>
			</td>
		<%}else{%>
			<td class='fields' nowrap WIDTH=''><input type='hidden'	name='includeHomeMedication0' id='includeHomeMedication0' id='includeHomeMedication0' value='Y' >
			<input type='hidden' name='enableDisParam0' id='enableDisParam0' id='enableDisParam0' value="Y"> </td></td>
		<%} %>
		
			<td  class='fields'>
			<input type='checkbox' name='delCode_0' id='delCode_0' value='N'   <%=modifyStatus%>  onclick="chkCustDeleteService(this,'0')"/>
		   	</td>

			</tr>
<%}%>
		</tbody>
		</table>		
		</DIV>

		<INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
		<input type='hidden' name='packageCode' id='packageCode' value="<%=packageCode%>" >
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" />
		<INPUT TYPE="hidden" name="parent_service_code" id="parent_service_code" value="<%=service_code%>">
		<INPUT TYPE="hidden" name="service_desc" id="service_desc" value="<%=service_desc%>">		
		<input type="hidden" name='totalRecords' id='totalRecords' value="<%=totalRecords%>">
		<input type='hidden' name='parent_indx' id='parent_indx' value="<%=parent_indx%>">
		<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
		<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
		<input type='hidden' name='cust_grp_code' id='cust_grp_code' value="<%=cust_grp_code%>" />
		<input type='hidden' name='cust_grp_desc' id='cust_grp_desc' value="<%=cust_grp_desc%>" />
		<input type='hidden' name='cust_code' id='cust_code' value="<%=cust_code%>" />
		<input type='hidden' name='cust_desc' id='cust_desc' value="<%=cust_desc%>" />
		<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
<input type='hidden' name='siteId' id='siteId' id ='siteId' value='<%=ss %>' />
</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from  PkgDefChargeBasedExclusion:"+e);
	e.printStackTrace();
}
%>

