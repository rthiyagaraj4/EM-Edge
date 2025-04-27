/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import eCommon.Common.CommonAdapter;

import eST.Common.*;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class StockLevelReportBean extends StTransaction    implements Serializable
{
   //private StHeaderBean   stHeaderBean	;
   //private String language;
	
    public ArrayList getArrayCodeList()
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
//        Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANALYSIS"));
			preparedstatement.setString(1,getLanguageId());
            HashMap hashmap;
            for(resultset = preparedstatement.executeQuery(); resultset != null && resultset.next(); arraylist.add(hashmap))
            {
                hashmap = new HashMap();
                hashmap.put("code", CommonAdapter.checkForNull(resultset.getString(1)));
                hashmap.put("desc", CommonAdapter.checkForNull(resultset.getString(2)));
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
        return arraylist;
    }

/*public void setLanguageId(String language) {
		this.language = language;
	}
public String getLanguageId() {
		return this.language;
	}
    */
    public String getReportType()
    {
        return getStaticListOptionTag("A,All;Z,Zero Stock;N,Non Zero;M,Item Below Minimum Level;R,Items Below Reorder Level;");
    }

    public String getNatureSelection()
    {
        return getStaticListOptionTag("A,Both;E,Enabled;D,Disabled");
    }

       
    public String getReportOrder()
    {
        return getStaticListOptionTag("1,Item Code;2,Short Description;");
    }
    public String getSpecialItem()
    {
        return getStaticListOptionTag("A,Both;Y,Special Item Only;N,Non Special Item Only;");
    }
	//added here
	public ArrayList getResult(String Report_type,String p_doc_type_code, String store_code, String dt_from,String dt_to,String p_doc_no)   throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList record = new ArrayList();
		ArrayList result	=	new ArrayList();
        try
        {
            connection = getConnection();

			if(Report_type.equals("A")) {

            preparedstatement = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_MFG_ITEM_LABEL_REPORT"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,p_doc_type_code);
			preparedstatement.setString(3,p_doc_no);
			preparedstatement.setString(4,store_code);
			preparedstatement.setString(5,dt_from);
			preparedstatement.setString(6,dt_to);
			resultset = preparedstatement.executeQuery();
			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	doc_type_code	=resultset.getString("doc_type_code");
				String	doc_type_desc	=resultset.getString("doc_type_desc");
				String	doc_no		=resultset.getString("doc_no");
				String	doc_date		=resultset.getString("doc_date");
				String	doc_ref		=resultset.getString("doc_ref");
				String	p_store_code	=resultset.getString("store_code");
				String	p_store_desc	=resultset.getString("store_desc");

				record.add(doc_type_code);
				record.add(doc_type_desc);
				record.add(doc_no);
				record.add(doc_date);
				record.add(doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);

				result.add(record);
			}
			} 			 
			else if(Report_type.equals("B") || Report_type.equals("C")) {

 preparedstatement = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_REPACK_LABEL_REPORT"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,p_doc_type_code);
			preparedstatement.setString(3,p_doc_no);
			preparedstatement.setString(4,store_code);
			preparedstatement.setString(5,dt_from);
			preparedstatement.setString(6,dt_to);

			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	doc_type_code	=resultset.getString("doc_type_code");
				String	doc_type_desc	=resultset.getString("doc_type_desc");
				String	doc_no		=resultset.getString("doc_no");
				String	doc_date		=resultset.getString("doc_date");
				String	doc_ref		=resultset.getString("doc_ref");
				String	p_store_code	=resultset.getString("store_code");
				String	p_store_desc	=resultset.getString("store_desc");

				record.add(doc_type_code);
				record.add(doc_type_desc);
				record.add(doc_no);
				record.add(doc_date);
				record.add(doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);

				result.add(record);
			}
			}
			}
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            try
            {
                closeResultSet(resultset);
                closeStatement(preparedstatement);
                closeConnection(connection);
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        }
		return result;
    }
//ended here


    public String getStaticListOptionTag(String s, String s1)
    {
        StringBuffer stringbuffer = new StringBuffer();
        StringTokenizer stringtokenizer1;
        String s2;
        String s3;
        for(StringTokenizer stringtokenizer = new StringTokenizer(s, ";"); stringtokenizer.hasMoreTokens(); stringbuffer.append("<option value=\"" + s2 + "\" " + s3 + ">" + stringtokenizer1.nextToken() + "</option>\n"))
        {
            stringtokenizer1 = new StringTokenizer(stringtokenizer.nextToken(), ",");
            s2 = stringtokenizer1.nextToken();
            s3 = s1.equalsIgnoreCase(s2) ? "selected" : "";
        }

        return stringbuffer.toString();
    }

    public String getStaticListOptionTag(String s)
    {
        return getStaticListOptionTag(s, "");
    }


	public String getStore_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST"),getLoginFacilityId()));
	}
    public String getItemAnal_code_List(){
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE")));
	}

	public void doOnlineReportPrintingOfLabel(String docno , String doc_type_code, String store_code, String reportid, javax.servlet.http.HttpSession ses) {
		try{
			
//			if (!isInternalRequest("ST",reportid)) return;

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",doc_type_code);
			hmReportParameter.put("p_doc_no",docno);
			// javax.servlet.http.HttpSession session = request.getSession(false);
			
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",ses.getAttribute("jdbc"));
			hmParameters.put("report_server",ses.getAttribute("report_server"));
			hmParameters.put("report_connect_string",ses.getAttribute("report_connect_string"));
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",store_code);
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}
//    public String module_id;
}
