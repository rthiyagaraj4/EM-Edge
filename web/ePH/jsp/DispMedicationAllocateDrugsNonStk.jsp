<!DOCTYPE html>

  
<%-- JSP Page specific attributes start --%>
	<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
	<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%


	    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		

        String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</HEAD>
<%
	
	String bean_id				= "DispMedicationAllStages" ;
	String bean_name			= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
	//bean.setLanguageId(locale);

	String	bean_id_1			=	"DispMedicationBean" ;
	String	bean_name_1			=	"ePH.DispMedicationBean";
	DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject(bean_id_1, bean_name_1,request);	
	//bean_1.setLanguageId(locale);

	String class_name			=	"";
	String drug_code			=	request.getParameter("drug_code");
	String patient_id			=	request.getParameter("patient_id");
	String order_id				=	request.getParameter("order_id");
	String order_line_no		=	request.getParameter("order_line_no");
	String drug_color			=	request.getParameter("drug_color");
	String alt_drug_code		=	request.getParameter("alt_drug_code");
	String qty					=	request.getParameter("qty");
	String uom					=	request.getParameter("qty_uom");
	String source				=	request.getParameter("source");
	String batch_id				=	"";
	String expiry_date			=	"";
	String issue_qty			=	"";
	String qty_uom				=	"";
	String item_drug_code		=	"";
	String read_only_status		=	"";
	String txt_status			=	"";	
	int	    totalRecords		=	25;	
	boolean firstTime			=	true;
	if(drug_color==null)
		drug_color				=	"";
	if(alt_drug_code==null)
		alt_drug_code			=	"";

	ArrayList	delivery_det	=	bean_1.getDeliveryDetails();

	if(delivery_det!=null && delivery_det.size() > 1) {
		txt_status			=	"disabled";
	}

	
	ArrayList	drug_detail			=	new ArrayList();
	ArrayList	all_drug_detail		=	new ArrayList();
	String		sys_date			=	bean.getCurrDate();

if(alt_drug_code.equals(""))	{
	drug_detail		=	bean.getDrugDetail(patient_id,order_id,order_line_no);	
	item_drug_code	=	drug_code;
}
else	{
	drug_detail		=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
	all_drug_detail	=	bean.getAllAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
	item_drug_code	=	alt_drug_code;
}
String tmp_drug_code		=	item_drug_code;
String tmp_drug_color		=	drug_color;
String item_drug_color		=	drug_color;
String module_id			=	"1";

%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="DispMedicationAllocateDrugsWithoutStock" id="DispMedicationAllocateDrugsWithoutStock">

<% if(module_id.equals("1")) { %>

<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<%	
	int no		=	0;
	int p		=	0;
	int q		=	0;

	for(int i=0; i<totalRecords; i++)	{

				batch_id			=	"";
				expiry_date			=	"";
				issue_qty			=	"";
				qty_uom				=	"";
				item_drug_code		=	tmp_drug_code;
				item_drug_color		=	tmp_drug_color;
				drug_color			=	item_drug_color;
				read_only_status	=	"";

			if(no < (drug_detail.size()-1))	{
				item_drug_code	=	(String)drug_detail.get(no);	
				batch_id		=	(String)drug_detail.get(++no);	
				expiry_date		=	(String)drug_detail.get(++no);	
				issue_qty		=	(String)drug_detail.get(++no);	
				qty_uom			=	(String)drug_detail.get(++no);	
				drug_color		=	(String)drug_detail.get(++no);	
				++no;
			}
			else if(p < all_drug_detail.size())	{
				ArrayList alt_drug_det	=	(ArrayList)all_drug_detail.get(p);
				if( q < (alt_drug_det.size()-1))	{
				item_drug_code		=	(String)alt_drug_det.get(q);	
				batch_id			=	(String)alt_drug_det.get(++q);	
				expiry_date			=	(String)alt_drug_det.get(++q);	
				issue_qty			=	(String)alt_drug_det.get(++q);	
				qty_uom				=	(String)alt_drug_det.get(++q);	
				drug_color			=	(String)alt_drug_det.get(++q);	
				read_only_status	=	"readOnly";
				++q;
				}
				else	{
				q	=	0;
				++p;
				continue;
				}
			}
		if(i%2==0)
			class_name	=	"QRYEVEN";
		else
			class_name	=	"QRYODD";		
			
	%>
	<tr>
	<td  width="24%" class="<%=class_name%>"><input type="hidden" name="item_drug_code<%=i%>" id="item_drug_code<%=i%>" value="<%=item_drug_code%>"><input type="hidden" name="item_drug_color<%=i%>" id="item_drug_color<%=i%>" value="<%=item_drug_color%>"><input type="text" class="flat" value="<%=batch_id%>" name="batch_id<%=i%>" size="10" maxlength="10" <%=txt_status%> <%=read_only_status%> style="color:<%=drug_color%>"
	onChange=""	onBlur="checkDuplicate(document.DispMedicationAllocateDrugsWithoutStock,this)">	</td>
	<td  width="24%" class="<%=class_name%>"><input type="text" class="flat" value="<%=expiry_date%>" name="expiry_date<%=i%>" size="10" maxlength="10" style="color:<%=drug_color%>" <%=txt_status%> <%=read_only_status%> onBlur="CompareDate(this);" onChange=""></td>
	<td  width="16%" class="<%=class_name%>"><input type="text" class="flat" value="<%=issue_qty%>" name="issue_qty<%=i%>" size="6" style="color:<%=drug_color%>;text-align:right" <%=txt_status%> <%=read_only_status%> onKeyPress="return allowValidNumber(this,event,6,0);" onBlur="allowNumber(this);defaultUOM(this,'<%=i%>');validateQty(this);" maxlength="5" onChange=""></td>

	<td  width="20%" class="<%=class_name%>">
	<% if(qty_uom.equals("") && firstTime==true) { 
		qty_uom		=	uom;
		firstTime	=	false;
	%>
		<input type="text" class="flat" size="8" value="<%=qty_uom%>" name="qty_uom<%=i%>" readOnly>
	<%	}	else	{	%>
		<input type="text" class="flat" size="8" value="<%=qty_uom%>" name="qty_uom<%=i%>" readOnly>
	<%	}	%>
	</td>
		<td width="15%" class="<%=class_name%>" ><input type="checkbox" name="select<%=i%>" id="select<%=i%>"></td>
	</tr>
<%	
	
	}	%>
	</table>

<%	}	%>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>"> 
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>"> 
<input type="hidden" name="alt_drug_code" id="alt_drug_code" value="<%=alt_drug_code%>"> 
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"> 
<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>"> 
<input type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>">
<input type="hidden" name="uom" id="uom" value="<%=uom%>">
<input type="hidden" name="qty" id="qty" value="<%=qty%>">
<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
<input type="hidden" name="source" id="source" value="<%=source%>">
</form>
</body>
<script>
setFocus(document.DispMedicationAllocateDrugsWithoutStock);
</script>
</html>
<%
//putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id_1,bean_1,request);
%>

