<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*,eOR.*,eOR.Common.* , ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
		String locale = (String) session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
			<SCRIPT language='javascript' src='../../eCommon/js/dchk.js' ></SCRIPT>
			<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
			<SCRIPT language='javascript' src='../../eCommon/js/FieldFormatMethods.js' ></SCRIPT>
			<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script language="javascript" src="../js/OncologyRegimen.js"></script>
			<script language="javascript" src="../js/PhCommon.js"></script>
			<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<title>Schedule</title>
		</head>
<%
try{

	String start_date_time	= request.getParameter("start_date"); 
	String drug_code		= request.getParameter("drug_code"); 
	String srl_no			= request.getParameter("srl_no"); 
	String no_of_cycle		= request.getParameter("no_of_cycle"); 
	String repeat_durn_type = request.getParameter("repeat_durn_type");
	String order_type_flag	= request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");


	String hrsHtml = "";
	String hrsHtmlInital = "";
	String hrsHtmlFinal = "";
	String bean_id			= request.getParameter("bean_id");
	String bean_name		= request.getParameter("bean_name");
	OncologyRegimenBean bean= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	
	String facility_id	= "";
	facility_id	= (String) session.getValue("facility_id");

	HashMap hm = bean.getCycleDetails();
	HashMap hm_details = null;
	System.err.println("OncologyCycleScheduleFreq.jsp=============dssd======40==getCycleDetails==>"+bean.getCycleDetails());
	if(hm!=null && hm.size()>0){
		hm_details = (HashMap)hm.get(drug_code+srl_no);//
	}
		System.err.println("OncologyCycleScheduleFreq.jsp==51===>");
%>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="onCologyCycleScheduleFreq" id="onCologyCycleScheduleFreq">
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<table border="0"  cellpadding=0 cellspacing=0 width="100%" style="top-margin:0">
<%
		System.err.println("OncologyCycleScheduleFreq.jsp==60==repeat_durn_type=>"+repeat_durn_type);
			if(repeat_durn_type.equals("W") )
			{
				hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='100%' align='center'><th align='left' width ='1%'></th><th align='left' width ='5%' >Cycle Week</th><th align='center' width ='2%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' width ='5%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels")+"</th><th  align='center' width ='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
			}else if(repeat_durn_type.equals("D")){
			
			hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><td></td><table border='1' width='100%' align='center'><th align='left' width ='1%' > </th><th align='center' width ='3%' >Cycle Day</th><th align='center' width ='4%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels")+"</th><th  align='center' width ='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
			}

			if(repeat_durn_type.equals("L")){
				
				hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='100%' align='center'><th align='left' width ='1%' ></th><th align='left' width ='5%' >Cycle Month</th><th align='center' width ='2%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' width ='5%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels")+"</th><th  align='center' width ='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	

			}

			hrsHtmlFinal = "</table></tr></table>";
			hrsHtml =hrsHtmlInital + hrsHtml + hrsHtmlFinal ; 
%>
<td id="timeLegend"><%=hrsHtml%></td>


<%
			System.err.println("OncologyCycleScheduleFreq.jsp==82===>");

	ArrayList time = new ArrayList();
	ArrayList time_list = null;
	String day_list = "";
	String start_date = "";
	String end_date   = "";
	String cycle_no   = "";
	String first_start_date = "";
	String disable_cycle    = "";
	int no_of_day		=1;
	String cycle_checked		= "";//ML-MMOH-CRF-1004
	String cycle_checked_yn	= "";//ML-MMOH-CRF-1004
	String def_admin_day    = "";//ML-MMOH-CRF-1228

	if(repeat_durn_type.equals("W"))
			no_of_day = 7;
	/*else{ 
		if(repeat_durn_type.equals("L"))
		   no_of_day = 31;


	} */

	

	for(int i=0;i<Integer.parseInt(no_of_cycle);i++){
		start_date = start_date_time;
		if(hm_details!=null){
			time_list	= (ArrayList)hm_details.get("cycle_"+i);
			time		= (ArrayList)time_list.get(0);
			day_list	= (String)time_list.get(1);
			cycle_no	= (String)time_list.get(2);
			start_date  = (String)time_list.get(3);
			end_date	= (String)time_list.get(4);
			cycle_checked_yn	= (String)time_list.get(5);//ML-MMOH-CRF-1004
		}
		if(i==0)
		first_start_date = start_date;
		disable_cycle = "";
		
		if(order_type_flag.equals("Existing")){
			disable_cycle = "disabled";
		}
		if(repeat_durn_type.equals("L")){
			no_of_day = 31;	
		}
		if(cycle_checked_yn.equals("Y")){//ML-MMOH-CRF-1004 - start
			cycle_checked = "checked";
			cycle_checked_yn = "Y";
		}
		else{
			cycle_checked = "";
			cycle_checked_yn = "N";
		}//ML-MMOH-CRF-1004 - end
%>
<tr><input type="checkbox" name="cycle_checked_yn_<%=i%>" id="cycle_checked_yn_<%=i%>" <%=cycle_checked%> onclick = "assignValueSchFreq(this,'<%=i%>')" value="<%=cycle_checked_yn%>"><!--ML-MMOH-CRF-1004-->

<%if(repeat_durn_type.equals("W") || repeat_durn_type.equals("L")){%>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td align= "right" width = "10%"> <input type="text" name="cycle_<%=i%>" id="cycle_<%=i%>" size="5" maxlength="5" onKeyPress="return(ChkNumberInput(this,event,'0'))"  onchange = "calcStartDateForWeek(this,'<%=i%>','N','C')" value = '<%=cycle_no%>' <%=disable_cycle%> tabIndex="1" ></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!--maxlength="5" added for ICN-65327 -->
	<%}else{%>
&nbsp;&nbsp;&nbsp;&nbsp;<td align= "right" width = "10%"> <input type="text" name="admin_day_<%=i%>" id="admin_day_<%=i%>" size="5" maxlength="5" onKeyPress="return(ChkNumberInput(this,event,'0'))" onchange = "calcStartDateForDay(this,'<%=i%>','Y')" value = '<%=day_list%>' <%=disable_cycle%> tabIndex="1" ></td>&nbsp;&nbsp;&nbsp;&nbsp; <!--maxlength="5" added for ICN-65327 -->

<%	}

if(repeat_durn_type.equals("W") || repeat_durn_type.equals("L")){
%>
<td width = "2%"><select name="admin_day_<%=i%>" id="admin_day_<%=i%>" onchange = "calcStartDateForWeek(this,'<%=i%>','N','');" <%=disable_cycle%>>
<%
for(int j=1;j<=no_of_day;j++){
	if(j==Integer.parseInt(day_list)){
%>
<option value="<%=j%>" selected><%=j%> </option>
<%}
else{%>
<option value="<%=j%>" ><%=j%> </option>
<%}
}%>
</select>
</td>
<%}
%>
<%	if(i==0){
	%>
	<td align="center" width = "3%">
		<input type="text" name="cycle_start_date_<%=i%>" id="cycle_start_date_<%=i%>" onblur="changeStartDate(this,'<%=i%>','<%=locale%>')" value="<%=start_date%>"  MAXLENGTH="16" SIZE = "13" <%=disable_cycle%>> 
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('cycle_start_date_<%=i%>',null,'hh:mm');
		document.onCologyCycleScheduleFreq.cycle_start_date_0.focus(); return false;" >
	</td>
<%}else{
	/*if(repeat_durn_type.equals("W"))
		start_date = bean.getSysdatePlusDays(start_date,(Integer.parseInt(cycle_no)*7)+"");
	else{
	  if(repeat_durn_type.equals("L"))
		start_date = bean.getSysdatePlusDays(start_date,(Integer.parseInt(cycle_no)*30)+"");
	} */
%>

	<td align="center" width = "3%" >
	<input type="text" name="cycle_start_date_<%=i%>" id="cycle_start_date_<%=i%>" value="<%=start_date%>" readonly MAXLENGTH="16" SIZE = "13" <%=disable_cycle%>> 
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('cycle_start_date_<%=i%>',null,'hh:mm');
		return false;" disabled>
	<!--<label class="label" id = "cycle_start_date_<%=i%>" ><%=start_date%></label>--></td>
<%}

for(int k=0;k<time.size();k++){
	%><td align="center">
<input type="text" name = "time_<%=i%>_<%=k%>" size='5' maxlength='5' onBlur='parent.timeChk(this);' value = "<%=time.get(k)%>"><img src="../../eCommon/images/mandatory.gif" border="0"></img></td><!-- img added for ML-MMOH-CRF-1004 -->
<%}
%>
<!--	<td align="center"><label class="label" id = "cycle_end_date_<%=i%>" ><%=bean.getSysdatePlusDays(start_date,"1")%></label>
	</td>-->
	<input type = "hidden" name ="cycle_end_date_<%=i%>" value = "<%=end_date%>">
	<input type = "hidden" name ="def_admin_day_<%=i%>" value = "<%=day_list%>"><!-- added for ML-MMOH-CRF-1228-->
	<input type = "hidden" name ="def_cycle_<%=i%>" value = "<%=cycle_no%>"><!-- ML-MMOH-CRF-1228-->
<br>
</tr>

<%	
}

%>	
	<input type = "hidden" name = "no_of_cycle" value = "<%=no_of_cycle%>">
	<input type = "hidden" name = "repeat_value" value = "<%=time.size()%>">
	<input type = "hidden" name = "repeat_durn_type" value = "<%=repeat_durn_type%>">
	<input type = "hidden" name = "drug_code" value = "<%=drug_code%>">
	<input type = "hidden" name = "srl_no" value = "<%=srl_no%>">
	<input type = "hidden" name = "start_date_time" value = "<%=start_date_time%>">
	<input type = "hidden" name = "end_date_time" value = "<%=end_date%>">
	<input type = "hidden" name = "first_start_date" value = "<%=first_start_date%>">
	<input type = "hidden" name = "locale" value = "<%=locale%>"><!-- added for ML-MMOH-CRF-1228-->
	

	<input type = "button" value = "OK" onclick = "setChangedCycleAdminTime();">
	<input type = "button" value = "Cancel" onclick = "window.close();">

	
	</form>
	</body>

</html>
<%	putObjectInBean(bean_id,bean,request);

}catch(Exception exception) {
       exception.printStackTrace();
 }
%>

