<!DOCTYPE html>
<%@ page import= "java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script>
	async function showPackage(patId)
	{			
		parent.Main_frame.document.forms[0].package_flag.value='Y';
		var retVal;
		var dialogHeight= "20" ;
		var dialogWidth	= "50" ;
		var dialogTop = "150" ;
		var center = "1" ;														   
		var status="no";
		var patient_id = patId;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "QueryPackageDetails.jsp?patient_id="+patient_id+"&mode=IP";
		retVal =await window.showModalDialog(url,arguments,features);
		
	//	if ((retVal!=null) && (retVal!="")) parent.frames[1].document.forms[0].pkg_sel.value = "Y";
		var returnArray = new Array();
		if ((retVal!=null) && (retVal!="")) returnArray = retVal.split(",");
		if(returnArray.length>0)
		{
			parent.Main_frame.document.forms[0].pkg_bill_type.value = returnArray[0];
			parent.Main_frame.document.forms[0].pkg_bill_no.value = returnArray[1];
		} 
	}
</script>

<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	String patId = request.getParameter("patientId");
	String facilityId = (String)session.getValue("facility_id"); 

	Connection con = null;
	//Statement stmt = null;
	ResultSet rs1 = null;
	PreparedStatement pstmt = null;
	//String retVal="";
	boolean packageDetReq = false;
	
	try 
	{
		con	=	ConnectionManager.getConnection(request);
		//stmt = con.createStatement();

		String pSql = "select count(*) ct from bl_package_trn_hdr a, bl_package_codes b "+
						"where a.patient_id = ? and a.package_code = b.package_code and "+
						"nvl(a.closed_yn, 'N') not in ('A', 'I') and nvl(a.bill_status, 'N') = 'N' and "+
						"nvl(a.expiry_date, trunc(sysdate)) >= trunc(sysdate) and nvl(b.apply_to, 'N') in ('B', 'I')";
		//rs1 = stmt.executeQuery(pSql);
		pstmt = con.prepareStatement(pSql);
		pstmt.setString(1, patId);
		rs1 = pstmt.executeQuery();
		if(rs1.next()) {
			if(rs1.getInt("ct")>0) packageDetReq=true;
		}	
		if (rs1 != null)   rs1.close();

		
		String sql = "select POLICY_EXPIRY_WARNING_PERIOD, Policy_expiry_date, "+
					"decode(sign(trunc(policy_expiry_date)-trunc(sysdate)),-1,'E','U') ins_chk, "+
					"decode(sign((trunc(policy_expiry_date) - trunc(sysdate)) - POLICY_EXPIRY_WARNING_PERIOD),-1,(trunc(policy_expiry_date) - trunc(sysdate)),0) warn_days "+
					"from bl_patient_fin_dtls a, ip_param b "+
					"where policy_type_code is not null and facility_id=? and patient_id=? ";
		
		//rs1 = stmt.executeQuery(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, facilityId);
		pstmt.setString(2, patId);
		rs1 = pstmt.executeQuery();
		if(rs1.next()) {
			if(rs1.getString("ins_chk").equals("E")) {
				%>
					<script>
						
/*						if(window.confirm('The Insurance Policy of the patient has expired.\nDo you want to modify the Financial Details?\n\nClick OK to continue. Click Cancel to stop.')==true)
*/
						if(window.confirm(getMessage('BL9320','BL')==true)
						{
							parent.Main_frame.tab_click('findtl_tab');
							if(<%=packageDetReq%>) showPackage('<%=patId%>');
						} 
						else{

							parent.Select_frame.document.forms[0].patient_id.value='';
							parent.Select_frame.document.forms[0].patient_id.focus();
							parent.Select_frame.document.forms[0].encounter_id.focus();	
							parent.Select_frame.document.forms[0].patient_id.focus();
						}
					</script>
				<%
			}		
			else if(rs1.getInt("warn_days")>0){
/*				out.println("<script>alert('The Insurance policy of the patient will expire with in the next "+rs1.getInt("warn_days")+" days')</script>");
*/
				out.println("<script>alert(getMessage('BL9542','BL')+rs1.getInt('warn_days'));</script>");

				
				if(packageDetReq){
					out.println("<script>if(!(parent.Select_frame.document.forms[0].patient_id.value=='')) showPackage('"+patId+"')</script>");
				}
			}
			else {
				if(packageDetReq){
					out.println("<script>if(!(parent.Select_frame.document.forms[0].patient_id.value=='')) showPackage('"+patId+"')</script>");
				}
			}
		}
		else {
			if(packageDetReq) {
					out.println("<script>if(!(parent.Select_frame.document.forms[0].patient_id.value=='')) showPackage('"+patId+"')</script>");
			}
		}		
		if (rs1 != null)   rs1.close();
	}
	catch(Exception e) {
		out.println(e.toString());
	}
	finally {
		
		if(pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con, request);

	}
%>
</body>
</html>

