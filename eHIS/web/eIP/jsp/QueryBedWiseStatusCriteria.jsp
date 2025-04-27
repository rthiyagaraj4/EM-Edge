<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<%@page import="java.sql.*,webbeans.eCommon.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String facilityid = (String)session.getValue("facility_id");
	String locale	  = (String)session.getAttribute("LOCALE");
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<script>
function clearAll()
{
	parent.result.location.href='../../eCommon/html/blank.html';
	document.forms[0].search.disabled=false;
}	

function submitPage()
{				
	var fields=new Array();
	fields[0]= document.forms[0].nursing_unit_desc;
	fields[1]= document.forms[0].from_date;
	fields[2]= document.forms[0].to_date;

	var names = new Array();
	names[0]	= getLabel("Common.nursingUnit.label","Common");
	names[1]	= getLabel("Common.DateFrom.label","Common")
	names[2]	= getLabel("Common.date.label","Common")+" "+getLabel("Common.to.label","Common");
	
	if(parent.criteria.checkFields( fields, names, parent.messageFrame))
	{
		var condition="";
		document.forms[0].search.disabled = true;

		for(var i=0; i<document.forms[0].elements.length; i++)
			condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
		parent.result.location.href= "../jsp/QueryBedWiseStatusResult.jsp?"+condition;	
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}else
	{
		document.forms[0].search.disabled = false;
		parent.result.location.href="../../eCommon/html/blank.html";
	}
}

function beforeGetNursingUnit(target_id,target)
{
	if(document.forms[0].nursing_unit_desc.value != document.forms[0].nursing_unit_hid.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			NursingUnitLookup(target_id,target)
		else
			document.forms[0].nursing_unit_code.value = "";
	}
}

async function NursingUnitLookup(target_id,target)
{
	var facility_id = document.forms[0].facilityid.value;
	var title = getLabel("Common.nursingUnit.label","Common");
	var argumentArray = new Array(8);
	var locale = document.forms[0].locale.value;

	argumentArray[0]="select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and EFF_STATUS like ? and facility_id like ? and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

	argumentArray[1]=new Array("EFF_STATUS","facility_id");
	argumentArray[2]=new Array("E",facility_id);
	argumentArray[3]=new Array(STRING,STRING);
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;
		
	var retVal = await CommonLookup(title,argumentArray);
		var ret1=unescape(retVal);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";
                document.forms[0].nursing_unit_hid.value = "";				
	 		}

            else{
			target_id.value = arr[0]; 
			target.value = arr[1];
           document.forms[0].nursing_unit_hid.value = arr[1];
			}		   

}


function DateCompare(from,to,localeName) 
{
	var fromdate = from.value ;
	var todate = to.value ;
	/*Tuesday, November 30, 2010 , SRR20056-SCF-6098 [IN:025257] , added to restrict date field from selecting back date*/
	var dttm = getCurrentDate('DMY' ,localeName);
	var  frmDate1 = fromdate.substring(0,10);
    var  toDate1 = todate.substring(0,10);

	if(frmDate1 != null && frmDate1 != "")
	{
		if(!isAfter((convertDate(frmDate1,"DMY",localeName,"en")),(convertDate(dttm,"DMY",localeName,"en")),"DMY",'en'))
		{
			var msg = getMessage("DATE1_LT_DATE2","IP");
			msg	=	msg.replace("$",getLabel("Common.DateFrom.label","Common"));
			msg	=	msg.replace("#",getLabel("Common.SystemDate.label","Common"));
			alert(msg);
			from.value = "";
		}
	}
	if(toDate1 != null  && toDate1 != "")
	{
		if(!isAfter((convertDate(toDate1,"DMY",localeName,"en")),(convertDate(dttm,"DMY",localeName,"en")),"DMY",'en'))
		{
			var msg = getMessage("DATE1_LT_DATE2","IP");
			msg	=	msg.replace("$",getLabel("Common.to.label","Common"));
			msg	=	msg.replace("#",getLabel("Common.SystemDate.label","Common"));
			alert(msg);
			to.value= "";
		}
	}
	/**/
	var flg1 = validDateObj(from,"DMYHM",localeName);
	var flg2 = validDateObj(to,"DMYHM",localeName);
	if(flg1 && flg2 )
	{
		var greg_fromdate = convertDate(from.value,"DMYHM",localeName,"en");
		var greg_todate = convertDate(to.value,"DMYHM",localeName,"en");
		if(!isBefore(greg_fromdate,greg_todate,"DMYHM",'en'))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.focus();
			to.select();
		}	
	}
	return true;
}
</script>

<body  onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='Criteria_Form' id='Criteria_Form' >
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
				<td  class='label' width='30%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td><input type=text  name='nursing_unit_desc' id='nursing_unit_desc' size="15" maxlength="15" align="center" onBlur="beforeGetNursingUnit(nursing_unit_code,nursing_unit_desc);"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='NursingUnitLookup(nursing_unit_code,nursing_unit_desc);'><input type="hidden" name='nursing_unit_code' id='nursing_unit_code' size="4" maxlength="4" align="center" onBlur="return makeValidQueryCriteria(this);"><input type="hidden" name='nursing_unit_hid' id='nursing_unit_hid' value=""><img align='center' src='../../eMP/images/mandatory.gif'></td>
				<td>&nbsp;</td><td>&nbsp;</td>
			</tr>
			<tr>
				<td class='label' nowrap><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
				<td class ='fields' nowrap><input type="text" id="fromDateID" name="from_date" id="from_date" size=16 maxlength=16 value="" onblur="DateCompare(this,to_date,'<%=locale%>') ;"><img src='../../eCommon/images/CommonCalendar.gif' onClick="from_date.focus();return showCalendar('fromDateID',null,'hh:mm');"/><img align='center' src='../../eMP/images/mandatory.gif'></td>
				<td class='label' nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class ='fields' nowrap><input type="text"  name="to_date" id="to_date" size=16 maxlength=16 value="" onblur="DateCompare(from_date,this,'<%=locale%>');"><img src='../../eCommon/images/CommonCalendar.gif' onClick="to_date.focus();return showCalendar('to_date',null,'hh:mm');"/><img align='center' src='../../eMP/images/mandatory.gif'></td>
			</tr>  
		</table>
		<table align='right'>
			<tr>
				<td align='right' class='white'><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick="clearAll()"></td>
				<input type=hidden name="facilityid" id="facilityid" value="<%=facilityid%>">
				<input type=hidden name="locale" id="locale" value="<%=locale%>">
			</tr>				
		</table>
	</form>
  </body>
</html>

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

