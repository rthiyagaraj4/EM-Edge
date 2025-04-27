
<%@page import="java.sql.*,java.util.*, eCA.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	
	StringTokenizer rowTok = null;
	StringTokenizer rowTok1 = null;
//	StringTokenizer colTok = null;
	String arrVal ="";
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
	String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
	
	if(operation_mode.equals("addToBean"))
	{
		
		eCA.PatientBannerGroupLine queryTemplateBean = null;

//		String hashKey ="";
//		String hashValue ="";
		
		queryTemplateBean = (eCA.PatientBannerGroupLine)getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		String final_string = request.getParameter("final_string")==null?"":request.getParameter("final_string");
		String rem_string = request.getParameter("rem_string")==null?"":request.getParameter("rem_string");

		try{
		rowTok = new StringTokenizer(final_string,"`");

		while(rowTok.hasMoreTokens())
		{
			arrVal = (String) rowTok.nextToken();

			if(!queryTemplateBean.returnList1().contains(arrVal))
			{
				queryTemplateBean.addRecordstoLine1(arrVal);
			}
			
		}
		rowTok1 = new StringTokenizer(rem_string,"`");

		while(rowTok1.hasMoreTokens())
		{
			arrVal = (String) rowTok1.nextToken();

			if((queryTemplateBean.returnList1().contains(arrVal)))
			{
				queryTemplateBean.remRecordsFromLine1(arrVal);
			}
		}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}


		putObjectInBean("queryTemplateBean"+bean_key,queryTemplateBean,session);

	}
	else if(operation_mode.equals("loadToBean"))
	{
		
		eCA.PatientBannerGroupLine queryTemplateBean = null;

//		String hashKey ="";
//		String hashValue ="";
		String sec_hdg_code ="";
		String comp_id ="";
		String srl_no ="";
		String prompt_id ="";
		String result_type ="";
		int count=0;

		arrVal ="";
		
		queryTemplateBean = (eCA.PatientBannerGroupLine)getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		String query_id = request.getParameter("query_id")==null?"":request.getParameter("query_id");
		String temp_det =" select SEC_HDG_CODE,COMP_ID,SRL_NO,PROMPT_ID,RESULT_TYPE from CA_TEMP_QRY_DTL  where QUERY_REF =? ";

		try
		{

			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(temp_det);
			stmt.setString(1,query_id);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				sec_hdg_code = rs.getString("SEC_HDG_CODE")==null?"":rs.getString("SEC_HDG_CODE");	
				comp_id = rs.getString("COMP_ID")==null?"":rs.getString("COMP_ID");	
				srl_no = rs.getString("SRL_NO")==null?"":rs.getString("SRL_NO");	
				prompt_id = rs.getString("PROMPT_ID")==null?"":rs.getString("PROMPT_ID");	
				result_type = rs.getString("RESULT_TYPE")==null?"":rs.getString("RESULT_TYPE");	
	
				arrVal = sec_hdg_code+"~"+comp_id+"~"+srl_no+"~"+prompt_id+"~"+result_type;	

				if(!queryTemplateBean.returnList1().contains(arrVal))
				{
					queryTemplateBean.addRecordstoLine1(arrVal);
				}
				count++;
			
			}
		
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}

		out.println("parent.QueryTemplateHeader.queryTemplateHdrForm.global_sel_count.value='"+count+"'");

		putObjectInBean("queryTemplateBean"+bean_key,queryTemplateBean,session);


	}
	else if(operation_mode.equals("remove"))
	{
		
		arrVal ="";

		String mode = "";

		eCA.PatientBannerGroupLine queryTemplateBean = null;
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		arrVal = request.getParameter("arrVal")==null?"":request.getParameter("arrVal");

		queryTemplateBean = (eCA.PatientBannerGroupLine)getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		if(mode.equals("Add"))
		{
			
			if(!queryTemplateBean.returnList1().contains(arrVal))
				{
					queryTemplateBean.addRecordstoLine1(arrVal);
				}
		}
		else if (mode.equals("Rem"))
		{
			if((queryTemplateBean.returnList1().contains(arrVal)))
			{
				queryTemplateBean.remRecordsFromLine1(arrVal);
			}

		}


		putObjectInBean("queryTemplateBean"+bean_key,queryTemplateBean,session);	

	}
	else if(operation_mode.equals("clearBean"))
	{
		
		
		eCA.PatientBannerGroupLine queryTemplateBean = null;
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		
		queryTemplateBean = (eCA.PatientBannerGroupLine)getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);
		queryTemplateBean.clearBean();
				

		putObjectInBean("queryTemplateBean"+bean_key,queryTemplateBean,session);	

	}




%>
