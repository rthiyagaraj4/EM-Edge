<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" 
		import= "java.sql.Connection,java.sql.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository"%>
<html>
<head>                        
	<%
		String locale = (String)session.getAttribute("LOCALE");
		request.setCharacterEncoding("UTF-8");	
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script src="../../eOT/js/Booking.js" language="javascript"></script>
	<script src="../../eOT/js/PickList.js" language="javascript"></script>
	<script src="../../eOT/js/OTCommon.js" language="javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<!--Added by lakshmi against crf-0146-->
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<% 
 String empty = "".intern();
 String facilityId=(String) session.getValue("facility_id"); 
 String flag=checkForNull(request.getParameter("flag"));
 String strPatientId=checkForNull(request.getParameter("patientid"));
 String strBookingDate=checkForNull(request.getParameter("schedule_date"));
 String strTheatre=checkForNull(request.getParameter("theatre"));
 String strTheatreType=checkForNull(request.getParameter("theatre_type"));
 String strButton=empty;
 String strMethod=empty;
 String sql=empty;
   //db related variables
  Connection conn=null;
  ResultSet rs=null;
  Statement stmt=null;

 //Added by lakshmi against CRF-0146 starts here
 String strSourceType=checkForNull(request.getParameter("source_type"));
 String strSourceDesc=checkForNull(request.getParameter("source_desc"));
 String strSourceCode=checkForNull(request.getParameter("source_code")); 
 String strSysDate = "";//Added by lakshmi on 31/01/2012

 PreparedStatement pstmt_sm_report_display = null;
 PreparedStatement pstmt=null;//Added by lakshmi on 31/01/2012
 ResultSet rs1=null;//Added by lakshmi on 31/01/2012
 ResultSet rst_sm_report_display=null;
 conn=ConnectionManager.getConnection(request);

     //Added by lakshmi on 31/01/2012 starts here against crf-0146
		pstmt=conn.prepareCall("SELECT to_char(SYSDATE,'dd/mm/yyyy') SYSDATE1 from DUAL");
		rs1=pstmt.executeQuery();

		if(rs1!=null &&rs1.next()==true)
		{
			strSysDate=com.ehis.util.DateUtils.convertDate(rs1.getString("SYSDATE1"),"DMY","en",locale);
		}
		if(rs1!=null)		rs1.close();
		if(pstmt !=null) pstmt.close();
		//Added by lakshmi on 31/01/2012 starts here against crf-0146

	String Ot_param="";
	String sql_sm_report="select NVL(PICKLIST_BY_WARD,'N') PICKLIST from OT_PARAM where rownum = 1";
	pstmt_sm_report_display=conn.prepareStatement(sql_sm_report);
	rst_sm_report_display=pstmt_sm_report_display.executeQuery();
	if(rst_sm_report_display !=null && rst_sm_report_display.next())
	   {
		Ot_param=checkForNull(rst_sm_report_display.getString("PICKLIST"));		
	   }
	   if(rst_sm_report_display!=null)rst_sm_report_display.close();
	   if(pstmt_sm_report_display!=null)pstmt_sm_report_display.close();
  

  if(flag.equals("PRINT")){
 	strButton=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels");
	strMethod="callReport()";
 }else{
 	strButton=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Generate.label","common_labels");
	strMethod="callPickList()";
 }
		
		String PatIDLen="";		

		sql ="SELECT PATIENT_ID_LENGTH from  mp_param";		
		
		try{
            stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs!= null && rs.next())
			{
				PatIDLen = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
			}

		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();

		}finally{
			try{

			if(rs!=null)       rs.close();
			if(stmt!=null)       stmt.close();
			if(conn!=null)  ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}
	
%>

<body  onLoad="callCommonServlet('1','<%=locale%>');" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PickGenByDate" id="PickGenByDate" >
<BR><BR><BR><BR><BR><BR><BR>
<table cellpadding=3  cellspacing="0" border="0" width="60%" align="center">

<tr>
	<td  class='label' width="25%">
	<fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/> 
	</td>
	<td class='fields' width="25%">
		<input type='text' name='schedule_date' id='schedule_date' size='11'   value='<%=strBookingDate%>'  maxlength='10' onBlur="isValidDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif"	
			onClick="return showCalendar('schedule_date','dd/mm/y');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>		
</tr>
<tr>
	<td   class='label' width="25%">
	<fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/> 
	</td>
	<td class='fields' width="25%">

	<select name='theatre_type' id='theatre_type'  DB_VALUE="<%=strTheatreType%>" onChange="callCommonServlet('2','<%=locale%>')" >
	<option value=''>
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	</option>
	</select>
	</td>		
</tr>
<tr>
	<td   class='label' width="25%" >
	<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	</td>

	<td  class='fields'  width="25%" >

	<select name='theatre' id='theatre' DB_VALUE="<%=strTheatre%>" >
	<option value=''>
	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	</select>
	</td>		
</tr>

<!--Added by lakshmi against CRF-0146 starts here-->
<%if(Ot_param.equalsIgnoreCase("Y")){%>
<tr>
		<td class='label'>
			<fmt:message key="Common.SourceType.label" bundle="${common_labels}"/>  
		</td>
		<td class="fields" colspan='4'>
			<select class="fields" name='source_type' id='source_type' onchange="clearSource();" value="<%=strSourceType%>">
			<!--<option value=''>
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
			</option>-->
			<option value='W'>
				<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
			</option>
			<option value='C'>
				<fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
			</option>
			<option value='E'>
				<fmt:message key="Common.referral.label" bundle="${common_labels}"/>
			</option>
		</select>
		<input type='hidden' name='source_code' id='source_code'  value="<%=strSourceCode%>" >
		<input type='text' name='source_desc' id='source_desc' size='20' value="<%=strSourceDesc%>" class="fields" onBlur="if(this.value!='') searchSourceTypeSelect(source_desc); else callchangeMoreIcon(); ">
		<input type='button' class='button' name='quest6' id='quest6' value='?' onClick="searchSourceTypeSelect(source_desc);" >
		<!--  Commented by DhanasekarV against incident 30512 JD-CRF-0146
			<div id='more_img' style='position:absolute;visibility:hidden;'><img src='../../eOT/images/more.gif' onmouseover="if(source_desc.value!='')Tip(getLongNameRefSrc());else Untip();" onmouseout="UnTip()"></img></div> -->  
	</td>
	</tr>
	<%}%>
<!--Added by lakshmi against CRF-0146 ends here-->

<tr > <td  class='label'  width="25%">
<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td align='left'>
<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onBlur="if(this.value!='')callPatSearch();clearDesc();" value= "<%=strPatientId%>" onkeypress="return CheckForSpecChars(event)">
<input type='button' class='button' value='?' name='surButton' id='surButton' 
 onClick="callPatSearch();">
</td>
</tr>
<tr > 
<td  class='label'  width="25%">
<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
</td>
<td align='left'>
<input type='text' name='patientname' id='patientname' maxlength='60' size='30'  readonly>
</td>
</tr>



<tr > 
	<td></td>
	<td colspan="2">
	<input type='button' class='button' name='Generate' id='Generate' value='<%=strButton%>' OnClick="<%=strMethod%>">
	<!--Added by lakshmi against CRF-0146-->
	<input type='button' class='button' name='Reset' id='Reset' align='Left' value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' OnClick="reset()">
	</td>
</tr>
</table>
<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">	
<input type='hidden' name='flag' id='flag'  value="<%=flag%>"%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
 <!--Added by lakshmi against CRF-0146-->
<input type='hidden' name='HLongRefSrcId' id='HLongRefSrcId' value="">
<input type='hidden' name='Ot_param' id='Ot_param' value="<%=Ot_param%>">
<input type='hidden' name='system_date' id='system_date' value="<%=strSysDate%>"><!--Added by lakshmi on 31/01/2012-->

</form>
</body>
</html>

