<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
if (slot_appt_ctrl==null) slot_appt_ctrl ="";
//String alcn_criteria=request.getParameter("alcn_criteria");
String params = request.getQueryString() ;




String final_alcn_criteria=request.getParameter("final_alcn_criteria");


//String others="";
String final_alcn_criteria1="";
String otherCount="";
StringTokenizer valueToken=null;
StringTokenizer groupToken=null;
StringTokenizer str=null;
int cnt=0;
if(final_alcn_criteria!=null && !final_alcn_criteria.equals("")){
	str=new StringTokenizer(final_alcn_criteria,"$");
	int count=str.countTokens();
	if(count !=2){
		groupToken=new StringTokenizer(final_alcn_criteria,"|");
		while(groupToken.hasMoreTokens()){
			String token=groupToken.nextToken();
			valueToken=new StringTokenizer(token,"$");
			String val1=valueToken.nextToken();
			String val2=valueToken.nextToken();
			String val3=valueToken.nextToken();
			if(val1.equals("OTH")){
				//others=val1+"&"+val2+"&"+val3;
				otherCount=val2;
			}else{
				if(cnt==0){
					final_alcn_criteria1=val1+"&"+val2+"&"+val3;
				}else{
					final_alcn_criteria1=final_alcn_criteria1+"|"+val1+"&"+val2+"&"+val3;
				}
			}
		}
	}else{
		String strval1=valueToken.nextToken();
		String strval2=valueToken.nextToken();
		String strval3=valueToken.nextToken();
		final_alcn_criteria1=strval1+"&"+strval2+"&"+strval3;
	}
}
%>
<html>
<head>
<script src='../../eOA/js/ClinicAllocation.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name='clinic_addmodify' id='clinic_addmodify' src="../../eCommon/html/blank.html" frameborder=0 noresize scrolling=no  framespacing='0' >
<iframeset cols='40%,60%' style='height:0%;width:100vw'></iframe><iframe name='add_allocation' id='add_allocation' src="../../eOA/jsp/AddPatientCategory.jsp?<%=params%>" frameborder=0 noresize scrolling=no>
<iframe name='display_allocation' id='display_allocation' src="../../eOA/jsp/AddPatientCategoryResult.jsp?<%=params%>"  frameborder=0 noresize style='height:100vh;width:100vw'></iframe>

<frame name='display_message' id='display_message' src="../../eOA/jsp/OthersCategoryMessage.jsp?step=1&<%=params%>&otherCountval=<%=otherCount%>" frameborder=0 noresize scrolling=no>
</frameset>
</html>

