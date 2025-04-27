<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,eBL.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
<script language="javascript" src='../../eBL/js/PkgDefDiscount.js'></script> 
<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	try
	{		
		String q_string         = request.getQueryString();
		String locale			= (String)session.getAttribute("LOCALE");
		String facilityId		= (String) session.getValue( "facility_id" ) ;
		String packageCode		= request.getParameter("packageCode");
		String longDesc 		= request.getParameter("longDesc");
		String effFromDate		= request.getParameter("effFromDate");
		String effToDate		= request.getParameter("effToDate");
		String orderAssociated	= request.getParameter("orderAssociated");
		String acrossEncounters	= request.getParameter("acrossEncounters");
		String no_of_decimals		= checkForNull(request.getParameter("noofdecimal"));
		String IpYn		= checkForNull(request.getParameter("IpYn"));
		String DcYn		= checkForNull(request.getParameter("DcYn"));
		String OpYn		= checkForNull(request.getParameter("OpYn"));
		String EmYn		= checkForNull(request.getParameter("EmYn"));
		//Added by Rajesh V - MMS-DM-SCF-0518
		String AllYn	= checkForNull(request.getParameter("AllYn"));
		String copyFrm_pkgCode		= checkForNull(request.getParameter("copyFrm_pkgCode"));
		String mode				= request.getParameter("mode")==null?"":request.getParameter("mode");
		packageCode				= checkForNull(packageCode);
		mode					= checkForNull(mode,"insert");
		longDesc				= checkForNull(longDesc);
		effFromDate				= checkForNull(effFromDate);
		effToDate				= checkForNull(effToDate);
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
		String bean_id			= "bl_PkgDefDiscountBean" ;
		String bean_name		= "eBL.PkgDefDiscountBean";
		PkgDefDiscountBean bean			= (PkgDefDiscountBean)getBeanObject( bean_id, bean_name, request ) ;

	no_of_decimals				= checkForNull(bean.getNoOfDecimal(),"0");
//	if(mode.equals("modify") && (bean.getCustDiscountDtls()==null || bean.getBlngGrpDiscountDtls().size()==0 )) {	
	if(mode.equals("modify") && ((bean.getCustDiscountDtls()==null || bean.getCustDiscountDtls().size()==0 ) && (bean.getBlngGrpDiscountDtls()==null || bean.getBlngGrpDiscountDtls().size()==0 ))) {	

		bean.setDBValues(packageCode,locale,facilityId);//set database values to bean.			
	}
	bean.setModifyDiscount("Y");	
   %>
		
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	
	<form name='discount_hdr' id='discount_hdr' >
	<table border='0' cellpadding='1' cellspacing='1' align='center' width='100%'>
	<tr>
		<td  class="label" width="25%"><fmt:message key="Common.PackageCode.label" bundle="${common_labels}"/></td>	

		<td  class='fields' width="25%"><input type='text' name='packageCode' id='packageCode' size='8' maxlength="8" readOnly value="<%=packageCode%>"  /><img src='../../eCommon/images/mandatory.gif'></td>

		<td class="label" width="25%"><fmt:message key="Common.LongDesc.label" bundle="${common_labels}"/></td>	
		
		<td class="fields" width="25%" >
		<input type='text' name='longDesc' id='longDesc' size='50' maxlength="100" readOnly  value="<%=longDesc%>" ><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>

	<tr>
		<td class='label'  width="25%">
			<fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/>
		</td>	
		<td class='fields'  width="25%">
			<input type='text' name='effFromDate' id='effFromDate' size='10' maxlength="10"  readOnly value="<%=effFromDate%>" /><img src='../../eCommon/images/mandatory.gif'>
		</td>
		<td class='label'  width="25%">
			<fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/>
		</td>	
		<td class='fields' width="25%">
			<input type='text' name='effToDate' id='effToDate' size='10' readOnly maxlength="10"  value="<%=effToDate%>" >
		</td>
	</tr>
</table>
<input type='hidden' name='orderAssociated' id='orderAssociated' value="<%=orderAssociated%>">
<input type='hidden' name='acrossEncounters' id='acrossEncounters' value="<%=acrossEncounters%>">
<input type='hidden' name='mode' id='mode' value="<%=mode%>">
<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=no_of_decimals%>" >
<input type='hidden' name='total_records' id='total_records' value="1">
<input type='hidden' name='total_records_excln' id='total_records_excln' value="1">
<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
<input type='hidden' name='IpYn' id='IpYn' value="<%=IpYn%>" >
<input type='hidden' name='DcYn' id='DcYn' value="<%=DcYn%>" >
<input type='hidden' name='OpYn' id='OpYn' value="<%=OpYn%>" >
<input type='hidden' name='EmYn' id='EmYn' value="<%=EmYn%>" >
<input type='hidden' name='AllYn' id='AllYn' value="<%=AllYn%>" >
<input type='hidden' name='copyFrm_pkgCode' id='copyFrm_pkgCode' value="<%=copyFrm_pkgCode%>" >
<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
<input type='hidden' name='allow_masterChild_package_map' id='allow_masterChild_package_map' value="N" />

<%
putObjectInBean(bean_id,bean,request);
%>
</form>
</body>
</html>
<SCRIPT>parent.frames[1].location.href='../../eBL/jsp/PkgDefCustDiscountMain.jsp?<%=q_string%>';
parent.frames[2].location.href='../../eBL/jsp/PkgDefBlngGrpDiscountMain.jsp?<%=q_string%>';</SCRIPT>
<%
}
catch(Exception e)
{
	System.out.println("Exception from Package defintion Discount header :"+e);
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

