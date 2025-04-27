/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. 
 ******************************************************************************/
package eCommon.Common ;

import java.util.* ;
import java.io.* ;
import java.sql.* ;
import java.util.*;
import javax.servlet.http.* ;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspWriter;
import java.net.*;

import webbeans.eCommon.ConnectionManager;


import eCommon.Common.* ;

import org.apache.commons.codec.binary.*;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.parser.JSONParser;
import org.json.simple.*;

public class CommonBean extends CommonAdapter implements Serializable {

    public CommonBean() {
        try {
            doCommon();
        }catch(Exception e) {}
    }

    private void doCommon() throws Exception {

    }
/**
 *
 * @param request   HttpServletRequest object
 * @return  HashMap that holds all the request parameters and the values
 */
    public HashMap parseRequest(HttpServletRequest request) throws Exception {
        String element_name  = "";
        String element_value = "";

        HashMap hmElements          = new HashMap();
		request.setCharacterEncoding("UTF-8");
        Enumeration enumElements    = request.getParameterNames();

        while(enumElements.hasMoreElements()) {
            element_name        = (String)enumElements.nextElement();
            element_value       = checkForNull(request.getParameter(element_name) );
            hmElements.put( element_name, element_value );
        }

        return hmElements;
    }

/**
 *Specific to MP module for getting the details for Online Reports
 * @param p_patient_id  Patient ID
 * @param p_facility_id   Facility ID
 * @return  HashMap containing  facility_name, patient_name, sex, date_of_birth and file_no
 */
    public HashMap getDataMPOnlineReport( String p_patient_id, String p_facility_id ) {
        Connection con          = null ;
        PreparedStatement pstmt = null ;
        ResultSet rs            = null ;
        HashMap dataMap         = new HashMap() ;
        StringBuffer msgsb      = null ;

        try {
            msgsb = new StringBuffer() ;
            con = getConnection() ;
            msgsb.append( con );
            pstmt = con.prepareStatement( "select facility_name from sm_facility_param where facility_id = ? " ) ;
            msgsb.append( "pstmt 1 : " + pstmt );
            pstmt.setString( 1, p_facility_id ) ;
            rs = pstmt.executeQuery() ;
            msgsb.append( "rs 1 : " + rs );
            if ( rs != null && rs.next() ) {
                dataMap.put( "facility_name", rs.getString( "facility_name" ) ) ;
                msgsb.append( "facility_name ="+rs.getString( "facility_name" ) );
            }
            if( rs != null ) closeResultSet( rs ) ;
            if( pstmt != null ) closeStatement( pstmt ) ;

            pstmt = con.prepareStatement( "select patient_name, sex, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth from mp_patient where patient_id = ?" ) ;
            msgsb.append( "pstmt 2 : " + pstmt );
            pstmt.setString( 1, p_patient_id ) ;
            rs = pstmt.executeQuery() ;
            msgsb.append( "rs 2 : " + rs );

            if ( rs != null && rs.next() ) {
                dataMap.put( "patient_name", rs.getString( "patient_name" ) ) ;
                msgsb.append( "patient_name ="+rs.getString( "patient_name" ) );
                dataMap.put( "sex", rs.getString( "sex" ) ) ;
                msgsb.append( "sex ="+rs.getString( "sex" ) );
                dataMap.put( "date_of_birth", rs.getString( "date_of_birth" ) ) ;
                msgsb.append( "date_of_birth ="+rs.getString( "date_of_birth" ) );
            }
			if( rs != null ) closeResultSet( rs ) ;
            if( pstmt != null ) closeStatement( pstmt ) ;
            pstmt = con.prepareStatement( "select file_no from mr_pat_file_index where patient_id = ? and facility_id = ?" ) ;
            msgsb.append( "pstmt 3 : " + pstmt );
            pstmt.setString( 1, p_patient_id ) ;
            pstmt.setString( 2, p_facility_id ) ;
            rs = pstmt.executeQuery() ;
            msgsb.append( "rs 3 : " + rs );

            if ( rs != null && rs.next() ) {
                dataMap.put( "file_no", rs.getString( "file_no" ) ) ;
                msgsb.append( "file_no ="+rs.getString( "file_no" ) );
            }

        } catch ( Exception e ) {
            msgsb.append( "exception 1 : " + e );
            System.err.println( e ) ;
        } finally {
            try {
                if ( rs != null ) closeResultSet( rs ) ;
                if ( pstmt != null ) closeStatement( pstmt ) ;
                if ( con != null ) closeConnection( con ) ;
            } catch ( Exception ee ) {
                msgsb.append( "exception 2 : " + ee );
            }
            dataMap.put( "error", msgsb.toString() );
        }

        return dataMap ;
    }

/**
 *
 * @param sqlMap
 * @param funcMap
 * @param req
 * @param lookup
 * @return
 * @throws Exception
 *  deprecated. Refer getQueryResultPage

    public ArrayList getQueryResultPageTest (PageContext pageContext, HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup ) throws Exception {
        return getQueryResultPageTest (pageContext, sqlMap, funcMap, req, lookup, true );
    }
*/
/**
 *
 * @param sqlMap
 * @param funcMap
 * @param req
 * @param lookup
 * @param master_function
 * @return
 * @throws Exception
 *deprecated. Refer getQueryResultPage

    public ArrayList getQueryResultPageTest (PageContext pageContext, HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup, boolean master_function ) throws Exception {
        StringBuffer msgsb = new StringBuffer();
        Connection connection       = null;
        String[] orderbycolumns     = req.getParameterValues("orderbycolumns") ;
        msgsb.append("Trace Starts ");
        msgsb.append(lookup) ;
        msgsb.append(master_function);
        if( !lookup && master_function ) {
            msgsb.append("for orderbycolumns");
            setOrderby(orderbycolumns);
        }
        String from                 = req.getParameter( "from" ) ;
        String to                   = req.getParameter( "to" ) ;
        ArrayList displayFields     = (ArrayList)funcMap.get( "displayFields" ) ;
        ArrayList chkFields         = (ArrayList)funcMap.get( "chkFields" ) ;
        String searchCriteria       = checkForNull( (String)funcMap.get( "searchCriteria" )) ;
        String sqlData              = (String)sqlMap.get( "sqlData" );
        ArrayList error             = new ArrayList();
        String prevnextlink         = "";
        int query_result_size       = Integer.parseInt( (String)CommonRepository.getCommonKeyValue( "QUERY_RESULT_SIZE" ) );
        msgsb.append(displayFields);
        msgsb.append(chkFields);

        int start = 0 ;
        int end = 0 ;

        if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from  ) ;

        if ( to == null )
            end =query_result_size;
        else
            end = Integer.parseInt( to ) ;

        PreparedStatement pstmtCount  =null;
        PreparedStatement pstmtData = null;
        ResultSet rs=null;
        int maxRecord = 0;
        ArrayList result = new ArrayList();
        result.clear();
        result.add("total");
        result.add("prevnext");
        try {
            connection=getConnection();
            int fldkey=1;
            try {
                msgsb.append( " SQL : "+sqlData );
                msgsb.append( " Connection : " + connection );
                if( !lookup && master_function ) {
                    msgsb.append("into orderbycolumns");
                    pstmtData = connection.prepareStatement( sqlData + orderBy );
                }
                else
                    pstmtData = connection.prepareStatement( sqlData );
                msgsb.append( " PreparedStatement : " + pstmtData);
                msgsb.append( " chkFields.size() : " + chkFields.size());

                for(int fldcount=0; fldcount<chkFields.size(); fldcount++) {
                    Object fldValue = chkFields.get(fldcount) ;
                    if( fldValue instanceof String ) {
                        if( !lookup ) {
                            msgsb.append(fldkey+":*");
                            msgsb.append((String) chkFields.get(fldcount)+"*");
                            pstmtData.setString( fldkey, ((String) chkFields.get(fldcount)) ) ;
                        }
                        else {
                            msgsb.append(fldkey+":*");
                            msgsb.append((String) chkFields.get(fldcount)+"*");
                            msgsb.append("searchCriteria"+searchCriteria+"*");

                            if( searchCriteria.equals( "S" ) )
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                            else if( searchCriteria.equals( "E" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount)) ) ;
                            else if( searchCriteria.equals( "C" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount))+"%" ) ;
                            else
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                        }
                    }
                    else if ( fldValue instanceof Integer )
                        pstmtData.setInt( fldkey, ((Integer)fldValue).intValue() ) ;
                    else if ( fldValue instanceof Long )
                        pstmtData.setLong( fldkey, ((Long)fldValue).longValue() ) ;
                    else if ( fldValue instanceof Float )
                        pstmtData.setFloat( fldkey, ((Float)fldValue).floatValue() ) ;
                    else if ( fldValue instanceof Double )
                        pstmtData.setDouble( fldkey, ((Double)fldValue).doubleValue() ) ;
                    fldkey++;
                }//for
                rs = null;
                rs = pstmtData.executeQuery();
                msgsb.append( "ResultSet : " + rs);
                long count = 0;
                long i = 0;

				msgsb.append( "start : " + start);
                msgsb.append( "end : " + end);

                if( rs != null ) {

                    while( rs.next() && i <= end+1 ) {
                        if( start != 1 && (i+1) < start ) {
                            i++;
                            continue;
                        }
                        else i++;
                        count++ ;
		                msgsb.append( "i: " + i);
		                msgsb.append( "count: " + count);
                        if(i <= end ) {
                            ArrayList records=new ArrayList();
                            records.clear();
                            msgsb.append( "Before Display flds loop" );
                            for( int dispfldCount=0;  dispfldCount<displayFields.size();  dispfldCount++ ) {
                                records.add(rs.getString((String)displayFields.get( dispfldCount )));
                                msgsb.append( "#"+(String)displayFields.get( dispfldCount )+":"+rs.getString((String)displayFields.get( dispfldCount )));
                            }
                            msgsb.append( "After Display flds loop" );
                            result.add(records);
                        }
                    }
                    msgsb.append( " count:"+count );
                    result.set( 0, String.valueOf( count ) ) ;
                    if( start != 1 )
                        prevnextlink += "<td class=\"WHITE\" align=\"right\"><a href=\"javascript:SubmitLink("+(start-query_result_size)+","+(end-query_result_size)+");\">Previous</A>" ;
                    if( count > 14 )
                        prevnextlink += "&nbsp;&nbsp;<td class=\"WHITE\" align=\"right\"><a href=\"javascript:SubmitLink("+(start+query_result_size)+","+(end+query_result_size)+");\">Next</A>" ;
                    result.set( 1, prevnextlink ) ;
                }

            }catch(Exception ed) {
                error.add("Exception from sqlData :" +ed.getMessage()+msgsb.toString() );
                result.add(error);
            } finally {
                //result.add(msgsb.toString());
            }
        } catch(Exception ex) {
                error.add(ex.getMessage());
                result.add(error);
        } finally {
            try{
                if( rs != null ) closeResultSet( rs ) ;
                if( pstmtData != null ) closeStatement( pstmtData ) ;
                if( pstmtCount != null ) closeStatement( pstmtCount ) ;
                if ( connection != null ) closeConnection( connection ) ;
            } catch(Exception e) {
                error.add(e.getMessage());
                result.add(error);
            }
            result.add(msgsb.toString());
        }
        return result;
    }
*/


/**
 *
 * @param sqlMap    HashMap that holds SQL statements
 * @param funcMap    Functional Fields like  displayFields, chkFields, searchCriteria
 * @param req   HTTPServletRequest
 * @return   ArrayList containing the data
 * @throws Exception
 */
    public ArrayList getQueryResultPage (PageContext pageContext, HashMap sqlMap, HashMap funcMap, HttpServletRequest req ) throws Exception {
        return getQueryResultPage(pageContext, sqlMap, funcMap, req, false, Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") ) );
    }
/**
 *
 * @param sqlMap    HashMap that holds SQL statements
 * @param funcMap   Functional Fields like  displayFields, chkFields, searchCriteria
 * @param req           HTTPServletRequest
 * @param lookup        Decides whether call is made from lookup or not
 * @return                  ArrayList containing the data
 * @throws Exception
 */
    public ArrayList getQueryResultPage (PageContext pageContext, HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup  ) throws Exception {
        return getQueryResultPage(pageContext, sqlMap, funcMap, req, lookup, Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") ) );
    }

    /**
     *
     * @param sqlMap    HashMap that holds SQL statements
     * @param funcMap   Functional Fields like  displayFields, chkFields, searchCriteria
     * @param req           HTTPServletRequest
     * @param query_result_size Number of records to fetch in as part of single call
     * @return                  ArrayList containing the data
     * @throws Exception
 */
    public ArrayList getQueryResultPage (PageContext pageContext, HashMap sqlMap, HashMap funcMap,HttpServletRequest req,int query_result_size ) throws Exception {
        return getQueryResultPage(pageContext, sqlMap, funcMap, req, false, query_result_size );
    }

    private ArrayList getQueryResultPage (PageContext pageContext,HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup, int query_result_size ) throws Exception {
        Connection connection       = null;
		req.setCharacterEncoding("UTF-8");
        String[] orderbycolumns     = req.getParameterValues("orderbycolumns") ;
        if(orderbycolumns == null)  orderbycolumns = new String[0] ;
        if( !lookup && orderbycolumns.length>0 ) setOrderby(orderbycolumns);
        String from                 = req.getParameter( "from" ) ;
        String to                   = req.getParameter( "to" ) ;
        ArrayList displayFields     = (ArrayList)funcMap.get( "displayFields" ) ;
        ArrayList chkFields         = (ArrayList)funcMap.get( "chkFields" ) ;
        String searchCriteria       = checkForNull( (String)funcMap.get( "searchCriteria" )) ;
        String sqlData              = (String)sqlMap.get( "sqlData" );
        ArrayList error             = new ArrayList();
        String prevnextlink         = "";
        //int query_result_size       = Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );
//System.out.println("chkFields :" +chkFields);


        StringBuffer msgsb = new StringBuffer();
        int start = 0 ;
        int end = 0 ;

        if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from  ) ;

        if ( to == null )
            end =query_result_size;
        else
            end = Integer.parseInt( to ) ;

        PreparedStatement pstmtCount  =null;
        PreparedStatement pstmtData = null;
        ResultSet rs=null;
        //int maxRecord = 0;
        ArrayList result = new ArrayList();
        result.clear();
        result.add("total");
        result.add("prevnext");
        try {
            HttpSession session = req.getSession(false) ;
            setProperties((java.util.Properties)session.getValue("jdbc")) ;

            connection=getConnection();
            int fldkey=1;
            try {
                msgsb.append( " SQL : "+sqlData );
                msgsb.append( " Connection : " + connection );
				
				// added scrollable prepared stmt by Marwan to solve the next hyperlink no records to be retrieved issues (EDGE-WORK)
                if( !lookup && orderbycolumns.length>0 )
                    pstmtData = connection.prepareStatement( sqlData + orderBy , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                else
                    pstmtData = connection.prepareStatement( sqlData , ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                msgsb.append( " PreparedStatement : " + pstmtData);
//System.out.println("chkFields1 :" +chkFields);

                for(int fldcount=0; fldcount<chkFields.size(); fldcount++) {
                    Object fldValue = chkFields.get(fldcount) ;
				//	System.out.println("fldValue :" +fldValue);

				//	System.out.println("(String) chkFields.get(fldcount)) :" +(String) chkFields.get(fldcount));
                    if( fldValue instanceof String ) {
                        if( !lookup )
                          pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))) ;
                        else {
                            if( searchCriteria.equals( "S" ) )
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                            else if( searchCriteria.equals( "E" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount)) ) ;
                            else if( searchCriteria.equals( "C" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount))+"%" ) ;
                            else
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                        }
                    }
                    else if ( fldValue instanceof Integer )
                        pstmtData.setInt( fldkey, ((Integer)fldValue).intValue() ) ;
                    else if ( fldValue instanceof Long )
                        pstmtData.setLong( fldkey, ((Long)fldValue).longValue() ) ;
                    else if ( fldValue instanceof Float )
                        pstmtData.setFloat( fldkey, ((Float)fldValue).floatValue() ) ;
                    else if ( fldValue instanceof Double )
                        pstmtData.setDouble( fldkey, ((Double)fldValue).doubleValue() ) ;
                    fldkey++;
                }//for
                rs = null;
                rs = pstmtData.executeQuery();
                msgsb.append( "ResultSet : " + rs);
                
            	/* 
               	done by Marwan - EGDE WORK 
               	there is a problem with rs cursor specially in retrieving pages after page 1
               	so this loop eager loads all the records to solve the issue of no records to be retrieved 
               	even though there are records in the db
             	*/
	            int totalRowsCount = 0;
	            while (rs.next()) {
	            	totalRowsCount++;
	            }
	            rs.beforeFirst();
	            /* Marwan code ended */
                
                long count = 0;
                long i = 0;
				
				
                if( rs != null ) {
                    while( rs.next() && i <= end+1 ) {
                        if( start != 1 && (i+1) < start ) {
                            i++;
                            continue;
                        }
                        else i++;
                        count++ ;
                        if(i <= end ) {
                            ArrayList records=new ArrayList();
                            records.clear();
                            for( int dispfldCount=0;  dispfldCount<displayFields.size();  dispfldCount++ )
                                records.add(rs.getString((String)displayFields.get( dispfldCount )));
                            result.add(records);
                        }
                    }
                    result.set( 0, String.valueOf( count ) ) ;
                    if( start != 1 )
                        prevnextlink += "<td align=\"right\" nowrap><a href=\"javascript:SubmitLink("+(start-query_result_size)+","+(end-query_result_size)+");\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>" ;
                    if( count > query_result_size )
                        prevnextlink += "&nbsp;&nbsp;<td align=\"right\" nowrap><a href=\"javascript:SubmitLink("+(start+query_result_size)+","+(end+query_result_size)+");\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>" ;
                    result.set( 1, prevnextlink ) ;
                }

            }catch(Exception ed) {
                error.add("Exception from sqlData :" +ed.getMessage()+msgsb.toString() );
                result.add(error);
            }
        } catch(Exception ex) {
                error.add(ex.getMessage());
                result.add(error);
        } finally {
            try{
                if( rs != null ) closeResultSet( rs ) ;
                if( pstmtData != null ) closeStatement( pstmtData ) ;
                if( pstmtCount != null ) closeStatement( pstmtCount ) ;
                if ( connection != null ) closeConnection( connection ) ;
            } catch(Exception e) {
                error.add(e.getMessage());
                result.add(error);
            }
        }
        return result;
    }

/**
 *
 * @param req               HttpServletRequest
 * @param nextprevLink  Link text
 * @param searched      Indicates whether search is executed ot not
 * @return                  Constructed HTML String
 */
    public String setForm (HttpServletRequest req, String nextprevLink, boolean searched) throws Exception{

        String queryform="<form name=\"QueryForm\" method=\"post\" action=\""+nextprevLink+"\" >";
		req.setCharacterEncoding("UTF-8");
        Enumeration paramnames =  req.getParameterNames();
        while(paramnames.hasMoreElements()){
            String str=(String)paramnames.nextElement();
            if( !str.equals( "orderbycolumns" ) ) {
                queryform+="<input type=\"hidden\" value=\""+req.getParameter(str)+"\" name=\""+str+"\">" ;
            }
        }
        String[] orderbycolumns = req.getParameterValues("orderbycolumns") ;
        if( orderbycolumns != null )
            for(int i=0 ; i<orderbycolumns.length ; i++) {
                queryform+="<input type=\"hidden\" value=\""+orderbycolumns[i]+"\" name=\"orderbycolumns\">" ;
            }
        if( !searched ) {
            queryform += "<input type=\"hidden\" value=\"\" name=\"from\">" ;
            queryform += "<input type=\"hidden\" value=\"\" name=\"to\">" ;
            queryform += "<input type=\"hidden\" value=\"\" name=\"searched\">" ;
        }
        queryform += "</form>";
        return queryform;
    }

/**
 *  Used in Transactional forms
 * @param req               HttpServletRequest
 * @param nextprevLink  Link text
 * @param searched      Indicates whether search is executed ot not
 * @return                  Constructed HTML String
 */
    public String setFormTransaction(HttpServletRequest req, String nextprevLink, boolean searched)  throws Exception {
        String queryform="<form name=\"QueryForm\" method=\"post\" action=\""+nextprevLink+"\" >";
		req.setCharacterEncoding("UTF-8");
        Enumeration paramnames =  req.getParameterNames();
        if( !searched ) {
            queryform += "<input type=\"hidden\" value=\"\" name=\"from\">" ;
            queryform += "<input type=\"hidden\" value=\"\" name=\"to\">" ;
            queryform += "<input type=\"hidden\" value=\"\" name=\"searched\">" ;
        } else {
            while(paramnames.hasMoreElements()){
                String str=(String)paramnames.nextElement();
                if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) ) {
                    queryform+="<input type=\"hidden\" value=\""+req.getParameter(str)+"\" name=\""+str+"\">" ;
                }
            }
        }
        queryform += "</form>";
        return queryform;
    }

   /**
    *
    * @param req    HttpServletRequest
     * @return                  Constructed HTML String
    */


    public String setFormTransaction(HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("UTF-8");
        String queryform = "";
        queryform += "<input type=\"hidden\" value=\""+checkForNull( req.getParameter("from") )+"\" name=\"from\">" ;
        queryform += "<input type=\"hidden\" value=\""+checkForNull( req.getParameter("to") )+"\" name=\"to\">" ;

        return queryform;
    }
/**
 *
 * @param ord
 */
    private void setOrderby(String ord[]) {
        if ( !(ord == null || ord .equals("")) ) {
            orderBy=" order by ";
            for ( int i=0;i < ord.length;i++ ) {
                if ( i == ord.length - 1 ) {
                    orderBy += ord[i];
                } else {
                    orderBy += ord[i]+",";
                }
            }//for
        }//outer if
    }//method end
/**
 *
 * @return
 */
    private String getOrderby() {
        return this.orderBy ;
    }


	
	/** Added by abirami - Bru-HIMS-CRF-313 **
    **  Method Description: To get the report print option from the table SM_DFLT_ONLNE_PRINT based on the FunctionID,ReportID, and ModuleID. **/
    public static String getDefaultOnlinePrint(HttpServletRequest request, String sFunction, String myReportID, String moduleID) 
    {
       
          String check_option ="";
          ResultSet rs = null;
          Connection con = null; 
          PreparedStatement pstmt =null;
          try
				{
        	  		con = ConnectionManager.getConnection(request);
        	  		pstmt = con.prepareStatement("SELECT NVL(DFLT_ONLINE_PRINT_YN, 'N') V_CHKKEY  FROM SM_DFLT_ONLINE_PRINT  WHERE FUNCTION_ID = UPPER('"+ sFunction +"') AND REPORT_ID = '"+myReportID+"' AND MODULE_ID = '"+moduleID+"'");
					rs = pstmt.executeQuery() ;
					
					if( rs != null  && rs.next()) 
					{				
						check_option  =  rs.getString("V_CHKKEY");	
						
					}
				}
			catch(Exception e)
			{
				System.out.println("Exception  while geting SM_DFLT_ONLNE_PRINT:"+e);
				e.printStackTrace();
			}
          finally
          {
        	  try {
        		  	if(rs!=null)
						rs.close();
        		  	if(pstmt!=null) 
        		  		pstmt.close();
					if(con != null)
						ConnectionManager.returnConnection(con,request);
				} catch (SQLException e) {
					e.printStackTrace();
				}
          }
		return check_option;
    }

	public static boolean isSiteSpecific(Connection con,String module_id,String function_id){
		String siteSpecificSQL="select count(*) count from SM_FUNCTION_CONTROL a, sm_site_param b where a.MODULE_ID=? and a.FUNCTIONALITY_ID =? and a.SITE_ID =b.customer_id";
		int count=0;
		boolean siteSpecific=false;
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(siteSpecificSQL);
			pstmt.setString(1,module_id);
			pstmt.setString(2,function_id);

			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				siteSpecific=true;
			}
		}catch(Exception ex){
			System.err.println("Exception in isSiteSpecific - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return siteSpecific;
	}

	//Added the below method against HSA-SCF-0059:
	//Method Desc: To check if the patient has file ..
	public static boolean isPatientFileExists(Connection con,String patient_id,String facilityId){
		String maintain_doc_or_file = "";
		String file_no				= "";
		String strSql_MaintainDoc = "SELECT maintain_doc_or_file FROM mp_param where module_id='MP'";
		boolean bPatientFileExists=false;
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
				pstmt	= con.prepareStatement(strSql_MaintainDoc);
				rs	= pstmt.executeQuery() ;
				if(rs.next())
				{
					maintain_doc_or_file = rs.getString(1);
					if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) 
						maintain_doc_or_file = "F";
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
	
				if(maintain_doc_or_file.equals("D"))
				{
					file_no = "";
				}
				else
				{
					String strSql_PatFile = "SELECT file_no FROM mr_pat_file_index WHERE patient_id = '"+patient_id+"' AND facility_id = '"+facilityId+"'";
					pstmt = con.prepareStatement(strSql_PatFile);
					rs = pstmt.executeQuery() ;
			
					if(rs.next())
					{
					   file_no = rs.getString(1);
						if(file_no == null || file_no.equals("null")) file_no = "";
					}
				}
				if(!file_no.equals(""))
					bPatientFileExists = true;
	
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
		}catch(Exception ex){
			System.err.println("Exception in isPatientFileExists - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return bPatientFileExists;
	}
	
	/*Added by Dharma on Apr 9th 2015 against HSA-CRF-0183 [IN:049543] Start*/
	public static HashMap getParamDetails(HashMap sqlColumns,String whereCondition,String tableName, Connection con) throws Exception {
	
		Statement stmt		= null;
		ResultSet rs				= null;
	
		HashMap hashMap = null;
		String dynamicColumns	= "";
		Iterator entries	= null;

		try{
			hashMap	= new HashMap();
			entries = sqlColumns.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				String key = (String)entry.getKey();
				String value = (String)entry.getValue();
				dynamicColumns	= dynamicColumns + key + ",";
			}
			
			if(!dynamicColumns.equals("")){
		
				dynamicColumns = dynamicColumns.substring(0, dynamicColumns.length() - 1);
				String sql="select "+dynamicColumns+" from "+tableName+" "+whereCondition+" ";
				stmt	= con.createStatement();
				rs		= stmt.executeQuery(sql);
				if(rs!=null && rs.next()) {
					entries	= null;
					entries = sqlColumns.entrySet().iterator();
					while (entries.hasNext()) {
						Map.Entry entry = (Map.Entry) entries.next();
						String key = (String)entry.getKey();
						String value = (String)entry.getValue();
						if(value.equals("S")){
							hashMap.put(key, rs.getString(key));
						}else if(value.equals("I")){
							hashMap.put(key,rs.getInt(key));
						}
					}
				}
			}

		}catch(Exception e)	{
			e.printStackTrace();
		}finally{
			try{
				if(stmt !=null) stmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
	
		return hashMap;
	}
	/*Added by Dharma on Apr 9th 2015 against HSA-CRF-0183 [IN:049543] End*/

	/*Added by Dharma on May 5th 2015 against GDOH-CRF-0035 [IN:049263] Start*/

	public static String verifyNationalId(Connection con,String nationalId) throws Exception{

		Statement stmt		= null;
		ResultSet rs				= null;
		String nationalIdStatus	= "";
		String result	= "";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select VERIFY_NATIONAL_ID('"+nationalId+"') FROM DUAL");
			if(rs!=null){
				if (rs.next())
					result = rs.getString(1);
			}
			StringTokenizer strTok = new StringTokenizer(result,"$");
			if (strTok.hasMoreTokens())
				result = strTok.nextToken();

			if ( result.equals("FALSE") ){
				if(strTok.hasMoreTokens()) 
					nationalIdStatus = strTok.nextToken();
			}

        }catch(Exception e)	{
			e.printStackTrace();
		}finally{
			try{
				if(stmt !=null) stmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}

		return nationalIdStatus;
    }

	public static String verifyCheckDigitSchemeForNationalId(Connection con,String nationalId,String nat_id_check_digit_function) throws Exception{

		Statement stmt		= null;
		ResultSet rs				= null;
		String nationalIdStatus	= "";
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select "+nat_id_check_digit_function+"('"+nationalId+"') FROM DUAL");
			if(rs!=null){
				if (rs.next())
					nationalIdStatus = rs.getString(1);
			}
			
		}catch(Exception e)	{
			e.printStackTrace();
		}finally{
			try{
				if(stmt !=null) stmt.close();
				if(rs !=null) rs.close();
			} catch(Exception fe){
			}
		}

		return nationalIdStatus;
	}

	/*Added by Dharma on May 5th 2015 against GDOH-CRF-0035 [IN:049263] End*/


/*Added by Dharma on May 27th 2015 against PMG2015-GDOH-CRF-0006 [IN:055606] Start*/
public static <key, value extends Comparable<value>> Map<key, value> sortByValuesMap(final Map<key, value> map) {
		Comparator<key> valueComparator =  new Comparator<key>() {
			public int compare(key k1, key k2) 
			{
				int valCompare = map.get(k1).compareTo(map.get(k2));
				if (valCompare == 0)
					return 1;
				else
					return valCompare;
			}
		};
		Map<key, value> sortedByValues = new TreeMap<key, value>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

/*Added by Dharma on May 27th 2015 against PMG2015-GDOH-CRF-0006 [IN:055606] End*/

/*Added by Rameswar on 30th July 2015 against HSA-CRF-0305 IN054700 Start*/
public static ArrayList getFunctionFieldRestriction(Connection con,String module_id,String function_id,String table_name,String ins_req,String upd_req){
		String SQL="select COLUMN_NAME from SM_FUNCTION_FIELD_RESTRICT a, sm_site_param b where a.MODULE_ID=? and a.FUNCTION_ID =? and  a.TABLE_NAME=? and a.INSERT_REQ_YN=? and a.UPDATE_REQ_YN=? and a.SITE_ID =b.customer_id";

		ArrayList arrayList=new ArrayList();
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,module_id);
			pstmt.setString(2,function_id);
			pstmt.setString(3,table_name);
			pstmt.setString(4,ins_req);
			pstmt.setString(5,upd_req);
			
			rs=pstmt.executeQuery();
			while(rs != null && rs.next()){
				arrayList.add(rs.getString("column_name"));
			}
			
		}catch(Exception ex){
			System.err.println("Exception in getFieldRestriction - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return arrayList;
	}

/*Added by Rameswar on 30th July 2015 against HSA-CRF-0305 IN054700 End*/

/*Added by Rameswar for Patient Portal Start*/
public static boolean isPortalPatient(Connection con,String appt_ref_no,String facility_id){
		String SQL="select nvl(PORTAL_APPT_YN,'N') from OA_APPT where APPT_REF_NO=? and FACILITY_ID=?";
		boolean portalPatient=false;
		String portal_appt_yn="";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,appt_ref_no);
			pstmt.setString(2,facility_id);

			rs=pstmt.executeQuery();
			while(rs.next()){
				portal_appt_yn=rs.getString(1);
			}
			if (portal_appt_yn.equals("Y"))
			{
				portalPatient=true;
			}			
		}catch(Exception ex){
			System.err.println("Exception in isPortalPatient - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return portalPatient;
	}
	/*Added by Rameswar for Patient Portal End*/
	/*Added by Rameswar for Patient Portal on 09-Oct-15 Start*/
	public static HashMap portalInstallation(Connection con) throws Exception{

		Statement stmt			= null;
		ResultSet rs			= null;
		HashMap hashdata        = new HashMap();
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT a.site_ip,a.port,a.site_id FROM portal_installation a, sm_site_param b WHERE a.customer_id = b.customer_id");
		
			if(rs!=null){
				if (rs.next()){
									
				hashdata.put( "site_ip", rs.getString(1) ) ;
				hashdata.put( "port", rs.getInt(2 ) ) ;
				hashdata.put( "site_id", rs.getString(3) ) ;
				}
			}
			
		}catch(Exception e)	{
			e.printStackTrace();
		}finally{
			try{
				if(stmt !=null) stmt.close();
				if(rs !=null) rs.close();
			} catch(Exception fe){
			}
		}

		return hashdata;
	}
/*Added by Rameswar for Patient Portal on 09-Oct-15 End*/

/*
* Method Added by Karthik to Support Online portal Update From EM Operations
* In Case of Success, this method Returns a String , which contains Processed JSON/XML Data.
* In Case of Failure, Exception will be thrown and Nothing will be Returned.
* Failure Code,URL and Params will be logged. 
*
* Note: Process flow will not be affected in case of failure as Exception is Handled
* @param url
* @param postInputJsonParams( String in JSON format )
* @return 
*/
/* Added by Karthik to Support Online portal Update From EM Operations - Start */
public static String restPostRequest(URL url,String postInputJsonParams) {
	
	String jsonOrXmlString = "";

	try {	
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		urlConn.setDoOutput(true);
		urlConn.setRequestMethod("POST");
		urlConn.setRequestProperty("Content-Type", "application/json");	

		OutputStream os = urlConn.getOutputStream();
		os.write(postInputJsonParams.getBytes());
		os.flush();

		if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK  || urlConn.getResponseCode() == HttpURLConnection.HTTP_CREATED ) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader((urlConn.getInputStream())));				
			String output;
			while (( output = br.readLine()) != null) {
				System.out.println(output);
				jsonOrXmlString+= output.trim();
			}

		}else{
			System.out.println("Failed : HTTP error code : "+ urlConn.getResponseCode());
			throw new RuntimeException("Failed : HTTP error code : "+ urlConn.getResponseCode());				
		}			
		urlConn.disconnect();			
		
	} catch (MalformedURLException e) {
		System.out.println("MalformedURLException in restPostRequest() "+ "\n"+ url + "\n"+ postInputJsonParams);
	} catch (Exception e) {
		System.out.println("Exception in restPostRequest() "+ "\n"+ url + "\n"+ postInputJsonParams);
	}
	return jsonOrXmlString;
}
/* Added by Karthik to Support Online portal Update From EM Operations - Ends */
public static boolean isDownTimePatient(Connection con,String patient_id){
		String SQL="select NVL(TO_CHAR(regn_date,'DD/MM/YYYY'),'N') from mp_patient where patient_id=?";
		boolean downTimePatient=false;
		String regn_date="";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,patient_id);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				regn_date=rs.getString(1);
			}
			if (regn_date.equals("N")||regn_date==null)
			{
				downTimePatient=true;
			}			
		}catch(Exception ex){
			System.err.println("Exception in isDownTimePatient - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return downTimePatient;
	}


/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] Start*/
public static String getRegistrationDateTime(Connection con,String patient_id){
		String SQL="select to_char(regn_date,'dd/mm/yyyy hh24:mi:ss') regn_date from mp_patient where patient_id=?";
		String regn_date		="";
		PreparedStatement pstmt	=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,patient_id);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				regn_date=rs.getString(1);
			}
					
		}catch(Exception ex){
			System.err.println("Exception in getRegistrationDateTime - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return regn_date;
	}
/*Added by Dharma on May 25th 2016 against KAUH-SCF-0261 [IN:059835] End*/

/*Added by Rameswar on  29-06-2016 for ML-MMOH-CRF-0459*/
public static String getCollectionDate(Connection conn) throws Exception{
        PreparedStatement pstmt=null;
        ResultSet rs1=null;
        String collection_date = "";
        
        try{
            
            String mrParamSql="select to_char((sysdate + nvl(MEDREP_COLLECTION_DAYS,0)),'dd/mm/yyyy hh24:mi') as collection_date  from mr_parameter";
            
            pstmt = conn.prepareStatement(mrParamSql);
                    
            rs1 = pstmt.executeQuery();
                        
            while(rs1!=null && rs1.next()){
                                
            collection_date = (rs1.getString("collection_date")==null || rs1.getString("collection_date")=="")?"" : rs1.getString("collection_date");
                                
            }
            

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(pstmt != null) pstmt.close();
                if(rs1  != null) rs1.close();
                
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }
        return collection_date;
        
    }

	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
	public static HashMap getSiteSpecificDetails(Connection con,String module_id,String function_id) throws Exception{

		PreparedStatement pstmt	=null;
		ResultSet  rs=null;
			HashMap hashdata        = new HashMap();
			String key1		= "";
			String value1	= "";
			String key2		= "";
			String value2	= "";
			try{
			
				String sql = "select KEY_1,VALUE_1,KEY_2,VALUE_2 from SM_FUNCTION_CONTROL a, sm_site_param b where a.MODULE_ID=? and a.FUNCTIONALITY_ID =? and a.SITE_ID =b.customer_id";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,module_id);
				pstmt.setString(2,function_id);
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next()){
					key1			= rs.getString("KEY_1")==null?"":rs.getString("KEY_1");
					value1			= rs.getString("VALUE_1")==null?"":rs.getString("VALUE_1");
					key2			= rs.getString("KEY_2")==null?"":rs.getString("KEY_2");
					value2			= rs.getString("VALUE_2")==null?"":rs.getString("VALUE_2");
				}
				hashdata.put( "key1", key1 ) ;
				hashdata.put( "value1", value1 ) ;
				hashdata.put( "key2", key2 ) ;
				hashdata.put( "value2", value2 ) ;
				
			}catch(Exception e)	{
				System.err.println("Exception in getSiteSpecificDetails - "+e.getMessage());
				e.printStackTrace();
			}finally{
				try{
					if(pstmt !=null) pstmt.close();
					if(rs !=null) rs.close();
				}
				catch(Exception fe){
				}
			}

			return hashdata;
		}

	/*Added by Dharma on Feb 7th 2017 against GDOH-SCF-0244 [IN:063491] End*/
	public static String getMyHixApplicable(Connection con){
		String sqlMyHixApplicable="SELECT count(*) FROM XH_STANDARD_PROFILE WHERE PROFILE_ID LIKE '%MYHIX%' and NVL(EFF_STATUS,'Y') = 'Y' AND ROWNUM = 1  ";
		int count=0;
		String myhixYN="N";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(sqlMyHixApplicable);
			

			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				myhixYN="Y";
			}
		}catch(Exception ex){
			System.err.println("Exception in getMyHixApplicable --> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return myhixYN;
	}
		/*Added by lakshmanan on nov 03 2022 against GHL-CRF-0657.1*/
	public static String getNDHMYN(Connection con){
		String sqlNDHMApplicable="SELECT count(*) FROM XH_STANDARD_PROFILE WHERE PROFILE_ID LIKE '%FHIR4PROF%' and NVL(EFF_STATUS,'Y') = 'Y' AND ROWNUM = 1  ";
		int count=0;
		String ndhmYN="N";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(sqlNDHMApplicable);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				ndhmYN="Y";
			}
		}catch(Exception ex){
			System.err.println("Exception in getNDHMApplicable --> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return ndhmYN;
	}
	/*Added by lakshmanan on nov 03 2022 against GHL-CRF-0657.1*/
	public static String getNDHMApplicable(Connection con){
		String sqlNDHMApplicable="SELECT count(*) FROM XH_STANDARD_PROFILE WHERE PROFILE_ID LIKE '%FHIR4PROF%' and NVL(EFF_STATUS,'Y') = 'Y' AND ROWNUM = 1  ";
		int count=0;
		String ndhmYN="N";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(sqlNDHMApplicable);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				ndhmYN="Y";
			}
		}catch(Exception ex){
			System.err.println("Exception in getNDHMApplicable --> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return ndhmYN;
	}

	/*Added by Thamizh selvi on 31st Mar 2017 against GDOH-CRF-0124 Start*/
	public static String getPatIdLength(Connection con) throws Exception{
		Statement stmt	=null;
		ResultSet rs 	= null;
		String patIdLen = null;
		try{
			String sql = "Select Patient_Id_Length from mp_param";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				patIdLen		= rs.getString("Patient_Id_Length");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatIdLength - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return patIdLen;
	} 
	/*End*/

	public static int getUserFunRightsCount(Connection con,String userId,String functionId,String moduleId){
	
		String sql ="select sm_user_func_rights(?,?,?) tot_count from dual";
		int count=0;
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userId);
			pstmt.setString(2,functionId);
			pstmt.setString(3,moduleId);
			rs=pstmt.executeQuery();
		
			if(rs!=null && rs.next()){
				count=rs.getInt(1);
			}

				
		}catch(Exception ex){
			System.err.println("Exception in getUserFunRightsCount --> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return count;
	}
	/*Added by Thamizh selvi on 20th Oct 2017 for ML-MMOH-CRF-0623 Start*/
	public static String getSystemDateTime(Connection con) throws Exception{
		Statement stmt		= null;
		ResultSet rs 		= null;
		String sysDateTime	= null;

		try{

			String sysDateSql = "Select to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sysDateSql);
			
			if(rs!=null && rs.next()){
				sysDateTime = rs.getString("sys_date_time")==null?"":rs.getString("sys_date_time");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSystemDateTime - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return sysDateTime;
	}/*End*/
	
	/*Below line added for this CRF ML-MMOH-CRF-0862*/
	public static String getPractitionerLongName(Connection con,String pract_id, String localang_id){
	
		/*String sql ="select NVL(SUBSTR(a.long_name,'1','100'),practitioner_name) long_name from am_practitioner_lang_vw a where practitioner_id='"+pract_id+"' and language_id='"+localang_id+"'";*/
		
		String sql ="select SUBSTR(a.long_name,'1','100') long_name from am_practitioner a where practitioner_id='"+pract_id+"'";
		String prat_long_name="";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{			
			pstmt=con.prepareStatement(sql);				
			rs=pstmt.executeQuery();		
		    if(rs!=null && rs.next()){
				prat_long_name=rs.getString("long_name")==null?"":rs.getString("long_name");
			}             			
		}catch(Exception ex){
			System.err.println("Exception in getPractitionerLongName ----> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fny){
			fny.printStackTrace();
			}
		}
		return prat_long_name;
	}
	
	//End this CRF ML-MMOH-CRF-0862

	public static String getCDRIconEnableYNforPract(Connection con,String userId){
		String sql ="SELECT COUNT (1) FROM sm_appl_user WHERE appl_user_id = ? AND func_role = 'P' AND func_role_id IS NOT NULL";
		String prat_long_name="";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		String practEnableCDR	= "N";
		System.err.println("sql==>"+sql);
		System.err.println("userId==>"+userId);
		try{			
			pstmt=con.prepareStatement(sql);	
			pstmt.setString(1,userId);
			rs=pstmt.executeQuery();		
		    if(rs!=null && rs.next()){
				int count	= rs.getInt(1);
				if(count > 0)
					practEnableCDR = "Y";
			} 
	
			System.err.println("practEnableCDR==>"+practEnableCDR);
		}catch(Exception ex){
			System.err.println("Exception in getCDRIconEnableYNforPract ----> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fny){
			fny.printStackTrace();
			}
		}
		return practEnableCDR;
} 

// Added by mujafar for ML-MMOH-CRF-1130.1 START

public static String getDisRefSumCnt(Connection con,String patId){
		String sql ="select ds_count,rs_count from XH_MYHIX_PAT_DOC where patient_id=?";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		int ds_count	= 0;
		int rs_count	= 0;
		String ds_rs_count="";
		
		try{			
			pstmt=con.prepareStatement(sql);	
			pstmt.setString(1,patId);
			
			rs=pstmt.executeQuery();
			
		    if(rs!=null && rs.next()){ 
				 ds_count	= rs.getInt("ds_count");
				 rs_count	= rs.getInt("rs_count");
			}
			
				if(ds_count > 0)
					ds_rs_count=ds_count+"~~";
				
				if(rs_count > 0 && !ds_rs_count.equals(""))
					ds_rs_count=ds_rs_count+rs_count;
				else if(rs_count > 0 && ds_rs_count.equals(""))
					ds_rs_count=ds_rs_count+"~~"+rs_count;
			
		}catch(Exception ex){
			System.err.println("Exception in getDisRefSumCnt ----> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fnly){
			fnly.printStackTrace();
			}
		}
		return ds_rs_count;
} 

// Added by mujafar for ML-MMOH-CRF-1130.1 END

/*Added By Dharma on 29th Jan 2020 against MO-CRF-20155 Start*/
public static String getOperStationId(Connection con, String facilityid, String userid, String operId) throws Exception	{
		PreparedStatement pstmt		= null;
		ResultSet rset				= null;
		String oper_stat_id			= null;
		
		try{

			String sqlQuery = " Select AM_OPER_STN_ACCESS_CHECK(?,?,'X','',?) oper_stat_id from dual ";
			pstmt= con.prepareStatement(sqlQuery);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,userid);
			pstmt.setString(3,operId);
			rset= pstmt.executeQuery();
			if(rset!=null && rset.next()){
				oper_stat_id = rset.getString("oper_stat_id")==null?"":rset.getString("oper_stat_id");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOperStationId - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return oper_stat_id;
	}

	public static String getModuleInstalledYN(Connection con, String facilityid, String moduleId) throws Exception	{
		PreparedStatement pstmt		= null;
		ResultSet rset				= null;
		String operational_yn			= null;
		
		try{

			String sqlQuery = " select operational_yn from sm_modules_facility where facility_id = ? and module_id = ? ";
			pstmt= con.prepareStatement(sqlQuery);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,moduleId);
			rset= pstmt.executeQuery();
			if(rset!=null && rset.next()){
				operational_yn = rset.getString("operational_yn")==null?"N":rset.getString("operational_yn");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getModuleInstalledYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return operational_yn;
	}
		
/*Added By Dharma on 29th Jan 2020 against MO-CRF-20155 End*/
	
	/*Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1*/
	public ArrayList getSearchQueryResultPage (PageContext pageContext, HashMap sqlMap, HashMap funcMap, HttpServletRequest req ) throws Exception {
        return getSearchQueryResultPage(pageContext, sqlMap, funcMap, req, false, Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") ) );
    }

    public ArrayList getSearchQueryResultPage (PageContext pageContext, HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup  ) throws Exception {
        return getSearchQueryResultPage(pageContext, sqlMap, funcMap, req, lookup, Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") ) );
    }

    public ArrayList getSearchQueryResultPage (PageContext pageContext, HashMap sqlMap, HashMap funcMap,HttpServletRequest req,int query_result_size ) throws Exception {
        return getSearchQueryResultPage(pageContext, sqlMap, funcMap, req, false, query_result_size );
    }

    private ArrayList getSearchQueryResultPage (PageContext pageContext,HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup, int query_result_size ) throws Exception {
        Connection connection       = null;
		req.setCharacterEncoding("UTF-8");
        String[] orderbycolumns     = req.getParameterValues("orderbycolumns") ;
        if(orderbycolumns == null)  orderbycolumns = new String[0] ;
        if( !lookup && orderbycolumns.length>0 ) setOrderby(orderbycolumns);
        String from                 = req.getParameter( "from" ) ;
        String to                   = req.getParameter( "to" ) ;
        ArrayList displayFields     = (ArrayList)funcMap.get( "displayFields" ) ;
        ArrayList chkFields         = (ArrayList)funcMap.get( "chkFields" ) ;
        String searchCriteria       = checkForNull( (String)funcMap.get( "searchCriteria" )) ;
        String searchType	        = checkForNull( (String)funcMap.get( "searchType" )) ;
        String sqlData              = (String)sqlMap.get( "sqlData" );
        ArrayList error             = new ArrayList();
        String prevnextlink         = "";
        
        StringBuffer msgsb = new StringBuffer();
        int start = 0 ;
        int end = 0 ;

        if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from  ) ;

        if ( to == null )
            end =query_result_size;
        else
            end = Integer.parseInt( to ) ;
        PreparedStatement pstmtCount = null;
        PreparedStatement pstmtData = null;
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        result.clear();
        result.add("total");
        result.add("prevnext");
        try {
            HttpSession session = req.getSession(false) ;
            setProperties((java.util.Properties)session.getValue("jdbc")) ;

            connection=getConnection();
            int fldkey=1;
            try {
                msgsb.append( " SQL : "+sqlData );
                msgsb.append( " Connection : " + connection );
                if( !lookup && orderbycolumns.length>0 )
                    pstmtData = connection.prepareStatement( sqlData + orderBy );
                else
                    pstmtData = connection.prepareStatement( sqlData );
                msgsb.append( " PreparedStatement : " + pstmtData);

                for(int fldcount=0; fldcount<chkFields.size(); fldcount++) {
                    Object fldValue = chkFields.get(fldcount) ;
				
                    if( fldValue instanceof String ) {
                        if( !lookup )
                          pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))) ;
                        else {
                            if( searchCriteria.equals( "S" ) )
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                            else if( searchCriteria.equals( "E" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount)) ) ;
                            else if( searchCriteria.equals( "C" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount))+"%" ) ;
                            else
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;

							if( !searchType.equals( "" ) )
                                pstmtData.setString( 3, searchType ) ;
                            else
                                pstmtData.setString( 3, searchType+"%" ) ;
                        }
                    }
                    else if ( fldValue instanceof Integer )
                        pstmtData.setInt( fldkey, ((Integer)fldValue).intValue() ) ;
                    else if ( fldValue instanceof Long )
                        pstmtData.setLong( fldkey, ((Long)fldValue).longValue() ) ;
                    else if ( fldValue instanceof Float )
                        pstmtData.setFloat( fldkey, ((Float)fldValue).floatValue() ) ;
                    else if ( fldValue instanceof Double )
                        pstmtData.setDouble( fldkey, ((Double)fldValue).doubleValue() ) ;
                    fldkey++;
                }

                rs = null;
                rs = pstmtData.executeQuery();
                msgsb.append( "ResultSet : " + rs);
                long count = 0;
                long i = 0;

                if( rs != null ) {
                    while( rs.next() && i <= end+1 ) {
                        if( start != 1 && (i+1) < start ) {
                            i++;
                            continue;
                        }
                        else i++;
                        count++ ;
                        if(i <= end ) {
                            ArrayList records=new ArrayList();
                            records.clear();
                            for( int dispfldCount=0;  dispfldCount<displayFields.size();  dispfldCount++ )
                                records.add(rs.getString((String)displayFields.get( dispfldCount )));

                            result.add(records);
                        }
                    }
                    result.set( 0, String.valueOf( count ) ) ;
                    if( start != 1 )
                        prevnextlink += "<td align=\"right\" nowrap><a href=\"javascript:SubmitLink("+(start-query_result_size)+","+(end-query_result_size)+");\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>" ;
                    if( count > query_result_size )
                        prevnextlink += "&nbsp;&nbsp;<td align=\"right\" nowrap><a href=\"javascript:SubmitLink("+(start+query_result_size)+","+(end+query_result_size)+");\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>" ;
                    result.set( 1, prevnextlink ) ;
                }

            }catch(Exception ed) {
                error.add("Exception from sqlData :" +ed.getMessage()+msgsb.toString() );
                result.add(error);
            }
        } catch(Exception ex) {
                error.add(ex.getMessage());
                result.add(error);
        } finally {
            try{
                if( rs != null ) closeResultSet( rs ) ;
                if( pstmtData != null ) closeStatement( pstmtData ) ;
                if( pstmtCount != null ) closeStatement( pstmtCount ) ;
                if ( connection != null ) closeConnection( connection ) ;
            } catch(Exception e) {
                error.add(e.getMessage());
                result.add(error);
            }
        }
        return result;
    }
	/*End GHL-CRF-0614.1*/

	/*Added by Ashwini on 22-Jul-2020 for ML-MMOH-CRF-1549*/
	private static final String encryptionKey           = "EMENTERPRISEMGMT";
    private static final String characterEncoding       = "UTF-8";
    private static final String cipherTransformation    = "AES/CBC/PKCS5PADDING";
    private static final String aesEncryptionAlgorithem = "AES";

    public static String decrypt(String encryptedText) {
        String decryptedText = "";
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = encryptionKey.getBytes(characterEncoding);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
 			//byte[] cipherText = cipher.doFinal(Base64.decodeBase64(encryptedText.getBytes("UTF-8")));
 			byte[] cipherText = cipher.doFinal(org.apache.commons.codec.binary.Base64.decodeBase64(encryptedText.getBytes("UTF-8")));
			decryptedText = new String(cipherText, "UTF8");

        } catch (Exception E) {
            System.err.println("decrypt Exception : "+E.getMessage());
        }
        return decryptedText;
    }
	/*End ML-MMOH-CRF-1549*/
    //IN27710 - Start
	public static JSONObject getBrowserCheck(Connection con, String quick_link_ref) throws Exception{

		PreparedStatement pstmt			= null;
		ResultSet rs 					= null;
		JSONObject jsonObj				= new JSONObject();
		String browserCheck	= "";
		

		try{
			String sql = "select BROWSER_CHECK from SM_QUICK_LINK_LIST where quick_link_ref = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,quick_link_ref);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				browserCheck    = rs.getString("BROWSER_CHECK"); 
			}
			
			jsonObj.put("browserCheck",browserCheck);
			

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getBrowserCheck - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	 //IN27710 - End
     //IN27707 Starts
	 public static JSONArray getOrderCategory(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		String orderCategory        ="";
		String shortDesc      ="";
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "select order_category,short_desc from or_order_category order by order_category"; 
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				orderCategory		= rs.getString("order_category")==null?"":rs.getString("order_category");
				shortDesc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				jsonObj.put("order_category",orderCategory);
				jsonObj.put("short_desc",shortDesc);
				arrJSON.add(jsonObj);
			}
			if(rs!=null) rs.close(); 
            if(stmt!=null) stmt.close(); 
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOrderCategory - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	 //IN27707 Ends

	//<!--Added by Himanshu Saxena on 20-AUG-2023 for AAKH-CRF-0175 Starts-->
	 public static String isSiteSpecificforBiometric(Connection con)
	 {
	 	String function_name="";
	 	PreparedStatement pstmt		= null;
	 	ResultSet rs 				= null;
	 	try
	 	{
	 	String siteSpecificSQL="select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID";
	 	pstmt= con.prepareStatement(siteSpecificSQL);
	     rs= pstmt.executeQuery();
	     if(rs!=null && rs.next())
	 	{
	 	function_name=rs.getString("VALUE_2");
	 	}	
	 	}catch(Exception esql)
	 	{
	 		esql.printStackTrace();
	 	}finally
	 	{
	 		try{
	 	 if(pstmt != null)pstmt.close();
	 	 if(rs != null)rs.close();
	 		}catch(Exception fe){
	 			
	 		}
	 	}
	 	return function_name;
}

//added by Himanshu for AAKH-CRF-0175 as on 23-08-2023
	 public static String insertReasonforBiometric(Connection con,String facility_id,String fun_id,String patient_id,String ref_no,String location_code,String reason,String addedworkstation,String user_id) 
	 {
	 	CallableStatement cstmt = null;
	 	String status="E";
	 	try{
		    
	 			StringBuffer sqloa = new StringBuffer() ;
	 			sqloa.append("{call mp_biometric_auth_prc(?,?,?,?,?,?,?,?,?)}");
	 				cstmt = con.prepareCall(sqloa.toString());
	 				cstmt.setString(1, facility_id);
	 				cstmt.setString(2, fun_id);
	 				cstmt.setString(3, patient_id);
	 				cstmt.setString(4, ref_no);
	 				cstmt.setString(5, location_code);
	 				cstmt.setString(6, reason);
	 				cstmt.setString(7, addedworkstation);
	 				cstmt.setString(8, user_id);
	 				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR	);
	 				cstmt.execute();
	 				status = cstmt.getString(9);
	 				
	 	}catch(Exception e)
	 	{
	 		status="E";
	 		e.printStackTrace();
	 	}finally
	 	{
	 		try{if(cstmt != null)cstmt.close();}
	 		catch(Exception fe){}
	 	}
	 	return status;
	 }

} 