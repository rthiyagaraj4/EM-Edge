<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.util.HashMap,java.util.ArrayList,eOT.*, eOT.Common.*, eCommon.Common.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %><html>
<head>
<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script language="JavaScript" src="../../eOT/js/OTMessages.js"></script> -->
<script language="JavaScript" src="../../eOT/js/VerifyCheckList.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style type="text/css">
.menu1 {text-align:left;position:relative;width:860px;}
</style>
</head>
<%
	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= request.getParameter("user_id");
	String mode			= (String)CommonRepository.getCommonKeyValue("MODE_INSERT") ;
	String params		= request.getQueryString() ;
	String booking_num	= request.getParameter("booking_num");
	String oper_num		= request.getParameter("oper_num");
	String pre_or_post	= request.getParameter("pre_or_post");
	String order_id		= request.getParameter("order_id");
	String access		= request.getParameter("access");
	String no_of_verifications	= request.getParameter("no_of_verifications");
	if(no_of_verifications==null) no_of_verifications="1";
	if(no_of_verifications.equals("null")) no_of_verifications="1";
	if(no_of_verifications.equals("")) no_of_verifications="1";
	String insert_update_flag	= "";
	
	//Modified By DhanasekarV against IN024357 on date 18/10/2010
	int current_level			= 2;
	String checklist_stage		= request.getParameter("checklist_stage");
	String apply_flag		= request.getParameter("apply_flag");
	if(checklist_stage.equals("C10") || checklist_stage.equals("C50"))
		current_level = 1;
	else if(checklist_stage.equals("C20") || checklist_stage.equals("C60"))
		current_level = 2;
	else if(checklist_stage.equals("C30") || checklist_stage.equals("C70"))
		current_level = 3;
	else if(checklist_stage.equals("C40") || checklist_stage.equals("C80"))
		current_level = 4;
	String checklist_codes_count = request.getParameter("checklist_codes_count");
//	String checklist_codes = request.getParameter("checklist_codes");
	ArrayList checklist_codes_arr = new ArrayList();
	for(int i=1;i<=Integer.parseInt(checklist_codes_count);i++)
		checklist_codes_arr.add(request.getParameter("verify_checklist_code_"+i));
	String checklist_arr0		= CommonBean.checkForNull((String)checklist_codes_arr.get(0));
	String checklist_arr1="";
	int checklist_codes_count_int = Integer.parseInt(checklist_codes_count);//Added against ML-MMOH-SCF-1282_10-07-2019
	if((pre_or_post.equals("I"))||(!(CommonBean.checkForNull(request.getParameter("invoked_from"))).equals(""))&&((request.getParameter("invoked_from")).equals("CHECKINTOOR") && checklist_codes_count_int <= 3)) //Modified against ML-MMOH-SCF-1282_10-07-2019
	{
			System.err.println("63: checklist_codes_count->"+checklist_codes_count);
			checklist_arr1=CommonBean.checkForNull((String)checklist_codes_arr.get(1));
	}
	//Added against ML-MMOH-SCF-1282_10-07-2019 Starts
	else if(checklist_stage.equals("C30"))
	{
		System.err.println("68: checklist_codes_count->"+checklist_codes_count);
		try{
		checklist_arr1=CommonBean.checkForNull((String)checklist_codes_arr.get(Integer.parseInt(checklist_codes_count)-2));
		} catch(Exception ex) {
			System.err.println("Error in Integer Conversion");
			ex.printStackTrace();
		}
	}
	//Added against ML-MMOH-SCF-1282_10-07-2019 Ends
	String bean_id		= "@VerifyCheckListBean";
	String bean_name	= "eOT.VerifyCheckListBean";
	VerifyCheckListBean bean = (VerifyCheckListBean)mh.getBeanObject(bean_id,request,bean_name);
	bean.loadCheckListDetails(checklist_codes_arr);
	HashMap all_checklist_details  = bean.getVerifyCheckListDetails();
	HashMap checklist_details = null;
	
	bean.loadExistingChkListDtls(booking_num,oper_num,order_id,pre_or_post);
	HashMap all_existing_chklist_dtls = bean.getExistingChkListDtls();
	String classValue			= "";
	String list_id				= "";
	String checklist_type		= "";
	String appl_for_intra_oper="";//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
	String list_code_temp		= "";
	String list_code_select		= "";
	String disabled				= "";
	String checked				= "";
	ArrayList arr_list_codes	= new ArrayList();
	int item_level				= 0;
	StringBuffer print_spaces	= new StringBuffer();
	
	int remarks_width	= 8;
	int list_width		= 18;
	int desc_width		= 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)));
	//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
	//Start	
	
	if((pre_or_post.equals("I"))&&(!no_of_verifications.equals("")))
	{
		list_width = 35;
		desc_width = 40;
		remarks_width=25;
	}
	//End
	else if(no_of_verifications.equals("4"))
	{
		list_width = 14;
		desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)));
	}	

	String checklist_value	 = "";
	String checklist_remarks = "";
	String accept_remarks_yn = "";
	String checklist_item_srl_no = "";
	String checklist_item_code ="";
	int row_num = 0;
try{
%>
	<body  ONLOAD='disable_reset();' onKeyDown = 'lockKey()' >
	<form name="VerifyCheckListForm" id="VerifyCheckListForm" method='POST' action="../../servlet/eOT.VerifyCheckListServlet">
	<table class='grid' cellpadding="3" cellspacing="0" align="center" border="1" width="100%">
<%	//for the title headers
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
		%>

			<tr>
				<th class='columnHeaderCenter'  wrap width="<%=desc_width+"%"%>" nowrap><fmt:message key="eOT.ChecklistItem.Label" bundle="${ot_labels}"/></th> 
				<%
					//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
					//Start
					if((pre_or_post.equals("I"))&&(!pre_or_post.equals("P"))&&(!pre_or_post.equals("O")))
					{
					%>
					<th class='columnHeaderCenter' width="<%=list_width+"%"%>" nowrap > 
					<fmt:message key="eOT.SurgeonRep.Label" bundle="${ot_labels}"/></th>
					<th class='columnHeaderCenter'  width="<%=remarks_width+"%"%>" nowrap colspan='3' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
					<%
					}
					else
					{
					//End
				%>
				<%
					if(size>0){
				%>
					<th class='columnHeaderCenter' width="<%=list_width+"%"%>" nowrap><%=(String)roles_desc.get(role_id_1)%></th> 
				<%
					}
					if(size>1){
				%>
					<th class='columnHeaderCenter' width="<%=list_width+"%"%>" nowrap><%=(String)roles_desc.get(role_id_2)%></th> 
				<%
					}
					if(size>2){
				%>
					<th class='columnHeaderCenter' width="<%=list_width+"%"%>" nowrap><%=(String)roles_desc.get(role_id_3)%></th> 
				<%
					}
					if(size>3){
				%>
					<th class='columnHeaderCenter' width="<%=list_width+"%"%>" nowrap><%=(String)roles_desc.get(role_id_4)%></th> 
				<%
					}
				%>
				<th class='columnHeaderCenter'  width="<%=remarks_width+"%"%>" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
			</tr>
<%			}//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
	StringBuffer sb_remarks = new StringBuffer();
	String previous_remarks = "";
	String style = "";
	String disable_checklist_fields = request.getParameter("disable_checklist_fields");

	String disable_all = "N";
	if(disable_checklist_fields.equals("disabled"))
		disable_all = "disabled";

	for(int i=1;i<=all_checklist_details.size();i++){
		row_num++;
		checklist_details	= (HashMap)all_checklist_details.get(i+"");
		checklist_item_code = (String)checklist_details.get("checklist_item_code");
		


		item_level			= Integer.parseInt((String)checklist_details.get("item_level"));
		list_id				= (String)checklist_details.get("list_id");
		checklist_type		= (String)checklist_details.get("checklist_type");
		//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
		//Start
		appl_for_intra_oper		= (String)checklist_details.get("appl_for_intra_oper");
		//End
		item_level = (item_level-1)*5;
		print_spaces.setLength(0);
		for(int s=0;s<item_level;s++)
			print_spaces.append("&nbsp;");//ML-MMOH-SCF-1018

		
		if ( row_num % 2 == 0 )
			classValue = "gridData" ;
		else
			classValue = "gridData" ;

		accept_remarks_yn = (String)checklist_details.get("accept_remarks_yn");
		checklist_item_srl_no = (String)checklist_details.get("checklist_item_srl_no");


// build the checklist_remarks here

		checklist_remarks = "";
		sb_remarks.setLength(0);
		previous_remarks = "";
		if(accept_remarks_yn!=null && accept_remarks_yn.equals("Y")){
			for(int r=1;r<=Integer.parseInt(no_of_verifications);r++){
				if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+r)!=null){		
					



					if(r==current_level){
						checklist_remarks = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+r)).get("checklist_remarks");
					}else{
						previous_remarks  = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+r)).get("checklist_remarks");
						if(previous_remarks==null)
							previous_remarks="";
						else if(previous_remarks!=null && previous_remarks.equals("null"))
							previous_remarks="";
							sb_remarks.append(previous_remarks);

				// Modified by DhanasekarV against the incident IN024968   on 09/11/2010
				if(previous_remarks.length()>0) 		sb_remarks.append("\n");

					// Modified by DhanasekarV against the incident IN024357 on 15/10/2010
						//					System.err.println( " eOT remarks "+sb_remarks.toString());
						//					System.err.println( " eOT checklistremarks "+checklist_remarks);
						//					System.err.println( " eOT current_level "+current_level);
					}
				}
			}
			
			if(checklist_remarks!=null){
				if(checklist_remarks.equals("null") || checklist_remarks.equals(""))
					checklist_remarks = "";
			}else{
				checklist_remarks = "";
			}
		// Modified by DhanasekarV against the incident IN024968   on 09/11/2010
			if(sb_remarks.length()>0 || checklist_remarks.length()>0){
				style = "color:navy;cursor:pointer;font-weight:bold";
				previous_remarks = sb_remarks.toString();
			}else{
				style = "color:blue;cursor:pointer";
				previous_remarks = "";
			}

			if(previous_remarks!=null && previous_remarks.equals("null"))
				previous_remarks="";
		}
// end of building the remarks
//System.err.println("checklist_remarks  "+checklist_remarks);
//System.err.println("previous_remarks  "+previous_remarks);
checklist_remarks=java.net.URLEncoder.encode(checklist_remarks,"UTF-8");
previous_remarks=java.net.URLEncoder.encode(previous_remarks,"UTF-8");
//System.err.println("checklist_remarks 219 "+checklist_remarks);
//System.err.println("previous_remarks 219 "+previous_remarks);
%>
			<tr>	
			<input type="hidden" name="checklist_code_<%=row_num%>" id="checklist_code_<%=row_num%>" value="<%=(String)checklist_details.get("checklist_code")%>">
			<input type="hidden" name="checklist_item_code_<%=row_num%>" id="checklist_item_code_<%=row_num%>" value="<%=checklist_item_code%>">
			<input type="hidden" name="checklist_item_srl_no_<%=row_num%>" id="checklist_item_srl_no_<%=row_num%>" value="<%=checklist_item_srl_no%>">
			<input type="hidden" name="description_<%=row_num%>" id="description_<%=row_num%>" value="<%=(String)checklist_details.get("description")%>">
			<input type="hidden" name="accept_remarks_yn_<%=row_num%>" id="accept_remarks_yn_<%=row_num%>" value="<%=accept_remarks_yn%>">		
			<input type="hidden" name="checklist_type_<%=row_num%>" id="checklist_type_<%=row_num%>" value="<%=checklist_type%>">

			<input type="hidden" name="list_id_<%=row_num%>" id="list_id_<%=row_num%>" value="<%=(String)checklist_details.get("list_id")%>">		

			<input type="hidden" name="remarks_<%=row_num%>" id="remarks_<%=row_num%>" value="<%=checklist_remarks%>">				
	<%	if((checklist_type.equals("E"))&&(!pre_or_post.equals("I"))){
			if((!checklist_arr1.equals(""))&&(checklist_arr1.equals((String)checklist_details.get("checklist_code")))&&(!(CommonBean.checkForNull(request.getParameter("invoked_from"))).equals(""))&&((request.getParameter("invoked_from")).equals("CHECKINTOOR")))
				{}else {
	%>
			<td class="<%=classValue%>" width="<%=desc_width+"%"%>" style="font-weight:normal" nowrap>
				<%=(String)checklist_details.get("description")%>
			</td>
			<%
				for(int cc=0;cc<Integer.parseInt(no_of_verifications);cc++){ 
			%>
				<td class="<%=classValue%>" nowrap></td>
			<%
				}
				if(accept_remarks_yn.equals("Y")){
					if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+current_level)!=null){
						insert_update_flag="U";
					}else{
						insert_update_flag="I";
					}
					if(previous_remarks==null){
						previous_remarks="";
					}else if(previous_remarks!=null && previous_remarks.equals("null")){
						previous_remarks="";
					}
			%>
					<input type="hidden" name="insert_update_flag_<%=row_num%>" id="insert_update_flag_<%=row_num%>"  value="<%=insert_update_flag%>">
					<td class="<%=classValue%>" width="<%=remarks_width+"%"%>" nowrap>
						<label style="<%=style%>"onClick="openCheckListRemarksWindow('<%=row_num%>','<%=previous_remarks%>','<%=disable_all%>','200')" onkeypress="return CheckForOHSpecChars(event);"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
					</td>
			<%
				}else{
			%>
					<input type="hidden" name="insert_update_flag_<%=row_num%>" id="insert_update_flag_<%=row_num%>"  value="X">
					<td class="<%=classValue%>" width="<%=remarks_width+"%"%>" nowrap></td>
		<%
				}
				}
		}else{
			//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
			//Start
			//This Condition is for IntraOperative Checklist Tab
			if(((appl_for_intra_oper.equals("I"))||(appl_for_intra_oper.equals("B")))&&(pre_or_post.equals("I"))&&(!pre_or_post.equals("P"))&&(!pre_or_post.equals("O")))
					{
					String status_flag1="";
				if(checklist_arr1.equals((String)checklist_details.get("checklist_code")))
					{
					for(int f=1;f<=all_checklist_details.size();f++)
						{
						HashMap checklist_details1	= (HashMap)all_checklist_details.get(f+"");
						
							String item_code=(String)checklist_details1.get("checklist_item_code");
							String chklist_code=(String)checklist_details1.get("checklist_code");
							if(!checklist_arr0.equals(checklist_arr1))
								{
							if(chklist_code.equals(checklist_arr0)&&(item_code.equals(checklist_item_code)))
								{
								status_flag1="Y";
								}
								}
							
						
						}
					}
					if(status_flag1.equals("Y"))
						{}
						else{
					%>
					<td class="<%=classValue%>" style="font-weight:normal" width="<%=desc_width+"%"%>"  nowrap >
					<%=print_spaces%><%=(String)checklist_details.get("description")%>
						</td><%
						if(checklist_type.equals("L")){
							bean.loadListItemValues(list_id);
							for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
								checklist_value="S";
								if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
									checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
									checklist_value=checklist_value==null?"":checklist_value;
									checklist_value=checklist_value.equalsIgnoreCase("null")?"S":checklist_value;
									insert_update_flag="U";
								}else{
									checklist_value="S";
									insert_update_flag="I";
								}
								if(k==current_level && disable_all.equals("N"))
									disabled="";
								else
									disabled="disabled";			
								
								if(k==3)
								{
					%>
							<input type="hidden" name="insert_update_flag_<%=row_num%>_<%=k%>" id="insert_update_flag_<%=row_num%>_<%=k%>" value="<%=insert_update_flag%>">			
					<td class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap ><select name="list_value_<%=row_num%>_<%=k%>" id="list_value_<%=row_num%>_<%=k%>" <%=disabled%> >
										<%
											list_code_temp   = "";
											list_code_select = "";
											arr_list_codes = null;
											arr_list_codes = bean.getListItemValues();
											if(arr_list_codes!=null){
												for(int j=0;j<arr_list_codes.size();j=j+3){
													list_code_temp = (String)arr_list_codes.get(j);
																
														if(((String)arr_list_codes.get(j+1)).equals("Y")){
															list_code_select = "selected";
														}else if (checklist_value.equals(list_code_temp)){
																
														list_code_select = "selected";
														}else
														{
															list_code_select = "";
														}
										%>
												<option value="<%=list_code_temp%>" <%=list_code_select%>> 
													<%=arr_list_codes.get(j+2)%>
												</option>
										<%
												}
											}
										%>
									</select>
								</td>
						<%
								}
								}
							}else if(checklist_type.equals("C")){
								for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
									checklist_value="N";
									if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
										insert_update_flag="U";
										checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
									}else{
										checklist_value="N";
										insert_update_flag="I";
										
									}

									if(k==current_level  && disable_all.equals("N"))
										disabled="";
									else
										disabled="disabled";
									if(checklist_value.equals("Y"))
										checked = "checked";
									else
										checked = "";
							%>
				<input type="hidden" name="insert_update_flag_<%=row_num%>_<%=k%>" id="insert_update_flag_<%=row_num%>_<%=k%>" value="<%=insert_update_flag%>">
				<%				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
									if(k==3)
									{
									%>
									<td align="center" class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap >
									<input type="checkbox" name="chkbox_value_<%=row_num%>_<%=k%>" id="chkbox_value_<%=row_num%>_<%=k%>" <%=disabled%> <%=checked%> onClick="assignCheckboxValue(this);" value="<%=checklist_value%>"  align="center"></td>
									<%}%>
									
								
									<%
									}	
							
							}
							else
								{
								%>
								<td align="center" class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap >&nbsp;</td>
								<%
								}
							if(accept_remarks_yn.equals("Y")){
								/*if(previous_remarks==null)
									previous_remarks="";
								else if(previous_remarks!=null && previous_remarks.equals("null"))
									previous_remarks="";*/
							previous_remarks = (previous_remarks=="null" || previous_remarks==null)?"":previous_remarks;
						%>
								<td class="<%=classValue%>" width="<%=remarks_width+"%"%>" nowrap >
									<label style="<%=style%>" onClick="openCheckListRemarksWindow('<%=row_num%>','<%=previous_remarks%>','<%=disable_all%>','200')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
								</td>
						<%
							}else{
						%>
								<td class="<%=classValue%>" width="<%=remarks_width+"%"%>" nowrap ></td>
					<%
							}
					}
					}
					
			//Mahesh new
			//This IF  CONDITION is for CHECK INTO OR Functions
//else if((pre_or_post.equals("P"))&&(!pre_or_post.equals("I"))&&(!pre_or_post.equals("O"))&&(apply_flag!=null)&&(apply_flag.equals("Y"))&&((!appl_for_intra_oper.equals("N"))&&(!checklist_arr1.equals((String)checklist_details.get("checklist_code"))))&&(!(CommonBean.checkForNull(request.getParameter("invoked_from"))).equals(""))&&((request.getParameter("invoked_from")).equals("CHECKINTOOR")))

else if((pre_or_post.equals("P"))&&(!(CommonBean.checkForNull(request.getParameter("invoked_from"))).equals(""))&&((request.getParameter("invoked_from")).equals("CHECKINTOOR")))
				{
				String status_flag="";
				if(checklist_arr1.equals((String)checklist_details.get("checklist_code")))
					{
					for(int f=1;f<=all_checklist_details.size();f++)
						{
						HashMap checklist_details1	= (HashMap)all_checklist_details.get(f+"");
						
							String item_code=(String)checklist_details1.get("checklist_item_code");
							String chklist_code=(String)checklist_details1.get("checklist_code");
							if(!checklist_arr0.equals(checklist_arr1))
								{
								if(chklist_code.equals(checklist_arr0)&&(item_code.equals(checklist_item_code)))
									{
									status_flag="Y";
									}
								}
						
						}
					}
				if((status_flag.equals("Y"))||((checklist_arr1.equals((String)checklist_details.get("checklist_code")))&&(appl_for_intra_oper.equals("N"))))
					{}
				else{	
				//End
		%>		<td class="<%=classValue%>" style="font-weight:normal" width="<%=desc_width+"%"%>"  nowrap>
				<%=print_spaces%><%=(String)checklist_details.get("description")%>
		</td>	<%
		if(checklist_type.equals("L")){
			bean.loadListItemValues(list_id);
			for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
				checklist_value="S";
				if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
					checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
					checklist_value=checklist_value==null?"":checklist_value;
					checklist_value=checklist_value.equalsIgnoreCase("null")?"S":checklist_value;
					insert_update_flag="U";
				}else{
					checklist_value="S";
					insert_update_flag="I";
				}
				if(k==current_level && disable_all.equals("N"))
					disabled="";
				else
					disabled="disabled";
				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				//Start
				if(appl_for_intra_oper.equals("I"))
					{
					if((k==1||k==2)){
					%>
					<td align="center" class="<%=classValue%>" >&nbsp;</td>
					<%}
					else{//End
					%>
			<input type="hidden" name="insert_update_flag_<%=row_num%>_<%=k%>" id="insert_update_flag_<%=row_num%>_<%=k%>" value="<%=insert_update_flag%>">			
	<td class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap><select name="list_value_<%=row_num%>_<%=k%>" id="list_value_<%=row_num%>_<%=k%>" <%=disabled%> >
						<%
							list_code_temp   = "";
							list_code_select = "";
							arr_list_codes = null;
							arr_list_codes = bean.getListItemValues();
							if(arr_list_codes!=null){
								for(int j=0;j<arr_list_codes.size();j=j+3){
									list_code_temp = (String)arr_list_codes.get(j);
												
										if(((String)arr_list_codes.get(j+1)).equals("Y")){
											list_code_select = "selected";
										}else if (checklist_value.equals(list_code_temp)){
												
										list_code_select = "selected";
										}else
										{
											list_code_select = "";
										}
						%>
								<option value="<%=list_code_temp%>" <%=list_code_select%>> 
									<%=arr_list_codes.get(j+2)%>
								</option>
						<%
								}
							}
						%>
					</select>
				</td><%
						}
					}
				else{	
	%>
			<input type="hidden" name="insert_update_flag_<%=row_num%>_<%=k%>" id="insert_update_flag_<%=row_num%>_<%=k%>" value="<%=insert_update_flag%>">			
	<td class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap><select name="list_value_<%=row_num%>_<%=k%>" id="list_value_<%=row_num%>_<%=k%>" <%=disabled%> >
						<%
							list_code_temp   = "";
							list_code_select = "";
							arr_list_codes = null;
							arr_list_codes = bean.getListItemValues();
							if(arr_list_codes!=null){
								for(int j=0;j<arr_list_codes.size();j=j+3){
									list_code_temp = (String)arr_list_codes.get(j);
												
										if(((String)arr_list_codes.get(j+1)).equals("Y")){
											list_code_select = "selected";
										}else if (checklist_value.equals(list_code_temp)){
												
										list_code_select = "selected";
										}else
										{
											list_code_select = "";
										}
						%>
								<option value="<%=list_code_temp%>" <%=list_code_select%>> 
									<%=arr_list_codes.get(j+2)%>
								</option>
						<%
								}
							}
						%>
					</select>
				</td>
		<%
				}
				}
			}else if(checklist_type.equals("C")){
				for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
					checklist_value="N";
					if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
						insert_update_flag="U";
						checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
					}else{
						checklist_value="N";
						insert_update_flag="I";
					}

					if(k==current_level  && disable_all.equals("N"))
						disabled="";
					else
						disabled="disabled";
					if(checklist_value.equals("Y"))
						checked = "checked";
					else
						checked = "";
			%>
<input type="hidden" name="insert_update_flag_<%=row_num%>_<%=k%>" id="insert_update_flag_<%=row_num%>_<%=k%>" value="<%=insert_update_flag%>">
<%				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				if(appl_for_intra_oper.equals("I"))
					{
					if((k==1||k==2)){
					%>
					<td align="center" class="<%=classValue%>" >&nbsp;</td>
					<%}
					else{
					%>
					<td align="center" class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap >
					<input type="checkbox" name="chkbox_value_<%=row_num%>_<%=k%>" id="chkbox_value_<%=row_num%>_<%=k%>" <%=disabled%> <%=checked%> onClick="assignCheckboxValue(this);" value="<%=checklist_value%>"  align="center"></td>
					<%}%>
					<%
					}	
				else{	//End
		%>		<td align="center" class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap >
					<input type="checkbox" name="chkbox_value_<%=row_num%>_<%=k%>" id="chkbox_value_<%=row_num%>_<%=k%>" <%=disabled%> <%=checked%> onClick="assignCheckboxValue(this);" value="<%=checklist_value%>"  align="center">
					
				</td>
				<%
				}
				%>
				<input type="hidden" name="total_value_<%=row_num%>_<%=k%>" id="total_value_<%=row_num%>_<%=k%>" value="<%=(String)checklist_details.get("checklist_code")+"|"+checklist_item_code+"|"+checklist_item_srl_no+"|"+checklist_type+"|"+(String)checklist_details.get("list_id")+"|"+checklist_remarks%>">
				<%
				}
			}
			if(accept_remarks_yn.equals("Y")){
				/*if(previous_remarks==null)
					previous_remarks="";
				else if(previous_remarks!=null && previous_remarks.equals("null"))
					previous_remarks="";*/
			previous_remarks = (previous_remarks=="null" || previous_remarks==null)?"":previous_remarks;
		%>
				<td class="<%=classValue%>" width="<%=remarks_width+"%"%>" nowrap>
					<label style="<%=style%>" onClick="openCheckListRemarksWindow('<%=row_num%>','<%=previous_remarks%>','<%=disable_all%>','200')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
				</td>
		<%
			}else{
		%>
				<td class="<%=classValue%>" width="<%=remarks_width+"%"%>" nowrap></td>
	<%
			}
				}
				}
			else if(((pre_or_post.equals("P"))&&(!appl_for_intra_oper.equals("I")))||((pre_or_post.equals("O"))&&(!appl_for_intra_oper.equals("I"))))
				{
				String status_flag2="";
				if(checklist_arr1.equals((String)checklist_details.get("checklist_code")))
					{
					for(int f=1;f<=all_checklist_details.size();f++)
						{
						HashMap checklist_details1	= (HashMap)all_checklist_details.get(f+"");
						
							String item_code=(String)checklist_details1.get("checklist_item_code");
							String chklist_code=(String)checklist_details1.get("checklist_code");
							if(chklist_code.equals(checklist_arr0)&&(item_code.equals(checklist_item_code)))
								{
								status_flag2="Y";
								}
							
						
						}
					}
				if(status_flag2.equals("Y"))	{}
				else
					{				
				//End
		%>		<td class="<%=classValue%>" style="font-weight:normal" width="<%=desc_width+"%"%>"  nowrap>
				<%=print_spaces%><%=(String)checklist_details.get("description")%>
		</td>	<%
		if(checklist_type.equals("L")){
			bean.loadListItemValues(list_id);
			for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
				checklist_value="S";
				if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
					checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
					checklist_value=checklist_value==null?"":checklist_value;
					checklist_value=checklist_value.equalsIgnoreCase("null")?"S":checklist_value;
					insert_update_flag="U";
				}else{
					checklist_value="S";
					insert_update_flag="I";
				}
				if(k==current_level && disable_all.equals("N"))
					disabled="";
				else
					disabled="disabled";			
				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				//Start
				if(appl_for_intra_oper.equals("I"))
					{
					if((k==1||k==2)){
					%>
					<td align="center" class="<%=classValue%>" >&nbsp;</td>
					<%}
					else{//End
					%>
			<input type="hidden" name="insert_update_flag_<%=row_num%>_<%=k%>" id="insert_update_flag_<%=row_num%>_<%=k%>" value="<%=insert_update_flag%>">			
	<td class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap><select name="list_value_<%=row_num%>_<%=k%>" id="list_value_<%=row_num%>_<%=k%>" <%=disabled%> >
						<%
							list_code_temp   = "";
							list_code_select = "";
							arr_list_codes = null;
							arr_list_codes = bean.getListItemValues();
							if(arr_list_codes!=null){
								for(int j=0;j<arr_list_codes.size();j=j+3){
									list_code_temp = (String)arr_list_codes.get(j);
												
										if(((String)arr_list_codes.get(j+1)).equals("Y")){
											list_code_select = "selected";
										}else if (checklist_value.equals(list_code_temp)){
												
										list_code_select = "selected";
										}else
										{
											list_code_select = "";
										}
						%>
								<option value="<%=list_code_temp%>" <%=list_code_select%>> 
									<%=arr_list_codes.get(j+2)%>
								</option>
						<%
								}
							}
						%>
					</select>
				</td><%
						}
					}
				else{	
	%>
			<input type="hidden" name="insert_update_flag_<%=row_num%>_<%=k%>" id="insert_update_flag_<%=row_num%>_<%=k%>" value="<%=insert_update_flag%>">			
	<td class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap><select name="list_value_<%=row_num%>_<%=k%>" id="list_value_<%=row_num%>_<%=k%>" <%=disabled%> >
						<%
							list_code_temp   = "";
							list_code_select = "";
							arr_list_codes = null;
							arr_list_codes = bean.getListItemValues();
							if(arr_list_codes!=null){
								for(int j=0;j<arr_list_codes.size();j=j+3){
									list_code_temp = (String)arr_list_codes.get(j);
												
										if(((String)arr_list_codes.get(j+1)).equals("Y")){
											list_code_select = "selected";
										}else if (checklist_value.equals(list_code_temp)){
												
										list_code_select = "selected";
										}else
										{
											list_code_select = "";
										}
						%>
								<option value="<%=list_code_temp%>" <%=list_code_select%>> 
									<%=arr_list_codes.get(j+2)%>
								</option>
						<%
								}
							}
						%>
					</select>
				</td>
		<%
				}
				}
			}else if(checklist_type.equals("C")){
				for(int k=1;k<=Integer.parseInt(no_of_verifications);k++){
					checklist_value="N";
					if(all_existing_chklist_dtls.size()>0 && (HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)!=null){
						insert_update_flag="U";
						checklist_value = (String)((HashMap)all_existing_chklist_dtls.get(checklist_item_code+"#"+k)). get("checklist_value");
						}else{
						checklist_value="N";
						insert_update_flag="I";
					}
					if(k==current_level  && disable_all.equals("N"))
						disabled="";
					else
						disabled="disabled";
					if(checklist_value.equals("Y"))
						checked = "checked";
					else
						checked = "";
			%>
<input type="hidden" name="insert_update_flag_<%=row_num%>_<%=k%>" id="insert_update_flag_<%=row_num%>_<%=k%>" value="<%=insert_update_flag%>">
<%				//Maheshwaran K modified for the CHL-CRF-0043 [IN:035927] as on 26/02/2013
				if(appl_for_intra_oper.equals("I"))
					{
					if((k==1||k==2)){
					%>
					<td align="center" class="<%=classValue%>" >&nbsp;</td>
					<%}
					else{
					%>
					<td align="center" class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap >
					<input type="checkbox" name="chkbox_value_<%=row_num%>_<%=k%>" id="chkbox_value_<%=row_num%>_<%=k%>" <%=disabled%> <%=checked%> onClick="assignCheckboxValue(this);" value="<%=checklist_value%>"  align="center"></td>
					<%}%>
					<%
					}	
				else{	//End
		%>		<td align="center" class="<%=classValue%>" width="<%=list_width+"%"%>" nowrap >
					<input type="checkbox" name="chkbox_value_<%=row_num%>_<%=k%>" id="chkbox_value_<%=row_num%>_<%=k%>" <%=disabled%> <%=checked%> onClick="assignCheckboxValue(this);" value="<%=checklist_value%>"  align="center">
					
				</td>
				<%
				}
				%>
				<input type="hidden" name="total_value_<%=row_num%>_<%=k%>" id="total_value_<%=row_num%>_<%=k%>" value="<%=(String)checklist_details.get("checklist_code")+"|"+checklist_item_code+"|"+checklist_item_srl_no+"|"+checklist_type+"|"+(String)checklist_details.get("list_id")+"|"+checklist_remarks%>">
				<%
				}
			}
			if(accept_remarks_yn.equals("Y")){
				/*if(previous_remarks==null)
					previous_remarks="";
				else if(previous_remarks!=null && previous_remarks.equals("null"))
					previous_remarks="";*/
			previous_remarks = (previous_remarks=="null" || previous_remarks==null)?"":previous_remarks;
		%>
				<td class="<%=classValue%>" width="<%=remarks_width+"%"%>" nowrap>
					<label style="<%=style%>" onClick="openCheckListRemarksWindow('<%=row_num%>','<%=previous_remarks%>','<%=disable_all%>','200')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
				</td>
		<%
			}else{
		%>
				<td class="<%=classValue%>" width="<%=remarks_width+"%"%>" nowrap></td>
	<%
			}
				}
				}
		}
		}
	
	  sb_remarks.setLength(0);
	  print_spaces.setLength(0);
%>

</table>

	<input type='hidden' name='params' id='params' value='<%=params%>' >
	<input type='hidden' name='mode' id='mode' value='<%=mode%>' >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >	
	<input type="hidden" name="checklist_user_id" id="checklist_user_id" value="<%=user_id%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="current_level" id="current_level" value="<%=current_level%>">
	<input type="hidden" name="oper_num" id="oper_num" value="<%=oper_num%>">
	<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
	<input type="hidden" name="booking_num" id="booking_num" value="<%=booking_num%>">	
	<input type="hidden" name="checklist_stage" id="checklist_stage" value="<%=checklist_stage%>"> 
	<input type="hidden" name="no_of_verifications" id="no_of_verifications" value="<%=row_num%>">
	<input type="hidden" name="no_of_verifications_orig" id="no_of_verifications_orig" value="<%=no_of_verifications%>">
	<input type="hidden" name="apply_flag" id="apply_flag" value="<%=apply_flag%>">
	<input type="hidden" name="size" id="size" value="<%=row_num%>">
	<input type="hidden" name="access" id="access" value="<%=access%>">
	<input type="hidden" name="confirm_yn" id="confirm_yn" value="">
	<input type="hidden" name="booking_or_oper_flag" id="booking_or_oper_flag" value="<%=request.getParameter("booking_or_oper_flag")%>"> 
	<script>
	setTimeout("disable_apply_button()",200);
</script>
</form>
</body>
</html>
<%
	}catch(Exception e)
	{
		e.printStackTrace(System.err);
		System.err.println("caught exception e="+e);
	}finally{


			

//		bean.clear();
	}
%>

