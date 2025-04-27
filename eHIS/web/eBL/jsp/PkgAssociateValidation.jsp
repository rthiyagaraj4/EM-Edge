

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,eBL.Common.*, eBL.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
Connection con			= ConnectionManager.getConnection();	
String bean_id		= "PkgAssociateBean" ;
String bean_name	= "eBL.PkgAssociateBean";
PkgAssociateBean bean			= (PkgAssociateBean)getBeanObject( bean_id, bean_name, request ) ;

String bean_id1		= "PkgApprovalBean" ;
String bean_name1	= "eBL.PkgApprovalBean";
PkgApprovalBean bean1			= (PkgApprovalBean)getBeanObject( bean_id1, bean_name1, request ) ;

try {
	request.setCharacterEncoding("UTF-8");

	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");

	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;	
	bean.setLanguageId(locale);		
	String	func_mode	= request.getParameter( "func_mode" );	
	if(func_mode != null && func_mode.equals("saveToBean" ) )
	{			
		String	total_records		=	(String) hash.get( "total_records" );
		ArrayList associatedPkgs=new ArrayList();
		int totalRec				=	Integer.parseInt(total_records);
		String associated="";
		bean.setAssociatedPkgs(new ArrayList());// clear the bean first

		for(int i=0;i<totalRec; i++)
		{
	   	   associated = (String) hash.get( "associated"+i );
		   
		   if(associated != null && associated.equals("Y"))
		   {
			associatedPkgs.add(((String)hash.get( "pkg_code"+i )==null?"":(String)hash.get( "pkg_code"+i ))+"~~"+((String)hash.get( "pkg_desc"+i )==null?"":(String)hash.get( "pkg_desc"+i ))+"~~"+((String)hash.get( "pkg_seq_no"+i )==null?"":(String)hash.get( "pkg_seq_no"+i ))+"~~"+((String)hash.get("from_date"+i)==null?" ":(String)hash.get("from_date"+i))+"~~"+((String)hash.get("pkgAmt"+i)==null?"":(String)hash.get("pkgAmt"+i)));			 
		   	System.out.println("associatedPkgs "+associatedPkgs.toString());
		   	//System.out.println("pkg amt "+(String)hash.get("pkgAmt"+i));
		   }
		}
		bean.setAssociatedPkgs(associatedPkgs);// set associated pkg in the bean
		System.out.println(" bean get  "+bean.getAssociatedPkgs());
	}else if(func_mode != null && func_mode.equals("chkPkgApprovals" ) ){
		String pkg_code=(String) hash.get( "pkg_code" );
		String pkg_desc=(String) hash.get( "pkg_desc" );
		String pkg_seq_no=(String) hash.get( "pkg_seq_no" );
		String calling_module_id = (String) hash.get( "calling_module_id" );
		String index=(String) hash.get( "index" );
		ArrayList apprvdPkgsList=bean1.getApprvdPkgsList();
		if(apprvdPkgsList.contains(""+pkg_code+"~~"+pkg_desc+"~~"+pkg_seq_no)){
			out.println("alert(getMessage('BL8610','BL'));eval(document.PkgAssociateDtl.associated"+index+").checked=true;eval(document.PkgAssociateDtl.associated"+index+").value='Y'");
		}
	}else if(func_mode != null && func_mode.equals("chkPkgvalidepisode" ) )
	{

		String pkg_code=(String) hash.get( "pkg_code" );
		String pkg_seq_no=(String) hash.get( "pkg_seq_no" );

		String allPayerGroupCode=(String) hash.get( "allPayerGroupCode" );
		String allPayerCode=(String) hash.get( "allPayerCode" );
		boolean errorFound=false;
		String calling_module_id = (String) hash.get( "calling_module_id" );
		String index=(String) hash.get( "index" );	
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		//Karthik added code for MMS-RY-SCF-0065 - This validation is to Verify whether the Payer for Package Association is present as Financial Information
 		if( allPayerGroupCode!=null && allPayerGroupCode.equals("")==false && allPayerGroupCode.equals("null")==false ){
 			//Modified dynamic construction of Sql by Rajesh V
 			String sql="SELECT COUNT (*) FROM bl_package_sub_hdr WHERE operating_facility_id =?  AND package_code =?  AND package_seq_no =? AND ((cust_group_code IS NOT NULL AND cust_group_code IN (";
 			StringTokenizer custGroupToken = new StringTokenizer(allPayerGroupCode,",");
 			int tokenCnt = 0;
 			List<String> custGroupList = new LinkedList<String>();
 			while(custGroupToken.hasMoreTokens()){
 				if(tokenCnt == 0){
 					sql = sql+"?";
 				}
 				else{
 					sql = sql+",?";
 				}
 				custGroupList.add(custGroupToken.nextToken());
 				tokenCnt++;
 			}
 			sql = sql + ")) OR (cust_group_code IS NULL) )";

			String strCount="";//BLHelper.getDescriptionViaSQL(con,sql,facility_id,pkg_code,pkg_seq_no,allPayerGroupCode);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, pkg_code);
			pstmt.setString(3, pkg_seq_no);
			int inPos = 4;
			for(String inElements:custGroupList){
				pstmt.setString(inPos, inElements);
				inPos++;
			}
			rst = pstmt.executeQuery();
			
			if(rst != null && rst.next()){
				strCount = rst.getString(1);
			}
			
			//System.err.println(facility_id+"/"+pkg_code+"/"+pkg_seq_no+"/"+custGroupList);
			//System.err.println("First Block Count->"+strCount);
			int count=Integer.parseInt(strCount);
			if(count==0){
				out.println("alert('Payer Group associated with Package is not present in Financial Details');");
				errorFound=true;
				//Added by Rajesh V for 5475
				out.println("eval(document.PkgAssociateDtl.associated"+index+").checked=false;eval(document.PkgAssociateDtl.associated"+index+").value='N'");
			}
		} 
		
 		if(errorFound==false && allPayerCode!=null && allPayerCode.equals("")==false && allPayerCode.equals("null")==false ){
 			//Modified dynamic construction of Sql by Rajesh V
 			String sql="SELECT COUNT (*) FROM bl_package_sub_hdr WHERE operating_facility_id =?  AND package_code =?  AND package_seq_no =? AND ((cust_code IS NOT NULL AND cust_code IN (";
			StringTokenizer custToken = new StringTokenizer(allPayerCode,",");
 			int tokenCnt = 0;
 			List<String> custList = new LinkedList<String>();
 			while(custToken.hasMoreTokens()){
 				if(tokenCnt == 0){
 					sql = sql+"?";
 				}
 				else{
 					sql = sql+",?";
 				}
 				custList.add(custToken.nextToken());
 				tokenCnt++;
 			}
 			sql = sql + ")) OR (cust_code IS NULL) )";
			String strCount="";//BLHelper.getDescriptionViaSQL(con,sql,facility_id,pkg_code,pkg_seq_no,allPayerCode);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, pkg_code);
			pstmt.setString(3, pkg_seq_no);
			int inPos = 4;
			for(String inElements:custList){
				pstmt.setString(inPos, inElements);
				inPos++;
			}
			rst = pstmt.executeQuery();
			
			if(rst != null && rst.next()){
				strCount = rst.getString(1);
			}
			//System.err.println(facility_id+"/"+pkg_code+"/"+pkg_seq_no+"/"+custList);
			//System.err.println("Second Block Count->"+strCount);
			int count=Integer.parseInt(strCount);
			if(count==0){
				out.println("alert('Payer associated with Package is not present in Financial Details');");
				errorFound=true;
				//Added by Rajesh V for 5475
				out.println("eval(document.PkgAssociateDtl.associated"+index+").checked=false;eval(document.PkgAssociateDtl.associated"+index+").value='N'");

			}
		} 


		if(errorFound==false && bean.pkgDefinedValidPatClass(facility_id,calling_module_id,pkg_code)==false)
		{	
		out.println("alert(getMessage('BL8688','BL'));eval(document.PkgAssociateDtl.associated"+index+").checked=false;eval(document.PkgAssociateDtl.associated"+index+").value='N'");
		}
		
	}

}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgAssociationValidation.jsp="+e);
}finally
{
	ConnectionManager.returnConnection(con, request);
}
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id1,bean1,request);

%>

