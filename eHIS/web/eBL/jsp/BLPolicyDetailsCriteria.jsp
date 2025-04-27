<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.op.CurrencyFormat, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null;

	PreparedStatement pstmt=null ;
	PreparedStatement pstmt1=null ;
	PreparedStatement pstmt2=null ;
	PreparedStatement pstmt3=null ;
	PreparedStatement pstmt4=null ;
	PreparedStatement pstmt5=null ;

	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	ResultSet rs5 = null;

	HttpSession httpSession = request.getSession(false);

	String locale	= (String)session.getAttribute("LOCALE");
	String facility_id = (String)httpSession.getValue("facility_id");

	try
	{

	//con = (Connection) session.getValue("connection" );

	con	=	ConnectionManager.getConnection(request);
	String cust_name="", policy_name="", clinic_code="",visit_type_code="" ;
	String clinic="",visit_type="",visit_deduce="";
	request.setCharacterEncoding("UTF-8");
	//unused variable, commented on 09/06/05
	//int ill_deduce=0;
	String  str_ill_deduce="";	
	
	String cust_code=request.getParameter("cust_code");
	String policy_code=request.getParameter("policy_code");
	clinic_code=request.getParameter("clinic_code");
	visit_type_code=request.getParameter("visit_type_code");

	if(cust_code==null)cust_code="";
	if(policy_code==null)policy_code="";
	if(clinic_code==null)clinic_code="";
	if(visit_type_code==null)visit_type_code="";

	cust_code=cust_code.trim();
	policy_code=policy_code.trim();
	visit_type_code=visit_type_code.trim();
	clinic_code=clinic_code.trim();

	//out.println("cust_code"+cust_code);
	//out.println("policy_code"+policy_code);

	String query_cust_code="select short_name from ar_customer_lang_vw where language_id='"+locale+"' and cust_code='"+cust_code+"'";
	String query_policy_code="select short_desc from bl_ins_policy_types_lang_vw where language_id='"+locale+"' and policy_type_code='"+policy_code+"'";

	String query_clinic="select short_desc from op_clinic_lang_vw where language_id='"+locale+"' and facility_id = '"+facility_id +"' and clinic_code='"+clinic_code+"'";
	//out.println("query_clinic :"+query_clinic);

	String query_ill_deduce="select nvl(ins_deduct_amt,0) from bl_ins_deductible_hdr where policy_type_code='"+policy_code+"' and cust_code='"+cust_code+"' and illn_visit_ind='I'";

	//out.println("query_ill_deduce :"+query_ill_deduce);

	String query_visit_type="select short_desc from op_visit_type_lang_vw where language_id='"+locale+"' and facility_id = '"+facility_id +"' and visit_type_code='"+visit_type_code+"'";

	String query_visit_deduce="select nvl(ins_deduct_amt,0) from bl_ins_deductible_dtl where policy_type_code='"+policy_code+"' and cust_code='"+cust_code+"' and clinic_code=nvl('"+clinic_code+"',clinic_code) and visit_type=nvl('"+visit_type_code+"',visit_type)";

	//out.println("query_visit_deduce :"+query_visit_deduce);

	
	try
	{
		pstmt = con.prepareStatement(query_cust_code);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				cust_name = rs.getString("short_name");
			}
		}
		if (rs != null)   rs.close();
		pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception @ 1"+e);
		e.printStackTrace();
	}



	try
	{
		pstmt1 = con.prepareStatement(query_policy_code);
		rs1 = pstmt1.executeQuery() ;
		if( rs1 != null ) 
		{
			while( rs1.next() )
			{  
				policy_name = rs1.getString("short_desc");
			}
		}
		if (rs1 != null)   rs1.close();
		pstmt1.close();
	}
	catch(Exception e)
	{
		//out.println("Exception @ 2"+e);
		e.printStackTrace();
	}

	/*1**/
	try
	{
		pstmt2 = con.prepareStatement(query_clinic);
		rs2 = pstmt2.executeQuery() ;
		if( rs2 != null ) 
		{
			while( rs2.next() )
			{  
				clinic = rs2.getString("short_desc");
			}
		}
		if (rs2 != null)   rs2.close();
		pstmt2.close();
	}
	catch(Exception e)
	{
		//out.println("Exception @ 3"+e);
		e.printStackTrace();
	}
	/****/
	if(clinic==null||clinic.equals("null")) clinic="";

	/*2**/
	try
	{
		pstmt3 = con.prepareStatement(query_ill_deduce);
		rs3 = pstmt3.executeQuery() ;
		if( rs3 != null ) 
		{
			while( rs3.next() )
			{  
				str_ill_deduce = rs3.getString(1);
			}
		}
		if (rs3 != null)   rs3.close();
		pstmt3.close();
	}
	catch(Exception e)
	{
		//out.println("Exception @ 4 here"+e);
		e.printStackTrace();
	}
	/****/

	if(str_ill_deduce==null||str_ill_deduce.equals("null")) str_ill_deduce="0.00";
	CurrencyFormat cf1 = new CurrencyFormat();
	str_ill_deduce = cf1.formatCurrency(str_ill_deduce, 2);
	


	/*3**/
	try
	{
		pstmt4 = con.prepareStatement(query_visit_type);
		rs4 = pstmt4.executeQuery() ;
		if( rs4 != null ) 
		{
			while( rs4.next() )
			{  
				visit_type = rs4.getString("short_desc");
			}
		}
		if (rs4 != null)   rs4.close();
		pstmt4.close();
	}
	catch(Exception e)
	{
		//out.println("Exception @ 5"+e);
		e.printStackTrace();
	}
	/****/
	if(visit_type==null||visit_type.equals("null")) visit_type="";
	/*4**/
	try
	{
		pstmt5 = con.prepareStatement(query_visit_deduce);
		rs5 = pstmt5.executeQuery() ;
		if( rs5 != null ) 
		{
			while( rs5.next() )
			{  
				visit_deduce = rs5.getString("ins_deduct_amt");
			}
		}
		if (rs5 != null)   rs5.close();
		pstmt5.close();
	}
	catch(Exception e)
	{
		//out.println("Exception @ 6"+e);
		e.printStackTrace();
	}
	/****/
	if(visit_deduce==null||visit_deduce.equals("null")) visit_deduce="0.00";
	CurrencyFormat cf2 = new CurrencyFormat();
	visit_deduce = cf2.formatCurrency(visit_deduce, 2);



%>
<html>	
<head>
	<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<!--<tr>
	<td width="20%" >&nbsp;</td>
	<td width="20%"  colspan="3">&nbsp;</td>
 </tr>-->

 <tr>
	<td width="25%" class="label"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields"><input type='text' name='cust_code' id='cust_code' size='30'  value='<%=cust_name%>'maxlength='15' disabled></td>
	<td width="25%" class="label"></td>
	<td width="25%" class="label"></td>
 </tr>
 <tr>
	<td width="25%" class="label"><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
	<td width="25%" class="fields"><input type='text' name='policy_type_code' id='policy_type_code' size='30' value='<%=policy_name%>' maxlength='15' disabled></td>
	<td width="25%" class="label"></td>
	<td width="25%" class="label"></td>

 </tr>
 <tr>
	<td width="25%" class="label"><fmt:message key="eBL.ILLNESS_DEDUCTIBLE.label" bundle="${bl_labels}"/></td>
	<td width="25%" class="fields"><input type='text' name='ill_deduce' id='ill_deduce' style='text-align:right' size='15' maxlength='15' value='<%=str_ill_deduce%>' disabled ></td>
	<td width="25%" class="label" nowrap ><fmt:message key="eBL.VISIT_DEDUCTIBLE.label" bundle="${bl_labels}"/></td>
	<td width="25%" class="fields"><input type='text' name='visit_deduce' id='visit_deduce' style='text-align:right' size='15' maxlength='15' value='<%=visit_deduce%>' disabled></td>
 </tr>
 <tr>
	<td width="25%" class="label"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields"><input type='text' name='clinic' id='clinic' size='15' maxlength='15' value='<%=clinic%>' disabled></td>
	<td width="25%" class="label" nowrap ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields"><input type='text' name='visit_type' id='visit_type' size='15' maxlength='15' value='<%=visit_type%>' disabled></td>
 </tr>
 <table border='3' cellpadding='3' cellspacing='0' width='100%'>
<!--<th width='25%'><fmt:message key="eBL.EXCLUSION_SERVICE.label" bundle="${bl_labels}"/></th>
<th width='75%'><fmt:message key="eBL.INCLUSION_SERVICE.label" bundle="${bl_labels}"/></th>
-->
<td width='24%' class="COLUMNHEADERCENTER"><fmt:message key="eBL.EXCLUSION_SERVICE.label" bundle="${bl_labels}"/></td>
<td width='76%' class="COLUMNHEADERCENTER"><fmt:message key="eBL.INCLUSION_SERVICE.label" bundle="${bl_labels}"/></td>
</table>

<input type= hidden name="locale" id="locale"  value='<%=locale%>'>

 <!--
 <tr>
	<td width="20%" >&nbsp;</td>
	<td width="20%"  colspan="3">&nbsp;</td>
 </tr>
 -->
</table>
	</body>
	</html>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in main try"+ee);
		ee.printStackTrace();
	}
	finally
	{
		if(pstmt != null) pstmt.close();
		if(pstmt1 != null) pstmt1.close();
		if(pstmt2 != null) pstmt2.close();
		if(pstmt3 != null) pstmt3.close();
		if(pstmt4 != null) pstmt4.close();
		if(pstmt5 != null) pstmt5.close();
		ConnectionManager.returnConnection(con, request);
	}

%>



