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
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src='../../eBL/js/PkgDef.js'></script> 
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
/* Added By Vijay A.P. for GHL-SCF-1086 */
$(document).ready(function(){
var totalrecords=$('#totRec').val();
totalrecords=totalrecords-1;
var from_date=$('#fromDate_'+totalrecords).val();
$('#from_date').val(from_date);
});
/*  *** ends  ***  */


			
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
		String locale			 = (String)session.getAttribute("LOCALE");
		String facilityId		 = (String) session.getValue( "facility_id" ) ;
		String from	= request.getParameter("from")== null ? "PACKAGE" : request.getParameter("from"); 
		String mode				 = "";
		String flagVal           = "insert"; 
		String status            = "";

		String toDateStatus		 = "";
		String fromDate			 = "";
		String toDate			 = "";
		String glSmryYN			 = "";
		String glSmry			 = "";
		String glSmryDesc		 = "";
		String glSmryDisc		 = "";
		String glSmryDiscDesc	 = "";
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
		String VATapp		 = "";
		String VATapp_old		 = "";
		String VATpercent	 = "";
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
		String pkgPriceClsCode	 = "";
		String pkgPriceClsDesc	 = "";
		String oPkgPriceClsCode	 = "";
		String oPkgPriceClsDesc	 = "";

		int  totRec				 = 1;
		String radVal			 = "off";
		HashMap baseDates	     =	new HashMap();
		ArrayList dtlsArray	     =	new ArrayList();
		ArrayList priceFromDate  =	new ArrayList();
		ArrayList priceToDate	 =	new ArrayList();
		ArrayList pkgPClsCode	 =	new ArrayList();
		ArrayList pkgPClsDesc	 =	new ArrayList();
		ArrayList oPkgPClsCode	 =	new ArrayList();
		ArrayList oPkgPClsDesc	 =	new ArrayList();
		ArrayList glSmryList	 =	new ArrayList();
		ArrayList glSmryDescList =	new ArrayList();
		ArrayList glSmryDiscList	 =	new ArrayList();
		ArrayList glSmryDiscDescList =	new ArrayList();
		ArrayList flag	         =	new ArrayList();
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
		ArrayList VATappList	 =	new ArrayList();
		ArrayList VATappList_old	 =	new ArrayList();
		ArrayList VATpercentList	 =	new ArrayList();
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
		//ArrayList statusToModify =  new ArrayList();
		//HashMap latestDateForBCls=  new HashMap();
		boolean boolIsAfter=true;

		String  modifyStatus = "";
			//Added V180201-Gayathri/MMS-DM-CRF-0118/Starts
		String VATapplCheck="";
		String VATSetup="";
			//Added V180201-Gayathri/MMS-DM-CRF-0118/Ends
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		String packageCode				 =  request.getParameter("packageCode")==null ? "" :request.getParameter("packageCode") ;
		//String packageCode = (String)session.getAttribute("login_user") ;

		mode					 = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String bean_id		     = "bl_PkgDefBean" ;
		String bean_name	     = "eBL.PkgDefBean";
		PkgDefBean bean		     = (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
		
		baseDates	=  bean.getBaseDates();
		glSmryYN=bean.getGLSmryYN(facilityId);
		if(glSmryYN==null) glSmryYN="";
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";

		if(mode.equals("modify") && (baseDates==null || baseDates.size()==0 || !baseDates.containsKey(packageCode)) )
		{ 
			bean.setDBValues("PACKAGE_DATE",packageCode,locale,facilityId,"","","");
		}
		
		if(baseDates.containsKey(packageCode))
		{
			dtlsArray =(ArrayList)baseDates.get(packageCode);
			if(dtlsArray.size()>0)
			{
				priceFromDate		= (ArrayList)dtlsArray.get(0);
				priceToDate			= (ArrayList)dtlsArray.get(1);
				pkgPClsCode			= (ArrayList)dtlsArray.get(2);
				pkgPClsDesc			= (ArrayList)dtlsArray.get(3);
				oPkgPClsCode		= (ArrayList)dtlsArray.get(4);
				oPkgPClsDesc		= (ArrayList)dtlsArray.get(5);
				flag				= (ArrayList)dtlsArray.get(6);
				glSmryList			= (ArrayList)dtlsArray.get(7);
				glSmryDescList		= (ArrayList)dtlsArray.get(8);
				glSmryDiscList			= (ArrayList)dtlsArray.get(9);
				glSmryDiscDescList		= (ArrayList)dtlsArray.get(10);
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
				VATappList= (ArrayList)dtlsArray.get(11);
				VATpercentList = (ArrayList)dtlsArray.get(12);
				VATappList_old= (ArrayList)dtlsArray.get(13);
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
			}
		}

		if((priceFromDate !=null) && priceFromDate.size()>0)
		{
			totRec = priceFromDate.size();
		}
			
	//	if(totRec ==1 ) flagVal = "insert"; 
	
	
	
			

			Connection con = null;	
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts	
			Boolean VATapplicableYN=false;
			String VATapplicable ="";
			
			
			
		//sarath jan/10/2017 added code to make as siteSpecific MMS-QF-SCF-0545 beginning...	
			Boolean SiteSpec=false;
			String SiteSpecific ="";
			try
			{
				con = ConnectionManager.getConnection();	
				SiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","PKG_MANDATORY_TABCLK_CHK");
				VATapplicableYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","VAT_CHANGES_APPLICABLE_YN");						
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
			//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends	
			
			//sarath jan/10/2017 added code to make as siteSpecific MMS-QF-SCF-0545 ending...
	
	
	
	
%>	

	<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="" onSelect="codeArrestThruSelect();">
	<form name='frmPkgDefBaseDate' id='frmPkgDefBaseDate'>	
	<!-- <div id="tbl-container" STYLE="overflow: auto; width: 1020px; height: 355px;   padding:3px; margin: 0px"> -->
	<div id="divHeadSep" style="position: absolute;">
	<table class='grid' width='100%' id="pkgDate">
		<tr id="heading">
		<td  class='COLUMNHEADER' ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.PACKAGE_PRICE_CLASS.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.OUTSIDE_PACKAGE_PRICE_CLASS.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.AccountingCode.label" bundle="${bl_labels}"/> </td>
		<td  class='COLUMNHEADER' ><fmt:message key="eBL.DISC_ACC_CODE.label" bundle="${bl_labels}"/> </td>
		<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts -->
		<%if("Y".equals(VATapplicable)) {%>
		<td  class='COLUMNHEADER'><fmt:message key="eBL.VAT_APPLICABLE.label" bundle="${bl_labels}"/></td>
		<td  class='COLUMNHEADER'><fmt:message key="eBL.VAT_PERCENTAGE.label" bundle="${bl_labels}"/></td>
	<%} %>
	<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends -->
		<td  class='COLUMNHEADER' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/> </td>

		</tr>
	
		<%for(int i=0; i<totRec; i++)
		{
			
			if(i==0)
				radVal = "on";
			else
				radVal = "off";
			if((priceFromDate !=null) && priceFromDate.size()>0)
			{
				fromDate = (String)(priceFromDate.get(i)==null?"":priceFromDate.get(i));				 
				toDate   = (String)(priceToDate.get(i)==null?"":priceToDate.get(i));				
				pkgPriceClsCode = (String)(pkgPClsCode.get(i)==null?"":pkgPClsCode.get(i));				
				pkgPriceClsDesc = (String)(pkgPClsDesc.get(i)==null?"":pkgPClsDesc.get(i));
				oPkgPriceClsCode = (String)(oPkgPClsCode.get(i)==null?"":oPkgPClsCode.get(i));				
				oPkgPriceClsDesc = (String)(oPkgPClsDesc.get(i)==null?"":oPkgPClsDesc.get(i));
				glSmry = (String)(glSmryList.get(i)==null?"":glSmryList.get(i));
				glSmryDesc = (String)(glSmryDescList.get(i)==null?"":glSmryDescList.get(i));
				glSmryDisc = (String)(glSmryDiscList.get(i)==null?"":glSmryDiscList.get(i));
				glSmryDiscDesc = (String)(glSmryDiscDescList.get(i)==null?"":glSmryDiscDescList.get(i));
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
				VATapp = (String)(VATappList.get(i)==null?"":VATappList.get(i));
				VATapp_old = (String)(VATappList_old.get(i)==null?"":VATappList_old.get(i));
				VATpercent = (String)(VATpercentList.get(i)==null?"":VATpercentList.get(i));
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
				flagVal	 = (String)(flag.get(i)==null ? "insert" : flag.get(i));
				//statToModify	 = (String)(statusToModify.get(i)==null ? "" : statusToModify.get(i));
				//lastToDate = 
			
				/*if(flagVal.equals("modify") || flagVal.equals("modifyLast"))
				{
					status = " disabled ";					
				}
				else
				{
					status = "";				
				}	  */

			}  	

			%>
			<tr >
		
<td  class='fields' ><input type='text' name='fromDate_<%=i%>' id='fromDate_<%=i%>' id='fromDate_<%=i%>'size='10' maxlength="10"  value="<%=fromDate%>"   onBlur="showBasePrice(this,'<%=from%>','<%=i%>');dateKeyChange(this,this,'document.getElementById("toDate_")<%=i%>','<%=i%>','fromDate','document.getElementById("fromDatePrev_")<%=i%>');" <%=status%> <%=modifyStatus%>><img id = 'fromDate_img_<%=i%>' name="fromDate_img_<%=i%>"	  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fromDate_<%=i%>');"  <%=status%> <%=modifyStatus%> /><img src='../../eCommon/images/mandatory.gif'/><input type='hidden' name='fromDatePrev_<%=i%>' id='fromDatePrev_<%=i%>' id='fromDatePrev_<%=i%>' value="<%=fromDate%>" /></td>

			<td  class='fields' ><input type='text' name='toDate_<%=i%>' id='toDate_<%=i%>'  id='toDate_<%=i%>' size='10' maxlength="10"  value="<%=toDate%>"  onBlur="pkgValidateDate(this,'document.getElementById("fromDate_")<%=i%>',this,'<%=i%>','toDate');" <%=modifyStatus%>><img id = 'toDate_img_<%=i%>' name="toDate_img_<%=i%>"	<%=toDateStatus%> src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('toDate_<%=i%>');" <%=modifyStatus%>></td>

			<td  class='fields' >
			
			<input type='text' name='pkgPriceClsCode_<%=i%>' id='pkgPriceClsCode_<%=i%>' size='8' maxlength="8"  value="<%=pkgPriceClsCode%>" onBlur="callPkgPriceClass(this,'code','PRICE_CLASS','<%=i%>')" <%=modifyStatus%>> <input type='text' name='pkgPriceClsDesc_<%=i%>' id='pkgPriceClsDesc_<%=i%>' size='10' maxlength="10"  value="<%=pkgPriceClsDesc%>"	 <%=modifyStatus%> onBlur="callPkgPriceClass(this,'desc','PRICE_CLASS','<%=i%>')" ><input type='button' class='button' name='pkgPriceCls_<%=i%>' id='pkgPriceCls_<%=i%>' value='?' onClick="callPkgPriceClass('','','PRICE_CLASS','<%=i%>')" tabindex='0' <%=modifyStatus%>/>

			</td>
				
			<td  class='fields' ><input type='text' name='oPkgPriceClsCode_<%=i%>' id='oPkgPriceClsCode_<%=i%>' size='8' maxlength="8"  value="<%=oPkgPriceClsCode%>" onBlur="callPkgPriceClass(this,'code','OUT_PRICE_CLASS','<%=i%>')" <%=modifyStatus%>/>
			<input type='text' name='oPkgPriceClsDesc_<%=i%>' id='oPkgPriceClsDesc_<%=i%>' size='10' maxlength="10"  value="<%=oPkgPriceClsDesc%>" onBlur="callPkgPriceClass(this,'desc','OUT_PRICE_CLASS','<%=i%>')" <%=modifyStatus%>/><input type='button' class='button' name='OPkgPriceCls_<%=i%>' id='OPkgPriceCls_<%=i%>' value='?' onClick="callPkgPriceClass('','','OUT_PRICE_CLASS','<%=i%>')" tabindex='0' <%=modifyStatus%>/>
		</td>
		<td align="left" nowrap>
			<input type='text' name='glSmry<%=i%>' id='glSmry<%=i%>' size='3' maxlength="6" value="<%=glSmry%>" <%=glSmryYN.equals("N")?"disabled":""%> onBlur="glSmryCodeLookUp(glSmryDesc<%=i%>,this,'<%=i%>')" <%=modifyStatus%>/>
			<input type='text' name='glSmryDesc<%=i%>' id='glSmryDesc<%=i%>' size='15' maxlength="15" <%=glSmryYN.equals("N")?"disabled":""%> value="<%=glSmryDesc%>" onBlur="glSmryDescLookUp(this,glSmry<%=i%>,'<%=i%>')" <%=modifyStatus%>/>
			<input type='button' class='button' name='glSmryLookUp<%=i%>' id='glSmryLookUp<%=i%>' value='?' onClick="glSmryLookUp(glSmryDesc<%=i%>,glSmry<%=i%>,'<%=i%>');"  <%=glSmryYN.equals("N")?" disabled ":""%> <%=modifyStatus%>/><img src='../../eCommon/images/mandatory.gif'/><!--Modified by lakshmi-->
			<INPUT type='hidden' name='glSmry_temp<%=i%>' id='glSmry_temp<%=i%>' value=''>
			<INPUT type='hidden' name='glSmryDesc_temp<%=i%>' id='glSmryDesc_temp<%=i%>' value=''>
		</td>
		<td align="left" nowrap>
			<input type='text' name='glSmryDisc<%=i%>' id='glSmryDisc<%=i%>' size='3' maxlength="6" value="<%=glSmryDisc%>" <%=glSmryYN.equals("N")?"disabled":""%> onBlur="glSmryDiscCodeLookUp(glSmryDiscDesc<%=i%>,this,'<%=i%>')" <%=modifyStatus%>/>
			<input type='text' name='glSmryDiscDesc<%=i%>' id='glSmryDiscDesc<%=i%>' size='15' maxlength="15" <%=glSmryYN.equals("N")?"disabled":""%> value="<%=glSmryDiscDesc%>" onBlur="glSmryDiscDescLookUp(this,glSmryDisc<%=i%>,'<%=i%>')" <%=modifyStatus%>/>
			<input type='button' class='button' name='glSmryDiscLookUp<%=i%>' id='glSmryDiscLookUp<%=i%>' value='?' onClick="glSmryDiscLookUp(glSmryDiscDesc<%=i%>,glSmryDisc<%=i%>,'<%=i%>');"  <%=glSmryYN.equals("N")?" disabled ":""%> <%=modifyStatus%>/><img src='../../eCommon/images/mandatory.gif'/><!--Modified by lakshmi-->
			<INPUT type='hidden' name='glSmryDisc_temp<%=i%>' id='glSmryDisc_temp<%=i%>' value=''>
			<INPUT type='hidden' name='glSmryDiscDesc_temp<%=i%>' id='glSmryDiscDesc_temp<%=i%>' value=''>
			<INPUT type='hidden' name='VATapp1<%=i%>' id='VATapp1<%=i%>' value="<%=VATapp_old%>">
		</td>
		<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts -->
			<%if("Y".equals(VATapplicable)) {
				
				
				boolIsAfter= com.ehis.util.DateUtils.isBefore(toDate,"31/12/2017", "DMY", locale);
				if(("Y".equals(VATapp)) &&("modify".equals(flagVal)) && (!("").equals(fromDate)) &&(("Y").equals(VATapp_old)))
					VATSetup="disabled";
				else
					VATSetup="";
			
			
			
			
			%>
		<td>
		<input type='checkbox' name='VATapp<%=i%>' id='VATapp<%=i%>' id='VATapp<%=i%>' value="<%=VATapp%>"  <%=VATapp.equals("Y")?"checked":""%>	<%=modifyStatus%>  <%=VATSetup%>  onClick="enableRuleCode(this,'<%=i%>')" onLoad="enableRuleCode1()" >
		</td>
	
		<%
			
			
		if((!("Y".equals(VATapp)))|| ("modify".equals(flagVal))&&("Y").equals(VATapp_old)){
					VATapplCheck=" disabled ";
			
				}
				else{
					VATapplCheck="";
				  
				}
		
				
		%>
		<td>
		<input type='text' name='VATpercent<%=i%>' id='VATpercent<%=i%>' id='VATpercent<%=i%>' size='15' maxlength="15"  value="<%=VATpercent%>" <%=modifyStatus%> <%=VATapplCheck%><%=VATSetup%>   onBlur="ruleCodeLookup(VATpercent<%=i%>,'<%=i%>')"  />
		<input type='button' class='button' name='VATpercent_temp<%=i%>' id='VATpercent_temp<%=i%>' id='VATpercent_temp<%=i%>' value='?' <%=modifyStatus%><%=VATSetup%> <%=VATapplCheck%>  onClick="ruleCodeLookup(VATpercent<%=i%>,'<%=i%>')"/>
</td>


<%
		}
		%>
		<!--//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends -->
		<td align="left" nowrap>
		<input type='radio'  name='select_0' id='select_0'  id='select_<%=i%>' value="<%=radVal%>"  <%=(radVal.equals("on")?"checked":"")%>  onClick='showBasePrice(this,"<%=from%>","<%=i%>")' /><input type='hidden' name='flag_<%=i%>' id='flag_<%=i%>' value="<%=flagVal%>" ></td>

			</tr>
		<%} %>
		
		</table>		
		</DIV>
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='boolIsAfter' id='boolIsAfter' id='boolIsAfter' value="<%=boolIsAfter%>" >
		<input type='hidden' name='totRec' id='totRec' id='totRec' value="<%=totRec%>" >
		<input type='hidden' name='VATapplicable' id='VATapplicable' id='VATapplicable' value="<%=VATapplicable%>" >
		<input type='hidden' name='from' id='from' value="<%=from%>" >
		<input type='hidden' name='fromDate' id='fromDate' value="" />
		<input type='hidden' name='glSmryYN' id='glSmryYN' value="<%=glSmryYN%>">
		<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityId%>">
		<input type='hidden' name='new_date_added' id='new_date_added' value="N">
		<input type='hidden' name='package_based_tab_checked' id='package_based_tab_checked' value="N">
		<input type='hidden' name='rate_based_tab_checked' id='rate_based_tab_checked' value="N">
		<input type='hidden' name='charge_based_tab_checked' id='charge_based_tab_checked' value="N">
		<input type='hidden' name='child_package_tab_checked' id='child_package_tab_checked' value="N">
		<input type='hidden' name='from_date' id='from_date' id='from_date' value=''>
		<input type='hidden' name='SiteSpecific' id='SiteSpecific' id='SiteSpecific' value="<%=SiteSpecific%>" /> 

</form>
</body>
<%putObjectInBean(bean_id,bean,request);%>
</html>
<%
}
catch(Exception e)
{
	System.out.println("Exception from Package Date :"+e);
	e.printStackTrace();
}
%>

