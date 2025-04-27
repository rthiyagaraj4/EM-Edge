<!DOCTYPE html>
<!--
	
	Created on 		:	19/02/2005
	Module				:	eAM - Deficiency
	FileName		    :	TransportModeQueryCriteria.jsp	
	Function		:	This function is used to load query criteria screen for the function
-->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	Boolean isCnrmReqPatOutChngAppl = false;//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

	//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
	Boolean isMedRepModeAppl = false;

	try 
	{

		con = ConnectionManager.getConnection(request);
	
		isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

		isMedRepModeAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CHCKLST_TRANS_MODE_MED_REPORT"); //Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
		
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  				// Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransportMode.label","common_labels"));		// label
		firstItem.add("transport_mode");		// name of field
		firstItem.add("10");						// SIZE
		firstItem.add("10");						// LENGTH
		finAr.add(firstItem);					// add to ArrayList obj finAr

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");					// Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransportMode.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));		// label
		secondItem.add("long_desc");			// name of field
		secondItem.add("30");					// SIZE
		secondItem.add("30");					// LENGTH
		finAr.add(secondItem);					// add to ArrayList obj finAr
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");					// Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.PatientRelated.label","am_labels"));		// label
		thirdItem.add("patient_related_yn");			// name
		thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");
		finAr.add(thirdItem);

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("List");					// Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FileRelated.label","am_labels"));		// label
		fourthItem.add("file_related_yn");			// name
		fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");
		finAr.add(fourthItem); 
		
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("List");					// Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.SpecimenRelated.label","am_labels"));		// label
		fifthItem.add("specimen_related_yn");			// name
		fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");
		finAr.add(fifthItem); 

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");					// Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ByPerson.label","am_labels"));				// label
		sixthItem.add("by_person_yn");			// name
		sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(sixthItem); //add to ArrayList obj finAr

		/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start*/
		ArrayList seventhItem=new ArrayList();
		if(isCnrmReqPatOutChngAppl){	
			seventhItem.add("List");					// Type of item
			seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.TfrPatientOut.label","am_labels"));				// label
			seventhItem.add("tfr_pat_out_yn");			// name
			seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(seventhItem); //add to ArrayList obj finAr
		}/*End*/

		/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
		ArrayList ninthItem=new ArrayList();
		if(isMedRepModeAppl){	
			ninthItem.add("List");					// Type of item
			ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicationMode.label","common_labels"));				// label
			ninthItem.add("application_mode");			// name
			ninthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(ninthItem); //add to ArrayList obj finAr
		}

		ArrayList tenthItem=new ArrayList();
		if(isMedRepModeAppl){	
			tenthItem.add("List");					// Type of item
			tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CollectionMode.label","common_labels"));				// label
			tenthItem.add("collection_mode");			// name
			tenthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(tenthItem); //add to ArrayList obj finAr
		}

		ArrayList eleventhItem=new ArrayList();
		if(isMedRepModeAppl){	
			eleventhItem.add("List");					// Type of item
			eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NotificationMode.label","common_labels"));				// label
			eleventhItem.add("notification_mode");			// name
			eleventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(eleventhItem); //add to ArrayList obj finAr
		}/*ML-MMOH-CRF-0708 End*/
			
		ArrayList eighthItem=new ArrayList();
		eighthItem.add("List");					// Type of item
		eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));				// label
		eighthItem.add("eff_status");			// name
		eighthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(eighthItem); //add to ArrayList obj finAr

		
		

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[7];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransportMode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransportMode.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

		orderByColVals[0] = "transport_mode";
		orderByColVals[1] = "long_desc";
		orderByColVals[2] = "patient_related_yn";
		orderByColVals[3] = "file_related_yn";
		orderByColVals[4] = "specimen_related_yn";
		orderByColVals[5] = "by_person_yn";
		orderByColVals[6] = "eff_status";

		strbuff = qrypg.getQueryPage(con,finAr,"File Transport Mode","../jsp/TransportModeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
		out.println(strbuff.toString());
		
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		
		/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617*/
		if(isCnrmReqPatOutChngAppl)
			seventhItem.clear();
		eighthItem.clear();
		/*End*/

		/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
		if(isMedRepModeAppl)
		{
			ninthItem.clear();
			tenthItem.clear();
			eleventhItem.clear();
		}
		/*ML-MMOH-CRF-0708 End*/

		finAr.clear();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
%>
