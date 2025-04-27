<!DOCTYPE html>
  
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eOA/js/GenerateSchedule.js' language='javascript'></SCRIPT>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String clinictype = request.getParameter("clinic_type");
String selIndex=request.getParameter("selIndex");
Connection con = null;
Statement stmt=null;
ResultSet rset=null ;

//java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );


String day_1="";
String day_2="";
String day_3="";
String day_4="";
String day_5="";
String day_6="";
String day_7="";

//String facilityId = (String) session.getValue( "facility_id" ) ;
//facilityId = "ragha";
//String fid=p.getProperty( "login_user" ) ;

String currentdate ="";
//String oper_stn_access_rule="";

String sql="";
//Statement stsql1=null;
//ResultSet rssql1=null ;
//Statement stsql2=null;
//ResultSet rssql2=null ;

String locale = (String)session.getAttribute("LOCALE");

String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

if(clinictype == null) clinictype="";

try{
	con = ConnectionManager.getConnection(request);

%>

	</head>

	<body onLoad="chgbuttonclr();" OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name='GenerateSchedule_form' id='GenerateSchedule_form' action='../../servlet/eOA.GenerateScheduleServlet' method='post' target='messageFrame'>

		<div>
		<table border='0' cellpadding='0' cellspacing='0' align='center' width='80%'>
		<tr width='100%' ><td colspan='6'>&nbsp;</td></tr>

		<tr>    
			<TD class="label"  width='25%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></TD>
			<TD class="fields"  >
		<%
		 //sql="select locn_type, short_desc, CARE_LOCN_TYPE_IND, to_char(sysdate,'dd/mm/yyyy') sys_date from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') and language_id = '"+locale+"' order by short_desc";
		sql="select locn_type, am_get_desc.am_care_locn_type(locn_type,'"+locale+"',2) short_desc, CARE_LOCN_TYPE_IND, to_char(sysdate,'dd/mm/yyyy') sys_date from am_care_locn_type where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') order by short_desc";
		 
		  stmt=con.createStatement();
		  rset = stmt.executeQuery(sql);
				
		%>
		<SELECT name='locationType' id='locationType' onChange='clearDetail1(this);' tabindex=1 > 
		<option style='align:center'>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
		
		<%
		String locn_type="";
		String short_desc="";

		while(rset.next() && rset !=null){
			locn_type=rset.getString("CARE_LOCN_TYPE_IND");
			short_desc=rset.getString("short_desc");
			currentdate = rset.getString("sys_date");
			out.println("<option value='"+locn_type+"'>"+short_desc);
		}
		if(rset !=null) rset.close();%>

		</SELECT>
		</TD>
 
	 <td width='8%' class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='4'>
	<input type='text' size='25' tabindex=3 maxlength='25' name='b_loc_val' id='b_loc_val' value='' onblur="ena_loc_lookup(this);">
	<input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button' tabindex=4>
	</select><img src='../../eCommon/images/mandatory.gif'></img>
	<input type="hidden" name="clinic" id="clinic" value="">
		</td>
		</tr>

		<tr width='100%' ><td colspan='6'>&nbsp;</td></tr>

		<tr>
			<input type='hidden' name='dutyRosterCount' id='dutyRosterCount' value=''>
			<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>

			<td  class=label><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
			<input type='text' tabindex=5 id='schedulefrom' name='eff_from' id='eff_from' size='10' maxlength='10' value=''  onChange='clearDetail()' onBlur="validate_date_from(this,'<%=currentdate%>');compare_from(this,eff_to);" ><img  style="cursor:pointer"  src="../../eCommon/images/CommonCalendar.gif" tabindex=6 onClick="document.forms[0].eff_from.select(); return showCalendar('schedulefrom');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<input type='hidden' name='eff_from_date' id='eff_from_date' size='10' maxlength='10' value=''></td>

			<td class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>

			<td class='fields' colspan='4'>
			<input type='text' tabindex=7  name='eff_to' id='eff_to' size='10' maxlength='10' value=""  onChange='clearDetail()' onBlur="validate_date_to(this,eff_from);"><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" tabindex=8 onClick="document.forms[0].eff_to.select();return showCalendar('eff_to'); " ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<input type='hidden' name='eff_to_date' id='eff_to_date' size='10' maxlength='10' value="">
			
			</td>

			</tr>
			

			<tr><td colspan=6 ><p id='info'>&nbsp;</p></td></tr>

			<tr>
			<%/*below line commented for this CRF [AMRI-CRF-0236]*/%>
			<td  class=label nowrap ><fmt:message key="eOA.AllResources.label" bundle="${oa_labels}"/></td>

			<td  class=fields><input type='checkbox' name='all_practitioners' id='all_practitioners' disabled  value=''  onClick="PractDetails(this)"></td>
           <% //End CRF [AMRI-CRF-0236]%>
			<td  class='label' colspan='3'>&nbsp;</td>

			<td class='button' align='right'><input type='button' name='generate' id='generate'  onclick="generate_schedule()" value='<fmt:message key="Common.Generate.label" bundle="${common_labels}"/>' class = 'button' disabled></td>
			</tr>
		</table>
		</div>
		<input type='hidden' name='no_days' id='no_days' value='' >
		<input type='hidden' name='con_days' id='con_days' value='' >
		<input type='hidden' name='P_pract_null' id='P_pract_null' value='' >

		<%
			rset=stmt.executeQuery("select substr(day_of_week,1,3) week_day,day_no from sm_day_of_week order by day_no");

			while(rset.next()){

				switch(rset.getInt("day_no")){

					case 1:		day_1 = rset.getString("week_day");
							break;
					case 2:		day_2 = rset.getString("week_day");
							break;
					case 3:		day_3 = rset.getString("week_day");
							break;
					case 4:		day_4 = rset.getString("week_day");
							break;
					case 5:		day_5 = rset.getString("week_day");
							break;
					case 6:		day_6 = rset.getString("week_day");
							break;
					case 7:		day_7 = rset.getString("week_day");
							break;
				}
			}

		%>
		<input type='hidden' name='wday_1' id='wday_1' value='<%=day_1%>' >
		<input type='hidden' name='wday_2' id='wday_2' value='<%=day_2%>' >
		<input type='hidden' name='wday_3' id='wday_3' value='<%=day_3%>' >
		<input type='hidden' name='wday_4' id='wday_4' value='<%=day_4%>' >
		<input type='hidden' name='wday_5' id='wday_5' value='<%=day_5%>' >
		<input type='hidden' name='wday_6' id='wday_6' value='<%=day_6%>' >
		<input type='hidden' name='wday_7' id='wday_7' value='<%=day_7%>' >
		<input type='hidden' name='default_select' id='default_select' value='<%=default_select%>'>
<%/*Below Line  Added for this CRF [AMRI-CRF-0236]*/%>	
<!--<input name='chkvalue' id='chkvalue' type='hidden' value =''>-->
		

		<%
		if(rset!=null)	rset.close();
		//if(rssql1!=null)	rssql1.close();
		//if(rssql2!=null)	rssql2.close();

		if(stmt!=null)	stmt.close();
		//if(stsql1!=null)	stsql1.close();
		//if(stsql2!=null)	stsql2.close();
	}catch(Exception e){
		e.printStackTrace();
		//out.println(e.toString());
	}finally{
		 if(con!=null)  ConnectionManager.returnConnection(con,request);
	}%>

	</form>
</body>
<script>
document.forms[0].locationType.focus();
var sel=<%=selIndex%>;

if (sel!=null && sel!=""){
	document.forms[0].locationType.options.selectedIndex=sel;
}
</script>

</html>

