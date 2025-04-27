<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<!--
Developed by	: P.Sudhakaran.
Module/Function : Generic Name for Service (Master)
				  Temporary JSP for BY SERVICE
-->

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>

<script language="JavaScript" src="../../eCommon/js/common.js" contentType="text/html;charset=ISO-8859-1"></script>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
     
   
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	HashMap dataMap		=null;
	String bean_id		= "genericnameforservice" ;
	String bean_name	= "ePH.GenericNameforServiceBean";
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;

	GenericNameforServiceBean bean = (GenericNameforServiceBean)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(locale);

	ArrayList DataList=bean.getDataList();


	//MODIFICATION OF DB

	int displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
	displaySize = 13;

	for( int i=0;i<DataList.size();i++ ){
		dataMap	= new HashMap();
		dataMap	= (HashMap)DataList.get(i);
		String dbcode    = (String)dataMap.get( "GENERIC_ID" ) ;
		String dbeffstat = (String)dataMap.get( "EFF_STATUS" ) ;
			if(hash.containsValue(dbcode)){
				for( int j=0;j<displaySize;j++ ){
					String value =(String) hash.get("GENERIC_CODE"+j);
					if(value!=null){
						if(value.equals(dbcode)){
							String dboper_mode = (String)hash.get( "OPER_MODE"+j ) ;
							String dbeff_status = (String)hash.get( "EFF_STATUS"+j ) ;
							if( !(dbeffstat.equals( dbeff_status )) ){
								dataMap.put( "OPER_MODE","U" );
							}
							else{
								dataMap.put( "OPER_MODE",dboper_mode );
							}

							dataMap.put( "EFF_STATUS",dbeff_status );
						}
				}
			}

		}
	}

%>
<%
putObjectInBean(bean_id,bean,request);
%>

