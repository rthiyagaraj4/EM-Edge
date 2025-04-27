/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import webbeans.eCommon.*;


public class  ScheduleFrequency implements Serializable{
	protected String                      freq_code;
	protected String                      admin_facility_id;
	protected String                      admin_day_or_time;
	protected String                      admin_day;
	protected String		              admin_time;
	protected Properties				  properties         ;

	protected static String SCHEDULE_FREQUENCY="SELECT freq_code,freq_desc  FROM   am_frequency a WHERE interval_durn_type IN ('H','D','W','M','L') AND  eff_status ='E' AND  Scheduled_yn ='Y' order by freq_desc";
	protected static String SCHEDULE_FREQUENCY_FACILITY  = "select facility_name , facility_id from sm_facility_param order by 1";
	protected static String SCHEDULE_FREQUENCY_DAY = "SELECT initcap(substr(DAY_OF_WEEK,1,3)) Disp_day_of_week,day_no day_of_week  FROM sm_day_of_week";
	protected static String SCHEDULE_FREQUENCY_FREQLEGEND ="SELECT  freq_code, freq_desc, repeat_value, interval_durn_type, repeat_value || ' '|| 'Repeats Per ' || b.Durn_desc || ' ' ||b.for_text || ' Every  ' || Interval_value || ' ' || c.durn_Desc  Frequency_Legend, START_TIME_ROUND, START_TIME_ASSIGN, MAX_NO_OF_CYCLE FROM   am_frequency a,  am_duration_type b, am_duration_type c WHERE  interval_durn_type IN ('H','D','W','M','L') AND  Scheduled_yn ='Y' AND  eff_status IN('D','E') AND a.repeat_durn_type =b.durn_type AND a.interval_durn_type = c.durn_type and  freq_code = ?"; //Modified by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
	protected static String FREQUENCY_REPEAT_VALUE_DURN_TYPE = "SELECT repeat_value, repeat_durn_type FROM am_frequency WHERE freq_code = ?";


	

	public  StringBuffer tempChk	=new StringBuffer();
	

/*********************Constructor *************************/
public ScheduleFrequency(){
			 admin_facility_id				= ""    ;
			 admin_day_or_time				= ""    ;
			 admin_day						= ""    ;
			 admin_time						= ""    ;
			 tempChk						=null		;
			 //tempChk1						=""		;
			 properties						=null	;
}

/**********************SET METHODS*************************/

  public void  setFreq_code(String  freq_code) {this.freq_code=  freq_code; } ;
  public void  setAdmin_facility_id(String  admin_facility_id) {this.admin_facility_id=  admin_facility_id; } ;
  public void  setAdmin_day_or_time(String  admin_day_or_time) {this.admin_day_or_time=  admin_day_or_time; } ;
  public void  setAdmin_day(String  admin_day) {this.admin_day=  admin_day; } ;
  public void  setAdmin_time(String  admin_time) {this.admin_time=  admin_time; } ;
  public void  setProperties( Properties properties ) {this.properties = properties ;};

/**********************GET METHODS*************************/

  public String getFreq_code() { return this.freq_code ; } ;
  public String getAdmin_facility_id() { return this.admin_facility_id ; } ;
  public String getAdmin_day_or_time() { return this.admin_day_or_time ; } ;
  public String getAdmin_day() { return this.admin_day ; } ;
  public String getAdmin_time() { return this.admin_time ; } ;
  public Properties getProperties(){return this.properties ;};

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSet ) {
	if(recordSet.containsKey("freq_code"))
		 setFreq_code((String)recordSet.get(freq_code));
	if(recordSet.containsKey("admin_facility_id"))
		 setAdmin_facility_id((String)recordSet.get(admin_facility_id));
	if(recordSet.containsKey("admin_day_or_time"))
		 setAdmin_day_or_time((String)recordSet.get(admin_day_or_time));
	if(recordSet.containsKey("admin_day"))
		 setAdmin_day((String)recordSet.get(admin_day));
	if(recordSet.containsKey("admin_time"))
		 setAdmin_time((String)recordSet.get(admin_time));
}

/*********************METHOD TO Reset the Class variable*************************/

	public void clear() {
			 admin_facility_id						= ""    ;
			 admin_day_or_time						= ""    ;
			 admin_day						= ""    ;
			 admin_time						= null    ;
	}

/*********************************************************/
public Object getComboOptions(String option) {
Connection connection =null ;
try
{
		connection = getConnection();
		Object str ="";
		if(option.trim().equalsIgnoreCase("frequency"))
		str = getComboOptions(SCHEDULE_FREQUENCY,connection,"freq_code","freq_desc");
		else if(option.trim().equalsIgnoreCase("facility"))
		str = getComboOptions(SCHEDULE_FREQUENCY_FACILITY,connection,"facility_id","facility_name");
		else if(option.trim().equalsIgnoreCase("day")){
		str = getAsHashArray(SCHEDULE_FREQUENCY_DAY,connection,"Disp_day_of_week","day_of_week");
		}

		return str;

}
catch(Exception e)
{
		e.printStackTrace();
		return null;
}
finally
{
	try
	{
	closeConnection(connection);
	}
	catch(Exception e)
	{e.printStackTrace();}
}

}

/*********************************************************************/
public ArrayList getFreqValues(HttpServletRequest params){
	Connection connection =null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;

try{
	String freq_code = params.getParameter("freq_code");
	connection = getConnection();
	ArrayList  retVales = new ArrayList();

	pstmt = connection.prepareStatement(SCHEDULE_FREQUENCY_FREQLEGEND);
	pstmt.setString(1,freq_code.trim());

	rs = pstmt.executeQuery();

	if(rs.next()){
	retVales.add(0,defaultString(rs.getString("REPEAT_VALUE")));
	retVales.add(1,defaultString(rs.getString("INTERVAL_DURN_TYPE")));
	retVales.add(2,defaultString(rs.getString("FREQUENCY_LEGEND")));
	retVales.add(3,defaultString(rs.getString("START_TIME_ROUND")));
	retVales.add(4,defaultString(rs.getString("START_TIME_ASSIGN")));
	retVales.add(5,defaultString(rs.getString("MAX_NO_OF_CYCLE"))); //Added by Sangeetha on 4th Jul 2017 for ML-MMOH-CRF-0345.2
	}
	return retVales;

}
catch(Exception e)
{
		e.printStackTrace();
		tempChk.append("e=" +e.getMessage());
		return null;
}
finally{
		try
		 {
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
			closeConnection(connection);
		 }
		 catch(Exception e){e.printStackTrace();}
  }

}

/*************************************************************************/

 public Connection getConnection() throws Exception {
        Connection connection = null ;
        connection = ConnectionManager.getConnection( properties ) ;
        return connection ;
    }

/*************************************************************************/

    public void closeConnection( Connection connection ) throws Exception {
        if( connection != null )
			ConnectionManager.returnConnection( connection, properties ) ;
    }


/*************************************************************************/
 public	 static  String   defaultString(String str){
	 return (str==null)? "":str.trim();
 }
/****************************************************************************/
public static String getComboOptions(String sql ,  Connection con  , String codeColumn ,String codeDescriptionColumn ) throws Exception
	{
		Statement stmt=null;
		ResultSet rs=null;

		try
		{

			 if(sql== null || sql.trim().equals("") || con == null || codeColumn.trim().equals("") ||  codeColumn==null || codeDescriptionColumn.trim().equals("") ||  codeDescriptionColumn==null )
                 throw new Exception("Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con + "\n codeColumn=>" + codeColumn + "\ncodeDescriptionColumn=>"  + codeDescriptionColumn ) ;

			stmt			= con.createStatement();
			rs				= stmt.executeQuery(sql);
	        StringBuffer sb = new StringBuffer();

			if(rs !=null )
				{
					while (rs.next())
					{
						String  codeCol			   = defaultString(rs.getString(codeColumn.trim()));
						String  codeDesc			= defaultString(rs.getString(codeDescriptionColumn.trim()));
						 sb.append("<option value="+ codeCol + " >" + codeDesc + "</option>");
					}

				}if(rs !=null ) rs.close();
				 if(stmt !=null ) stmt.close();

			 return  sb.toString();

		}
		catch(Exception e)
		{
			throw e;
		}
		finally{

			try
			 {
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
			 }catch(Exception e){e.printStackTrace();}
		}
   }
/******************************************************************************/
public ResultSet load(String freq_code,String facility_id,Connection connection, String max_no_of_cycle_p, String tempMode)
	{
String sql ="select ADMIN_DAY_OR_TIME,ADMIN_DAY,to_char(ADMIN_TIME,'HH24:MI')ADMIN_TIME,ADMIN_WEEK,ADMIN_MONTH from AM_FREQUENCY_ADMIN_DAY_TIME where freq_code='"+ freq_code + "' and admin_facility_id='" + facility_id + "'" ;
String order_by = "";
      if(max_no_of_cycle_p.equals(""))
	  {
		  order_by = " order by TO_NUMBER(ADMIN_DAY),ADMIN_TIME";
	  }
	  else{
		  if(tempMode.equals("Day")){
			  order_by = " order by TO_NUMBER(ADMIN_DAY),ADMIN_TIME";
		  }
		  if(tempMode.equals("Week")){
			  order_by = " order by TO_NUMBER(ADMIN_WEEK),ADMIN_TIME";
		  }
		  if(tempMode.equals("Month")){
			  order_by = " order by TO_NUMBER(ADMIN_MONTH),ADMIN_TIME";
		  }
	  }
        Statement stmt = null ;
		ResultSet rs=null;
try{
	    

		stmt		 = connection.createStatement();
		rs			 = stmt.executeQuery(sql+order_by);
//		if(stmt!=null)stmt.close();
		
		return rs;
		
		//if(stmt!=null)stmt.close();
		//if(rs!=null) rs.close();

}catch(Exception e){
		
		e.printStackTrace();
		return null;
}
finally{

			try
			 {
				//if(stmt!=null) stmt.close();
				//if(rs!=null) rs.close();
			 }catch(Exception e1){e1.printStackTrace();}
		  }


}
/******************************************************************************/
public static HashMap getAsHashArray(String sql ,  Connection con  , String codeColumn ,String codeDescriptionColumn) throws Exception{
		
		Statement stmt = null;
		ResultSet rs   = null;
		try
		{

				if(sql== null || sql.trim().equals("") || con == null || codeColumn.trim().equals("") ||  codeColumn==null || codeDescriptionColumn.trim().equals("") ||  codeDescriptionColumn==null )
                 throw new Exception("Illegal Parameter Passed Check \nsql=:>" + sql  + "\nConnection=>" + con + "\n codeColumn=>" + codeColumn + "\ncodeDescriptionColumn=>"  + codeDescriptionColumn ) ;

				HashMap holder		= new HashMap();
				stmt				= con.createStatement();
				rs					= stmt.executeQuery(sql);
				ArrayList  arrValue	= new ArrayList();
				ArrayList  arrDesc	= new ArrayList();

				int i = 0;

				while (rs.next())
					{
						String  codeCol			    = defaultString(rs.getString(codeColumn.trim()));
						String  codeDesc			= defaultString(rs.getString(codeDescriptionColumn.trim()));
						arrValue.add(i,codeCol);
						arrDesc.add(i,codeDesc);
						++i;
					}

						holder.put("value" , arrValue);
						holder.put("Description" , arrDesc);

						return  holder;
		  }
		  catch(Exception e)
		  {
				throw e;
		  }
		  finally{

			try
			 {
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
			 }catch(Exception e){e.printStackTrace();}
		  }
  }
/*******************************************************************************/
public ArrayList getRepeatValues(String freq_code)
{
	Connection connection =null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	ArrayList  retVales = new ArrayList();
	try
	 {
		connection = getConnection();
		
		pstmt = connection.prepareStatement(FREQUENCY_REPEAT_VALUE_DURN_TYPE);
		pstmt.setString(1,freq_code.trim());
		rs = pstmt.executeQuery();
		if(rs.next())
			{
				retVales.add(0,defaultString(rs.getString("REPEAT_VALUE")));
				retVales.add(1,defaultString(rs.getString("REPEAT_DURN_TYPE")));
			}
		}catch(Exception e)
			{
				e.printStackTrace();
				tempChk.append("e=" +e.getMessage());
				return null;
			}
		finally
			{
				try
				 {
					if(pstmt!=null) pstmt.close();
					if(rs!=null) rs.close();
						closeConnection(connection);
				 } catch(Exception e){e.printStackTrace();}
			 }
	return retVales;
}

/*******************************************************************************/


public String formHtmlOptions(String freq_code,String facility_id,Connection connection, String start_time_round_p, String start_time_assign_p,String max_no_of_cycle_p)
	{
		
			java.sql.ResultSet rs = null;  
			String hrsHtml = "";
			
			int counter = 0;
			int colSpanCount = 0 ;
  try{
		//Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2
	 
		//	 int k= 0;

			ArrayList repeatVals = getRepeatValues(freq_code);
			String tempMode;
			if((repeatVals.get(1)).equals("W"))
				tempMode ="Week";
			else if((repeatVals.get(1)).equals("L"))
				tempMode ="Month";
			else
				tempMode ="Day";

			String repeat_val = (String)repeatVals.get(0);
		 rs = load(freq_code,facility_id,connection,max_no_of_cycle_p,tempMode);
			if(max_no_of_cycle_p.equals("")){ //Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2
			if(tempMode.equals("Day"))
			{
				hrsHtml = "<TR>";
				while(rs.next())
					{
						counter++ ;
						colSpanCount++;
						String dt = rs.getString("admin_time");
						hrsHtml =hrsHtml+"<TD align='right' class='label'>"+ counter + "</TD><TD>"+"<INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' NAME=time" +counter+  " value='"+ dt+"'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></TD>";
						if(counter%6 == 0)
							hrsHtml =hrsHtml+"</TR><TR>";
					}
				//	chkDaysUpdate = chkDaysUpdate.substring(0,chkDaysUpdate.length()-1);
					hrsHtml = hrsHtml+"</TR>";
			}

			
			if(tempMode.equals("Week"))
			{
					while(rs.next())
					{
						++colSpanCount;
						String dt = rs.getString("admin_time");
						hrsHtml =hrsHtml+"<TR><TD align='right' class='label'>  "+colSpanCount + "</TD><TD>"+"<SELECT name='repeat_"+colSpanCount+"'>";
						
							for(int j=1; j<=7; j++)
							{
								if(rs.getString("admin_day")!=null) // condition written to prevent null pointer exception from existing old records
								{
									if(Integer.parseInt(rs.getString("admin_day"))==j)
										hrsHtml =hrsHtml+"<OPTION value='"+j+"' selected>"+j+"</OPTION>";
									else
										hrsHtml =hrsHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
								}
								else
										hrsHtml =hrsHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
							}
							
						hrsHtml = hrsHtml+"</SELECT></TD><TD>"+"<INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' NAME='time"+colSpanCount+"' value='"+dt+"'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></TD></TR>";
					}
												
			}

			if(tempMode.equals("Month"))
			{

				while(rs.next())
					{
    
						++colSpanCount;
						String dt = rs.getString("admin_time");
						hrsHtml =hrsHtml+"<TR><TD align='right' class='label'> "+colSpanCount + "</TD><TD>"+"<SELECT name='repeat_"+colSpanCount+"'>";
						for(int j=1; j<=30; j++)
						{
							if(rs.getString("admin_day")!=null) // condition written to prevent null pointer exception from existing old records
							{
								if(Integer.parseInt(rs.getString("admin_day"))==j)
								{
									hrsHtml =hrsHtml+"<OPTION value='"+j+"' selected>"+j+"</OPTION>";
								
								}
								else
									hrsHtml =hrsHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
							}
							else
									hrsHtml =hrsHtml+"<OPTION value='"+j+"'>"+j+"</OPTION>";
						}
							
						hrsHtml = hrsHtml+"</SELECT></TD><TD>"+"<INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' NAME='time"+colSpanCount+"' value='"+dt+"'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></TD></TR>";

					}
			}
         }else{ //Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2 - START
			 int max_cycle = Integer.parseInt(max_no_of_cycle_p.trim());
			 int repeats   = Integer.parseInt(repeat_val.trim());
			 int i=0;
			 int j=0;
			 if(tempMode.equals("Day"))
			{
				String prevDay	= "";
				while(rs.next())
					{
							String admin_day = rs.getString("admin_day");
							if(!prevDay.equals(admin_day)){
								j=1;
								i++;
								prevDay	= rs.getString("admin_day");
								hrsHtml =hrsHtml+"<TR><TD align='right' class='label'>  "+i + "</TD>";
								hrsHtml =hrsHtml+"<TD><INPUT class='label' TYPE='text' size='5' maxlength='2' NAME='repeat_D"+i+"' value='"+admin_day+"' onkeypress='return CheckForNumber(event);' onBlur='CheckPositiveNumber(this)' ></TD>";
								hrsHtml	= hrsHtml+"<TD>";
							}
									String dt = rs.getString("admin_time");
									hrsHtml = hrsHtml+"<INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' NAME='row_"+i+"_time_"+j+"' value='"+dt+"'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
							
								if(!prevDay.equals(admin_day)){
										hrsHtml	= hrsHtml+"</TD>";
									hrsHtml =hrsHtml+"</TR>";
								}
								j++;
					}
			}
			if(tempMode.equals("Week"))
			{
				String prevWeek	= "";
				while(rs.next())
					{
							String admin_day = rs.getString("admin_day");
							String admin_week = rs.getString("ADMIN_WEEK");
							if(!prevWeek.equals(admin_week)){
								j=1;
								i++;
								prevWeek	= rs.getString("admin_week");
								hrsHtml =hrsHtml+"<TR><TD align='right' class='label'>  "+i + "</TD>";

								hrsHtml =hrsHtml+"<TD><INPUT class='label' TYPE='text' size='5' maxlength='2' NAME='repeat_W"+i+"' value='"+admin_week+"' onkeypress='return CheckForNumber(event);' onBlur='CheckPositiveNumber(this)' ></TD><TD>"+"<SELECT name='repeat_D"+i+"'>";
								for(int k=1; k<=7; k++)
								{
									if(rs.getString("admin_day")!=null) // condition written to prevent null pointer exception from existing old records
									{
										if(Integer.parseInt(rs.getString("admin_day"))==k)
											hrsHtml =hrsHtml+"<OPTION value='"+k+"' selected>"+k+"</OPTION>";
										else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
									}
									else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
								}
								hrsHtml	= hrsHtml+"</SELECT></TD><TD>";
							}
									String dt = rs.getString("admin_time");
									hrsHtml = hrsHtml+"<INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' NAME='row_"+i+"_time_"+j+"' value='"+dt+"'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
							
								if(!prevWeek.equals(admin_week)){
										hrsHtml	= hrsHtml+"</TD>";
									hrsHtml =hrsHtml+"</TR>";
								}
								j++;
					}
			}
			if(tempMode.equals("Month"))
			{
				String prevMonth	= "";
				while(rs.next())
					{
							String admin_day = rs.getString("admin_day");
							String admin_month = rs.getString("ADMIN_MONTH");
							if(!prevMonth.equals(admin_month)){
								j=1;
								i++;
								prevMonth	= rs.getString("admin_month");
								hrsHtml =hrsHtml+"<TR><TD align='right' class='label'>  "+i + "</TD><TD>"+"<SELECT name='repeat_L"+i+"' onChange='populateMonths(this,"+i+")'>";
								for(int k=1; k<=12; k++)
								{
									if(rs.getString("admin_month")!=null) // condition written to prevent null pointer exception from existing old records
									{
										if(Integer.parseInt(rs.getString("admin_month"))==k)
											hrsHtml =hrsHtml+"<OPTION value='"+k+"' selected>"+k+"</OPTION>";
										else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
									}
									else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
								}
								hrsHtml =hrsHtml+"</SELECT></TD><TD>"+"<SELECT id='frq_day"+i+"' name='repeat_D"+i+"'>";
								if(admin_month.equals("2")){
								for(int k=1; k<=29; k++)
								{
									if(rs.getString("admin_day")!=null) // condition written to prevent null pointer exception from existing old records
									{
										if(Integer.parseInt(rs.getString("admin_day"))==k)
											hrsHtml =hrsHtml+"<OPTION value='"+k+"' selected>"+k+"</OPTION>";
										else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
									}
									else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
								}
							  }
							  if(admin_month.equals("1") || admin_month.equals("3") || admin_month.equals("5") || admin_month.equals("7") || admin_month.equals("8") || admin_month.equals("10") || admin_month.equals("12") ){
								for(int k=1; k<=31; k++)
								{
									if(rs.getString("admin_day")!=null) // condition written to prevent null pointer exception from existing old records
									{
										if(Integer.parseInt(rs.getString("admin_day"))==k)
											hrsHtml =hrsHtml+"<OPTION value='"+k+"' selected>"+k+"</OPTION>";
										else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
									}
									else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
								}
							  }
							  if(admin_month.equals("4") || admin_month.equals("6") || admin_month.equals("9") || admin_month.equals("11")){
								for(int k=1; k<=30; k++)
								{
									if(rs.getString("admin_day")!=null) // condition written to prevent null pointer exception from existing old records
									{
										if(Integer.parseInt(rs.getString("admin_day"))==k)
											hrsHtml =hrsHtml+"<OPTION value='"+k+"' selected>"+k+"</OPTION>";
										else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
									}
									else
											hrsHtml =hrsHtml+"<OPTION value='"+k+"'>"+k+"</OPTION>";
								}
							  }
								hrsHtml	= hrsHtml+"</SELECT></TD><TD>";
							}
									String dt = rs.getString("admin_time");
									hrsHtml = hrsHtml+"<INPUT class='label' TYPE='text' onBlur='parent.timeChk(this);' size='5' maxlength='5' NAME='row_"+i+"_time_"+j+"' value='"+dt+"'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
							
								if(!prevMonth.equals(admin_month)){
										hrsHtml	= hrsHtml+"</TD>";
									hrsHtml =hrsHtml+"</TR>";
								}
								j++;
					}
			}
		 } //Added by Sangeetha on 11th Jul 2017 for ML-MMOH-CRF-0345.2 - END
		}catch(Exception e)
			{
				e.printStackTrace();
				tempChk.append("e=" +e.getMessage());
				return null;
			}
		finally
			{
				try
				 {
					
					if(rs!=null) rs.close();
						closeConnection(connection);
				 } catch(Exception e){e.printStackTrace();}
			 }

				
			return(hrsHtml);
	}
	


}//ENd of the class
