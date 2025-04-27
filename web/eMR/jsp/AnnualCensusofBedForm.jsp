<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<!-- <script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script> -->
    <script src="../../eCommon/js/common.js"></script> 
	<script src="../../eCommon/js/messages.js"></script>
	<!-- <script src='../../eMR/js/eMRmessages.js' language='javascript'></script> -->
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eMR/js/AnnualCensusofBed.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	<script>
	</script>
</head>
<body OnMouseDown="CodeArrest()" onLoad='callClear_l1("SP")'>
<form name='annualCenBed_form' id='annualCenBed_form'  action=''  method='post' target='messageFrame'>
<%
	SimpleDateFormat dateFormat1 = new SimpleDateFormat( "dd/MM/yyyy" ) ;
   	String currentdate 		= dateFormat1.format(new java.util.Date()) ;
	%> 

<%
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rs				= null;

	String report_gr_id			= "";   	
	String p_report_id		= "MRIPCSBD" ;
	String master		= "SP" ;
  try
   {
	con				= ConnectionManager.getConnection(request);
	stmt			= con.createStatement();
	
%>
  <input type=hidden name="report_gr_id" id="report_gr_id" value='<%=report_gr_id%>'>
  <table border='0' cellpadding='0' cellspacing='0' width='98%' align='center'>
	<tr>
      <td colspan=4></td>
	</tr>
	<tr>
      <td colspan=4></td>
	</tr>
    <tr>
      <td colspan=4></td>
	</tr>
	  <tr>
      <td colspan=4></td>
	</tr>
	  <tr>
			<td align='right' width='14%' class="label">Census Year</td>
				<td width='25%'  >&nbsp;
					<input type=text id="census_date" name='p_census_date' id='p_census_date' size="4" onblur="CheckYear(this);chkyear_fut(this);" maxlength="4" align="center" onkeypress="return ValidStringrepIPAnnual(event)" ><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date','y',null);">
					<img align='center' src='../../eMP/images/mandatory.gif'>
				</td>
				<td colspan=2></td>
				<!-- <td  class='label'  width=14%  align='right'>Serial No</td>
	  <td class='querydata' width='11%' id='fetchdata'>&nbsp;</td> -->
		</tr>
	<tr>
      <td colspan=4></td>
	</tr>
	<tr>
      <td colspan=4></td>
	</tr>
<!-- 	<tr>
      <td colspan=4></td>
	</tr>
	<tr>
     <td  class='label'  width=14%  align='right'>
         Master</td>
      <td colspan=1>&nbsp;
      <select name="Master" id="Master" onchange="callClear_l1(this);clearMandatory()">
		  <option value="">---------Select----------</option>
		  <option value="SP">Specialty</option>
		  <option value="BD">Bed Class</option></SELECT> <img   src='../../eMP/images/mandatory.gif'> &nbsp;&nbsp;<td  class='label'  width=14%  align='right'>Serial No</td>
	  <td class='querydata' width='11%' id='fetchdata'>&nbsp;</td>
	 
</tr>
<tr>
      <td colspan=4></td>
</tr>  -->
 <tr>
      <td colspan=4></td>
</tr>
<tr>
      <td colspan=4></td>
</tr>
 <tr>
      <td colspan=4></td>
</tr>
<tr>
     <td align=right class='label' >
          Level1 Group
     </td > 
     <td align=left colspan=3>&nbsp; <textarea rows=2  disabled cols=50 name="Main_group_desc"   onBlur="level1(this);"  readonly></textarea><input disabled type="button" name="sub_group11" id="sub_group11" value="?" class="BUTTON" onClick="getLevelGroupId();">
		<input type="hidden" name="Main_group" id="Main_group">
		<img  style="visibility:hidden" src='../../eMP/images/mandatory.gif'  id='mand_gif1'></td>
	</tr>
<tr>
    <td colspan=4></td>
</tr>
<tr>
    <td colspan=4></td>
</tr> 
 <tr>
    <td colspan=4></td>
</tr>
<tr>
    <td colspan=4></td>
</tr>
    <tr>
    <td align=right class='label'>Level2 Group
    </td>
    <td  align="left" colspan=3>&nbsp;
	   <textarea rows=2  cols=50  name="sub_group1" readonly></textarea><input type="button" name="sub_group12" id="sub_group12"  value="?" class="BUTTON" onClick="getSubGroupId();">
  	   <input type="hidden" name="sub_group" id="sub_group" value="">
		 <img src='../../eMP/images/mandatory.gif' style="visibility:hidden" id='mand_gif2'>
    </td>
</tr>
<tr>
    <td colspan=4></td>
</tr>
<tr>
    <td colspan=4></td>
</tr> 
 <tr>
    <td colspan=4></td>
</tr>
<tr>
    <td colspan=4></td>
</tr> 
<tr>
    <td colspan=4></td>
</tr>
<tr>
    <td colspan=4></td>
</tr> 
 <tr>
    <td colspan=4></td>
</tr>
<tr>
    <td colspan=4></td>
</tr>
	  <!-- <tr>
			<td>
					 &nbsp;
            </td>
			<td align=center class=label>
					 From
            </td>
				<td align=center colspan=2 class=label>
					 To
            
            </td>
	 </tr> -->
	<tr>
		<td colspan=4>
	<table border=0 width='100%' align=center>
     <tr>
     <td  width='100%' id='t'></td>
	</tr>
	<tr>
     <td  width='100%' id='t1'></td>
	</tr>
		        
      </table>
	   </td>

	</tr>
		<!-- <tr><td class=label width='20%' align='right'>&nbsp;Search By&nbsp;&nbsp;</td><td class='label' align='left' width='33%'><select name='searchby' id='searchby' onchange='callhidden();'><option value='C'>Code</option><option value='D'>Description</option></select>&nbsp;Criteria&nbsp;<select onchange='callhidden();' name='searchcriteria' id='searchcriteria'><option value='C'>Contains</option><option value='S'>Starts With</option><option value='E'>Ends With</option></td><td class=label width='20%' align=right>&nbsp;Text&nbsp;&nbsp;<td align='left' width='33%'><input type='text' size='5' maxlength='6' name='alpha_desc' id='alpha_desc'><img src='../../eMP/images/mandatory.gif'></td><td>&nbsp;</td></tr> -->
		<!--  <tr>
      <td colspan=4>&nbsp;</td>

  </tr>  -->
		<!-- <tr>
		<td class=label align=right>Tabulation List Desc&nbsp;&nbsp;</td>
		<td colspan=3><input type="text"></td>
		</tr>  -->
		<tr>
      <td colspan=4></td>

  </tr> 
	  <tr>
      <td colspan=4></td>

  </tr> 
	  <tr>
      <td colspan=4></td>

  </tr> 
	<tr>
	  <td class='label' align="right">&nbsp;</td>
     <td class='querydata' id='fetchdata1'>&nbsp;</td>
    <td colspan=2 align=right>&nbsp;&nbsp;&nbsp;<INPUT TYPE="button" class='button' value="Search" Onclick="FetchValues()"><INPUT TYPE="button" class='button' value="Clear" Onclick="clearValues()">
  </td>
</tr>
</table>
		<input type="hidden" name=type value="">		
		<input type="hidden" name="Report" id="Report" 	value="<%= p_report_id %>">
		<input type="hidden" name="Master" id="Master" 	value="<%=master%>">
		<input type='hidden' name='sysdate' id='sysdate' value = "<%=currentdate%>"></input>
<% 
 if(stmt!=null) stmt.close();
   if(rs!=null) rs.close();
   }
 catch(Exception e)
 {
	//out.println("Exception in File AnnualCensusofBedForm"+e.toString());
	e.printStackTrace();
 }
 finally
 {
    ConnectionManager.returnConnection(con,request);
 }
%>
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

