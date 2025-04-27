<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html> 
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eOP/js/OPQSeries.js'  language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function assign(val)
    {
		opqueueseries_form.next_queue_num.value=val;
    }
	function NumberCheck(obj)
    {
		if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)
            {   }
            else
            {
				if ( obj.value.length > 0 )
                {
					var errors = getMessage("NUM_ALLOWED","SM");
					alert(errors);
                    obj.value="0";
                    obj.select();
                    obj.focus();
                }
            }
   }
	function Numberzero(obj)
	{
		 if(obj.value == 0){
			var errors = getMessage("AE_NUMBER_ZERO","AE");
			alert(errors);
			obj.value="";
			obj.select();
			obj.focus();
		 }
	}

	function checkGrtVal(obj,obj1)
    {
        var val=parseInt(obj.value,10);
        var val1=parseInt(obj1.value,10);
		//var arr = new Array(str,str1)
        if (val>=val1) {
           var msg = getMessage("RESET_NUM_GR_NEXT_NUM","OP"); 			
		   alert(msg);
           obj1.select();
           obj1.focus();
        }
    }


</script>
</head>

<%
	String mode="Insert";
	String queue_id=request.getParameter("queue_id");
	if(queue_id == null) queue_id="";

	Connection conn=null;
	Statement stmt=null;
	ResultSet rset=null;

	String qid="";
	String qdesc="";
	String walk_in="N";
	String appt="N";
	String refer="N";
	int qprefix=0;
	int start=0;
	int next=0;
	int reset=0;
	String enabl="E";
	String ronly="";
	String chkval="";
	String chkval1="";
	String chkval2="";
	String chkval3="checked";
	
	String edis="";
	String eronly="";
				
	if(!queue_id.equals(""))
	{
		mode="Modify";
		ronly="readOnly";

		try
		{
		conn  =  ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		String sql="select QUEUE_ID,QUEUE_DESCRIPTION,WALK_IN_APPL_YN,REFERRAL_APPL_YN,APPT_APPL_YN,QUEUE_PREFIX,START_QUEUE_NUM,NEXT_QUEUE_NUM,RESET_QUEUE_NUM,EFF_STATUS from op_queue_series where queue_id='"+queue_id+"'";
	 		
		rset=stmt.executeQuery(sql);

		if(rset != null)
		{
			if(rset.next())
			{
				 qid=rset.getString("QUEUE_ID");
				 qdesc=rset.getString("QUEUE_DESCRIPTION");
				 walk_in=rset.getString("WALK_IN_APPL_YN");
				 appt=rset.getString("APPT_APPL_YN");
				 refer=rset.getString("REFERRAL_APPL_YN");
				 qprefix=rset.getInt("QUEUE_PREFIX");
				 start=rset.getInt("START_QUEUE_NUM");
				 next=rset.getInt("NEXT_QUEUE_NUM");
				 reset=rset.getInt("RESET_QUEUE_NUM");
				 enabl=rset.getString("EFF_STATUS");
			}
		}

		if(rset != null) rset.close();
		if(stmt != null) stmt.close();

		if(walk_in.equals("Y"))
			chkval="checked";
		else
			chkval="";
		if(appt.equals("Y"))
			chkval1="checked";
		else
			chkval1="";
		if(refer.equals("Y"))
			chkval2="checked";
		else
			chkval2="";
		if(enabl.equals("E"))
			{
			chkval3="checked";
			edis="";
			eronly="";
			}
		else
			{
			chkval3="";
			edis="disabled";
			eronly="readOnly";
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null) ConnectionManager.returnConnection(conn,request);
		}
	}else
	{
		mode="Insert";
		ronly="";
		start=1;
		next=1;
	}
%>

<body onKeyDown='lockKey();'>
<center>
<BR><BR><BR><BR><BR>
<form name='opqueueseries_form' id='opqueueseries_form' action='../../servlet/eOP.OPQSeriesServlet' method='post' target='messageFrame'>
<table border='0' cellpadding='4' cellspacing='0' width='90%'>
<tr>
	<td width="20%" class="label"><fmt:message key="eOP.QueueID.label" bundle="${op_labels}"/></td>
	<td class='fields'>
	<input type='text' name='queue_id' id='queue_id' size=12 maxlength=10 value='<%=qid%>' <%=ronly%> onKeyPress="return CheckForSpecChars(event)">
	<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>	
</tr>

<tr>
	<td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='short_desc' id='short_desc' size=37 maxlength=30 onBlur = 'makeValidString(this)' value="<%=qdesc%>" <%=eronly%> ><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>	
</tr>
</table>
<table border='0' cellpadding='4' cellspacing='0' width='90%'>
	<th class='columnheader' colspan='0' align="left"><fmt:message key="Common.Applicability.label" bundle="${common_labels}"/></th>
</table>
<table border='0' cellpadding='4' cellspacing='0' width='90%'>
<tr>
	<td class='label' width="20%"><fmt:message key="eOP.Walkins.label" bundle="${op_labels}"/></td>
	<td class='fields'><input type='checkbox' name='walk_in' id='walk_in' value='<%=walk_in%>' <%=chkval%> <%=edis%> onClick='clickVal(this);'>
	<td class='label'><fmt:message key="eOP.Referrals.label" bundle="${op_labels}"/></td>
	<td class='fields'><input type='checkbox' name='referrals' id='referrals' <%=edis%> onClick='clickVal(this);' value='<%=refer%>' <%=chkval2%>></td>
	<td class='label'><fmt:message key="Common.Appointments.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='checkbox' name='appts' id='appts' onClick='clickVal(this);' value='<%=appt%>' <%=chkval1%> <%=edis%>><input type='hidden' name='walk_in_yn' id='walk_in_yn' value='<%=walk_in%>'>
	<input type='hidden' name='appt_yn' id='appt_yn' value='<%=appt%>'>
	<input type='hidden' name='ref_yn' id='ref_yn' value='<%=refer%>'></td>
</tr>
<tr>
	<td class='label'><fmt:message key="eOP.QueuePrefix.label" bundle="${op_labels}"/></td>
	<td class='fields'>
	<%
	 if(mode.equals("Modify"))
	 {
	%>
	<input type='text' name='q_prefix' id='q_prefix' size='4' maxlength=4 value='<%=qprefix%>' onKeyPress='return(ChkNumberInput(this,event,0))' <%=eronly%> onBlur='CheckNum(this)'>
	<%}else{%>
	<input type='text' name='q_prefix' id='q_prefix' size='4' maxlength=4 value='' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this)'>
	<%}%>
	<img align='center' src='../../eCommon/images/mandatory.gif'></img>
	<td class='label'><fmt:message key="eOP.NumberStart.label" bundle="${op_labels}"/></td>
	<td class='fields'><input type='text' name='start_queue_num' id='start_queue_num' value='<%=start%>' size='6' maxlength='4' onblur='if(this.value!=""){Numberzero(this)}if(CheckNum(this))checkGrtVal(start_queue_num,reset_queue_num);assign(this.value);' onKeyPress='return(ChkNumberInput(this,event,0))' <%=eronly%>><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
	<td class='label' nowrap><fmt:message key="Common.next.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='next_queue_num' id='next_queue_num' value='<%=next%>' size='6' maxlength='6' readOnly></td>
</tr>
<tr>
	<td class="label"><fmt:message key="eOP.ResetNumber.label" bundle="${op_labels}"/></td>
	<td class='fields' colspan='5'>
	<%if(mode.equals("Modify")){
		if(reset == 0){
		%>
	<input type='text' name='reset_queue_num' id='reset_queue_num' size='6' maxlength='4' value='' onBlur='if(this.value!=""){Numberzero(this)}if(CheckNum(this))checkGrtVal(next_queue_num,reset_queue_num);' onKeyPress='return(ChkNumberInput(this,event));' <%=eronly%>>
		<%}else{%>
	<input type='text' name='reset_queue_num' id='reset_queue_num' size='6' maxlength='4' value='<%=reset%>' onBlur='if(this.value!=""){Numberzero(this)}if(CheckNum(this))checkGrtVal(next_queue_num,reset_queue_num);' onKeyPress='return(ChkNumberInput(this,event));' <%=eronly%>>
		<%}%>
	<%}else{%>
	<input type='text' name='reset_queue_num' id='reset_queue_num' size='6' maxlength='4' value='' onBlur='if(this.value!=""){Numberzero(this)}if(CheckNum(this))checkGrtVal(next_queue_num,reset_queue_num);' onKeyPress='return(ChkNumberInput(this,event));'>
	<%}%>
	</td>		
</tr>        
<tr>
	<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='5'><input type='checkbox' name='enableYN' id='enableYN' <%=chkval3%> value='<%=enabl%>'   onClick='clickVal(this);'></td>	
	<input type='hidden' name='enable_yn' id='enable_yn' value='<%=enabl%>'>
</tr>
</table>
 
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
</form>
</center>
</body>
</html>

