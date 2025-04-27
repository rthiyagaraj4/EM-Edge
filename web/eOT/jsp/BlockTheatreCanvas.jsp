<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id=(String) session.getAttribute("facility_id");

%>

<html>
	<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language='javascript' src='../../eOT/js/BlockTheatre.js'></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
	
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
	<form name="BlockTheatreSlots" id="BlockTheatreSlots" action="../../servlet/eOT.BlockTheatreSlotsServlet" method="post" target="messageFrame">

	
<%


Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String  short_desc="";
String wd_start_time = "";
String wd_end_time = "";
String oper_room_code = request.getParameter("oper_room_code")==null?"":request.getParameter( "oper_room_code" );
String sql_1=request.getParameter("sql_1");
String unit_ot_time="";
String sqlForUnitTime="SELECT TO_CHAR(unit_ot_time, 'hh24:mi') FROM   ot_param_for_facility  WHERE  operating_facility_id = ?"; 
String sql_2="SELECT SHORT_DESC FROM  OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID = ? AND OPER_ROOM_CODE =? AND LANGUAGE_ID= ? ORDER BY SHORT_DESC"; 
//String sql_1 = "SELECT TO_CHAR(WD_START_TIME, 'HH24:MI') WD_START_TIME, TO_CHAR(WD_END_TIME, 'HH24:MI') WD_END_TIME FROM OT_OPER_ROOM WHERE  OPERATING_FACILITY_ID = ? AND OPER_ROOM_CODE = ?";

%>

		<table border=0 cellpadding=0 cellspacing=0 width=95% height=50% align="center">
			<tr>
				<td>
					<table border="0">
						<tr>
							<td width="11%">
							&nbsp;
							</td>
							<td width="30"class=LABEL>
							<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
							</td>
							<td width="10">&nbsp;
							</td>
							<td>
								<select name="theatre_code" id="theatre_code" onchange='populateTheartre(this);' >
								<%
								//if-else condition added by parul on 6/18/2009 for IN09789
								if(oper_room_code.equals("")){%>
									<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  </option> 
							
								<%
									}else{
									Connection conn1=null;
									PreparedStatement pstmt1=null;
									ResultSet rst1=null;
							try{

								conn1=ConnectionManager.getConnection(request);
								pstmt1=conn1.prepareStatement(sql_2);
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,oper_room_code);
								pstmt1.setString(3,locale);
								rst1=pstmt1.executeQuery();
								while(rst1.next()){
									
									short_desc=rst1.getString(1);
								}
								%>
							<option value="<%=oper_room_code%>"><%=short_desc%></option> 
							<%
							}catch(Exception e){e.printStackTrace();}
							finally{
						try{
								if(rst1!=null) rst1.close();
							    if(pstmt1!=null) pstmt1.close();
								ConnectionManager.returnConnection(conn1,request);
							}catch(Exception e){e.printStackTrace();}
						  }
						}
							%>							
							<%

								String sql="";
								sql="SELECT OPER_ROOM_CODE,SHORT_DESC FROM  OT_OPER_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID = ? AND NVL(STATUS,'E')='E' AND LANGUAGE_ID= ? ORDER BY SHORT_DESC";
								Connection conn=null;
								PreparedStatement pstmt=null;
								ResultSet rst=null;
								try{

									conn=ConnectionManager.getConnection(request);
									pstmt=conn.prepareStatement(sql);
									pstmt.setString(1,facility_id);
									pstmt.setString(2,locale);
									rst=pstmt.executeQuery();
								while(rst.next()){
									oper_room_code=rst.getString(1);
									short_desc=rst.getString(2);
									//select_flag = (p_instr_code.equals(rs.getString(1)))?"selected":"";
								
								%>	
								<option value="<%=oper_room_code%>"><%=short_desc%></option> 
								<%
									}
								%>
	              
							</select>&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'>

							<% }catch(Exception e){e.printStackTrace();}
							finally{
						try{
								if(rst!=null) rst.close();
							    if(pstmt!=null) pstmt.close();
								ConnectionManager.returnConnection(conn,request);
							}catch(Exception e){e.printStackTrace();}
							}

								try{
								con=ConnectionManager.getConnection(request);
								stmt=con.prepareStatement(sql_1);
							//	commented by parul on 6/18/2009 for IN09789 and written in function populateTheartre()
								//stmt.setString(1,facility_id);
								//stmt.setString(2,oper_room_code);
								rs=stmt.executeQuery();
								while(rs.next()){		
									wd_start_time = rs.getString("WD_START_TIME");
									wd_end_time = rs.getString("WD_END_TIME");
								}
								if(rs!=null) rs.close();
								if(stmt!=null) stmt.close();

								stmt=con.prepareStatement(sqlForUnitTime);
								stmt.setString(1,facility_id);
								rs=stmt.executeQuery();
								while(rs.next()){		
									unit_ot_time = rs.getString(1);
								}
							}catch(Exception e){
								e.printStackTrace();
								//System.err.println("Error in DairyScheduleForSuregonRecord.jsp"+e.getMessage());
							}finally{
								try{
									if(rs!=null) rs.close();
									if(stmt!=null) stmt.close();
									
									if(con!=null) 
									ConnectionManager.returnConnection(con,request);
								}catch(Exception e){e.printStackTrace();}
							}
							%>
							</td>
						</tr>
					</table>
				</td>
			</tr>
						<tr>
				<td>
					<table border="0">
						<tr>
							<td width="5%">
							&nbsp;
							</td>
							<td width="50"class=LABEL>
							<fmt:message key="Common.reason.label" bundle="${common_labels}"/>
							</td>
							<td width="5">&nbsp;</td>
							<td>
							<textarea name="block_reason" rows="3" cols="62" onBlur="checkMaxLimit1(this,200);makeValidString(this)" style="resize: none;"></textarea>
							<img src='../../eCommon/images/mandatory.gif'></img>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table border="0">
						<tr>
							<td width="48%">&nbsp;</td>
							<td>
							<input type="checkbox" name="block_by_day" id="block_by_day" value="N" onclick="blockbyday()">
							</td>
							<td class=LABEL>
							Day Specific
							</td>
						</tr>
					</table>				
				</td>
			</tr>
			<tr>
				<td>
					<table border="0" width="90%">
						<tr>
							<td width=20%>&nbsp;</td>
							<td width=29%>
								<fieldset name="BlockDate">
								<table width=68% border="0" align="right" cellpadding="1" cellspacing="0">
									<th colspan=3 align="left">
										<fmt:message key="eOA.BlockDate.label" bundle="${oa_labels}"/>
									</th>	
									<tr>
										<td width="20%" nowrap class=LABEL>
										<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;
										</td>
										<td width="30%" nowrap>
											<input type="text" name="from_date" id="from_date" value="" size="12" maxlength="10" onblur="checkDateFormat(this)" onkeypress="return checkForSpecCharsforID(event);">
										</td>
										<td width="10%"  align='left' nowrap>&nbsp;&nbsp;
										<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('from_date');"><img src='../../eCommon/images/mandatory.gif'></img>
										</td>
										<td width="20" nowrap>&nbsp;</td>
									</tr>
									<tr>
										<td class=LABEL>
											<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
										</td>
										<td>
											<input type="text" name="to_date" id="to_date" value="" size="12" maxlength="10" onBlur="checkDateFormat(this)" onkeypress="return checkForSpecCharsforID(event);">
										</td>
										<td>&nbsp;&nbsp;
										<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('to_date');"><img src='../../eCommon/images/mandatory.gif'></img>
										</td>

									</tr>
								</table>
								</fieldset>
							</td>
							<td width=0%>&nbsp;</td>
							<td width=30%>
								<fieldset name="Block">
								<table width=100% border="0" align="right" cellpadding="1" cellspacing="0">
									<th colspan=3 align="left">
										<fmt:message key="eOT.SlotTime.Label" bundle="${ot_labels}"/>
									</th>
									<td>&nbsp;</td>
									<tr>
										<td width="20%" nowrap class=LABEL>
											<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;
										</td>
										<td class="fields" width="36%" nowrap>
											<input type="text" name="from_time" id="from_time" value="" size="12" maxlength="5" onblur="chkFromTimeRange(this)" onkeypress="return checkForSpecCharsforIDTime(event);"> (hh24:mi)
										</td>
										<!--<td width="10%" nowrap>&nbsp;&nbsp;
										 <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('from_date');"><img src='../../eCommon/images/mandatory.gif'></img> 
										</td>-->
										<td width="34" nowrap>&nbsp;</td>
									</tr>
									<tr>
										<td class=LABEL>
											<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
										</td>
										<td class="fields">
											<input type="text" name="to_time" id="to_time" value="" size="12" maxlength="5" onblur="chkToTime(this)" onkeypress="return checkForSpecCharsforIDTime(event);"> (hh24:mi)
										</td>
										<!--<td>&nbsp;&nbsp;
										 <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('from_date');"><img src='../../eCommon/images/mandatory.gif'></img> 
										</td>-->
									</tr>
								</table>
								</fieldset>
							</td>
							<td width=25%>&nbsp;</td>
						</tr>
					</table>				
				</td>
			</tr>
			<tr>
				<td>
				
				<table border="0"><tr>
				
				<td width="17%">&nbsp;</td>
				<td>
				<fieldset name="week">
				
				<table border="0" width="80%">
				
					<tr>
						<td nowrap colspan="12">
						
						<table border="0" align="left"><tr><th class="labelleft" nowrap>
						<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
						</th></tr></table>
						
						</td></tr>
						<fieldset style="border:0;">
						<tr>
							<td align="left" nowrap>
								<input type="checkbox" name="all" id="all" onclick="selectall()"  disabled>
							</td>
							<td class="LABELLEFT" align="left" nowrap>
								<fmt:message key="Common.AllWeeks.label" bundle="${common_labels}"/>&nbsp;&nbsp;
							</td>		
							<td align="right" nowrap>
								<input type="checkbox" name="week_1" id="week_1" value="N" disabled onClick="assignDayofWeek(this)">
							</td>
							<td class='LABELLEFT' nowrap>
								<fmt:message key="eOT.FirstWeek.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;
							</td>
							<td align="right" nowrap>
								<input type="checkbox" name="week_2" id="week_2" value="N" disabled onClick="assignDayofWeek(this)">
							</td>
							<td class='labelleft' nowrap>
								<fmt:message key="eOT.SecondWeek.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;
							</td>
							<td align="right" nowrap>
								<input type="checkbox" name="week_3" id="week_3" value="N" disabled onClick="assignDayofWeek(this)">
							</td>
							<td class=LABELLEFT nowrap>
								<fmt:message key="eOT.ThirdWeek.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;
							</td>
							<td align="right" nowrap>
								<input type="checkbox" name="week_4" id="week_4" value="N" disabled onClick="assignDayofWeek(this)">
							</td>
							<td class=LABELLEFT nowrap>
								<fmt:message key="eOT.FourthWeek.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;
							</td>
							<td align="right" nowrap>
								<input type="checkbox" name="week_5" id="week_5" value="N" disabled onClick="assignDayofWeek(this)">
							</td>
							<td class=LABELLEFT nowrap>
								<fmt:message key="eOT.FifthWeek.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;
							</td>
						</tr>
					</tr>
					</fieldset>
				</table>
				
				</td><tr/></table>
				</td>
				
			</tr>
			<tr>
				<td>
					<table border="0">
						<tr>
							<td width="15%">&nbsp;</td>
							<td width="43" class=LABEL>
								<fmt:message key="Common.day.label" bundle="${common_labels}"/>
							</td>
							<td width="10">&nbsp;</td>
							<td>
								<select name="day_code" id="day_code" disabled>
									<option value=''> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> </option>
									<option value="sunday"><fmt:message key="Common.sun.label" bundle="${common_labels}"/></option>
									<option value="monday"><fmt:message key="Common.mon.label" bundle="${common_labels}"/></option>
									<option value="tuesday"><fmt:message key="Common.tue.label" bundle="${common_labels}"/></option>
									<option value="wednesday"><fmt:message key="Common.wed.label" bundle="${common_labels}"/></option>
									<option value="thursday"><fmt:message key="Common.thu.label" bundle="${common_labels}"/></option>
									<option value="friday"><fmt:message key="Common.fri.label" bundle="${common_labels}"/></option>
									<option value="saturday"><fmt:message key="Common.sat.label" bundle="${common_labels}"/></option>
								</select>
							
								<img name='imageflag' src='../../eCommon/images/Blank1.gif'></img>
					
							</td>
						</td>	
					</table>
				</td>
			</tr>
			<tr>
				<td align="center">
				<table border="0" width="100%"><tr>
					<td width="40">&nbsp;</td>
					<td width="60">
					<input type="button" class='button' name="block" id="block" onclick="blocktheatre()" value='<fmt:message key="Common.block.label" bundle="${common_labels}"/>' >
					</td></tr></table>
				</td>
			</tr>

		</table>


	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='wd_start_time' id='wd_start_time' value="<%=wd_start_time%>">
	<input type='hidden' name='wd_end_time' id='wd_end_time' value="<%=wd_end_time%>">
	<input type='hidden' name='unit_ot_time_DB' id='unit_ot_time_DB' value="<%=unit_ot_time%>">
	<input type='hidden' name='oper_room_code' id='oper_room_code' value="<%=oper_room_code%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
	<input type="hidden" value="" name="setflag" id="setflag">
	<input type="hidden" value="true" name="blocksetflag" id="blocksetflag">
	<input type="hidden" value="true" name="blocksetflagcheck" id="blocksetflagcheck">
	<input type='hidden' name='curr_date' id='curr_date'   value=''>
		</form>
	</body>
</html>

