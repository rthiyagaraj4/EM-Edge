<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.PkgDefBean, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
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
<script language="javascript" src="../../eBL/js/PkgDef.js"></script> 
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
				
</head>

<script>

$(document).ready(function()
{
			
	 parent.parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.package_based_tab_checked.value='Y';
	//alert('check now '+ parent.parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.package_based_tab_checked.value);	
		
});
		
		
	</script>	


<% 
	try
	{

		String locale			 = (String)session.getAttribute("LOCALE");
		String facilityId		 = (String) session.getValue( "facility_id" ) ;
		String mode				 = "";
		String flagVal           = "insert"; 
		String status            = "";
		String statusFac		 = " disabled";

		String blgClsCode        = "";
		String blgClsDesc        = "";
		String indicator         = "R";
		String factorAppl        = "";
		String roundTo			 = "";
		String roundInd			 = "";
		String price1			 = "";
		String pSelect			 = "";
		String fSelect			 = "";
		//String uSelect			 = "";
		//String dSelect			 = "";
		String deposit			= "";
		String partialDeposit	= "";
		String minDepAmtind		= "";
		String minDepAmt		= "";
		//String statToModify		 = "";
		String factorforServiceRate ="";//Added by muthu for Factor for service rate issue for KDAH on 21-6-12  

		String fromDate			 = request.getParameter("fromDate")==null ? "" :request.getParameter("fromDate") ;
		int noofdecimal			 = 0;
		String rteBsdRcdSize="";
		String chgBsdRcSize="";
		int  totRec				 = 1;
		//int  totRec				 = 0;
		//flagVal					 = mode;
		HashMap basePrice		= new HashMap();
		HashMap basePriceDtls   = new HashMap();

		ArrayList dtlsArray	     =	new ArrayList();

		ArrayList blgClsCodeGrp	 =	new ArrayList();
		ArrayList blgClsDescGrp	 =	new ArrayList();
		ArrayList indicatorGrp	 =	new ArrayList();
		ArrayList price	         =	new ArrayList();
		ArrayList roundToGrp	 =	new ArrayList();
		ArrayList roundIndGrp	 =	new ArrayList();
		ArrayList factorApplGrp	 =	new ArrayList();
		ArrayList flag	         =	new ArrayList();
		ArrayList depositGrp	 =	new ArrayList();
		ArrayList partialDepGrp	 =	new ArrayList();
		ArrayList minDepAmtindGrp=	new ArrayList();
		ArrayList minDepAmtGrp	 =	new ArrayList();
		ArrayList factorforServiceRateGrp	 =	new ArrayList();//Added by muthu for Factor for service rate issue for KDAH on 21-6-12
															   
		CurrencyFormat cf        = new CurrencyFormat();
	  //	String packageCode = (String)session.getAttribute("packageCode") ;
		String packageCode				 =  request.getParameter("packageCode")==null ? "" :request.getParameter("packageCode") ;
		mode					 = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";

		String bean_id		     = "bl_PkgDefBean" ;
		String bean_name	     = "eBL.PkgDefBean";
		PkgDefBean bean		     = (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
		basePrice	=  (HashMap)bean.getBasePrice();

if("Y".equals(authorized)){
//Code Added By Vijay For MMS-DM-SCF-0357
		String beanRateBasedId		     = "bl_rateBasedPkgDefBean" ;
		PkgDefBean beanRateBased		     = (PkgDefBean)getBeanObject( beanRateBasedId, bean_name, request ) ;
		
		beanRateBased.setDBValues("RATE_BASED",packageCode,locale,facilityId,"","",fromDate);
		rteBsdRcdSize=Integer.toString(beanRateBased.getIncludedItems_RB().size());
	
		beanRateBased.setDBValues("CHARGE_BASED",packageCode,locale,facilityId,"","",fromDate);
		chgBsdRcSize=Integer.toString(beanRateBased.getIncludedItems_CB().size());
	
		
}
//ends
		boolean siteSpecPrtlDep = false;//Added V06042018-Aravindh/GHL-SCF-1107
		
		if(basePrice.containsKey(packageCode))
		{
			basePriceDtls	= (HashMap)basePrice.get(packageCode);
		}
		if(mode.equals("modify") && !(basePriceDtls.containsKey(fromDate)))
		{ 
			bean.setDBValues("PACKAGE_PRICE",packageCode,locale,facilityId,"","",fromDate);
			basePrice	=  (HashMap)bean.getBasePrice();
		}
		if(basePrice.containsKey(packageCode))
		{
			basePriceDtls	= (HashMap)basePrice.get(packageCode);
			if(basePriceDtls.containsKey(fromDate))
			{
				dtlsArray =(ArrayList)basePriceDtls.get(fromDate);
				if(dtlsArray.size()>0)
				{							   
					blgClsCodeGrp		= (ArrayList)dtlsArray.get(0);
					blgClsDescGrp		= (ArrayList)dtlsArray.get(1);
					indicatorGrp		= (ArrayList)dtlsArray.get(2);
					price				= (ArrayList)dtlsArray.get(3);
					roundToGrp			= (ArrayList)dtlsArray.get(4);
					roundIndGrp			= (ArrayList)dtlsArray.get(5);
					factorApplGrp		= (ArrayList)dtlsArray.get(6);
					flag				= (ArrayList)dtlsArray.get(7);
					depositGrp			= (ArrayList)dtlsArray.get(8);
					partialDepGrp		= (ArrayList)dtlsArray.get(9);
					minDepAmtindGrp		= (ArrayList)dtlsArray.get(10);
					minDepAmtGrp		= (ArrayList)dtlsArray.get(11);
					factorforServiceRateGrp		= (ArrayList)dtlsArray.get(12);//Added by muthu for Factor for service rate issue for KDAH on 22-6-12

				}
			}
		}
		noofdecimal = Integer.parseInt(bean.getNoOfDecimal());
		if((price !=null) && price.size()>0)
		{
			totRec = price.size();
		}
		//if(totRec ==1 ) flagVal = "insert"; 		
		
		//Karthik added code here MMS-CRF-0023 Starts
		String strChargeLogic="N";
		Connection con= ConnectionManager.getConnection(request);
		PreparedStatement pstmtChrg = con.prepareStatement("select NVL(CHARGE_LOGIC_YN,'N')  from bl_parameters where OPERATING_FACILITY_ID =?");
		pstmtChrg.setString(1,facilityId);
		ResultSet rsChrg = pstmtChrg.executeQuery() ;
		if( rsChrg != null ) 
		{	
			while( rsChrg.next() )
			{  
				strChargeLogic = rsChrg.getString(1);
				if(strChargeLogic==null){
				strChargeLogic="N";
				}
			}
		}
		if (rsChrg != null) rsChrg.close();
		if (pstmtChrg!=null) pstmtChrg.close();
		//Karthik added code here MMS-CRF-0023 Ends
		
		//Added V06042018-Aravindh/GHL-SCF-1107/try-catch block-starts
		try
		{				
			siteSpecPrtlDep = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","PRTL_DEP_OPT_YN");
			System.out.println("PkgDefBasePrice.jsp->siteSpecPrtlDep: "+siteSpecPrtlDep);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception in PkgDefBasePrice.jsp->site specific: "+e);
		}
		//Added V06042018-Aravindh/GHL-SCF-1107/try-catch block-ends
%>		
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();">	
	<form name='frmPkgDefBasePrice' id='frmPkgDefBasePrice'>	
	<!-- <div id="tbl-container" STYLE="overflow: auto; width: 1020px; height: 355px;   padding:3px; margin: 0px"> -->	
	
	<table border="1" width="100%" cellspacing='0' cellpadding='3' id="pkg_base_tbl">	
	<tr>
		<td  class='COLUMNHEADER' WIDTH='16%' nowrap><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='7%' nowrap><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='8%' nowrap><fmt:message key="Common.Price.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='2%' nowrap><fmt:message key="eBL.ROUND_TO.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='4%' nowrap><fmt:message key="eBL.ROUND_INDICATOR.label" bundle="${bl_labels}"/></td>	
	<td  class='COLUMNHEADER' WIDTH='7%' nowrap><fmt:message key="eBL.DEPOSIT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='12%' nowrap><fmt:message key="eBL.PARTIAL_DEPOSIT.label" bundle="${bl_labels}"/> </td>
	<td  class='COLUMNHEADER' WIDTH='9%' nowrap><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='13%' nowrap ><fmt:message key="eBL.MIN_DEPOSIT_AMOUNT.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' WIDTH='10%' nowrap>ApplFactServLmt</td>	  
	<td  class='COLUMNHEADER' width='14%' ><fmt:message key="eBL.FactorForServiceRate.Label" bundle="${bl_labels}"/></td>	  
	<td  class='COLUMNHEADER' WIDTH='9%' nowrap>&nbsp;</td>		
	</tr>
	
	<%
		for(int i=0; i<totRec; i++)
	{	
	
	if((price !=null) && price.size()>0)
	{
		blgClsCode = (String)(blgClsCodeGrp.get(i)==null?"":blgClsCodeGrp.get(i));
		blgClsDesc = (String)(blgClsDescGrp.get(i)==null?"":blgClsDescGrp.get(i));
		roundTo = (String)(roundToGrp.get(i)==null?"":roundToGrp.get(i));
		roundInd   = (String)(roundIndGrp.get(i)==null?"":roundIndGrp.get(i));
		indicator  = (String)(indicatorGrp.get(i)==null?"":indicatorGrp.get(i));
		price1   =(String)(price.get(i)==null?"":price.get(i));
		price1=cf.formatCurrency(price1, noofdecimal);
		factorAppl = (String)(factorApplGrp.get(i)==null?"":factorApplGrp.get(i));
		flagVal	 = (String)(flag.get(i)==null ? "insert" : flag.get(i));
		deposit = (String)(depositGrp.get(i)==null ? "N" : depositGrp.get(i));
		partialDeposit = (String)(partialDepGrp.get(i)==null ? "N" : partialDepGrp.get(i));
		minDepAmtind = (String)(minDepAmtindGrp.get(i)==null ? "" : minDepAmtindGrp.get(i));
		minDepAmt = (String)(minDepAmtGrp.get(i)==null ? "" : minDepAmtGrp.get(i));
		factorforServiceRate = (String)(factorforServiceRateGrp.get(i)==null ? "" : factorforServiceRateGrp.get(i));
	}
	
	if(flagVal.equals("insert"))
		status = "";
	else
		status = " disabled ";
	if(indicator.equals("F"))
	{
		statusFac = " " ;
		pSelect	  = "";
		fSelect	  = " selected ";
	}
	else
	{
		statusFac = " disabled" ;
		pSelect	  = " selected ";
		fSelect	  = " ";
	}

	%>
	
	<tr >
	<td  class='fields' WIDTH='' nowrap><input type='text' name='blgClsCode_<%=i%>' id='blgClsCode_<%=i%>'  <%=modifyStatus%> size='3' maxlength="2" onBlur="callBlgCls(document.forms[0].blgClsDesc_<%=i%>,this,'<%=i%>','code')" value="<%=blgClsCode%>" <%=status%>> <input type='text' name='blgClsDesc_<%=i%>' id='blgClsDesc_<%=i%>' <%=modifyStatus%> size='15' maxlength="30" value="<%=blgClsDesc%>" onBlur="callBlgCls(this,document.forms[0].blgClsCode_<%=i%>,'<%=i%>','desc')"  <%=status%>>	<input type='button' class='button' name='blgCls_<%=i%>' id='blgCls_<%=i%>' value='?' <%=modifyStatus%> onClick="callBlgCls(document.forms[0].blgClsDesc_<%=i%>,document.forms[0].blgClsCode_<%=i%>,'<%=i%>')" tabindex='0'  <%=status%>><img src='../../eCommon/images/mandatory.gif'></td>
	<td  class='fields' width='7%'>
	<select name='indicator_<%=i%>' id='indicator_<%=i%>' <%=modifyStatus%>   onChange="indiValidation(this,'<%=i%>')">
	<option value='R' <%=indicator.equals("R")?"selected":""%>><fmt:message key="Common.Price.label" bundle="${common_labels}"/></option>
	<option value='F' <%=indicator.equals("F")?"selected":""%>><fmt:message key="eBL.FACTOR.label" bundle="${bl_labels}"/></option>
	</select>
	</td>
				
	<td  class='fields' WIDTH='' nowrap><input type='text' name='price_<%=i%>' id='price_<%=i%>' size='12' maxlength="13"  value="<%=price1%>"  onkeypress=" return allowValidNumber(this,event,'10','<%=noofdecimal%>');"	 <%=modifyStatus%> onBlur='validateBaePrice(this,"<%=noofdecimal%>","BL8526","<%=i%>")'  /></td>

	<td  class='fields' WIDTH='' nowrap><input type='text' name='roundTo_<%=i%>' id='roundTo_<%=i%>'	<%=indicator.equals("R")?"disabled":""%> <%=modifyStatus%>  size='2'  value="<%=roundTo%>"  onkeypress=" return (allowValidNumber1(this,event));"  /></td>

	<td  class='fields' WIDTH='' nowrap>
	<select name='roundInd_<%=i%>' id='roundInd_<%=i%>'   <%=modifyStatus%>  <%=indicator.equals("R")?"disabled":""%>  onChange=""	>
	<option value='U' <%=roundInd.equals("U")?"selected":""%>><fmt:message key="Common.Up.label" bundle="${common_labels}"/></option>
	<option value='D' <%=roundInd.equals("D")?"selected":""%>><fmt:message key="eBL.DOWN.label" bundle="${bl_labels}"/></option>
	</select>
	</td>
			 
	<td  class='fields' WIDTH='' nowrap>
	<input type='checkbox' name='deposit_<%=i%>' id='deposit_<%=i%>' <%=(deposit.equals("Y")?" checked ":"")%> value="<%=deposit%>"   <%=modifyStatus%> onClick ="checkDeposit(this,'<%=i%>')" />
	</td>

	<td  class='fields' WIDTH='' nowrap> 
	<!-- Karthik added code here MMS-CRF-0023 --><!-- Added V06042018-Aravindh/GHL-SCF-1107/siteSpecPrtlDep == true -->
	<%if(strChargeLogic.equals("Y") || siteSpecPrtlDep == true){%>
	<input type='checkbox' name='partialDeposit_<%=i%>' id='partialDeposit_<%=i%>'  onClick ='checkPartialDeposit(this,<%=i%>)' <%=modifyStatus%> <%=(partialDeposit.equals("Y")?" checked ":"")%> value="<%=partialDeposit%>" <%=deposit.equals("Y")?"":" disabled "%>  />
	<!-- Added V06042018-Aravindh/GHL-SCF-1107/if-condition -->
	<%if(strChargeLogic.equals("Y")) {%>
	<a name='depositLink_<%=i%>' id='depositLink_<%=i%>' href="#" onClick ="openLinkScreen(<%=i%>,'<%=modifyStatus%>');" > Link </a>
	<%}
	}else{%>
	<input type='checkbox' name='partialDeposit_<%=i%>' id='partialDeposit_<%=i%>'  <%=modifyStatus%> <%=(partialDeposit.equals("Y")?" checked ":"")%> value="<%=partialDeposit%>" <%=deposit.equals("Y")?"":" disabled "%>  />
	<%}%>
	<!-- Karthik added code here MMS-CRF-0023 -->
	</td>

	<td  class='fields' WIDTH='' nowrap>	<!-- Karthik MODIFIED code adding charge logic here MMS-CRF-0023 -->
	<select name='minDepAmtind_<%=i%>' id='minDepAmtind_<%=i%>'	<%=modifyStatus%> <%=strChargeLogic.equals("Y")?" disabled ":""%> <%=partialDeposit.equals("Y")?"":" disabled "%> onChange='validateInd(this,"<%=i%>","minDepAmt_")'>
	<option value='' <%=(minDepAmtind.equals("")?"selected":"")%>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
	<option value='A' <%=(minDepAmtind.equals("A")?"selected":"") %> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
	<option value='R'  <%=(minDepAmtind.equals("R")?"selected":"") %> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
	</select>
	</td>
<!-- Karthik MODIFIED code adding charge logic here MMS-CRF-0023 -->
<td  class='fields' WIDTH='' nowrap>	<input type='text' <%=strChargeLogic.equals("Y")?" disabled ":""%> name='minDepAmt_<%=i%>' value="<%=minDepAmt%>" size='13' <%=modifyStatus%> maxlength="13" <%=minDepAmtind.equals("")?" disabled ":""%> onKeyPress="return allowValidNumber(this,event,'10','<%=noofdecimal%>');" onBlur='validForAmtPerUnltd(document.forms[0].minDepAmtind_<%=i%>,this,"<%=i%>","PACKAGE_PRICE","<%=noofdecimal%>")'  /></td>

	<td  class='fields'  WIDTH='' nowrap>
	<input type='checkbox' name='factorAppl_<%=i%>' id='factorAppl_<%=i%>' <%=modifyStatus%> 
	<%=factorAppl.equals("Y")?"checked":""%> value='<%=factorAppl%>'   onclick="factorAppl(this,'<%=i%>')"  <%=statusFac%>  />
	<input type='hidden' name='flag_<%=i%>' id='flag_<%=i%>' value="<%=flagVal%>" >
	</td>
	<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->
	<td  class='fields' WIDTH='' nowrap>
		<input type='text' name='factorforServiceRate<%=i%>' id='factorforServiceRate<%=i%>' <%=modifyStatus%> maxlength='20' size='10' value="<%=factorforServiceRate%>">
	</td>
	<!-- Added by muthu for Factor for service rate issue for KDAH on 21-6-12 -->

	<td  class='fields' WIDTH='' nowrap><input type='button' class='button' name='callReportPkg<%=i%>' id='callReportPkg<%=i%>' value='R' onClick="callReportPkgBase(this,'<%=i%>')" tabindex='0' <%=modifyStatus%> ></td><!--Added by muthu for Report issue for KDAH on 21-6-12 -->
	</tr>
	<%} %>
	</table>		
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" />
	<input type='hidden' name='totRec' id='totRec' value="<%=totRec%>" />
	<input type='hidden' name='index' id='index' value="0" />
	<input type='hidden' name='fromDate' id='fromDate' value="<%=fromDate%>" />
	<input type='hidden' name='blgClsCode' id='blgClsCode' value="<%=blgClsCode%>" />
	<input type='hidden' name='factorforServiceRate' id='factorforServiceRate' value="<%=factorforServiceRate%>" />	
	<input type='hidden' name='totalRecordsRateBased' id='totalRecordsRateBased' value="<%=rteBsdRcdSize %>"/>
	<input type='hidden' name='totalRecordsChargeBased' id='totalRecordsChargeBased' value="<%=chgBsdRcSize %>"/>
	<input type='hidden' name='siteSpecPrtlDep' id='siteSpecPrtlDep' value="<%=siteSpecPrtlDep%>" /><!-- Added V06042018-Aravindh/GHL-SCF-1107 -->
	<input type='hidden' name='strChargeLogic' id='strChargeLogic' value="<%=strChargeLogic%>" /><!-- Added V06042018-Aravindh/GHL-SCF-1107 -->
	
<script>	
	//commented by ram july23 and added new line	parent.updateCurrentForm("PACKAGE_PRICE","parent.frames[3].frames[0].document.frmPkgDefBasePrice","","parent.PkgDefHeader.document.frmPkgDefHeader",<%=totRec%>);
	parent.updateCurrentForm("PACKAGE_PRICE","parent.frames[3].frames[1].document.frmPkgDefBasePrice","","parent.PkgDefHeader.document.frmPkgDefHeader",<%=totRec%>);
</script>
	<script>alignHeading_BasePrice();</script>
</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from Package Base Price :"+e);
	e.printStackTrace();
}
%>

