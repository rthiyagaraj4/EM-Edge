<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet rs1 =null;
	ResultSet rs3=null;
	PreparedStatement pstmt1 =null;
    
	String Chart = "";
	String Numbering ="";
	String Soundex ="";
	String CardTitle ="";
	String Line1 ="";
	String Line2 ="";
	String Line3 ="";
	String Line4 ="";
	String Line5 ="";
	String Line6 ="";
	String Line7 ="";
	String Line8 ="";
	String Line9 ="";
	String Line10 ="";
    String id_len="";
	String tm_req="";


try 
{
		con = ConnectionManager.getConnection(request);
		pstmt1 = con.prepareStatement("Select terminal_digit_reqd_yn, to_char(patient_id_length) as patient_id_length from mp_param");
		rs3= pstmt1.executeQuery();
		if(rs3.next())
		{
			tm_req=rs3.getString(1);
			if(tm_req==null)tm_req="N";
			id_len=rs3.getString(2);
		}
		pstmt = con.prepareStatement("Select Single_Or_Multi_Files_Ind,Separate_File_No_Yn,Dflt_Sndx_Type,   Id_Card_Title,Line1_Face_Sheet_Text,Line2_Face_Sheet_Text,Line3_Face_Sheet_Text, Line4_Face_Sheet_Text,Line5_Face_Sheet_Text,Line6_Face_Sheet_Text,Line7_Face_Sheet_Text,          Line8_Face_Sheet_Text,Line9_Face_Sheet_Text,Line10_Face_Sheet_Text from mp_param_lang_vw where language_id='"+localeName+"' and module_id='MP'");
		rs1 = pstmt.executeQuery();
		if(rs1.next()) 
		{
		Chart = rs1.getString("Single_Or_Multi_Files_Ind");
		Numbering = rs1.getString("Separate_File_No_Yn");
		Soundex = rs1.getString("Dflt_Sndx_Type");
		if(Soundex == null) Soundex="";
		CardTitle = rs1.getString("Id_Card_Title")== null ? "" : rs1.getString("Id_Card_Title").trim();
		Line1 = rs1.getString("Line1_Face_Sheet_Text")==null ? "" : rs1.getString("Line1_Face_Sheet_Text").trim();
		Line2 = rs1.getString("Line2_Face_Sheet_Text")==null ? "" : rs1.getString("Line2_Face_Sheet_Text").trim();
		Line3 = rs1.getString("Line3_Face_Sheet_Text")==null ? "" : rs1.getString("Line3_Face_Sheet_Text").trim();
		Line4 = rs1.getString("Line4_Face_Sheet_Text")==null ? "" : rs1.getString("Line4_Face_Sheet_Text").trim();
		Line5 = rs1.getString("Line5_Face_Sheet_Text")==null ? "" : rs1.getString("Line5_Face_Sheet_Text").trim();
		Line6 = rs1.getString("Line6_Face_Sheet_Text")==null ? "" : rs1.getString("Line6_Face_Sheet_Text").trim();
		Line7 = rs1.getString("Line7_Face_Sheet_Text")==null ? "" : rs1.getString("Line7_Face_Sheet_Text").trim();
		Line8 = rs1.getString("Line8_Face_Sheet_Text")==null ? "" : rs1.getString("Line8_Face_Sheet_Text").trim();
		Line9 = rs1.getString("Line9_Face_Sheet_Text")==null ? "" : rs1.getString("Line9_Face_Sheet_Text").trim();
		Line10 = rs1.getString("Line10_Face_Sheet_Text") ==null ? "" : rs1.getString("Line10_Face_Sheet_Text").trim();
		}
		if (rs1 != null) rs1.close();
		if (rs3 != null) rs3.close();
		if (pstmt != null) pstmt.close();
		if (pstmt1 != null) pstmt1.close();
	}catch(Exception e) { out.println(e.toString());}
	
%>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eMP/js/FacilityLevel.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<!-- <body onLoad="Focusing('Facility')"> -->
<body onLoad="FocusFirstElement()" OnMouseDown='CodeArrest()' onKeyDown='lockKey();'>
<form name="facility_level_form" id="facility_level_form" action="../../servlet/eMP.FacilityLevelServlet" method="post" target="messageFrame" >
<!--div align="left"-->
  <br><br><br><br><br>
  <table border="0" cellpadding="3" cellspacing="0" width="90%" align=center><!--97%-->
<!--		<%
			if(tm_req.equals("N"))
			{
		%> -->
     <tr>
  	<td width="40%">&nbsp;</td>
  	 <td width="60%">&nbsp;</td>
  </tr> 
<!-- <%}%> -->
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
      <td width="60%" class="fields" >&nbsp; <Select name="Facility_Name" id="Facility_Name">
      <option value='' selected>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------
<%
	try 
	{
			pstmt=con.prepareStatement("select a.facility_id,a.facility_name from sm_facility_param a where a.facility_id not in (select b.facility_id from mp_param_for_facility b) order by a.facility_name");
			rs = pstmt.executeQuery();
      		if(rs != null) {
      			while(rs.next()) {
				String classcode     	= rs.getString("facility_id");
				String classname	= rs.getString("facility_name");
%>
			<option value='<%= classcode %>'><%= classname %>
<%
      			}
      		}
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
	}catch(Exception e) { out.println(e.toString());}
	finally 
		{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>
	</select><img src='../images/mandatory.gif'></img></td>
    </tr>
	<%
			if(tm_req.equals("N"))
			{
		%>
 
			<% } %>
    </table>
    <table border="0" cellpadding="0" cellspacing="0" width="90%" align=center><!--97%-->
  	<tr>
    		<td class='columnheader' colspan=4><b><fmt:message key="eMP.MedicalRecordAdministration.label" bundle="${mp_labels}"/></b></td>
<!--    		<td width='70%'>&nbsp;&nbsp;&nbsp;</td>-->
    	</tr>
    </table>
  <table border="0" cellpadding="0" cellspacing="0" width="90%" align=center>
    <tr>
    <td width="100%" class="BORDER">
       	<table border="0" cellpadding="3" cellspacing="0" width="90%" align='center'>
    		
			<tr><td colspan=''>&nbsp;</td></tr>
			<tr>
    			<td width='35%' class="label" colspan=2><b><fmt:message key="eMP.FileMaintenance.label" bundle="${mp_labels}"/></b></td>
    			<td  width='40%' class="fields" colspan=2><b><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></b></td>
    			<!-- <td align=left width=25% class="label" colspan=2>&nbsp;<b>Default Soundex Type</b></td> -->
    		</tr>
    		<tr>
    			<td class="fields" width='5%'>
			<%
				if(Chart.equals("S")) out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' onClick=\"checkNumberingControl('S')\" value='S' checked>");
				else out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' onClick=\"checkNumberingControl('S')\" value='S'>");
			%>
			</td>
			<td width=30% class="fields"><fmt:message key="Common.single.label" bundle="${common_labels}"/></td>
		    <td class="fields" width=5%>
			<%
				String disableNumbering = "";   
				if(Chart.equals("M")) disableNumbering = "disabled";
				if(Numbering.equals("Y")) out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='Y' checked  "+disableNumbering+">");
				else out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='Y' "+disableNumbering+">");
			%>
		    	</td>
			<td width=35% class="fields"><fmt:message key="eMP.AllowseparateMRN.label" bundle="${mp_labels}"/></td>
			<td  class="label" width=5%></td>
			
	    	</tr>
	    	<tr>
		    	<td class="fields" width=5%>
			<%
				if(Chart.equals("M")) out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' onClick=\"checkNumberingControl('M')\" value='M' checked>");
				else out.println("<input type='radio' name='ChartMaintenance' id='ChartMaintenance' onClick=\"checkNumberingControl('M')\" value='M'>");
			%>
		        </td>
			<td width=30%  class="fields"><fmt:message key="Common.multiple.label" bundle="${common_labels}"/>
		    	</td>
		    	<td class="fields" width=5%>
			<%
				if(Numbering.equals("N")) out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='N' checked "+disableNumbering+">");
				else out.println("<input type='radio' name='NumberingControl' id='NumberingControl' value='N' "+disableNumbering+">");
			%>
		    	</td>
			<td width=31% class="fields"><fmt:message key="eMP.KeepFileNumbersameasPatientID.label" bundle="${mp_labels}"/></td>
		  	</tr>
	  </table>
  </td>
  </tr>
  <%
			if(tm_req.equals("N"))
			{
		%>
     <tr>
	  	<td colspan=2>&nbsp;</td>
  </tr> 

		<%
			}
			if(tm_req.equals("Y"))
			{
		%>
   		
		<%
			}

		%>
   </table>
</div>
<input type="hidden" name="function1" id="function1" value="insert">
<input type="hidden" name="patient_id_length" id="patient_id_length" value="<%=id_len%>">
<input type="hidden" name="terminal_reqd" id="terminal_reqd" value="<%=tm_req%>">
<input type="hidden" name="Numbering" id="Numbering" value="<%=Numbering%>">
<input type="hidden" name="Chart" id="Chart" value="<%=Chart%>">
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

