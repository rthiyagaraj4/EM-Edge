<!DOCTYPE html>

<%--
	FileName	: DiscretePanelQueryCriteriaResult.jsp
	Version	    : 3	
	Created On	: 5-5-2005
	Created By	: Jupitora 
--%>

<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>		
		<script language='javascript' src='../../eAM/js/DiscretePanel.js'></script>
		<script>
				function callfun(srlno)
				{
					var rowId_obj = document.getElementById('rowId');
						
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
PreparedStatement pstmt = null;
ResultSet rs = null;

try
{

	con	= ConnectionManager.getConnection();
	String panel_id="";
	String desc="";
	String id="";
	String description="";
	String classValue="";
	String checkAttribute="checked";
	
	String code="";
	String flag="";
	String mode="";
	String discrete="";
	String mandatory="";
	String mandatory1="";
	String idupdate="";
	String descupdate="";
	String mandatoryupdate="";
	String clearvalue="";
	String disp_flag="";
	String change="";
	String pos1="";
	String pos2="";
	String temp_id="";
	String temp_mandatory1="";
	String temp_description="";
	String removebean="";
	String lastlink="";
	request.setCharacterEncoding("UTF-8");

	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	removebean=(request.getParameter("removebean")==null)?"N":request.getParameter("removebean");
	//out.println("<script>alert('clearvalue ="+clearvalue+"')</script>");
	discrete= 
	(request.getParameter("discreteid")==null)?"":request.getParameter("discreteid");
	panel_id = (request.getParameter("id")==null)?"":request.getParameter("id");
	desc = (request.getParameter("description")==null)?"":request.getParameter("description");
	if(desc.indexOf("|")!=-1)
	
    {
    for(int i=0;i<desc.length();i++)
	{
	//	if(desc.indexOf("|")!=-1)
			desc=desc.replace('|','+');
	}
	}
	code = (request.getParameter("code")==null)?"":request.getParameter("code");
	flag = (request.getParameter("flag")==null)?"":request.getParameter("flag");
	mandatory = (request.getParameter("mandatory")==null)?"":request.getParameter("mandatory");
	disp_flag = (request.getParameter("disp_flag")==null)?"":request.getParameter("disp_flag");
	change = (request.getParameter("change")==null)?"":request.getParameter("change");
	
	pos1 = (request.getParameter("pos1")==null)?"":request.getParameter("pos1");
	pos2 = (request.getParameter("pos2")==null)?"":request.getParameter("pos2");
	lastlink = (request.getParameter("lastlink")==null)?"":request.getParameter("lastlink");
	//out.println("<script>alert('flag"+flag+"')</script>");
	int sp=0;
	int sptemp1=0;
	int sptemp2=0;
	if(change.equals("Y"))
	{
		
		ArrayList b= new ArrayList();
		b= associateDiagBean.getRecordSetHandle();
		int j=Integer.parseInt(pos1);
		sptemp1=Integer.parseInt(pos1);
		sptemp2=Integer.parseInt(pos2);
		int m=(3*j)-3;
		temp_id=b.get(m).toString();
		temp_description=b.get(m+1).toString();
		temp_mandatory1=b.get(m+2).toString();
		
		 sp=(j*3);
		//if(pos1!=pos2){
		associateDiagBean.removeObject(m+2);
		associateDiagBean.removeObject(m+1);
		associateDiagBean.removeObject(m);
		
		//}
		//out.println("<script>parent.frames[2].location.href=../../eAM/jsp/DiscretePanelQueryCriteriaResult.jsp?mode="+mode+"&change=Y</script>");
		
		int n=Integer.parseInt(pos2);
		int p=(3*n)-3;
		
		int q;
		if(j<n)
		q=p-3;
		else
        q=p;
		
		//ArrayList c= new ArrayList();
		//c= associateDiagBean.getRecordSetHandle();
		
		//int sp1=n*3;
		if(lastlink.equals("X"))
		{
        associateDiagBean.putObject(temp_id);
		associateDiagBean.putObject(temp_description);
		associateDiagBean.putObject(temp_mandatory1);
		
		}
		else
		{
         
		// if(pos1!=pos2){
			// if(sptemp1!=sptemp2){
		associateDiagBean.addObject(q,temp_id);
		associateDiagBean.addObject(q+1,temp_description);
		associateDiagBean.addObject(q+2,temp_mandatory1);
		
		// }
		}
	    //out.println("<script>alert('after add');</script>");
	//out.println("<script>alert('before page reloading');</script>"); //out.println("<script>document.location.href='DiscretePanelQueryCriteriaResult.jsp?change=Y&mode="+mode+"'</script>'");
	//out.println("<script>alert('after page reloading');</script>");
	 //out.println("<script>alert('after load');</script>");
		flag="true";
		
		b.clear();
		}
        		
		
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
<tr ><td class='CAGROUP' align=center><b><font size='2'><fmt:message key="eAM.AssociatedPanelElements.label" bundle="${am_labels}"/></b></td></tr>
</table> 
<table border='1' cellpadding='0' cellspacing='0' width='99%' align='center'>
<tr>
<th width='20%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
<th width='30%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
<th width='40%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th width='40%'>&nbsp&nbsp</th>
</tr>
	
<%
	
	if(removebean.equals("Y"))
	{
		if(!(panel_id.equals("") && desc.equals("")) )
		
		{
				
			if(associateDiagBean.containsObject(panel_id)==false )
			
			{
							
				associateDiagBean.putObject(panel_id);
				associateDiagBean.putObject(desc);
				associateDiagBean.putObject(mandatory);
							
			}
			else
			{
				if (disp_flag.equals("frompanel"))
				{
					int i = Integer.parseInt(clearvalue);
					
					associateDiagBean.setObject(i,panel_id);
					associateDiagBean.setObject(i+1,desc);
					associateDiagBean.setObject(i+2,mandatory);
				}
				else
					//out.println("<script>alert('APP-002005 Record Already Exists...')</script>");
				out.println("<script>alert(getMessage('CODE_ALREADY_EXISTS','Common'))</script>");
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
	
		if(mode.equals("update"))
		{	
			//int count=0;
			String sqlupdate="Select DISCR_MSR_ID,short_desc,MANDATORY_YN from am_discr_msr_battery_view where DISCR_MSR_BATTERY_ID=? order by ORDER_SRL_NO";
			pstmt=con.prepareStatement(sqlupdate);
			
			pstmt.setString(1,discrete);
			rs=pstmt.executeQuery();
			while( rs.next())
			{
				idupdate=(rs.getString("DISCR_MSR_ID")==null)?"":rs.getString("DISCR_MSR_ID");
				descupdate=(rs.getString("short_desc")==null)?"":rs.getString("short_desc");
				mandatoryupdate= (rs.getString("MANDATORY_YN")==null)?"":rs.getString("MANDATORY_YN");
				
				associateDiagBean.putObject(idupdate);
				associateDiagBean.putObject(descupdate);
				associateDiagBean.putObject(mandatoryupdate);
				
			}if(rs!=null) rs.close();
			  if(pstmt!=null) pstmt.close();
		}
	
	   
	
	

			ArrayList a= new ArrayList();
			a= associateDiagBean.getRecordSetHandle();
						           
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
			
				
				out.println("<tr id=rowId><td class='" + classValue + "' align='center' width='20%' nowrap><a href='javascript:panelposition("+k+");onclick=callfun("+k+");'> "+k+" </a></td>");
				id=a.get(i).toString();
				description=a.get(i+1).toString();
				mandatory1= a.get(i+2).toString();

				

				if(mandatory1.equals("Y"))
				{
					out.println("<td class='" + classValue + "' align='left' width='30%' nowrap ><A HREF='../../eAM/jsp/DiscretePanelAddtoPanelElement.jsp?ID="+id+"&Desc="+java.net.URLEncoder.encode(description)+"&srno="+i+"&mandatory="+mandatory1+"&flag=frompanel"+"&mode="+mode+"&clearvalue="+i+"&deleteflag=delete' target=paneladd>"+id+"</a><img src='../../eCommon/images/mandatory.gif'></img></td>");
				}
				else
				{
					out.println("<td class='" + classValue + "' align='left' width='30%' nowrap ><A HREF='../../eAM/jsp/DiscretePanelAddtoPanelElement.jsp?ID="+id+"&Desc="+java.net.URLEncoder.encode(description)+"&srno="+i+"&mandatory="+mandatory1+"&flag=frompanel"+"&mode="+mode+"&clearvalue="+i+"&deleteflag=delete' target=paneladd>"+id+"</a></td>");
				}
				out.println("<td class='" + classValue + "' align='left' width='40%' nowrap>");
				%>

				<%=description%>
				</td>
				<td class='<%=classValue%>' align='left' width='40%'><input type=checkbox <%=checkAttribute%> name='panelVals' value='<%=i%>' onClick='Reassaign(this)' ></td>
				<%
				i+=2;
				out.println("</tr>");
				j++;
				k++;
			
				
			}
			a.clear();
			%>
            <tr id='last' >
			<td class='" + classValue + "' align='center' width='20%' nowrap>
			<a href='javascript:panelposition("<%=k%>","X");onclick=callfun("<%=k%>");'> <%=k%> </a>
			</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>	

</table>

	<%
		
%>		
<input type="hidden" name="first" id="first" value="" >
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>

	
<%
 //out.println("<script>alert('before show');</script>");
out.println("<script>showvis('true')</script>");
}
catch(Exception e)
{
e.printStackTrace();}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
}
%>

</form>
</body>
</html>

