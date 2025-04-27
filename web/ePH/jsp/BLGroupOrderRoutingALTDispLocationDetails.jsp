<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../ePH/js/BLGroupOrderRouting.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="AltDisplocnDeatil" id="AltDisplocnDeatil" >
<%
		try{
			String bean_id					=   "BLGroupOrderRoutingBean" ;
			String bean_name				=	"ePH.BLGroupOrderRoutingBean";
			String ord_src_code				=   request.getParameter("ord_src_code");	  
			String order_fcy				=	request.getParameter("order_fcy");
			String ord_src_type				=	request.getParameter("ORD_SRC_TYPE");
			String perform_fcy				=	request.getParameter("perform_fcy");
			String disp_loc				    =	request.getParameter("disp_loc");
			String disp_loc_code            =   request.getParameter("disp_locn_code");
			String eff_status               =   request.getParameter("eff_status");
			String mode                     =   request.getParameter("mode");
			String rout_level               =   request.getParameter("rout_level");
			String rout_code                =   request.getParameter("rout_code");
			String billing_group                =   request.getParameter("billing_group");
			String day_type                 =   request.getParameter("day_type_value");
			String id                       =   request.getParameter("id");
			String flag_mode="";
			
			if(mode.equals("UPDATE"))
			    flag_mode="U";
			else if(mode.equals("1"))
				flag_mode="I";
			else if(mode.equals("2"))
				flag_mode="M";

			if(eff_status == null){
				eff_status="";
			}
			if(disp_loc_code == null){
				disp_loc_code=disp_loc;
			}
			
			String select_status	=	"";
			String select_flag	=	"";
			String flag				=	"";
			String frmtime          =   "";
			String totime           =   "";
			String repeat			=	"";
			String classvalue	    =   "";
			String prevCode="";
			String butnFlag="Y";
			String ALT_details_visible="visibility:hidden";
			int i=1;
			ArrayList altdisplocns			= null;
			ArrayList altdisplocns1			=null;
			HashMap tempaltdisp			=new HashMap();;
			HashMap stat= new HashMap();
			HashMap rtn=new HashMap();
			HashMap D=new HashMap();
			if ( bean_id == null || bean_id.equals( "" ) ) 
				return ;
			BLGroupOrderRoutingBean bean=(BLGroupOrderRoutingBean)getBeanObject( bean_id, bean_name, request);
			bean.setLanguageId(locale);
			String facility_id	= (String) session.getValue( "facility_id" ) ;
			String facility_name = "";
			ArrayList facilities = new ArrayList();
			facilities = bean.getFacilities();
			String SEL1 ="";
			for ( int j=0; j<facilities.size(); j += 2) {
				if(facility_id.equals((String)facilities.get(j))) {
					facility_name = (String)facilities.get(j+1);
				}
			}
			if(mode.equals("UPDATE") || mode.equals("1")){
				altdisplocns1=bean.getAltDispData();
			}
			else if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )))
				altdisplocns=bean.getLocns(ord_src_type,perform_fcy,order_fcy,"");
			else if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
				altdisplocns=bean.getaltdisplocmodify(ord_src_type,perform_fcy,order_fcy,ord_src_code,day_type,disp_loc_code,rout_level,rout_code,id);
			if(mode.equals("UPDATE") || mode.equals("1")){
				
				String key ;
				Set keyset;
				for(int k=0;k<altdisplocns1.size();k+=3){
					rtn=(HashMap)altdisplocns1.get(k);
					stat=(HashMap)altdisplocns1.get(k+1);
					D=(HashMap)altdisplocns1.get(k+2);
				}
				
				if(id.equals("R") && (rtn!=null || !rtn.equals(""))){
						keyset = rtn.keySet() ;
						String temp_displocn=disp_loc_code+"~R";//added for MMS_BETA_0043[046240]; 
					if(keyset.size()>0){
						Iterator keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(temp_displocn)){ // added temp_displocn instead of disp_loc_code for MMS_BETA_0043[046240]; 
								tempaltdisp  = (HashMap)rtn.get(key);
							}
						}
					}
					keyset = tempaltdisp.keySet() ;
					if(keyset.size()>0){
						Iterator keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(rout_level+"~"+rout_code+"~"+billing_group+"~"+disp_loc_code+"~"+day_type)){
								altdisplocns  = (ArrayList)tempaltdisp.get(key);
							}
						}
					}
					else{
						altdisplocns=bean.getLocns(ord_src_type,perform_fcy,order_fcy,"");
					}
				}
				if( id.equals("S") && (stat!=null || !stat.equals(""))){
						keyset = rtn.keySet() ;
						String temp_displocn=disp_loc_code+"~S";//added for MMS_BETA_0043[046240]; 
					if(keyset.size()>0){
						Iterator keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(temp_displocn)){// added temp_displocn instead of disp_loc_code for MMS_BETA_0043[046240]; 
								tempaltdisp=(HashMap)rtn.get(key);
							}
						}
					}
					if(tempaltdisp!=null){
					keyset = stat.keySet() ;
					if(keyset.size()>0){
						Iterator keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(temp_displocn)){// added temp_displocn instead of disp_loc_code for MMS_BETA_0043[046240]; 
								tempaltdisp  = (HashMap)stat.get(key);
							}
						}
					}
					}
					keyset = tempaltdisp.keySet() ;
					if(keyset.size()>0){
						Iterator keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(rout_level+"~"+rout_code+"~"+billing_group+"~"+disp_loc_code+"~"+day_type)){
								altdisplocns  = (ArrayList)tempaltdisp.get(key);
							}
						}
					}
					else
						altdisplocns=bean.getLocns(ord_src_type,perform_fcy,order_fcy,"");
				}

				if(id.equals("D")  && !(D==null || D.equals(""))){
					keyset = rtn.keySet() ;
					String temp_displocn=disp_loc_code+"~D";//added for MMS_BETA_0043[046240]; 
					if(keyset.size()>0){
						Iterator keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(temp_displocn)){ // added temp_displocn instead of disp_loc_code for MMS_BETA_0043[046240];
								tempaltdisp=(HashMap)rtn.get(key);
							}
						}
					}
					if(tempaltdisp!=null){
						keyset = D.keySet() ;
					if(keyset.size()>0){
						Iterator keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(temp_displocn)){// added temp_displocn instead of disp_loc_code for MMS_BETA_0043[046240]; 
								tempaltdisp  = (HashMap)D.get(key);
							}
						}
					}
					}
					keyset = tempaltdisp.keySet() ;
					if(keyset.size()>0){
						Iterator keyiterator= keyset.iterator() ;
						while(keyiterator.hasNext()){
							key   = (String)keyiterator.next();
							if(key.equals(rout_level+"~"+rout_code+"~"+billing_group+"~"+disp_loc_code+"~"+day_type)){
								altdisplocns  = (ArrayList)tempaltdisp.get(key);
							}
						}
					}
					else
					altdisplocns=bean.getLocns(ord_src_type,perform_fcy,order_fcy,"");
				}
				
				if(altdisplocns==null)
					altdisplocns=bean.getLocns(ord_src_type,perform_fcy,order_fcy,"");
			}
%>
			<TABLE BORDER="2" CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" id="AltDspLoc">	
				<tr>
					<th> <fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.totime.label" bundle="${common_labels}"/></th>
					<th>&nbsp;</th>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				</tr>
				<tr>
<%
				HashMap record=new HashMap();
				String code="",desc="";
				for(int t=0;t<altdisplocns.size();t++){
					select_status		=	"";
					select_flag		=	"N";
					record	=(HashMap)altdisplocns.get((t));
					code		=	(String)record.get("code");
					desc		=	(String)record.get("desc");
					flag		=	(String)record.get("flag");
					eff_status =(String)record.get("eff_status");
					if(mode.equals("2") || mode.equals("UPDATE")){
						eff_status    =	(String)record.get("eff_status");
					}
					frmtime	=   (String)record.get("frmtime");
					totime		=   (String)record.get("totime");
					if(frmtime.equals("00:00") || totime.equals("00:00")){
                        frmtime="";
					    totime="";
					}

					repeat	=(String)record.get("repeat");
					
					if(frmtime==null)
						frmtime="";
					if(totime==null)
						totime="";

					if(eff_status.equals("E")){
						if(flag.equals("I")){
							select_status="checked";
							select_flag="Y";
						} 
					}
					else if( eff_status.equals("D")){
						select_status="unchecked";
						select_flag="Y";
					}
					if (prevCode.equals(""))
						butnFlag="Y";
						
					if(prevCode.equals(code)) 
						butnFlag="N";
					else 
						butnFlag="Y";

					if(!code.equals(disp_loc_code)){
						if ( i % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;
%>
							<td width="10%" class="<%=classvalue%>"><%=desc%></td>
							<td class="<%=classvalue%>" width="10%"><input type=text name="frmtime_<%=i%>" id="frmtime_<%=i%>" value="<%=frmtime%>"  maxlength='5' size='5' onkeypress="return allowPositiveNumber()" onblur="appedzero(this);validtime(this,totime_<%=i%>);">
							</td>
							<td class="<%=classvalue%>" width="10%"><input type=text name="totime_<%=i%>" id="totime_<%=i%>" value="<%=totime%>"  maxlength='5' size='5' onkeypress="return allowPositiveNumber()" onChange="toggleCheckBox(this,'<%=i%>',true);appedzero(this);validtime(frmtime_<%=i%>,this)">
							</td>
<%     
							if(select_status=="checked" && butnFlag=="Y"){
%>
							<td class="<%=classvalue%>" align="center" width="2%" ><input type='button' name="addRow_<%=i%>" id="addRow_<%=i%>" class='button' align="right" onclick="generateRow(this,<%=i%>,'<%=desc%>','<%=code%>')" value=' V '> 
							</td>
<%     
						}
						else if(select_status=="checked" && butnFlag=="N"){
%>
							 <td class="<%=classvalue%>" align="center" width="2%" >
							   <input type='button' name="rem_<%=i%>" id="rem_<%=i%>" class='button' align="right" onClick="setflag(<%=i%>);removeRow(this);" value=' X ' > 
							 </td>
<%   
						}
						else{
%>
							<td class="<%=classvalue%>" align="center" width="2%" >
		                     <input type='button' style="visibility:hidden" name="addRow_<%=i%>" id="addRow_<%=i%>" class='button' align="right" onclick="generateRow(this,<%=i%>,'<%=desc%>','<%=code%>')" value=' V '> 
		                   </td>
<%
						}
%>
						<td class="<%=classvalue%>" width="6%"><input type=checkbox name="select_<%=i%>" id="select_<%=i%>"  <%=select_status%> onClick="assignValue(this,<%=i%>);clearValue(this,'<%=i%>')">
						</td>
						<input type="hidden" name="code_<%=i%>" id="code_<%=i%>" value="<%=code%>">
						<input type="hidden" name="flag_<%=i%>" id="flag_<%=i%>" value="<%=select_flag%>">
						<input type="hidden" name="number_<%=i%>" id="number_<%=i%>" value="<%=i%>">
						<input type="hidden" name="arrVal_<%=i%>" id="arrVal_<%=i%>" value="<%=frmtime%>">
						<input type="hidden" name="dbVal_<%=i%>" id="dbVal_<%=i%>" value="<%=frmtime%>">
						<input type="hidden" name="repeat_<%=i%>" id="repeat_<%=i%>" value="<%=repeat%>"> 
					</tr>
<%
					if(eff_status.equals("E") ){
%>
						<input type='hidden' name="enable_<%=i%>" id="enable_<%=i%>" value="<%=eff_status%>">
<%
					}
					else{
%>
						<input type='hidden' name="enable_<%=i%>" id="enable_<%=i%>" value="<%=eff_status%>">
<%
					}
					i++;
				}
				
				prevCode=code;
			}
%>
			</table>
			<INPUT TYPE="hidden"	name="count" id="count"	VALUE="<%=i%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="locn_desc" id="locn_desc" value="<%= disp_loc_code %>">
			<input type="hidden" name="ord_src_type" id="ord_src_type" value="<%= ord_src_type %>">
			<input type="hidden" name="perform_fcy" id="perform_fcy" value="<%= perform_fcy %>">
			<input type="hidden" name="id" id="id" value="<%= id %>">
			<input type="hidden" name="order_fcy" id="order_fcy" value="<%= order_fcy %>">
			<input type="hidden" name="day_type" id="day_type" value="<%= day_type %>">
			<input type="hidden" name="disp_loc_code" id="disp_loc_code" value="<%= disp_loc_code %>">
			<input type="hidden" name="ord_src_code" id="ord_src_code" value="<%= ord_src_code %>">
			<input type="hidden" name="mode" id="mode" value="<%= mode %>">
			<input type="hidden" name="flag_mode" id="flag_mode" value="<%= flag_mode %>">
<% 
			putObjectInBean(bean_id,bean,request);
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
%>
		</form>
	</body>
</html>

