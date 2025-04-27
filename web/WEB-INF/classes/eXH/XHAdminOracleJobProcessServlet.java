/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
//import com.ehis.util.*;
/*
import com.ehis.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;																			 
import com.ehis.util.*;
*/

/**
 *  The XHAdminOracleJobProcessServlet class used to  iAdminister oracle job process 
 *
 */
public class XHAdminOracleJobProcessServlet extends HttpServlet	
{
	
	
	/**
	 * Do get method which handles the internal oracle job submisson 
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{

		  String functionID = request.getParameter("functionID") ;	 

	//	  System.out.println(" XHAdminOracleJobProcessServlet.java : "+functionID);
		HttpSession session=request.getSession(false);											  
		String status = process(request,response,session);
		RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/JobDisplayResult.jsp?message="+status+"&functionID="+functionID);			 
        reqDis.forward(request,response);	

	}

    /**
	 * Do operate method is used to submit the oracle internal jobs
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @param  HttpSession session
	 */
	
	public String  process(HttpServletRequest request, HttpServletResponse response,HttpSession session)
	{

  	    Connection con=ConnectionManager.getConnection();
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
        String locale  = p.getProperty("LOCALE");
				
        try{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		}catch(Exception ex){}
		CallableStatement cstmt1 = null;
		CallableStatement cstmt2 = null;
		CallableStatement cstmt3 = null;
		CallableStatement cstmt4 = null;

//		Connection connection	= null;
		Statement statement		= null;
		Statement statement1		= null;
		Statement statement2		= null;
		ResultSet resultSet		= null;
		ResultSet resultSet1		= null;
		ResultSet resultSet2		= null;

		MessageManager mm=new MessageManager();

		ArrayList jobIds = new ArrayList();			 

 		String p_action=XHDBAdapter.checkNull(request.getParameter("action"));
			System.out.println("p_action : "+p_action);
		String p_proc_id=XHDBAdapter.checkNull(request.getParameter("process_id"));
			System.out.println("p_proc_id : "+p_proc_id);
		String processID=XHDBAdapter.checkNull(request.getParameter("processID"));
	//		System.out.println("processID : "+processID);
			String actionduplicate =XHDBAdapter.checkNull(request.getParameter("actionduplicate"));
		String p_job=XHDBAdapter.checkNull(request.getParameter("job"));
	//		System.out.println("p_job : "+p_job);
		String p_job1=XHDBAdapter.checkNull(request.getParameter("job1"));
	//		System.out.println("p_job1 : "+p_job1);											 
//		String p_what=XHDBAdapter.checkNull(request.getParameter("what"));
//			System.out.println("p_what : "+p_what);
  	    String p_internal_job=XHDBAdapter.checkNull(request.getParameter("internal_job"));
	//		System.out.println("p_internal_job : "+p_internal_job);
		String p_start_time=XHDBAdapter.checkNull(request.getParameter("proc_date"));
	//		System.out.println("p_start_time : "+p_start_time);
	//	p_start_time=DateUtils.convertDate(p_start_time,"DMYHM",locale,"en");
	//	if(p_start_time==null) p_start_time="";
		String p_interval=XHDBAdapter.checkNull(request.getParameter("interval"));			  
	//		System.out.println("p_interval : "+p_interval);
		String status="";
		String errMessage="";						    
		String p_OTcomm_type = "";

		String p_what= "";

		String wht1=XHDBAdapter.checkNull(request.getParameter("wht1"));
	//		System.out.println("wht1 : "+wht1);
		String wht2=XHDBAdapter.checkNull(request.getParameter("wht2"));
	//		System.out.println("wht2 : "+wht2);
																				   
		String param=XHDBAdapter.checkNull(request.getParameter("param"));
			System.out.println("param : "+param);			

	//	System.out.println("p_internal_job : "+p_internal_job);
		if(actionduplicate.equals("E"))
		{
			p_action="E";
		}
				
		try
		{

		if(p_action.equals("S")){			
			
			String proc_cmnd = "";
			String proc_str_cmd_sql = "SELECT PROC_ID,PROC_SRT_CMD FROM xh_proc_id WHERE proc_id= '"+p_proc_id+"' ";
			//	System.out.println("proc_str_cmd_sql : "+proc_str_cmd_sql);
		    statement1 = con.createStatement();
			resultSet1 = statement1.executeQuery(proc_str_cmd_sql); 
			//String dba_jobsWhat = "";
			while(resultSet1.next()){
					proc_cmnd = resultSet1.getString(2);
					//System.out.println("proc_cmnd : "+proc_cmnd);
			}
		
			if(p_proc_id.equals("XHORATABPRC")){
				p_what = proc_cmnd;
			}
			else if(proc_cmnd.equals("XIPROCUREMENT.HTTPGATEWAY('EPROCPL')")){ //Code changes made for XH_INTERFACE_ADMINISTER_ISSUE [IN:064353]
				p_what = proc_cmnd+";";
			}
			else{
				p_what = proc_cmnd+param+";";
			}
//			String p_whatNw = ""+proc_cmnd+param+";";
			//System.out.println("p_what Nw : "+p_what);
/*
			// Check duplicate Job
			
			String duplchksql = "SELECT what FROM dba_jobs WHERE what LIKE '"+p_what+"%'";
				System.out.println("dup chk sql1 : "+duplchksql);
			p_what = p_what+wht1+wht2+";";
				System.out.println("dup chk p_what : "+p_what);
		    statement = con.createStatement();
			resultSet = statement.executeQuery(duplchksql); 
			String dba_jobsWhat = "";
			while(resultSet.next()){
					dba_jobsWhat = resultSet.getString(1);
					System.out.println("dupl chk dba_jobsWhat : "+dba_jobsWhat);
			}

			if(p_what.equals(dba_jobsWhat)){
				System.out.println("Duplicate Record Exists");
			   final java.util.Hashtable mesg = mm.getMessage(locale, "XH1019", "XH") ;
			   status = ((String) mesg.get("message"));
			}
			else{
				if(resultSet!=null) resultSet.close();
			    if(statement!=null) statement.close();
			//

			*/


			p_job="0"; p_job1="0";

			// Process_Id - XHORATABPRC
			if(p_proc_id.equals("XHORATABPRC")){
				String p_OTProt_id=XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));			
	//				System.out.println("p_OTProt_id : "+p_OTProt_id);
	//			String p_OTAppl_id=XHDBAdapter.checkNull(request.getParameter("OTapplcation_id"));
				String p_OTAppl_id=XHDBAdapter.checkNull(request.getParameter("application_id"));				
	//				System.out.println("p_OTAppl_id : "+p_OTAppl_id);
				 p_OTcomm_type=XHDBAdapter.checkNull(request.getParameter("comm_type"));
	//				System.out.println("p_OTcomm_type : "+p_OTcomm_type);
				String p_OTclient_Id = p.getProperty("client_ip_address");	
	//				System.out.println("AdmnOra ClntId : "+p_OTclient_Id);

				String prc_id = "";
				cstmt1 = con.prepareCall("{ call xhgeneric.implicit_gateway_creation(?,?,?,?,?,?)}" ); 
				cstmt1.setString(1,p_OTProt_id);
				cstmt1.setString(2,p_OTAppl_id);			 
				cstmt1.setString(3,p_OTcomm_type);
				cstmt1.setString(4,p_OTclient_Id);
				cstmt1.registerOutParameter(5,java.sql.Types.VARCHAR);
				cstmt1.registerOutParameter(6,java.sql.Types.VARCHAR);
				cstmt1.execute();
				errMessage =  XHDBAdapter.checkNull(cstmt1.getString(5));
				status     =  cstmt1.getString(6);
					System.out.println("XHAdmOrclJob cstmt1 errMessage : "+errMessage);
					System.out.println("XHAdmOrclJob cstmt1 errCode : "+status);

				if(status.equals("1"))
				{
					 con.rollback();
					 final java.util.Hashtable mesg = mm.getMessage(con,"XH1000") ;
					 status = ((String) mesg.get("message"));
 	//			     System.out.println("XHAdmOrclJobProcSrvlt (rollback) message : "+status);
				}
				else if(status.equals("0")){
					con.commit();
	
	//					System.out.println("start_comm_process p_OTProt_id : "+p_OTProt_id);
					cstmt3 = con.prepareCall("{ call xhgeneric.start_comm_process(?,?,?)}" ); 
					cstmt3.setString(1,p_OTProt_id);
	//					System.out.println("XHAdmOrclJobProcSrvlt cstmt : "+cstmt3);
					cstmt3.registerOutParameter(2,java.sql.Types.VARCHAR);
					cstmt3.setString(3,p_OTclient_Id);
					cstmt3.execute();

					prc_id=XHDBAdapter.checkNull(cstmt3.getString(2));
	//					System.out.println("XHAdmOrclJob cstmt3 prc_id : "+prc_id);
				} 
				if(!prc_id.equals("")){
					p_what = p_what+wht1+prc_id+wht2+";";
	//				System.out.println("nw Wht Val ins XHORATABCond : "+p_what);
				} 
			} // end of XHORATABPRC
	//		} // end of else
		} // end of status 'S'
			
		//			System.out.println("nw Wht Val outsd : "+p_what);
 
	 	if(p_action.equals("R")){
			String fnlprocess_ID = "";
			if(processID.equals("XHORATABPRC")){
	//				System.out.println("Remv p_job : "+p_job);
				String sql1 = "SELECT what FROM dba_jobs WHERE job='"+p_job+"'";
			    statement = con.createStatement();
				resultSet = statement.executeQuery(sql1); 
				while(resultSet.next()){
					String processId = resultSet.getString(1);	    
						String sbstr1 = processId;
						for(int i=0;i<=sbstr1.length();i++){
							int argIndx = sbstr1.indexOf(",")+1;
								sbstr1 = sbstr1.substring(argIndx,sbstr1.length()-1);
								if(i==2){
								fnlprocess_ID = sbstr1.substring(1,sbstr1.indexOf(",")-1);
		//						System.out.println("final proc_id : "+fnlprocess_ID);
								break;
								}
						}
				}
	
				cstmt4 = con.prepareCall("{ call xhgeneric.stop_comm_process(?)}" ); 
				cstmt4.setString(1,p_proc_id);
				cstmt4.execute();				
			}
/*
			String crtrJobId = "";
			String crtrWhtval = "";

			if(processID.equals("XHBUILD")){
				String getJobIdQry  = "select job from dba_jobs where what='XHBUILDER.XHCREATOR;'";
				statement1 = con.createStatement();
				resultSet1 = statement1.executeQuery(getJobIdQry);
				while(resultSet1.next()){
					System.out.println("XHCreator job_id : "+resultSet1.getString(1));
					crtrJobId = resultSet1.getString(1);
				}
	//			jobIds.add(p_job);
				jobIds.add(crtrJobId);
			} // end of XHBUILD

			// Remove XHGEN_CREATOR.XHCREATOR job from dba_jobs before removing XHGENMESSAGEBUILDER or XHORATABPRC for Outbound
			else if((processID.equals("XHORATABPRC") && p_OTcomm_type.equals("O")) || processID.equals("XHGENMESSAGEBUILDER") ) {
				System.out.println("Comm_type : "+p_OTcomm_type);
				System.out.println("XHBLUDR / XHORTB for Outbound");
				int crtrJob_Id = Integer.parseInt(p_job);
				crtrJob_Id = crtrJob_Id-1;
						String getWhtQry  = "select job,what from dba_jobs where job='"+crtrJob_Id+"'";
				statement2 = con.createStatement();
				resultSet2 = statement2.executeQuery(getWhtQry);
				while(resultSet2.next()){
					crtrJobId = resultSet2.getString(1);
						System.out.println("XHGenCreator crtrJobId : "+crtrJobId);
					crtrWhtval = resultSet2.getString(2);
						System.out.println("XHGenCreator crtrWhtval : "+crtrWhtval);
				}
					int argIndx = crtrWhtval.indexOf("(");
					crtrWhtval = crtrWhtval.substring(0,argIndx);
					System.out.println("crtrWhtval aft indx : "+crtrWhtval);
					if(crtrWhtval.equals("XHGEN_CREATOR.XHCREATOR")){		
						jobIds.add(crtrJobId);
					}
			} // end of XHGENMESSAGEBUILDER and XHORATABPRC
		*/
		} // end of status 'R'
				jobIds.add(p_job);

				System.out.println("p_proc_id  : "+p_proc_id+" ::: p_action "+p_action+" ::: p_job "+p_job+" ::: p_job1 "+p_job1+" ::: p_what "+p_what+" ::: p_internal_job "+p_internal_job+" ::: p_start_time "+p_start_time+" ::: p_interval "+p_interval);
				//System.out.println("jobIds size : "+jobIds.size());
				for (int j=0;j<jobIds.size();j++)
				{
					p_job = (String)jobIds.get(j);
//					try
//					{
//					if (jobIds.length>0)
//					{
//						p_job = jobIds.get(0);
		//			System.out.println("jobIds.len>0 p_job : "+p_job);

 				    cstmt2 = con.prepareCall("{ call xhjob.process_job(?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?)}" ); 
					
					cstmt2.setString(1,p_action);
					cstmt2.setString(2,p_proc_id);		 
					cstmt2.setString(3,p_job);
					cstmt2.setString(4,p_job1);
					cstmt2.setString(5,p_what);
					cstmt2.setString(6,p_internal_job);
				    cstmt2.setString(7,p_start_time);							   
					cstmt2.setString(8,p_interval);
					cstmt2.registerOutParameter(9,java.sql.Types.VARCHAR);

					cstmt2.registerOutParameter(10,java.sql.Types.VARCHAR);  	 
								   
					cstmt2.execute();
					status=cstmt2.getString(9);
					errMessage =  cstmt2.getString(10);
//						System.out.println("XHAdmOrclJobProcSrvlt Status : "+status);
					request.setAttribute("status",status);
					request.setAttribute("p_action",p_action);
						//System.out.println("errMessage ::: "+errMessage);
						//System.out.println("status ::: "+status);


//					if(status.equals("1")||status.equals("2"))
					if(status.equals("0"))
					{
						con.commit();
	
/*					// Duplicate check code is replaced by Neelkamal on 26/5/2009	
					if(status.equals("2"))
					  {
					   System.out.println("XHAdmOrclJobProcSrvlt (if)Status2 : "+status);
					   final java.util.Hashtable mesg = mm.getMessage(locale, "XH1019", "XH") ;
  					   status = ((String) mesg.get("message"));
   				       System.out.println("XHAdmOrclJobProcSrvlt (commit) sts2 message : "+status);
						}
					else
					{
	*/
						
					//   final java.util.Hashtable mesg = mm.getMessage(con,"XH1001") ; RECORD_INSERTED
					   final java.util.Hashtable mesg = mm.getMessage(locale,"XH1001","XH") ;
  					   status = ((String) mesg.get("message"));
   //				    System.out.println("XHAdmOrclJobProcSrvlt (commit) message : "+status);
//					}
					}					
					else if(status.equals("2"))
					{
						con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
						//final java.util.Hashtable mesg = mm.getMessage(con, "XH1024") ;
						status = ((String) mesg.get("message"));	
					}
					else
					{
		//		     System.out.println("XHAdmOrclJobProcSrvlt (rollback) Status : "+status);
					 con.rollback();
					 final java.util.Hashtable mesg = mm.getMessage(locale,"XH1000","XH") ;
					// final java.util.Hashtable mesg = mm.getMessage(con,"XH1000") ;
					 status = ((String) mesg.get("message"));
 		//		     System.out.println("XHAdmOrclJobProcSrvlt (rollback) message : "+status);
					}
			 if(cstmt2!=null) cstmt2.close();
		//		 }
//				}
		} // end of for 
	}  // end of try


	      catch(Exception ex)
	      {
			  System.out.println("Error in doget method of xhadminoraclejobprocessservlet :"+ex.toString());
		     ex.printStackTrace(System.err);
			 final java.util.Hashtable mesg = mm.getMessage(con,"XH1000") ;
			 status = ((String) mesg.get("message"));
			 
	      }
		  finally{
			  try{
			//	  System.out.println("Status : "+status);
  				  if(cstmt1!=null) cstmt1.close();
			      if(cstmt3!=null) cstmt3.close();
				  if(cstmt4!=null) cstmt4.close();

				  if(statement!=null) statement.close();
				  if(resultSet!=null) resultSet.close();
				  if(statement1!=null) statement1.close();
				  if(resultSet1!=null) resultSet1.close();
		  		  if(statement2!=null) statement2.close();
				  if(resultSet2!=null) resultSet2.close();
	  			  if(cstmt2!=null) cstmt2.close();
				  ConnectionManager.returnConnection(con);
			  }catch(Exception e){ System.out.println("Error in calling closing dbconnection in doget method of xhadminoraclejobprocessservlet :"+e.toString());
			   e.printStackTrace(System.err);}
		  }
          return status;
	}	
}// end of class
