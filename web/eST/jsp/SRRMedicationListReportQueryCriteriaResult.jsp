<!DOCTYPE html>
   <%@page contentType="text/html;charset=UTF-8" import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.Common.*,eST.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.ConnectionManager "%>

<%@include file="../../eCommon/jsp/CommonBean.jsp"%>				    
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>						 

<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
																		   
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
 String pageCount=request.getParameter("pageCount")!=null?request.getParameter("pageCount"):"0";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>															  
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
<!-- 		<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
		<script language="javascript" src="../../eST/js/ReprintDocument.js"></script>
		<script language="javascript" src="../../eST/js/SRRMedicationListReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<body>
	<form name="MedicationListResult" id="MedicationListResult" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">	
	<input type=hidden name="pageCount" id="pageCount" value="<%=pageCount%>">	   
	 
	<%
		int i = 0;
//int count=0;														 		   
//boolean boolToggle =  true;						   
//String strTDClass = ""; 
String strBeanName = SRRMedicationListReportBean.strBeanName;


Connection conn = null;
ArrayList arrRow = null;
ArrayList arrCol = null;
HashMap resultsQry=null;							 
String strPrevious = "";  
String strNext  = "";													 
String classvalue="";
//Statement stmt=null;
String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		String store_desc=request.getParameter("store_desc");
//ResultSet rs=null;	
String action_type=request.getParameter("action_type")!=null?request.getParameter("action_type"):"";   
	  String selectAll=""; 
	//  java.util.Date date_time	 	= new java.util.Date();
	     String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	 
try
{
	 String patient_id=request.getParameter("patient_id");
	 String adr_reported_date_from=request.getParameter("adr_reported_date_from");
	 String adr_reported_date_to=request.getParameter("adr_reported_date_to");
	 String sale_doc_no_from=request.getParameter("sale_doc_no_from");
	 String sale_doc_no_to=request.getParameter("sale_doc_no_to");
	 String store_code=request.getParameter("store_code");	
	 String rule=request.getParameter("rule")!=null?request.getParameter("rule"):"N";
	 	
	 String doc_type_code=request.getParameter("doc_type_code");


			 
		if(rule.equals("N"))
	{
		selectAll=request.getParameter("selectYN")!=null?request.getParameter("selectYN"):"";
	}
														 									   
	 request.setAttribute("patient_id",patient_id);					    
     request.setAttribute("adr_reported_date_from",adr_reported_date_from);  
	 request.setAttribute("adr_reported_date_to",adr_reported_date_to);		  
     request.setAttribute("doc_type_code",doc_type_code);
	 request.setAttribute("sale_doc_no_from",sale_doc_no_from); 					     
	 request.setAttribute("sale_doc_no_to",sale_doc_no_to); 	   
	 request.setAttribute("store_code",store_code);
	 request.setAttribute("selectAll",selectAll);					 
	 request.setAttribute("action_attr","");
	 conn = ConnectionManager.getConnection(request);			  
	 SRRMedicationListReportBean	xhBean = SRRMedicationListReportBean.getBean(strBeanName,request,session);
	 xhBean.action(request,conn);
	 resultsQry = xhBean.getResultSet(); 	
	 arrRow = (ArrayList)resultsQry.get("qry_result"); 
	 boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 										 
	 boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 	
	
	 if(rule.equals("Y"))
	{
	 selectAll=((String)resultsQry.get("selectAll")).equals("")?"":((String)resultsQry.get("selectAll"));    		   
	}
										   


	  strPrevious = "Previous";
	 strNext  = "Next";
	 if (boolPrevious == true)														    
	{																	  
		strPrevious ="Previous";			 							   
	}
	else													    
	{													   
		strPrevious = " ";
	}														   
	if (boolNext== true)
	{
		strNext  ="Next";
	}
	else								  
	{																							  
		strNext  = " ";
	}
	 
	%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="reprint_rep">
<tr>
	<td colspan="8" align="right"  > 
	<A class='label'  style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
	</tr>
 
<%
if(arrRow.size()==0)												    
{														    			    
	%>						  
<script>																					 
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
	parent.f_query_add_mod.document.forms[0].print.disabled=true;
</script>
<%
}
else
{
	%>
<tr>										   
<th> <fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> </th>		   			    
<th> <fmt:message key="Common.Store.label" bundle="${mm_labels}"/> </th>
<th> <fmt:message key="eST.SalesDocNo.label" bundle="${st_labels}"/> </th>
<th> <fmt:message key="Common.patientId.label" bundle="${common_labels}"/>  </th>
<th> <fmt:message key="Common.PatientName_fs.label"   bundle="${common_labels}"/> </th>		 
<th> <fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </th>	
<th> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> <input type="checkbox"  name="selectAll" id="selectAll" value="<%=selectAll%>"    onClick="selectAllCheck(this,'<%=pageCount%>')" <%=(selectAll).equals("Y")?"checked":""%> >	
<%---<input type=hidden name='<%=pageCount+"selectYN"%>' id='<%=pageCount+"selectYN"%>' id='<%=pageCount+"selectYN"%>' value="<%=selectAll%>"  >----%>	  </th>   
</tr>

	<script>
parent.f_query_add_mod.document.forms[0].print.disabled=false;	
</script>
<%												    
for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;				    
			else
				classvalue = "QRYODD" ;
	%>														 			     
	<tr>											   
<td class="<%=classvalue%>" style="font-size=9" nowrap>&nbsp;<a href="#" onClick="funCheck(this)" doc_date="<%=(String)arrCol.get(2)%>" doc_no="<%=(String)arrCol.get(1)%>" doc_valid_code="<%=(String)arrCol.get(0)+(String)arrCol.get(1)%>"  store_code="<%=(String)arrCol.get(3)%>"><%=(String)arrCol.get(2)%></a></td>
<td class="<%=classvalue%>" style="font-size=9" nowrap>&nbsp;<a href="#" onClick="funCheck(this)" doc_date="<%=(String)arrCol.get(2)%>" doc_no="<%=(String)arrCol.get(1)%>" doc_valid_code="<%=(String)arrCol.get(0)+(String)arrCol.get(1)%>" store_code="<%=(String)arrCol.get(3)%>"><%=store_desc%></a> </td>		 			        
<td class="<%=classvalue%>" style="font-size=9" nowrap>&nbsp;<a href="#" onClick="funCheck(this)" doc_date="<%=(String)arrCol.get(2)%>" doc_no="<%=(String)arrCol.get(1)%>" doc_valid_code="<%=(String)arrCol.get(0)+(String)arrCol.get(1)%>" store_code="<%=(String)arrCol.get(3)%>"><%=(String)arrCol.get(1)%></a> </td>			 				   
<td class="<%=classvalue%>" style="font-size=9" nowrap>&nbsp;<%=(String)arrCol.get(5)%>  </td>				  	  							 	    
<td class="<%=classvalue%>" style="font-size=9" nowrap>&nbsp;<%=(String)arrCol.get(7)%> </td>		 	  	 
<td class="<%=classvalue%>" style="font-size=9" nowrap>&nbsp;<%=(String)arrCol.get(6)%> 	</td>	     
<%if(selectAll.equals("Y"))
{%>																	 
<td class="<%=classvalue%>" style="font-size=9" nowrap><input type="checkbox"  name='<%=(String)arrCol.get(0)+(String)arrCol.get(1)+"chk"%>' id='<%=(String)arrCol.get(0)+(String)arrCol.get(1)+"chk"%>' value="Y"   onClick="enableCheck(this)" checked>  </td>   		 
<%}							   
else
		{%>
		<td class="<%=classvalue%>" style="font-size=9" nowrap>
		<input type="checkbox"  name='<%=(String)arrCol.get(0)+(String)arrCol.get(1)+"chk"%>' id='<%=(String)arrCol.get(0)+(String)arrCol.get(1)+"chk"%>'	id='<%=(String)arrCol.get(0)+(String)arrCol.get(1)+"chk"%>' value="<%=((String)arrCol.get(8)).equals("Y")?"Y":"N"%>"   onClick="enableCheck(this)" <%=((String)arrCol.get(8)).equals("Y")?"checked":""%>  >  
		</td>
		<%}%>
</tr>																	  
	<%	   i++;
			}
}
	}
	
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		//arrRow.clear();
	//	arrCol.clear();
		ConnectionManager.returnConnection(conn);
		
	}%>

	        <input type="hidden" name="bean_id" id="bean_id" value="<%=strBeanName%>">
			<input type="hidden" name="bean_name" id="bean_name" value='<%="eST."+strBeanName%>'>	   
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STMEDLIST_SRR">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">  
																				     
	<input type=hidden name="P_DOC_DATE" id="P_DOC_DATE">
	<input type=hidden name="P_DOC_NO" id="P_DOC_NO">
	<input type=hidden name="store_desc" id="store_desc" value="<%=store_desc%>">
	<input type=hidden name="P_STORE_CODE" id="P_STORE_CODE" >
	<input type=hidden name="selectYN" id="selectYN"  >									  
	<input type=hidden name="rule" id="rule"> 	 

	<input type=hidden name="action_type" id="action_type" value="<%=action_type%>"> 	 
</table>																		  
	
																								    
	 
</form>
</body>
</html>

