<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.*,eBL.Common.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	request.setCharacterEncoding("UTF-8");

	HttpSession httpSession = request.getSession(false);
	String facility_id=(String)session.getValue("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	Connection con = null;
	PreparedStatement pstmt=null,pstmt1=null,pstmt2=null,pstmt3=null;
	ResultSet rst=null,rst1=null,rst2=null,rst3=null;
	Statement stmt=null;
	ResultSet rset=null ;
	Properties p=(Properties)session.getValue("jdbc");
	String userId=p.getProperty( "login_user" ) ;
	int noofdecimal=2;
	String en="";
	String dat="";
	String billingGrp_code="";
	String payerGrp_code="";
	String payer_code="";
	String policy_code="";	
	String p_facility_id="";
	String fac_Id="";
	String fac_name="";
	String chk_checked="checked";
	String mode=request.getParameter("mode");
	String disabled = "";
	String totaldisabled = "";
	String readonly="";
	String sql="",sql1="",sql2="",sql3="";
	String billing_group_desc="",payerDesc="",payergroup="";
	String alwAdhocPkgcheckYN="",alwMultiPkgDiscChkYn="",alwPkgCustChkYn="";

	String billing_group = request.getParameter("blngGroup")==null?"":request.getParameter( "blngGroup" ).trim().toUpperCase();
	String payer_group =request.getParameter("payerGroup")==null?"":request.getParameter( "payerGroup" ).trim().toUpperCase();
	String payer =request.getParameter("payer")==null?"":request.getParameter( "payer" ).trim().toUpperCase();
	String policy =request.getParameter("policyType")==null?"":request.getParameter( "policyType" ).trim().toUpperCase();

	String validFrom =request.getParameter("validFrom")==null?"":request.getParameter( "validFrom" ).trim().toUpperCase();
	String facility =request.getParameter("facility")==null?"":request.getParameter( "facility" ).trim().toUpperCase();
	String validTo =request.getParameter("validTo")==null?"":request.getParameter( "validTo" ).trim().toUpperCase();
	String applInd =request.getParameter("applInd")==null?"E":request.getParameter( "applInd" ).trim().toUpperCase(); 
	String alwMultiPkgYN =request.getParameter("alwMultiPkgYN")==null?"":request.getParameter( "alwMultiPkgYN" ).trim().toUpperCase();
	String alwPkgCustYN =request.getParameter("alwPkgCustYN")==null?"":request.getParameter( "alwPkgCustYN" ).trim().toUpperCase();
	String alwAdhocPkgYN =request.getParameter("alwAdhocPkgYN")==null?"":request.getParameter( "alwAdhocPkgYN" ).trim().toUpperCase();
	String discPerc =request.getParameter("discPerc")==null?"":request.getParameter( "discPerc" ).trim().toUpperCase();
	
	if(mode.equals("modify"))
	{
	try{
		readonly = "readonly";
		disabled = "disabled";
		totaldisabled = "disabled";	
		con=ConnectionManager.getConnection(request);
		
		sql="select short_desc description from bl_blng_grp where BLNG_GRP_ID = '"+billing_group+"' union select 'All' from dual where '"+billing_group+"' = '**'";
	  
		sql1="select SHORT_NAME description from ar_customer where cust_code ='"+payer+"' union select 'All' from dual where '"+payer+"' = '**'";
	   
		sql2="select short_desc description from ar_cust_group where cust_group_code = '"+payer_group+"' union select 'All' from dual where '"+payer_group+"' = '**'";
	   
		sql3="select TO_CHAR (VALID_FROM_DATE, 'dd/mm/yyyy') VALID_FROM_DATE,TO_CHAR (VALID_TO_DATE, 'dd/mm/yyyy') VALID_TO_DATE,APPLICABILITY_IND,DISC_PERC,ALW_MULTI_PKG_DISC,ALW_CUST_PKG_DISC,ALW_ADHOC_PKG_DISC from BL_MULTI_PKG_DISCOUNT where OPERATING_FACILITY_ID='"+facility_id+"' and BLNG_GRP_ID='"+billing_group+"' and CUST_GROUP_CODE='"+payer_group+"' and CUST_CODE='"+payer+"' and POLICY_TYPE_CODE='"+policy+"'";
	      
		pstmt=con.prepareStatement(sql);
		pstmt1=con.prepareStatement(sql1);
		pstmt2=con.prepareStatement(sql2);
		pstmt3=con.prepareStatement(sql3);

		rst=pstmt.executeQuery();
		rst1=pstmt1.executeQuery();
		rst2=pstmt2.executeQuery();
		rst3=pstmt3.executeQuery();

		if(rst!=null && rst.next())
		{
			billing_group_desc=rst.getString("description");			
		}
		if(rst1!=null && rst1.next())
		{
			payerDesc=rst1.getString("description");			
		}
		if(rst2!=null && rst2.next())
		{
			payergroup=rst2.getString("description");			
		}

		if ((validFrom == null) || (validFrom == "")) { //Added V190528-Dhananjay/MMS-DM-CRF-130/70574
			if(rst3!=null && rst3.next())
			{
				validFrom=com.ehis.util.DateUtils.convertDate(rst3.getString("VALID_FROM_DATE"),"DMY","en",locale);	
				validTo=com.ehis.util.DateUtils.convertDate(rst3.getString("VALID_TO_DATE"),"DMY","en",locale);	
				applInd=rst3.getString("APPLICABILITY_IND");	
				discPerc=rst3.getString("DISC_PERC");	
				alwMultiPkgYN=rst3.getString("ALW_MULTI_PKG_DISC");	
				alwPkgCustYN=rst3.getString("ALW_CUST_PKG_DISC");	
				alwAdhocPkgYN=rst3.getString("ALW_ADHOC_PKG_DISC");
			}
			} //Added V190528-Dhananjay/MMS-DM-CRF-130/70574

		alwMultiPkgDiscChkYn=alwMultiPkgYN.equals("Y")?"CHECKED":"";
		alwPkgCustChkYn=alwPkgCustYN.equals("Y")?"CHECKED":"";
		alwAdhocPkgcheckYN=alwAdhocPkgYN.equals("Y")?"CHECKED":"";

		/*//Added V190603-Dhananjay/MMS-DM-CRF-130/70600/Start-- commented against MuthuN/72898
		if ("**".equals(policy) ){
			policy = "All";
		}
		//Added V190603-Dhananjay/MMS-DM-CRF-130/70600/End*/

		//Added V200423-MuthuN/72898/Start
		if ("**".equals(policy) ){
			policy = "**";
		}
		//Added V200423-MuthuN/72898/End
	}catch(Exception e)
	{
		System.out.println("Exception in MultiPkgDisc==>"+e);
		e.printStackTrace();
	}
	finally{
		try{
			if(pstmt!=null) pstmt.close();
			if(rst!=null)rst.close();
			if(pstmt1!=null) pstmt1.close();
			if(rst1!=null)rst1.close();
			if(pstmt2!=null) pstmt2.close();
			if(rst2!=null)rst2.close();
			if(pstmt3!=null) pstmt3.close();
			if(rst3!=null)rst3.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e)
		{
			//out.println("Exception is "+e);
			e.printStackTrace();
		}
		}
	}
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/MultiPkgDisc.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>

	<script>
	function clearPolicyFields(obj){
		obj.value = '';
	}

	function enableAppy()
	{
		if(document.forms[0].mode.value == "modify" ){
			parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
			//parent.commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?';
		}
		if(document.forms[0].mode.value == "insert" ){
			document.forms[0].MultiPkgDiscYN.checked=true;
			document.forms[0].PkgCustDiscYN.checked=true;
			document.forms[0].PkgAdDiscYN.checked=true;
			document.forms[0].multipkgdisc.value="0";
		}
	}
</script>
<body  OnLoad="enableAppy();" OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"   >
<form name='multiPkgCreate' id='multiPkgCreate' action='../../servlet/eBL.MultiPkgDiscServlet'  method='post' target='messageFrame' onload='pkgDefLoaded()'>
<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
<tr>
	<td class="columnheader">Package Details</td>
</tr>	
</TABLE>	
<table  cellpadding=5 cellspacing=0 border=0  width="100%" align='left'>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;
		<select name='facility' id='facility' id='facility' <%=disabled %> >
		<%
			try{
				String sqlFacility = "select facility_id, facility_name from Sm_Facility_Param where status = 'E' and facility_id = ? ";
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sqlFacility);
				pstmt.setString(1,facility_id);
				rst = pstmt.executeQuery();
				if(rst != null){
					while(rst.next()){ 
						fac_Id=rst.getString("facility_id");
						fac_name=rst.getString("facility_name");
		%>			
			<option value='<%=fac_Id %>'><%=fac_name %></option>
		<%			
			}
			}
			}catch(Exception e) {
				System.out.println("Sm_Facility_Param in MultiPkgDisc===>"+e.toString());
				e.printStackTrace();
			}
			finally{
				rst.close(); 
				pstmt.close();				
			}
		%>
		</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
		<td width='10%'>&nbsp;</td>	
	</tr>
	<tr>
	</tr>
	<tr>
		<td colspan="6"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
		 <td class='fields'  nowrap>&nbsp;&nbsp;&nbsp;<input type='text' name='blngGrpDesc' id='blngGrpDesc' id='blngGrpDesc' size="30" value="<%=billing_group_desc%>"  onblur="if(this.value!=''){ callCommonValidation(4,blngGrpDesc,billingGrpCode); } else{ clearPolicyFields(blngGrpDesc); }" <%=disabled%> ><input type= 'hidden' name="billingGrpCode" id="billingGrpCode"  value="<%=billing_group%>">&nbsp;
		<input type='button' class='button' name="blngGrpBtn" id="blngGrpBtn" value='?' onClick="callCommonValidation(4,blngGrpDesc,billingGrpCode);" tabindex='2'><img src='../../eCommon/images/mandatory.gif'></td>	
	</tr> 
	<tr>
		<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td width='40%' class='label'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
		<td class='fields'  nowrap>&nbsp;&nbsp;&nbsp;<input type='text' name='payerGroup2' id='payerGroup2' size='30' maxlength='40' value="<%=payergroup%>" onblur='if(this.value!=""){ callCommonValidation(2,payerGroup2,payergrpCode); } else{clearPolicyFields(payerGroup2);}' <%=disabled%> >
		<input type='hidden' name='payergrpCode' id='payergrpCode' value="<%=payer_group%>">&nbsp;<input type='button' class='button' name="payerGroup2_btn" id="payerGroup2_btn" value='?'  onClick="callCommonValidation(2,payerGroup2,payergrpCode);" tabindex='2'><img src='../../eCommon/images/mandatory.gif'></td>	
	</tr>
	<tr>
		<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td width='40%' class='label'><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
		<td class='fields'  nowrap>&nbsp;&nbsp;&nbsp;<input type='text' name='payerGroup1' id='payerGroup1' size='30' maxlength='40'  value="<%=payerDesc%>" onblur='if(this.value!=""){ callCommonValidation(1,payerGroup1,payerCode);} else{clearPolicyFields(payerCode);}' <%=disabled%> ><input type='hidden' name='payerCode' id='payerCode' value="<%=payer%>">&nbsp;&nbsp;<input type='button' class='button' name="payerGroup1_btn" id="payerGroup1_btn" value='?'  onClick="callCommonValidation(1,payerGroup1,payerCode);" tabindex='2'><img src='../../eCommon/images/mandatory.gif'></td>	
	</tr>
	<tr>
		<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td width='40%' class='label'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
		<td class='fields'  nowrap>&nbsp;&nbsp;&nbsp;<input type='text' name='policyType' id='policyType' size='30' maxlength='40' value="<%=policy%>" onblur='if(this.value!=""){ callCommonValidation(3,policyType,policyTypeCode);} else{clearPolicyFields(policyTypeCode);}' <%=disabled%> >
		<input type='hidden' name='policyTypeCode' id='policyTypeCode' value="<%=policy%>">&nbsp;<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?'  onClick="callCommonValidation(3,policyType,policyTypeCode);" tabindex='2'><img src='../../eCommon/images/mandatory.gif'></td>	
	</tr>
	<tr>
		<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.VALID_FROM.label" bundle="${bl_labels}"/></td>
		<td  class='fields' >&nbsp;&nbsp;&nbsp;<input type='text' name='fromDate_' id='fromDate_'  id='fromDate_'size='15' maxlength="20"  value="<%=validFrom%>" onBlur="validateFromDate()"   <%=disabled%>  ><img id = 'fromDate_img' name="fromDate_img"  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fromDate_','dd/mm/yyyy ');" STYLE="display:inline;"><img src='../../eCommon/images/mandatory.gif'><input type='hidden' name='fromDateHid' id='fromDateHid'  id='fromDateHid'  value="<%=validFrom%>" /></td> <!-- Added V190528-Dhananjay/MMS-DM-CRF-130/70571 Removed readonly and added disabled -->	
	</tr>
	<tr>
		<td colspan="5"></td>
	</tr>
	<tr>
		<td class="label" ></td>
		<td class="label" ><fmt:message key="eBL.VALID_TO.label" bundle="${bl_labels}"/></td>
		<td  class='fields' >&nbsp;&nbsp;&nbsp;<input type='text' name='toDate_' id='toDate_'  id='toDate_' size='15' maxlength="20"  value="<%=validTo%>" onBlur="validateToDate()"  ><img id = 'toDate_img' name="toDate_img"	 src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('toDate_','dd/mm/yyyy ');" STYLE="display:inline;">
		<!-- Added V190528-Dhananjay/MMS-DM-CRF-130/70571 Removed readonly -->	
	</tr>
	<tr>
		<td colspan="5"></td>
	</tr>
	<tr>
		<td colspan="5"></td>
	</tr>
	<tr>
		<td colspan="5"></td>
	</tr>

	<tr>
		<td class="label" ></td>
		<td class="label" colspan="15"><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;<select name='applicalbleTo' id='applicalbleTo'	 onChange=""  value="<%=applInd%>">
		<option value='H' <%=applInd.equals("H")?"selected":""%> ><fmt:message key="eBL.HIGHCOSTPKG.label" bundle="${bl_labels}"/></option>
		<option value='L' <%=applInd.equals("L")?"selected":""%>  ><fmt:message key="eBL.LOWCOSTPKG.label" bundle="${bl_labels}"/></option>
		<option value='E' <%=applInd.equals("E")?"selected":""%>  ><fmt:message key="eBL.ALLEXCHIGHCOST.label" bundle="${bl_labels}"/>
		</select>&nbsp;&nbsp;&nbsp;
		<fmt:message key="eBL.MULTIPKGDISC.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;
		<input type='text' name='multipkgdisc' id='multipkgdisc' size='5' maxlength='5'  value="<%=discPerc%>" onBlur='validPercentage(this,"P")' onKeyPress='return(ChkNumberInput(this,event,"2"))'/>%
		</td>
	</tr>
	<tr>
		<td colspan="15"></td>
	</tr>
	<tr>
		<td class='label'></td>
		<td class='label' colspan="15">
		<fmt:message key="eBL.ALLOW.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;
		<input type='checkbox' name='MultiPkgDiscYN' id='MultiPkgDiscYN' value="<%=alwMultiPkgYN%>"   onClick='setCheckValue();' onLoad='setCheckValue();'   <%=alwMultiPkgDiscChkYn%> >&nbsp;&nbsp;&nbsp;
		<fmt:message key="eBL.MULTIPKGDISC.label" bundle="${bl_labels}"/>
		<input type='checkbox' name='PkgCustDiscYN' id='PkgCustDiscYN' value="<%=alwPkgCustYN%>"   onClick='setCheckValue();'  onLoad='setCheckValue();'   <%=alwPkgCustChkYn%> >&nbsp;&nbsp;&nbsp;
		<fmt:message key="eBL.PKGORCUSTDISC.label" bundle="${bl_labels}"/>
		<input type='checkbox' name='PkgAdDiscYN' id='PkgAdDiscYN' value="<%=alwAdhocPkgYN%>"   onClick='setCheckValue();'  onLoad='setCheckValue();'  <%=alwAdhocPkgcheckYN%> >&nbsp;&nbsp;&nbsp;
		<fmt:message key="eBL.PKGADHOCDISC.label" bundle="${bl_labels}"/>
		</td>
		</td>
	</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
</form>
</body>
</html>

