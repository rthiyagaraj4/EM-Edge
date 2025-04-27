<%
/*
Date		Edit History	Name				Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------------------------------
05/08/2024     64277		 Gomathi Sivakumar						Ramesh G		File created for  MMS-DM-CRF-0260-US005
-----------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*,java.net.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<%

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");


%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkChief.js'></script>

<html>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll="scrollTitle1()">
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>	

<%
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;

		ArrayList  fields			=	new ArrayList();
		String categ_sec_qry ="";
		String field_ref ="";
		String col_field ="";
		String		width			=	"";
		double		col_width		=	0.0;
		int col_span=0;
		StringBuffer innerhtml_header = new StringBuffer();
		StringBuffer innertext_header = new StringBuffer();
		String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
		String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	
	String complaintID = "";
	String complaint = "";
	String complaintDetails = "";
	String onsetDateTime = "";
	String remarks = "";
         
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
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}

%>

<form name="RecClinicalNotesLinkChiefSelectedTextForm" id="RecClinicalNotesLinkChiefSelectedTextForm">
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
		col_width = 98/col_span;
		innerhtml_header.append("<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr>");
		innertext_header.append("<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr>"); 
		for(int l=0;l<fields.size();++l)
		{
			 col_field = (String)fields.get(l);
			 
			 if(col_field.equals("COMPLAINT"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10" width='<%=col_width%>%'  align='left'><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Complaint.label","common_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Complaint.label","common_labels")+"</b></td>");
			}
			else if(col_field.equals("ONSETDATETIME"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10" width='<%=col_width%>%'  align='left'><fmt:message key="eCA.OnsetDatetime.label" bundle="${ca_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.OnsetDatetime.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.OnsetDatetime.label","ca_labels")+"</b></td>");
			}
			else if(col_field.equals("COMPLAINTDETAILS"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10" width='<%=col_width%>%'  align='left'><fmt:message key="eCA.ComplaintDetails.label" bundle="${ca_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ComplaintDetails.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ComplaintDetails.label","ca_labels")+"</b></td>");
			}
			else if(col_field.equals("REMARKS"))
			{
			%>
				<td class='columnheadercenter' style="font-size:10" width='<%=col_width%>%'  align='left'><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
			<%
			innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Remarks.label","ca_labels")+"</b></td>");
			innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Remarks.label","ca_labels")+"</b></td>");
			}
		} //for loops ends
		innerhtml_header.append("</tr>");
		innertext_header.append("</tr>");
	}
	else
	{
	%>
		<td class='columnheadercenter' style="font-size:10" width='20%'><fmt:message key="eCA.ComplaintDetails.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10" width='30%'><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10" width='20%'><fmt:message key="eCA.OnsetDatetime.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10" width='30%'><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
		<%
	}
			%>
</tr>
</table>
</div>
<div id="finalDiv1">
<table id="finalDiv"  width="100%" class='grid'>
<%
	ArrayList d=null;
	String ret_str="";
	String temp="";
	String value="";
	String remval="";
	String beanval="";
	String removebean="";
	String disbean="";
	String flag="";
    StringBuffer innerhtml = new StringBuffer();
    StringBuffer innertext = new StringBuffer();
    StringBuffer temp_new = new StringBuffer();
	
	String return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	  
	String formet="";
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

	if(sel_all.equals("select"))
	{
		ret_str=java.net.URLDecoder.decode((request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"),"UTF-8");
		ret_str = ret_str.substring(0, ret_str.length()-1);
	}

	String cat = "";
	int i=0;
	int index=0;
   if(flag.equals("clear"))
	{
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
			disbean=Beannew.getObject(i).toString(); 
					
			if(temp_new.length() > 0)
				temp_new.delete(0,temp_new.length());
							
			String strs[] = disbean.split("\\|");
			if(strs.length>0)
				{
				complaintID= strs[0];
				complaint= strs[1];
				complaintDetails= strs[2];
				remarks= strs[3];
				onsetDateTime= strs[4];		
				onsetDateTime =  com.ehis.util.DateUtils.convertDate(onsetDateTime,"DMYHM","en",locale);		
				disbean = complaintID+"|"+complaint+"|"+complaintDetails+"|"+remarks+"|"+onsetDateTime;
				%>
				<tr>
					<td class="gridData" width='5%' ><input type="checkbox" name="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' value="<%=Beannew.getObject(i-1).toString()%>">
					</td>
				<%
				if(fields.size()>0){
					col_span = fields.size();
					innerhtml.append("<tr>"); 
					innertext.append("<tr>"); 
					for(int n=0;n<fields.size();++n){						
						col_field = (String)fields.get(n);
						if(n != 0)
							temp_new.append(",");

						if(col_field.equals("COMPLAINT"))
						{
						%>
							<td  class="gridData" width='<%=col_width%>%'  align='left'  ><%=complaint%></td>
						<%
							temp_new.append(complaint);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+complaint+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+complaint+"</td>");
						}
						else if(col_field.equals("COMPLAINTDETAILS"))
						{
						%>
							<td  class="gridData" width='<%=col_width%>%'  align='left'  ><%=complaintDetails%></td>
						<%
							temp_new.append(complaintDetails);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+complaintDetails+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+complaintDetails+"</td>");
						}
						else if(col_field.equals("REMARKS"))
						{
						%>
							<td  class="gridData" width='<%=col_width%>%'  align='left' ><%=remarks%></td>
						<%
							temp_new.append(remarks);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+remarks+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+remarks+"</td>");
						}
						else if(col_field.equals("ONSETDATETIME"))
						{
							%>
							<td  class="gridData" width='<%=col_width%>%'  align='left'  ><%=onsetDateTime%></td> 
					<%
							temp_new.append(onsetDateTime);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+onsetDateTime+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+onsetDateTime+"</td>");
						}
						
						
					}
					
					cat=cat+formet+temp_new.toString();
					innerhtml.append("</tr>");
					innertext.append("</tr>");
				}	
				else
				{
				%>
					<td class="gridData"  width='20%'  align='left'>&nbsp;<%=complaintDetails%></td>
					<td class="gridData"  width='30%'  align='left'>&nbsp;<%=complaint%></td>
					<td class="gridData"  width='20%'  align='left'>&nbsp;<%=onsetDateTime%></td>
					<td class="gridData"  width='30%'  align='left'>&nbsp;<%=remarks%></td>
					
					<% 
						innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+complaintDetails+"</td><td style='font-size:12'>&nbsp;"+complaint+"</td><td style='font-size:12'>&nbsp;"+onsetDateTime+"</td>	<td style='font-size:12'>&nbsp;"+remarks+"</td></tr>");
						innertext.append("<tr><td style='font-size:12'>&nbsp;"+complaintDetails+"</td><td style='font-size:12'>&nbsp;"+complaint+"</td><td style='font-size:12'>&nbsp;"+onsetDateTime+"</td>	<td style='font-size:12'>&nbsp;"+remarks+"</td></tr>");
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
				complaintID= strs[0];
				complaint= strs[1];
				complaintDetails= strs[2];
				remarks= strs[3];
				onsetDateTime= strs[4];		
				onsetDateTime =  com.ehis.util.DateUtils.convertDate(onsetDateTime,"DMYHM","en",locale);		
				
				%>
				<tr>	
				<td class="gridData" width='5%' ><input type="checkbox" name="chkbox<%=(i-1)%>" onClick="selText(this)" checked value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' value="<%=Beannew.getObject(i-1).toString()%>"></td>	

				<%
				if(fields.size()>0)
				{
					col_span = fields.size();
					innerhtml.append("<tr>"); 
					innertext.append("<tr>");
					for(int n=0;n<fields.size();++n)
					{
						col_field = (String)fields.get(n);

						if(n != 0)
							temp_new.append(",");
							
						if(col_field.equals("COMPLAINT"))
						{
						%>
							<td  class="gridData" width='<%=col_width%>%'  align='left' ><%=complaint%></td>
						<%
							temp_new.append(complaint);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+complaint+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+complaint+"</td>");
						}
						else if(col_field.equals("COMPLAINTDETAILS"))
						{
						%>
							<td  class="gridData" width='<%=col_width%>%'  align='left' ><%=complaintDetails%></td>
						<%
							temp_new.append(complaintDetails);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+complaintDetails+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+complaintDetails+"</td>");
						}
						else if(col_field.equals("REMARKS"))
						{
						%>
							<td  class="gridData" width='<%=col_width%>%'  align='left' ><%=remarks%></td>
						<%
							temp_new.append(remarks);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+remarks+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+remarks+"</td>");
						}
						else if(col_field.equals("ONSETDATETIME"))
						{
							%>
							<td  class="gridData" width='<%=col_width%>%'  align='left' ><%=onsetDateTime%></td> 
					<%
							temp_new.append(onsetDateTime);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+onsetDateTime+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+onsetDateTime+"</td>");
						}							
					}
					cat=cat+formet+temp_new.toString();
					
					innerhtml.append("</tr>");
					innertext.append("</tr>");
				}
				else
				{
				%>	
					<td class="gridData"  width='30%'  align='left'>&nbsp;<%=complaint%></td>
					<td class="gridData"  width='20%'  align='left'>&nbsp;<%=complaintDetails%></td>
					<td class="gridData"  width='20%'  align='left'>&nbsp;<%=onsetDateTime%></td>
					<td class="gridData"  width='30%'  align='left'>&nbsp;<%=remarks%></td>
					
					<% 
						innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+complaint+"</td><td style='font-size:12'>&nbsp;"+complaintDetails+"</td><td style='font-size:12'>&nbsp;"+onsetDateTime+"</td>	<td style='font-size:12'>&nbsp;"+remarks+"</td></tr>");
						innertext.append("<tr><td style='font-size:12'>&nbsp;"+complaint+"</td><td style='font-size:12'>&nbsp;"+complaintDetails+"</td><td style='font-size:12'>&nbsp;"+onsetDateTime+"</td>	<td style='font-size:12'>&nbsp;"+remarks+"</td></tr>");
						cat=cat+formet+disbean;	
						cat=cat.replace('|' , ',');
					
				}
			}
		}
	}
if(d!=null)d.clear();
	%>

</tr>
</table>
</div></table>
<%
if(!return_format.equals("TEXT"))
{
	
cat = "<font size=2>"+cat+"</font>";
}
cat = java.net.URLEncoder.encode(cat,"UTF-8"); 
%>
<input type="hidden" name="temp" id="temp" value="<%=cat%>">
<input type="hidden" name="count" id="count" value="<%=i-2%>">
<input type="hidden" name="innerhtml" id="innerhtml" value="<%=innerhtml.toString()%>">
<input type="hidden" name="innerhtml_header" id="innerhtml_header" value="<%=innerhtml_header.toString()%>">
<input type="hidden" name="innertext" id="innertext" value="<%=innertext.toString()%>"> 
<input type="hidden" name="innertext_header" id="innertext_header" value="<%=innertext_header.toString()%>"> 
</form>
</body>
</html>

