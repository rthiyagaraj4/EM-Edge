<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
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
		<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>
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
//PreparedStatement pstmt = null;
//ResultSet rs = null;

try
{

	con	= ConnectionManager.getConnection();
	String contr="";
	String groupcode="";
	String contrnew="";
	String groupcodenew="";
	String classValue="";
	String checkAttribute="checked";
	
	String code="";
	String flag="";
	String mode="";
	String discrete="";
	String shortdesc="";
	String shortdescnew="";
//	String idupdate="";
//	String descupdate="";
//	String mandatoryupdate="";
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
	

	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	removebean=(request.getParameter("removebean")==null)?"N":request.getParameter("removebean");
	//out.println("<script>alert('clearvalue ="+clearvalue+"')</script>");
	discrete= 
	(request.getParameter("discreteid")==null)?"":request.getParameter("discreteid");
	contr = (request.getParameter("contr")==null)?"":request.getParameter("contr");
	groupcode = (request.getParameter("groupcode")==null)?"":request.getParameter("groupcode");
	code = (request.getParameter("code")==null)?"":request.getParameter("code");
	flag = (request.getParameter("flag")==null)?"":request.getParameter("flag");
	shortdesc = (request.getParameter("shortdesc")==null)?"":request.getParameter("shortdesc");
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
		b= EventBean.getRecordSetHandle();
		int j=Integer.parseInt(pos1);
		sptemp1=Integer.parseInt(pos1);
		sptemp2=Integer.parseInt(pos2);
		int m=(3*j)-3;
		temp_id=b.get(m).toString();
		temp_description=b.get(m+1).toString();
		temp_mandatory1=b.get(m+2).toString();
		
		 sp=(j*3);
		//if(pos1!=pos2){
		EventBean.removeObject(m+2);
		EventBean.removeObject(m+1);
		EventBean.removeObject(m);
		
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
		//c= EventBean.getRecordSetHandle();
		
		//int sp1=n*3;
		if(lastlink.equals("X"))
		{

        EventBean.putObject(temp_id);
		EventBean.putObject(temp_description);
		EventBean.putObject(temp_mandatory1);
		
		}
		else
		{
         
		// if(pos1!=pos2){
			// if(sptemp1!=sptemp2){
		EventBean.addObject(q,temp_id);
		EventBean.addObject(q+1,temp_description);
		EventBean.addObject(q+2,temp_mandatory1);
		
		// }
		}
	    
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
			     
				EventBean.removeObject(s+2);
				EventBean.removeObject(s+1);
				EventBean.removeObject(s);
					
				 }
				 else
				 {
				      
					  
					int s=Integer.parseInt(code) ;
					EventBean.removeObject(s+2);
					EventBean.removeObject(s+1); 
					EventBean.removeObject(s);
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
<tr ><td class='CAGROUP' align=center><b><font size='2'>Associated Event Groups</b></td></tr>
</table> 
<table border='1' cellpadding='0' cellspacing='0' width='99%' align='center'>
<tr>
<th width='20%'>SrlNo</th>
<th width='30%'>Contr System</th>
<th width='40%'>EventGroup</th>
<th width='40%'>&nbsp&nbsp</th>
</tr>
	
<%
	
	if(removebean.equals("Y"))
	{
		if(!(contr.equals("") && groupcode.equals("")) )
		
		{
				
			if(EventBean.containsObject(groupcode)==false)
			
			{
							
				EventBean.putObject(contr);
				EventBean.putObject(groupcode);
				EventBean.putObject(shortdesc);
							
			}
			else
			{
				if (disp_flag.equals("frompanel"))
				{
					int i = Integer.parseInt(clearvalue);
					
					EventBean.setObject(i,contr);
					EventBean.setObject(i+1,groupcode);
					EventBean.setObject(i+2,shortdesc);
				}
				else
					out.println("<script>alert('APP-002005 Record Already Exists...')</script>");
			}
		}

	}
	else
	{	
		//out.println("<script>alert('change"+change+"')</script>");
		if((!change.equals("Y") && change.equals("") && ( flag.equals("true") || flag.equals("")) ))
		{
			//out.println("<script>alert('inside clear')</script>");
			EventBean.clearAll();
		}
		
	}
	/*	if(mode.equals("update"))
		{	
			//int count=0;
			String sqlupdate="Select DISCR_MSR_ID,short_desc,MANDATORY_YN from am_discr_msr_battery_view where DISCR_MSR_BATTERY_ID=? order by ORDER_SRL_NO";
			pstmt=con.prepareStatement(sqlupdate,ResultSet.TYPE_SCROLL_INSENSITIVE,
											  ResultSet.CONCUR_UPDATABLE);
			
			pstmt.setString(1,discrete);
			rs=pstmt.executeQuery();
			while( rs.next())
			{
				idupdate=(rs.getString("DISCR_MSR_ID")==null)?"":rs.getString("DISCR_MSR_ID");
				descupdate=(rs.getString("short_desc")==null)?"":rs.getString("short_desc");
				mandatoryupdate= (rs.getString("MANDATORY_YN")==null)?"":rs.getString("MANDATORY_YN");
				
				EventBean.putObject(idupdate);
				EventBean.putObject(descupdate);
				EventBean.putObject(mandatoryupdate);
				
			}if(rs!=null) rs.close();
			  if(pstmt!=null) pstmt.close();
		} */
	

			ArrayList a= new ArrayList();
			a= EventBean.getRecordSetHandle();
						           
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
				contrnew=a.get(i).toString();
				groupcodenew=a.get(i+1).toString();
				shortdescnew= a.get(i+2).toString();

				
				out.println("<td class='" + classValue + "' align='left' width='30%' nowrap><A HREF='../../eCA/jsp/ClinicalEventGroupIndTabAddElement.jsp?contr="+java.net.URLEncoder.encode(contrnew)+"&groupcode="+java.net.URLEncoder.encode(groupcodenew)+"&srno="+i+"&shortdesc="+java.net.URLEncoder.encode(shortdescnew)+"&flag=frompanel"+"&mode="+mode+"&clearvalue="+i+"' target=add>"+contrnew+"</a></td>");
				
				out.println("<td class='" + classValue + "' align='left' width='40%' nowrap>"+shortdescnew+"</td>");
				out.println("<td class='" + classValue + "' align='left' width='40%'><input type=checkbox "+checkAttribute+" name='panelVals' id='panelVals' value='"+i+"'onClick='Reassaign(this)' ></td>");
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
	

<input type="hidden" name="first" id="first" value="" >
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>

	
<%
 //out.println("<script>alert('before show');</script>");
out.println("<script>showvis('true')</script>");
}
catch(Exception e)
{
	 //out.println("Exception="+e.toString());//COMMON-ICN-0181
           e.printStackTrace();//COMMON-ICN-0181
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

