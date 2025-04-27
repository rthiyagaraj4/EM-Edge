<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <%@page  import=" eST.*,eSS.*,eST.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
	<%
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		CheckListBean bean	=		(CheckListBean)getBeanObject( "checkListBean","eSS.CheckListBean", request ) ; String mode1 = ""; 
		bean.setLanguageId(locale);

		String index			=		bean.checkForNull(request.getParameter("index"),"-1");
		String mode				=		request.getParameter("mode");
     	 mode1				=		bean.checkForNull(bean.getMode_Temp(),"");
		String item_code		=		"";
		String item_desc		=		"";
		String qty				=		"";
		String seq_no			=		"";
		String eff_status		=		"";
		String cheked			=		"";
		String cheked1			=		"";
		String disab			=		"";
		String disab1			=		"";
		String disab2			=		"";
		String db_action		=		"";
		String legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");

		item_code				=		request.getParameter("item_code")==null?"":request.getParameter("item_code");
		item_desc				=		request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
		qty						=		request.getParameter("qty")==null?"":request.getParameter("qty");
		//uom_code				=		request.getParameter("uom_code")==null?"":request.getParameter("uom_code");
		seq_no					=		request.getParameter("seq_no")==null?"":request.getParameter("seq_no");
		eff_status				=		request.getParameter("eff_status")==null?"E":request.getParameter("eff_status");
	    
		 String 	mandatory_status = "Y";
		 String 	mandatory_status_temp = "";
         mandatory_status = request.getParameter("mandatory_status")==null?"Y":request.getParameter("mandatory_status");
         mandatory_status_temp = request.getParameter("mandatory_status")==null?"N":request.getParameter("mandatory_status");
		if(mandatory_status.equals("Y"))
				cheked1			=		"checked";
        
		if(item_code!="")
				disab			=		"disabled";
		
		if(eff_status.equals("E"))
				cheked			=		"checked";
				db_action		=		request.getParameter("db_action")==null?"I":request.getParameter("db_action");

		if(mode1.equals("MODE_MODIFY"))
		{     
			    
				disab1			=		"disabled";
	
				cheked1			=		"";
            
			if(mandatory_status_temp.equals("Y"))
			{
	        disab2			=		"disabled";
			}
                
		}	
		if(!index.equals("-1")){
				 legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		if(mandatory_status.equals("Y"))
			{
				cheked1			=		"checked";
			  
			}
		
		}
	
		
		
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eSS/js/CheckList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onLoad="CodeArrest()">
	<form name="KitTemplateAddModifyform" id="KitTemplateAddModifyform">
		<table border='0' cellpadding='0' cellspacing='0' width='100%' height='50%'>
		<th colspan=6 align="left"><fmt:message key="eST.Add/ModifyItem.label" bundle="${st_labels}"/></th>
		<tr>
		     <input type="hidden" name="item_code" id="item_code" value="<%=item_code%>"></td>
			<td class="label" align=right><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan=5 align=left class='label'>&nbsp;<input type=text name="item_desc" id="item_desc" size=70 maxlength=60 value="<%=item_desc%>" <%=disab%>><input type=button name="item_search" id="item_search" class="button"  onClick="callItemSearchScreen(item_code,item_desc)"  value='?'<%=disab%>><%=bean.getImage("M")%>
		</tr>
		<tr>
			<td class=label align="right"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td align=left>&nbsp;<input type=text name="qty" id="qty" size=6 maxlength=6 class="NUMBER" onKeyPress="return isValidInteger();" onblur="" value="<%=qty%>" ><%=bean.getImage("M")%>
			</td>
			<td class=label align=right><!--<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>>-->Mandatory </td>
			<td><input type="checkBox" name="mandatory_status" id="mandatory_status" value="<%=mandatory_status%>" <%=cheked1%> <%=disab1%> onclick="assignValue2(this);"></td>
			<!--<td class="label"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
			<td><select name="uom_code" id="uom_code"><option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option></select><%=bean.getImage("M")%>
			</td>-->
			<td class=label align=right><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
			<td align=left>&nbsp;<input type=text name="seq_no" id="seq_no" size=6 maxlength=4 class="NUMBER" onKeyPress="return CheckForSequence(event);"  onBlur="checkSeqNo(this);" value="<%=seq_no%>" ><%=bean.getImage("M")%>
		</tr>
		<tr>
			<td class=label align=right><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td><input type="checkBox" name="eff_status" id="eff_status" value="<%=eff_status%>" <%=cheked%> <%=disab2%> onclick="assignValue(this);"></td>
			<td class=label align=right colspan='3'>&nbsp;</td>
			<td><input type=button name="save" id="save" value="<%=legend%>" class=button onclick="addToList();">&nbsp;<input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();"></td>
		</tr>
		</table>
		<input type="hidden" name="index" id="index"		value="<%=index%>">
		<input type="hidden" name="db_action" id="db_action"	value="<%=db_action%>">
		<input type="hidden" name="mode" id="mode"	value="<%=mode%>">
		<input type="hidden" name="locale" id="locale"	value="<%=locale%>">
		<input type="hidden" name="SQL_SS_ITEM_LOOKUP" id="SQL_SS_ITEM_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_ITEM_LOOKUP")%>">
	</form>
<%  putObjectInBean("checkListBean",bean,request);
%>
	</body>
	
</html>


