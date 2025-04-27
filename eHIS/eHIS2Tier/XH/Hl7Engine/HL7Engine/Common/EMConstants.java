package HL7Engine.Common;

public class EMConstants
{
	public static final String SERVICENAME_SEPARATOR = "_";
	public static final String CRLF = "\r\n"; // Line separator required by multipart/form-data.
	public static final String CONFIG_FILE = "/CONFIG/properties.ini";
	public static final String EM_SETUP_DIR_OLD = "C:/eHIS/";
	public static final String EM_SETUP_ENV_NAME = "EM_INT_HOME";
	public static final String DBCONN_CHK_QRY_FILE = "/CONFIG/DB_QUERY.ini";
	public static final String EXE_FOLDER = "/Executables/";
	public static final String GENERIC_PACKAGE = "XHGENERIC.";
	public static final String LOG_EXT = ".log";
	public static final String LOG_BACKUP_FOLDER_DATE_FORMAT = "ddMMyy";
	public static final String SERVICE_NOT_EXISTS = "The specified service does not exist as an installed service.";

	public static final String ORA_INVALID_USER = "ORA-01017";
	public static final String ORA_ACCOUNT_LOCK = "ORA-28000";
	public static final String EBILLING_EB8_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
		
	public static final String ORDER_RESULT_EVENT = "R01";
	public static final Object ORDER_RESULT_SEG = "OBX";
	public static final Object ORDER_REQUEST_SEG = "OBR";
	public static final Object MESSAGE_HDR_SEG = "MSH";
	public static final String HL7_ELE_SEPARATOR = "^";
	public static final String SRR_RIS_IB_PROTOCOL = "SPIRAXLAB";
	public static final String SKR_EBL_OPIP_MDB_PROT = "SKREBLP1";
	public static final String MOHBR_CCIS_IB_PROTOCOL = "CCISPI";
	public static final String MOHBR_PACS_IB_PROTOCOL = "PACS231IBP";
	public static final String MOHBR_CPAC_IB_PROTOCOL = "CPACS23IBP";
	//Added by Sethu for ML-BRU-CRF-0615 on 04/03/2022
	public static final String MOHBR_LIS_IB_PROTOCOL = "LIS231IBP";
	public static final String DOC_MDM_EVENT = "T02";
	//Added by Sethu for ML-MMOH-SCF-2622 SERDANG on 23/01/2024
	public static final String SDNG_T08_IB_PROTOCOL = "CCISNIBP";
	public static final String DOC_T08_EVENT = "T08";
}