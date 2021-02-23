package org.example.core.comon.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.example.core.comon.constant.CoreConstant;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

public class uploadUtil {
    private final int maxMemorySize = 1024 * 1024 * 3;
    private final int maxRequestSize = 1024 * 1024 * 50;

    public Object[] writeorUpload(HttpServletRequest request, Set<String> titlevalue, String path) throws FileUploadException, Exception {
        ServletContext context = request.getServletContext();
        String address = "/"+ CoreConstant.FOLDER_UPLOAD;
        checkAndCreateFolder(address, path); /*tạo ford*/
        String fileLoacaltion = null;
            String name = null;
        boolean check = true;
        Map<String, String> mapReturnvalue = new HashMap<String, String>();
        List<String>strings = new ArrayList<String>();
        boolean isMutipart = ServletFileUpload.isMultipartContent(request);/* kiểm ra có tồn tại file*/
        if (!isMutipart) {
            System.out.println("have not enc");
            check = false;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();


        // Set factory constraints
        factory.setSizeThreshold(maxMemorySize);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            /*khởi tạo xử lý tệp*/
        ServletFileUpload upload = new ServletFileUpload(factory);

         /*   ràng buộc kích thước*/
        upload.setSizeMax(maxRequestSize);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (!item.isFormField()) {
                String filename = item.getName();
                if (StringUtils.isNotBlank(filename)) {
                    File Uploadfile = new File(address +File.separator + path + File.separator + filename);
                    fileLoacaltion = Uploadfile.toString();
                    name = path +File.separator+ filename;
                    strings.add(name);
                    boolean isExit = Uploadfile.exists();
                    if (isExit) { /*kiem tra ton tai cua file */
                        if (Uploadfile.delete()) {
                            item.write(Uploadfile);
                        } else {
                            check = false;
                        }
                    } else {
                        item.write(Uploadfile);
                    }
                }
            } else {

                if (titlevalue != null) {
                    String nameField = item.getFieldName();
                    String valueField = item.getString("UTF-8");
                    if (titlevalue.contains(nameField)) {
                        mapReturnvalue.put(nameField, valueField);
                    }
                }
            }

        }

        return new Object[]{check, fileLoacaltion, strings, mapReturnvalue};
    }
    public Object[] writeorUpload1(HttpServletRequest request, Set<String> titlevalue, String path) throws FileUploadException, Exception {
            String address = "/"+ CoreConstant.FOLDER_UPLOAD;
        ServletContext context = request.getServletContext();
        checkAndCreateFolder(address, path);
        String fileLoacaltion = null;
        String name = null;
        boolean check = true;
        Map<String, String> mapReturnvalue = new HashMap<String, String>();
        boolean isMutipart = ServletFileUpload.isMultipartContent(request);
        if (!isMutipart) {
            System.out.println("have not enc");
            check = false;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();


        // Set factory constraints
        factory.setSizeThreshold(maxMemorySize);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(maxRequestSize);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (!item.isFormField()) {
                String filename = item.getName();
                if (StringUtils.isNotBlank(filename)) {
                    File Uploadfile = new File(address +File.separator + path + File.separator + filename);
                    fileLoacaltion = Uploadfile.toString();
                    name = filename;
                    boolean isExit = Uploadfile.exists();
                    if (isExit) {
                        if (Uploadfile.delete()) {
                            item.write(Uploadfile);
                        } else {
                            check = false;
                        }
                    } else {
                        item.write(Uploadfile);
                    }
                }
            } else {

                if (titlevalue != null) {
                    String nameField = item.getFieldName();
                    String valueField = item.getString("UTF-8");
                    if (titlevalue.contains(nameField)) {
                        mapReturnvalue.put(nameField, valueField);
                    }
                }
            }

        }

        return new Object[]{check, fileLoacaltion, name, mapReturnvalue};
    }
    private void checkAndCreateFolder(String address, String path) {
        File folderRoot = new File(address);
        if (!folderRoot.exists()) {
            folderRoot.mkdirs();
        }
        File folderChild = new File(address + File.separator + path);
        if (!folderChild.exists()) {
            folderChild.mkdirs();
        }
    }
}
