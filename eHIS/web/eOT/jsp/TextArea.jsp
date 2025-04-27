<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	%>
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>

<style>
textarea {
  resize: none;
}
</style>
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
			window.returnValue=txtremarks.substring(0,size-1);
			/* let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = (0,size-1); */
			//window.returnValue=txtremarks		
		}else{
			window.returnValue=txtremarks;
			/* let dialogBody = parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = txtremarks; */
		}
	}
	window.close();
	//console.log(parent.document);
	/* const dialogTag = parent.document.getElementById("dialog_tag");    
	dialogTag.close(); */
	
}
function replaceQuote(){
   var formObj = document.forms[0];
   var str = formObj.remarks.value;
   var repStr = str.replace(/\'/g,"#"); //s.replace(/\./g, "!"); 
   alert(repStr);
}
function checkForSpecCharsforID(event)
{   
     var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*&"<>\.';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function SpecialCharRestriction(event){//This function will not allow special characters and will allow all other language characters apart from english
	var strCheck = "\"`'";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
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
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src='../../eXH/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
	
	<% 
		Connection conn = null;
		PreparedStatement pstmt	  = null;
		ResultSet rs		  = null;
		String locale = (String)session.getAttribute("LOCALE"); 
		String facility_id = (String)session.getAttribute("facility_id"); 
		String size=checkForNull(request.getParameter("size"));
		String title=checkForNull(request.getParameter("heading"));
		//String title="Remarks";
		String oper_num=checkForNull(request.getParameter("oper_num"));
		String index=checkForNull(request.getParameter("index"));
		String remarks=checkForNull(request.getParameter("remarks"));
		if(remarks.equals("undefined")) remarks="";
		String chk_status=checkForNull(request.getParameter("chk_status"));
		String cancel_remarks=checkForNull(request.getParameter("cancel_remarks"));
		if(cancel_remarks ==null) cancel_remarks="";
		String called_from=checkForNull(request.getParameter("called_from"));
		if(called_from ==null) called_from="";

		//cancel_remarks = java.net.URLDecoder.decode(cancel_remarks,"UTF-8");
	      //remarks = java.net.URLDecoder.decode(remarks);
		//title = java.net.URLDecoder.decode(title,"UTF-8");
		 String readOnly="readOnly";
		 String flag="";
		 flag=checkForNull(request.getParameter("flag"));
		 if(flag.equals("1")==true)	   readOnly="";

		try{
			if(remarks.equals(""))
			{
			String sql_oper_remarks="SELECT A.OPER_REMARKS FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID = ? AND A.OPERATING_FACILITY_ID= ? AND A.OPER_NUM= ? AND A.OPER_CODE=B.OPER_CODE AND A.OPER_LINE_NUM= ? ";
			conn=ConnectionManager.getConnection(request);
			pstmt = conn.prepareStatement(sql_oper_remarks);
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,oper_num);
			pstmt.setString(4,index);
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				remarks= checkForNull(rs.getString(1));
			}
			}
			}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		if(conn != null)
				ConnectionManager.returnConnection(conn,request);
	}

	 %>

<TITLE><%=title%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>

<BODY class="MESSAGE" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form>
<table  cellspacing='0'>
<tr>
<%if (called_from.equals("Operation_Dtls")) { %>	
<td class="label" width='0%' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
<%}else {%>
<td class="label" width='0%' nowrap></td>
<%}%>
	<td class="fields" width='0%' ><textarea name='txtCheck' id='txtCheck' rows='5' cols='67' <%=readOnly%> Onblur="makeValidString(this);" onKeyPress="return SpecialCharRestriction(event)"><%=remarks%></textarea></td>
	</tr>
		<%if(chk_status.equals("99")) {%>
		<tr>
		<td class="label"  width='0%' nowrap><fmt:message key="eOT.CancelledRemarks.Label" bundle="${ot_labels}"/></td>
	  <td class="fields" width='0%' ><textarea name='cancel_remark' rows='5' cols='67' <%=readOnly%>  Onblur="makeValidString(this);"><%=cancel_remarks%></textarea></td>
	   </tr>

		<%}%>
	
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

