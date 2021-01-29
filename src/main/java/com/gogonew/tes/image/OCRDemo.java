package com.gogonew.tes.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;

/**
 * java图像识别
 * likang
 * 2018-7-13
 */
public class OCRDemo {

    public static void main(String[] args) throws TesseractException, IOException {
        File file = new File("/Users/liutong/IdeaProjects/shardings-jdbc/src/main/resources/static/img_13.png");
        testDoOCR_ImageByte(FileUtils.readFileToByteArray(file));
    }

    public static void testDoOCR_ImageByte(byte[] imageByte) {
        try {
            InputStream sbs = new ByteArrayInputStream(imageByte);
            BufferedImage img = ImageIO.read(sbs);
            ITesseract instance = new Tesseract();
            //设置语言库所在的文件夹位置，最好是绝对的，不然加载不到就直接报错了
            instance.setDatapath("/Users/liutong/IdeaProjects/shardings-jdbc/src/main/resources/font");
            //设置使用的语言库类型：chi_sim 中文简体
            instance.setLanguage("chi_sim");
            String result = instance.doOCR(img);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("扫描图片文本错误:{}");
        }
    }
}
