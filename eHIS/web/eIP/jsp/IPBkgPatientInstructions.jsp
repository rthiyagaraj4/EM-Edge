<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" import="java.sql.*, java.util.*, java.net.*, webbeans.eCommon.*,java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	
	String locale=(String)session.getAttribute("LOCALE");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	Connection connection = null;
	Statement stmt = null;
	ResultSet rset = null;
	String ins_dec="";
	String instruction_id="";

	String default_linked_yn="";
	String checkValue="";
	String valueObject="";

	int recCount=1;

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
	<script src='../../eIP/js/IPBkgPatientInstructions.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	try{
		connection = ConnectionManager.getConnection(request);
		TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");

		int patInsCount=0;
		
		String patInsColSize="68";
		
		String disabledTextArea="";
		String from_page=request.getParameter("from_page")==null?"":request.getParameter("from_page");
		String nursing_unit_code=request.getParameter("nursing_unit_code")==null?"":request.getParameter("nursing_unit_code");
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String addCode=request.getParameter("addCode")==null?"":request.getParameter("addCode");
		String addDesc=request.getParameter("addDesc")==null?"":request.getParameter("addDesc");
		String booking_ref_no=request.getParameter("booking_ref_no")==null?"":request.getParameter("booking_ref_no");
		String addedInstns=request.getParameter("addedInstns")==null?"":request.getParameter("addedInstns");// included for the CRF - RUT-CRF-13.1 - 35825
		String excludeInstns=request.getParameter("excludeInstns")==null?"":request.getParameter("excludeInstns");// included for the CRF - RUT-CRF-13.1 - 35825
		String checkYN="N";
		String patInsSql="";
				
		if ((from_page.equals("createBooking")) && !nursing_unit_code.equals("")){
			patInsSql="SELECT instruction_id, display_order,am_get_desc.am_pat_instructions (instruction_id, '"+locale+"', 1) INSTRUCTION_DESC, DEFAULT_LINKED_YN FROM IP_NURS_PAT_INSTRUCTIONS where NURSING_UNIT_CODE='"+nursing_unit_code+"' and facility_id='"+facilityId+"'"; 
		}
		if (patInstructionsMap == null){
			patInstructionsMap=new TreeMap();
			}
			else{
				patInsCount=patInstructionsMap.size();
			}

			if(!patInsSql.equals("") && patInsCount==0){
			stmt=connection.createStatement();
			rset=stmt.executeQuery(patInsSql);
			String display_order_instn="";
			String instn_id="";
			String inst_desc="";
			while(rset.next()){
				display_order_instn=rset.getString("DISPLAY_ORDER");
				instn_id=rset.getString("INSTRUCTION_ID");
				inst_desc=rset.getString("INSTRUCTION_DESC");
				checkYN=rset.getString("DEFAULT_LINKED_YN");
				String instns=instn_id+"||"+inst_desc+"||"+checkYN;
				Integer dis_ord=new Integer(Integer.parseInt(display_order_instn));
				patInstructionsMap.put(dis_ord,instns);
			}
			session.setAttribute("ipPatInstructionsMap",patInstructionsMap);
			patInsCount=patInstructionsMap.size();
		}
		
		if (rset !=null) rset.close();
		if (stmt != null) stmt.close();
		
		if (addCode != null && !addCode.equals("")){
			if (addDesc != null && !addDesc.equals("")){
				int order=patInsCount+1;
				String insValue=addCode+"||"+addDesc+"||"+checkYN;
				Integer instOrder=new Integer(order);
				patInstructionsMap.put(instOrder,insValue);
				session.setAttribute("ipPatInstructionsMap",patInstructionsMap);
				patInsCount=patInstructionsMap.size();//modified for the incident IN039926
			}
		}
		if(from_page.equals("view_dtls")){
			disabledTextArea="readonly";
			patInsColSize="83";
		}
		// Added for the CRF - RUT-CRF-13.1 - 35825
		if (addedInstns != null && !addedInstns.equals("")){
			String patInstuctions="select instruction_id,instruction_desc from am_pat_instructions where instruction_id in ("+addedInstns+")"; 
			stmt=connection.createStatement();
			rset=stmt.executeQuery(patInstuctions);
			String addedInsCode="";
			String addedInsDesc="";
			while(rset.next()){
				addedInsCode=rset.getString("INSTRUCTION_ID");
				addedInsDesc=rset.getString("INSTRUCTION_DESC");
				//int order=patInsCount+1;
				String insValue=addedInsCode+"||"+addedInsDesc+"||Y";
				Integer instOrder=new Integer(patInsCount);
				patInstructionsMap.put(instOrder,insValue);
				session.setAttribute("ipPatInstructionsMap",patInstructionsMap);
				patInsCount=patInsCount+1;
			}
			patInsCount=patInstructionsMap.size();//included for the incident IN039926
		}
		// Added for the CRF - RUT-CRF-13.1 - 35825
%>
<body onKeyDown='lockKey();'>
<form name='patInsForm' id='patInsForm' ><%
%>
		<div id='patinsheaderID'>
		<table width='610'>
			<th width='510'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<%if(!(from_page.equals("view_dtls"))){%>
			<th width='100'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;</th>
			<%}%>
		</table>
		</div>
		<table width='610' id='patinsTableID'> 
		<%
			if(patInsCount > 0){
				int countValue=1;
				Iterator it=patInstructionsMap.keySet().iterator();
				while(it.hasNext()){
				Integer key=(Integer)it.next();
				valueObject=(String)patInstructionsMap.get(key);
				StringTokenizer tokenizer=new StringTokenizer(valueObject,"||");
				while (tokenizer.hasMoreTokens()){
					instruction_id=tokenizer.nextToken();
					excludeInstns=excludeInstns+instruction_id+",";// included for the CRF - RUT-CRF-13.1 - 35825
					ins_dec=tokenizer.nextToken();
					
					if(ins_dec.equals("*!*")){
						ins_dec="";
					}
					default_linked_yn=tokenizer.nextToken();
				}
				if(default_linked_yn.equals("Y")){
					checkValue="checked";
				}else{
					checkValue="";
				}
		%>
				<tr><td width='470'><TEXTAREA NAME='descriptionID<%=recCount%>', ROWS=2 COLS=<%=patInsColSize%> id='descriptionID<%=recCount%>' maxlength='200' onkeypress='checkMaxLimit(this,200)' onBlur="default_text('<%=countValue%>',this,'<%=checkValue%>')" <%=disabledTextArea%> ><%=ins_dec%></TEXTAREA></td><td width='130'><center><input type='checkbox' id='check_BoxID<%=recCount%>' name='check_BoxID<%=recCount%>' value='' onClick="default_check('<%=countValue%>',this);" <%=checkValue%>/></center></td>
				<input type='hidden' name='instructionID_<%=recCount%>' id='instructionID_<%=recCount%>' value='<%=instruction_id%>'/>
				<input type='hidden' name='display_orderID_<%=recCount%>' id='display_orderID_<%=recCount%>' value='<%=countValue%>'/>
				</tr>
		<%
				recCount++;
				countValue++;
				}
			}
			
		%>
 </table>

	<input type='hidden' name='recCount' id='recCount' value="<%=recCount%>">

	<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value="<%=nursing_unit_code%>">
	<input type='hidden' name='booking_ref_no' id='booking_ref_no' value="<%=booking_ref_no%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">
	
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
	<input type='hidden' name='from_page' id='from_page' value="<%=from_page%>">
	<!-- Added for the CRF - RUt-CRF-13.1 35825 -- start -->
	<input type='hidden' name='addedInstns' id='addedInstns' value="<%=addedInstns%>">
	<input type='hidden' name='excludeInstns' id='excludeInstns' value="<%=excludeInstns%>">
	<input type='hidden' name='patInsCount' id='patInsCount' value="<%=patInsCount%>">
	<!-- Added for the CRF - RUt-CRF-13.1 35825 -- end -->
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

