package edu.poly.shop.common;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
public static Map<PageType,PageInfo> pageRoute = new HashMap<PageType,PageInfo>();
static {
	pageRoute.put(PageType.PRODUCT_MANAGEMENT_PAGE, new PageInfo("Product Management","/WEB-INF/Views/admin/products/list.jsp",null));
	pageRoute.put(PageType.CATEGORY_MANAGEMENT_PAGE, new PageInfo("Category Management","/WEB-INF/Views/admin/categories/list.jsp",null));
	pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Report Management","/Views/admin/reports/report",null));
	pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home","/WEB-INF/Views/site/productitem.jsp",null));
	pageRoute.put(PageType.SITE_SHOPPINGCART_PAGE, new PageInfo("Shopping Cart","/WEB-INF/Views/site/shoppingCart.jsp",null));
	
}
private String title;
private String contentUrl;
private String scriptUrl;
}
