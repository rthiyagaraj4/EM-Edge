<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<!--
Developed by	: P.Sudhakaran.
Module/Function : Generic Name for Service (Master)
				  Temporary JSP for BY SERVICE
-->
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	   
	HashMap dataMap		= null;
	String bean_id		= "genericnameforservice" ;
	String bean_name	= "ePH.GenericNameforServiceBean";
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	out.println(hash);

	GenericNameforServiceBean bean = (GenericNameforServiceBean)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(locale);


	int displaySize = 13;

	for( int i=0;i<displaySize;i++ ){
		dataMap=new HashMap();
		if( hash.containsKey( "GENERIC_CODE"+i ) ){
			dataMap.put( "GENERIC_NAME",bean.getGenericName((String)hash.get("GENERIC_CODE"+i)));
			dataMap.put( "GENERIC_ID",(String)hash.get("GENERIC_CODE"+i) );
			dataMap.put( "EFF_STATUS",(String)hash.get("EFF_STATUS"+i) );
				if(   ((String)hash.get("PROCESS"+i)).equals("Y") ){
					dataMap.put( "OPER_MODE","I" );
					dataMap.put( "SOURCE","FB" );
				}
				else{
					dataMap.put( "OPER_MODE","DN" );
					dataMap.put( "SOURCE","FB" );

				}


	//set the latest values into FB

	bean.setGenericCodeResultPage((String)hash.get("GENERIC_CODE"+i), (String)hash.get("EFF_STATUS"+i), (String)hash.get("PROCESS"+i)) ;


	//Set the latest values into DB - includes insert/replace mode checking
			if( bean.chkDatainDB( ((String)hash.get("GENERIC_CODE"+i)) ) ){

					dataMap.put("SOURCE", (String)bean.getDataSource( (String)hash.get("GENERIC_CODE"+i) ) );
					boolean chk=bean.chkUpdateYN(((String)hash.get("GENERIC_CODE"+i)), ((String)hash.get("EFF_STATUS"+i)) );
						if(chk) dataMap.put( "OPER_MODE","U" );
				bean.replaceDataList(dataMap,((String)hash.get("GENERIC_CODE"+i)));
			}
			else {
			bean.setDataList(dataMap);
			}
		}//IF
	}//FOR

//Delete the duplicate records.

	bean.emptyDupRecords();

%>
<%
putObjectInBean(bean_id,bean,request);
%>

