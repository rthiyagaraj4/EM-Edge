
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
    "Y:\\trunk\\eHIS2Tier\\RL\\Rlrsenq2.pc"
};


static unsigned long sqlctx = 1193582917;


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
            void  *sqhstv[29];
   unsigned int   sqhstl[29];
            int   sqhsts[29];
            void  *sqindv[29];
            int   sqinds[29];
   unsigned int   sqharm[29];
   unsigned int   *sqharc[29];
   unsigned short  sqadto[29];
   unsigned short  sqtdso[29];
} sqlstm = {10,29};

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

 static const char *sq0011 = 
"select SOURCE_CODE ,CONSULTANT_CODE ,TO_CHAR(SPEC_RECD_DATE_TIME,'DD/MM/YYYY\
 HH24:MI') ,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SPEC_CO\
LLTD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') ,S\
ECTION_CODE ,REQUEST_COMMENT_CODE1 ,REQUEST_COMMENT_CODE2 ,REQUEST_COMMENT_COD\
E3 ,REQUEST_COMMENT_DESC1 ,REQUEST_COMMENT_DESC2 ,REQUEST_COMMENT_DESC3 ,EXTRA\
_COPIES_TO ,SPECIMEN_TYPE_CODE ,ADDED_BY_ID ,TO_CHAR(ADDED_DATE,'DD/MM/YYYY HH\
24:MI') ,MODIFIED_BY_ID ,TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI') ,URGENT_I\
NDICATOR ,EPISODE_TYPE ,SOURCE_TYPE ,RELEASED_BY_ID ,TO_CHAR(RELEASED_DATE,'DD\
/MM/YYYY HH24:MI') ,category_code ,category_year ,category_number ,TO_CHAR(SPE\
C_REGD_DATE_TIME,'DD/MM/YYYY') ,ORDERED_FACILITY_ID  from RL_REQUEST_HEADER wh\
ere ((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_ID=:b2) for u\
pdate of STATUS nowait ";

 static const char *sq0012 = 
"select TEST_CODE ,NVL(RESULT_STATUS,'O') ,DECODE(GROUP_TEST_YN,'Y','G','I') \
 from RL_REQUEST_DETAIL where ((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERAT\
ING_FACILITY_ID=:b2)           ";

 static const char *sq0016 = 
"select SNOMED_CODE ,snomed_code_2  from RL_RESULT_SNOMED where (((PATIENT_ID\
=:b0 and SPECIMEN_NO=:b1) and GROUP_TEST_CODE=:b2) and TEST_CODE=:b3) order by\
 SNOMED_CODE            ";

 static const char *sq0017 = 
"select ORGANISM_CODE ,RESULT_COMMENT_DESC  from RL_RESULT_ORGANISM where (((\
((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_ID=:b2) and GROUP\
_TEST_CODE=:b3) and TEST_CODE=:b4) and NVL(hide_organism_yn,'N')<>'Y') order b\
y ORGANISM_CODE            ";

 static const char *sq0018 = 
"select distinct ANTIBIOTIC_CODE  from RL_RESULT_ORGANISM_DTL where ((((((PAT\
IENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY_ID=:b2) and GROUP_TEST\
_CODE=:b3) and TEST_CODE=:b4) and REPORT_YN='Y') and SENSITIVITY_IND in ('S','\
R','I')) order by ANTIBIOTIC_CODE            ";

 static const char *sq0019 = 
"select ORGANISM_CODE ,ANTIBIOTIC_CODE ,SENSITIVITY_IND  from RL_RESULT_ORGAN\
ISM_DTL where ((((((PATIENT_ID=:b0 and SPECIMEN_NO=:b1) and OPERATING_FACILITY\
_ID=:b2) and GROUP_TEST_CODE=:b3) and TEST_CODE=:b4) and REPORT_YN='Y') and SE\
NSITIVITY_IND in ('S','R','I')) order by ANTIBIOTIC_CODE,ORGANISM_CODE        \
    ";

 static const char *sq0024 = 
"select TITLE_CODE ,SHORT_NAME ,SEX ,NATIONALITY_CODE ,ROUND((TRUNC(TO_DATE(:\
b0,'DD/MM/YYYY HH24:MI'))-DATE_OF_BIRTH)) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY')\
 ,NVL(actual_dob_yn,'N') ,race_code ,ROUND(((TRUNC(TO_DATE(:b0,'DD/MM/YYYY HH2\
4:MI'))-DATE_OF_BIRTH)/365))  from MP_PATIENT_MAST where PATIENT_ID=:b2       \
    ";

 static const char *sq0025 = 
"select TITLE_CODE ,SHORT_NAME ,SEX ,NATIONALITY_CODE ,ROUND((TRUNC(TO_DATE(:\
b0,'DD/MM/YYYY HH24:MI'))-DATE_OF_BIRTH)) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY')\
 ,SUBSTR(NVL(ACTUAL_PATIENT_ID,'NULL'),1,10) ,NVL(actual_dob_yn,'N') ,race_cod\
e ,ROUND(((TRUNC(TO_DATE(:b0,'DD/MM/YYYY HH24:MI'))-DATE_OF_BIRTH)/365)) ,loca\
tion  from RL_PATIENT_MAST where PATIENT_ID=:b2           ";

 static const char *sq0013 = 
"select COMMENT_TEXT  from RL_COMMENTS_FOR_TEST where TEST_CODE=:b0 order by \
SEQ_NO            ";

 static const char *sq0014 = 
"select RESULT_TEXT  from RL_RESULT_TEXT where (((((PATIENT_ID=:b0 and SPECIM\
EN_NO=:b1) and OPERATING_FACILITY_ID=:b2) and GROUP_TEST_CODE=:b3) and TEST_CO\
DE=:b4) and NVL(hide_text_yn,'N')<>'Y') order by SERIAL_NO            ";

 static const char *sq0015 = 
"select OPERAND_1 ,OPERAND_1_TYPE ,OPERATOR_1 ,OPERAND_2 ,OPERAND_2_TYPE ,OPE\
RATOR_2  from RL_FUNCTION where TEST_CODE=:b0 order by SEQ_NUMBER            ";

 static const char *sq0055 = 
"select distinct TO_CHAR(A.interval_test_specimen_no)  from RL_INTERVAL_TEST_\
SPECIMENS A where (((A.specimen_no=TO_NUMBER(:b0) and OPERATING_FACILITY_ID=:b\
1) and NVL(A.cancelled_yn,'N')<>'Y') and NVL(A.status,'O') in ('R',:b2))      \
     ";

 static const char *sq0058 = 
"select test_code  from RL_REQUEST_DETAIL where (((specimen_no=TO_NUMBER(:b0)\
 and OPERATING_FACILITY_ID=:b1) and NVL(cancelled_yn,'N')<>'Y') and NVL(result\
_status,'O') in ('R',:b2))           ";

 static const char *sq0061 = 
"select TO_CHAR(A.specimen_no) ,A.group_test_code ,A.test_code ,A.seq_no  fro\
m RL_INTERVAL_TEST_SPECIMENS A where ((A.interval_test_specimen_no=TO_NUMBER(:\
b0) and OPERATING_FACILITY_ID=:b1) and NVL(A.cancelled_yn,'N')<>'Y') order by \
A.specimen_no            ";

 static const char *sq0067 = 
"select TO_CHAR(A.interval_test_specimen_no)  from RL_INTERVAL_TEST_SPECIMENS\
 A where (((A.specimen_no=TO_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1) and NV\
L(A.cancelled_yn,'N')<>'Y') and NVL(A.status,'O') in ('R',:b2)) order by A.spe\
cimen_no            ";

 static const char *sq0069 = 
"select specimen_no ,clinical_text_code ,SUBSTR(clinical_text,1,4000)  from R\
L_PATIENT_CLINICAL_TEXT where (specimen_no in (select distinct specimen_no  fr\
om RL_INTERVAL_TEST_TEMP where ((OPERATING_FACILITY_ID=:b0 and user_id='RLRRSE\
NQ') and session_id=1)) and OPERATING_FACILITY_ID=:b0) order by specimen_no   \
         ";

 static const char *sq0071 = 
"select distinct specimen_no  from RL_INTERVAL_TEST_TEMP where ((OPERATING_FA\
CILITY_ID=:b0 and user_id='RLRRSENQ') and session_id=1)           ";

 static const char *sq0073 = 
"select test_code ,cancel_code  from RL_REQUEST_DETAIL where ((specimen_no=TO\
_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1) and NVL(cancelled_yn,'N')='Y')    \
       ";

 static const char *sq0074 = 
"select TO_CHAR(specimen_no) ,group_test_code ,test_code  from RL_INTERVAL_TE\
ST_TEMP where ((OPERATING_FACILITY_ID=:b0 and user_id='RLRRSENQ') and session_\
id=2)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,445,0,0,0,0,0,1,0,
20,0,0,2,74,0,4,458,0,0,1,0,0,1,0,2,3,0,0,
39,0,0,3,248,0,4,492,0,0,7,0,0,1,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,
82,0,0,4,65,0,4,523,0,0,1,0,0,1,0,2,9,0,0,
101,0,0,5,0,0,29,697,0,0,0,0,0,1,0,
116,0,0,6,161,0,4,728,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,1,
9,0,0,
155,0,0,7,0,0,27,937,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
186,0,0,8,75,0,4,947,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
209,0,0,9,305,0,4,978,0,0,10,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
264,0,0,10,136,0,4,1017,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
299,0,0,11,0,0,15,1194,0,0,0,0,0,1,0,
314,0,0,11,879,0,9,1203,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
341,0,0,11,0,0,13,1282,0,0,29,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
472,0,0,12,185,0,9,1360,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
499,0,0,12,0,0,13,1376,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
526,0,0,20,0,0,17,1437,0,0,1,1,0,1,0,1,9,0,0,
545,0,0,20,0,0,45,1449,0,0,1,1,0,1,0,1,9,0,0,
564,0,0,20,0,0,13,1502,0,0,20,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
659,0,0,21,95,0,5,1563,0,0,1,1,0,1,0,1,9,0,0,
678,0,0,16,178,0,9,2197,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
709,0,0,16,0,0,13,2215,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
732,0,0,17,259,0,9,2372,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
767,0,0,18,277,0,9,2380,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
802,0,0,18,0,0,13,2391,0,0,1,0,0,1,0,2,9,0,0,
821,0,0,17,0,0,13,2408,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
844,0,0,22,72,0,4,2430,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
867,0,0,23,89,0,4,2453,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
890,0,0,19,314,0,9,2467,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
925,0,0,19,0,0,13,2492,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
952,0,0,24,314,0,9,2614,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
979,0,0,24,0,0,13,2619,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1030,0,0,25,368,0,9,2640,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1057,0,0,25,0,0,13,2641,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1116,0,0,25,368,0,9,2666,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1143,0,0,25,0,0,13,2667,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1202,0,0,26,86,0,4,2716,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1225,0,0,27,458,0,4,2774,0,0,18,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1312,0,0,28,90,0,4,2846,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1343,0,0,29,85,0,4,2854,0,0,3,1,0,1,0,2,9,0,0,2,3,0,0,1,9,0,0,
1370,0,0,30,94,0,4,2863,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1401,0,0,31,103,0,4,2883,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1432,0,0,32,74,0,4,2891,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1455,0,0,33,103,0,4,2898,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1486,0,0,34,83,0,4,2924,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1509,0,0,35,235,0,4,2950,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1544,0,0,13,94,0,9,2972,0,0,1,1,0,1,0,1,9,0,0,
1563,0,0,13,0,0,13,2987,0,0,1,0,0,1,0,2,9,0,0,
1582,0,0,36,108,0,4,3054,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
1609,0,0,14,224,0,9,3331,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1644,0,0,14,0,0,13,3346,0,0,1,0,0,1,0,2,9,0,0,
1663,0,0,15,153,0,9,3431,0,0,1,1,0,1,0,1,9,0,0,
1682,0,0,15,0,0,13,3454,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
1721,0,0,37,0,0,17,3480,0,0,1,1,0,1,0,1,9,0,0,
1740,0,0,37,0,0,45,3486,0,0,0,0,0,1,0,
1755,0,0,37,0,0,13,3493,0,0,1,0,0,1,0,2,9,0,0,
1774,0,0,38,146,0,4,3518,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1809,0,0,39,42,0,4,3667,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1832,0,0,40,49,0,4,3670,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
1859,0,0,41,59,0,4,3676,0,0,4,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,2,9,0,0,
1890,0,0,42,43,0,4,3699,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
1913,0,0,43,29,0,4,3702,0,0,1,0,0,1,0,2,3,0,0,
1932,0,0,44,55,0,4,3706,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
1955,0,0,45,53,0,4,3710,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1982,0,0,46,31,0,4,3734,0,0,1,0,0,1,0,2,9,0,0,
2001,0,0,47,137,0,4,3760,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2028,0,0,48,193,0,5,3771,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
2055,0,0,49,0,0,17,3788,0,0,1,1,0,1,0,1,9,0,0,
2074,0,0,49,0,0,45,3790,0,0,1,1,0,1,0,1,9,0,0,
2093,0,0,49,0,0,13,3800,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
2116,0,0,50,160,0,4,3805,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2147,0,0,51,220,0,5,3817,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2178,0,0,11,0,0,15,3840,0,0,0,0,0,1,0,
2193,0,0,12,0,0,15,3841,0,0,0,0,0,1,0,
2208,0,0,20,0,0,15,3842,0,0,0,0,0,1,0,
2223,0,0,19,0,0,15,3843,0,0,0,0,0,1,0,
2238,0,0,52,168,0,3,3858,0,0,5,5,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2273,0,0,53,68,0,4,4052,0,0,1,0,0,1,0,2,9,0,0,
2292,0,0,54,76,0,4,4076,0,0,4,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,2,3,0,0,
2323,0,0,55,237,0,9,4137,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
2350,0,0,56,210,0,4,4142,0,0,3,2,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,
2377,0,0,57,174,0,3,4163,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
2412,0,0,58,191,0,9,4187,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
2439,0,0,59,182,0,4,4191,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2470,0,0,60,149,0,3,4203,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
2497,0,0,61,257,0,9,4234,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2520,0,0,61,0,0,13,4249,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
2551,0,0,55,0,0,13,4271,0,0,1,0,0,1,0,2,9,0,0,
2570,0,0,58,0,0,13,4290,0,0,1,0,0,1,0,2,9,0,0,
2589,0,0,55,0,0,15,4306,0,0,0,0,0,1,0,
2604,0,0,61,0,0,15,4312,0,0,0,0,0,1,0,
2619,0,0,58,0,0,15,4317,0,0,0,0,0,1,0,
2634,0,0,62,176,0,4,4322,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2665,0,0,63,167,0,5,4332,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
2692,0,0,64,111,0,2,4344,0,0,1,1,0,1,0,1,9,0,0,
2711,0,0,65,111,0,2,4349,0,0,1,1,0,1,0,1,9,0,0,
2730,0,0,66,92,0,4,4362,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,3,0,0,
2757,0,0,67,252,0,9,4384,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
2784,0,0,67,0,0,15,4388,0,0,0,0,0,1,0,
2799,0,0,67,0,0,13,4398,0,0,1,0,0,1,0,2,9,0,0,
2818,0,0,13,0,0,15,4416,0,0,0,0,0,1,0,
2833,0,0,14,0,0,15,4425,0,0,0,0,0,1,0,
2848,0,0,15,0,0,15,4434,0,0,0,0,0,1,0,
2863,0,0,16,0,0,15,4444,0,0,0,0,0,1,0,
2878,0,0,17,0,0,15,4454,0,0,0,0,0,1,0,
2893,0,0,18,0,0,15,4463,0,0,0,0,0,1,0,
2908,0,0,37,0,0,15,4472,0,0,0,0,0,1,0,
2923,0,0,24,0,0,15,4482,0,0,0,0,0,1,0,
2938,0,0,25,0,0,15,4493,0,0,0,0,0,1,0,
2953,0,0,49,0,0,15,4503,0,0,0,0,0,1,0,
2968,0,0,68,60,0,4,4532,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2991,0,0,69,319,0,9,4565,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3014,0,0,69,0,0,15,4615,0,0,0,0,0,1,0,
3029,0,0,69,0,0,13,4631,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
3056,0,0,70,81,0,4,4649,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3079,0,0,71,142,0,9,5106,0,0,1,1,0,1,0,1,9,0,0,
3098,0,0,72,163,0,3,5118,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3129,0,0,71,0,0,13,5138,0,0,1,0,0,1,0,2,9,0,0,
3148,0,0,71,0,0,15,5153,0,0,0,0,0,1,0,
3163,0,0,73,161,0,9,5166,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3186,0,0,73,0,0,15,5172,0,0,0,0,0,1,0,
3201,0,0,73,0,0,13,5183,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
3224,0,0,74,170,0,9,5211,0,0,1,1,0,1,0,1,9,0,0,
3243,0,0,74,0,0,13,5267,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
3270,0,0,75,74,0,4,5288,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3293,0,0,74,0,0,15,5302,0,0,0,0,0,1,0,
3308,0,0,76,134,0,4,5315,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3339,0,0,77,108,0,4,5343,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
3366,0,0,78,130,0,4,5387,0,0,8,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2,9,0,0,2,3,0,0,2,3,0,0,
3413,0,0,79,57,0,4,5484,0,0,1,0,0,1,0,2,9,0,0,
3432,0,0,80,100,0,4,5487,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,4,0,0,
3459,0,0,81,99,0,4,5515,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
3486,0,0,82,64,0,4,5542,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3509,0,0,83,78,0,4,5565,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
3536,0,0,84,105,0,4,5584,0,0,1,0,0,1,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.6                                                  */
/************************************************************************/
/* PROGRAM NAME          : RLRRSENQ                                     */
/* DESCRIPTION		     : Test Results report 							*/
/* AUTHOR                : S. Sheelvant                                 */
/* DATE WRITTEN          : 11-SEP-1998                                  */
/* MODIFIED BY           : S.SHEELVANT 									*/
/* MODIFIED ON			 : 12-DEC-1998	                                */
/* Last Modified by      : HAMEED 	                                    */
/*                       : 01.06.2003	                                */
/* Last Modified by      : SHRUTI(ORDERED_FACILITY_ID) 	                                    */
/*                       : 04.09.2003	                                */
/************************************************************************/

#include <stdio.h>
#include <string.h>
#include "gl.h"
#include "rl.h"
#define NODATAFOUND				(sqlca.sqlcode == 1403)
#define OERROR 					(sqlca.sqlcode < 0)
#define LAST_ROW 				(sqlca.sqlcode == 1403)
#define NOT_FOUND 				(sqlca.sqlerrd[2] == 0)
#define TABLE_ALREADY_EXISTS	(sqlca.sqlcode == -955)
#define RESOURCE_BUSY			(sqlca.sqlcode == -54)

#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define RESTART_INTERVAL 2
#define RESTART_TIME 500
#define INIT_MESG ""

#define SPOOL_DIR			""	
#define ESC 0x1B
#define SEP 0xFA   

#define MAX_ORGANISMS	10

/* EXEC SQL BEGIN DECLARE SECTION; */ 


#define MAX_ANTIBIOTICS	250


   /* VARCHAR nd_operating_facility_id      [3],
           uid_pwd                       [132],
           d_curr_pgm_name               [15],
           nd_file_name                  [151],
		   today			             [20],
           nd_file_no                    [15]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[20]; } today;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;


   /* VARCHAR s_org							[MAX_ANTIBIOTICS][5],
           s_ant							[MAX_ANTIBIOTICS][5],
           s_ind							[MAX_ANTIBIOTICS][2]; */ 
struct { unsigned short len; unsigned char arr[6]; } s_org[250];

struct { unsigned short len; unsigned char arr[6]; } s_ant[250];

struct { unsigned short len; unsigned char arr[2]; } s_ind[250];


   /* VARCHAR nd_hosp_no                       [21],	 /o Patient ID o/
           nd_spec_no                       [21],
           nd_cntrl_rowid                   [31],

		   nd_rowid							[31],

		   nd_result_printed_date			[21],
	       er_msg                           [71],
   
             c_req_dtl_test_code              [11],/o Used in o/ 
             c_group_test_yn                  [2],/o Update_rl_request_detailo/
             c_count                          [3],/o-----o/
             c_spec_no                        [21],

             p_print_name_yn                  [2],
             p_test_desc                      [41],
             p_function_yn                    [2], 

             rl_lab_title                     [101],
			 rl_lab_title_2					  [201],
			 rl_lab_title_3					  [201],
			 rl_lab_title_4					  [201],
			 rl_lab_title_5					  [201],
			 rl_actual_dob_yn				  [2], 
			 rl_race_code					  [5],
			 rl_report_format				  [3],
			 rl_age_years					  [3], 
			 rl_location					  [21], 
			 d_race_desc					  [31], 
			 d_clinical_text_code			  [5],
			 d_clinical_text				  [4000],
			 d_clinical_spec_no				  [21], 
			 rl_test_requested_yn			  [2],
			 d_inhibit_yn					  [2],
			 inhibit_test_code				  [11], 
			 rl_message_line				  [500],
			 rl_name_on_report_yn			  [2],
			 rl_footer_line_1				  [500],
			 rl_footer_line_2				  [500],
			 rl_category_code				  [5],
			 rl_category_year				  [5],
			 rl_category_number				  [21], 
			 v_test_code					  [11],
			 rl_high_low_ind			      [10],
			 rl_cancelled_yn				  [2],
			 can_spec_no					  [21],
			 can_group_test					  [11],
			 can_test_name					  [41], 
			 can_test_code				      [11],
			 cancel_reason					  [41],
			 print_name_yn					  [2],
			 first_user						  [21],
			 rl_released_by_id				  [21],
			 p_user_id						  [31],
			 rl_released_date				  [17],
			 v_numeric_result				  [21],
			 sy_user						  [30],
			 sy_user_name					  [50],
			 rl_ordered_facility_id			  [3],
             or_order_date_time             [17],

			rl_print_result_sect_yn			[2],
			rl_section_tel_num				[16],

           rl_hdr_source_code               [11],
           rl_hdr_consultant_code           [16],
           rl_hdr_spec_recd_date_time       [17],
           rl_hdr_spec_regd_date_time       [17],
  	       rl_hdr_spec_colltd_date_time     [17],
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
 	       rl_hdr_episode_type		    [2],
 	       rl_hdr_urgent_indicator	    [2],
		   rl_hdr_source_type		    [2],
		   rl_hdr_released_by_id		[31],
		   rl_hdr_released_date			[21],

           rl_dtl_test_code_reqd	    [11],
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
           rl_tst_rowid                     [31],
		   rl_tst_hide_rslt_comm_yn			[2],

           rl_loc_test_code                 [11],
           rl_loc_long_desc                 [41],

	       rl_pat_title                     [9],
           rl_pat_long_name                 [61],
           rl_pat_short_name                [61],
           rl_pat_sex                       [2],
           rl_pat_nationality               [4],
           rl_pat_dob_no_of_days            [10],
           rl_pat_date_of_birth             [16],
	       rl_pat_actual_id                 [21],
           rl_pat_blood_group               [3],
           rl_pat_g6pd                      [11],
           rl_pat_sicc                      [11],
           rl_pat_hbl4_1                    [11],
           rl_pat_hbl4_2                    [11],

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
		   rl_tst_cd_test_units_2           [11],
           rl_tst_cd_range_cmt              [41],
		   rl_tst_cd_range_cmt_2            [41],
		   rl_tst_cd_inh_rep_yn				[2],
		   rl_tst_cd_conf_yn				[2],

		   rl_tst_ran_low_val_nor    [16],
           rl_tst_ran_high_val_nor   [16],
		
		   l_low_val				 [16],
		   l_high_val				 [16],
           rl_tst_rng_lvn    [16],
           rl_tst_rng_hvn   [16],

           rl_comm_tst_comm_txt    [41],

           rl_res_result_text				[2000],

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

           rl_res_organism_code_desc        [41],

		   d_user_id_pwd					[50],

		   rl_res_dtl_organism_code			[5],
           rl_res_dtl_antibiotic_code       [5],
           rl_res_dtl_antibiotic_desc       [41],
           rl_res_dtl_sensitivity_ind       [2],
	   
	       //sy_acc_entity_name 				[81],
		   sy_acc_entity_name 				[300],

           rl_res_snomed_code               [21],
		   rl_res_snomed_code2				[21],
           
		   rl_prn_ctrl_hdr_pat_no	    [16],
		   rl_prn_ctrl_hdr_sp_no	    [21],
	       rl_prn_ctrl_hdr_source_code	    [11],
	       rl_prn_ctrl_hdr_user		    [21],
	       rl_prn_ctrl_hdr_section_code	    [2],
           rl_prn_ctrl_hdr_rp_yn         [2],

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


  	       d_loc_str 			    [20], 
  	       d_l_str 					[20], 
  	       d_dec_part			    [20],
  	       d_int_part			    [20],
  	       d_sig_part			    [20],

		   a_antibiotic_code		[5],

		   d_sleep_secs		[10],
		   d_machine_name   [40],
		   d_started_by_id  [20],
		   
		   sy_user_id			[31],
           sy_session_id		[30],
           sy_req_date			[30],
		   sy_machine_name      [16],
           sy_ws_no             [15],
		   sy_rowid				[31],
           
		   p_uid_pwd            [151], 
		   p_print_name         [100], 
		   p_loc_type           [10],
           p_loc_code           [100],
		   p_rep_file           [151],
		   p_print_mode         [10],
		   
		   p_param7				[2],
		   prg_start_date		[30],
		   d_next_start_date      [30],
		   d_cmd_line           [200],
		   l_print_disch_pat_result     [2],
		   rl_printer_for_urgent_yn		[2],
		   rl_print_inpatient_yn		[2],
		   rl_print_outpatient_yn		[2],
		   rl_print_referral_yn			[2],
		   rl_print_external_yn			[2],
		   nd_status					[2],
		   d_specimen_no				[21],
		   d_group_test_code			[11],
		   d_test_code					[11],
		   d_no							[21],
		   p_param8						[2],
		   actual_specimen				[21],
		   interval_description			[41],
		   first_specimen_no			[21],
		   sql_stmt						[2000],
		   nd_trx_ind					[2]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd_hosp_no;

struct { unsigned short len; unsigned char arr[21]; } nd_spec_no;

struct { unsigned short len; unsigned char arr[31]; } nd_cntrl_rowid;

struct { unsigned short len; unsigned char arr[31]; } nd_rowid;

struct { unsigned short len; unsigned char arr[21]; } nd_result_printed_date;

struct { unsigned short len; unsigned char arr[71]; } er_msg;

struct { unsigned short len; unsigned char arr[11]; } c_req_dtl_test_code;

struct { unsigned short len; unsigned char arr[2]; } c_group_test_yn;

struct { unsigned short len; unsigned char arr[3]; } c_count;

struct { unsigned short len; unsigned char arr[21]; } c_spec_no;

struct { unsigned short len; unsigned char arr[2]; } p_print_name_yn;

struct { unsigned short len; unsigned char arr[41]; } p_test_desc;

struct { unsigned short len; unsigned char arr[2]; } p_function_yn;

struct { unsigned short len; unsigned char arr[101]; } rl_lab_title;

struct { unsigned short len; unsigned char arr[201]; } rl_lab_title_2;

struct { unsigned short len; unsigned char arr[201]; } rl_lab_title_3;

struct { unsigned short len; unsigned char arr[201]; } rl_lab_title_4;

struct { unsigned short len; unsigned char arr[201]; } rl_lab_title_5;

struct { unsigned short len; unsigned char arr[2]; } rl_actual_dob_yn;

struct { unsigned short len; unsigned char arr[5]; } rl_race_code;

struct { unsigned short len; unsigned char arr[3]; } rl_report_format;

struct { unsigned short len; unsigned char arr[3]; } rl_age_years;

struct { unsigned short len; unsigned char arr[21]; } rl_location;

struct { unsigned short len; unsigned char arr[31]; } d_race_desc;

struct { unsigned short len; unsigned char arr[5]; } d_clinical_text_code;

struct { unsigned short len; unsigned char arr[4000]; } d_clinical_text;

struct { unsigned short len; unsigned char arr[21]; } d_clinical_spec_no;

struct { unsigned short len; unsigned char arr[2]; } rl_test_requested_yn;

struct { unsigned short len; unsigned char arr[2]; } d_inhibit_yn;

struct { unsigned short len; unsigned char arr[11]; } inhibit_test_code;

struct { unsigned short len; unsigned char arr[500]; } rl_message_line;

struct { unsigned short len; unsigned char arr[2]; } rl_name_on_report_yn;

struct { unsigned short len; unsigned char arr[500]; } rl_footer_line_1;

struct { unsigned short len; unsigned char arr[500]; } rl_footer_line_2;

struct { unsigned short len; unsigned char arr[5]; } rl_category_code;

struct { unsigned short len; unsigned char arr[5]; } rl_category_year;

struct { unsigned short len; unsigned char arr[21]; } rl_category_number;

struct { unsigned short len; unsigned char arr[11]; } v_test_code;

struct { unsigned short len; unsigned char arr[10]; } rl_high_low_ind;

struct { unsigned short len; unsigned char arr[2]; } rl_cancelled_yn;

struct { unsigned short len; unsigned char arr[21]; } can_spec_no;

struct { unsigned short len; unsigned char arr[11]; } can_group_test;

struct { unsigned short len; unsigned char arr[41]; } can_test_name;

struct { unsigned short len; unsigned char arr[11]; } can_test_code;

struct { unsigned short len; unsigned char arr[41]; } cancel_reason;

struct { unsigned short len; unsigned char arr[2]; } print_name_yn;

struct { unsigned short len; unsigned char arr[21]; } first_user;

struct { unsigned short len; unsigned char arr[21]; } rl_released_by_id;

struct { unsigned short len; unsigned char arr[31]; } p_user_id;

struct { unsigned short len; unsigned char arr[17]; } rl_released_date;

struct { unsigned short len; unsigned char arr[21]; } v_numeric_result;

struct { unsigned short len; unsigned char arr[30]; } sy_user;

struct { unsigned short len; unsigned char arr[50]; } sy_user_name;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[17]; } or_order_date_time;

struct { unsigned short len; unsigned char arr[2]; } rl_print_result_sect_yn;

struct { unsigned short len; unsigned char arr[16]; } rl_section_tel_num;

struct { unsigned short len; unsigned char arr[11]; } rl_hdr_source_code;

struct { unsigned short len; unsigned char arr[16]; } rl_hdr_consultant_code;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_recd_date_time;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[17]; } rl_hdr_spec_colltd_date_time;

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

struct { unsigned short len; unsigned char arr[2]; } rl_hdr_source_type;

struct { unsigned short len; unsigned char arr[31]; } rl_hdr_released_by_id;

struct { unsigned short len; unsigned char arr[21]; } rl_hdr_released_date;

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

struct { unsigned short len; unsigned char arr[31]; } rl_tst_rowid;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_hide_rslt_comm_yn;

struct { unsigned short len; unsigned char arr[11]; } rl_loc_test_code;

struct { unsigned short len; unsigned char arr[41]; } rl_loc_long_desc;

struct { unsigned short len; unsigned char arr[9]; } rl_pat_title;

struct { unsigned short len; unsigned char arr[61]; } rl_pat_long_name;

struct { unsigned short len; unsigned char arr[61]; } rl_pat_short_name;

struct { unsigned short len; unsigned char arr[2]; } rl_pat_sex;

struct { unsigned short len; unsigned char arr[4]; } rl_pat_nationality;

struct { unsigned short len; unsigned char arr[10]; } rl_pat_dob_no_of_days;

struct { unsigned short len; unsigned char arr[16]; } rl_pat_date_of_birth;

struct { unsigned short len; unsigned char arr[21]; } rl_pat_actual_id;

struct { unsigned short len; unsigned char arr[3]; } rl_pat_blood_group;

struct { unsigned short len; unsigned char arr[11]; } rl_pat_g6pd;

struct { unsigned short len; unsigned char arr[11]; } rl_pat_sicc;

struct { unsigned short len; unsigned char arr[11]; } rl_pat_hbl4_1;

struct { unsigned short len; unsigned char arr[11]; } rl_pat_hbl4_2;

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

struct { unsigned short len; unsigned char arr[11]; } rl_tst_cd_test_units_2;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_cd_range_cmt;

struct { unsigned short len; unsigned char arr[41]; } rl_tst_cd_range_cmt_2;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_inh_rep_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_tst_cd_conf_yn;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_ran_low_val_nor;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_ran_high_val_nor;

struct { unsigned short len; unsigned char arr[16]; } l_low_val;

struct { unsigned short len; unsigned char arr[16]; } l_high_val;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_rng_lvn;

struct { unsigned short len; unsigned char arr[16]; } rl_tst_rng_hvn;

struct { unsigned short len; unsigned char arr[41]; } rl_comm_tst_comm_txt;

struct { unsigned short len; unsigned char arr[2000]; } rl_res_result_text;

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

struct { unsigned short len; unsigned char arr[41]; } rl_res_organism_code_desc;

struct { unsigned short len; unsigned char arr[50]; } d_user_id_pwd;

struct { unsigned short len; unsigned char arr[5]; } rl_res_dtl_organism_code;

struct { unsigned short len; unsigned char arr[5]; } rl_res_dtl_antibiotic_code;

struct { unsigned short len; unsigned char arr[41]; } rl_res_dtl_antibiotic_desc;

struct { unsigned short len; unsigned char arr[2]; } rl_res_dtl_sensitivity_ind;

struct { unsigned short len; unsigned char arr[300]; } sy_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } rl_res_snomed_code;

struct { unsigned short len; unsigned char arr[21]; } rl_res_snomed_code2;

struct { unsigned short len; unsigned char arr[16]; } rl_prn_ctrl_hdr_pat_no;

struct { unsigned short len; unsigned char arr[21]; } rl_prn_ctrl_hdr_sp_no;

struct { unsigned short len; unsigned char arr[11]; } rl_prn_ctrl_hdr_source_code;

struct { unsigned short len; unsigned char arr[21]; } rl_prn_ctrl_hdr_user;

struct { unsigned short len; unsigned char arr[2]; } rl_prn_ctrl_hdr_section_code;

struct { unsigned short len; unsigned char arr[2]; } rl_prn_ctrl_hdr_rp_yn;

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

struct { unsigned short len; unsigned char arr[20]; } d_loc_str;

struct { unsigned short len; unsigned char arr[20]; } d_l_str;

struct { unsigned short len; unsigned char arr[20]; } d_dec_part;

struct { unsigned short len; unsigned char arr[20]; } d_int_part;

struct { unsigned short len; unsigned char arr[20]; } d_sig_part;

struct { unsigned short len; unsigned char arr[5]; } a_antibiotic_code;

struct { unsigned short len; unsigned char arr[10]; } d_sleep_secs;

struct { unsigned short len; unsigned char arr[40]; } d_machine_name;

struct { unsigned short len; unsigned char arr[20]; } d_started_by_id;

struct { unsigned short len; unsigned char arr[31]; } sy_user_id;

struct { unsigned short len; unsigned char arr[30]; } sy_session_id;

struct { unsigned short len; unsigned char arr[30]; } sy_req_date;

struct { unsigned short len; unsigned char arr[16]; } sy_machine_name;

struct { unsigned short len; unsigned char arr[15]; } sy_ws_no;

struct { unsigned short len; unsigned char arr[31]; } sy_rowid;

struct { unsigned short len; unsigned char arr[151]; } p_uid_pwd;

struct { unsigned short len; unsigned char arr[100]; } p_print_name;

struct { unsigned short len; unsigned char arr[10]; } p_loc_type;

struct { unsigned short len; unsigned char arr[100]; } p_loc_code;

struct { unsigned short len; unsigned char arr[151]; } p_rep_file;

struct { unsigned short len; unsigned char arr[10]; } p_print_mode;

struct { unsigned short len; unsigned char arr[2]; } p_param7;

struct { unsigned short len; unsigned char arr[30]; } prg_start_date;

struct { unsigned short len; unsigned char arr[30]; } d_next_start_date;

struct { unsigned short len; unsigned char arr[200]; } d_cmd_line;

struct { unsigned short len; unsigned char arr[2]; } l_print_disch_pat_result;

struct { unsigned short len; unsigned char arr[2]; } rl_printer_for_urgent_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_inpatient_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_outpatient_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_referral_yn;

struct { unsigned short len; unsigned char arr[2]; } rl_print_external_yn;

struct { unsigned short len; unsigned char arr[2]; } nd_status;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } d_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[21]; } d_no;

struct { unsigned short len; unsigned char arr[2]; } p_param8;

struct { unsigned short len; unsigned char arr[21]; } actual_specimen;

struct { unsigned short len; unsigned char arr[41]; } interval_description;

struct { unsigned short len; unsigned char arr[21]; } first_specimen_no;

struct { unsigned short len; unsigned char arr[2000]; } sql_stmt;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;


	int i_count = 0, u_count = 0, l_seq_no = 0;

   int     no_of_dtl_recs = 0,
		   d_time_interval =0,
		   d_starting_time =0,
           rl_tst_cd_no_of_decimals = 0,
	       sy_ref_no_of_copies = 0,
           rl_tst_cd_significant_digit = 0, 
   	       p_significant_digit,
   	       p_no_of_decimals,  
           er_msg_type = 0,
  	       d_dec_pos = 0,
           d_after_sig_digit = 0;

   int     page_length = 0;

   int l_low = 0, l_high = 0;

   long l_episode = 0;

   int l_restart_time = 0;

   int d_seq_no = 0, rl_seq_no = 0;
   int l_exist_decimals = 0;
   int l_inst_decimals = 0;

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


	float mt;
   int l_count = 0;

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





#include<winproc.h>

FILE *fp;
int  status_prn   = 0, pgm_flg  = 0,tst_cd_ind = 1,  err_flag = 0;
int copy = 0;
int numeric_value_flag = FALSE;
int  MAX_LINES = 27;

char nd_repo_file_name[151], extra_file_name[151], lab_file_name[151];

char prev_group_test [11],
     rl_curr_status  [4];

int i = 0, rec_ctr = 0, lctr = 0, pctr = 0,
    spc_first = 0,    ind_test_prn   = 0,
    group_printed = 0, group = 0,
    test_printed = 0, test_result_found = 0,
    source_copies = 0, local_copies = 0;

DWORD sleep_sec = 0;

char text_line[100], test_description[41], nd_e_name[151], nd_f_name[151];

char *to_day();

int no_of_sensitivities = 0;
int something_to_print = 0;
int qq = 0, cntr = 0, z = 0, hell = 0, clt = 0, cmp = 0, t_rue = 0;

int last_page = 0;

char word1[2];
char string_var[100];

/****** ADDED FOR GTT SPECIMENS ************/
char l_should_print_yn = 'N';
char nd_test_code[11];
char d_interval_specimen_yn = 'N';

char l_numeric_result[30];

char footer_released_date[20];

int request_count = 0;

//char      g_facility_id[50];

void proc_main(argc,argv)
char *argv[];
int argc;
{
   int rec_found = 0;

   if (argc < 4)
   {
      disp_message(ERR_MESG,"Usage : rlrrsenq uid/password ");
      proc_exit();
   }

   strcpy(d_user_id_pwd.arr,argv[1]);
   d_user_id_pwd.len = strlen(d_user_id_pwd.arr);

   strcpy(nd_spec_no.arr,argv[2]);
   nd_spec_no.len = strlen(nd_spec_no.arr);

   strcpy(nd_hosp_no.arr,argv[3]);
   nd_hosp_no.len = strlen(nd_hosp_no.arr);

   strcpy(p_param7.arr,argv[4]);
   p_param7.len = strlen(p_param7.arr);

   strcpy(g_pgm_id,"RLRRSENQ");
   strcpy(d_curr_pgm_name.arr,g_pgm_id); 

   strcpy(nd_operating_facility_id.arr, argv[5]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

   //strcpy(g_facility_id,nd_operating_facility_id.arr);
   if(sql_connect(argv[1]) == -1)
   {
      ins_message(ORA_MESG,"Error in connecting to Oracle");
      proc_exit();
   }

   set_meduser_role();

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
     ins_message(ORA_MESG,"ROLLBACK WORK RELEASE failed");
   return;
}
/*----------------------------------------------------*/
get_restart_time()
{
    
	 l_restart_time = 0;

     /* EXEC SQL SELECT NVL(TO_NUMBER(TO_CHAR(1111, 'HH24MI')), 500)
     INTO :l_restart_time
	 FROM RL_PARAM; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 1;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(TO_NUMBER(TO_CHAR(1111,'HH24MI')),500) into :\
b0  from RL_PARAM ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )20;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&l_restart_time;
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


  
     if (OERROR)
        ins_message(ORA_MESG,"Error Found in RL_PARAM 2");

	  if(NOT_FOUND) 
         ins_message(ORA_MESG,"Select failed on RL_PARAM 2 --> No Data Found");


 }
/*------------------------------------------------------*/
 /*------------------------------------------------------*/
 get_len_from_param()
 {
    
     page_length = 0;

     l_print_disch_pat_result.arr[0]                = '\0';
	 rl_print_inpatient_yn.arr[0]					= '\0';
	 rl_print_outpatient_yn.arr[0]					= '\0';
	 rl_print_referral_yn.arr[0]					= '\0';
	 rl_print_external_yn.arr[0]					= '\0';
	 rl_report_format.arr[0]						= '\0';

     l_print_disch_pat_result.len                   = 0;
	 rl_print_inpatient_yn.len						= 0;
	 rl_print_outpatient_yn.len						= 0;
	 rl_print_referral_yn.len						= 0;
	 rl_print_external_yn.len						= 0;
	 rl_report_format.len							= 0;


     /* EXEC SQL SELECT result_rep_pg_len, NVL(print_disch_pat_result_yn, 'N'),
					NVL(print_inpatient_yn, 'N'), NVL(print_outpatient_yn, 'N'), 
					NVL(print_referral_yn, 'N'), NVL(print_external_yn, 'N'),
					NVL(report_format, '1')
			  INTO :page_length, :l_print_disch_pat_result,
				   :rl_print_inpatient_yn, :rl_print_outpatient_yn,
				   :rl_print_referral_yn, :rl_print_external_yn,
				   :rl_report_format
			  FROM RL_PARAM; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 7;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select result_rep_pg_len ,NVL(print_disch_pat_result_yn,\
'N') ,NVL(print_inpatient_yn,'N') ,NVL(print_outpatient_yn,'N') ,NVL(print_ref\
erral_yn,'N') ,NVL(print_external_yn,'N') ,NVL(report_format,'1') into :b0,:b1\
,:b2,:b3,:b4,:b5,:b6  from RL_PARAM ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )39;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&page_length;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&l_print_disch_pat_result;
     sqlstm.sqhstl[1] = (unsigned int  )4;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&rl_print_inpatient_yn;
     sqlstm.sqhstl[2] = (unsigned int  )4;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&rl_print_outpatient_yn;
     sqlstm.sqhstl[3] = (unsigned int  )4;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&rl_print_referral_yn;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&rl_print_external_yn;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&rl_report_format;
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


  
     if (OERROR)
        ins_message(ORA_MESG,"Error Found in RL_PARAM");

	  if(NOT_FOUND) 
         ins_message(ORA_MESG,"Select failed on RL_PARAM --> No Data Found");

	 l_print_disch_pat_result.arr[l_print_disch_pat_result.len]      = '\0';
	 rl_print_inpatient_yn.arr[rl_print_inpatient_yn.len]			 = '\0';
	 rl_print_outpatient_yn.arr[rl_print_outpatient_yn.len]			 = '\0';
	 rl_print_referral_yn.arr[rl_print_referral_yn.len]				 = '\0';
	 rl_print_external_yn.arr[rl_print_external_yn.len]				 = '\0';
	 rl_report_format.arr[rl_report_format.len]						 = '\0';

 }
/*----------------------------------------------------------*/
char *to_day()
{

today.arr[0]	= '\0';
today.len	= 0;

/* EXEC SQL SELECT 	to_char(SYSDATE,'DD/MM/YYYY HH24:MI')
	   INTO		:today
	   FROM		DUAL; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select to_char(SYSDATE,'DD/MM/YYYY HH24:MI') into :b0  from D\
UAL ";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )82;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&today;
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
     ins_message(ORA_MESG,"Select failed on DUAL in to_day() ");

today.arr[today.len]	= '\0';
return (today.arr);
}
/*----------------------------------------------------------*/
process_rec()
{  
   int i = 0;
   int j = 0,corr_stat = 0;
   int sy_prg_param_found =0;
   int record_exist = 0;
   char test[11],group_test[11];
   _flushall();

    request_count = 1;
 

          
          get_len_from_param();

		  if (strcmp(rl_report_format.arr, "1") == 0)
			  MAX_LINES = (page_length - 5) ; 
		  else
			  MAX_LINES = (page_length - 7) ; 

		  l_should_print_yn = 'N';
		  d_interval_specimen_yn = 'N';

			 err_flag = 0;
             lctr = 0;
             pctr = 0;
             rec_ctr = 0;
	         copy = 0;

			strcpy(actual_specimen.arr, nd_spec_no.arr);
		 	actual_specimen.len = strlen(actual_specimen.arr);

			strcpy(nd_status.arr, "P");
			nd_status.len = strlen(nd_status.arr);
			 
			 build_table();

			 build_cancelled_tests();

			 declare_tst_result_curs();
			 strcpy(nd_test_code, "");

  		     something_to_print = 0;  
		
		if (l_should_print_yn == 'Y')
		{

             open_hdr();
			 _flushall();

             while (fetch_hdr() && err_flag == 0)
             {   
				 _flushall();

				 gen_file_name();

			     get_departmental_parameters();
                 source_copies = 0;
                 local_copies = 0;
	             strcpy(c_spec_no.arr,nd_spec_no.arr);
                 c_spec_no.len = strlen(nd_spec_no.arr);
                 fetch_other_dtls();
                 fetch_dtl();
                 while(TRUE)
                 {
                     copy++;
					 open_tst_result_curs();

					 strcpy(prev_group_test,"");
                     rec_ctr = 0;
                     fflush(fp);

	                 i = fetch_tst_result();

	                 if(i)
					 {
                       
					   last_page = 0;
					   strcpy(first_user.arr, rl_released_by_id.arr);
					   first_user.len = strlen(first_user.arr);

					   strcpy(footer_released_date, rl_released_date.arr);

					 }

					   if (strcmp(rl_report_format.arr, "1") == 0)
							print_header();
					   else
							print_header1();

						
					   _flushall();

					 set_printed_date_time();

                     while (i && err_flag == 0)
                     {

	                     group_printed = 0;
	                     group = 0;
                         strcpy(group_test, rl_tst_group_test_code.arr);
                         strcpy(test,rl_tst_test_code.arr);
	                     if(strcmp(group_test,test) !=0)
  		                    group = 1;
                         while(i && strcmp(group_test,rl_tst_group_test_code.arr)==0 && err_flag == 0)
	                     {  

			 	             strcpy(c_spec_no.arr,nd_spec_no.arr);
			                 c_spec_no.len = strlen(c_spec_no.arr);

		                     test_printed = 0;
                             rec_ctr ++;

                             print_dtls();


                             update_tst_result();
 							 update_interval_specimen();
						     update_rl_request_detail();
							 update_rl_request_header();

                             i = fetch_tst_result();
                         }
                      }
                      
                      if (rec_ctr && err_flag == 0)
                      {
						   print_cancelled_tests();

                          for (i=lctr;i<=MAX_LINES;i++)
                               fprintf(fp,"\n");
                          last_page = 1;

						  if (strcmp(rl_report_format.arr, "1") == 0)
								print_footer(0);
						  else
								print_footer1(0);

                      }

                      break;

                   }
   	               fclose(fp); /* Close the Main File if no Extra File,
								   else the Extra File */
			       _flushall();

				   if (err_flag == 0)
				   {
						create_lab_file_name();

						print_job();
					}
				   _flushall();

                }
			 }

                close_all_cur(); 
			

				delete_build_table();

                /* EXEC SQL COMMIT WORK; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 7;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )101;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




			 record_exist = 0;

 			 request_count++;


		 _flushall();
		 fflush(NULL);	 
		fflush(stdin);


}
/*------------------------------------------------------------*/

print_group_test_desc()
{
   int l_len = 0;
   int nctr;
   char group_result[16];
   p_print_name_yn.arr[0] = '\0';
   p_test_desc.arr[0]     = '\0';
   p_function_yn.arr[0]   = '\0';
   p_print_name_yn.len    = 0;
   p_test_desc.len        = 0;
   p_function_yn.len      = 0;

   p_significant_digit    = 0;  
   p_no_of_decimals       = 0;

   /* EXEC SQL SELECT LONG_DESC,NVL(PRINT_NAME_YN,'N'),NVL(FUNCTION_YN,'N'),
		   SIGNIFICANT_DIGIT,NO_OF_DECIMALS
	    INTO   :p_test_desc,:p_print_name_yn,:p_function_yn,
		   :p_significant_digit,:p_no_of_decimals
	    FROM   RL_TEST_CODE 
	    WHERE  TEST_CODE = :rl_tst_group_test_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC ,NVL(PRINT_NAME_YN,'N') ,NVL(FUNCTION_YN,\
'N') ,SIGNIFICANT_DIGIT ,NO_OF_DECIMALS into :b0,:b1,:b2,:b3,:b4  from RL_TEST\
_CODE where TEST_CODE=:b5";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )116;
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
   sqlstm.sqhstv[5] = (         void  *)&rl_tst_group_test_code;
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


   if (OERROR)
      ins_message(ORA_MESG,"Select failed on table RL_TEST_CODE in print_group_test_desc");

   p_test_desc.arr[p_test_desc.len]    ='\0';
   p_print_name_yn.arr[p_print_name_yn.len]='\0';
   p_function_yn.arr[p_function_yn.len] = '\0';

   if(p_function_yn.arr[0] == 'Y')
   {
      group_result[0] = '\0';
      calc_func_and_prn(rl_tst_group_test_code.arr,group_result);
   }
      
   l_len = strlen(p_test_desc.arr);

   if(p_print_name_yn.arr[0] == 'Y')
   {
	  fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
      //fprintf(fp,"%-40s",p_test_desc.arr);
	  fprintf(fp, "%s", p_test_desc.arr);
      fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */

	  fprintf(fp, "%-*s", 41 - l_len, " ");
   }

   if(p_function_yn.arr[0] == 'Y')
      if(strlen(group_result))
	  {
		/********* Numeric result is increased to 10 chrs length **/
//		 fprintf(fp,"%-5s",group_result);

		  strcpy(r_rslt.arr, group_result);
		  r_rslt.len = strlen(r_rslt.arr);
		  add_zero_after_result();
		  strcpy(group_result, r_rslt.arr);

         fprintf(fp,"%-10.10s",group_result);
	  }

   if(p_print_name_yn.arr[0] == 'Y' || strlen(group_result))
   {
      fprintf(fp,"\n");
      page_break(1);
   }

/*********** underline is added with printing of group test description ******
   if(p_print_name_yn.arr[0] == 'Y')
   {
      for(nctr = 0; nctr < p_test_desc.len; nctr++)
          fprintf(fp,"_");
	  fprintf(fp,"\n");

      page_break(1);
   } 
**************************** upto here ************/
}
/* Calculate result for the Group Test if a function is set on it.  */
float calculate_function_result(sd,dc)
int sd; int dc;
{
return 0;
}

/*------------------------------------------------------------*/
create_lab_file_name()
{
  source_copies = 1;

  /* Referral Patients and External Patients*/
  if (rl_hdr_episode_type.arr[0] == 'R' || rl_hdr_episode_type.arr[0] == 'H')  
  {
       source_copies = sy_ref_no_of_copies + 1;
       strcpy(rl_prn_ctrl_hdr_source_code.arr,rl_prn_ctrl_hdr_section_code.arr);
       rl_prn_ctrl_hdr_source_code.len = strlen(rl_prn_ctrl_hdr_section_code.arr);
  }

}
/*----------------------------------------------------------*/
print_job()
{
char er_cd[10];
char print_yn = 'Y';
int i;

if(something_to_print == 1)
{

p_uid_pwd.arr[0] = '\0';
p_print_name.arr[0] = '\0';
p_loc_code.arr[0] = '\0';
p_loc_type.arr[0] = '\0';
p_rep_file.arr[0] = '\0';
p_print_mode.arr[0] = '\0';

p_uid_pwd.len = 0;
p_print_name.len = 0;
p_loc_code.len = 0;
p_loc_type.len = 0;
p_rep_file.len = 0;
p_print_mode.len = 0;


strcpy(p_uid_pwd.arr,uid_pwd.arr);
p_uid_pwd.len = strlen(uid_pwd.arr);

strcpy(p_print_name.arr,"RLRRSENQ");
p_print_name.len = strlen(p_print_name.arr);


strcpy(p_rep_file.arr,nd_f_name);
p_rep_file.len = strlen(nd_f_name);

strcpy(p_print_mode.arr,"S");
p_print_mode.len = strlen(p_print_mode.arr);


switch(p_param7.arr[0])
{
   case 'L' :  /*-------To cater to pulling list---------*/

       source_copies = 1;
       rl_hdr_extra_copies_to.arr[0] = '\0';
       rl_hdr_extra_copies_to.len = 0;

       strcpy(p_loc_type.arr,"O");
       p_loc_type.len = strlen(p_loc_type.arr);

       strcpy(p_loc_code.arr,"L");
       p_loc_code.len = strlen(p_loc_code.arr);

	   break;

   case 'X':  /*-----To cater to confidential reports----*/

       source_copies = 1;
       rl_hdr_extra_copies_to.arr[0] = '\0';
       rl_hdr_extra_copies_to.len = 0;

       strcpy(p_loc_type.arr,"O");
       p_loc_type.len = strlen(p_loc_type.arr);

       strcpy(p_loc_code.arr,"X");
       p_loc_code.len = strlen(p_loc_code.arr);

	   break;

   case 'Z':  /*-----To cater to reprinting by Patient----*/

       source_copies = 1;
       rl_hdr_extra_copies_to.arr[0] = '\0';
       rl_hdr_extra_copies_to.len = 0;

       strcpy(p_loc_type.arr,"O");
       p_loc_type.len = strlen(p_loc_type.arr);

       strcpy(p_loc_code.arr,"Z");
       p_loc_code.len = strlen(p_loc_code.arr);

	   break;

   case 'Y' :  /*-------To cater to reprint of results while registration---------*/

       source_copies = 1;
       rl_hdr_extra_copies_to.arr[0] = '\0';
       rl_hdr_extra_copies_to.len = 0;

       strcpy(p_loc_type.arr,"O");
       p_loc_type.len = strlen(p_loc_type.arr);

       strcpy(p_loc_code.arr, p_param7.arr);
       p_loc_code.len = strlen(p_loc_code.arr);

	   break;

   }


 }

	get_trans_ind();


      if (strcmp(nd_trx_ind.arr,"Y") == 0)
		   //print_online(uid_pwd.arr,"RLRRSENQ", p_loc_type.arr, p_loc_code.arr,"rlrrsenq.lis","S");
		   NULL;
	  else
		   //print_online(uid_pwd.arr,"RLRRSENQ", p_loc_type.arr, "", "rlrrsenq.lis","S");
		   NULL;
	


 if(OERROR)
      ins_message(ERR_MESG,"Select failed on DUAL in print_job()");
 
}

/*----------------------------------------------------------*/
sql_connect(l_nd_ap_uid_pwd)
char l_nd_ap_uid_pwd[];
{
  strcpy(uid_pwd.arr,l_nd_ap_uid_pwd);
  uid_pwd.len = strlen(uid_pwd.arr);

  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )155;
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
get_company_name()
{
    /* EXEC SQL  SELECT ACC_ENTITY_NAME  
		        INTO :sy_acc_entity_name
	            FROM SY_ACC_ENTITY
                  WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME into :b0  from SY_ACC_ENTITY where\
 ACC_ENTITY_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )186;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sy_acc_entity_name;
    sqlstm.sqhstl[0] = (unsigned int  )302;
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

    /* Company Name Master */

      if (OERROR)
         ins_message(ORA_MESG,"Select failed on table SY_ACC_ENTITY");

    sy_acc_entity_name.arr[sy_acc_entity_name.len] = '\0'; 
}
/*-----------------------------------------------------*/

get_departmental_parameters()
{
   rl_print_result_sect_yn.arr[0] = '\0';
   rl_print_result_sect_yn.len = 0;
   rl_section_tel_num.arr[0] = '\0';
   rl_section_tel_num.len = 0;
   rl_printer_for_urgent_yn.arr[0]	= '\0';
   rl_printer_for_urgent_yn.len		= 0;
   rl_test_requested_yn.arr[0]		= '\0';
   rl_test_requested_yn.len			= 0;
   rl_message_line.arr[0]			= '\0';
   rl_message_line.len				= 0;
   rl_name_on_report_yn.arr[0]		= '\0';
   rl_name_on_report_yn.len			= 0;
   rl_footer_line_1.arr[0]			= '\0';
   rl_footer_line_2.arr[0]			= '\0';
   rl_footer_line_1.len				= 0;
   rl_footer_line_2.len				= 0;

   /* EXEC SQL SELECT NVL(PRINT_RESULT_AT_SECTION_YN,'N'),TEL_NUM,
					NVL(printer_for_urgent_yn, 'N'), NVL(test_requested_yn,'N'),
					message_line, NVL(use_name_on_rep_feature_yn, 'N'),
					footer_line_1, footer_line_2
              INTO :rl_print_result_sect_yn,:rl_section_tel_num,
					:rl_printer_for_urgent_yn, :rl_test_requested_yn,
					:rl_message_line, :rl_name_on_report_yn,
					:rl_footer_line_1, :rl_footer_line_2
		      FROM RL_SECTION_CTL
		     WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND   SECTION_CODE = :rl_hdr_section_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(PRINT_RESULT_AT_SECTION_YN,'N') ,TEL_NUM ,NVL(p\
rinter_for_urgent_yn,'N') ,NVL(test_requested_yn,'N') ,message_line ,NVL(use_n\
ame_on_rep_feature_yn,'N') ,footer_line_1 ,footer_line_2 into :b0,:b1,:b2,:b3,\
:b4,:b5,:b6,:b7  from RL_SECTION_CTL where (OPERATING_FACILITY_ID=:b8 and SECT\
ION_CODE=:b9)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )209;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_print_result_sect_yn;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_section_tel_num;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&rl_printer_for_urgent_yn;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&rl_test_requested_yn;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&rl_message_line;
   sqlstm.sqhstl[4] = (unsigned int  )502;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&rl_name_on_report_yn;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&rl_footer_line_1;
   sqlstm.sqhstl[6] = (unsigned int  )502;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&rl_footer_line_2;
   sqlstm.sqhstl[7] = (unsigned int  )502;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[8] = (unsigned int  )5;
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
         ins_message(ORA_MESG,"Select failed on table RL_SECTION_CTL");

      rl_print_result_sect_yn.arr[rl_print_result_sect_yn.len] = '\0';
      rl_section_tel_num.arr[rl_section_tel_num.len] = '\0';
	  rl_printer_for_urgent_yn.arr[rl_printer_for_urgent_yn.len]= '\0';
	  rl_test_requested_yn.arr[rl_test_requested_yn.len]		= '\0';
	  rl_message_line.arr[rl_message_line.len]					= '\0';
	  rl_name_on_report_yn.arr[rl_name_on_report_yn.len]		= '\0';
	  rl_footer_line_1.arr[rl_footer_line_1.len]				= '\0';
	  rl_footer_line_2.arr[rl_footer_line_2.len]				= '\0';

}
/*-----------------------------------------------------*/

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


    /* EXEC SQL  SELECT LAB_TITLE, lab_title_2, lab_title_3, lab_title_4
		    INTO :rl_lab_title, :rl_lab_title_2, :rl_lab_title_3, :rl_lab_title_4
	            FROM RL_PARAM_FOR_FACILITY
				WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LAB_TITLE ,lab_title_2 ,lab_title_3 ,lab_title_4 i\
nto :b0,:b1,:b2,:b3  from RL_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID=:b\
4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )264;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[4] = (unsigned int  )5;
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

	/* Departmental Parameters */

      if (OERROR)
         ins_message(ORA_MESG,"Select failed on table RL_PARAM");

    rl_lab_title.arr[rl_lab_title.len] = '\0';
	rl_lab_title_2.arr[rl_lab_title_2.len] = '\0';
	rl_lab_title_3.arr[rl_lab_title_3.len] = '\0';
	rl_lab_title_4.arr[rl_lab_title_4.len] = '\0';

	// The last  title has to be concatenated with the department name

	strcat(rl_lab_title_4.arr, " ");
	strcat(rl_lab_title_4.arr, rl_section_short_name.arr);
	rl_lab_title_4.len = strlen(rl_lab_title_4.arr);


}
/*-----------------------------------------------------*/
declare_curs()
{
    get_company_name();


    /* EXEC SQL DECLARE RL_REQ_HDR_CUR CURSOR FOR
              SELECT SOURCE_CODE,
                     CONSULTANT_CODE,
                     TO_CHAR(SPEC_RECD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
                     TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
                     TO_CHAR(SPEC_COLLTD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
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
					 SOURCE_TYPE,
					 RELEASED_BY_ID,
					 TO_CHAR(RELEASED_DATE,'DD/MM/YYYY HH24:MI'),
					 category_code,
					 category_year, 
					 category_number,
					 TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY'),
					 ORDERED_FACILITY_ID
                FROM RL_REQUEST_HEADER
               WHERE PATIENT_ID = :nd_hosp_no
			   AND SPECIMEN_NO = :nd_spec_no
			   AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		 FOR UPDATE OF STATUS NOWAIT; */ 


    /* EXEC SQL DECLARE RL_REQ_DTL_CUR CURSOR FOR
              SELECT TEST_CODE,
                     NVL(RESULT_STATUS,'O'),
                     DECODE(GROUP_TEST_YN,'Y','G','I')
                FROM RL_REQUEST_DETAIL
               WHERE PATIENT_ID = :nd_hosp_no
                 AND SPECIMEN_NO = :first_specimen_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 



    /* EXEC SQL DECLARE RL_COMM_FOR_TEST_CUR CURSOR FOR
              SELECT COMMENT_TEXT
                FROM RL_COMMENTS_FOR_TEST
               WHERE TEST_CODE = :rl_tst_test_code
	    ORDER BY SEQ_NO; */ 


    /* EXEC SQL DECLARE RL_RESULT_TEXT_CUR CURSOR FOR
              SELECT RESULT_TEXT
                FROM RL_RESULT_TEXT
               WHERE PATIENT_ID     = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
				 AND NVL(hide_text_yn, 'N') <> 'Y'
            ORDER BY SERIAL_NO; */ 


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



    /* EXEC SQL DECLARE RL_RESULT_SNOMED_CUR CURSOR FOR
              SELECT SNOMED_CODE, snomed_code_2
                FROM RL_RESULT_SNOMED
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
	       ORDER BY SNOMED_CODE; */ 



    /* EXEC SQL DECLARE RL_RESULT_ORGANISM_CUR CURSOR FOR
              SELECT ORGANISM_CODE,
                     RESULT_COMMENT_DESC
                FROM RL_RESULT_ORGANISM
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
				 AND NVL(hide_organism_yn, 'N') <> 'Y'
			   ORDER BY ORGANISM_CODE; */ 


    /* EXEC SQL DECLARE RL_ANTIBIOTIC_CUR CURSOR FOR
              SELECT DISTINCT ANTIBIOTIC_CODE
                FROM RL_RESULT_ORGANISM_DTL
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
                 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
                 AND REPORT_YN       = 'Y'
				 AND SENSITIVITY_IND IN('S','R','I')
			   ORDER BY ANTIBIOTIC_CODE; */ 


    /* EXEC SQL DECLARE RL_SENSITIVITY_CUR CURSOR FOR
              SELECT ORGANISM_CODE,
					 ANTIBIOTIC_CODE,
                     SENSITIVITY_IND
                FROM RL_RESULT_ORGANISM_DTL
               WHERE PATIENT_ID      = :nd_hosp_no
                 AND SPECIMEN_NO     = :nd_spec_no
                 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND GROUP_TEST_CODE = :rl_tst_group_test_code
                 AND TEST_CODE       = :rl_tst_test_code
                 AND REPORT_YN       = 'Y'
				 AND SENSITIVITY_IND IN('S','R','I')
               ORDER BY ANTIBIOTIC_CODE, ORGANISM_CODE; */ 



}
/*-----------------------------------------------------*/
gen_file_name()
{
     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;

     if (OERROR)
         ins_message(ORA_MESG,"Fetch failed on table RL_PARAM");
      
     nd_file_no.arr[nd_file_no.len] = '\0';

     sprintf(nd_file_name.arr,"%srlrrsenq.lis", WORKING_DIR);

	 strcpy(nd_f_name,nd_file_name.arr);

     if ((fp = fopen(nd_file_name.arr,"w")) == NULL)
     {
         ins_message(ERR_MESG,"Error while opening file RSLT_FILE in gen_file_name");
         proc_exit();
     }

}
/*-----------------------------------------------------*/
close_hdr()
{
    /* EXEC SQL CLOSE RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )299;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         ins_message(ORA_MESG,"CLOSE failed on cursor RL_REQ_HDR_CUR");
}

/*-----------------------------------------------------*/
open_hdr()
{
    /* EXEC SQL OPEN RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0011;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )314;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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




	if (RESOURCE_BUSY)
	{
		ins_message(ORA_MESG,"OPEN failed resource busy RL_REQ_HDR_CUR");
	}

    if (OERROR)
	{
         ins_message(ORA_MESG,"OPEN failed on cursor RL_REQ_HDR_CUR");
	}


}
/*-----------------------------------------------------*/

fetch_hdr()
{
  rl_hdr_source_code.arr[0]            = '\0';
  rl_hdr_consultant_code.arr[0]        = '\0';
  rl_hdr_spec_regd_date_time.arr[0]    = '\0';
  rl_hdr_spec_recd_date_time.arr[0]    = '\0';
  rl_hdr_spec_colltd_date_time.arr[0]  = '\0';
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
  rl_hdr_source_type.arr[0]		       = '\0';
  rl_hdr_released_by_id.arr[0]		   = '\0';
  rl_hdr_released_date.arr[0]		   = '\0';
  rl_category_code.arr[0]			   = '\0';
  rl_category_year.arr[0]			   = '\0';
  rl_category_number.arr[0]			   = '\0';
  rl_regd_date.arr[0]				   = '\0';
  rl_ordered_facility_id.arr[0]		   = '\0';

  rl_hdr_source_code.len               = 0;
  rl_hdr_consultant_code.len           = 0;
  rl_hdr_spec_regd_date_time.len       = 0;
  rl_hdr_spec_recd_date_time.len       = 0;
  rl_hdr_spec_colltd_date_time.len     = 0;
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
  rl_hdr_episode_type.len	       = 0;
  rl_hdr_urgent_indicator.len	       = 0;
  rl_hdr_source_type.len	       = 0;
  rl_hdr_released_by_id.len = 0;
  rl_hdr_released_date.len = 0;
  rl_category_code.len					= 0;
  rl_category_year.len					= 0;
  rl_category_number.len				= 0;
  rl_regd_date.len						= 0;
  rl_ordered_facility_id.len			= 0;

    /* EXEC SQL FETCH RL_REQ_HDR_CUR
              INTO :rl_hdr_source_code,
                   :rl_hdr_consultant_code,
                   :rl_hdr_spec_recd_date_time,
                   :rl_hdr_spec_regd_date_time,
			       :rl_hdr_spec_colltd_date_time,
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
				   :rl_hdr_source_type,
				   :rl_hdr_released_by_id,
				   :rl_hdr_released_date,
				   :rl_category_code,
				   :rl_category_year,
				   :rl_category_number,
				   :rl_regd_date,
				   :rl_ordered_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )341;
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
    sqlstm.sqhstv[5] = (         void  *)&rl_hdr_current_date_time;
    sqlstm.sqhstl[5] = (unsigned int  )19;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_hdr_section_code;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_hdr_request_comment_code1;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rl_hdr_request_comment_code2;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&rl_hdr_request_comment_code3;
    sqlstm.sqhstl[9] = (unsigned int  )7;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&rl_hdr_request_comment_desc1;
    sqlstm.sqhstl[10] = (unsigned int  )43;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&rl_hdr_request_comment_desc2;
    sqlstm.sqhstl[11] = (unsigned int  )43;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rl_hdr_request_comment_desc3;
    sqlstm.sqhstl[12] = (unsigned int  )43;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rl_hdr_extra_copies_to;
    sqlstm.sqhstl[13] = (unsigned int  )18;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&rl_hdr_specimen_type_code;
    sqlstm.sqhstl[14] = (unsigned int  )7;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&rl_hdr_added_by_id;
    sqlstm.sqhstl[15] = (unsigned int  )33;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&rl_hdr_added_date;
    sqlstm.sqhstl[16] = (unsigned int  )18;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&rl_hdr_modified_by_id;
    sqlstm.sqhstl[17] = (unsigned int  )33;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&rl_hdr_modified_date;
    sqlstm.sqhstl[18] = (unsigned int  )18;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&rl_hdr_urgent_indicator;
    sqlstm.sqhstl[19] = (unsigned int  )4;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&rl_hdr_episode_type;
    sqlstm.sqhstl[20] = (unsigned int  )4;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&rl_hdr_source_type;
    sqlstm.sqhstl[21] = (unsigned int  )4;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&rl_hdr_released_by_id;
    sqlstm.sqhstl[22] = (unsigned int  )33;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&rl_hdr_released_date;
    sqlstm.sqhstl[23] = (unsigned int  )23;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&rl_category_code;
    sqlstm.sqhstl[24] = (unsigned int  )7;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&rl_category_year;
    sqlstm.sqhstl[25] = (unsigned int  )7;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&rl_category_number;
    sqlstm.sqhstl[26] = (unsigned int  )23;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&rl_regd_date;
    sqlstm.sqhstl[27] = (unsigned int  )13;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&rl_ordered_facility_id;
    sqlstm.sqhstl[28] = (unsigned int  )5;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
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
        ins_message(ORA_MESG,"FETCH failed on cursor RL_REQ_HDR_CUR");

    rl_hdr_source_code.arr[rl_hdr_source_code.len]		 	= '\0';
    rl_hdr_consultant_code.arr[rl_hdr_consultant_code.len]		= '\0';
    rl_hdr_spec_recd_date_time.arr[rl_hdr_spec_recd_date_time.len] 	= '\0';
    rl_hdr_spec_regd_date_time.arr[rl_hdr_spec_regd_date_time.len] 	= '\0';
    rl_hdr_spec_colltd_date_time.arr[rl_hdr_spec_colltd_date_time.len] = '\0';
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
    rl_hdr_episode_type.arr[rl_hdr_episode_type.len]					= '\0';
    rl_hdr_urgent_indicator.arr[rl_hdr_urgent_indicator.len]			= '\0';
    rl_hdr_source_type.arr[rl_hdr_source_type.len]						= '\0';
    rl_hdr_released_by_id.arr[rl_hdr_released_by_id.len]				= '\0';
    rl_hdr_released_date.arr[rl_hdr_released_date.len]					= '\0';
	rl_category_code.arr[rl_category_code.len]							= '\0';
	rl_category_year.arr[rl_category_year.len]							= '\0';
	rl_category_number.arr[rl_category_number.len]						= '\0';
	rl_regd_date.arr[rl_regd_date.len]									= '\0';
	rl_ordered_facility_id.arr[rl_ordered_facility_id.len]				= '\0';
	 	

	/* To Override the Source Code which is sending through SY_PROG_PARAM *****/
/********** This portion is commented on 03/06/2001
		The result report should print in the current location of patient
	 strcpy(rl_prn_ctrl_hdr_source_code.arr, rl_hdr_source_code.arr);
	 rl_prn_ctrl_hdr_source_code.len = strlen(rl_prn_ctrl_hdr_source_code.arr);
********************************************/
	/*******************            *****/

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

fetch_dtl()
{
    /* EXEC SQL OPEN RL_REQ_DTL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )472;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&first_specimen_no;
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
         ins_message(ORA_MESG,"OPEN failed on cursor RL_REQ_DTL_CUR");

    for (i=0;i<6;i++)
    {
        rl_dtl_test_code[i].arr[0]         = '\0';
        rl_dtl_result_status[i].arr[0]     = '\0';
        rl_dtl_group_test_flag[i].arr[0]   = '\0';

        rl_dtl_test_code[i].len            = 0;
        rl_dtl_result_status[i].len        = 0;
        rl_dtl_group_test_flag[i].len      = 0;
    }

    /* EXEC SQL FETCH RL_REQ_DTL_CUR
              INTO :rl_dtl_test_code,
                   :rl_dtl_result_status,
                   :rl_dtl_group_test_flag; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )7;
    sqlstm.offset = (unsigned int  )499;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)rl_dtl_test_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )16;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqharc[0] = (unsigned int   *)0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)rl_dtl_result_status;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )4;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqharc[1] = (unsigned int   *)0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)rl_dtl_group_test_flag;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )4;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqharc[2] = (unsigned int   *)0;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_REQ_DTL_CUR");

    no_of_dtl_recs = sqlca.sqlerrd[2];

    for (i=0;i<sqlca.sqlerrd[2];i++)
    {
        rl_dtl_test_code[i].arr[rl_dtl_test_code[i].len]         = '\0';
        rl_dtl_result_status[i].arr[rl_dtl_result_status[i].len] = '\0';
        rl_dtl_group_test_flag[i].arr[rl_dtl_group_test_flag[i].len]  = '\0';
    }
}
/*-----------------------------------------------------*/
declare_tst_result_curs()
{
    sql_stmt.arr[0]		= '\0';
	sql_stmt.len		= 0;
	
	strcpy(sql_stmt.arr, "SELECT B.specimen_no, \
					 B.GROUP_TEST_CODE, \
                     B.TEST_CODE, \
                     NVL(NUMERIC_PREFIX,'+'), \
                     NUMERIC_RESULT, \
					 RESULT_COMMENT_DESC1, \
                     RESULT_COMMENT_DESC2, \
                     RESULT_COMMENT_DESC3, \
                     RESULT_COMMENT_DESC4, \
					 TEST_UNITS, \
					 TEST_REF_RANGE_COMMENT, \
					 AGE_RANGE_LOW, \
					 AGE_RANGE_HIGH, \
                     B.ROWID AS row_id, \
					 NVL(HIDE_RESULT_COMMENTS_YN,'N'), \
					 B.high_low_ind, \
					 A.seq_no, \
					 NVL(B.cancelled_yn, 'N'), \
					 B.released_by_id, \
					 TO_CHAR(B.released_date, 'DD/MM/YYYY HH24:MI') \
                FROM RL_INTERVAL_TEST_TEMP A, RL_TEST_RESULT B \
               WHERE B.PATIENT_ID = :nd_hosp_no \
                 AND A.specimen_no = B.specimen_no \
				 AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
				 AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
				 AND B.test_code = DECODE(A.test_code, NULL, B.test_code, A.test_code) \
				 AND B.group_test_code = A.group_test_code \
				 AND NVL(B.cancelled_yn, 'N') <> 'Y' \
				 AND A.user_id = 'RLRRSENQ' \
				 AND A.session_id = 1 ");
	
	if (d_interval_specimen_yn == 'Y')
		strcat(sql_stmt.arr, " ORDER BY B.test_code, B.specimen_no, B.GROUP_SEQ_NO,B.TEST_SEQ_NO FOR UPDATE OF STATUS NOWAIT");
	else
		strcat(sql_stmt.arr, " ORDER BY B.GROUP_SEQ_NO,B.TEST_SEQ_NO FOR UPDATE OF STATUS NOWAIT");

		 
	sql_stmt.len = strlen(sql_stmt.arr);
	/* EXEC SQL PREPARE sr1 FROM :sql_stmt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )526;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sql_stmt;
 sqlstm.sqhstl[0] = (unsigned int  )2002;
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
		 ins_message(ORA_MESG,"PREPARE failed on table RL_TEST_RESULT");

    /* EXEC SQL DECLARE rl_test_result_cur CURSOR FOR sr1; */ 
		

}
/*-----------------------------------------------------*/
open_tst_result_curs()
{

	/* EXEC SQL OPEN rl_test_result_cur USING :nd_hosp_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )545;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
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



	if (RESOURCE_BUSY)
	{
		ins_message(ORA_MESG,"OPEN failed resource busy rl_test_result_cur");
	}


}
/*-----------------------------------------------------*/
fetch_tst_result()
{

  rl_tst_group_test_code.arr[0]      = '\0';
  rl_tst_test_code.arr[0]      = '\0';
  rl_tst_numeric_prefix.arr[0]      = '\0';
  rl_tst_numeric_result.arr[0]      = '\0';
  rl_tst_result_comment_desc1.arr[0]      = '\0';
  rl_tst_result_comment_desc2.arr[0]      = '\0';
  rl_tst_result_comment_desc3.arr[0]      = '\0';
  rl_tst_result_comment_desc4.arr[0]      = '\0';
  rl_tst_rowid.arr[0]                     = '\0';
  rl_tst_cd_test_units.arr[0]			= '\0';
  rl_tst_cd_range_cmt.arr[0]		  = '\0';
  rl_tst_ran_low_val_nor.arr[0]	  = '\0';
  rl_tst_ran_high_val_nor.arr[0]	  = '\0';
  rl_tst_hide_rslt_comm_yn.arr[0] = '\0';
  d_specimen_no.arr[0]			  = '\0';
  rl_high_low_ind.arr[0]		  = '\0';
  rl_cancelled_yn.arr[0]			  = '\0';
  rl_released_by_id.arr[0]			  = '\0';
  rl_released_date.arr[0]			  = '\0';

  rl_tst_group_test_code.len         = 0;
  rl_tst_test_code.len         = 0;
  rl_tst_numeric_prefix.len         = 0;
  rl_tst_numeric_result.len         = 0;
  rl_tst_result_comment_desc1.len         = 0;
  rl_tst_result_comment_desc2.len         = 0;
  rl_tst_result_comment_desc3.len         = 0;
  rl_tst_result_comment_desc4.len         = 0;
  rl_tst_rowid.len                        = 0;
  rl_tst_cd_test_units.len		  = 0;
  rl_tst_cd_range_cmt.len		  = 0;
  rl_tst_ran_low_val_nor.len	  = 0;
  rl_tst_ran_high_val_nor.len	  = 0;
  rl_tst_hide_rslt_comm_yn.len	  = 0;
  d_specimen_no.len				  = 0;
  rl_high_low_ind.len			  = 0;
  rl_cancelled_yn.len			  = 0;
  rl_released_by_id.len			  = 0;
  rl_released_date.len			  = 0;

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
				   :rl_tst_cd_test_units,
				   :rl_tst_cd_range_cmt,
				   :rl_tst_ran_low_val_nor,
				   :rl_tst_ran_high_val_nor,
                   :rl_tst_rowid,
				   :rl_tst_hide_rslt_comm_yn,
				   :rl_high_low_ind, 
				   :rl_seq_no,
				   :rl_cancelled_yn,
				   :rl_released_by_id,
				   :rl_released_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )564;
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
    sqlstm.sqhstv[9] = (         void  *)&rl_tst_cd_test_units;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&rl_tst_cd_range_cmt;
    sqlstm.sqhstl[10] = (unsigned int  )43;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&rl_tst_ran_low_val_nor;
    sqlstm.sqhstl[11] = (unsigned int  )18;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rl_tst_ran_high_val_nor;
    sqlstm.sqhstl[12] = (unsigned int  )18;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rl_tst_rowid;
    sqlstm.sqhstl[13] = (unsigned int  )33;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&rl_tst_hide_rslt_comm_yn;
    sqlstm.sqhstl[14] = (unsigned int  )4;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&rl_high_low_ind;
    sqlstm.sqhstl[15] = (unsigned int  )12;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&rl_seq_no;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&rl_cancelled_yn;
    sqlstm.sqhstl[17] = (unsigned int  )4;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&rl_released_by_id;
    sqlstm.sqhstl[18] = (unsigned int  )23;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&rl_released_date;
    sqlstm.sqhstl[19] = (unsigned int  )19;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_TEST_RESULT_CUR");

    rl_tst_group_test_code.arr[rl_tst_group_test_code.len] = '\0';
    rl_tst_test_code.arr[rl_tst_test_code.len] = '\0';
    rl_tst_numeric_prefix.arr[rl_tst_numeric_prefix.len] = '\0';
    rl_tst_numeric_result.arr[rl_tst_numeric_result.len] = '\0';
    rl_tst_result_comment_desc1.arr[rl_tst_result_comment_desc1.len] = '\0';
    rl_tst_result_comment_desc2.arr[rl_tst_result_comment_desc2.len] = '\0';
    rl_tst_result_comment_desc3.arr[rl_tst_result_comment_desc3.len] = '\0';
    rl_tst_result_comment_desc4.arr[rl_tst_result_comment_desc4.len] = '\0';
    rl_tst_rowid.arr[rl_tst_rowid.len] = '\0';
    rl_tst_cd_test_units.arr[rl_tst_cd_test_units.len]  	      = '\0';
    rl_tst_cd_range_cmt.arr[rl_tst_cd_range_cmt.len]		      = '\0';
    rl_tst_ran_low_val_nor.arr[rl_tst_ran_low_val_nor.len]	  = '\0';
    rl_tst_ran_high_val_nor.arr[rl_tst_ran_high_val_nor.len]	  = '\0';
    rl_tst_hide_rslt_comm_yn.arr[rl_tst_hide_rslt_comm_yn.len] = '\0';
	d_specimen_no.arr[d_specimen_no.len]					   = '\0';
	rl_high_low_ind.arr[rl_high_low_ind.len]				   = '\0';
	rl_cancelled_yn.arr[rl_cancelled_yn.len]				   = '\0';
	rl_released_by_id.arr[rl_released_by_id.len]			   = '\0';
	rl_released_date.arr[rl_released_date.len]				   = '\0';

	strcpy(nd_spec_no.arr, d_specimen_no.arr);
	nd_spec_no.len = strlen(nd_spec_no.arr);

#ifdef DEBUG
    printf("Group is <%s> tst is <%s>\n",rl_tst_group_test_code.arr,
                       rl_tst_test_code.arr);
	printf("In fetch_tst_result, last_row = %d \n",
	LAST_ROW);
#endif
    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

update_tst_result()
{

     /* EXEC SQL UPDATE RL_TEST_RESULT
                 SET STATUS = 'P',
		     MODIFIED_BY_ID = USER,
		     MODIFIED_DATE = SYSDATE
               WHERE ROWID       = :rl_tst_rowid; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 29;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update RL_TEST_RESULT  set STATUS='P',MODIFIED_BY_ID=USE\
R,MODIFIED_DATE=SYSDATE where ROWID=:b0";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )659;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&rl_tst_rowid;
     sqlstm.sqhstl[0] = (unsigned int  )33;
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
         ins_message(ORA_MESG,"UPDATE failed on table RL_TEST_RESULT");
}
/*-----------------------------------------------------*/
print_header()
{   char t_patient_id[21];   
    char sex_desc[11];
	char pat_name[60];
	char uline[82];
	char l_str[100];
    int i;

    pctr++;
    lctr = 19;
    get_parameters();

/*---------*/
    fprintf(fp,"%c&a006L",ESC); /* Set the left Margin */
	fprintf(fp,"%c&k12S",ESC);	/* This makes the font size to increase to 12 */
	fprintf(fp,"%c&l6D",ESC);	/* Set the Density */
   	fprintf(fp,"%c(s4B",ESC);   /* Set Bold */
/*---------*/

    fprintf(fp,"\n%-*s%-.40s\n\n",(int)(((80 - sy_acc_entity_name.len)/2) - 6)," ",sy_acc_entity_name.arr);
    fprintf(fp,"%-*s%-.80s\n",(int)(((80 - rl_lab_title.len)/2) - 6)," ",rl_lab_title.arr);

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
   	fprintf(fp,"%c(s-3B",ESC);
    fprintf(fp,"%73.73sPage(s) : %3d\n"," ",pctr);
/*----------------------------------------*/


    if(rl_hdr_episode_type.arr[0] == 'R')
       if(strcmp(rl_pat_actual_id.arr,"NULL")==0)
	  strcpy(t_patient_id,nd_hosp_no.arr);
       else
	  strcpy(t_patient_id,rl_pat_actual_id.arr);
    else
       strcpy(t_patient_id,nd_hosp_no.arr);

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Patient ID : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/
	
	fprintf(fp,"%c&k12S",ESC);	
	fprintf(fp,"%c&l6D",ESC);
   	fprintf(fp,"%c(s4B",ESC);

    fprintf(fp,"%-15.15s",t_patient_id);

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Section : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

	fprintf(fp, "%-s - %-s\n",rl_section_short_name.arr,
							  rl_section_tel_num.arr);

    for(i=0;i<87;i++)
        fprintf(fp,"_");
    fprintf(fp,"\n\n");

    if(rl_pat_sex.arr[0] == 'M')
	   strcpy(sex_desc,"MALE");
	else
	if(rl_pat_sex.arr[0] == 'F')
	   strcpy(sex_desc,"FEMALE");
	else
       strcpy(sex_desc,"");
    
	strcpy(pat_name,rl_pat_title.arr);
	if(strlen(rl_pat_title.arr) > 0)
	   strcat(pat_name," ");
	strcat(pat_name,rl_pat_short_name.arr);
    
/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp,"Patient Name         : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

    fprintf(fp,"%-42.42s",pat_name);

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Sex : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

    fprintf(fp,"%-8.8s\n",sex_desc);

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Location             : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

    fprintf(fp,"%-42.42s",rl_source_short_name.arr);

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"DOB : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/
	
	fprintf(fp,"%-16.16s\n",rl_pat_date_of_birth.arr); 

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Clinical Information : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

    if (rl_hdr_request_comment_desc1.len)
    {
      fprintf(fp,"%-40s\n",rl_hdr_request_comment_desc1.arr);
      page_break(1);
    }
	else
    {
      fprintf(fp,"\n");
      page_break(1);
    }

    if (rl_hdr_request_comment_desc2.len)
    {
       /*----------------------------------------*/
       fprintf(fp,"%c&k4S",ESC); 
   	   fprintf(fp,"%c(s4B",ESC);
       fprintf(fp,"%-23.23s"," ");
       fprintf(fp,"%c&k4S",ESC); 
   	   fprintf(fp,"%c(s-3B",ESC);   
      /*----------------------------------------*/
      fprintf(fp,"%-40s\n",rl_hdr_request_comment_desc2.arr);
      page_break(1);
    }

    if (rl_hdr_request_comment_desc3.len)
    {
       /*----------------------------------------*/
       fprintf(fp,"%c&k4S",ESC); 
   	   fprintf(fp,"%c(s4B",ESC);
       fprintf(fp,"%-23.23s"," ");
       fprintf(fp,"%c&k4S",ESC); 
   	   fprintf(fp,"%c(s-3B",ESC);   
      /*----------------------------------------*/
      fprintf(fp,"%-40s\n",rl_hdr_request_comment_desc3.arr);
      page_break(1);
    }
/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Requesting Doctor    : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

    fprintf(fp,"%-33.33s",rl_consultant_short_name.arr);
				
/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Request Date : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

    fprintf(fp,"%-s\n",rl_hdr_spec_recd_date_time.arr);

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Specimen Type        : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

    fprintf(fp,"%-33.33s",rl_spc_specimen_desc.arr);

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Regn Date    : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

    fprintf(fp,"%s\n",rl_hdr_spec_regd_date_time.arr);

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Tests Requested      : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

    fprintf(fp,"%-33.33s"," ");

/*----------------------------------------*/
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
    fprintf(fp,"Specimen No  : ");
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
/*----------------------------------------*/

	if (d_interval_specimen_yn == 'Y')
		fprintf(fp,"%-9.9s (I)\n",first_specimen_no.arr);
	else
		fprintf(fp,"%-s\n",nd_spec_no.arr);

	sprintf(l_str,"%-6.6s"," ");

    for (i=0;i < no_of_dtl_recs;i++)
    {
       sprintf(l_str,"%s%-10s  ",l_str, rl_dtl_test_code[i].arr);
    }
    fprintf(fp,"%s\n",l_str);

    for(i=0;i<87;i++)
        fprintf(fp,"_");
    fprintf(fp,"\n\n");
}
/*---------------------------------------------------------*/
print_dtls()
{
  int next_line = 0;
  char range_cmnt_print_flag = 'N';
  char l_str [100],l_str1[100];
  int agesex_range_flag = FALSE;
  int path_review_flag = FALSE;
  numeric_value_flag = FALSE;
  strcpy(l_str,"");
  page_break(0);
  
  fetch_test_code(rl_tst_test_code.arr);
  
  /* Check to see if test result should be printed (Confidential Result) */
   if (rl_tst_cd_conf_yn.arr[0]	== 'N' || p_param7.arr[0] == 'X')
  {
  
  if(rl_tst_cd_inh_rep_yn.arr[0] == 'N')
  {
    spc_first = 1;
    fflush(fp);
    ind_test_prn = 0;
/********* Newly added to print only those reports 
	which is having some component or should print 
	  *********/
/***** changed on 13/04/2002 against scf - 42 of QATAR *********/
//		something_to_print = 1;	

/******** Newly added to print the specimen nos for the GTT Tests ****/
		if (d_interval_specimen_yn == 'Y')
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


	
    if(rl_tst_cd_print_report_yn.arr[0] == 'Y')
	{
		if (d_interval_specimen_yn == 'Y')
		{
			get_interval_description();
			sprintf(l_str,"%-40.40s",interval_description.arr);
		}
		else
		{
			sprintf(l_str,"%-40.40s",rl_tst_cd_short_desc.arr);
		}
	}
    else
        sprintf(l_str,"%-40s"," ");
    strcpy(text_line,l_str);
    strcpy(test_description,l_str);
	
    if (rl_tst_cd_numeric_result_yn.arr[0] == 'Y')
    {
	if (rl_tst_numeric_result.len)
	{

/****** ADDED ON 14/04/2002 AGAINST SCF - 42 *******/		
		something_to_print = 1;

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
	        sprintf(l_str,"%s%c%-10s",l_str,rl_tst_numeric_prefix.arr[0],
					     rl_tst_numeric_result.arr);
          }
          strcpy(l_str1,l_str);
          ltrim(l_str1);
          rtrim(l_str1);

	  if (strlen(rl_tst_cd_test_units.arr) == 0)
	  {
			strcpy(rl_tst_cd_test_units.arr,rl_tst_cd_test_units_2.arr);
			rl_tst_cd_test_units.len = strlen(rl_tst_cd_test_units.arr);
	  }

          sprintf(l_str,"%s%-10s",l_str,rl_tst_cd_test_units.arr);

   	  if ((rl_tst_ran_low_val_nor.len  || rl_tst_ran_high_val_nor.len ) &&
		  (rl_pat_sex.arr[0] == 'M'    || rl_pat_sex.arr[0] == 'F'))
          {
		    get_zero_prefix_for_range();

			  strcpy(r_rslt.arr, rl_tst_ran_low_val_nor.arr);
			  r_rslt.len = strlen(r_rslt.arr);
 			  add_zero_after_result();
			  strcpy(rl_tst_ran_low_val_nor.arr, r_rslt.arr);
			  rl_tst_ran_low_val_nor.len = strlen(rl_tst_ran_low_val_nor.arr);

			  strcpy(r_rslt.arr, rl_tst_ran_high_val_nor.arr);
			  r_rslt.len = strlen(r_rslt.arr);
 			  add_zero_after_result();
			  strcpy(rl_tst_ran_high_val_nor.arr, r_rslt.arr);
			  rl_tst_ran_high_val_nor.len = strlen(rl_tst_ran_high_val_nor.arr);
			

			      sprintf(l_str,"%s %-1s (%s - %s)",l_str,
						rl_high_low_ind.arr,
                     rl_tst_ran_low_val_nor.arr,
                     rl_tst_ran_high_val_nor.arr);

		   				   agesex_range_flag = TRUE;
          }
          else
          {
                    if(rl_tst_cd_range_cmt.len)
		    {
		       range_cmnt_print_flag = 'Y';
                    }
                    else
                    {
				 if ((!(rl_tst_ran_low_val_nor.len)  &&	!(rl_tst_ran_high_val_nor.len) && 
					(rl_tst_cd_age_sex_range_yn.arr[0] == 'Y')) &&
					(rl_pat_sex.arr[0] == 'M' || rl_pat_sex.arr[0] == 'F'))
				 {

					fetch_age_sex_range();
					if ( rl_tst_ran_low_val_nor.len && rl_tst_ran_high_val_nor.len )
					{
					   get_zero_prefix_for_range();

						  strcpy(r_rslt.arr, rl_tst_ran_low_val_nor.arr);
						  r_rslt.len = strlen(r_rslt.arr);
						  add_zero_after_result();
						  strcpy(rl_tst_ran_low_val_nor.arr, r_rslt.arr);
						  rl_tst_ran_low_val_nor.len = strlen(rl_tst_ran_low_val_nor.arr);

						  strcpy(r_rslt.arr, rl_tst_ran_high_val_nor.arr);
					   	  r_rslt.len = strlen(r_rslt.arr);
 						  add_zero_after_result();
 						  strcpy(rl_tst_ran_high_val_nor.arr, r_rslt.arr);
						  rl_tst_ran_high_val_nor.len = strlen(rl_tst_ran_high_val_nor.arr);

				      sprintf(l_str,"%s %-1s (%-s - %s)",l_str,
							rl_high_low_ind.arr,
			             rl_tst_ran_low_val_nor.arr,
				         rl_tst_ran_high_val_nor.arr);
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
          }
		
          strcpy(l_str1,l_str);
          ltrim(l_str1);
          rtrim(l_str1);
	    
          if(group && !group_printed)
          {
	       print_group_test_desc();
	       group_printed = 1;
          }
	    
          next_line = 0;

          if(range_cmnt_print_flag == 'Y')
          {
			if(strlen(rl_tst_cd_range_cmt.arr) <= (80 - strlen(l_str)))
			{
				sprintf(l_str,"%s%s",l_str,rl_tst_cd_range_cmt.arr);
			}
			else
				next_line = 1;   
          }
		
		  print_clinical_history();

          print_line(l_str);
          test_printed  = 1;

          if(next_line == 1)
          {
	     sprintf(l_str,"%40.40s%40.40s"," ",rl_tst_cd_range_cmt.arr);
	     print_line(l_str);
          } 

	}   /*Endif of rl_tst_numeric_result.len */

    } /* Endif of rl_tst_cd_numeric_result_yn.arr */

    if(rl_tst_hide_rslt_comm_yn.arr[0] == 'N')
        print_comment_desc1234();

     print_test_comments();

     if(rl_tst_cd_culture_test_yn.arr[0] == 'Y')
	    print_culture();

     if (rl_tst_cd_text_block_yn.arr[0] == 'Y')
     {
        open_result_text();
	    splitting();
     }

     if (rl_tst_cd_snomed_yn.arr[0] == 'Y') 
          print_snomed();

     fflush(fp);

  } /* end if of inh_rep_yn */

  } /* end if of confidential report*/
}
/*-----------------------------------------------------*/
print_test_comments()
{
open_comments();
_flushall();
while(fetch_comments())
  {
    if (rl_comm_tst_comm_txt.len)
    {
	   //something_to_print = 1;
       if(group && !group_printed)
       {
	      print_group_test_desc();
	      group_printed = 1;
       }
       if(test_printed)
       {  numeric_value_flag = TRUE;
          print_line_check(rl_comm_tst_comm_txt.arr);
       }
       else
       {
	      numeric_value_flag = FALSE;
	      sprintf(text_line,"%-40.40s%-40s",test_description,
			    rl_comm_tst_comm_txt.arr);
	      print_line_check(text_line);
	      test_printed = 1;
       }
     }
   }

   	close_comments_curs();

   _flushall();
}
/*-----------------------------------------------------*/
print_line(char *t_str)
{
         fprintf(fp,"%s\n",t_str);
         page_break(1);

/******COMMENTED AGAINST SCF 42 OF QATAR - ******/
//		 something_to_print = 1;
}
/*-----------------------------------------------------*/
print_line_check(char *t_str)
{
      if (numeric_value_flag == TRUE)
	  {
		fprint_repeat(fp,' ',40);
		print_line(t_str);
		numeric_value_flag = TRUE;
	  }
      else  
      {
		print_line(t_str);
		numeric_value_flag = TRUE;
	  }

/******COMMENTED AGAINST SCF 42 OF QATAR - ******/
//	  something_to_print = 1;
}
/*-----------------------------------------------------*/
print_test_desc(l_str)
char l_str[];
{
   if ((!ind_test_prn) &&
      (rl_tst_cd_group_test_yn.arr[0]  == 'N'))
   {
       if (rl_tst_cd_print_report_yn.arr[0] == 'Y')
           fprintf(fp,"%-40s%-36s%s",rl_tst_cd_short_desc.arr,l_str,
                           rl_curr_status);
       else
           fprintf(fp,"%-40s%-36s%s","",l_str,(tst_cd_ind)?rl_curr_status:"");
       ind_test_prn = 1;
       spc_first = 1;
    }
    else if (strlen(l_str))
           fprintf(fp,"%-40s%-40s","",l_str);

    if (tst_cd_ind) tst_cd_ind = 0;
}
/*-----------------------------------------------------*/

print_snomed()
{
	int ctr = 0;
	char prev_snomed_print_yn = 'N';

    open_result_snomed();
	

	_flushall();
    while (fetch_rl_result_snomed())
    {
        if (fetch_snomed_desc12345())
        {

	/***** NEWLY ADDED   *************/
		get_desc_snomed2();

	        if (rl_snomed_print_yn.arr[0] == 'Y' || rl_snomed2_print_yn.arr[0] == 'Y')
           	    print_snomed_desc12345();
			else
			{
			    something_to_print = 1;

				if(group && !group_printed)
				{
				   print_group_test_desc();
				  group_printed = 1;
				}
				if(!test_printed)
				{
					fprintf(fp,"%-40.40s\n",test_description);
					test_printed = 1;
				}
/******************************/

					print_snomed_codes('Y');

					fprintf(fp, "\n");
					page_break(1);

/******************************/				  


			}

	        ctr++;
        }
    }

	close_snomed_cur();

	_flushall();
}
/*-----------------------------------------------------*/

open_result_snomed()
{
    /* EXEC SQL OPEN RL_RESULT_SNOMED_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0016;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )678;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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
         ins_message(ORA_MESG,"OPEN failed on cursor RL_RESULT_SNOMED_CUR");
}
/*-----------------------------------------------------*/

fetch_rl_result_snomed()
{
#ifdef DEBUG
       printf("In fetch_rl_result_snomed() \n");
#endif
    rl_res_snomed_code.arr[0]     = '\0';
	rl_res_snomed_code2.arr[0]	  = '\0';

    rl_res_snomed_code.len        = 0;
	rl_res_snomed_code2.len		  = 0;

    /* EXEC SQL FETCH RL_RESULT_SNOMED_CUR
              INTO :rl_res_snomed_code,
				   :rl_res_snomed_code2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )709;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_RESULT_SNOMED_CUR");

    rl_res_snomed_code.arr[rl_res_snomed_code.len] = '\0';
	rl_res_snomed_code2.arr[rl_res_snomed_code2.len]	= '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
print_culture()
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
    int oflag = 1;
	int match_found = 0;

    open_result_organism();
	_flushall();
    while(fetch_result_org())
    {
        something_to_print = 1;

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
		   	fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/

                        sprintf(text_line,"%-46.46s%-41.41s","ORGANISM","COMMENT");
			print_line(text_line);

		   	fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */

			oflag = 0;
		}

		fetch_org_desc();

		sprintf(text_line,"%2d.   %-40.40s%-40.40s",no_of_organisms,
							rl_res_organism_code_desc.arr,
							rl_res_comment_desc.arr);
		print_line(text_line);
	} 

	close_organism_cur();

	_flushall();

	if(no_of_organisms)
	{
		something_to_print = 1;
   	    fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
		sprintf(text_line,"");
		for(c=0;c<87;c++)
			sprintf(text_line,"%s%s",text_line," ");
		print_line(text_line);
   	    fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */

		sprintf(text_line,"%-46.46s","ANTIBIOTIC ");
		for(c=0;c<no_of_organisms;c++)	/* Print organism codes as column headings*/
			sprintf(text_line,"%s%2d     ",text_line,c+1);  /* c is printed in place of org[c]*/
		print_line(text_line);

   	    fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
		sprintf(text_line,"");
		for(c=0;c<87;c++)
			sprintf(text_line,"%s%s",text_line," ");
		print_line(text_line);
	   	fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */

		open_sensitivity();
		fetch_sensitivity();

   	    fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
		open_antibiotic();
		_flushall();
		while(fetch_antibiotic())
		{
			something_to_print = 1;
			strcpy(rl_res_dtl_antibiotic_code.arr,a_antibiotic_code.arr);
			rl_res_dtl_antibiotic_code.len = strlen(a_antibiotic_code.arr);
			fetch_antibiotic_desc();
		    sprintf(text_line,"%-47.47s",rl_res_dtl_antibiotic_desc.arr);
			
			for(e=0;e<no_of_organisms;e++)
			{
				match_found = 0;
				for(s=0; s<no_of_sensitivities; s++)
				{
					if( (strcmp(s_ant[s].arr, a_antibiotic_code.arr) == 0) &&
						(strcmp(s_org[s].arr, org[e]) == 0) )
					{
			            sprintf(text_line,"%s%-7.7s",text_line,s_ind[s].arr);
						match_found = 1;
						break;
					}
				}

				if(match_found == 0)
	               sprintf(text_line,"%s       ",text_line);
			}
			sprintf(text_line,"%-87.87s",text_line);			
			print_line(text_line);
		}

		close_antibiotic_cur();

		sprintf(text_line,"%-35.35s%-52.52s"," ","S - Sensitive     R - Resistant   I - Intermediate");
		print_line(text_line);
	   	fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */

	}
	fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
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
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0017;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )732;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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
         ins_message(ORA_MESG,"OPEN failed on cursor RL_RESULT_ORGANISM_CUR");
}
/*-----------------------------------------------------*/

open_antibiotic()
{
    /* EXEC SQL OPEN RL_ANTIBIOTIC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0018;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )767;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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
         ins_message(ORA_MESG,"OPEN failed on cursor RL_ANTIBIOTIC_CUR");
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
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )802;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_RESULT_ORGANISM_CUR");

    a_antibiotic_code.arr[a_antibiotic_code.len]   = '\0';
    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
fetch_result_org()
{
    rl_res_organism_code.arr[0]   = '\0';
    rl_res_comment_desc.arr[0]    = '\0';

    rl_res_organism_code.len      = 0;
    rl_res_comment_desc.len       = 0;

    /* EXEC SQL FETCH RL_RESULT_ORGANISM_CUR
              INTO :rl_res_organism_code,
                   :rl_res_comment_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )821;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_RESULT_ORGANISM_CUR");

    rl_res_organism_code.arr[rl_res_organism_code.len] = '\0';
    rl_res_comment_desc.arr[rl_res_comment_desc.len] = '\0';
    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

fetch_org_desc()
{
    

    if (OERROR)
         ins_message(ORA_MESG,"OPEN failed on cursor RL_ORGANISM_CODE_CUR");

    rl_res_organism_code_desc.arr[0] = '\0';
    rl_res_organism_code_desc.len    = 0;

    /* EXEC SQL SELECT LONG_DESC
			 INTO :rl_res_organism_code_desc
             FROM RL_ORGANISM_CODE
             WHERE ORGANISM_CODE = :rl_res_organism_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from RL_ORGANISM_CODE where OR\
GANISM_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )844;
    sqlstm.selerr = (unsigned short)1;
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
    sqlstm.sqhstv[1] = (         void  *)&rl_res_organism_code;
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




    rl_res_organism_code_desc.arr[rl_res_organism_code_desc.len] = '\0';

    if (OERROR)
         ins_message(ORA_MESG,"FETCH failed on cursor RL_ORGANISM_CODE_CUR");
}
/*-----------------------------------------------------*/

fetch_antibiotic_desc()
{
    

    if (OERROR)
         ins_message(ORA_MESG,"OPEN failed on cursor RL_ANTIBIOTIC_CODE_CUR");

    rl_res_dtl_antibiotic_desc.arr[0] = '\0';
    rl_res_dtl_antibiotic_desc.len    = 0;

    /* EXEC SQL SELECT SUBSTR(LONG_DESC,1,39)
			 INTO :rl_res_dtl_antibiotic_desc
             FROM RL_ANTIBIOTIC_CODE
             WHERE ANTIBIOTIC_CODE = :rl_res_dtl_antibiotic_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SUBSTR(LONG_DESC,1,39) into :b0  from RL_ANTIBIOTI\
C_CODE where ANTIBIOTIC_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )867;
    sqlstm.selerr = (unsigned short)1;
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
    sqlstm.sqhstv[1] = (         void  *)&rl_res_dtl_antibiotic_code;
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



    rl_res_dtl_antibiotic_desc.arr[rl_res_dtl_antibiotic_desc.len] = '\0';

    if (OERROR)
         ins_message(ORA_MESG,"FETCH failed on cursor RL_ANTIBIOTIC_CODE_CUR");
}
/*-----------------------------------------------------*/
open_sensitivity()
{

    /* EXEC SQL OPEN RL_SENSITIVITY_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0019;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )890;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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
         ins_message(ORA_MESG,"OPEN failed on cursor RL_SENSITIVITY_CUR");
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

		s_ant[i].len = 0;
		s_org[i].len = 0;
		s_ind[i].len = 0;
   }

   /* EXEC SQL FETCH RL_SENSITIVITY_CUR
	         INTO :s_org,
			      :s_ant,
			      :s_ind; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 29;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )250;
   sqlstm.offset = (unsigned int  )925;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_SENSITIVITY_CUR");

   for(i=0;i<MAX_ANTIBIOTICS;i++)
   {
		s_org[i].arr[s_org[i].len] = '\0';
		if(strlen(s_org[i].arr) == 0)
		   break;
		s_ant[i].arr[s_ant[i].len] = '\0';
		s_ind[i].arr[s_ind[i].len] = '\0';
   }
   no_of_sensitivities = i;
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
   fetch_source();
   fetch_consultant();
   fetch_section();
}

/*-----------------------------------------------------*/
declare_inpat_curs()
{
	/* EXEC SQL DECLARE RL_PAT_MAST_CUR CURSOR FOR
              SELECT TITLE_CODE,
	 	     SHORT_NAME,
                     SEX,
                     NATIONALITY_CODE,
                     ROUND(TRUNC(TO_DATE(:rl_hdr_spec_regd_date_time,
				   'DD/MM/YYYY HH24:MI')) - DATE_OF_BIRTH),
                     TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,
					 NVL(actual_dob_yn, 'N'),
					 race_code,
                     ROUND((TRUNC(TO_DATE(:rl_hdr_spec_regd_date_time,
				   'DD/MM/YYYY HH24:MI')) - DATE_OF_BIRTH)/365)
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :nd_hosp_no; */ 

}
/*-----------------------------------------------------*/
declare_refpat_curs()
{
    /* EXEC SQL DECLARE RL_PAT_MAST3_CUR CURSOR FOR
              SELECT TITLE_CODE,
		     SHORT_NAME,
                     SEX,
                     NATIONALITY_CODE,
                     ROUND(TRUNC(TO_DATE(:rl_hdr_spec_regd_date_time,
				    'DD/MM/YYYY HH24:MI')) - DATE_OF_BIRTH),
                     TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		     SUBSTR(NVL(ACTUAL_PATIENT_ID,'NULL'),1,10),
					NVL(actual_dob_yn, 'N'), 
					race_code,
                     ROUND((TRUNC(TO_DATE(:rl_hdr_spec_regd_date_time,
				   'DD/MM/YYYY HH24:MI')) - DATE_OF_BIRTH)/365),
				   location
                FROM RL_PATIENT_MAST
               WHERE PATIENT_ID = :nd_hosp_no; */ 

			   /*AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */
}
/*-----------------------------------------------------*/
fetch_pat_name()
{
    rl_pat_title.arr[0]     = '\0';
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
	rl_actual_dob_yn.arr[0]			  = '\0';
	rl_race_code.arr[0]				  = '\0';
	rl_age_years.arr[0]				  = '\0';
	rl_location.arr[0]				  = '\0';

    rl_pat_title.len     = 0;
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
	rl_actual_dob_yn.len				= 0;
	rl_race_code.len					= 0;
	rl_age_years.len					= 0;
	rl_location.len						= 0;

	if(strcmp(rl_hdr_episode_type.arr,"I")==0 || 
       strcmp(rl_hdr_episode_type.arr,"O")==0 ||
	   strcmp(rl_hdr_episode_type.arr,"H")==0 )
    { 

		rl_pat_actual_id.arr[0]   = '\0';
		rl_pat_actual_id.len      = 0;

    /* EXEC SQL OPEN RL_PAT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0024;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )952;
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
    sqlstm.sqhstv[1] = (         void  *)&rl_hdr_spec_regd_date_time;
    sqlstm.sqhstl[1] = (unsigned int  )19;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[2] = (unsigned int  )23;
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
        ins_message(ORA_MESG,"OPEN failed on cursor RL_PAT_MAST_CUR");

    /* EXEC SQL FETCH RL_PAT_MAST_CUR
              INTO :rl_pat_title,
		   :rl_pat_short_name,
                   :rl_pat_sex,
                   :rl_pat_nationality,
                   :rl_pat_dob_no_of_days,
                   :rl_pat_date_of_birth, 
				   :rl_actual_dob_yn,
				   :rl_race_code,
				   :rl_age_years; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )979;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_pat_title;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rl_pat_short_name;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rl_pat_sex;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rl_pat_nationality;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&rl_pat_dob_no_of_days;
    sqlstm.sqhstl[4] = (unsigned int  )12;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&rl_pat_date_of_birth;
    sqlstm.sqhstl[5] = (unsigned int  )18;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_actual_dob_yn;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&rl_race_code;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rl_age_years;
    sqlstm.sqhstl[8] = (unsigned int  )5;
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



	close_mast_cur();

    if (OERROR)
       ins_message(ORA_MESG,"Error with MP_PATIENT_MAST fetch");
    else
	   if(NODATAFOUND)
	   {    
			rl_pat_actual_id.arr[0]   = '\0';
			rl_pat_actual_id.len      = 0;

                /* EXEC SQL OPEN RL_PAT_MAST3_CUR; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 29;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = sq0025;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )1030;
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
                sqlstm.sqhstv[1] = (         void  *)&rl_hdr_spec_regd_date_time;
                sqlstm.sqhstl[1] = (unsigned int  )19;
                sqlstm.sqhsts[1] = (         int  )0;
                sqlstm.sqindv[1] = (         void  *)0;
                sqlstm.sqinds[1] = (         int  )0;
                sqlstm.sqharm[1] = (unsigned int  )0;
                sqlstm.sqadto[1] = (unsigned short )0;
                sqlstm.sqtdso[1] = (unsigned short )0;
                sqlstm.sqhstv[2] = (         void  *)&nd_hosp_no;
                sqlstm.sqhstl[2] = (unsigned int  )23;
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


    		/* EXEC SQL FETCH RL_PAT_MAST3_CUR
              	         INTO   :rl_pat_title,
			        :rl_pat_short_name,
                   		:rl_pat_sex,
                   		:rl_pat_nationality,
                   		:rl_pat_dob_no_of_days,
                   		:rl_pat_date_of_birth,
						:rl_pat_actual_id,
						:rl_actual_dob_yn,
						:rl_race_code,
						:rl_age_years, 
						:rl_location; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1057;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_pat_title;
      sqlstm.sqhstl[0] = (unsigned int  )11;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_pat_short_name;
      sqlstm.sqhstl[1] = (unsigned int  )63;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&rl_pat_sex;
      sqlstm.sqhstl[2] = (unsigned int  )4;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_pat_nationality;
      sqlstm.sqhstl[3] = (unsigned int  )6;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&rl_pat_dob_no_of_days;
      sqlstm.sqhstl[4] = (unsigned int  )12;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&rl_pat_date_of_birth;
      sqlstm.sqhstl[5] = (unsigned int  )18;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&rl_pat_actual_id;
      sqlstm.sqhstl[6] = (unsigned int  )23;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&rl_actual_dob_yn;
      sqlstm.sqhstl[7] = (unsigned int  )4;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&rl_race_code;
      sqlstm.sqhstl[8] = (unsigned int  )7;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&rl_age_years;
      sqlstm.sqhstl[9] = (unsigned int  )5;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&rl_location;
      sqlstm.sqhstl[10] = (unsigned int  )23;
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


               if (OERROR)
                  ins_message(ORA_MESG,"Error with RL_PATIENT_MAST fetch");	
               else
					if(NODATAFOUND);

			close_mast3_cur();

       }
	}
	else
	{
	    rl_pat_actual_id.arr[0]   = '\0';
		rl_pat_actual_id.len      = 0;
             /* EXEC SQL OPEN RL_PAT_MAST3_CUR; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 10;
             sqlstm.arrsiz = 29;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = sq0025;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )1116;
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
             sqlstm.sqhstv[1] = (         void  *)&rl_hdr_spec_regd_date_time;
             sqlstm.sqhstl[1] = (unsigned int  )19;
             sqlstm.sqhsts[1] = (         int  )0;
             sqlstm.sqindv[1] = (         void  *)0;
             sqlstm.sqinds[1] = (         int  )0;
             sqlstm.sqharm[1] = (unsigned int  )0;
             sqlstm.sqadto[1] = (unsigned short )0;
             sqlstm.sqtdso[1] = (unsigned short )0;
             sqlstm.sqhstv[2] = (         void  *)&nd_hosp_no;
             sqlstm.sqhstl[2] = (unsigned int  )23;
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


    		/* EXEC SQL FETCH RL_PAT_MAST3_CUR
              	         INTO   :rl_pat_title,
			        :rl_pat_short_name,
                   		:rl_pat_sex,
                   		:rl_pat_nationality,
                   		:rl_pat_dob_no_of_days,
                   		:rl_pat_date_of_birth,
						:rl_pat_actual_id,
						:rl_actual_dob_yn,
						:rl_race_code, 
						:rl_age_years,
						:rl_location; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1143;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_pat_title;
      sqlstm.sqhstl[0] = (unsigned int  )11;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&rl_pat_short_name;
      sqlstm.sqhstl[1] = (unsigned int  )63;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&rl_pat_sex;
      sqlstm.sqhstl[2] = (unsigned int  )4;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_pat_nationality;
      sqlstm.sqhstl[3] = (unsigned int  )6;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&rl_pat_dob_no_of_days;
      sqlstm.sqhstl[4] = (unsigned int  )12;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&rl_pat_date_of_birth;
      sqlstm.sqhstl[5] = (unsigned int  )18;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&rl_pat_actual_id;
      sqlstm.sqhstl[6] = (unsigned int  )23;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&rl_actual_dob_yn;
      sqlstm.sqhstl[7] = (unsigned int  )4;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&rl_race_code;
      sqlstm.sqhstl[8] = (unsigned int  )7;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&rl_age_years;
      sqlstm.sqhstl[9] = (unsigned int  )5;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&rl_location;
      sqlstm.sqhstl[10] = (unsigned int  )23;
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


               if (OERROR)
                  ins_message(ORA_MESG,"Error with RL_PATIENT_MAST fetch");	
               else
	          if(NODATAFOUND);

			close_mast3_cur();


	}
    rl_pat_title.arr[rl_pat_title.len]                   = '\0';
    rl_pat_long_name.arr[rl_pat_long_name.len]           = '\0';
    rl_pat_short_name.arr[rl_pat_short_name.len]         = '\0';
    rl_pat_long_name.arr[rl_pat_long_name.len]           = '\0';
    rl_pat_short_name.arr[rl_pat_short_name.len]         = '\0';
    rl_pat_sex.arr[rl_pat_sex.len]                       = '\0';
    rl_pat_nationality.arr[rl_pat_nationality.len]       = '\0';
    rl_pat_dob_no_of_days.arr[rl_pat_dob_no_of_days.len] = '\0';
    rl_pat_date_of_birth.arr[rl_pat_date_of_birth.len]   = '\0';
    rl_pat_actual_id.arr[rl_pat_actual_id.len]           = '\0';
	rl_actual_dob_yn.arr[rl_actual_dob_yn.len]			 = '\0';
	rl_race_code.arr[rl_race_code.len]					 = '\0';
	rl_age_years.arr[rl_age_years.len]					 = '\0';
	rl_location.arr[rl_location.len]					 = '\0';

}

/*-----------------------------------------------------*/
fetch_spec_desc()
{


    if (OERROR)
         ins_message(ORA_MESG,"OPEN failed on cursor RL_SPECIMEN_TYPE_CODE_CUR");

    rl_spc_specimen_desc.arr[0] = '\0';
    rl_spc_specimen_desc.len    = 0;

		/* EXEC SQL SELECT SPECIMEN_DESC
				 INTO :rl_spc_specimen_desc
				 FROM RL_SPECIMEN_TYPE_CODE
				 WHERE SPECIMEN_TYPE_CODE = :rl_hdr_specimen_type_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SPECIMEN_DESC into :b0  from RL_SPECIMEN_TYPE_CODE w\
here SPECIMEN_TYPE_CODE=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1202;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&rl_hdr_specimen_type_code;
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



    if (OERROR)
         ins_message(ORA_MESG,"FETCH failed on cursor RL_SPECIMEN_TYPE_CODE_CUR");

    rl_spc_specimen_desc.arr[rl_spc_specimen_desc.len] = '\0';

}
/*-----------------------------------------------------*/

fetch_test_code(loc_tst_code)
char loc_tst_code[];
{
    strcpy(rl_loc_test_code.arr,loc_tst_code);
    rl_loc_test_code.len  =  strlen(rl_loc_test_code.arr);


    if (OERROR)
         ins_message(ORA_MESG,"OPEN failed on cursor RL_TEST_CODE_CUR");

    rl_tst_cd_short_desc.arr[0]         = '\0';
    rl_tst_cd_numeric_result_yn.arr[0]  = '\0';
    rl_tst_cd_age_sex_range_yn.arr[0]   = '\0';
    rl_tst_cd_function_yn.arr[0]        = '\0';
    rl_tst_cd_print_report_yn.arr[0]    = '\0';
    rl_tst_cd_low_value_normal.arr[0]   = '\0';
    rl_tst_cd_high_value_normal.arr[0]  = '\0';
    rl_tst_cd_test_units_2.arr[0]   = '\0';
    rl_tst_cd_group_test_yn.arr[0]      = '\0';
    rl_tst_cd_text_block_yn.arr[0]      = '\0';
    rl_tst_cd_culture_test_yn.arr[0]    = '\0';
    rl_tst_cd_snomed_yn.arr[0]          = '\0';
    rl_tst_cd_range_cmt_2.arr[0]        = '\0';
	rl_tst_cd_inh_rep_yn.arr[0]		    = '\0';
	rl_tst_cd_conf_yn.arr[0]		    = '\0';

    rl_tst_cd_short_desc.len            = 0;
    rl_tst_cd_numeric_result_yn.len     = 0;
    rl_tst_cd_age_sex_range_yn.len      = 0;
    rl_tst_cd_function_yn.len           = 0;
    rl_tst_cd_print_report_yn.len       = 0;
    rl_tst_cd_low_value_normal.len      = 0;
    rl_tst_cd_high_value_normal.len     = 0;
    rl_tst_cd_test_units_2.len      = 0;
    rl_tst_cd_group_test_yn.len         = 0;
    rl_tst_cd_text_block_yn.len         = 0;
    rl_tst_cd_culture_test_yn.len       = 0;
    rl_tst_cd_snomed_yn.len             = 0;
    rl_tst_cd_range_cmt_2.len           = 0;
	rl_tst_cd_inh_rep_yn.len		    = 0;
	rl_tst_cd_conf_yn.len				= 0;

    rl_tst_cd_no_of_decimals = 0;
    rl_tst_cd_significant_digit = 0;

    /* EXEC SQL SELECT LONG_DESC,
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
					 NVL(INHIBIT_REPORT_YN,'N'),
					 NVL(CONFIDENTIAL_YN,'N')    
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
				   :rl_tst_cd_inh_rep_yn,
				   :rl_tst_cd_conf_yn
                FROM RL_TEST_CODE
               WHERE TEST_CODE = :rl_loc_test_code
                 AND INHIBIT_REPORT_YN = 'N'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC ,NUMERIC_RESULT_YN ,AGE_SEX_RANGE_YN ,FU\
NCTION_YN ,PRINT_NAME_YN ,LOW_VALUE_NORMAL ,HIGH_VALUE_NORMAL ,GROUP_TEST_YN ,\
TEXT_BLOCK_YN ,CULTURE_TEST_YN ,SNOMED_YN ,TEST_UNITS ,NVL(NO_OF_DECIMALS,0) ,\
NVL(SIGNIFICANT_DIGIT,0) ,REF_RANGE_COMMENT ,NVL(INHIBIT_REPORT_YN,'N') ,NVL(C\
ONFIDENTIAL_YN,'N') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b1\
2,:b13,:b14,:b15,:b16  from RL_TEST_CODE where (TEST_CODE=:b17 and INHIBIT_REP\
ORT_YN='N')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1225;
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
    sqlstm.sqhstv[15] = (         void  *)&rl_tst_cd_inh_rep_yn;
    sqlstm.sqhstl[15] = (unsigned int  )4;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&rl_tst_cd_conf_yn;
    sqlstm.sqhstl[16] = (unsigned int  )4;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&rl_loc_test_code;
    sqlstm.sqhstl[17] = (unsigned int  )13;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_TEST_CODE_CUR");

    rl_tst_cd_short_desc.arr[rl_tst_cd_short_desc.len] = '\0';
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
    rl_tst_cd_inh_rep_yn.arr[rl_tst_cd_inh_rep_yn.len] = '\0';
	rl_tst_cd_conf_yn.arr[rl_tst_cd_conf_yn.len]	   = '\0';		

    rl_tst_cd_no_of_decimals = rl_tst_cd_no_of_decimals>9?9:
                         rl_tst_cd_no_of_decimals;
    rl_tst_cd_significant_digit = rl_tst_cd_no_of_decimals>9?9:
                         rl_tst_cd_significant_digit;

    if (sqlca.sqlerrd[2]) tst_cd_ind = 1;
    return (sqlca.sqlerrd[2]);
}
/*-----------------------------------------------------*/

fetch_source()
{
    if (rl_hdr_source_type.arr[0] == 'W') 
      {
      /* EXEC SQL  SELECT LONG_DESC
		  INTO :rl_source_short_name
                  FROM IP_WARD
                 WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
				   AND WARD_CODE = :rl_hdr_source_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select LONG_DESC into :b0  from IP_WARD where (FACILITY\
_ID=nvl(:b1,:b2) and WARD_CODE=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1312;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_source_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )43;
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
      sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[2] = (unsigned int  )5;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_hdr_source_code;
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


      }
    else if (rl_hdr_source_type.arr[0] == 'E') 
      {
      /* EXEC SQL  SELECT LONG_DESC,
		       NO_OF_COPIES
		  INTO :rl_source_short_name,
		       :sy_ref_no_of_copies
                  FROM RL_REFERRAL
                 WHERE REFERRAL_CODE = :rl_hdr_source_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select LONG_DESC ,NO_OF_COPIES into :b0,:b1  from RL_RE\
FERRAL where REFERRAL_CODE=:b2";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1343;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_source_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )43;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&sy_ref_no_of_copies;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&rl_hdr_source_code;
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
    else if (rl_hdr_source_type.arr[0] == 'C') 
      {
      /* EXEC SQL  SELECT LONG_DESC
		  INTO :rl_source_short_name
                  FROM OP_CLINIC
                 WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
				   AND CLINIC_CODE = :rl_hdr_source_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select LONG_DESC into :b0  from OP_CLINIC where (FACILI\
TY_ID=nvl(:b1,:b2) and CLINIC_CODE=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1370;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&rl_source_short_name;
      sqlstm.sqhstl[0] = (unsigned int  )43;
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
      sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[2] = (unsigned int  )5;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&rl_hdr_source_code;
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


      }
    else
       ins_message(ORA_MESG,"Invalid Source type in Request Header");
	      
    if (OERROR)
         ins_message(ORA_MESG,"FETCH failed on SOURCE master ");

    rl_source_short_name.arr[rl_source_short_name.len] = '\0';
}
/*-----------------------------------------------------*/

fetch_consultant()
{
    if (rl_hdr_episode_type.arr[0] == 'I') 
      {
      /* EXEC SQL  SELECT FULL_NAME
		  INTO :rl_consultant_short_name
                  FROM SY_PHYSICIAN_MAST
                 WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
				   AND PHYSICIAN_ID = :rl_hdr_consultant_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select FULL_NAME into :b0  from SY_PHYSICIAN_MAST where\
 (FACILITY_ID=nvl(:b1,:b2) and PHYSICIAN_ID=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1401;
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
      sqlstm.sqhstv[1] = (         void  *)&rl_ordered_facility_id;
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
    else if (rl_hdr_episode_type.arr[0] == 'R' || rl_hdr_episode_type.arr[0] == 'H')
      {
      /* EXEC SQL  SELECT LONG_NAME
		  INTO :rl_consultant_short_name
                  FROM RL_CONSULTANTS
                 WHERE REF_CONSULTANT_ID = :rl_hdr_consultant_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select LONG_NAME into :b0  from RL_CONSULTANTS where RE\
F_CONSULTANT_ID=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1432;
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
    else if (rl_hdr_episode_type.arr[0] == 'O') 
      {
      /* EXEC SQL  SELECT FULL_NAME
		  INTO :rl_consultant_short_name
                  FROM SY_PHYSICIAN_MAST
                 WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
				   AND PHYSICIAN_ID = :rl_hdr_consultant_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select FULL_NAME into :b0  from SY_PHYSICIAN_MAST where\
 (FACILITY_ID=nvl(:b1,:b2) and PHYSICIAN_ID=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1455;
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
      sqlstm.sqhstv[1] = (         void  *)&rl_ordered_facility_id;
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
       ins_message(ORA_MESG,"Invalid Episode type in Request Header");
	      
    if (OERROR)
         ins_message(ORA_MESG,"FETCH failed on CONSULTANT Master ");

    rl_consultant_short_name.arr[rl_consultant_short_name.len] = '\0';
}
/*-----------------------------------------------------*/
fetch_section()
{

//    EXEC SQL OPEN RL_SECTION_CUR;

    if (OERROR)
         ins_message(ORA_MESG,"OPEN failed on cursor RL_SECTION_CUR");

    rl_section_short_name.arr[0] 	= '\0';
    rl_section_short_name.len		= 0;
  
    /* EXEC SQL SELECT SUBSTR(LONG_NAME,1,30)
			 INTO :rl_section_short_name
             FROM RL_SECTION_CODE
             WHERE SECTION_CODE = :rl_hdr_section_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SUBSTR(LONG_NAME,1,30) into :b0  from RL_SECTION_C\
ODE where SECTION_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1486;
    sqlstm.selerr = (unsigned short)1;
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
    sqlstm.sqhstv[1] = (         void  *)&rl_hdr_section_code;
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



    rl_section_short_name.arr[rl_section_short_name.len] = '\0';

    if (OERROR)
         ins_message(ORA_MESG,"FETCH failed on cursor RL_SECTION_CUR");

}
/*-----------------------------------------------------*/

fetch_age_sex_range()
{


    if (OERROR)
         ins_message(ORA_MESG,"OPEN failed on cursor RL_AGE_SEX_RANGE_CUR",0,"");

    rl_tst_ran_low_val_nor.arr[0]      = '\0';
    rl_tst_ran_high_val_nor.arr[0]      = '\0';

    rl_tst_ran_low_val_nor.len         = 0;
    rl_tst_ran_high_val_nor.len         = 0;

  /* EXEC SQL SELECT NVL(physician_age_low_value, LOW_VALUE_NORMAL),
                     NVL(physician_age_high_value, HIGH_VALUE_NORMAL)
		   INTO :rl_tst_ran_low_val_nor,
                   :rl_tst_ran_high_val_nor
           FROM RL_AGE_SEX_RANGE
           WHERE TEST_CODE = :rl_tst_test_code
           AND SEX       = :rl_pat_sex
           AND :rl_pat_dob_no_of_days
	          BETWEEN CALC_MIN_AGE_IN_DAYS  AND 
           CALC_MAX_AGE_IN_DAYS; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(physician_age_low_value,LOW_VALUE_NORMAL) ,NVL(p\
hysician_age_high_value,HIGH_VALUE_NORMAL) into :b0,:b1  from RL_AGE_SEX_RANGE\
 where ((TEST_CODE=:b2 and SEX=:b3) and :b4 between CALC_MIN_AGE_IN_DAYS and C\
ALC_MAX_AGE_IN_DAYS)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1509;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&rl_tst_ran_low_val_nor;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&rl_tst_ran_high_val_nor;
  sqlstm.sqhstl[1] = (unsigned int  )18;
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
  sqlstm.sqhstv[3] = (         void  *)&rl_pat_sex;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&rl_pat_dob_no_of_days;
  sqlstm.sqhstl[4] = (unsigned int  )12;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_AGE_SEX_RANGE_CUR",0,"");

    rl_tst_ran_low_val_nor.arr[rl_tst_ran_low_val_nor.len] = '\0';
    rl_tst_ran_high_val_nor.arr[rl_tst_ran_high_val_nor.len] = '\0';
}
/*-----------------------------------------------------*/

open_comments()
{
    /* EXEC SQL OPEN RL_COMM_FOR_TEST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0013;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1544;
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
         ins_message(ORA_MESG,"OPEN failed on cursor RL_COMM_FOR_TEST_CUR");
}
/*-----------------------------------------------------*/
fetch_comments()
{
#ifdef DEBUG
       printf("In fetch_comments() \n");
#endif

    rl_comm_tst_comm_txt.arr[0]     = '\0';
    rl_comm_tst_comm_txt.len        = 0;

    /* EXEC SQL FETCH RL_COMM_FOR_TEST_CUR
              INTO :rl_comm_tst_comm_txt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1563;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_comm_tst_comm_txt;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_COMM_FOR_TEST_CUR");

    rl_comm_tst_comm_txt.arr[rl_comm_tst_comm_txt.len] = '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
print_comment_desc1234()
{
  if (rl_tst_result_comment_desc1.len || rl_tst_result_comment_desc2.len ||
     rl_tst_result_comment_desc3.len || rl_tst_result_comment_desc4.len)
  {  
     something_to_print = 1;
     if(group && !group_printed)
     {   print_group_test_desc();
	     group_printed = 1;
     }
     if(test_printed)
	    numeric_value_flag = TRUE;
     else
	 {
	    numeric_value_flag = FALSE;
        fprintf(fp,"%-40.40s",test_description);
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

fetch_snomed_desc12345()
{
    


    if (OERROR)
         ins_message(ORA_MESG,"OPEN failed on cursor RL_SNOMED_CODE_CUR");

#ifdef DEBUG
       printf("In fetch_snomed_desc1234() \n");
#endif
    rl_snomed_desc1.arr[0]          = '\0';
    rl_snomed_desc2.arr[0]          = '\0';
    rl_snomed_desc3.arr[0]          = '\0';
    rl_snomed_desc4.arr[0]          = '\0';
    rl_snomed_desc5.arr[0]          = '\0';
    rl_snomed_print_yn.arr[0]       = '\0';

    rl_snomed_desc1.len             = 0;
    rl_snomed_desc2.len             = 0;
    rl_snomed_desc3.len             = 0;
    rl_snomed_desc4.len             = 0;
    rl_snomed_desc5.len             = 0;
    rl_snomed_print_yn.len	    = 0;


	/* EXEC SQL SELECT SUBSTR(DESCRIPTION_1, 1, 12),
					 NVL(PRINT_YN, 'N')
              INTO :rl_snomed_desc1,
    		   :rl_snomed_print_yn
             FROM RL_SNOMED_CODE
             WHERE SNOMED_CODE = :rl_res_snomed_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SUBSTR(DESCRIPTION_1,1,12) ,NVL(PRINT_YN,'N') into :b\
0,:b1  from RL_SNOMED_CODE where SNOMED_CODE=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1582;
 sqlstm.selerr = (unsigned short)1;
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
 sqlstm.sqhstv[2] = (         void  *)&rl_res_snomed_code;
 sqlstm.sqhstl[2] = (unsigned int  )23;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_SNOMED_CODE_CUR");

    rl_snomed_desc1.arr[rl_snomed_desc1.len] = '\0';
    rl_snomed_desc2.arr[rl_snomed_desc2.len] = '\0';
    rl_snomed_desc3.arr[rl_snomed_desc3.len] = '\0';
    rl_snomed_desc4.arr[rl_snomed_desc4.len] = '\0';
    rl_snomed_desc5.arr[rl_snomed_desc5.len] = '\0';
    rl_snomed_print_yn.arr[rl_snomed_print_yn.len] = '\0';

   return (sqlca.sqlerrd[2]);
}
/*-----------------------------------------------------*/
print_snomed_desc12345()
{
  if(rl_snomed_desc1.len  || rl_snomed_desc2.len  ||
     rl_snomed_desc3.len  || rl_snomed_desc4.len  || 
     rl_snomed_desc5.len  || rl_snomed2_desc1.len || 
	 rl_snomed2_desc2.len || rl_snomed2_desc3.len || 
	 rl_snomed2_desc4.len || rl_snomed2_desc5.len ) 
  {
  
    something_to_print = 1;

    if(group && !group_printed)
    {   print_group_test_desc();
	group_printed = 1;
    }
    if(!test_printed)
    {
       fprintf(fp,"%-40.40s\n",test_description);
       test_printed = 1;
    }

/****************************/

	print_snomed_codes('Y');
	fprintf(fp, " - ");
/**************************/

	if (rl_snomed_desc1.len != 0 && rl_snomed_print_yn.arr[0] == 'Y')
    {
		 fprintf(fp,"%-20s",rl_snomed_desc1.arr);
		 fprintf(fp, " | ");
		 if (rl_snomed2_desc1.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
		 {
			fprintf(fp, "\n");
			page_break(1);
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

	if (rl_snomed2_desc1.len != 0 && rl_snomed2_print_yn.arr[0] == 'Y')
	{
			fprintf(fp,"%s\n",rl_snomed2_desc1.arr);
			page_break(1);
	}
	    
/*-----------------------*/    
    if (rl_snomed_desc2.len != 0 && rl_snomed_print_yn.arr[0] == 'Y')
    {
		 print_snomed_codes('N');	
		 fprintf(fp, " - ");
		 fprintf(fp,"%-20s",rl_snomed_desc2.arr);
		 fprintf(fp, " | ");
		 if (rl_snomed2_desc2.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
		 {
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
			fprintf(fp,"%s\n",rl_snomed2_desc2.arr);
			page_break(1);
	}
    
/*-----------------------*/    

    if (rl_snomed_desc3.len != 0 && rl_snomed_print_yn.arr[0] == 'Y')
    {

		print_snomed_codes('N');	
		fprintf(fp, " - ");
		fprintf(fp,"%-20s",rl_snomed_desc3.arr);
		fprintf(fp, " | ");
		if (rl_snomed2_desc3.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
		{
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
	        fprintf(fp,"%s\n",rl_snomed2_desc3.arr);
			page_break(1);
	}

/*-----------------------*/        

    if (rl_snomed_desc4.len != 0 && rl_snomed_print_yn.arr[0] == 'Y')
    {
		 print_snomed_codes('N');	
		 fprintf(fp, " - ");
		 fprintf(fp,"%-20s",rl_snomed_desc4.arr);
		 fprintf(fp, " | ");
		 if (rl_snomed2_desc4.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
		 {
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
			fprintf(fp,"%s\n",rl_snomed2_desc4.arr);
			page_break(1);
	}

/*-----------------------*/            

	if (rl_snomed_desc5.len != 0 && rl_snomed_print_yn.arr[0] == 'Y')	
	{
			print_snomed_codes('N');	
			fprintf(fp, " - ");
			fprintf(fp,"%-20s",rl_snomed_desc5.arr);
			fprintf(fp, " | ");
			if (rl_snomed2_desc5.len == 0 || rl_snomed2_print_yn.arr[0] == 'N')
			{
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

			fprintf(fp,"%s\n",rl_snomed2_desc5.arr);
			page_break(1);
	}

  
/************* old snomed logic *****************
    if (rl_snomed_desc1.len != 0)
    {
         fprint_repeat(fp,' ',40);
         fprintf(fp,"%s\n",rl_snomed_desc1.arr);
         page_break(1);
    }
    if (rl_snomed_desc2.len != 0)
    {
         fprint_repeat(fp,' ',40);
         fprintf(fp,"%s\n",rl_snomed_desc2.arr);
         page_break(1);
    }
    if (rl_snomed_desc3.len != 0)
    {
         fprint_repeat(fp,' ',40);
         fprintf(fp,"%s\n",rl_snomed_desc3.arr);
         page_break(1);
    }
    if (rl_snomed_desc4.len != 0)
    {
         fprint_repeat(fp,' ',40);
         fprintf(fp,"%s\n",rl_snomed_desc4.arr);
         page_break(1);
    }
    if (rl_snomed_desc5.len != 0)
    {
         fprint_repeat(fp,' ',40);
         fprintf(fp,"%s\n",rl_snomed_desc5.arr);
         page_break(1);
    }
************* UPTO HERE old snomed logic *****************/


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
    if (lctr == 0 || lctr > MAX_LINES)
    {
       if (lctr != 0)
	   {
		   if (strcmp(rl_report_format.arr, "1") == 0)
               print_footer(1);
		   else
			  print_footer1(1); 	
		}

       if (strcmp(rl_report_format.arr, "1") == 0)
			print_header();
	   else
			print_header1();

    }
}
/*-----------------------------------------------------*/
open_result_text()
{
    /* EXEC SQL OPEN RL_RESULT_TEXT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0014;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1609;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_hosp_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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
         ins_message(ORA_MESG,"OPEN failed on cursor RL_RESULT_TEXT_CUR");
}
/*-----------------------------------------------------*/

fetch_result_text()
{
#ifdef DEBUG
       printf("In fetch_result_text() \n");
#endif

    rl_res_result_text.arr[0]  = '\0';

    /* EXEC SQL FETCH RL_RESULT_TEXT_CUR
              INTO rl_res_result_text ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1644;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_RESULT_TEXT_CUR",0,"");

    rl_res_result_text.arr[rl_res_result_text.len] = '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
calc_func_and_prn(l_str,l_str2)
char l_str[],l_str2[];
{
   int func_ctr = 0;

   strcpy(rl_loc_test_code.arr,l_str);
   rl_loc_test_code.len = strlen(rl_loc_test_code.arr);
   open_function_cur();
   strcpy(rl_func_str.arr,"");
   _flushall();
   while (fetch_function_cur())
   {
        func_ctr ++;
        strcpy(rl_func_value.arr,rl_func_operand_1.arr);

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
   
	close_function_cur();

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
/*-----------------------------------------------------*/

open_function_cur()
{
    /* EXEC SQL OPEN RL_FUNCTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0015;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1663;
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
         ins_message(ORA_MESG,"OPEN failed on cursor RL_FUNCTION_CUR");
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
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1682;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_FUNCTION_CUR");

    rl_func_operand_1.arr[rl_func_operand_1.len]           = '\0';
    rl_func_operand_1_type.arr[rl_func_operand_1_type.len] = '\0';
    rl_func_operator_1.arr[rl_func_operator_1.len]         = '\0';
    rl_func_operand_2.arr[rl_func_operand_2.len]           = '\0';
    rl_func_operand_2_type.arr[rl_func_operand_2_type.len] = '\0';
    rl_func_operator_2.arr[rl_func_operator_2.len]         = '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/

calculate_value()
{
    sprintf(rl_calc_str.arr,"SELECT %s FROM DUAL",rl_func_str.arr);
    rl_calc_str.len = strlen(rl_calc_str.arr);
    /* EXEC SQL PREPARE STR1 FROM :rl_calc_str; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1721;
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
         ins_message(ORA_MESG,"PREPARE failed on table DUAL");

    /* EXEC SQL DECLARE CUR1 CURSOR FOR STR1; */ 


    /* EXEC SQL OPEN CUR1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1740;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         ins_message(ORA_MESG,"OPEN failed on cursor CUR1");

    rl_func_str.arr[0] = '\0';
    rl_func_str.len    = 0;

    /* EXEC SQL FETCH CUR1
              INTO :rl_func_str; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1755;
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
         ins_message(ORA_MESG,"FETCH failed on cursor CUR1");

    rl_func_str.arr[rl_func_str.len] = '\0';
    strcat(rl_func_str.arr," ");

	close_cur1_cur();

}
/*-----------------------------------------------------*/
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
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NUMERIC_RESULT into :b0  from RL_TEST_RESULT where\
 (((PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) and TES\
T_CODE=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1774;
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
    sqlstm.sqhstl[1] = (unsigned int  )23;
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
	       ins_message(ORA_MESG,"Error occurred at get_rl_test_result() Test not found.");
       proc_exit();
    }
*/
    rl_func_value.arr[rl_func_value.len] = '\0';

    if(strlen(rl_func_value.arr) == 0)
       test_result_found = 0;

    return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   ins_message(ORA_MESG,"Error occurred at get_rl_test_result()");
   return;

}
/*-----------------------------------------------------*/
print_footer(foot_ind)
int foot_ind;
{
   int fi = 0;
   char l_str[100];
   l_str[0] = '\0'; 

   for(fi=0; fi < 87; fi++)
       fprintf(fp,"%c",'_');

   fprintf(fp,"\n");

   fflush(fp);

   /*----------------------------------------*/
   fprintf(fp,"%c&k4S",ESC); 
   fprintf(fp,"%c(s4B",ESC);
   fprintf(fp,"Release Date : ");
   fprintf(fp,"%c&k4S",ESC); 
   fprintf(fp,"%c(s-3B",ESC);   
   sprintf(l_str,"%s",rl_hdr_released_date.arr);
   fprintf(fp,"%-25.25s",l_str);
   /*----------------------------------------*/

   /*----------------------------------------*/
   fprintf(fp,"%c&k4S",ESC); 
   fprintf(fp,"%c(s4B",ESC);
   fprintf(fp,"Released/Reviewed By : ");
   fprintf(fp,"%c&k4S",ESC); 
   fprintf(fp,"%c(s-3B",ESC);   
   fprintf(fp,"%-s\n",rl_hdr_released_by_id.arr);
   /*----------------------------------------*/

   /*----------------------------------------*/
   fprintf(fp,"%c&k4S",ESC); 
   fprintf(fp,"%c(s4B",ESC);
   fprintf(fp,"Reprint Date : ");
   fprintf(fp,"%c&k4S",ESC); 
   fprintf(fp,"%c(s-3B",ESC);   
   /*----------------------------------------*/
   
   if (rl_prn_ctrl_hdr_rp_yn.arr[0] == 'Y')
       sprintf(l_str,"%-16.16s         ",nd_result_printed_date.arr);
   else
       sprintf(l_str,"%-16.16s         ",nd_result_printed_date.arr);
   fprintf(fp,"%s",nd_result_printed_date.arr);

   /*----------------------------------------*/

   if (rl_hdr_extra_copies_to.len && copy == 2 ) 
   {
      /*----------------------------------------*/
      fprintf(fp,"%c&k4S",ESC); 
      fprintf(fp,"%c(s4B",ESC);
      fprintf(fp,"Copy To : ");
      fprintf(fp,"%c&k4S",ESC); 
      fprintf(fp,"%c(s-3B",ESC);   
      /*----------------------------------------*/

      sprintf(l_str,"%24.24s",rl_hdr_extra_copies_to.arr);
   }
   else
      sprintf(l_str,"%34.34s"," ");

   fprintf(fp,"%s\n",l_str);

   if(last_page == 0)
      sprintf(l_str,"%-73.73s--CONTINUED--"," ");
   else
      sprintf(l_str,"%-73.73s      --END--"," ");

   fprintf(fp,"%s\f",l_str);

   lctr = 0;
  
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
/*--- The following IF splits the result into two parts : INTEGER & DECIMAL --*/
  /* EXEC SQL SELECT INSTR(:d_loc_str,'.') INTO :d_dec_pos FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select INSTR(:b0,'.') into :b1  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1809;
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


  if(d_dec_pos > 0)
  {
      /* EXEC SQL SELECT SUBSTR(:d_loc_str,1,:d_dec_pos - 1) 
		 INTO :d_int_part
		 FROM DUAL; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select SUBSTR(:b0,1,(:b1-1)) into :b2  from DUAL ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1832;
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
         sqlstm.arrsiz = 29;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select SUBSTR(:b0,(:b1+1),LENGTH(:b0)) into :b3  fro\
m DUAL ";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )1859;
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
	  /* EXEC SQL SELECT SUBSTR(:d_int_part,1,1) INTO :d_sig_part
		     FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 29;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(:b0,1,1) into :b1  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1890;
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
	  /* EXEC SQL SELECT 1
		     INTO :d_after_sig_digit FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 29;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select 1 into :b0  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1913;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_after_sig_digit;
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


	  if(d_after_sig_digit >= 5)
	  {
	     /* EXEC SQL SELECT TO_CHAR(TO_NUMBER(:d_sig_part) + 1)
			INTO :d_sig_part FROM DUAL; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select TO_CHAR((TO_NUMBER(:b0)+1)) into :b0  from DUAL ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1932;
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
          }
          /* EXEC SQL SELECT RPAD(:d_sig_part,LENGTH(:d_int_part),'0')
		     INTO :d_l_str FROM DUAL; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 29;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "select RPAD(:b0,LENGTH(:b1),'0') into :b2  from DUA\
L ";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )1955;
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
       }
    }
    else
    {
       strcpy(d_l_str.arr,d_int_part.arr);
    }
}         
/*-- This IF is to take care of the INTEGER part of the Result ---------------*/
if(strlen(d_dec_part.arr))
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
        /* EXEC SQL SELECT  '1'
//		:d_l_str || SUBSTR(:d_dec_part,1,no_of_dec)
                   INTO :d_l_str FROM DUAL; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 29;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select '1' into :b0  from DUAL ";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1982;
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
  strcpy(loc_str,d_l_str.arr);
}
/*-----------------------------------------------------*/

split_num(l_str,l_var1,l_var2)
char l_str[];
char *l_var1, *l_var2;
{
  int i=0,j=0;
  for (i=0;(l_str[i]!='\0' && l_str[i] != '.');i++,l_var1++)
     *l_var1 = l_str[i];
  *l_var1 = '\0';
  for (i++,j=0;(l_str[i]!='\0');i++,j++,l_var2++)
     *l_var2 = l_str[i];
  *l_var2 = '\0';
}
/*----------------------------------------------------------*/
update_rl_request_header()
{
     /* EXEC SQL SELECT COUNT(*) INTO :c_count
              FROM   RL_REQUEST_DETAIL
              WHERE  SPECIMEN_NO = :c_spec_no 
	          AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		      AND    NVL(RESULT_STATUS,' ') != 'P'; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 29;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select count(*)  into :b0  from RL_REQUEST_DETAIL where \
((SPECIMEN_NO=:b1 and OPERATING_FACILITY_ID=:b2) and NVL(RESULT_STATUS,' ')<>'\
P')";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2001;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&c_count;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&c_spec_no;
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
	 ;
         if (OERROR)
              ins_message(ORA_MESG,"Failed in function update_rl_request_header()");
         c_count.arr[c_count.len] ='\0';
         if(atoi(c_count.arr) == 0)
	     /* EXEC SQL UPDATE RL_REQUEST_HEADER 
		         SET STATUS = 'P',
				 RESULT_PRINTED_DATE = to_date(:nd_result_printed_date,'DD/MM/YYYY HH24:MI:SS'),
			     MODIFIED_BY_ID = USER,
			     MODIFIED_DATE = SYSDATE
		       WHERE SPECIMEN_NO = :c_spec_no
			   AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update RL_REQUEST_HEADER  set STATUS='P',RESULT_PRINTED\
_DATE=to_date(:b0,'DD/MM/YYYY HH24:MI:SS'),MODIFIED_BY_ID=USER,MODIFIED_DATE=S\
YSDATE where (SPECIMEN_NO=:b1 and OPERATING_FACILITY_ID=:b2)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2028;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_result_printed_date;
      sqlstm.sqhstl[0] = (unsigned int  )23;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&c_spec_no;
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
              ins_message(ORA_MESG,"Failed in function update_rl_request_header()");
}
/*----------------------------------------------------------*/
update_rl_request_detail()
{   
    int fetch_c_rl_request_detail();
    strcpy(sql_stmt.arr,"SELECT TEST_CODE, GROUP_TEST_YN FROM RL_REQUEST_DETAIL WHERE SPECIMEN_NO = :v1 AND OPERATING_FACILITY_ID = :nd_operating_facility_id for update of result_status NOWAIT");
    sql_stmt.len = strlen(sql_stmt.arr);
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2055;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sql_stmt;
    sqlstm.sqhstl[0] = (unsigned int  )2002;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


    /* EXEC SQL DECLARE C CURSOR FOR S; */ 

    /* EXEC SQL OPEN C USING :c_spec_no; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2074;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&c_spec_no;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	if (RESOURCE_BUSY)
	{
		ins_message(ORA_MESG,"OPEN failed resource busy rl_request_detail");
	}

	
    while(1)
    {
	  /* EXEC SQL FETCH C INTO :c_req_dtl_test_code,:c_group_test_yn; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 29;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2093;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&c_req_dtl_test_code;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&c_group_test_yn;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


	  if(NODATAFOUND)
	     return;
          c_req_dtl_test_code.arr[c_req_dtl_test_code.len] = '\0';
          c_group_test_yn.arr[c_group_test_yn.len] = '\0';
          /* EXEC SQL SELECT NVL(COUNT(*),0) INTO :c_count
		   FROM   RL_TEST_RESULT
		   WHERE  SPECIMEN_NO = :c_spec_no 
		   AND    OPERATING_FACILITY_ID = :nd_operating_facility_id
		   AND    GROUP_TEST_CODE = :c_req_dtl_test_code
		   AND    NVL(STATUS,' ') != 'P'; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 29;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "select NVL(count(*) ,0) into :b0  from RL_TEST_RESU\
LT where (((SPECIMEN_NO=:b1 and OPERATING_FACILITY_ID=:b2) and GROUP_TEST_CODE\
=:b3) and NVL(STATUS,' ')<>'P')";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )2116;
          sqlstm.selerr = (unsigned short)1;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&c_count;
          sqlstm.sqhstl[0] = (unsigned int  )5;
          sqlstm.sqhsts[0] = (         int  )0;
          sqlstm.sqindv[0] = (         void  *)0;
          sqlstm.sqinds[0] = (         int  )0;
          sqlstm.sqharm[0] = (unsigned int  )0;
          sqlstm.sqadto[0] = (unsigned short )0;
          sqlstm.sqtdso[0] = (unsigned short )0;
          sqlstm.sqhstv[1] = (         void  *)&c_spec_no;
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
          sqlstm.sqhstv[3] = (         void  *)&c_req_dtl_test_code;
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
          if (sqlca.sqlcode < 0) goto err_exit;
}


         if(NODATAFOUND)
	       ;
         if (OERROR)
              ins_message(ORA_MESG,"Failed at Select RL_TEST_RESULT in c_request_detail_cur");
         c_count.arr[c_count.len] ='\0';
         if(atoi(c_count.arr) == 0)
	     /* EXEC SQL UPDATE RL_REQUEST_DETAIL 
		         SET RESULT_STATUS = 'P',
				 RESULT_PRINTED_DATE = to_date(:nd_result_printed_date,'DD/MM/YYYY HH24:MI:SS'),
			     MODIFIED_BY_ID = USER,
			     MODIFIED_DATE = SYSDATE
		         WHERE SPECIMEN_NO = :c_spec_no 
			     AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		         AND TEST_CODE = :c_req_dtl_test_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 29;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update RL_REQUEST_DETAIL  set RESULT_STATUS='P',RESULT_\
PRINTED_DATE=to_date(:b0,'DD/MM/YYYY HH24:MI:SS'),MODIFIED_BY_ID=USER,MODIFIED\
_DATE=SYSDATE where ((SPECIMEN_NO=:b1 and OPERATING_FACILITY_ID=:b2) and TEST_\
CODE=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2147;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_result_printed_date;
      sqlstm.sqhstl[0] = (unsigned int  )23;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&c_spec_no;
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
      sqlstm.sqhstv[3] = (         void  *)&c_req_dtl_test_code;
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
      if (sqlca.sqlcode < 0) goto err_exit;
}


         if (OERROR)
              ins_message(ORA_MESG,"Failed at update rl_request_detail");
    }

	close_c_cur();

    return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   ins_message(ORA_MESG,"Error occurred at update_rl_request_detail()");
   return;
}
/*----------------------------------------------------------*/
close_all_cur()
{
    /* EXEC SQL CLOSE RL_REQ_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2178;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RL_REQ_DTL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2193;
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
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2208;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2223;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

ins_message(int msg_type,char msg[])
{
   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   
   er_msg_type = 0;

   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(msg);
 
   er_msg_type = msg_type;
   /* EXEC SQL
   INSERT INTO SY_PROG_MSG
          (OPERATING_FACILITY_ID,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
          (:nd_operating_facility_id,'RLRRSENQ',:er_msg_type,NULL,:er_msg,SYSDATE,:sy_session_id,
		   :sy_req_date); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 29;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'RLRRSENQ\
',:b1,null ,:b2,SYSDATE,:b3,:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2238;
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
   sqlstm.sqhstv[2] = (         void  *)&er_msg;
   sqlstm.sqhstl[2] = (unsigned int  )73;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&sy_session_id;
   sqlstm.sqhstl[3] = (unsigned int  )32;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&sy_req_date;
   sqlstm.sqhstl[4] = (unsigned int  )32;
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


   err_flag = 1;
}

/* SPLITTING THE VARCHAR 2000 INTO 70 CHARACTERS   */
/************************************************/
splitting()
{
  
    int fetch_result_text();
	char word[2];

    strcpy(word1,"F");
	_flushall();
    while(fetch_result_text())
    {
		  something_to_print = 1;
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
		              fprintf(fp,"%c",rl_res_result_text.arr[i]);
				
			       }
			       fprintf	(fp,"\n");
				   page_break(1);
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
			         fprintf(fp,"%c",rl_res_result_text.arr[i]);
					
			      }
                              page_break(1);                                 
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
		             fprintf(fp,"%c",rl_res_result_text.arr[i]);
				
			      }

			       fprintf	(fp,"\n");
				   page_break(1);
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
		              fprintf(fp,"%c",rl_res_result_text.arr[i]);
				
			       }

			       fprintf(fp,"\n");
				   page_break(1);
				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }

		  
            cntr += 1;
	        z++ ;
          }

		
      }

	  close_text_cur();
  
       fflush(fp);

#ifdef DEBUG
   printf("rl_res_result_text = %s\n", rl_res_result_text.arr);
#endif

if (OERROR)
   ins_message(ORA_MESG,"Error occurred at splitting()");

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   ins_message(ORA_MESG,"Error occurred at splitting()");
   return;

}
set_printed_date_time()
{
 /* Trapping the result printed date/time into a variable */
 nd_result_printed_date.arr[0] = '\0';
 nd_result_printed_date.len = 0;
 /* EXEC SQL SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') 
            INTO :nd_result_printed_date
			FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') into :b0  fr\
om DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2273;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_result_printed_date;
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

  
 nd_result_printed_date.arr[nd_result_printed_date.len] = '\0';

 return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   ins_message(ORA_MESG,"Error occurred at set_printed_date_time()");
   return;
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


	/* EXEC SQL SELECT FLOOR(TO_NUMBER(:rl_tst_ran_high_val_nor)),
				FLOOR(TO_NUMBER(:rl_tst_ran_low_val_nor))
		     INTO :l_high, :l_low
			 FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select FLOOR(TO_NUMBER(:b0)) ,FLOOR(TO_NUMBER(:b1)) into :b2\
,:b3  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2292;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_tst_ran_high_val_nor;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_tst_ran_low_val_nor;
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



	strcpy(l_low_val.arr, rl_tst_ran_low_val_nor.arr);
	l_low_val.len = strlen(l_low_val.arr);

	strcpy(l_high_val.arr, rl_tst_ran_high_val_nor.arr);
	l_high_val.len = strlen(l_high_val.arr);

	if (l_low == 0)
	{
		strcpy(rl_tst_ran_low_val_nor.arr, "0");

		if (strcmp(l_low_val.arr, "0") != 0)
			strcat(rl_tst_ran_low_val_nor.arr, l_low_val.arr);

		rl_tst_ran_low_val_nor.len = strlen(rl_tst_ran_low_val_nor.arr);
	}

	if (l_high == 0)
	{
		strcpy(rl_tst_ran_high_val_nor.arr, "0");

		if (strcmp(l_high_val.arr, "0") != 0)
			strcat(rl_tst_ran_high_val_nor.arr, l_high_val.arr);

		rl_tst_ran_high_val_nor.len = strlen(rl_tst_ran_high_val_nor.arr);
	}


    l_low_val.arr[0]		= '\0';
	l_low_val.len			= 0;

	l_high_val.arr[0]		= '\0';
	l_high_val.len			= 0;

	l_low = 0;
	l_high = 0;


}
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
				AND NVL(A.status, 'O') IN ('R', :nd_status); */ 


	/* EXEC SQL OPEN int_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0055;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2323;
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



	while(fetch_int_curs())
	{

		/* EXEC SQL SELECT COUNT(*)
				 INTO :i_count
				 FROM RL_INTERVAL_TEST_SPECIMENS
				 WHERE interval_test_specimen_no = TO_NUMBER(:d_no) 
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND NVL(cancelled_yn, 'N') <> 'Y'
				 AND NVL(status, 'O') NOT IN ('R', 'P'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_SPECIMENS \
where (((interval_test_specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b\
2) and NVL(cancelled_yn,'N')<>'Y') and NVL(status,'O') not  in ('R','P'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2350;
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
  sqlstm.sqhstv[1] = (         void  *)&d_no;
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
								(:nd_operating_facility_id,'RLRRSENQ', 1, TO_NUMBER(:d_specimen_no), 
								 :d_group_test_code, :d_test_code, :d_seq_no); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into RL_INTERVAL_TEST_TEMP (operating_facility_id,\
user_id,session_id,specimen_no,group_test_code,test_code,seq_no) values (:b0,'\
RLRRSENQ',1,TO_NUMBER(:b1),:b2,:b3,:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2377;
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
				AND NVL(result_status, 'O') IN ('R', :nd_status); */ 

		   	    

	/* EXEC SQL OPEN req_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0058;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2412;
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
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_SPECIMENS \
where (((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and NVL(can\
celled_yn,'N')<>'Y') and group_test_code=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2439;
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
							(:nd_operating_facility_id,'RLRRSENQ', 1, TO_NUMBER(:nd_spec_no), 
									:d_group_test_code); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 29;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into RL_INTERVAL_TEST_TEMP (operating_facility_id,u\
ser_id,session_id,specimen_no,group_test_code) values (:b0,'RLRRSENQ',1,TO_NUM\
BER(:b1),:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2470;
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

	if (d_interval_specimen_yn == 'N')
	{
	   strcpy(first_specimen_no.arr, nd_spec_no.arr);
	   first_specimen_no.len = strlen(first_specimen_no.arr);

	}

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
		   	    ORDER BY A.specimen_no; */ 


		/* EXEC SQL OPEN spec_curs; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0061;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2497;
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
				 INTO :d_specimen_no, :d_group_test_code, :d_test_code,
				 :d_seq_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2520;
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
			ins_message(ORA_MESG,"FETCH failed on cursor specimen_curs");

	
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2551;
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
			ins_message(ORA_MESG,"FETCH failed on cursor int_curs");

	
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2570;
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
			ins_message(ORA_MESG,"FETCH failed on cursor req_curs");

	
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2589;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2604;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2619;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
/*------------------------------------------------------------*/
update_interval_specimen()
{
	/* EXEC SQL SELECT COUNT(*)
			 INTO :u_count
			 FROM RL_INTERVAL_TEST_SPECIMENS
			 WHERE specimen_no = TO_NUMBER(:nd_spec_no)
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND NVL(cancelled_yn, 'N') <> 'Y'
			 AND test_code = :rl_tst_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(*)  into :b0  from RL_INTERVAL_TEST_SPECIMENS w\
here (((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b2) and NVL(canc\
elled_yn,'N')<>'Y') and test_code=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2634;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&u_count;
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


	
	if (u_count > 0)
	{
		/* EXEC SQL UPDATE RL_INTERVAL_TEST_SPECIMENS
				 SET status = 'P'
				 WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND specimen_no = TO_NUMBER(:nd_spec_no)
				 AND test_code = :rl_tst_test_code
				 AND NVL(cancelled_yn, 'N') <> 'Y'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update RL_INTERVAL_TEST_SPECIMENS  set status='P' where (((\
OPERATING_FACILITY_ID=:b0 and specimen_no=TO_NUMBER(:b1)) and test_code=:b2) a\
nd NVL(cancelled_yn,'N')<>'Y')";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2665;
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
  sqlstm.sqhstv[2] = (         void  *)&rl_tst_test_code;
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
/*------------------------------------------------------------*/
delete_build_table()
{
	/* EXEC SQL DELETE FROM RL_INTERVAL_TEST_TEMP
			 WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND user_id = 'RLRRSENQ'
			 AND session_id = 1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from RL_INTERVAL_TEST_TEMP  where ((OPERATING_FACILI\
TY_ID=:b0 and user_id='RLRRSENQ') and session_id=1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2692;
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
			 WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND user_id = 'RLRRSENQ'
			 AND session_id = 2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from RL_INTERVAL_TEST_TEMP  where ((OPERATING_FACILI\
TY_ID=:b0 and user_id='RLRRSENQ') and session_id=2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2711;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select description into :b0  from RL_INTERVAL_TEST_DESC wher\
e (test_code=:b1 and seq_no=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2730;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0067;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2757;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2784;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2799;
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
			ins_message(ORA_MESG,"FETCH failed on cursor first_specimen_curs");

	
		first_specimen_no.arr[first_specimen_no.len]		= '\0';

	return (LAST_ROW?0:1);
	 
}
/*------------------------------------------------------------*/

close_comments_curs()
{

	/* EXEC SQL CLOSE RL_COMM_FOR_TEST_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2818;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor RL_COMM_FOR_TEST_CUR");

}

close_text_cur()
{
	/* EXEC SQL CLOSE RL_RESULT_TEXT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2833;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor RL_RESULT_TEXT_CUR");

}

close_function_cur()
{
	/* EXEC SQL CLOSE RL_FUNCTION_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2848;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor RL_FUNCTION_CUR");

}

close_snomed_cur()
{

	/* EXEC SQL CLOSE RL_RESULT_SNOMED_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2863;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor RL_RESULT_SNOMED_CUR");

}

close_organism_cur()
{

	/* EXEC SQL CLOSE RL_RESULT_ORGANISM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2878;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor RL_RESULT_ORGANISM_CUR");

}

close_antibiotic_cur()
{
	/* EXEC SQL CLOSE RL_ANTIBIOTIC_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2893;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor RL_ANTIBIOTIC_CUR");

}

close_cur1_cur()
{
	/* EXEC SQL CLOSE CUR1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2908;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor CUR1");

}

close_mast_cur()
{

	/* EXEC SQL CLOSE RL_PAT_MAST_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2923;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor RL_PAT_MAST_CUR");

}


close_mast3_cur()
{
	
	/* EXEC SQL CLOSE RL_PAT_MAST3_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2938;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor RL_PAT_MAST3_CUR");

}

close_c_cur()
{
	
	/* EXEC SQL CLOSE C; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2953;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		ins_message(ORA_MESG,"CLOSE failed on cursor C");

}

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

/******************************************************************************************/
get_race_desc()
{
	
	d_race_desc.arr[0]		= '\0';
	d_race_desc.len			= 0;

	/* EXEC SQL SELECT short_desc
		     INTO :d_race_desc
			 FROM MP_RACE
			 WHERE race_code = :rl_race_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from MP_RACE where race_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2968;
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



	if (NODATAFOUND);

	d_race_desc.arr[d_race_desc.len]			= '\0';
	
}


/******************************************************************************************/
print_clinical_history()
{

	int ctr = 0;
	int len = 0;
	int r_ctr = 0;

	char l_string[100];

		/* EXEC SQL DECLARE rl_clinical_cur CURSOR FOR
				 SELECT specimen_no, clinical_text_code, SUBSTR(clinical_text, 1, 4000) 
				 FROM RL_PATIENT_CLINICAL_TEXT
				 WHERE specimen_no IN (SELECT distinct specimen_no
							FROM RL_INTERVAL_TEST_TEMP
							WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
							AND user_id = 'RLRRSENQ' 
							AND session_id = 1 )
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 ORDER BY specimen_no; */ 


		/* EXEC SQL OPEN rl_clinical_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0069;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2991;
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



		ctr = 0;
		while(fetch_clinical_text())
		{

			len = strlen(d_clinical_text.arr);
			if (strlen(d_clinical_text.arr) > 0)
			{
			   
			   split_text(d_clinical_text.arr, 79, l_string, &r_ctr);

  			   if (d_interval_specimen_yn == 'Y')
			   {
			  	  fprintf(fp, "Specimen No : %-15s", d_clinical_spec_no.arr);
			   }

				if (ctr == 0)
				{

					if (strlen(l_string) > 0 )
					{
						page_break(1);
						fprintf(fp,"%c&k4S",ESC); 
						fprintf(fp,"%c(s4B",ESC);
						fprintf(fp, "Clinical History\n");
						fprintf(fp,"%c&k4S",ESC); 
						fprintf(fp,"%c(s-3B",ESC);
						
					}
				}

				fprintf(fp,"       %s\n",l_string);  
				page_break(1);

				while(r_ctr <= len)
				{	
					page_break(1);
					split_text(d_clinical_text.arr, 79, l_string, &r_ctr);
					fprintf(fp,"       %s\n",l_string);  
					page_break(1);

					strcpy(l_string, "");

				}
			
				ctr++;
			}
		}

		/* EXEC SQL CLOSE rl_clinical_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3014;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

/******************************************************************************************/
fetch_clinical_text()
{

	d_clinical_text_code.arr[0]		= '\0';
	d_clinical_text_code.len		= 0;
	d_clinical_spec_no.arr[0]		= '\0';
	d_clinical_spec_no.len			= 0;

	d_clinical_text.arr[0]			= '\0';
	d_clinical_text.len				= 0;

    /* EXEC SQL FETCH rl_clinical_cur
              INTO :d_clinical_spec_no,
				   :d_clinical_text_code, 
				   :d_clinical_text; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3029;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_clinical_spec_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_clinical_text_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_clinical_text;
    sqlstm.sqhstl[2] = (unsigned int  )4002;
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
         ins_message(ORA_MESG,"FETCH failed on cursor RL_PATIENT_CLINICAL_TEXT");


	d_clinical_spec_no.arr[d_clinical_spec_no.len]			= '\0';
	d_clinical_text_code.arr[d_clinical_text_code.len]		= '\0';
	d_clinical_text.arr[d_clinical_text.len]				= '\0';

    return (LAST_ROW?0:1);
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(inhibit_report_yn,'N') into :b0  from RL_TEST_COD\
E where test_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3056;
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
print_header1()
{

    char t_patient_id[16];   
    char sex_desc[11];
	char pat_name[61];
	char uline[82];
	char l_str[100];
    int i;
	char l_age_legend[5];

    pctr++;
    
    get_parameters();

/*---------*/
    fprintf(fp,"%c&a006L",ESC); /* Set the left Margin */
	fprintf(fp,"%c&k12S",ESC);	/* This makes the font size to increase to 12 */
	fprintf(fp,"%c&l6D",ESC);	/* Set the Density */
   	fprintf(fp,"%c(s4B",ESC);   /* Set Bold */
/*---------*/

    fprintf(fp,"%-*s%-.80s\n",(int)(((80 - rl_lab_title.len)/2) - 6)," ",rl_lab_title.arr);
	fprintf(fp,"%-*s%-.80s\n",(int)(((80 - rl_lab_title_2.len)/2) - 6)," ",rl_lab_title_2.arr);
	fprintf(fp,"%-*s%-.80s\n",(int)(((80 - rl_lab_title_3.len)/2) - 6)," ",rl_lab_title_3.arr);
	fprintf(fp,"%-*s%-.80s\n",(int)(((80 - rl_lab_title_4.len)/2) - 6)," ",rl_lab_title_4.arr);
/*----------------------------------------*/

   for(i=0;i<87;i++)
        fprintf(fp,"_");

	fprintf(fp, "\n");

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
   	fprintf(fp,"%c(s-3B",ESC);

	lctr = 8;

	if (strcmp(rl_actual_dob_yn.arr, "Y") == 0)
		strcpy(l_age_legend, "");
	else
		strcpy(l_age_legend, "*");

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Patient Name : ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp, "%-30.30s                ", rl_pat_short_name.arr);

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Age: ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp, "%s ", l_age_legend);

	patient_age();

	fprintf(fp, "%s\n", t_age.arr);
	page_break(1);

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Location     : ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp, "%s", rl_source_short_name.arr);

	if(rl_hdr_episode_type.arr[0] == 'R')
	{
	    fprintf(fp,"%c&k4S",ESC); 
   		fprintf(fp,"%c(s4B",ESC);
		fprintf(fp, "/");
		fprintf(fp,"%c&k4S",ESC); 
   		fprintf(fp,"%c(s-3B",ESC);   

		fprintf(fp, "%-20.20s\n", rl_location.arr);
		page_break(1);
	}
	else
	{
		fprintf(fp, "\n");
		page_break(1);
		
	}

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Hospital No  : ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
	
	if(rl_hdr_episode_type.arr[0] == 'R')
	{
       if(strcmp(rl_pat_actual_id.arr,"NULL")==0)
	 	   strcpy(t_patient_id,nd_hosp_no.arr);
	   else
		   strcpy(t_patient_id,rl_pat_actual_id.arr);
	}
    else
       strcpy(t_patient_id,nd_hosp_no.arr);

	fprintf(fp, "%-15.15s                          ", t_patient_id);

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Sex/Race: ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   

    if(rl_pat_sex.arr[0] == 'M')
	   strcpy(sex_desc,"MALE");
	else
		if(rl_pat_sex.arr[0] == 'F')
			strcpy(sex_desc,"FEMALE");
		else
			strcpy(sex_desc,"Unknown");

	fprintf(fp,"%s", sex_desc);

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "/");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   

	get_race_desc();
	fprintf(fp, "%-15.15s\n", d_race_desc.arr);
	page_break(1);

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Doctor       : ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp,"%-30.30s\n",rl_consultant_short_name.arr);
	page_break(1);

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Specimen No  : ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   

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

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Recd  Date: ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp, "%-16.16s\n", rl_hdr_spec_recd_date_time.arr);
	page_break(1);

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Category No  : ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   

	fprintf(fp, "%-4.4s/%-4.4s/%-15.15s              ", rl_category_code.arr, rl_category_year.arr,
								rl_category_number.arr);

    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Collt Date: ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);   
	
	fprintf(fp, "%-16.16s\n", rl_hdr_spec_colltd_date_time.arr);	
	page_break(1);
	
    fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s4B",ESC);
	fprintf(fp, "Clinical     : ");
	fprintf(fp,"%c&k4S",ESC); 
   	fprintf(fp,"%c(s-3B",ESC);
	   
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

	 fprintf(fp,"%c&k4S",ESC); 
   	 fprintf(fp,"%c(s4B",ESC);
	 fprintf(fp, "Comment        ");
	 fprintf(fp,"%c&k4S",ESC); 
   	 fprintf(fp,"%c(s-3B",ESC);

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

	if (strcmp(rl_test_requested_yn.arr, "Y") == 0)
	{

		 fprintf(fp,"%c&k4S",ESC); 
   		 fprintf(fp,"%c(s4B",ESC);
		 fprintf(fp, "Ordered Tests: ");
		 fprintf(fp,"%c&k4S",ESC); 
   		 fprintf(fp,"%c(s-3B",ESC);
		
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

			if (i > 15) 
				break;
		}
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

    fprintf(fp,"%c&k4S",ESC); 
    fprintf(fp,"%c(s4B",ESC);
    for(i=0;i<87;i++)
        fprintf(fp,"_");
    fprintf(fp,"%c&k4S",ESC); 
    fprintf(fp,"%c(s-3B",ESC);

	page_break(1);
	fprintf(fp, "\n");
    
}
/********************************************************************************************/
print_footer1(foot_ind)
int foot_ind;
{
   int fi = 0;
   char l_str[100];
   l_str[0] = '\0'; 

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
		fprintf(fp,"%c&k4S",ESC); 
		fprintf(fp,"%c(s4B",ESC);
//		fprintf(fp,"Released/Reviewed By : ");
		fprintf(fp,"Released By : ");
		fprintf(fp,"%c&k4S",ESC); 
		fprintf(fp,"%c(s-3B",ESC);   
  	    sprintf(l_str,"%s", sy_user_name.arr);
	    fprintf(fp,"%-30.30s",l_str);
		fprintf(fp, "        ");
		/*----------------------------------------*/

	   /*----------------------------------------*/	   
	   fprintf(fp,"%c&k4S",ESC); 
	   fprintf(fp,"%c(s4B",ESC);
	   fprintf(fp,"Released Date : ");
	   fprintf(fp,"%c&k4S",ESC); 
	   fprintf(fp,"%c(s-3B",ESC);   
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
		fprintf(fp,"%c&k4S",ESC); 
		fprintf(fp,"%c(s4B",ESC);
		fprintf(fp,"Reviewed By : ");
		fprintf(fp,"%c&k4S",ESC); 
		fprintf(fp,"%c(s-3B",ESC);   
  	    sprintf(l_str,"%s", sy_user_name.arr);
	    fprintf(fp,"%-30.30s",l_str);
		fprintf(fp, "        ");
	   /*----------------------------------------*/	   
	   fprintf(fp,"%c&k4S",ESC); 
	   fprintf(fp,"%c(s4B",ESC);
	   fprintf(fp,"Reviewed Date : ");
	   fprintf(fp,"%c&k4S",ESC); 
	   fprintf(fp,"%c(s-3B",ESC);   
	   fprintf(fp,"%-s\n",rl_hdr_released_date.arr);
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
	/***********************
	   if (rl_prn_ctrl_hdr_rp_yn.arr[0] == 'Y')
		   sprintf(l_str,"%-16.16s         ",nd_result_printed_date.arr);
	   else
		   sprintf(l_str,"%-16.16s         ",nd_result_printed_date.arr);

	   fprintf(fp,"%s",nd_result_printed_date.arr);
	***********************/


	  
	}

/****** FOOTER PRINTING FROM RL_SECTION_CTL  ****************/
   if ( (strlen(rl_footer_line_1.arr) > 0) ||
			(strlen(rl_footer_line_2.arr) > 0) )
   {
		if (strlen(rl_footer_line_1.arr) > 0) 
			fprintf(fp, "%-79.79s\n", rl_footer_line_1.arr);

		if (strlen(rl_footer_line_2.arr) > 0) 
			fprintf(fp, "%-79.79s\n", rl_footer_line_2.arr);
   }


   /*----------------------------------------*/

   if (rl_hdr_extra_copies_to.len && copy == 2 ) 
   {
      /*----------------------------------------*/
      fprintf(fp,"%c&k4S",ESC); 
      fprintf(fp,"%c(s4B",ESC);
      fprintf(fp,"Copy To : ");
      fprintf(fp,"%c&k4S",ESC); 
      fprintf(fp,"%c(s-3B",ESC);   
      /*----------------------------------------*/

      sprintf(l_str,"%24.24s",rl_hdr_extra_copies_to.arr);
   }
   else
      sprintf(l_str,"%34.34s"," ");

   fprintf(fp,"%s\n",l_str);

   if(last_page == 0)
      sprintf(l_str,"%-73.73s--CONTINUED--"," ");
   else
      sprintf(l_str,"%-73.73s      --END--"," ");

   fprintf(fp,"%s\f",l_str);

   lctr = 0;
  
}

/*-----------------------------------------------------*/
build_cancelled_tests()
{

	/* EXEC SQL DECLARE cancelled_curs CURSOR FOR 
				SELECT DISTINCT specimen_no
				FROM RL_INTERVAL_TEST_TEMP
				WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND user_id = 'RLRRSENQ'
				AND session_id = 1; */ 

	   	    
	/* EXEC SQL OPEN cancelled_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0071;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3079;
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
							(:nd_operating_facility_id,'RLRRSENQ', 2, TO_NUMBER(:can_spec_no), 
									:can_group_test, :can_test_code); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 29;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into RL_INTERVAL_TEST_TEMP (operating_facility_id,u\
ser_id,session_id,specimen_no,group_test_code,test_code) values (:b0,'RLRRSENQ\
',2,TO_NUMBER(:b1),:b2,:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3098;
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
   sqlstm.sqhstv[1] = (         void  *)&can_spec_no;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&can_group_test;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&can_test_code;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3129;
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
			ins_message(ORA_MESG,"FETCH failed on cursor specimen_curs");

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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3148;
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
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND NVL(cancelled_yn, 'N') = 'Y'; */ 

	   	    
	/* EXEC SQL OPEN can_req_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0073;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3163;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3186;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3201;
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
			ins_message(ORA_MESG,"FETCH failed on cursor specimen_curs");

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
				AND user_id = 'RLRRSENQ'
				AND session_id = 2; */ 


	/* EXEC SQL OPEN prn_can_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0074;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3224;
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



	while(fetch_prn_can_curs())
	{

		if (ctr == 0)
		{

			fprintf(fp, "\n");
			page_break(1);

		    fprintf(fp,"%c&k4S",ESC); 
   			fprintf(fp,"%c(s4B",ESC);
			fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
			fprintf(fp, "Cancelled Tests\n");
		   	fprintf(fp,"%c&d@",ESC);
			fprintf(fp,"%c&k4S",ESC); 
   			fprintf(fp,"%c(s-3B",ESC);   
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
			fprintf(fp, "%-40.40s %s\n", can_test_name.arr, cancel_reason.arr);

//			fprintf(fp, "%-10.10s  %-40s\n", can_group_test.arr, cancel_reason.arr);
			page_break(1);
		}

		ctr++;

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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3243;
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
			ins_message(ORA_MESG,"FETCH failed on cursor specimen_curs");

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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_CANCELLATION_CODE where c\
ancel_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3270;
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3293;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(name_on_report_yn,'Y') into :b0  from RL_USER_DEP\
T where ((OPERATING_FACILITY_ID=:b1 and user_id=:b2) and section_code=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3308;
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
get_desc_snomed2()
{
    rl_snomed2_desc1.arr[0]          = '\0';
    rl_snomed2_desc2.arr[0]          = '\0';
    rl_snomed2_desc3.arr[0]          = '\0';
    rl_snomed2_desc4.arr[0]          = '\0';
    rl_snomed2_desc5.arr[0]          = '\0';
    rl_snomed2_print_yn.arr[0]       = '\0';

    rl_snomed2_desc1.len             = 0;
    rl_snomed2_desc2.len             = 0;
    rl_snomed2_desc3.len             = 0;
    rl_snomed2_desc4.len             = 0;
    rl_snomed2_desc5.len             = 0;
    rl_snomed2_print_yn.len	    = 0;


     /* EXEC SQL SELECT SUBSTR(DESCRIPTION_1, 1, 12),
					 NVL(PRINT_YN, 'N')
	           INTO :rl_snomed2_desc1,
    			   :rl_snomed2_print_yn
             FROM RL_SNOMED_CODE
             WHERE SNOMED_CODE = :rl_res_snomed_code2; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 29;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SUBSTR(DESCRIPTION_1,1,12) ,NVL(PRINT_YN,'N') int\
o :b0,:b1  from RL_SNOMED_CODE where SNOMED_CODE=:b2";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )3339;
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
     sqlstm.sqhstv[2] = (         void  *)&rl_res_snomed_code2;
     sqlstm.sqhstl[2] = (unsigned int  )23;
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



    rl_snomed2_desc1.arr[rl_snomed2_desc1.len] = '\0';
    rl_snomed2_desc2.arr[rl_snomed2_desc2.len] = '\0';
    rl_snomed2_desc3.arr[rl_snomed2_desc3.len] = '\0';
    rl_snomed2_desc4.arr[rl_snomed2_desc4.len] = '\0';
    rl_snomed2_desc5.arr[rl_snomed2_desc5.len] = '\0';
    rl_snomed2_print_yn.arr[rl_snomed2_print_yn.len] = '\0';

}
/*------------------------------------------------------------*/
print_line_snomed1(char *t_str)
{
         fprintf(fp,"%-18.18s",t_str);

}
/*------------------------------------------------------------*/
print_line_snomed2(char *t_str)
{
         fprintf(fp,"%-18.18s",t_str);
}
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
  sqlstm.arrsiz = 29;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (TO_NUMBER(:b0)-FLOOR(TO_NUMBER(:b0))) ,LENGTH(SUBST\
R(:b0,(INSTR(:b0,'.')+1))) ,INSTR(:b0,'.') into :b5,:b6,:b7  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3366;
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

	
	/* EXEC SQL SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') INTO :tday
            FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3413;
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

                                        

    /* EXEC SQL SELECT ABS(MONTHS_BETWEEN(
		TO_DATE(:rl_regd_date,'DD/MM/YYYY'), 
		TO_DATE(:rl_pat_date_of_birth, 'DD/MM/YYYY')))
			INTO :mt FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ABS(MONTHS_BETWEEN(TO_DATE(:b0,'DD/MM/YYYY'),TO_DA\
TE(:b1,'DD/MM/YYYY'))) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3432;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_regd_date;
    sqlstm.sqhstl[0] = (unsigned int  )13;
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



			sprintf(mths.arr,"%f",mt);
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

			if ((tmp_mths == 0)  && (yrs ==0))
			{

				/* EXEC SQL SELECT TO_CHAR(ROUND((TO_DATE(:rl_regd_date,'DD/MM/YYYY') -
					TO_DATE(:rl_pat_date_of_birth, 'DD/MM/YYYY')),3))
					INTO :t_days FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 29;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ROUND((TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(:\
b1,'DD/MM/YYYY')),3)) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3459;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_regd_date;
    sqlstm.sqhstl[0] = (unsigned int  )13;
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



					tmp_days = atoi(strtok(t_days.arr,"."));
			}
			else
				tmp_days = (atof(mths.arr) - atoi(mths1.arr)) * 31 ;


			sprintf(st_r, "%f", yrs);
			strcpy(t_age.arr, strtok(st_r, "."));
			strcat(t_age.arr, "Y");
			sprintf(st_r, " %f", tmp_mths);
			strcat(t_age.arr, strtok(st_r, "."));
			strcat(t_age.arr, "M");
			sprintf(st_r, " %f", tmp_days);
			strcat(t_age.arr, strtok(st_r, "."));
			strcat(t_age.arr, "D ");
				
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
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_TEST_CODE where test_code\
=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3486;
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
get_user_name(char *y_user)
{
	
	strcpy(sy_user.arr, y_user);
	sy_user.len = strlen(sy_user.arr);
	
	sy_user_name.arr[0]		= '\0';
	sy_user_name.len			= 0;
	
	/* EXEC SQL SELECT username 
			 INTO :sy_user_name
			 FROM SY_USER
			 WHERE FACILITY_ID = :nd_operating_facility_id
			   AND user_id = :sy_user; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select username into :b0  from SY_USER where (FACILITY_ID=:b\
1 and user_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3509;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sy_user_name;
 sqlstm.sqhstl[0] = (unsigned int  )52;
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



	sy_user_name.arr[sy_user_name.len]		= '\0';

	if (NODATAFOUND);

}
/*------------------------------------------------------------*/
/**************************select transaction based or not ***************/
get_trans_ind()
{
	
	nd_trx_ind.arr[0]		= '\0';
	nd_trx_ind.len		= 0;

	/* EXEC SQL  SELECT NVL(TRANSACTION_BASED_YN, 'N')
	          INTO   :nd_trx_ind
	          FROM   sy_online_print_id
              WHERE  ONLINE_PRINT_NAME = 'RLRRSENQ'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 29;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') into :b0  from sy_onlin\
e_print_id where ONLINE_PRINT_NAME='RLRRSENQ'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3536;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
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



	if(OERROR)
	{
	    disp_message(ERR_MESG,"SELECT failed on  SY_ON_LINE_PRINT_ID");
		proc_exit();
	}

	nd_trx_ind.arr[nd_trx_ind.len]			= '\0';


    if(NO_DATA_FOUND)
		return 0;

		
	return 1;

}

