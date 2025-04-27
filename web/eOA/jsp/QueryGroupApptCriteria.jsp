<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.text.*,webbeans.eCommon.*" %>
<%

Connection con = null;
Statement stmt   	= null; 
ResultSet rset	   	= null;
request.setCharacterEncoding("UTF-8");
String fac_id    	= (String) session.getValue( "facility_id" ) ;
String locale = (String)session.getAttribute("LOCALE");
%>

<html>
<head>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>	
	<script language='javascript' src="../../eOA/js/QueryGroupApptDtls.js"></script>
	
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
    <script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript">


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body OnMouseDown='CodeArrest(); ' onKeyDown = 'lockKey()' onload='chkmangif()'>
<form name="QueryGroupAppt" id="QueryGroupAppt">
<table cellpadding='0' cellspacing='0' width='100%' border='0'>
    <tr>   
	<td class='label' width='8%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	<TD class='fields' width='8%'><SELECT name='locationType' id='locationType' onChange="javascript:populateLocations(this)"> 
	<option style='align:center'>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
		try{
			con = ConnectionManager.getConnection(request);
		    stmt   	= con.createStatement() ;
			
			String sql		= "" ;
			String sysdate	= "";
			String sysdate1	= "";
			String selected_idval="",loctype="";
			
		String locn_type="";
		String short_desc="";
		sql  = "Select locn_type,short_desc,CARE_LOCN_TYPE_IND , to_char(sysdate,'dd/mm/yyyy') d ,to_char(sysdate+13,'dd/mm/yyyy') sysdate1 from am_care_locn_type_lang_vw where sys_user_def_ind='S' and language_id='"+locale+"' and  locn_type in ('C','E','Y')   order by short_desc"; 
		rset = stmt.executeQuery(sql);

		
		while(rset.next() && rset !=null){
			locn_type=rset.getString("CARE_LOCN_TYPE_IND");
			short_desc=rset.getString("short_desc");
			sysdate=rset.getString(4);
			sysdate1 =rset.getString("sysdate1"); 
			if(locn_type.equals(loctype))
    		selected_idval = "selected";
	        else
			selected_idval = "";
			out.println("<option value='"+locn_type+"'" +selected_idval+">"+short_desc+"</option>");
		}
		sysdate=DateUtils.convertDate(sysdate,"DMY","en",locale);
		sysdate1=DateUtils.convertDate(sysdate1,"DMY","en",locale);
	if(rset !=null) rset.close();
	if(stmt !=null) stmt.close();
%>
	</SELECT>
	</TD>
	<td width='10%'  class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='fields' width='10%'>
	<input type='text' name='b_loc_val' id='b_loc_val' value='' onblur='javascript:populateGroup(this);ena_loc_lookup(this);' size=30 maxlength=30 ><input type='button' value='?' onclick='javascript:populateGroup(this); open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search'>
	<input type="hidden" name="b_loc" id="b_loc" value="">
		</td>
		</tr>
		<tr></tr>
		<br>
		<tr>
		<td class = 'label'  width = '8%' nowrap><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td width='8%' class='fields'>
						<input type="hidden" name="group_id" id="group_id" value="">
						<input type="hidden" name="min_patient" id="min_patient" id="min_patient" >
						<input type="hidden" name="max_patient" id="max_patient" id="max_patient" >	
						<input type="text" name="group_name" id="group_name"  onblur='if(this.value!=""){callgroupname(this,document.forms[0].group_name)}else{clearValues();}'><input type="button" name="group_name_lookup" id="group_name_lookup" value="?" class="button" onclick="callgroupname(this,document.forms[0].group_name)">&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center' ></img>
					</td>
	
		<td  nowrap class=label ><fmt:message key="eOA.ApptDateFrom.label" bundle="${oa_labels}"/></td>	
		<td  class=fields nowrap>
		<input type='text'  name='b_from_date' id='b_from_date' size='8' maxlength='10' Onblur='validate_date_from(this,b_to_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_from_date.select();return showCalendar('b_from_date');" tabindex=-1>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text'  name='b_to_date' id='b_to_date' size='8' maxlength='10' Onblur='validate_date_to(this,b_from_date);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].b_to_date.select();return showCalendar('b_to_date');" tabindex=-1>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		</tr>
	
		<tr><td width='20%'   colspan='4'>&nbsp;</tr>
		<tr><td width='20%'  id="TdLocationResult" colspan='4'></td></tr>
		<tr><td width='20%'   colspan='4'>&nbsp;</tr>
		<tr>
		<td   class='button' colspan='4' nowrap style="text-align:right;">
	<input type="button" class='button' name="select" id="select" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callResult()">
		       <input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearAll()"></td>
		</tr>
		
		</table>
	<input type='hidden' name='sys_date' id='sys_date' value='<%=sysdate%>'></input>	
	<input type='hidden' name='sysdate1' id='sysdate1' value='<%=sysdate1%>'></input>
<%
}catch(Exception es){
	//out.println(es.toString());
	es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally { 
	ConnectionManager.returnConnection(con,request);
}
%> 
	
</body>
</html>

