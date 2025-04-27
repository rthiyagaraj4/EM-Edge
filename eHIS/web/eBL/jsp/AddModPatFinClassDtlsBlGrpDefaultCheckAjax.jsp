<!DOCTYPE html>
<!-- 
Sr No        Version           Incident			SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V210413			17021        Common-ICN-0009-TF         MuthukumarN
-----------------------------------------------------------------------------------
-->

<%@ page language="java" import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*, java.text.SimpleDateFormat,eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="org.json.simple.JSONObject"%>    

<%
	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties) httpSession.getValue("jdbc"); //V210413
	Connection con = con=ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String defBlngGrpId="";
	JSONObject obj=new JSONObject();
	try{
			String facilityId=request.getParameter("facilityId");
			String classCode=request.getParameter("classCode");
			String incAssetInd = request.getParameter("incAssetInd");
			String InclFamilyYN=request.getParameter("InclFamilyYN");
			String totIncAsset=request.getParameter("totIncAsset");
			String totIncAssetParsed=request.getParameter("totIncAssetParsed");
			String strModuleId=request.getParameter("strModuleId");

			System.err.println("facilityId::"+facilityId+"/"+"classCode::"+classCode+"/"+"incAssetInd::"+incAssetInd+"/"+"InclFamilyYN::"+InclFamilyYN+"/"+"totIncAsset::"+totIncAsset+"/"+"totIncAssetParsed::"+totIncAssetParsed+"/"+strModuleId+"/"+strModuleId);	

			String sqlDefBlGrp = 	BlRepository.getBlKeyValue("DFLT_BILLING_GRP");
			String sqlDefBlGrpIP = 	BlRepository.getBlKeyValue("DFLT_BILLING_GRP_IP");
			
			if("IP".equalsIgnoreCase(strModuleId)){
			sqlDefBlGrp=sqlDefBlGrp+sqlDefBlGrpIP;
			}
			System.err.println("sqlDefBlGrp "+sqlDefBlGrp);
		
		 try {
				pstmt=con.prepareStatement(sqlDefBlGrp);				
				pstmt.setString(1,facilityId);
				pstmt.setString(2,classCode);
				pstmt.setString(3,incAssetInd);
				pstmt.setString(4,InclFamilyYN);
				pstmt.setString(5,totIncAsset);
				pstmt.setString(6,totIncAssetParsed);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					defBlngGrpId =rs.getString(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("defBlngGrpId" + e);
			} 
		obj.put("defBlngGrpId",defBlngGrpId);
		System.err.println("defBlngGrpId=frm back end=="+defBlngGrpId);
		out.println(obj);		
	}
	catch(Exception ee){	
		ee.printStackTrace();
		System.err.println("PkgDefIncludeHomeMedicationAjax : " + ee);
	}
	finally{
		ConnectionManager.returnConnection(con);
		//V210413 start
		//pstmt = null;
		//rs = null;
		pstmt.close();
		rs.close();		
		//V210413 end			
	}
%>
