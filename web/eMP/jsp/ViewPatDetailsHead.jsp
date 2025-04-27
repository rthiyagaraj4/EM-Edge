<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,eBL.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
    String patient = ""; 
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	patient = request.getParameter("Patient");
	String function_id = request.getParameter("function_id");
	    if(function_id == null || function_id == "undefined" || function_id.equals(""))
	function_id = "";
	String view_pat_photo_yn = request.getParameter("view_pat_photo_yn"); 
	if(view_pat_photo_yn == null ||view_pat_photo_yn.equals(""))
	view_pat_photo_yn = "N";
	String Pat_Details = request.getParameter("Pat_Details"); 
	if(Pat_Details == null ||Pat_Details.equals(""))
	Pat_Details = "";

	// Code added by Sethu for 64523	PMG2017-COMN-CRF-0005	Patient Photo capture in EM 

	String name = "";
	if (Pat_Details.length() > 0 )
	{
		name = Pat_Details.substring(0, Pat_Details.indexOf(",") - 1 );
	}
	
	System.out.println(" Patient details ::: "+Pat_Details+" ::: "+name);
	Connection con = null;
	Boolean enteredByAppl = false;	// Added by shagar for ML-MMOH-CRF-1328

/* Friday, April 30, 2010 PE_EXE Venkat S
    //String image = ""; 
    //image=request.getParameter("image");
    //String root		= request.getParameter("root"); 
	String disp_dup_pat_dtls=request.getParameter("disp_dup_pat_dtls");	
	String resp_id	= (String) session.getValue("responsibility_id");
	StringBuffer sqlresp = new StringBuffer("select view_pat_photo_yn from mp_access_rights where resp_id = '");
	String locale=(String)session.getAttribute("LOCALE");
	sqlresp.append(resp_id);
	sqlresp.append("'");
	String view_pat_photo_yn = "N";
	Connection con = null;
	 Boolean enteredByAppl = false;	// Added by shagar for ML-MMOH-CRF-1328
	PreparedStatement pstmt = null;
    Statement stmt_bl		= null;
	ResultSet rs			= null;
	ResultSet rs_bl			= null;
	Statement stmt			= null;
    String Pat_Details = "";
		
	try
	{
		con = ConnectionManager.getConnection(request);
			enteredByAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "ENTERED_BY"); // Added by shagar for ML-MMOH-CRF-1328
		stmt_bl=con.createStatement();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlresp.toString());
	    if (rs.next())
		    view_pat_photo_yn = rs.getString(1);
	}
	catch(Exception e){}
  
	try
    {
		if(disp_dup_pat_dtls.equals("Duplicate"))
		{
			pstmt = con.prepareStatement("SELECT get_dup_patient_line(?,?) FROM dual");
		}
		else{
			pstmt = con.prepareStatement("select get_patient_line(?,?) from dual");
		}
		pstmt.setString(1, patient);
		pstmt.setString(2, locale);
		rs = pstmt.executeQuery();
	    if(rs.next())
			Pat_Details = rs.getString(1);

		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
*/
try{
	con = ConnectionManager.getConnection(request);
	enteredByAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "ENTERED_BY"); // Added by shagar for ML-MMOH-CRF-1328
		
	
	String bl_install_yn = (String)session.getValue("mp_bl_oper_yn");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	if(bl_install_yn == null || bl_install_yn.equals("null"))
		bl_install_yn = "N";


	/*Added to clear the bean values Start*/
	String bean_id = "";
	String bean_name = "";
	BLInsuranceImageBean blInsuranceImageBean 		= 	null;
	bean_id							= 	"bl_blinsuranceimagebean" ;
	bean_name						= 	"eBL.BLInsuranceImageBean";
	blInsuranceImageBean					= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
	blInsuranceImageBean.clearBean();

   //end

	%>
	
<html>
<head>
	<title><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></title>
   	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
	<script language="JavaScript" src="../../eMP/js/ViewPatDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<script>
	function tab_click1(id) 
		{
			selectTab(id);
			tab_click(id);
		}
		function lockKey()
		{
			if(event.keyCode == 93 || event.keyCode ==32)
			{
				alert("Welcome to eHIS");
				event.returnValue=false;
				}
		}
	</script>

</head>
<body onKeyDown = 'lockKey()' onload="startBlink();">
<form name='viewPatDetsHeadForm' id='viewPatDetsHeadForm'>

<CENTER>

<table border="0" cellpadding="0" cellspacing="0" width="100%" style="padding-left:0px;">
<tr>
<td>
<ul id="tablist" class="tablist" style="padding-left:0">
			<li class="tablistitem" title='<fmt:message key="eMP.demographicdetails.label" bundle="${mp_labels}"/>'>
				<a onclick="tab_click1('demogrp_tab')" class="tabClicked" id='demogrp_tab' >
					<span class="tabSpanclicked" id="demogrp_tabspan"><fmt:message key="eMP.demographicdetails.label" bundle="${mp_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eMP.ContactAddresses.label" bundle="${mp_labels}"/>'>
				<a onclick="tab_click1('cmodeaddr_tab')" class="tabA" id="cmodeaddr_tab" >
					<span class="tabAspan" id="cmodeaddr_tabspan"><fmt:message key="eMP.ContactAddresses.label" bundle="${mp_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/>'>
				<a onclick="tab_click1('rlcnts_tab')" class="tabA" id="rlcnts_tab" name="rlcnts_tab" >
					<span class="tabAspan" id="rlcnts_tabspan"><fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="Common.documents.label" bundle="${common_labels}"/> & <fmt:message key="Common.others.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('pat_docs_tab')" class="tabA" id="pat_docs_tab" >
					<span class="tabAspan" id="pat_docs_tabspan"><fmt:message key="Common.documents.label" bundle="${common_labels}"/> & <fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
			<%if(enteredByAppl){ // Added by shagar for ML-MMOH-CRF-1328 %>
			<li class="tablistitem" title='<fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/>'>
			  <a onclick="tab_click1('add_mod_dtl')"  class="tabA" name="add_mod_dtl" id="add_mod_dtl" >
				 <span class="tabAspan" id="add_mod_dtlspan"><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}else {%>
			<li class="tablistitem" title='<fmt:message key="Common.whodoneit.label" bundle="${common_labels}"/>'>
			  <a onclick="tab_click1('add_mod_dtl')"  class="tabA" name="add_mod_dtl" id="add_mod_dtl" >
				 <span class="tabAspan" id="add_mod_dtlspan"><fmt:message key="Common.whodoneit.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
			<%}%>
			<%if(bl_install_yn.equals("Y")){%>
			<li class="tablistitem" title='<fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/>'>
				<a onclick="tab_click1('findtl_tab')" class="tabA" name="findtl_tab" id="findtl_tab" >
					<span class="tabAspan" id="findtl_tabspan"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
		<%}%>	

        <%if(function_id.equals("CAPTUREPATPHOTO") && view_pat_photo_yn.equals("Y")){%>
			<li class="tablistitem" title='<fmt:message key="eMP.photo.label" bundle="${mp_labels}"/>'>
				<a onclick="javascript:callCapturePhotoMain()" class="tabA" id="capture_tab" ><!-- Modified by Ajay Hatwate for BSP-SCF-0119 -->
<%-- 				<a onclick="javascript:capturePhotoMain('<%=patient%>','<%=name%>');" class="tabA" id="capture_tab" > --%>
					<span class="tabAspan" id="findtl_tabspan"><fmt:message key="eMP.photo.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
		<%}%>
</ul>
</td>
</tr>
</table>
</CENTER>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient%>'>
<!-- Code added by Sethu for 64523	PMG2017-COMN-CRF-0005	Patient Photo capture in EM -->

<input type='hidden' name='patient_name' id='patient_name' value='<%=name%>'>
			
</form>

<!-- Script Added by Ajay Hatwate for BSP-SCF-0119 -->
<script>
async function callCapturePhotoMain(){
	var pname = encodeURIComponent("<%=name%>");
	await capturePhotoMain('<%=patient%>',pname);
	//capturePhotoH5('<%=patient%>');
}
</script>
<!-- Script End for BSP-SCF-0119 -->
</body>
<%

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
%>
<!--  Friday, April 30, 2010 PE_EXE Venkat S
		if(rs_bl != null) rs_bl.close();
		if(rs != null) rs.close();

        if(stmt != null) stmt.close();
        if(stmt_bl != null) stmt_bl.close();
		if(pstmt!=null) pstmt.close();

    }
	catch(Exception e)
    {
		out.println("Excpetion in main try"+e.getMessage());
		e.printStackTrace();
    }
	finally
	{
        if(con!=null) ConnectionManager.returnConnection(con,request);
    } */ -->
   
    <!--<script>
        GifBlink(escape("<%=Pat_Details%>"),"parent.frames[0].document")
		prevTabObj='demogrp_tab';
    </script>-->
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


