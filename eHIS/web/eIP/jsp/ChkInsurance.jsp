<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8"); 
	Connection	con	= null;
	CallableStatement cstmt = null;
	String	credit_auth_ref			=	"",		credit_auth_date		=	"";
	String	app_days				=	"",		app_amount				=	"";
	String	eff_frm_date			=	"",		insTrackDtlsExists		=	"";
	String value2 = request.getParameter("value2");
	if (value2==null) value2="";
	String facilityId = (String) session.getValue("facility_id");
	try
	{
		con	= ConnectionManager.getConnection(request);
		cstmt = con.prepareCall("{ call BL_CHK_INS_CR_AUTH_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
		cstmt.setString(1,value2);
		cstmt.setString(2,facilityId);
		cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(7,java.sql.Types.DATE);
		cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(9,java.sql.Types.DATE);
		cstmt.registerOutParameter(10,java.sql.Types.DATE);
		cstmt.registerOutParameter(11,java.sql.Types.INTEGER);
		cstmt.registerOutParameter(12,java.sql.Types.INTEGER);
		cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);

		cstmt.execute();
		
		credit_auth_ref		=	cstmt.getString(8);
		if (credit_auth_ref==null) credit_auth_ref = "";
		credit_auth_date	=	cstmt.getString(9);
		if (credit_auth_date==null) credit_auth_date = "";
		eff_frm_date		=	cstmt.getString(10);
		if (eff_frm_date==null) eff_frm_date = "";
		app_days			=	cstmt.getString(11);
		if (app_days==null) app_days = "";
		app_amount			=	cstmt.getString(12);
		if (app_amount==null) app_amount = "";
		insTrackDtlsExists	=	cstmt.getString(13);
		if (insTrackDtlsExists==null) insTrackDtlsExists = "";
		%>
		<script>
			var eff_dt = new Array();
			var dt = new Array();
			var effective_dt = "";
			var cr_auth_dt = "";

			if(!('<%=eff_frm_date%>' == null || '<%=eff_frm_date%>' == '')) 
			{
				var eff_dt_str = '<%=eff_frm_date%>';
				if(eff_dt_str==null) 
					eff_dt_str="";
				eff_dt	=	eff_dt_str.split("-");
				if(eff_dt[2]!=null) 
					dt		=	eff_dt[2].split(" ");
				if(dt[0]!='undefined' && eff_dt[1]!='undefined' && eff_dt[0]!='undefined')
				{
					effective_dt = dt[0]+"/"+eff_dt[1]+"/"+eff_dt[0]
				}
			}
			if(!('<%=credit_auth_date%>' == null || '<%=credit_auth_date%>' == '')) 
			{
				var cr_dt = new Array();
				var dt1 = new Array();
				var cr_dt_str = '<%=credit_auth_date%>';
				if(cr_dt_str==null) cr_dt_str="";
					cr_dt = cr_dt_str.split("-");
				if(cr_dt[2]!=null) 
					dt1 = cr_dt[2].split(" ");
				if(dt1[0]!='undefined' && cr_dt[1]!='undefined' && cr_dt[0]!='undefined')
				{
					cr_auth_dt = dt1[0]+"/"+cr_dt[1]+"/"+cr_dt[0]
				}
			}
			parent.frames[1].frames[2].AdmitPatient_form.credit_auth_ref.value="<%=credit_auth_ref%>";
			parent.frames[1].frames[2].AdmitPatient_form.credit_auth_date.value=cr_auth_dt;
			parent.frames[1].frames[2].AdmitPatient_form.app_days.value="<%=app_days%>";
			parent.frames[1].frames[2].AdmitPatient_form.app_amount.value="<%=app_amount%>";
			parent.frames[1].frames[2].AdmitPatient_form.eff_frm_date.value=effective_dt;
			parent.frames[1].frames[2].AdmitPatient_form.insTrackDtlsExists.value="<%=insTrackDtlsExists%>";
			</script>
<%
		if(cstmt!=null) cstmt.close();

	}catch(Exception e)
	{
		out.println("Exception "+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
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

