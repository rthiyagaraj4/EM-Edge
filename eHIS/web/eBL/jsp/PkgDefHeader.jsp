<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,eBL.PkgDefBean,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
/*Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			   V220325				27973			MMS-ME-SCF-0046-TF			Mohana Priya K				
----------------------------------------------------------------------------------------------
*/
%>
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
<script language="javascript" src='../../eBL/js/PkgDef.js'></script> 
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

<script>
function avoidQuote()
{
	if( (window.event.keyCode == 34))	
		return false;
	else
		return true;
}	
</script>
</head>
<% 
try
{		
//V220324 Starts
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 //V220324 ends
	//Added V190325 Gayathri/KDAH-CRF-0503/Starts		
	Connection con = ConnectionManager.getConnection();	
	Boolean allow_masterChild_package=false;
	String allow_masterChild_package_map ="";
	String packageCode		=	checkForNull(request.getParameter("packageCode"));
	String facilityId		= (String) session.getValue( "facility_id" ) ;
	String isMasterPackChild="N";
	int count=0;
	Statement stmt,stmt1	= null;
	PreparedStatement pstmt2 = null;   //added by Nandhini for NMC-JD-CRF-0150.1
	ResultSet rs,rs1,rs2 = null;
try
{
	allow_masterChild_package = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ALLOW_MASTER_CHILD_PKG_MAPPING");	
	String sql="select IS_MASTER_PKG_YN from bl_package where PACKAGE_CODE=? ";
	String Sql1="SELECT count(*) FROM bl_package_child_dtl WHERE (package_code = ? OR link_package_code = ?) AND operating_facility_id = ? AND NVL (eff_to_date, TRUNC (SYSDATE) + 10000) >= TRUNC (SYSDATE)";
	/* Fixed SQL Injection for Common-ICN-0222 */
	/* stmt = con.createStatement();
	stmt1 = con.createStatement(); */
	pstmt2 = con.prepareStatement(sql);
	pstmt2.setString(1, packageCode);
	rs = pstmt2.executeQuery();
	if( rs != null ) 
	{
		System.out.println("If con ");
		while( rs.next() )
		{			
			System.out.println("While con ");
			isMasterPackChild = rs.getString(1);
			System.out.println("frm_date===> "+isMasterPackChild);
		}
	}
	if(pstmt2 != null) pstmt2.close();
	if(rs != null) rs.close();
	
	pstmt2 = con.prepareStatement(Sql1);
	pstmt2.setString(1, packageCode);
	pstmt2.setString(2, packageCode);
	pstmt2.setString(3, facilityId);
	rs1 = pstmt2.executeQuery();
	if( rs1 != null ) 
	{
		System.out.println("If con ");
		while( rs1.next() )
		{			
			System.out.println("While con ");
			count = rs1.getInt(1);
			System.out.println("frm_date===> "+count);
		}
	}
	if(rs1!=null) rs1.close();
			
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	if(allow_masterChild_package){
		allow_masterChild_package_map="Y";
	}
	else{
		allow_masterChild_package_map="N";
	}
//Added V190325 Gayathri/KDAH-CRF-0503/Ends	
		String locale			= (String)session.getAttribute("LOCALE");
		
		String	loggedInUser	=  (String) session.getValue("login_user");	
		
		String mode				= checkForNull("mode","insert");
		mode		=   checkForNull(request.getParameter("mode"));

		String isUserCanAcess	= (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
		String pkgApprovedYN		=	checkForNull(request.getParameter("pkgApprovedYN"),"N");
		String bean_id			= "bl_PkgDefBean" ;
		String bean_name		= "eBL.PkgDefBean";
		String modifyStatus     = "";
		PkgDefBean bean			= (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;
		//String copyFrm_pkgCode		=	request.getParameter("copyFrm_pkgCode") == null ? "" :request.getParameter("copyFrm_pkgCode") ;//unused variable.
		String disableAll="",disableCal="",disableOrdAssoc="enabled",enableAssocEnc="disabled",pkgAcrossEnctrYN="",enableEpiType="enabled";
		String authorized =	checkForNull(request.getParameter("authorized"),"N");
		try{
			String sql2 = "select ENABLE_ACROSS_ENC_FLAG_PKG from bl_parameters";
			pstmt2=con.prepareStatement(sql2);
			rs2 = pstmt2.executeQuery();
			if(rs2!=null && rs2.next()){
				pkgAcrossEnctrYN= checkForNull(rs2.getString("ENABLE_ACROSS_ENC_FLAG_PKG"));
				System.err.println("226,pkgAcrossEnctrYN==>"+pkgAcrossEnctrYN);
			} 
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception while retriving pkgAcrossEnctrYN-"+e);
		}
		   //added by Nandhini for NMC-JD-CRF-0150.1
		if(mode.equals("modify") && authorized.equals("N") && pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
			 
		 if("Y".equals(allow_masterChild_package_map)&& ("Y".equals(isMasterPackChild) || count >0 ))
			 {
				  modifyStatus = "disabled";
			 }
		if(mode.equals("modify") && !(packageCode.equals("")))
		{
		   disableAll="READONLY";
		   disableCal=" DISABLED ";
			/* Added by Aravindh/07-05-2018/IN67443/if-condition */
			if(!(bean.getPackageCode() != null && !"".equals(bean.getPackageCode()))) {
	        	bean.setDBValues("PACKAGE_MAIN",packageCode,locale,facilityId,"","","");
	        }
		}
		
		String modifyBtn = (authorized.equals("Y")|| isUserCanAcess.equals("N"))?" disabled ":"";
		packageCode		=	checkForNull(bean.getPackageCode());
		String longDesc 		=	checkForNull(bean.getLongDesc());
		String shortDesc 		=	checkForNull(bean.getShortDesc());
		String effFromDate		=	checkForNull(bean.getEffFromDate());
		String effToDate		=	checkForNull(bean.getEffToDate());
		String applSexInd 		=	checkForNull(bean.getApplSexInd());
		String minAgeInYrs		=	checkForNull(bean.getMinAgeInYrs());
		String minAgeInMths		=	checkForNull(bean.getMinAgeInMths());
		String minAgeInDays		=	checkForNull(bean.getMinAgeInDays());
		String maxAgeInYrs		=	checkForNull(bean.getMaxAgeInYrs());
		String maxAgeInMths		=	checkForNull(bean.getMaxAgeInMths());
		String maxAgeInDays		=	checkForNull(bean.getMaxAgeInDays());
		String OpYn				=	checkForNull(bean.getOpYn(),"N");
		String EmYn				=	checkForNull(bean.getEmYn(),"N");
		String IpYn				=	checkForNull(bean.getIpYn(),"N");
		String DcYn				=	checkForNull(bean.getDcYn(),"N");
		String AllYn			=   checkForNull(bean.getAllYn(),"N");
		String orderAssociated  =   checkForNull(bean.getOrderAssociated(),"N");
		String acrossEncounters =   checkForNull(bean.getAcrossEncounters(),"N");
		String applicalbleTo	=   checkForNull(bean.getApplicalbleTo());
		String auto				=   checkForNull(bean.getAuto(),"N");
		String validDays		=	checkForNull(bean.getValidDays());
		String approvedYN	    =   checkForNull(bean.getApprovedYN(),"N");
		String approvedBy	    =   checkForNull(bean.getApprovedBy());
		String approvedDate	    =   checkForNull(bean.getApprovedDate());
		String includeHomeMedication = "N";
		//String deposit			=   checkForNull(bean.getDeposit());
		//String partialDeposit	=   checkForNull(bean.getPartialDeposit());
		//String minDepAmt		=   checkForNull(bean.getMinDepAmt());
		String applicableToStatus = "";
		//String depositStatus = "";
		//String partialdepositStatus = "";
		String isMasterPackYN=checkForNull(bean.getIsMasterPkgYn(),"N");////Added V190325 Gayathri/KDAH-CRF-0503		

		if(applicalbleTo.equals("R"))
		{
			applicableToStatus = "disabled";			 
			//depositStatus = "disabled";
			//partialdepositStatus = "disabled";
		}
		else
		{
			applicableToStatus = "";
		/*	if(deposit.equals("Y"))
				depositStatus = "";
			else
				depositStatus = "disabled";
			if(partialDeposit.equals("Y"))
				partialdepositStatus = "";
			else
				partialdepositStatus = "disabled"; */
		}
		String userId = (String)session.getAttribute("login_user") ;
		boolean pkgApprovalStaus = bean.packageApprovalStatus(userId,facilityId);
		String apprvStst = " disabled ";
		if(pkgApprovalStaus)
			apprvStst = "";
		else  apprvStst = "disabled";
		if(approvedYN.equals("Y"))
			 apprvStst = "disabled";
		String allChkYn="",ipChkYn="",dcChkYn="",opChkYn="",acrossEncounterChck="",orderAssociatedYn="",emChkYn="",isMasterPackageYN="",includeHomeMedicationYn=""; //saraa
		String maleSelect="",femaleSelect="",otherSelect="",allSelect="" ,defSelect="";
		int noofdecimal=2;
		String strAllParam		= request.getQueryString();
		String sysDate			= "";
		String preferedDate     = "";
		allSelect= applSexInd.equals("A") ? "SELECTED" : "";						
		otherSelect=applSexInd.equals("U") ?"SELECTED" : "";
		maleSelect= applSexInd.equals("M")?"SELECTED" :"";
		femaleSelect=applSexInd.equals("F") ?"SELECTED" :"";
		defSelect=applSexInd.equals("") ? "SELECTED":"";
		opChkYn=OpYn.equals("Y")?"CHECKED":"";
		emChkYn=EmYn.equals("Y")?"CHECKED":"";
		ipChkYn=IpYn.equals("Y")?"CHECKED":"";
		dcChkYn=DcYn.equals("Y")?"CHECKED":"";
		orderAssociatedYn=orderAssociated.equals("Y")?"CHECKED":"";
		acrossEncounterChck=acrossEncounters.equals("Y")?"CHECKED":"";//Added by Nandhini against NMC-JD-CRF-0150.1
		auto = orderAssociated;
		allChkYn=AllYn.equals("Y")?"CHECKED":"";
		sysDate = bean.getSysDate();
		isMasterPackageYN=isMasterPackYN.equals("Y")?"CHECKED":"";
		System.out.println("sarath isMasterPackYN" + isMasterPackYN);
		String disableStatus="";
		if("insert".equals(mode)){
			
			disableStatus="enabled";
		}
		else{
			disableStatus="disabled";
		}
		 System.err.println("packageCode--"+packageCode);	
		if(mode.equals("modify") && !(packageCode.equals("")))
		{
			 System.err.println("231,modify authorized==>"+authorized);	
		   if(("Y".equals(OpYn))&&("N".equals(EmYn)) && ("N".equals(IpYn)) && ("N".equals(DcYn)) && ("Y".equals(pkgAcrossEnctrYN)) && authorized.equals("Y") && pkgApprovedYN.equals("Y")){
			   disableOrdAssoc=" enabled ";
			   System.err.println("231,enableAssocEnc==>"+enableAssocEnc);	
			   System.err.println("231,orderAssociated==>"+orderAssociated);	
			   if("Y".equals(orderAssociated)){
				   enableAssocEnc="enabled";
				   enableEpiType="DISABLED";//31072
			  }else{
				  enableAssocEnc=" DISABLED ";
			  }
		   }else if(("Y".equals(OpYn))&&("N".equals(EmYn)) && ("N".equals(IpYn)) && ("N".equals(DcYn)) && ("Y".equals(pkgAcrossEnctrYN)) && authorized.equals("N") && pkgApprovedYN.equals("N")){
			   disableOrdAssoc=" enabled ";
			   System.err.println("241,orderAssociated==>"+orderAssociated);	
			   System.err.println("241,enableAssocEnc==>"+enableAssocEnc);	
			   if("Y".equals(orderAssociated)){
				   enableAssocEnc="enabled";
				   enableEpiType="DISABLED";//31072
			  } else{
				  System.err.println("247,enableAssocEnc==>"+enableAssocEnc);
				  enableAssocEnc=" DISABLED ";
			  }
		   }else{
			   disableOrdAssoc="disabled";
			  enableAssocEnc="disabled";
			  }
			
		}
	System.err.println("213,enableAssocEnc==>"+enableAssocEnc);	
	System.err.println("213,disableOrdAssoc==>"+disableOrdAssoc);	
	//added by Nandhini for NMC-JD-CRF-0150.1
		preferedDate=com.ehis.util.DateUtils.convertDate(sysDate,"DMY","en",locale);  // SKR-SCF-0744 to display thai date
		noofdecimal = Integer.parseInt(bean.getNoOfDecimal());
		
		bean.setPartialDepositList(new HashMap<String,ArrayList<String>>()); //  MMS-CRF-0023 Partial Deposit Session Cleared here karthik
		
		includeHomeMedicationYn=includeHomeMedication.equals("Y")?"CHECKED":""; //saraa
   %>
	   <script>
	  
	   </script>
		
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onLoad = "initializeHdrFlds();chkmas();">
	
	<form name='frmPkgDefHeader' id='frmPkgDefHeader' >
	<table border='0' cellpadding='1' cellspacing='1' align='center' width='100%'>
	<tr  >
	
	<td  class="label" width="25%">
	<fmt:message key="Common.code.label" bundle="${common_labels}"/> 
	</td>	
		
	<td  class='fields' width="25%"><input type='text' name='packageCode' id='packageCode'  size='8' maxlength="8"  <%=disableAll%> <%=modifyStatus%>  value="<%=packageCode%>"  onKeyPress='return CheckForSpecChars_loc(event,packageCode)' onBlur='specialCharCheck(this);duplicateCheck(this,"<%=mode%>");'><img src='../../eCommon/images/mandatory.gif'><INPUT name='copy' id='copy' type="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Copy.label","common_labels")%>" <%=disableCal%> onclick="copyPkg();" />
	
	
		<% if(mode.equals("modify") && pkgApprovedYN.equals("Y")){ %>
	<input type='button' class='button' name='modify' id='modify'	  <%=modifyBtn%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>'  onClick='authUser("<%=packageCode%>");'>
	<%}%>	
	</td>
	
	<td class="label" width="25%"> 
	<fmt:message key="Common.LongDesc.label" bundle="${common_labels}"/> 
	</td>	
	
	<td class="fields" width="25%"  >
	<input type='text' name='longDesc' id='longDesc' size='50' maxlength="100"  value="<%=longDesc%>" onKeyPress='return avoidQuote();'  onBlur="makeValidString(longDesc)" <%=modifyStatus%>><img src='../../eCommon/images/mandatory.gif'>
	</td>
	</tr>

	<tr>
	<td class='label' width="25%">
	<fmt:message key="Common.ShortDesc.label" bundle="${common_labels}"/> 
	</td>	
	
	<td class='fields' width="25%">
	<input type='text' name='shortDesc' id='shortDesc' size='40' maxlength="40"  value="<%=shortDesc%>" onKeyPress='return avoidQuote();' onBlur="makeValidString(shortDesc)" <%=modifyStatus%>><img src='../../eCommon/images/mandatory.gif'>
	</td>
	
	<td class='label' width="25%"> 
	<fmt:message key="Common.gender.label" bundle="${common_labels}"/> 
	</td>	
		
	<td class='fields' width="25%">
	<select name='applSexInd' id='applSexInd' onChange="" <%=disableAll%> <%=modifyStatus%>>
	<option value='' <%=defSelect%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<option value='M' <%=maleSelect%>><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
	<option value='F' <%=femaleSelect%>><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
	<option value='U'<%=otherSelect%>><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
	<option value='A' <%=allSelect%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	</select><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
	
<tr>
<td class='label'  width="25%">Effective(From-To)
<!--<fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/> -->
</td>	

<td class='fields'  width="25%">
<input type='text' name='effFromDate' id='effFromDate' size='10' maxlength="10"  value="<%=effFromDate%>"  <%=modifyStatus%> onBlur="return validDateChk(this)"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('effFromDate');" <%=modifyStatus%> ><img src='../../eCommon/images/mandatory.gif'><B>-</B><input type='text' name='effToDate' id='effToDate' size='10' maxlength="10"  value="<%=effToDate%>"   onBlur="return toFromdateChk(this)" <%=modifyStatus%>><img src="../../eCommon/images/CommonCalendar.gif"  id='effToDateCal' onClick="return showCalendar('effToDate');" <%=modifyStatus%>>
</td>
<td class='label'  width="25%">
 <fmt:message key="eBL.VALID_DAYS.label" bundle="${bl_labels}"/>	
<input type='text' name='validDays' id='validDays' size='3' maxlength='4'   value="<%=validDays%>"    <%=modifyStatus%> onKeyPress='return(ChkNumberInput(this,event,"0"))' onBlur='numberCheck(this,"V","<%=mode%>")'/><img src='../../eCommon/images/mandatory.gif'>	 </TD>
<td class='label'  width="25%"><fmt:message key="eBL.AcrossEncounters.label" bundle="${bl_labels}"/>

<% if(pkgAcrossEnctrYN.equals("Y")){ %>
<input type='checkbox' name='acrossEncounters' id='acrossEncounters'  value="<%=acrossEncounters%>" <%=enableAssocEnc%> <%=acrossEncounterChck%> onClick="chkAcrossEncounters(this);"/>
<%}else{%>
<input type='checkbox' name='acrossEncounters' id='acrossEncounters' s value="<%=acrossEncounters%>"  <%=acrossEncounters.equals("Y")?"checked":""%>	<%=modifyStatus%> <%=(mode.equals("modify") && !acrossEncounters.equals(""))?"READONLY":""%>  onClick="chkAcrossEncounters(this);"/>
<%}%>

</td>


</tr>

<tr>
<td class='label' width="25%">Age(Min-Max) 
<!--<fmt:message key="Common.MinAge.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'> -->
</td>	

<td class='fields' width="25%">
<input type='text' name='minAgeInYrs' id='minAgeInYrs' size='3' maxlength="3"  value="<%=minAgeInYrs%>" <%=modifyStatus%>  onKeyPress='return(ChkNumberInput(this,event,"0"))' onBlur='numberCheck(this,"Y")'>Y
<input type='text' name='minAgeInMths' id='minAgeInMths' size='2' maxlength="2"  value="<%=minAgeInMths%>" <%=modifyStatus%> onBlur='numberCheck(this,"M")' 
onKeyPress='return(ChkNumberInput(this,event,"0"))'>M
<input type='text' name='minAgeInDays' id='minAgeInDays' size='2' maxlength="2"  value="<%=minAgeInDays%>" <%=modifyStatus%> onBlur='numberCheck(this,"D")' 
onKeyPress='return(ChkNumberInput(this,event,"0"))'>D<B>-</B><input type='text' name='maxAgeInYrs' id='maxAgeInYrs' size='3' maxlength="3"  value="<%=maxAgeInYrs%>"  <%=modifyStatus%> onKeyPress='return(ChkNumberInput(this,event,"0"))' onBlur='numberCheck(this,"Y")'>Y
<input type='text' name='maxAgeInMths' id='maxAgeInMths' size='2' maxlength="2"  value="<%=maxAgeInMths%>" <%=modifyStatus%> onBlur='numberCheck(this,"M")'
onKeyPress='return(ChkNumberInput(this,event,"0"))'>M
<input type='text' name='maxAgeInDays' id='maxAgeInDays' size='2' maxlength="2"  value="<%=maxAgeInDays%>" <%=modifyStatus%> onBlur='numberCheck(this,"D")'
onKeyPress='return(ChkNumberInput(this,event,"0"))'>D
<td class='label' width="25%" > <fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/> </td>
<td class='fields' width="20%">	<select name='applicalbleTo' id='applicalbleTo'	<%=modifyStatus%> onChange="chkApplTo(this)" >
<%if(applicalbleTo.equals("")){%>
<option value='' selected >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
 <option value='A' ><fmt:message key="eBL.CASH.label" bundle="${bl_labels}"/></option>
<option value='R' ><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></option>
<option value='B' ><fmt:message key="Common.Both.label" bundle="${common_labels}"/>(<fmt:message key="eBL.CashCredit.label" bundle="${bl_labels}"/>)</option>
 <%}//else{%>
<%if(applicalbleTo.equals("A")){%>
<option value='A' selected><fmt:message key="eBL.CASH.label" bundle="${bl_labels}"/></option>
<option value='B' ><fmt:message key="eBL.CashCredit.label" bundle="${bl_labels}"/></option>
<option value='R' ><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></option>
<%}else if(applicalbleTo.equals("R")){%>
<option value='R' selected ><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></option>
<option value='B' ><fmt:message key="eBL.CashCredit.label" bundle="${bl_labels}"/></option>
<option value='A' ><fmt:message key="eBL.CASH.label" bundle="${bl_labels}"/></option>

<%}else if(applicalbleTo.equals("B")){%>
<option value='B' <%=applicalbleTo.equals("B")?"selected":""%> ><fmt:message key="eBL.CashCredit.label" bundle="${bl_labels}"/></option>
<option value='R'  ><fmt:message key="eBL.CREDIT.label" bundle="${bl_labels}"/></option>
<option value='A' ><fmt:message key="eBL.CASH.label" bundle="${bl_labels}"/></option>

<%}%>
<%//}%>
			
</select><img src='../../eCommon/images/mandatory.gif'> </td>
</td>
</tr>

<tr>
<td class='label' width="10%" > <fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'> </td>
			
<td class='label' width="50%" &nbsp;&nbsp;>
<fmt:message key="Common.all.label" bundle="${common_labels}"/>
<input type='checkbox' name='AllYn' id='AllYn' value="<%=AllYn%>"  <%=allChkYn%> <%=enableEpiType%> <%=modifyStatus%> onclick="appChk('<%=mode%>',this)">
<fmt:message key="Common.IP.label" bundle="${common_labels}"/> 
<input type='checkbox' name='IpYn' id='IpYn' value="<%=IpYn%>" <%=enableEpiType%> onBlur="" <%=ipChkYn%> <%=modifyStatus%> onclick="appChk('<%=mode%>',this)">
<fmt:message key="Common.DC.label" bundle="${common_labels}"/> 
<input type='checkbox' name='DcYn' id='DcYn' value="<%=DcYn%>" <%=enableEpiType%> onBlur="" <%=dcChkYn%>  <%=modifyStatus%> onclick="appChk('<%=mode%>',this)">
<fmt:message key="Common.OP.label" bundle="${common_labels}"/> 
<input type='checkbox' name='OpYn' id='OpYn' value="<%=OpYn%>" onBlur="" <%=opChkYn%> <%=modifyStatus%> <%=disableAll%> onclick="appChk('<%=mode%>',this)">
<fmt:message key="eMP.EM.label" bundle="${mp_labels}"/> 
<input type='checkbox' name='EmYn' id='EmYn' value="<%=EmYn%>" <%=enableEpiType%> onBlur="" <%=emChkYn%>   <%=modifyStatus%> <%=disableAll%> onclick="appChk('<%=mode%>',this)"> 
</td>	

<td class='label' width="20%" id = 'autocheck' STYLE="display:none;"  > &nbsp;&nbsp;   
<fmt:message key="eBL.orderAssociated.label" bundle="${bl_labels}"/> 
</td>	

<td class='fields' width="20%" id = 'autocheck1'>
<input type='checkbox' name='orderAssociated' id='orderAssociated' id='orderAssociated' value="<%=orderAssociated%>"	  onBlur=""  <%=disableOrdAssoc%> <%=orderAssociatedYn%> onclick="orderAssociatedCheck(this,'<%=mode%>')">
</td>	
</tr>

<tr>
<td class='label'  width="25%">
<fmt:message key="Common.Approved.label" bundle="${common_labels}"/> 
<input type='checkbox' name='approvedYN' id='approvedYN' <%=apprvStst%> value="<%=approvedYN%>" <%=modifyStatus%> <%=approvedYN.equals("Y")?" checked ":""%> onClick="checkForApproval(this,'<%=loggedInUser%>','<%=preferedDate%>')" /> <!-- SKR-SCF-0744 prefereddate added to display thai date -->
</td>
<td class='label'  width="50%" colspan="3"> <fmt:message key="Common.ApprovedBy.label" bundle="${common_labels}"/>	
<input type='text' name='approvedBy' id='approvedBy' size='10' maxlength="10" 	   value="<%=approvedBy%>"  readOnly />
<fmt:message key="eBL.APPROVED_DATE.label" bundle="${bl_labels}"/> 
<input type='text' name='approvedDate' id='approvedDate' size='10' maxlength="10"  onBlur="return validDateChk(this)" value="<%=approvedDate%>"   <%=apprvStst%> readOnly/>
</td>
<%if(("Y").equals(allow_masterChild_package_map)){%>
<td class='label' width="20%" >    
<fmt:message key="eBL.MASPACK.label" bundle="${bl_labels}"/> 
</td>	
<td class='fields' width="20%" >

<input type='checkbox' name='mast_pack' id='mast_pack' id='mast_pack' value="<%=isMasterPackYN%>"  <%=isMasterPackageYN%> <%=disableStatus%>	<%=modifyStatus%> onclick="chkMasterpack(this)">
</td>

<%}%>
<!-- saraa -->
<!-- 
<td class='label'  width="20%">
<fmt:message key="eBL.includeHomeMedication.label" bundle="${bl_labels}"/> 
</td>
<td class='fields' width="20%" >  
<input type='checkbox' name='includeHomeMedication' id='includeHomeMedication'  value="<%=includeHomeMedication%>"	 <%=modifyStatus%>  onBlur=""  <%=includeHomeMedicationYn%> <%=disableAll%> onclick="includeHomeMedicationMainYn(this,'<%=mode%>');">
</td> -->
</tr>
</table>
	<input type='hidden' name='current_form1' id='current_form1' value="">
	<input type='hidden' name='current_form2' id='current_form2' value="">
	<input type='hidden' name='last_link' id='last_link' value="">
	<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
	<input type='hidden' name='fromDate0' id='fromDate0' value="" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >

	<input type='hidden' name='total_records' id='total_records' value="1">
	 <input type='hidden' name='total_records_excln' id='total_records_excln' value="1">
	<!--temp-->
	<input type='hidden' name='daysValid' id='daysValid' value="" >
	<input type='hidden' name='statusHdr' id='statusHdr' value="" >
	<input type='hidden' name='mode' id='mode' value="<%=mode%>" >
	<input type='hidden' name='auto' id='auto' value="<%=auto%>" >
	<input type='hidden' name='copyFrm_pkgCode' id='copyFrm_pkgCode' value="" >
	<input type='hidden' name='copyFrm_pkgDesc' id='copyFrm_pkgDesc' value="" >
	<input type='hidden' name='oldValidDays' id='oldValidDays' value="<%=(mode.equals("insert")?"":validDays)%>" >
	<input type='hidden' name='pkgApprovalStaus' id='pkgApprovalStaus' value="<%=pkgApprovalStaus%>" >
	<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" />
	<input type='hidden' name='pkgApprovedYN' id='pkgApprovedYN' value="<%=pkgApprovedYN%>" />
	<input type='hidden' name='strAllParam' id='strAllParam' value="<%=strAllParam%>" />
	<input type='hidden' name='pkgAcrossEnctrYN' id='pkgAcrossEnctrYN' value="<%=pkgAcrossEnctrYN%>" />
	<input type='hidden' name='allow_masterChild_package_map' id='allow_masterChild_package_map' value="<%=allow_masterChild_package_map%>" />
	<input type='hidden' name='isMasterPackYN' id='isMasterPackYN' value="<%=isMasterPackYN%>" />
	<!--End-->

<%
	putObjectInBean(bean_id,bean,request);
%>
</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{
		System.out.println("Exception from Package defintion header :"+e);
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

