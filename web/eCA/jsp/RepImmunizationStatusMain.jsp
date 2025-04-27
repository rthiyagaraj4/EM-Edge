<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String p_facility_id = (String)session.getValue("facility_id");
	String p_login_user  = (String)session.getValue("login_user");
	String p_outcome_type					=		request.getParameter("p_outcome_type")==null ? "":request.getParameter("p_outcome_type");
	if(p_facility_id == null)p_facility_id="";
	if(p_login_user == null)p_login_user="";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String style_auto= "display";	
	String currentMonthYear = com.ehis.util.DateUtils.getCurrentDate("MY",locale);	
	//String style_auto="dispaly:inline";
	Connection con=null;
	PreparedStatement pstmt=null;
    //PreparedStatement pstmt=null,pstmt1=null;
    ResultSet rs=null;
	con =	ConnectionManager.getConnection(request);
	

%>
<html>
<head><title></title>
<%

String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src="../../eCA/js/RepImmunizationStatus.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language="javascript" >
function showCalendarValidate(str){
		var flg = showCalendar(str);
		document.getElementById(str).focus();
		return flg;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onLoad='SelectRadio()'>
<form name='repImmunizationStatus' id='repImmunizationStatus' action="../../eCommon/jsp/report_options.jsp" target="messageFrame" >
<br><br><br><br>
<table width='80%' align='center' valign='top' cellpadding='3'>

		<th class='columnheader' ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
<tr>
    <td width="100%" class="Border" align='center'> 

		<table border=0 width='80%' cellPadding="3" cellSpacing="0"  align='center' >
				        <tr>
			            <td  width="20%"  align=left class="label"><fmt:message key="Common.ReportOptions.label" bundle="${common_labels}"/></td>
                        <td colspan=1 class="label">&nbsp;&nbsp;
		                <input type='radio' name='p_outcome_type' id='p_outcome_type' value='M' onclick ='Change_mode(this)'><fmt:message key="eCA.ForAMonth.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		                <input type='radio' name='p_outcome_type' id='p_outcome_type' value='R' onclick='Change_mode(this)'><fmt:message key="eCA.ForAPeriodRange.label" bundle="${ca_labels}"/> 
						<!-- <input type="hidden" name="p_type" id="p_type" value="A"> -->
						</td>
						</tr>


                       <tr id='referralrow' style="<%=style_auto%>">
					   <td  colspan=1 class="label"><fmt:message key="Common.periodfrom.label"bundle="${common_labels}"/></td><td class="fields"><input type=textbox size=11 maxlength=10 name='p_frmDate' id='p_frmDate' onblur='Check_Date(this,"DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="document.forms[0].p_toDate.select();return showCalendarValidate('p_frmDate');"  ><img src='../../eCommon/images/mandatory.gif'></img></td>
					   <td td width='25%'  class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					   <td class="fields"><input type=textbox size=11 maxlength=10 name='p_toDate' id='p_toDate' onblur='return checkingDate(this,"DMY","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="document.forms[0].p_toDate.select();return showCalendarValidate('p_toDate');" ><img src='../../eCommon/images/mandatory.gif'></img></td>
					   </tr>
						<!--size=11 maxlength=10 name=p_toMonth value = "02/2008"  -->
					   <tr id='notreferral' style="<%=style_auto%> ; color:black">
					   <td  colspan=1 class="label"><fmt:message key="Common.month.label" bundle="${common_labels}"/></td><td class='fields'><input type=textbox size=11 maxlength=10 name=p_toMonth value ="<%=currentMonthYear%>"
					   onblur='DateChk(this);'>(MM/YYYY)</td>
					   </tr>

					   <tr>
				      <td class="label" ><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td>
					 
				      <td class='fields'><select name="p_age_range_code" id="p_age_range_code" >
					  <option value='' >---------------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------------------</option>
					 
					<%
						try
						{	
							
							pstmt 	= con.prepareStatement( "select range_id, long_desc from am_summ_range_lang_vw where range_type='A' and language_id='"+localeName+"' and  trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status ='E' order by 2");
							
					      	rs = pstmt.executeQuery() ;

							if( rs != null )
							{
								while( rs.next() )
								{
									
									String range_id = rs.getString( "range_id" ) ;
									String long_desc = rs.getString( "long_desc" ) ;
									out.println( "<option value='"+range_id+"' >"+long_desc+"</option>") ;
								}
					      	}
						}catch(Exception e) { }
						finally
						{
							try
							{
							if (rs != null) rs.close();
							if (pstmt != null) pstmt.close();
							if(con!=null) 	
							ConnectionManager.returnConnection(con,request);
							}
							catch(Exception e) { }
						}
				
					%>
					</select><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
						
		
		</table>
    </tr>
</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id%>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=p_login_user%>">
<input type="hidden" name="currentMonthYear" id="currentMonthYear"		value="<%=currentMonthYear%>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="CA">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type="hidden" name="p_report_id" id="p_report_id" 	value="CACCIMSTAT">
<!-- <input type='hidden' name='p_indicator_level' id='p_indicator_level' value="<%=p_outcome_type%>"> --> 
<!-- <input type ='hidden' name='mode' id='mode' value=''> -->

</form>
</body>
</html>

