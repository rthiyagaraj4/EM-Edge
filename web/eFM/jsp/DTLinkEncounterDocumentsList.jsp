<!DOCTYPE html>
<%@page import="java.util.ArrayList, java.util.Iterator" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	HttpSession session1 =request.getSession();

	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/DTLinkEncounterVolumeDocType.js'></script>
	<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String class_value			=	"QRYEVEN";
	String maintain_doc_or_file	=	request.getParameter("maintain_doc_or_file");
	String status         =request.getParameter("status");
	String cnt=request.getParameter("count");
	String first_time=request.getParameter("first_time");
	String chkstatus="";
	if(first_time==null) first_time="";
	Integer cn=(Integer)session1.getAttribute("count");
    if(cn==null) cn=0;
	if(first_time.equals("Y"))
   { 
 	for(int i=1;i<= cn;i++)
	{
	session1.removeAttribute("status"+i);
	}
}
	if(cnt==null) cnt="";
	if(status==null) status="";
	session1.setAttribute("status"+cnt,status);
	
	if (maintain_doc_or_file==null)  maintain_doc_or_file = "";
	ArrayList documentArrList	=	((ArrayList)session.getAttribute("documentArrList"));	
	if (documentArrList.isEmpty())
		out.println("<script>self.location.href='../../eCommon/html/blank.html'</script>");
%>
<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'> 
<form name='DTLinkEncounterListForm' id='DTLinkEncounterListForm' action='' method='POST'>
	<table width="100%" cellpadding="0" cellspacing="0" border="1" style="border:1x solid black" id='tb1'>
	<tr>
	<%
		if (!maintain_doc_or_file.equals("D"))
		{
	%>
		<td width='25%' class='columnheader'><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
	<%
		}
		else
		{
	%>
		<td width='25%' class='columnheader'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
	<%
		}
	%>
		<td width='25%' class='columnheader'><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></td>
		<td width='25%' class='columnheader'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
		<td width='25%' class='columnheader'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></td>
	</tr>
	<%
		String volume_no		=	"";	
		String document_no		=	"";	
		String doc_type_code	=	"";	
		String doc_type_desc	=	"";	
		String fs_location_code	=	"";	
		String fs_location_desc	=	"";	
         String  chkattribute="";
		Iterator	outItr		=	documentArrList.iterator();
		int count				=	1;
		
		while(outItr.hasNext())
		{
			Iterator	inItr	=	((ArrayList)outItr.next()).iterator();
			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
			if (!maintain_doc_or_file.equals("D"))
				volume_no		=	(String)inItr.next();
			else
			{
				fs_location_code=	(String)inItr.next();
				fs_location_desc=	(String)inItr.next();
			}
			
			document_no			=	(String)inItr.next();
			doc_type_code		=	(String)inItr.next();
			doc_type_desc		=	(String)inItr.next();
			fs_location_code	=	fs_location_code + "$$" + fs_location_desc;

		%>
			<tr>
			<%
				if (!maintain_doc_or_file.equals("D"))
				{
			%>
				<td class="<%=class_value%>" align="CENTER" style="font-size:8pt" nowrap><%=volume_no%><input type="hidden" name="volume_no<%=count%>" id="volume_no<%=count%>" value="<%=volume_no%>"></td>
			<%
				}
				else if (maintain_doc_or_file.equals("D"))
				{
			%>
				<td class="<%=class_value%>" style="font-size:8pt" nowrap ><%=fs_location_desc%></td>
			<%
				}
			%>		
				
		    	<td class="<%=class_value%>" style="font-size:8pt" nowrap><%=document_no%><input type="hidden" name="document_no<%=count%>" id="document_no<%=count%>" value="<%=document_no%>"><input type="hidden" name="fs_location<%=count%>" id="fs_location<%=count%>" value="<%=fs_location_code%>"></td>
				<td class="<%=class_value%>" style="font-size:8pt" nowrap ><input type="Hidden" name="doc_type_code<%=count%>" id="doc_type_code<%=count%>" value="<%=doc_type_code%>"><input type="hidden" name="doc_type_desc<%=count%>" id="doc_type_desc<%=count%>" value="<%=doc_type_desc%>"><%=doc_type_desc%></td>
				<% chkstatus =(String)session1.getAttribute("status"+count);
				if(chkstatus==null) chkstatus="";
				if(chkstatus.equals("false"))
			   {
                  chkattribute=""; 
               
			   }else if(chkstatus.equals("true"))
			{
			  
			 chkattribute="checked";
			}else
			{
                chkattribute="checked";
			}
			%>
			<td class="<%=class_value%>" align="CENTER" style="font-size:8pt;cursor:pointer" nowrap onMouseOver="changeRowColor(this,4);" name='<%=count%>'><input type="checkBox" name="associate<%=count%>" id="associate<%=count%>" value="" <%=chkattribute%> onClick="removeThisItem(this,<%=count%>);" ></td>
			</td></tr>
		<input type="Hidden" name="associate1<%=count%>" id="associate1<%=count%>" value="">
				<%
			count++;
		}
	%>
	</table>
	<input type="Hidden" name="maintain_doc_or_file" id="maintain_doc_or_file" value="<%=maintain_doc_or_file%>">
    <input type="Hidden" name="count" id="count" value="<%=count%>">
         <%
Integer c=new Integer(count);
session1.setAttribute("count",c);
		
%>

</form>
</body>
</html>

<%!	
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

