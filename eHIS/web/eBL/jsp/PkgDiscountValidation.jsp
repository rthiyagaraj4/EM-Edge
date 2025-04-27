<!DOCTYPE html>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
String bean_id			= "PkgDiscountBean" ;
String bean_name		= "eBL.PkgDiscountBean";
PkgDiscountBean bean	= (PkgDiscountBean)getBeanObject( bean_id, bean_name, request ) ;



try {
	request.setCharacterEncoding("UTF-8");

	String locale			= (String)session.getAttribute("LOCALE");

	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;	
	bean.setLanguageId(locale);		
	String	func_mode	= request.getParameter( "func_mode" );	
	if(func_mode != null && func_mode.equals("saveToBean" ) )
	{			
		String	total_records		=	(String) hash.get( "total_records" );
		ArrayList discPkgs=new ArrayList();
		int totalRec				=	Integer.parseInt(total_records);
		bean.setdiscPkgs(new ArrayList());// clear the bean first

		String pkgDiscDtl="";
		String pkg_code="";
		String cust_grp="";
		String reason_code="";
		String pkg_amount="";
		

		for(int i=0;i<totalRec; i++)
		{
//			Pakagecode~~PackageseqNo~~Disc type~~Disc amount~~Reason code~~Reason desc~~cust_grp_code~~custcode
         pkg_code =((String)hash.get("pkg_code"+i)==null?"":(String)hash.get( "pkg_code"+i));
         cust_grp =((String)hash.get("cust_grp"+i)==null?"":(String)hash.get( "cust_grp"+i));
         reason_code =((String)hash.get("reason_code"+i)==null?"":(String)hash.get( "reason_code"+i));
         pkg_amount =((String)hash.get("pkg_disc_amt"+i)==null?"":(String)hash.get( "pkg_disc_amt"+i));


			if(pkg_code.length() != 0 &&  cust_grp.length() != 0 && reason_code.length() != 0 && pkg_amount.length()!=0)
						   	  
	{
	    pkgDiscDtl =  ((String)hash.get("pkg_code"+i)==null?" ":(String)hash.get( "pkg_code"+i))+"~~";
		pkgDiscDtl =  pkgDiscDtl +((String)hash.get("pkg_seq_no"+i)==null?" ":(String)hash.get( "pkg_seq_no"+i))+"~~";
		pkgDiscDtl =  pkgDiscDtl +((String)hash.get("pkg_disc_type"+i)==null?" ":(String)hash.get( "pkg_disc_type"+i))+"~~";
		pkgDiscDtl =  pkgDiscDtl +((String)hash.get("pkg_disc_amt"+i)==null?" ":(String)hash.get( "pkg_disc_amt"+i))+"~~";
		pkgDiscDtl =  pkgDiscDtl +((String)hash.get("reason_code"+i)==null?" ":(String)hash.get( "reason_code"+i))+"~~";
		pkgDiscDtl =  pkgDiscDtl +((String)hash.get("reason_desc"+i)==null?" ":(String)hash.get( "reason_desc"+i))+"~~";
		pkgDiscDtl =  pkgDiscDtl +((String)hash.get("cust_grp"+i)==null?" ":(String)hash.get( "cust_grp"+i))+"~~";
		pkgDiscDtl =  pkgDiscDtl +((String)hash.get("cust_code"+i)==null?" ":(String)hash.get( "cust_code"+i))+"~~";
		pkgDiscDtl =  pkgDiscDtl +((String)hash.get("cust_desc"+i)==null?" ":(String)hash.get( "cust_desc"+i))+"~~"; 
		pkgDiscDtl =  pkgDiscDtl +((String)hash.get("pkg_amt"+i)==null?" ":(String)hash.get( "pkg_amt"+i))+"~~";  //Added By Vijay For MMS-ICN-00025
		
		discPkgs.add(i,pkgDiscDtl);
	}
		  
		}
		bean.setdiscPkgs(discPkgs);// set discounted pkg in the bean
		System.out.println("discPkgs  "+discPkgs);
		System.out.println("discPkgs "+bean.getdiscPkgs());
	}

}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgAssociationValidation.jsp="+e);
}
putObjectInBean(bean_id,bean,request);

%>

