<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.ArrayList,eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ page import="java.sql.ResultSetMetaData" %>

<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	String bean_id		= "OTCommonBean";
	String bean_name	= "eOT.OTCommonBean";
	OTCommonBean bean= (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	ArrayList color_array = bean.getOTStatusColors();
%>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<Script src="../../eXH/js/showModalDialog.js" language="JavaScript"></Script>
<style>
<%
	for(int i =0;i<color_array.size();i+=3){
						
%>
		TD.<%=(String)color_array.get(i)%>{
			BACKGROUND-COLOR:<%=(String)color_array.get(i+2)%>;
			FONT-SIZE: 8pt ;
			BORDER-STYLE: solid;
			BORDER-BOTTOM: #CC9966 0px solid;
			BORDER-LEFT: #CC9966 0px solid;
			BORDER-RIGHT: #CC9966 0px solid;
			BORDER-TOP: #CC9966 1px solid;
	   }
<%}%>

	 TD.OTMENULAYER
		  {
	 		FONT-FAMILY: VERDANA ;
	 		FONT-SIZE: 10PT ;
	 		BACKGROUND-COLOR: #D8BFD8;
	 		COLOR: WHITE;
		}
		TD.OTMENU
		  {
			BACKGROUND-COLOR: #C0C0C0 ;
			FONT-SIZE: 9PT ;
			BORDER-STYLE: DASHED;
			BORDER-LEFT-COLOR: #FFA500;
			BORDER-RIGHT-COLOR: #FFA500;
			BORDER-TOP-COLOR: #FFFACD;
			BORDER-BOTTOM-COLOR: #FFFACD;
		 }
		TD.OTCLASS{
			FONT-SIZE: 9pt ;
			BORDER-STYLE: SOLID;
			border-left-color: #B2B6D7;
			border-right-color: #B2B6D7;
			border-top-color: #E2E3F0;
			border-bottom-color: #E2E3F0;
			height:18;	
	   }
	
	div.tableContainer {
		width: 65%;		/* table width will be 99% of this*/
		height: 295px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

table {
	width: 99%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: auto;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}




</style>

	<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../eOT/js/OTMessages.js"></script> -->
	<script language="JavaScript" src="../../eOT/js/SurgeryHistory.js"></script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; 	visibility:hidden;' bgcolor='blue'>	
</div>
<form name="SurgeryHistoryQryResultsForm" id="SurgeryHistoryQryResultsForm">
<div id="tableContainer">
<table class='grid' cellpadding="3" cellspacing="0" border="1" width="100%" align='3'>

	<THEAD>
		<TR>
			<th class ='columnheader'> <fmt:message key="eOT.OperationDate.Label" bundle="${ot_labels}"/></th>
			<th class ='columnheader'> <fmt:message key="Common.operation.label" bundle="${common_labels}"/></th>
			<th class ='columnheader'> <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
			<th class ='columnheader'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
			<th class ='columnheader'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
			<th class ='columnheader'><fmt:message key="Common.notes.label" bundle="${common_labels}"/></th>
		</TR>
	</THEAD>
<% 
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String oper_code = checkForNull(request.getParameter("oper_code"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	//String from_date = checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("from_date"),"DMY","en",locale));
	//String to_date = checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("to_date"),"DMY","en",locale));
	String from_date = checkForNull(request.getParameter("from_date"));
    String to_date = checkForNull(request.getParameter("to_date"));
	String called_from = checkForNull(request.getParameter("called_from"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String login_user = (String) session.getValue("login_user");
	String oper_date="";
	//String oper_num="";
	String oper_status="";
	
	String check_in_time =	"";
	String check_in_or_time="";
	String check_in_rec_time="";
	String check_out_rec_time="";
	String patient_class="";
	String episode_type="";
	String encounter_id="";
	String episode_id="";
	String speciality_code="";
	String booking_num="";
	String order_id="";
	String doc_level="";
	String SQL="";
	//Added by lakshmi against IN29152 starts here
	String check_out_or_time="";
	String recovery_room_desc="";
	//Added by lakshmi against IN29152 ends here

	// SQL="SELECT TO_CHAR(OPER_DATE,'DD/MM/YYYY',DECODE('"+locale+"','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,OPER_NUM,OPER_CODE,GET_DESC('"+locale+"'OPER_DESC) OPER_DESC ,SURGEON_CODE,SURGEON_NAME,OPER_STATUS,  TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),PATIENT_CLASS,EPISODE_TYPE,ENCOUNTER_ID, EPISODE_ID,SPECIALITY_CODE,BOOKING_NUM,ORDER_ID FROM OT_SURGERY_HISTORY WHERE LANGUAGE_ID='"+locale+"' and PATIENT_ID=?";
//Commented By Muthukumar against lN:029152 on 12-10-11
/*	 SQL="SELECT TO_CHAR(OPER_DATE,'DD/MM/YYYY',DECODE('"+locale+"','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,OPER_NUM,OPER_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',OPER_CODE) OPER_DESC,SURGEON_CODE,GET_DESC('"+locale+"','AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',SURGEON_CODE) SURGEON_NAME,OPER_STATUS, TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),PATIENT_CLASS,EPISODE_TYPE,ENCOUNTER_ID, EPISODE_ID,SPECIALITY_CODE,BOOKING_NUM,ORDER_ID,DOCUMENTATION_LEVEL FROM OT_SURGERY_HISTORY WHERE LANGUAGE_ID='"+locale+"' and PATIENT_ID=?";*/


//Below Query is Modified By Muthukumar against lN:029152 on 12-10-11
		// SQL="SELECT TO_CHAR(OPER_DATE,'DD/MM/YYYY',DECODE('"+locale+"','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,OPER_NUM,OPER_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',OPER_CODE) OPER_DESC,SURGEON_CODE,GET_DESC('"+locale+"','AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',SURGEON_CODE) SURGEON_NAME,OPER_STATUS, TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI'),PATIENT_CLASS,EPISODE_TYPE,ENCOUNTER_ID, EPISODE_ID,SPECIALITY_CODE,BOOKING_NUM,ORDER_ID,DOCUMENTATION_LEVEL FROM OT_SURGERY_HISTORY WHERE LANGUAGE_ID='"+locale+"' and PATIENT_ID=?";
//Below Query is Modified By Muthukumar against lN:029152 on 12-10-11
	/*(1)TO_CHAR(OPER_DATE,'DD/MM/YYYY'),(2)OPER_NUM,(3)PER_CODE,(4)OPER_DESC,(5)SURGEON_CODE,(6)SURGEON_NAME,(7)OPER_STATUS, (8) TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),(9)TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),(10)TO_CHAR(CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),(11)TO_CHAR(CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),(12)PATIENT_CLASS, (13)EPISODE_TYPE, (14) ENCOUNTER_ID, (15) EPISODE_ID FROM OT_SURGERY_HISTORY WHERE PATIENT_ID=?";*/

		
	/*if(sex.length()>0){
		SQL+= " AND SEX=?";
	}*/

	//Below Query is Modified By LAKSHMI against lN:029152 oN 16/08/2012 STARTS HERE
/*		 SQL="SELECT TO_CHAR(A.OPER_DATE,'DD/MM/YYYY',DECODE('en','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,A.OPER_NUM,A.OPER_CODE, GET_DESC('en','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPER_DESC,A.SURGEON_CODE,GET_DESC('en','AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',A.SURGEON_CODE) SURGEON_NAME,A.OPER_STATUS, TO_CHAR(A.CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),B.RECOVERY_ROOM_DESC,TO_CHAR(A.CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI'),A.PATIENT_CLASS,A.EPISODE_TYPE,A.ENCOUNTER_ID, A.EPISODE_ID,A.SPECIALITY_CODE,A.BOOKING_NUM,A.ORDER_ID,A.DOCUMENTATION_LEVEL FROM OT_SURGERY_HISTORY A, OT_RECOVERY_ROOM B WHERE A.LANGUAGE_ID='"+locale+"' and A.PATIENT_ID= ? AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.RECVERY_ROOM_CODE = B.RECOVERY_ROOM_CODE"; */
//Below Query is Modified By LAKSHMI against lN:029152 on 16/08/2012 ENDS HERE
// Modified by DhanasekarV against  SurgeryQuery result is not appearing when recovery room code is null   on 12/10/2012

		 SQL="SELECT TO_CHAR(A.OPER_DATE,'DD/MM/YYYY',DECODE('en','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) OPER_DATE,A.OPER_NUM,A.OPER_CODE, GET_DESC('en','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPER_DESC,A.SURGEON_CODE,GET_DESC('en','AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',A.SURGEON_CODE) SURGEON_NAME,A.OPER_STATUS, TO_CHAR(A.CHECK_IN_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI'),B.RECOVERY_ROOM_DESC,TO_CHAR(A.CHECK_INTO_RECOVERY_TIME,'DD/MM/YYYY HH24:MI'),TO_CHAR(A.RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI'),A.PATIENT_CLASS,A.EPISODE_TYPE,A.ENCOUNTER_ID, A.EPISODE_ID,A.SPECIALITY_CODE,A.BOOKING_NUM,A.ORDER_ID,A.DOCUMENTATION_LEVEL FROM OT_SURGERY_HISTORY A, OT_RECOVERY_ROOM B WHERE A.LANGUAGE_ID='"+locale+"' and A.PATIENT_ID= ? AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID(+) AND A.RECVERY_ROOM_CODE = B.RECOVERY_ROOM_CODE(+)";//MMS-QH-CRF-0199

//END 


	if(facility_id.length()>0){
		//SQL+= " AND OPERATING_FACILITY_ID=?";
		//Modified By LAKSHMI against lN:029152
		SQL+= " AND A.OPERATING_FACILITY_ID=?";

	}
	
	if(surgeon_code.length()>0){
		//SQL+= " AND SURGEON_CODE=?";
		//Modified By LAKSHMI against lN:029152
		SQL+= " AND A.SURGEON_CODE=?";
	}
	if(from_date.length()>0 && to_date.length()>0){
			//SQL+= " AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')";
			//Modified By LAKSHMI against lN:029152
			SQL+= " AND A.OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')";
	}else if(from_date.length()>0){
		//SQL+= " AND OPER_DATE > = TO_DATE(?,'DD/MM/YYYY')";
		//Modified By LAKSHMI against lN:029152
		SQL+= " AND A.OPER_DATE > = TO_DATE(?,'DD/MM/YYYY')";
	}else if(to_date.length()>0){
//		SQL+=" AND OPER_DATE<=TO_DATE(?,'DD/MM/YYYY')";
//Modified By LAKSHMI against lN:029152
SQL+=" AND A.OPER_DATE<=TO_DATE(?,'DD/MM/YYYY')";
	}

	if(oper_code.length()>0){
		//SQL+= " AND OPER_CODE=?";
		//Modified By LAKSHMI against lN:029152
		SQL+= " AND A.OPER_CODE=?";
	}
	
	String	qryVal="";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	int sno=0;
	String result="";
	try{
		con = ConnectionManager.getConnection(request);
		/*if(called_from.equals("OPER_REG")){
			pstmt = con.prepareStatement(OPER_REG_SQL);
			pstmt.setString(1,patient_id);
			pstmt.setString(1,oper_num);
		}else{*/

			pstmt = con.prepareStatement(SQL);
			pstmt.setString(++sno,patient_id);
			if(facility_id.length()>0){
				pstmt.setString(++sno,facility_id);
			}
			//SURGEON FILTER
			if(surgeon_code.length()>0)
				pstmt.setString(++sno,surgeon_code);
			//BOTH FROM_DATE AND TO_DATE FILTER
			if(from_date.length()>0 && to_date.length()>0){
				pstmt.setString(++sno,from_date);
				pstmt.setString(++sno,to_date);
			}else if(from_date.length()>0){
				pstmt.setString(++sno,from_date);
			} else if(to_date.length()>0){
				pstmt.setString(++sno,to_date);
			}
			//OPER_CODE FILTER
			if(oper_code.length()>0)
				pstmt.setString(++sno,oper_code);
		//}

		rst = pstmt.executeQuery();
		int index=0;
		while(rst.next()){
		   qryVal=(index%2==0)?"gridData":"gridData";
		   ++index;
		   oper_date = checkForNull(rst.getString(1));
		   //oper_date=com.ehis.util.DateUtils.convertDate(oper_date,"DMY","en",locale);
		   oper_num = checkForNull(rst.getString(2));
		   oper_code = checkForNull(rst.getString(3));
		   surgeon_code = checkForNull(rst.getString(5));
		   oper_status = checkForNull(rst.getString(7));
		   check_in_time = checkForNull(rst.getString(8));
		  // System.out.println("check_in_time in SurgeryHistoryQryResults "+check_in_time);
		   //check_in_or_time = checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString(9),"DMYHM","en",locale));
		   check_in_or_time = checkForNull(rst.getString(9));
		   check_out_or_time = checkForNull(rst.getString(10));//Added by lakshmi against IN29152
		   recovery_room_desc = checkForNull(rst.getString(11));//Added by lakshmi against IN29152
		   
		  /* check_in_rec_time = checkForNull(rst.getString(10));
		   check_out_rec_time = checkForNull(rst.getString(11));
		   patient_class=checkForNull(rst.getString(12));
		   episode_type=checkForNull(rst.getString(13));
		   encounter_id=checkForNull(rst.getString(14));
		   episode_id=checkForNull(rst.getString(15));
		   speciality_code=checkForNull(rst.getString(16));
		   booking_num=checkForNull(rst.getString(17));
		   order_id = checkForNull(rst.getString(18));
		   doc_level = checkForNull(rst.getString(19));*/ //Commented by lakshmi against IN29152
			
		   //Modified by lakshmi agisnt IN29152
		   check_in_rec_time = checkForNull(rst.getString(12));
		   check_out_rec_time = checkForNull(rst.getString(13));
		   patient_class=checkForNull(rst.getString(14));
		   episode_type=checkForNull(rst.getString(15));
		   encounter_id=checkForNull(rst.getString(16));
		   episode_id=checkForNull(rst.getString(17));
		   speciality_code=checkForNull(rst.getString(18));
		   booking_num=checkForNull(rst.getString(19));
		   order_id = checkForNull(rst.getString(20));
		   doc_level = checkForNull(rst.getString(21));
		   //result = facility_id+"::"+patient_id+"::"+oper_date+"::"+oper_num+"::"+oper_code+"::"+surgeon_code
			 
	   	 
%>
<tr>
	<td width='' nowrap id='orderctl<%=index%>' style='cursor:pointer' class='gridDataBlue' onClick="displayToolTip('<%=facility_id%>','<%=patient_id%>','<%=oper_num%>','<%=oper_code%>','<%=surgeon_code%>','<%=oper_code%>','<%=patient_class%>','<%=encounter_id%>','<%=episode_id%>','<%=episode_type%>','<%=speciality_code%>','<%=booking_num%>','<%=login_user%>','<%=called_from%>',this,'imgArrow<%=index%>');" onMouseOver='hideToolTip();'>
<a class='gridDataBlue' href="javascript:displayToolTip('<%=facility_id%>','<%=patient_id%>','<%=oper_num%>','<%=oper_code%>','<%=surgeon_code%>','<%=oper_code%>','<%=patient_class%>','<%=encounter_id%>','<%=episode_id%>','<%=episode_type%>','<%=speciality_code%>','<%=booking_num%>','<%=login_user%>','<%=called_from%>',this,'imgArrow<%=index%>');\">
	<%=oper_date%><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=index%>' id='imgArrow<%=index%>'></td>
	
	<td class="<%=qryVal%>"> <%=checkForNull(rst.getString(4))%> </td>
	<td class="<%=qryVal%>"> <%=checkForNull(rst.getString(6))%> </td>
	 
	 
	<td class="<%=rst.getString(7)%>" style="background-color: <%=(String)color_array.get(color_array.indexOf(rst.getString(7))+2)%>;"  width='3%'></td>
	 
	<td class="<%=qryVal%>" width="8%" align="center">
	<!--<a class='gridlink' href="javascript:callSurgeryDetails('<%=facility_id%>','<%=patient_id%>','<%=oper_date%>','<%=oper_num%>','<%=oper_code%>','<%=surgeon_code%>','<%=check_in_time%>','<%=check_in_or_time%>','<%=check_in_rec_time%>','<%=check_out_rec_time%>','<%=patient_class%>','<%=encounter_id%>','<%=episode_id%>','<%=episode_type%>','<%=speciality_code%>','<%=booking_num%>','<%=order_id%>','<%=login_user%>')"> <fmt:message key="Common.details.label" bundle="${common_labels}"/></a></td>--> <!--Commented by lakshmi against IN29152-->

	<!--Modified by lakshmi against IN29152-->
	<a class='gridlink' href="javascript:callSurgeryDetails('<%=facility_id%>','<%=patient_id%>','<%=oper_date%>','<%=oper_num%>','<%=oper_code%>','<%=surgeon_code%>','<%=check_in_time%>','<%=check_in_or_time%>','<%=check_out_or_time%>','<%=recovery_room_desc%>','<%=check_in_rec_time%>','<%=check_out_rec_time%>','<%=patient_class%>','<%=encounter_id%>','<%=episode_id%>','<%=episode_type%>','<%=speciality_code%>','<%=booking_num%>','<%=order_id%>','<%=login_user%>')"> <fmt:message key="Common.details.label" bundle="${common_labels}"/></a></td>
	<td class="<%=qryVal%>" >

<a class ='gridlink' href="javascript:callSurgeryNotes('<%=facility_id%>','<%=oper_num%>','<%=speciality_code%>',
'<%=doc_level%>')"> <fmt:message key="Common.notes.label" bundle="${common_labels}"/> </a></td>
</tr>
<%	}
    if(index==0){
		out.println("<script>callNoRecords();</script>");
	}
	}catch(Exception e){
		 System.err.println("Err Msg in SurgeryHistoryQryResults.jsp"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>
 
</table>
</div>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">

<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>	
	</div>
</form>
</html>





