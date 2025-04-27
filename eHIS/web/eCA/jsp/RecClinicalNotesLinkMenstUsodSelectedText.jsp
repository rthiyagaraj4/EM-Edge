<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	  Name		      Rev.Date	      Rev.Name		 Description
------------------------------------------------------------------------------------------------------------------------------
29/10/2024	   70704       Gunasekar R                                     ML-MMOH-CRF-1759
------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="eCA.CAMenstrualHistDtlTransBean,webbeans.eCommon.*,java.sql.*, java.util.*,java.net.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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
	<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkMenstHistDtl.js"></script>

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
		String bean_id = "@CAMenstrualHistDtlTransBean" ;
		String bean_name = "eCA.CAMenstrualHistDtlTransBean";

		CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean) getBeanObject( bean_id, bean_name ,  request) ;

		ArrayList  fields			=	new ArrayList();
		String col_field ="";
		String		width			=	"";
		double		col_width		=	0.0;
		int col_span=0;
		StringBuffer innerhtml_header = new StringBuffer();
		StringBuffer innertext_header = new StringBuffer(); 
		
		String result_linked_rec_type =	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
		String sec_hdg_code	      =	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

		String call_from_link_doc_btn     = request.getParameter("call_from_link_doc_btn")==null?"":request.getParameter("call_from_link_doc_btn");
		String includestatus		  =	request.getParameter("includestatus")==null?"N":request.getParameter("includestatus");
		String result_sub_category	  =	request.getParameter("result_sub_category")==null?"":request.getParameter("result_sub_category");

		fields = bean.getFields(sec_hdg_code, result_linked_rec_type, result_sub_category);
	    if(fields.size()==0)
	  	   fields = bean.getFields(result_linked_rec_type, result_sub_category );
%>
<form name="RecClinicalNotesLinkMenstSelectedTextForm" id="RecClinicalNotesLinkMenstSelectedTextForm">
<div id='divDataTitle' style='postion:relative'>
<table border="1" cellpadding="3" cellspacing="0" width="100%" align='center'>
<tr ><td class='CAGROUP' ><b><font size='2'><fmt:message key="eCA.SelectedItems.label" bundle="${ca_labels}"/></b></td></tr>
</table>
</div> 
<div id="finalDiv1">
<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
<tr><td class='columnheadercenter' style="font-size:10" width='5%' ></td>
<%
	if(fields.size()>0)
	{
			col_span = fields.size();
			innerhtml_header.append("<table  border='1'  cellpadding='3' cellspacing='0' width='100%'><tr>");
			innertext_header.append("<table  border='0'  cellpadding='3' cellspacing='0' width='100%'><tr>");
			for(int l=0;l<fields.size();++l)
			{
				 col_field = (String)fields.get(l);
				if(col_field.equals("SCANGESTATION"))
				{
				%>
				   <td class='columnheadercenter' style="font-size:10; padding:4px;"><fmt:message key="eCA.ScanGestation.label" bundle="${ca_labels}"/></td>
				<%
				innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ScanGestation.label","ca_labels")+"</b></td>");
				innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ScanGestation.label","ca_labels")+"</b></td>");
				}				 
			     else if(col_field.equals("LMP"))
				{
				%>
					<td class='columnheadercenter' style="font-size:10" ><fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/></td>
				<%
				innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LMP.label","ca_labels")+"</b></td>");
				innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LMP.label","ca_labels")+"</b></td>");
				}
				else if(col_field.equals("REED"))
				{
				%>
					<td class='columnheadercenter' style="font-size:10"  ><fmt:message key="eCA.REDD.label" bundle="${ca_labels}"/></td>
				<%
				
				innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.REDD.label","ca_labels")+"</b></td>");
				innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.REDD.label","ca_labels")+"</b></td>");
				}
				else if(col_field.equals("GESTATION(POG)"))
				{
				%>
					<td class='columnheadercenter' style="font-size:10"  ><fmt:message key="eCA.GestationPOG.label" bundle="${ca_labels}"/></td>
				<%
				innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.GestationPOG.label","ca_labels")+"</b></td>");
				innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.GestationPOG.label","ca_labels")+"</b></td>");
				}
				else if(col_field.equals("DELIVERYDATE"))
				{
				%>
					<td class='columnheadercenter' style="font-size:10" ><fmt:message key="eCA.DeliveryDate.label" bundle="${ca_labels}"/></td>
				<%
				innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DeliveryDate.label","ca_labels")+"</b></td>");
				innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DeliveryDate.label","ca_labels")+"</b></td>");
				}
				else if(col_field.equals("MISCARRIAGEDATE"))
				{
				%>
					<td class='columnheadercenter' style="font-size:10" ><fmt:message key="eCA.MiscarriageDate.label" bundle="${ca_labels}"/></td>
				<%
				innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MiscarriageDate.label","ca_labels")+"</b></td>");
				innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MiscarriageDate.label","ca_labels")+"</b></td>");
				}
				else if(col_field.equals("REMARKS"))
				{
				%>
					<td class='columnheadercenter' style="font-size:10" ><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
				<%
				innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Remarks.label","ca_labels")+"</b></td>");
				innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Remarks.label","ca_labels")+"</b></td>");
				}
				else if(col_field.equals("EVENTSTATUS"))
				{
				%>
					<td class='columnheadercenter' style="font-size:10" ><fmt:message key="eCA.EventStatus.label" bundle="${ca_labels}"/></td>
				<%
				innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EventStatus.label","ca_labels")+"</b></td>");
				innertext_header.append("<td align='center' class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EventStatus.label","ca_labels")+"</b></td>");
				}
			} 
			innerhtml_header.append("</tr>");
			innertext_header.append("</tr>");
		}
	else
	{
	%>
<td class='columnheadercenter'  style="font-size:10; padding:4px;"><fmt:message key="eCA.ScanGestation.label" bundle="${ca_labels}"/></td>				
<td class='columnheadercenter'  style="font-size:10"><fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/></td>						
<td class='columnheadercenter'  style="font-size:10"><fmt:message key="eCA.REDD.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter'  style="font-size:10"><fmt:message key="eCA.GestationPOG.label" bundle="${ca_labels}"/></td>							
<td class='columnheadercenter'  style="font-size:10"><fmt:message key="eCA.DeliveryDate.label" bundle="${ca_labels}"/></td>		
<td class='columnheadercenter'  style="font-size:10"> <fmt:message key="eCA.MiscarriageDate.label" bundle="${ca_labels}"/></td>		
<td class='columnheadercenter'  style="font-size:10"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>			
<td class='columnheadercenter'  style="font-size:10"><fmt:message key="eCA.EventStatus.label" bundle="${ca_labels}"/></td>					
<%} 
%>
</tr>

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

    String scan_gestation="";
    String usod_lmp="";
    String redd="";
    String usod_gestation_pog="";
 	String usod_delivery_date = "";
 	String usod_miscarriage_date="";
    String usod_remarks="";
 	String usod_event_status = "";
    
    StringBuffer innerhtml = new StringBuffer();
    StringBuffer innertext = new StringBuffer();
    StringBuffer temp_new = new StringBuffer();
	
	String  return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
	  
	String formet="";
					if(return_format.equals("TEXT"))
					{
						formet="\n";
					}else
					{
						formet="<br>";
					}
	
	
	String sel_all	=	request.getParameter("sel_all")==null?"":request.getParameter("sel_all");
   	ret_str			=	(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str");
	remval			=	(request.getParameter("remval")==null)?"0":request.getParameter("remval");
	removebean		=	(request.getParameter("removebean")==null)?"":request.getParameter("removebean");
	flag			=	(request.getParameter("flag")==null)?"":request.getParameter("flag");

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
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"�");
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
			StringTokenizer strtCodes = new StringTokenizer(ret_str,"�");   
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
				scan_gestation= strs[0];
				usod_lmp=strs[1];
				redd= strs[2];		
				usod_gestation_pog = strs[3]; 	
				usod_delivery_date= strs[4];
				usod_miscarriage_date= strs[5];
				usod_remarks= strs[6];
				usod_event_status= strs[7];
				disbean = scan_gestation+"|"+usod_lmp+"|"+redd+"|"+usod_gestation_pog+"|"+usod_delivery_date+"|"+usod_miscarriage_date+"|"+usod_remarks+"|"+usod_event_status;
				%>
				<tr>
					<td class="gridData" width='5%' ><input type="checkbox" name="chkbox<%=(i-1)%>" checked  onClick="selText(this)" value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' value="<%=Beannew.getObject(i-1).toString()%>">
				</td>
				<%
				String classValue="gridData";
				if(fields.size()>0){
					col_span = fields.size();
					innerhtml.append("<tr>"); 
					innertext.append("<tr>"); 
					for(int n=0;n<fields.size();++n){						
						col_field = (String)fields.get(n);
						if(n != 0)
							temp_new.append(",");

						if(col_field.equals("SCANGESTATION"))
						{
						%>
							<td class="<%=classValue%>"><%=scan_gestation%></td>
						<%
							temp_new.append(scan_gestation);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+scan_gestation+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+scan_gestation+"</td>");
						}
						else if(col_field.equals("LMP"))
						{
						%>
							<td class="<%=classValue%>"><%=usod_lmp%></td>
						<%
							temp_new.append(usod_lmp);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_lmp+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_lmp+"</td>");
						}
						else if(col_field.equals("REED"))
						{
						%>
							<td class="<%=classValue%>"><%=redd%></td>
						<%
							temp_new.append(redd);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+redd+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+redd+"</td>");
						}
						else if(col_field.equals("GESTATION(POG)"))
						{
						%>
							<td class="<%=classValue%>" ><%=usod_gestation_pog%></td>
						<%
							temp_new.append(usod_gestation_pog);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_gestation_pog+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_gestation_pog+"</td>");
						}
						else if(col_field.equals("DELIVERYDATE"))
						{%>
							<td class="<%=classValue%>" ><%=usod_delivery_date%></td> 
							<%
							temp_new.append(usod_delivery_date);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_delivery_date+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_delivery_date+"</td>");
						}
						else if(col_field.equals("MISCARRIAGEDATE"))
						{
						%>
							<td class="<%=classValue%>" ><%=usod_miscarriage_date%></td>
						<%
							temp_new.append(usod_miscarriage_date);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_miscarriage_date+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_miscarriage_date+"</td>");
						}
						else if(col_field.equals("REMARKS"))
						{
						%>
							<td class="<%=classValue%>" ><%=usod_remarks%></td>
						<%
							temp_new.append(usod_remarks);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_remarks+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_remarks+"</td>");
						}
						else if(col_field.equals("EVENTSTATUS"))
						{
						%>
							<td class="<%=classValue%>"  ><%=usod_event_status%></td>
						<%
							temp_new.append(usod_event_status);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_event_status+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_event_status+"</td>");
						}
					}

					cat=cat+formet+temp_new.toString();
					innerhtml.append("</tr>");
					innertext.append("</tr>");
				}
				else
				{
				%>
					<td class="gridData">&nbsp;<%=scan_gestation%></td>
					<td class="gridData">&nbsp;<%=usod_lmp%></td>
					<td class="gridData">&nbsp;<%=redd%></td>
					<td class="gridData">&nbsp;<%=usod_gestation_pog%></td>
					<td class="gridData">&nbsp;<%=usod_delivery_date%></td>
					<td class="gridData">&nbsp;<%=usod_miscarriage_date%></td> 
					<td class="gridData">&nbsp;<%=usod_remarks%></td>
					<td class="gridData">&nbsp;<%=usod_event_status%></td>					
					<% 
					
					innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+scan_gestation+"</td><td style='font-size:12'>&nbsp;"+usod_lmp+"</td><td style='font-size:12' >&nbsp;"+redd+"</td><td style='font-size:12'>&nbsp;"+usod_gestation_pog+"</td><td style='font-size:12'>&nbsp;"+usod_delivery_date+"</td><td  style='font-size:12'>&nbsp;"+usod_miscarriage_date+"</td><td  style='font-size:12'>&nbsp;"+usod_remarks+"</td><td style='font-size:12'>&nbsp;"+usod_event_status+"</td></tr>");
					innertext.append("<tr><td style='font-size:12'>&nbsp;"+scan_gestation+"</td><td style='font-size:12'>&nbsp;"+usod_lmp+"</td><td style='font-size:12' >&nbsp;"+redd+"</td><td style='font-size:12'>&nbsp;"+usod_gestation_pog+"</td><td style='font-size:12'>&nbsp;"+usod_delivery_date+"</td><td  style='font-size:12'>&nbsp;"+usod_miscarriage_date+"</td><td  style='font-size:12'>&nbsp;"+usod_remarks+"</td><td style='font-size:12'>&nbsp;"+usod_event_status+"</td></tr>");
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
				scan_gestation= strs[0];
				usod_lmp= strs[1];		
				redd = strs[2]; 	
				usod_gestation_pog= strs[3];
				usod_delivery_date= strs[4];
				usod_miscarriage_date= strs[5];
				usod_remarks= strs[6];
				usod_event_status= strs[7];
				%>
				<tr>	
				<td class="fields" width='5%'><input type="checkbox" name="chkbox<%=(i-1)%>" onClick="selText(this)" checked value="<%=(i-1)%>"><input type=hidden name='clear<%=(i-1)%>' value="<%=Beannew.getObject(i-1).toString()%>"></td>	

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
							
						if(col_field.equals("SCANGESTATION"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=scan_gestation%></td>
						<%
							temp_new.append(scan_gestation);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+scan_gestation+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+scan_gestation+"</td>");
						}
						else if(col_field.equals("LMP"))
						{
						%>
							<td class="gridData" >&nbsp;<%=usod_lmp%></td>
						<%
							temp_new.append(usod_lmp);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_lmp+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_lmp+"</td>");
						}
						else if(col_field.equals("REED"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=redd%></td>
						<%
							temp_new.append(redd);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+redd+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+redd+"</td>");
						}
						else if(col_field.equals("GESTATION"))
						{
							%>
							<td class="gridData"  >&nbsp;<%=usod_gestation_pog%></td>
                            <%
							temp_new.append(usod_gestation_pog);	
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_gestation_pog+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_gestation_pog+"</td>");
						}
						else if(col_field.equals("DELIVERYDATE"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=usod_delivery_date%></td>
						<%
							temp_new.append(usod_delivery_date);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_delivery_date+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_delivery_date+"</td>");
						}
						else if(col_field.equals("MISCARRIAGEDATE"))
						{
						%>
							<td class="gridData" >&nbsp;<%=usod_miscarriage_date%></td>
						<%
							temp_new.append(usod_miscarriage_date);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_miscarriage_date+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_miscarriage_date+"</td>");
						}
							else if(col_field.equals("REMARKS"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=usod_remarks%></td>
						<%
							temp_new.append(usod_remarks);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_remarks+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_remarks+"</td>");
						}	
						else if(col_field.equals("EVENTSTATUS"))
						{
						%>
							<td class="gridData"  >&nbsp;<%=usod_event_status%></td>
						<%
							temp_new.append(usod_event_status);
							innerhtml.append("<td style='font-size:12'>&nbsp;"+usod_event_status+"</td>");
							innertext.append("<td style='font-size:12'>&nbsp;"+usod_event_status+"</td>");
							}	
					}

					cat=cat+formet+temp_new.toString();
					innerhtml.append("</tr>");
					innertext.append("</tr>");
				}
				else
				{
				%>							
					<td class="gridData">&nbsp;<%=scan_gestation%></td>
					<td class="gridData">&nbsp;<%=usod_lmp%></td>
					<td class="gridData">&nbsp;<%=redd%></td>
					<td class="gridData">&nbsp;<%=usod_gestation_pog%></td>
					<td class="gridData">&nbsp;<%=usod_delivery_date%></td> 
					<td class="gridData">&nbsp;<%=usod_miscarriage_date%></td>
					<td class="gridData">&nbsp;<%=usod_remarks%></td>
					<td class="gridData">&nbsp;<%=usod_event_status%></td>
					<% 
						innerhtml.append("<tr><td style='font-size:12'>&nbsp;"+scan_gestation+"</td><td style='font-size:12'>&nbsp;"+usod_lmp+"</td><td style='font-size:12' >&nbsp;"+redd+"</td><td style='font-size:12'>&nbsp;"+usod_gestation_pog+"</td><td style='font-size:12'>&nbsp;"+usod_delivery_date+"</td><td  style='font-size:12'>&nbsp;"+usod_miscarriage_date+"</td><td  style='font-size:12'>&nbsp;"+usod_remarks+"</td><td style='font-size:12'>&nbsp;"+usod_event_status+"</td></tr>");
						innertext.append("<tr><td style='font-size:12'>&nbsp;"+scan_gestation+"</td><td style='font-size:12'>&nbsp;"+usod_lmp+"</td><td style='font-size:12' >&nbsp;"+redd+"</td><td style='font-size:12'>&nbsp;"+usod_gestation_pog+"</td><td style='font-size:12'>&nbsp;"+usod_delivery_date+"</td><td  style='font-size:12'>&nbsp;"+usod_miscarriage_date+"</td><td  style='font-size:12'>&nbsp;"+usod_remarks+"</td><td style='font-size:12'>&nbsp;"+usod_event_status+"</td></tr>");
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
cat = java.net.URLEncoder.encode(cat,"UTF-8");
%>
<input type="hidden" name="temp" id="temp" value="<%=cat%>">
<input type="hidden" name="count" id="count" value="<%=i-2%>">
<input type="hidden" name="innerhtml" id="innerhtml" value="<%=innerhtml.toString()%>">
<input type="hidden" name="innerhtml_header" id="innerhtml_header" value="<%=innerhtml_header.toString()%>">
<input type="hidden" name="innertext" id="innertext" value="<%=innertext.toString()%>"> 
<input type="hidden" name="innertext_header" id="innertext_header" value="<%=innertext_header.toString()%>">
</form>
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
</body>
</html>

