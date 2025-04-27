<!DOCTYPE html>
<html>
	<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* ,eCommon.XSSRequestWrapper " %>

	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");		
		String locale=(String)session.getAttribute("LOCALE");
		StringTokenizer splty_token=null;
		String addtl_splty_1="";
		String addtl_splty_2="";
		int k=0;
		if(!addtl_splty.equals("")){
			splty_token=new StringTokenizer(addtl_splty,",");
			k=0;
			while(splty_token.hasMoreTokens()){
				if(k==0){
					addtl_splty_1=splty_token.nextToken();
				}else{
					addtl_splty_2=splty_token.nextToken();
				}
				k++;
			}
		}
	
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			var count=0;
			var addtlArray =new Array(2);
			function selectCheck(obj,objValue,recNo){
				if(obj.checked){
					count=parseInt(count)+1;
					if(count > 2){
						alert(getMessage('MAX_2_SPLTY','OA'));
						obj.checked=false;
						count=count-1;
					}else{
						parent.button_frame.document.getElementById('spltyDisp').style.display="";
						if(parseInt(count)==1){
							parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value=eval("parent.result_frame.addtl_splty_result_form.code"+recNo).value;
							parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value=eval("parent.result_frame.addtl_splty_result_form.desc"+recNo).value;
						}else{
							parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value+","+eval("parent.result_frame.addtl_splty_result_form.code"+recNo).value;
							parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value+"^"+eval("parent.result_frame.addtl_splty_result_form.desc"+recNo).value;
						}
						parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_cnt.value=count;
						var retValArr=(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value).split(",");
						var descArr=(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value).split("^");
						for (var cnt = 1; cnt <=count; cnt++) {
							if(cnt==1){
								parent.button_frame.document.getElementById('divCode1').innerHTML=retValArr[0];
								parent.button_frame.document.getElementById('divDesc1').innerHTML=descArr[0];
							}else{
								parent.button_frame.document.getElementById('divCode2').innerHTML=retValArr[1];
								parent.button_frame.document.getElementById('divDesc2').innerHTML=descArr[1];
							}
						}
						/*//parent.button_frame.document.getElementById("innerHTML")
						//parent.button_frame.location.href="../../eOA/jsp/OAAdditionalSpecialtyButton.jsp?addtl_splty="+parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value;
						var parentDiv=parent.button_frame.document.getElementById('spltyData');
						var newdiv = parent.button_frame.document.createElement('div');
						newdiv.setAttribute('id',"One");
						newdiv.style.position="absolute";
						newdiv.style.height="20px";
						newdiv.style.width="150px";
						newdiv.innerHTML = 'Element Number 12 has been added! ';
						parentDiv.appendChild(newdiv);


						<div style="position: absolute;left:0;width :150px;height: 20px;BACKGROUND-COLOR: #B0949B;">ENT</div>
				<div style="position: absolute;left:150px;width :550px;height: 20px;BACKGROUND-COLOR: #5EF2A6;">Ent Specialty</div>*/
					}
				}else{
					count=parseInt(count)-1;
					parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_cnt.value=count;
					parent.button_frame.document.getElementById('divCode1').innerHTML="";
					parent.button_frame.document.getElementById('divDesc1').innerHTML="";
					parent.button_frame.document.getElementById('divCode2').innerHTML="";
					parent.button_frame.document.getElementById('divDesc2').innerHTML="";
					if(count ==0){
						parent.button_frame.document.getElementById('spltyDisp').style.display="none";
						parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value="";
						parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value="";
					}else{
						var retValArr=(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value).split(",");
						var descArr=(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value).split("^");
						if(objValue==retValArr[0]){
							parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value=retValArr[1];
							parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value=descArr[1];
						}else{
							parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value=retValArr[0];
							parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value=descArr[0];
						}
						parent.button_frame.document.getElementById('divCode1').innerHTML=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty.value;
						parent.button_frame.document.getElementById('divDesc1').innerHTML=parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_desc.value;
					}
				}
			}
			function default_values(){
				count=parseInt(parent.criteria_frame.addtl_splty_criteria_form.addtl_splty_cnt.value);
			}
		</script>
	</head>
	<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String code="";
		String desc="";
		String search_by=request.getParameter("search_by")==null?"":request.getParameter("search_by");
		String start_ends_contains=request.getParameter("start_ends_contains")==null?"":request.getParameter("start_ends_contains");
		String search_text=request.getParameter("search_text")==null?"":request.getParameter("search_text");
		try{
			con = ConnectionManager.getConnection(request);
			StringBuffer sql=new StringBuffer("select speciality_code,short_desc from am_speciality_lang_vw where language_id='"+locale+"'");
			if(!search_text.equals("")){
				if(start_ends_contains.equals("S")){
					if(search_by.equals("D")){
						sql.append(" and upper(short_desc) like upper('"+search_text+"%')");
					}else{
						sql.append(" and upper(speciality_code) like upper('"+search_text+"%')");
					}
				}else if(start_ends_contains.equals("E")){
					if(search_by.equals("D")){
						sql.append(" and upper(short_desc) like upper('%"+search_text+"')");
					}else{
						sql.append(" and upper(speciality_code) like upper('%"+search_text+"')");
					}
				}else if(start_ends_contains.equals("C")){
					if(search_by.equals("D")){
						sql.append(" and upper(short_desc) like upper('%"+search_text+"%')");
					}else{
						sql.append(" and upper(speciality_code) like upper('%"+search_text+"%')");
					}
				}
			}
			sql.append(" order by short_desc");
			pstmt = con.prepareStatement(sql.toString());
			
			rs=pstmt.executeQuery();
	%>
	<body onload='default_values()' onKeyDown = 'lockKey()'>
	<form name="addtl_splty_result_form" id="addtl_splty_result_form">
		<div style="position:relative;height:400px;overflow:auto">


					<%
						String classValue = "" ;						
						int i=0;
						int checked_count=0;
						String checkedStr="";
						while(rs!=null && rs.next()){
							checkedStr="";
							if(i==0){%>
								<table border="1" cellspacing="0" cellpadding="0" width="100%" >
									<thead id="TabHead">
										<tr style="position:relative;top:expression(this.offsetParent.scrollTop)">
											<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
											<th ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
											<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
										</tr>
										<tr></tr>
										</thead>
							<%}
							if ( i % 2 == 0 ){
								classValue = "QRYEVEN" ;
							}else{
								classValue = "QRYODD" ;
							}
							code=rs.getString("speciality_code");
							desc=rs.getString("short_desc");							
							if(!addtl_splty_1.equals("") || !addtl_splty_2.equals("")){
								if(code.equals(addtl_splty_1) || code.equals(addtl_splty_2)){
									checkedStr="checked";
									checked_count++;
								}
							}
						%>
						<tbody>
							<tr>
								<td class=<%=classValue%>><%=code%></td>
								<td class=<%=classValue%>><%=desc%></td>
								<td class=<%=classValue%>><input type='checkbox' name='check<%=i%>' id='check<%=i%>' onclick='selectCheck(this,"<%=code%>","<%=i%>","<%=code%>")' <%=checkedStr%>></td>
								<input type='hidden' name="code<%=i%>" id="code<%=i%>" value="<%=code%>">
								<input type='hidden' name="desc<%=i%>" id="desc<%=i%>" value="<%=desc%>">
							</tr>
						</tbody>
						<%
						i++;
						}
					%>
				</table>
			</div>
			<%if(i==0){
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
					}%>
			<input type='hidden' name="checked_count" id="checked_count" value="<%=checked_count%>">
			<input type='hidden' name="addtl_splty_1" id="addtl_splty_1" value="<%=addtl_splty_1%>">
			<input type='hidden' name="addtl_splty_2" id="addtl_splty_2" value="<%=addtl_splty_2%>">
			<input type='hidden' name="recordCount" id="recordCount" value="<%=i%>">
			<input type='hidden' name="selectedCount" id="selectedCount" value="">
		</form>
	</body>
	<%}catch(Exception e){
		e.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(con,request);
	}%>
</html>

