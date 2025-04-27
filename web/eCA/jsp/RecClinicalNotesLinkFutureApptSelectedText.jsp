<!DOCTYPE html>

<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkFutureEvent.js'></script>


<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll="scrollTitle1()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>	

<%

		Connection con				=	null;
		PreparedStatement pstmt		=	null;
		ResultSet rset				=	null;

		ArrayList	fields			=	new ArrayList();
		String		categ_sec_qry	=	"";
		String		field_ref		=	"";
/*		String		col_field		=	"";
		String		width			=	"";
		double		col_width		=	0.0;
		int			col_span		=	0;
		StringBuffer innerhtml_header = new StringBuffer();
		StringBuffer temp_new		=	new StringBuffer(); */

		String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
		String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
		
		
	try
	{
		
		con =  ConnectionManager.getConnection(request);
	
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='APPT' order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		
		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
			}
			while(rset.next());

		}
		else
		{
			 if (rset != null) rset.close();
			 if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='APPT' order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			
			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(pstmt != null) pstmt.close();

			}
		

		}
		
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception caught in RecClinicalNotesLinkDiagSelectedText.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}



%> 


<form name="RecClinicalNotesLinkFutureApptSelectedTextForm" id="RecClinicalNotesLinkFutureApptSelectedTextForm">
<div id='divDataTitle' style='postion:relative'>
<table border="1" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr ><td colspan=2 class='CAGROUP' ><b><font size='2'><fmt:message key="eCA.SelectedItems.label" bundle="${ca_labels}"/></b></td></tr>
<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<tr>
<!-- <th nowrap width="32%" style="font-size:10">Drug Name</th>
<th nowrap width="30%" style="font-size:10">Dosage Details</th>
<th nowrap width="19%" style="font-size:10">Start Date</th>
<th nowrap style="font-size:10">End Date</th> -->
</tr>
</table>
</div>



<div id="finalDiv1">
<table  class="grid" width="100%" align='center'>

<%
	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	String return_format="";

	String apptreferno=""; 
	String apptdat="";  
	String fromtime="";  
	String totime= "";   
	String locdesc= "";  
	String visitdesc= "";
	String resname= "";  
	String reason= "";   
	String remarks= "";  
	
	String classValue="";
	String classValue1="";
	int w=0;
	return_format=(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	
	String formet="";
					//out.println("return_format :" +return_format);
					if(return_format.equals("TEXT"))
					{
						formet="\n";
					}else
					{
						formet="<br>";
					}

	String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");
   	ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
	
	remval=(request.getParameter("remval")==null)?"0":request.getParameter("remval");
	removebean=(request.getParameter("removebean")==null)?"":request.getParameter("removebean");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");

	StringBuffer innerhtml= new StringBuffer();
	StringBuffer textbuffer= new StringBuffer();
	

	if(sel_all.equals("select"))
	{	
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"));
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}

	String cat = "";
	int i=0;
   if(flag.equals("clear"))
	{
		
      
		EventBean.clearAll();
	}
	
	if(!removebean.equals("Y"))
	{
		
		if(ret_str!=null && ret_str!="")
		{
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"@");
   
			while(strtCodes.hasMoreTokens())
			{
			   
				temp= (String) strtCodes.nextToken();
			   StringTokenizer tempCodes = new StringTokenizer(temp,"~");
 				while(tempCodes.hasMoreTokens())
				{
					String key= tempCodes.nextToken();
					value=tempCodes.nextToken();

				 EventBean.putObject(key);
				 EventBean.putObject(value);
				 
			}
 					
		}
		 
	}		
				
				for(i=1;i<EventBean.getSize();i+=2)
				{
  		         if ( w % 2 == 0 ){
		          classValue = "CAGROUP" ;
		          classValue1 = "gridData" ;
				 }else{
		           classValue = "CAGROUP" ;
		           classValue1 = "gridData" ;
				  }
				 w++;
				//out.println("<script>alert('classValue"+classValue+"')</script>");
		
					disbean=EventBean.getObject(i).toString();
				
					//code added by Shaiju 
						String strs[] = disbean.split("\\|");
												
						if(strs.length>0)
						{
						
						   apptreferno	=	strs[0];
						   apptdat		=	strs[1];  
						   fromtime		=	strs[2];  
						   totime		=	strs[3];   
						   locdesc		=	strs[4]; 
						   visitdesc	=	strs[5];
						   resname		=	strs[6]; 
						   reason		=	strs[7];   
						   remarks		=	strs[8];
						 
								

						//code added by Shaiju  ends

			/*	StringTokenizer valCodes = new StringTokenizer(disbean,"|");
					while(valCodes.hasMoreTokens())
				{
					
				   apptreferno=valCodes.nextToken(); 
	               apptdat=valCodes.nextToken();  
 	               fromtime=valCodes.nextToken();  
				   totime= valCodes.nextToken();   
				   locdesc= valCodes.nextToken();  
				   visitdesc= valCodes.nextToken();
				   resname= valCodes.nextToken();  
				   reason= valCodes.nextToken();   
				   remarks= valCodes.nextToken();  */
				   
					if(fields.size()>0)
					{
						innerhtml.append("<tr>");
					%>
					<tr>			
					<td class="<%=classValue%>"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"></td>
					<%

						if(fields.contains("APPTREFNO"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Appointment Ref.no : "+apptreferno+"\n");
								
							}
							else
							{
								textbuffer.append("<font size=2><b>Appointment Ref.no </b>: "+apptreferno+"<br>");
							}
							innerhtml.append("<td class='"+classValue+"'><font size=2><b> Appointment ref no : </b>&nbsp;"+apptreferno+"</font></td>");
						
						
						%>
							<td class="<%=classValue%>"  >
							<font size=2><b>Appointment Ref.no : </b></font><%=apptreferno%></td>
						<%
						}
						if(fields.contains("DATE"))
						{
							if(return_format.equals("TEXT"))
							{
								 textbuffer.append(" Date : "+apptdat+"\n");
								
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"</b> : "+apptdat+"&nbsp;&nbsp;");
							}
							innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+" : </b>&nbsp;"+apptdat+"</font></td>");

						%>
							<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font><%=apptdat%></td>
						<%
						}
						if(fields.contains("TIME"))
						{
							if(return_format.equals("TEXT"))
							{
								 textbuffer.append(" Time : "+fromtime+" To "+ totime+"\n");
								
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</b> : "+fromtime+"&nbsp;<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+"</b>&nbsp;"+ totime+"<br>");
							}
							innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"> : </b>&nbsp;"+fromtime+"<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+"  </b></font>&nbsp;"+totime+"</font></td>");

						%>
							<td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.time.label" bundle="${common_labels}"/> : </b></font><%=fromtime%><font size=2><b> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </b></font><%=totime%></td>
						<%
						}
						
						innerhtml.append("</tr><tr>");
						%></tr><tr>
						<%
						if(fields.contains("LOCATION"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Location : "+locdesc+"\n");
								
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b> : "+locdesc+"<br>");
							}
							innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" : </b>&nbsp;"+locdesc+"</font></td>");

						%>
							<td class="<%=classValue1%>"  ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font><%=locdesc%></td>
						<%
						}
						if(fields.contains("VISITTYPE"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Visit Type :"+visitdesc+"\n");
								
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+"</b> :"+visitdesc+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+" : </b>&nbsp;"+visitdesc+"</font></td>");

						%>
							<td class="<%=classValue1%>" colspan=3><font size=2><b><fmt:message key="Common.visittype.label" bundle="${common_labels}"/> : </b></font><%=visitdesc%></td>
						<%
						}
						innerhtml.append("</tr>");
						%></tr>
						<%
						if(fields.contains("RESOURCE"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Resource : "+resname+"\n");
								
							}
							else
							{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+"</b> : "+resname+"<br>");
							}
							innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+" : </b>&nbsp;"+resname+"</font></td></tr>");

						%>
							<tr>
							<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.resource.label" bundle="${common_labels}"/> : </b></font><%=resname%></td>
							</tr>
						<%
						}
						if(fields.contains("CONTACTREASON"))
						{
							if(return_format.equals("TEXT"))
							{
								 textbuffer.append(" Contact Reason :"+reason+"\n");
								
							}
							else
							{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactReason.label","common_labels")+"</b> :"+reason+"<br>");
							}
							innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactReason.label","common_labels")+" : </b>&nbsp;"+reason+"</font></td></tr>");

						%>
							<tr>
							<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/> : </b></font><%=reason%></td>
							</tr>
						<%
						}
						if(fields.contains("REMARKS"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Remarks : "+remarks);
								
							}
							else
							{
								if (!((remarks.trim()).equals("")))
									 
						 			textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</b> : "+remarks);
							}
							if(!(remarks.trim()).equals("") )
							{
								innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+" : </b>&nbsp;"+remarks+"</font></td></tr>");
							}

						%>
							<tr>
							<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> : </b></font><%=remarks%></td>
							<td colspan=4>&nbsp;</td></tr>
						<%
						}
						if(return_format.equals("TEXT"))
						{
							textbuffer.append("\n\n"); 
						}
						else
						{
							textbuffer.append("<br><br></font>");
						}

						innerhtml.append("<tr><td colspan=4>&nbsp;</td></tr>");

						cat=formet+textbuffer.toString();
						cat=cat.replace('|' , ',');


					}
					else
					{
										
										
				  
				  if(return_format.equals("TEXT"))
					{
                     textbuffer.append(" Appointment Ref.no : "+apptreferno+"\n");
					 textbuffer.append(" Date : "+apptdat+" Time : "+fromtime+" To "+ totime+"\n");
					 textbuffer.append(" Location : "+locdesc+"\n");
					 textbuffer.append(" Visit Type :"+visitdesc+"\n");
					 textbuffer.append(" Resource : "+resname+"\n");
					 textbuffer.append(" Contact Reason :"+reason+"\n");
					 if (!((remarks.trim()).equals("")))
						 textbuffer.append(" Remarks : "+remarks);
						
						 textbuffer.append("\n\n"); 
					}
					else
					{
				     textbuffer.append("<font size=2><b>Appointment Ref.no </b>: "+apptreferno+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"</b> : "+apptdat+"&nbsp;&nbsp;<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</b> : "+fromtime+"&nbsp;<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+"</b>&nbsp;"+ totime+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b> : "+locdesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+"</b> :"+visitdesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+"</b> : "+resname+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactReason.label","common_labels")+"</b> :"+reason+"<br>");
					 if (!((remarks.trim()).equals("")))
									 
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</b> : "+remarks);
						
					 textbuffer.append("<br><br></font>"); 
					}
						//com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AppointmentRef.label","common_labels")

					innerhtml.append("<tr><td class='"+classValue+"'><font size=2><b> Appointment ref no : </b>&nbsp;"+apptreferno+"</font></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+" : </b>&nbsp;"+apptdat+"</font></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+" : </b>&nbsp;"+fromtime+"<font size=2><b> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+"  </b></font>&nbsp;"+totime+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" : </b>&nbsp;"+locdesc+"</font></td><td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+" : </b>&nbsp;"+visitdesc+"</font></td></tr><tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+" : </b>&nbsp;"+resname+"</font></td></tr><tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactReason.label","common_labels")+" : </b>&nbsp;"+reason+"</font></td></tr>");


					if(!(remarks.trim()).equals("") )
					{
						
					innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+" : </b>&nbsp;"+remarks+"</font></td></tr>");

					}
					
					innerhtml.append("<tr><td colspan=4>&nbsp;</td></tr>");

				%>
				<tr>			
					<td class="<%=classValue%>"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"><font size=2><b>Appointmnet ref  <fmt:message key="Common.no.label" bundle="${common_labels}"/> : </b></font><%=apptreferno%></td>
					<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font><%=apptdat%></td>
					<td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.time.label" bundle="${common_labels}"/> : </b></font><%=fromtime%><font size=2><b> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </b></font><%=totime%></td>
				</tr>
				 <tr>
				<td class="<%=classValue1%>"  ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font><%=locdesc%></td>
				<td class="<%=classValue1%>" colspan=3><font size=2><b><fmt:message key="Common.visittype.label" bundle="${common_labels}"/> : </b></font><%=visitdesc%></td>
				</tr>
				<tr>
				<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.resource.label" bundle="${common_labels}"/> : </b></font><%=resname%></td>
				</tr>
				<tr>
				<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/> : </b></font><%=reason%></td>
				</tr>
				<tr>
				<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> : </b></font><%=remarks%></td>
				<td colspan=4>&nbsp;</td></tr>
				
				<!-- <td class="label"><%=disbean%></td>  -->
					<%
				
					cat=formet+textbuffer.toString();
					cat=cat.replace('|' , ',');
                    //cat=cat.replace('|' , '');  
					}
				}
				}
				%>
		   	
		<%
	}

				

%>
</td>
</tr>
<%

	if(removebean.equals("Y"))
	{
	 String beankey="";
	  for(int l=0;l<EventBean.getSize();l++)
	   {
			beankey=EventBean.getObject(l).toString();  


			if(remval.equalsIgnoreCase(beankey))
			{
					EventBean.removeObject(l);
					EventBean.removeObject(l);
					break;
			}
		}

				/*ArrayList d=new ArrayList();
				d=EventBean.getRecordSetHandle();
				int size=0;
				size=d.size();
				d.clear();*/
				w=0;
				for( i=1;i<EventBean.getSize();i+=2)
				{
					
					//beanval=d.get(i).toString();
				    if ( w % 2 == 0 )
		          classValue = "Label" ;
		        else
		           classValue = "CAGROUP" ;
				 w++;

					beanval=EventBean.getObject(i).toString();  

					//code added by Shaiju 
						String strs[] = beanval.split("\\|");
												
						if(strs.length>0)
						{
						
						   apptreferno	=	strs[0];
						   apptdat		=	strs[1];  
						   fromtime		=	strs[2];  
						   totime		=	strs[3];   
						   locdesc		=	strs[4]; 
						   visitdesc	=	strs[5];
						   resname		=	strs[6]; 
						   reason		=	strs[7];   
						   remarks		=	strs[8];
						 
								

						//code added by Shaiju  ends

					
					
				/*	StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					while(valCodes.hasMoreTokens())
					{
					
					 apptreferno=valCodes.nextToken(); 
	               apptdat=valCodes.nextToken();  
 	               fromtime=valCodes.nextToken();  
				   totime= valCodes.nextToken();   
				   locdesc= valCodes.nextToken();  
				   visitdesc= valCodes.nextToken();
				   resname= valCodes.nextToken();  
				   reason= valCodes.nextToken();   
				   remarks= valCodes.nextToken();   */


				   if(fields.size()>0)
					{
						innerhtml.append("<tr>");
					%>
					<tr>			
					<td class="<%=classValue%>"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"></td>
					<%

						if(fields.contains("APPTREFNO"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Appointment Ref.no : "+apptreferno+"\n");
								
							}
							else
							{
								textbuffer.append("<font size=2><b>Appointment Ref.no </b>: "+apptreferno+"<br>");
							}
							innerhtml.append("<td class='"+classValue+"'><font size=2><b> Appointment ref no : </b>&nbsp;"+apptreferno+"</font></td>");
						
						
						%>
							<td class="<%=classValue%>"  >
							<font size=2><b>Appointment Ref.no : </b></font><%=apptreferno%></td>
						<%
						}
						if(fields.contains("DATE"))
						{
							if(return_format.equals("TEXT"))
							{
								 textbuffer.append(" Date : "+apptdat+"\n");
								
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"</b> : "+apptdat+"&nbsp;&nbsp;");
							}
							innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+" : </b>&nbsp;"+apptdat+"</font></td>");

						%>
							<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font><%=apptdat%></td>
						<%
						}
						if(fields.contains("TIME"))
						{
							if(return_format.equals("TEXT"))
							{
								 textbuffer.append(" Time : "+fromtime+" To "+ totime+"\n");
								
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</b> : "+fromtime+"&nbsp;<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+"</b>&nbsp;"+ totime+"<br>");
							}
							innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+" : </b>&nbsp;"+fromtime+"<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+"  </b></font>&nbsp;"+totime+"</font></td>");

						%>
							<td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.time.label" bundle="${common_labels}"/> : </b></font><%=fromtime%><font size=2><b> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </b></font><%=totime%></td>
						<%
						}
						
						innerhtml.append("</tr><tr>");
						%></tr><tr>
						<%
						if(fields.contains("LOCATION"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Location : "+locdesc+"\n");
								
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b> : "+locdesc+"<br>");
							}
							innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" : </b>&nbsp;"+locdesc+"</font></td>");

						%>
							<td class="<%=classValue%>"  ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font><%=locdesc%></td>
						<%
						}
						if(fields.contains("VISITTYPE"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Visit Type :"+visitdesc+"\n");
								
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+"</b> :"+visitdesc+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+" : </b>&nbsp;"+visitdesc+"</font></td>");

						%>
							<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.visittype.label" bundle="${common_labels}"/> : </b></font><%=visitdesc%></td>
						<%
						}
						innerhtml.append("</tr>");
						%></tr>
						<%
						if(fields.contains("RESOURCE"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Resource : "+resname+"\n");
								
							}
							else
							{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+"</b> : "+resname+"<br>");
							}
							innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+" : </b>&nbsp;"+resname+"</font></td></tr>");

						%>
							<tr>
							<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.resource.label" bundle="${common_labels}"/> : </b></font><%=resname%></td>
							</tr>
						<%
						}
						if(fields.contains("CONTACTREASON"))
						{
							if(return_format.equals("TEXT"))
							{
								 textbuffer.append(" Contact Reason :"+reason+"\n");
								
							}
							else
							{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactReason.label","common_labels")+"</b> :"+reason+"<br>");
							}
							innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactReason.label","common_labels")+" : </b>&nbsp;"+reason+"</font></td></tr>");

						%>
							<tr>
							<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/> : </b></font><%=reason%></td>
							</tr>
						<%
						}
						if(fields.contains("REMARKS"))
						{
							if(return_format.equals("TEXT"))
							{
								textbuffer.append(" Remarks : "+remarks);
								
							}
							else
							{
								if (!((remarks.trim()).equals("")))
									 
						 			textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</b> : "+remarks);
							}
							if(!(remarks.trim()).equals("") )
							{
								innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+" : </b>&nbsp;"+remarks+"</font></td></tr>");
							}

						%>
							<tr>
							<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> : </b></font><%=remarks%></td>
							<td colspan=4>&nbsp;</td></tr>
						<%
						}
						if(return_format.equals("TEXT"))
						{
							textbuffer.append("\n\n"); 
						}
						else
						{
							textbuffer.append("<br><br></font>");
						}

						innerhtml.append("<tr><td colspan=4>&nbsp;</td></tr>");

						cat=formet+textbuffer.toString();
						cat=cat.replace('|' , ',');


					}
					else
					{
				  
					
					if(return_format.equals("TEXT"))
					{
                     textbuffer.append(" Appointment Ref.no : "+apptreferno+"\n");
					 textbuffer.append(" Date : "+apptdat+" Time : "+fromtime+" To "+ totime+"\n");
					 textbuffer.append(" Location : "+locdesc+"\n");
					 textbuffer.append(" Visit Type :"+visitdesc+"\n");
					 textbuffer.append(" Resource : "+resname+"\n");
					 textbuffer.append(" Contact Reason :"+reason+"\n");
					 if (!((remarks.trim()).equals("")))
						{
						 
						 textbuffer.append(" Remarks : "+remarks);
						}
					 textbuffer.append("\n\n"); 
					}
					else
					{
				    textbuffer.append("<font size=2><b>Appointment Ref.no </b>: "+apptreferno+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"</b> : "+apptdat+"&nbsp;&nbsp;<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+" </b> : "+fromtime+"&nbsp;<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+"</b>&nbsp;"+ totime+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b> : "+locdesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+"</b> :"+visitdesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+"</b> : "+resname+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactReason.label","common_labels")+"</b> :"+reason+"<br>");
					if (!((remarks.trim()).equals("")))
						{
						 
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</b> : "+remarks);
						}
					 textbuffer.append("<br><br></font>");  
					}
							 
					innerhtml.append("<tr><td class='"+classValue+"'><font size=2><b>Appointment Ref.no : </b>&nbsp;"+apptreferno+"</font></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+" : </b>&nbsp;"+apptdat+"</font></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+" : </b>&nbsp;"+fromtime+"<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+"  </b></font>&nbsp;"+totime+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" : </b>&nbsp;"+locdesc+"</font></td><td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+" : </b>&nbsp;"+visitdesc+"</font></td></tr><tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels")+" : </b>&nbsp;"+resname+"</font></td></tr><tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactReason.label","common_labels")+" : </b>&nbsp;"+reason+"</font></td></tr>");
					
					if(!(remarks.trim()).equals("") )
						{
						
					innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+" : </b>&nbsp;"+remarks+"</font></td></tr>");
						}
					
					innerhtml.append("<tr><td colspan=4>&nbsp;</td></tr>");
				%>
				<tr>			
					<td class="<%=classValue%>"><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"><font size=2><b>Appointment Ref <fmt:message key="Common.no.label" bundle="${common_labels}"/> : </b></font><%=apptreferno%></td>
					<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font><%=apptdat%></td>
					<td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.time.label" bundle="${common_labels}"/> : </b></font><%=fromtime%><font size=2><b> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </b></font><%=totime%></td>
				</tr>
				 <tr>
				<td class="<%=classValue%>"  ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font><%=locdesc%></td>
				<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.visittype.label" bundle="${common_labels}"/> : </b></font><%=visitdesc%></td>
				</tr>
				<tr>
				<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.resource.label" bundle="${common_labels}"/>  : </b></font><%=resname%></td>
				</tr>
				<tr>
				<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/> : </b></font><%=reason%></td>
				</tr>
				<tr>
				<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>  : </b></font><%=remarks%></td>
				<tr><td colspan=4>&nbsp;</td></tr>
				<%
						cat=formet+textbuffer.toString();
						cat=cat.replace('|' , ',');
                       // cat=cat.replace('|' , ' ');  
					}
					}
		
	}
}
%>

</tr>
<tr> <td colspan="4">&nbsp;</td> </tr>
</table>
</div>
<input type="hidden" name="temp" id="temp" value="<%=cat%>">
<input type="hidden" name="count" id="count" value="<%=i-2%>">
<input type="hidden" name="innerhtml" id="innerhtml" value="<%=innerhtml.toString()%>">

</body>
</form>


