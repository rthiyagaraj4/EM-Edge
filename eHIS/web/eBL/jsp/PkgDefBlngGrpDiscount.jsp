<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page  import="java.util.*, eBL.* ,eBL.Common.*,eCommon.Common.*, eBL.*,java.sql.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>



<html>
<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
		if(parent.blng_grp_discount_dtl_hdr.document.getElementById("tableheader")!=null)
		{		
			parent.blng_grp_discount_dtl_hdr.document.getElementById("tableheader").width =	eval(parent.frames[1].document.getElementById("blng_grp_discount_tbl").offsetWidth);
			for (j=0; j < parent.frames[1].document.getElementById("blng_grp_discount_tbl").rows[1].cells.length; j++) 
			{			
				var  wid=eval(parent.frames[1].document.getElementById("blng_grp_discount_tbl").rows[1].cells[j].offsetWidth);						
				if(parent.blng_grp_discount_dtl_hdr.document.getElementById("tableheader").rows[0].cells[j] != null)
				{
						
				parent.blng_grp_discount_dtl_hdr.document.getElementById("tableheader").rows[0].cells[j].width=wid;	
				parent.frames[1].document.getElementById("blng_grp_discount_tbl").rows[1].cells[6].width='66';					
						
				}
			}
		}			
	}
</script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String locale			= (String)session.getAttribute("LOCALE");
	//String facilityId = (String) session.getValue( "facility_id" ) ;	
	int totalRecords=1;
	
	String packageCode		=	"" ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	String bean_id			= "bl_PkgDefDiscountBean" ;
	String bean_name		= "eBL.PkgDefDiscountBean";
	PkgDefDiscountBean bean			= (PkgDefDiscountBean)getBeanObject( bean_id, bean_name, request ) ;	
	String 		blng_grp_code			="";
	String 	    blng_grp_desc		="";
	String 	    blng_class_code		="";
	String 	    blng_class_desc		="";
	String 	    eff_from_date		="";
	String 	    eff_to_date		="";
	String 	    discount_type		="";
	String 	    discount		="";
	//GHL-CRF-0502 Starts
	Connection con = null;
	HttpSession httpSession = request.getSession(false);
	String facilityId =  (String)httpSession.getValue("facility_id");
	if(facilityId == null) facilityId="";
	String	age_group_code ="";
	String	specialty_code ="";
	String hdn_age_group ="";
	String specialty_desc ="";
	String PkgByPolicy="";//ADDER FOR MMS-QH-CRF-128.1-US-2
	try {
		con = ConnectionManager.getConnection();
			
	//ADDER FOR MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 STARTS
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;		
	String sqlStr="";
	sqlStr="select  pkg_cust_disc_by_policy, pkg_cust_disc_new_pkg  from bl_parameters where OPERATING_FACILITY_ID='"+facilityId+"'";
	pstmt=con.prepareStatement(sqlStr);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
		PkgByPolicy=rs.getString("pkg_cust_disc_by_policy");		
	}	
	//ADDER FOR MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020 ENDS
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	boolean SiteAgeSpecialty = false;
	SiteAgeSpecialty = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AGE_SPECIALITY_APP_FOR_DISC");
	//ADDER FOR MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020
	boolean siteAutoApplyPkgDiscYN = false;
	siteAutoApplyPkgDiscYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_AUTO_APPLY_PKG_DISC_YN");
	//ADDER FOR MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 15/6/2020
	//GHL-CRF-0502 Ends
	String[] record;
	String 	    key		="";
	HashMap blng_grp_discount_dtls    = new HashMap();
	int noofdecimal  = 0;
	noofdecimal  =Integer.parseInt(bean.getNoOfDecimal());	
	blng_grp_discount_dtls    = (HashMap)bean.getBlngGrpDiscountDtls();
	Set<String> dtlSet=(Set<String>)blng_grp_discount_dtls.keySet();
	Iterator<String> iterator=dtlSet.iterator();
	if(blng_grp_discount_dtls.size()>0){
			totalRecords=blng_grp_discount_dtls.size();		
	}
	String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");
	String modifyStatus = "";
	String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");
	if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))
			 modifyStatus = " disabled ";
%>

<form name='blng_grp_discount_dtl' id='blng_grp_discount_dtl'  target='messageFrame' >	
<table class='grid' width='100%' id="blng_grp_discount_tbl">
<tr>
<!--<td class='columnheader' ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td> 
<td class='columnheader' ><fmt:message key="eBL.discountType.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="eBL.Discount.label" bundle="${bl_labels}"/></td>
<td class='columnheader' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>-->
</tr>

<%
int i=0;
if(blng_grp_discount_dtls!=null && blng_grp_discount_dtls.size()>0){
	while(iterator.hasNext()){
		record=new String[12];						
		key=(String)iterator.next();
		record=(String[])blng_grp_discount_dtls.get(key);
		blng_grp_code	= record[0];
		blng_grp_desc	= record[1];
	    blng_class_code	= record[2];
		blng_class_desc	= record[3];
		eff_from_date	= record[4];
		eff_to_date		= record[5];
		discount_type	= record[6];
		discount		= record[7];
		//GHL-CRF-0502 Starts
		age_group_code	= record[8];
		hdn_age_group	= record[9];
		specialty_code	= record[10];
		specialty_desc	= record[11];
		//GHL-CRF-0502 Ends
%>
<tr>
<td class='fields'>
<input type='text' name='blng_grp_code<%=i%>' id='blng_grp_code<%=i%>' value='<%=blng_grp_code%>'	<%=modifyStatus%> <%=(mode.equals("modify") && !blng_grp_code.equals(""))?"readonly":""%> size='10' onBlur="blngGrpCodeLookUp(blng_grp_desc<%=i%>,this,'<%=i%>')"><input type='text' name = 'blng_grp_desc<%=i%>' <%=(mode.equals("modify") && !blng_grp_desc.equals(""))?"readonly":""%>  size='10' maxlength='10' <%=modifyStatus%> onBlur="blngGrpDescLookUp(this,blng_grp_code<%=i%>,'<%=i%>')" value="<%=blng_grp_desc%>"><INPUT type='hidden' name='blng_grp_code_temp<%=i%>' id='blng_grp_code_temp<%=i%>' value='<%=blng_grp_code%>'><INPUT type='hidden' name='blng_grp_desc_temp<%=i%>' id='blng_grp_desc_temp<%=i%>' value='<%=blng_grp_desc%>'><input type='button' name='blng_grp_button<%=i%>' id='blng_grp_button<%=i%>' <%=modifyStatus%> class='button' value='?' <%=(mode.equals("modify") && !blng_grp_code.equals(""))?"disabled":""%> onclick="blngGrpLookUp(blng_grp_desc<%=i%>,blng_grp_code<%=i%>,'<%=i%>')"><input type='hidden' name='oldKey<%=i%>' id='oldKey<%=i%>' value='<%=(blng_grp_code+"~~"+blng_class_code+"~~"+eff_from_date)%>'>
</td>
<td class='fields'>
<input type='text' name='blng_class_code<%=i%>' id='blng_class_code<%=i%>' value='<%=blng_class_code%>' <%=modifyStatus%> size='10'  <%=(mode.equals("modify") && !blng_class_code.equals(""))?"readonly":""%>  onBlur="blngClassCodeLookUp(blng_class_desc<%=i%>,this,'<%=i%>')"><input type='text' name = 'blng_class_desc<%=i%>'  <%=(mode.equals("modify") && !blng_class_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="blngClassDescLookUp(this,blng_class_code<%=i%>,'<%=i%>')" value="<%=blng_class_desc%>"><INPUT type='hidden' name='blng_class_code_temp<%=i%>' id='blng_class_code_temp<%=i%>' value='<%=blng_class_code%>'><INPUT type='hidden' name='blng_class_desc_temp<%=i%>' id='blng_class_desc_temp<%=i%>' value='<%=blng_class_desc%>'><input type='button' name='blng_class_button<%=i%>' id='blng_class_button<%=i%>' <%=modifyStatus%> class='button' value='?' <%=(mode.equals("modify") && !blng_class_code.equals(""))?"disabled":""%> onclick="blngClassLookUp(blng_class_desc<%=i%>,blng_class_code<%=i%>,'<%=i%>')">
</td>

<!-- GHL-CRF-0502 Starts -->
<%
	if(SiteAgeSpecialty){
%>

<td class='fields' nowrap>
	<input type='text' name='age_group_code<%=i%>' id='age_group_code<%=i%>' value='<%=age_group_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !age_group_code.equals(""))?"readonly":""%> onBlur="AgeGrpBLCodeLookUp(hdn_age_group<%=i%>,this,'<%=i%>')"><input type='text' name = 'hdn_age_group<%=i%>' <%=(mode.equals("modify") && !hdn_age_group.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="AgeGrpBLDescLookUp(this,age_group_code<%=i%>,'<%=i%>')" value="<%=hdn_age_group%>"><INPUT type='hidden' name='age_group_temp<%=i%>' id='age_group_temp<%=i%>' value='<%=age_group_code%>'><INPUT type='hidden' name='hdn_age_group_temp<%=i%>' id='hdn_age_group_temp<%=i%>' value='<%=hdn_age_group%>'><input type='button' name='age_button<%=i%>' id='age_button<%=i%>' class='button' <%=(mode.equals("modify") && !age_group_code.equals(""))?"disabled":""%> value='?'	<%=modifyStatus%> onclick="AgeGrpBLLookUp(hdn_age_group<%=i%>,age_group_code<%=i%>,'<%=i%>')">
</td>

<td>	
	<input type='text' name='specialty_code<%=i%>' id='specialty_code<%=i%>' value='<%=specialty_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !specialty_code.equals(""))?"readonly":""%> onBlur="specialtyCodeBLLookUp(specialty_desc<%=i%>,this,'<%=i%>')"><input type='text' name = 'specialty_desc<%=i%>' <%=(mode.equals("modify") && !specialty_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> onBlur="specialtyDescBLLookUp(this,specialty_code<%=i%>,'<%=i%>')" value="<%=specialty_desc%>"><INPUT type='hidden' name='specialty_code_temp<%=i%>' id='specialty_code_temp<%=i%>' value='<%=specialty_code%>'><INPUT type='hidden' name='specialty_desc_temp<%=i%>' id='specialty_desc_temp<%=i%>' value='<%=specialty_desc%>'><input type='button' name='specialty_button<%=i%>' id='specialty_button<%=i%>' class='button' <%=(mode.equals("modify") && !specialty_code.equals(""))?"disabled":""%> value='?'	<%=modifyStatus%> onclick="specialtyBLLookUp(specialty_desc<%=i%>,specialty_code<%=i%>,'<%=i%>')">
</td>
<%
	}
%>
<!-- GHL-CRF-0502 Ends -->

<td  class='fields' >
	<input type='text' name='eff_from_date<%=i%>' id='eff_from_date<%=i%>'	<%=modifyStatus%> id='eff_from_date<%=i%>' <%=(mode.equals("modify") && !eff_from_date.equals(""))?"readonly":""%> size='10' maxlength="10"  value="<%=eff_from_date%>"   onBlur="validateDiscountDate(this,this,eff_to_date<%=i%>,'<%=i%>');"><img id = 'eff_from_date_img_<%=i%>' name="eff_from_date_img_<%=i%>"   <%=modifyStatus%>	<%=(mode.equals("modify") && !eff_from_date.equals(""))?"disabled":""%>   src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_from_date<%=i%>');"  /></td>

<td  class='fields' >
	<input type='text' name='eff_to_date<%=i%>' id='eff_to_date<%=i%>' <%=modifyStatus%> id='eff_to_date<%=i%>' size='10' maxlength="10"  value="<%=eff_to_date%>" <%=(mode.equals("modify") && !eff_to_date.equals(""))?"readonly":""%> onBlur="validateDiscountDate(this,eff_from_date<%=i%>,this,'<%=i%>');" ><img id = 'eff_to_Date_img_<%=i%>' name="eff_to_Date_img_<%=i%>"  <%=modifyStatus%>	src="../../eCommon/images/CommonCalendar.gif" <%=(mode.equals("modify") && !eff_to_date.equals(""))?"disabled":""%> onClick="return showCalendar('eff_to_date<%=i%>');" >
</td>

<td  class='fields' >
<select name='discount_type<%=i%>' id='discount_type<%=i%>' onChange="chkDisountType(this,'<%=i%>')" <%=modifyStatus%>>
<option value='R' <%=discount_type.equals("R")?"selected":""%>><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
<option value='A' <%=discount_type.equals("A")?"selected":""%>><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
</select>
</td>

<td>
	<input type='text' name='discount<%=i%>' id='discount<%=i%>'   size='5' <%=modifyStatus%> onBlur='chkDiscountAmt(this,"<%=i%>");' onKeyPress='return ChkNumberInput(this,event,"<%=noofdecimal%>")'; value="<%=discount%>"/>
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
<td class='fields'>
<input type='text' name='blng_grp_code0' id='blng_grp_code0' value='' size='10'	<%=modifyStatus%> onBlur="blngGrpCodeLookUp(blng_grp_desc0,this,'0')"><input type='text' name = 'blng_grp_desc0' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="blngGrpDescLookUp(this,blng_grp_code0,'0')" value=""><INPUT type='hidden' name='blng_grp_code_temp0' id='blng_grp_code_temp0' value=''><INPUT type='hidden' name='blng_grp_desc_temp0' id='blng_grp_desc_temp0' value=''><input type='button' name='blng_grp_button0' id='blng_grp_button0' class='button' value='?'	<%=modifyStatus%> onclick="blngGrpLookUp(blng_grp_desc0,blng_grp_code0,'0')"><input type='hidden' name='oldKey0' id='oldKey0' value=''>
</td>
<td class='fields'>
<input type='text' name='blng_class_code0' id='blng_class_code0' value='' size='10'	   <%=modifyStatus%> onBlur="blngClassCodeLookUp(blng_class_desc0,this,'0')"><input type='text' name = 'blng_class_desc0' size='10' maxlength='10'	  <%=modifyStatus%> onBlur="blngClassDescLookUp(this,blng_class_code0,'0')" value=""><INPUT type='hidden' name='blng_class_code_temp0' id='blng_class_code_temp0' value=''><INPUT type='hidden' name='blng_class_desc_temp0' id='blng_class_desc_temp0' value=''><input type='button' name='blng_class_button0' id='blng_class_button0' class='button' value='?'	  <%=modifyStatus%> onclick="blngClassLookUp(blng_class_desc0,blng_class_code0,'0')">
</td>

<!-- GHL-CRF-0502 Starts -->
<%
	if(SiteAgeSpecialty){
%>
<td class='fields' nowrap>
	<input type='text' name='age_group_code0' id='age_group_code0' value='' size='10'	 <%=modifyStatus%> onBlur="AgeGrpBLCodeLookUp(hdn_age_group0,this,'0')"><input type='text' name = 'hdn_age_group0' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="AgeGrpBLDescLookUp(this,age_group_code0,'0')" value=""><INPUT type='hidden' name='age_group_temp0' id='age_group_temp0' value=''><INPUT type='hidden' name='hdn_age_group_temp0' id='hdn_age_group_temp0' value=''><input type='button' name='age_button0' id='age_button0' class='button' value='?'	<%=modifyStatus%> onclick="AgeGrpBLLookUp(hdn_age_group0,age_group_code0,'0')">	
</td>

<td>
	<input type='text' name='specialty_code0' id='specialty_code0' value='' size='10'	 <%=modifyStatus%> onBlur="specialtyCodeBLLookUp(specialty_desc0,this,'0')"><input type='text' name = 'specialty_desc0' size='10' maxlength='10'	 <%=modifyStatus%> onBlur="specialtyDescBLLookUp(this,specialty_code0,'0')" value=""><INPUT type='hidden' name='specialty_code_temp0' id='specialty_code_temp0' value=''><INPUT type='hidden' name='specialty_desc_temp0' id='specialty_desc_temp0' value=''><input type='button' name='specialty_code_button_0' id='specialty_code_button_0' class='button' value='?'	<%=modifyStatus%> onclick="specialtyBLLookUp(specialty_desc0,specialty_code0,'0')">
</td>
<%
	}
%>
<!-- GHL-CRF-0502 Ends -->

<td  class='fields' >
	<input type='text' name='eff_from_date0' id='eff_from_date0'	<%=modifyStatus%> id='eff_from_date0'size='10' maxlength="10"  value=""   onBlur="validateDiscountDate(this,this,eff_to_date0,'0');">
	<img id = 'eff_from_date_img_0' name="eff_from_date_img_0" <%=modifyStatus%>	  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_from_date0');"  />
</td>

<td  class='fields' >
	<input type='text' name='eff_to_date0' id='eff_to_date0'  id='eff_to_date0' size='10' maxlength="10"  value=""   <%=modifyStatus%> onBlur="validateDiscountDate(this,eff_from_date0,this,'0');" ><img id = 'eff_to_Date_img_0' name="eff_to_Date_img_0"   <%=modifyStatus%>	src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_to_date0');" >
</td>

<td  class='fields' >
<select name='discount_type0' id='discount_type0' onChange="chkDisountType(this,'0')" <%=modifyStatus%> >
<option value='R' selected><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
<option value='A' ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
</select>
</td>

<td>
	<input type='text' name='discount0' id='discount0'   size='5'	<%=modifyStatus%> onBlur='chkDiscountAmt(this,"0");' onKeyPress='return ChkNumberInput(this,event,"<%=noofdecimal%>")'; value=""/>
</td>

<td align="left" nowrap>
	<input type='checkbox'  name='deleteDiscount0' id='deleteDiscount0'	  <%=modifyStatus%> onClick='chkDeleteDiscount(this,"0")' value="N"/>
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
	<input type='hidden' name='SiteAgeSpecialty' id='SiteAgeSpecialty' value='<%=SiteAgeSpecialty%>'>
	<input type='hidden' name='siteAutoApplyPkgDiscYN' id='siteAutoApplyPkgDiscYN' value='<%=siteAutoApplyPkgDiscYN%>'>
	<input type='hidden' name='PkgByPolicy' id='PkgByPolicy' value='<%=PkgByPolicy%>'>
</form>
<script>alignHeading();</script>
</body>
	<%putObjectInBean(bean_id,bean,request);%>
</html>

