<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eDS.Common.JSONObject" %>

<%  
	request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	CallableStatement billingCS = null;
	try{
		/*out.println("facility_id==> "+request.getParameter("facility_id"));
		out.println("p_patient_id==> "+request.getParameter("p_patient_id"));
		out.println("p_episode_type==> "+request.getParameter("p_episode_type"));
		out.println("p_episode_id==> "+request.getParameter("p_episode_id"));
		out.println("p_visit_id==> "+request.getParameter("p_visit_id"));*/
		String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String p_patient_id		= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
		String p_episode_type	= request.getParameter("p_episode_type")==null?"":request.getParameter("p_episode_type");
		int p_episode_id		= Integer.parseInt(request.getParameter("p_episode_id"));
		int p_visit_id			= Integer.parseInt(request.getParameter("p_visit_id"));
		int IsResult			= 0;
		JSONObject json			= new JSONObject();

		
		
		conn=ConnectionManager.getConnection(request);
		String billingSql =  "{call blcommonproc.get_unbilled_unsettled_amt(?,?,?,?,?,?,?)}";
		billingCS = conn.prepareCall(billingSql);
		billingCS.setString(1, facility_id);
		billingCS.setString(2, p_patient_id);
		billingCS.setString(3, p_episode_type);
		billingCS.setInt(4, p_episode_id);
		billingCS.setInt(5, p_visit_id);
		billingCS.registerOutParameter( 6,java.sql.Types.INTEGER);
		billingCS.registerOutParameter( 7,java.sql.Types.INTEGER);
		 try{
				billingCS.execute();
				int p_unbilled_amt 	= billingCS.getInt(6);
				int p_unsettled_amt	= billingCS.getInt(7);
				IsResult		= 1;
				json.put("p_unbilled_amt", p_unbilled_amt);
				json.put("p_unsettled_amt", p_unsettled_amt);
			} catch(Exception e1) {
				e1.printStackTrace();
			} finally{billingCS.close();}
		 
		 json.put("IsResult", IsResult);
		 out.print(json);
	
	}catch(Exception e) { 
		e.printStackTrace();
		
	}finally{ 
		try{
			if(billingCS != null) billingCS.close();
		}catch(Exception e){
		e.printStackTrace();}
		if(conn!=null)
			ConnectionManager.returnConnection(conn,request);
	}                           
%>          
            
            
