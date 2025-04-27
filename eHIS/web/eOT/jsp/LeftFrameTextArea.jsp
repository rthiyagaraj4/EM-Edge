<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%
	Properties prop = (Properties) session.getAttribute("jdbc");
	String locale = (String) prop.get("LOCALE");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String title=checkForNull(request.getParameter("heading"));
    String remarks=checkForNull(request.getParameter("para"));
	String disable_flag = checkForNull(request.getParameter("disable_flag"));
	String size= checkForNull(request.getParameter("size"));
%>
<HTML>
<TITLE> <%=title%></title>
<HEAD>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script lanaguage='javascript'>

function checkForSpecCharsforID(event)
{
   var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@ #$*-_= (),.;:?/"\|^{}[]- ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


function CheckChars2(Obj){
        var str = Obj.value;
        var specCharsExist = false;
        for (u=0;u<str.length;u++){
			//alert("str.charCodeAt(u)==="+str.charCodeAt(u))
            if (((str.charCodeAt(u)>=42) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)|| (str.charCodeAt(u)==32)|| (str.charCodeAt(u)==61) || (str.charCodeAt(u)==13) || (str.charCodeAt(u)==10));
            else{
                specCharsExist = true;
                break;
            }
        }
		//alert("specCharsExist==="+specCharsExist)
        return specCharsExist;
    }
	function CheckChars1(obj)
	{  //alert("obj==="+obj.value) 
	   var specCharsExist=CheckChars2(obj);
       //alert(specCharsExist)
	   
	   if(specCharsExist==true) 
		{
		 //alert("Special Characters other than _ * / - . , = +  are not allowed");
		 alert(getMessage("APP-OT0162","OT"));
		
		  obj.focus();
	      return;
		}
	}
	
	function checkOK(){
		 window.returnValue=document.forms[0].txtCheck.value;	 	
		 window.close();
	 }

	function checkClose(){
		window.returnValue=document.forms[0].previous.value;
		window.close();
	}
	function checkLimit(field, limit){
		 if (field.value.length > limit){
		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		   // Truncate at the limit
		   var revertField = field.value.slice(0,limit);
		   field.value = revertField;
		   field.focus();
		  }
	}
function checkForSpecCharsforID(event)
{
	//function used for spl chars
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@ #$*-_= (),.;:?/"\|^{}[]-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(event.keyCode==37 || event.keyCode==38 || event.keyCode==94 || event.keyCode==60 || event.keyCode==43){
		return false
	}else
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return true ;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form>
<table  cellspacing='0'>
<tr>
	<td>
		<textarea name='txtCheck' rows='5' cols='67' <%=disable_flag%> onkeypress="return checkForSpecCharsforID(event);" Onblur="checkLimit(this,<%=size%>);makeValidString(this);"><%=remarks%></textarea>
	</td>
</tr>
<tr>
	<td align='center'>
		<input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='checkOK();' >
	</td>
</tr>
</table>
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
</form>
</body>
</HTML>

