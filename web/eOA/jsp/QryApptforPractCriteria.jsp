
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
	<script language='javascript' src='../../eOA/js/QryApptforPractCriteria.js'></script>
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
	<body onLoad="chgbuttonclr();" OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="QueryLocnForDay" id="QueryLocnForDay">
	<table width='100%' cellspacing='1' cellpadding='0' border='0'>
	 <tr> 
	 <td class="BORDER"> 
	<table cellpadding='0' cellspacing='0' width='100%' align='left'  border='0'>
<%

	sql  = "Select locn_type,short_desc,CARE_LOCN_TYPE_IND , to_char(sysdate,'dd/mm/yyyy') d from am_care_locn_type_lang_vw where sys_user_def_ind='S' and language_id='"+locale+"' and  locn_type in ('C','E','Y')   order by short_desc"; 
	rset = stmt.executeQuery(sql);

	%>
	<tr>
	<td width='8%'  class='label' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<TD class="label"  width='8%'><SELECT name='locationType' id='locationType' onChange='onChangeLocType();locationPopulate(this)' > 
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
	<!--<td width='8%' nowrap><select name='blocation' id='blocation' nowrap onchange='onChangeEvents();checkResource(this)'>
	
	<option value=''>----------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------------------</option>
	</select><img src='../../eCommon/images/mandatory.gif'></img>-->
	<input type="hidden" name="blocation" id="blocation" value="">
		</td>
		</tr>
		<tr>
				<TD class="label" nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></TD>
<!-- Below Code remove Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar -->			
			<TD class="label" nowrap><SELECT name='resource' id='resource' id='res' onchange='return ena_pract()' ><OPTION value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
				  <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
				  <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
				  <OPTION value='R' ><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				 <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
				 </SELECT>	
				</TD>


				 <jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="from_page" value= "query" />
				<jsp:param name ="pract_value" value= "" />
				<jsp:param name ="called_from" value= "appt_for_res" /> 
				</jsp:include>

				<!-- <td  class='Label'nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				<td width='15%' nowrap><input type='text' name='b_pract_name' id='b_pract_name'  disabled size='28' maxlength='30' onblur = "onblurcheck(this,b_pract_name);frameClear();" ><input type='button' name='preact_butt' id='preact_butt' value='?' class='button'  onCLick="callPractSearch(this,b_pract_name);" disabled><input type='hidden' name='bpract' id='bpract' value=''><input type='HIDDEN' name='identityCheckIn' id='identityCheckIn' value=''><img id = 'imgpract' src='../../eCommon/images/mandatory.gif' ></img>
					</td> -->
				
	</tr>

	 <tr>
	 
     <td  class='label' nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>

	<td  nowrap>&nbsp;<input type='text' id='practfrom'  size='12' maxlength='10' name='date' id='date' onBlur="ValidateDate('<%=sysdate%>',this);frameClear();" nowrap><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('practfrom');"><img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		
	<td   class='button' colspan='4' nowrap align='right'>
	<input type="button" class='button' name="select" id="select" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResult()">
		       <input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAll()"></td>
		</tr>
	</table>
	</td>
	 </tr>	 
	</table>
	<table>
		<tr>
		<td class='black'>
		</td>
	</tr>
	</table>
	<input type="hidden" name="fac_id" id="fac_id" value="<%=fac_id%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type='hidden' name='speciality' id='speciality' value=''>
	<script>
	//document.getElementById("imgpract").style.visibility='hidden'
	</script>
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

