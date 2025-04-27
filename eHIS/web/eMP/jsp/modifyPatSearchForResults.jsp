<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'> </script>
<script src='../js/PatSearchForResult.js' language='javascript'></script>


<%
	String code="";
	String longdesc="";
	String order="";
	String eff_status="";
	String s="",s1="",d1="";
	String rdonly="";

	PreparedStatement pstmt=null;
	ResultSet rset=null;

	PreparedStatement pstmt1 = null;
	ResultSet rset1 = null;

	int maxVal = 0;
	Connection conn =null;
	try
	{
	    code=request.getParameter("field_name");
	    %>
			<html><head>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head><body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			<%
	    //Connection conn = (Connection) session.getValue( "connection" );
		conn = ConnectionManager.getConnection(request);
	    pstmt = conn.prepareStatement("select field_name,field_desc,field_order,field_select from mp_pat_search_result where field_name=? ");
	    pstmt.setString(1, code);
		pstmt1 = conn.prepareStatement("select count(*) from mp_pat_search_result");
	    rset=pstmt.executeQuery();
		rset1 = pstmt1.executeQuery();
		if (rset1.next()){
			maxVal = rset1.getInt(1);
		}
	    if(rset != null)
	    	{
		   rset.next();
		   code = rset.getString("field_name");
		   longdesc = rset.getString("field_desc");
		   order =rset.getString("field_order");
		   eff_status=rset.getString("field_select");

		   if(code.equalsIgnoreCase("pat_photo"))
			{
		   		rdonly="readonly";
			}
		   if(order==null)
		   	order="";
		 }
	}
	catch(Exception e)
	{
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174210669 on 30-08-2023
	}
	finally
	{
		if(pstmt !=null) pstmt.close();
		if(rset !=null)	rset.close();

		if(pstmt1 !=null) pstmt1.close();
		if(rset1 !=null)	rset1.close();
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>


<SCRIPT>
var i=0;
function clk()
{
	if (patient_form.fld_nm.value !='Pat_Photo')
	{
		if (patient_form.select1.checked == false)
		{
			patient_form.order1.disabled=true;
			patient_form.order1.value ="";
		}
		else if (patient_form.select1.checked == true)
		{
			patient_form.order1.disabled=false;
		}
	}
	else
		patient_form.order1.value = "<%=maxVal%>";
/*	var prop="";
	//var prop='<%=rdonly%>'
	//if(!patient_form.select1.checked)
	//	patient_form.order1.value=""

	i++;
	var newval=patient_form.long_desc.value
	var oldval=patient_form.long_desc1.value

	var onval=patient_form.order1.value
	var ooval=patient_form.order2.value

	if(prop=="readonly" && patient_form.select1.checked)
		patient_form.order1.value='<%=(maxVal)%>';
	else
	{
		if(i>1 && oldval!=newval)
		{
			patient_form.long_desc.value=patient_form.long_desc1.value
		}
		if(i>1 && ooval!=onval)
		{
			patient_form.order1.value=patient_form.order2.value
			if(!patient_form.select1.checked)
			patient_form.order1.value=""
		}
	}*/
}

function chkk(comp)
{
/*	//var prop='<%=rdonly%>'
	var prop="";
	if(!patient_form.select1.checked)
	{
		comp.blur();patient_form.order1.value=""
	}
	else
		if(prop=="readonly")
			patient_form.order1.value='18';
*/
}
</SCRIPT>

</head>

<body onKeyDown='lockKey()'>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="Focusing('fld_nm');">
		<form name='patient_form' id='patient_form' action='../../servlet/eMP.PatSearchForResultsServlet' method='post' target='messageFrame'>
		<BR><BR><BR><BR><BR><BR><BR><BR><BR>
		<div align='center'>
			<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>

			<tr>
				<td width='10%'>&nbsp;</td>
				<td colspan='2'>&nbsp;</td>
				<td width='20%'>&nbsp;</td>
			</tr>

    				<tr>
    				     <td width='40%' class='label'><fmt:message key="eMP.FieldName.label" bundle="${mp_labels}"/></td>
    				     <td width='60%' class='fields' colspan='2'>
    				     <input type='text' name='fld_nm' id='fld_nm' value="<%=code%>" size='30'maxlength='30' readonly >&nbsp;<img src='../images/mandatory.gif'></img> </td>
    				     <td>&nbsp;</td>
    				</tr>

				<tr>
				    <td width='40%' class='label'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				    <%
				    s="";
				    out.println("<td width='60%' class='fields'  colspan='2'><input type='checkbox' name='select1' id='select1' value='Y' ");
				    if(eff_status.equals("Y"))
				    	{s1="checked";}
				    else
				    	{/*s="readonly";*/}
				 	out.println(s1+" value='Y' onclick='clk()'>&nbsp</td>");
				    %>
				    <!--td width='60%' align='left' colspan='2'>&nbsp;&nbsp;</td-->
				    <td>&nbsp;</td>
  				  </tr>
   				<tr>
    				     <td width='40%' class='label'><fmt:message key="eMP.FieldTitle.label" bundle="${mp_labels}"/></td>
      				     <td width='60%'class='fields' colspan='2'>
                                     <input type='text' name='long_desc' id='long_desc' value="<%=longdesc%>" size='30' onFocus='chkk(this)' maxlength='30' style='{ font-size: ;}'  <%out.print(s);%> >&nbsp;<img src='../images/mandatory.gif' ></td>
                                     <input type='hidden' name='long_desc1' id='long_desc1' value="<%=longdesc%>" size='30' maxlength='30' style='{ font-size: ;}'  <%out.print(s);%> >
						<td>&nbsp;</td>
    			    </tr>
    				<tr>
      				     <td width='40%' class='label'><fmt:message key="Common.Order.label" bundle="${common_labels}"/></td>
				     <td width='60%' class='fields'  colspan="2">
					 <%
					    if(eff_status.equals("N"))
							{d1="disabled";}
						%>
      				     <input type='text' name='order1' id='order1' value="<%=order%>" size='2' maxlength='2' onkeypress="return allowValidNumber(this,event,2, 0);" onFocus='chkk(this)' onBlur='CheckNum(this)' <%out.print(s);%>  <%=rdonly%> <%=d1%>>&nbsp;</td>
      				     <input type='hidden' name='order2' id='order2' value="<%=order%>" size='2' maxlength='2'>
      				     <input type='hidden' name='order3' id='order3' value="<%=rdonly%>"  >
					<td>&nbsp;</td>
    				</tr>

			<tr>
				<td>&nbsp;</td>
				<td colspan='2'>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

			</table>
		</div>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<input type='hidden' name='eff_date_from' id='eff_date_from' >
		<input type='hidden' name='eff_date_to' id='eff_date_to' >
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='start' id='start' value='1'>
		<input type='hidden' name='stop' id='stop' value="<%=(maxVal)%>">
	</form>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

