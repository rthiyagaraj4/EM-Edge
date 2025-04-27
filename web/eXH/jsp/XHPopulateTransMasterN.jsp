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
//	String language           = request.getParameter("language")==null?"":request.getParameter("language");
	String master_code        = request.getParameter("master_code")==null?"":request.getParameter("master_code");
	String master_table_id	= request.getParameter("master_table_id")==null?"":request.getParameter("master_table_id");		     
//	System.out.println("module 28 :"+module);	 			    
	String ModuleFlag        = request.getParameter("ModuleFlag")==null?"":request.getParameter("ModuleFlag");	    
	String applicationid		= request.getParameter("application")==null?"":request.getParameter("application");
	System.out.println("XHPopulateTransMasterN.jsp applicationid :"+applicationid);	 			    

//		System.out.println("ModuleFlag : "+ModuleFlag);
	try{
		   con = ConnectionManager.getConnection(request);		     

			if(ModuleFlag.equals("Y"))
		    {									   
             try
               {
				  sql.setLength(0);
	//			  sql.append("select   module_id, module_name  from  sm_module ");
	//			  sql.append("SELECT   module_id, module_name  FROM  sm_module WHERE module_id IN (SELECT DISTINCT SUBSTR(MASTER_TABLE_ID,1,2) FROM  xh_mapping ) ");
				   sql.append("SELECT   module_id, module_name  FROM  sm_module WHERE module_id IN (SELECT DISTINCT SUBSTR(MASTER_TABLE_ID,1,2) FROM  xh_mapping WHERE   SUBSTR(MASTER_TABLE_ID,1,2) NOT IN ('XX') )  UNION   SELECT SUBSTR(MASTER_TABLE_ID,1,2),table_desc EXECUTION_NATURE FROM  xh_mapping WHERE   MASTER_TABLE_ID = 'XX' ");
				  sql.append(" order by module_name ");
				  pstmt = con.prepareStatement(sql.toString());						 
				  rs = pstmt.executeQuery();
			%>																     
			<script> 																  
			var obj=parent.frames[1].document.forms[0].module_id;
			var length = obj.length;																		  
	//		alert("XHPopulateTransMasterN modl obj length : "+length);			       
			for(i=0;i<length;i++)									   
			obj.remove(1);
			var obj1=parent.frames[1].document.forms[0].master_name;	    
			var length1 = obj1.length;
			for(i=0;i<length1;i++)												    
			obj1.remove(1);
			</script>																  
			<%	
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
				  %>
				  <script>	  
						var obj2=parent.frames[1].document.forms[0].module_id;
						for(var i=0;i<obj2.options.length;i++)
						{	
							if(obj2.options[i].value=='<%=module%>')
							{
								obj2.options[i].selected=true;
							}
						}
						
						//parent.frames[1].document.forms[0].module_id.selected="<%=module%>";
						 </script>
				  <%
						 if(fun_id.equals("SWITCHENTITY"))
   {
			  master_code=module;
			  sql.setLength(0);	
			if(master_code.equals("CA"))
			{						  
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('CA','CR') ");

				sql.append("order by table_desc");
			}else if(master_code.equals("SM"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('SM','SY') ");

				sql.append("order by table_desc");
			}else{
	//			System.out.println("XHPopulateTransMasterN Modls Othr thn CA/SM  ");
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2)='"+master_code+"' ");

				sql.append("order by table_desc");			  
			}																					   
			stmt= con.createStatement();
				System.out.println("XHPopulateTransMasterN.jsp sql 122 : "+sql.toString());
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
						 code = rs.getString("master_table_id");	
						 if(code==null) code="";
				 
						 desc = rs.getString("table_desc");
						 if(desc==null) desc="";

 						 trans_tbl_id = rs.getString(3);	
//						 System.out.println("trans_tbl_id : "+trans_tbl_id);

				 	%>
				<script>
			         opt=parent.frames[1].document.createElement("OPTION");
				     opt.text="<%=desc%>";
				     opt.value="<%=code%>";

					 parent.frames[1].document.forms[0].master_name.add(opt);

			         opt1=parent.frames[1].document.createElement("OPTION");
				     opt1.text="<%=trans_tbl_id%>";
				     opt1.value="<%=code%>";

					 parent.frames[1].document.forms[0].hidden_trans_table_id.add(opt1);
					 
				 		
                </script>
				<%	}
													 
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();


				sql.setLength(0);


   }									   
					 %>
					  <script>	  
						var obj3=parent.frames[1].document.forms[0].master_name;
						for(var i=0;i<obj3.options.length;i++)
						{	
							if(obj3.options[i].value=='<%=master_table_id%>')
							{
								obj3.options[i].selected=true;

							}
						}
						
						//parent.frames[1].document.forms[0].module_id.selected="<%=module%>";
						 </script>
				  <%											   
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
		     }catch(Exception e) { out.println("Main : "+e.toString());}			   
			} // end of ModuleFlag Y

           else {
			   
			if(master_code.equals("XX")){
				sql.setLength(0);	
	//			sql.append("SELECT  a.element_name, a.element_id element_id  FROM xh_element_crossref_lang_vw a, xh_appl_element b  WHERE a.element_id = b.element_id  AND b.application_id = '"+applicationid+"'  AND a.table_ID IS NOT NULL  AND b.in_use_yn = 'Y'   AND crossref_type = 'S'  AND a.in_use_yn = 'Y'  AND a.LANGUAGE_ID='"+locale+"'  ORDER BY 1 ";
				sql.append("SELECT  a.element_id element_id, a.element_name,'' DUMMY  FROM xh_element_crossref_lang_vw a, xh_appl_element b  WHERE a.element_id = b.element_id  AND b.application_id = '"+applicationid+"'   AND b.in_use_yn = 'Y'   AND a.in_use_yn = 'Y'  AND a.LANGUAGE_ID='en'  ORDER BY 1 ");
		   } // end of XX - NON Table

		   else{			   
//			   System.out.println("ModuleFlag!= Y");
				sql.setLength(0);				
					if(master_code.equals("CA"))
					{						  
						sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('CA','CR') ");

						sql.append("order by table_desc");
					}else if(master_code.equals("SM"))
					{
						sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2) in ('SM','SY') ");

						sql.append("order by table_desc");
					}else{
			//			System.out.println("XHPopulateTransMasterN Modls Othr thn CA/SM  ");
						sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC,SUBSTR(TRANS_TABLE_ID,LENGTH(TRANS_TABLE_ID)-3, LENGTH(TRANS_TABLE_ID)-1) from xh_mapping where substr(MASTER_TABLE_ID,1,2)='"+master_code+"' ");

						sql.append("order by table_desc");			  
					}
		   } // end of else
			stmt= con.createStatement();
				System.out.println("XHPopulateTransMasterN.jsp sql 122 : "+sql.toString());
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
//						 code = rs.getString("master_table_id");	
						 code = rs.getString(1);	
						 if(code==null) code="";

//						 desc = rs.getString("table_desc");				 
						 desc = rs.getString(2);
						 if(desc==null) desc="";

 						 trans_tbl_id = rs.getString(3);	
//						 System.out.println("trans_tbl_id : "+trans_tbl_id);

				 	%>
				<script>
			         opt=parent.frames[1].document.createElement("OPTION");
				     opt.text="<%=desc%>";
				     opt.value="<%=code%>";

					 parent.frames[1].document.forms[0].master_name.add(opt);

			         opt1=parent.frames[1].document.createElement("OPTION");
				     opt1.text="<%=trans_tbl_id%>";
				     opt1.value="<%=code%>";

					 parent.frames[1].document.forms[0].hidden_trans_table_id.add(opt1);
					 
				 		
                </script>
				<%	}
													 
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();


				sql.setLength(0);

		   } // end of ModuleFlag 'N'
		   
		   
		}catch(Exception e) { out.println("Main : "+e.toString());}
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

