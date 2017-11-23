package com.model2.mvc.web.purchase;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserService;

@Controller
public class PurchaseController {

	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	public PurchaseController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	// @Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;

	@Value("#{commonProperties['pageSize']}")
	// @Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	@RequestMapping("addPurchaseView.do")
	public String addPurchaseView(@RequestParam("prodNo") int prodNo,
								Model model) throws Exception {
		
		Product product = productService.getProduct(prodNo);
		model.addAttribute("product", product);
		
		return "forward:/purchase/addPurchaseView.jsp";
	}
	
	@RequestMapping("addPurchase.do")
	public String addPurchase(@RequestParam("prodNo") int prodNo,
							@RequestParam("buyerId") String buyerId,
							@RequestParam("purchaseAmount") int purchaseAmount,
							@ModelAttribute("purchase") Purchase purchase,
							Model model) throws Exception {
		
		User buyer = userService.getUser(buyerId);
		Product product = productService.getProduct(prodNo);
		
		purchase.setBuyer(buyer);
		purchase.setPurchaseProd(product);
		
		purchaseService.addPurchase(purchase);
		
		model.addAttribute("purchase", purchase);
		
		return "forward:/purchase/addPurchase.jsp?purchaseAmount="+purchaseAmount;
	}
	
	@RequestMapping("getPurchase.do")
	public String getPurchase() throws Exception {
		
		return null;
	}
	
	@RequestMapping("updatePurchaseView.do")
	public String updatePurchaseView() throws Exception {
		
		return null;
	}
	
	@RequestMapping("updatePurchase.do")
	public String updatePurchase() throws Exception {
		
		return null;
	}
	
	@RequestMapping("listPurchase.do")
	public String listPurchase(HttpSession session,
							Search search)throws Exception {
		
		String buyerId = ((User)session.getAttribute("user")).getUserId();
		
		return null;
	}
	
	@RequestMapping("listSale.do")
	public String listSale() throws Exception {
		
		return null;
	}
	
	@RequestMapping("updateTranCode.do")
	public String updateTranCode() throws Exception {
		
		return null;
	}
	
	@RequestMapping("updateTranCodeByProd.do")
	public String updateTranCodeByProd() throws Exception {
		
		return null;
	}

}
