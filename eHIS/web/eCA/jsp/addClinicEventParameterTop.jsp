<!DOCTYPE html>
<!-- addClinicEventParameterTop.jsp -->
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	int count=0;
	
%>
<html>
<head>
	<title></title>
	<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle =
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<style>
	#maintable  td,th,tr 
	{border-bottom: 1px solid #d5e2e5;
	}
	</style>
	
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/ClinicEventParameter.js'></script>		
	<SCRIPT LANGUAGE="JavaScript">
	var prevObjID;
	var prevImgObj;
	var disappeardelay= 250;
	function legendHide()
	{
		var e=window.event;
		if (!e.target) 
			e.target=e.srcElement;
		if(e.target)
		{				
			if(!(e.target.id=='icon0'||e.target.id=='icon1'||e.target.id=='icon4'||e.target.id=='icon5'||e.target.id=='mouse'||e.target.id=='tooltiptable1'||e.target.id=='tooltipimage'||e.target.id=='symbol0'||e.target.id=='symbol1'||e.target.id=='symbol4'||e.target.id=='symbol5'||e.target.id=='selectsymbol0'||e.target.id=='selectsymbol1'||e.target.id=='selectsymbol4'||e.target.id=='selectsymbol5'))
			{	
				hidemenu();
			}
		}
	}
	function resizeWindow(orderctlHDR)
	{		
		var orderctlHDR1 = orderctlHDR.id;	
		
		var wdth = document.getElementById(orderctlHDR1).offsetWidth;
		var hght1 = document.getElementById(orderctlHDR1).offsetHeight;		
		
		var wdth1 = getPos(orderctlHDR).x +wdth;
		var hght = getPos(orderctlHDR).y ;	

		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight
	
		var z = bodwidth- (event.x + wdth);	
		
		var x 	  = event.x;
		var y 	  = event.y;	

		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	
		
		if(x<bodwidth){
			x= wdth1;			
		}else{			
			x = getPos(orderctlHDR).x;
		}
		if(y<bodheight){			
			y = hght;
			
		}else
		{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
		}
		var framecols=parent.parent.contentFrameset.cols
		var tempframe=framecols.split(",");
		if(tempframe[0]=="0")
		{
			x=x-20;
			y=y+21;
		}
		else
		{
			x=x-35;
			y=y+21;
		}
		

		document.getElementById("tooltiplayer").style.left= x+"px";		
		document.getElementById("tooltiplayer").style.top = y+"px";
		document.getElementById("tooltiplayer").style.visibility='visible';
	}

	function displayToolTip(orderctlHD,imgObject,objcount) 
	{	
		var orderctlHDR=document.getElementById(orderctlHD);
		var imgObj=imgObject.id;
		callMouseOverOnTD(orderctlHDR,imgObj);
		buildTable(orderctlHDR,objcount);
		resizeWindow(orderctlHDR);
	}
	
	function callMouseOverOnTD(obj,imgObj){			
		 if (prevObjID != null && prevObjID != obj.id)
		 {			 
			 document.getElementById(prevObjID).className = 'gridData';
			 document.getElementById(prevImgObj).src = "../../eCommon/images/down.gif";			 
		 }		 
		obj.className = 'gridData';
		document.getElementById(imgObj).src = "../../eCommon/images/down.gif";
		prevObjID = obj.id;
		prevImgObj = imgObj;		
	}
	
	function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
			targetElement = inputElement;
			if(targetElement.x && targetElement.y) {
				coords.x = targetElement.x;
				coords.y = targetElement.y;
			} else {
					if(targetElement.offsetParent) {
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
					while(targetElement = targetElement.offsetParent) {
						coords.x += targetElement.offsetLeft;
						coords.y += targetElement.offsetTop;
					}
				} else {
					//alert("Could not find any reference for coordinate positioning.");
				}
			}
			 return coords;
       } catch(error) {
        //alert(error.msg);
        return coords;
       }
    }

	function hidemenu()
	{		
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
	}

	function buildTable(orderctlHDR,objcount) 
	{
		var click_id;		
		var objectid= orderctlHDR.id;
		var click_id= objectid.substring(objectid.length-1);
		
		var row      = ("../../eCA/images/NI_High.gif,../../eCA/images/NI_Low.gif,../../eCA/images/NI_CriticallyHigh.gif,../../eCA/images/NI_CriticallyLow.gif,../../eCA/images/NI_Normal.gif");
		rowval1      = row.split(",");
		var objcount1=objcount;
		var tab_dat  = "<table  class='grid' id='tooltiptable1'  width='' height='100%' align='center'>"
 		for( var i=0; i<rowval1.length; i++ ) {
			var colval1 = rowval1[i];			
			if (colval1 != "" )
			{
				tab_dat   =  tab_dat+"<tr>" ;								

				tab_dat    = tab_dat+ "<td class = 'contextMenuItem'   style='padding-left:10px;padding-right:10px' nowrap id='mouse' ><img src='"+colval1+"' id='tooltipimage' onclick='dispImage(this,"+objcount1+","+click_id+")'  ></img> </td>" ;
				tab_dat     =tab_dat+ "</tr> " ;
			}
		}
			tab_dat     =tab_dat+ "</table> ";		
			console.log(document.getElementById("t"))
		document.getElementById("t").innerHTML = tab_dat;	
	}


	function dispImage(obj,objcount,click_id)
	{
		var temp=obj.src;
		url=temp.split("/");
		var t=url[url.length-1];
		var tempurl="../../eCA/images/"+t;
		if(click_id=="0")		
			document.getElementById("symbol0").src=tempurl;
		else if(click_id=="1")
			document.getElementById("symbol1").src=tempurl;	
		else if(click_id=="4")
			document.getElementById("symbol4").src=tempurl;
		else if(click_id=="5")
			document.getElementById("symbol5").src=tempurl;
		document.getElementById("tooltiplayer").style.visibility = 'hidden';				
	}	
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' onMouseOver='legendHide()' onLoad="FocusFirstElement()" >
<form name='clinic_event_param_form_top' id='clinic_event_param_form_top' action='../../servlet/eCA.ClinicEventParamServlet' method='post' target='messageFrame'>
<%
conlCon = ConnectionManager.getConnection(request);
try
{
StringBuffer sblQry		= new StringBuffer();
String high_value		= "";
String low_value		= "";
String abnml_value		= "";
String crtcl_value		= "";
String crtcl_high_value = "";
String crtcl_low_value  = "";
String deltaValue = "";
String status="";
String high_value_desc ="High";
String high_value_color ="#FFDAB9";
String low_value_desc ="Low";
String low_value_color ="#F0FFFF";
String abnml_value_desc		= "Abnormal";
String abnml_value_color		= "#FFF8DC";
String crtcl_value_desc		= "Critical";
String crtcl_value_color		= "#D2B48C";
String crtcl_low_value_desc		= "Critical Low";
String crtcl_low_value_color		= "#D8BFD8";
String crtcl_high_value_desc		= "Critical High";
String crtcl_high_value_color		= "#F4A460";
String high_value_imageurl="NI_High.gif";
String low_value_imageurl="NI_Low.gif";
String abnormal_value_imageurl="NI_Abnormal.gif";
String critical_value_imageurl="NI_Critical.gif";
String critical_lowvalue_imageurl="NI_CriticallyLow.gif";
String criticalhigh_sym_imageurl="NI_CriticallyHigh.gif";
String legendValue="";


sblQry.append("SELECT high_str, low_str, abn_str, crit_str, crit_high_str, crit_low_str,high_str_desc,high_color_code,low_str_desc,low_color_code,abn_str_desc,abn_color_code,crit_str_desc,crit_color_code,crit_high_str_desc,crit_high_color_code,crit_low_str_desc,crit_low_color_code,DELTA_FAIL_STR,HIGH_SYMBOL_ICON,LOW_SYMBOL_ICON,ABN_SYMBOL_ICON, CRIT_SYMBOL_ICON,CRIT_LOW_SYMBOL_ICON,CRIT_HIGH_SYMBOL_ICON,LEGEND_TYPE FROM cr_clin_event_param");
pstmt = conlCon.prepareStatement(sblQry.toString());
rslRst = pstmt.executeQuery();
if(rslRst.next())
{
		high_value			= rslRst.getString("high_str");
		if(high_value == null || high_value.equals("")) high_value = "";
		low_value			= rslRst.getString("low_str");
		if(low_value == null || low_value.equals("")) low_value = "";
		abnml_value			= rslRst.getString("abn_str");
		if(abnml_value == null || abnml_value.equals("")) abnml_value = "";
		crtcl_value			= rslRst.getString("crit_str");
		if(crtcl_value == null || crtcl_value.equals("")) crtcl_value = "";
		crtcl_high_value	= rslRst.getString("crit_high_str");
		if(crtcl_high_value == null || crtcl_high_value.equals("")) crtcl_high_value = "";
		crtcl_low_value		= rslRst.getString("crit_low_str");
		if(crtcl_low_value == null || crtcl_low_value.equals("")) crtcl_low_value = "";
	
	high_value_imageurl			= rslRst.getString("HIGH_SYMBOL_ICON");	
	if(high_value_imageurl == null || high_value_imageurl.equals("")) high_value_imageurl = "NI_High.gif";
	low_value_imageurl			= rslRst.getString("LOW_SYMBOL_ICON");	
	if(low_value_imageurl == null || low_value_imageurl.equals("")) low_value_imageurl = "NI_Low.gif";
	abnormal_value_imageurl			= rslRst.getString("ABN_SYMBOL_ICON");	
	if(abnormal_value_imageurl == null || abnormal_value_imageurl.equals("")) abnormal_value_imageurl = "NI_Abnormal.gif";
	critical_value_imageurl			= rslRst.getString("CRIT_SYMBOL_ICON");
	if(critical_value_imageurl == null || critical_value_imageurl.equals("")) critical_value_imageurl = "NI_Critical.gif";	
	critical_lowvalue_imageurl			= rslRst.getString("CRIT_LOW_SYMBOL_ICON");
	if(critical_lowvalue_imageurl == null || critical_lowvalue_imageurl.equals("")) critical_lowvalue_imageurl = "NI_CriticallyLow.gif";	
	criticalhigh_sym_imageurl = rslRst.getString("CRIT_HIGH_SYMBOL_ICON");
	if(criticalhigh_sym_imageurl == null || criticalhigh_sym_imageurl.equals("")) criticalhigh_sym_imageurl = "NI_CriticallyHigh.gif";
	legendValue = rslRst.getString("LEGEND_TYPE");
	if(legendValue == null || legendValue.equals("")) legendValue = "S";

    high_value_desc			= rslRst.getString("high_str_desc");
	if(high_value_desc == null || high_value_desc.equals("")) high_value_desc = "High";
	high_value_color			= rslRst.getString("high_color_code");

	if(high_value_color == null || high_value_color.equals("")) high_value_color = "#FFDAB9";

	low_value_desc			= rslRst.getString("low_str_desc");
	if(low_value_desc == null || low_value_desc.equals("")) low_value_desc = "Low";
	low_value_color			= rslRst.getString("low_color_code");
	if(low_value_color == null || low_value_color.equals("")) low_value_color = "#F0FFFF";

	abnml_value_desc			= rslRst.getString("abn_str_desc");
	if(abnml_value_desc == null || abnml_value_desc.equals("")) abnml_value_desc = "Abnormal";
	abnml_value_color			= rslRst.getString("abn_color_code");
	if(abnml_value_color == null || abnml_value_color.equals("")) abnml_value_color = "#FFF8DC";

	crtcl_value_desc			= rslRst.getString("crit_str_desc");
	if(crtcl_value_desc == null || crtcl_value_desc.equals("")) crtcl_value_desc = "Critical";
	crtcl_value_color			= rslRst.getString("crit_color_code");
	if(crtcl_value_color == null || crtcl_value_color.equals("")) crtcl_value_color = "#D2B48C";

	crtcl_high_value_desc			= rslRst.getString("crit_high_str_desc");
	if(crtcl_high_value_desc == null || crtcl_high_value_desc.equals("")) crtcl_high_value_desc = "Critical High";
	crtcl_high_value_color			= rslRst.getString("crit_high_color_code");
	if(crtcl_high_value_color == null || crtcl_high_value_color.equals("")) crtcl_high_value_color = "#F4A460";
	
	crtcl_low_value_desc			= rslRst.getString("crit_low_str_desc");
	if(crtcl_low_value_desc == null || crtcl_low_value_desc.equals("")) crtcl_low_value_desc = "Critical Low";
	crtcl_low_value_color			= rslRst.getString("crit_low_color_code");
	if(crtcl_low_value_color == null || crtcl_low_value_color.equals("")) crtcl_low_value_color = "#D8BFD8";

		deltaValue		= rslRst.getString("DELTA_FAIL_STR");
		if(deltaValue == null || deltaValue.equals("")) deltaValue = "";
		
			out.println("<input type=hidden name='mode' id='mode' value='update'>");
}
else
{
			out.println("<input type=hidden name='mode' id='mode' value='insert'>");
}
%>

<table class='grid' width='90%' align=center  id='maintable'  >

<tr>
	<td class='COLUMNHEADERCENTER' width='24%'></td>
	<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='15%'><fmt:message key="Common.Color.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='11%'><fmt:message key="eCA.SymbolicLegends.label" bundle="${ca_labels}"/></td>		
</tr>
<tr>
	<td  class="gridData" width='24%' id='label0'><fmt:message key="Common.HighValue.label" bundle="${common_labels}"/></td>
	<td  class="gridData" width='10%'><input type='text' name='high_value' id='high_value' size='1' maxlength='1' onBlur='ChangeUpperCase(this)' <% if(!(high_value == null || high_value.equals(""))) {out.println("value = '"+high_value+"' readonly");}%>><img src='../../eCommon/images/mandatory.gif'></img></td>
    <td  class="gridData" width='20%'><input type='text' name='high_value_desc' id='high_value_desc' value="<%=high_value_desc%>" id='value0' onBlur='chkDescAndColor(this,0,"high")' size=25 maxlength=30><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td  class="gridData" width='15%' ><input type='text' name='high_value_color' id='high_value_color' id='color0' size='1' maxlength='1' STYLE="background-color:<%=high_value_color%>" readOnly><img src='../../eIP/images/showColor.gif' onClick='getColor("high");'<%=status%>></img></td>
	<td class="gridData"  style='text-align:center' width='11%' id="icon0"><img src='../../eCA/images/<%=high_value_imageurl%>' id="symbol0" name="symbolicobj0"></img>&nbsp;<img id='selectsymbol0' src='../../eCommon/images/down.gif' onClick='displayToolTip("icon0",this,<%=count%>)' ></img></td>	
</tr>
<tr>
	<td  class="gridData" width='24%' id='label1'><fmt:message key="Common.LowValue.label" bundle="${common_labels}"/></td>
	<td  class="gridData" width='10%'><input type='text' name='low_value' id='low_value' size='1' maxlength='1' onBlur='ChangeUpperCase(this)'  <% if(!(low_value == null || low_value.equals(""))){out.println("value = '"+low_value+"' readonly");}%>><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td  class="gridData" width='20%'><input type='text' name='low_value_desc' id='low_value_desc' value="<%=low_value_desc%>"  id='value1' onBlur='chkDescAndColor(this,1,"low")' size=25 maxlength=30><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td width='15%' class='gridData' ><input type='text' name='low_value_color' id='low_value_color'  id='color1' size='1' maxlength='1' STYLE="background-color:<%=low_value_color%>" readOnly><img src='../../eIP/images/showColor.gif' onClick='getColor("low");'<%=status%>></img></td>
	<td class="gridData" style='text-align:center' width='11%' id="icon1"><img src='../../eCA/images/<%=low_value_imageurl%>' id="symbol1" name="symbolicobj1"></img>&nbsp;<img id='selectsymbol1' src='../../eCommon/images/down.gif' onClick='displayToolTip("icon1",this,<%=count%>)' ></img></td>
</tr>
<tr>
	<td  class="gridData" width='24%' id='label2'><fmt:message key="eCA.AbnormalValue.label" bundle="${ca_labels}"/></td>
	<td  class="gridData" width='10%'><input type='text' name='abnml_value' id='abnml_value' size='1' maxlength='1' onBlur='ChangeUpperCase(this)'  <% if(!(abnml_value == null || abnml_value.equals(""))) {out.println("value = '"+abnml_value+"' readonly");}%>><img src='../../eCommon/images/mandatory.gif'></img></td>
    <td  class="gridData" width='20%'><input type='text' name='abnml_value_desc' id='abnml_value_desc' value="<%=abnml_value_desc%>"  id='value2' onBlur='chkDescAndColor(this,2,"abnml")' size=25 maxlength=30><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td width='15%' class='gridData' ><input type='text' name='abnml_value_color' id='abnml_value_color'  id='color2' size='1' maxlength='1' STYLE="background-color:<%=abnml_value_color%>" readOnly><img src='../../eIP/images/showColor.gif' onClick='getColor("abnormal");'<%=status%>></img></td>
	<td class="gridData" style='text-align:center' width='11%'  id="icon2"><img src='../../eCA/images/<%=abnormal_value_imageurl%>' id="symbol2" name="symbolicobj2"></img>&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
	<td  class="gridData" width='24%' id='label3' ><fmt:message key="eCA.CriticalValue.label" bundle="${ca_labels}"/></td>
	<td  class="gridData" width='10%' ><input type='text' name='crtcl_value' id='crtcl_value' size='1'  maxlength='1' onBlur='ChangeUpperCase(this)'  <% if(!(crtcl_value == null || crtcl_value.equals(""))) {out.println("value = '"+crtcl_value+"' readonly");}%>><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td  class="gridData" width='20%'><input type='text' name='crtcl_value_desc' id='crtcl_value_desc' value="<%=crtcl_value_desc%>"  id='value3'  onBlur='chkDescAndColor(this,3,"crtcl")' size=25 maxlength=30><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td width='15%' class='gridData' ><input type='text' name='crtcl_value_color' id='crtcl_value_color' id='color3' size='1' maxlength='1' STYLE="background-color:<%=crtcl_value_color%>" readOnly><img src='../../eIP/images/showColor.gif' onClick='getColor("critical");'<%=status%>></img></td>
	<td class="gridData" style='text-align:center' width='11%'  id="icon3" ><img src='../../eCA/images/<%=critical_value_imageurl%>' id="symbol3" name="symbolicobj3"></img>&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
	<td  class="gridData" width='24%' id='label4' ><fmt:message key="Common.CriticalLowValue.label" bundle="${common_labels}"/></td>
	<td  class="gridData" width='10%'><input type='text' name='crtcl_low_value' id='crtcl_low_value' size='1' maxlength='1' onBlur='ChangeUpperCase(this)'  <% if(!(crtcl_low_value == null || crtcl_low_value.equals(""))) {out.println("value = '"+crtcl_low_value+"' readonly");}%>><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td  class="gridData" width='20%'><input type='text' name='crtcl_low_value_desc' id='crtcl_low_value_desc' value="<%=crtcl_low_value_desc%>"  id='value4'  onBlur='chkDescAndColor(this,4,"crtcl_low")' size=25 maxlength=30><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td width='15%' class='gridData' ><input type='text' name='crtcl_low_value_color' id='crtcl_low_value_color'  id='color4' size='1' maxlength='1' STYLE="background-color:<%=crtcl_low_value_color%>" readOnly><img src='../../eIP/images/showColor.gif' onClick='getColor("criticallow");'<%=status%>></img></td>
	<td class="gridData" style='text-align:center' width='11%' id="icon4"><img src='../../eCA/images/<%=critical_lowvalue_imageurl%>' id="symbol4" name="symbolicobj4"></img>&nbsp;<img  onClick='displayToolTip("icon4",this,<%=count%>)' id='selectsymbol4' src='../../eCommon/images/down.gif'  ></img></td>
</tr>
<tr>
	<td  class="gridData" width='24%' id='label5'><fmt:message key="Common.CriticalHighValue.label" bundle="${common_labels}"/></td>
	<td  class="gridData" width='10%'><input type='text' name='crtcl_high_value' id='crtcl_high_value' size='1'  maxlength='1' onBlur='ChangeUpperCase(this)'  <% if(!(crtcl_high_value == null || crtcl_high_value.equals(""))) {out.println("value = '"+crtcl_high_value+"' readonly");}%>><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td  class="gridData" width='20%'><input type='text' name='crtcl_high_value_desc' id='crtcl_high_value_desc' value="<%=crtcl_high_value_desc%>"  id='value5'  onBlur='chkDescAndColor(this,5,"crtcl_high")'size=25 maxlength=30><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td width='15%' class='gridData' ><input type='text' name='crtcl_high_value_color' id='crtcl_high_value_color'  id='color5' size='1' maxlength='1' STYLE="background-color:<%=crtcl_high_value_color%>" readOnly><img src='../../eIP/images/showColor.gif' onClick='getColor("criticalhigh");'<%=status%>></img></td>
	<td class="gridData" style='text-align:center' width='11%' id="icon5"><img src='../../eCA/images/<%=criticalhigh_sym_imageurl%>' id="symbol5" name="symbolicobj5"></img>&nbsp;<img src='../../eCommon/images/down.gif'  id='selectsymbol5' onClick='displayToolTip("icon5",this,<%=count%>)'></img></td>
</tr>
<tr>
	<td  class="gridData" width='24%'><fmt:message key="eCA.DeltaValue.label" bundle="${ca_labels}"/></td>
	<td  class="gridData" width='10%'><input type='text' name='delta_value' id='delta_value' size='1' maxlength='1' onBlur='ChangeUpperCase(this)'  value='<%=deltaValue%>' <%if(!deltaValue.equals("")) out.println("readOnly");%>><MAP NAME=""><AREA SHAPE="" HREF="" COORDS="" ALT=""></MAP></td>
	<td  class="gridData" width='20%' >&nbsp;</td>
	<td  class="gridData" width='15%' >&nbsp;</td>
	<td  class="gridNumericData" width='11%'>&nbsp;</td>
	<%count++;%>
</tr>
</table>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='' height='100%' align='center'>
		<tr>
			<td width='100%' id='t'></td>
			</td>
		</tr>
	</table>
</div>

<table  width='90%' align=center id='symcolortbl'>
	<tr>
		<%if(legendValue.equals("S")) {%> 
		<td class='gridData' style='border: none;'><fmt:message key="eCA.NormalcyIndicator.label" bundle="${ca_labels}"/>&nbsp;&nbsp;<input type=radio name=sym_color value='S' checked  ><fmt:message key="eCA.Symboliclegends.label" bundle="${ca_labels}"/>&nbsp;&nbsp;<input type=radio name=sym_color value='C'  ><fmt:message key="eCA.Colourlegends.label" bundle="${ca_labels}"/>
		</td>
		<%}else{%>
		<td class='gridData' style='border: none;'><fmt:message key="eCA.NormalcyIndicator.label" bundle="${ca_labels}"/>&nbsp;&nbsp;<input type=radio name=sym_color value='S'   ><fmt:message key="eCA.Symboliclegends.label" bundle="${ca_labels}"/>&nbsp;&nbsp;<input type=radio name=sym_color value='C' checked ><fmt:message key="eCA.Colourlegends.label" bundle="${ca_labels}"/>
		</td>
		<%}%>
	</tr>
</table>
</form>
<%
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in addClinicEventParameterTop.jsp"+e.toString());//COMMON-ICN-0181
         e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(conlCon !=null)ConnectionManager.returnConnection(conlCon,request);
}
%>
</body>
</html>

