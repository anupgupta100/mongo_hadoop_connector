package com.traq.mongo.hadoop.common;

/**
 * Created by Amit on 6/9/18.
 * Company: MSD Telematix Pvt. Ltd
 */
public interface Constants {
    final static int totalSetRandomNumber = 15;

    final static String Empty = "";
    final static int Client = 300;
    final static int Core = 0;
    final static int ThreadSleepTiming = 2;
    final static int CorePool = 15;
    final static int ModeratorPool = 15;


    final static int EXACT_MATCH=1;

    final static int PARTIAL_MATCH=2;
    final static String _ACTIVE="A";
    final static String _INACTIVE="I";
    final static String _SUSPENDED="S";



	//TECH APIS
    final static String TECHLOGIN = "TECHLOGIN";
    final static String TECHSUPPORTLOGIN = "TECHSUPPORTLOGIN";
    final static String TECHACTLIST = "TECHACTLIST";
    final static String TECHMANDLIST = "TECHMANDLIST";
    final static String TECHSUBMIT = "TECHSUBMIT";
    final static String TECHVIEWALL = "TECHVIEWALL";
    final static String TECHPARTTECH = "TECHPARTTECH";
    final static String TECHPARTTECHWITHDUR = "TECHPARTTECHWITHDUR";
    final static String ACTIVITY = "Activity";
    final static String NewVehicle = "NewVehicle";
    final static String OldVehicle = "OldVehicle";
    final static String NewTransporterName = "NewTransporterName";
    final static String OldTransporterName = "OldTransporterName";
    final static String NewSIM = "NewSIM";
    final static String OldSIM = "OldSIM";
    final static String NewDeviceIMEI = "NewDeviceIMEI";
    final static String OldDeviceIMEI = "OldDeviceIMEI";
    final static String NewLoadcellNo = "NewLoadcellNo";
    final static String OldLoadcellNo = "OldLoadcellNo";
    final static String Date = "Date";
    final static String Date1 = "Date1";
    final static String Remarks = "Remarks";
    final static String UploadDocs = "UploadDocs";
    final static String Field1 = "Field1";
    final static String Field2 = "Field2";
    final static String Field3 = "Field3";
    final static String Field4 = "Field4";
    final static String Field5 = "Field5";

    final static String REVIEWALERT = "REVIEWALERT";

    final static String ALERTLOG = "ALERTLOG";
    final static String ADDDEVMAC = "ADDDEVMAC";




    // Device Status
    final static String HR_5 = "5HR";
    final static String HR_1 = "1HR";
    final static String OFFLINE = "OFF";
    final static String ONLINE = "ON";
    final static String MOTION = "MOTION";
    final static String IDLE = "IDLE";
    final static String STOP = "STOP";
    final static String _GEOCODE = "geocode";

    // Device Priority
    final static String _PRIMARY = "PRI";
    final static String _SECONDARY = "SEC";
    final static String _OTHER = "OTH";

    final static String TRIP_STOP = "STP";
    final static String TRIP_INITIATE = "IN";
    final static String TRIP_START = "STR";
    final static String TRIP_COMPLETE = "CMP";

    // clients
    public static final String CLIENT_PRAJ = "PRAJ";
    public static final String CLIENT_FIXED = "FIXED";
    public static final String CLIENT_FCI = "FCI";
    public static final String CLIENT_SBM = "SBM";

    // Account Type
    public static final String AC_DISTRICT = "DT";
    public static final String AC_BLOCK = "BL";
    public static final String AC_END_USER = "EU";
    public static final String AC_PANCHAYAT = "GP";
    public static final String AC_SUPER = "HO";
    public static final String AC_PARTNER = "PA";
    public static final String AC_SUB_PARTNER = "SP";
    public static final String AC_SUB_GROUP = "SG";
    public static final String AC_ATATE = "ST";
    public final static String CURLOC = "CURRENTLOC";

    // USER TYPE
    final static String SUPERUSER = "sup";
    final static String USER_ADMIN_ASSISTANT = "AA";
    final static String USER_ADMIN = "AD";
    final static String USER_SUB_ASSISTANT = "SA";
    final static String USER_CUSTOMER = "SUB";

    // Account TYPE
    final static String ACC_BLOCK = "BL";
    final static String ACC_COMPANY = "COM";
    final static String ACC_DISTRICT = "DT";
    final static String ACC_END_USER = "EU";
    final static String ACC_GRAM_PANCHAYAT = "GP";
    final static String ACC_INDIVIDUAL = "SUB";
    final static String ACC_LEVEL1 = "L1";
    final static String ACC_LEVEL2= "L2";
    final static String ACC_LEVEL3 = "L3";
    final static String ACC_LEVEL4 = "L4";
    final static String ACC_LEVEL5 = "L5";

    public static final String SOURCE = "source";
    public static final String NODESOURCELATLNG = "sourcelatlng";

    public static final String DESTINATION = "destination";
    public static final String NODEDESTINATIONLATLNG = "destinationlatlng";

    public static final String VIA = "via";
    public static final String VIA1 = "via1";
    public static final String NODEVIA1LATLNG = "via1latlng";
    public static final String VIA2 = "via2";
    public static final String NODEVIA2LATLNG = "via2latlng";
    public static final String VIA3 = "via3";
    public static final String NODEVIA3LATLNG = "via3latlng";
    public static final String RADIUS = "radius";
    public static final String ABBR = "abbr";
    public static final String HITINFO = "HITINFO";
    public static final String UNNAMED = "UN Named";

    public static final String TYPE_REGULAR = "REGULAR";
    public static final String NODEFORMATTED_ADD = "formatted_address";
    public static final String NODERESPONSEFORMAT= "responseformat";
    public static final String NODEGEOCODE = "geocode";


    final static String JSONROOT = "live";
    final static String XMLROOT = "<live>";
    final static String CLOSINGXMLROOT = "</live>";
    final static String REQUESTTYPE = "<requesttype>";
    final static String OPEN_ANGLE = "<";
    final static String CLOSE_ANGLE = ">";
    final static String OPNE_CLOSETAG_ANGLE = "</";

    final static String ELEMENTHEADER = "header";
    final static String ELEMENTREQUEST = "request";
    final static String ELEMENTRESPONSE = "response";
    final static String ELEMENTRECORDS = "records";

    final static String LOGIN = "LOGIN";
    final static String OTPLOGIN = "OTPLOGIN";
    final static String GENERATE = "GENERATE";
    final static String ONLINEREPORT = "ONLINEREPORT";
    final static String STANDARDREPORT = "STDREPORT";
    final static String DISTANCEREPORT = "DISTREPORT";
    final static String TRACKHISTREPORT = "TRACKHIST";
    final static String WORKINGHOURREPORT  = "WORKINGHOURREPORT";


    final static String IMGREPORT = "IMGREPORT";
    final static String IDLEREPORT = "IDLEREPORT";
    final static String IDLEHOURLYREPORT = "IDLEHOURLYREPORT";
    final static String DISTANCEHOURLYREPORT = "DISTANCEHOURLYREPORT";
    final static String ALLHOURLYREPORTS = "ALLHOURLYREPORTS";
    final static String OVERSTOPPAGEHOURLYREPORT = "OVERSTOPPAGEHOURLYREPORT";



    final static String OVERSTOPPAGEREPORT = "OVERSTOPPAGEREPORT";
    final static String OVERSPEEDREPORT = "OVERSPEEDREPORT";
    final static String WORKINGHOURLYREPORT  = "WORKINGHOURLYREPORT";
    final static String STOPPAGEHOURREPORT = "STOPPAGEHOURREPORT";


    final static String STOPPAGEREPORT = "STOPPAGEREPORT";
    final static String OFFLINEREPORT = "OFFLINEREPORT";
    final static String TANKERREPORT = "TANKERREPORT";
    final static String TALUKAREPORT = "TALUKAREPORT";
    final static String DISTRICTREPORT = "DISTRICTREPORT";
    final static String CREATEPOIREPORT = "CREATEPOIREPORT";
    final static String FUELREPORT = "FUELREPORT";
    final static String VEHINGEOREPORT = "VEHINGEOREPORT";



    final static String LOGOUT = "LOGOUT";
    final static String QUICK = "QUICK";
    final static String FORGETPIN = "FORGETPIN";
    final static String VALIDATEOTP = "VALIDATEOTP";
    final static String ACCOUNTTRANSFER = "ACCOUNTTRANSFER";
    final static String DEVICETRANSFER = "DEVICETRANSFER";

    final static String VIEWPROFILE = "VIEWPROFILE";
    final static String CHANGEPIN = "CHANGEPIN";
    final static String RESETPIN = "RESETPIN";
    final static String NEWPIN = "NEWPIN";

    final static String CHECKUSER = "CHECKUSER";
    final static String CHECKDEVICE = "CHECKDEVICE";
    final static String CASEOPENDROPDOWN = "CASEOPENDROPDOWN";
    final static String TRANSPORTERS = "TRANSPORTERS";
    final static String LIVEDEVICE = "LIVEDEVICE";
    final static String LIVEINFO = "LIVEINFO";
    final static String OPENCASE = "OPENCASE";
    final static String ATOPEN = "ATOPEN";
    final static String ATCLOSE = "ATCLOSE";
    final static String ATVIEW = "ATVIEW";
    final static String VIEWOPENCASE = "VIEWOPENCASE";
    final static String VIEWCLOSECASE = "VIEWCLOSECASE";
    final static String CLOSECASE = "CLOSECASE";
    final static String VIEWCASES = "VIEWCASES";
    final static String GEOCHECK = "GEOCHECK";
    final static String NODEAMOUNT  = "amount";
    final static String NODEDISPNAME = "dispname";
    final static String NODEPARTYNAME = "partyname";
    final static String NODEPERMITNO= "permitno";
    final static String DASHBOARD = "DASHBOARD";
    final static String VOLTAGEGRAPH = "VOLTAGEGRAPH";
    final static String CLOSEDEVICE = "CLOSEDEVICE";
    final static String CALIBRATE = "CALIBRATE";
    final static String UPDATECALIBRATION = "UPDATECALIBRATION";
    final static String UPDATEPROFILE = "UPDATEPROFILE";
    final static String CREATEUSER = "CREATEUSER";
    final static String REPORT = "REPORT";
    final static String ELOCKREPORT = "ELOCKREPORT";
    final static String UPDATEUSER = "UPDATEUSER";
    final static String VIEWUSERNAME = "VIEWUSERNAME";
    final static String VIEWUSERS = "VIEWUSERS";

    final static String VIEWDEVICETRAIL = "VIEWDEVICETRAIL";
    final static String VIEWUSERTRAIL = "VIEWUSERTRAIL";
    final static String VIEWACCOUNTTRAIL= "VIEWACCOUNTTRAIL";

    final static String CREATEGEOFENCE = "CREATEGEOFENCE";
    final static String UPDATEGEOFENCE = "UPDATEGEOFENCE";
    final static String GEOFENCEDETAIL = "GEOFENCEDETAIL";
    final static String GEOCODES = "GEOCODES";
    final static String DEFAULTGEO = "DEFAULTGEO";
    final static String CREATEALERT = "CREATEALERT";
    final static String SETALERT = "SETALERT";
    final static String UPDATEALERT = "UPDATEALERT";

    final static String CREATEZONE = "CREATEZONE";
    final static String UPDATEZONE = "UPDATEZONE";
    final static String CREATEROLE = "CREATEROLE";
    final static String UPDATEROLE = "UPDATEROLE";
    final static String UPLOADINVENT = "UPLOADINVENTORY";
    final static String UPDATEINVENT = "UPDATEINVENTORY";
    final static String VIEWPERMISSION="VIEWPERMISSION";
    final static String CREATEDVR = "CREATEDVR";
    final static String UPDATEDVR = "UPDATEDVR";

    final static String CREATEBRAND = "CREATEBRAND";
    final static String UPDATEBRAND = "UPDATEBRAND";
    final static String CREATEMFG = "CREATEMFG";
    final static String UPDATEMFG= "UPDATEMFG";
    final static String CREATEDEVTYPE = "CREATEDEVTYPE";
    final static String UPDATEDEVTYPE= "UPDATEDEVTYPE";

    final static String CREATEASSETTYPE = "CREATEASSETTYPE";
    final static String UPDATEASSETTYPE= "UPDATEASSETTYPE";

    final static String CREATEVEHICLE = "CREATEVEHICLE";
    final static String UPDATEVEHICLE= "UPDATEVEHICLE";

    final static String VIEWACCOUNT = "VIEWACC";
    final static String CREATEACCOUNT = "CREATEACC";
    final static String UPDATEACCOUNT = "UPDATEACC";

    final static String SIMTRAIL = "SIMTRAIL";

    final static String VIEWACCOUNTTYPE = "VIEWACCTYPE";
    final static String CREATEDEVICE = "CREATEDEVICE";
    final static String UPDATEDEVICE = "UPDATEDEVICE";
    final static String OFFDEVICE = "OFFDEVICE";
    final static String CREATETRIP = "CREATETRIP";
    final static String CREATEPREVTRIP = "CREATEPREVTRIP";
    final static String UPDATETRIP = "UPDATETRIP";

    final static String CREATECLIENT = "CREATECLIENT";
    final static String UPDATECLIENT = "UPDATECLIENT";

    final static String CREATEROUTE = "CREATEROUTE";
    final static String UPDATEROUTE = "UPDATEROUTE";
    final static String FILTERBYYVEHTYPE = "FILTERBYYVEHTYPE";

    final static String NODEDEVICETYPE = "devicetype";
    final static String NODEDATE = "date";
    final static String NODEHOUR = "hour";
    final static String NODEDEVICETYPEID = "devicetypeid";
    final static String NODEREQUEST = "request";
    final static String NODERESPONSE = "response";
    final static String NODEREQUESTTYPE = "requesttype";
    final static String NODERESPONSETYPE = "responsetype";

    final static String NODEMATERIAL = "material";
    final static String NODEDESCRIPTION = "description";
    final static String NODEACCOUNTNAME = "accname";
    final static String NODEACCOUNTSTATUS = "accstatus";
    final static String NODEDEVSTATUS = "devstatus";
    final static String NODEACCOUNT= "acc";
    final static String ACCOUNT= "ACCOUNT";
    final static String NODEOTHERACCOUNT = "oacc";
    final static String NODEGEOFENCE= "geofence";
    final static String NODEUNNAMED= "Unnamed Road";
    final static String GEOFENCE= "GEOFENCE";
    final static String GEOFENCEABBR="GEOFENCEABBR";
    final static String NODEACCOUNTID= "accid";
    final static String NODEACCOUNTDETAIL= "accdetail";
    final static String NODETRANSID = "transid";
    final static String NODETRANSIT = "transit";
    final static String NODETRAQ = "traq";
    final static String NODEREQUESTCTS = "requestcts";
    final static String NODECLIENTTYPE = "clienttype";
    final static String NODECLIENT = "client";
    final static String NODECOMMENTS = "comments";
    final static String NODEDISHA = "disha";
    final static String NODESPEED = "speed";
    final static String NODEMAXSPEED = "maxspeed";
    final static String NODEMAX = "max";
    final static String NODEMIN = "min";
    final static String NODEIGNITION = "ign";
    final static String NODEMOTION = "motion";
    final static String NODESTOP = "stop";
    final static String NODEIDLE = "idle";
    final static String NODEHR1 = "hr1";
    final static String NODEHR5 = "hr5";
    final static String NODEHR6 = "hr6";
    final static String NODEHR12 = "hr12";
    final static String NODEHR18 = "hr18";
    final static String NODEHR24 = "hr24";
    final static String NODERUNNING = "running";
    final static String NODEORIGINTS = "orgts";
    final static String NODEORIGINTSMILLI = "orgmillis";

    final static String NODELOCK = "lock";


    final static String NODEPACKETTYPE = "pktype";
    final static String NODEINITTS = "initts";
    final static String NODEFUEL = "fuel";
    final static String NODEFUELS = "fuels";
    final static String NODELOAD = "loadData";
    final static String NODEVOLTAGE = "voltage";
    final static String NODELOADS = "load";
    final static String NODETRANSPORTERS = "transporters";
    final static String NODEALERTTYPE = "alerttype";
    final static String NODETEMP = "temp";
    final static String NODETEMPS = "temps";
    final static String NODEAC = "ac";
    final static String NODEDOOR = "door";
    final static String NODEGEOID = "geoid";
    final static String NODESPDID = "spdid";
    final static String NODEIDLETS = "idlets";
    final static String NODEIDLEFLAG = "idleflag";
    final static String NODELASTSTOP = "laststop";
    final static String NODELASTUPDATED = "lastupdated";

    final static String NODEAGE = "age";
    final static String NODEGENDER= "gender";

    final static String NODELASTIGN = "lastign";
    final static String NODELASTMOVE = "lastmv";
    final static String NODEDEVICESTATUS = "devsts";
    final static String NODEDEVICENAME = "devname";
    final static String NODEDEVICEIP = "devip";
    final static String NODEDEVICEID = "deviceid";
    final static String NODEDEVICEPORT = "devport";
    final static String NODEDEVICEPASS = "devpass";
    final static String NODEPOWSTATUS = "powsts";
    final static String NODEBATTERY = "battery";
    final static String NODEBATCHARGE = "batchg";
    final static String NODESERVERIP = "servip";
    final static String NODESERVERPORT = "servport";
    final static String NODESATELLITES = "satellites";
    final static String NODEIMMOBILISER = "imb";
    final static String NODEIMBSTATUS = "imbstat";
    final static String NODETAMPER = "tamp";
    final static String NODEMOTORFAULT = "mtrfault";
    final static String NODEBACKCAP = "bkcap";
    final static String NODESTRINGCUT = "stgcut";
    final static String NODEROUTEID = "routeid";
    final static String NODEUDV1 = "udv1";
    final static String NODEUDV2 = "udv2";
    final static String NODEUDV3 = "udv3";
    final static String NODEUDV4 = "udv4";
    final static String NODEUDV5 = "udv5";
    final static String NODELIMIT = "limit";
    final static String NODEEVENT = "event";

    final static String NODERESULTCODE = "resultcode";
    final static String NODERESULTDESCRIPTION = "resultdescription";
    final static String NODERESPONSEVALUE = "responsevalue";
    final static String NODETS = "ts";
    final static String NODERESPONSECTS = "responsects";
    final static String NODERECORDS = "records";
    final static String NODEFIRSTNAME = "firstname";
    final static String NODEMIDDLENAME = "middlename";
    final static String NODELASTNAME = "lastname";
    final static String NODEACTIVATIONCODE = "activationcode";
    final static String NODEVENDORRESULTCODE = "vendorresultcode";
    final static String NODEVENDORRESULTDESCRIPTION = "vendorresultdescription";
    final static String NODEPASSENGERS = "passengers";
    final static String NODEPASSENGER = "passenger";
    final static String NODEPASSTYPE = "passtype";
    final static String NODEPASSENGERTYPE = "passengertype";
    final static String NODEADULT = "adult";
    final static String NODECHILD = "child";
    final static String NODEINFANT = "infant";
    final static String NODECUSTOMERTYPE = "customertype";
    final static String NODEVEHICLE = "vehicle";
    final static String NODEVEHICLENUMBER = "vehnum";
    final static String NODEVEHICLENAME = "vehname";
    final static String NODEVEHICLETYPE = "vehtype";
    final static String NODEDRIVERNAME = "drivername";
    final static String NODEDRIVERPHONE = "driverphone";
    final static String NODELOADCELL = "loadcell";
    final static String NODEDRIVER = "driver";
    final static String NODETOTALDEVICE = "totaldevice";
    final static String NODEDEVICEDATA = "devicedata";
    final static String DEVICE = "DEVICE";
    final static String CLIENT = "CLIENT";
    final static String  DEVICETRAIL = "DEVICETRAIL";
    final static String NODEDRIVERID = "driverid";
    final static String NODEFAILUREMESSAGE = "failuremessage";
    final static String NODEVEHICLEID = "vehid";
    final static String NODETRANSTYPE = "transtype";
    final static String NODEMFG = "manufacturer";
    final static String NODELOW = "low";
    final static String NODEHIGH = "high";
    final static String NODECAMERA = "camera";
    final static String NODESTATUS = "status";
    final static String NODEDEFAULT = "default";
   // final static String NODELOADCELL = "loadcell";

    final static String NODESTATUSDESC = "statusdesc";
    final static String NODEVENDORCODE = "vendorcode";
    final static String NODERECORDCOUNT = "recordcount";
    final static String NODEDESTINATION = "destination";
    final static String NODEDESTINATIONCITY = "destinationcity";
    final static String NODECUSTOMERCODE = "customercode";
    final static String NODEEMAIL = "email";
    final static String NODEMESSAGE = "message";
    final static String NODEMOBILENO = "mobileno";
    final static String NODESMSPACK = "smspack";
    final static String NODESMS = "sms";
    final static String NODEMAIL = "mail";
    final static String NODEPHONENO = "phoneno";
    final static String NODEACCOUNTTYPE = "accounttype";
    final static String NODERECORD = "record";
    final static String NODEREFID = "refid";
    final static String NODEZONE = "zone";
    final static String NODEROLE = "role";
    final static String NODECODE = "code";
    final static String NODECOUNTER = "counter";
    final static String NODECOUNT = "count";
    final static String NODEQUANTITY = "qty";
    final static String NODEPINEXPIRY = "pinexpiry";
    final static String NODEIPADDRESS = "ipaddress";
    final static String NODEDISTANCE = "distance";
    final static String NODESTOPDURATION = "stopduration";
    final static String NODEDURATION = "duration";
    final static String NODEMINUTES = "minutes";
    final static String NODETRIP = "trip";
    final static String NODETRIPSTATUS = "tripsts";
    final static String NODETRIPSTART = "tripstart";
    final static String NODETRIPEND = "tripend";
    final static String NODETYPE = "type";
    final static String NODECOUNTRY = "country";
    final static String NODESTATE = "state";
    final static String NODEPAN = "pan";
    final static String NODEGST = "gst";
    final static String NODEAADHAR = "aadhar";
    final static String NODECITY = "city";
    final static String NODEADDRESS = "address";
    final static String NODEALTITUDE = "alt";
    final static String NODECOURSE =  "course";
    final static String NODESUMMARY = "summary";
    final static String NODEREPORT = "report";
    final static String NODEACSUMMARY = "accountsummary";
    final static String NODECREATEDON = "cts";
    final static String NODEJOINEDON = "jts";
    final static String NODEGEOINTIME = "intime";
    final static String NODEGEOOUTTIME = "outtime";
    final static String NODEDELIVERED = "deliveredts";
    final static String NODEUPATEDON = "updatedts";
    final static String NODELASTLOGINCTS = "lastlogin";
    final static String NODELICENSENO = "licnum";
    final static String NODETOTAL = "total";
    final static String NODEOFFLINE = "offline";
    final static String NODEONLINE = "online";
    final static String NODESTARTDATE = "startdate";
    final static String NODEENDDATE = "enddate";
    final static String NODESTARTTIME = "starttime";
    final static String NODEENDTIME = "endtime";

    final static String NODESTARTDATE1 = "startdate1";
    final static String NODEENDDATE1 = "enddate1";

    final static String NODESOURCE = "source";
    final static String NODESTARTLOCATION = "startlocation";
    final static String NODEENDLOCATION = "endlocation";
    final static String NODEUNLOCKLOCATION = "unloc";
    final static String NODEUNLOCKTIME = "untme";
    final static String NODEUNMAPPEDTIME = "umtme";
    final static String NODEEXPIRYDATE = "expirydate";
    final static String NODEISSUEDATE = "issuedate";
    final static String NODEACTIVEDATE = "activedate";
    final static String NODEINSTALLDATE = "installdate";//cts


    final static String NODECLOSEREQUESTTIME = "closerequesttime";
    final static String NODECLOSEREQUESTUSERNAME = "closerequestname";
    final static String NODELATEFINE = "latefine";
    final static String NODEFINERECEIPTNUMBER = "finereceiptnumber";



    final static String NODESOS = "sos";
    final static String NODEPIN = "pin";
    final static String NODEOTP = "otp";
    final static String NODEDOB = "dob";
    final static String NODENEWPIN = "newpin";
    final static String NODEOLDPIN = "oldpin";
    final static String NODECONFIRMPIN = "confirmpin";
    final static String NODEIMEI = "imei";
    final static String NODEIMSI = "imsi";
    final static String NODEPROVIDER = "provider";
    final static String NODEACTION = "action";
    final static String NODEPARENTACCOUNT = "parentid";
    final static String NODEPARENTNAME = "parentname";
    final static String NODELEVEL1 = "level1";
    final static String NODELEVEL2 = "level2";
    final static String NODEASSETTYPEID = "assettypeid";
    final static String NODEASSETTYPE = "assettype";
    final static String NODEASSETID = "assetid";
    final static String NODEOLDASSETID = "oldassetid";
    final static String NODENEWASSETID = "newassetid";
    final static String NODENEWACCOUNTID = "newaccid";

    final static String NODELOGO = "logo";
    final static String NODEID = "id";
    final static String NODENAME = "name";
    final static String NODECONTACTNAME = "contactname";
    final static String NODEUSERNAME = "username";
    final static String NODEUSER = "user";
    final static String NODEBRAND = "brand";

    final static String NODESERVICES = "services";
    final static String NODEASSET = "asset";
    final static String NODEALERTID = "alertId";
    final static String NODEALERTLOG = "ALERTLOG";
    final static String MAPVIEW = "MAPVIEW";
    final static String MAPVIEWINFO = "MAPVIEWINFO";
    final static String VIEWMAP = "VIEWMAP";
    final static String NODENUMBER = "number";
    final static String NODEPACK = "reports";
    final static String NODEDATA = "data";
    final static String NODEELOCK = "elock";
    final static String NODEHIST = "hist";

    public static final String NODELATITUDE="lat";
    public static final String NODELONGITUDE="lng";
    public static final String NODEVALUE = "value";
    public static final String NODETEXT = "text";
    public static final String APPLICATION_XML = "application/xml";
    public static final String APPLICATION_JSON = "application/json";
    public static final String TEXT_XML = "text/xml";
    public static final String TEXT_PLAIN = "text/plain";
    public static final String NODEGEOFENCEIN="IN";
    public static final String NODEGEOFENCEOUT="OUT";


    public static final String NODEMFGID="mfgid";
    public static final String NODEFF="fuelformula";
    public static final String NODEPARTCOL = "partcol";
    public static final String NODEORIGINATED = "originated";
    public static final String NODECREATED = "created";
    public static final String NODEMISC = "misc";
    public static final String NODEMISCS = "miscs";
    public static final String NODERESERVED = "reserved";
    public static final String NODELOCATION = "location";
    public static final String NODEGEOCODEID = "geocodeid";

    final static String NODELENGTH= "length";
    final static String NODECAPACITY= "capacity";
    final static String NODEMEDIUM="medium";
    final static String NODECOEFFA="COEFFA";
    final static String NODECOEFFB="COEFFB";
    final static String NODECOEFFC="COEFFC";
    final static String NODECOEFFD="COEFFD";
    final static String NODECOEFFE="COEFFE";

    final static String NODEFULEARR="FUELARRAY";
    final static String NODEVOLTAGEARR="VOLTAGEARR";

    final static String NODEOPERATOR= "operator";
    final static String NODEUPDATEDBY= "updatedBy";

    final static String NODEMODE= "mode";
    final static String NODEDND= "dnd";
    final static String NODEDNDSTART= "dndstart";
    final static String NODEDNDSTOP= "dndstop";
    final static String NODEGPS= "gps";
    final static String NODEPRIORITY= "priority";
    final static String NODEUPDATE = "UPDATE";

    final static String NODEVALID = "valid";
    final static String NODEEVENTSOURCETYPE = "eventsourcetype";
    final static String NODEUNLOCKSTATUS = "unlockstatus";
    final static String NODERFID = "rfid";
    final static String NODEREASON = "reason";
    final static String NODEPASSWORD = "pwd";
    final static String NODEPASSWORDSTATUS = "pwdstatus";
    final static String NODEPASSWORDENTERED = "pwdentered";
    final static String NODEEVENTRECORD = "eventrecord";
    final static String NODERAWDATAID = "rawdata_id";
    final static String NODEORIGINATEDTS = "originatedts";
    final static String NODERAW = "raw";
    final static String NODELIVE = "live";
    final static String NODETALUKA = "taluka";
    final static String NODEVILLAGE = "village";
    final static String NODEASSIGNEDTRIP = "assignedtrip";
    final static String NODEDONETRIP = "donetrips";
    final static String NODEALLOCATEDTRIP = "allocationtrips";


    final static String REDIS_KEY_CLIENTS = "client_list";
    final static String REDIS_KEY_IMEI_ = "imei_";

    final static String SAVEIMAGE = "SAVEIMAGE";
    final static String NODETEST = "TEST";
    final static String SAVE = "SAVE";
    final static String ELECTION = "ELECTION";
    final static String NODEPOLLEXPDATE="poll_expdate";
    final static String NODEINSEXPDATE="ins_expdate";
    final static String CREATEDEVICEINSUR="CREATEDEVICEINSUR";
    final static String UPDATEDEVICEINSUR="UPDATEDEVICEINSUR";
    final static String REPLACEDEVICE="REPLACEDEVICE";
    final static String NODEMINAMOUNT="min_amount";
    final static String NODEMAXAMOUNT="max_amount";
    final static String NODEMAXPERCENT="max_percent";
    final static String NODEMAXUSE="max_use";
    final static String NODEAPPROVED="approved";

    final static String PROMOVALIDATE="PROMOVALIDATE";
    final static String PROMOCODE="PROMOCODE";

    final static String ELOCKTOP="ELOCKTOP";
    final static String ELOCKACC="ELOCKACC";

    final static String ACREPORT  = "ACREPORT";

    final static String NODEHARSHBREAK  = "HB";
    final static String NODEHARSHACC  = "HA";
    public static final String NODEKEY="key";
    public static final String NODESOCKETDEV="SocketDev";
    public static final String NODEVIEWSOCKETDEV="ViewSocketDev";
    public static final String NODEUPDATESOCKETDEV="UpdateSocketDev";
    public static final String NODECOMMAND="command";
    public static final String NODEBTNAME="btname";
    public static final String NODEBTPASS="btpass";
    public static final String NODEPORT="port";
    public static final String NODESCREENTIME="screentime";
    public static final String NODEEXPTIME="expTime";
    public static final String NODEMPIN="mpin";
    public static final String NODEVIPNO="vipno";
    public static final String NODETEMPCARD="tempcard";
    public static final String NODESEALSETTING="seal";
    public static final String NODESPECIFICSOCKETDEV="SpecificSocketDev";
    final static String NODEFREQUENCY  = "frquency";
    final static String NODEDEVICETYPENAME = "devicetypename";

    final static String NODEACCURACY  = "accuracy";
    final static String NODEREADSTATUS = "readstatus";
    final static String ALERT= "ALERT";
    final static String NODEALRTID = "alertid";
    final static String NODEVENDORRESULT = "vendorresult";
    final static String NODEFAILURE = "failure";
    final static String NODEGCM = "gcm";
    }



