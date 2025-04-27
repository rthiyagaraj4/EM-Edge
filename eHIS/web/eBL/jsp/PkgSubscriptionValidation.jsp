
<%@page import="java.sql.Date,java.text.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="eBL.Common.BlRepository"%>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.PkgSubsBean,eBL.PkgEnterReceptRefundBean, eCommon.Common.*,webbeans.op.CurrencyFormat,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="org.json.simple.JSONObject"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V220321             29311 	       	MMS-MD-SCF-0194		           Mohana Priya K
-----------------------------------------------------------------------------------------------
*/
%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	ResultSet rs_pkd,rs=null;ResultSet rs_pat=null;

try{	
	String locale			= (String)session.getAttribute("LOCALE");
	String facilityId		= (String) session.getValue( "facility_id" ) ;
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
	CurrencyFormat cf1 = new CurrencyFormat();
	int rec_count=0;
	String pkgPrice="",strMessageId="",strErrorLevel="",strErrorText="",effToDate="";
	String pkgvaliddays="";
	String pkgpricefactor="";
	String custdiscountind="";
	String custdiscountamt="";
	String blnggrpdiscountind=""; 	//Added By Shikha For GHL-CRF-0520.1
	String blnggrpdiscountamt="";  	//Added By Shikha For GHL-CRF-0520.1
	String addl_charge="";//Added V171212-Gayathri/MMS-DM-CRF-0118
	String practitioner_id = ""; //added for IN033044
	String practitioner_name ="";
	String sqlStr="";

	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
	String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;
	String calledFrom=request.getParameter("calledFrom") == null ? "" :request.getParameter("calledFrom");
	int noofdecimal=0;
	//Added V171212-Gayathri/MMS-DM-CRF-0118
	
	Boolean SiteSpec_VAT=false;
	String SiteSpecific_VAT ="";
	String chargeOnAdmVstDateYN = "N", subsDateFmt = "";//Added V191115-Aravindh/GHL-CRF-0520

	//Added By Shikha For GHL-CRF-0520.1
	boolean siteBLPkgBlngGrp = false; 
	String siteBLPkgBlngGrpYN = "N";
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
	
	Boolean allowMasterChildPack=false;
	String allowMasterChildPack_map ="";
	try
	{
		allowMasterChildPack = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ALLOW_MASTER_CHILD_PKG_MAPPING");	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	if(allowMasterChildPack){
		allowMasterChildPack_map="Y";
	}
	else{
		allowMasterChildPack_map="N";
	}
	
	try
	{		
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		ResultSet rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);		
		}		
		rscurr.close();
		pstmt.close();
	}
	catch(Exception e)
	{
		System.err.println("PkgSubscriptionValidation 3="+e.toString());
	}
	//Added for NMC-JD-CRF-0084 starts on 260121
	boolean siteBlrecordButEnable = false;
	String siteBlrecordButYN="N";	
	try{
		siteBlrecordButEnable = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DONT_CHK_FACILITY_IN_FIN_DTLS");	
		if (siteBlrecordButEnable)
			siteBlrecordButYN = "Y";
		else
			siteBlrecordButYN = "N";
	}catch(Exception e){
		e.printStackTrace();
	}	
	//Added for NMC-JD-CRF-0084 on 260121 ends
	
	/* Added V191115-Aravindh/GHL-CRF-0520/Starts */
	try {
		pstmt = con.prepareStatement("select nvl(charge_on_adm_vst_date_yn,'N') charge_on_adm_vst_date_yn from bl_parameters where operating_facility_id = '"+facilityId+"'");
		ResultSet rscurr = pstmt.executeQuery();
		if(rscurr.next()) {
			chargeOnAdmVstDateYN = rscurr.getString("charge_on_adm_vst_date_yn");
		}
		rscurr.close();
		pstmt.close();
	} catch(Exception ex) {
		System.err.println("Error in PkgSubscripitonValidaiton for getting value in BLParameters: "+ex);
		ex.printStackTrace();
	}
	/* Added V191115-Aravindh/GHL-CRF-0520/Ends */	
	
	if("ChildPack".equals(func_mode))
	{  
		try{
			if("Y".equals(allowMasterChildPack_map))
			{
				String packageCode = request.getParameter("packageCode");
				String fromdate	   = request.getParameter("fromdate");
				String toDate	   = request.getParameter("toDate");
				int count          = 0;
				sqlStr="select count(*) FROM bl_package_period a, bl_package_child_dtl b WHERE a.operating_facility_id = b.operating_facility_id AND a.package_code = b.package_code AND a.eff_from_date = b.mast_eff_from_date AND a.operating_facility_id = '"+facilityId+"' AND a.package_code = '"+packageCode+"'  AND to_date('"+fromdate+"','dd/mm/yyyy') BETWEEN b.eff_from_date AND NVL (b.eff_to_date, to_date('"+toDate+"','dd/mm/yyyy')) ";
				pstmt=con.prepareStatement(sqlStr);	
				rs	= pstmt.executeQuery();
				if(rs !=null && rs.next()){
					count = rs.getInt(1);
				}
				JSONObject obj=new JSONObject();
				obj.put("count",count);
				out.print(obj);
				out.flush();		
			}	
		}
		catch(Exception e)
		{
			System.err.println("3="+e.toString());
		}	
	}
	
	if(function_id!= null && function_id.equals("DUPLICATE_CHECK"))
	{  		
		ArrayList pkgCodes     = new ArrayList();
		int totRec		    = Integer.parseInt((String) hash.get( "total_records" ));
		int	index	    	= Integer.parseInt((String) hash.get( "index" ));	
		String item	= (String) hash.get( "item" );
		for(int i=0;i<totRec; i++)
		{
			if(i!=index)
			pkgCodes.add((String) hash.get( "code_"+i ));
		}
		if(pkgCodes.contains(item))
			out.println("duplicateAlert('"+index+"')");
		else
			out.println("callSysdate('"+index+"')");
	}
	else if(function_id!= null && (function_id.equals("VISIT_REGISTRATION") || function_id.equals("ADMISSION") || function_id.equals("EBL_PACKAGE_SUBS")))
	{
		if(	!(func_mode.equals("STORE_VALUES")) && hash.get( "packageCode" )!=null && !((String)hash.get( "packageCode" )).equals("")){			
		String packageCode		=	(String) hash.get( "packageCode" );	
		String rowCount			=	(String) hash.get( "rec_count" );
		String subsFromDate		=	(String) hash.get( "subsFromDate" );
		String blng_class_code	=	(String) hash.get( "blng_class_code" );
		String blng_grp_code	=	(String) hash.get( "blngGrpCode" ); //Added By Shikha For GHL-CRF-0520.1		
		String payerGrpCode		=	(String) hash.get( "payerGrpCode" );
	//	String payerGrpDesc		=	(String) hash.get( "payerGrpDesc" );//unused variable
		String payerCode		=	(String) hash.get( "payerCode" );
		String pkg_sysdate_dflt = (String) hash.get( "pkg_sysdate_dflt" );
		String siteSpec=(String) hash.get("site_spec");
		int count=0;
		//	String payerDesc		=	(String) hash.get( "payerDesc" );//unused variable
		String strOPYN ="",strEMYN="",strIPYN ="",strDCYN =""; 
		String finalepisodetype="";String sop="";
		//String sdc=""; //unused variable
		rec_count=Integer.parseInt(rowCount);
		/*String bean_id		= "PkgSubsBean" ;
		String bean_name	= "eBL.PkgSubsBean";
		PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id, bean_name, request ) ;
		*/
		if(siteSpec.equals("true")) {
			subsFromDate = com.ehis.util.DateUtils.convertDate(subsFromDate,"DMYHMS","en",locale);
			subsDateFmt = "to_date('"+subsFromDate+"','dd/MM/yyyy HH24:MI:SS')";
		} else {
			subsFromDate = com.ehis.util.DateUtils.convertDate(subsFromDate,"DMY","en",locale);
			subsDateFmt = "to_date('"+subsFromDate+"','dd/MM/yyyy')";
		}
		try
		{
		CallableStatement callstmt = null;
		//Added By Shikha For GHL-CRF-0520.1
		if(siteBLPkgBlngGrp) {		
			if(pkg_sysdate_dflt.equals("Y"))
			{
				if("Y".equals(allowMasterChildPack_map)){
					if("Y".equals(chargeOnAdmVstDateYN)) {
						callstmt = con.prepareCall("{ call blpackage.getpackageprice_linked_pkg(?,?,?,?,?,"+subsDateFmt+",?,?,?,?,?,?,?,?,?,?)}");
					} else {
						callstmt = con.prepareCall("{ call blpackage.getpackageprice_linked_pkg(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?)}");
					}
				} else {
					if("Y".equals(chargeOnAdmVstDateYN)) {
						callstmt = con.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,"+subsDateFmt+",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					} else {
						callstmt = con.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					}
				}
				count=6;
			} else {
			//Ended By Shikha For GHL-CRF-0520.1
				if("Y".equals(allowMasterChildPack_map)){ 
					callstmt = con.prepareCall("{ call blpackage.getpackageprice_linked_pkg(?,?,?,?,?,"+subsDateFmt+",?,?,?,?,?,?,?,?,?,?)}");
				} else {
					callstmt = con.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,to_date(?,'dd/mm/yyyy HH24:MI:SS'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				}
				count=7;
			}
		}else {
			if(pkg_sysdate_dflt.equals("Y"))
			{
				if("Y".equals(allowMasterChildPack_map)){
					if("Y".equals(chargeOnAdmVstDateYN)) {
						callstmt = con.prepareCall("{ call blpackage.getpackageprice_linked_pkg(?,?,?,?,?,"+subsDateFmt+",?,?,?,?,?,?,?,?,?)}");
					} else {
						callstmt = con.prepareCall("{ call blpackage.getpackageprice_linked_pkg(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)}");
					}
				} else {
					if("Y".equals(chargeOnAdmVstDateYN)) {
						callstmt = con.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,"+subsDateFmt+",?,?,?,?,?,?,?,?,?)}");
					} else {
						callstmt = con.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)}");
					}
				}
				count=6;
			} else {
				if("Y".equals(allowMasterChildPack_map)){ 
					callstmt = con.prepareCall("{ call blpackage.getpackageprice_linked_pkg(?,?,?,?,?,"+subsDateFmt+",?,?,?,?,?,?,?,?,?)}");
				} else {
					callstmt = con.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,to_date(?,'dd/mm/yyyy HH24:MI:SS'),?,?,?,?,?,?,?,?,?)}");
				}
				count=7;
			}
		}	
		callstmt.setString(1,facilityId);			
		callstmt.setString(2,packageCode);			
		callstmt.setString(3,blng_class_code);		
		callstmt.setString(4,payerGrpCode);			
		callstmt.setString(5,payerCode);				
		if(count == 7)
		{
			callstmt.setString(6,subsFromDate);				//Corrected against SCF MMS-DM-SCF-0103
		}
		callstmt.registerOutParameter(count,java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(count+1,java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(count+2,java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(count+3,java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(count+4,java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(count+5,java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(count+6,java.sql.Types.VARCHAR);
		callstmt.registerOutParameter(count+7,java.sql.Types.VARCHAR);	
		callstmt.registerOutParameter(count+8,java.sql.Types.VARCHAR);	//Added V171212-Gayathri/MMS-DM-CRF-0118
		//Added By Shikha For GHL-CRF-0520.1
		if (siteBLPkgBlngGrp) {
			if("Y".equals(allowMasterChildPack_map)){					
				callstmt.setString(count+9,blng_grp_code);					
			} else {					
			callstmt.setString(count+9,blng_grp_code);
			callstmt.registerOutParameter(count+10,java.sql.Types.VARCHAR);	
			callstmt.registerOutParameter(count+11,java.sql.Types.VARCHAR);
			callstmt.setString(count+12,null);
			callstmt.setString(count+13,null);
			callstmt.setString(count+14,null);
			}
		}
		//Ended By Shikha For GHL-CRF-0520.1
		callstmt.execute();			
	    pkgPrice = callstmt.getString(count);
		pkgvaliddays=callstmt.getString(count+1);
		pkgpricefactor=callstmt.getString(count+2);
		custdiscountind=callstmt.getString(count+3);
		custdiscountamt=callstmt.getString(count+4);		
		strErrorLevel=callstmt.getString(count+5);
		strMessageId=callstmt.getString(count+6);
		strErrorText=callstmt.getString(count+7);	
		addl_charge = callstmt.getString(count+8); //Added V171212-Gayathri/MMS-DM-CRF-0118
		if (siteBLPkgBlngGrp) {			
			if(!("Y".equals(allowMasterChildPack_map))) {
				blnggrpdiscountind=callstmt.getString(count+10);	
				blnggrpdiscountamt = callstmt.getString(count+11);
			}
		}
		
		if(pkgPrice==null) pkgPrice="0.00";
		if(pkgvaliddays==null) pkgvaliddays="0";
		if(pkgpricefactor==null) pkgpricefactor="1";
		if(custdiscountind==null) custdiscountind="N";
		if(custdiscountamt==null) custdiscountamt="0.00";
		if(addl_charge==null || "E".equals(addl_charge))addl_charge="0.00"; //Added V180803 by Gayathri/66902
		if(blnggrpdiscountind==null) blnggrpdiscountind="N"; 	//Added By Shikha For GHL-CRF-0520.1
		if(blnggrpdiscountamt==null) blnggrpdiscountamt="0.00"; 	//Added By Shikha For GHL-CRF-0520.1
		if(strErrorLevel==null) strErrorLevel="";
		if(strMessageId==null) strMessageId="";
		if(strErrorText==null) strErrorText="";
		addl_charge=cf1.formatCurrency(addl_charge, noofdecimal);
			
		if(calledFrom.equals("Pkgsubsheader"))
		{			
			if(strMessageId!=null && !strMessageId.equals("")){
				out.println("document.forms[0].strMessageId.value='"+strMessageId+"'");
			}else if (strErrorText!=null && !strErrorText.equals("")){
				out.println("document.forms[0].strErrorText.value='"+strErrorText+"'");			
			}else if(strErrorLevel!=null && !strErrorLevel.equals("")){
				out.println("document.forms[0].strErrorText.value='"+strErrorLevel+"'");
			}		
		}
		else{		
			if(strMessageId!=null && !strMessageId.equals("")){
				out.println("document.forms[0].strMessageId.value='"+strMessageId+"'");
			}else if (strErrorText!=null && !strErrorText.equals("")){
				out.println("document.forms[0].strErrorText.value='"+strErrorText+"'");			
			}else if(strErrorLevel!=null && !strErrorLevel.equals("")){
				out.println("document.forms[0].strErrorText.value='"+strErrorLevel+"'");		
			}		
		}
	//	if(rs_pkd!=null) rs_pkd=null;
	//	if(pstmt!=null) pstmt=null;
		
		/* Modified By Vijay For GHL-SCF-1185 */
		//pstmt = con.prepareStatement( " SELECT to_char(to_date(?,'dd/mm/yyyy HH24:MI:SS')+ ? - 1/86400,'dd/mm/yyyy HH24:MI:SS') toDate FROM DUAL");
		String sql="SELECT to_char(to_date(?,";
		StringBuilder sbToDate=new StringBuilder();
		
		sbToDate.append(sql);
		if(siteSpec.equals("true"))
		{
			sbToDate.append(" 'dd/mm/yyyy HH24:MI:SS')+ ? - 1/86400,'dd/mm/yyyy HH24:MI:SS') ");
		}
		else
		{
			sbToDate.append(" 'dd/mm/yyyy')+ ? - 1/86400,'dd/mm/yyyy')");
		}
			sbToDate.append(" toDate FROM DUAL");
	
		/* Ends */
		pstmt = con.prepareStatement(sbToDate.toString());
		pstmt.setString(1,subsFromDate);
		pstmt.setInt(2,Integer.parseInt(pkgvaliddays));
		rs_pkd = pstmt.executeQuery();	
		while(rs_pkd!=null && rs_pkd.next())
		{
			effToDate  =  rs_pkd.getString("toDate");
		}
		if(effToDate==null) effToDate="";		
	}
	catch(Exception e)
	{
		System.out.println("Exception @ HEADER package  :"+e);
		e.printStackTrace();
	}

	try{
			//if(rs_pkd!=null) rs_pkd=null;
			if(pstmt!=null) pstmt=null; 
			pstmt = con.prepareStatement( " select OP_YN,EM_YN,IP_YN,DC_YN from  bl_package where PACKAGE_CODE='"+packageCode+"' and operating_facility_id='"+facilityId+"'"); //V220321
			rs_pkd = pstmt.executeQuery();	
			while(rs_pkd.next())
			{
				strOPYN  =  rs_pkd.getString(1);
				strEMYN  =  rs_pkd.getString(2);
				strIPYN  =  rs_pkd.getString(3);
				strDCYN  =  rs_pkd.getString(4);
			}

			if(strOPYN==null) strOPYN="";
			if(strEMYN==null) strEMYN="";
			if(strIPYN==null) strIPYN="";
			if(strDCYN==null) strDCYN="";
			
			if(strOPYN.equals("Y")){				
					sop="OP";	}
			if(strEMYN.equals("Y")){					
						sop=sop+"/EM";						
				}
			if(strIPYN.equals("Y"))
			{				
						sop=sop+"/IP";			
				//sip="IP";
			}
			if(strDCYN.equals("Y"))
			{				
						sop=sop+"/DC";//	sdc="DC";
			}

			//finalepisodetype= sop+"/"+sem+"/"+sip+"/"+sdc;
			finalepisodetype=sop;
		}catch(Exception e)
		{
				System.out.println("Exception no. of decimal :"+e);
				e.printStackTrace();
		}
	//			out.println("<script>eval('parent.PkgSubscriptionDtls.document.forms[0].pkgAmt_"+rec_count+"').value="+pkgPrice+"</script>") 	
			if(calledFrom.equals("PkgAssocnExisting") || calledFrom.equals("Pkgsubsheader") )
			{
				out.println("dateDisplay('"+rec_count+"','"+effToDate+"','"+calledFrom+"')");
			}
			else
			{
				if("Y".equals(SiteSpecific_VAT)){
					out.println("callPkgPrice_VAT('"+pkgPrice+"','"+rec_count+"','"+finalepisodetype+"','"+strOPYN+"','"+strEMYN+"','"+strIPYN+"','"+strDCYN+"','"+function_id+"','"+effToDate+"','"+addl_charge+"');");
				}
				else{
					out.println("callPkgPrice('"+pkgPrice+"','"+rec_count+"','"+finalepisodetype+"','"+strOPYN+"','"+strEMYN+"','"+strIPYN+"','"+strDCYN+"','"+function_id+"','"+effToDate+"','"+allowMasterChildPack_map+"');");	
				}				
			}
		}
}//	else
else if(func_mode.equals("GET_PKG_DEPOSIT_DTLS")  && function_id.equals("PKG_BILLING"))
	{ 
		String str_deposit_man_yn = "",	str_partial_dep_yn	= "",	str_min_dep_amt	= "",str_err_level= "",	str_sys_message_id= "",	str_error_text= "";	

		int packseqno		    = Integer.parseInt((String) hash.get( "packseqno" ));
		String pkgCode	= (String) hash.get( "pkgCode" );
		String pkgAmount	= (String) hash.get( "pkgAmount" );		
		CallableStatement call1 = 
				con.prepareCall(
				"{ call  blpackage.get_pkg_deposit_dtls (?,?,?,?,?,?,?,?,?,?)}");			
				call1.setString(1,facilityId);				
				call1.setInt(2,packseqno);				
				call1.setString(3,pkgCode);				
				call1.setString(4,pkgAmount);											
				call1.registerOutParameter(5,java.sql.Types.VARCHAR); // p_deposit_man_yn   			
				call1.registerOutParameter(6,java.sql.Types.VARCHAR); // p_partial_dep_yn   	
				call1.registerOutParameter(7,java.sql.Types.VARCHAR); // p_min_dep_amt      
				call1.registerOutParameter(8,java.sql.Types.VARCHAR); //p_err_level 
				call1.registerOutParameter(9,java.sql.Types.VARCHAR); // p_sys_message_id
				call1.registerOutParameter(10,java.sql.Types.VARCHAR); // p_error_text
				
				call1.execute();				

				str_deposit_man_yn	 = call1.getString(5);
				str_partial_dep_yn	 = call1.getString(6);
				str_min_dep_amt		 = call1.getString(7);		
				str_err_level		 = call1.getString(8);		
				str_sys_message_id	 = call1.getString(9);		
				str_error_text		 = call1.getString(10);		
				call1.close();	
				if ( str_deposit_man_yn == null ) str_deposit_man_yn = "";
				if ( str_partial_dep_yn == null ) str_partial_dep_yn = "";
				if ( str_min_dep_amt == null ) str_min_dep_amt = "";
				if ( str_err_level == null ) str_err_level = "";
				if ( str_sys_message_id == null ) str_sys_message_id = "";
				if ( str_error_text == null ) str_error_text = "";		
				out.println(str_deposit_man_yn);
	}else if(func_mode.equals("REM_PKG_SUBS")  && function_id.equals("PKG_BILLING"))
	{
		//String packseqno = request.getParameter("packseqno") == null ? "" :request.getParameter("packseqno") ;
		//String pkgCode = request.getParameter("pkgCode") == null ? "" :request.getParameter("pkgCode") ;
		String pkg_seq_token="";StringTokenizer st_seqno; 	
		String errorText = "";
		try{		
			String called_from_mode = (String) hash.get( "called_from_mode" );		 
			if(called_from_mode==null) called_from_mode="";
			String strpackseqno	= (String) hash.get( "packseqno" );		
			st_seqno=new StringTokenizer(strpackseqno,"^");
			if(!called_from_mode.equals("") && called_from_mode.equals("VISIT_REGISTRATION"))
			{
				String bean_id		= "PkgSubsBean" ;
				String bean_name	= "eBL.PkgSubsBean";
				PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id, bean_name, request ) ;
				HashMap  patPackSubsDtls=bean.getPatientPackSubsDtls();
				patPackSubsDtls.clear();
				bean.setPatientPackSubsDtls(patPackSubsDtls);
				putObjectInBean(bean_id,bean,request);
				String bean_id1		= "PkgEnterReceptRefundBean" ;
				String bean_name1	= "eBL.PkgEnterReceptRefundBean";
				PkgEnterReceptRefundBean bean1			= (PkgEnterReceptRefundBean)getBeanObject( bean_id1, bean_name1, request ) ;
				bean1.clearBean();
				putObjectInBean(bean_id1,bean1,request);

			}else{
				while(st_seqno.hasMoreTokens())
				{
					pkg_seq_token = st_seqno.nextToken();
					//int packseqno		    = Integer.parseInt(pkg_seq_token);
									
					//Modified the Procedure Call MMS-DM-SCF-0013
					CallableStatement callstmt1 = con.prepareCall("{ call blpackage.remove_pkg_subs (?,?,?)}");
					callstmt1.setString(1,facilityId);			
					callstmt1.setString(2,pkg_seq_token);	
					callstmt1.registerOutParameter(3, java.sql.Types.VARCHAR);
					callstmt1.execute();	
					errorText = callstmt1.getString(3);
					if(errorText == null)	errorText = "";
					
					if(!"".equals(errorText)){
						strErrorText += errorText; 
					}					
				}
				
				if("".equals(strErrorText)){
					con.commit();
				}
				else{
					con.rollback();
				}
				out.println(strErrorText);
				//Modified the Procedure Call MMS-DM-SCF-0013
			}
		}catch (Exception ee) {
			System.out.println("Exception from REM_PKG_SUBS :"+ee);
			ee.printStackTrace();
		}

	}else if(func_mode.equals("CHK_PAT_ID")  && function_id.equals("PAT_CHK"))	
	{
		String patient_id	= (String) hash.get( "patient_id" );
		String str_x="";
		pstmt = con.prepareStatement( "SELECT 'X' FROM mp_patient WHERE patient_id='"+patient_id+"'");			
		rs_pat = pstmt.executeQuery();	
		while(rs_pat!=null && rs_pat.next())
		{
			str_x  =  rs_pat.getString(1);
		}
		if(str_x==null) str_x="";
		if(str_x.equals("")){
		out.println("N");
		}else{
			out.println("Y");
		}
	}
	//if(func_mode.equals("STORE_VALUES") && function_id.equals("VISIT_REGISTRATION"))
	if(func_mode.equals("STORE_VALUES"))	
	{
		try{
			String	patientId		=	(String) hash.get( "patientId" );
			String charge_logic_yn = (String) hash.get( "charge_logic_yn" );
			String bean_id		= "PkgSubsBean" ;
			String bean_name	= "eBL.PkgSubsBean";
			PkgSubsBean bean	= (PkgSubsBean)getBeanObject( bean_id, bean_name, request ) ;
			
			String	total_records		=	(String) hash.get( "total_records" );		
			int totalRec				=	Integer.parseInt(total_records);

			ArrayList	pack_code	    =	new ArrayList();
			ArrayList	Mul_pack_code	    =	new ArrayList();//added for NMC-JD-CRF-0084 on 260121
			ArrayList	frm_date	    =	new ArrayList();
			ArrayList	to_date	    =	new ArrayList();
			ArrayList	pack_amt	    =	new ArrayList();	
			ArrayList	addlCharge	    =	new ArrayList(); //Added V171212-Gayathri/MMS-DM-CRF-0118
			ArrayList	blng_class_code_list	    =	new ArrayList();
			ArrayList	blng_class_desc_list	    =	new ArrayList();
			ArrayList	blng_grp_code_list	    =	new ArrayList();//Added By Shikha For GHL-CRF-0520.1
			ArrayList	blng_grp_desc_list	    =	new ArrayList();//Added By Shikha For GHL-CRF-0520.1
			ArrayList	payerGrpCode_list	    =	new ArrayList();
			ArrayList	payerGrpDesc_list	    =	new ArrayList();
			ArrayList	payerCode_list	    =	new ArrayList();
			ArrayList	payerDesc_list	    =	new ArrayList();
			ArrayList	pack_desc	    =	new ArrayList();
			ArrayList	episode_type_list	    =	new ArrayList();//added for IN021023
			ArrayList	package_details	    =	new ArrayList();	
			ArrayList	subscribedPkgs	    =	new ArrayList();
			ArrayList	practitioner_id_list	    =	new ArrayList(); //added for IN033044
			ArrayList	practitioner_name_list	    =	new ArrayList(); //added for IN033044

			HashMap packageDetails    =   new HashMap();		

			for(int i=0;i<totalRec; i++)
				{															
				if(hash.get( "packageCode_"+i )!=null && !(((String)hash.get( "packageCode_"+i )).equals(""))){
				   //Duplicate Pkg Rajesh v
				   if("Y".equals(charge_logic_yn)){
					   pack_code.add((String) hash.get( "packageCode_"+i )+"@:"+i);
				   }
				   else{
					   pack_code.add((String) hash.get( "packageCode_"+i ));
				   }
				     Mul_pack_code.add((String) hash.get( "packageCode_"+i)); //added for NMC-JD-CRF-0084 on 260121
			pack_desc.add((String) hash.get( "packageDesc_"+i ));
			frm_date.add((String) hash.get( "fromDate_"+i ));
			to_date.add((String) hash.get( "toDate_"+i ));
			pack_amt.add((String) hash.get( "pkgAmt_"+i ));

			blng_class_code_list.add((String) hash.get( "blng_class_code"+i ));			   
			blng_class_desc_list.add((String) hash.get( "blng_class_desc"+i ));			 
			payerGrpCode_list.add((String) hash.get( "payerGrpCode_"+i ));				   
			payerGrpDesc_list.add((String) hash.get( "payerGrpDesc_"+i ));				   
			payerCode_list.add((String) hash.get( "payerCode_"+i ));				   
			payerDesc_list.add((String) hash.get( "payerDesc_"+i ));	
			episode_type_list.add((String) hash.get( "episodeType_"+i ));	//added for IN021023				
			practitioner_id_list.add((String) hash.get( "practitioner_id"+i ));//added for IN033044
			practitioner_name_list.add((String) hash.get( "practitioner_name"+i ));
			addlCharge.add((String) hash.get( "addl_charge_"+i ));//Added V171212-Gayathri/MMS-DM-CRF-0118
			//Added By Shikha For GHL-CRF-0520.1
			blng_grp_code_list.add((String) hash.get( "blngGrpCode_"+i ));	
			blng_grp_desc_list.add((String) hash.get( "blngGrpDesc_"+i ));	
			//Added By Shikha For GHL-CRF-0520.1

				//Duplicate Pkg - Rajesh V
					if("Y".equals(charge_logic_yn)){
						subscribedPkgs.add((String) hash.get( "packageCode_"+i )+"@:"+i+"~~"+(String) hash.get( "packageDesc_"+i )+"~~"+" "+"~~"+" "+"~~"+(String)hash.get("pkgAmt_"+i)+"~~");
						// Modified By Vijay For MMS-ICN-00025
					}
					else{
						subscribedPkgs.add((String) hash.get( "packageCode_"+i )+"~~"+(String) hash.get( "packageDesc_"+i )+"~~"+" "+"~~"+(String) hash.get("pkgAmt_"+i)+"~~");
						// Modified By Vijay For MMS-ICN-00025
					}
										  				
				}else{
					  					//System.out.println("cond subs vali 4"+totalRec);
					  if(totalRec==1)
					  {
						  					//System.out.println("cond subs vali 5");
						  package_details.clear();
						  subscribedPkgs.clear();
						  bean.setPatientPackSubsDtls(packageDetails);
		 				 bean.setSubscribedPkgs(subscribedPkgs);
					  }
				  }
				  
				}
				if(pack_code !=null && pack_code.size()>0){
					 package_details.add( pack_code );
					 package_details.add( pack_desc );
					 package_details.add( frm_date );
					 package_details.add( to_date );
					 package_details.add( pack_amt );
					 //package_details.add( encounter_id );   
					package_details.add( blng_class_code_list );
					package_details.add( blng_class_desc_list );					
					package_details.add( payerGrpCode_list );
					package_details.add( payerGrpDesc_list );
					package_details.add( payerCode_list );
					package_details.add( payerDesc_list );
					package_details.add( episode_type_list );//added for IN021023
					package_details.add(practitioner_id_list);//added for IN033044
					package_details.add(practitioner_name_list);
					package_details.add(addlCharge);//Added V171212-Gayathri/MMS-DM-CRF-0118
					//Added By Shikha For GHL-CRF-0520.1
					package_details.add( blng_grp_code_list );				
					package_details.add( blng_grp_desc_list );
					//Added By Shikha For GHL-CRF-0520.1

					packageDetails.put(patientId,package_details);
					System.err.println("package_details 689:"+package_details);
					System.err.println("packageDetails 690:"+packageDetails);
					bean.setPatientPackSubsDtls(packageDetails);
					bean.setSubscribedPkgs(subscribedPkgs);
				}
		putObjectInBean(bean_id,bean,request);
		if(function_id!= null && (function_id.equals("VISIT_REGISTRATION") )){
			if("Y".equals(siteBlrecordButYN)){ //added for NMC-JD-CRF-0084 on 260121
				out.println("sitecallPkgDeposit('"+patientId+"','"+function_id+"','"+Mul_pack_code+"')");	 
			}
			else
				out.println("callPkgDeposit('"+patientId+"','"+function_id+"')");
			}			
		  }catch (Exception e) {
			e.printStackTrace() ;
			System.out.println("Exception from bean calling :"+e);
		}
	}
	// CRF - Health card Subscription - Rajesh V
	else if(func_mode.equals("get_patient_hdr")){
		String patId = request.getParameter("patient_id");
		/*String sqlGetPatLine = BlRepository.getBlKeyValue("BL_HEALTHCARDSUBS_PATHDR");
		CallableStatement call = con.prepareCall(sqlGetPatLine);	
		call.registerOutParameter(1,java.sql.Types.VARCHAR);
		call.setString(2,patId);
		call.setString(3,locale);
		call.execute();							
		String patln = call.getString(1);*/
		String patln = "";
		String sqlGetPatLine =  "SELECT patient_name, "+
								" TRUNC (MONTHS_BETWEEN (sysdate, date_of_birth) / 12) "+
								" || ' Y ' "+
								" || TRUNC (MOD (MONTHS_BETWEEN (sysdate, date_of_birth), 12)) "+
								" || ' M ' "+
								" || TRUNC ( sysdate - ADD_MONTHS (date_of_birth, TRUNC ( MONTHS_BETWEEN (sysdate, date_of_birth ) / 12 ) * 12 + TRUNC (MOD (MONTHS_BETWEEN (sysdate, date_of_birth ), 12 ) ) ) ) "+
								" || ' D ' AS dob "+
								" FROM mp_patient "+
								"WHERE patient_id = ?";
		pstmt = con.prepareCall(sqlGetPatLine);
		pstmt.setString(1,patId);
		rs_pat =  pstmt.executeQuery();
		if(rs_pat != null){
			while(rs_pat.next()){
				patln = rs_pat.getString("patient_name")+"###"+rs_pat.getString("dob");
			}
		}
		//Added for getting Price class for Additional Patient
		String cardCode = request.getParameter("cardCode");
		CallableStatement call = null;
		call = con.prepareCall("{ ? = call  IBAEHIS.blhealthcard.get_price_class_code(?,?,?)}");
		call.registerOutParameter(1,java.sql.Types.VARCHAR);
		call.setString(2,facilityId);
		call.setString(3,cardCode);
		call.setString(4,patId);
		call.execute();
		String priceClass = call.getString(1);
		//Ends here
		out.println(patln+"::::"+priceClass);
		call.close();
		pstmt.close();
		rs_pat.close();
	}
	
	else if(func_mode.equals("get_Card_Details")){
		String cardId = request.getParameter("card_id");
		String patId = request.getParameter("patient_id");
		String priceClass = "";
		String priceDesc = "";
		String effFrom = "";
		String effTo = "";
		int validDays = 0;
		String sqlGetDob = BlRepository.getBlKeyValue("BL_HEALTHCARDSUBS_GETDOB");
		//CallableStatement call = con.prepareCall("{ ? = call  IBAEHIS.blhealthcard.get_dob(?,sysdate)}");	
		CallableStatement call = con.prepareCall(sqlGetDob);
		call.registerOutParameter(1,java.sql.Types.VARCHAR);
		call.setString(2,patId);
		call.execute();							
		String age = call.getString(1);
		String ageArr[] = age.split(" ");
		int years=Integer.parseInt(ageArr[0]);
		int months=Integer.parseInt(ageArr[2]);
		int days=Integer.parseInt(ageArr[4]);

		/*String sql = 	"select bhd.price_class_code,bps.long_desc,bhh.valid_days,to_char(bhh.effective_from,'dd/mm/yyyy') "+ 
						" eff_from,to_char(bhh.effective_to,'dd/mm/yyyy') eff_to"+
					    " from bl_hcard_dtl bhd, bl_price_class bps,bl_hcard_hdr bhh "+
						" where bhd.operating_facility_id = ? and bhd.card_type_code = ?  and bhd.card_type_code = bhh.card_type_code and bhd.price_class_code = bps.price_class_code "+
						" and  lpad(to_char(?),3,'0')||lpad(to_char(?),2,'0')||lpad(to_char(?),3,'0') between "+
						" lpad(to_char(from_age_yrs),3,'0')||lpad(to_char(from_age_month),2,'0')||lpad(to_char(from_age_days),3,'0') "+
						" and lpad(to_char(to_age_yrs),3,'0')||lpad(to_char(to_age_month),2,'0')||lpad(to_char(to_age_days),3,'0')";	*/
		String sql = 	BlRepository.getBlKeyValue("BL_HEALTHCARDSUBS_CARDDTL");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, facilityId);
		pstmt.setString(2, cardId);
		pstmt.setInt(3, years);
		pstmt.setInt(4, months);
		pstmt.setInt(5, days);
		/*pstmt.setInt(6, years);
		pstmt.setInt(7, months);
		pstmt.setInt(8, years);*/
		rs_pat = pstmt.executeQuery();
		while(rs_pat != null && rs_pat.next()){
			priceClass = rs_pat.getString("price_class_code");
			priceDesc = rs_pat.getString("long_desc");
			validDays = rs_pat.getInt("valid_days");
			effFrom = rs_pat.getString("eff_from");
			effTo = rs_pat.getString("eff_to");
		}
		out.println( priceClass+":::"+priceDesc+":::"+validDays+":::"+effFrom+":::"+effTo);
		pstmt.close();
		rs_pat.close();
		call.close();
		/*call = con.prepareCall("{ ? = call  IBAEHIS.blhealthcard.get_dob(?,?,?,?,sysdate)}");	
		call.registerOutParameter(1,java.sql.Types.VARCHAR);
		call.setString(2,patId);
		call.execute();							
		String age = call.getString(1);*/
	}
	
	else if(func_mode.equals("get_To_Date")){
		String fromdate = request.getParameter("fromDate");
		
		int validDays = Integer.parseInt(request.getParameter("valid_days"));
		String patId = request.getParameter("patientId");
		String cardType = request.getParameter("card_type");
		//String sql = "select to_char(to_date(?,'dd/mm/yyyy')+?,'dd/mm/yyyy') todat from dual";
		String sql = BlRepository.getBlKeyValue("BL_HEALTHCARDSUBS_TODATE");
		String todate = "";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, fromdate);
		pstmt.setInt(2, validDays);
		rs_pat = pstmt.executeQuery();
		while(rs_pat != null && rs_pat.next()){
			todate = rs_pat.getString("todat");
		}

		rs_pat.close();
		pstmt.close();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fromDt = new Date(sdf.parse(fromdate).getTime());
		//String sqlGetServPrice = "{ ? = call  IBAEHIS.blhealthcard.get_serv_price(?,?,?,?,?)}";
		String sqlGetServPrice = BlRepository.getBlKeyValue("BL_HEALTHCARDSUBS_SERVPRICE");
		CallableStatement call = con.prepareCall(sqlGetServPrice);	

		call.registerOutParameter(1,java.sql.Types.VARCHAR);
		call.setString(2,facilityId);
		call.setString(3,patId);
		call.setString(4,cardType);
		call.setString(5,null);
		call.setDate(6,fromDt);	
		call.execute();
						
		String patln = call.getString(1);
		
		out.println(todate+":::"+patln);
		call.close();
	}
	// CRF - Health card Subscription - Rajesh V
	// Add Modify pat Fin Details - Rajesh V
	else if(func_mode.equals("getActiveHealthCardVis")){

		String facility_id = request.getParameter("facility_id");
		String patient_id = request.getParameter("patient_id");
		String billGroup = request.getParameter("billGroup");
		CallableStatement call = con.prepareCall("{call  blhealthcard.get_hcard_enable_yn(?,?,SYSDATE,?,?,?,?,null,null)}");	

		call.setString(1,facility_id);
		call.setString(2,patient_id);
		call.registerOutParameter(3,java.sql.Types.VARCHAR);
		call.setInt(4,0);
		call.setInt(5,0);
		call.setString(6,billGroup);
		call.execute();	
		String hCardYn = call.getString(3);
		out.println(hCardYn);
		call.close();
	}
	// Add Modify pat Fin Details - Rajesh V
	// Added for MMS-DM-SCF-0083 - Rajesh V
	else if(func_mode.equals("getProgressStatus")){
		String status = "N";
		int reqId = Integer.parseInt(request.getParameter("reqId"));
		pstmt = con.prepareStatement("select  status from BL_BACKGROUND_PROCESS where req_id = ? ");
		pstmt.setInt(1, reqId);
		rs_pat = pstmt.executeQuery();
		if(rs_pat != null && rs_pat.next()){
			status = rs_pat.getString("status");
		}
					
		out.println(status);
	}
	else if(func_mode.equals("getProgressCount")){

		String status = "N";
		int processed = 0;
		int total = 0;
		int reqId = Integer.parseInt(request.getParameter("reqId"));
		pstmt = con.prepareStatement("select  status,rec_processed,total_rec from BL_BACKGROUND_PROCESS where req_id = ? ");
		pstmt.setInt(1, reqId);
		rs_pat = pstmt.executeQuery();
		if(rs_pat != null && rs_pat.next()){
			status = rs_pat.getString("status");
			processed = rs_pat.getInt("rec_processed");
			total = rs_pat.getInt("total_rec");
		}
		out.println(status+"::"+processed+"::"+total);
	}
	else if(func_mode.equals("getPatData")){
		String patId = "";
		String episodeType = "";
		String episodeId = "";
		String visitId = "";
		String patName = "";
		int reqId = Integer.parseInt(request.getParameter("reqId"));
		pstmt = con.prepareStatement("select  patient_id,episode_type,episode_id,visit_id from BL_BACKGROUND_PROCESS where req_id = ? ");
		pstmt.setInt(1, reqId);
		rs_pat = pstmt.executeQuery();
		if(rs_pat != null && rs_pat.next()){
			patId = rs_pat.getString("patient_id");
			episodeType = rs_pat.getString("episode_type");
			episodeId = rs_pat.getString("episode_id");
			visitId = rs_pat.getString("visit_id");
		}
		
		if(!"".equals(patId)){
			pstmt = con.prepareStatement("select  patient_name from mp_patient where patient_id = ? ");
			pstmt.setString(1, patId);
			rs_pat = pstmt.executeQuery();
			if(rs_pat != null && rs_pat.next()){
				patName = rs_pat.getString("patient_name");
			}
		}
		out.println(patId+"::"+episodeType+"::"+episodeId+"::"+visitId+"::"+patName);
			
	}
	else if(func_mode.equals("reRunReCalcJob")){
		System.err.println("Re Run Re Calc Job");
		int reqId = Integer.parseInt(request.getParameter("reqId"));
		int newReqId = 0;
		String str_error_level="",str_sysmesage_id="",str_error_text="";
		String inProgReqId = "";
		//Call to new Procedure
		try{
			pstmt = con.prepareStatement("Select operating_facility_id,patient_id,episode_type,episode_id,visit_id, "+
					                     "added_at_ws_no,user_id,function_id from bl_background_process where req_id = ?");
			pstmt.setInt(1, reqId);
			rs_pat = pstmt.executeQuery();
			if(rs_pat != null && rs_pat.next()){
				
				PreparedStatement pstmt1 = con.prepareCall("Select BL_GET_PKG_BGRD_JOBS(?,?,?,?,?) req_id from dual ");
				pstmt1.setString(1, rs_pat.getString("operating_facility_id"));
				pstmt1.setString(2, rs_pat.getString("episode_type"));
				pstmt1.setString(3, rs_pat.getString("patient_id"));
				pstmt1.setString(4, rs_pat.getString("episode_id"));
				pstmt1.setString(5, rs_pat.getString("visit_id"));
				ResultSet rst1 = pstmt1.executeQuery();
				if(rst1 != null && rst1.next()){
					inProgReqId = rst1.getString("req_id");
				}
				if(inProgReqId == null || "null".equals(inProgReqId) || "".equals(inProgReqId)){
					inProgReqId = "0";
				}
				
				if("0".equals(inProgReqId)){
					String recalc = "{ call   bl_recalc_process.proc_recalc (?,?,?,?,?,?,?,?,?,?,?,?) }";
					CallableStatement cstmt =con.prepareCall(recalc);
			
					cstmt.setString(1, rs_pat.getString("operating_facility_id"));
					cstmt.setString(2, rs_pat.getString("patient_id"));
					cstmt.setString(3, rs_pat.getString("episode_type"));
					cstmt.setString(4, rs_pat.getString("episode_id"));
					cstmt.setString(5, rs_pat.getString("visit_id"));
					cstmt.setString(6, rs_pat.getString("added_at_ws_no"));
					cstmt.setString(7, rs_pat.getString("user_id"));
					cstmt.setString(8, rs_pat.getString("function_id"));
					cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
					cstmt.setInt(12, reqId);
					
					
					cstmt.execute();
					str_error_level = cstmt.getString(10);
					str_sysmesage_id = cstmt.getString(9);
					str_error_text = cstmt.getString(11);	
			
					System.err.println("str_error_level-"+str_error_level+"str_sysmesage_id-"+str_sysmesage_id+"str_error_text-"+str_error_text);
					if(str_error_level!=null || str_error_text!=null){
						newReqId = 0;
						con.rollback();
					}
					else{
						newReqId = reqId;
						con.commit();
					}
				}
				else{
					newReqId = Integer.parseInt(inProgReqId);
				}				
			}
		}
		catch(Exception e){
			con.rollback();
			System.err.println("Exception in Re-Running the Job -> "+e);
			newReqId = 0;
		}		
		//Call to new Procedure
		out.println(newReqId);		
	}
	else if(func_mode.equals("checkForInProgress")){
		String facId = request.getParameter("facilityId");
		String patientId = request.getParameter("patientId");
		String episdoeType = request.getParameter("episdoeType");
		String episdoeId = request.getParameter("episdoeId");
		String visitId = request.getParameter("visitId");
		if(visitId == null || "null".equals(visitId)){
			visitId = "";
		}
		String reqId = "0";
		
		pstmt = con.prepareCall("Select BL_GET_PKG_BGRD_JOBS(?,?,?,?,?) req_id from dual ");
		pstmt.setString(1, facId);
		pstmt.setString(2, episdoeType);
		pstmt.setString(3, patientId);
		pstmt.setString(4, episdoeId);
		pstmt.setString(5, visitId);
		rs_pat = pstmt.executeQuery();
		if(rs_pat != null && rs_pat.next()){
			reqId = rs_pat.getString("req_id");
		}
		System.err.println("reqId->"+reqId);
		if(reqId == null || "null".equals(reqId) || "".equals(reqId)){
			reqId = "0";
		}
		out.println(reqId);
		
	}
	else if(func_mode.equals("checkForMultEnc")){
		String reqId = "0";
		String patientId = request.getParameter("patientId");		
		String episdoeType = "";
		String episdoeId = "";
		String visitId = "";
		String encounterId = "";
		boolean executeYn = true;
		HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters = (HashMap<String,ArrayList<String>>) session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
		ArrayList<String> encounterCombinationArray=new ArrayList<String>();
		if(packageSubscriptionAssociationEncounters != null){
			encounterCombinationArray=packageSubscriptionAssociationEncounters.get(patientId);	
			for(int encCount=0;encCount<encounterCombinationArray.size();encCount++){					
				
				if(executeYn){					
					StringTokenizer stEncList=new StringTokenizer(encounterCombinationArray.get(encCount),"|");					
					episdoeType=stEncList.hasMoreTokens()?stEncList.nextToken():"";
					encounterId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
					episdoeId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
					visitId=stEncList.hasMoreTokens()?stEncList.nextToken():"";
					
					pstmt = con.prepareCall("Select BL_GET_PKG_BGRD_JOBS(?,?,?,?,?) req_id from dual ");
					pstmt.setString(1, facilityId);
					pstmt.setString(2, episdoeType);
					pstmt.setString(3, patientId);
					pstmt.setString(4, episdoeId);
					pstmt.setString(5, visitId);
					rs_pat = pstmt.executeQuery();
					if(rs_pat != null && rs_pat.next()){
						reqId = rs_pat.getString("req_id");
					}
					if(reqId == null || "null".equals(reqId) || "".equals(reqId)){
						reqId = "0";
					}
					
					if(!"0".equals(reqId)){
						executeYn = false;
					}
				}
			}
		}
		out.println(reqId);
	}
	// Added for MMS-DM-SCF-0083 - Rajesh V
	//Added Newly Sarath for pkg closure checking
	else if(func_mode.equals("ChkForPkgClosure")){
		String reqId = "";
		String pkgcodeclosure=request.getParameter("pkgcodeclosure");
		String cust_grp_code=request.getParameter("payerGrpCodeclosure");
		String cust_code=request.getParameter("payerCodeclosure");
		String blng_grp_code=request.getParameter("blngGrpCodeclosure"); 	//Added By Shikha For GHL-CRF-0520.1

		try{
			pstmt = con.prepareStatement("Select blpackage.check_package_closure(?,?,?,?) req_id from dual ");
			pstmt.setString(1,pkgcodeclosure);
			pstmt.setString(2,cust_grp_code);
			pstmt.setString(3,cust_code); 
			pstmt.setString(4,blng_grp_code);
			rs_pat = pstmt.executeQuery();
			if(rs_pat !=null && rs_pat.next()){
				reqId = rs_pat.getString("req_id");
				}
			JSONObject obj=new JSONObject();
			obj.put("reqId",reqId);
			out.print(obj);
			out.flush();
		}
		catch(Exception e){
			System.err.println("Exception form ChkForPkgClosure : "+ e);
			e.printStackTrace();
		}
	} 
	//Added Newly Sarath for pkg closure checking ends*/
//	}
}catch (Exception e) {
	e.printStackTrace();
	System.out.println("Exception from PkgDefValidation :"+e);
}
finally
	{	
		//if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>

