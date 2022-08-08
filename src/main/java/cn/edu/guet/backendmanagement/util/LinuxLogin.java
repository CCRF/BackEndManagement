package cn.edu.guet.backendmanagement.util;

import java.io.File;
import java.io.IOException;



import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author yj
 * @Date    2022/8/8 20:10
 * @version: 1.3
 */
@Component
public class LinuxLogin {


    /**
     * 上传文件
     * multipartfile为文件
     * toPath为上传的路径
     */
    public String uploadVideo(MultipartFile file,String filePath) {
        String originalFilename = file.getOriginalFilename();
        String fileName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
        System.out.println("文件名字为："+fileName);
        String type = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);//png、jpg
        System.out.println("type = " + type);

        //存放目录
        File upload = new File(filePath);
        if (!upload.exists()){
            upload.mkdirs();
        }

        String uuid = "123456";
        String saveUrl = filePath+fileName+uuid+"."+type;
        System.out.println("保存的路径" + saveUrl);

        File uploadFile = new File(saveUrl);

        try {
            file.transferTo(uploadFile);
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return saveUrl;
    }

    /**
     *
     * @param path 存放图片的路径，通过路径获取返回列表
     * @return
     * 查找文件夹的图片列表
     */
    public String[] FindImageList(String path) {

        File file = new File(path);
        File[] arrays = file.listFiles();
        String[] fileLists = new String[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].isFile()){
                String name = arrays[i].getName();
                String NewName = path+name;
                System.out.println(NewName);
                fileLists[i] = NewName;
            }else if (arrays[i].isDirectory()){
                FindImageList(arrays[i].getPath());//递归判断是否还有文件夹
            }
        }
        System.out.println("----------------------------------------");
        return fileLists;
    }
}
