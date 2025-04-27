<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.*,eBL.Common.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src='../js/AddModifyPatFinDetailsPkgDiscDtls.js'></script> 
<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
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
		</style>

<% 
	try
	{
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id			= (String)session.getAttribute("facility_id");
		int totRec=1;
		String appr_seq_no = request.getParameter("appr_seq_no") == null ? "1" :request.getParameter("appr_seq_no") ;// IN 20964
		String credit_auth_ref = request.getParameter("credit_auth_ref") == null ? "" :request.getParameter("credit_auth_ref") ;
		String noofdecimal = request.getParameter("noofdecimal") == null ? "" :request.getParameter("noofdecimal") ;
		String payer_grp_code = request.getParameter("payer_grp_code") == null ? "" :request.getParameter("payer_grp_code") ;
		String payer_code = request.getParameter("payer_code") == null ? "" :request.getParameter("payer_code") ;
		String parent_index = request.getParameter("parent_index") == null ? "" :request.getParameter("parent_index") ;
		String patient_id = request.getParameter("patient_id") == null ? "" :request.getParameter("patient_id") ;
		String encounter_date_aft_trunc = request.getParameter("encounter_date_aft_trunc") == null ? "" :request.getParameter("encounter_date_aft_trunc") ;	
		String blng_grp_code= request.getParameter("blng_grp_code") == null ? "" :request.getParameter("blng_grp_code") ;	
		String policy_type_code= request.getParameter("policy_type_code") == null ? "" :request.getParameter("policy_type_code") ;	
		String policy_no= request.getParameter("policy_no") == null ? "" :request.getParameter("policy_no") ;	
		String priority= request.getParameter("priority") == null ? "" :request.getParameter("priority") ;	
		String policy_eff_frm_date= request.getParameter("policy_eff_frm_date") == null ? "" :request.getParameter("policy_eff_frm_date") ;	

		String bean_id		= "PkgApprovalBean" ;
		String bean_name	= "eBL.PkgApprovalBean";
		PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
		
		String bean_id1		= "PkgAssociateBean" ;
		String bean_name1	= "eBL.PkgAssociateBean";
		PkgAssociateBean bean1			= (PkgAssociateBean)getBeanObject( bean_id1, bean_name1, request ) ;
		
		String bean_id2		= "PkgSubsBean" ;
		String bean_name2	= "eBL.PkgSubsBean";
		PkgSubsBean bean2			= (PkgSubsBean)getBeanObject( bean_id2, bean_name2, request ) ;
		
		String pkg_seq_no="";
		String pkg_code="";
		String pkg_desc="";
		String pkg_disc_type="",pkg_disc_amt="",pkg_disc_reason="",pkg_disc_reason_desc="";
		String bean_pkg_seq_no="";
		String bean_pkg_code="";
		String bean_pkg_desc="";
		String pkgDtlsVals="";	

		String row_sel = "";
	
%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="" onSelect="codeArrestThruSelect();" >
	<form name='PkgDtls' id='PkgDtls' action="" method="post" target="messageFrame" >	
	<table class='grid' width='100%' id="PkgDtls_tbl">
		<tr>
			<td  class='COLUMNHEADER' ><fmt:message key="eBL.PackageCode-Desc-Seqno.label" bundle="${bl_labels}"/></td>		
			<td  class='COLUMNHEADER' ><fmt:message key="Common.PackageCode.label" bundle="${common_labels}"/></td>
			<td  class='COLUMNHEADER' ><fmt:message key="eBL.PKG_DESC.label" bundle="${bl_labels}"/></td>
			<td  class='COLUMNHEADER' ><fmt:message key="eBL.PackageDiscount.label" bundle="${bl_labels}"/></td>
			<td  class='COLUMNHEADER' ><fmt:message key="Common.Add.label" bundle="${common_labels}"/></td>
		
		</tr>
	<%
		//String currMapKey=blng_grp_code+"~~"+payer_grp_code+"~~"+payer_code+"~~"+priority+"~~"+policy_type_code+"~~"+policy_no+"~~"+policy_eff_frm_date;
//		String oldMapKey=request.getParameter("oldMapKey") == null ? "" :request.getParameter("oldMapKey") ;
		String oldMapKey= "";
		oldMapKey=blng_grp_code.trim()+"~~"+payer_grp_code.trim()+"~~"+payer_code.trim();
/*
		String mapKey=blng_grp_code+"~~"+payer_grp_code+"~~"+payer_code+"~~"+priority+"~~"+policy_type_code+"~~"+policy_no+"~~"+policy_eff_frm_date
		HashMap payerDtls=(HashMap)bean.getPayerDtls();
		ArrayList payer=(ArrayList)payerDtls.get(mapKey);//'details' member in bean contains this value
		//HashMap hdrDtls=	(HashMap)payer.get(0);//contains Hdr dtls
		HashMap authDtls=	(HashMap)payer.get(1);// contains Credit_auth_ref dtls,appr_seq_no as key
		HashMap pkgApprovals=	(HashMap)payer.get(2);// contains pkg approvals for each appr_seq_no
		authDtls ==>;appr_seq_no as key, value is a record[] => appr_seq_no(String),credit_auth_ref(String),credit_auth_date(String),credit_auth_amt(String),credit_apprd_days(String),pkg_approval_yn(String),pol_validity_chk_date(String)
		pkgApprovals; // appr_seq_no is key and Arraylist =>each value is a String[]=>pkg_seq_no(String),pkg_code(String),pkg_desc(String), appv_amt(String)
*/
	
		HashMap payerDtls=(HashMap)bean.getPayerDtls();
		ArrayList payer=new ArrayList();
		payer=(ArrayList)bean.getDetails();
	
		HashMap pkgApprovals=new HashMap();
		if((payer==null || payer.size()==0) && payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(oldMapKey))
		{
			//payer=new ArrayList((ArrayList)payerDtls.get(oldMapKey));
			payer=bean.getPayerCopy((ArrayList)payerDtls.get(oldMapKey));
			bean.setDetails(payer);
		}
			
		if(payer!=null && payer.size()>0)
		{
			pkgApprovals=	(HashMap)payer.get(2);
		}
		ArrayList creditPkgApprovals=new ArrayList();
		//if(pkgApprovals!=null && pkgApprovals.size()>0 && pkgApprovals.containsKey(credit_auth_ref)){//IN 20964
		if(pkgApprovals!=null && pkgApprovals.size()>0 && pkgApprovals.containsKey(appr_seq_no))
		{	//IN 20964
			// creditPkgApprovals=(ArrayList)pkgApprovals.get(credit_auth_ref);	// IN 20964
			creditPkgApprovals=(ArrayList)pkgApprovals.get(appr_seq_no);	// IN 20964
		}
		if(creditPkgApprovals!=null && creditPkgApprovals.size()>0)
			totRec=creditPkgApprovals.size();
		ArrayList beanPkgDtls=new ArrayList();
		for(int i=0;i<((ArrayList)bean1.getAssociatedPkgs()).size();i++)
		{
			beanPkgDtls.add(((ArrayList)bean1.getAssociatedPkgs()).get(i));	
		}
		//ArrayList beanPkgDtls=(ArrayList)bean1.getAssociatedPkgs();
		ArrayList subsPkgs=(ArrayList)bean2.getSubscribedPkgs();
		for(int i=0;i<subsPkgs.size();i++)
		{
			if(!beanPkgDtls.contains(subsPkgs.get(i)))
			{
				beanPkgDtls.add(subsPkgs.get(i));
			}
		}

		for(int i=0; i<totRec; i++)
		{	
			if(creditPkgApprovals!=null && creditPkgApprovals.size()>0)
			{
				ArrayList record = (ArrayList)creditPkgApprovals.get(i);
				pkg_seq_no	=(String)record.get(0);
				pkg_code	=(String)record.get(1);
				pkg_desc	=(String)record.get(2);
				pkg_disc_type = (String)record.get(4);
				pkg_disc_amt = (String)record.get(5);
				pkg_disc_reason = (String)record.get(6);
				pkg_disc_reason_desc = (String)record.get(7);
				row_sel = "N";
			}
%>
		<tr>
			<td class='fields' >
				<select name='pkg_dtls<%=i%>' id='pkg_dtls<%=i%>' onChange="onChangePkgDtls(this,'<%=i%>');">
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%

			for(int j=0;j<beanPkgDtls.size();j++)
			{
				StringTokenizer st=new StringTokenizer(((String)beanPkgDtls.get(j)),"~~");
				if(st.hasMoreTokens())
				{
					bean_pkg_code=st.nextToken();
				}
				else
				{
					bean_pkg_code="";
				}
				if(st.hasMoreTokens())
					bean_pkg_desc=st.nextToken();
				else
					bean_pkg_desc="";
				if(st.hasMoreTokens())
				{
					bean_pkg_seq_no=st.nextToken();
				}
				else
					bean_pkg_seq_no="";
				if(i==0 )
				{
					if(j<(beanPkgDtls.size()-1))
					{
						pkgDtlsVals=pkgDtlsVals+(String)beanPkgDtls.get(j)+"^~^";
					}
					else
					{
						pkgDtlsVals=pkgDtlsVals+(String)beanPkgDtls.get(j);
					}
				}
				if(((String)beanPkgDtls.get(j)).equals(pkg_code+"~~"+pkg_desc+"~~"+pkg_seq_no))
				{
					row_sel = "Y";
				}
%>
					<option <%=((String)beanPkgDtls.get(j)).equals(pkg_code+"~~"+pkg_desc+"~~"+pkg_seq_no)?"selected":""%> value='<%=(String)beanPkgDtls.get(j)%>' ><%=bean_pkg_code%>-<%=bean_pkg_desc%>-<%=bean_pkg_seq_no%></option>
<%
			}
%>
				</select>
				<input type='hidden' name = 'pkg_seq_no<%=i%>' value="<%=pkg_seq_no%>">
			</td>
<%
			if(row_sel.equals("Y"))
			{
%>
			<td class='fields'><input type='text' name='pkg_code<%=i%>' id='pkg_code<%=i%>' value='<%=pkg_code%>' readonly size='8' maxlength="8"  ></td>
			<td class='fields'><input type='text' name='pkg_desc<%=i%>' id='pkg_desc<%=i%>' value='<%=pkg_desc%>' readonly size='40' maxlength="100"  ></td>
<%
			}
			else	
			{
%>
			<td class='fields'><input type='text' name='pkg_code<%=i%>' id='pkg_code<%=i%>' value='' readonly size='8' maxlength="8"  ></td>
			<td class='fields'><input type='text' name='pkg_desc<%=i%>' id='pkg_desc<%=i%>' value='' readonly size='40' maxlength="100"  ></td>
<%
			}
%>	
			<td class='fields'>
				<a name='pkg_disc_dtls<%=i%>' href='#' onClick='showPkgDiscDtls("<%=i%>");'><fmt:message key="eBL.Dtls.label" bundle="${bl_labels}"/></a>
			</td>
			<td  class='fields'>
<%
			if(i==0)
			{	
%>				<a name='addRow_<%=i%>'  href='#' onClick="addRow('PkgDtls');">+</a>
<%
			}
			if(!row_sel.equals("Y"))
			{
				pkg_disc_type = "";
				pkg_disc_amt = "";
				pkg_disc_reason = "";
				pkg_disc_reason_desc = "";
			}
%>			</td>
		<input type='hidden' name='pkg_disc_type<%=i%>' id='pkg_disc_type<%=i%>' value="<%=pkg_disc_type%>" >
		<input type='hidden' name='pkg_disc_amt<%=i%>' id='pkg_disc_amt<%=i%>' value="<%=pkg_disc_amt%>" >
		<input type='hidden' name='pkg_disc_reason<%=i%>' id='pkg_disc_reason<%=i%>' value="<%=pkg_disc_reason%>" >
		<input type='hidden' name='pkg_disc_reason_desc<%=i%>' id='pkg_disc_reason_desc<%=i%>' value="<%=pkg_disc_reason_desc%>" >
		</tr>
<%
		}
%>
		</table>		
		<input type='hidden' name='total_records' id='total_records' value="<%=totRec%>" >
		<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
		<input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value="<%=credit_auth_ref%>" >
		<input type='hidden' name='appr_seq_no' id='appr_seq_no' value="1" >
		<input type='hidden' name='payer_grp_code' id='payer_grp_code' value="<%=payer_grp_code%>" >
		<input type='hidden' name='payer_code' id='payer_code' value="<%=payer_code%>" >
		<input type='hidden' name='form_name' id='form_name' value="PkgDtls" >
		<input type='hidden' name='parent_index' id='parent_index' value="<%=parent_index%>" >
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
		<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
		<input type='hidden' name='encounter_date_aft_trunc' id='encounter_date_aft_trunc' value="<%=encounter_date_aft_trunc%>" >
		<input type='hidden' name='blng_grp_code' id='blng_grp_code' value="<%=blng_grp_code%>" >
		<input type='hidden' name='policy_type_code' id='policy_type_code' value="<%=policy_type_code%>" >
		<input type='hidden' name='policy_no' id='policy_no' value="<%=policy_no%>" >
		<input type='hidden' name='policy_eff_frm_date' id='policy_eff_frm_date' value="<%=policy_eff_frm_date%>" >
		<input type='hidden' name='pkgDtlsVals' id='pkgDtlsVals' value="<%=pkgDtlsVals%>" >
		<input type='hidden' name='priority' id='priority' value="<%=priority%>" >
		<input type='hidden' name='oldMapKey' id='oldMapKey' value="<%=oldMapKey%>" >

		<!-- Added by muthu against 32361 on 24/5/2012 -->
		<input type="hidden" name='add_button1' id='add_button1' value="">
		<!-- Added by muthu against 32361 on 24/5/2012 -->

</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id1,bean1,request);
		putObjectInBean(bean_id2,bean2,request);
	}
	catch(Exception e)
	{
		System.out.println("Exception from Package subscription  :"+e);
		e.printStackTrace();
	}
%>

