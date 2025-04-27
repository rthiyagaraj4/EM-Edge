<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eIP/js/Booking.js' language='javascript'></script>
	<script src='../../eIP/js/Booking1.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt		=	null;
	ResultSet rs		=	null;
	String facilityid = (String) session.getValue("facility_id");
	StringBuffer str			=	new StringBuffer();
	String SelectType	= request.getParameter("SelectType");
	String med_code		= request.getParameter("med_code");
	String spy_code		= request.getParameter("spy_code");
	String prt_code		= request.getParameter("prt_code");
	String p_code		= "";
	String p_desc		= "";

	if (med_code==null) med_code="";
	if (spy_code==null) spy_code="";
	if (prt_code==null) prt_code="";

try
{
	con = ConnectionManager.getConnection(request);
	stmt= con.createStatement();

	if (SelectType.equals("M"))
	{
		str.append("SELECT nursing_unit_code,Short_desc FROM IP_NURSING_UNIT WHERE FACILITY_ID='"+facilityid+"' AND NURSING_UNIT_TYPE_CODE IN (SELECT NURSING_UNIT_TYPE_CODE FROM IP_MED_SER_GRP_NURS_UT_TYPE WHERE MED_SER_GRP_CODE='"+med_code+"' AND FACILITY_ID='"+facilityid+"') AND EFF_STATUS='E'  order by 2 ");
	}
	else if (SelectType.equals("S"))
	{
		str.append(" SELECT nursing_unit_code,Short_desc FROM IP_NURSING_UNIT WHERE FACILITY_ID='"+facilityid+"' AND EFF_STATUS='E' AND NURSING_UNIT_TYPE_CODE IN (SELECT NURSING_UNIT_TYPE_CODE FROM IP_MED_SER_GRP_NURS_UT_TYPE WHERE MED_SER_GRP_CODE='"+med_code+"' AND FACILITY_ID='"+facilityid+"') AND NURSING_UNIT_CODE IN (SELECT NURSING_UNIT_CODE FROM IP_NURS_UNIT_FOR_SPECIALTY WHERE SPECIALTY_CODE='"+spy_code+"' AND FACILITY_ID='"+facilityid+"') ORDER BY 2 ");
	}
	else if (SelectType.equals("P"))
	{
		str.append(" SELECT a.nursing_unit_code,a.Short_desc FROM IP_NURSING_UNIT a, IP_MED_SER_GRP_NURS_UT_TYPE b, IP_NURS_UNIT_FOR_SPECIALTY c,IP_NURSING_UNIT_FOR_PRACT D WHERE a.FACILITY_ID='"+facilityid+"' AND A.EFF_STATUS='E' AND B.MED_SER_GRP_CODE='"+med_code+"' AND A.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID=C.FACILITY_ID AND A.FACILITY_ID=D.FACILITY_ID AND A.NURSING_UNIT_CODE=C.NURSING_UNIT_CODE AND A.NURSING_UNIT_CODE=D.NURSING_UNIT_CODE AND A.NURSING_UNIT_TYPE_CODE=B.NURSING_UNIT_TYPE_CODE AND C.SPECIALTY_CODE='"+spy_code+"' AND D.PRACTITIONER_ID='"+prt_code+"' ");
	}

	rs = stmt.executeQuery(str.toString());

	if(rs != null)
	{

		while (rs.next())
		{
			p_code				= rs.getString("nursing_unit_code");
			p_desc				= rs.getString("Short_desc");
	%>
			<script>
				var temp = "<%=p_code%>";
				var temp1="<%=p_desc%>";
				var opt=parent.frames[2].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.frames[1].document.forms[0].nursing_unit.add(opt);
			</script>
	<%
		}
  }
  		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
}catch (Exception e)
{out.println("Exception in tryCatch : "+ e.toString());}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
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

