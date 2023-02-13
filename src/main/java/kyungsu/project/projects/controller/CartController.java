package kyungsu.project.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kyungsu.project.projects.dto.CartCountDto;
import kyungsu.project.projects.dto.CartDto;
import kyungsu.project.projects.dto.CartPayDto;
import kyungsu.project.projects.dto.CartPayResponseDto;
import kyungsu.project.projects.dto.CartResponseDto;
import kyungsu.project.projects.dto.CategoryResponseDto;
import kyungsu.project.projects.entity.CartPayEntity;
import kyungsu.project.projects.service.CartService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired CartService cartService;
	
	@PostMapping("/up")
	public void cartUp(@RequestBody CartDto cartDto) {
		System.out.println(cartDto);
		cartService.cartUP(cartDto);
	}
	@GetMapping("/down/{id}")
	public CategoryResponseDto<List<CartResponseDto>> cartDown(@PathVariable("id") String id) {
		return cartService.cartDown(id);
	}
	@PostMapping("/countUp")
	public void cartCountUp(@RequestBody CartCountDto cartCountDto) {
		cartService.cartCountUP(cartCountDto);
	}
	
	@PostMapping("/countDown")
	public void cartCountDown(@RequestBody CartCountDto countDto) {
		cartService.cartCountDown(countDto);
	}
	@PostMapping("/deleteitem")
	public void cartDelete(@RequestBody CartCountDto countDto ) {
		cartService.cartDelete(countDto);
	}
	@GetMapping("/cartCount/{id}")
	public int cartCount(@PathVariable("id") String id) {
		return cartService.cartCount(id);
		
	}
	@PostMapping("/payCheck")
	public void payCheck(@RequestBody CartPayDto cartPayDto ) {
		System.out.println(cartPayDto);
		cartService.cartPay(cartPayDto);
	}
	@GetMapping("/cartListDelete/{id}")
	public void cartListDelete(@PathVariable("id") String id) {
		cartService.cartListDelete(id);
	}
	
	@GetMapping("/payList/{id}")
	public List<CartPayResponseDto> payList(@PathVariable("id") String id) {	
		return cartService.payList(id);
	}
	
}
