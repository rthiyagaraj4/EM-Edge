package eMR.smrp;

import java.sql.*;

public class LogSMRP{

	public void logSMRPStatus(Connection conn,String status,String file_name,String file_date,String file_type,String msg){

		
		Statement stmt =  null;

		System.out.println("Inside logger ");
		System.out.println("file_name--> "+file_name);
		System.out.println("file_date--> "+file_date);
		System.out.println("status--> "+status);
		try{
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			String sql="insert into MR_SMRP_LOG (FILE_NAME,GEN_STATUS,FILE_DATE,FILE_TYPE,GEN_MESSAGE,GEN_DATE) values ('"+file_name+"','"+status+"',to_date('"+file_date+"','dd/mm/yyyy'),'"+file_type+"','"+msg+"',sysdate)";
			System.out.println(sql);
			int i= stmt.executeUpdate(sql);
			System.out.println("i-->"+i);
			conn.commit();
				
		}catch(Exception ex){
			System.out.println("Error while logging "+ "file_name--> "+file_name +"file_date--> "+file_date+"status--> "+status +"file_type--> "+file_type +"gen_msg--> "+msg);
			System.out.println(ex.toString());
		}finally{
			try{
				stmt.close();
			}catch(Exception ex){
				
			}
		}

	}
}