<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<HTML>
<style>
		TD.FIRSTSELECTED
		{
			BACKGROUND-COLOR: #B1C5E9;  
			FONT-SIZE: 9pt ;
			BORDER-STYLE: SOLID;
			border-left-color: #B2B6D7;
			border-right-color: #B2B6D7;
			border-top-color: #E2E3F0;
			border-bottom-color: #E2E3F0;
			height:18;	
		}
</style>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/messages.js' language='javascript'></script>
		
		<script language='javascript' src='../../eCA/js/ClinicalRepMast.js'></script>
		<script>
				function callfun(srlno)
				{
					var rowId_obj = document.getElementById("rowId");
						
					for(i=0;i<rowId_obj.length;i++)
					{
						for(j=0;j<rowId_obj[i].cells.length;j++)
						{
							if(i == (srlno-1))
							{	
								rowId_obj[i].cells[j].className = "FIRSTSELECTED";	
							}					
										
						}
					}
				}
		</script>
</head>
<%
Connection con = null;


try
{

	con	= ConnectionManager.getConnection();
	
	String id="";
	String description="";
	String classValue="";
	String checkAttribute="checked";
	
	String code="";
	String flag="";
	String mode="";
	String discrete="";
	String mandatory="";
	String event_code1="";
	String clearvalue="";
	String disp_flag="";
	String change="";
	String removebean="";
	String contr_system="";
	String event_code="";
	String short_desc="";
	

	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	removebean=(request.getParameter("removebean")==null)?"N":request.getParameter("removebean");
	//out.println("<script>alert('clearvalue ="+clearvalue+"')</script>");
	discrete= 
	(request.getParameter("discreteid")==null)?"":request.getParameter("discreteid");
	contr_system = (request.getParameter("contr_system")==null)?"":request.getParameter("contr_system");
	//out.println("contr_system"+contr_system);
	event_code = (request.getParameter("event_code")==null)?"":request.getParameter("event_code");
	short_desc = (request.getParameter("short_desc")==null)?"":request.getParameter("short_desc");
	code = (request.getParameter("code")==null)?"":request.getParameter("code");

	flag = (request.getParameter("flag")==null)?"":request.getParameter("flag");
	mandatory = (request.getParameter("mandatory")==null)?"":request.getParameter("mandatory");
	disp_flag = (request.getParameter("disp_flag")==null)?"":request.getParameter("disp_flag");
	//out.println("disp_flag"+disp_flag);
	change = (request.getParameter("change")==null)?"":request.getParameter("change");

	//out.println("<script>alert('flag"+flag+"')</script>");
	if(code != null )
		{	
			if(flag.equals("false") )
			{
				if(!code.equals("0"))
				{
				
				int s=Integer.parseInt(code) ;
			
				associateDiagBean.removeObject(s+2);
				associateDiagBean.removeObject(s+1);
				associateDiagBean.removeObject(s);
					
				 }
				 else
				 {
				
					int s=Integer.parseInt(code) ;
					associateDiagBean.removeObject(s+2);
					associateDiagBean.removeObject(s+1); 
					associateDiagBean.removeObject(s);
				}
			}
		}
	
%> 
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >

	<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<form name='DiscrPanelQueryResult_form' id='DiscrPanelQueryResult_form' >


<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'>
<tr ><td class='CAGROUP' align=center><b><font size='2'>Associated Contributing Events</b></td></tr>
</table> 
<table border='1' cellpadding='0' cellspacing='0' width='99%' align='center'>
<tr>
<th width='20%'>SrlNo</th>
<th width='30%'>Contr System</th>
<th width='40%'>Event </th>
<th width='40%'>&nbsp&nbsp</th>
</tr>
	
<%
	
	if(removebean.equals("Y"))
	{
		if(!(contr_system.equals("") && short_desc.equals("")) )
		
		{
				
			if(associateDiagBean.containsObject(short_desc)==false )
			
			{
				
	
				associateDiagBean.putObject(contr_system);
				associateDiagBean.putObject(short_desc);
				associateDiagBean.putObject(event_code);
										
			}
			else
			{
				if (disp_flag.equals("frompanel"))
				{
					int i = Integer.parseInt(clearvalue);
					
					associateDiagBean.setObject(i,contr_system);
					associateDiagBean.setObject(i+1,short_desc);
					associateDiagBean.setObject(i+2,event_code);
					//out.println("<script>alert('coming here to disp_flag')</script>");	
				}
				else
					out.println("<script>alert('APP-002005 Event Code Already Exists...')</script>");
			}
		}

	}
	else
	{	
		//out.println("<script>alert('change"+change+"')</script>");
		if((!change.equals("Y") && change.equals("") && ( flag.equals("true") || flag.equals("")) ))
		{
			//out.println("<script>alert('inside clear')</script>");
			associateDiagBean.clearAll();
		}
		
	}
		
			ArrayList a= new ArrayList();
			a= associateDiagBean.getRecordSetHandle();
			//out.println("<script>alert('coming here 189')</script>");			           
			int size=0;
			int j=0;
			int k=1;
			size=a.size();
			
			for(int i=0;i<size;i++)
			{
				if ( j % 2 == 0 )
					 classValue = "QRYEVEN" ;
				else
					 classValue = "QRYODD" ;	
			
				
				out.println("<tr id=rowId><td class='" + classValue + "' align='center' width='20%' nowrap> "+k+" </td>");
				id=a.get(i).toString();
				description=a.get(i+1).toString();
				event_code1=a.get(i+2).toString();

				//out.println("id"+id);
				//out.println("description"+description);

				out.println("<td class='" + classValue + "' align='left' width='30%' nowrap ><A HREF='../../eCA/jsp/ClinicalRepMastAssociateLinked.jsp?ID="+id+"&Desc="+description+"&event_code="+event_code1+"&flag=frompanel"+"&mode="+mode+"&clearvalue="+i+"' target=paneladd>"+id+"</a></td>");
				
				out.println("<td class='" + classValue + "' align='left' width='40%' nowrap>"+description+"</td>");
				out.println("<td class='" + classValue + "' align='left' width='40%'><input type=checkbox "+checkAttribute+" name='panelVals' id='panelVals' value='"+i+"'onClick='Reassaign(this)' ></td>");
				
				i+=2;
				out.println("</tr>");
				j++;
				k++;
			
			//out.println("<script>alert('coming here 228')</script>");	
			}
			a.clear();
			%>
            <tr id='last' >
			
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>	

</table>

	<%
		if(mode.equals("insert"))
		{
			out.println("<script>parent.paneladd.document.forms[0].short_desc.value='';</script>");
			out.println("<script>parent.paneladd.document.forms[0].short_desc.disabled=false;parent.paneladd.document.forms[0].id.disabled=false</script>");

		}
		else
		{
			out.println("<script>parent.paneladd.document.forms[0].short_desc.value='';parent.paneladd.document.forms[0].add.value='Add'</script>");
			out.println("<script>parent.paneladd.document.forms[0].short_desc.disabled=false;parent.paneladd.document.forms[0].id.disabled=false</script>");

}		
%>		
<input type="hidden" name="first" id="first" value="" >
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>

	
<%
 //out.println("<script>alert('before show');</script>");
out.println("<script>showvis('true')</script>");
}
catch(Exception e)
{
	 e.printStackTrace() ;
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
}
%>

</form>
</body>
</html>

