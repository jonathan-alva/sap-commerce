package org.training.storefront.controllers.pages;

import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
//import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.training.core.service.TrainingProductService;
import org.training.facades.product.impl.DefaultTrainingProductFacade;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductRecommendationPageController extends ProductPageController {
    private static final String PRODUCT_RECOMMENDATION_PAGE = "product-recommendation";

//    @Resource(name = "defaultTrainingProductService")
//    private TrainingProductService productService;


//    @Resource(name = "productVariantFacade")
//    private ProductFacade productFacade;

    @Resource(name = "trainingProductFacade")
    private DefaultTrainingProductFacade productFacade;

    @RequestMapping(value = PRODUCT_RECOMMENDATION_PAGE, method = RequestMethod.GET)
    public String getPriceEngine(final Model model) throws CMSItemNotFoundException {
//        final List<ProductOption> extraOptions = Arrays.asList(ProductOption.VARIANT_MATRIX_BASE, ProductOption.VARIANT_MATRIX_URL,
//                ProductOption.VARIANT_MATRIX_MEDIA);

        final ContentPageModel contentPageModel = getContentPageForLabelOrId(PRODUCT_RECOMMENDATION_PAGE);
        storeCmsPageInModel(model, contentPageModel);
        setUpMetaDataForContentPage(model, contentPageModel);

//        List<ProductModel> productModelList = productService.getAllProductModels();
//        List<ProductData> productDataList = new ArrayList<>();
//        for (ProductModel productModel : productModelList)
//        {
//            String productCode = productModel.getCode();
//
//            final List<ProductOption> options = new ArrayList<>(Arrays.asList(ProductOption.VARIANT_FIRST_VARIANT, ProductOption.BASIC,
//                    ProductOption.URL, ProductOption.PRICE, ProductOption.SUMMARY, ProductOption.DESCRIPTION, ProductOption.GALLERY,
//                    ProductOption.CATEGORIES, ProductOption.REVIEW, ProductOption.PROMOTIONS, ProductOption.CLASSIFICATION,
//                    ProductOption.VARIANT_FULL, ProductOption.STOCK, ProductOption.VOLUME_PRICES, ProductOption.PRICE_RANGE,
//                    ProductOption.DELIVERY_MODE_AVAILABILITY, ProductOption.PRODUCT_SKU));
//
//            options.addAll(extraOptions);
//
//            final ProductData productData = productFacade.getProductForCodeAndOptions(productCode, options);
//            productDataList.add(productData);
//        }

        List<ProductData> productDataList = productFacade.getAllProductsData();

        model.addAttribute("productList", productDataList);

        return getViewForPage(model);
    }
}
