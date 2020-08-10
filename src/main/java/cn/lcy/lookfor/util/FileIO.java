package cn.lcy.lookfor.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileIO {

    private static InputStream is;

    public static void saveImg(MultipartFile multipartFile, String saveDir, String fileName) throws IOException {
        byte[] bs = new byte[1024];    // 1K 数据缓冲
        int len;    // 读取到的数据长度

        is = multipartFile.getInputStream();

        File fileDir = new File(saveDir);    // 输出文件夹
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        OutputStream os = new FileOutputStream(fileDir.getPath() + File.separator + fileName);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭链接
        os.close();
    }

    public static void saveImg(File file, String saveDir, String fileName) throws IOException {
        byte[] bs = new byte[1024];    // 1K 数据缓冲
        int len;    // 读取到的数据长度

        is = new FileInputStream(file);

        File fileDir = new File(saveDir);    // 输出文件夹
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        OutputStream os = new FileOutputStream(fileDir.getPath() + File.separator + fileName);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭链接
        os.close();
    }

}
