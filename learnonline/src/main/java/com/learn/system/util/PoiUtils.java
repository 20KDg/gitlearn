//package com.learn.system.util;
//
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//
//import java.io.*;
//
///**
// * POI相关操作
// *
// */
//public class PoiUtils {
//
//    /**
//     * 生成Excel文件
//     * @param workbook
//     * @param fileName
//     * @return
//     */
//    public static File createExcelFile(Workbook workbook, String fileName) {
//        OutputStream stream = null;
//        File file = null;
//        try {
//            file = File.createTempFile(fileName, ".xlsx");
//            stream = new FileOutputStream(file.getAbsoluteFile());
//            workbook.write(stream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.closeQuietly(workbook);
//            IOUtils.closeQuietly(stream);
//        }
//        return file;
//    }
//}