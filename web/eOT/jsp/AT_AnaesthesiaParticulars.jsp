<!DOCTYPE html>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.CommonBean" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<%@page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>
<%
	String locale = (String)session.getAttribute("LOCALE"); 
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/dchk.js"></Script>
<script language="javascript" src="../../eOT/js/AT_PostAnaesthesia.js"></script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript">
 function loadFinishTime(){
	var formObj = document.forms[0];
	var locale =formObj.locale.value;
	var str = document.forms[0].finish_date_time.value;
	if(str.length>0){
		var arr = str.split(" ");
		document.forms[0].finish_date.value=arr[0];
		document.forms[0].finish_time.value=arr[1];
	}
	var str1 = document.forms[0].rec_start_date_time.value;
	if(str1.length>0){
		var arr = str1.split(" ");
		var rec_start_date=convertDate(arr[0],"DMY","en",locale);
		document.forms[0].rec_start_date.value=rec_start_date;
		document.forms[0].rec_start_time.value=arr[1];
	}
	var str2 = document.forms[0].rec_finish_date_time.value;
	if(str2.length>0){
		var arr = str2.split(" ");
		var rec_finish_date=convertDate(arr[0],"DMY","en",locale);
		document.forms[0].rec_finish_date.value=rec_finish_date;
		document.forms[0].rec_finish_time.value=arr[1];
	}
 }
 
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'AnaesthesiaParticularsForm' >
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>'>
<% 

	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String accession_num = CommonBean.checkForNull(request.getParameter("accession_num"));
	String anaesthesia_srl_no = CommonBean.checkForNull(request.getParameter("anesthesia_srl_no"));
	String anaesthesia_code = CommonBean.checkForNull(request.getParameter("anaesthesia_code"));
	String start_time = CommonBean.checkForNull(request.getParameter("start_time"));
	String end_time = CommonBean.checkForNull(request.getParameter("end_time"));
	String doc_comp_yn="";
	/* Commented against SKR-SCF-1286 */
	//String rec_start_date_time = CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("rec_start_date_time"),"DMYHM","en",locale));
	//String rec_finish_date_time = CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("rec_finish_date_time"),"DMYHM","en",locale));
	/* Commented against SKR-SCF-1286 */
	/* Added against SKR-SCF-1286 */
	String rec_start_date_time = CommonBean.checkForNull(request.getParameter("rec_start_date_time"));
	String rec_finish_date_time = CommonBean.checkForNull(request.getParameter("rec_finish_date_time"));
	/* Added against SKR-SCF-1286 */

	String aneasthetist_code1=CommonBean.checkForNull(request.getParameter("anaesthetist_code1"));
	String aneasthetist_code2=CommonBean.checkForNull(request.getParameter("anaesthetist_code2"));	
	String anaesthestist_desc1="";
	String SQL1="SELECT ANAESTHESIA_CODE CODE,to_char(START_TIME,'dd/mm/yyyy hh24:mi') ST_TIME1,to_char(END_TIME,'dd/mm/yyyy hh24:mi') END_TIME1,POSTOP_DONE_YN  FROM  AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
	String SQL2="SELECT SHORT_DESC FROM AM_ANAESTHESIA_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ANAESTHESIA_CODE =?";
	String SQL3="SELECT SHORT_NAME FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = ? AND PRACT_TYPE = 'AN' AND  PHYSICIAN_ID=?";
	String anaesthesia_desc = ""; 
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;	
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,anaesthesia_srl_no);
		rst = pstmt.executeQuery();
		while(rst.next()){
			anaesthesia_code = CommonBean.checkForNull(rst.getString(1));
			//start_time = CommonBean.checkForNull(rst.getString(2));
			start_time=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString(2),"DMYHM","en",locale));
			//end_time = CommonBean.checkForNull(rst.getString(3));
			end_time=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString(3),"DMYHM","en",locale));
			doc_comp_yn = CommonBean.checkForNull(rst.getString(4));
		}

		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

		pstmt = con.prepareStatement(SQL2);
		pstmt.setString(1,anaesthesia_code);
		rst = pstmt.executeQuery();
		while(rst.next()){
			anaesthesia_desc = CommonBean.checkForNull(rst.getString(1));
		}

		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

 if(aneasthetist_code1.length()!=0)
		{
		pstmt = con.prepareStatement(SQL3);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,aneasthetist_code1);
		rst = pstmt.executeQuery();
		while(rst.next()){
			anaesthestist_desc1 = CommonBean.checkForNull(rst.getString(1));
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		}


 if(aneasthetist_code2.length()!=0)
		{
			pstmt = con.prepareStatement(SQL3);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,aneasthetist_code2);
		rst = pstmt.executeQuery();
		while(rst.next()){
			//anaesthestist_desc2 = CommonBean.checkForNull(rst.getString(1));
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		}	
	}catch(Exception e){
		out.println(e.getMessage());
		System.err.println(" Err Msg in AnaesthesiaParticulars.jsp"+e.getMessage());
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr>
	<td class="COLUMNHEADER" colspan=4>
		<fmt:message key="eOT.AnaesthesiaParticulars.Label"  bundle="${ot_labels}"/> 
	</td>
</tr>
<tr>
	<td class='label' width="25%">
		<fmt:message key="Common.AnaesthesiaDetails.label" bundle="${common_labels}"/>		
	</td>
    <td class='fields' width="25%" >
		<input type='text' name='anaesthesia_desc' id='anaesthesia_desc'  value='<%=anaesthesia_desc%>' size='15' disabled > 
	</td>
	<td class='label' width="25%" >
	<fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/>
	</td>

	<td class='fields' width="25%"  >
		<input type='text' name='start_date' id='start_date' size='15' value='<%=start_time%>' disabled > 
	</td>
</tr>
<tr>
	 <td class='label' width="25%" >
	 <fmt:message key="eOT.FinishDateTime.Label"  bundle="${ot_labels}"/>
	 </td>
<%if(!doc_comp_yn.equals("Y")) {%>
     <td  class='fields' width="25%" colspan="3">
		<input type='text' name='finish_date' id='finish_date'  size='8' readonly > 
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('finish_date'); "  > <img src='../../eCommon/images/mandatory.gif'></img>
		<input type='text' name='finish_time' id='finish_time' size='3'  maxlength='5'onBlur="checkTimeFormat(this)" >
	</td>
<%} else {%>
     <td  class='fields' width="25%" colspan="3">
		<input type='text' name='finish_date' id='finish_date'  size='8' readonly > 
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('finish_date'); "  > <img src='../../eCommon/images/mandatory.gif'></img>
		<input type='text' name='finish_time' id='finish_time' size='3'  maxlength='5'onBlur="checkTimeFormat(this)" >
	</td>
<%}%>
</tr>
<tr>
	<td class="COLUMNHEADER" colspan=4>
		 <fmt:message key="eOT.RecoveryParticulars.Label"  bundle="${ot_labels}"/>
	</td>
</tr>
<tr>
	 <td  class='label' width="25%" >
	  <fmt:message key= "eOT.RecoveryStartTime.Label" bundle="${ot_labels}"/>	
	 </td>
<%if(!doc_comp_yn.equals("Y")) {%>
	 <td class='fields' width="25%" >
		<input type='text' name='rec_start_date' id='rec_start_date'  size='10' readonly > 
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('rec_start_date'); "  > 
		<img src='../../eCommon/images/mandatory.gif'></img>
		<input type='text' name='rec_start_time' id='rec_start_time'  size='6' onBlur="checkTimeFormat(this)" maxlength="5">
	</td>
<%} else {%>
	 <td class='fields' width="25%" >
		<input type='text' name='rec_start_date' id='rec_start_date'  size='10' disabled> 
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('rec_start_date'); " disabled > 
		<img src='../../eCommon/images/mandatory.gif'></img>
		<input type='text' name='rec_start_time' id='rec_start_time'  size='6' onBlur="checkTimeFormat(this)" maxlength="5" disabled>
	</td>
<%}%>
	<td class='label' width="25%">
		 <fmt:message key="eOT.RecoveryEndTime.Label"  bundle="${ot_labels}"/>		
	</td>
<%if(!doc_comp_yn.equals("Y")) {%>
	<td class='fields' width="25%">
		<input type='text' name='rec_finish_date' id='rec_finish_date'  size='10' readonly > 
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('rec_finish_date'); "  > <img src='../../eCommon/images/mandatory.gif'></img>
		<input type='text' name='rec_finish_time' id='rec_finish_time'  size='6' onBlur="checkTimeFormat(this)" maxlength="5"> 
	</td>
<%} else { %>
<td class='fields' width="25%">
		<input type='text' name='rec_finish_date' id='rec_finish_date'  size='10' disabled> 
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('rec_finish_date'); " disabled > 
		<img src='../../eCommon/images/mandatory.gif'></img>
		<input type='text' name='rec_finish_time' id='rec_finish_time'  size='6' onBlur="checkTimeFormat(this)" maxlength="5" disabled> 
	</td>
<%}%>
</tr>
	<input type='hidden' name='rec_start_date_time' id='rec_start_date_time'  size='8' value='<%=rec_start_date_time%>'  > 
	<input type='hidden' name='rec_finish_date_time' id='rec_finish_date_time'  size='8' value='<%=rec_finish_date_time%>' >
	<input type='hidden' name='finish_date_time' id='finish_date_time'  size='8' value='<%=end_time%>'  >
	<input type='hidden' name='facility_id' id='facility_id'  size='8' value='<%=facility_id%>'  >
	<input type='hidden' name='accession_num' id='accession_num'  size='8' value='<%=accession_num%>'  >
	<input type='hidden' name='locale' id='locale'  size='8' value='<%=locale%>'  >
<script>loadFinishTime();</script>
</form>
</body>

</html>

