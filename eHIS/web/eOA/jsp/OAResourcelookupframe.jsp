<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*" %>
<script src='../../eOA/js/OAResourcelookup.js' language='javascript'></script>
<script language='javascript' src='../../eOA/js/OAResourceComponent.js'></script>

 

<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale=(String)session.getAttribute("LOCALE");
	String facilityId=(String) session.getValue("facility_id");
	String from_page=request.getParameter("from_page");
	if(from_page==null) from_page="";
	String pract_value=request.getParameter("pract_value");
	if(pract_value==null) pract_value="";

	String pract_id=request.getParameter("pract_id");
	if(pract_id==null) pract_id="";

	String res_type=request.getParameter("res_type");
	if(res_type==null) res_type="";

	String called_from=request.getParameter("called_from"); //Added by S.Sathish for IN020571 on Thursday, April 08, 2010 
	if(called_from==null) called_from="";

	//Added by S.Sathish for IN021901 on Friday, June 11, 2010 Starts here
	String resourceId=request.getParameter("resourceId");
	if(resourceId==null) resourceId="";

	String resourceDesc=request.getParameter("resourceDesc");
	if(resourceDesc==null) resourceDesc="";
	
	String resourceType_2="";
	if(!resourceId.equals("") && !resourceDesc.equals(""))			
		resourceType_2="P";
	else		   
		resourceType_2="";
			

	//Ends here
%>
		<%if(!from_page.equals("reports") && !from_page.equals("stats") && !from_page.equals("change_resource") && !from_page.equals("bulk1") && !from_page.equals("schedule_appt") && !from_page.equals("schedule_appt_diff")&& !from_page.equals("reports_bulk") && !from_page.equals("appt_dairy") && !from_page.equals("reports1") && !from_page.equals("reports_listappt") && !from_page.equals("vw_book_appt_wtlist")) {%>

		<TD class="label"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

		<%}%>
		<%if(from_page.equals("create_wl")) {%>

		<TD class="fields" nowrap><input type="hidden" name=resourceType id=resourceType value=""><input type=text name='practitioner_name' id='practitioner_name' disabled onblur="onblurcheck1(this,practitioner_name,'<%=locale%>')" size='25' maxlength='30'  ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  disabled name='search_pract' id='search_pract' onClick="if(document.forms[0].location.value!=''){callPractSearch1(this,practitioner_name,'<%=locale%>');}"> <font  id='pract_type'  nowrap> </font>
		</TD>

		<%}else if(from_page.equals("schedule_appt")){
			%>
		
		<td class=label nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				  
			  <td class='fields'>
					<SELECT name='resourceType_1' id='resourceType_1'  onchange="enable_dsiable_res(this)" >
					<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					</SELECT>

					
			  </td>

		<input type="hidden" name=resourceType id=resourceType value="">
		
		<TD class="label"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		<td  class='label'><input type=text name='practitioner_name' id='practitioner_name'  value='<%=resourceDesc%>'  onblur="onblurcheck1(this,practitioner_name,'<%=locale%>')" size='25' maxlength='30' ><input type=hidden name='practitioner' id='practitioner'  value='<%=resourceId%>' size='30' maxlength='30' ></input><input type='button' class='button' value='?'   name='search_pract' id='search_pract' onClick="callPractSearch1(this,practitioner_name,'<%=locale%>');"><input type=hidden name='resourceType_2' id='resourceType_2'  value='<%=resourceType_2%>' size='30' maxlength='30' ><span style="FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;PADDING-LEFT:10px;PADDING-RIGHT:15px" ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></span><select name='schedule_gender' id='schedule_gender' onChange="">
						<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
					</select></TD>
		<!-- Added Above Line for this CRF [Bru-HIMS-CRF-167] & Above line Modified for this SCF [ML-BRU-SCF-0692]--></tr>

		<%}else if(from_page.equals("transfer_cancel")){%>

		<TD class="fields" nowrap><input type="hidden" name=resourceType id=resourceType value=""><input type=text name='practitioner_name' id='practitioner_name' disabled onblur="onblurcheck1(this,practitioner_name,'<%=locale%>');chk_pract_value(practitioner_name);" size='25' maxlength='30'  ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  disabled name='search_pract' id='search_pract' onClick="if(document.forms[0].b_loc.value!=''){callPractSearch1(this,practitioner_name,'<%=locale%>');chk_pract_value(practitioner_name);}"></TD>
		<td  class="label"><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
		<TD class="queryData"  id='pract_type1' width = '15%' nowrap><font  id='pract_type'  nowrap></td></tr>

		<%}else if(from_page.equals("query") || from_page.equals("reprint")){%>

		<TD class="fields" nowrap><input type=text name='practitioner_name' id='practitioner_name' disabled onblur="onblurcheck1(this,practitioner_name,'<%=locale%>')" size='25' maxlength='30'  ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  disabled name='search_pract' id='search_pract' onClick="callPractSearch1(this,practitioner_name,'<%=locale%>');"><img id = 'imgpract' style='visibility:hidden' src='../../eCommon/images/mandatory.gif' ></img></TD>
		</TD>

		<%}else if(from_page.equals("bulk")){%>

		<TD class="fields" nowrap><input type=text name='practitioner_name' id='practitioner_name' disabled onblur="onblurcheck1(this,practitioner_name,'<%=locale%>')" size='25' maxlength='30'  ><input type="hidden" name=resourceType id=resourceType value=""><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  disabled name='search_pract' id='search_pract' onClick="if(document.forms[0].from_locn.value!=''){callPractSearch1(this,practitioner_name,'<%=locale%>');}"><img id = 'imgpract' style='visibility:hidden' src='../../eCommon/images/mandatory.gif' ></img></TD>

		<td class='label' colspan=1>&nbsp;</td>

		<TD class="fields" nowrap><input type=text name='practitioner_name2' id='practitioner_name2' disabled onblur="onblurcheck1(this,practitioner_name2,'<%=locale%>')" size='25' maxlength='30'  ><input type="hidden" name=resourceType2 id=resourceType2 value=""><input type=hidden name='practitioner2' id='practitioner2'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  disabled name='search_pract2' id='search_pract2' onClick="if(document.forms[0].to_locn.value!=''){callPractSearch1(this,practitioner_name2,'<%=locale%>');}"><img id = 'imgpract2' style='visibility:hidden' src='../../eCommon/images/mandatory.gif' ></img></TD>

		<%}else if(from_page.equals("schedule") || from_page.equals("block") || from_page.equals("block_lift_cancel")|| from_page.equals("duty_roaster") ){ 
			String visibilityFlag="hidden";
			if(from_page.equals("duty_roaster")){
				visibilityFlag="";
			}
		%>
		<TD class="fields" nowrap colspan='3'><input type=text name='practitioner_name' id='practitioner_name' disabled onblur="onblurcheck1(this,practitioner_name,'<%=locale%>')" size='25' maxlength='30'  ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  disabled name='search_pract' id='search_pract' onClick="if(document.forms[0].location.value!='')callPractSearch1(this,practitioner_name,'<%=locale%>');"><img id = 'imgpract' style='visibility:<%=visibilityFlag%>' src='../../eCommon/images/mandatory.gif' ></img></TD>

		<%}else if(from_page.equals("wait_list_modify")){%>

		<TD class="fields" nowrap colspan='3'><input type=text name='practitioner_name' id='practitioner_name' value="<%=pract_value%>"  onblur="onblurcheck1(this,practitioner_name,'<%=locale%>')" size='25' maxlength='30'  ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' value='<%=pract_id%>' ></input><input type='button' class='button' value='?'   name='search_pract' id='search_pract' onClick="callPractSearch1(this,practitioner_name,'<%=locale%>');"><img id = 'imgpract' style='visibility:hidden' src='../../eCommon/images/mandatory.gif' ></img></TD>

		<%}else if(from_page.equals("schedule_appt_diff")){%>

		<td class=label nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				  
			  <td class='fields'>
					<SELECT name='resourceType_1' id='resourceType_1'  onchange="enable_dsiable_res(this)" >
					<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					</SELECT>

					
			  </td>

		<input type="hidden" name=resourceType id=resourceType value="">
		
		<TD class="label"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		<td class='label'><input type=text name='practitioner_name' id='practitioner_name' disabled value="<%=pract_value%>"  onblur="onblurcheck1(this,practitioner_name,'<%=locale%>')" size='25' maxlength='30'  ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' value="<%=pract_id%>"></input><input type='button' class='button' value='?'  disabled name='search_pract' id='search_pract' onClick="callPractSearch1(this,practitioner_name,'<%=locale%>');"><span style="FONT-SIZE: 8pt;TEXT-ALIGN: LEFT;PADDING-LEFT:10px;PADDING-RIGHT:15px" ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></span><select name='schedule_gender' id='schedule_gender' onChange="">
						<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
					</select></TD>
		<!-- Added Above Line for this CRF [Bru-HIMS-CRF-167] & Above line Modified for this SCF [ML-BRU-SCF-0692]--></tr>
		
				
		<%}else if(from_page.equals("change_resource")){%>

		<td class='label' ><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

		<td class='fields'>
        <input type='text'  name='pract_from_desc' id='pract_from_desc' disabled onblur = " onblurcheck1(this,pract_from_desc,'<%=locale%>');" size=30 maxlength=30 onChange='clearDetail();'tabindex=7><input type='hidden' name='pract_from' id='pract_from' value="" onChange='clearDetail();'><input type='button' class='button' name='from' id='from' value='?' disabled  onClick="callPractSearch1(this,pract_from_desc,'<%=locale%>');"><img src='../../eCommon/images/mandatory.gif'></img></td>

		<td class='label' ><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		
		<td class='fields'><input type='text'  name='pract_to_desc' id='pract_to_desc' disabled  onblur = "onblurcheck1(this,pract_to_desc,'<%=locale%>')" size=30 maxlength=30 onChange='clearDetail();' tabindex=8><input type='hidden' name='pract_to' id='pract_to' value="" onChange='clearDetail();'><input type='button' class='button' name='to' id='to' value='?' disabled  onClick="callPractSearch1(this,pract_to_desc,'<%=locale%>')"><img src='../../eCommon/images/mandatory.gif'></img>	</td> 


		<%}else if(from_page.equals("reports") || from_page.equals("reports1")) {%>
		<tr>
			<td   class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_pract_id" id="p_fm_pract_id" disabled onblur ="onblurcheck_rep(this,p_fm_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button' disabled onclick="callPractSearch_rep(this, p_fm_pract_id)">
			</td>


			<td class='fields'>
				<input type="text" name="p_to_pract_id" id="p_to_pract_id" disabled onblur="onblurcheck_rep(this,p_to_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1' disabled value='?' class='button' onclick='callPractSearch_rep(this, p_to_pract_id)'>
			</td>
		</tr>
		<%}else if(from_page.equals("reports1")) {%>
		<tr>
			<td  align="right" class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_pract_id" id="p_fm_pract_id" disabled onblur ="onblurcheck_rep(this,p_fm_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button' disabled onclick="callPractSearch_rep(this, p_fm_pract_id)">
			</td>


			<td class='fields'>
				<input type="text" name="p_to_pract_id" id="p_to_pract_id" disabled onblur="onblurcheck_rep(this,p_to_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1' disabled value='?' class='button' onclick='callPractSearch_rep(this, p_to_pract_id)'>
			</td>
		</tr>
		<%}else if(from_page.equals("stats")) {%>
		<tr>
			<td  class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_pract_id" id="p_fm_pract_id" disabled onblur ="onblurcheck_rep(this,p_fm_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button' disabled onclick="callPractSearch_rep(this, p_fm_pract_id)">
			</td>
			
			<td class='label' colspan=1>&nbsp;</td>

			<td class='fields'>
				<input type="text" name="p_to_pract_id" id="p_to_pract_id" disabled onblur="onblurcheck_rep(this,p_to_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1' disabled value='?' class='button' onclick='callPractSearch_rep(this, p_to_pract_id)'>
			</td>
			
		</tr>

		<%}else if(from_page.equals("reports_bulk")){%>
				
			<tr><td  class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="p_fm_pract_id" id="p_fm_pract_id" disabled onblur ="onblurcheck_rep_bulk(this,p_fm_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button' disabled onclick="callPractSearch_rep_bulk(this, p_fm_pract_id)">
			</td>


			<td class='fields'>
				<input type="text" name="p_to_pract_id" id="p_to_pract_id" disabled onblur="onblurcheck_rep_bulk(this,p_to_pract_id)" size="15" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1' disabled value='?' class='button' onclick='callPractSearch_rep_bulk(this, p_to_pract_id)'>
			</td>
			</tr>
		<%}else if(from_page.equals("reports_listappt")){%>
			<tr><td align="right" class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
				<input type="text" name="P_FM_PRACT_ID" id="P_FM_PRACT_ID"  onblur ="onblurcheck_rep_listappt(this,P_FM_PRACT_ID)" size="15" maxlength="15" ><input type='button' name='pract_id' id='pract_id' value='?' class='button'  onclick="callPractSearch_rep_listappt(this,P_FM_PRACT_ID)">
			</td>


			<td class='fields'>
				<input type="text" name="P_TO_PRACT_ID" id="P_TO_PRACT_ID"  onblur="onblurcheck_rep_listappt(this,P_TO_PRACT_ID)" size="15" maxlength="15" ><input type='button' name='pract_id1' id='pract_id1'  value='?' class='button' onclick='callPractSearch_rep_listappt(this,P_TO_PRACT_ID)'>
			</td>
			</tr>
		<%}else if(from_page.equals("appt_dairy")){%>
			<tr><td align="right" class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap>
			<input type=text name='practitioner_name' id='practitioner_name' value="<%=pract_value%>"  onblur="onblurcheck1(this,practitioner_name,'<%=locale%>');" size='25' maxlength='30' ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' ><input type='button' name='search_pract' id='search_pract' value='?' class='button'  onclick="callPractSearch1(this,practitioner_name,'<%=locale%>');change_schedule(practitioner,practitioner_name);">
			<!--Above Line Modified for this SCF ML-BRU-SCF-0240 [IN:033238] -->
			
			
			</td>
			</tr>
		<%}else if(from_page.equals("vw_book_appt_wtlist")){
			%>
		
		<td class=label nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				  
			  <td class='fields'>
					<SELECT name='resource_type' id='resource_type'  onchange="enable_dsiable_res(this)" >
					<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					</SELECT>

					
			  </td>		
			<TD class="label"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			<td><input type=text name='practitioner_name' id='practitioner_name'  value='<%=resourceDesc%>'  onblur="resource_search(this,practitioner_name,'<%=locale%>')" size='25' maxlength='30' ><input type=hidden name='practitioner' id='practitioner'  value='' size='30' maxlength='30' ></input><input type='button' class='button' value='?'   name='search_resource' id='search_resource' onClick="resource_search_lookup(this,practitioner_name,'<%=locale%>');"></TD>
		<!-- <td  class="label"><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
		<TD class="queryData"  id='pract_type1' width = '15%' nowrap><font  id='pract_type'  nowrap></td> --></tr>

		<%}%>
	

	<input type='hidden' name='specialty_code1' id='specialty_code1' value=''>
	<input type='hidden' name='location_code1' id='location_code1' value=''>
	<input type='hidden' name='locationType1' id='locationType1' value=''>
	<input type='hidden' name='resourceType1' id='resourceType1' value=''>
	<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>'>
	<input type='hidden' name='from_page' id='from_page' value='<%=from_page%>'>
	<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'> <!--Added by S.Sathish for IN020571 on Thursday, April 08, 2010-->

	<input type='hidden' name='specialty_code2' id='specialty_code2' value=''>
	<input type='hidden' name='location_code2' id='location_code2' value=''>
	<input type='hidden' name='locationType2' id='locationType2' value=''>
	<input type='hidden' name='resourceType3' id='resourceType3' value=''>
	

