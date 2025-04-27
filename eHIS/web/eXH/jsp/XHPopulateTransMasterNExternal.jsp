<!DOCTYPE html>

<%@ page import ="webbeans.eCommon.*,java.sql.*,eXH.*" contentType="text/html;charset=UTF-8"%>
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
	String trans_tbl_id		= "";																				   
	String fun_id=XHDBAdapter.checkNull(request.getParameter("fun_id")); 
	String module= request.getParameter("module")==null?"":request.getParameter("module"); 

	String master_code        = request.getParameter("master_code")==null?"":request.getParameter("master_code");
	String master_table_id	= request.getParameter("master_table_id")==null?"":request.getParameter("master_table_id");		     
	//System.out.println("module 28 :"+module);	 			    
	String ModuleFlag        = request.getParameter("ModuleFlag")==null?"":request.getParameter("ModuleFlag");	    
//		System.out.println("ModuleFlag : "+ModuleFlag);
	try{
		   con = ConnectionManager.getConnection(request);		     
		    sql.setLength(0);	
			sql.append("select distinct MASTER_TABLE_ID,TABLE_DESC,TRANS_TABLE_ID from xh_mapping where MASTER_TABLE_ID in(select PLUGIN_TYPE from xh_interactive_connect_param )");
			stmt= con.createStatement();
				rs = stmt.executeQuery(sql.toString()) ;%>
			<script> 
			var obj=parent.frames[1].document.forms[0].master_name;
			var obj1=parent.frames[1].document.forms[0].hidden_trans_table_id;
			var length = obj.length;
			for(i=0;i<length;i++){
				obj.remove(1);														    
				obj1.remove(1);
			}												 
			</script>
			<%	
					while (rs.next())
					{		
				

						 code = rs.getString("MASTER_TABLE_ID");	
						 if(code==null) code="";
				 
						 desc = rs.getString("TABLE_DESC");
						 if(desc==null) desc="";

 						 trans_tbl_id = rs.getString(3);	


				 	%>
				<script>
			         opt=parent.frames[1].document.createElement("OPTION");
				     opt.text="<%=desc%>";
				     opt.value="<%=code%>";
					 parent.frames[1].document.forms[0].master_name.add(opt);	    
					 opt1=parent.frames[1].document.createElement("OPTION");
				     opt1.text="<%=trans_tbl_id%>";
				     opt1.value="<%=code%>"; 

			    </script>
				<%	}
				if(rs != null) rs.close();											 
				if(stmt != null) stmt.close();
				sql.setLength(0);
		}catch(Exception e) { 
			System.out.println(" XHPopulateTransMasterNExternal sqlQuery 34 : "+sql.toString());
			out.println("XHPopulateTransMasterNExternal.jsp :Exception : "+e.toString());}
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

