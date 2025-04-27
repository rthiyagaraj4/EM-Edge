<!DOCTYPE html>
<%--
FileName	: md_FetchValForLocnForOperator.jsp
Version	    : 3	
Modified On	: 23-2-2005
--%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%
StringBuffer sql=new StringBuffer(" ");
Connection con = null;

Statement stmt = null;
Statement st=null;
ResultSet rset=null;
ResultSet rset1=null;
String code="";
String desc="";
String comp=" ";
String oper_stn_type="";
String name=request.getParameter("name");
String value=request.getParameter("value");
String fid=request.getParameter("fid");
String loctype=request.getParameter("loctype");
String oid=request.getParameter("oprstn");
String sel=request.getParameter("selval");
String operating_facilityID = request.getParameter("operating_facilityID");
if(operating_facilityID == null) operating_facilityID="";

try
{
	con = ConnectionManager.getConnection(request);

	st=con.createStatement();

	if(name!=null)
	name=name.trim();

	if(fid!=null)
	fid=fid.trim();

	if(sel!=null)
	sel=sel.trim();

	sql.setLength(0);

	sql.append("select oper_stn_type from am_oper_stn where facility_id='"+fid+"' and oper_stn_id='"+oid+"'");

	rset1= st.executeQuery(sql.toString());
	if(rset1.next())
	oper_stn_type    = rset1.getString("oper_stn_type")==null ?"":rset1.getString("oper_stn_type");

	if(name.equals("oprstn"))
	{
		if (oper_stn_type.equals("O"))
		{	
			sql.setLength(0);
			sql.append("select locn_type,short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and care_locn_type_ind != 'N'  order by upper(short_desc)");
		}
		else if (oper_stn_type.equals("I"))
		{
			sql.setLength(0);
			sql.append("select locn_type,short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and care_locn_type_ind = 'N' order by upper(short_desc) ");
		}
		else if (oper_stn_type.equals("B"))
		{
			sql.setLength(0);
			sql.append("select locn_type,short_desc from am_care_locn_type where sys_user_def_ind = 'S' order by upper(short_desc) ");
		}
		comp="parent.f_query_add_mod.f_query_add_mod_query.document.forms[0].loctype";
	}
	if(rset1!=null)rset1.close();

	if(name.equals("loctype"))
	{
		sql.setLength(0);
		sql.append("select CARE_LOCN_TYPE_IND  from am_care_locn_type where LOCN_TYPE ='"+value+"'");
		rset1=st.executeQuery(sql.toString());
		rset1.next();
		String ind=rset1.getString("CARE_LOCN_TYPE_IND");
		if(ind.equalsIgnoreCase("C"))
		{	
			sql.setLength(0);
			sql.append("Select clinic_code,long_desc from op_clinic where facility_id = '"+fid+"' and clinic_type='"+loctype+"' and eff_status = 'E' order by upper(long_desc)");
		}
		else if (ind.equalsIgnoreCase("N"))
		{
			sql.setLength(0);
			sql.append("Select NURSING_UNIT_CODE,long_desc from  ip_nursing_unit where facility_id = '"+fid+"' and eff_status = 'E' and locn_type='"+loctype+"' order by upper(long_desc)");
		}
		comp="parent.f_query_add_mod.f_query_add_mod_query.document.forms[0].locid";
	}

	if(name.equals("fromFac"))
	{
		sql.setLength(0);
		sql.append("SELECT  oper_stn_id,short_desc  FROM  am_oper_stn WHERE  facility_id='"+operating_facilityID+"' " +
		" and EFF_STATUS='E'  ORDER BY short_desc");

		comp="parent.f_query_add_mod.f_query_add_mod_query.document.forms[0].oprstn";
	}

	if(rset!=null)rset.close();
	stmt = con.createStatement();
	rset = stmt.executeQuery(sql.toString());

	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script></HEAD><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
	if(rset != null)
	{
		while( rset.next() )
		{
			code =	rset.getString(1);
			desc =	rset.getString(2);
		%>
			<script>
				var temp = "<%=code%>";
				var temp1="<%=desc%>";
				var opt=parent.f_query_add_mod.f_query_add_mod_query.document.createElement("OPTION");
				//var opt=parent.f_query_add_mod.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				var comp=<%=comp%>
				comp.add(opt);
			</script>
	<%	}
	}
}catch(Exception e){e.toString();}
finally
{
	try
	{
		if (rset != null)   rset.close();
		if (rset1 != null)   rset1.close();
		if (stmt != null) stmt.close();
		if (st != null) st.close();
	}catch(Exception e)
	{}
	ConnectionManager.returnConnection(con,request);
}
%>

