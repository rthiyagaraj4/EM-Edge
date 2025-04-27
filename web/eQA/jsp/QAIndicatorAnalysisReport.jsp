<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
   <html>
	<head>
	<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script type="text/javascript" src="../../eCommon/js/common.js"></script>
	<script type="text/javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script type="text/javascript" src="../../eQA/js/QAReport.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%!	  String facility_id="",login_user="";
      Properties p = null;
	  %>
	</head>
      <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
      <form name='QAGeneral_report' id='QAGeneral_report'    action="../../eCommon/jsp/report_options.jsp"   target="messageFrame">
      <BR><BR><BR>
		<div align='left' >
      	<table width='60%' border=0 align='center'>
      	<tr><td  valign='center' width='60%' style="background-color:#E0E1EB;">

		 	<center>
      	<table border='0' cellpadding='0' cellspacing='0' >
      	 <tr><td colspan=3>&nbsp</td></tr>
      	
      		<tr><td colspan=3>&nbsp</td></tr>
      			  	
			<tr>
    			<td width='30%' align='right' class='label'>Clinical Indicator</td>
      		    <td width='70%' colspan='2'>&nbsp;&nbsp;<input type='text' name='P_QIND_CLIND_NAME' id='P_QIND_CLIND_NAME' size='36' maxlength='35' value="" onblur='funClinicianGroup(this); poprep();' ><input type='button' name='P_QIND_CLIEND_QUEST' id='P_QIND_CLIEND_QUEST' value='?' class='button' OnClick=" funClinicianGroup(P_QIND_CLIND_NAME),poprep();"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
                <input type="hidden" name='P_QIND_CLIND_ID' id='P_QIND_CLIND_ID'; value="">
   		    </tr>
		   	<tr>
				<td colspan=3>&nbsp</td>
			</tr>
      		<tr>
      			<td width='30%' align='right' class='label'>Report Periodicity</td>
      			<td width='70%' align='left' colspan='2'>&nbsp;&nbsp;
				<select name='P_PERIODICITY' id='P_PERIODICITY' onChange='funPeriodicity()'><option value=''>&nbsp;&nbsp;-------- Select --------&nbsp;&nbsp;</option><option value='M' >Monthly&nbsp;<option value='Q'>Quarterly &nbsp;<option value='B'>Bi-Annually &nbsp;<option value='A'>Annually &nbsp;</select>
		   		<img align='center' src='../../eCommon/images/mandatory.gif'></img>
		   		</td>
			</tr>
		<tr><td colspan=3>&nbsp</td></tr>
<tr>
	<td width='30%' align='right' class=label nowrap>From Period</td>

	<td width='70%'  colspan='2'>&nbsp;&nbsp;
	<input type='text' name='P_FROM_YEAR' id='P_FROM_YEAR' value='<%=new java.util.Date().getYear()+1900%>' onblur='check_from_date(this);' size=10 maxlength=4>

	<select name='P_FROM' id='P_FROM'>
	<option value=''>----Select-----</option>
	</select>   		


	<img src='../../eCommon/images/mandatory.gif' id='hide'>
	</td>
	<td >&nbsp;</td>

	</tr>
		<tr><td colspan=3>&nbsp</td></tr>
	<tr>
		<td width='30%' align='right' class=label>To Period</td>
		<td width='70%'  colspan='2'>&nbsp;&nbsp;
		<input type='text' name='P_TO_YEAR' id='P_TO_YEAR' value='<%=new java.util.Date().getYear()+1900%>'  onblur='check_to_date(this);'  size=10 maxlength=4>

		<select name='P_TO' id='P_TO' onChange ='check_all_date(this);' >
		<option value=''>-----Select-----
		</option>
		</select>   		
		</td>	
		<td >&nbsp;</td>
	</tr>
      		<tr><td colspan=3>&nbsp</td></tr>
		</table>
      	</td>
		</tr>
      	</table>
      	</div> 
		<%		
			HttpSession httpSession = request.getSession(false);
			p = (Properties)httpSession.getValue("jdbc"); 
			facility_id = (String)httpSession.getValue("facility_id");
			login_user =  p.getProperty("login_user");
			//resp_id= (String)httpSession.getValue("responsibility_id");	
		%>
		<input type="hidden" name="P_FACILITY_ID" id="P_FACILITY_ID"		value=<%=facility_id%>>
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="QABCLIND">
		<input type="hidden" name="p_user_name" id="p_user_name"			value=<%=login_user%>>
      	</form>
      	</body>
      	</html>

