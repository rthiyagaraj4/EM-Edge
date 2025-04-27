<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,webbeans.eCommon.*" %>


<head>
   <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
    -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css'   href='../../eCommon/html/CommonCalendar.css'></link>
   <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
   <script language='javascript' src='../../eCommon/js/common.js'></script>
   <script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
	<script language="javascript" src="../../eCommon/js/dchk.js"> </script>
   <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
   <script language='javascript' src='../../eOA/js/QueryBlockAppt.js'></script>
   <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
   <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
    Connection con = null;
    Statement stmt		= null;
	Statement stmt2		= null;
	Statement stmt1		= null;
	ResultSet rs		= null;
	ResultSet rset		= null;
    ResultSet rs2		= null;
	
try {
	String locale = (String)session.getAttribute("LOCALE");	
	con = ConnectionManager.getConnection(request);	
	String sqlSpl = "";
	%>

	<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()' onload='disableFields()'>
  <form name='query_search_form' id='query_search_form'>
    <div>
  <table width = '100%' cellspacing='0' cellpadding='0' border='0' align='center'>

   <tr>

			<td  class='label' width='25%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td> 
			<%
		
		     sqlSpl="select short_desc, speciality_code from am_speciality_lang_vw where eff_status = 'E' and language_id='"+locale+"' order by short_desc" ;
			 stmt1 = con.createStatement();
 
			 rset = stmt1.executeQuery(sqlSpl);

			%>
			<td class='fields' width='25%'>
						
					<select name="speciality" id="speciality" onchange='locn_change()' > 
					<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
					<%
					while(rset.next()){
						out.println("<option value='" + rset.getString("speciality_code") + "' >" + rset.getString("short_desc")+"</option>");
					}
						if(rset !=null) rset.close();
						if(stmt1 !=null) stmt1.close();
					%>
					</select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
         <td  class='label'nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

         <td  class='fields'>
				  <select name='location1' id='location1'  onChange = 'locationreturn(this)'>
				  <option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
			<%
			 String sql="";
             sql = "select locn_type,short_desc,CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and language_id='"+locale+"' and locn_type in ('C','E','Y')  order by short_desc";
             stmt = con.createStatement();
             rs = stmt.executeQuery(sql);
			 String locn_type="";
			 String short_desc1="";
             if (rs != null) {
             	while( rs.next() ) {
            	   locn_type=rs.getString("CARE_LOCN_TYPE_IND");
				   short_desc1=rs.getString("short_desc");
				   %>
				<option value='<%=locn_type%>'><%=short_desc1%>
				<% }
				 }%>
				 </select></td>
				 </tr><tr>

			<td  class='label'nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
         
			<!--<td  class='fields' nowrap><SELECT name='location' id='location' nowrap onChange='enablepr(this);validateTbs();'>
			 <OPTION value=''  style='align:center'>----------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------------------
			 </SELECT><img src="../../eCommon/images/mandatory.gif"     align='center'></img>-->
			 <td class="fields"><input type='text' name='b_loc_val' id='b_loc_val' value='' onblur='ena_loc_lookup(this);' size=30 maxlength=30 ><input type='button' value='?' onclick='open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search'><!--<img src='../../eCommon/images/mandatory.gif'></img> -->
			 <input type='hidden' name='location' id='location' value=''></td>

			
			<td  class='label'nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td> 

			<td  class='fields'><SELECT name='resource' id='resource'  onchange='practValidate();' onblur='resourceOnBlur();' disabled>
				  <OPTION value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
				  <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
				  <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
				  <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				  <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
				 </SELECT>

</tr><tr>
			 <jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
			 <jsp:param name ="from_page" value= "query" />
			 <jsp:param name ="pract_value" value= "" />
			 </jsp:include>

			<!-- <td  class='Label'nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				
			<td  class='fields'nowrap><input type="text" name="pract_name" id="pract_name" disabled onblur = "onblurcheck(this,pract_name,document.forms[0].resourceType)"size="25" maxlength="30" ><input type="button" name="preact_butt" id="preact_butt" value="?" disabled class="button" onCLick="callPractSearch(this,pract_name,document.forms[0].resourceType);"><input type="hidden" value="" name="practitioner" id="practitioner">
  
			</td> -->
 
         <td  class='label' nowrap><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
        
		 <td class=fields>
			
			<select name='day' id='day' >
			<option value='' >-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------</option>
			
			<%
             String sql2="";
             sql2 = "select day_no, INITCAP(day_of_week) day_of_week from sm_day_of_week order by 1";
             stmt2= con.createStatement();
             rs2= stmt2.executeQuery(sql2);

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


            	     out.println("<option value ='" + day_no + "' > " + day_desc );
                }
             }
			%>
			</select></td>

</tr>
<tr>
         <td  class='label'><fmt:message key="eOA.BlockDate.label" bundle="${oa_labels}"/></td>
         <td class='fields' >
           <input type='text' id='schedulefrom' size='10' maxlength='10' name='from_date' id='from_date' value='' title='Date From' Onblur='ValidateDate_from(this,to_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('schedulefrom');">&nbsp;&nbsp;-&nbsp;&nbsp;<input type='text' id='scheduleto' size='10' maxlength='10' name='to_date' id='to_date' value='' title='Date To' Onblur='ValidateDate_to(this,from_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('scheduleto');" Onblur="document.forms[0].to_date.focus();">                     
         </td>
  		<td class='button' colspan='2' align='right'><input type='button' name='select' id='select' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  class='Button' onclick = 'select_click()'>&nbsp;<input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  class='Button' onclick = 'clear_click()'>
			</td>
 </tr>

	<input type="hidden" name="locale" id="locale" value="<%=locale%>">

     </table>
    </div>
 <%
	  if (rs	!=null)	rs.close();
      if (rs2	!=null)	rs2.close();
      if (stmt	!=null)	stmt.close();
      if (stmt2	!=null)	stmt2.close();

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

