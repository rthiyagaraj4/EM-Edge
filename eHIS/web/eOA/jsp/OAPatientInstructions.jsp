<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" import="java.sql.*, java.net.*, webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale=(String)session.getAttribute("LOCALE");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	Connection connection = null;
	Statement stmt = null;
	ResultSet rset = null;
	String ins_dec="";
	String instruction_id="";
	String display_order="";
	String default_linked_yn="";
	String checkValue="";
	String valueObject="";
	Integer inObj=null;
	String clinic_visibility="";
	String proc_visibility="";
	String proc_display="";
	String clinic_display="";
	int recCount=1;
	//Set  keySet=null;
	//Iterator setIterator=null;

%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	  
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>       
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eOA/js/OAPatientInstructions.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	try{
		connection = ConnectionManager.getConnection(request);
		HashMap patInstructionsMap=(java.util.HashMap)session.getAttribute("patInstructionsMap");
		HashMap prcInstructionMap=(java.util.HashMap)session.getAttribute("prcInstructionMap");
		//HashMap patInsMapBasic=new HashMap();
		//HashMap displayMap=new HashMap();
		//String order_stand_ins="";
		//String pat_preps_or_instrns_ind="";
		String patInsColSize="68";
		String prcInsColSize="68";
		int procInsCount=0;
		int patInsCount=0;
		String prcCheckFlag="";
		//String appt_pat_ins="";
		//String appt_prc_ins="";
		String disabledTextArea="";
		String from_page=request.getParameter("from_page")==null?"":request.getParameter("from_page");
		//String appt_refno=request.getParameter("appt_refno")==null?"":request.getParameter("appt_refno");
		String viewinsdtlsYN=request.getParameter("viewinsdtlsYN")==null?"N":request.getParameter("viewinsdtlsYN");
		String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
		String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
		String pending_order_catalog_code=request.getParameter("pending_order_catalog_code")==null?"":request.getParameter("pending_order_catalog_code");
		String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String clinicInsYN=request.getParameter("clinicInsYN")==null?"N":request.getParameter("clinicInsYN");
		String orderInsYN=request.getParameter("orderInsYN")==null?"N":request.getParameter("orderInsYN");
		String orderInsStandardYN=request.getParameter("orderInsStandardYN")==null?"N":request.getParameter("orderInsStandardYN");
		String addInstructionYN=request.getParameter("addInstructionYN")==null?"N":request.getParameter("addInstructionYN");
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		//String date_of_birth=request.getParameter("date_of_birth")==null?"":request.getParameter("date_of_birth");
		//String gender=request.getParameter("gender")==null?"":request.getParameter("gender");
		String addCode=request.getParameter("addCode")==null?"":request.getParameter("addCode");
		String addDesc=request.getParameter("addDesc")==null?"":request.getParameter("addDesc");
		
		if(clinicInsYN.equals("Y")){
			proc_visibility="hidden";
			proc_display="none";
		}else{
			clinic_visibility="hidden";
			clinic_display="none";
			proc_visibility="";
			proc_display="";
		}
		if(patInstructionsMap!=null){
			patInsCount=patInstructionsMap.size();
		}
		if(prcInstructionMap!=null){
			if(prcInstructionMap.size()>0){
				procInsCount++;
				String checkedValue=(String)prcInstructionMap.get("checked");
				if(checkedValue!=null && checkedValue.equals("Y")){
					prcCheckFlag="checked";
				}
			}
		}
		if(from_page.equals("view_dtls")){
			disabledTextArea="readonly";
			patInsColSize="83";
			prcInsColSize="83";
		}
%>
<body onKeyDown='lockKey()' onLoad='loadInstruciotnsCheck()'>
<form name='patInsForm' id='patInsForm' >
	<%if(patInsCount >0 || procInsCount>0){%>
		<div id='patinsheaderID'>
		<table width='610'>
			<th width='500'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<%if(!(from_page.equals("view_dtls"))){%>
			<th width='30'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;</th>
			<%}%>
		</table>
		</div>
	<%}%>
	<div id='patinsID' style='visibility:<%=clinic_visibility%>;display:<%=clinic_display%>;width:630;height:400;overflow-y:auto;overflow-x:no'>
	<table width='610' id='patinsTableID'>
		<%
			for(int countValue=1;countValue<=patInsCount;countValue++){
				default_linked_yn="";
				inObj=new Integer(countValue);
				display_order=inObj.toString();
				valueObject=(String)patInstructionsMap.get(inObj.toString());
				if(valueObject !=null){
					String[] tokens=valueObject.split("\\|~");
					instruction_id=tokens[0];
					ins_dec=tokens[1];
					default_linked_yn=tokens[2];
				}
				if(default_linked_yn.equals("Y")){
					checkValue="checked";
				}else{
					checkValue="";
				}

		%>
				<tr><td><TEXTAREA NAME='descriptionID<%=recCount%>', ROWS=2 COLS=<%=patInsColSize%> id='descriptionID<%=recCount%>' size='200' maxlength='200' onkeypress='checkMaxLimit(this,200);return Allow(event);'onBlur='RemoveSpec()' onpaste='return maxLengthPaste(this,"200")' <%=disabledTextArea%>><%=ins_dec%></TEXTAREA></td><%if(!(from_page.equals("view_dtls"))){%><td><input type='checkbox' id='check_BoxID<%=recCount%>' name='check_BoxID<%=recCount%>' value='' <%=checkValue%>></td><%}%>
				<input type='hidden' name='instructionID_<%=recCount%>' id='instructionID_<%=recCount%>' value='<%=instruction_id%>'/>
				<input type='hidden' name='display_orderID_<%=recCount%>' id='display_orderID_<%=recCount%>' value='<%=countValue%>'/>
				</tr>
		<%
				recCount++;
			}
			if(addInstructionYN.equals("Y")){%>
				<tr><td><TEXTAREA NAME='descriptionID<%=recCount%>', ROWS=2 COLS=<%=patInsColSize%> id='descriptionID<%=recCount%>' size='200' maxlength='200' onkeypress='checkMaxLimit(this,200)' onBlur='RemoveSpec()' onpaste='return maxLengthPaste(this,"200")'><%=addDesc%></TEXTAREA></td><%if(!(from_page.equals("view_dtls"))){%><td><input type='checkbox' id='check_BoxID<%=recCount%>' name='check_BoxID<%=recCount%>' value=''></td><%}%>
				<input type='hidden' name='instructionID_<%=recCount%>' id='instructionID_<%=recCount%>' value='<%=addCode%>'/>
				<input type='hidden' name='display_orderID_<%=recCount%>' id='display_orderID_<%=recCount%>' value='<%=recCount%>'/>
				</tr>
			<%recCount++;}
		%>
	</table>

	</div>
	<%if(procInsCount>0){
		String procDesc=(String)(prcInstructionMap.get("prcIns")==null?"":prcInstructionMap.get("prcIns"));
		if(procDesc==null)procDesc="";
		%>
		<div id='procinsID' style="visibility:<%=proc_visibility%>;display:<%=proc_display%>">
		<table width='610'>
			<tr><td>
				<TEXTAREA name='or_standard_ins' ROWS=5 COLS=<%=prcInsColSize%> size='2000' maxlength='200' onkeypress='checkMaxLimit(this,200)'onpaste='return maxLengthPaste(this,"200")' <%=disabledTextArea%>><%=procDesc%></TEXTAREA></td><%if(!(from_page.equals("view_dtls"))){%><td><input type='checkbox' id='procCheckID' name='procCheck' id='procCheck' value='' <%=prcCheckFlag%>></td><%}%>
			</tr>
		</div>
	<%}%>
	<input type='hidden' name='recCount' id='recCount' value="<%=recCount%>">
	<input type='hidden' name='clinic_code' id='clinic_code' value="<%=clinic_code%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">
	<input type='hidden' name='viewinsdtlsYN' id='viewinsdtlsYN' value="<%=viewinsdtlsYN%>">
	<input type='hidden' name='clinicInsYN' id='clinicInsYN' value="<%=clinicInsYN%>">
	<input type='hidden' name='orderInsYN' id='orderInsYN' value="<%=orderInsYN%>">
	<input type='hidden' name='orderInsStandardYN' id='orderInsStandardYN' value="<%=orderInsStandardYN%>">
	<input type='hidden' name='or_catalogue_code' id='or_catalogue_code' value="<%=or_catalogue_code%>">
	<input type='hidden' name='pending_order_catalog_code' id='pending_order_catalog_code' value="<%=pending_order_catalog_code%>">
	<input type='hidden' name='order_id' id='order_id' value="<%=order_id%>">
	<input type='hidden' name='order_line_num' id='order_line_num' value="<%=order_line_num%>">
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
	<input type='hidden' name='procInsCount' id='procInsCount' value="<%=procInsCount%>">
	<input type='hidden' name='from_page' id='from_page' value="<%=from_page%>">
	</form>
<%	
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(connection,request);
	}
%>
</body>
</html>

