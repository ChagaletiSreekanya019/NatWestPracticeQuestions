package org.uplift.libraryproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.uplift.libraryproject.exception.HolidayApiException;
import org.uplift.libraryproject.exception.InvalidHolidayApiInputException;
import org.uplift.libraryproject.exception.LibraryClosedException;
import org.uplift.libraryproject.exception.MobileNumberIsNotValidException;
import org.uplift.libraryproject.model.Book;
import org.uplift.libraryproject.model.HolidayApiResponse;
import org.uplift.libraryproject.model.UserApiResponce;
import org.uplift.libraryproject.repositry.LibraryRepositry;

import java.time.LocalDate;
@Service
public class LibraryService {
    @Autowired
    private LibraryRepositry lr;
    @Value("${check.holidays}")
    private boolean checkHolidays;
    @Autowired
    private HolidayService hs;
    @Autowired
    private UserService us;
    private Book book;
    public Book findById(String id){
        return null;
//        return new Book("1","title1","author1","genere1", LocalDate.of(2011,12,2));


    }

    public Book borrow(String id,String phoneNum) {
        System.out.println("checkHolidays"+checkHolidays);
        if(checkHolidays){
            HolidayApiResponse result=hs.getHolidayApiServise(LocalDate.of(2022,1,26));
            if(result.getStatus()== HttpStatus.OK.value()){
                if(result.getHolidays().length>0) {
                    throw new LibraryClosedException("Sorry,Library is closed");
                }else{
                    System.out.println("Phonenum");
                    boolean result1=checkPhoneNumber(phoneNum);
                    if(!result1){
                        throw new MobileNumberIsNotValidException("please provide correct Mobilenum");
                    }else return lr.borrowBook(id);

                }

            }else{
                if(result.getStatus()== HttpStatus.BAD_REQUEST.value()) {
                    throw new InvalidHolidayApiInputException(result.getError());
                }
                System.out.println("error while connecting to holidays service"+result);
                throw new HolidayApiException("sorry,There is an internal error request to connect after some time");
            }

        }else{
            return lr.borrowBook(id);
        }


    }


    public boolean checkPhoneNumber(String phoneNum){
        UserApiResponce result=us.getuserDetailApiService(phoneNum);
        return result.getStatus()==HttpStatus.OK.value();
    }
}
