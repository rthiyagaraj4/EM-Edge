/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;
import ePH.PhATCClassLevel.*;
//saved on 27/10/2005
public class ATCClassificationBean extends PhAdapter implements Serializable {

    protected String atc_class_lev_code_1   =   "";
    protected String atc_class_lev_code_2   =   "";
    protected String atc_class_lev_code_3   =   "";
    protected String atc_class_lev_code_4   =   "";
    protected String atc_class_lev_code_5   =   "";
    protected String atc_class_lev_code_6   =   "";
    protected String atc_class_lev_code_7   =   "";
    protected String atc_class_lev_code_8   =   "";
    protected String atc_class_lev_code_9   =   "";
    protected String atc_class_lev_code_10  =   "";

    protected String atc_class_lev_desc_1   =   "";
    protected String atc_class_lev_desc_2   =   "";
    protected String atc_class_lev_desc_3   =   "";
    protected String atc_class_lev_desc_4   =   "";
    protected String atc_class_lev_desc_5   =   "";
    protected String atc_class_lev_desc_6   =   "";
    protected String atc_class_lev_desc_7   =   "";
    protected String atc_class_lev_desc_8   =   "";
    protected String atc_class_lev_desc_9   =   "";
    protected String atc_class_lev_desc_10  =   "";

    protected int display_seq_no_1      =   0;
    protected int display_seq_no_2      =   0;
    protected int display_seq_no_3      =   0;
    protected int display_seq_no_4      =   0;
    protected int display_seq_no_5      =   0;
    protected int display_seq_no_6      =   0;
    protected int display_seq_no_7      =   0;
    protected int display_seq_no_8      =   0;
    protected int display_seq_no_9      =   0;
    protected int display_seq_no_10     =   0;

    protected String select_1           =   "";
    protected String select_2           =   "";
    protected String select_3           =   "";
    protected String select_4           =   "";
    protected String select_5           =   "";
    protected String select_6           =   "";
    protected String select_7           =   "";
    protected String select_8           =   "";
    protected String select_9           =   "";
    protected String select_10          =   "";


    protected String atc_class_lev1_code    =   "" ;
    protected String atc_class_lev2_code    =   "" ;
    protected String atc_class_lev3_code    =   "" ;
    protected String atc_class_lev4_code    =   "" ;
    protected String atc_class_lev5_code    =   "" ;
    protected String atc_class_lev1_desc    =   "" ;
    protected String atc_class_lev2_desc    =   "" ;
    protected String atc_class_lev3_desc    =   "" ;
    protected String atc_class_lev4_desc    =   "" ;
    protected String atc_class_lev5_desc    =   "" ;
    protected int display_seq_no            =   0 ;
    protected String level_no               =   "" ;
    protected String level_one_code         =   "";
    protected String level2_code            =   "";
    protected String level3_code            =   "";
    protected String level4_code            =   "";
	protected String innerMode				=	"";
    protected Vector values                 =    new Vector();
	protected Vector temp_values			=	 new Vector();
    protected Vector values_1               =    new Vector();
    protected Vector values_2               =    new Vector();
    protected Vector values_3               =    new Vector();
    protected Vector values_4               =    new Vector();
    protected Vector values_5               =    new Vector();
    protected Vector  recs                  =    null;

    String debug="";

	private HashMap pharma_level_codes = null;
    protected ArrayList insertObjects=null;
    protected ArrayList whereObjects=null;


    public ATCClassificationBean() {
       try {
            doCommon();
        }catch(Exception e) {e.printStackTrace();}
    }

    /* Multiple Records Set Methods Start */
    //  First
    public void setATCLevCode1( String atc_class_lev_code_1 ) {
        this.atc_class_lev_code_1 = atc_class_lev_code_1  ;
    }

    public void setATCLevDesc1( String atc_class_lev_desc_1 ) {
        this.atc_class_lev_desc_1 = atc_class_lev_desc_1  ;
    }

    public void setDisplaySeqNo1( int display_seq_no_1 ) {
        this.display_seq_no_1 = display_seq_no_1  ;
    }

    public void setSelect_1(String select_1)    {
        this.select_1   =   select_1;
    }
    //  Second
    public void setATCLevCode2( String atc_class_lev_code_2 ) {
        this.atc_class_lev_code_2 = atc_class_lev_code_2  ;
    }

    public void setATCLevDesc2( String atc_class_lev_desc_2 ) {
        this.atc_class_lev_desc_2 = atc_class_lev_desc_2  ;
    }

    public void setDisplaySeqNo2( int display_seq_no_2 ) {
        this.display_seq_no_2 = display_seq_no_2  ;
    }
    public void setSelect_2(String select_2)    {
        this.select_2   =   select_2;
    }
    //  Third
    public void setATCLevCode3( String atc_class_lev_code_3 ) {
        this.atc_class_lev_code_3 = atc_class_lev_code_3  ;
    }

    public void setATCLevDesc3( String atc_class_lev_desc_3 ) {
        this.atc_class_lev_desc_3 = atc_class_lev_desc_3  ;
    }

    public void setDisplaySeqNo3( int display_seq_no_3 ) {
        this.display_seq_no_3 = display_seq_no_3  ;
    }

    public void setSelect_3(String select_3)    {
        this.select_3   =   select_3;
    }
    //  Fourth
    public void setATCLevCode4( String atc_class_lev_code_4 ) {
        this.atc_class_lev_code_4 = atc_class_lev_code_4  ;
    }

    public void setATCLevDesc4( String atc_class_lev_desc_4 ) {
        this.atc_class_lev_desc_4 = atc_class_lev_desc_4  ;
    }

    public void setDisplaySeqNo4( int display_seq_no_4 ) {
        this.display_seq_no_4   = display_seq_no_4  ;
    }

    public void setSelect_4(String select_4)    {
        this.select_4   =   select_4;
    }
    //  Fifth
    public void setATCLevCode5( String atc_class_lev_code_5 ) {
        this.atc_class_lev_code_5 = atc_class_lev_code_5  ;
    }

    public void setATCLevDesc5( String atc_class_lev_desc_5 ) {
        this.atc_class_lev_desc_5 = atc_class_lev_desc_5  ;
    }

    public void setDisplaySeqNo5( int display_seq_no_5 ) {
        this.display_seq_no_5   = display_seq_no_5  ;
    }

    public void setSelect_5(String select_5)    {
        this.select_5   =   select_5;
    }
    //  Sixth
    public void setATCLevCode6( String atc_class_lev_code_6 ) {
        this.atc_class_lev_code_6 = atc_class_lev_code_6  ;
    }

    public void setATCLevDesc6( String atc_class_lev_desc_6 ) {
        this.atc_class_lev_desc_6 = atc_class_lev_desc_6  ;
    }

    public void setDisplaySeqNo6( int display_seq_no_6 ) {
        this.display_seq_no_6 = display_seq_no_6  ;
    }

    public void setSelect_6(String select_6)    {
        this.select_6   =   select_6;
    }
    //  Seven
    public void setATCLevCode7( String atc_class_lev_code_7 ) {
        this.atc_class_lev_code_7 = atc_class_lev_code_7  ;
    }

    public void setATCLevDesc7( String atc_class_lev_desc_7 ) {
        this.atc_class_lev_desc_7 = atc_class_lev_desc_7  ;
    }

    public void setDisplaySeqNo7( int display_seq_no_7 ) {
        this.display_seq_no_7 = display_seq_no_7  ;
    }

    public void setSelect_7(String select_7)    {
        this.select_7   =   select_7;
    }
    //  Eighth
    public void setATCLevCode8( String atc_class_lev_code_8 ) {
        this.atc_class_lev_code_8 = atc_class_lev_code_8  ;
    }

    public void setATCLevDesc8( String atc_class_lev_desc_8 ) {
        this.atc_class_lev_desc_8 = atc_class_lev_desc_8  ;
    }

    public void setDisplaySeqNo8( int display_seq_no_8 ) {
        this.display_seq_no_8 = display_seq_no_8  ;
    }

    public void setSelect_8(String select_8)    {
        this.select_8   =   select_8;
    }
    //  Ninth
    public void setATCLevCode9( String atc_class_lev_code_9 ) {
        this.atc_class_lev_code_9 = atc_class_lev_code_9  ;
    }

    public void setATCLevDesc9( String atc_class_lev_desc_9 ) {
        this.atc_class_lev_desc_9 = atc_class_lev_desc_9  ;
    }

    public void setDisplaySeqNo9( int display_seq_no_9 ) {
        this.display_seq_no_9   = display_seq_no_9  ;
    }

    public void setSelect_9(String select_9)    {
        this.select_9   =   select_9;
    }
    //  Tenth
    public void setATCLevCode10( String atc_class_lev_code_10 ) {
        this.atc_class_lev_code_10 = atc_class_lev_code_10  ;
    }

    public void setATCLevDesc10( String atc_class_lev_desc_10 ) {
        this.atc_class_lev_desc_10 = atc_class_lev_desc_10  ;
    }

    public void setDisplaySeqNo10( int display_seq_no_10 ) {
        this.display_seq_no_10  = display_seq_no_10  ;
    }

    public void setSelect_10(String select_10)  {
        this.select_10  =   select_10;
    }

/********* Multiple Record set methods End ***************************/

/* Multiple Records Get Methods Start */
    //  First
    public String getATCLevCode1() {
        return this.atc_class_lev_code_1;
    }

    public String getATCLevDesc1() {
        return this.atc_class_lev_desc_1 ;
    }

    public int getDisplaySeqNo1() {
        return this.display_seq_no_1;
    }

    public String getSelect_1() {
        return this.select_1;
    }

    //  Second
    public String getATCLevCode2() {
        return this.atc_class_lev_code_2;
    }

    public String getATCLevDesc2() {
        return this.atc_class_lev_desc_2;
    }

    public int getDisplaySeqNo2() {
        return this.display_seq_no_2;
    }

    public String getSelect_2() {
        return this.select_2;
    }
    //  Third
    public String getATCLevCode3() {
        return this.atc_class_lev_code_3;
    }

    public String getATCLevDesc3() {
        return this.atc_class_lev_desc_3;
    }

    public int getDisplaySeqNo3() {
        return this.display_seq_no_3;
    }

    public String getSelect_3() {
        return this.select_3;
    }
    //  Fourth
    public String getATCLevCode4() {
        return this.atc_class_lev_code_4;
    }

    public String getATCLevDesc4() {
        return this.atc_class_lev_desc_4;
    }

    public int getDisplaySeqNo4() {
        return this.display_seq_no_4;
    }

    public String getSelect_4() {
        return this.select_4;
    }
    //  Fifth
    public String getATCLevCode5() {
        return this.atc_class_lev_code_5;
    }

    public String getATCLevDesc5() {
        return this.atc_class_lev_desc_5;
    }

    public int getDisplaySeqNo5() {
        return this.display_seq_no_5;
    }

    public String getSelect_5() {
        return this.select_5;
    }
    //  Sixth
    public String getATCLevCode6() {
        return this.atc_class_lev_code_6;
    }

    public String getATCLevDesc6() {
        return this.atc_class_lev_desc_6;
    }

    public int getDisplaySeqNo6() {
        return this.display_seq_no_6;
    }

    public String getSelect_6() {
        return this.select_6;
    }
    //  Seven
    public String getATCLevCode7() {
        return this.atc_class_lev_code_7;
    }

    public String getATCLevDesc7() {
        return this.atc_class_lev_desc_7;
    }

    public int getDisplaySeqNo7() {
        return this.display_seq_no_7;
    }

    public String getSelect_7() {
        return this.select_7;
    }
    //  Eighth
    public String getATCLevCode8() {
        return this.atc_class_lev_code_8;
    }

    public String getATCLevDesc8() {
        return this.atc_class_lev_desc_8;
    }

    public int getDisplaySeqNo8() {
        return this.display_seq_no_8;
    }

    public String getSelect_8() {
        return this.select_8;
    }
    //  Ninth
    public String getATCLevCode9() {
        return this.atc_class_lev_code_9;
    }

    public String getATCLevDesc9() {
        return this.atc_class_lev_desc_9;
    }

    public int getDisplaySeqNo9() {
        return this.display_seq_no_9  ;
    }

    public String getSelect_9() {
        return this.select_9;
    }
    //  Tenth
    public String getATCLevCode10() {
        return this.atc_class_lev_code_10;
    }

    public String getATCLevDesc10() {
        return this.atc_class_lev_desc_10 ;
    }

    public int getDisplaySeqNo10() {
        return this.display_seq_no_10;
    }

    public String getSelect_10() {
        return this.select_10;
    }
/********* Multiple Record get methods End ***************************/
	public void setInnerMode(String mode){
		innerMode	=	mode;
	}

	public String getInnerMode(){
		return innerMode;
	}


    private void setmandatoryObjects(){
		if(insertObjects!=null){
			insertObjects.add( login_by_id ) ;
			insertObjects.add( login_at_ws_no ) ;
			insertObjects.add( login_facility_id ) ;
			insertObjects.add( login_by_id ) ;
			insertObjects.add( login_at_ws_no ) ;
			insertObjects.add( login_facility_id ) ;
		}
    }

/*******************Single Record Set and Get Methods ***************************/

    public void setATCLev1Code( String atc_class_lev1_code ) {
        this.atc_class_lev1_code = atc_class_lev1_code  ;
    }

    public void setATCLev2Code( String atc_class_lev2_code ) {
        this.atc_class_lev2_code = atc_class_lev2_code  ;
    }

    public void setATCLev3Code( String atc_class_lev3_code ) {
        this.atc_class_lev3_code = atc_class_lev3_code  ;
    }

    public void setATCLev4Code( String atc_class_lev4_code ) {
        this.atc_class_lev4_code = atc_class_lev4_code  ;
    }

    public void setATCLev5Code( String atc_class_lev5_code ) {
        this.atc_class_lev5_code = atc_class_lev5_code  ;
    }


    public void setATCLev1Desc( String atc_class_lev1_desc ) {
        this.atc_class_lev1_desc = atc_class_lev1_desc  ;
    }

    public void setATCLev2Desc( String atc_class_lev2_desc ) {
        this.atc_class_lev2_desc = atc_class_lev2_desc  ;
    }

    public void setATCLev3Desc( String atc_class_lev3_desc ) {
            this.atc_class_lev3_desc = atc_class_lev3_desc  ;
    }

    public void setATCLev4Desc( String atc_class_lev4_desc ) {
            this.atc_class_lev4_desc = atc_class_lev4_desc  ;
    }

    public void setATCLev5Desc( String atc_class_lev5_desc ) {
            this.atc_class_lev5_desc = atc_class_lev5_desc  ;
    }

    public void setDisplaySeqNo( int display_seq_no ) {
        this.display_seq_no  = display_seq_no ;
    }

    public void setLevelNo ( String level_no ) {
        this.level_no = level_no ;
    }

	public void resetRecords(String level_no,int start, int end){
		switch (Integer.parseInt(level_no)) {
			case 1:
				for(int i=start; i<end; i++)    {
					temp_values.set(i,values_1.get(i));
				}
			break;

			case 2:
				for(int i=start; i<end; i++){
				   temp_values.set(i,values_2.get(i));
				}
			break;

			case 3:
				for(int i=start; i<end; i++)    {
					temp_values.set(i,values_3.get(i));
				}
			break;

			case 4:
				for(int i=start; i<end; i++)    {
					temp_values.set(i,values_4.get(i));
				}
			break;

			case 5:
				for(int i=start; i<end; i++)    {
					temp_values.set(i,values_5.get(i));
				}
			break;
        }
	}

    public void updateRecords(String level_no, Vector vals ,int start){

        switch (Integer.parseInt(level_no)){
			case 1:
				for(int i=0; i<vals.size(); i++){
					temp_values.set(start,vals.get(i));
					start++;
				}
			break;

			case 2:
				for(int i=0; i<vals.size(); i++)    {
					temp_values.set(start,vals.get(i));
					start++;
				}
			break;

			case 3:
				for(int i=0; i<vals.size(); i++)    {
					temp_values.set(start,vals.get(i));
					start++;
				}
			break;

			case 4:
				for(int i=0; i<vals.size(); i++)    {
					temp_values.set(start,vals.get(i));
					start++;
				}
			break;

			case 5:
				for(int i=0; i<vals.size(); i++)    {
					temp_values.set(start,vals.get(i));
					start++;
				}
			break;
        }
    }

    public void setRecords  (String level_no, Vector vals ){
        switch (Integer.parseInt(level_no)){
			case 1:
				values_1   =(Vector) vals.clone();
			break;

			case 2:
				values_2   = (Vector)vals.clone();
			break;

			case 3:
				values_3   = (Vector)vals.clone();
			break;

			case 4:
				values_4   = (Vector)vals.clone();
			break;

			case 5:
				values_5   = (Vector)vals.clone();
			break;
        }
    }

    /* Set Methods End */

    /* Get Methods Start */
    public String getATCLev1Code() {
        return this.atc_class_lev1_code  ;
    }

    public String getATCLev2Code() {
        return this.atc_class_lev2_code  ;
    }

    public String getATCLev3Code() {
        return this.atc_class_lev3_code  ;
    }

    public String getATCLev4Code() {
        return this.atc_class_lev4_code  ;
    }

    public String getATCLev5Code() {
        return this.atc_class_lev5_code  ;
    }

    public String getATCLev1Desc() {
        return this.atc_class_lev1_desc  ;
    }

    public String getATCLev2Desc() {
        return this.atc_class_lev2_desc  ;
    }

    public String getATCLev3Desc() {
        return this.atc_class_lev3_desc  ;
    }

    public String getATCLev4Desc() {
        return this.atc_class_lev4_desc  ;
    }

    public String getATCLev5Desc() {
        return this.atc_class_lev5_desc  ;
    }

    public int getDisplaySeqNo () {
        return this.display_seq_no ;
    }


	public Vector getRecords(String level_no) {

		switch (Integer.parseInt(level_no)) {
			case 1:
				temp_values   = (Vector) values_1.clone();
			break;

			case 2:
				temp_values   = (Vector) values_2.clone();
			break;

			case 3:
				temp_values   = (Vector) values_3.clone();
			break;

			case 4:
				temp_values   = (Vector) values_4.clone();
			break;

			case 5:
				temp_values    = (Vector) values_5.clone();
			break;
		}
		return temp_values;

    }

	public Vector getTempValues(){ 
		return temp_values;
	}
    public String getLevelNo () {
        return this.level_no ;
    }

	public String getDebug(){
		return debug;
	}

	public ArrayList getPharmaLevelClassification(String level_num){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList result		= new ArrayList();
		HashMap tmp_level_codes = getPharmaLevelCodes();
		try{
			connection		= getConnection() ;
			String str_qry	= "";
			if(level_num.equals("1")){
				str_qry			= PhRepository.getPhKeyValue("SQL_PH_PHARMACO_SEARCH_SELECT11");
				pstmt			= connection.prepareStatement(str_qry) ;
				resultSet		= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					result.add(resultSet.getString("DRUG_CLASS_GROUP_NO"));
					result.add(resultSet.getString("DRUG_CLASS_GROUP_DESC"));
				}
			}
			else if(level_num.equals("2")){
				str_qry			= PhRepository.getPhKeyValue("SQL_PH_PHARMACO_SEARCH_SELECT12");
				pstmt			= connection.prepareStatement(str_qry) ;				
				pstmt.setString(1,(String)tmp_level_codes.get("level_code_1"));
				resultSet		= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					result.add(resultSet.getString("DRUG_CLASS_DTL_GROUP_NO_1"));
					result.add(resultSet.getString("DRUG_CLASS_DTL_GROUP_DESC_1"));
				}
			}
			else if(level_num.equals("3")){
				str_qry			= PhRepository.getPhKeyValue("SQL_PH_PHARMACO_SEARCH_SELECT13");
				pstmt			= connection.prepareStatement(str_qry) ;
				pstmt.setString(1,(String)tmp_level_codes.get("level_code_1"));
				pstmt.setString(2,(String)tmp_level_codes.get("level_code_2"));
				resultSet		= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					result.add(resultSet.getString("DRUG_CLASS_DTL_GROUP_NO_2"));
					result.add(resultSet.getString("DRUG_CLASS_DTL_GROUP_DESC_2"));
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( e ) ;
            e.printStackTrace() ;
		}
		finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return result;
	}
    /* Get Methods End */

    /* Over-ridden Adapter methods start here */
    public HashMap validate() throws Exception{
        Connection connection       =   null ;
        PreparedStatement pstmt     =   null ;
        ResultSet resultSet         =   null ;
        String sql_query            =   "";
        String level_no             =   "";
        String seq_no               =   "";
        String bean_code            =   "";
        String code                 =   "";

        HashMap map                 =   new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;

		try {
			if(this.getMode().equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && this.getInnerMode().equals("")){
				level_no            =   this.getLevelNo();
				display_seq_no      =   this.getDisplaySeqNo();

				try {
					if( level_no.equals("1"))
						sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL1_DISP_SELECT");
					else if( level_no.equals("2"))
						sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL2_DISP_SELECT");
					else if( level_no.equals("3"))
						sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL3_DISP_SELECT");
					else if( level_no.equals("4"))
						sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL4_DISP_SELECT");
					else if( level_no.equals("5"))
						sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL5_DISP_SELECT");

					connection  = getConnection() ;
					pstmt       = connection.prepareStatement(sql_query) ;

					if(level_no.equals("1")) {
                        pstmt.setInt(1,display_seq_no);
                        bean_code   =   this.getATCLev1Code();
					}
					else if(level_no.equals("2")) {
                        pstmt.setInt(1,display_seq_no);
                        pstmt.setString(2,this.getATCLev1Code());
                        bean_code   =   this.getATCLev2Code();
					}
					else if(level_no.equals("3")) {
                        pstmt.setInt(1,display_seq_no);
                        pstmt.setString(2,this.getATCLev1Code());
                        pstmt.setString(3,this.getATCLev2Code());
                        bean_code   =   this.getATCLev3Code();
					}
					else if(level_no.equals("4")) {
                        pstmt.setInt(1,display_seq_no);
                        pstmt.setString(2,this.getATCLev1Code());
                        pstmt.setString(3,this.getATCLev2Code());
                        pstmt.setString(4,this.getATCLev3Code());
                        bean_code   =   this.getATCLev4Code();
					}
					else if(level_no.equals("5")) {
                        pstmt.setInt(1,display_seq_no);
                        pstmt.setString(2,this.getATCLev1Code());
                        pstmt.setString(3,this.getATCLev2Code());
                        pstmt.setString(4,this.getATCLev3Code());
                        pstmt.setString(5,this.getATCLev4Code());
                        bean_code   =   this.getATCLev5Code();
					}

					resultSet   =   pstmt.executeQuery();

					while(resultSet.next()){
						if(level_no.equals("1"))
							code    =   resultSet.getString("ATC_CLASS_LEV1_CODE");
						else if(level_no.equals("2"))
							code    =   resultSet.getString("ATC_CLASS_LEV2_CODE");
						else if(level_no.equals("3"))
							code    =   resultSet.getString("ATC_CLASS_LEV3_CODE");
						else if(level_no.equals("4"))
							code    =   resultSet.getString("ATC_CLASS_LEV4_CODE");
						else if(level_no.equals("5"))
							code    =   resultSet.getString("ATC_CLASS_LEV5_CODE");

						seq_no  =   resultSet.getString("DISPLAY_SEQ_NO");
					}

					if((code==null || code.equals("") ) && (seq_no == null || seq_no.equals("")) ) {
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "success.." ) ;
					}
					else if(code.equals(bean_code)) {
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "success.." ) ;
					}
					else    {
						map.put( "result", new Boolean( false ) ) ;
						map.put( "message", "Duplicate Display Sequence Number" ) ;
					}


				}
				catch ( Exception e ) {
					System.err.println( "Error loading values from database" ) ;
					e.printStackTrace() ;
					throw e ;
				}
				finally {
					try{
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
						closeConnection( connection );
						}catch(Exception es){es.printStackTrace();}
				  }
			}
			else if(this.getInnerMode().equals("MODIFY_ALL") ){
				Vector record	=	null;
				String tmp_desc		=	"";
				String tmp_dispno	=	"";
				String blank_desc	=	"";
				String blank_no		=	"";
				String dup_no		=	"";
				String dup_vals		=	"";
				boolean entered		=	false;

				ArrayList tmp_disp	=	new ArrayList();
				for(int k=0; k<temp_values.size(); k++)	{
					record	=	new Vector();
					record	=	(Vector)temp_values.get(k);

					if(record.size() > 0)	{
						tmp_desc		=	(String)record.get(1);
						tmp_dispno		=	(String)record.get(2);
					}
					if((tmp_desc==null || tmp_desc.equals("") )) {
						entered			=		true;

						if(k!=0)
							blank_desc	=blank_desc+	","+k;
						else
							blank_desc	=blank_desc+	""+k;
						continue;
					}
					else if((tmp_dispno==null || tmp_dispno.equals("") ))	{
						entered			=	true;
						if(k!=0)
							blank_no	=blank_no+	","+k;
						else
							blank_no	=blank_no+	""+k;
						continue;
					}

					if(!tmp_disp.contains(tmp_dispno))
						tmp_disp.add(tmp_dispno);
					else	{
						entered			=	true;

						if(tmp_disp.contains(tmp_dispno)) {
							dup_no	=dup_no+ ","+tmp_disp.indexOf(tmp_dispno);
						}
						dup_vals	=dup_vals+	","+tmp_dispno;
						if(k!=0)
							dup_no	=dup_no+	","+k;
						else
							dup_no	=	""+k;
						continue;
					}
					if(entered)	{
						map.put( "result", new Boolean( false ) ) ;
						map.put( "message", "Blank_Desc:"+blank_desc+":Blank_No:"+blank_no+":Dup_No:"+dup_no+":Dup_Vals:"+dup_vals) ;
					}
					else{
						map.put( "result", new Boolean( true ) ) ;
						map.put( "message", "success.." ) ;
					}

				}

			}
		}
		catch(Exception e){e.printStackTrace();}
        return map ;
    }

    public HashMap insert() {

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put( "message", "Insert Failed" ) ;

        String level_no =   this.getLevelNo();

        ArrayList insertData = new ArrayList() ;
        ArrayList whereData = new ArrayList() ;


        if (select_1 !=null && !select_1.equals("")){
			insertObjects=new ArrayList();

			if(level_no.equals("2"))    {
                insertObjects.add( atc_class_lev1_code );
			}
			else if(level_no.equals("3"))   {
                insertObjects.add( atc_class_lev1_code );
                insertObjects.add( atc_class_lev2_code );
			}
			else if(level_no.equals("4"))   {
                insertObjects.add( atc_class_lev1_code );
                insertObjects.add( atc_class_lev2_code );
                insertObjects.add( atc_class_lev3_code );
			}
			else if(level_no.equals("5"))   {
                insertObjects.add( atc_class_lev1_code );
                insertObjects.add( atc_class_lev2_code );
                insertObjects.add( atc_class_lev3_code );
                insertObjects.add( atc_class_lev4_code );
			}
			insertObjects.add( atc_class_lev_code_1);
			insertObjects.add( atc_class_lev_desc_1 ) ;
			insertObjects.add( new Integer(display_seq_no_1 )) ;
			setmandatoryObjects();
			insertData.add(insertObjects);
			whereObjects=new ArrayList();

			if(level_no.equals("2"))    {
				whereObjects.add(atc_class_lev1_code);
			}
			else if(level_no.equals("3"))   {
				whereObjects.add(atc_class_lev1_code);
				whereObjects.add(atc_class_lev2_code);
			}
			else if(level_no.equals("4"))   {
				whereObjects.add(atc_class_lev1_code);
				whereObjects.add(atc_class_lev2_code);
				whereObjects.add(atc_class_lev3_code);
			}
			else if(level_no.equals("5"))   {
				whereObjects.add(atc_class_lev1_code);
				whereObjects.add(atc_class_lev2_code);
				whereObjects.add(atc_class_lev3_code);
				whereObjects.add(atc_class_lev4_code);
			}
			whereObjects.add(atc_class_lev_code_1);
			whereObjects.add(new Integer(display_seq_no_1));
			whereData.add(whereObjects);

            }
            if (select_2 !=null && !select_2.equals("")){
                insertObjects=new ArrayList();

                if(level_no.equals("2"))    {
					insertObjects.add( atc_class_lev1_code );
                }
                else if(level_no.equals("3"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
                }
                else if(level_no.equals("4"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
                }
                else if(level_no.equals("5"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
					insertObjects.add( atc_class_lev4_code );
                }
                insertObjects.add( atc_class_lev_code_2 ) ;
                insertObjects.add( atc_class_lev_desc_2 ) ;
                insertObjects.add( new Integer(display_seq_no_2 )) ;
                setmandatoryObjects();
                insertData.add(insertObjects);
                whereObjects=new ArrayList();

                if(level_no.equals("2"))    {
                    whereObjects.add(atc_class_lev1_code);
                }
                else if(level_no.equals("3"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                }
                else if(level_no.equals("4"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                }
                else if(level_no.equals("5"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                    whereObjects.add(atc_class_lev4_code);
                }
                whereObjects.add(atc_class_lev_code_2);
                whereObjects.add(new Integer(display_seq_no_2));
                whereData.add(whereObjects);
            }
			if (select_3 !=null && !select_3.equals("")){
                insertObjects=new ArrayList();

                if(level_no.equals("2"))    {
					insertObjects.add( atc_class_lev1_code );
                }
                else if(level_no.equals("3"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
                }
                else if(level_no.equals("4"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
				 insertObjects.add( atc_class_lev3_code );
                }
                else if(level_no.equals("5"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
					insertObjects.add( atc_class_lev4_code );
                }

                insertObjects.add( atc_class_lev_code_3 ) ;
                insertObjects.add( atc_class_lev_desc_3 ) ;
                insertObjects.add( new Integer(display_seq_no_3 )) ;
                setmandatoryObjects();
                insertData.add(insertObjects);

                whereObjects=new ArrayList();

                if(level_no.equals("2"))    {
                    whereObjects.add(atc_class_lev1_code);
                }
                else if(level_no.equals("3"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                }
                else if(level_no.equals("4"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                }
                else if(level_no.equals("5"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                    whereObjects.add(atc_class_lev4_code);
                }
                whereObjects.add(atc_class_lev_code_3);
                whereObjects.add(new Integer(display_seq_no_3));
                whereData.add(whereObjects);

            }
            if (select_4 !=null && !select_4.equals("")){
                insertObjects=new ArrayList();

                if(level_no.equals("2"))    {
					insertObjects.add( atc_class_lev1_code );
                }
                else if(level_no.equals("3"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
                }
                else if(level_no.equals("4"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
                }
                else if(level_no.equals("5"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
					insertObjects.add( atc_class_lev4_code );
                }
                insertObjects.add( atc_class_lev_code_4 ) ;
                insertObjects.add( atc_class_lev_desc_4 ) ;
                insertObjects.add( new Integer(display_seq_no_4 )) ;
                setmandatoryObjects();
                insertData.add(insertObjects);

                whereObjects=new ArrayList();

                if(level_no.equals("2"))    {
                    whereObjects.add(atc_class_lev1_code);
                }
                else if(level_no.equals("3"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                }
                else if(level_no.equals("4"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                }
                else if(level_no.equals("5"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                    whereObjects.add(atc_class_lev4_code);
                }
                whereObjects.add(atc_class_lev_code_4);
                whereObjects.add(new Integer(display_seq_no_4));
                whereData.add(whereObjects);

            }
            if (select_5 !=null && !select_5.equals("")){
                insertObjects=new ArrayList();

                if(level_no.equals("2"))    {
					insertObjects.add( atc_class_lev1_code );
                }
                else if(level_no.equals("3"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
                }
                else if(level_no.equals("4"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
                }
                else if(level_no.equals("5"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
					insertObjects.add( atc_class_lev4_code );
                }
                insertObjects.add( atc_class_lev_code_5 ) ;
                insertObjects.add( atc_class_lev_desc_5 ) ;
                insertObjects.add( new Integer(display_seq_no_5 )) ;
                setmandatoryObjects();
                insertData.add(insertObjects);

                whereObjects=new ArrayList();

                if(level_no.equals("2"))    {
                    whereObjects.add(atc_class_lev1_code);
                }
                else if(level_no.equals("3"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                }
                else if(level_no.equals("4"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                }
                else if(level_no.equals("5"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                    whereObjects.add(atc_class_lev4_code);
                }
                whereObjects.add(atc_class_lev_code_5);
                whereObjects.add( new Integer(display_seq_no_5));
                whereData.add(whereObjects);
            }
            if (select_6 !=null && !select_6.equals("")){
                insertObjects=new ArrayList();

                if(level_no.equals("2"))    {
					insertObjects.add( atc_class_lev1_code );
                }
                else if(level_no.equals("3"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
                }
                else if(level_no.equals("4"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
                }
                else if(level_no.equals("5"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
					insertObjects.add( atc_class_lev4_code );
                }

                insertObjects.add( atc_class_lev_code_6 ) ;
                insertObjects.add( atc_class_lev_desc_6 ) ;
                insertObjects.add( new Integer(display_seq_no_6 )) ;
                setmandatoryObjects();
                insertData.add(insertObjects);

                whereObjects=new ArrayList();

                if(level_no.equals("2"))    {
                    whereObjects.add(atc_class_lev1_code);
                }
                else if(level_no.equals("3"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                }
                else if(level_no.equals("4"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                }
                else if(level_no.equals("5"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                    whereObjects.add(atc_class_lev4_code);
                }
                whereObjects.add(atc_class_lev_code_6);
                whereObjects.add(new Integer(display_seq_no_6));
                whereData.add(whereObjects);
            }
            if (select_7 !=null && !select_7.equals("")){
                insertObjects=new ArrayList();

                if(level_no.equals("2"))    {
					insertObjects.add( atc_class_lev1_code );
                }
                else if(level_no.equals("3"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
                }
                else if(level_no.equals("4"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
                }
                else if(level_no.equals("5"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
					insertObjects.add( atc_class_lev4_code );
                }
                insertObjects.add( atc_class_lev_code_7 ) ;
                insertObjects.add( atc_class_lev_desc_7 ) ;
                insertObjects.add( new Integer(display_seq_no_7 )) ;
                setmandatoryObjects();
                insertData.add(insertObjects);

                whereObjects=new ArrayList();

                if(level_no.equals("2"))    {
                    whereObjects.add(atc_class_lev1_code);
                }
                else if(level_no.equals("3"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                }
                else if(level_no.equals("4"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                }
                else if(level_no.equals("5"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                    whereObjects.add(atc_class_lev4_code);
                }
                whereObjects.add(atc_class_lev_code_7);
                whereObjects.add(new Integer(display_seq_no_7));
                whereData.add(whereObjects);

            }
            if (select_8 !=null && !select_8.equals("")){
                insertObjects=new ArrayList();

                if(level_no.equals("2"))    {
				  insertObjects.add( atc_class_lev1_code );
                }
                else if(level_no.equals("3"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
                }
                else if(level_no.equals("4"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
                }
                else if(level_no.equals("5"))   {
					insertObjects.add( atc_class_lev1_code );
					insertObjects.add( atc_class_lev2_code );
					insertObjects.add( atc_class_lev3_code );
					insertObjects.add( atc_class_lev4_code );
                }

                insertObjects.add( atc_class_lev_code_8 ) ;
                insertObjects.add( atc_class_lev_desc_8 ) ;
                insertObjects.add( new Integer(display_seq_no_8 )) ;
                setmandatoryObjects();
                insertData.add(insertObjects);

                whereObjects=new ArrayList();
                if(level_no.equals("2"))    {
                    whereObjects.add(atc_class_lev1_code);
                }
                else if(level_no.equals("3"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                }
                else if(level_no.equals("4"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                }
                else if(level_no.equals("5"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                    whereObjects.add(atc_class_lev4_code);
                }
                whereObjects.add(atc_class_lev_code_8);
                whereObjects.add(new Integer(display_seq_no_8));
                whereData.add(whereObjects);

            }
            if (select_9 !=null && !select_9.equals("")){
                insertObjects=new ArrayList();

                if(level_no.equals("2"))    {
                insertObjects.add( atc_class_lev1_code );
                }
                else if(level_no.equals("3"))   {
                insertObjects.add( atc_class_lev1_code );
                insertObjects.add( atc_class_lev2_code );
                }
                else if(level_no.equals("4"))   {
                insertObjects.add( atc_class_lev1_code );
                insertObjects.add( atc_class_lev2_code );
                insertObjects.add( atc_class_lev3_code );
                }
                else if(level_no.equals("5"))   {
                insertObjects.add( atc_class_lev1_code );
                insertObjects.add( atc_class_lev2_code );
                insertObjects.add( atc_class_lev3_code );
                insertObjects.add( atc_class_lev4_code );
                }
                insertObjects.add( atc_class_lev_code_9 ) ;
                insertObjects.add( atc_class_lev_desc_9 ) ;
                insertObjects.add( new Integer(display_seq_no_9 )) ;
                setmandatoryObjects();
                insertData.add(insertObjects);

                whereObjects=new ArrayList();

                if(level_no.equals("2"))    {
                    whereObjects.add(atc_class_lev1_code);
                }
                else if(level_no.equals("3"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                }
                else if(level_no.equals("4"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                }
                else if(level_no.equals("5"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                    whereObjects.add(atc_class_lev4_code);
                }
                whereObjects.add(atc_class_lev_code_9);
                whereObjects.add(new Integer(display_seq_no_9));
                whereData.add(whereObjects);

            }
            if (select_10 !=null && !select_10.equals(""))
            {
                insertObjects=new ArrayList();

                if(level_no.equals("2"))    {
                insertObjects.add( atc_class_lev1_code );
                }
                else if(level_no.equals("3"))   {
                insertObjects.add( atc_class_lev1_code );
                insertObjects.add( atc_class_lev2_code );
                }
                else if(level_no.equals("4"))   {
                insertObjects.add( atc_class_lev1_code );
                insertObjects.add( atc_class_lev2_code );
                insertObjects.add( atc_class_lev3_code );
                }
                else if(level_no.equals("5"))   {
                insertObjects.add( atc_class_lev1_code );
                insertObjects.add( atc_class_lev2_code );
                insertObjects.add( atc_class_lev3_code );
                insertObjects.add( atc_class_lev4_code );
                }
                insertObjects.add( atc_class_lev_code_10 ) ;
                insertObjects.add( atc_class_lev_desc_10 ) ;
                insertObjects.add( new Integer(display_seq_no_10 )) ;
                setmandatoryObjects();
                insertData.add(insertObjects);

                whereObjects=new ArrayList();

                if(level_no.equals("2"))    {
                    whereObjects.add(atc_class_lev1_code);
                }
                else if(level_no.equals("3"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                }
                else if(level_no.equals("4"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                }
                else if(level_no.equals("5"))   {
                    whereObjects.add(atc_class_lev1_code);
                    whereObjects.add(atc_class_lev2_code);
                    whereObjects.add(atc_class_lev3_code);
                    whereObjects.add(atc_class_lev4_code);
                }
                whereObjects.add(atc_class_lev_code_10);
                whereObjects.add(new Integer(display_seq_no_10));
                whereData.add(whereObjects);

            }
            HashMap tabData = new HashMap() ;
            tabData.put( "properties", getProperties() );
            tabData.put( "InsertData",insertData);
            tabData.put( "WhereData",whereData);


            HashMap sqlMap = new HashMap() ;

/*		    SingleTableHandlerHome home = null;
            SingleTableHandlerRemote remote = null;*/

		 try{
            if(level_no.equals("1"))    {
            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL1_SELECT2"));
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL1_INSERT"));
            }
            else if(level_no.equals("2"))   {
            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL2_SELECT2"));
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL2_INSERT"));
            }
            else if(level_no.equals("3"))   {
            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL3_SELECT2"));
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL3_INSERT"));
            }
            else if(level_no.equals("4"))   {
            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL4_SELECT2"));
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL4_INSERT"));
            }
            else if(level_no.equals("5"))   {
            sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL5_SELECT2"));
            sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL5_INSERT"));
            }

/*          InitialContext context = new InitialContext() ;
            Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

            home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
            remote = home.create() ;

            map = remote.singleBatchHandler( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if( ((Boolean) map.get( "result" )).booleanValue() )	{
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ;
					map.put( "message", msgID  ) ;
				}
            else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
				{
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ;
					map.put( "message", msgID  ) ;
					map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				}
                else
                    map.put( "message", (map.get("msgid"))) ;
            }
        } catch(Exception e) {
            System.err.println( "Error Calling EJB : "+e ) ;
            map.put( "message", e.getMessage()+"here") ;
            e.printStackTrace() ;
        } 
		/*finally {
            try {
                if( remote != null ) remote.remove() ;
            } catch( Exception ee ) {
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ; 
            }
        }*/
        map.put( "flag" ,"0");
        return map ;
    }

    public HashMap modify() {
        String sql_query    =   "";
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put("flag", debug );

		/*SingleTableHandlerHome home = null;
        SingleTableHandlerRemote remote = null;*/

	if(this.getInnerMode().equals(""))	{
        ArrayList modifyData = new ArrayList() ;
        if( this.getLevelNo().equals("1"))
        {
        modifyData.add( atc_class_lev1_desc);
        }
        else if( this.getLevelNo().equals("2"))
        {
        modifyData.add( atc_class_lev2_desc);
        }
        else if( this.getLevelNo().equals("3"))
        {
        modifyData.add( atc_class_lev3_desc);
        }
        else if( this.getLevelNo().equals("4"))
        {
        modifyData.add( atc_class_lev4_desc);
        }
        else if( this.getLevelNo().equals("5"))
        {
        modifyData.add( atc_class_lev5_desc);
        }

        modifyData.add( new Integer(display_seq_no));
        modifyData.add( login_by_id ) ;
        modifyData.add( login_at_ws_no ) ;
        modifyData.add( login_facility_id ) ;
	try {
        if( this.getLevelNo().equals("1"))
        {
            modifyData.add( atc_class_lev1_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL1_UPDATE");
        }
        else if( this.getLevelNo().equals("2"))
        {
            modifyData.add( atc_class_lev1_code ) ;
            modifyData.add( atc_class_lev2_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL2_UPDATE");
        }
        else if( this.getLevelNo().equals("3"))
        {
            modifyData.add( atc_class_lev1_code ) ;
            modifyData.add( atc_class_lev2_code ) ;
            modifyData.add( atc_class_lev3_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL3_UPDATE");
        }
        else if( this.getLevelNo().equals("4"))
        {
            modifyData.add( atc_class_lev1_code ) ;
            modifyData.add( atc_class_lev2_code ) ;
            modifyData.add( atc_class_lev3_code ) ;
            modifyData.add( atc_class_lev4_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL4_UPDATE");
        }
        else if( this.getLevelNo().equals("5"))
        {
            modifyData.add( atc_class_lev1_code ) ;
            modifyData.add( atc_class_lev2_code ) ;
            modifyData.add( atc_class_lev3_code ) ;
            modifyData.add( atc_class_lev4_code ) ;
            modifyData.add( atc_class_lev5_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL5_UPDATE");
        }
        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "ModifyData",modifyData);

        HashMap sqlMap = new HashMap() ;
        sqlMap.put( "ModifySQL", sql_query );

/*            InitialContext context = new InitialContext() ;
            Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")) ;

            home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
            remote = home.create() ;
            map = remote.modify( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if( ((Boolean) map.get( "result" )).booleanValue() )	{
				String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ;
				map.put( "message", msgID  ) ;
     		}
            else{

                map.put( "message", (map.get("msgid"))) ;
            }
        } catch(Exception e) {
            System.err.println( "Error Calling EJB : "+e ) ;
            map.put( "message", e.getMessage()) ;
            e.printStackTrace() ;
        } 
		/*finally {
            try {
                if( remote != null )          remote.remove() ;
            } catch( Exception ee ) {
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;
            }
        }*/
	}
	else	{
	map	=	this.modifyAllData(temp_values,this.getLevelNo());
		try {
               if( ((Boolean) map.get( "result" )).booleanValue() ){
				   	String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ;
//				map.put("message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
//					msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
					map.put( "message", msgID  ) ;
				   }
				else{
                map.put( "message", (map.get("msgid"))) ;
				}
			} catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}

	}
        return map ;
    }
    public HashMap delete() 
	{
        String sql_query    =   "";

        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        map.put("flag", "0" );

		/*SingleTableHandlerHome home = null;
        SingleTableHandlerRemote remote = null;*/

	  try {
        ArrayList deleteData = new ArrayList() ;
        if( this.getLevelNo().equals("1"))
        {
            deleteData.add( atc_class_lev1_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL1_DELETE");
        }
        else if( this.getLevelNo().equals("2"))
        {
            deleteData.add( atc_class_lev1_code ) ;
            deleteData.add( atc_class_lev2_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL2_DELETE");
        }
        else if( this.getLevelNo().equals("3"))
        {
            deleteData.add( atc_class_lev1_code ) ;
            deleteData.add( atc_class_lev2_code ) ;
            deleteData.add( atc_class_lev3_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL3_DELETE");
        }
        else if( this.getLevelNo().equals("4"))
        {
            deleteData.add( atc_class_lev1_code ) ;
            deleteData.add( atc_class_lev2_code ) ;
            deleteData.add( atc_class_lev3_code ) ;
            deleteData.add( atc_class_lev4_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL4_DELETE");
        }
        else if( this.getLevelNo().equals("5"))
        {
            deleteData.add( atc_class_lev1_code ) ;
            deleteData.add( atc_class_lev2_code ) ;
            deleteData.add( atc_class_lev3_code ) ;
            deleteData.add( atc_class_lev4_code ) ;
            deleteData.add( atc_class_lev5_code ) ;
            sql_query   =   PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL5_DELETE");
        }

        HashMap tabData = new HashMap() ;
        tabData.put( "properties", getProperties() );
        tabData.put( "DeleteData",deleteData);

        HashMap sqlMap = new HashMap() ;
        sqlMap.put( "DeleteSQL", sql_query );

/*          InitialContext context = new InitialContext() ;
            Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")) ;

            home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
            remote = home.create() ;
            map = remote.delete( tabData, sqlMap ) ;  */

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            if( ((Boolean) map.get( "result" )).booleanValue() )	{
					String msgID = getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ;
					map.put( "message", msgID  ) ;
   			}
            else{

                map.put( "message", (map.get("msgid"))) ;
            }
        } catch(Exception e) {
            System.err.println( "Error Calling EJB : "+e ) ;
            map.put( "message", e.getMessage()) ;
            e.printStackTrace() ;
        } 
		/*finally {
            try {
                if( remote != null )                    remote.remove() ;
            } catch( Exception ee ) {
                System.err.println( ee.getMessage() ) ;
                map.put( "message", ee.getMessage() ) ;
            }
        }*/

        return map ;
    }


    public void clear() {
        atc_class_lev1_code = "" ;
        atc_class_lev2_code     = "" ;
        atc_class_lev3_code = "" ;
        atc_class_lev1_desc = "" ;
        atc_class_lev2_desc = "" ;
        atc_class_lev3_desc = "" ;
        display_seq_no          = 0 ;
		pharma_level_codes = null;
        super.clear() ;
    }

    public void setAll( Hashtable recordSet ) {
	try {
        if (this.getMode().equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
        {

            if(recordSet.containsKey("atc_class_lev1_code"))
                    setATCLev1Code((String)recordSet.get("atc_class_lev1_code")) ;

            if(recordSet.containsKey("atc_class_lev1_desc"))
                    setATCLev1Desc((String)recordSet.get("atc_class_lev1_desc")) ;

            if(recordSet.containsKey("atc_class_lev2_code"))
                setATCLev2Code((String)recordSet.get("atc_class_lev2_code")) ;

            if(recordSet.containsKey("atc_class_lev2_desc"))
                setATCLev2Desc((String)recordSet.get("atc_class_lev2_desc")) ;


            if(recordSet.containsKey("atc_class_lev3_code"))
                setATCLev3Code((String)recordSet.get("atc_class_lev3_code")) ;


            if(recordSet.containsKey("atc_class_lev3_desc"))
                setATCLev3Desc((String)recordSet.get("atc_class_lev3_desc")) ;

            if(recordSet.containsKey("atc_class_lev4_code"))
                setATCLev4Code((String)recordSet.get("atc_class_lev4_code")) ;


            if(recordSet.containsKey("atc_class_lev4_desc"))
                setATCLev4Desc((String)recordSet.get("atc_class_lev4_desc")) ;

            if(recordSet.containsKey("atc_class_lev5_code"))
                setATCLev5Code((String)recordSet.get("atc_class_lev5_code")) ;


            if(recordSet.containsKey("atc_class_lev5_desc"))
                setATCLev5Desc((String)recordSet.get("atc_class_lev5_desc")) ;


            if(recordSet.containsKey("display_seq_no"))
                setDisplaySeqNo(Integer.parseInt((String)recordSet.get("display_seq_no"))) ;
        }

        if (this.getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) )
        {
            if(recordSet.containsKey("atc_class_lev_code_1"))
                setATCLevCode1( (String) recordSet.get("atc_class_lev_code_1"));

            if(recordSet.containsKey("atc_class_lev_code_2"))
                setATCLevCode2( (String) recordSet.get("atc_class_lev_code_2"));

            if(recordSet.containsKey("atc_class_lev_code_3"))
                setATCLevCode3( (String) recordSet.get("atc_class_lev_code_3"));

            if(recordSet.containsKey("atc_class_lev_code_4"))
                setATCLevCode4( (String) recordSet.get("atc_class_lev_code_4"));

            if(recordSet.containsKey("atc_class_lev_code_5"))
                setATCLevCode5( (String) recordSet.get("atc_class_lev_code_5"));

            if(recordSet.containsKey("atc_class_lev_code_6"))
                setATCLevCode6( (String) recordSet.get("atc_class_lev_code_6"));

            if(recordSet.containsKey("atc_class_lev_code_7"))
                setATCLevCode7( (String) recordSet.get("atc_class_lev_code_7"));

            if(recordSet.containsKey("atc_class_lev_code_8"))
                setATCLevCode8( (String) recordSet.get("atc_class_lev_code_8"));

            if(recordSet.containsKey("atc_class_lev_code_9"))
                setATCLevCode9( (String) recordSet.get("atc_class_lev_code_9"));

            if(recordSet.containsKey("atc_class_lev_code_10"))
                setATCLevCode10( (String) recordSet.get("atc_class_lev_code_10"));

            if(recordSet.containsKey("atc_class_lev_desc_1"))
                setATCLevDesc1( (String) recordSet.get("atc_class_lev_desc_1"));

            if(recordSet.containsKey("atc_class_lev_desc_2"))
                setATCLevDesc2( (String) recordSet.get("atc_class_lev_desc_2"));

            if(recordSet.containsKey("atc_class_lev_desc_3"))
                setATCLevDesc3( (String) recordSet.get("atc_class_lev_desc_3"));

            if(recordSet.containsKey("atc_class_lev_desc_4"))
                setATCLevDesc4( (String) recordSet.get("atc_class_lev_desc_4"));

            if(recordSet.containsKey("atc_class_lev_desc_5"))
                setATCLevDesc5( (String) recordSet.get("atc_class_lev_desc_5"));

            if(recordSet.containsKey("atc_class_lev_desc_6"))
                setATCLevDesc6( (String) recordSet.get("atc_class_lev_desc_6"));

            if(recordSet.containsKey("atc_class_lev_desc_7"))
                setATCLevDesc7( (String) recordSet.get("atc_class_lev_desc_7"));

            if(recordSet.containsKey("atc_class_lev_desc_8"))
                setATCLevDesc8( (String) recordSet.get("atc_class_lev_desc_8"));

            if(recordSet.containsKey("atc_class_lev_desc_9"))
                setATCLevDesc9( (String) recordSet.get("atc_class_lev_desc_9"));

            if(recordSet.containsKey("atc_class_lev_desc_10"))
                setATCLevDesc10( (String) recordSet.get("atc_class_lev_desc_10"));

            if(recordSet.containsKey("display_seq_no_1"))
                setDisplaySeqNo1(Integer.parseInt((String) recordSet.get("display_seq_no_1")));

            if(recordSet.containsKey("display_seq_no_2"))
                setDisplaySeqNo2(Integer.parseInt((String) recordSet.get("display_seq_no_2")));

            if(recordSet.containsKey("display_seq_no_3"))
                setDisplaySeqNo3(Integer.parseInt((String) recordSet.get("display_seq_no_3")));

            if(recordSet.containsKey("display_seq_no_4"))
                setDisplaySeqNo4(Integer.parseInt((String) recordSet.get("display_seq_no_4")));

            if(recordSet.containsKey("display_seq_no_5"))
                setDisplaySeqNo5(Integer.parseInt((String) recordSet.get("display_seq_no_5")));

            if(recordSet.containsKey("display_seq_no_6"))
                setDisplaySeqNo6(Integer.parseInt((String) recordSet.get("display_seq_no_6")));

            if(recordSet.containsKey("display_seq_no_7"))
                setDisplaySeqNo7(Integer.parseInt((String) recordSet.get("display_seq_no_7")));

            if(recordSet.containsKey("display_seq_no_8"))
                setDisplaySeqNo8(Integer.parseInt((String) recordSet.get("display_seq_no_8")));

            if(recordSet.containsKey("display_seq_no_9"))
                setDisplaySeqNo9(Integer.parseInt((String) recordSet.get("display_seq_no_9")));

            if(recordSet.containsKey("display_seq_no_10"))
                setDisplaySeqNo10(Integer.parseInt((String) recordSet.get("display_seq_no_10")));

            if(recordSet.containsKey("select_1"))
                setSelect_1( (String) recordSet.get("select_1"));

            if(recordSet.containsKey("select_2"))
                setSelect_2( (String) recordSet.get("select_2"));

            if(recordSet.containsKey("select_3"))
                setSelect_3( (String) recordSet.get("select_3"));

            if(recordSet.containsKey("select_4"))
                setSelect_4( (String) recordSet.get("select_4"));

            if(recordSet.containsKey("select_5"))
                setSelect_5( (String) recordSet.get("select_5"));

            if(recordSet.containsKey("select_6"))
                setSelect_6( (String) recordSet.get("select_6"));

            if(recordSet.containsKey("select_7"))
                setSelect_7( (String) recordSet.get("select_7"));

            if(recordSet.containsKey("select_8"))
                setSelect_8( (String) recordSet.get("select_8"));

            if(recordSet.containsKey("select_9"))
                setSelect_9( (String) recordSet.get("select_9"));

            if(recordSet.containsKey("select_10"))
                setSelect_10( (String) recordSet.get("select_10"));

        }
	} catch(Exception e) { e.printStackTrace();}
        if(recordSet.containsKey("level_no"))
            setLevelNo((String)recordSet.get("level_no")) ;

        if(recordSet.containsKey("mode"))
            setMode((String)recordSet.get("mode")) ;
   }

    private void doCommon() throws Exception {

    }
    /* Over-ridden Adapter methods end here */

    /* Function specific methods start */

    public void setLevelDetail(String levelNo,String levelCode,String levelDesc){
        if(levelNo.equals("2")) {
            level_one_code  =   levelCode;
            setATCLev1Code(levelCode);
            setATCLev1Desc(levelDesc);
        }
        else if(levelNo.equals("3")) {
            level2_code     =   levelCode;
            setATCLev2Code(levelCode);
            setATCLev2Desc(levelDesc);
        }
        else if(levelNo.equals("4")) {
            level3_code     =   levelCode;
            setATCLev3Code(levelCode);
            setATCLev3Desc(levelDesc);
        }
        else if(levelNo.equals("5")) {
            level4_code     =   levelCode;
            setATCLev4Code(levelCode);
            setATCLev4Desc(levelDesc);
        }
    }

    public int getMaxDisplaySeqNo(String level_no) throws Exception {

        Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;

        String sql_query            =   "";
        int    seq_no               = 0;
		try {

        if(level_no.equals("1"))
            sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL1_DISP_SELECT2");
        else if(level_no.equals("2"))
            sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL2_DISP_SELECT2");
        else if(level_no.equals("3"))
            sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL3_DISP_SELECT2");
        else if(level_no.equals("4"))
            sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL4_DISP_SELECT2");
        else if(level_no.equals("5"))
            sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL5_DISP_SELECT2");


                connection  = getConnection() ;
                pstmt       = connection.prepareStatement(sql_query) ;

                if(level_no.equals("2")) {
                        pstmt.setString(1,level_one_code);
                }
                else if(level_no.equals("3")) {
                        pstmt.setString(1,level_one_code);
                        pstmt.setString(2,level2_code);
                }
                else if(level_no.equals("4")) {
                        pstmt.setString(1,level_one_code);
                        pstmt.setString(2,level2_code);
                        pstmt.setString(3,level3_code);
                }
                else if(level_no.equals("5")) {
                        pstmt.setString(1,level_one_code);
                        pstmt.setString(2,level2_code);
                        pstmt.setString(3,level3_code);
                        pstmt.setString(4,level4_code);
                }


            resultSet   =   pstmt.executeQuery();

            if(resultSet.next())
            {
                seq_no  =   resultSet.getInt("SEQ_NO");
            }
            } catch ( Exception e ) {
                System.err.println( "Error loading values from database" ) ;
                e.printStackTrace() ;
                throw e ;
            } finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){es.printStackTrace();}
              }
            return seq_no;
    }


    public Vector loadLevelValues(String level_no) throws Exception {
        Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
        values                      = new Vector();
        recs                        = null;

        int colno                   = 0;
        int recno                   = 0;
        String sql_query            =   "";
        String col_one              =   "";
        String col_two              =   "";
        String col_three            =   "";

		 try {

			if(level_no.equals("1"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL1_SELECT");
			else if(level_no.equals("2"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL2_SELECT");
			else if(level_no.equals("3"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL3_SELECT");
			else if(level_no.equals("4"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL4_SELECT");
			else if(level_no.equals("5"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL5_SELECT");

			connection  = getConnection() ;
			pstmt       = connection.prepareStatement(sql_query) ;
			
			if(level_no.equals("1")) {
				pstmt.setString(1,getLanguageId());
			}

			if(level_no.equals("2")) {
				pstmt.setString(1,level_one_code);
				pstmt.setString(2,getLanguageId());
			}
			else if(level_no.equals("3")) {
				pstmt.setString(1,level_one_code);
				pstmt.setString(2,level2_code);
				pstmt.setString(3,getLanguageId());
			}
			else if(level_no.equals("4")) {
				pstmt.setString(1,level_one_code);
				pstmt.setString(2,level2_code);
				pstmt.setString(3,level3_code);
				pstmt.setString(4,getLanguageId());
			}
			else if(level_no.equals("5")) {
				pstmt.setString(1,level_one_code);
				pstmt.setString(2,level2_code);
				pstmt.setString(3,level3_code);
				pstmt.setString(4,level4_code);
				pstmt.setString(5,getLanguageId());
			}

			col_one     ="lev"+level_no+"_code";
			col_two     ="lev"+level_no+"_desc";
			col_three   ="display_seq_no";


			resultSet   =   pstmt.executeQuery();
			while(resultSet.next()){
				recs    =   new Vector();
				recs.add(colno++,   resultSet.getString(col_one));
				recs.add(colno++,   resultSet.getString(col_two));
				recs.add(colno++,   resultSet.getString(col_three));
				if(!( level_no.equals("5") ))
				recs.add(colno++,   resultSet.getString("tot_rec_cnt"));
				recs.add(colno++,   "N");
				recs.add(colno++,   "N");
				values.add(recno,recs);

				colno=0;
				recno++;
			}

		} catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
        this.setRecords(level_no,values);

        return values;
    }

	public HashMap modifyAllData(Vector allData, String level_no){
		ArrayList	updateData		=	new ArrayList();
		ArrayList	whereData		=	new ArrayList();
		ArrayList	deleteRecord	=	new ArrayList();
		ArrayList	updateRecord	=	new ArrayList();
		HashMap		sqlMap			=	new HashMap();
		HashMap		tabData			=   new HashMap() ;
		Vector		record			=	null;
		String		code			="";
		String		desc			="";
		String		seqno			="";
		String		delete			="";
/*		PhATCClassLevelHome   home=null;
		PhATCClassLevelRemote remote=null;*/

//		HashMap map = new HashMap() ;
		HashMap result = null;

		for(int i=0; i<allData.size(); i++)	{
			record	=	(Vector) allData.get(i);

			if(record!=null) { 
				int j=0;
				code	=(String)	record.get(j);
				j++;
				desc	=(String)	record.get(j);
				j++;
				seqno	=(String)	record.get(j);
				j++;

				j++;
				delete	=(String)	record.get(j);
				if(delete.equals("Y"))	{
					deleteRecord.add(code);

				}
				else{
					updateRecord	=	new ArrayList();
					updateRecord.add(code);
					updateRecord.add(desc);
					updateRecord.add(seqno);
					updateData.add(updateRecord);
				}
			}
		}
		try{
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL1_DELETE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL1_DELETE"));
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL1_UPDATE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL1_UPDATE"));
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL2_DELETE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL2_DELETE"));
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL2_UPDATE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL2_UPDATE"));
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL3_DELETE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL3_DELETE"));
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL3_UPDATE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL3_UPDATE"));
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL4_DELETE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL4_DELETE"));
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL4_UPDATE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL4_UPDATE"));
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL5_DELETE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL5_DELETE"));
			sqlMap.put("SQL_PH_ATC_CLASS_LEVEL5_UPDATE",PhRepository.getPhKeyValue("SQL_PH_ATC_CLASS_LEVEL5_UPDATE"));

			whereData.add(this.getATCLev1Code());
			whereData.add(this.getATCLev2Code());
			whereData.add(this.getATCLev3Code());
			whereData.add(this.getATCLev4Code());


			tabData.put( "properties", getProperties() );
			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;
			tabData.put("levelNo", this.getLevelNo() );
			tabData.put("deleteData",deleteRecord);
			tabData.put("updateData",updateData);
			tabData.put("whereData",whereData);

/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_ATC_CLASS_LEVEL")) ;

				home  = (PhATCClassLevelHome) PortableRemoteObject.narrow( object, PhATCClassLevelHome.class ) ;
				remote = home.create() ;
				result = remote.modify( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_ATC_CLASS_LEVEL"),PhATCClassLevelHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			result=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		}//try
		catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			result.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}//catch
		/*finally{
		try{
			if( remote != null )
				remote.remove() ;
			}//try
			catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				result.put( "message", ee.getMessage() ) ;
			}//catch
		}//finally*/
		return result ;
	}

	public boolean getDeleteStatus(String levelNo, String param_code)	{

		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query            =   "";
		int del_status				=	0;
		boolean delete_status		=	false;

		try {
			if(levelNo.equals("1"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CHILD_CHECK_SELECT1");
			else if(levelNo.equals("2"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CHILD_CHECK_SELECT2");
			else if(levelNo.equals("3"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CHILD_CHECK_SELECT3");
			else if(levelNo.equals("4"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CHILD_CHECK_SELECT4");
			else if(levelNo.equals("5"))
				sql_query               = PhRepository.getPhKeyValue("SQL_PH_ATC_CHILD_CHECK_SELECT5");

			connection  = getConnection() ;
			pstmt       = connection.prepareStatement(sql_query) ;

			if(levelNo.equals("1"))
			pstmt.setString(1,param_code);
			else if(levelNo.equals("2")) {
				pstmt.setString(1,atc_class_lev1_code);
				pstmt.setString(2,param_code);
			}
			else if(levelNo.equals("3")) {
				pstmt.setString(1,atc_class_lev1_code);
				pstmt.setString(2,atc_class_lev2_code);
				pstmt.setString(3,param_code);
			}
			else if(levelNo.equals("4")) {
				pstmt.setString(1,atc_class_lev1_code);
				pstmt.setString(2,atc_class_lev2_code);
				pstmt.setString(3,atc_class_lev3_code);
				pstmt.setString(4,param_code);
			}
			else if(levelNo.equals("5")) {
				pstmt.setString(1,atc_class_lev1_code);
				pstmt.setString(2,atc_class_lev2_code);
				pstmt.setString(3,atc_class_lev3_code);
				pstmt.setString(4,atc_class_lev4_code);
				pstmt.setString(5,param_code);
			}

			resultSet   =   pstmt.executeQuery();

			if(resultSet.next()){
				del_status	=	Integer.parseInt(resultSet.getString(1));
			}

			if(del_status==0)
				delete_status	= true;
		} 
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
				}catch(Exception es){es.printStackTrace();}
		  }
		return delete_status;

	}

	public void setPharmaLevelCodes(String level_num,String level_code,String level_desc){
		if(pharma_level_codes==null)
			pharma_level_codes = new HashMap();

		if(level_num.equals("1")){
			pharma_level_codes.put("level_code_1",level_code);
			pharma_level_codes.put("level_desc_1",level_desc);
			pharma_level_codes.put("level_code_2","");
			pharma_level_codes.put("level_desc_2","");
			pharma_level_codes.put("level_code_3","");
			pharma_level_codes.put("level_desc_3","");			
		}
		else if(level_num.equals("2")){
			pharma_level_codes.put("level_code_2",level_code);
			pharma_level_codes.put("level_desc_2",level_desc);
			pharma_level_codes.put("level_code_3","");
			pharma_level_codes.put("level_desc_3","");
		}
		else if(level_num.equals("3")){
			pharma_level_codes.put("level_code_3",level_code);
			pharma_level_codes.put("level_desc_3",level_desc);
		}
	}	
	public HashMap getPharmaLevelCodes(){
		return this.pharma_level_codes;
	}
    /* Function specific methods end */
}
