<!DOCTYPE html>
<%--
	FileName	:DiscretePanelAddModify.jsp
	Version	    : 3	
	Created On	: 28-04-2005
	Created By	: Ashok Raja 
--%>

<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script language='javascript' src='../../eAM/js/DiscretePanel.js'></script>
<script>
function f1()
{
	//var mode=document.forms[0].mode.value;
	//if(mode=='update')
	eval("parent.frames[2].document.DiscrPanelQueryResult_form"+<%=associateDiagBean.clearAll()%>);
		
}
</script>
</head>


<body onLoad='FocusFirstElement();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad=' loadPage()' >
<%
	
	Connection con=null;
	String sql="";
	//PreparedStatement pstmt=null;
	PreparedStatement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
		
	String mode="";
	String code ="";

	String discrete_msr_id="";
	String long_desc="";
	String short_desc="";
	String service1="";
	String result_type="";
	String eff_status="";

	String service="";
	String shortdesc="";

	String enabled_checked="checked";
	String sel="";
	String status="";
	//String readOnly = "";
	String rd="";
	String status1="";

	//String id="";
	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String servicesql = " select service_code, SHORT_DESC from am_service where EFF_STATUS = 'E' order by 2 "; 

	mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	code= (request.getParameter("discr_msr_id")==null)?"":request.getParameter("discr_msr_id");

	try
	{
			con =	ConnectionManager.getConnection(request);
			if(mode.trim().equalsIgnoreCase("update")) 
			{
				rd="disabled";
				 sql = " SELECT DISCR_MSR_ID,LONG_DESC,SHORT_DESC,SERVICE_CODE,RESULT_TYPE,NUM_DIGITS_MAX,NUM_DIGITS_MIN,RESULT_TEMPLATE_ID,NUM_DIGITS_DEC,REF_RANGE_TYPE,EFF_STATUS FROM AM_DISCR_MSR where DISCR_MSR_ID=? and result_type in('G','V','Z') ";

				// stmt=con.prepareStatement(sql);
				//	rs = stmt.executeQuery();
				
					pstmt   = con.prepareStatement(sql);
					pstmt.setString	(	1,	code		);
					rs		 = pstmt.executeQuery();
						if(rs.next())

						{
							
							discrete_msr_id=	(rs.getString("DISCR_MSR_ID")==null)?"":rs.getString("DISCR_MSR_ID");
							long_desc= (rs.getString("LONG_DESC")==null)?"":rs.getString("LONG_DESC");
							short_desc=(rs.getString("SHORT_DESC")==null)?"":rs.getString("SHORT_DESC");
							service1=(rs.getString("SERVICE_CODE")==null)?"":rs.getString("SERVICE_CODE");
							result_type=(rs.getString("RESULT_TYPE")==null)?"":rs.getString("RESULT_TYPE");
							eff_status=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");

							if(eff_status.equals("E"))
								enabled_checked="checked";
								else
								{
                                    //out.println("<script>parent.frames[3].location.href='parent.frames[3].location.href='../../eAM/jsp/DiscretePanelAddtoPanelElement.jsp?mode="+mode+"'</script>");  

									//out.println("<script>alert('inside else')</script>");

									out.println("<script>parent.frames[3].document.forms[0].id.disabled=true</script>");

									enabled_checked="";
									
								
								}
						}
				if(rs!=null)  rs.close(); 
				if(stmt!=null)  stmt.close();
			}
	}
	catch(Exception e)
	{
	//out.println("Exception@1: "+e.toString());
	e.printStackTrace(System.err);
	}

	%>


<form name='DiscrPanel_form' id='DiscrPanel_form' action='../../servlet/eAM.DiscretePanelServlet' method='post' target='messageFrame'>
<table border='0' cellpadding='0' cellspacing='0'  width='102%' align='left'>
<br><br>

<tr>
	<td width="25%">&nbsp;</td>
	<td >&nbsp;</td>
	
</tr> 
<tr>

<%
	
	if(mode.trim().equalsIgnoreCase("update")&& (eff_status.equals("E"))) 
	{status="enabled" ;
	//readOnly = ""; 
	}else{status="disabled";
	//readOnly = "readonly";
	}
	
	if(mode.trim().equalsIgnoreCase("update")) 
	{status1="disabled";
	//readOnly = "readonly";
	}
	
	if(mode.trim().equalsIgnoreCase("insert")){
		status="enabled";
		//readOnly = "";
		}%>
	    
		<td class=label  width='25%'><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></td>
		
		<td class=fields>&nbsp;&nbsp;<select name='result_type' id='result_type' <%=status1%> onChange="displayPanel();">
		<option value="">----------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------</option>
		<%if (result_type.equals("G")) sel="selected"; else sel="";%>
			<option value="G" <%=sel%> ><fmt:message key="eAM.ChartSection.label" bundle="${am_labels}"/></option>
		<%if (result_type.equals("V")) sel="selected"; else sel="";%>
			<option value="V" <%=sel%>> <fmt:message key="Common.VitalSignsBattery.label" bundle="${common_labels}"/></option>
		<%if (result_type.equals("Z")) sel="selected"; else sel="";%>
			<option value="Z" <%=sel%> > <fmt:message key="eAM.PatientCarePanel.label" bundle="${am_labels}"/></option>

		</select>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
</tr>

<tr>


	<td    class='label' > <fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td class=fields>&nbsp;&nbsp;<input type='text' name="discr_panel_id" id="discr_panel_id" value="<%=discrete_msr_id%>" <%=rd%>  size='10' maxlength='10' onKeyPress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this)" >
	<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
</tr>

<tr>
	<td   class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td  class=fields>&nbsp;&nbsp;<input type='text'  name='long_desc' id='long_desc' value="<%=long_desc%>" <%=status%>  size="60" maxlength="60" onBlur="makeValidString(this)"" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td   class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td  class=fields>&nbsp;&nbsp;<input type='text'  name='short_desc' id='short_desc' value="<%=short_desc%>" <%=status%>  size="30" maxlength="30"  onBlur="makeValidString(this)" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
		<td class=label  ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class=fields>&nbsp;&nbsp;<select name='service' id='service' <%=status%> onchange=''>
		<option value=" ">------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------------</option>
	
	<%
	try
{
	
	stmt= con.prepareStatement(servicesql);
	rs = stmt.executeQuery();
	while(rs!=null && rs.next())
	{
		service=rs.getString("service_code");
		//out.println("<script>alert('"+service+"')</script>");
		shortdesc=rs.getString("SHORT_DESC");
		//out.println("<script>alert('"+shortdesc+"')</script>");
		if(service1.equals(service))
		{
			sel="selected";
		}	
		else
		{
			sel="";
		}
		
		out.println("<option value='"+service+"' "+sel+"  >"+shortdesc+"</option>");
	}
	
	if(rs!=null)  rs.close(); 
	if(stmt!=null)  stmt.close();
}//try 

catch(Exception eg)
{
  // out.println("Exception="+eg.toString());
  eg.printStackTrace();
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 

%>	
</select>&nbsp; <img src='../../eCommon/images/mandatory.gif' align='center'></img>
</td>
</tr>
<tr>
	<td  class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  class=fields>&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E"  <%=enabled_checked%> onClick="checkstatus(this)">
	</td>
</tr>
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>
</table>


<input type='hidden' name='mode' id='mode' value=<%=mode%>>
<input type='hidden' name='result_type1' id='result_type1' value='<%=result_type%>'>
<input type='hidden' name='discr_panel_id1' id='discr_panel_id1' value='<%=discrete_msr_id%>'>
<input type='hidden' name='long_desc1' id='long_desc1' value='<%=long_desc%>'>
<input type='hidden' name='short_desc1' id='short_desc1' value='<%=short_desc%>'>
<input type='hidden' name='service1' id='service1' value='<%=service1%>'>



</form>
<script>
	parent.discrete.rows="14%,34%,*,8%";
	<%
		if(mode.equals("update"))
	{%>
var discreteid=document.forms[0].discr_panel_id.value;
parent.frames[3].location.href="../../eAM/jsp/DiscretePanelAddtoPanelElement.jsp?mode=update" ;
parent.frames[2].location.href="../../eAM/jsp/DiscretePanelQueryCriteriaResult.jsp?mode=update&discreteid="+discreteid+"";
<%}
%>
</script>
</body>
</html>

