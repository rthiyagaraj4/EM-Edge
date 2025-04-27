<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%
request.setCharacterEncoding("UTF-8");
	String sql=" ";
		Connection con = null;

		Statement stmt = null;
		Statement st=null;
		ResultSet rset=null;
		ResultSet rset1=null;
		String code="";
		String desc="";
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		String fid=request.getParameter("fid").trim();
		String loctype=request.getParameter("loctype");
		String oid=request.getParameter("oprstn");
		String comp=" ";
		//String comp1=" ";
	//	String sql1=null;
		//String func=request.getParameter("function");
		String sel=request.getParameter("selval");
		String oper_stn_type="";

	try
	{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	st=con.createStatement();
	
		if(name!=null)
			name=name.trim();

		if(fid!=null)
			fid=fid.trim();

		if(sel!=null)
			sel=sel.trim();

	
		sql="select oper_stn_type from am_oper_stn where facility_id='"+fid+"' and oper_stn_id='"+oid+"'";

		rset1= st.executeQuery(sql);
		if(rset1.next())
			oper_stn_type    = rset1.getString("oper_stn_type")==null ?"":rset1.getString("oper_stn_type");

		if(name.equals("oprstn"))
		{
			if (oper_stn_type.equals("O"))
			{
				sql="select locn_type,short_desc from am_care_locn_type where CARE_LOCN_TYPE_IND = 'C' ";
			}
			else if (oper_stn_type.equals("I"))
			{
				sql="select locn_type,short_desc from am_care_locn_type where CARE_LOCN_TYPE_IND = 'N' ";
			}
			else if (oper_stn_type.equals("B"))
			{
				sql="select locn_type,short_desc from am_care_locn_type where CARE_LOCN_TYPE_IND in('C','N') ";
			}
			comp="parent.document.frames[1].document.forms[0].loctype";
		}
		if(name.equals("loctype"))
		{
			sql="select CARE_LOCN_TYPE_IND  from am_care_locn_type where LOCN_TYPE ='"+value+"'";
			 rset1=st.executeQuery(sql);
			 rset1.next();
			String ind=rset1.getString("CARE_LOCN_TYPE_IND");
/*
			if(res.equals("N") && ind.equals("R"))
				sql=" Select room_num,short_desc from am_facility_room where operating_facility_id = '"+fid+"' and RESIDENT_STAY_YN = 'N'  and ROOM_TYPE='"+loctype+"' order by short_desc";

			else 
*/			 
			if(ind.equalsIgnoreCase("C"))
				sql="Select clinic_code,long_desc from op_clinic where facility_id = '"+fid+"' and clinic_type='"+loctype+"' and eff_status = 'E' order by long_desc";
			
			else if (ind.equalsIgnoreCase("N"))
				sql="Select NURSING_UNIT_CODE,long_desc from  ip_nursing_unit where facility_id = '"+fid+"' and eff_status = 'E' and locn_type='"+loctype+"' order by long_desc";
/*			
			else if (ind.equalsIgnoreCase("S"))
				sql="Select store_code,short_desc from  st_store  where facility_id = '"+fid+"' and eff_status = 'E'  order by short_desc";
*/
			comp="parent.document.frames[1].document.forms[0].locid";
		}
		  if (rset1 != null) rset1.close();
          if (st != null) st.close();

			if(sql!=null || sql.equals(""))
				rset = stmt.executeQuery(sql);

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
		if(rset != null)
		{
		while( rset.next() )
		{
			code=rset.getString(1);
			desc=rset.getString(2);
%>
	<script>
			var temp = "<%=code%>";
			var temp1="<%=desc%>";
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			//parent.document.frames[1].document.forms[0].clinic.add(opt);
			var comp=<%=comp%>
			comp.add(opt);
		
			//parent.document.frames[1].document.getElementById("opr_type").innerText="<%=oper_stn_type%>";

			//parent.document.frames[1].document.getElementById("opr_type").style.visibility='visible';


	</script>
<%
		}
		}
		if (rset != null) rset.close();
        if (stmt != null) stmt.close();
	}
	catch(Exception e){e.toString();}

finally {
  if (rset != null)   rset.close();
  if (rset1 != null)   rset1.close();
  if (stmt != null) stmt.close();
  if (st != null) st.close();
  ConnectionManager.returnConnection(con,request);
}
%>

