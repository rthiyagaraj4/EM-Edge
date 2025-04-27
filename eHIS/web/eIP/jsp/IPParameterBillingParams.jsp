<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../js/IPParam.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
	var errorFlag	=	false;
	var errorSource	=	"";
	 function changesetfield()
	 {
		if(document.ipparam_form.bl_interfaced_yn.checked==false)
		 {

			document.ipparam_form.setup_bl_dtls_in_ip_yn.checked=false
			document.ipparam_form.setup_bl_dtls_in_ip_yn.disabled=true;
		 }
		 else
		 document.ipparam_form.setup_bl_dtls_in_ip_yn.disabled=false;
	 }

	function InterfacetoBL()
	{
		if(document.ipparam_form.bl_interfaced_yn.checked==true &&  document.ipparam_form.setup_bl_dtls_in_ip_yn.checked==true)
		{
			document.getElementById('blpar').style.visibility='visible';
			document.getElementById('blparam').style.visibility='visible';
		}
		else
		{
			document.getElementById('blpar').style.visibility='hidden';
			document.getElementById('blparam').style.visibility='hidden';
		}
	}


	function selfClose()
	{
		var ret_bl_interfaced_yn = "N";
		
		var ret_setup_bl_dtls_in_ip_yn = "N";

		var ret_outst_amt_limit    = 	document.ipparam_form.outst_amt_limit.value
			if(ret_outst_amt_limit == "")
			{
				ret_outst_amt_limit = "-";
			}
		var ret_policy_expiry_warning_period =  document.ipparam_form.policy_expiry_warning_period.value
			if(ret_policy_expiry_warning_period == "")
			{
				ret_policy_expiry_warning_period="-";
			}

		var ret_credit_auth_reqd_yn =document.ipparam_form.credit_auth_reqd_yn.value
			if(!(document.ipparam_form.credit_auth_reqd_yn.checked))
			{
				ret_credit_auth_reqd_yn = "N";
			}
		if(document.ipparam_form.bl_interfaced_yn.checked)
		{
			ret_bl_interfaced_yn = "Y";
			if(document.ipparam_form.setup_bl_dtls_in_ip_yn.checked)
			{
				ret_setup_bl_dtls_in_ip_yn = "Y";
			}
		}
		
		parent.window.returnValue = ret_bl_interfaced_yn+"@"+ret_setup_bl_dtls_in_ip_yn+"@"+ret_outst_amt_limit+"@"+ret_policy_expiry_warning_period+"@"+ret_credit_auth_reqd_yn

		parent.window.close();
		return 1;
	}
</script>

</head>
<%
	request.setCharacterEncoding("UTF-8"); 
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rset		= null;
	String facility_id	= (String)session.getAttribute("facility_id");

	try
	{
	con= ConnectionManager.getConnection(request);
	stmt = con.createStatement();

	String chk_booking_limit_by="";

	String bl_interfaced_yn="";
	String setup_bl_dtls_in_ip_yn="";
	String outst_amt_limit="";
	String policy_expiry_warning_period="";
	String credit_auth_reqd_yn="";
	String bl_fields="";
	String bl_set="disabled";
	String bkg_grace_period ="";

	String sql="select * from ip_param where facility_id='"+facility_id+"' ";	
	rset = stmt.executeQuery(sql);	
	if(rset!=null )
	{
		if(rset.next())
		{
			chk_booking_limit_by=rset.getString("chk_booking_limit_by");
			if(chk_booking_limit_by == null) chk_booking_limit_by = "";
			
			bl_interfaced_yn=rset.getString("bl_interfaced_yn");
			if(bl_interfaced_yn == null)
	
			bl_interfaced_yn = "N";
			bl_interfaced_yn = bl_interfaced_yn.equals("Y") ?"checked" :"" ;
	
			bkg_grace_period = rset.getString("bkg_grace_period");
			if(bkg_grace_period == null ) bkg_grace_period ="";

			setup_bl_dtls_in_ip_yn=rset.getString("setup_bl_dtls_in_ip_yn");
			if(setup_bl_dtls_in_ip_yn == null) setup_bl_dtls_in_ip_yn = "N";
			setup_bl_dtls_in_ip_yn = setup_bl_dtls_in_ip_yn.equals("Y") ?"checked" :"" ;
		
			

			}
                if(rset != null)rset.close();
                if(stmt != null)stmt.close();
		}	
%>
<title>Billing Parameters</title>
<body  onMouseDown='CodeArrest()' onKeyDown='lockKey()' >
<form name='ipparam_form' id='ipparam_form'  method="post"  target="messageFrame">	
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >

	<table cellspacing=0 cellpadding=0 align='center' width='99%' border='0'>

	<tr>
	<th colspan='4' align='left'>Billing Parameters</th>
	<tr>
		<td nowrap class='label' align='right' width ='45%'><fmt:message key="Common.InterfacetoBillingModule.label" bundle="${common_labels}"/></td>
		<td nowrap class='label' align='left' width ='5%'>&nbsp;<input type='checkbox' size='1' maxlength='1' name='bl_interfaced_yn' id='bl_interfaced_yn' value='Y'  <%=bl_interfaced_yn%> onclick="InterfacetoBL();changesetfield()" <%=bl_fields%> tabIndex ='0'>
		</td>
		<td nowrap class='label' align='right' width ='45%'><fmt:message key="eIP.SetupBillingDtls.label" bundle="${ip_labels}"/></td>
		<td nowrap class='label' align='left' width ='7%'>&nbsp;<input type='checkbox' size='1' maxlength='1' name='setup_bl_dtls_in_ip_yn' id='setup_bl_dtls_in_ip_yn' value='Y'  <%=setup_bl_dtls_in_ip_yn%> onclick="InterfacetoBL()" <%=bl_fields%> <%=bl_set%> tabIndex ='0'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr id='blpar' style=visibility:hidden;>
		<td nowrap class='label' align='right' width ='43%'><fmt:message key="eIP.OutstandingamountLimit.label" bundle="${ip_labels}"/></td>
		<td nowrap  class='label' align='right' width ='7%'>&nbsp;<input type='text' size='5' maxlength='5' name='outst_amt_limit' id='outst_amt_limit' value='<%=outst_amt_limit%>' onKeyPress='return(ChkNumberInput(this,event,2))'>
		</td>
		<td nowrap class='label' align='right' width ='43%'><fmt:message key="eIP.InsuranceExpiryWarning.label" bundle="${ip_labels}"/></td>
		<td nowrap class='label' align='left' width ='4%'>&nbsp;<input type='text' size='3' maxlength='3' name='policy_expiry_warning_period' id='policy_expiry_warning_period' value='<%=policy_expiry_warning_period%>' onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;Days
		</td>
	</tr>
	<tr id='blparam' style=visibility:hidden;>
		<td nowrap class='label' align='right' colspan='3' nowrap >When Outstanding Amount exceeds limit,Credit Authorization Required</td><td nowrap class='label' align='left'>&nbsp;<input type='checkbox' size='8' maxlength='8' name='credit_auth_reqd_yn' id='credit_auth_reqd_yn' value='Y'  <%=credit_auth_reqd_yn%>>
		</td>		
	</tr>
<tr>
		<td >&nbsp;</td>
		<td colspan=3 align=right><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>"  onclick="javascript:return selfClose();"></td>		
		</tr>
	<script>
		<%
			if(bl_interfaced_yn.equals("checked") && setup_bl_dtls_in_ip_yn.equals("checked"))
			{
				out.println("document.getElementById('blpar').style.visibility='visible';		document.getElementById('blparam').style.visibility='visible';");
			}
		%>
	</script>		
	<% out.println("<script> if(document.ipparam_form.bl_interfaced_yn.checked==true)	{document.ipparam_form.setup_bl_dtls_in_ip_yn.disabled=false; \n }		else { document.ipparam_form.setup_bl_dtls_in_ip_yn.disabled=true;\n }		</script>"); %>	
	</table>
	</form>	
	</body>
	<%
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{
		if(stmt	!= null) stmt.close();
		if(rset		!= null)rset.close();
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</html>


	<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

