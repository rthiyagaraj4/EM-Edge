<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eMP/js/DocumentType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- Added by Sangeetha on 24/apr/17 for KDAH-CRF-0347 -->
		<!-- Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 -->
<script>
function setValue()
{
	if ( document_type_form.addr_id.checked == true)
	{
	  document_type_form.supp_doc_type_add.value="Y";
	}
	  
	if ( document_type_form.iden_id.checked == true)
	{
	  document_type_form.supp_doc_type_iden.value="Y";
	}
 
}

</script>
	</head>
	<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>

<% 
String doc_type = request.getParameter("doc_type");
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
String eff_date_from="",eff_date_to="";
//Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 
String supp_doc_desc=""; 
String supp_doc_type_iden=""; 
String supp_doc_type_add=""; 
String isIDChecked ="";
String isAddrChecked="";
try{
	conn = ConnectionManager.getConnection(request);
	//Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347
	Boolean isSuppDocFieldAvail	= eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","GENERATE_FORM_60");

	pstmt = conn.prepareStatement("select doc_type,long_desc,short_desc,eff_date_from,eff_date_to,eff_status, address_proof_yn, identity_proof_yn,SUPP_DOC_DESC from mp_document_type where doc_type='"+doc_type+"'"); //Added SUPP_DOC_TYPE and SUPP_DOC_DESC by Sangeetha on 18/apr/17 for KDAH-CRF-0347 

	String status = "" ;

	rset = pstmt.executeQuery();

	if ( rset != null ){
		rset.next();
		status = rset.getString( "eff_status" ) ;
		//Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347
		supp_doc_desc = rset.getString( "SUPP_DOC_DESC" ) ;  
		supp_doc_type_add = rset.getString( "address_proof_yn" ) ;  
		supp_doc_type_iden = rset.getString( "identity_proof_yn" ) ; 
	}
	if((supp_doc_desc==null) || (supp_doc_desc.equals("null")))
		supp_doc_desc = "";

	//Modified by Sangeetha for PMG2017-KDAH-CRF-0001
	if((supp_doc_type_add==null) || (supp_doc_type_add.equals("null")))
		supp_doc_type_add = "N";
	if((supp_doc_type_iden==null) || (supp_doc_type_iden.equals("null")))
		supp_doc_type_iden = "N";

	
	//Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347
	/*if(supp_doc_type.equals("A"))
		isAddrChecked="Checked";
	if(supp_doc_type.equals("I"))
		isIDChecked="Checked"; */

	//Modified by Sangeetha for PMG2017-KDAH-CRF-0001
	if(supp_doc_type_add.equals("Y"))
		isAddrChecked="Checked";
	else if(supp_doc_type_add.equals("N"))
		isAddrChecked="";

	if(supp_doc_type_iden.equals("Y"))
		isIDChecked="Checked";
	else if(supp_doc_type_iden.equals("N"))
		isIDChecked="";
	
%>
	<form name='document_type_form' id='document_type_form' action='../../servlet/eMP.DocumentTypeServlet' method='post' target='messageFrame'> 
		<BR><BR><BR><BR><BR><BR><BR><BR><BR>
		<div align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
			<tr>
				<td width='40%'>&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='2'><input type='text' size='2' maxlength='2' name='doc_type' id='doc_type' readonly value='<%=rset.getString("doc_type")%>'><img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='2'>
<%
	if ( status.equals( "E" ) )
		out.println( "<input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value= \"" + rset.getString( "long_desc" ) + "\">" );
	else
		out.println( "<input type='text' name='long_desc' id='long_desc' size='30' readonly value=\"" + rset.getString( "long_desc" ) + "\">" );
%>					<img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='2'>
<%
	if ( status.equals( "E" ) )
		out.println( "<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"" + rset.getString( "short_desc" ) + "\">" );
	else
		out.println( "<input type='text' name='short_desc' id='short_desc' size='15' readonly value=\""  + rset.getString( "short_desc" ) + "\">" );

	out.println("<img src='../images/mandatory.gif'></img></td></tr>" ) ;

/*out.println( "<tr><td width='40%' class='label'>Effective From</td><td width='13%' >&nbsp;&nbsp;" ) ;*/


	if ( rset.getDate("eff_date_from") != null )
	{
		java.util.Date date = rset.getDate("eff_date_from");
		SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		eff_date_from = formatter.format(date);
		date = null;
		formatter = null;
	}
 
	if ( status.equals( "E" ) )
		out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' value='"+eff_date_from+"'>");
	else
		out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' readonly value='"+eff_date_from+"'>");


/*out.println("' onblur='checkdate(this)'></td><td width='47%'  class='label'>&nbsp;&nbsp;To&nbsp;&nbsp; " ) ;*/

	if ( rset.getDate("eff_date_to") != null)
	{
		java.util.Date date1 = rset.getDate("eff_date_to");
		SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		eff_date_to = formatter.format(date1);
		date1 = null;
		formatter = null;
	}

	if ( status.equals( "E" ) )
		out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"'>");
	else
		out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  readonly value='"+eff_date_to+"'>");
%>
	<!-- Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 -->
	<%if(isSuppDocFieldAvail){
	%>
	<tr>
		<td width="40%" class="label"><fmt:message key="eMP.SuppDocType.label" bundle="${mp_labels}"/></td>
		<td width='60%' class='fields' colspan='2'>
		<fmt:message key="eMP.AddrProof.label" bundle="${mp_labels}"/><input type='checkbox' name='supp_doc_type_add' id='supp_doc_type_add' id='addr_id' value = 'Y' <%=isAddrChecked%> onClick="setValue();">  &nbsp&nbsp&nbsp
		<fmt:message key="eMP.IDProof.label" bundle="${mp_labels}"/><input type='checkbox' name='supp_doc_type_iden' id='supp_doc_type_iden' id='iden_id' value = 'Y' <%=isIDChecked%> onClick="setValue();">
		</td>
	</tr>

	<tr>
	<td width='40%' class='label'><fmt:message key="eMP.SuppDocDesc.label" bundle="${mp_labels}"/></td>
	<td width='60%' class='fields' colspan='2'>
<%
	if ( status.equals( "E" ) )
		out.println( "<TextArea name='supp_doc_desc' size=60 maxlength=60 rows='2' cols='45' onKeyPress='checkMaxLimit(this,60);' onblur='callCheckMaxLen(this,60)'>" + supp_doc_desc + "</TextArea>" );
	else
		out.println( "<TextArea name='supp_doc_desc' size=60 maxlength=60 rows='2' cols='45' readonly>" + supp_doc_desc + "</TextArea>" );
	out.println("<img src='../images/mandatory.gif'></img></td></tr>" ) ;
	}

/*out.println("' onblur='checkdate(this)'></td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/

	out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");

	String eff_status = rset.getString("eff_status");

	if  ( eff_status.equals("E") )
		out.println("checked >");
	else
		out.println(">");
%>
				</td>
			</tr>
			<tr>
				<td width='40%'>&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
		</table>
		</div>
	<input type='hidden' name='function' id='function' value='modify'>
	<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
	<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
	<input type='hidden' name='function_name' id='function_name' value='modify'>
	<!-- Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 -->
	<input type='hidden' name='isSuppDocFieldAvail' id='isSuppDocFieldAvail' value='<%=isSuppDocFieldAvail%>'> 
	<input type='hidden' name='isdocTypeSelected' id='isdocTypeSelected' value=''>
</form>
<%
}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();
}finally{
	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close();
	ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

