<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html> 
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<style>
		textarea {
		  	resize: none;
		}
	</style>
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript'   src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
		function doInit()
		{
			var val = window.dialogArguments; 
			val = ""+val+"";
			var index 	= -1;
			if ((val != '')||("undefined" != val))
				document.getElementById("msg").value = val ; 
		}

		function doClose()	
		{
			/* window.returnValue = document.getElementById("msg").value;
			window.close(); */
			
			let dialogBody = parent.document.getElementById('dialog-body');
		    dialogBody.contentWindow.returnValue = document.getElementById("msg").value;
			const dialogTag = parent.document.getElementById("dialog_tag");    
		    dialogTag.close(); 
		}

		function checkMaxLimit(obj,maxSize)	
		{
			if ( obj.value.length >= maxSize )
			{
				event.returnValue = false;
			}
		}  

		function closeWin()
		{
			/* if(document.getElementById("msg").value.length > 0)
				window.returnValue = document.getElementById("msg").value;
			else
				window.returnValue ='';
			window.close(); */
			let dialogBody = parent.document.getElementById('dialog-body');
			if(document.getElementById("msg").value.length > 0)
			{				
		    	dialogBody.contentWindow.returnValue = document.getElementById("msg").value;
			}
			else
				dialogBody.contentWindow.returnValue = "";
			
			const dialogTag = parent.document.getElementById("dialog_tag");    
		    dialogTag.close(); 		
			
		}

		function chkLength(Obj,len)
		{
			if(Obj.value.length > parseInt(len))
			{
				alert('The number of characters cannot exceed '+len);
				Obj.focus();Obj.value='';
			}
		}

	</script>

	<title><fmt:message key="eOR.InstructionbyAgeSex.label" bundle="${or_labels}"/></title>
</head>

<body onload='' onUnload ='closeWin()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" >

<%

try
{
	String indexVal = request.getParameter("indexVal");
	//Added by Jyothi.G to fix 25033 on 19/11/2010
	String currMsgTxt = request.getParameter("currMsgTxt") == null ? "" : request.getParameter("currMsgTxt");

	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		
	HashMap recordByAge =  bean.getInstructionStdByAge("IM") ;

	ArrayList  records=null;
	int size = 0;

	if(!recordByAge.isEmpty())
	{
		records  = (ArrayList)recordByAge.get("records");
		size = records.size();
	}
	else
	{
		size =0 ;
	}

	HashMap  currRec = new HashMap();
    if(!indexVal.equals("-1"))
	{
		int indx = Integer.parseInt(indexVal);
		currRec = (HashMap)records.get(indx); 
    }
	
	String MsgText = (String)currRec.get("pat_preps_or_instrns_txt");

	if(MsgText == null) MsgText = currMsgTxt;
%>

<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>
	<tr>
		<td  class='label' width='10%'></td>

		<td  width='90%' class='fields'><textarea name="msg" id="msg" rows="5" cols="60"  onkeypress="checkMaxLimit(this,1000);" onBlur="SPCheckMaxLen('Instruction By Age',this,1000);makeValidString(this);"><%=MsgText%></textarea></td>
	</tr>
</table>

<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>
	<tr>
		<td class='Button' width='100%'><input type='Button' class='Button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doClose()'></td>
	</tr>
</table>
<%
	putObjectInBean(bean_id,bean,request);	
}
catch(Exception e)
{
	System.out.println(e);
}  
%>
</body>
</html>

