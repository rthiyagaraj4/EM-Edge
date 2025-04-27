
/* Result Sets Interface */
#ifndef SQL_CRSR
#  define SQL_CRSR
  struct sql_cursor
  {
    unsigned int curocn;
    void *ptr1;
    void *ptr2;
    unsigned long magic;
  };
  typedef struct sql_cursor sql_cursor;
  typedef struct sql_cursor SQL_CURSOR;
#endif /* SQL_CRSR */

/* Thread Safety */
typedef void * sql_context;
typedef void * SQL_CONTEXT;

/* Object support */
struct sqltvn
{
  unsigned char *tvnvsn; 
  unsigned short tvnvsnl; 
  unsigned char *tvnnm;
  unsigned short tvnnml; 
  unsigned char *tvnsnm;
  unsigned short tvnsnml;
};
typedef struct sqltvn sqltvn;

struct sqladts
{
  unsigned int adtvsn; 
  unsigned short adtmode; 
  unsigned short adtnum;  
  sqltvn adttvn[1];       
};
typedef struct sqladts sqladts;

static struct sqladts sqladt = {
  1,1,0,
};

/* Binding to PL/SQL Records */
struct sqltdss
{
  unsigned int tdsvsn; 
  unsigned short tdsnum; 
  unsigned char *tdsval[1]; 
};
typedef struct sqltdss sqltdss;
static struct sqltdss sqltds =
{
  1,
  0,
};

/* File name & Package Name */
struct sqlcxp
{
  unsigned short fillen;
           char  filnam[34];
};
static const struct sqlcxp sqlfpn =
{
    33,
    "D:\\WORK\\Pradeep-issue\\RLILBRES.PC"
};


static unsigned long sqlctx = 563248573;


static struct sqlexd {
   unsigned int   sqlvsn;
   unsigned int   arrsiz;
   unsigned int   iters;
   unsigned int   offset;
   unsigned short selerr;
   unsigned short sqlety;
   unsigned int   occurs;
      const short *cud;
   unsigned char  *sqlest;
      const char  *stmt;
   sqladts *sqladtp;
   sqltdss *sqltdsp;
            void  **sqphsv;
   unsigned int   *sqphsl;
            int   *sqphss;
            void  **sqpind;
            int   *sqpins;
   unsigned int   *sqparm;
   unsigned int   **sqparc;
   unsigned short  *sqpadto;
   unsigned short  *sqptdso;
            void  *sqhstv[30];
   unsigned int   sqhstl[30];
            int   sqhsts[30];
            void  *sqindv[30];
            int   sqinds[30];
   unsigned int   sqharm[30];
   unsigned int   *sqharc[30];
   unsigned short  sqadto[30];
   unsigned short  sqtdso[30];
} sqlstm = {10,30};

/* SQLLIB Prototypes */
extern void sqlcxt (void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlcx2t(void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlbuft(void **, char *);
extern void sqlgs2t(void **, char *);
extern void sqlorat(void **, unsigned long *, void *);

/* Forms Interface */
static const int IAPSUCC = 0;
static const int IAPFAIL = 1403;
static const int IAPFTL  = 535;
extern void sqliem(char *, int *);

 static const char *sq0019 = 
"select nvl(NOTIFY_BY,' ') ,NVL(NOTIFY_TO,' ') ,TO_CHAR(NOTIFY_DATE_TIME,'DD/\
MM/YYYY HH24:MI') ,NVL(NOTIFY_TEXT,' ')  from RL_NOTIFY_DETAILS where ((PATIEN\
T_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_ID=:b2)           ";

 static const char *sq0018 = 
"select SOURCE_CODE ,CONSULTANT_CODE ,TO_CHAR(SPEC_RECD_DATE_TIME,'DD/MM/YYYY\
 HH24:MI') ,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SPEC_CO\
LLTD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,order_id ,RELEASED_BY_ID ,TO_CHAR(RELEAS\
ED_DATE,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') ,SECTION_\
CODE ,REQUEST_COMMENT_CODE1 ,REQUEST_COMMENT_CODE2 ,REQUEST_COMMENT_CODE3 ,REQ\
UEST_COMMENT_DESC1 ,REQUEST_COMMENT_DESC2 ,REQUEST_COMMENT_DESC3 ,EXTRA_COPIES\
_TO ,SPECIMEN_TYPE_CODE ,ADDED_BY_ID ,TO_CHAR(ADDED_DATE,'DD/MM/YYYY HH24:MI')\
 ,MODIFIED_BY_ID ,TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI') ,URGENT_INDICATO\
R ,EPISODE_TYPE ,ordered_facility_id  from RL_REQUEST_HEADER where ((PATIENT_I\
D=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_ID=:b2)           ";

 static const char *sq0031 = 
"select A.SNOMED_CODE ,A.snomed_code_2 ,SNOMED_MARKER_CODE_1 ,SNOMED_MARKER_C\
ODE_2  from RL_RESULT_SNOMED A where ((((A.PATIENT_ID=:b0 and A.SPECIMEN_NO=:b\
1) and A.OPERATING_FACILITY_ID=:b2) and A.GROUP_TEST_CODE=:b3) and A.TEST_CODE\
=:b4) order by SNOMED_CODE            ";

 static const char *sq0033 = 
"select ORGANISM_CODE ,RESULT_COMMENT_DESC ,NVL(HIDE_ORGANISM_YN,'N') ,SEQ_FO\
R_DUP_ORG  from RL_RESULT_ORGANISM where (((((PATIENT_ID=:b0 and SPECIMEN_NO=:\
b1) and OPERATING_FACILITY_ID=:b2) and GROUP_TEST_CODE=:b3) and TEST_CODE=:b4)\
 and ((:b5 in ('W','C') and NVL(hide_organism_yn,'N') not  in ('Y')) or :b5 in\
 ('L','K'))) order by ORGANISM_CODE            ";

 static const char *sq0037 = 
"select LONG_DESC  from RL_ORGANISM_CODE where ORGANISM_CODE=:b0           ";

 static const char *sq0039 = 
"select LONG_DESC  from RL_ORGANISM_CODE where ORGANISM_CODE=:b0           ";

 static const char *sq0034 = 
"select distinct ANTIBIOTIC_CODE  from RL_RESULT_ORGANISM_DTL where (((((((PA\
TIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_ID=:b2) and GROUP_TES\
T_CODE=:b3) and TEST_CODE=:b4) and (REPORT_YN='Y' or :b5 in ('L','K'))) and (S\
ENSITIVITY_IND in ('S','R','I','D') or :b5 in ('L','K'))) and SENSITIVITY_IND \
is  not null ) order by ANTIBIOTIC_CODE            ";

 static const char *sq0038 = 
"select LONG_DESC  from RL_ANTIBIOTIC_CODE where ANTIBIOTIC_CODE=:b0         \
  ";

 static const char *sq0035 = 
"select ORGANISM_CODE ,ANTIBIOTIC_CODE ,SENSITIVITY_IND ,REPORT_YN ,trim(MIC_\
RESULT) MIC_RESULT ,zone_size ,NVL(PRINT_MIC_VALUE_YN,'N') PRINT_MIC_VALUE_YN \
 from RL_RESULT_ORGANISM_DTL where (((((((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) \
and OPERATING_FACILITY_ID=:b2) and GROUP_TEST_CODE=:b3) and TEST_CODE=:b4) and\
 (REPORT_YN='Y' or :b5 in ('L','K'))) and (SENSITIVITY_IND in ('S','R','I','D'\
) or :b5 in ('L','K'))) and SENSITIVITY_IND is  not null ) order by ANTIBIOTIC\
_CODE,ORGANISM_CODE            ";

 static const char *sq0036 = 
"select ANTIBIOTIC_CODE ,SENSITIVITY_IND ,REPORT_YN ,trim(MIC_RESULT) MIC_RES\
ULT ,MIC_SIGN ,zone_size ,NVL(PRINT_MIC_VALUE_YN,'N') PRINT_MIC_VALUE_YN ,SEQ_\
FOR_DUP_ORG  from RL_RESULT_ORGANISM_DTL where (((((((((PATIENT_ID=:b0 and SPE\
CIMEN_NO=:b1) and OPERATING_FACILITY_ID=:b2) and GROUP_TEST_CODE=:b3) and TEST\
_CODE=:b4) and ORGANISM_CODE=:b5) and (REPORT_YN='Y' or :b6 in ('L','K'))) and\
 (SENSITIVITY_IND in ('S','R','I','D') or :b6 in ('L','K'))) and SENSITIVITY_I\
ND is  not null ) and SEQ_FOR_DUP_ORG=:b8) order by SEQ_FOR_DUP_ORG,seq_no    \
        ";

 static const char *sq0054 = 
"select SHORT_NAME ,SEX ,NATIONALITY_CODE ,ROUND((TO_DATE(:b0,'DD/MM/YYYY HH2\
4:MI')-DATE_OF_BIRTH)) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY')  from MP_PATIENT_MAS\
T where PATIENT_ID=:b1           ";

 static const char *sq0055 = 
"select SHORT_NAME ,SEX ,NATIONALITY_CODE ,ROUND((TO_DATE(:b0,'DD/MM/YYYY HH2\
4:MI')-DATE_OF_BIRTH)) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY')  from RL_PATIENT_MAS\
T where PATIENT_ID=:b1           ";

 static const char *sq0021 = 
"select SPECIMEN_DESC  from RL_SPECIMEN_TYPE_CODE where SPECIMEN_TYPE_CODE=:b\
0           ";

 static const char *sq0023 = 
"select LONG_DESC ,NUMERIC_RESULT_YN ,AGE_SEX_RANGE_YN ,FUNCTION_YN ,PRINT_NA\
ME_YN ,LOW_VALUE_NORMAL ,HIGH_VALUE_NORMAL ,GROUP_TEST_YN ,TEXT_BLOCK_YN ,CULT\
URE_TEST_YN ,SNOMED_YN ,TEST_UNITS ,NVL(NO_OF_DECIMALS,0) ,NVL(SIGNIFICANT_DIG\
IT,0) ,REF_RANGE_COMMENT ,NVL(CONFIDENTIAL_YN,'N') ,NVL(inhibit_report_yn,'N')\
  from RL_TEST_CODE where TEST_CODE=:b0           ";

 static const char *sq0022 = 
"select LONG_NAME  from RL_SECTION_CODE where SECTION_CODE=:b0           ";

 static const char *sq0024 = 
"select NVL(physician_age_low_value,LOW_VALUE_NORMAL) ,NVL(physician_age_high\
_value,HIGH_VALUE_NORMAL)  from RL_AGE_SEX_RANGE where ((TEST_CODE=:b0 and SEX\
=:b1) and :b2 between CALC_MIN_AGE_IN_DAYS and CALC_MAX_AGE_IN_DAYS)          \
 ";

 static const char *sq0025 = 
"select COMMENT_TEXT  from RL_COMMENTS_FOR_TEST where TEST_CODE=:b0 order by \
SEQ_NO            ";

 static const char *sq0032 = 
"select SUBSTR(DESCRIPTION_1,1,12) ,NVL(PRINT_YN,'N') ,NVL(print_code_yn,'N')\
  from RL_SNOMED_CODE where SNOMED_CODE=:b0           ";

 static const char *sq0026 = 
"select RESULT_TEXT ,RESULT_TEXT_CODE ,NVL(print_desc_in_report_yn,'N') ,NVL(\
print_desc_in_bold_yn,'N') ,NVL(print_desc_underlined_yn,'N')  from RL_RESULT_\
TEXT where (((((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_ID=\
:b2) and GROUP_TEST_CODE=:b3) and TEST_CODE=:b4) and ((:b5 in ('W','C') and NV\
L(hide_text_yn,'N') not  in ('Y')) or :b5 in ('L','K'))) order by SERIAL_NO   \
         ";

 static const char *sq0027 = 
"select result_text rl_res_result_text ,result_text_code ,TEST_CODE ,ORGANISM\
_CODE ,B_GROUP_TEST_CODE ,B_TEST_CODE  from RL_ORGANISM_TESTS_RESULT_TEXT wher\
e ((((patient_id=:b0 and specimen_no=:b1) and group_test_code=:b2) and test_co\
de=:b3) and NVL(hide_text_yn,'N')<>'Y') order by LINE_no            ";

 static const char *sq0028 = 
"select TEST_CODE ,ORGANISM_CODE ,B_GROUP_TEST_CODE ,B_TEST_CODE ,RESULT_COMM\
ENT_CODE1 ,RESULT_COMMENT_DESC1  from RL_RESULT_ORGANISM_TESTS_DTL where ((((p\
atient_id=:b0 and specimen_no=:b1) and group_test_code=:b2) and test_code=:b3)\
 and (RESULT_COMMENT_CODE1 is  not null  or RESULT_COMMENT_DESC1 is  not null \
)) order by LINE_no            ";

 static const char *sq0020 = 
"select OPERAND_1 ,OPERAND_1_TYPE ,OPERATOR_1 ,OPERAND_2 ,OPERAND_2_TYPE ,OPE\
RATOR_2  from RL_FUNCTION where TEST_CODE=:b0 order by SEQ_NUMBER            ";

 static const char *sq0040 = 
"select LONG_DESC  from RL_ORGANISM_CODE where ORGANISM_CODE=:b0           ";

 static const char *sq0041 = 
"select LONG_DESC ,nvl(GROUP_TEST_YN,'N')  from RL_TEST_CODE where TEST_CODE=\
:b0           ";

 static const char *sq0042 = 
"select LONG_DESC  from RL_TEST_CODE where TEST_CODE=:b0           ";

 static const char *sq0061 = 
"select distinct TO_CHAR(A.interval_test_specimen_no)  from RL_INTERVAL_TEST_\
SPECIMENS A where (((A.specimen_no=TO_NUMBER(:b0) and OPERATING_FACILITY_ID=:b\
1) and NVL(A.cancelled_yn,'N')<>'Y') and ((:b2 in ('W','C') and NVL(status,'O'\
) in ('R','P')) or :b2 in ('L','K')))           ";

 static const char *sq0063 = 
"select test_code  from RL_REQUEST_DETAIL where (((specimen_no=TO_NUMBER(:b0)\
 and OPERATING_FACILITY_ID=:b1) and NVL(cancelled_yn,'N')<>'Y') and ((((:b2 in\
 ('W','C') and NVL(result_status,'O') in ('R','P')) or ((:b2 in ('W','C') and \
test_code in (select test_code  from RL_TEST_CODE where (NVL(PROFILE_YN,'N')='\
Y' and NVL(GROUP_TEST_YN,'N')='Y'))) and (NVL(result_status,'O')='O' or (NVL(r\
esult_status,'O') in ('A') and released_date is  not null )))) or ((:b2 in ('W\
','C') and NVL(preliminary_release_yn,'N')='Y') and NVL(result_status,'O') in \
('A'))) or :b2 in ('L','K')))           ";

 static const char *sq0066 = 
"select TO_CHAR(A.specimen_no) ,A.group_test_code ,A.test_code ,A.seq_no  fro\
m RL_INTERVAL_TEST_SPECIMENS A where (((A.interval_test_specimen_no=TO_NUMBER(\
:b0) and OPERATING_FACILITY_ID=:b1) and NVL(A.cancelled_yn,'N')<>'Y') and ((:b\
2 in ('W','C') and NVL(status,'O') in ('R','P')) or :b2 in ('L','K'))) order b\
y A.specimen_no            ";

 static const char *sq0070 = 
"select TO_CHAR(A.interval_test_specimen_no)  from RL_INTERVAL_TEST_SPECIMENS\
 A where (((A.specimen_no=TO_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1) and NV\
L(A.cancelled_yn,'N')<>'Y') and NVL(A.status,'O') in ('R',:b2)) order by A.spe\
cimen_no            ";

 static const char *sq0072 = 
"select distinct specimen_no  from RL_INTERVAL_TEST_TEMP where ((OPERATING_FA\
CILITY_ID=:b0 and user_id=USER) and session_id=USERENV('sessionid'))          \
 ";

 static const char *sq0074 = 
"select test_code ,cancel_code  from RL_REQUEST_DETAIL where ((specimen_no=TO\
_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1) and NVL(cancelled_yn,'N')='Y')    \
       ";

 static const char *sq0075 = 
"select TO_CHAR(specimen_no) ,group_test_code ,test_code  from RL_INTERVAL_TE\
ST_TEMP where ((OPERATING_FACILITY_ID=:b0 and user_id=USER) and session_id=:b1\
)           ";

 static const char *sq0029 = 
"select REMARK_CODE ,REMARK_TEXT ,RELEASED_BY ,TO_CHAR(RELEASED_DATE,'DD/MM/Y\
Y HH24:MI') ,NUMERIC_PREFIX ,NUMERIC_RESULT ,NVL(MODIFY_COMPONENTS_IND,'!!!!')\
 ,INSTR(NVL(MODIFY_COMPONENTS_IND,'!!!!'),'NM')  from RL_RESULT_MODIFY_REASON \
where ((((SPECIMEN_NO=:b0 and OPERATING_FACILITY_ID=:b1) and PATIENT_ID=:b2) a\
nd GROUP_TEST_CODE=:b3) and TEST_CODE=:b4) order by MODIFY_LOG_SEQ_NO desc    \
         ";

 static const char *sq0101 = 
"select TO_CHAR(A.specimen_no) ,A.test_code ,A.numeric_result ,NVL(A.numeric_\
prefix,'+') ,A.status ,A.test_units ,A.age_range_low ,A.age_range_high ,A.high\
_low_ind ,TO_CHAR(B.spec_regd_date_time,'DD/MM/YYYY HH24:MI') ,B.operating_fac\
ility_id ,NVL(A.numeric_result_hide_yn,'N') numeric_result_hide_yn  from RL_TE\
ST_RESULT A ,RL_REQUEST_HEADER B where ((((((((B.patient_id=:b0 and B.patient_\
id=A.patient_id) and B.specimen_no=A.specimen_no) and B.operating_facility_id=\
A.operating_facility_id) and A.test_code=:b1) and A.specimen_no<>TO_NUMBER(:b2\
)) and B.spec_regd_date_time between TO_DATE(:b3,'DD/MM/YYYY HH24:MI') and TO_\
DATE(:b4,'DD/MM/YYYY HH24:MI')) and NVL(A.cancelled_yn,'N')<>'Y') and NVL(A.st\
atus,'O') in ('R','P')) order by B.spec_regd_date_time desc             ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,689,0,0,0,0,0,1,0,
20,0,0,2,213,0,4,784,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
51,0,0,3,284,0,3,908,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
110,0,0,4,0,0,29,950,0,0,0,0,0,1,0,
125,0,0,5,177,0,4,977,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,
9,0,0,1,9,0,0,
168,0,0,6,157,0,4,1005,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
203,0,0,7,0,0,17,1123,0,0,1,1,0,1,0,1,9,0,0,
222,0,0,7,0,0,45,1129,0,0,0,0,0,1,0,
237,0,0,7,0,0,13,1136,0,0,1,0,0,1,0,2,9,0,0,
256,0,0,8,42,0,4,1172,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
279,0,0,9,49,0,4,1178,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
306,0,0,10,59,0,4,1185,0,0,4,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,2,9,0,0,
337,0,0,11,45,0,4,1212,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
364,0,0,12,49,0,4,1219,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
391,0,0,13,55,0,4,1226,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
414,0,0,14,57,0,4,1235,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
441,0,0,15,53,0,4,1246,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
468,0,0,16,52,0,4,1271,0,0,4,3,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,2,9,0,0,
499,0,0,17,0,0,27,1289,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
530,0,0,36,0,0,15,1660,0,0,0,0,0,1,0,
545,0,0,33,0,0,15,1669,0,0,0,0,0,1,0,
560,0,0,19,0,0,15,1682,0,0,0,0,0,1,0,
575,0,0,19,225,0,9,1691,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
602,0,0,19,0,0,13,1709,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
633,0,0,43,151,0,4,1747,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
664,0,0,44,217,0,4,1761,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,
707,0,0,18,0,0,15,2117,0,0,0,0,0,1,0,
722,0,0,18,768,0,9,2126,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
749,0,0,18,0,0,13,2187,0,0,25,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,
864,0,0,45,0,0,17,2310,0,0,1,1,0,1,0,1,9,0,0,
883,0,0,46,504,0,4,2313,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
914,0,0,47,504,0,4,2342,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
945,0,0,45,0,0,45,2368,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
972,0,0,45,0,0,13,2441,0,0,30,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1107,0,0,48,44,0,4,2612,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1134,0,0,49,788,0,4,3020,0,0,6,4,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,3,0,0,
1173,0,0,50,762,0,4,3042,0,0,6,4,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,3,0,0,
1212,0,0,51,74,0,4,3364,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1235,0,0,52,101,0,4,3393,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1262,0,0,53,101,0,4,3422,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1289,0,0,31,270,0,9,3683,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1324,0,0,31,0,0,13,3707,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1355,0,0,34,0,0,15,4362,0,0,0,0,0,1,0,
1370,0,0,35,0,0,15,4363,0,0,0,0,0,1,0,
1385,0,0,33,357,0,9,4406,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,1,0,0,1,1,0,0,
1428,0,0,33,0,0,13,4425,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1459,0,0,37,74,0,9,4443,0,0,1,1,0,1,0,1,9,0,0,
1478,0,0,37,0,0,13,4450,0,0,1,0,0,1,0,2,9,0,0,
1497,0,0,39,74,0,9,4464,0,0,1,1,0,1,0,1,9,0,0,
1516,0,0,39,0,0,13,4474,0,0,1,0,0,1,0,2,9,0,0,
1535,0,0,34,361,0,9,4487,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,1,0,0,1,1,0,0,
1578,0,0,34,0,0,13,4498,0,0,1,0,0,1,0,2,9,0,0,
1597,0,0,38,78,0,9,4510,0,0,1,1,0,1,0,1,9,0,0,
1616,0,0,38,0,0,13,4517,0,0,1,0,0,1,0,2,9,0,0,
1635,0,0,35,497,0,9,4529,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,1,0,0,1,1,0,0,
1678,0,0,36,552,0,9,4538,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,
1729,0,0,35,0,0,13,4573,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1772,0,0,36,0,0,13,4626,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1815,0,0,54,187,0,9,4737,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1838,0,0,54,0,0,13,4743,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1873,0,0,55,187,0,9,4755,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1896,0,0,55,0,0,13,4756,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1931,0,0,55,187,0,9,4772,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1954,0,0,55,0,0,13,4773,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1989,0,0,21,88,0,9,4800,0,0,1,1,0,1,0,1,9,0,0,
2008,0,0,21,0,0,13,4808,0,0,1,0,0,1,0,2,9,0,0,
2027,0,0,23,360,0,9,4825,0,0,1,1,0,1,0,1,9,0,0,
2046,0,0,23,0,0,13,4865,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,
2129,0,0,56,103,0,4,4925,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2160,0,0,57,74,0,4,4933,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2183,0,0,58,103,0,4,4940,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2214,0,0,22,72,0,9,4957,0,0,1,1,0,1,0,1,9,0,0,
2233,0,0,22,0,0,13,4965,0,0,1,0,0,1,0,2,9,0,0,
2252,0,0,24,233,0,9,4979,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
2279,0,0,24,0,0,13,4990,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
2302,0,0,25,94,0,9,5004,0,0,1,1,0,1,0,1,9,0,0,
2321,0,0,25,0,0,13,5019,0,0,1,0,0,1,0,2,9,0,0,
2340,0,0,32,130,0,9,5088,0,0,1,1,0,1,0,1,9,0,0,
2359,0,0,32,0,0,13,5119,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
2386,0,0,26,397,0,9,5446,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,1,0,0,1,1,0,0,
2429,0,0,27,300,0,9,5456,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2460,0,0,28,341,0,9,5464,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2491,0,0,26,0,0,13,5514,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2526,0,0,28,0,0,13,5586,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
2565,0,0,27,0,0,13,5649,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
2604,0,0,59,146,0,4,5713,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2639,0,0,20,153,0,9,5763,0,0,1,1,0,1,0,1,9,0,0,
2658,0,0,20,0,0,13,5786,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
2697,0,0,18,0,0,15,5816,0,0,0,0,0,1,0,
2712,0,0,45,0,0,15,5817,0,0,0,0,0,1,0,
2727,0,0,54,0,0,15,5818,0,0,0,0,0,1,0,
2742,0,0,21,0,0,15,5819,0,0,0,0,0,1,0,
2757,0,0,22,0,0,15,5820,0,0,0,0,0,1,0,
2772,0,0,23,0,0,15,5821,0,0,0,0,0,1,0,
2787,0,0,24,0,0,15,5822,0,0,0,0,0,1,0,
2802,0,0,25,0,0,15,5823,0,0,0,0,0,1,0,
2817,0,0,26,0,0,15,5824,0,0,0,0,0,1,0,
2832,0,0,30,0,0,15,5825,0,0,0,0,0,1,0,
2847,0,0,31,0,0,15,5826,0,0,0,0,0,1,0,
2862,0,0,32,0,0,15,5827,0,0,0,0,0,1,0,
2877,0,0,33,0,0,15,5828,0,0,0,0,0,1,0,
2892,0,0,34,0,0,15,5829,0,0,0,0,0,1,0,
2907,0,0,35,0,0,15,5830,0,0,0,0,0,1,0,
2922,0,0,37,0,0,15,5831,0,0,0,0,0,1,0,
2937,0,0,38,0,0,15,5832,0,0,0,0,0,1,0,
2952,0,0,55,0,0,15,5833,0,0,0,0,0,1,0,
2967,0,0,60,101,0,4,6214,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2994,0,0,40,74,0,9,6265,0,0,1,1,0,1,0,1,9,0,0,
3013,0,0,40,0,0,13,6266,0,0,1,0,0,1,0,2,9,0,0,
3032,0,0,41,90,0,9,6284,0,0,1,1,0,1,0,1,9,0,0,
3051,0,0,41,0,0,13,6285,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
3074,0,0,42,66,0,9,6308,0,0,1,1,0,1,0,1,9,0,0,
3093,0,0,42,0,0,13,6309,0,0,1,0,0,1,0,2,9,0,0,
3112,0,0,42,66,0,9,6331,0,0,1,1,0,1,0,1,9,0,0,
3131,0,0,42,0,0,13,6332,0,0,1,0,0,1,0,2,9,0,0,
3150,0,0,39,74,0,9,6416,0,0,1,1,0,1,0,1,9,0,0,
3169,0,0,39,0,0,13,6417,0,0,1,0,0,1,0,2,9,0,0,
3188,0,0,41,90,0,9,6426,0,0,1,1,0,1,0,1,9,0,0,
3207,0,0,41,0,0,13,6427,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
3230,0,0,42,66,0,9,6450,0,0,1,1,0,1,0,1,9,0,0,
3249,0,0,42,0,0,13,6451,0,0,1,0,0,1,0,2,9,0,0,
3268,0,0,42,66,0,9,6468,0,0,1,1,0,1,0,1,9,0,0,
3287,0,0,42,0,0,13,6469,0,0,1,0,0,1,0,2,9,0,0,
3306,0,0,61,280,0,9,6817,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
3337,0,0,62,187,0,3,6851,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
3372,0,0,63,584,0,9,6890,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,1,0,0,
1,1,0,0,
3411,0,0,64,182,0,4,6894,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3442,0,0,65,162,0,3,6906,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
3469,0,0,66,337,0,9,6937,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
3500,0,0,66,0,0,13,6952,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
3531,0,0,61,0,0,13,6973,0,0,1,0,0,1,0,2,9,0,0,
3550,0,0,63,0,0,13,6992,0,0,1,0,0,1,0,2,9,0,0,
3569,0,0,61,0,0,15,7008,0,0,0,0,0,1,0,
3584,0,0,66,0,0,15,7014,0,0,0,0,0,1,0,
3599,0,0,63,0,0,15,7019,0,0,0,0,0,1,0,
3614,0,0,67,124,0,2,7025,0,0,1,1,0,1,0,1,9,0,0,
3633,0,0,68,107,0,2,7030,0,0,2,2,0,1,0,1,9,0,0,1,3,0,0,
3656,0,0,69,92,0,4,7043,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,3,0,0,
3683,0,0,70,252,0,9,7065,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
3710,0,0,70,0,0,15,7069,0,0,0,0,0,1,0,
3725,0,0,70,0,0,13,7079,0,0,1,0,0,1,0,2,9,0,0,
3744,0,0,71,68,0,4,7112,0,0,1,0,0,1,0,2,3,0,0,
3763,0,0,72,155,0,9,7123,0,0,1,1,0,1,0,1,9,0,0,
3782,0,0,73,159,0,3,7135,0,0,5,5,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3817,0,0,72,0,0,13,7156,0,0,1,0,0,1,0,2,9,0,0,
3836,0,0,72,0,0,15,7171,0,0,0,0,0,1,0,
3851,0,0,74,161,0,9,7184,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3874,0,0,74,0,0,15,7190,0,0,0,0,0,1,0,
3889,0,0,74,0,0,13,7201,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
3912,0,0,75,166,0,9,7229,0,0,2,2,0,1,0,1,9,0,0,1,3,0,0,
3935,0,0,76,44,0,4,7270,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
3962,0,0,75,0,0,13,7325,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
3989,0,0,77,74,0,4,7346,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4012,0,0,75,0,0,15,7360,0,0,0,0,0,1,0,
4027,0,0,78,112,0,2,7367,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
4050,0,0,79,136,0,4,7406,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
4081,0,0,80,130,0,4,7459,0,0,8,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2,9,0,0,2,3,0,0,2,3,0,0,
4128,0,0,81,76,0,4,7612,0,0,4,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,2,3,0,0,
4159,0,0,82,64,0,4,7661,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4182,0,0,83,76,0,4,7684,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
4205,0,0,84,137,0,4,7709,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
4236,0,0,85,42,0,4,7716,0,0,1,0,0,1,0,2,9,0,0,
4255,0,0,86,253,0,4,7732,0,0,8,7,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,1,0,0,1,1,0,0,
4302,0,0,87,495,0,4,7749,0,0,6,5,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
4341,0,0,88,261,0,4,7773,0,0,8,7,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,1,0,0,1,1,0,0,
4388,0,0,89,76,0,4,7808,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4411,0,0,29,0,0,15,7984,0,0,0,0,0,1,0,
4426,0,0,29,397,0,9,7995,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
4461,0,0,29,0,0,13,8022,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,3,0,0,
4508,0,0,90,91,0,4,8055,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
4535,0,0,91,91,0,4,8078,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
4562,0,0,92,360,0,4,6,1,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
4613,0,0,93,200,0,4,38,1,0,1,0,0,1,0,2,9,0,0,
4632,0,0,94,58,0,4,57,1,0,1,0,0,1,0,2,9,0,0,
4651,0,0,95,174,0,4,76,1,0,4,1,0,1,0,2,3,0,0,2,3,0,0,2,9,0,0,1,9,0,0,
4682,0,0,96,116,0,4,87,1,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
4709,0,0,97,115,0,4,94,1,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
4736,0,0,98,102,0,4,101,1,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
4763,0,0,99,102,0,4,107,1,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
4790,0,0,100,107,0,4,113,1,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
4817,0,0,101,772,0,9,177,1,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
4852,0,0,101,0,0,13,223,1,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
4915,0,0,102,107,0,4,359,1,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4938,0,0,103,58,0,4,382,1,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4961,0,0,104,68,0,4,428,1,0,1,0,0,1,0,2,3,0,0,
4980,0,0,105,151,0,4,615,1,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5007,0,0,106,372,0,4,640,1,0,9,8,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
5058,0,0,107,370,0,4,658,1,0,9,8,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
5109,0,0,108,101,0,4,957,1,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5136,0,0,109,172,0,6,1465,1,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5163,0,0,110,303,0,4,1663,1,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,1,9,0,0,
5206,0,0,111,140,0,4,1676,1,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
5245,0,0,112,109,0,6,1709,1,0,1,1,0,1,0,2,9,0,0,
5264,0,0,113,81,0,4,1866,1,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
5287,0,0,114,105,0,4,1878,1,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5314,0,0,115,110,0,4,1897,1,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5341,0,0,116,164,0,4,1917,1,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5368,0,0,117,171,0,4,1928,1,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5395,0,0,118,96,0,4,1956,1,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5422,0,0,119,90,0,4,1976,1,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5449,0,0,120,143,0,4,1997,1,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
5476,0,0,121,57,0,4,2032,1,0,1,0,0,1,0,2,9,0,0,
5495,0,0,122,100,0,4,2041,1,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,4,0,0,
5522,0,0,123,99,0,4,2076,1,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
5549,0,0,124,0,0,31,2133,1,0,0,0,0,1,0,
5564,0,0,125,191,0,3,2150,1,0,6,6,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
5603,0,0,126,0,0,29,2158,1,0,0,0,0,1,0,
5618,0,0,127,120,0,6,2164,1,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
5641,0,0,128,136,0,6,2173,1,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
5664,0,0,129,93,0,4,2195,1,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
5687,0,0,130,87,0,4,2373,1,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
5710,0,0,131,146,0,6,2382,1,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5737,0,0,132,134,0,4,2487,1,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
5768,0,0,133,96,0,4,2512,1,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
5799,0,0,134,78,0,4,2520,1,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
5826,0,0,135,150,0,4,2543,1,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.6                                                  */
/************************************************************************/
/* PROGRAM NAME          : RLILBRES                                     */
/* DESCRIPTION		     : Test Results report 				            */
/* AUTHOR                : S. SHEELVANT                                 */
/* DATE WRITTEN          : 17-NOV-1996                                  */
/*                                                                      */
/* CALLED FROM           : rlispcmn.frm                                 */
/*                                                                      */
/* FUNCTION              :                                              */
/*                                                                      */
/* TABLE DETAILS	    : RL_REQUEST_HEADER,RL_REQUEST_DETAIL,		    */
/*                         RL_TEST_RESULT,RL_PRINT_CONTROL_HDR	        */
/*                                                                      */
/* MODIFIED BY           : Srinivas  				                    */
/* MODIFIED ON		     : 31/07/2006                                   */
/*MODIFIED BY   		 : KrishnamoorthyS                              */
/*MODIFIED ON   		 : 02-dec-2014 For AMS-CRF-0067                 */
/*MODIFIED ON   		 : 01-03-2018 For GHL-CRF-0452-DD-01              */
/*MODIFIED ON   		 : 28-05-2018 For GHL-CRF-0489              */
/*MODIFIED ON   		 : 21-08-2018 For ML-MMOH-SCF-0934              */
/*MODIFIED ON   		 : 21-11-2018 For MO-CRF-20134              */
/*MODIFIED ON   		 : 04-01-2019 For KDAH-SCF-0546              */
/************************************************************************/

#include <stdio.h>
//#include <stdin.h>
/*#include <unistd.h> */       
#include "rl.h"
#define NODATAFOUND                     (sqlca.sqlcode == 1403)
#define OERROR 				(sqlca.sqlcode < 0)
#define LAST_ROW 			(sqlca.sqlcode == 1403)
#define NOT_FOUND 			(sqlca.sqlerrd[2] == 0)
#define TABLE_ALREADY_EXISTS 		(sqlca.sqlcode == -955)
#define RESOURCE_BUSY        		(sqlca.sqlcode == -54)
#define INIT_MESG "Fetching  Results"
#define ONLINE_PRINTING 0

#define ESC 0x1B
#define SEP 0xFA   

/*
#define DEBUG 				0
*/
#define SPOOL_DIR			""	


#define MAX_ORGANISMS	50

/* EXEC SQL BEGIN DECLARE SECTION; */ 


#define MAX_ANTIBIOTICS	250


   /* VARCHAR nd_operating_facility_id         [3],
			nd_facility_id					[5],
           uid_pwd                          [132],
           d_curr_pgm_name                  [31],
           nd_file_name                     [151],
	       today			                [20],
           nd_user	                        [31],
		   nd_trial						    [100],
           nd_file_no                       [100]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[5]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[20]; } today;

struct { unsigned short len; unsigned char arr[31]; } nd_user;

struct { unsigned short len; unsigned char arr[100]; } nd_trial;

struct { unsigned short len; unsigned char arr[100]; } nd_file_no;


   /* VARCHAR s_org							[MAX_ANTIBIOTICS][5],
           s_ant							[MAX_ANTIBIOTICS][5],
           s_ind							[MAX_ANTIBIOTICS][2],
		   s_rep							[MAX_ANTIBIOTICS][2],
  		   s_mic							[MAX_ANTIBIOTICS][10],
		   s_zone							[MAX_ANTIBIOTICS][10],
		   s_mic_print_yn					[MAX_ANTIBIOTICS][2]; */ 
struct { unsigned short len; unsigned char arr[6]; } s_org[250];

struct { unsigned short len; unsigned char arr[6]; } s_ant[250];

struct { unsigned short len; unsigned char arr[2]; } s_ind[250];

struct { unsigned short len; unsigned char arr[2]; } s_rep[250];

struct { unsigned short len; unsigned char arr[10]; } s_mic[250];

struct { unsigned short len; unsigned char arr[10]; } s_zone[250];

struct { unsigned short len; unsigned char arr[2]; } s_mic_print_yn[250];


   /* VARCHAR nd_hosp_no                       [31],	 /o Patient ID o/
           nd_spec_no                       [21],
           nd_cntrl_rowid                   [31],

           c_req_dtl_test_code              [11],/o Used in o/ 
           c_group_test_yn                  [2],/o Update_rl_request_detailo/
           c_count                          [3],/o-----o/
           c_count_profile                  [3],
           c_spec_no                        [21],

           p_print_name_yn                  [2],
		   print_name_yn					  [2],
	       p_test_desc                      [41],
           p_grp_status                     [2],
		   p_user_id						  [31],
		   first_user						  [31],
		   l_sy_req_date1					[30], 
		   l_sy_req_date					[30], 

           rl_hdr_source_code               [11],
           rl_hdr_consultant_code           [16],
           rl_hdr_spec_regd_date_time       [17],
           rl_hdr_current_date_time         [17],
           rl_hdr_section_code              [2],
           rl_hdr_request_comment_code1     [5],
           rl_hdr_request_comment_code2     [5],
           rl_hdr_request_comment_code3     [5],
           rl_hdr_request_comment_desc1     [41],
           rl_hdr_request_comment_desc2     [41],
           rl_hdr_request_comment_desc3     [41],
           rl_hdr_extra_copies_to           [16],
           rl_hdr_specimen_type_code        [5],
           rl_hdr_added_by_id               [31],
           rl_hdr_added_date                [16],
           rl_hdr_modified_by_id            [31],
           rl_hdr_modified_date             [16],
 	       rl_hdr_episode_type		        [2],
 	       rl_hdr_urgent_indicator	        [2],
		   rl_hdr_ordered_facility_id		[3],
	       rl_conf_yn					    [2],
		   rl_hdr_released_by_id	    	[31],
		   rl_hdr_released_date				[21],
		   rl_hdr_released_date1			[21], //added for globalisation

           rl_dtl_test_code_reqd			[11],
           rl_dtl_test_code                 [7][11],
           rl_dtl_result_status             [7][2],
           rl_dtl_group_test_flag           [7][2],

           rl_tst_group_test_code           [11],
           rl_tst_test_code                 [11],
           rl_tst_numeric_prefix            [2],
           rl_tst_numeric_result            [16],
           rl_tst_result_comment_desc1      [41],
           rl_tst_result_comment_desc2      [41],
           rl_tst_result_comment_desc3      [41],
           rl_tst_result_comment_desc4      [41],
		   rl_tst_status                    [2],
  		   rl_tst_tech_status		    [2],
  		   rl_tst_delta_status		    [2],
  		   rl_tst_qlty_status		    [2],
  		   rl_tst_cmnt_status		    [2],
  		   rl_tst_path_status		    [2],

		   rl_tst_interval_test_yn			[2], 
		   rl_tst_preliminary_release_yn	[2],

           rl_tst_rowid                     [31],
		   rl_tst_hide_rslt_comm_yn			[2],
		   rl_tst_cd_profile_yn				[2],


           rl_loc_test_code                 [11],
           rl_loc_grp_test_code             [11],

           rl_loc_long_desc                 [41],

           rl_pat_long_name                 [61],
           rl_pat_short_name                [61],
           rl_pat_sex                       [2],
           rl_pat_nationality               [4],
           rl_pat_dob_no_of_days            [10],
           rl_pat_date_of_birth             [16],
           rl_pat_blood_group               [3],
           rl_pat_g6pd                      [11],
           rl_pat_sicc                      [11],
           rl_pat_hbl4_1                    [11],
           rl_pat_hbl4_2                    [11],
		   rl_num_result_hide_yn			[2],

           rl_spc_specimen_desc             [41],

           rl_source_short_name             [41],    	 /o long name o/
           rl_consultant_short_name         [41], 	 /o long name o/
           rl_section_short_name            [41],  

           rl_tst_cd_short_desc             [41],
           rl_tst_cd_numeric_result_yn      [2],
           rl_tst_cd_age_sex_range_yn       [2],
           rl_tst_cd_function_yn            [2],
           rl_tst_cd_print_report_yn        [2],
           rl_tst_cd_low_value_normal       [16],
           rl_tst_cd_high_value_normal      [16],
           rl_tst_cd_result_name_text       [11],
           rl_tst_cd_group_test_yn          [2],
           rl_tst_cd_text_block_yn          [2],
           rl_tst_cd_culture_test_yn        [2],
           rl_tst_cd_snomed_yn              [2],
           rl_tst_cd_test_units             [11],
		   rl_tst_cd_test_units_desc        [16],
		   rl_tst_cd_test_units_2			[11],
           rl_tst_cd_range_cmt              [41],
		   rl_tst_cd_range_cmt_2			[41],

           rl_tst_range_low_v_nor    [16],
           rl_tst_range_high_v_nor   [16],

           rl_comm_for_test_com_text    [41],

		   rl_res_modify_reason		 [41],
		   rl_res_modify_reason_code [5],
		   rl_modify_reason_rel_by   [31],
		   rl_modify_reason_rel_dt   [31],
		   rl_modify_numeric_prefix  [2],
		   rl_modify_numeric_result  [16],
		   rl_modify_components_ind  [21],

           rl_res_result_text              [2000],
		   rl_bio_res_result_text          [2000], //added for MO-CRF-20134
		   rl_res_result_text1              [71],
           rl_res_result_text2              [71],
           rl_res_result_text3              [71],
           rl_res_result_text4              [71],
           rl_res_result_text5              [71],
           rl_res_result_text6              [71],
           rl_res_result_text7              [71],
           rl_res_result_text8              [71],
           rl_res_result_text9              [71],
           rl_res_result_text10             [71],

           rl_func_operand_1                [11],
           rl_func_operand_1_type           [2],
           rl_func_operator_1               [2],
           rl_func_operand_2                [11],
           rl_func_operand_2_type           [2],
           rl_func_operator_2               [2],
  
           rl_func_value                    [16],

           rl_calc_str                      [400],
           rl_func_str                      [400],

           rl_res_organism_code             [5],
           rl_res_comment_desc              [41],
		   rl_res_hide_organism_yn          [2], /oAdded for CRF20281 by srinivaso/    

           rl_res_organism_code_desc        [41],
		   rl_bio_organism_code_desc          [41],//added for MO-CRF-20134
		   rl_bio_organism_code_desc1          [41],//added for MO-CRF-20134
		   b_group_test_desc		          [41],//added for MO-CRF-20134
		   b_test_desc		          [41],//added for MO-CRF-20134
		   b_group_test_yn			          [1],//added for MO-CRF-20134

           rl_res_dtl_antibiotic_code       [5],
           rl_res_dtl_antibiotic_desc       [41],
           rl_res_dtl_sensitivity_ind       [2],
           rl_res_dtl_report_yn             [2],
	   
	       sy_acc_entity_name 		        [81],

		   b_antibiotic_code				[5],
		   b_sensitivity_ind				[2],
		   b_report_yn						[2],
  		   b_mic_value              [10],  
		   b_mic_sign              [2], 	//added for AMS-CRF-0067 by krishnamoorthys
		   b_zone_value				[10],
		   b_mic_print_yn			[2],
           rl_mic_to_print_yn			[2],
		   rl_print_mic_sign_yn		[2],

		   rl_mic_value_uom			[7],
           
           rl_res_snomed_code               [21],
		   rl_res_snomed_code2				[21],
           
		   rl_res_snomed_mrkr_code1         [2],
		   rl_res_snomed_mrkr_code2         [2],		    

	       rl_param_print_start		        [2],

	       op_clinic_lab_print_reqd_yn	    [2],

		   a_antibiotic_code		        [5],

           rl_snomed_desc1                  [301],
           rl_snomed_desc2                  [41],
           rl_snomed_desc3                  [41],
           rl_snomed_desc4                  [41],
           rl_snomed_desc5                  [41],
           rl_snomed_print_yn               [2],
           rl_snomed2_desc1                  [301],
           rl_snomed2_desc2                  [41],
           rl_snomed2_desc3                  [41],
           rl_snomed2_desc4                  [41],
           rl_snomed2_desc5                  [41],
           rl_snomed2_print_yn               [2],
		   r_rslt							 [20], 
		   v_numeric_result					 [21],

		   nd_snomed_mrkr_desc2				 [41],
		   nd_snomed_mrkr2_print_yn          [2],
		   nd_snomed_mrkr_desc1				 [41],
		   nd_snomed_mrkr1_print_yn          [2],
		   nd_res_modify_reason_print_yn     [2],
		   nd_user_conf_access_yn			 [2], 	
		   rl_print_pend_profile_yn          [2],
		   rl_legend_for_pending 		     [40], 
		   rl_print_prev_modified_result_yn  [2],
		   rl_legend_for_pre_result		[100],
		   rl_print_test_method_yn			 [2],
		   rl_tst_test_method_code			 [4],
		   rl_tst_test_method_code_t		 [4],
		   rl_tst_test_t		 			[100], //added for ML-MMOH-SCF-0934  
		   rl_tst_test_sub_sec			 [4], //added for GHL-CRF-0452-DD-01
		   rl_tst_test_sub_sec_t		 [4],//added for GHL-CRF-0452-DD-01
		   
		   rl_grp_tst_test_sub_sec			 [4], //GHL-CRF-0489
		   rl_grp_tst_test_sub_sec_t		 [4],//GHL-CRF-0489
		   
		   rl_test_method_desc				 [61], //modified 16 to 61 for ML-MMOH-CRF-0788
		   rl_sub_sec_desc				 [61], //ADDED FOR GHL-CRF-0452-DD-01
		   rl_customer_id					 [10],
		   l_customer_id					 [10],
		   rl_critical_result				 [1], //added for INT-CRF-BRU-LIS-006
		   rl_func_ctl						  [1],	//added for INT-CRF-BRU-LIS-006
		   l_critical_result				 [1], //added for MMS-RY-SCF-0062
	   result_line                      [100],
	   result_status                    [2],
	   result_tech_status               [2],
	   result_delta_status              [2],
	   result_qlty_status               [2],
	   result_cmnt_status               [2],
	   result_path_status               [2],

       p_function_yn                    [2],
	   p_test_units                     [11],
  	   d_loc_str 			    [20], 
  	   d_l_str 			    [20], 
	   d_l_str_bio 			    [100],  //added for MO-CRF-20134
	   d_l_str_org_leg 			    [100],  //added for MO-CRF-20134
  	   d_dec_part			    [20],
  	   d_int_part			    [20],
  	   d_sig_part			    [20]; */ 
struct { unsigned short len; unsigned char arr[31]; } nd_hosp_no;

struct { unsigned short len; unsigned char arr[21]; } nd_spec_no;

struct { unsigned short len; unsigned char arr[31]; } nd_cntrl_rowid;

struct { unsigned short len; unsigned char arr[11]; } c_req_dtl_test_code;

struct { unsigned short len; unsigned char arr[2]; } c_group_test_yn;

struct { unsigned short len; unsigned char arr[3]; } c_count;

struct { unsigned short len; unsigned char arr[3]; } c_count_profile;

struct { unsigned short len; unsigned char arr[21]; } c_spec_no;

struct { unsigned short len; unsigned char arr[2]; } p_print_name_yn;

struct { unsigned short len; unsigned char arr[2]; } print_name_yn;

struct { unsigned short len; unsigned char arr[41]; } p_test_desc;

struct { unsigned short len; unsigned char arr[2]; } p_grp_status;

struct { unsigned short len; unsigned char arr[31]; } p_user_id;

struct { unsigned short len; unsigned char arr[31]; } first_user;

struct { unsigned short len; unsigned char arr[30]; } l_sy_req_date1;

struct { unsigned short len; unsigned char arr[30]; } l_sy_req_date;

struct { unsigned short len; unsigned char arr[11]; } rl_hdr_source_code;

struct { unsigned short len; unsigned char arr[16]; } rl_hdr_consultant_code;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_current_date_time;

struct { unsigned short len; unsigned char arr[2]; } rl_hdr_section_code;

struct { unsigned short len; unsigned char arr[5]; } rl_hdr_request_comment_code1;

struct { unsigned short len; unsigned char arr[5]; } rl_hdr_request_comment_code2;

struct { unsigned short len; unsigned char arr[5]; } rl_hdr_request_comment_code3;

struct { unsigned short len; unsigned char arr[41]; } rl_hdr_request_comment_desc1;

struct { unsigned short len; unsigned char arr[41]; } rl_hdr_request_comment_desc2;

struct { unsigned short len; unsigned char arr[41]; } rl_hdr_request_comment_desc3;

struct { unsigned short len; unsigned char arr[16]; } rl_hdr_extra_copies_to;

struct { unsigned short len; unsigned char arr[5]; } rl_hdr_specimen_type_code;

struct { unsigned short len; unsigned char arr[31]; } rl_hdr_added_by_id;

struct { unsigned short len; unsigned char arr[16]; } rl_hdr_added_date;

struct { unsigned short len; unsigned char arr[31]; } rl_hdr_modified_by_id;

struct { unsigned short len; unsigned char arr[16]; } rl_hdr_modified_date;

struct { unsigned short len; unsigned char arr[2]; } rl_hdr_episode_type;

struct { unsigned short len; unsigned char arr[2]; } rl_hdr_urgent_indicator;

struct { unsigned short len; unsigned char arr[3]; } rl_hdr_ordered_facility_id;

struct { unsigned short len; unsigned char arr[2]; } rl_conf_yn;

struct { unsigned short len; unsigned char arr[31]; } rl_hdr_released_by_id;

struct { unsigned short len; unsigned char arr[21]; } rl_hdr_released_date;

struct { unsigned short len; unsigned char arr[21]; } rl_hdr_released_date1;

struct { unsigned short len; unsigned char arr[11]; } rl_dtl_test_code_reqd;

struct { unsigned short len; unsigned char arr[14]; } rl_dtl_test_code[7];

struct { unsigned short len; unsigned char arr[2]; } rl_dtl_result_status[7];

struct { unsigned short len; unsigned char arr[2]; } rl_dtl_group_test_flag[7];

struct { unsigned short len; unsigned char arr[11]; } rl_tst_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } rl_tst_test_code;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_numeric_prefix;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_numeric_result;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_result_comment_desc1;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_result_comment_desc2;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_result_comment_desc3;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_result_comment_desc4;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_tech_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_delta_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_qlty_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cmnt_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_path_status;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_interval_test_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_preliminary_release_yn;

struct { unsigned short len; unsigned char arr[31]; } rl_tst_rowid;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_hide_rslt_comm_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_profile_yn;

struct { unsigned short len; unsigned char arr[11]; } rl_loc_test_code;

struct { unsigned short len; unsigned char arr[11]; } rl_loc_grp_test_code;

struct { unsigned short len; unsigned char arr[41]; } rl_loc_long_desc;

struct { unsigned short len; unsigned char arr[61]; } rl_pat_long_name;

struct { unsigned short len; unsigned char arr[61]; } rl_pat_short_name;

struct { unsigned short len; unsigned char arr[2]; } rl_pat_sex;

struct { unsigned short len; unsigned char arr[4]; } rl_pat_nationality;

struct { unsigned short len; unsigned char arr[10]; } rl_pat_dob_no_of_days;

struct { unsigned short len; unsigned char arr[16]; } rl_pat_date_of_birth;

struct { unsigned short len; unsigned char arr[3]; } rl_pat_blood_group;

struct { unsigned short len; unsigned char arr[11]; } rl_pat_g6pd;

struct { unsigned short len; unsigned char arr[11]; } rl_pat_sicc;

struct { unsigned short len; unsigned char arr[11]; } rl_pat_hbl4_1;

struct { unsigned short len; unsigned char arr[11]; } rl_pat_hbl4_2;

struct { unsigned short len; unsigned char arr[2]; } rl_num_result_hide_yn;

struct { unsigned short len; unsigned char arr[41]; } rl_spc_specimen_desc;

struct { unsigned short len; unsigned char arr[41]; } rl_source_short_name;

struct { unsigned short len; unsigned char arr[41]; } rl_consultant_short_name;

struct { unsigned short len; unsigned char arr[41]; } rl_section_short_name;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_cd_short_desc;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_numeric_result_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_age_sex_range_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_function_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_print_report_yn;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_cd_low_value_normal;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_cd_high_value_normal;

struct { unsigned short len; unsigned char arr[11]; } rl_tst_cd_result_name_text;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_group_test_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_text_block_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_culture_test_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_snomed_yn;

struct { unsigned short len; unsigned char arr[11]; } rl_tst_cd_test_units;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_cd_test_units_desc;

struct { unsigned short len; unsigned char arr[11]; } rl_tst_cd_test_units_2;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_cd_range_cmt;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_cd_range_cmt_2;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_range_low_v_nor;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_range_high_v_nor;

struct { unsigned short len; unsigned char arr[41]; } rl_comm_for_test_com_text;

struct { unsigned short len; unsigned char arr[41]; } rl_res_modify_reason;

struct { unsigned short len; unsigned char arr[5]; } rl_res_modify_reason_code;

struct { unsigned short len; unsigned char arr[31]; } rl_modify_reason_rel_by;

struct { unsigned short len; unsigned char arr[31]; } rl_modify_reason_rel_dt;

struct { unsigned short len; unsigned char arr[2]; } rl_modify_numeric_prefix;

struct { unsigned short len; unsigned char arr[16]; } rl_modify_numeric_result;

struct { unsigned short len; unsigned char arr[21]; } rl_modify_components_ind;

struct { unsigned short len; unsigned char arr[2000]; } rl_res_result_text;

struct { unsigned short len; unsigned char arr[2000]; } rl_bio_res_result_text;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text1;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text2;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text3;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text4;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text5;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text6;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text7;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text8;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text9;

struct { unsigned short len; unsigned char arr[71]; } rl_res_result_text10;

struct { unsigned short len; unsigned char arr[11]; } rl_func_operand_1;

struct { unsigned short len; unsigned char arr[2]; } rl_func_operand_1_type;

struct { unsigned short len; unsigned char arr[2]; } rl_func_operator_1;

struct { unsigned short len; unsigned char arr[11]; } rl_func_operand_2;

struct { unsigned short len; unsigned char arr[2]; } rl_func_operand_2_type;

struct { unsigned short len; unsigned char arr[2]; } rl_func_operator_2;

struct { unsigned short len; unsigned char arr[16]; } rl_func_value;

struct { unsigned short len; unsigned char arr[400]; } rl_calc_str;

struct { unsigned short len; unsigned char arr[400]; } rl_func_str;

struct { unsigned short len; unsigned char arr[5]; } rl_res_organism_code;

struct { unsigned short len; unsigned char arr[41]; } rl_res_comment_desc;

struct { unsigned short len; unsigned char arr[2]; } rl_res_hide_organism_yn;

struct { unsigned short len; unsigned char arr[41]; } rl_res_organism_code_desc;

struct { unsigned short len; unsigned char arr[41]; } rl_bio_organism_code_desc;

struct { unsigned short len; unsigned char arr[41]; } rl_bio_organism_code_desc1;

struct { unsigned short len; unsigned char arr[41]; } b_group_test_desc;

struct { unsigned short len; unsigned char arr[41]; } b_test_desc;

struct { unsigned short len; unsigned char arr[1]; } b_group_test_yn;

struct { unsigned short len; unsigned char arr[5]; } rl_res_dtl_antibiotic_code;

struct { unsigned short len; unsigned char arr[41]; } rl_res_dtl_antibiotic_desc;

struct { unsigned short len; unsigned char arr[2]; } rl_res_dtl_sensitivity_ind;

struct { unsigned short len; unsigned char arr[2]; } rl_res_dtl_report_yn;

struct { unsigned short len; unsigned char arr[81]; } sy_acc_entity_name;

struct { unsigned short len; unsigned char arr[5]; } b_antibiotic_code;

struct { unsigned short len; unsigned char arr[2]; } b_sensitivity_ind;

struct { unsigned short len; unsigned char arr[2]; } b_report_yn;

struct { unsigned short len; unsigned char arr[10]; } b_mic_value;

struct { unsigned short len; unsigned char arr[2]; } b_mic_sign;

struct { unsigned short len; unsigned char arr[10]; } b_zone_value;

struct { unsigned short len; unsigned char arr[2]; } b_mic_print_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_mic_to_print_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_mic_sign_yn;

struct { unsigned short len; unsigned char arr[7]; } rl_mic_value_uom;

struct { unsigned short len; unsigned char arr[21]; } rl_res_snomed_code;

struct { unsigned short len; unsigned char arr[21]; } rl_res_snomed_code2;

struct { unsigned short len; unsigned char arr[2]; } rl_res_snomed_mrkr_code1;

struct { unsigned short len; unsigned char arr[2]; } rl_res_snomed_mrkr_code2;

struct { unsigned short len; unsigned char arr[2]; } rl_param_print_start;

struct { unsigned short len; unsigned char arr[2]; } op_clinic_lab_print_reqd_yn;

struct { unsigned short len; unsigned char arr[5]; } a_antibiotic_code;

struct { unsigned short len; unsigned char arr[301]; } rl_snomed_desc1;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed_desc2;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed_desc3;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed_desc4;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed_desc5;

struct { unsigned short len; unsigned char arr[2]; } rl_snomed_print_yn;

struct { unsigned short len; unsigned char arr[301]; } rl_snomed2_desc1;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed2_desc2;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed2_desc3;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed2_desc4;

struct { unsigned short len; unsigned char arr[41]; } rl_snomed2_desc5;

struct { unsigned short len; unsigned char arr[2]; } rl_snomed2_print_yn;

struct { unsigned short len; unsigned char arr[20]; } r_rslt;

struct { unsigned short len; unsigned char arr[21]; } v_numeric_result;

struct { unsigned short len; unsigned char arr[41]; } nd_snomed_mrkr_desc2;

struct { unsigned short len; unsigned char arr[2]; } nd_snomed_mrkr2_print_yn;

struct { unsigned short len; unsigned char arr[41]; } nd_snomed_mrkr_desc1;

struct { unsigned short len; unsigned char arr[2]; } nd_snomed_mrkr1_print_yn;

struct { unsigned short len; unsigned char arr[2]; } nd_res_modify_reason_print_yn;

struct { unsigned short len; unsigned char arr[2]; } nd_user_conf_access_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_pend_profile_yn;

struct { unsigned short len; unsigned char arr[40]; } rl_legend_for_pending;

struct { unsigned short len; unsigned char arr[2]; } rl_print_prev_modified_result_yn;

struct { unsigned short len; unsigned char arr[100]; } rl_legend_for_pre_result;

struct { unsigned short len; unsigned char arr[2]; } rl_print_test_method_yn;

struct { unsigned short len; unsigned char arr[4]; } rl_tst_test_method_code;

struct { unsigned short len; unsigned char arr[4]; } rl_tst_test_method_code_t;

struct { unsigned short len; unsigned char arr[100]; } rl_tst_test_t;

struct { unsigned short len; unsigned char arr[4]; } rl_tst_test_sub_sec;

struct { unsigned short len; unsigned char arr[4]; } rl_tst_test_sub_sec_t;

struct { unsigned short len; unsigned char arr[4]; } rl_grp_tst_test_sub_sec;

struct { unsigned short len; unsigned char arr[4]; } rl_grp_tst_test_sub_sec_t;

struct { unsigned short len; unsigned char arr[61]; } rl_test_method_desc;

struct { unsigned short len; unsigned char arr[61]; } rl_sub_sec_desc;

struct { unsigned short len; unsigned char arr[10]; } rl_customer_id;

struct { unsigned short len; unsigned char arr[10]; } l_customer_id;

struct { unsigned short len; unsigned char arr[1]; } rl_critical_result;

struct { unsigned short len; unsigned char arr[1]; } rl_func_ctl;

struct { unsigned short len; unsigned char arr[1]; } l_critical_result;

struct { unsigned short len; unsigned char arr[100]; } result_line;

struct { unsigned short len; unsigned char arr[2]; } result_status;

struct { unsigned short len; unsigned char arr[2]; } result_tech_status;

struct { unsigned short len; unsigned char arr[2]; } result_delta_status;

struct { unsigned short len; unsigned char arr[2]; } result_qlty_status;

struct { unsigned short len; unsigned char arr[2]; } result_cmnt_status;

struct { unsigned short len; unsigned char arr[2]; } result_path_status;

struct { unsigned short len; unsigned char arr[2]; } p_function_yn;

struct { unsigned short len; unsigned char arr[11]; } p_test_units;

struct { unsigned short len; unsigned char arr[20]; } d_loc_str;

struct { unsigned short len; unsigned char arr[20]; } d_l_str;

struct { unsigned short len; unsigned char arr[100]; } d_l_str_bio;

struct { unsigned short len; unsigned char arr[100]; } d_l_str_org_leg;

struct { unsigned short len; unsigned char arr[20]; } d_dec_part;

struct { unsigned short len; unsigned char arr[20]; } d_int_part;

struct { unsigned short len; unsigned char arr[20]; } d_sig_part;



/****** NEWLY ADDED FOR GTT SPECIMENS  ********/
/* VARCHAR    nd_status					[2],
		   d_specimen_no				[21],
		   d_group_test_code			[11],
		   d_test_code					[11],
		   d_no							[21],
		   p_param8						[2],
		   actual_specimen				[21],
		   interval_description			[41],
		   first_specimen_no			[21]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_status;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } d_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[21]; } d_no;

struct { unsigned short len; unsigned char arr[2]; } p_param8;

struct { unsigned short len; unsigned char arr[21]; } actual_specimen;

struct { unsigned short len; unsigned char arr[41]; } interval_description;

struct { unsigned short len; unsigned char arr[21]; } first_specimen_no;


/*********** NEWLY ADDED FOR KNDV LAB ENHANCEMENTS **********/
/* VARCHAR 	 rl_cancelled_yn				  [2],
			 rl_high_low_ind			      [10],
			 can_spec_no					  [21],
			 can_group_test					  [11],
			 can_test_name					  [41], 
			 can_test_code				      [11],
	 	     l_low_val						  [16],
		     l_high_val						  [16],
			 cancel_reason					  [41]; */ 
struct { unsigned short len; unsigned char arr[2]; } rl_cancelled_yn;

struct { unsigned short len; unsigned char arr[10]; } rl_high_low_ind;

struct { unsigned short len; unsigned char arr[21]; } can_spec_no;

struct { unsigned short len; unsigned char arr[11]; } can_group_test;

struct { unsigned short len; unsigned char arr[41]; } can_test_name;

struct { unsigned short len; unsigned char arr[11]; } can_test_code;

struct { unsigned short len; unsigned char arr[16]; } l_low_val;

struct { unsigned short len; unsigned char arr[16]; } l_high_val;

struct { unsigned short len; unsigned char arr[41]; } cancel_reason;

			 
/***** ADDED by madhu for showing notify details FD-ML-MMOH-CRF-0332 *******/
			/* VARCHAR  RL_NOTIFY_CODE [5],
			RL_NOTIFY_BY [30],
			RL_NOTIFY_TO[30],
			RL_NOTIFY_DATE_TIME1 [30],
			RL_NOTIFY_TEXT [2000],
			rl_print_notify_yn [5]; */ 
struct { unsigned short len; unsigned char arr[5]; } RL_NOTIFY_CODE;

struct { unsigned short len; unsigned char arr[30]; } RL_NOTIFY_BY;

struct { unsigned short len; unsigned char arr[30]; } RL_NOTIFY_TO;

struct { unsigned short len; unsigned char arr[30]; } RL_NOTIFY_DATE_TIME1;

struct { unsigned short len; unsigned char arr[2000]; } RL_NOTIFY_TEXT;

struct { unsigned short len; unsigned char arr[5]; } rl_print_notify_yn;
	
			int c_count_notify = 0;	
            			
			 

/*********** NEWLY ADDED FOR KNDV LAB ENHANCEMENTS OF SNOMED CODE TO PRINT Y/N**********/
/* VARCHAR		 rl_print_snomed_code_yn		  [2],
			 rl_print_snomed2_code_yn		  [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } rl_print_snomed_code_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_snomed2_code_yn;


/* VARCHAR	     rl_inhibit_report_yn			  [2],
             rl_report_format				  [2],
             test_desc_fill_for_report        [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } rl_inhibit_report_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_report_format;

struct { unsigned short len; unsigned char arr[2]; } test_desc_fill_for_report;
 
int i_count = 0, u_count = 0, l_seq_no = 0;
int l_mth_count=1,l_mth_count1=0,i_test_count=0; //added for ML-MMOH-SCF-0934
int		mic_count=0;
int     mic_sign_count=0;//added for AMS-CRF-0067 linked In-52950
int   l_customer=0 ; //added for AMS-CRF-0067 by krishnamoorthys

/* VARCHAR  l_org_seq_no[100]; */ 
struct { unsigned short len; unsigned char arr[100]; } l_org_seq_no;
 //added for MO-CRF-20128
/* VARCHAR    sql_stmt[5000]; */ 
struct { unsigned short len; unsigned char arr[5000]; } sql_stmt;



   int     no_of_dtl_recs = 0,
           rl_tst_cd_no_of_decimals = 0,
	       sy_ref_no_of_copies = 0,
           rl_tst_cd_significant_digit = 0,
		   i = 0,
	   result_line_no = 0,
	   d_dec_pos = 0,
	   d_after_sig_digit = 0,
	   p_significant_digit = 0,
	   p_no_of_decimals = 0,
	   end_pgm_control = 0;

      char flag;
	char err_num[10];
	  long l_session = 0;
	  int d_seq_no = 0, rl_seq_no = 0;
	  int l_exist_decimals = 0;
	  int l_inst_decimals = 0;
	  int l_low = 0, l_high = 0;

	  int l_count = 0;
	  int err_flag = 0;
	float mt;
	  int other_than_comments = 0;
	  int t_antib_head_first_time = 0;

/*** added for previous results printing 07.08.2004 *******/

/* VARCHAR  rl_print_prv_result_yn           [2],
		 nd_prv_result_dt				  [31],
		 d_past_result_unit      		  [6],
		 d_prv_specimen_no				  [21],
		 d_tst_prv_test_code			  [11],
		 d_tst_prv_numeric_result    	  [16],
		 d_num_prv_prefix				  [2],
		 d_status_prv					  [2],
		 d_tst_prv_units				  [11],
		 d_tst_prv_age_range_low		  [16],
		 d_tst_prv_age_range_high		  [16],
		 d_tst_prv_high_low_ind			  [10],
		 d_prv_spec_regd_date_time		  [31],
		 d_prv_spec_facility_id			  [3],
		 d_num_result_hide_yn			  [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } rl_print_prv_result_yn;

struct { unsigned short len; unsigned char arr[31]; } nd_prv_result_dt;

struct { unsigned short len; unsigned char arr[6]; } d_past_result_unit;

struct { unsigned short len; unsigned char arr[21]; } d_prv_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } d_tst_prv_test_code;

struct { unsigned short len; unsigned char arr[16]; } d_tst_prv_numeric_result;

struct { unsigned short len; unsigned char arr[2]; } d_num_prv_prefix;

struct { unsigned short len; unsigned char arr[2]; } d_status_prv;

struct { unsigned short len; unsigned char arr[11]; } d_tst_prv_units;

struct { unsigned short len; unsigned char arr[16]; } d_tst_prv_age_range_low;

struct { unsigned short len; unsigned char arr[16]; } d_tst_prv_age_range_high;

struct { unsigned short len; unsigned char arr[10]; } d_tst_prv_high_low_ind;

struct { unsigned short len; unsigned char arr[31]; } d_prv_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[3]; } d_prv_spec_facility_id;

struct { unsigned short len; unsigned char arr[2]; } d_num_result_hide_yn;


		int		d_past_result_period = 0;
		int		d_past_result_no     = 0;
	    int     p_count			     = 0;
		int er_msg_type = 0;
		int     past_results_head_printed = 0;
		int     rl_num_component_modified = 0; /// 07.03.2006


/***** ADDED FOR KDAH requirement to print the long desc of result text ********/
	/* VARCHAR rl_print_text_desc_yn [2],
			rl_print_text_bold_yn[2],
			rl_print_text_underline_yn[2],
			rl_res_result_text_code[10],
			rl_res_text_code_desc[50],
			
			rl_bio_text_code_desc[50], //added for MO-CRF-20134
			rl_bio_result_comment_code[50], //added for MO-CRF-20134
			rl_bio_result_comment_desc[50]; */ 
struct { unsigned short len; unsigned char arr[2]; } rl_print_text_desc_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_text_bold_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_text_underline_yn;

struct { unsigned short len; unsigned char arr[10]; } rl_res_result_text_code;

struct { unsigned short len; unsigned char arr[50]; } rl_res_text_code_desc;

struct { unsigned short len; unsigned char arr[50]; } rl_bio_text_code_desc;

struct { unsigned short len; unsigned char arr[50]; } rl_bio_result_comment_code;

struct { unsigned short len; unsigned char arr[50]; } rl_bio_result_comment_desc;
 //added for MO-CRF-20134
			
	//added for MO-CRF-20134
	/* VARCHAR      rl_bio_res_result_text_code[20],
			 rl_bio_test_code[10],
			 rl_bio_organism_code[20],
			 rl_bio_organism_code1[20],
			 rl_b_grp_test_code[20],
			 rl_b_test_code[20]; */ 
struct { unsigned short len; unsigned char arr[20]; } rl_bio_res_result_text_code;

struct { unsigned short len; unsigned char arr[10]; } rl_bio_test_code;

struct { unsigned short len; unsigned char arr[20]; } rl_bio_organism_code;

struct { unsigned short len; unsigned char arr[20]; } rl_bio_organism_code1;

struct { unsigned short len; unsigned char arr[20]; } rl_b_grp_test_code;

struct { unsigned short len; unsigned char arr[20]; } rl_b_test_code;

	
	
	//END MO-CRF-20134


    /* VARCHAR  rl_lab_title                     [101],
			 rl_lab_title_2					  [201],
			 rl_lab_title_3					  [201],
			 rl_lab_title_4					  [201],
			 rl_lab_title_5					  [201],
			 rl_lab_title_6					  [201],
			 rl_actual_dob_yn				  [2], 
			 rl_race_code					  [11],
			 rl_age_years					  [3], 
			 rl_national_id_num               [21],
			 rl_alternate_id_num              [21],
			 rl_location					  [21], 
			 d_race_desc					  [31], 
			 d_clinical_text_code			  [5],
			 d_clinical_text				  [4001],
			 d_clinical_spec_no				  [21], 
			 rl_test_requested_yn			  [2],
			 d_inhibit_yn					  [2],
			 inhibit_test_code				  [11], 
			 rl_message_line				  [500],
			 rl_name_on_report_yn			  [2],
			 rl_print_build_clin_hist_yn      [2],
			 rl_footer_line_1				  [500],
			 rl_footer_line_2				  [500],
			 rl_footer_line_3				  [500],
			 rl_category_code				  [5],
			 rl_category_year				  [5],
			 rl_category_number				  [21], 
			 rl_ordered_facility_id			  [3],
			 rl_ordering_doctor_name		  [41],
			 rl_order_id					  [21],
			 rl_perform_site_code			  [5],
	         rl_hdr_spec_recd_date_time       [17],
		     rl_hdr_spec_recd_date_time1       [17],//added for globalisation
	         rl_hdr_spec_regd_date_time1       [17],//added for globalisation
  			 rl_hdr_spec_colltd_date_time     [17],
  			 rl_hdr_spec_colltd_date_time1     [17],//added for globalisation
			 language_id			[5],
			 BVNewVersionYN					  [2]; */ 
struct { unsigned short len; unsigned char arr[101]; } rl_lab_title;

struct { unsigned short len; unsigned char arr[201]; } rl_lab_title_2;

struct { unsigned short len; unsigned char arr[201]; } rl_lab_title_3;

struct { unsigned short len; unsigned char arr[201]; } rl_lab_title_4;

struct { unsigned short len; unsigned char arr[201]; } rl_lab_title_5;

struct { unsigned short len; unsigned char arr[201]; } rl_lab_title_6;

struct { unsigned short len; unsigned char arr[2]; } rl_actual_dob_yn;

struct { unsigned short len; unsigned char arr[11]; } rl_race_code;

struct { unsigned short len; unsigned char arr[3]; } rl_age_years;

struct { unsigned short len; unsigned char arr[21]; } rl_national_id_num;

struct { unsigned short len; unsigned char arr[21]; } rl_alternate_id_num;

struct { unsigned short len; unsigned char arr[21]; } rl_location;

struct { unsigned short len; unsigned char arr[31]; } d_race_desc;

struct { unsigned short len; unsigned char arr[5]; } d_clinical_text_code;

struct { unsigned short len; unsigned char arr[4001]; } d_clinical_text;

struct { unsigned short len; unsigned char arr[21]; } d_clinical_spec_no;

struct { unsigned short len; unsigned char arr[2]; } rl_test_requested_yn;

struct { unsigned short len; unsigned char arr[2]; } d_inhibit_yn;

struct { unsigned short len; unsigned char arr[11]; } inhibit_test_code;

struct { unsigned short len; unsigned char arr[500]; } rl_message_line;

struct { unsigned short len; unsigned char arr[2]; } rl_name_on_report_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_build_clin_hist_yn;

struct { unsigned short len; unsigned char arr[500]; } rl_footer_line_1;

struct { unsigned short len; unsigned char arr[500]; } rl_footer_line_2;

struct { unsigned short len; unsigned char arr[500]; } rl_footer_line_3;

struct { unsigned short len; unsigned char arr[5]; } rl_category_code;

struct { unsigned short len; unsigned char arr[5]; } rl_category_year;

struct { unsigned short len; unsigned char arr[21]; } rl_category_number;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[41]; } rl_ordering_doctor_name;

struct { unsigned short len; unsigned char arr[21]; } rl_order_id;

struct { unsigned short len; unsigned char arr[5]; } rl_perform_site_code;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_recd_date_time;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_recd_date_time1;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_regd_date_time1;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_colltd_date_time;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_colltd_date_time1;

struct { unsigned short len; unsigned char arr[5]; } language_id;

struct { unsigned short len; unsigned char arr[2]; } BVNewVersionYN;


	/* VARCHAR		draft_printing_yn			 [2],
				nd_nationality_desc          [21],
				rl_pat_actual_id             [31],
			    nd_order_date_time          [17],
				rl_use_sample_anatomy_ind    [3],
				nd_anatomy_site_desc		 [41],
				nd_anatomy_site					 [5],
				sy_ord_acc_entity_name		    [61],
				rl_title_for_test            [50],
				rl_title_for_num_result      [50],
				rl_title_for_range_ind		[50],
				rl_title_for_test_units		[50],
				rl_title_for_result_range	[50],
				rl_title1_for_result_range	[50],
				rl_title2_for_result_range	[50],
				rl_title3_for_result_range	[50],
				rl_title4_for_result_range	[50],
				l_report_legend      [20],		   		   
				rl_print_num_result_title_yn [2],
				nd_position_desc                  [31], 
		   sy_user_id			[31],
		   sy_user						  [31],
			 sy_user_name					  [60],
             sy_func_role_id                  [21],
           sy_session_id		[30],
           sy_req_date			[30],
		   er_msg                           [1071],
		   er_msg_num						[1000],
		   rl_race_accepted_yn		     [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } draft_printing_yn;

struct { unsigned short len; unsigned char arr[21]; } nd_nationality_desc;

struct { unsigned short len; unsigned char arr[31]; } rl_pat_actual_id;

struct { unsigned short len; unsigned char arr[17]; } nd_order_date_time;

struct { unsigned short len; unsigned char arr[3]; } rl_use_sample_anatomy_ind;

struct { unsigned short len; unsigned char arr[41]; } nd_anatomy_site_desc;

struct { unsigned short len; unsigned char arr[5]; } nd_anatomy_site;

struct { unsigned short len; unsigned char arr[61]; } sy_ord_acc_entity_name;

struct { unsigned short len; unsigned char arr[50]; } rl_title_for_test;

struct { unsigned short len; unsigned char arr[50]; } rl_title_for_num_result;

struct { unsigned short len; unsigned char arr[50]; } rl_title_for_range_ind;

struct { unsigned short len; unsigned char arr[50]; } rl_title_for_test_units;

struct { unsigned short len; unsigned char arr[50]; } rl_title_for_result_range;

struct { unsigned short len; unsigned char arr[50]; } rl_title1_for_result_range;

struct { unsigned short len; unsigned char arr[50]; } rl_title2_for_result_range;

struct { unsigned short len; unsigned char arr[50]; } rl_title3_for_result_range;

struct { unsigned short len; unsigned char arr[50]; } rl_title4_for_result_range;

struct { unsigned short len; unsigned char arr[20]; } l_report_legend;

struct { unsigned short len; unsigned char arr[2]; } rl_print_num_result_title_yn;

struct { unsigned short len; unsigned char arr[31]; } nd_position_desc;

struct { unsigned short len; unsigned char arr[31]; } sy_user_id;

struct { unsigned short len; unsigned char arr[31]; } sy_user;

struct { unsigned short len; unsigned char arr[60]; } sy_user_name;

struct { unsigned short len; unsigned char arr[21]; } sy_func_role_id;

struct { unsigned short len; unsigned char arr[30]; } sy_session_id;

struct { unsigned short len; unsigned char arr[30]; } sy_req_date;

struct { unsigned short len; unsigned char arr[1071]; } er_msg;

struct { unsigned short len; unsigned char arr[1000]; } er_msg_num;

struct { unsigned short len; unsigned char arr[2]; } rl_race_accepted_yn;


		/*  For Patient Age SYSDATE, MTHS */
   /* VARCHAR  tday				[30],
			t_days				[30],
			mths				[30],
			mths1				[30],
			t_age				[30],
			rl_regd_date		[11]; */ 
struct { unsigned short len; unsigned char arr[30]; } tday;

struct { unsigned short len; unsigned char arr[30]; } t_days;

struct { unsigned short len; unsigned char arr[30]; } mths;

struct { unsigned short len; unsigned char arr[30]; } mths1;

struct { unsigned short len; unsigned char arr[30]; } t_age;

struct { unsigned short len; unsigned char arr[11]; } rl_regd_date;

/* VARCHAR		l_translated_value		 [600]; */ 
struct { unsigned short len; unsigned char arr[600]; } l_translated_value;



/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header: sqlca.h,v 1.3 1994/12/12 19:27:27 jbasu Exp $ sqlca.h 
 */

/* Copyright (c) 1985,1986, 1998 by Oracle Corporation. */
 
/*
NAME
  SQLCA : SQL Communications Area.
FUNCTION
  Contains no code. Oracle fills in the SQLCA with status info
  during the execution of a SQL stmt.
NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************

  If the symbol SQLCA_STORAGE_CLASS is defined, then the SQLCA
  will be defined to have this storage class. For example:
 
    #define SQLCA_STORAGE_CLASS extern
 
  will define the SQLCA as an extern.
 
  If the symbol SQLCA_INIT is defined, then the SQLCA will be
  statically initialized. Although this is not necessary in order
  to use the SQLCA, it is a good pgming practice not to have
  unitialized variables. However, some C compilers/OS's don't
  allow automatic variables to be init'd in this manner. Therefore,
  if you are INCLUDE'ing the SQLCA in a place where it would be
  an automatic AND your C compiler/OS doesn't allow this style
  of initialization, then SQLCA_INIT should be left undefined --
  all others can define SQLCA_INIT if they wish.

  If the symbol SQLCA_NONE is defined, then the SQLCA variable will
  not be defined at all.  The symbol SQLCA_NONE should not be defined
  in source modules that have embedded SQL.  However, source modules
  that have no embedded SQL, but need to manipulate a sqlca struct
  passed in as a parameter, can set the SQLCA_NONE symbol to avoid
  creation of an extraneous sqlca variable.
 
MODIFIED
    lvbcheng   07/31/98 -  long to int
    jbasu      12/12/94 -  Bug 217878: note this is an SOSD file
    losborne   08/11/92 -  No sqlca var if SQLCA_NONE macro set 
  Clare      12/06/84 - Ch SQLCA to not be an extern.
  Clare      10/21/85 - Add initialization.
  Bradbury   01/05/86 - Only initialize when SQLCA_INIT set
  Clare      06/12/86 - Add SQLCA_STORAGE_CLASS option.
*/
 
#ifndef SQLCA
#define SQLCA 1
 
struct   sqlca
         {
         /* ub1 */ char    sqlcaid[8];
         /* b4  */ int     sqlabc;
         /* b4  */ int     sqlcode;
         struct
           {
           /* ub2 */ unsigned short sqlerrml;
           /* ub1 */ char           sqlerrmc[70];
           } sqlerrm;
         /* ub1 */ char    sqlerrp[8];
         /* b4  */ int     sqlerrd[6];
         /* ub1 */ char    sqlwarn[8];
         /* ub1 */ char    sqlext[8];
         };

#ifndef SQLCA_NONE 
#ifdef   SQLCA_STORAGE_CLASS
SQLCA_STORAGE_CLASS struct sqlca sqlca
#else
         struct sqlca sqlca
#endif
 
#ifdef  SQLCA_INIT
         = {
         {'S', 'Q', 'L', 'C', 'A', ' ', ' ', ' '},
         sizeof(struct sqlca),
         0,
         { 0, {0}},
         {'N', 'O', 'T', ' ', 'S', 'E', 'T', ' '},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0}
         }
#endif
         ;
#endif
 
#endif
 
/* end SQLCA */
/* EXEC SQL INCLUDE SQLDA.H;
 */ 
/*
 * $Header: sqlda.h 31-jul-99.19:34:41 apopat Exp $ sqlda.h 
 */

/***************************************************************
*      The SQLDA descriptor definition                         *
*--------------------------------------------------------------*
*      VAX/3B Version                                          *
*                                                              *
*  Copyright (c) 1987, 1997, 1998, 1999 by Oracle Corporation                    *
***************************************************************/


/* NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************
*/

/*  MODIFIED
    apopat     07/31/99 -  [707588] TAB to blanks for OCCS
    lvbcheng   10/27/98 -  change long to int for sqlda
    lvbcheng   08/15/97 -  Move sqlda protos to sqlcpr.h
    lvbcheng   06/25/97 -  Move sqlda protos to this file
    jbasu      01/29/95 -  correct typo
    jbasu      01/27/95 -  correct comment - ub2->sb2
    jbasu      12/12/94 - Bug 217878: note this is an SOSD file
    Morse      12/01/87 - undef L and S for v6 include files
    Richey     07/13/87 - change int defs to long 
    Clare      09/13/84 - Port: Ch types to match SQLLIB structs
    Clare      10/02/86 - Add ifndef SQLDA
*/

#ifndef SQLDA_
#define SQLDA_ 1
 
#ifdef T
# undef T
#endif
#ifdef F
# undef F
#endif

#ifdef S
# undef S
#endif
#ifdef L
# undef L
#endif
 
struct SQLDA {
  /* ub4    */ int        N; /* Descriptor size in number of entries        */
  /* text** */ char     **V; /* Ptr to Arr of addresses of main variables   */
  /* ub4*   */ int       *L; /* Ptr to Arr of lengths of buffers            */
  /* sb2*   */ short     *T; /* Ptr to Arr of types of buffers              */
  /* sb2**  */ short    **I; /* Ptr to Arr of addresses of indicator vars   */
  /* sb4    */ int        F; /* Number of variables found by DESCRIBE       */
  /* text** */ char     **S; /* Ptr to Arr of variable name pointers        */
  /* ub2*   */ short     *M; /* Ptr to Arr of max lengths of var. names     */
  /* ub2*   */ short     *C; /* Ptr to Arr of current lengths of var. names */
  /* text** */ char     **X; /* Ptr to Arr of ind. var. name pointers       */
  /* ub2*   */ short     *Y; /* Ptr to Arr of max lengths of ind. var. names */
  /* ub2*   */ short     *Z; /* Ptr to Arr of cur lengths of ind. var. names */
  };
 
typedef struct SQLDA SQLDA;
 
#endif

/* ----------------- */
/* defines for sqlda */
/* ----------------- */

#define SQLSQLDAAlloc(arg1, arg2, arg3, arg4) sqlaldt(arg1, arg2, arg3, arg4) 

#define SQLSQLDAFree(arg1, arg2) sqlclut(arg1, arg2) 





#include <winproc.h>

FILE *fp;
int  status_prn   = 0, pgm_flg  = 0,tst_cd_ind = 1;
int copy = 0;
int numeric_value_flag = FALSE;
int  MAX_LINES = 27;
int no_of_sensitivities = 0;

char file_name[150];
char extra_file_name[151];
char lab_file_name[151];
char prev_group_test [11],
     rl_curr_status  [4];

char local_legend[125][600];//added for globalisation

char footer_released_date[22];
char footer_released_date1[22];//added for globalisation

int rec_ctr = 0,lctr = 0,pctr = 0;
int something_to_print = 0;
int something_to_print_for_test = 0;
int spc_first = 0,    ind_test_prn   = 0;
int sleep_sec = 0;
int group_printed = 0;
int group = 0;
int test_printed = 0;
int test_result_found = 0;
char text_line[1000],text_line1[1000];
char test_description[41];

char string_var[1500];
char patient_id1[50];
char patient_id2[50];
char l_kb_mic_legend[500];

char l_mic_sign[100];  //added for AMS-CRF-0067 by krishnamoorthys

int qq = 0, cntr = 0, z = 0, hell = 0, clt = 0, cmp = 0, t_rue = 0;
char word1[2];

/****** ADDED FOR GTT SPECIMENS ************/
char l_should_print_yn = 'N';
char nd_test_code[11];
char d_interval_specimen_yn = 'N';

int l_snomed_head_printed = 0;
char l_numeric_result[30];
int l_print_anti_flag = 0;
char text_line_temp2[100];
int l_should_anti_flag = 0;
int l_anti_flag = 0;
int oflag = 1; // 01.08.2006
int org_yn = 0; 
int a_flag = 0; 
int antb_yn = 0; 
int b_flag = 0;

char g_facility_id[50];

int l_heading_printed1=0; //added for MO-CRF-20134
void proc_main(argc,argv)
int argc;
char *argv[];
{

   int i = 0, len = 0; 
   
   if (argc < 5)
   {
    int i = 0;
      printf("Not enough Parameters for running this program\n");
      printf("Exiting...\n\007\007\007");
      sprintf(string_var,"Usage : %s uid/password <patient_id> <spec.no> <L/W> \n",argv[0]);
	  disp_message(ERR_MESG, string_var);
      sprintf(string_var,"No of parameters passed is <%d>\n",argc);
	  disp_message(ERR_MESG, string_var);
      proc_exit();
   }

   strcpy(nd_operating_facility_id.arr,argv[5]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);
   
   strcpy(g_facility_id, nd_operating_facility_id.arr);

   strcpy(nd_hosp_no.arr,argv[6]);
   nd_hosp_no.len = strlen(argv[6]);
   
   strcpy(nd_spec_no.arr,argv[7]);
   nd_spec_no.len = strlen(argv[7]);
   
   flag = argv[8][0]; /* (K - WORKLIST)/(L - Lab Query) / (W - Ward Query) /(C - Confidential)*/

   strcpy(patient_id1, argv[9]);


   if (strcmp(patient_id1, nd_hosp_no.arr) != 0)
   {
	  len = strlen(patient_id1);
      for(i = 0; i < len; i++)
	  {

		if (patient_id1[i] != '`')
			patient_id2[i] = patient_id1[i];
		else
			patient_id2[i] = ' ';

	  }

	  i++;

	  patient_id2[i] = '\0';


	  strcpy(nd_hosp_no.arr, patient_id2);
	  nd_hosp_no.len = strlen(nd_hosp_no.arr);

   }

   if(sql_connect(argv[1]) == -1)
   {
      disp_message(ORA_MESG,"OERROR in connecting to Oracle\n");
      proc_exit();
   }
   
   set_meduser_role();


/********* This part added for globalisation ***************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
/********* This part added for globalisation ***************************/

   get_legend_value(95); //added for globalisation 


   strcpy(draft_printing_yn.arr, "N");
   draft_printing_yn.len = strlen(draft_printing_yn.arr);


///disp_message(ERR_MESG,"debug version");
   declare_curs();
//disp_message(ERR_MESG,"after declare curs()");
   gen_file_name();
//disp_message(ERR_MESG,"after gen_file_name()");

   process_rec();

   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 0;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
     err_mesg("ROLLBACK WORK RELEASE failed",0,"");

   return;
}

/*----------------------------------------------------------*/
process_rec()
{  int i = 0;
   int j = 0,corr_stat = 0;
   char test[11],group_test[11];
       lctr = 0;
       pctr = 0;
       rec_ctr = 0;
       copy = 0;

	  l_should_print_yn = 'N';
	  d_interval_specimen_yn = 'N';

	   strcpy(actual_specimen.arr, nd_spec_no.arr);
	   actual_specimen.len = strlen(actual_specimen.arr);
 	   strcpy(nd_status.arr, "P");
	   nd_status.len = strlen(nd_status.arr);
//disp_message(ERR_MESG,"in Process_rec() b4 build table");
	   build_table();
//disp_message(ERR_MESG,"in Process_rec() after build table");
	   build_cancelled_tests();

	   declare_tst_result_curs();
	   strcpy(nd_test_code, "");

	   something_to_print = 0;		
	   other_than_comments = 0;
	   get_mic_print_yn();
       get_test_desc_fill_char();  //// added on 30.09.2003

       open_hdr();
//disp_message(ERR_MESG,"in Process_rec() b4 if(fetch_hdr())");
       if(fetch_hdr())
         {
	     get_departmental_parameters();  /// 07.08.2004

		 get_customer_id(); /// added on 19.05.2015 against HSA-CRF-0298

		 get_user_conf_access_yn();  ///// 28.09.2006 added against SD CRF-20006. 

         fetch_other_dtls();
	//	if (strcmp(rl_customer_id.arr, "KDAH") == 0) 
	//	  print_header4();

          copy++;
		  open_tst_result_curs();
//           open_tst_result();
           strcpy(prev_group_test,"");

		   //strcpy(rl_tst_test_method_code_t.arr,"!!!!");
		   
		   strcpy(rl_tst_test_sub_sec_t.arr,"!!!!"); //added for GHL-CRF-0452-DD-01
		   
		   strcpy(rl_grp_tst_test_sub_sec_t.arr,"!!!!");//GHL-CRF-0489

           rec_ctr = 0;
           fflush(fp);

		   i = fetch_tst_result();
//disp_message(ERR_MESG,"in Process_rec() b4 while (i)");
           while (i)
           {
	
				group_printed = 0;
				group = 0;
		
				strcpy(group_test, rl_tst_group_test_code.arr);
				strcpy(test,rl_tst_test_code.arr);
				
				/// strcpy(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr);
			    

				if(strcmp(group_test,test) !=0)
					group = 1;

/******** added the below on 21.05.2005 *****************************/
						  
				check_profile_yn(rl_tst_group_test_code.arr);

				c_count_profile.arr[0]	='\0';
				c_count_profile.len		= 0; 

				if(rl_tst_cd_profile_yn.arr[0] == 'Y')
				{
					if(p_param8.arr[0] != 'P')  
					{
					  
						/* EXEC SQL SELECT COUNT(*)  
								 INTO	c_count_profile
								 FROM   RL_TEST_RESULT
								 WHERE  SPECIMEN_NO = TO_NUMBER(:nd_spec_no)
								 AND    OPERATING_FACILITY_ID = :nd_operating_facility_id
								 AND    GROUP_TEST_CODE = :rl_tst_group_test_code
								 AND   ( NVL(STATUS,'O') IN ('R','P')
													OR NVL(PRELIMINARY_RELEASE_YN,'N') = 'Y'); */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 4;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select count(*)  into :b0  from RL_TEST_RESULT where ((\
(SPECIMEN_NO=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and GROUP_TEST_CODE\
=:b3) and (NVL(STATUS,'O') in ('R','P') or NVL(PRELIMINARY_RELEASE_YN,'N')='Y'\
))";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )20;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&c_count_profile;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
      sqlstm.sqhstl[1] = (unsigned int  )23;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[2] = (unsigned int  )5;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
      sqlstm.sqhstl[3] = (unsigned int  )13;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

  // 22.08.2006

						if(NODATAFOUND);
						if (OERROR)
							  disp_message(ORA_MESG,"Failed at Select RL_TEST_RESULT in print_dtls()");

						c_count_profile.arr[c_count_profile.len] ='\0';
					}
					else 
					{
					   strcpy(c_count_profile.arr,"1");
					   c_count_profile.len =  strlen(c_count_profile.arr);
					}
				 }
				 else
				 {
					   strcpy(c_count_profile.arr,"1");
					   c_count_profile.len =  strlen(c_count_profile.arr);
				 }

				 
/*************************** upto here added on 21.05.2005 ******************/

				while(i && strcmp(group_test,rl_tst_group_test_code.arr)==0)
				{  
					test_printed = 0;
					rec_ctr ++;
//disp_message(ERR_MESG,"in Process_rec() b4 print_dtls()");
					print_dtls();
                    
					i = fetch_tst_result();
					

					other_than_comments = 0;

					#ifdef DEBUG
					   printf(" In process_rec(), rec_ctr = %d\n",rec_ctr);
					 #endif
				}
				
           }
		
		   
//		fclose(fp);


	   delete_rl_result_line();

	   if ((rec_ctr) && (something_to_print > 0))
	   {
		  
		  print_cancelled_tests();
		  
		  
		    /*added by madhusudhan for ml-mmoh-CRF-0332 */
								print_notify_details();
			/*added by madhusudhan for ml-mmoh-CRF-0332 */
		   
       // if (strcmp(rl_customer_id.arr, "KDAH") == 0) 
	//	  print_footer5(1);

		  fclose(fp); 

//		  delete_rl_result_line();
	      insert_rl_result_line();
	
		}
		else
			fclose(fp);

		delete_build_table();

     } 
}
/*------------------------------------------------------------*/
insert_rl_result_line()
{  

   int re_write = 1;

   if ((fp = fopen(nd_file_name.arr,"r")) == NULL)
   {
       sprintf(string_var,"OERROR while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG, string_var);
       proc_exit();
   }
   result_line_no = 0;

   while(fgets(result_line.arr,101,fp))
     {


	   result_line.len = strlen(result_line.arr) ;
	   
	   if((result_line.len) && (result_line.arr[0] != '\n'))
       {
	   
  	   result_status.arr[0] = result_line.arr[strlen(result_line.arr)-7];
	   result_tech_status.arr[0]  = result_line.arr[strlen(result_line.arr)-6];
       result_delta_status.arr[0] = result_line.arr[strlen(result_line.arr)-5];
       result_qlty_status.arr[0]  = result_line.arr[strlen(result_line.arr)-4];
       result_cmnt_status.arr[0]  = result_line.arr[strlen(result_line.arr)-3];
       result_path_status.arr[0]  = result_line.arr[strlen(result_line.arr)-2];
       result_status.len          = 1;
       result_tech_status.len     = 1;
       result_delta_status.len    = 1;
       result_qlty_status.len     = 1;
       result_cmnt_status.len     = 1;
       result_path_status.len     = 1;
  
       result_line_no++;
       #ifdef DEBUG
	     printf(" In insert_rl_result_line(), line_no = %d\n",
		    result_line_no);
       #endif
    
 
       /* EXEC SQL INSERT INTO RL_RESULT_LINE
		       (OPERATING_FACILITY_ID,USER_ID,SPECIMEN_NO,LINE_NO,TEXT,STATUS,
			TECH_STATUS,DELTA_STATUS,QLTY_STATUS,
			CMNT_STATUS,PATH_STATUS)
		VALUES (:nd_operating_facility_id,USER,to_number(:actual_specimen),
//		        :result_line_no,substr(:result_line,1,length(:result_line) - 7 ),
		        :result_line_no,substr(REPLACE(REPLACE(:result_line,CHR(9),' '),CHR(10),' '),1,length(:result_line) - 7 ),
	            :result_status, :result_tech_status, 
			    :result_delta_status, :result_qlty_status, 
			    :result_cmnt_status, :result_path_status); */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 11;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "insert into RL_RESULT_LINE (OPERATING_FACILITY_ID,USER\
_ID,SPECIMEN_NO,LINE_NO,TEXT,STATUS,TECH_STATUS,DELTA_STATUS,QLTY_STATUS,CMNT_\
STATUS,PATH_STATUS) values (:b0,USER,to_number(:b1),:b2,substr(REPLACE(REPLACE\
(:b3,CHR(9),' '),CHR(10),' '),1,(length(:b3)-7)),:b5,:b6,:b7,:b8,:b9,:b10)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )51;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
       sqlstm.sqhstl[0] = (unsigned int  )5;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&actual_specimen;
       sqlstm.sqhstl[1] = (unsigned int  )23;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&result_line_no;
       sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&result_line;
       sqlstm.sqhstl[3] = (unsigned int  )102;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&result_line;
       sqlstm.sqhstl[4] = (unsigned int  )102;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&result_status;
       sqlstm.sqhstl[5] = (unsigned int  )4;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&result_tech_status;
       sqlstm.sqhstl[6] = (unsigned int  )4;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&result_delta_status;
       sqlstm.sqhstl[7] = (unsigned int  )4;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&result_qlty_status;
       sqlstm.sqhstl[8] = (unsigned int  )4;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&result_cmnt_status;
       sqlstm.sqhstl[9] = (unsigned int  )4;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&result_path_status;
       sqlstm.sqhstl[10] = (unsigned int  )4;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




       result_line.arr[0]          = '\0';
       result_line.len             = 0;
       result_status.arr[0]        ='\0';
       result_status.len           = 0;
       result_tech_status.arr[0]   ='\0';
       result_tech_status.len      = 0;
       result_delta_status.arr[0]  ='\0';
       result_delta_status.len     = 0;
       result_qlty_status.arr[0]   ='\0';
       result_qlty_status.len      = 0;
       result_cmnt_status.arr[0]   ='\0';
       result_cmnt_status.len      = 0;
       result_path_status.arr[0]   ='\0';
       result_path_status.len      = 0;
	
       if (OERROR)
	      err_mesg("INSERT failed on table RL_RESULT_LINE",0,"");
	
		
       }

	   if (re_write < 2)
			re_write = re_write + 1;

     }       
	

   if (result_line_no)
     {

     /* EXEC SQL COMMIT WORK; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )110;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
         err_mesg("COMMIT failed on table RL_RESULT_LINE",0,"");

     }
   fclose(fp);
}

/*---------------------------------------------------------------------*/
print_group_test_desc()
{
   char group_result[16];
   /************** This line is newly added in KNDV enhancements ***********/
   group_result[0]		  = '\0';

   p_print_name_yn.arr[0] = '\0';
   p_test_desc.arr[0]     = '\0';
   p_function_yn.arr[0]   = '\0';
   p_test_units.arr[0]    = '\0';
   p_test_desc.len        = 0;
   p_print_name_yn.len    = 0;
   p_function_yn.len      = 0;
   p_test_units.len       = 0;
   p_significant_digit    = 0;
   p_no_of_decimals       = 0;

   /* EXEC SQL SELECT LONG_DESC,NVL(PRINT_NAME_YN,'N'),NVL(FUNCTION_YN,'N'),
		    SIGNIFICANT_DIGIT,NO_OF_DECIMALS	,TEST_UNITS    
	        INTO   :p_test_desc,:p_print_name_yn,:p_function_yn,
		           :p_significant_digit,:p_no_of_decimals,:p_test_units 
	        FROM   RL_TEST_CODE 
	        WHERE  TEST_CODE = :rl_tst_group_test_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC ,NVL(PRINT_NAME_YN,'N') ,NVL(FUNCTION_YN,\
'N') ,SIGNIFICANT_DIGIT ,NO_OF_DECIMALS ,TEST_UNITS into :b0,:b1,:b2,:b3,:b4,:\
b5  from RL_TEST_CODE where TEST_CODE=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )125;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&p_test_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_print_name_yn;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_function_yn;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&p_significant_digit;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&p_no_of_decimals;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&p_test_units;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&rl_tst_group_test_code;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
      err_mesg("Select failed on table RL_TEST_CODE in print_group_test_desc",
	       0,"");

   p_test_desc.arr[p_test_desc.len]         = '\0';
   p_print_name_yn.arr[p_print_name_yn.len] = '\0';
   p_function_yn.arr[p_function_yn.len]     = '\0';
   p_test_units.arr[p_test_units.len]       = '\0';

   if(p_function_yn.arr[0] == 'Y')
   {
      group_result[0] = '\0';
      calc_func_and_prn(rl_tst_group_test_code.arr,group_result);
   } 
   
   if(strlen(p_test_desc.arr) > 35)
      //p_test_desc.arr[35] = '\0'; //commented out for KDAH-SCF-0546
	  p_test_desc.arr[40] = '\0';//added for KDAH-SCF-0546

   p_print_name_yn.arr[p_print_name_yn.len]='\0';
   
   p_grp_status.arr[0]     = '\0';
   /* EXEC SQL SELECT NVL(RESULT_STATUS,'O') 
	    INTO   :p_grp_status
	    FROM   RL_REQUEST_DETAIL
	    WHERE  PATIENT_ID  = :nd_hosp_no 
	    AND    SPECIMEN_NO = :nd_spec_no 
		AND    OPERATING_FACILITY_ID = :nd_operating_facility_id
	    AND    TEST_CODE = :rl_tst_group_test_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(RESULT_STATUS,'O') into :b0  from RL_REQUEST_DE\
TAIL where (((PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b\
3) and TEST_CODE=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )168;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&p_grp_status;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&rl_tst_group_test_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
      err_mesg(
	  "Select failed on RL_REQUEST_DETAIL in print_group_test_desc", 0,"");

   p_grp_status.arr[p_grp_status.len] ='\0';

   if(strcmp(p_print_name_yn.arr,"Y")==0)
      //fprintf(fp,"%-37s",p_test_desc.arr); //commented out for KDAH-SCF-0546
	  fprintf(fp,"%-40s",p_test_desc.arr);//added for KDAH-SCF-0546

   if(p_function_yn.arr[0] == 'Y' && test_result_found == 1) 
      if(strlen(group_result))
      {
		  strcpy(r_rslt.arr, group_result);
		  r_rslt.len = strlen(r_rslt.arr);
		  add_zero_after_result();
		  strcpy(group_result, r_rslt.arr);

	 fprintf(fp,"%-10s",group_result);
	 if(p_test_units.len)
	    fprintf(fp,"%-10s",p_test_units.arr);
      }

   if(p_print_name_yn.arr[0] == 'Y' || strlen(group_result))
   {
      fprintf(fp,"%c     \n",p_grp_status.arr[0]);
      page_break(1);
   }

   if(strcmp(p_print_name_yn.arr,"Y")==0)
   {
      //fprintf(fp,"-----------------------------------      \n");//commented out for KDAH-SCF-0546
	  fprintf(fp,"----------------------------------------      \n");//added for KDAH-SCF-0546
      page_break(1);
   } 
}
/*------------------------------------------------------------*/
calc_func_and_prn(l_str,l_str2)
char l_str[],l_str2[];
{
   int func_ctr = 0;

   strcpy(rl_loc_test_code.arr,l_str);
   rl_loc_test_code.len = strlen(rl_loc_test_code.arr);
   open_function_cur();
   strcpy(rl_func_str.arr,"");
   while (fetch_function_cur())
   {
        func_ctr ++;
        strcpy(rl_func_value.arr,rl_func_operand_1.arr);
        test_result_found = 1;
        if (rl_func_operand_1_type.arr[0] == 'T')
             get_rl_test_result(rl_func_operand_1.arr);

	if(test_result_found == 0)
	{
	   l_str2[0] = '\0'; 
	   break;
        }
        strcat(rl_func_str.arr,rl_func_value.arr);
        strcat(rl_func_str.arr," ");

        if (func_ctr != 1)
             calculate_value();

        if (rl_func_operator_1.len == 0)
             break;

        strcat(rl_func_str.arr,rl_func_operator_1.arr);
        strcat(rl_func_str.arr," ");
        strcpy(rl_func_value.arr,rl_func_operand_2.arr);

        test_result_found = 1;

        if (rl_func_operand_2_type.arr[0] == 'T')
             get_rl_test_result(rl_func_operand_2.arr);

	if(test_result_found == 0)
	{
	   l_str2[0] = '\0'; 
	   break;
        }

        strcat(rl_func_str.arr,rl_func_value.arr);
        strcat(rl_func_str.arr," ");
        calculate_value();

        if (rl_func_operator_2.len == 0)
             break;

        strcat(rl_func_str.arr,rl_func_operator_2.arr);
        strcat(rl_func_str.arr," ");
   }
   ltrim(rl_func_str.arr); 
   rtrim(rl_func_str.arr); 
   
   rl_func_str.arr[9] = '\0';
   if (rl_tst_cd_no_of_decimals != 0 ||
             rl_tst_cd_significant_digit != 0)
      get_deci_sig_dig(rl_func_str.arr, p_no_of_decimals, p_significant_digit);
   rl_func_str.arr[5] = '\0';
   sprintf(l_str2,"%-10s",rl_func_str.arr);
#ifdef DEBUG
    printf("func str is <%s> str is <%s>\n",rl_func_str.arr,l_str2);
#endif
}
/*--------------------------------------------------------------------*/
calculate_value()
{
    sprintf(rl_calc_str.arr,"SELECT %s FROM DUAL",rl_func_str.arr);
    rl_calc_str.len = strlen(rl_calc_str.arr);
    /* EXEC SQL PREPARE STR1 FROM :rl_calc_str; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )203;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_calc_str;
    sqlstm.sqhstl[0] = (unsigned int  )402;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("PREPARE failed on table DUAL");

    /* EXEC SQL DECLARE CUR1 CURSOR FOR STR1; */ 


    /* EXEC SQL OPEN CUR1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )222;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor CUR1");

    rl_func_str.arr[0] = '\0';
    rl_func_str.len    = 0;

    /* EXEC SQL FETCH CUR1
              INTO :rl_func_str; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )237;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_func_str;
    sqlstm.sqhstl[0] = (unsigned int  )402;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("FETCH failed on cursor CUR1");

    rl_func_str.arr[rl_func_str.len] = '\0';
    strcat(rl_func_str.arr," ");
}
/*------------------------------------------------------------*/
get_deci_sig_dig(loc_str,no_of_dec,signif)
                 char *loc_str;
                 int no_of_dec,signif;
{
  char significant_digits_applied_yn = 'N';
  d_dec_pos = 0;
  d_after_sig_digit = 0;  

  d_loc_str.arr[0] = '\0';
  d_dec_part.arr[0] = '\0';
  d_int_part.arr[0] = '\0';
  d_sig_part.arr[0] = '\0';

  d_loc_str.len     = 0;
  d_dec_part.len    = 0;
  d_int_part.len    = 0;
  d_sig_part.len    = 0;

  strcpy(d_loc_str.arr,loc_str);
  d_loc_str.len = strlen(d_loc_str.arr);
#ifdef DEBUG
  printf("get_deci_sig_dig() loc_str %s d_loc_str %s\n",loc_str,d_loc_str.arr);
  getchar();
  printf("signif = %d no_of_dec = %d \n",signif,no_of_dec);getchar();
#endif
/*--- The following IF splits the result into two parts : INTEGER & DECIMAL --*/
  /* EXEC SQL SELECT INSTR(:d_loc_str,'.') INTO :d_dec_pos FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select INSTR(:b0,'.') into :b1  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )256;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_loc_str;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_dec_pos;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


#ifdef DEBUG
   printf("dec pos = %d\n",d_dec_pos);getchar();
#endif
  if(d_dec_pos > 0)
  {
      /* EXEC SQL SELECT SUBSTR(:d_loc_str,1,:d_dec_pos - 1) 
		 INTO :d_int_part
		 FROM DUAL; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 11;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select SUBSTR(:b0,1,(:b1-1)) into :b2  from DUAL ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )279;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_loc_str;
      sqlstm.sqhstl[0] = (unsigned int  )22;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_dec_pos;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_int_part;
      sqlstm.sqhstl[2] = (unsigned int  )22;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      d_int_part.arr[d_int_part.len] = '\0';

      if(strlen(d_loc_str.arr) > d_dec_pos )
      {
         /* EXEC SQL SELECT SUBSTR(:d_loc_str,:d_dec_pos + 1,LENGTH(:d_loc_str)) 
	  	    INTO :d_dec_part
		    FROM DUAL; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 11;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select SUBSTR(:b0,(:b1+1),LENGTH(:b0)) into :b3  fro\
m DUAL ";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )306;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&d_loc_str;
         sqlstm.sqhstl[0] = (unsigned int  )22;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&d_dec_pos;
         sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&d_loc_str;
         sqlstm.sqhstl[2] = (unsigned int  )22;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&d_dec_part;
         sqlstm.sqhstl[3] = (unsigned int  )22;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqphsv = sqlstm.sqhstv;
         sqlstm.sqphsl = sqlstm.sqhstl;
         sqlstm.sqphss = sqlstm.sqhsts;
         sqlstm.sqpind = sqlstm.sqindv;
         sqlstm.sqpins = sqlstm.sqinds;
         sqlstm.sqparm = sqlstm.sqharm;
         sqlstm.sqparc = sqlstm.sqharc;
         sqlstm.sqpadto = sqlstm.sqadto;
         sqlstm.sqptdso = sqlstm.sqtdso;
         sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


         d_dec_part.arr[d_dec_part.len] = '\0';
      }
#ifdef DEBUG
   printf("int_part = %s dec_part = %s \n",d_int_part.arr,d_dec_part.arr);
   getchar();
#endif
  }
  else
  {
     strcpy(d_int_part.arr,d_loc_str.arr);
     d_int_part.len = strlen(d_int_part.arr);
  }
/*-- This IF is to take care of the INTEGER part of the Result ---------------*/
  if(strlen(d_int_part.arr))
  {
    if(signif > 0)
    {
       if(strlen(d_int_part.arr) <= signif)
       {
          strcpy(d_l_str.arr,d_int_part.arr);
       }
       else
       {
	  significant_digits_applied_yn = 'Y';
	  /* EXEC SQL SELECT SUBSTR(:d_int_part,1,:p_significant_digit)
		     INTO :d_sig_part
		     FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(:b0,1,:b1) into :b2  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )337;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_int_part;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_significant_digit;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sig_part;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


          d_sig_part.arr[d_sig_part.len] = '\0';
#ifdef DEBUG
   printf("d_sig_part (1) = %s\n",d_sig_part.arr);getchar();
#endif
	  /* EXEC SQL SELECT SUBSTR(:d_int_part,:p_significant_digit + 1,1) 
		     INTO :d_after_sig_digit FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(:b0,(:b1+1),1) into :b2  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )364;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_int_part;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_significant_digit;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_after_sig_digit;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


#ifdef DEBUG
   printf("d_after_sig_digit = %d \n",d_after_sig_digit);getchar();
#endif
	  if(d_after_sig_digit >= 5)
	  {
	     /* EXEC SQL SELECT TO_CHAR(TO_NUMBER(:d_sig_part) + 1)
			INTO :d_sig_part FROM DUAL; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 11;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select TO_CHAR((TO_NUMBER(:b0)+1)) into :b0  from DUAL ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )391;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_sig_part;
      sqlstm.sqhstl[0] = (unsigned int  )22;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_sig_part;
      sqlstm.sqhstl[1] = (unsigned int  )22;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


             d_sig_part.arr[d_sig_part.len] = '\0'; 
#ifdef DEBUG
   printf("d_sig_part (2) = %s\n",d_sig_part.arr);getchar();
#endif
          }
	  if(d_after_sig_digit == 9)
	  {
             /* EXEC SQL SELECT RPAD(:d_sig_part,LENGTH(:d_int_part)+1,'0')
	   	        INTO :d_l_str FROM DUAL; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 10;
             sqlstm.arrsiz = 11;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = "select RPAD(:b0,(LENGTH(:b1)+1),'0') into :b2  f\
rom DUAL ";
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )414;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)256;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqhstv[0] = (         void  *)&d_sig_part;
             sqlstm.sqhstl[0] = (unsigned int  )22;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_int_part;
             sqlstm.sqhstl[1] = (unsigned int  )22;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_l_str;
             sqlstm.sqhstl[2] = (unsigned int  )22;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqphsv = sqlstm.sqhstv;
             sqlstm.sqphsl = sqlstm.sqhstl;
             sqlstm.sqphss = sqlstm.sqhsts;
             sqlstm.sqpind = sqlstm.sqindv;
             sqlstm.sqpins = sqlstm.sqinds;
             sqlstm.sqparm = sqlstm.sqharm;
             sqlstm.sqparc = sqlstm.sqharc;
             sqlstm.sqpadto = sqlstm.sqadto;
             sqlstm.sqptdso = sqlstm.sqtdso;
             sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


             d_l_str.arr[d_l_str.len] = '\0'; 
	     if(d_l_str.len > 5)
	     {
		strcpy(d_l_str.arr,loc_str);
		d_l_str.len = strlen(d_l_str.arr);
             }
          }
	  else
	  {
             /* EXEC SQL SELECT RPAD(:d_sig_part,LENGTH(:d_int_part),'0')
	   	        INTO :d_l_str FROM DUAL; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 10;
             sqlstm.arrsiz = 11;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = "select RPAD(:b0,LENGTH(:b1),'0') into :b2  from \
DUAL ";
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )441;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)256;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqhstv[0] = (         void  *)&d_sig_part;
             sqlstm.sqhstl[0] = (unsigned int  )22;
             sqlstm.sqhsts[0] = (         int  )0;
             sqlstm.sqindv[0] = (         void  *)0;
             sqlstm.sqinds[0] = (         int  )0;
             sqlstm.sqharm[0] = (unsigned int  )0;
             sqlstm.sqadto[0] = (unsigned short )0;
             sqlstm.sqtdso[0] = (unsigned short )0;
             sqlstm.sqhstv[1] = (         void  *)&d_int_part;
             sqlstm.sqhstl[1] = (unsigned int  )22;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&d_l_str;
             sqlstm.sqhstl[2] = (unsigned int  )22;
             sqlstm.sqhsts[2] = (         int  )0;
             sqlstm.sqindv[2] = (         void  *)0;
             sqlstm.sqinds[2] = (         int  )0;
             sqlstm.sqharm[2] = (unsigned int  )0;
             sqlstm.sqadto[2] = (unsigned short )0;
             sqlstm.sqtdso[2] = (unsigned short )0;
             sqlstm.sqphsv = sqlstm.sqhstv;
             sqlstm.sqphsl = sqlstm.sqhstl;
             sqlstm.sqphss = sqlstm.sqhsts;
             sqlstm.sqpind = sqlstm.sqindv;
             sqlstm.sqpins = sqlstm.sqinds;
             sqlstm.sqparm = sqlstm.sqharm;
             sqlstm.sqparc = sqlstm.sqharc;
             sqlstm.sqpadto = sqlstm.sqadto;
             sqlstm.sqptdso = sqlstm.sqtdso;
             sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


          }
          d_l_str.arr[d_l_str.len] = '\0'; 
       }
    }
    else
    {
       strcpy(d_l_str.arr,d_int_part.arr);
    }
  }         
/*-- This IF is to take care of the DECIMAL part of the Result ---------------*/
if(strlen(d_dec_part.arr) && significant_digits_applied_yn == 'N')
{
  if(no_of_dec > 0)
  {
     strcpy(d_l_str.arr,strcat(d_l_str.arr,"."));
     d_l_str.len = strlen(d_l_str.arr);
     if(strlen(d_dec_part.arr) <= no_of_dec) 
     {
        strcpy(d_l_str.arr,strcat(d_l_str.arr,d_dec_part.arr));
	d_l_str.len = strlen(d_l_str.arr);
     }
     else
     {
        /* EXEC SQL SELECT :d_l_str || SUBSTR(:d_dec_part,1,:p_no_of_decimals)
                   INTO :d_l_str FROM DUAL; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 11;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select (:b0||SUBSTR(:b1,1,:b2)) into :b0  from DUAL ";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )468;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_l_str;
        sqlstm.sqhstl[0] = (unsigned int  )22;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_dec_part;
        sqlstm.sqhstl[1] = (unsigned int  )22;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&p_no_of_decimals;
        sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_l_str;
        sqlstm.sqhstl[3] = (unsigned int  )22;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        d_l_str.arr[d_l_str.len] = '\0';
     }
  }
}
#ifdef DEBUG
   printf("d_l_str = %s\n",d_l_str.arr);getchar();
#endif
  strcpy(loc_str,d_l_str.arr);
}
/*------------------------------------------------------------*/
sql_connect(l_nd_ap_uid_pwd)
char l_nd_ap_uid_pwd[];
{
  strcpy(uid_pwd.arr,l_nd_ap_uid_pwd);
  uid_pwd.len = strlen(uid_pwd.arr);

  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )499;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )134;
  sqlstm.sqhsts[0] = (         int  )134;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}
/*-----------------------------------------------------*/
declare_curs()
{
    /* EXEC SQL DECLARE RL_REQ_HDR_CUR CURSOR FOR
              SELECT SOURCE_CODE,
                     CONSULTANT_CODE,
                     TO_CHAR(SPEC_RECD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
                     TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
                     TO_CHAR(SPEC_COLLTD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
					 order_id, 
					 RELEASED_BY_ID,
					 TO_CHAR(RELEASED_DATE,'DD/MM/YYYY HH24:MI'),
                     TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                     SECTION_CODE,
                     REQUEST_COMMENT_CODE1,
                     REQUEST_COMMENT_CODE2,
                     REQUEST_COMMENT_CODE3,
                     REQUEST_COMMENT_DESC1,
                     REQUEST_COMMENT_DESC2,
                     REQUEST_COMMENT_DESC3,
                     EXTRA_COPIES_TO,
                     SPECIMEN_TYPE_CODE,
                     ADDED_BY_ID,
                     TO_CHAR(ADDED_DATE,'DD/MM/YYYY HH24:MI'),
                     MODIFIED_BY_ID,
                     TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI'),
		     URGENT_INDICATOR,
		     EPISODE_TYPE,
					ordered_facility_id
                FROM RL_REQUEST_HEADER
               WHERE PATIENT_ID = :nd_hosp_no
                 AND SPECIMEN_NO = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

			/*added by madhusudhan for gdoh-crf-0107*/	 
	/* EXEC SQL DECLARE RL_NOTIFY_TYPE_CUR CURSOR FOR
									SELECT  nvl(NOTIFY_BY ,' '),
											NVL(NOTIFY_TO ,' '),
											TO_CHAR(NOTIFY_DATE_TIME,'DD/MM/YYYY HH24:MI'),
											NVL(NOTIFY_TEXT ,' ') 
									FROM  RL_NOTIFY_DETAILS 
									where PATIENT_ID = :nd_hosp_no
                                    AND SPECIMEN_NO = :actual_specimen
				                    AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

									
									
/***************** INCLUDED AS DYNAMIC SQL FOR GTT INTERVAL TESTS ****

    EXEC SQL DECLARE RL_TEST_RESULT_CUR CURSOR FOR
              SELECT GROUP_TEST_CODE,
                     TEST_CODE,
                     NVL(NUMERIC_PREFIX,'+'),
                     NUMERIC_RESULT,
                     RESULT_COMMENT_DESC1,
                     RESULT_COMMENT_DESC2,
                     RESULT_COMMENT_DESC3,
                     RESULT_COMMENT_DESC4,
					 NVL(STATUS,'O'),
					 NVL(TECH_STATUS,'*'),
					 NVL(DELTA_STATUS,'*'),
					 NVL(QLTY_STATUS,'*'),
					 NVL(CMNT_STATUS,'*'),
					 NVL(PATH_STATUS,'*'),
					 TEST_UNITS,
					 TEST_REF_RANGE_COMMENT,
					 AGE_RANGE_LOW,
					 AGE_RANGE_HIGH,
                     ROWID,
					 NVL(HIDE_RESULT_COMMENTS_YN,'N')
                FROM RL_TEST_RESULT
               WHERE PATIENT_ID = :nd_hosp_no
                 AND SPECIMEN_NO = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND GROUP_TEST_CODE IN
		 (
              SELECT TEST_CODE
                FROM RL_REQUEST_DETAIL
               WHERE PATIENT_ID = :nd_hosp_no
                 AND SPECIMEN_NO = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND ( 
				       (:flag IN ('W','C') AND NVL(RESULT_STATUS,'O') IN ('R','P'))
				       OR
					   (:flag IN ('L', 'K'))
					 )
		 )
               ORDER BY GROUP_SEQ_NO,TEST_SEQ_NO;
***************************/

    /* EXEC SQL DECLARE RL_FUNCTION_CUR CURSOR FOR
              SELECT OPERAND_1,
                     OPERAND_1_TYPE,
                     OPERATOR_1,
                     OPERAND_2,
                     OPERAND_2_TYPE,
                     OPERATOR_2
                FROM RL_FUNCTION
               WHERE TEST_CODE       = :rl_loc_test_code
               ORDER BY SEQ_NUMBER; */ 

    
    /* EXEC SQL DECLARE RL_SPECIMEN_TYPE_CODE_CUR CURSOR FOR
              SELECT SPECIMEN_DESC
                FROM RL_SPECIMEN_TYPE_CODE
               WHERE SPECIMEN_TYPE_CODE = :rl_hdr_specimen_type_code; */ 


    /* EXEC SQL DECLARE RL_SECTION_CUR CURSOR FOR
              SELECT LONG_NAME
                FROM RL_SECTION_CODE
               WHERE SECTION_CODE = :rl_hdr_section_code; */ 


    /* EXEC SQL DECLARE RL_TEST_CODE_CUR CURSOR FOR
              SELECT LONG_DESC,
                     NUMERIC_RESULT_YN,
                     AGE_SEX_RANGE_YN,
                     FUNCTION_YN,
                     PRINT_NAME_YN,
                     LOW_VALUE_NORMAL,
                     HIGH_VALUE_NORMAL,
                     GROUP_TEST_YN,
                     TEXT_BLOCK_YN,
                     CULTURE_TEST_YN,
                     SNOMED_YN,
					 TEST_UNITS, 
                     NVL(NO_OF_DECIMALS,0),
                     NVL(SIGNIFICANT_DIGIT,0),
                     REF_RANGE_COMMENT,
					 NVL(CONFIDENTIAL_YN, 'N'),
					 NVL(inhibit_report_yn, 'N')
                FROM RL_TEST_CODE
               WHERE TEST_CODE = :rl_loc_test_code; */ 

//                 AND NVL(INHIBIT_REPORT_YN, 'N') = 'N';

    /* EXEC SQL DECLARE RL_AGE_SEX_RANGE_CUR CURSOR FOR
              SELECT NVL(physician_age_low_value, LOW_VALUE_NORMAL),
                     NVL(physician_age_high_value, HIGH_VALUE_NORMAL)
                FROM RL_AGE_SEX_RANGE
               WHERE TEST_CODE = :rl_tst_test_code
                 AND SEX       = :rl_pat_sex
                 AND :rl_pat_dob_no_of_days
                       BETWEEN CALC_MIN_AGE_IN_DAYS  AND 
                          CALC_MAX_AGE_IN_DAYS; */ 


    /* EXEC SQL DECLARE RL_COMM_FOR_TEST_CUR CURSOR FOR
              SELECT COMMENT_TEXT
                FROM RL_COMMENTS_FOR_TEST
               WHERE TEST_CODE = :rl_tst_test_code
	    ORDER BY SEQ_NO; */ 


    /* EXEC SQL DECLARE RL_RESULT_TEXT_CUR CURSOR FOR
              SELECT RESULT_TEXT,  RESULT_TEXT_CODE, NVL(print_desc_in_report_yn, 'N'),
			NVL(print_desc_in_bold_yn, 'N'), NVL(print_desc_underlined_yn, 'N')
                FROM RL_RESULT_TEXT
               WHERE PATIENT_ID     = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
				 AND ( 
				       (:flag IN ('W','C') AND NVL(hide_text_yn,'N') NOT IN ('Y'))
				       OR
					   (:flag IN ('L', 'K'))
					 )
            ORDER BY SERIAL_NO; */ 

			
	// added the code for MO-CRF-20134
	/* EXEC SQL DECLARE RL_BIO_RESULT_TEXT_CUR CURSOR FOR
	      select result_text rl_res_result_text, result_text_code,
		 TEST_CODE ,ORGANISM_CODE,B_GROUP_TEST_CODE,B_TEST_CODE
			from RL_ORGANISM_TESTS_RESULT_TEXT 
            WHERE patient_id = :nd_hosp_no
              AND specimen_no = :nd_spec_no
              AND group_test_code = :rl_tst_group_test_code
              AND test_code = :rl_tst_test_code
              AND NVL (hide_text_yn, 'N') <> 'Y'
         ORDER BY LINE_no; */ 

		 
	/* EXEC SQL DECLARE RL_BIO_RESULT_COMMENT_CUR CURSOR FOR
	      select TEST_CODE ,ORGANISM_CODE,B_GROUP_TEST_CODE,B_TEST_CODE,
		  RESULT_COMMENT_CODE1,RESULT_COMMENT_DESC1
			from RL_RESULT_ORGANISM_TESTS_DTL 
            WHERE patient_id = :nd_hosp_no
              AND specimen_no = :nd_spec_no
              AND group_test_code = :rl_tst_group_test_code
              AND test_code = :rl_tst_test_code
			  AND( RESULT_COMMENT_CODE1 IS NOT NULL OR RESULT_COMMENT_DESC1 IS NOT NULL)
              ORDER BY LINE_no; */ 

	
	//


/// added the below cursor on 25.05.2004

    /* EXEC SQL DECLARE RL_RESULT_MODIFY_REASON_CUR CURSOR FOR
              SELECT REMARK_CODE,REMARK_TEXT,RELEASED_BY,
					 TO_CHAR(RELEASED_DATE,'DD/MM/YY HH24:MI'),
					 NUMERIC_PREFIX,NUMERIC_RESULT,  ////06.03.2006
					 NVL(MODIFY_COMPONENTS_IND,'!!!!'),
					 INSTR(NVL(MODIFY_COMPONENTS_IND,'!!!!'),'NM')
                FROM RL_RESULT_MODIFY_REASON
               WHERE SPECIMEN_NO     = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND PATIENT_ID     = :nd_hosp_no
				 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
            ORDER BY MODIFY_LOG_SEQ_NO desc; */ 



    /* EXEC SQL DECLARE RL_TEST_RESULT_CUR2 CURSOR FOR
              SELECT NUMERIC_RESULT
                FROM RL_TEST_RESULT
               WHERE PATIENT_ID     = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND TEST_CODE       = :rl_loc_test_code; */ 


    /* EXEC SQL DECLARE RL_RESULT_SNOMED_CUR CURSOR FOR
              SELECT A.SNOMED_CODE, A.snomed_code_2,SNOMED_MARKER_CODE_1,SNOMED_MARKER_CODE_2
                FROM RL_RESULT_SNOMED A
               WHERE A.PATIENT_ID     = :nd_hosp_no
                 AND A.SPECIMEN_NO     = :nd_spec_no
				 AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND A.GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND A.TEST_CODE       = :rl_tst_test_code
	       ORDER BY SNOMED_CODE; */ 


/********************* CHANGD ON 01/09/2002

                     DESCRIPTION_2,
                     DESCRIPTION_3,
                     DESCRIPTION_4,
                     DESCRIPTION_5,
***************************************/
    /* EXEC SQL DECLARE RL_SNOMED_CODE_CUR CURSOR FOR
              SELECT SUBSTR(DESCRIPTION_1, 1, 12),
					 NVL(PRINT_YN, 'N'),
					 NVL(print_code_yn, 'N')
                FROM RL_SNOMED_CODE
               WHERE SNOMED_CODE = :rl_res_snomed_code; */ 


    /* EXEC SQL DECLARE RL_RESULT_ORGANISM_CUR CURSOR FOR
              SELECT ORGANISM_CODE,
                     RESULT_COMMENT_DESC,
					 NVL(HIDE_ORGANISM_YN,'N'),   /oAdded for CRF20281 by srinivaso/
					 SEQ_FOR_DUP_ORG /oadded for MO-CRF-20128o/
                FROM RL_RESULT_ORGANISM
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
				 AND ( 
				       (:flag IN ('W','C') AND NVL(hide_organism_yn,'N') NOT IN ('Y'))
				       OR
					   (:flag IN ('L', 'K'))
					 )
				 ORDER BY ORGANISM_CODE; */ 
 /////    08.10.2003

    /* EXEC SQL DECLARE RL_ANTIBIOTIC_CUR CURSOR FOR 
              SELECT DISTINCT ANTIBIOTIC_CODE
                FROM RL_RESULT_ORGANISM_DTL
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
                 AND (REPORT_YN       = 'Y' OR :flag IN ('L', 'K'))
				 AND (SENSITIVITY_IND IN('S','R','I','D') OR :flag IN ('L', 'K') ) //added D for ml-mmoh-crf-0576
				 AND  SENSITIVITY_IND IS NOT NULL  ///26.03.2006
			   ORDER BY ANTIBIOTIC_CODE; */ 


    /* EXEC SQL DECLARE RL_SENSITIVITY_CUR CURSOR FOR
              SELECT ORGANISM_CODE,
					 ANTIBIOTIC_CODE,
                     SENSITIVITY_IND,
					 REPORT_YN,
					 trim(MIC_RESULT) MIC_RESULT,  //// MIC_RESULT,
					 zone_size,
					 NVL(PRINT_MIC_VALUE_YN,'N') PRINT_MIC_VALUE_YN  //////added on 03.12.2012 against BRU-HIMS-CRF-0050
                FROM RL_RESULT_ORGANISM_DTL
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
                 AND (REPORT_YN       = 'Y' OR :flag IN ('L', 'K'))
			     AND (SENSITIVITY_IND IN('S','R','I','D') OR :flag IN ('L', 'K') ) //added D for ml-mmoh-crf-0576
				 AND  SENSITIVITY_IND IS NOT NULL  ///26.03.2006
               ORDER BY ANTIBIOTIC_CODE, ORGANISM_CODE; */ 


    /* EXEC SQL DECLARE RL_SENSITIVITY_CUR_FORMAT4 CURSOR FOR
              SELECT ANTIBIOTIC_CODE,
                     SENSITIVITY_IND,
					 REPORT_YN,
					 trim(MIC_RESULT) MIC_RESULT,
					 MIC_SIGN,//added the code for AMS-CRF-0067 by krishnamoorthys
					 zone_size,
					 NVL(PRINT_MIC_VALUE_YN,'N') PRINT_MIC_VALUE_YN,  ///////added on 03.12.2012 against BRU-HIMS-CRF-0050
					 SEQ_FOR_DUP_ORG //added for MO-CRF-20128
                FROM RL_RESULT_ORGANISM_DTL
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
				 AND ORGANISM_CODE   = :rl_res_organism_code
                 AND (REPORT_YN       = 'Y' OR :flag IN ('L', 'K'))
			     AND (SENSITIVITY_IND IN('S','R','I','D') OR :flag IN ('L', 'K') ) //added D for ml-mmoh-crf-0576
				 AND  SENSITIVITY_IND IS NOT NULL  ///26.03.2006
				 AND  SEQ_FOR_DUP_ORG=:l_org_seq_no //added for MO-CRF-20128
               ORDER BY SEQ_FOR_DUP_ORG,seq_no; */ 
 //added SEQ_FOR_DUP_ORG for MO-CRF-20128

    /* EXEC SQL DECLARE RL_ORGANISM_CODE_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM RL_ORGANISM_CODE
               WHERE ORGANISM_CODE = :rl_res_organism_code; */ 


    /* EXEC SQL DECLARE RL_ANTIBIOTIC_CODE_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM RL_ANTIBIOTIC_CODE
               WHERE ANTIBIOTIC_CODE = :rl_res_dtl_antibiotic_code; */ 

			   
	//added for MO-CRF-20134
	
	/* EXEC SQL DECLARE RL_BIO_ORGANISM_CODE_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM RL_ORGANISM_CODE
               WHERE ORGANISM_CODE = :rl_bio_organism_code; */ 

			   
	/* EXEC SQL DECLARE RL_BIO_ORGANISM_CODE_CUR1 CURSOR FOR
              SELECT LONG_DESC
                FROM RL_ORGANISM_CODE
               WHERE ORGANISM_CODE = :rl_bio_organism_code1; */ 

			   
	/* EXEC SQL DECLARE RL_BIO_TEST_CODE_CUR CURSOR FOR
              SELECT LONG_DESC,nvl(GROUP_TEST_YN,'N')
                FROM RL_TEST_CODE
               WHERE TEST_CODE = :rl_b_grp_test_code; */ 

	
	/* EXEC SQL DECLARE RL_BIO_IND_TEST_CODE_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM RL_TEST_CODE
               WHERE TEST_CODE = :rl_b_test_code; */ 

	//end MO-CRF-20134
	

 								
}

/*-----------------------------------------------------*/
gen_file_name()
{
     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
     sprintf(nd_file_name.arr,"%srlilbres.lis", WORKING_DIR);
	 nd_file_name.len = strlen(nd_file_name.arr);

     if ((fp = fopen(nd_file_name.arr,"w")) == NULL)
     {
       disp_message(ERR_MESG,"Error while opening file \n");
       proc_exit();
     }

}
/*-----------------------------------------------------*/
close_sensitivity_cur_format4()
{
	/* EXEC SQL CLOSE RL_SENSITIVITY_CUR_FORMAT4; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )530;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		disp_message(ERR_MESG,"CLOSE failed on cursor RL_SENSITIVITY_CUR_FORMAT4");

}
/*-----------------------------------------------------*/
close_organism_cur()
{
	/* EXEC SQL CLOSE RL_RESULT_ORGANISM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )545;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		disp_message(ERR_MESG,"CLOSE failed on cursor RL_RESULT_ORGANISM_CUR");

}

/*-----------------------------------------------------*/


/********************************* added by madhu for crf -0332 ***************************/
close_notify_type()
{
    /* EXEC SQL CLOSE RL_NOTIFY_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )560;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("CLOSE failed on cursor RL_NOTIFY_TYPE_CUR",0,"");
}


open_notify_type()
{	
    /* EXEC SQL OPEN RL_NOTIFY_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0019;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )575;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&actual_specimen;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_NOTIFY_TYPE_CUR",0,"");
}


fetch_notify_type()
{
    RL_NOTIFY_BY.arr[0]             = '\0';
    RL_NOTIFY_TEXT.arr[0]			= '\0';
	RL_NOTIFY_TO.arr[0]			    = '\0';
	RL_NOTIFY_DATE_TIME1.arr[0]		= '\0';
	RL_NOTIFY_BY.len				= 0;
	RL_NOTIFY_TO.len				= 0;
	RL_NOTIFY_DATE_TIME1.len         = 0;
	RL_NOTIFY_TEXT.len              = 0;
  
    /* EXEC SQL FETCH RL_NOTIFY_TYPE_CUR
              INTO :RL_NOTIFY_BY ,
	:RL_NOTIFY_TO,
	:RL_NOTIFY_DATE_TIME1 ,
	:RL_NOTIFY_TEXT ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )602;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&RL_NOTIFY_BY;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&RL_NOTIFY_TO;
    sqlstm.sqhstl[1] = (unsigned int  )32;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&RL_NOTIFY_DATE_TIME1;
    sqlstm.sqhstl[2] = (unsigned int  )32;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&RL_NOTIFY_TEXT;
    sqlstm.sqhstl[3] = (unsigned int  )2002;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			
    if (OERROR)
        ins_message(ORA_MESG,"FETCH failed on cursor RL_NOTIFY_TYPE_CUR");
	
	RL_NOTIFY_BY.arr[RL_NOTIFY_BY.len]							= '\0';
	RL_NOTIFY_TO.arr[RL_NOTIFY_TO.len]							= '\0';
	RL_NOTIFY_DATE_TIME1.arr[RL_NOTIFY_DATE_TIME1.len]			= '\0';
	RL_NOTIFY_TEXT.arr[RL_NOTIFY_TEXT.len]						= '\0';
	

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
print_notify_details()
{
	
	if (strcmp(rl_print_notify_yn.arr, "Y") == 0)
    {
		  splitting1();
	  page_break(1);
	}
}

splitting1()
{
    int fetch_notify_type();
	char word[2];
	char l_str[100];
	char w_flag ;
	
    l_str[0] = '\0'; 
   
				/* EXEC SQL 
					SELECT COUNT(*) 
					INTO	c_count_notify
					FROM  RL_NOTIFY_DETAILS 
					where PATIENT_ID = :nd_hosp_no
					AND SPECIMEN_NO = :actual_specimen
					AND OPERATING_FACILITY_ID = :nd_operating_facility_id
					order by NOTIFY_DATE_TIME; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from RL_NOTIFY_DETAILS where (\
(PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) order by N\
OTIFY_DATE_TIME ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )633;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&c_count_notify;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&actual_specimen;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

								


						if(NODATAFOUND);
						if (OERROR)
							  disp_message(ORA_MESG,"Failed at Select RL_NOTIFY_DETAILS in splitting1()");
						  
				/* EXEC SQL  SELECT NVL(' ','O'), //madhu
                     NVL(TECH_STATUS,'*'), 
                     NVL(DELTA_STATUS,'*'), 
                     NVL(QLTY_STATUS,'*'), 
                     NVL(CMNT_STATUS,'*'), 
                     NVL(PATH_STATUS,'*')
					 INTO 
					 rl_tst_status,
								 rl_tst_delta_status,
							     rl_tst_tech_status,
								 rl_tst_qlty_status,
								 rl_tst_cmnt_status,
								 rl_tst_path_status
                     from RL_TEST_RESULT 
					 where SPECIMEN_NO = :actual_specimen 
					 AND ROWNUM=1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(' ','O') ,NVL(TECH_STATUS,'*') ,NVL(DELTA_STAT\
US,'*') ,NVL(QLTY_STATUS,'*') ,NVL(CMNT_STATUS,'*') ,NVL(PATH_STATUS,'*') into\
 :b0,:b1,:b2,:b3,:b4,:b5  from RL_TEST_RESULT where (SPECIMEN_NO=:b6 and ROWNU\
M=1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )664;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_status;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_tst_delta_status;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_tst_tech_status;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_qlty_status;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_cmnt_status;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_tst_path_status;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&actual_specimen;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


					 
					 
						if(NODATAFOUND);
						if (OERROR)
							  disp_message(ORA_MESG,"Failed at Select RL_TEST_RESULT in splitting1()");
						  
						
   if (c_count_notify > 0) 
   {
	   
    strcpy(word1,"F");
	_flushall(); 
	fprintf(fp,"%-20.20s: ", local_legend[95]); //added for globalisation 
	fprintf(fp,"%-60.60s\n",l_str);
	page_break(1);
	w_flag = 'T';
	open_notify_type();
	
    while(fetch_notify_type())
    {
		  something_to_print = 1;
		  something_to_print_for_test = 1;
   	get_user_name(RL_NOTIFY_BY.arr);	
	fprintf(fp,"%-15.15s: ", local_legend[91]); //added for globalisation 
	sprintf(l_str,"%s", sy_user_name.arr);
	fprintf(fp,"%-60.60s\n",l_str);
	
	page_break(1);
	
    get_user_name(RL_NOTIFY_TO.arr);	
	fprintf(fp,"%-15.15s: ", local_legend[92]); //added for globalisation 
    sprintf(l_str,"%s", sy_user_name.arr);
	fprintf(fp,"%-60.60s\n",l_str);	
	

   page_break(1);
   
	fprintf(fp,"%-15.15s: ", local_legend[93]); //added for globalisation 
   
   if (RL_NOTIFY_DATE_TIME1.len != 0)
    {
		 fprintf(fp,"%-30s",RL_NOTIFY_DATE_TIME1.arr);
		 fprintf(fp, "\n");
		 page_break(1);
   }
   page_break(1);
      
	fprintf(fp,"%-15.15s:", local_legend[94]); //added for globalisation 
	
          hell = strlen(RL_NOTIFY_TEXT.arr);
//		  fprintf(fp, "\n");

/***** added for KDAH requirement to print the long desc of the result text **********/
//sprintf(string_var, "String  -> [%s]  [%s]", rl_print_text_desc_yn.arr, rl_res_result_text_code.arr);
//disp_message(ERR_MESG, string_var);

         z = 0;
	     clt = 0;
	     strcpy(word1,"F");
	     cntr = 1;
	     qq = 0;
		 
		 
         while(z<hell)
         {
		     word[0] = RL_NOTIFY_TEXT.arr[z];
 		     word[1] = '\0';

		    if (strcmp(word,"\n") == 0)
		     {
		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
		      } 

  		      if(cntr >= 71)
		      {
		   	
			     cmp = cntr;
			     while((RL_NOTIFY_TEXT.arr[z] != 32) && (cmp > 1))
			     {
			         z--;
				     cmp--;
			      }

				  qq = z;
				  			   
			      word[0] = RL_NOTIFY_TEXT.arr[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
		       }
			   
				if (((z == hell) || (z == hell - 1)) && (strcmp(word1,"F") == 0))
				{
					
					if (clt == 0)
					{
				   fprint_repeat(fp,' ',1);	
					}
			       else 
				   {
				   fprint_repeat(fp,' ',8);	
					}
					
				   for(i=clt;i < z + 1;i++)
		           {
					   if(RL_NOTIFY_TEXT.arr[i] == '\n')
						{
						//  if ((z + 1 - clt) < 70)
						 // {
						 	   fprintf(fp,"%c%c%c%c%c%c",
						         rl_tst_status.arr[0],
								 rl_tst_delta_status.arr[0],
							     rl_tst_tech_status.arr[0],
								 rl_tst_qlty_status.arr[0],
								 rl_tst_cmnt_status.arr[0],
								 rl_tst_path_status.arr[0]);

							    w_flag = 'F';
						  // }
 						 }
					   
		              fprintf(fp,"%c",RL_NOTIFY_TEXT.arr[i]);
				   }
				     if (w_flag == 'T')
				   {
				    	fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
					   		   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);
				   }
			       
			       fprintf	(fp,"\n");
				   //page_break(1);
				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");


				}
			
		       if (strcmp(word1,"N") == 0) 
		       {
				
		         if (clt == 0)
					{
				   fprint_repeat(fp,' ',1);	
					}
			       else 
				   {
				   fprint_repeat(fp,' ',8);	
					}
						   
				  for(i=clt;i<=qq;i++)
		          { 
			         if(RL_NOTIFY_TEXT.arr[i] == '\n')
					{
						  
						  //if ((qq  - clt) < 70)
						 //{
							fprintf(fp,"%c%c%c%c%c%c",
						        rl_tst_status.arr[0],
							    rl_tst_tech_status.arr[0],
								rl_tst_delta_status.arr[0],
								rl_tst_qlty_status.arr[0],
								rl_tst_cmnt_status.arr[0],
								rl_tst_path_status.arr[0]);
								w_flag = 'F';
						 //}

				    }
					
			         fprintf(fp,"%c",RL_NOTIFY_TEXT.arr[i]);
					
			      }
				    if (w_flag == 'T')
				  {
				   	 fprintf(fp,"%c%c%c%c%c%c",
					      rl_tst_status.arr[0],
					      rl_tst_tech_status.arr[0],
					  	  rl_tst_delta_status.arr[0],
						  rl_tst_qlty_status.arr[0],
						  rl_tst_cmnt_status.arr[0],
						  rl_tst_path_status.arr[0]);
				  }
                    //page_break(1);                                 
			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }
			   
		       if (strcmp(word1,"T") == 0)
		       {
				 
		 		if (clt == 0)
					{
				   fprint_repeat(fp,' ',1);	
					}
			       else 
				   {
				   fprint_repeat(fp,' ',8);	
					}
					
						   
				  for(i=clt;i<= qq;i++)
		          {  
			        if(RL_NOTIFY_TEXT.arr[i] == '\n')
					 {
						 
						 // if ((qq  - clt) < 70)
						  //{
							fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
							   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);

								w_flag = 'F';
							//}

					  }
		             fprintf(fp,"%c",RL_NOTIFY_TEXT.arr[i]);
				
			      }
				   if (w_flag == 'T')
				  {
						fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
							   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);
					}

			       fprintf	(fp,"\n");
				   //page_break(1);
			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");

		        } 
		        if (strcmp(word1,"W") == 0)
		        {
		 		
			     if (clt == 0)
					{
				   fprint_repeat(fp,' ',1);	
					}
			       else 
				   {
				   fprint_repeat(fp,' ',8);	
					}
					
						   
				   for(i=clt;i < clt + 70;i++)
		           {  
			          if(RL_NOTIFY_TEXT.arr[i] == '\n')
						{

						//  if ((clt + 70 - clt) < 70)
						  //{
							fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
							   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);

								w_flag = 'F';
							//}
						}
			          
		              fprintf(fp,"%c",RL_NOTIFY_TEXT.arr[i]);
			       }
				    if (w_flag = 'T')
				   {
						fprintf(fp,"%c%c%c%c%c%c",
				  	         rl_tst_status.arr[0],
							 rl_tst_tech_status.arr[0],
							 rl_tst_delta_status.arr[0],
							 rl_tst_qlty_status.arr[0],
							 rl_tst_cmnt_status.arr[0],
							 rl_tst_path_status.arr[0]);
				   }

			       fprintf(fp,"\n");
				   //page_break(1);
				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
		        }

		    w_flag = 'T';	
            cntr += 1;
	        z++ ;
          }
		
      }
	  
	  close_notify_type();
   }
       fflush(fp);
	   

#ifdef DEBUG
   printf("rl_res_result_text = %s\n", RL_NOTIFY_TEXT.arr);
#endif

if (OERROR)
   ins_message(ORA_MESG,"Error occurred at splitting()");

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   ins_message(ORA_MESG,"Error occurred at splitting()");
   return;
}



close_hdr()
{
    /* EXEC SQL CLOSE RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )707;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("CLOSE failed on cursor RL_REQ_HDR_CUR",0,"");
}

/*-----------------------------------------------------*/
open_hdr()
{
    /* EXEC SQL OPEN RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0018;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )722;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_REQ_HDR_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_hdr()
{ 
  rl_hdr_source_code.arr[0]            = '\0';
  rl_hdr_consultant_code.arr[0]        = '\0';
  rl_hdr_spec_regd_date_time.arr[0]    = '\0';
  rl_hdr_spec_recd_date_time.arr[0]    = '\0';
  rl_hdr_spec_colltd_date_time.arr[0]  = '\0';
  rl_order_id.arr[0]				   = '\0';
  rl_hdr_released_by_id.arr[0]		   = '\0';
  rl_hdr_current_date_time.arr[0]      = '\0';
  rl_hdr_section_code.arr[0]           = '\0';
  rl_hdr_request_comment_code1.arr[0]  = '\0';
  rl_hdr_request_comment_code2.arr[0]  = '\0';
  rl_hdr_request_comment_code3.arr[0]  = '\0';
  rl_hdr_request_comment_desc1.arr[0]  = '\0';
  rl_hdr_request_comment_desc2.arr[0]  = '\0';
  rl_hdr_request_comment_desc3.arr[0]  = '\0';
  rl_hdr_extra_copies_to.arr[0]        = '\0';
  rl_hdr_specimen_type_code.arr[0]     = '\0';
  rl_hdr_added_by_id.arr[0]            = '\0';
  rl_hdr_added_date.arr[0]             = '\0';
  rl_hdr_modified_by_id.arr[0]         = '\0';
  rl_hdr_modified_date.arr[0]          = '\0';
  rl_hdr_episode_type.arr[0]           = '\0';
  rl_hdr_urgent_indicator.arr[0]       = '\0';
  rl_hdr_ordered_facility_id.arr[0]	   = '\0';
  rl_hdr_released_date.arr[0]		   = '\0';

  rl_hdr_source_code.len               = 0;
  rl_hdr_consultant_code.len           = 0;
  rl_hdr_spec_regd_date_time.len       = 0;
  rl_hdr_spec_recd_date_time.len       = 0;
  rl_hdr_spec_colltd_date_time.len     = 0;
  rl_order_id.len			 		   = 0; 
  rl_hdr_released_by_id.len            = 0;
  rl_hdr_current_date_time.len         = 0;
  rl_hdr_section_code.len              = 0;
  rl_hdr_request_comment_code1.len     = 0;
  rl_hdr_request_comment_code2.len     = 0;
  rl_hdr_request_comment_code3.len     = 0;
  rl_hdr_request_comment_desc1.len     = 0;
  rl_hdr_request_comment_desc2.len     = 0;
  rl_hdr_request_comment_desc3.len     = 0;
  rl_hdr_extra_copies_to.len           = 0;
  rl_hdr_specimen_type_code.len        = 0;
  rl_hdr_added_by_id.len               = 0;
  rl_hdr_added_date.len                = 0;
  rl_hdr_modified_by_id.len            = 0;
  rl_hdr_modified_date.len             = 0;
  rl_hdr_episode_type.len	           = 0;
  rl_hdr_urgent_indicator.len	       = 0;
  rl_hdr_ordered_facility_id.len	   = 0;
  rl_hdr_released_date.len             = 0;

    /* EXEC SQL FETCH RL_REQ_HDR_CUR
              INTO :rl_hdr_source_code,
                   :rl_hdr_consultant_code,
                   :rl_hdr_spec_recd_date_time,
                   :rl_hdr_spec_regd_date_time,
			       :rl_hdr_spec_colltd_date_time,
				   :rl_order_id,
				   :rl_hdr_released_by_id,
				   :rl_hdr_released_date,
                   :rl_hdr_current_date_time,
                   :rl_hdr_section_code,
                   :rl_hdr_request_comment_code1,
                   :rl_hdr_request_comment_code2,
                   :rl_hdr_request_comment_code3,
                   :rl_hdr_request_comment_desc1,
                   :rl_hdr_request_comment_desc2,
                   :rl_hdr_request_comment_desc3,
                   :rl_hdr_extra_copies_to,
                   :rl_hdr_specimen_type_code,
                   :rl_hdr_added_by_id,
                   :rl_hdr_added_date,
                   :rl_hdr_modified_by_id,
                   :rl_hdr_modified_date,
  		   :rl_hdr_urgent_indicator,
  		   :rl_hdr_episode_type,
		   :rl_hdr_ordered_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 25;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )749;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_source_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_hdr_consultant_code;
    sqlstm.sqhstl[1] = (unsigned int  )18;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_hdr_spec_recd_date_time;
    sqlstm.sqhstl[2] = (unsigned int  )19;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[3] = (unsigned int  )19;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_hdr_spec_colltd_date_time;
    sqlstm.sqhstl[4] = (unsigned int  )19;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_order_id;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_hdr_released_by_id;
    sqlstm.sqhstl[6] = (unsigned int  )33;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_hdr_released_date;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rl_hdr_current_date_time;
    sqlstm.sqhstl[8] = (unsigned int  )19;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&rl_hdr_section_code;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&rl_hdr_request_comment_code1;
    sqlstm.sqhstl[10] = (unsigned int  )7;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&rl_hdr_request_comment_code2;
    sqlstm.sqhstl[11] = (unsigned int  )7;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rl_hdr_request_comment_code3;
    sqlstm.sqhstl[12] = (unsigned int  )7;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rl_hdr_request_comment_desc1;
    sqlstm.sqhstl[13] = (unsigned int  )43;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&rl_hdr_request_comment_desc2;
    sqlstm.sqhstl[14] = (unsigned int  )43;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&rl_hdr_request_comment_desc3;
    sqlstm.sqhstl[15] = (unsigned int  )43;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&rl_hdr_extra_copies_to;
    sqlstm.sqhstl[16] = (unsigned int  )18;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&rl_hdr_specimen_type_code;
    sqlstm.sqhstl[17] = (unsigned int  )7;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&rl_hdr_added_by_id;
    sqlstm.sqhstl[18] = (unsigned int  )33;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&rl_hdr_added_date;
    sqlstm.sqhstl[19] = (unsigned int  )18;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&rl_hdr_modified_by_id;
    sqlstm.sqhstl[20] = (unsigned int  )33;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&rl_hdr_modified_date;
    sqlstm.sqhstl[21] = (unsigned int  )18;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&rl_hdr_urgent_indicator;
    sqlstm.sqhstl[22] = (unsigned int  )4;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&rl_hdr_episode_type;
    sqlstm.sqhstl[23] = (unsigned int  )4;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&rl_hdr_ordered_facility_id;
    sqlstm.sqhstl[24] = (unsigned int  )5;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
        err_mesg("FETCH failed on cursor RL_REQ_HDR_CUR",0,"");

    rl_hdr_source_code.arr[rl_hdr_source_code.len]		 	= '\0';
    rl_hdr_consultant_code.arr[rl_hdr_consultant_code.len]		= '\0';
    rl_hdr_spec_recd_date_time.arr[rl_hdr_spec_recd_date_time.len] 	= '\0';
    rl_hdr_spec_regd_date_time.arr[rl_hdr_spec_regd_date_time.len] 	= '\0';
    rl_hdr_spec_colltd_date_time.arr[rl_hdr_spec_colltd_date_time.len] = '\0';
	rl_order_id.arr[rl_order_id.len]									= '\0';	 
	rl_hdr_released_by_id.arr[rl_hdr_released_by_id.len]				= '\0';
    rl_hdr_current_date_time.arr[rl_hdr_current_date_time.len] 		= '\0';
    rl_hdr_section_code.arr[rl_hdr_section_code.len] 			= '\0';
    rl_hdr_request_comment_code1.arr[rl_hdr_request_comment_code1.len] = '\0';
    rl_hdr_request_comment_code2.arr[rl_hdr_request_comment_code2.len] = '\0';
    rl_hdr_request_comment_code3.arr[rl_hdr_request_comment_code3.len] = '\0';
    rl_hdr_request_comment_desc1.arr[rl_hdr_request_comment_desc1.len] = '\0';
    rl_hdr_request_comment_desc2.arr[rl_hdr_request_comment_desc2.len] = '\0';
    rl_hdr_request_comment_desc3.arr[rl_hdr_request_comment_desc3.len] = '\0';
    rl_hdr_extra_copies_to.arr[rl_hdr_extra_copies_to.len]             = '\0';
    rl_hdr_specimen_type_code.arr[rl_hdr_specimen_type_code.len]       = '\0';
    rl_hdr_added_by_id.arr[rl_hdr_added_by_id.len]                     = '\0';
    rl_hdr_added_date.arr[rl_hdr_added_date.len]                       = '\0';
    rl_hdr_modified_by_id.arr[rl_hdr_modified_by_id.len]               = '\0';
    rl_hdr_modified_date.arr[rl_hdr_modified_date.len]                 = '\0';
    rl_hdr_episode_type.arr[rl_hdr_episode_type.len]				   = '\0';
    rl_hdr_urgent_indicator.arr[rl_hdr_urgent_indicator.len]	       = '\0';
	rl_hdr_ordered_facility_id.arr[rl_hdr_ordered_facility_id.len]	   = '\0';
    rl_hdr_released_date.arr[rl_hdr_released_date.len]					= '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
/********** INCLUDED AS DYNAMIC SQL ***************
open_tst_result()
{
    EXEC SQL OPEN RL_TEST_RESULT_CUR;

    if (OERROR)
         err_mesg("OPEN failed on cursor RL_TEST_RESULT_CUR",0,"");
}
**********************/
/*-----------------------------------------------------*/
/*-----------------------------------------------------*/
declare_tst_result_curs()
{
strcpy(sql_stmt.arr, "SELECT B.specimen_no, \
					 B.GROUP_TEST_CODE, \
                     B.TEST_CODE, \
                     NVL(NUMERIC_PREFIX,'+'), \
                     NUMERIC_RESULT, \
					 RESULT_COMMENT_DESC1, \
                     RESULT_COMMENT_DESC2, \
                     RESULT_COMMENT_DESC3, \
                     RESULT_COMMENT_DESC4, \
					 NVL(B.STATUS,'O'), \
					 NVL(TECH_STATUS,'*'), \
					 NVL(DELTA_STATUS,'*'), \
					 NVL(QLTY_STATUS,'*'), \
					 NVL(CMNT_STATUS,'*'), \
					 NVL(PATH_STATUS,'*'), \
					 B.TEST_UNITS, \
					 TEST_REF_RANGE_COMMENT, \
					 AGE_RANGE_LOW, \
					 AGE_RANGE_HIGH, \
                     B.ROWID AS row_id, \
					 NVL(HIDE_RESULT_COMMENTS_YN,'N'), \
					 B.high_low_ind, \
					 A.seq_no, \
					 NVL(B.numeric_result_hide_yn, 'N') numeric_result_hide_yn, \
					 NVL(C.interval_test_yn,'N'), \
					 NVL(B.preliminary_release_yn,'N') preliminary_release_yn, \
					 B.TEST_METHOD_CODE , \
					 B.CRITICAL_VALUE_YN, \
					 B.SUB_SECTION_CODE,  \
					 B.SUB_SECTION_CODE_IND\
                FROM RL_INTERVAL_TEST_TEMP A, RL_TEST_RESULT B,RL_TEST_CODE C \
               WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
			     AND B.PATIENT_ID = :nd_hosp_no \
                 AND A.specimen_no = B.specimen_no \
				 AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
				 AND B.test_code = DECODE(A.test_code, NULL, B.test_code, A.test_code) \
				 AND B.group_test_code = A.group_test_code \
				 AND A.operating_facility_id = B.operating_facility_id \
				 AND NVL(B.cancelled_yn, 'N') <> 'Y' \
				 AND A.user_id = USER  \
				 AND B.test_code = C.test_code \
				 AND A.session_id = USERENV('sessionid') ");
	

	if (d_interval_specimen_yn == 'Y')
		strcat(sql_stmt.arr, " ORDER BY B.SUB_SECTION_CODE,B.SUB_SECTION_CODE_IND,B.test_code, B.specimen_no, B.GROUP_SEQ_NO,B.GROUP_TEST_CODE,B.TEST_SEQ_NO,B.TEST_CODE"); //ADDED FOR GHL-CRF-0452
	else
		strcat(sql_stmt.arr, " ORDER BY B.SUB_SECTION_CODE,B.SUB_SECTION_CODE_IND,B.GROUP_SEQ_NO,B.GROUP_TEST_CODE,B.TEST_SEQ_NO,B.TEST_CODE"); //ADDED FOR GHL-CRF-0452

		 
	sql_stmt.len = strlen(sql_stmt.arr);
	/* EXEC SQL PREPARE sr1 FROM :sql_stmt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )864;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sql_stmt;
 sqlstm.sqhstl[0] = (unsigned int  )5002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
	//added the below code for ML-MMOH-SCF-0934
	/* EXEC SQL  SELECT  count(*) into :i_test_count
                FROM RL_INTERVAL_TEST_TEMP A, RL_TEST_RESULT B,RL_TEST_CODE C 
               WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id 
			     AND B.PATIENT_ID = :nd_hosp_no 
                 AND A.specimen_no = B.specimen_no 
				 AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id 
				 AND B.test_code = DECODE(A.test_code, NULL, B.test_code, A.test_code) 
				 AND B.group_test_code = A.group_test_code 
				 AND A.operating_facility_id = B.operating_facility_id 
				 AND NVL(B.cancelled_yn, 'N') <> 'Y' 
				 AND A.user_id = USER  
				 AND B.test_code = C.test_code 
				AND A.session_id = USERENV('sessionid'); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_TEMP A ,RL_\
TEST_RESULT B ,RL_TEST_CODE C where ((((((((((A.OPERATING_FACILITY_ID=:b1 and \
B.PATIENT_ID=:b2) and A.specimen_no=B.specimen_no) and B.OPERATING_FACILITY_ID\
=:b1) and B.test_code=DECODE(A.test_code,null ,B.test_code,A.test_code)) and B\
.group_test_code=A.group_test_code) and A.operating_facility_id=B.operating_fa\
cility_id) and NVL(B.cancelled_yn,'N')<>'Y') and A.user_id=USER) and B.test_co\
de=C.test_code) and A.session_id=USERENV('sessionid'))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )883;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&i_test_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_hosp_no;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
	//end ML-MMOH-SCF-0934

	if (OERROR)
		 disp_message(ORA_MESG,"PREPARE failed on table RL_TEST_RESULT");

    /* EXEC SQL DECLARE rl_test_result_cur CURSOR FOR sr1; */ 
		

}
/*-----------------------------------------------------*/

/*-----------------------------------------------------*/
//added for ML-MMOH-SCF-0934
test_count()
{
 //disp_message(ORA_MESG,"test_count()");
 /* EXEC SQL  SELECT  count(*) into :i_test_count
                FROM RL_INTERVAL_TEST_TEMP A, RL_TEST_RESULT B,RL_TEST_CODE C 
               WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id 
			     AND B.PATIENT_ID = :nd_hosp_no 
                 AND A.specimen_no = B.specimen_no 
				 AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id 
				 AND B.test_code = DECODE(A.test_code, NULL, B.test_code, A.test_code) 
				 AND B.group_test_code = A.group_test_code 
				 AND A.operating_facility_id = B.operating_facility_id 
				 AND NVL(B.cancelled_yn, 'N') <> 'Y' 
				 AND A.user_id = USER  
				 AND B.test_code = C.test_code 
				AND A.session_id = USERENV('sessionid'); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_TEMP A ,RL_\
TEST_RESULT B ,RL_TEST_CODE C where ((((((((((A.OPERATING_FACILITY_ID=:b1 and \
B.PATIENT_ID=:b2) and A.specimen_no=B.specimen_no) and B.OPERATING_FACILITY_ID\
=:b1) and B.test_code=DECODE(A.test_code,null ,B.test_code,A.test_code)) and B\
.group_test_code=A.group_test_code) and A.operating_facility_id=B.operating_fa\
cility_id) and NVL(B.cancelled_yn,'N')<>'Y') and A.user_id=USER) and B.test_co\
de=C.test_code) and A.session_id=USERENV('sessionid'))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )914;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&i_test_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_hosp_no;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


				 
				 
//sprintf(string_var,"test_count: %d",i_test_count);
	  // disp_message(ERR_MESG, string_var);
if (OERROR)
		 disp_message(ORA_MESG,"failed on table test_count()");

}
//end ML-MMOH-SCF-0934
/*-----------------------------------------------------*/
open_tst_result_curs()
{

	/* EXEC SQL OPEN rl_test_result_cur USING :nd_operating_facility_id,
	                                       :nd_hosp_no,
										   :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 25;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )945;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




}
/*-----------------------------------------------------*/
fetch_tst_result()
{

  rl_tst_group_test_code.arr[0]      	  = '\0';
  rl_tst_test_code.arr[0]     	 	  = '\0';
  rl_tst_numeric_prefix.arr[0] 	          = '\0';
  rl_tst_numeric_result.arr[0]            = '\0';
  rl_tst_result_comment_desc1.arr[0]      = '\0';
  rl_tst_result_comment_desc2.arr[0]      = '\0';
  rl_tst_result_comment_desc3.arr[0]      = '\0';
  rl_tst_result_comment_desc4.arr[0]      = '\0';
  rl_tst_status.arr[0] 			  = '\0';
  rl_tst_tech_status.arr[0] 	 	  = '\0';
  rl_tst_delta_status.arr[0] 		  = '\0';
  rl_tst_qlty_status.arr[0] 		  = '\0';
  rl_tst_cmnt_status.arr[0] 		  = '\0';
  rl_tst_path_status.arr[0] 		  = '\0';
  rl_tst_rowid.arr[0]                     = '\0';
  rl_tst_hide_rslt_comm_yn.arr[0]		= '\0';
  
  rl_tst_cd_test_units.arr[0]		  = '\0';
  rl_tst_cd_range_cmt.arr[0]		  = '\0';
  rl_tst_range_low_v_nor.arr[0] 	  = '\0';
  rl_tst_range_high_v_nor.arr[0]	  = '\0';
  d_specimen_no.arr[0]			  = '\0';
  rl_high_low_ind.arr[0]		  = '\0';
  rl_num_result_hide_yn.arr[0]		  = '\0';
  rl_tst_interval_test_yn.arr[0]      = '\0';
  rl_tst_preliminary_release_yn.arr[0]      = '\0';
  rl_tst_test_method_code.arr[0]      = '\0';
  rl_tst_test_sub_sec.arr[0]      = '\0'; //added for GHL-CRF-0452-DD-01
  rl_grp_tst_test_sub_sec.arr[0]		 = '\0'; //GHL-CRF-0489

  rl_tst_group_test_code.len              = 0;
  rl_tst_test_code.len         		  = 0;
  rl_tst_numeric_prefix.len         	  = 0;
  rl_tst_numeric_result.len 	          = 0;
  rl_tst_result_comment_desc1.len         = 0;
  rl_tst_result_comment_desc2.len         = 0;
  rl_tst_result_comment_desc3.len         = 0;
  rl_tst_result_comment_desc4.len         = 0;
  rl_tst_status.len 			  = 0;
  rl_tst_tech_status.len 	 	  = 0;
  rl_tst_delta_status.len 		  = 0;
  rl_tst_qlty_status.len 		  = 0;
  rl_tst_cmnt_status.len 		  = 0;
  rl_tst_path_status.len 		  = 0;
  rl_tst_rowid.len                        = 0;
  rl_tst_hide_rslt_comm_yn.len    = 0;
  rl_tst_cd_test_units.len		  = 0;
  rl_tst_cd_range_cmt.len		  = 0;
  rl_tst_range_low_v_nor.len	  = 0;
  rl_tst_range_high_v_nor.len	  = 0;
  d_specimen_no.len				  = 0;
  rl_high_low_ind.len			  = 0;
  rl_num_result_hide_yn.len		  = 0;
  rl_tst_interval_test_yn.len     = 0;
  rl_tst_preliminary_release_yn.len = 0; /// 22.08.2006
  rl_tst_test_method_code.len = 0;  /// 15.05.2015
  
  rl_tst_test_sub_sec.len = 0; //added for GHL-CRF-0452-DD-01
  rl_grp_tst_test_sub_sec.len = 0; //GHL-CRF-0489
  
  rl_critical_result.arr[0]            = '\0'; //added for INT-CRF-BRU-LIS-006


    /* EXEC SQL FETCH RL_TEST_RESULT_CUR
              INTO :d_specimen_no,
				   :rl_tst_group_test_code,
                   :rl_tst_test_code,
                   :rl_tst_numeric_prefix,
                   :rl_tst_numeric_result,
                   :rl_tst_result_comment_desc1,
                   :rl_tst_result_comment_desc2,
                   :rl_tst_result_comment_desc3,
                   :rl_tst_result_comment_desc4,
				   :rl_tst_status,
				   :rl_tst_tech_status,
				   :rl_tst_delta_status,
				   :rl_tst_qlty_status,
				   :rl_tst_cmnt_status,
				   :rl_tst_path_status,
				   :rl_tst_cd_test_units,
				   :rl_tst_cd_range_cmt,
				   :rl_tst_range_low_v_nor,
				   :rl_tst_range_high_v_nor,
                   :rl_tst_rowid,
				   :rl_tst_hide_rslt_comm_yn,
				   :rl_high_low_ind, 
				   :rl_seq_no,
				   :rl_num_result_hide_yn,
				   :rl_tst_interval_test_yn,
				   :rl_tst_preliminary_release_yn,
				   :rl_tst_test_method_code,
				   :rl_critical_result, //added for INT-CRF-BRU-LIS-006
				   :rl_tst_test_sub_sec, //added for GHL-CRF-0452-DD-01
				   :rl_grp_tst_test_sub_sec; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )972;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_numeric_prefix;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_numeric_result;
    sqlstm.sqhstl[4] = (unsigned int  )18;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_tst_result_comment_desc1;
    sqlstm.sqhstl[5] = (unsigned int  )43;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_tst_result_comment_desc2;
    sqlstm.sqhstl[6] = (unsigned int  )43;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_tst_result_comment_desc3;
    sqlstm.sqhstl[7] = (unsigned int  )43;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rl_tst_result_comment_desc4;
    sqlstm.sqhstl[8] = (unsigned int  )43;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&rl_tst_status;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&rl_tst_tech_status;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&rl_tst_delta_status;
    sqlstm.sqhstl[11] = (unsigned int  )4;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rl_tst_qlty_status;
    sqlstm.sqhstl[12] = (unsigned int  )4;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rl_tst_cmnt_status;
    sqlstm.sqhstl[13] = (unsigned int  )4;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&rl_tst_path_status;
    sqlstm.sqhstl[14] = (unsigned int  )4;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&rl_tst_cd_test_units;
    sqlstm.sqhstl[15] = (unsigned int  )13;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&rl_tst_cd_range_cmt;
    sqlstm.sqhstl[16] = (unsigned int  )43;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&rl_tst_range_low_v_nor;
    sqlstm.sqhstl[17] = (unsigned int  )18;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&rl_tst_range_high_v_nor;
    sqlstm.sqhstl[18] = (unsigned int  )18;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&rl_tst_rowid;
    sqlstm.sqhstl[19] = (unsigned int  )33;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&rl_tst_hide_rslt_comm_yn;
    sqlstm.sqhstl[20] = (unsigned int  )4;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&rl_high_low_ind;
    sqlstm.sqhstl[21] = (unsigned int  )12;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&rl_seq_no;
    sqlstm.sqhstl[22] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&rl_num_result_hide_yn;
    sqlstm.sqhstl[23] = (unsigned int  )4;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&rl_tst_interval_test_yn;
    sqlstm.sqhstl[24] = (unsigned int  )4;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&rl_tst_preliminary_release_yn;
    sqlstm.sqhstl[25] = (unsigned int  )4;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&rl_tst_test_method_code;
    sqlstm.sqhstl[26] = (unsigned int  )6;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&rl_critical_result;
    sqlstm.sqhstl[27] = (unsigned int  )3;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&rl_tst_test_sub_sec;
    sqlstm.sqhstl[28] = (unsigned int  )6;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&rl_grp_tst_test_sub_sec;
    sqlstm.sqhstl[29] = (unsigned int  )6;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

//GHL-CRF-0489


    if (OERROR)
         err_mesg("FETCH failed on cursor RL_TEST_RESULT_CUR",0,"");

    rl_tst_group_test_code.arr[rl_tst_group_test_code.len] = '\0';
    rl_tst_test_code.arr[rl_tst_test_code.len] = '\0';
    rl_tst_numeric_prefix.arr[rl_tst_numeric_prefix.len] = '\0';
    rl_tst_numeric_result.arr[rl_tst_numeric_result.len] = '\0';
    rl_tst_result_comment_desc1.arr[rl_tst_result_comment_desc1.len] = '\0';
    rl_tst_result_comment_desc2.arr[rl_tst_result_comment_desc2.len] = '\0';
    rl_tst_result_comment_desc3.arr[rl_tst_result_comment_desc3.len] = '\0';
    rl_tst_result_comment_desc4.arr[rl_tst_result_comment_desc4.len] = '\0';
    rl_tst_rowid.arr[rl_tst_rowid.len] = '\0';
    rl_tst_status.arr[rl_tst_status.len]= '\0';
    rl_tst_hide_rslt_comm_yn.arr[rl_tst_hide_rslt_comm_yn.len] = '\0';

    rl_tst_tech_status.arr[rl_tst_tech_status.len] = '\0'; 
    rl_tst_delta_status.arr[rl_tst_delta_status.len] = '\0'; 
    rl_tst_qlty_status.arr[rl_tst_qlty_status.len] = '\0'; 
    rl_tst_cmnt_status.arr[rl_tst_cmnt_status.len] = '\0'; 
    rl_tst_path_status.arr[rl_tst_path_status.len] = '\0'; 
    rl_tst_cd_test_units.arr[rl_tst_cd_test_units.len]  	      = '\0';
    rl_tst_cd_range_cmt.arr[rl_tst_cd_range_cmt.len]		      = '\0';
    rl_tst_range_low_v_nor.arr[rl_tst_range_low_v_nor.len]	  = '\0';
    rl_tst_range_high_v_nor.arr[rl_tst_range_high_v_nor.len]	  = '\0';
	d_specimen_no.arr[d_specimen_no.len]					   = '\0';
	rl_high_low_ind.arr[rl_high_low_ind.len]				   = '\0';
	rl_num_result_hide_yn.arr[rl_num_result_hide_yn.len]	   = '\0';
    rl_tst_interval_test_yn.arr[rl_tst_interval_test_yn.len]   = '\0';
	rl_tst_preliminary_release_yn.arr[rl_tst_preliminary_release_yn.len] = '\0';
	rl_tst_test_method_code.arr[rl_tst_test_method_code.len] = '\0';
	
	rl_tst_test_sub_sec.arr[rl_tst_test_sub_sec.len] = '\0'; //added for GHL-CRF-0452-DD-01
	rl_grp_tst_test_sub_sec.arr[rl_grp_tst_test_sub_sec.len] = '\0'; //GHL-CRF-0489

	strcpy(nd_spec_no.arr, d_specimen_no.arr);
	nd_spec_no.len = strlen(nd_spec_no.arr);
	
	rl_critical_result.arr[rl_critical_result.len] = '\0'; //added for INT-CRF-BRU-LIS-006


#ifdef DEBUG
    	printf("Group is <%s> tst is <%s>\n",rl_tst_group_test_code.arr,
                       rl_tst_test_code.arr);
	printf("In fetch_tst_result, last_row = %d \n",
	LAST_ROW);
#endif
    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

print_dtls()
{
    int next_line = 0;
	void splitting();
	void splitting_biochem(); //ADDED FOR MO-CRF-20134
	void result_comment_biochem(); //ADDED FOR MO-CRF-20134
	
    char range_cmnt_print_flag = 'N';
    char l_str [100],l_str1[100];
    int agesex_range_flag = FALSE;
    int path_review_flag = FALSE; 
    numeric_value_flag = FALSE;
    strcpy(l_str,""); 
    page_break(0); 

    fetch_test_code(rl_tst_test_code.arr);  
	
	something_to_print_for_test = 0; //// 21.05.2005


// 21.07.2003   if ((flag == 'C') || (flag == 'K') || (rl_conf_yn.arr[0] == 'N'))
///// 08.10.2003   if  ((flag == 'C') || (flag == 'K') || (flag == 'L') || (rl_conf_yn.arr[0] == 'N'))

// 21.05.2005   if  ((flag == 'C') || (flag == 'K') || (rl_conf_yn.arr[0] == 'N'))

   if(    (flag == 'C' && rl_tst_status.arr[0] != 'A') 
       || (flag == 'K') 
       || (flag == 'L' && rl_conf_yn.arr[0] == 'N')  
       || ((flag == 'L')  && nd_user_conf_access_yn.arr[0] == 'Y')  //// 28.09.2006 against SD CRF-20006.
	   || (flag == 'W' && atoi(c_count_profile.arr) > 0 && rl_tst_status.arr[0] != 'A' 
	                   && rl_conf_yn.arr[0] == 'N'   
		  ) 
	   || (flag == 'W' && atoi(c_count_profile.arr) > 0 && strcmp(rl_tst_preliminary_release_yn.arr, "Y") == 0  // 22.08.2006
	                   && rl_conf_yn.arr[0] == 'N'     // 22.08.2006
		  ) 
     )  // 21.05.2005
   {
    if  ( (flag == 'K') || (flag == 'L') || (rl_inhibit_report_yn.arr[0] == 'N'))
//	 if ((flag == 'K') || (flag == 'L')  ||   ( ((flag == 'C') || (flag == 'W')) && (rl_inhibit_report_yn.arr[0] == 'N'))) 
     {
	 spc_first = 1;
     fflush(fp);
     ind_test_prn = 0;

/******** Newly added to print the specimen nos for the GTT Tests ****/
		if (d_interval_specimen_yn == 'Y' && rl_tst_interval_test_yn.arr[0] == 'Y')
		 {

			if (strcmp(rl_tst_test_code.arr, nd_test_code) != 0)
			{
				strcpy(nd_test_code, rl_tst_test_code.arr);
				l_seq_no = 1;
			}
			else  
				l_seq_no++;

				sprintf(l_str,"Specimen No: %-15.15s", nd_spec_no.arr);
				print_line(l_str);
				strcpy(l_str,"");
				page_break(0);
		 }
/******* Upto here *******/
	
//disp_message(ERR_MESG,"in Process_rec() INSIDE print_dtls()");
	
    if (rl_tst_cd_print_report_yn.arr[0] == 'Y') 
	{
		if (d_interval_specimen_yn == 'Y' && rl_tst_interval_test_yn.arr[0] == 'Y')
		{

			get_interval_description();
			sprintf(l_str,"%-40.40s",interval_description.arr);
		}
		else
		{
/************* added following if stmnt on 30.09.2003 *********/

		    if(! test_desc_fill_for_report.len)   
			{
			  sprintf(l_str,"%-40.40s",rl_tst_cd_short_desc.arr);
			}
			else
			 {
				if ((rl_tst_numeric_result.len) ||
					((rl_tst_result_comment_desc1.len || rl_tst_result_comment_desc2.len ||
						rl_tst_result_comment_desc3.len || rl_tst_result_comment_desc4.len)) &&
						(rl_tst_hide_rslt_comm_yn.arr[0] == 'N' || flag == 'L' || flag == 'K'))
				{
		              /* EXEC SQL SELECT RPAD(:rl_tst_cd_short_desc,35,:test_desc_fill_for_report) 
						   INTO :rl_tst_cd_short_desc
						   FROM DUAL; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 30;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = "select RPAD(:b0,35,:b1) into :b0  from DUAL ";
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )1107;
                sqlstm.selerr = (unsigned short)1;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&rl_tst_cd_short_desc;
                sqlstm.sqhstl[0] = (unsigned int  )43;
                sqlstm.sqhsts[0] = (         int  )0;
                sqlstm.sqindv[0] = (         void  *)0;
                sqlstm.sqinds[0] = (         int  )0;
                sqlstm.sqharm[0] = (unsigned int  )0;
                sqlstm.sqadto[0] = (unsigned short )0;
                sqlstm.sqtdso[0] = (unsigned short )0;
                sqlstm.sqhstv[1] = (         void  *)&test_desc_fill_for_report;
                sqlstm.sqhstl[1] = (unsigned int  )4;
                sqlstm.sqhsts[1] = (         int  )0;
                sqlstm.sqindv[1] = (         void  *)0;
                sqlstm.sqinds[1] = (         int  )0;
                sqlstm.sqharm[1] = (unsigned int  )0;
                sqlstm.sqadto[1] = (unsigned short )0;
                sqlstm.sqtdso[1] = (unsigned short )0;
                sqlstm.sqhstv[2] = (         void  *)&rl_tst_cd_short_desc;
                sqlstm.sqhstl[2] = (unsigned int  )43;
                sqlstm.sqhsts[2] = (         int  )0;
                sqlstm.sqindv[2] = (         void  *)0;
                sqlstm.sqinds[2] = (         int  )0;
                sqlstm.sqharm[2] = (unsigned int  )0;
                sqlstm.sqadto[2] = (unsigned short )0;
                sqlstm.sqtdso[2] = (unsigned short )0;
                sqlstm.sqphsv = sqlstm.sqhstv;
                sqlstm.sqphsl = sqlstm.sqhstl;
                sqlstm.sqphss = sqlstm.sqhsts;
                sqlstm.sqpind = sqlstm.sqindv;
                sqlstm.sqpins = sqlstm.sqinds;
                sqlstm.sqparm = sqlstm.sqharm;
                sqlstm.sqparc = sqlstm.sqharc;
                sqlstm.sqpadto = sqlstm.sqadto;
                sqlstm.sqptdso = sqlstm.sqtdso;
                sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			          rl_tst_cd_short_desc.arr[rl_tst_cd_short_desc.len] = '\0'; 
				      sprintf(l_str,"%-40.40s",rl_tst_cd_short_desc.arr);
				}
				else
					  sprintf(l_str,"%-40.40s",rl_tst_cd_short_desc.arr);
			 }
		}
	}
    else
        sprintf(l_str,"%-40s"," ");
		
	print_sub_sec(); //added for GHL-CRF-0452-DD-01

    strcpy(text_line,l_str);
    strcpy(test_description,l_str);

    if ((rl_tst_cd_numeric_result_yn.arr[0] == 'Y') &&
				(rl_num_result_hide_yn.arr[0]	== 'N'))
    {
	if (rl_tst_numeric_result.len)
	{
	
	/******** AGAINST SCF 042 OF QATAR ***********/
		something_to_print = 1;
		something_to_print_for_test = 1;


        if ( (atof(rl_tst_numeric_result.arr) < 1) && 
			(atof(rl_tst_numeric_result.arr) > 0) )
             put_zero_before_decimal();

	  numeric_value_flag = TRUE;

/*********** for adding zero after result if no fraction part **********/

	  strcpy(r_rslt.arr, rl_tst_numeric_result.arr);
	  r_rslt.len = strlen(r_rslt.arr);

	  add_zero_after_result();

	  strcpy(rl_tst_numeric_result.arr, r_rslt.arr);
	  rl_tst_numeric_result.len = strlen(rl_tst_numeric_result.arr);

	  if(rl_tst_numeric_prefix.arr[0] == '+')
	  {
             sprintf(l_str,"%s %-10s",l_str,rl_tst_numeric_result.arr);
      }
	  else
	  {
             sprintf(l_str,"%s%c%-10s",l_str,rl_tst_numeric_prefix.arr[0],rl_tst_numeric_result.arr);
      }
			
		  //added the below code for INT-CRF-BRU-LIS-006
		  get_function_ctl();
		  if(strcmp(rl_critical_result.arr,"Y")==0  & strcmp(rl_func_ctl.arr,"Y")==0 )
		  { 
		   // rtrim(l_str);
		   strcpy(l_critical_result.arr, rl_critical_result.arr);//added for MMS-RY-SCF-0062
			sprintf(l_str,"%s%-4s",l_str," **"); // modified on 16.02.2016  
			}
		   else
		  { 
		 	sprintf(l_str,"%s%-4.4s",l_str,"    "); // modified on 16.02.2016  
			}

		  //END INT-CRF-BRU-LIS-006
		  strcpy(l_str1,l_str);
          ltrim(l_str1);
          rtrim(l_str1);  

		  /**********
			THE BELOW PORTION IS COMMENTED ON 13/10/2003 BECAUSE
		  IF THE TEST_UNITS IS NOT MENIOTED AT THE TIME OF RELEASE OF RESULTS
			THEN THE TRANSACTION TABLE WILL NOT GET UPDATED WITH  TEST UNITS.
			LATER IF THEY DEFINED IN TEST CODE MASTER IT SHOULD NOT SHOW IN 
			QUERY SINCE IT MAY THE CR REPOSITORY**************
			 
		  if (strlen(rl_tst_cd_test_units.arr) == 0)
		  {
			strcpy(rl_tst_cd_test_units.arr,rl_tst_cd_test_units_2.arr);
			rl_tst_cd_test_units.len = strlen(rl_tst_cd_test_units.arr);
		  }
**************** upto here is commented ****************************/

/// 18.02.2006          sprintf(l_str,"%s%-10s",l_str,rl_tst_cd_test_units.arr);

			  get_test_units_desc_from_sy_uom(); //// 18.02.2006
			  sprintf(l_str,"%s%-10s",l_str,rl_tst_cd_test_units_desc.arr); /// 18.02.2006



/******** CORRECTED ON 17/02/2004 AGAINST HMC RL-11
		      if ((( rl_tst_range_low_v_nor.len  ||
                  rl_tst_range_high_v_nor.len )) &&
				  ((rl_pat_sex.arr[0] == 'M' || rl_pat_sex.arr[0] == 'F')))
****** UPTO HERE CORRECTED ON 17/02/2004 AGAINST HMC RL-11 *********/
		      if ( rl_tst_range_low_v_nor.len  ||
                  rl_tst_range_high_v_nor.len )
	           {
					  get_zero_prefix_for_range();

					  strcpy(r_rslt.arr, rl_tst_range_low_v_nor.arr);
					  r_rslt.len = strlen(r_rslt.arr);
					  add_zero_after_result();
					  strcpy(rl_tst_range_low_v_nor.arr, r_rslt.arr);
					  rl_tst_range_low_v_nor.len = strlen(rl_tst_range_low_v_nor.arr);
					
					  strcpy(r_rslt.arr, rl_tst_range_high_v_nor.arr);
  					  r_rslt.len = strlen(r_rslt.arr);
  					  add_zero_after_result();
					  strcpy(rl_tst_range_high_v_nor.arr, r_rslt.arr);
					  rl_tst_range_high_v_nor.len = strlen(rl_tst_range_high_v_nor.arr);
			
			      sprintf(l_str,"%s %-1s (%s - %s)",l_str,
						rl_high_low_ind.arr,
                     rl_tst_range_low_v_nor.arr,
                     rl_tst_range_high_v_nor.arr);
					 
					agesex_range_flag = TRUE;
               }

	          else
	         {
		       if(rl_tst_cd_range_cmt.len)
		       {
                 range_cmnt_print_flag = 'Y';
               } 
			   
			   /**************************** commented on 09/15/2020 as per Nandhini.
becaz it should not take the age sex range from master setup. 

			   else
			   { 
				
				 if ((!(rl_tst_range_low_v_nor.len)  &&
					!(rl_tst_range_high_v_nor.len) && 
					(rl_tst_cd_age_sex_range_yn.arr[0] == 'Y')) &&
					(rl_pat_sex.arr[0] == 'M' || rl_pat_sex.arr[0] == 'F'))
				 {
					fetch_age_sex_range();
					if( rl_tst_range_low_v_nor.len && rl_tst_range_high_v_nor.len )
					{
						  get_zero_prefix_for_range();

						  strcpy(r_rslt.arr, rl_tst_range_low_v_nor.arr);
						  r_rslt.len = strlen(r_rslt.arr);
 						  add_zero_after_result();
						  strcpy(rl_tst_range_low_v_nor.arr, r_rslt.arr);
						  rl_tst_range_low_v_nor.len = strlen(rl_tst_range_low_v_nor.arr);

						  strcpy(r_rslt.arr, rl_tst_range_high_v_nor.arr);
 						  r_rslt.len = strlen(r_rslt.arr);
  						  add_zero_after_result();
 						  strcpy(rl_tst_range_high_v_nor.arr, r_rslt.arr);
						  rl_tst_range_high_v_nor.len = strlen(rl_tst_range_high_v_nor.arr);
			

						
						sprintf(l_str,"%s %-1s (%s - %s)",l_str,
								rl_high_low_ind.arr,
                                rl_tst_range_low_v_nor.arr,
                                rl_tst_range_high_v_nor.arr);
					}
					agesex_range_flag = TRUE;
				 }				
				else if(rl_tst_cd_range_cmt_2.len)
				{
					strcpy(rl_tst_cd_range_cmt.arr,rl_tst_cd_range_cmt_2.arr);
					rl_tst_cd_range_cmt.len = strlen(rl_tst_cd_range_cmt.arr);
					range_cmnt_print_flag = 'Y';
				}
			  }
			  *********************************/
	        }
			
			
        strcpy(l_str1,l_str);
        ltrim(l_str1);
        rtrim(l_str1);

	if(group && !group_printed)
	{
	   print_group_test_desc();
	   group_printed = 1;
        }
	if (strcmp(rl_tst_group_test_code.arr,rl_tst_test_code.arr)!=0)//GHL-CRF-0489
	  print_grp_sub_sec();//GHL-CRF-0489
	next_line = 0;
	if(range_cmnt_print_flag == 'Y')
	{
	   if(strlen(rl_tst_cd_range_cmt.arr) <= ( 77 - strlen(l_str)))
	   {
	      sprintf(l_str,"%s%s",l_str,rl_tst_cd_range_cmt.arr);
        }
	   else
	      next_line = 1;
     }
      print_line(l_str);
	  test_printed  = 1;
	  if(next_line == 1)
	  {
	     sprintf(l_str,"%-37.37s%-40s"," ",rl_tst_cd_range_cmt.arr);
         print_line(l_str);
      }
     }
#ifdef DEBUG
       printf("In print_dtls numeric results \n");  
#endif
    }

	if (rl_num_result_hide_yn.arr[0] == 'N')
		print_past_results();   /////// 07.08.2004 added to print previous results based on setup


	if (strcmp(rl_tst_preliminary_release_yn.arr, "Y") == 0 && strcmp(rl_tst_status.arr,"A") == 0 ) 
	    print_prel_release_desc();	

    if(rl_tst_hide_rslt_comm_yn.arr[0] == 'N' || flag == 'L' || flag == 'K')
		print_comment_desc1234();


    //commented out for ML-MMOH-SCF-0934 and moved to before print_result_modify_reason()
	// print_test_method();  /// added on 19.05.2015 against HSA-CRF-0298,
	

     print_test_comments();

     if(rl_tst_cd_culture_test_yn.arr[0] == 'Y')
	 {

	/////	if (strcmp(rl_mic_to_print_yn.arr,"Y") == 0)  ///commented against bru-hims-crf-0050
			check_mic_value_present_for_test();
              // disp_message(ERR_MESG, "100");
 	    if (strcmp(rl_report_format.arr, "5") == 0 || strcmp(rl_report_format.arr, "6") == 0)   //// 01.08.2006  ////modified on 15.05.2014
		{
           if (strcmp(rl_customer_id.arr, "SHALM") == 0 || strcmp(rl_customer_id.arr, "WCH") == 0 || strcmp(rl_customer_id.arr, "SLY") == 0)  /// added this IF stmnt on 19.05.2015 against HSA-CRF-0298,added || for RF ML-MMOH-SCF-0691
			  print_culture_HSA();
		   else
		    print_culture_format5(); 
		}
		else
			print_culture();
	 }
	 
	 //added for MO-CRF-20134
	 if (strcmp(rl_customer_id.arr, "MOD") == 0)
	 {
	     open_bio_result_comment(); 
		 result_comment_biochem();
		 
		 open_bio_result_text(); 
		 splitting_biochem();
	 }
	 
	 //end MO-CRF-20134

     if (rl_tst_cd_text_block_yn.arr[0] == 'Y') /* optional result text */
     {
        open_result_text(); 
		 splitting();
     }

     if (rl_tst_cd_snomed_yn.arr[0] == 'Y') 	/*  optional snomed text */
	    print_snomed();
	 

/***************** added the below on 21.05.2005	  *******************/

	 if ((rl_tst_status.arr[0] == 'O') && (rl_tst_cd_profile_yn.arr[0] == 'Y'))
	 {
	   if(rl_print_pend_profile_yn.arr[0] == 'Y')  
	   {
		if(!something_to_print_for_test) 
		{
		    strcpy(l_str," ");
			sprintf(l_str,"%-40.40s",test_description); 
			

		    if(rl_tst_cd_print_report_yn.arr[0] == 'Y')  
			{
				if(group && !group_printed)  
				{
				  print_group_test_desc(); 
				  group_printed = 1;
				}
				if(rl_legend_for_pending.len)
				   sprintf(l_str,"%s %-35.35s",l_str,rl_legend_for_pending.arr);
				else
				   sprintf(l_str,"%s %-25.25s",l_str,"Pending.."); 

				something_to_print_for_test = 1;
				print_line(l_str); 
				test_printed = 1;
//				something_to_print = 1; // if all are pending and no other results in the specimen then it should not print.
			 }

		}		
	   }		   	
	 }
/*************** upto here added on 21.05.2005 ***********************/


    /* -------------- 25.05.2004 added below line -------------------------- */
     print_test_method(); //added for ML-MMOH-SCF-0934
	 print_result_modify_reason(); // to print modify reason if any and something_to_print_for_test = 1


     fflush(fp);  
	}
  }
}
/*-----------------------------------------------------*/
print_range_comment(int agesex_range_flag,int path_review_flag)
{
  if (rl_tst_cd_range_cmt.len) 	 /* optional Range comment */
    {
     if (agesex_range_flag == TRUE ||
	 path_review_flag == TRUE )
	 ;
     else
     {
       if(group && !group_printed)
       {
	  print_group_test_desc();
	  group_printed = 1;
       }
       if(test_printed)
       {  numeric_value_flag = TRUE;
          print_line_check(rl_tst_cd_range_cmt.arr);
       }
       else
       {
	  numeric_value_flag = FALSE;
	  sprintf(text_line,"%-37.37s%-40s",test_description,
				rl_tst_cd_range_cmt.arr);
	  print_line_check(text_line);
	  test_printed = 1;
       }
     }
    }
}

/*-----------------------------------------------------*/
//added for ML-MMOH-SCF-0934
get_next_test_method()
{


/*if(i_test_count==2)
l_mth_count=l_mth_count+2;
else
l_mth_count=l_mth_count+1;*/

l_mth_count=l_mth_count+1;

//sprintf(string_var,"l_mth_count: %d",l_mth_count);
	 //  disp_message(ERR_MESG, string_var);	
//disp_message(ERR_MESG, "1345");
/*EXEC SQL SELECT b.TEST_METHOD_CODE  INTO :rl_tst_test_method_code_t
			    FROM RL_INTERVAL_TEST_TEMP A, RL_TEST_RESULT B,RL_TEST_CODE C 
                WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id 
                 AND B.PATIENT_ID = :nd_hosp_no 
                 AND A.specimen_no = B.specimen_no 
                 AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id 
                 AND B.test_code = DECODE(A.test_code, NULL, B.test_code, A.test_code) 
                 AND B.group_test_code = A.group_test_code 
                 AND A.operating_facility_id = B.operating_facility_id 
                 AND NVL(B.cancelled_yn, 'N') <> 'Y' 
				 AND A.user_id = USER  
				 AND B.test_code = C.test_code 
				 AND A.session_id = USERENV('sessionid')
				 AND ROWNUM<=:l_mth_count
				 AND B.TEST_CODE NOT IN (:rl_tst_test_code) 
				 AND ROWNUM=1
                 ORDER BY B.SUB_SECTION_CODE,B.SUB_SECTION_CODE_IND,B.test_code;
		//sprintf(string_var,"rl_tst_test_method_code_t: %s %d",rl_tst_test_method_code_t.arr, l_mth_count);
	   //disp_message(ERR_MESG, string_var);		 
if (OERROR)
		 disp_message(ORA_MESG,"failed on table get_next_test_method()");*/



//disp_message(ERR_MESG, "1345");
/*EXEC SQL 		SELECT TEST_METHOD_CODE,TEST_CODE 
				INTO :rl_tst_test_method_code_t,:rl_tst_test_t
				FROM (select TEST_METHOD_CODE,TEST_CODE,ROWNUM R 
				FROM (SELECT b.TEST_METHOD_CODE ,B.TEST_CODE 
			    FROM RL_INTERVAL_TEST_TEMP A, RL_TEST_RESULT B,RL_TEST_CODE C 
                WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id 
                 AND B.PATIENT_ID = :nd_hosp_no 
                 AND A.specimen_no = B.specimen_no 
                 AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id 
                 AND B.test_code = DECODE(A.test_code, NULL, B.test_code, A.test_code) 
                 AND B.group_test_code = A.group_test_code 
                 AND A.operating_facility_id = B.operating_facility_id 
                 AND NVL(B.cancelled_yn, 'N') <> 'Y' 
				 AND A.user_id = USER  
				 AND B.test_code = C.test_code 
				 AND A.session_id = USERENV('sessionid')
				 //AND ROWNUM>=:l_mth_count
				 ORDER BY B.SUB_SECTION_CODE,B.SUB_SECTION_CODE_IND,B.GROUP_SEQ_NO,B.GROUP_TEST_CODE,B.TEST_SEQ_NO,B.tEST_CODE ))
				 where R=:l_mth_count;*/
		if (d_interval_specimen_yn=='Y')
		
		/* EXEC SQL SELECT NVL(TEST_METHOD_CODE,'!!!!'),TEST_CODE 
					INTO :rl_tst_test_method_code_t,:rl_tst_test_t
					FROM (select TEST_METHOD_CODE,TEST_CODE,ROWNUM R 
					FROM (SELECT b.TEST_METHOD_CODE ,B.TEST_CODE 
					FROM RL_INTERVAL_TEST_TEMP A, RL_TEST_RESULT B,RL_TEST_CODE C 
					WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id 
					 AND B.PATIENT_ID = :nd_hosp_no 
					 AND A.specimen_no = B.specimen_no 
					 AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id 
					 AND B.test_code = DECODE(A.test_code, NULL, B.test_code, A.test_code) 
					 AND B.group_test_code = A.group_test_code 
					 AND A.operating_facility_id = B.operating_facility_id 
					 AND NVL(B.cancelled_yn, 'N') <> 'Y' 
					 AND A.user_id = USER  
					 AND B.test_code = C.test_code 
					 AND A.session_id = USERENV('sessionid')
					 ORDER BY B.SUB_SECTION_CODE,B.SUB_SECTION_CODE_IND,B.test_code, B.specimen_no, B.GROUP_SEQ_NO,B.GROUP_TEST_CODE,B.TEST_SEQ_NO,B.TEST_CODE
					 ))
			 where R=:l_mth_count; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(TEST_METHOD_CODE,'!!!!') ,TEST_CODE into :b0,:b1\
  from (select TEST_METHOD_CODE ,TEST_CODE ,ROWNUM R  from (select b.TEST_METH\
OD_CODE ,B.TEST_CODE  from RL_INTERVAL_TEST_TEMP A ,RL_TEST_RESULT B ,RL_TEST_\
CODE C where ((((((((((A.OPERATING_FACILITY_ID=:b2 and B.PATIENT_ID=:b3) and A\
.specimen_no=B.specimen_no) and B.OPERATING_FACILITY_ID=:b2) and B.test_code=D\
ECODE(A.test_code,null ,B.test_code,A.test_code)) and B.group_test_code=A.grou\
p_test_code) and A.operating_facility_id=B.operating_facility_id) and NVL(B.ca\
ncelled_yn,'N')<>'Y') and A.user_id=USER) and B.test_code=C.test_code) and A.s\
ession_id=USERENV('sessionid')) order by B.SUB_SECTION_CODE,B.SUB_SECTION_CODE\
_IND,B.test_code,B.specimen_no,B.GROUP_SEQ_NO,B.GROUP_TEST_CODE,B.TEST_SEQ_NO,\
B.TEST_CODE ) ) where R=:b5";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1134;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&rl_tst_test_method_code_t;
  sqlstm.sqhstl[0] = (unsigned int  )6;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&rl_tst_test_t;
  sqlstm.sqhstl[1] = (unsigned int  )102;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_hosp_no;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_mth_count;
  sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	
			 
		else
		    //disp_message(ORA_MESG,"HERE");
		    /* EXEC SQL SELECT  NVL(TEST_METHOD_CODE,'!!!!'),TEST_CODE 
					INTO :rl_tst_test_method_code_t,:rl_tst_test_t
					FROM (select TEST_METHOD_CODE,TEST_CODE,ROWNUM R 
					FROM (SELECT b.TEST_METHOD_CODE ,B.TEST_CODE 
					FROM RL_INTERVAL_TEST_TEMP A, RL_TEST_RESULT B,RL_TEST_CODE C 
					WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id 
					 AND B.PATIENT_ID = :nd_hosp_no 
					 AND A.specimen_no = B.specimen_no 
					 AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id 
					 AND B.test_code = DECODE(A.test_code, NULL, B.test_code, A.test_code) 
					 AND B.group_test_code = A.group_test_code 
					 AND A.operating_facility_id = B.operating_facility_id 
					 AND NVL(B.cancelled_yn, 'N') <> 'Y' 
					 AND A.user_id = USER  
					 AND B.test_code = C.test_code 
					 AND A.session_id = USERENV('sessionid')
					 ORDER BY B.SUB_SECTION_CODE,B.SUB_SECTION_CODE_IND,B.GROUP_SEQ_NO,B.GROUP_TEST_CODE,B.TEST_SEQ_NO,B.TEST_CODE
					 ))
			 where R=:l_mth_count; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 30;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select NVL(TEST_METHOD_CODE,'!!!!') ,TEST_CODE into :b0\
,:b1  from (select TEST_METHOD_CODE ,TEST_CODE ,ROWNUM R  from (select b.TEST_\
METHOD_CODE ,B.TEST_CODE  from RL_INTERVAL_TEST_TEMP A ,RL_TEST_RESULT B ,RL_T\
EST_CODE C where ((((((((((A.OPERATING_FACILITY_ID=:b2 and B.PATIENT_ID=:b3) a\
nd A.specimen_no=B.specimen_no) and B.OPERATING_FACILITY_ID=:b2) and B.test_co\
de=DECODE(A.test_code,null ,B.test_code,A.test_code)) and B.group_test_code=A.\
group_test_code) and A.operating_facility_id=B.operating_facility_id) and NVL(\
B.cancelled_yn,'N')<>'Y') and A.user_id=USER) and B.test_code=C.test_code) and\
 A.session_id=USERENV('sessionid')) order by B.SUB_SECTION_CODE,B.SUB_SECTION_\
CODE_IND,B.GROUP_SEQ_NO,B.GROUP_TEST_CODE,B.TEST_SEQ_NO,B.TEST_CODE ) ) where \
R=:b5";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1173;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_tst_test_method_code_t;
      sqlstm.sqhstl[0] = (unsigned int  )6;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_tst_test_t;
      sqlstm.sqhstl[1] = (unsigned int  )102;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[2] = (unsigned int  )5;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_hosp_no;
      sqlstm.sqhstl[3] = (unsigned int  )33;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[4] = (unsigned int  )5;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_mth_count;
      sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	
			 
			 

if (OERROR)
		 disp_message(ORA_MESG,"failed on table get_next_test_method()");


}
//end ML-MMOH-SCF-0934
/*-----------------------------------------------------*/
//commented out for ML-MMOH-SCF-0934
/*print_test_method()
{
  if (rl_print_test_method_yn.arr[0] == 'Y' )
  {
   if (rl_tst_test_method_code.len)
   {
	if(strcmp(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr) !=0)
	{
	 // fprintf(fp,"(Test Method:%s)\n",rl_test_method_desc.arr);

	  get_test_method_description();

///////////////

       if(group && !group_printed)
       {
		  print_group_test_desc();
		  group_printed = 1;
       }
       if(test_printed)
       {  
		  numeric_value_flag = TRUE;

		  sprintf(text_line,"(Test Method:%s)",rl_test_method_desc.arr);

		  strcpy(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr);

    ///      print_line_check(text_line);
	      print_line(text_line);

       }
       else
       {
		  numeric_value_flag = FALSE;

		  sprintf(text_line,"%-37.37s",test_description);
		  print_line_check(text_line);

		  sprintf(text_line,"(Test Method:%s)",rl_test_method_desc.arr);

		  strcpy(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr);

		  print_line(text_line);

		  test_printed = 1;
       }




///////////////////

///	  sprintf(text_line,"(Test Method:%s)",rl_test_method_desc.arr);
///	  print_line(text_line);
	  
///	  strcpy(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr);
    }
   }
  }
}*/
//commented end ML-MMOH-SCF-0934

/*------------------------------------------------------*/
//added for ML-MMOH-SCF-0934
print_test_method()
{//4
 // l_mth_count=l_mth_count+1;
  l_mth_count1=l_mth_count1+1;
 // sprintf(string_var,"rl_tst_test_method: %s",rl_tst_test_method_code.arr);
  // disp_message(ERR_MESG, string_var);
  //sprintf(string_var,"test_count: %d",i_test_count);
	  // disp_message(ERR_MESG, string_var);
  //sprintf(string_var,"rl_tst_test_code: %s %d",rl_tst_test_code.arr, l_mth_count1);
	 //  disp_message(ERR_MESG, string_var);	
  if (rl_print_test_method_yn.arr[0] == 'Y' )
  {//3
  get_next_test_method();
   if (rl_tst_test_method_code.len)
   {//2
  
  //  sprintf(string_var,"rl_tst_test_method123: %s",rl_tst_test_method_code.arr);
  // disp_message(ERR_MESG, string_var);
	
	
	
	// sprintf(string_var,"rl_tst_test_method_code_t: %s %s",rl_tst_test_method_code_t.arr, rl_tst_test_method_code.arr);
   //disp_message(ERR_MESG, string_var);
	if(strcmp(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr) !=0)
	{//1
	 // disp_message(ERR_MESG, "34");
	  get_test_method_description();
	///////////////

       if(group && !group_printed)
       {
		  print_group_test_desc();
		  group_printed = 1;
       }
       if(test_printed)
       {  
		  //disp_message(ERR_MESG, "3");
		  numeric_value_flag = TRUE;
		  	
		  sprintf(text_line,"(Test Method:%s)",rl_test_method_desc.arr);

		  //strcpy(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr);

    ///      print_line_check(text_line);
	      print_line(text_line);

       }
       else
       {
		//disp_message(ERR_MESG, "4");
		  numeric_value_flag = FALSE;

		  sprintf(text_line,"%-37.37s",test_description);
		  print_line_check(text_line);

		  sprintf(text_line,"(Test Method:%s)",rl_test_method_desc.arr);

		  //strcpy(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr);

		  print_line(text_line);

		  test_printed = 1;
       }


    //}

///////////////////

///	  sprintf(text_line,"(Test Method:%s)",rl_test_method_desc.arr);
///	  print_line(text_line);
	  
///	  strcpy(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr);
	}//1
   
	else
	{
	//disp_message(ERR_MESG, "6");
	 if(i_test_count==l_mth_count1)
	 {
		//disp_message(ERR_MESG, "7");
		get_test_method_description();
		sprintf(text_line,"(Test Method:%s)",rl_test_method_desc.arr);

		 // strcpy(rl_tst_test_method_code_t.arr,rl_tst_test_method_code.arr);

		  print_line(text_line);

		  test_printed = 1;
	 }
	 }
   }//2

   }//3
  
}//4
  
//end ML-MMOH-SCF-0934
/*------------------------------------------------------*/
//ADDED FOR GHL-CRF-0452-DD-01
print_sub_sec()
{
  
   if (rl_tst_test_sub_sec.len)
   {
	if(strcmp(rl_tst_test_sub_sec_t.arr,rl_tst_test_sub_sec.arr) !=0)
	{
	 	  get_sub_sec_description();
       /*if(group && !group_printed)
       {
		  print_group_test_desc();
		  group_printed = 1;
       }*/
       if(test_printed)
       {  
		  numeric_value_flag = TRUE;

		 
		//  sprintf(text_line,"Sub Section:%s",rl_sub_sec_desc.arr);
		sprintf(text_line,"%s",rl_sub_sec_desc.arr);
		  strcpy(rl_tst_test_sub_sec_t.arr,rl_tst_test_sub_sec.arr);

    ///      print_line_check(text_line);
	      print_line(text_line);

       }
       else
       {
		  numeric_value_flag = FALSE;

		 // sprintf(text_line,"%-37.37s",test_description);
		  //print_line_check(text_line);

		  
		  //sprintf(text_line,"Sub Section:%s",rl_sub_sec_desc.arr);
		  sprintf(text_line,"%s",rl_sub_sec_desc.arr);
		  strcpy(rl_tst_test_sub_sec_t.arr,rl_tst_test_sub_sec.arr);

		  print_line(text_line);

		  //test_printed = 1; //commented out for IN-67057
       }




///////////////////



///	  print_line(text_line);
	  
///	  strcpy(rl_tst_test_sub_sec_t.arr,rl_tst_test_sub_sec.arr);
    }
   }
  
}

print_grp_sub_sec()
{
  
   //sprintf(string_var,"sub %s %s ",rl_grp_tst_test_sub_sec.arr, rl_grp_tst_test_sub_sec.arr);
  // disp_message(ERR_MESG, string_var);
   if (rl_grp_tst_test_sub_sec.len)
   {
	if(strcmp(rl_grp_tst_test_sub_sec_t.arr,rl_grp_tst_test_sub_sec.arr) !=0)
	{
	 	  get_grp_tst_sub_sec_description();
       /*if(group && !group_printed)
       {
		  print_group_test_desc();
		  group_printed = 1;
       }*/
       if(test_printed)
       {  
		  numeric_value_flag = TRUE;

		 
		//  sprintf(text_line,"Sub Section:%s",rl_sub_sec_desc.arr);
		sprintf(text_line,"%s",rl_sub_sec_desc.arr);
		  strcpy(rl_grp_tst_test_sub_sec_t.arr,rl_grp_tst_test_sub_sec.arr);

    ///      print_line_check(text_line);
	      print_line(text_line);

       }
       else
       {
		  numeric_value_flag = FALSE;

		 // sprintf(text_line,"%-37.37s",test_description);
		  //print_line_check(text_line);

		  
		  //sprintf(text_line,"Sub Section:%s",rl_sub_sec_desc.arr);
		  sprintf(text_line,"%s",rl_sub_sec_desc.arr);
		  strcpy(rl_grp_tst_test_sub_sec_t.arr,rl_grp_tst_test_sub_sec.arr);

		  print_line(text_line);

		  //test_printed = 1; //commented out for IN-67057
       }




///////////////////



///	  print_line(text_line);
	  
///	  strcpy(rl_tst_test_sub_sec_t.arr,rl_tst_test_sub_sec.arr);
    }
   }
  
}




/*------------------------------------------------------------*/

get_test_method_description()
{
	rl_test_method_desc.arr[0]		= '\0';
	rl_test_method_desc.len		= 0;

	/* EXEC SQL SELECT long_desc  //changed short_desc to long_desc for ML-MMOH-CRF-0788
			 INTO :rl_test_method_desc
			 FROM RL_TEST_METHODS
			 WHERE test_method_code = :rl_tst_test_method_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_TEST_METHODS where test_m\
ethod_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1212;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_test_method_desc;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_tst_test_method_code;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




	if (NODATAFOUND)
	{
	  strcpy(rl_test_method_desc.arr,rl_tst_test_method_code.arr);
	  rl_test_method_desc.len = strlen(rl_test_method_desc.arr);
	}

	if (OERROR)
	  strcpy(rl_test_method_desc.arr,rl_tst_test_method_code.arr);


//    rl_test_method_desc.len = strlen(rl_test_method_desc.arr);
    rl_test_method_desc.arr[rl_test_method_desc.len]		= '\0';
         
}
/*-----------------------------------------------------*/

/*-----------------------------------------------------*/
//added for GHL-CRF-0452-DD-01
get_sub_sec_description()
{
	rl_sub_sec_desc.arr[0]		= '\0';
	rl_sub_sec_desc.len		= 0;

	/* EXEC SQL SELECT LONG_NAME  
			 INTO :rl_sub_sec_desc
			 FROM RL_SUB_SECTION_CODE
			 WHERE SECTION_CODE=:rl_hdr_section_code
			 AND SUB_SECTION_CODE = :rl_tst_test_sub_sec; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_NAME into :b0  from RL_SUB_SECTION_CODE where (S\
ECTION_CODE=:b1 and SUB_SECTION_CODE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1235;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_sub_sec_desc;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_hdr_section_code;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_tst_test_sub_sec;
 sqlstm.sqhstl[2] = (unsigned int  )6;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




	if (NODATAFOUND)
	{
	  strcpy(rl_sub_sec_desc.arr,rl_tst_test_sub_sec.arr);
	  rl_sub_sec_desc.len = strlen(rl_sub_sec_desc.arr);
	}

	if (OERROR)
	  strcpy(rl_sub_sec_desc.arr,rl_tst_test_sub_sec.arr);


//    rl_sub_sec_desc.len = strlen(rl_sub_sec_desc.arr);
    rl_sub_sec_desc.arr[rl_sub_sec_desc.len]		= '\0';
         
}

/*-----------------------------------------------------*/

get_grp_tst_sub_sec_description()
{
	rl_sub_sec_desc.arr[0]		= '\0';
	rl_sub_sec_desc.len		= 0;

	/* EXEC SQL SELECT LONG_NAME//SUB_SECTION_CODE //LONG_NAME
			 INTO :rl_sub_sec_desc
			 FROM RL_SUB_SECTION_CODE
			 WHERE SECTION_CODE=:rl_hdr_section_code
			 AND SUB_SECTION_CODE = :rl_grp_tst_test_sub_sec; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_NAME into :b0  from RL_SUB_SECTION_CODE where (S\
ECTION_CODE=:b1 and SUB_SECTION_CODE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1262;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_sub_sec_desc;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_hdr_section_code;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_grp_tst_test_sub_sec;
 sqlstm.sqhstl[2] = (unsigned int  )6;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




	if (NODATAFOUND)
	{
	  strcpy(rl_sub_sec_desc.arr,rl_grp_tst_test_sub_sec.arr);
	  rl_sub_sec_desc.len = strlen(rl_sub_sec_desc.arr);
	}

	if (OERROR)
	  strcpy(rl_sub_sec_desc.arr,rl_grp_tst_test_sub_sec.arr);


//    rl_sub_sec_desc.len = strlen(rl_sub_sec_desc.arr);
    rl_sub_sec_desc.arr[rl_sub_sec_desc.len]		= '\0';
         
}
/*-----------------------------------------------------*/

print_test_comments()
{

  if (something_to_print ==  0 )
  {
	check_any_res_comp();

  }
  else
    other_than_comments = 1;


  if (other_than_comments > 0)
  {
	open_comments();
   while(fetch_comments())
  {
  if (rl_comm_for_test_com_text.len)
     {
       if(group && !group_printed)
       {
	  print_group_test_desc();
	  group_printed = 1;
       }
       if(test_printed)
       {  
		  numeric_value_flag = TRUE;
          print_line_check(rl_comm_for_test_com_text.arr);

       }
       else
       {
	  numeric_value_flag = FALSE;
	  sprintf(text_line,"%-37.37s%s",test_description,
			    rl_comm_for_test_com_text.arr);
	  print_line_check(text_line);
	  test_printed = 1;
       }
     }

	}
  }
}
/*-----------------------------------------------------*/

print_result_text()
{
   if(rl_res_result_text1.len || rl_res_result_text2.len || 
      rl_res_result_text3.len || rl_res_result_text4.len || 
      rl_res_result_text5.len || rl_res_result_text6.len || 
      rl_res_result_text7.len || rl_res_result_text8.len || 
      rl_res_result_text9.len || rl_res_result_text10.len )
   {
      if(group && !group_printed)
      {   print_group_test_desc();
	  group_printed = 1;
      }
      if(!test_printed  && strlen(test_description))
      {     numeric_value_flag = FALSE;  
	    sprintf(text_line,"%37.37s%-40s",test_description," ");
            print_line_check(text_line);
	    test_printed = 1;
      }
   
    		if (rl_res_result_text1.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		  	print_line(rl_res_result_text1.arr);
		  }
    		if (rl_res_result_text2.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		        print_line(rl_res_result_text2.arr);
		  }
    		if (rl_res_result_text3.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		  	 print_line(rl_res_result_text3.arr);
		  }
    		if (rl_res_result_text4.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text4.arr);
		  }
    		if (rl_res_result_text5.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text5.arr);
		  }
    		if (rl_res_result_text6.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text6.arr);
		  }
    		if (rl_res_result_text7.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text7.arr);
		  }
    		if (rl_res_result_text8.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text8.arr);
		  }
    		if (rl_res_result_text9.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		   	print_line(rl_res_result_text9.arr);
		  }
    		if (rl_res_result_text10.len)
		  {
		  	fprint_repeat(fp,' ',8);		   
		  	print_line(rl_res_result_text10.arr);
		  }
            	fflush(fp);
   }
}
/*-----------------------------------------------------*/
print_line(char *t_str)
{
         fprintf(fp,"%s%c%c%c%c%c%c\n",t_str,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
         page_break(1);
}
/*-----------------------------------------------------*/
print_line_check(char *t_str)
{
       if (numeric_value_flag == TRUE)
	  {
	  fprint_repeat(fp,' ',37);
	  print_line(t_str);
	  numeric_value_flag = TRUE;
	  }
       else  
         {
	   print_line(t_str);
	   numeric_value_flag = TRUE;
	 }
}
/*-----------------------------------------------------*/

print_snomed()
{
int ctr = 0;
char prev_snomed_print_yn = 'N';
    open_result_snomed();
	l_snomed_head_printed = 0;
    while (fetch_rl_result_snomed())
    {
        if (fetch_snomed_desc12345())   
        {


	/***** NEWLY ADDED   *************/
		get_desc_snomed2();

 /************   CHANGED FOR KNDV ENHANCEMENTS    ***********/
//            if (rl_snomed_print_yn.arr[0] == 'Y' || flag == 'L' )
            if ( (rl_snomed_print_yn.arr[0] == 'Y' ) || (rl_snomed2_print_yn.arr[0] == 'Y' ) ||
					 flag == 'L' || flag == 'K')
            {   
					print_snomed_desc12345();
			}
			else
			{
				if(group && !group_printed)
				{ 
				  print_group_test_desc();
				  group_printed = 1;
                 }
				if(!test_printed)
				{
					fprintf(fp,"%-37.37s%c%c%c%c%c%c\n",test_description,
							rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
						test_printed = 1;
				}

				print_str('Y');
				if (l_snomed_head_printed) 
				{
					fprintf(fp, "\n");
					page_break(1);
				}

/************ added on 20.07.2004 **************/

			    if (rl_res_snomed_mrkr_code1.len != 0) 
				{
				    get_snomed_marker_desc1();
					print_snomed_marker1();
				}
				if (rl_res_snomed_mrkr_code2.len != 0) 
				{
				    get_snomed_marker_desc2();
					print_snomed_marker2();
				}


/****************************** commented since new procedure print_str is added on 
		//     02/11/2002 for snomed code to be print y/n

					print_snomed_codes('Y');

				if (strlen(rl_res_snomed_code2.arr) > 0 )
				{

					fprintf(fp,"%c%c%c%c%c%c", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);
				}

					fprintf(fp, "\n");
					page_break(1);

******************************/				  

             }
			ctr++;
        }
    }
}
/*-----------------------------------------------------*/

open_result_snomed()
{
    /* EXEC SQL OPEN RL_RESULT_SNOMED_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0031;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1289;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_RESULT_SNOMED_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_rl_result_snomed()
{
#ifdef DEBUG
       printf("In fetch_rl_result_snomed() \n");
#endif
    rl_res_snomed_code.arr[0]     = '\0';
	rl_res_snomed_code2.arr[0]	  = '\0';
	rl_res_snomed_mrkr_code1.arr[0]	  = '\0';
	rl_res_snomed_mrkr_code2.arr[0]	  = '\0';

    rl_res_snomed_code.len        = 0;
	rl_res_snomed_code2.len		  = 0;

	rl_res_snomed_mrkr_code1.len		  = 0;
	rl_res_snomed_mrkr_code2.len		  = 0;


    /* EXEC SQL FETCH RL_RESULT_SNOMED_CUR
              INTO :rl_res_snomed_code,
				   :rl_res_snomed_code2,
				   :rl_res_snomed_mrkr_code1,
				   :rl_res_snomed_mrkr_code2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1324;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_snomed_code;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_res_snomed_code2;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_res_snomed_mrkr_code1;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_res_snomed_mrkr_code2;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_RESULT_SNOMED_CUR",0,"");

    rl_res_snomed_code.arr[rl_res_snomed_code.len]		= '\0';
	rl_res_snomed_code2.arr[rl_res_snomed_code2.len]	= '\0';
	rl_res_snomed_mrkr_code1.arr[rl_res_snomed_mrkr_code1.len]	= '\0';
	rl_res_snomed_mrkr_code2.arr[rl_res_snomed_mrkr_code2.len]	= '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
print_culture()
{

    char temp_sens_ind;
    char temp_line[801];
	char org[MAX_ORGANISMS][5];
	char l_char_str[20];
    int still_org_dtl_left;
    int print_anti_flag = 0;
    int change_flag = 0;
	int e = 0;
    int anti_flag = 0;
    int c = 0, s = 0;
	int no_of_organisms = 0;
    int oflag = 1;
	int match_found = 0;

    open_result_organism();
    while(fetch_result_org())
    {

	/***** ADDED FOR SCF42 OF QATAR *****/		
		something_to_print = 1;
		something_to_print_for_test = 1;

		strcpy(org[no_of_organisms],rl_res_organism_code.arr);
	    no_of_organisms++;

		if(group && !group_printed)
		{
			print_group_test_desc();
			group_printed = 1;
		}
		if(!test_printed)
		{
			sprintf(text_line,"%-40.40s",test_description);
			print_line(text_line);
			test_printed = 1;
		}

		if(oflag)
		{
			sprintf(text_line,"%-46.46s%-34.34s","ORGANISM","COMMENTS");
			print_line(text_line);

			sprintf(text_line,"");
			for(c=0;c<80;c++)
				sprintf(text_line,"%s%s",text_line,"-");
			print_line(text_line); 
			oflag = 0;
		} 

		fetch_org_desc();

		 /*Added Condition for crf20281 by srinivas*/
		if (strcmp(rl_res_hide_organism_yn.arr,"Y") == 0)
       	   
             sprintf(text_line,"(%-4.4s) %-40.40s%-34.34s",rl_res_organism_code.arr,
							rl_res_organism_code_desc.arr,rl_res_comment_desc.arr);
	
        else
			sprintf(text_line,"%-4.4s %-40.40s%-34.34s",rl_res_organism_code.arr,
									rl_res_organism_code_desc.arr,rl_res_comment_desc.arr);

		
		print_line(text_line);
	} 

	if(no_of_organisms)
	{

		/***** ADDED FOR SCF42 OF QATAR *****/		
		something_to_print = 1;
		something_to_print_for_test = 1;

		sprintf(text_line,"");
		for(c=0;c<80;c++)
			sprintf(text_line,"%s%s",text_line,"-");
		print_line(text_line);

/*** 07.08.2004 *******/
//		sprintf(text_line,"%-30.30s","ANTIBIOTIC ");
//		for(c=0;c<no_of_organisms;c++)	/* Print organism codes as column headings*/
//			sprintf(text_line,"%s%-5.5s",text_line,org[c]);
//		print_line(text_line);
//
//		sprintf(text_line,"");
//		for(c=0;c<80;c++)
//			sprintf(text_line,"%s%s",text_line,"-");
//		print_line(text_line);
/* ********* */

		open_sensitivity();  
		fetch_sensitivity(); 

		l_should_anti_flag = 0;

		
		open_antibiotic();
		t_antib_head_first_time = 0;
		while(fetch_antibiotic())
		{
////////////////////
			if (t_antib_head_first_time == 0) 
			{
				sprintf(text_line,"%-31.31s","ANTIBIOTIC ");
				for(c=0;c<no_of_organisms;c++)	/* Print organism codes as column headings*/
				{
						sprintf(text_line,"%s%-8.8s",text_line,org[c]);
				}

				print_line(text_line);
		
				sprintf(text_line,"");
				for(c=0;c<80;c++)
					sprintf(text_line,"%s%s",text_line,"-");
				print_line(text_line);				

			    t_antib_head_first_time = 1;
			}
////////////////////
			strcpy(text_line, "");

	/***** ADDED FOR SCF42 OF QATAR *****/		
		something_to_print = 1;
		something_to_print_for_test = 1;

			strcpy(rl_res_dtl_antibiotic_code.arr,a_antibiotic_code.arr);
			rl_res_dtl_antibiotic_code.len = strlen(a_antibiotic_code.arr);
			fetch_antibiotic_desc();
// changed on 09/10/2003 by C. Dinesh since the antibiotic description
//	should not show if the organism is to be hide 
	strcpy(text_line_temp2, "");
	sprintf(text_line_temp2,"%-31.31s",rl_res_dtl_antibiotic_desc.arr);
//		    sprintf(text_line,"%-31.31s",rl_res_dtl_antibiotic_desc.arr);


			get_kb_mic_legend(no_of_organisms, 'L');
			sprintf(text_line1,"%-31.31s", l_kb_mic_legend);
		
		
			l_print_anti_flag = 0;
			l_anti_flag = 0;

			for(e=0;e<no_of_organisms;e++)
			{
				match_found = 0;
				
				for(s=0; s<no_of_sensitivities; s++)
				{
					

						if (l_print_anti_flag == 0)
						{
							sprintf(text_line, "%s%s", text_line, text_line_temp2);
							strcpy(text_line_temp2, "");
							l_print_anti_flag = 1;
						}


					if( (strcmp(s_ant[s].arr, a_antibiotic_code.arr) == 0) &&
						(strcmp(s_org[s].arr, org[e]) == 0) )
					{

						match_found = 1;
						l_should_anti_flag = 1;
						l_anti_flag = 1;

//sprintf(string_var, " Report  %c   Ind   %c", s_rep[s].arr[0], s_ind[s].arr[0]);
//disp_message(ERR_MESG, string_var);

					    if(s_rep[s].arr[0] == 'Y')
						{
						   
						   sprintf(l_char_str, "%s", s_ind[s].arr);
						   sprintf(text_line,"%s%-8.8s",text_line, l_char_str);

/////						 if (strlen(s_mic[s].arr) > 0)
						 if (strlen(s_mic[s].arr) > 0 && (strcmp(s_mic_print_yn[s].arr, "Y") == 0))  /// modified against bru-hims-crf-0050
						 {
							 sprintf(l_char_str, "%-9.9s", s_mic[s].arr);
					//		 strcpy(l_kb_mic_legend,"MIC Value");
					//		 sprintf(text_line1,"%-39.39s", l_kb_mic_legend);
							 sprintf(text_line1,"%s%-8.8s",text_line1,l_char_str);
							 
						 }
						 /************************
						 else if (strlen(s_zone[s].arr) > 0)
						 {
							sprintf(l_char_str, "%-5.5s", s_zone[s].arr);
							sprintf(text_line1,"%s%-8.8s",text_line1, l_char_str);
						 }
						 ******************************/
						 else
						 {
							sprintf(text_line1,"%s%-8.8s",text_line1," ");
						 }


						}
						else// TO BE CHECKED LAXMAN
						{
							
						   strcpy(l_char_str, "");

						   sprintf(l_char_str, "(%s)", s_ind[s].arr);
						   sprintf(text_line,"%s%-8.8s",text_line, l_char_str);

   						   if (strlen(s_mic[s].arr) > 0 && (strcmp(s_mic_print_yn[s].arr, "Y") == 0) )   /// modified against bru-hims-crf-0050
						   {
							 sprintf(l_char_str, "(%-9.9s)", s_mic[s].arr);
					//		 strcpy(l_kb_mic_legend,"MIC Value");
					//		 sprintf(text_line1,"%-39.39s", l_kb_mic_legend);
							 sprintf(text_line1,"%s%-8.8s",text_line1, l_char_str);
                           }     
						   /******************************************
                           else if (strlen(s_zone[s].arr) > 0)
						   {
							 sprintf(l_char_str, "(%-5.5s)", s_zone[s].arr);
							 sprintf(text_line1,"%s%-8.8s",text_line1, l_char_str);
                           }     
							****************************/
						   strcpy(l_char_str, "");						   

						} 
						break;
					}
				}

				if(match_found == 0)
				{
	               sprintf(text_line,"%s        ",text_line);
				   sprintf(text_line1,"%s        ",text_line1);
				}

			}

			if (l_anti_flag == 1)
			{


					sprintf(text_line,"%-80.80s",text_line);			
					print_line(text_line);

					sprintf(text_line1,"%-80.80s",text_line1);			
					print_line(text_line1);

/************************** commented below and added above against BRU-HIMS-CRF-0050 on 04.12.2012
				if ( (strcmp(rl_mic_to_print_yn.arr,"Y") == 0) && mic_count > 0)
                {

					sprintf(text_line,"%-80.80s",text_line);			
					print_line(text_line);

					sprintf(text_line1,"%-80.80s",text_line1);			
					print_line(text_line1);

				}
				else
				{ 
					sprintf(text_line,"%-80.80s",text_line);			
					print_line(text_line);
					//sprintf(text_line1,"%-80.80s",text_line1);			
					//print_line(text_line1);

				}
*************************************/
			}

		}

		if (l_should_anti_flag == 1)
		{
			sprintf(text_line,"");
			
//			for(c=0;c<80;c++)
//				sprintf(text_line,"%s%s",text_line,"-");
	
			sprintf(text_line,"%-29.29s%-52.52s"," ","S - Sensitive     R - Resistant   I - Intermediate");
			print_line(text_line);

			sprintf(text_line,"");
			for(c=0;c<80;c++)
				sprintf(text_line,"%s%s",text_line,"-");

			print_line(text_line);

		}

	}
}
/*-----------------------------------------------------*/

print_culture_HSA()
{

    char temp_sens_ind;
    char temp_line[801];
	char org[MAX_ORGANISMS][5];
	char l_char_str[20];
    int still_org_dtl_left;
    int print_anti_flag = 0;
    int change_flag = 0;
	int e = 0;
    int anti_flag = 0;
    int c = 0, s = 0, c1 = 0, d = 0;
	int no_of_organisms = 0;
    int oflag = 1;
	int match_found = 0;

    open_result_organism();
    while(fetch_result_org())
    {

	/***** ADDED FOR SCF42 OF QATAR *****/		
		something_to_print = 1;
		something_to_print_for_test = 1;

		strcpy(org[no_of_organisms],rl_res_organism_code.arr);
	    no_of_organisms++;

		if(group && !group_printed)
		{
			print_group_test_desc();
			group_printed = 1;
		}
		if(!test_printed)
		{
			sprintf(text_line,"%-40.40s",test_description);
			print_line(text_line);
			test_printed = 1;
		}

		if(oflag)
		{
			sprintf(text_line,"%-46.46s%-34.34s","ORGANISM","COMMENTS");
			print_line(text_line);

			sprintf(text_line,"");
			for(c=0;c<80;c++)
				sprintf(text_line,"%s%s",text_line,"-");
			print_line(text_line); 
			oflag = 0;
		} 

		fetch_org_desc();

		 /*Added Condition for crf20281 by srinivas*/
		if (strcmp(rl_res_hide_organism_yn.arr,"Y") == 0)
       	   
             sprintf(text_line,"(%-4.4s) %-40.40s%-34.34s",rl_res_organism_code.arr,
							rl_res_organism_code_desc.arr,rl_res_comment_desc.arr);
	
        else
			sprintf(text_line,"%-4.4s %-40.40s%-34.34s",rl_res_organism_code.arr,
									rl_res_organism_code_desc.arr,rl_res_comment_desc.arr);

		
		print_line(text_line);
	} 

	if(no_of_organisms)
	{

		/***** ADDED FOR SCF42 OF QATAR *****/		
		something_to_print = 1;
		something_to_print_for_test = 1;

		sprintf(text_line,"");

		for(c=0;c<80;c++)
			sprintf(text_line,"%s%s",text_line,"-");
		print_line(text_line);

/*** 07.08.2004 *******/
//		sprintf(text_line,"%-30.30s","ANTIBIOTIC ");
//		for(c=0;c<no_of_organisms;c++)	/* Print organism codes as column headings*/
//			sprintf(text_line,"%s%-5.5s",text_line,org[c]);
//		print_line(text_line);
//
//		sprintf(text_line,"");
//		for(c=0;c<80;c++)
//			sprintf(text_line,"%s%s",text_line,"-");
//		print_line(text_line);
/* ********* */


//disp_message(ERR_MESG, "1");
    c1 == 0;
	while(c1<no_of_organisms)		/* Print all organism codes with 2 sets */
    {	


//sprintf(string_var, " organism loop  %d=", c1);

//disp_message(ERR_MESG, "111");
   
		open_sensitivity();  
		fetch_sensitivity(); 

		l_should_anti_flag = 0;

		
		open_antibiotic();
		t_antib_head_first_time = 0;
		while(fetch_antibiotic())
		{
//disp_message(ERR_MESG, "fetch antibiotic "); 
////////////////////

			get_kb_mic_legend(no_of_organisms, 'L');

//sprintf(string_var, " organism loop%sAAA", l_kb_mic_legend);
//disp_message(ERR_MESG, string_var); 

            ltrim(l_kb_mic_legend);
			rtrim(l_kb_mic_legend);

			//if ( ! strcmp(l_kb_mic_legend,"") == 0)//commented for RF ML-MMOH-SCF-0691
			//{//commented for RF ML-MMOH-SCF-0691
///sprintf(string_var, "loop%sAAA", l_kb_mic_legend);
///disp_message(ERR_MESG, string_var);  
			   strcpy(l_kb_mic_legend,"MIC");
			   
			   ltrim(rl_mic_value_uom.arr);
			   rtrim(rl_mic_value_uom.arr);
			   
			   if(rl_mic_value_uom.len)
				   sprintf(l_kb_mic_legend,"%s(%s)",l_kb_mic_legend,rl_mic_value_uom.arr); 	
			//} //commented for RF ML-MMOH-SCF-0691

			if (t_antib_head_first_time == 0) 
			{
			    sprintf(text_line,"%s","");
				for(c=0;c<80;c++)
					sprintf(text_line,"%s%s",text_line,"-");
				print_line(text_line);

				sprintf(text_line,"%-31.31s","ANTIBIOTIC ");

		///		for(c=0;c<no_of_organisms;c++)	/* Print organism codes as column headings*/

				for(d=c1;d<c1+2;d++)	/* Print 2 organism codes as column headings*/
				{

//sprintf(string_var, " organism loop%sAAA", org[d]);
//disp_message(ERR_MESG, string_var); 

						if( strcmp(org[d],"") == 0 )       ///// aded on 10.06.2015 to avoid 2 times MIC heading when there is 1 org
						   strcpy(l_kb_mic_legend,"  ");

						sprintf(text_line,"%s%-8.8s%-12.12s",text_line,org[d],l_kb_mic_legend);

				}

				print_line(text_line); 
		
				sprintf(text_line,"");
				for(c=0;c<80;c++)
					sprintf(text_line,"%s%s",text_line,"-");
				print_line(text_line);				

			    t_antib_head_first_time = 1;
			}
////////////////////
			strcpy(text_line, "");

	/***** ADDED FOR SCF42 OF QATAR *****/		
		something_to_print = 1;
		something_to_print_for_test = 1;

			strcpy(rl_res_dtl_antibiotic_code.arr,a_antibiotic_code.arr);
			rl_res_dtl_antibiotic_code.len = strlen(a_antibiotic_code.arr);
			fetch_antibiotic_desc();

// changed on 09/10/2003 by C. Dinesh since the antibiotic description
//	should not show if the organism is to be hide 

	strcpy(text_line_temp2, "");
	sprintf(text_line_temp2,"%-31.31s",rl_res_dtl_antibiotic_desc.arr);

//		    sprintf(text_line,"%-31.31s",rl_res_dtl_antibiotic_desc.arr);


//////			get_kb_mic_legend(no_of_organisms, 'L');
//////			sprintf(text_line1,"%-31.31s", l_kb_mic_legend);
		
		
			l_print_anti_flag = 0;
			l_anti_flag = 0;

/////////			for(e=0;e<no_of_organisms;e++)

			for(e=c1;e<c1+2;e++)
			{
//disp_message(ERR_MESG, "3");
				match_found = 0;
				
				for(s=0; s<no_of_sensitivities; s++)
				{
					

						if (l_print_anti_flag == 0)
						{
							sprintf(text_line, "%s%s", text_line, text_line_temp2);
							strcpy(text_line_temp2, "");
							l_print_anti_flag = 1;
						}


					if( (strcmp(s_ant[s].arr, a_antibiotic_code.arr) == 0) &&
						(strcmp(s_org[s].arr, org[e]) == 0) )
					{

						match_found = 1;
						l_should_anti_flag = 1;
						l_anti_flag = 1;

//sprintf(string_var, " Report  %c   Ind   %c", s_rep[s].arr[0], s_ind[s].arr[0]);
//disp_message(ERR_MESG, string_var);

					    if(s_rep[s].arr[0] == 'Y')
						{
						   
						   sprintf(l_char_str, "%s", s_ind[s].arr);
						   sprintf(text_line,"%s%-8.8s",text_line, l_char_str);

/////						 if (strlen(s_mic[s].arr) > 0)

						 if (strlen(s_mic[s].arr) > 0 && (strcmp(s_mic_print_yn[s].arr, "Y") == 0))  /// modified against bru-hims-crf-0050
						 {
							 sprintf(l_char_str, "%-9.9s", s_mic[s].arr);

					//		 strcpy(l_kb_mic_legend,"MIC Value");
					//		 sprintf(text_line1,"%-39.39s", l_kb_mic_legend);

					/////		 sprintf(text_line1,"%s%-8.8s",text_line1,l_char_str);

							 sprintf(text_line,"%s%-12.12s",text_line, l_char_str);
						 }
						 /************************
						 else if (strlen(s_zone[s].arr) > 0)
						 {
							sprintf(l_char_str, "%-5.5s", s_zone[s].arr);
							sprintf(text_line1,"%s%-8.8s",text_line1, l_char_str);
						 }
						 ******************************/
						 else
						 {
							/////sprintf(text_line1,"%s%-8.8s",text_line1," ");

							sprintf(text_line,"%s%-12.12s",text_line, " ");
						 }


						}
						else// TO BE CHECKED LAXMAN
						{
							
						   strcpy(l_char_str, "");

						   sprintf(l_char_str, "(%s)", s_ind[s].arr);
						   sprintf(text_line,"%s%-8.8s",text_line, l_char_str);

   						   if (strlen(s_mic[s].arr) > 0 && (strcmp(s_mic_print_yn[s].arr, "Y") == 0) )   /// modified against bru-hims-crf-0050
						   {
							 sprintf(l_char_str, "(%-9.9s)", s_mic[s].arr);
					//		 strcpy(l_kb_mic_legend,"MIC Value");
					//		 sprintf(text_line1,"%-39.39s", l_kb_mic_legend);

					////		 sprintf(text_line1,"%s%-8.8s",text_line1, l_char_str);

							 sprintf(text_line,"%s%-12.12s",text_line, l_char_str);
                           }     
								   /******************************************
									   else if (strlen(s_zone[s].arr) > 0)
									   {
										 sprintf(l_char_str, "(%-5.5s)", s_zone[s].arr);
										 sprintf(text_line1,"%s%-8.8s",text_line1, l_char_str);
									   }     
									****************************/
						   else
						   {
							/////sprintf(text_line1,"%s%-8.8s",text_line1," ");

							sprintf(text_line,"%s%-12.12s",text_line, " ");
						   }
						   strcpy(l_char_str, "");						   

						   

						} 
						break;
					}
				}

				if(match_found == 0)
				{
	               sprintf(text_line,"%s                    ",text_line);
				 ////  sprintf(text_line1,"%s        ",text_line1);
				}

			}

			if (l_anti_flag == 1)
			{


					sprintf(text_line,"%-80.80s",text_line);			
					print_line(text_line);

		/////		sprintf(text_line1,"%-80.80s",text_line1);			
		////		print_line(text_line1);

/************************** commented below and added above against BRU-HIMS-CRF-0050 on 04.12.2012
				if ( (strcmp(rl_mic_to_print_yn.arr,"Y") == 0) && mic_count > 0)
                {

					sprintf(text_line,"%-80.80s",text_line);			
					print_line(text_line);

					sprintf(text_line1,"%-80.80s",text_line1);			
					print_line(text_line1);

				}
				else
				{ 
					sprintf(text_line,"%-80.80s",text_line);			
					print_line(text_line);
					//sprintf(text_line1,"%-80.80s",text_line1);			
					//print_line(text_line1);

				}
*************************************/
			}
		
		 } 
		 
		 /* EXEC SQL CLOSE RL_ANTIBIOTIC_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1355;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		 /* EXEC SQL CLOSE RL_SENSITIVITY_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1370;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		 c1 = c1 + 2;
//		 disp_message(ERR_MESG, "22");

		}
		if (l_should_anti_flag == 1)
		{
			sprintf(text_line,"");
			
//			for(c=0;c<80;c++)
//				sprintf(text_line,"%s%s",text_line,"-");
	        //sprintf(text_line,"%-29.29s%-52.52s"," ","S - Sensitive     R - Resistant   I - Intermediate");//commented out for ML-MMOH-CRF-0576
			sprintf(text_line,"%-23.23s%-55.55s"," ","S - Sensitive  R - Resistant  I - Intermediate  D - SDD");//added for ML-MMOH-CRF-0576
			print_line(text_line);

			sprintf(text_line,"");
			for(c=0;c<80;c++)
				sprintf(text_line,"%s%s",text_line,"-");

			print_line(text_line);

		}

    }
}
/*-----------------------------------------------------*/

scan_and_prnt(l_str)
char *l_str;
{
   for(;*l_str != '\0';l_str++)
   {
     fprintf(fp,"%c",*l_str);
     if (*l_str == '\n')
        page_break(1);
   }
   fprintf(fp,"\n");
   page_break(1);
}
/*-----------------------------------------------------*/

open_result_organism()
{
    /* EXEC SQL OPEN RL_RESULT_ORGANISM_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0033;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1385;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&flag;
    sqlstm.sqhstl[5] = (unsigned int  )1;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&flag;
    sqlstm.sqhstl[6] = (unsigned int  )1;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor RL_RESULT_ORGANISM_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_result_org()
{
    rl_res_organism_code.arr[0]   = '\0';
    rl_res_comment_desc.arr[0]    = '\0';
	rl_res_hide_organism_yn.arr[0]= '\0'; /*Added for CRF20281 by srinivas*/

    rl_res_organism_code.len      = 0;
    rl_res_comment_desc.len       = 0;
	rl_res_hide_organism_yn.len   = 0; /*Added for CRF20281 by srinivas*/  

  l_org_seq_no.arr[0]   = '\0';	/*added for MO-CRF-20128*/
   l_org_seq_no.len      = 0;/*added for MO-CRF-20128*/

    /* EXEC SQL FETCH RL_RESULT_ORGANISM_CUR
              INTO :rl_res_organism_code,
                   :rl_res_comment_desc,
				   :rl_res_hide_organism_yn,/oAdded for CRF20281 by srinivaso/
				   :l_org_seq_no; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1428;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_organism_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_res_comment_desc;
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_res_hide_organism_yn;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_org_seq_no;
    sqlstm.sqhstl[3] = (unsigned int  )102;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 /*added for MO-CRF-20128*/
    if (OERROR)
         err_mesg("FETCH failed on cursor RL_RESULT_ORGANISM_CUR",0,"");

    rl_res_organism_code.arr[rl_res_organism_code.len] = '\0';
    rl_res_comment_desc.arr[rl_res_comment_desc.len] = '\0';
	rl_res_hide_organism_yn.arr[rl_res_hide_organism_yn.len] = '\0'; /*Added For CRF20281 by srinivas*/
    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

fetch_org_desc()
{
    //disp_message(ERR_MESG, "fetch_org_desc");
	/* EXEC SQL OPEN RL_ORGANISM_CODE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0037;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1459;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_res_organism_code;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor RL_ORGANISM_CODE_CUR",0,"");

    rl_res_organism_code_desc.arr[0] = '\0';
    rl_res_organism_code_desc.len    = 0;

    /* EXEC SQL FETCH RL_ORGANISM_CODE_CUR
              INTO :rl_res_organism_code_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1478;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_organism_code_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    rl_res_organism_code_desc.arr[rl_res_organism_code_desc.len] = '\0';

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_ORGANISM_CODE_CUR",0,"");
}
/*-----------------------------------------------------*/

//added for MO-CRF-20134
fetch_bio_org_desc()
{
    disp_message(ERR_MESG, "fetch_bio_org_desc");
	/* EXEC SQL OPEN RL_BIO_ORGANISM_CODE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0039;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1497;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_bio_organism_code;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor RL_BIO_ORGANISM_CODE_CUR",0,"");

    rl_bio_organism_code_desc.arr[0] = '\0';
    rl_bio_organism_code_desc.len    = 0;
	
	sprintf(string_var, "RESULT  %s", rl_bio_organism_code.arr);
				disp_message(ERR_MESG, string_var);

    /* EXEC SQL FETCH RL_BIO_ORGANISM_CODE_CUR
              INTO :rl_bio_organism_code_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1516;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_bio_organism_code_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    rl_bio_organism_code_desc.arr[rl_bio_organism_code_desc.len] = '\0';

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_BIO_ORGANISM_CODE_CUR",0,"");
}

//end MO-CRF-20134

open_antibiotic()
{
    /* EXEC SQL OPEN RL_ANTIBIOTIC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0034;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1535;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&flag;
    sqlstm.sqhstl[5] = (unsigned int  )1;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&flag;
    sqlstm.sqhstl[6] = (unsigned int  )1;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor RL_ANTIBIOTIC_CUR");
}

/*-----------------------------------------------------*/
fetch_antibiotic()
{
    a_antibiotic_code.arr[0]   = '\0';
    a_antibiotic_code.len	   = 0;

    /* EXEC SQL FETCH RL_ANTIBIOTIC_CUR
              INTO a_antibiotic_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1578;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&a_antibiotic_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("FETCH failed on cursor RL_ANTIBIOTIC_CUR");

    a_antibiotic_code.arr[a_antibiotic_code.len]   = '\0';
    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

fetch_antibiotic_desc()
{
    /* EXEC SQL OPEN RL_ANTIBIOTIC_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0038;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1597;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_dtl_antibiotic_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("OPEN failed on cursor RL_ANTIBIOTIC_CODE_CUR",0,"");

    rl_res_dtl_antibiotic_desc.arr[0] = '\0';
    rl_res_dtl_antibiotic_desc.len    = 0;

    /* EXEC SQL FETCH RL_ANTIBIOTIC_CODE_CUR
              INTO :rl_res_dtl_antibiotic_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1616;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_dtl_antibiotic_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    rl_res_dtl_antibiotic_desc.arr[rl_res_dtl_antibiotic_desc.len] = '\0';

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_ANTIBIOTIC_CODE_CUR",0,"");
}
/*-----------------------------------------------------*/
open_sensitivity()
{

    /* EXEC SQL OPEN RL_SENSITIVITY_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0035;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1635;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&flag;
    sqlstm.sqhstl[5] = (unsigned int  )1;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&flag;
    sqlstm.sqhstl[6] = (unsigned int  )1;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_SENSITIVITY_CUR");
}
/*-----------------------------------------------------*/
open_sensitivity_format4()
{

    /* EXEC SQL OPEN RL_SENSITIVITY_CUR_FORMAT4; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0036;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1678;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_res_organism_code;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&flag;
    sqlstm.sqhstl[6] = (unsigned int  )1;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&flag;
    sqlstm.sqhstl[7] = (unsigned int  )1;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&l_org_seq_no;
    sqlstm.sqhstl[8] = (unsigned int  )102;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_SENSITIVITY_CUR_FORMAT4");
}
/*-----------------------------------------------------*/


fetch_sensitivity()
{
   int i;
   char str[100];   

   no_of_sensitivities = 0;

   for(i=0;i<MAX_ANTIBIOTICS;i++)
   {
		s_ant[i].arr[0] = '\0';
		s_org[i].arr[0] = '\0';
		s_ind[i].arr[0] = '\0';
		s_rep[i].arr[0] = '\0';
		s_mic[i].arr[0] = '\0';
		s_zone[i].arr[0] = '\0';
		s_mic_print_yn[i].arr[0] = '\0';

		s_ant[i].len = 0;
		s_org[i].len = 0;
		s_ind[i].len = 0;
		s_rep[i].len = 0;
		s_mic[i].len = 0;
		s_zone[i].len = 0;
		s_mic_print_yn[i].len = 0;

   }

   /* EXEC SQL FETCH RL_SENSITIVITY_CUR
	         INTO :s_org,
			      :s_ant,
			      :s_ind,
			  	  :s_rep,
				  :s_mic,
				  :s_zone,
				  :s_mic_print_yn; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )250;
   sqlstm.offset = (unsigned int  )1729;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)s_org;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )8;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqharc[0] = (unsigned int   *)0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)s_ant;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )8;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqharc[1] = (unsigned int   *)0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)s_ind;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )4;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqharc[2] = (unsigned int   *)0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)s_rep;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )4;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqharc[3] = (unsigned int   *)0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)s_mic;
   sqlstm.sqhstl[4] = (unsigned int  )12;
   sqlstm.sqhsts[4] = (         int  )12;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqharc[4] = (unsigned int   *)0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)s_zone;
   sqlstm.sqhstl[5] = (unsigned int  )12;
   sqlstm.sqhsts[5] = (         int  )12;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqharc[5] = (unsigned int   *)0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)s_mic_print_yn;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )4;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqharc[6] = (unsigned int   *)0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




   if (OERROR)
         err_mesg("FETCH failed on cursor RL_SENSITIVITY_CUR");

   for(i=0;i<MAX_ANTIBIOTICS;i++)
   {
		s_org[i].arr[s_org[i].len] = '\0';
		if(strlen(s_org[i].arr) == 0)
		   break;
		s_ant[i].arr[s_ant[i].len] = '\0';
		s_ind[i].arr[s_ind[i].len] = '\0';
		s_rep[i].arr[s_rep[i].len] = '\0';
  		s_mic[i].arr[s_mic[i].len] = '\0';
		s_zone[i].arr[s_zone[i].len] = '\0';
  		s_mic_print_yn[i].arr[s_mic_print_yn[i].len] = '\0';

   }
   no_of_sensitivities = i;
}
/*-----------------------------------------------------*/
fetch_sensitivity_format4()
{
    b_antibiotic_code.arr[0]   = '\0'; 
    b_antibiotic_code.len	   = 0;
	
	b_sensitivity_ind.arr[0]   = '\0';
	b_sensitivity_ind.len      = 0;
	
	b_report_yn.arr[0]         = '\0';
	b_report_yn.len            = 0;

	b_mic_value.arr[0]   = '\0';
	b_mic_value.len      = 0;
	b_zone_value.arr[0]   = '\0';
	b_zone_value.len      = 0;

	b_mic_print_yn.arr[0] = '\0';
	b_mic_print_yn.len    = 0;
		
	//added the following code for AMS-CRF-0067 by krishnamoorthys
	b_mic_sign.arr[0]   = '\0';
	b_mic_sign.len      = 0;

//added "b_mic_sign" for AMS-CRF-0067 by krishnamoorthys
    /* EXEC SQL FETCH RL_SENSITIVITY_CUR_FORMAT4
              INTO b_antibiotic_code,b_sensitivity_ind,b_report_yn,b_mic_value,b_mic_sign, 
					b_zone_value,
					b_mic_print_yn; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1772;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&b_antibiotic_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&b_sensitivity_ind;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&b_report_yn;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&b_mic_value;
    sqlstm.sqhstl[3] = (unsigned int  )12;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&b_mic_sign;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&b_zone_value;
    sqlstm.sqhstl[5] = (unsigned int  )12;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&b_mic_print_yn;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         disp_message(ERR_MESG,"FETCH failed on cursor RL_SENSITIVITY_CUR_FORMAT4");

    b_antibiotic_code.arr[b_antibiotic_code.len]   = '\0';
	b_sensitivity_ind.arr[b_sensitivity_ind.len]   = '\0';
	b_report_yn.arr[b_report_yn.len]			   = '\0';
	b_mic_value.arr[b_mic_value.len]   = '\0';
	b_mic_sign.arr[b_mic_sign.len]   = '\0'; //added b_mic_sign for AMS-CRF-0067 by krishnamoorthys
	b_zone_value.arr[b_zone_value.len]   = '\0';
	b_mic_print_yn.arr[b_mic_print_yn.len]   = '\0';

    return (LAST_ROW?0:1); 
}
/*-----------------------------------------------------*/
fetch_other_dtls()
{
	if(strcmp(rl_hdr_episode_type.arr,"I")==0 || 
       strcmp(rl_hdr_episode_type.arr,"O")==0 ||
	   strcmp(rl_hdr_episode_type.arr,"H")==0 )
    { 
      declare_inpat_curs();
	
    }
	else 
		declare_refpat_curs();
   
   fetch_pat_name();
   fetch_spec_desc();
   fetch_consultant();
   fetch_section();
}
/*-----------------------------------------------------*/
declare_inpat_curs()
{

/* EXEC SQL DECLARE RL_PAT_MAST_CUR CURSOR FOR
              SELECT SHORT_NAME,
                     SEX,
                     NATIONALITY_CODE,
                     ROUND(TO_DATE(:rl_hdr_spec_regd_date_time,
				   'DD/MM/YYYY HH24:MI') - DATE_OF_BIRTH),
                     TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY') 
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :nd_hosp_no; */ 


/*
    EXEC SQL DECLARE RL_PAT_MAST2_CUR CURSOR FOR
              SELECT SHORT_NAME,
                     SEX,
                     NATIONALITY_CODE,
                     ROUND(TO_DATE(:rl_hdr_spec_regd_date_time,
				   'DD/MM/YYYY HH24:MI') - DATE_OF_BIRTH),
                     TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY')
                FROM MP_PATIENT_MAST_OTHERS
               WHERE PATIENT_ID = :nd_hosp_no;
*/

}

/*-----------------------------------------------------*/
declare_refpat_curs()
{
    /* EXEC SQL DECLARE RL_PAT_MAST3_CUR CURSOR FOR
              SELECT SHORT_NAME,
                     SEX,
                     NATIONALITY_CODE,
                     ROUND(TO_DATE(:rl_hdr_spec_regd_date_time,
				   'DD/MM/YYYY HH24:MI') - DATE_OF_BIRTH),
                     TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY') 
                FROM RL_PATIENT_MAST
               WHERE PATIENT_ID = :nd_hosp_no; */ 

			   /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

}


/*-----------------------------------------------------*/
fetch_pat_name()
{
    rl_pat_long_name.arr[0]     = '\0';
    rl_pat_short_name.arr[0]     = '\0';
    rl_pat_sex.arr[0]           = '\0';
    rl_pat_nationality.arr[0]           = '\0';
    rl_pat_dob_no_of_days.arr[0]           = '\0';
    rl_pat_date_of_birth.arr[0]            = '\0';
    rl_pat_blood_group.arr[0]              = '\0';
    rl_pat_g6pd.arr[0]              = '\0';
    rl_pat_sicc.arr[0]              = '\0';
    rl_pat_hbl4_1.arr[0]              = '\0';
    rl_pat_hbl4_2.arr[0]              = '\0';

    rl_pat_long_name.len         = 0;
    rl_pat_short_name.len         = 0;
    rl_pat_sex.len         = 0;
    rl_pat_nationality.len         = 0;
    rl_pat_dob_no_of_days.len         = 0;
    rl_pat_date_of_birth.len          = 0;
    rl_pat_g6pd.len                   = 0;
    rl_pat_sicc.len                   = 0;
    rl_pat_hbl4_1.len                   = 0;
    rl_pat_hbl4_2.len                   = 0;

	if(strcmp(rl_hdr_episode_type.arr,"I")==0 || 
       strcmp(rl_hdr_episode_type.arr,"O")==0 ||
	   strcmp(rl_hdr_episode_type.arr,"H")==0 )
    { 

    /* EXEC SQL OPEN RL_PAT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0054;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1815;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_PAT_MAST_CUR",0,"");


    /* EXEC SQL FETCH RL_PAT_MAST_CUR
              INTO :rl_pat_short_name,
                   :rl_pat_sex,
                   :rl_pat_nationality,
                   :rl_pat_dob_no_of_days,
                   :rl_pat_date_of_birth; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1838;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_pat_short_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_pat_sex;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_pat_nationality;
    sqlstm.sqhstl[2] = (unsigned int  )6;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_pat_dob_no_of_days;
    sqlstm.sqhstl[3] = (unsigned int  )12;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_pat_date_of_birth;
    sqlstm.sqhstl[4] = (unsigned int  )18;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
       err_mesg("OERROR with MP_PATIENT_MAST fetch",0,"");
    else
	   if(NODATAFOUND)
	   {
                /* EXEC SQL OPEN RL_PAT_MAST3_CUR; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 30;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = sq0055;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )1873;
                sqlstm.selerr = (unsigned short)1;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
                sqlstm.sqhstl[0] = (unsigned int  )19;
                sqlstm.sqhsts[0] = (         int  )0;
                sqlstm.sqindv[0] = (         void  *)0;
                sqlstm.sqinds[0] = (         int  )0;
                sqlstm.sqharm[0] = (unsigned int  )0;
                sqlstm.sqadto[0] = (unsigned short )0;
                sqlstm.sqtdso[0] = (unsigned short )0;
                sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
                sqlstm.sqhstl[1] = (unsigned int  )33;
                sqlstm.sqhsts[1] = (         int  )0;
                sqlstm.sqindv[1] = (         void  *)0;
                sqlstm.sqinds[1] = (         int  )0;
                sqlstm.sqharm[1] = (unsigned int  )0;
                sqlstm.sqadto[1] = (unsigned short )0;
                sqlstm.sqtdso[1] = (unsigned short )0;
                sqlstm.sqphsv = sqlstm.sqhstv;
                sqlstm.sqphsl = sqlstm.sqhstl;
                sqlstm.sqphss = sqlstm.sqhsts;
                sqlstm.sqpind = sqlstm.sqindv;
                sqlstm.sqpins = sqlstm.sqinds;
                sqlstm.sqparm = sqlstm.sqharm;
                sqlstm.sqparc = sqlstm.sqharc;
                sqlstm.sqpadto = sqlstm.sqadto;
                sqlstm.sqptdso = sqlstm.sqtdso;
                sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    		/* EXEC SQL FETCH RL_PAT_MAST3_CUR
              	         INTO   :rl_pat_short_name,
                   		:rl_pat_sex,
                   		:rl_pat_nationality,
                   		:rl_pat_dob_no_of_days,
                   		:rl_pat_date_of_birth; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 30;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1896;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_pat_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )63;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_pat_sex;
      sqlstm.sqhstl[1] = (unsigned int  )4;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&rl_pat_nationality;
      sqlstm.sqhstl[2] = (unsigned int  )6;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_pat_dob_no_of_days;
      sqlstm.sqhstl[3] = (unsigned int  )12;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&rl_pat_date_of_birth;
      sqlstm.sqhstl[4] = (unsigned int  )18;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


               if (OERROR)
                  err_mesg("OERROR with MP_PATIENT_MAST_REFERRALS fetch",0,"");	
               else
	          if(NODATAFOUND)
                        ;
      }
	}
	else
	{

                /* EXEC SQL OPEN RL_PAT_MAST3_CUR; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 30;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = sq0055;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )1931;
                sqlstm.selerr = (unsigned short)1;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
                sqlstm.sqhstl[0] = (unsigned int  )19;
                sqlstm.sqhsts[0] = (         int  )0;
                sqlstm.sqindv[0] = (         void  *)0;
                sqlstm.sqinds[0] = (         int  )0;
                sqlstm.sqharm[0] = (unsigned int  )0;
                sqlstm.sqadto[0] = (unsigned short )0;
                sqlstm.sqtdso[0] = (unsigned short )0;
                sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
                sqlstm.sqhstl[1] = (unsigned int  )33;
                sqlstm.sqhsts[1] = (         int  )0;
                sqlstm.sqindv[1] = (         void  *)0;
                sqlstm.sqinds[1] = (         int  )0;
                sqlstm.sqharm[1] = (unsigned int  )0;
                sqlstm.sqadto[1] = (unsigned short )0;
                sqlstm.sqtdso[1] = (unsigned short )0;
                sqlstm.sqphsv = sqlstm.sqhstv;
                sqlstm.sqphsl = sqlstm.sqhstl;
                sqlstm.sqphss = sqlstm.sqhsts;
                sqlstm.sqpind = sqlstm.sqindv;
                sqlstm.sqpins = sqlstm.sqinds;
                sqlstm.sqparm = sqlstm.sqharm;
                sqlstm.sqparc = sqlstm.sqharc;
                sqlstm.sqpadto = sqlstm.sqadto;
                sqlstm.sqptdso = sqlstm.sqtdso;
                sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    		/* EXEC SQL FETCH RL_PAT_MAST3_CUR
              	         INTO   :rl_pat_short_name,
                   		:rl_pat_sex,
                   		:rl_pat_nationality,
                   		:rl_pat_dob_no_of_days,
                   		:rl_pat_date_of_birth; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 30;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1954;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_pat_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )63;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_pat_sex;
      sqlstm.sqhstl[1] = (unsigned int  )4;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&rl_pat_nationality;
      sqlstm.sqhstl[2] = (unsigned int  )6;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_pat_dob_no_of_days;
      sqlstm.sqhstl[3] = (unsigned int  )12;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&rl_pat_date_of_birth;
      sqlstm.sqhstl[4] = (unsigned int  )18;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


               if (OERROR)
                  err_mesg("OERROR with MP_PATIENT_MAST_REFERRALS fetch",0,"");	
               else
	          if(NODATAFOUND)
                        ;

	}
    rl_pat_long_name.arr[rl_pat_long_name.len] = '\0';
    rl_pat_short_name.arr[rl_pat_short_name.len] = '\0';
    rl_pat_long_name.arr[rl_pat_long_name.len] = '\0';
    rl_pat_short_name.arr[rl_pat_short_name.len] = '\0';
    rl_pat_sex.arr[rl_pat_sex.len] = '\0';
    rl_pat_nationality.arr[rl_pat_nationality.len] = '\0';
    rl_pat_dob_no_of_days.arr[rl_pat_dob_no_of_days.len] = '\0';
    rl_pat_date_of_birth.arr[rl_pat_date_of_birth.len]   = '\0';

}

/*-----------------------------------------------------*/
fetch_spec_desc()
{
    /* EXEC SQL OPEN RL_SPECIMEN_TYPE_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0021;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1989;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_specimen_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_SPECIMEN_TYPE_CODE_CUR",0,"");

    rl_spc_specimen_desc.arr[0] = '\0';
    rl_spc_specimen_desc.len    = 0;

    /* EXEC SQL FETCH RL_SPECIMEN_TYPE_CODE_CUR
              INTO :rl_spc_specimen_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2008;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_spc_specimen_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_SPECIMEN_TYPE_CODE_CUR",0,"");

    rl_spc_specimen_desc.arr[rl_spc_specimen_desc.len] = '\0';

}
/*-----------------------------------------------------*/

fetch_test_code(loc_tst_code)
char loc_tst_code[];
{
    strcpy(rl_loc_test_code.arr,loc_tst_code);
    rl_loc_test_code.len  =  strlen(rl_loc_test_code.arr);

    /* EXEC SQL OPEN RL_TEST_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0023;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2027;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_loc_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_TEST_CODE_CUR",0,"");

    rl_tst_cd_short_desc.arr[0]         = '\0';
    rl_tst_cd_numeric_result_yn.arr[0]  = '\0';
    rl_tst_cd_age_sex_range_yn.arr[0]   = '\0';
    rl_tst_cd_function_yn.arr[0]        = '\0';
    rl_tst_cd_print_report_yn.arr[0]    = '\0';
    rl_tst_cd_low_value_normal.arr[0]   = '\0';
    rl_tst_cd_high_value_normal.arr[0]  = '\0';
    rl_tst_cd_test_units_2.arr[0]		= '\0'; 
    rl_tst_cd_group_test_yn.arr[0]      = '\0';
    rl_tst_cd_text_block_yn.arr[0]      = '\0';
    rl_tst_cd_culture_test_yn.arr[0]    = '\0';
    rl_tst_cd_snomed_yn.arr[0]          = '\0';
	rl_tst_cd_range_cmt_2.arr[0]        = '\0';  
	rl_conf_yn.arr[0]					= '\0';
	rl_inhibit_report_yn.arr[0]			= '\0';

    rl_tst_cd_short_desc.len            = 0;
    rl_tst_cd_numeric_result_yn.len     = 0;
    rl_tst_cd_age_sex_range_yn.len      = 0;
    rl_tst_cd_function_yn.len           = 0;
    rl_tst_cd_print_report_yn.len       = 0;
    rl_tst_cd_low_value_normal.len      = 0;
    rl_tst_cd_high_value_normal.len     = 0;
    rl_tst_cd_test_units_2.len			= 0;  
    rl_tst_cd_group_test_yn.len         = 0;
    rl_tst_cd_text_block_yn.len         = 0;
    rl_tst_cd_culture_test_yn.len       = 0;
    rl_tst_cd_snomed_yn.len             = 0;
    rl_tst_cd_range_cmt_2.len           = 0;  
	rl_conf_yn.len						= 0;
	rl_inhibit_report_yn.len			= 0;

    rl_tst_cd_no_of_decimals = 0;
    rl_tst_cd_significant_digit = 0;

    /* EXEC SQL FETCH RL_TEST_CODE_CUR
              INTO :rl_tst_cd_short_desc,
                   :rl_tst_cd_numeric_result_yn,
                   :rl_tst_cd_age_sex_range_yn,
                   :rl_tst_cd_function_yn,
                   :rl_tst_cd_print_report_yn,
                   :rl_tst_cd_low_value_normal,
                   :rl_tst_cd_high_value_normal,
                   :rl_tst_cd_group_test_yn,
                   :rl_tst_cd_text_block_yn,
                   :rl_tst_cd_culture_test_yn,
                   :rl_tst_cd_snomed_yn,
				   :rl_tst_cd_test_units_2,
                   :rl_tst_cd_no_of_decimals,
                   :rl_tst_cd_significant_digit,
				   :rl_tst_cd_range_cmt_2,
				   :rl_conf_yn,
				   :rl_inhibit_report_yn; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2046;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_cd_short_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_tst_cd_numeric_result_yn;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_tst_cd_age_sex_range_yn;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_cd_function_yn;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_cd_print_report_yn;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_tst_cd_low_value_normal;
    sqlstm.sqhstl[5] = (unsigned int  )18;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_tst_cd_high_value_normal;
    sqlstm.sqhstl[6] = (unsigned int  )18;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_tst_cd_group_test_yn;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rl_tst_cd_text_block_yn;
    sqlstm.sqhstl[8] = (unsigned int  )4;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&rl_tst_cd_culture_test_yn;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&rl_tst_cd_snomed_yn;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&rl_tst_cd_test_units_2;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rl_tst_cd_no_of_decimals;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rl_tst_cd_significant_digit;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&rl_tst_cd_range_cmt_2;
    sqlstm.sqhstl[14] = (unsigned int  )43;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&rl_conf_yn;
    sqlstm.sqhstl[15] = (unsigned int  )4;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&rl_inhibit_report_yn;
    sqlstm.sqhstl[16] = (unsigned int  )4;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




/* CHANGED ON 27/09/1999    
				   :rl_tst_cd_test_units,
                   :rl_tst_cd_range_cmt;
 UPTO HERE    */

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_TEST_CODE_CUR",0,"");

    rl_tst_cd_short_desc.arr[rl_tst_cd_short_desc.len] = '\0';
    if(strlen(rl_tst_cd_short_desc.arr) > 35)
	rl_tst_cd_short_desc.arr[35]='\0';

    rl_tst_cd_numeric_result_yn.arr[rl_tst_cd_numeric_result_yn.len] = '\0';
    rl_tst_cd_age_sex_range_yn.arr[rl_tst_cd_age_sex_range_yn.len] = '\0';
    rl_tst_cd_function_yn.arr[rl_tst_cd_function_yn.len] = '\0';
    rl_tst_cd_print_report_yn.arr[rl_tst_cd_print_report_yn.len] = '\0';
    rl_tst_cd_low_value_normal.arr[rl_tst_cd_low_value_normal.len] = '\0';
    rl_tst_cd_high_value_normal.arr[rl_tst_cd_high_value_normal.len] = '\0';
    rl_tst_cd_test_units_2.arr[rl_tst_cd_test_units_2.len] = '\0';  
    rl_tst_cd_group_test_yn.arr[rl_tst_cd_group_test_yn.len] = '\0';
    rl_tst_cd_text_block_yn.arr[rl_tst_cd_text_block_yn.len] = '\0';
    rl_tst_cd_culture_test_yn.arr[rl_tst_cd_culture_test_yn.len] = '\0';
    rl_tst_cd_snomed_yn.arr[rl_tst_cd_snomed_yn.len] = '\0';
    rl_tst_cd_range_cmt_2.arr[rl_tst_cd_range_cmt_2.len] = '\0';  
	rl_conf_yn.arr[rl_conf_yn.len]						 = '\0';
	rl_inhibit_report_yn.arr[rl_inhibit_report_yn.len]	 = '\0';

    rl_tst_cd_no_of_decimals = rl_tst_cd_no_of_decimals>9?9:
                         rl_tst_cd_no_of_decimals;
    rl_tst_cd_significant_digit = rl_tst_cd_no_of_decimals>9?9:
                         rl_tst_cd_significant_digit;

    if (sqlca.sqlerrd[2]) tst_cd_ind = 1;
    return (sqlca.sqlerrd[2]);
}
/*-----------------------------------------------------*/
fetch_consultant()
{
    if (rl_hdr_episode_type.arr[0] == 'I') 
      {
      /* EXEC SQL  SELECT FULL_NAME
		  INTO :rl_consultant_short_name
                  FROM SY_PHYSICIAN_MAST
                 WHERE FACILITY_ID = NVL(:rl_hdr_ordered_facility_id, :nd_operating_facility_id)
			 AND PHYSICIAN_ID = :rl_hdr_consultant_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 30;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select FULL_NAME into :b0  from SY_PHYSICIAN_MAST where\
 (FACILITY_ID=NVL(:b1,:b2) and PHYSICIAN_ID=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2129;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_consultant_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )43;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_hdr_ordered_facility_id;
      sqlstm.sqhstl[1] = (unsigned int  )5;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[2] = (unsigned int  )5;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_hdr_consultant_code;
      sqlstm.sqhstl[3] = (unsigned int  )18;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      }
    else if (rl_hdr_episode_type.arr[0] == 'R') 
      {
      /* EXEC SQL  SELECT LONG_NAME
		  INTO :rl_consultant_short_name
                  FROM RL_CONSULTANTS
                 WHERE REF_CONSULTANT_ID = :rl_hdr_consultant_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 30;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select LONG_NAME into :b0  from RL_CONSULTANTS where RE\
F_CONSULTANT_ID=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2160;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_consultant_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )43;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_hdr_consultant_code;
      sqlstm.sqhstl[1] = (unsigned int  )18;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      }
    else if ((rl_hdr_episode_type.arr[0] == 'O') || (rl_hdr_episode_type.arr[0] == 'H')) 
      {
      /* EXEC SQL  SELECT FULL_NAME
		  INTO :rl_consultant_short_name
                  FROM SY_PHYSICIAN_MAST
                 WHERE FACILITY_ID = NVL(:rl_hdr_ordered_facility_id, :nd_operating_facility_id)
			 AND PHYSICIAN_ID = :rl_hdr_consultant_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 30;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select FULL_NAME into :b0  from SY_PHYSICIAN_MAST where\
 (FACILITY_ID=NVL(:b1,:b2) and PHYSICIAN_ID=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2183;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_consultant_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )43;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_hdr_ordered_facility_id;
      sqlstm.sqhstl[1] = (unsigned int  )5;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[2] = (unsigned int  )5;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_hdr_consultant_code;
      sqlstm.sqhstl[3] = (unsigned int  )18;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      }
    else
       err_mesg("Invalid Episode type in Request Header",0,"");
	      
    if (OERROR)
         err_mesg("FETCH failed on CONSULTANT Master ",0,"");

    rl_consultant_short_name.arr[rl_consultant_short_name.len] = '\0';
}
/*-----------------------------------------------------*/
fetch_section()
{
    /* EXEC SQL OPEN RL_SECTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0022;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2214;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_section_code;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_SECTION_CUR",0,"");

    rl_section_short_name.arr[0] 	= '\0';
    rl_section_short_name.len		= 0;

    /* EXEC SQL FETCH RL_SECTION_CUR
              INTO :rl_section_short_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2233;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_section_short_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    rl_section_short_name.arr[rl_section_short_name.len] = '\0';

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_SECTION_CUR",0,"");

}
/*-----------------------------------------------------*/

fetch_age_sex_range()
{

    /* EXEC SQL OPEN RL_AGE_SEX_RANGE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0024;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2252;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_pat_sex;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_pat_dob_no_of_days;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_AGE_SEX_RANGE_CUR",0,"");

    rl_tst_range_low_v_nor.arr[0]      = '\0';
    rl_tst_range_high_v_nor.arr[0]      = '\0';

    rl_tst_range_low_v_nor.len         = 0;
    rl_tst_range_high_v_nor.len         = 0;

    /* EXEC SQL FETCH RL_AGE_SEX_RANGE_CUR
              INTO :rl_tst_range_low_v_nor,
                   :rl_tst_range_high_v_nor; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2279;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_range_low_v_nor;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_tst_range_high_v_nor;
    sqlstm.sqhstl[1] = (unsigned int  )18;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
    if (OERROR)
         err_mesg("FETCH failed on cursor RL_AGE_SEX_RANGE_CUR",0,"");

    rl_tst_range_low_v_nor.arr[rl_tst_range_low_v_nor.len] = '\0';
    rl_tst_range_high_v_nor.arr[rl_tst_range_high_v_nor.len] = '\0';
}
/*-----------------------------------------------------*/

open_comments()
{
    /* EXEC SQL OPEN RL_COMM_FOR_TEST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0025;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2302;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_COMM_FOR_TEST_CUR",0,"");
}
/*-----------------------------------------------------*/
fetch_comments()
{
#ifdef DEBUG
       printf("In fetch_comments() \n");
#endif

    rl_comm_for_test_com_text.arr[0]     = '\0';
    rl_comm_for_test_com_text.len        = 0;

    /* EXEC SQL FETCH RL_COMM_FOR_TEST_CUR
              INTO :rl_comm_for_test_com_text; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2321;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_comm_for_test_com_text;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_COMM_FOR_TEST_CUR",0,"");

    rl_comm_for_test_com_text.arr[rl_comm_for_test_com_text.len] = '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
print_comment_desc1234()
{
  if (rl_tst_result_comment_desc1.len || rl_tst_result_comment_desc2.len ||
     rl_tst_result_comment_desc3.len || rl_tst_result_comment_desc4.len)
  {  

  	/***** ADDED FOR SCF42 OF QATAR *****/		
		something_to_print = 1;
		something_to_print_for_test = 1;

     if(group && !group_printed)
     {   print_group_test_desc();
	 group_printed = 1;
     }
     if(test_printed)
	 numeric_value_flag = TRUE;
     else
	{
	 numeric_value_flag = FALSE;
         fprintf(fp,"%-37.37s",test_description);
	 test_printed = 1;
        }
    if (rl_tst_result_comment_desc1.len != 0)
         print_line_check(rl_tst_result_comment_desc1.arr);
    if (rl_tst_result_comment_desc2.len != 0)
         print_line_check(rl_tst_result_comment_desc2.arr);
    if (rl_tst_result_comment_desc3.len != 0)
         print_line_check(rl_tst_result_comment_desc3.arr);
    if (rl_tst_result_comment_desc4.len != 0)
         print_line_check(rl_tst_result_comment_desc4.arr);
  }
}
/*-----------------------------------------------------*/
print_prel_release_desc() 
{
  if (rl_legend_for_pre_result.len)
  {  

     if(group && !group_printed)
     {   
		print_group_test_desc();
		group_printed = 1;
     }
     if(test_printed)
		numeric_value_flag = TRUE;
     else
	{
		 numeric_value_flag = FALSE;
	     fprintf(fp,"%-37.37s",test_description);
		 test_printed = 1;
     }
     print_line_check(rl_legend_for_pre_result.arr);

  }
}
/*-----------------------------------------------------*/
fetch_snomed_desc12345()
{
    /* EXEC SQL OPEN RL_SNOMED_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0032;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2340;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_snomed_code;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_SNOMED_CODE_CUR",0,"");

#ifdef DEBUG
       printf("In fetch_snomed_desc1234() \n");
#endif
    rl_snomed_desc1.arr[0]          = '\0';
    rl_snomed_desc2.arr[0]          = '\0';
    rl_snomed_desc3.arr[0]          = '\0';
    rl_snomed_desc4.arr[0]          = '\0';
    rl_snomed_desc5.arr[0]          = '\0';
    rl_snomed_print_yn.arr[0]       = '\0';
	rl_print_snomed_code_yn.arr[0]  = '\0';

    rl_snomed_desc1.len             = 0;
    rl_snomed_desc2.len             = 0;
    rl_snomed_desc3.len             = 0;
    rl_snomed_desc4.len             = 0;
    rl_snomed_desc5.len             = 0;
    rl_snomed_print_yn.len			= 0;
	rl_print_snomed_code_yn.len		= 0;

/***************************** CHANGED ON 01/09/2002
                   :rl_snomed_desc2,
                   :rl_snomed_desc3,
                   :rl_snomed_desc4,
                   :rl_snomed_desc5,
*******************************************/

    /* EXEC SQL FETCH RL_SNOMED_CODE_CUR
              INTO :rl_snomed_desc1,
    		   :rl_snomed_print_yn,
			   :rl_print_snomed_code_yn; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2359;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_snomed_desc1;
    sqlstm.sqhstl[0] = (unsigned int  )303;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_snomed_print_yn;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_print_snomed_code_yn;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_SNOMED_CODE_CUR",0,"");

    rl_snomed_desc1.arr[rl_snomed_desc1.len] = '\0';
    rl_snomed_desc2.arr[rl_snomed_desc2.len] = '\0';
    rl_snomed_desc3.arr[rl_snomed_desc3.len] = '\0';
    rl_snomed_desc4.arr[rl_snomed_desc4.len] = '\0';
    rl_snomed_desc5.arr[rl_snomed_desc5.len] = '\0';
    rl_snomed_print_yn.arr[rl_snomed_print_yn.len] = '\0';
	rl_print_snomed_code_yn.arr[rl_print_snomed_code_yn.len]	= '\0';

   return (sqlca.sqlerrd[2]);
}
/*-----------------------------------------------------*/
print_snomed_desc12345()
{
  if(rl_snomed_desc1.len || rl_snomed2_desc1.len ) 
  {

	
  	/***** ADDED FOR SCF42 OF QATAR *****/		
		something_to_print = 1;
		something_to_print_for_test = 1;

    if(group && !group_printed)
    {   print_group_test_desc();
	group_printed = 1;
    }
    if(!test_printed)
    {
       fprintf(fp,"%-37.37s%c%c%c%c%c%c\n",test_description,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
       test_printed = 1;
    }

/****************************/

//	print_snomed_codes('Y');
	
	print_str('N');
	fprintf(fp, " - ");
/**************************/
	if (rl_snomed_desc1.len != 0 && rl_snomed_print_yn.arr[0] == 'Y'
			|| flag == 'L' || flag == 'K')
    {
		 fprintf(fp,"%-20s",rl_snomed_desc1.arr);
		 fprintf(fp, " | ");
		 if (rl_snomed2_desc1.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
		 {

			if (flag != 'K' && flag != 'L')
			{
				fprintf(fp,"%c%c%c%c%c%c", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);
			
				fprintf(fp, "\n");
				page_break(1);
			}
		 }
	}
	else
	{
		if (rl_snomed2_desc1.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
		{
			fprint_repeat(fp,' ',20);	
			fprintf(fp, " | ");
		}
	}
    

	if ((rl_snomed2_desc1.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
			|| (flag == 'L' || flag == 'K'))
	{
			fprintf(fp,"%s",rl_snomed2_desc1.arr);
			fprintf(fp,"%c%c%c%c%c%c\n", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);

			page_break(1);
	}

/*---------------------------*/
    if (rl_snomed_desc2.len != 0 && rl_snomed_print_yn.arr[0] == 'Y')
    {
		 print_snomed_codes('N');	
		 fprintf(fp, " - ");
		 fprintf(fp,"%-20s",rl_snomed_desc2.arr);
		 fprintf(fp, " | ");
		 if (rl_snomed2_desc2.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
		 {
			fprintf(fp,"%c%c%c%c%c%c", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);

			fprintf(fp, "\n");
			page_break(1);

		 }
	}
	else
	{
		if (rl_snomed2_desc2.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
		{
			print_snomed_codes('N');		
			fprintf(fp, " - ");
			fprint_repeat(fp,' ',20);
			fprintf(fp, " | ");
		}
	}

	if (rl_snomed2_desc2.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
	{
			fprintf(fp,"%s",rl_snomed2_desc2.arr);
			fprintf(fp,"%c%c%c%c%c%c\n", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);

			page_break(1);
	}

    
/*---------------------------*/    

    if (rl_snomed_desc3.len != 0 && rl_snomed_print_yn.arr[0] == 'Y')
    {

		print_snomed_codes('N');	
		fprintf(fp, " - ");
		fprintf(fp,"%-20s",rl_snomed_desc3.arr);
		fprintf(fp, " | ");
		if (rl_snomed2_desc3.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
		{
			fprintf(fp,"%c%c%c%c%c%c", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);

			fprintf(fp, "\n");
			
			fprintf(fp, "\n");
			page_break(1);

		}
	}
	else
	{
		if (rl_snomed2_desc3.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
		{
			print_snomed_codes('N');	
			fprintf(fp, " - ");
			fprint_repeat(fp,' ',20);
			fprintf(fp, " | ");
		}
	}

	if (rl_snomed2_desc3.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
	{
	        fprintf(fp,"%s",rl_snomed2_desc3.arr);
			fprintf(fp,"%c%c%c%c%c%c", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);

			fprintf(fp, "\n");

			page_break(1);
	}

/*---------------------------*/        


    if (rl_snomed_desc4.len != 0 && rl_snomed_print_yn.arr[0] == 'Y')
    {
		 print_snomed_codes('N');	
		 fprintf(fp, " - ");
		 fprintf(fp,"%-20s",rl_snomed_desc4.arr);
		 fprintf(fp, " | ");
		 if (rl_snomed2_desc4.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
		 {
			fprintf(fp,"%c%c%c%c%c%c", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);
			
			fprintf(fp, "\n");
			page_break(1);

		 }
	}
	else
	{
		if (rl_snomed2_desc4.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
		{
			print_snomed_codes('N');	
			fprintf(fp, " - ");
			fprint_repeat(fp,' ',20);
			fprintf(fp, " | ");
		}
	}

	if (rl_snomed2_desc4.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
	{
			fprintf(fp,"%s",rl_snomed2_desc4.arr);
			fprintf(fp,"%c%c%c%c%c%c\n", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);

			page_break(1);
	}

/*---------------------------*/        
	if (rl_snomed_desc5.len != 0 && rl_snomed_print_yn.arr[0] == 'Y')	
	{
			print_snomed_codes('N');	
			fprintf(fp, " - ");
			fprintf(fp,"%-20s",rl_snomed_desc5.arr);
			fprintf(fp, " | ");
			if (rl_snomed2_desc5.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
			{
				fprintf(fp,"%c%c%c%c%c%c", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);

				fprintf(fp, "\n");

				page_break(1);

			}
	}
	else
	{
		if (rl_snomed2_desc5.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
		{
			print_snomed_codes('N');	
			fprintf(fp, " - ");
			fprint_repeat(fp,' ',20);
			fprintf(fp, " | ");
		}
	}

	if (rl_snomed2_desc5.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
	{

			
			fprintf(fp,"%s",rl_snomed2_desc5.arr);
			fprintf(fp,"%c%c%c%c%c%c\n", rl_tst_status.arr[0],
						   rl_tst_tech_status.arr[0],
					       rl_tst_delta_status.arr[0],
							rl_tst_qlty_status.arr[0],
							rl_tst_cmnt_status.arr[0],
							rl_tst_path_status.arr[0]);

			page_break(1);
	}


  }

  if (rl_res_snomed_mrkr_code1.len != 0) 
  {
     get_snomed_marker_desc1();
	 print_snomed_marker1();
  }
  if (rl_res_snomed_mrkr_code2.len != 0) 
  {
     get_snomed_marker_desc2();
	 print_snomed_marker2();
  }	

}
/*-----------------------------------------------------*/

fprint_repeat(l_fp,l_prn_chr,l_no)
FILE *l_fp;
char l_prn_chr;
int  l_no;
{
   int l_i = 0;

   for (l_i = 0;l_i < l_no;l_i++)
        fputc(l_prn_chr,l_fp);
}
/*-----------------------------------------------------*/

page_break(l_skip)
int l_skip;
{
    lctr+= l_skip;
}
/*-----------------------------------------------------*/
open_result_text()
{
    /* EXEC SQL OPEN RL_RESULT_TEXT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0026;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2386;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&flag;
    sqlstm.sqhstl[5] = (unsigned int  )1;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&flag;
    sqlstm.sqhstl[6] = (unsigned int  )1;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_RESULT_TEXT_CUR",0,"");
}
/*-----------------------------------------------------*/

//added for MO-CRF-20134
open_bio_result_text()
{
    /* EXEC SQL OPEN RL_BIO_RESULT_TEXT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0027;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2429;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_BIO_RESULT_TEXT_CUR",0,"");
}

open_bio_result_comment()
{
    /* EXEC SQL OPEN rl_bio_result_comment_cur ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0028;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2460;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor rl_bio_result_comment",0,"");
}

//end MO-CRF-20134

int fetch_result_text()
{
#ifdef DEBUG
       printf("In fetch_result_text() \n");
#endif

/*
    rl_res_result_text1.arr[0]  = '\0';
    rl_res_result_text1.len     = 0;
    rl_res_result_text2.arr[0]  = '\0';
    rl_res_result_text2.len     = 0;
    rl_res_result_text3.arr[0]  = '\0';
    rl_res_result_text3.len     = 0;
    rl_res_result_text4.arr[0]  = '\0';
    rl_res_result_text4.len     = 0;
    rl_res_result_text5.arr[0]  = '\0';
    rl_res_result_text5.len     = 0;
    rl_res_result_text6.arr[0]  = '\0';
    rl_res_result_text6.len     = 0;
    rl_res_result_text7.arr[0]  = '\0';
    rl_res_result_text7.len     = 0;
    rl_res_result_text8.arr[0]  = '\0';
    rl_res_result_text8.len     = 0;
    rl_res_result_text9.arr[0]  = '\0';
    rl_res_result_text9.len     = 0;
    rl_res_result_text10.arr[0]  = '\0';
    rl_res_result_text10.len     = 0;
*/

    rl_res_result_text.arr[0]  = '\0';
    rl_res_result_text.len     = 0;

    rl_print_text_desc_yn.arr[0] = '\0';
    rl_print_text_desc_yn.len = 0;
    rl_print_text_bold_yn.arr[0] = '\0';
    rl_print_text_bold_yn.len = 0;
    rl_print_text_underline_yn.arr[0] = '\0';
    rl_print_text_underline_yn.len = 0;
    rl_res_result_text_code.arr[0] = '\0';
    rl_res_result_text_code.len = 0;


    /* EXEC SQL FETCH RL_RESULT_TEXT_CUR
              INTO :rl_res_result_text,
	      :rl_res_result_text_code, :rl_print_text_desc_yn,
		:rl_print_text_bold_yn, :rl_print_text_underline_yn; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2491;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_result_text;
    sqlstm.sqhstl[0] = (unsigned int  )2002;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_res_result_text_code;
    sqlstm.sqhstl[1] = (unsigned int  )12;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_print_text_desc_yn;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_print_text_bold_yn;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_print_text_underline_yn;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			  /*
			  :rl_res_result_text1,
                   :rl_res_result_text2,
                   :rl_res_result_text3,
                   :rl_res_result_text4,
                   :rl_res_result_text5,
                   :rl_res_result_text6,
                   :rl_res_result_text7,
                   :rl_res_result_text8,
                   :rl_res_result_text9,
                   :rl_res_result_text10
				*/
	      

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_RESULT_TEXT_CUR",0,"");

/*
    rl_res_result_text1.arr[rl_res_result_text1.len] = '\0';
    rl_res_result_text2.arr[rl_res_result_text2.len] = '\0';
    rl_res_result_text3.arr[rl_res_result_text3.len] = '\0';
    rl_res_result_text4.arr[rl_res_result_text4.len] = '\0';
    rl_res_result_text5.arr[rl_res_result_text5.len] = '\0';
    rl_res_result_text6.arr[rl_res_result_text6.len] = '\0';
    rl_res_result_text7.arr[rl_res_result_text7.len] = '\0';
    rl_res_result_text8.arr[rl_res_result_text8.len] = '\0';
    rl_res_result_text9.arr[rl_res_result_text9.len] = '\0';
    rl_res_result_text10.arr[rl_res_result_text10.len] = '\0';
*/

  rl_res_result_text.arr[rl_res_result_text.len] = '\0';
    rl_print_text_desc_yn.arr[rl_print_text_desc_yn.len] = '\0';
    rl_print_text_bold_yn.arr[rl_print_text_bold_yn.len] = '\0';
    rl_print_text_underline_yn.arr[rl_print_text_underline_yn.len] = '\0';
    rl_res_result_text_code.arr[rl_res_result_text_code.len]	= '\0';

  if (NODATAFOUND)
	return 0;

  return 1;

}
/*-----------------------------------------------------*/

//ADDED THE BELOW CODE FOR MO-CRF-20134

int fetch_bio_result_comment()
{
#ifdef DEBUG
       printf("In fetch_result_text() \n");
#endif

    rl_bio_result_comment_code.arr[0]  = '\0';
    rl_bio_result_comment_code.len     = 0;
	
	rl_bio_result_comment_desc.arr[0]  = '\0';
    rl_bio_result_comment_desc.len     = 0;

    //rl_bio_res_result_text_code.arr[0] = '\0';
   // rl_bio_res_result_text_code.len = 0;
	rl_bio_test_code.arr[0] = '\0';
    rl_bio_test_code.len = 0;
	rl_b_test_code.arr[0] = '\0';
    rl_b_test_code.len = 0;
	rl_b_grp_test_code.arr[0] = '\0';
    rl_b_grp_test_code.len = 0;


    /* EXEC SQL FETCH RL_BIO_RESULT_COMMENT_CUR
              INTO :rl_bio_test_code,:rl_bio_organism_code1,:rl_b_grp_test_code,:rl_b_test_code,
			  :rl_bio_result_comment_code,:rl_bio_result_comment_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2526;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_bio_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )12;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_bio_organism_code1;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_b_grp_test_code;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_b_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )22;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_bio_result_comment_code;
    sqlstm.sqhstl[4] = (unsigned int  )52;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_bio_result_comment_desc;
    sqlstm.sqhstl[5] = (unsigned int  )52;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_BIO_RESULT_COMMENT_CUR",0,"");

  if (NODATAFOUND)
	return 0;

  return 1;

}

int fetch_bio_result_text()
{
#ifdef DEBUG
       printf("In fetch_result_text() \n");
#endif

/*
    rl_res_result_text1.arr[0]  = '\0';
    rl_res_result_text1.len     = 0;
    rl_res_result_text2.arr[0]  = '\0';
    rl_res_result_text2.len     = 0;
    rl_res_result_text3.arr[0]  = '\0';
    rl_res_result_text3.len     = 0;
    rl_res_result_text4.arr[0]  = '\0';
    rl_res_result_text4.len     = 0;
    rl_res_result_text5.arr[0]  = '\0';
    rl_res_result_text5.len     = 0;
    rl_res_result_text6.arr[0]  = '\0';
    rl_res_result_text6.len     = 0;
    rl_res_result_text7.arr[0]  = '\0';
    rl_res_result_text7.len     = 0;
    rl_res_result_text8.arr[0]  = '\0';
    rl_res_result_text8.len     = 0;
    rl_res_result_text9.arr[0]  = '\0';
    rl_res_result_text9.len     = 0;
    rl_res_result_text10.arr[0]  = '\0';
    rl_res_result_text10.len     = 0;
*/

    rl_bio_res_result_text.arr[0]  = '\0';
    rl_bio_res_result_text.len     = 0;

    //rl_print_text_desc_yn.arr[0] = '\0';
   // rl_print_text_desc_yn.len = 0;
   // rl_print_text_bold_yn.arr[0] = '\0';
   // rl_print_text_bold_yn.len = 0;
   // rl_print_text_underline_yn.arr[0] = '\0';
   // rl_print_text_underline_yn.len = 0;
    rl_bio_res_result_text_code.arr[0] = '\0';
    rl_bio_res_result_text_code.len = 0;
	rl_bio_test_code.arr[0] = '\0';
    rl_bio_test_code.len = 0;
	rl_b_test_code.arr[0] = '\0';
    rl_b_test_code.len = 0;
	rl_b_grp_test_code.arr[0] = '\0';
    rl_b_grp_test_code.len = 0;


    /* EXEC SQL FETCH RL_BIO_RESULT_TEXT_CUR
              INTO :rl_bio_res_result_text,:rl_bio_res_result_text_code, 
			  :rl_bio_test_code,:rl_bio_organism_code,:rl_b_grp_test_code,:rl_b_test_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2565;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_bio_res_result_text;
    sqlstm.sqhstl[0] = (unsigned int  )2002;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_bio_res_result_text_code;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_bio_test_code;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_bio_organism_code;
    sqlstm.sqhstl[3] = (unsigned int  )22;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_b_grp_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )22;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_b_test_code;
    sqlstm.sqhstl[5] = (unsigned int  )22;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			  
    
			  
	      
			  /*
			  :rl_res_result_text1,
                   :rl_res_result_text2,
                   :rl_res_result_text3,
                   :rl_res_result_text4,
                   :rl_res_result_text5,
                   :rl_res_result_text6,
                   :rl_res_result_text7,
                   :rl_res_result_text8,
                   :rl_res_result_text9,
                   :rl_res_result_text10
				*/
	      

    if (OERROR)
         err_mesg("FETCH failed on cursor RL_BIO_RESULT_TEXT_CUR",0,"");

/*
    rl_res_result_text1.arr[rl_res_result_text1.len] = '\0';
    rl_res_result_text2.arr[rl_res_result_text2.len] = '\0';
    rl_res_result_text3.arr[rl_res_result_text3.len] = '\0';
    rl_res_result_text4.arr[rl_res_result_text4.len] = '\0';
    rl_res_result_text5.arr[rl_res_result_text5.len] = '\0';
    rl_res_result_text6.arr[rl_res_result_text6.len] = '\0';
    rl_res_result_text7.arr[rl_res_result_text7.len] = '\0';
    rl_res_result_text8.arr[rl_res_result_text8.len] = '\0';
    rl_res_result_text9.arr[rl_res_result_text9.len] = '\0';
    rl_res_result_text10.arr[rl_res_result_text10.len] = '\0';
*/

  /*rl_res_result_text.arr[rl_res_result_text.len] = '\0';
    rl_print_text_desc_yn.arr[rl_print_text_desc_yn.len] = '\0';
    rl_print_text_bold_yn.arr[rl_print_text_bold_yn.len] = '\0';
    rl_print_text_underline_yn.arr[rl_print_text_underline_yn.len] = '\0';
    rl_res_result_text_code.arr[rl_res_result_text_code.len]	= '\0';*/

  if (NODATAFOUND)
	return 0;

  return 1;

}
/*-----------------------------------------------------*/

//END MO-CRF-20134
get_rl_test_result(l_test_code)
char l_test_code[];
{
    test_result_found = 1;
    strcpy(rl_loc_test_code.arr,l_test_code);
    rl_loc_test_code.len = strlen(rl_loc_test_code.arr);

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


    rl_func_value.arr[0] = '\0';
    rl_func_value.len    = 0;

    /* EXEC SQL SELECT NUMERIC_RESULT INTO :rl_func_value
               FROM RL_TEST_RESULT
              WHERE PATIENT_ID      = :nd_hosp_no
                AND SPECIMEN_NO     = :nd_spec_no
                AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND TEST_CODE       = :rl_loc_test_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NUMERIC_RESULT into :b0  from RL_TEST_RESULT where\
 (((PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) and TES\
T_CODE=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2604;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_func_value;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_loc_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
    if (sqlca.sqlcode < 0) goto err_exit;
}



    if(NODATAFOUND); 
/*
    {
       disp_message(ORA_MESG,"OERROR occurred at get_rl_test_result() no_data_found");
       proc_exit();	
    }
*/

    rl_func_value.arr[rl_func_value.len] = '\0';

    if(strlen(rl_func_value.arr) == 0)
       test_result_found = 0;
return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   disp_message(ORA_MESG,"OERROR occurred at get_rl_test_result()");
   return;

}
/*-----------------------------------------------------*/
ltrim(l_str)
char *l_str;
{
   char *ptr;
   ptr = l_str;
   while (*ptr== ' ') ptr++;
   for(;*ptr!='\0';ptr++,l_str++)
    *l_str = *ptr;
   *l_str = '\0';
}
/*-----------------------------------------------------*/

rtrim(l_str)
char *l_str;
{
  while (*l_str != '\0') *l_str++;
  l_str--;
  while (*l_str == ' ') *l_str--;
  *(l_str+1) = '\0';
}
/*-----------------------------------------------------*/
open_function_cur()
{
    /* EXEC SQL OPEN RL_FUNCTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0020;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2639;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_loc_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("OPEN failed on cursor RL_FUNCTION_CUR",0,"");
}
/*-----------------------------------------------------*/

fetch_function_cur()
{
    rl_func_operand_1.arr[0]          = '\0';
    rl_func_operand_1_type.arr[0]     = '\0';
    rl_func_operator_1.arr[0]         = '\0';
    rl_func_operand_2.arr[0]          = '\0';
    rl_func_operand_2_type.arr[0]     = '\0';
    rl_func_operator_2.arr[0]         = '\0';

    rl_func_operand_1.len             = 0;
    rl_func_operand_1_type.len        = 0;
    rl_func_operator_1.len            = 0;
    rl_func_operand_2.len             = 0;
    rl_func_operand_2_type.len        = 0;
    rl_func_operator_2.len            = 0;

    /* EXEC SQL FETCH RL_FUNCTION_CUR
              INTO :rl_func_operand_1,
                   :rl_func_operand_1_type,
                   :rl_func_operator_1,
                   :rl_func_operand_2,
                   :rl_func_operand_2_type,
                   :rl_func_operator_2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2658;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_func_operand_1;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_func_operand_1_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_func_operator_1;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_func_operand_2;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_func_operand_2_type;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_func_operator_2;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("FETCH failed on cursor RL_FUNCTION_CUR",0,"");

    rl_func_operand_1.arr[rl_func_operand_1.len]           = '\0';
    rl_func_operand_1_type.arr[rl_func_operand_1_type.len] = '\0';
    rl_func_operator_1.arr[rl_func_operator_1.len]         = '\0';
    rl_func_operand_2.arr[rl_func_operand_2.len]           = '\0';
    rl_func_operand_2_type.arr[rl_func_operand_2_type.len] = '\0';
    rl_func_operator_2.arr[rl_func_operator_2.len]         = '\0';
#ifdef DEBUG
    printf("oprd 1 %s \n",rl_func_operand_1.arr);
    printf("oprd 1 type %s \n",rl_func_operand_1_type.arr);
    printf("opr 1 %s \n",rl_func_operator_1.arr);
    printf("oprd 2 %s \n",rl_func_operand_2.arr);
    printf("oprd 2 type %s \n",rl_func_operand_2_type.arr);
    printf("opr 2 %s \n",rl_func_operator_2.arr);
#endif
    return (LAST_ROW?0:1);
}
/*--------------------------------------------------------------------*/
close_all_cur()
{
    /* EXEC SQL CLOSE RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2697;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_TEST_RESULT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2712;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_PAT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2727;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_SPECIMEN_TYPE_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2742;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_SECTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2757;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_TEST_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2772;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_AGE_SEX_RANGE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2787;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_COMM_FOR_TEST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2802;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_RESULT_TEXT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2817;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_TEST_RESULT_CUR2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2832;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_RESULT_SNOMED_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2847;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_SNOMED_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2862;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_RESULT_ORGANISM_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2877;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RL_ANTIBIOTIC_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2892;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RL_SENSITIVITY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2907;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_ORGANISM_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2922;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_ANTIBIOTIC_CODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2937;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_PAT_MAST3_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2952;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




#ifdef DEBUG
	     printf(" In close_all_cur() \n");
#endif
}


/* SPLITTING THE VARCHAR 2000 INTO 70 CHARACTERS   */
/************************************************/
void splitting()
{
    int fetch_result_text();
	char word[2];
	char w_flag ;

    strcpy(word1,"F");

	w_flag = 'T';

    while(fetch_result_text())
    {
          
		  	/***** ADDED FOR SCF42 OF QATAR *****/		
			something_to_print = 1;
			something_to_print_for_test = 1;

		  hell = strlen(rl_res_result_text.arr);

			if(group && !group_printed)
			{   print_group_test_desc();
				group_printed = 1;
			}
			if(!test_printed  && strlen(test_description))
			{     numeric_value_flag = FALSE;  
				sprintf(text_line,"%37.37s%-40s",test_description," ");
					print_line_check(text_line);
			    test_printed = 1;
			}

/***** added for KDAH requirement to print the long desc of the result text **********/
//sprintf(string_var, "String  -> [%s]  [%s]", rl_print_text_desc_yn.arr, rl_res_result_text_code.arr);
//disp_message(ERR_MESG, string_var);

	 if ((strcmp(rl_print_text_desc_yn.arr, "Y") == 0) && (strlen(rl_res_result_text_code.arr) > 0))
	 {
		
		get_text_code_desc();

		if (strlen(rl_res_text_code_desc.arr) > 0)
			print_text_code_desc();

	 }

         z = 0;
	     clt = 0;
	     strcpy(word1,"F");
	     cntr = 1;
	     qq = 0;

         while(z<hell)
         {
		 		  	
		 
             word[0] = rl_res_result_text.arr[z];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
   
		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
		      }


  		      if(cntr >= 71)
		      {
		   	
			     cmp = cntr;
			     while((rl_res_result_text.arr[z] != 32) && (cmp > 1))
			     {

			         z--;
				     cmp--;
				  
			      }

				  qq = z;
				  			   
			      word[0] = rl_res_result_text.arr[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
			   
		
		       }


				if (((z == hell) || (z == hell - 1)) && (strcmp(word1,"F") == 0))
				{
	
				   fprint_repeat(fp,' ',8);		   
				   for(i=clt;i < z + 1;i++)
		           {
			       		
						if(rl_res_result_text.arr[i] == '\n')
						{
						//  if ((z + 1 - clt) < 70)
						 // {
						 	   fprintf(fp,"%c%c%c%c%c%c",
						         rl_tst_status.arr[0],
							     rl_tst_tech_status.arr[0],
								 rl_tst_delta_status.arr[0],
								 rl_tst_qlty_status.arr[0],
								 rl_tst_cmnt_status.arr[0],
								 rl_tst_path_status.arr[0]);

							    w_flag = 'F';
						  // }
 						 }

						fprintf(fp,"%c",rl_res_result_text.arr[i]);
			
			       }

				   if (w_flag == 'T')
				   {
				    	fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
					   		   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);
				   }

			       fprintf	(fp,"\n");
				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");


				}

			
		       if (strcmp(word1,"N") == 0) 
		       {
				
		          fprint_repeat(fp,' ',8);		   
				  for(i=clt;i<=qq;i++)
		          {
			         if(rl_res_result_text.arr[i] == '\n')
					{
						  
						  //if ((qq  - clt) < 70)
						 //{
							fprintf(fp,"%c%c%c%c%c%c",
						        rl_tst_status.arr[0],
							    rl_tst_tech_status.arr[0],
								rl_tst_delta_status.arr[0],
								rl_tst_qlty_status.arr[0],
								rl_tst_cmnt_status.arr[0],
								rl_tst_path_status.arr[0]);
								w_flag = 'F';
						 //}

				    }

				    fprintf(fp,"%c",rl_res_result_text.arr[i]);
					
			      }

				  if (w_flag == 'T')
				  {
				   	 fprintf(fp,"%c%c%c%c%c%c",
					      rl_tst_status.arr[0],
					      rl_tst_tech_status.arr[0],
					  	  rl_tst_delta_status.arr[0],
						  rl_tst_qlty_status.arr[0],
						  rl_tst_cmnt_status.arr[0],
						  rl_tst_path_status.arr[0]);
				  }
					
			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

		       if (strcmp(word1,"T") == 0)
		       {
		 										 
			      fprint_repeat(fp,' ',8);		   
				  for(i=clt;i<= qq;i++)
		          {
		             if(rl_res_result_text.arr[i] == '\n')
					 {
						 
						 // if ((qq  - clt) < 70)
						  //{
							fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
							   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);

								w_flag = 'F';
							//}

					  }

					  fprintf(fp,"%c",rl_res_result_text.arr[i]);
				
			      }

				  if (w_flag == 'T')
				  {
						fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
							   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);
					}


			       fprintf	(fp,"\n");
			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }


		        if (strcmp(word1,"W") == 0)
		        {
		 										 
			       fprint_repeat(fp,' ',8);		   
				   for(i=clt;i < clt + 70;i++)
		           {
		              if(rl_res_result_text.arr[i] == '\n')
						{

						//  if ((clt + 70 - clt) < 70)
						  //{
							fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
							   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);

								w_flag = 'F';
							//}

						}

						fprintf(fp,"%c",rl_res_result_text.arr[i]);
				
			       }

				   if (w_flag = 'T')
				   {
						fprintf(fp,"%c%c%c%c%c%c",
				  	         rl_tst_status.arr[0],
							 rl_tst_tech_status.arr[0],
							 rl_tst_delta_status.arr[0],
							 rl_tst_qlty_status.arr[0],
							 rl_tst_cmnt_status.arr[0],
							 rl_tst_path_status.arr[0]);
				   }

			       fprintf(fp,"\n");
				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }

			w_flag = 'T';	  
	        cntr += 1;
	        z++ ;
          }

		
      }
  
       fflush(fp);

#ifdef DEBUG
   printf("rl_res_result_text = %s\n", rl_res_result_text.arr);
#endif

if (OERROR)
      err_mesg("SPLITTING failed on table RL_RESULT_TEXT",0,"");

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   disp_message(ORA_MESG,"Error occurred at splitting()");
   return;

}


//ADDED THE BELWO CODE FOR MO-CRF-20134


print_bio_text_code_desc()
{

int l_len = 0;

//sprintf(string_var, "String  -> [%s]  ", rl_res_text_code_desc.arr);
//disp_message(ERR_MESG, string_var);

	fprint_repeat(fp,' ',8);
/*
	
	if (strcmp(rl_print_text_underline_yn.arr, "Y") == 0)
	{
		fprintf(fp,"%c&d0D",ESC);   // Set  UnderLine ON
	}
	if (strcmp(rl_print_text_bold_yn.arr, "Y") == 0)
	{
	   	fprintf(fp,"%c(s4B",ESC);   // Set Bold 
	}

*/


	fprintf(fp,"%s%c%c%c%c%c%c\n",rl_bio_text_code_desc.arr,
					rl_tst_status.arr[0], rl_tst_tech_status.arr[0],
		rl_tst_delta_status.arr[0], rl_tst_qlty_status.arr[0],
		rl_tst_cmnt_status.arr[0], rl_tst_path_status.arr[0]);	
	
	page_break(1);

	l_len = strlen(rl_bio_text_code_desc.arr);
	//if (strcmp(rl_print_text_underline_yn.arr, "Y") == 0)
	//{
		fprint_repeat(fp,' ',8);
		fprint_repeat(fp,'-', l_len);
	
		fprintf(fp, "%c%c%c%c%c%c\n", rl_tst_status.arr[0], rl_tst_tech_status.arr[0],
			rl_tst_delta_status.arr[0], rl_tst_qlty_status.arr[0],
			rl_tst_cmnt_status.arr[0], rl_tst_path_status.arr[0]);

		page_break(1);
	//}

/*
   	fprintf(fp,"%c(s4B",ESC);
   	fprintf(fp,"%c(s-3B",ESC);
	fprintf(fp,"%c&d@",ESC);   // Set UnderLine OFF 
*/

}


get_bio_text_code_desc()	
{
	rl_bio_text_code_desc.arr[0] = '\0';
	
	/* EXEC SQL SELECT long_desc
		INTO :rl_bio_text_code_desc
		FROM RL_RESULT_TEXT_CODE
		WHERE result_text_code = :rl_bio_res_result_text_code
		AND section_code = :rl_hdr_section_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_RESULT_TEXT_CODE where (r\
esult_text_code=:b1 and section_code=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2967;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_bio_text_code_desc;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_bio_res_result_text_code;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_hdr_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	rl_bio_text_code_desc.arr[rl_bio_text_code_desc.len]	= 0;

	if(NODATAFOUND);

	if (OERROR);

}

void result_comment_biochem()
{
    int fetch_bio_result_comment();
	//int l_heading_printed=0;
	int l_heading_printed1=0;
	int b_group_test_printed=0;
		
	char  v_next_org_code1[100];
	char  v_next_test_code[100];
	
	strcpy(v_next_org_code1,"!!");
	strcpy(v_next_test_code,"!!");
	
	strcpy(d_l_str_bio.arr,"Bio-chemical tests"); 
	strcpy(d_l_str_org_leg.arr,"Organism :"); 
	
	l_heading_printed1 = 0;
	while(fetch_bio_result_comment())
    {
	 if (strcmp(v_next_org_code1,rl_bio_organism_code.arr)!=0)
			{
			
			//fetch_bio_org_desc;
			
			if (l_heading_printed1==0)
			{
		   // sprintf(text_line,"%18.18s%-80s","Bio-Chemical Tests"," ");
			//print_line_check("Bio-Chemical Tests");
			//fprintf(fp, "          \n                      ** --> Critical Value  CCCCCC\n");
			//fprintf(fp,"Bio-Chemical Tests  CCCCCC\n");
			//print_line("Bio-Chemical Tests");
			print_line(d_l_str_bio.arr);
			//print_line(d_l_str_bio.arr);
			l_heading_printed1=1;
			}
			rl_bio_organism_code1.arr[rl_bio_organism_code1.len] = '\0';
			rl_bio_organism_code_desc1.arr[rl_bio_organism_code_desc1.len] = '\0';
			/* EXEC SQL OPEN RL_BIO_ORGANISM_CODE_CUR1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0040;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2994;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_bio_organism_code1;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			/* EXEC SQL FETCH RL_BIO_ORGANISM_CODE_CUR1
              INTO :rl_bio_organism_code_desc1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3013;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_bio_organism_code_desc1;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			  
			  
		//	print_line(rl_bio_organism_code_desc1.arr);
			//print_line(strcat("Organism :",rl_bio_organism_code1.arr));
			print_line(strcat(d_l_str_org_leg.arr,strcat(strcat(rl_bio_organism_code1.arr," "),rl_bio_organism_code_desc1.arr)));
			//print_line(strcat(strcat(rl_bio_organism_code1.arr," "),rl_bio_organism_code_desc1.arr));
			
			
			if (OERROR)
			{
				rl_bio_organism_code1.arr[rl_bio_organism_code1.len] = '\0';
			rl_bio_organism_code_desc1.arr[rl_bio_organism_code_desc1.len] = '\0';
			}
			
			
			}
			/* EXEC SQL OPEN RL_BIO_TEST_CODE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0041;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3032;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_b_grp_test_code;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			/* EXEC SQL FETCH RL_BIO_TEST_CODE_CUR
              INTO :b_group_test_desc,:b_group_test_yn; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3051;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&b_group_test_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&b_group_test_yn;
   sqlstm.sqhstl[1] = (unsigned int  )3;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			  
			
			  
			if (OERROR)
			{
			  b_test_desc.arr[b_test_desc.len] = '\0';
			  b_group_test_desc.arr[b_group_test_desc.len] = '\0';
			}
		
			
			 //print_line(b_group_test_desc.arr);
			if(strcmp(b_group_test_yn.arr,"N")==0)
			{
			b_group_test_printed=0;
			}
			
			if((strcmp(b_group_test_yn.arr,"Y")==0) &&b_group_test_printed==0)
			{
			print_line(b_group_test_desc.arr);
			
			
			/* EXEC SQL OPEN RL_BIO_IND_TEST_CODE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0042;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3074;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_b_test_code;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			/* EXEC SQL FETCH RL_BIO_IND_TEST_CODE_CUR
              INTO :b_test_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3093;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&b_test_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
			  
			b_test_desc.arr[b_test_desc.len] = '\0';
			b_group_test_desc.arr[b_group_test_desc.len] = '\0';
			rl_bio_result_comment_code.arr[rl_bio_result_comment_code.len] = '\0';
			rl_bio_result_comment_desc.arr[rl_bio_result_comment_desc.len] = '\0';
			
			//rl_bio_result_comment_code.arr ,rl_bio_result_comment_desc.arr)
			 
			//print_line(strcat(strcat(b_test_desc.arr," "),rl_bio_result_comment_desc.arr));
			print_line(strcat(strcat(strcat(strcat(b_test_desc.arr," "),rl_bio_result_comment_code.arr)," "),rl_bio_result_comment_desc.arr));
		
			b_group_test_printed=1;
			}
			else
			{
			
			//b_test_desc.arr[b_test_desc.len] = '\0';
			//b_group_test_desc.arr[b_group_test_desc.len] = '\0';
			
			
			/* EXEC SQL OPEN RL_BIO_IND_TEST_CODE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0042;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3112;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_b_test_code;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			/* EXEC SQL FETCH RL_BIO_IND_TEST_CODE_CUR
              INTO :b_test_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3131;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&b_test_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

  
			  
			b_test_desc.arr[b_test_desc.len] = '\0';
			b_group_test_desc.arr[b_group_test_desc.len] = '\0';
			rl_bio_result_comment_code.arr[rl_bio_result_comment_code.len] = '\0';
			rl_bio_result_comment_desc.arr[rl_bio_result_comment_desc.len] = '\0';
			
			if (strcmp(v_next_test_code,rl_b_test_code.arr)!=0)
			{
			//print_line(b_test_desc.arr);
			//print_line(strcat(strcat(b_test_desc.arr," "),rl_bio_result_comment_code.arr));
			print_line(strcat(strcat(strcat(strcat(b_test_desc.arr," "),rl_bio_result_comment_code.arr)," "),rl_bio_result_comment_desc.arr));
			}
			
			}
			//print_line(rl_bio_result_comment_desc.arr);
			strcpy(v_next_test_code,rl_b_test_code.arr);
		
	strcpy(v_next_org_code1,rl_bio_organism_code.arr);
	}
    
	
}
/*----------------------------------------------*/

void splitting_biochem()
{
    int fetch_bio_result_text();
	char word[2];
	char w_flag ;
	
	int l_heading_printed=0;
	int b_group_test_printed=0;
	
	char  v_next_org_code[100];
	char  v_next_test_code[100];
	
	
	

    strcpy(word1,"F");

	w_flag = 'T';

	strcpy(v_next_org_code,"!!");
	strcpy(v_next_test_code,"!!");
	strcpy(d_l_str_bio.arr,"Bio-chemical tests");
	strcpy(d_l_str_org_leg.arr,"Organism :"); 
	
	
    while(fetch_bio_result_text())
    {
          
		  	/***** ADDED FOR SCF42 OF QATAR *****/		
			something_to_print = 1;
			something_to_print_for_test = 1;

		  hell = strlen(rl_bio_res_result_text.arr);
		  
		    b_group_test_desc.arr[0]    = '\0';
			b_group_test_desc.len    = 0;
	
			
		  
		  if (l_heading_printed1==0)
		  {
		   // sprintf(text_line,"%18.18s%-80s","Bio-Chemical Tests"," ");
			//print_line_check("Bio-Chemical Tests");
			//fprintf(fp, "          \n                      ** --> Critical Value  CCCCCC\n");
			//fprintf(fp,"Bio-Chemical Tests  CCCCCC\n");
			//print_line("Bio-Chemical Tests");
			print_line(d_l_str_bio.arr);
			l_heading_printed1=1;
		  }
		  //fetch_bio_org_desc;
			//sprintf(text_line,"%-s%",rl_bio_organism_code.arr);
			if (strcmp(v_next_org_code,rl_bio_organism_code.arr)!=0)
			{
			
			//fetch_bio_org_desc;
			
			rl_bio_organism_code.arr[rl_bio_organism_code.len] = '\0';
			rl_bio_organism_code_desc.arr[rl_bio_organism_code_desc.len] = '\0';
			/* EXEC SQL OPEN RL_BIO_ORGANISM_CODE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0039;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3150;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_bio_organism_code;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			/* EXEC SQL FETCH RL_BIO_ORGANISM_CODE_CUR
              INTO :rl_bio_organism_code_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3169;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_bio_organism_code_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			  
			  rl_bio_organism_code1.arr[rl_bio_organism_code1.len] = '\0';
			//print_line(rl_bio_organism_code_desc.arr);
			print_line(strcat(d_l_str_org_leg.arr,strcat(strcat(rl_bio_organism_code.arr,"  "),rl_bio_organism_code_desc.arr)));
			//rl_bio_organism_code.arr[rl_bio_organism_code.len] = '\0';
			//rl_bio_organism_code_desc.arr[rl_bio_organism_code_desc.len] = '\0';
			}
			/* EXEC SQL OPEN RL_BIO_TEST_CODE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0041;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3188;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_b_grp_test_code;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			/* EXEC SQL FETCH RL_BIO_TEST_CODE_CUR
              INTO :b_group_test_desc,:b_group_test_yn; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3207;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&b_group_test_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&b_group_test_yn;
   sqlstm.sqhstl[1] = (unsigned int  )3;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			  
			
			  
			if (OERROR)
			{
			  b_test_desc.arr[b_test_desc.len] = '\0';
			  b_group_test_desc.arr[b_group_test_desc.len] = '\0';
			}
		
			
			 //print_line(b_group_test_desc.arr);
			if(strcmp(b_group_test_yn.arr,"N")==0)
			{
			b_group_test_printed=0;
			}
			
			if((strcmp(b_group_test_yn.arr,"Y")==0) &&b_group_test_printed==0)
			{
			print_line(b_group_test_desc.arr);
			
			
			/* EXEC SQL OPEN RL_BIO_IND_TEST_CODE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0042;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3230;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_b_test_code;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			/* EXEC SQL FETCH RL_BIO_IND_TEST_CODE_CUR
              INTO :b_test_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3249;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&b_test_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
			  
			b_test_desc.arr[b_test_desc.len] = '\0';
			b_group_test_desc.arr[b_group_test_desc.len] = '\0';
			 
			print_line(b_test_desc.arr);
		
			b_group_test_printed=1;
			}
			else
			{
			
			//b_test_desc.arr[b_test_desc.len] = '\0';
			//b_group_test_desc.arr[b_group_test_desc.len] = '\0';
			
			
			/* EXEC SQL OPEN RL_BIO_IND_TEST_CODE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0042;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3268;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_b_test_code;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			/* EXEC SQL FETCH RL_BIO_IND_TEST_CODE_CUR
              INTO :b_test_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3287;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&b_test_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

  
			  
			b_test_desc.arr[b_test_desc.len] = '\0';
			b_group_test_desc.arr[b_group_test_desc.len] = '\0';
			
			if (strcmp(v_next_test_code,rl_b_test_code.arr)!=0)
			{
			print_line(b_test_desc.arr);
			}
			
			//rl_b_test_code.arr[rl_b_test_code.len] = '\0';
			//b_test_desc.arr[b_test_desc.len] = '\0';
			//b_group_test_desc.arr[b_group_test_desc.len] = '\0';
			
			
			}
			strcpy(v_next_test_code,rl_b_test_code.arr);
			//print_line(rl_b_grp_test_code.arr);
			//print_line(rl_b_test_code.arr);
			
			
			/*if(group && !group_printed)
			{   print_group_test_desc();
				group_printed = 1;
			}
			if(!test_printed  && strlen(test_description))
			{     numeric_value_flag = FALSE;  
				sprintf(text_line,"%37.37s%-40s",test_description," ");
					print_line_check(text_line);
			    test_printed = 1;
			}*/

/***** added for KDAH requirement to print the long desc of the result text **********/
//sprintf(string_var, "String  -> [%s]  [%s]", rl_print_text_desc_yn.arr, rl_res_result_text_code.arr);
//disp_message(ERR_MESG, string_var);

	 /*if ((strcmp(rl_print_text_desc_yn.arr, "Y") == 0) && (strlen(rl_res_result_text_code.arr) > 0))
	 {
		
		get_text_code_desc();

		if (strlen(rl_res_text_code_desc.arr) > 0)
			print_text_code_desc();

	 }*/
		get_bio_text_code_desc();
		if (strlen(rl_res_text_code_desc.arr) > 0)
		print_bio_text_code_desc;
		
		fprintf(fp,rl_bio_text_code_desc.arr);
		
		
         
		 //print_line(rl_bio_text_code_desc.arr);
		 z = 0;
	     clt = 0;
	     strcpy(word1,"F");
	     cntr = 1;
	     qq = 0;

         while(z<hell)
         {
		 		  	
		 
             word[0] = rl_bio_res_result_text.arr[z];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
   
		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
		      }


  		      if(cntr >= 71)
		      {
		   	
			     cmp = cntr;
			     while((rl_bio_res_result_text.arr[z] != 32) && (cmp > 1))
			     {

			         z--;
				     cmp--;
				  
			      }

				  qq = z;
				  			   
			      word[0] = rl_bio_res_result_text.arr[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
			   
		
		       }


				if (((z == hell) || (z == hell - 1)) && (strcmp(word1,"F") == 0))
				{
	
				   fprint_repeat(fp,' ',8);		   
				   for(i=clt;i < z + 1;i++)
		           {
			       		
						if(rl_bio_res_result_text.arr[i] == '\n')
						{
						//  if ((z + 1 - clt) < 70)
						 // {
						 	   fprintf(fp,"%c%c%c%c%c%c",
						         rl_tst_status.arr[0],
							     rl_tst_tech_status.arr[0],
								 rl_tst_delta_status.arr[0],
								 rl_tst_qlty_status.arr[0],
								 rl_tst_cmnt_status.arr[0],
								 rl_tst_path_status.arr[0]);

							    w_flag = 'F';
						  // }
 						 }

						fprintf(fp,"%c",rl_bio_res_result_text.arr[i]);
			
			       }

				   if (w_flag == 'T')
				   {
				    	fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
					   		   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);
				   }

			       fprintf	(fp,"\n");
				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");


				}

			
		       if (strcmp(word1,"N") == 0) 
		       {
				
		          fprint_repeat(fp,' ',8);		   
				  for(i=clt;i<=qq;i++)
		          {
			         if(rl_bio_res_result_text.arr[i] == '\n')
					{
						  
						  //if ((qq  - clt) < 70)
						 //{
							fprintf(fp,"%c%c%c%c%c%c",
						        rl_tst_status.arr[0],
							    rl_tst_tech_status.arr[0],
								rl_tst_delta_status.arr[0],
								rl_tst_qlty_status.arr[0],
								rl_tst_cmnt_status.arr[0],
								rl_tst_path_status.arr[0]);
								w_flag = 'F';
						 //}

				    }

				    fprintf(fp,"%c",rl_bio_res_result_text.arr[i]);
					
			      }

				  if (w_flag == 'T')
				  {
				   	 fprintf(fp,"%c%c%c%c%c%c",
					      rl_tst_status.arr[0],
					      rl_tst_tech_status.arr[0],
					  	  rl_tst_delta_status.arr[0],
						  rl_tst_qlty_status.arr[0],
						  rl_tst_cmnt_status.arr[0],
						  rl_tst_path_status.arr[0]);
				  }
					
			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

		       if (strcmp(word1,"T") == 0)
		       {
		 										 
			      fprint_repeat(fp,' ',8);		   
				  for(i=clt;i<= qq;i++)
		          {
		             if(rl_bio_res_result_text.arr[i] == '\n')
					 {
						 
						 // if ((qq  - clt) < 70)
						  //{
							fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
							   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);

								w_flag = 'F';
							//}

					  }

					  fprintf(fp,"%c",rl_bio_res_result_text.arr[i]);
				
			      }

				  if (w_flag == 'T')
				  {
						fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
							   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);
					}


			       fprintf	(fp,"\n");
			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }


		        if (strcmp(word1,"W") == 0)
		        {
		 										 
			       fprint_repeat(fp,' ',8);		   
				   for(i=clt;i < clt + 70;i++)
		           {
		              if(rl_bio_res_result_text.arr[i] == '\n')
						{

						//  if ((clt + 70 - clt) < 70)
						  //{
							fprintf(fp,"%c%c%c%c%c%c",
						       rl_tst_status.arr[0],
							   rl_tst_tech_status.arr[0],
							   rl_tst_delta_status.arr[0],
							   rl_tst_qlty_status.arr[0],
							   rl_tst_cmnt_status.arr[0],
							   rl_tst_path_status.arr[0]);

								w_flag = 'F';
							//}

						}

						fprintf(fp,"%c",rl_bio_res_result_text.arr[i]);
				
			       }

				   if (w_flag = 'T')
				   {
						fprintf(fp,"%c%c%c%c%c%c",
				  	         rl_tst_status.arr[0],
							 rl_tst_tech_status.arr[0],
							 rl_tst_delta_status.arr[0],
							 rl_tst_qlty_status.arr[0],
							 rl_tst_cmnt_status.arr[0],
							 rl_tst_path_status.arr[0]);
				   }

			       fprintf(fp,"\n");
				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }

			w_flag = 'T';	  
	        cntr += 1;
	        z++ ;
          }

		strcpy(v_next_org_code,rl_bio_organism_code.arr);
      }
  
       fflush(fp);

#ifdef DEBUG
   printf("rl_bio_res_result_text = %s\n", rl_bio_res_result_text.arr);
#endif

if (OERROR)
      err_mesg("splitting_biochem failed on table RL_RESULT_TEXT",0,"");

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   disp_message(ORA_MESG,"Error occurred at splitting_biochem()");
   return;

}



//END MO-CRF-20134

/*------------------------------------------------------------*/
build_table()
{
	int i;

	l_should_print_yn = 'N';
	d_interval_specimen_yn = 'N';

	i = 1;

	/* EXEC SQL DECLARE int_curs CURSOR FOR 
				SELECT DISTINCT TO_CHAR(A.interval_test_specimen_no)
				FROM RL_INTERVAL_TEST_SPECIMENS A 
				WHERE A.specimen_no = TO_NUMBER(:nd_spec_no) 
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND NVL(A.cancelled_yn, 'N') <> 'Y'
	            AND ( 
				       (:flag IN ('W','C') AND NVL(status,'O') IN ('R','P'))
				       OR
					   (:flag IN  ('L', 'K'))
					 ); */ 



	/* EXEC SQL OPEN int_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0061;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3306;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_spec_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&flag;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&flag;
 sqlstm.sqhstl[3] = (unsigned int  )1;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	//test_count(); //added for ML-MMOH-SCF-0934

	while(fetch_int_curs())
	{
	   if ((flag == 'W') || (flag == 'C'))
	   {
		//commented out for ML-BRU-SCF-2045
		/*EXEC SQL SELECT COUNT(*)
				 INTO :i_count
				 FROM RL_INTERVAL_TEST_SPECIMENS
				 WHERE interval_test_specimen_no = TO_NUMBER(:d_no) 
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND NVL(cancelled_yn, 'N') <> 'Y'
				 AND NVL(status, 'O') NOT IN ('R', 'P');*/
		i_count = 0;//added for ML-BRU-SCF-2045
		}
		else
		{
		  i_count = 0;
		}

		if (i_count == 0)
		{
			declare_spec_curs();
			while(fetch_spec_curs())
			{
				if (i == 1)
				{
				   strcpy(first_specimen_no.arr, d_specimen_no.arr);
				   first_specimen_no.len = strlen(first_specimen_no.arr);
				   i++;
				}

				/* EXEC SQL INSERT INTO RL_INTERVAL_TEST_TEMP
						 (operating_facility_id,user_id, session_id, specimen_no, group_test_code, test_code, seq_no)
						 VALUES
						 (:nd_operating_facility_id,USER, USERENV('sessionid'), TO_NUMBER(:d_specimen_no), 
									:d_group_test_code, :d_test_code, :d_seq_no); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into RL_INTERVAL_TEST_TEMP (operating_facility_id,\
user_id,session_id,specimen_no,group_test_code,test_code,seq_no) values (:b0,U\
SER,USERENV('sessionid'),TO_NUMBER(:b1),:b2,:b3,:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3337;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_specimen_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_group_test_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_seq_no;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



				l_should_print_yn = 'Y';
				d_interval_specimen_yn = 'Y';
			}
			close_spec_curs();
		}
	}

	close_int_curs();

	/* EXEC SQL DECLARE req_curs CURSOR FOR  
				SELECT test_code
				FROM RL_REQUEST_DETAIL
				WHERE specimen_no = TO_NUMBER(:nd_spec_no) 
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND NVL(cancelled_yn, 'N') <> 'Y'
	             AND ( 
				       (:flag IN ('W','C') AND NVL(result_status,'O') IN ('R','P'))
					   OR (:flag IN ('W','C') AND test_code in (SELECT test_code 
															      FROM RL_TEST_CODE
															     WHERE NVL(PROFILE_YN,'N') = 'Y'
															       AND NVL(GROUP_TEST_YN,'N') = 'Y'
															   )  /// 21.05.2005
							                  AND ( NVL(result_status,'O') = 'O'
													OR (NVL(result_status,'O') IN ('A') AND released_date IS NOT NULL))
						  )
					   OR (:flag IN ('W','C') AND NVL(preliminary_release_yn,'N') = 'Y' AND NVL(result_status,'O') IN ('A') )  /// 22.08.2006
				       OR
					   (:flag IN ('L', 'K') ) 
					 ); */ 


//					   (:flag = 'L' AND NVL(result_status,'O') <> 'O') 		   	    


	/* EXEC SQL OPEN req_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0063;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3372;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_spec_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&flag;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&flag;
 sqlstm.sqhstl[3] = (unsigned int  )1;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&flag;
 sqlstm.sqhstl[4] = (unsigned int  )1;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&flag;
 sqlstm.sqhstl[5] = (unsigned int  )1;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	while(fetch_req_curs())
	{
		/* EXEC SQL SELECT COUNT(*)
		INTO :i_count
		FROM RL_INTERVAL_TEST_SPECIMENS
		WHERE specimen_no = TO_NUMBER(:nd_spec_no)
		AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND NVL(cancelled_yn, 'N') <> 'Y'
		AND group_test_code = :d_group_test_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_SPECIMENS \
where (((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and NVL(can\
celled_yn,'N')<>'Y') and group_test_code=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3411;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&i_count;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_group_test_code;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (i_count == 0)
		{
			l_should_print_yn = 'Y';

			/* EXEC SQL INSERT INTO RL_INTERVAL_TEST_TEMP
					 (operating_facility_id,user_id, session_id, specimen_no, group_test_code)
					 VALUES
					 (:nd_operating_facility_id,USER, USERENV('sessionid'), TO_NUMBER(:nd_spec_no), 
					  :d_group_test_code); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into RL_INTERVAL_TEST_TEMP (operating_facility_id,u\
ser_id,session_id,specimen_no,group_test_code) values (:b0,USER,USERENV('sessi\
onid'),TO_NUMBER(:b1),:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3442;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_group_test_code;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		}


	}
	close_req_curs();

}
/*------------------------------------------------------------*/
declare_spec_curs()
{
		/* EXEC SQL DECLARE spec_curs CURSOR FOR 
				SELECT TO_CHAR(A.specimen_no), A.group_test_code, A.test_code, A.seq_no
				FROM RL_INTERVAL_TEST_SPECIMENS A 
				WHERE A.interval_test_specimen_no= TO_NUMBER(:d_no) 
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND NVL(A.cancelled_yn, 'N') <> 'Y'
		        AND ( 
				       (:flag IN ('W','C') AND NVL(status,'O') IN ('R','P'))
				       OR
					   (:flag IN ('L', 'K') )
					 )
		   	    ORDER BY A.specimen_no; */ 


//					   (:flag = 'L' AND NVL(status,'O') <> 'O' )

		/* EXEC SQL OPEN spec_curs; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0066;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3469;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_no;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&flag;
  sqlstm.sqhstl[2] = (unsigned int  )1;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&flag;
  sqlstm.sqhstl[3] = (unsigned int  )1;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		
}

/*------------------------------------------------------------*/
fetch_spec_curs()
{
	 d_specimen_no.arr[0]		= '\0';
	 d_specimen_no.len			= 0;
	 d_group_test_code.arr[0]	= '\0';
	 d_group_test_code.len		= 0;
	 d_test_code.arr[0]			= '\0';
	 d_test_code.len			= 0;

	/* EXEC SQL FETCH spec_curs 
				 INTO :d_specimen_no, :d_group_test_code, :d_test_code, :d_seq_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3500;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_group_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_test_code;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_seq_no;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		if (OERROR)
			disp_message(ORA_MESG,"FETCH failed on cursor specimen_curs");

	
		d_specimen_no.arr[d_specimen_no.len]			= '\0';
		d_group_test_code.arr[d_group_test_code.len]	= '\0';
		d_test_code.arr[d_test_code.len]				= '\0';

	return (LAST_ROW?0:1);
	 
}
/*------------------------------------------------------------*/
fetch_int_curs()
{
	 d_no.arr[0]		= '\0';
	 d_no.len			= 0;
	 
	/* EXEC SQL FETCH int_curs 
				 INTO :d_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3531;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		if (OERROR)
			disp_message(ORA_MESG,"FETCH failed on cursor int_curs");

	
		d_no.arr[d_no.len]			= '\0';

	return (LAST_ROW?0:1);
	 
}
/*------------------------------------------------------------*/
fetch_req_curs()
{
	 d_group_test_code.arr[0]		= '\0';
	 d_group_test_code.len			= 0;
	 
	/* EXEC SQL FETCH req_curs 
				 INTO :d_group_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3550;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_group_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		if (OERROR)
			disp_message(ORA_MESG,"FETCH failed on cursor req_curs");

	
		d_group_test_code.arr[d_group_test_code.len]			= '\0';

	return (LAST_ROW?0:1);
	 
}
/*------------------------------------------------------------*/
close_int_curs()
{
	/* EXEC SQL CLOSE int_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3569;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
/*------------------------------------------------------------*/

close_spec_curs()
{
	/* EXEC SQL CLOSE spec_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3584;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
/*------------------------------------------------------------*/
close_req_curs()
{
	/* EXEC SQL CLOSE req_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3599;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
/*------------------------------------------------------------*/
/*------------------------------------------------------------*/
delete_build_table()
{
	/* EXEC SQL DELETE FROM RL_INTERVAL_TEST_TEMP
			 WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND user_id = USER
			 AND session_id = USERENV('sessionid'); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from RL_INTERVAL_TEST_TEMP  where ((OPERATING_FACILI\
TY_ID=:b0 and user_id=USER) and session_id=USERENV('sessionid'))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3614;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	/* EXEC SQL DELETE FROM RL_INTERVAL_TEST_TEMP
			 WHERE operating_facility_id = :nd_operating_facility_id
			 AND user_id = USER
			 AND session_id = :l_session; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from RL_INTERVAL_TEST_TEMP  where ((operating_facili\
ty_id=:b0 and user_id=USER) and session_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3633;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_session;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}
/*------------------------------------------------------------*/

get_interval_description()
{
	interval_description.arr[0]		= '\0';
	interval_description.len		= 0;

	/* EXEC SQL SELECT description
			 INTO :interval_description
			 FROM RL_INTERVAL_TEST_DESC
			 WHERE test_code = :rl_tst_test_code
			 AND seq_no = :rl_seq_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select description into :b0  from RL_INTERVAL_TEST_DESC wher\
e (test_code=:b1 and seq_no=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3656;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&interval_description;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_tst_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_seq_no;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	interval_description.arr[interval_description.len]		= '\0';
}
/*-----------------------------------------------------*/
get_first_specimen_no() 
{
	int i;

	/* EXEC SQL DECLARE first_spec_curs CURSOR FOR 
				SELECT TO_CHAR(A.interval_test_specimen_no)
				FROM RL_INTERVAL_TEST_SPECIMENS A 
				WHERE A.specimen_no = TO_NUMBER(:nd_spec_no) 
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND NVL(A.cancelled_yn, 'N') <> 'Y'
				AND NVL(A.status, 'O') IN ('R', :nd_status)
		   	    ORDER BY A.specimen_no; */ 
 

	/* EXEC SQL OPEN first_spec_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0070;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3683;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_spec_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_status;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	i = fetch_first_spec_curs();

	/* EXEC SQL CLOSE first_spec_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3710;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

/*------------------------------------------------------------*/
fetch_first_spec_curs()
{
	 first_specimen_no.arr[0]	= '\0';
	 first_specimen_no.len		= 0;

	/* EXEC SQL FETCH first_spec_curs 
				 INTO :first_specimen_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3725;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&first_specimen_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		if (OERROR)
			disp_message(ORA_MESG,"FETCH failed on cursor first_specimen_curs");

	
		first_specimen_no.arr[first_specimen_no.len]		= '\0';

	return (LAST_ROW?0:1);
	 
}
/*------------------------------------------------------------*/

put_zero_before_decimal()
{

	if (rl_tst_numeric_result.arr[0] != '0')
	{
		strcpy(l_numeric_result, "0");
		strcat(l_numeric_result, rl_tst_numeric_result.arr);

		strcpy(rl_tst_numeric_result.arr, l_numeric_result);
		rl_tst_numeric_result.len = strlen(rl_tst_numeric_result.arr);
	}
	
}
/*-----------------------------------------------------*/
build_cancelled_tests()
{
	l_session = 0;

	/* EXEC SQL SELECT TO_NUMBER(TO_CHAR(SYSDATE, 'DDHH24MISS'))
			 INTO :l_session
			 FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_NUMBER(TO_CHAR(SYSDATE,'DDHH24MISS')) into :b0  fr\
om DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3744;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_session;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	/* EXEC SQL DECLARE cancelled_curs CURSOR FOR 
				SELECT DISTINCT specimen_no
				FROM RL_INTERVAL_TEST_TEMP
				WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND user_id = USER
				AND session_id = USERENV('sessionid'); */ 


	/* EXEC SQL OPEN cancelled_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0072;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3763;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	while(fetch_cancelled_curs())
	{
		
		declare_can_req_curs();
		while(fetch_can_req_curs())
		{

/************ In Rl_interval_test_temp table in column test code 
			  the system will put the cancel code				   *************/

			/* EXEC SQL INSERT INTO RL_INTERVAL_TEST_TEMP
					 (operating_facility_id,user_id, session_id, specimen_no, group_test_code, test_code)
					 VALUES
					 (:nd_operating_facility_id,USER, :l_session, TO_NUMBER(:can_spec_no), 
					  :can_group_test, :can_test_code); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into RL_INTERVAL_TEST_TEMP (operating_facility_id,u\
ser_id,session_id,specimen_no,group_test_code,test_code) values (:b0,USER,:b1,\
TO_NUMBER(:b2),:b3,:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3782;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_session;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&can_spec_no;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&can_group_test;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&can_test_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		}

		close_can_req_curs();
	}
	close_cancelled_curs();

}

/*------------------------------------------------------------*/
fetch_cancelled_curs()
{
	 can_spec_no.arr[0]		= '\0';
	 can_spec_no.len			= 0;

	/* EXEC SQL FETCH cancelled_curs 
				 INTO :can_spec_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3817;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&can_spec_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		if (OERROR)
			disp_message(ORA_MESG,"FETCH failed on cursor specimen_curs");

	 can_spec_no.arr[can_spec_no.len]		= '\0';
	
	return (LAST_ROW?0:1);
	 
}
/*------------------------------------------------------------*/
close_cancelled_curs()
{
	/* EXEC SQL CLOSE cancelled_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3836;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
/*------------------------------------------------------------*/
declare_can_req_curs()
{

	/* EXEC SQL DECLARE can_req_curs CURSOR FOR 
				SELECT test_code, cancel_code
				FROM RL_REQUEST_DETAIL
				WHERE specimen_no = TO_NUMBER(:can_spec_no)
				AND   OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND NVL(cancelled_yn, 'N') = 'Y'; */ 

	   	    
	/* EXEC SQL OPEN can_req_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0074;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3851;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&can_spec_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}
/*------------------------------------------------------------*/
close_can_req_curs()
{
	/* EXEC SQL CLOSE can_req_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3874;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
/*------------------------------------------------------------*/
fetch_can_req_curs()
{
	
	can_test_code.arr[0]		= '\0';
	can_test_code.len			= 0;
    can_group_test.arr[0]		= '\0';
    can_group_test.len			= 0;

	/* EXEC SQL FETCH can_req_curs 
				 INTO	:can_group_test,
						:can_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3889;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&can_group_test;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&can_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		if (OERROR)
			disp_message(ORA_MESG,"FETCH failed on cursor specimen_curs");

	 can_test_code.arr[can_test_code.len]		= '\0';
	 can_group_test.arr[can_group_test.len]		= '\0';
	
	return (LAST_ROW?0:1);
	 
}
/*------------------------------------------------------------*/
print_cancelled_tests()
{

   int ctr = 0;

/************ in test code the system will put the cancel code *************/
	/* EXEC SQL DECLARE prn_can_curs CURSOR FOR 
				SELECT TO_CHAR(specimen_no), group_test_code, test_code
				FROM RL_INTERVAL_TEST_TEMP
				WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND user_id = USER
				AND session_id = :l_session; */ 


	/* EXEC SQL OPEN prn_can_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0075;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3912;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_session;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	while(fetch_prn_can_curs())
	{

		if (ctr == 0)
		{

			fprintf(fp, "               \n");
			page_break(1);
			fprintf(fp, "               \n");
			page_break(1);
			fprintf(fp, "                \n");
			page_break(1);

			fprintf(fp, "Cancelled Tests CCCCCC\n");
			page_break(1);
			fprintf(fp, "--------------- CCCCCC\n");
			page_break(1);

		}


		if (d_interval_specimen_yn == 'Y')
		{
			fprintf(fp, "Specimen No : %-15.15s\n", can_spec_no.arr);
			page_break(1);
		}

		if (strlen(can_test_code.arr) > 0)
		{

			get_cancel_reason();
			get_test_desc();

/**************** added on 30.09.2003 ************/
		    if(test_desc_fill_for_report.len)   
/////		    if(strcmp(test_desc_fill_for_report.arr,"NULL") !=0)   
			{

///// 03.10.2003                EXEC SQL SELECT RPAD(:can_test_name,40-LENGTH(:can_test_name),
                /* EXEC SQL SELECT RPAD(:can_test_name,40,:test_desc_fill_for_report) 
				   	     INTO :can_test_name
					     FROM DUAL; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 30;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = "select RPAD(:b0,40,:b1) into :b0  from DUAL ";
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )3935;
                sqlstm.selerr = (unsigned short)1;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&can_test_name;
                sqlstm.sqhstl[0] = (unsigned int  )43;
                sqlstm.sqhsts[0] = (         int  )0;
                sqlstm.sqindv[0] = (         void  *)0;
                sqlstm.sqinds[0] = (         int  )0;
                sqlstm.sqharm[0] = (unsigned int  )0;
                sqlstm.sqadto[0] = (unsigned short )0;
                sqlstm.sqtdso[0] = (unsigned short )0;
                sqlstm.sqhstv[1] = (         void  *)&test_desc_fill_for_report;
                sqlstm.sqhstl[1] = (unsigned int  )4;
                sqlstm.sqhsts[1] = (         int  )0;
                sqlstm.sqindv[1] = (         void  *)0;
                sqlstm.sqinds[1] = (         int  )0;
                sqlstm.sqharm[1] = (unsigned int  )0;
                sqlstm.sqadto[1] = (unsigned short )0;
                sqlstm.sqtdso[1] = (unsigned short )0;
                sqlstm.sqhstv[2] = (         void  *)&can_test_name;
                sqlstm.sqhstl[2] = (unsigned int  )43;
                sqlstm.sqhsts[2] = (         int  )0;
                sqlstm.sqindv[2] = (         void  *)0;
                sqlstm.sqinds[2] = (         int  )0;
                sqlstm.sqharm[2] = (unsigned int  )0;
                sqlstm.sqadto[2] = (unsigned short )0;
                sqlstm.sqtdso[2] = (unsigned short )0;
                sqlstm.sqphsv = sqlstm.sqhstv;
                sqlstm.sqphsl = sqlstm.sqhstl;
                sqlstm.sqphss = sqlstm.sqhsts;
                sqlstm.sqpind = sqlstm.sqindv;
                sqlstm.sqpins = sqlstm.sqinds;
                sqlstm.sqparm = sqlstm.sqharm;
                sqlstm.sqparc = sqlstm.sqharc;
                sqlstm.sqpadto = sqlstm.sqadto;
                sqlstm.sqptdso = sqlstm.sqtdso;
                sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	            can_test_name.arr[can_test_name.len] = '\0'; 

/**** upto here ************/ 

			    fprintf(fp, "%-40.40s %s CCCCCC\n", can_test_name.arr, cancel_reason.arr);
			}
			else
			    fprintf(fp, "%-40.40s %s CCCCCC\n", can_test_name.arr, cancel_reason.arr);
			page_break(1);
		}

		ctr++;

	}
///disp_message(ERR_MESG,"debug version 2");
    get_customer_id();   //added for MMS-RY-SCF-0062	
	if( strcmp(rl_func_ctl.arr,"Y")==0 ) /// added on 10.02.2016
{
//disp_message(ERR_MESG,"debug version 3");
	   //fprintf(fp, "          \n                      ** --> Critical Value  CCCCCC\n"); //commented for MMS-RY-SCF-0062
	   //added for MMS-RY-SCF-0062
		if(strcmp(rl_customer_id.arr,"ALMO")==0 )
		{
			
			if(strcmp(l_critical_result.arr,"Y")==0 )
			{
			fprintf(fp, "          \n                      ** --> Critical Value  CCCCCC\n");
			}
		}
		else
		{
		fprintf(fp, "          \n                      ** --> Critical Value  CCCCCC\n");
		}
		// end  MMS-RY-SCF-0062
	
}

	close_prn_can_curs();

}

/*------------------------------------------------------------*/
fetch_prn_can_curs()
{
	 can_spec_no.arr[0]			= '\0';
	 can_spec_no.len			= 0;
	 can_group_test.arr[0]		= '\0';
	 can_group_test.len			= 0;
 	 can_test_code.arr[0]		= '\0';
	 can_test_code.len			= 0;

	/* EXEC SQL FETCH prn_can_curs
				 INTO :can_spec_no,
					  :can_group_test,
					  :can_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3962;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&can_spec_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&can_group_test;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&can_test_code;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR)
			disp_message(ORA_MESG,"FETCH failed on cursor specimen_curs");

	 can_spec_no.arr[can_spec_no.len]			= '\0';
	 can_test_code.arr[can_test_code.len]		= '\0';
	 can_group_test.arr[can_group_test.len]		= '\0';
	 	
	return (LAST_ROW?0:1);
	 
}
/*------------------------------------------------------------*/
get_cancel_reason()
{
	cancel_reason.arr[0]		= '\0';
	cancel_reason.len			= 0;

	/* EXEC SQL SELECT long_desc
			 INTO :cancel_reason
		     FROM RL_CANCELLATION_CODE
			 WHERE cancel_code = :can_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_CANCELLATION_CODE where c\
ancel_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3989;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cancel_reason;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&can_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




	if (NODATAFOUND);

	cancel_reason.arr[cancel_reason.len]	= '\0';

}
/*------------------------------------------------------------*/
close_prn_can_curs()
{
	/* EXEC SQL CLOSE prn_can_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4012;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/*------------------------------------------------------------*/
delete_rl_result_line()
{

	/* EXEC SQL DELETE FROM RL_RESULT_LINE
			 WHERE operating_facility_id = :nd_operating_facility_id
			 AND user_id = USER
			 AND specimen_no = TO_NUMBER(:actual_specimen); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from RL_RESULT_LINE  where ((operating_facility_id=:\
b0 and user_id=USER) and specimen_no=TO_NUMBER(:b1))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4027;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&actual_specimen;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}
/*------------------------------------------------------------*/
get_desc_snomed2()
{
    rl_snomed2_desc1.arr[0]          = '\0';
    rl_snomed2_desc2.arr[0]          = '\0';
    rl_snomed2_desc3.arr[0]          = '\0';
    rl_snomed2_desc4.arr[0]          = '\0';
    rl_snomed2_desc5.arr[0]          = '\0';
    rl_snomed2_print_yn.arr[0]       = '\0';
	rl_print_snomed2_code_yn.arr[0]	 = '\0';


    rl_snomed2_desc1.len             = 0;
    rl_snomed2_desc2.len             = 0;
    rl_snomed2_desc3.len             = 0;
    rl_snomed2_desc4.len             = 0;
    rl_snomed2_desc5.len             = 0;
    rl_snomed2_print_yn.len			 = 0;
	rl_print_snomed2_code_yn.len	 = 0;

/****************** CHANGED ON 01/09/2002

                     DESCRIPTION_2,
                     DESCRIPTION_3,
                     DESCRIPTION_4,
                     DESCRIPTION_5,
                   :rl_snomed2_desc2,
                   :rl_snomed2_desc3,
                   :rl_snomed2_desc4,
                   :rl_snomed2_desc5,

********************/

     /* EXEC SQL SELECT SUBSTR(DESCRIPTION_1, 1, 12),
					 NVL(PRINT_YN, 'N'),
					 NVL(print_code_yn, 'N')
	           INTO :rl_snomed2_desc1,
    			   :rl_snomed2_print_yn,
				   :rl_print_snomed2_code_yn
             FROM RL_SNOMED_CODE
             WHERE SNOMED_CODE = :rl_res_snomed_code2; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 30;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SUBSTR(DESCRIPTION_1,1,12) ,NVL(PRINT_YN,'N') ,NV\
L(print_code_yn,'N') into :b0,:b1,:b2  from RL_SNOMED_CODE where SNOMED_CODE=:\
b3";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )4050;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&rl_snomed2_desc1;
     sqlstm.sqhstl[0] = (unsigned int  )303;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&rl_snomed2_print_yn;
     sqlstm.sqhstl[1] = (unsigned int  )4;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&rl_print_snomed2_code_yn;
     sqlstm.sqhstl[2] = (unsigned int  )4;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&rl_res_snomed_code2;
     sqlstm.sqhstl[3] = (unsigned int  )23;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    rl_snomed2_desc1.arr[rl_snomed2_desc1.len] = '\0';
    rl_snomed2_desc2.arr[rl_snomed2_desc2.len] = '\0';
    rl_snomed2_desc3.arr[rl_snomed2_desc3.len] = '\0';
    rl_snomed2_desc4.arr[rl_snomed2_desc4.len] = '\0';
    rl_snomed2_desc5.arr[rl_snomed2_desc5.len] = '\0';
    rl_snomed2_print_yn.arr[rl_snomed2_print_yn.len] = '\0';
	rl_print_snomed2_code_yn.arr[rl_print_snomed2_code_yn.len]	= '\0';

}
/*------------------------------------------------------------*/
print_line_snomed1(char *t_str)
{
         fprintf(fp,"%-18.18s%c%c%c%c%c%c",t_str,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
}
/*------------------------------------------------------------*/
print_line_snomed2(char *t_str)
{
         fprintf(fp,"%-18.18s",t_str);
}
/*------------------------------------------------------------*/
/*------------------------------------------------------------*/
add_zero_after_result()
{
	int i = 0;
	char rslt[21];
	int l_decimal_position = 0;

	strcpy(rslt, r_rslt.arr);

//	if (atoi(r_rslt.arr) > 1 || atoi(r_rslt.arr) == 1)
//	{

		v_numeric_result.arr[0]		= '\0';
		v_numeric_result.len		= 0;

		l_exist_decimals = 0;
		l_inst_decimals = 0;
		
		/* EXEC SQL SELECT TO_NUMBER(:r_rslt) - FLOOR(TO_NUMBER(:r_rslt)),
						LENGTH(SUBSTR(:r_rslt, INSTR(:r_rslt, '.') + 1)), INSTR(:r_rslt, '.')
				 INTO :v_numeric_result, :l_exist_decimals, :l_inst_decimals
				 FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (TO_NUMBER(:b0)-FLOOR(TO_NUMBER(:b0))) ,LENGTH(SUBST\
R(:b0,(INSTR(:b0,'.')+1))) ,INSTR(:b0,'.') into :b5,:b6,:b7  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4081;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&r_rslt;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&r_rslt;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&r_rslt;
  sqlstm.sqhstl[2] = (unsigned int  )22;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&r_rslt;
  sqlstm.sqhstl[3] = (unsigned int  )22;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&r_rslt;
  sqlstm.sqhstl[4] = (unsigned int  )22;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&v_numeric_result;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_exist_decimals;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&l_inst_decimals;
  sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	
		v_numeric_result.arr[v_numeric_result.len]	= '\0';

		if (l_inst_decimals == 0)
			l_exist_decimals = 0;

		l_decimal_position = l_exist_decimals;


//		if (strcmp(v_numeric_result.arr, "0") == 0)
//		{

			for (i = l_exist_decimals;i < rl_tst_cd_no_of_decimals; i++)
			{

/**************
			if (strcmp(rslt, "4.65") == 0)
			{
				sprintf(string_var, "RESULT  %d  %d  %s", l_exist_decimals, rl_tst_cd_no_of_decimals,
											r_rslt.arr);
				disp_message(ERR_MESG, string_var);
			}
****************/

				
				if (l_decimal_position == 0)
					strcat(r_rslt.arr, ".");				
	
				strcat(r_rslt.arr, "0");

				l_decimal_position++;

			}
	
			r_rslt.len = strlen(r_rslt.arr);
//		}
/*		else
		{

			strcpy(r_rslt.arr, rslt);
			r_rslt.len = strlen(r_rslt.arr);

		}
*/



//	}


	for (i = 0; i < 10; i++)
	{
		rslt[i] = r_rslt.arr[i];
	}

	rslt[i] = '\0';

	strcpy(r_rslt.arr, rslt);
	r_rslt.len = strlen(r_rslt.arr);


}
/*------------------------------------------------------------*/
print_str(char l_mode)
{

	if ( rl_snomed_print_yn.arr[0]	== 'Y' || rl_snomed2_print_yn.arr[0]	== 'Y' ||
		rl_print_snomed_code_yn.arr[0] == 'Y' || rl_print_snomed2_code_yn.arr[0] == 'Y' || 
			flag == 'L' || flag == 'K')
	{

		something_to_print = 1;
		something_to_print_for_test = 1;

		fprintf(fp, "SNOMED : ");
		l_snomed_head_printed = 1;

		if (rl_print_snomed_code_yn.arr[0] == 'Y' || flag == 'L' || flag == 'K')
		{
			print_line_snomed2(rl_res_snomed_code.arr);
		}
		else
			print_line_snomed2(" ");
	
		fprintf(fp, " | ");

		if ((rl_print_snomed2_code_yn.arr[0] == 'Y' && 
				strlen(rl_res_snomed_code2.arr) > 0 ) || flag == 'L' || flag == 'K')
		{
			print_line_snomed2(rl_res_snomed_code2.arr);
		}
		else
		{
			print_line_snomed2(" ");
		}

        if (l_mode == 'Y')
		{
			fprintf(fp,"%c%c%c%c%c%c",
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
	
		}

	}
	
}

/*------------------------------------------------------------*/
print_snomed_codes(char l_mode)
{
	if (l_mode == 'Y')
		fprintf(fp, "SNOMED : ");
	else
	{
		fprint_repeat(fp, ' ', 9);
	}

	if (strlen(rl_res_snomed_code2.arr) > 0 )
	{
		print_line_snomed2(rl_res_snomed_code.arr);
	}
	else
	{
		print_line_snomed1(rl_res_snomed_code.arr);
	}

	fprintf(fp, " | ");

	print_line_snomed2(rl_res_snomed_code2.arr);

}
/*------------------------------------------------------------*/
get_zero_prefix_for_range()
{
	l_low_val.arr[0]	= '\0';
	l_low_val.len		= 0;
	l_high_val.arr[0]	= '\0';
	l_high_val.len		= 0;
		
	l_low = 0;
	l_high = 0;


	/* EXEC SQL SELECT FLOOR(TO_NUMBER(:rl_tst_range_high_v_nor)),
				FLOOR(TO_NUMBER(:rl_tst_range_low_v_nor))
		     INTO :l_high, :l_low
			 FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select FLOOR(TO_NUMBER(:b0)) ,FLOOR(TO_NUMBER(:b1)) into :b2\
,:b3  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4128;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_tst_range_high_v_nor;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_tst_range_low_v_nor;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_high;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_low;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	strcpy(l_low_val.arr, rl_tst_range_low_v_nor.arr);
	l_low_val.len = strlen(l_low_val.arr);

	strcpy(l_high_val.arr, rl_tst_range_high_v_nor.arr);
	l_high_val.len = strlen(l_high_val.arr);

	if (l_low == 0)
	{
		strcpy(rl_tst_range_low_v_nor.arr, "0");

		if (strcmp(l_low_val.arr, "0") != 0)
			strcat(rl_tst_range_low_v_nor.arr, l_low_val.arr);

		rl_tst_range_low_v_nor.len = strlen(rl_tst_range_low_v_nor.arr);
	}

	if (l_high == 0)
	{
		strcpy(rl_tst_range_high_v_nor.arr, "0");

		if (strcmp(l_high_val.arr, "0") != 0)
			strcat(rl_tst_range_high_v_nor.arr, l_high_val.arr);

		rl_tst_range_high_v_nor.len = strlen(rl_tst_range_high_v_nor.arr);
	}


    l_low_val.arr[0]		= '\0';
	l_low_val.len			= 0;

	l_high_val.arr[0]		= '\0';
	l_high_val.len			= 0;

	l_low = 0;
	l_high = 0;


}
/*------------------------------------------------------------*/
get_test_desc()
{
	can_test_name.arr[0]	= '\0';
	can_test_name.len		= 0;
	
	/* EXEC SQL SELECT long_desc
			 INTO :can_test_name
			 FROM RL_TEST_CODE
			 WHERE test_code = :can_group_test; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_TEST_CODE where test_code\
=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4159;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&can_test_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&can_group_test;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	
	can_test_name.arr[can_test_name.len]	= '\0';

	if (NODATAFOUND);


}

/*------------------------------------------------------------*/
/**** added on 30.09.2003 *********/
get_test_desc_fill_char()
{
	test_desc_fill_for_report.arr[0]		= '\0';
	test_desc_fill_for_report.len			= 0;

	rl_report_format.arr[0]	= '\0';
	rl_report_format.len	= 0;

	/* EXEC SQL SELECT test_desc_fill_for_report,report_format
			 INTO :test_desc_fill_for_report, :rl_report_format
		     FROM RL_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select test_desc_fill_for_report ,report_format into :b0,:b1\
  from RL_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4182;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&test_desc_fill_for_report;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_report_format;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (NODATAFOUND)
			disp_message(ORA_MESG,"FETCH failed, No data found in RL_PARAM");

  	if (OERROR)
			disp_message(ORA_MESG,"FETCH failed, Error occured while fetching from RL_PARAM");

	test_desc_fill_for_report.arr[test_desc_fill_for_report.len]	= '\0';
	rl_report_format.arr[rl_report_format.len] = '\0';
}
/********************Added to check MIC TO PTINT *************/
get_mic_print_yn()
{
	rl_mic_to_print_yn.arr[0]		= '\0';
	rl_mic_to_print_yn.len			= 0;

	rl_print_mic_sign_yn.arr[0]		= '\0';
	rl_print_mic_sign_yn.len			= 0;

	rl_mic_value_uom.arr[0]		= '\0';
	rl_mic_value_uom.len			= 0;

	/* EXEC SQL SELECT rep_mic_yn,NVL(print_mic_sign_yn,'N'),MIC_VALUE_UOM
			 INTO :rl_mic_to_print_yn,:rl_print_mic_sign_yn, :rl_mic_value_uom
		     FROM RL_PARAM_FOR_FACILITY
             WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rep_mic_yn ,NVL(print_mic_sign_yn,'N') ,MIC_VALUE_UOM\
 into :b0,:b1,:b2  from RL_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4205;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_mic_to_print_yn;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_print_mic_sign_yn;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_mic_value_uom;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (NODATAFOUND)

	/* EXEC SQL SELECT rep_mic_yn
			 INTO :rl_mic_to_print_yn
		     FROM RL_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rep_mic_yn into :b0  from RL_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4236;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_mic_to_print_yn;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  	if (OERROR)
			disp_message(ORA_MESG,"FETCH failed, Error occured while fetching from RL_PARAM_FOR_FACILITY");

	rl_mic_to_print_yn.arr[rl_mic_to_print_yn.len]	= '\0';
	rl_print_mic_sign_yn.arr[rl_print_mic_sign_yn.len]	= '\0';
	rl_mic_value_uom.arr[rl_mic_value_uom.len]	= '\0';
}
/*-----------------------------------------------------------*/

check_any_res_comp()
{

	/* EXEC SQL SELECT COUNT(1)
				INTO :other_than_comments
                FROM RL_RESULT_TEXT
               WHERE PATIENT_ID     = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
				 AND ( 
				       (:flag IN ('W','C') AND NVL(hide_text_yn,'N') NOT IN ('Y'))
				       OR
					   (:flag IN ('L', 'K'))
					 ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_RESULT_TEXT where (((((PAT\
IENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) and GROUP_TEST\
_CODE=:b4) and TEST_CODE=:b5) and ((:b6 in ('W','C') and NVL(hide_text_yn,'N')\
 not  in ('Y')) or :b6 in ('L','K')))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4255;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&other_than_comments;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rl_tst_group_test_code;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rl_tst_test_code;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&flag;
 sqlstm.sqhstl[6] = (unsigned int  )1;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&flag;
 sqlstm.sqhstl[7] = (unsigned int  )1;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	
	if (other_than_comments == 0)
	{
		/* EXEC SQL SELECT  COUNT(1)
			 INTO :other_than_comments
                FROM RL_RESULT_SNOMED A
               WHERE A.PATIENT_ID     = :nd_hosp_no
                 AND A.SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND A.GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND A.TEST_CODE       = :rl_tst_test_code
				AND (A.SNOMED_CODE
							IN (SELECT SNOMED_CODE
								FROM RL_SNOMED_CODE
								WHERE snomed_code = A.snomed_code
								AND (NVL(print_yn, 'N') = 'Y' 
									OR NVL(print_code_yn, 'N') = 'Y' ))
					 OR A.SNOMED_CODE_2
							IN (SELECT SNOMED_CODE
								FROM RL_SNOMED_CODE
								WHERE snomed_code = A.snomed_code_2
								AND (NVL(print_yn, 'N') = 'Y' 
								OR NVL(print_code_yn, 'N') = 'Y' ))); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(1) into :b0  from RL_RESULT_SNOMED A where (((\
((A.PATIENT_ID=:b1 and A.SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) and A\
.GROUP_TEST_CODE=:b4) and A.TEST_CODE=:b5) and (A.SNOMED_CODE in (select SNOME\
D_CODE  from RL_SNOMED_CODE where (snomed_code=A.snomed_code and (NVL(print_yn\
,'N')='Y' or NVL(print_code_yn,'N')='Y'))) or A.SNOMED_CODE_2 in (select SNOME\
D_CODE  from RL_SNOMED_CODE where (snomed_code=A.snomed_code_2 and (NVL(print_\
yn,'N')='Y' or NVL(print_code_yn,'N')='Y')))))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4302;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&other_than_comments;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&rl_tst_group_test_code;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&rl_tst_test_code;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	
		if (other_than_comments == 0)
		{
			/* EXEC SQL  SELECT COUNT(1)
               INTO :other_than_comments 
                FROM RL_RESULT_ORGANISM
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
				 AND ( 
				       (:flag IN ('W','C') AND NVL(hide_organism_yn,'N') NOT IN ('Y'))
				       OR
					   (:flag IN ('L', 'K'))
					 ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select count(1) into :b0  from RL_RESULT_ORGANISM where ((\
(((PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) and GROU\
P_TEST_CODE=:b4) and TEST_CODE=:b5) and ((:b6 in ('W','C') and NVL(hide_organi\
sm_yn,'N') not  in ('Y')) or :b6 in ('L','K')))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4341;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&other_than_comments;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&rl_tst_group_test_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&rl_tst_test_code;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&flag;
   sqlstm.sqhstl[6] = (unsigned int  )1;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&flag;
   sqlstm.sqhstl[7] = (unsigned int  )1;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


/************
			 if (other_than_comments == 0)
			{

			} 
****************/ 
		}
	}

}


/*--- added on 07.08.2004   --------------------------------------------------*/

get_modify_reason_print_yn_for_code()
{



    nd_res_modify_reason_print_yn.arr[0] = '\0';
    nd_res_modify_reason_print_yn.len    = 0;

   /* EXEC SQL SELECT nvl(print_yn,'N')
			INTO :nd_res_modify_reason_print_yn
			FROM RL_REASON_CODE
			WHERE reason_code = :rl_res_modify_reason_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select nvl(print_yn,'N') into :b0  from RL_REASON_CODE whe\
re reason_code=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4388;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_res_modify_reason_print_yn;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_res_modify_reason_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
   	    strcpy(nd_res_modify_reason_print_yn.arr,"N");;

	if (NODATAFOUND)
	    strcpy(nd_res_modify_reason_print_yn.arr,"N");

	nd_res_modify_reason_print_yn.arr[nd_res_modify_reason_print_yn.len]	= '\0';

}

/*-----------------------------------------------------*/


/*---------- 25.05.2004 added below -------------------------------------------*/

print_result_modify_reason()
{
 
  if (something_to_print_for_test > 0)
  {

	open_result_modify_reason();

	_flushall();
  
	test_printed = 0;	

	while(fetch_result_modify_reason())
	{

     strcpy(nd_res_modify_reason_print_yn.arr,"N");

	 if (rl_res_modify_reason_code.len)
	    get_modify_reason_print_yn_for_code();
     else
	    strcpy(nd_res_modify_reason_print_yn.arr,"Y");;

//07.03.2006 if (rl_res_modify_reason.len && strcmp(nd_res_modify_reason_print_yn.arr,"Y")== 0)

	 if((strcmp(rl_print_prev_modified_result_yn.arr,"Y") == 0 && rl_num_component_modified > 0) ||
		(rl_res_modify_reason.len && strcmp(nd_res_modify_reason_print_yn.arr,"Y")== 0))			

     {

       if(test_printed)
       {  

          fprintf(fp,"%c%c%c%c%c%c\n",
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
					   
		  page_break(1);

//07.03.2006  sprintf(text_line,"%-17.17s%-31.31s%s",rl_modify_reason_rel_dt.arr,
//07.03.2006			rl_modify_reason_rel_by.arr,rl_res_modify_reason.arr);

		  sprintf(text_line,"%-17.17s%-31.31s ",rl_modify_reason_rel_dt.arr,
									rl_modify_reason_rel_by.arr);
	      fprintf(fp,"%s",text_line);

		  if (rl_res_modify_reason.len && strcmp(nd_res_modify_reason_print_yn.arr,"Y")== 0)
		  {
			 sprintf(text_line,"%s",rl_res_modify_reason.arr);
	 		 fprintf(fp,"%s",text_line);
		  }

		  if((strcmp(rl_print_prev_modified_result_yn.arr,"Y") == 0 && rl_num_component_modified > 0) && 
					((rl_tst_cd_numeric_result_yn.arr[0] == 'Y') &&
											(rl_num_result_hide_yn.arr[0]	== 'N')
					)
			 )
		  {
           fprintf(fp,"%c%c%c%c%c%c\n",
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
					   
		   page_break(1);
		   sprintf(text_line,"%41s%s%-10s%-10s"," ",rl_modify_numeric_prefix.arr,rl_modify_numeric_result.arr,rl_tst_cd_test_units_desc.arr);
	 	   fprintf(fp,"%s",text_line);
		  }

       }
       else
       {
	      
//07.03.2006 sprintf(text_line,"(%s","Reason for Modification: ");

		  sprintf(text_line,"(%s","Above result has been modified: ");   ///07.03.2006


          fprintf(fp,"%s%c%c%c%c%c%c\n",text_line,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);

		  page_break(1);

//07.03.2006   sprintf(text_line,"%-17.17s%-31.31s%s",rl_modify_reason_rel_dt.arr,
//07.03.2006			rl_modify_reason_rel_by.arr,rl_res_modify_reason.arr);
//07.03.2006   fprintf(fp,"\n%s",text_line);

		  sprintf(text_line,"%-17.17s%-31.31s ",rl_modify_reason_rel_dt.arr,
														rl_modify_reason_rel_by.arr);
		  fprintf(fp,"%s",text_line);

		  if (rl_res_modify_reason.len && strcmp(nd_res_modify_reason_print_yn.arr,"Y")== 0)
		  {
			 sprintf(text_line,"%s",rl_res_modify_reason.arr);
	 		 fprintf(fp,"%s",text_line);
		  }
		 
		  if((strcmp(rl_print_prev_modified_result_yn.arr,"Y") == 0 && rl_num_component_modified > 0) && 
					((rl_tst_cd_numeric_result_yn.arr[0] == 'Y') &&
											(rl_num_result_hide_yn.arr[0]	== 'N')
					)
			 )
		  {
           fprintf(fp,"%c%c%c%c%c%c\n",
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);
		   page_break(1);

		   sprintf(text_line,"%41s%s%-10s%-10s"," ",rl_modify_numeric_prefix.arr,rl_modify_numeric_result.arr,rl_tst_cd_test_units_desc.arr);
	 	   fprintf(fp,"%s",text_line);
		  }

	      test_printed = 1;
       }
     }
   }

   if (test_printed) 
   {

	  fprintf(fp,")%c%c%c%c%c%c\n",
				   rl_tst_status.arr[0],
				   rl_tst_tech_status.arr[0],
				   rl_tst_delta_status.arr[0],
				   rl_tst_qlty_status.arr[0],
				   rl_tst_cmnt_status.arr[0],
				   rl_tst_path_status.arr[0]);
	   page_break(1);
   }

   	close_result_modify_reason_cur();

   _flushall();
 }

}


/*-----------------------------------------------------*/

close_result_modify_reason_cur()
{
	/* EXEC SQL CLOSE RL_RESULT_MODIFY_REASON_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4411;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		disp_message(ORA_MESG,"CLOSE failed on cursor RL_RESULT_MODIFY_REASON_CUR");

}

/*-----------------------------------------------------*/

open_result_modify_reason()
{
    /* EXEC SQL OPEN RL_RESULT_MODIFY_REASON_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0029;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4426;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_tst_group_test_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_tst_test_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         disp_message(ORA_MESG,"OPEN failed on cursor RL_RESULT_MODIFY_REASON_CUR");
}

/*-----------------------------------------------------*/

fetch_result_modify_reason()  
{
#ifdef DEBUG
       printf("In fetch_result_modify_reason() \n");
#endif

    rl_res_modify_reason.arr[0]			= '\0';
    rl_res_modify_reason_code.arr[0]	= '\0';
    rl_modify_reason_rel_by.arr[0]		= '\0';
    rl_modify_reason_rel_dt.arr[0]		= '\0';

	rl_modify_numeric_prefix.arr[0] = '\0';
	rl_modify_numeric_prefix.len = 0;
	rl_modify_numeric_result.arr[0] = '\0';
	rl_modify_numeric_result.len = 0;
	rl_modify_components_ind.arr[0] = '\0';
	rl_modify_components_ind.len = 0;
	rl_num_component_modified = 0;

    /* EXEC SQL FETCH RL_RESULT_MODIFY_REASON_CUR
              INTO rl_res_modify_reason_code,rl_res_modify_reason,
				   rl_modify_reason_rel_by,rl_modify_reason_rel_dt,
				   rl_modify_numeric_prefix,rl_modify_numeric_result,
				   rl_modify_components_ind,rl_num_component_modified; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4461;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_res_modify_reason_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_res_modify_reason;
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_modify_reason_rel_by;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_modify_reason_rel_dt;
    sqlstm.sqhstl[3] = (unsigned int  )33;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_modify_numeric_prefix;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_modify_numeric_result;
    sqlstm.sqhstl[5] = (unsigned int  )18;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_modify_components_ind;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_num_component_modified;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			  
    if (OERROR)
         disp_message(ORA_MESG,"FETCH failed on cursor RL_RESULT_MODIFY_REASON_CUR");

    rl_res_modify_reason.arr[rl_res_modify_reason.len] = '\0';
    rl_res_modify_reason_code.arr[rl_res_modify_reason_code.len] = '\0';
    rl_modify_reason_rel_by.arr[rl_modify_reason_rel_by.len] = '\0';
    rl_modify_reason_rel_dt.arr[rl_modify_reason_rel_dt.len] = '\0';

	rl_modify_numeric_prefix.arr[rl_modify_numeric_prefix.len] = '\0';
	rl_modify_numeric_result.arr[rl_modify_numeric_result.len] = '\0';
	rl_modify_components_ind.arr[rl_modify_components_ind.len] = '\0';

    return (LAST_ROW?0:1);
}

/* ----------------- 25.05.2004 upto here added ---------------------------------- */

/*------------------------------------------------------------*/

get_snomed_marker_desc1()
{
	nd_snomed_mrkr_desc1.arr[0]		= '\0';
	nd_snomed_mrkr_desc1.len		= 0;

    nd_snomed_mrkr1_print_yn.arr[0] = '\0';
    nd_snomed_mrkr1_print_yn.len    = 0;

   /* EXEC SQL SELECT long_desc,print_yn
			INTO :nd_snomed_mrkr_desc1,:nd_snomed_mrkr1_print_yn
			FROM RL_SNOMED_MARKER
			WHERE snomed_marker_code = :rl_res_snomed_mrkr_code1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select long_desc ,print_yn into :b0,:b1  from RL_SNOMED_MA\
RKER where snomed_marker_code=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4508;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_snomed_mrkr_desc1;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_snomed_mrkr1_print_yn;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&rl_res_snomed_mrkr_code1;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if(OERROR);

	if (NODATAFOUND);

	nd_snomed_mrkr_desc1.arr[nd_snomed_mrkr_desc1.len]	= '\0';
	nd_snomed_mrkr1_print_yn.arr[nd_snomed_mrkr1_print_yn.len]	= '\0';

}
/*------------------------------------------------------------*/

get_snomed_marker_desc2()
{
	nd_snomed_mrkr_desc2.arr[0]		= '\0';
	nd_snomed_mrkr_desc2.len		= 0;

    nd_snomed_mrkr2_print_yn.arr[0] = '\0';
    nd_snomed_mrkr2_print_yn.len    = 0;

   /* EXEC SQL SELECT long_desc,print_yn
			INTO :nd_snomed_mrkr_desc2,:nd_snomed_mrkr2_print_yn
			FROM RL_SNOMED_MARKER
			WHERE snomed_marker_code = :rl_res_snomed_mrkr_code2; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select long_desc ,print_yn into :b0,:b1  from RL_SNOMED_MA\
RKER where snomed_marker_code=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4535;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_snomed_mrkr_desc2;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_snomed_mrkr2_print_yn;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&rl_res_snomed_mrkr_code2;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if(OERROR);

	if (NODATAFOUND);

	nd_snomed_mrkr_desc2.arr[nd_snomed_mrkr_desc2.len]	= '\0';
	nd_snomed_mrkr2_print_yn.arr[nd_snomed_mrkr2_print_yn.len]	= '\0';

}
/*------------------------------------------------------------*/

print_snomed_marker1()
{
	if (strcmp(nd_snomed_mrkr1_print_yn.arr,"Y") == 0 && nd_snomed_mrkr_desc1.len != 0)
	{
         something_to_print = 1;
		 something_to_print_for_test = 1;

/********** no heading, no margin is needed
         if (l_snomed_head_printed == 0)
		 {
	        sprintf(text_line,"SNOMED : ");
	        print_line(text_line);
			l_snomed_head_printed = 1;
		 }
         else
	 		fprintf(fp, "         ");
**********/

/*s		 fprintf(fp,"%c&k4S",ESC); 
   		 fprintf(fp,"%c(s4B",ESC);
		 fprintf(fp,"%s\n",nd_snomed_mrkr_desc1.arr);
		 fprintf(fp,"%c&k4S",ESC); 
   		 fprintf(fp,"%c(s-3B",ESC);
s*/

         fprintf(fp,"%s%c%c%c%c%c%c\n",nd_snomed_mrkr_desc1.arr,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);

         page_break(1);
	} 

}

/*------------------------------------------------------------*/

print_snomed_marker2()
{

	if (strcmp(nd_snomed_mrkr2_print_yn.arr,"Y") == 0 && nd_snomed_mrkr_desc2.len != 0)
	{
         something_to_print = 1;
		 something_to_print_for_test = 1;

/****** no heading, no margin is needed
         if (l_snomed_head_printed == 0)
		 {
	 		fprintf(fp, "SNOMED : \n");
			l_snomed_head_printed = 1;
		    page_break(1);
		 }
         else
	 		fprintf(fp, "         ");
**************/ 

/*s		 fprintf(fp,"%c&k4S",ESC); 
   		 fprintf(fp,"%c(s4B",ESC);
		 fprintf(fp,"%s\n",nd_snomed_mrkr_desc2.arr);
		 fprintf(fp,"%c&k4S",ESC); 
   		 fprintf(fp,"%c(s-3B",ESC);
s*/

         fprintf(fp,"%s%c%c%c%c%c%c\n",nd_snomed_mrkr_desc2.arr,
				       rl_tst_status.arr[0],
				       rl_tst_tech_status.arr[0],
				       rl_tst_delta_status.arr[0],
				       rl_tst_qlty_status.arr[0],
				       rl_tst_cmnt_status.arr[0],
				       rl_tst_path_status.arr[0]);

         page_break(1);


	}

}

/*------------------------------------------------------------*/

	/*** Code added 07.08.2004 to check and Print the Past results based on setup ***/

/*-----------------------------------------------------------------------------------*/

get_departmental_parameters() 
{
   rl_print_prv_result_yn.arr[0]	= '\0';
   rl_print_prv_result_yn.len		= 0;
   rl_print_pend_profile_yn.arr[0]      = '\0';   /////// 21.05.2005
   rl_print_pend_profile_yn.len         = 0;
   rl_legend_for_pending.arr[0]         = '\0';   /////// 21.05.2005
   rl_legend_for_pending.len            = 0;
   rl_print_prev_modified_result_yn.arr[0] = '\0';  // 07.03.2006
   rl_print_prev_modified_result_yn.len    = 0;
   rl_legend_for_pre_result.arr[0]    = '\0';
   rl_legend_for_pre_result.len       = 0;   /// 29.08.2006

   rl_print_test_method_yn.arr[0] = '\0';  // 15.05.2015 against HSA-CRF-0298
   rl_print_test_method_yn.len    = 0;
   rl_print_notify_yn.arr[0]			= '\0'; //added by madhusudhan for crf-0332*/
   rl_print_notify_yn.len				= 0;

   /* EXEC SQL SELECT NVL(print_prev_results_yn,'N'),NVL(print_pending_for_profile_yn,'N'),
				   legend_for_pending,NVL(print_modified_results_yn,'N'),
				   NVL(LEGEND_FOR_PRE_RESULT,'This is Preliminary Result'),NVL(PRINT_TEST_METHOD_YN,'N'),
				   NVL(PRINT_NOTIFY_TEXT_YN,'N')
              INTO :rl_print_prv_result_yn,:rl_print_pend_profile_yn,
			       :rl_legend_for_pending,:rl_print_prev_modified_result_yn,
				   :rl_legend_for_pre_result,:rl_print_test_method_yn,
				   :rl_print_notify_yn
		      FROM RL_SECTION_CTL
		     WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND SECTION_CODE = :rl_hdr_section_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(print_prev_results_yn,'N') ,NVL(print_pending_f\
or_profile_yn,'N') ,legend_for_pending ,NVL(print_modified_results_yn,'N') ,NV\
L(LEGEND_FOR_PRE_RESULT,'This is Preliminary Result') ,NVL(PRINT_TEST_METHOD_Y\
N,'N') ,NVL(PRINT_NOTIFY_TEXT_YN,'N') into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from R\
L_SECTION_CTL where (OPERATING_FACILITY_ID=:b7 and SECTION_CODE=:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4562;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_print_prv_result_yn;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_print_pend_profile_yn;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&rl_legend_for_pending;
   sqlstm.sqhstl[2] = (unsigned int  )42;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&rl_print_prev_modified_result_yn;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&rl_legend_for_pre_result;
   sqlstm.sqhstl[4] = (unsigned int  )102;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&rl_print_test_method_yn;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&rl_print_notify_yn;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[7] = (unsigned int  )5;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&rl_hdr_section_code;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR)
         disp_message(ORA_MESG,"Select failed on table RL_SECTION_CTL");

	  rl_print_prv_result_yn.arr[rl_print_prv_result_yn.len]	= '\0';
	  rl_print_pend_profile_yn.arr[rl_print_pend_profile_yn.len]	    = '\0';
	  rl_legend_for_pending.arr[rl_legend_for_pending.len]				= '\0';
	  rl_print_prev_modified_result_yn.arr[rl_print_prev_modified_result_yn.len] = '\0';
	  rl_legend_for_pre_result.arr[rl_legend_for_pre_result.len] = '\0';
	  rl_print_test_method_yn.arr[rl_print_test_method_yn.len] = '\0';
	  rl_print_notify_yn.arr[rl_print_notify_yn.len]				= '\0';

}

//added for INT-CRF-BRU-LIS-006
get_function_ctl()
{
     
 	rl_func_ctl.arr[0] ='\0';
	rl_func_ctl.len=0;
	
	/* EXEC SQL SELECT NVL(VALUE_1,'N') INTO :rl_func_ctl
	FROM SM_FUNCTION_CONTROL,SM_SITE_PARAM
	WHERE SM_FUNCTION_CONTROL.SITE_ID=SM_SITE_PARAM.CUSTOMER_ID
	AND MODULE_ID='RL' AND FUNCTIONALITY_ID='RL_HIDE_CRITICAL_STR'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(VALUE_1,'N') into :b0  from SM_FUNCTION_CONTROL ,\
SM_SITE_PARAM where ((SM_FUNCTION_CONTROL.SITE_ID=SM_SITE_PARAM.CUSTOMER_ID an\
d MODULE_ID='RL') and FUNCTIONALITY_ID='RL_HIDE_CRITICAL_STR')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4613;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_func_ctl;
 sqlstm.sqhstl[0] = (unsigned int  )3;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
	if (OERROR)
         disp_message(ORA_MESG,"Select failed on table SM_SITE_PARAM");

	  rl_func_ctl.arr[rl_func_ctl.len]	= '\0';

}
//end for INT-CRF-BRU-LIS-006

/*---------------------------------------------------------------------------------*/
get_customer_id() 
{
   rl_customer_id.arr[0]	= '\0';
   rl_customer_id.len		= 0;

   /* EXEC SQL SELECT NVL(customer_id,'!!')
              INTO :rl_customer_id
		      FROM SM_SITE_PARAM; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(customer_id,'!!') into :b0  from SM_SITE_PARAM ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4632;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_customer_id;
   sqlstm.sqhstl[0] = (unsigned int  )12;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR)
         disp_message(ORA_MESG,"Select failed on table SM_SITE_PARAM");

	  rl_customer_id.arr[rl_customer_id.len]	= '\0';

}

/*---------------------------------------------------------------------------------*/

print_past_results()
{

	if (strcmp(rl_print_prv_result_yn.arr, "Y") == 0 )
	{

		/* EXEC SQL SELECT NVL(PERIOD_FOR_PAST_RESULTS,0),NVL(NO_OF_PAST_RESULTS,0),
		                PAST_RESULT_UNITS
				 INTO :d_past_result_period, :d_past_result_no, :d_past_result_unit
				 FROM RL_TEST_PAST_RESULT
				 WHERE test_code = :rl_tst_test_code
				 AND   result_type_ind = 'REP'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(PERIOD_FOR_PAST_RESULTS,0) ,NVL(NO_OF_PAST_RESUL\
TS,0) ,PAST_RESULT_UNITS into :b0,:b1,:b2  from RL_TEST_PAST_RESULT where (tes\
t_code=:b3 and result_type_ind='REP')";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4651;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_past_result_period;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_past_result_no;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_past_result_unit;
  sqlstm.sqhstl[2] = (unsigned int  )8;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&rl_tst_test_code;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (d_past_result_period)
		{
			if (strcmp(d_past_result_unit.arr, "YRS") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI'), -12*:d_past_result_period),
					                    'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY HH24:MI\
'),((-12)* :b1)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4682;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			}
			if (strcmp(d_past_result_unit.arr, "MTHS") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI'), -1*:d_past_result_period),
										'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						 FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY HH24:MI\
'),((-1)* :b1)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4709;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			}
			if (strcmp(d_past_result_unit.arr, "WKS") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI') - 7*:d_past_result_period, 'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						 FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR((TO_DATE(:b0,'DD/MM/YYYY HH24:MI')-(7* :b1\
)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4736;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			}
			if (strcmp(d_past_result_unit.arr, "DAY") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI') - 1*:d_past_result_period, 'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						 FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR((TO_DATE(:b0,'DD/MM/YYYY HH24:MI')-(1* :b1\
)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4763;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			}
			if (strcmp(d_past_result_unit.arr, "HRS") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI') - (1/24)*:d_past_result_period, 'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						 FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR((TO_DATE(:b0,'DD/MM/YYYY HH24:MI')-((1/24)\
* :b1)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4790;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			}



			dclr_test_result_prv_cur();

	        p_count = 0;
			past_results_head_printed = 0;
			while(fetch_test_result_prv_cur())
			{
				if (d_num_result_hide_yn.arr[0] == 'N')
					ge_prev_result_line(); 
	
				p_count++;

				if (p_count == d_past_result_no)
				{
					break;
				}
				

			}


		}
	}
}

/*-------------------------------------------------------------------------------*/

/*** Cursor declared to get the previous results of the Test Code  from the RL_TEST_RESULT ***/

dclr_test_result_prv_cur() 
{

    /* EXEC SQL DECLARE test_result_prv_cur CURSOR FOR
         SELECT TO_CHAR(A.specimen_no), A.test_code, A.numeric_result, NVL(A.numeric_prefix,'+'), 
				A.status, A.test_units, A.age_range_low, A.age_range_high, A.high_low_ind,
				TO_CHAR(B.spec_regd_date_time,'DD/MM/YYYY HH24:MI'),B.operating_facility_id,
				NVL(A.numeric_result_hide_yn, 'N') numeric_result_hide_yn
           FROM RL_TEST_RESULT A, RL_REQUEST_HEADER B
           WHERE B.patient_id = :nd_hosp_no
		   AND B.patient_id = A.patient_id
		   AND B.specimen_no = A.specimen_no
		   AND B.operating_facility_id = A.operating_facility_id
		   AND A.test_code = :rl_tst_test_code
		   AND A.specimen_no != TO_NUMBER(:nd_spec_no)
           AND B.spec_regd_date_time BETWEEN
		       TO_DATE(:nd_prv_result_dt,'DD/MM/YYYY HH24:MI') AND
		       TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI')
           AND NVL(A.cancelled_yn, 'N') <> 'Y'
		   AND NVL(A.status,'O') IN ('R','P')
		   ORDER BY B.spec_regd_date_time desc; */ 


//AND NVL(B.spec_regd_date_time,TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI')) >= 
//		       TO_DATE(:nd_prv_result_dt,'DD/MM/YYYY HH24:MI')
//           AND NVL(B.spec_regd_date_time,TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI')) <= 
//		       TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI')
//		   ORDER BY A.reviewed_date desc;


	/* EXEC SQL OPEN test_result_prv_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0101;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4817;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_tst_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_prv_result_dt;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rl_hdr_spec_regd_date_time;
 sqlstm.sqhstl[4] = (unsigned int  )19;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

/*-----------------------------------------------------------------------------------------*/

/*** Added to fetch the Previous results for the Test ***/

fetch_test_result_prv_cur()
{
  d_prv_specimen_no.arr[0]          = '\0';
  d_prv_specimen_no.len				= 0;

  d_tst_prv_test_code.arr[0]		= '\0';
  d_tst_prv_test_code.len			= 0;
  
  d_tst_prv_numeric_result.arr[0]	= '\0';
  d_tst_prv_numeric_result.len		= 0;

  d_num_prv_prefix.arr[0]			= '\0';
  d_num_prv_prefix.len				= 0;

  d_status_prv.arr[0]				= '\0';
  d_status_prv.len					= 0;

  d_tst_prv_units.arr[0]			= '\0';
  d_tst_prv_units.len				= 0;

  d_tst_prv_age_range_low.arr[0]	= '\0';
  d_tst_prv_age_range_low.len		= 0;

  d_tst_prv_age_range_high.arr[0]	= '\0';
  d_tst_prv_age_range_high.len		= 0;

  d_tst_prv_high_low_ind.arr[0]		= '\0';
  d_tst_prv_high_low_ind.len		= 0;

  d_prv_spec_regd_date_time.arr[0]	= '\0';
  d_prv_spec_regd_date_time.len		= 0;

  d_prv_spec_facility_id.arr[0]	= '\0';
  d_prv_spec_facility_id.len		= 0;

  d_num_result_hide_yn.arr[0]		= '\0';
  d_num_result_hide_yn.len			= 0;

  /* EXEC SQL FETCH test_result_prv_cur
		   INTO :d_prv_specimen_no,	
				:d_tst_prv_test_code,
				:d_tst_prv_numeric_result,
				:d_num_prv_prefix,
				:d_status_prv,
				:d_tst_prv_units,
				:d_tst_prv_age_range_low,
				:d_tst_prv_age_range_high,
				:d_tst_prv_high_low_ind,
				:d_prv_spec_regd_date_time,
				:d_prv_spec_facility_id,
				:d_num_result_hide_yn; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4852;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_prv_specimen_no;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_tst_prv_test_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_tst_prv_numeric_result;
  sqlstm.sqhstl[2] = (unsigned int  )18;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_num_prv_prefix;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_status_prv;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_tst_prv_units;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_tst_prv_age_range_low;
  sqlstm.sqhstl[6] = (unsigned int  )18;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_tst_prv_age_range_high;
  sqlstm.sqhstl[7] = (unsigned int  )18;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_tst_prv_high_low_ind;
  sqlstm.sqhstl[8] = (unsigned int  )12;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_prv_spec_regd_date_time;
  sqlstm.sqhstl[9] = (unsigned int  )33;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_prv_spec_facility_id;
  sqlstm.sqhstl[10] = (unsigned int  )5;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_num_result_hide_yn;
  sqlstm.sqhstl[11] = (unsigned int  )4;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




  d_prv_specimen_no.arr[d_prv_specimen_no.len]					= '\0';
  d_tst_prv_numeric_result.arr[d_tst_prv_numeric_result.len]	= '\0';
  d_tst_prv_test_code.arr[d_tst_prv_test_code.len]				= '\0';
  d_num_prv_prefix.arr[d_num_prv_prefix.len]					= '\0';
  d_status_prv.arr[d_status_prv.len]							= '\0';
  d_tst_prv_units.arr[d_tst_prv_units.len]						= '\0';
  d_tst_prv_age_range_low.arr[d_tst_prv_age_range_low.len]		= '\0';
  d_tst_prv_age_range_high.arr[d_tst_prv_age_range_high.len]	= '\0';
  d_tst_prv_high_low_ind.arr[d_tst_prv_high_low_ind.len]		= '\0';
  d_prv_spec_regd_date_time.arr[d_prv_spec_regd_date_time.len]	= '\0';
  d_prv_spec_facility_id.arr[d_prv_spec_facility_id.len]		= '\0';
  d_num_result_hide_yn.arr[d_num_result_hide_yn.len]			= '\0';

   return (LAST_ROW?0:1);   

}

/*-----------------------------------------------------------------*/
put_zero_before_decimal_past_result()
{

	if (d_tst_prv_numeric_result.arr[0] != '0')
	{
		strcpy(l_numeric_result, "0");
		strcat(l_numeric_result, d_tst_prv_numeric_result.arr);

		strcpy(d_tst_prv_numeric_result.arr, l_numeric_result);
		d_tst_prv_numeric_result.len = strlen(d_tst_prv_numeric_result.arr);
	}
	

}

/*--------------------------------------------------------------------------------------*/
ge_prev_result_line()
{
char l_str [100];

	if(past_results_head_printed==0)
	{
//		fprintf(fp,"    ");
/////	fprintf(fp,"[Previous Results]\n");
        sprintf(text_line,"[Previous Results]");
        print_line(text_line);
		past_results_head_printed = 1;
		page_break(1);
	}

    strcpy(l_str,"");
	sprintf(l_str,"%-15.15s  %s   %s   ",d_prv_specimen_no.arr,d_prv_spec_regd_date_time.arr,
																	d_prv_spec_facility_id.arr);

	something_to_print = 1;
	something_to_print_for_test = 1;
	if (d_tst_prv_numeric_result.len)
	{

	  if ( (atof(d_tst_prv_numeric_result.arr) < 1) && 
												(atof(d_tst_prv_numeric_result.arr) > 0) )
			 put_zero_before_decimal_past_result();

	  numeric_value_flag = TRUE;

	  strcpy(r_rslt.arr, d_tst_prv_numeric_result.arr);
	  r_rslt.len = strlen(r_rslt.arr);
	  add_zero_after_result();
	  strcpy(d_tst_prv_numeric_result.arr, r_rslt.arr);
	  d_tst_prv_numeric_result.len = strlen(d_tst_prv_numeric_result.arr);

	  if(d_num_prv_prefix.arr[0] == '+')
	  {
		 sprintf(l_str,"%s%-10s",l_str,d_tst_prv_numeric_result.arr);  
      }
	  else
	  {
         sprintf(l_str,"%s%c%-10s",l_str,d_num_prv_prefix.arr[0],
													     d_tst_prv_numeric_result.arr);
      }

      sprintf(l_str,"%s%-10s",l_str,d_tst_prv_units.arr);

	  if ( d_tst_prv_age_range_low.len  || d_tst_prv_age_range_high.len )
      {

		  get_zero_prefix_for_range();

		  strcpy(r_rslt.arr, d_tst_prv_age_range_low.arr);
		  r_rslt.len = strlen(r_rslt.arr);
 		  add_zero_after_result();
		  strcpy(d_tst_prv_age_range_low.arr, r_rslt.arr);
		  d_tst_prv_age_range_low.len = strlen(d_tst_prv_age_range_low.arr);

		  strcpy(r_rslt.arr, d_tst_prv_age_range_high.arr);
		  r_rslt.len = strlen(r_rslt.arr);
 		  add_zero_after_result();
		  strcpy(d_tst_prv_age_range_high.arr, r_rslt.arr);
		  d_tst_prv_age_range_high.len = strlen(d_tst_prv_age_range_high.arr);
		

			  sprintf(l_str,"%s %-1s (%s - %s)",l_str,
													  d_tst_prv_high_low_ind.arr,
													  d_tst_prv_age_range_low.arr,
													  d_tst_prv_age_range_high.arr);
      }
 
	}   /*Endif of rl_tst_numeric_result.len */

	print_line(l_str);

}

/*-----------------------------------------------------*/
check_profile_yn(loc_tst_code)
char loc_tst_code[];
{
    strcpy(rl_loc_grp_test_code.arr,loc_tst_code);
    rl_loc_grp_test_code.len  =  strlen(rl_loc_grp_test_code.arr);

	rl_tst_cd_profile_yn.arr[0]		    = '\0';
	rl_tst_cd_profile_yn.len			= 0;

    /* EXEC SQL SELECT  NVL(PROFILE_YN,'N')    /// 21.05.2005    
               INTO :rl_tst_cd_profile_yn
               FROM  RL_TEST_CODE
              WHERE  TEST_CODE = :rl_loc_grp_test_code
                AND  NVL(GROUP_TEST_YN,'N') = 'Y'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(PROFILE_YN,'N') into :b0  from RL_TEST_CODE wh\
ere (TEST_CODE=:b1 and NVL(GROUP_TEST_YN,'N')='Y')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4915;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_tst_cd_profile_yn;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_loc_grp_test_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (NODATAFOUND);
	   
    if (OERROR)
         disp_message(ORA_MESG,"FETCH failed on cursor RL_TEST_CODE_CUR..2");

	rl_tst_cd_profile_yn.arr[rl_tst_cd_profile_yn.len]	   = '\0';		

}
/*-----------------------------------------------------*/

/*--------- added the below on 18.02.2006 -------------------------------------*/
get_test_units_desc_from_sy_uom()
{

   rl_tst_cd_test_units_desc.arr[0]		= '\0';      
   rl_tst_cd_test_units_desc.len		= 0;

   /* EXEC SQL SELECT  short_desc
			  INTO :rl_tst_cd_test_units_desc
		  	  FROM SY_UOM
			 WHERE uom_code = :rl_tst_cd_test_units; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from SY_UOM where uom_code=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4938;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_tst_cd_test_units_desc;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_tst_cd_test_units;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (NODATAFOUND)
	{
		strcpy(rl_tst_cd_test_units_desc.arr,rl_tst_cd_test_units.arr);    
		rl_tst_cd_test_units_desc.len = strlen(rl_tst_cd_test_units_desc.arr);
//		rl_tst_cd_test_units_desc.arr[rl_tst_cd_test_units_desc.len]	= '\0';

	}

    if (OERROR)
	{
		strcpy(rl_tst_cd_test_units_desc.arr,rl_tst_cd_test_units.arr);    
		rl_tst_cd_test_units_desc.len = strlen(rl_tst_cd_test_units_desc.arr);
	}

	rl_tst_cd_test_units_desc.arr[rl_tst_cd_test_units_desc.len]	= '\0';

}
/*------------------------------------------------------------*/

print_culture_format5() 
{

    char temp_sens_ind;
    char temp_line[81];
	char org[MAX_ORGANISMS][5];
    int still_org_dtl_left;
    int print_anti_flag = 0;
    int change_flag = 0;
	int e = 0;
    int anti_flag = 0;
    int c = 0, s = 0;
	int no_of_organisms = 0;
	int v_sensitivity = 0;
// 17.12.2003    int oflag = 1;
	int match_found = 0;
    oflag = 1;     /// 17.12.2003
	org_yn = 0;    /// 17.12.2003
    open_result_organism();
	//_flushall();
	
	//added for AMS-CRF-0067 by krishnamoorthys
	/* EXEC SQL SELECT COUNT(1) INTO l_customer
	FROM SM_SITE_PARAM
	WHERE CUSTOMER_ID='AMS'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from SM_SITE_PARAM where CUSTOMER_\
ID='AMS'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4961;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_customer;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    while(fetch_result_org())
    {
        something_to_print = 1;
		oflag = 1;     /// 17.12.2003

	//s	strcpy(org[no_of_organisms],rl_res_organism_code.arr);
	    no_of_organisms++;

		if(group && !group_printed)
		{
			print_group_test_desc();
			group_printed = 1;
		}
		if(!test_printed)
		{
			sprintf(text_line,"%-40.40s",test_description);
			print_line(text_line);
			test_printed = 1;
		}

		if(oflag)
		{

        sprintf(text_line,"%-46.46s%-7.7s","ORGANISM","COMMENT");
		print_line(text_line);

		sprintf(text_line,"");
		for(c=0;c<54;c++)
			sprintf(text_line,"%s%s",text_line,"-");
		print_line(text_line); 
		oflag = 0;
		}

		fetch_org_desc();   
		/*added condition for CRF20281 by srinivas*/

		if (strcmp(rl_customer_id.arr, "MOD")!=0)  /*added for MO-CRF-20128*/
		{
		if (strcmp(rl_res_hide_organism_yn.arr,"Y") == 0)

		sprintf(text_line,"(%-4.6s) %-40.40s%-34.34s",rl_res_organism_code.arr,
							rl_res_organism_code_desc.arr,
							rl_res_comment_desc.arr);

		else
   		sprintf(text_line,"%-6.6s %-40.40s%-34.34s",rl_res_organism_code.arr,
							rl_res_organism_code_desc.arr,
							rl_res_comment_desc.arr); 
		}
		else/*added for MO-CRF-20128*/
		{
		//disp_message(ERR_MESG, "666");
		if (strcmp(rl_res_hide_organism_yn.arr,"Y") == 0)

		sprintf(text_line,"(%-4.6s) %-40.40s%-34.34s",strcat(strcat(rl_res_organism_code.arr,"-"),l_org_seq_no.arr),
							rl_res_organism_code_desc.arr,
							rl_res_comment_desc.arr);

		else
   		sprintf(text_line,"%-6.6s %-40.40s%-34.34s",strcat(strcat(rl_res_organism_code.arr,"-"),l_org_seq_no.arr),
							rl_res_organism_code_desc.arr,
							rl_res_comment_desc.arr); 
		
		}

		print_line(text_line);
		org_yn = 1; /// 17.12.2003


		open_sensitivity_format4(); 

		a_flag = 0;   /// 18.12.2003
		antb_yn = 0;  /// 18.12.2003
	      b_flag = 1;
		while(fetch_sensitivity_format4())
		{
			if ((! a_flag) && (b_flag))
			{
				sprintf(text_line,"");
				for(c=0;c<80;c++)
					sprintf(text_line,"%s%s",text_line," ");
				print_line(text_line);
				
				get_kb_mic_legend(no_of_organisms, 'C');
			//	if (l_customer>0 ) //added the "if" condition for AM_CRF-0067 by krishnamoorthys
				
				if (strcmp(rl_print_mic_sign_yn.arr,"Y") == 0 ) // commented above if and added this on 02.04.2015 to generalize.
				{
				 sprintf(text_line,"%-46.46s %-13.13s %s %s","ANTIBIOTIC ","SENSITIVITY",l_mic_sign,l_kb_mic_legend);
				}
				else
				 sprintf(text_line,"%-46.46s %-13.13s %s","ANTIBIOTIC ","SENSITIVITY",l_kb_mic_legend);

				print_line(text_line);

				sprintf(text_line,"");
				sprintf(text_line1,"");

				for(c=0;c<80;c++)
					sprintf(text_line,"%s%s",text_line," ");

				print_line(text_line);

				b_flag = 0;
			}

			if(a_flag)
			{
				sprintf(text_line,"%-46.46s %s","ANTIBIOTIC ","SENSITIVITY");
				print_line(text_line);
				a_flag = 0; 
			}		
		
			strcpy(rl_res_dtl_antibiotic_code.arr,b_antibiotic_code.arr);
			rl_res_dtl_antibiotic_code.len = strlen(b_antibiotic_code.arr);
			
			fetch_antibiotic_desc();
	        
			if (strcmp(b_report_yn.arr,"Y") == 0 )
			{
			   //sprintf(text_line,"%-47.47s %s",rl_res_dtl_antibiotic_desc.arr,b_sensitivity_ind.arr);
			   v_sensitivity++;
			   prep_kb_mic_value_for_format4('N');
	    	}
		    else
			{
				//sprintf(text_line,"%-47.47s (%s)",rl_res_dtl_antibiotic_desc.arr,b_sensitivity_ind.arr);
				prep_kb_mic_value_for_format4('Y');
			}

			print_line(text_line);

			antb_yn = 1;  /// 18.12.2003
		
		}   /// while(fetch_sensitivity_format4())

		antb_yn = 0;  /// 18.12.2003
		close_sensitivity_cur_format4();

		sprintf(text_line,"");
		for(c=0;c<80;c++)
			sprintf(text_line,"%s%s",text_line," ");
		print_line(text_line);


	}  //// while(fetch_result_org())

	antb_yn = 0;  /// 18.12.2003
/********
	if(no_of_organisms)  
	{
		sprintf(text_line,"%-35.35s%-52.52s"," ","S - Sensitive     R - Resistant   I - Intermediate");
		print_line(text_line);
	}
*****************/
	if(v_sensitivity)
	{
		//added SKR for PMG2020-TECH-CRF-0005
		if (strcmp(rl_customer_id.arr, "MOHBR") == 0 || strcmp(rl_customer_id.arr, "ALMO")==0|| strcmp(rl_customer_id.arr, "MOD")==0|| strcmp(rl_customer_id.arr, "SKR")==0) //added IF for ML-MMOH-CRF-0576
		{
		sprintf(text_line,"%-30.30s%-55.55s"," ","S - Sensitive  R - Resistant  I - Intermediate  D - SDD");
		}
		else
		{
		sprintf(text_line,"%-35.35s%-52.52s"," ","S - Sensitive     R - Resistant   I - Intermediate");
		}
		print_line(text_line);
	}
    v_sensitivity = 0;
	close_organism_cur();
	org_yn = 0;  //// 17.12.2003  
	//_flushall();
}
/*-----------------------------------------------------*/

get_user_conf_access_yn()
{
	nd_user_conf_access_yn.arr[0]	= '\0';
	nd_user_conf_access_yn.len		= 0;

   strcpy(nd_user_conf_access_yn.arr,"N");
   nd_user_conf_access_yn.len = strlen(nd_user_conf_access_yn.arr);

   
   /* EXEC SQL SELECT NVL(VIEW_CONFIDENTIAL_YN,'N') 
			  INTO :nd_user_conf_access_yn
		      FROM RL_USER_DEPT_VIEW_RESULTS
             WHERE USER_ID = USER
		       AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			   AND SECTION_CODE = :rl_hdr_section_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(VIEW_CONFIDENTIAL_YN,'N') into :b0  from RL_USE\
R_DEPT_VIEW_RESULTS where ((USER_ID=USER and OPERATING_FACILITY_ID=:b1) and SE\
CTION_CODE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4980;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_user_conf_access_yn;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&rl_hdr_section_code;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




    if(OERROR);

	if (NODATAFOUND);

	nd_user_conf_access_yn.arr[nd_user_conf_access_yn.len]	= '\0';
	nd_user_conf_access_yn.arr[nd_user_conf_access_yn.len]	= '\0';

}
/*------------------------------------------------------------*/


check_mic_value_present_for_test()
{
	
	mic_count = 0;
	mic_sign_count=0; //added the code for AMS-CRF-0067 linked In-52950 by krishnamoorthys

	/* EXEC SQL 

              SELECT COUNT(1)
                 INTO mic_count
                FROM RL_RESULT_ORGANISM_DTL
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
				 AND ORGANISM_CODE   = :rl_res_organism_code
                 AND (REPORT_YN       = 'Y' OR :flag IN ('L', 'K'))
			     AND (SENSITIVITY_IND IN('S','R','I','D') OR :flag IN ('L', 'K') ) //added 'D' for ML-MMOH-CRF-0576
				 AND  SENSITIVITY_IND IS NOT NULL 
				 AND (mic_result IS NOT NULL); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_RESULT_ORGANISM_DTL where \
(((((((((PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) an\
d GROUP_TEST_CODE=:b4) and TEST_CODE=:b5) and ORGANISM_CODE=:b6) and (REPORT_Y\
N='Y' or :b7 in ('L','K'))) and (SENSITIVITY_IND in ('S','R','I','D') or :b7 i\
n ('L','K'))) and SENSITIVITY_IND is  not null ) and mic_result is  not null )";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5007;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&mic_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rl_tst_group_test_code;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rl_tst_test_code;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&rl_res_organism_code;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&flag;
 sqlstm.sqhstl[7] = (unsigned int  )1;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&flag;
 sqlstm.sqhstl[8] = (unsigned int  )1;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

   
			//////		OR zone_size IS NOT NULL);  ////modified against bru-hims-crf-0050
			
			//added the query for linked IN-52950 by krishnamoorthys
	/* EXEC SQL 
			
			SELECT COUNT(1)
                 INTO mic_sign_count
                FROM RL_RESULT_ORGANISM_DTL
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
				 AND ORGANISM_CODE   = :rl_res_organism_code
                 AND (REPORT_YN       = 'Y' OR :flag IN ('L', 'K'))
			     AND (SENSITIVITY_IND IN('S','R','I','D') OR :flag IN ('L', 'K') ) //added 'D' for ML-MMOH-CRF-0576
				 AND  SENSITIVITY_IND IS NOT NULL 
				 AND (mic_sign IS NOT NULL); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_RESULT_ORGANISM_DTL where \
(((((((((PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) an\
d GROUP_TEST_CODE=:b4) and TEST_CODE=:b5) and ORGANISM_CODE=:b6) and (REPORT_Y\
N='Y' or :b7 in ('L','K'))) and (SENSITIVITY_IND in ('S','R','I','D') or :b7 i\
n ('L','K'))) and SENSITIVITY_IND is  not null ) and mic_sign is  not null )";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5058;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&mic_sign_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_hosp_no;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_spec_no;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rl_tst_group_test_code;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rl_tst_test_code;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&rl_res_organism_code;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&flag;
 sqlstm.sqhstl[7] = (unsigned int  )1;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&flag;
 sqlstm.sqhstl[8] = (unsigned int  )1;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			
			//end linked IN-52950

		if(OERROR);               
}

/********************** added for check_mic_value_present_for_test*******************/

get_kb_mic_legend(int l_no_of_organisms, char l_char)
{

	int fe = 0, fs = 0;

///sprintf(string_var,"latest.. within get-kb-mic-legend=%c,orgscnt=%d",l_char,l_no_of_organisms);
///disp_message(ERR_MESG, string_var);

		strcpy(l_kb_mic_legend, "  ");

		if (l_char == 'L')
		{
			for(fe=0; fe < l_no_of_organisms; fe++)
			{

				for(fs = 0; fs < l_no_of_organisms; fs++)
				{
 

//sprintf(string_var,"within forloop 1..mic=%c,micprnt=%c",s_mic[fs].arr[0],s_mic_print_yn[fs].arr[0]);
//disp_message(ERR_MESG, string_var);
//sprintf(string_var,"within forloop 1..mic=%c,micprnt=%c",s_mic[fs].arr[0],s_mic_print_yn[fs].arr[0]);
//disp_message(ERR_MESG, string_var);

				////		if (strlen(s_mic[fs].arr) > 0)
						if (strlen(s_mic[fs].arr) > 0 )
						 {
//sprintf(string_var,"within forloop 2");
//disp_message(ERR_MESG, string_var);
					        if (strcmp(s_mic_print_yn[fs].arr,"Y")==0)
							{
//sprintf(string_var,"within forloop 3");
//disp_message(ERR_MESG, string_var);
							 strcpy(l_kb_mic_legend,"MIC Value");
							 strcpy(l_mic_sign,"MIC Sign"); //added for AMS-CRF-0067 by krishnamoorthys
							 break;
							}
							 
						 }
						 /**************** ---COMMENTED ON 03.12.2012 against bru-hims-crf-0050.
						 else if (strlen(s_zone[fs].arr) > 0)
						 {
							strcpy(l_kb_mic_legend,"KB Value");
							break;
						 }
						*********************/	

				}


			}
		}
		else
		{


/////////			if (strcmp(rl_mic_to_print_yn.arr,"Y")==0) 

		check_mic_value_present_for_test();  //////////added against bru-hims-crf-0050.

///sprintf(string_var,"else part..micprintyn=%s,micval=%s,miccount=%d",b_mic_print_yn.arr,b_mic_value.arr,mic_count);
///disp_message(ERR_MESG, string_var);

			if (mic_count > 0) 
			{
				 strcpy(l_kb_mic_legend, "MIC Value");
				 //added the following code for linked incident In-52950 on 08-dec-2014
					// if (l_customer>0 && mic_sign_count>0) 
					if (strcmp(rl_print_mic_sign_yn.arr,"Y") == 0 && mic_sign_count>0)
				    {
					    strcpy(l_mic_sign, "MIC Sign");//added for AMS-CRF-0067 by krishnamoorthys
					   
					 }  
					 else
					 {
					    strcpy(l_mic_sign, "        ");//added for AMS-CRF-0067 by krishnamoorthys
					 }
					 
				 //moved to if condition for linked issue In-52950
				 //strcpy(l_mic_sign, "MIC Sign");//added for AMS-CRF-0067 by krishnamoorthys
	
	
				/********* ---COMMENTED ON 03.12.2012 against bru-hims-crf-0050.
				else if (strlen(b_zone_value.arr) > 0)
				{
							 strcpy(l_kb_mic_legend,"KB Value");

				}
				********************/
			}
			else
			{
				strcpy(l_kb_mic_legend,"  ");
				strcpy(l_mic_sign," ");//added for AMS-CRF-0067 by krishnamoorthys
			}

		}
////sprintf(string_var,"else part..legend=%s",l_kb_mic_legend);
////disp_message(ERR_MESG, string_var);

}
/********************** added for check_mic_value_present_for_test*******************/
prep_kb_mic_value_for_format4(char l_char)
{
	char l_char1[500];
	char l_char2[500];
	int l_num1 = 0;

//sprintf(string_var, "%c   %s   %s", l_char, b_sensitivity_ind.arr, b_mic_value.arr);
//disp_message(ERR_MESG, string_var);


	strcpy(l_char1, "");
	strcpy(l_char2, "");

	if (l_char == 'Y')
	{
		if (strlen(b_sensitivity_ind.arr) > 0)
		{
			sprintf(l_char1, "(%s)", b_sensitivity_ind.arr);

/////			if (strlen(b_mic_value.arr) > 0)
			
			//commented the code for AMS-CRF-0067 ON 22-DEC-2014
			
			/*************************
			if (strlen(b_mic_value.arr) > 0 && (strcmp(b_mic_print_yn.arr,"Y")==0))
			{

				sprintf(l_char2, "(%-9.9s)", b_mic_value.arr);
			}
			************************/
			//end AMS-CRF-0067 ON 22-DEC-2014
			
			//added the code for AMS-CRF-0067 ON 22-DEC-2014
/****************************
			if (l_customer>0 )
			{
			  if (strlen(b_mic_value.arr) > 0)
			  {
			  sprintf(l_char2, "%-9.9s(%-9.9s)%s",b_mic_sign.arr, b_mic_value.arr);
			  
			  }
			} 
			else if (strlen(b_mic_value.arr) > 0 && (strcmp(b_mic_print_yn.arr,"Y")==0))
***************************/
	        if (strlen(b_mic_value.arr) > 0 && (strcmp(b_mic_print_yn.arr,"Y")==0))
			{
		      if (strcmp(rl_print_mic_sign_yn.arr,"Y") == 0 )			
			     sprintf(l_char2, "%-9.9s(%-9.9s)%s",b_mic_sign.arr, b_mic_value.arr);
              else
			     sprintf(l_char2, "(%-9.9s)", b_mic_value.arr);
			} 
			 
			//end for AMS-CRF-0067 ON 22-DEC-2014
			
			/*******************
			else if (strlen(b_zone_value.arr) > 0)
			{

				sprintf(l_char2, "(%-5.5s)", b_zone_value.arr);
			}
			****************************/
			else
			{
				strcpy(l_char2, " ");
			}


		}
		else
		{
			strcpy(l_char1, " ");
			strcpy(l_char2, " ");
		}
		
	}
	else
	{
		
		sprintf(l_char1, " %s", b_sensitivity_ind.arr);


////		if (strlen(b_mic_value.arr) > 0)

		//commented the code for AMS-CRF-0067 ON 22-DEC-2014
		/********************
		if (strlen(b_mic_value.arr) > 0 && (strcmp(b_mic_print_yn.arr,"Y")==0))
		{
			if (l_customer>0 ) //added the condition for AMS-CRF-0067 by krishnamoorthys
			//sprintf(l_char2, " %-9.9s", b_mic_value.arr); //commented out  the condition for AMS-CRF-0067 by krishnamoorthys
			sprintf(l_char2, " %-9.9s %s %s",b_mic_sign.arr, b_mic_value.arr); //added the condition for AMS-CRF-0067 by krishnamoorthys
			else
			sprintf(l_char2, " %-9.9s %s", b_mic_value.arr);
			
		}
		******************************/
		
		//end AMS-CRF-0067 ON 22-DEC-2014
		
		//added the code for AMS-CRF-0067 ON 22-DEC-2014
/************************* commented on 02.04.2015
		if  (l_customer>0 )
		{
		  if (strlen(b_mic_value.arr) > 0)
		  {
		  sprintf(l_char2, "%-9.9s%s",b_mic_sign.arr, b_mic_value.arr);
		  }
		}
		else if (strlen(b_mic_value.arr) > 0 && (strcmp(b_mic_print_yn.arr,"Y")==0))
**************************/
	    if (strlen(b_mic_value.arr) > 0 && (strcmp(b_mic_print_yn.arr,"Y")==0))
		{
		   if (strcmp(rl_print_mic_sign_yn.arr,"Y") == 0 )
			 sprintf(l_char2, "%-9.9s %s",b_mic_sign.arr, b_mic_value.arr);	
           else
		     sprintf(l_char2, "%-9.9s %s", b_mic_value.arr);
	    } 
		
		//END added the code for AMS-CRF-0067 ON 22-DEC-2014
		  
		/************************
		else if (strlen(b_zone_value.arr) > 0)
		{
			sprintf(l_char2, " %-5.5s", b_zone_value.arr);
		}
		***********************/

	}


				sprintf(text_line,"%-46.46s %-13.13s %s",rl_res_dtl_antibiotic_desc.arr,
						l_char1, l_char2);

/**************** commented against bru-hims-crf-50
		if (strcmp(rl_mic_to_print_yn.arr,"Y")==0) 
		 {

				sprintf(text_line,"%-46.46s %-13.13s %s",rl_res_dtl_antibiotic_desc.arr,
						l_char1, l_char2);
*************************************************/

/**************************
			if (strlen(b_mic_value.arr) > 0)
			{
				sprintf(text_line,"%-46.46s %-13.13s %s",rl_res_dtl_antibiotic_desc.arr,
										l_char1, b_mic_value.arr);
			}
			else if (strlen(b_zone_value.arr) > 0)
			{
				sprintf(text_line,"%-46.46s %-13.13s %s",rl_res_dtl_antibiotic_desc.arr,
						l_char1, b_zone_value.arr);
			}
  			else
			{
				sprintf(text_line,"%-46.46s %-13.13s %s",rl_res_dtl_antibiotic_desc.arr,
						l_char1, " ");
			}
*****************************/

/***********************commented against bru-hims-crf-50
		}
		else
		{
			sprintf(text_line,"%-46.46s %-13.13s",rl_res_dtl_antibiotic_desc.arr,
					l_char1);
		}
*****************************/
}

/********************** added for paranthesis *******************/
/******* added for KDAH requirement to print the long desc of result text code *******/
get_text_code_desc()	
{
	rl_res_text_code_desc.arr[0] = '\0';
	
	/* EXEC SQL SELECT long_desc
		INTO :rl_res_text_code_desc
		FROM RL_RESULT_TEXT_CODE
		WHERE result_text_code = :rl_res_result_text_code
		AND section_code = :rl_hdr_section_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_RESULT_TEXT_CODE where (r\
esult_text_code=:b1 and section_code=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5109;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_res_text_code_desc;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_res_result_text_code;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_hdr_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	rl_res_text_code_desc.arr[rl_res_text_code_desc.len]	= 0;

	if(NODATAFOUND);

	if (OERROR);

}

print_text_code_desc()
{

int l_len = 0;

//sprintf(string_var, "String  -> [%s]  ", rl_res_text_code_desc.arr);
//disp_message(ERR_MESG, string_var);

	fprint_repeat(fp,' ',8);
/*
	
	if (strcmp(rl_print_text_underline_yn.arr, "Y") == 0)
	{
		fprintf(fp,"%c&d0D",ESC);   // Set  UnderLine ON
	}
	if (strcmp(rl_print_text_bold_yn.arr, "Y") == 0)
	{
	   	fprintf(fp,"%c(s4B",ESC);   // Set Bold 
	}

*/


	fprintf(fp,"%s%c%c%c%c%c%c\n",rl_res_text_code_desc.arr,
					rl_tst_status.arr[0], rl_tst_tech_status.arr[0],
		rl_tst_delta_status.arr[0], rl_tst_qlty_status.arr[0],
		rl_tst_cmnt_status.arr[0], rl_tst_path_status.arr[0]);	
	
	page_break(1);

	l_len = strlen(rl_res_text_code_desc.arr);
	if (strcmp(rl_print_text_underline_yn.arr, "Y") == 0)
	{
		fprint_repeat(fp,' ',8);
		fprint_repeat(fp,'-', l_len);
	
		fprintf(fp, "%c%c%c%c%c%c\n", rl_tst_status.arr[0], rl_tst_tech_status.arr[0],
			rl_tst_delta_status.arr[0], rl_tst_qlty_status.arr[0],
			rl_tst_cmnt_status.arr[0], rl_tst_path_status.arr[0]);

		page_break(1);
	}

/*
   	fprintf(fp,"%c(s4B",ESC);
   	fprintf(fp,"%c(s-3B",ESC);
	fprintf(fp,"%c&d@",ESC);   // Set UnderLine OFF 
*/

}


/*--------------added on 25.02.2016 against MMS-DM-CRF-0049-------------------------------------------*/
print_header4()
{

    char t_patient_id[16];   
    char sex_desc[11];
	char pat_name[300];
	char uline[82];
	char l_str[100];
    int i;
	char l_age_legend[5];

//disp_message(ERR_MESG, "111");

    if (strcmp(rl_customer_id.arr, "AMRI") == 0) 
    {
		///print_header_amri();
    }
    else
    {
		pctr++;
       get_parameters();
		lctr = 0;

//disp_message(ERR_MESG, "222");

/*-------------------------- added on 21.10.2004 to skip 2 lines for site AH ------*/
	get_sm_installation();
	if (strcmp(BVNewVersionYN.arr,"N") == 0
					|| strcmp(rl_report_format.arr, "6") == 0    /// added on 09.07.2007 against ARTEMIS request
	   )
	{
	 fprintf(fp,"\n\n");
	 lctr+=2;
	}    
	else
	{
			fprintf(fp,"\n");
			lctr+=1;
	}


/*---------*/
/*-------  added on 21.10.2004 to reset the printer setting before start printing ------*/
//    fprintf(fp,"%cE",ESC); 

/*-------- upto here on 21.10.2004 -----*/

//    fprintf(fp,"%c&a006L",ESC); /* Set the left Margin */
//    fprintf(fp,"%c&k12S",ESC);	/* This makes the font size to increase to 12 */
//	  fprintf(fp,"%c&l6D",ESC);	/* Set the Density */
//    fprintf(fp,"%c(s4B",ESC);   /* Set Bold */
/*---------*/

/***	if (strcmp(rl_customer_id.arr, "KDAH") == 0) 
	{
		fprintf(fp,"\n\n\n\n\n");
		lctr+=5;
	}
***********/
//disp_message(ERR_MESG, "333");
    if (rl_lab_title.len) 
	{
       fprintf(fp,"%-*s%-.80s     C\n",(int)(((90 - rl_lab_title.len)/2) - 6)," ",rl_lab_title.arr);
	   lctr+=2;
	}
    if (rl_lab_title_2.len)
	{
	   fprintf(fp,"%-*s%-.80s     C\n",(int)(((90 - rl_lab_title_2.len)/2) - 6)," ",rl_lab_title_2.arr);
	   lctr+=2;
	}
    if (rl_lab_title_3.len)
	{
	   fprintf(fp,"%-*s%-.80s     C\n",(int)(((90 - rl_lab_title_3.len)/2) - 6)," ",rl_lab_title_3.arr);
	   lctr+=2;
	}
    if (rl_lab_title_4.len)
	{
	   fprintf(fp,"%-*s%-.80s     C\n",(int)(((90 - rl_lab_title_4.len)/2) - 6)," ",rl_lab_title_4.arr);
	   lctr+=2;
	}
    if (rl_lab_title_5.len)  
	{
	   fprintf(fp,"%-*s%-.80s     C\n",(int)(((90 - rl_lab_title_5.len)/2) - 6)," ",rl_lab_title_5.arr);
	   lctr+=2;
	}

//disp_message(ERR_MESG, "444");

	// New title has to be printed as the department name with hardcoded legend 'Department of' 27.07.2004

    rl_lab_title_6.arr[0] = '\0';
    rl_lab_title_6.len = 0;
	/// 12.02.2006 if (strcmp(rl_hmc_yn.arr,"Y") == 0)  // because HMC doesnt want hardcoded legend 
	if (strcmp(BVNewVersionYN.arr,"Y") == 0)  // 12.02.2006 becaz ML,HMC doesnt want hardcoded legend
	{
		strcpy(rl_lab_title_6.arr, rl_section_short_name.arr);
	}
	else
	{
		strcpy(rl_lab_title_6.arr, "Department of ");
		strcat(rl_lab_title_6.arr, rl_section_short_name.arr);
	}

	rl_lab_title_6.len = strlen(rl_lab_title_6.arr);
    if (rl_lab_title_6.len)
	{
	   fprintf(fp,"%-*s%-.80s      C\n",(int)(((90 - rl_lab_title_6.len)/2) - 6)," ",rl_lab_title_6.arr);
	   lctr+=2;
	}

//disp_message(ERR_MESG, "555");
/*----------------------------------------*/

/***** for draft copy legend *********/

	if (strcmp(draft_printing_yn.arr, "N") == 0)
		lctr = lctr;   /// 27.07.2004  lctr = 8;

	else
	{
	    lctr++;       /// 27.07.2004   lctr = 9;    
		//fprintf(fp, "Draft Copy\n"); 
		fprintf(fp, "%-10.10s\n", local_legend[71]); //added for globalisation
	}

	if(l_report_legend.len && strcmp(draft_printing_yn.arr, "N") == 0)  // 21.05.2005
	{
	    lctr++;       
		fprintf(fp, "%s  \n",l_report_legend.arr);
	}
/*----------------------------------------*/
//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
//   	fprintf(fp,"%c(s-3B",ESC);
//    fprintf(fp,"%73.73sPage(s) : %3d\n"," ",pctr);
/*----------------------------------------*/

	

	/*** NEWLY ADDED ON 28/08/2003 TO PRINT THE HMC NO FOR THE MEDICOM NO 
			BEFORE the detail portion of heading******/
	//if(rl_hdr_episode_type.arr[0] != 'R')
	//	print_hmc_no();


//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);

   for(i=0;i<87;i++)
        fprintf(fp,"_");

	fprintf(fp, "\n");

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
//   	fprintf(fp,"%c(s-3B",ESC);

	lctr++;
	
//disp_message(ERR_MESG, "666");

	if (strcmp(rl_actual_dob_yn.arr, "Y") == 0)
		strcpy(l_age_legend, "");
	else
		strcpy(l_age_legend, "*");

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Patient Name : ");
//disp_message(ERR_MESG, "6661");
	fprintf(fp,"%-13.13s: ", local_legend[6]); //added for globalisation
//disp_message(ERR_MESG, "6662");
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp, "%-30.30s                ", rl_pat_short_name.arr);
//disp_message(ERR_MESG, "6663");
//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Age: ");
	fprintf(fp, "%-3.3s: ", local_legend[41]);//added for globalisation
//disp_message(ERR_MESG, "6664");
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp, "%s ", l_age_legend);
//disp_message(ERR_MESG, "6665");
	patient_age();
//disp_message(ERR_MESG, "6666");
	fprintf(fp, "%s\n", t_age.arr);
//disp_message(ERR_MESG, "6667");
	page_break(1);
//disp_message(ERR_MESG, "777");

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Patient  ID  : ");
    fprintf(fp,"%-13.13s: ", local_legend[26]); //added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   
	
	if(rl_hdr_episode_type.arr[0] == 'R')
	{
	   fetch_mp_ext_per_nric();  ///// 03.07.2005 

       if(strcmp(rl_pat_actual_id.arr,"NULL")==0)
	 	   strcpy(t_patient_id,nd_hosp_no.arr);
	   else
		   strcpy(t_patient_id,rl_pat_actual_id.arr);
	}
    else
       strcpy(t_patient_id,nd_hosp_no.arr);

	fprintf(fp, "%-15.15s                          ", t_patient_id);

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);

	if (strcmp(rl_race_accepted_yn.arr,"Y") == 0)
	   //fprintf(fp, "Sex/Race: ");
	   fprintf(fp, "%-8.8s: ",local_legend[42] );//added for globalisation
    else
       //fprintf(fp, "     Sex: ");
	   fprintf(fp, "%8.8s: ",local_legend[7] );//added for globalisation

//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   
//disp_message(ERR_MESG, "888");
    if(rl_pat_sex.arr[0] == 'M')
	   //strcpy(sex_desc,"MALE");
		strcpy(sex_desc,local_legend[37]);//added for globalisation
	else
		if(rl_pat_sex.arr[0] == 'F')
			//strcpy(sex_desc,"FEMALE");
			strcpy(sex_desc,local_legend[38]);//added for globalisation
		else
			//strcpy(sex_desc,"Unknown");
			strcpy(sex_desc,local_legend[43]);//added for globalisation

	fprintf(fp,"%s", sex_desc);

    if (strcmp(rl_race_accepted_yn.arr,"Y") == 0)
	{
//		fprintf(fp,"%c&k4S",ESC); 
//  		fprintf(fp,"%c(s4B",ESC);
		fprintf(fp, "/");
//		fprintf(fp,"%c&k4S",ESC); 
//   		fprintf(fp,"%c(s-3B",ESC);   

		get_race_desc();
		fprintf(fp, "%-15.15s", d_race_desc.arr);
	}

    fprintf(fp, "\n");
	page_break(1);

/********** added on 13.02.2005 *************/

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "NRIC/Alt.IdNo: ");
    fprintf(fp,"%-13.13s: ", local_legend[55]); //added for globaliation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   

    if (rl_national_id_num.len)
	   //fprintf(fp, "%s", rl_national_id_num.arr);  against scf ML-SD-SCF-1749
         fprintf(fp, "%-30.30s", rl_national_id_num.arr); 
	else
       fprintf(fp, "%-30.30s", rl_alternate_id_num.arr);

//11.04.2005    fprintf(fp, "\n");
//11.04.2005	page_break(1);

/************* upto here added on 13.02.2005 ******/

/////////////////  11.04.2005
    get_nationality_desc();	
	fprintf(fp,"%-8.8s"," ");
//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Nationality: ");
	fprintf(fp, "%-11.11s: ",local_legend[45]);//added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   
	fprintf(fp, "%-15.15s  C\n", nd_nationality_desc.arr);
	page_break(1);
/////////////////
//disp_message(ERR_MESG, "999");

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Location     : ");
    fprintf(fp,"%-13.13s: ", local_legend[8]); //added for globaliation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp, "%s", rl_source_short_name.arr);

	if(rl_hdr_episode_type.arr[0] == 'R')
	{
//	    fprintf(fp,"%c&k4S",ESC); 
//   		fprintf(fp,"%c(s4B",ESC);
		fprintf(fp, "/");
//		fprintf(fp,"%c&k4S",ESC); 
//   		fprintf(fp,"%c(s-3B",ESC);   

		fprintf(fp, "%-20.20s\n", rl_location.arr);
		page_break(1);
	}
	else
	{
		fprintf(fp, "\n");
		page_break(1);
	}


	/*** NEWLY ADDED ON 26/08/2003 TO PRINT THE HMC NO FOR THE MEDICOM NO ******/
//	if(rl_hdr_episode_type.arr[0] != 'R')
//		print_hmc_no();

//disp_message(ERR_MESG, "1000");
//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Doctor       : ");
	fprintf(fp, "%-13.13s: ",local_legend[44]);//added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   

    if(rl_ordering_doctor_name.len)    ///// added on 06.12.2004
	  strcpy(rl_consultant_short_name.arr,rl_ordering_doctor_name.arr);

	fprintf(fp,"%-30.30s",rl_consultant_short_name.arr);


//////// 11.04.2005

	fprintf(fp,"%-9.9s"," ");
//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Ordered   : ");
	fprintf(fp,"%-10.10s: ", local_legend[56]); //added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   


	get_order_date_time();

    if(rl_order_id.len)
	{
	  fprintf(fp, "%-16.16s\n", nd_order_date_time.arr);//added for globalisation
    }
	else
	  fprintf(fp, "\n");

//////////// 11.04.2005
	page_break(1);

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Specimen No  : ");
    fprintf(fp,"%-13.13s: ", local_legend[16]); //added for globalisation
// 12.07.2004	fprintf(fp,"%c&k4S",ESC); 
// 12.07.2004  	fprintf(fp,"%c(s-3B",ESC);   

	if (d_interval_specimen_yn == 'Y')
	{
		strcpy(l_str, first_specimen_no.arr);
		strcat(l_str, " (I)");
	}
	else
	{
		strcpy(l_str, nd_spec_no.arr);
		strcat(l_str, "    ");
	}

	fprintf(fp, "%-19.19s                    ", l_str);

//	fprintf(fp,"%c&k4S",ESC);  // 12.07.2004
//  	fprintf(fp,"%c(s-3B",ESC); // 12.07.2004  


//// added the below on  11.04.2005

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
//	fprintf(fp, "Collt Date: ");
	//fprintf(fp, "Collected : ");
    fprintf(fp,"%-10.10s: ", local_legend[58]); //added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   
	
	//fprintf(fp, "%-16.16s\n", rl_hdr_spec_colltd_date_time.arr);	
	fprintf(fp, "%-16.16s\n", rl_hdr_spec_colltd_date_time.arr); //added for globalisation	
////////  upto here added on 11.04.2005

	page_break(1);
	
//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Specimen Type: ");
      fprintf(fp,"%-13.13s: ", local_legend[13]); //added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp,"%-39.39s",rl_spc_specimen_desc.arr);
//disp_message(ERR_MESG, "101111");	

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
//	fprintf(fp, "Recd  Date: ");
	//fprintf(fp, "Received  : ");
    fprintf(fp,"%-10.10s: ", local_legend[59]); //added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   

	//fprintf(fp, "%-16.16s\n", rl_hdr_spec_recd_date_time.arr);
	fprintf(fp, "%-16.16s\n", rl_hdr_spec_recd_date_time.arr); //added for globalisation
	page_break(1);

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Category No  : ");
    fprintf(fp,"%-13.13s: ", local_legend[48]); //added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp, "%-4.4s/%-4.4s/%-15.15s              ", rl_category_code.arr, rl_category_year.arr,
								rl_category_number.arr);


//////// added the below on 11.04.2005

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
//	fprintf(fp, "Regd  Date: ");
	//fprintf(fp, "Registered: ");
    fprintf(fp,"%-10.10s: ", local_legend[57]); //added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);     

            /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:rl_hdr_spec_regd_date_time1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:rl_hdr_spec_regd_date_time1 :=sm_convert_datetime_2t(to_date(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY HH24:MI'),:language_id);
				END;
			END-EXEC; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 30;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "declare t_date date ; BEGIN :rl_hdr_spec_regd_dat\
e_time1 := sm_convert_datetime_2t ( to_date ( :rl_hdr_spec_regd_date_time , 'D\
D/MM/YYYY HH24:MI' ) , :language_id ) ; END ;";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )5136;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time1;
            sqlstm.sqhstl[0] = (unsigned int  )19;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&rl_hdr_spec_regd_date_time;
            sqlstm.sqhstl[1] = (unsigned int  )19;
            sqlstm.sqhsts[1] = (         int  )0;
            sqlstm.sqindv[1] = (         void  *)0;
            sqlstm.sqinds[1] = (         int  )0;
            sqlstm.sqharm[1] = (unsigned int  )0;
            sqlstm.sqadto[1] = (unsigned short )0;
            sqlstm.sqtdso[1] = (unsigned short )0;
            sqlstm.sqhstv[2] = (         void  *)&language_id;
            sqlstm.sqhstl[2] = (unsigned int  )7;
            sqlstm.sqhsts[2] = (         int  )0;
            sqlstm.sqindv[2] = (         void  *)0;
            sqlstm.sqinds[2] = (         int  )0;
            sqlstm.sqharm[2] = (unsigned int  )0;
            sqlstm.sqadto[2] = (unsigned short )0;
            sqlstm.sqtdso[2] = (unsigned short )0;
            sqlstm.sqphsv = sqlstm.sqhstv;
            sqlstm.sqphsl = sqlstm.sqhstl;
            sqlstm.sqphss = sqlstm.sqhsts;
            sqlstm.sqpind = sqlstm.sqindv;
            sqlstm.sqpins = sqlstm.sqinds;
            sqlstm.sqparm = sqlstm.sqharm;
            sqlstm.sqparc = sqlstm.sqharc;
            sqlstm.sqpadto = sqlstm.sqadto;
            sqlstm.sqptdso = sqlstm.sqtdso;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	//fprintf(fp, "%-16.16s\n", rl_hdr_spec_regd_date_time.arr);
	fprintf(fp, "%-16.16s\n", rl_hdr_spec_regd_date_time1.arr); //added for globalisation

//////////// upto here added on 11.04.2005

	page_break(1);


/// 31.10.2006 added the below 

		if (strcmp(rl_use_sample_anatomy_ind.arr, "SA") == 0 ||
				strcmp(rl_use_sample_anatomy_ind.arr, "AT") == 0)
		{
	  	 get_anatomy_site();
		 get_anatomy_site_desc();
//		 fprintf(fp,"%c&k4S",ESC); 
//   		 fprintf(fp,"%c(s4B",ESC);
		 //fprintf(fp, "Anatomy Site : ");
	     fprintf(fp,"%-13.13s: ", local_legend[60]); //added for globalisation
//		 fprintf(fp,"%c&k4S",ESC); 
//   		 fprintf(fp,"%c(s-3B",ESC);

		 fprintf(fp,"%s\n",nd_anatomy_site_desc.arr);
  		 page_break(1);
		}

///

//disp_message(ERR_MESG, "121212");

//    fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s4B",ESC);
	//fprintf(fp, "Clinical     : ");
    fprintf(fp,"%-13.13s: ", local_legend[50]); //added for globalisation
//	fprintf(fp,"%c&k4S",ESC); 
//   	fprintf(fp,"%c(s-3B",ESC);
	   
	if (rl_hdr_request_comment_desc1.len)
    {
      fprintf(fp,"%-40.40s\n",rl_hdr_request_comment_desc1.arr);
      page_break(1);
    }
	else
    {
      fprintf(fp,"\n");
      page_break(1);
    }

//	 fprintf(fp,"%c&k4S",ESC); 
//   	 fprintf(fp,"%c(s4B",ESC);
	 //fprintf(fp, "Comment        ");
     fprintf(fp,"%-15.15s ", local_legend[51]); //added for globalisation
//	 fprintf(fp,"%c&k4S",ESC); 
//   	 fprintf(fp,"%c(s-3B",ESC);

	if (rl_hdr_request_comment_desc2.len)
    {

      fprintf(fp,"%-40.40s\n",rl_hdr_request_comment_desc2.arr);
      page_break(1);
    }
	else
    {
      fprintf(fp,"\n");
      page_break(1);
    }

    
	if (rl_hdr_request_comment_desc3.len)
    {
	  fprintf(fp, "               ");
      fprintf(fp,"%-40.40s\n",rl_hdr_request_comment_desc3.arr);
      page_break(1);
    }

/// 12.07.2004 added the below 
		if (strcmp(rl_ordered_facility_id.arr,nd_operating_facility_id.arr) != 0)
		{
		 get_ordered_company_name();
//		 fprintf(fp,"%c&k4S",ESC); 
//   		 fprintf(fp,"%c(s4B",ESC);
		 //fprintf(fp, "Ordering Facility ID: ");
		 fprintf(fp,"%-20.20s:  ", local_legend[52]); //added for globalisation
//		 fprintf(fp,"%c&k4S",ESC); 
//   		 fprintf(fp,"%c(s-3B",ESC);

		 fprintf(fp,"%s\n",sy_ord_acc_entity_name.arr);
  		 page_break(1);
		}
///



	if (strcmp(rl_test_requested_yn.arr, "Y") == 0)
	{

//		 fprintf(fp,"%c&k4S",ESC); 
//   		 fprintf(fp,"%c(s4B",ESC);
		 //fprintf(fp, "Ordered Tests: ");
		 fprintf(fp,"%-13.13s: ", local_legend[53]); //added for globalisation
//		 fprintf(fp,"%c&k4S",ESC); 
//   		 fprintf(fp,"%c(s-3B",ESC);
		
		strcpy(l_str, "");

		for (i=0;i < no_of_dtl_recs;i++)
		{
			d_inhibit_yn.arr[0]		= '\0';
			d_inhibit_yn.len		= 0;

			strcpy(inhibit_test_code.arr, rl_dtl_test_code[i].arr);
			inhibit_test_code.len = strlen(inhibit_test_code.arr);

			chk_inhibit_yn();

			if (d_inhibit_yn.arr[0]	== 'N') 
			{
				if (i == 0)
					sprintf(l_str,"%s", rl_dtl_test_code[i].arr);
				else
					sprintf(l_str,"%s,%s",l_str, rl_dtl_test_code[i].arr);
			}

//11.04.2005   if (i > 15) 

			if (i > 5) 
				break;
		}

		if(no_of_dtl_recs > 7)
		  sprintf(l_str,"%s...",l_str);

		fprintf(fp,"%s\n",l_str);
		page_break(1);
	}


	if(rl_hdr_episode_type.arr[0] == 'R')
	{
		if (strlen(rl_message_line.arr) > 0)
		{
			fprintf(fp, "%70.70s ", rl_message_line.arr);
			fprintf(fp, "%-15.15s\n", nd_hosp_no.arr);
			page_break(1);

		}
	}
//disp_message(ERR_MESG, "13333");
//    fprintf(fp,"%c&k4S",ESC);  
//    fprintf(fp,"%c(s4B",ESC);
    for(i=0;i<87;i++)
        fprintf(fp,"_");
//    fprintf(fp,"%c&k4S",ESC);  
//    fprintf(fp,"%c(s-3B",ESC);

	page_break(1);
	fprintf(fp, "\n"); 
    
	if (strcmp(rl_print_num_result_title_yn.arr, "Y") == 0)
    {

	// print_result_titles(); /// created this procedure to maintain the below common code


	}

    }
}
/*-----------------------------*/

get_parameters()
{
    rl_lab_title.arr[0] = '\0';
    rl_lab_title.len = 0;
    rl_lab_title_2.arr[0] = '\0';
    rl_lab_title_2.len = 0;
    rl_lab_title_3.arr[0] = '\0';
    rl_lab_title_3.len = 0;
    rl_lab_title_4.arr[0] = '\0';
    rl_lab_title_4.len = 0;
    rl_lab_title_5.arr[0] = '\0';
    rl_lab_title_5.len = 0;
    rl_race_accepted_yn.arr[0] = '\0';   /// 27.07.2004
    rl_race_accepted_yn.len = 0;



     {
		 /* EXEC SQL SELECT nvl(a.lab_title,b.lab_title),
	 					 nvl(a.lab_title_2,b.lab_title_2), 
						 nvl(a.lab_title_3,b.lab_title_3),
						 nvl(a.lab_title_4,b.lab_title_4),
						 nvl(a.lab_title_5,b.lab_title_5), 
						 nvl(b.race_accepted_yn,'N')
				  INTO :rl_lab_title, :rl_lab_title_2, :rl_lab_title_3, :rl_lab_title_4,
				       :rl_lab_title_5,:rl_race_accepted_yn
				  FROM   RL_PARAM_FOR_FACILITY A , RL_PARAM B
				  WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select nvl(a.lab_title,b.lab_title) ,nvl(a.lab_title_2,b.l\
ab_title_2) ,nvl(a.lab_title_3,b.lab_title_3) ,nvl(a.lab_title_4,b.lab_title_4\
) ,nvl(a.lab_title_5,b.lab_title_5) ,nvl(b.race_accepted_yn,'N') into :b0,:b1,\
:b2,:b3,:b4,:b5  from RL_PARAM_FOR_FACILITY A ,RL_PARAM B where OPERATING_FACI\
LITY_ID=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5163;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_lab_title;
   sqlstm.sqhstl[0] = (unsigned int  )103;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_lab_title_2;
   sqlstm.sqhstl[1] = (unsigned int  )203;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&rl_lab_title_3;
   sqlstm.sqhstl[2] = (unsigned int  )203;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&rl_lab_title_4;
   sqlstm.sqhstl[3] = (unsigned int  )203;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&rl_lab_title_5;
   sqlstm.sqhstl[4] = (unsigned int  )203;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&rl_race_accepted_yn;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



 		 if(NODATAFOUND)
		 {
			    /* EXEC SQL  SELECT LAB_TITLE, lab_title_2, lab_title_3,lab_title_4, lab_title_5, nvl(race_accepted_yn,'N')
						  INTO :rl_lab_title, :rl_lab_title_2, :rl_lab_title_3, :rl_lab_title_4,
							   :rl_lab_title_5,:rl_race_accepted_yn
						  FROM RL_PARAM; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 30;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select LAB_TITLE ,lab_title_2 ,lab_title_3 ,lab_title_\
4 ,lab_title_5 ,nvl(race_accepted_yn,'N') into :b0,:b1,:b2,:b3,:b4,:b5  from R\
L_PARAM ";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )5206;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&rl_lab_title;
       sqlstm.sqhstl[0] = (unsigned int  )103;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&rl_lab_title_2;
       sqlstm.sqhstl[1] = (unsigned int  )203;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&rl_lab_title_3;
       sqlstm.sqhstl[2] = (unsigned int  )203;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&rl_lab_title_4;
       sqlstm.sqhstl[3] = (unsigned int  )203;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&rl_lab_title_5;
       sqlstm.sqhstl[4] = (unsigned int  )203;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&rl_race_accepted_yn;
       sqlstm.sqhstl[5] = (unsigned int  )4;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



				  if (OERROR)
					 ins_message(ORA_MESG,"Select failed on table RL_PARAM");

		 }
	 }

      if (OERROR)
         ins_message(ORA_MESG,"Select failed on table RL_PARAM");

	rl_race_accepted_yn.arr[rl_race_accepted_yn.len] = '\0';
    rl_lab_title.arr[rl_lab_title.len] = '\0';
	rl_lab_title_2.arr[rl_lab_title_2.len] = '\0';
	rl_lab_title_3.arr[rl_lab_title_3.len] = '\0';
	rl_lab_title_4.arr[rl_lab_title_4.len] = '\0';  
	rl_lab_title_5.arr[rl_lab_title_5.len] = '\0';  

	// The last  title has to be concatenated with the department name


}
/*-----------------------------------------------------*/
get_sm_installation()
{
 
	BVNewVersionYN.arr[0] = '\0';
	BVNewVersionYN.len = 0;
	strcpy(BVNewVersionYN.arr,"N");

	/* EXEC SQL EXECUTE 
	BEGIN 
		IF sm_installation_tab_check THEN
			:BVNewVersionYN := 'Y';
		ELSE
			:BVNewVersionYN := 'N';
		END IF;
	END ;
	END-EXEC ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin IF sm_installation_tab_check THEN :BVNewVersionYN := '\
Y' ; ELSE :BVNewVersionYN := 'N' ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5245;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVNewVersionYN;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	BVNewVersionYN.len = strlen(BVNewVersionYN.arr);

			
}
/*-----------------------------------------------------*/
print_result_titles()   
{
	int r_ctr = 0;
	char l_string[100];     
	char l_delimeter;
	int	 l_len = 11;
	int	 l_len1 = 0;
	int	 l_len2 = 0;
	int	 l_len3 = 0;
	int	 l_len4 = 0;
	if (strcmp(rl_print_num_result_title_yn.arr, "Y") == 0)
    {
     if(rl_title_for_test.len)
	 {
	    fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
//		fprintf(fp, "%s%s", rl_title_for_test.arr," ");
		fprintf(fp, "%s", rl_title_for_test.arr);
        fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
		fprintf(fp, "%s", " ");
		for(i=0;i<(39-rl_title_for_test.len);i++)
		   fprintf(fp, "%s", " ");
     }
	 else
		fprintf(fp, "%-40.40s", " ");

     if(rl_title_for_num_result.len)
	 {
	    fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
//		fprintf(fp, "%s%s", rl_title_for_num_result.arr," ");
		fprintf(fp, "%s", rl_title_for_num_result.arr);
        fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
		fprintf(fp, "%s", " ");
		for(i=0;i<(9-rl_title_for_num_result.len);i++)
		   fprintf(fp, "%s", " ");
     }
	 else
		fprintf(fp, "%-10.10s", " ");

     if (strcmp(rl_customer_id.arr, "KDAH") == 0)  ///added this condition against KDAH-CRF-0174 on 12/03/2012
     {
		 if(rl_title_for_range_ind.len)
		 {
			fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
			fprintf(fp, "%s", rl_title_for_range_ind.arr);
			fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
			for(i=0;i<(5-rl_title_for_range_ind.len);i++)
			   fprintf(fp, "%s", " ");
		 }
		 else
			fprintf(fp, "%-4.4s", " ");
	 }
	 

     if(rl_title_for_test_units.len)
	 {
	    fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
//		fprintf(fp, "%s%s", rl_title_for_test_units.arr," ");
		fprintf(fp, "%s", rl_title_for_test_units.arr);
        fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
		fprintf(fp, "%s", " ");
		for(i=0;i<(9-rl_title_for_test_units.len);i++)
		   fprintf(fp, "%s", " ");
     }
	 else
		fprintf(fp, "%-10.10s", " ");

     if (strcmp(rl_customer_id.arr, "KDAH") != 0)  ///added this condition against KDAH-CRF-0174 on 12/03/2012
     {
		 if(rl_title_for_range_ind.len)
		 {
			fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
			fprintf(fp, "%s", rl_title_for_range_ind.arr);
			fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
			for(i=0;i<(5-rl_title_for_range_ind.len);i++)
			   fprintf(fp, "%s", " ");
		 }
		 else
			fprintf(fp, "%-4.4s", " ");
	 }
	 


		if (strlen(rl_title_for_result_range.arr) > 15)
		{
   		    l_delimeter = ' ';
			rl_split_text(rl_title_for_result_range.arr,l_delimeter,l_len,rl_title1_for_result_range.arr,
							  rl_title2_for_result_range.arr,rl_title3_for_result_range.arr,rl_title4_for_result_range.arr);

//  sprintf(string_var,"rl_title1_for_result_range=%s",rl_title1_for_result_range.arr);
//  disp_message(ERR_MESG,string_var);

			fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/

			rtrim(rl_title1_for_result_range.arr);
			fprintf(fp, "%s", rl_title1_for_result_range.arr);
			fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
		//	for(i=0;i<(14-rl_title1_for_result_range.len);i++)
		//	   fprintf(fp, "%s", " ");
			page_break(1);
			fprintf(fp, "\n");


			for(i=0;i<64;i++)
			   fprintf(fp, "%s", " ");

			fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/

			rtrim(rl_title2_for_result_range.arr);


			rtrim(rl_title3_for_result_range.arr);
			fprintf(fp, "%s %s", rl_title2_for_result_range.arr,rl_title3_for_result_range.arr);
			fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
		//	for(i=0;i<(14-(rl_title2_for_result_range.len + rl_title3_for_result_range.len));i++)
		//	   fprintf(fp, "%s", " ");

		}
	   else
		{
		   if(rl_title_for_result_range.len)
		   {
				fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
		///		fprintf(fp, "%s%s", rl_title_for_result_range.arr," ");
				fprintf(fp, "%s", rl_title_for_result_range.arr);
				fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
				for(i=0;i<(14-rl_title_for_result_range.len);i++)
				   fprintf(fp, "%s", " ");
		   }
		   else
	    		fprintf(fp, "%-15.15s", " ");
		}
/////////////////////////////////


	page_break(1);
	fprintf(fp, "\n");

	}
}
/*******************************************************************************************/
chk_inhibit_yn()
{

	/* EXEC SQL SELECT NVL(inhibit_report_yn, 'N') 
			INTO :d_inhibit_yn
			FROM RL_TEST_CODE 
			WHERE test_code = :inhibit_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(inhibit_report_yn,'N') into :b0  from RL_TEST_COD\
E where test_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5264;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_inhibit_yn;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&inhibit_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




	d_inhibit_yn.arr[d_inhibit_yn.len]		= '\0';
}

/*******************************************************************************************/
get_ordered_company_name()
{
    /* EXEC SQL  SELECT ACC_ENTITY_NAME  
		        INTO :sy_ord_acc_entity_name
	            FROM SY_ACC_ENTITY_LANG_VW
			WHERE ACC_ENTITY_ID = :rl_ordered_facility_id
			and language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME into :b0  from SY_ACC_ENTITY_LANG_\
VW where (ACC_ENTITY_ID=:b1 and language_id=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5287;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sy_ord_acc_entity_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_ordered_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&language_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	/* Company Name Master */

      if (OERROR)
         ins_message(ORA_MESG,"Select failed on table SY_ACC_ENTITY");

    sy_ord_acc_entity_name.arr[sy_ord_acc_entity_name.len] = '\0'; 
}


/*-----------------------------------------------------*/
get_anatomy_site_desc()
{
	nd_anatomy_site_desc.arr[0]	= '\0';
	nd_anatomy_site_desc.len		= 0;

   /* EXEC SQL SELECT long_desc
			  INTO :nd_anatomy_site_desc
		      FROM RL_ANATOMY_SITE_CODE_LANG_VW
             WHERE ANATOMY_SITE_CODE   = :nd_anatomy_site
			 AND LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select long_desc into :b0  from RL_ANATOMY_SITE_CODE_LANG_\
VW where (ANATOMY_SITE_CODE=:b1 and LANGUAGE_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5314;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_anatomy_site_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_anatomy_site;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&language_id;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




    if(OERROR);

	if (NODATAFOUND);

	nd_anatomy_site_desc.arr[nd_anatomy_site_desc.len]	= '\0';
	
}
/*------------------------------------------------------------*/
get_anatomy_site()
{
	nd_anatomy_site.arr[0]	= '\0';
	nd_anatomy_site.len		= 0;

	   /* EXEC SQL SELECT anatomy_site_code
				  INTO :nd_anatomy_site
				  FROM RL_SAMPLE_DETAILS
				 WHERE SPECIMEN_NO     = :nd_spec_no
				   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				   AND ANATOMY_SITE_CODE IS NOT NULL
				   AND ROWNUM =1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select anatomy_site_code into :b0  from RL_SAMPLE_DETAILS\
 where (((SPECIMEN_NO=:b1 and OPERATING_FACILITY_ID=:b2) and ANATOMY_SITE_CODE\
 is  not null ) and ROWNUM=1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5341;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_anatomy_site;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (NODATAFOUND)
	{

	   /* EXEC SQL SELECT anatomy_site_code
				  INTO :nd_anatomy_site
				  FROM RL_SPECIMEN_ANATOMY_DTLS
				 WHERE SPECIMEN_NO     = :nd_spec_no
				   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				   AND ANATOMY_SITE_CODE IS NOT NULL
				   AND ROWNUM =1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select anatomy_site_code into :b0  from RL_SPECIMEN_ANATO\
MY_DTLS where (((SPECIMEN_NO=:b1 and OPERATING_FACILITY_ID=:b2) and ANATOMY_SI\
TE_CODE is  not null ) and ROWNUM=1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5368;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_anatomy_site;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_spec_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	}

	if (NODATAFOUND);

    if(OERROR);

	nd_anatomy_site.arr[nd_anatomy_site.len]	= '\0';
	
}
/*------------------------------------------------------------*/
get_nationality_desc()
{
	nd_nationality_desc.arr[0]		= '\0';
	nd_nationality_desc.len			= 0;

 /*
   EXEC SQL SELECT nationality
			INTO :nd_nationality_desc
			FROM MP_COUNTRY_HIS_VW
			WHERE country_code = :rl_pat_nationality;*/
   /* EXEC SQL SELECT short_name
			INTO :nd_nationality_desc
			FROM MP_COUNTRY_LANG_VW
			WHERE country_code = :rl_pat_nationality
			AND   language_id =:language_id ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_name into :b0  from MP_COUNTRY_LANG_VW where \
(country_code=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5395;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_nationality_desc;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_pat_nationality;
   sqlstm.sqhstl[1] = (unsigned int  )6;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&language_id;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      if(OERROR);

	if (NODATAFOUND);

	nd_nationality_desc.arr[nd_nationality_desc.len]	= '\0';

}
/*------------------------------------------------------------*/

get_race_desc()
{
	
	d_race_desc.arr[0]		= '\0';
	d_race_desc.len			= 0;

	/* EXEC SQL SELECT short_desc
		     INTO :d_race_desc
			 FROM MP_RACE_lang_vw
			 WHERE race_code = :rl_race_code
			 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from MP_RACE_lang_vw where (race\
_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5422;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_race_desc;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_race_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (NODATAFOUND);

	d_race_desc.arr[d_race_desc.len]			= '\0';
	
}


/******************************************************************************************/
fetch_mp_ext_per_nric() 
{
	rl_national_id_num.arr[0]				  = '\0';
	rl_alternate_id_num.arr[0]				  = '\0';
	rl_national_id_num.len					  = 0;
	rl_alternate_id_num.len                   = 0;

    /* EXEC SQL SELECT NATIONAL_ID_NO,
	        //ALT_ID1_NO
			NVL(ALT_ID1_NO,NVL(ALT_ID2_NO,NVL(ALT_ID3_NO,NVL(ALT_ID4_NO,' ')))) //18.06.2008 against ML-SD-CRF-20224

	           INTO :rl_national_id_num,:rl_alternate_id_num
               FROM MP_EXT_PERSON
              WHERE PERSON_ID = :nd_hosp_no; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NATIONAL_ID_NO ,NVL(ALT_ID1_NO,NVL(ALT_ID2_NO,NVL(\
ALT_ID3_NO,NVL(ALT_ID4_NO,' ')))) into :b0,:b1  from MP_EXT_PERSON where PERSO\
N_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5449;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_national_id_num;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_alternate_id_num;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (NODATAFOUND);    

    if (OERROR);

	rl_national_id_num.arr[rl_national_id_num.len]		 = '\0';
	rl_alternate_id_num.arr[rl_alternate_id_num.len]	 = '\0';

}

/*-----------------------------------------------------*/
patient_age()
 {

		 float  lone = 0;
		 float  num1 = 0, yrs = 0, 
				tmp_mths = 0, 
				tmp_days = 0;

		 char st_r[50];

	tday.arr[0] = '\0';
	tday.len = 0;

	mths.arr[0]  = '\0';
	mths.len  = 0;
//disp_message(ERR_MESG, "66651");
	
	/* EXEC SQL SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') INTO :tday
            FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5476;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&tday;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

                                        
//disp_message(ERR_MESG, "66652 %s %s",rl_hdr_spec_regd_date_time.arr,rl_pat_date_of_birth.arr);


//sprintf(string_var,"regdt=%s,dob=%s",rl_hdr_spec_regd_date_time.arr,rl_pat_date_of_birth.arr);
//	  disp_message(ERR_MESG, string_var);


    /* EXEC SQL SELECT ABS(MONTHS_BETWEEN(TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY'), 
									   TO_DATE(:rl_pat_date_of_birth, 'DD/MM/YYYY')))
					INTO :mt FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ABS(MONTHS_BETWEEN(TO_DATE(:b0,'DD/MM/YYYY'),TO_DA\
TE(:b1,'DD/MM/YYYY'))) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5495;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_pat_date_of_birth;
    sqlstm.sqhstl[1] = (unsigned int  )18;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&mt;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(float);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			sprintf(mths.arr,"%d",mt);

//sprintf(string_var,"mths=%s",mths.arr);
//	  disp_message(ERR_MESG, string_var);

			strcpy(mths1.arr, mths.arr);

        	tday.arr[tday.len] = '\0';
							
			lone = atoi(strtok(mths1.arr, ".")) ;

		   if (lone > 0) 
		   {
			  num1 = lone/12 ;
			  sprintf(t_age.arr, "%f", num1);
			  yrs = atoi(strtok(t_age.arr, ".")) ;
		   }
		   else
			  yrs = 0;
            
			tmp_mths   = atoi(mths1.arr) - (yrs * 12) ;
			sprintf(t_age.arr, "%f", tmp_mths);
			tmp_mths   = atoi(strtok(t_age.arr, "."));

//sprintf(string_var,"tage=%s",t_age.arr);
//	  disp_message(ERR_MESG, string_var);


			if ((tmp_mths == 0)  && (yrs ==0))
			{
//disp_message(ERR_MESG, "666541");
			/* EXEC SQL SELECT TO_CHAR(ROUND((TO_DATE(:rl_hdr_spec_regd_date_time,'DD/MM/YYYY') -
					TO_DATE(:rl_pat_date_of_birth, 'DD/MM/YYYY')),3))
					INTO :t_days FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select TO_CHAR(ROUND((TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:b\
1,'DD/MM/YYYY')),3)) into :b2  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5522;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_hdr_spec_regd_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )19;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_pat_date_of_birth;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&t_days;
   sqlstm.sqhstl[2] = (unsigned int  )32;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


//disp_message(ERR_MESG, "666542");
				///t	tmp_days = atoi(strtok(t_days.arr,"."));
					
//disp_message(ERR_MESG, "666543");
			}
			else
				tmp_days = (atof(mths.arr) - atoi(mths1.arr)) * 31 ;

//disp_message(ERR_MESG, "66655");
			sprintf(st_r, "%f", yrs);
			strcpy(t_age.arr, strtok(st_r, "."));
			//strcat(t_age.arr, "Y");
			strncat(t_age.arr, local_legend[72],1);

			if (strcmp(rl_report_format.arr, "6") != 0  
			    && strcmp(rl_customer_id.arr, "AMRI") != 0) 
					
			{
				sprintf(st_r, " %f", tmp_mths);
				strcat(t_age.arr, strtok(st_r, "."));
				//strcat(t_age.arr, "M");
				strncat(t_age.arr, local_legend[73],1);
				sprintf(st_r, " %f", tmp_days);
				strcat(t_age.arr, strtok(st_r, "."));
				//strcat(t_age.arr, "D ");
				strncat(t_age.arr, local_legend[74],1);
			}
			
//disp_message(ERR_MESG, "66656");
			if (strcmp(rl_customer_id.arr, "AMRI") == 0)
			{
				if (yrs == 0) 
				{
					if ( tmp_mths == 0)
					{
						sprintf(st_r, " %f", tmp_days);
						strcpy(t_age.arr, strtok(st_r, "."));
						strncat(t_age.arr, local_legend[74],1);
					}
					else
					{
						sprintf(st_r, " %f", tmp_mths);
						strcpy(t_age.arr, strtok(st_r, "."));
						strncat(t_age.arr, local_legend[73],1);
					}
				}
			}
 }
/*------------------------------------------------------------*/
ins_message(int msg_type,char msg[])
{

   
   
   /* EXEC SQL ROLLBACK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5549;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   
   er_msg_type = 0;

   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(msg);
 
   er_msg_type = msg_type;

   sprintf(err_num,"%d",sqlca.sqlcode);

   strcpy(er_msg_num.arr, err_num);
 	er_msg_num.len = strlen(er_msg_num.arr);


   /* EXEC SQL
   INSERT INTO SY_PROG_MSG
          (OPERATING_FACILITY_ID,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
          (:nd_operating_facility_id,'RLRRSENQ',:er_msg_type, SUBSTR(:er_msg_num,1,6),SUBSTR(:er_msg, 1, 70),SYSDATE,:sy_session_id,
		   :sy_req_date); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'RLRRSENQ\
',:b1,SUBSTR(:b2,1,6),SUBSTR(:b3,1,70),SYSDATE,:b4,:b5)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5564;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&er_msg_type;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&er_msg_num;
   sqlstm.sqhstl[2] = (unsigned int  )1002;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&er_msg;
   sqlstm.sqhstl[3] = (unsigned int  )1073;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&sy_session_id;
   sqlstm.sqhstl[4] = (unsigned int  )32;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&sy_req_date;
   sqlstm.sqhstl[5] = (unsigned int  )32;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   err_flag = 1;
  
  /* EXEC SQL COMMIT ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5603;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  
}
/********************** added for globalisation ***********************************/
get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRSENQ1.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRSENQ1.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5618;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	for (i=1; i<=cou; i++)
	{
		l_translated_value.arr[0]		= '\0';
		/* EXEC SQL EXECUTE
		BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRSENQ1.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
RLRSENQ1.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5641;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[0] = (unsigned int  )602;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&i;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
		l_translated_value.arr[l_translated_value.len] = '\0';
		//sp_message(ERR_MESG,l_translated_value.arr);
		strcpy(local_legend[i],l_translated_value.arr);
		
		//disp_message(ERR_MESG,local_legend[i]);
	}
 }
/********************** added for globalisation ***********************************/
/*-----------------------------------------------------*/


get_order_date_time()
{
	nd_order_date_time.arr[0]		= '\0';
	nd_order_date_time.len		= 0;

   /* EXEC SQL SELECT TO_CHAR(ord_date_time,'DD/MM/YYYY HH24:MI')
			INTO :nd_order_date_time
			FROM OR_ORDER
			WHERE order_id = :rl_order_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select TO_CHAR(ord_date_time,'DD/MM/YYYY HH24:MI') into :b\
0  from OR_ORDER where order_id=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5664;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_order_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )19;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_order_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 

    if(OERROR);

	if (NODATAFOUND);    

	nd_order_date_time.arr[nd_order_date_time.len]	= '\0';
     
    
}
/*------------------------------------------------------------*/

print_footer5(foot_ind)
int foot_ind;
{
   int fi = 0;
   int bal = 0;
   char l_str[100];
   l_str[0] = '\0'; 


    if (strcmp(rl_customer_id.arr, "AMRI") == 0) 
    {

		 fflush(fp);

	}
	else
	{

	   for(fi=0; fi < 87; fi++)
		   fprintf(fp,"%c",'_');

	   fprintf(fp,"\n");

	   fflush(fp);

      if (rl_name_on_report_yn.arr[0] == 'Y')
	  {

		get_print_name(first_user.arr);
	  if (print_name_yn.arr[0]	== 'Y')
	  {

		get_user_name(first_user.arr);

	   /*----------------------------------------*/
//		fprintf(fp,"%c&k4S",ESC); 
//		fprintf(fp,"%c(s4B",ESC);
//		fprintf(fp,"Released/Reviewed By : ");
		//fprintf(fp,"Released By   : ");
		fprintf(fp,"%-13.13s : ", local_legend[61]); //added for globalisation
//		fprintf(fp,"%c&k4S",ESC); 
//		fprintf(fp,"%c(s-3B",ESC);   
  	    sprintf(l_str,"%s", sy_user_name.arr);

		fprintf(fp,"%-60.60s\n",l_str);

		get_position_desc(sy_func_role_id.arr);

		fprintf(fp,"                ");
		sprintf(l_str,"%s", nd_position_desc.arr);
		fprintf(fp,"%-30.30s",l_str);	
		fprintf(fp, "    ");
		}
		/*----------------------------------------*/

	   /*----------------------------------------*/	   
//	   fprintf(fp,"%c&k4S",ESC); 
//	   fprintf(fp,"%c(s4B",ESC);
	   //fprintf(fp,"Released Date  : ");
	   fprintf(fp,"%-15.15s : ", local_legend[62]); //added for globalisation
//	   fprintf(fp,"%c&k4S",ESC); 
//	   fprintf(fp,"%c(s-3B",ESC);   
	   fprintf(fp,"%-s\n",footer_released_date);
	   /*----------------------------------------*/

	   	sy_user_name.arr[0]		= '\0';
		sy_user_name.len			= 0;

	 }

	  get_print_name(rl_hdr_released_by_id.arr);
	  if (print_name_yn.arr[0]	== 'Y')
	  {

		get_user_name(rl_hdr_released_by_id.arr);

	   /*----------------------------------------*/
//		fprintf(fp,"%c&k4S",ESC); 
//		fprintf(fp,"%c(s4B",ESC);
//		fprintf(fp,"Reviewed By : ");
		//fprintf(fp,"Authorized By : ");
		fprintf(fp,"%-13.13s : ", local_legend[64]); //added for globalisation
//		fprintf(fp,"%c&k4S",ESC); 
//		fprintf(fp,"%c(s-3B",ESC);   
  	    sprintf(l_str,"%s", sy_user_name.arr);

		fprintf(fp,"%-60.60s\n",l_str);

		get_position_desc(sy_func_role_id.arr);

		sprintf(l_str,"%s", nd_position_desc.arr);
		fprintf(fp,"                ");
		fprintf(fp,"%-30.30s",l_str);	
		fprintf(fp, "    ");


	   /*----------------------------------------*/	   
//	   fprintf(fp,"%c&k4S",ESC); 
//	   fprintf(fp,"%c(s4B",ESC);
//	   fprintf(fp,"Reviewed Date : ");
	   //fprintf(fp,"Authorized Date: ");
	   fprintf(fp,"%-15.15s : ", local_legend[66]); //added for globalisation
//	   fprintf(fp,"%c&k4S",ESC); 
//	   fprintf(fp,"%c(s-3B",ESC);   
	   //fprintf(fp,"%-s\n",rl_hdr_released_date.arr);
	   fprintf(fp,"%-s\n",rl_hdr_released_date.arr); //added for globalisation
	   /*----------------------------------------*/

   	   	sy_user_name.arr[0]		= '\0';
		sy_user_name.len			= 0;


	  }

		/*----------------------------------------*/
		/***********************
	    fprintf(fp,"%c&k4S",ESC); 
		fprintf(fp,"%c(s4B",ESC);
		fprintf(fp,"Reprint Date : ");
        fprintf(fp,"%c&k4S",ESC); 
        fprintf(fp,"%c(s-3B",ESC);   
		***********************/
		/*----------------------------------------*/

///////////////// 12.07.2004 'ss'
		if (p_param8.arr[0] == 'P')
		{
		  get_print_name(sy_user_id.arr);
		  if (print_name_yn.arr[0]	== 'Y')
		  {

			get_user_name(sy_user_id.arr);

		   /*----------------------------------------*/ 
//			fprintf(fp,"%c&k4S",ESC); 
//			fprintf(fp,"%c(s4B",ESC);
			//fprintf(fp,"Reprinted By  : ");
			fprintf(fp,"%-13.13s : ", local_legend[67]); //added for globalisation 
//			fprintf(fp,"%c&k4S",ESC); 
//			fprintf(fp,"%c(s-3B",ESC);   
  			sprintf(l_str,"%s", sy_user_name.arr);

			fprintf(fp,"%-60.60s\n",l_str);

			get_position_desc(sy_func_role_id.arr);

			sprintf(l_str,"%s", nd_position_desc.arr);
			fprintf(fp,"                ");
			fprintf(fp,"%-30.30s",l_str);	
			fprintf(fp, "    ");


		   /*----------------------------------------*/	   
//		   fprintf(fp,"%c&k4S",ESC); 
//		   fprintf(fp,"%c(s4B",ESC);
		   //fprintf(fp,"Reprinted Date : ");
			fprintf(fp,"%-15.15s : ", local_legend[68]); //added for globalisation 
//		   fprintf(fp,"%c&k4S",ESC); 
//		   fprintf(fp,"%c(s-3B",ESC);   

			l_sy_req_date.arr[0]	= '\0';
			l_sy_req_date.len	= 0;

			/* EXEC SQL SELECT  to_char(to_date(:sy_req_date,'DDMMYYHH24MISS'),'DD/MM/YYYY HH24:MI')
				   INTO		:l_sy_req_date
				   FROM		DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select to_char(to_date(:b0,'DDMMYYHH24MISS'),'DD/MM/YYYY H\
H24:MI') into :b1  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5687;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&sy_req_date;
   sqlstm.sqhstl[0] = (unsigned int  )32;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_sy_req_date;
   sqlstm.sqhstl[1] = (unsigned int  )32;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			   if (OERROR);

			l_sy_req_date.arr[l_sy_req_date.len] = '\0';

	 /**** date conversion start for globalisation ************/
        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:l_sy_req_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				//:l_sy_req_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				:l_sy_req_date1 :=sm_convert_datetime_2t(to_date(:l_sy_req_date,'DD/MM/YYYY HH24:MI'),:language_id);
				END;
			END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 30;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "declare t_date date ; BEGIN :l_sy_req_date1 := sm_con\
vert_datetime_2t ( to_date ( :l_sy_req_date , 'DD/MM/YYYY HH24:MI' ) , :langua\
ge_id ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )5710;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&l_sy_req_date1;
        sqlstm.sqhstl[0] = (unsigned int  )32;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&l_sy_req_date;
        sqlstm.sqhstl[1] = (unsigned int  )32;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&language_id;
        sqlstm.sqhstl[2] = (unsigned int  )7;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	 /**** date conversion end for globalisation ************/


		   fprintf(fp,"%-s\n",l_sy_req_date1.arr);
//		   fprintf(fp,"%-s\n",l_sy_req_date.arr);
		   /*----------------------------------------*/

   	   		sy_user_name.arr[0]		= '\0';
			sy_user_name.len			= 0; 



		}
////////////////
	  
	}
  }

//	fprintf(fp,"%c&k4S",ESC);       
/****** FOOTER PRINTING FROM RL_SECTION_CTL  ****************/
   if ( (strlen(rl_footer_line_1.arr) > 0) ||
			(strlen(rl_footer_line_2.arr) > 0) || (strlen(rl_footer_line_3.arr) > 0) )
   {
		if (strlen(rl_footer_line_1.arr) > 0) 
			fprintf(fp, "%-79.79s\n", rl_footer_line_1.arr);

		if (strlen(rl_footer_line_2.arr) > 0) 
			fprintf(fp, "%-79.79s\n", rl_footer_line_2.arr);

		if (strlen(rl_footer_line_3.arr) > 0) 
			fprintf(fp, "%-79.79s\n", rl_footer_line_3.arr);
 

   }

//	fprintf(fp,"%c&k4S",ESC); 

   /*----------------------------------------*/

   if (rl_hdr_extra_copies_to.len && copy == 2  && 
		strcmp(draft_printing_yn.arr, "N") == 0)
   {
      /*----------------------------------------*/
//      fprintf(fp,"%c&k4S",ESC); 
//      fprintf(fp,"%c(s4B",ESC);
      //fprintf(fp,"Copy To : ");
      fprintf(fp,"%-8.8s: ", local_legend[23]); //added for globalisation
//      fprintf(fp,"%c&k4S",ESC); 
//      fprintf(fp,"%c(s-3B",ESC);   
      /*----------------------------------------*/

      sprintf(l_str,"%24.24s",rl_hdr_extra_copies_to.arr);
   }
   else
      sprintf(l_str,"%34.34s"," ");

   fprintf(fp,"%s\n",l_str);
/*****
   if (strcmp(rl_customer_id.arr, "AMRI") != 0) 
   {
		if(last_page == 0)
			sprintf(l_str,"%-34.34s--%-9.9s--"," ",local_legend[24]); //added for globalisation
		else
			sprintf(l_str,"%-43.43s --%-3.3s--"," ",local_legend[25]);// added for globalisation

		fprintf(fp,"%s\f",l_str);    
	}
	else
	{
		fprintf(fp,"%-11.11s %-30.30s", local_legend[90], first_user.arr); 		

		bal = 66 - (11 + 1 + 30);

		fprintf(fp,"%-*sPage(s):%3d\n", bal," ",pctr);

		fprintf(fp,"\f");    
	}

   fprintf(fp,"%cE",ESC); // added on 21.10.2004 to reset the printer settings.
************/
   lctr = 0; 
  
}

/*-----------------------------------------------------*/
/*------------------------------------------------------------*/
get_print_name(prn_user_id)
char prn_user_id[];
{
	
	strcpy(p_user_id.arr, prn_user_id);
	p_user_id.len = strlen(p_user_id.arr);

	print_name_yn.arr[0]		= '\0';
	print_name_yn.len			= 0;

	/* EXEC SQL SELECT NVL(name_on_report_yn, 'Y')
			 INTO :print_name_yn
			 FROM RL_USER_DEPT
			 WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND user_id = :p_user_id
			 AND section_code = :rl_hdr_section_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(name_on_report_yn,'Y') into :b0  from RL_USER_DEP\
T where ((OPERATING_FACILITY_ID=:b1 and user_id=:b2) and section_code=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5737;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&print_name_yn;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_user_id;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rl_hdr_section_code;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	print_name_yn.arr[print_name_yn.len]	= '\0';

}
/*------------------------------------------------------------*/
get_user_name(char *y_user)
{
	
	strcpy(sy_user.arr, y_user);
	sy_user.len = strlen(sy_user.arr); 
	
	sy_user_name.arr[0]		= '\0';
	sy_user_name.len			= 0;

	sy_func_role_id.arr[0]  = '\0';
	sy_func_role_id.len     = 0;
	
	if (strcmp(BVNewVersionYN.arr,"Y") == 0)
	{
		/* EXEC SQL SELECT username,func_role_id 
				 INTO :sy_user_name,:sy_func_role_id
				 FROM SY_USER
				 WHERE FACILITY_ID = :nd_operating_facility_id
				   AND user_id = :sy_user; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select username ,func_role_id into :b0,:b1  from SY_USER wh\
ere (FACILITY_ID=:b2 and user_id=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5768;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&sy_user_name;
  sqlstm.sqhstl[0] = (unsigned int  )62;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&sy_func_role_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&sy_user;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     }
	 else
	 {
		/* EXEC SQL SELECT username
				 INTO :sy_user_name
				 FROM SY_USER
				 WHERE FACILITY_ID = :nd_operating_facility_id
				   AND user_id = :sy_user; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select username into :b0  from SY_USER where (FACILITY_ID=:\
b1 and user_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5799;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&sy_user_name;
  sqlstm.sqhstl[0] = (unsigned int  )62;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&sy_user;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	 }

	sy_user_name.arr[sy_user_name.len]		= '\0';
	sy_func_role_id.arr[sy_func_role_id.len] = '\0';

	if (NODATAFOUND);
	if (OERROR);

}
/*------------------------------------------------------------*/
get_position_desc(char *fuserid)
{
	strcpy(sy_user.arr, fuserid);
	sy_user.len  = strlen(sy_user.arr);

	nd_position_desc.arr[0]		= '\0';
	nd_position_desc.len		= 0;
    
	/* EXEC SQL SELECT b.position_desc position_desc
			INTO :nd_position_desc
			FROM  AM_PRACTITIONER A,AM_POSITION B
			WHERE a.practitioner_id  = :sy_user
			AND   a.position_code = b.position_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select b.position_desc position_desc into :b0  from AM_PRACT\
ITIONER A ,AM_POSITION B where (a.practitioner_id=:b1 and a.position_code=b.po\
sition_code)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5826;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_position_desc;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sy_user;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR);

	if (NODATAFOUND);

	nd_position_desc.arr[nd_position_desc.len]	= '\0';

}
/*------------------------------------------------------------*/



