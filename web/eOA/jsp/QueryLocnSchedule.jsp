<!DOCTYPE html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,webbeans.eCommon.*" %>

<head>
   <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

   <link rel='stylesheet' type='text/css'   href='../../eCommon/html/CommonCalendar.css'></link>
   <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
   <script language='javascript' src='../../eCommon/js/common.js'></script>
   <script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
   <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
   <script language="javascript" src="../../eOA/js/QueryLocnSchedule.js"></script>
   <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
   <Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
   


</head>
<%

    Connection con = null;	
	Statement stmt		= null;
	Statement stmt1		= null;
    Statement stmt2		= null;
	ResultSet rs		= null;
    ResultSet rs2		= null;
    ResultSet rset		= null;
try {
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);		
	String locale = (String)session.getAttribute("LOCALE");
	String sqlSpl ="";
	
		
 %>

<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()' onload='chkmangif()'>
  <form name='query_search_form' id='query_search_form'>
    <div>
     <table width = '100%' cellspacing='0' cellpadding='0' border ='0' align='center'>
       
	<tr>


							<td  class='label' width='25%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td> 
			<%
		
		     sqlSpl="select short_desc, speciality_code from am_speciality_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by short_desc" ;
			 stmt1 = con.createStatement();
			 rset = stmt1.executeQuery(sqlSpl);

			%>
			<td class='fields' width='25%'>
						
					<select name="speciality" id="speciality"  onchange='locn_change()' style="width:71%"> 
					<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
					<%
					while(rset.next()){
						out.println("<option value='" + rset.getString("speciality_code") + "' >" + rset.getString("short_desc")+"</option>");
					}
						if(rset !=null) rset.close();
						if(stmt1 !=null) stmt1.close();
					%>
					</select><img src="../../eCommon/images/mandatory.gif"     align='center'></img></td>
				<td  class='label' width='25%' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
				<td  class='fields' width='25%' >
				   <select name='location1' id='location1' onChange = 'locationreturn(this);frameClear();' style="width:130">
					 <option value='' >&nbsp;-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------&nbsp;</option>
					<%
					
					String sql="";
					 sql = "select locn_type,short_desc,CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') and language_id='"+locale+"' order by short_desc";

					 stmt = con.createStatement();
					 rs = stmt.executeQuery(sql);
					 String locn_type="";
					 String short_desc1="";
					 if (rs != null) {
						while( rs.next() ) {
							locn_type =rs.getString("CARE_LOCN_TYPE_IND");
							short_desc1 =rs.getString("short_desc");
							
							%>
								<option value='<%=locn_type%>|<%=locn_type%>'><%=short_desc1%>
								<%
						}
					 }
					%>
				   </select>
				   </td>


</tr><tr>
				<td  class='label' width='25%'  nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td  class='fields' width='25%' >

				 <input type='text' name='b_loc_val' id='b_loc_val' size='25' maxlength='25' value='' onBlur="ena_loc_lookup(this);"><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup()" class='button' >
				<input type="hidden" name="location" id="location"  id='loc' value=""> 

			   
				  <!-- <SELECT name='location' id='location' id='loc' onChange='enablepr(this);validateTbs();' >
				 <OPTION value=''  style='align:center'>&nbsp;&nbsp;----------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------------------&nbsp;&nbsp;
				 
				 </SELECT>  -->
				 <img src="../../eCommon/images/mandatory.gif"     align='center'></img></td>
					 

				 <td class='label' width='25%' ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				 <td  class='fields' width='25%' >	 
					<SELECT name='resource' id='resource' id='res'  onchange='practValidate();' onblur='resourceOnBlur();'  disabled>
				  <OPTION value=''>&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;
				  <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
				  <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
				  <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				  <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
				 </SELECT></td>

</tr><tr>
				 <jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
				 <jsp:param name ="from_page" value= "query" />
				 <jsp:param name ="pract_value" value= "" />
				 </jsp:include>


			    <!-- <td class='label' width='25%' ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				<td  class='fields' width='25%' >	
				<input type="text" name="b_pract_name" id="b_pract_name" onblur = "onblurcheck(this,b_pract_name,document.forms[0].resourceType)" size="25" maxlength="30" disabled><input type="button" name="preact_butt" id="preact_butt" value="?" disabled class="button" onCLick="callPractSearch(this,b_pract_name,document.forms[0].resourceType);"><input type="hidden" value="" name="practitioner" id="practitioner">
				 </td> -->

			 <td class='label' nowrap><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
			 <td class='fields' width='20%'>
				  <select name='day' id='day' onchange='changeDay();'>
				   <option value='' >&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------&nbsp;</option>
					<%
					 String sql2="";
					 sql2 = "select day_no, INITCAP(day_of_week) day_of_week from sm_day_of_week order by 1";
					 stmt2= con.createStatement();
					 rs2= stmt.executeQuery(sql2);

					 String day_no 	= "" ;
					 String day_desc	= "" ;

					 if (rs2 != null) {
						while( rs2.next() ) {
							day_no	= rs2.getString("day_no") ;
							day_desc= rs2.getString("day_of_week") ;

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
							<option value ='<%=day_no%>' ><%=day_desc%>
						<%
						}
					 }
					 %>
					</select></td>
<td/><td/>

</tr>

			 
	<tr>
	   <td class='label' ><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
	   <td class='fields'  >
		 <input type='text' id='schedulefrom' size='10' maxlength='10' name='from_date' id='from_date' value='' title='Date From' Onblur='ValidateDate_from(this,to_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('schedulefrom');">&nbsp;-&nbsp;<input type='text' id='scheduleto' size='10' maxlength='10' name='to_date' id='to_date' value='' title='Date To' Onblur='ValidateDate_to(this,from_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('scheduleto');" Onblur="document.forms[0].to_date.focus();"></td>
		 <td class='button' colspan=2 align='right'>
		 <input type='button' name='select' id='select' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  class='Button' onclick = 'select_click()'>&nbsp;
		 <input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  class='Button' onclick = 'clear_click()'>
		</td>
     </tr>
	 <input type="hidden" name=locale value="<%=locale%>">

				
     </table>
    </div>
 <%
	if (rs2!=null) rs2.close();
	if (rs!=null) rs.close();
	if (stmt2!=null) stmt2.close();
	if (stmt!=null) stmt.close();



} catch(Exception e) {
     // out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally {
	  ConnectionManager.returnConnection(con,request);
}
 %>
 </form>
</body><script>document.forms[0].location1.focus();</script>
</html>


