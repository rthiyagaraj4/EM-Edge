<!DOCTYPE html>
<%
//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*"
%>
<%@page  import="java.util.HashMap,java.util.ArrayList, eOT.*, eOT.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>

<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
    <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/VerifyCheckList.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../eOT/js/OTMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>

<body  onKeyDown="lockKey()" >
	<form name="VerifyCheckListConfirmForm" id="VerifyCheckListConfirmForm" >
		<table class='grid'cellpadding="3" cellspacing="0" width="102%" align="center" border="1">
		<%
			String user_id	= request.getParameter("slate_user_id");
			String no_of_verifications = request.getParameter("no_of_verifications");
			String disable_checklist_fields = request.getParameter("disable_checklist_fields");
			//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
			String pre_or_post	= request.getParameter("pre_or_post");
			String checklist_stage = request.getParameter("checklist_stage");

			int remarks_width	= 5;
			int list_width		= 7;			
			int desc_width		= 0; 
			if(no_of_verifications.equals("4")){
				list_width		= 7;
				desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)))-53;
			}else if(no_of_verifications.equals("3"))
				desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)))-59;
			else if(no_of_verifications.equals("2"))
				desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)))-59;
			else if(no_of_verifications.equals("1"))
				desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)))-57;

//desc_width=100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)))-56;
//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
	//Start
	if((pre_or_post.equals("I"))&&(!no_of_verifications.equals("")))
		{
		list_width = 35;
		desc_width = 40;
		remarks_width=25;
		}
	//End
			String bean_id			 = "@VerifyCheckListBean";
			String bean_name		 = "eOT.VerifyCheckListBean";
			VerifyCheckListBean bean = (VerifyCheckListBean)mh.getBeanObject(bean_id,request,bean_name);

			// for the title headers
			ArrayList roles_arr		 = new ArrayList();
			String role_id_1 = CommonBean.checkForNull(request.getParameter("role_id_1"));
			String role_id_2 = CommonBean.checkForNull(request.getParameter("role_id_2"));
			String role_id_3 = CommonBean.checkForNull(request.getParameter("role_id_3"));
			String role_id_4 = CommonBean.checkForNull(request.getParameter("role_id_4"));

			if(role_id_1!=null && !role_id_1.equals("null"))
				roles_arr.add(role_id_1);
			if(role_id_2!=null && !role_id_2.equals("null"))
				roles_arr.add(role_id_2);
			if(role_id_3!=null && !role_id_3.equals("null"))
				roles_arr.add(role_id_3);
			if(role_id_4!=null && !role_id_4.equals("null"))
				roles_arr.add(role_id_4);

			HashMap roles_desc = new HashMap();
			if(roles_arr.size()>0)
				roles_desc = bean.getRoleDesc(roles_arr);
			int size=roles_desc.size();
			ArrayList user_info_arr = (ArrayList)bean.getUserInfo();

			String chklst_usr1_id = "(------)";
			String chklst_usr2_id = "(------)";
			String chklst_usr3_id = "(------)";
			String chklst_usr4_id = "(------)";

			String chklst_usr1_compl_yn = "";
			String chklst_usr2_compl_yn = "";
			String chklst_usr3_compl_yn = "";
			String chklst_usr4_compl_yn = "";

			String pre_oper_or_post_oper_flag = "";
			if(checklist_stage.equals("C10") || checklist_stage.equals("C20") || checklist_stage.equals("C30") || checklist_stage.equals("C40"))
				pre_oper_or_post_oper_flag="PRE";
			else
				pre_oper_or_post_oper_flag="POST";

			if(user_info_arr!=null && user_info_arr.size()>0){
				if(pre_oper_or_post_oper_flag.equals("PRE")){
					chklst_usr1_id = (String)user_info_arr.get(0); // C10
					chklst_usr1_compl_yn = (String)user_info_arr.get(1); // completed check for C10
					chklst_usr2_id = (String)user_info_arr.get(2); // C20
					chklst_usr2_compl_yn = (String)user_info_arr.get(3); // completed check for C20
					chklst_usr3_id = (String)user_info_arr.get(4); // C30
					chklst_usr3_compl_yn = (String)user_info_arr.get(5); // completed check for C30
					chklst_usr4_id = (String)user_info_arr.get(6); // C40
					chklst_usr4_compl_yn = (String)user_info_arr.get(7); // completed check for C40
				}else{
					chklst_usr1_id = (String)user_info_arr.get(8); // C50
					chklst_usr1_compl_yn = (String)user_info_arr.get(9); // completed check for C50
					chklst_usr2_id = (String)user_info_arr.get(10); // C60
					chklst_usr2_compl_yn = (String)user_info_arr.get(11); // completed check for C60
					chklst_usr3_id = (String)user_info_arr.get(12); // C70
					chklst_usr3_compl_yn = (String)user_info_arr.get(13); // completed check for C70
					chklst_usr4_id = (String)user_info_arr.get(14); // C80
					chklst_usr4_compl_yn = (String)user_info_arr.get(15); // completed check for C80
				}
				if(chklst_usr1_id==null) chklst_usr1_id="(------)";
				if(chklst_usr1_id!=null && chklst_usr1_id.equals("null")) 
					chklst_usr1_id="(------)";

				if(chklst_usr1_compl_yn==null) chklst_usr1_compl_yn="N";
				if(chklst_usr1_compl_yn!=null && chklst_usr1_compl_yn.equals("null")) 
					chklst_usr1_compl_yn="N";

				if(chklst_usr2_id==null) chklst_usr2_id="(------)";
				if(chklst_usr2_id!=null && chklst_usr2_id.equals("null")) 
					chklst_usr2_id="(------)";

				if(chklst_usr2_compl_yn==null) chklst_usr2_compl_yn="N";
				if(chklst_usr2_compl_yn!=null && chklst_usr2_compl_yn.equals("null")) 
					chklst_usr2_compl_yn="N";

				if(chklst_usr3_id==null) chklst_usr3_id="(------)";
				if(chklst_usr3_id!=null && chklst_usr3_id.equals("null")) 
					chklst_usr3_id="(------)";

				if(chklst_usr3_compl_yn==null) chklst_usr3_compl_yn="N";
				if(chklst_usr3_compl_yn!=null && chklst_usr3_compl_yn.equals("null")) 
					chklst_usr3_compl_yn="N";

				if(chklst_usr4_id==null) chklst_usr4_id="(------)";
				if(chklst_usr4_id!=null && chklst_usr4_id.equals("null")) 
					chklst_usr4_id="(------)";

				if(chklst_usr4_compl_yn==null) chklst_usr4_compl_yn="N";
				if(chklst_usr4_compl_yn!=null && chklst_usr4_compl_yn.equals("null")) 
					chklst_usr4_compl_yn="N";
			}

			String disabled="";
			String checkbox_checked = "";
		%>

			<tr>
				<td align="right" class="fields" width="<%=desc_width+"%"%>" >
				</td>				
				<%	
				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				if(pre_or_post.equals("I"))
						{
						if(chklst_usr3_compl_yn.equals("Y")){
							checkbox_checked="checked";
							disabled="disabled";
						}else{
							checkbox_checked="";
							if(!checklist_stage.equals("C30") && !checklist_stage.equals("C70"))
								disabled="disabled";
							else
								disabled="";
						}						
						if(disabled.equals("") && disable_checklist_fields.equals("disabled"))
							disabled=disable_checklist_fields;
				%>
					<td align="center" width="<%=list_width+"%"%>" style="font-weight:normal"><input type="checkbox" name="confirm_yn_3" id="confirm_yn_3" <%=disabled%> onClick="assignConfirm(this,'<%=user_id%>');" value="<%=chklst_usr3_compl_yn%>" <%=checkbox_checked%> ><fmt:message key="Common.completed.label" bundle="${common_labels}"/><br><br> <%=chklst_usr3_id%>
					</td> 
				<%
						}
					else
						{//End
					if(size>0){
						if(chklst_usr1_compl_yn.equals("Y")){
							disabled="disabled";
							checkbox_checked="checked";
						}else{
							checkbox_checked="";
							if(!checklist_stage.equals("C10") && !checklist_stage.equals("C50"))
								disabled="disabled";
							else
								disabled="";
						}						
						if(disabled.equals("") && disable_checklist_fields.equals("disabled"))
							disabled=disable_checklist_fields;
				%>
					<td align="center" width="<%=list_width+"%"%>" style="font-weight:normal"><input type="checkbox" name="confirm_yn_1" id="confirm_yn_1" <%=disabled%> onClick="assignConfirm(this,'<%=user_id%>');" value="<%=chklst_usr1_compl_yn%>" <%=checkbox_checked%> ><fmt:message key="Common.completed.label" bundle="${common_labels}"/><br><br> <%=chklst_usr1_id%>
					</td> 
				<%
					}
					if(size>1){
						if(chklst_usr2_compl_yn.equals("Y")){
							disabled="disabled";
							checkbox_checked="checked";
						}else{
							checkbox_checked="";
							if(!checklist_stage.equals("C20") && !checklist_stage.equals("C60"))
								disabled="disabled";
							else
								disabled="";
						}						
						if(disabled.equals("") && disable_checklist_fields.equals("disabled"))
							disabled=disable_checklist_fields;
				%>
					<td align="center" width="<%=list_width+"%"%>" style="font-weight:normal"><input type="checkbox" name="confirm_yn_2" id="confirm_yn_2" <%=disabled%> onClick="assignConfirm(this,'<%=user_id%>');" value="<%=chklst_usr2_compl_yn%>" <%=checkbox_checked%> ><fmt:message key="Common.completed.label" bundle="${common_labels}"/><br><br> <%=chklst_usr2_id%>
					</td> 
				<%
					}
					if(size>2){
						if(chklst_usr3_compl_yn.equals("Y")){
							checkbox_checked="checked";
							disabled="disabled";
						}else{
							checkbox_checked="";
							if(!checklist_stage.equals("C30") && !checklist_stage.equals("C70"))
								disabled="disabled";
							else
								disabled="";
						}						
						if(disabled.equals("") && disable_checklist_fields.equals("disabled"))
							disabled=disable_checklist_fields;
				%>
					<td align="center" width="<%=list_width+"%"%>" style="font-weight:normal"><input type="checkbox" name="confirm_yn_3" id="confirm_yn_3" <%=disabled%> onClick="assignConfirm(this,'<%=user_id%>');" value="<%=chklst_usr3_compl_yn%>" <%=checkbox_checked%> ><fmt:message key="Common.completed.label" bundle="${common_labels}"/><br><br> <%=chklst_usr3_id%>
					</td> 
				<%
					}
					if(size>3){
						if(chklst_usr4_compl_yn.equals("Y")){
							disabled="disabled";
							checkbox_checked="checked";
						}else{
							checkbox_checked="";
							if(!checklist_stage.equals("C40") && !checklist_stage.equals("C80"))
								disabled="disabled";
							else
								disabled="";
						}						
						if(disabled.equals("") && disable_checklist_fields.equals("disabled"))
							disabled=disable_checklist_fields;
				%>
					<td align="center" width="<%=list_width+"%"%>" style="font-weight:normal"><input type="checkbox" name="confirm_yn_4" id="confirm_yn_4" <%=disabled%> onClick="assignConfirm(this,'<%=user_id%>');" value="<%=chklst_usr4_compl_yn%>" <%=checkbox_checked%> > <fmt:message key="Common.completed.label" bundle="${common_labels}"/><br><br> <%=chklst_usr4_id%>
					</td> 
				<%
					}
					}
				%>
				<td class="fields" width="<%=remarks_width+"%"%>" ></td>
			</tr>
		</table>
		</form>
</body>
</html>

