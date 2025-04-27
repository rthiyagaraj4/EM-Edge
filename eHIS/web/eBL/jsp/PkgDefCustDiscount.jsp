<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*, webbeans.eCommon.*,eCommon.Common.*, eBL.*,java.sql.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%!
	private String checkForNull(String inputString) {
			return (inputString == null) ? "" : inputString;
		}
%>
<%
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDef.js"></script>
	<script language="javascript" src="../../eBL/js/PkgDefDiscount.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function alignHeading()
	{	
		if(parent.cust_discount_dtl_hdr.document.getElementById("tableheader")!=null)
		{		
			parent.cust_discount_dtl_hdr.document.getElementById("tableheader").width =	eval(parent.frames[1].document.getElementById("cust_discount_tbl").offsetWidth);
		for (j=0; j < parent.frames[1].document.getElementById("cust_discount_tbl").rows[1].cells.length; j++) 
		{			
			var  wid=eval(parent.frames[1].document.getElementById("cust_discount_tbl").rows[1].cells[j].offsetWidth);	
		if(parent.cust_discount_dtl_hdr.document.getElementById("tableheader").rows[0].cells[j] != null)
		{
			parent.cust_discount_dtl_hdr.document.getElementById("tableheader").rows[0].cells[j].width=wid;	
			parent.frames[1].document.getElementById("cust_discount_tbl").rows[1].cells[7].width='66';
		}
		}
		}
	}
</script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	String mode		= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String locale		= (String)session.getAttribute("LOCALE");
	int totalRecords=1;	
	String packageCode		=	"" ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	String bean_id			= "bl_PkgDefDiscountBean" ;
	String bean_name		= "eBL.PkgDefDiscountBean";
	PkgDefDiscountBean bean			= (PkgDefDiscountBean)getBeanObject( bean_id, bean_name, request ) ;	
	String 	cust_grp_code	="";
	String 	cust_grp_desc	="";
	String 	cust_code		="";
	String 	cust_desc		="";
	String 	blng_class_code	="";
	String 	blng_class_desc	="";
	String 	eff_from_date	="";
	String 	eff_to_date		="";
	String 	discount_type	="";
	String 	discount		="";
	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 
	String  poly_code        ="";  
	String  poly_desc        ="";  
	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 
	//GHL-CRF-0502 Starts
	Connection con = null;
	HttpSession httpSession = request.getSession(false);
	String facilityId =  (String)httpSession.getValue("facility_id");
	if(facilityId == null) facilityId="";
	String age_group_code ="";
	String specialty_code ="";
	String hdn_age_group ="";
	String specialty_desc ="";
	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 
	String PkgByPolicy="";
	String newPkg="";
	//ADDER FOR MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 
	try {
		con = ConnectionManager.getConnection();
	
		boolean SiteAgeSpecialty = false;
		SiteAgeSpecialty = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AGE_SPECIALITY_APP_FOR_DISC");
		boolean siteAutoApplyPkgDiscYN = false;
		siteAutoApplyPkgDiscYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_AUTO_APPLY_PKG_DISC_YN");
		
		//GHL-CRF-0502 Ends
		String[] record;
		String 	key		="";
		HashMap cust_discount_dtls    = new HashMap();
		int noofdecimal  = 0;
		noofdecimal  =Integer.parseInt(bean.getNoOfDecimal());	
		cust_discount_dtls    = (HashMap)bean.getCustDiscountDtls();
		Set<String> dtlSet=(Set<String>)cust_discount_dtls.keySet();
		Iterator<String> iterator=dtlSet.iterator();
		if(cust_discount_dtls.size()>0){
			totalRecords=cust_discount_dtls.size();		
		}
		String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
		String modifyStatus = "";
		String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
		if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
				 modifyStatus = " disabled ";
		//ADDER FOR MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 STARTS-->
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;		
		String sqlStr="";

		sqlStr="select pkg_cust_disc_by_policy, pkg_cust_disc_new_pkg  from bl_parameters where OPERATING_FACILITY_ID='"+facilityId+"'" ;
		//sqlStr="select  pkg_cust_disc_by_policy, pkg_cust_disc_new_pkg  from bl_parameters" ;
		pstmt=con.prepareStatement(sqlStr);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			PkgByPolicy=rs.getString("pkg_cust_disc_by_policy");
			newPkg=rs.getString("pkg_cust_disc_new_pkg");
		}	
		//ADDER FOR MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 ENDS-->
%>

<form name='cust_discount_dtl' id='cust_discount_dtl'  target='messageFrame' >	
<table class='grid' width='100%' id="cust_discount_tbl">
<tr>
	<!--<td class='columnheader' ><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></td> 
	<td class='columnheader' ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' > <fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' > <fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' > <fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' ><fmt:message key="eBL.discountType.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' ><fmt:message key="eBL.Discount.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>-->

</tr>

<%
	int i=0;
	if(cust_discount_dtls!=null && cust_discount_dtls.size()>0){
	while(iterator.hasNext()){
		record=new String[16];//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 						
		key=(String)iterator.next();
		record	= (String[])cust_discount_dtls.get(key);
		cust_grp_code	= record[0];
		cust_grp_desc	= record[1];
		cust_code		= record[2];
		cust_desc		= record[3];
	    	blng_class_code	= record[4];
		blng_class_desc	= record[5];
		eff_from_date	= record[6];
		eff_to_date		= record[7];
		discount_type	= record[8];
		discount		= record[9];		
		//GHL-CRF-0502 Starts
		age_group_code	= record[10];
		hdn_age_group	= record[11];
		specialty_code	= record[12];		
		specialty_desc	= record[13];		
		//GHL-CRF-0502 Ends
		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 
		poly_code		= record[14];
		poly_desc		= record[15];
		//ADDER FOR MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 
	
%>
<tr>
<td>
	<input type='text' name='cust_grp_code<%=i%>' id='cust_grp_code<%=i%>' value='<%=cust_grp_code%>' <%=modifyStatus%> size='10' <%=(mode.equals("modify") && !cust_grp_code.equals(""))?"readonly":""%> onBlur="custGrpCodeDisLookUp(cust_grp_desc<%=i%>,this,'<%=i%>')"><input type='text' name = 'cust_grp_desc<%=i%>' <%=(mode.equals("modify") && !cust_grp_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="custGrpDescDisLookUp(this,cust_grp_code<%=i%>,'<%=i%>')" value="<%=cust_grp_desc%>"><INPUT type='hidden' name='cust_grp_code_temp<%=i%>' id='cust_grp_code_temp<%=i%>' value='<%=cust_grp_code%>'><INPUT type='hidden' name='cust_grp_desc_temp<%=i%>' id='cust_grp_desc_temp<%=i%>' value='<%=cust_grp_desc%>'><input type='button' name='cust_grp_button<%=i%>' id='cust_grp_button<%=i%>' <%=modifyStatus%> class='button' value='?' <%=(mode.equals("modify") && !cust_grp_code.equals(""))?"disabled":""%> onclick="custGrpDisLookUp(cust_grp_desc<%=i%>,cust_grp_code<%=i%>,'<%=i%>')"><input type='hidden' name='oldKey<%=i%>' id='oldKey<%=i%>' value='<%=(cust_grp_code+"~~"+cust_code+"~~"+blng_class_code+"~~"+eff_from_date)%>'>
</td>

<td>		
	<input type='text' name='cust_code<%=i%>' id='cust_code<%=i%>' value='<%=cust_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !cust_code.equals(""))?"readonly":""%> onBlur="custCodeDisLookUp(cust_desc<%=i%>,this,cust_grp_code<%=i%>,'<%=i%>')"><input type='text' name = 'cust_desc<%=i%>' <%=(mode.equals("modify") && !cust_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="custDescDisLookUp(this,cust_code<%=i%>,cust_grp_code<%=i%>,'<%=i%>')" value="<%=cust_desc%>"><INPUT type='hidden' name='cust_code_temp<%=i%>' id='cust_code_temp<%=i%>' value='<%=cust_code%>'><INPUT type='hidden' name='cust_desc_temp<%=i%>' id='cust_desc_temp<%=i%>' value='<%=cust_desc%>'><input type='button' name='cust_button<%=i%>' id='cust_button<%=i%>' class='button' <%=(mode.equals("modify") && !cust_code.equals(""))?"disabled":""%> value='?'	<%=modifyStatus%> onclick="custDisLookUp(cust_desc<%=i%>,cust_code<%=i%>,cust_grp_code<%=i%>,'<%=i%>')">
</td>
<!-- MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS -->
<% if(siteAutoApplyPkgDiscYN){
 if("Y".equals(PkgByPolicy)){%>
<td>
	<input type='text' name='poly_code<%=i%>' id='poly_code<%=i%>' value='<%=poly_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !poly_code.equals(""))?"readonly":""%> onBlur="polyCodeDisLookUp(poly_desc<%=i%>,this,'<%=i%>')"><input type='text' name = 'poly_desc<%=i%>' <%=(mode.equals("modify") && !poly_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="polyDescDisLookUp(this,poly_code<%=i%>,cust_grp_code<%=i%>,'<%=i%>')" value="<%=poly_desc%>"><INPUT type='hidden' name='poly_code_temp<%=i%>' id='poly_code_temp<%=i%>' value='<%=poly_code%>'><INPUT type='hidden' name='poly_desc_temp<%=i%>' id='poly_desc_temp<%=i%>' value='<%=poly_desc%>'><input type='button' name='poly_button<%=i%>' id='poly_button<%=i%>' class='button' <%=(mode.equals("modify") && !cust_code.equals(""))?"disabled":""%> value='?'	<%=modifyStatus%> onclick="custpolyDisLookUp(poly_desc<%=i%>,poly_code<%=i%>,cust_grp_code<%=i%>,'<%=i%>')">
</td>
<%}}%>
<!-- MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS -->
<td>
	<input type='text' name='blng_class_code<%=i%>' id='blng_class_code<%=i%>' value='<%=blng_class_code%>' <%=modifyStatus%> size='10' <%=(mode.equals("modify") && !blng_class_code.equals(""))?"readonly":""%> onBlur="custBlngClassCodeLookUp(blng_class_desc<%=i%>,this,'<%=i%>')"><input type='text' name = 'blng_class_desc<%=i%>' <%=(mode.equals("modify") && !blng_class_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="custBlngClassDescLookUp(this,blng_class_code<%=i%>,'<%=i%>')" value="<%=blng_class_desc%>"><INPUT type='hidden' name='blng_class_code_temp<%=i%>' id='blng_class_code_temp<%=i%>' value='<%=blng_class_code%>'><INPUT type='hidden' name='blng_class_desc_temp<%=i%>' id='blng_class_desc_temp<%=i%>' value='<%=blng_class_desc%>'><input type='button' name='blng_class_button<%=i%>' id='blng_class_button<%=i%>' <%=(mode.equals("modify") && !blng_class_code.equals(""))?"disabled":""%> class='button' value='?'  <%=modifyStatus%> onclick="custBlngClassLookUp(blng_class_desc<%=i%>,blng_class_code<%=i%>,'<%=i%>')">
</td>

<!-- GHL-CRF-0502 Starts -->
<%
	if(SiteAgeSpecialty){
%>
<td class='fields' nowrap>
	<input type='text' name='age_group_code<%=i%>' id='age_group_code<%=i%>' value='<%=age_group_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !age_group_code.equals(""))?"readonly":""%> onBlur="AgeGroupCodeLookUp(hdn_age_group<%=i%>,this,'<%=i%>')"><input type='text' name = 'hdn_age_group<%=i%>' <%=(mode.equals("modify") && !hdn_age_group.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="AgeGroupDescLookUp(this,age_group_code<%=i%>,'<%=i%>')" value="<%=hdn_age_group%>"><INPUT type='hidden' name='age_group_temp<%=i%>' id='age_group_temp<%=i%>' value='<%=age_group_code%>'><INPUT type='hidden' name='hdn_age_group_temp<%=i%>' id='hdn_age_group_temp<%=i%>' value='<%=hdn_age_group%>'><input type='button' name='age_button<%=i%>' id='age_button<%=i%>' class='button' <%=(mode.equals("modify") && !age_group_code.equals(""))?"disabled":""%> value='?'	<%=modifyStatus%> onclick="AgeGroupLookUp(hdn_age_group<%=i%>,age_group_code<%=i%>,'<%=i%>')">
</td>

<td>	
	<input type='text' name='specialty_code<%=i%>' id='specialty_code<%=i%>' value='<%=specialty_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !specialty_code.equals(""))?"readonly":""%> onBlur="specialtyCodeLookUp(specialty_desc<%=i%>,this,'<%=i%>')"><input type='text' name = 'specialty_desc<%=i%>' <%=(mode.equals("modify") && !specialty_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="specialtyDescLookUp(this,specialty_code<%=i%>,'<%=i%>')" value="<%=specialty_desc%>"><INPUT type='hidden' name='specialty_code_temp<%=i%>' id='specialty_code_temp<%=i%>' value='<%=specialty_code%>'><INPUT type='hidden' name='specialty_desc_temp<%=i%>' id='specialty_desc_temp<%=i%>' value='<%=specialty_desc%>'><input type='button' name='specialty_button<%=i%>' id='specialty_button<%=i%>' class='button' <%=(mode.equals("modify") && !specialty_code.equals(""))?"disabled":""%> value='?'	<%=modifyStatus%> onclick="specialtyLookUp(specialty_desc<%=i%>,specialty_code<%=i%>,'<%=i%>')">
</td>
<%
	}
%>
<!-- GHL-CRF-0502 Ends -->

<td  class='fields' >
	<input type='text' name='eff_from_date<%=i%>' id='eff_from_date<%=i%>'	 <%=modifyStatus%> id='eff_from_date<%=i%>' <%=(mode.equals("modify") && !eff_from_date.equals(""))?"readonly":""%> size='10' maxlength="10"  value="<%=eff_from_date%>"   onBlur="validateDiscountDate(this,this,eff_to_date<%=i%>,'<%=i%>');"><img id = 'eff_from_date_img_<%=i%>' name="eff_from_date_img_<%=i%>" <%=modifyStatus%>	<%=(mode.equals("modify") && !eff_from_date.equals(""))?"disabled":""%>   src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_from_date<%=i%>');"  />
</td>

<td  class='fields' >
	<input type='text' name='eff_to_date<%=i%>' id='eff_to_date<%=i%>'  <%=modifyStatus%> id='eff_to_date<%=i%>' size='10' maxlength="10"  value="<%=eff_to_date%>" <%=(mode.equals("modify") && !eff_to_date.equals(""))?"readonly":""%> onBlur="validateDiscountDate(this,eff_from_date<%=i%>,this,'<%=i%>');" ><img id = 'eff_to_Date_img_<%=i%>' name="eff_to_Date_img_<%=i%>"	<%=modifyStatus%>	src="../../eCommon/images/CommonCalendar.gif" <%=(mode.equals("modify") && !eff_to_date.equals(""))?"disabled":""%> onClick="return showCalendar('eff_to_date<%=i%>');" >
</td>

<td  class='fields' >
	<select name='discount_type<%=i%>' id='discount_type<%=i%>' onChange="chkDisountType(this,'<%=i%>')" <%=modifyStatus%> >
	<option value='R' <%=discount_type.equals("R")?"selected":""%>>
		<fmt:message key="Common.Percent.label" bundle="${common_labels}"/>
	</option>
	<option value='A' <%=discount_type.equals("A")?"selected":""%>><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
</select>
</td>

<td>
	<input type='text' name='discount<%=i%>' id='discount<%=i%>'   size='5'  <%=modifyStatus%> onBlur='chkDiscountAmt(this,"<%=i%>");'  onKeyPress='return ChkNumberInput(this,event,"<%=noofdecimal%>");' value="<%=discount%>"/>
</td>

<td align="left" nowrap>
	<input type='checkbox'  name='deleteDiscount<%=i%>' id='deleteDiscount<%=i%>' disabled onClick='chkDeleteDiscount(this,"<%=i%>")' value="N"/>
</td>

</tr>
<%
i++;
}
}else{%>
<tr>
<td>
	<input type='text' name='cust_grp_code0' id='cust_grp_code0' value='' size='10'  <%=modifyStatus%> onBlur="custGrpCodeDisLookUp(cust_grp_desc0,this,'0')"><input type='text' name = 'cust_grp_desc0' size='10' maxlength='10'	<%=modifyStatus%> onBlur="custGrpDescDisLookUp(this,cust_grp_code0,'0')" value=""><INPUT type='hidden' name='cust_grp_code_temp0' id='cust_grp_code_temp0' value=''><INPUT type='hidden' name='cust_grp_desc_temp0' id='cust_grp_desc_temp0' value=''><input type='button' name='cust_grp_button0' id='cust_grp_button0' class='button' value='?'  <%=modifyStatus%> onclick="custGrpDisLookUp(cust_grp_desc0,cust_grp_code0,'0')"><input type='hidden' name='oldKey0' id='oldKey0' value=''>
</td>

<td>		
	<input type='text' name='cust_code0' id='cust_code0' value='' size='10'	 <%=modifyStatus%> onBlur="custCodeDisLookUp(cust_desc0,this,cust_grp_code0,'0')"><input type='text' name = 'cust_desc0' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="custDescDisLookUp(this,cust_code0,cust_grp_code0,'0')" value=""><INPUT type='hidden' name='cust_code_temp0' id='cust_code_temp0' value=''><INPUT type='hidden' name='cust_desc_temp0' id='cust_desc_temp0' value=''><input type='button' name='cust_button0' id='cust_button0' class='button' value='?'	 <%=modifyStatus%> onclick="custDisLookUp(cust_desc0,cust_code0,cust_grp_code0,'0')">
</td>
<!-- MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS -->
<% if(siteAutoApplyPkgDiscYN){
 if("Y".equals(PkgByPolicy)){%>
<td>

	<input type='text' name='poly_code<%=i%>' id='poly_code<%=i%>' value='<%=poly_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !poly_code.equals(""))?"readonly":""%> onBlur="polyCodeDisLookUp(poly_desc<%=i%>,this,'<%=i%>')"><input type='text' name = 'poly_desc<%=i%>' <%=(mode.equals("modify") && !poly_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="polyDescDisLookUp(this,poly_code<%=i%>,cust_grp_code<%=i%>,'<%=i%>')" value="<%=poly_desc%>"><INPUT type='hidden' name='poly_code_temp<%=i%>' id='poly_code_temp<%=i%>' value='<%=poly_code%>'><INPUT type='hidden' name='poly_desc_temp<%=i%>' id='poly_desc_temp<%=i%>' value='<%=poly_desc%>'><input type='button' name='poly_button<%=i%>' id='poly_button<%=i%>' class='button' <%=(mode.equals("modify") && !cust_code.equals(""))?"disabled":""%> value='?'	<%=modifyStatus%> onclick="custpolyDisLookUp(poly_desc<%=i%>,poly_code<%=i%>,cust_grp_code<%=i%>,'<%=i%>')">
</td>
<%}} %>

<!-- MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS -->
<td>
	<input type='text' name='blng_class_code0' id='blng_class_code0' value='' size='10'	 <%=modifyStatus%> onBlur="custBlngClassCodeLookUp(blng_class_desc0,this,'0')"><input type='text' name = 'blng_class_desc0' size='10' maxlength='10'	   <%=modifyStatus%> onBlur="custBlngClassDescLookUp(this,blng_class_code0,'0')" value=""><INPUT type='hidden' name='blng_class_code_temp0' id='blng_class_code_temp0' value=''><INPUT type='hidden' name='blng_class_desc_temp0' id='blng_class_desc_temp0' value=''><input type='button' name='blng_class_button0' id='blng_class_button0' class='button' value='?'	  <%=modifyStatus%> onclick="custBlngClassLookUp(blng_class_desc0,blng_class_code0,'0')">
</td>

<!-- GHL-CRF-0502 Starts -->
<%
	if(SiteAgeSpecialty){
%>
<td class='fields' nowrap>

	<input type='text' name='age_group_code0' id='age_group_code0' value='' size='10'	 <%=modifyStatus%> onBlur="AgeGroupCodeLookUp(hdn_age_group0,this,'0')"><input type='text' name = 'hdn_age_group0' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="AgeGroupDescLookUp(this,age_group_code0,'0')" value=""><INPUT type='hidden' name='age_group_temp0' id='age_group_temp0' value=''><INPUT type='hidden' name='hdn_age_group_temp0' id='hdn_age_group_temp0' value=''><input type='button' name='age_button0' id='age_button0' class='button' value='?'	<%=modifyStatus%> onclick="AgeGroupLookUp(hdn_age_group0,age_group_code0,'0')">	
</td>

<td>

	<input type='text' name='specialty_code0' id='specialty_code0' value='' size='10'	 <%=modifyStatus%> onBlur="specialtyCodeLookUp(specialty_desc0,this,'0')"><input type='text' name = 'specialty_desc0' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="specialtyDescLookUp(this,specialty_code0,'0')" value=""><INPUT type='hidden' name='specialty_code_temp0' id='specialty_code_temp0' value=''><INPUT type='hidden' name='specialty_desc_temp0' id='specialty_desc_temp0' value=''><input type='button' name='specialty_code_button_0' id='specialty_code_button_0' class='button' value='?'	<%=modifyStatus%> onclick="specialtyLookUp(specialty_desc0,specialty_code0,'0')">
</td>
<%
	}
%>
<!-- GHL-CRF-0502 Ends -->

<td  class='fields' >
	<input type='text' name='eff_from_date0' id='eff_from_date0' id='eff_from_date0'  size='10' maxlength="10"  value=""  <%=modifyStatus%> onBlur="validateDiscountDate(this,this,eff_to_date0,'0');"><img id = 'eff_from_date_img_0' name="eff_from_date_img_0"	<%=modifyStatus%> src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_from_date0');"  />
</td>

<td  class='fields' >
	<input type='text' name='eff_to_date0' id='eff_to_date0'  id='eff_to_date0'	<%=modifyStatus%> size='10' maxlength="10"  value="" onBlur="validateDiscountDate(this,eff_from_date0,this,'0');" ><img id = 'eff_to_Date_img_0' name="eff_to_Date_img_0"   <%=modifyStatus%>	src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('eff_to_date0');" >
</td>

<td  class='fields' >
	<select name='discount_type0' id='discount_type0' onChange="chkDisountType(this,'0')" <%=modifyStatus%>>
	<option value='R' >
		<fmt:message key="Common.Percent.label" bundle="${common_labels}"/>
	</option>
	<option value='A' >
		<fmt:message key="Common.amount.label" bundle="${common_labels}"/>
	</option>
	</select>
</td>

<td>
	<input type='text' name='discount0' id='discount0'   size='5'	 <%=modifyStatus%> onBlur='chkDiscountAmt(this,"0");' onKeyPress='return ChkNumberInput(this,event,"<%=noofdecimal%>");' value=""/>
</td>

<td align="left" nowrap>
	<input type='checkbox'  name='deleteDiscount0' id='deleteDiscount0'	   <%=modifyStatus%> onClick='chkDeleteDiscount(this,"0")' value="N"/>
</td>
</tr>
<%}%>
 </table>
	<INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityId%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
	<input type="hidden" name="noofdecimal" id="noofdecimal" value="<%=noofdecimal%>">
	<input type="hidden" name="SiteAgeSpecialty" id="SiteAgeSpecialty" value="<%=SiteAgeSpecialty%>">
	<!-- MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 STARTS -->
	<input type="hidden" name="PkgByPolicy" id="PkgByPolicy" value="<%=PkgByPolicy%>">
	<input type="hidden" name="newPkg" id="newPkg" value="<%=newPkg%>">
	<input type="hidden" name="siteAutoApplyPkgDiscYN" id="siteAutoApplyPkgDiscYN" value="<%=siteAutoApplyPkgDiscYN%>">
	<!-- MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 ENDS -->
 </form>
 <%
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	finally
	{
		if(con!=null) con.close();
	}
%>
<SCRIPT>setTimeout('alignHeading()',100);
//alignHeading();</SCRIPT>
 </body>
  <%putObjectInBean(bean_id,bean,request);%>
</html>

