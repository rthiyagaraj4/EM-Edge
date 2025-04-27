<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.PkgDefBean, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//sarathkumar added code to make as siteSpecific 	//sarathkumar InclHmeMedi 
	String siteSpecf=session.getAttribute("siteSpecf").toString();
	Boolean ss=Boolean.parseBoolean(siteSpecf); 
	System.out.println("siteSpecf" + ss);

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
<!--  <script language="javascript" src='../js/PkgDefTemp.js'></script> 
 --><Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
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
		
		String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		String custCode			 = request.getParameter("custCode")==null ? "" :request.getParameter("custCode") ;
	
	//	String copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;
		String packageCode		=	"" ;
		String mode				= "";
		//String modeChk			=request.getParameter("modeChk") == null ? "" :request.getParameter("modeChk") ;

		//String flagVal = ""; 
		//String status = "", toDateStatus = "", fromDateImgStatus = "";
		String itemCode = "";
		String itemDesc = "";
		String qtyLimit = "";
		String amountLimit = "";
		String inExcl = "N";
		String inDisabled = " ";
		//String factorAppl = "N";
		HashMap excludedItems	  = new HashMap();
		HashMap excludedItems_FD  = new HashMap();
		//HashMap excludedItems_SR  = new HashMap();
		ArrayList itemsForService = new ArrayList();
		packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;

		String serviceCode		=	request.getParameter("serviceCode") == null ? "" :request.getParameter("serviceCode") ;
		mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
		ArrayList itemGroup	        =	new ArrayList();
		ArrayList itemDescGroup     =	new ArrayList();
		ArrayList inExcnGroup		=	new ArrayList();
		ArrayList amountLtGroup		=	new ArrayList();
		ArrayList qtyLtGroup		=	new ArrayList();
		//ArrayList factorApplGroup	=	new ArrayList();
		ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
		String		splitReqd = "Y";	//Split reqd
		
		ArrayList 	includeHomeMedication_list = new ArrayList();	//sarathkumar InclHmeMedi
		String		includeHomeMedication = "N"; //sarathkumar InclHmeMedi
		String		enableDisParam = "N"; //sarathkumar InclHmeMedi
		ArrayList 	enableDisParam_list = new ArrayList();	//sarathkumar InclHmeMedi
		//String		callfrom = "pkgchexl"; //sarathkumar InclHmeMedi
		
	
		int  totRec=1;
		String bean_id		= "bl_PkgDefBean" ;
		String bean_name	= "eBL.PkgDefBean";
		PkgDefBean bean			= (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
		int noofdecimal = Integer.parseInt(bean.getNoOfDecimal());
		excludedItems	=  bean.getExcludedItems_CB();
	//	String deletedStatusCBLt = bean.getDeletedStatusCBLt() ;//unused variable
		if(excludedItems.size()>0 && excludedItems.containsKey(fromDate))
		{
			excludedItems_FD = (HashMap) excludedItems.get(fromDate);
			if(excludedItems_FD.size()>0 && excludedItems_FD.containsKey(serviceCode) )
			{
				itemsForService =(ArrayList)excludedItems_FD.get(serviceCode);
				if(itemsForService.size()>0)
				{
					itemGroup		= (ArrayList)itemsForService.get(0);
					itemDescGroup	= (ArrayList)itemsForService.get(1);
					qtyLtGroup		= (ArrayList)itemsForService.get(2);
					amountLtGroup	= (ArrayList)itemsForService.get(3);
					inExcnGroup		= (ArrayList)itemsForService.get(4);
					//factorApplGroup	= (ArrayList)itemsForService.get(5);
					split_reqd_list 	= (ArrayList)itemsForService.get(5);//Split Reqd
					
					includeHomeMedication_list 	= (ArrayList)itemsForService.get(6); //sarathkumar InclHmeMedi
					enableDisParam_list 	= (ArrayList)itemsForService.get(7); //sarathkumar InclHmeMedi
					
					if(itemGroup.size()>0)
						totRec =  itemGroup.size();
				}
			}
			
		}
		
   %>
	<body   onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" onLoad='chkChargeExludeServiceonload();includeHomeMedicationEnable();'>
	<form name='frmPkgDefChargeBasedExcln' id='frmPkgDefChargeBasedExcln'>	
<!--	<div id="tbl-container" STYLE="overflow: auto; width: 1020px; height: 100px;   padding:3px; margin: 0px">-->
<div id="divHeadSep" style="position: absolute;">
	<table class='grid' width='100%' id="pkgCbasedItem">
	<tr id="heading">	
		<td  class='COLUMNHEADER' width="20%"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		<!-- <td  class='COLUMNHEADER' width="30%"><b>
		<fmt:message key='Common.ItemDescription.label' bundle='${common_labels}'/></b></td> -->
		<td  class='COLUMNHEADER' ><b><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></b></td>
		<td  class='COLUMNHEADER' ><b><fmt:message key="eBL.QTY_LMT.label" bundle="${bl_labels}"/></b></td>
		<td  class='COLUMNHEADER' ><b><fmt:message key="eBL.AMT_LMT.label" bundle="${bl_labels}"/></b></td>	
		<!-- <td class='columnheader'  ><fmt:message key="eBL.ApplyFactorForServiceLimit.label" bundle="${bl_labels}"/></td>	 -->
		
		<%if(ss){ %>
 		<!-- saraa -->
		<td  class='COLUMNHEADER' WIDTH='' nowrap><fmt:message key="eBL.IncludeHomeMedication.label" bundle="${bl_labels}"/></td>
		 <% }else{%>
		 <td  class='COLUMNHEADER' WIDTH='' nowrap></td>
		 
		 <%} %>
		
		<td class='columnheader' nowrap><fmt:message bundle="${bl_labels }" key="eBL.SplitReqd.label"></fmt:message></td> <!-- Added By Rajesh V -->
		<td class='COLUMNHEADER' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td> 
	</tr>
	
	<%
	String inSel = "";
	for(int i=0; i<totRec; i++)
	
	{	System.out.println("itemCodebefore");
		if(itemGroup!=null && itemGroup.size()>0)
		{
			itemCode	= (String)itemGroup.get(i);
			System.out.println("itemCode");
			System.out.println("itemCode"+itemCode);
			itemDesc	=	(String)itemDescGroup.get(i);
			qtyLimit	= (String)qtyLtGroup.get(i);
			amountLimit = (String)amountLtGroup.get(i);
			inExcl		=  (String)inExcnGroup.get(i);
			//factorAppl	= (String)factorApplGroup.get(i);
			splitReqd 		=(String) split_reqd_list.get(i);//Split reqd
			
			includeHomeMedication 		=(String) includeHomeMedication_list.get(i); //sarathkumar InclHmeMedi
			 enableDisParam 		=(String) enableDisParam_list.get(i);//sarathkumar InclHmeMedi
			
			
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
		}

			%>
			<tr > <input type='hidden'   name='charge_type<%=i%>' id='charge_type<%=i%>' id='charge_type<%=i%>' value='M' />
			<td  class='fields'><input type='text' name='cbCode_<%=i%>' id='cbCode_<%=i%>' <%=modifyStatus%> id='cbCode_<%=i%>'size='10' maxlength="10"  value="<%=itemCode%>"   onBlur='callServices(document.forms[0].cbCode_<%=i%>,document.forms[0].cbDesc_<%=i%>,"CHARGE_BASED_ITEM",charge_type<%=i%>, "<%=i%>"); IncludeHomeMedicationCheck(this,charge_type<%=i%>,"<%=i%>");'><input type='hidden' name='cbCodePrev_<%=i%>' id='cbCodePrev_<%=i%>' value="<%=itemCode%>"/><!-- </td>
			
			<td  class='fields' width="35%"> --><input type='text'	<%=modifyStatus%> name='cbDesc_<%=i%>' id='cbDesc_<%=i%>'size='30' maxlength="100"  value="<%=itemDesc%>"   onBlur="callServices(document.forms[0].cbCode_<%=i%>,document.forms[0].cbDesc_<%=i%>,'CHARGE_BASED_ITEM',charge_type<%=i%>, '<%=i%>'); IncludeHomeMedicationCheck(cbCode_<%=i%>,charge_type<%=i%>,'<%=i%>'); "><input type='hidden' name='cbDescPrev_<%=i%>' id='cbDescPrev_<%=i%>' value="<%=itemDesc%>"/><input type='button' class='button' name='serviceLookUp_<%=i%>' id='serviceLookUp_<%=i%>' value='?'	<%=modifyStatus%> onClick="callServices(document.forms[0].cbCode_<%=i%>,document.forms[0].cbDesc_<%=i%>,'CHARGE_BASED_ITEM',charge_type<%=i%>, '<%=i%>');IncludeHomeMedicationCheck(cbCode_<%=i%>,charge_type<%=i%>,'<%=i%>');" tabindex='0'></td>
 
			<td  class='fields' >
			<input type='checkbox' name='inEx_<%=i%>' id='inEx_<%=i%>' id='inEx_<%=i%>' value="<%=inExcl%>" <%=modifyStatus%> <%=inSel%>   onclick="excludeItem(this,'<%=i%>');changeSplitReqd(this,'exclude','<%=i%>');IncludeHomeMedicationExclude(this,cbCode_<%=i%>,charge_type<%=i%>,'<%=i%>');"/>
		   	</td>
			<td  class='fields' >
			 <input type='text' name='quantityLimit_<%=i%>' id='quantityLimit_<%=i%>'  <%=inDisabled%>  <%=modifyStatus%> size='15' maxlength="15"  value="<%=qtyLimit%>" onkeypress=" return (allowValidNumber(this,event,'<%=noofdecimal%>'));"/></td>
			<td  class='fields' >
			<input type='text' name='amountLimit_<%=i%>' id='amountLimit_<%=i%>' <%=inDisabled%> <%=modifyStatus%> size='13' maxlength="13"  value="<%=amountLimit%>" onkeypress=" return allowValidNumber(this,event,'10','<%=noofdecimal%>');" onBlur='checkForNegetiveNumber(this,"<%=noofdecimal%>","BL8540")'></td>
			
			<%if(ss){ %>
			<!-- 	//sarathkumar InclHmeMedi  -->
			<td class='fields' WIDTH='' nowrap ><input type='checkbox' <%=modifyStatus%> name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='<%=includeHomeMedication %>' <%="Y".equals(includeHomeMedication)?" checked ":""%>  <%="Y".equals(enableDisParam)?"":"disabled"%> onclick='checkInclHomeMedi(this); IncludeHomeMedicationUnchkExclude(this,"chargeexclude","<%=i%>");' > </td>
			<input type='hidden'  <%=modifyStatus%> name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value='<%=enableDisParam %>'> </td> 
			<% } else{%>
			<td><input type='hidden'   name='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' id='includeHomeMedication<%=i%>' value='Y'  >
			<input type='hidden'   name='enableDisParam<%=i%>' id='enableDisParam<%=i%>' id='enableDisParam<%=i%>' value='Y'> </td>
			<%} %>
			
			
			
			<td class='fields' nowrap ><input type='checkbox'   <%=modifyStatus%>	name='split_reqd<%=i%>' id='split_reqd<%=i%>' <%="checked".equals(inSel)?" disabled ":"" %> value='<%=splitReqd %>' <%="Y".equals(splitReqd)?" checked ":""%> onclick="checkSplitReqd(this);"></td>
			<td  class='fields'>
			<input type='checkbox' name='delCode_<%=i%>' id='delCode_<%=i%>' value='N'   <%=modifyStatus%> onclick="chkDeleteService(this,'<%=i%>')"/>
		   	</td>

			</tr>
		<%} %>
		</table>		
		</div>		
 		<!-- <TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			<tr>
			<td width="25%"  class='labels'>	</td>
			<td width="25%"  class='labels'>	</td>
			<td width="25%"  class='labels'>	</td>
			<td width="25%"  class='labels'>
			<INPUT type="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" onclick="addRow('pkgCbasedItem','CHARGE_BASED_ITEM')" /> </td>
			</tr>
		</table> -->
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
		<input type='hidden' name='serviceCode' id='serviceCode' value="<%=serviceCode%>" >
		<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
		<input type='hidden' name='custCode' id='custCode' value="<%=custCode%>" />
		<input type='hidden' name='totalRecords' id='totalRecords' id='totalRecords' value="<%=totRec%>" />
		<input type='hidden' name='siteSpecf' id='siteSpecf'  id='siteSpecf' value='<%=siteSpecf%>'> <!-- saraa -->
		<script>parent.updateNoofExcln(<%=totRec%>);</script>
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

