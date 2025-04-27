<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%String param=request.getParameter("msg"); 
	if(param == null) param="";
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
	
	<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script>
	function populateSource(Obj)
	{	
		var u=document.forms[0].msg.value;
		if(Obj.value.length >0)
		{
		if(Obj.value == "XF")
		{
		document.getElementById("pract").innerHTML="<input type='text' name='practitioner' id='practitioner'>";
		document.getElementById('pract_type').innerText='';
		var HTMLVal  =  "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='form1' id='form1' action='../jsp/FetchValForBooking.jsp'>"
		  HTMLVal += "<input type='hidden' name='source_type' id='source_type' value='"+Obj.value+"'>"
		  if(u.length >0){
		  HTMLVal += "<input type='hidden' name='param' id='param' value='msg'>"
		  HTMLVal += "</form></body></html>";
		  parent.parent.frames[2].document.write(HTMLVal);
		  parent.parent.frames[2].document.form1.submit();
		  }
		  else
		  {
		  HTMLVal += "</form></body></html>";
		   parent.frames[2].document.write(HTMLVal);
		  parent.frames[2].document.form1.submit();
		  }
		  	  
		}
		else
		{
		document.getElementById("pract").innerHTML="<SELECT name='practitioner' id='practitioner' onChange='populateDesc(this)'><option value=''>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;</SELECT>";
		var HTMLVal  =  "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+IeStyle.css+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='form1' id='form1' action='../jsp/FetchValForBooking.jsp'>"
		  HTMLVal += "<input type='hidden' name='source_type' id='source_type' value='"+Obj.value+"'>"
		  if(u.length >0){
		  HTMLVal += "<input type='hidden' name='param' id='param' value='msg'>"
		  HTMLVal += "</form></body></html>"
		  parent.parent.frames[2].document.write(HTMLVal);
		  parent.parent.frames[2].document.form1.submit();
		  }
		  else
		  {
		  HTMLVal += "</form></body></html>"
		   parent.frames[2].document.write(HTMLVal);
		  parent.frames[2].document.form1.submit();
		  }
	  	}
	  }
	  
	  else
	  {
	  document.getElementById("pract").innerHTML="<SELECT name='practitioner' id='practitioner' onChange='populateDesc(this)'><option value=''>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;</SELECT>";
	  document.getElementById('pract_type').innerText='';
	  var len=document.forms[0].source.length;
	  	var i=1;
	  	while(i<len)
	  	{
	  		len=document.forms[0].source.length;
	  		document.forms[0].source.remove(i);
		}
		
	 var len1=document.forms[0].practitioner.length;
		var i1=1;
		while(i1<len1)
		{
			len1=document.forms[0].practitioner.length;
			document.forms[0].practitioner.remove(i1);
		}
	  
	 }
}
	
	function populatePractitioner(Obj1,Obj2)
	{
	var u=document.forms[0].msg.value;
	document.getElementById('pract_type').innerText='';
	var len1=document.forms[0].practitioner.length;
	var i1=1;
	while(i1<len1)
	{
	len1=document.forms[0].practitioner.length;
	document.forms[0].practitioner.remove(i1);
	}
	var source=Obj2.value;
	var HTMLVal  =  "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+IeStyle.css+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='form1' id='form1' action='../jsp/FetchValForBooking.jsp'>"
	  HTMLVal += "<input type='hidden' name='pract_name' id='pract_name' value='"+Obj1.value+"'>"
	  HTMLVal += "<input type='hidden' name='source' id='source' value='"+source+"'>"
	 if(u.length >0){
	  HTMLVal += "<input type='hidden' name='param' id='param' value='msg'>"
	  HTMLVal += "</form></body></html>";
	  parent.parent.frames[2].document.write(HTMLVal);
	  parent.parent.frames[2].document.form1.submit();
	  }
	  else
	  {
	  HTMLVal += "</form></body></html>";
	   parent.frames[2].document.write(HTMLVal);
	  parent.frames[2].document.form1.submit();
	  }
	
	}
	
	function populateDesc(Obj3)
	{
		var u=document.forms[0].msg.value;
		if(Obj3.value.length >0)
		{
		var HTMLVal  =  "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+IeStyle.css+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='form1' id='form1' action='../jsp/FetchValForBooking.jsp'>"
		  HTMLVal += "<input type='hidden' name='pract' id='pract' value='"+Obj3.value+"'>"
		 if(u.length >0){
		  HTMLVal += "<input type='hidden' name='param' id='param' value='msg'>"
		  HTMLVal += "</form></body></html>";
		  parent.parent.frames[2].document.write(HTMLVal);
		  parent.parent.frames[2].document.form1.submit();
		  }
		  else
		  {
		  HTMLVal += "</form></body></html>";
		   parent.frames[2].document.write(HTMLVal);
		  parent.frames[2].document.form1.submit();
		  }
	  	}
	  	else
	  	document.getElementById('pract_type').innerText='';
	}
	
	</script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	</head>

	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<table width='100%' border='0' cellpadding='0' cellspacing='0'>
	<tr>
	   <th align ='left' colspan=7><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></th>
        </tr>	
	<tr>
           <td width='8%'><input type='hidden' name='msg' id='msg' value='<%=param%>' > </td>
	   <td align='right' class='label' width='10%'><fmt:message key="eOR.SourceType.label" bundle="${or_labels}"/></td>
	   <td align='left' width='20%'>
	   	<select name='source_type' id='source_type' onChange='populateSource(this)'>&nbsp;
	   	<option value=''>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;</option>
	   	<option value='XF'><fmt:message key="Common.externalfacility.label" bundle="${common_labels}"/>
	   	<option value='ZF'><fmt:message key="Common.enterprisefacility.label" bundle="${common_labels}"/>
	   	<option value='OP'><fmt:message key="eIP.OutpatientLocation.label" bundle="${ip_labels}"/>
	   	</select>
	   </td>
	   <td align='left' class='label' colspan='4' width='60%'>&nbsp;<fmt:message key="Common.source.label" bundle="${common_labels}"/>&nbsp;
	   <SELECT name="source" id="source" onChange='populatePractitioner(this,source_type)'><option value=''>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;</SELECT>
   	   </td>
        </tr>
         
	<tr>
	   <td>&nbsp;</td>
	   <td align='right' class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</td>
	   <td align='left' id='pract'><SELECT name="practitioner" id="practitioner" onChange='populateDesc(this)' ><option value=''>&nbsp;------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;</SELECT>&nbsp;</td>
	   <td align='left' id='pract_type' class='label'> </td>
	   <td colspan='3'>&nbsp;</td>	   
        </tr>        
</table>

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

