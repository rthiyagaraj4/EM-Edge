package HL7Engine.Common;

public class EMConstants
{
	public static final String SERVICENAME_SEPARATOR = "_";
	public static final String CONFIG_FILE = "/CONFIG/properties.ini";
	public static final String EM_SETUP_DIR_OLD = "C:/eHIS/";
	public static final String EM_SETUP_ENV_NAME = "EM_INT_HOME";
	public static final String DBCONN_CHK_QRY_FILE = "/CONFIG/DB_QUERY.ini";
	public static final String EXE_FOLDER = "/Executables/";
	public static final String GENERIC_PACKAGE = "XHGENERIC.";
	public static final String LOG_EXT = ".log";
	public static final String SERVICE_NOT_EXISTS = "The specified service does not exist as an installed service.";

	public static final String ORA_INVALID_USER = "ORA-01017";
	public static final String ORA_ACCOUNT_LOCK = "ORA-28000";
	public static final String EBILLING_EB8_DATE_FORMAT = "dd/MM/yyyy";
		
	public static final String ORDER_RESULT_EVENT = "R01";
	public static final Object ORDER_RESULT_SEG = "OBX";
	public static final Object ORDER_REQUEST_SEG = "OBR";
	public static final Object MESSAGE_HDR_SEG = "MSH";
	public static final String HL7_ELE_SEPARATOR = "^";
	public static final String SRR_RIS_IB_PROTOCOL = "SPIRAXLAB";
	public static final String SKR_EBL_OPIP_MDB_PROT = "SKREBLP1";
}