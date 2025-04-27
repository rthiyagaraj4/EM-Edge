<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			/** added by kishore kumar n on 27/11/2009  */
			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }
			/** ends here*/
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/SpltyMasterCode.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name='SpltyMasterCodeHdrForm' id='SpltyMasterCodeHdrForm'>
	<%
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		//String locale = (String) p.getProperty("LOCALE");
		try
		{   
			con = ConnectionManager.getConnection(request);
			
			sql = "select  MAST_TYPE_REF,  MAST_TYPE_DESC from ca_splty_mast_catalog  order by 2 ";
			//sql = "select MAST_TYPE_REF,MAST_TYPE_DESC from CA_SPLTY_MAST_CATALOG where EFF_STATUS='E' order by 2 ";
			ps = con.prepareStatement(sql);
			//ps.setString(1,"MC");
			
			rs = ps.executeQuery();
	%>
	<table border='0' cellspacing='0' cellpadding='3' width='100%' align='center'>
		
		<tr>
			<td class ='label' ><fmt:message key="eCA.MasterCategory.label" bundle="${ca_labels}"/></td>
			<td class ='fields' >
			<select name ='category' onchange='getDetails(this)'><option  value=''>----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>

	<%
			while(rs.next())
			{
				out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");		
			}
			if(rs != null) rs.close();
			if(ps != null) ps.close();
	%>			
			</select>
			</td>
		</tr>
		</table>
		<!-- added by kishore kumar n on 27/11/2009  -->
			<%if(!imgUrl.equals("")){ %>
			<img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>
			<!--ends here -->
	<%
		}
		catch(Exception ee)
		{
			//out.println("Exception in SpecialityMasterCodeHeader "+ee.toString());//COMMON-ICN-0181
                          ee.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			try{
				if(con != null) 
				{	
					ConnectionManager.returnConnection(con);
					con.close();
				 }
			}
			catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                                  e.printStackTrace();//COMMON-ICN-0181
				}
		}

	%>
	</form>
	</body>
</html>

