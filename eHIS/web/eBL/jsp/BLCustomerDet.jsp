<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* , java.io.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection con = null; ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;

	String cust_code = "", cust_grp_code = "", cust_grp_desc="";
	String cust_name = "";
	String cust_add1 = "";
	String cust_add2 = "";
	String cust_add3 = "";
	String cust_phone = "";
	String cust_email = "";
	String cust_fax = "";
	String cust_contact_name = "";
	String cust_contact_title = "";
    request.setCharacterEncoding("UTF-8");

	String locale	= (String)session.getAttribute("LOCALE");

	try
  	{	
		con = ConnectionManager.getConnection(request);
		
		cust_code = request.getParameter("cust_code");
		if( cust_code == null) cust_code="";

		cust_grp_code = request.getParameter("cust_grp_code");
		if( cust_grp_code == null) cust_grp_code="";
		
//		System.err.println("cust_grp_code:"+cust_grp_code);

		String sql="select long_name, add1_desc, add2_desc, add3_desc, tel_num,email_id, fax_num, contact_name, contact_name_title from ar_customer_lang_vw where language_id='"+locale+"' and cust_code ='"+cust_code+"'";

		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery() ;

		
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				cust_name = rs.getString("long_name");	
				cust_add1 = rs.getString("add1_desc");	
				cust_add2 = rs.getString("add2_desc");	
				cust_add3 = rs.getString("add3_desc");	
				cust_phone = rs.getString("tel_num");	
				cust_email = rs.getString("email_id");	
				cust_fax = rs.getString("fax_num");	
				cust_contact_name = rs.getString("contact_name");	
				cust_contact_title = rs.getString("contact_name_title");	
			}
		}
		if (rs != null)   rs.close();
		pstmt.close();	
		
		sql="select LONG_DESC from ar_cust_group_lang_vw where language_id='"+locale+"' and cust_group_code ='"+cust_grp_code+"'";

		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery() ;

		
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				cust_grp_desc = rs.getString("LONG_DESC");	
			}
		}
		if (rs != null)   rs.close();
		pstmt.close();
//			System.err.println("cust_grp_desc:"+cust_grp_desc);	
		
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}

	if (cust_name == null) cust_name = "";
	if (cust_add1 == null) cust_add1 = "";
	if (cust_add2 == null) cust_add2 = "";
	if (cust_add3 == null) cust_add3 = "";
	if (cust_phone == null) cust_phone = "";
	if (cust_email == null) cust_email = "";
	if (cust_fax == null ) cust_fax = "";
	if (cust_contact_name == null ) cust_contact_name = "";
	if (cust_contact_title == null ) cust_contact_title = "";
%>

<html>
	<head>
	<script>	
		function showcustdesc()
		{		
				if(document.forms[0].cust_grp.value != "")
				{
					document.getElementById('custgrp').innerText = document.forms[0].cust_grp.value;								
				}
				document.getElementById('custname').innerText = document.forms[0].cust_name.value;				
				document.getElementById('custadd1').innerText = document.forms[0].cust_add1.value;				
				document.getElementById('custadd2').innerText = document.forms[0].cust_add2.value;				
				document.getElementById('custadd3').innerText = document.forms[0].cust_add3.value;				
				document.getElementById('custphone').innerText = document.forms[0].cust_phone.value;				
				document.getElementById('custfax').innerText = document.forms[0].cust_fax.value;				
				document.getElementById('custemail').innerText = document.forms[0].cust_email.value;				
				document.getElementById('custcontactname').innerText = document.forms[0].cust_contact_name.value;		
				document.getElementById('custcontacttitle').innerText = document.forms[0].cust_contact_title.value;		
		 }
	</script>

			<title><fmt:message key="eBL.CUSTOMER_DTL.label" bundle="${bl_labels}"/></title>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


			
	</head>

	<body onLoad='showcustdesc();' onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();">
	<form name='CusrDet' id='CusrDet' method='post' action=''>		
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<%
	if(!cust_grp_code.equals(""))
	{
%>
	<tr>
		 <td width="40%" class="label" ><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>: </td>	
		 <td width="60%" class="fields"><b  id="custgrp"> </b></td>
	</tr>	
<%
	}
%>
	<tr>
		 <td width="40%" class="label" ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/>: </td>	
		 <td width="60%" class="fields"><b  id="custname"> </b></td>
	</tr>	
	<tr>
		 <td width="40%" class="label" ><fmt:message key="Common.Address.label" bundle="${common_labels}"/>: </td>
		 <td width="60%" class="fields" ><b  id="custadd1"></b></td>
	</tr>	

	<tr>
		 <td width="40%"></td>		
		 <td width="60%" class="fields"><b  id="custadd2"></b></td>
	</tr>	

	<tr>
		 <td width="40%"></td>		
		 <td width="60%" class="fields"><b  id="custadd3"></b></td>
	</tr>	

	<tr>
		 <td width="40%" class="label" ><fmt:message key="Common.telephone.label" bundle="${common_labels}"/>: </td>		
		 <td width="60%" class="fields"  ><b  id="custphone"> </b></td>
	</tr>	

	<tr>
		 <td width="40%"  class="label" ><fmt:message key="Common.fax.label" bundle="${common_labels}"/>: </td>		
		 <td width="60%" class="fields" > <b  id="custfax"> </b></td>
	</tr>	

	<tr>
		 <td width="40%" class="label" ><fmt:message key="Common.email.label" bundle="${common_labels}"/>: </td>		
		 <td width="60%" class="fields"> <b  id="custemail"> </b></td>
	</tr>	

	<tr>
		 <td width="40%"  class="label" ><fmt:message key="eMP.ContactPersonName.label" bundle="${mp_labels}"/>:</td>		
		 <td width="60%" class="fields" > <b  id="custcontactname"> </b></td>
	</tr>	

	<tr>
		 <td width="40%"  class="label" ><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/>: </td>		
		 <td width="60%" class="fields" > <b  id="custcontacttitle"> </b></td>
	</tr>	
	</table>

	<input type=hidden name='cust_grp' id='cust_grp' value="<%=cust_grp_desc%>">		 
	<input type=hidden name='cust_name' id='cust_name' value="<%=cust_name%>">		 
	<input type=hidden name='cust_add1' id='cust_add1' value="<%=cust_add1%>">		 
	<input type=hidden name='cust_add2' id='cust_add2' value="<%=cust_add2%>">		 
	<input type=hidden name='cust_add3' id='cust_add3' value="<%=cust_add3%>">		 
	<input type=hidden name='cust_phone' id='cust_phone' value="<%=cust_phone%>">	
	<input type=hidden name='cust_fax' id='cust_fax' value="<%=cust_fax%>">		 
	<input type=hidden name='cust_email' id='cust_email' value="<%=cust_email%>">		 
	<input type=hidden name='cust_contact_name' id='cust_contact_name' value="<%=cust_contact_name%>">		 
	<input type=hidden name='cust_contact_title' id='cust_contact_title' value="<%=cust_contact_title%>">		 

	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>

	</form>
	</body>

</html>



