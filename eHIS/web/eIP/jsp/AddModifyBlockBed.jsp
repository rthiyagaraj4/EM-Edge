<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,com.ehis.util.*,java.text.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script> 
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eIP/js/BlockBed.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script language="JavaScript">
override_yn = new Array();
var strconcat="";
function setOverride(object)
{
	var strarr="";
	var i = object.selectedIndex;
	strarr = strconcat.split("`");
	for( J=0 ;J<strarr.length ;J++)
	{
     override_yn[J]=strarr[J];
	}
   // document.getElementById("from_date").value='';
	document.forms[0].from_date.value = '';
	//document.getElementById("until_date").value='';
	document.forms[0].until_date.value = '';
	
	if (i > 0)
	{
			if(override_yn[i-1]=='Y')
			{
				document.getElementById("overrides").checked = true;
				document.getElementById("override").value = 'Y';							
			}
			else
			{
				document.getElementById("overrides").checked = false;
				document.getElementById("override").value = 'N';
			}
	}
	else
	{
		document.getElementById("overrides").checked = false;
		document.getElementById("override").value = 'N';
	}
}

</script>

	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String locale			= (String)session.getAttribute("LOCALE");
		
		Connection	con			= null;
		Statement	stmt		= null;
		PreparedStatement pstmt = null;
		ResultSet	rs			= null;
		Statement	stmt_opn	= null;
		ResultSet	rs_opn		= null;
		Statement	stmtBlkType = null;
		ResultSet	rsBlkType	= null;

		try
		{
			con	= ConnectionManager.getConnection(request);
			String facility_id			= (String)session.getAttribute("facility_id");
			String p_oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
			String gen_booking_srl_yn	= checkForNull(request.getParameter("gen_booking_srl_yn"));
			String loginUser			= (String)session.getAttribute("login_user");
	      String strconcat="";
	%>

	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  onload="FocusFirstElement();" >
		<form name="Blocking_Bed_Form" id="Blocking_Bed_Form"  action="../../servlet/eIP.BlockBedServlet" method="post" target="messageFrame">
		<BR><BR><BR>
		<BR><BR><BR>
			 <table border='0' cellpadding='3' cellspacing='0' width='90%' align='center'>
		<%
				String  call = request.getParameter("call");
				if(call == null || call.equals("null"))call="";

				StringBuffer sbSql = new StringBuffer();
				sbSql.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? ");
				sbSql.append(" AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? ");
				sbSql.append(" AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
	
				pstmt = con.prepareStatement(sbSql.toString());
				pstmt.setString(1, facility_id);
				pstmt.setString(2, loginUser);
				
				rs_opn = pstmt.executeQuery();
	/* 			stmt_opn = con.createStatement();
				rs_opn = stmt_opn.executeQuery(sbSql.toString()); */
				if (rs_opn.next())
				{
					p_oper_stn_id = rs_opn.getString("oper_stn_id");
				}
			    if (rs_opn!=null) rs_opn.close();
	            if (pstmt!=null) pstmt.close();
			 	if (sbSql.length() > 0) sbSql.delete(0,sbSql.length());		

					if (!gen_booking_srl_yn.equals(""))
					{
						if(gen_booking_srl_yn.equals("N"))
						{
						
							%>
                         <tr>
							
							<td class='label' nowrap><fmt:message key="eIP.BlockingRefNo.label" bundle="${ip_labels}"/></Td>
								
							<td class = 'fields' nowrap><input type='text'  name='blocking_ref_no' id='blocking_ref_no' size='12' maxlength='12' onBlur='return validSplchars_ref(this)'><img align='center' src='../../eCommon/images/mandatory.gif'></img>
							</td>
						 </tr> 
					<%   }
					}
					else
					{ %>
						<script>alert(getMessage('SETUP_BOOK_SRL_CTRL','IP'));
						self.location.href='../../eCommon/html/blank.html'</script>
				    <%}
				
				%>

             	<tr>
					<td class='columnheader' colspan='4'><fmt:message key="eIP.BedDetails.label" bundle="${ip_labels}"/></td>
				</tr>
                 
				<tr>
					<td class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>

					<td class = 'fields' nowrap><input type=text name="nursing_unit_desc" id="nursing_unit_desc" width="15" maxlength=15 size=15 onblur="beforeGetNursingUnit('<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>',nursing_unit,nursing_unit_desc); checkForNursing(this.value);"><input type=button class=button name=nursing_unit_lookup value='?' onClick="checkTxtVal('<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>',nursing_unit,nursing_unit_desc)"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					<input type=hidden name="nursing_unit" id="nursing_unit" width="15" onChange=''></td>
					<input type=hidden name="nurs_desc_hid" id="nurs_desc_hid" value=''>
					
					<td class='label'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
					<td  class = 'fields' nowrap>
						<input type='text' readonly name='bed_no' id='bed_no' size='8' maxlength='8'  onKeyPress='return CheckForSpecChars(event)' onblur='ChangeUpperCase(this);checkForBedNo(this.value);getRoomNo();'><input type='button'  name='search_bed' id='search_bed' value='?' onclick='searchBed()' class='button'><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				
				<tr>
					<td class='label'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
					<td id='bedclass' class='QUERYDATA'></td>
					<td class='label'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
					<td id='roomno' class='QUERYDATA'></td>
				</tr>
				<tr><td colspan='4'>&nbsp</tr>
				
				<tr>
					<td class='columnheader' colspan='4' ><fmt:message key="eIP.BlockingDetail.label" bundle="${ip_labels}"/></td>	
				</tr>
				
	<%
		//stmtBlkType = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

/* 		stmtBlkType = con.createStatement(); */

		StringBuffer sqlBlkType = new StringBuffer();
	    sqlBlkType.append("Select  blocking_type_code,short_desc,override_yn from ip_blocking_type_lang_vw where language_id = ? and eff_status ='E' order by short_desc");
	    
	    pstmt = con.prepareStatement(sqlBlkType.toString());
	    pstmt.setString(1, locale);
	    rsBlkType = pstmt.executeQuery();
/* 		rsBlkType  = stmtBlkType .executeQuery(sqlBlkType.toString()); */
		int indexForBlkType = 0;
	%>
				<tr>
					<td class ='label'><fmt:message key="eIP.ReasonforBlocking.label" bundle="${ip_labels}"/></td>
					<td class = 'fields' nowrap>
						<select name='blocktype' id='blocktype' onChange="setOverride(this)"><option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
						String code	  = "";
						String desc   = "";
						String str	  = "";
						
						while( rsBlkType.next() )
						{
								 code   = rsBlkType.getString(1) ;
								 desc   = rsBlkType.getString(2) ;
								 str	= rsBlkType.getString(3);
								
								if(strconcat.equals(""))
							   {
							  strconcat=str; 
							   }else{
								strconcat=strconcat+"`"+str; 
							   }
					%>
					<!--	<script>
							override_yn[<%=indexForBlkType%>]="<%=str%>";
						</script> -->
						 <OPTION VALUE="<%=code%>"><%=desc%></option>
					<%
								indexForBlkType++;
							
						}%>
						<script>
							strconcat="<%=strconcat%>";
						</script>
						
						</select><img src='../../eCommon/images/mandatory.gif'></img>  
					</td>
					<td class ='label'>&nbsp;</td>
					<td class ='label'>&nbsp;</td>
					</tr>
					<%	
						
						//rsBlkType.beforeFirst();
						//String str = "";
						/*while(rsBlkType.next())
						{
							str = rsBlkType.getString(3);
							*/
							 
					%>
					<!--<script>
							override_yn[<%=indexForBlkType%>]="<%=str%>";
					</script>-->
					<%
							/*indexForBlkType++;
						}*/

						if(pstmt != null) pstmt.close();
						pstmt = con.prepareStatement("Select BED_BLOCK_PERIOD_MAX, BED_BLOCK_PERIOD_MAX_TYPE, BED_BLOCK_PERIOD_NORMAL from ip_param where facility_id=? order by bed_block_period_max_type");
						pstmt.setString(1, facility_id);
						rsBlkType = pstmt.executeQuery();
						/* 						rsBlkType  = stmtBlkType.executeQuery(""); */
						
						String block_max = "";
						String block_normal = "";
						String block_max_period = "";
						if ( (rsBlkType != null) && rsBlkType.next() )
						{
							block_max = ""+rsBlkType.getInt(1);
							block_max_period = rsBlkType.getString(2);
							block_normal = ""+rsBlkType.getInt(3);
						}
					%>
                
                <tr> 
					<td class ='label'><fmt:message key="Common.override.label" bundle="${common_labels}"/></td>
					<td class = 'fields' nowrap><input type='checkbox'  name='overrides' id='overrides' value='Y' onclick='objChk(this)' disabled></td>
					<td class = 'fields' nowrap><input type="hidden" name='override' id='override' value="Y"></td>
                    <td class ='label'>&nbsp;</td>
				</tr>
				
				<tr>
					<td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class = 'fields' nowrap colspan='4'>
						<input type='text'  name='remarks' id='remarks' size='60' maxlength='60' onblur='dateValRemarks(this)'><img id="mandimg" align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				
				<tr>
					<td class='label'><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
					<td class = 'fields' nowrap>					
<!-- id='from_date' -->	
						<input type='text' id='blockfrom' name='from_date'  size='16' maxlength='16' value='' onblur='dateVal(this)'><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('blockfrom', null, 'hh:mm' );"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
					<td class='label'><fmt:message key="Common.until.label" bundle="${common_labels}"/></td>
					<td class = 'fields' nowrap>					
<!-- id='until_date' -->
						<input type='text' id='blockto' name='until_date' size='16' maxlength='16' value='' onblur="if(dateVal(this))checkUntilDate(this,grace);"><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('blockto', null, 'hh:mm' );"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr><td colspan='4'>&nbsp</tr>
			</table>
			<input type='hidden'  name='bed_type' id='bed_type' > 
			<input type='hidden'  name='bed_class' id='bed_class' >
			<input type='hidden'  name='room_no' id='room_no' >
			<input type='hidden'  name='locale' id='locale' value='<%=locale%>' >
			<input type='hidden'  name='grace' id='grace' value='<%=block_max%>' >
			<input type='hidden'  name='grace_type' id='grace_type' value='<%=block_max_period%>' >
			<input type='hidden'  name='grace_normal' id='grace_normal' value='<%=block_normal%>' >
			<!-- <input type='hidden'  name='remarks_flag' id='remarks_flag' value='mandatory' > -->
			<input type='hidden'  name='call_function' id='call_function' value='BLOCK_BED' >	
			<input type='hidden'  name='sStyle' id='sStyle' value='<%=sStyle%>' >	
		</form>
	</body>
</html>
<%
		if (rsBlkType != null) rsBlkType.close();
		if (rs != null) rs.close();
		if (rs_opn != null) rs_opn.close();
		if (stmt != null) stmt.close();
		if (pstmt != null) pstmt.close();
		if (stmt_opn != null) stmt_opn.close();
		if (stmtBlkType != null) stmtBlkType.close();

	}catch(Exception e) {
		/* out.println(e.toString()); */
		e.printStackTrace();		
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}			
%>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

