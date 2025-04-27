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
import eST.Common.StAdapter;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ReportsMasterCodeBean extends StAdapter
    implements Serializable
{
//private String language;

    public ReportsMasterCodeBean()
    {
        module_id = "ST";
    }

    public ArrayList getMasterCodeList()
        throws Exception
    {
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        ResultSet resultset = null;
        ArrayList arraylist = new ArrayList();
     //   Object obj = null;
        try
        {
            connection = getConnection();
            preparedstatement = connection.prepareStatement(StRepository.getStKeyValue ("SQL_SM_MASTER_CODE_SELECT_REPORTS_LANG"));
            preparedstatement.setString(1, module_id);
			preparedstatement.setString(2, getLanguageId());
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
/*    
    public String getROFStatus()
    {
        String s = getStRepositoryValue("sql_ST_RQT_TRAY_STATUS");
        ArrayList arraylist = getListOptionArrayList(s);
        return getListOptionTag(arraylist);
    }

    public String getDocTypeForRof()
    {
        String s = getSsRepositoryValue("SQL_SS_DOC_TYPE_ROF_GROUP_SELECT_LIST");
        ArrayList arraylist = getListOptionArrayList(s);
        return getListOptionTag(arraylist);
    }
*/

/*public void setLanguageId(String language) {
		this.language = language;
	}
public String getLanguageId() {
		return this.language;
	}
*/
    public String getNature()
    {
        return getStaticListOptionTag("B,Both;E,Enabled;D,Disabled;");
    }

    public String getExpiryItem()
    {
        return getStaticListOptionTag("A,All;Y,Expiry Items;N,Non Expiry Items;");
    }

    public String getSWPvals()
    {
        return getStaticListOptionTag("B,Both;Y,Yes;N,No;");
    }

    public String getReportType()
    {
        return getStaticListOptionTag("1,Summary;D,Detail;");
    }

    public String getWrite_off_Entry_StatusList()
    {
        return getStaticListOptionTag("A,All;Y,Completed;N,Not Completed;");
    }

    public String getLoadStatusList()
    {
        return getStaticListOptionTag("A,All;P,Passed;F,Failed;");
    }

    public String getWrite_off_finalized_StatusList()
    {
        return getStaticListOptionTag("A,All;Y,Finalized;N,UnFinalized;");
    }

    public String getMonthlyServiceStatisticsList()
    {
        return getStaticListOptionTag("A,Both;C,Item Count Only;L,Load Count Only;");
    }

    public String getRequestOrderStatusSummaryOptionList()
    {
        return getStaticListOptionTag("A,All;RE,Entered;RC,Checked;WE,Washing Entered;WC,Washing Completed;PACK,Packed;HL,Hold;AE,Auto Claving;AC,Auto claved;DI,Dispatched;ACK,Acknowledged");
    }

    public String getDepartmentChargeDetails()
    {
        return getStaticListOptionTag("D,Department;R,Store;");
    }

    public String getGroupCode()
    {
        return getStaticListOptionTag("T,Tray;E,Set;P,Soft Pack;S,Single;A,All;");
    }

    public String getRequest_type_List()
    {
        return getStaticListOptionTag("A,All;N,Normal;U,Urgent;E,Elective;");
    }

    public String getInstRetStatusPatient_List()
    {
        return getStaticListOptionTag("A,All;0,Returned;1,Pending");
    }

    public String getTrayDtlStatusList()
    {
        return getStaticListOptionTag("A,All;U,Unsterilized;S,Sterilized;R,In Service Location;W,Written Off;");
    }

    public String getOrderBySterilizationType()
    {
        return getStaticListOptionTag("1,Sterilization Type Code;2,Sterilization Type Description;");
    }

    public String getOrderByItemClass()
    {
        return getStaticListOptionTag("1,Item Class Code;2,Item Class Description;");
    }

    public String getOrderBySurgeryType()
    {
        return getStaticListOptionTag("1,Surgery Type Code;2,Surgery Type Description;");
    }

    public String getOrderByPrepareLocation()
    {
        return getStaticListOptionTag("1,Prepare Location Code;2,Prepare Location Description;");
    }

    public String getOrderByAutoclaveWashingUnit()
    {
        return getStaticListOptionTag("1,Autoclave Wash Unit Code;2,Autoclave Wash Unit Description;");
    }

    public String getOrderByAutoclaveWashingTest()
    {
        return getStaticListOptionTag("1,Test Code;2,Test Description;");
    }

    public String getOrderByWriteOffReason()
    {
        return getStaticListOptionTag("1,Write Off Reason Code;2,Write Off Reason Description;");
    }

    public String getOrderByUsageType()
    {
        return getStaticListOptionTag("1,Usage Type Code;2,Usage Type Description;");
    }

    public String getOrderBySubClassification()
    {
        return getStaticListOptionTag("1,Sub Classification Code;2,Sub Classification Description;");
    }

    public String getOrderBySterProcessStage()
    {
        return getStaticListOptionTag("1,Process Stage Code;2,Process Stage Description;");
    }

    public String getOrderByWashingType()
    {
        return getStaticListOptionTag("1,Washing Type Code;2,Washing Type Description;");
    }

    public String getOrderByStatGroup()
    {
        return getStaticListOptionTag("1,Statistical Group Code;2,Statistical Group Description;");
    }

    public String getOrderByStore()
    {
        return getStaticListOptionTag("1,Store Code;2,Store Description;3,Department Code;");
    }

    public String getOrderByItem()
    {
        return getStaticListOptionTag("1,Item Code;2,Item Description;");
    }
    public String getOrderByMachine()
    {
        return getStaticListOptionTag("1,Machine Code;2,Machine Name;");
    }
    public String getOrderByGroup()
    {
        return getStaticListOptionTag("1,Group Code;2,Group Description;");
    }

    public String getOrderBySterilizationCost()
    {
        return getStaticListOptionTag("1,Group Code;2,Group Description;");
    }

    public String getOrderByItemForStore()
    {
        return getStaticListOptionTag("1,Store Code;2,Store Description;3,Item Code;4,Item Description;");
    }

    public String getOrderByItemClassForStore()
    {
        return getStaticListOptionTag("1,Store Code;2,Store Description;3,Item Class Code;4,Item Class Description;");
    }

	

    public String getOrderByUserAccessForStore()
    {
        return getStaticListOptionTag("2,User Name;4,Store Description;");
    }

    public String getOrderByTrnDocType()
    {
        return getStaticListOptionTag("1,Doc Type Code;2,Doc Type Description;");
    }

    public String getOrderByExpiryList()
    {
        return getStaticListOptionTag("5,Owner Store Code;7,Current Store Code;2,Group Code;3,Tray No");
    }

    public String getStoreType()
    {
        return getStaticListOptionTag("B,Both;Y,Owner ;N,Requestor;");
    }

public String getOrderByRepackingLocation()
	{
	return getStaticListOptionTag("1,Repacking Group Code;2,Repacking Group Description;");
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
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANAL_CODE_SELECT_SINGLE"),getLanguageId()));
	}

    public String module_id;
}
