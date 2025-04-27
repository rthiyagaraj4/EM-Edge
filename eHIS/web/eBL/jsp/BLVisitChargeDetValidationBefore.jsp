<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

  <%
	Connection con				= null;
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	try{	
	request.setCharacterEncoding("UTF-8");

	con	=	ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);

	String panel_str="";

	long encounter_id=0;
	int acc_seq_no=1;
	String strAccSeqNo="";

	String serv_panel_ind="";
	String serv_panel_code="";
	String service_date="";
	String call_after_reg="";

	String query_string="";

	query_string=request.getQueryString();

	HashMap pString = new HashMap();

	String episode_type=request.getParameter("episode_type");
	if(episode_type==null) episode_type="";
	String episode_id=request.getParameter("episode_id");
	if(episode_id==null) episode_id="";
	String patient_id=request.getParameter("patient_id");
	if(patient_id==null) patient_id="";
	String visit_id=request.getParameter("visit_id");
	if(visit_id==null) visit_id="";
	String calling_module_id=request.getParameter("calling_module_id");
	if(calling_module_id==null) calling_module_id="";
	String facility_id=(String)httpSession.getValue("facility_id");
	if(facility_id==null) facility_id="";

	call_after_reg=request.getParameter("call_after_reg");
	if(call_after_reg==null) call_after_reg="";
	
	String hsptl_chrg=request.getParameter("hsptl_chrg");
	if(hsptl_chrg==null) hsptl_chrg="";

	String prof_chrg=request.getParameter("prof_chrg");
	if(prof_chrg==null) prof_chrg="";

	String addl_chrg=request.getParameter("addl_chrg");
	if(addl_chrg==null) addl_chrg="";

	String hsptl_chrg_flag=request.getParameter("hsptl_chrg_flag");
	if(hsptl_chrg_flag==null) hsptl_chrg_flag="";

	String prof_chrg_flag=request.getParameter("prof_chrg_flag");
	if(prof_chrg_flag==null) prof_chrg_flag="";

	String addl_chrg_flag=request.getParameter("addl_chrg_flag");
	if(addl_chrg_flag==null) addl_chrg_flag="";

	String clinic_code=request.getParameter("clinic_code");
	if(clinic_code==null) clinic_code="";

	if(hsptl_chrg.equals("Y"))
	{
//		System.out.println("Inside hsptl_chrg");
		String hosp_panel_str_YN=(String)session.getAttribute("hosp_panel_str_YN");
		if(hosp_panel_str_YN==null || hosp_panel_str_YN.equals("")) hosp_panel_str_YN="";
		if(hosp_panel_str_YN.equals("Y"))
		{
			panel_str=(String)session.getAttribute("hosp_panel");
		}
		else
		{
			panel_str=(String)session.getAttribute("hosp_panel_str");
		}
		
		serv_panel_ind=request.getParameter("hosp_serv_panel_ind");
		serv_panel_code=request.getParameter("hosp_serv_panel_code");
	}
	else if(prof_chrg.equals("Y"))
	{
//		System.out.println("Inside prof_chrg");
		String prof_panel_str_YN=(String)session.getAttribute("prof_panel_str_YN");
		if(prof_panel_str_YN==null || prof_panel_str_YN.equals("")) prof_panel_str_YN="";
		if(prof_panel_str_YN.equals("Y"))
		{
			panel_str=(String)session.getAttribute("prof_panel");
		}
		else
		{
			panel_str=(String)session.getAttribute("prof_panel_str");
		}
		
		serv_panel_ind=request.getParameter("med_serv_panel_ind");
		serv_panel_code=request.getParameter("med_serv_panel_code");
	}
	else if(addl_chrg.equals("Y"))
	{
//		System.out.println("Inside addl_chrg");
		String addl_panel_str_YN=(String)session.getAttribute("addl_panel_str_YN");
//		System.out.println("addl_panel_str_YN:"+addl_panel_str_YN);
		if(addl_panel_str_YN==null || addl_panel_str_YN.equals("")) addl_panel_str_YN="";
		if(addl_panel_str_YN.equals("Y"))
		{
			panel_str=(String)session.getAttribute("addl_panel");
		}
		else
		{
			panel_str=(String)session.getAttribute("addl_panel_str");
		}
		
		serv_panel_ind=request.getParameter("addl_serv_panel_ind");
		serv_panel_code=request.getParameter("addl_serv_panel_code");
	}
	else
	{
//		System.out.println("Inside else");
		panel_str="";
	}

	pString.put("panel_str",panel_str); 

	pString.put("episode_type",episode_type);
	pString.put("episode_id",episode_id);
	pString.put("patient_id",patient_id);
	pString.put("visit_id",visit_id);
//	System.out.println("Panel String in Visit Validation:"+panel_str);
	session.setAttribute("BlChargeRecord",(HashMap)pString);

	if(call_after_reg.equals("Y"))
	{
		try
		{
			String acc_seq_no_sql="select cur_acct_seq_no from bl_visit_fin_dtls where OPERATING_FACILITY_ID=? AND EPISODE_TYPE =? AND EPISODE_ID=? AND VISIT_ID =? AND PATIENT_ID  =?";

			/* stmt = con.createStatement();
			rs = stmt.executeQuery(acc_seq_no_sql) ; */
			pstmt = con.prepareStatement(acc_seq_no_sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, episode_type);
			pstmt.setString(3, episode_id);
			pstmt.setString(4, visit_id);
			pstmt.setString(5, patient_id);
			rs = pstmt.executeQuery();
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					strAccSeqNo= rs.getString(1);
				}
			}

			if(rs != null) rs.close();
			pstmt.close();

			if(strAccSeqNo==null || strAccSeqNo.equals("")) strAccSeqNo="0";

//			System.out.println("strAccSeqNo:"+strAccSeqNo);
		}
		catch(Exception e)
		{
			System.out.println("Exception in Acc Seq No:"+e);
		}
					
		acc_seq_no=Integer.parseInt(strAccSeqNo);
//		System.out.println("acc_seq_no:"+acc_seq_no);
	}

	try
	{
		String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date) ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				service_date = rs.getString(1);
			}
		}
		if(rs != null) rs.close();
		stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception in Sys Date :"+e);
	}



%>


<html>
<head>


<script language='javascript'>

async function hsptl_chrg()
{
	var episode_type=document.forms[0].episode_type.value;
	var patient_id = document.forms[0].patient_id.value;
	var visit_id=document.forms[0].visit_id.value;
	var episode_id=document.forms[0].episode_id.value;
	var encounter_id=document.forms[0].encounter_id.value;
	var calling_module_id=document.forms[0].calling_module_id.value;
	var acc_seq_no=document.forms[0].acc_seq_no.value;

	var service_panel_ind=document.forms[0].serv_panel_ind.value;
	var service_panel_code=document.forms[0].serv_panel_code.value;

	var service_date=document.forms[0].service_date.value;
	var query_string=document.forms[0].query_string.value;

	var clinic_code=document.forms[0].clinic_code.value;

	var order_catalog_code="";

	var retArray = new Array();
	
	var include_label=encodeURIComponent(getLabel("Common.Include.label","common"));
	var exclude_label=encodeURIComponent(getLabel("Common.Exclude.label","common"));

	// Added for Edge work: to extend the parent before opening the dialog so that child dialog can extend to its full height and width
	var parentDialog = parent.parent.document.getElementById("dialog_tag");
	var originalHeight;
	var originalWidth;
	if (parentDialog != null) {
		originalHeight = parent.parent.document.getElementById("dialog_tag").style.height;
		originalWidth = parent.parent.document.getElementById("dialog_tag").style.width;
		//parentDialog.style.height = "80vh";
		//parentDialog.style.width = "100vh";
	}
	
	
	var dialogTop = "0vh";
	var dialogHeight = "80vh" ;
	var dialogWidth = "90vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&acct_seq_no="+acc_seq_no+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+service_date+"&order_catalog_code="+order_catalog_code+"&module_id="+calling_module_id+"&include_label="+include_label+"&exclude_label="+exclude_label+"&clinic_code="+clinic_code;

	
	retArray= await parent.window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
	
	// Added for Edge Work: After the child dialog is closed, restore the original dimensions of the parent dialog
	if (parentDialog != null) {
		parentDialog.style.height = originalHeight;
		parentDialog.style.width = originalWidth;
	}
	
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray!=null)
	{
		if(retArray[0]=="Y")
		{
			var total_payable=arr[1];
			var patient_payable=arr[2];
			var quantity=arr[4];
			var rate=arr[5];

//			alert("total_payable:"+total_payable);
//			alert("patient_payable:"+patient_payable);
//			alert("quantity:"+quantity);
//			alert("rate:"+rate);
			
			var url="../../eBL/jsp/BLVisitChargeDetValidationAfter.jsp?hsptl_chrg_flag=Y&total_payable="+total_payable+"&patient_payable="+patient_payable+"&quantity="+quantity+"&rate="+rate+"&"+query_string;
//			alert("url:"+url);
			parent.frames[1].location.href=url;
		}
	}

}

async function prof_chrg()
{
	var episode_type=document.forms[0].episode_type.value;
	var patient_id = document.forms[0].patient_id.value;
	var visit_id=document.forms[0].visit_id.value;
	var episode_id=document.forms[0].episode_id.value;
	var encounter_id=document.forms[0].encounter_id.value;
	var calling_module_id=document.forms[0].calling_module_id.value;
	var acc_seq_no=document.forms[0].acc_seq_no.value;
	
	var service_panel_ind=document.forms[0].serv_panel_ind.value;
	var service_panel_code=document.forms[0].serv_panel_code.value;

	var service_date=document.forms[0].service_date.value;

	var clinic_code=document.forms[0].clinic_code.value;
	var query_string=document.forms[0].query_string.value;

	var order_catalog_code="";

	var retArray = new Array();
				
	var include_label=encodeURIComponent(getLabel("Common.Include.label","common"));
	var exclude_label=encodeURIComponent(getLabel("Common.Exclude.label","common"));
	

	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&acct_seq_no="+acc_seq_no+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+service_date+"&order_catalog_code="+order_catalog_code+"&module_id="+calling_module_id+"&include_label="+include_label+"&exclude_label="+exclude_label+"&clinic_code="+clinic_code;

	retArray= await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray!=null)
	{
		if(arr[0]=="Y")
		{
			var total_payable=arr[1];
			var patient_payable=arr[2];
			var quantity=arr[4];
			var rate=arr[5];
//			alert("total_payable:"+total_payable);
//			alert("patient_payable:"+patient_payable);
//			alert("quantity:"+quantity);
//			alert("rate:"+rate);

			parent.frames[1].location.href="../../eBL/jsp/BLVisitChargeDetValidationAfter.jsp?prof_chrg_flag=Y&total_payable="+total_payable+"&patient_payable="+patient_payable+"&quantity="+quantity+"&rate="+rate+"&"+query_string;
		}
	}

}

async function addl_chrg()
{
	var episode_type=document.forms[0].episode_type.value;
	var patient_id = document.forms[0].patient_id.value;
	var visit_id=document.forms[0].visit_id.value;
	var episode_id=document.forms[0].episode_id.value;
	var encounter_id=document.forms[0].encounter_id.value;
	var calling_module_id=document.forms[0].calling_module_id.value;
	var acc_seq_no=document.forms[0].acc_seq_no.value;
	
	var service_panel_ind=document.forms[0].serv_panel_ind.value;
	var service_panel_code=document.forms[0].serv_panel_code.value;

	var service_date=document.forms[0].service_date.value;

	var clinic_code=document.forms[0].clinic_code.value;
	var query_string=document.forms[0].query_string.value;

	var order_catalog_code="";

	var retArray = new Array();
				
	var include_label=encodeURIComponent(getLabel("Common.Include.label","common"));
	var exclude_label=encodeURIComponent(getLabel("Common.Exclude.label","common"));
	

	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&encounter_id="+encounter_id+"&acct_seq_no="+acc_seq_no+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+service_date+"&order_catalog_code="+order_catalog_code+"&module_id="+calling_module_id+"&include_label="+include_label+"&exclude_label="+exclude_label+"&clinic_code="+clinic_code;

	retArray= await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray!=null)
	{
		if(retArray[0]=="Y")
		{
			var total_payable=arr[1];
			var patient_payable=arr[2];
			var quantity=arr[4];
			var rate=arr[5];
//			alert("total_payable:"+total_payable);
//			alert("patient_payable:"+patient_payable);
//			alert("quantity:"+quantity);
//			alert("rate:"+rate);

			parent.frames[1].location.href="../../eBL/jsp/BLVisitChargeDetValidationAfter.jsp?addl_chrg_flag=Y&total_payable="+total_payable+"&patient_payable="+patient_payable+"&quantity="+quantity+"&rate="+rate+"&"+query_string;
		}
	}

}

</script>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>			
			<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<%
	if(hsptl_chrg.equals("Y"))
	{
%>
<body onLoad='hsptl_chrg()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	}
	else if(prof_chrg.equals("Y"))
	{
%>
<body onLoad='prof_chrg()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	}
	else if(addl_chrg.equals("Y"))
	{
%>
<body onLoad='addl_chrg()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	}
	else
	{
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	}
%>
	
<form >
	<input type=hidden name='episode_id' id='episode_id' value='<%=episode_id%>'>	
	 <input type=hidden name='episode_type' id='episode_type' value='<%=episode_type%>'>	
	 <input type=hidden name='visit_id' id='visit_id' value='<%=visit_id%>'>	
	 <input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type=hidden name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
	<input type=hidden name='calling_module_id' id='calling_module_id' value='<%=calling_module_id%>'>
	<input type=hidden name='acc_seq_no' id='acc_seq_no' value='<%=acc_seq_no%>'>


	 <input type=hidden name='serv_panel_ind' id='serv_panel_ind' value='<%=serv_panel_ind%>'>
	 <input type=hidden name='serv_panel_code' id='serv_panel_code' value='<%=serv_panel_code%>'>

	<input type=hidden name='service_date' id='service_date' value='<%=service_date%>'>
	<input type=hidden name='hsptl_chrg' id='hsptl_chrg' value='<%=hsptl_chrg%>'>
	<input type=hidden name='prof_chrg' id='prof_chrg' value='<%=prof_chrg%>'>
	<input type=hidden name='addl_chrg' id='addl_chrg' value='<%=addl_chrg%>'>	

	<input type=hidden name='clinic_code' id='clinic_code' value='<%=clinic_code%>'>

	



	<input type=hidden name='query_string' id='query_string' value='<%=query_string%>'>
</form>
</body>

<%
	}
	catch(Exception e)
	{
	}
	finally
	{
		ConnectionManager.returnConnection(con, request);
	}
%>
<script>

</script>
</html>

