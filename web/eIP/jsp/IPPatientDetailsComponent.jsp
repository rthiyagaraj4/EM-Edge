<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<!--Parimala-->
	<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" %>
	<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>	
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eIP/html/text.css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script>
		function OpenModel() 
		{
			
		}
		
		function validpatient() {

			}
				///// This function is used to validate Nationality ID
		
		function validateNationality(Nat_Id)	{
			
		}
		// This function is used to validate Alternate Id 
function altid(Alt_Id) 
{

}

function altidval()
{
}
// This function is used to put the values into the name field 

function putPatientName(from1,from){}// End of FUNCTION


// This function is used to pop up modal window for address details

 	function show_window(Val)
	{}

		// This Function Calculates Year,Month and Days given D.O.B
			
			function calci(Obj)
			{}
			
			
			function leapyear(a) {}

			
			
			
			function CheckForNumber_L(Objval) {}

			
			function calcage(obj1,obj2) {}
		
		function enable(Obj)
		{}
		
		
		
		function checkMonth(Obj)
		{
		
		}
		
		function checkDays(Obj)
		{
		}
		
		// End By Ush

	</script>	
		
	</head>
 	<%
	request.setCharacterEncoding("UTF-8");
 	String sql="";
 	String First_Name_Accept_Yn ="";
	int First_Name_Order=0;
	String First_Name_Prompt ="";
	String Second_Name_Accept_Yn ="";
	int Second_Name_Order =0;
	String Second_Name_Prompt ="";
	String Third_Name_Accept_Yn ="";
	int Third_Name_Order =0;
	String Third_Name_Prompt ="";
	String Family_Name_Accept_Yn ="";
	int Family_Name_Order =0;
	String Family_Name_Prompt ="";
	String Name_Suffix_Accept_Yn ="";
	String Name_Suffix_Prompt ="";
	String Name_Prefix_Accept_Yn = "";
	String Name_Prefix_Prompt = "";

	String First_Name_Reqd_Yn ="";
	String Second_Name_Reqd_Yn ="";
	String Third_Name_Reqd_Yn ="";
	String Family_Name_Reqd_Yn ="";
	String Name_Prefix_Reqd_Yn ="";
 	String NameDrvnLogic="";

	Statement stmt=null;
	Statement stmtlen=null;
	ResultSet rs=null;

	ResultSet rssd=null;
	ResultSet rslen=null; 
	Connection conn = null;
	try
	{

	conn = ConnectionManager.getConnection(request);;
	String len_check="Select Patient_Id_Length,Nat_Id_Length,alt_id1_length from mp_param";
	stmtlen=conn.createStatement();
	rslen=stmtlen.executeQuery(len_check);
	rslen.next();

	if(rslen!=null)rslen.close();
	if(stmtlen!=null)stmtlen.close();

	
	stmt=conn.createStatement();
	sql= "select nvl(First_Name_Accept_Yn,'N'),First_Name_Order,nvl(First_Name_Prompt,'First Name'),nvl(Second_Name_Accept_Yn,'N'),Second_Name_Order,nvl(Second_Name_Prompt,'Second Name'),nvl(Third_Name_Accept_Yn,'N'),Third_Name_Order,nvl(Third_Name_Prompt,'Third Name'),nvl(Family_Name_Accept_Yn,'N'),Family_Name_Order,nvl(Family_Name_Prompt,'Family Name'),nvl(name_suffix_accept_yn,'N'),nvl(name_prefix_accept_yn,'N'),nvl(name_suffix_prompt,'Name Suffix'),nvl(name_prefix_prompt,'Name Prefix'),nvl(first_name_reqd_yn,'N'),nvl(second_name_reqd_yn,'N'),nvl(third_name_reqd_yn,'N'),nvl(family_name_reqd_yn,'N'),nvl(name_suffix_reqd_yn,'N'),nvl(name_prefix_reqd_yn,'N'),name_dervn_logic, nvl(Alt_Id1_reqd_yn,'N'), Alt_Id1_type, nvl(Alt_Id1_length,0), nvl(Alt_Id1_Unique_yn,'N') from mp_param ";
	rs=stmt.executeQuery(sql);
	rs.next();
	First_Name_Accept_Yn = rs.getString(1);
	First_Name_Order = rs.getInt(2);
	First_Name_Prompt = rs.getString(3);
	Second_Name_Accept_Yn = rs.getString(4);
	Second_Name_Order = rs.getInt(5);
	Second_Name_Prompt = rs.getString(6);
	Third_Name_Accept_Yn = rs.getString(7);
	Third_Name_Order = rs.getInt(8);
	Third_Name_Prompt = rs.getString(9);
	Family_Name_Accept_Yn = rs.getString(10);
	Family_Name_Order = rs.getInt(11);
	Family_Name_Prompt = rs.getString(12);

	Name_Suffix_Accept_Yn = rs.getString(13);
	Name_Prefix_Accept_Yn = rs.getString(14);
	Name_Suffix_Prompt = rs.getString(15);
	Name_Prefix_Prompt = rs.getString(16);

	First_Name_Reqd_Yn = rs.getString(17);
	Second_Name_Reqd_Yn = rs.getString(18);
	Third_Name_Reqd_Yn = rs.getString(19);
	Family_Name_Reqd_Yn = rs.getString(20);
	Name_Prefix_Reqd_Yn = rs.getString(22);
	NameDrvnLogic=rs.getString(23);
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
%>
	     <body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>		
	     		<input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value='<%= NameDrvnLogic%>' >
	     		<input type='hidden' name='contactvals' id='contactvals' value=''>
	     		<input type='hidden' name='name_prefix' id='name_prefix' value=''>
			<input type='hidden' name='name_suffix' id='name_suffix' value=''>
    	    			<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top' >
						
						<tr>
							<td width="100%" class="Border">
	    					<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top' >
		    							<tr>
										<td width="100%" class="Border">
											<table border='0' cellpadding='0' cellspacing='0' width='100%'>
											<tr>
		<%
		if ( Name_Prefix_Accept_Yn.equals("Y") )
			out.println("<td align='left' class='label'>"+Name_Prefix_Prompt+"</td>");
		
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
				out.println("<td align='left' class='label' >"+ First_Name_Prompt + "</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
			out.println("<td align='left' class='label' >" + Second_Name_Prompt + "</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
			out.println("<td align='left' class='label' >" + Third_Name_Prompt + "</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
			out.println("<td align='left' class='label' >"+Family_Name_Prompt+"</td>");
		}

		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
			out.println("<td align='left' class='label' >"+ First_Name_Prompt + "</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
			out.println("<td align='left' class='label' >" + Second_Name_Prompt + "</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
			out.println("<td align='left' class='label' >" + Third_Name_Prompt + "</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
			out.println("<td align='left' class='label' >"+Family_Name_Prompt+"</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
			out.println("<td align='left' class='label' >"+ First_Name_Prompt + "</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
			out.println("<td align='left' class='label' >" + Second_Name_Prompt + "</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
			out.println("<td align='left' class='label' >" + Third_Name_Prompt + "</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
			out.println("<td align='left' class='label' >"+Family_Name_Prompt+"</td>");
		}
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
			out.println("<td align='left' class='label' >"+ First_Name_Prompt + "</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
			out.println("<td align='left' class='label' >" + Second_Name_Prompt + "</td>");
		}
			else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
				out.println("<td align='left' class='label' >" + Third_Name_Prompt + "</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
			out.println("<td align='left' class='label' >"+Family_Name_Prompt+"</td>");
		}
		
		if ( Name_Suffix_Accept_Yn.equals("Y") )
			out.println("<td align='left' class='label' >"+Name_Suffix_Prompt+"</td>");

		%>
		</tr>
		<tr>
		
		<%
		if ( Name_Prefix_Accept_Yn.equals("Y") )
		{
		
				out.println("<td align='left' nowrap id='name_prefix' class='query_data' align='center'>");
				out.println("");
			
			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
				out.println("<input type='hidden' name='first_name' id='first_name' size='15' maxlength='20'>");
			}
			else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
				out.println("<input type='hidden' name='second_name' id='second_name' size='15' maxlength='20'>");
			}
			else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
				out.println("<input type='hidden' name='third_name' id='third_name' size='15' maxlength='20'>");
			}
			else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
				out.println("<input type='hidden' name='family_name' id='family_name' size='15' maxlength='20'>");
			}
		
			if (Name_Prefix_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'></input>");
			}
		
		out.println("</td>");
		}
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 )
		{
				out.println("<td align='left' id='first_name' class='query_data' align='center'>");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
		{
			out.println("<td align='left' id='second_name' class='query_data' align='center'>");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )
		{
			out.println("<td align='left' id='third_name' class='query_data' align='center'>");
		
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 )
		{
			out.println("<td align='left' id='family_name' class='query_data' align='center'>");
		
		
			if ( Family_Name_Reqd_Yn.equals("Y") )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 )
		{
			out.println("<td align='left' id='first_name' class='query_data' align='center'>");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 )
		{
			out.println("<td align='left' id='second_name' class='query_data' align='center'>");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )
		{
			out.println("<td align='left' id='third_name' class='query_data' align='center'>");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 )
		{
			out.println("<td align='left' id='family_name' class='query_data' align='center'>");
		
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 )
		{
			out.println("<td align='left' id='first_name' class='query_data' align='center'>");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 )
		{
			out.println("<td align='left' id='second_name' class='query_data' align='center'>");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )
		{
			out.println("<td align='left' id='third_name' class='query_data' align='center'>");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 )
		{
			out.println("<td align='left' id='family_name' class='query_data' align='center'>");
		
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 )
		{
			out.println("<td align='left' id='first_name' class='query_data' align='center'>");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 )
		{
			out.println("<td align='left' id='second_name' class='query_data' align='center'>");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )
		{
			out.println("<td align='left' id='third_name' class='query_data' align='center'>");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 )
		{
			out.println("<td align='left' id='family_name' class='query_data' align='center'>");
		
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
				
		if ( Name_Suffix_Accept_Yn.equals("Y") )
		{
			out.println("<td align='left' nowrap id='name_suffix' class='query_data' align='center'>");
			out.println("</td>");
		}
		
		%>	    										</tr>
														</table>
														<table border='0' cellpadding='0' cellspacing='0' width='100%'>
																<tr>
																<td align="left"  class="label"  nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>
																</td>
																<td align='left'  class='label' colspan='2' nowrap>< Age >
																</td>
																<td align='left' class='label'  colspan='2' nowrap>Date of Birth
																</td>
																</tr>

																<tr>
		
																<td align='left' width='2%' id='gender' class='query_data' align='center'>
																</td>
																<td align='left' width='1%' colspan='2' nowrap id='b_age' class='query_data' align='center'>
																	
																</td>
																<td align='left' width='1%' id='date_of_birth' class='query_data' align='center'>

																</td>
																 <td align='right' colspan='3' >
																
																</td>

				    											</tr>
				    											</table>
				    											</td>
																</tr>
		    													</table>
		    													
												
				    									</td>
				    									</tr>
				    									</table>
		
		<% } 
		catch(Exception e ){out.println(e);} 
		finally
		{
			if(stmt!=null)stmt.close();
			if(stmtlen!=null)stmtlen.close();
			if(rs!=null)rs.close();
			if(rssd!=null)rssd.close();
			if(rslen!=null)rslen.close();
			ConnectionManager.returnConnection(conn,request);
		}
		%>
		<input type='hidden' name='text5' id='text5' value=''>
		<input type='hidden' name='text6' id='text6' value=''>
		

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

