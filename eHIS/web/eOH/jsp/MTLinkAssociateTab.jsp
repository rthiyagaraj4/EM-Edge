<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eOH.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page import ="eOH.*, eOH.Common.*,java.util.ArrayList,java.util.Hashtable,java.util.Map "   %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../js/OrderSet.js'></script>
    <script language='javascript' src='../../eOH/js/MTasksLink.js'></script>
	<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

</head>
 <jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
    Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_mt_id		= "@MTLinkBean";
	String bean_mt_name	= "eOH.MTLinkBean";
	MTLinkBean bean_mt= (MTLinkBean)mh.getBeanObject( bean_mt_id, request, bean_mt_name );
	//HashMap checkedRow=(HashMap)bean_mt.getCheckedRow();
	//HashMap checkedMap=(HashMap)bean_mt.getCheckedMap();
	ArrayList checkedArray=null;
	checkedArray=(ArrayList)bean_mt.getCheckedArray();
    
	String from = checkForNull(request.getParameter( "from" )) ;
    String to =   checkForNull(request.getParameter( "to" ) ) ;
    String treatment_code=checkForNull(request.getParameter("treatment_code"));
    String multiple_yn=checkForNull(request.getParameter("multiple_yn"));
    String select_value="Y";
    String task_code = "";
    String task_desc = "";
    String seq_no = checkForNull(request.getParameter("seq_no"));
    String mode="";
    String sel="";
    String select_checked="";
	String classValue ="";
	int start = ( from.equals("") )?0:Integer.parseInt(from);
    int end =  ( to.equals("") )?6:Integer.parseInt(to);
	int maxRecord=checkedArray.size();
    maxRecord=maxRecord/3;
	if(maxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
  %>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="MtLinkAssociateForm" id="MtLinkAssociateForm" >
<table align='right' border=0>
			<tr>
				<td>
				<%
					if ( !(start <= 0) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous_associate();'>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
					if ( !( (start+8) > maxRecord ) )
					out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next_associate();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");
				%>
				</td>
			</tr>
</table>
		<br><br>
		<table border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
			<tr>
				<td class='columnHeader'  width="30%" align="center">
					<fmt:message key="eOH.TaskCode.Label" bundle="${oh_labels}"/>
				</td>
				<td class="columnHeader" width='30%' align="center">
					<fmt:message key="eOH.TaskDescription.Label" bundle="${oh_labels}"/>
				</td>
				<td class="columnHeader" width='30%' align="center">
					<fmt:message key="eOR.SeqNo.label" bundle="${or_labels}"/>
				</td>
				<td class="columnHeader" width='30%' align="center">
					<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</td>
			</tr>
		
<% 
	 for(int j=start*3,i=0,l=start;j<checkedArray.size() && l<start+7;j=j+3,l++)
	{  
		//int count=0;
		if ( i % 2 == 0 )
		classValue = "QRYODD" ;
		else
		classValue = "QRYEVEN" ;
		
		task_code= (String)checkedArray.get(j);
        task_desc=(String)checkedArray.get(j+1);
		//task_desc=java.net.URLDecoder.decode(task_desc,"UTF-8"); //commented by sridevi joshi on 260908.
		seq_no= (String)checkedArray.get(j+2);
		//seq_no= (String)checkedMap.get(task_code);
		
	   
	
		if(seq_no!=null)
		{
        select_checked="checked";
		select_value="Y";
		}
		
		out.println("<tr>");
		out.println("<td class='" + classValue+"' width='30%'>"+task_code+"</td>");
		out.println("<td class='" + classValue+"' width='30%'>"+task_desc+"</td>");
		out.println("<td class='" + classValue+"' width='20%'><input type='text' name='seq_no"+i+"' id='seq_no"+i+"' size='3' maxlength='3' value='"+seq_no+"' task_code='"+task_code+"'task_desc='"+task_desc+"' seq_no='"+seq_no+"' select_yn='"+select_value+"' db_change_seq_yn='N' value_yn='"+seq_no+"' mode='"+mode+"' onBlur=\"return validateSeqNo(this,'"+i+"')\"; onKeyPress='return allowNumOnly(event);'></td>");


		out.println("<td class='" + classValue+"' width='30%'><input type=checkbox name=chk_select"+i+" value="+select_value+" "+select_checked+" task_code='"+task_code+"'task_desc='"+task_desc+"'sel='"+sel+"' db_change='N' seq_no='"+seq_no+"' select_yn='"+select_value+"' mode='"+mode+"' onclick=\" setCheckedRow(this);removeCheckedRow(this);\">");
		
		
		
		i++;
		
		
	}
	

	
%>
   
	  
	
</table>

<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type="hidden" name="treatment_code" id="treatment_code" value="<%=treatment_code%>" >
<input type="hidden" name="multiple_yn" id="multiple_yn" value="<%=multiple_yn%>" >
</form>
</body>
</html>

