<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />		
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>		
		<script language='javascript' src='../../eMP/js/RelationshipLevel.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<%Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
{   
    con	= ConnectionManager.getConnection();
	String relationship_code = "";
	String relationship_level_code = "";
	String relationship_level_desc = "";
	String linked_relnship_level_code = "";
	String relationship_level = "";
	String linked_relnship_level_desc = "";
	String reln_lvl_code = "";
	String reln_lvl_desc = "";
	String linked_reln_lvl_code = "";
	String linked_reln_lvl_desc = "";
	String mode = "";
	String classValue = "";	
	String linked_relationship_desc="";    
    String srno=""; 
    String linked_relationship_code="";     
    String insert_flag="";         
    
	linked_relationship_desc=(request.getParameter("linked_relationship_desc")==null)? "":request.getParameter("linked_relationship_desc");
	
	linked_relationship_code=(request.getParameter("linked_relationship_code")==null)? "":request.getParameter("linked_relationship_code");

  	relationship_code=(request.getParameter("relationship_code")==null)?"":request.getParameter("relationship_code");
	relationship_level_code=(request.getParameter("relationship_level_code")==null)?"":request.getParameter("relationship_level_code");
	relationship_level_desc=(request.getParameter("relationship_level_desc")==null)?"":request.getParameter("relationship_level_desc");
	relationship_level=(request.getParameter("relationship_level")==null)?"":request.getParameter("relationship_level");
	linked_relnship_level_code=(request.getParameter("linked_relnship_level_code")==null)?"": request.getParameter("linked_relnship_level_code");

	linked_relnship_level_desc=(request.getParameter("linked_relnship_level_desc")==null)?"": request.getParameter("linked_relnship_level_desc");	

	mode=(request.getParameter("mode")==null)?"": request.getParameter("mode");
	
	srno=(request.getParameter("srno")==null)?"": request.getParameter("srno");		

	if(mode.equals("update"))
	{
			%>
			<script>				
				function clearBean()
				{
					eval("document.relnshiplvl_result_form"+<%=associateDiagBean.clearAll()%>);		
				}
			</script>
			<%
	} 	

	if(!(relationship_level_code.equals("") && relationship_level_desc.equals("") && linked_relnship_level_code.equals("") ) )	
	{
		if(mode.equals("add"))
		{
			if(associateDiagBean.containsObject(relationship_level_code)==false)
			{
				associateDiagBean.putObject("I");
				associateDiagBean.putObject(relationship_level_code);
				associateDiagBean.putObject(relationship_level_desc);	

				if(relationship_level.equals("2"))
				{
					associateDiagBean.putObject(linked_relnship_level_code);
					associateDiagBean.putObject(linked_relnship_level_desc);					
				}
				
			}
			else
			{
				%>
				<script>
					alert(getMessage("RECORD_EXISTS","SM"));					
				</script>
				<%
			} 
		}
		else if(mode.equals("modify"))
		{
				int g = Integer.parseInt(srno);

				associateDiagBean.setObject(g,"M");				
				associateDiagBean.setObject(g+1,relationship_level_code);
				associateDiagBean.setObject(g+2,relationship_level_desc);

				if(relationship_level.equals("2"))
				{
					associateDiagBean.setObject(g+3,linked_relnship_level_code);					
					associateDiagBean.setObject(g+4,linked_relnship_level_desc);			
				}				
		}		
	}	

	if(mode.equals("update"))
	{
		String sqlupdate = "";
		
		if(relationship_level.equals("1"))
		{
			sqlupdate = "select relationship_level_code, relationship_level_desc from MP_RELATIONSHIP_LEVEL where relationship_code='"+relationship_code+"'";
		}
		else if(relationship_level.equals("2"))
		{
			sqlupdate = "select relationship_level_code, relationship_level_desc, relationship_level_code2, relationship_level2_desc from MP_RELATIONSHIP_LEVEL_VW where relationship_code='"+relationship_code+"' and ASSOCIATED_RELATIONSHIP_CODE = '"+linked_relationship_code+"'";
		}

		pstmt=con.prepareStatement(sqlupdate);		
		rs=pstmt.executeQuery();

		while( rs!=null && rs.next())
		{
				reln_lvl_code=(rs.getString("relationship_level_code")==null)?"":rs.getString("relationship_level_code");
				reln_lvl_desc=(rs.getString("relationship_level_desc")==null)?"":rs.getString("relationship_level_desc");

				associateDiagBean.putObject("U");
				associateDiagBean.putObject(reln_lvl_code);
				associateDiagBean.putObject(reln_lvl_desc);

				if(relationship_level.equals("2"))
				{
					linked_reln_lvl_code=(rs.getString("relationship_level_code2")==null)?"":rs.getString("relationship_level_code2");
					linked_reln_lvl_desc=(rs.getString("relationship_level2_desc")==null)?"":rs.getString("relationship_level2_desc");

					associateDiagBean.putObject(linked_reln_lvl_code);					
					associateDiagBean.putObject(linked_reln_lvl_desc);

				}				
		}

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}

	int rec_cnt=associateDiagBean.getSize();	

	if(rec_cnt>0)
	{
	
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name='relnshiplvl_result_form' id='relnshiplvl_result_form' method='post' action='../../servlet/eMP.RelationshipLevelServlet' target="messageFrame">
<table border='1' cellpadding='0' cellspacing='0' width='99%' align='center'>
<tr>

<th width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th width='40%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<%if(relationship_level.equals("2"))
{%>
<th width='40%'><fmt:message key="eMP.LinkedRelnshpLevel.label" bundle="${mp_labels}"/></th>
<%}%>
<th width='5%'>&nbsp;</th>
</tr>

<%
            ArrayList a= new ArrayList();
			a= associateDiagBean.getRecordSetHandle();
						           
			//int j=0;
			//int k=1;
			int z=0;			
			
			for(int i=0;i<rec_cnt;i++)
			{
				if ( i % 2 == 0 )
					 classValue = "QRYEVEN" ;
				else
					 classValue = "QRYODD" ;
				
				z=i;

				insert_flag=a.get(i).toString();
				reln_lvl_code=a.get(++i).toString();
				reln_lvl_desc=a.get(++i).toString();
				if(relationship_level.equals("2"))
				{
					linked_reln_lvl_code=a.get(++i).toString();
					linked_reln_lvl_desc=a.get(++i).toString();								
				}				

				out.println("<tr><td class='" + classValue + "' align='center' width ='10%' nowrap><A HREF='../../eMP/jsp/RelationshipLevelAddModify.jsp?relationship_level_code="+reln_lvl_code+"&relationship_level_desc="+reln_lvl_desc+"&linked_relnship_level_desc="+linked_reln_lvl_desc+"&relationship_code="+relationship_code+"&linked_relnship_level_code="+linked_reln_lvl_code+"&linked_relationship_desc="+linked_relationship_desc+"&linked_relationship_code="+linked_relationship_code+"&srno="+z+"&mode=modify' target=relnshp_lvl_add_mod>"+reln_lvl_code+"</a></td>");
				out.println("<td class='" + classValue + "' align='center' width ='40%' nowrap>"+reln_lvl_desc+"</td>");
				if(relationship_level.equals("2"))
				{
					out.println("<td class='" + classValue + "' align='center' width ='40%' nowrap>"+linked_reln_lvl_desc+"</td>");
				}	

				if(insert_flag.equals("M")||insert_flag.equals("I"))
				{
					out.println("<td class='" + classValue + "' align='center' width ='5%' nowrap><input type='checkbox' value='Y' name='insert_chk"+z+"' id='insert_chk"+z+"' checked onclick='chkValue(this,"+z+");'></td></tr>");
				}
				else
				{
					out.println("<td class='" + classValue + "' align='center' width ='5%' nowrap>&nbsp;</td></tr>");
				}
				
				//z++;
				
			}	
%>

<input type = 'hidden' name = 'rec_cnt' value = '<%=rec_cnt%>'>
<input type = 'hidden' name = 'checked_flag' value = ''>
<input type = 'hidden' name = 'linked_relationship_code' value = '<%=linked_relationship_code%>'>
<input type = 'hidden' name = 'linked_relationship_desc' value = '<%=linked_relationship_desc%>'>
<input type = 'hidden' name = 'relationship_code' value = '<%=relationship_code%>'>
<input type = 'hidden' name = 'relationship_level' value = '<%=relationship_level%>'>

</table>
</form>
</body>

<%
	}

}
catch(Exception e)
{
	 
	 e.printStackTrace();
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
}
%>

</html>













