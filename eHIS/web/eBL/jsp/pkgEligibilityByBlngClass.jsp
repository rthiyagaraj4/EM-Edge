<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%

	//StringBuffer opt=new StringBuffer();//unused variable
	Connection			con			=	null;
	PreparedStatement	stmt		=	null;
	ResultSet			rs		=	null;
	con					=	ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);
	String bed_no="";String bed_type="";
	
	String billing_group="";	//String title="";
	String x_valid_user="";
	String locale	= (String)session.getAttribute("LOCALE");
	String facility_id = (String)httpSession.getValue("facility_id");
	String loginUser				= (String)session.getValue("login_user");

	try
	{
		request.setCharacterEncoding("UTF-8");
		bed_type=request.getParameter("bed_type");
		//System.out.println("bed_type:"+bed_type);
		bed_no = request.getParameter("bed_no");
		//System.out.println("bed_no:"+bed_no);
		billing_group = request.getParameter("billing_group");
		//System.out.println("billing_group:"+billing_group);
		//title = request.getParameter("title");
		try{
			stmt = con.prepareStatement( "SELECT 'X' FROM BL_USERS_FOR_HOSP_REQ_TFR WHERE OPERATING_FACILITY_ID='"+facility_id+"' and AUTH_USER_ID='"+loginUser+"'");	
			rs = stmt.executeQuery();	
			while(rs!=null && rs.next())
			{
				x_valid_user  =  rs.getString(1);
			}
			if(x_valid_user==null) x_valid_user="";			
			rs.close();
			stmt.close();
		}catch(Exception ss)
		{
			System.out.println("Exception in BL_USERS_FOR_HOSP_REQ_TFR"+ss);
			ss.printStackTrace();
		}

		
	}catch (Exception e)
	{ out.println ("Exception :"+e); }
	finally
	{
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}

%>
 <title><fmt:message key="eBL.BLNG_CLASS_ELIG_PKG.label" bundle="${bl_labels}"/></title>
		<script>

		function storeVal(obj)
		{
			
			radioval = eval(obj).value;
		}
		function chkReq()
		{
			if(radioval=='P')
			{
				//alert("Package Subscribed with Different Billing Class");
				alert(getMessage("BL8675","BL"));
				parent.window.returnValue='N';
				parent.window.close();
			}else
			{
				var x_valid_user=document.forms[0].x_valid_user.value;
				var radioval_hosp = eval("document.forms[0].hosp_request");
				if(x_valid_user!='X')
				{
						alert(getMessage("BL9539","BL"));
					radioval_hosp.checked=false;
				//	return false;
				}else{
					parent.window.returnValue='Y';
					parent.window.close();
				}
			}

		}
		function validate()
		{	
			var radioval_pat = eval("document.forms[0].pat_request");
			var radioval_hosp = eval("document.forms[0].hosp_request");
			if(radioval_hosp.checked==false || radioval_pat.checkedt==false )
			{
				//alert("Please Select either Patient or Hospital Request");			
					alert(getMessage("BL8650","BL"));
				return false;
			}
		}
</script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<br>


<table width='100%' border='0' cellspacing='0' cellpadding='3' align='center'>


</table>
<table width='100%' border='0' cellspacing='0' cellpadding='3' align='center'>

	<tr>
		<td  class='fields' width="25%"><input type='radio' name='pat_request' id='pat_request' value='P' onClick='storeVal(this);chkReq()'  ><fmt:message key="eBL.PATIENT_REQUEST.label" bundle="${bl_labels}"/></td>
		<td  width="25%" class='label'></td>		
		<td class='fields' width="25%"><input type='radio' name='hosp_request' id='hosp_request' value='H' onClick='storeVal(this);chkReq()'><fmt:message key="eBL.HOSPITAL_REQUEST.label" bundle="${bl_labels}"/></td>
		<!--	<td id = '' class='label' width="25%"></td>
		<td id = '' class="fields" width="25%"><input type='hidden' name='BedTypeCode' id='BedTypeCode' value=''></td>
		<td  width="25%">--></td>
	</tr>


	<tr>
  	  <td  width="25%" class='label'>&nbsp;</td>
		<td  width="25%" class='label'>&nbsp;</td>	
	
		<td class='fields' width="25%"><input type='button' name='CANCEL' id='CANCEL' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='validate()' class='button'></td>		
		
	</tr>
</table>

	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
	<input type= hidden name="x_valid_user" id="x_valid_user"  value='<%=x_valid_user%>'>
	</form>
</body>
</html>

