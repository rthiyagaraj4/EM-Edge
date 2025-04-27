<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<%
	Connection con =null;

	
	Statement stmt = null;
	ResultSet rs=null;
	
try{
	
	String pat_ser_grp_code=request.getParameter("pat_ser_grp_code");	
	
	
	int i=0;
	
	String prefix_or_suffix_length = "";//request.getParameter("prefix_or_suffix_length");
	String relationship_level="";
	String relationship_level_desc="";
	String sex_ind="";
	String prefix1="";
	String prefix2="";
	String prefix3="";
	
	String select_check_box="";
	String chkboxAttribute="";
	String combined_rel_level_code="";

	String sex_ind1="";
	int maxRecord = 0;


%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/PatientNumberingForRelation.js' language='javascript'>
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' >
<form name="patnum_altid_result" id="patnum_altid_result" action="../../servlet/eMP.PatNumberingRelationServlet" method="post" target="messageFrame">
<table border="1" cellpadding="" cellspacing="0" width="90%" align='center'>

<tr>
		
		<td class='columnheader' ><div  id='head3' width='2'  class='myClass'><fmt:message key="eMP.RelationshipLevel.label" bundle="${mp_labels}"/></div></td>
		<td class='columnheader' ><div  id='head3'  class='myClass'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></div></td>
		<td class='columnheader' ><div  id='head3'  class='myClass'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></div></td>
		<!-- <td class='columnheader' ><div  id='head3'  class='myClass'><fmt:message key="eMP.Prefix1.label" bundle="${mp_labels}"/></div></td> -->
		<!-- <td class='columnheader' ><div  id='head3'  class='myClass'><fmt:message key="eMP.PrefixSuffix.label" bundle="${mp_labels}"/></div></td> -->
		<td class='columnheader' ><div  id='head3'  class='myClass'><fmt:message key="Common.length.label" bundle="${common_labels}"/></div></td>
		<!--
		<td class='columnheader' ><div  id='head3'  class='myClass'><fmt:message key="eMP.Prefix1.label" bundle="${mp_labels}"/></div></td>
		<td class='columnheader' ><div  id='head3'  class='myClass'><fmt:message key="eMP.Prefix2.label" bundle="${mp_labels}"/></div></td>
		<td class='columnheader' ><div  id='head3'  class='myClass'><fmt:message key="eMP.Prefix3.label" bundle="${mp_labels}"/></div></td>
		-->
		<td colspan='3'>
		
			 <table border="0" cellpadding="0" cellspacing="1" width='100%'>
				<tr>
					<td class='columnheader' colspan ='3' align ='center'><fmt:message key="eMP.RelationShipLevInd.label" bundle="${mp_labels}"/></td>
				</tr>
				<tr>
					<td class='columnheader' colspan ='1' align ='center'>1</td>
					<td class='columnheader' colspan ='1' align ='center'>2</td>
					<td class='columnheader' colspan ='1' align ='center'>3</td>
				</tr>
			</table>
		
		</td>
		<td class='columnheader' ><div  id='head4'  class='myClass'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></div></td>

</tr>

<%
	String sql="select relationship_level_length  prefix_or_suffix_length,relationship_level,combined_rel_level_code,relationship_level_desc,sex_ind,prefix1,prefix2,prefix3,select_check_box from mp_rel_for_pat_ser_grp_vw where pat_ser_grp_code='"+pat_ser_grp_code+"'";



	//String sql="select relationship_level,combined_rel_level_code,relationship_level_desc,sex_ind,prefix1,prefix2,prefix3,select_check_box from mp_rel_for_pat_ser_grp_vw where pat_ser_grp_code='"+pat_ser_grp_code+"'";

	//out.println("sql is:"+sql);

	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);

	
	while(rs.next())
	{
		
		prefix_or_suffix_length=rs.getString("prefix_or_suffix_length")==null ? "":rs.getString("prefix_or_suffix_length");
		
		relationship_level=rs.getString("relationship_level")==null ? "":rs.getString("relationship_level");
		relationship_level_desc=rs.getString("relationship_level_desc")==null ? "":rs.getString("relationship_level_desc");
		sex_ind=rs.getString("sex_ind")==null ? "":rs.getString("sex_ind");
				if (sex_ind.equals("M"))
					sex_ind1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (sex_ind.equals("F"))
					sex_ind1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		        else if (sex_ind.equals("U"))
					sex_ind1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");


		prefix1=rs.getString("prefix1")==null ? "":rs.getString("prefix1");
		prefix2=rs.getString("prefix2")==null ? "":rs.getString("prefix2");
		prefix3=rs.getString("prefix3")==null ? "":rs.getString("prefix3");
		select_check_box=rs.getString("select_check_box")==null ? "":rs.getString("select_check_box");
		combined_rel_level_code=rs.getString("combined_rel_level_code")==null ? "":rs.getString("combined_rel_level_code");
		

		


		if(select_check_box.equals("Y"))
				chkboxAttribute ="CHECKED";
			else
				chkboxAttribute="";
		

		String classValue = "" ;
		if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

		  out.println("<tr> ");
			maxRecord++;

			

if(chkboxAttribute == "")
{
	out.println("<td class='" + classValue + "' width='2'>");
	out.println(relationship_level +"</td>");
	out.println("<td class='" + classValue + "'>");
	out.println(relationship_level_desc +"</td><td class='" + classValue + "' width='3'>");
	out.println(sex_ind1 +"</td>");
	// out.println(prefix1 +"</td><td class='" + classValue + "'>"); 

	%>
	
	<%
	out.println("<td class='" + classValue + "'>");
	%>
	<input type='hidden' name="combined_rel_level_code<%=i%>" id="combined_rel_level_code<%=i%>" value=<%=combined_rel_level_code%> >
	<input type='hidden' name="sex_indicator<%=i%>" id="sex_indicator<%=i%>" value=<%=sex_ind%> >
	<input type='text' size='2' name="prefix_or_suffix_length<%=i%>" id="prefix_or_suffix_length<%=i%>" value=<%=prefix_or_suffix_length%>  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='ChkLength(this);' maxLength='1'>
     <%
	out.println("</td><td class='" + classValue + "'>");
	// out.println("<td class='" + classValue + "'>");
	%>
	<!--<input type='hidden' name="combined_rel_level_code<%=i%>" id="combined_rel_level_code<%=i%>" value=<%=combined_rel_level_code%> >
	<input type='hidden' name="sex_indicator<%=i%>" id="sex_indicator<%=i%>" value=<%=sex_ind%> >-->
	<input type='text' name='prefix1<%=i%>' id='prefix1<%=i%>' size='3' value='' onKeyPress='return(ChkNumberInput(this,event,0))' maxLength='2' onBlur='unCheckCheckBox(this);' >
	<%
	out.println("</td><td class='" + classValue + "'>");
	%>
	<input type='text' name='prefix2<%=i%>' id='prefix2<%=i%>' size='3' value='' onKeyPress='return(ChkNumberInput(this,event,0))' maxLength='2' onBlur='unCheckCheckBox(this);'>
	<%
	out.println("</td><td class='" + classValue + "'>");
	%>
	<input type='text' name='prefix3<%=i%>' id='prefix3<%=i%>' size='3' value='' onKeyPress='return(ChkNumberInput(this,event,0))' maxLength='2' <% if(prefix_or_suffix_length!=null && prefix_or_suffix_length.equals("3")){ %> disabled <%}%> onBlur='unCheckCheckBox(this);'>
	<%
	out.println("</td>");
	 out.println("<td class='" + classValue + "'>");

%>

	<input type=checkbox name="select<%=i%>" id="select<%=i%>" onclick="ChkPrefixLength(this)" value="<%=pat_ser_grp_code%>$<%=i%>"  <%=chkboxAttribute%> >
	
	<%
	out.println("</td></tr>");
}
else
{
	
	out.println("<td class='" + classValue + "'>");
	
	out.println(relationship_level +"</td><td class='" + classValue + "'>");
	out.println(relationship_level_desc +"</td><td class='" + classValue + "'>");
	out.println(sex_ind1 +"</td>");
	//out.println(prefix1 +"</td><td class='" + classValue + "'>");

	%>
	
	
	<%

	out.println("<td class='" + classValue + "'>");
	%>
	<input type='hidden' name='combined_rel_level_code<%=i%>' id='combined_rel_level_code<%=i%>' value=<%=combined_rel_level_code%> >
	<input type='text' size='3' name="prefix_or_suffix_length<%=i%>" id="prefix_or_suffix_length<%=i%>" value=<%=prefix_or_suffix_length%> disabled>	
	<input type='hidden' name="sex_indicator<%=i%>" id="sex_indicator<%=i%>" value=<%=sex_ind%> >
	
	<%
	out.println("</td><td class='" + classValue + "'>");
	//out.println("<td class='" + classValue + "'>");
	%>
	<!--<input type='hidden' name='combined_rel_level_code<%=i%>' id='combined_rel_level_code<%=i%>' value=<%=combined_rel_level_code%> >-->
	<input type='text' name='prefix1<%=i%>' id='prefix1<%=i%>' size='3' value='<%=prefix1%>' disabled>
	<%
	out.println("</td><td class='" + classValue + "'>");
	%>
	<input type='text' name='prefix2<%=i%>' id='prefix2<%=i%>' size='3' value='<%=prefix2%>' disabled>
	<%
	out.println("</td><td class='" + classValue + "'>");
	%>
	<input type='text' name='prefix3<%=i%>' id='prefix3<%=i%>' size='3' value='<%=prefix3%>' disabled>
	<%
	out.println("</td>");
   out.println("<td class='" + classValue + "'>");
   
%>


	
	
	<input type=checkbox name="select<%=i%>" id="select<%=i%>" value="<%=pat_ser_grp_code%>$<%=i%>" <%=chkboxAttribute%>  disabled >
	<%
	out.println("</td></tr>");
}
	i++;


	}
	%>
<input type=hidden name='maxRecord1' id='maxRecord1' value='<%=maxRecord%>'>
<input type=hidden name='pat_ser_grp_code' id='pat_ser_grp_code' value='<%=pat_ser_grp_code%>'>
</table>
</form>
<%


}catch(Exception e)
	{
	out.println(e.getMessage());
	e.printStackTrace();
	}
	finally
	{
	try
	{
	if (stmt != null) stmt.close();
	if (rs != null)   rs.close();
	ConnectionManager.returnConnection(con,request);
	}
	catch(Exception exp)
	{
		out.println(exp.toString());
	}
	}		

%>

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

