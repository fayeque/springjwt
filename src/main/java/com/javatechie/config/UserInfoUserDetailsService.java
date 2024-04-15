package com.javatechie.config;

import com.javatechie.entity.ShopkeeperInfo;
import com.javatechie.entity.UserInfo;
import com.javatechie.repository.ShopkeeperInfoRepository;
import com.javatechie.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userRepository;
    @Autowired
    private ShopkeeperInfoRepository shopkeeperRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	int index=username.indexOf("/");
    	String group = username.substring(index+1);
    	String username2 = username.substring(0,index);
    	Optional<UserInfo> userInfo;
    	Optional<ShopkeeperInfo> shopkeeperInfo;
    	System.out.println("username2 is " + username2);
    	System.out.println("outer group is " + group);
    	if(group.equals("Shopkeeper")) {
    		System.out.println("group is " + group);
    		shopkeeperInfo = Optional.ofNullable(shopkeeperRepository.findByEmail(username2));
            return shopkeeperInfo.map(ShopkeeperInfoShopkeeperDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + username2));
    	}else {
    	     userInfo = Optional.ofNullable(userRepository.findByEmail(username2));
    	        return userInfo.map(UserInfoUserDetails::new)
    	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username2));
    	}
        
    }
}
