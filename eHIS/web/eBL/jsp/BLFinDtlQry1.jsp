<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
1			 V211020												Mohanapriya K
 */ %>
 
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	CallableStatement call =null;
	String facility_id = "";
	String login_user = "";
	String strSetInd = ""; 
	String strAdmFlag = "";
	String strFamIn = ""; 
	String strFamAss  = "";
	String strNoDep = ""; 	
	String strNonInsBlGrId = ""; 	
	String strNonInsCustCode = "";
	String strGLHol  = ""; 
	String strPatRel  = "";
	String strBillGrp = "";
	String strPatRelGL = "";
	String strCrdDocRef = ""; 	
	String strCrDocRefStDate = "";
	String strCrDocRefEndDate = "";	
	String strResPay  = ""; 	
	String strPatRelnRespPers=""; 	 

	String strepisodetype=""; 
	String strepisodeid=""; 
	String strvisitid="";
	String strpatientid="";
	String str_ref_src_main_desc="";
	String str_ref_src_sub_desc="";
	String str_ref_src_code_flag="";
	Boolean SiteSpec=false;
	Boolean siteSpecUploadDocAll=false;//Added V200225-MuthuN/GHL-CRF-0550
	String str_ref_src_main_code = "", str_ref_src_sub_code="";
	String str_ref_src_main_long_name="", str_ref_src_sub_long_name="";
//	String streffFromDate ="";  	String streffToDate=""; String strfinRemarks="";
//	int intNoDep=0;

	int noofdecimal = 2;
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs3 = null;

	String locale	= (String)session.getAttribute("LOCALE");

	request.setCharacterEncoding("UTF-8");

	try
	{
		con = ConnectionManager.getConnection(request);
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");
		strBillGrp =	request.getParameter("strBillGrp");
		if(strBillGrp==null) strBillGrp="";
		strSetInd =	request.getParameter("strSetInd");	
		if(strSetInd==null) strSetInd="";
		strAdmFlag =	request.getParameter("strAdmFlag");	
		if(strAdmFlag==null) strAdmFlag="";
		strFamIn =	request.getParameter("strFamIn");	
		if(strFamIn==null) strFamIn="";
		strFamAss =	request.getParameter("strFamAss");	
		if(strFamAss==null) strFamAss="";
		strNoDep =	request.getParameter("strNoDep");	
		if(strNoDep==null) strNoDep="";
		strNonInsBlGrId =	request.getParameter("strNonInsBlGrId");	
		if(strNonInsBlGrId==null) strNonInsBlGrId="";
		strNonInsCustCode =	request.getParameter("strNonInsCustCode");	
		if(strNonInsCustCode==null) strNonInsCustCode="";
		strGLHol =	request.getParameter("strGLHol");
		if(strGLHol==null) strGLHol="";
		strPatRel =	request.getParameter("strPatRel");	
		if(strPatRel==null) strPatRel="";
		strPatRelGL =	request.getParameter("strPatRelGL");	
		if(strPatRelGL==null) strPatRelGL="";
		strCrdDocRef =	request.getParameter("strCrdDocRef");
		if(strCrdDocRef==null) strCrdDocRef="";
		strCrDocRefStDate =	request.getParameter("strCrDocRefStDate");
		if(strCrDocRefStDate==null) strCrDocRefStDate="";
		strCrDocRefEndDate =	request.getParameter("strCrDocRefEndDate");
		if(strCrDocRefEndDate==null) strCrDocRefEndDate="";
		strResPay =	request.getParameter("strResPay");
		if(strResPay==null) strResPay="";
		strPatRelnRespPers =	request.getParameter("strPatRelnRespPers");
		if(strPatRelnRespPers==null) strPatRelnRespPers="";
		strepisodetype = request.getParameter("episodetype");
		if(strepisodetype==null) strepisodetype="";
		strepisodeid = request.getParameter("episodeid");
		if(strepisodeid==null) strepisodeid="";
		strvisitid = request.getParameter("visitid");
		if(strvisitid==null) strvisitid="";
		strpatientid= request.getParameter("patientid");
		if(strpatientid==null) strpatientid="";
//		intNoDep=Integer.parseInt(strNoDep);
		
//		str_ref_src_main_desc=request.getParameter("ref_src_main_desc");
//		if(str_ref_src_main_desc == null) str_ref_src_main_desc="";

//		str_ref_src_sub_desc=request.getParameter("ref_src_sub_desc");
//		if(str_ref_src_sub_desc == null) str_ref_src_sub_desc="";

		str_ref_src_code_flag=request.getParameter("referral_source_code_flag");
		if(str_ref_src_code_flag == null) str_ref_src_code_flag="";

		str_ref_src_main_code = request.getParameter("ref_src_main_code");
		if(str_ref_src_main_code == null) str_ref_src_main_code="";

		str_ref_src_sub_code = request.getParameter("ref_src_sub_code");
		if(str_ref_src_sub_code == null) str_ref_src_sub_code="";

	
		
		try
		{
			//con = ConnectionManager.getConnection(request); //V211020
			 SiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","VIEW_FINANCIAL_DETAIL");
			 siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");//Added V200225-MuthuN/GHL-CRF-0550
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in site specific "+e);
		}
		
		try
		{	
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs3 = pstmt.executeQuery();	
			while(rs3.next())
			{
				noofdecimal  =  rs3.getInt(1);		
			}
			CurrencyFormat cf = new CurrencyFormat();

			if(!strFamIn.equals(""))
				strFamIn = cf.formatCurrency(strFamIn, noofdecimal);

			if(!strFamAss.equals(""))
				strFamAss = cf.formatCurrency(strFamAss, noofdecimal);
		}
		catch(Exception e)
		{
			System.out.println("Error in Currency Conversion="+e.toString());
			e.printStackTrace();
		}
		rs3.close();
		pstmt.close();

		if(!str_ref_src_main_code.equals(""))
		{
			call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
			call.registerOutParameter(1,java.sql.Types.VARCHAR);

			call.setString(2,str_ref_src_main_code);
			call.setString(3,locale);
			call.setString(4,"1");

			call.execute();							
			str_ref_src_main_desc = call.getString(1);				
			call.close();
			if ( str_ref_src_main_desc == null ) str_ref_src_main_desc = "";

			call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
			call.registerOutParameter(1,java.sql.Types.VARCHAR);

			call.setString(2,str_ref_src_main_code);
			call.setString(3,locale);
			call.setString(4,"3");

			call.execute();							
			str_ref_src_main_long_name = call.getString(1);				
			call.close();
			if ( str_ref_src_main_long_name == null ) str_ref_src_main_long_name = "";
		}

		if(!str_ref_src_sub_code.equals(""))
		{
			call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
			call.registerOutParameter(1,java.sql.Types.VARCHAR);

			call.setString(2,str_ref_src_sub_code);
			call.setString(3,locale);
			call.setString(4,"1");

			call.execute();							
			str_ref_src_sub_desc = call.getString(1);				
			call.close();
			if ( str_ref_src_sub_desc == null ) str_ref_src_sub_desc = "";

			call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
			call.registerOutParameter(1,java.sql.Types.VARCHAR);

			call.setString(2,str_ref_src_sub_code);
			call.setString(3,locale);
			call.setString(4,"3");

			call.execute();							
			str_ref_src_sub_long_name = call.getString(1);				
			call.close();
			if ( str_ref_src_sub_long_name == null ) str_ref_src_sub_long_name = "";
		}
%>

<html>
<head>
<script>

function scrollTitle()
{
	var x = document.body.scrollTop;
	if(x == 0)
	{
		document.getElementById("divTitleTable").style.position = 'relative';
	    document.getElementById("divTitleTable").style.posTop  = 0;
	}
	else
	{
		document.getElementById("divTitleTable").style.position = 'relative';
		document.getElementById("divTitleTable").style.posTop  = x-2;
	}
}

function closepatctr()
{
	window.close()
}

//Dhanasekar
async function uploadImage(){
/*	var dialogUrl       = "../../eBL/jsp/AddModifyPatFinDetailsUpload.jsp?title=Upload Document" ;
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "70" +" ; scroll=auto; ";
	*/
	var patient_id = document.forms[0].strPatientId.value;
	var strepisodeid=document.getElementById('strepisodeid').value;
	var strvisitid=document.getElementById('strvisitid').value;
	var strSetInd = document.getElementById("strSetInd").value;//28-08-2020
	//var dialogUrl       = "../../eBL/jsp/AddModifyInsUpldImgFrame.jsp?title=Upload Document&patient_id="+patient_id;

	var dialogUrl       = "../../eBL/jsp/AddModifyInsUpldImgDtlNew.jsp?title=Upload Document&patient_id="+patient_id+"&strepisodeid="+strepisodeid+"&strvisitid="+strvisitid+"&settlement_ind="+strSetInd+"&pat_view=Y";//28-08-2020

	var dialogFeatures  = "dialogHeight:" + "40vh" + "; dialogWidth:" + "94vw" +" ; scroll=auto; ";
	var returnVal = await window.showModalDialog(dialogUrl,null,dialogFeatures);	
}


</script>


	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<table border='0' cellpadding='6' cellspacing='0' width='100%' align='center'>

	<tr>
	<% 
	if(SiteSpec==true)
	{
		//System.out.println("In if");
	%>
		<td width='25%'  class='label'><fmt:message key="eBL.BillingGroupId.label" bundle="${bl_labels}"/></td>
<% 
	}
 else
{

		//System.out.println("In else");
	%>
	
		<td width='25%'  class='label'><fmt:message key="eBL.PRIMARY_BILLING_GROUP.label" bundle="${bl_labels}"/></td>
	
	<%
}
	%>
	<!--
		<td width='25%' class="data"><input type='text' name='strBillGrp' id='strBillGrp' size='20' readonly maxlength='30'  value='<%=strBillGrp.equals("null")?"":strBillGrp%>' ></td>
-->
		<td width='25%' class="data"><%=strBillGrp.equals("null")?"":strBillGrp%></td>
		<td width='25%' class="data"></td>
		<td width='25%' class="data"></td>
<!--
		<td width="25%" align='right'><input type='button' class='button' onclick='closepatctr()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" ></td>
-->
	</tr>

	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.FAMILY_ANNUAL_INCOME.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='strFamIn' id='strFamIn' size='15' readonly maxlength='30' value='<%=strFamIn.equals("null")?"":strFamIn%>' style='text-align:right'></td>
-->
		<td width='25%' class="data"><%=strFamIn.equals("null")?"":strFamIn%></td>
		<td width='25%'  class='label'><fmt:message key="eBL.FAMILY_ASSET.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='strFamAss' id='strFamAss' size='15' readonly maxlength='30'  value='<%=strFamAss.equals("null")?"":strFamAss%>' style='text-align:right'></td>	
-->
		<td width='25%' class="data"><%=strFamAss.equals("null")?"":strFamAss%></td>
	</tr>

	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.NO_OF_DEPENDANTS.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='strNoDep' id='strNoDep' size='15' readonly maxlength='30'  value='' style='text-align:right'></td>
-->
		<td width='25%' class="data"><%=strNoDep%></td>
		<td width='25%' class="data"></td>
		<td width='25%' class="data"></td>
	</tr>

<%
	if(strSetInd.equals("C"))
	{
%>
	<tr>
		<td width='25%'  class='label'><fmt:message key="eBL.RESPONSIBLE_FOR_PAYMENT.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='strResPay' id='strResPay' size='15' readonly maxlength='30' value='<%=strResPay.equals("null")?"":strResPay%>' ></td>
-->
		<td width='25%' class="data"><%=strResPay%></td>
		<td width='25%'  class='label'><fmt:message key="eBL.PATIENT_RELN_WITH_RESP_PERSON.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='strPatRel' id='strPatRel' size='15' readonly maxlength='30'  value='<%=strPatRel.equals("null")?"":strPatRel%>'></td>
-->
		<td width='25%' class="data"><%=strPatRel%></td>
    </tr>		
<%
	}
	else if(!strSetInd.equals("C"))
	{
%>
	<tr>
        <td width='25%'  class='label'><fmt:message key="eBL.GL_HOLDER_NAME.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='strGLHol' id='strGLHol' size='15' readonly maxlength='30'  value='<%=strGLHol.equals("null")?"":strGLHol%>'></td>	
-->
		<td width='25%' class="data"><%=strGLHol%></td>
		<td width='25%'  class='label'><fmt:message key="eBL.PATIENT_RELN_WITH_GL_HOLDER.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='strPatRelGL' id='strPatRelGL' size='15' readonly maxlength='30'  value='<%=strPatRelGL.equals("null")?"":strPatRelGL%>' ></td>	
-->
		<td width='25%' class="data"><%=strPatRelGL%></td>
	</tr>
<%
	}
	if(str_ref_src_code_flag.equals("Y"))
	{
%>
	<tr>
		<td width='25%' class='label'><fmt:message key="eBL.PMY_REF_SRC.label" bundle="${bl_labels}"/></td>
<!--	
		<td width='25%' class="data"><input type='text' name='strPrmyRefSrc' id='strPrmyRefSrc' size='20' readonly maxlength='30'  value='<%=str_ref_src_main_desc%>'></td>
-->
		<td width='25%' class="data">
<%
		if(!str_ref_src_main_long_name.equals(""))
		{
%>
		<%=str_ref_src_main_desc%>&nbsp;<img src='../../eCommon/images/more.gif' style="visibility:inline" alt='<%=str_ref_src_main_long_name%>'>
<%
		}
		else
		{
%>
		<%=str_ref_src_main_desc%>
<%
		}
%>
		</td>
		<td width='25%' class='label'><fmt:message key="eBL.SEC_REF_SRC.label" bundle="${bl_labels}"/></td>
<!--
		<td width='25%' class="data"><input type='text' name='strSecRefSrc' id='strSecRefSrc' size='20' readonly maxlength='30'  value='<%=str_ref_src_sub_desc%>'></td>
-->
		<td width='25%' class="data">
<%
		if(!str_ref_src_sub_long_name.equals(""))
		{
%>
		<%=str_ref_src_sub_desc%>&nbsp;<img src='../../eCommon/images/more.gif' style="visibility:inline" alt='<%=str_ref_src_sub_long_name%>'>
<%
		}
		else
		{
%>
		<%=str_ref_src_sub_desc%>
<%
		}
%>
		</td>
	</tr>
<%
	}
%>

<% 
	if(siteSpecUploadDocAll==true)
	{
%>
	<tr>
		<td colspan='4'>&nbsp;
		<a href="javascript:uploadImage()"><fmt:message key="eBL.ViewDocuments.label" bundle="${bl_labels}"/></a>
	</td>
	</tr>
<%
	}else{
%>
	<tr>
		<td colspan='4'>&nbsp;
		<a href="javascript:uploadImage()"><fmt:message key="eBL.INSIMAGEUPLOADDOC.label" bundle="${bl_labels}"/></a>
	</td>
	</tr>
<%
	}
%>	
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>

</table>

<input type= 'hidden' name="locale" id="locale"  value='<%=locale%>'>
<input type= 'hidden' name="strBillGrp" id="strBillGrp"  value="<%=strBillGrp%>">
<input type='hidden' name='strFamIn' id='strFamIn' value='<%=strFamIn%>'>
<input type='hidden' name='strPatRel' id='strPatRel' value="<%=strPatRel%>">
<input type='hidden' name='strGLHol' id='strGLHol' value="<%=strGLHol%>">
<input type='hidden' name='strResPay' id='strResPay' value="<%=strResPay%>">
<input type='hidden' name='strNoDep' id='strNoDep' value='<%=strNoDep%>'>
<input type='hidden' name='strPatRelGL' id='strPatRelGL' value="<%=strPatRelGL%>">
<input type='hidden' name='strResPay' id='strResPay' value="<%=strResPay%>">
<input type='hidden' name='strFamAss' id='strFamAss' value='<%=strFamAss%>'>
<input type='hidden' name='strPatientId' id='strPatientId' value='<%=strpatientid%>'>
<input type='hidden' name='strepisodeid' id='strepisodeid' value='<%=strepisodeid%>' id='strepisodeid'>
<input type='hidden' name='strvisitid' id='strvisitid' value='<%=strvisitid%>' id='strvisitid'>
<input type='hidden' name='strSetInd' id='strSetInd' value='<%=strSetInd%>' id='strSetInd'>
</form>
</body>
<%
	}
	catch(Exception eX)
	{
		System.out.println("Error in Qry1.jsp= "+eX);
		eX.printStackTrace();
	}
	finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
</html>

