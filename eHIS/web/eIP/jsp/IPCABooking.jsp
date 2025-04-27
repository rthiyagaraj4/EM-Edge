<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
<html>
<title><fmt:message key="Common.booking.label" bundle="${common_labels}"/></title>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>		
			
	<script language='javascript' src='../js/Booking.js'></script>
	<script language='javascript' src='../js/Booking1.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String query_string = request.getQueryString();
	String bkg_lst_ref_no = request.getParameter("bkg_lst_ref_no");
	if(bkg_lst_ref_no == null) bkg_lst_ref_no="";
	String is_ca_yn = request.getParameter("CA");
	if(is_ca_yn==null || is_ca_yn.equals("")) is_ca_yn="";
	String ca_patient_id = request.getParameter("patient_id");
	if(ca_patient_id==null || ca_patient_id.equals("")) ca_patient_id="";




%>
	
	
	
	<script>
	async function ipcaBooking(){
		var retVal		 = 	new String();
		var dialogHeight= "70vh" ;
		var dialogTop	 = "80vw";
		var dialogWidth	= "65" ;
		var status		= "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ;dialogTop:"+dialogTop+"; scroll=no; status:" + status;
		retVal			 = await window.showModalDialog("../../eIP/jsp/Booking.jsp?is_ca_yn=<%=is_ca_yn%>&bkg_lst_ref_no=<%=bkg_lst_ref_no%>&ca_patient_id=<%=ca_patient_id%>",arguments,features);
		
		document.location.href='../../eCA/jsp/CAMainTitle.jsp?query_string=<%=query_string%>';
	}
	ipcaBooking();
	</script>
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

