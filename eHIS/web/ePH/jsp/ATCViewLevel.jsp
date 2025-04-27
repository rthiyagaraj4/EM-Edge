<!DOCTYPE html>
  <%-- saved on 27/10/2005 --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <body bgcolor="navy" style="overflow-x:hidden;overflow-y:scroll"> -->
<body onMouseDown="" onKeyDown="lockKey()" bgcolor="navy" style="overflow-x:hidden;overflow-y:scroll">

<form name="ATCViewLevel" id="ATCViewLevel">
<%
String level_num	=	request.getParameter("level");
String code			=	request.getParameter("code");
String desc			=	request.getParameter("desc");

if(code==null)  code	=	"";
if(desc==null)	desc	=	"";


String desc_1		=	"";
String desc_2		=	"";
String desc_3		=	"";
String desc_4		=	"";
String desc_5		=	"";
String code_1		=	"";
String code_2		=	"";
String code_3		=	"";
String code_4		=	"";
String code_5		=	"";


		  if(level_num.equals("1"))	  {
			code_1 =code; 
			desc_1 =desc;
		  }
		  
		  else if(level_num.equals("2")) {
			  desc_1	=	request.getParameter("desc_1");
			  code_1	=	request.getParameter("code_1");
			  code_2	=	code;
			  desc_2	=	desc;
		  }
          else if(level_num.equals("3"))  {
				desc_1	=	request.getParameter("desc_1");
				desc_2	=	request.getParameter("desc_2");
				code_1	=	request.getParameter("code_1");
				code_2	=	request.getParameter("code_2");
				code_3	=	code;
				desc_3	=	desc;
		  }
          else if(level_num.equals("4"))	{   
			 	code_1	=	request.getParameter("code_1");
				code_2	=	request.getParameter("code_2");
				code_3	=	request.getParameter("code_3");
			  	desc_1	=	request.getParameter("desc_1");
				desc_2	=	request.getParameter("desc_2");
				desc_3	=	request.getParameter("desc_3");
				code_4	=	code;
				desc_4	=	desc;
		  }
		  else if(level_num.equals("5"))   {
			   	code_1	=	request.getParameter("code_1");
				code_2	=	request.getParameter("code_2");
				code_3	=	request.getParameter("code_3");
				code_4	=	request.getParameter("code_4");

			  	desc_1	=	request.getParameter("desc_1");
				desc_2	=	request.getParameter("desc_2");
				desc_3	=	request.getParameter("desc_3");
				desc_4	=	request.getParameter("desc_4");

				code_5	=	code;
				desc_5	=	desc;
		  }
%>

<table border='0' align=center width='100%' cellpadding='0' cellspacing='0'>
<tr>	<td class="tdvl"><fmt:message key="ePH.AnatomicalClass.label" bundle="${ph_labels}"/></td>					</tr>
<tr>	<td id='L1' class="dtdvl">&nbsp;<%=desc_1%></td>						</tr>
<tr>	<td>&nbsp;</td>											</tr> 
<tr>	<td class="tdvl"><fmt:message key="ePH.TherapeuticClass.label" bundle="${ph_labels}"/>(<fmt:message key="ePH.MainClass.label" bundle="${ph_labels}"/>)</td>				</tr>
<tr>	<td id='L2' class="dtdvl">&nbsp;<%=desc_2%></td>						</tr>
 <tr>	<td>&nbsp;</td>											</tr> 
<tr>	<td class="tdvl"><fmt:message key="ePH.TherapeuticClass.label" bundle="${ph_labels}"/>(<fmt:message key="Common.SubClass.label" bundle="${common_labels}"/>)</td>				</tr>
<tr>	<td id='L3' class="dtdvl">&nbsp;<%=desc_3%></td>						</tr>
 <tr>	<td>&nbsp;</td>											</tr> 
<tr>	<td class="tdvl"><fmt:message key="ePH.ChemicalClass.label" bundle="${ph_labels}"/>(<fmt:message key="ePH.MainClass.label" bundle="${ph_labels}"/>)</td>				</tr>
<tr>	<td id='L4' class="dtdvl">&nbsp;<%=desc_4%></td>						</tr>
 <tr>	<td  >&nbsp;</td>										</tr> 
<tr>	<td class="tdvl"><fmt:message key="ePH.ChemicalClass.label" bundle="${ph_labels}"/>(<fmt:message key="Common.SubClass.label" bundle="${common_labels}"/>)</td>					</tr>
<tr>	<td id='L5' class="dtdvl">&nbsp;<%=desc_5%></td>						</tr>
<tr>	<td>&nbsp;</td>											</tr> 
</table>
<input type="hidden" name="L1_code" id="L1_code" value="<%=code_1%>">
<input type="hidden" name="L2_code" id="L2_code" value="<%=code_2%>">
<input type="hidden" name="L3_code" id="L3_code" value="<%=code_3%>">
<input type="hidden" name="L4_code" id="L4_code" value="<%=code_4%>">
<input type="hidden" name="L5_code" id="L5_code" value="<%=code_5%>">
<input type="hidden" name="L1_desc" id="L1_desc" value="<%=desc_1%>">
<input type="hidden" name="L2_desc" id="L2_desc" value="<%=desc_2%>">
<input type="hidden" name="L3_desc" id="L3_desc" value="<%=desc_3%>">
<input type="hidden" name="L4_desc" id="L4_desc" value="<%=desc_4%>">
<input type="hidden" name="L5_desc" id="L5_desc" value="<%=desc_5%>">
</form>
</body>
</html>

