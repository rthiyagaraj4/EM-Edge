<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,eAM.*,eCommon.XSSRequestWrapper, webbeans.eCommon.*,java.io.*,java.util.*" %>



<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<jsp:useBean id="scheduleFrequency" scope="session" class="eAM.ScheduleFrequency"/>

 <%
  request.setCharacterEncoding("UTF-8");	
  request= new XSSRequestWrapper(request);
  response.addHeader("X-XSS-Protection", "1; mode=block");
  response.addHeader("X-Content-Type-Options", "nosniff");
  HttpSession ss = request.getSession(false);
  scheduleFrequency.setProperties( (Properties) ss.getValue( "jdbc" ) ) ;
%>

<html>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eAM/js/ScheduleFrquency.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
<body onLoad='delValue();' onKeyDown = 'lockKey()' OnMouseDown="CodeArrest();">
<%!
		private String decodeLocal(String objVal)
		{
			if(objVal.trim().equalsIgnoreCase(""))	    return	"";
			else if(objVal.trim().equalsIgnoreCase("N"))		return	"Next";
			else if(objVal.trim().equalsIgnoreCase("C"))     return	"Closest";
			else if(objVal.trim().equalsIgnoreCase("P"))     return	"Previous";
			else if(objVal.trim().equalsIgnoreCase("TM"))    return	"10th minute";
			else if(objVal.trim().equalsIgnoreCase("FM"))    return	"5th minute" ;
			else if(objVal.trim().equalsIgnoreCase("QH"))    return	"Quater Hour";
			else if(objVal.trim().equalsIgnoreCase("H"))     return	"Hourly" ;
			else if(objVal.trim().equalsIgnoreCase("M"))     return	"Minute" ;
			else
				return "";
		}

%>

<%
	String mode	   = request.getParameter("mode") ;
	
 	String daysHtml		="";
	
	String freq_code		=request.getParameter("freq_code");
	String freq_desc		=request.getParameter("freq_desc");
	String facility_id		=request.getParameter("facility_id");
	String facility_name	=request.getParameter("facility_name");
	String freqLegend	= "";
	String hrsHtml = "";
	String hrsHtmlInital = "";
	String hrsHtmlFinal = "";
	String  freqLegend_P		 = "";
	String  durationType_P		 = "";
	String  repeatValue_P	     = "";
	String  start_time_round_p	 = "";
	String  start_time_assign_p  = "";
	//Added by Sangeetha on 6th Jul 2017 for ML-MMOH-CRF-0345.2
	String max_no_of_cycle_p	 =""; 
	String monthdaysHtml		 = ""; 
	
	java.sql.Connection connection = null;
	
	scheduleFrequency.clear() ;
	
	if(mode.equals("2"))
		{                    //modify mode

 			 ArrayList  freqValues = null ;
			 freqValues = scheduleFrequency.getFreqValues(request);

			 freqLegend_P			= (String)freqValues.get(2);
			 freqLegend				= freqLegend_P;
			 durationType_P			= (String)freqValues.get(1);
			 repeatValue_P			= (String)freqValues.get(0);
			 start_time_round_p		= (String)freqValues.get(3);
			 start_time_assign_p	= (String)freqValues.get(4); 
			 max_no_of_cycle_p	    = (String)freqValues.get(5); //Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2

			 connection				= ConnectionManager.getConnection(request);
			
			ArrayList repeatVals = scheduleFrequency.getRepeatValues(freq_code);

			hrsHtml = scheduleFrequency.formHtmlOptions(freq_code,facility_id,connection,start_time_round_p,start_time_assign_p,max_no_of_cycle_p);

	
			//Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2
			if(max_no_of_cycle_p == ""){
			hrsHtmlInital =hrsHtmlInital+"<table border='0' width='100%' ><tr><th  colspan='12'  align='left' width='100%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.TimeRoundedto.label","am_labels")+":"+decodeLocal(start_time_assign_p)+ " "+decodeLocal(start_time_round_p) + "</th>";
			}else{
				hrsHtmlInital =hrsHtmlInital+"<table border='0' width='100%' ><tr><th  colspan='12'  align='left' width='100%'>&nbsp;</th>";
			}
			
			//Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2
			if(max_no_of_cycle_p == ""){
			if((repeatVals.get(1)).equals("W") || (repeatVals.get(1)).equals("L"))
			{
				hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='50%' align='center'><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Repeat.label","am_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
			}
			}else{  //Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2
				String repeat_val = (String)repeatVals.get(0);
				if((repeatVals.get(1)).equals("D")){
					hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='50%' align='center'><th align='center'>"+"SI.No"+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' colspan= '"+repeat_val+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
				}
				else if((repeatVals.get(1)).equals("W")){
					hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='50%' align='center'><th align='center'>"+"SI.No"+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Week.label","common_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' colspan= '"+repeat_val+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
				}
				else if((repeatVals.get(1)).equals("L")){
					hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='50%' align='center'><th align='center'>"+"SI.No"+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.month.label","common_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Cycle.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' colspan= '"+repeat_val+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
				}
			}
			hrsHtmlFinal = "</table></tr></table>";
			hrsHtml =hrsHtmlInital + hrsHtml + hrsHtmlFinal ;
            hrsHtml= hrsHtml.replaceAll("right", "");			

		}

%>

<form name="scheduleFreqencyAddMod" id="scheduleFreqencyAddMod" action="../../servlet/eAM.ScheduleFrequencyServlet" method="post" target="messageFrame">

<table border="0" id="headerTab" cellpadding=0 cellspacing=0 width="95%" align="center">
<%
	try 
	{ 
		int ii=1;
%>

		<tr>
	
			<td colspan="3">&nbsp;</td>
		</tr>

		<tr>
			<td width="20%" class="label" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>&nbsp;</td>
	
<%
			if (! mode.equals("2") ) //insert mode
				{
%>
					<td class="fields" width="40%" >
						<select name="freq_code" id="freq_code"  onChange="return parent.fillLegend(this)">
							<option>------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------</option>
							<%=(String)scheduleFrequency.getComboOptions("frequency")%>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img></td>
					
					<td class="label" width="50%" id="freqLegend">&nbsp;</td>
<%
				}
			else
				{
%>
					<td class="fields" width="40%" >
						<INPUT TYPE="text" name="freq_code_desc" id="freq_code_desc" readOnly value="<%=freq_desc%>" size='75%'>&nbsp;
						<img src="../../eCommon/images/mandatory.gif"></img></td>

						<input type="hidden" name="freq_code" id="freq_code" value="<%=freq_code%>">

					<td class="label" width="50%" id="freqLegend">&nbsp;<%=freqLegend%></td>
<%
				}
%>
		</tr>
 
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>

		<tr>
			<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class="fields" colspan="2">
<%
			if (!mode.equals("2") ) //insert mode
				{
%>
					<select name="admin_facility_id" id="admin_facility_id" >
						<option value=''>------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------</option>
						<option value='*A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%=(String)scheduleFrequency.getComboOptions("facility")%>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img>
<%				}
			else
			   {
%>
					<INPUT TYPE="text" name="admin_facility_desc" id="admin_facility_desc" readOnly value="<%=facility_name%>" size="70">
					<input type="hidden" name="admin_facility_id" id="admin_facility_id" value="<%=facility_id%>">
					<img src="../../eCommon/images/mandatory.gif"></img>
<%
				}
%>
			</td>
		</tr>	

		<tr>
			<td colspan="3" class="label">&nbsp;</td>
		</tr>
	</table>



	<table border="0" id="timeTab" cellpadding=0 cellspacing=0 width="95%" align="center" style="top-margin:0">
<%
		if (!mode.equals("2") )  // insert mode
			{
%>
				<tr><td id="timeLegend">&nbsp;</td></tr>
<%	 
			}
		else
			{
%>
				<tr><td id="timeLegend"><%=hrsHtml%></td></tr>
<%
			}
%>
	</table>


<input type="hidden" name="chkvaltemp" id="chkvaltemp" value="">
	
<input type="hidden" name="chkvaltemp1" id="chkvaltemp1" value="">
<input type="hidden" name="chkval" id="chkval" value="<%=ii%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="daysHtml" id="daysHtml" value="<%=daysHtml%>">
<input type="hidden" name="repeat" id="repeat" value="<%=repeatValue_P%>">
<input type="hidden" name="durationType" id="durationType" value="<%=durationType_P%>">
<!-- Added by Sangeetha on 6th Jul 2017 for ML-MMOH-CRF-0345.2 -->
<input type="hidden" name="monthdaysHtml" id="monthdaysHtml" value="<%=monthdaysHtml%>"> 
<input type="hidden" name="max_no_of_cycle" id="max_no_of_cycle" value="<%=max_no_of_cycle_p%>">

<input type="hidden" name="start_time_round_p" id="start_time_round_p" value="<%=start_time_round_p%>">
<input type="hidden" name="start_time_assign_p" id="start_time_assign_p" value="<%=start_time_assign_p%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">

<%
	}catch(Exception e)
	{	
		//out.println("Exception here");
		//out.println("Exception in ScheduleFrequencyAddModify" + e.getMessage());
		e.printStackTrace();
	}
	finally {
				 	 ConnectionManager.returnConnection(connection,request);
			}
%>
</form>
</body>
</html>
		
	

