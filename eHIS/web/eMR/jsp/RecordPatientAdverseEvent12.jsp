<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.StringTokenizer,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="adverseReaction1" class="webbeans.eCommon.RecordSet" scope="session"/>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>

<head><title><fmt:message key="eMR.ReactionSearch.label" bundle="${mr_labels}"/></title>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src='../../eCommon/js/messages.js' ></script>
  <!-- <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script> -->
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
 <script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script>

</head>
<%
	  Connection con = ConnectionManager.getConnection(request);
	  ResultSet rs   = null;
	  Statement stmt = null;
	   String react_val=request.getParameter("react_val")==null?"":request.getParameter("react_val");
	   String allergen=request.getParameter("allergen")==null?"":request.getParameter("allergen");
	   String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	   String flag=request.getParameter("flag")==null?"":request.getParameter("flag");
	   String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
	   String adv_event_ind=request.getParameter("adv_event_ind")==null?"":request.getParameter("adv_event_ind");
	   String adv_event_type=request.getParameter("adv_event_type")==null?"":request.getParameter("adv_event_type");
	   String patientId=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	   /*Avoid the Duplicate Reaction code added by Senthil on 12-08-2011*/
	   String reactcode=request.getParameter("reactcode")==null?"":request.getParameter("reactcode");
	   String oldreactionvalue_count=request.getParameter("oldreactionvalue_count")==null?"":request.getParameter("oldreactionvalue_count"); 
	   
	
	try 
	{
	
		
	%>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'  onscroll='scrollTitle()'>
   <form name = 'reaction_criteria_new'>
	<table cellpadding='0'  border='0' cellspacing='0' width='100%'  >	
	   <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
		<%if(!search_text.equals("")) {%>
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text" value="<%=search_text%>" width="30%" align="left" size="40" maxlength="70" >
        </td>
		<%}else{%>
   <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text"  width="30%" align="left" size="40" maxlength="70" >
        </td>
		<%}%>
		<td class="label">&nbsp;</td>

        <td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtextReaction(search_text); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm()" class="button" >
        </td>
    </tr>
	</table>
	<input type='hidden' name='allergen' id='allergen' value='<%=allergen%>'>
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
	<input type='hidden' name='flag' id='flag' value='<%=flag%>'>
	<input type='hidden' name='react_val' id='react_val' value='<%=react_val%>'>
	<input type='hidden' name='adv_event_ind' id='adv_event_ind' value='<%=adv_event_ind%>'>
	<input type='hidden' name='adv_event_type' id='adv_event_type' value='<%=adv_event_type%>'>
	<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>'>
	<input type='hidden' name='other_reaction' id='other_reaction' value=''>
	<input type='hidden' name='errorMsg' id='errorMsg' value=''>
	<input type='hidden' name='checkedRec' id='checkedRec' value=''>
	<input type='hidden' name='reactcode' id='reactcode' value='<%=reactcode%>'>
	<input type='hidden' name='oldreactionvalue_count' id='oldreactionvalue_count' value='<%=oldreactionvalue_count%>'>
	</form>
	</body>

	<% } catch(Exception e) {
          //out.println(e.toString());
		  e.printStackTrace();
          if(rs !=null) rs.close();
		  if(stmt !=null) stmt.close();
     }
     finally {
    
		  ConnectionManager.returnConnection(con,request);
     }%>
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

