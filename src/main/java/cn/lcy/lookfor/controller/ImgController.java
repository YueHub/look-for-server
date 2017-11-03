package cn.lcy.lookfor.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.lcy.lookfor.config.Config;

@RestController
public class ImgController {

	private String imagePath;

	@RequestMapping(value = "/image/{year}/{month}/{day}/{name:.*}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage(@PathVariable("year") String year,
			@PathVariable("month") String month, @PathVariable("day") String day, @PathVariable("name") String name)
			throws IOException {

		imagePath = Config.imgUrl + year + File.separator + month + File.separator + day
				+ File.separator + name;
		InputStream inputImage = new FileInputStream(imagePath);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[512];
        int l = inputImage.read(buffer);
        while(l >= 0) {
            outputStream.write(buffer, 0, l);
            l = inputImage.read(buffer);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "image/png");
        return new ResponseEntity<byte[]>(outputStream.toByteArray(), headers, HttpStatus.OK);  
	}
}
