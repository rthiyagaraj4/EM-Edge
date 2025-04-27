<!DOCTYPE html>
<%@page import="java.sql.Connection,java.sql.Statement,java.sql.*,java.sql.ResultSet,eCommon.Common.*,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	//Added Against MMS Vulnerability Issue - Starts
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
    //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String imgUrl = "";
	if (sStyle.equals("IeStyle.css")) {
		imgUrl = "../../eCommon/images/searchBoxBG.jpg";
	}
%>
<link rel="StyleSheet" type="text/css"
	href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css"
	href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
<script language="Javascript" src="../../eDS/js/MealPreparedServedComplaints.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name="MultipleSelectForAllPatients" id="MultipleSelectForAllPatients">
<!-- ML-MMOH-CRF-0681-->
<%
	//Added Against ML-MMOH-CRF-1061 US3 Starts Here
		String patient_class_IP="IP";
		String status_code_IP="";
		String status_desc_IP="";
		String status_desc_MP="";
		String status_desc_MR="";
		String status_desc_MS="";
		String status_desc_MJ="";
		String status_code_MP="";
		String status_code_MR="";
		String status_code_MS="";
		String status_code_MJ="";
		String IPstatus_Pre_YN="";
		String IPstatus_Rec_YN="";
		String STATUS_ACT_YN_IP="";
		String sql_Query="";
	//Added Against ML-MMOH-CRF-1061 US3 Ends Here
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		String sysDate ="";
		String locale=(String) session.getValue("LOCALE");
		boolean isMealComplaints = false; //Added Against MMOH-CRF-1125[IN:067026]
	try{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'DD/MM/YYYY HH24:MI') CURRENT_DATE FROM DUAL");
		isMealComplaints = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_COMPLAINTS"); //Added Against CRF-1125		 
		rst = pstmt.executeQuery();
		while(rst.next()){
			sysDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMYHM","en",locale);
		}
		
		//Added Against ML-MMOH-CRF-1061 US3 Starts Here
			sql_Query= "SELECT status_code , status_desc ,STATUS_ACT_YN FROM DS_MEAL_ACK_STATUS_MAST WHERE disp_sl_no <= 4 AND patient_class ='"+patient_class_IP+"' ORDER BY patient_class, disp_sl_no DESC";	
		pstmt=conn.prepareStatement(sql_Query);
		rst=pstmt.executeQuery();
		while (rst.next()){		
		status_code_IP = rst.getString(1);
		status_desc_IP = rst.getString(2);
		STATUS_ACT_YN_IP = rst.getString(3);
			
			if((status_code_IP.equals("MP"))){
					status_code_MP = rst.getString(1);
					status_desc_MP = rst.getString(2);
					IPstatus_Pre_YN	= rst.getString(3);
			}else if((status_code_IP.equals("MR"))){
					status_code_MR = rst.getString(1);
					status_desc_MR = rst.getString(2);
					IPstatus_Rec_YN = rst.getString(3);
			}else if((status_code_IP.equals("MS"))){
					status_code_MS = rst.getString(1);
					status_desc_MS = rst.getString(2);
			}else if((status_code_IP.equals("MJ"))){
					status_code_MJ = rst.getString(1);
					status_desc_MJ = rst.getString(2);
			}
		}
		//Added Against ML-MMOH-CRF-1061 US3 Ends Here
%>
<!-- ML-MMOH-CRF-0681-->
		<table width="100%" border="0">
			<tr align="left">
				<td style="width: 390px;" a align="left" class="label"><fmt:message
						key="eOT.statusDateTimeforAllPatients.Label"
						bundle="${ot_labels}" /></td>

				<td>
					<select name="setStatusForAll" id="setStatusForAll" onChange="changeStatus()">
						<option value=''>
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
						<!-- Modified Against ML-MMOH-CRF-1061 US3 Starts Here -->
						<%if(IPstatus_Pre_YN.equals("Y")){%>
						<option value='MP'><%=status_desc_MP%>
						</option>
						<%}%>
						<%if(IPstatus_Rec_YN.equals("Y")){%>
						<option value='MR'><%=status_desc_MR%>
						</option>
						<%}%>
						<option value='MS'><%=status_desc_MS%>
						</option>
						<option value='MJ'><%=status_desc_MJ%>
						</option>
						<!-- Modified Against ML-MMOH-CRF-1061 US3 Ends Here -->
					</select>
					<input type="text" name="from" id="from" size="16" maxlength="16" onchange="changeDate_AllPatients();" value="<%=sysDate%>" onblur="isValidDateTime_AllPatients(this);" >
					<img src='../../eCommon/images/CommonCalendar.gif' onclick="showCalendar('from','DD/MM/YYYY','hh:mm');changeDate_AllPatients();"/>
				</td>
			</tr>
		<input type="hidden" name="isMealComplaints" id="isMealComplaints" id ="isMealComplaints" value="<%=isMealComplaints%>"> <!-- Added Against MMOH-CRF-1125 -->	
		</table>
<!-- ML-MMOH-CRF-0681-->
<%
		}
		catch(Exception e){
			e.printStackTrace();
			out.println(e);
		}finally{
		if(rst!=null)
			rst.close();
		if(pstmt!=null)
			pstmt.close();
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
		}
%>
<!-- ML-MMOH-CRF-0681-->
</form>
</body>
</html>

