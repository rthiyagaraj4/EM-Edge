<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
try{
		request.setCharacterEncoding("UTF-8"); 
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String patient = request.getParameter("Patient_ID");
		String function_id = request.getParameter("function_id");
		String functionid = request.getParameter("functionid");
		String image = request.getParameter("image");
		String disp_dup_pat_dtls = request.getParameter("disp_dup_pat_dtls");
		String group_status=request.getParameter("group_status" );
		String resp_id	= (String) session.getValue("responsibility_id");
		String locale=(String)session.getAttribute("LOCALE");
		String view_pat_photo_yn = "N";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		con = ConnectionManager.getConnection(request);
		if(disp_dup_pat_dtls==null || disp_dup_pat_dtls.equals("null"))
			disp_dup_pat_dtls = "";	
		/*Modified By Dharma for SKR-SCF-1528 Start*/	
	   //Added for ML-MMOH-CRF-0860.2
	   /*String alternate_id = request.getParameter("alternate_id");
	   if(alternate_id==null || alternate_id.equals("null")) alternate_id = "";		   
	   
		*/
		String alternate_id = "";
		boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
		boolean alterAddressApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");
		if(increasedaddressLength && alterAddressApplicable){
			alternate_id	= "ViewAlternateId";
		}
		/*Modified By Dharma for SKR-SCF-1528 End*/
		//End ML-MMOH-CRF-0860.2
	 
		String dup_detail = "";
		String Pat_Details = "";
		int count=0;

		if(image == null) image="";
		if(patient == null) patient="";

		if(function_id == null) function_id="";
		if(functionid == null) functionid="";
		String root= request.getParameter("root");
		if(root == null) root="";
		if(group_status == null) group_status="";

// Friday, April 30, venkat s 2010 PE_EXE 
		if(disp_dup_pat_dtls.equals("Duplicate"))
		{
			dup_detail="get_dup_patient_line(?,?) Pat_Details";
		} else
		{
			dup_detail="get_patient_line(?,?) Pat_Details";
		}

		StringBuffer sqlresp = new StringBuffer("select view_pat_photo_yn,(SELECT COUNT (*) AS total FROM sm_language WHERE language_direction = 'R' AND eff_status = 'E') total,"+dup_detail+" from mp_access_rights where resp_id = ?");

		try
			{
				
				pstmt = con.prepareStatement(sqlresp.toString());
				pstmt.setString(1, patient);
				pstmt.setString(2, locale);
				pstmt.setString(3, resp_id);

				rs = pstmt.executeQuery();
				if(rs.next())
				{
					view_pat_photo_yn = rs.getString("view_pat_photo_yn")==null?"":rs.getString("view_pat_photo_yn"); //Added the line for this incident [36906]
					count = rs.getInt("total");
					//Pat_Details = rs.getString("Pat_Details");
					Pat_Details = rs.getString("Pat_Details")==null?"":rs.getString("Pat_Details"); //Added the line for this incident [36906]
				}

				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();

			}
			catch(Exception e)
			{
				out.println("Excpetion in main try"+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}


/* Friday, April 30, 2010 PE_EXE VEnkat S
if(!disp_dup_pat_dtls.equals("")) {
	src = "../../eCommon/html/blank.html";
	frameRows = "0,15,*";
} else {
	
	src = "../../eCommon/jsp/pline.jsp?Patient_ID="+patient;
	frameRows = "7.5%,15,*";
}
*/



%>
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<html>
<head><title><fmt:message key="eMP.ViewPatientDetails.label" bundle="${mp_labels}"/></title></head>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/common.js' language='javascript'></script>
 <script>

if(parent.plineFrame !=undefined) {
	
	parent.plineFrame.document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+"<%=patient%>";
	document.write("<iframe name='patient_main' id='patient_main'	src='../jsp/ViewPatDetailsHead.jsp?Patient=<%=java.net.URLEncoder.encode(patient) %>&function_id=<%=java.net.URLEncoder.encode(function_id)%>&image=<%=java.net.URLEncoder.encode(image)%>&disp_dup_pat_dtls=<%=java.net.URLEncoder.encode(disp_dup_pat_dtls)%>&root=<%=java.net.URLEncoder.encode(root)%>&view_pat_photo_yn=<%=java.net.URLEncoder.encode(view_pat_photo_yn)%>&Pat_Details=<%=java.net.URLEncoder.encode(Pat_Details)%>' frameborder=0 scrolling='no' noresize frameborder='0' style='height:15%;width:100vw'></iframe><iframe name='patient_sub' id='patient_sub' src='../jsp/ViewPatDetailsQuery.jsp?functionid=<%=functionid%>&Patient=<%=java.net.URLEncoder.encode(patient)%>&function_id=<%=java.net.URLEncoder.encode(function_id)%>&disp_dup_pat_dtls=<%=java.net.URLEncoder.encode(disp_dup_pat_dtls)%>&group_status=<%=java.net.URLEncoder.encode(group_status)%>&view_pat_photo_yn=<%=java.net.URLEncoder.encode(view_pat_photo_yn)%>&total=<%=count%>&alternate_id=<%=alternate_id%>'  frameborder=0 scrolling='no' noresize frameborder='0' style='height:100vh;width:100vw'></iframe>");
} else {
	//  newly added  Friday, April 30, 2010 PE_EXE Venkat S
	var frameRows  = "";
	var src = "";
	
	if('<%=disp_dup_pat_dtls%>' != '') {
		src = '../../eCommon/html/blank.html';
		frameRows = '0,15,*';
	} else {		
		src = '../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient%>';
		frameRows = '7.5%,15,*';
	}

	document.write("<frameset rows="+frameRows+"><frame name='plineFrame' id='plineFrame' src = "+src+" frameborder=0 scrolling='no' noresize><frame name='patient_main' id='patient_main' src='../../eMP/jsp/ViewPatDetailsHead.jsp?Patient=<%=java.net.URLEncoder.encode(patient) %>&function_id=<%=java.net.URLEncoder.encode(function_id)%>&image=<%=java.net.URLEncoder.encode(image)%>&disp_dup_pat_dtls=<%=java.net.URLEncoder.encode(disp_dup_pat_dtls)%>&root=<%=java.net.URLEncoder.encode(root)%>&view_pat_photo_yn=<%=java.net.URLEncoder.encode(view_pat_photo_yn)%>&Pat_Details=<%=java.net.URLEncoder.encode(Pat_Details)%>' frameborder=0 scrolling='no' noresize><frame name='patient_sub' id='patient_sub' src='../../eMP/jsp/ViewPatDetailsQuery.jsp?functionid=<%=functionid%>&Patient=<%=java.net.URLEncoder.encode(patient)%>&function_id=<%=java.net.URLEncoder.encode(function_id)%>&disp_dup_pat_dtls=<%=java.net.URLEncoder.encode(disp_dup_pat_dtls)%>&group_status=<%=java.net.URLEncoder.encode(group_status)%>&view_pat_photo_yn=<%=java.net.URLEncoder.encode(view_pat_photo_yn)%>&total=<%=count%>&alternate_id=<%=alternate_id%>' frameborder=0 scrolling='no' noresize></frameset>");
}
</script>

<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	<input type='hidden' name='functionid' id='functionid' value=<%=functionid%>>
	</form>
</html>
<%}catch(Exception e){
		out.println("Excpetion in main try"+e.getMessage());
		e.printStackTrace();
	}
%>

