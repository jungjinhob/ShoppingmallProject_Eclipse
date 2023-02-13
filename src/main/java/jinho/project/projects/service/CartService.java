package jinho.project.projects.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jinho.project.projects.dto.CartCountDto;
import jinho.project.projects.dto.CartDto;
import jinho.project.projects.dto.CartPayDto;
import jinho.project.projects.dto.CartPayResponseDto;
import jinho.project.projects.dto.CartResponseDto;
import jinho.project.projects.dto.CategoryResponseDto;
import jinho.project.projects.entity.CartEntity;
import jinho.project.projects.entity.CartPayEntity;
import jinho.project.projects.repository.CartPayRepository;
import jinho.project.projects.repository.CartRepository;

@Service
public class CartService {
	@Autowired CartRepository cartRepository;
	@Autowired CartPayRepository cartPayRepository;
	
	public void cartUP(CartDto cartDto) {
		CartEntity cartEntity = null;
		String image = cartDto.getImage();
		String image2 = image.substring(image.lastIndexOf("/") + 1);
		try {
			cartEntity = cartRepository.findByProductNameAndId(cartDto.getProductName(), cartDto.getId()).get(0);
		} catch (Exception e) {
			cartEntity = new CartEntity(cartDto);
			cartEntity.setImage(image2);
			cartRepository.save(cartEntity);
		}
		cartEntity.setCount(cartDto.getCount2());
		cartEntity.setImage(image2);
		cartRepository.save(cartEntity);
	}
	public CategoryResponseDto<List<CartResponseDto>> cartDown(String id) {
		List<CartEntity> carts = cartRepository.cartList(id);
		System.out.println(carts);
		List<CartResponseDto> cartDtos = new ArrayList<CartResponseDto>();
		for (CartEntity cart : carts) {
			cartDtos.add(new CartResponseDto(cart));
		}
		return CategoryResponseDto.setSuccess("d", cartDtos);
		
	}
	public void cartCountUP(CartCountDto cartCountDto) {
		CartEntity cartEntity =null;
		try {
			cartEntity = cartRepository.findByProductNameAndId(cartCountDto.getProductName(), cartCountDto.getId()).get(0);
			System.out.println(cartEntity);
		} catch (Exception e) {
		}
		cartEntity.setCount(cartEntity.getCount() + 1);
		cartRepository.save(cartEntity);
		
	}
	public void cartCountDown (CartCountDto cartCountDto) {
		CartEntity countDown = cartRepository.findByProductNameAndId(cartCountDto.getProductName(), cartCountDto.getId()).get(0);	
		try {
			if (countDown.getCount() > 1) {
				countDown.setCount(countDown.getCount() - 1);
				}	
		} catch (Exception e) {
			
		}	
		
		cartRepository.save(countDown);
	}
	public void cartDelete(CartCountDto countDto) {
		
		CartEntity cartEntity = cartRepository.findByProductNameAndId(countDto.getProductName(), countDto.getId()).get(0);
		cartRepository.deleteById(cartEntity.getNum());
	}
	public int cartCount(String id) {
		List<CartEntity> cartList = cartRepository.cartList(id);
		int count = cartList.size();
		System.out.println(count);
		return count;
	}
	public void cartPay(CartPayDto cartPayDto) {
		System.out.println("hh");
		CartPayEntity cartPayEntity = null;
		List<CartPayEntity> cartPayList = new ArrayList<CartPayEntity>();
		
		for(int i =0 ; i < cartPayDto.getVariables().size(); i++) {
			cartPayEntity = new CartPayEntity(cartPayDto.getVariables().get(i), cartPayDto.getAddress());
			cartPayRepository.save(cartPayEntity);
			System.out.println(cartPayEntity);
			cartPayList.add(cartPayEntity);
		}
	}
	public void cartListDelete(String id) {
		List<CartEntity> cartEntity = cartRepository.cartList(id);
		cartRepository.deleteAll(cartEntity);
	}
	
	public List<CartPayResponseDto> payList(String id) {
		List<CartPayEntity> cartPayEntity = cartPayRepository.cartList(id);
		List<CartPayResponseDto> cartPayList = new ArrayList<CartPayResponseDto>();
		for(CartPayEntity carts : cartPayEntity) {
			cartPayList.add(new CartPayResponseDto(carts));
		}
		return cartPayList;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

