<!DOCTYPE html>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="PositionForIntervention" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function submitPrevNext(from, to)
{
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
}

function selectAll(Obj,start,end)
{
	if(Obj.checked)
	{
	for(var i=start;i<=end;i++)
	{
	if(eval("document.forms[0].chk"+i))
		eval("document.forms[0].chk"+i).checked=true;
	}
		var  role_type = document.forms[0].role_type.value;
		var  staff_type = document.forms[0].staff_type.value;
		var  position_code = document.forms[0].position_code.value;

		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='PositionForInterventionDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='role_type' id='role_type' value='"+role_type+"'><input type='hidden' name='staff_type' id='staff_type' value='"+staff_type+"'><input type='hidden' name='position_code' id='position_code' value='"+position_code+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	}
	else
	{
		for(var i=start;i<=end;i++)
			{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
			}
	
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='PositionForInterventionDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	}
}

function chkForSelectAll(start,end)
{
	if(parent.frames[2].document.forms[0].E.value == 'selectAll')
	{
		alert("selectall");
	document.forms[0].chkAll.checked=true;
	selectAll(document.forms[0].chkAll,start,end)
	}
}
</script>
<%
String  req_start   =   "", req_end     =   "";
String  checkedOnes         =   "";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
int maxRecord = 0;
int start = 0 ;
int end = 0 ;
int i=1;
if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
req_start = (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
req_end = (request.getParameter("end")==null)?"0":request.getParameter("end");

String effStatus="";
String sqlinsVals="";

effStatus=request.getParameter("effStatus");
if(effStatus == null) effStatus="";

Connection con = null;

PreparedStatement stmt3 = null;
ResultSet rstlRs3 = null;

PreparedStatement stmt=null;
ResultSet rs=null ;

try
{
	con = ConnectionManager.getConnection(request);
	String intervention_code="";
	String position_code="";
	String role_type=request.getParameter("role_type");
	String staff_type=request.getParameter("staff_type");
    position_code=request.getParameter("position_code");
	intervention_code=request.getParameter("intervention_code");
	String flagSelect = request.getParameter("fromSearch");
	if(flagSelect !=null)
	{
		PositionForIntervention.clearAll();
		sqlinsVals= "select intervention_code from ca_intervention_for_posn  where position_code = ? and role_type = ? and staff_type = trim(?) ";
		stmt3=con.prepareStatement(sqlinsVals);
        stmt3.setString(1,position_code);
        stmt3.setString(2,role_type);
        stmt3.setString(3,staff_type);
		rstlRs3 = stmt3.executeQuery();
		if(rstlRs3 !=null)
		{
			while(rstlRs3.next())
			{
				PositionForIntervention.putObject(rstlRs3.getString(1));
			}
		}
	}
	if(from != null && to != null)
	{
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		{
			if(request.getParameter("chk"+(i)) != null)
			{
				checkedOnes = request.getParameter("chk"+(i));
				if(!(PositionForIntervention.containsObject(checkedOnes)))
					PositionForIntervention.putObject(checkedOnes);
				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
	i = 1 ;
	String classValue="";
	String chkAttribute="";
	//String sql  = "select intervention_code, short_desc intervention_desc,'I' db_action from ca_intervention where intervention_code not in (select intervention_code from ca_intervention_for_posn where position_code = ? and role_type = ?  and staff_type = ? ) and eff_status = 'E' union all select a.intervention_code intervention_code, b.short_desc intervention_desc, 'U' db_action from ca_intervention_for_posn a, ca_intervention b where a.position_code = ? and a.role_type =?  and a.staff_type = ? and b.intervention_code  = a.intervention_code order by 2";
	String sql  = "SELECT intervention_code, short_desc intervention_desc,'I' db_action FROM ca_intervention_lang_vw WHERE intervention_code NOT IN (SELECT intervention_code FROM ca_intervention_for_posn WHERE position_code = ? AND role_type = ?  AND staff_type = ? ) AND eff_status = 'E' and language_id = ? UNION ALL SELECT a.intervention_code intervention_code, b.short_desc intervention_desc, 'U' db_action FROM ca_intervention_for_posn a, ca_intervention_lang_vw b WHERE a.position_code = ? AND a.role_type =?  AND a.staff_type = ? AND b.intervention_code  = a.intervention_code and b.language_id = ? ORDER BY 2";
	try
	{
		stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt.setString(1,position_code);
		stmt.setString(2,role_type);
		stmt.setString(3,staff_type);
		stmt.setString(4,locale);
		stmt.setString(5,position_code);
		stmt.setString(6,role_type);
		stmt.setString(7,staff_type);
		stmt.setString(8,locale);
		rs=stmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
	}
	catch(Exception e)
	{
		out.println(e);
	}

%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' onKeyDown="lockKey()" class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eCP/jsp/PositionForInterventionDetail.jsp' method='post' >
<table  width='90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='role_type' id='role_type' value='<%=role_type%>'>
<input type=hidden name='staff_type' id='staff_type' value='<%=staff_type%>'>
<input type=hidden name='position_code' id='position_code' value='<%=position_code%>'>
<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='allValues' id='allValues' value=''>
<%
    if ( !(start <= 1)) {
%>
    <a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
    }
    if ( !((start+12) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
	<th width='60%'><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></th>
	<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
<%	 
	if (start != 0)
	{
		for(int j=1; j<=start; i++,j++)
		{
		rs.next() ;
		}
	}
    int recordIndex=0;
	String intervention_desc = "";
	while(rs.next() && i<=end)
	{ 
        intervention_code=rs.getString("intervention_code");
		intervention_desc=rs.getString("intervention_desc");
		if(PositionForIntervention.containsObject(intervention_code)) 
			chkAttribute = "CHECKED";
		else
			chkAttribute="";
		recordIndex = PositionForIntervention.indexOfObject(intervention_code);
		if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED")) PositionForIntervention.removeObject(recordIndex);
		if( i%2 == 0)  
		classValue="QRYEVEN";
		else
		classValue="QRYODD";
%>
	<tr>
		<td class='<%=classValue%>'><%=intervention_desc%></td>
		<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=intervention_code%>'> </td>
	</tr>
			<%
		i++;
	}		
 }
catch(Exception e)
{
	out.println(e);
}
finally
{
	// Added on 25/07/2003 for closing ResultSet & Statements which are not closed Properly.
	if(rs != null) rs.close(); 
	if(rstlRs3 != null) rstlRs3.close(); 
	if(stmt != null) stmt.close(); 
	if(stmt3 != null) stmt3.close();
	// End of Addition on 25/07/2003 for closing ResultSet & Statements which are not closed properly.
	if(con != null)
		ConnectionManager.returnConnection(con,request);
	session.setAttribute("PositionForIntervention", PositionForIntervention);
}
%>
</table>
</form>
</body>
</html>








