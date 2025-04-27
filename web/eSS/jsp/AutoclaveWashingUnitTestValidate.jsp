 
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*

--------------------------------------------------------------------------------------------------------------------
Date       Edit History     Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
25/11/2014	IN052312		Karthi L						Ramesh			Autoclaving Unit Test Entry
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="alAutoclaveWashingUnitTestList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
   	String bean_id								=	"autoclaveWashingUnitTestListBean" ;
	String bean_name							=	"eSS.AutoclaveWashingUnitTestListBean";
	AutoclaveWashingUnitTestListBean bean		= (AutoclaveWashingUnitTestListBean) getBeanObject(bean_id, bean_name, request) ;  
	String autoclave_wash_unit_code				=	request.getParameter("autoclave_wash_unit_code");
	String validate								=	request.getParameter("validate");

	String test_code							=	request.getParameter("test_code");
	String batch_id								=	request.getParameter("batch_id"); ;
	String test_result							=	request.getParameter("test_result");
	String result_date							=	request.getParameter("result_date"); 
	String unit_type							=	request.getParameter("unit_type"); 
	String result_remarks						=	request.getParameter("result_remarks"); 

	String index								=	request.getParameter("index");
	// added for AAKH-CRF-0057 - IN052312 - Start
	String room_temp							=	request.getParameter("room_temp");
	String relative_humidity					=	request.getParameter("relative_humidity");
	String biologic_indicator					=	request.getParameter("biologic_indicator");
	String bms_pass_fail						=	request.getParameter("bms_pass_fail");
	// added for AAKH-CRF-0057 - IN052312 - End
	String message								=	"";
	String flag									=	"";
	boolean	result								=	false;

	try{
		if (validate.equals("ADD_TO_LIST")){
			HashMap hmListItems	=	new HashMap();
			bean.setUnit_type(unit_type);
		if(bean.isTestCodeInArrayList(alAutoclaveWashingUnitTestList,test_code,autoclave_wash_unit_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			hmListItems.put("test_code",		test_code		);
			hmListItems.put("batch_id",		batch_id );
			hmListItems.put("test_result",				test_result		);
			hmListItems.put("result_date",				result_date );
			hmListItems.put("result_remarks",				result_remarks		);
			hmListItems.put("unit_type",				unit_type		);
			// added for AAKH-CRF-0057 - IN052312 - Start
			hmListItems.put("room_temp",		room_temp		);
			hmListItems.put("relative_humidity",		relative_humidity		);
			hmListItems.put("biologic_indicator",		biologic_indicator		);
			hmListItems.put("bms_pass_fail",		bms_pass_fail		);
			// added for AAKH-CRF-0057 - IN052312 - End
			if(index.equals("-1")){
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alAutoclaveWashingUnitTestList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alAutoclaveWashingUnitTestList.get(Integer.parseInt(index))).get("mode"));
				alAutoclaveWashingUnitTestList.set(Integer.parseInt(index),hmListItems);
			}
			result	=	true;
			message	=	"Done";
		}
		else if(validate.equals("LOAD_BMS_BIO_CODE")){
			String bio_bms_codes = bean.getBioBmsApplicableCodes(test_code);
			out.println( "addBmsBiologicalCodes(\"" + bio_bms_codes + "\");" ) ;
		}
		//Ramesh Start.
		else if(validate.equals("CLEAR_LIST")){
			alAutoclaveWashingUnitTestList.clear();
		}
		//Ramesh End.
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		putObjectInBean(bean_id,bean,request);
	}
%>
