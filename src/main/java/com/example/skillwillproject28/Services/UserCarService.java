package com.example.skillwillproject28.Services;

import com.example.skillwillproject28.ExceptionHandling.GeneralException;
import com.example.skillwillproject28.Models.CarModel;
import com.example.skillwillproject28.Models.UserCarModel;
import com.example.skillwillproject28.Models.UserModel;
import com.example.skillwillproject28.Repositories.CarRepository;
import com.example.skillwillproject28.Repositories.UserCarRepository;
import com.example.skillwillproject28.Repositories.UserRepository;
import com.example.skillwillproject28.Response.UserCarCartsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserCarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    UserCarRepository ucrepo;

    @Autowired
    UserRepository userRepo;

    public UserCarCartsResponse addCarInCart(String id)
    {
        Optional<CarModel> carModel = carRepository.findById(UUID.fromString(id));
        if(!carModel.isPresent())
        {
            throw  new GeneralException("car not found");
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if(username == null)
        {
            throw new GeneralException("user not found");
        }
        UserModel usermodel = userRepo.findUserByUsername(username);
        if(usermodel == null)
        {
            throw  new GeneralException("user not found");
        }
        UserCarModel ucModel = new UserCarModel();
        ucModel.setCarModel(carModel.get());
        ucModel.setUserModel(usermodel);
        ucrepo.save(ucModel);
        UserCarCartsResponse uccr = new UserCarCartsResponse(ucModel.getUserModel().getUserName()
                ,ucModel.getCarModel().getCarBrand(),ucModel.getCarModel().getCarModel(),ucModel.getCarModel().getYear());
        return uccr;
    }


    public List<UserCarCartsResponse> showMyCart()
    {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel usermodel = userRepo.findUserByUsername(username);
        if(usermodel == null)
        {
            throw new GeneralException("user not found");
        }

        List<UserCarModel> ummodel = ucrepo.findByUserId(usermodel.getId());
        if(ummodel == null) {
            throw new GeneralException("something error we have");
        }
        List<UserCarCartsResponse> response
                = ummodel.stream().map(c -> new UserCarCartsResponse(c.getUserModel().getUserName(),c.getCarModel().getCarBrand()
                ,c.getCarModel().getCarModel(),c.getCarModel().getYear())).toList();
        return response;

    }

}
