<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="webbeans.eCommon.ConnectionManager,webbeans.eCommon.*"%>
<%@page import="java.sql.*, eBL.*, eBL.Common.*, java.io.*, eCommon.Common.*,java.util.*, com.ehis.util.*, java.text.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

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
	<script language="javascript" src="../../eBL/js/pkgActiveDis.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

<% 
	
	Connection conn		= null;		
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;		
	String sqlStr="";
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String language_id = (String) session.getValue("LOCALE");
	String loginuser 	= (String) session.getValue( "login_user" ) ;
    	int start=0;
	int end=0;
	int i=1;
	String endOfRes="1";
	int count=0;
	boolean flage=true;
	int noofdecimal  = 0;
	String from 			= request.getParameter("from") ; 
	String to 				= request.getParameter("to") ;
	//String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	  // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1
	String mode				= "modify";
	
	int totalRecords=1;	
	String packageCode		=	"" ;
	//String blngGrpCode		=	"" ;
	String custCode			=	"" ;
	String ppGrpCode		=	"" ;
	String eff_from_date	=	"" ;
	String 	eff_to_date		="";//20/8/2020
	String 	blng_class_code	="";	// 20/8/2020
	String 	cust_grp_code	="";//23/09/2020
    	//ADDED AGAINST THE INC ON:73403 MMS-QH-128.1
	cust_grp_code		=	request.getParameter("custGrpCode") == null ? "" :request.getParameter("custGrpCode") ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	blng_class_code		=	request.getParameter("blng_class_code") == null ? "" :request.getParameter("blng_class_code") ; // 20/8/2020
	custCode		=	request.getParameter("custCode") == null ? "" :request.getParameter("custCode") ;
	ppGrpCode		=	request.getParameter("ppGrpCode") == null ? "" :request.getParameter("ppGrpCode") ;
	eff_from_date	=	request.getParameter("eff_from_date") == null ? "" :request.getParameter("eff_from_date") ;// 20/8/2020
	eff_to_date	=	request.getParameter("eff_to_date") == null ? "" :request.getParameter("eff_to_date") ;//20/8/2020
	
	String age_group_code ="";
	String specialty_code ="";
	String hdn_age_group ="";
	String specialty_desc ="";
	String[] record;
	
	String 	cust_grp_desc	="";
	String 	cust_code		="";
	String 	cust_desc		="";
	String 	blng_class_desc	="";
	
	String 	discount_type	="";
	String 	discount		="";
	String  poly_code        ="";
	String  poly_desc        =""; 
	String  pkg_code        ="";
	String  pkg_desc        =""; 
	Connection con = null;
	
	HttpSession httpSession = request.getSession(false);
	String facility_id =  (String)httpSession.getValue("facility_id");
	if(facility_id == null) facility_id="";
	String modifyStatus = "";//73392
	//String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");//73392
	//String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");//73392
	//if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))//73392
	modifyStatus = " disabled ";

	if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from ) ;

        if ( to == null )
            end = 16 ;
        else
            end = Integer.parseInt( to ) ;
        try{
	//28-08-2020 start
		conn = ConnectionManager.getConnection(request);
	if(cust_grp_code.equals("") || cust_grp_code.equals("null"))
	{
		sqlStr=" SELECT  a.package_code,a.cust_group_code cust_grp_code,DECODE (a.cust_group_code, '**', 'All Groups', c.short_desc ) cust_grp_desc, a.cust_code cust_code,DECODE (a.cust_code, '**', 'All Customers', b.short_name) cust_desc, a.blng_class_code blng_class_code, DECODE (a.blng_class_code, '**', 'All Billing Classes', d.short_desc ) blng_class_desc,a.age_group, a.speciality_code,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date,a.discount_type discount_type, a.discount discount,DECODE (a.age_group,'**', 'All Age Group',e.short_desc) age_group_desc,DECODE (a.speciality_code,'**', 'All Specialty',f.short_desc ) speciality_desc,g.package_code package_code, g.short_desc package_short_desc,a.policy_type_code policy_type_code,DECODE (a.policy_type_code,'**', 'All Policies',h.short_desc) policy_short_desc FROM bl_package_cust_discount a,ar_customer_lang_vw b,ar_cust_group_lang_vw c,bl_blng_class_lang_vw d, bl_age_group e,am_speciality f,bl_package g,bl_ins_policy_types h WHERE a.package_code = DECODE (?, '**', a.package_code, ?) AND a.operating_facility_id = ?  and a.cust_code = DECODE (?, '**', a.cust_code, ?) AND a.policy_type_code = DECODE (?, '**', a.policy_type_code, ?) AND a.blng_class_code = DECODE (?, '**', a.blng_class_code,?) AND ( ( a.eff_to_date IS NULL AND ? IS NULL AND a.eff_from_date >= TO_DATE (?, 'dd/mm/yyyy'))OR ( a.eff_to_date IS NOT NULL AND a.eff_from_date >= TO_DATE (?, 'dd/mm/yyyy') AND( ( ? IS NOT NULL AND a.eff_to_date <= TO_DATE (?, 'dd/mm/yyyy')) OR (? IS NULL AND a.eff_to_date >= TO_DATE (NVL (?, SYSDATE), 'dd/mm/yyyy')))  )) and   a.cust_group_code = c.cust_group_code(+) AND a.cust_code = b.cust_code(+) AND a.blng_class_code = d.blng_class_code(+) AND b.language_id(+) = ? AND c.language_id(+) =? AND d.language_id(+) = ? AND a.age_group = e.age_group_code(+) AND a.speciality_code = f.speciality_code(+) AND a.package_code = g.package_code AND h.operating_facility_id(+) = a.operating_facility_id AND h.policy_type_code(+) = a.policy_type_code";
		pstmt=conn.prepareStatement(sqlStr);	
		pstmt.setString(1,packageCode);			
		pstmt.setString(2,packageCode);
		pstmt.setString(3,facility_id);     // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(4,custCode);    // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(5,custCode); 
		pstmt.setString(6,ppGrpCode);   // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(7,ppGrpCode);
		pstmt.setString(8,blng_class_code);
		pstmt.setString(9,blng_class_code);
		pstmt.setString(10,eff_to_date);
		pstmt.setString(11,eff_from_date);
		pstmt.setString(12,eff_from_date);
		pstmt.setString(13,eff_to_date);
		pstmt.setString(14,eff_to_date);		
		pstmt.setString(15,eff_to_date);	
		pstmt.setString(16,eff_to_date);
		pstmt.setString(17,language_id);
		pstmt.setString(18,language_id);		
		pstmt.setString(19,language_id);
		rs= pstmt.executeQuery();
	}
	else{
		
			sqlStr="SELECT  a.package_code,a.cust_group_code cust_grp_code,DECODE (a.cust_group_code, '**', 'All Groups', c.short_desc ) cust_grp_desc, a.cust_code cust_code,DECODE (a.cust_code, '**', 'All Customers', b.short_name) cust_desc, a.blng_class_code blng_class_code, DECODE (a.blng_class_code, '**', 'All Billing Classes', d.short_desc ) blng_class_desc,a.age_group, a.speciality_code,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date,a.discount_type discount_type, a.discount discount,DECODE (a.age_group,'**', 'All Age Group',e.short_desc) age_group_desc,DECODE (a.speciality_code,'**', 'All Specialty',f.short_desc ) speciality_desc,g.package_code package_code, g.short_desc package_short_desc,a.policy_type_code policy_type_code,DECODE (a.policy_type_code,'**', 'All Policies',h.short_desc) policy_short_desc FROM bl_package_cust_discount a,ar_customer_lang_vw b,ar_cust_group_lang_vw c,bl_blng_class_lang_vw d, bl_age_group e,am_speciality f,bl_package g,bl_ins_policy_types h WHERE a.package_code = DECODE (?, '**', a.package_code, ?) AND a.operating_facility_id = ? AND a.cust_group_code = ? and a.cust_code = DECODE (?, '**', a.cust_code, ?) AND a.policy_type_code = DECODE (?, '**', a.policy_type_code, ?) AND a.blng_class_code = DECODE (?, '**', a.blng_class_code,?) AND ( ( a.eff_to_date IS NULL AND ? IS NULL AND a.eff_from_date >= TO_DATE (?, 'dd/mm/yyyy'))OR ( a.eff_to_date IS NOT NULL AND a.eff_from_date >= TO_DATE (?, 'dd/mm/yyyy') AND( ( ? IS NOT NULL AND a.eff_to_date <= TO_DATE (?, 'dd/mm/yyyy')) OR (? IS NULL AND a.eff_to_date >= TO_DATE (NVL (?, SYSDATE), 'dd/mm/yyyy')))  )) and   a.cust_group_code = c.cust_group_code(+) AND a.cust_code = b.cust_code(+) AND a.blng_class_code = d.blng_class_code(+) AND b.language_id(+) = ? AND c.language_id(+) =? AND d.language_id(+) = ? AND a.age_group = e.age_group_code(+) AND a.speciality_code = f.speciality_code(+) AND a.package_code = g.package_code AND h.operating_facility_id(+) = a.operating_facility_id AND h.policy_type_code(+) = a.policy_type_code"; 
		pstmt=conn.prepareStatement(sqlStr);	
		pstmt.setString(1,packageCode);			
		pstmt.setString(2,packageCode);
		pstmt.setString(3,facility_id);     // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(4,cust_grp_code);
		pstmt.setString(5,custCode);    // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(6,custCode); 
		pstmt.setString(7,ppGrpCode);   // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(8,ppGrpCode);
		pstmt.setString(9,blng_class_code);
		pstmt.setString(10,blng_class_code);
		pstmt.setString(11,eff_to_date);
		pstmt.setString(12,eff_from_date);
		pstmt.setString(13,eff_from_date);
		pstmt.setString(14,eff_to_date);
		pstmt.setString(15,eff_to_date);		
		pstmt.setString(16,eff_to_date);	
		pstmt.setString(17,eff_to_date);
		pstmt.setString(18,language_id);
		pstmt.setString(19,language_id);		
		pstmt.setString(20,language_id);
		rs= pstmt.executeQuery();
	}

	/*	pstmt=conn.prepareStatement(sqlStr);	
		pstmt.setString(1,packageCode);			
		pstmt.setString(2,packageCode);
		pstmt.setString(3,facility_id);     // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(4,custCode);    // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(5,custCode); 
		pstmt.setString(6,ppGrpCode);   // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(7,ppGrpCode);
		pstmt.setString(8,blng_class_code);
		pstmt.setString(9,blng_class_code);
		pstmt.setString(10,eff_to_date);
		pstmt.setString(11,eff_from_date);
		pstmt.setString(12,eff_from_date);
		pstmt.setString(13,eff_to_date);
		pstmt.setString(14,eff_to_date);		
		pstmt.setString(15,eff_to_date);	
		pstmt.setString(16,eff_to_date);
		pstmt.setString(17,language_id);
		pstmt.setString(18,language_id);		
		pstmt.setString(19,language_id);
		rs= pstmt.executeQuery();
*/
		// 28-08-2020  end
		while(rs.next())
		{
			count=rs.getRow();
		}

		rs= pstmt.executeQuery();
		if(count<end)
		{
			flage=false;	
		}

if ( !(start== 1) )
{	
	for( int j=1; j<=start; i++,j++ )   
		rs.next() ;  
}
	int cnt=0;
	i=1;
	 try {	
		%>
			
<form name='cust_discount_dtl' id='cust_discount_dtl'  target='messageFrame' >	
<table width='100%' id="cust_discount_tbl">
	<tr>
		<td></td><td></td><td></td><td></td><td></td><td></td><td></td>						
		<td>
	<%
	if(cnt==0)
	{		
		if ( !(start <= i) )
		{
			out.println("<A HREF='../../eBL/jsp/BLPakDefQuery.jsp?from="+(start-16)+"&to="+(end-16)+"&packageCode="+packageCode+"&facility_id="+facility_id+"&custCode="+custCode+"&ppGrpCode="+ppGrpCode+"&blng_class_code="+blng_class_code+"&language_id="+language_id+"&language_id="+language_id+"&language_id="+language_id+"&eff_from_date="+eff_from_date+"&eff_to_date="+eff_to_date+"&cust_grp_code="+cust_grp_code+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}						
		if (endOfRes.equals("1") && count > end )
		{
			out.println("<A id='nextval' HREF='../../eBL/jsp/BLPakDefQuery.jsp?from="+(start+16)+"&to="+(end+16)+"&packageCode="+packageCode+"&facility_id="+facility_id+"&custCode="+custCode+"&ppGrpCode="+ppGrpCode+"&blng_class_code="+blng_class_code+"&language_id="+language_id+"&language_id="+language_id+"&language_id="+language_id+"&eff_from_date="+eff_from_date+"&eff_to_date="+eff_to_date+"&cust_grp_code="+cust_grp_code+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
	}					
	%>
	</td>						
	</tr>
	<% 
	while( i<=end && rs.next() )		
	{	
		record=new String[14];
		record[0]=checkForNull(rs.getString("cust_grp_code"));
		record[1]=checkForNull(rs.getString("cust_grp_desc"));
		record[2]=checkForNull(rs.getString("cust_code"));
		record[3]=checkForNull(rs.getString("cust_desc"));
		record[4]=checkForNull(rs.getString("blng_class_code"));
		record[5]=checkForNull(rs.getString("blng_class_desc"));
		record[6]=checkForNull(rs.getString("eff_from_date"));				
		record[7]=checkForNull(rs.getString("eff_to_date"));				
		record[8]=checkForNull(rs.getString("discount_type"));				
		record[9]=checkForNull(rs.getString("discount"));	
		record[10]=checkForNull(rs.getString("policy_type_code"));
		record[11]=checkForNull(rs.getString("policy_short_desc"));
		record[12]=checkForNull(rs.getString("package_code"));
		record[13]=checkForNull(rs.getString("package_short_desc"));
		
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
		poly_code       = record[10];
		poly_desc       = record[11]; 
		pkg_code       = record[12];
		pkg_desc       = record[13];
	%>
<tr>
<td width='15%' nowrap >
	<input type='text' name='cust_grp_code<%=i%>' id='cust_grp_code<%=i%>' value='<%=cust_grp_code%>' <%=modifyStatus%> size='10' <%=(mode.equals("modify") && !cust_grp_code.equals(""))?"readonly":""%> >
	<input type='text' name = 'cust_grp_desc<%=i%>' <%=(mode.equals("modify") && !cust_grp_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%>  value="<%=cust_grp_desc%>">
	<INPUT type='hidden' name='cust_grp_code_temp<%=i%>' id='cust_grp_code_temp<%=i%>' value='<%=cust_grp_code%>'>
	<INPUT type='hidden' name='cust_grp_desc_temp<%=i%>' id='cust_grp_desc_temp<%=i%>' value='<%=cust_grp_desc%>'><!-- 28-08-2020-->
</td>

<td width='15%' nowrap>		
	<input type='text' name='cust_code<%=i%>' id='cust_code<%=i%>' value='<%=cust_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !cust_code.equals(""))?"readonly":""%> >
	<input type='text' name = 'cust_desc<%=i%>' value='<%=cust_desc%>' <%=(mode.equals("modify") && !cust_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%> >
	<INPUT type='hidden' name='cust_code_temp<%=i%>' id='cust_code_temp<%=i%>' value='<%=cust_code%>'>
	<INPUT type='hidden' name='cust_code_temp<%=i%>' id='cust_code_temp<%=i%>' value='<%=cust_desc%>'>
</td>

<td  width='15%' nowrap>		
	<input type='text' name='poly_code<%=i%>' id='poly_code<%=i%>' value='<%=poly_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !poly_code.equals(""))?"readonly":""%> >
	<input type='text' name = 'poly_desc<%=i%>' <%=(mode.equals("modify") && !poly_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%>  value="<%=poly_desc%>">
	<INPUT type='hidden' name='poly_code_temp<%=i%>' id='poly_code_temp<%=i%>' value='<%=poly_code%>'>
	<INPUT type='hidden' name='poly_code_temp<%=i%>' id='poly_code_temp<%=i%>' value='<%=poly_desc%>'>
</td>

<td width='15%' nowrap>
	<input type='text' name='blng_class_code<%=i%>' id='blng_class_code<%=i%>' value='<%=blng_class_code%>' <%=modifyStatus%> size='10' <%=(mode.equals("modify") && !blng_class_code.equals(""))?"readonly":""%> ">
	<input type='text' name = 'blng_class_desc<%=i%>' <%=(mode.equals("modify") && !blng_class_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%>  value="<%=blng_class_desc%>">
	<INPUT type='hidden' name='blng_class_code_temp<%=i%>' id='blng_class_code_temp<%=i%>' value='<%=blng_class_code%>'>
	<INPUT type='hidden' name='blng_class_desc_temp<%=i%>' id='blng_class_desc_temp<%=i%>' value='<%=blng_class_desc%>'>
	
</td>

<td width='15%' nowrap>		
	<input type='text' name='pkg_code<%=i%>' id='pkg_code<%=i%>' value='<%=pkg_code%>' size='10' <%=modifyStatus%> <%=(mode.equals("modify") && !pkg_code.equals(""))?"readonly":""%> >
	<input type='text' name = 'pkg_desc<%=i%>' <%=(mode.equals("modify") && !pkg_desc.equals(""))?"readonly":""%> size='10' maxlength='10' <%=modifyStatus%>  value="<%=pkg_desc%>">
	<INPUT type='hidden' name='pkg_code_temp<%=i%>' id='pkg_code_temp<%=i%>' value='<%=pkg_code%>'>
	<INPUT type='hidden' name='pkg_desc_temp<%=i%>' id='pkg_desc_temp<%=i%>' value='<%=pkg_desc%>'>
</td>
<!-- 20/8/2020 START-->
<td  class='fields'   witdh='6%' nowrap>
	<input type='text' name='eff_from_date<%=i%>' id='eff_from_date<%=i%>'	 <%=modifyStatus%> id='eff_from_date<%=i%>' <%=(mode.equals("modify") && !eff_from_date.equals(""))?"readonly":""%> size='10' maxlength="10"  value="<%=eff_from_date%>"   onBlur="validateDiscountDate(this,this,eff_to_date<%=i%>,'<%=i%>');"><img id = 'eff_from_date_img_<%=i%>' name="eff_from_date_img_<%=i%>" <%=modifyStatus%>	<%=(mode.equals("modify") && !eff_from_date.equals(""))?"disabled":""%>   src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_from_date<%=i%>');"  />
</td>

<td  class='fields'   witdh='6%' nowrap>
	<input type='text' name='eff_to_date<%=i%>' id='eff_to_date<%=i%>'  <%=modifyStatus%> id='eff_to_date<%=i%>' size='10' maxlength="10"  value="<%=eff_to_date%>" <%=(mode.equals("modify") && !eff_to_date.equals(""))?"readonly":""%> onBlur="validateDiscountDate(this,eff_from_date<%=i%>,this,'<%=i%>');" ><img id = 'eff_to_Date_img_<%=i%>' name="eff_to_Date_img_<%=i%>"	<%=modifyStatus%>	src="../../eCommon/images/CommonCalendar.gif" <%=(mode.equals("modify") && !eff_to_date.equals(""))?"disabled":""%> onClick="return showCalendar('eff_to_date<%=i%>');" >
</td>
<!-- 20/8/2020 END-->

<td  class='fields'   witdh='6%' nowrap>
	<select name='discount_type<%=i%>' id='discount_type<%=i%>' onChange="chkDisountType(this,'<%=i%>')" <%=modifyStatus%> >
	<option value='R' <%=discount_type.equals("R")?"selected":""%>>
		<fmt:message key="Common.Percent.label" bundle="${common_labels}"/>
	</option>
	<option value='A' <%=discount_type.equals("A")?"selected":""%>><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
</select>
</td>

<td  witdh='7%' nowrap>
	<input type='text' name='discount<%=i%>' id='discount<%=i%>'   size='5'  <%=modifyStatus%> onBlur='chkDiscountAmt(this,"<%=i%>");'  onKeyPress='return ChkNumberInput(this,event,"<%=noofdecimal%>");' value="<%=discount%>"/>
</td>
</tr>
<%
cnt++;
i++;
}	
   if (!rs.next() && cnt!=0 )
    {
	      endOfRes = "0";	
    } 
	}catch(Exception e){	
		e.printStackTrace();
	}
if(cnt==0)	
   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	}catch(Exception e)
	 {
	   e.printStackTrace();
	}   
   finally
   {
      try{	  
		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();	  
	  }catch(Exception e){
		  e.printStackTrace();
		}
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }
%>
</table>
</tr>
</table>
<INPUT TYPE="hidden" name='mode' id='mode' value="<%=mode%>">
</form>
</BODY>
</HTML>

