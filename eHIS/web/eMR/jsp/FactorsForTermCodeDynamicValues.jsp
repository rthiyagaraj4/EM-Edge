<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"%>

<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onKeyDown='lockKey()'>
<form name='fact_for_dynaval' id='fact_for_dynaval'>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String factor_val = request.getParameter("factor_val")==null?"":request.getParameter("factor_val");
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");
%>
<INPUT TYPE="hidden" name='chkselect' id='chkselect' value="<%=factor_val%>">
</form>
</body>
</html>
<%
				 RecordSet FactorsForTermCodebn	=	null;
							   ArrayList arr_factor = null;
try
{
	con = ConnectionManager.getConnection(request);
	
	
	FactorsForTermCodebn = (webbeans.eCommon.RecordSet)	session.getAttribute("FactorsForTermCodebn");
	if(factor_val.equals("FACTORSCLEARED"))
		FactorsForTermCodebn.clearAll();
	else if(factor_val.equals("FACTORSSELECTED"))
	{
		String sql_factors = "select factor_code, long_desc factor_desc,	decode(defn_characteristic_yn,'Y','Defining Characteristics',		decode(related_factor_yn||risk_factor_yn,'YY','Related & Risk Factor','YN','Related Factor','NY','Risk Factor'))factor_type,defn_characteristic_yn,related_factor_yn,risk_factor_yn,'I' db_action from mr_factor where factor_code not in (select factor_code from mr_factor_for_term_code where term_set_id = ? and term_code =?) and eff_status = 'E' union all select a.factor_code, b.long_desc factor_desc, decode(b.defn_characteristic_yn,'Y','Defining Characteristic',		decode(b.related_factor_yn||b.risk_factor_yn,'YY','Related & Risk Factor','YN','Related Factor','NY','Risk Factor')) factor_type,b.defn_characteristic_yn,b.related_factor_yn,b.risk_factor_yn,'U' db_action  from mr_factor_for_term_code a, mr_factor b where a.term_set_id = ? and a.term_code = ? and b.factor_code=a.factor_code order by factor_desc";
		FactorsForTermCodebn.clearAll();
		pstmt = con.prepareStatement(sql_factors);
		pstmt.setString(1,term_set_id);
		pstmt.setString(2,term_code);
		pstmt.setString(3,term_set_id);
		pstmt.setString(4,term_code);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				arr_factor = new ArrayList();
				arr_factor.add(rs.getString("factor_code"));
				arr_factor.add(rs.getString("defn_characteristic_yn"));
				arr_factor.add(rs.getString("related_factor_yn"));
				arr_factor.add(rs.getString("risk_factor_yn"));
				FactorsForTermCodebn.putObject(arr_factor);
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
	}
	if ( arr_factor != null ) arr_factor.clear();
}
catch (Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con);
}
%>

