<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.text.*,webbeans.eCommon.*" %>
<%

Connection con = null;

Statement stmt   	= null;
Statement stmt1   	= null;
ResultSet rs	   	= null;
ResultSet rset		= null;
request.setCharacterEncoding("UTF-8");

try{
	con = ConnectionManager.getConnection(request);

 stmt			 	= con.createStatement() ;
 stmt1			 	= con.createStatement() ;
String fac_id    	= (String) session.getValue( "facility_id" ) ;
String locale = (String)session.getAttribute("LOCALE");


String sql		    = "" ;
String sqlSpl		= "" ;

%>

<html>
<head>
	<script language='javascript' src="../../eOA/js/QueryLocnForDay.js"></script>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
    <script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript">


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body OnMouseDown='CodeArrest(); ' onKeyDown = 'lockKey()' onload='chkmangif()'>
<form name="QueryLocnForDay" id="QueryLocnForDay">
<table cellpadding='0' cellspacing='0' width='100%' border='0'>
         
		<tr>
				
		<td  class='label' width='25%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td> 
			<%
		
		     sqlSpl="select short_desc, speciality_code from am_speciality_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by short_desc" ;
			 
			 rset = stmt1.executeQuery(sqlSpl);

			%>
			<td class='fields' width='25%'>
						
					<select name="speciality" id="speciality"  onchange='locn_change()'> 
					<option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
					<%
					while(rset.next()){
						out.println("<option value='" + rset.getString("speciality_code") + "' >" + rset.getString("short_desc")+"</option>");
					}
						if(rset !=null) rset.close();
						if(stmt1 !=null) stmt1.close();
					%>
					</select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
<td width='25%' class='label' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
				<TD class="fields"  width='25%' >
						<%
					
					 sql  = "Select locn_type,short_desc,CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where language_id='"+locale+"' and locn_type in ('C','E','Y')   order by short_desc"; 				
					 rset = stmt.executeQuery(sql);
					
							%>
					<SELECT name='locationType' id='locationType' onChange='javascript:populateLocations(this);frameClear();' > 
					<option style='align:center' value=''>&nbsp;&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------&nbsp;&nbsp;
													
					<%

					String short_desc="";
					String care_locn="";
					while(rset.next() && rset !=null){

						short_desc=rset.getString("short_desc"); 
						care_locn=rset.getString("CARE_LOCN_TYPE_IND");
						%>
						<option value='<%=care_locn%>|<%=care_locn%>'><%=short_desc%>

					<%	}
					%>

					</SELECT></TD>

</tr>
<tr>
					
				<td width='25%' class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td width='25%' class='fields' nowrap>


				<input type='text' name='b_loc_val' id='b_loc_val' size='25' maxlength='25' value='' onBlur="ena_loc_lookup(this);"><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup()" class='button' >
				<input type="hidden" name="blocation" id="blocation" value="">

					<!-- <select name='blocation' id='blocation' nowrap onchange='onChangeEvents();'>
			
					<option value=''>&nbsp;-----------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------&nbsp;</option>
					</select> --><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
					<td width='25%' class='label'><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
				<td  class='fields' width='25%' >
					<select name='bday' id='bday' onChange='clearFrame2();'>
					 <option value=''>&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
						<%
						sql = "select day_no,INITCAP(day_of_week) day_of_week from sm_day_of_week order by 1 " ;
						   rs  = stmt.executeQuery( sql ) ;

						   String day_no 	= "" ;
						   String day_desc	= "" ;

						   if (rs != null)
						   {
							while (rs.next())
							{
								day_no	= rs.getString("day_no") ;
								day_desc= rs.getString("day_of_week") ;
								
								if(day_desc.equals("Monday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(day_desc.equals("Tuesday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(day_desc.equals("Wednesday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(day_desc.equals("Thursday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(day_desc.equals("Friday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(day_desc.equals("Saturday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(day_desc.equals("Sunday"))
								{
									day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}


								%>
								<option value='<%=day_no%>' ><%=day_desc%>
											<%
								}
							   }

							   rs.close() ;

							%>
					</select></td>
			</tr>
			<tr>
					
					<TD class="label" width='25%' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/> </TD>
					<TD class="fields" width='25%'>
						 <SELECT name='resource' id='resource' id='res' onchange='ena_pract()'  disabled>
						  <OPTION value=''>&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
						  <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
						  <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
						  <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
						  <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
						 </SELECT></TD>


					<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "query" />
					<jsp:param name ="pract_value" value= "" />
					</jsp:include>

					<!-- <TD class="label" width='25%' nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/> </TD>
					<td width='25%' nowrap>
					<input type='text' name='b_pract_name' id='b_pract_name' disabled size='30' maxlength='30' onblur = "onblurcheck(this,b_pract_name);clearDaySel();"><input type='button' name='preact_butt' id='preact_butt' value='?' class='button'  onCLick="callPractSearch(this,b_pract_name);" disabled><input type='hidden' name='bpract' id='bpract' value=''></td> -->
		
			</tr>

			<tr>
				
				<td class='label'></td>
				<td  class='button' colspan='4' align='right'>
		       <input type='button' class='button' name='select' id='select' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResult()">
		       <input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAll()"></td>

			</tr>
</table>
<input type=hidden name="fac_id" id="fac_id" value="<%=fac_id%>">
<input type=hidden name="locale" id="locale" value="<%=locale%>">

<%
	if(rs	  !=null) rs.close();
	if(rset !=null) rset.close();
	if(stmt   !=null) stmt.close();

}catch(Exception es){
	//out.println(es.toString());
	es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
	ConnectionManager.returnConnection(con,request);
}
			
%>

</body><script>document.forms[0].locationType.focus();</script>
</html>

