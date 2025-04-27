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
//shaiju new diag starts
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;

		ArrayList  fields			=	new ArrayList();
		String categ_sec_qry ="";
		String field_ref ="";
		/*String col_field ="";
		//String col_val ="";
		String		width			=	"";
		double		col_width		=	0.0;
		int col_span=0;
		StringBuffer innerhtml_header = new StringBuffer();
		StringBuffer temp_new = new StringBuffer();*/

		String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
		String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

		
	try
	{
		
		con =  ConnectionManager.getConnection(request);
	
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='RFRL' order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		//pstmt.setString(3,result_linked_rec_type);

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

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='RFRL' order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			//pstmt.setString(2,result_linked_rec_type);

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
<table class='grid' width="100%" align='center'>



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

	String refid=""; 
	String referdate=""; 
	String refpriority=""; 
	String refreason="";  
	String refpractfrom="";  
	String refpractto="";  
	String refspecfrom="";  
	String refspecto= "";   
	String reflocfrom="";  
	String reflocto= "";
	String reffacfrom= "";  
	String reffacto= "";  
	
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
	StringBuffer textbuffer1= new StringBuffer();
	StringBuffer textbuffer2= new StringBuffer();
	

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
						
						   refid		=	strs[0]; 
						   referdate	=	strs[1];  
						   refpriority	=	strs[2];  
						   refreason	=	java.net.URLDecoder.decode(strs[3]);   
						   refpractfrom	=	java.net.URLDecoder.decode(strs[4]);  
						   refpractto	=	java.net.URLDecoder.decode(strs[5]);
						   refspecfrom	=	java.net.URLDecoder.decode(strs[6]);  
						   refspecto	=	java.net.URLDecoder.decode(strs[7]);   
						   reflocfrom	=	java.net.URLDecoder.decode(strs[8]);  
						   reflocto		=	java.net.URLDecoder.decode(strs[9]);  
						   reffacfrom	=	java.net.URLDecoder.decode(strs[10]);  
						   reffacto		=	java.net.URLDecoder.decode(strs[11]);
						 
								

						//code added by Shaiju  ends


				/*	StringTokenizer valCodes = new StringTokenizer(disbean,"|");
					while(valCodes.hasMoreTokens())
				{
	 
				   refid=valCodes.nextToken(); 
	               referdate=valCodes.nextToken();  
 	               refpriority=valCodes.nextToken();  
				   refreason= valCodes.nextToken();   
				   refpractfrom= valCodes.nextToken();  
				   refpractto= valCodes.nextToken();
				   refspecfrom= valCodes.nextToken();  
				   refspecto= valCodes.nextToken();   
				   reflocfrom= valCodes.nextToken();  
				   reflocto= valCodes.nextToken();  
				   reffacfrom= valCodes.nextToken();  
				   reffacto= valCodes.nextToken();  */
					
					if(fields.size()>0)
					{
					%>
						<tr>			
						<td class="<%=classValue%>" ><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><font size=2><b><fmt:message key="Common.referralid.label" bundle="${common_labels}"/> : </b></font><%=refid%><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"></td>
					<%
						if(return_format.equals("TEXT"))
						{
						textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" :" +refid+"\n");
						}
						else
						{
							textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</b> : "+refid+"<br>");
						}
						innerhtml.append("<tr><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" : </b>&nbsp;"+refid+"</font></td>");
					
					
						if(fields.contains("DATE"))
						{

							if(return_format.equals("TEXT"))
						{
						textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" :" +referdate+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+"</b> : "+referdate+"<br>");
						}
						innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" : </b>&nbsp;"+referdate+"</font></td>");

					%>
						<td class="<%=classValue%>"  ><font size=2><b><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/> : </b></font><%=referdate%></td>
					<%
						}
						if(fields.contains("PRIORITY"))
						{
							if(return_format.equals("TEXT"))
						{
						textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" :" +refpriority+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b> : "+refpriority+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan=2><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+refpriority+"</font></td>");
					%>
						<td class="<%=classValue%>" colspan=2><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=refpriority%></td>

					<%
						}innerhtml.append("</tr>");
					%>
                    
					</tr>
					<%

						if(fields.contains("REASONFORREFERRAL"))
						{

								if(return_format.equals("TEXT"))
						{
						textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" :" +refreason+"\n");
						}
						else
						{
							textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+"</b> : "+ refreason+"<br>");
						}
						innerhtml.append("<tr><td class="+classValue+" colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" : </b>&nbsp;"+refreason+"</font></td></tr>");

					%>

					<tr>
					 <td class="<%=classValue%>" colspan=4><font size=2><b><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/></b></font>&nbsp;<%=refreason%></td> 
					</tr>
					<%
					}
					%>

					<tr>
					<td class="<%=classValue%>" colspan="4">
                   <table border="1"  cellpadding="0" cellspacing="0" width="100%">
                   <tr>
                   <td class="<%=classValue1%>">&nbsp;</td> 
        		  <%

				   if(fields.contains("REFERREDFROM"))
				   {
					   	if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"\n");
						}
						else
						{
							textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b><br>");
						}
						innerhtml.append("<tr><td class="+classValue+" colspan='4'><table border='1'  cellpadding='3' cellspacing='0' width='100%' align='center'>    <tr><td class="+classValue+"></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b></font></td>");

				  %>
				   
				   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></b></font></td> 
        		   
				  <%
					}
					if(fields.contains("REFERREDTO"))
					{
							if(return_format.equals("TEXT"))
						{
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+" :" +referdate+"\n");
						}
						else
						{
							textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b><br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b></font></td>");

					%> 
				   <td class="<%=classValue1%>" colspan="2"><font size=2><b><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></b></font></td> 
                   
				   
				   <%
					}innerhtml.append(" </tr>");
					%>
					</tr>
						
				   <%
					if(fields.contains("PRACTITIONER"))
					{

					   	if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));
						}
						else
						{
							textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>");
							textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>");
						}
						innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b></font></td> ");

					%>
					   
					   <tr> <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b></font></td>    
					  <%
						if(fields.contains("REFERREDFROM"))
						{
						   	if(return_format.equals("TEXT"))
						{
						textbuffer1.append(" :" +refpractfrom+"\n");
						}
						else
						{
							textbuffer1.append(" : "+refpractfrom+"<br>");
						}
						innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+refpractfrom+"</font></td>");

					  %>
					   <td class="<%=classValue1%>" >&nbsp;<%=refpractfrom%>&nbsp;</td>   
					  <%
																
						}
						if(fields.contains("REFERREDTO"))
						{
								if(return_format.equals("TEXT"))
						{
						textbuffer2.append(" :" +refpractto+"\n");
						}
						else
						{
							textbuffer2.append(" : "+refpractto+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refpractto+"</font></td>");

					   %>
					   <td class="<%=classValue1%>" colspan="2">&nbsp;<%=refpractto%>&nbsp;</td>
					   <%
																
						}innerhtml.append("</tr>");
						%></tr><%
					}
				   
					if(fields.contains("SPECIALITY"))
					{ 
							if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"));
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"));
						}
						else
						{
							textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> ");
							textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> ");
						}
						innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b></font></td>");

						%>  
					   
					   <tr>	
					   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></b></font></td>  
					   
						<%
						if(fields.contains("REFERREDFROM"))
						{ 
								if(return_format.equals("TEXT"))
						{
						textbuffer1.append(" :" +refspecfrom+"\n");
						}
						else
						{
							textbuffer1.append(" : "+refspecfrom+"<br>");
						}
						innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+refspecfrom+"</font></td>");

						%>
					   <td class="<%=classValue1%>" >&nbsp;<%=refspecfrom%>&nbsp;</td> 
					   <%
											
						}
						if(fields.contains("REFERREDTO"))
						{ 
								if(return_format.equals("TEXT"))
						{
						textbuffer2.append(" :" +refspecto+"\n");
						}
						else
						{
							textbuffer2.append(" : "+refspecto+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td>");

						%>
					   <td class="<%=classValue1%>" colspan="2">&nbsp;<%=refspecto%>&nbsp;</td>   
					   
					  <%
						}
					  innerhtml.append("</tr>");
					   %>
					   </tr>
					   <%
															
					}
					if(fields.contains("LOCATION"))
					{ 

							if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
						}
						else
						{
							textbuffer1.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
							textbuffer2.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
						}
						innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b></font></td>");

						%>
					   
					   <tr>	
					   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></font></td>    
					  <%
						if(fields.contains("REFERREDFROM"))
						{ 
						  	if(return_format.equals("TEXT"))
						{
						textbuffer1.append(" :" +reflocfrom+"\n");
						}
						else
						{
							textbuffer1.append("</b> : "+reflocfrom+"<br>");
						}
						innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+reflocfrom+"</font></td>");

						%>
					   
					   <td class="<%=classValue1%>" >&nbsp;<%=reflocfrom%>&nbsp;</td>   
					   <%
																
						}
						if(fields.contains("REFERREDTO"))
						{ 
								if(return_format.equals("TEXT"))
						{
						textbuffer2.append(" :" +reffacto+"\n");
						}
						else
						{
							textbuffer2.append("</b> : "+reffacto+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td>");

						%>
					   <td class="<%=classValue1%>" colspan="2">&nbsp;<%=reflocto%>&nbsp;</td>   
					   
					   <%
						innerhtml.append("</tr>");										
						}
						%></tr><%
												
				    }
					if(fields.contains("SOURCE"))
					{ 
							if(return_format.equals("TEXT"))
						{
						textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
						textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
						}
						else
						{
							textbuffer1.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
							textbuffer2.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
						}
						innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</font></td>");

						%>
					   
					   <tr>	
					   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.source.label" bundle="${common_labels}"/></b></font></td>    
					   
						<%
						if(fields.contains("REFERREDFROM"))
						{
								if(return_format.equals("TEXT"))
						{
						textbuffer1.append(" :" +reffacfrom+"\n");
						}
						else
						{
							textbuffer1.append("</b> : "+reffacfrom+"<br>");
						}
						innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+reffacfrom+"</font></td> ");

						%>

					   <td class="<%=classValue1%>" >&nbsp;<%=reffacfrom%>&nbsp;</td>   
					   
						<%
																
						}
						if(fields.contains("REFERREDTO"))
						{

								if(return_format.equals("TEXT"))
						{
						textbuffer2.append(" :" +reffacto+"\n");
						}
						else
						{
							textbuffer2.append("</b> : "+reffacto+"<br>");
						}
						innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reffacto+"</font></td>");
						%>


					   <td class="<%=classValue1%>" colspan="2">&nbsp;<%=reffacto%>&nbsp;</td>   
					   
						<%
																
						}
						innerhtml.append("</tr>");
						%></tr><%
															
					}
					//innerhtml.append("</table></td></tr>");	
					%>
               
				
				</table>
				</td>
				</tr>

					<%
						

					textbuffer.append(textbuffer1.toString() + textbuffer2.toString());

					cat=formet+textbuffer.toString();
					cat=cat.replace('|' , ',');
					
					}
					else
					{

					
			
				
					if(return_format.equals("TEXT"))
					{
                     textbuffer.append(" Referral ID : "+refid+"\n");
					 textbuffer.append(" Date : "+referdate+"\n");
					 textbuffer.append(" Priority : "+refpriority+"\n");
					 textbuffer.append(" Reason for Referral : "+ refreason+"\n"); 
					 textbuffer.append(" Referred From\n"); 
					 textbuffer.append(" Practioner : "+refpractfrom+"\n");
					 textbuffer.append(" Specialty : "+refspecfrom+"\n");					
					 textbuffer.append(" Location : "+reflocfrom+"\n");					
					 textbuffer.append(" Source : "+reffacfrom+"\n");
					 textbuffer.append(" Referred To \n"); 
  				     textbuffer.append(" Practioner : "+refpractto+"\n");
 				     textbuffer.append(" Specialty : "+refspecto+"\n");
				     textbuffer.append(" Location : "+reflocto+"\n");
					 textbuffer.append(" Source : "+reffacto+"\n");
					 textbuffer.append("\n\n"); 
					}
					else
					{
				   textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</b> : "+refid+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+"</b> : "+referdate+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b> : "+refpriority+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+"</b> : "+ refreason+"<br>"); 
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b><br>"); 
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b> : "+refpractfrom+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> : "+refspecfrom+"<br>");					
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>  : "+reflocfrom+"<br>");					
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b>  : "+reffacfrom+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b><br>"); 
  				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b> : "+refpractto+"<br>");
 				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> : "+refspecto+"<br>");
				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b> : "+reflocto+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b>   : "+reffacto+"<br>");
					 textbuffer.append("<br><br></font>"); 
					}
						
						

					innerhtml.append("<tr><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" : </b>&nbsp;"+refid+"</font></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" : </b>&nbsp;"+referdate+"</font></td><td class="+classValue+" colspan=2><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+refpriority+"</font></td></tr><tr><td class="+classValue+" colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" : </b>&nbsp;"+refreason+"</font></td></tr><tr><td class="+classValue+" colspan='4'><table border='1'  cellpadding='3' cellspacing='0' width='100%' align='center'>    <tr><td class="+classValue+"></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b></font></td><td class="+classValue+" colspan='2'><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b></font></td></tr>	<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b></font></td>        <td class="+classValue+" ><font size=2>&nbsp;"+refpractfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refpractto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+refspecfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refspecto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+reflocfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+reffacfrom+"</font></td>  <td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reffacto+"</font></td></tr></table></td></tr>");
				%>
				<tr>
				    <!--Below colon is added after each header names by Archana Dhal on 11/10/2010 related to incident no. IN024868 -->
					<td class="<%=classValue%>" ><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><font size=2><b><fmt:message key="Common.referralid.label" bundle="${common_labels}"/> : </b></font><%=refid%></td>
					<td class="<%=classValue%>"  ><font size=2><b><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/> : </b></font><%=referdate%></td>
                    <td class="<%=classValue%>" colspan=2><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=refpriority%><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"></td>
                    
                 </tr>
                  <tr>
                 <td class="<%=classValue%>" colspan=4><font size=2><b><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/> : </b></font>&nbsp;<%=refreason%></td> 
                 </tr>
                 <tr>
				<td class="<%=classValue1%>" colspan="4">
                   <table border="1"  cellpadding="0" cellspacing="0" width="100%">
                   <tr>
                   <td class="<%=classValue1%>">&nbsp;</td> 
        		   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></b></font></td> 
        		   <td class="<%=classValue1%>" colspan="2"><font size=2><b><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></b></font></td> 
                   </tr>
				   <tr>	
				   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue1%>" >&nbsp;<%=refpractfrom%>&nbsp;</td>   
                   <td class="<%=classValue1%>" colspan="2">&nbsp;<%=refpractto%>&nbsp;</td>   
				   </tr>
				   <tr>	
				   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue1%>" >&nbsp;<%=refspecfrom%>&nbsp;</td>   
                   <td class="<%=classValue1%>" colspan="2">&nbsp;<%=refspecto%>&nbsp;</td>   
				   </tr>	
                   <tr>	
				   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue1%>" >&nbsp;<%=reflocfrom%>&nbsp;</td>   
                   <td class="<%=classValue1%>" colspan="2">&nbsp;<%=reflocto%>&nbsp;</td>   
				   </tr>
                   <tr>	
				   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.source.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue1%>" >&nbsp;<%=reffacfrom%>&nbsp;</td>   
                   <td class="<%=classValue1%>" colspan="2">&nbsp;<%=reffacto%>&nbsp;</td>   
				   </tr>
                </table>
				</td>
				</tr>
				
				
				
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
						
						   refid		=	strs[0]; 
						   referdate	=	strs[1];  
						   refpriority	=	strs[2];  
						   refreason	=	java.net.URLDecoder.decode(strs[3]);   
						   refpractfrom	=	java.net.URLDecoder.decode(strs[4]);  
						   refpractto	=	java.net.URLDecoder.decode(strs[5]);
						   refspecfrom	=	java.net.URLDecoder.decode(strs[6]);  
						   refspecto	=	java.net.URLDecoder.decode(strs[7]);   
						   reflocfrom	=	java.net.URLDecoder.decode(strs[8]);  
						   reflocto		=	java.net.URLDecoder.decode(strs[9]);  
						   reffacfrom	=	java.net.URLDecoder.decode(strs[10]);  
						   reffacto		=	java.net.URLDecoder.decode(strs[11]);
						 
								

						//code added by Shaiju  ends
					
				/*	StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					while(valCodes.hasMoreTokens())
					{
					
				   refid=valCodes.nextToken(); 
	               referdate=valCodes.nextToken();  
 	               refpriority=valCodes.nextToken();  
				   refreason= valCodes.nextToken();   
				   refpractfrom= valCodes.nextToken();  
				   refpractto= valCodes.nextToken();
				   refspecfrom= valCodes.nextToken();  
				   refspecto= valCodes.nextToken();   
				   reflocfrom= valCodes.nextToken();  
				   reflocto= valCodes.nextToken();  
				   reffacfrom= valCodes.nextToken();  
				   reffacto= valCodes.nextToken();   */


					if(fields.size()>0)
					{
						

							%>
							<tr>			
							<td class="<%=classValue%>" ><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><font size=2><b><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></b></font><%=refid%><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"></td>
						<%
							if(return_format.equals("TEXT"))
							{
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" :" +refid+"\n");
							}
							else
							{
								textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</b> : "+refid+"<br>");
							}
							innerhtml.append("<tr><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" : </b>&nbsp;"+refid+"</font></td>");
						
						
							if(fields.contains("DATE"))
							{

								if(return_format.equals("TEXT"))
							{
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" :" +referdate+"\n");
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+"</b> : "+referdate+"<br>");
							}
							innerhtml.append("<td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" : </b>&nbsp;"+referdate+"</font></td>");

						%>
							<td class="<%=classValue%>"  ><font size=2><b><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/></b></font><%=referdate%></td>
						<%
							}
							if(fields.contains("PRIORITY"))
							{
								if(return_format.equals("TEXT"))
							{
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" :" +refpriority+"\n");
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b> : "+refpriority+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan=2><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+refpriority+"</font></td>");
						%>
							<td class="<%=classValue%>" colspan=2><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/></b></font>&nbsp;<%=refpriority%></td>

						<%
							}innerhtml.append("</tr>");
						%>
						
						</tr>
						<%

							if(fields.contains("REASONFORREFERRAL"))
							{

									if(return_format.equals("TEXT"))
							{
							textbuffer.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" :" +refreason+"\n");
							}
							else
							{
								textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+"</b> : "+ refreason+"<br>");
							}
							innerhtml.append("<tr><td class="+classValue+" colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" : </b>&nbsp;"+refreason+"</font></td></tr>");

						%>

						<tr>
						 <td class="<%=classValue%>" colspan=4><font size=2><b><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/></b></font>&nbsp;<%=refreason%></td> 
						</tr>
						<%
						}
						%>

						<tr>
						<td class="<%=classValue%>" colspan="4">
					   <table border="1"  cellpadding="0" cellspacing="0" width="100%">
					   <tr>
					   <td class="<%=classValue%>">&nbsp;</td> 
					  <%

					   if(fields.contains("REFERREDFROM"))
					   {
							if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"\n");
							}
							else
							{
								textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b><br>");
							}
							innerhtml.append("<tr><td class="+classValue+" colspan='4'><table border='1'  cellpadding='3' cellspacing='0' width='100%' align='center'>    <tr><td class="+classValue+"></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b></font></td>");

					  %>
					   
					   <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></b></font></td> 
					   
					  <%
						}
						if(fields.contains("REFERREDTO"))
						{
								if(return_format.equals("TEXT"))
							{
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+" :" +referdate+"\n");
							}
							else
							{
								textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b><br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b></font></td>");

						%> 
					   <td class="<%=classValue%>" colspan="2"><font size=2><b><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></b></font></td> 
					   
					   
					   <%
						}innerhtml.append(" </tr>");
						%>
						</tr>
							
					   <%
						if(fields.contains("PRACTITIONER"))
						{

							if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));
							}
							else
							{
								textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>");
								textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>");
							}
							innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b></font></td> ");

						%>
						   
						   <tr> <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b></font></td>    
						  <%
							if(fields.contains("REFERREDFROM"))
							{
								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(" :" +refpractfrom+"\n");
							}
							else
							{
								textbuffer1.append(" : "+refpractfrom+"<br>");
							}
							innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+refpractfrom+"</font></td>");

						  %>
						   <td class="<%=classValue%>" >&nbsp;<%=refpractfrom%>&nbsp;</td>   
						  <%
																	
							}
							if(fields.contains("REFERREDTO"))
							{
									if(return_format.equals("TEXT"))
							{
							textbuffer2.append(" :" +refpractto+"\n");
							}
							else
							{
								textbuffer2.append(" : "+refpractto+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refpractto+"</font></td>");

						   %>
						   <td class="<%=classValue%>" colspan="2">&nbsp;<%=refpractto%>&nbsp;</td>
						   <%
																	
							}innerhtml.append("</tr>");
							%></tr><%
						}
					   
						if(fields.contains("SPECIALITY"))
						{ 
								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"));
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels"));
							}
							else
							{
								textbuffer1.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> ");
								textbuffer2.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b> ");
							}
							innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b></font></td>");

							%>  
						   
						   <tr>	
						   <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></b></font></td>  
						   
							<%
							if(fields.contains("REFERREDFROM"))
							{ 
									if(return_format.equals("TEXT"))
							{
							textbuffer1.append(" :" +refspecfrom+"\n");
							}
							else
							{
								textbuffer1.append(" : "+refspecfrom+"<br>");
							}
							innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+refspecfrom+"</font></td>");

							%>
						   <td class="<%=classValue%>" >&nbsp;<%=refspecfrom%>&nbsp;</td> 
						   <%
												
							}
							if(fields.contains("REFERREDTO"))
							{ 
									if(return_format.equals("TEXT"))
							{
							textbuffer2.append(" :" +refspecto+"\n");
							}
							else
							{
								textbuffer2.append(" : "+refspecto+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td>");

							%>
						   <td class="<%=classValue%>" colspan="2">&nbsp;<%=refspecto%>&nbsp;</td>   
						   
						  <%
							}
						  innerhtml.append("</tr>");
						   %>
						   </tr>
						   <%
																
						}
						if(fields.contains("LOCATION"))
						{ 

								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
							}
							else
							{
								textbuffer1.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
								textbuffer2.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
							}
							innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b></font></td>");

							%>
						   
						   <tr>	
						   <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></font></td>    
						  <%
							if(fields.contains("REFERREDFROM"))
							{ 
								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(" :" +reflocfrom+"\n");
							}
							else
							{
								textbuffer1.append("</b> : "+reflocfrom+"<br>");
							}
							innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+reflocfrom+"</font></td>");

							%>
						   
						   <td class="<%=classValue%>" >&nbsp;<%=reflocfrom%>&nbsp;</td>   
						   <%
																	
							}
							if(fields.contains("REFERREDTO"))
							{ 
									if(return_format.equals("TEXT"))
							{
							textbuffer2.append(" :" +reffacto+"\n");
							}
							else
							{
								textbuffer2.append("</b> : "+reffacto+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td>");

							%>
						   <td class="<%=classValue%>" colspan="2">&nbsp;<%=reflocto%>&nbsp;</td>   
						   
						   <%
							innerhtml.append("</tr>");										
							}
							%></tr><%
													
						}
						if(fields.contains("SOURCE"))
						{ 
								if(return_format.equals("TEXT"))
							{
							textbuffer1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
							textbuffer2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
							}
							else
							{
								textbuffer1.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
								textbuffer2.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels"));
							}
							innerhtml.append("<tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</font></td>");

							%>
						   
						   <tr>	
						   <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.source.label" bundle="${common_labels}"/></b></font></td>    
						   
							<%
							if(fields.contains("REFERREDFROM"))
							{
									if(return_format.equals("TEXT"))
							{
							textbuffer1.append(" :" +reffacfrom+"\n");
							}
							else
							{
								textbuffer1.append("</b> : "+reffacfrom+"<br>");
							}
							innerhtml.append("<td class="+classValue+" ><font size=2>&nbsp;"+reffacfrom+"</font></td> ");

							%>

						   <td class="<%=classValue%>" >&nbsp;<%=reffacfrom%>&nbsp;</td>   
						   
							<%
																	
							}
							if(fields.contains("REFERREDTO"))
							{

									if(return_format.equals("TEXT"))
							{
							textbuffer2.append(" :" +reffacto+"\n");
							}
							else
							{
								textbuffer2.append("</b> : "+reffacto+"<br>");
							}
							innerhtml.append("<td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reffacto+"</font></td>");
							%>


						   <td class="<%=classValue%>" colspan="2">&nbsp;<%=reffacto%>&nbsp;</td>   
						   
							<%
																	
							}
							innerhtml.append("</tr>");
							%></tr><%
																
						}
						//innerhtml.append("</table></td></tr>");	
						%>
				   
					
					</table>
					</td>
					</tr>

						<%


						textbuffer.append(textbuffer1.toString() + textbuffer2.toString());

						cat=formet+textbuffer.toString();
						cat=cat.replace('|' , ',');


					}
					else
					{

				
					if(return_format.equals("TEXT"))
					{
                     textbuffer.append(" Referral ID : "+refid+"\n");
					 textbuffer.append(" Date : "+referdate+"\n");
					 textbuffer.append(" Priority : "+refpriority+"\n");
					 textbuffer.append(" Reason for Referral : "+ refreason+"\n"); 
					 textbuffer.append(" Referred From\n"); 
					 textbuffer.append(" Practioner : "+refpractfrom+"\n");
					 textbuffer.append(" Specialty : "+refspecfrom+"\n");					
					 textbuffer.append(" Location : "+reflocfrom+"\n");					
					 textbuffer.append(" Source : "+reffacfrom+"\n");
					 textbuffer.append(" Referred To \n"); 
  				     textbuffer.append(" Practioner : "+refpractto+"\n");
 				     textbuffer.append(" Specialty : "+refspecto+"\n");
				     textbuffer.append(" Location : "+reflocto+"\n");
					 textbuffer.append(" Source : "+reffacto+"\n");
					 textbuffer.append("\n\n"); 
					}
					else
					{
				    textbuffer.append("<font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</b> : "+refid+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+"</b> : "+referdate+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</b> : "+refpriority+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+"</b> : "+ refreason+"<br>"); 
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b><br>"); 
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>  : "+refpractfrom+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b>  : "+refspecfrom+"<br>");					
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>  : "+reflocfrom+"<br>");					
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b>  : "+reffacfrom+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b><br>"); 
  				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</b>  : "+refpractto+"<br>");
 				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</b>  : "+refspecto+"<br>");
				     textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b>   : "+reflocto+"<br>");
					 textbuffer.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b>   : "+reffacto+"<br>");
					 textbuffer.append("<br><br></font>"); 
					}
						
							 
					innerhtml.append("<tr><td class="+classValue+" ><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+" : </b>&nbsp;"+refid+"</font></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredDate.label","common_labels")+" : </b>&nbsp;"+referdate+"</font></td><td class="+classValue+" colspan=2><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+" : </b>&nbsp;"+refpriority+"</font></td></tr><tr><td class="+classValue+" colspan=4><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforReferral.label","common_labels")+" : </b>&nbsp;"+refreason+"</font></td></tr><tr><td class="+classValue+" colspan='4'><table border='1'  cellpadding='3' cellspacing='0' width='100%' align='center'>    <tr><td class="+classValue+"></td><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredFrom.label","common_labels")+"</b></font></td><td class="+classValue+" colspan='2'><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredTo.label","common_labels")+"</b></font></td></tr>	 <tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+" </b></font></td>        <td class="+classValue+" ><font size=2>&nbsp;"+refpractfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refpractto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" </b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+refspecfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+refspecto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+" </b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+reflocfrom+"</font></td><td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reflocto+"</font></td></tr><tr><td class="+classValue+"><font size=2><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.source.label","common_labels")+"</b></font></td><td class="+classValue+" ><font size=2>&nbsp;"+reffacfrom+"</font></td>  <td class="+classValue+" colspan='2'><font size=2>&nbsp;"+reffacto+"</font></td></tr></table></td></tr>");
				%>
				<tr>			
					<td class="<%=classValue%>" ><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><font size=2><b><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></b></font><%=refid%></td>
					<td class="<%=classValue%>"  ><font size=2><b><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/></b></font><%=referdate%></td>
                    <td class="<%=classValue%>" colspan=2><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/></b></font>&nbsp;<%=refpriority%><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=EventBean.getObject(i-1).toString()%>"></td>
                   
                 </tr>
                 <tr>
                 <td class="<%=classValue%>" colspan=4><font size=2><b><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/></b></font>&nbsp;<%=refreason%></td> 
                 </tr> 
                 <tr>
				<td class="<%=classValue%>" colspan="4">
                   <table border="1"  cellpadding="3" cellspacing="0" width="100%" align='center'>
                   <tr>
                   <td class="<%=classValue%>">&nbsp;</td> 
        		   <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></b></font></td> 
        		   <td class="<%=classValue%>" colspan="2"><font size=2><b><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></b></font></td> 
                   </tr>
				   <tr>	
				   <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue%>" >&nbsp;<%=refpractfrom%></td>   
                   <td class="<%=classValue%>" colspan="2">&nbsp;<%=refpractto%></td>   
				   </tr>
				   <tr>	
				   <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue%>" >&nbsp;<%=refspecfrom%></td>   
                   <td class="<%=classValue%>" colspan="2">&nbsp;<%=refspecto%></td>   
				   </tr>	
                   <tr>	
				   <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue%>" >&nbsp;<%=reflocfrom%></td>   
                   <td class="<%=classValue%>" colspan="2">&nbsp;<%=reflocto%></td>   
				   </tr>
                   <tr>	
				   <td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.source.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue%>" >&nbsp;<%=reffacfrom%></td>   
                   <td class="<%=classValue%>" colspan="2">&nbsp;<%=reffacto%></td>   
				   </tr>
                </table>
				</td>
				</tr>
				
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


