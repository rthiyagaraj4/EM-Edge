<%
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date	Rev.Name	Description
-----------------------------------------------------------------------
?             100            ?           							created
07/10/2011  IN029084		Chowminya G								Incident No: IN029084 - <Add Item component which setting result category 																	is Medication into Note section Template> 
21/02/2012  IN036181		Chowminya G								reports which has special characters such as an airstrisk (*) or a 																			semicolon
28/11/2014	IN052716		Ramesh G								Result Link In Template Based Section In  Clinical Notes For ?Table? And 																	?Text?.
22/02/2016	IN059058		RAJA S									In Record Clinical Notes function show wrong note view. The header of 																		prescription note view section shown in wrong format.
25/07/2016	IN060688		Ramesh G								AAKH-CRF-0088.1
20/12/2023   54677    Krishna Pranay   21/12/2023  Ramesh Goli    CA-Common-Record Clinical Note
-----------------------------------------------------------------------

*/
%>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="Bean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097//54677
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- added by Kishore Kumar N on 10/12/2008  -->
		
		<!-- end here -->
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkMed.js'></script>

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
		StringBuffer temp_new = new StringBuffer();

		String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
		String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

		
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
	//out.println("Exception caught in RecClinicalNotesLinkDiagSelectedText.jsp" + e);//common-icn-0181
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}



%>

<form name="RecClinicalNotesLinkMedSelectedTextForm" id="RecClinicalNotesLinkMedSelectedTextForm">
<div id='divDataTitle' style='postion:relative'>
<table border="1" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr ><td colspan=2 class='CAGROUP' ><b><font size='2'><fmt:message key="eCA.SelectedItems.label" bundle="${ca_labels}"/></b></td></tr>
</table>

<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<tr><td class='columnheader' style="font-size:10" width='5%' ></td>
<%
	if(fields.size()>0)
	{
		col_span = fields.size();
		col_width= 100/col_span;
		width = col_width+"%";
		innerhtml_header.append("<table   border='1' cellpadding='0' cellspacing='0' width='100%'><tr>");
		innertext_header.append("<table   border='0' cellpadding='0' cellspacing='0' width='100%'><tr>"); //IN052716
		for(int l=0;l<fields.size();++l)
		{
			 col_field = (String)fields.get(l);
			 
			 
			
			if(col_field.equals("DRUGNAME"))
			{
			%>
				<td class='columnheader'  width='<%=width%>' style="font-size:10"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>				
			<%
			 innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels")+"</b></td>");//IN052716
			}
			//IN060688 Start.
			else if("GENERICNAME".equals(col_field))
			{
			%>				
				<td class='columnheader' width='<%=width%>' style="font-size:10"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td><!-- Ramesh Goli -->
			<%
			 innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels")+"</b></td>");//IN052716
			}
			//IN060688 End.
			else if(col_field.equals("DOSAGEDETAILS"))
			{
			%>
				<td class='columnheader' width='<%=width%>' style="font-size:10"><fmt:message key="eCA.DosageDetails.label" bundle="${ca_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DosageDetails.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DosageDetails.label","ca_labels")+"</b></td>");//IN052716
			}
			else if(col_field.equals("STARTDATE"))
			{
			%>
				<td class='columnheader' width='<%=width%>' style="font-size:10"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StartDate.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StartDate.label","common_labels")+"</b></td>");//IN052716
			}
			else if(col_field.equals("ENDDATE"))
			{
			%>
				<td class='columnheader' width='<%=width%>' style="font-size:10"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enddate.label","common_labels")+"</b></td>");//IN052716
			}
		//innerhtml_header.append("</tr>");  //commented for IN059058
		//innertext_header.append("</tr>"); //IN052716 //commented for IN059058
		}
		innerhtml_header.append("</tr>");  //Added for IN059058
		innertext_header.append("</tr>"); //Added for IN059058
	}
	else
	{

	%>

	<td class='columnheader'  width="22%" style="font-size:10"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width='22%' style="font-size:10"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td><!-- IN060688 -->
	<td class='columnheader' width="22%" style="font-size:10"><fmt:message key="eCA.DosageDetails.label" bundle="${ca_labels}"/></td>
	<td class='columnheader' width="19%" style="font-size:10"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
	<td class='columnheader' style="font-size:10"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
	<%
	}
	%>

</tr>
</table>
</div>


<div id="finalDiv1">
<table  class='grid' width="100%">



<%
	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
	String drug_name="";
	String generic_name = "";//IN060688
	String dosage_detail="";
	String strt_date="";
	String end_date="";
	String return_format="";
	
	return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	
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
   	ret_str = (request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
	
	remval = (request.getParameter("remval")==null)?"0":request.getParameter("remval");
	removebean = (request.getParameter("removebean")==null)?"":request.getParameter("removebean");
	flag = (request.getParameter("flag")==null)?"":request.getParameter("flag");

	StringBuffer innerhtml = new StringBuffer();
	StringBuffer innertext = new StringBuffer();//IN052716

	if(sel_all.equals("select"))
	{	
		ret_str = request.getParameter("ret_str")==null?"":request.getParameter("ret_str");
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}
	String cat = "";
	int i=0;
	if(flag.equals("clear"))
	{
		
      
		Bean.clearAll();
	}
	
	if(!removebean.equals("Y"))
	{
		
		if(ret_str!=null && ret_str!="")
		{
			
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"^");
   
			while(strtCodes.hasMoreTokens())
			{
			   
				temp= (String) strtCodes.nextToken();						
			   
			   StringTokenizer tempCodes = new StringTokenizer(temp,"~");
			 
 				while(tempCodes.hasMoreTokens())
				{
					String key= tempCodes.nextToken();
					value=tempCodes.nextToken();


				if(!(Bean.containsObject(key)))
				{
					Bean.putObject(key);
					Bean.putObject(value);
				}
				 
			}
 					
		}
		 
	}		
				
				for(i=1;i<Bean.getSize();i+=2)
				{
					
					disbean=Bean.getObject(i).toString();
					
					//code added by Shaiju 
						String strs[] = disbean.split("\\|");
												
						if(strs.length>0)
						{
						
						  drug_name		= strs[0];
						  generic_name	= strs[1]; //IN060688
						  dosage_detail	= strs[2];
						  strt_date		= strs[3];
						  end_date		= strs[4];
						  
					

						//code added by Shaiju  ends
					
				/*	StringTokenizer valCodes = new StringTokenizer(disbean,"|");
					while(valCodes.hasMoreTokens())
				{
					
					 drug_name= valCodes.nextToken();
					 dosage_detail= valCodes.nextToken();
					 strt_date= valCodes.nextToken();
					 end_date= valCodes.nextToken();
					*/

				%>
				<tr>
										
				<td class="fields" width='5%'><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=Bean.getObject(i-1).toString()%>">
                </td>	
               <%
				if(fields.size()>0)
				{
					col_span = fields.size();

					innerhtml.append("<tr>"); 
					innertext.append("<tr>");//IN052716
					
					for(int n=0;n<fields.size();++n)
					{
						col_field = (String)fields.get(n);

						if(col_field.equals("DRUGNAME"))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=drug_name%></td>
						<%
						temp_new.append(""+drug_name+"");
						innerhtml.append("<td style='font-size:12'>"+drug_name+"</td>");
						innertext.append("<td style='font-size:12'>"+drug_name+"</td>");//IN052716
						}
						//IN060688 Start.
						else if("GENERICNAME".equals(col_field))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=generic_name%></td>
						<%
						temp_new.append(""+generic_name+"");
						innerhtml.append("<td style='font-size:12'>"+generic_name+"</td>");
						innertext.append("<td style='font-size:12'>"+generic_name+"</td>");//IN052716
						}
						//IN060688 End.
						else if(col_field.equals("DOSAGEDETAILS"))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=dosage_detail%></td>
						<%
						temp_new.append(","+dosage_detail);	
						innerhtml.append("<td style='font-size:12'>"+dosage_detail+"</td>");
						innertext.append("<td style='font-size:12'>"+dosage_detail+"</td>");//IN052716
						}
						else if(col_field.equals("STARTDATE"))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=strt_date%></td>
						<%
						temp_new.append(","+strt_date);	
						innerhtml.append("<td style='font-size:12'>"+strt_date+"</td>");
						innertext.append("<td style='font-size:12'>"+strt_date+"</td>");//IN052716
						}
						else if(col_field.equals("ENDDATE"))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=end_date%></td>
						<%
						temp_new.append(","+end_date);	
						innerhtml.append("<td style='font-size:12'>"+end_date+"</td>");
						innertext.append("<td style='font-size:12'>"+end_date+"</td>");//IN052716
						}


					}
					if(!cat.equals("")) 
						cat=cat+formet+temp_new.toString();
					else
						cat=cat+temp_new.toString();

					innerhtml.append("</tr>");
					innertext.append("</tr>");//IN052716
					temp_new.setLength(0);//--[IN029084]--

				}
				else
				{
				%>
				
				
				
				<% 
					innerhtml.append("<tr><td class='gridData' style='font-size:12' >"+drug_name+"</td><td class='gridData' style='font-size:12' >"+generic_name+"</td><td class='gridData'  style='font-size:12' >"+dosage_detail+"</td><td class='gridData' style='font-size:12'>"+strt_date+"</td><td class='gridData' style='font-size:12'>"+end_date+"</td></tr>");
					innertext.append("<tr><td class='' style='font-size:12' >"+drug_name+"</td><td class='' style='font-size:12' >"+generic_name+"</td><td class=''  style='font-size:12' >"+dosage_detail+"</td><td class='' style='font-size:12'>"+strt_date+"</td><td class='' style='font-size:12'>"+end_date+"</td></tr>");//IN052716
				%>
				<td class='gridData' width="22%" ><%=drug_name%></td>
				<td class='gridData' width="22%" ><%=generic_name%></td>
				<td class='gridData' width="22%" ><%=dosage_detail%></td>
				<td class='gridData' width="19%" ><%=strt_date%></td>
				<td class='gridData' ><%=end_date%></td>
				
				<!-- <td class='gridData'><%=disbean%></td>  -->
					<%
					if(!cat.equals("")) 
						cat=cat+formet+disbean;
					else
						cat=cat+disbean;
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
	  for(int l=0;l<Bean.getSize();l++)
	   {
			beankey=Bean.getObject(l).toString();  



			if(remval.equalsIgnoreCase(beankey))
			{
					Bean.removeObject(l);
					Bean.removeObject(l);
					break;
			}
		}

				/*ArrayList d=new ArrayList();
				d=Bean.getRecordSetHandle();
				int size=0;
				size=d.size();
				d.clear();*/
				for( i=1;i<Bean.getSize();i+=2)
				{
					
					//beanval=d.get(i).toString();
					beanval=Bean.getObject(i).toString();  


					
				//code added by Shaiju 
						String strs[] = beanval.split("\\|");
												
						if(strs.length>0)
						{
						
						  drug_name		= strs[0];
						  generic_name	= strs[1]; //IN060688
						  dosage_detail	= strs[2];
						  strt_date		= strs[3];
						  end_date		= strs[4];
						  
					

						//code added by Shaiju  ends
					
				/*	StringTokenizer valCodes = new StringTokenizer(beanval,"|");
					while(valCodes.hasMoreTokens())
					{
					
					 drug_name= valCodes.nextToken();
					 dosage_detail= valCodes.nextToken();
					 strt_date= valCodes.nextToken();
					 end_date= valCodes.nextToken();
					*/
							
					%>
					<tr>	
					<td class='gridData' width='5%'><input type="checkbox" name="chkbox<%=(i-1)%>" id="chkbox<%=(i-1)%>" onClick="selText(this)" checked value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' id='clear<%=(i-1)%>' value="<%=Bean.getObject(i-1).toString()%>"></td>	
					<%
					
					if(fields.size()>0)
					{
						
						col_span = fields.size();

					innerhtml.append("<tr>"); 
					innertext.append("<tr>"); //IN052716
					
					for(int n=0;n<fields.size();++n)
					{
						col_field = (String)fields.get(n);

						if(col_field.equals("DRUGNAME"))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=drug_name%></td>
						<%
						temp_new.append(""+drug_name+"");
						innerhtml.append("<td style='font-size:12'>"+drug_name+"</td>");
						innertext.append("<td style='font-size:12'>"+drug_name+"</td>");//IN052716
						}
						//IN060688 Start.
						else if("GENERICNAME".equals(col_field))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=generic_name%></td>
						<%
						temp_new.append(""+generic_name+"");
						innerhtml.append("<td style='font-size:12'>"+generic_name+"</td>");
						innertext.append("<td style='font-size:12'>"+generic_name+"</td>");//IN052716
						}
						//IN060688 End.
						else if(col_field.equals("DOSAGEDETAILS"))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=dosage_detail%></td>
						<%
						temp_new.append(","+dosage_detail);	
						innerhtml.append("<td style='font-size:12'>"+dosage_detail+"</td>");
						innertext.append("<td style='font-size:12'>"+dosage_detail+"</td>");//IN052716
						}
						else if(col_field.equals("STARTDATE"))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=strt_date%></td>
						<%
						temp_new.append(","+strt_date);	
						innerhtml.append("<td style='font-size:12'>"+strt_date+"</td>");
						innertext.append("<td style='font-size:12'>"+strt_date+"</td>");//IN052716
						}
						else if(col_field.equals("ENDDATE"))
						{
						%>
							<td class='gridData' width='<%=width%>' ><%=end_date%></td>
						<%
						temp_new.append(","+end_date);	
						innerhtml.append("<td style='font-size:12'>"+end_date+"</td>");
						innertext.append("<td style='font-size:12'>"+end_date+"</td>");//IN052716
						}


					}
					if(!cat.equals(""))
						cat=cat+formet+temp_new.toString();
					else
						cat=cat+temp_new.toString();

					innerhtml.append("</tr>");
					innertext.append("</tr>");//IN052716
					temp_new.setLength(0);//--[IN029084]--


					}
					else
					{
				
					innerhtml.append("<tr><td class='gridData' style='font-size:12'  >"+drug_name+"</td><td class='gridData' style='font-size:12'  >"+generic_name+"</td><td class='gridData' style='font-size:12'  >"+dosage_detail+"</td><td class='gridData' style='font-size:12' >"+strt_date+"</td><td class='gridData' style='font-size:12' >"+end_date+"</td></tr>");
					innertext.append("<tr><td class='' style='font-size:12'  >"+drug_name+"</td><td class='' style='font-size:12'  >"+generic_name+"</td><td class='' style='font-size:12'  >"+dosage_detail+"</td><td class='' style='font-size:12' >"+strt_date+"</td><td class='' style='font-size:12' >"+end_date+"</td></tr>"); //IN052716
				%>
					
				<td class='gridData' width="22%"><%=drug_name%></td>
				<td class='gridData' width="22%"><%=generic_name%></td> <!-- IN060688 -->
				<td class='gridData' width="22%"><%=dosage_detail%></td>
				<td class='gridData'  ><%=strt_date%></td>
				<td class='gridData' ><%=end_date%></td>
					<%	
						if(!cat.equals(""))
							cat=cat+formet+beanval;
						else
							cat=cat+beanval;
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
<input type="hidden" name="innertext" id="innertext" value="<%=innertext.toString()%>">	<!-- IN052716 -->
<input type="hidden" name="innertext_header" id="innertext_header" value="<%=innertext_header.toString()%>"> <!-- IN052716 -->
</form>
</body>
</html>



