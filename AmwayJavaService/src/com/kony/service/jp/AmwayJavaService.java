package com.kony.service.jp;

import com.konylabs.middleware.common.JavaService2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class AmwayJavaService implements JavaService2 {
  public static final Logger logger = Logger.getLogger(AmwayJavaService.class);
  
  //static Class class$0;
  
  static {
   /* if (class$0 == null)
      try {
      
      } catch (ClassNotFoundException classNotFoundException) {
        //throw new NoClassDefFoundError(classNotFoundException.);
    	  logger.error(classNotFoundException);
      }  */
  }
  
  public Object invoke(String methodId, Object[] map, DataControllerRequest req, DataControllerResponse res) throws Exception {
    Result result = new Result();
    logger.debug("Method name : " + methodId);
    logger.debug("Calling configuration properties file");
    String propDetails = loadProperties();
    result.addParam(new Param("result", propDetails));
    return result;
  }
  
  private String loadProperties() {
    Properties prop = new Properties();
    Properties visitorImcId = new Properties();
    InputStream input = null;
    Map propDetails = new HashMap();
    try {
      /*if (class$0 == null)
        try {
        
        } catch (ClassNotFoundException classNotFoundException) {
          //throw new NoClassDefFoundError(null.getMessage());
        }  */
      input = (AmwayJavaService.class.getResourceAsStream("com/kony/service/jp/configuration.properties"));
      //getResourceAsStream("com/kony/service/jp/configuration.properties");
      prop.load(input);
      propDetails.put("Android_Min_Version", prop.getProperty("Android_Min_Version"));
      propDetails.put("Android_Max_Version", prop.getProperty("Android_Max_Version"));
      propDetails.put("iOS_Min_Version", prop.getProperty("iOS_Min_Version"));
      propDetails.put("iOS_Max_Version", prop.getProperty("iOS_Max_Version"));
      propDetails.put("appStoreURL", prop.getProperty("appStoreURL"));
      propDetails.put("playStoreURL", prop.getProperty("playStoreURL"));
      propDetails.put("appLanguage", prop.getProperty("AppLanguage"));
      propDetails.put("appLocale", prop.getProperty("AppLocale"));
      propDetails.put("ServiceLocale", prop.getProperty("ServiceLocale"));
      propDetails.put("appRegion", prop.getProperty("AppRegion"));
      propDetails.put("appEnvironment", prop.getProperty("AppEnvironment"));
      propDetails.put("richPushURL", prop.getProperty("RichPushURL"));
      propDetails.put("TealiumAccountName", prop.getProperty("TealiumAccountName"));
      propDetails.put("TealiumProfileName", prop.getProperty("TealiumProfileName"));
      propDetails.put("senderId", prop.getProperty("senderId"));
      propDetails.put("visitorCountryCode", getAllExtractedImcId(prop.getProperty("visitorCountryCode")));
      propDetails.put("visitor_pinnumber", getAllExtractedPinCode(prop.getProperty("visitorPinCode")));
      propDetails.put("uATShareURL", prop.getProperty("uATShareURL"));
      propDetails.put("uATSharePromoURL", prop.getProperty("uATSharePromoURL"));
      propDetails.put("youtubeidURL", prop.getProperty("youtubeidURL"));
      propDetails.put("loginOptions_success_url", prop.getProperty("loginOptions_success_url"));
      propDetails.put("amwayLocationURL", prop.getProperty("amwayLocationURL"));
      propDetails.put("geoLocationUri", prop.getProperty("geoLocationUri"));
      propDetails.put("googleDocsURL", prop.getProperty("googleDocsURL"));
      propDetails.put("turnOffPromo", prop.getProperty("turnOffPromo"));
      propDetails.put("turnOffCalendar", prop.getProperty("turnOffCalendar"));
      propDetails.put("turnOffFeedback", prop.getProperty("turnOffFeedback"));
      propDetails.put("visitorCountry", prop.getProperty("visitorCountry"));
      propDetails.put("loginCallbackUrl", prop.getProperty("loginCallbackUrl"));
      propDetails.put("TealiumDigitalProperty", prop.getProperty("TealiumDigitalProperty"));
      propDetails.put("TealiumAppRegion", prop.getProperty("TealiumAppRegion"));
      propDetails.put("shopOnlineURL", prop.getProperty("shopOnlineURL"));
      propDetails.put("languagesList", prop.getProperty("languagesList"));
      propDetails.put("manageProfileURL", prop.getProperty("manageProfileURL"));
      propDetails.put("renewMembershipURL", prop.getProperty("renewMembershipURL"));
      propDetails.put("graphDisplayPeriod", prop.getProperty("graphDisplayPeriod"));
      propDetails.put("businessTrackingURL", prop.getProperty("businessTrackingURL"));
      propDetails.put("resourceCenterURL", prop.getProperty("resourceCenterURL"));
      propDetails.put("eventsRecognitionURL", prop.getProperty("eventsRecognitionURL"));
      propDetails.put("actionReportURL", prop.getProperty("actionReportURL"));
      propDetails.put("viewFullBusinessDashboardURL", prop.getProperty("viewFullBusinessDashboardURL"));
      propDetails.put("lineOfSponsorshipURL", prop.getProperty("lineOfSponsorshipURL"));
      propDetails.put("displayRegion", prop.getProperty("displayRegion"));
      propDetails.put("maxLimit4PVBV", prop.getProperty("maxLimit4PVBV"));
      propDetails.put("systemMaintenance", prop.getProperty("systemMaintenance"));
      propDetails.put("contactUS", prop.getProperty("contactUS"));
      propDetails.put("shareRegion", prop.getProperty("shareRegion"));
      propDetails.put("maxBonusPercent", prop.getProperty("maxBonusPercent"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    JSONObject json = new JSONObject();
    try {
      json.put("configProps", propDetails);
    } catch (JSONException e) {
      e.printStackTrace();
    } 
    System.out.println(json.toString());
    return json.toString();
  }
  
  private String getExtractedImcId(String key) {
    JSONObject tempProp = new JSONObject();
    try {
      StringTokenizer st = new StringTokenizer(key, "|");
      String str1 = "";
      String str2 = "";
      String str3 = "";
      if (st.hasMoreTokens()) {
        str1 = st.nextToken();
        str2 = st.nextToken();
        str3 = st.nextToken();
      } 
      Map propDetails = new HashMap();
      propDetails.put("affiliateCode", str2);
      propDetails.put("countryCode", str3);
      tempProp.put(str1, propDetails);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    System.out.println(tempProp.toString());
    String finalStr = tempProp.toString();
    finalStr = finalStr.substring(1, finalStr.length() - 1);
    System.out.println("final Str in getExtractedImcId : " + finalStr);
    return finalStr;
  }
  
  private String getAllExtractedImcId(String input) {
    String finalStr = "";
    try {
      StringTokenizer st = new StringTokenizer(input, "~");
      String str1 = "";
      StringBuffer sb = new StringBuffer();
      sb.append("{");
      while (st.hasMoreTokens()) {
        str1 = st.nextToken();
        String formattedStr = getExtractedImcId(str1);
        System.out.println("formattedStr : " + formattedStr);
        sb.append(formattedStr);
        System.out.println("finalStr before , : " + sb.toString());
        sb.append(",");
      } 
      finalStr = sb.substring(0, sb.toString().length() - 1);
      finalStr = String.valueOf(finalStr) + "}";
      System.out.println("finalStr : " + finalStr);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return finalStr;
  }
  
  private Map getAllExtractedPinCode(String input) {
    Map finalStr = new HashMap();
    try {
      StringTokenizer st = new StringTokenizer(input, "~");
      String str1 = "";
      while (st.hasMoreTokens()) {
        str1 = st.nextToken();
        StringTokenizer str = new StringTokenizer(str1, "|");
        String s1 = "";
        String s2 = "";
        if (str.hasMoreTokens()) {
          s1 = str.nextToken();
          s2 = str.nextToken();
        } 
        finalStr.put(s1, s2);
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return finalStr;
  }
  
  public static void main(String[] args) {
    AmwayJavaService as = new AmwayJavaService();
    as.loadProperties();
  }
}

