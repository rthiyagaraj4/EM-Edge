<!DOCTYPE html>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="eBL.BLInsuranceImageBean"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
BLInsuranceImageBean blInsuranceImageBean 		= 	null;
String bean_id							= 	"bl_blinsuranceimagebean" ;
String bean_name						= 	"eBL.BLInsuranceImageBean";
blInsuranceImageBean					= 	(eBL.BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
blInsuranceImageBean.clearBean();

String pol_bean_id		= "PayerPolicyInsuranceMasterBean" ;
String pol_bean_name	= "eBL.PolicyInsuranceMasterBean";
PolicyInsuranceMasterBean pol_bean			= (PolicyInsuranceMasterBean)getBeanObject( pol_bean_id, pol_bean_name, request ) ;
if(pol_bean!=null)
pol_bean.clearAll();
cleanBeanObject(pol_bean_id, pol_bean_name, request);

String enc_pol_bean_id		= "EncPolicyInsuranceMasterBean" ;
String enc_pol_bean_name	= "eBL.PolicyInsuranceMasterBean";							
PolicyInsuranceMasterBean enc_pol_bean		= 	(PolicyInsuranceMasterBean)getBeanObject( enc_pol_bean_id, enc_pol_bean_name, request ) ;
if(enc_pol_bean!=null)
enc_pol_bean.clearAll();
cleanBeanObject(enc_pol_bean_id, enc_pol_bean_name, request );

session.setAttribute("VALID_ACROSS_ENCOUNTER_MAP",null);						
session.setAttribute("ENCOUNTER_POLICY_RECORD_ELEMENTS",null);
session.setAttribute("blGetDfltEncBg", null);
session.setAttribute("blGetDfltEncCC", null);
session.removeAttribute("BL_DEFAULT_LOADED_BLNG_GROUP_INFO");		/* MMS-SCF-0355 - Added by Karthikeyan on 26/05/2014 */
session.setAttribute("CLAIM_CREDIT_MAP_SESSION",null); //IN50355
%>
