/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashMap;
import eXH.XHDBAdapter;
import java.util.regex.*;
import webbeans.eCommon.ConnectionManager;

/*
 * Class is used to get the results of the SQL query to poupulate listbox values in jsps 
 * 
 */
public class XHReturnArray
{
	
	ResultSet msgtypers=null,facilityrs=null,eventrs=null;
	Statement msgstmt=null,facilitystmt=null,eventstmt=null;
	String stemp="";
	
	String A[][]=null;
	ArrayList  arraylist=null;

	public String[][] returnArray(Connection con ,String sql,String locale)
    {

    try{
		con=ConnectionManager.getConnection();
		String facilitysql="SELECT DISTINCT a.facility_id, s.facility_name"+
					" FROM xh_appl_for_facility a, sm_facility_param_lang_vw s"+
					" WHERE a.facility_id = s.facility_id and s.language_id='"+locale+"'"+ 
					" AND a.application_id  = NVL('"+sql+"' , application_id) ";
		facilitystmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	//	System.out.println("facilitysql(auditlog) : "+facilitysql);
		facilityrs=facilitystmt.executeQuery(facilitysql);
		facilityrs.last();
		A=new String[facilityrs.getRow()][2];
		facilityrs.beforeFirst();
		int row=0;
		while(facilityrs.next())
		{
			A[row][1]=facilityrs.getString(1);
			A[row][0]=facilityrs.getString(2) ;
			row++;
		}	
		if( facilityrs!=null) facilityrs.close();
		if( facilitystmt!=null) facilitystmt.close();
		if(con!=null) con.close();
		}catch(Exception e1){			 
			e1.printStackTrace(System.err);
		}
		finally {
			//pstmt.close(); 
			//resultSet.close();	
			XHUtil.closeDBResources(facilityrs, facilitystmt, con);

		}
 
		return A;
	}
 
/*************************************************************************************************/
public String[][] returnMsgArray(Connection con ,String sql,String sql1,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	String msgsql="SELECT 	DISTINCT ae.message_type , me.description "+
						" FROM 	xh_appl_for_facility m, XH_EVENT_TYPE ae , XH_MESSAGE_TYPE_LANG_VW me"+
			" WHERE 	ME.MESSAGE_TYPE =  ae.message_type  and me.language_id='"+locale+"'"+ 
			" AND M.APPLICATION_ID = NVL('"+sql+"', M.APPLICATION_ID) "+
			" AND M.FACILITY_ID = NVL('"+sql1+"', M.FACILITY_ID)";

	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	//System.out.println("msgsql(auditlog) : "+msgsql);
	msgtypers=msgstmt.executeQuery(msgsql);
	msgtypers.last();
	A=new String[msgtypers.getRow()][2];
	msgtypers.beforeFirst();
	int row=0;
	while(msgtypers.next())
		{
		  A[row][1]=msgtypers.getString(1);
		  A[row][0]=msgtypers.getString(2) ;
		 row++;
		}	
		 if( msgtypers!=null) msgtypers.close();
         if( msgstmt!=null) msgstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){			            
			e1.printStackTrace(System.err);
		}
 
	return A;
	}

/******************************************************************************************************/

public String[][] returnEventArray(Connection con ,String sql,String sql1,String sql2,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	String eventsql="SELECT 	DISTINCT ME.EVENT_TYPE , me.EVENT_NAME "+
		" FROM 	XH_APPL_EVENT_SEGMENT m,  XH_EVENT_TYPE_LANG_VW me "+
        " WHERE 	M.EVENT_TYPE =  Me.EVENT_type  and me.language_id='"+locale+"'"+ 
        " AND M.APPLICATION_ID = NVL('"+sql+"', M.APPLICATION_ID)"+
       // " AND M.FACILITY_ID = NVL('"+sql1+"', M.FACILITY_ID)"+
        " AND Me.MESSAGE_TYPE = NVL('"+sql2+"', Me.MESSAGE_TYPE  )";
	eventstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
//	System.out.println("eventsql(auditlog) : "+eventsql);
	eventrs=eventstmt.executeQuery(eventsql);
	eventrs.last();
	A=new String[eventrs.getRow()][2];
	eventrs.beforeFirst();
	int row=0;
	while(eventrs.next())
		{
		  A[row][1]=eventrs.getString(1);
		  A[row][0]=eventrs.getString(2) ;
		 row++;
		}	
		 if( eventrs!=null) eventrs.close();
         if( eventstmt!=null) eventstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){            
			e1.printStackTrace(System.err);
		}
 
	return A;
	}
/*************************************************************************************************/
public String[][] returnFacilityQueryArray(Connection con ,String sql,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	String eventsql="SELECT DISTINCT a.facility_id, s.facility_name "+
			" FROM 	xh_appl_for_facility a, sm_facility_param_lang_vw s "+
			" WHERE	a.facility_id = s.facility_id  and s.language_id='"+locale+"'"+ 
             " AND a.application_id  = NVL('"+sql+"' , application_id)";
	eventstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
//	System.out.println("facility(query) : "+eventsql);
	eventrs=eventstmt.executeQuery(eventsql);
	eventrs.last();
	A=new String[eventrs.getRow()][2];
	eventrs.beforeFirst();
	int row=0;
	while(eventrs.next())
		{
		  A[row][1]=eventrs.getString(1);
		  A[row][0]=eventrs.getString(2) ;
		 row++;
		}	
		 if( eventrs!=null) eventrs.close();
         if( eventstmt!=null) eventstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){            
			e1.printStackTrace(System.err);}
 
	return A;
	}
/***************************************************************************************************/
public String[][] returnDebugFacilityArray(Connection con ,String sql,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	String eventsql="SELECT 		DISTINCT a.facility_id, s.facility_name"+
	" FROM 		xh_appl_for_facility a, sm_facility_param_lang_vw s"+
	" WHERE 		a.facility_id = s.facility_id and s.language_id='"+locale+"'"+ 
	" AND 		a.application_id  = NVL('"+sql+"', application_id)";
	eventstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	//System.out.println("facility(debug) : "+eventsql);
	eventrs=eventstmt.executeQuery(eventsql);
	eventrs.last();
	A=new String[eventrs.getRow()][2];
	eventrs.beforeFirst();
	int row=0;
	while(eventrs.next())
		{
		  A[row][1]=eventrs.getString(1);
		  A[row][0]=eventrs.getString(2) ;
		 row++;
		}	
		 if( eventrs!=null) eventrs.close();
         if( eventstmt!=null) eventstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){			            
						e1.printStackTrace(System.err);}
 
	return A;
	}
/***************************************************************************************************/
/*************************************************************************************************/
public String[][] returndebugeventArray(Connection con ,String sql,String sql1,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	String msgsql="SELECT 	DISTINCT me.EVENT_TYPE , me.EVENT_NAME"+
	" FROM 	XH_APPL_EVENT_SEGMENT m,  XH_EVENT_TYPE_LANG_VW me"+
	" WHERE 	M.APPLICATION_ID = NVL('"+sql+"', M.APPLICATION_ID) and me.language_id='"+locale+"'"+ 
	" AND m.event_TYPE  = ME.EVENT_TYPE";
    //" AND M.FACILITY_ID = NVL('"+sql1+"', M.FACILITY_ID)";
	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	//System.out.println("event(debug) : "+msgsql);
	msgtypers=msgstmt.executeQuery(msgsql);
	msgtypers.last();
	A=new String[msgtypers.getRow()][2];
	msgtypers.beforeFirst();
	int row=0;
	while(msgtypers.next())
		{
		  A[row][1]=msgtypers.getString(1);
		  A[row][0]=msgtypers.getString(2) ;
		 row++;
		}	
		 if( msgtypers!=null) msgtypers.close();
         if( msgstmt!=null) msgstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){            
			e1.printStackTrace(System.err);}
 
	return A;
	}


/***************************************************************************************************/
// TREEE   
/*************************************************************************************************/
// To check whether records exist or not 
/*************************************************************************************************/

public String[][] checkStatus(Connection con ,String appln_id,String facility_id,
                               String message_type,String event_type,String msg_date,String msg_id,String patient_id,
                               String msg_status,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	
	String msgsql="SELECT DISTINCT message_type,description"+
" FROM xh_application_message_lang_vw "+
" WHERE application_id = NVL('"+appln_id+"',application_id)"+
" AND facility_id = NVL('"+facility_id+"',facility_id) and language_id='"+locale+"'"+ 
" AND message_type= NVL('"+message_type+"',message_type) "+
" AND event_type= NVL('"+event_type+"',event_type)"+
" AND TO_CHAR(message_date,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(message_date,'DD/MM/YYYY')) "+
" AND message_id = NVL('"+msg_id+"',message_id) "+
" AND patient_id = NVL('"+patient_id+"',patient_id) ";
//" AND message_status = NVL('"+msg_status+"',message_status) ";


msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
//System.out.println("chkstatus sql ::"+msgsql);

msgtypers=msgstmt.executeQuery(msgsql);
msgtypers.last();
A=new String[msgtypers.getRow()][2];
msgtypers.beforeFirst();
int row=0;
while(msgtypers.next())
{
	  A[row][1]=msgtypers.getString(1);
	  A[row][0]=msgtypers.getString(2) ;
	  row++;
}	
if( msgtypers!=null) msgtypers.close();
if( msgstmt!=null) msgstmt.close();
if(con!=null) con.close();
}catch(Exception e1){          
			e1.printStackTrace(System.err);}
 
return A;
}

/*************************************************************************************************/
// To get the values 
/*************************************************************************************************/

public ArrayList getArrayList(Connection con ,String appln_id,String facility_id,
                               String message_type,String event_type,String msg_date,String msg_id,String patient_id,
                               String msg_status,String locale)
{

    try{
	con=ConnectionManager.getConnection();

	String msgsql="SELECT DISTINCT message_type,description,event_type,event_name,TO_CHAR(message_date,'DD/MM/YYYY'),message_id "+
" FROM xh_application_message_lang_vw "+
" WHERE application_id = NVL('"+appln_id+"',application_id)"+
" AND facility_id = NVL('"+facility_id+"',facility_id) and language_id='"+locale+"'"+ 
" AND message_type= NVL('"+message_type+"',message_type) "+
" AND event_type= NVL('"+event_type+"',event_type)"+
" AND TO_CHAR(message_date,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(message_date,'DD/MM/YYYY')) "+
" AND message_id = NVL('"+msg_id+"',message_id) "+
" AND patient_id = NVL('"+patient_id+"',patient_id) ";
//" AND message_status = NVL('"+msg_status+"',message_status) ";
//System.out.println("chkstatus sql ::"+msgsql);
	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	msgtypers=msgstmt.executeQuery(msgsql);
	arraylist=new ArrayList();
	while(msgtypers.next())
		{
		    arraylist.add(msgtypers.getString(1));
			arraylist.add(msgtypers.getString(2));
		    arraylist.add(msgtypers.getString(3));
	        arraylist.add(msgtypers.getString(4));
            arraylist.add(msgtypers.getString(5));
	        arraylist.add(msgtypers.getString(6));
		}	
		 if( msgtypers!=null) msgtypers.close();
         if( msgstmt!=null) msgstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){				
 	  	        e1.printStackTrace(System.err);}
 
	return arraylist;
	}

/*************************************************************************************************/
// To get the event values 
/*************************************************************************************************/

public String[][] checkEvent(Connection con ,String appln_id,String facility_id,
                               String message_type,String event_type,String msg_date,String msg_id,String patient_id,
                               String msg_status,String locale)
    {

    try{
	con=ConnectionManager.getConnection();

String msgsql="SELECT DISTINCT event_type,event_name "+
" FROM xh_application_message_lang_vw "+
" WHERE application_id = NVL('"+appln_id+"',application_id)"+
" AND facility_id = NVL('"+facility_id+"',facility_id) and language_id='"+locale+"'"+ 
" AND message_type= NVL('"+message_type+"',message_type) "+
" AND event_type= NVL('"+event_type+"',event_type)"+
" AND TO_CHAR(message_date,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(message_date,'DD/MM/YYYY')) "+
" AND message_id = NVL('"+msg_id+"',message_id) "+
" AND patient_id = NVL('"+patient_id+"',patient_id) ";
//" AND message_status = NVL('"+msg_status+"',message_status) ";

	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	//System.out.println("chkstatus sql ::"+msgsql);

	msgtypers=msgstmt.executeQuery(msgsql);
	msgtypers.last();
	A=new String[msgtypers.getRow()][2];
	msgtypers.beforeFirst();
	int row=0;
	while(msgtypers.next())
		{
		  A[row][1]=msgtypers.getString(1);
		  A[row][0]=msgtypers.getString(2) ;
		 row++;
		}	
		 if( msgtypers!=null) msgtypers.close();
         if( msgstmt!=null) msgstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){			            
						e1.printStackTrace(System.err);}
 
	return A;
	}


//**************************************************************************************
public String[][] getMsgdateArray(Connection con ,String appln_id,String facility_id,
                               String message_type,String event_type,String msg_date,String msg_id,String patient_id,
                               String msg_status,String locale)
    {

   
    try{
	con=ConnectionManager.getConnection();

	String msgsql="SELECT DISTINCT TO_CHAR(message_date,'DD/MM/YYYY'),TO_CHAR(message_date,'DD/MM/YYYY') "+
" FROM xh_application_message_lang_vw "+
" WHERE application_id = NVL('"+appln_id+"',application_id)"+
" AND facility_id = NVL('"+facility_id+"',facility_id) and language_id='"+locale+"'"+ 
" AND message_type= NVL('"+message_type+"',message_type) "+
" AND event_type= NVL('"+event_type+"',event_type)"+
" AND TO_CHAR(message_date,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(message_date,'DD/MM/YYYY')) "+
" AND message_id = NVL('"+msg_id+"',message_id) "+
" AND patient_id = NVL('"+patient_id+"',patient_id) ";
//" AND message_status = NVL('"+msg_status+"',message_status) ";
  
	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	//System.out.println("chkstatus sql ::"+msgsql);

	msgtypers=msgstmt.executeQuery(msgsql);
	msgtypers.last();
	A=new String[msgtypers.getRow()][2];
	msgtypers.beforeFirst();
	int row=0;
	while(msgtypers.next())
		{
		 // if( msgtypers.getString(2)!=null){
		// A[row][1]= com.ehis.util.DateUtils.convertDate(msgtypers.getString(2),"DMY","en",locale);
		  //}
		  A[row][1]=msgtypers.getString(2) ;
		  A[row][0]=msgtypers.getString(2) ;
		 row++;

		}	
		 if( msgtypers!=null) msgtypers.close();
         if( msgstmt!=null) msgstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){			            
						e1.printStackTrace(System.err);}
 
	return A;
	}



	//**************************************************************************************
public String[][] getMsgidArray(Connection con ,String appln_id,String facility_id,
                               String message_type,String event_type,String msg_date,String msg_id,String patient_id,
                               String msg_status,String locale)
    {

   
    try{
	con=ConnectionManager.getConnection();

	String msgsql="SELECT DISTINCT message_id,message_id "+
" FROM xh_application_message_lang_vw "+
" WHERE application_id = NVL('"+appln_id+"',application_id)"+
" AND facility_id = NVL('"+facility_id+"',facility_id) and language_id='"+locale+"'"+ 
" AND message_type= NVL('"+message_type+"',message_type) "+
" AND event_type= NVL('"+event_type+"',event_type)"+
" AND TO_CHAR(message_date,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(message_date,'DD/MM/YYYY')) "+
" AND message_id = NVL('"+msg_id+"',message_id) "+
" AND patient_id = NVL('"+patient_id+"',patient_id) ";
//" AND message_status = NVL('"+msg_status+"',message_status) ";
  
	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	//System.out.println("chkstatus sql ::"+msgsql);

	msgtypers=msgstmt.executeQuery(msgsql);
	msgtypers.last();
	A=new String[msgtypers.getRow()][2];
	msgtypers.beforeFirst();
	int row=0;
	while(msgtypers.next())
		{
		  A[row][1]=msgtypers.getString(1);
		  A[row][0]=msgtypers.getString(2) ;
		 row++;

		}	
		 if( msgtypers!=null) msgtypers.close();
         if( msgstmt!=null) msgstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){			            
						e1.printStackTrace(System.err);}
 
	return A;
	}
//*****************************************************************************************
public ArrayList returnArrayList(Connection con,String sq1,String sq2,String sq3,String locale)
    {

   
    try{
	con=ConnectionManager.getConnection();
	String msgsql="SELECT message_type,description,event_type,event_name"+
" FROM xh_application_message_vw "+
" WHERE application_id = NVL('"+sq1+"',application_id)"+
" AND facility_id = NVL('"+sq2+"',facility_id) and language_id='"+locale+"'"+
" AND message_id = NVL('"+sq3+"',message_id) ";
//" AND message_status = NVL('',message_status)";

   
	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	msgtypers=msgstmt.executeQuery(msgsql);
	arraylist=new ArrayList();
	while(msgtypers.next())
		{
		    arraylist.add(msgtypers.getString(1));
			arraylist.add(msgtypers.getString(2));
		    arraylist.add(msgtypers.getString(3));
	        arraylist.add(msgtypers.getString(4));

		}	
		 if( msgtypers!=null) msgtypers.close();
         if( msgstmt!=null) msgstmt.close();
		 if(con!=null) con.close();
		}catch(Exception e1){
 	  	        e1.printStackTrace(System.err);}
 
	return arraylist;
	
	}



/*************************************************************************************************/
//
/*************************************************************************************************/
public String returnmsgText(Connection con ,String sq1,String sq2,String sq3,String sq4,String sq5)
    {

    try{
	con=ConnectionManager.getConnection();
	String msgsql="SELECT  MESSAGE_TEXT"+
" FROM xh_application_message_vw "+
" WHERE application_id = NVL('"+sq1+"',application_id)"+
" AND facility_id = NVL('"+sq2+"',facility_id)"+
" AND message_type= NVL('"+sq3+"',message_type) "+
" AND event_type= NVL('"+sq4+"',event_type)"+
" AND message_id = NVL('"+sq5+"',message_id) ";
//" AND NVL(MESSAGE_STATUS,'')=NVL('"+msg_status+"',MESSAGE_STATUS)";
//" AND message_status = NVL('',message_status)";
   msgstmt=con.createStatement();
   msgtypers=msgstmt.executeQuery(msgsql);
   while(msgtypers.next())
   {
	  
	    stemp=msgtypers.getString("MESSAGE_TEXT");
		
	}
   
	if( msgtypers!=null) msgtypers.close();
    if( msgstmt!=null) msgstmt.close();
	if(con!=null) con.close();
	}catch(Exception e1){         
  		 e1.printStackTrace(System.err);}
    // System.out.println("stemp :"+stemp);
	return stemp;
	}

//********************************************************************************************
//    Tree values for inbound con,appl_name,client_id,msg_date,msgg_id,msg_status,locale
/*************************************************************************************************/
public String[][] returnInbound(Connection con ,String appl_name,String client_id,
	                             String msg_date,String msgg_id,String msg_status,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	String msgsql="SELECT  distinct TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY'),TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY')"+
" FROM XH_INBOUND_MESSAGE"+
" WHERE APPLICATION_ID=NVL('"+appl_name+"',APPLICATION_ID)"+
" AND CLIENT_ID=NVL('"+client_id+"',CLIENT_ID)"+
" AND TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY')) "+
" AND MESSAGE_ID=NVL('"+msgg_id+"',MESSAGE_ID)";
//" AND MESSAGE_STATUS=NVL('"+msg_status+"',MESSAGE_STATUS)";


	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	//	System.out.println("INBOUND STATUS  sql ::"+msgsql);

	msgtypers=msgstmt.executeQuery(msgsql);
	msgtypers.last();
	A=new String[msgtypers.getRow()][2];
	msgtypers.beforeFirst();
	int row=0;
	while(msgtypers.next())
		{
		  A[row][1]=msgtypers.getString(1);
		  A[row][0]=msgtypers.getString(2) ;
		 row++;

		}	
	 if( msgtypers!=null) msgtypers.close();
     if( msgstmt!=null) msgstmt.close();
	 if(con!=null) con.close();
	}catch(Exception e1){		
		e1.printStackTrace(System.err);}
     //System.out.println("stemp :"+stemp);
	return A;
	}


public String[][] returnInboundmsgid(Connection con ,String appl_name,String client_id,
	                             String msg_date,String msgg_id,String msg_status,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	String msgsql="SELECT  MESSAGE_ID,MESSAGE_ID"+
" FROM XH_INBOUND_MESSAGE"+
" WHERE APPLICATION_ID=NVL('"+appl_name+"',APPLICATION_ID)"+
" AND CLIENT_ID=NVL('"+client_id+"',CLIENT_ID)"+
" AND TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY')) "+
" AND MESSAGE_ID=NVL('"+msgg_id+"',MESSAGE_ID)";
//" AND MESSAGE_STATUS=NVL('"+msg_status+"',MESSAGE_STATUS)";


	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
		//System.out.println("INBOUND MESSAGE_ID  sql ::"+msgsql);

	msgtypers=msgstmt.executeQuery(msgsql);
	msgtypers.last();
	A=new String[msgtypers.getRow()][2];
	msgtypers.beforeFirst();
	int row=0;
	while(msgtypers.next())
		{
		  A[row][1]=msgtypers.getString(1);
		  A[row][0]=msgtypers.getString(2) ;
		 row++;

		}	
	if( msgtypers!=null) msgtypers.close();
    if( msgstmt!=null) msgstmt.close();
	if(con!=null) con.close();
	}catch(Exception e1){		
		e1.printStackTrace(System.err);}
    // System.out.println("stemp :"+stemp);
	return A;
	}

public String[][] getClient_id(Connection con ,String appl_name,String client_id,
	                             String msg_date,String msgg_id,String msg_status,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	String msgsql="SELECT  CLIENT_ID,CLIENT_ID"+
" FROM XH_INBOUND_MESSAGE"+
" WHERE APPLICATION_ID=NVL('"+appl_name+"',APPLICATION_ID)"+
" AND CLIENT_ID=NVL('"+client_id+"',CLIENT_ID)"+
" AND TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY') = NVL('"+msg_date+"', TO_CHAR(MESSAGE_RECEIVED_DATE,'DD/MM/YYYY')) "+
" AND MESSAGE_ID=NVL('"+msgg_id+"',MESSAGE_ID)";
//" AND NVL(MESSAGE_STATUS,'')=NVL('"+msg_status+"',MESSAGE_STATUS)";
//" AND MESSAGE_STATUS=NVL('"+msg_status+"',MESSAGE_STATUS)";
//	AND NVL(MESSAGE_STATUS,'')=NVL('"+msg_status+"',MESSAGE_STATUS)";

	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	//	System.out.println("INBOUND CLIENT_ID  sql ::"+msgsql);

	msgtypers=msgstmt.executeQuery(msgsql);
	msgtypers.last();
	A=new String[msgtypers.getRow()][2];
	msgtypers.beforeFirst();
	int row=0;
	while(msgtypers.next())
		{
		  A[row][1]=msgtypers.getString(1);
		  A[row][0]=msgtypers.getString(2) ;
		 row++;

		}	
	if( msgtypers!=null) msgtypers.close();
    if( msgstmt!=null) msgstmt.close();
	if(con!=null) con.close();
	}catch(Exception e1){		
		e1.printStackTrace(System.err);}
    // System.out.println("stemp :"+stemp);
	return A;
	}




/*************************************************************************************************/








public String[][] returnsmesgType(Connection con ,String sq1,String sq2,String sq3,String locale)
    {

    try{
	con=ConnectionManager.getConnection();
	String msgsql="SELECT  distinct message_type ,DESCRIPTION"+
" FROM xh_application_message_lang_vw "+
" WHERE application_id = NVL('"+sq1+"',application_id) and language_id='"+locale+"'"+
" AND facility_id = NVL('"+sq2+"',facility_id)"+
" AND event_type= NVL('"+sq3+"',event_type)";
//" AND message_status = NVL('',message_status)";


	msgstmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
	msgtypers=msgstmt.executeQuery(msgsql);
	msgtypers.last();
	A=new String[msgtypers.getRow()][2];
	msgtypers.beforeFirst();
	int row=0;
	while(msgtypers.next())
		{
		  A[row][1]=msgtypers.getString(1);
		  A[row][0]=msgtypers.getString(2) ;
		 row++;

		}	
	if(msgtypers!=null) msgtypers.close();
	if(msgstmt!=null) msgstmt.close(); 
	if(con!=null) con.close();
	}catch(Exception e1){		
		e1.printStackTrace(System.err);}
//	System.out.println("stemp :"+stemp);
	return A;
	}

//*************************************************************************************************
public HashMap returnsSegmentArray(String msgtext )
 {
Connection con=null;
String individualSegment="";
String segmentSeparator="";
char separatorDelimiter;
char firstCharOfMSH;
String segmentName="";
String A[][]=null;
String comp[][]=null;
HashMap hashmap=new HashMap();
boolean chkStat=false;
int leng=0;
chkStat=containsSubstring(msgtext,"MSH");
try{
con=ConnectionManager.getConnection();
separatorDelimiter=msgtext.charAt((msgtext.length())-1);
 if(chkStat){ segmentSeparator=""+separatorDelimiter; }
 else { segmentSeparator=""; } 
StringTokenizer st=new StringTokenizer(msgtext,segmentSeparator);
if(chkStat) leng=st.countTokens()-1;
else  leng=st.countTokens();

A=new String[leng][2];
int row=0;
while (st.hasMoreTokens())
{
          ResultSet rss=null;
          Statement stmts=null;
		  individualSegment=st.nextToken().trim();
		  if(individualSegment.length()!=0){
          firstCharOfMSH=individualSegment.charAt(0);
		  if(chkStat){
		  if (firstCharOfMSH==separatorDelimiter) segmentName=individualSegment.substring(1,4);
		  else segmentName=individualSegment.substring(0,3);
		  }
		  else {
			     segmentName=individualSegment.substring(0,2);
		      } 
		  A[row][0]=segmentName;
		  String msgsql1="SELECT segment_name FROM xh_segment WHERE segment_type ='"+segmentName+"'";
		  stmts=con.createStatement();
		  rss=stmts.executeQuery(msgsql1);
		  while(rss.next()){		  
		  A[row][1]= rss.getString(1);		 
		  }
		  if(rss!=null) rss.close();
		  if(stmts!=null) stmts.close(); 
          comp=getSegmentComponents(con,msgtext,individualSegment);
		  hashmap.put("comp"+row,comp);
		  row++;
} 
}
if(con!=null) con.close();
}catch(Exception e1){
	             e1.printStackTrace(System.err);}
hashmap.put("segment",A);
return hashmap;
}
///************************************************************************************************************

private String[][] getSegmentComponents(Connection con,String msgtext,String segmentString)
	{
		char firstCharOfMSH;
		String segmentName=null;
		String tempSegment=null;
		String[] components=null;
        ResultSet rss=null;
        Statement stmts=null;
		String A[][]=null;
		boolean chkStat=false;
      

		try
		{	
			tempSegment=segmentString.trim();
			firstCharOfMSH=tempSegment.charAt(0);
		
		    chkStat=containsSubstring(msgtext,"MSH");
			if(chkStat)	{
			if (firstCharOfMSH=='') segmentName=tempSegment.substring(1,4);
			else segmentName=tempSegment.substring(0,3);
			}
			else segmentName=tempSegment.substring(0,2);

			components= tempSegment.split("\\|");
			int leng=0;
			leng=components.length-1;
			A=new String[leng][2];
		    stmts=con.createStatement();
			int row=0;
		    for(int i=1;i<components.length; i++)
			{				
				String msgsql1="SELECT element_name FROM xh_segment_element_seq WHERE segment_type ='"+segmentName+"' and element_seq ="+i ;				
				rss=stmts.executeQuery(msgsql1);
				while(rss.next()){
		        A[row][0]= rss.getString(1);
				A[row][1]= components[i];
		        }
				if(rss!=null) rss.close();
		  
			  row++;			
			}
			if(stmts!=null) stmts.close(); 
	      segmentName=null;
		}catch(Exception exception)
		  {			
			exception.printStackTrace(System.err);
			
		  }
       return A;
	}


 public boolean  containsSubstring(String mainString, String subString)
  {
     boolean status = false; 
     Pattern pattern = Pattern.compile(subString);
	 Matcher matcher = pattern.matcher(mainString); 
	 status = matcher.find();
	 return status; 
  }
///************************************************************************************************************

}
