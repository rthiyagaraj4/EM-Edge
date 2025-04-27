<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
String bean_id			  = "bl_PkgAdhocDiscountBean" ;
String bean_name		  = "eBL.PkgAdhocDiscountBean";
PkgAdhocDiscountBean bean = (PkgAdhocDiscountBean)getBeanObject( bean_id, bean_name, request ) ;

try
{
	request.setCharacterEncoding("UTF-8");
	//Connection con = ConnectionManager.getConnection();	

	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	//	String	packageCode		= (String) hash.get( "packageCode" );	//unused variable
	//String	facilityId		= (String) hash.get( "facilityId" );	
	//String	patientId		= (String) hash.get( "patientId" );	
	String	packageSeqNo	= (String) hash.get( "packageSeqNo" );	
	String	totalRec		= (String) hash.get( "totalRec" );	
	String  adhocDiscount 	= "";
	String encounterId		= "";
	String encounterId_chk	= "";

	int totalRecords		= Integer.parseInt(totalRec);
	ArrayList enconterDtls		= new ArrayList();
	ArrayList dtls				= new ArrayList();
	ArrayList dtlsNew			= null;

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
		if(adhocDiscount!=null && !adhocDiscount.equals(""))
		{
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
				dtlsNew.add("N");
				
				enconterDtls.set(i,dtlsNew);
			
		}
		adhocDiscountDtls.put(packageSeqNo,enconterDtls);
		bean.setAdhocDiscountDtls(adhocDiscountDtls);
		bean.setPackageSeqNoList(packageSeqNoList);

	}

}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgVisitAdhocDiscountValidation :"+e);
}
putObjectInBean(bean_id,bean,request);
%>

