<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>SplChartKeyHdr</title>
		<script src='../../eCA/js/SplChartKey.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript'>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	String sql = "";
	String mode = null;
	String chart_type = "",chart_desc = "",chart_type1="",type_value1="";
	String group_type = "",group_desc = "",group_type1="";
	String element_type = "",element_type1="",element_desc="";
	boolean flag = false;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	mode		= request.getParameter("mode")==null?"modify":request.getParameter("mode");
    chart_type1 = request.getParameter("spl_chart_type")==null?"":request.getParameter("spl_chart_type");
	group_type1 = request.getParameter("spl_chart_group")==null?"":request.getParameter("spl_chart_group");
	chart_desc	= request.getParameter("chart_desc")==null?"":request.getParameter("chart_desc");
	type_value1 = request.getParameter("type_value1")==null?"I":request.getParameter("type_value1");
	element_type1= request.getParameter("xAxis_element")==null?"*K":request.getParameter("xAxis_element");
	if(mode.equals(""))
		mode = "modify";

	try
	{
		con = ConnectionManager.getConnection(request);
		sql = "SELECT SPL_CHART_TYPE_GRP_APPL_YN FROM CA_SPL_CHART_TYPE WHERE SPL_CHART_TYPE=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,chart_type1);
		rset  = pstmt.executeQuery();
		String appl = "N";
		if(rset.next())
			appl = rset.getString(1);
		if(appl.equals("Y"))
			flag = true;
		else
	 		flag = false;
		if(flag==true && group_type1.equals("*A"))
			group_type1 = "";
		if(!flag)
			group_type1 = "*A";
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	} 
	catch(Exception e){
		//out.println("Exception in try of SplChartKeyHdr.jsp"+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
	if(chart_type1!=null && !(chart_type1.equals("")) && !(flag==true && (group_type1==null || group_type1.equals(""))))
	{
		try
		{
			sql = "SELECT SPL_CHART_TYPE FROM CA_SPL_CHART_KEY_VALUE WHERE SPL_CHART_TYPE=? AND SPL_CHART_TYPE_GRP_ID=? AND X_ELEMENT_TYPE=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,chart_type1);
			pstmt.setString(2,group_type1);
			pstmt.setString(3,element_type1);
			rset  = pstmt.executeQuery();
			if(rset.next())
			{
			%>
				setDetailsPage('display','<%=chart_type1%>','<%=group_type1%>','<%=element_type1%>');
			<%
			}
			else
			{%>
				setDetailsPage('list','<%=type_value1%>','<%=group_type1%>','<%=element_type1%>');
			<%
			}	
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
		}//end of try 
						
		catch(Exception e){
		//	out.println("Exception in try of SplChartKeyHdr.jsp"+e.toString());//COMMON-ICN-0181
                          e.printStackTrace();//COMMON-ICN-0181
		}
	}
	else
	{%>
	<!--	setDetailsPage('list','<%=type_value1%>') -->
			setDetailsPage('empty','');
	<%
	}	
	%>
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
/** added by kishore kumar n on 27/11/2009  */
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

</head>
<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name='SplChartKeyHdrForm' id='SplChartKeyHdrForm' method="post">
		<table width='98%' border='0' cellspacing='0' cellpadding='3' align=center>
			<tr>
				<td  class='label' ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td  class='fields' >
					<SELECT name="spl_chart_type" id="spl_chart_type" style="width: 150px" onchange='checkChartType(this)'>
					<%
					try{
						sql = "Select SPL_CHART_TYPE , SPL_CHART_TYPE_DESC From CA_SPL_CHART_TYPE where eff_status='E' Order by SPL_CHART_TYPE_DESC";
						if(mode.equals("insert") || mode.equals("modify")){
							pstmt = con.prepareStatement(sql);
							rset  = pstmt.executeQuery();
							if(rset!=null){
								chart_type = "";
								chart_desc = ""; %>
								<option value = '' selected >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
								<%
								while(rset.next()){
									chart_type = rset.getString("SPL_CHART_TYPE")==null?"":rset.getString("SPL_CHART_TYPE");
									chart_desc = rset.getString("SPL_CHART_TYPE_DESC")==null?"":rset.getString("SPL_CHART_TYPE_DESC");
									%>
									<option value = <%=chart_type%>  <%if(chart_type.equals(chart_type1))out.print("selected");%>><%=chart_desc%></option> 
									<%
								}
							}
						}
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
						%>
						</SELECT><img src='../../eCommon/images/mandatory.gif'>
						</td>
						<%
						if(flag){
						%>
							<td class='label'  ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
							<td class='fields'>
							<SELECT name="spl_chart_group" id="spl_chart_group"  style="width: 150px" onchange='checkChartType(this)'>
							<%
						 	sql = "SELECT SPL_CHART_TYPE_GRP_ID, SPL_CHART_TYPE_GRP_DESC FROM  CA_SPL_CHTY_GRP_LANG_VW WHERE SPL_CHART_TYPE=? and LANGUAGE_ID=?";
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,chart_type1);
							pstmt.setString(2,locale);
							rset  = pstmt.executeQuery();
							if(rset!=null){
								group_type = "";
								group_desc = ""; %>
								<option value = '' selected >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
								<%
								while(rset.next()){
									group_type = rset.getString("SPL_CHART_TYPE_GRP_ID")==null?"":rset.getString("SPL_CHART_TYPE_GRP_ID");
									group_desc = rset.getString("SPL_CHART_TYPE_GRP_DESC")==null?"":rset.getString("SPL_CHART_TYPE_GRP_DESC");
								%>
								<option value = <%=group_type%>  <%if(group_type.equals(group_type1))out.print("selected");%>><%=group_desc%></option> 
								<%
								}
							}
							if(rset!=null) rset.close();
							if(pstmt!=null) pstmt.close(); %>
							</SELECT><img src='../../eCommon/images/mandatory.gif'></td>
						<% 
						}%>

			
					
			</tr>
			<tr>
				<td width='15%' class='label' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td width='35%' class='fields'> 
					<INPUT id='r1' TYPE="radio" name="type_value" id="type_value" value="I" onclick='processInterval()' <%if(type_value1.equals("I"))out.print("CHECKED");%>> <fmt:message key="eCA.IntervalBased.label" bundle="${ca_labels}"/>&nbsp; 
					<INPUT id='r2' TYPE="radio" name="type_value" id="type_value" value="S" onClick='processStatic()' <%if(type_value1.equals("S"))out.print("CHECKED");%>> <fmt:message key="eCA.Static.label" bundle="${ca_labels}"/> 
				</td>
				<%
				if(flag){
				%>
				<td width='15%' class='label' ><fmt:message key="eCA.Xaxiselement.label" bundle="${ca_labels}"/> </td>
				<td width='35%'   class='fields'> 
					<select name="xAxis_element" id="xAxis_element" style="width: 150px" onchange='checkChartType(this)'>
							<%
							sql = "SELECT ELEMENT_TYPE, ELEMENT_TYPE_DESC FROM CA_SPL_CHART_ELEMENT_TYPE WHERE EFF_STATUS='E' ORDER BY ELEMENT_TYPE_DESC";
							pstmt = con.prepareStatement(sql);							
							rset  = pstmt.executeQuery();
							if(rset!=null){
								element_type = "";
								element_desc = ""; %>
								<option value = '*K' selected ><fmt:message key="Common.age.label" bundle="${common_labels}"/></option>
								<%
								while(rset.next()){
									element_type = rset.getString("ELEMENT_TYPE")==null?"":rset.getString("ELEMENT_TYPE");
									element_desc = rset.getString("ELEMENT_TYPE_DESC")==null?"":rset.getString("ELEMENT_TYPE_DESC");
								%>
								<option value = <%=element_type%> <%if(element_type.equals(element_type1))out.print("selected");%>><%=element_desc%></option> 
								<%
								}
							}
							if(rset!=null) rset.close();
							if(pstmt!=null) pstmt.close();	
									
					%>
					</select><img src='../../eCommon/images/mandatory.gif'></td>
					<%
					}
					
					}//end of try 									
					catch(Exception e){
						//out.println("Exception in try of SplChartKeyHdr.jsp"+e.toString());//COMMON-ICN-0181
                                                e.printStackTrace();//COMMON-ICN-0181
					}
					finally{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
					%>
							

			</tr>
		</table>
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'></input>
		<input type='hidden' name='type_value1' id='type_value1' value='<%=type_value1%>'></input>		
		<input type='hidden' name='chart_desc' id='chart_desc' value='<%=chart_desc%>'></input>
	<!-- added by kishore kumar n on 27/11/2009  -->
	<%if(!imgUrl.equals("")){ %>
	<img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>
	<!--ends here -->
	</form>

	</body>
</html>

