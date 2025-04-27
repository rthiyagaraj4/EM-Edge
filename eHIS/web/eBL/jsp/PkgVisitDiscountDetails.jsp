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
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eBL/js/PkgVisitDiscount.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
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
		/*String appr_seq_no = request.getParameter("appr_seq_no") == null ? "1" :request.getParameter("appr_seq_no") ;// IN 20964
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
		*/

		/*String bean_id		= "PkgApprovalBean" ;
		String bean_name	= "eBL.PkgApprovalBean";
		PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
		*/
		
		String bean_id1		= "PkgAssociateBean" ;
		String bean_name1	= "eBL.PkgAssociateBean";
		PkgAssociateBean bean1			= (PkgAssociateBean)getBeanObject( bean_id1, bean_name1, request ) ;
		
		String bean_id2		= "PkgSubsBean" ;
		String bean_name2	= "eBL.PkgSubsBean";
		PkgSubsBean bean2			= (PkgSubsBean)getBeanObject( bean_id2, bean_name2, request ) ;
		

		String bean_id		= "PkgDiscountBean" ;
		String bean_name	= "eBL.PkgDiscountBean";
		PkgDiscountBean bean	= (PkgDiscountBean)getBeanObject( bean_id, bean_name, request ) ;





		String pkg_seq_no="";
		String pkg_code="";
		String pkg_desc="";
		String pkg_disc_type="",pkg_disc_amt="",pkg_disc_reason="",pkg_disc_reason_desc="";
		String bean_pkg_seq_no="";
		String bean_pkg_code="";
		String bean_pkg_desc="";
		String pkgDtlsVals="";	
		String cust_grp_code ="";
		String cust_code = "";
		String cust_desc = "";
		String  pkgAmt=""; // Added Vijay for MMS-ICN-00025
		
		String row_sel = "";
		String tempPkgCode = ""; //Added for Duplicate Pkg Rajesh V
				
		//Added By Vijay For MMS-ICN-00025
		Connection connection 		= ConnectionManager.getConnection();	
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;	
		String noofdecimal = "";
	
		
		
		try
		{
			String sql = "select nvl(no_of_decimal,2) noofdecimal from  sm_acc_entity_param";
			pstmt=connection.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next())
				noofdecimal = rs.getString("noofdecimal");
				System.out.println("noofdecimal "+noofdecimal);
		}
		catch(Exception e)
		{
			System.out.println("Exception from getNoOfDecimal :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			/* Commented V180619-Aravindh/IN67992/AMS-SCF-0667/Below Line */
			//if(connection!=null) ConnectionManager.returnConnection(connection);
		}
				
		/* Added V180619-Aravindh/IN67992/AMS-SCF-0667/Starts */
		boolean pkgAmtValidSiteSpec = false;		
		try
		{
			pkgAmtValidSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(connection, "BL","BL_PKG_DISC_ARRAY_VAL");
			System.out.println("PkgVisitDiscountDetails.jsp->pkgAmtValidSiteSpec: "+pkgAmtValidSiteSpec);
		}
		catch(Exception e)
		{
			System.err.println("Exception from getpkgAmtValidSiteSpec :"+e);
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection);
		}		
		/* Added V180619-Aravindh/IN67992/AMS-SCF-0667/Ends */
				
	
%>
	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onload="" onSelect="codeArrestThruSelect();" >
	<form name='PkgDtls' id='PkgDtls' action="" method="post" target="messageFrame" >	
	<table class='grid' width='100%' id="PkgDtls_tbl">
	
	<%
	
	int plcy_count=   Integer.parseInt(request.getParameter("plcy_count") == null ? "0" :request.getParameter("plcy_count")) ;
	String plcyrecd[]=new String[plcy_count+1];	
	
	System.out.println(" plcy count "+plcy_count);
	int k;	
		
		for(k =0;k<plcy_count; k++)
		{
		  plcyrecd[k] = request.getParameter("insCustGrp"+k)+"~"+ request.getParameter("insCust"+k) +"~"+  request.getParameter("insCustDesc"+k) ;	

		    System.out.println("plcy record "+plcyrecd[k]);
		  
		  %>
		  <input type='hidden' name= 'cust_dtls<%=k%>' value="<%=plcyrecd[k]%>"  >
		  <%
		}
	
		  plcyrecd[k] = "CASH~ ~ ";
		  %>		  
	 		<input type='hidden' name= 'cust_dtls<%=k%>' value='CASH~ ~ '  >
	
	
	
		<tr>
				<th  class='COLUMNHEADER' ><fmt:message key="eBL.PackageCode-Desc-Seqno.label" bundle="${bl_labels}"/></th>
				<th class='columnheader'><fmt:message key="eBL.CUST_GROUP_DESC.label" bundle="${bl_labels}"/></th>						
				<th  class='columnheader'><fmt:message key="eBL.PERC_AMOUNT.label" bundle="${bl_labels}"/></th>
				<th  class='columnheader'><fmt:message key="eBL.ADHOC_DISC_AMT.label" bundle="${bl_labels}"/></th>
				<th  class='columnheader'><fmt:message key="eBL.ADHOC_DISC_REASON.label" bundle="${bl_labels}"/></th>
				<th   class='COLUMNHEADER' ><fmt:message key="Common.Add.label" bundle="${common_labels}"/></th>
		
		</tr>
	<%

		//String oldMapKey= "";
		//oldMapKey=blng_grp_code.trim()+"~~"+payer_grp_code.trim()+"~~"+payer_code.trim();

	//	HashMap payerDtls=(HashMap)bean.getPayerDtls();
	//	ArrayList payer=new ArrayList();
	//	payer=(ArrayList)bean.getDetails();
	
	//	HashMap pkgApprovals=new HashMap();
		/*if((payer==null || payer.size()==0) && payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(oldMapKey))
		{
			//payer=new ArrayList((ArrayList)payerDtls.get(oldMapKey));
			payer=bean.getPayerCopy((ArrayList)payerDtls.get(oldMapKey));
			bean.setDetails(payer);
		}
			
		if(payer!=null && payer.size()>0)
		{
			pkgApprovals=	(HashMap)payer.get(2);
		}*/
		ArrayList creditPkgApprovals=new ArrayList();
		//if(pkgApprovals!=null && pkgApprovals.size()>0 && pkgApprovals.containsKey(credit_auth_ref)){//IN 20964
	/*	if(pkgApprovals!=null && pkgApprovals.size()>0 && pkgApprovals.containsKey(appr_seq_no))
		{	//IN 20964
			// creditPkgApprovals=(ArrayList)pkgApprovals.get(credit_auth_ref);	// IN 20964
			creditPkgApprovals=(ArrayList)pkgApprovals.get(appr_seq_no);	// IN 20964
		}

		*/

		 creditPkgApprovals=(ArrayList)bean.getdiscPkgs();

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
			System.out.println("beanPkgDtls "+beanPkgDtls.toString());
			
			}
		}



		for(int i=0; i<totRec; i++)
		{	
			if(creditPkgApprovals!=null && creditPkgApprovals.size()>0)
			{
				
				//Pakagecode~~PackageseqNo~~Disc type~~Disc amount~~Reason code~~Reason desc~~cust_grp_code~~custcode
				String record[] = ((String)creditPkgApprovals.get(i)).split("~~");
				pkg_code	=record[0].trim();
				pkg_seq_no	=record[1].trim();
				pkg_disc_type = record[2].trim();
				pkg_disc_amt = record[3].trim();
				pkg_disc_reason = record[4].trim();
				pkg_disc_reason_desc = record[5].trim();
				cust_grp_code = record[6];
				cust_code	=   record[7];
				cust_desc   =   record[8];				
				pkgAmt=record[9];
				System.out.println("pkgAmt bean val "+pkgAmt);
				//System.out.println("record vals "+" i "+ i +record[i].toString());
				
				row_sel = "N";
			}
%>
		<tr>
			<td class='fields' >
				<select name='pkg_dtls<%=i%>' id='pkg_dtls<%=i%>' onChange="onChangePkgDiscDtls(this,'<%=i%>');">
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%

			for(int j=0;j<beanPkgDtls.size();j++)
			{
				StringTokenizer st=new StringTokenizer(((String)beanPkgDtls.get(j)),"~~");
				if(st.hasMoreTokens())
				{
					bean_pkg_code=st.nextToken();
					try{
						tempPkgCode = bean_pkg_code.substring(0,bean_pkg_code.lastIndexOf("@:"));
					}
					catch(Exception pkgEx){
						tempPkgCode = bean_pkg_code;
					}
				}
				else
				{
					bean_pkg_code="";
					tempPkgCode = "";
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
					<option <%=((String)beanPkgDtls.get(j)).startsWith(pkg_code+"~~")?"selected":""%> value='<%=(String)beanPkgDtls.get(j)%>' ><%=tempPkgCode%>-<%=bean_pkg_desc%>-<%=bean_pkg_seq_no%></option>
<%
			}
%>
				</select>
				<input type='hidden' name = 'pkg_code<%=i%>' value="<%=pkg_code%>">
				<input type='hidden' name = 'pkg_desc<%=i%>' value="<%=pkg_desc%>">
				<input type='hidden' name = 'pkg_seq_no<%=i%>' value="<%=pkg_seq_no%>">
		
				<input type='hidden' id='pkg_amt<%=i %>' name='pkg_amt<%=i %>' value='<%=pkgAmt%>'>
										
				
			</td>



	
			<td class='fields'>	<select name='pkg_cust_desc<%=i%>' id='pkg_cust_desc<%=i%>'  onChange="onChangePkgCustDtls(this,'<%=i%>');"  >	<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>		
			<%
			for(int j=0;j<plcy_count+1;j++)	{	%>
			<option value="<%=plcyrecd[j]%>" <%=(plcyrecd[j]).startsWith(cust_grp_code+"~"+cust_code)?"selected":""%>  ><%=plcyrecd[j]%></option>
			<%}%>
				<input type='hidden' name = 'cust_grp<%=i%>' value="<%=cust_grp_code%>">
				<input type='hidden' name = 'cust_code<%=i%>' value="<%=cust_code%>">				
				<input type='hidden' name = 'cust_desc<%=i%>' value="<%=cust_desc%>">
			</select>
			</td>			
			

		

			<td class='fields'>
			
			<select name='pkg_disc_type<%=i%>' id='pkg_disc_type<%=i%>'  onChange="resetDiscAmt(this,'<%=i%>');"  >
			<option value='A' <%=pkg_disc_type.equals("A")?"selected":""%> ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></option>
			<option value='R' <%=pkg_disc_type.equals("R")?"selected":""%> ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/></option>
			</select>
				
			</td>
			
			<td class='fields'>
				<input type='text' name='pkg_disc_amt<%=i%>' id='pkg_disc_amt<%=i%>' value='<%=pkg_disc_amt%>' onBlur="chkAmtDiscPer1(this,'<%=i%>');"    size='8' maxlength="8"  >
			</td>
			
			<td class='fields'>
			<input type='text' name='reason_desc<%=i%>' id='reason_desc<%=i%>' value='<%=pkg_disc_reason_desc %>'  size='8' maxlength="8"  ><input type='hidden' name='reason_code<%=i%>' id='reason_code<%=i%>' value='<%=pkg_disc_reason%>'><input type='button' class='button' name="reasonbut<%=i%>" id="reasonbut<%=i%>" value='?' onClick="searchDiscountReason('C','<%=i%>')"><img src='../../eCommon/images/mandatory.gif'>
			</td>
			
			<td  class='fields'>
<%
			if(i==0)
			{	
%>				<a name='addRow_<%=i%>'  href='#' onClick="addRowDiscount('PkgDtls');">+</a>
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
		
		</tr>
<%
		}
%>
		</table>		
		<input type='hidden' name='plcy_count' id='plcy_count' value="<%=(plcy_count+1)%>" >
		<input type='hidden' name='total_records' id='total_records' value="<%=totRec%>" >
		<input type='hidden' name='form_name' id='form_name' value="PkgDtls" >
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
		<input type='hidden' name='pkgDtlsVals' id='pkgDtlsVals' value="<%=pkgDtlsVals%>" >
		<input type='hidden' name='auth_discount' id='auth_discount' value='N' >
		<input type='hidden' name='noofdecimal' id='noofdecimal' value='<%=noofdecimal%>'>
	
		<input type='hidden' name='beanPkgDtlssize' id='beanPkgDtlssize' id='beanPkgDtlssize' value='<%=beanPkgDtls.size()%>'>
		<!-- Added V180619-Aravindh/IN67992/AMS-SCF-0667/Below Line--siteID -->
	 	<input type='hidden' name='siteId' id='siteId' id='pkgAmtValidSiteSpec' value='<%=pkgAmtValidSiteSpec %>' />
</form>
</body>
</html>
<%
	
	}
	catch(Exception e)
	{
		System.out.println("Exception from Package subscription  :"+e);
		e.printStackTrace();
	}
%>

