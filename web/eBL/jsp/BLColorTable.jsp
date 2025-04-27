<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
27/07/2020 	  		       Ram kumar S											NMC-JD-CRF-0042
-------------------------------------------------------------------------------------------------
*/ 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title><fmt:message key="eIP.ColorSchemeTable.label" bundle="${ip_labels}"/></title> 
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <style type="text/css">
td
{
height: 10px;
	width: 10px;
}
</style>

<script>
	/*function getFontColor(object)
	{
		//window.returnValue = object.style.backgroundColor;
		let dialogBody = parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = object.style.backgroundColor;
		alert("returnValue :" +object.style.backgroundColor);
		const dialogTag = parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
	}*/
	function getFontColor(object)
	{
		//alert("object.style.backgroundColor:"+object.style.backgroundColor);
		//window.returnValue = object.style.backgroundColor;
		    const rgb = object.style.backgroundColor;
 
    // Convert RGB to HEX
    const rgbValues = rgb.match(/\d+/g);
		 const hex = rgbValues ? '#' + rgbValues.map(value => {
        const hexValue = parseInt(value).toString(16);
        return hexValue.length === 1 ? '0' + hexValue : hexValue; // Ensure two digits
    }).join('') : rgb; // Fallback to original value if parsing fails
 
    //alert("Hex color: " + hex);
		let dialogBody = parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = hex;
		const dialogTag = parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
	}
	</script>
</head>	
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<table BGCOLOR="#ffffff" BORDER="0" CELLSPACING=2 CELLPADDING=1 WIDTH='250px' HEIGHT='250px' border=0 margin-bottom="25px";>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FAEBD7" ALIGN=CENTER width='auto'></TD> 
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#00FFFF" ALIGN=CENTER width='auto'></TD>			
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#7FFFD4" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#F0FFFF" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#F5F5DC" ALIGN=CENTER width='auto'></TD>			
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFE4C4" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#00CED1" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFEBCD" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#0000FF" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#8A2BE2" ALIGN=CENTER width='auto'></TD>
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#DEB887" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#5F9EA0" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#7FFF00" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#D2691E" ALIGN=CENTER width='auto'></TD>
			 	<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FF7F50" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#9ACD32" ALIGN=CENTER width='auto'></TD>				
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFF8DC" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#DC143C" ALIGN=CENTER width='auto'></TD>			 	
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#00FFFF" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#008B8B" ALIGN=CENTER width='auto'></TD>
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#008080" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#B8860B" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFFF00" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#A9A9A9" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#BDB76B" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#556B2F" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FF8C00" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#9932CC" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#8FBC8B" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FF6347" ALIGN=CENTER width='auto'></TD>
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#9400D3" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FF1493" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#00BFFF" ALIGN=CENTER width='auto'></TD>				
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#696969" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#B22222" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#228B22" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#DCDCDC" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFD700" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#EE82EE" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#D8BFD8" ALIGN=CENTER width='auto'></TD>
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#DAA520" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#808080" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#008000" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#ADFF2F" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#F0FFF0" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FF69B4" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#CD5C5C" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#F0E68C" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#E6E6FA" ALIGN=CENTER width='auto'></TD>				
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFF0F5" ALIGN=CENTER width='auto'></TD>
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFFACD" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#ADD8E6" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#F08080" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#E0FFFF" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FAFAD2" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#90EE90" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#D3D3D3" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFB6C1" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFA07A" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#20B2AA" ALIGN=CENTER width='auto'></TD>
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#B0C4DE" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFFFE0" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#00FF00" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#32CD32" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FAF0E6" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FF00FF" ALIGN=CENTER width='auto'></TD>				
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#66CDAA" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#0000CD" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#BA55D3" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#9370DB" ALIGN=CENTER width='auto'></TD>
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#3CB371" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#7B68EE" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#00FA9A" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#48D1CC" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#C71585" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#F5FFFA" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFE4E1" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFE4B5" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#778899" ALIGN=CENTER width='auto'></TD>				
 				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFDEAD" ALIGN=CENTER width='auto'></TD> 
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#6B8E23" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFA500" ALIGN=CENTER width='auto'></TD>				
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FF4500" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#DA70D6" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#EEE8AA" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#98FB98" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#AFEEEE" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#DB7093" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFEFD5" ALIGN=CENTER width='auto'></TD>
 				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFDAB9" ALIGN=CENTER width='auto'></TD> 
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#CD853F" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FFC0CB" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#DDA0DD" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#B0E0E6" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FF0000" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#BC8F8F" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#4169E1" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#FA8072" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#F4A460" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#2E8B57" ALIGN=CENTER width='auto'></TD>
		</tr>
		<tr>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#C0C0C0" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#87CEEB" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#6A5ACD" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#708090" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#00FF7F" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#4682B4" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#D2B48C" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#40E0D0" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#87CEFA" ALIGN=CENTER width='auto'></TD>
				<TD title='Click inside a color box to choose the particular color' onClick='getFontColor(this)' STYLE="background-color:#7CFC00" ALIGN=CENTER width='auto'></TD>
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


