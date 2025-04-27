<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	 created
28/11/2014	IN052716		Ramesh G		Result Link In Template Based Section In  Clinical Notes For ?Table? And ?Text?.
-----------------------------------------------------------------------

*/
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="AllergyTypeBean" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- added by Kishore Kumar N on 10/12/2008  -->
		
		<!-- end here -->
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkAlrg.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<body onKeyDown="lockKey()">
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

	 <script>
	    function display_records(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)
	{
	
	eval("parent.frames[2].document.forms[0].detail"+obj).innerHTML="<a href='#'  onClick=\" display_records1('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black' bgcolor='#FF9933'>-</font></a>";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" status=\""+status+"\" error_status=\""+error_status+"\" onset_date=\""+onset_date+"\" det='add' steps='7'/></root>"
	
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)		   
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
		//alert(responseText);
	eval(responseText)
		document.getElementById("record").width=eval(document.getElementById("third0").offsetWidth);
		document.getElementById("finalDiv").width=eval(document.getElementById("third0").offsetWidth);	
}

function display_records1(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)
{
	//alert("1="+eval(document.getElementById("record").offsetWidth));
	parent.frames[2].document.getElementById("detail"+obj).innerHTML="<a href='#' onClick=\"display_records('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black'>+</font></a>";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" det='sub' status=\""+status+"\" error_status=\""+error_status+"\" onset_date=\""+onset_date+"\" steps='7'/></root>"
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eCA/jsp/AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
		/*var temp=0;
		alert(obj);
		alert(obj.value);
		for(i=0;i<obj.value;i++)
		{
			alert("i="+eval("document.getElementById("third")"+i.offsetWidth));
		}*/
		document.getElementById("record").width=eval(document.getElementById("third0").offsetWidth);
		document.getElementById("finalDiv").width=eval(document.getElementById("third0").offsetWidth);	
}
function callonload()
{
	var tot_allr=document.forms[0].rowcolor.value;
//parent.frames[0].document.forms[0].all.third1.style.display='inline';
//	parent.frames[0].document.forms[0].all.third1.style.display='visible';

}	
 </script>
</head>
<%
		int m=0;
	//String allergic_item="";
	//String allergy_type_desc="";
	String onset_date="";
	//String close_date="";
	//String status="";
	//String status2="";
	//String recorded_by_name="";
	String classValue="";
	 ArrayList temp4=new ArrayList();
	 ArrayList  fields			=	new ArrayList();
	 //ArrayList list1=new ArrayList();
	//int maxRecord=0;
	StringBuffer temp=new StringBuffer();
	StringBuffer temp2=new StringBuffer();
	String temp1="";
	String temp3="";
	//StringBuffer strsql1 = new StringBuffer(" ");
    StringBuffer innerhtml = new StringBuffer();
    StringBuffer innerhtml_header = new StringBuffer();
    StringBuffer innertext = new StringBuffer();  //IN052716
    StringBuffer innertext_header = new StringBuffer(); //IN052716
	String patient_id		=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String from_date_time	=	request.getParameter("from_date_time")==null?"":request.getParameter("from_date_time");
	String to_date_time		=	request.getParameter("to_date_time")==null?"":request.getParameter("to_date_time");
	String status1			=	request.getParameter("status1")==null?"":request.getParameter("status1");
	 
	String allergy_class	=	request.getParameter("allergy_type")==null?"":request.getParameter("allergy_type");
	String allergy_item    	=	request.getParameter("allergy_item")==null?"":request.getParameter("allergy_item");
	String order_by1		=	request.getParameter("order_by1")==null?"":request.getParameter("order_by1");
	String order_by2		=	request.getParameter("order_by2")==null?"":request.getParameter("order_by2");
	String ret_str		=	request.getParameter("ret_str")==null?"":request.getParameter("ret_str");

	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");

	String field_ref	=	"";
	String	col_field	=	"";
	//String col_val ="";
	int		col_span	=	0;
	String	width		=	"";
	int	col_width	=	0;
	String calculated_onset_date_yn = "";

	int cnt=0;


	
	if(ret_str.length()>0)
	{
	ret_str=ret_str.substring(0,ret_str.length()-3).trim() ;
	if(ret_str.indexOf("[")!=-1)
	{
			ret_str=ret_str.substring(1,ret_str.length()).trim() ;
	}
	if(ret_str.indexOf("]")!=-1)
	{
			ret_str=ret_str.substring(0,ret_str.length()-1).trim() ;
	}
	}

	//String rowid			=	"";

	from_date_time			=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time			=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
		
	Connection con = null;
	//PreparedStatement stmt=null;
	ResultSet rs=null;
	Statement stmt1 = null;

	PreparedStatement stmt=null;
	ResultSet rset=null;

	String allergen="",allergen1="",adv_event_type="",Certainity="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",cnt_recurring="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",StrSql2="",StrSql3="",StrSql4="",StrSql5 ="",row_id="" , error_status= "",adv_event_type_ind_code1="",onset_date_disply1="",onset_date1="" ;
	//int i=1;
	int k=0;
	int l=0;
	int j=0;
   	try
	{
		con =  ConnectionManager.getConnection(request);	  %>
	<form name="RecClinicalNotesLinkAlrgResultForm1" id="RecClinicalNotesLinkAlrgResultForm1">	
		<table  id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
		<tr ><td colspan='4' class='CAGROUP' ><b><font size='2'><fmt:message key="eCA.SelectedItems.label" bundle="${ca_labels}"/></b></td>
		</tr>
		</table>

		<table class='grid' width='100%'  id='record'>



	<tr>
		<td class='columnheadercenter' width="1%" ><div  id='head0'  class='myClass' nowrap width='3%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td class='columnheadercenter' width='1%'><div  id='head1'  class='myClass' nowrap width='3%'>&nbsp;&nbsp;-&nbsp;&nbsp;</div></td>
		
		
		<%
		
		String categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

		stmt = con.prepareStatement(categ_sec_qry);
		
		stmt.setString(1,sec_hdg_code);
		stmt.setString(2,result_linked_rec_type);
		stmt.setString(3,result_linked_rec_type);

		rset = stmt.executeQuery();

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
			 if (stmt != null) stmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

			stmt = con.prepareStatement(categ_sec_qry);
			stmt.setString(1,result_linked_rec_type);
			stmt.setString(2,result_linked_rec_type);

			rset = stmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(stmt != null) stmt.close();

			}
		

		}

			
	%>

		<%
			if(fields.size()>0)
			{

				col_span = fields.size();
				col_width = 98/col_span;
				width = col_width+"%";

				
				innerhtml_header.append("<table cellpadding='0'  border='1' cellspacing='0' width='100%'><tr>");
				innertext_header.append("<table cellpadding='0'  border='0' cellspacing='0' width='100%'><tr>"); //IN052716
				for(int i=0;i<fields.size();++i)
				{
				
					 col_field = (String)fields.get(i);
					if(col_field.equals("EVENTTYPE"))
					{
					%>
						<td class='columnheadercenter' width='<%=col_width%>%'><div  id='head2' class='myClass' nowrap width=''><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></div></td>
					<%
					innerhtml_header.append("<td  class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EventType.label","common_labels")+"</b></td>");
					innertext_header.append("<td  class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EventType.label","common_labels")+"</b></td>");//IN052716
					}
					else if(col_field.equals("ALLERGEN"))
					{
					%>
						<td class='columnheadercenter' width='<%=col_width%>%'><div  id='head3' class='myClass' nowrap width=''><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></div></td>
					<%
					innerhtml_header.append("<td  class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Allergen.label","mr_labels")+"</b></td>");
					innertext_header.append("<td  class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Allergen.label","mr_labels")+"</b></td>");//IN052716
					}
					else if(col_field.equals("ONSETDATE"))
					{
					%>
						<td class='columnheadercenter' width='<%=col_width%>%'><div  id='head4' class='myClass' nowrap width=''><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></div></td>
					<%
					innerhtml_header.append("<td  class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.onsetdate.label","common_labels")+"</b></td>");
					innertext_header.append("<td  class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.onsetdate.label","common_labels")+"</b></td>");//IN052716
					}
					else if(col_field.equals("Status"))
					{
					%>
						<td class='columnheadercenter' width='<%=col_width%>%'><div  id='head5' class='myClass' nowrap width=''><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></td>
					<%
					innerhtml_header.append("<td  class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</b></td>");
					innertext_header.append("<td  class=''  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</b></td>");//IN052716
					}

				}
				innerhtml_header.append("</tr>");
				innertext_header.append("</tr>");//IN052716
			}
			else
			{

		%>
		
		
		
		
		<td class='columnheadercenter' width='15%'><div  id='head2' class='myClass' nowrap width='24%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></div></td>
		<td class='columnheadercenter' width='15%'><div  id='head3' class='myClass' nowrap width='25%'><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></div></td>
		<td class='columnheadercenter' width='15%'><div  id='head4' class='myClass' nowrap width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></div></td>
		<td class='columnheadercenter' width='15%'><div  id='head5' class='myClass' nowrap width='23%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></td>
	</tr>
	<%
		}
		%>
		</table>
		<table width='100%'>
		<%
		//stmt1=con.createStatement();//common-icn-0180
		int rowcolor=0;

		   if(status1.equals("AT"))
				  StrSql2="a.status='A'";
				else if(status1.equals("Al"))
				   StrSql2="a.status!='E'";

				if(order_by1.equals("O"))
				{
				  StrSql3="a.onset_date";
				  StrSql5="a.allergen_code";
				}
				else if(order_by1.equals("A"))
				{
				   StrSql3="a.allergen_code";
				   StrSql5="a.onset_date";
				}

				if(order_by2.equals("AS"))
				  StrSql4="ASC";
				else if(order_by2.equals("DE"))
				   StrSql4="DESC";


		//Query has been changed by Jyothi G to get the thai description to fix IN024940 on 09/11/2010
		//String sql2="SELECT a.rowid row_id,(SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code, CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"'))) END allergen, MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') adv_event_type_ind_desc, MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1') adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,f.status error_status,a.calculated_onset_date_yn calculated_onset_date_yn FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+patient_id+"' and a.status!='E' and f.status!='E' AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code and a.rowid in('"+ret_str+"') AND f.adv_reac_code = g.reaction_code (+)  ORDER BY "+StrSql3+" "+StrSql4+", "+StrSql5+", a.ADV_EVENT_TYPE_IND,f.reaction_date ";//common-icn-0180	
		String sql2="SELECT a.rowid row_id,(SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,?,'1') reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code, CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id= ?),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id=?))) END allergen, MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,?,'1') adv_event_type_ind_desc, MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,?,'1') adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id=?),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,f.status error_status,a.calculated_onset_date_yn calculated_onset_date_yn FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+patient_id+"' and a.status!='E' and f.status!='E' AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code and a.rowid in('"+ret_str+"') AND f.adv_reac_code = g.reaction_code (+)  ORDER BY "+StrSql3+" "+StrSql4+", "+StrSql5+", a.ADV_EVENT_TYPE_IND,f.reaction_date ";	//common-icn-0180
		
		//ORDER BY "+StrSql3+" "+StrSql4+", f.reaction_date
		//ORDER BY a.onset_date,a.ADV_EVENT_TYPE_IND, a.allergen_code, f.reaction_date
		//common-icn-0180 starts
        stmt = con.prepareStatement(sql2);
		
		stmt.setString(1,locale);
		stmt.setString(2,locale);
		stmt.setString(3,locale);
		stmt.setString(4,locale);
		stmt.setString(5,locale);
		stmt.setString(6,locale);
		
		//rs=stmt1.executeQuery(sql2);//common-icn-0180
		rs=stmt.executeQuery();
		//common-icn-0180 ends
		if(rs !=null)
		{%>
			<%while(rs.next())
			  {
					 //row_id=rs.getString("row_id");	j++;

					 row_id=rs.getString("row_id");
					 
					 j++;
					
					 if( !temp4.contains(row_id))
				    {   
						 temp4.add(row_id);
					}
					causative_code=rs.getString("allergen_code");
					adv_event_type_ind_code=rs.getString("ADV_EVENT_TYPE_IND");

					adv_event_type_code=rs.getString("ADV_EVENT_TYPE");
					allergen=rs.getString("allergen");
					adv_event_type=rs.getString("adv_event_type_desc");
					Certainity=rs.getString("CERTAINTY");
					onset_date=rs.getString("ONSET_DATE");
					if(onset_date ==null) onset_date="&nbsp;";
					status=rs.getString("STATUS");
					severity_main=rs.getString("severity1");
					if(severity_main==null) severity_main="";
					adv_event_dtl_srl_no=rs.getString("adv_event_dtl_srl_no");
					if(adv_event_dtl_srl_no ==null) adv_event_dtl_srl_no="";
					causative_substance=rs.getString("causative_substance");
					if(causative_substance ==null) causative_substance="";
					route_of_exposure=rs.getString("route_of_exposure");
					if(route_of_exposure ==null) route_of_exposure="";
					severity_two=rs.getString("severity_two");
					if(severity_two ==null) severity_two="&nbsp;";
					adv_reac_code=rs.getString("adv_reac_code");
					if(adv_reac_code ==null) adv_reac_code="";
					reaction_date1 =rs.getString("reaction_date");
					if(reaction_date1 ==null) reaction_date1="";
					reac_desc=rs.getString("reac_desc");

					if(reac_desc ==null) reac_desc="&nbsp;";
					severity_code=rs.getString("severity_code");
					if(severity_code ==null)severity_code="";
					diagnosis_code=rs.getString("diagnosis_code");
					if(diagnosis_code==null)diagnosis_code="";
					active_date=rs.getString("active_date");
					if(active_date ==null) active_date="";
					final_reac_code_val=rs.getString("REACTION_CODE_VALUES");
					if(final_reac_code_val ==null || final_reac_code_val.equals("THR")) final_reac_code_val="";
					reaction_site=rs.getString("reaction_site");
					if(reaction_site ==null) reaction_site="&nbsp;";
					
					others_reaction=rs.getString("OTHERS_REACTION");
					if(others_reaction ==null) others_reaction="&nbsp;";

					error_status = rs.getString("error_status") == null ?"A":rs.getString("error_status");
					calculated_onset_date_yn=rs.getString("calculated_onset_date_yn") == null ? "N" : rs.getString("calculated_onset_date_yn");

					cnt_recurring=rs.getString("COUNT");
					if(adv_event_type_ind_code.equals("01"))
					{
						classValue1="MRALLERGY";
					}else if(adv_event_type_ind_code.equals("02"))
					{
						classValue1="MRHYPERII";
					}else if(adv_event_type_ind_code.equals("03"))
					{
						classValue1="MRHEADER";
					}else if(adv_event_type_ind_code.equals("04"))
					{
						classValue1="ORBROWN";
					}


					
					if(severity_main.equals("U"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					}else if(severity_main.equals("M"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					}else if(severity_main.equals("O"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					}else if(severity_main.equals("S"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
					}


					if(Certainity.equals("D"))
					{
					Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Definitive.label","common_labels");
					}else if(Certainity.equals("P"))
					{
					Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");
					}

					if(status.equals("A"))
					{
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
					}
					else if(status.equals("R"))
					{
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
					}else if(status.equals("E"))
					{
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
					}
					
					/*if(status.equals("A"))
					{
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
					} */
						
				
					if(route_of_exposure.equals("1"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Ingestion.label","mr_labels");
					}else if(route_of_exposure.equals("2"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Inhalation.label","mr_labels");
					}else if(route_of_exposure.equals("3"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Injection.label","mr_labels");
					}else if(route_of_exposure.equals("4"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Tropical.label","mr_labels");
					}
					

					if(severity_two.equals("U"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					}else if(severity_two.equals("M"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					}else if(severity_two.equals("O"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					}else if(severity_two.equals("S"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
					}

					onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
					reaction_date1_disply=DateUtils.convertDate(reaction_date1,"DMYHM","en",locale);

/*					out.println("<script>");
					out.println("alert('adv_event_type_code ="+adv_event_type_code+" ---- adv_event_type_code1 ="+adv_event_type_code1+" -------- causative_code = "+causative_code+" ---- allergen1="+allergen1+"')");
					out.println("</script>");*/

				if(fields.size()>0)
				{
					col_span = fields.size();
					if((!adv_event_type_code.equals(adv_event_type_code1) || !causative_code.equals(allergen1)|| !status.equals(status1)|| !adv_event_type_ind_code.equals(adv_event_type_ind_code1)|| !onset_date_disply.equals(onset_date_disply1)))
				{
					classValue = "gridData";
					/*if (classValue.equals("QRYODDSMALL"))
					{
					classValue = "QRYEVENSMALL";
					   //	k++;
					}else
					{
						classValue = "QRYODDSMALL";
						//k++; 
					}*/
				%>
			
			<tr id='first' width='' ><td colspan='6'>
		
			<table width='100%' id='tableData'>
			<tr>
			<td class="<%=classValue%>"  align='left'><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="ReassaignAlrg1(this);chkunchk(this)" value="<%=k%>"  checked  disabled>
				<%k++;%>

	        </td>	
			<td  class='<%=classValue1%>' nowrap id='detail<%=m%>'><a href='#'  onClick="display_records1('<%=m%>','<%=patient_id%>','<%=causative_code%>','<%=adv_event_type_ind_code%>','<%=adv_event_type_code%>','<%=reaction_date1%>','<%=status%>','<%=error_status%>','<%=onset_date_disply%>')">&nbsp;-&nbsp;</a>
			</td>
			<%
					
				if(cnt!=0)
					{
							temp.append("<br>");
							temp2.append("\n");
					}

				if(cnt!=0)
					{
							//innerhtml.append("<tr><td colspan='"+col_span+"'><table cellpadding='0'  border='1' cellspacing='0' width='100%'><tr> <td class='label'>&nbsp;&nbsp;&nbsp;</td><td class='label' >&nbsp;&nbsp;&nbsp;</td><td class='label'>&nbsp;&nbsp;&nbsp;</td><td class='label'>&nbsp;&nbsp;&nbsp;</td></tr></table></td></tr>"); 
							innerhtml.append("</table></td></tr>");
							innertext.append("</table></td></tr>");//IN052716
					}

				innerhtml.append("<tr>");
				innertext.append("<tr>");//IN052716
				for(int n=0;n<fields.size();++n)
				{
				   col_field = (String)fields.get(n);
				   if(col_field.equals("EVENTTYPE"))
				   {
			%>

					 <td  class='<%=classValue%>' width='<%=col_width%>%'  align='left' nowrap ><%=adv_event_type%></td>
			
			<%
				     temp.append(""+adv_event_type);		
				     temp2.append(""+adv_event_type);
				     innerhtml.append("<td class='label' style='font-size:12' >"+adv_event_type+"</td>");
				     innertext.append("<td class='label' style='font-size:12' >"+adv_event_type+"</td>");//IN052716
			        }
				    else if(col_field.equals("ALLERGEN"))
					{
			%>
			         <td class='<%=classValue%>' width='<%=col_width%>%' align='left' nowrap id='header'><%=allergen%></td>
			<%
					 temp.append(","+allergen);	
					 temp2.append(","+allergen);	
					 innerhtml.append("<td class='label' style='font-size:12' >"+allergen+"</td>");
					 innertext.append("<td class='label' style='font-size:12' >"+allergen+"</td>"); //IN052716
			
					}
					else if(col_field.equals("ONSETDATE"))
					{
			%>
					<td  class='<%=classValue%>'  align='left' width='<%=col_width%>%' nowrap><%=onset_date_disply%>
			<%
					if(calculated_onset_date_yn.equals("Y"))
					{
			%>
						(<fmt:message key="eCA.Approx.label" bundle="${ca_labels}"/>)				
			<%
					}
			%>
					 </td>
			  
			<%
				
					 temp.append(","+onset_date_disply);
					 temp2.append(","+onset_date_disply);
					 innerhtml.append("<td class='label' style='font-size:12' p>"+onset_date_disply);
					 innertext.append("<td class='label' style='font-size:12' p>"+onset_date_disply);//IN052716
					 if(calculated_onset_date_yn.equals("Y"))
					 {
						innerhtml.append(" ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Approx.label","ca_labels")+")");				
						innertext.append(" ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Approx.label","ca_labels")+")");//IN052716
					 }
					 innerhtml.append("</td>");
					 innertext.append("</td>");//IN052716
					}
					else if(col_field.equals("Status"))
					{
			%>
		
					 <%if(cnt_recurring.equals("0"))
					{
			%>
					 <td class='<%=classValue%>'  align='left' width='<%=col_width%>%' nowrap ><%=status%></td>
			<%		}
					else 
					{
			%>
				<td  class='<%=classValue%>' width='<%=col_width%>%' align='left' nowrap ><%=status%>(<%=cnt_recurring%>)<img src='../../eCommon/images/mandatory.gif' ></img></td>
			<%
					}
			%>
				

			<%
				temp.append(","+status+"");	
				temp2.append(","+status+"");
				 innerhtml.append("<td class='label' style='font-size:12'>"+status+"</td>");
				 innertext.append("<td class='label' style='font-size:12'>"+status+"</td>");//IN052716
				}
			%>
							
			<%
				}

					//temp.append("<br>");
					/*if(cnt!=0)
					{
							temp.append("<br>");
							temp2.append("\n");
					} */
							//temp.append(""+adv_event_type+","+allergen+","+onset_date_disply+","+status+"");
							//temp2.append(""+adv_event_type+","+allergen+","+onset_date_disply+","+status+"");

							temp.append("<br>");
							temp2.append("\n");
							temp.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SiteOfReaction.label","mr_labels")+"</b>");
							temp2.append(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SiteOfReaction.label","mr_labels")+"");
							temp.append("<br>");
							temp2.append("\n");
					/*if(cnt!=0)
					{
							innerhtml.append("<tr><td class='label'>&nbsp;&nbsp;&nbsp;</td><td class='label' >&nbsp;&nbsp;&nbsp;</td><td class='label'>&nbsp;&nbsp;&nbsp;</td><td class='label'>&nbsp;&nbsp;&nbsp;</td></tr>"); 
					}*/
					cnt++;
							
						//  innerhtml.append("<tr><td class='label' style='font-size:12' >"+adv_event_type+"</td><td class='label' style='font-size:12' >"+allergen+"</td><td class='label' style='font-size:12' p>"+onset_date_disply+"</td><td class='label' style='font-size:12'>"+status+"</td></tr>");

						 innerhtml.append("</tr>");
						 innertext.append("</tr>");//IN052716
						 // innerhtml.append("<tr><td colspan='"+col_span+"'><table cellpadding='0'  border='1' cellspacing='0' width='100%' ><tr ><td class='label' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels")+"</b></td><td class='label' style='font-size:12' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels")+"</b></td><td class='label' style='font-size:12' p><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels")+"</b></td><td class='label' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SiteOfReaction.label","mr_labels")+"</b></td></tr></table></td></tr>");
						  innerhtml.append("<tr><td colspan='"+col_span+"'><table cellpadding='0'  border='1' cellspacing='0' width='100%'><tr ><td class='label' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels")+"</b></td><td class='label' style='font-size:12' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels")+"</b></td><td class='label' style='font-size:12' p><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels")+"</b></td><td class='label' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SiteOfReaction.label","mr_labels")+"</b></td></tr>");
						  innertext.append("<tr><td colspan='"+col_span+"'><table cellpadding='0'  border='0' cellspacing='0' width='100%'><tr ><td class='' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels")+"</b></td><td class='' style='font-size:12' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels")+"</b></td><td class='' style='font-size:12' p><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels")+"</b></td><td class='' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SiteOfReaction.label","mr_labels")+"</b></td></tr>"); //IN052716
			%>
			</td>
			</tr>
			</table>
			</tr>
			<tr id='third<%=m%>' Style="display;visibility:visible">
			<td class='<%=classValue%>'  >&nbsp;</td><td class='<%=classValue%>' >&nbsp;</td>
			<td class=<%=classValue%> width='25%'  nowrap><b><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></b></td>
			<td class=<%=classValue%> width='25%' nowrap><b><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></b></td>
			<td class=<%=classValue%> width='25%' nowrap><b><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></b></td>
			<td class=<%=classValue%> width='25%' nowrap><b><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></b></td></tr>
		</td>
		
			
			<tr id='second<%=m%>' Style="display;visibility:visible" >
			<td class='<%=classValue%>'  >&nbsp;</td><td class='<%=classValue%>' >&nbsp;</td>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=reaction_date1_disply%></td>
			

			<% 
				temp.append(""+reaction_date1_disply+",");
				temp2.append(""+reaction_date1_disply+",");
    			

			 // innerhtml.append("<tr><td colspan='"+col_span+"' ><table cellpadding='0'  border='1' cellspacing='0' width='100%'><tr><td class='label' style='font-size:12' >"+reaction_date1_disply+"</td>");	
			  innerhtml.append("<tr><td class='label' style='font-size:12' >"+reaction_date1_disply+"</td>");	
			  innertext.append("<tr><td class='' style='font-size:12' >"+reaction_date1_disply+"</td>");//IN052716	
			if(adv_reac_code.equals("Oth")) 
			{
				 innerhtml.append("<td class='label' style='font-size:12' >"+others_reaction+"</td>");
				 innertext.append("<td class='' style='font-size:12' >"+others_reaction+"</td>");//IN052716
				temp.append(""+others_reaction+",");
				temp2.append(""+others_reaction+",");
				%>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=others_reaction%></td>
			<%} else { 
					 innerhtml.append("<td class='label' style='font-size:12' p>"+reac_desc+"</td>");
					 innertext.append("<td class='' style='font-size:12' p>"+reac_desc+"</td>");//IN052716
					 temp.append(""+reac_desc+",");
					 temp2.append(""+reac_desc+",");
				%>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=reac_desc%></td>
			<%}%>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=severity_two%></td>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=reaction_site%></td>
			
			
			</tr>
			<%
						
			//innerhtml.append("<td class='label' style='font-size:12'>"+severity_two+"</td><td class='label' style='font-size:12'>"+reaction_site+"</td></tr></table></td></tr>"); 	
			innerhtml.append("<td class='label' style='font-size:12'>"+severity_two+"</td><td class='label' style='font-size:12'>"+reaction_site+"</td></tr>"); 	
			innertext.append("<td class='' style='font-size:12'>"+severity_two+"</td><td class='' style='font-size:12'>"+reaction_site+"</td></tr>");//IN052716
			temp.append(""+severity_two+","+reaction_site+"");
			temp2.append(""+severity_two+","+reaction_site+"");
			
			}else{%>
			<tr id='third<%=m%>' Style="display:none;visibility:hidden" >
			<td  class='<%=classValue%>' nowrap ></td>
			<td  class='<%=classValue%>' nowrap ></td>
			<td colspan='<%=col_span%>' class='<%=classValue%>' >
			<table class='grid' width='100%' ><tr>
			<td class=<%=classValue%> width='25%' align=center nowrap><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></td>
			<td class=<%=classValue%> width='25%' align=center nowrap ><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></td>
			<td class=<%=classValue%> width='25%' align=center nowrap ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
			<td class=<%=classValue%> width='25%' align=center nowrap><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></td>
		</tr></table></td>
		</tr>
		<tr id='second<%=m%>' Style="display;visibility:visible" >
			<td class='<%=classValue%>'  >&nbsp;</td><td class='<%=classValue%>' >&nbsp;</td>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=reaction_date1_disply%></td>
			
			<% //innerhtml.append("<tr><td colspan='"+col_span+"'> <table cellpadding='0'  border='1' cellspacing='0' width='100%'><tr><td class='label' style='font-size:12' >"+reaction_date1_disply+"</td>"); 
			 innerhtml.append("<tr><td class='label'style='font-size:12'>"+reaction_date1_disply+"</td>"); 
			 innertext.append("<tr><td class=''style='font-size:12'>"+reaction_date1_disply+"</td>"); //IN052716
				   temp.append(""+reaction_date1_disply+",");
				   temp2.append(""+reaction_date1_disply+",");

			 if(adv_reac_code.equals("Oth")) 
			{
				 		  innerhtml.append("<td class='label' style='font-size:12' >"+others_reaction+"</td>");
				 		 innertext.append("<td class='' style='font-size:12' >"+others_reaction+"</td>");  //IN052716
						  temp.append(""+others_reaction+",");
						  temp2.append(""+others_reaction+",");
				 %>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=others_reaction%></td>
			<%} else { 
					 
					  innerhtml.append("<td class='label' style='font-size:12' p>"+reac_desc+"</td>");
					  innertext.append("<td class='' style='font-size:12' p>"+reac_desc+"</td>");//IN052716
					  temp.append(""+reac_desc+",");
					  temp2.append(""+reac_desc+",");%>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=reac_desc%></td>
			<%}%>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=severity_two%></td>
			<td  class='<%=classValue%>' width='25%' nowrap ><%=reaction_site%></td>
			
			
			</tr>
			<%
				
				//innerhtml.append("<td class='label' style='font-size:12'>"+severity_two+"</td><td class='label' style='font-size:12'>"+reaction_site+"</td></tr></table></td></tr>"); 
				innerhtml.append("<td class='label' style='font-size:12'>"+severity_two+"</td><td class='label' style='font-size:12'>"+reaction_site+"</td></tr>"); 
				innertext.append("<td class='' style='font-size:12'>"+severity_two+"</td><td class='' style='font-size:12'>"+reaction_site+"</td></tr>");//IN052716
				temp.append(""+severity_two+","+reaction_site+"");
				temp2.append(""+severity_two+","+reaction_site+"");
			}
				%>
					<!--<input type="hidden" name="adv_event_type<%=k%>" id="adv_event_type<%=k%>" value="<%=adv_event_type%>" >
					<input type="hidden" name="allergen<%=k%>" id="allergen<%=k%>" value="<%=allergen%>" >
					<input type="hidden" name="onset_date_disply<%=k%>" id="onset_date_disply<%=k%>" value="<%=onset_date_disply%>" >
					<input type="hidden" name="reaction_date1_disply<%=k%>" id="reaction_date1_disply<%=k%>" value="<%=reaction_date1_disply%>" >
					<input type="hidden" name="others_reaction<%=k%>" id="others_reaction<%=k%>" value="<%=others_reaction%>" >
					<input type="hidden" name="reac_desc<%=k%>" id="reac_desc<%=k%>" value="<%=reac_desc%>" >
					<input type="hidden" name="severity_two<%=k%>" id="severity_two<%=k%>" value="<%=severity_two%>" >
					<input type="hidden" name="reaction_site<%=k%>" id="reaction_site<%=k%>" value="<%=reaction_site%>" >-->
					<input type="hidden" name="status<%=l%>" id="status<%=l%>" value="<%=status%>" >
					<input type='hidden' name='ret_value<%=l%>' id='ret_value<%=l%>' value='<%=row_id%>'>
					<input type='hidden' name='row_value<%=l%>' id='row_value<%=l%>' value='<%=k%>'>
				<%	

				allergen1=rs.getString("allergen_code");
				reaction_date_prev =rs.getString("reaction_date");
				adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");
				
				adv_event_type_ind_code1 = rs.getString("adv_event_type_ind");
					onset_date1 = rs.getString("onset_date");
					onset_date_disply1=DateUtils.convertDate(onset_date1,"DMYHMS","en",locale);
					status1 = rs.getString("status");
					
					if(status1.equals("A")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
					}
					else if(status1.equals("R")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
					}else if(status1.equals("E")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
					}



				rowcolor ++;
				m++;
				 l++;
				temp.append("<br>");
				temp2.append("\n");
			    temp1=temp.toString();
			    temp3=temp2.toString();
				
					

				}
				else
				{
				
				
				if((!adv_event_type_code.equals(adv_event_type_code1) || !causative_code.equals(allergen1)|| !status.equals(status1)|| !adv_event_type_ind_code.equals(adv_event_type_ind_code1)|| !onset_date_disply.equals(onset_date_disply1)))
				{

					classValue = "gridData";
					/*if (classValue.equals("QRYODDSMALL"))
					{
					classValue = "QRYEVENSMALL";
					   //	k++;
					}else
					{
						classValue = "QRYODDSMALL";
						//k++; 
					}*/
				%>
			
			<tr id='first' >
			<td class="<%=classValue%>" ><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="ReassaignAlrg1(this);chkunchk(this)" value="<%=k%>"  checked  disabled>
				<%k++;%>

	        </td>	
			<td  class='<%=classValue1%>' nowrap id='detail<%=m%>'><a href='#'  onClick="display_records1('<%=m%>','<%=patient_id%>','<%=causative_code%>','<%=adv_event_type_ind_code%>','<%=adv_event_type_code%>','<%=reaction_date1%>','<%=status%>','<%=error_status%>','<%=onset_date_disply%>')">&nbsp;-&nbsp;</a>
			</td>
			<td  class='<%=classValue%>' nowrap ><%=adv_event_type%></td>
			<td   class='<%=classValue%>' nowrap id='header'>
			<%=allergen%>
			</td>
			<td  class='<%=classValue%>' nowrap ><%=onset_date_disply%>
			<%
					if(calculated_onset_date_yn.equals("Y"))
					{
			%>
						(<fmt:message key="eCA.Approx.label" bundle="${ca_labels}"/>)				
			<%
					}
			%>
			</td>
			  
		
			<%if(cnt_recurring.equals("0")){%>
			<td  class='<%=classValue%>' nowrap ><%=status%></td>
				<%}else {%>
				<td  class='<%=classValue%>' nowrap ><%=status%>(<%=cnt_recurring%>)<img src='../../eCommon/images/mandatory.gif' ></img></td>
				<%}%>
				</tr>

				<%		//temp.append("<br>");
					if(cnt!=0)
					{
							temp.append("<br>");
							temp2.append("\n");
					}
							temp.append(""+adv_event_type+","+allergen+","+onset_date_disply+","+status+"");
							temp2.append(""+adv_event_type+","+allergen+","+onset_date_disply+","+status+"");

							temp.append("<br>");
							temp2.append("\n");
							temp.append("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SiteOfReaction.label","mr_labels")+"</b>");
							temp2.append(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SiteOfReaction.label","mr_labels")+"");
							temp.append("<br>");
							temp2.append("\n");
					if(cnt!=0)
					{
							innerhtml.append("<tr><td class='label'>&nbsp;&nbsp;&nbsp;</td><td class='label' >&nbsp;&nbsp;&nbsp;</td><td class='label'>&nbsp;&nbsp;&nbsp;</td><td class='label'>&nbsp;&nbsp;&nbsp;</td></tr>"); 
							innertext.append("<tr><td class='label'>&nbsp;&nbsp;&nbsp;</td><td class='' >&nbsp;&nbsp;&nbsp;</td><td class=''>&nbsp;&nbsp;&nbsp;</td><td class=''>&nbsp;&nbsp;&nbsp;</td></tr>");//IN052716
					}
					cnt++;
							
						  innerhtml.append("<tr><td class='label' style='font-size:12' >"+adv_event_type+"</td><td class='label' style='font-size:12' >"+allergen+"</td><td class='label' style='font-size:12' p>"+onset_date_disply);
						  innertext.append("<tr><td class='' style='font-size:12' >"+adv_event_type+"</td><td class='' style='font-size:12' >"+allergen+"</td><td class='' style='font-size:12' p>"+onset_date_disply);//IN052716
						  if(calculated_onset_date_yn.equals("Y"))
						  {
							 innerhtml.append(" ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Approx.label","ca_labels")+")");				
							 innertext.append(" ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Approx.label","ca_labels")+")");//IN052716
						  }
						  innerhtml.append("</td><td class='label' style='font-size:12'>"+status+"</td></tr>");
						  innertext.append("</td><td class='' style='font-size:12'>"+status+"</td></tr>"); //IN052716
						  innerhtml.append("<tr><td class='label' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels")+"</b></td><td class='label' style='font-size:12' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels")+"</b></td><td class='label' style='font-size:12' p><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels")+"</b></td><td class='label' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SiteOfReaction.label","mr_labels")+"</b></td></tr>");
						  innertext.append("<tr><td class='' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels")+"</b></td><td class='' style='font-size:12' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels")+"</b></td><td class='' style='font-size:12' p><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels")+"</b></td><td class='' style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SiteOfReaction.label","mr_labels")+"</b></td></tr>");//IN052716
			%>
			<tr id='third<%=m%>' Style="display;visibility:visible">
			<td  class='<%=classValue%>' nowrap ></td>
			<td  class='<%=classValue%>' nowrap ></td>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></b></td>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></b></td>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></b></td>
			<td class=<%=classValue%>  nowrap><b><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></b></td>
		</tr>
			
			<tr id='second<%=m%>' Style="display;visibility:visible" >
			<td  class='<%=classValue%>' nowrap ></td>
			<td  class='<%=classValue%>' nowrap ></td>
			<td  class='<%=classValue%>' nowrap ><%=reaction_date1_disply%></td>
			

			<% 
				temp.append(""+reaction_date1_disply+",");
				temp2.append(""+reaction_date1_disply+",");
    			

			  innerhtml.append("<tr><td class='label' style='font-size:12' >"+reaction_date1_disply+"</td>");	
			  innertext.append("<tr><td class='' style='font-size:12' >"+reaction_date1_disply+"</td>"); //IN052716
			if(adv_reac_code.equals("Oth")) 
			{
				 innerhtml.append("<td class='label' style='font-size:12' >"+others_reaction+"</td>");
				 innertext.append("<td class='' style='font-size:12' >"+others_reaction+"</td>"); //IN052716
				temp.append(""+others_reaction+",");
				temp2.append(""+others_reaction+",");
				%>
			<td  class='<%=classValue%>' nowrap ><%=others_reaction%></td>
			<%} else { 
					 innerhtml.append("<td class='label' style='font-size:12' p>"+reac_desc+"</td>");
					 innertext.append("<td class='' style='font-size:12' p>"+reac_desc+"</td>"); //IN052716
					 temp.append(""+reac_desc+",");
					 temp2.append(""+reac_desc+",");
				%>
			<td  class='<%=classValue%>' nowrap ><%=reac_desc%></td>
			<%}%>
			<td  class='<%=classValue%>' nowrap ><%=severity_two%></td>
			<td  class='<%=classValue%>' nowrap ><%=reaction_site%></td>
			
			
			</tr>
			<%
			innerhtml.append("<td class='label' style='font-size:12'>"+severity_two+"</td><td class='label' style='font-size:12'>"+reaction_site+"</td></tr>"); 
			innertext.append("<td class='' style='font-size:12'>"+severity_two+"</td><td class='' style='font-size:12'>"+reaction_site+"</td></tr>"); //IN052716
			temp.append(""+severity_two+","+reaction_site+"");
			temp2.append(""+severity_two+","+reaction_site+"");
			
			}else{%>
			<tr id='third<%=m%>' Style="display:none;visibility:hidden" >
			<td  class='<%=classValue%>' nowrap ></td>
			<td  class='<%=classValue%>' nowrap ></td>
			<td class=<%=classValue%> align=center nowrap><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></td>
			<td class=<%=classValue%> align=center nowrap ><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></td>
			<td class=<%=classValue%> align=center nowrap ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
			<td class=<%=classValue%> align=center nowrap><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></td>
		</tr>
		<tr id='second<%=m%>' Style="display;visibility:visible" >
			<td  class='<%=classValue%>' nowrap ></td>
			<td  class='<%=classValue%>' nowrap ></td>
			<td  class='<%=classValue%>' nowrap ><%=reaction_date1_disply%></td>
			
			<% innerhtml.append("<tr><td class='label' style='font-size:12' >"+reaction_date1_disply+"</td>"); 
			innertext.append("<tr><td class='' style='font-size:12' >"+reaction_date1_disply+"</td>");  //IN052716
				   temp.append(""+reaction_date1_disply+",");
				   temp2.append(""+reaction_date1_disply+",");

			 if(adv_reac_code.equals("Oth")) 
			{
				 		  innerhtml.append("<td class='label' style='font-size:12' >"+others_reaction+"</td>");
				 		 innertext.append("<td class='' style='font-size:12' >"+others_reaction+"</td>"); //IN052716
						  temp.append(""+others_reaction+",");
						  temp2.append(""+others_reaction+",");
				 %>
			<td  class='<%=classValue%>' nowrap ><%=others_reaction%></td>
			<%} else { 
					 
					  innerhtml.append("<td class='label' style='font-size:12' p>"+reac_desc+"</td>");
					  innertext.append("<td class='' style='font-size:12' p>"+reac_desc+"</td>");//IN052716
					  temp.append(""+reac_desc+",");
					  temp2.append(""+reac_desc+",");%>
			<td  class='<%=classValue%>' nowrap ><%=reac_desc%></td>
			<%}%>
			<td  class='<%=classValue%>' nowrap ><%=severity_two%></td>
			<td  class='<%=classValue%>' nowrap ><%=reaction_site%></td>
			
			
			</tr>
			<%
				innerhtml.append("<td class='label' style='font-size:12'>"+severity_two+"</td><td class='label' style='font-size:12'>"+reaction_site+"</td></tr>"); 
				innertext.append("<td class='' style='font-size:12'>"+severity_two+"</td><td class='' style='font-size:12'>"+reaction_site+"</td></tr>"); //IN052716
				temp.append(""+severity_two+","+reaction_site+"");
				temp2.append(""+severity_two+","+reaction_site+"");
			}
				%>
					<!--<input type="hidden" name="adv_event_type<%=k%>" id="adv_event_type<%=k%>" value="<%=adv_event_type%>" >
					<input type="hidden" name="allergen<%=k%>" id="allergen<%=k%>" value="<%=allergen%>" >
					<input type="hidden" name="onset_date_disply<%=k%>" id="onset_date_disply<%=k%>" value="<%=onset_date_disply%>" >
					<input type="hidden" name="reaction_date1_disply<%=k%>" id="reaction_date1_disply<%=k%>" value="<%=reaction_date1_disply%>" >
					<input type="hidden" name="others_reaction<%=k%>" id="others_reaction<%=k%>" value="<%=others_reaction%>" >
					<input type="hidden" name="reac_desc<%=k%>" id="reac_desc<%=k%>" value="<%=reac_desc%>" >
					<input type="hidden" name="severity_two<%=k%>" id="severity_two<%=k%>" value="<%=severity_two%>" >
					<input type="hidden" name="reaction_site<%=k%>" id="reaction_site<%=k%>" value="<%=reaction_site%>" >-->
					<input type="hidden" name="status<%=l%>" id="status<%=l%>" value="<%=status%>" >
					 <input type='hidden' name='ret_value<%=l%>' id='ret_value<%=l%>' value='<%=row_id%>'>
					 <input type='hidden' name='row_value<%=l%>' id='row_value<%=l%>' value='<%=k%>'>
				<%	

				allergen1=rs.getString("allergen_code");
				reaction_date_prev =rs.getString("reaction_date");
				adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");
				adv_event_type_ind_code1 = rs.getString("adv_event_type_ind");
					onset_date1 = rs.getString("onset_date");
					onset_date_disply1=DateUtils.convertDate(onset_date1,"DMYHMS","en",locale);
					status1 = rs.getString("status");
					
					if(status1.equals("A")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
					}
					else if(status1.equals("R")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
					}else if(status1.equals("E")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
					}

				rowcolor ++;
				m++;
				 l++;
				temp.append("<br>");
				temp2.append("\n");
			    temp1=temp.toString();
			    temp3=temp2.toString();

					}
				
			}
				

			%></table>
					
			
			<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable'  width='auto' height='100%' class='grid'>
			<tr><td width='100%' id='t'></td></tr>
		</table>
	</div><%
		}


	%>

	<input type="hidden" name="detail" id="detail" value="" >
	<input type="hidden" name="rowcolor" id="rowcolor" value="<%=rowcolor%>" >
	<input type="hidden" name="cnt" id="cnt" value="" >
	<input type="hidden" name="flag1" id="flag1" VALUE="">

	<input type="hidden" name="PatientId" id="PatientId" value="<%=patient_id%>" >
  </form>
</body></div>
	 <%
     } catch(Exception e) {
			   e.printStackTrace();
		
         if (rs != null) rs.close();
         if (stmt1 != null) stmt1.close();
    } finally
	{
	    if (rs != null) rs.close();
		if (stmt1 != null) stmt1.close();
		if (con != null) con.close();

	}%>
 	
<input type="hidden" name="counter<%=k+j%>" id="counter<%=k+j%>" value="<%=k%>">
<input type="hidden" name="innerhtml" id="innerhtml" value="<%=innerhtml.toString()%>">
<input type="hidden" name="innerhtml_header" id="innerhtml_header" value="<%=innerhtml_header.toString()%>">
<input type="hidden" name="innertext" id="innertext" value="<%=innertext.toString()%>">  <!-- IN052716 -->
<input type="hidden" name="innertext_header" id="innertext_header" value="<%=innertext_header.toString()%>"> <!-- IN052716 -->
<input type="hidden" name="temp1" id="temp1" value="<%=temp1%>">
<input type="hidden" name="temp" id="temp" value="<%=temp3%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="from_date_time" id="from_date_time" value="<%=from_date_time%>">
<input type="hidden" name="to_date_time" id="to_date_time" value="<%=to_date_time%>">
<input type="hidden" name="status1" id="status1" value="<%=status1%>">
<input type="hidden" name="allergy_class" id="allergy_class" value="<%=allergy_class%>">
<input type="hidden" name="allergy_item" id="allergy_item" value="<%=allergy_item%>">
<input type="hidden" name="order_by1" id="order_by1" value="<%=order_by1%>">
<input type="hidden" name="order_by2" id="order_by2" value="<%=order_by2%>">
<input type="hidden" name="count" id="count" value="<%=j%>">
<input type="hidden" name="finalString" id="finalString" value="<%=temp4%>">
<input type="hidden" name="chkcount" id="chkcount" value="<%=k%>">
</table>
<script>setTimeout("aligntable('<%=m%>');",300);</script>
</form>
</body>
</script>
</html>

