<!DOCTYPE html>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
String bean_id			  = "bl_PkgSrvsToNonPkgSvsBean" ;
String bean_name		  = "eBL.PkgSrvsToNonPkgSvsBean";
PkgSrvsToNonPkgSvsBean bean = (PkgSrvsToNonPkgSvsBean)getBeanObject( bean_id, bean_name, request ) ;

try
{
	request.setCharacterEncoding("UTF-8");


	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	
	String	packageSeqNo	= (String) hash.get( "packageSeqNo" );	
	String	totalRec		= (String) hash.get( "totalRec" );	
	//String	source			= (String) hash.get( "source" );	
	String delChk			= "";

	int totalRecords		= Integer.parseInt(totalRec);
	ArrayList srvDetails	= new ArrayList();
	//	ArrayList dtls			= new ArrayList();//unused variable
	ArrayList dtlsNew		= null;

	ArrayList packageSeqNoList	= bean.getPackageSeqNoList();
	HashMap srvsToNonPkgSvsDtls	= bean.getSrvsToNonPkgSvsDtls();
	if(srvsToNonPkgSvsDtls!=null && srvsToNonPkgSvsDtls.containsKey(packageSeqNo))
	{
		srvDetails = 	(ArrayList)srvsToNonPkgSvsDtls.get(packageSeqNo);
	}
	for(int i=0;i<totalRecords;i++)
	{
		delChk = (String) hash.get( "del_"+i );
		if(delChk.equals("Y"))
		{
			if(!(packageSeqNoList.contains(packageSeqNo)))
				packageSeqNoList.add(packageSeqNo);
		}
		dtlsNew	= new ArrayList();
		dtlsNew.add((String) hash.get( "transDocRef_"+i ));
		dtlsNew.add((String) hash.get( "transDocRefLineNo_"+i ));
		dtlsNew.add((String) hash.get( "billingSrvCode_"+i ));
		dtlsNew.add((String) hash.get( "billingSrvDesc_"+i ));
		dtlsNew.add((String) hash.get( "serviceDate_"+i ));
		dtlsNew.add((String) hash.get( "serviceQty_"+i ));
		dtlsNew.add((String) hash.get( "exemptInPkg_"+i ));
		dtlsNew.add((String) hash.get( "policyNo_"+i ));
		dtlsNew.add((String) hash.get( "payerspkgCoverage_"+i ));
		dtlsNew.add((String) hash.get( "patientpayable_"+i ));
		dtlsNew.add((String) hash.get( "del_"+i ));
		srvDetails.set(i,dtlsNew);
		srvsToNonPkgSvsDtls.put(packageSeqNo,srvDetails);
		bean.setSrvsToNonPkgSvsDtls(srvsToNonPkgSvsDtls);
		bean.setPackageSeqNoList(packageSeqNoList);
		
	}

}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgSrvsToNonPkgSvsValidation :"+e);
}
putObjectInBean(bean_id,bean,request);
%>

