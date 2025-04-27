<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Created by Uma on 6/7/2010 for  SRR20056-SCF-4500 IN021348--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.* "%> 
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		07/08/2017		Ramesh G		ML-MMOH-CRF-0345.1
12/02/2018	IN065713		Dinesh T		12/02/2017		Ramesh G		ML-MMOH-CRF-0987
10/10/2018	IN68241			Dinesh T		10/10/2018		Ramesh G		ML-MMOH-CRF-1227
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
08/01/2020	IN068314	Nijitha S     08/01/2020	Ramesh G	ML-MMOH-CRF-1229
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%
try
{
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= (String)hash.get("BEAN_ID");
	String l_class_name = (String)hash.get("CLASS_NAME");//IN062992
	String l_catalog_code = (String)hash.get("CATALOG_CODE");//IN062992
	String l_iv_prep_yn = (String)hash.get("IV_PREP_YN");//IN062992
	String l_dosage_type = (String)hash.get("P_DOSAGE_TYPE");
	String l_age_grp_code = (String)hash.get("P_AGE_GRP_CODE");

	CareSetBean bean = (CareSetBean)getBeanObject( bean_id,"eOR.CareSetBean", request ) ;
	
	String localeName=(String)session.getAttribute("LOCALE");
	bean.setLanguageId(localeName);

	//IN062992, starts
	//bean.setHashValues(hash);//IN062992
	if("DOSAGE_TYPE_AGE_GROUP".equals(l_class_name))
	{
		//bean.clearAdditionalCatalogs();//IN065713
		bean.clearAdditionalCatalogs(l_catalog_code);//IN065713
		bean.setAgeGrpWiseHashValues(hash);
	}
	else if("CLEAR_AGE_WISE_CATALOG_DETAILS".equals(l_class_name))
	{
		bean.getDBAgeWiseCatalogs().remove(l_catalog_code);
		//bean.ageWiseDBCatalogsSpecific(l_catalog_code);
	}
	else if("CLEAR_AGE_WISE_ALL_DETAILS".equals(l_class_name))
	{
		bean.getDBAgeWiseCatalogs().clear();
	}
	else if("CLEAR_ALL".equals(l_class_name))
	{
		bean.setApplicableTo(l_iv_prep_yn);
		bean.reloadFreqRecordedData();
		bean.clearAdditionalCatalogs();//IN065713
		
		bean.getDBAgeWiseCatalogs().clear();
		bean.getDBAgeWiseAdditionalCatalogs().clear();
		bean.getDosageTypeHashValues().clear();
		bean.getDosageTypeAdditionalKgHashValues().clear();
		bean.getDosageTypeAdditionalM2HashValues().clear();
	}
	else if("ORD_SET_AGE_GRP".equals(l_class_name))//IN065713, starts
	{
		bean.setAgeGrpWiseAdditionalHashValues(hash);
	}//IN065713, ends
	else if("DOSAGE_TYPE_DEFN_ADDITIONAL".equals(l_class_name))
	{
		if("K".equals(l_dosage_type))
			bean.setDosageTypeAdditionalKgHashValues(hash);
		else if("M".equals(l_dosage_type))
			bean.setDosageTypeAdditionalM2HashValues(hash);	
	}
	else if("DOSAGE_TYPE_DEFN".equals(l_class_name))
	{
		bean.setDosageTypeHashValues(hash);
	}
	else if("DOSAGE_TYPE_DEFN_CLEAR".equals(l_class_name))
	{	
		bean.clearDosageTypeWiseAdditional(l_catalog_code,l_dosage_type);		
	}	
	else if("CLEAR_ADDITIONAL_FOR_BASIC_DOSAGE_TYPE".equals(l_class_name))
	{	
		String l_index = (String)hash.get("INDEX");
		bean.clearAdditionalCatalogs(l_catalog_code);
		
		//if(bean.getDosageTypeHashValues().size()>0)
		out.println("clearAdditionals('"+l_index+"')");
	}
	else if("CLEAR_MAPPED_FACS".equals(l_class_name))//IN068370,IN068373, starts
	{
		bean.clearMappedFacilities();
	}//IN068370,IN068373, ends
	else if("VALIDATE_FPP_CATALOGS".equals(l_class_name)){//IN068314 Starts
		
		MultiRecordBean1 data =bean.getComponentStr();
		int size = data.getSize("DB");
		System.out.println("111:size1===>"+size);	
		out.println(size);
	}//IN068314 Ends
	else
	{		
		bean.setHashValues(hash);	
	}
	//IN062992, ends
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
e.printStackTrace();	
}
%>
