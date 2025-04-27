<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" %>
<html>	
<HEAD>
<TITLE></TITLE>
<!-- Added By Dharma on July 31, 2014 Start -->
<style>
table, td {
word-wrap: break-word;
word-break: break-all;
}
</style>
<!-- Added By Dharma on July 31, 2014 End-->
</HEAD>
<%
Connection con = null;
Statement stmt = null;
Statement stmt1 = null;
ResultSet rset = null;
ResultSet rset1 = null;

String p_facility_id = (String)session.getAttribute("facility_id");
String p_amb_case_no = request.getParameter("p_trip_no");
String fac_name="";
%>

<BODY onLoad="repPrint()">
<form name="AmbPrintSheet" id="AmbPrintSheet" action="return true">

<!-- Start of Setting up Header and Footer -->
<script Language="vbscript">
    Dim WSHShell
    Dim myHeader
    Dim myFooter
    Set WSHShell = CreateObject("WScript.Shell")
    myHeader = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\header")
    myFooter = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer")

    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header",""
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"

    Sub ResetHeader()
        Dim WSHShell
        Set WSHShell = CreateObject("WScript.Shell")
        WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", myHeader
        WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", myFooter
    End Sub
</script>
<!-- End of Setting up Header and Footer -->
<%
try
	{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		String str2 = "select facility_name from sm_facility_param where facility_id='"+p_facility_id+"'";
		rset = stmt.executeQuery(str2);

		if (rset !=null)
		{
			while(rset.next())
			{
				fac_name = rset.getString("facility_name");
			}
		}
		if (stmt !=null)
			stmt.close();
		if (rset !=null)
			rset.close();
	}

	catch(Exception e)
	{
	//out.println(e);
	e.printStackTrace();
	}
%>
<table width='100%' border='0'>
<tr>
	<td width='10%'><img width='75' height='75' src='../../eCommon/images/Entilogo.jpg'></img></td>
	<td width='87%'valign='center'><p align='center'><font size='5'> <b><%=fac_name%><br>Patient Transport Sheet</b></font></p></td>
</tr>
<tr>
	<td>&nbsp;</td>
</tr>
</table>

<%

try
	{
		stmt = con.createStatement();
		String sql ="SELECT	A.FACILITY_ID FACILITY_ID,A.AMB_CASE_NO AMB_CASE_NO,to_char(A.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_BOOKED_DATE, A.AMB_VEHICLE_ID    AMB_VEHICLE_ID,    To_char(A.AMB_CASE_START_DATE,'dd/mm/yyyy hh24:mi')    AMB_CASE_START_DATE,to_char(A.AMB_CASE_END_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_END_DATE, A.PATIENT_ID PATIENT_ID ,nvl((select patient_name  || '/' ||  sex  || '/' || get_age(date_of_birth)    from mp_patient where patient_id  =a.patient_id),    patient_name  || '/' ||  a.sex  || '/' || get_age(a.date_of_birth)  ) PATIENT_NAME , TO_CHAR(A.DATE_OF_BIRTH,'DD/MM/YYYY')  DATE_OF_BIRTH,upper(A.AGE) AGE, decode(A.SEX,'M','Male','F','Female','U','Unknown') SEX,A.PICKUP_FROM_HOSP_YN PICKUP_FROM_HOSP_YN,A.PICKUP_LOCN_CODE PICKUP_LOCN_CODE,  NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.PICKUP_LOCN_CODE and rownum <=1),PICKUP_LOCN_DESC) PICKUP_LOCN_DESC, A.PICKUP_ADDRESS    PICKUP_ADDRESS,A.DESTN_LOCN_CODE DESTN_LOCN_CODE ,  NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.DESTN_LOCN_CODE and rownum <=1),A.DESTN_LOCN_DESC) DESTN_LOCN_DESC,  A.DESTN_ADDRESS DESTN_ADDRESS ,A.AMB_CALLER_NAME AMB_CALLER_NAME ,A.AMB_CALLER_CONTACT_NO AMB_CALLER_CONTACT_NO,A.AMB_CALLER_REMARKS AMB_CALLER_REMARKS,    A.AMB_NATURE_CALL_CODE AMB_NATURE_CALL_CODE ,(SELECT LONG_DESC FROM AE_AMB_NATURE WHERE AMB_NATURE_CODE = A.AMB_NATURE_CALL_CODE) NATURE_CALL_DESC,    decode(A.AMB_PRIORITY_IND,'L','Low','H','High','M','Medium')  AMB_PRIORITY_IND,A.AMB_CASE_STATUS AMB_CASE_STATUS,A.AMB_START_MILEAGE AMB_START_MILEAGE,   A.AMB_END_MILEAGE AMB_END_MILEAGE,A.AMB_DISP_REMARKS AMB_DISP_REMARKS ,C.AMB_CURRENT_LOCATION CURRENT_LOCATION ,B.AMB_VEHICLE_NAME AMB_VEHICLE_NAME,  B.AMB_REGN_NO AMB_REGN_NO, B.AMB_MODEL_NO AMB_MODEL_NO,B.AMB_DATE_MANUFCT AMB_DATE_MANUFCT,B.AMB_LAST_MILEAGE AMB_LAST_MILEAGE,  B.AMB_REMARKS AMB_REMARKS ,to_char(a.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy') added_date,     to_char(a.AMB_CASE_BOOKED_DATE,'hh24:mi') added_time ,TO_CHAR (a.amb_case_start_date,'dd/mm/yyyy') disp_start_date,       TO_CHAR (a.amb_case_start_date,'hh24:mi') disp_start_time, TO_CHAR (a.amb_case_end_date, 'dd/mm/yyyy') disp_end_date,TO_CHAR (a.amb_case_end_date, 'hh24:mi') disp_end_time,patient_name pat_name,nvl(amb_uom,'Mileage') amb_uom,A.AMB_EXP_DIST_COVERED,A.AMB_DIST_COVERED FROM    AE_AMB_CASE_REQUEST A , AE_AMB_VEHICLE B,AE_AMB_OPEN_REQUEST C WHERE    A.FACILITY_ID = '"+p_facility_id+"' AND    A.AMB_CASE_NO = '"+p_amb_case_no+"' AND    A.FACILITY_ID = B.FACILITY_ID (+) AND    A.AMB_VEHICLE_ID = B.AMB_VEHICLE_ID (+) AND    A.FACILITY_ID = C.FACILITY_ID (+)AND    A.AMB_CASE_NO = C.AMB_CASE_NO (+)";
		rset = stmt.executeQuery(sql.toString());

		if (rset!=null)
		{
			while(rset.next())
			{
%>

<table width='100%' align='center' valign='top' cellpadding='1' cellspacing='0' border='1' bordercolor=#330066>
	<tr>
		<td width='30%' height='40' align='left' valign='top'> <font size='2'><b>Incident Number :&nbsp;</b> <%=checkForNull(rset.getString("amb_case_no")) %></font></td>
		<td width='30%' height='40' align='left' valign='top'> <font size='2'><b>Type of Call :&nbsp;</b><%=checkForNull(rset.getString("nature_call_desc"))%> <br></font></td>
		<td colspan='3' height='40' align='left' valign='top'> <font size='2'><b>Incident date :&nbsp;</b><%=checkForNull(rset.getString("amb_case_booked_date"))%></font></td>
	</tr>

	<tr>
		<td width='30%' height='40' align='left' valign='top'> <font size='2'><b>Pickup Location :&nbsp;</b><%=checkForNull(rset.getString("pickup_locn_desc"))%></font></td>
		<td width='30%' height='40' align='left' valign='top'> <font size='2'><b>Dropping Location :&nbsp;</b><%=checkForNull(rset.getString("destn_locn_desc"))%></font></td>
		<td width='20%' height='40' align='left' valign='top'> <font size='2'><b>Dispatcher TOC :&nbsp;</b></font></td>
		<td colspan='2' width='20%' height='40' align='left' valign='top'> <font size='2'><b>Prescheduled Pickup Time :&nbsp;</b></font></td>
	</tr>

	<tr>
		<td width='30%' height='40' align='left' valign='top'> <font size='2'><b>Pickup Address :&nbsp;</b><%=checkForNull(rset.getString("pickup_address"))%></font></td>
		<td width='30%' height='40' align='left' valign='top'> <font size='2'><b>Dropping Address :&nbsp;</b><%=checkForNull(rset.getString("destn_address"))%></font></td>
		<td rowspan = '3' colspan = '3' height='40' valign='top'>
			<table width='100%' height='40'  align='left' valign='top' border='1'>
				<tr>
					<td colspan = '3' height='20' align='center' valign='center'  bgcolor=#D8D8D8 style="border :0px"> <font size='4'><b>Times</b></font></td>
				</tr>
			    <tr>
					<td width='50%' height='20' align='left' valign='top' bgcolor=#D8D8D8 style="border :0px"> <font size='2'><b>&nbsp;</b></font></td>
					<td width='30%' height='20' align='center' valign='top' bgcolor=#D8D8D8 style="border :0px"> <font size='2'><b>Date</b></font></td>
					<td width='20%' height='20' align='center' valign='top' bgcolor=#D8D8D8 style="border :0px"> <font size='2'><b>Time</b></font></td>
			    </tr>

				<tr>
					<td width='50%' height='20' align='left' valign='top'> <font size='2'><b>Call Rec'd </b></font></td>
					<td width='30%' height='20' align='center' valign='top'> <font size='2'><b>&nbsp;</b><%=checkForNull(rset.getString("added_date"))%></font></td>
					<td width='20%' height='20' align='center' valign='top'> <font size='2'><b>&nbsp;</b><%=checkForNull(rset.getString("added_time"))%></font></td>
				</tr>
			    <tr>
					<td width='50%' height='20' align='left' valign='top'> <font size='2'><b>Dispatched</b></font></td>
					<td width='30%' height='20' align='center' valign='top'> <font size='2'><b>&nbsp;</b><%=checkForNull(rset.getString("disp_start_date"))%></font></td>
					<td width='20%' height='20' align='center' valign='top'> <font size='2'><b>&nbsp;</b><%=checkForNull(rset.getString("disp_start_time"))%></font></td>
			    </tr>
				<tr>
					<td width='50%' height='20' align='left' valign='top'> <font size='2'><b>Location </b></font></td>
					<td width='30%' height='20' align='center' valign='top'> <font size='2'><b>&nbsp;</b></font></td>
					<td width='20%' height='20' align='center' valign='top'> <font size='2'><b>&nbsp;</b></font></td>
				</tr>
			    <tr>
					<td width='50%' height='20' align='left' valign='top'> <font size='2'><b>Destination</b></font></td>
					<td width='30%' height='20' align='center' valign='top'> <font size='2'><b>&nbsp;</b><%=checkForNull(rset.getString("disp_end_date"))%></font></td>
					<td width='20%' height='20' align='center' valign='top'> <font size='2'><b>&nbsp;</b><%=checkForNull(rset.getString("disp_end_time"))%></font></td>
			    </tr>

		   </table>
		</td>
	</tr>

	<tr>
		<td width='30%' height='40' align='left' valign='top'> <font size='2'><b>Requester name :&nbsp;</b><%=checkForNull(rset.getString("amb_caller_name"))%></font></td>
		<td width='30%' height='40' align='left' valign='top'> <font size='2'><b>Requester Contact :&nbsp;</b><%=checkForNull(rset.getString("amb_caller_contact_no"))%></font></td>
	</tr>

	<tr>
		<td colspan = '2' width='30%' height='40' align='left' valign='top'> <font size='2'><b>Request Remarks :&nbsp;</b><%=checkForNull(rset.getString("amb_caller_remarks"))%></font></td>
	</tr>

	<tr>
		<td colspan ='2' width='60%' height='40' align='left' valign='top'>
			<table width='100%' height='40'  align='left' valign='top' border='0' cellpadding='0' cellspacing='0' >
					<tr>
	<!-- Start of Patient Address Block -->
						<td width='80%' height='200' align='left'>
							<table width='100%' height='200' border='1' cellpadding='0' cellspacing='0'>
								<tr>
									<td rowspan='5' width='6%' bgcolor=#D8D8D8> 
									<p align='center'><font size='4'><b>P<br>A<br>T<br>I<br>E<br>N<br>T </b></font></p>
									</td>
								</tr>
								<tr>
									<td colspan='4' width='94%' height='120' valign='top' style="border :0px"><font size='2'><b>Patient Name : &nbsp;</b><%=checkForNull(rset.getString("pat_name"))%></font></td>
								</tr>

								<tr>
									<td width='21%' height='40' valign='top'><font size='2'><b>Age :&nbsp</b> <%=checkForNull(rset.getString("age"))%></font></td>
									<td width='21%' valign='top'><font size='2'><b>DOB :&nbsp;</b><%=checkForNull(rset.getString("date_of_birth"))%></font></td>
									<td width='21%' valign='top'><font size='2'><b>Gender :&nbsp;</b><%=checkForNull(rset.getString("sex"))%></font></td>
									<td width='21%' valign='top'><font size='2'><b>Phone :</b></font></td>
								</tr>
								<tr>
									<td colspan='4' width='94%' height='32' valign='top'><font size='2'><b>Condition:</b></font></td>
								</tr>
								<tr>
									<td colspan='4' width='94%' height='30' valign='top'><font size='2'><b>Chief Complaint :</b></font></td>
								</tr>
							</table>
						</td>
	<!-- end of Patient Address Block -->
						<td width='80%' height='196' align='left' valign='top'><font size='2'><b>Escorted By :</b></font></td>
					</tr>
			</table>
		</td>
		<td colspan ='3' width='40%' height='30' align='left' valign='top'>
			<table width='100%' align='left' valign='top' border='1'>
				<tr>
					<td colspan ='3' width='50%' height='46' align='center' valign='center' bgcolor='#D8D8D8' border='0' style="border :0px"> <font size='4'><b>Est.&nbsp;<%=checkForNull(rset.getString("amb_uom"))%></b></font></td>
				</tr>
				<tr>
					<td width='50%' height='23' align='left' valign='top'> <font size='2'><b>To Scene </b></font></td>
					<td width='50%' height='23' align='left' valign='top'> <font size='2'><b>&nbsp; </b></font></td>
				</tr>
				<tr>
					<td width='50%' height='23' align='left' valign='top'> <font size='2'><b>To Dest</b></font></td>
					<td width='50%' height='23' align='left' valign='top'> <font size='2'><b>&nbsp <%=checkForNull(rset.getString("amb_exp_dist_covered"))%> </b></font></td>
				</tr>

				<tr>
					<td colspan ='3' width='50%' height='46' align='center' valign='center' bgcolor='#D8D8D8' border='0'> <font size='4' ><b>Odometer </b></font></td>
				</tr>
				<tr>
					<td width='50%' height='23' align='left' valign='top'> <font size='2'><b>Start Mileage </b></font></td>
					<td width='50%' height='23' align='center' valign='top'> <font size='2'>&nbsp<%=checkForNull(rset.getString("amb_start_mileage"))%></font></td>
				</tr>
				<tr>
					<td width='50%' height='23' align='left' valign='top'> <font size='2'><b>End Mileage</b></font></td>
					<td width='50%' height='23' align='center' valign='top'> <font size='2'>&nbsp<%=checkForNull(rset.getString("amb_end_mileage"))%></font></td>
				</tr>
				<tr>
					<td width='50%' height='23' align='left' valign='top'> <font size='2'><b>Total </b></font></td>
					<td width='50%' height='23' align='left' valign='top'> <font size='2'><b>&nbsp<%=checkForNull(rset.getString("amb_dist_covered"))%> </b></font></td>
				</tr>
		    </table>
		</td>
	</tr>
	

	<tr>
		<td colspan ='2' height='40' align='left' valign='top'>
			<table width='100%' border='1'>
				<tr style ="background-color :#D8D8D8">
					<td align='center'><font size='4' ><b>Equipment</b></font></td>
				</tr>
				<tr>
					<td align='left'><font size='4'>
<%
	try
		{
		//con1 = ConnectionManager.getConnection(request);
		stmt1 = con.createStatement();
		String sql2 = "select amb_equipment_code,(select long_desc from am_resource where resource_id=a.amb_equipment_code) amb_equipment_desc from AE_AMB_REQUEST_EQUIP a where facility_id = '"+p_facility_id+"'  and amb_case_no = '"+p_amb_case_no+"'";
		rset1 = stmt1.executeQuery(sql2);
		if (rset1 !=null)
			{
				while(rset1.next())
				{
					out.println("<font size='2'>"+checkForNull(rset1.getString("amb_equipment_desc"))+"</font><br>");				
				}
			}
		if (stmt1 !=null)
			stmt1.close();
		if (rset1 !=null)
			rset1.close();
		}
	catch(Exception e)
		{
			//out.println(e +"  Sub block1 Block");
			e.printStackTrace();
		}

%>					
					
					</font></td>
				</tr>
			</table>
		</td>
		<td colspan ='3' width='50%' height='40' align='center' valign='center' border='0'>
			<table width='100%' border='1'>
				<tr style ="background-color :#D8D8D8">
					<td align='center'><font size='4' ><b>Resources</b></font></td>
				</tr>
				<tr>
					<td align='left'><font size='2'>
<%
	try
		{
		stmt1 = con.createStatement();
		String sql2 = "SELECT amb_resource_id,A.AMB_RESOURCE_TYPE amb_resource_type, (CASE WHEN A.AMB_RESOURCE_TYPE = 'P' THEN ( SELECT    practitioner_name || (SELECT ' ('||position_desc||')'  FROM am_position WHERE position_code = a.position_code) resource_desc FROM am_practitioner a WHERE UPPER (practitioner_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') WHEN A.AMB_RESOURCE_TYPE = 'E' THEN (SELECT practitioner_name|| (SELECT ' ('||position_desc||')' FROM am_position WHERE position_code = a.position_code) resource_desc FROM am_ext_practitioner a WHERE UPPER (practitioner_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') WHEN A.AMB_RESOURCE_TYPE  = 'O' THEN (SELECT  other_staff_name||' ('||(SELECT long_desc FROM am_other_staff_type WHERE other_staff_type = a.other_staff_type)||')' resource_desc FROM am_other_staff a WHERE UPPER (other_staff_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') ELSE '' END ) amb_resource_desc FROM ae_amb_request_resource a WHERE facility_id = '"+p_facility_id+"' AND amb_case_no = '"+p_amb_case_no+"'";

		rset1 = stmt1.executeQuery(sql2);
		if (rset1 !=null)
			{
				while(rset1.next())
				{
					out.println("<font size='2'>"+checkForNull(rset1.getString("amb_resource_desc"))+"</font><br>");				
				}
			}
		if (stmt1 !=null)
			stmt1.close();
		if (rset1 !=null)
			rset1.close();
		}
	catch(Exception e)
		{
			//out.println(e+"  Sub block2 Block");
			e.printStackTrace();
		}
%>						
					
					
					</font></td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td colspan ='5' height='300'>
			<table width='100%' border='0'>
				<tr height='50'>
					<td width='30%' valign='bottom'>
						<font size='2'><b><br>--------------------------------<br>Person Receiving Patient</b></font>
					</td>
					<td width='30%' valign='bottom'>
						<font size='2'><b><br>--------------------------------<br>Date/Time</b></font>
					</td>
					<td width='30%' valign='bottom'>
						<font size='2'><b><br>--------------------------------<br>Driver</b></font>
					</td>
				</tr>
				<tr height='50'>
					<td width='30%' valign='bottom'>
						<font size='2'><b><br>--------------------------------<br>Authorizing Physician</b></font>
					</td>
					<td width='30%' valign='bottom'>
						<font size='2'><b><br>--------------------------------<br>Date/Time</b></font>
					</td>
					<td width='30%' valign='bottom'>
						<font size='2'><b><br>--------------------------------<br>Attendant</b></font>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<%
			}
		}

		if (stmt !=null)
			stmt.close();
		if (rset !=null)
			rset.close();
	}
catch(Exception e)
	{
	//out.println(e +"  Main Block");
	e.printStackTrace();
	}
finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con,request);
		}
	}
%>


	<script name="javascript">
		function repPrint()
		{
			if (document.all)
			{
				var res= confirm("Continue Printing?");
				if (res)
				{
				window.print();				
				}
			}
		}
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>





</form>
</BODY>

</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

