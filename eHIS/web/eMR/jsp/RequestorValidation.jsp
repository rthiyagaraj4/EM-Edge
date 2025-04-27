<!DOCTYPE html>
<html>
<head>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body class='message' onKeyDown='lockKey()'>         
<%@page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.ConnectionManager" %>
<%
		request.setCharacterEncoding("UTF-8");
		String pr_id = request.getParameter("process_id");
		if (pr_id==null||pr_id.equals("null"))
			pr_id="";
		ResultSet rs=null;
		PreparedStatement stmt=null;
		int process = 0;
		if (!pr_id.equals(""))
			process = Integer.parseInt(pr_id);
		Connection con = ConnectionManager.getConnection(request);
        try
        {

// FOR POPULATING THE town list WHEN area list HAS BEEN SELECTED...........
        if ( process == 7 )
        {
        String postal_code = request.getParameter("r_postal");
		if (postal_code==null) postal_code ="";
		String res_area_code = request.getParameter("r_area");
		if (res_area_code==null) res_area_code ="";
		String region_code = request.getParameter("r_region");
		if (region_code==null) region_code ="";
		String res_town_code = request.getParameter("r_town");
		if (res_town_code==null) res_town_code ="";
		String fieldName ="";
		String fieldName1 ="";
		String fieldName2 ="";
		String fieldName3 ="";
		String fieldName4 ="";
		String fieldName5 ="";
        String mode = request.getParameter("mode") ;
		if (mode==null) mode="";
		
		String sql = "";
		
		if(mode.equals("r_postal_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_area_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_area";
			fieldName4 = "r_region";
	   }
       else if(mode.equals("r_town_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_area";
			fieldName4 = "r_region";
	   }
	   else if(mode.equals("r_area_code")){
			fieldName = "r_town_code";
			fieldName1 = "r_postal_code";
			fieldName2 = "r_region_code";
			fieldName3 = "r_area";
			fieldName4 = "r_region";
	   }
	  else if(mode.equals("r_region_code")){
			fieldName = "r_area_code";
			fieldName1 = "r_town_code";
			fieldName2 = "r_postal_code";
			fieldName3 = "r_area";
			fieldName4 = "r_region";
		}
		//Defaulting area, town, region based on selection.	
        if (!postal_code.equals(""))
		{
			String town_code="";
			
			sql = "select a.res_town_code, b.long_desc res_town_desc from mp_postal_code a, mp_res_town b where a.postal_code = '"+postal_code+"' and a.res_town_code = b.res_town_code";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{

				town_code = rs.getString(2);
				if (town_code==null) town_code="";
				out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName+" !=null) parent.frames[1].document.forms[0]."+fieldName+".value='"+town_code+"';");

				out.println("parent.frames[1].document.forms[0]."+fieldName5+".value='"+(rs.getString("res_town_code")==null ? "" : rs.getString("res_town_code"))+"'; </script>");

				sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area a, mp_region b where res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+rs.getString(1)+"') and a.region_code = b.region_code" ;
				if ( stmt != null ) stmt.close();
				if ( rs != null ) rs.close();

				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if (rs.next())
				{
				out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName1+" != null) parent.frames[1].document.forms[0]."+fieldName1+".value='"+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"';");
				 
				 out.println("if (parent.frames[1].document.forms[0]."+fieldName2+" !=null) parent.frames[1].document.forms[0]."+fieldName2+".value='"+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"';");
				 out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='"+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"';");
				 out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='"+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"';</script>");
				}
			}
		}
		if (!res_town_code.equals(""))
		{
			sql = "select a.res_area_code, a.long_desc res_area_desc, b.region_code, b.long_desc region_desc from mp_res_area a, mp_region b where res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"') and a.region_code = b.region_code ";

			if ( stmt != null ) stmt.close();
			if ( rs != null ) rs.close();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{
			     out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName+" != null) parent.frames[1].document.forms[0]."+fieldName+".value='"+(rs.getString("res_area_desc")==null ? "" : rs.getString("res_area_desc"))+"';");
				 
				 out.println("if (parent.frames[1].document.forms[0]."+fieldName2+" !=null) parent.frames[1].document.forms[0]."+fieldName2+".value='"+(rs.getString("region_desc")==null ? "" : rs.getString("region_desc"))+"';");
				 out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='"+(rs.getString("res_area_code")==null ? "" : rs.getString("res_area_code"))+"';");
				 out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='"+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"';</script>");
			}	
			sql="select postal_code from mp_postal_code where res_town_code = '"+res_town_code+"'";

			if ( stmt != null ) stmt.close();
			if ( rs != null ) rs.close();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{
				out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName1+" !=null) parent.frames[1].document.forms[0]."+fieldName1+".value = '"+(rs.getString("postal_code")==null ? "" : rs.getString("postal_code"))+"'</script>");

			}
			else{
			out.println("<script>parent.frames[1].document.forms[0]."+fieldName1+".value=''</script>");
			}
	}
		if (!res_area_code.equals(""))
		{
			sql = "select region_code,long_desc from mp_region where region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			
			if ( stmt != null ) stmt.close();
			if ( rs != null ) rs.close();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next())
			{
			out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName+" !=null) parent.frames[1].document.forms[0]."+fieldName+".value='';");
			out.println("if (parent.frames[1].document.forms[0]."+fieldName1+" !=null) parent.frames[1].document.forms[0]."+fieldName1+".value='';");
			out.println("if (parent.frames[1].document.forms[0]."+fieldName2+" !=null) parent.frames[1].document.forms[0]."+fieldName2+".value='"+(rs.getString("long_desc")==null ? "" : rs.getString("long_desc"))+"';");
			out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='';");	out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='"+(rs.getString("region_code")==null ? "" : rs.getString("region_code"))+"';</script>");
			stmt.close();
				
			}
			else
			{
			out.println("<script>if (parent.frames[1].document.forms[0]."+fieldName+" ) parent.frames[1].document.forms[0]."+fieldName+".value='';");
			out.println("if (parent.frames[1].document.forms[0]."+fieldName1+") parent.frames[1].document.forms[0]."+fieldName1+".value='';");
			out.println("if (parent.frames[1].document.forms[0]."+fieldName2+" ) parent.frames[1].document.forms[0]."+fieldName2+".value='';");
			out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='';");
			out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='';</script>");
			}
			out.println("<script>parent.frames[1].document.forms[0]."+fieldName1+".focus();</script>");
			if ( stmt != null ) stmt.close();
			if ( rs != null ) rs.close();
		}
		if (!region_code.equals(""))
		{
				
		out.println("<script>if(parent.frames[1].document.forms[0]."+fieldName+" ) parent.frames[1].document.forms[0]."+fieldName+".value='';");
		out.println("if (parent.frames[1].document.forms[0]."+fieldName2+") parent.frames[1].document.forms[0]."+fieldName2+".value='';");
		out.println("if (parent.frames[1].document.forms[0]."+fieldName1+") parent.frames[1].document.forms[0]."+fieldName1+".value='';");
		out.println("parent.frames[1].document.forms[0]."+fieldName3+".value='';");
        out.println("parent.frames[1].document.forms[0]."+fieldName4+".value='';</script>");
	    out.println("<script>parent.frames[1].document.forms[0]."+fieldName2+".focus();</script>");
		
		}        
    }
 }
    catch(Exception e){/* out.println("tst "+e); */e.printStackTrace();}
    finally
    {
        ConnectionManager.returnConnection(con,request);
    }
%>
<script>
parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
</script>
</head>
</body>
</html>

