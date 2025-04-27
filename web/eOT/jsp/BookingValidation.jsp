<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page   import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.CallableStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.sql.Types,eOT.*,java.util.*" %>

<%@include file="../../eCommon/jsp/Common.jsp" %>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends
String locale = ((String)session.getAttribute("LOCALE"));
Properties p= (Properties)session.getValue("jdbc");
String client_ip_address=""+p.getProperty("client_ip_address");
String user_id = (String)session.getValue("login_user");
String mode="",anaestheticcode="",saveanaes="",stages="",currstage="",reason_code1="",reasoncodeflag="";
String booking_no=CommonBean.checkForNull(request.getParameter("booking_no"));
String facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
String patient_id=CommonBean.checkForNull(request.getParameter("patient_id"));
String orderid=CommonBean.checkForNull(request.getParameter("orderid")); mode=CommonBean.checkForNull(request.getParameter("mode"));
anaestheticcode=CommonBean.checkForNull(request.getParameter("anaestheticcode"));
saveanaes=CommonBean.checkForNull(request.getParameter("saveanaes"));
currstage=CommonBean.checkForNull(request.getParameter("currstage"));
stages=CommonBean.checkForNull(request.getParameter("stages"));
reason_code1=CommonBean.checkForNull(request.getParameter("reason_code1"));
reasoncodeflag=CommonBean.checkForNull(request.getParameter("reasoncodeflag"));
String p_new_episode_type="",p_new_episode_id="",p_new_encounter_id="",p_new_patient_class="",p_status="",p_msg_txt="",p_alert_status="",post_stage_desc="",stage_code="",strNextStageCode="",strNextSpecificInd="",strNextActionDone="",strNextStageDesc="",p_langerr_msg_txt = "";

Connection con = null;
CallableStatement cstmt = null;
PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
ResultSet resultset =null;
ResultSet resultset1 =null;
try{
	con = ConnectionManager.getConnection(request);
	int index = 0;
	if(reasoncodeflag.equals(""))
	{
	if(stages.equals(""))
	{
	if(anaestheticcode.equals(""))
	{
		if(mode.equals(""))
	{
		
		cstmt=con.prepareCall("{call OT_CHK_EPISODE_VALIDITY(?,?,?,?,?,?,?,?,?,?,null,null,null,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(++index,facility_id);					//1	
		cstmt.setString(++index,patient_id);					//2
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//3
		cstmt.registerOutParameter(++index,Types.INTEGER);		//4
		cstmt.registerOutParameter(++index,Types.INTEGER);		//5
		cstmt.registerOutParameter(++index,Types.INTEGER);		//6
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//7
		cstmt.setString(++index,booking_no);					//8
		cstmt.setString(++index,"Y");							//9
		cstmt.setString(++index,orderid);						//10
		cstmt.setString(++index,user_id);						//11
		cstmt.setString(++index,client_ip_address);				//12
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//P_NEW_EPISODE_TYPE   	13
		cstmt.registerOutParameter(++index,Types.INTEGER);		//P_NEW_EPISODE_ID     	14
		cstmt.registerOutParameter(++index,Types.INTEGER);		//P_NEW_ENCOUNTER_ID   	15
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//P_NEW_PATIENT_CLASS  	16
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//P_STATUS    		17
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//P_ALERT_STATUS	18	
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//P_MSG_TXT			19
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//P_LANGERR_MSG_TXT	20		
		cstmt.execute();										   		
		p_new_episode_type=cstmt.getString(13);
		p_new_episode_id =cstmt.getString(14);
		p_new_encounter_id=cstmt.getString(15);
		p_new_patient_class=cstmt.getString(16);
		p_status =CommonBean.checkForNull(cstmt.getString(17));
		p_alert_status =CommonBean.checkForNull(cstmt.getString(18));
		p_msg_txt=CommonBean.checkForNull(cstmt.getString(19));
		p_langerr_msg_txt=CommonBean.checkForNull(cstmt.getString(20));
		session.setAttribute("enc_id",p_new_encounter_id);
	    out.println(p_status+"##"+p_alert_status+"##"+p_msg_txt+"##"+p_langerr_msg_txt+"##"+p_new_encounter_id);
	
	}
	else
	{

		cstmt=con.prepareCall("{call OT_CHK_EPISODE_VALIDITY(?,?,?,?,?,?,?,?,?,?,null,null,null,?,?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(++index,facility_id);					//1
		cstmt.setString(++index,patient_id);					//2
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//3
		cstmt.registerOutParameter(++index,Types.INTEGER);		//4
		cstmt.registerOutParameter(++index,Types.INTEGER);		//5
		cstmt.registerOutParameter(++index,Types.INTEGER);		//6
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//7
		cstmt.setString(++index,booking_no);					//8
		cstmt.setString(++index,"N");							//9
		cstmt.setString(++index,orderid);						//10
		cstmt.setString(++index,user_id);						//11
		cstmt.setString(++index,client_ip_address);				//12
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//13
		cstmt.registerOutParameter(++index,Types.INTEGER);		//14
		cstmt.registerOutParameter(++index,Types.INTEGER);		//15
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//16
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//17
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//18
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//19
		cstmt.registerOutParameter(++index,Types.VARCHAR);		//20
		cstmt.execute();
		p_new_episode_type=cstmt.getString(13);
		p_new_episode_id =cstmt.getString(14);
		p_new_encounter_id=cstmt.getString(15);
		p_new_patient_class=cstmt.getString(16);
		p_status =CommonBean.checkForNull(cstmt.getString(17));
		p_alert_status =CommonBean.checkForNull(cstmt.getString(18));
		p_msg_txt=CommonBean.checkForNull(cstmt.getString(19));
		p_langerr_msg_txt=CommonBean.checkForNull(cstmt.getString(20));
		out.println(p_status+"##"+p_alert_status+"##"+p_msg_txt+"##"+p_langerr_msg_txt+"##"+p_new_encounter_id);
	}
	}
	else
	{
		String sql1="UPDATE OT_BOOKING_HDR SET ANAESTHETIST1_CODE = '"+anaestheticcode+"' WHERE OPERATING_FACILITY_ID = '"+facility_id+"'  AND BOOKING_NUM = '"+booking_no+"' ";
	pstmt=con.prepareCall(sql1);
		/*		pstmt.setString(1,anaestheticcode);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,booking_no);*/
		int result=	pstmt.executeUpdate();
	
		if(result>0)
		{
				con.commit();
				out.println("Updated Successfully");
		}else
		{
			con.rollback();
		}
	}
}
else if(stages.equals("YES"))
{
	String sqlstage="SELECT POST_STAGE_DESC, STAGE_CODE FROM OT_BOOKING_FIN_STAGES_LANG_VW WHERE SERIAL_NO >      (SELECT SERIAL_NO FROM OT_BOOKING_FIN_STAGES WHERE STAGE_CODE = '"+currstage+"') AND LANGUAGE_ID='"+locale+"'  ORDER BY SERIAL_NO";

		pstmt=con.prepareStatement(sqlstage);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			post_stage_desc += resultset.getString("POST_STAGE_DESC")+"#";
			stage_code += resultset.getString("STAGE_CODE")+"::";
		}
		out.println(post_stage_desc+"##"+stage_code);
}
else if(stages.equals("NO"))
{
		String sqlstage1="SELECT STAGE_CODE, SPECIFIC_IND,ACTION_IF_NOT_DONE,PRE_STAGE_DESC  FROM OT_BOOKING_FIN_STAGES_LANG_VW WHERE SERIAL_NO = (SELECT MIN(SERIAL_NO) FROM OT_BOOKING_FIN_STAGES WHERE SERIAL_NO > '"+currstage+"') AND LANGUAGE_ID= ? ";

		pstmt=con.prepareStatement(sqlstage1);
		pstmt.setString(1,locale);
			resultset=pstmt.executeQuery();
			while(resultset.next()){
			strNextStageCode=CommonBean.checkForNull(resultset.getString("STAGE_CODE"));
			strNextSpecificInd=CommonBean.checkForNull(resultset.getString("SPECIFIC_IND"));
			strNextActionDone=CommonBean.checkForNull(resultset.getString("ACTION_IF_NOT_DONE"));
			strNextStageDesc=CommonBean.checkForNull(resultset.getString("PRE_STAGE_DESC"));	
			}
		String strUserPrevilage="N";
		if(strNextSpecificInd.equals("SPC")==true){
			String sql4="SELECT 'X'   FROM OT_BOOKING_FIN_STAGES_DTL WHERE STAGE_CODE = ? AND FACILITY_ID= ?  AND APPL_USER_ID ='"+user_id+"'"; 
			pstmt1=con.prepareStatement(sql4);
			pstmt1.setString(1,strNextStageCode);
			pstmt1.setString(2,facility_id);
			resultset1=pstmt1.executeQuery();
			if(resultset1!=null){
				while (resultset1.next()){			 
					strUserPrevilage="Y";
				}	
				resultset1.close();
		}
	}
			out.println(strNextStageCode+"##"+strNextSpecificInd+"##"+strNextActionDone+"##"+strNextStageDesc+"##"+strUserPrevilage);
  }
}
else
{

	String sqlstage1="SELECT REASON_CODE,REASON_DESC  FROM OT_REASONS_LANG_VW WHERE REASON_DESC = '"+reason_code1+"'  AND LANGUAGE_ID='"+locale+"' ";

	pstmt=con.prepareStatement(sqlstage1);
	resultset=pstmt.executeQuery();
	while(resultset.next()){
		post_stage_desc = resultset.getString("REASON_CODE");
		stage_code = resultset.getString("REASON_DESC");
	}
	out.println(post_stage_desc+"##"+stage_code);

}
}catch(Exception e){
		 System.err.println("Err in booking validation.jsp"+e.getMessage());
		 e.printStackTrace();
	}finally{
		
		if(pstmt!=null) pstmt.close();		
		if(cstmt!=null) cstmt.close();		
		if(resultset!=null) resultset.close();
		ConnectionManager.returnConnection(con,request);
	}

%>
