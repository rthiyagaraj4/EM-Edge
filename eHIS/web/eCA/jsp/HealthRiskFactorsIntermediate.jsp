<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");

Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String sql			= "";
String module_id	= "";
String sub_code 	= "";
String sub_code1 	= "";
String mode 		= "";
String locale 		= "";
try
{
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	locale 	= (String) p.getProperty("LOCALE");
		
	con =	ConnectionManager.getConnection(request);
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;

	if(hash.containsKey("module_id") ){
		module_id = (String)hash.get("module_id");
		if("AG".equals(module_id)){
			mode = (String)hash.get("mode");
			out.println("clearAgeGroups(\""+mode+"\");");
			if("insert".equals(mode)){
				sql="SELECT AGE_GROUP_CODE CODE,SHORT_DESC DESCRIPTION FROM AM_AGE_GROUP ORDER BY SHORT_DESC";
			}else{
				sub_code = (String)hash.get("sub_code");
				sql="SELECT AGE_GROUP_CODE CODE,SHORT_DESC DESCRIPTION FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE='"+sub_code+"'";
			}
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			String ageGroup_Id = null;
			String ageGrup_Desc = null;
			while (rs.next()) 
			{
					ageGroup_Id=rs.getString("CODE")==null?"":rs.getString("CODE");
					ageGrup_Desc=rs.getString("DESCRIPTION")==null?"":rs.getString("DESCRIPTION");
					out.println( "addAgeGroups(\""+ageGroup_Id+"\",\""+ageGrup_Desc+"\",\""+mode+"\");");
					ageGroup_Id = null;
					ageGrup_Desc = null;
			}
			if (rs!= null) rs.close();
			if (pstmt!= null) pstmt.close();		
		}else if("AGPATSEX".equals(module_id)){			
			sub_code = (String)hash.get("sub_code");
			sql="SELECT GENDER FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,sub_code);
			rs = pstmt.executeQuery();			
			String patSex="";
			if(rs.next()) 
				patSex=rs.getString("GENDER")==null?"":rs.getString("GENDER");			
			out.println("setPatientSex(\""+patSex+"\");");
			if (rs!= null) rs.close();
			if (pstmt!= null) pstmt.close();
		
		}else if("AL".equals(module_id)){
			mode = (String)hash.get("mode");
			out.println("clearAdverseEvents(\""+mode+"\");");
			sql="SELECT ADV_EVENT_TYPE_CODE CODE,SHORT_DESC DESCRIPTION from MR_ADV_EVENT_TYPE ORDER BY SHORT_DESC";
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			String advEvent_Id = null;
			String advEvent_Desc = null;
			while (rs.next()) 
			{
					advEvent_Id=rs.getString("CODE")==null?"":rs.getString("CODE");
					advEvent_Desc=rs.getString("DESCRIPTION")==null?"":rs.getString("DESCRIPTION");
					out.println( "addAdverseEvents(\""+advEvent_Id+"\",\""+advEvent_Desc+"\",\""+mode+"\");");
					advEvent_Id = null;
					advEvent_Desc = null;
			}
			if (rs!= null) rs.close();
			if (pstmt!= null) pstmt.close();
		
		}else if("AL_A".equals(module_id)){
			mode = (String)hash.get("mode");
			out.println("clearAllergens(\""+mode+"\");");
			sub_code = (String)hash.get("sub_code");
			sql="select allergen_code CODE,short_desc DESCRIPTION from MR_ALLERGEN where adv_event_type_code=? ORDER BY SHORT_DESC";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,sub_code);
			rs = pstmt.executeQuery(); 
			String allergen_Id = null;
			String allergen_Desc = null;
			while (rs.next()) 
			{
					allergen_Id=rs.getString("CODE")==null?"":rs.getString("CODE");
					allergen_Desc=rs.getString("DESCRIPTION")==null?"":rs.getString("DESCRIPTION");
					out.println( "addAllergens(\""+allergen_Id+"\",\""+allergen_Desc+"\",\""+mode+"\");");
					allergen_Id = null;
					allergen_Desc = null;
			}
			if (rs!= null) rs.close();
			if (pstmt!= null) pstmt.close();		
		}else if("AL_Query".equals(module_id)){
			mode = (String)hash.get("mode");
			out.println("clearAdverseEvents(\""+mode+"\");");
			out.println("clearAllergens(\""+mode+"\");");
			
			sub_code = (String)hash.get("sub_code");
			sql="SELECT AL.ALLERGEN_CODE ALCODE,AL.SHORT_DESC ALDESCRIPTION,AE.ADV_EVENT_TYPE_CODE AECODE,AE.SHORT_DESC AEDESCRIPTION FROM MR_ALLERGEN AL,MR_ADV_EVENT_TYPE AE WHERE  AL.ADV_EVENT_TYPE_CODE=AE.ADV_EVENT_TYPE_CODE AND AL.ALLERGEN_CODE=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,sub_code);
			rs = pstmt.executeQuery(); 
			String allergen_Id = null;
			String allergen_Desc = null;
			String advEvent_Id = null;
			String advEvent_Desc = null;
			if (rs.next()) 
			{
					allergen_Id=rs.getString("ALCODE")==null?"":rs.getString("ALCODE");
					allergen_Desc=rs.getString("ALDESCRIPTION")==null?"":rs.getString("ALDESCRIPTION");
					advEvent_Id=rs.getString("AECODE")==null?"":rs.getString("AECODE");
					advEvent_Desc=rs.getString("AEDESCRIPTION")==null?"":rs.getString("AEDESCRIPTION");
					out.println( "addAllergens(\""+allergen_Id+"\",\""+allergen_Desc+"\",\""+mode+"\");");
					out.println( "addAdverseEvents(\""+advEvent_Id+"\",\""+advEvent_Desc+"\",\""+mode+"\");");
				allergen_Id 	= null;
				allergen_Desc 	= null;	
				advEvent_Id = null;
				advEvent_Desc = null;
			}
			if (rs!= null) rs.close();
			if (pstmt!= null) pstmt.close();							
		}else if("CC".equals(module_id)){
			mode = (String)hash.get("mode");			
			sub_code = (String)hash.get("sub_code");
			sql="SELECT COMPLAINT_ID CODE,COMPLAINT_DESC DESCRIPTION FROM CA_CHIEF_COMPLAINT WHERE COMPLAINT_ID=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,sub_code);
			rs = pstmt.executeQuery(); 
			String chiefComplaintId_Id = null;
			String chiefComplaintId_Desc = null;
			if (rs.next()) 
			{
					chiefComplaintId_Id=rs.getString("CODE")==null?"":rs.getString("CODE");
					chiefComplaintId_Desc=rs.getString("DESCRIPTION")==null?"":rs.getString("DESCRIPTION");					
					out.println( "addChiefComplaint(\""+chiefComplaintId_Id+"\",\""+chiefComplaintId_Desc+"\");");
				chiefComplaintId_Id 	= null;
				chiefComplaintId_Desc 	= null;					
			}
			if (rs!= null) rs.close();
			if (pstmt!= null) pstmt.close();							
		}else if("PH".equals(module_id)){
			mode = (String)hash.get("mode");			
			sub_code = (String)hash.get("sub_code");
			sql="SELECT GENERIC_ID CODE,GENERIC_NAME DESCRIPTION FROM PH_GENERIC_NAME_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND GENERIC_ID=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,sub_code);
			rs = pstmt.executeQuery(); 
			String drug_Id = null;
			String drug_Desc = null;
			if (rs.next()) 
			{
					drug_Id=rs.getString("CODE")==null?"":rs.getString("CODE");
					drug_Desc=rs.getString("DESCRIPTION")==null?"":rs.getString("DESCRIPTION");					
					out.println( "setPharmacyDtls(\""+drug_Id+"\",\""+drug_Desc+"\");");
				drug_Id 	= null;
				drug_Desc 	= null;					
			}
			if (rs!= null) rs.close();
			if (pstmt!= null) pstmt.close();							
		}else if("CA".equals(module_id)){
			mode = (String)hash.get("mode");
			sub_code = (String)hash.get("sub_code");
			sub_code1 = (String)hash.get("sub_code1");
			sql = "SELECT RESULT_TYPE FROM AM_DISCR_MSR WHERE  DISCR_MSR_ID=?" ;
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,sub_code);
			rs = pstmt.executeQuery();
			String discr_msr_resultType=null;
			if (rs.next()) 
			{
				discr_msr_resultType = rs.getString("RESULT_TYPE")==null?"":rs.getString("RESULT_TYPE");
				out.println( "addOperatorValue(\""+discr_msr_resultType+"\",\""+sub_code+"\",\""+mode+"\",\""+sub_code1+"\");");
				out.println( "displayLable(\""+discr_msr_resultType+"\",\"dmType\");");
			}
			discr_msr_resultType= null;
		}else if("CA_DMS".equals(module_id)){
			mode = (String)hash.get("mode");
			sub_code = (String)hash.get("sub_code");
			sql = "select dm.discr_msr_id code, dm_l.short_desc description from am_discr_msr dm, am_discr_msr_lang dm_l where dm.discr_msr_id=dm_l.discr_msr_id  and dm_l.language_id=? and dm.discr_msr_id=?" ;
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,sub_code);
			rs = pstmt.executeQuery();
			String discr_msr_id=null;
			String discr_msr_desc=null;
			if (rs.next()) 
			{
				discr_msr_id = rs.getString("code")==null?"":rs.getString("code");
				discr_msr_desc = rs.getString("description")==null?"":rs.getString("description");
				out.println( "getDescripMsrDtls(\""+discr_msr_id+"\",\""+discr_msr_desc+"\");");
				discr_msr_id=null;
				discr_msr_desc=null;
			}
			
		}else if("CA_Dis_Msr_List".equals(module_id)){
			mode = (String)hash.get("mode");
			sub_code = (String)hash.get("sub_code");
			
			sql = "SELECT LI.RESULT_VALUE RESULT_VALUE,LL.REF_RNG_DESC REF_RNG_DESC FROM AM_DISCR_MSR_REF_RNG_LIST LI,AM_DISCR_MSR_REF_RNG_LIST_LANG LL WHERE  LI.DISCR_MSR_ID=LL.DISCR_MSR_ID AND LI.REF_RANGE_SEQ=LL.REF_RANGE_SEQ AND LI.DISCR_MSR_ID=? AND LL.LANGUAGE_ID=? ORDER BY LL.REF_RNG_DESC" ;
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,sub_code);
			pstmt.setString(2,locale);
			rs = pstmt.executeQuery();
			String resText="";
			while (rs.next()) 
			{
				resText = resText+(rs.getString("RESULT_VALUE")==null?"":rs.getString("RESULT_VALUE"))+"|"+(rs.getString("REF_RNG_DESC")==null?"":rs.getString("REF_RNG_DESC"))+"~";
			}
			out.println( resText);
		}else if("LB".equals(module_id)){
			mode = (String)hash.get("mode");
			sub_code = (String)hash.get("sub_code");
			sub_code1 = (String)hash.get("sub_code1");
			sql = "SELECT DECODE(CONTR_MSR_PANEL_ID,NULL,'OR','LB') FACTOR_SET_ID,NVL(CONTR_MSR_PANEL_ID,DISCR_MSR_PANEL_ID) FACTOR_CODE FROM OR_ORDER_CATALOG WHERE  ORDER_CATALOG_CODE =?" ;
			pstmt= con.prepareStatement(sql);			
			pstmt.setString(1,sub_code);
			rs = pstmt.executeQuery();
			String factor_set_id=null;
			String factor_code=null;
			if (rs.next()) 
			{
				factor_set_id = rs.getString("factor_set_id")==null?"":rs.getString("factor_set_id");
				factor_code = rs.getString("FACTOR_CODE")==null?"":rs.getString("FACTOR_CODE");
				out.println( "setfactorSetIdCode(\""+factor_set_id+"\",\""+factor_code+"\");");
				factor_set_id=null;
				factor_code=null;
			}			
		}else if("LB_OCC".equals(module_id)||"OR_OCC".equals(module_id)||"RD_OCC".equals(module_id)){
			mode = (String)hash.get("mode");
			sub_code = (String)hash.get("sub_code");
			sql = "SELECT ORDER_CATALOG_CODE CODE,SHORT_DESC DESCRIPTION FROM OR_ORDER_CATALOG_LANG_VW WHERE ORDER_CATALOG_CODE=ORDER_CATALOG_CODE AND DISCR_MSR_PANEL_ID = ? OR CONTR_MSR_PANEL_ID = ? AND LANGUAGE_ID=?" ;
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,sub_code);
			pstmt.setString(2,sub_code);
			pstmt.setString(3,locale);
			
			rs = pstmt.executeQuery();
			String orderCataLog_code=null;
			String orderCataLog_desc=null;
			if (rs.next()) 
			{
				orderCataLog_code = rs.getString("CODE")==null?"":rs.getString("CODE");
				orderCataLog_desc = rs.getString("DESCRIPTION")==null?"":rs.getString("DESCRIPTION");
				if("LB_OCC".equals(module_id)){
					out.println( "setLBOrderCataLogDtls(\""+orderCataLog_code+"\",\""+orderCataLog_desc+"\");");
				}else if("OR_OCC".equals(module_id)){
					out.println( "setOROrderCataLogDtls(\""+orderCataLog_code+"\",\""+orderCataLog_desc+"\");");
				}else if("RD_OCC".equals(module_id)){
					out.println( "setRDOrderCataLogDtls(\""+orderCataLog_code+"\",\""+orderCataLog_desc+"\");");
				}
				orderCataLog_code=null;
				orderCataLog_desc=null;
			}
			
		}else if("OR".equals(module_id)){
			mode = (String)hash.get("mode");
			sub_code = (String)hash.get("sub_code");
			sql = "SELECT 'OR' FACTOR_SET_ID,DISCR_MSR_PANEL_ID FACTOR_CODE FROM OR_ORDER_CATALOG WHERE  ORDER_CATALOG_CODE =?" ;
			pstmt= con.prepareStatement(sql);			
			pstmt.setString(1,sub_code);
			rs = pstmt.executeQuery();
			String factor_set_id=null;
			String factor_code=null;
			if (rs.next()) 
			{
				factor_set_id = rs.getString("factor_set_id")==null?"":rs.getString("factor_set_id");
				factor_code = rs.getString("FACTOR_CODE")==null?"":rs.getString("FACTOR_CODE");
				out.println( "setfactorSetIdCode(\""+factor_set_id+"\",\""+factor_code+"\");");
				factor_set_id=null;
				factor_code=null;
			}			
		}else if("RD".equals(module_id)){
			mode = (String)hash.get("mode");
			sub_code = (String)hash.get("sub_code");
			sub_code1 = (String)hash.get("sub_code1");
			sql = "SELECT DECODE(CONTR_MSR_PANEL_ID,NULL,'OR','RD') FACTOR_SET_ID,NVL(CONTR_MSR_PANEL_ID,DISCR_MSR_PANEL_ID) FACTOR_CODE FROM OR_ORDER_CATALOG WHERE  ORDER_CATALOG_CODE =?" ;
			pstmt= con.prepareStatement(sql);			
			pstmt.setString(1,sub_code);
			rs = pstmt.executeQuery();
			String factor_set_id=null;
			String factor_code=null;
			if (rs.next()) 
			{
				factor_set_id = rs.getString("factor_set_id")==null?"":rs.getString("factor_set_id");
				factor_code = rs.getString("FACTOR_CODE")==null?"":rs.getString("FACTOR_CODE");
				out.println( "setfactorSetIdCode(\""+factor_set_id+"\",\""+factor_code+"\");");
				factor_set_id=null;
				factor_code=null;
			}			
		}else if("TS".equals(module_id)){
			sub_code = (String)hash.get("sub_code");
			sub_code1 = (String)hash.get("sub_code1");
			sql = "SELECT A.TERM_CODE CODE,A.SHORT_DESC DESCRIPTION FROM MR_D_"+sub_code1+"_LANG_VW A WHERE A.TERM_CODE = UPPER(?) AND A.TERM_SET_ID=? AND A.LANGUAGE_ID=? " ;
			pstmt= con.prepareStatement(sql);			
			pstmt.setString(1,sub_code);
			pstmt.setString(2,sub_code1);
			pstmt.setString(3,locale);
			rs = pstmt.executeQuery();
			String term_code=null;
			String term_desc=null;
			if (rs.next()) 
			{
				term_code = rs.getString("CODE")==null?"":rs.getString("CODE");
				term_desc = rs.getString("DESCRIPTION")==null?"":rs.getString("DESCRIPTION");
				out.println( "setTermCodeDesc(\""+term_code+"\",\""+term_desc+"\");");
				
				term_code=null;
				term_desc=null;
			}			
		}else if("BM".equals(module_id)){
			mode = (String)hash.get("mode");
			sub_code = (String)hash.get("sub_code");
			sub_code1 = (String)hash.get("sub_code1");
			sql = "select dm.discr_msr_id code, dm_l.short_desc description from am_discr_msr dm, am_discr_msr_lang dm_l where dm.discr_msr_id=dm_l.discr_msr_id  and dm_l.language_id=? and dm.discr_msr_id=?" ;
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,sub_code);
			rs = pstmt.executeQuery();
			String discr_msr_id=null;
			String discr_msr_desc=null;
			if (rs.next()) 
			{
				discr_msr_id = rs.getString("code")==null?"":rs.getString("code");
				discr_msr_desc = rs.getString("description")==null?"":rs.getString("description");
				if("WEIGHT".equals(sub_code1)){
					out.println( "setBMIWeightDtls(\""+discr_msr_id+"\",\""+discr_msr_desc+"\");");
				}else if("HEIGHT".equals(sub_code1)){
					out.println( "setBMIHeightDtls(\""+discr_msr_id+"\",\""+discr_msr_desc+"\");");
				}
				discr_msr_id=null;
				discr_msr_desc=null;
			}
			
		}
	}
}catch(Exception e)
{
	e.printStackTrace() ;
}finally{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 

%>

