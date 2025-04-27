<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%

	request.setCharacterEncoding("UTF-8");
%>

<HTML>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

Connection con=null;
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 
<script src='../../eCA/js/CACalculator.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	
	/*function check(cardiac){
	
		var cardiacOutput = document.forms[0].cardOutput.value;
		var BSA = document.forms[0].BSA.value;
		var weight=document.forms[0].weight.value;
		var height=document.forms[0].height.value;
		if(cardiacOutput!=null || BSA!=null || height!=null || weight!=null){
		if (isNaN(cardiacOutput) || isNaN(BSA)==true || isNaN(height) || isNaN(weight)) {
			alert("Please enter a number");
			cardiac.select();
			return false;
		}
		}
	}	*/	
			
		
	
	


</script>

<%
   try
   {

	

	String formula_ref_id ="";
	String formula_detail ="";
	String formula_ref_desc ="";


	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
	String qry ="select r.FORMULA_REF_ID,g.FORMULA_REF_DESC ,g.FORMULA_DETAIL from CA_CLINICAL_CALC r,CA_CLIN_CALC_DEF g where r.CALC_ID=g.CALC_ID and r.FORMULA_REF_ID=g.FORMULA_REF_ID and r.CALC_ID='BSA'";

	stmt = con.prepareStatement(qry);
	rs = stmt.executeQuery();

	while(rs.next())
	{
		formula_ref_id = rs.getString("FORMULA_REF_ID");
		formula_detail = rs.getString("FORMULA_DETAIL");
		formula_ref_desc = rs.getString("FORMULA_REF_DESC");
	
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();




%>

</HEAD>

<BODY class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name ='CalInchtoCMSForm' >
<table  width ='100%' height='25%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>
		<tr><th colspan='5' align='left'>&nbsp;<fmt:message key="Common.BSA.label" bundle="${common_labels}"/></th>
			<tr>
					<td class='LABEL' align ='left' width=40%><fmt:message key="Common.height.label" bundle="${common_labels}"/>&nbsp;(<fmt:message key="Common.Cms.label" bundle="${common_labels}"/>)&nbsp;</td>
						<td class=label><input type='text' name ='HeitInput' size ='10' class="DATA" style="text-align: Right" maxLength ='10' onBlur='CheckNum(this);CheckNoVal(this)'> </td> 
								<td class='LABEL' align ='right' width=40%><fmt:message key="Common.weight.label" bundle="${common_labels}"/> &nbsp;(<fmt:message key="Common.Kgs.label" bundle="${common_labels}"/>)&nbsp;</td><td class=label><input type='text' name ='WeitInput' size ='10' class="DATA" style="text-align: Right" maxLength ='10' onBlur='CheckNum(this);CheckNoVal(this)'> </td> 	
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		
			<tr>
					<td class='LABEL' align ='left' width=40% ><fmt:message key="Common.BSA.label" bundle="${common_labels}"/>&nbsp;</td><td class=label colspan='4' id='BSAOut'></td> 
				
			</tr>

			<tr>
					<td  align=center colspan='4' align='center'><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' onClick='CaluculateBSA()' class="BUTTON" ></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
	
</table>
&nbsp;
	<table width ='100%' height='10%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>	
		<tr><th colspan=4 align=left>&nbsp;<fmt:message key="eCA.FormulaAdopted.label" bundle="${ca_labels}"/>&nbsp;&nbsp;:&nbsp;&nbsp;<%=formula_ref_desc%>&nbsp;&nbsp;</th></tr>
				<tr>
						<!--<td colspan=2 align='left' class ='LABEL'>&nbsp;BSA:<br><br>
							&nbsp;&nbsp;&nbsp;(0.007184 * power(Height,0.725) * power(Weight,0.425))</td> -->

							<td colspan=2 align='left' class ='LABEL' nowrap>&nbsp;<fmt:message key="Common.BSA.label" bundle="${common_labels}"/>:<br><br>
							&nbsp;&nbsp;&nbsp;<%=formula_detail%></td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>		
			    </tr>
		
				<tr>
						<td colspan=2 align=left   class ='LABEL'></td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>

</table>
<input type='hidden' name='formula_ref_id' id='formula_ref_id' value="<%= formula_ref_id %>">
</form>
</BODY>
</HTML>
<%
}
catch(Exception e)
{
	
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

