<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import= "java.sql.*,webbeans.op.CurrencyFormat" %>
<script language="JavaScript">
	async function crAuthorize(patId,outAmt) {

		var retVal = new Array();
		var dialogHeight= "19" ;
		var dialogWidth	= "34" ;
		var dialogTop = "170" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../eBL/jsp/dispCreditAuth.jsp?patient_id="+patId+"&outst_amt="+outAmt,arguments,features);
		if(retVal[0]=='N') {
			parent.Select_frame.document.forms[0].patient_id.value='';
			parent.Select_frame.document.forms[0].patient_id.focus();
			parent.Select_frame.document.forms[0].encounter_id.focus();
			parent.Select_frame.document.forms[0].patient_id.focus();
		}
		else { InsureChk(patId);}
		
	}
	function InsureChk(patId) {
		var HTMLVal = new String();
		if( patId != "" || patId !=null ) {
			HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='InsureChk' id='InsureChk' method='post' action='../../eBL/jsp/IPAdmitInsureChk.jsp'><input name='patientId' id='patientId' type='hidden' value='"+patId+"'></form></BODY></HTML>";
			document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			document.InsureChk.submit();
		}
	}

</script>
<head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8"); 
	String patId = request.getParameter("patientId");
	String facilityId = (String)session.getValue("facility_id"); 

	boolean isBlInterfaced=false;
	Connection con = null;
	Statement stmt = null;
	CallableStatement cstmt = null;
	ResultSet rs1 = null;
	int retVal=0;
	int minOutstAmt = 0;
	String crAuth = "N";
	String strRetval="";
	
	try {
		con = (Connection) session.getValue("connection");
		stmt = con.createStatement();
		rs1 = stmt.executeQuery("Select BL_INTERFACED_YN,nvl(OUTST_AMT_LIMIT,0) OUTST_AMT_LIMIT,nvl(CREDIT_AUTH_REQD_YN,'N')CREDIT_AUTH_REQD_YN from ip_param where facility_id='"+facilityId+"'");
		if(rs1.next()) {
			minOutstAmt = rs1.getInt("OUTST_AMT_LIMIT");
			crAuth = rs1.getString("CREDIT_AUTH_REQD_YN");
			if(rs1.getString("BL_INTERFACED_YN").equals("Y")) isBlInterfaced=true;
			else isBlInterfaced=false;
		}
		
		if(isBlInterfaced) 
		{
			cstmt = con.prepareCall("{ call BL_CALCULATE_OUTST_AMT(?,?) }");
			cstmt.setString(1,patId);
			cstmt.registerOutParameter(2,2);
			cstmt.execute();
			retVal= cstmt.getInt(2);
			strRetval =""+retVal;

			CurrencyFormat cf1 = new CurrencyFormat();
			strRetval = cf1.formatCurrency(strRetval, 2);

			if(retVal>0){
				out.println("<script>parent.Pline_frame.document.getElementById('outstdAmt').innerText='Outstanding Amt.  "+strRetval+"    '</script>");
			}
			if( (retVal>minOutstAmt) && crAuth.equals("Y") ){
				out.println("<script>crAuthorize('"+patId+"','"+retVal+"');</script>");
			}
			else {
				out.println("<script>InsureChk('"+patId+"');</script>");	
			}
		}
		
	
		if(rs1!=null) rs1.close();
		if(cstmt!=null) cstmt.close();
		if(stmt!=null) stmt.close();
	
	}catch(Exception e) {
		out.println(e.toString());
	}
	finally {
	}
%>
</body>

