<!DOCTYPE html>

<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	

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
		/*String		col_field		=	"";
		String		width			=	"";
		double		col_width		=	0.0;
		int			col_span		=	0;
		StringBuffer innerhtml_header = new StringBuffer();
		StringBuffer temp_new		=	new StringBuffer();*/

		String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
		String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

		
	try
	{
		
		con =  ConnectionManager.getConnection(request);
	
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='FORD' order by ORDER_SEQ_NUM";

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

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='FORD' order by ORDER_SEQ_NUM";

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

	String ordcatdesc=""; 
	String ordtypedesc=""; 
	String ordcatlogdesc=""; 
	String ordstartdat="";  
	String ordfreq="";  
	String ordenddat="";  
	String ordprioritydesc= "";  
	String ordloc= "";
	String ordcomments= "";  
	
	String classValue="";
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
		          classValue = "gridData" ;
		          //classValue = "Label" ;
				 }else{
				 classValue = "CAGROUP" ;
				 }
				 w++;
				//out.println("<script>alert('classValue"+classValue+"')</script>");
		
					disbean=EventBean.getObject(i).toString();
										
					//code added by Shaiju 
						String strs[] = disbean.split("\\|");
												
						if(strs.length>0)
						{
						
						   ordcatdesc	=	java.net.URLDecoder.decode(strs[0]);
						   ordtypedesc	=	java.net.URLDecoder.decode(strs[1]); 
						   ordcatlogdesc=	java.net.URLDecoder.decode(strs[2]);  
						   ordstartdat	=	strs[3];   
						   ordenddat	=	strs[4];  
						   ordfreq		=	strs[5];
						   ordprioritydesc= java.net.URLDecoder.decode(strs[6]);  
						   ordloc		=	java.net.URLDecoder.decode(strs[7]);   
						   ordcomments	=	java.net.URLDecoder.decode(strs[8]);
						 
								

						//code added by Shaiju  ends
					
				/*	StringTokenizer valCodes = new StringTokenizer(disbean,"|");
					
					while(valCodes.hasMoreTokens())
					{
					   ordcatdesc=valCodes.nextToken(); 
					   ordtypedesc=valCodes.nextToken();  
					   ordcatlogdesc=valCodes.nextToken();  
					   ordstartdat= valCodes.nextToken();   
					   ordenddat= valCodes.nextToken();  
					   ordfreq= valCodes.nextToken();
					   ordprioritydesc= valCodes.nextToken();  
					   ordloc= valCodes.nextToken();   
					   ordcomments= valCodes.nextToken();  */
				
					
					if(fields.size()>0)
					{
					%>
					<tr>			
					<td class="<%=classValue%>" colspan=1 ><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"></td>
					<%


					if(fields.contains("ORDERCATEGORY"))
					{
						if(return_format.equals("TEXT"))
						{
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels")+"  :"+ordcatdesc+"\n");
						}
						else
						{
								textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels")+"</b> :"+ordcatdesc+"<br>");
						}
						
								innerhtml.append("<tr><td class='"+classValue+"' colspan=4><font size=2><b><font size=2><b>"+ordcatdesc+"</b></font></td></tr>");

					%>
					
					<td class="<%=classValue%>" colspan=3 ><font size=2 ><b>&nbsp;<%=ordcatdesc%></b></font></td>
					
					<%
					}
					
					%>
									
					</tr>
					
					<%
					if(fields.contains("ORDERTYPE"))
					{
						if(return_format.equals("TEXT"))
						{
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")+"  : "+ordtypedesc+"\n");
						}
						else
						{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")+"</b> : "+ordtypedesc+"<br>");
						}
						
								innerhtml.append("<tr><td class="+classValue+" colspan=4 ><font size=2><b>&nbsp;"+ordtypedesc+"</b></font></td></tr>");
					%>
						<tr>
						<td class="<%=classValue%>" colspan=4 ><font size=2><b>&nbsp;<%=ordtypedesc%></b></font></td>
						</tr>
					<%
					}
					%><tr><%
					if(fields.contains("ORDER"))
					{
						if(return_format.equals("TEXT"))
						{
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Test.label","common_labels")+"   : "+ordcatlogdesc+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Test.label","common_labels")+"</b> : "+ordcatlogdesc+"<br>");
						}
						
						innerhtml.append("<tr><td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Test.label","common_labels")+" : </b>&nbsp;"+ordcatlogdesc+"</font></td>");
					%>
						<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.Test.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordcatlogdesc%></td>
					<%
					}
					if(fields.contains("STARTDATE"))
					{
						if(return_format.equals("TEXT"))
						{
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"   :"+ ordstartdat+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"</b>     :"+ ordstartdat+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+" : </b>&nbsp;"+ordstartdat+"</font></td>");
					%>
						<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordstartdat%></td>
					<%
					innerhtml.append("</tr><tr>");
					}
					%></tr><tr><%
					
					
					if(fields.contains("ENDDATE"))
					{
						if(return_format.equals("TEXT"))
						{
								if (!(ordenddat.equals("")))
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+" : "+ordenddat+"\n");
						}
						else
						{
							if (!(ordenddat.equals("")))
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+"</b>  : "+ordenddat+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+" : </b>&nbsp;"+ordenddat+"</font></td>");
					%>
						<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.enddate.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordenddat%></td>
					<%
					}
					if(fields.contains("FREQUENCY"))
					{
						if(return_format.equals("TEXT"))
						{
								if (!(ordfreq.equals("")))
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FrequencywithDurationvalue.label","ca_labels")+"  : "+ordfreq+"\n");
						}
						else
						{
							if (!(ordfreq.equals("")))
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FrequencywithDurationvalue.label","ca_labels")+"</b> : "+ordfreq+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" colspan=3><font size=2>&nbsp;"+ordfreq+"</font></td>");
					%>
						<td class="<%=classValue%>" colspan=3>&nbsp;<%=ordfreq%></td>
					<%
					}
					innerhtml.append("</tr><tr>");
					
					%></tr><tr><%
					if(fields.contains("PRIORITY"))
					{
						if(return_format.equals("TEXT"))
						{
							 if (!(ordprioritydesc.equals("")))
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : "+ordprioritydesc+"\n");
						}
						else
						{
						 if (!(ordprioritydesc.equals("")))
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b>  : "+ordprioritydesc+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+ordprioritydesc+"</font></td>");
					%>
						<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordprioritydesc%></td>
					<%
					}
					if(fields.contains("LOCATION"))
					{
						if(return_format.equals("TEXT"))
						{
							 if (!(ordloc.equals("")))
							 textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"  : "+ordloc+"\n");
						}
						else
						{
						 if (!(ordloc.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>	 : "+ordloc+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" : </b>&nbsp;"+ordloc+"</font></td>");
					%>
						<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordloc%></td>
					<%
					}
					
					innerhtml.append("</tr>");
					%></tr><%
					if(fields.contains("CLINCOMMENTS"))
					{
						if(return_format.equals("TEXT"))
						{
							if (!(ordcomments.equals("")))
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"  : "+ordcomments+"\n");
						}
						else
						{
							if (!(ordcomments.equals("")))
							 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"</b> : "+ordcomments+"<br>");
						}
						
						innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"  : </b>&nbsp;"+ordcomments+"</font></td></tr>");
					%>
						<tr>
						<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>  : </b></font>&nbsp;<%=ordcomments%></td>
						</tr><tr><td colspan=4>&nbsp;</td></tr>
					<%
					}
					if(return_format.equals("TEXT"))
					{
					 textbuffer.append("\n\n");
					}
					else
					{
					 textbuffer.append("<br></font>");
					}

					innerhtml.append("<tr><td colspan=4>&nbsp;</td></tr>");

					cat=formet+textbuffer.toString();
					cat=cat.replace('|' , ',');

					}
					else
					{
						
					

						if(return_format.equals("TEXT"))
						{
							textbuffer.append(" Category :"+ordcatdesc+"\n");
							textbuffer.append(" Order Type : "+ordtypedesc+"\n");
							textbuffer.append(" Test      : "+ordcatlogdesc+"\n");
							textbuffer.append(" Date     :"+ ordstartdat+"\n"); 

					 if (!(ordfreq.equals("")))
						 textbuffer.append("Frequency with Duration value : "+ordfreq+"\n");
					 if (!(ordenddat.equals("")))
						 textbuffer.append("End Date : "+ordenddat+"\n");
					 if (!(ordprioritydesc.equals("")))
						 textbuffer.append("Priority : "+ordprioritydesc+"\n");
					 if (!(ordloc.equals("")))
						 textbuffer.append(" Location : "+ordloc+"\n");
					 if (!(ordcomments.equals("")))
						 textbuffer.append(" Clinical Comments : "+ordcomments+"\n");
					 
					 textbuffer.append("\n\n");


					}
					else
					{
				     textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels")+"</b> :"+ordcatdesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")+"</b> : "+ordtypedesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")+"</b> : "+ordcatlogdesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"</b>     :"+ ordstartdat+"<br>"); 
					 if (!(ordfreq.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FrequencywithDurationvalue.label","ca_labels")+"</b> : "+ordfreq+"<br>");
					 if (!(ordenddat.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+"</b>  : "+ordenddat+"<br>");
					 if (!(ordprioritydesc.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b>  : "+ordprioritydesc+"<br>");
					 if (!(ordloc.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>	 : "+ordloc+"<br>");
					 if (!(ordcomments.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"</b> : "+ordcomments+"<br>");
					 textbuffer.append("<br></font>");
					}

					innerhtml.append("<tr><td class='"+classValue+"' colspan=4><font size=2><b><font size=2><b>"+ordcatdesc+"</b></font></td></tr><tr><td class="+classValue+" colspan=4 ><font size=2><b>&nbsp;"+ordtypedesc+"</b></font></td></tr><tr><td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Test.label","common_labels")+" : </b>&nbsp;"+ordcatlogdesc+"</font></td><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+" : </b>&nbsp;"+ordstartdat+"</font></td></tr><tr><td class="+classValue+" colspan=3><font size=2>&nbsp;"+ordfreq+"</font></td><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+" : </b>&nbsp;"+ordenddat+"</font></td></tr><tr><td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+ordprioritydesc+"</font></td><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" : </b>&nbsp;"+ordloc+"</font></td>	</tr><tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"  : </b>&nbsp;"+ordcomments+"</font></td></tr><tr><td colspan=4>&nbsp;</td></tr>");
				%>
				<tr>			
					<td class="<%=classValue%>" colspan=4><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"><font size=2><b>&nbsp;<%=ordcatdesc%></b></font></td>
					</tr>
				<tr>
					<td class="<%=classValue%>" colspan=4 ><font size=2><b>&nbsp;<%=ordtypedesc%></b></font></td>
				</tr>
				<tr>

					<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.Test.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordcatlogdesc%></td>
					<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordstartdat%></td>
				</tr>
				
				<tr>
				<td class="<%=classValue%>" colspan=3>&nbsp;<%=ordfreq%></td>
				<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.enddate.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordenddat%></td>
				</tr>
				
				<tr>
				<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordprioritydesc%></td>
				<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordloc%></td>
				</tr>
				<tr>
				<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>  : </b></font>&nbsp;<%=ordcomments%></td>
				</tr><tr><td colspan=4>&nbsp;</td></tr>
				
				
				
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
						
						   ordcatdesc	=	java.net.URLDecoder.decode(strs[0]);
						   ordtypedesc	=	java.net.URLDecoder.decode(strs[1]); 
						   ordcatlogdesc=	java.net.URLDecoder.decode(strs[2]);  
						   ordstartdat	=	strs[3];   
						   ordenddat	=	strs[4];  
						   ordfreq		=	strs[5];
						   ordprioritydesc= java.net.URLDecoder.decode(strs[6]);  
						   ordloc		=	java.net.URLDecoder.decode(strs[7]);   
						   ordcomments	=	java.net.URLDecoder.decode(strs[8]);
						 
								

						//code added by Shaiju  ends

					
				/*	StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					while(valCodes.hasMoreTokens())
					{
					
				   ordcatdesc=valCodes.nextToken(); 
	               ordtypedesc=valCodes.nextToken();  
 	               ordcatlogdesc=valCodes.nextToken();  
				   ordstartdat= valCodes.nextToken();   
				   ordenddat= valCodes.nextToken();  
				   ordfreq= valCodes.nextToken();
				   ordprioritydesc= valCodes.nextToken();  
				   ordloc= valCodes.nextToken();   
				   ordcomments= valCodes.nextToken();  */

					if(fields.size()>0)
					{

						
					%>
					<tr>			
					<td class="<%=classValue%>" colspan=1 ><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"></td>
					<%


					if(fields.contains("ORDERCATEGORY"))
					{
						if(return_format.equals("TEXT"))
						{
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels")+"  :"+ordcatdesc+"\n");
						}
						else
						{
								textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels")+"</b> :"+ordcatdesc+"<br>");
						}
						
								innerhtml.append("<tr><td class='"+classValue+"' colspan=4><font size=2><b><font size=2><b>"+ordcatdesc+"</b></font></td></tr>");

					%>
					
					<td class="<%=classValue%>" colspan=3 ><font size=2 ><b>&nbsp;<%=ordcatdesc%></b></font></td>
					
					<%
					}
					
					%>
									
					</tr>
					
					<%
					if(fields.contains("ORDERTYPE"))
					{
						if(return_format.equals("TEXT"))
						{
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")+"  : "+ordtypedesc+"\n");
						}
						else
						{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")+"</b> : "+ordtypedesc+"<br>");
						}
						
								innerhtml.append("<tr><td class="+classValue+" colspan=4 ><font size=2><b>&nbsp;"+ordtypedesc+"</b></font></td></tr>");
					%>
						<tr>
						<td class="<%=classValue%>" colspan=4 ><font size=2><b>&nbsp;<%=ordtypedesc%></b></font></td>
						</tr>
					<%
					}
					%><tr><%
					if(fields.contains("ORDER"))
					{
						if(return_format.equals("TEXT"))
						{
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Test.label","common_labels")+"   : "+ordcatlogdesc+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Test.label","common_labels")+"</b> : "+ordcatlogdesc+"<br>");
						}
						
						innerhtml.append("<tr><td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Test.label","common_labels")+" : </b>&nbsp;"+ordcatlogdesc+"</font></td>");
					%>
						<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.Test.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordcatlogdesc%></td>
					<%
					}
					if(fields.contains("STARTDATE"))
					{
						if(return_format.equals("TEXT"))
						{
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"   :"+ ordstartdat+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"</b>     :"+ ordstartdat+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+" : </b>&nbsp;"+ordstartdat+"</font></td>");
					%>
						<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordstartdat%></td>
					<%
					innerhtml.append("</tr><tr>");
					}
					%></tr><tr><%
					
					
					if(fields.contains("ENDDATE"))
					{
						if(return_format.equals("TEXT"))
						{
								if (!(ordenddat.equals("")))
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+" : "+ordenddat+"\n");
						}
						else
						{
							if (!(ordenddat.equals("")))
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+"</b>  : "+ordenddat+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+" : </b>&nbsp;"+ordenddat+"</font></td>");
					%>
						<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.enddate.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordenddat%></td>
					<%
					}
					if(fields.contains("FREQUENCY"))
					{
						if(return_format.equals("TEXT"))
						{
								if (!(ordfreq.equals("")))
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FrequencywithDurationvalue.label","ca_labels")+"  : "+ordfreq+"\n");
						}
						else
						{
							if (!(ordfreq.equals("")))
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FrequencywithDurationvalue.label","ca_labels")+"</b> : "+ordfreq+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" colspan=3><font size=2>&nbsp;"+ordfreq+"</font></td>");
					%>
						<td class="<%=classValue%>" colspan=3>&nbsp;<%=ordfreq%></td>
					<%
					}
					innerhtml.append("</tr><tr>");
					
					%></tr><tr><%
					if(fields.contains("PRIORITY"))
					{
						if(return_format.equals("TEXT"))
						{
							 if (!(ordprioritydesc.equals("")))
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : "+ordprioritydesc+"\n");
						}
						else
						{
						 if (!(ordprioritydesc.equals("")))
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b>  : "+ordprioritydesc+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+ordprioritydesc+"</font></td>");
					%>
						<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordprioritydesc%></td>
					<%
					}
					if(fields.contains("LOCATION"))
					{
						if(return_format.equals("TEXT"))
						{
							 if (!(ordloc.equals("")))
							 textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"  : "+ordloc+"\n");
						}
						else
						{
						 if (!(ordloc.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>	 : "+ordloc+"<br>");
						}
						
						innerhtml.append("<td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" : </b>&nbsp;"+ordloc+"</font></td>");
					%>
						<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordloc%></td>
					<%
					}
					
					innerhtml.append("</tr>");
					%></tr><%
					if(fields.contains("CLINCOMMENTS"))
					{
						if(return_format.equals("TEXT"))
						{
							if (!(ordcomments.equals("")))
								textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"  : "+ordcomments+"\n");
						}
						else
						{
							if (!(ordcomments.equals("")))
							 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"</b> : "+ordcomments+"<br>");
						}
						
						innerhtml.append("<tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"  : </b>&nbsp;"+ordcomments+"</font></td></tr>");
					%>
						<tr>
						<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>  : </b></font>&nbsp;<%=ordcomments%></td>
						</tr><tr><td colspan=4>&nbsp;</td></tr>
					<%
					}
					if(return_format.equals("TEXT"))
					{
					 textbuffer.append("\n\n");
					}
					else
					{
					 textbuffer.append("<br></font>");
					}

					innerhtml.append("<tr><td colspan=4>&nbsp;</td></tr>");

					cat=formet+textbuffer.toString();
					cat=cat.replace('|' , ',');




					}
					else
					{

			

				
					if(return_format.equals("TEXT"))
					{
                    textbuffer.append(" Category :"+ordcatdesc+"\n");
					textbuffer.append(" Order Type : "+ordtypedesc+"\n");
					 textbuffer.append(" Test      : "+ordcatlogdesc+"\n");
					 textbuffer.append(" Date     :"+ ordstartdat+"\n"); 
					 if (!(ordfreq.equals("")))
						 textbuffer.append("Frequency with Duration value : "+ordfreq+"\n");
					 if (!(ordenddat.equals("")))
						 textbuffer.append("End Date : "+ordenddat+"\n");
					 if (!(ordprioritydesc.equals("")))
						 textbuffer.append("Priority : "+ordprioritydesc+"\n");
					 if (!(ordloc.equals("")))
						 textbuffer.append(" Location : "+ordloc+"\n");
					 if (!(ordcomments.equals("")))
						 textbuffer.append(" Clinical Comments : "+ordcomments+"\n");
					 textbuffer.append("\n\n");


					}
					else
					{
				     textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels")+"</b> :"+ordcatdesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")+"</b> : "+ordtypedesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Test.label","common_labels")+"</b>    : "+ordcatlogdesc+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+"</b>     :"+ ordstartdat+"<br>"); 
					 if (!(ordfreq.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.FrequencywithDurationvalue.label","ca_labels")+"</b> : "+ordfreq+"<br>");
					 if (!(ordenddat.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+"</b>  : "+ordenddat+"<br>");
					 if (!(ordprioritydesc.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b>  : "+ordprioritydesc+"<br>");
					 if (!(ordloc.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>	 : "+ordloc+"<br>");
					 if (!(ordcomments.equals("")))
						 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"</b> : "+ordcomments+"<br>");
					 textbuffer.append("<br></font>");
					 }
							 
					innerhtml.append("<tr><td class='"+classValue+"' colspan=4><font size=2><b><font size=2><b>&nbsp;"+ordcatdesc+"</b></font></td></tr><tr><td class="+classValue+" colspan=4 ><font size=2><b>&nbsp;"+ordtypedesc+"</b></font></td></tr><tr><td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Test.label","common_labels")+" : </b>&nbsp;"+ordcatlogdesc+"</font></td><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+" : </b>&nbsp;"+ordstartdat+"</font></td></tr><tr><td class="+classValue+" colspan=3><font size=2>&nbsp;"+ordfreq+"</font></td><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+" : </b>&nbsp;"+ordenddat+"</font></td></tr><tr><td class="+classValue+" colspan=3><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+ordprioritydesc+"</font></td><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" : </b>&nbsp;"+ordloc+"</font></td>	</tr><tr><td class="+classValue+"  colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"  : </b>&nbsp;"+ordcomments+"</font></td></tr><tr><td colspan=4>&nbsp;</td></tr>");
				%>
				<tr>			
					<td class="<%=classValue%>" colspan=4><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"><font size=2><b>&nbsp;<%=ordcatdesc%></b></font></td>
					</tr>
				<tr>
					<td class="<%=classValue%>" colspan=4 align=left><font size=2><b>&nbsp;<%=ordtypedesc%></b></font></td>
				</tr>
				<tr>

					<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.Test.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordcatlogdesc%></td>
					<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordstartdat%></td>
				</tr>
				
				<tr>
				<td class="<%=classValue%>" colspan=3>&nbsp;<%=ordfreq%></td>
				<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.enddate.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordenddat%></td>
				</tr>
				
				<tr>
				<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordprioritydesc%></td>
				<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=ordloc%></td>
				</tr>
				<tr>
				<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>  : </b></font>&nbsp;<%=ordcomments%></td>
				</tr><tr><td colspan=4>&nbsp;</td></tr>
				
				
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
</table>
</div>
<input type="hidden" name="temp" id="temp" value="<%=cat%>">
<input type="hidden" name="count" id="count" value="<%=i-2%>">
<input type="hidden" name="innerhtml" id="innerhtml" value="<%=innerhtml.toString()%>">

</body>
</form>


