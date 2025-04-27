<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%!int row_count=0;%>

<html>
<head><title>MultiPatientOrdersResultingHdr</title>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eOR/js/ORMultiPatientOrdersResultingReport.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script><!-- used for date validation-->
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function checkValid(obj,event,val1,val2) 
{
	if (event.keyCode == 13) 
	{
		event.keyCode = "";
		return;
	} 
	else 
	{
		return allowValidNumber(obj,event,val1,val2);
	}
}


function validateDateWithTime(obj)
{
	if(!doDateTimeChk(obj))
	{
		if(obj.value!='')
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			return false;
		}
	}
}

function doDateTimeChk(obj)
{
	if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
	{
		retval= false
	}
	else
	{
		var comp=obj
		obj=obj.value
		var dttime = obj.split(" ");
		var dt
		var time
		var retval=true
		if(dttime.length>1)
		{
			dt=dttime[0]
			time=dttime[1]
			if(!checkDt(dt) )
			{
				retval= false
			}
			else
			{
				if(time==null || time=="")
				{
					alert(getMessage("INVALID_DATE_TIME","SM"))
					retval= false;
				}
				else
				{
					if(!chkTime(time))
					{
							retval= false
							alert(getMessage("INVALID_DATE_TIME","SM"))
					}
				}
			}
		}
		else
		{
			retval= false
		}
	}
	return retval
}
	</script>
</head>

<%
	/* Mandatory checks start */

	String bean_id = "Or_MultiPatientOrdersResulting" ;
	String bean_name = "eOR.MultiPatientOrdersResultingBean";

	//int total_records_count = Integer.parseInt(request.getParameter("total_records_count"));
	int discrete_count = Integer.parseInt(request.getParameter("discrete_count"));

	String result_type = "";
	String max_digits = "";
	String min_digits = "";
	String dec_digits = "";
	String classval = "";
	String unit_of_msr = "";
	String num_crit_low_points = "0";
	String num_crit_high_points = "0";
	String num_crit_low = "0";
	String num_crit_high = "0";

//	String discrete_desc = request.getParameter("discrete_desc");
	int max_length = 0;

	int row_disp=OrRepository.DISPLAY_MIN_RECORDS;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;
	String dispMode="";
	String temp_disp = "";

	MultiPatientOrdersResultingBean bean = (MultiPatientOrdersResultingBean)getBeanObject( bean_id, bean_name, request ) ;	
	bean.setLanguageId(localeName);
	eOR.Common.MultiRecordBean MultiRecordSet= new eOR.Common.MultiRecordBean();

	String from= "", to ="" ;

	dispMode			=	request.getParameter("dispMode") ;
	from				=	request.getParameter("from") ;
	to					=	request.getParameter("to") ;
	
	temp_disp = dispMode;

	if (from == null || from=="null" || from.equals("null"))
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp - 1;
	else
		end = Integer.parseInt( to ) ;

	if(dispMode == null || dispMode.equals("null"))dispMode="";

	if(dispMode.equals(""))
	{
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
		row_count			=  MultiRecordSet.getSize("DB");
//		System.out.println("in result 1, row count is...."+row_count);
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start);
		to   = ""+(end);
	}
	else
	{
//		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
		}else if(dispMode.equals("Previous")){
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
		if(to_val > (row_count-1))
			to_val=(row_count-1);
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();

		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}
	
	String result_format = request.getParameter("result_format");
	String main_result_type = request.getParameter("main_result_type");

	ArrayList discrete_measures_list = (ArrayList)bean.getDiscreteMeasures(result_format,main_result_type);
	String[] record = null;

%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll='scrollFrame();callScrollLeft();' onResize='alignDivs()'>
<form name="multiPatientORMainResultValues" id="multiPatientORMainResultValues">

<div id='divDataTitle' style='postion:relative'>
	<table border='0' width='100%' id='dataTitleTable' >
		<TR>
		<%
		int count=0;
		String descrete_msr_desc = "";
		String mandatory = "";
		//StringTokenizer st = new StringTokenizer(discrete_desc,":::");
		for(int j=0;j<discrete_count;j++)
		{
			//descrete_msr_desc = st.nextToken();
			//descrete_msr_desc = descrete_msr_desc.replaceAll("hash","#");
			//descrete_msr_desc = descrete_msr_desc.replaceAll("ampersand","&");
			record = (String[])discrete_measures_list.get(j);
			descrete_msr_desc = record[1];
			//mandatory = request.getParameter("mandatory"+count);
			//unit_of_msr = request.getParameter("unit_of_msr"+count);
			mandatory = record[7];
			unit_of_msr = record[6];
			if(unit_of_msr==null || unit_of_msr.equals(""))
				unit_of_msr = "";
		%>
			<td class="COLUMNHEADER" style="width: 240px;" nowrap>
				 <%=descrete_msr_desc%>
				<%
				if(unit_of_msr!=null && !unit_of_msr.equals(""))
					out.println("("+unit_of_msr+")");;
				
				if(mandatory!= null && !mandatory.equals("")&& mandatory.equals("Y"))
				{
				%>
				<img src="../../eCommon/images/mandatory.gif">
				<%
				}
				%>
			</td >
		<%
		count++;
		}
		%>
		</TR>
		<TR>
			<td colspan="<%=count%>">&nbsp;
			</td >
		</TR>
	</table>
</div>
<div id="prevNext" style='postion:relative'>
<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center' >
	<tr align='right' width='10%'>
	<%
	if ( (!(start <= 1)) && (start < row_count)){
	%>
		<td class='WHITE' width='89%'>&nbsp;</td>
		<td width='11%'>
		<A HREF='javascript:onClick=submitPage("Previous");' text-decoration='none' class="gridLink" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
		</td>
	<%	
	}
	if ( !( (start+row_disp) >= row_count ) ){
	%>
		<td class='WHITE' width='94%'>&nbsp;</td>
		<td width='6%'>
		<A HREF='javascript:onClick=submitPage("Next");' text-decoration='none' class="gridLink"><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
		</td>
	<%
	}
	%>
	</tr>
</table>
</div>
<table width="100%" border=0 id='dataTable' style="border-bottom:#ffffff">
	<%

	for(int i=fm_disp;i<=to_disp;i++)
	{
		if(i % 2 == 0 )
		{
			classval	=	"CACHARTQRYEVEN";
			
		}
		else
		{
			classval	=	"CACHARTQRYEVEN";
		}
		%>
		<TR>
			<TD class="<%=classval%>" colspan="<%=discrete_count%>">&nbsp;&nbsp;</TD>
		</TR>
		<input type="hidden" name="order_id<%=i%> value=" id="order_id<%=i%> value="">		
		<input type="hidden" name="order_line_num<%=i%> value=" id="order_line_num<%=i%> value="">
		<input TYPE="hidden" name="srv_status<%=i%>" id="srv_status<%=i%>" value="Normal">
		<input TYPE="hidden" name="rslt_type<%=i%>" id="rslt_type<%=i%>" value="">
		<TR VALIGN="BOTTOM" style="height: 25px;">
		<%
		for(int j=0;j<discrete_count;j++)
		{
			record = (String[])discrete_measures_list.get(j);
			//result_type = request.getParameter("result_type"+j);
			result_type = bean.checkForNull(record[2]);
	%>
			<input type="hidden" name="srv_stat<%=i%><%=j%>" id="srv_stat<%=i%><%=j%>" value="N">
			<TD class="<%=classval%>" style="width:240px;" nowrap valign="center">
			<%
			if(result_type.equals("E"))
			{
			%>
			<input type="text" name="date_hour_type<%=i%><%=j%>" id="date_hour_type<%=i%><%=j%>" value="" size="14" maxlength="16" onBlur="validDateObj1(this,'DMYHM','<%=localeName%>');changeColorIfDiff(this,'<%=i%>','<%=j%>');setHeaderValue1(this,'<%=i%>','<%=j%>')" onChange="changeColorIfDiff(this,'<%=i%>','<%=j%>');setHeaderValue1(this,'<%=i%>','<%=j%>')"  onKeyPress='return OrAllowDateHourFormat()'> <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_hour_type<%=i%><%=j%>',null,'hh:mm');" style='cursor:pointer'> 
			<%
			}
			else if(result_type.equals("D"))
			{

			%>
			<input type="text" name="date_type<%=i%><%=j%>" id="date_type<%=i%><%=j%>" value="" size="10" maxlength="10"  onBlur="CheckDate(this);changeColorIfDiff(this,'<%=i%>','<%=j%>');setHeaderValue1(this,'<%=i%>','<%=j%>')" onChange="changeColorIfDiff(this,'<%=i%>','<%=j%>');setHeaderValue1(this,'<%=i%>','<%=j%>')" onKeyPress='return OrAllowDateFormat()'> <img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_type<%=i%><%=j%>');" style='cursor:pointer'> 
			<%
			}
			else if(result_type.equals("N") || result_type.equals("I"))
			{
				//max_digits = request.getParameter("max_digits"+j);
				//min_digits = request.getParameter("min_digits"+j);
				//dec_digits = request.getParameter("dec_digits"+j);

				max_digits = bean.checkForNull(record[3]);
				min_digits = bean.checkForNull(record[4]);
				dec_digits = bean.checkForNull(record[5]);

				/*if(max_digits==null || max_digits.equals(""))
					max_digits = "1";

				if(min_digits==null || min_digits.equals(""))
					min_digits = "0";
				
				if(dec_digits==null || dec_digits.equals(""))
					dec_digits = "0";

				if(dec_digits.equals("0"))
					max_length = Integer.parseInt(max_digits) + Integer.parseInt(dec_digits);
				else
					max_length = Integer.parseInt(max_digits) + Integer.parseInt(dec_digits) + 1;*/
				if(result_type.trim().equalsIgnoreCase("N") ||result_type.trim().equalsIgnoreCase("I"))
				{
					max_length = 1;
					if(max_digits==null || max_digits.trim().equals(""))
						max_digits = "20";
					if(dec_digits.equals("") || dec_digits.equals("0")) 
					{
						max_length = Integer.parseInt(max_digits);
						dec_digits = "0";
					} 
					else 
					{
						max_length = Integer.parseInt(max_digits) + 1;										
					}
				}
				
				num_crit_low_points		= bean.checkForNull(record[8]);
				num_crit_high_points	= bean.checkForNull(record[9]);
				num_crit_low			= bean.checkForNull(record[10]);
				num_crit_high			= bean.checkForNull(record[11]);
			%>
			<input type="text" name="number_type<%=i%><%=j%>" id="number_type<%=i%><%=j%>" value="" onKeyPress="return checkValid(this,window.event,<%=max_digits%>,<%=dec_digits%>)" onBlur="check_NumericResult(this,'<%=i%><%=j%>','<%=i%>','<%=j%>')" onChange="changeColorIfDiff(this,'<%=i%>','<%=j%>');setHeaderValue1(this,'<%=i%>','<%=j%>')" maxLength="<%=max_length%>" >
			<input type="hidden" name="num_crit_low_points<%=i%><%=j%>" id="num_crit_low_points<%=i%><%=j%>" value="<%=num_crit_low_points%>">
			<input type="hidden" name="num_crit_high_points<%=i%><%=j%>" id="num_crit_high_points<%=i%><%=j%>" value="<%=num_crit_high_points%>">
			<input type="hidden" name="num_crit_low<%=i%><%=j%>" id="num_crit_low<%=i%><%=j%>" value="<%=num_crit_low%>">
			<input type="hidden" name="num_crit_high<%=i%><%=j%>" id="num_crit_high<%=i%><%=j%>" value="<%=num_crit_high%>">
			<input type="hidden" name="max_digits<%=i%><%=j%>" id="max_digits<%=i%><%=j%>" value="<%=max_digits%>">
			<input type="hidden" name="min_digits<%=i%><%=j%>" id="min_digits<%=i%><%=j%>" value="<%=min_digits%>">
			<input type="hidden" name="dec_digits<%=i%><%=j%>" id="dec_digits<%=i%><%=j%>" value="<%=dec_digits%>">
			
			<%
			}
			else if(result_type.equals("C"))
			{
			%>
				<input type="checkbox" name="check_type<%=i%><%=j%>" id="check_type<%=i%><%=j%>" value="" onClick="setHeaderCheckBoxValue(this,'<%=i%>','<%=j%>')">
			<%
			}
			else if(result_type.equals("F"))
			{	
			%>
				<TEXTAREA ROWS="3" COLS="25" name="long_text_type<%=i%><%=j%>" id="long_text<%=i%><%=j%>" onBlur="check_MaxLimit(this,2000,'<%=i%>','<%=j%>')" onChange="changeColorIfDiff(this,'<%=i%>','<%=j%>');setHeaderValue1(this,'<%=i%>','<%=j%>');"></TEXTAREA>
			<%
			}
			else if (result_type.equals("L"))
			{
			%>
				<SELECT name="list_type<%=i%><%=j%>" id="list_type<%=i%><%=j%>" onChange="changeColorIfDiff(this,'<%=i%>','<%=j%>');setHeaderValue1(this,'<%=i%>','<%=j%>')">
					<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</OPTION>
				</SELECT>
				<SCRIPT>loadListValues('list_type<%=i%><%=j%>','<%=j%>')</script>
			<%
			}
			else if (result_type.equals("T"))
			{
			%>
			<input type="text" name="time_type<%=i%><%=j%>" id="time_type<%=i%><%=j%>" value="" size="10" maxlength="5" onkeypress="return CheckForSpecChars(event)" onChange="setHeaderValue1(this,'<%=i%>','<%=j%>');" onBlur="changeColorIfDiff(this,'<%=i%>','<%=j%>');check_Time(this,'<%=i%>','<%=j%>')">
			<%
			}
			else if (result_type.equals("H"))
			{
			%>
			<input type="text" name="short_text_type<%=i%><%=j%>" id="short_text_type<%=i%><%=j%>" value="" size="30" maxlength="200" onBlur="changeColorIfDiff(this,'<%=i%>','<%=j%>');setHeaderValue1(this,'<%=i%>','<%=j%>')" onChange="changeColorIfDiff(this,'<%=i%>','<%=j%>');setHeaderValue1(this,'<%=i%>','<%=j%>')">
			<%
			}
			%>
			</TD>
	<%
		}
		%>
		</TR>
	<%
	}
	%>
	
	<!--<TR style="display: none;">
		<TD class="<%=classval%>" colspan="<%=discrete_count%>">&nbsp;&nbsp;</TD>
	</TR>
	<TR style="display: none;">
		<TD class="<%=classval%>" colspan="<%=discrete_count%>">&nbsp;&nbsp;</TD>
	</TR>-->
</table>
<input type="hidden" name="from" id="from" value="<%=from%>">
<input type="hidden" name="to" id="to" value=<%=to%>>
<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> >
<input type="hidden" name="result_format" id="result_format" value="<%=result_format%>">
<input type="hidden" name="main_result_type" id="main_result_type" value="<%=main_result_type%>">
<input type="hidden" name="total_values" id="total_values" value="<%=discrete_count%>">
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
<script>
	if(parent.multiPatientOrdersResultingMainResultData!= null)
	{
		parent.multiPatientOrdersResultingMainResultData.document.body.scroll="no";
		parent.multiPatientOrdersResultingMainResultData.document.body.onscroll= "";
	}
	setTimeout("alignUnitsAndData()",200);
	setTimeout("alignHeight()",300);
</script>
<%
if(temp_disp==null || temp_disp.equals("null") || temp_disp.equals(""))
{
	out.println("<script>loadHiddenParams();</script>");
}
%>
<script>
loadParamValues();
</script>
</form>
</body>
</html>
<%
	// set it back persistence
	//putObjectInBean(bean_id,bean,request);
%>

