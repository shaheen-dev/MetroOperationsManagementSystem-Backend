package com.app.controller;

import static com.app.service.QRCodeGenerator.generateQRCodeImage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.dto.TicketRequest;
import com.app.dto.TicketResponse;
import com.app.service.IBookingService;
import com.app.service.PaymentService;
import com.app.service.SendMail;
import com.google.zxing.WriterException;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/user/book_ticket")
public class BookingController {
	private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

	@Autowired
	private IBookingService bookService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private SendMail mail;

	// Method to book ticket
	@PostMapping("/journey_planner")
	public ResponseEntity<?> bookTicket(@RequestBody TicketRequest trequest) {

		if (trequest.getDestinationId() > 0 && trequest.getSourceId() > 0) {
			TicketResponse response = bookService.bookTicket(trequest);

			try { // QR Code generator for booked ticket
				generateQRCodeImage(response.toString(), 350, 350, QR_CODE_IMAGE_PATH);
			} catch (WriterException e) {
				System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
			} catch (IOException e) {
				System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
			}

			return ResponseEntity.ok(response);
		} else {
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse("Invalid Source or destination!", LocalDateTime.now()), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> order(@RequestBody Map<String, Object> data) {
		
		if (Integer.parseInt(data.get("amount").toString()) > 0) {
			System.out.println(paymentService.payment(data).toString());
			return ResponseEntity.ok(paymentService.payment(data).toString());
		} else {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("Invalid amount!", LocalDateTime.now()),
					HttpStatus.BAD_REQUEST);
		}
	}

}
