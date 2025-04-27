<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"%>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/BookingRights.js'></script>
<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
//String login_id = request.getParameter("login_id")==null?"":request.getParameter( "login_id" );
String chk_checked="checked";
String chk_value="Y";
String chk_checked1="checked";
String chk_value1="Y";
String chk_checked2="checked";
String chk_value2="Y";
String chk_checked3="checked";
String chk_value3="Y";
String chk_checked4="checked";
String chk_value4="Y";
//Added by lakshmi against MO-CRF-20058 starts here
String chk_checked5="checked";
String chk_value5="Y";
String overbooking_allowed_yn="";
//Added by lakshmi against MO-CRF-20058 ends here
String appl_user_id = request.getParameter("appl_user_id")==null?"":request.getParameter( "appl_user_id" );
String disable_flag="";
String appl_user_name = request.getParameter("appl_user_name")==null?"":request.getParameter( "appl_user_name" );;
String book_schedule_yn="";
String cancel_schedule_yn="";
String transfer_schedule_yn="";
String overide_splty_restriction_yn="";
String restrict_bkg_display_to_self="";
String sql="";
String facility_id=(String) session.getAttribute("facility_id");
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		//sql=" SELECT A.APPL_USER_ID, B.APPL_USER_NAME, A.BOOK_SCHEDULE_YN, A.TRANSFER_SCHEDULE_YN, A.CANCEL_SCHEDULE_YN, A.OVERIDE_SPLTY_RESTRICTION_YN, A.RESTRICT_BKG_DISPLAY_TO_SELF FROM OT_BOOKING_ACCESS_RIGHTS A, SM_APPL_USER B WHERE A.OPERATING_FACILITY_ID = ? AND A.APPL_USER_ID = ? AND   B.APPL_USER_NAME=? ";
		sql=" SELECT A.APPL_USER_ID, B.APPL_USER_NAME, A.BOOK_SCHEDULE_YN, A.TRANSFER_SCHEDULE_YN, A.CANCEL_SCHEDULE_YN, A.OVERIDE_SPLTY_RESTRICTION_YN, A.RESTRICT_BKG_DISPLAY_TO_SELF,NVL(A.OVER_BOOK_YN, 'N') FROM OT_BOOKING_ACCESS_RIGHTS A, SM_APPL_USER B WHERE A.OPERATING_FACILITY_ID = ? AND A.APPL_USER_ID = ? AND   B.APPL_USER_NAME=? ";//Modified by lakshmi against MO-CRF-20058
		stmt=con.prepareStatement(sql);
		stmt.setString(1,facility_id);
		stmt.setString(2,appl_user_id);
		stmt.setString(3,appl_user_name);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			appl_user_id=rs.getString(1);
			appl_user_name=rs.getString(2);
			book_schedule_yn=rs.getString(3);
			transfer_schedule_yn=rs.getString(4);
            cancel_schedule_yn=rs.getString(5);
			overide_splty_restriction_yn=rs.getString(6);
			restrict_bkg_display_to_self=rs.getString(7);
			overbooking_allowed_yn=rs.getString(8);//Added by lakshmi against MO-CRF-20058
		}
		if(book_schedule_yn.equals("Y"))
		{
			chk_checked="checked";
			//disable_flag="";
			
		}
		else
		{
			chk_checked="";
			//disable_flag="disabled";
			chk_value="N";
		}

		if(transfer_schedule_yn.equals("Y"))
		{
			chk_checked1="checked";
			//disable_flag="";
			
		}
		else
		{
			chk_checked1="";
			//disable_flag="disabled";
			chk_value1="N";
		}

		if(cancel_schedule_yn.equals("Y"))
		{
			chk_checked2="checked";
			//disable_flag="";
			
		}
		else
		{
			chk_checked2="";
			//disable_flag="disabled";
			chk_value2="N";
		}
		
		if(overide_splty_restriction_yn.equals("Y"))
		{
			chk_checked3="checked";
			disable_flag="";
			
		}
		else
		{
			chk_checked3="";
			disable_flag="disabled";
			chk_value3="N";
		}

		if(restrict_bkg_display_to_self.equals("Y"))
		{
			chk_checked4="checked";
		}
		else
		{
			chk_checked4="";
			chk_value4="N";
		}

		//Added by lakshmi against MO-CRF-20058 starts here
		if(overbooking_allowed_yn.equals("Y"))
		{
			chk_checked5="checked";
		}
		else
		{
			chk_checked5="";
			chk_value5="N";
		}
		//Added by lakshmi against MO-CRF-20058 ends here
		
	//login_id_disable="disabled";
	//appl_user_name_disable="disabled";
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
}

%>
<form name="bookingRights_form" id="bookingRights_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.BookingRightsServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
<% if(mode.equals("insert"))
{ %>
<tr>
	<td class=label>
		<fmt:message key="Common.name.label" bundle="${common_labels}"/>
	</td>
	<td class=fields>
		<input type="text" name="appl_user_id" id="appl_user_id" size="30" maxlength=30 value=" " onBlur="if(this.value!='')callLoginUser();">
		<input type="button" class="button" name="generic_search" id="generic_search" value="?"  onClick='callLoginUser();' >
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>		
<tr>
	<td class=label><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
	<td class="fields">

		<input type="text" name="appl_user_name" id="appl_user_name" value=""  size=10 maxlength=10 readonly>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eOT.Book.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="book_schedule_yn" id="book_schedule_yn"
		onClick="bookScheduleYN();" value="<%=chk_value%>">
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="transfer_schedule_yn" id="transfer_schedule_yn"
		onClick="transferScheduleYN();" value="<%=chk_value1%>"> 
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="cancel_schedule_yn" id="cancel_schedule_yn"
		onClick="cancelScheduleYN();" value="<%=chk_value2%>">
	</td>
</tr>
<!--Added by lakshmi against MO-CRF-20058 starts here-->
<tr>
	<td class=label>
		<fmt:message key="eOT.OverBookingAllowedYN.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="overbooking_allowed_yn" id="overbooking_allowed_yn"
		onClick="overbookingAllowedYN();" value="<%=chk_value5%>">
	</td>
</tr>
<!--Added by lakshmi against MO-CRF-20058 ends here-->
<tr>
	<td class=label>
		<fmt:message key="eOT.OverrideSpecialtyRestriction.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="overide_splty_restriction_yn" id="overide_splty_restriction_yn" onClick='overrideSpecialityRestriction();' value='<%=chk_value3%>' >
	</td>
</tr>
<!-- Added on 9/16/2010 for crf -->
<!--<tr>
	<td class=label>
		<fmt:message key="eOT.DisplayonlyloggedinUserBookings.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="restrict_bkg_display_to_self" id="restrict_bkg_display_to_self" onClick='restrictBkgDisplayToSelf();' value='<%=chk_value4%>' >
	</td>
</tr> -->
<% } else if(mode.equals("modify"))
{%>

 <tr>
	<td class=label >
		<fmt:message key="Common.login.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text"  name="appl_user_id" id="appl_user_id" size='30' value="<%=appl_user_id%>" disabled>
		<input type="hidden" name="appl_user_id1" id="appl_user_id1" value="<%=appl_user_id%>">
		<input type="button" class="button" name="generic_search" id="generic_search" value="?"  disabled >
       <img src='../../eCommon/images/mandatory.gif'></td>
</tr>
	
<tr>
	<td class=label>
		<fmt:message key="Common.name.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="appl_user_name" id="appl_user_name" value="<%=appl_user_name%>"  disabled size=30 maxlength=30>
	</td>
</tr>		
<tr>
	<td class=label>
		<fmt:message key="eOT.Book.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="book_schedule_yn" id="book_schedule_yn"
		onClick="bookScheduleYN();" value="<%=chk_value%>" <%=chk_checked%>>
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="transfer_schedule_yn" id="transfer_schedule_yn"
		onClick="transferScheduleYN();" value="<%=chk_value1%>" <%=chk_checked1%>> 
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="cancel_schedule_yn" id="cancel_schedule_yn"
		onClick="cancelScheduleYN();" value="<%=chk_value2%>" <%=chk_checked2%>>
	</td>
</tr>
<!--Added by lakshmi against MO-CRF-20058 starts here-->
<tr>
	<td class=label>
		<fmt:message key="eOT.OverBookingAllowedYN.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="overbooking_allowed_yn" id="overbooking_allowed_yn"
		onClick="overbookingAllowedYN();" value="<%=chk_value5%>" <%=chk_checked5%>> 
	</td>
</tr>
<!--Added by lakshmi against MO-CRF-20058 ends here-->
<tr>
	<td class=label>
		<fmt:message key="eOT.OverrideSpecialtyRestriction.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="overide_splty_restriction_yn" id="overide_splty_restriction_yn" onClick='overrideSpecialityRestriction();' value='<%=chk_value3%>' <%=chk_checked3%>  >
	</td>
</tr>

<!--<tr>
	<td class=label>
		<fmt:message key="eOT.DisplayonlyloggedinUserBookings.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="restrict_bkg_display_to_self" id="restrict_bkg_display_to_self" onClick='restrictBkgDisplayToSelf();' value='<%=chk_value4%>' <%=chk_checked4%>  >
	</td>
</tr>  -->
<% }%>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='appl_user_name1' id='appl_user_name1' value="<%=appl_user_name%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


