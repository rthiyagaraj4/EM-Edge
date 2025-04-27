<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,java.net.*,com.ehis.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
	<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eAE/js/ReleaseBay.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    </head>
	<body onload="setfocus();" onKeyDown = 'lockKey()'>
	<form name="releasebed_resultform" id="releasebed_resultform" method='post' action='../../eAE/jsp/ReleaseBayResult.jsp'>
	
	<%

		Connection con	= null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    String locale			= (String)session.getAttribute("LOCALE");

		String from = request.getParameter( "from" ) ; 
	    String to = request.getParameter( "to" ) ;
		String facilityid	= (String)session.getValue("facility_id");
		String loginUser	= checkForNull((String)session.getValue("login_user"));
		String cliniccode=(request.getParameter("clinic_code") == null)?"":request.getParameter("clinic_code");
		String treatmentarea = (request.getParameter("treatment_area") == null)?"":request.getParameter("treatment_area");
		String baytype = (request.getParameter("bay_type") == null)?"":request.getParameter("bay_type");
		String reserveuntil =(request.getParameter("reserve_until") == null)?"":request.getParameter("reserve_until");
    	StringBuffer whereclause= new StringBuffer();
		String relsbedvalue="";
		String releasebedhid=(request.getParameter("releasebed_hid") == null)?"":request.getParameter("releasebed_hid");
		String bayno="";
		String baytypecode="";
		String baytypedesc="";
		String cliniccode1="";
		String clinicdesc="";
		String treatmentareacode1="";
		String treatmentareadesc="";		
		String reserveuntilresult="";
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;
		StringTokenizer strToken		= null;
		int strCount					= 0;
		String tokenValue	= "";
		String check_attribute="";
		String classValue="";
		String bool=(request.getParameter("bool") == null)?"false":request.getParameter("bool");
		String operstn = "";

		con =ConnectionManager.getConnection(request);

		StringBuffer sqlAM = new StringBuffer();
	    sqlAM.append("select a.oper_stn_id oper_stn_id,to_char(sysdate,'dd/mm/yyyy hh24:mi')sys_date from ");
		sqlAM.append(" am_oper_stn a, am_user_for_oper_stn b,dual ");
		sqlAM.append(" where a.facility_id= ? ");
		sqlAM.append(" and a.facility_id=b.facility_id ");
		sqlAM.append(" and a.oper_stn_id = b.oper_stn_id ");
		sqlAM.append(" and b.appl_user_id = ?  ");
		sqlAM.append(" and trunc(sysdate) between b.eff_date_from  ");
		sqlAM.append(" and  nvl(b.eff_date_to,trunc(sysdate)) ");
		pstmt=con.prepareStatement(sqlAM.toString());
		pstmt.setString(1, facilityid);
	     pstmt.setString(2, loginUser);
					rs=pstmt.executeQuery();
					if(rs != null && rs.next())
					{
						operstn	 = checkForNull(rs.getString("oper_stn_id"));

					}
					
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				    if((sqlAM != null) && (sqlAM.length() > 0))
					  {
						sqlAM.delete(0,sqlAM.length());
					  } 


		StringBuffer sql = new StringBuffer();
		try{
			    
				whereclause.append(" and FACILITY_ID='"+facilityid+"'");

				if(!cliniccode.equals(""))
				{
					whereclause.append(" and clinic_code='"+cliniccode+"'");
				}
				if(!treatmentarea.equals(""))
				{
					whereclause.append( " and treatment_area_code='"+treatmentarea+"'");
				}
				if(!baytype.equals(""))
				{
					whereclause.append(" and bay_type_code='"+baytype+"'");
				}

				if(!reserveuntil.equals(""))
				{
					whereclause.append( " and occupied_until_date_time <= to_date('"+reserveuntil+"','dd/mm/yyyy hh24:mi')");
				}

				if ( from == null )
					start = 1 ;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null )
					end = 14;
				else
					end = Integer.parseInt( to ) ;
                sql.append("select bed_no bed_no,bay_type_code bay_type_code,AE_GET_DESC.AE_BAY_TYPE(BAY_TYPE_CODE,'"+locale+"','2') bay_type_desc, clinic_code clinic_code,OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_desc,treatment_area_code treatment_area_code,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(FACILITY_ID,CLINIC_CODE,TREATMENT_AREA_CODE,'"+locale+"','2') treatment_area_desc,to_char(occupied_until_date_time,'dd/mm/yyyy hh24:mi')  reserve_until,current_status reserve from ae_bed_for_trmt_area where current_status='R' and occupied_until_date_time > sysdate and eff_status='E' AND (facility_id,CLINIC_CODE) in (select facility_id,locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+facilityid+"' and oper_stn_id ='"+operstn+"' and appl_user_id = '"+loginUser+"' and RELEASE_BED_BAY_YN = 'Y') "+whereclause.toString());
					
				
				
				pstmt=con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
				rs=pstmt.executeQuery();
				
				%>
					<input type='hidden' name='maxRecord' id='maxRecord' value='<%=maxRecord%>'>
						<input type='hidden' name='releasebed_hid' id='releasebed_hid' value='<%=releasebedhid%>'>
						<input type='hidden' name='from' id='from' value='<%=from%>'>
						<input type='hidden' name='to' id='to'value='<%=to%>'>
						<input type="hidden" name="fac_id" id="fac_id" value = "<%=facilityid%>">
						<input type=hidden  name='treatment_area' id='treatment_area' value='<%=treatmentarea%>' >
						<input type=hidden  name='clinic_code ' id='clinic_code ' value='<%=cliniccode%>'>
						<input type=hidden name='bay_type' id='bay_type' value='<%=baytype%>'>
						<input type=hidden name='reserve_until' id='reserve_until' value='<%=reserveuntil%>'>	
						<input type='hidden' name='bool' id='bool' value='<%=bool%>'>
					
					<%
				if(rs != null)
				{
						
					if(bool.equals("false"))
					{
                    
						while(rs.next())
						{
							bayno=(rs.getString("bed_no") == null)?"":rs.getString("bed_no");
							cliniccode1=(rs.getString("clinic_code") == null)?"":rs.getString("clinic_code");
							treatmentareacode1=(rs.getString("treatment_area_code") == null)?"":rs.getString("treatment_area_code");
							relsbedvalue=bayno+"$"+cliniccode1+"$"+treatmentareacode1;
							
							%>
								<script>							
								releaseValues('<%=relsbedvalue%>','<%=i%>');			
								</script>
								<%
									i++;

						}
					}
					i=1;
					rs.beforeFirst();
					rs.last();
					maxRecord=rs.getRow();
					%>
						
					<P>
					<table align='right'>
						<tr>
							<td>					
								<%
								if ( !(start <= 1) )
								{						
								%>							

									<a href='javascript:submitPrevNext(<%=start-14%>, <%=end-14%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
								<%
								}

								if ( !( (start+14) > maxRecord ) )
								{									
								%>
									<a href='javascript:submitPrevNext(<%=(start+14)%>, <%=end+14%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
								<%
								}
								%>
							</td>
						</tr>
					</table><br>					
					</P>
						
							

				<%				
					rs.beforeFirst();
					if(maxRecord == 0) {
				%>
				<script>						
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				    parent.frames[1].location.href = "../../eCommon/html/blank.html";	// Tuesday, March 23, 2010  20202 Venkat S
				</script>
				<%
				} 	else 	{%><table cellpadding='0' cellspacing=0 border=1 width='100%' >
					<th align='center'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
					<th align='center'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></th>
					<th align='center'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></th>
					<th align='center'><fmt:message key="eAE.BedBayType.label" bundle="${ae_labels}"/></th>					
					<th align='center'><fmt:message key="eAE.ReservedUntil.label" bundle="${ae_labels}"/></th>
					<th align='center'><fmt:message key="Common.Release.label" bundle="${common_labels}"/></th><%
					if ( start != 1 ) {
						for( int j=1; j<start; i++,j++ )
						rs.next() ;
					}
					while(rs.next()  && i<=end) {
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						bayno=(rs.getString("bed_no") == null)?"":rs.getString("bed_no");
						baytypecode=(rs.getString("bay_type_code") == null)?"":rs.getString("bay_type_code");
						baytypedesc=(rs.getString("bay_type_desc") == null)?"":rs.getString("bay_type_desc");
						cliniccode1=(rs.getString("clinic_code") == null)?"":rs.getString("clinic_code");
						clinicdesc=(rs.getString("clinic_desc") == null)?"":rs.getString("clinic_desc");
						treatmentareacode1=(rs.getString("treatment_area_code") == null)?"":rs.getString("treatment_area_code");
						treatmentareadesc=(rs.getString("treatment_area_desc") == null)?"":rs.getString("treatment_area_desc");
						reserveuntilresult=(rs.getString("reserve_until") == null)?"":rs.getString("reserve_until");
						reserveuntilresult=DateUtils.convertDate(reserveuntilresult,"DMYHM","en",locale);
						relsbedvalue=bayno+"$"+cliniccode1+"$"+treatmentareacode1;

						if(bool.equals("false")) {
							check_attribute = "Checked";
						}
						if ((!releasebedhid.equals("")) && (!releasebedhid.equals(","))) {
							strToken	=  new StringTokenizer(releasebedhid, ","); 
							strCount = strToken.countTokens();
						}							
						for (int k=0; k<strCount; k++) {
							tokenValue = checkForNull(strToken.nextToken());
							String newchkval=i+"^^"+relsbedvalue;
							if(tokenValue.equals(newchkval)) {
								check_attribute = "Checked";
								}						

							}	
							%>
								<tr >
									<td  class='<%=classValue%>' align='left' width='15%'><%=clinicdesc%><input type='hidden' name='clinic_code<%=i%>' id='clinic_code<%=i%>' value='<%=cliniccode1%>'>
									</td>
									<td  class='<%=classValue%>' align='left' width='15%'><%=treatmentareadesc%><input type='hidden' name='treatment_area_code<%=i%>' id='treatment_area_code<%=i%>' value='<%=treatmentareacode1%>'>
									</td>
									<td class='<%=classValue%>' align='left' width='15%'><%=bayno%><input type='hidden' name='bay_no<%=i%>' id='bay_no<%=i%>' value='<%=bayno%>'>
									</td>
									<td  class='<%=classValue%>' align='left' width='15%'><%=baytypedesc%><input type='hidden' name='bay_type<%=i%>' id='bay_type<%=i%>' value='<%=baytypecode%>'>
									</td>									
									<td  class='<%=classValue%>' align='left' width='15%'><%=reserveuntilresult%>
									</td>
									<td  class='<%=classValue%>' align='center' width='15%'><input type='checkbox' name='reserve_yn<%=i%>' id='reserve_yn<%=i%>' onClick="unrelease(this,'<%=i%>')" <%=check_attribute%> value="<%=relsbedvalue%>">
									</td>
								</tr>
										
							<%
							i++;
						}
					}
				}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			%>

				</table>					
			</form>
		<%
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
		%>

	</body>
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
}

%>

