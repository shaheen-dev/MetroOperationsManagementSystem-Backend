package com.app.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

//source- https://www.callicoder.com/generate-qr-code-in-java-using-zxing/

public class QRCodeGenerator {

	// private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

	/*
	 * In the following program, I’ve written a method called generateQRCodeImage
	 * which takes the text to be encoded, the width and height of the QR Code, and
	 * the file system’s path where QR Code will be saved.
	 * 
	 * The function generates and saves the QR Code in the specified path.
	 */

	public static void generateQRCodeImage(String text, int width, int height, String filePath)
			throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

	/*
	 * This method takes the text to be encoded, the width and height of the QR
	 * Code, and returns the QR Code in the form of a byte array.
	 */
	public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();
		
		for (byte b : pngData) {
			System.out.print(b+",");
		}
		
		return pngData;
		
		//https://stackoverflow.com/questions/58013079/how-to-fetch-byte-array-image-from-api-in-react
	}

}
