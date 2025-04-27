<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>

<jsp:useBean id="scheduleFrequencyTemp" scope="page" class="eAM.ScheduleFrequency"/>


<%

	request.setCharacterEncoding("UTF-8");	
	HttpSession ss = request.getSession(false);
	scheduleFrequencyTemp.setProperties( (Properties) ss.getValue( "jdbc" ) ) ;
	ArrayList  freqValues = null ;

	try{
		 freqValues = scheduleFrequencyTemp.getFreqValues(request);
		}catch(Exception e){%>
	<script>alert("Exception thrown ...Chk in ScehduleferquencyComboFill.jsp" + "<%=e.getMessage()%>");</script>
	<%}

	String  freqLegend_P		 ="";
	String  durationType_P		 ="";
	String  repeatValue_P	     ="";
	String  start_time_round_p	 ="";
	String  start_time_assign_p  ="";
	String daysHtml = "";

	//Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
	String max_no_of_cycle_p	 =""; 
	String monthdaysHtml				 ="";
	if(freqValues.size() != 0){
	  freqLegend_P		 = (String)freqValues.get(2); // FREQUENCY_LEGEND
	  durationType_P		 = (String)freqValues.get(1); // INTERVAL_DURN_TYPE
	  repeatValue_P	     = (String)freqValues.get(0); // REPEAT_VALUE
	  start_time_round_p	 = (String)freqValues.get(3); // START_TIME_ROUND
	  start_time_assign_p  = (String)freqValues.get(4); // START_TIME_ASSIGN
	  max_no_of_cycle_p	   = (String)freqValues.get(5); //Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
	}

	 if(durationType_P.equals("W"))
			{
						for(int j=1; j<=7;j++)
						{
							daysHtml =daysHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
						}
			}
		else if(durationType_P.equals("L"))
			{
				for(int j=1; j<=30;j++)
				{
						daysHtml =daysHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
				}
			}
		for(int j=1; j<=31;j++)
		{
				monthdaysHtml =monthdaysHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
		}
		
	out.println("<script>parent.assignFrqeuncyGlobal(\"" + durationType_P + "\",\"" + repeatValue_P + "\",\""+freqLegend_P +  "\",\"" + start_time_round_p + "\",\"" + start_time_assign_p + "\",\"" + daysHtml + "\",\"" + max_no_of_cycle_p + "\",\"" + monthdaysHtml + "\" ) ;</script>");
	freqValues.clear();
		
	%>
	
