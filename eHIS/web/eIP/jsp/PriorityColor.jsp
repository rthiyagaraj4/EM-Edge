<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");  %>
<%
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Module		: IP
// Created By   : SRIDHAR R 
// Created Date : 28 APR 2004

// Function		: This page is called to display colors in a modal Window & return the 					  ColorCode.. 

// CAlling Page : "../../eIP/jsp/addModifyPriority.jsp"
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
	<head>
  <title><fmt:message key="eIP.ColorSchemeTable.label" bundle="${ip_labels}"/></title> 
  <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	</head>	
	<script>
	function getFontColor(object)
	{
		window.returnValue = object.style.backgroundColor;
		const dialogTag = parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
	}
	</script>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<table BGCOLOR="#000000" BORDER="0" CELLSPACING=3 CELLPADDING=0 WIDTH='380px' HEIGHT='380px'>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:antiquewhite" ALIGN=CENTER width='auto'></td> 
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:aqua" ALIGN=CENTER width='auto'></td>			
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:aquamarine" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:azure" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:beige" ALIGN=CENTER width='auto'></td>			
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:bisque" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkturquoise" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:blanchedalmond" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:blue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:blueviolet" ALIGN=CENTER width='auto'></td>
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:burlywood" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:cadetblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:chartreuse" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:chocolate" ALIGN=CENTER width='auto'></td>
			 	<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:coral" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:yellowgreen" ALIGN=CENTER width='auto'></td>				
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:cornsilk" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:crimson" ALIGN=CENTER width='auto'></td>			 	
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:cyan" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkcyan" ALIGN=CENTER width='auto'></td>
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:teal" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkgoldenrod" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:yellow" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkgray" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkkhaki" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkolivegreen" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkorange" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkorchid" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkseagreen" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:tomato" ALIGN=CENTER width='auto'></td>
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:darkviolet" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:deeppink" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:deepskyblue" ALIGN=CENTER width='auto'></td>				
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:dimgray" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:firebrick" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:forestgreen" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:gainsboro" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:gold" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:violet" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:thistle" ALIGN=CENTER width='auto'></td>
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:goldenrod" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:gray" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:green" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:greenyellow" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:honeydew" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:hotpink" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:indianred" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:khaki" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lavender" ALIGN=CENTER width='auto'></td>				
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lavenderblush" ALIGN=CENTER width='auto'></td>
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lemonchiffon" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightcoral" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightcyan" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightgoldyellow" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightgreen" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightgrey" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightpink" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightsalmon" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightseagreen" ALIGN=CENTER width='auto'></td>
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightsteelblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightyellow" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lime" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:limegreen" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:linen" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:magenta" ALIGN=CENTER width='auto'></td>				
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:medaquamarine" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mediumblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mediumorchid" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mediumpurple" ALIGN=CENTER width='auto'></td>
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mediumseagreen" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mediumslateblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mediumspringgrn" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mediumturquoise" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mediumvioletred" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mintcream" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:mistyrose" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:moccasin" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightslategray" ALIGN=CENTER width='auto'></td>				
 				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:navajowhite" ALIGN=CENTER width='auto'></td> 
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:olivedrab" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:orange" ALIGN=CENTER width='auto'></td>				
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:orangered" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:orchid" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:palegoldenrod" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:palegreen" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:paleturquoise" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:palevioletred" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:papayawhip" ALIGN=CENTER width='auto'></td>
 				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:peachpuff" ALIGN=CENTER width='auto'></td> 
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:peru" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:pink" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:plum" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:powderblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:red" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:rosybrown" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:royalblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:salmon" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:sandybrown" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:seagreen" ALIGN=CENTER width='auto'></td>
		</tr>
		<tr>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:silver" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:skyblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:slateblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:slategray" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:springgreen" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:steelblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:tan" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:turquoise" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lightskyblue" ALIGN=CENTER width='auto'></td>
				<td title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:lawngreen" ALIGN=CENTER width='auto'></td>
			</tr>
	  </table> 
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

