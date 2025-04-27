/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.Random ;
import java.text.*;

public class RegEmailRecipientBean  implements java.io.Serializable
 { 
	
	ArrayList password= new ArrayList();
	public RegEmailRecipientBean()
	{
		password=new ArrayList();
	}
	public void setPassword(String[] pwdVals){
		boolean rt=(this.password).add(pwdVals);
		rt=rt;
	}
	public ArrayList getPassword(){
		return this.password;
	}
	public void removePwdVal(String srl_no,String[] des){
		String[] pwdVals=new String[4];
		if(this.password !=null && !this.password.isEmpty() && this.password.size()>0){
			for(int i=0;i<(this.password).size();i++){
				String[] tempStr=(String[])(this.password).get(i);
				if(tempStr[0].equals(srl_no)){
					pwdVals[0]=tempStr[0];
					pwdVals[1]=tempStr[1];
					pwdVals[2]=des[1];
					pwdVals[3]=tempStr[3];	
					(this.password).remove(i);
					setPassword(pwdVals);
					break;
				}		
			}
		}
	}
		
	public String getNewPassword(String mailer_id,String mode,Connection con)	
	{

		String i="";
		String pwd="";
		try{
		if(mode.equals("insert")){
			java.util.Random r=new Random();
			i=java.lang.Integer.toString(r.nextInt(10000),10);
			while(i.length()<4){
				i=java.lang.Integer.toString(r.nextInt(10000),10);
			}
			
		}else if(mode.equals("update")){

			ArrayList dbPasswords=getPasswords(mailer_id,con);
			if(dbPasswords.size()>0){
				java.util.Random r=new Random();
				i=java.lang.Integer.toString(r.nextInt(10000),10);
				while((i.length()<4) || dbPasswords.contains(mailer_id+i)){
					i=java.lang.Integer.toString(r.nextInt(10000),10);
				}
			}
			else
			{
				java.util.Random r=new Random();
				i=java.lang.Integer.toString(r.nextInt(10000),10);
				while(i.length()<4){
					i=java.lang.Integer.toString(r.nextInt(10000),10);
				}
			}
		}	
		pwd=mailer_id+i;
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return pwd;
	}
	public ArrayList getPasswords(String mailer_id,Connection con) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs=null;
		ArrayList dbPasswords=new ArrayList();
		try{
			/******** get passwords from database*****/
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("select app_password.decrypt(password) password from sm_regd_mail_user_pwd where mailer_id=?");
			pstmt.setString(1,mailer_id);
			rs=pstmt.executeQuery();	
			while(rs !=null && rs.next())
			{
				dbPasswords.add(rs.getString("password"));
			} 
			/********** get passwords set in the bean************/
			for(int i=0;i<this.password.size();i++){
				String[] pwdVals=(String[])(this.password).get(i);
				dbPasswords.add(pwdVals[3]);
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			try{
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}	
	return dbPasswords;
	}
	public String maxEffDate(String mailer_id,Connection con,String locale) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs=null;
		java.util.Date maxEffDate=new java.util.Date()	;
		ArrayList dateList=new ArrayList();
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy HH:mm");
		java.util.Date sysdate=maxEffDate;
		String from_date="";
		String to_date="";
  
		try{
			if(this.password.size()>0){
			/********** get date values set in the bean************/
				for(int i=0;i<this.password.size();i++){
					String[] pwdVals=(String[])(this.password).get(i);
					if(!pwdVals[1].equals(""))
						dateList.add(df.parse(pwdVals[1]));
					if(!pwdVals[2].equals(""))
					dateList.add(df.parse(pwdVals[2]));
				}
			}else{
			/******** get date values from database*****/
				con.setAutoCommit(false);
				pstmt=con.prepareStatement("select from_date,to_date from sm_regd_mail_user_pwd where mailer_id=?");
				pstmt.setString(1,mailer_id);
				rs=pstmt.executeQuery();	
				while(rs !=null && rs.next())
				{
					from_date=rs.getString("from_date");
					to_date=rs.getString("to_date");
					/*Thai date validations 29/07/2008 start */
					if(from_date==null || from_date.equals("null") || (from_date.equals(""))) from_date="";
					if(to_date==null || to_date.equals("null") || (to_date.equals(""))) to_date="";
				
					if(!locale.equals("en")){
						from_date = com.ehis.util.DateUtils.convertDate(from_date,"DMYHM","en",locale);
						to_date=com.ehis.util.DateUtils.convertDate(to_date,"DMYHM","en",locale);
					}
				/*Thai date validations 29/07/2008 end */
					if(!from_date.equals(""))
						dateList.add(df.parse(from_date));
					if(!to_date.equals(""))
						dateList.add(df.parse(to_date));
				} 
			}			
			if(dateList.size()>0){
				maxEffDate=(java.util.Date)dateList.get(0);
				for(int i=0;i<dateList.size();i++){
					if(maxEffDate.before((java.util.Date)dateList.get(i))){
						maxEffDate=(java.util.Date)dateList.get(i);
					}
				}
			}
			if(maxEffDate.before(sysdate)){
				maxEffDate=sysdate;
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			try{
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}	
		return df.format(maxEffDate);
	}
	public void clearBean(){
		this.password= new ArrayList();
	}
	public String getCurrUserPwd(Connection con,String appl_user_id,String language_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs=null;
		String currPassword="";
		try{
			/******** get passwords from database*****/
			con.setAutoCommit(false);
			pstmt=con.prepareStatement("select app_password.decrypt(appl_user_password) password from sm_appl_user where appl_user_id=? and language_id=? and to_date(sysdate,'dd/mm/yyyy HH24:MI') between to_date(nvl(eff_date_to,sysdate),'dd/mm/yyyy HH24:MI') and to_date(nvl(eff_date_to,sysdate),'dd/mm/yyyy HH24:MI')");
			pstmt.setString(1,appl_user_id);
			pstmt.setString(2,language_id);
			rs=pstmt.executeQuery();	
			while(rs !=null && rs.next())
			{
				currPassword=rs.getString("password");
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			try{
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}	
	return currPassword;
	
	}
	
}
