<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

try
{
    
    String clinic_code= request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
    String oper_stn_id= request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
   
    String gen_file_yn = request.getParameter("gen_file_yn")==null?"":request.getParameter("gen_file_yn");
    String oa_install_yn = request.getParameter("oa_install_yn")==null?"":request.getParameter("oa_install_yn");
	String or_install_yn = request.getParameter("or_install_yn")==null?"":request.getParameter("or_install_yn");
	String query_string = request.getParameter("query_string")==null?"":request.getParameter("query_string");
	
	String build_episode_rule =request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
    String errorMsg = request.getParameter("error")==null?"":request.getParameter("error");
	String register_visit_walkin = request.getParameter("register_visit_walkin")==null?"":request.getParameter("register_visit_walkin"); 
	String register_pat_yn= request.getParameter("register_pat_yn")==null?"":request.getParameter("register_pat_yn");  
	String register_visit_referral = request.getParameter("register_visit_referral")==null?"":request.getParameter("register_visit_referral");   
	String reg_vis_param=(request.getParameter("reg_vis_param") == null)?"":request.getParameter("reg_vis_param");
	String disable_pat_reg=(request.getParameter("disable_pat_reg") == null)?"":request.getParameter("disable_pat_reg");
	String fromserv=(request.getParameter("fromserv") == null)?"N":request.getParameter("fromserv");
	String bl_interface_yn=(request.getParameter("bl_interface_yn") == null)?"N":request.getParameter("bl_interface_yn");
    String emer_regn_allow_yn=(request.getParameter("emer_regn_allow_yn") == null)?"N":request.getParameter("emer_regn_allow_yn");
    String visit_for_inpat_yn=(request.getParameter("visit_for_inpat_yn") == null)?"N":request.getParameter("visit_for_inpat_yn");
	String status=request.getParameter("status");
    if(status == null) status="N";
	String function_id=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");
	String wait_list_inv=(request.getParameter("wait_list_inv") == null)?"N":request.getParameter("wait_list_inv");
	String call_from=(request.getParameter("call_from") == null)?"":request.getParameter("call_from");

	if(wait_list_inv.equals(""))
	      wait_list_inv="N";

	

    
%>
<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOP/js/VisitRegistration.js'></script>
	<script language='javascript' src='../../eOP/js/VisitRegistration1.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
</head>
<body onLoad="" onKeyDown ='lockKey()'>
	<form name='patient_head' id='patient_head'>
	<a alt='Invitation List'> </a>
	<ul id="tablist" class="tablist" style="padding-left:0px">
	<%
		if(call_from.equals("CA"))
	{
	%>
		<li class="tablistitem" title="Add Visit">
			<a id="addvisit_tab" class="tabClicked"  >
				<span class="tabSpanclicked" id="addvisit_tabspan"><fmt:message key="eOP.addvisit.label" bundle="${op_labels}"/></span>
			</a>
		</li>
	<%
	}
	else
	{
	if(register_visit_walkin.equals("N") && register_visit_referral.equals("N"))
	{
	%>
		<li class="tablistitem" title="Appt List">
		<a onclick="javascript:tab_click('checkin_tab','<%=errorMsg%>')" id="checkin_tab" class="tabClicked"  >
		<span class="tabSpanclicked" id="checkin_tabspan"><fmt:message key="eOP.ApptList.label" bundle="${op_labels}"/></span>
		</a>
	</li>
<%	}
	else
	{
		if(wait_list_inv.equals("Y"))
		{
		%>
    <script>prevTabObj='invitation_tab'</script>
          
				
						<li class="tablistitem" title="Invitation List">
					<a onclick="tab_click('invitation_tab','WA')" class="tabClicked" id="invitation_tab" >
						<span class="tabSpanclicked" id="invitation_tabspan"><fmt:message key="Common.invitationlist.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Appt List">
					<a onclick="javascript:tab_click('checkin_tab','<%=errorMsg%>')" id="checkin_tab" class="tabA"  >
					<span class="tabAspan" id="checkin_tabspan"><fmt:message key="eOP.apptlist.label" bundle="${op_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Add Visit">
					<a onclick="javascript:tab_click('addvisit_tab','<%=errorMsg%>')" id="addvisit_tab" class="tabA"  >
						<span class="tabAspan" id="addvisit_tabspan"><fmt:message key="eOP.addvisit.label" bundle="${op_labels}"/></span>
					</a>
				</li>	
			
		<!-- <a href="javascript:tab_click('invitation_tab','WA')" alt='Invitation List'>
			<img name='invitation_tab' border='0' src='../images/Invitation-List.gif' alt='Invitation List'></img></a><a href="javascript:tab_click('checkin_tab','<%=errorMsg%>')" alt='Appt List'><img name='checkin_tab' border='0' src='../images/Appt_List_click.gif' alt='Appt List' style='{ border-style: ridge;}'></img></a><a href="javascript:tab_click('addvisit_tab','<%=errorMsg%>')" alt='Add Visit'><img name='addvisit_tab' border='0' src='../images/LAddVisit.gif' alt='Add Visit'></img></a> -->
			
		<%}else{
		%><script>prevTabObj='checkin_tab'</script>
			<li class="tablistitem" title="Appt List">
					<a onclick="javascript:tab_click('checkin_tab','<%=errorMsg%>')" id="checkin_tab" class="tabClicked"  >
						<span class="tabSpanclicked" id="checkin_tabspan"><fmt:message key="eOP.apptlist.label" bundle="${op_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Add Visit">
					<a onclick="javascript:tab_click('addvisit_tab','<%=errorMsg%>')" id="addvisit_tab" class="tabA"  >
						<span class="tabAspan" id="addvisit_tabspan"><fmt:message key="eOP.addvisit.label" bundle="${op_labels}"/></span>
					</a>
				</li>
	<%	
		}	
	}
	}
%>		
     </ul>
	
	    <input type='hidden' name='query_string' id='query_string' value='<%=query_string%>'>
		<input type='hidden' name='gen_file_yn' id='gen_file_yn' value='<%=gen_file_yn%>'>
        <input type='hidden' name='ct_tab_name' id='ct_tab_name'>
        <input type='hidden' name='ct_patient_id' id='ct_patient_id' value="">
        <input type='hidden' name='referral_id' id='referral_id' value="">
        <input type='hidden' name='oa_install_yn' id='oa_install_yn' value="<%=oa_install_yn%>">
	    <input type='hidden' name='or_install_yn' id='or_install_yn' value="<%=or_install_yn%>">
        <input type='hidden' name='assign_care_locn_code' id='assign_care_locn_code' value="<%=clinic_code%>">
        <input type='hidden' name='practitioner_id' id='practitioner_id' value="">
        <input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>">
        <input type='hidden' name='error' id='error' value="">     
        <input type='hidden' name='init_params' id='init_params' value="">
        <input type='hidden' name='reg_vis_param' id='reg_vis_param' value="<%=reg_vis_param%>" >		
        <input type='hidden' name='disable_pat_reg' id='disable_pat_reg' value="<%=disable_pat_reg%>">
		<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
		<input type='hidden' name='register_visit_walkin' id='register_visit_walkin' value="<%=register_visit_walkin%>" >	
		<input type='hidden' name='register_visit_referral' id='register_visit_referral' value="<%=register_visit_referral%>">
		<input type='hidden' name='build_episode_rule' id='build_episode_rule' value="<%=build_episode_rule%>">
		 <input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value='<%=bl_interface_yn%>'>
		<input type='hidden' name='invitation_no' id='invitation_no' value=''>
		<input type='hidden' name='wait_list_inv' id='wait_list_inv' value='<%=wait_list_inv%>'>
		<input type='hidden' name='emer_regn_allow_yn' id='emer_regn_allow_yn' value='<%=emer_regn_allow_yn%>'>
        <input type='hidden' name='visit_for_inpat_yn' id='visit_for_inpat_yn' value='<%=visit_for_inpat_yn%>'>
        <input type='hidden' name='register_pat_yn' id='register_pat_yn' value='<%=register_pat_yn%>'>
        <input type='hidden' name='call_from' id='call_from' value='<%=call_from%>'>
		

		
    </form>
	<%

	if(wait_list_inv.equals("N") && status.equals("Y"))
  {
%>
  <script>
	currentTab ="checkin_tab";
  </script>
<%
  }
	if(fromserv.equals("Y"))
	{
	%>
	<script>
		changeTab('addvisit_tab')
	</script>
	<%
	}

	if(wait_list_inv.equals("N"))
  {
%>
  <script>
	currentTab ="checkin_tab";
  </script>
<%
	  if(status.equals("Y"))
	  {	      
  %>
		  <script> currentTab ="addvisit_tab"; </script>
	  
<%
	  }
  }else if(wait_list_inv.equals("Y"))
  {
  %>
	  <script>
	  currentTab = "invitation_tab";
      </script>
  <%}%>
</body>
</html>
	<%
}catch(Exception ee){}

%>

