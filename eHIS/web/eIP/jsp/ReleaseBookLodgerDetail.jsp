<!DOCTYPE html>
<%
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckOutLodger && Lodger -> RenewGatePass
/// Developer		:	SRIDHAR R
/// Created On		:	FEB 2004
/// Funtion			:	This File is called from ReleaseLodgerLookupResult.jsp.

//	Here frames are defined for ChkOutLodger or RenewGatePass Functions & will direct the Page to CheckinLodgerDetail.jsp for ChkOutLodger && to CheckinAccmpPersonDetail.jsp for ChkOutAccomPerson && amendGatePassDetail.jsp for RenewGatePass Functions.
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<script language='javascript' src='../js/BookLodger.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	
<%
    request.setCharacterEncoding("UTF-8");
	String FrameName = request.getParameter("ResultPageName");
	String call_function = checkForNull(request.getParameter("call_function"));
	String EncounterId = checkForNull(request.getParameter("EncounterId"));

	if(FrameName.equals("GatePass"))
	{	%>
		<title><fmt:message key="eIP.renewgatepass.label" bundle="${ip_labels}"/></title>
		<html>
		<%
			//String rows ="*,7%" ;
			String Category = request.getParameter("Category");
				//if(Category.equals("Y"))
				//	rows = "43,*,7%" ;*/
					
		%>

			<%	if(Category.equals("Y")) 
				{	%>
					<iframe name='detail' src='../../eCommon/jsp/pline.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
					<iframe name='detail' src='../jsp/AmendGatePassDetail.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:85vh;width:100vw'></iframe>
					<iframe name='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:7vh;width:100vw'></iframe>
			<%	}else{ %>
					<iframe name='detail' src='../jsp/AmendGatePassDetail.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:93vh;width:100vw'></iframe>
					<iframe name='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:7vh;width:100vw'></iframe>
			<%	} %>
				
		</html>
<%	}
	else if(call_function.equals("CHECK_OUT_LODGER"))
	{	%>
		<title><fmt:message key="eIP.checkoutlodger.label" bundle="${ip_labels}"/></title>
		<html>
			<iframe name='checkOutLodger' src='../jsp/CheckinLodgerDetail.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:95vh;width:100vw'></iframe>
			<iframe name='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
		</html>
<%	}else if(call_function.equals("CHECK_OUT_ACCMP_PERSON")) 
	{	%>
		<title><fmt:message key="eIP.checkoutaccomperson.label" bundle="${ip_labels}"/></title>
		<html>
			<iframe name="PatientLine_frame" src="../../eCommon/jsp/pline.jsp?EncounterId=<%=EncounterId%>&<%=request.getQueryString()%>" scrolling='no' noresize border='0' style='height:7vh;width:100vw'></iframe>
			<iframe name='checkOutAccPerson' src='../jsp/CheckinAccmpPersonDetail.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:88vh;width:100vw'></iframe>
			<iframe name='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
		</html>
<%	}	%>

<%!	
	// Added by Sridhar R on 3/16/2005 for chking null values..
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	"" : inputString;
	}
%>
