<!DOCTYPE html>

<!-- Program for to search the Clinic -->

<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	String called_from=request.getParameter("called_from");
	String facility_id=(String)session.getValue("facility_id");
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null;
	ResultSet rs=null;
	
	try{
        con=ConnectionManager.getConnection(request);
	    String dat="";
		String id="";
		String careind="";
	%>

<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
    	<script src='../../eOP/js/ClinicService.js' language='javascript'></script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
	TD.BLANKROW{
		FONT-SIZE: 2 pt; 
	}

	</style>

<script>
	var careArray=new Array();
	var i=1;
</script>
</head>
<body onLoad='FocusFirstElement();ChkClinic();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='Search_form' id='Search_form'>
  <table border='0' cellpadding='1' cellspacing='0' width='100%' align='center'>
	 <tr><td colspan='4'>&nbsp;</td></tr>	
	 <tr>
	  	 <td class='label' width='23%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		 <td class='fields' width='23%' id=td5>
			<%
			/*if(count>15) commented this condition and made true always to get through search and
			left the else part as it is for future modification. */
			if(true)
			{	 
			%>
			 
			 <select name="clinic_code" id="clinic_code" onchange="rem();">
				<option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				 bundle="${common_labels}"/> --------&nbsp;</option>

			 <%						    
				try{ 
				pstmt=con.prepareStatement("select short_desc,locn_type,care_locn_type_ind from am_care_locn_type where care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') and  SYS_USER_DEF_IND='S' order by short_desc");
					rset=pstmt.executeQuery() ;
					if(rset!=null)
							{
								while(rset.next())
								{
									dat=rset.getString("short_desc");
									id=rset.getString("locn_type");
									careind=rset.getString("care_locn_type_ind");
									%>
										<option value='<%=id%>' ><%=dat%>
									<script>
										careArray[i]="<%=careind%>";
									      i++;
									</script>
									<%
																
									}
							}

							if(pstmt != null) pstmt.close();
							if(rset != null) rset.close();
						}catch(Exception e){out.println("Exp in am_care_locn_type list "+ e.toString());}
				%>				
			 </select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			<%
			}
			%>	
			</td>
			<td class='label' width='19%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='fields' id="td5" width='35%' nowrap>
			 <%
				/*if(count>15) commented this condition and made true always to get through search and
				left the else part as it is for future modification. */
				if(true)
				{	 
			%>
			<INPUT TYPE="text" name="clinic_code2" id="clinic_code2"  onBlur="onBlurgetLoc('<%=facility_id%>',document.Search_form.clinic_code.value,document.Search_form.clinic_code2);PopulateValues(this);"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=facility_id%>',document.Search_form.clinic_code.value,document.Search_form.clinic_code2);PopulateValues(document.forms[0].clinic_code2);" ><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			<input type="hidden" name="clinic_code1" id="clinic_code1">
			<!--
			<SELECT name="clinic_code1" id="clinic_code1" onchange="PopulateValues(this)" >
			<option selected value="">&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option></SELECT> 
			-->						
			<%
			}
			%>	
			</td>
		</tr>		
		<tr><td colspan='4'>&nbsp;</td></tr>
	</table>		 
		
		
	<!-- <td class='fields'><input type=button class=button value='Search' name='Search' id='Search' onclick='PopulateResult()'></td> -->		
   
		
	<table border='0' cellpadding='1' cellspacing='0' width='100%' align='center' id="tab" style='visibility:hidden'>
	<tr>
	<td class=label width='23%'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
	<td class='querydata' id='td2' width='23%'></td>
	<td class=label width='19%'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
	<td class='fields' id='td3' width='35%'><select name='dept_desc' id='dept_desc' onchange="clearResultPage()">
	<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
		<%	try
				{
					String deptSql = " SELECT b.DEPT_CODE, a.SHORT_DESC FROM AM_DEPT a, AM_FACILITY_DEPT b WHERE a.EFF_STATUS = 'E' and a.DEPT_CODE = b.DEPT_CODE and b.OPERATING_FACILITY_ID ='"+facility_id+"' ORDER BY 2 ";
					String id1="";
					String dat1="";
					
					stmt=con.createStatement();
					rs=stmt.executeQuery(deptSql);
					if(rs!=null)
					{
						while(rs.next())
						{
							id1=rs.getString("DEPT_CODE");
							dat1=rs.getString("SHORT_DESC");
							out.println("<option value='"+id1+"'>"+dat1+"</option>");
						}
					}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();

				}catch(Exception e) 
				{
					out.println(e);
				}
			%>
	</select></td>
	</tr>	
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
		<td class=label><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='querydata' id=td4></td>
	    <td class=label><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='querydata' id=td6></td>
		</tr>	
	<tr>
			<td colspan='3'>&nbsp;</td>
			<td align='right'><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' name='Search' onclick='PopulateResult()'>	
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
</table>
<input type=hidden name=called_from value='<%=called_from%>'>
<input type=hidden name=facility_id value='<%=facility_id%>'>
<input type=hidden name=dept_code value=''>

<input type=hidden name='careind' id='careind' value=''>
</form>
<%
}
catch ( Exception e ){out.println(e.toString());}

finally{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>

