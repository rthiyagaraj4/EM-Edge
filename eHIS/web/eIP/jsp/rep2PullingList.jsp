<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>

<script src="../../eCommon/js/CommonCalendar.js"></script>

<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBPULST" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
try
{	

%>

<script language="javascript">

	function checkDt(date1)
	{
		retval=true
		var date1arr=new Array()

		date1arr=date1.split("/")

		if(date1arr.length==3)
		{
			var date1d=date1arr[0]
			var date1m=date1arr[1]
			var date1y=date1arr[2]

			date1d=eval(date1d)
			date1m=eval(date1m)
			date1yy=eval(date1y);

			if(date1m<=12)
			{

				if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
				{
				retval= false}

				if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30))
				{
				retval= false}

				if ((date1y.length <4) || (date1y.length >4))
					{
					retval= false}
					}
			else
				{
				retval= false;}
		}
		else
			{retval= false;}
			return retval;
		}

	function chkTime(time1)
	{
		var retval=true;

		if( (time1.charAt(time1.length-1) )!=":")
		{
			var time1arr=new Array()
			time1arr=time1.split(":")

			if(time1arr.length==2)
			{
				var time1hr=time1arr[0]
				var time1min=time1arr[1]

				time1hr=eval(time1hr)
				time1min=eval(time1min)
				if(time1hr<=23)
				{
					if(time1min>=60)
					{
							retval=false;
					}
				}
				else
						retval=false;
			}
			else
				retval=false;
		}
		else
				retval=false;
		
		return retval
	}

	function CompDates(dat1,dat2)
	{
		var comp = true;
		if (dat1.getFullYear() > dat2.getFullYear()){
			comp = true;
		}else if (dat1.getFullYear() == dat2.getFullYear()){
			if (dat1.getMonth() > dat2.getMonth()){
				comp = true;
			}else if (dat1.getMonth() == dat2.getMonth()){
				if (dat1.getDate() > dat2.getDate()){
					comp = true;
				}else if (dat1.getDate() == dat2.getDate()){
					comp = true;
				}else if (dat1.getDate() < dat2.getDate()){
					comp = false;	
				}
			}else if (dat1.getMonth() < dat2.getMonth()){
				comp = false;
			}
		}else if (dat1.getFullYear() < dat2.getFullYear()){
			comp = false;
		}
		return comp;
	}

	function doDateTimeChk(obj)
	{
		var comp=obj
		obj=obj.value
		var dttime = obj.split(" ");
		var dtArr=new Array()
		dtArr=obj.split("/")
		var dt
		var time
		var retval=true
		if(dttime == ""){}
		else if(dttime.length>1)
		{
			dt=dttime[0]
			time=dttime[1]

			if(!checkDt(dt) )
			{
				retval= false
				comp.focus()
			}
			else
			{
				if(time==null || time=="")
				{
					alert(getMessage("INVALID_DATE_TIME","SM"))
					retval= false;
					comp.focus()
				}

				else
				{
					if(!chkTime(time))
					{
							retval= false
							alert(getMessage("INVALID_DATE_TIME","SM"))
							comp.focus()
					}
					else
					{
						var today = new Date();
						var entDate = new Date(parseInt(dtArr[2]),parseInt(dtArr[1]-1),parseInt(dtArr[0]));
						if(!CompDates(entDate,today))
						{
								retval= false
								alert(getMessage("PREF_FM_DT_VALIDATION","IP"))
								comp.focus()
						}
					}
				}
			}
		}
		else
		{
			retval= false
			alert(getMessage("INVALID_DATE_TIME","SM"))
			comp.focus()
		}

		return retval
	}


	async function searchCode(obj,target)
	{
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";
		
		if(obj.name=="nursing_unit_code")
		{
			tit=getLabel('Common.nursingUnit.label','common');
			sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
			search_code="nursing_unit_code";
			search_desc= "short_desc";
		}

		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();
	}	

	function addOrderByCol(obj)	
		{ 		
		    var from = document.forms[0].orderbycols;
		    if ( from.options.length > 0 ) 
			{
				var to = document.forms[0].orderbycolumns; 
				var element = document.createElement('OPTION'); 
				element.text = from.options[from.selectedIndex].text; 
				element.value= from.options[from.selectedIndex].value; 
				to.add(element); 			
				from.remove(from.selectedIndex); 
			} 
		}                                                                                             

		function removeOrderByCol()
		    { 
				var from = document.forms[0].orderbycolumns;
				if ( from.options.length > 0 )
				{ 
					var to = document.forms[0].orderbycols; 
					var element = document.createElement('OPTION'); 
					element.text = from.options[from.selectedIndex].text; 
					element.value = from.options[from.selectedIndex].value; 
					to.add(element);	
					from.remove(from.selectedIndex); 
				} 
		    }	
</script>

<center>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name="rep2PullingListForm" id="rep2PullingListForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

			<th colspan='3' align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

				<tr>
					<td align="center" width="30%">&nbsp;</td>
					<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	
				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="eIP.PreferredAdmissionDate.label" bundle="${ip_labels}"/>&nbsp;</td>
						<td width='20%'  >
							<input type=text id="adm_date_from"  name='p_fm_preferred_date' id='p_fm_preferred_date' size="10" maxlength="10" align="center" onblur='CheckDate(this)'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_from');">
						</td>
						<td width='40%'> 
							<input type=text id="adm_date_to"  name='p_to_preferred_date' id='p_to_preferred_date' size="10" maxlength="10" align="center" onblur='CheckDate(this)'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_to');">
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>	

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='20%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				</tr>

		<tr>
			<td> &nbsp;</td>
			<td >&nbsp;</td>		
			<td >&nbsp;</td>		
		</tr>

			<tr>
				<td  align="right" width ="30%" class="label"><fmt:message key="Common.PickOnlyBookingsDoneAfter.label" bundle="${common_labels}"/> ? &nbsp;</td>

				<td width ='20%'>
					<input type = 'text' name='p_pick_booking_after' id='p_pick_booking_after' onBlur='CheckDate(this)'  size='10' maxlength='10'>&nbsp;
				</td>
				<td width = '40%'> &nbsp;</td>
		</tr>
		
		<tr>
			<td> &nbsp;</td>
			<td >&nbsp;</td>		
			<td >&nbsp;</td>		
		</tr>

		</table>
		
		<table border='0' width='80%' align='center' cellpadding='0' cellspacing='0'>
			<th colspan='3' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></th>
		<tr>
			<td colspan=3>&nbsp;</td>
		</tr>

		<tr>
			<td class='label' align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<td>&nbsp;</td>
			<td class='label' align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td class='label' align='center'><select name='orderbycols' id='orderbycols' size='6' >");
				<option value='bkg.gender'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></option>
				<option value='mrf.terminal_digit'><fmt:message key="Common.TerminalDigit.label" bundle="${common_labels}"/></option>
				<option value='bkg.patient_id'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
				</select>
			</td>

				<td align='center' width='3%' ><input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img></td>

			<td class='label' align='center'>
			<select name='orderbycolumns' id='orderbycolumns' size='6' multiple='true'>
			<option value='bkg.preferred_date' selected><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></option>
			</select>
			</td>
		</tr>
			<td colspan=3>&nbsp;</td>
		</table>



		<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
		<input type="hidden" name="p_order_by" id="p_order_by"		value="1">
	</form>
</body>
</center>
<%
}catch(Exception es)
{
	out.println(es.toString());
}
%>
</body>
<script>document.forms[0].p_fm_preferred_date.focus();</script></html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

