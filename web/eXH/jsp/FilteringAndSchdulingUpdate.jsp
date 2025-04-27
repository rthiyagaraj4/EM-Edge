<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<%
String exceptions="";
try
{

String Filterlevel1type=XHDBAdapter.checkNull(request.getParameter("Filter_level1_type"));
String Filterlevel1subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level1_subtype"));
String Filterlevel1code=XHDBAdapter.checkNull(request.getParameter("Filter_level1_code"));
String Filterlevel1value=XHDBAdapter.checkNull(request.getParameter("Filter_level1_value"));

String Filterlevel2type=XHDBAdapter.checkNull(request.getParameter("Filter_level2_type"));
String Filterlevel2subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level2_subtype"));
String Filterlevel2code=XHDBAdapter.checkNull(request.getParameter("Filter_level2_code"));
String Filterlevel2value=XHDBAdapter.checkNull(request.getParameter("Filter_level2_value"));

String Filterlevel3type=XHDBAdapter.checkNull(request.getParameter("Filter_level3_type"));
String Filterlevel3subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level3_subtype"));
String Filterlevel3code=XHDBAdapter.checkNull(request.getParameter("Filter_level3_code"));
String Filterlevel3value=XHDBAdapter.checkNull(request.getParameter("Filter_level3_value"));

String Filterlevel4type=XHDBAdapter.checkNull(request.getParameter("Filter_level4_type"));
String Filterlevel4subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level4_subtype"));
String Filterlevel4code=XHDBAdapter.checkNull(request.getParameter("Filter_level4_code"));
String Filterlevel4value=XHDBAdapter.checkNull(request.getParameter("Filter_level4_value"));

String Filterlevel5type=XHDBAdapter.checkNull(request.getParameter("Filter_level5_type"));
String Filterlevel5subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level5_subtype"));
String Filterlevel5code=XHDBAdapter.checkNull(request.getParameter("Filter_level5_code"));
String Filterlevel5value=XHDBAdapter.checkNull(request.getParameter("Filter_level5_value"));

String Filterlevel6type=XHDBAdapter.checkNull(request.getParameter("Filter_level6_type"));
String Filterlevel6subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level6_subtype"));
String Filterlevel6code=XHDBAdapter.checkNull(request.getParameter("Filter_level6_code"));
String Filterlevel6value=XHDBAdapter.checkNull(request.getParameter("Filter_level6_value"));

String Filterlevel7type=XHDBAdapter.checkNull(request.getParameter("Filter_level7_type"));
String Filterlevel7subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level7_subtype"));
String Filterlevel7code=XHDBAdapter.checkNull(request.getParameter("Filter_level7_code"));
String Filterlevel7value=XHDBAdapter.checkNull(request.getParameter("Filter_level7_value"));

String Filterlevel8type=XHDBAdapter.checkNull(request.getParameter("Filter_level8_type"));
String Filterlevel8subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level8_subtype"));
String Filterlevel8code=XHDBAdapter.checkNull(request.getParameter("Filter_level8_code"));
String Filterlevel8value=XHDBAdapter.checkNull(request.getParameter("Filter_level8_value"));

String Filterlevel9type=XHDBAdapter.checkNull(request.getParameter("Filter_level9_type"));
String Filterlevel9subtype=XHDBAdapter.checkNull(request.getParameter("Filter_level9_subtype"));
String Filterlevel9code=XHDBAdapter.checkNull(request.getParameter("Filter_level9_code"));
String Filterlevel9value=XHDBAdapter.checkNull(request.getParameter("Filter_level9_value"));

String leval_number=XHDBAdapter.checkNull(request.getParameter("Level_number"));
String Filter_group_desc_id=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
String tranaction_number=XHDBAdapter.checkNull(request.getParameter("Transnumber"));
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eXH/js/FilterLayerReference.js' language='javascript'></script>

<script Language="JavaScript" >
function CheckForSpecCharsforID(event) 
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
function record(mode)
{
this.document.forms[0].actualmode.value=mode;
this.document.forms[0].submit();

}
function cancel()
{
	this.document.forms[0].reset();
}
function hide()
	{
var k=1;	
var count=0;
for(var i=1;i<document.DATAELEMENTCROSSREF.elements.length;i++)
		{

if(document.DATAELEMENTCROSSREF.elements[i].value!="" )
{

document.DATAELEMENTCROSSREF.elements[i].style.display="block";
if(document.DATAELEMENTCROSSREF.elements[i].type=="text")
	{
k++;
	}
}
else
{
	document.DATAELEMENTCROSSREF.elements[i].style.display="none";
}
}

 count =k/4;
for(var r=1;r<=count;r++)
		{
document.getElementById("lablerow"+r).style.display="block"; 
document.getElementById("lablelevelt"+r).style.display="block";
document.getElementById("lablelevels"+r).style.display="block";
document.getElementById("lablelevelc"+r).style.display="block";
document.getElementById("lablelevelv"+r).style.display="block";
		}

document.forms[0].count.value=count;
	} 
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onload="hide();">
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF" target='messageFrame' method="POST" action='../../eXH/jsp/FilterAndSchedulingUpdateRecord.jsp' > 
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr id="lablerow1" style="display:none">
<td class=label id="lablelevelt1" width='10%' style="display:none">Filter level1 type</td>
<td align=left><input type=text name=Filter_level_type1 size=15 value='<%=Filterlevel1type%>' > </td>
<td class=label id="lablelevels1" width='10%' style="display:none">Filter level1 subtype</td>
<td align=left><input type=text name=Filter_level_subtype1 size=15  value='<%=Filterlevel1subtype%>'  style="display:none"></td>
<td class="label" id="lablelevelc1" style="display:none">Filter level1 code</td>
<td align=left>
<input type=text id='Filter_level1_code'  name ='Filter_level_code1' size='15' value='<%=Filterlevel1code%>'  style="display:none"> 
</td>
<td class="label" id="lablelevelv1" style="display:none" >Filter level1 value</td>
<td align=left><input type=text id="Filter_level_value1"  name ='Filter_level_value1' size='15' value='<%=Filterlevel1value%>'  style="display:none"> </td>
</tr> 

 
<tr id="lablerow2" style="display:none">
<td class=label width='10%' id="lablelevelt2" style="display:none">Filter level2 type</td>
	<td align=left><input type=text name=Filter_level_type2 size=15 value='<%=Filterlevel2type%>' style="display:none" > </td>
<td class=label width='10%' id="lablelevels2" style="display:none">Filter level2 subtype</td>
<td align=left><input type=text name=Filter_level_subtype2 size=15 value='<%=Filterlevel2subtype%>'style="display:none" ></td>
<td class="label" id="lablelevelc2" style="display:none">Filter level2 code</td>
<td align=left>
<input type=text id='Filter_level2_code'  name ='Filter_level_code2' size='15' value='<%=Filterlevel2code%>'  style="display:none"> 
</td>
<td class="label" id="lablelevelv2" style="display:none">Filter level2 value</td>
<td align=left><input type=text id="Filter_level_value2"  name ='Filter_level_value2' size='15' value='<%=Filterlevel2value%>'  style="display:none"> </td>
</tr>

<tr id="lablerow3" style="display:none">
<td class=label width='10%' id="lablelevelt3" style="display:none">Filter level3 type</td>
	<td align=left><input type=text name=Filter_level_type3 size=15 value='<%=Filterlevel3type%>' style="display:none"> </td>
<td class=label width='10%' id="lablelevels3" style="display:none">Filter level3 subtype</td>
<td align=left><input type=text name=Filter_level_subtype3 size=15 value='<%=Filterlevel3subtype%>' style="display:none"></td>
<td class="label" id="lablelevelc3" style="display:none">Filter level3 code</td>
<td align=left>
<input type=text id='Filter_level3_code'  name ='Filter_level_code3' size='15' value='<%=Filterlevel3code%>' style="display:none" > 
</td>
<td class="label" id="lablelevelv3" style="display:none">Filter level3 value</td>
<td align=left><input type=text id="Filter_level_value3"  name ='Filter_level_value3' size='15' value='<%=Filterlevel3value%>' style="display:none" > </td>
</tr>


<tr id="lablerow4" style="display:none">
<td class=label width='10%' id="lablelevelt4" style="display:none">Filter level4 type</td>
	<td align=left><input type=text name=Filter_level_type4 size=15 value='<%=Filterlevel4type%>' style="display:none"> </td>
<td class=label width='10%' id="lablelevels4" style="display:none">Filter level4 subtype</td>
<td align=left><input type=text name=Filter_level_subtype4 size=15 value='<%=Filterlevel4subtype%>' style="display:none"></td>
<td class="label" id="lablelevelc4" style="display:none">Filter level4 code</td>
<td align=left>
<input type=text id='Filter_level4_code'  name ='Filter_level_code4' size='15' value='<%=Filterlevel4code%>'  style="display:none"> 
</td>
<td class="label" id="lablelevelv4" style="display:none" >Filter level4 value</td>
<td align=left><input type=text id="Filter_level4_value"  name ='Filter_level_value4' size='15' value='<%=Filterlevel4value%>'  style="display:none"> </td>
</tr>

<tr id="lablerow5" style="display:none">
<td class=label width='10%' id="lablelevelt5"style="display:none">Filter level5 type</td>
	<td align=left><input type=text name=Filter_level_type5 size=15 value='<%=Filterlevel5type%>' style="display:none"> </td>
<td class=label id="lablelevels5" width='10%' style="display:none">Filter level5 subtype</td>
<td align=left><input type=text name=Filter_level_subtype5 size=15 value='<%=Filterlevel5subtype%>' style="display:none"></td>
<td class="label" id="lablelevelc5" style="display:none">Filter level5 code</td>
<td align=left>
<input type=text id='Filter_level5_code'  name ='Filter_level_code5' size='15' value='<%=Filterlevel5code%>'  style="display:none"> 
</td>
<td class="label" id="lablelevelv5" style="display:none">Filter level5 value</td>
<td align=left><input type=text id="Filter_level_value5"  name ='Filter_level_value5' size='15' value='<%=Filterlevel5value%>'  style="display:none"> </td>
</tr>

<tr id="lablerow6" style="display:none">
<td class=label width='10%' id="lablelevelt6" style="display:none">Filter level6 type</td>
<td align=left><input type=text name=Filter_level_type6 size=16 value='<%=Filterlevel6type%>' style="display:none"> </td>

<td class=label width='10%' id="lablelevels6" style="display:none">Filter level6 subtype</td>
<td align=left><input type=text name=Filter_level_subtype6 size=16 value='<%=Filterlevel6subtype%>' style="display:none"></td>


<td class="label" id="lablelevelc6" style="display:none">Filter level6 code</td>
<td align=left><input type=text id='Filter_level_code6'  name ='Filter_level_code6' size='16' value='<%=Filterlevel6code%>'  style="display:none"> 
</td>

<td class="label" id="lablelevelv6" style="display:none">Filter level6 value</td>
<td align=left><input type=text id="Filter_level_value6"  name ='Filter_level_value6' size='16' value='<%=Filterlevel6value%>'  style="display:none"> </td>
</tr>



<tr id="lablerow7" style="display:none">
<td class=label width='10%' id="lablelevelt7" style="display:none">Filter level7 type</td>
<td align=left><input type=text name=Filter_level_type7 size=15 value='<%=Filterlevel7type%>' style="display:none"> </td>

<td class=label width='10%' id="lablelevels7" style="display:none">Filter level7 subtype</td>
<td align=left><input type=text name=Filter_level_subtype7 size=15 value='<%=Filterlevel7subtype%>' style="display:none"></td>

<td class="label" id="lablelevelc7" style="display:none">Filter level7 code</td>
<td align=left><input type=text id='Filter_level_code7'  name ='Filter_level_code7' size='15' value='<%=Filterlevel7code%>'  style="display:none"> 
</td>

<td class="label" id="lablelevelv7" style="display:none">Filter level7 value</td>
<td align=left><input type=text id="Filter_level_value7"  name ='Filter_level_value7' size='15' value='<%=Filterlevel7value%>'  style="display:none"> </td>
</tr>

<tr id="lablerow8" style="display:none">
<td class=label width='10%' id="lablelevet8" style="display:none">Filter level8 type</td>
	<td align=left id="" ><input type=text name=Filter_level_type8 size=15 value='<%=Filterlevel8type%>' style="display:none"> </td>

<td class=label width='10%' id="lablelevels8" style="display:none">Filter level8 subtype</td>
<td align=left><input type=text name=Filter_level_subtype8 size=15 value='<%=Filterlevel8subtype%>' style="display:none"></td>

<td class="label" id="lablelevelc8" style="display:none">Filter level8 code</td>
<td align=left><input type=text id='Filter_level_code8'  name ='Filter_level_code8' size='15' value='<%=Filterlevel8code%>'  style="display:none"> 
</td>

<td class="label" id="lablelevelv8" style="display:none">Filter level8 value</td>
<td align=left><input type=text id="Filter_level_value8"  name ='Filter_level_value8' size='15' value='<%=Filterlevel8value%>'  style="display:none"> </td>
</tr>
<tr id="lablerow9" style="display:none">
<td class=label width='10%' id="lablelevelt9" style="display:none">Filter level9 type</td>
	<td align=left><input type=text name=Filter_level_type9 size=15 value='<%=Filterlevel9type%>' style="display:none"> </td>

<td class=label width='10%' id="lablelevels9" style="display:none">Filter level9 subtype</td>
<td align=left><input type=text name=Filter_level_subtype9 size=15 value='<%=Filterlevel9subtype%>' style="display:none"></td>

<td class="label" id="lablelevelc9" style="display:none">Filter level9 code</td>
<td align=left><input type=text id='Filter_level_code9'  name ='Filter_level_code9' size='15' value='<%=Filterlevel9code%>'  style="display:none"> 
</td>

<td class="label" id="lablelevelv9" style="display:none ">Filter level9 value</td>
<td align=left><input type=text id="Filter_level_value9"  name ='Filter_level_value9' size='15' value='<%=Filterlevel9value%>'  style="display:none"> 
</tr>
<tr>
<td>
</td>
<td>
</td>
</tr>
<tr>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
<td>
</td>
<td></td>
<td class="BUTTON"><input class='button' type='button'  name='Record' id='Record' value='<fmt:message key="eXH.Record.Label" bundle="${xh_labels}"/>' onClick="record('U')"></td>
<td>
<input class='button' type='button'  name='Cancel' id='Cancel' value='<fmt:message key="eXH.Cancel.Label" bundle="${xh_labels}"/>' onClick='cancel();'></td>
</tr>
</table>
<input type='hidden' name='actualmode' id='actualmode' value='U'>	
<input type='hidden' name='Leval_number' id='Leval_number' value='<%=leval_number%>'>
<input type=hidden name=count >
<input type=hidden name=Filter_group_desc_id value='<%=Filter_group_desc_id%>'> 
<input type=hidden name=Tranaction_number value='<%=tranaction_number%>'> 
<%

}
catch(Exception exp){
         System.out.println("Error in calling getconnection method of dooperate method of FilteringAndSchdulingUpdate.jsp :"+exp.toString());
	     exp.printStackTrace(System.err);
         exceptions=exceptions+"1"+"*"+exp.toString();
     }    
    	
%>

</form>
</body>
</html>

 

