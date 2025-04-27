<!DOCTYPE html>
<%
/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1			 V220614			 32364			MMS-ME-SCF-0102				   Manivel Natarajan
-----------------------------------------------------------------------------------------------
*/
%>

<%@page import="java.net.URLDecoder"%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<%!
private String decodeParam(String input){
	String output = "";
	try{
		if(input!=null){
			input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			input = input.replaceAll("\\+", "%2B");
			output = URLDecoder.decode(input,"UTF-8");
		}
	}
	catch(Exception e){
		System.err.println("Exception while Decoding Pkgsusdtls->"+e);
		e.printStackTrace();
	}
	return output;
}

public int siteParamPkgAssociation(Connection con) throws SQLException{
	PreparedStatement pstmt=null;
	ResultSet rst = null; 
	int count=0;
	try{
		pstmt = con.prepareStatement( "SELECT COUNT (*) FROM sm_function_control a, sm_site_param b  WHERE a.site_id = b.customer_id AND module_id = 'BL'  AND functionality_id = 'PACKAGE_SUBS_DATE_WITH_TIME'");
		rst = pstmt.executeQuery();	
		if(rst.next())
		{
			count=rst.getInt(1);
		}		
		}catch(Exception e){
			System.out.println("Exception no. of decimal :"+e);
			e.printStackTrace();
		}finally{
			if(pstmt!=null) pstmt.close();
			if(rst!=null) rst.close();
		}
	return count;
	}
	
// Added By Vijay For GHL-SCF-1185
private String TruncDate(Connection con,String Input,String DateTimeFormat)
{
	String outPut="";
	try{
		PreparedStatement pstmt=null;
		ResultSet rst = null; 
		String sql="";
		if(DateTimeFormat.equals("HH24:MI"))
		{
		 sql="select to_char( (to_date(?,'dd/mm/yyyy HH24:MI')),'dd/mm/yyyy') from dual";
		}
		else
		{
		 sql="select to_char( (to_date(?,'dd/mm/yyyy HH24:MI:SS')),'dd/mm/yyyy') from dual";
		}
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,Input);
		rst=pstmt.executeQuery();
		if(rst!=null)
		{
			while(rst.next())
			{
				outPut=rst.getString(1);
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Exception in Trunc Date "+e);
		}
		return outPut;
	
}%>
<%
	Connection con		= ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	//Added V171212-Gayathri/MMS-DM-CRF-0118/Starts	
	String chargeLogicYn ="";
	Boolean SiteSpec_VAT=false;
	String SiteSpecific_VAT ="";
	//Added By Shikha For GHL-CRF-0520.1
	boolean siteBLPkgBlngGrp = false;
	String siteBLPkgBlngGrpYN = "N";
	//Added By Shikha For GHL-CRF-0520.1
	
	//Added against GHL-CRF-0631
	boolean isSiteSpec1 = false;
	String siteBLPkgBlngGrpYN1 = "N";	
	try {
			isSiteSpec1 = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "BL_CAL_BY_FACILITY");
			if (isSiteSpec1)
				siteBLPkgBlngGrpYN1 = "Y";
			else
				siteBLPkgBlngGrpYN1 = "N";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in isSiteSpec_GHL " + e);
		}
		//Added against GHL-CRF-0631
		//KDAH-SCF-0812-TF
	boolean isPracMand = false;
	String pracMandatoryYN = "N";	
	try {
			isPracMand = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "BL_PRAC_NAME_MANDATORY");
			if (isPracMand)
				pracMandatoryYN = "Y";
			else
				pracMandatoryYN = "N";
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in pracMandatoryYN " + e);
		}
	//KDAH-SCF-0812-TF ends
	
	try
	{	
		SiteSpec_VAT = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","VAT_CHANGES_APPLICABLE_YN");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(SiteSpec_VAT){
			SiteSpecific_VAT="Y";
		}
		else{
			SiteSpecific_VAT="N";
		}
	//Added V171212-Gayathri/MMS-DM-CRF-0118/Ends
	//Added By Shikha For GHL-CRF-0520.1
	try{
		siteBLPkgBlngGrp = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_PKG_BLNG_GRP");	
		if (siteBLPkgBlngGrp)
			siteBLPkgBlngGrpYN = "Y";
		else
			siteBLPkgBlngGrpYN = "N";
		}catch(Exception e){
			e.printStackTrace();
		}
	//Ended By Shikha For GHL-CRF-0520.1
	int checkSiteParam= siteParamPkgAssociation(con);
	if(checkSiteParam>0) {
		session.setAttribute("SITE_PARAM_PACKAGE_ASSOCIATION_ENABLED",true);
	}else{
		session.setAttribute("SITE_PARAM_PACKAGE_ASSOCIATION_ENABLED",false);
	}

try{
		String str_title="";
		String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;	
		//Added by Rajesh V for CRF-140
		String insCustGrp = decodeParam(request.getParameter("insCustGrp"));
		String insCust = decodeParam(request.getParameter("insCust"));
		String insCustGrpDesc = decodeParam(request.getParameter("insCustGrpDesc"));
		String insCustDesc = decodeParam(request.getParameter("insCustDesc"));
		//Added by Rajesh V for CRF-140
		//Added By Shikha For GHL-CRF-0520.1
		String insBlngGrp = decodeParam(request.getParameter("insBlngGrp"));		
		String insBlngGrpDesc = decodeParam(request.getParameter("insBlngGrpDesc"));	
		//Ended By Shikha For GHL-CRF-0520.1		
		if(function_id.equals("VISIT_REGISTRATION") || function_id.equals("ADMISSION"))		str_title=request.getParameter("title");	
		Boolean isSiteSpec = false;
%>
<title>
	<%=str_title%>
</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<Script language ="JavaScript" src ='../../eCommon/js/jquery-3.6.3.js'></Script>
<script language="javascript" src='../../eBL/js/PkgSubs.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


 

</head>
<script>
	$(document).ready(function () {	
	$("#existingPackages").load("../../eBL/jsp/PkgAssociationExistingPackages.jsp",{patientId:$("#patientId").val()});
	
	$.ajax({
          url:"../../eBL/jsp/PkgAssociationExistingPackagesPersistance.jsp",
          type:'post',
          data:{
        	  operation:'clearsessions'
          },
          async:false,
          success: function(data) {
          }
      });
});
</script>
<style>
	thead td, thead td.locked	{
	background-color: navy;
	color: white;
	position:relative;}	
	thead td {
	top: expression(document.getElementById("tbl-container").scrollTop-4); 
	z-index: 20;}
	thead td.locked {z-index: 30;}
	td.locked,  th.locked{
	left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
	position: relative;
	z-index: 10;}
	td.locked,  th.locked{
	left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
	position: relative;
	z-index: 10;}
	table
	{white-space: nowrap;}
	
</style>

<% 		
	ResultSet rs			= null;
	ResultSet rscurr		= null;
	Statement stmt			= null;
	String locale			= (String)session.getAttribute("LOCALE");		
	int noofdecimal			= 2;
	int totRec			= 1;
	String patientId 		= request.getParameter("patientId") == null ? "" :request.getParameter("patientId") ;
	String bed_type_code 	= request.getParameter("bed_type") == null ? "" :request.getParameter("bed_type") ;		
	String facility_id 		= (String) session.getValue( "facility_id" ) ;
	//String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;
	String patln="",sysDate="";
	String pkgsubDfltDateYN="";

	String bean_id		= "PkgSubsBean" ;
	String bean_name	= "eBL.PkgSubsBean";
	PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id, bean_name, request ) ;
	if(function_id.equals("EBL_PACKAGE_SUBS"))
	{
		bean.clearBean();
	}
		
	try{
		String sqlLen ="SELECT CHARGE_LOGIC_YN,NVL(PKG_SUB_AS_SYSDATE_YN,'Y') FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+facility_id+"'";
		pstmt=con.prepareStatement(sqlLen);
		rs=pstmt.executeQuery();
		while(rs.next() && rs!=null)
		{
			chargeLogicYn   =  rs.getString(1);
			pkgsubDfltDateYN=  rs.getString(2);
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		System.out.println("Exception @ Patient Id Length :"+e);
		e.printStackTrace();
	}
		
	pstmt = null;
		
	if(!(function_id.equals("VISIT_REGISTRATION") && function_id.equals("ADMISSION")))
	{
		try
		{
			CallableStatement call = con.prepareCall("{ ? = call  get_patient_line(?,?)}");	
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.setString(2,patientId);
			call.setString(3,locale);
			call.execute();							
			patln = call.getString(1);				
			call.close();
			if ( patln == null ) patln = "";
			int ind=patln.indexOf("#");
			patln=patln.substring(0,ind);
			if ( patln == null ) patln = "";
			//System.out.println("title @:"+patln);
		}catch(Exception e){
				System.out.println("Exception no. of patline :"+e);
				e.printStackTrace();
		}
	}

	try{
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);		
		}			
	}catch(Exception e)
	{
		System.out.println("Exception no. of decimal :"+e);
		e.printStackTrace();
	}

	try
	{
		String query_date="select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date) ;
		if( rs != null ) 
		{
			if( rs.next() )
				sysDate = rs.getString(1); 
		}
	if (rs != null)   rs.close();
	if (stmt != null)   stmt.close();
	}		
	catch(Exception e)
	{
		System.out.println("Exception @ sysdate  :"+e);
		e.printStackTrace();
	}

	try {
		isSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "PACKAGE_SUBS_DATE_WITH_TIME");
		System.out.println("isSiteSpec " + isSiteSpec);
	} catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception in isSiteSpec " + e);
	}
%>

<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="" onSelect="codeArrestThruSelect();" >
<form name='frmPkgSubs' id='frmPkgSubs' action="../../servlet/eBL.PkgSubscriptionServlet" method="post" target="messageFrame" >	
<div style="height:36vh;overflow-y: auto;">
	<!--Added V171212-Gayathri/MMS-DM-CRF-0118/Starts-->
	<%if("Y".equals(SiteSpecific_VAT)){%>
	<table class='grid' width='110%' id="pkgSubs_tabId" name="pkgSubs_tabId" >
	<%}else{%>
	<table class='grid' width='110%' id="pkgSubs_tabId" name="pkgSubs_tabId" >
	<%} %>
	<tr>
	<%if("Y".equals(SiteSpecific_VAT)){%>
	<td  class='COLUMNHEADER' colspan='11' ><b><%=patln%><b></td>
	<%}
	else {%>
	<td  class='COLUMNHEADER' colspan='10' ><b><%=patln%><b></td>
	<%}%>
	<!--Added V171212-Gayathri/MMS-DM-CRF-0118/Ends-->
	</tr>	
	<tr >
	<td  class='COLUMNHEADER' width ='' ><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>	
	<td  class='COLUMNHEADER' width =''><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<% if (siteBLPkgBlngGrp) { %>
	<td  class='COLUMNHEADER' width =''><fmt:message key="eBL.BillingGroup.label" bundle="${common_labels}"/></td>
	<%} %> 
	<td  class='COLUMNHEADER' width =''><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
	<td  class='COLUMNHEADER' width =''><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>		
	<td  class='COLUMNHEADER' width =''><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>	
	<td  class='COLUMNHEADER' width =''><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>	
	<td  class='COLUMNHEADER' width =''><fmt:message key="eBL.PKG_AMT.label" bundle="${bl_labels}"/></td>
	<!--Added V171212-Gayathri/MMS-DM-CRF-0118-->
	<%if("Y".equals(SiteSpecific_VAT)){%>
	<td  class='COLUMNHEADER' width =''><fmt:message key="eBL.ADDL_CHARGE.label" bundle="${bl_labels}"/></td>
	<%}%>
	<td  class='COLUMNHEADER' width =''><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
	<!-- Added by MuthuN Against 33044 on 15-6-12-->
	<td  class='COLUMNHEADER' width =''><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<!-- Added by MuthuN Against 33044 on 15-6-12-->
	</tr>

<%
	String packageCode="",fromDate="",toDate="";			
	//String packEnId="",strEMYN="",strIPYN="",strDCYN="",depositAmt="",status="O",utilizedAmt="";//unused variable
	String strOPYN="",addl_charge_amt="",packAmt="",pack_desc="",valid_episode="",blng_class_code="",blng_class_desc="",payerGrpCode="",payerGrpDesc="",payerCode="",payerDesc="",practitioner_id="",practitioner_name="";
	String blng_grp_code="",blng_grp_desc=""; //Added By Shikha For GHL-CRF-0520.1
	HashMap  patPackSubsDetails =   bean.getPatientPackSubsDtls();
	ArrayList	pkgDtls		    =	new ArrayList();
	ArrayList	pkgCodes		=	new ArrayList();
	ArrayList	packdescs		=	new ArrayList();
	ArrayList	pkgFrmDate		=	new ArrayList();
	ArrayList	pkgToDate		=	new ArrayList();
	ArrayList	pkgAmt			=	new ArrayList();	
	ArrayList	addlCharge		=	new ArrayList();	
	ArrayList	blng_class_code_list	=	new ArrayList();
	ArrayList	blng_class_desc_list	=	new ArrayList();
	ArrayList	blng_grp_code_list	=	new ArrayList();//Added By Shikha For GHL-CRF-0520.1
	ArrayList	blng_grp_desc_list	=	new ArrayList();//Added By Shikha For GHL-CRF-0520.1
	ArrayList	payerGrpCode_list	=	new ArrayList();			
	ArrayList	payerGrpDesc_list	=	new ArrayList();	
	ArrayList	payerCode_list	=	new ArrayList();			
	ArrayList	payerDesc_list	=	new ArrayList();			
	ArrayList	episode_type_list	=	new ArrayList();	//added for IN021023
	ArrayList	practitioner_id_list	=	new ArrayList();	//added for IN033044
	ArrayList	practitioner_name_list	=	new ArrayList();	//added for IN033044
	//ArrayList	pkgEncounter_id	=	new ArrayList();
	if(patPackSubsDetails.size()>0 && patPackSubsDetails.containsKey(patientId) )			
	{
		pkgDtls		=(ArrayList)patPackSubsDetails.get(patientId);
		if(pkgDtls.size()>0)
		{

			pkgCodes = (ArrayList)pkgDtls.get(0);//System.out.println("pkgDtls inside dtl1");
			packdescs = (ArrayList)pkgDtls.get(1);						//System.out.println("pkgDtls inside dtl2");
			pkgFrmDate = (ArrayList)pkgDtls.get(2);//System.out.println("pkgDtls inside dtl3");
			pkgToDate = (ArrayList)pkgDtls.get(3);
			pkgAmt = (ArrayList)pkgDtls.get(4);//System.out.println("pkgDtls inside dtl4");
			//pkgEncounter_id = (ArrayList)pkgDtls.get(4);
			blng_class_code_list = (ArrayList)pkgDtls.get(5);
			blng_class_desc_list = (ArrayList)pkgDtls.get(6);					
			payerGrpCode_list = (ArrayList)pkgDtls.get(7);
			payerGrpDesc_list = (ArrayList)pkgDtls.get(8);
			payerCode_list = (ArrayList)pkgDtls.get(9);
			payerDesc_list = (ArrayList)pkgDtls.get(10);
			episode_type_list = (ArrayList)pkgDtls.get(11);//added for IN021023
			practitioner_id_list = (ArrayList)pkgDtls.get(12);//added for IN033044
			practitioner_name_list = (ArrayList)pkgDtls.get(13);
			addlCharge = (ArrayList)pkgDtls.get(14);//added for IN033044
			//Added By Shikha For GHL-CRF-0520.1
			blng_grp_code_list = (ArrayList)pkgDtls.get(15);
			blng_grp_desc_list = (ArrayList)pkgDtls.get(16);
			//Added By Shikha For GHL-CRF-0520.1
		}
	}
			
	if(pkgCodes.size() >0)
			totRec = pkgCodes.size();		
			
	for(int i=0; i<totRec; i++)
	{	
		if(pkgCodes.size() >0){
		packageCode	=(String)pkgCodes.get(i);
		try{
			if(packageCode.contains("@:")){
				packageCode = packageCode.substring(0,packageCode.lastIndexOf("@:"));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		pack_desc	=(String)packdescs.get(i);
		fromDate	=(String)pkgFrmDate.get(i);
		toDate		=(String)pkgToDate.get(i);
		packAmt		=(String)pkgAmt.get(i);	
		addl_charge_amt		=(String)addlCharge.get(i);					
		blng_class_code	=(String)blng_class_code_list.get(i);
		blng_class_desc	=(String)blng_class_desc_list.get(i);			
		payerGrpCode	=(String)payerGrpCode_list.get(i);
		payerGrpDesc	=(String)payerGrpDesc_list.get(i);
		payerCode	=(String)payerCode_list.get(i);
		payerDesc	=(String)payerDesc_list.get(i);	
		valid_episode =(String)episode_type_list.get(i);	 
		practitioner_id = (String)practitioner_id_list.get(i);//added for IN033044
		practitioner_name = (String)practitioner_name_list.get(i);//added for IN033044
		//packEnId	=(String)pkgEncounter_id.get(i);
		//Added By Shikha For GHL-CRF-0520.1
		blng_grp_code	=(String)blng_grp_code_list.get(i);
		blng_grp_desc	=(String)blng_grp_desc_list.get(i);
		//Added By Shikha For GHL-CRF-0520.1
		strOPYN		="Y";
		//valid_episode="OP";			
		}	
		%>
		<tr >
		<td  class='fields' width="10%" nowrap="nowrap" >			
		<a href='#' name='pkgDtls<%=i%>' id='pkgDtls<%=i%>' onClick="displaypkgDtls('<%=i%>');" >+</a>				
		<input type='text' name='packageCode_<%=i%>' id='packageCode_<%=i%>' value='<%=packageCode%>' size='8' maxlength="8"  onKeyPress='return CheckForSpecChars_loc(event,packageCode_<%=i%>);' onBlur="pkgCodeLookup(packageDesc_<%=i%>,this,'<%=i%>');" >
		<input type='text' name='packageDesc_<%=i%>'  id ='packageDesc_<%=i%>'  onBlur="pkgDescLookUp(this,packageCode_<%=i%>,'<%=i%>')"  size='10'  maxlength="40" value="<%=pack_desc%>" style="margin-left:-4px" >
		<INPUT type='hidden' name='packageCode_temp_<%=i%>' id='packageCode_temp_<%=i%>' value=''>
		<INPUT type='hidden' name='packageDesc_temp_<%=i%>' id='packageDesc_temp_<%=i%>' value=''>
		<input type='button' class='button' name='packageBtn_<%=i%>' id='packageBtn_<%=i%>' value='?'  onClick="pkgLookUp(packageDesc_<%=i%>,packageCode_<%=i%>,'<%=i%>');"style="margin-left: -3px;">
		</td>
		<td  class='fields' width="12%">
			<%if(function_id.equals("VISIT_REGISTRATION") ){
				blng_class_code="OP";
				%><input type='text' size='2' MAXLENGTH ='2'  name='blng_class_code<%=i%>' id='blng_class_code<%=i%>' value='<%=blng_class_code%>' readOnly><input type='text' name = 'blng_class_desc<%=i%>' id = 'blng_class_desc<%=i%>' value="<%=blng_class_code%>" readOnly><%
			}else if(function_id.equals("ADMISSION")) {
			try{
			if(rscurr!=null) rscurr.close();
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement( " select a.blng_class_code, b.short_desc from bl_ip_bed_type a, bl_blng_class_lang_vw b where a.blng_class_code=b.blng_class_code and a.bed_type_code=? and b.language_id=?");
			//System.out.println("bed_type_code="+bed_type_code);
			pstmt.setString(1,bed_type_code);
			pstmt.setString(2,locale);
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				blng_class_code  =  rscurr.getString(1);		
				blng_class_desc  =  rscurr.getString(2);		
			}			
			}catch(Exception e)
			{
				System.out.println("Exception no. of decimal :"+e);
				e.printStackTrace();
			}
		%>
			<input  type='text'  size='2' MAXLENGTH ='2'  name='blng_class_code<%=i%>' id='blng_class_code<%=i%>'  value='<%=blng_class_code%>' readOnly>
			<input type='text' name = 'blng_class_desc<%=i%>' id = 'blng_class_desc<%=i%>' value="<%=blng_class_desc%>" readOnly><%
				}else{%>
		<input  type='text' name='blng_class_code<%=i%>' id='blng_class_code<%=i%>' value='<%=blng_class_code%>' size='2' MAXLENGTH ='2'  onBlur="blngClassCodeLookUp(blng_class_desc<%=i%>,this,'<%=i%>')">
		<input type='text' name = 'blng_class_desc<%=i%>' id = 'blng_class_desc<%=i%>' size='10' onBlur="blngClassDescLookUp(this,blng_class_code<%=i%>,'<%=i%>')" value="<%=blng_class_desc%>" style="margin-left:-4px">
		<input type='button' name='blng_class_button<%=i%>' id='blng_class_button<%=i%>' class='button' value='?' onclick="blngClassLookUp(blng_class_desc<%=i%>,blng_class_code<%=i%>,'<%=i%>')"  style="margin-left: -3px;">
		<%}%>
		<INPUT type='hidden' name='blng_class_code_temp<%=i%>' id='blng_class_code_temp<%=i%>' value=''>
		<INPUT type='hidden' name='blng_class_desc_temp<%=i%>' id='blng_class_desc_temp<%=i%>' value=''>
		</td>
		<% if (siteBLPkgBlngGrp) { %>
		<%if(true && !"".equals(insBlngGrp)){ %>
			<td  class='fields' width="12%" >
			<input  type='text' name='blngGrpCode_<%=i%>' id='blngGrpCode_<%=i%>' value='<%=insBlngGrp%>' size='2' onBlur="blngGrpCodeLookUp(blngGrpDesc_<%=i%>,this,'<%=i%>')">
			<input type='text' name = 'blngGrpDesc_<%=i%>' id = 'blngGrpDesc_<%=i%>' size='10' maxlength='15' onBlur="blngGrpDescLookUp(this,blngGrpCode_<%=i%>,'<%=i%>')" value="<%=insBlngGrpDesc%>">
			<INPUT type='hidden' name='blngGrpCode_temp_<%=i%>' id='blngGrpCode_temp_<%=i%>' value=''>
			<INPUT type='hidden' name='blngGrpDesc_temp_<%=i%>' id='blngGrpDesc_temp_<%=i%>' value=''>
			<input type='button' name='blngGrp_button_<%=i%>' id='blngGrp_button_<%=i%>' class='button' value='?'  onclick="blngGrpLookUp(blngGrpDesc_<%=i%>,blngGrpCode_<%=i%>,'<%=i%>')">
			</td>
		<%}
		else{%>
			<td  class='fields' width="12%">
			<input  type='text' name='blngGrpCode_<%=i%>' id='blngGrpCode_<%=i%>' value='<%=blng_grp_code%>' size='2' onBlur="blngGrpCodeLookUp(blngGrpDesc_<%=i%>,this,'<%=i%>')">
			<input type='text' name = 'blngGrpDesc_<%=i%>' id = 'blngGrpDesc_<%=i%>' size='10' maxlength='15' onBlur="blngGrpDescLookUp(this,blngGrpCode_<%=i%>,'<%=i%>')" value="<%=blng_grp_desc%>">
			<INPUT type='hidden' name='blngGrpCode_temp_<%=i%>' id='blngGrpCode_temp_<%=i%>' value=''>
			<INPUT type='hidden' name='blngGrpDesc_temp_<%=i%>' id='blngGrpDesc_temp_<%=i%>' value=''>
			<input type='button' name='blngGrp_button_<%=i%>' id='blngGrp_button_<%=i%>' class='button' value='?' onclick="blngGrpLookUp(blngGrpDesc_<%=i%>,blngGrpCode_<%=i%>,'<%=i%>')">
			</td>
		<%} %>	
		<%} %>			
		<%if(true && !"".equals(insCustGrp) &&!"".equals(insCust)){ %>
		<td  class='fields' width="12%" >
			<input  type='text' name='payerGrpCode_<%=i%>' id='payerGrpCode_<%=i%>' value='<%=insCustGrp%>' size='2' onBlur="payerGrpCodeLookUp(payerGrpDesc_<%=i%>,this,'<%=i%>')"><input type='text' name = 'payerGrpDesc_<%=i%>' id = 'payerGrpDesc_<%=i%>' size='10' maxlength='15' onBlur="payerGrpDescLookUp(this,payerGrpCode_<%=i%>,'<%=i%>')" value="<%=insCustGrpDesc%>"><INPUT type='hidden' name='payerGrpCode_temp_<%=i%>' id='payerGrpCode_temp_<%=i%>' value=''><INPUT type='hidden' name='payerGrpDesc_temp_<%=i%>' id='payerGrpDesc_temp_<%=i%>' value=''><input type='button' name='payerGrp_button_<%=i%>' id='payerGrp_button_<%=i%>' class='button' value='?'  onclick="payerGrpLookUp(payerGrpDesc_<%=i%>,payerGrpCode_<%=i%>,'<%=i%>')">
		</td>

		<td  class='fields' width="12">
			<input  type='text' name='payerCode_<%=i%>' id='payerCode_<%=i%>' value='<%=insCust%>' size='2' onBlur="payerCodeLookUp(payerDesc_<%=i%>,this,payerGrpCode_<%=i%>,'<%=i%>')"><input type='text' name = 'payerDesc_<%=i%>' id = 'payerDesc_<%=i%>' size='10' maxlength='15' onBlur="payerDescLookUp(this,payerCode_<%=i%>,payerGrpCode_<%=i%>,'<%=i%>')" value="<%=insCustDesc%>"><INPUT type='hidden' name='payerCode_temp_<%=i%>' id='payerCode_temp_<%=i%>' value=''><INPUT type='hidden' name='payerDesc_temp_<%=i%>' id='payerDesc_temp_<%=i%>' value=''><input type='button' name='payer_button_<%=i%>' id='payer_button_<%=i%>' class='button' value='?'  onclick="payerLookUp(payerDesc_<%=i%>,payerCode_<%=i%>,payerGrpCode_<%=i%>,'<%=i%>')">
		</td>
		<%}
		else{%>
			<td  class='fields' width="12%" >
			<input  type='text' name='payerGrpCode_<%=i%>' id='payerGrpCode_<%=i%>' value='<%=payerGrpCode%>' size='2' onBlur="payerGrpCodeLookUp(payerGrpDesc_<%=i%>,this,'<%=i%>')"><input type='text' name = 'payerGrpDesc_<%=i%>' id = 'payerGrpDesc_<%=i%>' size='10' maxlength='15' onBlur="payerGrpDescLookUp(this,payerGrpCode_<%=i%>,'<%=i%>')" value="<%=payerGrpDesc%>"><INPUT type='hidden' name='payerGrpCode_temp_<%=i%>' id='payerGrpCode_temp_<%=i%>' value=''><INPUT type='hidden' name='payerGrpDesc_temp_<%=i%>' id='payerGrpDesc_temp_<%=i%>' value=''><input type='button' name='payerGrp_button_<%=i%>' id='payerGrp_button_<%=i%>' class='button' value='?' onclick="payerGrpLookUp(payerGrpDesc_<%=i%>,payerGrpCode_<%=i%>,'<%=i%>')">
		</td>

		<td  class='fields' width="12%" >
			<input  type='text' name='payerCode_<%=i%>' id='payerCode_<%=i%>' value='<%=payerCode%>' size='2' onBlur="payerCodeLookUp(payerDesc_<%=i%>,this,payerGrpCode_<%=i%>,'<%=i%>')"><input type='text' name = 'payerDesc_<%=i%>' id = 'payerDesc_<%=i%>' size='10' maxlength='15' onBlur="payerDescLookUp(this,payerCode_<%=i%>,payerGrpCode_<%=i%>,'<%=i%>')" value="<%=payerDesc%>"><INPUT type='hidden' name='payerCode_temp_<%=i%>' id='payerCode_temp_<%=i%>' value=''><INPUT type='hidden' name='payerDesc_temp_<%=i%>' id='payerDesc_temp_<%=i%>' value=''><input type='button' name='payer_button_<%=i%>' id='payer_button_<%=i%>' class='button' value='?' onclick="payerLookUp(payerDesc_<%=i%>,payerCode_<%=i%>,payerGrpCode_<%=i%>,'<%=i%>')">
		</td>
		<%} %>
<%			
	//Karthik modified Default From Date for MMS-DM-SCF-0214.1 /MMS-DM-SCF-0152.1
	if(function_id.equals("EBL_PACKAGE_SUBS")){ //function_id.equals("ADMISSION") 
		if (isSiteSpec) {
			fromDate = BLHelper.getSysDate(con,
					"dd/mm/yyyy HH24:MI:SS");
		} else {
			fromDate = BLHelper.getSysDate(con, "dd/mm/yyyy");
		}
		System.out.println("fromDate " + fromDate);
	}else if(function_id.equals("ADMISSION")) {
		if (isSiteSpec)
		{
			fromDate = request.getParameter("firstVisitDateTime") + ":00";
		}else 
		{
			fromDate = request
					.getParameter("firstVisitDateTime");
			fromDate=TruncDate(con, fromDate,"HH24:MI");
		}
		System.out.println("fromDate 0 " + fromDate);
	} 
	else{
			fromDate=request.getParameter("firstVisitDateTime");
			if(!(isSiteSpec)){
		fromDate=TruncDate(con, fromDate,"HH24:MI:SS");}
		System.out.println("fromDate 1" + fromDate);
	}
%>
	<%
		if (isSiteSpec) {
	%>
	<td  class='fields' width="10%"><input type='text' name='fromDate_<%=i%>' id='fromDate_<%=i%>'size='15' maxlength="20"  value="<%=fromDate%>" onBlur="callvalidate(<%=i%>,'<%=function_id%>'); "  ><img id = 'fromDate_img_<%=i%>' name="fromDate_img_<%=i%>"	 src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fromDate_<%=i%>','dd/mm/yyyy hh:mm:ss');" STYLE="display:inline;"></td>
	<%
		} else {
	%>
	<td  class='fields' width="10%"><input type='text' name='fromDate_<%=i%>' id='fromDate_<%=i%>'size='15' maxlength="20"  value="<%=fromDate%>" onBlur="callvalidate(<%=i%>,'<%=function_id%>'); "  ><img id = 'fromDate_img_<%=i%>' name="fromDate_img_<%=i%>"	 src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('fromDate_<%=i%>','dd/mm/yyyy ');" STYLE="display:inline;"></td>
	<%
		}
	%>
	<td  class='fields' width="10%"><input type='text' name='toDate_<%=i%>'  id='toDate_<%=i%>' size='15' maxlength="20"  value="<%=toDate%>"  ReadOnly></td>	

	<td  class='fields' width="9%"><input type='text' name='pkgAmt_<%=i%>'  id = 'pkgAmt_<%=i%>' size='10' maxlength="10"  value="<%=packAmt%>" readonly ></td>
	<!--Added V171212-Gayathri/MMS-DM-CRF-0118-->
	<%if("Y".equals(SiteSpecific_VAT)){%>
	<td  class='fields' width="5%"><input type='text' name='addl_charge_<%=i%>'  id = 'addl_charge_<%=i%>' size='10' maxlength="10"  value="<%=addl_charge_amt%>" readonly ></td>
	<%}%>

	<td  class='fields' width="7%"><input type='text' name='episodeType_<%=i%>'  id = 'episodeType_<%=i%>'  size='11' maxlength="11" value="<%=valid_episode%>"  ReadOnly></td>

	<!-- Added by MuthuN Against 33044 on 15-6-12 & 33717 on 03-07-12-->
	<td class="fields" width='10%' nowrap="nowrap">
		<input type="text"  name="practitioner_name<%=i%>" id="practitioner_name<%=i%>" size='10' value="<%=practitioner_name%>" onBlur="if(this.value!='')callPractSearch(practitioner_id<%=i%>,practitioner_name<%=i%>,<%=i%>);">	
			<input type="button" class="button" name="generic_search<%=i%>" id="generic_search<%=i%>" value="?" onclick="callPractSearch(practitioner_id<%=i%>,practitioner_name<%=i%>,<%=i%>);">
			<%if("Y".equals(pracMandatoryYN)){%>
			<img src='../../eCommon/images/mandatory.gif'>
				<%}%>	<!--KDAH-SCF-0812-TF-->
	 </td>
	<!-- Added by MuthuN Against 33044 on 15-6-12  & 33717 on 03-07-12 -->
	<input type="hidden" name="practitioner_id<%=i%>" id="practitioner_id<%=i%>"  value="<%=practitioner_id%>">
	<input type='hidden' name='strOPYN_<%=i%>' id='strOPYN_<%=i%>' value="<%=strOPYN%>" >
	<input type='hidden' name='strEMYN_<%=i%>' id='strEMYN_<%=i%>' value="" >
	<input type='hidden' name='strIPYN_<%=i%>' id='strIPYN_<%=i%>' value="" >
	<input type='hidden' name='strDCYN_<%=i%>' id='strDCYN_<%=i%>' value="" >			
	</tr>
	<%} %>
	</table>	
	<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
		<tr>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>
		<INPUT type="button" class='button' name='Add' id='Add'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" onclick="addRow('pkgSubs_tabId','<%=function_id%>')" /> </td>
		</tr>
	</table>
<%
	if(!(function_id.equals("EBL_PACKAGE_SUBS")))
	{
%>
		<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
		<tr>
		<td width="25%"  class='labels'></td>
		<td width="25%"  class='labels'></td>			
		<td width="25%"  class='labels'></td>								
		<td width="25%"  class='labels' colspan='4'>
		<INPUT type="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="packageSubsDetails('<%=function_id%>')" /> 
		<INPUT type="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="closeSubs()" /> </td>
		</tr>
	</table>			
<%
		}
%>
</div>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	<input type='hidden' name='total_records' id='total_records' value="<%=totRec%>" >
	<input type='hidden' id='patientId' name='patientId' id='patientId' value="<%=patientId%>" >
	<input type='hidden' name='sysDate' id='sysDate' value="<%=sysDate%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
	<input type='hidden' name='bed_type_code' id='bed_type_code' value="<%=bed_type_code%>" >
	<input type='hidden' name='strMessageId' id='strMessageId' value="" >
	<input type='hidden' name='strErrorText' id='strErrorText' value="" >
	<input type='hidden' name='insCustGrp' id='insCustGrp' value='<%=insCustGrp%>'>
	<input type='hidden' name='insCust' id='insCust' value='<%=insCust%>'>
	<input type='hidden' name='insCustGrpDesc' id='insCustGrpDesc' value='<%=insCustGrpDesc%>'>
	<input type='hidden' name='insCustDesc' id='insCustDesc' value='<%=insCustDesc%>'>
	<input type='hidden' name='site_spec' id='site_spec'  value='<%=isSiteSpec%>'>
	<input type='hidden' name='insBlngGrp' id='insBlngGrp' value='<%=insBlngGrp%>'>		
	<input type='hidden' name='insBlngGrpDesc' id='insBlngGrpDesc' value='<%=insBlngGrpDesc%>'>
	<!--  Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  starts  -->	
	<% String siteId=BLHelper.getDescriptionViaSQL(con,"Select CUSTOMER_ID from SM_SITE_PARAM");  %>
	<input type='hidden' name='siteParam' id='siteParam' value='<%=siteId%>'>	
	<!--Added V171212-Gayathri/MMS-DM-CRF-0118-->
	<input type='hidden' name='SiteSpec_VAT' id='SiteSpec_VAT' value='<%=SiteSpecific_VAT%>'>			
	<!-- Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Ends-->
	<input type="hidden" name="practitioner_name" id="practitioner_name"  value="<%=practitioner_name%>">		
	<input type="hidden" name="charge_logic_yn" id="charge_logic_yn"    value ="<%=chargeLogicYn%>">
	<input type="hidden" name="pkg_sysdate_dflt" id="pkg_sysdate_dflt"    value ="<%=pkgsubDfltDateYN%>">
	<!--  Karthik added for MMS-DM-SCF-0214.1 /MMS-DM-SCF-0152.1   Admission Date Extra Parameter -->
	<input type="hidden" name="firstVisitDateTime" id="firstVisitDateTime"    value ="<%=fromDate%>">
	<!--  Karthik added for  MMS-DM-SCF-0214.1 /MMS-DM-SCF-0152.1   Admission Date Extra Parameter -->
	<% 
	if( (Boolean)session.getAttribute("SITE_PARAM_PACKAGE_ASSOCIATION_ENABLED") && function_id.equals("EBL_PACKAGE_SUBS")){
	%>
		<!-- V220614 added the scrolling -->
		<div id='existingPackages' style="overflow-y:scroll; overflow-x:hidden; height:68vh;"></div>
	<%} %>
	<!-- 		Karthik added code for MMS-RY-SCF-0065 -->
	<input type='hidden' name='allPayerGroupCode' id='allPayerGroupCode' value="<%=request.getParameter("allPayerGroupCode")%>">
	<input type='hidden' name='allPayerCode' id='allPayerCode' value="<%=request.getParameter("allPayerCode")%>">
	<input type='hidden' name='allBlngGroupCode' id='allBlngGroupCode' value="<%=request.getParameter("allBlngGroupCode")%>">
	<input type='hidden' name="facility_id" id="facility_id"  value="<%=facility_id%>">
	<input type='hidden' name='siteBLPkgBlngGrpYN' id='siteBLPkgBlngGrpYN'  value='<%=siteBLPkgBlngGrpYN%>'>	
	<input type='hidden' name='siteBLPkgBlngGrpYN1' id='siteBLPkgBlngGrpYN1'  value='<%=siteBLPkgBlngGrpYN1%>'><!--added against ghl-crf-0639 -->
	<input type='hidden' name='pracMandatoryYN' id='pracMandatoryYN'  value='<%=pracMandatoryYN%>'><!--added against KDAH-SCF-0812-TF -->
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e)
	{
		System.out.println("Exception from Package subscription  :"+e);
		e.printStackTrace();
	}finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>

