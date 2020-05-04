package com.springapp.helpers;

public class FilesHelper {
    public static String getStringWithoutColonSign(String certificateName) {
        String certificateNameWithoutSpaces = certificateName.replaceAll(":","");
        return certificateNameWithoutSpaces;
    }

    public static String getYearFromCertificationDate(String certificationDate) {
        return certificationDate.substring(0, 4);
    }
}
