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
import eST.Common.StTransaction;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class SRRRePrintDocReportBean extends StTransaction
    implements Serializable
{
	//private String language;
    public ArrayList getTrnTypeList()
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
//* pmd 21/02/2005
//*        Object obj = null;
        try
        {
            connection = getConnection();
            //preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRN_TYPE_SELECT_LIST2"));
            preparedstatement = connection.prepareStatement("SELECT TRN_TYPE, LONG_DESC FROM ST_TRN_TYPE WHERE TRN_TYPE NOT IN ('PRT','OBS','SPB','CBL') ORDER BY 2");
          
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
   
  /* public void setLanguageId(String language) {
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
        return getStaticListOptionTag("I,Item Code;S,Short Description;");
    }
    public String getSpecialItem()
    {
        return getStaticListOptionTag("A,Both;Y,Special Item Only;N,Non Special Item Only;");
    }
/*
    public String getAutoclavable()
    {
        return getStaticListOptionTag("A,All Items;Y,Autoclavable Only ;N,Non Autoclavable;");
    }

    public String getReorderable()
    {
        return getStaticListOptionTag("A,All Items;Y,Reorderable Only ;N,Non Reorderable;");
    }
*/
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

//    public String module_id;


	 public ArrayList getResult(String trn_type,String doc_type_code, String fr_st_code,String to_st_code, String dt_from,String dt_to,String doc_no)   throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList record = new ArrayList();
		ArrayList result	=	new ArrayList();
        try
        {
            connection = getConnection();

			if(trn_type.equals("ADJ")||trn_type.equals("CEB")) {

            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_ADJ_REPORT_SRR"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,trn_type);
			preparedstatement.setString(3,doc_type_code);
			preparedstatement.setString(4,doc_no);
			preparedstatement.setString(5,fr_st_code);
			preparedstatement.setString(6,to_st_code);
			preparedstatement.setString(7,dt_from);
			preparedstatement.setString(8,dt_to);
			preparedstatement.setString(9,getLanguageId());

			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no		=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref		=resultset.getString("doc_ref");
				String	p_store_code	=resultset.getString("store_code");
				String	p_store_desc	=resultset.getString("store_desc");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);

				result.add(record);
			}
			} 
			else if(trn_type.equals("ISS")) {

            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_ISS_REPORT_SRR"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,to_st_code);
			preparedstatement.setString(6,dt_from);
			preparedstatement.setString(7,dt_to);
			preparedstatement.setString(8,getLanguageId());

			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no			=resultset.getString("doc_no");
				String	p_issue_seq		=resultset.getString("issue_seq");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref			=resultset.getString("doc_ref");
				String	p_fm_store_code	=resultset.getString("fm_store_code");
				String	p_fm_store_desc	=resultset.getString("fm_store_desc");
				String	p_to_store_code	=resultset.getString("to_store_code");
				String	p_to_store_desc	=resultset.getString("to_store_desc");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_issue_seq);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_fm_store_code);
				record.add(p_fm_store_desc);
				record.add(p_to_store_code);
				record.add(p_to_store_desc);

				result.add(record);
			}
			}  else if(trn_type.equals("MFG")) {
			 preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_MFG_REPORT"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,dt_from);
			preparedstatement.setString(6,dt_to);
			preparedstatement.setString(7,getLanguageId());

			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no			=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref			=resultset.getString("doc_ref");
				String	p_store_code		=resultset.getString("store_code");
				String	p_store_desc		=resultset.getString("store_desc");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);

				result.add(record);
			}
			}
			 else if(trn_type.equals("REQ")) {
				 /* (SELECT COUNT (*) FROM st_request_dtl dtl WHERE dtl.doc_no = a.doc_no AND dtl.facility_id = a.facility_id AND dtl.doc_type_code = a.doc_type_code) no_of_items*/

            preparedstatement = connection.prepareStatement("SELECT a.doc_type_code, b.short_desc doc_type_desc, a.doc_no, to_char(a.doc_date,'dd/mm/yyyy') doc_date,a.doc_ref, a.req_by_store_code, c.short_desc req_by_store_desc,a.req_on_store_code, d.short_desc req_on_store_desc,(SELECT COUNT (*) FROM st_request_dtl dtl WHERE dtl.doc_no = a.doc_no AND dtl.facility_id = a.facility_id AND dtl.doc_type_code = a.doc_type_code) no_of_items FROM st_request_hdr a, sy_doc_type_master_lang_vw b, mm_store_lang_vw c, mm_store_lang_vw d WHERE a.facility_id= ? AND a.doc_type_code=b.doc_type_code AND a.req_by_store_code=c.store_code AND a.req_on_store_code=d.store_code AND a.REQ_AUTHORIZED_BY_ID IS NOT NULL AND a.doc_type_code LIKE NVL(?,'%') AND a.doc_no LIKE NVL(?,'%') AND a.req_by_store_code LIKE NVL(upper(?),'%') AND a.req_on_store_code LIKE NVL(upper(?),'%') AND TRUNC(a.doc_date) BETWEEN TO_DATE(NVL(?,'01/01/1472'),'DD/MM/RRRR') AND TO_DATE(NVL(?,'31/12/5000'),'DD/MM/RRRR') AND b.language_id=c.language_id AND b.language_id = d.language_id AND b.language_id = ? ORDER BY a.doc_type_code,a.doc_no,a.doc_date");
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,to_st_code);
			preparedstatement.setString(6,dt_from);
			preparedstatement.setString(7,dt_to);
			preparedstatement.setString(8,getLanguageId());


			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no			=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref			=resultset.getString("doc_ref");
				String	p_fm_store_code	=resultset.getString("req_by_store_code");
				String	p_fm_store_desc	=resultset.getString("req_by_store_desc");
				String	p_to_store_code	=resultset.getString("req_on_store_code");
				String	p_to_store_desc	=resultset.getString("req_on_store_desc");
				String	p_no_of_items	=resultset.getString("no_of_items");


				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_fm_store_code);
				record.add(p_fm_store_desc);
				record.add(p_to_store_code);
				record.add(p_to_store_desc);
				record.add(p_no_of_items);

				result.add(record);
			}
			
			}
			else if(trn_type.equals("TFR")) {

            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_TFR_REPORT"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,fr_st_code);
			preparedstatement.setString(6,dt_from);
			preparedstatement.setString(7,dt_to);
			preparedstatement.setString(8,getLanguageId());

			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no			=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref			=resultset.getString("doc_ref");
				String	p_fm_store_code	=resultset.getString("fm_store_code");
				String	p_fm_store_desc	=resultset.getString("fm_store_desc");
				String	p_to_store_code	=resultset.getString("to_store_code");
				String	p_to_store_desc	=resultset.getString("to_store_desc");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_fm_store_code);
				record.add(p_fm_store_desc);
				record.add(p_to_store_code);
				record.add(p_to_store_desc);

				result.add(record);
			}
			}
			else if(trn_type.equals("URG")) {

            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_URG_REPORT"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,fr_st_code);
			preparedstatement.setString(6,dt_from);
			preparedstatement.setString(7,dt_to);
			preparedstatement.setString(8,getLanguageId());
			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no			=resultset.getString("doc_no");
				String	p_issue_seq		=resultset.getString("issue_seq");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref			=resultset.getString("doc_ref");
				String	p_fm_store_code	=resultset.getString("fm_store_code");
				String	p_fm_store_desc	=resultset.getString("fm_store_desc");
				String	p_to_store_code	=resultset.getString("to_store_code");
				String	p_to_store_desc	=resultset.getString("to_store_desc");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_issue_seq);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_fm_store_code);
				record.add(p_fm_store_desc);
				record.add(p_to_store_code);
				record.add(p_to_store_desc);

				result.add(record);
			}
			}
			else if(trn_type.equals("VAR")) {
			 preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_VAR_REPORT"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,dt_from);
			preparedstatement.setString(6,dt_to);
			preparedstatement.setString(7,getLanguageId());
			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no			=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref			=resultset.getString("doc_ref");
				String	p_store_code		=resultset.getString("store_code");
				String	p_store_desc		=resultset.getString("store_desc");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);

				result.add(record);
			}}
			else if(trn_type.equals("SAL")) {
			preparedstatement = connection.prepareStatement("SELECT  a.doc_type_code, b.short_desc doc_type_desc, a.doc_no,to_char(a.doc_date,'dd/mm/yyyy') doc_date, a.doc_ref, a.store_code, c.short_desc store_desc,a.patient_id patient_id FROM st_sal_hdr  a, sy_doc_type_master_lang_vw b, mm_store_lang_vw c WHERE  a.facility_id = ? AND a.doc_type_code = b.doc_type_code AND a.store_code  = c.store_code AND module_id = 'ST' AND a.finalized_yn ='Y'   AND a.doc_type_code LIKE NVL(?,'%') AND a.doc_no LIKE NVL(?,'%') AND c.store_code LIKE NVL(upper(?),'%') AND TRUNC(a.doc_date) BETWEEN TO_DATE(NVL(?,'01/01/1472'),'DD/MM/RRRR') AND TO_DATE(NVL(?,'31/12/5000'),'DD/MM/RRRR') AND b.language_id = c.language_id AND b.language_id = ? ORDER BY a.doc_type_code,a.doc_no,a.doc_date");
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,dt_from);
			preparedstatement.setString(6,dt_to);
			preparedstatement.setString(7,getLanguageId());

			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no			=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref			=resultset.getString("doc_ref");
				String	p_store_code		=resultset.getString("store_code");
				String	p_store_desc		=resultset.getString("store_desc");
				String	p_patient_id		=resultset.getString("patient_id");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);
				record.add(p_patient_id);

				result.add(record);
			}
			}
			else if(trn_type.equals("SRT")) {
			 preparedstatement = connection.prepareStatement("SELECT a.doc_type_code, b.short_desc doc_type_desc, a.doc_no,to_char(a.doc_date,'dd/mm/yyyy') doc_date, a.doc_ref, a.store_code, c.short_desc store_desc,a.patient_id patient_id FROM st_sal_ret_hdr a, sy_doc_type_master_lang_vw b, mm_store_lang_vw c WHERE a.facility_id= ? AND a.doc_type_code = b.doc_type_code AND a.store_code    = c.store_code AND a.finalized_yn ='Y' AND a.doc_type_code LIKE NVL(?,'%') AND a.doc_no LIKE NVL(?,'%') AND c.store_code LIKE NVL(upper(?),'%') AND TRUNC(a.doc_date) BETWEEN TO_DATE(NVL(?,'01/01/1472'),'DD/MM/RRRR') AND TO_DATE(NVL(?,'31/12/5000'),'DD/MM/RRRR') AND b.language_id = c.language_id AND b.language_id = ? ORDER BY a.doc_type_code,a.doc_no,a.doc_date");
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,dt_from);
			preparedstatement.setString(6,dt_to);
			preparedstatement.setString(7,getLanguageId());

			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no		=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref		=resultset.getString("doc_ref");
				String	p_store_code	=resultset.getString("store_code");
				String	p_store_desc	=resultset.getString("store_desc");
				String	p_patient_id		=resultset.getString("patient_id");


				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);
				record.add(p_patient_id);

				result.add(record);
			}
			}else if(trn_type.equals("RET")) {

            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_RET_REPORT_SRR"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,to_st_code);
			preparedstatement.setString(6,dt_from);
			preparedstatement.setString(7,dt_to);
			preparedstatement.setString(8,getLanguageId());

			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no			=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref			=resultset.getString("doc_ref");
				String	p_fm_store_code	=resultset.getString("fm_store_code");
				String	p_fm_store_desc	=resultset.getString("fm_store_desc");
				String	p_to_store_code	=resultset.getString("to_store_code");
				String	p_to_store_desc	=resultset.getString("to_store_desc");
				String	p_no_of_items	=resultset.getString("no_of_items");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_fm_store_code);
				record.add(p_fm_store_desc);
				record.add(p_to_store_code);
				record.add(p_to_store_desc);
				record.add(p_no_of_items);

				result.add(record);
			}
			}else
			if(trn_type.equals("RTV")) {

            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_RTV_REPORT"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,dt_from);
			preparedstatement.setString(6,dt_to);
			preparedstatement.setString(7,getLanguageId());
			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no		=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref		=resultset.getString("doc_ref");
				String	p_store_code	=resultset.getString("store_code");
				String	p_store_desc	=resultset.getString("store_desc");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);

				result.add(record);
			}
			} 
			else if(trn_type.equals("GRN")) {

            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_GRN_REPORT"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,dt_from);
			preparedstatement.setString(6,dt_to);
			preparedstatement.setString(7,getLanguageId());
			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no		=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref		=resultset.getString("doc_ref");
				String	p_store_code	=resultset.getString("store_code");
				String	p_store_desc	=resultset.getString("store_desc");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);

				result.add(record);
			}
			} else if(trn_type.equals("PRT"))
			{

            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_TRANS_SUMM_PRT_REPORT"));
			preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,dt_from);
			preparedstatement.setString(6,dt_to);
			preparedstatement.setString(7,getLanguageId());
			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no		=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref		=resultset.getString("doc_ref");
				String	p_store_code	=resultset.getString("store_code");

				String	p_store_desc	=resultset.getString("store_desc");

				
				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_store_code);
				record.add(p_store_desc);

				result.add(record);
									}
				}else if(trn_type.equals("AIS"))
			{
				
				preparedstatement = connection.prepareStatement("SELECT a.doc_type_code, b.short_desc doc_type_desc, a.doc_no, to_char(a.doc_date,'dd/mm/yyyy') doc_date,a.doc_ref, a.req_by_store_code, c.short_desc req_by_store_desc,a.req_on_store_code, d.short_desc req_on_store_desc FROM st_request_hdr a, sy_doc_type_master_lang_vw b, mm_store_lang_vw c, mm_store_lang_vw d WHERE a.facility_id= ? AND a.doc_type_code=b.doc_type_code AND a.req_by_store_code=c.store_code AND a.req_on_store_code=d.store_code AND a.REQ_AUTHORIZED_BY_ID IS NOT NULL AND a.doc_type_code LIKE NVL(?,'%') AND a.doc_no LIKE NVL(?,'%') AND a.req_by_store_code LIKE NVL(upper(?),'%') AND a.req_on_store_code LIKE NVL(upper(?),'%') AND TRUNC(a.doc_date) BETWEEN TO_DATE(NVL(?,'01/01/1472'),'DD/MM/RRRR') AND TO_DATE(NVL(?,'31/12/5000'),'DD/MM/RRRR') AND b.language_id=c.language_id AND b.language_id = d.language_id AND a.request_status = 'A' AND b.language_id = ? ORDER BY a.doc_type_code,a.doc_no,a.doc_date");
		  	preparedstatement.setString(1,login_facility_id);
			preparedstatement.setString(2,doc_type_code);
			preparedstatement.setString(3,doc_no);
			preparedstatement.setString(4,fr_st_code);
			preparedstatement.setString(5,to_st_code);
			preparedstatement.setString(6,dt_from);
			preparedstatement.setString(7,dt_to);
			preparedstatement.setString(8,getLanguageId());


			resultset = preparedstatement.executeQuery();

			while(resultset!=null && resultset.next()) {
				record	=	new ArrayList();

				String	p_doc_type_code	=resultset.getString("doc_type_code");
				String	p_doc_type_desc	=resultset.getString("doc_type_desc");
				String	p_doc_no			=resultset.getString("doc_no");
				String	p_doc_date		=resultset.getString("doc_date");
				String	p_doc_ref			=resultset.getString("doc_ref");
				String	p_fm_store_code	=resultset.getString("req_by_store_code");
				String	p_fm_store_desc	=resultset.getString("req_by_store_desc");
				String	p_to_store_code	=resultset.getString("req_on_store_code");
				String	p_to_store_desc	=resultset.getString("req_on_store_desc");

				record.add(p_doc_type_code);
				record.add(p_doc_type_desc);
				record.add(p_doc_no);
				record.add(p_doc_date);
				record.add(p_doc_ref);
				record.add(p_fm_store_code);
				record.add(p_fm_store_desc);
				record.add(p_to_store_code);
				record.add(p_to_store_desc);

				result.add(record);
							
				}
			}
		} catch(Exception exception)
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

}
