<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,com.ehis.util.*,webbeans.op.CurrencyFormat,eBL.* " contentType="text/html;charset=UTF-8" %>
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
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src='../js/PkgRefund.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<% 
	//Added by Nmuthu against 31888 (patientID length) on 13-4-12 - Starts Here
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	Statement stmt	= null;
	ResultSet rs = null;
	String PatIDLen = "";
	
try{
		String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
		pstmt=con.prepareStatement(sqlLen);
	    rs=pstmt.executeQuery();
		while(rs.next() && rs!=null)
		{
			 PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		System.out.println("Exception @ Patient Id Length :"+e);
		e.printStackTrace();
	}
	//Added by Nmuthu against 31888 (patientID length) on 13-4-12 - Starts Here
	try
	{		

		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id			= (String)session.getAttribute("facility_id");
		String params = request.getQueryString();		
		String bean_id		= "PkgRefundBean" ;
		String bean_name	= "eBL.PkgRefundBean";
		PkgRefundBean bean			= (PkgRefundBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.clearBean();
   %>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">	
	<form name='PkgRefundHdrForm' id='PkgRefundHdrForm' action="../../servlet/eBL.PkgRefundServlet" method="post" target="messageFrame">
	<table cellpadding=0 cellspacing=0 border=0  width="100%" align='center'>
	<tr>		
		  <td class="label" nowrap width='20%'><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></td>
			<td class="field" nowrap width='22%'><INPUT TYPE="TEXT"  name="patient_id" id="patient_id" SIZE="10" maxlength='<%=PatIDLen%>' VALUE=''  onKeyPress='changeToUpper()' onBlur="chkPatientId();" ><input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return getPatID()" tabindex='2'><img src='../../eCommon/images/mandatory.gif'></td>
		<td class='label' nowrap id='pat_dtls' colspan='2'>&nbsp;</td>		
	</tr>
	<tr>
	<td  class='label' nowrap width='20%'><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>
	<td class="field" nowrap width='22%'><input type='text' name='pkg_code' id='pkg_code' value='' size='8' maxlength="8"  onKeyPress='return CheckForSpecChars_loc(event,pkg_code);' onBlur="pkgCodeLookup(pkg_desc,this);" ><input type='text' name='pkg_desc' id='pkg_desc'    onBlur="pkgDescLookUp(this,pkg_code)"  size='15'  maxlength="40" value="" ><INPUT type='hidden' name='pkg_code_temp' id='pkg_code_temp' value=''><INPUT type='hidden' name='pkg_desc_temp' id='pkg_desc_temp' value=''><input type='button' class='button' name='pkg_btn' id='pkg_btn' value='?'  onClick="pkgLookUp(pkg_desc,pkg_code);"><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class='label' nowrap id='pkg_dtls_td' colspan='2'>&nbsp;</td>
	</tr>
	<tr>		
			<td class='field' align='right' colspan='3'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='displaySrvDtls()'></td>	
<td class='label' nowrap width='10%'>&nbsp;</td>			
	</tr>
</table>

<input type='hidden' name='params' id='params' value="<%=params%>" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
<input type='hidden' name='pkg_seq_no' id='pkg_seq_no' value="">


</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	System.out.println("Exception from Package Refund header :"+e);
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


