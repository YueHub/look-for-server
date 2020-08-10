package cn.lcy.lookfor.vo;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {


    private MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
