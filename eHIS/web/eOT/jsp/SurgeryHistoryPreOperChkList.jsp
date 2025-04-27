<!DOCTYPE html>
<%
//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.*" 
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.Common.*,webbeans.eCommon.*,java.sql.Types,java.sql.Connection,java.sql.ResultSet,java.sql.*, java.sql.CallableStatement" %>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.util.HashMap,webbeans.eCommon.ConnectionManager,java.net.URLDecoder,eCommon.Common.CommonBean,java.util.ArrayList,eOT.*,eOT.Common.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%-- JSP Page specific attributes end --%>
<html>
<head>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="JavaScript" src="../../eOT/js/SurgeryHistory.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
<script language="JavaScript">
	function callVerifyCheckList(checklists){
		var formObj = document.forms[0]; 
		var tab_id = formObj.tab_id.value;
		if(tab_id=="pre_oper_checklist_tab"){
			var pre_or_post="P";
		//Modified By DhanasekarV against IN024357 on date 18/10/2010
		//	var checklist_stage = "C20";
		
		var checklist_stage = "C40";
		}
		//Maheshwaran K added for the CHL-CRF-0043 [IN:035927] as on 22/02/2013
		//Start
		else if(tab_id=="intra_oper_checklist_tab"){
		if((formObj.role_id_3.value=="null")&&(formObj.no_of_verifications.value<=2))
			{
			alert(getMessage("APP-OT0210","OT"));
			return false;
			}
		else
			{
			var pre_or_post="I";
			var checklist_stage = "C40";
			}
		}
		//End
		else{
			var pre_or_post="O";
	//Modified By DhanasekarV against on date 22/11/2010  IN025161  
		var checklist_stage = "C60";
		
		}
		var order_id = formObj.order_id.value;
		var checklist_arr = checklists.split("##");
		var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
		var count=1;
		for(i=1;i<checklist_arr.length;i++){
		   count++;
		   //verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];
		   verify_checklist_codes=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i]; //Modified Against AAKH-SCF-0478
		}
		var booking_or_oper_flag = "B";
		if(order_id!=null && order_id!="null" && order_id!="")
		booking_or_oper_flag = "ORD";
		disable_checklist_fields = "disabled"
		access="NNNNY";
		var booking_num = formObj.booking_no.value;
		if(booking_num!=null && booking_num!="null" && booking_num!="" && booking_num!="NULL"){
		order_id = "";
		}else if(order_id!=null && order_id!="null" && order_id!="" && order_id!="NULL"){
			booking_num = "";
		}
		slate_user_id = (formObj.login_user_id.value).toUpperCase();
		var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
		//var verifyCheckList_value=getLabel("eOT.VerifyCheckList.Label","OT");
		var function_string = "&function_id=OT_CHECK_LIST&function_name=Verify Checklist";
		var db_param = db_param_1 + function_string;
		var url_desc = "VerifyCheckListMain.jsp";
		var url = url_desc+"?"+db_param+"&patient_id="+formObj.patient_id.value+"&slate_user_id="+slate_user_id+verify_checklist_codes+"&checklist_codes_count="+count+"&checklist_stage="+checklist_stage+"&pre_or_post="+pre_or_post+"&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+formObj.no_of_verifications.value+"&user_id="+slate_user_id+"&role_id_1="+formObj.role_id_1.value+"&role_id_2="+formObj.role_id_2.value+"&role_id_3="+formObj.role_id_3.value+"&role_id_4="+formObj.role_id_4.value+"&order_id="+order_id+"&booking_num="+booking_num+"&oper_num="+formObj.oper_num.value+"&disable_checklist_fields="+disable_checklist_fields+"&query_flag_yn=Y&called_from="+formObj.called_from.value;
		document.location.href=url;
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<Script src="../../eXH/js/showModalDialog.js" language="JavaScript"></Script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SurgeryHistoryPreOperChkListForm" id="SurgeryHistoryPreOperChkListForm">
<%
	

	String booking_num = CommonBean.checkForNull(request.getParameter("booking_num"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String login_user = CommonBean.checkForNull(request.getParameter("login_user"));
	String sta = CommonBean.checkForNull(request.getParameter("status"));
	int status =(sta.intern()!="")?Integer.parseInt(sta):Integer.parseInt("40");
	String speciality_code = CommonBean.checkForNull(request.getParameter("speciality_code"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String order_id = CommonBean.checkForNull(request.getParameter("order_id"));
	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	String tab_id = CommonBean.checkForNull(request.getParameter("parent_tab_id"));
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	String verify_checklist_codes="";
	String no_of_verifications = "";	
	String role_id_1="";
	String role_id_2="";
	String role_id_3="";
	String role_id_4="";
	Connection con = null;
	CallableStatement cstmt = null;
	//Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
	Statement stmt= null;
	ResultSet rset=null;
	//This Bean is used to get only the PostOperative Checklist code
	String bean_id1 = "ChkInOutRecoveryBean";
	String bean_name1 = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean1 = (ChkInOutRecoveryBean) mh.getBeanObject( bean_id1, request, bean_name1 );
	ArrayList verify_checklist_arr1 = new ArrayList();
	String verify_checklist_codes1="";
	//End
	try{	
		 con = ConnectionManager.getConnection(request);
		 cstmt=con.prepareCall("{call OT_OPER_CHECKLISTS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,?)}");
		 cstmt.setString(1,facility_id);
		 //Maheshwaran K added "intra_oper_checklist_tab" condition for the CHL-CRF-0043 [IN:035927] as on 27/02/2013
		 if(( tab_id.equals("pre_oper_checklist_tab") )||( tab_id.equals("intra_oper_checklist_tab") )){
			 cstmt.setString(2,"P");// V_PRE_OR_POST ="Pre" for checkin,checkoutfromward & holdingarea
		 }else
			cstmt.setString(2,"S");
		 //after documentation completed checklist is not popultated we are passing only oper_num 
		//cstmt.setString(3,order_id); after documentation completed checklist is not popultated 
		//cstmt.setString(4,booking_num);
		cstmt.setString(3,"");
		if(status<=35){
			cstmt.setString(4,booking_num);
			cstmt.setString(5,"");
		}else{
			cstmt.setString(4,"");
			cstmt.setString(5,oper_num);
		}
		 cstmt.setString(6,speciality_code);
		 cstmt.registerOutParameter(7,Types.VARCHAR); // concatenated Checklist String
		 cstmt.registerOutParameter(8,Types.VARCHAR); // V_NO_OF_VERIFICATIONS
		 cstmt.registerOutParameter(9,Types.VARCHAR); // role_1
		 cstmt.registerOutParameter(10,Types.VARCHAR); // role_2
		 cstmt.registerOutParameter(11,Types.VARCHAR); // role_3
		 cstmt.registerOutParameter(12,Types.VARCHAR); // role_4
		 cstmt.registerOutParameter(13,Types.VARCHAR); //STATUS
		 cstmt.registerOutParameter(14,Types.VARCHAR); // Error text
		 cstmt.registerOutParameter(15,Types.VARCHAR); // lANGUAGE ERROR TEXT
		 cstmt.execute();
		 verify_checklist_codes= cstmt.getString(7); 
		 no_of_verifications = cstmt.getString(8); 
		 role_id_1=cstmt.getString(9); 
		 role_id_2=cstmt.getString(10);
		 role_id_3=cstmt.getString(11);
		 role_id_4=cstmt.getString(12);
		 //Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
		 //Start
		 if(tab_id.equals("intra_oper_checklist_tab"))
			{
			//Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
			//Start
			verify_checklist_arr1 = bean1.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
			if(verify_checklist_arr1.size()>0){
			verify_checklist_codes1=(String)verify_checklist_arr1.get(0); 
			}
			else{
			verify_checklist_codes1="";
			}
			verify_checklist_codes=verify_checklist_codes+"##"+verify_checklist_codes1;
			//End
			}
		//End	
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err Msg in SurgeryHistoryPreOperChkList.jsp"+e.getMessage());
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}
%>
<input type='hidden' name="login_user_id" id="login_user_id" value="<%=login_user%>">
<input type='hidden' name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type='hidden' name="booking_no" id="booking_no" value="<%=booking_num%>">
<input type='hidden' name="order_id" id="order_id" value="<%=order_id%>">
<input type='hidden' name="no_of_verifications" id="no_of_verifications" value="<%=no_of_verifications%>">
<input type='hidden' name="role_id_1" id="role_id_1" value="<%=role_id_1%>">
<input type='hidden' name="role_id_2" id="role_id_2" value="<%=role_id_2%>">
<input type='hidden' name="role_id_3" id="role_id_3" value="<%=role_id_3%>">
<input type='hidden' name="role_id_4" id="role_id_4" value="<%=role_id_4%>">
<input type='hidden' name="tab_id" id="tab_id" value="<%=tab_id%>">
<input type='hidden' name="called_from" id="called_from" value="<%=called_from%>">
<input type='hidden' name="oper_num" id="oper_num" value="<%=oper_num%>">

<% out.println("<script>callVerifyCheckList('"+verify_checklist_codes+"')</script>"); %>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

 </form>
 </html>

 


