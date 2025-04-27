<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con = null;

	try 
	{
		con = ConnectionManager.getConnection(request); ;
	
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels"));	   //label
		firstItem.add("APPL_USER_ID");	//name of field
		firstItem.add("30");	// SIZE
		firstItem.add("30");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");  		// Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels"));	   //label
		secondItem.add("APPL_USER_NAME");	//name of field
		secondItem.add("30");	 //SIZE
		secondItem.add("30");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");  		// Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationCode.label","fm_labels"));	   //label
		thirdItem.add("FS_LOCN_CODE");	//name of field
		thirdItem.add("8");	 //SIZE
		thirdItem.add("8");	//LENGTH

		finAr.add(thirdItem);//add to ArrayList obj finAr

		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");  		// Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileStorageLocationDesc.label","fm_labels"));	   //label
		fourthItem.add("FS_LOCN_DESC");	//name of field
		fourthItem.add("30");	 //SIZE
		fourthItem.add("30");	//LENGTH

		finAr.add(fourthItem);//add to ArrayList obj finAr

		ArrayList fifthItem=new ArrayList();

		fifthItem.add("List");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationIdentity.label","fm_labels"));  /// label
		fifthItem.add("LOCN_IDENTITY_DESC");  // name of field
		fifthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"));//static values that need to be displayed as 

		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthItem=new ArrayList();

		sixthItem.add("List");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AccessRights.label","common_labels"));  /// label
		sixthItem.add("ACCESS_RIGHTS");  // name of field
		sixthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.AssignFSLocation.label","fm_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelRequest.label","common_labels")+",Q,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.CreateFileVolume.label","fm_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ChangeFSLocation.label","fm_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ChangeFileReturnDate.label","fm_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ChangeFileStatus.label","fm_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ConfirmReceipt.label","fm_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.IssueFileWithinFacility.label","fm_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.IssueFileToOtherFacilities.label","fm_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ManualRequestYN.label","fm_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.MonitorDeficiency.label","fm_labels")+",H,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ReceiveFile.label","fm_labels")+",K,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.RequestFileWithinFacility.label","fm_labels")+",L,"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.RequestFileFromOtherFacilities.label","fm_labels")+",G,"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.TrackoutfilestoOPD.label","fm_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.TrackoutfilestoIPW.label","fm_labels")+",J,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.TransferFileoutsideMRD.label","fm_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ReturnFile.label","fm_labels"));

		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[6];
		String orderByColVals[] = new String[6];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationCode.label","fm_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileStorageLocationDesc.label","fm_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FSLocationIdentity.label","fm_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AccessRights.label","common_labels");

		orderByColVals[0] = "APPL_USER_ID";
		orderByColVals[1] = "APPL_USER_NAME";
		orderByColVals[2] = "FS_LOCN_CODE";
		orderByColVals[3] = "FS_LOCN_DESC";
		orderByColVals[4] = "LOCN_IDENTITY_DESC";
		orderByColVals[5] = "APPL_USER_ID";

		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.Narration.label","fm_labels"),"../../eFM/jsp/FMUserAccessQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear(); 
		firstItem.clear(); 
		secondItem.clear(); 
		thirdItem.clear(); 
		fourthItem.clear(); 
		fifthItem.clear(); 
		sixthItem.clear();
	}
	catch(Exception e) 
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
