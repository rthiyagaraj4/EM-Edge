<!DOCTYPE html>
<%--
	FileName	: ResultTemplateAddModify.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="webbeans.eCommon.*,java.sql.*,java.net.*, java.io.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		 <script src='../../eAM/js/ResultTemplate.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
	
	
	<body  OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown = 'lockKey()'>
	<style>
	textarea{resize: none;}
	</style>
	<form name='ResultTemplate_form' id='ResultTemplate_form' action='../../servlet/eAM.ResultTemplateServlet' method='post' target='messageFrame'>
		<div>
      	<BR><BR><BR><BR>
	<%
		 Connection con=null;
		 Statement stmt=null;
		 PreparedStatement pstmt = null;
		 ResultSet rs=null;
		 request.setCharacterEncoding("UTF-8");	
		 request= new XSSRequestWrapper(request);
		 response.addHeader("X-XSS-Protection", "1; mode=block");
		 response.addHeader("X-Content-Type-Options", "nosniff");
		 String sql="";

		 String dis="checked";
		// String dis1="";
		 String dis_t="";
	//	 String sel="";
		 String status="";

		// oracle.sql.CLOB	clob_tech_spec			= null;
		Clob clob_tech_spec =null;
		 String result_template_id     = "" ;   
		 String result_template_name   = "" ;   
		 String result_template        = "" ;  
		 String eff_status             = "" ;   
		 String mode				   = (request.getParameter("mode")==null)?"":request.getParameter("mode");
		 String enabled_checked					="";
		 java.io.Reader	tech_reader				= null;
		 java.io.BufferedReader	bf_tech_reader	= null;
	
		try
		{
			
		 if(mode.equalsIgnoreCase("update"))
		 {
			con =ConnectionManager.getConnection(request);
			stmt=con.createStatement();

			result_template_id = (request.getParameter("result_template_id")==null)?"":
			request.getParameter("result_template_id");

			//sql = "select * from am_result_template where result_template_id='" + result_template_id + "'"  ;
			//rs			= stmt.executeQuery(sql);
			
			sql="select * from am_result_template where result_template_id=?" ;
			pstmt   = con.prepareStatement(sql);
			pstmt.setString	(	1,	result_template_id		);
			rs		 = pstmt.executeQuery();

			if(rs.next())
			 {
				result_template_id = (rs.getString("result_template_id")==null)?"":rs.getString("result_template_id");
				result_template_name =
				(rs.getString("result_template_name")==null)?"":rs.getString("result_template_name");
				//clob_tech_spec		= (oracle.sql.CLOB)rs.getObject("result_template");
				clob_tech_spec		= (Clob)rs.getObject("result_template");
				
				if(clob_tech_spec!=null)
				{
					try
					{
					//tech_reader	= ((oracle.sql.CLOB) clob_tech_spec).getCharacterStream();
					tech_reader	= ((Clob) clob_tech_spec).getCharacterStream();
					bf_tech_reader = new java.io.BufferedReader(tech_reader);
					char[] arr_tech_spec = new char[(int)clob_tech_spec.length()];
					bf_tech_reader.read(arr_tech_spec,0,(int)clob_tech_spec.length());
					result_template = new String(arr_tech_spec);
					bf_tech_reader.close();
				}
				catch(Exception e)
				{
					//out.println("Exception@2-readCLOB : "+e);
					e.printStackTrace();
				}
			}

				eff_status=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");
			
				if(eff_status.equals("E"))
				 {
					enabled_checked="checked";
					dis="checked";
				 }
				else
				{
					enabled_checked="";
					//dis1="disabled";
					dis ="";
					dis_t ="readonly";
				}

			  }
		
		 }
	}

	catch(Exception e)
	{
			//out.println(e);
			e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
	} 

	 %>

      	<table border='0' cellpadding='0' cellspacing='0'  width='auto' align='center' >
      	<tr>
									<td width='30%' class="label">&nbsp;</td>
									<td width='70%' class="label">&nbsp;</td>
		</tr>
      		<tr>
      			<td class='label'><fmt:message key="Common.TemplateID.label" bundle="${common_labels}"/></td>
				<%if(mode.trim().equalsIgnoreCase("update")) {status="readonly" ;}else{status="";}%>
      		    <td  class="fields"><input type='text' name='result_template_id' id='result_template_id' 
				value="<%= result_template_id%>" onkeypress="return CheckForSpecChars(event)" size='10' maxlength='10'  onBLur="ChangeUpperCase(this);" <%=status%>>
      		    <img src='../../eCommon/images/mandatory.gif' align='center'></img>
      		    </td>
			</tr>
			<tr class="label">
				<td width='30%' class="label">&nbsp;</td>
				<td width='70%' class="label">&nbsp;</td>
			</tr>
			<tr>
     		    <td class='label'><fmt:message key="Common.TemplateName.label" bundle="${common_labels}"/></td>
      		    <td class="fields"><input type='text'  onBlur='makeValidString(this)' name='result_template_name' id='result_template_name' value="<%=result_template_name%>" size='30' maxlength='30' <%=dis_t%>><img src='../../eCommon/images/mandatory.gif' align='center'></img>
      		    </td>
      		</tr>
			<tr class="label">
							<td width='30%' class="label">&nbsp;</td>
							<td width='70%' class="label">&nbsp;</td>
			</tr>
			<tr>
				<td  class='label' ><fmt:message key="Common.ResultTemplate.label" bundle="${common_labels}"/></td>
				<td  class="fields"><textarea name='result_template' id='result_template'  onBlur="makeValidString(this)"rows='5' cols='40'  <%=dis_t%>><%=result_template%></textarea>
				<img src='../../eMP/images/mandatory.gif' align='center'></img></td>
			</tr>
			<tr class="label">
				<td width='30%' class="label">&nbsp;</td>
				<td width='70%' class="label">&nbsp;</td>
			</tr>
			<tr>    			
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="E" <%=dis%> >
      		     </td>
      		</tr>
			<tr class="label">
				<td width='30%' class="label">&nbsp;</td>
				<td width='70%' class="label">&nbsp;</td>
			</tr>
    	</table>
      	</div>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='result_template_id_update' id='result_template_id_update' value='<%=result_template_id%>'>
			<input type='hidden' name="beforeUpdateEff_status" id="beforeUpdateEff_status" value="<%=enabled_checked%>">
      </form>
     </body>
    </html>

