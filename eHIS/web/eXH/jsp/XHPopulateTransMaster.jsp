<!DOCTYPE html>
 
<%@ page import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

<%
	
    request.setCharacterEncoding("UTF-8");
	Connection con            = null;
	Statement stmt            = null;
	PreparedStatement  pstmt  = null;
	ResultSet rs              = null;
    StringBuffer sql          = new StringBuffer();
	String code               = "";
	String desc               = "";
	String code1              = "";
	String desc1              = "";
//	String language           = request.getParameter("language")==null?"":request.getParameter("language");

	String master_code        = request.getParameter("master_code")==null?"":request.getParameter("master_code");
	String ModuleFlag        = request.getParameter("ModuleFlag")==null?"":request.getParameter("ModuleFlag");
//		System.out.println("ModuleFlag : "+ModuleFlag);
	try{
		   con = ConnectionManager.getConnection(request);

			if(ModuleFlag.equals("Y"))
		    {
             try
               {
			  sql.setLength(0);
			  sql.append("select   module_id, module_name  from  sm_module ");
			  sql.append(" order by module_name ");
		//  			  System.out.println("sql 57 : "+sql.toString());
			  pstmt = con.prepareStatement(sql.toString());
			  rs = pstmt.executeQuery();
			%>
			<script> 
			var obj=parent.frames[1].document.forms[0].module_id;
			var length = obj.length;
			for(i=0;i<length;i++)
			obj.remove(1);
			var obj1=parent.frames[1].document.forms[0].master_name;
			var length1 = obj1.length;
			for(i=0;i<length1;i++)
			obj1.remove(1);
			</script>
			<%	
//				System.out.println("73");
					while (rs.next())
					{			
						 code1 = rs.getString("module_id");	
						 if(code1==null) code1="";
				 
						 desc1 = rs.getString("module_name");
						 if(desc1==null) desc1="";
				 	%>
				<script>
			         opt=parent.frames[1].document.createElement("OPTION");
				     opt.text="<%=desc1%>";
				     opt.value="<%=code1%>";
					 parent.frames[1].document.forms[0].module_id.add(opt);
					 
				 		
                </script>
				<%	}
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
		     }catch(Exception e) { out.println("Main : "+e.toString());}
			} // end of ModuleFlag Y
           else{
//			   System.out.println("ModuleFlag!= Y");
		    sql.setLength(0);
			if(master_code.equals("CA"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('CA','CR') ");

				sql.append("order by table_desc");
			}else if(master_code.equals("SM"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('SM','SY') ");

				sql.append("order by table_desc");
			}else{
				//System.out.println("XHPopulateTransMasterN Modls Othr thn CA/SM  ");
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from xh_mapping where substr(MASTER_TABLE_ID,1,2)='"+master_code+"' ");

				sql.append("order by table_desc");
			}
			stmt= con.createStatement();
				//System.out.println("XHPopulateTransMaster.jsp sql 122 : "+sql.toString());
			rs = stmt.executeQuery(sql.toString()) ;%>
			<script> 
			var obj=parent.frames[1].document.forms[0].master_name;
			var length = obj.length;
			for(i=0;i<length;i++)
			obj.remove(1);
			</script>
			<%	
					while (rs.next())
					{			
						 code = rs.getString("master_table_id");	
						 if(code==null) code="";
				 
						 desc = rs.getString("table_desc");
						 if(desc==null) desc="";
				 	%>
				<script>
			         opt=parent.frames[1].document.createElement("OPTION");
				     opt.text="<%=desc%>";
				     opt.value="<%=code%>";
					 parent.frames[1].document.forms[0].master_name.add(opt);
					 
				 		
                </script>
				<%	}
				
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();


				sql.setLength(0);

		   } // end of ModuleFlag 'N'
		   
		   
		}catch(Exception e) {
					   System.out.println("XHPopulateTransMaster.jsp sql  : "+sql.toString());
			out.println("XHPopulateTransMaster.jsp :Exception : "+e.toString());}
	finally
	{
		try{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		}catch(Exception e) {}
		if(con != null) ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
	
%>	

