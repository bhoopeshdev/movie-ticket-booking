package com.company;

import com.company.controller.*;
import com.company.entity.*;
import com.company.enums.MovieGenre;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        MovieController movieController = new MovieController();

        Movie movie1 = movieController.createMovie("SHOLAY", MovieGenre.ACTION);
        System.out.println("created movie : " + movie1.getMovieId());
        Movie movie2 = movieController.createMovie("ABNS", MovieGenre.ACTION);
        System.out.println("created movie : " + movie2.getMovieId());
        Movie movie3 = movieController.createMovie("SWD", MovieGenre.ACTION);
        System.out.println("created movie : " + movie3.getMovieId());
        Movie movie4 = movieController.createMovie("DED", MovieGenre.ACTION);
        System.out.println("created movie : " + movie4.getMovieId());
        Movie movie5 = movieController.createMovie("WWDD", MovieGenre.ACTION);
        System.out.println("created movie : " + movie5.getMovieId());
        Movie movie6 = movieController.createMovie("FEW", MovieGenre.ACTION);
        System.out.println("created movie : " + movie6.getMovieId());

        TheatreController theatreController = new TheatreController();
        Theatre theatre1 = theatreController.createTheatre("THEATRE1", "Bilaspur", "chantideeh");
        Screen screen = theatreController.addScreen(theatre1.getTheatreId(), 100);

        ShowController showController = new ShowController();
        Show show1 =
                showController.createShow(
                        movie1.getMovieId(),
                        theatre1.getTheatreId(),
                        screen.getScreenId(),
                        LocalDateTime.now(),
                        LocalDateTime.now());
        System.out.println(
                "show created : "
                        + show1.getShowId()
                        + " "
                        + show1.getMovieId()
                        + " "
                        + show1.getScreenId());

        List<Seat> availableSeats = showController.getAvailableSeats(show1.getShowId());
        System.out.println("available seats count " + availableSeats.size());
        List<Long> seatReqList =
                availableSeats.subList(0, 3).stream().map(Seat::getSeatId).collect(Collectors.toList());

        BookingController bookingController = new BookingController();
        Booking initiatedBooking =
                bookingController.initiateBooking(show1.getShowId(), seatReqList, 12345L);
        System.out.println(
                "booking initiated for booking id : "
                        + initiatedBooking.getBookingId()
                        + " with booking status "
                        + initiatedBooking.getBookingStatus());

        PaymentController paymentController = new PaymentController();
        Payment payment =
                paymentController.createPayment(
                        initiatedBooking.getBookingId(), 100L, initiatedBooking.getUserId());
        System.out.println("completed payment with status " + payment.getPaymentStatus());

        Booking completedBooking = bookingController.completeBooking(initiatedBooking.getBookingId(), payment);
        System.out.println("completed booking with status " + completedBooking.getBookingStatus());
    }
}