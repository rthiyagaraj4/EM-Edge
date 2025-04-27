/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ecis.utils;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.* ;
import java.net.* ;

import java.sql.* ;
import java.util.* ;
import webbeans.eCommon.*;

public class OnlineReports implements java.io.Serializable {
    Vector reports ;

//  By sbchand start on 23 Oct, 2001 
    boolean results_not_needed ;
//  By sbchand end on 23 Oct, 2001

    public OnlineReports() {
        reports = new Vector() ;
    }

//  By sbchand start on 23 Oct, 2001
    public OnlineReports( boolean results_not_needed ) {
        this.results_not_needed = results_not_needed ;
        reports = new Vector() ;
    }
//  By sbchand end on 23 Oct, 2001

    public boolean add( OnlineReport or ) {
        boolean result = reports.add( or ) ;
        return result ;
    }

    public Vector getReports() {
        return this.reports ;
    }

    public String execute( HttpServletRequest request, HttpServletResponse response ) {
        if ( reports == null ) return "Null Value" ;
        String result = "" ;
		
        for( Enumeration e = (getReports()).elements(); e.hasMoreElements(); ) {
		
            OnlineReport report = (OnlineReport) e.nextElement() ;
            result = result + processReport( report, request, response ) ;
        }
        result += "<center><b>Report Generated Successfully....</b></center>" ;
        return result ;
    }

    public String processReport( OnlineReport onlineReport, HttpServletRequest req, HttpServletResponse res ) {
        String result       = "<br> " ;
        Connection con = null;
		Statement stmt= null;
		ResultSet rset=null;
		PreparedStatement pstmt=null;
		CallableStatement cs=null;

		String reportServer = "";   //Null handling in exception
		String userid       = "";  //Null handling in exception
		String ws_no		= "";  //Null handling in exception
		String workStation  = ""; //added for SCF-16960 on 28/6/2016
        try {
            HttpSession session = req.getSession( false ) ;
			
			//String reportServer = "";  //Null handling in exception
			//String userid       = "";  //Null handling in exception
			//String ws_no = "";          //Null handling in exception
			
			con = ConnectionManager.getConnection(req);
			if(session != null)
			{ 
				reportServer = (String) session.getValue( "report_server" ) ;
				userid       = (String) session.getValue( "report_connect_string" ) ;
				
				// By Bala RR start on 20th Feb 2003 ** For getting correct IP address
				Properties p = (Properties) session.getValue( "jdbc" ) ;
				ws_no = p.getProperty( "client_ip_address" ) ;
				
            } 
			else //Modified against SRR20056-SCF-12178 - Else Loop executes if session is null
			{ 
				String sUserid = "";
				String sPwd = "";
				String sReportConnectString = "";
				pstmt = con.prepareStatement("select nvl(connection_pool_yn,'N') connection_pool_yn,  user_id, app_password.decrypt(password) as password, connect_string, db_driver, ejb_connect_string, report_connect_string, report_server from sm_db_info");
				rset = pstmt.executeQuery();            
				if (rset != null && rset.next()) {  
					sUserid = rset.getString("user_id");
					sPwd 	= rset.getString("password");
					sReportConnectString = rset.getString("report_connect_string");
					userid = sUserid + "/" + sPwd + "@" + sReportConnectString;
					reportServer = rset.getString("report_server");
				}

				 ws_no = req.getRemoteAddr();   

				 workStation= onlineReport.getWorkStationID() ; //added for SCF-16960 on 28/6/2016
				 if ( workStation       == null ) workStation  = "" ;


				
				if(workStation!=null && !workStation.equals("")) //added for SCF-16960 on 28/6/2016
					ws_no = workStation;

					
				if(rset != null)rset.close(); //SCF-16497
				if(pstmt != null)pstmt.close();//SCF-16497
				
			} 

		

            String url          = "" ;

            String report       = "" ;
            String server       = "" ;
            String copies       = "" ;
            String report_mode  = "" ;
            String queue_name       = "" ;
            String report_tool  = "" ;
            String status       = "" ; 
            String message      = "" ;
			String rep_debug_YN="N"; 
			
            String module_id        = onlineReport.getModuleId() ;
			
            String report_id        = onlineReport.getReportId() ;
			
            String dest_locn_type   = onlineReport.getLocationType() ;
			
            String dest_locn_code   = onlineReport.getLocationCode() ;
			
            String facility_id  = onlineReport.getFacilityId() ;
			
            //String ws_no        = req.getRemoteAddr() ;
			
			
			String report_ssl_yn = (String) session.getValue( "report_ssl_yn" ) ;//Added By dharma for MOHE-CRF-0009
			// By Bala RR end on 20th Feb 2003

            String report_option    = "P" ;

// By sbchand start on 25th July, 2001
            String app_server_ip    = "" ;
            
// By sbchand end on 25th July, 2001
			String rep_server_key    = "" ;//Changes for 37658
            if ( reportServer       == null ) reportServer  = "" ;
            if ( userid         == null ) userid        = "" ;
            if ( ws_no          == null ) ws_no     = "" ;
			
			
            //Connection con = (Connection) session.getValue( "connection" ) ;
            //con = ConnectionManager.getConnection(req);

             //result +="<br>"+con ;
			 
            cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;
			
			System.out.println("module_id"+module_id+"report_id"+report_id+"dest_locn_type"+dest_locn_type+"dest_locn_code"+dest_locn_code+"facility_id"+facility_id+"ws_no"+ws_no+"report_option"+report_option+"reportServer"+reportServer+"userid"+userid);	
            cs.setString( 1,    module_id ) ;
            cs.setString( 2,    report_id ) ;
            cs.setString( 3,    dest_locn_type ) ;
            cs.setString( 4,    dest_locn_code ) ;
            cs.setString( 5,    facility_id ) ;
            cs.setString( 6,    ws_no ) ;
            cs.setString( 7,    report_option ) ;
            cs.registerOutParameter( 8,  Types.VARCHAR ) ;
            cs.registerOutParameter( 9,  Types.VARCHAR ) ;
            cs.registerOutParameter( 10, Types.VARCHAR ) ;
            cs.registerOutParameter( 11, Types.VARCHAR ) ;
            cs.registerOutParameter( 12, Types.VARCHAR ) ;
            cs.registerOutParameter( 13, Types.VARCHAR ) ;
            cs.registerOutParameter( 14, Types.VARCHAR ) ;
            cs.registerOutParameter( 15, Types.VARCHAR ) ;
// By sbchand start on 25th July, 2001
            cs.registerOutParameter( 16, Types.VARCHAR ) ;

// By sbchand end on 25th July, 2001
			cs.registerOutParameter( 17, Types.VARCHAR ) ; // changes for 37658
            cs.execute() ;

            report  = cs.getString( 8 ) ;
            server  = cs.getString( 9 ) ;
            copies  = cs.getString( 10 ) ;			
            report_mode = cs.getString( 11 ) ;
            queue_name  = cs.getString( 12 ) ;
			queue_name=queue_name.trim();
            report_tool = cs.getString( 13 ) ;
            status  = cs.getString( 14 ) ;
            message = cs.getString( 15 ) ;
            //result +="<br>"+message ;
// By sbchand start on 25th July, 2001
            app_server_ip = cs.getString( 16 ) ;
            rep_server_key = cs.getString( 17 ) ;//Changes for 37658

			//report_ssl_yn condition added by Dharma for MOHE-CRF-0009
			if(report_ssl_yn.equals("Y")){
				reportServer = "https://" + app_server_ip + reportServer ;
			}else{
				reportServer = "http://" + app_server_ip + reportServer ;
			}

// By sbchand end on 25th July, 2001

            

			/*try{
				if(con!=null) ConnectionManager.returnConnection(con, req);
			}catch(Exception exc){
				System.err.println("my error===>156-->"+exc);
				exc.printStackTrace();
			}
			*/
			
			try{
				stmt=con.createStatement();

				rset	=stmt.executeQuery("select DEBUG_YN from SM_REPORT where report_id='"+report_id+"' and MODULE_ID='"+module_id+"'");

					
				if(rset!=null && rset.next()){
					rep_debug_YN = rset.getString("DEBUG_YN");
				}
				
				
				
			}catch(Exception ex){
				rep_debug_YN="N";
				
				ex.printStackTrace() ;
			}
			

// By sbchand start on 20th June, 2001 - To check for Windows Printing
            if ( queue_name.startsWith( "\\\\\\\\" ) ) {
                String s1 = queue_name.substring( 4 ) ;

                int index = s1.indexOf( "\\\\" ) ;
                String s2 = s1.substring( 0, index ) ;
                String s3 = s1.substring( index+2 ) ;

                String result_queue = "\\\\" + s2 + "\\" + s3 ;
                queue_name = result_queue ;


            }
// By sbchand end on 20th June, 2001

		//modified on 12/11/2003
		if (onlineReport.getParameters().indexOf("copies") == -1)
		{
			int cop = 0;
			if(copies == null || copies.equals(""))
				copies="1";
			cop=Integer.parseInt(copies);

            url = reportServer  +"?report="      + report ;
			if(rep_server_key==null || rep_server_key.equals("null") ||  rep_server_key.equals("")){ //PMG2012-CRF-0027 IN:037658
						url=url+"+userid=" 		+ userid;
					}else{
						url=url+"+cmdkey=" 		+ rep_server_key;
					}
					url=url+"+server="      + server        +
                "+destype=printer+COPIES="+cop+
                "+desname="     + queue_name    +
                "+recursive_load=no"+
                "+"         + onlineReport.getParameters() ;

			//Added  on 2/14/2006
			//Changes for number of copies -- Begin
			
			//for (int i=0;i<cop;i++){//Changes for number of copies -- End

				
			if(rep_debug_YN.equals("Y")){
				
				int ins_count=0;
				 con.setAutoCommit(false);
				 try{
					 pstmt = con.prepareStatement("insert into SM_PROC_MSG (OPERATING_FACILITY_ID,PROC_ID,APP_MSG,MSG_DATE_TIME,FAILED_PROC_ID,APP_KEY) values (?,?,?,sysdate,'DBGRP',?)");
					 pstmt.setString(1,module_id);
					 pstmt.setString(2,report_id);
					 pstmt.setString(3,url);
					 pstmt.setString(4,ws_no);
					 ins_count	= pstmt.executeUpdate();					 
				 }catch (Exception ex){
				  
				   ex.printStackTrace() ;
					
					 pstmt = con.prepareStatement("insert into SM_PROC_MSG (OPERATING_FACILITY_ID,PROC_ID,APP_MSG,MSG_DATE_TIME,FAILED_PROC_ID,APP_KEY) values (?,?,?,sysdate,'DBGRP',?)");
					 pstmt.setString(1,module_id);
					 pstmt.setString(2,report_id);
					 pstmt.setString(3,"Error in inserting for user ="+userid+" COPIES ="+cop +"desname  = "+ queue_name);
					  pstmt.setString(4,ws_no);
					 ins_count	=pstmt.executeUpdate();
					 

				 }
				 con.commit();
			}
	

			for (int i=0;i<1;i++){//Changes for number of copies -- End
            URL reportUrl = new URL( url ) ;

            URLConnection urlConnection = reportUrl.openConnection() ;
            BufferedReader br = new BufferedReader(
                            new InputStreamReader(
                                urlConnection.getInputStream()
                                ) ) ;

			//  By sbchand start on 23 Oct, 2001
            if ( results_not_needed ) return "" ;
			//  By sbchand end on 23 Oct, 2001

            String line = "" ;
            String output = "" ;
			
			
			
			
            while( (line = br.readLine() ) != null ) {
				

                output = output + line ;
            }
			

            int start = output.indexOf( "<PRE>" ) ;
            int end   = output.lastIndexOf( "</PRE>" ) ;
			
			

            if ( start != -1 ) {
                String error = output.substring( start+5, end ) ;
                result += error ;
            }

			br.close();	
			}//Changes for number of copies 

		}
		else
			{
			//Pick up the number of copies
			StringTokenizer tok = new StringTokenizer(onlineReport.getParameters(),"+");
			String parameters = "";
			String copiesTok = "";
			while(tok.hasMoreTokens()){
				String tok1 = tok.nextToken();
				if (tok1.startsWith("copies")){
					copiesTok = tok1;
				}else{
					if (parameters.equals(""))parameters = tok1;
					else parameters = parameters+"+"+tok1;
				}
			}

            url = reportServer  + "?report="      + report;

			String noCop = copiesTok.substring(copiesTok.indexOf("=")+1);
			int cop = Integer.parseInt(noCop);

			if(rep_server_key==null || rep_server_key.equals("null") || rep_server_key.equals("")){ //PMG2012-CRF-0027 IN:037658
						url=url+"+userid=" 		+ userid;
					}else{
						url=url+"+cmdkey=" 		+ rep_server_key;
					}
					url=url+"+server="      + server        +
                "+destype=printer+COPIES="+cop+
                "+desname="     + queue_name    +             
                "+recursive_load=no"+
                "+"         + parameters ;			
				
				

				if(rep_debug_YN.equals("Y")){
					
					int ins_count=0;
					 con.setAutoCommit(false);
					 try{
						 pstmt = con.prepareStatement("insert into SM_PROC_MSG (OPERATING_FACILITY_ID,PROC_ID,APP_MSG,MSG_DATE_TIME,FAILED_PROC_ID,APP_KEY) values (?,?,?,sysdate,'DBGRP1',?)");
						 pstmt.setString(1,module_id);
						 pstmt.setString(2,report_id);
						 pstmt.setString(3,url);
						  pstmt.setString(4,ws_no);
						 ins_count	= pstmt.executeUpdate();					 
					 }catch (Exception ex){
					 
					 ex.printStackTrace() ;
						
						 pstmt = con.prepareStatement("insert into SM_PROC_MSG (OPERATING_FACILITY_ID,PROC_ID,APP_MSG,MSG_DATE_TIME,FAILED_PROC_ID,APP_KEY) values (?,?,?,sysdate,'DBGRP1',?)");
						 pstmt.setString(1,module_id);
						 pstmt.setString(2,report_id);
						 pstmt.setString(3,"Error in inserting for user ="+userid+" COPIES ="+cop +"desname  = "+ queue_name);
						  pstmt.setString(4,ws_no);
						 ins_count	=pstmt.executeUpdate();
						 

					 }
					 con.commit();
				}

				//for (int i=0;i<cop;i++){
				for (int i=0;i<1;i++){
					//Added on 2/14/2006
					URL reportUrl = new URL( url ) ;

					URLConnection urlConnection = reportUrl.openConnection() ;
					BufferedReader br = new BufferedReader(
									new InputStreamReader(
										urlConnection.getInputStream()
										) ) ;

					//  By sbchand start on 23 Oct, 2001
					if ( ! results_not_needed ) result += "" ;
					//  By sbchand end on 23 Oct, 2001
					else{
						String line = "" ;
						String output = "" ;

						
						


						while( (line = br.readLine() ) != null ) {
							output = output + line ;
							
						}
						
						int start = output.indexOf( "<PRE>" ) ;
						int end   = output.lastIndexOf( "</PRE>" ) ;
						
				
						

						if ( start != -1 ) {
							String error = output.substring( start+5, end ) ;
							result += error ;
						}
						
					}

					br.close();	
				}
			}
                //result +=  "<br>url:"+url ;
			

			if(stmt!=null)	stmt.close();
			if(rset!=null)	rset.close();
			if(cs!=null)	cs.close();
			if(pstmt!=null) pstmt.close();

        } catch ( Exception e ) {
//          out.println( e.getMessage() ) ;
			/*Modified against SRR-SCF-12178*/
			int ins_count=0;
			try{
				if(con==null)  con = ConnectionManager.getConnection(req);
				con.setAutoCommit(false);

				String err_msg = "";
				//StringWriter sw = new StringWriter();	//Null handling in exception for SCF-16497
				//PrintWriter pw  = new PrintWriter(sw);	//Null handling in exception for SCF-16497
				//e.printStackTrace(pw);					//Null handling in exception for SCF-16497
				

				//err_msg =  "ws_no-"+ws_no +"userid-"+userid+"stacktrace=="+sw.toString(); //Null handling in exception for SCF-16497
				
				err_msg = "ws_no-"+ws_no +"userid-"+userid+"stacktrace=="+e.getMessage();


				if(err_msg.length()>3999)
					err_msg = err_msg.substring(0, 3999);		//Null handling in exception for SCF-16497
				


				pstmt = con.prepareStatement("insert into SM_PROC_MSG (OPERATING_FACILITY_ID,PROC_ID,APP_MSG,MSG_DATE_TIME,FAILED_PROC_ID,APP_KEY) values (?,?,?,sysdate,'DBGRP',?)");
				pstmt.setString(1,onlineReport.getModuleId());
				pstmt.setString(2,onlineReport.getReportId());
				//pstmt.setString(3,"Error on printing report:"+e.getMessage());//commented for SCF-16497
				pstmt.setString(3,"Error on printing report:"+err_msg);//Null handling in exception for SCF-16497
				pstmt.setString(4,"");
				ins_count	= pstmt.executeUpdate();
				con.commit();				
				if(pstmt != null)pstmt.close();				 
			 }catch (SQLException ex){
				System.err.println("Error in inserting into SM_PROC_MSG .."+ex.getMessage());
			 } 
			 
			 /*Modified against SRR-SCF-12178*/
            result += e.toString();
            e.printStackTrace() ;
			System.err.println("my error 292-->"+e);
			System.out.println("my onlinereports.java 292-->"+e);

        }
        finally
        {
			//Modified against SRR-SCF-12178: Closing objects
			try{
            if(rset != null)rset.close();
			if(pstmt != null)pstmt.close();
			}catch (SQLException ex){
				System.err.println("Error on closing resultset and preparedstatement..");
			}
			if(con!=null) ConnectionManager.returnConnection(con, req);
        }

        return result ;
    }
}
