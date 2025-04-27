package eXH.snomed;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;


import eXH.util.EMDataSource;
import eXH.util.XHUtil;
import in.cdac.medinfo.csnotk.csnolib.agents.SNOMEDAgent;
import in.cdac.medinfo.csnotk.csnolib.commons.Constants;
import in.cdac.medinfo.csnotk.csnolib.commons.EnumState;
import in.cdac.medinfo.csnotk.csnolib.model.CompositeDescription;
import in.cdac.medinfo.csnotk.csnolib.util.Logger;

public class SnomedTransaction {
	
	public static final String l_field_separator = "$!^";
	public static String l_debug_YN = "N";
	public String l_errcd = "S";
    public String l_errmsg = "";
    public static List<String> semanticTagList;
    public static EnumState enumState;
    public static String l_search_term="", l_return_limit="",l_state="",l_semantic_tag="";

    public List<String> TransRequestMethod(String applicationId,String actionKey) throws IOException{
		
		String l_response_errmsg= StringUtils.EMPTY;
		String l_application_id="", l_protocol_link_id="", l_standard_code="", l_segment_id="", l_user_id="", l_user_wsno=""; 
		//String l_search_term="", l_return_limit="",l_state="",l_semantic_tag="";
		String l_app_msg = "";
		
		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String query = "", l_debug_yn = "";
		
		try
		{
			dbConn =  EMDataSource.getConnection();
			query = "select NVL(DEBUG_YN, 'N') DEBUG_YN FROM XH_PARAM" ;

			pstmt = dbConn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
			   l_debug_yn = rs.getString("DEBUG_YN");
			}
			
			l_debug_YN = l_debug_yn;
		}
		catch(Exception e)
		{
		}
		finally {
			XHUtil.closeDBResources(rs, pstmt, null);
			EMDataSource.returnConnection(dbConn);
		}
		
		l_app_msg = " ::: Inside SNOMED TransRequestMethod Request ::: ";
		if (l_debug_YN.equals("Y"))
			System.out.println(l_app_msg); 
		
		l_app_msg = " ::: Inside IQVIA TransRequestMethod Application ID ::: "+applicationId;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);
		
		l_app_msg = " ::: Inside SNOMED TransRequestMethod Action Key ::: "+actionKey;
		if (l_debug_YN.equals("Y"))	
			System.out.println(l_app_msg);
		
		/* action_key= <APPLICATION_ID>snomed$!^<SEARCH_TERM>typhoid$!^<RETURN_LIMIT>-1$!^<STATE>active$!^<SEMANTIC_TAG>disorder$!^<USER>Ravisankar$!^<WSNO>DFLT_WSNO$!^ */
		
		l_app_msg = " ::: Fetching Application ID ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_application_id = FieldValueFetchMethod(actionKey,"<APPLICATION_ID>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: APPLICATION ID : "+l_application_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_application_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_application_id;
		}
		
		l_app_msg = " ::: Fetching SEARCH_TERM ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_search_term=FieldValueFetchMethod(actionKey,"<SEARCH_TERM>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: SEARCH_TERM : "+l_search_term;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_search_term.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_search_term;
		}
		
		l_app_msg = " ::: Fetching RETURN_LIMIT ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_return_limit=FieldValueFetchMethod(actionKey,"<RETURN_LIMIT>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: RETURN_LIMIT : "+l_return_limit;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_return_limit.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_return_limit;
		}
		
		
		l_app_msg = " ::: Fetching STATE ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_state=FieldValueFetchMethod(actionKey,"<STATE>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: STATE : "+l_state;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_state.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_state;
		}
		
		l_app_msg = " ::: Fetching SEMANTIC_TAG ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_segment_id=FieldValueFetchMethod(actionKey,"<SEMANTIC_TAG>",null,l_field_separator, "TransRequestMethod");
		
		List<String> semanticTagList = new ArrayList<String>();
		semanticTagList.add(l_segment_id);
		
		l_app_msg = " ::: SEMANTIC_TAG : "+l_segment_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_segment_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_segment_id;
		}
		
		l_app_msg = " ::: Fetching USER ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_user_id=FieldValueFetchMethod(actionKey,"<USER>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: USER : "+l_user_id;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_id.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_id;
		}
		
		l_app_msg = " ::: Fetching WSNO ... ";
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		l_user_wsno=FieldValueFetchMethod(actionKey,"<WSNO>",null,l_field_separator, "TransRequestMethod");
		l_app_msg = " ::: WSNO : "+l_user_wsno;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		if (l_user_wsno.indexOf("Error")>=0)
		{
			l_errcd = "E";
			l_errmsg = l_user_wsno;
		}
		
		
	 enumState = EnumState.getEnum(l_state);
		
		l_app_msg = " ::: Fetching enumState ... "+enumState;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
		int returnlimit = Integer.parseInt(l_return_limit.trim());
		
		l_app_msg = " ::: Fetching returnlimit ... "+returnlimit;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);
		
				
		
		List<String> snomedList=SnomedList(l_search_term, enumState, semanticTagList, returnlimit);
		
		System.out.println(snomedList);
		return snomedList;
			
}
    
    public List<String> SnomedList(String matchTerm, EnumState enumState, List<String> semanticTagList, int returnlimit) throws IOException
	{
		
    	System.out.println(matchTerm);
    	System.out.println(enumState);
    	System.out.println(semanticTagList);
    	System.out.println(returnlimit);
    	
		SNOMEDAgent agent = new SNOMEDAgent();		
		agent.init();
		System.out.println("Snomed agent has initialized");
/*		System.out.println("Do you want to create SNOMED CT database (y/n)");
		String dbOverride ="y";
		if(dbOverride.equalsIgnoreCase("y"))
		{
			System.out.println("Please Enter SNOMED CT Release directory path till Snapshot");
			String snomedDirPath="C:\\SNOMEDCT_INT\\Snapshot";		
			System.out.println("Snomed Index files were getting generated please wait");
			agent.createSNOMEDdb(snomedDirPath, true);
		} */
			
		 List<String> ResponseList=new ArrayList<String>();
		Set<CompositeDescription> descriptions = agent.search(
				matchTerm, enumState, semanticTagList, returnlimit, false,null,null);
		System.out.println("Semantic: SIZE OF DESC : "+ descriptions.size());
		for (CompositeDescription description : descriptions)
		{
			//System.out.println(description.getConceptId() + " :"+ description.getTerm());
			ResponseList.add(description.getConceptId() + " :"+ description.getTerm());
		}
		System.out.println(ResponseList);
		return ResponseList;
	}
    
    public String FieldValueFetchMethod(String message, String identifier, String standardCode, String fieldSep, String procID) {
		String l_app_msg = "", l_field_value = "";	
		try
		{
			if(standardCode != null && !(standardCode.length()>0))
			{
			}
			else
			{
				if (message.indexOf(identifier) >= 0 )
				{
					if (message.indexOf(fieldSep) >= 0)
					{
						l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0)
						{						
							l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		

		l_app_msg = " ::: l_field_value ::: "+l_field_value;
		if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}

}
