package com.example.jpa.jpa_one_to_one_demo;

import com.example.jpa.jpa_one_to_one_demo.model.Gender;
import com.example.jpa.jpa_one_to_one_demo.model.User;
import com.example.jpa.jpa_one_to_one_demo.model.UserProfile;
import com.example.jpa.jpa_one_to_one_demo.repository.UserProfileRepository;
import com.example.jpa.jpa_one_to_one_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class JpaOneToOneDemoApplication implements CommandLineRunner
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    public static void main( String[] args )
    {
        SpringApplication.run( JpaOneToOneDemoApplication.class, args );
    }

    @Override
    public void run( String... args ) throws Exception
    {
        userProfileRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();

        User user = new User( "Kinath", "Rupasinghe", "kinath@codegen.net", "mysecretepwd" );
        UserProfile userProfile = new UserProfile();
        userProfile.setPhoneNumber( "+715735385" );
        userProfile.setAddress1( "address1" );
        userProfile.setAddress2( "address2" );
        userProfile.setCity( "Colombo" );
        userProfile.setState( "Western" );
        userProfile.setCountry( "Sri Lanka" );
        userProfile.setZipCode( "10200" );
        userProfile.setGender( Gender.MALE );

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1989, 06, 05);
        userProfile.setDateOfBirth( dateOfBirth.getTime() );

        user.setUserProfile( userProfile );
        userProfile.setUser( user );

        userRepository.save( user );
    }
}
