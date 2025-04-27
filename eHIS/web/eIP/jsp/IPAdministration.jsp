<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");  %>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src='../../eCommon/js/common.js'></script>
	
	<script language="JavaScript">
	
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='IPCAHIGHERLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();
		function goHomePage()
		{
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*	Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
			if(val == 'NURS_UNIT_ROOM')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitRoom.jsp?function_name='+encodeURIComponent(getLabel("Common.room.label","Common"))+'&nbsp;'+encodeURIComponent(getLabel("Common.for.label","Common"))+'&nbsp;'+encodeURIComponent(getLabel("Common.nursingUnit.label","Common"))+'&access=YYYNN&function_type=F';
			if(val == 'NURS_UNIT_PRACT')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitPract.jsp?function_name='+encodeURIComponent(getLabel("eIP.PractitionerforNursingUnit.label","IP"))+'&access=YYYYN&function_type=F';
			if(val == 'NURS_UNIT_SPECIALTY')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitSpecialty.jsp?function_name='+encodeURIComponent(getLabel("eIP.SpecialtyforNursingUnit.label","IP"))+'&access=YYYYN&function_type=F';
			
			if(val == 'NURS_UNIT_BED')
				parent.frames[1].location.href = '../../eIP/jsp/NursUnitBed.jsp?function_name='+encodeURIComponent(getLabel("Common.Bed.label","Common"))+'&nbsp;'+encodeURIComponent(getLabel("Common.for.label","Common"))+'&nbsp;'+encodeURIComponent(getLabel("Common.nursingUnit.label","Common"))+'&access=YYYNN&function_type=F';
			if(val == 'TRANSFER_CHARGE')
				parent.frames[1].location.href = '../../eIP/jsp/TransferCharge.jsp?function_name='+encodeURIComponent(getLabel("eIP.TransferCharge.label","IP"))+'&access=YYYNN&function_type=F';
			
			if(val == 'NURS_UT_BKG_LT')
			parent.frames[1].location.href = '../../eIP/jsp/NursingUnitBkgLt.jsp?function_name='+encodeURIComponent(getLabel("eIP.BookingLimitByNursingUnitBedClass.label","IP"))+'&access=YYYNN&function_type=F';
			
			if(val == 'AGE_GRP_BOOK_LT')
			parent.frames[1].location.href = '../../eIP/jsp/AgeGrpBookLt.jsp?function_name='+encodeURIComponent(getLabel('eIP.BookingLimitByAgeGroupBedClass.label','IP'))+'&access=YYYNN&function_type=F';
			
			if(val == 'BED_BKG_SRL_CTRL')
			parent.frames[1].location.href = '../../eIP/jsp/BedBkgSrlCtrl.jsp?function_name='+encodeURIComponent(getLabel('eIP.BedBookingSerialControl.label','IP'))+'&access=YYYNN&function_type=F';
			
		}

	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	   request.setCharacterEncoding("UTF-8");
	   String facilityId = (String)session.getValue("facility_id");
	   String bl_instal_yn = "N";
	   Connection con = null;
	   PreparedStatement pstmt = null;
	   ResultSet rset = null;
	   	try{
	         con = ConnectionManager.getConnection(request);
			 pstmt = con.prepareStatement("select BL_INTERFACED_YN from ip_param where facility_id='"+facilityId+"' ");
			 rset = pstmt.executeQuery();
			 while (rset!=null && rset.next())
			{
				bl_instal_yn = rset.getString(1);
				if(rset!=null)	rset.close();
				if(pstmt!=null)	pstmt.close();
			}
			if(bl_instal_yn==null || bl_instal_yn.equals(""))
				bl_instal_yn = "N";
			
		}catch(Exception e)
		{
			 e.toString();
		}
		finally {
			  if(pstmt!=null) pstmt.close();
			  if(rset!=null) rset.close();
			  ConnectionManager.returnConnection(con,request); 
		}
	%>

	<body style="background-color:dimgray;" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name="IPAdministration_form" id="IPAdministration_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		<tr>
			<td  class='IPCAHIGHERLEVELCOLOR'><fmt:message key="eIP.IPMiscsetup.label" bundle="${ip_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("NURS_UT_BKG_LT")'><fmt:message key="eIP.BookingLimitByNursingUnitBedClass.label" bundle="${ip_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("AGE_GRP_BOOK_LT")'><fmt:message key="eIP.BookingLimitByAgeGroupBedClass.label" bundle="${ip_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick='callJSPs("BED_BKG_SRL_CTRL")'><fmt:message key="eIP.BedBookingSerialControl.label" bundle="${ip_labels}"/></td>
		</tr>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR'><a href=javascript:goHomePage() style='color:white;'><fmt:message key="Common.menu.label" bundle="${common_labels}"/></a></td>
		</tr>
	</table>
	</body>
	</form>
</html>
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

