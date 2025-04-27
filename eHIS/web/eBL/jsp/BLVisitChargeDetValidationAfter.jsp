<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con				= null;
	
	try
	{	
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);

		String query_string=request.getQueryString();
//		System.out.println(query_string);


		String panel_str="";
		String upd_hosp_chrg_amt="";
		String upd_hosp_chrg_pat_amt="";
		String upd_med_chrg_amt="";
		String upd_med_chrg_pat_amt="";
		String upd_addl_chrg_amt="";
		String upd_addl_chrg_pat_amt="";


		double hosp_chrg_amt=0.0;
		double med_chrg_amt=0.0;
		double addl_chrg_amt=0.0;
//		String hosp_chrg_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.HOSP_CHRG.label","bl_labels");
//		String prof_chrg_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PROF_CHRG.label","bl_labels");
		HashMap pString=new HashMap();
		HashMap hosp_dtls=new HashMap();
		HashMap prof_dtls=new HashMap();
		HashMap addl_dtls=new HashMap();

		String episode_type=request.getParameter("episode_type");
		if(episode_type==null) episode_type="";
		String episode_id=request.getParameter("episode_id");
		if(episode_id==null) episode_id="";
		String patient_id=request.getParameter("patient_id");
		if(patient_id==null) patient_id="";
		String visit_id=request.getParameter("visit_id");
		if(visit_id==null) visit_id="";
		

		String hosp_serv_panel_ind=request.getParameter("hosp_serv_panel_ind");
		if(hosp_serv_panel_ind==null) hosp_serv_panel_ind="";

		String hosp_serv_panel_code=request.getParameter("hosp_serv_panel_code");
		if(hosp_serv_panel_code==null) hosp_serv_panel_code="";

		String hosp_serv_panel_str=(String)session.getAttribute("hosp_panel_str");
		if(hosp_serv_panel_str==null) hosp_serv_panel_str="";

		String hosp_serv_panel_qty=request.getParameter("hosp_serv_panel_qty");
		if(hosp_serv_panel_qty==null) hosp_serv_panel_qty="";

/*
		String hosp_serv_chrg_amt=request.getParameter("hosp_serv_chrg_amt");
		if(hosp_serv_chrg_amt==null) hosp_serv_chrg_amt="";
*/

		String prof_serv_panel_ind=request.getParameter("med_serv_panel_ind");
		if(prof_serv_panel_ind==null) prof_serv_panel_ind="";

		String prof_serv_panel_code=request.getParameter("med_serv_panel_code");
		if(prof_serv_panel_code==null) prof_serv_panel_code="";

		String prof_serv_panel_str=(String)session.getAttribute("prof_panel_str");
		if(prof_serv_panel_str==null) prof_serv_panel_str="";

		String prof_serv_panel_qty=request.getParameter("med_serv_panel_qty");
		if(prof_serv_panel_qty==null) prof_serv_panel_qty="";

/*
		String prof_serv_chrg_amt=request.getParameter("med_serv_chrg_amt");
		if(prof_serv_chrg_amt==null) prof_serv_chrg_amt="";
*/		

		String addl_serv_panel_ind=request.getParameter("addl_serv_panel_ind");
		if(addl_serv_panel_ind==null) addl_serv_panel_ind="";

		String addl_serv_panel_code=request.getParameter("addl_serv_panel_code");
		if(addl_serv_panel_code==null) addl_serv_panel_code="";

		String addl_serv_panel_str=(String)session.getAttribute("addl_panel_str");
		if(addl_serv_panel_str==null) addl_serv_panel_str="";

		String addl_serv_panel_qty=request.getParameter("addl_serv_panel_qty");
		if(addl_serv_panel_qty==null) addl_serv_panel_qty="";

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

		String visit_charge=request.getParameter("visitcharge");
		if(visit_charge==null) visit_charge="";

		String total_payable=request.getParameter("total_payable");
		if(total_payable==null) total_payable="";

		String patient_payable=request.getParameter("patient_payable");
		if(patient_payable==null) patient_payable="";

		String quantity=request.getParameter("quantity");
		if(quantity==null || quantity.equals("")) quantity="1.0";

		String rate=request.getParameter("rate");
		if(rate==null || rate.equals("")) rate="0.0";

//		System.out.println("total_payable:"+total_payable);
//		System.out.println("patient_payable:"+patient_payable);
//		System.out.println("quantity:"+quantity);
//		System.out.println("rate:"+rate);

		String str_hosp_chrg_amt=request.getParameter("str_hosp_chrg_amt");
		if(str_hosp_chrg_amt==null) str_hosp_chrg_amt="";
		else hosp_chrg_amt=Double.parseDouble(str_hosp_chrg_amt);

		String str_hosp_chrg_pat_amt = request.getParameter("str_hosp_chrg_pat_amt");
		if(str_hosp_chrg_pat_amt==null) str_hosp_chrg_pat_amt="";

		String str_med_chrg_amt=request.getParameter("str_med_chrg_amt");
		if(str_med_chrg_amt==null) str_med_chrg_amt="";
		else med_chrg_amt=Double.parseDouble(str_med_chrg_amt);

		String str_med_chrg_pat_amt = request.getParameter("str_med_chrg_pat_amt");
		if(str_med_chrg_pat_amt==null) str_med_chrg_pat_amt="";

		String str_addl_chrg_amt=request.getParameter("str_addl_chrg_amt");
		if(str_addl_chrg_amt==null) str_addl_chrg_amt="";
		else addl_chrg_amt=Double.parseDouble(str_addl_chrg_amt);

		String str_addl_chrg_pat_amt = request.getParameter("str_addl_chrg_pat_amt");
		if(str_addl_chrg_pat_amt==null) str_addl_chrg_pat_amt="";

//		System.out.println("str_hosp_chrg_amt:"+str_hosp_chrg_amt);
//		System.out.println("str_hosp_chrg_pat_amt:"+str_hosp_chrg_pat_amt);
//		System.out.println("str_med_chrg_amt:"+str_med_chrg_amt);
//		System.out.println("str_med_chrg_pat_amt:"+str_med_chrg_pat_amt);
//		System.out.println("str_addl_chrg_amt:"+str_addl_chrg_amt);
//		System.out.println("str_addl_chrg_pat_amt:"+str_addl_chrg_pat_amt);

		if(hsptl_chrg.equals("Y"))
		{
			if(hsptl_chrg_flag.equals("Y"))
			{
				upd_hosp_chrg_amt=total_payable;
				upd_hosp_chrg_pat_amt=patient_payable;

				upd_med_chrg_amt=str_med_chrg_amt;
				upd_med_chrg_pat_amt=str_med_chrg_pat_amt;

				upd_addl_chrg_amt=str_addl_chrg_amt;
				upd_addl_chrg_pat_amt=str_addl_chrg_pat_amt;

				session.setAttribute("upd_hosp_chrg_amt",upd_hosp_chrg_amt);
				session.setAttribute("upd_hosp_chrg_pat_amt",upd_hosp_chrg_pat_amt);
			}
		}
		else if(prof_chrg.equals("Y"))
		{
			if(prof_chrg_flag.equals("Y"))
			{
				upd_med_chrg_amt=total_payable;
				upd_med_chrg_pat_amt=patient_payable;

				upd_hosp_chrg_amt=str_hosp_chrg_amt;
				upd_hosp_chrg_pat_amt=str_hosp_chrg_pat_amt;

				upd_addl_chrg_amt=str_addl_chrg_amt;
				upd_addl_chrg_pat_amt=str_addl_chrg_pat_amt;

				session.setAttribute("upd_med_chrg_amt",upd_med_chrg_amt);
				session.setAttribute("upd_med_chrg_pat_amt",upd_med_chrg_pat_amt);
			}
		}
		else if(addl_chrg.equals("Y"))
		{
			if(addl_chrg_flag.equals("Y"))
			{
				upd_hosp_chrg_amt=str_hosp_chrg_amt;
				upd_hosp_chrg_pat_amt=str_hosp_chrg_pat_amt;

				upd_med_chrg_amt=str_med_chrg_amt;
				upd_med_chrg_pat_amt=str_med_chrg_pat_amt;

				upd_addl_chrg_amt=total_payable;
				upd_addl_chrg_pat_amt=patient_payable;

				session.setAttribute("upd_addl_chrg_amt",upd_addl_chrg_amt);
				session.setAttribute("upd_addl_chrg_pat_amt",upd_addl_chrg_pat_amt);
			}
		}

		if(hsptl_chrg.equals("Y"))
		{
			if(hsptl_chrg_flag.equals("Y"))
			{
				HashMap hm_string=(HashMap)session.getAttribute("BlChargeRecord");
				String p_string1 =((String)hm_string.get("panel_str")).trim();
				panel_str=p_string1;
				session.setAttribute("hosp_panel",panel_str);
				session.setAttribute("hosp_panel_str_YN","Y");

				hosp_dtls.put("hosp_serv_panel_ind",hosp_serv_panel_ind);
				hosp_dtls.put("hosp_serv_panel_code",hosp_serv_panel_code);
				hosp_dtls.put("hosp_serv_panel_str",panel_str);
				hosp_dtls.put("hosp_serv_panel_qty",quantity);
				hosp_dtls.put("hosp_serv_chrg_amt",rate);
				session.setAttribute("hosp_dtls",hosp_dtls);
//				System.out.println("hosp_dtls Updated in Validation1:"+session.getAttribute("hosp_dtls"));

			}
		}
		else if(prof_chrg.equals("Y"))
		{
			if(prof_chrg_flag.equals("Y"))
			{
				HashMap hm_string=(HashMap)session.getAttribute("BlChargeRecord");
				String p_string1 =((String)hm_string.get("panel_str")).trim();
				panel_str=p_string1;
				session.setAttribute("prof_panel",panel_str);
				session.setAttribute("prof_panel_str_YN","Y");

				prof_dtls.put("prof_serv_panel_ind",prof_serv_panel_ind);
				prof_dtls.put("prof_serv_panel_code",prof_serv_panel_code);
				prof_dtls.put("prof_serv_panel_str",panel_str);
				prof_dtls.put("prof_serv_panel_qty",quantity);
				prof_dtls.put("prof_serv_chrg_amt",rate);
				session.setAttribute("prof_dtls",prof_dtls);
//				System.out.println("prof_dtls Updated in Validation1:"+session.getAttribute("prof_dtls"));
			}
		}
		else if(addl_chrg.equals("Y"))
		{
			if(addl_chrg_flag.equals("Y"))
			{
				HashMap hm_string=(HashMap)session.getAttribute("BlChargeRecord");
				String p_string1 =((String)hm_string.get("panel_str")).trim();
				panel_str=p_string1;
				session.setAttribute("addl_panel",panel_str);
				session.setAttribute("addl_panel_str_YN","Y");

				addl_dtls.put("addl_serv_panel_ind",addl_serv_panel_ind);
				addl_dtls.put("addl_serv_panel_code",addl_serv_panel_code);
				addl_dtls.put("addl_serv_panel_str",panel_str);
				addl_dtls.put("addl_serv_panel_qty",quantity);
				addl_dtls.put("addl_serv_chrg_amt",rate);
				session.setAttribute("addl_dtls",addl_dtls);
//				System.out.println("addl_dtls Updated in Validation1:"+session.getAttribute("addl_dtls"));
			}
		}
		else
		{
			panel_str="";
		}

		pString.put("panel_str",panel_str); 

		pString.put("episode_type",episode_type);
		pString.put("episode_id",episode_id);
		pString.put("patient_id",patient_id);
		pString.put("visit_id",visit_id);	
//		System.out.println("Pstring in Validation 1:"+pString.get("panel_str"));
		session.setAttribute("BlChargeRecord",(HashMap)pString);

%>
<html>
<head>
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

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form >	
<input type='hidden' name="query_string" id="query_string" value="<%=query_string%>">
<input type='hidden' name="upd_hosp_chrg_amt" id="upd_hosp_chrg_amt" value="<%=upd_hosp_chrg_amt%>">
<input type='hidden' name="upd_hosp_chrg_pat_amt" id="upd_hosp_chrg_pat_amt" value="<%=upd_hosp_chrg_pat_amt%>">
<input type='hidden' name="upd_med_chrg_amt" id="upd_med_chrg_amt" value="<%=upd_med_chrg_amt%>">
<input type='hidden' name="upd_med_chrg_pat_amt" id="upd_med_chrg_pat_amt" value="<%=upd_med_chrg_pat_amt%>">
<input type='hidden' name="upd_addl_chrg_amt" id="upd_addl_chrg_amt" value="<%=upd_addl_chrg_amt%>">
<input type='hidden' name="upd_addl_chrg_pat_amt" id="upd_addl_chrg_pat_amt" value="<%=upd_addl_chrg_pat_amt%>">

</form>
</body>
<%
	}
	catch(Exception e)
	{
		System.out.println("Main Exception:"+e);
	}
	finally
	{ 
		ConnectionManager.returnConnection(con, request);
	}
%>
<script>
var query_string=document.forms[0].query_string.value;
var upd_hosp_chrg_amt=document.forms[0].upd_hosp_chrg_amt.value;
var upd_hosp_chrg_pat_amt=document.forms[0].upd_hosp_chrg_pat_amt.value;
var upd_med_chrg_amt=document.forms[0].upd_med_chrg_amt.value;
var upd_med_chrg_pat_amt=document.forms[0].upd_med_chrg_pat_amt.value;
var upd_addl_chrg_amt=document.forms[0].upd_addl_chrg_amt.value;
var upd_addl_chrg_pat_amt=document.forms[0].upd_addl_chrg_pat_amt.value;

parent.frames[0].location.href="../../eBL/jsp/BLVisitChargeDet.jsp?upd_hosp_chrg_amt="+upd_hosp_chrg_amt+"&upd_hosp_chrg_pat_amt="+upd_hosp_chrg_pat_amt+"&upd_med_chrg_amt="+upd_med_chrg_amt+"&upd_med_chrg_pat_amt="+upd_med_chrg_pat_amt+"&upd_addl_chrg_amt="+upd_addl_chrg_amt+"&upd_addl_chrg_pat_amt="+upd_addl_chrg_pat_amt+"&"+query_string;

</script>
</html>

