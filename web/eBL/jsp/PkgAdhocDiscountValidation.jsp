

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
String bean_id			  = "bl_PkgAdhocDiscountBean" ;
String bean_name		  = "eBL.PkgAdhocDiscountBean";
PkgAdhocDiscountBean bean = (PkgAdhocDiscountBean)getBeanObject( bean_id, bean_name, request ) ;
Connection con = ConnectionManager.getConnection();	
PreparedStatement pstmt = null;
ResultSet rs = null;

try
{
	request.setCharacterEncoding("UTF-8");
	String func_mode			= request.getParameter("func_mode");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String	patientId		= (String) hash.get( "patientId" );	
	String	packageSeqNo	= (String) hash.get( "packageSeqNo" );	
	String	totalRec		= (String) hash.get( "totalRec" );	
	String  adhocDiscount 	= "";
	String encounterId		= "";
	String encounterId_chk	= "";

	ArrayList enconterDtls		= new ArrayList();
	ArrayList dtls				= new ArrayList();
	ArrayList dtlsNew			= null;
	/* Added V180523-Aravindh/MMS-DM-SCF-0346/ */
	String facilityId = (String) session.getValue("facility_id");

	if(func_mode!=null && func_mode.equals("CHK_PAT_ID") )	
	{
		String str_x="";
		pstmt = con.prepareStatement( "SELECT 'X' FROM mp_patient WHERE patient_id='"+patientId+"'");			
		rs = pstmt.executeQuery();	
		while(rs!=null && rs.next())
		{
			str_x  =  rs.getString(1);
		}
		if(str_x==null) str_x="";
		if(str_x.equals("")){
		out.println("N");
		}else{
			out.println("Y");
		}
	}
	else if(func_mode.equals("SAVE_VALUES"))
	{
		int totalRecords		= Integer.parseInt(totalRec);
		ArrayList packageSeqNoList	= bean.getPackageSeqNoList();
		HashMap adhocDiscountDtls	= bean.getAdhocDiscountDtls();

		if(adhocDiscountDtls!=null && adhocDiscountDtls.containsKey(packageSeqNo))
		{
			enconterDtls = 	(ArrayList)adhocDiscountDtls.get(packageSeqNo);
		}
		for(int i=0;i<totalRecords;i++)
		{
			adhocDiscount = (String) hash.get( "adhocDiscount_"+i );
			encounterId = (String) hash.get( "encounterId_"+i );
			dtls = 	(ArrayList)enconterDtls.get(i);
			encounterId_chk =(String)dtls.get(0);
//			if(adhocDiscount!=null && !adhocDiscount.equals(""))
//			{
				if(!(packageSeqNoList.contains(packageSeqNo)))
					packageSeqNoList.add(packageSeqNo);
					//enconterDtls.remove(i);
				
					dtlsNew	= new ArrayList();
					/*dtlsNew.add(encounterId);
					dtlsNew.add((String) hash.get( "blngGrpId_"+i ));
					dtlsNew.add((String) hash.get( "custGrpCode_"+i ));
					dtlsNew.add((String) hash.get( "custGrpDesc_"+i ));
					dtlsNew.add((String) hash.get( "custCode_"+i ));
					dtlsNew.add((String) hash.get( "custDesc_"+i ));
					dtlsNew.add((String) hash.get( "priority_"+i ));
					dtlsNew.add((String) hash.get( "policyTypeCode_"+i ));
					dtlsNew.add((String) hash.get( "policyNo_"+i ));
					dtlsNew.add((String) hash.get( "approvedAmt_"+i ));
					dtlsNew.add((String) hash.get( "discountAsPerSetup_"+i ));
					dtlsNew.add((String) hash.get( "episodeType_"+i )); 
					dtlsNew.add((String) hash.get( "visitId_"+i ));
					dtlsNew.add((String) hash.get( "appmtBkRefNo_"+i )); 
					dtlsNew.add((String) hash.get( "acctSeqno_"+i ));
					dtlsNew.add((String) hash.get( "episodeId_"+i ));  			 
					dtlsNew.add(adhocDiscount);
					dtlsNew.add((String) hash.get( "type_"+i ));*/
				
					dtlsNew.add((String) hash.get( "cust_group_code"+i ));
					dtlsNew.add((String) hash.get( "cust_group_desc"+i ));
				///	if(((String)hash.get( "cust_desc"+i )).equals("") ){
					//	dtlsNew.add("");
				//	}else{
					dtlsNew.add((String)hash.get( "cust_code"+i ));
				//}				
					dtlsNew.add((String) hash.get( "cust_desc"+i ));
					dtlsNew.add((String) hash.get( "discountAsPerSetup_"+i ));
					dtlsNew.add((String) hash.get( "type_"+i ));
					dtlsNew.add((String) hash.get( "adhocDiscount_"+i ));
					dtlsNew.add((String) hash.get( "to_update"+i ));					
					dtlsNew.add((String) hash.get( "packageCode" ));					
					dtlsNew.add((String) hash.get( "reason_code"+i ));
					dtlsNew.add((String) hash.get( "reason_desc"+i ));
					dtlsNew.add((String) hash.get( "del_rec_YN"+i ));
					enconterDtls.set(i,dtlsNew);
//			}

			adhocDiscountDtls.put(packageSeqNo,enconterDtls);
			bean.setAdhocDiscountDtls(adhocDiscountDtls);
			bean.setPackageSeqNoList(packageSeqNoList);

		}
	}
	/* Added V180523-Aravindh/MMS-DM-SCF-0346/Starts */
	else if(func_mode.equals("copay_disc_valid_yn")) {
		
		packageSeqNo = request.getParameter("packageSeqNo");
		String custCode = request.getParameter("custCode");
		String custGroupCode = request.getParameter("custGroupCode");
		String episodeType = request.getParameter("episode_type");
		String episodeId = request.getParameter("episode_id");
		String packageCode = request.getParameter("packageCode");
		String visitId = request.getParameter("visit_id");
		
		String copayValidYN = "";
		
		CallableStatement cstmt = con.prepareCall("{ call bl_adhoc_disc_valid_copay_yn(?,?,?,?,?,?,?) }");
		cstmt.setString(1, facilityId);
		cstmt.setString(2, patientId);
		cstmt.setString(3, packageSeqNo);
		cstmt.setString(4, custCode);
		cstmt.setString(5, custGroupCode);
		cstmt.setString(6, episodeType);
		//cstmt.setString(7, episodeId);
		cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
		cstmt.execute();
		
		copayValidYN = cstmt.getString(7);
		
		out.print(copayValidYN);
	}
	/* Added V180523-Aravindh/MMS-DM-SCF-0346/Ends */
}
catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgAdhocDiscountValidation :"+e);
}
finally
{	
	if(pstmt != null)		pstmt.close();
	if(rs != null)		rs.close();
	ConnectionManager.returnConnection(con, request);
}

putObjectInBean(bean_id,bean,request);
%>

