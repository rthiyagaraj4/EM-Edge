<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
22/08/2017		IN058006	Prakash C		22/08/2017		Ramesh G		ML-MMOH-CRF-0461
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
 <%
     request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request); //MOHE-SCF-0153
 response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
 response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCA/js/SplChartGraph.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
</script>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	
	String sql="";
	String status="";
	String mode="";
	String sel="";
	String enabled_checked="";
	String spl_chart_type = "";
	String spl_chart_group = "";
	String graph_code = "";
	String graph_desc = "";
	String x_axis = "";
	String y_axis = "";
	String eff_status = "";
	boolean flag = false;
	String group_type = "",group_desc = "";

	mode		    =(request.getParameter("mode")==null)?"":request.getParameter("mode");
	spl_chart_type  =(request.getParameter("spl_chart_type")==null)?"":request.getParameter("spl_chart_type");

	spl_chart_group =(request.getParameter("spl_chart_group")==null)?"":request.getParameter("spl_chart_group");
   	graph_code      =(request.getParameter("graph_code")==null)?"":request.getParameter("graph_code");
	graph_desc      =(request.getParameter("graph_desc")==null)?"":request.getParameter("graph_desc");
	eff_status      =(request.getParameter("eff_status")==null)?"":request.getParameter("eff_status"); 

	if(eff_status.equals("E"))
		enabled_checked = "checked";
	else
		enabled_checked = "";
	if(eff_status.equals(""))
	if((mode==null || mode.equals("") || mode.equals("insert"))) 
	{
		mode="insert";
		enabled_checked = "checked";
		eff_status = "E";
	}
	try
	{
		con = ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update")) 
		{
			//sql ="SELECT * FROM CA_SPL_CHART_GRAPH WHERE SPL_CHART_TYPE='"+ spl_chart_type + "' AND GRAPH_CODE='"+ graph_code + "' AND SPL_CHART_TYPE_GRP_ID='"+spl_chart_group+"'" ;//common-icn-0180
			sql ="SELECT * FROM CA_SPL_CHART_GRAPH WHERE SPL_CHART_TYPE=? AND GRAPH_CODE=? AND SPL_CHART_TYPE_GRP_ID=?" ;//common-icn-0180
			
			pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1,spl_chart_type);//common-icn-0180
			pstmt.setString(2,graph_code);//common-icn-0180
			pstmt.setString(3,spl_chart_group);//common-icn-0180
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				 spl_chart_type		= (rset.getString("SPL_CHART_TYPE")==null)?"":rset.getString("SPL_CHART_TYPE");
				 graph_code			= (rset.getString("GRAPH_CODE")==null)?"":rset.getString("GRAPH_CODE");
				 graph_desc			= (rset.getString("GRAPH_DESC")==null)?"":rset.getString("GRAPH_DESC");
				 x_axis			= (rset.getString("X_AXIS_ELEMENT_TYPE")==null)?"":rset.getString("X_AXIS_ELEMENT_TYPE");
				 y_axis			= (rset.getString("Y_AXIS_ELEMENT_TYPE")==null)?"":rset.getString("Y_AXIS_ELEMENT_TYPE");
				 eff_status		= (rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
				 if(eff_status.equals("E"))
					enabled_checked = "checked";
				 else
					enabled_checked = "";
			}
			if(rset!=null)  rset.close(); 
			if(pstmt!=null)  pstmt.close();
		}
		if(spl_chart_type!=null && !(spl_chart_type.equals("")))
		{
			sql = "SELECT SPL_CHART_TYPE_GRP_APPL_YN FROM CA_SPL_CHART_TYPE WHERE SPL_CHART_TYPE=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,spl_chart_type);
			rset  = pstmt.executeQuery();
			String appl = "N";
			if(rset.next())
				appl = rset.getString(1);
			if(rset!=null)  rset.close(); 
			if(pstmt!=null)  pstmt.close();
			if(appl.equals("Y"))
				flag = true;
			else
				flag = false;
		}
	}
	catch(Exception e)
	{
		//out.println("Exception@1: "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
%>

<%
		if(mode.trim().equalsIgnoreCase("update")) status="disabled"; 
		else status="enabled";
%>


<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<BR>
<form name="splchartgraph_form" id="splchartgraph_form" action="../../servlet/eCA.SplChartGraphServlet" method="post" target="messageFrame">
<table border=0 cellspacing=0 cellpadding=4 width='90%' align='center' >
<tr>
<td class=label><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
<td >
<select name='spl_chart_type' id='spl_chart_type'  onchange='update_form();' <%=status%>>
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
try{
	sql = "Select SPL_CHART_TYPE , SPL_CHART_TYPE_DESC From CA_SPL_CHART_TYPE where eff_status='E' Order by SPL_CHART_TYPE_DESC";
	pstmt = con.prepareStatement(sql);
	rset  = pstmt.executeQuery();
	String chart_type = null,chart_desc = null;
	while(rset!=null && rset.next())
	{
		chart_type=rset.getString("SPL_CHART_TYPE");
		chart_desc=rset.getString("SPL_CHART_TYPE_DESC");
		if(chart_type.equals(spl_chart_type))
		{
			sel="selected";
		}	
		else
		{
			sel="";
		}
  	   
		out.println("<option value='"+chart_type+"' "+sel+" >"+chart_desc+"</option>");
	}
	if(rset!=null)  rset.close(); 
	if(pstmt!=null)  pstmt.close();
}//try 
catch(Exception eg)
{
   //out.println("Exception="+eg.toString());//COMMON-ICN-0181
   eg.printStackTrace();//COMMON-ICN-0181
}
%>	
</select><img src='../../eCommon/images/mandatory.gif'>
</td>
</tr>

<%
if(flag)
{
%>
	<td class='label' ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
		<td class='fields' >
		<SELECT name="spl_chart_group" id="spl_chart_group" onchange='' <%=status%>>
		<%
			//sql = "SELECT SPL_CHART_TYPE_GRP_ID, SPL_CHART_TYPE_GRP_DESC FROM  CA_SPL_CHART_TYPE_GRP WHERE SPL_CHART_TYPE=?";
			sql = "SELECT SPL_CHART_TYPE_GRP_ID, SPL_CHART_TYPE_GRP_DESC FROM  CA_SPL_CHTY_GRP_LANG_VW WHERE SPL_CHART_TYPE=? and LANGUAGE_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,spl_chart_type);
			pstmt.setString(2,locale);
			rset  = pstmt.executeQuery();
			if(rset!=null){
				group_type = "";
				group_desc = ""; %>
			<!--IN058006 start-->
			<!--<option value = '' selected>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>-->
			<option value = ''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<!--IN058006 ends-->
			<%
			while(rset.next()){
				group_type = rset.getString("SPL_CHART_TYPE_GRP_ID")==null?"":rset.getString("SPL_CHART_TYPE_GRP_ID");
				group_desc = rset.getString("SPL_CHART_TYPE_GRP_DESC")==null?"":rset.getString("SPL_CHART_TYPE_GRP_DESC");
			%>
				<option value = <%=group_type%>  <%if(group_type.equals(spl_chart_group))out.print("selected");%>><%=group_desc%></option> 
			<%
			}
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close(); %>
		</SELECT><img src='../../eCommon/images/mandatory.gif'></td>
	
<% }	else
		{
		%>

	<INPUT type='hidden' name='spl_chart_group' id='spl_chart_group' value='*A'/>	
		
<% } %>
		
		<tr>
	<td class=label ><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td ><input type="text" name="graph_code" id="graph_code" value="<%=graph_code%>" <%=status%> size=4 maxlength='4' onkeypress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this);return makeValidString(this);"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td ><input type="text" name="graph_desc" id="graph_desc" value="<%=graph_desc%>"  size='30' maxlength='30' onBlur="return makeValidString(this);"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
<td class=label >X-<fmt:message key="eCA.Axis.label" bundle="${ca_labels}"/></td>
<td ><select name='x_axis' id='x_axis' onChange = 'callOther(this, y_axis)'>
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%

try{
	sql = "SELECT ELEMENT_TYPE,ELEMENT_TYPE_DESC FROM CA_SPL_CHART_ELEMENT_TYPE WHERE ELEMENT_TYPE IN (SELECT NVL(B.ELEMENT_TYPE,'***') FROM CA_CHART A,CA_CHART_SECTION_COMP B WHERE A.SPL_CHART_TYPE=? AND A.CHART_ID=B.CHART_ID)";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,spl_chart_type);
	rset  = pstmt.executeQuery();
	String ele_type = null,ele_desc = null;


	if(x_axis.equals("*K"))
	{
		sel = "selected";
	}
	else
		sel = "";
	out.println("<option value='*K' "+sel+">"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"</option>");
	while(rset!=null && rset.next())
	{
		ele_type=rset.getString("ELEMENT_TYPE");
		ele_desc=rset.getString("ELEMENT_TYPE_DESC");
		if(ele_type.equals(x_axis))
		{
			sel="selected";
		}	
		else
		{
			sel="";
		}
		out.println("<option value='"+ele_type+"' "+sel+" >"+ele_desc+"</option>");

	}
	if(rset!=null)  rset.close(); 
	if(pstmt!=null)  pstmt.close();
}//try 
catch(Exception eg)
{
   //out.println("Exception="+eg.toString());//COMMON-ICN-0181
    eg.printStackTrace();//COMMON-ICN-0181
}
%>	
</select><img src='../../eCommon/images/mandatory.gif'>
</td>
</tr>
<tr>
<td class=label >Y-<fmt:message key="eCA.Axis.label" bundle="${ca_labels}"/></td>
<td ><select name='y_axis' id='y_axis' onChange = 'callOther(this, x_axis)'>
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
try{
	sql = "SELECT ELEMENT_TYPE,ELEMENT_TYPE_DESC FROM CA_SPL_CHART_ELEMENT_TYPE WHERE ELEMENT_TYPE IN (SELECT NVL(B.ELEMENT_TYPE,'***') FROM CA_CHART A,CA_CHART_SECTION_COMP B WHERE A.SPL_CHART_TYPE=? AND A.CHART_ID=B.CHART_ID)";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,spl_chart_type);
	rset  = pstmt.executeQuery();
	String ele_type1 = null,ele_desc1 = null;
	while(rset!=null && rset.next())
	{
		ele_type1=rset.getString("ELEMENT_TYPE");
		ele_desc1=rset.getString("ELEMENT_TYPE_DESC");
		if(ele_type1.equals(y_axis))
		{
			sel="selected";
		}	
		else
		{
			sel="";
		}
		out.println("<option value='"+ele_type1+"' "+sel+" >"+ele_desc1+"</option>");
	}
	if(rset!=null)  rset.close(); 
	if(pstmt!=null)  pstmt.close();
}//try 
catch(Exception eg)
{
   //out.println("Exception="+eg.toString());//COMMON-ICN-0181
    eg.printStackTrace();//COMMON-ICN-0181
}
finally
{

	if (con!= null)
	ConnectionManager.returnConnection(con,request);
}
%>	
</select><img src='../../eCommon/images/mandatory.gif'>
</td>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  ><input type="checkbox" name="eff_status" id="eff_status" value="<%=eff_status%>" <%=enabled_checked%> OnClick ='checkForMode(this)'></td>
</tr>
</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="spl_chart_type1" id="spl_chart_type1" value="<%=spl_chart_type%>">
<input type=hidden name="spl_chart_group1" id="spl_chart_group1" value="<%=spl_chart_group%>">
<input type=hidden name="graph_code1" id="graph_code1" value="<%=graph_code%>">
<input type=hidden name="graph_desc1" id="graph_desc1" value="<%=graph_desc%>">
<input type=hidden name="x_axis1" id="x_axis1" value="<%=x_axis%>">
<input type=hidden name="y_axis1" id="y_axis1" value="<%=y_axis%>">
<input type=hidden name="eff_status1" id="eff_status1" value="<%=eff_status%>">
</form>
</body>
</html>

