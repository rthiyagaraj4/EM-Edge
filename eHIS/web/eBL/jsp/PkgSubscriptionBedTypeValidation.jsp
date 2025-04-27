<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.PkgSubsBean, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
try {
		

		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id		= "PkgSubsBean" ;
		String bean_name	= "eBL.PkgSubsBean";
		PkgSubsBean bean			= (PkgSubsBean)getBeanObject( bean_id, bean_name, request ) ;
	
		String blng_class_code="";
		HashMap patPackSubsDetails = new HashMap();
		String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
			String bed_type	= (String) hash.get( "bed_type" );
			String patientid	= (String) hash.get( "patientid" );
		if(func_mode.equals("BED_TYPE_CHK"))
		{
			patPackSubsDetails=bean.getPatientPackSubsDtls();	
			ArrayList	pkgDtls	=	new ArrayList();
			pstmt = con.prepareStatement( "SELECT BED_TYPE_CODE,BLNG_CLASS_CODE,BLNG_SERV_CODE FROM bl_ip_bed_type WHERE BED_TYPE_CODE='"+bed_type+"'");	
			rs = pstmt.executeQuery();	
			while(rs!=null && rs.next())
			{
				blng_class_code  =  rs.getString(2);
			}
			if(blng_class_code==null) blng_class_code="";

			ArrayList	blng_class_code_list	=	new ArrayList();
			String pkg_blng_class_code="";
			if(patPackSubsDetails!=null && patPackSubsDetails.size()>0)
			{
				if(patPackSubsDetails.containsKey(patientid))
				{
					pkgDtls					=(ArrayList)patPackSubsDetails.get(patientid);
					if(pkgDtls.size()>0)
					{
						blng_class_code_list = (ArrayList)pkgDtls.get(5);

						if(blng_class_code_list!= null && blng_class_code_list.size() >0)
						{
							pkg_blng_class_code	=(String)blng_class_code_list.get(0);
						}
						
					}
				}
				if(!pkg_blng_class_code.equals(blng_class_code))
				{				
						//bean.clearBean();
						patPackSubsDetails.clear();
						 bean.setPatientPackSubsDtls(patPackSubsDetails);
						out.println("callBedTypeAlert()");
				}	
			}
		}
}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgSubsBedTypeValidation :"+e);
}
finally
	{	
		//if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}


%>

