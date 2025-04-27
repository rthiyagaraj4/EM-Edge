<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*,java.net.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
04/10/2012	IN033558.1		 Dinesh T	 Incident No: IN033558 - Link Doc in Record Clinical Note Displays Error.
10/01/2013	IN037280 		 Chowminya G Incident No: IN037280 - System is displaying internal server error, when we link  diagnosis with "%" character
21/02/2012  IN036181		 Chowminya G			 reports which has special characters such as an airstrisk (*) or a semicolon (??)
28/11/2014	IN052716		Ramesh G		Result Link In Template Based Section In  Clinical Notes For ?Table? And ?Text?.
---------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
02/05/2017	IN061907		Krishna Gowtham		02/05/2017	Ramesh G		ML-MMOH-CRF-0559
15/04/2023	   38981        Krishna Pranay   16/04/2023     Ramesh G     ML-MMOH-CRF-1986

------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");


%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- added by Kishore Kumar N on 10/12/2008  -->
		
		<!-- end here -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkDiag.js'></script>

<html>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

<%
 //shaiju new diag starts
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;

		ArrayList  fields			=	new ArrayList();
		String categ_sec_qry ="";
		String field_ref ="";
		String col_field ="";
		//String col_val ="";
		String		width			=	"";
		double		col_width		=	0.0;
		int col_span=0;
		StringBuffer innerhtml_header = new StringBuffer();
		StringBuffer innertext_header = new StringBuffer(); //IN052716
		String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
		String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

		String call_from_link_doc_btn 	= request.getParameter("call_from_link_doc_btn")==null?"":request.getParameter("call_from_link_doc_btn");//IN061907
		String includestatus		=	request.getParameter("includestatus")==null?"N":request.getParameter("includestatus");//38981
         
try
{
		
		con =  ConnectionManager.getConnection(request);
	
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		pstmt.setString(3,result_linked_rec_type);

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

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
		  
			pstmt.setString(1,result_linked_rec_type);
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

<form name="RecClinicalNotesLinkDiagSelectedTextForm" id="RecClinicalNotesLinkDiagSelectedTextForm">
<div id='divDataTitle' style='postion:relative'>
<table border="1" cellpadding="3" cellspacing="0" width="100%" align='center'>
<tr ><td class='CAGROUP' ><b><font size='2'><fmt:message key="eCA.SelectedItems.label" bundle="${ca_labels}"/></b></td></tr>
</table>
</div> 
<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<tr><td class='columnheadercenter' style="font-size:10" width='5%' ></td>
<%
	if(fields.size()>0)
	{
		
		col_span = fields.size();
		//col_width= 100/col_span;
		//width = col_width+"%";
		innerhtml_header.append("<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr>");
		innertext_header.append("<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr>"); //IN052716
		for(int l=0;l<fields.size();++l)
		{
			 col_field = (String)fields.get(l);
			 
			 
			
			 if(col_field.equals("ACCURACY"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10" ><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
			<%
			 innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accuracy.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accuracy.label","common_labels")+"</b></td>"); //IN052716
			}
			else if(col_field.equals("ONSET DATE"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10"  ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.onsetdate.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.onsetdate.label","common_labels")+"</b></td>");//IN052716
			}
			else if(col_field.equals("DESCRIPTION"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10"  ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<%
			
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</b></td>");//IN052716
			}
			else if(col_field.equals("STAGE"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10"  ><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+"</b></td>");//IN052716
			}
			else if(col_field.equals("CODE"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</b></td>");//IN052716
			}
			else if(col_field.equals("SCHEME"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10" ><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.scheme.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.scheme.label","common_labels")+"</b></td>");//IN052716
			}
			else if(col_field.equals("DIAGNOSIS REMARKS"))//38981 start
			{
				
			%>
				<td class='columnheadercenter' style="font-size:10" ><fmt:message key="eCA.DiagnosisRemarks.label" bundle="${ca_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DiagnosisRemarks.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DiagnosisRemarks.label","ca_labels")+"</b></td>");
			}//38981 end
		} //for loops ends
		
		              //38981 start
	   if(includestatus.equals("Y")){ 
	  
		%>
			 <td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.SupportingDiag.label" bundle="${ca_labels}"/></td>
		<% 
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SupportingDiag.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SupportingDiag.label","ca_labels")+"</b></td>");
		}	//38981 end
		innerhtml_header.append("</tr>");
		innertext_header.append("</tr>");//IN052716
		
	}
	else
	{
		
 %>

<td class='columnheadercenter'  style="font-size:10" width='10%'><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter'  style="font-size:10" width='10%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter'  style="font-size:10" width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter'  style="font-size:10" width='10%'><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter'  style="font-size:10" width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter'  style="font-size:10" width='10%'> <fmt:message key="Common.scheme.label" bundle="${common_labels}"/></td>
<td class='columnheadercenter'  style="font-size:10" width='30%'><fmt:message key="eCA.DiagnosisRemarks.label" bundle="${ca_labels}"/></td><!-- 38981 -->

<%
	}  
%>

</tr>
<!--
</table>
</div>
<div id="finalDiv1">
<table id="finalDiv"  width="100%" class='grid'>
-->
<%

	ArrayList d=null;
	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	String curr_remarks="";//38981
	String supportDiagDesc="";//38981
    String support_exisist_yn_yn="";//38981
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	//String end_date="";
	String diagtypestr="";
    String onsetdate="";
    String onsetdate1="";
    String diagdesc="";
    String diagstage="";
    String diagcodestr="";
    String diagcodescheme="";
    StringBuffer innerhtml = new StringBuffer();
    StringBuffer innertext = new StringBuffer();
    StringBuffer temp_new = new StringBuffer();
	
	
	String return_format="";
	
	return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	  
	String formet="";
				//	out.println("return_format :" +return_format);
					if(return_format.equals("TEXT"))
					{
						formet="\n";
					}else
					{
						formet="<br>";
					}
	
	
	String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");
   	ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
//	ret_str=java.net.URLDecoder.decode(ret_str,"UTF-8");//IN033558.1 //commented IN037280 
	

	remval=(request.getParameter("remval")==null)?"0":request.getParameter("remval");
	removebean=(request.getParameter("removebean")==null)?"":request.getParameter("removebean");
			   

	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");

	if(sel_all.equals("select"))
	{
		//ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"));//IN033558.1
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"),"UTF-8");//IN033558.1
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}

	String cat = "";
	int i=0;
	int index=0;
   if(flag.equals("clear"))
	{
		
		//ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");//IN033558.1
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"),"UTF-8");
		
		if(ret_str!=null && !ret_str.equals(""))
		{
			
			ret_str = ret_str.substring(0, ret_str.length()-1);
		}
		

		

		if(ret_str!=null && !ret_str.equals(""))
		{
			
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"»");
			
   
			while(strtCodes.hasMoreTokens())
			{
			   
				temp= (String) strtCodes.nextToken();
				
				StringTokenizer tempCodes = new StringTokenizer(temp,"~");
				while(tempCodes.hasMoreTokens())
				{
					String key= tempCodes.nextToken();
					value=tempCodes.nextToken();
					

					index = Beannew.indexOfObject(key.trim());
					
							
					
				
					if(index!=-1)
					{
						
						Beannew.removeObject(index);
						Beannew.removeObject(index);
					}
					//Beannew.putObject(key);
					//Beannew.putObject(value);

				}
						
			}

				
		}
		else
		{
			
			Beannew.clearAll();
		}
		ret_str="";
	}
	
	if(!removebean.equals("Y"))
	{
		
       	  
		if(ret_str!=null && ret_str!="")
		{
			
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"»");   
			while(strtCodes.hasMoreTokens())
			{			   
				temp= (String) strtCodes.nextToken();
				StringTokenizer tempCodes = new StringTokenizer(temp,"~");
				while(tempCodes.hasMoreTokens())
				{
					String key= tempCodes.nextToken();
					value=tempCodes.nextToken();

					Beannew.putObject(key);
					Beannew.putObject(value);

				}
						
			}
		}		
				
		for(i=1;i<Beannew.getSize();i+=2){
			//Below code is commented and following code is added by Archana Dhal on 9/24/2010 related to the incident IN023584.
			disbean=Beannew.getObject(i).toString(); //Uncommented IN037280 
			//disbean= java.net.URLDecoder.decode(Beannew.getObject(i).toString()); //commented IN037280 

			if(temp_new.length() > 0)
				temp_new.delete(0,temp_new.length());
							
							
			String strs[] = disbean.split("\\|");
														
			if(strs.length>0)
			{
				diagstage="";
				diagtypestr= strs[0];
				onsetdate= strs[1];		
				onsetdate1 =  com.ehis.util.DateUtils.convertDate(onsetdate,"DMY","en",locale);		
				diagdesc= strs[2];
				diagstage= strs[3];
				diagcodestr= strs[4];
				diagcodescheme= strs[5];
				curr_remarks= strs[6];//38981
				support_exisist_yn_yn= strs[7];//38981
				supportDiagDesc= strs[8];//38981
				disbean = diagtypestr+"|"+onsetdate1+"|"+diagdesc+"|"+diagstage+"|"+diagcodestr+"|"+diagcodescheme+"|"+curr_remarks+"|"+support_exisist_yn_yn+"|"+supportDiagDesc;//38981
				%>
				<tr>
					<td class="gridData" width='5%' ><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=Beannew.getObject(i-1).toString()%>">
					</td>
				<%
				if(fields.size()>0){
					col_span = fields.size();
					innerhtml.append("<tr>"); 
					innertext.append("<tr>"); //IN052716
					for(int n=0;n<fields.size();++n){						
						col_field = (String)fields.get(n);
						if(n != 0)
							temp_new.append(",");

						if(col_field.equals("ACCURACY"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=diagtypestr%></td>
						<%
							temp_new.append(diagtypestr);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagtypestr+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagtypestr+"</td>");//IN052716
						}
						else if(col_field.equals("ONSET DATE"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=onsetdate1%></td>
						<%
							temp_new.append(onsetdate1);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+onsetdate1+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagtypestr+"</td>");//IN052716
						}
						else if(col_field.equals("DESCRIPTION"))
						{
						%>
							<td class="gridData" >&nbsp;<%=diagdesc%></td>
						<%
							temp_new.append(diagdesc);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagdesc+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagdesc+"</td>");//IN052716
						}
						else if(col_field.equals("STAGE"))
						{
							
							if(diagstage.equals("?")||diagstage.equals("")) {
								diagstage="&nbsp;";%>
							<td class="gridData" >&nbsp;<%=diagstage%></td>
							 <%}else{%>
							<td class="gridData" >&nbsp;<%=diagstage%></td> 
							<%}
							temp_new.append(diagstage);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagstage+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagstage+"</td>");//IN052716
						}
						else if(col_field.equals("CODE"))
						{
						%>
							<td class="gridData" >&nbsp;<%=diagcodestr%></td>
						<%
							temp_new.append(diagcodestr);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagcodestr+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagcodestr+"</td>");//IN052716
						}
						else if(col_field.equals("SCHEME"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=diagcodescheme%></td>
						<%
							temp_new.append(diagcodescheme);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagcodescheme+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagcodescheme+"</td>");//IN052716
						}
						else if(col_field.equals("DIAGNOSIS REMARKS"))//38981 start
						{
						%>
							<td class="gridData"  >&nbsp;<%=curr_remarks%></td>
						<%
							temp_new.append(curr_remarks);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+curr_remarks+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+curr_remarks+"</td>");
						}//38981 end
						
					}
					//38981 start
					
					if(includestatus !=null && includestatus.equals("Y")){
						if(support_exisist_yn_yn.equals("Y")){
						%>	
							   <td class="gridData"  >&nbsp;<%=supportDiagDesc%></td>
						<% 
						temp_new.append(supportDiagDesc);
						innerhtml.append("<td style='font-size:12'>&nbsp;"+supportDiagDesc+"</td>");
						innertext.append("<td style='font-size:12'>&nbsp;"+supportDiagDesc+"</td>");
						}else{
							%>	
							   <td class="gridData"  >&nbsp;</td>
							<% 
							temp_new.append("");
							innerhtml.append("<td style='font-size:12'>&nbsp;</td>");
							innertext.append("<td style='font-size:12'>&nbsp;</td>");
						}
					
					}
					
					//38981 end
						
					cat=cat+formet+temp_new.toString();
					innerhtml.append("</tr>");
					innertext.append("</tr>");//IN052716
					//cat =cat+temp_new.toString();
				}
				else
				{
				%>
					<td class="gridData" width='10%'>&nbsp;<%=diagtypestr%></td>
					<td class="gridData" width='10%'>&nbsp;<%=onsetdate1%></td>
					<td class="gridData" width='20%'>&nbsp;<%=diagdesc%></td>
					<%
					//	out.println("diagtypestr"+diagtypestr);

					if(diagstage.equals("?")||diagstage.equals("")) {
						diagstage="&nbsp;";%>
					<td class="gridData" width='10%'>&nbsp;<%=diagstage%></td>
					<%}else{%>
					<td class="gridData" width='10%'>&nbsp;<%=diagstage%></td> 
					<%}%>	
					<td class="gridData" width='10%'>&nbsp;<%=diagcodestr%></td>
					<td class="gridData" width='10%'>&nbsp;<%=diagcodescheme%></td>
					<td class="gridData" width='30%'>&nbsp;<%=curr_remarks%></td><!-- 38981 -->
					
					<% 
						//innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+diagtypestr+"</td><td style='font-size:12'>&nbsp;"+onsetdate1+"</td><td style='font-size:12'>&nbsp;"+diagdesc+"</td>	<td style='font-size:12'>&nbsp;"+diagstage+"</td><td style='font-size:12'>&nbsp;"+diagcodestr+"</td><td style='font-size:12'>&nbsp;"+diagcodescheme+"</td></tr>");
						//innertext.append("<tr><td style='font-size:12'>&nbsp;"+diagtypestr+"</td><td style='font-size:12'>&nbsp;"+onsetdate1+"</td><td style='font-size:12'>&nbsp;"+diagdesc+"</td>	<td style='font-size:12'>&nbsp;"+diagstage+"</td><td style='font-size:12'>&nbsp;"+diagcodestr+"</td><td style='font-size:12'>&nbsp;"+diagcodescheme+"</td></tr>");//IN052716
						innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+diagtypestr+"</td><td style='font-size:12'>&nbsp;"+onsetdate1+"</td><td style='font-size:12'>&nbsp;"+diagdesc+"</td>	<td style='font-size:12'>&nbsp;"+diagstage+"</td><td style='font-size:12'>&nbsp;"+diagcodestr+"</td><td style='font-size:12'>&nbsp;"+diagcodescheme+"</td><td style='font-size:12'>&nbsp;"+curr_remarks+"</td></tr>");//38981
						innertext.append("<tr><td style='font-size:12'>&nbsp;"+diagtypestr+"</td><td style='font-size:12'>&nbsp;"+onsetdate1+"</td><td style='font-size:12'>&nbsp;"+diagdesc+"</td>	<td style='font-size:12'>&nbsp;"+diagstage+"</td><td style='font-size:12'>&nbsp;"+diagcodestr+"</td><td style='font-size:12'>&nbsp;"+diagcodescheme+"</td><td style='font-size:12'>&nbsp;"+curr_remarks+"</td></tr>");//38981
						cat=cat+formet+disbean;	
						cat=cat.replace('|' , ',');
					
				}
						
						
			}
		}
		   	
		
	}

				

%>
</td>
</tr>
<%

	if(removebean.equals("Y"))
	{
	  
	  String beankey="";
	  for(int l=0;l<Beannew.getSize();l++)
	   {
			beankey=Beannew.getObject(l).toString();  
			if(remval.equalsIgnoreCase(beankey))
			{
					Beannew.removeObject(l);
					Beannew.removeObject(l);
					break;
			}
		}

		d=new ArrayList();
		d=Beannew.getRecordSetHandle();
		int size=0;
		size=d.size();
				
		for( i=1;i<size;i+=2){
							
			beanval= java.net.URLDecoder.decode(d.get(i).toString());
			if(temp_new.length() > 0)
				temp_new.delete(0,temp_new.length());
			
			String strs[] = beanval.split("\\|");
																			
			if(strs.length>0)
			{
				diagstage="";
				diagtypestr= strs[0];
				onsetdate= strs[1];
				//Date Conversion is done by Archana Dhal on 11/16/2010 related to IN025049.
				onsetdate1 =  com.ehis.util.DateUtils.convertDate(onsetdate,"DMY","en",locale);
				//Below code is commented and following code is added by Archana Dhal on 9/27/2010 related to the incident IN023584.

				diagdesc= strs[2];
				diagstage= strs[3];
				diagcodestr= strs[4];
				diagcodescheme= strs[5];
				curr_remarks= strs[6];// 38981 
				support_exisist_yn_yn= strs[7];// 38981 
				supportDiagDesc= strs[8];//38981
				%>
				<tr>	
				<td class="fields" width='5%'><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" onClick="selText(this)" checked value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=Beannew.getObject(i-1).toString()%>"></td>	

				<%
				if(fields.size()>0)
				{
					col_span = fields.size();
					innerhtml.append("<tr>"); 
					innertext.append("<tr>");//IN052716
					for(int n=0;n<fields.size();++n)
					{
						col_field = (String)fields.get(n);

						if(n != 0)
							temp_new.append(",");
							
						if(col_field.equals("ACCURACY"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=diagtypestr%></td>
						<%
							temp_new.append(diagtypestr);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagtypestr+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagtypestr+"</td>");//IN052716
						}
						else if(col_field.equals("ONSET DATE"))
						{
						%>
							<td class="gridData" >&nbsp;<%=onsetdate1%></td>
						<%
							temp_new.append(onsetdate1);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+onsetdate1+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+onsetdate1+"</td>");//IN052716
						}
						else if(col_field.equals("DESCRIPTION"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=diagdesc%></td>
						<%
							temp_new.append(diagdesc);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagdesc+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagdesc+"</td>");//IN052716
						}
						else if(col_field.equals("STAGE"))
						{
							if(diagstage.equals("?")||diagstage.equals("")) {diagstage="&nbsp;";%>
							<td class="gridData"  >&nbsp;<%=diagstage%></td>
							 <%}else{%>
							<td class="gridData" >&nbsp;<%=diagstage%></td> 
							<%}
							temp_new.append(diagstage);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagstage+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagstage+"</td>");//IN052716
						}
						else if(col_field.equals("CODE"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=diagcodestr%></td>
						<%
							temp_new.append(diagcodestr);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagcodestr+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagcodestr+"</td>");//IN052716
						}
						else if(col_field.equals("SCHEME"))
						{
						%>
							<td class="gridData" >&nbsp;<%=diagcodescheme%></td>
						<%
							temp_new.append(diagcodescheme);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+diagcodescheme+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+diagcodescheme+"</td>");//IN052716
						}
							else if(col_field.equals("DIAGNOSIS REMARKS"))//38981 start
						{
						%>
							<td class="gridData"  >&nbsp;<%=curr_remarks%></td>
						<%
							temp_new.append(curr_remarks);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+curr_remarks+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+curr_remarks+"</td>");
						}//38981 end
							
					}
					//38981 start
					
					if(includestatus !=null && includestatus.equals("Y")){
						if(support_exisist_yn_yn.equals("Y")){
					%>	
					  <td class="gridData"  >&nbsp;<%=supportDiagDesc%></td>
					<% 
						temp_new.append(supportDiagDesc);
						innerhtml.append("<td style='font-size:12'>&nbsp;"+supportDiagDesc+"</td>");
						innertext.append("<td style='font-size:12'>&nbsp;"+supportDiagDesc+"</td>");
						}else{
						%>	
						  <td class="gridData"  >&nbsp;</td>
						<%
						temp_new.append("");
						innerhtml.append("<td style='font-size:12'>&nbsp;</td>");
						innertext.append("<td style='font-size:12'>&nbsp;</td>");						
						}
					}
					
					//38981 end
					cat=cat+formet+temp_new.toString();
					
					innerhtml.append("</tr>");
					innertext.append("</tr>");//IN052716
					//cat =cat+temp_new.toString();

				}
				else
				{
				%>							
					<td class="gridData" width='10%'>&nbsp;<%=diagtypestr%></td>
					<td class="gridData" width='10%'>&nbsp;<%=onsetdate1%></td>
					<td class="gridData" width='20%'>&nbsp;<%=diagdesc%></td>
				 
					<%

					if(diagstage.equals("?")||diagstage.equals("")) {diagstage="&nbsp;";%>
					<td class="gridData" width='10%'>&nbsp;<%=diagstage%></td>
					<%}else{%>
					<td class="gridData" width='10%'>&nbsp;<%=diagstage%></td> 
					<%}%>	
					<td class="gridData" width='10%'>&nbsp;<%=diagcodestr%></td>
					<td class="gridData" width='10%'>&nbsp;<%=diagcodescheme%></td>	
					<td class="gridData" width='30%'>&nbsp;<%=curr_remarks%></td><!-- 38981 -->
					
					<% 
					//	innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+diagtypestr+"</td><td style='font-size:12'>&nbsp;"+onsetdate1+"</td><td style='font-size:12' >&nbsp;"+diagdesc+"</td><td style='font-size:12'>&nbsp;"+diagstage+"</td><td style='font-size:12'>&nbsp;"+diagcodestr+"</td><td  style='font-size:12'>&nbsp;"+diagcodescheme+"</td></tr>");
					//	innertext.append("<tr><td style='font-size:12'>&nbsp;"+diagtypestr+"</td><td style='font-size:12'>&nbsp;"+onsetdate1+"</td><td style='font-size:12' >&nbsp;"+diagdesc+"</td><td style='font-size:12'>&nbsp;"+diagstage+"</td><td style='font-size:12'>&nbsp;"+diagcodestr+"</td><td  style='font-size:12'>&nbsp;"+diagcodescheme+"</td></tr>");//IN052716
						innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+diagtypestr+"</td><td style='font-size:12'>&nbsp;"+onsetdate1+"</td><td style='font-size:12' >&nbsp;"+diagdesc+"</td><td style='font-size:12'>&nbsp;"+diagstage+"</td><td style='font-size:12'>&nbsp;"+diagcodestr+"</td><td  style='font-size:12'>&nbsp;"+diagcodescheme+"</td><td  style='font-size:12'>&nbsp;"+curr_remarks+"</td></tr>");//38981
						innertext.append("<tr><td style='font-size:12'>&nbsp;"+diagtypestr+"</td><td style='font-size:12'>&nbsp;"+onsetdate1+"</td><td style='font-size:12' >&nbsp;"+diagdesc+"</td><td style='font-size:12'>&nbsp;"+diagstage+"</td><td style='font-size:12'>&nbsp;"+diagcodestr+"</td><td  style='font-size:12'>&nbsp;"+diagcodescheme+"</td><td  style='font-size:12'>&nbsp;"+curr_remarks+"</td></tr>");//38981
					%>	
					
					<%	
						cat=cat+formet+beanval;
						cat=cat.replace('|' , ',');	
					
				}
			}
		}
		
	}

if(d!=null)d.clear();
	%>

</tr>
</table>
</div>
<%
if(!return_format.equals("TEXT"))
{
	
cat = "<font size=2>"+cat+"</font>";
}
cat = java.net.URLEncoder.encode(cat,"UTF-8"); //IN036181
%>
<input type="hidden" name="temp" id="temp" value="<%=cat%>">
<input type="hidden" name="count" id="count" value="<%=i-2%>">
<input type="hidden" name="innerhtml" id="innerhtml" value="<%=innerhtml.toString()%>">
<input type="hidden" name="innerhtml_header" id="innerhtml_header" value="<%=innerhtml_header.toString()%>">
<input type="hidden" name="innertext" id="innertext" value="<%=innertext.toString()%>">  <!-- IN052716 -->
<input type="hidden" name="innertext_header" id="innertext_header" value="<%=innertext_header.toString()%>"> <!-- IN052716 -->
</form>
<!--IN061907 starts-->
<%
if(call_from_link_doc_btn.equals("YES"))
{
%>	
	<script>
		returnDataApprove();
	</script>
<%
}
%>
<!--IN061907 Ends-->
</body>
</html>

