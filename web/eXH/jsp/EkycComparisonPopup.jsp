<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% String sStyle = (String)session.getAttribute("PREFERRED_STYLE"); %>
<html>
	<%

		String aFirstName = request.getParameter("aFirstName")== null? "" : request.getParameter("aFirstName");
		String aSecondName = request.getParameter("aSecondName")== null? "" : request.getParameter("aSecondName");
		String aThirdName = request.getParameter("aThirdName")== null? "" : request.getParameter("aThirdName");
		String aFamilyName = request.getParameter("aFamilyName")== null? "" : request.getParameter("aFamilyName");
		String aDOB = request.getParameter("aDOB")== null? "" : request.getParameter("aDOB");
		String aGender = request.getParameter("aGen")== null? "" : request.getParameter("aGen");
		String aMail = request.getParameter("aMail")== null? "" : request.getParameter("aMail");
		String aMobile = request.getParameter("aMob")== null? "" : request.getParameter("aMob");
		String address1 = request.getParameter("adr1")== null? "" : request.getParameter("adr1");
		String address2 = request.getParameter("adr2")== null? "" : request.getParameter("adr2");
		String address3 = request.getParameter("adr3")== null? "" : request.getParameter("adr3");
		String address4 = request.getParameter("adr4")== null? "" : request.getParameter("adr4");
		String aDistrict = request.getParameter("aDist")== null? "" : request.getParameter("aDist");
		String aState = request.getParameter("aState")== null? "" : request.getParameter("aState");
		String aPostalCode = request.getParameter("aPC")== null? "" : request.getParameter("aPC");

		String kFirstName = request.getParameter("kFirstName")== null? "" : request.getParameter("kFirstName");
		String kSecondName = request.getParameter("kSecondName")== null? "" : request.getParameter("kSecondName");
		String kThirdName = request.getParameter("kThirdName")== null? "" : request.getParameter("kThirdName");
		String kFamilyName = request.getParameter("kFamilyName")== null? "" : request.getParameter("kFamilyName");
		String kGender = request.getParameter("kGen")== null? "" : request.getParameter("kGen");
		String kDOB = request.getParameter("kDob")== null? "" : request.getParameter("kDob");
		String kMail = request.getParameter("kEmail")== null? "" : request.getParameter("kEmail");
		String kMobile = request.getParameter("kMob")== null? "" : request.getParameter("kMob");
		String kAddress1 = request.getParameter("kAdr1")== null? "" : request.getParameter("kAdr1");
		String kAddress2 = request.getParameter("kAdr2")== null? "" : request.getParameter("kAdr2");
		String kAddress3 = request.getParameter("kAdr3")== null? "" : request.getParameter("kAdr3");
		String kAddress4 = request.getParameter("kAdr4")== null? "" : request.getParameter("kAdr4");
		String kPostalCode = request.getParameter("kPC")== null? "" : request.getParameter("kPC");
		String kState = request.getParameter("kState")== null? "" : request.getParameter("kState");
		String kDistrict = request.getParameter("kDist")== null? "" : request.getParameter("kDist");

		String aadharNumber = request.getParameter("aadharId")== null? "" : request.getParameter("aadharId");

	%>
	<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script Language="javascript" src="../../eMP/js/PasInterface.js"> </script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<style>

		tr, td{
			border-bottom: 1px solid #d5ecfb;
			border-top: 1px solid #d5ecfb;
			border-left: 1px solid #d5ecfb;
			border-right: 1px solid #d5ecfb;	
		}

		.btn {
			border: none; /* Remove borders */
			color: white; /* Add a text color */
			padding: 8px 22px; /* Add some padding */
			cursor: pointer; /* Add a pointer cursor on mouse-over */
		}

		.info {background-color: #0063c5;} /* Blue */
		.info:hover {background: #0b7dda;}

	</style>

	<script>
		function cancel()
		{
			window.close();
		}

		function reset()
		{
		  document.forms[0].reset();
		}
	</script>

	<title>
		eKYC Comparison
	</title>
	</head>
	<form>
		<table width="100%" height="100%" cellPadding="1" noWrap="nowrap" bgcolor="#000000" style="border-collapse: collapse;border-style: solid;border-color: #d5ecfb #d5ecfb;">
			<tr height="40">
				<td  colSpan="4"  align="center"  style="background-color: #dae6f2; color: black;"> Compare eKYC Data and EM data </td>
				</tr>
				<tr height="30">
				<td   colSpan="4"  align="left" style="background-color: #dae6f2; color: black;"> Aadhaar Number from eKYC - <%=aadharNumber %> </td>
				</tr>
				<tr style="background-color: #f2f9fe; color: black; border-bottom: 1px solid #d5ecfb;">
				<td height="45">&nbsp</td>
				<td height="45">EM</td>
				<td height="45">eKYC</td>
				<td height="45">Action</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">First Name</td>
				<td height="30" style="font-size: 105%;"><%=aFirstName %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kFirstName %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aFirstName.equalsIgnoreCase(kFirstName)) { 
				%>
					<input type='checkbox' name='firstNameCheck' id='firstNameCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Second Name</td>
				<td height="30" style="font-size: 105%;"><%=aSecondName %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kSecondName %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aSecondName.equalsIgnoreCase(kSecondName)) { 
				%>
					<input type='checkbox' name='secondNameCheck' id='secondNameCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Family Name</td>
				<td height="30" style="font-size: 105%;"><%=aFamilyName %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kFamilyName %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aFamilyName.equalsIgnoreCase(kFamilyName)) { 
				%>
					<input type='checkbox' name='familyNameCheck' id='familyNameCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Date of Birth</td>
				<td height="30" style="font-size: 105%;"><%=aDOB %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kDOB %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aDOB.equalsIgnoreCase(kDOB)) { 
				%>
					<input type='checkbox' name='dobCheck' id='dobCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Gender</td>
				<td height="30" style="font-size: 105%;"><%=aGender %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kGender %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aGender.equalsIgnoreCase(kGender)) { 
				%>
					<input type='checkbox' name='genderCheck' id='genderCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Phone number</td>
				<td height="30" style="font-size: 105%;"><%=aMobile %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kMobile %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aMobile.equalsIgnoreCase(kMobile)) { 
				%>
					<input type='checkbox' name='mobileNumCheck' id='mobileNumCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Email</td>
				<td height="30" style="font-size: 105%;"><%=aMail %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kMail %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aMail.equalsIgnoreCase(kMail)) { 
				%>
					<input type='checkbox' name='mailCheck' id='mailCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Address 1</td>
				<td height="30" style="font-size: 105%;"><%=address1 %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kAddress1 %> &nbsp;</td>
				<td height="30">
				<% 
					if(!address1.equalsIgnoreCase(kAddress1)) { 
				%>
					<input type='checkbox' name='addr1Check' id='addr1Check' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Address 2</td>
				<td height="30" style="font-size: 105%;"><%=address2 %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kAddress2 %> &nbsp;</td>
				<td height="30">
				<% 
					if(!address2.equalsIgnoreCase(kAddress2)) { 
				%>
					<input type='checkbox' name='addr2Check' id='addr2Check' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Address 3</td>
				<td height="30" style="font-size: 105%;"><%=address3 %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kAddress3 %> &nbsp;</td>
				<td height="30">
				<% 
					if(!address3.equalsIgnoreCase(kAddress3)) { 
				%>
					<input type='checkbox' name='addr3Check' id='addr3Check' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Address 4</td>
				<td height="30" style="font-size: 105%;"><%=address4 %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kAddress4 %> &nbsp;</td>
				<td height="30">
				<% 
					if(!address4.equalsIgnoreCase(kAddress4)) { 
				%>
					<input type='checkbox' name='addr4Check' id='addr4Check' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">District</td>
				<td height="30" style="font-size: 105%;"><%=aDistrict %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kDistrict %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aDistrict.equalsIgnoreCase(kDistrict)) { 
				%>
					<input type='checkbox' name='districtCheck' id='districtCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">State</td>
				<td height="30" style="font-size: 105%;"><%=aState %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kState %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aState.equalsIgnoreCase(kState)) { 
				%>
					<input type='checkbox' name='stateCheck' id='stateCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="border-bottom: 1px solid #d5ecfb;">
				<td height="30" style="background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;">Postal Code</td>
				<td height="30" style="font-size: 105%;"><%=aPostalCode %> &nbsp;</td>
				<td height="30" style="font-size: 105%;"><%=kPostalCode %> &nbsp;</td>
				<td height="30">
				<% 
					if(!aPostalCode.equalsIgnoreCase(kPostalCode)) { 
				%>
					<input type='checkbox' name='postalCodeCheck' id='postalCodeCheck' value='Y'>
				<% 
					} 
				%>
				&nbsp;</td>
			</tr>
			<tr style="background-color: #dae6f2; color: black;">
				<td rowSpan="1" colSpan="4" align="right" height="50">
					<input class="btn info" type="button" value="Save Validation " align="right" onClick="saveValidation();" />
					<input class="btn info" type="button" value="Replace from eKYC" align="right" onClick="replaceValues();"/>
					<input class="btn info" type="button" value="Cancel" align="right" onClick="cancelValidation()"/>
				</td>
			</tr>
		</table>
		<input type=hidden name="aFirstName" id="aFirstName" value="<%=aFirstName %>" >
		<input type=hidden name="aSecondName" id="aSecondName" value="<%=aSecondName %>" >
		<input type=hidden name="aThirdName" id="aThirdName" value="<%=aThirdName %>" >
		<input type=hidden name="aFamilyName" id="aFamilyName" value="<%=aFamilyName %>" >
		<input type=hidden name="aDOB" id="aDOB" value="<%=aDOB %>" >
		<input type=hidden name="aGender" id="aGender" value="<%=aGender %>" >
		<input type=hidden name="aMail" id="aMail" value="<%=aMail %>" >
		<input type=hidden name="aMobile" id="aMobile" value="<%=aMobile %>" >
		<input type=hidden name="address1" id="address1" value="<%=address1 %>" >
		<input type=hidden name="address2" id="address2" value="<%=address2 %>" >
		<input type=hidden name="address3" id="address3" value="<%=address3 %>" >
		<input type=hidden name="address4" id="address4" value="<%=address4 %>" >
		<input type=hidden name="aDistrict" id="aDistrict" value="<%=aDistrict %>" >
		<input type=hidden name="aState" id="aState" value="<%=aState %>" >
		<input type=hidden name="aPostalCode" id="aPostalCode" value="<%=aPostalCode %>" >

		<input type=hidden name="kFirstName" id="kFirstName" value="<%=kFirstName %>" >
		<input type=hidden name="kSecondName" id="kSecondName" value="<%=kSecondName %>" >
		<input type=hidden name="kThirdName" id="kThirdName" value="<%=kThirdName %>" >
		<input type=hidden name="kFamilyName" id="kFamilyName" value="<%=kFamilyName %>" >
		<input type=hidden name="kGender" id="kGender" value="<%=kGender %>" >
		<input type=hidden name="kDOB" id="kDOB" value="<%=kDOB %>" >
		<input type=hidden name="kMail" id="kMail" value="<%=kMail %>" >
		<input type=hidden name="kMobile" id="kMobile" value="<%=kMobile %>" >
		<input type=hidden name="kAddress1" id="kAddress1" value="<%=kAddress1 %>" >
		<input type=hidden name="kAddress2" id="kAddress2" value="<%=kAddress2 %>" >
		<input type=hidden name="kAddress3" id="kAddress3" value="<%=kAddress3 %>" >
		<input type=hidden name="kAddress4" id="kAddress4" value="<%=kAddress4 %>" >
		<input type=hidden name="kDistrict" id="kDistrict" value="<%=kDistrict %>" >
		<input type=hidden name="kState" id="kState" value="<%=kState %>" >
		<input type=hidden name="kPostalCode" id="kPostalCode" value="<%=kPostalCode %>" >
	</form>
</html>

