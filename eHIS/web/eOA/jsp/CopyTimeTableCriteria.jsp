<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*" %>
<%
Connection con=null;
Statement stmt   	= null ;
ResultSet rset	   	= null;
request.setCharacterEncoding("UTF-8");
try{
	con = ConnectionManager.getConnection(request);
stmt   	= con.createStatement() ;
	String fac_id    	= (String) session.getValue( "facility_id" ) ;
	String sql		= "" ;
	String sysdate	= "";
	String locale = (String)session.getAttribute("LOCALE");	
	%>

	<html>
	<head>
	<script language='javascript' src='../../eOA/js/CopyTimeTable.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="CopyTimeTableCriteria" id="CopyTimeTableCriteria">
	<table cellpadding='0' cellspacing='0' width='100%' align='left'  border='0'>
<%

	sql  = "Select locn_type,short_desc,CARE_LOCN_TYPE_IND , to_char(sysdate,'dd/mm/yyyy') d from am_care_locn_type_lang_vw where sys_user_def_ind='S' and language_id='"+locale+"' and  locn_type in ('C','E','Y')   order by short_desc"; 
	rset = stmt.executeQuery(sql);

	%>
	<tr>
	<td width='8%'  class='label' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<TD class="label"  width='8%'><SELECT name='locationType' id='locationType' onChange='locationPopulate(this)' > 
	<option style='align:center'>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
		String locn_type="";
		String short_desc="";
		
		while(rset.next() && rset !=null){
			locn_type=rset.getString("CARE_LOCN_TYPE_IND");
			short_desc=rset.getString("short_desc");
			sysdate=rset.getString("d");
			%>
			<option value='<%=locn_type%>|<%=short_desc%>'><%=short_desc%>
			<%
		}
	%>

	</SELECT> 
	</TD>
	<td width='8%'  class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='fields' width='8%'>
	<input type='text' name='b_loc_val' id='b_loc_val' value='' onblur='ena_loc_lookup(this);' size=30 maxlength=30 ><input type='button' value='?' onclick='open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search'>
	<input type="hidden" name="blocation" id="blocation" value="">
		</td>
		<td class = 'label'  width = '8%' ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
	<td width = '8%' >
	<select name='Time_Table_Details' id='Time_Table_Details' onChange = 'TimeTableDetails(this)'><option value = "">------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</option>
  </select>
		</tr>	
	</table>
	<input type="hidden" name="fac_id" id="fac_id" value="<%=fac_id%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type='hidden' name='speciality' id='speciality' value=''>
	
	</form>
	<%
	if(rset !=null) rset.close();
	if(stmt !=null) stmt.close();

}catch(Exception es){
	//out.println(es.toString());
	es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
<script>document.forms[0].locationType.focus();</script>

</body>
</html>

