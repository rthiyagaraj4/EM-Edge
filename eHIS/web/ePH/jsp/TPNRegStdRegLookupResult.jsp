<!DOCTYPE html>
<!-- 
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/02/2017      IN68728            Devindra          ML-MMOH-CRF-1266 [IN:068728]   
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.Connection,webbeans.eCommon.ConnectionManager"%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>



<html>

<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id          = (String)session.getValue( "facility_id" );
//out.println("TPNRegStdRegLookupResult.jsp--->" );
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/TPNStdRegimen.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<%!
public String roundTwoDigits(String a)
{
	try
	{
		
		String bb = "";
			if (a.indexOf(".")==-1)
			{
				bb=a.substring(0,a.length());
			}
			else
			{   
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3)
				{
					bb=a.substring(0,a.indexOf(".")+3);
				}
				else
				{
					bb=a;
				}
			
			}
			return bb;
	}
	catch (Exception e)
	{
			return a;
			
	}
}

%>

<!--<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">

<%
	//Search Criteria's from Query Criteria page
	String regname			= request.getParameter( "regname" );
	String searchpos		= request.getParameter( "searchpos" );
	String chofrom			= request.getParameter( "chofrom" );
	String choto			= request.getParameter( "choto" );
	String proteinfrom		= request.getParameter( "proteinfrom" );
	String proteinto		= request.getParameter( "proteinto" );
	String lipidfrom		= request.getParameter( "lipidfrom" );
	String lipidto			= request.getParameter( "lipidto" );
	String eml_type			= request.getParameter( "eml_type" );
	String cho_energy		= request.getParameter("cho_energy");
	String pro_energy		= request.getParameter("pro_energy");
	String lipd_energy		= request.getParameter("lipd_energy");
	String cho_qty			= request.getParameter("cho_qty");
	String pro_qty			= request.getParameter("pro_qty");
	String lipd_qty			= request.getParameter("lipd_qty");
	String fluid			= request.getParameter("fluid");
	String unit				= request.getParameter("unit");
		 //  unit				= unit.substring(0,(unit.indexOf("/"))) ;
	String fluidunit		= request.getParameter("fluidunit");
	String assmnt_total		= (Integer.parseInt(cho_energy))+(Integer.parseInt(pro_energy))+(Integer.parseInt(lipd_energy))+"";
   	String sqlappend		= "";
    String queryString		= request.getQueryString();

	String basedOnAssmntValues		= request.getParameter( "basedOnAssmntValues" );    
	String displayRecords			= request.getParameter( "displayRecords" ); 
	String CHO						= request.getParameter( "CHO" ) ;    
	String PROTEIN					= request.getParameter( "PROTEIN" );      
	String LIPID					= request.getParameter( "LIPID" )  ;

	String CHO_PER					= request.getParameter( "CHO_PER" );    
	String PROTEIN_PER				= request.getParameter( "PROTEIN_PER" );      
	String LIPID_PER				= request.getParameter( "LIPID_PER" )== "" ? "0":request.getParameter( "LIPID_PER" );
	if(basedOnAssmntValues.equals("Y")){
		chofrom  = (Integer.parseInt(CHO)-Integer.parseInt(CHO_PER))+""; 
		choto	 = (Integer.parseInt(CHO)+Integer.parseInt(CHO_PER))+""; 

		proteinfrom  = (Integer.parseInt(PROTEIN)-Integer.parseInt(PROTEIN_PER))+""; 
		proteinto	 = (Integer.parseInt(PROTEIN)+Integer.parseInt(PROTEIN_PER))+""; 

		lipidfrom  = (Integer.parseInt(LIPID)-Integer.parseInt(LIPID_PER))+""; 
		lipidto	 = (Integer.parseInt(LIPID)+Integer.parseInt(LIPID_PER))+""; 
	}

//	String Rf_Name		= request.getParameter( "RFName" ) ;
//	String Drug_Code		= request.getParameter( "DrugCode" ) ;
//	String Drug_Desc		= request.getParameter( "DrugName" ) ;

	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	String bean_id	= "TPNStandardRegimenBean";
	String bean_name	 = "ePH.TPNStandardRegimenBean";
	TPNStandardRegimenBean bean = (TPNStandardRegimenBean)getBeanObject(bean_id, bean_name,request);
	ArrayList generics=bean.getTPNGenerics("EL");
	ArrayList energyConst = bean.getTPNConstEnrg("MN");  // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
	String select_energy_const_weight_query = "";
	String select_energy_const_energy_query = "";
	String where_clause_query = "";
	String energy_const_code ="";
	String energy_const_name ="";
	ArrayList displayFieldsConstWeight = new ArrayList();
	ArrayList displayFieldsConstEnergy = new ArrayList();
	ArrayList energyConstName = new ArrayList();
	ArrayList energyConstcode = new ArrayList();
	ArrayList columnHeader   = new ArrayList();
	Connection con			= null;
	boolean macro_nutrients_not_mnd_yn = false;
	boolean tpn_tab_reg = false;//ML-MMOH-CRF-1290
        try{
	   con				= ConnectionManager.getConnection(request);    
           macro_nutrients_not_mnd_yn = CommonBean.isSiteSpecific(con, "PH", "MACRO_ENTERABLE_YN");
           tpn_tab_reg          =eCommon.Common.CommonBean.isSiteSpecific(con, "PH","INSTRUCTIONS_REQUIRED_YN");//ADDED FOR ML-MMOH-CRF-1290
        }
	 catch(Exception e){
		e.printStackTrace();
	 }
	 finally{
		if(con != null){
		   ConnectionManager.returnConnection(con,request);
		}
	 }
         for(int i=0;i<energyConst.size();i=i+2){
    	 
    	 energy_const_code = "";
    	 
    	 energy_const_name = "";
    	 
    	 energy_const_code = CommonBean.checkForNull((String)energyConst.get(i));
    	 
    	 energy_const_name = CommonBean.checkForNull((String)energyConst.get(i+1));
    	 
    	 energyConstName.add(energy_const_name);
    	 energyConstcode.add(energy_const_code);
    	 
    	 displayFieldsConstWeight.add("const_weight_"+energy_const_code);
    	 
    	 displayFieldsConstEnergy.add("const_energy_"+energy_const_code);
    	 
    	 columnHeader.add(energy_const_code);
    	    	   
    	 select_energy_const_weight_query = select_energy_const_weight_query+",(SELECT const_weight FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + "AND tpn_regimen_code = a.tpn_regimen_code) const_weight_"+energy_const_code;
    	 
    	 select_energy_const_energy_query = select_energy_const_energy_query+",(SELECT const_weight FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND tpn_regimen_code = a.tpn_regimen_code) * (SELECT energy_rel_value FROM ph_tpn_energy_for_const WHERE constituent_code = "+"'"+energy_const_code+"'"+") const_energy_"+energy_const_code;
         
    	 if(i==0){
    		 if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y") && (energy_const_code.equals("CHO") || energy_const_code.equals("PROTEIN"))){
    		   where_clause_query = where_clause_query+"a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL (?, 0) AND NVL (?, 100000))";
    		 }
    		 else if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y") && energy_const_code.equals("LIPID")){
      		   where_clause_query = where_clause_query+"a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL (?, 0) AND NVL (?, 100000) AND NVL (emulsion_type, '%') LIKE DECODE (?, 'A', '%', ?))";
      		 }
    		 else{
    		   where_clause_query = where_clause_query+"a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL ('', 0) AND NVL ('', 100000))";
    		 }
         }
         else{
        	 if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y") && (energy_const_code.equals("CHO") || energy_const_code.equals("PROTEIN"))){
    	       where_clause_query = where_clause_query+" or a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL (?, 0) AND NVL (?, 100000))";
        	 }
        	 else if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y") && energy_const_code.equals("LIPID")){
      	       where_clause_query = where_clause_query+" or a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL (?, 0) AND NVL (?, 100000)AND NVL (emulsion_type, '%') LIKE DECODE (?, 'A', '%', ?))";
          	 }
        	 else{
        		 where_clause_query = where_clause_query+" or a.tpn_regimen_code IN ( SELECT tpn_regimen_code FROM ph_const_for_tpn_regimen WHERE const_generic_code =" +"'"+energy_const_code+"'" + " AND const_weight BETWEEN NVL ('', 0) AND NVL ('', 100000))";
        	 }
         }
        } // Added for ML-MMOH-CRF-1266 [IN:068728] - End
    

try{
	if (generics.size()>0)
	{
		for (int i=0;i<generics.size();i++)
		{
		String code=(String)generics.get(i);	
		String val	=request.getParameter(code);
		if  ( val!=null && !val.equals("") && !val.equals("0") )
		{
			sqlappend+=" AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='"+code+"' AND  CONST_WEIGHT ="+val +")";
		
		}
		}

	}
	
	
	
	String classvalue			= "";

	regname = CommonBean.checkForNull( regname );
	searchpos = CommonBean.checkForNull( searchpos );
	if ( searchpos.equals("sw"))
	{
		regname=regname+"%"	;
		
	}
	else
	{
			regname="%"+regname+"%"	;
	}


//	Drug_Code = CommonBean.checkForNull( Drug_Code );
//	Drug_Desc = CommonBean.checkForNull( Drug_Desc );

	//Common parameters.
	HashMap sqlMap = new HashMap();

	//out.println(PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT2"));
	
	//Function Parameters
	HashMap funcMap = new HashMap();
	//String SQL_PH_TPN_STD_REGIMEN_SELECT2 = "SELECT    A.TPN_REGIMEN_CODE,   A.LONG_NAME,   A.TOTAL_VOLUME,   A.PRES_BASE_UNIT, (SELECT CONST_WEIGHT  FROM    PH_CONST_FOR_TPN_REGIMEN WHERE     CONST_GENERIC_CODE='CHO' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    CHO, (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN        WHERE CONST_GENERIC_CODE='PROTEIN' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    PROTEIN,      (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN    WHERE CONST_GENERIC_CODE='LIPID' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    LIPID,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'CHO' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'CHO'  )) CHO_KCAL, ((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'PROTEIN' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'PROTEIN'  )) PROTEIN_KCAL,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN  WHERE CONST_GENERIC_CODE = 'LIPID' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM  PH_TPN_ENERGY_FOR_CONST  WHERE CONSTITUENT_CODE = 'LIPID'  ))  LIPID_KCAL     FROM    PH_TPN_REGIMEN_LANG_VW A WHERE    STANDARD_REGIMEN_YN='Y' AND EXISTS (SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = A.TPN_REGIMEN_CODE AND EFF_STATUS = 'E') AND SYSTEM_CREATED_YN='N' AND   UPPER(A.LONG_NAME) LIKE UPPER(?) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='CHO' AND   CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='PROTEIN' AND  CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='LIPID'  AND CONST_WEIGHT   BETWEEN NVL(?,0) AND   NVL(?,100000) AND NVL(emulsion_type,'%') LIKE  DECODE(?,'A','%',?))  AND A.LANGUAGE_ID = ?";

	//SRR20056-SCF-7808 - chandrasekhar
	//String SQL_PH_TPN_STD_REGIMEN_SELECT2 = "SELECT    A.TPN_REGIMEN_CODE,   A.LONG_NAME,   A.TOTAL_VOLUME,   A.PRES_BASE_UNIT, (SELECT CONST_WEIGHT  FROM    PH_CONST_FOR_TPN_REGIMEN WHERE     CONST_GENERIC_CODE='CHO' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    CHO, (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN        WHERE CONST_GENERIC_CODE='PROTEIN' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    PROTEIN,      (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN    WHERE CONST_GENERIC_CODE='LIPID' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    LIPID,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'CHO' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'CHO'  )) CHO_KCAL, ((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'PROTEIN' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'PROTEIN'  )) PROTEIN_KCAL,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN  WHERE CONST_GENERIC_CODE = 'LIPID' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM  PH_TPN_ENERGY_FOR_CONST  WHERE CONSTITUENT_CODE = 'LIPID'  ))  LIPID_KCAL     FROM    PH_TPN_REGIMEN_LANG_VW A WHERE    STANDARD_REGIMEN_YN='Y' AND EXISTS (SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = A.TPN_REGIMEN_CODE AND EFF_STATUS = 'E') AND SYSTEM_CREATED_YN='N' AND   UPPER(A.LONG_NAME) LIKE UPPER(?) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='CHO' AND   CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='PROTEIN' AND  CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='LIPID'  AND CONST_WEIGHT   BETWEEN NVL(?,0) AND   NVL(?,100000) AND NVL(emulsion_type,'%') LIKE  DECODE(?,'A','%',?))  AND A.LANGUAGE_ID = ?"; // Added for ML-MMOH-CRF-1266 [IN:068728] - Start

	String SQL_PH_TPN_STD_REGIMEN_SELECT2 = ""; 
	 
	if(macro_nutrients_not_mnd_yn){ 
	  SQL_PH_TPN_STD_REGIMEN_SELECT2 = "SELECT    A.TPN_REGIMEN_CODE,   A.LONG_NAME,   A.TOTAL_VOLUME,   A.PRES_BASE_UNIT"+select_energy_const_weight_query + select_energy_const_energy_query+" FROM  PH_TPN_REGIMEN_LANG_VW A WHERE    STANDARD_REGIMEN_YN='Y' AND EXISTS (SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = A.TPN_REGIMEN_CODE AND EFF_STATUS = 'E') AND SYSTEM_CREATED_YN='N' AND   UPPER(A.LONG_NAME) LIKE UPPER(?) AND ("+ where_clause_query +") AND A.LANGUAGE_ID = ?";	
	} 
	else{		
	  SQL_PH_TPN_STD_REGIMEN_SELECT2 = "SELECT    A.TPN_REGIMEN_CODE,   A.LONG_NAME,   A.TOTAL_VOLUME,   A.PRES_BASE_UNIT, (SELECT CONST_WEIGHT  FROM    PH_CONST_FOR_TPN_REGIMEN WHERE     CONST_GENERIC_CODE='CHO' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    CHO, (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN        WHERE CONST_GENERIC_CODE='PROTEIN' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    PROTEIN,      (SELECT CONST_WEIGHT   FROM PH_CONST_FOR_TPN_REGIMEN    WHERE CONST_GENERIC_CODE='LIPID' AND   TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE)    LIPID,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'CHO' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'CHO'  )) CHO_KCAL, ((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN WHERE CONST_GENERIC_CODE = 'PROTEIN' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM PH_TPN_ENERGY_FOR_CONST WHERE CONSTITUENT_CODE = 'PROTEIN'  )) PROTEIN_KCAL,((SELECT CONST_WEIGHT FROM PH_CONST_FOR_TPN_REGIMEN  WHERE CONST_GENERIC_CODE = 'LIPID' AND TPN_REGIMEN_CODE = A.TPN_REGIMEN_CODE) *  (SELECT ENERGY_REL_VALUE FROM  PH_TPN_ENERGY_FOR_CONST  WHERE CONSTITUENT_CODE = 'LIPID'  ))  LIPID_KCAL     FROM    PH_TPN_REGIMEN_LANG_VW A WHERE    STANDARD_REGIMEN_YN='Y' AND EXISTS (SELECT ORDER_CATALOG_CODE FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = A.TPN_REGIMEN_CODE AND EFF_STATUS = 'E') AND SYSTEM_CREATED_YN='N' AND   UPPER(A.LONG_NAME) LIKE UPPER(?) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='CHO' AND   CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='PROTEIN' AND  CONST_WEIGHT    BETWEEN NVL(?,0) AND   NVL(?,100000) ) AND   A.TPN_REGIMEN_CODE IN (   SELECT TPN_REGIMEN_CODE FROM PH_CONST_FOR_TPN_REGIMEN   WHERE CONST_GENERIC_CODE='LIPID'  AND CONST_WEIGHT   BETWEEN NVL(?,0) AND   NVL(?,100000) AND NVL(emulsion_type,'%') LIKE  DECODE(?,'A','%',?))  AND A.LANGUAGE_ID = ?";
	} // Added for ML-MMOH-CRF-1266 [IN:068728] - End


	//AND eff_status = 'E') AND system_created_yn = 'N'   AND UPPER(A.LONG_NAME) LIKE UPPER(?)     AND a.tpn_regimen_code = b.tpn_regimen_code(+)   AND   b.const_generic_code(+)  ='CHO'  AND b.const_generic_code(+) = 'PROTEIN'    AND  b.const_generic_code(+) ='LIPID' AND const_weight(+) BETWEEN NVL ('', 0) AND NVL ('', 100000)  AND A.LANGUAGE_ID = ?";


	String sql=SQL_PH_TPN_STD_REGIMEN_SELECT2+sqlappend;
	
//	String sql=PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT2")+sqlappend;
	
//	out.println(sql);

	sqlMap.put( "sqlData", sql);

	ArrayList displayFields = new ArrayList();
	displayFields.add( "TPN_REGIMEN_CODE" );
	displayFields.add( "LONG_NAME" );
	displayFields.add( "TOTAL_VOLUME" );
	displayFields.add( "PRES_BASE_UNIT" );
 if(macro_nutrients_not_mnd_yn){ // Added for ML-MMOH-CRF-1266 [IN:068728] - Start
	displayFields.addAll(displayFieldsConstWeight);
	displayFields.addAll(displayFieldsConstEnergy);
 } // Added for ML-MMOH-CRF-1266 [IN:068728] - End
 else{
	displayFields.add( "CHO" );
	displayFields.add( "PROTEIN" );
	displayFields.add( "LIPID" );
	displayFields.add( "CHO_KCAL" );
	displayFields.add( "PROTEIN_KCAL" );
	displayFields.add( "LIPID_KCAL" );
 }
	ArrayList chkFields = new ArrayList();

  chkFields.add( regname);
  
  if(macro_nutrients_not_mnd_yn && basedOnAssmntValues.equals("Y")){	
	
	for(int j=0;j<energyConstcode.size();j++){
		if(((String)energyConstcode.get(j)).equals("CHO")){
			chkFields.add( chofrom);
			chkFields.add( choto);			
		}
		else if(((String)energyConstcode.get(j)).equals("PROTEIN")){
			chkFields.add( proteinfrom);
			chkFields.add( proteinto);			
		}
		else if(((String)energyConstcode.get(j)).equals("LIPID")){
			chkFields.add( lipidfrom);
			chkFields.add( lipidto);  
			chkFields.add( eml_type);
			chkFields.add( eml_type);			
		}
	}
  }
  else if(!macro_nutrients_not_mnd_yn){
	  chkFields.add( chofrom);
	  chkFields.add( choto);
	  chkFields.add( proteinfrom);
	  chkFields.add( proteinto);
	  chkFields.add( lipidfrom);
	  chkFields.add( lipidto);  
	  chkFields.add( eml_type);
	  chkFields.add( eml_type);
  }
	chkFields.add( locale);

//	chkFields.add( Rf_Id.trim() + "%" );
//	chkFields.add( Rf_Name.trim() + "%" );
	
	

	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
	
	if((result.size()>=3) && ( !( ((String) result.get(0)).equals("0")))){ // (result.size()>=3) changed to (result.size()>3) for ML-MMOH-CRF-1266 [IN:068728]
		%>
		 <table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp; 
	<%
		// For display the previous/next link
		out.println(result.get(1));
	%>
		</td></tr>
		</table>
		<%if(macro_nutrients_not_mnd_yn){ %>
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr> <th colspan=4>&nbsp;</th><th colspan=<%=energyConstName.size()%>><fmt:message key="ePH.Weightin.label" bundle="${ph_labels}"/> <%=unit%></th><th colspan=<%=energyConstName.size()+1%> align='center'><fmt:message key="ePH.EnergyinKCal.label" bundle="${ph_labels}"/></th><th colspan=1 >&nbsp;</th></tr>
		<tr><th  style="width:5%"><fmt:message key="ePH.RegimenCode.label" bundle="${ph_labels}"/></th>
		<th  style="width:60%"><fmt:message key="ePH.RegimenName.label" bundle="${ph_labels}"/></th>
		<th style="width:10%" colspan=2><fmt:message key="Common.volume.label" bundle="${common_labels}"/></th>
	    
	   <% for(int j=0;j<energyConstName.size();j++){	
	       if(j==0){%>
	        <th style="width:5%"><fmt:message key="Common.volume.label" bundle="${common_labels}"/><%=energyConstName.get(j)%></th>
	      <%}else{ %>	
	        <th style="width:5%"><%=energyConstName.get(j)%></th>
	      <%}
	     }%>	   
	   <%for(int j=0;j<energyConstName.size();j++){
	      if(j==0){%>
	        <th style="width:5%"><fmt:message key="Common.volume.label" bundle="${common_labels}"/><%=energyConstName.get(j)%></th>
	    <%}else{ %>	
	        <th style="width:5%"><%=energyConstName.get(j)%></th>
	     <%}
	     }%>
		<th style="width:5%"><fmt:message key="Common.total.label" bundle="${common_labels}"/></th>
		<th style="width:5%"></th></tr> 
		<tr>
		<td>&nbsp;</td>
		<td style="font-weight:bold;padding-right: 35%;" ><fmt:message key="ePH.AssesmentValue.label" bundle="${ph_labels}"/></td>
		<TD style="font-weight:bold;padding-right: 5%;"><%=fluid%></TD>
		<TD style="font-weight:bold;padding-right: 6%;" ><%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,fluidunit))%></TD>
		<TD style="font-weight:bold;padding-right: 9%;" align='left'><%=cho_qty%></TD>
		<TD style="font-weight:bold;padding-right: 9%;" align='left'><%=pro_qty%></TD>
		<TD style="font-weight:bold;padding-right: 9%;" align='left'><%=lipd_qty%></TD>
		<% for(int j=3;j<energyConstName.size();j++){%>	
	     <TD style="font-weight:bold;padding-right: 9%;" align='left'>0</TD>
	    <%}%>
		<TD style="font-weight:bold;padding-right: 9%;" align='left'><%=cho_energy%></TD>
		<TD style="font-weight:bold;padding-right: 9%;" align='left'><%=pro_energy%></TD>
		<TD style="font-weight:bold;padding-right: 9%;" align='left'><%=lipd_energy%></TD>
		<% for(int j=3;j<energyConstName.size();j++){%>	
	     <TD style="font-weight:bold;padding-right: 9%;" align='left'>0</TD>
	    <%}%>
		<TD style="font-weight:bold" align='left'><%=roundTwoDigits(assmnt_total)%></TD>
		<td style="font-weight:bold;padding-right: 10%">&nbsp;</td>
         </tr>
		 <%}else{ %>		 
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr> <th colspan=4 >&nbsp;</th><th colspan=3 ><fmt:message key="ePH.Weightin.label" bundle="${ph_labels}"/> <%=unit%></th><th colspan=4 align='center'><fmt:message key="ePH.EnergyinKCal.label" bundle="${ph_labels}"/></th><th colspan=1 >&nbsp;</th></tr>
		 <tr><th  style="width:5 %"><fmt:message key="ePH.RegimenCode.label" bundle="${ph_labels}"/></th>
		 <th  style="width:30%"><fmt:message key="ePH.RegimenName.label" bundle="${ph_labels}"/></th>
		<th style="width:10%" colspan=2><fmt:message key="Common.volume.label" bundle="${common_labels}"/></th>
		<th style="width:5%"><fmt:message key="Common.volume.label" bundle="${common_labels}"/>CHO</th>
		<th style="width:5%"><fmt:message key="ePH.Protein.label" bundle="${ph_labels}"/></th>
		<th style="width:5%"> <fmt:message key="Common.Lipid.label" bundle="${common_labels}"/></th>
		<th style="width:5%"><fmt:message key="Common.volume.label" bundle="${common_labels}"/>CHO</th>
		<th style="width:5%"><fmt:message key="ePH.Protein.label" bundle="${ph_labels}"/></th>
		<th style="width:5%"> <fmt:message key="Common.Lipid.label" bundle="${common_labels}"/></th>
		<th style="width:5%"><fmt:message key="Common.total.label" bundle="${common_labels}"/></th>
		<th style="width:5%"></th></tr> 
		<tr>
		<td>&nbsp;</td>
		<td style="font-weight:bold"><fmt:message key="ePH.AssesmentValue.label" bundle="${ph_labels}"/></td>
		<TD style="font-weight:bold"><%=fluid%></TD>
		<TD style="font-weight:bold" nowrap ><%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,fluidunit))%></TD>
		<TD style="font-weight:bold" align='right'><%=cho_qty%></TD>
		<TD style="font-weight:bold" align='right'><%=pro_qty%></TD>
		<TD style="font-weight:bold" align='right'><%=lipd_qty%></TD>
		<TD style="font-weight:bold" align='right'><%=cho_energy%></TD>
		<TD style="font-weight:bold" align='right'><%=pro_energy%></TD>
		<TD style="font-weight:bold" align='right'><%=lipd_energy%></TD>
		<TD style="font-weight:bold" align='right'><%=roundTwoDigits(assmnt_total)%></TD>
		<td style="font-weight:bold">&nbsp;</td>
         </tr>         
		<%}
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if(basedOnAssmntValues.equals("Y") && (displayRecords != "0") && ((recCount-2) > Integer.parseInt(displayRecords))){break;}
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr >
	<%
		
			records=(ArrayList) result.get( recCount );
			
			for(int colCount=0; colCount<records.size(); colCount++){
				
				
				String dkVal = (String)records.get( colCount );
                
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
					
					if (colCount==0)
				{
					//put in a hyperlink and on click pass the selected name, code to the calliing page
					String desc=(String)records.get(colCount+1);
					out.println("<TD style='color:blue;cursor:pointer'   class='"+classvalue+"'onClick=\"chooseRegimen('"+dkVal+"','"+desc+"','"+tpn_tab_reg+"')\">"+dkVal+"</TD>");//,'"+tpn_tab_reg+"' added  ml-mmoh-crf-1290 
				}
				else if(colCount>3)
				{
						out.println("<TD align='right' class='"+classvalue+"'>"+dkVal+"</TD>");

				}
				else
				{
 					out.println("<TD class='"+classvalue+"'>"+dkVal+"</TD>");
				}
			
				
				}				   							       
			       String code=(String)records.get(0);
				   String cho_kcal= CommonBean.checkForNull((String)records.get( 7 ), "0"); // CommonBean.checkForNull added for ML-MMOH-CRF-1266 [IN:068728] - Start
				   String pro_kcal=CommonBean.checkForNull((String)records.get( 8 ),"0");
				   String lipid_kcal=CommonBean.checkForNull((String)records.get( 9 ),"0"); // CommonBean.checkForNull added for ML-MMOH-CRF-1266 [IN:068728] - End
				   String total =(Float.parseFloat(cho_kcal))+(Float.parseFloat(pro_kcal))+(Float.parseFloat(lipid_kcal))+"";
				   
				   if(macro_nutrients_not_mnd_yn){ // ML-MMOH-CRF-1266 [IN:068728] - Start
					   total="0";
					   for(int j=records.size()-energyConstcode.size();j<records.size();j++){
						   total = Float.parseFloat(total)+Float.parseFloat(CommonBean.checkForNull((String)records.get(j),"0"))+"";
					   }
				   } // ML-MMOH-CRF-1266 [IN:068728] - End
				   
				   
				   
				   out.println("<TD align='right' class='"+classvalue+"'>"+roundTwoDigits(total)+"</TD>");
				   out.println("<Td  style='color:blue;cursor:pointer'  onClick=\"displayConst('"+code+"')\"> Constituents</Td>");
	%>
			</tr>
	<%
		}
	%>
		</table>
	<%
		out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/TPNRegStdRegLookupResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
<% putObjectInBean(bean_id,bean,request); %>
<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\">";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\">";
}
%>
</body>
</html>

