<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% request.setCharacterEncoding("UTF-8");	%>
<%@ page import= "eCommon.Common.CommonBean,eOT.Common.OTRepository" %>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script lanaguage='javascript'>
function windowClosing()
{
	var txtremarks=document.forms[0].txtCheck.value;
	var size=document.forms[0].remarks_size.value;
	var flag=document.forms[0].flag.value;
	if(flag=="1"){
		if(txtremarks.length > size){
			var max_len = getMessage("MAX_LENGTH_DATA","OT");
			var max_len_msg_arr = max_len.split("#");
			//APP-OT0025 # Remarks should not be more than # character
			var errors = max_len_msg_arr[0]+getLabel("Common.operation.label","Common")+max_len_msg_arr[1]+size+max_len_msg_arr[2];
			alert(errors)
			//window.returnValue=txtremarks.substring(0,size-1);
			let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = txtremarks.substring(0,size-1);
			//window.returnValue=txtremarks		
		}else{
			//window.returnValue=txtremarks;
			let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = txtremarks;
		}
	}
	//window.close();
	const dialogTag = parent.document.getElementById("dialog_tag");    
	dialogTag.close();
}
function replaceQuote(){
   var formObj = document.forms[0];
   var str = formObj.remarks.value;
   var repStr = str.replace(/\'/g,"#"); //s.replace(/\./g, "!"); 
   alert(repStr);
}
function checkForSpecCharsforID(event)
{   
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
	//alert("key===="+key)// Get key value from key code
	//alert("event.keyCode===="+event.keyCode)// Get key value from key code
    if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//return (event.keyCode -= 32);
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
function SpecialCharRestriction(event){//This function will not allow special characters and will allow all other language characters apart from english
	var strCheck = "\"`'&<>";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<% 
		// start KDAH-CRF-0283 [IN:050553]
		String calledFrom=checkForNull(request.getParameter("calledFrom"));
		String preOperativeComments = "";
		Connection conn=null;
		PreparedStatement preOperCmntsPstmt = null;
		ResultSet preOperCmntsRs = null;
		try
		{
			if(calledFrom != null && calledFrom.equalsIgnoreCase("pendingOrderTab"))
			{
				conn = ConnectionManager.getConnection(request);
				String orderId = checkForNull(request.getParameter("orderId"));
				System.out.println("=====orderId=====TextAreaRemarks======"+orderId);
				StringBuffer preOperCmntsSqlBuffer = new StringBuffer();
				preOperCmntsSqlBuffer.append("	SELECT order_comment preopercomments	");
				preOperCmntsSqlBuffer.append("	FROM or_order_comment	");
				preOperCmntsSqlBuffer.append("	WHERE order_id = ?		");
				preOperCmntsPstmt = conn.prepareStatement(preOperCmntsSqlBuffer.toString());
				preOperCmntsPstmt.setString(1, orderId);
				preOperCmntsRs = preOperCmntsPstmt.executeQuery();
				while(preOperCmntsRs.next())
					preOperativeComments = checkForNull(preOperCmntsRs.getString("preopercomments"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null) conn.close();
			if(preOperCmntsPstmt != null) preOperCmntsPstmt.close();
			if(preOperCmntsRs != null) preOperCmntsRs.close();
		}
		//end  KDAH-CRF-0283 [IN:050553]
		String size=checkForNull(request.getParameter("size"));
		String title=checkForNull(request.getParameter("heading"));
		String remarks=checkForNull(request.getParameter("remarks"));
		if(remarks.equals("undefined"))
			remarks="";
		String var_temp="";
		if(!("").equals(remarks))
		var_temp=remarks.substring(0,1);
		String chk_status=checkForNull(request.getParameter("chk_status"));
		String cancel_remarks=checkForNull(request.getParameter("cancel_remarks"));
		if(cancel_remarks ==null)
			cancel_remarks="";
		cancel_remarks = java.net.URLDecoder.decode(cancel_remarks,"UTF-8");
		title = java.net.URLDecoder.decode(title,"UTF-8");
		 String readOnly="readOnly";
		 String flag="";
		 flag=checkForNull(request.getParameter("flag"));
		if(flag.equals("1")==true)
			readOnly="";
		//KDAH-CRF-0283 [IN:050553]
		if(calledFrom != null && calledFrom.equalsIgnoreCase("pendingOrderTab")) // KDAH-CRF-0283 [IN:050553]
			remarks = preOperativeComments;
	 %>
<TITLE><%=title%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>
<style>
textarea {
  resize: none;
}
</style>
<BODY class="MESSAGE" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form>
<table  cellspacing='0'>
<tr>
	<td class="label" width='0%' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class="fields" width='0%' >
<%
	if(var_temp.equals("%"))
	{
%>
			<textarea name='txtCheck' rows='5' cols='67' <%=readOnly%> onkeypress="return SpecialCharRestriction(event);"  Onblur="makeValidString(this);" ><%=remarks%></textarea>
<%
	}
	else
	{
%>
			<textarea name='txtCheck' rows='5' cols='67' <%=readOnly%> onkeypress="return SpecialCharRestriction(event);"  Onblur="makeValidString(this);" ><%=remarks%></textarea>
<%
	}
%>
	</td>
	</tr>
<%
	if(chk_status.equals("99"))
	{
%>
		<tr>
		<td class="label"  width='0%' nowrap><fmt:message key="eOT.CancelledRemarks.Label" bundle="${ot_labels}"/></td>
	  <td class="fields" width='0%' ><textarea name='cancel_remark' rows='5' cols='67' <%=readOnly%> onkeypress="return SpecialCharRestriction(event);" Onblur="makeValidString(this);" ><%=cancel_remarks%></textarea></td>
	   </tr>
<%
	}
%>
	
<tr>
	<td class='MESSAGE' colspan='2' align='right'>
		<input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='windowClosing();' >
		<input type='hidden' name='remarks' id='remarks' value="" >
		<input type='hidden' name='remarks_size' id='remarks_size' value="<%=size%>" >
		<input type='hidden' name='flag' id='flag' value="<%=flag%>" >
	</td>
</tr>
</table>
</form>
</body>
</HTML>

