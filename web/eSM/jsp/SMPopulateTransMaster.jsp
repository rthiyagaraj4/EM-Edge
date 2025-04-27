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
	String language_direction = "";
	String language           = request.getParameter("language")==null?"":request.getParameter("language");
	String master_code        = request.getParameter("master_code")==null?"":request.getParameter("master_code");
	String ModuleFlag        = request.getParameter("ModuleFlag")==null?"":request.getParameter("ModuleFlag");
	String module_id        = request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String master_name        = request.getParameter("master_name")==null?"":request.getParameter("master_name");	
	try{
		    con = ConnectionManager.getConnection(request);
			sql.setLength(0);
			if(!master_name.equals("SM_RECORD_TRANS")){
			sql.append("select language_direction from sm_language where language_id= '"+language+"'" );
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if ( rs != null && rs.next() ) 
			{
				language_direction = rs.getString("language_direction");
			}
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();		   
			if ( language_direction      == null ) language_direction      = "" ;
		 %>
			<script>
			   parent.frames[1].document.forms[0].language_direction.value="<%=language_direction%>";
			</script>

		 <%	if(ModuleFlag.equals("Y"))
		    {
             try
               {
			  sql.setLength(0);
			  sql.append("select   module_id, module_name  from  sm_module ");
			  /*if(language_direction.equals("R"))
			    {
                  sql.append(" where module_id in ('MP', 'SM', 'OA','PH','AM') ");
				}*/ 
			  sql.append(" order by module_name ");
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
		     }catch(Exception e) { 
				 out.println("Main : "+e.toString());
				 e.printStackTrace();
				 }
			}
           else{
		    sql.setLength(0);
			// In below query TRANS_REQ_YN = 'Y'  is added for SRR20056-SCF-5111 [IN:023565] by suresh M on 24.11.2010

			if(master_code.equals("CA"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from sm_mapping where substr(MASTER_TABLE_ID,1,2) in ('CA','CR') and TRANS_REQ_YN = 'Y' order by table_desc");
				/*if(language_direction.equals("R"))
			    {
                  sql.append(" and MASTER_TABLE_ID IN ('OA_PARAM','PH_DRUG','PH_LABEL_TEXT','PH_ROUTE','AM_FREQUENCY')  ");
				}*/
				//sql.append("order by table_desc");
			}else if(master_code.equals("SM"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from sm_mapping where substr(MASTER_TABLE_ID,1,2) in ('SM','SY') and TRANS_REQ_YN = 'Y' order by table_desc");
				/*if(language_direction.equals("R"))
			    {
                  sql.append(" and MASTER_TABLE_ID IN ('SM_SITE_PARAM', 'SM_MENU_HDR', 'SM_APPL_USER', 'MP_CONTACT_MODE', 'SM_RESP', 'SM_FUNCTION', 'MP_PARAM', 'MP_ALTERNATE_ID_TYPE', 'OA_PARAM', 'PH_DRUG','PH_LABEL_TEXT', 'PH_ROUTE', 'AM_FREQUENCY')  ");
				}*/
				//sql.append("order by table_desc");
			}else if(master_code.equals("MM"))
			{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from sm_mapping where substr(MASTER_TABLE_ID,1,2) in ('MM','AP') and TRANS_REQ_YN = 'Y' order by table_desc ");
				//sql.append("order by table_desc");
			}else{
				sql.append("select distinct MASTER_TABLE_ID, TABLE_DESC from sm_mapping where substr(MASTER_TABLE_ID,1,2)='"+master_code+"' and TRANS_REQ_YN = 'Y' order by table_desc");

				/*if(language_direction.equals("R"))
			    {
                  sql.append(" and MASTER_TABLE_ID IN ('SM_SITE_PARAM', 'SM_MENU_HDR', 'SM_APPL_USER', 'MP_CONTACT_MODE', 'SM_RESP', 'SM_FUNCTION', 'MP_PARAM', 'MP_ALTERNATE_ID_TYPE', 'OA_PARAM','PH_DRUG', 'PH_LABEL_TEXT', 'PH_ROUTE', 'AM_FREQUENCY') ");
				}*/
				//sql.append("order by table_desc");
			}
			 
			stmt= con.createStatement();
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

		   }
	}else{%>
	<script>
		var obj=parent.frames[1].document.forms[0].report_id;
	</script>
	<%
		sql.append("select report_id,report_desc from sm_report where module_id='"+module_id+"' order by 2,1" );
		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		while(rs != null && rs.next()){
			
			String report_id=rs.getString("report_id");
			String report_desc=rs.getString("report_desc");
		%>
		<script>
			opt=parent.frames[1].document.createElement("OPTION");
			opt.text='<%=report_desc%>';
			opt.value='<%=report_id%>';
			parent.frames[1].document.forms[0].report_id.add(opt);
		</script>
		<%}
	}
		   
		   
		}catch(Exception e) { 
			e.printStackTrace();
			out.println("Main : "+e.toString());}
	finally
	{
		try{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(con != null) ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></html>");		
	
%>	

