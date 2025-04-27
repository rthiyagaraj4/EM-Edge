<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

  <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script src='../js/AMBFacility.js' language='javascript'></script>	
	<script src='../../eCommon/js/common.js' language='javascript'></script>


</head>
 <body OnMouseDown='CodeArrest()' onKeyDown='lockKey();' onLoad='FocusFirstElement()'>
     
<%

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rset = null;
String facility_id = checkForNull((String)session.getValue("facility_id"));
String amb_prefix_ind = "";
String amb_user_prefix = "";
String start_case_no = "";
String next_case_no = "";
String end_case_no = "";
String amb_mileage_uom = "";
String amb_dflt_dys_behind = "";
String amb_dflt_dys_ahead = "";
String print_trip_sheet_yn = "";
String print_trip_sheet_comp_yn = "";
String virt_keypad_display_yn = "";
/*String mode = "insert";
String chk = "checked";*/
String prefixVisible = "hidden";
String fnval = "insert";
String readOnly = "";
int uomCount = 0;
ArrayList amUomVals = new ArrayList();

try
{
  con = ConnectionManager.getConnection(request);
  pstmt = con.prepareStatement(
    "select amb_prefix_ind, amb_user_prefix, start_case_no, next_case_no, end_case_no, amb_mileage_uom,amb_dflt_dys_behind, amb_dflt_dys_ahead, print_trip_sheet_yn, print_trip_sheet_comp_yn,virt_keypad_display_yn from ae_amb_param_for_facility where facility_id='" + facility_id + "'");
  rset = pstmt.executeQuery();
  if (rset.next())
  {
    fnval = "modify";
	readOnly = "disabled";
    amb_prefix_ind = checkForNull(rset.getString("amb_prefix_ind"));
    amb_user_prefix = checkForNull(rset.getString("amb_user_prefix"));
    start_case_no = checkForNull(rset.getString("start_case_no"));
    next_case_no = checkForNull(rset.getString("next_case_no"));
    end_case_no = checkForNull(rset.getString("end_case_no"));
    amb_mileage_uom = checkForNull(rset.getString("amb_mileage_uom"));
    amb_dflt_dys_behind = checkForNull(rset.getString("amb_dflt_dys_behind"));
    amb_dflt_dys_ahead = checkForNull(rset.getString("amb_dflt_dys_ahead"));
    print_trip_sheet_yn = checkForNull(rset.getString("print_trip_sheet_yn"),"N");
    print_trip_sheet_comp_yn = checkForNull(rset.getString("print_trip_sheet_comp_yn"),"N");
    virt_keypad_display_yn = checkForNull(rset.getString("virt_keypad_display_yn"),"N");
  }
 
  if (amb_prefix_ind.equals("U")){
    prefixVisible = "visibility:visible";
	}

  if (pstmt != null)
    pstmt.close();

  pstmt = con.prepareStatement(
    "select uom_code,short_desc from AM_UOM where STOCK_UOM_YN='N' AND PUR_UOM_YN = 'N'  AND SALE_UOM_YN = 'N'  AND DOSAGE_UOM_YN = 'N'  AND STRENGTH_UOM_YN = 'N'  AND  QTY_UOM_YN = 'N'  AND EFF_STATUS ='E' ");
  rset = pstmt.executeQuery();
  if (rset != null)
  {
    while (rset.next())
    {
      amUomVals.add(checkForNull(rset.getString("uom_code")) + "~" +
        checkForNull(rset.getString("short_desc")));
    }
  }
  uomCount = amUomVals.size();
}
catch (Exception e)
{
  //out.println(e.toString());
  e.printStackTrace();
}
finally
{
  if (rset != null)
    rset.close();
  if (pstmt != null)
    pstmt.close();
  if (con != null)
    ConnectionManager.returnConnection(con, request);
}
/*int[] age= getDOB("22y11m22d","Y");
System.out.println("age : "+age[0]+" "+age[1]+" "+age[2]);
age= getDOB("43y","Y");
System.out.println("age : "+age[0]+" "+age[1]+" "+age[2]);
age= getDOB("11m","Y");
System.out.println("age : "+age[0]+" "+age[1]+" "+age[2]);
age= getDOB("22d","Y");
System.out.println("age : "+age[0]+" "+age[1]+" "+age[2]);
age= getDOB("222","D");
System.out.println("age : "+age[0]+" "+age[1]+" "+age[2]);
age= getDOB("222","m");
System.out.println("age : "+age[0]+" "+age[1]+" "+age[2]);
*/
%>
      	<form name='AMBFacility_form' id='AMBFacility_form' action='../../servlet/eAE.AMBFacilityServlet' method='post' target='messageFrame'>
     
		<br><br><br><br><br><br><br><br>
		<table>
		<tr>
      	<table id='amb_tab' border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
			<th align='left' colspan='4'><fmt:message key="eAE.AmbulanceOdometer.label" bundle="${ae_labels}"/></th>
			<tr ><tr><td colspan=2>&nbsp;</td></tr>
       		     <!--<td width='40%' align='right' class='label'>Odometer Units</td>-->
				 <td class='label' width='40%'> <fmt:message key="eAE.OdometerUnits.label" bundle="${ae_labels}"/></td>
      		     <td>&nbsp;&nbsp;<select name="amb_mileage_uom" id="amb_mileage_uom">
				<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				</select>
		    <img style='visibility:visible' id='end_num_mand' src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      	</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<th align='left' colspan='4'><fmt:message key="eAE.RequestQueuePeriod.label" bundle="${ae_labels}"/></th>
		<tr >
			 
			 <!--<td width='40%' align='right' class='label'>Display past requests for </td>-->
			  <td class='label' width='40%'> <fmt:message key="eAE.Displaypastrequestsfor.label" bundle="${ae_labels}"/></td>
			 <td class='label'>&nbsp;&nbsp;<input type='text' name='amb_dflt_dys_behind' id='amb_dflt_dys_behind' size='3' maxlength='3' onBlur='makeValidString(this)' onKeyPress="return CheckNumbers(event)"  value="<%=amb_dflt_dys_behind%>" > Days 
		</td>
			 
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr >
  
			 <!--<td width='40%' align='right' class='label'>Display future requests for</td>-->
			  <td class='label' width='40%'> <fmt:message key="eAE.Displayfuturerequestsfor.label" bundle="${ae_labels}"/></td>
			 <td class='label'>&nbsp;&nbsp;<input type='text' name='amb_dflt_dys_ahead' id='amb_dflt_dys_ahead' size='3' maxlength='3' onBlur='makeValidString(this)' onKeyPress="return CheckNumbers(event)" value="<%=amb_dflt_dys_ahead%>" > Days 
		</td>
			 
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
			<th align='left' colspan='4'><fmt:message key="eAE.IncidentRegister.label" bundle="${ae_labels}"/></th>
			<tr><td colspan=2>&nbsp;</td></tr>
      		<tr>
      		    <!--<td width='40%' align='right' class='label'>Incident Numbering By</td>-->
				 <td class='label' width='40%'> <fmt:message key="eAE.IncidentNumberingBy.label" bundle="${ae_labels}"/></td>
      		    <td>&nbsp;&nbsp;<select name="amb_prefix_ind" id="amb_prefix_ind"  onchange="onChangePrefixInd(this);">
				<option value="F" >Facility ID</option>
				<option value="A">Ambulance ID</option>
				<option value="Y">Year</option>
				<option value="U" >Custom Prefix</option>				
				</select>
      		    <img style='visibility:visible' src='../../eCommon/images/mandatory.gif' align='center'></img></td>
       		</tr>
			<SCRIPT >
			if ("<%=amb_prefix_ind%>"=="")
				document.forms[0].amb_prefix_ind.value="F";
			else
				document.forms[0].amb_prefix_ind.value="<%=amb_prefix_ind%>";
			</SCRIPT>
      
      		<tr><td colspan=2>&nbsp;</td></tr>
      		<tr id='prefix_row' style='<%=prefixVisible%>'>
      		    
      		    <!--<td id='prefix_lable' width='40%' align='right' class=label>Prefix</td>-->
				 <td class='label' width='40%'> <fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/></td>
      		    <td id='prefix_value'>&nbsp;&nbsp;<input type='text' name='amb_user_prefix' id='amb_user_prefix' size='10' maxlength='2' onBlur='makeValidString(this)' onKeyPress="return CheckSpecChars(event)" value="<%=amb_user_prefix%>"  >
      		    <img name='prefix_ind_mand' src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		    
      		</tr>
		</table>

		<table border=0 cellpadding='0' cellspacing='0' id = 'case_no_tab' style='position:relative; visibility:visible' width='75%' align='center'>
      	<tr><td colspan=2>&nbsp;</td></tr>

      		<tr >
			<td class='label' width='40%'> <fmt:message key="eOP.StartNumber.label" bundle="${op_labels}"/></td>
			<!--<td width='40%'align='right' class=label>Start Number</td>-->
		    <td>&nbsp;&nbsp;<input type='text' name='start_case_no' id='start_case_no' size='9' maxlength='9' onBlur = 'fillNextNo(this)' onKeyPress="return CheckNumbers(event)" value="<%=start_case_no%>" >
		    <img  name='start_num_mand' src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		</tr>

      		<tr><td colspan=2>&nbsp;</td></tr>

      		<tr >
			  <td class='label' width='40%'> <fmt:message key="eAM.NextNumber.label" bundle="${ae_labels}"/></td>
      		     <!--<td width='40%' align='right' class='label'>Next Number</td>-->
      		     <td>&nbsp;&nbsp;<input type='text' name='next_case_no' id='next_case_no' size='9' maxlength='9'  onBlur='makeValidString(this)' onKeyPress="return CheckSpecChars(event)" value="<%=next_case_no%>" readonly>
		    <img  name='next_num_mand' src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		     
      		</tr>

      	<!--	<tr><td colspan=2>&nbsp;</td></tr>

		 	<tr >
      		     <td class='label' width='40%'> <fmt:message key="eAE.EndNumber.label" bundle="${ae_labels}"/></td>
      		 
      		     <td>&nbsp;&nbsp;<input type='text' name='end_case_no' id='end_case_no' size='9' maxlength='9'  onKeyPress="return CheckNumbers(event)"   value="<%=end_case_no%>" >
		    <img  name='end_num_mand' src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		</tr> -->

			<tr><td colspan=2>&nbsp;</td></tr>
<!--
			<tr >
			 <td width='40%' align='right' class='label'>Print Trip Sheet</td>
			 <td>&nbsp;&nbsp;<input type='checkbox' name='print_trip_sheet_yn' id='print_trip_sheet_yn'  onclick="switchVal(this)"  value="<%=print_trip_sheet_yn%>" >
		    <img  name='print_trip_sht' src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		</tr>
-->
			<input type ='hidden' name = 'print_trip_sheet_yn' value = 'N'>
			
			<tr style="display:none">
   		     <td width='40%' align='right' class='label'><fmt:message key="eAE.PrintCompletedTripSheet.label" bundle="${ae_labels}"/></td>
			 <td>&nbsp;&nbsp;<input type='checkbox' name='print_trip_sheet_comp_yn' id='print_trip_sheet_comp_yn'  onclick="switchVal(this)"  value="<%=print_trip_sheet_comp_yn%>" >
		    <img  name='print_compltd_trip_sht' src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		</tr>

			<tr><td colspan=2>&nbsp;</td></tr>
<!--
			<tr >
      		     
      		     <td width='40%' align='right' class='label'>Interface To Virtual KeyBoard</td>
      		     <td>&nbsp;&nbsp;<input type='checkbox' name='virt_keypad_display_yn' id='virt_keypad_display_yn'  onclick="switchVal(this)" value="<%=virt_keypad_display_yn%>" >
		    <img  name='print_compltd_trip_sht' src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		</tr>-->
			<input type ='hidden' name = 'virt_keypad_display_yn' value = 'N'>

			<tr><td colspan=2>&nbsp;</td></tr>


		</table>

</tr><tr>

		
 
    
     	<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
     	<input type='hidden' name='prefixStr' id='prefixStr' value='<%=facility_id%>'>
     	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='uom_backup' id='uom_backup' value='<%=amb_mileage_uom%>'>
      	</form>
<script>
if ('<%=print_trip_sheet_yn%>'=='Y')
	parent.f_query_add_mod.AMBFacility_form.print_trip_sheet_yn.checked=true;
if ('<%=print_trip_sheet_comp_yn%>'=='Y')
	parent.f_query_add_mod.AMBFacility_form.print_trip_sheet_comp_yn.checked=true;
if ('<%=virt_keypad_display_yn%>'=='Y')
	parent.f_query_add_mod.AMBFacility_form.virt_keypad_display_yn.checked=true;
</script>
		<%
/*
To List UOM Values
 */
int i = 0;
while (i < uomCount)
{
  String tempArr[] = ((String)amUomVals.get(i)).split("~");

%>
				<script language="javascript">
					var opt = document.createElement('Option');
					opt.value='<%=tempArr[0]%>';
					opt.text='<%=tempArr[1]%>';					
					parent.f_query_add_mod.AMBFacility_form.amb_mileage_uom.add(opt)
				</script>
				<%
++i;
}

%>
		<SCRIPT >
		parent.f_query_add_mod.AMBFacility_form.amb_mileage_uom.value='<%=amb_mileage_uom%>'
		if ('<%=amb_prefix_ind%>'!='U')
		{
			 document.getElementById("prefix_row").style.display = 'none';
		} 
		if ('<%=amb_prefix_ind%>'=='A')
		{
			document.getElementById("case_no_tab").style.visibility='hidden';
		}
		if ("<%=fnval%>"=="modify")
		{
			document.getElementById("amb_prefix_ind").disabled=true;
			document.getElementById("amb_user_prefix").disabled=true;
			document.getElementById("start_case_no").disabled=true;
			document.getElementById("next_case_no").disabled=true;
			//document.getElementById("end_case_no").disabled=true;
		}
		</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

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

