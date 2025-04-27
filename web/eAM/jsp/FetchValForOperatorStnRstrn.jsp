<!DOCTYPE html>
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<%request.setCharacterEncoding("UTF-8");%>

<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%
	String sql="";
	Connection con =null;
	Statement stmt = null;
	Statement stmt2 = null;
	Statement st=null;
	ResultSet rset=null;
	ResultSet rset1=null;
	
	ResultSet rs=null;
	Statement stm= null;
	
	ResultSet rset2=null;
	String code="";
	String desc="";
	String fid=request.getParameter("fid")==null?"":request.getParameter("fid");
	
	con =ConnectionManager.getConnection(request);
    if( !(fid.trim().equals("")))
	{	%>
		<script language="JavaScript">
			var f=parent.parent.frames[1].frames[0]
		</script>
<%	try
	{     
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		String locationtype=request.getParameter("locationtype");
		String oid=request.getParameter("oprstn");
		String comp=" ";
		String comp2=" ";
		StringBuffer sql1=new StringBuffer();
		String sel=request.getParameter("selval");
    
		stmt = con.createStatement();
		stmt2 = con.createStatement();
		st=con.createStatement();
	
		if(name!=null)
			name=name.trim();

		if(fid!=null)
			fid=fid.trim();

		if(sel!=null)
			sel=sel.trim();
			
		if(name.equals("oprstnid"))
		{			
			comp="f.document.forms[0].locationtype";
	
			sql1.append(" select a.appl_user_id user_id,b.appl_user_name user_name from ");
			sql1.append(" am_user_for_oper_stn a, sm_appl_user b      ");
			sql1.append(" where a.appl_user_id = b.appl_user_id	     ");	
			sql1.append(" and a.oper_stn_id='"+oid+"' and a.facility_id='"+fid+"' and trunc(sysdate) between trunc(a.eff_date_from) and trunc(nvl(a.eff_date_to,sysdate)) order by 2 ");

			String sql2=" SELECT oper_stn_type FROM  am_oper_stn WHERE  facility_id='"+fid+"' and  oper_stn_id ='"+oid+"' ";
			stm=con.createStatement();
			rs=stm.executeQuery(sql2);
			rs.next();
			String operation_stn_type = rs.getString("oper_stn_type");
			if(operation_stn_type == null) operation_stn_type="";

			if (rs != null)   rs.close();
            if (stm != null) stm.close();

			rset2= stmt2.executeQuery(sql1.toString());

			comp2="f.document.forms[0].user";
			out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'>");
			
			
			if(rset2 != null)
			{
				while( rset2.next() )
				{
					code=rset2.getString(1);
					desc=rset2.getString(2);
				%>
					<script>
						var temp = "<%=code%>";
						var temp1="<%=desc%>";
						var opt=f.document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						var comp2=<%=comp2%>
						//comp2.add(opt)
					</script>
					<%
					}
				out.println("<script>parent.parent.frames[1].frames[0].document.forms[0].operation_stn_type.value='"+operation_stn_type+"' </script>");
			}

			if (rset2 != null)   rset2.close();
            if (stmt2 != null) stmt2.close();
/*
			String instring = "";
			if(oper_stn_type.equals("I"))
				 instring = "N";
			else if(oper_stn_type.equals("O"))
				instring = "C','D','E";
			else
				instring = "C','N','D','E";
			 String locntypesql = " SELECT   CARE_LOCN_TYPE_IND||'#'||LOCN_TYPE locn_type, SHORT_DESC from am_care_locn_type where CARE_LOCN_TYPE_IND in ('"+instring+"') order by 2 ";
*/
			String locntypesql = "";
			if (operation_stn_type.equals("O"))
			{					
				locntypesql = " select locn_type, short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and locn_type in ('C','E','Y') order by upper(short_desc) ";
			}
			else if (operation_stn_type.equals("I"))
			{
				locntypesql = " select locn_type, short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and locn_type in ('N') order by upper(short_desc) ";
			}
			else if (operation_stn_type.equals("B"))
			{
				locntypesql = " select locn_type, short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and locn_type in ('C','E','Y','N') order by upper(short_desc) ";
			}
			
			if(stmt2 != null )stmt2.close();
			if(rset2 != null )rset2.close();
			stmt2 = con.createStatement();
			rset2= stmt2.executeQuery(locntypesql);
			while(rset2.next())
			{	
				%>				
				<script>
					var oOption = f.document.createElement("OPTION");
					oOption.text =	"<%=rset2.getString("SHORT_DESC")%>";
					oOption.value=	"<%=rset2.getString("LOCN_TYPE")%>";
					f.document.getElementById('locationtype').add(oOption);
				</script>
<%
			}
			
			 if (rset2 != null)   rset2.close();
             if (stmt2 != null) stmt2.close();
		}
		
		
		if(name.equals("locationtype"))
		{
			sql="select CARE_LOCN_TYPE_IND  from am_care_locn_type where LOCN_TYPE ='"+value+"'";
			String ind= "";
			rset1=st.executeQuery(sql);
			if(rset1.next())
				ind=rset1.getString("CARE_LOCN_TYPE_IND");
			
			if (rset1 != null)   rset1.close();
            if (st != null) st.close();

			if(ind.equals("R"))
				sql=" Select room_num,short_desc from am_facility_room where operating_facility_id = '"+fid+"' and RESIDENT_STAY_YN = 'N'  and ROOM_TYPE='"+locationtype+"' order by short_desc";

			else if(ind.equals("C"))
				sql="Select clinic_code,long_desc from op_clinic where facility_id = '"+fid+"' and clinic_type='"+locationtype+"' and eff_status = 'E' order by long_desc";
			
			else if (ind.equalsIgnoreCase("N"))
				sql="Select NURSING_UNIT_CODE,long_desc from  ip_nursing_unit where facility_id = '"+fid+"' and eff_status = 'E' and locn_type='"+locationtype+"' order by long_desc";
			
			else if (ind.equalsIgnoreCase("S"))
				sql="Select store_code,short_desc from  st_store  where facility_id = '"+fid+"' and eff_status = 'E'  order by short_desc";

			comp="f.document.forms[0].locationid";
		}

		if(sql!=null && !sql.equals(""))
			stmt = con.createStatement();
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
			var opt=f.document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=<%=comp%>
			comp.add(opt)
	</script>
<%
		}
		}
		if (rset1 != null)   rset1.close();
        if (stmt != null) stmt.close();
	}
	catch(Exception e){e.toString();}

	finally {
	  if (stmt != null) stmt.close();
	  if (rset != null)   rset.close();
	  if (rset1 != null)   rset1.close();
	  if(st !=null) stm.close();
	  if(rs !=null) rs.close();
	 ConnectionManager.returnConnection(con,request);
	}
	}
	else
	{
        
	
%>
<script language="JavaScript">

var f=parent.parent.frames[1].frames[0]
//var f = parent.frames[1].frames[0];


</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
	
	
	String facid="";
   String	oper_stn_id="";
  String	short_desc="";
   String stb="";
	try
	{
	  //con = ConnectionManager.getConnection(request);
	   stmt = con.createStatement();
			facid=request.getParameter("facid")==null?"":request.getParameter("facid");
	      	
     	   stb= "SELECT oper_stn_id,short_desc  from  am_oper_stn where  facility_id = '"+facid+"' and eff_status= 'E' order by short_desc ";
        
		   rs = stmt.executeQuery(stb) ;
		   	if(rs!=null)
			    {
					while (rs.next())
					{			
                
						 oper_stn_id = rs.getString(1);	
						 if(oper_stn_id==null) oper_stn_id="";
						 
				 
						 short_desc = rs.getString(2);
						 if(short_desc==null) short_desc="";
					%>
				<script>
	                  
					var opt =f.document.createElement("OPTION");
					
					//opt=parent.frames[1].frames[1].document.createElement("OPTION");
				   	opt.text='<%=short_desc%>';
				    opt.value='<%=oper_stn_id%>';
					f.document.getElementById('oprstnid').add(opt);
		         </script>
         <%}
		}
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		finally
		{
			ConnectionManager.returnConnection(con,request); 
		}
		
	
	}
	%>
</html>

